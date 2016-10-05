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
public class TasksBean implements Serializable {

        private static final long serialVersionUID = 1L;

        /*
         * Support creating and retrieving Tasks entities
         */

        private Long id;

        public Long getId() {
                return this.id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        private Tasks tasks;

        public Tasks getTasks() {
                return this.tasks;
        }

        public void setTasks(Tasks tasks) {
                this.tasks = tasks;
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
                        this.tasks = this.example;
                } else {
                        this.tasks = findById(getId());
                }
        }

        public Tasks findById(Long id) {

                return this.entityManager.find(Tasks.class, id);
        }

        /*
         * Support updating and deleting Tasks entities
         */

        public String update() {
                this.conversation.end();

                try {
                        if (this.id == null) {
                                this.entityManager.persist(this.tasks);
                                return "search?faces-redirect=true";
                        } else {
                                this.entityManager.merge(this.tasks);
                                return "view?faces-redirect=true&id=" + this.tasks.getId();
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
                        Tasks deletableEntity = findById(getId());
                        Iterator<Diaries> iterDiaries = deletableEntity.getDiaries().iterator();
                        for (; iterDiaries.hasNext();){
                               Diaries nextInDiaries = iterDiaries.next();
                                nextInDiaries.setTasks(null);
                               iterDiaries.remove();
                               this.entityManager.merge(nextInDiaries);
                        }
                        Chapters chapters = deletableEntity.getChapters();
                        chapters.getTasks().remove(deletableEntity);
                        deletableEntity.setChapters(null);
                        this.entityManager.merge(chapters);
                        Persons persons = deletableEntity.getPersons();
                        persons.getTasks().remove(deletableEntity);
                        deletableEntity.setPersons(null);
                        this.entityManager.merge(persons);
                        Activities activities = deletableEntity.getActivities();
                        activities.getTasks().remove(deletableEntity);
                        deletableEntity.setActivities(null);
                        this.entityManager.merge(activities);
                        Priorities priorities = deletableEntity.getPriorities();
                        priorities.getTasks().remove(deletableEntity);
                        deletableEntity.setPriorities(null);
                        this.entityManager.merge(priorities);
                        Sections sections = deletableEntity.getSections();
                        sections.getTasks().remove(deletableEntity);
                        deletableEntity.setSections(null);
                        this.entityManager.merge(sections);
                        Series series = deletableEntity.getSeries();
                        series.getTasks().remove(deletableEntity);
                        deletableEntity.setSeries(null);
                        this.entityManager.merge(series);
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
         * Support searching Tasks entities with pagination
         */

        private int page;
        private long count;
        private List<Tasks> pageItems;

        private Tasks example = new Tasks();

        public int getPage() {
                return this.page;
        }

        public void setPage(int page) {
                this.page = page;
        }

        public int getPageSize() {
                return 10;
        }

        public Tasks getExample() {
                return this.example;
        }

        public void setExample(Tasks example) {
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
                Root<Tasks> root = countCriteria.from(Tasks.class);
                countCriteria = countCriteria.select(builder.count(root)).where(
                                getSearchPredicates(root));
                this.count = this.entityManager.createQuery(countCriteria).getSingleResult();

                // Populate this.pageItems

                CriteriaQuery<Tasks> criteria = builder.createQuery(Tasks.class);
                root = criteria.from(Tasks.class);
                TypedQuery<Tasks> query = this.entityManager.createQuery(criteria.select(root).where(getSearchPredicates(root)));
                query.setFirstResult(this.page * getPageSize()).setMaxResults(getPageSize());
                this.pageItems = query.getResultList();
        }

        private Predicate[] getSearchPredicates(Root<Tasks> root) {

                CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
                List<Predicate> predicatesList = new ArrayList<Predicate>();

                return predicatesList.toArray(new Predicate[predicatesList.size()]);
        }

        public List<Tasks> getPageItems() {
                return this.pageItems;
        }

        public long getCount() {
                return this.count;
        }

        /*
         * Support listing and POSTing back Tasks entities (e.g. from inside an HtmlSelectOneMenu)
         */

        public List<Tasks> getAll() {
                CriteriaQuery<Tasks> criteria = this.entityManager.getCriteriaBuilder().createQuery(Tasks.class);
                return this.entityManager.createQuery(criteria.select(criteria.from(Tasks.class))).getResultList();
        }

        @Resource
        private SessionContext sessionContext;

        public Converter getConverter() {

                final TasksBean ejbProxy = this.sessionContext.getBusinessObject(TasksBean.class);

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
                                return String.valueOf(((Tasks) value).getId());
                        }

        };
   }

        /*
         * Support adding children to bidirectional, one-to-many tables
         */

        private Tasks add = new Tasks();

        public Tasks getAdd() {
               return this.add;
        }

        public Tasks getAdded() {
               Tasks added = this.add;
               this.add = new Tasks();
               return added;
        }

}
