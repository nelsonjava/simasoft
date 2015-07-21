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

import co.simasoft.models.naif.sgdea.TiposDocumentales;
import co.simasoft.models.naif.sgdea.Series;
import java.util.Iterator;

/**
 * Backing bean for TiposDocumentales entities.
 * <p/>
 * This class provides CRUD functionality for all TiposDocumentales entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class TiposDocumentalesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving TiposDocumentales entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private TiposDocumentales tiposDocumentales;

	public TiposDocumentales getTiposDocumentales() {
		return this.tiposDocumentales;
	}

	public void setTiposDocumentales(TiposDocumentales tiposDocumentales) {
		this.tiposDocumentales = tiposDocumentales;
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
			this.tiposDocumentales = this.example;
		} else {
			this.tiposDocumentales = findById(getId());
		}
	}

	public TiposDocumentales findById(Long id) {

		return this.entityManager.find(TiposDocumentales.class, id);
	}

	/*
	 * Support updating and deleting TiposDocumentales entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.tiposDocumentales);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.tiposDocumentales);
				return "view?faces-redirect=true&id="
						+ this.tiposDocumentales.getId();
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
			TiposDocumentales deletableEntity = findById(getId());
			Iterator<Series> iterSeries = deletableEntity.getSeries()
					.iterator();
			for (; iterSeries.hasNext();) {
				Series nextInSeries = iterSeries.next();
				nextInSeries.getTiposDocumentales().remove(deletableEntity);
				iterSeries.remove();
				this.entityManager.merge(nextInSeries);
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
	 * Support searching TiposDocumentales entities with pagination
	 */

	private int page;
	private long count;
	private List<TiposDocumentales> pageItems;

	private TiposDocumentales example = new TiposDocumentales();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public TiposDocumentales getExample() {
		return this.example;
	}

	public void setExample(TiposDocumentales example) {
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
		Root<TiposDocumentales> root = countCriteria
				.from(TiposDocumentales.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<TiposDocumentales> criteria = builder
				.createQuery(TiposDocumentales.class);
		root = criteria.from(TiposDocumentales.class);
		TypedQuery<TiposDocumentales> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<TiposDocumentales> root) {

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

	public List<TiposDocumentales> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back TiposDocumentales entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<TiposDocumentales> getAll() {

		CriteriaQuery<TiposDocumentales> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(TiposDocumentales.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(TiposDocumentales.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final TiposDocumentalesBean ejbProxy = this.sessionContext
				.getBusinessObject(TiposDocumentalesBean.class);

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

				return String.valueOf(((TiposDocumentales) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private TiposDocumentales add = new TiposDocumentales();

	public TiposDocumentales getAdd() {
		return this.add;
	}

	public TiposDocumentales getAdded() {
		TiposDocumentales added = this.add;
		this.add = new TiposDocumentales();
		return added;
	}
}
