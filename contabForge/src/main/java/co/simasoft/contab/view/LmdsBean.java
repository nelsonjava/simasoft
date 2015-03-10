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

import co.simasoft.models.iso.lmd.Lmds;
import co.simasoft.models.iso.lmd.EstadosDocuementos;
import co.simasoft.models.iso.lmd.TiposDocumentos;

/**
 * Backing bean for Lmds entities.
 * <p/>
 * This class provides CRUD functionality for all Lmds entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class LmdsBean implements Serializable
{

   private static final long serialVersionUID = 1L;

   /*
    * Support creating and retrieving Lmds entities
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

   private Lmds lmds;

   public Lmds getLmds()
   {
      return this.lmds;
   }

   public void setLmds(Lmds lmds)
   {
      this.lmds = lmds;
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
         this.lmds = this.example;
      }
      else
      {
         this.lmds = findById(getId());
      }
   }

   public Lmds findById(Long id)
   {

      return this.entityManager.find(Lmds.class, id);
   }

   /*
    * Support updating and deleting Lmds entities
    */

   public String update()
   {
      this.conversation.end();

      try
      {
         if (this.id == null)
         {
            this.entityManager.persist(this.lmds);
            return "search?faces-redirect=true";
         }
         else
         {
            this.entityManager.merge(this.lmds);
            return "view?faces-redirect=true&id=" + this.lmds.getId();
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
         Lmds deletableEntity = findById(getId());
         TiposDocumentos tiposDocumentos = deletableEntity.getTiposDocumentos();
         tiposDocumentos.getLmds().remove(deletableEntity);
         deletableEntity.setTiposDocumentos(null);
         this.entityManager.merge(tiposDocumentos);
         EstadosDocuementos estadosDocuementos = deletableEntity.getEstadosDocuementos();
         estadosDocuementos.getLmds().remove(deletableEntity);
         deletableEntity.setEstadosDocuementos(null);
         this.entityManager.merge(estadosDocuementos);
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
    * Support searching Lmds entities with pagination
    */

   private int page;
   private long count;
   private List<Lmds> pageItems;

   private Lmds example = new Lmds();

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

   public Lmds getExample()
   {
      return this.example;
   }

   public void setExample(Lmds example)
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
      Root<Lmds> root = countCriteria.from(Lmds.class);
      countCriteria = countCriteria.select(builder.count(root)).where(
            getSearchPredicates(root));
      this.count = this.entityManager.createQuery(countCriteria)
            .getSingleResult();

      // Populate this.pageItems

      CriteriaQuery<Lmds> criteria = builder.createQuery(Lmds.class);
      root = criteria.from(Lmds.class);
      TypedQuery<Lmds> query = this.entityManager.createQuery(criteria
            .select(root).where(getSearchPredicates(root)));
      query.setFirstResult(this.page * getPageSize()).setMaxResults(
            getPageSize());
      this.pageItems = query.getResultList();
   }

   private Predicate[] getSearchPredicates(Root<Lmds> root)
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
      String version = this.example.getVersion();
      if (version != null && !"".equals(version))
      {
         predicatesList.add(builder.like(builder.lower(root.<String> get("version")), '%' + version.toLowerCase() + '%'));
      }
      String ubicacion = this.example.getUbicacion();
      if (ubicacion != null && !"".equals(ubicacion))
      {
         predicatesList.add(builder.like(builder.lower(root.<String> get("ubicacion")), '%' + ubicacion.toLowerCase() + '%'));
      }
      String link = this.example.getLink();
      if (link != null && !"".equals(link))
      {
         predicatesList.add(builder.like(builder.lower(root.<String> get("link")), '%' + link.toLowerCase() + '%'));
      }

      return predicatesList.toArray(new Predicate[predicatesList.size()]);
   }

   public List<Lmds> getPageItems()
   {
      return this.pageItems;
   }

   public long getCount()
   {
      return this.count;
   }

   /*
    * Support listing and POSTing back Lmds entities (e.g. from inside an
    * HtmlSelectOneMenu)
    */

   public List<Lmds> getAll()
   {

      CriteriaQuery<Lmds> criteria = this.entityManager
            .getCriteriaBuilder().createQuery(Lmds.class);
      return this.entityManager.createQuery(
            criteria.select(criteria.from(Lmds.class))).getResultList();
   }

   @Resource
   private SessionContext sessionContext;

   public Converter getConverter()
   {

      final LmdsBean ejbProxy = this.sessionContext.getBusinessObject(LmdsBean.class);

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

            return String.valueOf(((Lmds) value).getId());
         }
      };
   }

   /*
    * Support adding children to bidirectional, one-to-many tables
    */

   private Lmds add = new Lmds();

   public Lmds getAdd()
   {
      return this.add;
   }

   public Lmds getAdded()
   {
      Lmds added = this.add;
      this.add = new Lmds();
      return added;
   }
}
