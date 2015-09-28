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

import import co.simasoft.models.dev.tasks.*;
import import co.simasoft.models.core.persons.*;
import import co.simasoft.models.core.archival.*;
import import co.simasoft.models.core.sites.*;
import import javax.persistence.Temporal;
import import javax.persistence.TemporalType;
import import org.hibernate.search.annotations.DateBridge;
import import org.hibernate.search.annotations.Resolution;
import import org.hibernate.search.annotations.Analyze;
import import org.hibernate.search.annotations.DocumentId;
import import org.hibernate.search.annotations.Field;
import import org.hibernate.search.annotations.Index;
import import org.hibernate.search.annotations.Indexed;
import import org.hibernate.search.annotations.Store;
import import javax.persistence.Lob;
import import javax.persistence.ManyToMany;
import import javax.persistence.OneToMany;
import import javax.persistence.ManyToOne;
import java.util.Iterator;

@Named
@Stateful
@ConversationScoped
public class DiariesBean implements Serializable{

        private static final long serialVersionUID = 1L;

        /*
         * Support creating and retrieving Diaries entities
         */

        private Long id;

        public Long getId() {
                return this.id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        private Diaries diaries;

        public Diaries getDiaries() {
                return this.diaries;
        }

        public void setDiaries(Diaries diaries) {
                this.diaries = diaries;
        }

        @Inject
        private Conversation conversation;

        @PersistenceContext(unitName = "tasksPU-JTA", type = PersistenceContextType.EXTENDED)
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
                        this.diaries = this.example;
                } else {
                        this.diaries = findById(getId());
                }
        }

        public Diaries findById(Long id) {

                return this.entityManager.find(Diaries.class, id);
        }

        /*
         * Support updating and deleting Diaries entities
        */

        public String update() {
                this.conversation.end();

                try {
                        if (this.id == null) {
                                this.entityManager.persist(this.diaries);
                                return "search?faces-redirect=true";
                        } else {
                                this.entityManager.merge(this.diaries);
                                return "view?faces-redirect=true&id=" + this.diaries.getId();
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
                        Diaries deletableEntity = findById(getId());
                        Activities activities = deletableEntity.getActivities();
                        activities.getDiaries().remove(deletableEntity);
                        deletableEntity.setActivities(null);
                        this.entityManager.merge(activities);
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
         * Support searching Diaries entities with pagination
         */

        private int page;
        private long count;
        private List<Diaries> pageItems;

        private Diaries example = new Diaries();

        public int getPage() {
                return this.page;
        }

        public void setPage(int page) {
                this.page = page;
        }

        public int getPageSize() {
                return 10;
        }

        public Diaries getExample() {
                return this.example;
        }

        public void setExample(Diaries example) {
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
                Root<Diaries> root = countCriteria.from(Diaries.class);
                countCriteria = countCriteria.select(builder.count(root)).where(
                                getSearchPredicates(root));
                this.count = this.entityManager.createQuery(countCriteria).getSingleResult();

                // Populate this.pageItems

                CriteriaQuery<Diaries> criteria = builder.createQuery(Diaries.class);
                root = criteria.from(Diaries.class);
                TypedQuery<Diaries> query = this.entityManager.createQuery(criteria.select(root).where(getSearchPredicates(root)));
                query.setFirstResult(this.page * getPageSize()).setMaxResults(getPageSize());
                this.pageItems = query.getResultList();
        }

        private Predicate[] getSearchPredicates(Root<Diaries> root) {

                CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
                List<Predicate> predicatesList = new ArrayList<Predicate>();

                return predicatesList.toArray(new Predicate[predicatesList.size()]);
        }

        public List<Diaries> getPageItems() {
                return this.pageItems;
        }

        public long getCount() {
                return this.count;
        }

        /*
         * Support listing and POSTing back Diaries entities (e.g. from inside an HtmlSelectOneMenu)
         */

        public List<Diaries> getAll() {
                CriteriaQuery<Diaries> criteria = this.entityManager.getCriteriaBuilder().createQuery(Diaries.class);
                return this.entityManager.createQuery(criteria.select(criteria.from(Diaries.class))).getResultList();
        }

        @Resource
        private SessionContext sessionContext;

        public Converter getConverter() {

                final DiariesBean ejbProxy = this.sessionContext.getBusinessObject(DiariesBean.class);

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
                       return String.valueOf(((Diaries) value).getId());
                }

        };
   }

        /*
         * Support adding children to bidirectional, one-to-many tables
         */

        private Diaries add = new Diaries();

        public Diaries getAdd() {
               return this.add;
        }

        public Diaries getAdded() {
               Diaries added = this.add;
               this.add = new Diaries();
               return added;
        }

}
