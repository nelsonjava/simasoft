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

import co.simasoft.models.Vlans;
import co.simasoft.models.SwitchesPorts;
import java.util.Iterator;

/**
 * Backing bean for Vlans entities.
 * <p/>
 * This class provides CRUD functionality for all Vlans entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class VlansBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving Vlans entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Vlans vlans;

	public Vlans getVlans() {
		return this.vlans;
	}

	public void setVlans(Vlans vlans) {
		this.vlans = vlans;
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
			this.vlans = this.example;
		} else {
			this.vlans = findById(getId());
		}
	}

	public Vlans findById(Long id) {

		return this.entityManager.find(Vlans.class, id);
	}

	/*
	 * Support updating and deleting Vlans entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.vlans);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.vlans);
				return "view?faces-redirect=true&id=" + this.vlans.getId();
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
			Vlans deletableEntity = findById(getId());
			Iterator<SwitchesPorts> iterSwitchesPorts = deletableEntity
					.getSwitchesPorts().iterator();
			for (; iterSwitchesPorts.hasNext();) {
				SwitchesPorts nextInSwitchesPorts = iterSwitchesPorts.next();
				nextInSwitchesPorts.setVlans(null);
				iterSwitchesPorts.remove();
				this.entityManager.merge(nextInSwitchesPorts);
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
	 * Support searching Vlans entities with pagination
	 */

	private int page;
	private long count;
	private List<Vlans> pageItems;

	private Vlans example = new Vlans();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 1000;
	}

	public Vlans getExample() {
		return this.example;
	}

	public void setExample(Vlans example) {
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
		Root<Vlans> root = countCriteria.from(Vlans.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<Vlans> criteria = builder.createQuery(Vlans.class);
		root = criteria.from(Vlans.class);
		TypedQuery<Vlans> query = this.entityManager.createQuery(criteria
				.select(root).where(getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<Vlans> root) {

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
		String name = this.example.getName();
		if (name != null && !"".equals(name)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("name")),
					'%' + name.toLowerCase() + '%'));
		}
		String ipMask = this.example.getIpMask();
		if (ipMask != null && !"".equals(ipMask)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("ipMask")),
					'%' + ipMask.toLowerCase() + '%'));
		}
		String ipGateway = this.example.getIpGateway();
		if (ipGateway != null && !"".equals(ipGateway)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("ipGateway")),
					'%' + ipGateway.toLowerCase() + '%'));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<Vlans> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back Vlans entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<Vlans> getAll() {

		CriteriaQuery<Vlans> criteria = this.entityManager.getCriteriaBuilder()
				.createQuery(Vlans.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(Vlans.class))).getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final VlansBean ejbProxy = this.sessionContext
				.getBusinessObject(VlansBean.class);

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

				return String.valueOf(((Vlans) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private Vlans add = new Vlans();

	public Vlans getAdd() {
		return this.add;
	}

	public Vlans getAdded() {
		Vlans added = this.add;
		this.add = new Vlans();
		return added;
	}
}
