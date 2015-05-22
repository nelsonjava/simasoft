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

import co.simasoft.models.naif.domainmodels.Relationships;
import co.simasoft.models.naif.domainmodels.Cardinalities;
import co.simasoft.models.naif.domainmodels.Entities;
import co.simasoft.models.naif.domainmodels.PropertiesAttributes;
import java.util.Iterator;

/**
 * Backing bean for Relationships entities.
 * <p/>
 * This class provides CRUD functionality for all Relationships entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class RelationshipsBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving Relationships entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Relationships relationships;

	public Relationships getRelationships() {
		return this.relationships;
	}

	public void setRelationships(Relationships relationships) {
		this.relationships = relationships;
	}

	@Inject
	private Conversation conversation;

	@PersistenceContext(unitName = "DomainModelsPU-JTA", type = PersistenceContextType.EXTENDED)
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
			this.relationships = this.example;
		} else {
			this.relationships = findById(getId());
		}
	}

	public Relationships findById(Long id) {

		return this.entityManager.find(Relationships.class, id);
	}

	/*
	 * Support updating and deleting Relationships entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.relationships);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.relationships);
				return "view?faces-redirect=true&id="
						+ this.relationships.getId();
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
			Relationships deletableEntity = findById(getId());
			Iterator<PropertiesAttributes> iterPropertiesAttributes = deletableEntity
					.getPropertiesAttributes().iterator();
			for (; iterPropertiesAttributes.hasNext();) {
				PropertiesAttributes nextInPropertiesAttributes = iterPropertiesAttributes
						.next();
				nextInPropertiesAttributes.setRelationships(null);
				iterPropertiesAttributes.remove();
				this.entityManager.merge(nextInPropertiesAttributes);
			}
			Entities from = deletableEntity.getFrom();
			from.getFrom().remove(deletableEntity);
			deletableEntity.setFrom(null);
			this.entityManager.merge(from);
			Cardinalities cardinalities = deletableEntity.getCardinalities();
			cardinalities.getRelationships().remove(deletableEntity);
			deletableEntity.setCardinalities(null);
			this.entityManager.merge(cardinalities);
			Entities to = deletableEntity.getTo();
			to.getTo().remove(deletableEntity);
			deletableEntity.setTo(null);
			this.entityManager.merge(to);
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
	 * Support searching Relationships entities with pagination
	 */

	private int page;
	private long count;
	private List<Relationships> pageItems;

	private Relationships example = new Relationships();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public Relationships getExample() {
		return this.example;
	}

	public void setExample(Relationships example) {
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
		Root<Relationships> root = countCriteria.from(Relationships.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<Relationships> criteria = builder
				.createQuery(Relationships.class);
		root = criteria.from(Relationships.class);
		TypedQuery<Relationships> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<Relationships> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		long orden = this.example.getOrden();
		if (orden != 0) {
			predicatesList.add(builder.equal(root.get("orden"), orden));
		}
		String description = this.example.getDescription();
		if (description != null && !"".equals(description)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("description")),
					'%' + description.toLowerCase() + '%'));
		}
		String observaciones = this.example.getObservaciones();
		if (observaciones != null && !"".equals(observaciones)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("observaciones")),
					'%' + observaciones.toLowerCase() + '%'));
		}
		String idTabla1 = this.example.getIdTabla1();
		if (idTabla1 != null && !"".equals(idTabla1)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("idTabla1")),
					'%' + idTabla1.toLowerCase() + '%'));
		}
		String idTabla2 = this.example.getIdTabla2();
		if (idTabla2 != null && !"".equals(idTabla2)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("idTabla2")),
					'%' + idTabla2.toLowerCase() + '%'));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<Relationships> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back Relationships entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<Relationships> getAll() {

		CriteriaQuery<Relationships> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(Relationships.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(Relationships.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final RelationshipsBean ejbProxy = this.sessionContext
				.getBusinessObject(RelationshipsBean.class);

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

				return String.valueOf(((Relationships) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private Relationships add = new Relationships();

	public Relationships getAdd() {
		return this.add;
	}

	public Relationships getAdded() {
		Relationships added = this.add;
		this.add = new Relationships();
		return added;
	}
}
