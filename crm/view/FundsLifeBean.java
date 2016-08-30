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
public class FundsLifeBean implements Serializable {

        private static final long serialVersionUID = 1L;

        /*
         * Support creating and retrieving FundsLife entities
         */

        private Long id;

        public Long getId() {
                return this.id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        private FundsLife fundsLife;

        public FundsLife getFundsLife() {
                return this.fundsLife;
        }

        public void setFundsLife(FundsLife fundsLife) {
                this.fundsLife = fundsLife;
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
                        this.fundsLife = this.example;
                } else {
                        this.fundsLife = findById(getId());
                }
        }

        public FundsLife findById(Long id) {

                return this.entityManager.find(FundsLife.class, id);
        }

        /*
         * Support updating and deleting FundsLife entities
         */

        public String update() {
                this.conversation.end();

                try {
                        if (this.id == null) {
                                this.entityManager.persist(this.fundsLife);
                                return "search?faces-redirect=true";
                        } else {
                                this.entityManager.merge(this.fundsLife);
                                return "view?faces-redirect=true&id=" + this.fundsLife.getId();
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
                        FundsLife deletableEntity = findById(getId());
                        Iterator<Funds> iterFunds = deletableEntity.getFunds().iterator();
                        for (; iterFunds.hasNext();){
                               Funds nextInFunds = iterFunds.next();
                                nextInFunds.setFundsLife(null);
                               iterFunds.remove();
                               this.entityManager.merge(nextInFunds);
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
         * Support searching FundsLife entities with pagination
         */

        private int page;
        private long count;
        private List<FundsLife> pageItems;

        private FundsLife example = new FundsLife();

        public int getPage() {
                return this.page;
        }

        public void setPage(int page) {
                this.page = page;
        }

        public int getPageSize() {
                return 10;
        }

        public FundsLife getExample() {
                return this.example;
        }

        public void setExample(FundsLife example) {
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
                Root<FundsLife> root = countCriteria.from(FundsLife.class);
                countCriteria = countCriteria.select(builder.count(root)).where(
                                getSearchPredicates(root));
                this.count = this.entityManager.createQuery(countCriteria).getSingleResult();

                // Populate this.pageItems

                CriteriaQuery<FundsLife> criteria = builder.createQuery(FundsLife.class);
                root = criteria.from(FundsLife.class);
                TypedQuery<FundsLife> query = this.entityManager.createQuery(criteria.select(root).where(getSearchPredicates(root)));
                query.setFirstResult(this.page * getPageSize()).setMaxResults(getPageSize());
                this.pageItems = query.getResultList();
        }

        private Predicate[] getSearchPredicates(Root<FundsLife> root) {

                CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
                List<Predicate> predicatesList = new ArrayList<Predicate>();

                return predicatesList.toArray(new Predicate[predicatesList.size()]);
        }

        public List<FundsLife> getPageItems() {
                return this.pageItems;
        }

        public long getCount() {
                return this.count;
        }

        /*
         * Support listing and POSTing back FundsLife entities (e.g. from inside an HtmlSelectOneMenu)
         */

        public List<FundsLife> getAll() {
                CriteriaQuery<FundsLife> criteria = this.entityManager.getCriteriaBuilder().createQuery(FundsLife.class);
                return this.entityManager.createQuery(criteria.select(criteria.from(FundsLife.class))).getResultList();
        }

        @Resource
        private SessionContext sessionContext;

        public Converter getConverter() {

                final FundsLifeBean ejbProxy = this.sessionContext.getBusinessObject(FundsLifeBean.class);

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
                                return String.valueOf(((FundsLife) value).getId());
                        }

        };
   }

        /*
         * Support adding children to bidirectional, one-to-many tables
         */

        private FundsLife add = new FundsLife();

        public FundsLife getAdd() {
               return this.add;
        }

        public FundsLife getAdded() {
               FundsLife added = this.add;
               this.add = new FundsLife();
               return added;
        }

}
