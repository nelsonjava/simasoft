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

import co.simasoft.models.Address;
import co.simasoft.models.Persons;
import java.util.Iterator;

/**
 * Backing bean for Address entities.
 * <p/>
 * This class provides CRUD functionality for all Address entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class AddressBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving Address entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Address address;

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Inject
	private Conversation conversation;

	@PersistenceContext(unitName = "networkingPU-JTA", type = PersistenceContextType.EXTENDED)
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
			this.address = this.example;
		} else {
			this.address = findById(getId());
		}
	}

	public Address findById(Long id) {

		return this.entityManager.find(Address.class, id);
	}

	/*
	 * Support updating and deleting Address entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.address);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.address);
				return "view?faces-redirect=true&id=" + this.address.getId();
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
			Address deletableEntity = findById(getId());
			Iterator<Persons> iterPersons = deletableEntity.getPersons()
					.iterator();
			for (; iterPersons.hasNext();) {
				Persons nextInPersons = iterPersons.next();
				nextInPersons.getAddress().remove(deletableEntity);
				iterPersons.remove();
				this.entityManager.merge(nextInPersons);
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
	 * Support searching Address entities with pagination
	 */

	private int page;
	private long count;
	private List<Address> pageItems;

	private Address example = new Address();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 1000;
	}

	public Address getExample() {
		return this.example;
	}

	public void setExample(Address example) {
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
		Root<Address> root = countCriteria.from(Address.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<Address> criteria = builder.createQuery(Address.class);
		root = criteria.from(Address.class);
		TypedQuery<Address> query = this.entityManager.createQuery(criteria
				.select(root).where(getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<Address> root) {

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
		String address = this.example.getAddress();
		if (address != null && !"".equals(address)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("address")),
					'%' + address.toLowerCase() + '%'));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<Address> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back Address entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<Address> getAll() {

		CriteriaQuery<Address> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(Address.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(Address.class))).getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final AddressBean ejbProxy = this.sessionContext
				.getBusinessObject(AddressBean.class);

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

				return String.valueOf(((Address) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private Address add = new Address();

	public Address getAdd() {
		return this.add;
	}

	public Address getAdded() {
		Address added = this.add;
		this.add = new Address();
		return added;
	}
}
