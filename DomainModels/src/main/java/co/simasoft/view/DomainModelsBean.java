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

import co.simasoft.models.naif.DomainModels.DomainModels;

/**
 * Backing bean for DomainModels entities.
 * <p/>
 * This class provides CRUD functionality for all DomainModels entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class DomainModelsBean implements Serializable
{

   private static final long serialVersionUID = 1L;

   /*
    * Support creating and retrieving DomainModels entities
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

   private DomainModels domainModels;

   public DomainModels getDomainModels()
   {
      return this.domainModels;
   }

   public void setDomainModels(DomainModels domainModels)
   {
      this.domainModels = domainModels;
   }

   @Inject
   private Conversation conversation;

   @PersistenceContext(unitName = "DomainModelsPU-JTA", type = PersistenceContextType.EXTENDED)
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
         this.domainModels = this.example;
      }
      else
      {
         this.domainModels = findById(getId());
      }
   }

   public DomainModels findById(Long id)
   {

      return this.entityManager.find(DomainModels.class, id);
   }

   /*
    * Support updating and deleting DomainModels entities
    */

   public String update()
   {
      this.conversation.end();

      try
      {
         if (this.id == null)
         {
            this.entityManager.persist(this.domainModels);
            return "search?faces-redirect=true";
         }
         else
         {
            this.entityManager.merge(this.domainModels);
            return "view?faces-redirect=true&id=" + this.domainModels.getId();
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
         DomainModels deletableEntity = findById(getId());

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
    * Support searching DomainModels entities with pagination
    */

   private int page;
   private long count;
   private List<DomainModels> pageItems;

   private DomainModels example = new DomainModels();

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

   public DomainModels getExample()
   {
      return this.example;
   }

   public void setExample(DomainModels example)
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
      Root<DomainModels> root = countCriteria.from(DomainModels.class);
      countCriteria = countCriteria.select(builder.count(root)).where(
            getSearchPredicates(root));
      this.count = this.entityManager.createQuery(countCriteria)
            .getSingleResult();

      // Populate this.pageItems

      CriteriaQuery<DomainModels> criteria = builder.createQuery(DomainModels.class);
      root = criteria.from(DomainModels.class);
      TypedQuery<DomainModels> query = this.entityManager.createQuery(criteria
            .select(root).where(getSearchPredicates(root)));
      query.setFirstResult(this.page * getPageSize()).setMaxResults(
            getPageSize());
      this.pageItems = query.getResultList();
   }

   private Predicate[] getSearchPredicates(Root<DomainModels> root)
   {

      CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
      List<Predicate> predicatesList = new ArrayList<Predicate>();

      String name = this.example.getName();
      if (name != null && !"".equals(name))
      {
         predicatesList.add(builder.like(builder.lower(root.<String> get("name")), '%' + name.toLowerCase() + '%'));
      }
      String paquete = this.example.getPaquete();
      if (paquete != null && !"".equals(paquete))
      {
         predicatesList.add(builder.like(builder.lower(root.<String> get("paquete")), '%' + paquete.toLowerCase() + '%'));
      }
      String release = this.example.getRelease();
      if (release != null && !"".equals(release))
      {
         predicatesList.add(builder.like(builder.lower(root.<String> get("release")), '%' + release.toLowerCase() + '%'));
      }
      String codigo = this.example.getCodigo();
      if (codigo != null && !"".equals(codigo))
      {
         predicatesList.add(builder.like(builder.lower(root.<String> get("codigo")), '%' + codigo.toLowerCase() + '%'));
      }
      String description = this.example.getDescription();
      if (description != null && !"".equals(description))
      {
         predicatesList.add(builder.like(builder.lower(root.<String> get("description")), '%' + description.toLowerCase() + '%'));
      }

      return predicatesList.toArray(new Predicate[predicatesList.size()]);
   }

   public List<DomainModels> getPageItems()
   {
      return this.pageItems;
   }

   public long getCount()
   {
      return this.count;
   }

   /*
    * Support listing and POSTing back DomainModels entities (e.g. from inside an
    * HtmlSelectOneMenu)
    */

   public List<DomainModels> getAll()
   {

      CriteriaQuery<DomainModels> criteria = this.entityManager
            .getCriteriaBuilder().createQuery(DomainModels.class);
      return this.entityManager.createQuery(
            criteria.select(criteria.from(DomainModels.class))).getResultList();
   }

   @Resource
   private SessionContext sessionContext;

   public Converter getConverter()
   {

      final DomainModelsBean ejbProxy = this.sessionContext.getBusinessObject(DomainModelsBean.class);

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

            return String.valueOf(((DomainModels) value).getId());
         }
      };
   }

   /*
    * Support adding children to bidirectional, one-to-many tables
    */

   private DomainModels add = new DomainModels();

   public DomainModels getAdd()
   {
      return this.add;
   }

   public DomainModels getAdded()
   {
      DomainModels added = this.add;
      this.add = new DomainModels();
      return added;
   }

}
