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

import co.simasoft.models.FinalDisposition;
import co.simasoft.models.Series;

/**
 * Backing bean for FinalDisposition entities.
 * <p/>
 * This class provides CRUD functionality for all FinalDisposition entities. It
 * focuses purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt>
 * for state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class FinalDispositionBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving FinalDisposition entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private FinalDisposition finalDisposition;

	public FinalDisposition getFinalDisposition() {
		return this.finalDisposition;
	}

	public void setFinalDisposition(FinalDisposition finalDisposition) {
		this.finalDisposition = finalDisposition;
	}

	@Inject
	private Conversation conversation;

	@PersistenceContext(unitName = "archivalPU-JTA", type = PersistenceContextType.EXTENDED)
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
			this.finalDisposition = this.example;
		} else {
			this.finalDisposition = findById(getId());
		}
	}

	public FinalDisposition findById(Long id) {

		return this.entityManager.find(FinalDisposition.class, id);
	}

	/*
	 * Support updating and deleting FinalDisposition entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.finalDisposition);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.finalDisposition);
				return "view?faces-redirect=true&id="
						+ this.finalDisposition.getId();
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
			FinalDisposition deletableEntity = findById(getId());
			Series series = deletableEntity.getSeries();
			series.getFinalDisposition().remove(deletableEntity);
			deletableEntity.setSeries(null);
			this.entityManager.merge(series);
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
	 * Support searching FinalDisposition entities with pagination
	 */

	private int page;
	private long count;
	private List<FinalDisposition> pageItems;

	private FinalDisposition example = new FinalDisposition();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 1000;
	}

	public FinalDisposition getExample() {
		return this.example;
	}

	public void setExample(FinalDisposition example) {
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
		Root<FinalDisposition> root = countCriteria
				.from(FinalDisposition.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<FinalDisposition> criteria = builder
				.createQuery(FinalDisposition.class);
		root = criteria.from(FinalDisposition.class);
		TypedQuery<FinalDisposition> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<FinalDisposition> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		String observations = this.example.getObservations();
		if (observations != null && !"".equals(observations)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("observations")),
					'%' + observations.toLowerCase() + '%'));
		}
		String name = this.example.getName();
		if (name != null && !"".equals(name)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("name")),
					'%' + name.toLowerCase() + '%'));
		}
		Series series = this.example.getSeries();
		if (series != null) {
			predicatesList.add(builder.equal(root.get("series"), series));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<FinalDisposition> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back FinalDisposition entities (e.g. from
	 * inside an HtmlSelectOneMenu)
	 */

	public List<FinalDisposition> getAll() {

		CriteriaQuery<FinalDisposition> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(FinalDisposition.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(FinalDisposition.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final FinalDispositionBean ejbProxy = this.sessionContext
				.getBusinessObject(FinalDispositionBean.class);

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

				return String.valueOf(((FinalDisposition) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private FinalDisposition add = new FinalDisposition();

	public FinalDisposition getAdd() {
		return this.add;
	}

	public FinalDisposition getAdded() {
		FinalDisposition added = this.add;
		this.add = new FinalDisposition();
		return added;
	}
}
