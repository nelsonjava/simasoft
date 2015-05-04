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

import co.simasoft.models.naif.relacionesejb.Buses;
import co.simasoft.models.naif.relacionesejb.PuestosBuses;
import co.simasoft.models.naif.relacionesejb.Rutas;
import java.util.Iterator;

/**
 * Backing bean for Buses entities.
 * <p/>
 * This class provides CRUD functionality for all Buses entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class BusesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving Buses entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Buses buses;

	public Buses getBuses() {
		return this.buses;
	}

	public void setBuses(Buses buses) {
		this.buses = buses;
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
			this.buses = this.example;
		} else {
			this.buses = findById(getId());
		}
	}

	public Buses findById(Long id) {

		return this.entityManager.find(Buses.class, id);
	}

	/*
	 * Support updating and deleting Buses entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.buses);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.buses);
				return "view?faces-redirect=true&id=" + this.buses.getId();
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
			Buses deletableEntity = findById(getId());
			Iterator<Rutas> iterRutas = deletableEntity.getRutas().iterator();
			for (; iterRutas.hasNext();) {
				Rutas nextInRutas = iterRutas.next();
				nextInRutas.setBuses(null);
				iterRutas.remove();
				this.entityManager.merge(nextInRutas);
			}
			Iterator<PuestosBuses> iterPuestosBuses = deletableEntity
					.getPuestosBuses().iterator();
			for (; iterPuestosBuses.hasNext();) {
				PuestosBuses nextInPuestosBuses = iterPuestosBuses.next();
				nextInPuestosBuses.setBuses(null);
				iterPuestosBuses.remove();
				this.entityManager.merge(nextInPuestosBuses);
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
	 * Support searching Buses entities with pagination
	 */

	private int page;
	private long count;
	private List<Buses> pageItems;

	private Buses example = new Buses();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public Buses getExample() {
		return this.example;
	}

	public void setExample(Buses example) {
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
		Root<Buses> root = countCriteria.from(Buses.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<Buses> criteria = builder.createQuery(Buses.class);
		root = criteria.from(Buses.class);
		TypedQuery<Buses> query = this.entityManager.createQuery(criteria
				.select(root).where(getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<Buses> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		long orden = this.example.getOrden();
		if (orden != 0) {
			predicatesList.add(builder.equal(root.get("orden"), orden));
		}
		String numero = this.example.getNumero();
		if (numero != null && !"".equals(numero)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("numero")),
					'%' + numero.toLowerCase() + '%'));
		}
		String clase = this.example.getClase();
		if (clase != null && !"".equals(clase)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("clase")),
					'%' + clase.toLowerCase() + '%'));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<Buses> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back Buses entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<Buses> getAll() {

		CriteriaQuery<Buses> criteria = this.entityManager.getCriteriaBuilder()
				.createQuery(Buses.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(Buses.class))).getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final BusesBean ejbProxy = this.sessionContext
				.getBusinessObject(BusesBean.class);

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

				return String.valueOf(((Buses) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private Buses add = new Buses();

	public Buses getAdd() {
		return this.add;
	}

	public Buses getAdded() {
		Buses added = this.add;
		this.add = new Buses();
		return added;
	}
}
