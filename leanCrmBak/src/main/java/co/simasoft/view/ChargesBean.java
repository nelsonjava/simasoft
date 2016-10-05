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

import co.simasoft.models.Charges;
import co.simasoft.models.ChargesTypes;
import co.simasoft.models.CompaniesRoles;
import co.simasoft.models.Employees;
import java.util.Iterator;

/**
 * Backing bean for Charges entities.
 * <p/>
 * This class provides CRUD functionality for all Charges entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class ChargesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving Charges entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Charges charges;

	public Charges getCharges() {
		return this.charges;
	}

	public void setCharges(Charges charges) {
		this.charges = charges;
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
			this.charges = this.example;
		} else {
			this.charges = findById(getId());
		}
	}

	public Charges findById(Long id) {

		return this.entityManager.find(Charges.class, id);
	}

	/*
	 * Support updating and deleting Charges entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.charges);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.charges);
				return "view?faces-redirect=true&id=" + this.charges.getId();
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
			Charges deletableEntity = findById(getId());
			Iterator<CompaniesRoles> iterCompaniesRoles = deletableEntity
					.getCompaniesRoles().iterator();
			for (; iterCompaniesRoles.hasNext();) {
				CompaniesRoles nextInCompaniesRoles = iterCompaniesRoles.next();
				nextInCompaniesRoles.getCharges().remove(deletableEntity);
				iterCompaniesRoles.remove();
				this.entityManager.merge(nextInCompaniesRoles);
			}
			ChargesTypes chargesTypes = deletableEntity.getChargesTypes();
			chargesTypes.getCharges().remove(deletableEntity);
			deletableEntity.setChargesTypes(null);
			this.entityManager.merge(chargesTypes);
			Iterator<Employees> iterEmployees = deletableEntity.getEmployees()
					.iterator();
			for (; iterEmployees.hasNext();) {
				Employees nextInEmployees = iterEmployees.next();
				nextInEmployees.getCharges().remove(deletableEntity);
				iterEmployees.remove();
				this.entityManager.merge(nextInEmployees);
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
	 * Support searching Charges entities with pagination
	 */

	private int page;
	private long count;
	private List<Charges> pageItems;

	private Charges example = new Charges();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 1000;
	}

	public Charges getExample() {
		return this.example;
	}

	public void setExample(Charges example) {
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
		Root<Charges> root = countCriteria.from(Charges.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<Charges> criteria = builder.createQuery(Charges.class);
		root = criteria.from(Charges.class);
		TypedQuery<Charges> query = this.entityManager.createQuery(criteria
				.select(root).where(getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<Charges> root) {

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
		ChargesTypes chargesTypes = this.example.getChargesTypes();
		if (chargesTypes != null) {
			predicatesList.add(builder.equal(root.get("chargesTypes"),
					chargesTypes));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<Charges> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back Charges entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<Charges> getAll() {

		CriteriaQuery<Charges> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(Charges.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(Charges.class))).getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final ChargesBean ejbProxy = this.sessionContext
				.getBusinessObject(ChargesBean.class);

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

				return String.valueOf(((Charges) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private Charges add = new Charges();

	public Charges getAdd() {
		return this.add;
	}

	public Charges getAdded() {
		Charges added = this.add;
		this.add = new Charges();
		return added;
	}
}
