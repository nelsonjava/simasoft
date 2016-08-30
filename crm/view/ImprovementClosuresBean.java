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
public class ImprovementClosuresBean implements Serializable {

        private static final long serialVersionUID = 1L;

        /*
         * Support creating and retrieving ImprovementClosures entities
         */

        private Long id;

        public Long getId() {
                return this.id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        private ImprovementClosures improvementClosures;

        public ImprovementClosures getImprovementClosures() {
                return this.improvementClosures;
        }

        public void setImprovementClosures(ImprovementClosures improvementClosures) {
                this.improvementClosures = improvementClosures;
        }

        @Inject
        private Conversation conversation;

        @PersistenceContext(unitName = "crmPU-JTA", type = PersistenceContextType.EXTENDED)
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
                        this.improvementClosures = this.example;
                } else {
                        this.improvementClosures = findById(getId());
                }
        }

        public ImprovementClosures findById(Long id) {

                return this.entityManager.find(ImprovementClosures.class, id);
        }

        /*
         * Support updating and deleting ImprovementClosures entities
         */

        public String update() {
                this.conversation.end();

                try {
                        if (this.id == null) {
                                this.entityManager.persist(this.improvementClosures);
                                return "search?faces-redirect=true";
                        } else {
                                this.entityManager.merge(this.improvementClosures);
                                return "view?faces-redirect=true&id=" + this.improvementClosures.getId();
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
                        ImprovementClosures deletableEntity = findById(getId());
                        Iterator<ClosingActivities> iterClosingActivities = deletableEntity.getClosingActivities().iterator();
                        for (; iterClosingActivities.hasNext();){
                               ClosingActivities nextInClosingActivities = iterClosingActivities.next();
                                nextInClosingActivities.setImprovementClosures(null);
                               iterClosingActivities.remove();
                               this.entityManager.merge(nextInClosingActivities);
                        }
                        Iterator<ContinualImprovements> iterContinualImprovements = deletableEntity.getContinualImprovements().iterator();
                        for (; iterContinualImprovements.hasNext();){
                               ContinualImprovements nextInContinualImprovements = iterContinualImprovements.next();
                                nextInContinualImprovements.setImprovementClosures(null);
                               iterContinualImprovements.remove();
                               this.entityManager.merge(nextInContinualImprovements);
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
         * Support searching ImprovementClosures entities with pagination
         */

        private int page;
        private long count;
        private List<ImprovementClosures> pageItems;

        private ImprovementClosures example = new ImprovementClosures();

        public int getPage() {
                return this.page;
        }

        public void setPage(int page) {
                this.page = page;
        }

        public int getPageSize() {
                return 10;
        }

        public ImprovementClosures getExample() {
                return this.example;
        }

        public void setExample(ImprovementClosures example) {
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
                Root<ImprovementClosures> root = countCriteria.from(ImprovementClosures.class);
                countCriteria = countCriteria.select(builder.count(root)).where(
                                getSearchPredicates(root));
                this.count = this.entityManager.createQuery(countCriteria).getSingleResult();

                // Populate this.pageItems

                CriteriaQuery<ImprovementClosures> criteria = builder.createQuery(ImprovementClosures.class);
                root = criteria.from(ImprovementClosures.class);
                TypedQuery<ImprovementClosures> query = this.entityManager.createQuery(criteria.select(root).where(getSearchPredicates(root)));
                query.setFirstResult(this.page * getPageSize()).setMaxResults(getPageSize());
                this.pageItems = query.getResultList();
        }

        private Predicate[] getSearchPredicates(Root<ImprovementClosures> root) {

                CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
                List<Predicate> predicatesList = new ArrayList<Predicate>();

                return predicatesList.toArray(new Predicate[predicatesList.size()]);
        }

        public List<ImprovementClosures> getPageItems() {
                return this.pageItems;
        }

        public long getCount() {
                return this.count;
        }

        /*
         * Support listing and POSTing back ImprovementClosures entities (e.g. from inside an HtmlSelectOneMenu)
         */

        public List<ImprovementClosures> getAll() {
                CriteriaQuery<ImprovementClosures> criteria = this.entityManager.getCriteriaBuilder().createQuery(ImprovementClosures.class);
                return this.entityManager.createQuery(criteria.select(criteria.from(ImprovementClosures.class))).getResultList();
        }

        @Resource
        private SessionContext sessionContext;

        public Converter getConverter() {

                final ImprovementClosuresBean ejbProxy = this.sessionContext.getBusinessObject(ImprovementClosuresBean.class);

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
                                return String.valueOf(((ImprovementClosures) value).getId());
                        }

        };
   }

        /*
         * Support adding children to bidirectional, one-to-many tables
         */

        private ImprovementClosures add = new ImprovementClosures();

        public ImprovementClosures getAdd() {
               return this.add;
        }

        public ImprovementClosures getAdded() {
               ImprovementClosures added = this.add;
               this.add = new ImprovementClosures();
               return added;
        }

}
