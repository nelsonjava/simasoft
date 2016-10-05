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

import co.simasoft.models.CompaniesRolesTypes;
import co.simasoft.models.CompaniesRoles;
import java.util.Iterator;

/**
 * Backing bean for CompaniesRolesTypes entities.
 * <p/>
 * This class provides CRUD functionality for all CompaniesRolesTypes entities.
 * It focuses purely on Java EE 6 standards (e.g.
 * <tt>&#64;ConversationScoped</tt> for state management,
 * <tt>PersistenceContext</tt> for persistence, <tt>CriteriaBuilder</tt> for
 * searches) rather than introducing a CRUD framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class CompaniesRolesTypesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving CompaniesRolesTypes entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private CompaniesRolesTypes companiesRolesTypes;

	public CompaniesRolesTypes getCompaniesRolesTypes() {
		return this.companiesRolesTypes;
	}

	public void setCompaniesRolesTypes(CompaniesRolesTypes companiesRolesTypes) {
		this.companiesRolesTypes = companiesRolesTypes;
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
			this.companiesRolesTypes = this.example;
		} else {
			this.companiesRolesTypes = findById(getId());
		}
	}

	public CompaniesRolesTypes findById(Long id) {

		return this.entityManager.find(CompaniesRolesTypes.class, id);
	}

	/*
	 * Support updating and deleting CompaniesRolesTypes entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.companiesRolesTypes);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.companiesRolesTypes);
				return "view?faces-redirect=true&id="
						+ this.companiesRolesTypes.getId();
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
			CompaniesRolesTypes deletableEntity = findById(getId());
			Iterator<CompaniesRoles> iterCompaniesRoles = deletableEntity
					.getCompaniesRoles().iterator();
			for (; iterCompaniesRoles.hasNext();) {
				CompaniesRoles nextInCompaniesRoles = iterCompaniesRoles.next();
				nextInCompaniesRoles.setCompaniesRolesTypes(null);
				iterCompaniesRoles.remove();
				this.entityManager.merge(nextInCompaniesRoles);
			}
			Iterator<CompaniesRolesTypes> iterObjHijos = deletableEntity
					.getObjHijos().iterator();
			for (; iterObjHijos.hasNext();) {
				CompaniesRolesTypes nextInObjHijos = iterObjHijos.next();
				nextInObjHijos.setObjPadre(null);
				iterObjHijos.remove();
				this.entityManager.merge(nextInObjHijos);
			}
			CompaniesRolesTypes objPadre = deletableEntity.getObjPadre();
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
	 * Support searching CompaniesRolesTypes entities with pagination
	 */

	private int page;
	private long count;
	private List<CompaniesRolesTypes> pageItems;

	private CompaniesRolesTypes example = new CompaniesRolesTypes();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 1000;
	}

	public CompaniesRolesTypes getExample() {
		return this.example;
	}

	public void setExample(CompaniesRolesTypes example) {
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
		Root<CompaniesRolesTypes> root = countCriteria
				.from(CompaniesRolesTypes.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<CompaniesRolesTypes> criteria = builder
				.createQuery(CompaniesRolesTypes.class);
		root = criteria.from(CompaniesRolesTypes.class);
		TypedQuery<CompaniesRolesTypes> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<CompaniesRolesTypes> root) {

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
		CompaniesRolesTypes objPadre = this.example.getObjPadre();
		if (objPadre != null) {
			predicatesList.add(builder.equal(root.get("objPadre"), objPadre));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<CompaniesRolesTypes> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back CompaniesRolesTypes entities (e.g. from
	 * inside an HtmlSelectOneMenu)
	 */

	public List<CompaniesRolesTypes> getAll() {

		CriteriaQuery<CompaniesRolesTypes> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(CompaniesRolesTypes.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(CompaniesRolesTypes.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final CompaniesRolesTypesBean ejbProxy = this.sessionContext
				.getBusinessObject(CompaniesRolesTypesBean.class);

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

				return String.valueOf(((CompaniesRolesTypes) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private CompaniesRolesTypes add = new CompaniesRolesTypes();

	public CompaniesRolesTypes getAdd() {
		return this.add;
	}

	public CompaniesRolesTypes getAdded() {
		CompaniesRolesTypes added = this.add;
		this.add = new CompaniesRolesTypes();
		return added;
	}
}
