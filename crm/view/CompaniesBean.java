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
public class CompaniesBean implements Serializable {

        private static final long serialVersionUID = 1L;

        /*
         * Support creating and retrieving Companies entities
         */

        private Long id;

        public Long getId() {
                return this.id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        private Companies companies;

        public Companies getCompanies() {
                return this.companies;
        }

        public void setCompanies(Companies companies) {
                this.companies = companies;
        }

        @Inject
        private Conversation conversation;

        @PersistenceContext(unitName = "crmPU-JTA", type = PersistenceContextType.EXTENDED)
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
                        this.companies = this.example;
                } else {
                        this.companies = findById(getId());
                }
        }

        public Companies findById(Long id) {

                return this.entityManager.find(Companies.class, id);
        }

        /*
         * Support updating and deleting Companies entities
         */

        public String update() {
                this.conversation.end();

                try {
                        if (this.id == null) {
                                this.entityManager.persist(this.companies);
                                return "search?faces-redirect=true";
                        } else {
                                this.entityManager.merge(this.companies);
                                return "view?faces-redirect=true&id=" + this.companies.getId();
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
                        Companies deletableEntity = findById(getId());
                        Iterator<Funds> iterFunds = deletableEntity.getFunds().iterator();
                        for (; iterFunds.hasNext();){
                               Funds nextInFunds = iterFunds.next();
                                nextInFunds.setCompanies(null);
                               iterFunds.remove();
                               this.entityManager.merge(nextInFunds);
                        }
                        Iterator<Brands> iterBrands = deletableEntity.getBrands().iterator();
                        for (; iterBrands.hasNext();){
                               Brands nextInBrands = iterBrands.next();
                                nextInBrands.setCompanies(null);
                               iterBrands.remove();
                               this.entityManager.merge(nextInBrands);
                        }
                        Iterator<Employees> iterEmployees = deletableEntity.getEmployees().iterator();
                        for (; iterEmployees.hasNext();){
                               Employees nextInEmployees = iterEmployees.next();
                                nextInEmployees.setCompanies(null);
                               iterEmployees.remove();
                               this.entityManager.merge(nextInEmployees);
                        }
          Iterator<Companies> iterObjHijos = deletableEntity.getObjHijos().iterator();
          for (; iterObjHijos.hasNext();){
             Companies nextInObjHijos = iterObjHijos.next();
             nextInObjHijos.setObjPadre(null);
             iterObjHijos.remove();
             this.entityManager.merge(nextInObjHijos);
          }
   1      Companies objPadre = deletableEntity.getObjPadre();
   1      objPadre.getObjHijos().remove(deletableEntity);
   1      deletableEntity.setObjPadre(null);
   1      this.entityManager.merge(objPadre);
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
         * Support searching Companies entities with pagination
         */

        private int page;
        private long count;
        private List<Companies> pageItems;

        private Companies example = new Companies();

        public int getPage() {
                return this.page;
        }

        public void setPage(int page) {
                this.page = page;
        }

        public int getPageSize() {
                return 10;
        }

        public Companies getExample() {
                return this.example;
        }

        public void setExample(Companies example) {
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
                Root<Companies> root = countCriteria.from(Companies.class);
                countCriteria = countCriteria.select(builder.count(root)).where(
                                getSearchPredicates(root));
                this.count = this.entityManager.createQuery(countCriteria).getSingleResult();

                // Populate this.pageItems

                CriteriaQuery<Companies> criteria = builder.createQuery(Companies.class);
                root = criteria.from(Companies.class);
                TypedQuery<Companies> query = this.entityManager.createQuery(criteria.select(root).where(getSearchPredicates(root)));
                query.setFirstResult(this.page * getPageSize()).setMaxResults(getPageSize());
                this.pageItems = query.getResultList();
        }

        private Predicate[] getSearchPredicates(Root<Companies> root) {

                CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
                List<Predicate> predicatesList = new ArrayList<Predicate>();

                return predicatesList.toArray(new Predicate[predicatesList.size()]);
        }

        public List<Companies> getPageItems() {
                return this.pageItems;
        }

        public long getCount() {
                return this.count;
        }

        /*
         * Support listing and POSTing back Companies entities (e.g. from inside an HtmlSelectOneMenu)
         */

        public List<Companies> getAll() {
                CriteriaQuery<Companies> criteria = this.entityManager.getCriteriaBuilder().createQuery(Companies.class);
                return this.entityManager.createQuery(criteria.select(criteria.from(Companies.class))).getResultList();
        }

        @Resource
        private SessionContext sessionContext;

        public Converter getConverter() {

                final CompaniesBean ejbProxy = this.sessionContext.getBusinessObject(CompaniesBean.class);

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
                                return String.valueOf(((Companies) value).getId());
                        }

        };
   }

        /*
         * Support adding children to bidirectional, one-to-many tables
         */

        private Companies add = new Companies();

        public Companies getAdd() {
               return this.add;
        }

        public Companies getAdded() {
               Companies added = this.add;
               this.add = new Companies();
               return added;
        }

}
