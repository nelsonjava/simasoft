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

import co.simasoft.models.LegisSubject;
import co.simasoft.models.LegisArtSubject;
import co.simasoft.models.LegisTopic;
import java.util.Iterator;

/**
 * Backing bean for LegisSubject entities.
 * <p/>
 * This class provides CRUD functionality for all LegisSubject entities. It
 * focuses purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt>
 * for state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class LegisSubjectBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving LegisSubject entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private LegisSubject legisSubject;

	public LegisSubject getLegisSubject() {
		return this.legisSubject;
	}

	public void setLegisSubject(LegisSubject legisSubject) {
		this.legisSubject = legisSubject;
	}

	@Inject
	private Conversation conversation;

	@PersistenceContext(unitName = "legisPU-JTA", type = PersistenceContextType.EXTENDED)
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
			this.legisSubject = this.example;
		} else {
			this.legisSubject = findById(getId());
		}
	}

	public LegisSubject findById(Long id) {

		return this.entityManager.find(LegisSubject.class, id);
	}

	/*
	 * Support updating and deleting LegisSubject entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.legisSubject);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.legisSubject);
				return "view?faces-redirect=true&id="
						+ this.legisSubject.getId();
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
			LegisSubject deletableEntity = findById(getId());
			Iterator<LegisArtSubject> iterLegisArtSubject = deletableEntity
					.getLegisArtSubject().iterator();
			for (; iterLegisArtSubject.hasNext();) {
				LegisArtSubject nextInLegisArtSubject = iterLegisArtSubject
						.next();
				nextInLegisArtSubject.setLegisSubject(null);
				iterLegisArtSubject.remove();
				this.entityManager.merge(nextInLegisArtSubject);
			}
			Iterator<LegisTopic> iterLegisTopic = deletableEntity
					.getLegisTopic().iterator();
			for (; iterLegisTopic.hasNext();) {
				LegisTopic nextInLegisTopic = iterLegisTopic.next();
				nextInLegisTopic.setLegisSubject(null);
				iterLegisTopic.remove();
				this.entityManager.merge(nextInLegisTopic);
			}
			Iterator<LegisSubject> iterObjHijos = deletableEntity.getObjHijos()
					.iterator();
			for (; iterObjHijos.hasNext();) {
				LegisSubject nextInObjHijos = iterObjHijos.next();
				nextInObjHijos.setObjPadre(null);
				iterObjHijos.remove();
				this.entityManager.merge(nextInObjHijos);
			}
			LegisSubject objPadre = deletableEntity.getObjPadre();
			objPadre.getObjHijos().remove(deletableEntity);
			deletableEntity.setObjPadre(null);
			this.entityManager.merge(objPadre);
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
	 * Support searching LegisSubject entities with pagination
	 */

	private int page;
	private long count;
	private List<LegisSubject> pageItems;

	private LegisSubject example = new LegisSubject();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 1000;
	}

	public LegisSubject getExample() {
		return this.example;
	}

	public void setExample(LegisSubject example) {
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
		Root<LegisSubject> root = countCriteria.from(LegisSubject.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<LegisSubject> criteria = builder
				.createQuery(LegisSubject.class);
		root = criteria.from(LegisSubject.class);
		TypedQuery<LegisSubject> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<LegisSubject> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		String observations = this.example.getObservations();
		if (observations != null && !"".equals(observations)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("observations")),
					'%' + observations.toLowerCase() + '%'));
		}
		String code = this.example.getCode();
		if (code != null && !"".equals(code)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("code")),
					'%' + code.toLowerCase() + '%'));
		}
		String name = this.example.getName();
		if (name != null && !"".equals(name)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("name")),
					'%' + name.toLowerCase() + '%'));
		}
		LegisSubject objPadre = this.example.getObjPadre();
		if (objPadre != null) {
			predicatesList.add(builder.equal(root.get("objPadre"), objPadre));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<LegisSubject> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back LegisSubject entities (e.g. from inside
	 * an HtmlSelectOneMenu)
	 */

	public List<LegisSubject> getAll() {

		CriteriaQuery<LegisSubject> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(LegisSubject.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(LegisSubject.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final LegisSubjectBean ejbProxy = this.sessionContext
				.getBusinessObject(LegisSubjectBean.class);

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

				return String.valueOf(((LegisSubject) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private LegisSubject add = new LegisSubject();

	public LegisSubject getAdd() {
		return this.add;
	}

	public LegisSubject getAdded() {
		LegisSubject added = this.add;
		this.add = new LegisSubject();
		return added;
	}
}
