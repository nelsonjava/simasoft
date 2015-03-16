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

import co.simasoft.models.pruebas.prueba.RolesSistemas;
import co.simasoft.models.pruebas.prueba.Roles;
import co.simasoft.models.pruebas.prueba.Sistemas;

/**
 * Backing bean for RolesSistemas entities.
 * <p/>
 * This class provides CRUD functionality for all RolesSistemas entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class RolesSistemasBean implements Serializable
{

   private static final long serialVersionUID = 1L;

   /*
    * Support creating and retrieving RolesSistemas entities
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

   private RolesSistemas rolesSistemas;

   public RolesSistemas getRolesSistemas()
   {
      return this.rolesSistemas;
   }

   public void setRolesSistemas(RolesSistemas rolesSistemas)
   {
      this.rolesSistemas = rolesSistemas;
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
         this.rolesSistemas = this.example;
      }
      else
      {
         this.rolesSistemas = findById(getId());
      }
   }

   public RolesSistemas findById(Long id)
   {

      return this.entityManager.find(RolesSistemas.class, id);
   }

   /*
    * Support updating and deleting RolesSistemas entities
    */

   public String update()
   {
      this.conversation.end();

      try
      {
         if (this.id == null)
         {
            this.entityManager.persist(this.rolesSistemas);
            return "search?faces-redirect=true";
         }
         else
         {
            this.entityManager.merge(this.rolesSistemas);
            return "view?faces-redirect=true&id=" + this.rolesSistemas.getId();
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
         RolesSistemas deletableEntity = findById(getId());
         Roles roles = deletableEntity.getRoles();
         roles.getRolesSistemas().remove(deletableEntity);
         deletableEntity.setRoles(null);
         this.entityManager.merge(roles);
         Sistemas sistemas = deletableEntity.getSistemas();
         sistemas.getRolesSistemas().remove(deletableEntity);
         deletableEntity.setSistemas(null);
         this.entityManager.merge(sistemas);
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
    * Support searching RolesSistemas entities with pagination
    */

   private int page;
   private long count;
   private List<RolesSistemas> pageItems;

   private RolesSistemas example = new RolesSistemas();

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

   public RolesSistemas getExample()
   {
      return this.example;
   }

   public void setExample(RolesSistemas example)
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
      Root<RolesSistemas> root = countCriteria.from(RolesSistemas.class);
      countCriteria = countCriteria.select(builder.count(root)).where(
            getSearchPredicates(root));
      this.count = this.entityManager.createQuery(countCriteria)
            .getSingleResult();

      // Populate this.pageItems

      CriteriaQuery<RolesSistemas> criteria = builder.createQuery(RolesSistemas.class);
      root = criteria.from(RolesSistemas.class);
      TypedQuery<RolesSistemas> query = this.entityManager.createQuery(criteria
            .select(root).where(getSearchPredicates(root)));
      query.setFirstResult(this.page * getPageSize()).setMaxResults(
            getPageSize());
      this.pageItems = query.getResultList();
   }

   private Predicate[] getSearchPredicates(Root<RolesSistemas> root)
   {

      CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
      List<Predicate> predicatesList = new ArrayList<Predicate>();

      int prueba = this.example.getPrueba();
      if (prueba != 0)
      {
         predicatesList.add(builder.equal(root.get("prueba"), prueba));
      }
      Roles roles = this.example.getRoles();
      if (roles != null)
      {
         predicatesList.add(builder.equal(root.get("roles"), roles));
      }
      Sistemas sistemas = this.example.getSistemas();
      if (sistemas != null)
      {
         predicatesList.add(builder.equal(root.get("sistemas"), sistemas));
      }

      return predicatesList.toArray(new Predicate[predicatesList.size()]);
   }

   public List<RolesSistemas> getPageItems()
   {
      return this.pageItems;
   }

   public long getCount()
   {
      return this.count;
   }

   /*
    * Support listing and POSTing back RolesSistemas entities (e.g. from inside an
    * HtmlSelectOneMenu)
    */

   public List<RolesSistemas> getAll()
   {

      CriteriaQuery<RolesSistemas> criteria = this.entityManager
            .getCriteriaBuilder().createQuery(RolesSistemas.class);
      return this.entityManager.createQuery(
            criteria.select(criteria.from(RolesSistemas.class))).getResultList();
   }

   @Resource
   private SessionContext sessionContext;

   public Converter getConverter()
   {

      final RolesSistemasBean ejbProxy = this.sessionContext.getBusinessObject(RolesSistemasBean.class);

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

            return String.valueOf(((RolesSistemas) value).getId());
         }
      };
   }

   /*
    * Support adding children to bidirectional, one-to-many tables
    */

   private RolesSistemas add = new RolesSistemas();

   public RolesSistemas getAdd()
   {
      return this.add;
   }

   public RolesSistemas getAdded()
   {
      RolesSistemas added = this.add;
      this.add = new RolesSistemas();
      return added;
   }
}
