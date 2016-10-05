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

import co.simasoft.models.Predio;
import co.simasoft.models.PhysicalSpaces;
import java.util.Iterator;

/**
 * Backing bean for Predio entities.
 * <p/>
 * This class provides CRUD functionality for all Predio entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class PredioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving Predio entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Predio predio;

	public Predio getPredio() {
		return this.predio;
	}

	public void setPredio(Predio predio) {
		this.predio = predio;
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
			this.predio = this.example;
		} else {
			this.predio = findById(getId());
		}
	}

	public Predio findById(Long id) {

		return this.entityManager.find(Predio.class, id);
	}

	/*
	 * Support updating and deleting Predio entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.predio);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.predio);
				return "view?faces-redirect=true&id=" + this.predio.getId();
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
			Predio deletableEntity = findById(getId());
			Iterator<PhysicalSpaces> iterPhysicalSpaces = deletableEntity
					.getPhysicalSpaces().iterator();
			for (; iterPhysicalSpaces.hasNext();) {
				PhysicalSpaces nextInPhysicalSpaces = iterPhysicalSpaces.next();
				nextInPhysicalSpaces.setPredio(null);
				iterPhysicalSpaces.remove();
				this.entityManager.merge(nextInPhysicalSpaces);
			}
			Iterator<Predio> iterObjHijos = deletableEntity.getObjHijos()
					.iterator();
			for (; iterObjHijos.hasNext();) {
				Predio nextInObjHijos = iterObjHijos.next();
				nextInObjHijos.setObjPadre(null);
				iterObjHijos.remove();
				this.entityManager.merge(nextInObjHijos);
			}
			Predio objPadre = deletableEntity.getObjPadre();
			objPadre.getObjHijos().remove(deletableEntity);
			deletableEntity.setObjPadre(null);
			this.entityManager.merge(objPadre);
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
	 * Support searching Predio entities with pagination
	 */

	private int page;
	private long count;
	private List<Predio> pageItems;

	private Predio example = new Predio();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public Predio getExample() {
		return this.example;
	}

	public void setExample(Predio example) {
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
		Root<Predio> root = countCriteria.from(Predio.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<Predio> criteria = builder.createQuery(Predio.class);
		root = criteria.from(Predio.class);
		TypedQuery<Predio> query = this.entityManager.createQuery(criteria
				.select(root).where(getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<Predio> root) {

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
		String nomenclatura = this.example.getNomenclatura();
		if (nomenclatura != null && !"".equals(nomenclatura)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("nomenclatura")),
					'%' + nomenclatura.toLowerCase() + '%'));
		}
		String predial = this.example.getPredial();
		if (predial != null && !"".equals(predial)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("predial")),
					'%' + predial.toLowerCase() + '%'));
		}
		String estrato = this.example.getEstrato();
		if (estrato != null && !"".equals(estrato)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("estrato")),
					'%' + estrato.toLowerCase() + '%'));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<Predio> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back Predio entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<Predio> getAll() {

		CriteriaQuery<Predio> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(Predio.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(Predio.class))).getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final PredioBean ejbProxy = this.sessionContext
				.getBusinessObject(PredioBean.class);

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

				return String.valueOf(((Predio) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private Predio add = new Predio();

	public Predio getAdd() {
		return this.add;
	}

	public Predio getAdded() {
		Predio added = this.add;
		this.add = new Predio();
		return added;
	}
}
