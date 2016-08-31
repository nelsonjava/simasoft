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
public class BooksTypesBean implements Serializable {

        private static final long serialVersionUID = 1L;

        /*
         * Support creating and retrieving BooksTypes entities
         */

        private Long id;

        public Long getId() {
                return this.id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        private BooksTypes booksTypes;

        public BooksTypes getBooksTypes() {
                return this.booksTypes;
        }

        public void setBooksTypes(BooksTypes booksTypes) {
                this.booksTypes = booksTypes;
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
                        this.booksTypes = this.example;
                } else {
                        this.booksTypes = findById(getId());
                }
        }

        public BooksTypes findById(Long id) {

                return this.entityManager.find(BooksTypes.class, id);
        }

        /*
         * Support updating and deleting BooksTypes entities
         */

        public String update() {
                this.conversation.end();

                try {
                        if (this.id == null) {
                                this.entityManager.persist(this.booksTypes);
                                return "search?faces-redirect=true";
                        } else {
                                this.entityManager.merge(this.booksTypes);
                                return "view?faces-redirect=true&id=" + this.booksTypes.getId();
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
                        BooksTypes deletableEntity = findById(getId());
                        Iterator<Books> iterBooks = deletableEntity.getBooks().iterator();
                        for (; iterBooks.hasNext();){
                               Books nextInBooks = iterBooks.next();
                                nextInBooks.setBooksTypes(null);
                               iterBooks.remove();
                               this.entityManager.merge(nextInBooks);
                        }
          Iterator<BooksTypes> iterObjHijos = deletableEntity.getObjHijos().iterator();
          for (; iterObjHijos.hasNext();){
             BooksTypes nextInObjHijos = iterObjHijos.next();
             nextInObjHijos.setObjPadre(null);
             iterObjHijos.remove();
             this.entityManager.merge(nextInObjHijos);
          }
   1      BooksTypes objPadre = deletableEntity.getObjPadre();
   1      objPadre.getObjHijos().remove(deletableEntity);
   1      deletableEntity.setObjPadre(null);
   1      this.entityManager.merge(objPadre);
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
         * Support searching BooksTypes entities with pagination
         */

        private int page;
        private long count;
        private List<BooksTypes> pageItems;

        private BooksTypes example = new BooksTypes();

        public int getPage() {
                return this.page;
        }

        public void setPage(int page) {
                this.page = page;
        }

        public int getPageSize() {
                return 10;
        }

        public BooksTypes getExample() {
                return this.example;
        }

        public void setExample(BooksTypes example) {
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
                Root<BooksTypes> root = countCriteria.from(BooksTypes.class);
                countCriteria = countCriteria.select(builder.count(root)).where(
                                getSearchPredicates(root));
                this.count = this.entityManager.createQuery(countCriteria).getSingleResult();

                // Populate this.pageItems

                CriteriaQuery<BooksTypes> criteria = builder.createQuery(BooksTypes.class);
                root = criteria.from(BooksTypes.class);
                TypedQuery<BooksTypes> query = this.entityManager.createQuery(criteria.select(root).where(getSearchPredicates(root)));
                query.setFirstResult(this.page * getPageSize()).setMaxResults(getPageSize());
                this.pageItems = query.getResultList();
        }

        private Predicate[] getSearchPredicates(Root<BooksTypes> root) {

                CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
                List<Predicate> predicatesList = new ArrayList<Predicate>();

                return predicatesList.toArray(new Predicate[predicatesList.size()]);
        }

        public List<BooksTypes> getPageItems() {
                return this.pageItems;
        }

        public long getCount() {
                return this.count;
        }

        /*
         * Support listing and POSTing back BooksTypes entities (e.g. from inside an HtmlSelectOneMenu)
         */

        public List<BooksTypes> getAll() {
                CriteriaQuery<BooksTypes> criteria = this.entityManager.getCriteriaBuilder().createQuery(BooksTypes.class);
                return this.entityManager.createQuery(criteria.select(criteria.from(BooksTypes.class))).getResultList();
        }

        @Resource
        private SessionContext sessionContext;

        public Converter getConverter() {

                final BooksTypesBean ejbProxy = this.sessionContext.getBusinessObject(BooksTypesBean.class);

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
                                return String.valueOf(((BooksTypes) value).getId());
                        }

        };
   }

        /*
         * Support adding children to bidirectional, one-to-many tables
         */

        private BooksTypes add = new BooksTypes();

        public BooksTypes getAdd() {
               return this.add;
        }

        public BooksTypes getAdded() {
               BooksTypes added = this.add;
               this.add = new BooksTypes();
               return added;
        }

}
