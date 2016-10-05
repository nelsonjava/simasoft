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

import co.simasoft.models.Persons;
import co.simasoft.models.Activities;
import co.simasoft.models.Employees;
import co.simasoft.models.Tasks;
import java.util.Iterator;

/**
 * Backing bean for Persons entities.
 * <p/>
 * This class provides CRUD functionality for all Persons entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class PersonsBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving Persons entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Persons persons;

	public Persons getPersons() {
		return this.persons;
	}

	public void setPersons(Persons persons) {
		this.persons = persons;
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
			this.persons = this.example;
		} else {
			this.persons = findById(getId());
		}
	}

	public Persons findById(Long id) {

		return this.entityManager.find(Persons.class, id);
	}

	/*
	 * Support updating and deleting Persons entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.persons);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.persons);
				return "view?faces-redirect=true&id=" + this.persons.getId();
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
			Persons deletableEntity = findById(getId());
			Iterator<Tasks> iterTasks = deletableEntity.getTasks().iterator();
			for (; iterTasks.hasNext();) {
				Tasks nextInTasks = iterTasks.next();
				nextInTasks.setPersons(null);
				iterTasks.remove();
				this.entityManager.merge(nextInTasks);
			}
			Iterator<Activities> iterActivities = deletableEntity
					.getActivities().iterator();
			for (; iterActivities.hasNext();) {
				Activities nextInActivities = iterActivities.next();
				nextInActivities.setPersons(null);
				iterActivities.remove();
				this.entityManager.merge(nextInActivities);
			}
			Iterator<Employees> iterEmployees = deletableEntity.getEmployees()
					.iterator();
			for (; iterEmployees.hasNext();) {
				Employees nextInEmployees = iterEmployees.next();
				nextInEmployees.setPersons(null);
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
	 * Support searching Persons entities with pagination
	 */

	private int page;
	private long count;
	private List<Persons> pageItems;

	private Persons example = new Persons();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public Persons getExample() {
		return this.example;
	}

	public void setExample(Persons example) {
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
		Root<Persons> root = countCriteria.from(Persons.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<Persons> criteria = builder.createQuery(Persons.class);
		root = criteria.from(Persons.class);
		TypedQuery<Persons> query = this.entityManager.createQuery(criteria
				.select(root).where(getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<Persons> root) {

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
		String firstName = this.example.getFirstName();
		if (firstName != null && !"".equals(firstName)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("firstName")),
					'%' + firstName.toLowerCase() + '%'));
		}
		String secondName = this.example.getSecondName();
		if (secondName != null && !"".equals(secondName)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("secondName")),
					'%' + secondName.toLowerCase() + '%'));
		}
		String firstLastName = this.example.getFirstLastName();
		if (firstLastName != null && !"".equals(firstLastName)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("firstLastName")),
					'%' + firstLastName.toLowerCase() + '%'));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<Persons> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back Persons entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<Persons> getAll() {

		CriteriaQuery<Persons> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(Persons.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(Persons.class))).getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final PersonsBean ejbProxy = this.sessionContext
				.getBusinessObject(PersonsBean.class);

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

				return String.valueOf(((Persons) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private Persons add = new Persons();

	public Persons getAdd() {
		return this.add;
	}

	public Persons getAdded() {
		Persons added = this.add;
		this.add = new Persons();
		return added;
	}
}
