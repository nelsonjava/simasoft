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

import co.simasoft.models.iso.lmd.EstadosDocuementos;
import co.simasoft.models.iso.lmd.Lmds;
import java.util.Iterator;

/**
 * Backing bean for EstadosDocuementos entities.
 * <p/>
 * This class provides CRUD functionality for all EstadosDocuementos entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class EstadosDocuementosBean implements Serializable
{

   private static final long serialVersionUID = 1L;

   /*
    * Support creating and retrieving EstadosDocuementos entities
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

   private EstadosDocuementos estadosDocuementos;

   public EstadosDocuementos getEstadosDocuementos()
   {
      return this.estadosDocuementos;
   }

   public void setEstadosDocuementos(EstadosDocuementos estadosDocuementos)
   {
      this.estadosDocuementos = estadosDocuementos;
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
         this.estadosDocuementos = this.example;
      }
      else
      {
         this.estadosDocuementos = findById(getId());
      }
   }

   public EstadosDocuementos findById(Long id)
   {

      return this.entityManager.find(EstadosDocuementos.class, id);
   }

   /*
    * Support updating and deleting EstadosDocuementos entities
    */

   public String update()
   {
      this.conversation.end();

      try
      {
         if (this.id == null)
         {
            this.entityManager.persist(this.estadosDocuementos);
            return "search?faces-redirect=true";
         }
         else
         {
            this.entityManager.merge(this.estadosDocuementos);
            return "view?faces-redirect=true&id=" + this.estadosDocuementos.getId();
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
         EstadosDocuementos deletableEntity = findById(getId());
         Iterator<Lmds> iterLmds = deletableEntity.getLmds().iterator();
         for (; iterLmds.hasNext();)
         {
            Lmds nextInLmds = iterLmds.next();
            nextInLmds.setEstadosDocuementos(null);
            iterLmds.remove();
            this.entityManager.merge(nextInLmds);
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
    * Support searching EstadosDocuementos entities with pagination
    */

   private int page;
   private long count;
   private List<EstadosDocuementos> pageItems;

   private EstadosDocuementos example = new EstadosDocuementos();

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

   public EstadosDocuementos getExample()
   {
      return this.example;
   }

   public void setExample(EstadosDocuementos example)
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
      Root<EstadosDocuementos> root = countCriteria.from(EstadosDocuementos.class);
      countCriteria = countCriteria.select(builder.count(root)).where(
            getSearchPredicates(root));
      this.count = this.entityManager.createQuery(countCriteria)
            .getSingleResult();

      // Populate this.pageItems

      CriteriaQuery<EstadosDocuementos> criteria = builder.createQuery(EstadosDocuementos.class);
      root = criteria.from(EstadosDocuementos.class);
      TypedQuery<EstadosDocuementos> query = this.entityManager.createQuery(criteria
            .select(root).where(getSearchPredicates(root)));
      query.setFirstResult(this.page * getPageSize()).setMaxResults(
            getPageSize());
      this.pageItems = query.getResultList();
   }

   private Predicate[] getSearchPredicates(Root<EstadosDocuementos> root)
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

   public List<EstadosDocuementos> getPageItems()
   {
      return this.pageItems;
   }

   public long getCount()
   {
      return this.count;
   }

   /*
    * Support listing and POSTing back EstadosDocuementos entities (e.g. from inside an
    * HtmlSelectOneMenu)
    */

   public List<EstadosDocuementos> getAll()
   {

      CriteriaQuery<EstadosDocuementos> criteria = this.entityManager
            .getCriteriaBuilder().createQuery(EstadosDocuementos.class);
      return this.entityManager.createQuery(
            criteria.select(criteria.from(EstadosDocuementos.class))).getResultList();
   }

   @Resource
   private SessionContext sessionContext;

   public Converter getConverter()
   {

      final EstadosDocuementosBean ejbProxy = this.sessionContext.getBusinessObject(EstadosDocuementosBean.class);

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

            return String.valueOf(((EstadosDocuementos) value).getId());
         }
      };
   }

   /*
    * Support adding children to bidirectional, one-to-many tables
    */

   private EstadosDocuementos add = new EstadosDocuementos();

   public EstadosDocuementos getAdd()
   {
      return this.add;
   }

   public EstadosDocuementos getAdded()
   {
      EstadosDocuementos added = this.add;
      this.add = new EstadosDocuementos();
      return added;
   }
}
