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

import co.simasoft.models.base.sistemas.Sistemas;
import co.simasoft.models.base.sistemas.Datos;
import co.simasoft.models.base.sistemas.OpcionesSistemas;
import co.simasoft.models.base.sistemas.RolesSistemas;
import co.simasoft.models.base.sistemas.TiposSistemas;
import java.util.Iterator;

/**
 * Backing bean for Sistemas entities.
 * <p/>
 * This class provides CRUD functionality for all Sistemas entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class SistemasBean implements Serializable
{

   private static final long serialVersionUID = 1L;

   /*
    * Support creating and retrieving Sistemas entities
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

   private Sistemas sistemas;

   public Sistemas getSistemas()
   {
      return this.sistemas;
   }

   public void setSistemas(Sistemas sistemas)
   {
      this.sistemas = sistemas;
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
         this.sistemas = this.example;
      }
      else
      {
         this.sistemas = findById(getId());
      }
   }

   public Sistemas findById(Long id)
   {

      return this.entityManager.find(Sistemas.class, id);
   }

   /*
    * Support updating and deleting Sistemas entities
    */

   public String update()
   {
      this.conversation.end();

      try
      {
         if (this.id == null)
         {
            this.entityManager.persist(this.sistemas);
            return "search?faces-redirect=true";
         }
         else
         {
            this.entityManager.merge(this.sistemas);
            return "view?faces-redirect=true&id=" + this.sistemas.getId();
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
         Sistemas deletableEntity = findById(getId());
         Sistemas objPadre = deletableEntity.getObjPadre();
         objPadre.getObjHijos().remove(deletableEntity);
         deletableEntity.setObjPadre(null);
         this.entityManager.merge(objPadre);
         Iterator<OpcionesSistemas> iterOpcionesSistemas = deletableEntity.getOpcionesSistemas().iterator();
         for (; iterOpcionesSistemas.hasNext();)
         {
            OpcionesSistemas nextInOpcionesSistemas = iterOpcionesSistemas.next();
            nextInOpcionesSistemas.setSistemas(null);
            iterOpcionesSistemas.remove();
            this.entityManager.merge(nextInOpcionesSistemas);
         }
         Iterator<Datos> iterDatos = deletableEntity.getDatos().iterator();
         for (; iterDatos.hasNext();)
         {
            Datos nextInDatos = iterDatos.next();
            nextInDatos.setSistemas(null);
            iterDatos.remove();
            this.entityManager.merge(nextInDatos);
         }
         TiposSistemas tiposSistemas = deletableEntity.getTiposSistemas();
         tiposSistemas.getSistemas().remove(deletableEntity);
         deletableEntity.setTiposSistemas(null);
         this.entityManager.merge(tiposSistemas);
         Iterator<Sistemas> iterObjHijos = deletableEntity.getObjHijos().iterator();
         for (; iterObjHijos.hasNext();)
         {
            Sistemas nextInObjHijos = iterObjHijos.next();
            nextInObjHijos.setObjPadre(null);
            iterObjHijos.remove();
            this.entityManager.merge(nextInObjHijos);
         }
         Iterator<RolesSistemas> iterRolesSistemas = deletableEntity.getRolesSistemas().iterator();
         for (; iterRolesSistemas.hasNext();)
         {
            RolesSistemas nextInRolesSistemas = iterRolesSistemas.next();
            nextInRolesSistemas.setSistemas(null);
            iterRolesSistemas.remove();
            this.entityManager.merge(nextInRolesSistemas);
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
    * Support searching Sistemas entities with pagination
    */

   private int page;
   private long count;
   private List<Sistemas> pageItems;

   private Sistemas example = new Sistemas();

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

   public Sistemas getExample()
   {
      return this.example;
   }

   public void setExample(Sistemas example)
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
      Root<Sistemas> root = countCriteria.from(Sistemas.class);
      countCriteria = countCriteria.select(builder.count(root)).where(
            getSearchPredicates(root));
      this.count = this.entityManager.createQuery(countCriteria)
            .getSingleResult();

      // Populate this.pageItems

      CriteriaQuery<Sistemas> criteria = builder.createQuery(Sistemas.class);
      root = criteria.from(Sistemas.class);
      TypedQuery<Sistemas> query = this.entityManager.createQuery(criteria
            .select(root).where(getSearchPredicates(root)));
      query.setFirstResult(this.page * getPageSize()).setMaxResults(
            getPageSize());
      this.pageItems = query.getResultList();
   }

   private Predicate[] getSearchPredicates(Root<Sistemas> root)
   {

      CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
      List<Predicate> predicatesList = new ArrayList<Predicate>();

      String codigo = this.example.getCodigo();
      if (codigo != null && !"".equals(codigo))
      {
         predicatesList.add(builder.like(builder.lower(root.<String> get("codigo")), '%' + codigo.toLowerCase() + '%'));
      }
      String nombre = this.example.getNombre();
      if (nombre != null && !"".equals(nombre))
      {
         predicatesList.add(builder.like(builder.lower(root.<String> get("nombre")), '%' + nombre.toLowerCase() + '%'));
      }
      String titulo = this.example.getTitulo();
      if (titulo != null && !"".equals(titulo))
      {
         predicatesList.add(builder.like(builder.lower(root.<String> get("titulo")), '%' + titulo.toLowerCase() + '%'));
      }
      String descripcion = this.example.getDescripcion();
      if (descripcion != null && !"".equals(descripcion))
      {
         predicatesList.add(builder.like(builder.lower(root.<String> get("descripcion")), '%' + descripcion.toLowerCase() + '%'));
      }
      Sistemas objPadre = this.example.getObjPadre();
      if (objPadre != null)
      {
         predicatesList.add(builder.equal(root.get("objPadre"), objPadre));
      }

      return predicatesList.toArray(new Predicate[predicatesList.size()]);
   }

   public List<Sistemas> getPageItems()
   {
      return this.pageItems;
   }

   public long getCount()
   {
      return this.count;
   }

   /*
    * Support listing and POSTing back Sistemas entities (e.g. from inside an
    * HtmlSelectOneMenu)
    */

   public List<Sistemas> getAll()
   {

      CriteriaQuery<Sistemas> criteria = this.entityManager
            .getCriteriaBuilder().createQuery(Sistemas.class);
      return this.entityManager.createQuery(
            criteria.select(criteria.from(Sistemas.class))).getResultList();
   }

   @Resource
   private SessionContext sessionContext;

   public Converter getConverter()
   {

      final SistemasBean ejbProxy = this.sessionContext.getBusinessObject(SistemasBean.class);

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

            return String.valueOf(((Sistemas) value).getId());
         }
      };
   }

   /*
    * Support adding children to bidirectional, one-to-many tables
    */

   private Sistemas add = new Sistemas();

   public Sistemas getAdd()
   {
      return this.add;
   }

   public Sistemas getAdded()
   {
      Sistemas added = this.add;
      this.add = new Sistemas();
      return added;
   }
}
