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

import co.simasoft.models.base.direcciones.Direcciones;
import co.simasoft.models.base.direcciones.Direccioness;
import co.simasoft.models.base.direcciones.TiposEdificaciones;
import java.util.Iterator;

/**
 * Backing bean for Direcciones entities.
 * <p/>
 * This class provides CRUD functionality for all Direcciones entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class DireccionesBean implements Serializable
{

   private static final long serialVersionUID = 1L;

   /*
    * Support creating and retrieving Direcciones entities
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

   private Direcciones direcciones;

   public Direcciones getDirecciones()
   {
      return this.direcciones;
   }

   public void setDirecciones(Direcciones direcciones)
   {
      this.direcciones = direcciones;
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
         this.direcciones = this.example;
      }
      else
      {
         this.direcciones = findById(getId());
      }
   }

   public Direcciones findById(Long id)
   {

      return this.entityManager.find(Direcciones.class, id);
   }

   /*
    * Support updating and deleting Direcciones entities
    */

   public String update()
   {
      this.conversation.end();

      try
      {
         if (this.id == null)
         {
            this.entityManager.persist(this.direcciones);
            return "search?faces-redirect=true";
         }
         else
         {
            this.entityManager.merge(this.direcciones);
            return "view?faces-redirect=true&id=" + this.direcciones.getId();
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
         Direcciones deletableEntity = findById(getId());
         Direcciones objPadre = deletableEntity.getObjPadre();
         objPadre.getObjHijos().remove(deletableEntity);
         deletableEntity.setObjPadre(null);
         this.entityManager.merge(objPadre);
         Direccioness direccioness = deletableEntity.getDireccioness();
         direccioness.getDirecciones().remove(deletableEntity);
         deletableEntity.setDireccioness(null);
         this.entityManager.merge(direccioness);
         TiposEdificaciones tiposEdificaciones = deletableEntity.getTiposEdificaciones();
         tiposEdificaciones.getDirecciones().remove(deletableEntity);
         deletableEntity.setTiposEdificaciones(null);
         this.entityManager.merge(tiposEdificaciones);
         Iterator<Direcciones> iterObjHijos = deletableEntity.getObjHijos().iterator();
         for (; iterObjHijos.hasNext();)
         {
            Direcciones nextInObjHijos = iterObjHijos.next();
            nextInObjHijos.setObjPadre(null);
            iterObjHijos.remove();
            this.entityManager.merge(nextInObjHijos);
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
    * Support searching Direcciones entities with pagination
    */

   private int page;
   private long count;
   private List<Direcciones> pageItems;

   private Direcciones example = new Direcciones();

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

   public Direcciones getExample()
   {
      return this.example;
   }

   public void setExample(Direcciones example)
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
      Root<Direcciones> root = countCriteria.from(Direcciones.class);
      countCriteria = countCriteria.select(builder.count(root)).where(
            getSearchPredicates(root));
      this.count = this.entityManager.createQuery(countCriteria)
            .getSingleResult();

      // Populate this.pageItems

      CriteriaQuery<Direcciones> criteria = builder.createQuery(Direcciones.class);
      root = criteria.from(Direcciones.class);
      TypedQuery<Direcciones> query = this.entityManager.createQuery(criteria
            .select(root).where(getSearchPredicates(root)));
      query.setFirstResult(this.page * getPageSize()).setMaxResults(
            getPageSize());
      this.pageItems = query.getResultList();
   }

   private Predicate[] getSearchPredicates(Root<Direcciones> root)
   {

      CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
      List<Predicate> predicatesList = new ArrayList<Predicate>();

      String direccionCompleta = this.example.getDireccionCompleta();
      if (direccionCompleta != null && !"".equals(direccionCompleta))
      {
         predicatesList.add(builder.like(builder.lower(root.<String> get("direccionCompleta")), '%' + direccionCompleta.toLowerCase() + '%'));
      }
      String ubicacionBase = this.example.getUbicacionBase();
      if (ubicacionBase != null && !"".equals(ubicacionBase))
      {
         predicatesList.add(builder.like(builder.lower(root.<String> get("ubicacionBase")), '%' + ubicacionBase.toLowerCase() + '%'));
      }
      String prefijoBase = this.example.getPrefijoBase();
      if (prefijoBase != null && !"".equals(prefijoBase))
      {
         predicatesList.add(builder.like(builder.lower(root.<String> get("prefijoBase")), '%' + prefijoBase.toLowerCase() + '%'));
      }
      String ubicacionCruce = this.example.getUbicacionCruce();
      if (ubicacionCruce != null && !"".equals(ubicacionCruce))
      {
         predicatesList.add(builder.like(builder.lower(root.<String> get("ubicacionCruce")), '%' + ubicacionCruce.toLowerCase() + '%'));
      }
      String prefijoCruce = this.example.getPrefijoCruce();
      if (prefijoCruce != null && !"".equals(prefijoCruce))
      {
         predicatesList.add(builder.like(builder.lower(root.<String> get("prefijoCruce")), '%' + prefijoCruce.toLowerCase() + '%'));
      }

      return predicatesList.toArray(new Predicate[predicatesList.size()]);
   }

   public List<Direcciones> getPageItems()
   {
      return this.pageItems;
   }

   public long getCount()
   {
      return this.count;
   }

   /*
    * Support listing and POSTing back Direcciones entities (e.g. from inside an
    * HtmlSelectOneMenu)
    */

   public List<Direcciones> getAll()
   {

      CriteriaQuery<Direcciones> criteria = this.entityManager
            .getCriteriaBuilder().createQuery(Direcciones.class);
      return this.entityManager.createQuery(
            criteria.select(criteria.from(Direcciones.class))).getResultList();
   }

   @Resource
   private SessionContext sessionContext;

   public Converter getConverter()
   {

      final DireccionesBean ejbProxy = this.sessionContext.getBusinessObject(DireccionesBean.class);

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

            return String.valueOf(((Direcciones) value).getId());
         }
      };
   }

   /*
    * Support adding children to bidirectional, one-to-many tables
    */

   private Direcciones add = new Direcciones();

   public Direcciones getAdd()
   {
      return this.add;
   }

   public Direcciones getAdded()
   {
      Direcciones added = this.add;
      this.add = new Direcciones();
      return added;
   }
}
