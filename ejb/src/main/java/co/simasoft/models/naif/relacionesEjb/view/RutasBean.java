package co.simasoft.models.naif.relacionesejb.view;

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

import co.simasoft.models.naif.relacionesejb.Rutas;
import co.simasoft.models.naif.relacionesejb.Buses;
import co.simasoft.models.naif.relacionesejb.Pasajes;
import java.util.Iterator;

/**
 * Backing bean for Rutas entities.
 * <p/>
 * This class provides CRUD functionality for all Rutas entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class RutasBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving Rutas entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Rutas rutas;

	public Rutas getRutas() {
		return this.rutas;
	}

	public void setRutas(Rutas rutas) {
		this.rutas = rutas;
	}

	@Inject
	private Conversation conversation;

	@PersistenceContext(unitName = "RelacionesEjbPU-JTA", type = PersistenceContextType.EXTENDED)
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
			this.rutas = this.example;
		} else {
			this.rutas = findById(getId());
		}
	}

	public Rutas findById(Long id) {

		return this.entityManager.find(Rutas.class, id);
	}

	/*
	 * Support updating and deleting Rutas entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.rutas);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.rutas);
				return "view?faces-redirect=true&id=" + this.rutas.getId();
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
			Rutas deletableEntity = findById(getId());
			Buses buses = deletableEntity.getBuses();
			buses.getRutas().remove(deletableEntity);
			deletableEntity.setBuses(null);
			this.entityManager.merge(buses);
			Iterator<Pasajes> iterPasajes = deletableEntity.getPasajes()
					.iterator();
			for (; iterPasajes.hasNext();) {
				Pasajes nextInPasajes = iterPasajes.next();
				nextInPasajes.setRutas(null);
				iterPasajes.remove();
				this.entityManager.merge(nextInPasajes);
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
	 * Support searching Rutas entities with pagination
	 */

	private int page;
	private long count;
	private List<Rutas> pageItems;

	private Rutas example = new Rutas();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public Rutas getExample() {
		return this.example;
	}

	public void setExample(Rutas example) {
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
		Root<Rutas> root = countCriteria.from(Rutas.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<Rutas> criteria = builder.createQuery(Rutas.class);
		root = criteria.from(Rutas.class);
		TypedQuery<Rutas> query = this.entityManager.createQuery(criteria
				.select(root).where(getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<Rutas> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		long orden = this.example.getOrden();
		if (orden != 0) {
			predicatesList.add(builder.equal(root.get("orden"), orden));
		}
		String origen = this.example.getOrigen();
		if (origen != null && !"".equals(origen)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("origen")),
					'%' + origen.toLowerCase() + '%'));
		}
		String destino = this.example.getDestino();
		if (destino != null && !"".equals(destino)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("destino")),
					'%' + destino.toLowerCase() + '%'));
		}
		String observaciones = this.example.getObservaciones();
		if (observaciones != null && !"".equals(observaciones)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("observaciones")),
					'%' + observaciones.toLowerCase() + '%'));
		}
		Buses buses = this.example.getBuses();
		if (buses != null) {
			predicatesList.add(builder.equal(root.get("buses"), buses));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<Rutas> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back Rutas entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<Rutas> getAll() {

		CriteriaQuery<Rutas> criteria = this.entityManager.getCriteriaBuilder()
				.createQuery(Rutas.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(Rutas.class))).getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final RutasBean ejbProxy = this.sessionContext
				.getBusinessObject(RutasBean.class);

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

				return String.valueOf(((Rutas) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private Rutas add = new Rutas();

	public Rutas getAdd() {
		return this.add;
	}

	public Rutas getAdded() {
		Rutas added = this.add;
		this.add = new Rutas();
		return added;
	}
}
