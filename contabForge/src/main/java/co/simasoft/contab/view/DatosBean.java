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

import co.simasoft.models.base.sistemas.Datos;
import co.simasoft.models.base.empresas.Empresas;
import co.simasoft.models.base.personas.Personas;
import co.simasoft.models.base.sistemas.Sistemas;

/**
 * Backing bean for Datos entities.
 * <p/>
 * This class provides CRUD functionality for all Datos entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class DatosBean implements Serializable
{

   private static final long serialVersionUID = 1L;

   /*
    * Support creating and retrieving Datos entities
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

   private Datos datos;

   public Datos getDatos()
   {
      return this.datos;
   }

   public void setDatos(Datos datos)
   {
      this.datos = datos;
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
         this.datos = this.example;
      }
      else
      {
         this.datos = findById(getId());
      }
   }

   public Datos findById(Long id)
   {

      return this.entityManager.find(Datos.class, id);
   }

   /*
    * Support updating and deleting Datos entities
    */

   public String update()
   {
      this.conversation.end();

      try
      {
         if (this.id == null)
         {
            this.entityManager.persist(this.datos);
            return "search?faces-redirect=true";
         }
         else
         {
            this.entityManager.merge(this.datos);
            return "view?faces-redirect=true&id=" + this.datos.getId();
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
         Datos deletableEntity = findById(getId());
         Sistemas sistemas = deletableEntity.getSistemas();
         sistemas.getDatos().remove(deletableEntity);
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
    * Support searching Datos entities with pagination
    */

   private int page;
   private long count;
   private List<Datos> pageItems;

   private Datos example = new Datos();

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

   public Datos getExample()
   {
      return this.example;
   }

   public void setExample(Datos example)
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
      Root<Datos> root = countCriteria.from(Datos.class);
      countCriteria = countCriteria.select(builder.count(root)).where(
            getSearchPredicates(root));
      this.count = this.entityManager.createQuery(countCriteria)
            .getSingleResult();

      // Populate this.pageItems

      CriteriaQuery<Datos> criteria = builder.createQuery(Datos.class);
      root = criteria.from(Datos.class);
      TypedQuery<Datos> query = this.entityManager.createQuery(criteria
            .select(root).where(getSearchPredicates(root)));
      query.setFirstResult(this.page * getPageSize()).setMaxResults(
            getPageSize());
      this.pageItems = query.getResultList();
   }

   private Predicate[] getSearchPredicates(Root<Datos> root)
   {

      CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
      List<Predicate> predicatesList = new ArrayList<Predicate>();

      String xyz = this.example.getXyz();
      if (xyz != null && !"".equals(xyz))
      {
         predicatesList.add(builder.like(builder.lower(root.<String> get("xyz")), '%' + xyz.toLowerCase() + '%'));
      }
      String abc = this.example.getAbc();
      if (abc != null && !"".equals(abc))
      {
         predicatesList.add(builder.like(builder.lower(root.<String> get("abc")), '%' + abc.toLowerCase() + '%'));
      }
      Empresas empresas = this.example.getEmpresas();
      if (empresas != null)
      {
         predicatesList.add(builder.equal(root.get("empresas"), empresas));
      }
      Personas personas = this.example.getPersonas();
      if (personas != null)
      {
         predicatesList.add(builder.equal(root.get("personas"), personas));
      }
      Sistemas sistemas = this.example.getSistemas();
      if (sistemas != null)
      {
         predicatesList.add(builder.equal(root.get("sistemas"), sistemas));
      }

      return predicatesList.toArray(new Predicate[predicatesList.size()]);
   }

   public List<Datos> getPageItems()
   {
      return this.pageItems;
   }

   public long getCount()
   {
      return this.count;
   }

   /*
    * Support listing and POSTing back Datos entities (e.g. from inside an
    * HtmlSelectOneMenu)
    */

   public List<Datos> getAll()
   {

      CriteriaQuery<Datos> criteria = this.entityManager
            .getCriteriaBuilder().createQuery(Datos.class);
      return this.entityManager.createQuery(
            criteria.select(criteria.from(Datos.class))).getResultList();
   }

   @Resource
   private SessionContext sessionContext;

   public Converter getConverter()
   {

      final DatosBean ejbProxy = this.sessionContext.getBusinessObject(DatosBean.class);

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

            return String.valueOf(((Datos) value).getId());
         }
      };
   }

   /*
    * Support adding children to bidirectional, one-to-many tables
    */

   private Datos add = new Datos();

   public Datos getAdd()
   {
      return this.add;
   }

   public Datos getAdded()
   {
      Datos added = this.add;
      this.add = new Datos();
      return added;
   }
}
