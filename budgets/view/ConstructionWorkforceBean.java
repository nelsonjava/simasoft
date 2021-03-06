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
import org.hibernate.search.annotations.NumericField;

@Named
@Stateful
@ConversationScoped
public class ConstructionWorkforceBean implements Serializable {

        private static final long serialVersionUID = 1L;

        /*
         * Support creating and retrieving ConstructionWorkforce entities
         */

        private Long id;

        public Long getId() {
                return this.id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        private ConstructionWorkforce constructionWorkforce;

        public ConstructionWorkforce getConstructionWorkforce() {
                return this.constructionWorkforce;
        }

        public void setConstructionWorkforce(ConstructionWorkforce constructionWorkforce) {
                this.constructionWorkforce = constructionWorkforce;
        }

        @Inject
        private Conversation conversation;

        @PersistenceContext(unitName = "budgetsPU-JTA", type = PersistenceContextType.EXTENDED)
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
                        this.constructionWorkforce = this.example;
                } else {
                        this.constructionWorkforce = findById(getId());
                }
        }

        public ConstructionWorkforce findById(Long id) {

                return this.entityManager.find(ConstructionWorkforce.class, id);
        }

        /*
         * Support updating and deleting ConstructionWorkforce entities
         */

        public String update() {
                this.conversation.end();

                try {
                        if (this.id == null) {
                                this.entityManager.persist(this.constructionWorkforce);
                                return "search?faces-redirect=true";
                        } else {
                                this.entityManager.merge(this.constructionWorkforce);
                                return "view?faces-redirect=true&id=" + this.constructionWorkforce.getId();
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
                        ConstructionWorkforce deletableEntity = findById(getId());
                        TypesConstructionWorkforce typesConstructionWorkforce = deletableEntity.getTypesConstructionWorkforce();
                        typesConstructionWorkforce.getConstructionWorkforce().remove(deletableEntity);
                        deletableEntity.setTypesConstructionWorkforce(null);
                        this.entityManager.merge(typesConstructionWorkforce);
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
         * Support searching ConstructionWorkforce entities with pagination
         */

        private int page;
        private long count;
        private List<ConstructionWorkforce> pageItems;

        private ConstructionWorkforce example = new ConstructionWorkforce();

        public int getPage() {
                return this.page;
        }

        public void setPage(int page) {
                this.page = page;
        }

        public int getPageSize() {
                return 10;
        }

        public ConstructionWorkforce getExample() {
                return this.example;
        }

        public void setExample(ConstructionWorkforce example) {
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
                Root<ConstructionWorkforce> root = countCriteria.from(ConstructionWorkforce.class);
                countCriteria = countCriteria.select(builder.count(root)).where(
                                getSearchPredicates(root));
                this.count = this.entityManager.createQuery(countCriteria).getSingleResult();

                // Populate this.pageItems

                CriteriaQuery<ConstructionWorkforce> criteria = builder.createQuery(ConstructionWorkforce.class);
                root = criteria.from(ConstructionWorkforce.class);
                TypedQuery<ConstructionWorkforce> query = this.entityManager.createQuery(criteria.select(root).where(getSearchPredicates(root)));
                query.setFirstResult(this.page * getPageSize()).setMaxResults(getPageSize());
                this.pageItems = query.getResultList();
        }

        private Predicate[] getSearchPredicates(Root<ConstructionWorkforce> root) {

                CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
                List<Predicate> predicatesList = new ArrayList<Predicate>();

                return predicatesList.toArray(new Predicate[predicatesList.size()]);
        }

        public List<ConstructionWorkforce> getPageItems() {
                return this.pageItems;
        }

        public long getCount() {
                return this.count;
        }

        /*
         * Support listing and POSTing back ConstructionWorkforce entities (e.g. from inside an HtmlSelectOneMenu)
         */

        public List<ConstructionWorkforce> getAll() {
                CriteriaQuery<ConstructionWorkforce> criteria = this.entityManager.getCriteriaBuilder().createQuery(ConstructionWorkforce.class);
                return this.entityManager.createQuery(criteria.select(criteria.from(ConstructionWorkforce.class))).getResultList();
        }

        @Resource
        private SessionContext sessionContext;

        public Converter getConverter() {

                final ConstructionWorkforceBean ejbProxy = this.sessionContext.getBusinessObject(ConstructionWorkforceBean.class);

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
                                return String.valueOf(((ConstructionWorkforce) value).getId());
                        }

        };
   }

        /*
         * Support adding children to bidirectional, one-to-many tables
         */

        private ConstructionWorkforce add = new ConstructionWorkforce();

        public ConstructionWorkforce getAdd() {
               return this.add;
        }

        public ConstructionWorkforce getAdded() {
               ConstructionWorkforce added = this.add;
               this.add = new ConstructionWorkforce();
               return added;
        }

}
