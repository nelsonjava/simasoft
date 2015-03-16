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

import co.simasoft.models.pruebas.prueba.TiposOpciones;
import co.simasoft.models.pruebas.prueba.Opciones;
import java.util.Iterator;

/**
 * Backing bean for TiposOpciones entities.
 * <p/>
 * This class provides CRUD functionality for all TiposOpciones entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class TiposOpcionesBean implements Serializable
{

   private static final long serialVersionUID = 1L;

   /*
    * Support creating and retrieving TiposOpciones entities
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

   private TiposOpciones tiposOpciones;

   public TiposOpciones getTiposOpciones()
   {
      return this.tiposOpciones;
   }

   public void setTiposOpciones(TiposOpciones tiposOpciones)
   {
      this.tiposOpciones = tiposOpciones;
   }

   @Inject
   private Conversation conversation;

   @PersistenceContext(unitName = "pruebaPU-JTA", type = PersistenceContextType.EXTENDED)
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
         this.tiposOpciones = this.example;
      }
      else
      {
         this.tiposOpciones = findById(getId());
      }
   }

   public TiposOpciones findById(Long id)
   {

      return this.entityManager.find(TiposOpciones.class, id);
   }

   /*
    * Support updating and deleting TiposOpciones entities
    */

   public String update()
   {
      this.conversation.end();

      try
      {
         if (this.id == null)
         {
            this.entityManager.persist(this.tiposOpciones);
            return "search?faces-redirect=true";
         }
         else
         {
            this.entityManager.merge(this.tiposOpciones);
            return "view?faces-redirect=true&id=" + this.tiposOpciones.getId();
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
         TiposOpciones deletableEntity = findById(getId());
         Iterator<Opciones> iterOpciones = deletableEntity.getOpciones().iterator();
         for (; iterOpciones.hasNext();)
         {
            Opciones nextInOpciones = iterOpciones.next();
            nextInOpciones.setTiposOpciones(null);
            iterOpciones.remove();
            this.entityManager.merge(nextInOpciones);
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
    * Support searching TiposOpciones entities with pagination
    */

   private int page;
   private long count;
   private List<TiposOpciones> pageItems;

   private TiposOpciones example = new TiposOpciones();

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

   public TiposOpciones getExample()
   {
      return this.example;
   }

   public void setExample(TiposOpciones example)
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
      Root<TiposOpciones> root = countCriteria.from(TiposOpciones.class);
      countCriteria = countCriteria.select(builder.count(root)).where(
            getSearchPredicates(root));
      this.count = this.entityManager.createQuery(countCriteria)
            .getSingleResult();

      // Populate this.pageItems

      CriteriaQuery<TiposOpciones> criteria = builder.createQuery(TiposOpciones.class);
      root = criteria.from(TiposOpciones.class);
      TypedQuery<TiposOpciones> query = this.entityManager.createQuery(criteria
            .select(root).where(getSearchPredicates(root)));
      query.setFirstResult(this.page * getPageSize()).setMaxResults(
            getPageSize());
      this.pageItems = query.getResultList();
   }

   private Predicate[] getSearchPredicates(Root<TiposOpciones> root)
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

   public List<TiposOpciones> getPageItems()
   {
      return this.pageItems;
   }

   public long getCount()
   {
      return this.count;
   }

   /*
    * Support listing and POSTing back TiposOpciones entities (e.g. from inside an
    * HtmlSelectOneMenu)
    */

   public List<TiposOpciones> getAll()
   {

      CriteriaQuery<TiposOpciones> criteria = this.entityManager
            .getCriteriaBuilder().createQuery(TiposOpciones.class);
      return this.entityManager.createQuery(
            criteria.select(criteria.from(TiposOpciones.class))).getResultList();
   }

   @Resource
   private SessionContext sessionContext;

   public Converter getConverter()
   {

      final TiposOpcionesBean ejbProxy = this.sessionContext.getBusinessObject(TiposOpcionesBean.class);

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

            return String.valueOf(((TiposOpciones) value).getId());
         }
      };
   }

   /*
    * Support adding children to bidirectional, one-to-many tables
    */

   private TiposOpciones add = new TiposOpciones();

   public TiposOpciones getAdd()
   {
      return this.add;
   }

   public TiposOpciones getAdded()
   {
      TiposOpciones added = this.add;
      this.add = new TiposOpciones();
      return added;
   }
}
