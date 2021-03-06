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

import co.simasoft.models.naif.sgdea.Series;
import co.simasoft.models.naif.sgdea.Secciones;
import co.simasoft.models.naif.sgdea.TiposDocumentales;
import co.simasoft.models.naif.sgdea.Trd;
import co.simasoft.models.naif.sgdea.UnidadesDocumentales;
import java.util.Iterator;

/**
 * Backing bean for Series entities.
 * <p/>
 * This class provides CRUD functionality for all Series entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class SeriesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving Series entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Series series;

	public Series getSeries() {
		return this.series;
	}

	public void setSeries(Series series) {
		this.series = series;
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
			this.series = this.example;
		} else {
			this.series = findById(getId());
		}
	}

	public Series findById(Long id) {

		return this.entityManager.find(Series.class, id);
	}

	/*
	 * Support updating and deleting Series entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.series);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.series);
				return "view?faces-redirect=true&id=" + this.series.getId();
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
			Series deletableEntity = findById(getId());
			Iterator<Series> iterObjHijos = deletableEntity.getObjHijos()
					.iterator();
			for (; iterObjHijos.hasNext();) {
				Series nextInObjHijos = iterObjHijos.next();
				nextInObjHijos.setObjPadre(null);
				iterObjHijos.remove();
				this.entityManager.merge(nextInObjHijos);
			}
			Series objPadre = deletableEntity.getObjPadre();
			objPadre.getObjHijos().remove(deletableEntity);
			deletableEntity.setObjPadre(null);
			this.entityManager.merge(objPadre);
			Iterator<Secciones> iterSecciones = deletableEntity.getSecciones()
					.iterator();
			for (; iterSecciones.hasNext();) {
				Secciones nextInSecciones = iterSecciones.next();
				nextInSecciones.getSeries().remove(deletableEntity);
				iterSecciones.remove();
				this.entityManager.merge(nextInSecciones);
			}
			UnidadesDocumentales unidadesDocumentales = deletableEntity
					.getUnidadesDocumentales();
			unidadesDocumentales.getSeries().remove(deletableEntity);
			deletableEntity.setUnidadesDocumentales(null);
			this.entityManager.merge(unidadesDocumentales);
			Iterator<TiposDocumentales> iterTiposDocumentales = deletableEntity
					.getTiposDocumentales().iterator();
			for (; iterTiposDocumentales.hasNext();) {
				TiposDocumentales nextInTiposDocumentales = iterTiposDocumentales
						.next();
				nextInTiposDocumentales.getSeries().remove(deletableEntity);
				iterTiposDocumentales.remove();
				this.entityManager.merge(nextInTiposDocumentales);
			}
			Trd trd = deletableEntity.getTrd();
			trd.getSeries().remove(deletableEntity);
			deletableEntity.setTrd(null);
			this.entityManager.merge(trd);
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
	 * Support searching Series entities with pagination
	 */

	private int page;
	private long count;
	private List<Series> pageItems;

	private Series example = new Series();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public Series getExample() {
		return this.example;
	}

	public void setExample(Series example) {
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
		Root<Series> root = countCriteria.from(Series.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<Series> criteria = builder.createQuery(Series.class);
		root = criteria.from(Series.class);
		TypedQuery<Series> query = this.entityManager.createQuery(criteria
				.select(root).where(getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<Series> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		String nombre = this.example.getNombre();
		if (nombre != null && !"".equals(nombre)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("nombre")),
					'%' + nombre.toLowerCase() + '%'));
		}
		String codigo = this.example.getCodigo();
		if (codigo != null && !"".equals(codigo)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("codigo")),
					'%' + codigo.toLowerCase() + '%'));
		}
		String observaciones = this.example.getObservaciones();
		if (observaciones != null && !"".equals(observaciones)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("observaciones")),
					'%' + observaciones.toLowerCase() + '%'));
		}
		Series objPadre = this.example.getObjPadre();
		if (objPadre != null) {
			predicatesList.add(builder.equal(root.get("objPadre"), objPadre));
		}
		UnidadesDocumentales unidadesDocumentales = this.example
				.getUnidadesDocumentales();
		if (unidadesDocumentales != null) {
			predicatesList.add(builder.equal(root.get("unidadesDocumentales"),
					unidadesDocumentales));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<Series> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back Series entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<Series> getAll() {

		CriteriaQuery<Series> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(Series.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(Series.class))).getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final SeriesBean ejbProxy = this.sessionContext
				.getBusinessObject(SeriesBean.class);

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

				return String.valueOf(((Series) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private Series add = new Series();

	public Series getAdd() {
		return this.add;
	}

	public Series getAdded() {
		Series added = this.add;
		this.add = new Series();
		return added;
	}
}
