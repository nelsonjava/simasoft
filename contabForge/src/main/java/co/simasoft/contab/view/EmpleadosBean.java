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

import co.simasoft.models.base.empresas.Empleados;
import co.simasoft.models.base.empresas.Cargos;
import co.simasoft.models.base.empresas.Empresas;
import co.simasoft.models.base.personas.Personas;
import java.util.Iterator;

/**
 * Backing bean for Empleados entities.
 * <p/>
 * This class provides CRUD functionality for all Empleados entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class EmpleadosBean implements Serializable
{

   private static final long serialVersionUID = 1L;

   /*
    * Support creating and retrieving Empleados entities
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

   private Empleados empleados;

   public Empleados getEmpleados()
   {
      return this.empleados;
   }

   public void setEmpleados(Empleados empleados)
   {
      this.empleados = empleados;
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
         this.empleados = this.example;
      }
      else
      {
         this.empleados = findById(getId());
      }
   }

   public Empleados findById(Long id)
   {

      return this.entityManager.find(Empleados.class, id);
   }

   /*
    * Support updating and deleting Empleados entities
    */

   public String update()
   {
      this.conversation.end();

      try
      {
         if (this.id == null)
         {
            this.entityManager.persist(this.empleados);
            return "search?faces-redirect=true";
         }
         else
         {
            this.entityManager.merge(this.empleados);
            return "view?faces-redirect=true&id=" + this.empleados.getId();
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
         Empleados deletableEntity = findById(getId());
         Empresas empresas = deletableEntity.getEmpresas();
         empresas.getEmpleados().remove(deletableEntity);
         deletableEntity.setEmpresas(null);
         this.entityManager.merge(empresas);
         Iterator<Cargos> iterCargos = deletableEntity.getCargos().iterator();
         for (; iterCargos.hasNext();)
         {
            Cargos nextInCargos = iterCargos.next();
            nextInCargos.setEmpleados(null);
            iterCargos.remove();
            this.entityManager.merge(nextInCargos);
         }
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
    * Support searching Empleados entities with pagination
    */

   private int page;
   private long count;
   private List<Empleados> pageItems;

   private Empleados example = new Empleados();

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

   public Empleados getExample()
   {
      return this.example;
   }

   public void setExample(Empleados example)
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
      Root<Empleados> root = countCriteria.from(Empleados.class);
      countCriteria = countCriteria.select(builder.count(root)).where(
            getSearchPredicates(root));
      this.count = this.entityManager.createQuery(countCriteria)
            .getSingleResult();

      // Populate this.pageItems

      CriteriaQuery<Empleados> criteria = builder.createQuery(Empleados.class);
      root = criteria.from(Empleados.class);
      TypedQuery<Empleados> query = this.entityManager.createQuery(criteria
            .select(root).where(getSearchPredicates(root)));
      query.setFirstResult(this.page * getPageSize()).setMaxResults(
            getPageSize());
      this.pageItems = query.getResultList();
   }

   private Predicate[] getSearchPredicates(Root<Empleados> root)
   {

      CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
      List<Predicate> predicatesList = new ArrayList<Predicate>();

      String descripcion = this.example.getDescripcion();
      if (descripcion != null && !"".equals(descripcion))
      {
         predicatesList.add(builder.like(builder.lower(root.<String> get("descripcion")), '%' + descripcion.toLowerCase() + '%'));
      }
      Personas personas = this.example.getPersonas();
      if (personas != null)
      {
         predicatesList.add(builder.equal(root.get("personas"), personas));
      }
      Empresas empresas = this.example.getEmpresas();
      if (empresas != null)
      {
         predicatesList.add(builder.equal(root.get("empresas"), empresas));
      }

      return predicatesList.toArray(new Predicate[predicatesList.size()]);
   }

   public List<Empleados> getPageItems()
   {
      return this.pageItems;
   }

   public long getCount()
   {
      return this.count;
   }

   /*
    * Support listing and POSTing back Empleados entities (e.g. from inside an
    * HtmlSelectOneMenu)
    */

   public List<Empleados> getAll()
   {

      CriteriaQuery<Empleados> criteria = this.entityManager
            .getCriteriaBuilder().createQuery(Empleados.class);
      return this.entityManager.createQuery(
            criteria.select(criteria.from(Empleados.class))).getResultList();
   }

   @Resource
   private SessionContext sessionContext;

   public Converter getConverter()
   {

      final EmpleadosBean ejbProxy = this.sessionContext.getBusinessObject(EmpleadosBean.class);

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

            return String.valueOf(((Empleados) value).getId());
         }
      };
   }

   /*
    * Support adding children to bidirectional, one-to-many tables
    */

   private Empleados add = new Empleados();

   public Empleados getAdd()
   {
      return this.add;
   }

   public Empleados getAdded()
   {
      Empleados added = this.add;
      this.add = new Empleados();
      return added;
   }
}
