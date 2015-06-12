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

import co.simasoft.models.naif.domainmodels.Dependency;
import co.simasoft.models.naif.domainmodels.Imports;
import java.util.Iterator;

/**
 * Backing bean for Dependency entities.
 * <p/>
 * This class provides CRUD functionality for all Dependency entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class DependencyBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving Dependency entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Dependency dependency;

	public Dependency getDependency() {
		return this.dependency;
	}

	public void setDependency(Dependency dependency) {
		this.dependency = dependency;
	}

	@Inject
	private Conversation conversation;

	@PersistenceContext(unitName = "naifg8PU-JTA", type = PersistenceContextType.EXTENDED)
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
			this.dependency = this.example;
		} else {
			this.dependency = findById(getId());
		}
	}

	public Dependency findById(Long id) {

		return this.entityManager.find(Dependency.class, id);
	}

	/*
	 * Support updating and deleting Dependency entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.dependency);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.dependency);
				return "view?faces-redirect=true&id=" + this.dependency.getId();
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
			Dependency deletableEntity = findById(getId());
			Iterator<Imports> iterImports = deletableEntity.getImports()
					.iterator();
			for (; iterImports.hasNext();) {
				Imports nextInImports = iterImports.next();
				nextInImports.setDependency(null);
				iterImports.remove();
				this.entityManager.merge(nextInImports);
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
	 * Support searching Dependency entities with pagination
	 */

	private int page;
	private long count;
	private List<Dependency> pageItems;

	private Dependency example = new Dependency();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 100;
	}

	public Dependency getExample() {
		return this.example;
	}

	public void setExample(Dependency example) {
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
		Root<Dependency> root = countCriteria.from(Dependency.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<Dependency> criteria = builder
				.createQuery(Dependency.class);
		root = criteria.from(Dependency.class);
		TypedQuery<Dependency> query = this.entityManager.createQuery(criteria
				.select(root).where(getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<Dependency> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		String artifactId = this.example.getArtifactId();
		if (artifactId != null && !"".equals(artifactId)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("artifactId")),
					'%' + artifactId.toLowerCase() + '%'));
		}
		String version = this.example.getVersion();
		if (version != null && !"".equals(version)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("version")),
					'%' + version.toLowerCase() + '%'));
		}
		String groupId = this.example.getGroupId();
		if (groupId != null && !"".equals(groupId)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("groupId")),
					'%' + groupId.toLowerCase() + '%'));
		}
		String maven = this.example.getMaven();
		if (maven != null && !"".equals(maven)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("maven")),
					'%' + maven.toLowerCase() + '%'));
		}
		String link = this.example.getLink();
		if (link != null && !"".equals(link)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("link")),
					'%' + link.toLowerCase() + '%'));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<Dependency> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back Dependency entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<Dependency> getAll() {

		CriteriaQuery<Dependency> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(Dependency.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(Dependency.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final DependencyBean ejbProxy = this.sessionContext
				.getBusinessObject(DependencyBean.class);

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

				return String.valueOf(((Dependency) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private Dependency add = new Dependency();

	public Dependency getAdd() {
		return this.add;
	}

	public Dependency getAdded() {
		Dependency added = this.add;
		this.add = new Dependency();
		return added;
	}
}
