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

import co.simasoft.models.naif.relacionesejb.Pasajes;
import co.simasoft.models.naif.relacionesejb.Personas;
import co.simasoft.models.naif.relacionesejb.Rutas;
import java.util.Iterator;

/**
 * Backing bean for Pasajes entities.
 * <p/>
 * This class provides CRUD functionality for all Pasajes entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class PasajesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving Pasajes entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Pasajes pasajes;

	public Pasajes getPasajes() {
		return this.pasajes;
	}

	public void setPasajes(Pasajes pasajes) {
		this.pasajes = pasajes;
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
			this.pasajes = this.example;
		} else {
			this.pasajes = findById(getId());
		}
	}

	public Pasajes findById(Long id) {

		return this.entityManager.find(Pasajes.class, id);
	}

	/*
	 * Support updating and deleting Pasajes entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.pasajes);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.pasajes);
				return "view?faces-redirect=true&id=" + this.pasajes.getId();
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
			Pasajes deletableEntity = findById(getId());
			Rutas rutas = deletableEntity.getRutas();
			rutas.getPasajes().remove(deletableEntity);
			deletableEntity.setRutas(null);
			this.entityManager.merge(rutas);
			Iterator<Personas> iterPersonas = deletableEntity.getPersonas()
					.iterator();
			for (; iterPersonas.hasNext();) {
				Personas nextInPersonas = iterPersonas.next();
				nextInPersonas.getPasajes().remove(deletableEntity);
				iterPersonas.remove();
				this.entityManager.merge(nextInPersonas);
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
	 * Support searching Pasajes entities with pagination
	 */

	private int page;
	private long count;
	private List<Pasajes> pageItems;

	private Pasajes example = new Pasajes();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public Pasajes getExample() {
		return this.example;
	}

	public void setExample(Pasajes example) {
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
		Root<Pasajes> root = countCriteria.from(Pasajes.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<Pasajes> criteria = builder.createQuery(Pasajes.class);
		root = criteria.from(Pasajes.class);
		TypedQuery<Pasajes> query = this.entityManager.createQuery(criteria
				.select(root).where(getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<Pasajes> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		long orden = this.example.getOrden();
		if (orden != 0) {
			predicatesList.add(builder.equal(root.get("orden"), orden));
		}
		Integer numero = this.example.getNumero();
		if (numero != null && numero.intValue() != 0) {
			predicatesList.add(builder.equal(root.get("numero"), numero));
		}
		Rutas rutas = this.example.getRutas();
		if (rutas != null) {
			predicatesList.add(builder.equal(root.get("rutas"), rutas));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<Pasajes> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back Pasajes entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<Pasajes> getAll() {

		CriteriaQuery<Pasajes> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(Pasajes.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(Pasajes.class))).getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final PasajesBean ejbProxy = this.sessionContext
				.getBusinessObject(PasajesBean.class);

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

				return String.valueOf(((Pasajes) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private Pasajes add = new Pasajes();

	public Pasajes getAdd() {
		return this.add;
	}

	public Pasajes getAdded() {
		Pasajes added = this.add;
		this.add = new Pasajes();
		return added;
	}
}
