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

import co.simasoft.models.Books;
import co.simasoft.models.Activities;
import co.simasoft.models.BooksTypes;
import co.simasoft.models.Chapters;
import java.util.Iterator;

/**
 * Backing bean for Books entities.
 * <p/>
 * This class provides CRUD functionality for all Books entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class BooksBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving Books entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Books books;

	public Books getBooks() {
		return this.books;
	}

	public void setBooks(Books books) {
		this.books = books;
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
			this.books = this.example;
		} else {
			this.books = findById(getId());
		}
	}

	public Books findById(Long id) {

		return this.entityManager.find(Books.class, id);
	}

	/*
	 * Support updating and deleting Books entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.books);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.books);
				return "view?faces-redirect=true&id=" + this.books.getId();
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
			Books deletableEntity = findById(getId());
			Iterator<Activities> iterActivities = deletableEntity
					.getActivities().iterator();
			for (; iterActivities.hasNext();) {
				Activities nextInActivities = iterActivities.next();
				nextInActivities.setBooks(null);
				iterActivities.remove();
				this.entityManager.merge(nextInActivities);
			}
			Iterator<Chapters> iterChapters = deletableEntity.getChapters()
					.iterator();
			for (; iterChapters.hasNext();) {
				Chapters nextInChapters = iterChapters.next();
				nextInChapters.setBooks(null);
				iterChapters.remove();
				this.entityManager.merge(nextInChapters);
			}
			BooksTypes booksTypes = deletableEntity.getBooksTypes();
			booksTypes.getBooks().remove(deletableEntity);
			deletableEntity.setBooksTypes(null);
			this.entityManager.merge(booksTypes);
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
	 * Support searching Books entities with pagination
	 */

	private int page;
	private long count;
	private List<Books> pageItems;

	private Books example = new Books();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public Books getExample() {
		return this.example;
	}

	public void setExample(Books example) {
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
		Root<Books> root = countCriteria.from(Books.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<Books> criteria = builder.createQuery(Books.class);
		root = criteria.from(Books.class);
		TypedQuery<Books> query = this.entityManager.createQuery(criteria
				.select(root).where(getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<Books> root) {

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
		BooksTypes booksTypes = this.example.getBooksTypes();
		if (booksTypes != null) {
			predicatesList
					.add(builder.equal(root.get("booksTypes"), booksTypes));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<Books> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back Books entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<Books> getAll() {

		CriteriaQuery<Books> criteria = this.entityManager.getCriteriaBuilder()
				.createQuery(Books.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(Books.class))).getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final BooksBean ejbProxy = this.sessionContext
				.getBusinessObject(BooksBean.class);

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

				return String.valueOf(((Books) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private Books add = new Books();

	public Books getAdd() {
		return this.add;
	}

	public Books getAdded() {
		Books added = this.add;
		this.add = new Books();
		return added;
	}
}
