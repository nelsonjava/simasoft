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

import co.simasoft.models.naif.relacionesejb.Cedulas;

/**
 * Backing bean for Cedulas entities.
 * <p/>
 * This class provides CRUD functionality for all Cedulas entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class CedulasBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving Cedulas entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Cedulas cedulas;

	public Cedulas getCedulas() {
		return this.cedulas;
	}

	public void setCedulas(Cedulas cedulas) {
		this.cedulas = cedulas;
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
			this.cedulas = this.example;
		} else {
			this.cedulas = findById(getId());
		}
	}

	public Cedulas findById(Long id) {

		return this.entityManager.find(Cedulas.class, id);
	}

	/*
	 * Support updating and deleting Cedulas entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.cedulas);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.cedulas);
				return "view?faces-redirect=true&id=" + this.cedulas.getId();
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
			Cedulas deletableEntity = findById(getId());

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
	 * Support searching Cedulas entities with pagination
	 */

	private int page;
	private long count;
	private List<Cedulas> pageItems;

	private Cedulas example = new Cedulas();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public Cedulas getExample() {
		return this.example;
	}

	public void setExample(Cedulas example) {
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
		Root<Cedulas> root = countCriteria.from(Cedulas.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<Cedulas> criteria = builder.createQuery(Cedulas.class);
		root = criteria.from(Cedulas.class);
		TypedQuery<Cedulas> query = this.entityManager.createQuery(criteria
				.select(root).where(getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<Cedulas> root) {

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

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<Cedulas> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back Cedulas entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<Cedulas> getAll() {

		CriteriaQuery<Cedulas> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(Cedulas.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(Cedulas.class))).getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final CedulasBean ejbProxy = this.sessionContext
				.getBusinessObject(CedulasBean.class);

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

				return String.valueOf(((Cedulas) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private Cedulas add = new Cedulas();

	public Cedulas getAdd() {
		return this.add;
	}

	public Cedulas getAdded() {
		Cedulas added = this.add;
		this.add = new Cedulas();
		return added;
	}
}
