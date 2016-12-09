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

import co.simasoft.models.Chapters;
import co.simasoft.models.Books;
import co.simasoft.models.Diaries;
import co.simasoft.models.Tasks;
import java.util.Iterator;

/**
 * Backing bean for Chapters entities.
 * <p/>
 * This class provides CRUD functionality for all Chapters entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class ChaptersBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving Chapters entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Chapters chapters;

	public Chapters getChapters() {
		return this.chapters;
	}

	public void setChapters(Chapters chapters) {
		this.chapters = chapters;
	}

	@Inject
	private Conversation conversation;

	@PersistenceContext(unitName = "crmNaifgPU-JTA", type = PersistenceContextType.EXTENDED)
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
			this.chapters = this.example;
		} else {
			this.chapters = findById(getId());
		}
	}

	public Chapters findById(Long id) {

		return this.entityManager.find(Chapters.class, id);
	}

	/*
	 * Support updating and deleting Chapters entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.chapters);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.chapters);
				return "view?faces-redirect=true&id=" + this.chapters.getId();
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
			Chapters deletableEntity = findById(getId());
			Iterator<Diaries> iterDiaries = deletableEntity.getDiaries()
					.iterator();
			for (; iterDiaries.hasNext();) {
				Diaries nextInDiaries = iterDiaries.next();
				nextInDiaries.setChapters(null);
				iterDiaries.remove();
				this.entityManager.merge(nextInDiaries);
			}
			Iterator<Tasks> iterTasks = deletableEntity.getTasks().iterator();
			for (; iterTasks.hasNext();) {
				Tasks nextInTasks = iterTasks.next();
				nextInTasks.setChapters(null);
				iterTasks.remove();
				this.entityManager.merge(nextInTasks);
			}
			Iterator<Chapters> iterObjHijos = deletableEntity.getObjHijos()
					.iterator();
			for (; iterObjHijos.hasNext();) {
				Chapters nextInObjHijos = iterObjHijos.next();
				nextInObjHijos.setObjPadre(null);
				iterObjHijos.remove();
				this.entityManager.merge(nextInObjHijos);
			}
			Books books = deletableEntity.getBooks();
			books.getChapters().remove(deletableEntity);
			deletableEntity.setBooks(null);
			this.entityManager.merge(books);
			Chapters objPadre = deletableEntity.getObjPadre();
			objPadre.getObjHijos().remove(deletableEntity);
			deletableEntity.setObjPadre(null);
			this.entityManager.merge(objPadre);
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
	 * Support searching Chapters entities with pagination
	 */

	private int page;
	private long count;
	private List<Chapters> pageItems;

	private Chapters example = new Chapters();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public Chapters getExample() {
		return this.example;
	}

	public void setExample(Chapters example) {
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
		Root<Chapters> root = countCriteria.from(Chapters.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<Chapters> criteria = builder.createQuery(Chapters.class);
		root = criteria.from(Chapters.class);
		TypedQuery<Chapters> query = this.entityManager.createQuery(criteria
				.select(root).where(getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<Chapters> root) {

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
		Books books = this.example.getBooks();
		if (books != null) {
			predicatesList.add(builder.equal(root.get("books"), books));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<Chapters> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back Chapters entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<Chapters> getAll() {

		CriteriaQuery<Chapters> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(Chapters.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(Chapters.class))).getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final ChaptersBean ejbProxy = this.sessionContext
				.getBusinessObject(ChaptersBean.class);

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

				return String.valueOf(((Chapters) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private Chapters add = new Chapters();

	public Chapters getAdd() {
		return this.add;
	}

	public Chapters getAdded() {
		Chapters added = this.add;
		this.add = new Chapters();
		return added;
	}
}
