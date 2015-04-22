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

import co.simasoft.naif.models.DomainModels.TiposLinksModels;

/**
 * Backing bean for TiposLinksModels entities.
 * <p/>
 * This class provides CRUD functionality for all TiposLinksModels entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class TiposLinksModelsBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving TiposLinksModels entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private TiposLinksModels tiposLinksModels;

	public TiposLinksModels getTiposLinksModels() {
		return this.tiposLinksModels;
	}

	public void setTiposLinksModels(TiposLinksModels tiposLinksModels) {
		this.tiposLinksModels = tiposLinksModels;
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
			this.tiposLinksModels = this.example;
		} else {
			this.tiposLinksModels = findById(getId());
		}
	}

	public TiposLinksModels findById(Long id) {

		return this.entityManager.find(TiposLinksModels.class, id);
	}

	/*
	 * Support updating and deleting TiposLinksModels entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.tiposLinksModels);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.tiposLinksModels);
				return "view?faces-redirect=true&id="
						+ this.tiposLinksModels.getId();
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
			TiposLinksModels deletableEntity = findById(getId());

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
	 * Support searching TiposLinksModels entities with pagination
	 */

	private int page;
	private long count;
	private List<TiposLinksModels> pageItems;

	private TiposLinksModels example = new TiposLinksModels();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public TiposLinksModels getExample() {
		return this.example;
	}

	public void setExample(TiposLinksModels example) {
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
		Root<TiposLinksModels> root = countCriteria
				.from(TiposLinksModels.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<TiposLinksModels> criteria = builder
				.createQuery(TiposLinksModels.class);
		root = criteria.from(TiposLinksModels.class);
		TypedQuery<TiposLinksModels> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<TiposLinksModels> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		String nombre = this.example.getNombre();
		if (nombre != null && !"".equals(nombre)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("nombre")),
					'%' + nombre.toLowerCase() + '%'));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<TiposLinksModels> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back TiposLinksModels entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<TiposLinksModels> getAll() {

		CriteriaQuery<TiposLinksModels> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(TiposLinksModels.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(TiposLinksModels.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final TiposLinksModelsBean ejbProxy = this.sessionContext
				.getBusinessObject(TiposLinksModelsBean.class);

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

				return String.valueOf(((TiposLinksModels) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private TiposLinksModels add = new TiposLinksModels();

	public TiposLinksModels getAdd() {
		return this.add;
	}

	public TiposLinksModels getAdded() {
		TiposLinksModels added = this.add;
		this.add = new TiposLinksModels();
		return added;
	}
}
