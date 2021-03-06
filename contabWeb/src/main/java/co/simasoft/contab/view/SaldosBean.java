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

import co.simasoft.models.contable.contabilidad.Saldos;
import co.simasoft.models.contable.contabilidad.Pucs;
import co.simasoft.models.contable.contabilidad.Terceros;

/**
 * Backing bean for Saldos entities.
 * <p/>
 * This class provides CRUD functionality for all Saldos entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class SaldosBean implements Serializable
{

   private static final long serialVersionUID = 1L;

   /*
    * Support creating and retrieving Saldos entities
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

   private Saldos saldos;

   public Saldos getSaldos()
   {
      return this.saldos;
   }

   public void setSaldos(Saldos saldos)
   {
      this.saldos = saldos;
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
         this.saldos = this.example;
      }
      else
      {
         this.saldos = findById(getId());
      }
   }

   public Saldos findById(Long id)
   {

      return this.entityManager.find(Saldos.class, id);
   }

   /*
    * Support updating and deleting Saldos entities
    */

   public String update()
   {
      this.conversation.end();

      try
      {
         if (this.id == null)
         {
            this.entityManager.persist(this.saldos);
            return "search?faces-redirect=true";
         }
         else
         {
            this.entityManager.merge(this.saldos);
            return "view?faces-redirect=true&id=" + this.saldos.getId();
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
         Saldos deletableEntity = findById(getId());
         Pucs pucs = deletableEntity.getPucs();
         pucs.getSaldos().remove(deletableEntity);
         deletableEntity.setPucs(null);
         this.entityManager.merge(pucs);
         Terceros terceros = deletableEntity.getTerceros();
         terceros.getSaldos().remove(deletableEntity);
         deletableEntity.setTerceros(null);
         this.entityManager.merge(terceros);
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
    * Support searching Saldos entities with pagination
    */

   private int page;
   private long count;
   private List<Saldos> pageItems;

   private Saldos example = new Saldos();

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

   public Saldos getExample()
   {
      return this.example;
   }

   public void setExample(Saldos example)
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
      Root<Saldos> root = countCriteria.from(Saldos.class);
      countCriteria = countCriteria.select(builder.count(root)).where(
            getSearchPredicates(root));
      this.count = this.entityManager.createQuery(countCriteria)
            .getSingleResult();

      // Populate this.pageItems

      CriteriaQuery<Saldos> criteria = builder.createQuery(Saldos.class);
      root = criteria.from(Saldos.class);
      TypedQuery<Saldos> query = this.entityManager.createQuery(criteria
            .select(root).where(getSearchPredicates(root)));
      query.setFirstResult(this.page * getPageSize()).setMaxResults(
            getPageSize());
      this.pageItems = query.getResultList();
   }

   private Predicate[] getSearchPredicates(Root<Saldos> root)
   {

      CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
      List<Predicate> predicatesList = new ArrayList<Predicate>();

      Pucs pucs = this.example.getPucs();
      if (pucs != null)
      {
         predicatesList.add(builder.equal(root.get("pucs"), pucs));
      }
      Terceros terceros = this.example.getTerceros();
      if (terceros != null)
      {
         predicatesList.add(builder.equal(root.get("terceros"), terceros));
      }

      return predicatesList.toArray(new Predicate[predicatesList.size()]);
   }

   public List<Saldos> getPageItems()
   {
      return this.pageItems;
   }

   public long getCount()
   {
      return this.count;
   }

   /*
    * Support listing and POSTing back Saldos entities (e.g. from inside an
    * HtmlSelectOneMenu)
    */

   public List<Saldos> getAll()
   {

      CriteriaQuery<Saldos> criteria = this.entityManager
            .getCriteriaBuilder().createQuery(Saldos.class);
      return this.entityManager.createQuery(
            criteria.select(criteria.from(Saldos.class))).getResultList();
   }

   @Resource
   private SessionContext sessionContext;

   public Converter getConverter()
   {

      final SaldosBean ejbProxy = this.sessionContext.getBusinessObject(SaldosBean.class);

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

            return String.valueOf(((Saldos) value).getId());
         }
      };
   }

   /*
    * Support adding children to bidirectional, one-to-many tables
    */

   private Saldos add = new Saldos();

   public Saldos getAdd()
   {
      return this.add;
   }

   public Saldos getAdded()
   {
      Saldos added = this.add;
      this.add = new Saldos();
      return added;
   }
}
