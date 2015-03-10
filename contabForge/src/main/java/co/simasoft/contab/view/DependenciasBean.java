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

import co.simasoft.models.iso.lmr.Dependencias;
import co.simasoft.models.iso.lmr.Lmrs;
import java.util.Iterator;

/**
 * Backing bean for Dependencias entities.
 * <p/>
 * This class provides CRUD functionality for all Dependencias entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class DependenciasBean implements Serializable
{

   private static final long serialVersionUID = 1L;

   /*
    * Support creating and retrieving Dependencias entities
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

   private Dependencias dependencias;

   public Dependencias getDependencias()
   {
      return this.dependencias;
   }

   public void setDependencias(Dependencias dependencias)
   {
      this.dependencias = dependencias;
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
         this.dependencias = this.example;
      }
      else
      {
         this.dependencias = findById(getId());
      }
   }

   public Dependencias findById(Long id)
   {

      return this.entityManager.find(Dependencias.class, id);
   }

   /*
    * Support updating and deleting Dependencias entities
    */

   public String update()
   {
      this.conversation.end();

      try
      {
         if (this.id == null)
         {
            this.entityManager.persist(this.dependencias);
            return "search?faces-redirect=true";
         }
         else
         {
            this.entityManager.merge(this.dependencias);
            return "view?faces-redirect=true&id=" + this.dependencias.getId();
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
         Dependencias deletableEntity = findById(getId());
         Iterator<Lmrs> iterLmrs = deletableEntity.getLmrs().iterator();
         for (; iterLmrs.hasNext();)
         {
            Lmrs nextInLmrs = iterLmrs.next();
            nextInLmrs.setDependencias(null);
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
    * Support searching Dependencias entities with pagination
    */

   private int page;
   private long count;
   private List<Dependencias> pageItems;

   private Dependencias example = new Dependencias();

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

   public Dependencias getExample()
   {
      return this.example;
   }

   public void setExample(Dependencias example)
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
      Root<Dependencias> root = countCriteria.from(Dependencias.class);
      countCriteria = countCriteria.select(builder.count(root)).where(
            getSearchPredicates(root));
      this.count = this.entityManager.createQuery(countCriteria)
            .getSingleResult();

      // Populate this.pageItems

      CriteriaQuery<Dependencias> criteria = builder.createQuery(Dependencias.class);
      root = criteria.from(Dependencias.class);
      TypedQuery<Dependencias> query = this.entityManager.createQuery(criteria
            .select(root).where(getSearchPredicates(root)));
      query.setFirstResult(this.page * getPageSize()).setMaxResults(
            getPageSize());
      this.pageItems = query.getResultList();
   }

   private Predicate[] getSearchPredicates(Root<Dependencias> root)
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

   public List<Dependencias> getPageItems()
   {
      return this.pageItems;
   }

   public long getCount()
   {
      return this.count;
   }

   /*
    * Support listing and POSTing back Dependencias entities (e.g. from inside an
    * HtmlSelectOneMenu)
    */

   public List<Dependencias> getAll()
   {

      CriteriaQuery<Dependencias> criteria = this.entityManager
            .getCriteriaBuilder().createQuery(Dependencias.class);
      return this.entityManager.createQuery(
            criteria.select(criteria.from(Dependencias.class))).getResultList();
   }

   @Resource
   private SessionContext sessionContext;

   public Converter getConverter()
   {

      final DependenciasBean ejbProxy = this.sessionContext.getBusinessObject(DependenciasBean.class);

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

            return String.valueOf(((Dependencias) value).getId());
         }
      };
   }

   /*
    * Support adding children to bidirectional, one-to-many tables
    */

   private Dependencias add = new Dependencias();

   public Dependencias getAdd()
   {
      return this.add;
   }

   public Dependencias getAdded()
   {
      Dependencias added = this.add;
      this.add = new Dependencias();
      return added;
   }
}
