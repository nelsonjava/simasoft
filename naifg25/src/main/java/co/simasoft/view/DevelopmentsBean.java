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

import co.simasoft.models.Developments;
import co.simasoft.models.DevelopmentsModels;
import java.util.Iterator;

/**
 * Backing bean for Developments entities.
 * <p/>
 * This class provides CRUD functionality for all Developments entities. It
 * focuses purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt>
 * for state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class DevelopmentsBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving Developments entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Developments developments;

	public Developments getDevelopments() {
		return this.developments;
	}

	public void setDevelopments(Developments developments) {
		this.developments = developments;
	}

	@Inject
	private Conversation conversation;

	@PersistenceContext(unitName = "naifg25PU-JTA", type = PersistenceContextType.EXTENDED)
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
			this.developments = this.example;
		} else {
			this.developments = findById(getId());
		}
	}

	public Developments findById(Long id) {

		return this.entityManager.find(Developments.class, id);
	}

	/*
	 * Support updating and deleting Developments entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.developments);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.developments);
				return "view?faces-redirect=true&id="
						+ this.developments.getId();
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
			Developments deletableEntity = findById(getId());
			Iterator<DevelopmentsModels> iterDevelopmentsModels = deletableEntity
					.getDevelopmentsModels().iterator();
			for (; iterDevelopmentsModels.hasNext();) {
				DevelopmentsModels nextInDevelopmentsModels = iterDevelopmentsModels
						.next();
				nextInDevelopmentsModels.setDevelopments(null);
				iterDevelopmentsModels.remove();
				this.entityManager.merge(nextInDevelopmentsModels);
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
	 * Support searching Developments entities with pagination
	 */

	private int page;
	private long count;
	private List<Developments> pageItems;

	private Developments example = new Developments();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public Developments getExample() {
		return this.example;
	}

	public void setExample(Developments example) {
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
		Root<Developments> root = countCriteria.from(Developments.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<Developments> criteria = builder
				.createQuery(Developments.class);
		root = criteria.from(Developments.class);
		TypedQuery<Developments> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<Developments> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

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
		String artifactId = this.example.getArtifactId();
		if (artifactId != null && !"".equals(artifactId)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("artifactId")),
					'%' + artifactId.toLowerCase() + '%'));
		}
		String groupId = this.example.getGroupId();
		if (groupId != null && !"".equals(groupId)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("groupId")),
					'%' + groupId.toLowerCase() + '%'));
		}
		String version = this.example.getVersion();
		if (version != null && !"".equals(version)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("version")),
					'%' + version.toLowerCase() + '%'));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<Developments> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back Developments entities (e.g. from inside
	 * an HtmlSelectOneMenu)
	 */

	public List<Developments> getAll() {

		CriteriaQuery<Developments> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(Developments.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(Developments.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final DevelopmentsBean ejbProxy = this.sessionContext
				.getBusinessObject(DevelopmentsBean.class);

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

				return String.valueOf(((Developments) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private Developments add = new Developments();

	public Developments getAdd() {
		return this.add;
	}

	public Developments getAdded() {
		Developments added = this.add;
		this.add = new Developments();
		return added;
	}
}
