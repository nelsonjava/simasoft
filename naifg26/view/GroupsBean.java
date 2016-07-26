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

import import co.simasoft.models.*;
import import org.hibernate.search.annotations.Analyze;
import import org.hibernate.search.annotations.DocumentId;
import import org.hibernate.search.annotations.Field;
import import org.hibernate.search.annotations.Index;
import import org.hibernate.search.annotations.Indexed;
import import org.hibernate.search.annotations.Store;
import import javax.persistence.OneToMany;
import import javax.persistence.ManyToOne;
import import javax.persistence.ManyToMany;
import import javax.persistence.Temporal;
import import javax.persistence.TemporalType;
import import org.hibernate.search.annotations.DateBridge;
import import org.hibernate.search.annotations.Resolution;
import java.util.Iterator;

@Named
@Stateful
@ConversationScoped
public class GroupsBean implements Serializable{

        private static final long serialVersionUID = 1L;

        /*
         * Support creating and retrieving Groups entities
         */

        private Long id;

        public Long getId() {
                return this.id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        private Groups groups;

        public Groups getGroups() {
                return this.groups;
        }

        public void setGroups(Groups groups) {
                this.groups = groups;
        }

        @Inject
        private Conversation conversation;

        @PersistenceContext(unitName = "naifg26PU-JTA", type = PersistenceContextType.EXTENDED)
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
                        this.groups = this.example;
                } else {
                        this.groups = findById(getId());
                }
        }

        public Groups findById(Long id) {

                return this.entityManager.find(Groups.class, id);
        }

        /*
         * Support updating and deleting Groups entities
        */

        public String update() {
                this.conversation.end();

                try {
                        if (this.id == null) {
                                this.entityManager.persist(this.groups);
                                return "search?faces-redirect=true";
                        } else {
                                this.entityManager.merge(this.groups);
                                return "view?faces-redirect=true&id=" + this.groups.getId();
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
                        Groups deletableEntity = findById(getId());
                        Iterator<GroupsModels> iterGroupsModels = deletableEntity.getGroupsModels().iterator();
                        for (; iterGroupsModels.hasNext();){
                               GroupsModels nextInGroupsModels = iterGroupsModels.next();
                                nextInGroupsModels.setGroups(null);
                               iterGroupsModels.remove();
                               this.entityManager.merge(nextInGroupsModels);
                        }
                        Iterator<DevelopmentsGroups> iterDevelopmentsGroups = deletableEntity.getDevelopmentsGroups().iterator();
                        for (; iterDevelopmentsGroups.hasNext();){
                               DevelopmentsGroups nextInDevelopmentsGroups = iterDevelopmentsGroups.next();
                                nextInDevelopmentsGroups.setGroups(null);
                               iterDevelopmentsGroups.remove();
                               this.entityManager.merge(nextInDevelopmentsGroups);
                        }
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
         * Support searching Groups entities with pagination
         */

        private int page;
        private long count;
        private List<Groups> pageItems;

        private Groups example = new Groups();

        public int getPage() {
                return this.page;
        }

        public void setPage(int page) {
                this.page = page;
        }

        public int getPageSize() {
                return 10;
        }

        public Groups getExample() {
                return this.example;
        }

        public void setExample(Groups example) {
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
                Root<Groups> root = countCriteria.from(Groups.class);
                countCriteria = countCriteria.select(builder.count(root)).where(
                                getSearchPredicates(root));
                this.count = this.entityManager.createQuery(countCriteria).getSingleResult();

                // Populate this.pageItems

                CriteriaQuery<Groups> criteria = builder.createQuery(Groups.class);
                root = criteria.from(Groups.class);
                TypedQuery<Groups> query = this.entityManager.createQuery(criteria.select(root).where(getSearchPredicates(root)));
                query.setFirstResult(this.page * getPageSize()).setMaxResults(getPageSize());
                this.pageItems = query.getResultList();
        }

        private Predicate[] getSearchPredicates(Root<Groups> root) {

                CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
                List<Predicate> predicatesList = new ArrayList<Predicate>();

                return predicatesList.toArray(new Predicate[predicatesList.size()]);
        }

        public List<Groups> getPageItems() {
                return this.pageItems;
        }

        public long getCount() {
                return this.count;
        }

        /*
         * Support listing and POSTing back Groups entities (e.g. from inside an HtmlSelectOneMenu)
         */

        public List<Groups> getAll() {
                CriteriaQuery<Groups> criteria = this.entityManager.getCriteriaBuilder().createQuery(Groups.class);
                return this.entityManager.createQuery(criteria.select(criteria.from(Groups.class))).getResultList();
        }

        @Resource
        private SessionContext sessionContext;

        public Converter getConverter() {

                final GroupsBean ejbProxy = this.sessionContext.getBusinessObject(GroupsBean.class);

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
                       return String.valueOf(((Groups) value).getId());
                }

        };
   }

        /*
         * Support adding children to bidirectional, one-to-many tables
         */

        private Groups add = new Groups();

        public Groups getAdd() {
               return this.add;
        }

        public Groups getAdded() {
               Groups added = this.add;
               this.add = new Groups();
               return added;
        }

}
