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

import co.simasoft.models.base.paises.Localidades;
import co.simasoft.models.base.paises.Municipios;
import co.simasoft.models.base.paises.TiposLocalidades;
import java.util.Iterator;

/**
 * Backing bean for Localidades entities.
 * <p/>
 * This class provides CRUD functionality for all Localidades entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class LocalidadesBean implements Serializable
{

   private static final long serialVersionUID = 1L;

   /*
    * Support creating and retrieving Localidades entities
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

   private Localidades localidades;

   public Localidades getLocalidades()
   {
      return this.localidades;
   }

   public void setLocalidades(Localidades localidades)
   {
      this.localidades = localidades;
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
         this.localidades = this.example;
      }
      else
      {
         this.localidades = findById(getId());
      }
   }

   public Localidades findById(Long id)
   {

      return this.entityManager.find(Localidades.class, id);
   }

   /*
    * Support updating and deleting Localidades entities
    */

   public String update()
   {
      this.conversation.end();

      try
      {
         if (this.id == null)
         {
            this.entityManager.persist(this.localidades);
            return "search?faces-redirect=true";
         }
         else
         {
            this.entityManager.merge(this.localidades);
            return "view?faces-redirect=true&id=" + this.localidades.getId();
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
         Localidades deletableEntity = findById(getId());
         Localidades objPadre = deletableEntity.getObjPadre();
         objPadre.getObjHijos().remove(deletableEntity);
         deletableEntity.setObjPadre(null);
         this.entityManager.merge(objPadre);
         Iterator<Localidades> iterObjHijos = deletableEntity.getObjHijos().iterator();
         for (; iterObjHijos.hasNext();)
         {
            Localidades nextInObjHijos = iterObjHijos.next();
            nextInObjHijos.setObjPadre(null);
            iterObjHijos.remove();
            this.entityManager.merge(nextInObjHijos);
         }
         TiposLocalidades tiposLocalidades = deletableEntity.getTiposLocalidades();
         tiposLocalidades.getLocalidades().remove(deletableEntity);
         deletableEntity.setTiposLocalidades(null);
         this.entityManager.merge(tiposLocalidades);
         Municipios municipios = deletableEntity.getMunicipios();
         municipios.getLocalidades().remove(deletableEntity);
         deletableEntity.setMunicipios(null);
         this.entityManager.merge(municipios);
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
    * Support searching Localidades entities with pagination
    */

   private int page;
   private long count;
   private List<Localidades> pageItems;

   private Localidades example = new Localidades();

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

   public Localidades getExample()
   {
      return this.example;
   }

   public void setExample(Localidades example)
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
      Root<Localidades> root = countCriteria.from(Localidades.class);
      countCriteria = countCriteria.select(builder.count(root)).where(
            getSearchPredicates(root));
      this.count = this.entityManager.createQuery(countCriteria)
            .getSingleResult();

      // Populate this.pageItems

      CriteriaQuery<Localidades> criteria = builder.createQuery(Localidades.class);
      root = criteria.from(Localidades.class);
      TypedQuery<Localidades> query = this.entityManager.createQuery(criteria
            .select(root).where(getSearchPredicates(root)));
      query.setFirstResult(this.page * getPageSize()).setMaxResults(
            getPageSize());
      this.pageItems = query.getResultList();
   }

   private Predicate[] getSearchPredicates(Root<Localidades> root)
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
      String codigoDane = this.example.getCodigoDane();
      if (codigoDane != null && !"".equals(codigoDane))
      {
         predicatesList.add(builder.like(builder.lower(root.<String> get("codigoDane")), '%' + codigoDane.toLowerCase() + '%'));
      }
      Localidades objPadre = this.example.getObjPadre();
      if (objPadre != null)
      {
         predicatesList.add(builder.equal(root.get("objPadre"), objPadre));
      }
      TiposLocalidades tiposLocalidades = this.example.getTiposLocalidades();
      if (tiposLocalidades != null)
      {
         predicatesList.add(builder.equal(root.get("tiposLocalidades"), tiposLocalidades));
      }

      return predicatesList.toArray(new Predicate[predicatesList.size()]);
   }

   public List<Localidades> getPageItems()
   {
      return this.pageItems;
   }

   public long getCount()
   {
      return this.count;
   }

   /*
    * Support listing and POSTing back Localidades entities (e.g. from inside an
    * HtmlSelectOneMenu)
    */

   public List<Localidades> getAll()
   {

      CriteriaQuery<Localidades> criteria = this.entityManager
            .getCriteriaBuilder().createQuery(Localidades.class);
      return this.entityManager.createQuery(
            criteria.select(criteria.from(Localidades.class))).getResultList();
   }

   @Resource
   private SessionContext sessionContext;

   public Converter getConverter()
   {

      final LocalidadesBean ejbProxy = this.sessionContext.getBusinessObject(LocalidadesBean.class);

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

            return String.valueOf(((Localidades) value).getId());
         }
      };
   }

   /*
    * Support adding children to bidirectional, one-to-many tables
    */

   private Localidades add = new Localidades();

   public Localidades getAdd()
   {
      return this.add;
   }

   public Localidades getAdded()
   {
      Localidades added = this.add;
      this.add = new Localidades();
      return added;
   }
}
