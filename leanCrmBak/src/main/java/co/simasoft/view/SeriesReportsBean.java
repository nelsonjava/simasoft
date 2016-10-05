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

import co.simasoft.models.SeriesReports;
import co.simasoft.models.Reports;
import co.simasoft.models.SectionsReports;
import java.util.Iterator;

/**
 * Backing bean for SeriesReports entities.
 * <p/>
 * This class provides CRUD functionality for all SeriesReports entities. It
 * focuses purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt>
 * for state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class SeriesReportsBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving SeriesReports entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private SeriesReports seriesReports;

	public SeriesReports getSeriesReports() {
		return this.seriesReports;
	}

	public void setSeriesReports(SeriesReports seriesReports) {
		this.seriesReports = seriesReports;
	}

	@Inject
	private Conversation conversation;

	@PersistenceContext(unitName = "leanCrmPU-JTA", type = PersistenceContextType.EXTENDED)
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
			this.seriesReports = this.example;
		} else {
			this.seriesReports = findById(getId());
		}
	}

	public SeriesReports findById(Long id) {

		return this.entityManager.find(SeriesReports.class, id);
	}

	/*
	 * Support updating and deleting SeriesReports entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.seriesReports);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.seriesReports);
				return "view?faces-redirect=true&id="
						+ this.seriesReports.getId();
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
			SeriesReports deletableEntity = findById(getId());
			Iterator<Reports> iterReports = deletableEntity.getReports()
					.iterator();
			for (; iterReports.hasNext();) {
				Reports nextInReports = iterReports.next();
				nextInReports.setSeriesReports(null);
				iterReports.remove();
				this.entityManager.merge(nextInReports);
			}
			SectionsReports sectionsReports = deletableEntity
					.getSectionsReports();
			sectionsReports.getSeriesReports().remove(deletableEntity);
			deletableEntity.setSectionsReports(null);
			this.entityManager.merge(sectionsReports);
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
	 * Support searching SeriesReports entities with pagination
	 */

	private int page;
	private long count;
	private List<SeriesReports> pageItems;

	private SeriesReports example = new SeriesReports();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 1000;
	}

	public SeriesReports getExample() {
		return this.example;
	}

	public void setExample(SeriesReports example) {
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
		Root<SeriesReports> root = countCriteria.from(SeriesReports.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<SeriesReports> criteria = builder
				.createQuery(SeriesReports.class);
		root = criteria.from(SeriesReports.class);
		TypedQuery<SeriesReports> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<SeriesReports> root) {

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
		String code = this.example.getCode();
		if (code != null && !"".equals(code)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("code")),
					'%' + code.toLowerCase() + '%'));
		}
		SectionsReports sectionsReports = this.example.getSectionsReports();
		if (sectionsReports != null) {
			predicatesList.add(builder.equal(root.get("sectionsReports"),
					sectionsReports));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<SeriesReports> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back SeriesReports entities (e.g. from inside
	 * an HtmlSelectOneMenu)
	 */

	public List<SeriesReports> getAll() {

		CriteriaQuery<SeriesReports> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(SeriesReports.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(SeriesReports.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final SeriesReportsBean ejbProxy = this.sessionContext
				.getBusinessObject(SeriesReportsBean.class);

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

				return String.valueOf(((SeriesReports) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private SeriesReports add = new SeriesReports();

	public SeriesReports getAdd() {
		return this.add;
	}

	public SeriesReports getAdded() {
		SeriesReports added = this.add;
		this.add = new SeriesReports();
		return added;
	}
}
