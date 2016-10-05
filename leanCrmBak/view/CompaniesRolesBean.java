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
public class CompaniesRolesBean implements Serializable {

        private static final long serialVersionUID = 1L;

        /*
         * Support creating and retrieving CompaniesRoles entities
         */

        private Long id;

        public Long getId() {
                return this.id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        private CompaniesRoles companiesRoles;

        public CompaniesRoles getCompaniesRoles() {
                return this.companiesRoles;
        }

        public void setCompaniesRoles(CompaniesRoles companiesRoles) {
                this.companiesRoles = companiesRoles;
        }

        @Inject
        private Conversation conversation;

        @PersistenceContext(unitName = "leanCrmPU-JTA", type = PersistenceContextType.EXTENDED)
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
                        this.companiesRoles = this.example;
                } else {
                        this.companiesRoles = findById(getId());
                }
        }

        public CompaniesRoles findById(Long id) {

                return this.entityManager.find(CompaniesRoles.class, id);
        }

        /*
         * Support updating and deleting CompaniesRoles entities
         */

        public String update() {
                this.conversation.end();

                try {
                        if (this.id == null) {
                                this.entityManager.persist(this.companiesRoles);
                                return "search?faces-redirect=true";
                        } else {
                                this.entityManager.merge(this.companiesRoles);
                                return "view?faces-redirect=true&id=" + this.companiesRoles.getId();
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
                        CompaniesRoles deletableEntity = findById(getId());
          Iterator<DocumentalsUnits> iterAlmacenamiento = deletableEntity.getAlmacenamiento().iterator();
          for (; iterAlmacenamiento.hasNext();){
             DocumentalsUnits nextInAlmacenamiento = iterAlmacenamiento.next();
             nextInAlmacenamiento.setAlmacenamiento(null);
             iterAlmacenamiento.remove();
             this.entityManager.merge(nextInAlmacenamiento);
          }
          Iterator<DocumentalsUnits> iterProteccion = deletableEntity.getProteccion().iterator();
          for (; iterProteccion.hasNext();){
             DocumentalsUnits nextInProteccion = iterProteccion.next();
             nextInProteccion.setProteccion(null);
             iterProteccion.remove();
             this.entityManager.merge(nextInProteccion);
          }
                        CompaniesRolesTypes companiesRolesTypes = deletableEntity.getCompaniesRolesTypes();
                        companiesRolesTypes.getCompaniesRoles().remove(deletableEntity);
                        deletableEntity.setCompaniesRolesTypes(null);
                        this.entityManager.merge(companiesRolesTypes);
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
         * Support searching CompaniesRoles entities with pagination
         */

        private int page;
        private long count;
        private List<CompaniesRoles> pageItems;

        private CompaniesRoles example = new CompaniesRoles();

        public int getPage() {
                return this.page;
        }

        public void setPage(int page) {
                this.page = page;
        }

        public int getPageSize() {
                return 10;
        }

        public CompaniesRoles getExample() {
                return this.example;
        }

        public void setExample(CompaniesRoles example) {
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
                Root<CompaniesRoles> root = countCriteria.from(CompaniesRoles.class);
                countCriteria = countCriteria.select(builder.count(root)).where(
                                getSearchPredicates(root));
                this.count = this.entityManager.createQuery(countCriteria).getSingleResult();

                // Populate this.pageItems

                CriteriaQuery<CompaniesRoles> criteria = builder.createQuery(CompaniesRoles.class);
                root = criteria.from(CompaniesRoles.class);
                TypedQuery<CompaniesRoles> query = this.entityManager.createQuery(criteria.select(root).where(getSearchPredicates(root)));
                query.setFirstResult(this.page * getPageSize()).setMaxResults(getPageSize());
                this.pageItems = query.getResultList();
        }

        private Predicate[] getSearchPredicates(Root<CompaniesRoles> root) {

                CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
                List<Predicate> predicatesList = new ArrayList<Predicate>();

                return predicatesList.toArray(new Predicate[predicatesList.size()]);
        }

        public List<CompaniesRoles> getPageItems() {
                return this.pageItems;
        }

        public long getCount() {
                return this.count;
        }

        /*
         * Support listing and POSTing back CompaniesRoles entities (e.g. from inside an HtmlSelectOneMenu)
         */

        public List<CompaniesRoles> getAll() {
                CriteriaQuery<CompaniesRoles> criteria = this.entityManager.getCriteriaBuilder().createQuery(CompaniesRoles.class);
                return this.entityManager.createQuery(criteria.select(criteria.from(CompaniesRoles.class))).getResultList();
        }

        @Resource
        private SessionContext sessionContext;

        public Converter getConverter() {

                final CompaniesRolesBean ejbProxy = this.sessionContext.getBusinessObject(CompaniesRolesBean.class);

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
                                return String.valueOf(((CompaniesRoles) value).getId());
                        }

        };
   }

        /*
         * Support adding children to bidirectional, one-to-many tables
         */

        private CompaniesRoles add = new CompaniesRoles();

        public CompaniesRoles getAdd() {
               return this.add;
        }

        public CompaniesRoles getAdded() {
               CompaniesRoles added = this.add;
               this.add = new CompaniesRoles();
               return added;
        }

}
