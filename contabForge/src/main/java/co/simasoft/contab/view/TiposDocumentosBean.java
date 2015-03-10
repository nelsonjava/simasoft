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

import co.simasoft.models.iso.lmd.TiposDocumentos;
import co.simasoft.models.iso.lmd.Lmds;
import java.util.Iterator;

/**
 * Backing bean for TiposDocumentos entities.
 * <p/>
 * This class provides CRUD functionality for all TiposDocumentos entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class TiposDocumentosBean implements Serializable
{

   private static final long serialVersionUID = 1L;

   /*
    * Support creating and retrieving TiposDocumentos entities
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

   private TiposDocumentos tiposDocumentos;

   public TiposDocumentos getTiposDocumentos()
   {
      return this.tiposDocumentos;
   }

   public void setTiposDocumentos(TiposDocumentos tiposDocumentos)
   {
      this.tiposDocumentos = tiposDocumentos;
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
         this.tiposDocumentos = this.example;
      }
      else
      {
         this.tiposDocumentos = findById(getId());
      }
   }

   public TiposDocumentos findById(Long id)
   {

      return this.entityManager.find(TiposDocumentos.class, id);
   }

   /*
    * Support updating and deleting TiposDocumentos entities
    */

   public String update()
   {
      this.conversation.end();

      try
      {
         if (this.id == null)
         {
            this.entityManager.persist(this.tiposDocumentos);
            return "search?faces-redirect=true";
         }
         else
         {
            this.entityManager.merge(this.tiposDocumentos);
            return "view?faces-redirect=true&id=" + this.tiposDocumentos.getId();
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
         TiposDocumentos deletableEntity = findById(getId());
         Iterator<Lmds> iterLmds = deletableEntity.getLmds().iterator();
         for (; iterLmds.hasNext();)
         {
            Lmds nextInLmds = iterLmds.next();
            nextInLmds.setTiposDocumentos(null);
            iterLmds.remove();
            this.entityManager.merge(nextInLmds);
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
    * Support searching TiposDocumentos entities with pagination
    */

   private int page;
   private long count;
   private List<TiposDocumentos> pageItems;

   private TiposDocumentos example = new TiposDocumentos();

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

   public TiposDocumentos getExample()
   {
      return this.example;
   }

   public void setExample(TiposDocumentos example)
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
      Root<TiposDocumentos> root = countCriteria.from(TiposDocumentos.class);
      countCriteria = countCriteria.select(builder.count(root)).where(
            getSearchPredicates(root));
      this.count = this.entityManager.createQuery(countCriteria)
            .getSingleResult();

      // Populate this.pageItems

      CriteriaQuery<TiposDocumentos> criteria = builder.createQuery(TiposDocumentos.class);
      root = criteria.from(TiposDocumentos.class);
      TypedQuery<TiposDocumentos> query = this.entityManager.createQuery(criteria
            .select(root).where(getSearchPredicates(root)));
      query.setFirstResult(this.page * getPageSize()).setMaxResults(
            getPageSize());
      this.pageItems = query.getResultList();
   }

   private Predicate[] getSearchPredicates(Root<TiposDocumentos> root)
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

      return predicatesList.toArray(new Predicate[predicatesList.size()]);
   }

   public List<TiposDocumentos> getPageItems()
   {
      return this.pageItems;
   }

   public long getCount()
   {
      return this.count;
   }

   /*
    * Support listing and POSTing back TiposDocumentos entities (e.g. from inside an
    * HtmlSelectOneMenu)
    */

   public List<TiposDocumentos> getAll()
   {

      CriteriaQuery<TiposDocumentos> criteria = this.entityManager
            .getCriteriaBuilder().createQuery(TiposDocumentos.class);
      return this.entityManager.createQuery(
            criteria.select(criteria.from(TiposDocumentos.class))).getResultList();
   }

   @Resource
   private SessionContext sessionContext;

   public Converter getConverter()
   {

      final TiposDocumentosBean ejbProxy = this.sessionContext.getBusinessObject(TiposDocumentosBean.class);

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

            return String.valueOf(((TiposDocumentos) value).getId());
         }
      };
   }

   /*
    * Support adding children to bidirectional, one-to-many tables
    */

   private TiposDocumentos add = new TiposDocumentos();

   public TiposDocumentos getAdd()
   {
      return this.add;
   }

   public TiposDocumentos getAdded()
   {
      TiposDocumentos added = this.add;
      this.add = new TiposDocumentos();
      return added;
   }
}
