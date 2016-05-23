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

import co.simasoft.models.OriginalOrder;
import co.simasoft.models.DocumentalsSupports;
import co.simasoft.models.DocumentalsUnits;
import co.simasoft.models.DocumentsTypes;

/**
 * Backing bean for OriginalOrder entities.
 * <p/>
 * This class provides CRUD functionality for all OriginalOrder entities. It
 * focuses purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt>
 * for state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class OriginalOrderBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving OriginalOrder entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private OriginalOrder originalOrder;

	public OriginalOrder getOriginalOrder() {
		return this.originalOrder;
	}

	public void setOriginalOrder(OriginalOrder originalOrder) {
		this.originalOrder = originalOrder;
	}

	@Inject
	private Conversation conversation;

	@PersistenceContext(unitName = "archivalPU-JTA", type = PersistenceContextType.EXTENDED)
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
			this.originalOrder = this.example;
		} else {
			this.originalOrder = findById(getId());
		}
	}

	public OriginalOrder findById(Long id) {

		return this.entityManager.find(OriginalOrder.class, id);
	}

	/*
	 * Support updating and deleting OriginalOrder entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.originalOrder);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.originalOrder);
				return "view?faces-redirect=true&id="
						+ this.originalOrder.getId();
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
			OriginalOrder deletableEntity = findById(getId());
			DocumentalsSupports documentalsSupports = deletableEntity
					.getDocumentalsSupports();
			documentalsSupports.getOriginalOrder().remove(deletableEntity);
			deletableEntity.setDocumentalsSupports(null);
			this.entityManager.merge(documentalsSupports);
			DocumentsTypes documentsTypes = deletableEntity.getDocumentsTypes();
			documentsTypes.getOriginalOrder().remove(deletableEntity);
			deletableEntity.setDocumentsTypes(null);
			this.entityManager.merge(documentsTypes);
			DocumentalsUnits documentalsUnits = deletableEntity
					.getDocumentalsUnits();
			documentalsUnits.getOriginalOrder().remove(deletableEntity);
			deletableEntity.setDocumentalsUnits(null);
			this.entityManager.merge(documentalsUnits);
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
	 * Support searching OriginalOrder entities with pagination
	 */

	private int page;
	private long count;
	private List<OriginalOrder> pageItems;

	private OriginalOrder example = new OriginalOrder();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 1000;
	}

	public OriginalOrder getExample() {
		return this.example;
	}

	public void setExample(OriginalOrder example) {
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
		Root<OriginalOrder> root = countCriteria.from(OriginalOrder.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<OriginalOrder> criteria = builder
				.createQuery(OriginalOrder.class);
		root = criteria.from(OriginalOrder.class);
		TypedQuery<OriginalOrder> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<OriginalOrder> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		String observations = this.example.getObservations();
		if (observations != null && !"".equals(observations)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("observations")),
					'%' + observations.toLowerCase() + '%'));
		}
		Integer folios = this.example.getFolios();
		if (folios != null && folios.intValue() != 0) {
			predicatesList.add(builder.equal(root.get("folios"), folios));
		}
		String located = this.example.getLocated();
		if (located != null && !"".equals(located)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("located")),
					'%' + located.toLowerCase() + '%'));
		}
		DocumentalsSupports documentalsSupports = this.example
				.getDocumentalsSupports();
		if (documentalsSupports != null) {
			predicatesList.add(builder.equal(root.get("documentalsSupports"),
					documentalsSupports));
		}
		DocumentsTypes documentsTypes = this.example.getDocumentsTypes();
		if (documentsTypes != null) {
			predicatesList.add(builder.equal(root.get("documentsTypes"),
					documentsTypes));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<OriginalOrder> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back OriginalOrder entities (e.g. from inside
	 * an HtmlSelectOneMenu)
	 */

	public List<OriginalOrder> getAll() {

		CriteriaQuery<OriginalOrder> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(OriginalOrder.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(OriginalOrder.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final OriginalOrderBean ejbProxy = this.sessionContext
				.getBusinessObject(OriginalOrderBean.class);

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

				return String.valueOf(((OriginalOrder) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private OriginalOrder add = new OriginalOrder();

	public OriginalOrder getAdd() {
		return this.add;
	}

	public OriginalOrder getAdded() {
		OriginalOrder added = this.add;
		this.add = new OriginalOrder();
		return added;
	}
}
