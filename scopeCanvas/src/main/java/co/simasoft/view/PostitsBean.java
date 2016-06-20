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

import co.simasoft.models.Postits;
import co.simasoft.models.ScopeCanvas;
import co.simasoft.models.SectionsScopeCanvas;
import java.lang.Boolean;
import java.util.Iterator;

/**
 * Backing bean for Postits entities.
 * <p/>
 * This class provides CRUD functionality for all Postits entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class PostitsBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving Postits entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Postits postits;

	public Postits getPostits() {
		return this.postits;
	}

	public void setPostits(Postits postits) {
		this.postits = postits;
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
			this.postits = this.example;
		} else {
			this.postits = findById(getId());
		}
	}

	public Postits findById(Long id) {

		return this.entityManager.find(Postits.class, id);
	}

	/*
	 * Support updating and deleting Postits entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.postits);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.postits);
				return "view?faces-redirect=true&id=" + this.postits.getId();
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
			Postits deletableEntity = findById(getId());
			Iterator<Postits> iterObjHijos = deletableEntity.getObjHijos()
					.iterator();
			for (; iterObjHijos.hasNext();) {
				Postits nextInObjHijos = iterObjHijos.next();
				nextInObjHijos.setObjPadre(null);
				iterObjHijos.remove();
				this.entityManager.merge(nextInObjHijos);
			}
			ScopeCanvas scopeCanvas = deletableEntity.getScopeCanvas();
			scopeCanvas.getPostits().remove(deletableEntity);
			deletableEntity.setScopeCanvas(null);
			this.entityManager.merge(scopeCanvas);
			Postits objPadre = deletableEntity.getObjPadre();
			objPadre.getObjHijos().remove(deletableEntity);
			deletableEntity.setObjPadre(null);
			this.entityManager.merge(objPadre);
			SectionsScopeCanvas sectionsScopeCanvas = deletableEntity
					.getSectionsScopeCanvas();
			sectionsScopeCanvas.getPostits().remove(deletableEntity);
			deletableEntity.setSectionsScopeCanvas(null);
			this.entityManager.merge(sectionsScopeCanvas);
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
	 * Support searching Postits entities with pagination
	 */

	private int page;
	private long count;
	private List<Postits> pageItems;

	private Postits example = new Postits();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 1000;
	}

	public Postits getExample() {
		return this.example;
	}

	public void setExample(Postits example) {
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
		Root<Postits> root = countCriteria.from(Postits.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<Postits> criteria = builder.createQuery(Postits.class);
		root = criteria.from(Postits.class);
		TypedQuery<Postits> query = this.entityManager.createQuery(criteria
				.select(root).where(getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<Postits> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		String observations = this.example.getObservations();
		if (observations != null && !"".equals(observations)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("observations")),
					'%' + observations.toLowerCase() + '%'));
		}
		String note = this.example.getNote();
		if (note != null && !"".equals(note)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("note")),
					'%' + note.toLowerCase() + '%'));
		}
		Boolean isValid = this.example.getIsValid();
		if (isValid != null) {
			predicatesList.add(builder.equal(root.get("isValid"), isValid));
		}
		ScopeCanvas scopeCanvas = this.example.getScopeCanvas();
		if (scopeCanvas != null) {
			predicatesList.add(builder.equal(root.get("scopeCanvas"),
					scopeCanvas));
		}
		Postits objPadre = this.example.getObjPadre();
		if (objPadre != null) {
			predicatesList.add(builder.equal(root.get("objPadre"), objPadre));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<Postits> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back Postits entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<Postits> getAll() {

		CriteriaQuery<Postits> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(Postits.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(Postits.class))).getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final PostitsBean ejbProxy = this.sessionContext
				.getBusinessObject(PostitsBean.class);

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

				return String.valueOf(((Postits) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private Postits add = new Postits();

	public Postits getAdd() {
		return this.add;
	}

	public Postits getAdded() {
		Postits added = this.add;
		this.add = new Postits();
		return added;
	}
}
