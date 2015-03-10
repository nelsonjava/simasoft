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

import co.simasoft.models.iso.procesos.Procesos;
import co.simasoft.models.iso.procesos.TiposProcesos;

/**
 * Backing bean for Procesos entities.
 * <p/>
 * This class provides CRUD functionality for all Procesos entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class ProcesosBean implements Serializable
{

   private static final long serialVersionUID = 1L;

   /*
    * Support creating and retrieving Procesos entities
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

   private Procesos procesos;

   public Procesos getProcesos()
   {
      return this.procesos;
   }

   public void setProcesos(Procesos procesos)
   {
      this.procesos = procesos;
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
         this.procesos = this.example;
      }
      else
      {
         this.procesos = findById(getId());
      }
   }

   public Procesos findById(Long id)
   {

      return this.entityManager.find(Procesos.class, id);
   }

   /*
    * Support updating and deleting Procesos entities
    */

   public String update()
   {
      this.conversation.end();

      try
      {
         if (this.id == null)
         {
            this.entityManager.persist(this.procesos);
            return "search?faces-redirect=true";
         }
         else
         {
            this.entityManager.merge(this.procesos);
            return "view?faces-redirect=true&id=" + this.procesos.getId();
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
         Procesos deletableEntity = findById(getId());
         TiposProcesos tiposProcesos = deletableEntity.getTiposProcesos();
         tiposProcesos.getProcesos().remove(deletableEntity);
         deletableEntity.setTiposProcesos(null);
         this.entityManager.merge(tiposProcesos);
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
    * Support searching Procesos entities with pagination
    */

   private int page;
   private long count;
   private List<Procesos> pageItems;

   private Procesos example = new Procesos();

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

   public Procesos getExample()
   {
      return this.example;
   }

   public void setExample(Procesos example)
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
      Root<Procesos> root = countCriteria.from(Procesos.class);
      countCriteria = countCriteria.select(builder.count(root)).where(
            getSearchPredicates(root));
      this.count = this.entityManager.createQuery(countCriteria)
            .getSingleResult();

      // Populate this.pageItems

      CriteriaQuery<Procesos> criteria = builder.createQuery(Procesos.class);
      root = criteria.from(Procesos.class);
      TypedQuery<Procesos> query = this.entityManager.createQuery(criteria
            .select(root).where(getSearchPredicates(root)));
      query.setFirstResult(this.page * getPageSize()).setMaxResults(
            getPageSize());
      this.pageItems = query.getResultList();
   }

   private Predicate[] getSearchPredicates(Root<Procesos> root)
   {

      CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
      List<Predicate> predicatesList = new ArrayList<Predicate>();

      String codigo = this.example.getCodigo();
      if (codigo != null && !"".equals(codigo))
      {
         predicatesList.add(builder.like(builder.lower(root.<String> get("codigo")), '%' + codigo.toLowerCase() + '%'));
      }
      String nombre = this.example.getNombre();
      if (nombre != null && !"".equals(nombre))
      {
         predicatesList.add(builder.like(builder.lower(root.<String> get("nombre")), '%' + nombre.toLowerCase() + '%'));
      }
      String observaciones = this.example.getObservaciones();
      if (observaciones != null && !"".equals(observaciones))
      {
         predicatesList.add(builder.like(builder.lower(root.<String> get("observaciones")), '%' + observaciones.toLowerCase() + '%'));
      }
      TiposProcesos tiposProcesos = this.example.getTiposProcesos();
      if (tiposProcesos != null)
      {
         predicatesList.add(builder.equal(root.get("tiposProcesos"), tiposProcesos));
      }

      return predicatesList.toArray(new Predicate[predicatesList.size()]);
   }

   public List<Procesos> getPageItems()
   {
      return this.pageItems;
   }

   public long getCount()
   {
      return this.count;
   }

   /*
    * Support listing and POSTing back Procesos entities (e.g. from inside an
    * HtmlSelectOneMenu)
    */

   public List<Procesos> getAll()
   {

      CriteriaQuery<Procesos> criteria = this.entityManager
            .getCriteriaBuilder().createQuery(Procesos.class);
      return this.entityManager.createQuery(
            criteria.select(criteria.from(Procesos.class))).getResultList();
   }

   @Resource
   private SessionContext sessionContext;

   public Converter getConverter()
   {

      final ProcesosBean ejbProxy = this.sessionContext.getBusinessObject(ProcesosBean.class);

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

            return String.valueOf(((Procesos) value).getId());
         }
      };
   }

   /*
    * Support adding children to bidirectional, one-to-many tables
    */

   private Procesos add = new Procesos();

   public Procesos getAdd()
   {
      return this.add;
   }

   public Procesos getAdded()
   {
      Procesos added = this.add;
      this.add = new Procesos();
      return added;
   }
}
