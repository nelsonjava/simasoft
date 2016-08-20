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

import co.simasoft.models.Sites;
import co.simasoft.models.Attributes;
import co.simasoft.models.AttributesProperties;
import co.simasoft.models.AttributesTypes;
import co.simasoft.models.Cardinalities;
import co.simasoft.models.Dependencies;
import co.simasoft.models.Developments;
import co.simasoft.models.Entities;
import co.simasoft.models.GroupIds;
import co.simasoft.models.Imports;
import co.simasoft.models.Models;
import co.simasoft.models.SitesTypes;
import java.util.Iterator;

/**
 * Backing bean for Sites entities.
 * <p/>
 * This class provides CRUD functionality for all Sites entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class SitesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving Sites entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Sites sites;

	public Sites getSites() {
		return this.sites;
	}

	public void setSites(Sites sites) {
		this.sites = sites;
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
			this.sites = this.example;
		} else {
			this.sites = findById(getId());
		}
	}

	public Sites findById(Long id) {

		return this.entityManager.find(Sites.class, id);
	}

	/*
	 * Support updating and deleting Sites entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.sites);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.sites);
				return "view?faces-redirect=true&id=" + this.sites.getId();
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
			Sites deletableEntity = findById(getId());
			Iterator<SitesTypes> iterSitesTypes = deletableEntity
					.getSitesTypes().iterator();
			for (; iterSitesTypes.hasNext();) {
				SitesTypes nextInSitesTypes = iterSitesTypes.next();
				nextInSitesTypes.getSites().remove(deletableEntity);
				iterSitesTypes.remove();
				this.entityManager.merge(nextInSitesTypes);
			}
			Iterator<Cardinalities> iterCardinalities = deletableEntity
					.getCardinalities().iterator();
			for (; iterCardinalities.hasNext();) {
				Cardinalities nextInCardinalities = iterCardinalities.next();
				nextInCardinalities.getSites().remove(deletableEntity);
				iterCardinalities.remove();
				this.entityManager.merge(nextInCardinalities);
			}
			Iterator<Models> iterModels = deletableEntity.getModels()
					.iterator();
			for (; iterModels.hasNext();) {
				Models nextInModels = iterModels.next();
				nextInModels.getSites().remove(deletableEntity);
				iterModels.remove();
				this.entityManager.merge(nextInModels);
			}
			Iterator<Developments> iterDevelopments = deletableEntity
					.getDevelopments().iterator();
			for (; iterDevelopments.hasNext();) {
				Developments nextInDevelopments = iterDevelopments.next();
				nextInDevelopments.getSites().remove(deletableEntity);
				iterDevelopments.remove();
				this.entityManager.merge(nextInDevelopments);
			}
			Iterator<GroupIds> iterGroupIds = deletableEntity.getGroupIds()
					.iterator();
			for (; iterGroupIds.hasNext();) {
				GroupIds nextInGroupIds = iterGroupIds.next();
				nextInGroupIds.getSites().remove(deletableEntity);
				iterGroupIds.remove();
				this.entityManager.merge(nextInGroupIds);
			}
			Iterator<Entities> iterEntities = deletableEntity.getEntities()
					.iterator();
			for (; iterEntities.hasNext();) {
				Entities nextInEntities = iterEntities.next();
				nextInEntities.getSites().remove(deletableEntity);
				iterEntities.remove();
				this.entityManager.merge(nextInEntities);
			}
			Attributes attributes = deletableEntity.getAttributes();
			attributes.getSites().remove(deletableEntity);
			deletableEntity.setAttributes(null);
			this.entityManager.merge(attributes);
			Iterator<AttributesTypes> iterAttributesTypes = deletableEntity
					.getAttributesTypes().iterator();
			for (; iterAttributesTypes.hasNext();) {
				AttributesTypes nextInAttributesTypes = iterAttributesTypes
						.next();
				nextInAttributesTypes.getSites().remove(deletableEntity);
				iterAttributesTypes.remove();
				this.entityManager.merge(nextInAttributesTypes);
			}
			Iterator<Dependencies> iterDependencies = deletableEntity
					.getDependencies().iterator();
			for (; iterDependencies.hasNext();) {
				Dependencies nextInDependencies = iterDependencies.next();
				nextInDependencies.getSites().remove(deletableEntity);
				iterDependencies.remove();
				this.entityManager.merge(nextInDependencies);
			}
			Iterator<AttributesProperties> iterAttributesProperties = deletableEntity
					.getAttributesProperties().iterator();
			for (; iterAttributesProperties.hasNext();) {
				AttributesProperties nextInAttributesProperties = iterAttributesProperties
						.next();
				nextInAttributesProperties.getSites().remove(deletableEntity);
				iterAttributesProperties.remove();
				this.entityManager.merge(nextInAttributesProperties);
			}
			Iterator<Imports> iterImports = deletableEntity.getImports()
					.iterator();
			for (; iterImports.hasNext();) {
				Imports nextInImports = iterImports.next();
				nextInImports.getSites().remove(deletableEntity);
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
	 * Support searching Sites entities with pagination
	 */

	private int page;
	private long count;
	private List<Sites> pageItems;

	private Sites example = new Sites();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 1000;
	}

	public Sites getExample() {
		return this.example;
	}

	public void setExample(Sites example) {
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
		Root<Sites> root = countCriteria.from(Sites.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<Sites> criteria = builder.createQuery(Sites.class);
		root = criteria.from(Sites.class);
		TypedQuery<Sites> query = this.entityManager.createQuery(criteria
				.select(root).where(getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<Sites> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		String observations = this.example.getObservations();
		if (observations != null && !"".equals(observations)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("observations")),
					'%' + observations.toLowerCase() + '%'));
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
		String abc = this.example.getAbc();
		if (abc != null && !"".equals(abc)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("abc")),
					'%' + abc.toLowerCase() + '%'));
		}
		String ipAddress1 = this.example.getIpAddress1();
		if (ipAddress1 != null && !"".equals(ipAddress1)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("ipAddress1")),
					'%' + ipAddress1.toLowerCase() + '%'));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<Sites> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back Sites entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<Sites> getAll() {

		CriteriaQuery<Sites> criteria = this.entityManager.getCriteriaBuilder()
				.createQuery(Sites.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(Sites.class))).getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final SitesBean ejbProxy = this.sessionContext
				.getBusinessObject(SitesBean.class);

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

				return String.valueOf(((Sites) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private Sites add = new Sites();

	public Sites getAdd() {
		return this.add;
	}

	public Sites getAdded() {
		Sites added = this.add;
		this.add = new Sites();
		return added;
	}
}
