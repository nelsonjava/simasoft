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
public class TelephonesBean implements Serializable {

        private static final long serialVersionUID = 1L;

        /*
         * Support creating and retrieving Telephones entities
         */

        private Long id;

        public Long getId() {
                return this.id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        private Telephones telephones;

        public Telephones getTelephones() {
                return this.telephones;
        }

        public void setTelephones(Telephones telephones) {
                this.telephones = telephones;
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
                        this.telephones = this.example;
                } else {
                        this.telephones = findById(getId());
                }
        }

        public Telephones findById(Long id) {

                return this.entityManager.find(Telephones.class, id);
        }

        /*
         * Support updating and deleting Telephones entities
         */

        public String update() {
                this.conversation.end();

                try {
                        if (this.id == null) {
                                this.entityManager.persist(this.telephones);
                                return "search?faces-redirect=true";
                        } else {
                                this.entityManager.merge(this.telephones);
                                return "view?faces-redirect=true&id=" + this.telephones.getId();
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
                        Telephones deletableEntity = findById(getId());
                        Persons persons = deletableEntity.getPersons();
                        persons.getTelephones().remove(deletableEntity);
                        deletableEntity.setPersons(null);
                        this.entityManager.merge(persons);
                        TelephonesTypes telephonesTypes = deletableEntity.getTelephonesTypes();
                        telephonesTypes.getTelephones().remove(deletableEntity);
                        deletableEntity.setTelephonesTypes(null);
                        this.entityManager.merge(telephonesTypes);
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
         * Support searching Telephones entities with pagination
         */

        private int page;
        private long count;
        private List<Telephones> pageItems;

        private Telephones example = new Telephones();

        public int getPage() {
                return this.page;
        }

        public void setPage(int page) {
                this.page = page;
        }

        public int getPageSize() {
                return 10;
        }

        public Telephones getExample() {
                return this.example;
        }

        public void setExample(Telephones example) {
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
                Root<Telephones> root = countCriteria.from(Telephones.class);
                countCriteria = countCriteria.select(builder.count(root)).where(
                                getSearchPredicates(root));
                this.count = this.entityManager.createQuery(countCriteria).getSingleResult();

                // Populate this.pageItems

                CriteriaQuery<Telephones> criteria = builder.createQuery(Telephones.class);
                root = criteria.from(Telephones.class);
                TypedQuery<Telephones> query = this.entityManager.createQuery(criteria.select(root).where(getSearchPredicates(root)));
                query.setFirstResult(this.page * getPageSize()).setMaxResults(getPageSize());
                this.pageItems = query.getResultList();
        }

        private Predicate[] getSearchPredicates(Root<Telephones> root) {

                CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
                List<Predicate> predicatesList = new ArrayList<Predicate>();

                return predicatesList.toArray(new Predicate[predicatesList.size()]);
        }

        public List<Telephones> getPageItems() {
                return this.pageItems;
        }

        public long getCount() {
                return this.count;
        }

        /*
         * Support listing and POSTing back Telephones entities (e.g. from inside an HtmlSelectOneMenu)
         */

        public List<Telephones> getAll() {
                CriteriaQuery<Telephones> criteria = this.entityManager.getCriteriaBuilder().createQuery(Telephones.class);
                return this.entityManager.createQuery(criteria.select(criteria.from(Telephones.class))).getResultList();
        }

        @Resource
        private SessionContext sessionContext;

        public Converter getConverter() {

                final TelephonesBean ejbProxy = this.sessionContext.getBusinessObject(TelephonesBean.class);

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
                                return String.valueOf(((Telephones) value).getId());
                        }

        };
   }

        /*
         * Support adding children to bidirectional, one-to-many tables
         */

        private Telephones add = new Telephones();

        public Telephones getAdd() {
               return this.add;
        }

        public Telephones getAdded() {
               Telephones added = this.add;
               this.add = new Telephones();
               return added;
        }

}
