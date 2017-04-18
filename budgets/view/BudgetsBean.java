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
public class BudgetsBean implements Serializable {

        private static final long serialVersionUID = 1L;

        /*
         * Support creating and retrieving Budgets entities
         */

        private Long id;

        public Long getId() {
                return this.id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        private Budgets budgets;

        public Budgets getBudgets() {
                return this.budgets;
        }

        public void setBudgets(Budgets budgets) {
                this.budgets = budgets;
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
                        this.budgets = this.example;
                } else {
                        this.budgets = findById(getId());
                }
        }

        public Budgets findById(Long id) {

                return this.entityManager.find(Budgets.class, id);
        }

        /*
         * Support updating and deleting Budgets entities
         */

        public String update() {
                this.conversation.end();

                try {
                        if (this.id == null) {
                                this.entityManager.persist(this.budgets);
                                return "search?faces-redirect=true";
                        } else {
                                this.entityManager.merge(this.budgets);
                                return "view?faces-redirect=true&id=" + this.budgets.getId();
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
                        Budgets deletableEntity = findById(getId());
                        WorksConstruction worksConstruction = deletableEntity.getWorksConstruction();
                        worksConstruction.getBudgets().remove(deletableEntity);
                        deletableEntity.setWorksConstruction(null);
                        this.entityManager.merge(worksConstruction);
                        WorkActivities workActivities = deletableEntity.getWorkActivities();
                        workActivities.getBudgets().remove(deletableEntity);
                        deletableEntity.setWorkActivities(null);
                        this.entityManager.merge(workActivities);
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
         * Support searching Budgets entities with pagination
         */

        private int page;
        private long count;
        private List<Budgets> pageItems;

        private Budgets example = new Budgets();

        public int getPage() {
                return this.page;
        }

        public void setPage(int page) {
                this.page = page;
        }

        public int getPageSize() {
                return 10;
        }

        public Budgets getExample() {
                return this.example;
        }

        public void setExample(Budgets example) {
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
                Root<Budgets> root = countCriteria.from(Budgets.class);
                countCriteria = countCriteria.select(builder.count(root)).where(
                                getSearchPredicates(root));
                this.count = this.entityManager.createQuery(countCriteria).getSingleResult();

                // Populate this.pageItems

                CriteriaQuery<Budgets> criteria = builder.createQuery(Budgets.class);
                root = criteria.from(Budgets.class);
                TypedQuery<Budgets> query = this.entityManager.createQuery(criteria.select(root).where(getSearchPredicates(root)));
                query.setFirstResult(this.page * getPageSize()).setMaxResults(getPageSize());
                this.pageItems = query.getResultList();
        }

        private Predicate[] getSearchPredicates(Root<Budgets> root) {

                CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
                List<Predicate> predicatesList = new ArrayList<Predicate>();

                return predicatesList.toArray(new Predicate[predicatesList.size()]);
        }

        public List<Budgets> getPageItems() {
                return this.pageItems;
        }

        public long getCount() {
                return this.count;
        }

        /*
         * Support listing and POSTing back Budgets entities (e.g. from inside an HtmlSelectOneMenu)
         */

        public List<Budgets> getAll() {
                CriteriaQuery<Budgets> criteria = this.entityManager.getCriteriaBuilder().createQuery(Budgets.class);
                return this.entityManager.createQuery(criteria.select(criteria.from(Budgets.class))).getResultList();
        }

        @Resource
        private SessionContext sessionContext;

        public Converter getConverter() {

                final BudgetsBean ejbProxy = this.sessionContext.getBusinessObject(BudgetsBean.class);

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
                                return String.valueOf(((Budgets) value).getId());
                        }

        };
   }

        /*
         * Support adding children to bidirectional, one-to-many tables
         */

        private Budgets add = new Budgets();

        public Budgets getAdd() {
               return this.add;
        }

        public Budgets getAdded() {
               Budgets added = this.add;
               this.add = new Budgets();
               return added;
        }

}
