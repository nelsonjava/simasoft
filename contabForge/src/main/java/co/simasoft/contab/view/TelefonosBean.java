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

import co.simasoft.models.base.telefonos.Telefonos;
import co.simasoft.models.base.direcciones.Direcciones;
import co.simasoft.models.base.empresas.Empresas;
import co.simasoft.models.base.personas.Personas;

/**
 * Backing bean for Telefonos entities.
 * <p/>
 * This class provides CRUD functionality for all Telefonos entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class TelefonosBean implements Serializable
{

   private static final long serialVersionUID = 1L;

   /*
    * Support creating and retrieving Telefonos entities
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

   private Telefonos telefonos;

   public Telefonos getTelefonos()
   {
      return this.telefonos;
   }

   public void setTelefonos(Telefonos telefonos)
   {
      this.telefonos = telefonos;
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
         this.telefonos = this.example;
      }
      else
      {
         this.telefonos = findById(getId());
      }
   }

   public Telefonos findById(Long id)
   {

      return this.entityManager.find(Telefonos.class, id);
   }

   /*
    * Support updating and deleting Telefonos entities
    */

   public String update()
   {
      this.conversation.end();

      try
      {
         if (this.id == null)
         {
            this.entityManager.persist(this.telefonos);
            return "search?faces-redirect=true";
         }
         else
         {
            this.entityManager.merge(this.telefonos);
            return "view?faces-redirect=true&id=" + this.telefonos.getId();
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
         Telefonos deletableEntity = findById(getId());

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
    * Support searching Telefonos entities with pagination
    */

   private int page;
   private long count;
   private List<Telefonos> pageItems;

   private Telefonos example = new Telefonos();

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

   public Telefonos getExample()
   {
      return this.example;
   }

   public void setExample(Telefonos example)
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
      Root<Telefonos> root = countCriteria.from(Telefonos.class);
      countCriteria = countCriteria.select(builder.count(root)).where(
            getSearchPredicates(root));
      this.count = this.entityManager.createQuery(countCriteria)
            .getSingleResult();

      // Populate this.pageItems

      CriteriaQuery<Telefonos> criteria = builder.createQuery(Telefonos.class);
      root = criteria.from(Telefonos.class);
      TypedQuery<Telefonos> query = this.entityManager.createQuery(criteria
            .select(root).where(getSearchPredicates(root)));
      query.setFirstResult(this.page * getPageSize()).setMaxResults(
            getPageSize());
      this.pageItems = query.getResultList();
   }

   private Predicate[] getSearchPredicates(Root<Telefonos> root)
   {

      CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
      List<Predicate> predicatesList = new ArrayList<Predicate>();

      String telefono = this.example.getTelefono();
      if (telefono != null && !"".equals(telefono))
      {
         predicatesList.add(builder.like(builder.lower(root.<String> get("telefono")), '%' + telefono.toLowerCase() + '%'));
      }
      Direcciones direcciones = this.example.getDirecciones();
      if (direcciones != null)
      {
         predicatesList.add(builder.equal(root.get("direcciones"), direcciones));
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

      return predicatesList.toArray(new Predicate[predicatesList.size()]);
   }

   public List<Telefonos> getPageItems()
   {
      return this.pageItems;
   }

   public long getCount()
   {
      return this.count;
   }

   /*
    * Support listing and POSTing back Telefonos entities (e.g. from inside an
    * HtmlSelectOneMenu)
    */

   public List<Telefonos> getAll()
   {

      CriteriaQuery<Telefonos> criteria = this.entityManager
            .getCriteriaBuilder().createQuery(Telefonos.class);
      return this.entityManager.createQuery(
            criteria.select(criteria.from(Telefonos.class))).getResultList();
   }

   @Resource
   private SessionContext sessionContext;

   public Converter getConverter()
   {

      final TelefonosBean ejbProxy = this.sessionContext.getBusinessObject(TelefonosBean.class);

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

            return String.valueOf(((Telefonos) value).getId());
         }
      };
   }

   /*
    * Support adding children to bidirectional, one-to-many tables
    */

   private Telefonos add = new Telefonos();

   public Telefonos getAdd()
   {
      return this.add;
   }

   public Telefonos getAdded()
   {
      Telefonos added = this.add;
      this.add = new Telefonos();
      return added;
   }
}
