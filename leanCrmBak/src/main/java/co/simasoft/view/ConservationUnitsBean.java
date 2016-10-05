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

import co.simasoft.models.ConservationUnits;
import co.simasoft.models.ConservationUnitsTypes;
import co.simasoft.models.OriginalOrders;
import java.util.Iterator;

/**
 * Backing bean for ConservationUnits entities.
 * <p/>
 * This class provides CRUD functionality for all ConservationUnits entities. It
 * focuses purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt>
 * for state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class ConservationUnitsBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving ConservationUnits entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private ConservationUnits conservationUnits;

	public ConservationUnits getConservationUnits() {
		return this.conservationUnits;
	}

	public void setConservationUnits(ConservationUnits conservationUnits) {
		this.conservationUnits = conservationUnits;
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
			this.conservationUnits = this.example;
		} else {
			this.conservationUnits = findById(getId());
		}
	}

	public ConservationUnits findById(Long id) {

		return this.entityManager.find(ConservationUnits.class, id);
	}

	/*
	 * Support updating and deleting ConservationUnits entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.conservationUnits);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.conservationUnits);
				return "view?faces-redirect=true&id="
						+ this.conservationUnits.getId();
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
			ConservationUnits deletableEntity = findById(getId());
			Iterator<OriginalOrders> iterOriginalOrders = deletableEntity
					.getOriginalOrders().iterator();
			for (; iterOriginalOrders.hasNext();) {
				OriginalOrders nextInOriginalOrders = iterOriginalOrders.next();
				nextInOriginalOrders.setConservationUnits(null);
				iterOriginalOrders.remove();
				this.entityManager.merge(nextInOriginalOrders);
			}
			ConservationUnitsTypes conservationUnitsTypes = deletableEntity
					.getConservationUnitsTypes();
			conservationUnitsTypes.getConservationUnits().remove(
					deletableEntity);
			deletableEntity.setConservationUnitsTypes(null);
			this.entityManager.merge(conservationUnitsTypes);
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
	 * Support searching ConservationUnits entities with pagination
	 */

	private int page;
	private long count;
	private List<ConservationUnits> pageItems;

	private ConservationUnits example = new ConservationUnits();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 1000;
	}

	public ConservationUnits getExample() {
		return this.example;
	}

	public void setExample(ConservationUnits example) {
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
		Root<ConservationUnits> root = countCriteria
				.from(ConservationUnits.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<ConservationUnits> criteria = builder
				.createQuery(ConservationUnits.class);
		root = criteria.from(ConservationUnits.class);
		TypedQuery<ConservationUnits> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<ConservationUnits> root) {

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
		String code = this.example.getCode();
		if (code != null && !"".equals(code)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("code")),
					'%' + code.toLowerCase() + '%'));
		}
		ConservationUnitsTypes conservationUnitsTypes = this.example
				.getConservationUnitsTypes();
		if (conservationUnitsTypes != null) {
			predicatesList
					.add(builder.equal(root.get("conservationUnitsTypes"),
							conservationUnitsTypes));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<ConservationUnits> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back ConservationUnits entities (e.g. from
	 * inside an HtmlSelectOneMenu)
	 */

	public List<ConservationUnits> getAll() {

		CriteriaQuery<ConservationUnits> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(ConservationUnits.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(ConservationUnits.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final ConservationUnitsBean ejbProxy = this.sessionContext
				.getBusinessObject(ConservationUnitsBean.class);

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

				return String.valueOf(((ConservationUnits) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private ConservationUnits add = new ConservationUnits();

	public ConservationUnits getAdd() {
		return this.add;
	}

	public ConservationUnits getAdded() {
		ConservationUnits added = this.add;
		this.add = new ConservationUnits();
		return added;
	}
}
