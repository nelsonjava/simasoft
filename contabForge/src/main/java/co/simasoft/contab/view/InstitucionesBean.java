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

import co.simasoft.models.iso.lmr.Instituciones;
import co.simasoft.models.iso.lmr.Lmrs;
import java.util.Iterator;

/**
 * Backing bean for Instituciones entities.
 * <p/>
 * This class provides CRUD functionality for all Instituciones entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class InstitucionesBean implements Serializable
{

   private static final long serialVersionUID = 1L;

   /*
    * Support creating and retrieving Instituciones entities
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

   private Instituciones instituciones;

   public Instituciones getInstituciones()
   {
      return this.instituciones;
   }

   public void setInstituciones(Instituciones instituciones)
   {
      this.instituciones = instituciones;
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
         this.instituciones = this.example;
      }
      else
      {
         this.instituciones = findById(getId());
      }
   }

   public Instituciones findById(Long id)
   {

      return this.entityManager.find(Instituciones.class, id);
   }

   /*
    * Support updating and deleting Instituciones entities
    */

   public String update()
   {
      this.conversation.end();

      try
      {
         if (this.id == null)
         {
            this.entityManager.persist(this.instituciones);
            return "search?faces-redirect=true";
         }
         else
         {
            this.entityManager.merge(this.instituciones);
            return "view?faces-redirect=true&id=" + this.instituciones.getId();
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
         Instituciones deletableEntity = findById(getId());
         Iterator<Lmrs> iterLmrs = deletableEntity.getLmrs().iterator();
         for (; iterLmrs.hasNext();)
         {
            Lmrs nextInLmrs = iterLmrs.next();
            nextInLmrs.setInstituciones(null);
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
    * Support searching Instituciones entities with pagination
    */

   private int page;
   private long count;
   private List<Instituciones> pageItems;

   private Instituciones example = new Instituciones();

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

   public Instituciones getExample()
   {
      return this.example;
   }

   public void setExample(Instituciones example)
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
      Root<Instituciones> root = countCriteria.from(Instituciones.class);
      countCriteria = countCriteria.select(builder.count(root)).where(
            getSearchPredicates(root));
      this.count = this.entityManager.createQuery(countCriteria)
            .getSingleResult();

      // Populate this.pageItems

      CriteriaQuery<Instituciones> criteria = builder.createQuery(Instituciones.class);
      root = criteria.from(Instituciones.class);
      TypedQuery<Instituciones> query = this.entityManager.createQuery(criteria
            .select(root).where(getSearchPredicates(root)));
      query.setFirstResult(this.page * getPageSize()).setMaxResults(
            getPageSize());
      this.pageItems = query.getResultList();
   }

   private Predicate[] getSearchPredicates(Root<Instituciones> root)
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

   public List<Instituciones> getPageItems()
   {
      return this.pageItems;
   }

   public long getCount()
   {
      return this.count;
   }

   /*
    * Support listing and POSTing back Instituciones entities (e.g. from inside an
    * HtmlSelectOneMenu)
    */

   public List<Instituciones> getAll()
   {

      CriteriaQuery<Instituciones> criteria = this.entityManager
            .getCriteriaBuilder().createQuery(Instituciones.class);
      return this.entityManager.createQuery(
            criteria.select(criteria.from(Instituciones.class))).getResultList();
   }

   @Resource
   private SessionContext sessionContext;

   public Converter getConverter()
   {

      final InstitucionesBean ejbProxy = this.sessionContext.getBusinessObject(InstitucionesBean.class);

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

            return String.valueOf(((Instituciones) value).getId());
         }
      };
   }

   /*
    * Support adding children to bidirectional, one-to-many tables
    */

   private Instituciones add = new Instituciones();

   public Instituciones getAdd()
   {
      return this.add;
   }

   public Instituciones getAdded()
   {
      Instituciones added = this.add;
      this.add = new Instituciones();
      return added;
   }
}
