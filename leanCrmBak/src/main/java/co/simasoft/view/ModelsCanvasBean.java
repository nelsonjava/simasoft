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

import co.simasoft.models.ModelsCanvas;
import co.simasoft.models.LeanProjects;
import co.simasoft.models.ModelsCanvasSections;
import java.util.Iterator;

/**
 * Backing bean for ModelsCanvas entities.
 * <p/>
 * This class provides CRUD functionality for all ModelsCanvas entities. It
 * focuses purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt>
 * for state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class ModelsCanvasBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving ModelsCanvas entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private ModelsCanvas modelsCanvas;

	public ModelsCanvas getModelsCanvas() {
		return this.modelsCanvas;
	}

	public void setModelsCanvas(ModelsCanvas modelsCanvas) {
		this.modelsCanvas = modelsCanvas;
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
			this.modelsCanvas = this.example;
		} else {
			this.modelsCanvas = findById(getId());
		}
	}

	public ModelsCanvas findById(Long id) {

		return this.entityManager.find(ModelsCanvas.class, id);
	}

	/*
	 * Support updating and deleting ModelsCanvas entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.modelsCanvas);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.modelsCanvas);
				return "view?faces-redirect=true&id="
						+ this.modelsCanvas.getId();
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
			ModelsCanvas deletableEntity = findById(getId());
			Iterator<ModelsCanvasSections> iterModelsCanvasSections = deletableEntity
					.getModelsCanvasSections().iterator();
			for (; iterModelsCanvasSections.hasNext();) {
				ModelsCanvasSections nextInModelsCanvasSections = iterModelsCanvasSections
						.next();
				nextInModelsCanvasSections.getModelsCanvas().remove(
						deletableEntity);
				iterModelsCanvasSections.remove();
				this.entityManager.merge(nextInModelsCanvasSections);
			}
			LeanProjects leanProjects = deletableEntity.getLeanProjects();
			leanProjects.getModelsCanvas().remove(deletableEntity);
			deletableEntity.setLeanProjects(null);
			this.entityManager.merge(leanProjects);
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
	 * Support searching ModelsCanvas entities with pagination
	 */

	private int page;
	private long count;
	private List<ModelsCanvas> pageItems;

	private ModelsCanvas example = new ModelsCanvas();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 1000;
	}

	public ModelsCanvas getExample() {
		return this.example;
	}

	public void setExample(ModelsCanvas example) {
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
		Root<ModelsCanvas> root = countCriteria.from(ModelsCanvas.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<ModelsCanvas> criteria = builder
				.createQuery(ModelsCanvas.class);
		root = criteria.from(ModelsCanvas.class);
		TypedQuery<ModelsCanvas> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<ModelsCanvas> root) {

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
		LeanProjects leanProjects = this.example.getLeanProjects();
		if (leanProjects != null) {
			predicatesList.add(builder.equal(root.get("leanProjects"),
					leanProjects));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<ModelsCanvas> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back ModelsCanvas entities (e.g. from inside
	 * an HtmlSelectOneMenu)
	 */

	public List<ModelsCanvas> getAll() {

		CriteriaQuery<ModelsCanvas> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(ModelsCanvas.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(ModelsCanvas.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final ModelsCanvasBean ejbProxy = this.sessionContext
				.getBusinessObject(ModelsCanvasBean.class);

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

				return String.valueOf(((ModelsCanvas) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private ModelsCanvas add = new ModelsCanvas();

	public ModelsCanvas getAdd() {
		return this.add;
	}

	public ModelsCanvas getAdded() {
		ModelsCanvas added = this.add;
		this.add = new ModelsCanvas();
		return added;
	}
}