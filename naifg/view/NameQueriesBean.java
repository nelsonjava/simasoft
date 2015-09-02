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

import import co.simasoft.models.dev.naifg.*;
import import co.simasoft.models.dev.naifg.dependencies.*;
import import co.simasoft.models.core.sites.*;
import import org.hibernate.search.annotations.Analyze;
import import org.hibernate.search.annotations.Index;
import import org.hibernate.search.annotations.Field;
import import org.hibernate.search.annotations.DocumentId;
import import org.hibernate.search.annotations.Store;
import import org.hibernate.search.annotations.Indexed;
import import javax.persistence.TemporalType;
import import javax.persistence.Temporal;
import import org.hibernate.search.annotations.DateBridge;
import import org.hibernate.search.annotations.Resolution;
import import javax.persistence.OneToMany;
import import javax.persistence.ManyToOne;
import import javax.persistence.ManyToMany;
import java.util.Iterator;

@Named
@Stateful
@ConversationScoped
public class NameQueriesBean implements Serializable{

        private static final long serialVersionUID = 1L;

        /*
         * Support creating and retrieving NameQueries entities
         */

        private Long id;

        public Long getId() {
                return this.id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        private NameQueries nameQueries;

        public NameQueries getNameQueries() {
                return this.nameQueries;
        }

        public void setNameQueries(NameQueries nameQueries) {
                this.nameQueries = nameQueries;
        }

        @Inject
        private Conversation conversation;

        @PersistenceContext(unitName = "naifgPU-JTA", type = PersistenceContextType.EXTENDED)
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
                        this.nameQueries = this.example;
                } else {
                        this.nameQueries = findById(getId());
                }
        }

        public NameQueries findById(Long id) {

                return this.entityManager.find(NameQueries.class, id);
        }

        /*
         * Support updating and deleting NameQueries entities
        */

        public String update() {
                this.conversation.end();

                try {
                        if (this.id == null) {
                                this.entityManager.persist(this.nameQueries);
                                return "search?faces-redirect=true";
                        } else {
                                this.entityManager.merge(this.nameQueries);
                                return "view?faces-redirect=true&id=" + this.nameQueries.getId();
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
                        NameQueries deletableEntity = findById(getId());
                        Entities entities = deletableEntity.getEntities();
                        entities.getNameQueries().remove(deletableEntity);
                        deletableEntity.setEntities(null);
                        this.entityManager.merge(entities);
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
         * Support searching NameQueries entities with pagination
         */

        private int page;
        private long count;
        private List<NameQueries> pageItems;

        private NameQueries example = new NameQueries();

        public int getPage() {
                return this.page;
        }

        public void setPage(int page) {
                this.page = page;
        }

        public int getPageSize() {
                return 10;
        }

        public NameQueries getExample() {
                return this.example;
        }

        public void setExample(NameQueries example) {
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
                Root<NameQueries> root = countCriteria.from(NameQueries.class);
                countCriteria = countCriteria.select(builder.count(root)).where(
                                getSearchPredicates(root));
                this.count = this.entityManager.createQuery(countCriteria).getSingleResult();

                // Populate this.pageItems

                CriteriaQuery<NameQueries> criteria = builder.createQuery(NameQueries.class);
                root = criteria.from(NameQueries.class);
                TypedQuery<NameQueries> query = this.entityManager.createQuery(criteria.select(root).where(getSearchPredicates(root)));
                query.setFirstResult(this.page * getPageSize()).setMaxResults(getPageSize());
                this.pageItems = query.getResultList();
        }

        private Predicate[] getSearchPredicates(Root<NameQueries> root) {

                CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
                List<Predicate> predicatesList = new ArrayList<Predicate>();

                return predicatesList.toArray(new Predicate[predicatesList.size()]);
        }

        public List<NameQueries> getPageItems() {
                return this.pageItems;
        }

        public long getCount() {
                return this.count;
        }

        /*
         * Support listing and POSTing back NameQueries entities (e.g. from inside an HtmlSelectOneMenu)
         */

        public List<NameQueries> getAll() {
                CriteriaQuery<NameQueries> criteria = this.entityManager.getCriteriaBuilder().createQuery(NameQueries.class);
                return this.entityManager.createQuery(criteria.select(criteria.from(NameQueries.class))).getResultList();
        }

        @Resource
        private SessionContext sessionContext;

        public Converter getConverter() {

                final NameQueriesBean ejbProxy = this.sessionContext.getBusinessObject(NameQueriesBean.class);

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
                       return String.valueOf(((NameQueries) value).getId());
                }

        };
   }

        /*
         * Support adding children to bidirectional, one-to-many tables
         */

        private NameQueries add = new NameQueries();

        public NameQueries getAdd() {
               return this.add;
        }

        public NameQueries getAdded() {
               NameQueries added = this.add;
               this.add = new NameQueries();
               return added;
        }

}
