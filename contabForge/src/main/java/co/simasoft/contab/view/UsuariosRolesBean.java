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

import co.simasoft.models.base.usuarios.UsuariosRoles;
import co.simasoft.models.base.usuarios.Roles;
import co.simasoft.models.base.usuarios.Usuarios;

/**
 * Backing bean for UsuariosRoles entities.
 * <p/>
 * This class provides CRUD functionality for all UsuariosRoles entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class UsuariosRolesBean implements Serializable
{

   private static final long serialVersionUID = 1L;

   /*
    * Support creating and retrieving UsuariosRoles entities
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

   private UsuariosRoles usuariosRoles;

   public UsuariosRoles getUsuariosRoles()
   {
      return this.usuariosRoles;
   }

   public void setUsuariosRoles(UsuariosRoles usuariosRoles)
   {
      this.usuariosRoles = usuariosRoles;
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
         this.usuariosRoles = this.example;
      }
      else
      {
         this.usuariosRoles = findById(getId());
      }
   }

   public UsuariosRoles findById(Long id)
   {

      return this.entityManager.find(UsuariosRoles.class, id);
   }

   /*
    * Support updating and deleting UsuariosRoles entities
    */

   public String update()
   {
      this.conversation.end();

      try
      {
         if (this.id == null)
         {
            this.entityManager.persist(this.usuariosRoles);
            return "search?faces-redirect=true";
         }
         else
         {
            this.entityManager.merge(this.usuariosRoles);
            return "view?faces-redirect=true&id=" + this.usuariosRoles.getId();
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
         UsuariosRoles deletableEntity = findById(getId());
         Usuarios usuarios = deletableEntity.getUsuarios();
         usuarios.getUsuariosRoles().remove(deletableEntity);
         deletableEntity.setUsuarios(null);
         this.entityManager.merge(usuarios);
         Roles roles = deletableEntity.getRoles();
         roles.getUsuariosRoles().remove(deletableEntity);
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
    * Support searching UsuariosRoles entities with pagination
    */

   private int page;
   private long count;
   private List<UsuariosRoles> pageItems;

   private UsuariosRoles example = new UsuariosRoles();

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

   public UsuariosRoles getExample()
   {
      return this.example;
   }

   public void setExample(UsuariosRoles example)
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
      Root<UsuariosRoles> root = countCriteria.from(UsuariosRoles.class);
      countCriteria = countCriteria.select(builder.count(root)).where(
            getSearchPredicates(root));
      this.count = this.entityManager.createQuery(countCriteria)
            .getSingleResult();

      // Populate this.pageItems

      CriteriaQuery<UsuariosRoles> criteria = builder.createQuery(UsuariosRoles.class);
      root = criteria.from(UsuariosRoles.class);
      TypedQuery<UsuariosRoles> query = this.entityManager.createQuery(criteria
            .select(root).where(getSearchPredicates(root)));
      query.setFirstResult(this.page * getPageSize()).setMaxResults(
            getPageSize());
      this.pageItems = query.getResultList();
   }

   private Predicate[] getSearchPredicates(Root<UsuariosRoles> root)
   {

      CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
      List<Predicate> predicatesList = new ArrayList<Predicate>();

      int prueba = this.example.getPrueba();
      if (prueba != 0)
      {
         predicatesList.add(builder.equal(root.get("prueba"), prueba));
      }
      Usuarios usuarios = this.example.getUsuarios();
      if (usuarios != null)
      {
         predicatesList.add(builder.equal(root.get("usuarios"), usuarios));
      }
      Roles roles = this.example.getRoles();
      if (roles != null)
      {
         predicatesList.add(builder.equal(root.get("roles"), roles));
      }

      return predicatesList.toArray(new Predicate[predicatesList.size()]);
   }

   public List<UsuariosRoles> getPageItems()
   {
      return this.pageItems;
   }

   public long getCount()
   {
      return this.count;
   }

   /*
    * Support listing and POSTing back UsuariosRoles entities (e.g. from inside an
    * HtmlSelectOneMenu)
    */

   public List<UsuariosRoles> getAll()
   {

      CriteriaQuery<UsuariosRoles> criteria = this.entityManager
            .getCriteriaBuilder().createQuery(UsuariosRoles.class);
      return this.entityManager.createQuery(
            criteria.select(criteria.from(UsuariosRoles.class))).getResultList();
   }

   @Resource
   private SessionContext sessionContext;

   public Converter getConverter()
   {

      final UsuariosRolesBean ejbProxy = this.sessionContext.getBusinessObject(UsuariosRolesBean.class);

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

            return String.valueOf(((UsuariosRoles) value).getId());
         }
      };
   }

   /*
    * Support adding children to bidirectional, one-to-many tables
    */

   private UsuariosRoles add = new UsuariosRoles();

   public UsuariosRoles getAdd()
   {
      return this.add;
   }

   public UsuariosRoles getAdded()
   {
      UsuariosRoles added = this.add;
      this.add = new UsuariosRoles();
      return added;
   }
}
