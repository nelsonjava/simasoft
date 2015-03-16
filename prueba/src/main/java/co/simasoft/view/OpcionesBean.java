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

import co.simasoft.models.pruebas.prueba.Opciones;
import co.simasoft.models.pruebas.prueba.OpcionesSistemas;
import co.simasoft.models.pruebas.prueba.Permisos;
import co.simasoft.models.pruebas.prueba.TiposOpciones;
import java.util.Iterator;

/**
 * Backing bean for Opciones entities.
 * <p/>
 * This class provides CRUD functionality for all Opciones entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class OpcionesBean implements Serializable
{

   private static final long serialVersionUID = 1L;

   /*
    * Support creating and retrieving Opciones entities
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

   private Opciones opciones;

   public Opciones getOpciones()
   {
      return this.opciones;
   }

   public void setOpciones(Opciones opciones)
   {
      this.opciones = opciones;
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
         this.opciones = this.example;
      }
      else
      {
         this.opciones = findById(getId());
      }
   }

   public Opciones findById(Long id)
   {

      return this.entityManager.find(Opciones.class, id);
   }

   /*
    * Support updating and deleting Opciones entities
    */

   public String update()
   {
      this.conversation.end();

      try
      {
         if (this.id == null)
         {
            this.entityManager.persist(this.opciones);
            return "search?faces-redirect=true";
         }
         else
         {
            this.entityManager.merge(this.opciones);
            return "view?faces-redirect=true&id=" + this.opciones.getId();
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
         Opciones deletableEntity = findById(getId());
         Iterator<Opciones> iterObjHijos = deletableEntity.getObjHijos().iterator();
         for (; iterObjHijos.hasNext();)
         {
            Opciones nextInObjHijos = iterObjHijos.next();
            nextInObjHijos.setObjPadre(null);
            iterObjHijos.remove();
            this.entityManager.merge(nextInObjHijos);
         }
         TiposOpciones tiposOpciones = deletableEntity.getTiposOpciones();
         tiposOpciones.getOpciones().remove(deletableEntity);
         deletableEntity.setTiposOpciones(null);
         this.entityManager.merge(tiposOpciones);
         Permisos permisos = deletableEntity.getPermisos();
         permisos.getOpciones().remove(deletableEntity);
         deletableEntity.setPermisos(null);
         this.entityManager.merge(permisos);
         Iterator<OpcionesSistemas> iterOpcionesSistemas = deletableEntity.getOpcionesSistemas().iterator();
         for (; iterOpcionesSistemas.hasNext();)
         {
            OpcionesSistemas nextInOpcionesSistemas = iterOpcionesSistemas.next();
            nextInOpcionesSistemas.setOpciones(null);
            iterOpcionesSistemas.remove();
            this.entityManager.merge(nextInOpcionesSistemas);
         }
         Opciones objPadre = deletableEntity.getObjPadre();
         objPadre.getObjHijos().remove(deletableEntity);
         deletableEntity.setObjPadre(null);
         this.entityManager.merge(objPadre);
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
    * Support searching Opciones entities with pagination
    */

   private int page;
   private long count;
   private List<Opciones> pageItems;

   private Opciones example = new Opciones();

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

   public Opciones getExample()
   {
      return this.example;
   }

   public void setExample(Opciones example)
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
      Root<Opciones> root = countCriteria.from(Opciones.class);
      countCriteria = countCriteria.select(builder.count(root)).where(
            getSearchPredicates(root));
      this.count = this.entityManager.createQuery(countCriteria)
            .getSingleResult();

      // Populate this.pageItems

      CriteriaQuery<Opciones> criteria = builder.createQuery(Opciones.class);
      root = criteria.from(Opciones.class);
      TypedQuery<Opciones> query = this.entityManager.createQuery(criteria
            .select(root).where(getSearchPredicates(root)));
      query.setFirstResult(this.page * getPageSize()).setMaxResults(
            getPageSize());
      this.pageItems = query.getResultList();
   }

   private Predicate[] getSearchPredicates(Root<Opciones> root)
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
      String wwwUrl = this.example.getWwwUrl();
      if (wwwUrl != null && !"".equals(wwwUrl))
      {
         predicatesList.add(builder.like(builder.lower(root.<String> get("wwwUrl")), '%' + wwwUrl.toLowerCase() + '%'));
      }
      String descripcion = this.example.getDescripcion();
      if (descripcion != null && !"".equals(descripcion))
      {
         predicatesList.add(builder.like(builder.lower(root.<String> get("descripcion")), '%' + descripcion.toLowerCase() + '%'));
      }
      TiposOpciones tiposOpciones = this.example.getTiposOpciones();
      if (tiposOpciones != null)
      {
         predicatesList.add(builder.equal(root.get("tiposOpciones"), tiposOpciones));
      }

      return predicatesList.toArray(new Predicate[predicatesList.size()]);
   }

   public List<Opciones> getPageItems()
   {
      return this.pageItems;
   }

   public long getCount()
   {
      return this.count;
   }

   /*
    * Support listing and POSTing back Opciones entities (e.g. from inside an
    * HtmlSelectOneMenu)
    */

   public List<Opciones> getAll()
   {

      CriteriaQuery<Opciones> criteria = this.entityManager
            .getCriteriaBuilder().createQuery(Opciones.class);
      return this.entityManager.createQuery(
            criteria.select(criteria.from(Opciones.class))).getResultList();
   }

   @Resource
   private SessionContext sessionContext;

   public Converter getConverter()
   {

      final OpcionesBean ejbProxy = this.sessionContext.getBusinessObject(OpcionesBean.class);

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

            return String.valueOf(((Opciones) value).getId());
         }
      };
   }

   /*
    * Support adding children to bidirectional, one-to-many tables
    */

   private Opciones add = new Opciones();

   public Opciones getAdd()
   {
      return this.add;
   }

   public Opciones getAdded()
   {
      Opciones added = this.add;
      this.add = new Opciones();
      return added;
   }
}
