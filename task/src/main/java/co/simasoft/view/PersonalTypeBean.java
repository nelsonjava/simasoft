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

import co.simasoft.models.naif.task.persons.PersonalType;
import co.simasoft.models.naif.task.persons.Persons;
import java.util.Iterator;

/**
 * Backing bean for PersonalType entities.
 * <p/>
 * This class provides CRUD functionality for all PersonalType entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class PersonalTypeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving PersonalType entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private PersonalType personalType;

	public PersonalType getPersonalType() {
		return this.personalType;
	}

	public void setPersonalType(PersonalType personalType) {
		this.personalType = personalType;
	}

	@Inject
	private Conversation conversation;

	@PersistenceContext(unitName = "taskPU-JTA", type = PersistenceContextType.EXTENDED)
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
			this.personalType = this.example;
		} else {
			this.personalType = findById(getId());
		}
	}

	public PersonalType findById(Long id) {

		return this.entityManager.find(PersonalType.class, id);
	}

	/*
	 * Support updating and deleting PersonalType entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.personalType);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.personalType);
				return "view?faces-redirect=true&id="
						+ this.personalType.getId();
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
			PersonalType deletableEntity = findById(getId());
			Iterator<Persons> iterPersons = deletableEntity.getPersons()
					.iterator();
			for (; iterPersons.hasNext();) {
				Persons nextInPersons = iterPersons.next();
				nextInPersons.setPersonalType(null);
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
	 * Support searching PersonalType entities with pagination
	 */

	private int page;
	private long count;
	private List<PersonalType> pageItems;

	private PersonalType example = new PersonalType();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public PersonalType getExample() {
		return this.example;
	}

	public void setExample(PersonalType example) {
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
		Root<PersonalType> root = countCriteria.from(PersonalType.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<PersonalType> criteria = builder
				.createQuery(PersonalType.class);
		root = criteria.from(PersonalType.class);
		TypedQuery<PersonalType> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<PersonalType> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		String name = this.example.getName();
		if (name != null && !"".equals(name)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("name")),
					'%' + name.toLowerCase() + '%'));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<PersonalType> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back PersonalType entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<PersonalType> getAll() {

		CriteriaQuery<PersonalType> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(PersonalType.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(PersonalType.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final PersonalTypeBean ejbProxy = this.sessionContext
				.getBusinessObject(PersonalTypeBean.class);

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

				return String.valueOf(((PersonalType) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private PersonalType add = new PersonalType();

	public PersonalType getAdd() {
		return this.add;
	}

	public PersonalType getAdded() {
		PersonalType added = this.add;
		this.add = new PersonalType();
		return added;
	}
}
