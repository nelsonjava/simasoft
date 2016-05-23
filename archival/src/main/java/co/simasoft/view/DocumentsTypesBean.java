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

import co.simasoft.models.DocumentsTypes;
import co.simasoft.models.OriginalOrder;
import co.simasoft.models.Series;
import java.util.Iterator;

/**
 * Backing bean for DocumentsTypes entities.
 * <p/>
 * This class provides CRUD functionality for all DocumentsTypes entities. It
 * focuses purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt>
 * for state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class DocumentsTypesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving DocumentsTypes entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private DocumentsTypes documentsTypes;

	public DocumentsTypes getDocumentsTypes() {
		return this.documentsTypes;
	}

	public void setDocumentsTypes(DocumentsTypes documentsTypes) {
		this.documentsTypes = documentsTypes;
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
			this.documentsTypes = this.example;
		} else {
			this.documentsTypes = findById(getId());
		}
	}

	public DocumentsTypes findById(Long id) {

		return this.entityManager.find(DocumentsTypes.class, id);
	}

	/*
	 * Support updating and deleting DocumentsTypes entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.documentsTypes);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.documentsTypes);
				return "view?faces-redirect=true&id="
						+ this.documentsTypes.getId();
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
			DocumentsTypes deletableEntity = findById(getId());
			Iterator<OriginalOrder> iterOriginalOrder = deletableEntity
					.getOriginalOrder().iterator();
			for (; iterOriginalOrder.hasNext();) {
				OriginalOrder nextInOriginalOrder = iterOriginalOrder.next();
				nextInOriginalOrder.setDocumentsTypes(null);
				iterOriginalOrder.remove();
				this.entityManager.merge(nextInOriginalOrder);
			}
			Iterator<Series> iterSeries = deletableEntity.getSeries()
					.iterator();
			for (; iterSeries.hasNext();) {
				Series nextInSeries = iterSeries.next();
				nextInSeries.setDocumentsTypes(null);
				iterSeries.remove();
				this.entityManager.merge(nextInSeries);
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
	 * Support searching DocumentsTypes entities with pagination
	 */

	private int page;
	private long count;
	private List<DocumentsTypes> pageItems;

	private DocumentsTypes example = new DocumentsTypes();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 1000;
	}

	public DocumentsTypes getExample() {
		return this.example;
	}

	public void setExample(DocumentsTypes example) {
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
		Root<DocumentsTypes> root = countCriteria.from(DocumentsTypes.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<DocumentsTypes> criteria = builder
				.createQuery(DocumentsTypes.class);
		root = criteria.from(DocumentsTypes.class);
		TypedQuery<DocumentsTypes> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<DocumentsTypes> root) {

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

	public List<DocumentsTypes> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back DocumentsTypes entities (e.g. from
	 * inside an HtmlSelectOneMenu)
	 */

	public List<DocumentsTypes> getAll() {

		CriteriaQuery<DocumentsTypes> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(DocumentsTypes.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(DocumentsTypes.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final DocumentsTypesBean ejbProxy = this.sessionContext
				.getBusinessObject(DocumentsTypesBean.class);

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

				return String.valueOf(((DocumentsTypes) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private DocumentsTypes add = new DocumentsTypes();

	public DocumentsTypes getAdd() {
		return this.add;
	}

	public DocumentsTypes getAdded() {
		DocumentsTypes added = this.add;
		this.add = new DocumentsTypes();
		return added;
	}
}
