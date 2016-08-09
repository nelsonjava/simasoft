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
public class ModelRelationshipsBean implements Serializable {

        private static final long serialVersionUID = 1L;

        /*
         * Support creating and retrieving ModelRelationships entities
         */

        private Long id;

        public Long getId() {
                return this.id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        private ModelRelationships modelRelationships;

        public ModelRelationships getModelRelationships() {
                return this.modelRelationships;
        }

        public void setModelRelationships(ModelRelationships modelRelationships) {
                this.modelRelationships = modelRelationships;
        }

        @Inject
        private Conversation conversation;

        @PersistenceContext(unitName = "naifg28PU-JTA", type = PersistenceContextType.EXTENDED)
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
                        this.modelRelationships = this.example;
                } else {
                        this.modelRelationships = findById(getId());
                }
        }

        public ModelRelationships findById(Long id) {

                return this.entityManager.find(ModelRelationships.class, id);
        }

        /*
         * Support updating and deleting ModelRelationships entities
         */

        public String update() {
                this.conversation.end();

                try {
                        if (this.id == null) {
                                this.entityManager.persist(this.modelRelationships);
                                return "search?faces-redirect=true";
                        } else {
                                this.entityManager.merge(this.modelRelationships);
                                return "view?faces-redirect=true&id=" + this.modelRelationships.getId();
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
                        ModelRelationships deletableEntity = findById(getId());
                        GroupIds groupIds = deletableEntity.getGroupIds();
                        groupIds.getModelRelationships().remove(deletableEntity);
                        deletableEntity.setGroupIds(null);
                        this.entityManager.merge(groupIds);
                        Models models = deletableEntity.getModels();
                        models.getModelRelationships().remove(deletableEntity);
                        deletableEntity.setModels(null);
                        this.entityManager.merge(models);
                        Relationships relationships = deletableEntity.getRelationships();
                        relationships.getModelRelationships().remove(deletableEntity);
                        deletableEntity.setRelationships(null);
                        this.entityManager.merge(relationships);
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
         * Support searching ModelRelationships entities with pagination
         */

        private int page;
        private long count;
        private List<ModelRelationships> pageItems;

        private ModelRelationships example = new ModelRelationships();

        public int getPage() {
                return this.page;
        }

        public void setPage(int page) {
                this.page = page;
        }

        public int getPageSize() {
                return 10;
        }

        public ModelRelationships getExample() {
                return this.example;
        }

        public void setExample(ModelRelationships example) {
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
                Root<ModelRelationships> root = countCriteria.from(ModelRelationships.class);
                countCriteria = countCriteria.select(builder.count(root)).where(
                                getSearchPredicates(root));
                this.count = this.entityManager.createQuery(countCriteria).getSingleResult();

                // Populate this.pageItems

                CriteriaQuery<ModelRelationships> criteria = builder.createQuery(ModelRelationships.class);
                root = criteria.from(ModelRelationships.class);
                TypedQuery<ModelRelationships> query = this.entityManager.createQuery(criteria.select(root).where(getSearchPredicates(root)));
                query.setFirstResult(this.page * getPageSize()).setMaxResults(getPageSize());
                this.pageItems = query.getResultList();
        }

        private Predicate[] getSearchPredicates(Root<ModelRelationships> root) {

                CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
                List<Predicate> predicatesList = new ArrayList<Predicate>();

                return predicatesList.toArray(new Predicate[predicatesList.size()]);
        }

        public List<ModelRelationships> getPageItems() {
                return this.pageItems;
        }

        public long getCount() {
                return this.count;
        }

        /*
         * Support listing and POSTing back ModelRelationships entities (e.g. from inside an HtmlSelectOneMenu)
         */

        public List<ModelRelationships> getAll() {
                CriteriaQuery<ModelRelationships> criteria = this.entityManager.getCriteriaBuilder().createQuery(ModelRelationships.class);
                return this.entityManager.createQuery(criteria.select(criteria.from(ModelRelationships.class))).getResultList();
        }

        @Resource
        private SessionContext sessionContext;

        public Converter getConverter() {

                final ModelRelationshipsBean ejbProxy = this.sessionContext.getBusinessObject(ModelRelationshipsBean.class);

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
                                return String.valueOf(((ModelRelationships) value).getId());
                        }

        };
   }

        /*
         * Support adding children to bidirectional, one-to-many tables
         */

        private ModelRelationships add = new ModelRelationships();

        public ModelRelationships getAdd() {
               return this.add;
        }

        public ModelRelationships getAdded() {
               ModelRelationships added = this.add;
               this.add = new ModelRelationships();
               return added;
        }

}
