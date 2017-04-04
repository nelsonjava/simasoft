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

import co.simasoft.models.Videos;
import co.simasoft.models.Films;
import co.simasoft.models.VideoContents;
import java.util.Iterator;

/**
 * Backing bean for Videos entities.
 * <p/>
 * This class provides CRUD functionality for all Videos entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class VideosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving Videos entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Videos videos;

	public Videos getVideos() {
		return this.videos;
	}

	public void setVideos(Videos videos) {
		this.videos = videos;
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
			this.videos = this.example;
		} else {
			this.videos = findById(getId());
		}
	}

	public Videos findById(Long id) {

		return this.entityManager.find(Videos.class, id);
	}

	/*
	 * Support updating and deleting Videos entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.videos);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.videos);
				return "view?faces-redirect=true&id=" + this.videos.getId();
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
			Videos deletableEntity = findById(getId());
			Iterator<VideoContents> iterVideoContents = deletableEntity
					.getVideoContents().iterator();
			for (; iterVideoContents.hasNext();) {
				VideoContents nextInVideoContents = iterVideoContents.next();
				nextInVideoContents.setVideos(null);
				iterVideoContents.remove();
				this.entityManager.merge(nextInVideoContents);
			}
			Films films = deletableEntity.getFilms();
			films.getVideos().remove(deletableEntity);
			deletableEntity.setFilms(null);
			this.entityManager.merge(films);
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
	 * Support searching Videos entities with pagination
	 */

	private int page;
	private long count;
	private List<Videos> pageItems;

	private Videos example = new Videos();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public Videos getExample() {
		return this.example;
	}

	public void setExample(Videos example) {
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
		Root<Videos> root = countCriteria.from(Videos.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<Videos> criteria = builder.createQuery(Videos.class);
		root = criteria.from(Videos.class);
		TypedQuery<Videos> query = this.entityManager.createQuery(criteria
				.select(root).where(getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<Videos> root) {

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
		String time = this.example.getTime();
		if (time != null && !"".equals(time)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("time")),
					'%' + time.toLowerCase() + '%'));
		}
		Films films = this.example.getFilms();
		if (films != null) {
			predicatesList.add(builder.equal(root.get("films"), films));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<Videos> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back Videos entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<Videos> getAll() {

		CriteriaQuery<Videos> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(Videos.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(Videos.class))).getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final VideosBean ejbProxy = this.sessionContext
				.getBusinessObject(VideosBean.class);

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

				return String.valueOf(((Videos) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private Videos add = new Videos();

	public Videos getAdd() {
		return this.add;
	}

	public Videos getAdded() {
		Videos added = this.add;
		this.add = new Videos();
		return added;
	}
}
