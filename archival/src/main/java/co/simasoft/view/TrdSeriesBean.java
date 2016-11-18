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

import co.simasoft.models.TrdSeries;
import co.simasoft.models.Series;
import co.simasoft.models.Trd;

/**
 * Backing bean for TrdSeries entities.
 * <p/>
 * This class provides CRUD functionality for all TrdSeries entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class TrdSeriesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving TrdSeries entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private TrdSeries trdSeries;

	public TrdSeries getTrdSeries() {
		return this.trdSeries;
	}

	public void setTrdSeries(TrdSeries trdSeries) {
		this.trdSeries = trdSeries;
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
			this.trdSeries = this.example;
		} else {
			this.trdSeries = findById(getId());
		}
	}

	public TrdSeries findById(Long id) {

		return this.entityManager.find(TrdSeries.class, id);
	}

	/*
	 * Support updating and deleting TrdSeries entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.trdSeries);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.trdSeries);
				return "view?faces-redirect=true&id=" + this.trdSeries.getId();
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
			TrdSeries deletableEntity = findById(getId());
			Trd trd = deletableEntity.getTrd();
			trd.getTrdSeries().remove(deletableEntity);
			deletableEntity.setTrd(null);
			this.entityManager.merge(trd);
			Series series = deletableEntity.getSeries();
			series.getTrdSeries().remove(deletableEntity);
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
	 * Support searching TrdSeries entities with pagination
	 */

	private int page;
	private long count;
	private List<TrdSeries> pageItems;

	private TrdSeries example = new TrdSeries();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public TrdSeries getExample() {
		return this.example;
	}

	public void setExample(TrdSeries example) {
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
		Root<TrdSeries> root = countCriteria.from(TrdSeries.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<TrdSeries> criteria = builder
				.createQuery(TrdSeries.class);
		root = criteria.from(TrdSeries.class);
		TypedQuery<TrdSeries> query = this.entityManager.createQuery(criteria
				.select(root).where(getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<TrdSeries> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		String alias = this.example.getAlias();
		if (alias != null && !"".equals(alias)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("alias")),
					'%' + alias.toLowerCase() + '%'));
		}
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
		Trd trd = this.example.getTrd();
		if (trd != null) {
			predicatesList.add(builder.equal(root.get("trd"), trd));
		}
		Series series = this.example.getSeries();
		if (series != null) {
			predicatesList.add(builder.equal(root.get("series"), series));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<TrdSeries> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back TrdSeries entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<TrdSeries> getAll() {

		CriteriaQuery<TrdSeries> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(TrdSeries.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(TrdSeries.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final TrdSeriesBean ejbProxy = this.sessionContext
				.getBusinessObject(TrdSeriesBean.class);

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

				return String.valueOf(((TrdSeries) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private TrdSeries add = new TrdSeries();

	public TrdSeries getAdd() {
		return this.add;
	}

	public TrdSeries getAdded() {
		TrdSeries added = this.add;
		this.add = new TrdSeries();
		return added;
	}
}
