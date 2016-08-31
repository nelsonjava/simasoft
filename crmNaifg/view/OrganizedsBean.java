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
public class OrganizedsBean implements Serializable {

        private static final long serialVersionUID = 1L;

        /*
         * Support creating and retrieving Organizeds entities
         */

        private Long id;

        public Long getId() {
                return this.id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        private Organizeds organizeds;

        public Organizeds getOrganizeds() {
                return this.organizeds;
        }

        public void setOrganizeds(Organizeds organizeds) {
                this.organizeds = organizeds;
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
                        this.organizeds = this.example;
                } else {
                        this.organizeds = findById(getId());
                }
        }

        public Organizeds findById(Long id) {

                return this.entityManager.find(Organizeds.class, id);
        }

        /*
         * Support updating and deleting Organizeds entities
         */

        public String update() {
                this.conversation.end();

                try {
                        if (this.id == null) {
                                this.entityManager.persist(this.organizeds);
                                return "search?faces-redirect=true";
                        } else {
                                this.entityManager.merge(this.organizeds);
                                return "view?faces-redirect=true&id=" + this.organizeds.getId();
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
                        Organizeds deletableEntity = findById(getId());
                        Iterator<DocumentalsUnits> iterDocumentalsUnits = deletableEntity.getDocumentalsUnits().iterator();
                        for (; iterDocumentalsUnits.hasNext();){
                               DocumentalsUnits nextInDocumentalsUnits = iterDocumentalsUnits.next();
                                nextInDocumentalsUnits.setOrganizeds(null);
                               iterDocumentalsUnits.remove();
                               this.entityManager.merge(nextInDocumentalsUnits);
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
         * Support searching Organizeds entities with pagination
         */

        private int page;
        private long count;
        private List<Organizeds> pageItems;

        private Organizeds example = new Organizeds();

        public int getPage() {
                return this.page;
        }

        public void setPage(int page) {
                this.page = page;
        }

        public int getPageSize() {
                return 10;
        }

        public Organizeds getExample() {
                return this.example;
        }

        public void setExample(Organizeds example) {
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
                Root<Organizeds> root = countCriteria.from(Organizeds.class);
                countCriteria = countCriteria.select(builder.count(root)).where(
                                getSearchPredicates(root));
                this.count = this.entityManager.createQuery(countCriteria).getSingleResult();

                // Populate this.pageItems

                CriteriaQuery<Organizeds> criteria = builder.createQuery(Organizeds.class);
                root = criteria.from(Organizeds.class);
                TypedQuery<Organizeds> query = this.entityManager.createQuery(criteria.select(root).where(getSearchPredicates(root)));
                query.setFirstResult(this.page * getPageSize()).setMaxResults(getPageSize());
                this.pageItems = query.getResultList();
        }

        private Predicate[] getSearchPredicates(Root<Organizeds> root) {

                CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
                List<Predicate> predicatesList = new ArrayList<Predicate>();

                return predicatesList.toArray(new Predicate[predicatesList.size()]);
        }

        public List<Organizeds> getPageItems() {
                return this.pageItems;
        }

        public long getCount() {
                return this.count;
        }

        /*
         * Support listing and POSTing back Organizeds entities (e.g. from inside an HtmlSelectOneMenu)
         */

        public List<Organizeds> getAll() {
                CriteriaQuery<Organizeds> criteria = this.entityManager.getCriteriaBuilder().createQuery(Organizeds.class);
                return this.entityManager.createQuery(criteria.select(criteria.from(Organizeds.class))).getResultList();
        }

        @Resource
        private SessionContext sessionContext;

        public Converter getConverter() {

                final OrganizedsBean ejbProxy = this.sessionContext.getBusinessObject(OrganizedsBean.class);

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
                                return String.valueOf(((Organizeds) value).getId());
                        }

        };
   }

        /*
         * Support adding children to bidirectional, one-to-many tables
         */

        private Organizeds add = new Organizeds();

        public Organizeds getAdd() {
               return this.add;
        }

        public Organizeds getAdded() {
               Organizeds added = this.add;
               this.add = new Organizeds();
               return added;
        }

}
