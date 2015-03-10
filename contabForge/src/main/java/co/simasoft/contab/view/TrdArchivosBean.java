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

import co.simasoft.models.iso.lmr.TrdArchivos;
import co.simasoft.models.iso.lmr.Lmrs;
import java.util.Iterator;

/**
 * Backing bean for TrdArchivos entities.
 * <p/>
 * This class provides CRUD functionality for all TrdArchivos entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class TrdArchivosBean implements Serializable
{

   private static final long serialVersionUID = 1L;

   /*
    * Support creating and retrieving TrdArchivos entities
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

   private TrdArchivos trdArchivos;

   public TrdArchivos getTrdArchivos()
   {
      return this.trdArchivos;
   }

   public void setTrdArchivos(TrdArchivos trdArchivos)
   {
      this.trdArchivos = trdArchivos;
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
         this.trdArchivos = this.example;
      }
      else
      {
         this.trdArchivos = findById(getId());
      }
   }

   public TrdArchivos findById(Long id)
   {

      return this.entityManager.find(TrdArchivos.class, id);
   }

   /*
    * Support updating and deleting TrdArchivos entities
    */

   public String update()
   {
      this.conversation.end();

      try
      {
         if (this.id == null)
         {
            this.entityManager.persist(this.trdArchivos);
            return "search?faces-redirect=true";
         }
         else
         {
            this.entityManager.merge(this.trdArchivos);
            return "view?faces-redirect=true&id=" + this.trdArchivos.getId();
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
         TrdArchivos deletableEntity = findById(getId());
         Iterator<Lmrs> iterLmrs = deletableEntity.getLmrs().iterator();
         for (; iterLmrs.hasNext();)
         {
            Lmrs nextInLmrs = iterLmrs.next();
            nextInLmrs.setTrdArchivos(null);
            iterLmrs.remove();
            this.entityManager.merge(nextInLmrs);
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
    * Support searching TrdArchivos entities with pagination
    */

   private int page;
   private long count;
   private List<TrdArchivos> pageItems;

   private TrdArchivos example = new TrdArchivos();

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

   public TrdArchivos getExample()
   {
      return this.example;
   }

   public void setExample(TrdArchivos example)
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
      Root<TrdArchivos> root = countCriteria.from(TrdArchivos.class);
      countCriteria = countCriteria.select(builder.count(root)).where(
            getSearchPredicates(root));
      this.count = this.entityManager.createQuery(countCriteria)
            .getSingleResult();

      // Populate this.pageItems

      CriteriaQuery<TrdArchivos> criteria = builder.createQuery(TrdArchivos.class);
      root = criteria.from(TrdArchivos.class);
      TypedQuery<TrdArchivos> query = this.entityManager.createQuery(criteria
            .select(root).where(getSearchPredicates(root)));
      query.setFirstResult(this.page * getPageSize()).setMaxResults(
            getPageSize());
      this.pageItems = query.getResultList();
   }

   private Predicate[] getSearchPredicates(Root<TrdArchivos> root)
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

   public List<TrdArchivos> getPageItems()
   {
      return this.pageItems;
   }

   public long getCount()
   {
      return this.count;
   }

   /*
    * Support listing and POSTing back TrdArchivos entities (e.g. from inside an
    * HtmlSelectOneMenu)
    */

   public List<TrdArchivos> getAll()
   {

      CriteriaQuery<TrdArchivos> criteria = this.entityManager
            .getCriteriaBuilder().createQuery(TrdArchivos.class);
      return this.entityManager.createQuery(
            criteria.select(criteria.from(TrdArchivos.class))).getResultList();
   }

   @Resource
   private SessionContext sessionContext;

   public Converter getConverter()
   {

      final TrdArchivosBean ejbProxy = this.sessionContext.getBusinessObject(TrdArchivosBean.class);

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

            return String.valueOf(((TrdArchivos) value).getId());
         }
      };
   }

   /*
    * Support adding children to bidirectional, one-to-many tables
    */

   private TrdArchivos add = new TrdArchivos();

   public TrdArchivos getAdd()
   {
      return this.add;
   }

   public TrdArchivos getAdded()
   {
      TrdArchivos added = this.add;
      this.add = new TrdArchivos();
      return added;
   }
}
