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

import co.simasoft.models.ConstructionActivities;
import co.simasoft.models.Apus;
import co.simasoft.models.ConstructionChapters;
import co.simasoft.models.TypesWorksConstruction;
import co.simasoft.models.WorkActivities;
import java.util.Iterator;

/**
 * Backing bean for ConstructionActivities entities.
 * <p/>
 * This class provides CRUD functionality for all ConstructionActivities
 * entities. It focuses purely on Java EE 6 standards (e.g.
 * <tt>&#64;ConversationScoped</tt> for state management,
 * <tt>PersistenceContext</tt> for persistence, <tt>CriteriaBuilder</tt> for
 * searches) rather than introducing a CRUD framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class ConstructionActivitiesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving ConstructionActivities entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private ConstructionActivities constructionActivities;

	public ConstructionActivities getConstructionActivities() {
		return this.constructionActivities;
	}

	public void setConstructionActivities(
			ConstructionActivities constructionActivities) {
		this.constructionActivities = constructionActivities;
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
			this.constructionActivities = this.example;
		} else {
			this.constructionActivities = findById(getId());
		}
	}

	public ConstructionActivities findById(Long id) {

		return this.entityManager.find(ConstructionActivities.class, id);
	}

	/*
	 * Support updating and deleting ConstructionActivities entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.constructionActivities);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.constructionActivities);
				return "view?faces-redirect=true&id="
						+ this.constructionActivities.getId();
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
			ConstructionActivities deletableEntity = findById(getId());
			Iterator<WorkActivities> iterWorkActivities = deletableEntity
					.getWorkActivities().iterator();
			for (; iterWorkActivities.hasNext();) {
				WorkActivities nextInWorkActivities = iterWorkActivities.next();
				nextInWorkActivities.setConstructionActivities(null);
				iterWorkActivities.remove();
				this.entityManager.merge(nextInWorkActivities);
			}
			Iterator<Apus> iterApus = deletableEntity.getApus().iterator();
			for (; iterApus.hasNext();) {
				Apus nextInApus = iterApus.next();
				nextInApus.setConstructionActivities(null);
				iterApus.remove();
				this.entityManager.merge(nextInApus);
			}
			Iterator<TypesWorksConstruction> iterTypesWorksConstruction = deletableEntity
					.getTypesWorksConstruction().iterator();
			for (; iterTypesWorksConstruction.hasNext();) {
				TypesWorksConstruction nextInTypesWorksConstruction = iterTypesWorksConstruction
						.next();
				nextInTypesWorksConstruction.getConstructionActivities()
						.remove(deletableEntity);
				iterTypesWorksConstruction.remove();
				this.entityManager.merge(nextInTypesWorksConstruction);
			}
			ConstructionChapters constructionChapters = deletableEntity
					.getConstructionChapters();
			constructionChapters.getConstructionActivities().remove(
					deletableEntity);
			deletableEntity.setConstructionChapters(null);
			this.entityManager.merge(constructionChapters);
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
	 * Support searching ConstructionActivities entities with pagination
	 */

	private int page;
	private long count;
	private List<ConstructionActivities> pageItems;

	private ConstructionActivities example = new ConstructionActivities();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public ConstructionActivities getExample() {
		return this.example;
	}

	public void setExample(ConstructionActivities example) {
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
		Root<ConstructionActivities> root = countCriteria
				.from(ConstructionActivities.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<ConstructionActivities> criteria = builder
				.createQuery(ConstructionActivities.class);
		root = criteria.from(ConstructionActivities.class);
		TypedQuery<ConstructionActivities> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<ConstructionActivities> root) {

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
		String name = this.example.getName();
		if (name != null && !"".equals(name)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("name")),
					'%' + name.toLowerCase() + '%'));
		}
		ConstructionChapters constructionChapters = this.example
				.getConstructionChapters();
		if (constructionChapters != null) {
			predicatesList.add(builder.equal(root.get("constructionChapters"),
					constructionChapters));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<ConstructionActivities> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back ConstructionActivities entities (e.g.
	 * from inside an HtmlSelectOneMenu)
	 */

	public List<ConstructionActivities> getAll() {

		CriteriaQuery<ConstructionActivities> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(ConstructionActivities.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(ConstructionActivities.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final ConstructionActivitiesBean ejbProxy = this.sessionContext
				.getBusinessObject(ConstructionActivitiesBean.class);

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

				return String.valueOf(((ConstructionActivities) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private ConstructionActivities add = new ConstructionActivities();

	public ConstructionActivities getAdd() {
		return this.add;
	}

	public ConstructionActivities getAdded() {
		ConstructionActivities added = this.add;
		this.add = new ConstructionActivities();
		return added;
	}
}