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

import co.simasoft.models.naif.sgdea.FinalidadInventario;
import co.simasoft.models.naif.sgdea.InventarioDocumental;
import java.util.Iterator;

/**
 * Backing bean for FinalidadInventario entities.
 * <p/>
 * This class provides CRUD functionality for all FinalidadInventario entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class FinalidadInventarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving FinalidadInventario entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private FinalidadInventario finalidadInventario;

	public FinalidadInventario getFinalidadInventario() {
		return this.finalidadInventario;
	}

	public void setFinalidadInventario(FinalidadInventario finalidadInventario) {
		this.finalidadInventario = finalidadInventario;
	}

	@Inject
	private Conversation conversation;

	@PersistenceContext(unitName = "sgdeaPU-JTA", type = PersistenceContextType.EXTENDED)
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
			this.finalidadInventario = this.example;
		} else {
			this.finalidadInventario = findById(getId());
		}
	}

	public FinalidadInventario findById(Long id) {

		return this.entityManager.find(FinalidadInventario.class, id);
	}

	/*
	 * Support updating and deleting FinalidadInventario entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.finalidadInventario);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.finalidadInventario);
				return "view?faces-redirect=true&id="
						+ this.finalidadInventario.getId();
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
			FinalidadInventario deletableEntity = findById(getId());
			Iterator<InventarioDocumental> iterInventarioDocumental = deletableEntity
					.getInventarioDocumental().iterator();
			for (; iterInventarioDocumental.hasNext();) {
				InventarioDocumental nextInInventarioDocumental = iterInventarioDocumental
						.next();
				nextInInventarioDocumental.setFinalidadInventario(null);
				iterInventarioDocumental.remove();
				this.entityManager.merge(nextInInventarioDocumental);
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
	 * Support searching FinalidadInventario entities with pagination
	 */

	private int page;
	private long count;
	private List<FinalidadInventario> pageItems;

	private FinalidadInventario example = new FinalidadInventario();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public FinalidadInventario getExample() {
		return this.example;
	}

	public void setExample(FinalidadInventario example) {
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
		Root<FinalidadInventario> root = countCriteria
				.from(FinalidadInventario.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<FinalidadInventario> criteria = builder
				.createQuery(FinalidadInventario.class);
		root = criteria.from(FinalidadInventario.class);
		TypedQuery<FinalidadInventario> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<FinalidadInventario> root) {

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

	public List<FinalidadInventario> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back FinalidadInventario entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<FinalidadInventario> getAll() {

		CriteriaQuery<FinalidadInventario> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(FinalidadInventario.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(FinalidadInventario.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final FinalidadInventarioBean ejbProxy = this.sessionContext
				.getBusinessObject(FinalidadInventarioBean.class);

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

				return String.valueOf(((FinalidadInventario) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private FinalidadInventario add = new FinalidadInventario();

	public FinalidadInventario getAdd() {
		return this.add;
	}

	public FinalidadInventario getAdded() {
		FinalidadInventario added = this.add;
		this.add = new FinalidadInventario();
		return added;
	}
}
