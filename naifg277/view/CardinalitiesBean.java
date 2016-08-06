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

import import org.hibernate.search.annotations.Analyze;
import import org.hibernate.search.annotations.DocumentId;
import import org.hibernate.search.annotations.Field;
import import org.hibernate.search.annotations.Index;
import import org.hibernate.search.annotations.Indexed;
import import org.hibernate.search.annotations.Store;
import import javax.persistence.OneToMany;
import import javax.persistence.ManyToOne;
import import javax.persistence.ManyToMany;
import import co.simasoft.models.*;
import import org.hibernate.search.annotations.DateBridge;
import import org.hibernate.search.annotations.Resolution;
import import javax.persistence.TemporalType;
import import javax.persistence.Temporal;
import java.util.Iterator;

@Named
@Stateful
@ConversationScoped
public class CardinalitiesBean implements Serializable{

        private static final long serialVersionUID = 1L;

        /*
         * Support creating and retrieving Cardinalities entities
         */

        private Long id;

        public Long getId() {
                return this.id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        private Cardinalities cardinalities;

        public Cardinalities getCardinalities() {
                return this.cardinalities;
        }

        public void setCardinalities(Cardinalities cardinalities) {
                this.cardinalities = cardinalities;
        }

        @Inject
        private Conversation conversation;

        @PersistenceContext(unitName = "naifg27PU-JTA", type = PersistenceContextType.EXTENDED)
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
                        this.cardinalities = this.example;
                } else {
                        this.cardinalities = findById(getId());
                }
        }

        public Cardinalities findById(Long id) {

                return this.entityManager.find(Cardinalities.class, id);
        }

        /*
         * Support updating and deleting Cardinalities entities
        */

        public String update() {
                this.conversation.end();

                try {
                        if (this.id == null) {
                                this.entityManager.persist(this.cardinalities);
                                return "search?faces-redirect=true";
                        } else {
                                this.entityManager.merge(this.cardinalities);
                                return "view?faces-redirect=true&id=" + this.cardinalities.getId();
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
                        Cardinalities deletableEntity = findById(getId());
    3     Iterator<Cardinalities> iterObjHijos = deletableEntity.getObjHijos().iterator();
    3     for (; iterObjHijos.hasNext();){
    3        Cardinalities nextInObjHijos = iterObjHijos.next();
    3        nextInObjHijos.setObjPadre(null);
    3        iterObjHijos.remove();
    3        this.entityManager.merge(nextInObjHijos);
    3     }
                        Iterator<Relationships> iterRelationships = deletableEntity.getRelationships().iterator();
                        for (; iterRelationships.hasNext();){
                               Relationships nextInRelationships = iterRelationships.next();
                                nextInRelationships.setCardinalities(null);
                               iterRelationships.remove();
                               this.entityManager.merge(nextInRelationships);
                        }
         Cardinalities objPadre = deletableEntity.getObjPadre();
         objPadre.getObjHijos().remove(deletableEntity);
         deletableEntity.setObjPadre(null);
         this.entityManager.merge(objPadre);
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
         * Support searching Cardinalities entities with pagination
         */

        private int page;
        private long count;
        private List<Cardinalities> pageItems;

        private Cardinalities example = new Cardinalities();

        public int getPage() {
                return this.page;
        }

        public void setPage(int page) {
                this.page = page;
        }

        public int getPageSize() {
                return 10;
        }

        public Cardinalities getExample() {
                return this.example;
        }

        public void setExample(Cardinalities example) {
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
                Root<Cardinalities> root = countCriteria.from(Cardinalities.class);
                countCriteria = countCriteria.select(builder.count(root)).where(
                                getSearchPredicates(root));
                this.count = this.entityManager.createQuery(countCriteria).getSingleResult();

                // Populate this.pageItems

                CriteriaQuery<Cardinalities> criteria = builder.createQuery(Cardinalities.class);
                root = criteria.from(Cardinalities.class);
                TypedQuery<Cardinalities> query = this.entityManager.createQuery(criteria.select(root).where(getSearchPredicates(root)));
                query.setFirstResult(this.page * getPageSize()).setMaxResults(getPageSize());
                this.pageItems = query.getResultList();
        }

        private Predicate[] getSearchPredicates(Root<Cardinalities> root) {

                CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
                List<Predicate> predicatesList = new ArrayList<Predicate>();

                return predicatesList.toArray(new Predicate[predicatesList.size()]);
        }

        public List<Cardinalities> getPageItems() {
                return this.pageItems;
        }

        public long getCount() {
                return this.count;
        }

        /*
         * Support listing and POSTing back Cardinalities entities (e.g. from inside an HtmlSelectOneMenu)
         */

        public List<Cardinalities> getAll() {
                CriteriaQuery<Cardinalities> criteria = this.entityManager.getCriteriaBuilder().createQuery(Cardinalities.class);
                return this.entityManager.createQuery(criteria.select(criteria.from(Cardinalities.class))).getResultList();
        }

        @Resource
        private SessionContext sessionContext;

        public Converter getConverter() {

                final CardinalitiesBean ejbProxy = this.sessionContext.getBusinessObject(CardinalitiesBean.class);

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
                       return String.valueOf(((Cardinalities) value).getId());
                }

        };
   }

        /*
         * Support adding children to bidirectional, one-to-many tables
         */

        private Cardinalities add = new Cardinalities();

        public Cardinalities getAdd() {
               return this.add;
        }

        public Cardinalities getAdded() {
               Cardinalities added = this.add;
               this.add = new Cardinalities();
               return added;
        }

}