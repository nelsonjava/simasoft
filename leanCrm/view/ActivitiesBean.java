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
public class ActivitiesBean implements Serializable {

        private static final long serialVersionUID = 1L;

        /*
         * Support creating and retrieving Activities entities
         */

        private Long id;

        public Long getId() {
                return this.id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        private Activities activities;

        public Activities getActivities() {
                return this.activities;
        }

        public void setActivities(Activities activities) {
                this.activities = activities;
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
                        this.activities = this.example;
                } else {
                        this.activities = findById(getId());
                }
        }

        public Activities findById(Long id) {

                return this.entityManager.find(Activities.class, id);
        }

        /*
         * Support updating and deleting Activities entities
         */

        public String update() {
                this.conversation.end();

                try {
                        if (this.id == null) {
                                this.entityManager.persist(this.activities);
                                return "search?faces-redirect=true";
                        } else {
                                this.entityManager.merge(this.activities);
                                return "view?faces-redirect=true&id=" + this.activities.getId();
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
                        Activities deletableEntity = findById(getId());
          Iterator<Activities> iterObjHijos = deletableEntity.getObjHijos().iterator();
          for (; iterObjHijos.hasNext();){
             Activities nextInObjHijos = iterObjHijos.next();
             nextInObjHijos.setObjPadre(null);
             iterObjHijos.remove();
             this.entityManager.merge(nextInObjHijos);
          }
                        Iterator<Tasks> iterTasks = deletableEntity.getTasks().iterator();
                        for (; iterTasks.hasNext();){
                               Tasks nextInTasks = iterTasks.next();
                                nextInTasks.setActivities(null);
                               iterTasks.remove();
                               this.entityManager.merge(nextInTasks);
                        }
                        Books books = deletableEntity.getBooks();
                        books.getActivities().remove(deletableEntity);
                        deletableEntity.setBooks(null);
                        this.entityManager.merge(books);
                        Persons persons = deletableEntity.getPersons();
                        persons.getActivities().remove(deletableEntity);
                        deletableEntity.setPersons(null);
                        this.entityManager.merge(persons);
   1      Activities objPadre = deletableEntity.getObjPadre();
   1      objPadre.getObjHijos().remove(deletableEntity);
   1      deletableEntity.setObjPadre(null);
   1      this.entityManager.merge(objPadre);
                        ActivitiesTypes activitiesTypes = deletableEntity.getActivitiesTypes();
                        activitiesTypes.getActivities().remove(deletableEntity);
                        deletableEntity.setActivitiesTypes(null);
                        this.entityManager.merge(activitiesTypes);
                        Sections sections = deletableEntity.getSections();
                        sections.getActivities().remove(deletableEntity);
                        deletableEntity.setSections(null);
                        this.entityManager.merge(sections);
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
         * Support searching Activities entities with pagination
         */

        private int page;
        private long count;
        private List<Activities> pageItems;

        private Activities example = new Activities();

        public int getPage() {
                return this.page;
        }

        public void setPage(int page) {
                this.page = page;
        }

        public int getPageSize() {
                return 10;
        }

        public Activities getExample() {
                return this.example;
        }

        public void setExample(Activities example) {
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
                Root<Activities> root = countCriteria.from(Activities.class);
                countCriteria = countCriteria.select(builder.count(root)).where(
                                getSearchPredicates(root));
                this.count = this.entityManager.createQuery(countCriteria).getSingleResult();

                // Populate this.pageItems

                CriteriaQuery<Activities> criteria = builder.createQuery(Activities.class);
                root = criteria.from(Activities.class);
                TypedQuery<Activities> query = this.entityManager.createQuery(criteria.select(root).where(getSearchPredicates(root)));
                query.setFirstResult(this.page * getPageSize()).setMaxResults(getPageSize());
                this.pageItems = query.getResultList();
        }

        private Predicate[] getSearchPredicates(Root<Activities> root) {

                CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
                List<Predicate> predicatesList = new ArrayList<Predicate>();

                return predicatesList.toArray(new Predicate[predicatesList.size()]);
        }

        public List<Activities> getPageItems() {
                return this.pageItems;
        }

        public long getCount() {
                return this.count;
        }

        /*
         * Support listing and POSTing back Activities entities (e.g. from inside an HtmlSelectOneMenu)
         */

        public List<Activities> getAll() {
                CriteriaQuery<Activities> criteria = this.entityManager.getCriteriaBuilder().createQuery(Activities.class);
                return this.entityManager.createQuery(criteria.select(criteria.from(Activities.class))).getResultList();
        }

        @Resource
        private SessionContext sessionContext;

        public Converter getConverter() {

                final ActivitiesBean ejbProxy = this.sessionContext.getBusinessObject(ActivitiesBean.class);

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
                                return String.valueOf(((Activities) value).getId());
                        }

        };
   }

        /*
         * Support adding children to bidirectional, one-to-many tables
         */

        private Activities add = new Activities();

        public Activities getAdd() {
               return this.add;
        }

        public Activities getAdded() {
               Activities added = this.add;
               this.add = new Activities();
               return added;
        }

}
