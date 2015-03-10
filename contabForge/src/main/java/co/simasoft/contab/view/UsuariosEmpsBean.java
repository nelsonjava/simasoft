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

import co.simasoft.models.base.usuarios.UsuariosEmps;
import co.simasoft.models.base.empresas.Empresas;
import co.simasoft.models.base.personas.Personas;
import co.simasoft.models.base.usuarios.Usuarios;

/**
 * Backing bean for UsuariosEmps entities.
 * <p/>
 * This class provides CRUD functionality for all UsuariosEmps entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class UsuariosEmpsBean implements Serializable
{

   private static final long serialVersionUID = 1L;

   /*
    * Support creating and retrieving UsuariosEmps entities
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

   private UsuariosEmps usuariosEmps;

   public UsuariosEmps getUsuariosEmps()
   {
      return this.usuariosEmps;
   }

   public void setUsuariosEmps(UsuariosEmps usuariosEmps)
   {
      this.usuariosEmps = usuariosEmps;
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
         this.usuariosEmps = this.example;
      }
      else
      {
         this.usuariosEmps = findById(getId());
      }
   }

   public UsuariosEmps findById(Long id)
   {

      return this.entityManager.find(UsuariosEmps.class, id);
   }

   /*
    * Support updating and deleting UsuariosEmps entities
    */

   public String update()
   {
      this.conversation.end();

      try
      {
         if (this.id == null)
         {
            this.entityManager.persist(this.usuariosEmps);
            return "search?faces-redirect=true";
         }
         else
         {
            this.entityManager.merge(this.usuariosEmps);
            return "view?faces-redirect=true&id=" + this.usuariosEmps.getId();
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
         UsuariosEmps deletableEntity = findById(getId());
         Usuarios usuarios = deletableEntity.getUsuarios();
         usuarios.getUsuariosEmps().remove(deletableEntity);
         deletableEntity.setUsuarios(null);
         this.entityManager.merge(usuarios);
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
    * Support searching UsuariosEmps entities with pagination
    */

   private int page;
   private long count;
   private List<UsuariosEmps> pageItems;

   private UsuariosEmps example = new UsuariosEmps();

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

   public UsuariosEmps getExample()
   {
      return this.example;
   }

   public void setExample(UsuariosEmps example)
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
      Root<UsuariosEmps> root = countCriteria.from(UsuariosEmps.class);
      countCriteria = countCriteria.select(builder.count(root)).where(
            getSearchPredicates(root));
      this.count = this.entityManager.createQuery(countCriteria)
            .getSingleResult();

      // Populate this.pageItems

      CriteriaQuery<UsuariosEmps> criteria = builder.createQuery(UsuariosEmps.class);
      root = criteria.from(UsuariosEmps.class);
      TypedQuery<UsuariosEmps> query = this.entityManager.createQuery(criteria
            .select(root).where(getSearchPredicates(root)));
      query.setFirstResult(this.page * getPageSize()).setMaxResults(
            getPageSize());
      this.pageItems = query.getResultList();
   }

   private Predicate[] getSearchPredicates(Root<UsuariosEmps> root)
   {

      CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
      List<Predicate> predicatesList = new ArrayList<Predicate>();

      String ip = this.example.getIp();
      if (ip != null && !"".equals(ip))
      {
         predicatesList.add(builder.like(builder.lower(root.<String> get("ip")), '%' + ip.toLowerCase() + '%'));
      }
      Personas personas = this.example.getPersonas();
      if (personas != null)
      {
         predicatesList.add(builder.equal(root.get("personas"), personas));
      }
      Usuarios usuarios = this.example.getUsuarios();
      if (usuarios != null)
      {
         predicatesList.add(builder.equal(root.get("usuarios"), usuarios));
      }
      Empresas empresas = this.example.getEmpresas();
      if (empresas != null)
      {
         predicatesList.add(builder.equal(root.get("empresas"), empresas));
      }

      return predicatesList.toArray(new Predicate[predicatesList.size()]);
   }

   public List<UsuariosEmps> getPageItems()
   {
      return this.pageItems;
   }

   public long getCount()
   {
      return this.count;
   }

   /*
    * Support listing and POSTing back UsuariosEmps entities (e.g. from inside an
    * HtmlSelectOneMenu)
    */

   public List<UsuariosEmps> getAll()
   {

      CriteriaQuery<UsuariosEmps> criteria = this.entityManager
            .getCriteriaBuilder().createQuery(UsuariosEmps.class);
      return this.entityManager.createQuery(
            criteria.select(criteria.from(UsuariosEmps.class))).getResultList();
   }

   @Resource
   private SessionContext sessionContext;

   public Converter getConverter()
   {

      final UsuariosEmpsBean ejbProxy = this.sessionContext.getBusinessObject(UsuariosEmpsBean.class);

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

            return String.valueOf(((UsuariosEmps) value).getId());
         }
      };
   }

   /*
    * Support adding children to bidirectional, one-to-many tables
    */

   private UsuariosEmps add = new UsuariosEmps();

   public UsuariosEmps getAdd()
   {
      return this.add;
   }

   public UsuariosEmps getAdded()
   {
      UsuariosEmps added = this.add;
      this.add = new UsuariosEmps();
      return added;
   }
}
