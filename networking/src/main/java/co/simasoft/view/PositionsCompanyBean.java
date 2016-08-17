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

import co.simasoft.models.PositionsCompany;
import co.simasoft.models.Employees;

/**
 * Backing bean for PositionsCompany entities.
 * <p/>
 * This class provides CRUD functionality for all PositionsCompany entities. It
 * focuses purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt>
 * for state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class PositionsCompanyBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving PositionsCompany entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private PositionsCompany positionsCompany;

	public PositionsCompany getPositionsCompany() {
		return this.positionsCompany;
	}

	public void setPositionsCompany(PositionsCompany positionsCompany) {
		this.positionsCompany = positionsCompany;
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
			this.positionsCompany = this.example;
		} else {
			this.positionsCompany = findById(getId());
		}
	}

	public PositionsCompany findById(Long id) {

		return this.entityManager.find(PositionsCompany.class, id);
	}

	/*
	 * Support updating and deleting PositionsCompany entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.positionsCompany);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.positionsCompany);
				return "view?faces-redirect=true&id="
						+ this.positionsCompany.getId();
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
			PositionsCompany deletableEntity = findById(getId());
			Employees employees = deletableEntity.getEmployees();
			employees.getPositionsCompany().remove(deletableEntity);
			deletableEntity.setEmployees(null);
			this.entityManager.merge(employees);
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
	 * Support searching PositionsCompany entities with pagination
	 */

	private int page;
	private long count;
	private List<PositionsCompany> pageItems;

	private PositionsCompany example = new PositionsCompany();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public PositionsCompany getExample() {
		return this.example;
	}

	public void setExample(PositionsCompany example) {
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
		Root<PositionsCompany> root = countCriteria
				.from(PositionsCompany.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<PositionsCompany> criteria = builder
				.createQuery(PositionsCompany.class);
		root = criteria.from(PositionsCompany.class);
		TypedQuery<PositionsCompany> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<PositionsCompany> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

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
		Employees employees = this.example.getEmployees();
		if (employees != null) {
			predicatesList.add(builder.equal(root.get("employees"), employees));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<PositionsCompany> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back PositionsCompany entities (e.g. from
	 * inside an HtmlSelectOneMenu)
	 */

	public List<PositionsCompany> getAll() {

		CriteriaQuery<PositionsCompany> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(PositionsCompany.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(PositionsCompany.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final PositionsCompanyBean ejbProxy = this.sessionContext
				.getBusinessObject(PositionsCompanyBean.class);

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

				return String.valueOf(((PositionsCompany) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private PositionsCompany add = new PositionsCompany();

	public PositionsCompany getAdd() {
		return this.add;
	}

	public PositionsCompany getAdded() {
		PositionsCompany added = this.add;
		this.add = new PositionsCompany();
		return added;
	}
}
