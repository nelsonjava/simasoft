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

import co.simasoft.models.LegisTopic;
import co.simasoft.models.LegisSubject;
import co.simasoft.models.LegisTopicTypes;

/**
 * Backing bean for LegisTopic entities.
 * <p/>
 * This class provides CRUD functionality for all LegisTopic entities. It
 * focuses purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt>
 * for state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class LegisTopicBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving LegisTopic entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private LegisTopic legisTopic;

	public LegisTopic getLegisTopic() {
		return this.legisTopic;
	}

	public void setLegisTopic(LegisTopic legisTopic) {
		this.legisTopic = legisTopic;
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
			this.legisTopic = this.example;
		} else {
			this.legisTopic = findById(getId());
		}
	}

	public LegisTopic findById(Long id) {

		return this.entityManager.find(LegisTopic.class, id);
	}

	/*
	 * Support updating and deleting LegisTopic entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.legisTopic);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.legisTopic);
				return "view?faces-redirect=true&id=" + this.legisTopic.getId();
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
			LegisTopic deletableEntity = findById(getId());
			LegisSubject legisSubject = deletableEntity.getLegisSubject();
			legisSubject.getLegisTopic().remove(deletableEntity);
			deletableEntity.setLegisSubject(null);
			this.entityManager.merge(legisSubject);
			LegisTopicTypes legisTopicTypes = deletableEntity
					.getLegisTopicTypes();
			legisTopicTypes.getLegisTopic().remove(deletableEntity);
			deletableEntity.setLegisTopicTypes(null);
			this.entityManager.merge(legisTopicTypes);
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
	 * Support searching LegisTopic entities with pagination
	 */

	private int page;
	private long count;
	private List<LegisTopic> pageItems;

	private LegisTopic example = new LegisTopic();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 1000;
	}

	public LegisTopic getExample() {
		return this.example;
	}

	public void setExample(LegisTopic example) {
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
		Root<LegisTopic> root = countCriteria.from(LegisTopic.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<LegisTopic> criteria = builder
				.createQuery(LegisTopic.class);
		root = criteria.from(LegisTopic.class);
		TypedQuery<LegisTopic> query = this.entityManager.createQuery(criteria
				.select(root).where(getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<LegisTopic> root) {

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
		String code = this.example.getCode();
		if (code != null && !"".equals(code)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("code")),
					'%' + code.toLowerCase() + '%'));
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

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<LegisTopic> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back LegisTopic entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<LegisTopic> getAll() {

		CriteriaQuery<LegisTopic> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(LegisTopic.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(LegisTopic.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final LegisTopicBean ejbProxy = this.sessionContext
				.getBusinessObject(LegisTopicBean.class);

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

				return String.valueOf(((LegisTopic) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private LegisTopic add = new LegisTopic();

	public LegisTopic getAdd() {
		return this.add;
	}

	public LegisTopic getAdded() {
		LegisTopic added = this.add;
		this.add = new LegisTopic();
		return added;
	}
}
