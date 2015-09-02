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

import import co.simasoft.models.dev.naifg.*;
import import co.simasoft.models.dev.naifg.dependencies.*;
import import co.simasoft.models.core.sites.*;
import import org.hibernate.search.annotations.Analyze;
import import org.hibernate.search.annotations.Index;
import import org.hibernate.search.annotations.Field;
import import org.hibernate.search.annotations.DocumentId;
import import org.hibernate.search.annotations.Store;
import import org.hibernate.search.annotations.Indexed;
import import javax.persistence.TemporalType;
import import javax.persistence.Temporal;
import import org.hibernate.search.annotations.DateBridge;
import import org.hibernate.search.annotations.Resolution;
import import javax.persistence.OneToMany;
import import javax.persistence.ManyToOne;
import import javax.persistence.ManyToMany;
import java.util.Iterator;

@Named
@Stateful
@ConversationScoped
public class AttributesTypesBean implements Serializable{

        private static final long serialVersionUID = 1L;

        /*
         * Support creating and retrieving AttributesTypes entities
         */

        private Long id;

        public Long getId() {
                return this.id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        private AttributesTypes attributesTypes;

        public AttributesTypes getAttributesTypes() {
                return this.attributesTypes;
        }

        public void setAttributesTypes(AttributesTypes attributesTypes) {
                this.attributesTypes = attributesTypes;
        }

        @Inject
        private Conversation conversation;

        @PersistenceContext(unitName = "naifgPU-JTA", type = PersistenceContextType.EXTENDED)
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
                        this.attributesTypes = this.example;
                } else {
                        this.attributesTypes = findById(getId());
                }
        }

        public AttributesTypes findById(Long id) {

                return this.entityManager.find(AttributesTypes.class, id);
        }

        /*
         * Support updating and deleting AttributesTypes entities
        */

        public String update() {
                this.conversation.end();

                try {
                        if (this.id == null) {
                                this.entityManager.persist(this.attributesTypes);
                                return "search?faces-redirect=true";
                        } else {
                                this.entityManager.merge(this.attributesTypes);
                                return "view?faces-redirect=true&id=" + this.attributesTypes.getId();
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
                        AttributesTypes deletableEntity = findById(getId());
                        Iterator<Attributes> iterAttributes = deletableEntity.getAttributes().iterator();
                        for (; iterAttributes.hasNext();){
                               Attributes nextInAttributes = iterAttributes.next();
                                nextInAttributes.setAttributesTypes(null);
                               iterAttributes.remove();
                               this.entityManager.merge(nextInAttributes);
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
         * Support searching AttributesTypes entities with pagination
         */

        private int page;
        private long count;
        private List<AttributesTypes> pageItems;

        private AttributesTypes example = new AttributesTypes();

        public int getPage() {
                return this.page;
        }

        public void setPage(int page) {
                this.page = page;
        }

        public int getPageSize() {
                return 10;
        }

        public AttributesTypes getExample() {
                return this.example;
        }

        public void setExample(AttributesTypes example) {
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
                Root<AttributesTypes> root = countCriteria.from(AttributesTypes.class);
                countCriteria = countCriteria.select(builder.count(root)).where(
                                getSearchPredicates(root));
                this.count = this.entityManager.createQuery(countCriteria).getSingleResult();

                // Populate this.pageItems

                CriteriaQuery<AttributesTypes> criteria = builder.createQuery(AttributesTypes.class);
                root = criteria.from(AttributesTypes.class);
                TypedQuery<AttributesTypes> query = this.entityManager.createQuery(criteria.select(root).where(getSearchPredicates(root)));
                query.setFirstResult(this.page * getPageSize()).setMaxResults(getPageSize());
                this.pageItems = query.getResultList();
        }

        private Predicate[] getSearchPredicates(Root<AttributesTypes> root) {

                CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
                List<Predicate> predicatesList = new ArrayList<Predicate>();

                return predicatesList.toArray(new Predicate[predicatesList.size()]);
        }

        public List<AttributesTypes> getPageItems() {
                return this.pageItems;
        }

        public long getCount() {
                return this.count;
        }

        /*
         * Support listing and POSTing back AttributesTypes entities (e.g. from inside an HtmlSelectOneMenu)
         */

        public List<AttributesTypes> getAll() {
                CriteriaQuery<AttributesTypes> criteria = this.entityManager.getCriteriaBuilder().createQuery(AttributesTypes.class);
                return this.entityManager.createQuery(criteria.select(criteria.from(AttributesTypes.class))).getResultList();
        }

        @Resource
        private SessionContext sessionContext;

        public Converter getConverter() {

                final AttributesTypesBean ejbProxy = this.sessionContext.getBusinessObject(AttributesTypesBean.class);

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
                       return String.valueOf(((AttributesTypes) value).getId());
                }

        };
   }

        /*
         * Support adding children to bidirectional, one-to-many tables
         */

        private AttributesTypes add = new AttributesTypes();

        public AttributesTypes getAdd() {
               return this.add;
        }

        public AttributesTypes getAdded() {
               AttributesTypes added = this.add;
               this.add = new AttributesTypes();
               return added;
        }

}
