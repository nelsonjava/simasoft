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

import co.simasoft.models.base.mails.Mails;
import co.simasoft.models.base.empresas.Empresas;
import co.simasoft.models.base.personas.Personas;

/**
 * Backing bean for Mails entities.
 * <p/>
 * This class provides CRUD functionality for all Mails entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class MailsBean implements Serializable
{

   private static final long serialVersionUID = 1L;

   /*
    * Support creating and retrieving Mails entities
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

   private Mails mails;

   public Mails getMails()
   {
      return this.mails;
   }

   public void setMails(Mails mails)
   {
      this.mails = mails;
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
         this.mails = this.example;
      }
      else
      {
         this.mails = findById(getId());
      }
   }

   public Mails findById(Long id)
   {

      return this.entityManager.find(Mails.class, id);
   }

   /*
    * Support updating and deleting Mails entities
    */

   public String update()
   {
      this.conversation.end();

      try
      {
         if (this.id == null)
         {
            this.entityManager.persist(this.mails);
            return "search?faces-redirect=true";
         }
         else
         {
            this.entityManager.merge(this.mails);
            return "view?faces-redirect=true&id=" + this.mails.getId();
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
         Mails deletableEntity = findById(getId());

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
    * Support searching Mails entities with pagination
    */

   private int page;
   private long count;
   private List<Mails> pageItems;

   private Mails example = new Mails();

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

   public Mails getExample()
   {
      return this.example;
   }

   public void setExample(Mails example)
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
      Root<Mails> root = countCriteria.from(Mails.class);
      countCriteria = countCriteria.select(builder.count(root)).where(
            getSearchPredicates(root));
      this.count = this.entityManager.createQuery(countCriteria)
            .getSingleResult();

      // Populate this.pageItems

      CriteriaQuery<Mails> criteria = builder.createQuery(Mails.class);
      root = criteria.from(Mails.class);
      TypedQuery<Mails> query = this.entityManager.createQuery(criteria
            .select(root).where(getSearchPredicates(root)));
      query.setFirstResult(this.page * getPageSize()).setMaxResults(
            getPageSize());
      this.pageItems = query.getResultList();
   }

   private Predicate[] getSearchPredicates(Root<Mails> root)
   {

      CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
      List<Predicate> predicatesList = new ArrayList<Predicate>();

      String mail = this.example.getMail();
      if (mail != null && !"".equals(mail))
      {
         predicatesList.add(builder.like(builder.lower(root.<String> get("mail")), '%' + mail.toLowerCase() + '%'));
      }
      String observacion = this.example.getObservacion();
      if (observacion != null && !"".equals(observacion))
      {
         predicatesList.add(builder.like(builder.lower(root.<String> get("observacion")), '%' + observacion.toLowerCase() + '%'));
      }
      Personas personas = this.example.getPersonas();
      if (personas != null)
      {
         predicatesList.add(builder.equal(root.get("personas"), personas));
      }
      Empresas empresas = this.example.getEmpresas();
      if (empresas != null)
      {
         predicatesList.add(builder.equal(root.get("empresas"), empresas));
      }

      return predicatesList.toArray(new Predicate[predicatesList.size()]);
   }

   public List<Mails> getPageItems()
   {
      return this.pageItems;
   }

   public long getCount()
   {
      return this.count;
   }

   /*
    * Support listing and POSTing back Mails entities (e.g. from inside an
    * HtmlSelectOneMenu)
    */

   public List<Mails> getAll()
   {

      CriteriaQuery<Mails> criteria = this.entityManager
            .getCriteriaBuilder().createQuery(Mails.class);
      return this.entityManager.createQuery(
            criteria.select(criteria.from(Mails.class))).getResultList();
   }

   @Resource
   private SessionContext sessionContext;

   public Converter getConverter()
   {

      final MailsBean ejbProxy = this.sessionContext.getBusinessObject(MailsBean.class);

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

            return String.valueOf(((Mails) value).getId());
         }
      };
   }

   /*
    * Support adding children to bidirectional, one-to-many tables
    */

   private Mails add = new Mails();

   public Mails getAdd()
   {
      return this.add;
   }

   public Mails getAdded()
   {
      Mails added = this.add;
      this.add = new Mails();
      return added;
   }
}
