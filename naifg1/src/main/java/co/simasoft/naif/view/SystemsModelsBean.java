package co.simasoft.naif.view;

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

import co.simasoft.naif.models.DomainModels.SystemsModels;

/**
 * Backing bean for SystemsModels entities.
 * <p/>
 * This class provides CRUD functionality for all SystemsModels entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class SystemsModelsBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving SystemsModels entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private SystemsModels systemsModels;

	public SystemsModels getSystemsModels() {
		return this.systemsModels;
	}

	public void setSystemsModels(SystemsModels systemsModels) {
		this.systemsModels = systemsModels;
	}

	@Inject
	private Conversation conversation;

	@PersistenceContext(unitName = "DomainModelsPU-JTA", type = PersistenceContextType.EXTENDED)
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
			this.systemsModels = this.example;
		} else {
			this.systemsModels = findById(getId());
		}
	}

	public SystemsModels findById(Long id) {

		return this.entityManager.find(SystemsModels.class, id);
	}

	/*
	 * Support updating and deleting SystemsModels entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.systemsModels);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.systemsModels);
				return "view?faces-redirect=true&id="
						+ this.systemsModels.getId();
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
			SystemsModels deletableEntity = findById(getId());

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
	 * Support searching SystemsModels entities with pagination
	 */

	private int page;
	private long count;
	private List<SystemsModels> pageItems;

	private SystemsModels example = new SystemsModels();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public SystemsModels getExample() {
		return this.example;
	}

	public void setExample(SystemsModels example) {
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
		Root<SystemsModels> root = countCriteria.from(SystemsModels.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<SystemsModels> criteria = builder
				.createQuery(SystemsModels.class);
		root = criteria.from(SystemsModels.class);
		TypedQuery<SystemsModels> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<SystemsModels> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		String name = this.example.getName();
		if (name != null && !"".equals(name)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("name")),
					'%' + name.toLowerCase() + '%'));
		}
		String description = this.example.getDescription();
		if (description != null && !"".equals(description)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("description")),
					'%' + description.toLowerCase() + '%'));
		}
		String observaciones = this.example.getObservaciones();
		if (observaciones != null && !"".equals(observaciones)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("observaciones")),
					'%' + observaciones.toLowerCase() + '%'));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<SystemsModels> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back SystemsModels entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<SystemsModels> getAll() {

		CriteriaQuery<SystemsModels> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(SystemsModels.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(SystemsModels.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final SystemsModelsBean ejbProxy = this.sessionContext
				.getBusinessObject(SystemsModelsBean.class);

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

				return String.valueOf(((SystemsModels) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private SystemsModels add = new SystemsModels();

	public SystemsModels getAdd() {
		return this.add;
	}

	public SystemsModels getAdded() {
		SystemsModels added = this.add;
		this.add = new SystemsModels();
		return added;
	}
}
