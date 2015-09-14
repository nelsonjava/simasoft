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

import co.simasoft.models.dev.naifg.ModelsGroupIds;
import co.simasoft.models.dev.naifg.GroupIds;
import co.simasoft.models.dev.naifg.Models;
import java.lang.Boolean;

/**
 * Backing bean for ModelsGroupIds entities.
 * <p/>
 * This class provides CRUD functionality for all ModelsGroupIds entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class ModelsGroupIdsBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving ModelsGroupIds entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private ModelsGroupIds modelsGroupIds;

	public ModelsGroupIds getModelsGroupIds() {
		return this.modelsGroupIds;
	}

	public void setModelsGroupIds(ModelsGroupIds modelsGroupIds) {
		this.modelsGroupIds = modelsGroupIds;
	}

	@Inject
	private Conversation conversation;

	@PersistenceContext(unitName = "naifgPU-JTA", type = PersistenceContextType.EXTENDED)
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
			this.modelsGroupIds = this.example;
		} else {
			this.modelsGroupIds = findById(getId());
		}
	}

	public ModelsGroupIds findById(Long id) {

		return this.entityManager.find(ModelsGroupIds.class, id);
	}

	/*
	 * Support updating and deleting ModelsGroupIds entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.modelsGroupIds);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.modelsGroupIds);
				return "view?faces-redirect=true&id="
						+ this.modelsGroupIds.getId();
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
			ModelsGroupIds deletableEntity = findById(getId());
			Models models = deletableEntity.getModels();
			models.getModelsGroupIds().remove(deletableEntity);
			deletableEntity.setModels(null);
			this.entityManager.merge(models);
			GroupIds groupIds = deletableEntity.getGroupIds();
			groupIds.getModelsGroupIds().remove(deletableEntity);
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
	 * Support searching ModelsGroupIds entities with pagination
	 */

	private int page;
	private long count;
	private List<ModelsGroupIds> pageItems;

	private ModelsGroupIds example = new ModelsGroupIds();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public ModelsGroupIds getExample() {
		return this.example;
	}

	public void setExample(ModelsGroupIds example) {
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
		Root<ModelsGroupIds> root = countCriteria.from(ModelsGroupIds.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<ModelsGroupIds> criteria = builder
				.createQuery(ModelsGroupIds.class);
		root = criteria.from(ModelsGroupIds.class);
		TypedQuery<ModelsGroupIds> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<ModelsGroupIds> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		String observations = this.example.getObservations();
		if (observations != null && !"".equals(observations)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("observations")),
					'%' + observations.toLowerCase() + '%'));
		}
		Boolean isIsolated = this.example.getIsIsolated();
		if (isIsolated != null) {
			predicatesList
					.add(builder.equal(root.get("isIsolated"), isIsolated));
		}
		Boolean isSimplified = this.example.getIsSimplified();
		if (isSimplified != null) {
			predicatesList.add(builder.equal(root.get("isSimplified"),
					isSimplified));
		}
		Models models = this.example.getModels();
		if (models != null) {
			predicatesList.add(builder.equal(root.get("models"), models));
		}
		GroupIds groupIds = this.example.getGroupIds();
		if (groupIds != null) {
			predicatesList.add(builder.equal(root.get("groupIds"), groupIds));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<ModelsGroupIds> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back ModelsGroupIds entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<ModelsGroupIds> getAll() {

		CriteriaQuery<ModelsGroupIds> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(ModelsGroupIds.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(ModelsGroupIds.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final ModelsGroupIdsBean ejbProxy = this.sessionContext
				.getBusinessObject(ModelsGroupIdsBean.class);

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

				return String.valueOf(((ModelsGroupIds) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private ModelsGroupIds add = new ModelsGroupIds();

	public ModelsGroupIds getAdd() {
		return this.add;
	}

	public ModelsGroupIds getAdded() {
		ModelsGroupIds added = this.add;
		this.add = new ModelsGroupIds();
		return added;
	}
}
