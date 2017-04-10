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

import co.simasoft.models.TypesConstructionEquipments;
import co.simasoft.models.ConstructionEquipments;
import java.util.Iterator;

/**
 * Backing bean for TypesConstructionEquipments entities.
 * <p/>
 * This class provides CRUD functionality for all TypesConstructionEquipments
 * entities. It focuses purely on Java EE 6 standards (e.g.
 * <tt>&#64;ConversationScoped</tt> for state management,
 * <tt>PersistenceContext</tt> for persistence, <tt>CriteriaBuilder</tt> for
 * searches) rather than introducing a CRUD framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class TypesConstructionEquipmentsBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving TypesConstructionEquipments entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private TypesConstructionEquipments typesConstructionEquipments;

	public TypesConstructionEquipments getTypesConstructionEquipments() {
		return this.typesConstructionEquipments;
	}

	public void setTypesConstructionEquipments(
			TypesConstructionEquipments typesConstructionEquipments) {
		this.typesConstructionEquipments = typesConstructionEquipments;
	}

	@Inject
	private Conversation conversation;

	@PersistenceContext(unitName = "budgetsPU-JTA", type = PersistenceContextType.EXTENDED)
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
			this.typesConstructionEquipments = this.example;
		} else {
			this.typesConstructionEquipments = findById(getId());
		}
	}

	public TypesConstructionEquipments findById(Long id) {

		return this.entityManager.find(TypesConstructionEquipments.class, id);
	}

	/*
	 * Support updating and deleting TypesConstructionEquipments entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.typesConstructionEquipments);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.typesConstructionEquipments);
				return "view?faces-redirect=true&id="
						+ this.typesConstructionEquipments.getId();
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
			TypesConstructionEquipments deletableEntity = findById(getId());
			Iterator<ConstructionEquipments> iterConstructionEquipments = deletableEntity
					.getConstructionEquipments().iterator();
			for (; iterConstructionEquipments.hasNext();) {
				ConstructionEquipments nextInConstructionEquipments = iterConstructionEquipments
						.next();
				nextInConstructionEquipments
						.setTypesConstructionEquipments(null);
				iterConstructionEquipments.remove();
				this.entityManager.merge(nextInConstructionEquipments);
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
	 * Support searching TypesConstructionEquipments entities with pagination
	 */

	private int page;
	private long count;
	private List<TypesConstructionEquipments> pageItems;

	private TypesConstructionEquipments example = new TypesConstructionEquipments();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public TypesConstructionEquipments getExample() {
		return this.example;
	}

	public void setExample(TypesConstructionEquipments example) {
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
		Root<TypesConstructionEquipments> root = countCriteria
				.from(TypesConstructionEquipments.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<TypesConstructionEquipments> criteria = builder
				.createQuery(TypesConstructionEquipments.class);
		root = criteria.from(TypesConstructionEquipments.class);
		TypedQuery<TypesConstructionEquipments> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(
			Root<TypesConstructionEquipments> root) {

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

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<TypesConstructionEquipments> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back TypesConstructionEquipments entities
	 * (e.g. from inside an HtmlSelectOneMenu)
	 */

	public List<TypesConstructionEquipments> getAll() {

		CriteriaQuery<TypesConstructionEquipments> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(
						TypesConstructionEquipments.class);
		return this.entityManager.createQuery(
				criteria.select(criteria
						.from(TypesConstructionEquipments.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final TypesConstructionEquipmentsBean ejbProxy = this.sessionContext
				.getBusinessObject(TypesConstructionEquipmentsBean.class);

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

				return String.valueOf(((TypesConstructionEquipments) value)
						.getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private TypesConstructionEquipments add = new TypesConstructionEquipments();

	public TypesConstructionEquipments getAdd() {
		return this.add;
	}

	public TypesConstructionEquipments getAdded() {
		TypesConstructionEquipments added = this.add;
		this.add = new TypesConstructionEquipments();
		return added;
	}
}
