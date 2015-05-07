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

import co.simasoft.models.naif.domainmodels.LinksModels;
import co.simasoft.models.naif.domainmodels.GroupIds;
import co.simasoft.models.naif.domainmodels.TiposLinksModels;

/**
 * Backing bean for LinksModels entities.
 * <p/>
 * This class provides CRUD functionality for all LinksModels entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class LinksModelsBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving LinksModels entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private LinksModels linksModels;

	public LinksModels getLinksModels() {
		return this.linksModels;
	}

	public void setLinksModels(LinksModels linksModels) {
		this.linksModels = linksModels;
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
			this.linksModels = this.example;
		} else {
			this.linksModels = findById(getId());
		}
	}

	public LinksModels findById(Long id) {

		return this.entityManager.find(LinksModels.class, id);
	}

	/*
	 * Support updating and deleting LinksModels entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.linksModels);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.linksModels);
				return "view?faces-redirect=true&id="
						+ this.linksModels.getId();
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
			LinksModels deletableEntity = findById(getId());
			GroupIds groupIds = deletableEntity.getGroupIds();
			groupIds.getLinksModels().remove(deletableEntity);
			deletableEntity.setGroupIds(null);
			this.entityManager.merge(groupIds);
			TiposLinksModels tiposLinksModels = deletableEntity
					.getTiposLinksModels();
			tiposLinksModels.getLinksModels().remove(deletableEntity);
			deletableEntity.setTiposLinksModels(null);
			this.entityManager.merge(tiposLinksModels);
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
	 * Support searching LinksModels entities with pagination
	 */

	private int page;
	private long count;
	private List<LinksModels> pageItems;

	private LinksModels example = new LinksModels();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public LinksModels getExample() {
		return this.example;
	}

	public void setExample(LinksModels example) {
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
		Root<LinksModels> root = countCriteria.from(LinksModels.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<LinksModels> criteria = builder
				.createQuery(LinksModels.class);
		root = criteria.from(LinksModels.class);
		TypedQuery<LinksModels> query = this.entityManager.createQuery(criteria
				.select(root).where(getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<LinksModels> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		long orden = this.example.getOrden();
		if (orden != 0) {
			predicatesList.add(builder.equal(root.get("orden"), orden));
		}
		String observaciones = this.example.getObservaciones();
		if (observaciones != null && !"".equals(observaciones)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("observaciones")),
					'%' + observaciones.toLowerCase() + '%'));
		}
		String link = this.example.getLink();
		if (link != null && !"".equals(link)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("link")),
					'%' + link.toLowerCase() + '%'));
		}
		String titulo = this.example.getTitulo();
		if (titulo != null && !"".equals(titulo)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("titulo")),
					'%' + titulo.toLowerCase() + '%'));
		}
		GroupIds groupIds = this.example.getGroupIds();
		if (groupIds != null) {
			predicatesList.add(builder.equal(root.get("groupIds"), groupIds));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<LinksModels> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back LinksModels entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<LinksModels> getAll() {

		CriteriaQuery<LinksModels> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(LinksModels.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(LinksModels.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final LinksModelsBean ejbProxy = this.sessionContext
				.getBusinessObject(LinksModelsBean.class);

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

				return String.valueOf(((LinksModels) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private LinksModels add = new LinksModels();

	public LinksModels getAdd() {
		return this.add;
	}

	public LinksModels getAdded() {
		LinksModels added = this.add;
		this.add = new LinksModels();
		return added;
	}
}
