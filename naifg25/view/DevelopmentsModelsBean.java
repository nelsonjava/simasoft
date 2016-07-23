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

import import co.simasoft.*;
import import org.hibernate.search.annotations.Analyze;
import import org.hibernate.search.annotations.DocumentId;
import import org.hibernate.search.annotations.Field;
import import org.hibernate.search.annotations.Index;
import import org.hibernate.search.annotations.Indexed;
import import org.hibernate.search.annotations.Store;
import import javax.persistence.OneToMany;
import import javax.persistence.ManyToOne;
import import javax.persistence.ManyToMany;
import import javax.persistence.Temporal;
import import javax.persistence.TemporalType;
import import org.hibernate.search.annotations.DateBridge;
import import org.hibernate.search.annotations.Resolution;
import java.util.Iterator;

@Named
@Stateful
@ConversationScoped
public class DevelopmentsModelsBean implements Serializable{

        private static final long serialVersionUID = 1L;

        /*
         * Support creating and retrieving DevelopmentsModels entities
         */

        private Long id;

        public Long getId() {
                return this.id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        private DevelopmentsModels developmentsModels;

        public DevelopmentsModels getDevelopmentsModels() {
                return this.developmentsModels;
        }

        public void setDevelopmentsModels(DevelopmentsModels developmentsModels) {
                this.developmentsModels = developmentsModels;
        }

        @Inject
        private Conversation conversation;

        @PersistenceContext(unitName = "naifg25PU-JTA", type = PersistenceContextType.EXTENDED)
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
                        this.developmentsModels = this.example;
                } else {
                        this.developmentsModels = findById(getId());
                }
        }

        public DevelopmentsModels findById(Long id) {

                return this.entityManager.find(DevelopmentsModels.class, id);
        }

        /*
         * Support updating and deleting DevelopmentsModels entities
        */

        public String update() {
                this.conversation.end();

                try {
                        if (this.id == null) {
                                this.entityManager.persist(this.developmentsModels);
                                return "search?faces-redirect=true";
                        } else {
                                this.entityManager.merge(this.developmentsModels);
                                return "view?faces-redirect=true&id=" + this.developmentsModels.getId();
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
                        DevelopmentsModels deletableEntity = findById(getId());
                        Developments developments = deletableEntity.getDevelopments();
                        developments.getDevelopmentsModels().remove(deletableEntity);
                        deletableEntity.setDevelopments(null);
                        this.entityManager.merge(developments);
                        Models models = deletableEntity.getModels();
                        models.getDevelopmentsModels().remove(deletableEntity);
                        deletableEntity.setModels(null);
                        this.entityManager.merge(models);
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
         * Support searching DevelopmentsModels entities with pagination
         */

        private int page;
        private long count;
        private List<DevelopmentsModels> pageItems;

        private DevelopmentsModels example = new DevelopmentsModels();

        public int getPage() {
                return this.page;
        }

        public void setPage(int page) {
                this.page = page;
        }

        public int getPageSize() {
                return 10;
        }

        public DevelopmentsModels getExample() {
                return this.example;
        }

        public void setExample(DevelopmentsModels example) {
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
                Root<DevelopmentsModels> root = countCriteria.from(DevelopmentsModels.class);
                countCriteria = countCriteria.select(builder.count(root)).where(
                                getSearchPredicates(root));
                this.count = this.entityManager.createQuery(countCriteria).getSingleResult();

                // Populate this.pageItems

                CriteriaQuery<DevelopmentsModels> criteria = builder.createQuery(DevelopmentsModels.class);
                root = criteria.from(DevelopmentsModels.class);
                TypedQuery<DevelopmentsModels> query = this.entityManager.createQuery(criteria.select(root).where(getSearchPredicates(root)));
                query.setFirstResult(this.page * getPageSize()).setMaxResults(getPageSize());
                this.pageItems = query.getResultList();
        }

        private Predicate[] getSearchPredicates(Root<DevelopmentsModels> root) {

                CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
                List<Predicate> predicatesList = new ArrayList<Predicate>();

                return predicatesList.toArray(new Predicate[predicatesList.size()]);
        }

        public List<DevelopmentsModels> getPageItems() {
                return this.pageItems;
        }

        public long getCount() {
                return this.count;
        }

        /*
         * Support listing and POSTing back DevelopmentsModels entities (e.g. from inside an HtmlSelectOneMenu)
         */

        public List<DevelopmentsModels> getAll() {
                CriteriaQuery<DevelopmentsModels> criteria = this.entityManager.getCriteriaBuilder().createQuery(DevelopmentsModels.class);
                return this.entityManager.createQuery(criteria.select(criteria.from(DevelopmentsModels.class))).getResultList();
        }

        @Resource
        private SessionContext sessionContext;

        public Converter getConverter() {

                final DevelopmentsModelsBean ejbProxy = this.sessionContext.getBusinessObject(DevelopmentsModelsBean.class);

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
                       return String.valueOf(((DevelopmentsModels) value).getId());
                }

        };
   }

        /*
         * Support adding children to bidirectional, one-to-many tables
         */

        private DevelopmentsModels add = new DevelopmentsModels();

        public DevelopmentsModels getAdd() {
               return this.add;
        }

        public DevelopmentsModels getAdded() {
               DevelopmentsModels added = this.add;
               this.add = new DevelopmentsModels();
               return added;
        }

}
