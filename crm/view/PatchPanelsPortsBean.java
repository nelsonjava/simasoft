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
public class PatchPanelsPortsBean implements Serializable {

        private static final long serialVersionUID = 1L;

        /*
         * Support creating and retrieving PatchPanelsPorts entities
         */

        private Long id;

        public Long getId() {
                return this.id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        private PatchPanelsPorts patchPanelsPorts;

        public PatchPanelsPorts getPatchPanelsPorts() {
                return this.patchPanelsPorts;
        }

        public void setPatchPanelsPorts(PatchPanelsPorts patchPanelsPorts) {
                this.patchPanelsPorts = patchPanelsPorts;
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
                        this.patchPanelsPorts = this.example;
                } else {
                        this.patchPanelsPorts = findById(getId());
                }
        }

        public PatchPanelsPorts findById(Long id) {

                return this.entityManager.find(PatchPanelsPorts.class, id);
        }

        /*
         * Support updating and deleting PatchPanelsPorts entities
         */

        public String update() {
                this.conversation.end();

                try {
                        if (this.id == null) {
                                this.entityManager.persist(this.patchPanelsPorts);
                                return "search?faces-redirect=true";
                        } else {
                                this.entityManager.merge(this.patchPanelsPorts);
                                return "view?faces-redirect=true&id=" + this.patchPanelsPorts.getId();
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
                        PatchPanelsPorts deletableEntity = findById(getId());
                        Iterator<NetworkPorts> iterNetworkPorts = deletableEntity.getNetworkPorts().iterator();
                        for (; iterNetworkPorts.hasNext();){
                               NetworkPorts nextInNetworkPorts = iterNetworkPorts.next();
                                nextInNetworkPorts.setPatchPanelsPorts(null);
                               iterNetworkPorts.remove();
                               this.entityManager.merge(nextInNetworkPorts);
                        }
                        PhysicalAreas physicalAreas = deletableEntity.getPhysicalAreas();
                        physicalAreas.getPatchPanelsPorts().remove(deletableEntity);
                        deletableEntity.setPhysicalAreas(null);
                        this.entityManager.merge(physicalAreas);
                        SwitchesPorts switchesPorts = deletableEntity.getSwitchesPorts();
                        switchesPorts.getPatchPanelsPorts().remove(deletableEntity);
                        deletableEntity.setSwitchesPorts(null);
                        this.entityManager.merge(switchesPorts);
                        Hosts hosts = deletableEntity.getHosts();
                        hosts.getPatchPanelsPorts().remove(deletableEntity);
                        deletableEntity.setHosts(null);
                        this.entityManager.merge(hosts);
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
         * Support searching PatchPanelsPorts entities with pagination
         */

        private int page;
        private long count;
        private List<PatchPanelsPorts> pageItems;

        private PatchPanelsPorts example = new PatchPanelsPorts();

        public int getPage() {
                return this.page;
        }

        public void setPage(int page) {
                this.page = page;
        }

        public int getPageSize() {
                return 10;
        }

        public PatchPanelsPorts getExample() {
                return this.example;
        }

        public void setExample(PatchPanelsPorts example) {
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
                Root<PatchPanelsPorts> root = countCriteria.from(PatchPanelsPorts.class);
                countCriteria = countCriteria.select(builder.count(root)).where(
                                getSearchPredicates(root));
                this.count = this.entityManager.createQuery(countCriteria).getSingleResult();

                // Populate this.pageItems

                CriteriaQuery<PatchPanelsPorts> criteria = builder.createQuery(PatchPanelsPorts.class);
                root = criteria.from(PatchPanelsPorts.class);
                TypedQuery<PatchPanelsPorts> query = this.entityManager.createQuery(criteria.select(root).where(getSearchPredicates(root)));
                query.setFirstResult(this.page * getPageSize()).setMaxResults(getPageSize());
                this.pageItems = query.getResultList();
        }

        private Predicate[] getSearchPredicates(Root<PatchPanelsPorts> root) {

                CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
                List<Predicate> predicatesList = new ArrayList<Predicate>();

                return predicatesList.toArray(new Predicate[predicatesList.size()]);
        }

        public List<PatchPanelsPorts> getPageItems() {
                return this.pageItems;
        }

        public long getCount() {
                return this.count;
        }

        /*
         * Support listing and POSTing back PatchPanelsPorts entities (e.g. from inside an HtmlSelectOneMenu)
         */

        public List<PatchPanelsPorts> getAll() {
                CriteriaQuery<PatchPanelsPorts> criteria = this.entityManager.getCriteriaBuilder().createQuery(PatchPanelsPorts.class);
                return this.entityManager.createQuery(criteria.select(criteria.from(PatchPanelsPorts.class))).getResultList();
        }

        @Resource
        private SessionContext sessionContext;

        public Converter getConverter() {

                final PatchPanelsPortsBean ejbProxy = this.sessionContext.getBusinessObject(PatchPanelsPortsBean.class);

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
                                return String.valueOf(((PatchPanelsPorts) value).getId());
                        }

        };
   }

        /*
         * Support adding children to bidirectional, one-to-many tables
         */

        private PatchPanelsPorts add = new PatchPanelsPorts();

        public PatchPanelsPorts getAdd() {
               return this.add;
        }

        public PatchPanelsPorts getAdded() {
               PatchPanelsPorts added = this.add;
               this.add = new PatchPanelsPorts();
               return added;
        }

}
