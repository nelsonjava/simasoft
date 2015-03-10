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

import co.simasoft.models.base.empresas.TiposCargos;
import co.simasoft.models.base.empresas.Cargos;
import java.util.Iterator;

/**
 * Backing bean for TiposCargos entities.
 * <p/>
 * This class provides CRUD functionality for all TiposCargos entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class TiposCargosBean implements Serializable
{

   private static final long serialVersionUID = 1L;

   /*
    * Support creating and retrieving TiposCargos entities
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

   private TiposCargos tiposCargos;

   public TiposCargos getTiposCargos()
   {
      return this.tiposCargos;
   }

   public void setTiposCargos(TiposCargos tiposCargos)
   {
      this.tiposCargos = tiposCargos;
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
         this.tiposCargos = this.example;
      }
      else
      {
         this.tiposCargos = findById(getId());
      }
   }

   public TiposCargos findById(Long id)
   {

      return this.entityManager.find(TiposCargos.class, id);
   }

   /*
    * Support updating and deleting TiposCargos entities
    */

   public String update()
   {
      this.conversation.end();

      try
      {
         if (this.id == null)
         {
            this.entityManager.persist(this.tiposCargos);
            return "search?faces-redirect=true";
         }
         else
         {
            this.entityManager.merge(this.tiposCargos);
            return "view?faces-redirect=true&id=" + this.tiposCargos.getId();
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
         TiposCargos deletableEntity = findById(getId());
         Iterator<Cargos> iterCargos = deletableEntity.getCargos().iterator();
         for (; iterCargos.hasNext();)
         {
            Cargos nextInCargos = iterCargos.next();
            nextInCargos.setTiposCargos(null);
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
    * Support searching TiposCargos entities with pagination
    */

   private int page;
   private long count;
   private List<TiposCargos> pageItems;

   private TiposCargos example = new TiposCargos();

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

   public TiposCargos getExample()
   {
      return this.example;
   }

   public void setExample(TiposCargos example)
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
      Root<TiposCargos> root = countCriteria.from(TiposCargos.class);
      countCriteria = countCriteria.select(builder.count(root)).where(
            getSearchPredicates(root));
      this.count = this.entityManager.createQuery(countCriteria)
            .getSingleResult();

      // Populate this.pageItems

      CriteriaQuery<TiposCargos> criteria = builder.createQuery(TiposCargos.class);
      root = criteria.from(TiposCargos.class);
      TypedQuery<TiposCargos> query = this.entityManager.createQuery(criteria
            .select(root).where(getSearchPredicates(root)));
      query.setFirstResult(this.page * getPageSize()).setMaxResults(
            getPageSize());
      this.pageItems = query.getResultList();
   }

   private Predicate[] getSearchPredicates(Root<TiposCargos> root)
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

   public List<TiposCargos> getPageItems()
   {
      return this.pageItems;
   }

   public long getCount()
   {
      return this.count;
   }

   /*
    * Support listing and POSTing back TiposCargos entities (e.g. from inside an
    * HtmlSelectOneMenu)
    */

   public List<TiposCargos> getAll()
   {

      CriteriaQuery<TiposCargos> criteria = this.entityManager
            .getCriteriaBuilder().createQuery(TiposCargos.class);
      return this.entityManager.createQuery(
            criteria.select(criteria.from(TiposCargos.class))).getResultList();
   }

   @Resource
   private SessionContext sessionContext;

   public Converter getConverter()
   {

      final TiposCargosBean ejbProxy = this.sessionContext.getBusinessObject(TiposCargosBean.class);

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

            return String.valueOf(((TiposCargos) value).getId());
         }
      };
   }

   /*
    * Support adding children to bidirectional, one-to-many tables
    */

   private TiposCargos add = new TiposCargos();

   public TiposCargos getAdd()
   {
      return this.add;
   }

   public TiposCargos getAdded()
   {
      TiposCargos added = this.add;
      this.add = new TiposCargos();
      return added;
   }
}
