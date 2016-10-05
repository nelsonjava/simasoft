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
public class PhysicalSpacesBean implements Serializable {

        private static final long serialVersionUID = 1L;

        /*
         * Support creating and retrieving PhysicalSpaces entities
         */

        private Long id;

        public Long getId() {
                return this.id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        private PhysicalSpaces physicalSpaces;

        public PhysicalSpaces getPhysicalSpaces() {
                return this.physicalSpaces;
        }

        public void setPhysicalSpaces(PhysicalSpaces physicalSpaces) {
                this.physicalSpaces = physicalSpaces;
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
                        this.physicalSpaces = this.example;
                } else {
                        this.physicalSpaces = findById(getId());
                }
        }

        public PhysicalSpaces findById(Long id) {

                return this.entityManager.find(PhysicalSpaces.class, id);
        }

        /*
         * Support updating and deleting PhysicalSpaces entities
         */

        public String update() {
                this.conversation.end();

                try {
                        if (this.id == null) {
                                this.entityManager.persist(this.physicalSpaces);
                                return "search?faces-redirect=true";
                        } else {
                                this.entityManager.merge(this.physicalSpaces);
                                return "view?faces-redirect=true&id=" + this.physicalSpaces.getId();
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
                        PhysicalSpaces deletableEntity = findById(getId());
          Iterator<PhysicalSpaces> iterObjHijos = deletableEntity.getObjHijos().iterator();
          for (; iterObjHijos.hasNext();){
             PhysicalSpaces nextInObjHijos = iterObjHijos.next();
             nextInObjHijos.setObjPadre(null);
             iterObjHijos.remove();
             this.entityManager.merge(nextInObjHijos);
          }
                        Iterator<Employees> iterEmployees = deletableEntity.getEmployees().iterator();
                        for (; iterEmployees.hasNext();){
                               Employees nextInEmployees = iterEmployees.next();
                                nextInEmployees.setPhysicalSpaces(null);
                               iterEmployees.remove();
                               this.entityManager.merge(nextInEmployees);
                        }
                        Iterator<Items> iterItems = deletableEntity.getItems().iterator();
                        for (; iterItems.hasNext();){
                               Items nextInItems = iterItems.next();
                                nextInItems.setPhysicalSpaces(null);
                               iterItems.remove();
                               this.entityManager.merge(nextInItems);
                        }
                        PhysicalSpacesTypes physicalSpacesTypes = deletableEntity.getPhysicalSpacesTypes();
                        physicalSpacesTypes.getPhysicalSpaces().remove(deletableEntity);
                        deletableEntity.setPhysicalSpacesTypes(null);
                        this.entityManager.merge(physicalSpacesTypes);
   1      PhysicalSpaces objPadre = deletableEntity.getObjPadre();
   1      objPadre.getObjHijos().remove(deletableEntity);
   1      deletableEntity.setObjPadre(null);
   1      this.entityManager.merge(objPadre);
                        Predio predio = deletableEntity.getPredio();
                        predio.getPhysicalSpaces().remove(deletableEntity);
                        deletableEntity.setPredio(null);
                        this.entityManager.merge(predio);
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
         * Support searching PhysicalSpaces entities with pagination
         */

        private int page;
        private long count;
        private List<PhysicalSpaces> pageItems;

        private PhysicalSpaces example = new PhysicalSpaces();

        public int getPage() {
                return this.page;
        }

        public void setPage(int page) {
                this.page = page;
        }

        public int getPageSize() {
                return 10;
        }

        public PhysicalSpaces getExample() {
                return this.example;
        }

        public void setExample(PhysicalSpaces example) {
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
                Root<PhysicalSpaces> root = countCriteria.from(PhysicalSpaces.class);
                countCriteria = countCriteria.select(builder.count(root)).where(
                                getSearchPredicates(root));
                this.count = this.entityManager.createQuery(countCriteria).getSingleResult();

                // Populate this.pageItems

                CriteriaQuery<PhysicalSpaces> criteria = builder.createQuery(PhysicalSpaces.class);
                root = criteria.from(PhysicalSpaces.class);
                TypedQuery<PhysicalSpaces> query = this.entityManager.createQuery(criteria.select(root).where(getSearchPredicates(root)));
                query.setFirstResult(this.page * getPageSize()).setMaxResults(getPageSize());
                this.pageItems = query.getResultList();
        }

        private Predicate[] getSearchPredicates(Root<PhysicalSpaces> root) {

                CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
                List<Predicate> predicatesList = new ArrayList<Predicate>();

                return predicatesList.toArray(new Predicate[predicatesList.size()]);
        }

        public List<PhysicalSpaces> getPageItems() {
                return this.pageItems;
        }

        public long getCount() {
                return this.count;
        }

        /*
         * Support listing and POSTing back PhysicalSpaces entities (e.g. from inside an HtmlSelectOneMenu)
         */

        public List<PhysicalSpaces> getAll() {
                CriteriaQuery<PhysicalSpaces> criteria = this.entityManager.getCriteriaBuilder().createQuery(PhysicalSpaces.class);
                return this.entityManager.createQuery(criteria.select(criteria.from(PhysicalSpaces.class))).getResultList();
        }

        @Resource
        private SessionContext sessionContext;

        public Converter getConverter() {

                final PhysicalSpacesBean ejbProxy = this.sessionContext.getBusinessObject(PhysicalSpacesBean.class);

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
                                return String.valueOf(((PhysicalSpaces) value).getId());
                        }

        };
   }

        /*
         * Support adding children to bidirectional, one-to-many tables
         */

        private PhysicalSpaces add = new PhysicalSpaces();

        public PhysicalSpaces getAdd() {
               return this.add;
        }

        public PhysicalSpaces getAdded() {
               PhysicalSpaces added = this.add;
               this.add = new PhysicalSpaces();
               return added;
        }

}
