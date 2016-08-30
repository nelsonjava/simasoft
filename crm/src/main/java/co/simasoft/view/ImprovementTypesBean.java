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

import co.simasoft.models.ImprovementTypes;
import co.simasoft.models.ContinualImprovements;
import java.util.Iterator;

/**
 * Backing bean for ImprovementTypes entities.
 * <p/>
 * This class provides CRUD functionality for all ImprovementTypes entities. It
 * focuses purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt>
 * for state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class ImprovementTypesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving ImprovementTypes entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private ImprovementTypes improvementTypes;

	public ImprovementTypes getImprovementTypes() {
		return this.improvementTypes;
	}

	public void setImprovementTypes(ImprovementTypes improvementTypes) {
		this.improvementTypes = improvementTypes;
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
			this.improvementTypes = this.example;
		} else {
			this.improvementTypes = findById(getId());
		}
	}

	public ImprovementTypes findById(Long id) {

		return this.entityManager.find(ImprovementTypes.class, id);
	}

	/*
	 * Support updating and deleting ImprovementTypes entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.improvementTypes);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.improvementTypes);
				return "view?faces-redirect=true&id="
						+ this.improvementTypes.getId();
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
			ImprovementTypes deletableEntity = findById(getId());
			Iterator<ContinualImprovements> iterContinualImprovements = deletableEntity
					.getContinualImprovements().iterator();
			for (; iterContinualImprovements.hasNext();) {
				ContinualImprovements nextInContinualImprovements = iterContinualImprovements
						.next();
				nextInContinualImprovements.setImprovementTypes(null);
				iterContinualImprovements.remove();
				this.entityManager.merge(nextInContinualImprovements);
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
	 * Support searching ImprovementTypes entities with pagination
	 */

	private int page;
	private long count;
	private List<ImprovementTypes> pageItems;

	private ImprovementTypes example = new ImprovementTypes();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public ImprovementTypes getExample() {
		return this.example;
	}

	public void setExample(ImprovementTypes example) {
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
		Root<ImprovementTypes> root = countCriteria
				.from(ImprovementTypes.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<ImprovementTypes> criteria = builder
				.createQuery(ImprovementTypes.class);
		root = criteria.from(ImprovementTypes.class);
		TypedQuery<ImprovementTypes> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<ImprovementTypes> root) {

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

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<ImprovementTypes> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back ImprovementTypes entities (e.g. from
	 * inside an HtmlSelectOneMenu)
	 */

	public List<ImprovementTypes> getAll() {

		CriteriaQuery<ImprovementTypes> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(ImprovementTypes.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(ImprovementTypes.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final ImprovementTypesBean ejbProxy = this.sessionContext
				.getBusinessObject(ImprovementTypesBean.class);

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

				return String.valueOf(((ImprovementTypes) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private ImprovementTypes add = new ImprovementTypes();

	public ImprovementTypes getAdd() {
		return this.add;
	}

	public ImprovementTypes getAdded() {
		ImprovementTypes added = this.add;
		this.add = new ImprovementTypes();
		return added;
	}
}
