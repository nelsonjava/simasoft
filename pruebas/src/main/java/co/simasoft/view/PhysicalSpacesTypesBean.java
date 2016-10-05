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

import co.simasoft.models.PhysicalSpacesTypes;
import co.simasoft.models.PhysicalSpaces;
import java.util.Iterator;

/**
 * Backing bean for PhysicalSpacesTypes entities.
 * <p/>
 * This class provides CRUD functionality for all PhysicalSpacesTypes entities.
 * It focuses purely on Java EE 6 standards (e.g.
 * <tt>&#64;ConversationScoped</tt> for state management,
 * <tt>PersistenceContext</tt> for persistence, <tt>CriteriaBuilder</tt> for
 * searches) rather than introducing a CRUD framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class PhysicalSpacesTypesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving PhysicalSpacesTypes entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private PhysicalSpacesTypes physicalSpacesTypes;

	public PhysicalSpacesTypes getPhysicalSpacesTypes() {
		return this.physicalSpacesTypes;
	}

	public void setPhysicalSpacesTypes(PhysicalSpacesTypes physicalSpacesTypes) {
		this.physicalSpacesTypes = physicalSpacesTypes;
	}

	@Inject
	private Conversation conversation;

	@PersistenceContext(unitName = "pruebasPU-JTA", type = PersistenceContextType.EXTENDED)
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
			this.physicalSpacesTypes = this.example;
		} else {
			this.physicalSpacesTypes = findById(getId());
		}
	}

	public PhysicalSpacesTypes findById(Long id) {

		return this.entityManager.find(PhysicalSpacesTypes.class, id);
	}

	/*
	 * Support updating and deleting PhysicalSpacesTypes entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.physicalSpacesTypes);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.physicalSpacesTypes);
				return "view?faces-redirect=true&id="
						+ this.physicalSpacesTypes.getId();
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
			PhysicalSpacesTypes deletableEntity = findById(getId());
			Iterator<PhysicalSpaces> iterPhysicalSpaces = deletableEntity
					.getPhysicalSpaces().iterator();
			for (; iterPhysicalSpaces.hasNext();) {
				PhysicalSpaces nextInPhysicalSpaces = iterPhysicalSpaces.next();
				nextInPhysicalSpaces.setPhysicalSpacesTypes(null);
				iterPhysicalSpaces.remove();
				this.entityManager.merge(nextInPhysicalSpaces);
			}
			Iterator<PhysicalSpacesTypes> iterObjHijos = deletableEntity
					.getObjHijos().iterator();
			for (; iterObjHijos.hasNext();) {
				PhysicalSpacesTypes nextInObjHijos = iterObjHijos.next();
				nextInObjHijos.setObjPadre(null);
				iterObjHijos.remove();
				this.entityManager.merge(nextInObjHijos);
			}
			PhysicalSpacesTypes objPadre = deletableEntity.getObjPadre();
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
	 * Support searching PhysicalSpacesTypes entities with pagination
	 */

	private int page;
	private long count;
	private List<PhysicalSpacesTypes> pageItems;

	private PhysicalSpacesTypes example = new PhysicalSpacesTypes();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 1000;
	}

	public PhysicalSpacesTypes getExample() {
		return this.example;
	}

	public void setExample(PhysicalSpacesTypes example) {
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
		Root<PhysicalSpacesTypes> root = countCriteria
				.from(PhysicalSpacesTypes.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<PhysicalSpacesTypes> criteria = builder
				.createQuery(PhysicalSpacesTypes.class);
		root = criteria.from(PhysicalSpacesTypes.class);
		TypedQuery<PhysicalSpacesTypes> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<PhysicalSpacesTypes> root) {

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
		PhysicalSpacesTypes objPadre = this.example.getObjPadre();
		if (objPadre != null) {
			predicatesList.add(builder.equal(root.get("objPadre"), objPadre));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<PhysicalSpacesTypes> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back PhysicalSpacesTypes entities (e.g. from
	 * inside an HtmlSelectOneMenu)
	 */

	public List<PhysicalSpacesTypes> getAll() {

		CriteriaQuery<PhysicalSpacesTypes> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(PhysicalSpacesTypes.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(PhysicalSpacesTypes.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final PhysicalSpacesTypesBean ejbProxy = this.sessionContext
				.getBusinessObject(PhysicalSpacesTypesBean.class);

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

				return String.valueOf(((PhysicalSpacesTypes) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private PhysicalSpacesTypes add = new PhysicalSpacesTypes();

	public PhysicalSpacesTypes getAdd() {
		return this.add;
	}

	public PhysicalSpacesTypes getAdded() {
		PhysicalSpacesTypes added = this.add;
		this.add = new PhysicalSpacesTypes();
		return added;
	}
}
