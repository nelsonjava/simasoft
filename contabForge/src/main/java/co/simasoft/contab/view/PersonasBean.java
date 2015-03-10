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

import co.simasoft.models.base.personas.Personas;

/**
 * Backing bean for Personas entities.
 * <p/>
 * This class provides CRUD functionality for all Personas entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class PersonasBean implements Serializable
{

   private static final long serialVersionUID = 1L;

   /*
    * Support creating and retrieving Personas entities
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

   private Personas personas;

   public Personas getPersonas()
   {
      return this.personas;
   }

   public void setPersonas(Personas personas)
   {
      this.personas = personas;
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
         this.personas = this.example;
      }
      else
      {
         this.personas = findById(getId());
      }
   }

   public Personas findById(Long id)
   {

      return this.entityManager.find(Personas.class, id);
   }

   /*
    * Support updating and deleting Personas entities
    */

   public String update()
   {
      this.conversation.end();

      try
      {
         if (this.id == null)
         {
            this.entityManager.persist(this.personas);
            return "search?faces-redirect=true";
         }
         else
         {
            this.entityManager.merge(this.personas);
            return "view?faces-redirect=true&id=" + this.personas.getId();
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
         Personas deletableEntity = findById(getId());

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
    * Support searching Personas entities with pagination
    */

   private int page;
   private long count;
   private List<Personas> pageItems;

   private Personas example = new Personas();

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

   public Personas getExample()
   {
      return this.example;
   }

   public void setExample(Personas example)
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
      Root<Personas> root = countCriteria.from(Personas.class);
      countCriteria = countCriteria.select(builder.count(root)).where(
            getSearchPredicates(root));
      this.count = this.entityManager.createQuery(countCriteria)
            .getSingleResult();

      // Populate this.pageItems

      CriteriaQuery<Personas> criteria = builder.createQuery(Personas.class);
      root = criteria.from(Personas.class);
      TypedQuery<Personas> query = this.entityManager.createQuery(criteria
            .select(root).where(getSearchPredicates(root)));
      query.setFirstResult(this.page * getPageSize()).setMaxResults(
            getPageSize());
      this.pageItems = query.getResultList();
   }

   private Predicate[] getSearchPredicates(Root<Personas> root)
   {

      CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
      List<Predicate> predicatesList = new ArrayList<Predicate>();

      String primerNombre = this.example.getPrimerNombre();
      if (primerNombre != null && !"".equals(primerNombre))
      {
         predicatesList.add(builder.like(builder.lower(root.<String> get("primerNombre")), '%' + primerNombre.toLowerCase() + '%'));
      }
      String segundoNombre = this.example.getSegundoNombre();
      if (segundoNombre != null && !"".equals(segundoNombre))
      {
         predicatesList.add(builder.like(builder.lower(root.<String> get("segundoNombre")), '%' + segundoNombre.toLowerCase() + '%'));
      }
      String primerApellido = this.example.getPrimerApellido();
      if (primerApellido != null && !"".equals(primerApellido))
      {
         predicatesList.add(builder.like(builder.lower(root.<String> get("primerApellido")), '%' + primerApellido.toLowerCase() + '%'));
      }
      String segundoApellido = this.example.getSegundoApellido();
      if (segundoApellido != null && !"".equals(segundoApellido))
      {
         predicatesList.add(builder.like(builder.lower(root.<String> get("segundoApellido")), '%' + segundoApellido.toLowerCase() + '%'));
      }
      String nombreCompleto = this.example.getNombreCompleto();
      if (nombreCompleto != null && !"".equals(nombreCompleto))
      {
         predicatesList.add(builder.like(builder.lower(root.<String> get("nombreCompleto")), '%' + nombreCompleto.toLowerCase() + '%'));
      }

      return predicatesList.toArray(new Predicate[predicatesList.size()]);
   }

   public List<Personas> getPageItems()
   {
      return this.pageItems;
   }

   public long getCount()
   {
      return this.count;
   }

   /*
    * Support listing and POSTing back Personas entities (e.g. from inside an
    * HtmlSelectOneMenu)
    */

   public List<Personas> getAll()
   {

      CriteriaQuery<Personas> criteria = this.entityManager
            .getCriteriaBuilder().createQuery(Personas.class);
      return this.entityManager.createQuery(
            criteria.select(criteria.from(Personas.class))).getResultList();
   }

   @Resource
   private SessionContext sessionContext;

   public Converter getConverter()
   {

      final PersonasBean ejbProxy = this.sessionContext.getBusinessObject(PersonasBean.class);

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

            return String.valueOf(((Personas) value).getId());
         }
      };
   }

   /*
    * Support adding children to bidirectional, one-to-many tables
    */

   private Personas add = new Personas();

   public Personas getAdd()
   {
      return this.add;
   }

   public Personas getAdded()
   {
      Personas added = this.add;
      this.add = new Personas();
      return added;
   }
}
