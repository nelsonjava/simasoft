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

import co.simasoft.models.DevelopmentsGroups;
import co.simasoft.models.Developments;
import co.simasoft.models.Models;
import java.util.Iterator;

/**
 * Backing bean for DevelopmentsGroups entities.
 * <p/>
 * This class provides CRUD functionality for all DevelopmentsGroups entities.
 * It focuses purely on Java EE 6 standards (e.g.
 * <tt>&#64;ConversationScoped</tt> for state management,
 * <tt>PersistenceContext</tt> for persistence, <tt>CriteriaBuilder</tt> for
 * searches) rather than introducing a CRUD framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class DevelopmentsGroupsBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving DevelopmentsGroups entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private DevelopmentsGroups developmentsGroups;

	public DevelopmentsGroups getDevelopmentsGroups() {
		return this.developmentsGroups;
	}

	public void setDevelopmentsGroups(DevelopmentsGroups developmentsGroups) {
		this.developmentsGroups = developmentsGroups;
	}

	@Inject
	private Conversation conversation;

	@PersistenceContext(unitName = "naifg28PU-JTA", type = PersistenceContextType.EXTENDED)
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
			this.developmentsGroups = this.example;
		} else {
			this.developmentsGroups = findById(getId());
		}
	}

	public DevelopmentsGroups findById(Long id) {

		return this.entityManager.find(DevelopmentsGroups.class, id);
	}

	/*
	 * Support updating and deleting DevelopmentsGroups entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.developmentsGroups);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.developmentsGroups);
				return "view?faces-redirect=true&id="
						+ this.developmentsGroups.getId();
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
			DevelopmentsGroups deletableEntity = findById(getId());
			Iterator<Models> iterModels = deletableEntity.getModels()
					.iterator();
			for (; iterModels.hasNext();) {
				Models nextInModels = iterModels.next();
				nextInModels.getDevelopmentsGroups().remove(deletableEntity);
				iterModels.remove();
				this.entityManager.merge(nextInModels);
			}
			Iterator<Developments> iterDevelopments = deletableEntity
					.getDevelopments().iterator();
			for (; iterDevelopments.hasNext();) {
				Developments nextInDevelopments = iterDevelopments.next();
				nextInDevelopments.getDevelopmentsGroups().remove(
						deletableEntity);
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
	 * Support searching DevelopmentsGroups entities with pagination
	 */

	private int page;
	private long count;
	private List<DevelopmentsGroups> pageItems;

	private DevelopmentsGroups example = new DevelopmentsGroups();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 1000;
	}

	public DevelopmentsGroups getExample() {
		return this.example;
	}

	public void setExample(DevelopmentsGroups example) {
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
		Root<DevelopmentsGroups> root = countCriteria
				.from(DevelopmentsGroups.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<DevelopmentsGroups> criteria = builder
				.createQuery(DevelopmentsGroups.class);
		root = criteria.from(DevelopmentsGroups.class);
		TypedQuery<DevelopmentsGroups> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<DevelopmentsGroups> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

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

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<DevelopmentsGroups> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back DevelopmentsGroups entities (e.g. from
	 * inside an HtmlSelectOneMenu)
	 */

	public List<DevelopmentsGroups> getAll() {

		CriteriaQuery<DevelopmentsGroups> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(DevelopmentsGroups.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(DevelopmentsGroups.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final DevelopmentsGroupsBean ejbProxy = this.sessionContext
				.getBusinessObject(DevelopmentsGroupsBean.class);

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

				return String.valueOf(((DevelopmentsGroups) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private DevelopmentsGroups add = new DevelopmentsGroups();

	public DevelopmentsGroups getAdd() {
		return this.add;
	}

	public DevelopmentsGroups getAdded() {
		DevelopmentsGroups added = this.add;
		this.add = new DevelopmentsGroups();
		return added;
	}
}
