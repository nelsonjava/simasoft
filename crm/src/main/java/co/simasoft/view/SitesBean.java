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
import co.simasoft.models.Activities;
import co.simasoft.models.Brands;
import co.simasoft.models.Companies;
import co.simasoft.models.Diaries;
import co.simasoft.models.NetworkPorts;
import co.simasoft.models.SitesTypes;
import co.simasoft.models.Tasks;
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
			Iterator<Tasks> iterTasks = deletableEntity.getTasks().iterator();
			for (; iterTasks.hasNext();) {
				Tasks nextInTasks = iterTasks.next();
				nextInTasks.getSites().remove(deletableEntity);
				iterTasks.remove();
				this.entityManager.merge(nextInTasks);
			}
			Iterator<Diaries> iterDiaries = deletableEntity.getDiaries()
					.iterator();
			for (; iterDiaries.hasNext();) {
				Diaries nextInDiaries = iterDiaries.next();
				nextInDiaries.getSites().remove(deletableEntity);
				iterDiaries.remove();
				this.entityManager.merge(nextInDiaries);
			}
			Iterator<Activities> iterActivities = deletableEntity
					.getActivities().iterator();
			for (; iterActivities.hasNext();) {
				Activities nextInActivities = iterActivities.next();
				nextInActivities.getSites().remove(deletableEntity);
				iterActivities.remove();
				this.entityManager.merge(nextInActivities);
			}
			Iterator<NetworkPorts> iterNetworkPorts = deletableEntity
					.getNetworkPorts().iterator();
			for (; iterNetworkPorts.hasNext();) {
				NetworkPorts nextInNetworkPorts = iterNetworkPorts.next();
				nextInNetworkPorts.getSites().remove(deletableEntity);
				iterNetworkPorts.remove();
				this.entityManager.merge(nextInNetworkPorts);
			}
			Iterator<Companies> iterCompanies = deletableEntity.getCompanies()
					.iterator();
			for (; iterCompanies.hasNext();) {
				Companies nextInCompanies = iterCompanies.next();
				nextInCompanies.getSites().remove(deletableEntity);
				iterCompanies.remove();
				this.entityManager.merge(nextInCompanies);
			}
			Iterator<Brands> iterBrands = deletableEntity.getBrands()
					.iterator();
			for (; iterBrands.hasNext();) {
				Brands nextInBrands = iterBrands.next();
				nextInBrands.getSites().remove(deletableEntity);
				iterBrands.remove();
				this.entityManager.merge(nextInBrands);
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
		return 10;
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
