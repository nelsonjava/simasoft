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

import co.simasoft.models.naif.sgdea.InventarioDocumental;
import co.simasoft.models.naif.sgdea.FinalidadInventario;
import co.simasoft.models.naif.sgdea.UnidadesDocumentales;

/**
 * Backing bean for InventarioDocumental entities.
 * <p/>
 * This class provides CRUD functionality for all InventarioDocumental entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class InventarioDocumentalBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving InventarioDocumental entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private InventarioDocumental inventarioDocumental;

	public InventarioDocumental getInventarioDocumental() {
		return this.inventarioDocumental;
	}

	public void setInventarioDocumental(
			InventarioDocumental inventarioDocumental) {
		this.inventarioDocumental = inventarioDocumental;
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
			this.inventarioDocumental = this.example;
		} else {
			this.inventarioDocumental = findById(getId());
		}
	}

	public InventarioDocumental findById(Long id) {

		return this.entityManager.find(InventarioDocumental.class, id);
	}

	/*
	 * Support updating and deleting InventarioDocumental entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.inventarioDocumental);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.inventarioDocumental);
				return "view?faces-redirect=true&id="
						+ this.inventarioDocumental.getId();
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
			InventarioDocumental deletableEntity = findById(getId());
			UnidadesDocumentales unidadesDocumentales = deletableEntity
					.getUnidadesDocumentales();
			unidadesDocumentales.getInventarioDocumental().remove(
					deletableEntity);
			deletableEntity.setUnidadesDocumentales(null);
			this.entityManager.merge(unidadesDocumentales);
			FinalidadInventario finalidadInventario = deletableEntity
					.getFinalidadInventario();
			finalidadInventario.getInventarioDocumental().remove(
					deletableEntity);
			deletableEntity.setFinalidadInventario(null);
			this.entityManager.merge(finalidadInventario);
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
	 * Support searching InventarioDocumental entities with pagination
	 */

	private int page;
	private long count;
	private List<InventarioDocumental> pageItems;

	private InventarioDocumental example = new InventarioDocumental();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public InventarioDocumental getExample() {
		return this.example;
	}

	public void setExample(InventarioDocumental example) {
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
		Root<InventarioDocumental> root = countCriteria
				.from(InventarioDocumental.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<InventarioDocumental> criteria = builder
				.createQuery(InventarioDocumental.class);
		root = criteria.from(InventarioDocumental.class);
		TypedQuery<InventarioDocumental> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<InventarioDocumental> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		Integer cantidad = this.example.getCantidad();
		if (cantidad != null && cantidad.intValue() != 0) {
			predicatesList.add(builder.equal(root.get("cantidad"), cantidad));
		}
		Integer folios = this.example.getFolios();
		if (folios != null && folios.intValue() != 0) {
			predicatesList.add(builder.equal(root.get("folios"), folios));
		}
		String disposcionFinal = this.example.getDisposcionFinal();
		if (disposcionFinal != null && !"".equals(disposcionFinal)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("disposcionFinal")),
					'%' + disposcionFinal.toLowerCase() + '%'));
		}
		Integer nroTransferencia = this.example.getNroTransferencia();
		if (nroTransferencia != null && nroTransferencia.intValue() != 0) {
			predicatesList.add(builder.equal(root.get("nroTransferencia"),
					nroTransferencia));
		}
		UnidadesDocumentales unidadesDocumentales = this.example
				.getUnidadesDocumentales();
		if (unidadesDocumentales != null) {
			predicatesList.add(builder.equal(root.get("unidadesDocumentales"),
					unidadesDocumentales));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<InventarioDocumental> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back InventarioDocumental entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<InventarioDocumental> getAll() {

		CriteriaQuery<InventarioDocumental> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(InventarioDocumental.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(InventarioDocumental.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final InventarioDocumentalBean ejbProxy = this.sessionContext
				.getBusinessObject(InventarioDocumentalBean.class);

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

				return String.valueOf(((InventarioDocumental) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private InventarioDocumental add = new InventarioDocumental();

	public InventarioDocumental getAdd() {
		return this.add;
	}

	public InventarioDocumental getAdded() {
		InventarioDocumental added = this.add;
		this.add = new InventarioDocumental();
		return added;
	}
}
