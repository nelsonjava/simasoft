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

import co.simasoft.models.base.direcciones.TiposEdificaciones;
import co.simasoft.models.base.direcciones.Direcciones;
import java.util.Iterator;

/**
 * Backing bean for TiposEdificaciones entities.
 * <p/>
 * This class provides CRUD functionality for all TiposEdificaciones entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class TiposEdificacionesBean implements Serializable
{

   private static final long serialVersionUID = 1L;

   /*
    * Support creating and retrieving TiposEdificaciones entities
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

   private TiposEdificaciones tiposEdificaciones;

   public TiposEdificaciones getTiposEdificaciones()
   {
      return this.tiposEdificaciones;
   }

   public void setTiposEdificaciones(TiposEdificaciones tiposEdificaciones)
   {
      this.tiposEdificaciones = tiposEdificaciones;
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
         this.tiposEdificaciones = this.example;
      }
      else
      {
         this.tiposEdificaciones = findById(getId());
      }
   }

   public TiposEdificaciones findById(Long id)
   {

      return this.entityManager.find(TiposEdificaciones.class, id);
   }

   /*
    * Support updating and deleting TiposEdificaciones entities
    */

   public String update()
   {
      this.conversation.end();

      try
      {
         if (this.id == null)
         {
            this.entityManager.persist(this.tiposEdificaciones);
            return "search?faces-redirect=true";
         }
         else
         {
            this.entityManager.merge(this.tiposEdificaciones);
            return "view?faces-redirect=true&id=" + this.tiposEdificaciones.getId();
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
         TiposEdificaciones deletableEntity = findById(getId());
         Iterator<Direcciones> iterDirecciones = deletableEntity.getDirecciones().iterator();
         for (; iterDirecciones.hasNext();)
         {
            Direcciones nextInDirecciones = iterDirecciones.next();
            nextInDirecciones.setTiposEdificaciones(null);
            iterDirecciones.remove();
            this.entityManager.merge(nextInDirecciones);
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
    * Support searching TiposEdificaciones entities with pagination
    */

   private int page;
   private long count;
   private List<TiposEdificaciones> pageItems;

   private TiposEdificaciones example = new TiposEdificaciones();

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

   public TiposEdificaciones getExample()
   {
      return this.example;
   }

   public void setExample(TiposEdificaciones example)
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
      Root<TiposEdificaciones> root = countCriteria.from(TiposEdificaciones.class);
      countCriteria = countCriteria.select(builder.count(root)).where(
            getSearchPredicates(root));
      this.count = this.entityManager.createQuery(countCriteria)
            .getSingleResult();

      // Populate this.pageItems

      CriteriaQuery<TiposEdificaciones> criteria = builder.createQuery(TiposEdificaciones.class);
      root = criteria.from(TiposEdificaciones.class);
      TypedQuery<TiposEdificaciones> query = this.entityManager.createQuery(criteria
            .select(root).where(getSearchPredicates(root)));
      query.setFirstResult(this.page * getPageSize()).setMaxResults(
            getPageSize());
      this.pageItems = query.getResultList();
   }

   private Predicate[] getSearchPredicates(Root<TiposEdificaciones> root)
   {

      CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
      List<Predicate> predicatesList = new ArrayList<Predicate>();

      String nombre = this.example.getNombre();
      if (nombre != null && !"".equals(nombre))
      {
         predicatesList.add(builder.like(builder.lower(root.<String> get("nombre")), '%' + nombre.toLowerCase() + '%'));
      }

      return predicatesList.toArray(new Predicate[predicatesList.size()]);
   }

   public List<TiposEdificaciones> getPageItems()
   {
      return this.pageItems;
   }

   public long getCount()
   {
      return this.count;
   }

   /*
    * Support listing and POSTing back TiposEdificaciones entities (e.g. from inside an
    * HtmlSelectOneMenu)
    */

   public List<TiposEdificaciones> getAll()
   {

      CriteriaQuery<TiposEdificaciones> criteria = this.entityManager
            .getCriteriaBuilder().createQuery(TiposEdificaciones.class);
      return this.entityManager.createQuery(
            criteria.select(criteria.from(TiposEdificaciones.class))).getResultList();
   }

   @Resource
   private SessionContext sessionContext;

   public Converter getConverter()
   {

      final TiposEdificacionesBean ejbProxy = this.sessionContext.getBusinessObject(TiposEdificacionesBean.class);

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

            return String.valueOf(((TiposEdificaciones) value).getId());
         }
      };
   }

   /*
    * Support adding children to bidirectional, one-to-many tables
    */

   private TiposEdificaciones add = new TiposEdificaciones();

   public TiposEdificaciones getAdd()
   {
      return this.add;
   }

   public TiposEdificaciones getAdded()
   {
      TiposEdificaciones added = this.add;
      this.add = new TiposEdificaciones();
      return added;
   }
}
