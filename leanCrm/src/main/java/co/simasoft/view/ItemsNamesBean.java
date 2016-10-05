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

import co.simasoft.models.ItemsNames;
import co.simasoft.models.Items;
import co.simasoft.models.ItemsTypes;
import java.util.Iterator;

/**
 * Backing bean for ItemsNames entities.
 * <p/>
 * This class provides CRUD functionality for all ItemsNames entities. It
 * focuses purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt>
 * for state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class ItemsNamesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving ItemsNames entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private ItemsNames itemsNames;

	public ItemsNames getItemsNames() {
		return this.itemsNames;
	}

	public void setItemsNames(ItemsNames itemsNames) {
		this.itemsNames = itemsNames;
	}

	@Inject
	private Conversation conversation;

	@PersistenceContext(unitName = "leanCrmPU-JTA", type = PersistenceContextType.EXTENDED)
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
			this.itemsNames = this.example;
		} else {
			this.itemsNames = findById(getId());
		}
	}

	public ItemsNames findById(Long id) {

		return this.entityManager.find(ItemsNames.class, id);
	}

	/*
	 * Support updating and deleting ItemsNames entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.itemsNames);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.itemsNames);
				return "view?faces-redirect=true&id=" + this.itemsNames.getId();
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
			ItemsNames deletableEntity = findById(getId());
			Iterator<Items> iterItems = deletableEntity.getItems().iterator();
			for (; iterItems.hasNext();) {
				Items nextInItems = iterItems.next();
				nextInItems.setItemsNames(null);
				iterItems.remove();
				this.entityManager.merge(nextInItems);
			}
			ItemsTypes itemsTypes = deletableEntity.getItemsTypes();
			itemsTypes.getItemsNames().remove(deletableEntity);
			deletableEntity.setItemsTypes(null);
			this.entityManager.merge(itemsTypes);
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
	 * Support searching ItemsNames entities with pagination
	 */

	private int page;
	private long count;
	private List<ItemsNames> pageItems;

	private ItemsNames example = new ItemsNames();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public ItemsNames getExample() {
		return this.example;
	}

	public void setExample(ItemsNames example) {
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
		Root<ItemsNames> root = countCriteria.from(ItemsNames.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<ItemsNames> criteria = builder
				.createQuery(ItemsNames.class);
		root = criteria.from(ItemsNames.class);
		TypedQuery<ItemsNames> query = this.entityManager.createQuery(criteria
				.select(root).where(getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<ItemsNames> root) {

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
		String model = this.example.getModel();
		if (model != null && !"".equals(model)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("model")),
					'%' + model.toLowerCase() + '%'));
		}
		String productNumber = this.example.getProductNumber();
		if (productNumber != null && !"".equals(productNumber)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("productNumber")),
					'%' + productNumber.toLowerCase() + '%'));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<ItemsNames> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back ItemsNames entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<ItemsNames> getAll() {

		CriteriaQuery<ItemsNames> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(ItemsNames.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(ItemsNames.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final ItemsNamesBean ejbProxy = this.sessionContext
				.getBusinessObject(ItemsNamesBean.class);

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

				return String.valueOf(((ItemsNames) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private ItemsNames add = new ItemsNames();

	public ItemsNames getAdd() {
		return this.add;
	}

	public ItemsNames getAdded() {
		ItemsNames added = this.add;
		this.add = new ItemsNames();
		return added;
	}
}
