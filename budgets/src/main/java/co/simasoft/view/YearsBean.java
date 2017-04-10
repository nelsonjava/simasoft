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

import co.simasoft.models.Years;
import co.simasoft.models.WorksConstruction;
import java.util.Iterator;

/**
 * Backing bean for Years entities.
 * <p/>
 * This class provides CRUD functionality for all Years entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class YearsBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving Years entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Years years;

	public Years getYears() {
		return this.years;
	}

	public void setYears(Years years) {
		this.years = years;
	}

	@Inject
	private Conversation conversation;

	@PersistenceContext(unitName = "budgetsPU-JTA", type = PersistenceContextType.EXTENDED)
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
			this.years = this.example;
		} else {
			this.years = findById(getId());
		}
	}

	public Years findById(Long id) {

		return this.entityManager.find(Years.class, id);
	}

	/*
	 * Support updating and deleting Years entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.years);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.years);
				return "view?faces-redirect=true&id=" + this.years.getId();
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
			Years deletableEntity = findById(getId());
			Iterator<WorksConstruction> iterWorksConstruction = deletableEntity
					.getWorksConstruction().iterator();
			for (; iterWorksConstruction.hasNext();) {
				WorksConstruction nextInWorksConstruction = iterWorksConstruction
						.next();
				nextInWorksConstruction.setYears(null);
				iterWorksConstruction.remove();
				this.entityManager.merge(nextInWorksConstruction);
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
	 * Support searching Years entities with pagination
	 */

	private int page;
	private long count;
	private List<Years> pageItems;

	private Years example = new Years();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public Years getExample() {
		return this.example;
	}

	public void setExample(Years example) {
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
		Root<Years> root = countCriteria.from(Years.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<Years> criteria = builder.createQuery(Years.class);
		root = criteria.from(Years.class);
		TypedQuery<Years> query = this.entityManager.createQuery(criteria
				.select(root).where(getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<Years> root) {

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
		String year = this.example.getYear();
		if (year != null && !"".equals(year)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("year")),
					'%' + year.toLowerCase() + '%'));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<Years> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back Years entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<Years> getAll() {

		CriteriaQuery<Years> criteria = this.entityManager.getCriteriaBuilder()
				.createQuery(Years.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(Years.class))).getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final YearsBean ejbProxy = this.sessionContext
				.getBusinessObject(YearsBean.class);

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

				return String.valueOf(((Years) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private Years add = new Years();

	public Years getAdd() {
		return this.add;
	}

	public Years getAdded() {
		Years added = this.add;
		this.add = new Years();
		return added;
	}
}
