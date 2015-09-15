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

import co.simasoft.models.dev.naifg.GroupIdsFiles;
import co.simasoft.models.dev.naifg.GroupIds;

/**
 * Backing bean for GroupIdsFiles entities.
 * <p/>
 * This class provides CRUD functionality for all GroupIdsFiles entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class GroupIdsFilesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving GroupIdsFiles entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private GroupIdsFiles groupIdsFiles;

	public GroupIdsFiles getGroupIdsFiles() {
		return this.groupIdsFiles;
	}

	public void setGroupIdsFiles(GroupIdsFiles groupIdsFiles) {
		this.groupIdsFiles = groupIdsFiles;
	}

	@Inject
	private Conversation conversation;

	@PersistenceContext(unitName = "naifgPU-JTA", type = PersistenceContextType.EXTENDED)
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
			this.groupIdsFiles = this.example;
		} else {
			this.groupIdsFiles = findById(getId());
		}
	}

	public GroupIdsFiles findById(Long id) {

		return this.entityManager.find(GroupIdsFiles.class, id);
	}

	/*
	 * Support updating and deleting GroupIdsFiles entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.groupIdsFiles);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.groupIdsFiles);
				return "view?faces-redirect=true&id="
						+ this.groupIdsFiles.getId();
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
			GroupIdsFiles deletableEntity = findById(getId());
			GroupIds groupIds = deletableEntity.getGroupIds();
			groupIds.getGroupIdsFiles().remove(deletableEntity);
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
	 * Support searching GroupIdsFiles entities with pagination
	 */

	private int page;
	private long count;
	private List<GroupIdsFiles> pageItems;

	private GroupIdsFiles example = new GroupIdsFiles();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public GroupIdsFiles getExample() {
		return this.example;
	}

	public void setExample(GroupIdsFiles example) {
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
		Root<GroupIdsFiles> root = countCriteria.from(GroupIdsFiles.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<GroupIdsFiles> criteria = builder
				.createQuery(GroupIdsFiles.class);
		root = criteria.from(GroupIdsFiles.class);
		TypedQuery<GroupIdsFiles> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<GroupIdsFiles> root) {

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
		String type = this.example.getType();
		if (type != null && !"".equals(type)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("type")),
					'%' + type.toLowerCase() + '%'));
		}
		GroupIds groupIds = this.example.getGroupIds();
		if (groupIds != null) {
			predicatesList.add(builder.equal(root.get("groupIds"), groupIds));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<GroupIdsFiles> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back GroupIdsFiles entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<GroupIdsFiles> getAll() {

		CriteriaQuery<GroupIdsFiles> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(GroupIdsFiles.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(GroupIdsFiles.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final GroupIdsFilesBean ejbProxy = this.sessionContext
				.getBusinessObject(GroupIdsFilesBean.class);

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

				return String.valueOf(((GroupIdsFiles) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private GroupIdsFiles add = new GroupIdsFiles();

	public GroupIdsFiles getAdd() {
		return this.add;
	}

	public GroupIdsFiles getAdded() {
		GroupIdsFiles added = this.add;
		this.add = new GroupIdsFiles();
		return added;
	}
}
