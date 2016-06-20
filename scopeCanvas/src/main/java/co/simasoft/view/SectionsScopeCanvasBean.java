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

import co.simasoft.models.SectionsScopeCanvas;
import co.simasoft.models.Postits;
import java.util.Iterator;

/**
 * Backing bean for SectionsScopeCanvas entities.
 * <p/>
 * This class provides CRUD functionality for all SectionsScopeCanvas entities.
 * It focuses purely on Java EE 6 standards (e.g.
 * <tt>&#64;ConversationScoped</tt> for state management,
 * <tt>PersistenceContext</tt> for persistence, <tt>CriteriaBuilder</tt> for
 * searches) rather than introducing a CRUD framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class SectionsScopeCanvasBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving SectionsScopeCanvas entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private SectionsScopeCanvas sectionsScopeCanvas;

	public SectionsScopeCanvas getSectionsScopeCanvas() {
		return this.sectionsScopeCanvas;
	}

	public void setSectionsScopeCanvas(SectionsScopeCanvas sectionsScopeCanvas) {
		this.sectionsScopeCanvas = sectionsScopeCanvas;
	}

	@Inject
	private Conversation conversation;

	@PersistenceContext(unitName = "scopeCanvasPU-JTA", type = PersistenceContextType.EXTENDED)
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
			this.sectionsScopeCanvas = this.example;
		} else {
			this.sectionsScopeCanvas = findById(getId());
		}
	}

	public SectionsScopeCanvas findById(Long id) {

		return this.entityManager.find(SectionsScopeCanvas.class, id);
	}

	/*
	 * Support updating and deleting SectionsScopeCanvas entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.sectionsScopeCanvas);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.sectionsScopeCanvas);
				return "view?faces-redirect=true&id="
						+ this.sectionsScopeCanvas.getId();
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
			SectionsScopeCanvas deletableEntity = findById(getId());
			Iterator<Postits> iterPostits = deletableEntity.getPostits()
					.iterator();
			for (; iterPostits.hasNext();) {
				Postits nextInPostits = iterPostits.next();
				nextInPostits.setSectionsScopeCanvas(null);
				iterPostits.remove();
				this.entityManager.merge(nextInPostits);
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
	 * Support searching SectionsScopeCanvas entities with pagination
	 */

	private int page;
	private long count;
	private List<SectionsScopeCanvas> pageItems;

	private SectionsScopeCanvas example = new SectionsScopeCanvas();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 1000;
	}

	public SectionsScopeCanvas getExample() {
		return this.example;
	}

	public void setExample(SectionsScopeCanvas example) {
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
		Root<SectionsScopeCanvas> root = countCriteria
				.from(SectionsScopeCanvas.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<SectionsScopeCanvas> criteria = builder
				.createQuery(SectionsScopeCanvas.class);
		root = criteria.from(SectionsScopeCanvas.class);
		TypedQuery<SectionsScopeCanvas> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<SectionsScopeCanvas> root) {

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

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<SectionsScopeCanvas> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back SectionsScopeCanvas entities (e.g. from
	 * inside an HtmlSelectOneMenu)
	 */

	public List<SectionsScopeCanvas> getAll() {

		CriteriaQuery<SectionsScopeCanvas> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(SectionsScopeCanvas.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(SectionsScopeCanvas.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final SectionsScopeCanvasBean ejbProxy = this.sessionContext
				.getBusinessObject(SectionsScopeCanvasBean.class);

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

				return String.valueOf(((SectionsScopeCanvas) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private SectionsScopeCanvas add = new SectionsScopeCanvas();

	public SectionsScopeCanvas getAdd() {
		return this.add;
	}

	public SectionsScopeCanvas getAdded() {
		SectionsScopeCanvas added = this.add;
		this.add = new SectionsScopeCanvas();
		return added;
	}
}
