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

import co.simasoft.models.ContinualImprovements;
import co.simasoft.models.ActionPlans;
import co.simasoft.models.DocumentalsUnits;
import co.simasoft.models.ImprovementClosures;
import co.simasoft.models.ImprovementSources;
import co.simasoft.models.ImprovementTypes;
import co.simasoft.models.ImprovementVerifications;
import co.simasoft.models.OriginalOrders;
import java.util.Iterator;

/**
 * Backing bean for ContinualImprovements entities.
 * <p/>
 * This class provides CRUD functionality for all ContinualImprovements
 * entities. It focuses purely on Java EE 6 standards (e.g.
 * <tt>&#64;ConversationScoped</tt> for state management,
 * <tt>PersistenceContext</tt> for persistence, <tt>CriteriaBuilder</tt> for
 * searches) rather than introducing a CRUD framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class ContinualImprovementsBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving ContinualImprovements entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private ContinualImprovements continualImprovements;

	public ContinualImprovements getContinualImprovements() {
		return this.continualImprovements;
	}

	public void setContinualImprovements(
			ContinualImprovements continualImprovements) {
		this.continualImprovements = continualImprovements;
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
			this.continualImprovements = this.example;
		} else {
			this.continualImprovements = findById(getId());
		}
	}

	public ContinualImprovements findById(Long id) {

		return this.entityManager.find(ContinualImprovements.class, id);
	}

	/*
	 * Support updating and deleting ContinualImprovements entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.continualImprovements);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.continualImprovements);
				return "view?faces-redirect=true&id="
						+ this.continualImprovements.getId();
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
			ContinualImprovements deletableEntity = findById(getId());
			Iterator<OriginalOrders> iterOriginalOrders = deletableEntity
					.getOriginalOrders().iterator();
			for (; iterOriginalOrders.hasNext();) {
				OriginalOrders nextInOriginalOrders = iterOriginalOrders.next();
				nextInOriginalOrders.setContinualImprovements(null);
				iterOriginalOrders.remove();
				this.entityManager.merge(nextInOriginalOrders);
			}
			Iterator<ActionPlans> iterActionPlans = deletableEntity
					.getActionPlans().iterator();
			for (; iterActionPlans.hasNext();) {
				ActionPlans nextInActionPlans = iterActionPlans.next();
				nextInActionPlans.setContinualImprovements(null);
				iterActionPlans.remove();
				this.entityManager.merge(nextInActionPlans);
			}
			DocumentalsUnits documentalsUnits = deletableEntity
					.getDocumentalsUnits();
			documentalsUnits.getContinualImprovements().remove(deletableEntity);
			deletableEntity.setDocumentalsUnits(null);
			this.entityManager.merge(documentalsUnits);
			ImprovementClosures improvementClosures = deletableEntity
					.getImprovementClosures();
			improvementClosures.getContinualImprovements().remove(
					deletableEntity);
			deletableEntity.setImprovementClosures(null);
			this.entityManager.merge(improvementClosures);
			ImprovementTypes improvementTypes = deletableEntity
					.getImprovementTypes();
			improvementTypes.getContinualImprovements().remove(deletableEntity);
			deletableEntity.setImprovementTypes(null);
			this.entityManager.merge(improvementTypes);
			ImprovementSources improvementSources = deletableEntity
					.getImprovementSources();
			improvementSources.getContinualImprovements().remove(
					deletableEntity);
			deletableEntity.setImprovementSources(null);
			this.entityManager.merge(improvementSources);
			ImprovementVerifications improvementVerifications = deletableEntity
					.getImprovementVerifications();
			improvementVerifications.getContinualImprovements().remove(
					deletableEntity);
			deletableEntity.setImprovementVerifications(null);
			this.entityManager.merge(improvementVerifications);
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
	 * Support searching ContinualImprovements entities with pagination
	 */

	private int page;
	private long count;
	private List<ContinualImprovements> pageItems;

	private ContinualImprovements example = new ContinualImprovements();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public ContinualImprovements getExample() {
		return this.example;
	}

	public void setExample(ContinualImprovements example) {
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
		Root<ContinualImprovements> root = countCriteria
				.from(ContinualImprovements.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<ContinualImprovements> criteria = builder
				.createQuery(ContinualImprovements.class);
		root = criteria.from(ContinualImprovements.class);
		TypedQuery<ContinualImprovements> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<ContinualImprovements> root) {

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
		String description = this.example.getDescription();
		if (description != null && !"".equals(description)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("description")),
					'%' + description.toLowerCase() + '%'));
		}
		String causesAnalysis = this.example.getCausesAnalysis();
		if (causesAnalysis != null && !"".equals(causesAnalysis)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("causesAnalysis")),
					'%' + causesAnalysis.toLowerCase() + '%'));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<ContinualImprovements> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back ContinualImprovements entities (e.g.
	 * from inside an HtmlSelectOneMenu)
	 */

	public List<ContinualImprovements> getAll() {

		CriteriaQuery<ContinualImprovements> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(ContinualImprovements.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(ContinualImprovements.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final ContinualImprovementsBean ejbProxy = this.sessionContext
				.getBusinessObject(ContinualImprovementsBean.class);

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

				return String.valueOf(((ContinualImprovements) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private ContinualImprovements add = new ContinualImprovements();

	public ContinualImprovements getAdd() {
		return this.add;
	}

	public ContinualImprovements getAdded() {
		ContinualImprovements added = this.add;
		this.add = new ContinualImprovements();
		return added;
	}
}
