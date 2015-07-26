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

import co.simasoft.models.naif.task.activities.Tasks;
import co.simasoft.models.naif.task.activities.Activities;
import co.simasoft.models.naif.task.activities.Diaries;
import java.util.Iterator;

/**
 * Backing bean for Tasks entities.
 * <p/>
 * This class provides CRUD functionality for all Tasks entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class TasksBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving Tasks entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Tasks tasks;

	public Tasks getTasks() {
		return this.tasks;
	}

	public void setTasks(Tasks tasks) {
		this.tasks = tasks;
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
			this.tasks = this.example;
		} else {
			this.tasks = findById(getId());
		}
	}

	public Tasks findById(Long id) {

		return this.entityManager.find(Tasks.class, id);
	}

	/*
	 * Support updating and deleting Tasks entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.tasks);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.tasks);
				return "view?faces-redirect=true&id=" + this.tasks.getId();
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
			Tasks deletableEntity = findById(getId());
			Iterator<Diaries> iterDiaries = deletableEntity.getDiaries()
					.iterator();
			for (; iterDiaries.hasNext();) {
				Diaries nextInDiaries = iterDiaries.next();
				nextInDiaries.setTasks(null);
				iterDiaries.remove();
				this.entityManager.merge(nextInDiaries);
			}
			Activities activities = deletableEntity.getActivities();
			activities.getTasks().remove(deletableEntity);
			deletableEntity.setActivities(null);
			this.entityManager.merge(activities);
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
	 * Support searching Tasks entities with pagination
	 */

	private int page;
	private long count;
	private List<Tasks> pageItems;

	private Tasks example = new Tasks();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public Tasks getExample() {
		return this.example;
	}

	public void setExample(Tasks example) {
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
		Root<Tasks> root = countCriteria.from(Tasks.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<Tasks> criteria = builder.createQuery(Tasks.class);
		root = criteria.from(Tasks.class);
		TypedQuery<Tasks> query = this.entityManager.createQuery(criteria
				.select(root).where(getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<Tasks> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		Integer priority = this.example.getPriority();
		if (priority != null && priority.intValue() != 0) {
			predicatesList.add(builder.equal(root.get("priority"), priority));
		}
		String name = this.example.getName();
		if (name != null && !"".equals(name)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("name")),
					'%' + name.toLowerCase() + '%'));
		}
		String detail = this.example.getDetail();
		if (detail != null && !"".equals(detail)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("detail")),
					'%' + detail.toLowerCase() + '%'));
		}
		Activities activities = this.example.getActivities();
		if (activities != null) {
			predicatesList
					.add(builder.equal(root.get("activities"), activities));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<Tasks> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back Tasks entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<Tasks> getAll() {

		CriteriaQuery<Tasks> criteria = this.entityManager.getCriteriaBuilder()
				.createQuery(Tasks.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(Tasks.class))).getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final TasksBean ejbProxy = this.sessionContext
				.getBusinessObject(TasksBean.class);

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

				return String.valueOf(((Tasks) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private Tasks add = new Tasks();

	public Tasks getAdd() {
		return this.add;
	}

	public Tasks getAdded() {
		Tasks added = this.add;
		this.add = new Tasks();
		return added;
	}
}
