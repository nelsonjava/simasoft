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
public class WorksConstructionBean implements Serializable {

        private static final long serialVersionUID = 1L;

        /*
         * Support creating and retrieving WorksConstruction entities
         */

        private Long id;

        public Long getId() {
                return this.id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        private WorksConstruction worksConstruction;

        public WorksConstruction getWorksConstruction() {
                return this.worksConstruction;
        }

        public void setWorksConstruction(WorksConstruction worksConstruction) {
                this.worksConstruction = worksConstruction;
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
                        this.worksConstruction = this.example;
                } else {
                        this.worksConstruction = findById(getId());
                }
        }

        public WorksConstruction findById(Long id) {

                return this.entityManager.find(WorksConstruction.class, id);
        }

        /*
         * Support updating and deleting WorksConstruction entities
         */

        public String update() {
                this.conversation.end();

                try {
                        if (this.id == null) {
                                this.entityManager.persist(this.worksConstruction);
                                return "search?faces-redirect=true";
                        } else {
                                this.entityManager.merge(this.worksConstruction);
                                return "view?faces-redirect=true&id=" + this.worksConstruction.getId();
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
                        WorksConstruction deletableEntity = findById(getId());
                        Iterator<Budgets> iterBudgets = deletableEntity.getBudgets().iterator();
                        for (; iterBudgets.hasNext();){
                               Budgets nextInBudgets = iterBudgets.next();
                                nextInBudgets.setWorksConstruction(null);
                               iterBudgets.remove();
                               this.entityManager.merge(nextInBudgets);
                        }
          Iterator<WorksConstruction> iterObjHijos = deletableEntity.getObjHijos().iterator();
          for (; iterObjHijos.hasNext();){
             WorksConstruction nextInObjHijos = iterObjHijos.next();
             nextInObjHijos.setObjPadre(null);
             iterObjHijos.remove();
             this.entityManager.merge(nextInObjHijos);
          }
                        Years years = deletableEntity.getYears();
                        years.getWorksConstruction().remove(deletableEntity);
                        deletableEntity.setYears(null);
                        this.entityManager.merge(years);
   1      WorksConstruction objPadre = deletableEntity.getObjPadre();
   1      objPadre.getObjHijos().remove(deletableEntity);
   1      deletableEntity.setObjPadre(null);
   1      this.entityManager.merge(objPadre);
                        TypesWorksConstruction typesWorksConstruction = deletableEntity.getTypesWorksConstruction();
                        typesWorksConstruction.getWorksConstruction().remove(deletableEntity);
                        deletableEntity.setTypesWorksConstruction(null);
                        this.entityManager.merge(typesWorksConstruction);
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
         * Support searching WorksConstruction entities with pagination
         */

        private int page;
        private long count;
        private List<WorksConstruction> pageItems;

        private WorksConstruction example = new WorksConstruction();

        public int getPage() {
                return this.page;
        }

        public void setPage(int page) {
                this.page = page;
        }

        public int getPageSize() {
                return 10;
        }

        public WorksConstruction getExample() {
                return this.example;
        }

        public void setExample(WorksConstruction example) {
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
                Root<WorksConstruction> root = countCriteria.from(WorksConstruction.class);
                countCriteria = countCriteria.select(builder.count(root)).where(
                                getSearchPredicates(root));
                this.count = this.entityManager.createQuery(countCriteria).getSingleResult();

                // Populate this.pageItems

                CriteriaQuery<WorksConstruction> criteria = builder.createQuery(WorksConstruction.class);
                root = criteria.from(WorksConstruction.class);
                TypedQuery<WorksConstruction> query = this.entityManager.createQuery(criteria.select(root).where(getSearchPredicates(root)));
                query.setFirstResult(this.page * getPageSize()).setMaxResults(getPageSize());
                this.pageItems = query.getResultList();
        }

        private Predicate[] getSearchPredicates(Root<WorksConstruction> root) {

                CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
                List<Predicate> predicatesList = new ArrayList<Predicate>();

                return predicatesList.toArray(new Predicate[predicatesList.size()]);
        }

        public List<WorksConstruction> getPageItems() {
                return this.pageItems;
        }

        public long getCount() {
                return this.count;
        }

        /*
         * Support listing and POSTing back WorksConstruction entities (e.g. from inside an HtmlSelectOneMenu)
         */

        public List<WorksConstruction> getAll() {
                CriteriaQuery<WorksConstruction> criteria = this.entityManager.getCriteriaBuilder().createQuery(WorksConstruction.class);
                return this.entityManager.createQuery(criteria.select(criteria.from(WorksConstruction.class))).getResultList();
        }

        @Resource
        private SessionContext sessionContext;

        public Converter getConverter() {

                final WorksConstructionBean ejbProxy = this.sessionContext.getBusinessObject(WorksConstructionBean.class);

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
                                return String.valueOf(((WorksConstruction) value).getId());
                        }

        };
   }

        /*
         * Support adding children to bidirectional, one-to-many tables
         */

        private WorksConstruction add = new WorksConstruction();

        public WorksConstruction getAdd() {
               return this.add;
        }

        public WorksConstruction getAdded() {
               WorksConstruction added = this.add;
               this.add = new WorksConstruction();
               return added;
        }

}
