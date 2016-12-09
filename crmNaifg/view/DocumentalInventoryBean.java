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
public class DocumentalInventoryBean implements Serializable {

        private static final long serialVersionUID = 1L;

        /*
         * Support creating and retrieving DocumentalInventory entities
         */

        private Long id;

        public Long getId() {
                return this.id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        private DocumentalInventory documentalInventory;

        public DocumentalInventory getDocumentalInventory() {
                return this.documentalInventory;
        }

        public void setDocumentalInventory(DocumentalInventory documentalInventory) {
                this.documentalInventory = documentalInventory;
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
                        this.documentalInventory = this.example;
                } else {
                        this.documentalInventory = findById(getId());
                }
        }

        public DocumentalInventory findById(Long id) {

                return this.entityManager.find(DocumentalInventory.class, id);
        }

        /*
         * Support updating and deleting DocumentalInventory entities
         */

        public String update() {
                this.conversation.end();

                try {
                        if (this.id == null) {
                                this.entityManager.persist(this.documentalInventory);
                                return "search?faces-redirect=true";
                        } else {
                                this.entityManager.merge(this.documentalInventory);
                                return "view?faces-redirect=true&id=" + this.documentalInventory.getId();
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
                        DocumentalInventory deletableEntity = findById(getId());
                        Iterator<OriginalOrders> iterOriginalOrders = deletableEntity.getOriginalOrders().iterator();
                        for (; iterOriginalOrders.hasNext();){
                               OriginalOrders nextInOriginalOrders = iterOriginalOrders.next();
                                nextInOriginalOrders.setDocumentalInventory(null);
                               iterOriginalOrders.remove();
                               this.entityManager.merge(nextInOriginalOrders);
                        }
                        InventoryFinality inventoryFinality = deletableEntity.getInventoryFinality();
                        inventoryFinality.getDocumentalInventory().remove(deletableEntity);
                        deletableEntity.setInventoryFinality(null);
                        this.entityManager.merge(inventoryFinality);
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
         * Support searching DocumentalInventory entities with pagination
         */

        private int page;
        private long count;
        private List<DocumentalInventory> pageItems;

        private DocumentalInventory example = new DocumentalInventory();

        public int getPage() {
                return this.page;
        }

        public void setPage(int page) {
                this.page = page;
        }

        public int getPageSize() {
                return 10;
        }

        public DocumentalInventory getExample() {
                return this.example;
        }

        public void setExample(DocumentalInventory example) {
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
                Root<DocumentalInventory> root = countCriteria.from(DocumentalInventory.class);
                countCriteria = countCriteria.select(builder.count(root)).where(
                                getSearchPredicates(root));
                this.count = this.entityManager.createQuery(countCriteria).getSingleResult();

                // Populate this.pageItems

                CriteriaQuery<DocumentalInventory> criteria = builder.createQuery(DocumentalInventory.class);
                root = criteria.from(DocumentalInventory.class);
                TypedQuery<DocumentalInventory> query = this.entityManager.createQuery(criteria.select(root).where(getSearchPredicates(root)));
                query.setFirstResult(this.page * getPageSize()).setMaxResults(getPageSize());
                this.pageItems = query.getResultList();
        }

        private Predicate[] getSearchPredicates(Root<DocumentalInventory> root) {

                CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
                List<Predicate> predicatesList = new ArrayList<Predicate>();

                return predicatesList.toArray(new Predicate[predicatesList.size()]);
        }

        public List<DocumentalInventory> getPageItems() {
                return this.pageItems;
        }

        public long getCount() {
                return this.count;
        }

        /*
         * Support listing and POSTing back DocumentalInventory entities (e.g. from inside an HtmlSelectOneMenu)
         */

        public List<DocumentalInventory> getAll() {
                CriteriaQuery<DocumentalInventory> criteria = this.entityManager.getCriteriaBuilder().createQuery(DocumentalInventory.class);
                return this.entityManager.createQuery(criteria.select(criteria.from(DocumentalInventory.class))).getResultList();
        }

        @Resource
        private SessionContext sessionContext;

        public Converter getConverter() {

                final DocumentalInventoryBean ejbProxy = this.sessionContext.getBusinessObject(DocumentalInventoryBean.class);

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
                                return String.valueOf(((DocumentalInventory) value).getId());
                        }

        };
   }

        /*
         * Support adding children to bidirectional, one-to-many tables
         */

        private DocumentalInventory add = new DocumentalInventory();

        public DocumentalInventory getAdd() {
               return this.add;
        }

        public DocumentalInventory getAdded() {
               DocumentalInventory added = this.add;
               this.add = new DocumentalInventory();
               return added;
        }

}
