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
public class VersionsControlsBean implements Serializable {

        private static final long serialVersionUID = 1L;

        /*
         * Support creating and retrieving VersionsControls entities
         */

        private Long id;

        public Long getId() {
                return this.id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        private VersionsControls versionsControls;

        public VersionsControls getVersionsControls() {
                return this.versionsControls;
        }

        public void setVersionsControls(VersionsControls versionsControls) {
                this.versionsControls = versionsControls;
        }

        @Inject
        private Conversation conversation;

        @PersistenceContext(unitName = "crmNaifgPU-JTA", type = PersistenceContextType.EXTENDED)
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
                        this.versionsControls = this.example;
                } else {
                        this.versionsControls = findById(getId());
                }
        }

        public VersionsControls findById(Long id) {

                return this.entityManager.find(VersionsControls.class, id);
        }

        /*
         * Support updating and deleting VersionsControls entities
         */

        public String update() {
                this.conversation.end();

                try {
                        if (this.id == null) {
                                this.entityManager.persist(this.versionsControls);
                                return "search?faces-redirect=true";
                        } else {
                                this.entityManager.merge(this.versionsControls);
                                return "view?faces-redirect=true&id=" + this.versionsControls.getId();
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
                        VersionsControls deletableEntity = findById(getId());
                        DocumentalsUnits documentalsUnits = deletableEntity.getDocumentalsUnits();
                        documentalsUnits.getVersionsControls().remove(deletableEntity);
                        deletableEntity.setDocumentalsUnits(null);
                        this.entityManager.merge(documentalsUnits);
                        Series series = deletableEntity.getSeries();
                        series.getVersionsControls().remove(deletableEntity);
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
         * Support searching VersionsControls entities with pagination
         */

        private int page;
        private long count;
        private List<VersionsControls> pageItems;

        private VersionsControls example = new VersionsControls();

        public int getPage() {
                return this.page;
        }

        public void setPage(int page) {
                this.page = page;
        }

        public int getPageSize() {
                return 10;
        }

        public VersionsControls getExample() {
                return this.example;
        }

        public void setExample(VersionsControls example) {
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
                Root<VersionsControls> root = countCriteria.from(VersionsControls.class);
                countCriteria = countCriteria.select(builder.count(root)).where(
                                getSearchPredicates(root));
                this.count = this.entityManager.createQuery(countCriteria).getSingleResult();

                // Populate this.pageItems

                CriteriaQuery<VersionsControls> criteria = builder.createQuery(VersionsControls.class);
                root = criteria.from(VersionsControls.class);
                TypedQuery<VersionsControls> query = this.entityManager.createQuery(criteria.select(root).where(getSearchPredicates(root)));
                query.setFirstResult(this.page * getPageSize()).setMaxResults(getPageSize());
                this.pageItems = query.getResultList();
        }

        private Predicate[] getSearchPredicates(Root<VersionsControls> root) {

                CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
                List<Predicate> predicatesList = new ArrayList<Predicate>();

                return predicatesList.toArray(new Predicate[predicatesList.size()]);
        }

        public List<VersionsControls> getPageItems() {
                return this.pageItems;
        }

        public long getCount() {
                return this.count;
        }

        /*
         * Support listing and POSTing back VersionsControls entities (e.g. from inside an HtmlSelectOneMenu)
         */

        public List<VersionsControls> getAll() {
                CriteriaQuery<VersionsControls> criteria = this.entityManager.getCriteriaBuilder().createQuery(VersionsControls.class);
                return this.entityManager.createQuery(criteria.select(criteria.from(VersionsControls.class))).getResultList();
        }

        @Resource
        private SessionContext sessionContext;

        public Converter getConverter() {

                final VersionsControlsBean ejbProxy = this.sessionContext.getBusinessObject(VersionsControlsBean.class);

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
                                return String.valueOf(((VersionsControls) value).getId());
                        }

        };
   }

        /*
         * Support adding children to bidirectional, one-to-many tables
         */

        private VersionsControls add = new VersionsControls();

        public VersionsControls getAdd() {
               return this.add;
        }

        public VersionsControls getAdded() {
               VersionsControls added = this.add;
               this.add = new VersionsControls();
               return added;
        }

}
