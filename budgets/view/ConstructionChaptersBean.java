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
public class ConstructionChaptersBean implements Serializable {

        private static final long serialVersionUID = 1L;

        /*
         * Support creating and retrieving ConstructionChapters entities
         */

        private Long id;

        public Long getId() {
                return this.id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        private ConstructionChapters constructionChapters;

        public ConstructionChapters getConstructionChapters() {
                return this.constructionChapters;
        }

        public void setConstructionChapters(ConstructionChapters constructionChapters) {
                this.constructionChapters = constructionChapters;
        }

        @Inject
        private Conversation conversation;

        @PersistenceContext(unitName = "budgetsPU-JTA", type = PersistenceContextType.EXTENDED)
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
                        this.constructionChapters = this.example;
                } else {
                        this.constructionChapters = findById(getId());
                }
        }

        public ConstructionChapters findById(Long id) {

                return this.entityManager.find(ConstructionChapters.class, id);
        }

        /*
         * Support updating and deleting ConstructionChapters entities
         */

        public String update() {
                this.conversation.end();

                try {
                        if (this.id == null) {
                                this.entityManager.persist(this.constructionChapters);
                                return "search?faces-redirect=true";
                        } else {
                                this.entityManager.merge(this.constructionChapters);
                                return "view?faces-redirect=true&id=" + this.constructionChapters.getId();
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
                        ConstructionChapters deletableEntity = findById(getId());
                        Iterator<ConstructionActivities> iterConstructionActivities = deletableEntity.getConstructionActivities().iterator();
                        for (; iterConstructionActivities.hasNext();){
                               ConstructionActivities nextInConstructionActivities = iterConstructionActivities.next();
                                nextInConstructionActivities.setConstructionChapters(null);
                               iterConstructionActivities.remove();
                               this.entityManager.merge(nextInConstructionActivities);
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
         * Support searching ConstructionChapters entities with pagination
         */

        private int page;
        private long count;
        private List<ConstructionChapters> pageItems;

        private ConstructionChapters example = new ConstructionChapters();

        public int getPage() {
                return this.page;
        }

        public void setPage(int page) {
                this.page = page;
        }

        public int getPageSize() {
                return 10;
        }

        public ConstructionChapters getExample() {
                return this.example;
        }

        public void setExample(ConstructionChapters example) {
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
                Root<ConstructionChapters> root = countCriteria.from(ConstructionChapters.class);
                countCriteria = countCriteria.select(builder.count(root)).where(
                                getSearchPredicates(root));
                this.count = this.entityManager.createQuery(countCriteria).getSingleResult();

                // Populate this.pageItems

                CriteriaQuery<ConstructionChapters> criteria = builder.createQuery(ConstructionChapters.class);
                root = criteria.from(ConstructionChapters.class);
                TypedQuery<ConstructionChapters> query = this.entityManager.createQuery(criteria.select(root).where(getSearchPredicates(root)));
                query.setFirstResult(this.page * getPageSize()).setMaxResults(getPageSize());
                this.pageItems = query.getResultList();
        }

        private Predicate[] getSearchPredicates(Root<ConstructionChapters> root) {

                CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
                List<Predicate> predicatesList = new ArrayList<Predicate>();

                return predicatesList.toArray(new Predicate[predicatesList.size()]);
        }

        public List<ConstructionChapters> getPageItems() {
                return this.pageItems;
        }

        public long getCount() {
                return this.count;
        }

        /*
         * Support listing and POSTing back ConstructionChapters entities (e.g. from inside an HtmlSelectOneMenu)
         */

        public List<ConstructionChapters> getAll() {
                CriteriaQuery<ConstructionChapters> criteria = this.entityManager.getCriteriaBuilder().createQuery(ConstructionChapters.class);
                return this.entityManager.createQuery(criteria.select(criteria.from(ConstructionChapters.class))).getResultList();
        }

        @Resource
        private SessionContext sessionContext;

        public Converter getConverter() {

                final ConstructionChaptersBean ejbProxy = this.sessionContext.getBusinessObject(ConstructionChaptersBean.class);

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
                                return String.valueOf(((ConstructionChapters) value).getId());
                        }

        };
   }

        /*
         * Support adding children to bidirectional, one-to-many tables
         */

        private ConstructionChapters add = new ConstructionChapters();

        public ConstructionChapters getAdd() {
               return this.add;
        }

        public ConstructionChapters getAdded() {
               ConstructionChapters added = this.add;
               this.add = new ConstructionChapters();
               return added;
        }

}
