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

import co.simasoft.models.LegisTypes;
import co.simasoft.models.Legis;
import java.util.Iterator;

/**
 * Backing bean for LegisTypes entities.
 * <p/>
 * This class provides CRUD functionality for all LegisTypes entities. It
 * focuses purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt>
 * for state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class LegisTypesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving LegisTypes entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private LegisTypes legisTypes;

	public LegisTypes getLegisTypes() {
		return this.legisTypes;
	}

	public void setLegisTypes(LegisTypes legisTypes) {
		this.legisTypes = legisTypes;
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
			this.legisTypes = this.example;
		} else {
			this.legisTypes = findById(getId());
		}
	}

	public LegisTypes findById(Long id) {

		return this.entityManager.find(LegisTypes.class, id);
	}

	/*
	 * Support updating and deleting LegisTypes entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.legisTypes);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.legisTypes);
				return "view?faces-redirect=true&id=" + this.legisTypes.getId();
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
			LegisTypes deletableEntity = findById(getId());
			Iterator<Legis> iterLegis = deletableEntity.getLegis().iterator();
			for (; iterLegis.hasNext();) {
				Legis nextInLegis = iterLegis.next();
				nextInLegis.setLegisTypes(null);
				iterLegis.remove();
				this.entityManager.merge(nextInLegis);
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
	 * Support searching LegisTypes entities with pagination
	 */

	private int page;
	private long count;
	private List<LegisTypes> pageItems;

	private LegisTypes example = new LegisTypes();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 1000;
	}

	public LegisTypes getExample() {
		return this.example;
	}

	public void setExample(LegisTypes example) {
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
		Root<LegisTypes> root = countCriteria.from(LegisTypes.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<LegisTypes> criteria = builder
				.createQuery(LegisTypes.class);
		root = criteria.from(LegisTypes.class);
		TypedQuery<LegisTypes> query = this.entityManager.createQuery(criteria
				.select(root).where(getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<LegisTypes> root) {

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

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<LegisTypes> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back LegisTypes entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<LegisTypes> getAll() {

		CriteriaQuery<LegisTypes> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(LegisTypes.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(LegisTypes.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final LegisTypesBean ejbProxy = this.sessionContext
				.getBusinessObject(LegisTypesBean.class);

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

				return String.valueOf(((LegisTypes) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private LegisTypes add = new LegisTypes();

	public LegisTypes getAdd() {
		return this.add;
	}

	public LegisTypes getAdded() {
		LegisTypes added = this.add;
		this.add = new LegisTypes();
		return added;
	}
}