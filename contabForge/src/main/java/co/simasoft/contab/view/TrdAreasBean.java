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

import co.simasoft.models.iso.lmr.TrdAreas;
import co.simasoft.models.iso.lmr.Lmrs;
import java.util.Iterator;

/**
 * Backing bean for TrdAreas entities.
 * <p/>
 * This class provides CRUD functionality for all TrdAreas entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class TrdAreasBean implements Serializable
{

   private static final long serialVersionUID = 1L;

   /*
    * Support creating and retrieving TrdAreas entities
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

   private TrdAreas trdAreas;

   public TrdAreas getTrdAreas()
   {
      return this.trdAreas;
   }

   public void setTrdAreas(TrdAreas trdAreas)
   {
      this.trdAreas = trdAreas;
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
         this.trdAreas = this.example;
      }
      else
      {
         this.trdAreas = findById(getId());
      }
   }

   public TrdAreas findById(Long id)
   {

      return this.entityManager.find(TrdAreas.class, id);
   }

   /*
    * Support updating and deleting TrdAreas entities
    */

   public String update()
   {
      this.conversation.end();

      try
      {
         if (this.id == null)
         {
            this.entityManager.persist(this.trdAreas);
            return "search?faces-redirect=true";
         }
         else
         {
            this.entityManager.merge(this.trdAreas);
            return "view?faces-redirect=true&id=" + this.trdAreas.getId();
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
         TrdAreas deletableEntity = findById(getId());
         Iterator<Lmrs> iterLmrs = deletableEntity.getLmrs().iterator();
         for (; iterLmrs.hasNext();)
         {
            Lmrs nextInLmrs = iterLmrs.next();
            nextInLmrs.setTrdAreas(null);
            iterLmrs.remove();
            this.entityManager.merge(nextInLmrs);
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
    * Support searching TrdAreas entities with pagination
    */

   private int page;
   private long count;
   private List<TrdAreas> pageItems;

   private TrdAreas example = new TrdAreas();

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

   public TrdAreas getExample()
   {
      return this.example;
   }

   public void setExample(TrdAreas example)
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
      Root<TrdAreas> root = countCriteria.from(TrdAreas.class);
      countCriteria = countCriteria.select(builder.count(root)).where(
            getSearchPredicates(root));
      this.count = this.entityManager.createQuery(countCriteria)
            .getSingleResult();

      // Populate this.pageItems

      CriteriaQuery<TrdAreas> criteria = builder.createQuery(TrdAreas.class);
      root = criteria.from(TrdAreas.class);
      TypedQuery<TrdAreas> query = this.entityManager.createQuery(criteria
            .select(root).where(getSearchPredicates(root)));
      query.setFirstResult(this.page * getPageSize()).setMaxResults(
            getPageSize());
      this.pageItems = query.getResultList();
   }

   private Predicate[] getSearchPredicates(Root<TrdAreas> root)
   {

      CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
      List<Predicate> predicatesList = new ArrayList<Predicate>();

      String nombre = this.example.getNombre();
      if (nombre != null && !"".equals(nombre))
      {
         predicatesList.add(builder.like(builder.lower(root.<String> get("nombre")), '%' + nombre.toLowerCase() + '%'));
      }

      return predicatesList.toArray(new Predicate[predicatesList.size()]);
   }

   public List<TrdAreas> getPageItems()
   {
      return this.pageItems;
   }

   public long getCount()
   {
      return this.count;
   }

   /*
    * Support listing and POSTing back TrdAreas entities (e.g. from inside an
    * HtmlSelectOneMenu)
    */

   public List<TrdAreas> getAll()
   {

      CriteriaQuery<TrdAreas> criteria = this.entityManager
            .getCriteriaBuilder().createQuery(TrdAreas.class);
      return this.entityManager.createQuery(
            criteria.select(criteria.from(TrdAreas.class))).getResultList();
   }

   @Resource
   private SessionContext sessionContext;

   public Converter getConverter()
   {

      final TrdAreasBean ejbProxy = this.sessionContext.getBusinessObject(TrdAreasBean.class);

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

            return String.valueOf(((TrdAreas) value).getId());
         }
      };
   }

   /*
    * Support adding children to bidirectional, one-to-many tables
    */

   private TrdAreas add = new TrdAreas();

   public TrdAreas getAdd()
   {
      return this.add;
   }

   public TrdAreas getAdded()
   {
      TrdAreas added = this.add;
      this.add = new TrdAreas();
      return added;
   }
}
