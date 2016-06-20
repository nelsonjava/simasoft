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

import import co.simasoft.models.*;
import import org.hibernate.search.annotations.Analyze;
import import org.hibernate.search.annotations.DocumentId;
import import org.hibernate.search.annotations.Field;
import import org.hibernate.search.annotations.Index;
import import org.hibernate.search.annotations.Indexed;
import import org.hibernate.search.annotations.Store;
import import javax.persistence.OneToMany;
import import javax.persistence.ManyToOne;
import java.util.Iterator;

@Named
@Stateful
@ConversationScoped
public class ScopeCanvasBean implements Serializable{

        private static final long serialVersionUID = 1L;

        /*
         * Support creating and retrieving ScopeCanvas entities
         */

        private Long id;

        public Long getId() {
                return this.id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        private ScopeCanvas scopeCanvas;

        public ScopeCanvas getScopeCanvas() {
                return this.scopeCanvas;
        }

        public void setScopeCanvas(ScopeCanvas scopeCanvas) {
                this.scopeCanvas = scopeCanvas;
        }

        @Inject
        private Conversation conversation;

        @PersistenceContext(unitName = "scopeCanvasPU-JTA", type = PersistenceContextType.EXTENDED)
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
                        this.scopeCanvas = this.example;
                } else {
                        this.scopeCanvas = findById(getId());
                }
        }

        public ScopeCanvas findById(Long id) {

                return this.entityManager.find(ScopeCanvas.class, id);
        }

        /*
         * Support updating and deleting ScopeCanvas entities
        */

        public String update() {
                this.conversation.end();

                try {
                        if (this.id == null) {
                                this.entityManager.persist(this.scopeCanvas);
                                return "search?faces-redirect=true";
                        } else {
                                this.entityManager.merge(this.scopeCanvas);
                                return "view?faces-redirect=true&id=" + this.scopeCanvas.getId();
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
                        ScopeCanvas deletableEntity = findById(getId());
    3     Iterator<ScopeCanvas> iterObjHijos = deletableEntity.getObjHijos().iterator();
    3     for (; iterObjHijos.hasNext();){
    3        ScopeCanvas nextInObjHijos = iterObjHijos.next();
    3        nextInObjHijos.setObjPadre(null);
    3        iterObjHijos.remove();
    3        this.entityManager.merge(nextInObjHijos);
    3     }
                        Iterator<Postits> iterPostits = deletableEntity.getPostits().iterator();
                        for (; iterPostits.hasNext();){
                               Postits nextInPostits = iterPostits.next();
                                nextInPostits.setScopeCanvas(null);
                               iterPostits.remove();
                               this.entityManager.merge(nextInPostits);
                        }
         ScopeCanvas objPadre = deletableEntity.getObjPadre();
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
         * Support searching ScopeCanvas entities with pagination
         */

        private int page;
        private long count;
        private List<ScopeCanvas> pageItems;

        private ScopeCanvas example = new ScopeCanvas();

        public int getPage() {
                return this.page;
        }

        public void setPage(int page) {
                this.page = page;
        }

        public int getPageSize() {
                return 10;
        }

        public ScopeCanvas getExample() {
                return this.example;
        }

        public void setExample(ScopeCanvas example) {
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
                Root<ScopeCanvas> root = countCriteria.from(ScopeCanvas.class);
                countCriteria = countCriteria.select(builder.count(root)).where(
                                getSearchPredicates(root));
                this.count = this.entityManager.createQuery(countCriteria).getSingleResult();

                // Populate this.pageItems

                CriteriaQuery<ScopeCanvas> criteria = builder.createQuery(ScopeCanvas.class);
                root = criteria.from(ScopeCanvas.class);
                TypedQuery<ScopeCanvas> query = this.entityManager.createQuery(criteria.select(root).where(getSearchPredicates(root)));
                query.setFirstResult(this.page * getPageSize()).setMaxResults(getPageSize());
                this.pageItems = query.getResultList();
        }

        private Predicate[] getSearchPredicates(Root<ScopeCanvas> root) {

                CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
                List<Predicate> predicatesList = new ArrayList<Predicate>();

                return predicatesList.toArray(new Predicate[predicatesList.size()]);
        }

        public List<ScopeCanvas> getPageItems() {
                return this.pageItems;
        }

        public long getCount() {
                return this.count;
        }

        /*
         * Support listing and POSTing back ScopeCanvas entities (e.g. from inside an HtmlSelectOneMenu)
         */

        public List<ScopeCanvas> getAll() {
                CriteriaQuery<ScopeCanvas> criteria = this.entityManager.getCriteriaBuilder().createQuery(ScopeCanvas.class);
                return this.entityManager.createQuery(criteria.select(criteria.from(ScopeCanvas.class))).getResultList();
        }

        @Resource
        private SessionContext sessionContext;

        public Converter getConverter() {

                final ScopeCanvasBean ejbProxy = this.sessionContext.getBusinessObject(ScopeCanvasBean.class);

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
                       return String.valueOf(((ScopeCanvas) value).getId());
                }

        };
   }

        /*
         * Support adding children to bidirectional, one-to-many tables
         */

        private ScopeCanvas add = new ScopeCanvas();

        public ScopeCanvas getAdd() {
               return this.add;
        }

        public ScopeCanvas getAdded() {
               ScopeCanvas added = this.add;
               this.add = new ScopeCanvas();
               return added;
        }

}
