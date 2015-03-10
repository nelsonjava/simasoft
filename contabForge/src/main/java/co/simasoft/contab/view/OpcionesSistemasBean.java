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

import co.simasoft.models.base.sistemas.OpcionesSistemas;
import co.simasoft.models.base.sistemas.Opciones;
import co.simasoft.models.base.sistemas.Sistemas;

/**
 * Backing bean for OpcionesSistemas entities.
 * <p/>
 * This class provides CRUD functionality for all OpcionesSistemas entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class OpcionesSistemasBean implements Serializable
{

   private static final long serialVersionUID = 1L;

   /*
    * Support creating and retrieving OpcionesSistemas entities
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

   private OpcionesSistemas opcionesSistemas;

   public OpcionesSistemas getOpcionesSistemas()
   {
      return this.opcionesSistemas;
   }

   public void setOpcionesSistemas(OpcionesSistemas opcionesSistemas)
   {
      this.opcionesSistemas = opcionesSistemas;
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
         this.opcionesSistemas = this.example;
      }
      else
      {
         this.opcionesSistemas = findById(getId());
      }
   }

   public OpcionesSistemas findById(Long id)
   {

      return this.entityManager.find(OpcionesSistemas.class, id);
   }

   /*
    * Support updating and deleting OpcionesSistemas entities
    */

   public String update()
   {
      this.conversation.end();

      try
      {
         if (this.id == null)
         {
            this.entityManager.persist(this.opcionesSistemas);
            return "search?faces-redirect=true";
         }
         else
         {
            this.entityManager.merge(this.opcionesSistemas);
            return "view?faces-redirect=true&id=" + this.opcionesSistemas.getId();
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
         OpcionesSistemas deletableEntity = findById(getId());
         Sistemas sistemas = deletableEntity.getSistemas();
         sistemas.getOpcionesSistemas().remove(deletableEntity);
         deletableEntity.setSistemas(null);
         this.entityManager.merge(sistemas);
         Opciones opciones = deletableEntity.getOpciones();
         opciones.getOpcionesSistemas().remove(deletableEntity);
         deletableEntity.setOpciones(null);
         this.entityManager.merge(opciones);
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
    * Support searching OpcionesSistemas entities with pagination
    */

   private int page;
   private long count;
   private List<OpcionesSistemas> pageItems;

   private OpcionesSistemas example = new OpcionesSistemas();

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

   public OpcionesSistemas getExample()
   {
      return this.example;
   }

   public void setExample(OpcionesSistemas example)
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
      Root<OpcionesSistemas> root = countCriteria.from(OpcionesSistemas.class);
      countCriteria = countCriteria.select(builder.count(root)).where(
            getSearchPredicates(root));
      this.count = this.entityManager.createQuery(countCriteria)
            .getSingleResult();

      // Populate this.pageItems

      CriteriaQuery<OpcionesSistemas> criteria = builder.createQuery(OpcionesSistemas.class);
      root = criteria.from(OpcionesSistemas.class);
      TypedQuery<OpcionesSistemas> query = this.entityManager.createQuery(criteria
            .select(root).where(getSearchPredicates(root)));
      query.setFirstResult(this.page * getPageSize()).setMaxResults(
            getPageSize());
      this.pageItems = query.getResultList();
   }

   private Predicate[] getSearchPredicates(Root<OpcionesSistemas> root)
   {

      CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
      List<Predicate> predicatesList = new ArrayList<Predicate>();

      Sistemas sistemas = this.example.getSistemas();
      if (sistemas != null)
      {
         predicatesList.add(builder.equal(root.get("sistemas"), sistemas));
      }
      Opciones opciones = this.example.getOpciones();
      if (opciones != null)
      {
         predicatesList.add(builder.equal(root.get("opciones"), opciones));
      }

      return predicatesList.toArray(new Predicate[predicatesList.size()]);
   }

   public List<OpcionesSistemas> getPageItems()
   {
      return this.pageItems;
   }

   public long getCount()
   {
      return this.count;
   }

   /*
    * Support listing and POSTing back OpcionesSistemas entities (e.g. from inside an
    * HtmlSelectOneMenu)
    */

   public List<OpcionesSistemas> getAll()
   {

      CriteriaQuery<OpcionesSistemas> criteria = this.entityManager
            .getCriteriaBuilder().createQuery(OpcionesSistemas.class);
      return this.entityManager.createQuery(
            criteria.select(criteria.from(OpcionesSistemas.class))).getResultList();
   }

   @Resource
   private SessionContext sessionContext;

   public Converter getConverter()
   {

      final OpcionesSistemasBean ejbProxy = this.sessionContext.getBusinessObject(OpcionesSistemasBean.class);

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

            return String.valueOf(((OpcionesSistemas) value).getId());
         }
      };
   }

   /*
    * Support adding children to bidirectional, one-to-many tables
    */

   private OpcionesSistemas add = new OpcionesSistemas();

   public OpcionesSistemas getAdd()
   {
      return this.add;
   }

   public OpcionesSistemas getAdded()
   {
      OpcionesSistemas added = this.add;
      this.add = new OpcionesSistemas();
      return added;
   }
}
