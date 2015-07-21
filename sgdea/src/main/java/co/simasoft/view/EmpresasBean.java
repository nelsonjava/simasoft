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

import co.simasoft.models.naif.sgdea.Empresas;
import co.simasoft.models.naif.sgdea.FondosDocumentales;
import java.util.Iterator;

/**
 * Backing bean for Empresas entities.
 * <p/>
 * This class provides CRUD functionality for all Empresas entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class EmpresasBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving Empresas entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Empresas empresas;

	public Empresas getEmpresas() {
		return this.empresas;
	}

	public void setEmpresas(Empresas empresas) {
		this.empresas = empresas;
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
			this.empresas = this.example;
		} else {
			this.empresas = findById(getId());
		}
	}

	public Empresas findById(Long id) {

		return this.entityManager.find(Empresas.class, id);
	}

	/*
	 * Support updating and deleting Empresas entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.empresas);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.empresas);
				return "view?faces-redirect=true&id=" + this.empresas.getId();
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
			Empresas deletableEntity = findById(getId());
			Iterator<FondosDocumentales> iterFondosDocumentales = deletableEntity
					.getFondosDocumentales().iterator();
			for (; iterFondosDocumentales.hasNext();) {
				FondosDocumentales nextInFondosDocumentales = iterFondosDocumentales
						.next();
				nextInFondosDocumentales.setEmpresas(null);
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
	 * Support searching Empresas entities with pagination
	 */

	private int page;
	private long count;
	private List<Empresas> pageItems;

	private Empresas example = new Empresas();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public Empresas getExample() {
		return this.example;
	}

	public void setExample(Empresas example) {
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
		Root<Empresas> root = countCriteria.from(Empresas.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<Empresas> criteria = builder.createQuery(Empresas.class);
		root = criteria.from(Empresas.class);
		TypedQuery<Empresas> query = this.entityManager.createQuery(criteria
				.select(root).where(getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<Empresas> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		String nombre = this.example.getNombre();
		if (nombre != null && !"".equals(nombre)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("nombre")),
					'%' + nombre.toLowerCase() + '%'));
		}
		String nit = this.example.getNit();
		if (nit != null && !"".equals(nit)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("nit")),
					'%' + nit.toLowerCase() + '%'));
		}
		String direccion = this.example.getDireccion();
		if (direccion != null && !"".equals(direccion)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("direccion")),
					'%' + direccion.toLowerCase() + '%'));
		}
		String link = this.example.getLink();
		if (link != null && !"".equals(link)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("link")),
					'%' + link.toLowerCase() + '%'));
		}
		String tels = this.example.getTels();
		if (tels != null && !"".equals(tels)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("tels")),
					'%' + tels.toLowerCase() + '%'));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<Empresas> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back Empresas entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<Empresas> getAll() {

		CriteriaQuery<Empresas> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(Empresas.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(Empresas.class))).getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final EmpresasBean ejbProxy = this.sessionContext
				.getBusinessObject(EmpresasBean.class);

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

				return String.valueOf(((Empresas) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private Empresas add = new Empresas();

	public Empresas getAdd() {
		return this.add;
	}

	public Empresas getAdded() {
		Empresas added = this.add;
		this.add = new Empresas();
		return added;
	}
}
