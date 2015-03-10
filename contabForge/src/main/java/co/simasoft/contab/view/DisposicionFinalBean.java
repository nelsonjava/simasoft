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

import co.simasoft.models.iso.lmr.DisposicionFinal;
import co.simasoft.models.iso.lmr.Lmrs;
import java.util.Iterator;

/**
 * Backing bean for DisposicionFinal entities.
 * <p/>
 * This class provides CRUD functionality for all DisposicionFinal entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class DisposicionFinalBean implements Serializable
{

   private static final long serialVersionUID = 1L;

   /*
    * Support creating and retrieving DisposicionFinal entities
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

   private DisposicionFinal disposicionFinal;

   public DisposicionFinal getDisposicionFinal()
   {
      return this.disposicionFinal;
   }

   public void setDisposicionFinal(DisposicionFinal disposicionFinal)
   {
      this.disposicionFinal = disposicionFinal;
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
         this.disposicionFinal = this.example;
      }
      else
      {
         this.disposicionFinal = findById(getId());
      }
   }

   public DisposicionFinal findById(Long id)
   {

      return this.entityManager.find(DisposicionFinal.class, id);
   }

   /*
    * Support updating and deleting DisposicionFinal entities
    */

   public String update()
   {
      this.conversation.end();

      try
      {
         if (this.id == null)
         {
            this.entityManager.persist(this.disposicionFinal);
            return "search?faces-redirect=true";
         }
         else
         {
            this.entityManager.merge(this.disposicionFinal);
            return "view?faces-redirect=true&id=" + this.disposicionFinal.getId();
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
         DisposicionFinal deletableEntity = findById(getId());
         Iterator<Lmrs> iterLmrs = deletableEntity.getLmrs().iterator();
         for (; iterLmrs.hasNext();)
         {
            Lmrs nextInLmrs = iterLmrs.next();
            nextInLmrs.setDisposicionFinal(null);
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
    * Support searching DisposicionFinal entities with pagination
    */

   private int page;
   private long count;
   private List<DisposicionFinal> pageItems;

   private DisposicionFinal example = new DisposicionFinal();

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

   public DisposicionFinal getExample()
   {
      return this.example;
   }

   public void setExample(DisposicionFinal example)
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
      Root<DisposicionFinal> root = countCriteria.from(DisposicionFinal.class);
      countCriteria = countCriteria.select(builder.count(root)).where(
            getSearchPredicates(root));
      this.count = this.entityManager.createQuery(countCriteria)
            .getSingleResult();

      // Populate this.pageItems

      CriteriaQuery<DisposicionFinal> criteria = builder.createQuery(DisposicionFinal.class);
      root = criteria.from(DisposicionFinal.class);
      TypedQuery<DisposicionFinal> query = this.entityManager.createQuery(criteria
            .select(root).where(getSearchPredicates(root)));
      query.setFirstResult(this.page * getPageSize()).setMaxResults(
            getPageSize());
      this.pageItems = query.getResultList();
   }

   private Predicate[] getSearchPredicates(Root<DisposicionFinal> root)
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

   public List<DisposicionFinal> getPageItems()
   {
      return this.pageItems;
   }

   public long getCount()
   {
      return this.count;
   }

   /*
    * Support listing and POSTing back DisposicionFinal entities (e.g. from inside an
    * HtmlSelectOneMenu)
    */

   public List<DisposicionFinal> getAll()
   {

      CriteriaQuery<DisposicionFinal> criteria = this.entityManager
            .getCriteriaBuilder().createQuery(DisposicionFinal.class);
      return this.entityManager.createQuery(
            criteria.select(criteria.from(DisposicionFinal.class))).getResultList();
   }

   @Resource
   private SessionContext sessionContext;

   public Converter getConverter()
   {

      final DisposicionFinalBean ejbProxy = this.sessionContext.getBusinessObject(DisposicionFinalBean.class);

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

            return String.valueOf(((DisposicionFinal) value).getId());
         }
      };
   }

   /*
    * Support adding children to bidirectional, one-to-many tables
    */

   private DisposicionFinal add = new DisposicionFinal();

   public DisposicionFinal getAdd()
   {
      return this.add;
   }

   public DisposicionFinal getAdded()
   {
      DisposicionFinal added = this.add;
      this.add = new DisposicionFinal();
      return added;
   }
}
