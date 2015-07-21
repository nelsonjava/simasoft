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

import co.simasoft.models.naif.sgdea.UnidadesConservacion;
import co.simasoft.models.naif.sgdea.UnidadesDocumentales;
import java.util.Iterator;

/**
 * Backing bean for UnidadesConservacion entities.
 * <p/>
 * This class provides CRUD functionality for all UnidadesConservacion entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class UnidadesConservacionBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving UnidadesConservacion entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private UnidadesConservacion unidadesConservacion;

	public UnidadesConservacion getUnidadesConservacion() {
		return this.unidadesConservacion;
	}

	public void setUnidadesConservacion(
			UnidadesConservacion unidadesConservacion) {
		this.unidadesConservacion = unidadesConservacion;
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
			this.unidadesConservacion = this.example;
		} else {
			this.unidadesConservacion = findById(getId());
		}
	}

	public UnidadesConservacion findById(Long id) {

		return this.entityManager.find(UnidadesConservacion.class, id);
	}

	/*
	 * Support updating and deleting UnidadesConservacion entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.unidadesConservacion);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.unidadesConservacion);
				return "view?faces-redirect=true&id="
						+ this.unidadesConservacion.getId();
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
			UnidadesConservacion deletableEntity = findById(getId());
			Iterator<UnidadesDocumentales> iterUnidadesDocumentales = deletableEntity
					.getUnidadesDocumentales().iterator();
			for (; iterUnidadesDocumentales.hasNext();) {
				UnidadesDocumentales nextInUnidadesDocumentales = iterUnidadesDocumentales
						.next();
				nextInUnidadesDocumentales.setUnidadesConservacion(null);
				iterUnidadesDocumentales.remove();
				this.entityManager.merge(nextInUnidadesDocumentales);
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
	 * Support searching UnidadesConservacion entities with pagination
	 */

	private int page;
	private long count;
	private List<UnidadesConservacion> pageItems;

	private UnidadesConservacion example = new UnidadesConservacion();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public UnidadesConservacion getExample() {
		return this.example;
	}

	public void setExample(UnidadesConservacion example) {
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
		Root<UnidadesConservacion> root = countCriteria
				.from(UnidadesConservacion.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<UnidadesConservacion> criteria = builder
				.createQuery(UnidadesConservacion.class);
		root = criteria.from(UnidadesConservacion.class);
		TypedQuery<UnidadesConservacion> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<UnidadesConservacion> root) {

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

	public List<UnidadesConservacion> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back UnidadesConservacion entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<UnidadesConservacion> getAll() {

		CriteriaQuery<UnidadesConservacion> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(UnidadesConservacion.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(UnidadesConservacion.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final UnidadesConservacionBean ejbProxy = this.sessionContext
				.getBusinessObject(UnidadesConservacionBean.class);

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

				return String.valueOf(((UnidadesConservacion) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private UnidadesConservacion add = new UnidadesConservacion();

	public UnidadesConservacion getAdd() {
		return this.add;
	}

	public UnidadesConservacion getAdded() {
		UnidadesConservacion added = this.add;
		this.add = new UnidadesConservacion();
		return added;
	}
}
