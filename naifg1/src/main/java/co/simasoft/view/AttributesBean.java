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

import co.simasoft.models.dev.naifg.Attributes;
import co.simasoft.models.dev.naifg.Entities;
import java.lang.Boolean;

/**
 * Backing bean for Attributes entities.
 * <p/>
 * This class provides CRUD functionality for all Attributes entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class AttributesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving Attributes entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Attributes attributes;

	public Attributes getAttributes() {
		return this.attributes;
	}

	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
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
			this.attributes = this.example;
		} else {
			this.attributes = findById(getId());
		}
	}

	public Attributes findById(Long id) {

		return this.entityManager.find(Attributes.class, id);
	}

	/*
	 * Support updating and deleting Attributes entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.attributes);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.attributes);
				return "view?faces-redirect=true&id=" + this.attributes.getId();
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
			Attributes deletableEntity = findById(getId());
			Entities entities = deletableEntity.getEntities();
			entities.getAttributes().remove(deletableEntity);
			deletableEntity.setEntities(null);
			this.entityManager.merge(entities);
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
	 * Support searching Attributes entities with pagination
	 */

	private int page;
	private long count;
	private List<Attributes> pageItems;

	private Attributes example = new Attributes();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 1000;
	}

	public Attributes getExample() {
		return this.example;
	}

	public void setExample(Attributes example) {
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
		Root<Attributes> root = countCriteria.from(Attributes.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<Attributes> criteria = builder
				.createQuery(Attributes.class);
		root = criteria.from(Attributes.class);
		TypedQuery<Attributes> query = this.entityManager.createQuery(criteria
				.select(root).where(getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<Attributes> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		String observations = this.example.getObservations();
		if (observations != null && !"".equals(observations)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("observations")),
					'%' + observations.toLowerCase() + '%'));
		}
		Boolean isSimplified = this.example.getIsSimplified();
		if (isSimplified != null) {
			predicatesList.add(builder.equal(root.get("isSimplified"),
					isSimplified));
		}
		Boolean isCreate = this.example.getIsCreate();
		if (isCreate != null) {
			predicatesList.add(builder.equal(root.get("isCreate"), isCreate));
		}
		Boolean isSearch = this.example.getIsSearch();
		if (isSearch != null) {
			predicatesList.add(builder.equal(root.get("isSearch"), isSearch));
		}
		Boolean isView = this.example.getIsView();
		if (isView != null) {
			predicatesList.add(builder.equal(root.get("isView"), isView));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<Attributes> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back Attributes entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<Attributes> getAll() {

		CriteriaQuery<Attributes> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(Attributes.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(Attributes.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final AttributesBean ejbProxy = this.sessionContext
				.getBusinessObject(AttributesBean.class);

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

				return String.valueOf(((Attributes) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private Attributes add = new Attributes();

	public Attributes getAdd() {
		return this.add;
	}

	public Attributes getAdded() {
		Attributes added = this.add;
		this.add = new Attributes();
		return added;
	}
}
