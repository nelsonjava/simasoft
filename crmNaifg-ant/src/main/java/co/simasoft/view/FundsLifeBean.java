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

import co.simasoft.models.FundsLife;
import co.simasoft.models.Funds;
import java.lang.Boolean;
import java.util.Iterator;

/**
 * Backing bean for FundsLife entities.
 * <p/>
 * This class provides CRUD functionality for all FundsLife entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class FundsLifeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving FundsLife entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private FundsLife fundsLife;

	public FundsLife getFundsLife() {
		return this.fundsLife;
	}

	public void setFundsLife(FundsLife fundsLife) {
		this.fundsLife = fundsLife;
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
			this.fundsLife = this.example;
		} else {
			this.fundsLife = findById(getId());
		}
	}

	public FundsLife findById(Long id) {

		return this.entityManager.find(FundsLife.class, id);
	}

	/*
	 * Support updating and deleting FundsLife entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.fundsLife);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.fundsLife);
				return "view?faces-redirect=true&id=" + this.fundsLife.getId();
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
			FundsLife deletableEntity = findById(getId());
			Iterator<Funds> iterFunds = deletableEntity.getFunds().iterator();
			for (; iterFunds.hasNext();) {
				Funds nextInFunds = iterFunds.next();
				nextInFunds.setFundsLife(null);
				iterFunds.remove();
				this.entityManager.merge(nextInFunds);
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
	 * Support searching FundsLife entities with pagination
	 */

	private int page;
	private long count;
	private List<FundsLife> pageItems;

	private FundsLife example = new FundsLife();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public FundsLife getExample() {
		return this.example;
	}

	public void setExample(FundsLife example) {
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
		Root<FundsLife> root = countCriteria.from(FundsLife.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<FundsLife> criteria = builder
				.createQuery(FundsLife.class);
		root = criteria.from(FundsLife.class);
		TypedQuery<FundsLife> query = this.entityManager.createQuery(criteria
				.select(root).where(getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<FundsLife> root) {

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
		Boolean isOpen = this.example.getIsOpen();
		if (isOpen != null) {
			predicatesList.add(builder.equal(root.get("isOpen"), isOpen));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<FundsLife> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back FundsLife entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<FundsLife> getAll() {

		CriteriaQuery<FundsLife> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(FundsLife.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(FundsLife.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final FundsLifeBean ejbProxy = this.sessionContext
				.getBusinessObject(FundsLifeBean.class);

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

				return String.valueOf(((FundsLife) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private FundsLife add = new FundsLife();

	public FundsLife getAdd() {
		return this.add;
	}

	public FundsLife getAdded() {
		FundsLife added = this.add;
		this.add = new FundsLife();
		return added;
	}
}
