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

import co.simasoft.models.naif.sgdea.VigenciaFondos;
import co.simasoft.models.naif.sgdea.FondosDocumentales;
import java.lang.Boolean;
import java.util.Iterator;

/**
 * Backing bean for VigenciaFondos entities.
 * <p/>
 * This class provides CRUD functionality for all VigenciaFondos entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class VigenciaFondosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving VigenciaFondos entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private VigenciaFondos vigenciaFondos;

	public VigenciaFondos getVigenciaFondos() {
		return this.vigenciaFondos;
	}

	public void setVigenciaFondos(VigenciaFondos vigenciaFondos) {
		this.vigenciaFondos = vigenciaFondos;
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
			this.vigenciaFondos = this.example;
		} else {
			this.vigenciaFondos = findById(getId());
		}
	}

	public VigenciaFondos findById(Long id) {

		return this.entityManager.find(VigenciaFondos.class, id);
	}

	/*
	 * Support updating and deleting VigenciaFondos entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.vigenciaFondos);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.vigenciaFondos);
				return "view?faces-redirect=true&id="
						+ this.vigenciaFondos.getId();
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
			VigenciaFondos deletableEntity = findById(getId());
			Iterator<FondosDocumentales> iterFondosDocumentales = deletableEntity
					.getFondosDocumentales().iterator();
			for (; iterFondosDocumentales.hasNext();) {
				FondosDocumentales nextInFondosDocumentales = iterFondosDocumentales
						.next();
				nextInFondosDocumentales.setVigenciaFondos(null);
				iterFondosDocumentales.remove();
				this.entityManager.merge(nextInFondosDocumentales);
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
	 * Support searching VigenciaFondos entities with pagination
	 */

	private int page;
	private long count;
	private List<VigenciaFondos> pageItems;

	private VigenciaFondos example = new VigenciaFondos();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public VigenciaFondos getExample() {
		return this.example;
	}

	public void setExample(VigenciaFondos example) {
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
		Root<VigenciaFondos> root = countCriteria.from(VigenciaFondos.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<VigenciaFondos> criteria = builder
				.createQuery(VigenciaFondos.class);
		root = criteria.from(VigenciaFondos.class);
		TypedQuery<VigenciaFondos> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<VigenciaFondos> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		String observaciones = this.example.getObservaciones();
		if (observaciones != null && !"".equals(observaciones)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("observaciones")),
					'%' + observaciones.toLowerCase() + '%'));
		}
		Boolean siAbierto = this.example.getSiAbierto();
		if (siAbierto != null) {
			predicatesList.add(builder.equal(root.get("siAbierto"), siAbierto));
		}
		String nombre = this.example.getNombre();
		if (nombre != null && !"".equals(nombre)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("nombre")),
					'%' + nombre.toLowerCase() + '%'));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<VigenciaFondos> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back VigenciaFondos entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<VigenciaFondos> getAll() {

		CriteriaQuery<VigenciaFondos> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(VigenciaFondos.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(VigenciaFondos.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final VigenciaFondosBean ejbProxy = this.sessionContext
				.getBusinessObject(VigenciaFondosBean.class);

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

				return String.valueOf(((VigenciaFondos) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private VigenciaFondos add = new VigenciaFondos();

	public VigenciaFondos getAdd() {
		return this.add;
	}

	public VigenciaFondos getAdded() {
		VigenciaFondos added = this.add;
		this.add = new VigenciaFondos();
		return added;
	}
}
