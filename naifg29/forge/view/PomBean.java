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

import co.simasoft.models.Pom;
import co.simasoft.models.Dependencies;
import co.simasoft.models.Developments;
import co.simasoft.models.GroupIds;
import java.util.Iterator;

/**
 * Backing bean for Pom entities.
 * <p/>
 * This class provides CRUD functionality for all Pom entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class PomBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving Pom entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Pom pom;

	public Pom getPom() {
		return this.pom;
	}

	public void setPom(Pom pom) {
		this.pom = pom;
	}

	@Inject
	private Conversation conversation;

	@PersistenceContext(unitName = "naifg29PU-JTA", type = PersistenceContextType.EXTENDED)
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
			this.pom = this.example;
		} else {
			this.pom = findById(getId());
		}
	}

	public Pom findById(Long id) {

		return this.entityManager.find(Pom.class, id);
	}

	/*
	 * Support updating and deleting Pom entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.pom);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.pom);
				return "view?faces-redirect=true&id=" + this.pom.getId();
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
			Pom deletableEntity = findById(getId());
			Iterator<Dependencies> iterDependencies = deletableEntity
					.getDependencies().iterator();
			for (; iterDependencies.hasNext();) {
				Dependencies nextInDependencies = iterDependencies.next();
				nextInDependencies.setPom(null);
				iterDependencies.remove();
				this.entityManager.merge(nextInDependencies);
			}
			Iterator<Developments> iterDevelopments = deletableEntity
					.getDevelopments().iterator();
			for (; iterDevelopments.hasNext();) {
				Developments nextInDevelopments = iterDevelopments.next();
				nextInDevelopments.getPom().remove(deletableEntity);
				iterDevelopments.remove();
				this.entityManager.merge(nextInDevelopments);
			}
			Iterator<GroupIds> iterGroupIds = deletableEntity.getGroupIds()
					.iterator();
			for (; iterGroupIds.hasNext();) {
				GroupIds nextInGroupIds = iterGroupIds.next();
				nextInGroupIds.getPom().remove(deletableEntity);
				iterGroupIds.remove();
				this.entityManager.merge(nextInGroupIds);
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
	 * Support searching Pom entities with pagination
	 */

	private int page;
	private long count;
	private List<Pom> pageItems;

	private Pom example = new Pom();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 1000;
	}

	public Pom getExample() {
		return this.example;
	}

	public void setExample(Pom example) {
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
		Root<Pom> root = countCriteria.from(Pom.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<Pom> criteria = builder.createQuery(Pom.class);
		root = criteria.from(Pom.class);
		TypedQuery<Pom> query = this.entityManager.createQuery(criteria.select(
				root).where(getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<Pom> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		String observations = this.example.getObservations();
		if (observations != null && !"".equals(observations)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("observations")),
					'%' + observations.toLowerCase() + '%'));
		}
		String groupId = this.example.getGroupId();
		if (groupId != null && !"".equals(groupId)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("groupId")),
					'%' + groupId.toLowerCase() + '%'));
		}
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

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<Pom> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back Pom entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<Pom> getAll() {

		CriteriaQuery<Pom> criteria = this.entityManager.getCriteriaBuilder()
				.createQuery(Pom.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(Pom.class))).getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final PomBean ejbProxy = this.sessionContext
				.getBusinessObject(PomBean.class);

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

				return String.valueOf(((Pom) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private Pom add = new Pom();

	public Pom getAdd() {
		return this.add;
	}

	public Pom getAdded() {
		Pom added = this.add;
		this.add = new Pom();
		return added;
	}
}
