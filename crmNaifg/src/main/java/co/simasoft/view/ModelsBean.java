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

import co.simasoft.models.Models;
import co.simasoft.models.GroupIds;
import co.simasoft.models.ModelRelationships;
import co.simasoft.models.ModelsGroups;
import java.util.Iterator;

/**
 * Backing bean for Models entities.
 * <p/>
 * This class provides CRUD functionality for all Models entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class ModelsBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving Models entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Models models;

	public Models getModels() {
		return this.models;
	}

	public void setModels(Models models) {
		this.models = models;
	}

	@Inject
	private Conversation conversation;

	@PersistenceContext(unitName = "crmNaifgPU-JTA", type = PersistenceContextType.EXTENDED)
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
			this.models = this.example;
		} else {
			this.models = findById(getId());
		}
	}

	public Models findById(Long id) {

		return this.entityManager.find(Models.class, id);
	}

	/*
	 * Support updating and deleting Models entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.models);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.models);
				return "view?faces-redirect=true&id=" + this.models.getId();
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
			Models deletableEntity = findById(getId());
			Iterator<ModelRelationships> iterModelRelationships = deletableEntity
					.getModelRelationships().iterator();
			for (; iterModelRelationships.hasNext();) {
				ModelRelationships nextInModelRelationships = iterModelRelationships
						.next();
				nextInModelRelationships.setModels(null);
				iterModelRelationships.remove();
				this.entityManager.merge(nextInModelRelationships);
			}
			GroupIds groupIds = deletableEntity.getGroupIds();
			groupIds.getModels().remove(deletableEntity);
			deletableEntity.setGroupIds(null);
			this.entityManager.merge(groupIds);
			Iterator<ModelsGroups> iterModelsGroups = deletableEntity
					.getModelsGroups().iterator();
			for (; iterModelsGroups.hasNext();) {
				ModelsGroups nextInModelsGroups = iterModelsGroups.next();
				nextInModelsGroups.getModels().remove(deletableEntity);
				iterModelsGroups.remove();
				this.entityManager.merge(nextInModelsGroups);
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
	 * Support searching Models entities with pagination
	 */

	private int page;
	private long count;
	private List<Models> pageItems;

	private Models example = new Models();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public Models getExample() {
		return this.example;
	}

	public void setExample(Models example) {
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
		Root<Models> root = countCriteria.from(Models.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<Models> criteria = builder.createQuery(Models.class);
		root = criteria.from(Models.class);
		TypedQuery<Models> query = this.entityManager.createQuery(criteria
				.select(root).where(getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<Models> root) {

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
		String version = this.example.getVersion();
		if (version != null && !"".equals(version)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("version")),
					'%' + version.toLowerCase() + '%'));
		}
		String name = this.example.getName();
		if (name != null && !"".equals(name)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("name")),
					'%' + name.toLowerCase() + '%'));
		}
		String code = this.example.getCode();
		if (code != null && !"".equals(code)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("code")),
					'%' + code.toLowerCase() + '%'));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<Models> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back Models entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<Models> getAll() {

		CriteriaQuery<Models> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(Models.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(Models.class))).getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final ModelsBean ejbProxy = this.sessionContext
				.getBusinessObject(ModelsBean.class);

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

				return String.valueOf(((Models) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private Models add = new Models();

	public Models getAdd() {
		return this.add;
	}

	public Models getAdded() {
		Models added = this.add;
		this.add = new Models();
		return added;
	}
}
