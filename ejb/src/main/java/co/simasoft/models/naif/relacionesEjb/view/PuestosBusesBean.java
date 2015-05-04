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

import co.simasoft.models.naif.relacionesejb.PuestosBuses;
import co.simasoft.models.naif.relacionesejb.Buses;

/**
 * Backing bean for PuestosBuses entities.
 * <p/>
 * This class provides CRUD functionality for all PuestosBuses entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class PuestosBusesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving PuestosBuses entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private PuestosBuses puestosBuses;

	public PuestosBuses getPuestosBuses() {
		return this.puestosBuses;
	}

	public void setPuestosBuses(PuestosBuses puestosBuses) {
		this.puestosBuses = puestosBuses;
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
			this.puestosBuses = this.example;
		} else {
			this.puestosBuses = findById(getId());
		}
	}

	public PuestosBuses findById(Long id) {

		return this.entityManager.find(PuestosBuses.class, id);
	}

	/*
	 * Support updating and deleting PuestosBuses entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.puestosBuses);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.puestosBuses);
				return "view?faces-redirect=true&id="
						+ this.puestosBuses.getId();
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
			PuestosBuses deletableEntity = findById(getId());
			Buses buses = deletableEntity.getBuses();
			buses.getPuestosBuses().remove(deletableEntity);
			deletableEntity.setBuses(null);
			this.entityManager.merge(buses);
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
	 * Support searching PuestosBuses entities with pagination
	 */

	private int page;
	private long count;
	private List<PuestosBuses> pageItems;

	private PuestosBuses example = new PuestosBuses();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public PuestosBuses getExample() {
		return this.example;
	}

	public void setExample(PuestosBuses example) {
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
		Root<PuestosBuses> root = countCriteria.from(PuestosBuses.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<PuestosBuses> criteria = builder
				.createQuery(PuestosBuses.class);
		root = criteria.from(PuestosBuses.class);
		TypedQuery<PuestosBuses> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<PuestosBuses> root) {

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
		Buses buses = this.example.getBuses();
		if (buses != null) {
			predicatesList.add(builder.equal(root.get("buses"), buses));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<PuestosBuses> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back PuestosBuses entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<PuestosBuses> getAll() {

		CriteriaQuery<PuestosBuses> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(PuestosBuses.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(PuestosBuses.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final PuestosBusesBean ejbProxy = this.sessionContext
				.getBusinessObject(PuestosBusesBean.class);

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

				return String.valueOf(((PuestosBuses) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private PuestosBuses add = new PuestosBuses();

	public PuestosBuses getAdd() {
		return this.add;
	}

	public PuestosBuses getAdded() {
		PuestosBuses added = this.add;
		this.add = new PuestosBuses();
		return added;
	}
}