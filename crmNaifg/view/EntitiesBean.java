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

import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import co.simasoft.models.*;
import org.hibernate.search.annotations.Resolution;
import org.hibernate.search.annotations.DateBridge;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Named
@Stateful
@ConversationScoped
public class EntitiesBean implements Serializable {

        private static final long serialVersionUID = 1L;

        /*
         * Support creating and retrieving Entities entities
         */

        private Long id;

        public Long getId() {
                return this.id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        private Entities entities;

        public Entities getEntities() {
                return this.entities;
        }

        public void setEntities(Entities entities) {
                this.entities = entities;
        }

        @Inject
        private Conversation conversation;

        @PersistenceContext(unitName = "crmNaifgPU-JTA", type = PersistenceContextType.EXTENDED)
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
                        this.entities = this.example;
                } else {
                        this.entities = findById(getId());
                }
        }

        public Entities findById(Long id) {

                return this.entityManager.find(Entities.class, id);
        }

        /*
         * Support updating and deleting Entities entities
         */

        public String update() {
                this.conversation.end();

                try {
                        if (this.id == null) {
                                this.entityManager.persist(this.entities);
                                return "search?faces-redirect=true";
                        } else {
                                this.entityManager.merge(this.entities);
                                return "view?faces-redirect=true&id=" + this.entities.getId();
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
                        Entities deletableEntity = findById(getId());
          Iterator<Relationships> iterFrom = deletableEntity.getFrom().iterator();
          for (; iterFrom.hasNext();){
             Relationships nextInFrom = iterFrom.next();
             nextInFrom.setFrom(null);
             iterFrom.remove();
             this.entityManager.merge(nextInFrom);
          }
                        Iterator<Attributes> iterAttributes = deletableEntity.getAttributes().iterator();
                        for (; iterAttributes.hasNext();){
                               Attributes nextInAttributes = iterAttributes.next();
                                nextInAttributes.setEntities(null);
                               iterAttributes.remove();
                               this.entityManager.merge(nextInAttributes);
                        }
          Iterator<Relationships> iterTo = deletableEntity.getTo().iterator();
          for (; iterTo.hasNext();){
             Relationships nextInTo = iterTo.next();
             nextInTo.setTo(null);
             iterTo.remove();
             this.entityManager.merge(nextInTo);
          }
                        GroupIds groupIds = deletableEntity.getGroupIds();
                        groupIds.getEntities().remove(deletableEntity);
                        deletableEntity.setGroupIds(null);
                        this.entityManager.merge(groupIds);
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
         * Support searching Entities entities with pagination
         */

        private int page;
        private long count;
        private List<Entities> pageItems;

        private Entities example = new Entities();

        public int getPage() {
                return this.page;
        }

        public void setPage(int page) {
                this.page = page;
        }

        public int getPageSize() {
                return 10;
        }

        public Entities getExample() {
                return this.example;
        }

        public void setExample(Entities example) {
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
                Root<Entities> root = countCriteria.from(Entities.class);
                countCriteria = countCriteria.select(builder.count(root)).where(
                                getSearchPredicates(root));
                this.count = this.entityManager.createQuery(countCriteria).getSingleResult();

                // Populate this.pageItems

                CriteriaQuery<Entities> criteria = builder.createQuery(Entities.class);
                root = criteria.from(Entities.class);
                TypedQuery<Entities> query = this.entityManager.createQuery(criteria.select(root).where(getSearchPredicates(root)));
                query.setFirstResult(this.page * getPageSize()).setMaxResults(getPageSize());
                this.pageItems = query.getResultList();
        }

        private Predicate[] getSearchPredicates(Root<Entities> root) {

                CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
                List<Predicate> predicatesList = new ArrayList<Predicate>();

                return predicatesList.toArray(new Predicate[predicatesList.size()]);
        }

        public List<Entities> getPageItems() {
                return this.pageItems;
        }

        public long getCount() {
                return this.count;
        }

        /*
         * Support listing and POSTing back Entities entities (e.g. from inside an HtmlSelectOneMenu)
         */

        public List<Entities> getAll() {
                CriteriaQuery<Entities> criteria = this.entityManager.getCriteriaBuilder().createQuery(Entities.class);
                return this.entityManager.createQuery(criteria.select(criteria.from(Entities.class))).getResultList();
        }

        @Resource
        private SessionContext sessionContext;

        public Converter getConverter() {

                final EntitiesBean ejbProxy = this.sessionContext.getBusinessObject(EntitiesBean.class);

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
                                return String.valueOf(((Entities) value).getId());
                        }

        };
   }

        /*
         * Support adding children to bidirectional, one-to-many tables
         */

        private Entities add = new Entities();

        public Entities getAdd() {
               return this.add;
        }

        public Entities getAdded() {
               Entities added = this.add;
               this.add = new Entities();
               return added;
        }

}
