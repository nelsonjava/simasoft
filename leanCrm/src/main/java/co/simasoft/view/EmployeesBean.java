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

import co.simasoft.models.Employees;
import co.simasoft.models.Charges;
import co.simasoft.models.Companies;
import co.simasoft.models.EmployeesTypes;
import co.simasoft.models.Persons;
import co.simasoft.models.PhysicalSpaces;
import java.util.Iterator;

/**
 * Backing bean for Employees entities.
 * <p/>
 * This class provides CRUD functionality for all Employees entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class EmployeesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving Employees entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Employees employees;

	public Employees getEmployees() {
		return this.employees;
	}

	public void setEmployees(Employees employees) {
		this.employees = employees;
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
			this.employees = this.example;
		} else {
			this.employees = findById(getId());
		}
	}

	public Employees findById(Long id) {

		return this.entityManager.find(Employees.class, id);
	}

	/*
	 * Support updating and deleting Employees entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.employees);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.employees);
				return "view?faces-redirect=true&id=" + this.employees.getId();
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
			Employees deletableEntity = findById(getId());
			Iterator<Charges> iterCharges = deletableEntity.getCharges()
					.iterator();
			for (; iterCharges.hasNext();) {
				Charges nextInCharges = iterCharges.next();
				nextInCharges.getEmployees().remove(deletableEntity);
				iterCharges.remove();
				this.entityManager.merge(nextInCharges);
			}
			PhysicalSpaces physicalSpaces = deletableEntity.getPhysicalSpaces();
			physicalSpaces.getEmployees().remove(deletableEntity);
			deletableEntity.setPhysicalSpaces(null);
			this.entityManager.merge(physicalSpaces);
			Persons persons = deletableEntity.getPersons();
			persons.getEmployees().remove(deletableEntity);
			deletableEntity.setPersons(null);
			this.entityManager.merge(persons);
			EmployeesTypes employeesTypes = deletableEntity.getEmployeesTypes();
			employeesTypes.getEmployees().remove(deletableEntity);
			deletableEntity.setEmployeesTypes(null);
			this.entityManager.merge(employeesTypes);
			Companies companies = deletableEntity.getCompanies();
			companies.getEmployees().remove(deletableEntity);
			deletableEntity.setCompanies(null);
			this.entityManager.merge(companies);
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
	 * Support searching Employees entities with pagination
	 */

	private int page;
	private long count;
	private List<Employees> pageItems;

	private Employees example = new Employees();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public Employees getExample() {
		return this.example;
	}

	public void setExample(Employees example) {
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
		Root<Employees> root = countCriteria.from(Employees.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<Employees> criteria = builder
				.createQuery(Employees.class);
		root = criteria.from(Employees.class);
		TypedQuery<Employees> query = this.entityManager.createQuery(criteria
				.select(root).where(getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<Employees> root) {

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
		String code = this.example.getCode();
		if (code != null && !"".equals(code)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("code")),
					'%' + code.toLowerCase() + '%'));
		}
		PhysicalSpaces physicalSpaces = this.example.getPhysicalSpaces();
		if (physicalSpaces != null) {
			predicatesList.add(builder.equal(root.get("physicalSpaces"),
					physicalSpaces));
		}
		Persons persons = this.example.getPersons();
		if (persons != null) {
			predicatesList.add(builder.equal(root.get("persons"), persons));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<Employees> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back Employees entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<Employees> getAll() {

		CriteriaQuery<Employees> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(Employees.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(Employees.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final EmployeesBean ejbProxy = this.sessionContext
				.getBusinessObject(EmployeesBean.class);

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

				return String.valueOf(((Employees) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private Employees add = new Employees();

	public Employees getAdd() {
		return this.add;
	}

	public Employees getAdded() {
		Employees added = this.add;
		this.add = new Employees();
		return added;
	}
}