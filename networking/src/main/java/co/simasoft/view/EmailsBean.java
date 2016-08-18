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

import co.simasoft.models.Emails;
import co.simasoft.models.Persons;

/**
 * Backing bean for Emails entities.
 * <p/>
 * This class provides CRUD functionality for all Emails entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class EmailsBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving Emails entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Emails emails;

	public Emails getEmails() {
		return this.emails;
	}

	public void setEmails(Emails emails) {
		this.emails = emails;
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
			this.emails = this.example;
		} else {
			this.emails = findById(getId());
		}
	}

	public Emails findById(Long id) {

		return this.entityManager.find(Emails.class, id);
	}

	/*
	 * Support updating and deleting Emails entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.emails);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.emails);
				return "view?faces-redirect=true&id=" + this.emails.getId();
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
			Emails deletableEntity = findById(getId());
			Persons persons = deletableEntity.getPersons();
			persons.getEmails().remove(deletableEntity);
			deletableEntity.setPersons(null);
			this.entityManager.merge(persons);
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
	 * Support searching Emails entities with pagination
	 */

	private int page;
	private long count;
	private List<Emails> pageItems;

	private Emails example = new Emails();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 1000;
	}

	public Emails getExample() {
		return this.example;
	}

	public void setExample(Emails example) {
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
		Root<Emails> root = countCriteria.from(Emails.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<Emails> criteria = builder.createQuery(Emails.class);
		root = criteria.from(Emails.class);
		TypedQuery<Emails> query = this.entityManager.createQuery(criteria
				.select(root).where(getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<Emails> root) {

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
		String email = this.example.getEmail();
		if (email != null && !"".equals(email)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("email")),
					'%' + email.toLowerCase() + '%'));
		}
		Persons persons = this.example.getPersons();
		if (persons != null) {
			predicatesList.add(builder.equal(root.get("persons"), persons));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<Emails> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back Emails entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<Emails> getAll() {

		CriteriaQuery<Emails> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(Emails.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(Emails.class))).getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final EmailsBean ejbProxy = this.sessionContext
				.getBusinessObject(EmailsBean.class);

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

				return String.valueOf(((Emails) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private Emails add = new Emails();

	public Emails getAdd() {
		return this.add;
	}

	public Emails getAdded() {
		Emails added = this.add;
		this.add = new Emails();
		return added;
	}
}
