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
public class ItemsTypesBean implements Serializable {

        private static final long serialVersionUID = 1L;

        /*
         * Support creating and retrieving ItemsTypes entities
         */

        private Long id;

        public Long getId() {
                return this.id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        private ItemsTypes itemsTypes;

        public ItemsTypes getItemsTypes() {
                return this.itemsTypes;
        }

        public void setItemsTypes(ItemsTypes itemsTypes) {
                this.itemsTypes = itemsTypes;
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
                        this.itemsTypes = this.example;
                } else {
                        this.itemsTypes = findById(getId());
                }
        }

        public ItemsTypes findById(Long id) {

                return this.entityManager.find(ItemsTypes.class, id);
        }

        /*
         * Support updating and deleting ItemsTypes entities
         */

        public String update() {
                this.conversation.end();

                try {
                        if (this.id == null) {
                                this.entityManager.persist(this.itemsTypes);
                                return "search?faces-redirect=true";
                        } else {
                                this.entityManager.merge(this.itemsTypes);
                                return "view?faces-redirect=true&id=" + this.itemsTypes.getId();
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
                        ItemsTypes deletableEntity = findById(getId());
                        Iterator<ItemsNames> iterItemsNames = deletableEntity.getItemsNames().iterator();
                        for (; iterItemsNames.hasNext();){
                               ItemsNames nextInItemsNames = iterItemsNames.next();
                                nextInItemsNames.setItemsTypes(null);
                               iterItemsNames.remove();
                               this.entityManager.merge(nextInItemsNames);
                        }
          Iterator<ItemsTypes> iterObjHijos = deletableEntity.getObjHijos().iterator();
          for (; iterObjHijos.hasNext();){
             ItemsTypes nextInObjHijos = iterObjHijos.next();
             nextInObjHijos.setObjPadre(null);
             iterObjHijos.remove();
             this.entityManager.merge(nextInObjHijos);
          }
   1      ItemsTypes objPadre = deletableEntity.getObjPadre();
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
         * Support searching ItemsTypes entities with pagination
         */

        private int page;
        private long count;
        private List<ItemsTypes> pageItems;

        private ItemsTypes example = new ItemsTypes();

        public int getPage() {
                return this.page;
        }

        public void setPage(int page) {
                this.page = page;
        }

        public int getPageSize() {
                return 10;
        }

        public ItemsTypes getExample() {
                return this.example;
        }

        public void setExample(ItemsTypes example) {
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
                Root<ItemsTypes> root = countCriteria.from(ItemsTypes.class);
                countCriteria = countCriteria.select(builder.count(root)).where(
                                getSearchPredicates(root));
                this.count = this.entityManager.createQuery(countCriteria).getSingleResult();

                // Populate this.pageItems

                CriteriaQuery<ItemsTypes> criteria = builder.createQuery(ItemsTypes.class);
                root = criteria.from(ItemsTypes.class);
                TypedQuery<ItemsTypes> query = this.entityManager.createQuery(criteria.select(root).where(getSearchPredicates(root)));
                query.setFirstResult(this.page * getPageSize()).setMaxResults(getPageSize());
                this.pageItems = query.getResultList();
        }

        private Predicate[] getSearchPredicates(Root<ItemsTypes> root) {

                CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
                List<Predicate> predicatesList = new ArrayList<Predicate>();

                return predicatesList.toArray(new Predicate[predicatesList.size()]);
        }

        public List<ItemsTypes> getPageItems() {
                return this.pageItems;
        }

        public long getCount() {
                return this.count;
        }

        /*
         * Support listing and POSTing back ItemsTypes entities (e.g. from inside an HtmlSelectOneMenu)
         */

        public List<ItemsTypes> getAll() {
                CriteriaQuery<ItemsTypes> criteria = this.entityManager.getCriteriaBuilder().createQuery(ItemsTypes.class);
                return this.entityManager.createQuery(criteria.select(criteria.from(ItemsTypes.class))).getResultList();
        }

        @Resource
        private SessionContext sessionContext;

        public Converter getConverter() {

                final ItemsTypesBean ejbProxy = this.sessionContext.getBusinessObject(ItemsTypesBean.class);

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
                                return String.valueOf(((ItemsTypes) value).getId());
                        }

        };
   }

        /*
         * Support adding children to bidirectional, one-to-many tables
         */

        private ItemsTypes add = new ItemsTypes();

        public ItemsTypes getAdd() {
               return this.add;
        }

        public ItemsTypes getAdded() {
               ItemsTypes added = this.add;
               this.add = new ItemsTypes();
               return added;
        }

}
