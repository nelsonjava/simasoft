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

import co.simasoft.models.GroupIds;
import co.simasoft.models.Entities;
import co.simasoft.models.GroupIdsTypes;
import co.simasoft.models.Models;
import co.simasoft.models.Pom;
import co.simasoft.models.Sites;
import java.util.Iterator;

/**
 * Backing bean for GroupIds entities.
 * <p/>
 * This class provides CRUD functionality for all GroupIds entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class GroupIdsBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving GroupIds entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private GroupIds groupIds;

	public GroupIds getGroupIds() {
		return this.groupIds;
	}

	public void setGroupIds(GroupIds groupIds) {
		this.groupIds = groupIds;
	}

	@Inject
	private Conversation conversation;

	@PersistenceContext(unitName = "naifg29PU-JTA", type = PersistenceContextType.EXTENDED)
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
			this.groupIds = this.example;
		} else {
			this.groupIds = findById(getId());
		}
	}

	public GroupIds findById(Long id) {

		return this.entityManager.find(GroupIds.class, id);
	}

	/*
	 * Support updating and deleting GroupIds entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.groupIds);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.groupIds);
				return "view?faces-redirect=true&id=" + this.groupIds.getId();
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
			GroupIds deletableEntity = findById(getId());
			Iterator<Pom> iterPom = deletableEntity.getPom().iterator();
			for (; iterPom.hasNext();) {
				Pom nextInPom = iterPom.next();
				nextInPom.getGroupIds().remove(deletableEntity);
				iterPom.remove();
				this.entityManager.merge(nextInPom);
			}
			Iterator<Sites> iterSites = deletableEntity.getSites().iterator();
			for (; iterSites.hasNext();) {
				Sites nextInSites = iterSites.next();
				nextInSites.getGroupIds().remove(deletableEntity);
				iterSites.remove();
				this.entityManager.merge(nextInSites);
			}
			Iterator<Entities> iterEntities = deletableEntity.getEntities()
					.iterator();
			for (; iterEntities.hasNext();) {
				Entities nextInEntities = iterEntities.next();
				nextInEntities.setGroupIds(null);
				iterEntities.remove();
				this.entityManager.merge(nextInEntities);
			}
			Iterator<Models> iterModels = deletableEntity.getModels()
					.iterator();
			for (; iterModels.hasNext();) {
				Models nextInModels = iterModels.next();
				nextInModels.setGroupIds(null);
				iterModels.remove();
				this.entityManager.merge(nextInModels);
			}
			GroupIdsTypes groupIdsTypes = deletableEntity.getGroupIdsTypes();
			groupIdsTypes.getGroupIds().remove(deletableEntity);
			deletableEntity.setGroupIdsTypes(null);
			this.entityManager.merge(groupIdsTypes);
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
	 * Support searching GroupIds entities with pagination
	 */

	private int page;
	private long count;
	private List<GroupIds> pageItems;

	private GroupIds example = new GroupIds();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 1000;
	}

	public GroupIds getExample() {
		return this.example;
	}

	public void setExample(GroupIds example) {
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
		Root<GroupIds> root = countCriteria.from(GroupIds.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<GroupIds> criteria = builder.createQuery(GroupIds.class);
		root = criteria.from(GroupIds.class);
		TypedQuery<GroupIds> query = this.entityManager.createQuery(criteria
				.select(root).where(getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<GroupIds> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		String observations = this.example.getObservations();
		if (observations != null && !"".equals(observations)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("observations")),
					'%' + observations.toLowerCase() + '%'));
		}
		String artifactId = this.example.getArtifactId();
		if (artifactId != null && !"".equals(artifactId)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("artifactId")),
					'%' + artifactId.toLowerCase() + '%'));
		}
		String groupId = this.example.getGroupId();
		if (groupId != null && !"".equals(groupId)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("groupId")),
					'%' + groupId.toLowerCase() + '%'));
		}
		String version = this.example.getVersion();
		if (version != null && !"".equals(version)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("version")),
					'%' + version.toLowerCase() + '%'));
		}
		String code = this.example.getCode();
		if (code != null && !"".equals(code)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("code")),
					'%' + code.toLowerCase() + '%'));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<GroupIds> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back GroupIds entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<GroupIds> getAll() {

		CriteriaQuery<GroupIds> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(GroupIds.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(GroupIds.class))).getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final GroupIdsBean ejbProxy = this.sessionContext
				.getBusinessObject(GroupIdsBean.class);

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

				return String.valueOf(((GroupIds) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private GroupIds add = new GroupIds();

	public GroupIds getAdd() {
		return this.add;
	}

	public GroupIds getAdded() {
		GroupIds added = this.add;
		this.add = new GroupIds();
		return added;
	}
}
