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

import co.simasoft.models.base.usuarios.RolesGrupos;
import co.simasoft.models.base.usuarios.Roles;

/**
 * Backing bean for RolesGrupos entities.
 * <p/>
 * This class provides CRUD functionality for all RolesGrupos entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class RolesGruposBean implements Serializable
{

   private static final long serialVersionUID = 1L;

   /*
    * Support creating and retrieving RolesGrupos entities
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

   private RolesGrupos rolesGrupos;

   public RolesGrupos getRolesGrupos()
   {
      return this.rolesGrupos;
   }

   public void setRolesGrupos(RolesGrupos rolesGrupos)
   {
      this.rolesGrupos = rolesGrupos;
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
         this.rolesGrupos = this.example;
      }
      else
      {
         this.rolesGrupos = findById(getId());
      }
   }

   public RolesGrupos findById(Long id)
   {

      return this.entityManager.find(RolesGrupos.class, id);
   }

   /*
    * Support updating and deleting RolesGrupos entities
    */

   public String update()
   {
      this.conversation.end();

      try
      {
         if (this.id == null)
         {
            this.entityManager.persist(this.rolesGrupos);
            return "search?faces-redirect=true";
         }
         else
         {
            this.entityManager.merge(this.rolesGrupos);
            return "view?faces-redirect=true&id=" + this.rolesGrupos.getId();
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
         RolesGrupos deletableEntity = findById(getId());
         Roles roles = deletableEntity.getRoles();
         roles.getRolesGrupos().remove(deletableEntity);
         deletableEntity.setRoles(null);
         this.entityManager.merge(roles);
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
    * Support searching RolesGrupos entities with pagination
    */

   private int page;
   private long count;
   private List<RolesGrupos> pageItems;

   private RolesGrupos example = new RolesGrupos();

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

   public RolesGrupos getExample()
   {
      return this.example;
   }

   public void setExample(RolesGrupos example)
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
      Root<RolesGrupos> root = countCriteria.from(RolesGrupos.class);
      countCriteria = countCriteria.select(builder.count(root)).where(
            getSearchPredicates(root));
      this.count = this.entityManager.createQuery(countCriteria)
            .getSingleResult();

      // Populate this.pageItems

      CriteriaQuery<RolesGrupos> criteria = builder.createQuery(RolesGrupos.class);
      root = criteria.from(RolesGrupos.class);
      TypedQuery<RolesGrupos> query = this.entityManager.createQuery(criteria
            .select(root).where(getSearchPredicates(root)));
      query.setFirstResult(this.page * getPageSize()).setMaxResults(
            getPageSize());
      this.pageItems = query.getResultList();
   }

   private Predicate[] getSearchPredicates(Root<RolesGrupos> root)
   {

      CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
      List<Predicate> predicatesList = new ArrayList<Predicate>();

      String nombre = this.example.getNombre();
      if (nombre != null && !"".equals(nombre))
      {
         predicatesList.add(builder.like(builder.lower(root.<String> get("nombre")), '%' + nombre.toLowerCase() + '%'));
      }
      Roles roles = this.example.getRoles();
      if (roles != null)
      {
         predicatesList.add(builder.equal(root.get("roles"), roles));
      }

      return predicatesList.toArray(new Predicate[predicatesList.size()]);
   }

   public List<RolesGrupos> getPageItems()
   {
      return this.pageItems;
   }

   public long getCount()
   {
      return this.count;
   }

   /*
    * Support listing and POSTing back RolesGrupos entities (e.g. from inside an
    * HtmlSelectOneMenu)
    */

   public List<RolesGrupos> getAll()
   {

      CriteriaQuery<RolesGrupos> criteria = this.entityManager
            .getCriteriaBuilder().createQuery(RolesGrupos.class);
      return this.entityManager.createQuery(
            criteria.select(criteria.from(RolesGrupos.class))).getResultList();
   }

   @Resource
   private SessionContext sessionContext;

   public Converter getConverter()
   {

      final RolesGruposBean ejbProxy = this.sessionContext.getBusinessObject(RolesGruposBean.class);

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

            return String.valueOf(((RolesGrupos) value).getId());
         }
      };
   }

   /*
    * Support adding children to bidirectional, one-to-many tables
    */

   private RolesGrupos add = new RolesGrupos();

   public RolesGrupos getAdd()
   {
      return this.add;
   }

   public RolesGrupos getAdded()
   {
      RolesGrupos added = this.add;
      this.add = new RolesGrupos();
      return added;
   }
}
