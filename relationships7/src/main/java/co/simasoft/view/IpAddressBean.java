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

import co.simasoft.models.IpAddress;
import co.simasoft.models.Sites;
import java.lang.Boolean;
import java.util.Iterator;

/**
 * Backing bean for IpAddress entities.
 * <p/>
 * This class provides CRUD functionality for all IpAddress entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class IpAddressBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving IpAddress entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private IpAddress ipAddress;

	public IpAddress getIpAddress() {
		return this.ipAddress;
	}

	public void setIpAddress(IpAddress ipAddress) {
		this.ipAddress = ipAddress;
	}

	@Inject
	private Conversation conversation;

	@PersistenceContext(unitName = "relationships7PU-JTA", type = PersistenceContextType.EXTENDED)
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
			this.ipAddress = this.example;
		} else {
			this.ipAddress = findById(getId());
		}
	}

	public IpAddress findById(Long id) {

		return this.entityManager.find(IpAddress.class, id);
	}

	/*
	 * Support updating and deleting IpAddress entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.ipAddress);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.ipAddress);
				return "view?faces-redirect=true&id=" + this.ipAddress.getId();
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
			IpAddress deletableEntity = findById(getId());
			Iterator<Sites> iterSites = deletableEntity.getSites().iterator();
			for (; iterSites.hasNext();) {
				Sites nextInSites = iterSites.next();
				nextInSites.getIpAddress().remove(deletableEntity);
				iterSites.remove();
				this.entityManager.merge(nextInSites);
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
	 * Support searching IpAddress entities with pagination
	 */

	private int page;
	private long count;
	private List<IpAddress> pageItems;

	private IpAddress example = new IpAddress();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public IpAddress getExample() {
		return this.example;
	}

	public void setExample(IpAddress example) {
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
		Root<IpAddress> root = countCriteria.from(IpAddress.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<IpAddress> criteria = builder
				.createQuery(IpAddress.class);
		root = criteria.from(IpAddress.class);
		TypedQuery<IpAddress> query = this.entityManager.createQuery(criteria
				.select(root).where(getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<IpAddress> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		String observations = this.example.getObservations();
		if (observations != null && !"".equals(observations)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("observations")),
					'%' + observations.toLowerCase() + '%'));
		}
		String ipAddress = this.example.getIpAddress();
		if (ipAddress != null && !"".equals(ipAddress)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("ipAddress")),
					'%' + ipAddress.toLowerCase() + '%'));
		}
		Boolean isActive = this.example.getIsActive();
		if (isActive != null) {
			predicatesList.add(builder.equal(root.get("isActive"), isActive));
		}
		String state = this.example.getState();
		if (state != null && !"".equals(state)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("state")),
					'%' + state.toLowerCase() + '%'));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<IpAddress> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back IpAddress entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<IpAddress> getAll() {

		CriteriaQuery<IpAddress> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(IpAddress.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(IpAddress.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final IpAddressBean ejbProxy = this.sessionContext
				.getBusinessObject(IpAddressBean.class);

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

				return String.valueOf(((IpAddress) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private IpAddress add = new IpAddress();

	public IpAddress getAdd() {
		return this.add;
	}

	public IpAddress getAdded() {
		IpAddress added = this.add;
		this.add = new IpAddress();
		return added;
	}
}
