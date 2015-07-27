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

import co.simasoft.models.naif.task.archival.Sections;
import co.simasoft.models.naif.task.archival.Funds;
import co.simasoft.models.naif.task.archival.SectionsTypes;
import co.simasoft.models.naif.task.archival.Series;
import java.util.Iterator;

/**
 * Backing bean for Sections entities.
 * <p/>
 * This class provides CRUD functionality for all Sections entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class SectionsBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving Sections entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Sections sections;

	public Sections getSections() {
		return this.sections;
	}

	public void setSections(Sections sections) {
		this.sections = sections;
	}

	@Inject
	private Conversation conversation;

	@PersistenceContext(unitName = "taskPU-JTA", type = PersistenceContextType.EXTENDED)
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
			this.sections = this.example;
		} else {
			this.sections = findById(getId());
		}
	}

	public Sections findById(Long id) {

		return this.entityManager.find(Sections.class, id);
	}

	/*
	 * Support updating and deleting Sections entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.sections);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.sections);
				return "view?faces-redirect=true&id=" + this.sections.getId();
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
			Sections deletableEntity = findById(getId());
			Iterator<Sections> iterObjHijos = deletableEntity.getObjHijos()
					.iterator();
			for (; iterObjHijos.hasNext();) {
				Sections nextInObjHijos = iterObjHijos.next();
				nextInObjHijos.setObjPadre(null);
				iterObjHijos.remove();
				this.entityManager.merge(nextInObjHijos);
			}
			Iterator<Series> iterSeries = deletableEntity.getSeries()
					.iterator();
			for (; iterSeries.hasNext();) {
				Series nextInSeries = iterSeries.next();
				nextInSeries.getSections().remove(deletableEntity);
				iterSeries.remove();
				this.entityManager.merge(nextInSeries);
			}
			Sections objPadre = deletableEntity.getObjPadre();
			objPadre.getObjHijos().remove(deletableEntity);
			deletableEntity.setObjPadre(null);
			this.entityManager.merge(objPadre);
			SectionsTypes sectionsTypes = deletableEntity.getSectionsTypes();
			sectionsTypes.getSections().remove(deletableEntity);
			deletableEntity.setSectionsTypes(null);
			this.entityManager.merge(sectionsTypes);
			Funds funds = deletableEntity.getFunds();
			funds.getSections().remove(deletableEntity);
			deletableEntity.setFunds(null);
			this.entityManager.merge(funds);
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
	 * Support searching Sections entities with pagination
	 */

	private int page;
	private long count;
	private List<Sections> pageItems;

	private Sections example = new Sections();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public Sections getExample() {
		return this.example;
	}

	public void setExample(Sections example) {
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
		Root<Sections> root = countCriteria.from(Sections.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<Sections> criteria = builder.createQuery(Sections.class);
		root = criteria.from(Sections.class);
		TypedQuery<Sections> query = this.entityManager.createQuery(criteria
				.select(root).where(getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<Sections> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

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
		String email = this.example.getEmail();
		if (email != null && !"".equals(email)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("email")),
					'%' + email.toLowerCase() + '%'));
		}
		Sections objPadre = this.example.getObjPadre();
		if (objPadre != null) {
			predicatesList.add(builder.equal(root.get("objPadre"), objPadre));
		}
		SectionsTypes sectionsTypes = this.example.getSectionsTypes();
		if (sectionsTypes != null) {
			predicatesList.add(builder.equal(root.get("sectionsTypes"),
					sectionsTypes));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<Sections> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back Sections entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<Sections> getAll() {

		CriteriaQuery<Sections> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(Sections.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(Sections.class))).getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final SectionsBean ejbProxy = this.sessionContext
				.getBusinessObject(SectionsBean.class);

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

				return String.valueOf(((Sections) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private Sections add = new Sections();

	public Sections getAdd() {
		return this.add;
	}

	public Sections getAdded() {
		Sections added = this.add;
		this.add = new Sections();
		return added;
	}
}
