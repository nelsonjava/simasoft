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

import co.simasoft.models.SectionsTypes;
import co.simasoft.models.Sections;
import java.util.Iterator;

/**
 * Backing bean for SectionsTypes entities.
 * <p/>
 * This class provides CRUD functionality for all SectionsTypes entities. It
 * focuses purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt>
 * for state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class SectionsTypesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving SectionsTypes entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private SectionsTypes sectionsTypes;

	public SectionsTypes getSectionsTypes() {
		return this.sectionsTypes;
	}

	public void setSectionsTypes(SectionsTypes sectionsTypes) {
		this.sectionsTypes = sectionsTypes;
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
			this.sectionsTypes = this.example;
		} else {
			this.sectionsTypes = findById(getId());
		}
	}

	public SectionsTypes findById(Long id) {

		return this.entityManager.find(SectionsTypes.class, id);
	}

	/*
	 * Support updating and deleting SectionsTypes entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.sectionsTypes);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.sectionsTypes);
				return "view?faces-redirect=true&id="
						+ this.sectionsTypes.getId();
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
			SectionsTypes deletableEntity = findById(getId());
			Iterator<Sections> iterSections = deletableEntity.getSections()
					.iterator();
			for (; iterSections.hasNext();) {
				Sections nextInSections = iterSections.next();
				nextInSections.setSectionsTypes(null);
				iterSections.remove();
				this.entityManager.merge(nextInSections);
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
	 * Support searching SectionsTypes entities with pagination
	 */

	private int page;
	private long count;
	private List<SectionsTypes> pageItems;

	private SectionsTypes example = new SectionsTypes();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 1000;
	}

	public SectionsTypes getExample() {
		return this.example;
	}

	public void setExample(SectionsTypes example) {
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
		Root<SectionsTypes> root = countCriteria.from(SectionsTypes.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<SectionsTypes> criteria = builder
				.createQuery(SectionsTypes.class);
		root = criteria.from(SectionsTypes.class);
		TypedQuery<SectionsTypes> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<SectionsTypes> root) {

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

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<SectionsTypes> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back SectionsTypes entities (e.g. from inside
	 * an HtmlSelectOneMenu)
	 */

	public List<SectionsTypes> getAll() {

		CriteriaQuery<SectionsTypes> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(SectionsTypes.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(SectionsTypes.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final SectionsTypesBean ejbProxy = this.sessionContext
				.getBusinessObject(SectionsTypesBean.class);

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

				return String.valueOf(((SectionsTypes) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private SectionsTypes add = new SectionsTypes();

	public SectionsTypes getAdd() {
		return this.add;
	}

	public SectionsTypes getAdded() {
		SectionsTypes added = this.add;
		this.add = new SectionsTypes();
		return added;
	}
}
