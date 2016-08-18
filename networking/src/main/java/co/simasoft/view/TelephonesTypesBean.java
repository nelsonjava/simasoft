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

import co.simasoft.models.TelephonesTypes;
import co.simasoft.models.Telephones;
import java.util.Iterator;

/**
 * Backing bean for TelephonesTypes entities.
 * <p/>
 * This class provides CRUD functionality for all TelephonesTypes entities. It
 * focuses purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt>
 * for state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class TelephonesTypesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving TelephonesTypes entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private TelephonesTypes telephonesTypes;

	public TelephonesTypes getTelephonesTypes() {
		return this.telephonesTypes;
	}

	public void setTelephonesTypes(TelephonesTypes telephonesTypes) {
		this.telephonesTypes = telephonesTypes;
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
			this.telephonesTypes = this.example;
		} else {
			this.telephonesTypes = findById(getId());
		}
	}

	public TelephonesTypes findById(Long id) {

		return this.entityManager.find(TelephonesTypes.class, id);
	}

	/*
	 * Support updating and deleting TelephonesTypes entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.telephonesTypes);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.telephonesTypes);
				return "view?faces-redirect=true&id="
						+ this.telephonesTypes.getId();
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
			TelephonesTypes deletableEntity = findById(getId());
			Iterator<Telephones> iterTelephones = deletableEntity
					.getTelephones().iterator();
			for (; iterTelephones.hasNext();) {
				Telephones nextInTelephones = iterTelephones.next();
				nextInTelephones.setTelephonesTypes(null);
				iterTelephones.remove();
				this.entityManager.merge(nextInTelephones);
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
	 * Support searching TelephonesTypes entities with pagination
	 */

	private int page;
	private long count;
	private List<TelephonesTypes> pageItems;

	private TelephonesTypes example = new TelephonesTypes();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 1000;
	}

	public TelephonesTypes getExample() {
		return this.example;
	}

	public void setExample(TelephonesTypes example) {
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
		Root<TelephonesTypes> root = countCriteria.from(TelephonesTypes.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<TelephonesTypes> criteria = builder
				.createQuery(TelephonesTypes.class);
		root = criteria.from(TelephonesTypes.class);
		TypedQuery<TelephonesTypes> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<TelephonesTypes> root) {

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

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<TelephonesTypes> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back TelephonesTypes entities (e.g. from
	 * inside an HtmlSelectOneMenu)
	 */

	public List<TelephonesTypes> getAll() {

		CriteriaQuery<TelephonesTypes> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(TelephonesTypes.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(TelephonesTypes.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final TelephonesTypesBean ejbProxy = this.sessionContext
				.getBusinessObject(TelephonesTypesBean.class);

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

				return String.valueOf(((TelephonesTypes) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private TelephonesTypes add = new TelephonesTypes();

	public TelephonesTypes getAdd() {
		return this.add;
	}

	public TelephonesTypes getAdded() {
		TelephonesTypes added = this.add;
		this.add = new TelephonesTypes();
		return added;
	}
}
