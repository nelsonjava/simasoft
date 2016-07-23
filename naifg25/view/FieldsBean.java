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

import import co.simasoft.*;
import import org.hibernate.search.annotations.Analyze;
import import org.hibernate.search.annotations.DocumentId;
import import org.hibernate.search.annotations.Field;
import import org.hibernate.search.annotations.Index;
import import org.hibernate.search.annotations.Indexed;
import import org.hibernate.search.annotations.Store;
import import javax.persistence.OneToMany;
import import javax.persistence.ManyToOne;
import import javax.persistence.ManyToMany;
import import javax.persistence.Temporal;
import import javax.persistence.TemporalType;
import import org.hibernate.search.annotations.DateBridge;
import import org.hibernate.search.annotations.Resolution;
import java.util.Iterator;

@Named
@Stateful
@ConversationScoped
public class FieldsBean implements Serializable{

        private static final long serialVersionUID = 1L;

        /*
         * Support creating and retrieving Fields entities
         */

        private Long id;

        public Long getId() {
                return this.id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        private Fields fields;

        public Fields getFields() {
                return this.fields;
        }

        public void setFields(Fields fields) {
                this.fields = fields;
        }

        @Inject
        private Conversation conversation;

        @PersistenceContext(unitName = "naifg25PU-JTA", type = PersistenceContextType.EXTENDED)
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
                        this.fields = this.example;
                } else {
                        this.fields = findById(getId());
                }
        }

        public Fields findById(Long id) {

                return this.entityManager.find(Fields.class, id);
        }

        /*
         * Support updating and deleting Fields entities
        */

        public String update() {
                this.conversation.end();

                try {
                        if (this.id == null) {
                                this.entityManager.persist(this.fields);
                                return "search?faces-redirect=true";
                        } else {
                                this.entityManager.merge(this.fields);
                                return "view?faces-redirect=true&id=" + this.fields.getId();
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
                        Fields deletableEntity = findById(getId());
                        AttributesTypes attributesTypes = deletableEntity.getAttributesTypes();
                        attributesTypes.getFields().remove(deletableEntity);
                        deletableEntity.setAttributesTypes(null);
                        this.entityManager.merge(attributesTypes);
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
         * Support searching Fields entities with pagination
         */

        private int page;
        private long count;
        private List<Fields> pageItems;

        private Fields example = new Fields();

        public int getPage() {
                return this.page;
        }

        public void setPage(int page) {
                this.page = page;
        }

        public int getPageSize() {
                return 10;
        }

        public Fields getExample() {
                return this.example;
        }

        public void setExample(Fields example) {
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
                Root<Fields> root = countCriteria.from(Fields.class);
                countCriteria = countCriteria.select(builder.count(root)).where(
                                getSearchPredicates(root));
                this.count = this.entityManager.createQuery(countCriteria).getSingleResult();

                // Populate this.pageItems

                CriteriaQuery<Fields> criteria = builder.createQuery(Fields.class);
                root = criteria.from(Fields.class);
                TypedQuery<Fields> query = this.entityManager.createQuery(criteria.select(root).where(getSearchPredicates(root)));
                query.setFirstResult(this.page * getPageSize()).setMaxResults(getPageSize());
                this.pageItems = query.getResultList();
        }

        private Predicate[] getSearchPredicates(Root<Fields> root) {

                CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
                List<Predicate> predicatesList = new ArrayList<Predicate>();

                return predicatesList.toArray(new Predicate[predicatesList.size()]);
        }

        public List<Fields> getPageItems() {
                return this.pageItems;
        }

        public long getCount() {
                return this.count;
        }

        /*
         * Support listing and POSTing back Fields entities (e.g. from inside an HtmlSelectOneMenu)
         */

        public List<Fields> getAll() {
                CriteriaQuery<Fields> criteria = this.entityManager.getCriteriaBuilder().createQuery(Fields.class);
                return this.entityManager.createQuery(criteria.select(criteria.from(Fields.class))).getResultList();
        }

        @Resource
        private SessionContext sessionContext;

        public Converter getConverter() {

                final FieldsBean ejbProxy = this.sessionContext.getBusinessObject(FieldsBean.class);

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
                       return String.valueOf(((Fields) value).getId());
                }

        };
   }

        /*
         * Support adding children to bidirectional, one-to-many tables
         */

        private Fields add = new Fields();

        public Fields getAdd() {
               return this.add;
        }

        public Fields getAdded() {
               Fields added = this.add;
               this.add = new Fields();
               return added;
        }

}