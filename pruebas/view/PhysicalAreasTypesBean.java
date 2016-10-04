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
import org.hibernate.search.annotations.NumericField;

@Named
@Stateful
@ConversationScoped
public class PhysicalAreasTypesBean implements Serializable {

        private static final long serialVersionUID = 1L;

        /*
         * Support creating and retrieving PhysicalAreasTypes entities
         */

        private Long id;

        public Long getId() {
                return this.id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        private PhysicalAreasTypes physicalAreasTypes;

        public PhysicalAreasTypes getPhysicalAreasTypes() {
                return this.physicalAreasTypes;
        }

        public void setPhysicalAreasTypes(PhysicalAreasTypes physicalAreasTypes) {
                this.physicalAreasTypes = physicalAreasTypes;
        }

        @Inject
        private Conversation conversation;

        @PersistenceContext(unitName = "pruebasPU-JTA", type = PersistenceContextType.EXTENDED)
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
                        this.physicalAreasTypes = this.example;
                } else {
                        this.physicalAreasTypes = findById(getId());
                }
        }

        public PhysicalAreasTypes findById(Long id) {

                return this.entityManager.find(PhysicalAreasTypes.class, id);
        }

        /*
         * Support updating and deleting PhysicalAreasTypes entities
         */

        public String update() {
                this.conversation.end();

                try {
                        if (this.id == null) {
                                this.entityManager.persist(this.physicalAreasTypes);
                                return "search?faces-redirect=true";
                        } else {
                                this.entityManager.merge(this.physicalAreasTypes);
                                return "view?faces-redirect=true&id=" + this.physicalAreasTypes.getId();
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
                        PhysicalAreasTypes deletableEntity = findById(getId());
                        Iterator<PhysicalAreas> iterPhysicalAreas = deletableEntity.getPhysicalAreas().iterator();
                        for (; iterPhysicalAreas.hasNext();){
                               PhysicalAreas nextInPhysicalAreas = iterPhysicalAreas.next();
                                nextInPhysicalAreas.setPhysicalAreasTypes(null);
                               iterPhysicalAreas.remove();
                               this.entityManager.merge(nextInPhysicalAreas);
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
         * Support searching PhysicalAreasTypes entities with pagination
         */

        private int page;
        private long count;
        private List<PhysicalAreasTypes> pageItems;

        private PhysicalAreasTypes example = new PhysicalAreasTypes();

        public int getPage() {
                return this.page;
        }

        public void setPage(int page) {
                this.page = page;
        }

        public int getPageSize() {
                return 10;
        }

        public PhysicalAreasTypes getExample() {
                return this.example;
        }

        public void setExample(PhysicalAreasTypes example) {
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
                Root<PhysicalAreasTypes> root = countCriteria.from(PhysicalAreasTypes.class);
                countCriteria = countCriteria.select(builder.count(root)).where(
                                getSearchPredicates(root));
                this.count = this.entityManager.createQuery(countCriteria).getSingleResult();

                // Populate this.pageItems

                CriteriaQuery<PhysicalAreasTypes> criteria = builder.createQuery(PhysicalAreasTypes.class);
                root = criteria.from(PhysicalAreasTypes.class);
                TypedQuery<PhysicalAreasTypes> query = this.entityManager.createQuery(criteria.select(root).where(getSearchPredicates(root)));
                query.setFirstResult(this.page * getPageSize()).setMaxResults(getPageSize());
                this.pageItems = query.getResultList();
        }

        private Predicate[] getSearchPredicates(Root<PhysicalAreasTypes> root) {

                CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
                List<Predicate> predicatesList = new ArrayList<Predicate>();

                return predicatesList.toArray(new Predicate[predicatesList.size()]);
        }

        public List<PhysicalAreasTypes> getPageItems() {
                return this.pageItems;
        }

        public long getCount() {
                return this.count;
        }

        /*
         * Support listing and POSTing back PhysicalAreasTypes entities (e.g. from inside an HtmlSelectOneMenu)
         */

        public List<PhysicalAreasTypes> getAll() {
                CriteriaQuery<PhysicalAreasTypes> criteria = this.entityManager.getCriteriaBuilder().createQuery(PhysicalAreasTypes.class);
                return this.entityManager.createQuery(criteria.select(criteria.from(PhysicalAreasTypes.class))).getResultList();
        }

        @Resource
        private SessionContext sessionContext;

        public Converter getConverter() {

                final PhysicalAreasTypesBean ejbProxy = this.sessionContext.getBusinessObject(PhysicalAreasTypesBean.class);

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
                                return String.valueOf(((PhysicalAreasTypes) value).getId());
                        }

        };
   }

        /*
         * Support adding children to bidirectional, one-to-many tables
         */

        private PhysicalAreasTypes add = new PhysicalAreasTypes();

        public PhysicalAreasTypes getAdd() {
               return this.add;
        }

        public PhysicalAreasTypes getAdded() {
               PhysicalAreasTypes added = this.add;
               this.add = new PhysicalAreasTypes();
               return added;
        }

}
