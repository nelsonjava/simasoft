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
public class OriginalOrdersBean implements Serializable {

        private static final long serialVersionUID = 1L;

        /*
         * Support creating and retrieving OriginalOrders entities
         */

        private Long id;

        public Long getId() {
                return this.id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        private OriginalOrders originalOrders;

        public OriginalOrders getOriginalOrders() {
                return this.originalOrders;
        }

        public void setOriginalOrders(OriginalOrders originalOrders) {
                this.originalOrders = originalOrders;
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
                        this.originalOrders = this.example;
                } else {
                        this.originalOrders = findById(getId());
                }
        }

        public OriginalOrders findById(Long id) {

                return this.entityManager.find(OriginalOrders.class, id);
        }

        /*
         * Support updating and deleting OriginalOrders entities
         */

        public String update() {
                this.conversation.end();

                try {
                        if (this.id == null) {
                                this.entityManager.persist(this.originalOrders);
                                return "search?faces-redirect=true";
                        } else {
                                this.entityManager.merge(this.originalOrders);
                                return "view?faces-redirect=true&id=" + this.originalOrders.getId();
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
                        OriginalOrders deletableEntity = findById(getId());
                        ContinualImprovements continualImprovements = deletableEntity.getContinualImprovements();
                        continualImprovements.getOriginalOrders().remove(deletableEntity);
                        deletableEntity.setContinualImprovements(null);
                        this.entityManager.merge(continualImprovements);
                        DocumentalsUnits documentalsUnits = deletableEntity.getDocumentalsUnits();
                        documentalsUnits.getOriginalOrders().remove(deletableEntity);
                        deletableEntity.setDocumentalsUnits(null);
                        this.entityManager.merge(documentalsUnits);
                        DocumentalsSupports documentalsSupports = deletableEntity.getDocumentalsSupports();
                        documentalsSupports.getOriginalOrders().remove(deletableEntity);
                        deletableEntity.setDocumentalsSupports(null);
                        this.entityManager.merge(documentalsSupports);
                        ConservationUnits conservationUnits = deletableEntity.getConservationUnits();
                        conservationUnits.getOriginalOrders().remove(deletableEntity);
                        deletableEntity.setConservationUnits(null);
                        this.entityManager.merge(conservationUnits);
                        ConservationUnitsTypes conservationUnitsTypes = deletableEntity.getConservationUnitsTypes();
                        conservationUnitsTypes.getOriginalOrders().remove(deletableEntity);
                        deletableEntity.setConservationUnitsTypes(null);
                        this.entityManager.merge(conservationUnitsTypes);
                        DocumentalInventory documentalInventory = deletableEntity.getDocumentalInventory();
                        documentalInventory.getOriginalOrders().remove(deletableEntity);
                        deletableEntity.setDocumentalInventory(null);
                        this.entityManager.merge(documentalInventory);
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
         * Support searching OriginalOrders entities with pagination
         */

        private int page;
        private long count;
        private List<OriginalOrders> pageItems;

        private OriginalOrders example = new OriginalOrders();

        public int getPage() {
                return this.page;
        }

        public void setPage(int page) {
                this.page = page;
        }

        public int getPageSize() {
                return 10;
        }

        public OriginalOrders getExample() {
                return this.example;
        }

        public void setExample(OriginalOrders example) {
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
                Root<OriginalOrders> root = countCriteria.from(OriginalOrders.class);
                countCriteria = countCriteria.select(builder.count(root)).where(
                                getSearchPredicates(root));
                this.count = this.entityManager.createQuery(countCriteria).getSingleResult();

                // Populate this.pageItems

                CriteriaQuery<OriginalOrders> criteria = builder.createQuery(OriginalOrders.class);
                root = criteria.from(OriginalOrders.class);
                TypedQuery<OriginalOrders> query = this.entityManager.createQuery(criteria.select(root).where(getSearchPredicates(root)));
                query.setFirstResult(this.page * getPageSize()).setMaxResults(getPageSize());
                this.pageItems = query.getResultList();
        }

        private Predicate[] getSearchPredicates(Root<OriginalOrders> root) {

                CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
                List<Predicate> predicatesList = new ArrayList<Predicate>();

                return predicatesList.toArray(new Predicate[predicatesList.size()]);
        }

        public List<OriginalOrders> getPageItems() {
                return this.pageItems;
        }

        public long getCount() {
                return this.count;
        }

        /*
         * Support listing and POSTing back OriginalOrders entities (e.g. from inside an HtmlSelectOneMenu)
         */

        public List<OriginalOrders> getAll() {
                CriteriaQuery<OriginalOrders> criteria = this.entityManager.getCriteriaBuilder().createQuery(OriginalOrders.class);
                return this.entityManager.createQuery(criteria.select(criteria.from(OriginalOrders.class))).getResultList();
        }

        @Resource
        private SessionContext sessionContext;

        public Converter getConverter() {

                final OriginalOrdersBean ejbProxy = this.sessionContext.getBusinessObject(OriginalOrdersBean.class);

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
                                return String.valueOf(((OriginalOrders) value).getId());
                        }

        };
   }

        /*
         * Support adding children to bidirectional, one-to-many tables
         */

        private OriginalOrders add = new OriginalOrders();

        public OriginalOrders getAdd() {
               return this.add;
        }

        public OriginalOrders getAdded() {
               OriginalOrders added = this.add;
               this.add = new OriginalOrders();
               return added;
        }

}
