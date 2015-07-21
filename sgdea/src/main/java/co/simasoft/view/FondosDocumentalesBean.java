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

import co.simasoft.models.naif.sgdea.FondosDocumentales;
import co.simasoft.models.naif.sgdea.Empresas;
import co.simasoft.models.naif.sgdea.Secciones;
import co.simasoft.models.naif.sgdea.VigenciaFondos;
import java.util.Iterator;

/**
 * Backing bean for FondosDocumentales entities.
 * <p/>
 * This class provides CRUD functionality for all FondosDocumentales entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class FondosDocumentalesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving FondosDocumentales entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private FondosDocumentales fondosDocumentales;

	public FondosDocumentales getFondosDocumentales() {
		return this.fondosDocumentales;
	}

	public void setFondosDocumentales(FondosDocumentales fondosDocumentales) {
		this.fondosDocumentales = fondosDocumentales;
	}

	@Inject
	private Conversation conversation;

	@PersistenceContext(unitName = "sgdeaPU-JTA", type = PersistenceContextType.EXTENDED)
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
			this.fondosDocumentales = this.example;
		} else {
			this.fondosDocumentales = findById(getId());
		}
	}

	public FondosDocumentales findById(Long id) {

		return this.entityManager.find(FondosDocumentales.class, id);
	}

	/*
	 * Support updating and deleting FondosDocumentales entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.fondosDocumentales);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.fondosDocumentales);
				return "view?faces-redirect=true&id="
						+ this.fondosDocumentales.getId();
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
			FondosDocumentales deletableEntity = findById(getId());
			Iterator<Secciones> iterSecciones = deletableEntity.getSecciones()
					.iterator();
			for (; iterSecciones.hasNext();) {
				Secciones nextInSecciones = iterSecciones.next();
				nextInSecciones.setFondosDocumentales(null);
				iterSecciones.remove();
				this.entityManager.merge(nextInSecciones);
			}
			VigenciaFondos vigenciaFondos = deletableEntity.getVigenciaFondos();
			vigenciaFondos.getFondosDocumentales().remove(deletableEntity);
			deletableEntity.setVigenciaFondos(null);
			this.entityManager.merge(vigenciaFondos);
			Empresas empresas = deletableEntity.getEmpresas();
			empresas.getFondosDocumentales().remove(deletableEntity);
			deletableEntity.setEmpresas(null);
			this.entityManager.merge(empresas);
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
	 * Support searching FondosDocumentales entities with pagination
	 */

	private int page;
	private long count;
	private List<FondosDocumentales> pageItems;

	private FondosDocumentales example = new FondosDocumentales();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public FondosDocumentales getExample() {
		return this.example;
	}

	public void setExample(FondosDocumentales example) {
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
		Root<FondosDocumentales> root = countCriteria
				.from(FondosDocumentales.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<FondosDocumentales> criteria = builder
				.createQuery(FondosDocumentales.class);
		root = criteria.from(FondosDocumentales.class);
		TypedQuery<FondosDocumentales> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<FondosDocumentales> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		String organismos = this.example.getOrganismos();
		if (organismos != null && !"".equals(organismos)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("organismos")),
					'%' + organismos.toLowerCase() + '%'));
		}
		String nombre = this.example.getNombre();
		if (nombre != null && !"".equals(nombre)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("nombre")),
					'%' + nombre.toLowerCase() + '%'));
		}
		String disposiciones = this.example.getDisposiciones();
		if (disposiciones != null && !"".equals(disposiciones)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("disposiciones")),
					'%' + disposiciones.toLowerCase() + '%'));
		}
		VigenciaFondos vigenciaFondos = this.example.getVigenciaFondos();
		if (vigenciaFondos != null) {
			predicatesList.add(builder.equal(root.get("vigenciaFondos"),
					vigenciaFondos));
		}
		Empresas empresas = this.example.getEmpresas();
		if (empresas != null) {
			predicatesList.add(builder.equal(root.get("empresas"), empresas));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<FondosDocumentales> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back FondosDocumentales entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<FondosDocumentales> getAll() {

		CriteriaQuery<FondosDocumentales> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(FondosDocumentales.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(FondosDocumentales.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final FondosDocumentalesBean ejbProxy = this.sessionContext
				.getBusinessObject(FondosDocumentalesBean.class);

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

				return String.valueOf(((FondosDocumentales) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private FondosDocumentales add = new FondosDocumentales();

	public FondosDocumentales getAdd() {
		return this.add;
	}

	public FondosDocumentales getAdded() {
		FondosDocumentales added = this.add;
		this.add = new FondosDocumentales();
		return added;
	}
}
