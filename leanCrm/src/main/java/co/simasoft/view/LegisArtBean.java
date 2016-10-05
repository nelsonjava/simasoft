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

import co.simasoft.models.LegisArt;
import co.simasoft.models.Legis;
import co.simasoft.models.LegisArtSubject;
import java.util.Iterator;

/**
 * Backing bean for LegisArt entities.
 * <p/>
 * This class provides CRUD functionality for all LegisArt entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class LegisArtBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving LegisArt entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private LegisArt legisArt;

	public LegisArt getLegisArt() {
		return this.legisArt;
	}

	public void setLegisArt(LegisArt legisArt) {
		this.legisArt = legisArt;
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
			this.legisArt = this.example;
		} else {
			this.legisArt = findById(getId());
		}
	}

	public LegisArt findById(Long id) {

		return this.entityManager.find(LegisArt.class, id);
	}

	/*
	 * Support updating and deleting LegisArt entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.legisArt);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.legisArt);
				return "view?faces-redirect=true&id=" + this.legisArt.getId();
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
			LegisArt deletableEntity = findById(getId());
			Iterator<LegisArtSubject> iterLegisArtSubject = deletableEntity
					.getLegisArtSubject().iterator();
			for (; iterLegisArtSubject.hasNext();) {
				LegisArtSubject nextInLegisArtSubject = iterLegisArtSubject
						.next();
				nextInLegisArtSubject.setLegisArt(null);
				iterLegisArtSubject.remove();
				this.entityManager.merge(nextInLegisArtSubject);
			}
			Legis legis = deletableEntity.getLegis();
			legis.getLegisArt().remove(deletableEntity);
			deletableEntity.setLegis(null);
			this.entityManager.merge(legis);
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
	 * Support searching LegisArt entities with pagination
	 */

	private int page;
	private long count;
	private List<LegisArt> pageItems;

	private LegisArt example = new LegisArt();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public LegisArt getExample() {
		return this.example;
	}

	public void setExample(LegisArt example) {
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
		Root<LegisArt> root = countCriteria.from(LegisArt.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<LegisArt> criteria = builder.createQuery(LegisArt.class);
		root = criteria.from(LegisArt.class);
		TypedQuery<LegisArt> query = this.entityManager.createQuery(criteria
				.select(root).where(getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<LegisArt> root) {

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
		String content = this.example.getContent();
		if (content != null && !"".equals(content)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("content")),
					'%' + content.toLowerCase() + '%'));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<LegisArt> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back LegisArt entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<LegisArt> getAll() {

		CriteriaQuery<LegisArt> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(LegisArt.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(LegisArt.class))).getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final LegisArtBean ejbProxy = this.sessionContext
				.getBusinessObject(LegisArtBean.class);

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

				return String.valueOf(((LegisArt) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private LegisArt add = new LegisArt();

	public LegisArt getAdd() {
		return this.add;
	}

	public LegisArt getAdded() {
		LegisArt added = this.add;
		this.add = new LegisArt();
		return added;
	}
}
