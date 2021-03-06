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

import co.simasoft.models.SitesTypes;
import co.simasoft.models.Sites;
import java.util.Iterator;

/**
 * Backing bean for SitesTypes entities.
 * <p/>
 * This class provides CRUD functionality for all SitesTypes entities. It
 * focuses purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt>
 * for state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class SitesTypesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving SitesTypes entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private SitesTypes sitesTypes;

	public SitesTypes getSitesTypes() {
		return this.sitesTypes;
	}

	public void setSitesTypes(SitesTypes sitesTypes) {
		this.sitesTypes = sitesTypes;
	}

	@Inject
	private Conversation conversation;

	@PersistenceContext(unitName = "naifg29PU-JTA", type = PersistenceContextType.EXTENDED)
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
			this.sitesTypes = this.example;
		} else {
			this.sitesTypes = findById(getId());
		}
	}

	public SitesTypes findById(Long id) {

		return this.entityManager.find(SitesTypes.class, id);
	}

	/*
	 * Support updating and deleting SitesTypes entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.sitesTypes);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.sitesTypes);
				return "view?faces-redirect=true&id=" + this.sitesTypes.getId();
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
			SitesTypes deletableEntity = findById(getId());
			Iterator<SitesTypes> iterObjHijos = deletableEntity.getObjHijos()
					.iterator();
			for (; iterObjHijos.hasNext();) {
				SitesTypes nextInObjHijos = iterObjHijos.next();
				nextInObjHijos.setObjPadre(null);
				iterObjHijos.remove();
				this.entityManager.merge(nextInObjHijos);
			}
			SitesTypes objPadre = deletableEntity.getObjPadre();
			objPadre.getObjHijos().remove(deletableEntity);
			deletableEntity.setObjPadre(null);
			this.entityManager.merge(objPadre);
			Iterator<Sites> iterSites = deletableEntity.getSites().iterator();
			for (; iterSites.hasNext();) {
				Sites nextInSites = iterSites.next();
				nextInSites.getSitesTypes().remove(deletableEntity);
				iterSites.remove();
				this.entityManager.merge(nextInSites);
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
	 * Support searching SitesTypes entities with pagination
	 */

	private int page;
	private long count;
	private List<SitesTypes> pageItems;

	private SitesTypes example = new SitesTypes();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 1000;
	}

	public SitesTypes getExample() {
		return this.example;
	}

	public void setExample(SitesTypes example) {
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
		Root<SitesTypes> root = countCriteria.from(SitesTypes.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<SitesTypes> criteria = builder
				.createQuery(SitesTypes.class);
		root = criteria.from(SitesTypes.class);
		TypedQuery<SitesTypes> query = this.entityManager.createQuery(criteria
				.select(root).where(getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<SitesTypes> root) {

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
		SitesTypes objPadre = this.example.getObjPadre();
		if (objPadre != null) {
			predicatesList.add(builder.equal(root.get("objPadre"), objPadre));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<SitesTypes> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back SitesTypes entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<SitesTypes> getAll() {

		CriteriaQuery<SitesTypes> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(SitesTypes.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(SitesTypes.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final SitesTypesBean ejbProxy = this.sessionContext
				.getBusinessObject(SitesTypesBean.class);

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

				return String.valueOf(((SitesTypes) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private SitesTypes add = new SitesTypes();

	public SitesTypes getAdd() {
		return this.add;
	}

	public SitesTypes getAdded() {
		SitesTypes added = this.add;
		this.add = new SitesTypes();
		return added;
	}
}
