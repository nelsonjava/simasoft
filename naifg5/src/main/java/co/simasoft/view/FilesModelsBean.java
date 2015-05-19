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

import co.simasoft.models.naif.domainmodels.FilesModels;
import co.simasoft.models.naif.domainmodels.DomainModels;
import co.simasoft.models.naif.domainmodels.Entities;
import co.simasoft.models.naif.domainmodels.GroupIds;
import co.simasoft.models.naif.domainmodels.SystemsModels;

/**
 * Backing bean for FilesModels entities.
 * <p/>
 * This class provides CRUD functionality for all FilesModels entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class FilesModelsBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving FilesModels entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private FilesModels filesModels;

	public FilesModels getFilesModels() {
		return this.filesModels;
	}

	public void setFilesModels(FilesModels filesModels) {
		this.filesModels = filesModels;
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
			this.filesModels = this.example;
		} else {
			this.filesModels = findById(getId());
		}
	}

	public FilesModels findById(Long id) {

		return this.entityManager.find(FilesModels.class, id);
	}

	/*
	 * Support updating and deleting FilesModels entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.filesModels);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.filesModels);
				return "view?faces-redirect=true&id="
						+ this.filesModels.getId();
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
			FilesModels deletableEntity = findById(getId());
			GroupIds groupIds = deletableEntity.getGroupIds();
			groupIds.getFilesModels().remove(deletableEntity);
			deletableEntity.setGroupIds(null);
			this.entityManager.merge(groupIds);
			Entities entities = deletableEntity.getEntities();
			entities.getFilesModels().remove(deletableEntity);
			deletableEntity.setEntities(null);
			this.entityManager.merge(entities);
			SystemsModels systemsModels = deletableEntity.getSystemsModels();
			systemsModels.getFilesModels().remove(deletableEntity);
			deletableEntity.setSystemsModels(null);
			this.entityManager.merge(systemsModels);
			DomainModels domainModels = deletableEntity.getDomainModels();
			domainModels.getFilesModels().remove(deletableEntity);
			deletableEntity.setDomainModels(null);
			this.entityManager.merge(domainModels);
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
	 * Support searching FilesModels entities with pagination
	 */

	private int page;
	private long count;
	private List<FilesModels> pageItems;

	private FilesModels example = new FilesModels();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public FilesModels getExample() {
		return this.example;
	}

	public void setExample(FilesModels example) {
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
		Root<FilesModels> root = countCriteria.from(FilesModels.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<FilesModels> criteria = builder
				.createQuery(FilesModels.class);
		root = criteria.from(FilesModels.class);
		TypedQuery<FilesModels> query = this.entityManager.createQuery(criteria
				.select(root).where(getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<FilesModels> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		long orden = this.example.getOrden();
		if (orden != 0) {
			predicatesList.add(builder.equal(root.get("orden"), orden));
		}
		String archivo = this.example.getArchivo();
		if (archivo != null && !"".equals(archivo)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("archivo")),
					'%' + archivo.toLowerCase() + '%'));
		}
		String extension = this.example.getExtension();
		if (extension != null && !"".equals(extension)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("extension")),
					'%' + extension.toLowerCase() + '%'));
		}
		byte data = this.example.getData();
		if (data != 0) {
			predicatesList.add(builder.equal(root.get("data"), data));
		}
		String observaciones = this.example.getObservaciones();
		if (observaciones != null && !"".equals(observaciones)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("observaciones")),
					'%' + observaciones.toLowerCase() + '%'));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<FilesModels> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back FilesModels entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<FilesModels> getAll() {

		CriteriaQuery<FilesModels> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(FilesModels.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(FilesModels.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final FilesModelsBean ejbProxy = this.sessionContext
				.getBusinessObject(FilesModelsBean.class);

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

				return String.valueOf(((FilesModels) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private FilesModels add = new FilesModels();

	public FilesModels getAdd() {
		return this.add;
	}

	public FilesModels getAdded() {
		FilesModels added = this.add;
		this.add = new FilesModels();
		return added;
	}
}
