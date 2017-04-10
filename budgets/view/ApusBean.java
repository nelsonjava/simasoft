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
public class ApusBean implements Serializable {

        private static final long serialVersionUID = 1L;

        /*
         * Support creating and retrieving Apus entities
         */

        private Long id;

        public Long getId() {
                return this.id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        private Apus apus;

        public Apus getApus() {
                return this.apus;
        }

        public void setApus(Apus apus) {
                this.apus = apus;
        }

        @Inject
        private Conversation conversation;

        @PersistenceContext(unitName = "budgetsPU-JTA", type = PersistenceContextType.EXTENDED)
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
                        this.apus = this.example;
                } else {
                        this.apus = findById(getId());
                }
        }

        public Apus findById(Long id) {

                return this.entityManager.find(Apus.class, id);
        }

        /*
         * Support updating and deleting Apus entities
         */

        public String update() {
                this.conversation.end();

                try {
                        if (this.id == null) {
                                this.entityManager.persist(this.apus);
                                return "search?faces-redirect=true";
                        } else {
                                this.entityManager.merge(this.apus);
                                return "view?faces-redirect=true&id=" + this.apus.getId();
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
                        Apus deletableEntity = findById(getId());
                        Iterator<ConstructionMaterials> iterConstructionMaterials = deletableEntity.getConstructionMaterials().iterator();
                        for (; iterConstructionMaterials.hasNext();){
                               ConstructionMaterials nextInConstructionMaterials = iterConstructionMaterials.next();
                                nextInConstructionMaterials.setApus(null);
                               iterConstructionMaterials.remove();
                               this.entityManager.merge(nextInConstructionMaterials);
                        }
                        Iterator<ConstructionWorkforce> iterConstructionWorkforce = deletableEntity.getConstructionWorkforce().iterator();
                        for (; iterConstructionWorkforce.hasNext();){
                               ConstructionWorkforce nextInConstructionWorkforce = iterConstructionWorkforce.next();
                                nextInConstructionWorkforce.setApus(null);
                               iterConstructionWorkforce.remove();
                               this.entityManager.merge(nextInConstructionWorkforce);
                        }
                        Iterator<ConstructionEquipments> iterConstructionEquipments = deletableEntity.getConstructionEquipments().iterator();
                        for (; iterConstructionEquipments.hasNext();){
                               ConstructionEquipments nextInConstructionEquipments = iterConstructionEquipments.next();
                                nextInConstructionEquipments.setApus(null);
                               iterConstructionEquipments.remove();
                               this.entityManager.merge(nextInConstructionEquipments);
                        }
                        Iterator<ConstructionTransports> iterConstructionTransports = deletableEntity.getConstructionTransports().iterator();
                        for (; iterConstructionTransports.hasNext();){
                               ConstructionTransports nextInConstructionTransports = iterConstructionTransports.next();
                                nextInConstructionTransports.setApus(null);
                               iterConstructionTransports.remove();
                               this.entityManager.merge(nextInConstructionTransports);
                        }
                        MeasurementUnits measurementUnits = deletableEntity.getMeasurementUnits();
                        measurementUnits.getApus().remove(deletableEntity);
                        deletableEntity.setMeasurementUnits(null);
                        this.entityManager.merge(measurementUnits);
                        ConstructionActivities constructionActivities = deletableEntity.getConstructionActivities();
                        constructionActivities.getApus().remove(deletableEntity);
                        deletableEntity.setConstructionActivities(null);
                        this.entityManager.merge(constructionActivities);
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
         * Support searching Apus entities with pagination
         */

        private int page;
        private long count;
        private List<Apus> pageItems;

        private Apus example = new Apus();

        public int getPage() {
                return this.page;
        }

        public void setPage(int page) {
                this.page = page;
        }

        public int getPageSize() {
                return 10;
        }

        public Apus getExample() {
                return this.example;
        }

        public void setExample(Apus example) {
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
                Root<Apus> root = countCriteria.from(Apus.class);
                countCriteria = countCriteria.select(builder.count(root)).where(
                                getSearchPredicates(root));
                this.count = this.entityManager.createQuery(countCriteria).getSingleResult();

                // Populate this.pageItems

                CriteriaQuery<Apus> criteria = builder.createQuery(Apus.class);
                root = criteria.from(Apus.class);
                TypedQuery<Apus> query = this.entityManager.createQuery(criteria.select(root).where(getSearchPredicates(root)));
                query.setFirstResult(this.page * getPageSize()).setMaxResults(getPageSize());
                this.pageItems = query.getResultList();
        }

        private Predicate[] getSearchPredicates(Root<Apus> root) {

                CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
                List<Predicate> predicatesList = new ArrayList<Predicate>();

                return predicatesList.toArray(new Predicate[predicatesList.size()]);
        }

        public List<Apus> getPageItems() {
                return this.pageItems;
        }

        public long getCount() {
                return this.count;
        }

        /*
         * Support listing and POSTing back Apus entities (e.g. from inside an HtmlSelectOneMenu)
         */

        public List<Apus> getAll() {
                CriteriaQuery<Apus> criteria = this.entityManager.getCriteriaBuilder().createQuery(Apus.class);
                return this.entityManager.createQuery(criteria.select(criteria.from(Apus.class))).getResultList();
        }

        @Resource
        private SessionContext sessionContext;

        public Converter getConverter() {

                final ApusBean ejbProxy = this.sessionContext.getBusinessObject(ApusBean.class);

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
                                return String.valueOf(((Apus) value).getId());
                        }

        };
   }

        /*
         * Support adding children to bidirectional, one-to-many tables
         */

        private Apus add = new Apus();

        public Apus getAdd() {
               return this.add;
        }

        public Apus getAdded() {
               Apus added = this.add;
               this.add = new Apus();
               return added;
        }

}
