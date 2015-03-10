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

import co.simasoft.models.base.nits.Nits;
import co.simasoft.models.base.empresas.Empresas;
import co.simasoft.models.base.nits.Ids;
import co.simasoft.models.base.personas.Personas;

/**
 * Backing bean for Nits entities.
 * <p/>
 * This class provides CRUD functionality for all Nits entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class NitsBean implements Serializable
{

   private static final long serialVersionUID = 1L;

   /*
    * Support creating and retrieving Nits entities
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

   private Nits nits;

   public Nits getNits()
   {
      return this.nits;
   }

   public void setNits(Nits nits)
   {
      this.nits = nits;
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
         this.nits = this.example;
      }
      else
      {
         this.nits = findById(getId());
      }
   }

   public Nits findById(Long id)
   {

      return this.entityManager.find(Nits.class, id);
   }

   /*
    * Support updating and deleting Nits entities
    */

   public String update()
   {
      this.conversation.end();

      try
      {
         if (this.id == null)
         {
            this.entityManager.persist(this.nits);
            return "search?faces-redirect=true";
         }
         else
         {
            this.entityManager.merge(this.nits);
            return "view?faces-redirect=true&id=" + this.nits.getId();
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
         Nits deletableEntity = findById(getId());
         Ids ids = deletableEntity.getIds();
         ids.getNits().remove(deletableEntity);
         deletableEntity.setIds(null);
         this.entityManager.merge(ids);
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
    * Support searching Nits entities with pagination
    */

   private int page;
   private long count;
   private List<Nits> pageItems;

   private Nits example = new Nits();

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

   public Nits getExample()
   {
      return this.example;
   }

   public void setExample(Nits example)
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
      Root<Nits> root = countCriteria.from(Nits.class);
      countCriteria = countCriteria.select(builder.count(root)).where(
            getSearchPredicates(root));
      this.count = this.entityManager.createQuery(countCriteria)
            .getSingleResult();

      // Populate this.pageItems

      CriteriaQuery<Nits> criteria = builder.createQuery(Nits.class);
      root = criteria.from(Nits.class);
      TypedQuery<Nits> query = this.entityManager.createQuery(criteria
            .select(root).where(getSearchPredicates(root)));
      query.setFirstResult(this.page * getPageSize()).setMaxResults(
            getPageSize());
      this.pageItems = query.getResultList();
   }

   private Predicate[] getSearchPredicates(Root<Nits> root)
   {

      CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
      List<Predicate> predicatesList = new ArrayList<Predicate>();

      int prueba = this.example.getPrueba();
      if (prueba != 0)
      {
         predicatesList.add(builder.equal(root.get("prueba"), prueba));
      }
      Empresas empresas = this.example.getEmpresas();
      if (empresas != null)
      {
         predicatesList.add(builder.equal(root.get("empresas"), empresas));
      }
      Ids ids = this.example.getIds();
      if (ids != null)
      {
         predicatesList.add(builder.equal(root.get("ids"), ids));
      }
      Personas personas = this.example.getPersonas();
      if (personas != null)
      {
         predicatesList.add(builder.equal(root.get("personas"), personas));
      }

      return predicatesList.toArray(new Predicate[predicatesList.size()]);
   }

   public List<Nits> getPageItems()
   {
      return this.pageItems;
   }

   public long getCount()
   {
      return this.count;
   }

   /*
    * Support listing and POSTing back Nits entities (e.g. from inside an
    * HtmlSelectOneMenu)
    */

   public List<Nits> getAll()
   {

      CriteriaQuery<Nits> criteria = this.entityManager
            .getCriteriaBuilder().createQuery(Nits.class);
      return this.entityManager.createQuery(
            criteria.select(criteria.from(Nits.class))).getResultList();
   }

   @Resource
   private SessionContext sessionContext;

   public Converter getConverter()
   {

      final NitsBean ejbProxy = this.sessionContext.getBusinessObject(NitsBean.class);

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

            return String.valueOf(((Nits) value).getId());
         }
      };
   }

   /*
    * Support adding children to bidirectional, one-to-many tables
    */

   private Nits add = new Nits();

   public Nits getAdd()
   {
      return this.add;
   }

   public Nits getAdded()
   {
      Nits added = this.add;
      this.add = new Nits();
      return added;
   }
}
