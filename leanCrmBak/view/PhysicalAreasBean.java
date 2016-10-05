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
import org.hibernate.search.annotations.NumericField;

@Named
@Stateful
@ConversationScoped
public class PhysicalAreasBean implements Serializable {

        private static final long serialVersionUID = 1L;

        /*
         * Support creating and retrieving PhysicalAreas entities
         */

        private Long id;

        public Long getId() {
                return this.id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        private PhysicalAreas physicalAreas;

        public PhysicalAreas getPhysicalAreas() {
                return this.physicalAreas;
        }

        public void setPhysicalAreas(PhysicalAreas physicalAreas) {
                this.physicalAreas = physicalAreas;
        }

        @Inject
        private Conversation conversation;

        @PersistenceContext(unitName = "leanCrmPU-JTA", type = PersistenceContextType.EXTENDED)
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
                        this.physicalAreas = this.example;
                } else {
                        this.physicalAreas = findById(getId());
                }
        }

        public PhysicalAreas findById(Long id) {

                return this.entityManager.find(PhysicalAreas.class, id);
        }

        /*
         * Support updating and deleting PhysicalAreas entities
         */

        public String update() {
                this.conversation.end();

                try {
                        if (this.id == null) {
                                this.entityManager.persist(this.physicalAreas);
                                return "search?faces-redirect=true";
                        } else {
                                this.entityManager.merge(this.physicalAreas);
                                return "view?faces-redirect=true&id=" + this.physicalAreas.getId();
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
                        PhysicalAreas deletableEntity = findById(getId());
          Iterator<PhysicalAreas> iterObjHijos = deletableEntity.getObjHijos().iterator();
          for (; iterObjHijos.hasNext();){
             PhysicalAreas nextInObjHijos = iterObjHijos.next();
             nextInObjHijos.setObjPadre(null);
             iterObjHijos.remove();
             this.entityManager.merge(nextInObjHijos);
          }
                        PhysicalAreasTypes physicalAreasTypes = deletableEntity.getPhysicalAreasTypes();
                        physicalAreasTypes.getPhysicalAreas().remove(deletableEntity);
                        deletableEntity.setPhysicalAreasTypes(null);
                        this.entityManager.merge(physicalAreasTypes);
   1      PhysicalAreas objPadre = deletableEntity.getObjPadre();
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
         * Support searching PhysicalAreas entities with pagination
         */

        private int page;
        private long count;
        private List<PhysicalAreas> pageItems;

        private PhysicalAreas example = new PhysicalAreas();

        public int getPage() {
                return this.page;
        }

        public void setPage(int page) {
                this.page = page;
        }

        public int getPageSize() {
                return 10;
        }

        public PhysicalAreas getExample() {
                return this.example;
        }

        public void setExample(PhysicalAreas example) {
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
                Root<PhysicalAreas> root = countCriteria.from(PhysicalAreas.class);
                countCriteria = countCriteria.select(builder.count(root)).where(
                                getSearchPredicates(root));
                this.count = this.entityManager.createQuery(countCriteria).getSingleResult();

                // Populate this.pageItems

                CriteriaQuery<PhysicalAreas> criteria = builder.createQuery(PhysicalAreas.class);
                root = criteria.from(PhysicalAreas.class);
                TypedQuery<PhysicalAreas> query = this.entityManager.createQuery(criteria.select(root).where(getSearchPredicates(root)));
                query.setFirstResult(this.page * getPageSize()).setMaxResults(getPageSize());
                this.pageItems = query.getResultList();
        }

        private Predicate[] getSearchPredicates(Root<PhysicalAreas> root) {

                CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
                List<Predicate> predicatesList = new ArrayList<Predicate>();

                return predicatesList.toArray(new Predicate[predicatesList.size()]);
        }

        public List<PhysicalAreas> getPageItems() {
                return this.pageItems;
        }

        public long getCount() {
                return this.count;
        }

        /*
         * Support listing and POSTing back PhysicalAreas entities (e.g. from inside an HtmlSelectOneMenu)
         */

        public List<PhysicalAreas> getAll() {
                CriteriaQuery<PhysicalAreas> criteria = this.entityManager.getCriteriaBuilder().createQuery(PhysicalAreas.class);
                return this.entityManager.createQuery(criteria.select(criteria.from(PhysicalAreas.class))).getResultList();
        }

        @Resource
        private SessionContext sessionContext;

        public Converter getConverter() {

                final PhysicalAreasBean ejbProxy = this.sessionContext.getBusinessObject(PhysicalAreasBean.class);

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
                                return String.valueOf(((PhysicalAreas) value).getId());
                        }

        };
   }

        /*
         * Support adding children to bidirectional, one-to-many tables
         */

        private PhysicalAreas add = new PhysicalAreas();

        public PhysicalAreas getAdd() {
               return this.add;
        }

        public PhysicalAreas getAdded() {
               PhysicalAreas added = this.add;
               this.add = new PhysicalAreas();
               return added;
        }

}
