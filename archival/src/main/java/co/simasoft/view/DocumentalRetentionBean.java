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

import co.simasoft.models.DocumentalRetention;
import co.simasoft.models.Trd;
import java.util.Iterator;

/**
 * Backing bean for DocumentalRetention entities.
 * <p/>
 * This class provides CRUD functionality for all DocumentalRetention entities.
 * It focuses purely on Java EE 6 standards (e.g.
 * <tt>&#64;ConversationScoped</tt> for state management,
 * <tt>PersistenceContext</tt> for persistence, <tt>CriteriaBuilder</tt> for
 * searches) rather than introducing a CRUD framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class DocumentalRetentionBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving DocumentalRetention entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private DocumentalRetention documentalRetention;

	public DocumentalRetention getDocumentalRetention() {
		return this.documentalRetention;
	}

	public void setDocumentalRetention(DocumentalRetention documentalRetention) {
		this.documentalRetention = documentalRetention;
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
			this.documentalRetention = this.example;
		} else {
			this.documentalRetention = findById(getId());
		}
	}

	public DocumentalRetention findById(Long id) {

		return this.entityManager.find(DocumentalRetention.class, id);
	}

	/*
	 * Support updating and deleting DocumentalRetention entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.documentalRetention);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.documentalRetention);
				return "view?faces-redirect=true&id="
						+ this.documentalRetention.getId();
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
			DocumentalRetention deletableEntity = findById(getId());
			Iterator<Trd> iterGestion = deletableEntity.getGestion().iterator();
			for (; iterGestion.hasNext();) {
				Trd nextInGestion = iterGestion.next();
				nextInGestion.setGestion(null);
				iterGestion.remove();
				this.entityManager.merge(nextInGestion);
			}
			Iterator<Trd> iterCentral = deletableEntity.getCentral().iterator();
			for (; iterCentral.hasNext();) {
				Trd nextInCentral = iterCentral.next();
				nextInCentral.setCentral(null);
				iterCentral.remove();
				this.entityManager.merge(nextInCentral);
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
	 * Support searching DocumentalRetention entities with pagination
	 */

	private int page;
	private long count;
	private List<DocumentalRetention> pageItems;

	private DocumentalRetention example = new DocumentalRetention();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 1000;
	}

	public DocumentalRetention getExample() {
		return this.example;
	}

	public void setExample(DocumentalRetention example) {
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
		Root<DocumentalRetention> root = countCriteria
				.from(DocumentalRetention.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<DocumentalRetention> criteria = builder
				.createQuery(DocumentalRetention.class);
		root = criteria.from(DocumentalRetention.class);
		TypedQuery<DocumentalRetention> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<DocumentalRetention> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		String observations = this.example.getObservations();
		if (observations != null && !"".equals(observations)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("observations")),
					'%' + observations.toLowerCase() + '%'));
		}
		Integer year = this.example.getYear();
		if (year != null && year.intValue() != 0) {
			predicatesList.add(builder.equal(root.get("year"), year));
		}
		String name = this.example.getName();
		if (name != null && !"".equals(name)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("name")),
					'%' + name.toLowerCase() + '%'));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<DocumentalRetention> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back DocumentalRetention entities (e.g. from
	 * inside an HtmlSelectOneMenu)
	 */

	public List<DocumentalRetention> getAll() {

		CriteriaQuery<DocumentalRetention> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(DocumentalRetention.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(DocumentalRetention.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final DocumentalRetentionBean ejbProxy = this.sessionContext
				.getBusinessObject(DocumentalRetentionBean.class);

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

				return String.valueOf(((DocumentalRetention) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private DocumentalRetention add = new DocumentalRetention();

	public DocumentalRetention getAdd() {
		return this.add;
	}

	public DocumentalRetention getAdded() {
		DocumentalRetention added = this.add;
		this.add = new DocumentalRetention();
		return added;
	}
}
