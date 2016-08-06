package co.simasoft.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import import org.hibernate.search.annotations.Analyze;
import import org.hibernate.search.annotations.DocumentId;
import import org.hibernate.search.annotations.Field;
import import org.hibernate.search.annotations.Index;
import import org.hibernate.search.annotations.Indexed;
import import org.hibernate.search.annotations.Store;
import import javax.persistence.OneToMany;
import import javax.persistence.ManyToOne;
import import javax.persistence.ManyToMany;
import import co.simasoft.models.*;
import import org.hibernate.search.annotations.DateBridge;
import import org.hibernate.search.annotations.Resolution;
import import javax.persistence.TemporalType;
import import javax.persistence.Temporal;
import java.util.Iterator;

@Named
@Stateful
@ConversationScoped
public class GroupsModelsBean implements Serializable{

        private static final long serialVersionUID = 1L;

        /*
         * Support creating and retrieving GroupsModels entities
         */

        private Long id;

        public Long getId() {
                return this.id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        private GroupsModels groupsModels;

        public GroupsModels getGroupsModels() {
                return this.groupsModels;
        }

        public void setGroupsModels(GroupsModels groupsModels) {
                this.groupsModels = groupsModels;
        }

        @Inject
        private Conversation conversation;

        @PersistenceContext(unitName = "naifg27PU-JTA", type = PersistenceContextType.EXTENDED)
        private EntityManager entityManager;

        public String create() {

                this.conversation.begin();
                this.conversation.setTimeout(1800000L);
                return "create?faces-redirect=true";
        }

        public void retrieve() {

                if (FacesContext.getCurrentInstance().isPostback()) {
                        return;
                }

                if (this.conversation.isTransient()) {
                        this.conversation.begin();
                        this.conversation.setTimeout(1800000L);
                }

                if (this.id == null) {
                        this.groupsModels = this.example;
                } else {
                        this.groupsModels = findById(getId());
                }
        }

        public GroupsModels findById(Long id) {

                return this.entityManager.find(GroupsModels.class, id);
        }

        /*
         * Support updating and deleting GroupsModels entities
        */

        public String update() {
                this.conversation.end();

                try {
                        if (this.id == null) {
                                this.entityManager.persist(this.groupsModels);
                                return "search?faces-redirect=true";
                        } else {
                                this.entityManager.merge(this.groupsModels);
                                return "view?faces-redirect=true&id=" + this.groupsModels.getId();
                        }
                } catch (Exception e) {
                        FacesContext.getCurrentInstance().addMessage(null,
                                        new FacesMessage(e.getMessage()));
                        return null;
                }
        }

        public String delete() {
                this.conversation.end();

                try {
                        GroupsModels deletableEntity = findById(getId());
                        GroupsModels groupsModels = deletableEntity.getGroupsModels();
                        groupsModels.getGroupsModels().remove(deletableEntity);
                        deletableEntity.setGroupsModels(null);
                        this.entityManager.merge(groupsModels);
                        GroupsModels groupsModels = deletableEntity.getGroupsModels();
                        groupsModels.getGroupsModels().remove(deletableEntity);
                        deletableEntity.setGroupsModels(null);
                        this.entityManager.merge(groupsModels);
                        this.entityManager.remove(deletableEntity);
                        this.entityManager.flush();
                        return "search?faces-redirect=true";
                } catch (Exception e) {
                        FacesContext.getCurrentInstance().addMessage(null,
                                        new FacesMessage(e.getMessage()));
                        return null;
                }
        }

        /*
         * Support searching GroupsModels entities with pagination
         */

        private int page;
        private long count;
        private List<GroupsModels> pageItems;

        private GroupsModels example = new GroupsModels();

        public int getPage() {
                return this.page;
        }

        public void setPage(int page) {
                this.page = page;
        }

        public int getPageSize() {
                return 10;
        }

        public GroupsModels getExample() {
                return this.example;
        }

        public void setExample(GroupsModels example) {
                this.example = example;
        }

        public String search() {
                this.page = 0;
                return null;
        }

        public void paginate() {

                CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();

                // Populate this.count

                CriteriaQuery<Long> countCriteria = builder.createQuery(Long.class);
                Root<GroupsModels> root = countCriteria.from(GroupsModels.class);
                countCriteria = countCriteria.select(builder.count(root)).where(
                                getSearchPredicates(root));
                this.count = this.entityManager.createQuery(countCriteria).getSingleResult();

                // Populate this.pageItems

                CriteriaQuery<GroupsModels> criteria = builder.createQuery(GroupsModels.class);
                root = criteria.from(GroupsModels.class);
                TypedQuery<GroupsModels> query = this.entityManager.createQuery(criteria.select(root).where(getSearchPredicates(root)));
                query.setFirstResult(this.page * getPageSize()).setMaxResults(getPageSize());
                this.pageItems = query.getResultList();
        }

        private Predicate[] getSearchPredicates(Root<GroupsModels> root) {

                CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
                List<Predicate> predicatesList = new ArrayList<Predicate>();

                return predicatesList.toArray(new Predicate[predicatesList.size()]);
        }

        public List<GroupsModels> getPageItems() {
                return this.pageItems;
        }

        public long getCount() {
                return this.count;
        }

        /*
         * Support listing and POSTing back GroupsModels entities (e.g. from inside an HtmlSelectOneMenu)
         */

        public List<GroupsModels> getAll() {
                CriteriaQuery<GroupsModels> criteria = this.entityManager.getCriteriaBuilder().createQuery(GroupsModels.class);
                return this.entityManager.createQuery(criteria.select(criteria.from(GroupsModels.class))).getResultList();
        }

        @Resource
        private SessionContext sessionContext;

        public Converter getConverter() {

                final GroupsModelsBean ejbProxy = this.sessionContext.getBusinessObject(GroupsModelsBean.class);

                return new Converter(){

                @Override
                public Object getAsObject(FacesContext context,UIComponent component, String value){
                       return ejbProxy.findById(Long.valueOf(value));
                }

                @Override
                public String getAsString(FacesContext context,UIComponent component, Object value){
                       if (value == null){
                          return "";
                       }
                       return String.valueOf(((GroupsModels) value).getId());
                }

        };
   }

        /*
         * Support adding children to bidirectional, one-to-many tables
         */

        private GroupsModels add = new GroupsModels();

        public GroupsModels getAdd() {
               return this.add;
        }

        public GroupsModels getAdded() {
               GroupsModels added = this.add;
               this.add = new GroupsModels();
               return added;
        }

}
