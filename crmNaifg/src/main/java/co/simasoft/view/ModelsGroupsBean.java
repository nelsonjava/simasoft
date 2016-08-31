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

import co.simasoft.models.ModelsGroups;
import co.simasoft.models.Developments;
import co.simasoft.models.GroupIdsTypes;
import co.simasoft.models.Models;
import java.util.Iterator;

/**
 * Backing bean for ModelsGroups entities.
 * <p/>
 * This class provides CRUD functionality for all ModelsGroups entities. It
 * focuses purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt>
 * for state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class ModelsGroupsBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving ModelsGroups entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private ModelsGroups modelsGroups;

	public ModelsGroups getModelsGroups() {
		return this.modelsGroups;
	}

	public void setModelsGroups(ModelsGroups modelsGroups) {
		this.modelsGroups = modelsGroups;
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
			this.modelsGroups = this.example;
		} else {
			this.modelsGroups = findById(getId());
		}
	}

	public ModelsGroups findById(Long id) {

		return this.entityManager.find(ModelsGroups.class, id);
	}

	/*
	 * Support updating and deleting ModelsGroups entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.modelsGroups);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.modelsGroups);
				return "view?faces-redirect=true&id="
						+ this.modelsGroups.getId();
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
			ModelsGroups deletableEntity = findById(getId());
			Iterator<Models> iterModels = deletableEntity.getModels()
					.iterator();
			for (; iterModels.hasNext();) {
				Models nextInModels = iterModels.next();
				nextInModels.getModelsGroups().remove(deletableEntity);
				iterModels.remove();
				this.entityManager.merge(nextInModels);
			}
			GroupIdsTypes groupIdsTypes = deletableEntity.getGroupIdsTypes();
			groupIdsTypes.getModelsGroups().remove(deletableEntity);
			deletableEntity.setGroupIdsTypes(null);
			this.entityManager.merge(groupIdsTypes);
			Iterator<Developments> iterDevelopments = deletableEntity
					.getDevelopments().iterator();
			for (; iterDevelopments.hasNext();) {
				Developments nextInDevelopments = iterDevelopments.next();
				nextInDevelopments.getModelsGroups().remove(deletableEntity);
				iterDevelopments.remove();
				this.entityManager.merge(nextInDevelopments);
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
	 * Support searching ModelsGroups entities with pagination
	 */

	private int page;
	private long count;
	private List<ModelsGroups> pageItems;

	private ModelsGroups example = new ModelsGroups();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public ModelsGroups getExample() {
		return this.example;
	}

	public void setExample(ModelsGroups example) {
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
		Root<ModelsGroups> root = countCriteria.from(ModelsGroups.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<ModelsGroups> criteria = builder
				.createQuery(ModelsGroups.class);
		root = criteria.from(ModelsGroups.class);
		TypedQuery<ModelsGroups> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<ModelsGroups> root) {

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
		GroupIdsTypes groupIdsTypes = this.example.getGroupIdsTypes();
		if (groupIdsTypes != null) {
			predicatesList.add(builder.equal(root.get("groupIdsTypes"),
					groupIdsTypes));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<ModelsGroups> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back ModelsGroups entities (e.g. from inside
	 * an HtmlSelectOneMenu)
	 */

	public List<ModelsGroups> getAll() {

		CriteriaQuery<ModelsGroups> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(ModelsGroups.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(ModelsGroups.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final ModelsGroupsBean ejbProxy = this.sessionContext
				.getBusinessObject(ModelsGroupsBean.class);

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

				return String.valueOf(((ModelsGroups) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private ModelsGroups add = new ModelsGroups();

	public ModelsGroups getAdd() {
		return this.add;
	}

	public ModelsGroups getAdded() {
		ModelsGroups added = this.add;
		this.add = new ModelsGroups();
		return added;
	}
}
