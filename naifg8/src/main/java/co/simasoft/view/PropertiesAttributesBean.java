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

import co.simasoft.models.naif.domainmodels.PropertiesAttributes;
import co.simasoft.models.naif.domainmodels.Attributes;
import co.simasoft.models.naif.domainmodels.AttributesTypes;
import co.simasoft.models.naif.domainmodels.Imports;
import co.simasoft.models.naif.domainmodels.Relationships;
import java.util.Iterator;

/**
 * Backing bean for PropertiesAttributes entities.
 * <p/>
 * This class provides CRUD functionality for all PropertiesAttributes entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class PropertiesAttributesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving PropertiesAttributes entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private PropertiesAttributes propertiesAttributes;

	public PropertiesAttributes getPropertiesAttributes() {
		return this.propertiesAttributes;
	}

	public void setPropertiesAttributes(
			PropertiesAttributes propertiesAttributes) {
		this.propertiesAttributes = propertiesAttributes;
	}

	@Inject
	private Conversation conversation;

	@PersistenceContext(unitName = "naifg8PU-JTA", type = PersistenceContextType.EXTENDED)
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
			this.propertiesAttributes = this.example;
		} else {
			this.propertiesAttributes = findById(getId());
		}
	}

	public PropertiesAttributes findById(Long id) {

		return this.entityManager.find(PropertiesAttributes.class, id);
	}

	/*
	 * Support updating and deleting PropertiesAttributes entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.propertiesAttributes);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.propertiesAttributes);
				return "view?faces-redirect=true&id="
						+ this.propertiesAttributes.getId();
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
			PropertiesAttributes deletableEntity = findById(getId());
			Iterator<Imports> iterImports = deletableEntity.getImports()
					.iterator();
			for (; iterImports.hasNext();) {
				Imports nextInImports = iterImports.next();
				nextInImports.getPropertiesAttributes().remove(deletableEntity);
				iterImports.remove();
				this.entityManager.merge(nextInImports);
			}
			Relationships relationships = deletableEntity.getRelationships();
			relationships.getPropertiesAttributes().remove(deletableEntity);
			deletableEntity.setRelationships(null);
			this.entityManager.merge(relationships);
			Iterator<Attributes> iterAttributes = deletableEntity
					.getAttributes().iterator();
			for (; iterAttributes.hasNext();) {
				Attributes nextInAttributes = iterAttributes.next();
				nextInAttributes.getPropertiesAttributes().remove(
						deletableEntity);
				iterAttributes.remove();
				this.entityManager.merge(nextInAttributes);
			}
			Iterator<AttributesTypes> iterAttributesTypes = deletableEntity
					.getAttributesTypes().iterator();
			for (; iterAttributesTypes.hasNext();) {
				AttributesTypes nextInAttributesTypes = iterAttributesTypes
						.next();
				nextInAttributesTypes.getPropertiesAttributes().remove(
						deletableEntity);
				iterAttributesTypes.remove();
				this.entityManager.merge(nextInAttributesTypes);
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
	 * Support searching PropertiesAttributes entities with pagination
	 */

	private int page;
	private long count;
	private List<PropertiesAttributes> pageItems;

	private PropertiesAttributes example = new PropertiesAttributes();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 100;
	}

	public PropertiesAttributes getExample() {
		return this.example;
	}

	public void setExample(PropertiesAttributes example) {
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
		Root<PropertiesAttributes> root = countCriteria
				.from(PropertiesAttributes.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<PropertiesAttributes> criteria = builder
				.createQuery(PropertiesAttributes.class);
		root = criteria.from(PropertiesAttributes.class);
		TypedQuery<PropertiesAttributes> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<PropertiesAttributes> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		String name = this.example.getName();
		if (name != null && !"".equals(name)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("name")),
					'%' + name.toLowerCase() + '%'));
		}
		String observations = this.example.getObservations();
		if (observations != null && !"".equals(observations)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("observations")),
					'%' + observations.toLowerCase() + '%'));
		}
		String value = this.example.getValue();
		if (value != null && !"".equals(value)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("value")),
					'%' + value.toLowerCase() + '%'));
		}
		Relationships relationships = this.example.getRelationships();
		if (relationships != null) {
			predicatesList.add(builder.equal(root.get("relationships"),
					relationships));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<PropertiesAttributes> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back PropertiesAttributes entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<PropertiesAttributes> getAll() {

		CriteriaQuery<PropertiesAttributes> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(PropertiesAttributes.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(PropertiesAttributes.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final PropertiesAttributesBean ejbProxy = this.sessionContext
				.getBusinessObject(PropertiesAttributesBean.class);

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

				return String.valueOf(((PropertiesAttributes) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private PropertiesAttributes add = new PropertiesAttributes();

	public PropertiesAttributes getAdd() {
		return this.add;
	}

	public PropertiesAttributes getAdded() {
		PropertiesAttributes added = this.add;
		this.add = new PropertiesAttributes();
		return added;
	}
}
