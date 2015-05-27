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

import co.simasoft.models.naif.domainmodels.Links;
import co.simasoft.models.naif.domainmodels.GroupIds;
import co.simasoft.models.naif.domainmodels.LinksTypes;

/**
 * Backing bean for Links entities.
 * <p/>
 * This class provides CRUD functionality for all Links entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class LinksBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving Links entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Links links;

	public Links getLinks() {
		return this.links;
	}

	public void setLinks(Links links) {
		this.links = links;
	}

	@Inject
	private Conversation conversation;

	@PersistenceContext(unitName = "naifg7PU-JTA", type = PersistenceContextType.EXTENDED)
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
			this.links = this.example;
		} else {
			this.links = findById(getId());
		}
	}

	public Links findById(Long id) {

		return this.entityManager.find(Links.class, id);
	}

	/*
	 * Support updating and deleting Links entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.links);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.links);
				return "view?faces-redirect=true&id=" + this.links.getId();
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
			Links deletableEntity = findById(getId());
			LinksTypes linksTypes = deletableEntity.getLinksTypes();
			linksTypes.getLinks().remove(deletableEntity);
			deletableEntity.setLinksTypes(null);
			this.entityManager.merge(linksTypes);
			GroupIds groupIds = deletableEntity.getGroupIds();
			groupIds.getLinks().remove(deletableEntity);
			deletableEntity.setGroupIds(null);
			this.entityManager.merge(groupIds);
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
	 * Support searching Links entities with pagination
	 */

	private int page;
	private long count;
	private List<Links> pageItems;

	private Links example = new Links();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 50;
	}

	public Links getExample() {
		return this.example;
	}

	public void setExample(Links example) {
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
		Root<Links> root = countCriteria.from(Links.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<Links> criteria = builder.createQuery(Links.class);
		root = criteria.from(Links.class);
		TypedQuery<Links> query = this.entityManager.createQuery(criteria
				.select(root).where(getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<Links> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		long orden = this.example.getOrden();
		if (orden != 0) {
			predicatesList.add(builder.equal(root.get("orden"), orden));
		}
		String title = this.example.getTitle();
		if (title != null && !"".equals(title)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("title")),
					'%' + title.toLowerCase() + '%'));
		}
		String link = this.example.getLink();
		if (link != null && !"".equals(link)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("link")),
					'%' + link.toLowerCase() + '%'));
		}
		String observations = this.example.getObservations();
		if (observations != null && !"".equals(observations)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("observations")),
					'%' + observations.toLowerCase() + '%'));
		}
		LinksTypes linksTypes = this.example.getLinksTypes();
		if (linksTypes != null) {
			predicatesList
					.add(builder.equal(root.get("linksTypes"), linksTypes));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<Links> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back Links entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<Links> getAll() {

		CriteriaQuery<Links> criteria = this.entityManager.getCriteriaBuilder()
				.createQuery(Links.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(Links.class))).getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final LinksBean ejbProxy = this.sessionContext
				.getBusinessObject(LinksBean.class);

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

				return String.valueOf(((Links) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private Links add = new Links();

	public Links getAdd() {
		return this.add;
	}

	public Links getAdded() {
		Links added = this.add;
		this.add = new Links();
		return added;
	}
}
