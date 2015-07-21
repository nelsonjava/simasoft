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

import co.simasoft.models.naif.sgdea.UnidadesDocumentales;
import co.simasoft.models.naif.sgdea.FrecuenciasConsulta;
import co.simasoft.models.naif.sgdea.InventarioDocumental;
import co.simasoft.models.naif.sgdea.Series;
import co.simasoft.models.naif.sgdea.SoporteDocumental;
import co.simasoft.models.naif.sgdea.UnidadesConservacion;
import java.util.Iterator;

/**
 * Backing bean for UnidadesDocumentales entities.
 * <p/>
 * This class provides CRUD functionality for all UnidadesDocumentales entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class UnidadesDocumentalesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving UnidadesDocumentales entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private UnidadesDocumentales unidadesDocumentales;

	public UnidadesDocumentales getUnidadesDocumentales() {
		return this.unidadesDocumentales;
	}

	public void setUnidadesDocumentales(
			UnidadesDocumentales unidadesDocumentales) {
		this.unidadesDocumentales = unidadesDocumentales;
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
			this.unidadesDocumentales = this.example;
		} else {
			this.unidadesDocumentales = findById(getId());
		}
	}

	public UnidadesDocumentales findById(Long id) {

		return this.entityManager.find(UnidadesDocumentales.class, id);
	}

	/*
	 * Support updating and deleting UnidadesDocumentales entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.unidadesDocumentales);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.unidadesDocumentales);
				return "view?faces-redirect=true&id="
						+ this.unidadesDocumentales.getId();
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
			UnidadesDocumentales deletableEntity = findById(getId());
			Iterator<InventarioDocumental> iterInventarioDocumental = deletableEntity
					.getInventarioDocumental().iterator();
			for (; iterInventarioDocumental.hasNext();) {
				InventarioDocumental nextInInventarioDocumental = iterInventarioDocumental
						.next();
				nextInInventarioDocumental.setUnidadesDocumentales(null);
				iterInventarioDocumental.remove();
				this.entityManager.merge(nextInInventarioDocumental);
			}
			Iterator<SoporteDocumental> iterSoporteDocumental = deletableEntity
					.getSoporteDocumental().iterator();
			for (; iterSoporteDocumental.hasNext();) {
				SoporteDocumental nextInSoporteDocumental = iterSoporteDocumental
						.next();
				nextInSoporteDocumental.getUnidadesDocumentales().remove(
						deletableEntity);
				iterSoporteDocumental.remove();
				this.entityManager.merge(nextInSoporteDocumental);
			}
			Iterator<Series> iterSeries = deletableEntity.getSeries()
					.iterator();
			for (; iterSeries.hasNext();) {
				Series nextInSeries = iterSeries.next();
				nextInSeries.setUnidadesDocumentales(null);
				iterSeries.remove();
				this.entityManager.merge(nextInSeries);
			}
			UnidadesConservacion unidadesConservacion = deletableEntity
					.getUnidadesConservacion();
			unidadesConservacion.getUnidadesDocumentales().remove(
					deletableEntity);
			deletableEntity.setUnidadesConservacion(null);
			this.entityManager.merge(unidadesConservacion);
			FrecuenciasConsulta frecuenciasConsulta = deletableEntity
					.getFrecuenciasConsulta();
			frecuenciasConsulta.getUnidadesDocumentales().remove(
					deletableEntity);
			deletableEntity.setFrecuenciasConsulta(null);
			this.entityManager.merge(frecuenciasConsulta);
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
	 * Support searching UnidadesDocumentales entities with pagination
	 */

	private int page;
	private long count;
	private List<UnidadesDocumentales> pageItems;

	private UnidadesDocumentales example = new UnidadesDocumentales();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public UnidadesDocumentales getExample() {
		return this.example;
	}

	public void setExample(UnidadesDocumentales example) {
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
		Root<UnidadesDocumentales> root = countCriteria
				.from(UnidadesDocumentales.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<UnidadesDocumentales> criteria = builder
				.createQuery(UnidadesDocumentales.class);
		root = criteria.from(UnidadesDocumentales.class);
		TypedQuery<UnidadesDocumentales> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<UnidadesDocumentales> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		String nombre = this.example.getNombre();
		if (nombre != null && !"".equals(nombre)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("nombre")),
					'%' + nombre.toLowerCase() + '%'));
		}
		UnidadesConservacion unidadesConservacion = this.example
				.getUnidadesConservacion();
		if (unidadesConservacion != null) {
			predicatesList.add(builder.equal(root.get("unidadesConservacion"),
					unidadesConservacion));
		}
		FrecuenciasConsulta frecuenciasConsulta = this.example
				.getFrecuenciasConsulta();
		if (frecuenciasConsulta != null) {
			predicatesList.add(builder.equal(root.get("frecuenciasConsulta"),
					frecuenciasConsulta));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<UnidadesDocumentales> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back UnidadesDocumentales entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<UnidadesDocumentales> getAll() {

		CriteriaQuery<UnidadesDocumentales> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(UnidadesDocumentales.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(UnidadesDocumentales.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final UnidadesDocumentalesBean ejbProxy = this.sessionContext
				.getBusinessObject(UnidadesDocumentalesBean.class);

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

				return String.valueOf(((UnidadesDocumentales) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private UnidadesDocumentales add = new UnidadesDocumentales();

	public UnidadesDocumentales getAdd() {
		return this.add;
	}

	public UnidadesDocumentales getAdded() {
		UnidadesDocumentales added = this.add;
		this.add = new UnidadesDocumentales();
		return added;
	}
}
