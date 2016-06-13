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

import co.simasoft.models.Legis;
import co.simasoft.models.LegisArt;
import co.simasoft.models.LegisTypes;
import java.util.Iterator;

/**
 * Backing bean for Legis entities.
 * <p/>
 * This class provides CRUD functionality for all Legis entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class LegisBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving Legis entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Legis legis;

	public Legis getLegis() {
		return this.legis;
	}

	public void setLegis(Legis legis) {
		this.legis = legis;
	}

	@Inject
	private Conversation conversation;

	@PersistenceContext(unitName = "legisPU-JTA", type = PersistenceContextType.EXTENDED)
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
			this.legis = this.example;
		} else {
			this.legis = findById(getId());
		}
	}

	public Legis findById(Long id) {

		return this.entityManager.find(Legis.class, id);
	}

	/*
	 * Support updating and deleting Legis entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.legis);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.legis);
				return "view?faces-redirect=true&id=" + this.legis.getId();
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
			Legis deletableEntity = findById(getId());
			Iterator<LegisArt> iterLegisArt = deletableEntity.getLegisArt()
					.iterator();
			for (; iterLegisArt.hasNext();) {
				LegisArt nextInLegisArt = iterLegisArt.next();
				nextInLegisArt.setLegis(null);
				iterLegisArt.remove();
				this.entityManager.merge(nextInLegisArt);
			}
			LegisTypes legisTypes = deletableEntity.getLegisTypes();
			legisTypes.getLegis().remove(deletableEntity);
			deletableEntity.setLegisTypes(null);
			this.entityManager.merge(legisTypes);
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
	 * Support searching Legis entities with pagination
	 */

	private int page;
	private long count;
	private List<Legis> pageItems;

	private Legis example = new Legis();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 1000;
	}

	public Legis getExample() {
		return this.example;
	}

	public void setExample(Legis example) {
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
		Root<Legis> root = countCriteria.from(Legis.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<Legis> criteria = builder.createQuery(Legis.class);
		root = criteria.from(Legis.class);
		TypedQuery<Legis> query = this.entityManager.createQuery(criteria
				.select(root).where(getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<Legis> root) {

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
		String link = this.example.getLink();
		if (link != null && !"".equals(link)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("link")),
					'%' + link.toLowerCase() + '%'));
		}
		LegisTypes legisTypes = this.example.getLegisTypes();
		if (legisTypes != null) {
			predicatesList
					.add(builder.equal(root.get("legisTypes"), legisTypes));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<Legis> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back Legis entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<Legis> getAll() {

		CriteriaQuery<Legis> criteria = this.entityManager.getCriteriaBuilder()
				.createQuery(Legis.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(Legis.class))).getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final LegisBean ejbProxy = this.sessionContext
				.getBusinessObject(LegisBean.class);

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

				return String.valueOf(((Legis) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private Legis add = new Legis();

	public Legis getAdd() {
		return this.add;
	}

	public Legis getAdded() {
		Legis added = this.add;
		this.add = new Legis();
		return added;
	}
}
