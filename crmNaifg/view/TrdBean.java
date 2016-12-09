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
public class TrdBean implements Serializable {

        private static final long serialVersionUID = 1L;

        /*
         * Support creating and retrieving Trd entities
         */

        private Long id;

        public Long getId() {
                return this.id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        private Trd trd;

        public Trd getTrd() {
                return this.trd;
        }

        public void setTrd(Trd trd) {
                this.trd = trd;
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
                        this.trd = this.example;
                } else {
                        this.trd = findById(getId());
                }
        }

        public Trd findById(Long id) {

                return this.entityManager.find(Trd.class, id);
        }

        /*
         * Support updating and deleting Trd entities
         */

        public String update() {
                this.conversation.end();

                try {
                        if (this.id == null) {
                                this.entityManager.persist(this.trd);
                                return "search?faces-redirect=true";
                        } else {
                                this.entityManager.merge(this.trd);
                                return "view?faces-redirect=true&id=" + this.trd.getId();
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
                        Trd deletableEntity = findById(getId());
                        Iterator<TrdSeries> iterTrdSeries = deletableEntity.getTrdSeries().iterator();
                        for (; iterTrdSeries.hasNext();){
                               TrdSeries nextInTrdSeries = iterTrdSeries.next();
                                nextInTrdSeries.setTrd(null);
                               iterTrdSeries.remove();
                               this.entityManager.merge(nextInTrdSeries);
                        }
               DocumentalRetention gestion = deletableEntity.getGestion();
               gestion.getGestion().remove(deletableEntity);
               deletableEntity.setGestion(null);
               this.entityManager.merge(gestion);
               DocumentalRetention central = deletableEntity.getCentral();
               central.getCentral().remove(deletableEntity);
               deletableEntity.setCentral(null);
               this.entityManager.merge(central);
                        FinalDisposition finalDisposition = deletableEntity.getFinalDisposition();
                        finalDisposition.getTrd().remove(deletableEntity);
                        deletableEntity.setFinalDisposition(null);
                        this.entityManager.merge(finalDisposition);
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
         * Support searching Trd entities with pagination
         */

        private int page;
        private long count;
        private List<Trd> pageItems;

        private Trd example = new Trd();

        public int getPage() {
                return this.page;
        }

        public void setPage(int page) {
                this.page = page;
        }

        public int getPageSize() {
                return 10;
        }

        public Trd getExample() {
                return this.example;
        }

        public void setExample(Trd example) {
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
                Root<Trd> root = countCriteria.from(Trd.class);
                countCriteria = countCriteria.select(builder.count(root)).where(
                                getSearchPredicates(root));
                this.count = this.entityManager.createQuery(countCriteria).getSingleResult();

                // Populate this.pageItems

                CriteriaQuery<Trd> criteria = builder.createQuery(Trd.class);
                root = criteria.from(Trd.class);
                TypedQuery<Trd> query = this.entityManager.createQuery(criteria.select(root).where(getSearchPredicates(root)));
                query.setFirstResult(this.page * getPageSize()).setMaxResults(getPageSize());
                this.pageItems = query.getResultList();
        }

        private Predicate[] getSearchPredicates(Root<Trd> root) {

                CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
                List<Predicate> predicatesList = new ArrayList<Predicate>();

                return predicatesList.toArray(new Predicate[predicatesList.size()]);
        }

        public List<Trd> getPageItems() {
                return this.pageItems;
        }

        public long getCount() {
                return this.count;
        }

        /*
         * Support listing and POSTing back Trd entities (e.g. from inside an HtmlSelectOneMenu)
         */

        public List<Trd> getAll() {
                CriteriaQuery<Trd> criteria = this.entityManager.getCriteriaBuilder().createQuery(Trd.class);
                return this.entityManager.createQuery(criteria.select(criteria.from(Trd.class))).getResultList();
        }

        @Resource
        private SessionContext sessionContext;

        public Converter getConverter() {

                final TrdBean ejbProxy = this.sessionContext.getBusinessObject(TrdBean.class);

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
                                return String.valueOf(((Trd) value).getId());
                        }

        };
   }

        /*
         * Support adding children to bidirectional, one-to-many tables
         */

        private Trd add = new Trd();

        public Trd getAdd() {
               return this.add;
        }

        public Trd getAdded() {
               Trd added = this.add;
               this.add = new Trd();
               return added;
        }

}
