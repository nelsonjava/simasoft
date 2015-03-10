package co.simasoft.contab.view;

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

import co.simasoft.models.base.empresas.Cargos;
import co.simasoft.models.base.empresas.Empleados;
import co.simasoft.models.base.empresas.TiposCargos;

/**
 * Backing bean for Cargos entities.
 * <p/>
 * This class provides CRUD functionality for all Cargos entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class CargosBean implements Serializable
{

   private static final long serialVersionUID = 1L;

   /*
    * Support creating and retrieving Cargos entities
    */

   private Long id;

   public Long getId()
   {
      return this.id;
   }

   public void setId(Long id)
   {
      this.id = id;
   }

   private Cargos cargos;

   public Cargos getCargos()
   {
      return this.cargos;
   }

   public void setCargos(Cargos cargos)
   {
      this.cargos = cargos;
   }

   @Inject
   private Conversation conversation;

   @PersistenceContext(unitName = "contabilidadPU-JTA", type = PersistenceContextType.EXTENDED)
   private EntityManager entityManager;

   public String create()
   {

      this.conversation.begin();
      this.conversation.setTimeout(1800000L);
      return "create?faces-redirect=true";
   }

   public void retrieve()
   {

      if (FacesContext.getCurrentInstance().isPostback())
      {
         return;
      }

      if (this.conversation.isTransient())
      {
         this.conversation.begin();
         this.conversation.setTimeout(1800000L);
      }

      if (this.id == null)
      {
         this.cargos = this.example;
      }
      else
      {
         this.cargos = findById(getId());
      }
   }

   public Cargos findById(Long id)
   {

      return this.entityManager.find(Cargos.class, id);
   }

   /*
    * Support updating and deleting Cargos entities
    */

   public String update()
   {
      this.conversation.end();

      try
      {
         if (this.id == null)
         {
            this.entityManager.persist(this.cargos);
            return "search?faces-redirect=true";
         }
         else
         {
            this.entityManager.merge(this.cargos);
            return "view?faces-redirect=true&id=" + this.cargos.getId();
         }
      }
      catch (Exception e)
      {
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
         return null;
      }
   }

   public String delete()
   {
      this.conversation.end();

      try
      {
         Cargos deletableEntity = findById(getId());
         Empleados empleados = deletableEntity.getEmpleados();
         empleados.getCargos().remove(deletableEntity);
         deletableEntity.setEmpleados(null);
         this.entityManager.merge(empleados);
         TiposCargos tiposCargos = deletableEntity.getTiposCargos();
         tiposCargos.getCargos().remove(deletableEntity);
         deletableEntity.setTiposCargos(null);
         this.entityManager.merge(tiposCargos);
         this.entityManager.remove(deletableEntity);
         this.entityManager.flush();
         return "search?faces-redirect=true";
      }
      catch (Exception e)
      {
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
         return null;
      }
   }

   /*
    * Support searching Cargos entities with pagination
    */

   private int page;
   private long count;
   private List<Cargos> pageItems;

   private Cargos example = new Cargos();

   public int getPage()
   {
      return this.page;
   }

   public void setPage(int page)
   {
      this.page = page;
   }

   public int getPageSize()
   {
      return 10;
   }

   public Cargos getExample()
   {
      return this.example;
   }

   public void setExample(Cargos example)
   {
      this.example = example;
   }

   public String search()
   {
      this.page = 0;
      return null;
   }

   public void paginate()
   {

      CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();

      // Populate this.count

      CriteriaQuery<Long> countCriteria = builder.createQuery(Long.class);
      Root<Cargos> root = countCriteria.from(Cargos.class);
      countCriteria = countCriteria.select(builder.count(root)).where(
            getSearchPredicates(root));
      this.count = this.entityManager.createQuery(countCriteria)
            .getSingleResult();

      // Populate this.pageItems

      CriteriaQuery<Cargos> criteria = builder.createQuery(Cargos.class);
      root = criteria.from(Cargos.class);
      TypedQuery<Cargos> query = this.entityManager.createQuery(criteria
            .select(root).where(getSearchPredicates(root)));
      query.setFirstResult(this.page * getPageSize()).setMaxResults(
            getPageSize());
      this.pageItems = query.getResultList();
   }

   private Predicate[] getSearchPredicates(Root<Cargos> root)
   {

      CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
      List<Predicate> predicatesList = new ArrayList<Predicate>();

      String nombre = this.example.getNombre();
      if (nombre != null && !"".equals(nombre))
      {
         predicatesList.add(builder.like(builder.lower(root.<String> get("nombre")), '%' + nombre.toLowerCase() + '%'));
      }
      Empleados empleados = this.example.getEmpleados();
      if (empleados != null)
      {
         predicatesList.add(builder.equal(root.get("empleados"), empleados));
      }
      TiposCargos tiposCargos = this.example.getTiposCargos();
      if (tiposCargos != null)
      {
         predicatesList.add(builder.equal(root.get("tiposCargos"), tiposCargos));
      }

      return predicatesList.toArray(new Predicate[predicatesList.size()]);
   }

   public List<Cargos> getPageItems()
   {
      return this.pageItems;
   }

   public long getCount()
   {
      return this.count;
   }

   /*
    * Support listing and POSTing back Cargos entities (e.g. from inside an
    * HtmlSelectOneMenu)
    */

   public List<Cargos> getAll()
   {

      CriteriaQuery<Cargos> criteria = this.entityManager
            .getCriteriaBuilder().createQuery(Cargos.class);
      return this.entityManager.createQuery(
            criteria.select(criteria.from(Cargos.class))).getResultList();
   }

   @Resource
   private SessionContext sessionContext;

   public Converter getConverter()
   {

      final CargosBean ejbProxy = this.sessionContext.getBusinessObject(CargosBean.class);

      return new Converter()
      {

         @Override
         public Object getAsObject(FacesContext context,
               UIComponent component, String value)
         {

            return ejbProxy.findById(Long.valueOf(value));
         }

         @Override
         public String getAsString(FacesContext context,
               UIComponent component, Object value)
         {

            if (value == null)
            {
               return "";
            }

            return String.valueOf(((Cargos) value).getId());
         }
      };
   }

   /*
    * Support adding children to bidirectional, one-to-many tables
    */

   private Cargos add = new Cargos();

   public Cargos getAdd()
   {
      return this.add;
   }

   public Cargos getAdded()
   {
      Cargos added = this.add;
      this.add = new Cargos();
      return added;
   }
}
