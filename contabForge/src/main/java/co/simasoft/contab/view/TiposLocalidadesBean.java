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

import co.simasoft.models.base.paises.TiposLocalidades;
import co.simasoft.models.base.paises.Localidades;
import java.util.Iterator;

/**
 * Backing bean for TiposLocalidades entities.
 * <p/>
 * This class provides CRUD functionality for all TiposLocalidades entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class TiposLocalidadesBean implements Serializable
{

   private static final long serialVersionUID = 1L;

   /*
    * Support creating and retrieving TiposLocalidades entities
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

   private TiposLocalidades tiposLocalidades;

   public TiposLocalidades getTiposLocalidades()
   {
      return this.tiposLocalidades;
   }

   public void setTiposLocalidades(TiposLocalidades tiposLocalidades)
   {
      this.tiposLocalidades = tiposLocalidades;
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
         this.tiposLocalidades = this.example;
      }
      else
      {
         this.tiposLocalidades = findById(getId());
      }
   }

   public TiposLocalidades findById(Long id)
   {

      return this.entityManager.find(TiposLocalidades.class, id);
   }

   /*
    * Support updating and deleting TiposLocalidades entities
    */

   public String update()
   {
      this.conversation.end();

      try
      {
         if (this.id == null)
         {
            this.entityManager.persist(this.tiposLocalidades);
            return "search?faces-redirect=true";
         }
         else
         {
            this.entityManager.merge(this.tiposLocalidades);
            return "view?faces-redirect=true&id=" + this.tiposLocalidades.getId();
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
         TiposLocalidades deletableEntity = findById(getId());
         Iterator<Localidades> iterLocalidades = deletableEntity.getLocalidades().iterator();
         for (; iterLocalidades.hasNext();)
         {
            Localidades nextInLocalidades = iterLocalidades.next();
            nextInLocalidades.setTiposLocalidades(null);
            iterLocalidades.remove();
            this.entityManager.merge(nextInLocalidades);
         }
         TiposLocalidades objPadre = deletableEntity.getObjPadre();
         objPadre.getObjHijos().remove(deletableEntity);
         deletableEntity.setObjPadre(null);
         this.entityManager.merge(objPadre);
         Iterator<TiposLocalidades> iterObjHijos = deletableEntity.getObjHijos().iterator();
         for (; iterObjHijos.hasNext();)
         {
            TiposLocalidades nextInObjHijos = iterObjHijos.next();
            nextInObjHijos.setObjPadre(null);
            iterObjHijos.remove();
            this.entityManager.merge(nextInObjHijos);
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
    * Support searching TiposLocalidades entities with pagination
    */

   private int page;
   private long count;
   private List<TiposLocalidades> pageItems;

   private TiposLocalidades example = new TiposLocalidades();

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

   public TiposLocalidades getExample()
   {
      return this.example;
   }

   public void setExample(TiposLocalidades example)
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
      Root<TiposLocalidades> root = countCriteria.from(TiposLocalidades.class);
      countCriteria = countCriteria.select(builder.count(root)).where(
            getSearchPredicates(root));
      this.count = this.entityManager.createQuery(countCriteria)
            .getSingleResult();

      // Populate this.pageItems

      CriteriaQuery<TiposLocalidades> criteria = builder.createQuery(TiposLocalidades.class);
      root = criteria.from(TiposLocalidades.class);
      TypedQuery<TiposLocalidades> query = this.entityManager.createQuery(criteria
            .select(root).where(getSearchPredicates(root)));
      query.setFirstResult(this.page * getPageSize()).setMaxResults(
            getPageSize());
      this.pageItems = query.getResultList();
   }

   private Predicate[] getSearchPredicates(Root<TiposLocalidades> root)
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
      TiposLocalidades objPadre = this.example.getObjPadre();
      if (objPadre != null)
      {
         predicatesList.add(builder.equal(root.get("objPadre"), objPadre));
      }

      return predicatesList.toArray(new Predicate[predicatesList.size()]);
   }

   public List<TiposLocalidades> getPageItems()
   {
      return this.pageItems;
   }

   public long getCount()
   {
      return this.count;
   }

   /*
    * Support listing and POSTing back TiposLocalidades entities (e.g. from inside an
    * HtmlSelectOneMenu)
    */

   public List<TiposLocalidades> getAll()
   {

      CriteriaQuery<TiposLocalidades> criteria = this.entityManager
            .getCriteriaBuilder().createQuery(TiposLocalidades.class);
      return this.entityManager.createQuery(
            criteria.select(criteria.from(TiposLocalidades.class))).getResultList();
   }

   @Resource
   private SessionContext sessionContext;

   public Converter getConverter()
   {

      final TiposLocalidadesBean ejbProxy = this.sessionContext.getBusinessObject(TiposLocalidadesBean.class);

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

            return String.valueOf(((TiposLocalidades) value).getId());
         }
      };
   }

   /*
    * Support adding children to bidirectional, one-to-many tables
    */

   private TiposLocalidades add = new TiposLocalidades();

   public TiposLocalidades getAdd()
   {
      return this.add;
   }

   public TiposLocalidades getAdded()
   {
      TiposLocalidades added = this.add;
      this.add = new TiposLocalidades();
      return added;
   }
}
