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

import co.simasoft.models.TypesMeasurementUnits;
import co.simasoft.models.MeasurementUnits;
import java.util.Iterator;

/**
 * Backing bean for TypesMeasurementUnits entities.
 * <p/>
 * This class provides CRUD functionality for all TypesMeasurementUnits
 * entities. It focuses purely on Java EE 6 standards (e.g.
 * <tt>&#64;ConversationScoped</tt> for state management,
 * <tt>PersistenceContext</tt> for persistence, <tt>CriteriaBuilder</tt> for
 * searches) rather than introducing a CRUD framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class TypesMeasurementUnitsBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving TypesMeasurementUnits entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private TypesMeasurementUnits typesMeasurementUnits;

	public TypesMeasurementUnits getTypesMeasurementUnits() {
		return this.typesMeasurementUnits;
	}

	public void setTypesMeasurementUnits(
			TypesMeasurementUnits typesMeasurementUnits) {
		this.typesMeasurementUnits = typesMeasurementUnits;
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
			this.typesMeasurementUnits = this.example;
		} else {
			this.typesMeasurementUnits = findById(getId());
		}
	}

	public TypesMeasurementUnits findById(Long id) {

		return this.entityManager.find(TypesMeasurementUnits.class, id);
	}

	/*
	 * Support updating and deleting TypesMeasurementUnits entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.typesMeasurementUnits);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.typesMeasurementUnits);
				return "view?faces-redirect=true&id="
						+ this.typesMeasurementUnits.getId();
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
			TypesMeasurementUnits deletableEntity = findById(getId());
			Iterator<MeasurementUnits> iterMeasurementUnits = deletableEntity
					.getMeasurementUnits().iterator();
			for (; iterMeasurementUnits.hasNext();) {
				MeasurementUnits nextInMeasurementUnits = iterMeasurementUnits
						.next();
				nextInMeasurementUnits.setTypesMeasurementUnits(null);
				iterMeasurementUnits.remove();
				this.entityManager.merge(nextInMeasurementUnits);
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
	 * Support searching TypesMeasurementUnits entities with pagination
	 */

	private int page;
	private long count;
	private List<TypesMeasurementUnits> pageItems;

	private TypesMeasurementUnits example = new TypesMeasurementUnits();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public TypesMeasurementUnits getExample() {
		return this.example;
	}

	public void setExample(TypesMeasurementUnits example) {
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
		Root<TypesMeasurementUnits> root = countCriteria
				.from(TypesMeasurementUnits.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<TypesMeasurementUnits> criteria = builder
				.createQuery(TypesMeasurementUnits.class);
		root = criteria.from(TypesMeasurementUnits.class);
		TypedQuery<TypesMeasurementUnits> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<TypesMeasurementUnits> root) {

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

	public List<TypesMeasurementUnits> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back TypesMeasurementUnits entities (e.g.
	 * from inside an HtmlSelectOneMenu)
	 */

	public List<TypesMeasurementUnits> getAll() {

		CriteriaQuery<TypesMeasurementUnits> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(TypesMeasurementUnits.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(TypesMeasurementUnits.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final TypesMeasurementUnitsBean ejbProxy = this.sessionContext
				.getBusinessObject(TypesMeasurementUnitsBean.class);

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

				return String.valueOf(((TypesMeasurementUnits) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private TypesMeasurementUnits add = new TypesMeasurementUnits();

	public TypesMeasurementUnits getAdd() {
		return this.add;
	}

	public TypesMeasurementUnits getAdded() {
		TypesMeasurementUnits added = this.add;
		this.add = new TypesMeasurementUnits();
		return added;
	}
}
