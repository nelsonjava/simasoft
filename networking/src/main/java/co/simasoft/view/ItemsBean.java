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

import co.simasoft.models.Items;
import co.simasoft.models.Hosts;
import co.simasoft.models.ItemsNames;
import co.simasoft.models.ItemsStates;
import co.simasoft.models.PhysicalAreas;
import java.util.Iterator;

/**
 * Backing bean for Items entities.
 * <p/>
 * This class provides CRUD functionality for all Items entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class ItemsBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving Items entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Items items;

	public Items getItems() {
		return this.items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	@Inject
	private Conversation conversation;

	@PersistenceContext(unitName = "networkingPU-JTA", type = PersistenceContextType.EXTENDED)
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
			this.items = this.example;
		} else {
			this.items = findById(getId());
		}
	}

	public Items findById(Long id) {

		return this.entityManager.find(Items.class, id);
	}

	/*
	 * Support updating and deleting Items entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.items);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.items);
				return "view?faces-redirect=true&id=" + this.items.getId();
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
			Items deletableEntity = findById(getId());
			Iterator<Hosts> iterHosts = deletableEntity.getHosts().iterator();
			for (; iterHosts.hasNext();) {
				Hosts nextInHosts = iterHosts.next();
				nextInHosts.setItems(null);
				iterHosts.remove();
				this.entityManager.merge(nextInHosts);
			}
			Iterator<Items> iterObjHijos = deletableEntity.getObjHijos()
					.iterator();
			for (; iterObjHijos.hasNext();) {
				Items nextInObjHijos = iterObjHijos.next();
				nextInObjHijos.setObjPadre(null);
				iterObjHijos.remove();
				this.entityManager.merge(nextInObjHijos);
			}
			ItemsNames itemsNames = deletableEntity.getItemsNames();
			itemsNames.getItems().remove(deletableEntity);
			deletableEntity.setItemsNames(null);
			this.entityManager.merge(itemsNames);
			ItemsStates itemsStates = deletableEntity.getItemsStates();
			itemsStates.getItems().remove(deletableEntity);
			deletableEntity.setItemsStates(null);
			this.entityManager.merge(itemsStates);
			Items objPadre = deletableEntity.getObjPadre();
			objPadre.getObjHijos().remove(deletableEntity);
			deletableEntity.setObjPadre(null);
			this.entityManager.merge(objPadre);
			PhysicalAreas physicalAreas = deletableEntity.getPhysicalAreas();
			physicalAreas.getItems().remove(deletableEntity);
			deletableEntity.setPhysicalAreas(null);
			this.entityManager.merge(physicalAreas);
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
	 * Support searching Items entities with pagination
	 */

	private int page;
	private long count;
	private List<Items> pageItems;

	private Items example = new Items();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 1000;
	}

	public Items getExample() {
		return this.example;
	}

	public void setExample(Items example) {
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
		Root<Items> root = countCriteria.from(Items.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<Items> criteria = builder.createQuery(Items.class);
		root = criteria.from(Items.class);
		TypedQuery<Items> query = this.entityManager.createQuery(criteria
				.select(root).where(getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<Items> root) {

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
		String cvNumber = this.example.getCvNumber();
		if (cvNumber != null && !"".equals(cvNumber)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("cvNumber")),
					'%' + cvNumber.toLowerCase() + '%'));
		}
		String located = this.example.getLocated();
		if (located != null && !"".equals(located)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("located")),
					'%' + located.toLowerCase() + '%'));
		}
		String code = this.example.getCode();
		if (code != null && !"".equals(code)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("code")),
					'%' + code.toLowerCase() + '%'));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<Items> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back Items entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<Items> getAll() {

		CriteriaQuery<Items> criteria = this.entityManager.getCriteriaBuilder()
				.createQuery(Items.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(Items.class))).getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final ItemsBean ejbProxy = this.sessionContext
				.getBusinessObject(ItemsBean.class);

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

				return String.valueOf(((Items) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private Items add = new Items();

	public Items getAdd() {
		return this.add;
	}

	public Items getAdded() {
		Items added = this.add;
		this.add = new Items();
		return added;
	}
}