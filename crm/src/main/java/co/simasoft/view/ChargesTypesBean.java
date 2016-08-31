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

import co.simasoft.models.ChargesTypes;
import co.simasoft.models.Charges;
import java.util.Iterator;

/**
 * Backing bean for ChargesTypes entities.
 * <p/>
 * This class provides CRUD functionality for all ChargesTypes entities. It
 * focuses purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt>
 * for state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class ChargesTypesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving ChargesTypes entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private ChargesTypes chargesTypes;

	public ChargesTypes getChargesTypes() {
		return this.chargesTypes;
	}

	public void setChargesTypes(ChargesTypes chargesTypes) {
		this.chargesTypes = chargesTypes;
	}

	@Inject
	private Conversation conversation;

	@PersistenceContext(unitName = "crmPU-JTA", type = PersistenceContextType.EXTENDED)
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
			this.chargesTypes = this.example;
		} else {
			this.chargesTypes = findById(getId());
		}
	}

	public ChargesTypes findById(Long id) {

		return this.entityManager.find(ChargesTypes.class, id);
	}

	/*
	 * Support updating and deleting ChargesTypes entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.chargesTypes);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.chargesTypes);
				return "view?faces-redirect=true&id="
						+ this.chargesTypes.getId();
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
			ChargesTypes deletableEntity = findById(getId());
			Iterator<Charges> iterCharges = deletableEntity.getCharges()
					.iterator();
			for (; iterCharges.hasNext();) {
				Charges nextInCharges = iterCharges.next();
				nextInCharges.setChargesTypes(null);
				iterCharges.remove();
				this.entityManager.merge(nextInCharges);
			}
			Iterator<ChargesTypes> iterObjHijos = deletableEntity.getObjHijos()
					.iterator();
			for (; iterObjHijos.hasNext();) {
				ChargesTypes nextInObjHijos = iterObjHijos.next();
				nextInObjHijos.setObjPadre(null);
				iterObjHijos.remove();
				this.entityManager.merge(nextInObjHijos);
			}
			ChargesTypes objPadre = deletableEntity.getObjPadre();
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
	 * Support searching ChargesTypes entities with pagination
	 */

	private int page;
	private long count;
	private List<ChargesTypes> pageItems;

	private ChargesTypes example = new ChargesTypes();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public ChargesTypes getExample() {
		return this.example;
	}

	public void setExample(ChargesTypes example) {
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
		Root<ChargesTypes> root = countCriteria.from(ChargesTypes.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<ChargesTypes> criteria = builder
				.createQuery(ChargesTypes.class);
		root = criteria.from(ChargesTypes.class);
		TypedQuery<ChargesTypes> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<ChargesTypes> root) {

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
		ChargesTypes objPadre = this.example.getObjPadre();
		if (objPadre != null) {
			predicatesList.add(builder.equal(root.get("objPadre"), objPadre));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<ChargesTypes> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back ChargesTypes entities (e.g. from inside
	 * an HtmlSelectOneMenu)
	 */

	public List<ChargesTypes> getAll() {

		CriteriaQuery<ChargesTypes> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(ChargesTypes.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(ChargesTypes.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final ChargesTypesBean ejbProxy = this.sessionContext
				.getBusinessObject(ChargesTypesBean.class);

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

				return String.valueOf(((ChargesTypes) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private ChargesTypes add = new ChargesTypes();

	public ChargesTypes getAdd() {
		return this.add;
	}

	public ChargesTypes getAdded() {
		ChargesTypes added = this.add;
		this.add = new ChargesTypes();
		return added;
	}
}
