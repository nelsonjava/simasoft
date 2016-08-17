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
public class IdsTypesBean implements Serializable {

        private static final long serialVersionUID = 1L;

        /*
         * Support creating and retrieving IdsTypes entities
         */

        private Long id;

        public Long getId() {
                return this.id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        private IdsTypes idsTypes;

        public IdsTypes getIdsTypes() {
                return this.idsTypes;
        }

        public void setIdsTypes(IdsTypes idsTypes) {
                this.idsTypes = idsTypes;
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
                        this.idsTypes = this.example;
                } else {
                        this.idsTypes = findById(getId());
                }
        }

        public IdsTypes findById(Long id) {

                return this.entityManager.find(IdsTypes.class, id);
        }

        /*
         * Support updating and deleting IdsTypes entities
         */

        public String update() {
                this.conversation.end();

                try {
                        if (this.id == null) {
                                this.entityManager.persist(this.idsTypes);
                                return "search?faces-redirect=true";
                        } else {
                                this.entityManager.merge(this.idsTypes);
                                return "view?faces-redirect=true&id=" + this.idsTypes.getId();
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
                        IdsTypes deletableEntity = findById(getId());
                        Iterator<Ids> iterIds = deletableEntity.getIds().iterator();
                        for (; iterIds.hasNext();){
                               Ids nextInIds = iterIds.next();
                                nextInIds.setIdsTypes(null);
                               iterIds.remove();
                               this.entityManager.merge(nextInIds);
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
         * Support searching IdsTypes entities with pagination
         */

        private int page;
        private long count;
        private List<IdsTypes> pageItems;

        private IdsTypes example = new IdsTypes();

        public int getPage() {
                return this.page;
        }

        public void setPage(int page) {
                this.page = page;
        }

        public int getPageSize() {
                return 10;
        }

        public IdsTypes getExample() {
                return this.example;
        }

        public void setExample(IdsTypes example) {
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
                Root<IdsTypes> root = countCriteria.from(IdsTypes.class);
                countCriteria = countCriteria.select(builder.count(root)).where(
                                getSearchPredicates(root));
                this.count = this.entityManager.createQuery(countCriteria).getSingleResult();

                // Populate this.pageItems

                CriteriaQuery<IdsTypes> criteria = builder.createQuery(IdsTypes.class);
                root = criteria.from(IdsTypes.class);
                TypedQuery<IdsTypes> query = this.entityManager.createQuery(criteria.select(root).where(getSearchPredicates(root)));
                query.setFirstResult(this.page * getPageSize()).setMaxResults(getPageSize());
                this.pageItems = query.getResultList();
        }

        private Predicate[] getSearchPredicates(Root<IdsTypes> root) {

                CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
                List<Predicate> predicatesList = new ArrayList<Predicate>();

                return predicatesList.toArray(new Predicate[predicatesList.size()]);
        }

        public List<IdsTypes> getPageItems() {
                return this.pageItems;
        }

        public long getCount() {
                return this.count;
        }

        /*
         * Support listing and POSTing back IdsTypes entities (e.g. from inside an HtmlSelectOneMenu)
         */

        public List<IdsTypes> getAll() {
                CriteriaQuery<IdsTypes> criteria = this.entityManager.getCriteriaBuilder().createQuery(IdsTypes.class);
                return this.entityManager.createQuery(criteria.select(criteria.from(IdsTypes.class))).getResultList();
        }

        @Resource
        private SessionContext sessionContext;

        public Converter getConverter() {

                final IdsTypesBean ejbProxy = this.sessionContext.getBusinessObject(IdsTypesBean.class);

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
                                return String.valueOf(((IdsTypes) value).getId());
                        }

        };
   }

        /*
         * Support adding children to bidirectional, one-to-many tables
         */

        private IdsTypes add = new IdsTypes();

        public IdsTypes getAdd() {
               return this.add;
        }

        public IdsTypes getAdded() {
               IdsTypes added = this.add;
               this.add = new IdsTypes();
               return added;
        }

}
