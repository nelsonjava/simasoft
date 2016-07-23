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

import co.simasoft.models.GroupIdsRelationships;
import co.simasoft.models.GroupIds;
import co.simasoft.models.Relationships;
import java.lang.Boolean;

/**
 * Backing bean for GroupIdsRelationships entities.
 * <p/>
 * This class provides CRUD functionality for all GroupIdsRelationships
 * entities. It focuses purely on Java EE 6 standards (e.g.
 * <tt>&#64;ConversationScoped</tt> for state management,
 * <tt>PersistenceContext</tt> for persistence, <tt>CriteriaBuilder</tt> for
 * searches) rather than introducing a CRUD framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class GroupIdsRelationshipsBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving GroupIdsRelationships entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private GroupIdsRelationships groupIdsRelationships;

	public GroupIdsRelationships getGroupIdsRelationships() {
		return this.groupIdsRelationships;
	}

	public void setGroupIdsRelationships(
			GroupIdsRelationships groupIdsRelationships) {
		this.groupIdsRelationships = groupIdsRelationships;
	}

	@Inject
	private Conversation conversation;

	@PersistenceContext(unitName = "naifg25PU-JTA", type = PersistenceContextType.EXTENDED)
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
			this.groupIdsRelationships = this.example;
		} else {
			this.groupIdsRelationships = findById(getId());
		}
	}

	public GroupIdsRelationships findById(Long id) {

		return this.entityManager.find(GroupIdsRelationships.class, id);
	}

	/*
	 * Support updating and deleting GroupIdsRelationships entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.groupIdsRelationships);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.groupIdsRelationships);
				return "view?faces-redirect=true&id="
						+ this.groupIdsRelationships.getId();
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
			GroupIdsRelationships deletableEntity = findById(getId());
			Relationships relationships = deletableEntity.getRelationships();
			relationships.getGroupIdsRelationships().remove(deletableEntity);
			deletableEntity.setRelationships(null);
			this.entityManager.merge(relationships);
			GroupIds groupIds = deletableEntity.getGroupIds();
			groupIds.getGroupIdsRelationships().remove(deletableEntity);
			deletableEntity.setGroupIds(null);
			this.entityManager.merge(groupIds);
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
	 * Support searching GroupIdsRelationships entities with pagination
	 */

	private int page;
	private long count;
	private List<GroupIdsRelationships> pageItems;

	private GroupIdsRelationships example = new GroupIdsRelationships();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public GroupIdsRelationships getExample() {
		return this.example;
	}

	public void setExample(GroupIdsRelationships example) {
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
		Root<GroupIdsRelationships> root = countCriteria
				.from(GroupIdsRelationships.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<GroupIdsRelationships> criteria = builder
				.createQuery(GroupIdsRelationships.class);
		root = criteria.from(GroupIdsRelationships.class);
		TypedQuery<GroupIdsRelationships> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<GroupIdsRelationships> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		String observations = this.example.getObservations();
		if (observations != null && !"".equals(observations)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("observations")),
					'%' + observations.toLowerCase() + '%'));
		}
		Boolean isIsolated = this.example.getIsIsolated();
		if (isIsolated != null) {
			predicatesList
					.add(builder.equal(root.get("isIsolated"), isIsolated));
		}
		Boolean isSimplified = this.example.getIsSimplified();
		if (isSimplified != null) {
			predicatesList.add(builder.equal(root.get("isSimplified"),
					isSimplified));
		}
		Relationships relationships = this.example.getRelationships();
		if (relationships != null) {
			predicatesList.add(builder.equal(root.get("relationships"),
					relationships));
		}
		GroupIds groupIds = this.example.getGroupIds();
		if (groupIds != null) {
			predicatesList.add(builder.equal(root.get("groupIds"), groupIds));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<GroupIdsRelationships> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back GroupIdsRelationships entities (e.g.
	 * from inside an HtmlSelectOneMenu)
	 */

	public List<GroupIdsRelationships> getAll() {

		CriteriaQuery<GroupIdsRelationships> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(GroupIdsRelationships.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(GroupIdsRelationships.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final GroupIdsRelationshipsBean ejbProxy = this.sessionContext
				.getBusinessObject(GroupIdsRelationshipsBean.class);

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

				return String.valueOf(((GroupIdsRelationships) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private GroupIdsRelationships add = new GroupIdsRelationships();

	public GroupIdsRelationships getAdd() {
		return this.add;
	}

	public GroupIdsRelationships getAdded() {
		GroupIdsRelationships added = this.add;
		this.add = new GroupIdsRelationships();
		return added;
	}
}
