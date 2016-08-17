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

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.DocumentId;
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
public class ItemsStatesBean implements Serializable {

        private static final long serialVersionUID = 1L;

        /*
         * Support creating and retrieving ItemsStates entities
         */

        private Long id;

        public Long getId() {
                return this.id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        private ItemsStates itemsStates;

        public ItemsStates getItemsStates() {
                return this.itemsStates;
        }

        public void setItemsStates(ItemsStates itemsStates) {
                this.itemsStates = itemsStates;
        }

        @Inject
        private Conversation conversation;

        @PersistenceContext(unitName = "networkingPU-JTA", type = PersistenceContextType.EXTENDED)
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
                        this.itemsStates = this.example;
                } else {
                        this.itemsStates = findById(getId());
                }
        }

        public ItemsStates findById(Long id) {

                return this.entityManager.find(ItemsStates.class, id);
        }

        /*
         * Support updating and deleting ItemsStates entities
         */

        public String update() {
                this.conversation.end();

                try {
                        if (this.id == null) {
                                this.entityManager.persist(this.itemsStates);
                                return "search?faces-redirect=true";
                        } else {
                                this.entityManager.merge(this.itemsStates);
                                return "view?faces-redirect=true&id=" + this.itemsStates.getId();
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
                        ItemsStates deletableEntity = findById(getId());
                        Iterator<Items> iterItems = deletableEntity.getItems().iterator();
                        for (; iterItems.hasNext();){
                               Items nextInItems = iterItems.next();
                                nextInItems.setItemsStates(null);
                               iterItems.remove();
                               this.entityManager.merge(nextInItems);
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
         * Support searching ItemsStates entities with pagination
         */

        private int page;
        private long count;
        private List<ItemsStates> pageItems;

        private ItemsStates example = new ItemsStates();

        public int getPage() {
                return this.page;
        }

        public void setPage(int page) {
                this.page = page;
        }

        public int getPageSize() {
                return 10;
        }

        public ItemsStates getExample() {
                return this.example;
        }

        public void setExample(ItemsStates example) {
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
                Root<ItemsStates> root = countCriteria.from(ItemsStates.class);
                countCriteria = countCriteria.select(builder.count(root)).where(
                                getSearchPredicates(root));
                this.count = this.entityManager.createQuery(countCriteria).getSingleResult();

                // Populate this.pageItems

                CriteriaQuery<ItemsStates> criteria = builder.createQuery(ItemsStates.class);
                root = criteria.from(ItemsStates.class);
                TypedQuery<ItemsStates> query = this.entityManager.createQuery(criteria.select(root).where(getSearchPredicates(root)));
                query.setFirstResult(this.page * getPageSize()).setMaxResults(getPageSize());
                this.pageItems = query.getResultList();
        }

        private Predicate[] getSearchPredicates(Root<ItemsStates> root) {

                CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
                List<Predicate> predicatesList = new ArrayList<Predicate>();

                return predicatesList.toArray(new Predicate[predicatesList.size()]);
        }

        public List<ItemsStates> getPageItems() {
                return this.pageItems;
        }

        public long getCount() {
                return this.count;
        }

        /*
         * Support listing and POSTing back ItemsStates entities (e.g. from inside an HtmlSelectOneMenu)
         */

        public List<ItemsStates> getAll() {
                CriteriaQuery<ItemsStates> criteria = this.entityManager.getCriteriaBuilder().createQuery(ItemsStates.class);
                return this.entityManager.createQuery(criteria.select(criteria.from(ItemsStates.class))).getResultList();
        }

        @Resource
        private SessionContext sessionContext;

        public Converter getConverter() {

                final ItemsStatesBean ejbProxy = this.sessionContext.getBusinessObject(ItemsStatesBean.class);

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
                                return String.valueOf(((ItemsStates) value).getId());
                        }

        };
   }

        /*
         * Support adding children to bidirectional, one-to-many tables
         */

        private ItemsStates add = new ItemsStates();

        public ItemsStates getAdd() {
               return this.add;
        }

        public ItemsStates getAdded() {
               ItemsStates added = this.add;
               this.add = new ItemsStates();
               return added;
        }

}
