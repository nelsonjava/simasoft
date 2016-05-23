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

import co.simasoft.models.DocumentalsUnits;
import co.simasoft.models.ConservationUnits;
import co.simasoft.models.DocumentalInventory;
import co.simasoft.models.FrequentlyQuery;
import co.simasoft.models.OriginalOrder;
import co.simasoft.models.Series;
import java.util.Iterator;

/**
 * Backing bean for DocumentalsUnits entities.
 * <p/>
 * This class provides CRUD functionality for all DocumentalsUnits entities. It
 * focuses purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt>
 * for state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class DocumentalsUnitsBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving DocumentalsUnits entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private DocumentalsUnits documentalsUnits;

	public DocumentalsUnits getDocumentalsUnits() {
		return this.documentalsUnits;
	}

	public void setDocumentalsUnits(DocumentalsUnits documentalsUnits) {
		this.documentalsUnits = documentalsUnits;
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
			this.documentalsUnits = this.example;
		} else {
			this.documentalsUnits = findById(getId());
		}
	}

	public DocumentalsUnits findById(Long id) {

		return this.entityManager.find(DocumentalsUnits.class, id);
	}

	/*
	 * Support updating and deleting DocumentalsUnits entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.documentalsUnits);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.documentalsUnits);
				return "view?faces-redirect=true&id="
						+ this.documentalsUnits.getId();
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
			DocumentalsUnits deletableEntity = findById(getId());
			Iterator<DocumentalInventory> iterDocumentalInventory = deletableEntity
					.getDocumentalInventory().iterator();
			for (; iterDocumentalInventory.hasNext();) {
				DocumentalInventory nextInDocumentalInventory = iterDocumentalInventory
						.next();
				nextInDocumentalInventory.setDocumentalsUnits(null);
				iterDocumentalInventory.remove();
				this.entityManager.merge(nextInDocumentalInventory);
			}
			Iterator<OriginalOrder> iterOriginalOrder = deletableEntity
					.getOriginalOrder().iterator();
			for (; iterOriginalOrder.hasNext();) {
				OriginalOrder nextInOriginalOrder = iterOriginalOrder.next();
				nextInOriginalOrder.setDocumentalsUnits(null);
				iterOriginalOrder.remove();
				this.entityManager.merge(nextInOriginalOrder);
			}
			ConservationUnits conservationUnits = deletableEntity
					.getConservationUnits();
			conservationUnits.getDocumentalsUnits().remove(deletableEntity);
			deletableEntity.setConservationUnits(null);
			this.entityManager.merge(conservationUnits);
			FrequentlyQuery frequentlyQuery = deletableEntity
					.getFrequentlyQuery();
			frequentlyQuery.getDocumentalsUnits().remove(deletableEntity);
			deletableEntity.setFrequentlyQuery(null);
			this.entityManager.merge(frequentlyQuery);
			Series series = deletableEntity.getSeries();
			series.getDocumentalsUnits().remove(deletableEntity);
			deletableEntity.setSeries(null);
			this.entityManager.merge(series);
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
	 * Support searching DocumentalsUnits entities with pagination
	 */

	private int page;
	private long count;
	private List<DocumentalsUnits> pageItems;

	private DocumentalsUnits example = new DocumentalsUnits();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 1000;
	}

	public DocumentalsUnits getExample() {
		return this.example;
	}

	public void setExample(DocumentalsUnits example) {
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
		Root<DocumentalsUnits> root = countCriteria
				.from(DocumentalsUnits.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<DocumentalsUnits> criteria = builder
				.createQuery(DocumentalsUnits.class);
		root = criteria.from(DocumentalsUnits.class);
		TypedQuery<DocumentalsUnits> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<DocumentalsUnits> root) {

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
		ConservationUnits conservationUnits = this.example
				.getConservationUnits();
		if (conservationUnits != null) {
			predicatesList.add(builder.equal(root.get("conservationUnits"),
					conservationUnits));
		}
		FrequentlyQuery frequentlyQuery = this.example.getFrequentlyQuery();
		if (frequentlyQuery != null) {
			predicatesList.add(builder.equal(root.get("frequentlyQuery"),
					frequentlyQuery));
		}
		Series series = this.example.getSeries();
		if (series != null) {
			predicatesList.add(builder.equal(root.get("series"), series));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<DocumentalsUnits> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back DocumentalsUnits entities (e.g. from
	 * inside an HtmlSelectOneMenu)
	 */

	public List<DocumentalsUnits> getAll() {

		CriteriaQuery<DocumentalsUnits> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(DocumentalsUnits.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(DocumentalsUnits.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final DocumentalsUnitsBean ejbProxy = this.sessionContext
				.getBusinessObject(DocumentalsUnitsBean.class);

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

				return String.valueOf(((DocumentalsUnits) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private DocumentalsUnits add = new DocumentalsUnits();

	public DocumentalsUnits getAdd() {
		return this.add;
	}

	public DocumentalsUnits getAdded() {
		DocumentalsUnits added = this.add;
		this.add = new DocumentalsUnits();
		return added;
	}
}
