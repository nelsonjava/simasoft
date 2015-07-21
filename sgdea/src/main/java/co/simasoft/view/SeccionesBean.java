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

import co.simasoft.models.naif.sgdea.Secciones;
import co.simasoft.models.naif.sgdea.FondosDocumentales;
import co.simasoft.models.naif.sgdea.Personas;
import co.simasoft.models.naif.sgdea.Series;
import java.util.Iterator;

/**
 * Backing bean for Secciones entities.
 * <p/>
 * This class provides CRUD functionality for all Secciones entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class SeccionesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving Secciones entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Secciones secciones;

	public Secciones getSecciones() {
		return this.secciones;
	}

	public void setSecciones(Secciones secciones) {
		this.secciones = secciones;
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
			this.secciones = this.example;
		} else {
			this.secciones = findById(getId());
		}
	}

	public Secciones findById(Long id) {

		return this.entityManager.find(Secciones.class, id);
	}

	/*
	 * Support updating and deleting Secciones entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.secciones);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.secciones);
				return "view?faces-redirect=true&id=" + this.secciones.getId();
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
			Secciones deletableEntity = findById(getId());
			Iterator<Secciones> iterObjHijos = deletableEntity.getObjHijos()
					.iterator();
			for (; iterObjHijos.hasNext();) {
				Secciones nextInObjHijos = iterObjHijos.next();
				nextInObjHijos.setObjPadre(null);
				iterObjHijos.remove();
				this.entityManager.merge(nextInObjHijos);
			}
			Iterator<Series> iterSeries = deletableEntity.getSeries()
					.iterator();
			for (; iterSeries.hasNext();) {
				Series nextInSeries = iterSeries.next();
				nextInSeries.getSecciones().remove(deletableEntity);
				iterSeries.remove();
				this.entityManager.merge(nextInSeries);
			}
			Secciones objPadre = deletableEntity.getObjPadre();
			objPadre.getObjHijos().remove(deletableEntity);
			deletableEntity.setObjPadre(null);
			this.entityManager.merge(objPadre);
			Personas personas = deletableEntity.getPersonas();
			personas.getSecciones().remove(deletableEntity);
			deletableEntity.setPersonas(null);
			this.entityManager.merge(personas);
			FondosDocumentales fondosDocumentales = deletableEntity
					.getFondosDocumentales();
			fondosDocumentales.getSecciones().remove(deletableEntity);
			deletableEntity.setFondosDocumentales(null);
			this.entityManager.merge(fondosDocumentales);
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
	 * Support searching Secciones entities with pagination
	 */

	private int page;
	private long count;
	private List<Secciones> pageItems;

	private Secciones example = new Secciones();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public Secciones getExample() {
		return this.example;
	}

	public void setExample(Secciones example) {
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
		Root<Secciones> root = countCriteria.from(Secciones.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<Secciones> criteria = builder
				.createQuery(Secciones.class);
		root = criteria.from(Secciones.class);
		TypedQuery<Secciones> query = this.entityManager.createQuery(criteria
				.select(root).where(getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<Secciones> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		String observaciones = this.example.getObservaciones();
		if (observaciones != null && !"".equals(observaciones)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("observaciones")),
					'%' + observaciones.toLowerCase() + '%'));
		}
		Integer nroTransferencias = this.example.getNroTransferencias();
		if (nroTransferencias != null && nroTransferencias.intValue() != 0) {
			predicatesList.add(builder.equal(root.get("nroTransferencias"),
					nroTransferencias));
		}
		String codigo = this.example.getCodigo();
		if (codigo != null && !"".equals(codigo)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("codigo")),
					'%' + codigo.toLowerCase() + '%'));
		}
		String nombre = this.example.getNombre();
		if (nombre != null && !"".equals(nombre)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("nombre")),
					'%' + nombre.toLowerCase() + '%'));
		}
		Secciones objPadre = this.example.getObjPadre();
		if (objPadre != null) {
			predicatesList.add(builder.equal(root.get("objPadre"), objPadre));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<Secciones> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back Secciones entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<Secciones> getAll() {

		CriteriaQuery<Secciones> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(Secciones.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(Secciones.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final SeccionesBean ejbProxy = this.sessionContext
				.getBusinessObject(SeccionesBean.class);

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

				return String.valueOf(((Secciones) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private Secciones add = new Secciones();

	public Secciones getAdd() {
		return this.add;
	}

	public Secciones getAdded() {
		Secciones added = this.add;
		this.add = new Secciones();
		return added;
	}
}
