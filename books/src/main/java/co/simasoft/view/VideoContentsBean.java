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

import co.simasoft.models.VideoContents;
import co.simasoft.models.Chapters;
import co.simasoft.models.Videos;
import java.util.Iterator;

/**
 * Backing bean for VideoContents entities.
 * <p/>
 * This class provides CRUD functionality for all VideoContents entities. It
 * focuses purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt>
 * for state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class VideoContentsBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving VideoContents entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private VideoContents videoContents;

	public VideoContents getVideoContents() {
		return this.videoContents;
	}

	public void setVideoContents(VideoContents videoContents) {
		this.videoContents = videoContents;
	}

	@Inject
	private Conversation conversation;

	@PersistenceContext(unitName = "booksPU-JTA", type = PersistenceContextType.EXTENDED)
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
			this.videoContents = this.example;
		} else {
			this.videoContents = findById(getId());
		}
	}

	public VideoContents findById(Long id) {

		return this.entityManager.find(VideoContents.class, id);
	}

	/*
	 * Support updating and deleting VideoContents entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.videoContents);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.videoContents);
				return "view?faces-redirect=true&id="
						+ this.videoContents.getId();
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
			VideoContents deletableEntity = findById(getId());
			Videos videos = deletableEntity.getVideos();
			videos.getVideoContents().remove(deletableEntity);
			deletableEntity.setVideos(null);
			this.entityManager.merge(videos);
			Iterator<Chapters> iterChapters = deletableEntity.getChapters()
					.iterator();
			for (; iterChapters.hasNext();) {
				Chapters nextInChapters = iterChapters.next();
				nextInChapters.getVideoContents().remove(deletableEntity);
				iterChapters.remove();
				this.entityManager.merge(nextInChapters);
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
	 * Support searching VideoContents entities with pagination
	 */

	private int page;
	private long count;
	private List<VideoContents> pageItems;

	private VideoContents example = new VideoContents();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public VideoContents getExample() {
		return this.example;
	}

	public void setExample(VideoContents example) {
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
		Root<VideoContents> root = countCriteria.from(VideoContents.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<VideoContents> criteria = builder
				.createQuery(VideoContents.class);
		root = criteria.from(VideoContents.class);
		TypedQuery<VideoContents> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<VideoContents> root) {

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
		String startTime = this.example.getStartTime();
		if (startTime != null && !"".equals(startTime)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("startTime")),
					'%' + startTime.toLowerCase() + '%'));
		}
		String endTime = this.example.getEndTime();
		if (endTime != null && !"".equals(endTime)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("endTime")),
					'%' + endTime.toLowerCase() + '%'));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<VideoContents> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back VideoContents entities (e.g. from inside
	 * an HtmlSelectOneMenu)
	 */

	public List<VideoContents> getAll() {

		CriteriaQuery<VideoContents> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(VideoContents.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(VideoContents.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final VideoContentsBean ejbProxy = this.sessionContext
				.getBusinessObject(VideoContentsBean.class);

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

				return String.valueOf(((VideoContents) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private VideoContents add = new VideoContents();

	public VideoContents getAdd() {
		return this.add;
	}

	public VideoContents getAdded() {
		VideoContents added = this.add;
		this.add = new VideoContents();
		return added;
	}
}