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

import co.simasoft.models.base.sistemas.TiposSistemas;
import co.simasoft.models.base.sistemas.Sistemas;
import java.util.Iterator;

/**
 * Backing bean for TiposSistemas entities.
 * <p/>
 * This class provides CRUD functionality for all TiposSistemas entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class TiposSistemasBean implements Serializable
{

   private static final long serialVersionUID = 1L;

   /*
    * Support creating and retrieving TiposSistemas entities
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

   private TiposSistemas tiposSistemas;

   public TiposSistemas getTiposSistemas()
   {
      return this.tiposSistemas;
   }

   public void setTiposSistemas(TiposSistemas tiposSistemas)
   {
      this.tiposSistemas = tiposSistemas;
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
         this.tiposSistemas = this.example;
      }
      else
      {
         this.tiposSistemas = findById(getId());
      }
   }

   public TiposSistemas findById(Long id)
   {

      return this.entityManager.find(TiposSistemas.class, id);
   }

   /*
    * Support updating and deleting TiposSistemas entities
    */

   public String update()
   {
      this.conversation.end();

      try
      {
         if (this.id == null)
         {
            this.entityManager.persist(this.tiposSistemas);
            return "search?faces-redirect=true";
         }
         else
         {
            this.entityManager.merge(this.tiposSistemas);
            return "view?faces-redirect=true&id=" + this.tiposSistemas.getId();
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
         TiposSistemas deletableEntity = findById(getId());
         Iterator<Sistemas> iterSistemas = deletableEntity.getSistemas().iterator();
         for (; iterSistemas.hasNext();)
         {
            Sistemas nextInSistemas = iterSistemas.next();
            nextInSistemas.setTiposSistemas(null);
            iterSistemas.remove();
            this.entityManager.merge(nextInSistemas);
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
    * Support searching TiposSistemas entities with pagination
    */

   private int page;
   private long count;
   private List<TiposSistemas> pageItems;

   private TiposSistemas example = new TiposSistemas();

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

   public TiposSistemas getExample()
   {
      return this.example;
   }

   public void setExample(TiposSistemas example)
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
      Root<TiposSistemas> root = countCriteria.from(TiposSistemas.class);
      countCriteria = countCriteria.select(builder.count(root)).where(
            getSearchPredicates(root));
      this.count = this.entityManager.createQuery(countCriteria)
            .getSingleResult();

      // Populate this.pageItems

      CriteriaQuery<TiposSistemas> criteria = builder.createQuery(TiposSistemas.class);
      root = criteria.from(TiposSistemas.class);
      TypedQuery<TiposSistemas> query = this.entityManager.createQuery(criteria
            .select(root).where(getSearchPredicates(root)));
      query.setFirstResult(this.page * getPageSize()).setMaxResults(
            getPageSize());
      this.pageItems = query.getResultList();
   }

   private Predicate[] getSearchPredicates(Root<TiposSistemas> root)
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

   public List<TiposSistemas> getPageItems()
   {
      return this.pageItems;
   }

   public long getCount()
   {
      return this.count;
   }

   /*
    * Support listing and POSTing back TiposSistemas entities (e.g. from inside an
    * HtmlSelectOneMenu)
    */

   public List<TiposSistemas> getAll()
   {

      CriteriaQuery<TiposSistemas> criteria = this.entityManager
            .getCriteriaBuilder().createQuery(TiposSistemas.class);
      return this.entityManager.createQuery(
            criteria.select(criteria.from(TiposSistemas.class))).getResultList();
   }

   @Resource
   private SessionContext sessionContext;

   public Converter getConverter()
   {

      final TiposSistemasBean ejbProxy = this.sessionContext.getBusinessObject(TiposSistemasBean.class);

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

            return String.valueOf(((TiposSistemas) value).getId());
         }
      };
   }

   /*
    * Support adding children to bidirectional, one-to-many tables
    */

   private TiposSistemas add = new TiposSistemas();

   public TiposSistemas getAdd()
   {
      return this.add;
   }

   public TiposSistemas getAdded()
   {
      TiposSistemas added = this.add;
      this.add = new TiposSistemas();
      return added;
   }
}
