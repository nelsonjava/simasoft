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

import co.simasoft.models.NetworkPorts;
import co.simasoft.models.Hosts;
import co.simasoft.models.PatchPanelsPorts;
import co.simasoft.models.Sites;
import java.util.Iterator;

/**
 * Backing bean for NetworkPorts entities.
 * <p/>
 * This class provides CRUD functionality for all NetworkPorts entities. It
 * focuses purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt>
 * for state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class NetworkPortsBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving NetworkPorts entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private NetworkPorts networkPorts;

	public NetworkPorts getNetworkPorts() {
		return this.networkPorts;
	}

	public void setNetworkPorts(NetworkPorts networkPorts) {
		this.networkPorts = networkPorts;
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
			this.networkPorts = this.example;
		} else {
			this.networkPorts = findById(getId());
		}
	}

	public NetworkPorts findById(Long id) {

		return this.entityManager.find(NetworkPorts.class, id);
	}

	/*
	 * Support updating and deleting NetworkPorts entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.networkPorts);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.networkPorts);
				return "view?faces-redirect=true&id="
						+ this.networkPorts.getId();
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
			NetworkPorts deletableEntity = findById(getId());
			Iterator<Sites> iterSites = deletableEntity.getSites().iterator();
			for (; iterSites.hasNext();) {
				Sites nextInSites = iterSites.next();
				nextInSites.getNetworkPorts().remove(deletableEntity);
				iterSites.remove();
				this.entityManager.merge(nextInSites);
			}
			PatchPanelsPorts patchPanelsPorts = deletableEntity
					.getPatchPanelsPorts();
			patchPanelsPorts.getNetworkPorts().remove(deletableEntity);
			deletableEntity.setPatchPanelsPorts(null);
			this.entityManager.merge(patchPanelsPorts);
			Hosts hosts = deletableEntity.getHosts();
			hosts.getNetworkPorts().remove(deletableEntity);
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
	 * Support searching NetworkPorts entities with pagination
	 */

	private int page;
	private long count;
	private List<NetworkPorts> pageItems;

	private NetworkPorts example = new NetworkPorts();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 1000;
	}

	public NetworkPorts getExample() {
		return this.example;
	}

	public void setExample(NetworkPorts example) {
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
		Root<NetworkPorts> root = countCriteria.from(NetworkPorts.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<NetworkPorts> criteria = builder
				.createQuery(NetworkPorts.class);
		root = criteria.from(NetworkPorts.class);
		TypedQuery<NetworkPorts> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<NetworkPorts> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		String alias = this.example.getAlias();
		if (alias != null && !"".equals(alias)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("alias")),
					'%' + alias.toLowerCase() + '%'));
		}
		String observations = this.example.getObservations();
		if (observations != null && !"".equals(observations)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("observations")),
					'%' + observations.toLowerCase() + '%'));
		}
		String macAddress = this.example.getMacAddress();
		if (macAddress != null && !"".equals(macAddress)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("macAddress")),
					'%' + macAddress.toLowerCase() + '%'));
		}
		String ipAddress = this.example.getIpAddress();
		if (ipAddress != null && !"".equals(ipAddress)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("ipAddress")),
					'%' + ipAddress.toLowerCase() + '%'));
		}
		String state = this.example.getState();
		if (state != null && !"".equals(state)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("state")),
					'%' + state.toLowerCase() + '%'));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<NetworkPorts> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back NetworkPorts entities (e.g. from inside
	 * an HtmlSelectOneMenu)
	 */

	public List<NetworkPorts> getAll() {

		CriteriaQuery<NetworkPorts> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(NetworkPorts.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(NetworkPorts.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final NetworkPortsBean ejbProxy = this.sessionContext
				.getBusinessObject(NetworkPortsBean.class);

		return new Converter() {

			@Override
			public Object getAsObject(FacesContext context,
					UIComponent component, String value) {

				return ejbProxy.findById(Long.valueOf(value));
			}

			@Override
			public String getAsString(FacesContext context,
					UIComponent component, Object value) {

				if (value == null) {
					return "";
				}

				return String.valueOf(((NetworkPorts) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private NetworkPorts add = new NetworkPorts();

	public NetworkPorts getAdd() {
		return this.add;
	}

	public NetworkPorts getAdded() {
		NetworkPorts added = this.add;
		this.add = new NetworkPorts();
		return added;
	}
}
