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

import co.simasoft.models.ClosingActivities;
import co.simasoft.models.ImprovementClosures;
import java.lang.Boolean;

/**
 * Backing bean for ClosingActivities entities.
 * <p/>
 * This class provides CRUD functionality for all ClosingActivities entities. It
 * focuses purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt>
 * for state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class ClosingActivitiesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving ClosingActivities entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private ClosingActivities closingActivities;

	public ClosingActivities getClosingActivities() {
		return this.closingActivities;
	}

	public void setClosingActivities(ClosingActivities closingActivities) {
		this.closingActivities = closingActivities;
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
			this.closingActivities = this.example;
		} else {
			this.closingActivities = findById(getId());
		}
	}

	public ClosingActivities findById(Long id) {

		return this.entityManager.find(ClosingActivities.class, id);
	}

	/*
	 * Support updating and deleting ClosingActivities entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.closingActivities);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.closingActivities);
				return "view?faces-redirect=true&id="
						+ this.closingActivities.getId();
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
			ClosingActivities deletableEntity = findById(getId());
			ImprovementClosures improvementClosures = deletableEntity
					.getImprovementClosures();
			improvementClosures.getClosingActivities().remove(deletableEntity);
			deletableEntity.setImprovementClosures(null);
			this.entityManager.merge(improvementClosures);
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
	 * Support searching ClosingActivities entities with pagination
	 */

	private int page;
	private long count;
	private List<ClosingActivities> pageItems;

	private ClosingActivities example = new ClosingActivities();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 1000;
	}

	public ClosingActivities getExample() {
		return this.example;
	}

	public void setExample(ClosingActivities example) {
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
		Root<ClosingActivities> root = countCriteria
				.from(ClosingActivities.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<ClosingActivities> criteria = builder
				.createQuery(ClosingActivities.class);
		root = criteria.from(ClosingActivities.class);
		TypedQuery<ClosingActivities> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<ClosingActivities> root) {

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
		Boolean isSiorNo = this.example.getIsSiorNo();
		if (isSiorNo != null) {
			predicatesList.add(builder.equal(root.get("isSiorNo"), isSiorNo));
		}
		ImprovementClosures improvementClosures = this.example
				.getImprovementClosures();
		if (improvementClosures != null) {
			predicatesList.add(builder.equal(root.get("improvementClosures"),
					improvementClosures));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<ClosingActivities> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back ClosingActivities entities (e.g. from
	 * inside an HtmlSelectOneMenu)
	 */

	public List<ClosingActivities> getAll() {

		CriteriaQuery<ClosingActivities> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(ClosingActivities.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(ClosingActivities.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final ClosingActivitiesBean ejbProxy = this.sessionContext
				.getBusinessObject(ClosingActivitiesBean.class);

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

				return String.valueOf(((ClosingActivities) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private ClosingActivities add = new ClosingActivities();

	public ClosingActivities getAdd() {
		return this.add;
	}

	public ClosingActivities getAdded() {
		ClosingActivities added = this.add;
		this.add = new ClosingActivities();
		return added;
	}
}
