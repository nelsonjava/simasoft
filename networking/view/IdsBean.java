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
public class IdsBean implements Serializable {

        private static final long serialVersionUID = 1L;

        /*
         * Support creating and retrieving Ids entities
         */

        private Long id;

        public Long getId() {
                return this.id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        private Ids ids;

        public Ids getIds() {
                return this.ids;
        }

        public void setIds(Ids ids) {
                this.ids = ids;
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
                        this.ids = this.example;
                } else {
                        this.ids = findById(getId());
                }
        }

        public Ids findById(Long id) {

                return this.entityManager.find(Ids.class, id);
        }

        /*
         * Support updating and deleting Ids entities
         */

        public String update() {
                this.conversation.end();

                try {
                        if (this.id == null) {
                                this.entityManager.persist(this.ids);
                                return "search?faces-redirect=true";
                        } else {
                                this.entityManager.merge(this.ids);
                                return "view?faces-redirect=true&id=" + this.ids.getId();
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
                        Ids deletableEntity = findById(getId());
                        Persons persons = deletableEntity.getPersons();
                        persons.getIds().remove(deletableEntity);
                        deletableEntity.setPersons(null);
                        this.entityManager.merge(persons);
                        IdsTypes idsTypes = deletableEntity.getIdsTypes();
                        idsTypes.getIds().remove(deletableEntity);
                        deletableEntity.setIdsTypes(null);
                        this.entityManager.merge(idsTypes);
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
         * Support searching Ids entities with pagination
         */

        private int page;
        private long count;
        private List<Ids> pageItems;

        private Ids example = new Ids();

        public int getPage() {
                return this.page;
        }

        public void setPage(int page) {
                this.page = page;
        }

        public int getPageSize() {
                return 10;
        }

        public Ids getExample() {
                return this.example;
        }

        public void setExample(Ids example) {
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
                Root<Ids> root = countCriteria.from(Ids.class);
                countCriteria = countCriteria.select(builder.count(root)).where(
                                getSearchPredicates(root));
                this.count = this.entityManager.createQuery(countCriteria).getSingleResult();

                // Populate this.pageItems

                CriteriaQuery<Ids> criteria = builder.createQuery(Ids.class);
                root = criteria.from(Ids.class);
                TypedQuery<Ids> query = this.entityManager.createQuery(criteria.select(root).where(getSearchPredicates(root)));
                query.setFirstResult(this.page * getPageSize()).setMaxResults(getPageSize());
                this.pageItems = query.getResultList();
        }

        private Predicate[] getSearchPredicates(Root<Ids> root) {

                CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
                List<Predicate> predicatesList = new ArrayList<Predicate>();

                return predicatesList.toArray(new Predicate[predicatesList.size()]);
        }

        public List<Ids> getPageItems() {
                return this.pageItems;
        }

        public long getCount() {
                return this.count;
        }

        /*
         * Support listing and POSTing back Ids entities (e.g. from inside an HtmlSelectOneMenu)
         */

        public List<Ids> getAll() {
                CriteriaQuery<Ids> criteria = this.entityManager.getCriteriaBuilder().createQuery(Ids.class);
                return this.entityManager.createQuery(criteria.select(criteria.from(Ids.class))).getResultList();
        }

        @Resource
        private SessionContext sessionContext;

        public Converter getConverter() {

                final IdsBean ejbProxy = this.sessionContext.getBusinessObject(IdsBean.class);

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
                                return String.valueOf(((Ids) value).getId());
                        }

        };
   }

        /*
         * Support adding children to bidirectional, one-to-many tables
         */

        private Ids add = new Ids();

        public Ids getAdd() {
               return this.add;
        }

        public Ids getAdded() {
               Ids added = this.add;
               this.add = new Ids();
               return added;
        }

}
