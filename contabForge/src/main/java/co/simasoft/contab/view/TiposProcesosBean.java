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

import co.simasoft.models.iso.procesos.TiposProcesos;
import co.simasoft.models.iso.procesos.Procesos;
import java.util.Iterator;

/**
 * Backing bean for TiposProcesos entities.
 * <p/>
 * This class provides CRUD functionality for all TiposProcesos entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class TiposProcesosBean implements Serializable
{

   private static final long serialVersionUID = 1L;

   /*
    * Support creating and retrieving TiposProcesos entities
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

   private TiposProcesos tiposProcesos;

   public TiposProcesos getTiposProcesos()
   {
      return this.tiposProcesos;
   }

   public void setTiposProcesos(TiposProcesos tiposProcesos)
   {
      this.tiposProcesos = tiposProcesos;
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
         this.tiposProcesos = this.example;
      }
      else
      {
         this.tiposProcesos = findById(getId());
      }
   }

   public TiposProcesos findById(Long id)
   {

      return this.entityManager.find(TiposProcesos.class, id);
   }

   /*
    * Support updating and deleting TiposProcesos entities
    */

   public String update()
   {
      this.conversation.end();

      try
      {
         if (this.id == null)
         {
            this.entityManager.persist(this.tiposProcesos);
            return "search?faces-redirect=true";
         }
         else
         {
            this.entityManager.merge(this.tiposProcesos);
            return "view?faces-redirect=true&id=" + this.tiposProcesos.getId();
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
         TiposProcesos deletableEntity = findById(getId());
         Iterator<Procesos> iterProcesos = deletableEntity.getProcesos().iterator();
         for (; iterProcesos.hasNext();)
         {
            Procesos nextInProcesos = iterProcesos.next();
            nextInProcesos.setTiposProcesos(null);
            iterProcesos.remove();
            this.entityManager.merge(nextInProcesos);
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
    * Support searching TiposProcesos entities with pagination
    */

   private int page;
   private long count;
   private List<TiposProcesos> pageItems;

   private TiposProcesos example = new TiposProcesos();

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

   public TiposProcesos getExample()
   {
      return this.example;
   }

   public void setExample(TiposProcesos example)
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
      Root<TiposProcesos> root = countCriteria.from(TiposProcesos.class);
      countCriteria = countCriteria.select(builder.count(root)).where(
            getSearchPredicates(root));
      this.count = this.entityManager.createQuery(countCriteria)
            .getSingleResult();

      // Populate this.pageItems

      CriteriaQuery<TiposProcesos> criteria = builder.createQuery(TiposProcesos.class);
      root = criteria.from(TiposProcesos.class);
      TypedQuery<TiposProcesos> query = this.entityManager.createQuery(criteria
            .select(root).where(getSearchPredicates(root)));
      query.setFirstResult(this.page * getPageSize()).setMaxResults(
            getPageSize());
      this.pageItems = query.getResultList();
   }

   private Predicate[] getSearchPredicates(Root<TiposProcesos> root)
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

      return predicatesList.toArray(new Predicate[predicatesList.size()]);
   }

   public List<TiposProcesos> getPageItems()
   {
      return this.pageItems;
   }

   public long getCount()
   {
      return this.count;
   }

   /*
    * Support listing and POSTing back TiposProcesos entities (e.g. from inside an
    * HtmlSelectOneMenu)
    */

   public List<TiposProcesos> getAll()
   {

      CriteriaQuery<TiposProcesos> criteria = this.entityManager
            .getCriteriaBuilder().createQuery(TiposProcesos.class);
      return this.entityManager.createQuery(
            criteria.select(criteria.from(TiposProcesos.class))).getResultList();
   }

   @Resource
   private SessionContext sessionContext;

   public Converter getConverter()
   {

      final TiposProcesosBean ejbProxy = this.sessionContext.getBusinessObject(TiposProcesosBean.class);

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

            return String.valueOf(((TiposProcesos) value).getId());
         }
      };
   }

   /*
    * Support adding children to bidirectional, one-to-many tables
    */

   private TiposProcesos add = new TiposProcesos();

   public TiposProcesos getAdd()
   {
      return this.add;
   }

   public TiposProcesos getAdded()
   {
      TiposProcesos added = this.add;
      this.add = new TiposProcesos();
      return added;
   }
}
