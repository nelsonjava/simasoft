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

import co.simasoft.models.SwitchesPorts;
import co.simasoft.models.Hosts;
import co.simasoft.models.PatchPanelsPorts;
import co.simasoft.models.Vlans;
import java.util.Iterator;

/**
 * Backing bean for SwitchesPorts entities.
 * <p/>
 * This class provides CRUD functionality for all SwitchesPorts entities. It
 * focuses purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt>
 * for state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class SwitchesPortsBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving SwitchesPorts entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private SwitchesPorts switchesPorts;

	public SwitchesPorts getSwitchesPorts() {
		return this.switchesPorts;
	}

	public void setSwitchesPorts(SwitchesPorts switchesPorts) {
		this.switchesPorts = switchesPorts;
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
			this.switchesPorts = this.example;
		} else {
			this.switchesPorts = findById(getId());
		}
	}

	public SwitchesPorts findById(Long id) {

		return this.entityManager.find(SwitchesPorts.class, id);
	}

	/*
	 * Support updating and deleting SwitchesPorts entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.switchesPorts);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.switchesPorts);
				return "view?faces-redirect=true&id="
						+ this.switchesPorts.getId();
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
			SwitchesPorts deletableEntity = findById(getId());
			Iterator<PatchPanelsPorts> iterPatchPanelsPorts = deletableEntity
					.getPatchPanelsPorts().iterator();
			for (; iterPatchPanelsPorts.hasNext();) {
				PatchPanelsPorts nextInPatchPanelsPorts = iterPatchPanelsPorts
						.next();
				nextInPatchPanelsPorts.setSwitchesPorts(null);
				iterPatchPanelsPorts.remove();
				this.entityManager.merge(nextInPatchPanelsPorts);
			}
			Vlans vlans = deletableEntity.getVlans();
			vlans.getSwitchesPorts().remove(deletableEntity);
			deletableEntity.setVlans(null);
			this.entityManager.merge(vlans);
			Hosts hosts = deletableEntity.getHosts();
			hosts.getSwitchesPorts().remove(deletableEntity);
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
	 * Support searching SwitchesPorts entities with pagination
	 */

	private int page;
	private long count;
	private List<SwitchesPorts> pageItems;

	private SwitchesPorts example = new SwitchesPorts();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 1000;
	}

	public SwitchesPorts getExample() {
		return this.example;
	}

	public void setExample(SwitchesPorts example) {
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
		Root<SwitchesPorts> root = countCriteria.from(SwitchesPorts.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<SwitchesPorts> criteria = builder
				.createQuery(SwitchesPorts.class);
		root = criteria.from(SwitchesPorts.class);
		TypedQuery<SwitchesPorts> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<SwitchesPorts> root) {

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
		String port = this.example.getPort();
		if (port != null && !"".equals(port)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("port")),
					'%' + port.toLowerCase() + '%'));
		}
		String code = this.example.getCode();
		if (code != null && !"".equals(code)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("code")),
					'%' + code.toLowerCase() + '%'));
		}
		String state = this.example.getState();
		if (state != null && !"".equals(state)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("state")),
					'%' + state.toLowerCase() + '%'));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<SwitchesPorts> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back SwitchesPorts entities (e.g. from inside
	 * an HtmlSelectOneMenu)
	 */

	public List<SwitchesPorts> getAll() {

		CriteriaQuery<SwitchesPorts> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(SwitchesPorts.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(SwitchesPorts.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final SwitchesPortsBean ejbProxy = this.sessionContext
				.getBusinessObject(SwitchesPortsBean.class);

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

				return String.valueOf(((SwitchesPorts) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private SwitchesPorts add = new SwitchesPorts();

	public SwitchesPorts getAdd() {
		return this.add;
	}

	public SwitchesPorts getAdded() {
		SwitchesPorts added = this.add;
		this.add = new SwitchesPorts();
		return added;
	}
}
