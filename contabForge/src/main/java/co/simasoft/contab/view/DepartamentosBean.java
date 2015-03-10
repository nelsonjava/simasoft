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

import co.simasoft.models.base.paises.Departamentos;
import co.simasoft.models.base.paises.Municipios;
import co.simasoft.models.base.paises.Paises;
import java.util.Iterator;

/**
 * Backing bean for Departamentos entities.
 * <p/>
 * This class provides CRUD functionality for all Departamentos entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class DepartamentosBean implements Serializable
{

   private static final long serialVersionUID = 1L;

   /*
    * Support creating and retrieving Departamentos entities
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

   private Departamentos departamentos;

   public Departamentos getDepartamentos()
   {
      return this.departamentos;
   }

   public void setDepartamentos(Departamentos departamentos)
   {
      this.departamentos = departamentos;
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
         this.departamentos = this.example;
      }
      else
      {
         this.departamentos = findById(getId());
      }
   }

   public Departamentos findById(Long id)
   {

      return this.entityManager.find(Departamentos.class, id);
   }

   /*
    * Support updating and deleting Departamentos entities
    */

   public String update()
   {
      this.conversation.end();

      try
      {
         if (this.id == null)
         {
            this.entityManager.persist(this.departamentos);
            return "search?faces-redirect=true";
         }
         else
         {
            this.entityManager.merge(this.departamentos);
            return "view?faces-redirect=true&id=" + this.departamentos.getId();
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
         Departamentos deletableEntity = findById(getId());
         Iterator<Municipios> iterMunicipios = deletableEntity.getMunicipios().iterator();
         for (; iterMunicipios.hasNext();)
         {
            Municipios nextInMunicipios = iterMunicipios.next();
            nextInMunicipios.setDepartamentos(null);
            iterMunicipios.remove();
            this.entityManager.merge(nextInMunicipios);
         }
         Paises paises = deletableEntity.getPaises();
         paises.getDepartamentos().remove(deletableEntity);
         deletableEntity.setPaises(null);
         this.entityManager.merge(paises);
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
    * Support searching Departamentos entities with pagination
    */

   private int page;
   private long count;
   private List<Departamentos> pageItems;

   private Departamentos example = new Departamentos();

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

   public Departamentos getExample()
   {
      return this.example;
   }

   public void setExample(Departamentos example)
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
      Root<Departamentos> root = countCriteria.from(Departamentos.class);
      countCriteria = countCriteria.select(builder.count(root)).where(
            getSearchPredicates(root));
      this.count = this.entityManager.createQuery(countCriteria)
            .getSingleResult();

      // Populate this.pageItems

      CriteriaQuery<Departamentos> criteria = builder.createQuery(Departamentos.class);
      root = criteria.from(Departamentos.class);
      TypedQuery<Departamentos> query = this.entityManager.createQuery(criteria
            .select(root).where(getSearchPredicates(root)));
      query.setFirstResult(this.page * getPageSize()).setMaxResults(
            getPageSize());
      this.pageItems = query.getResultList();
   }

   private Predicate[] getSearchPredicates(Root<Departamentos> root)
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
      Paises paises = this.example.getPaises();
      if (paises != null)
      {
         predicatesList.add(builder.equal(root.get("paises"), paises));
      }

      return predicatesList.toArray(new Predicate[predicatesList.size()]);
   }

   public List<Departamentos> getPageItems()
   {
      return this.pageItems;
   }

   public long getCount()
   {
      return this.count;
   }

   /*
    * Support listing and POSTing back Departamentos entities (e.g. from inside an
    * HtmlSelectOneMenu)
    */

   public List<Departamentos> getAll()
   {

      CriteriaQuery<Departamentos> criteria = this.entityManager
            .getCriteriaBuilder().createQuery(Departamentos.class);
      return this.entityManager.createQuery(
            criteria.select(criteria.from(Departamentos.class))).getResultList();
   }

   @Resource
   private SessionContext sessionContext;

   public Converter getConverter()
   {

      final DepartamentosBean ejbProxy = this.sessionContext.getBusinessObject(DepartamentosBean.class);

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

            return String.valueOf(((Departamentos) value).getId());
         }
      };
   }

   /*
    * Support adding children to bidirectional, one-to-many tables
    */

   private Departamentos add = new Departamentos();

   public Departamentos getAdd()
   {
      return this.add;
   }

   public Departamentos getAdded()
   {
      Departamentos added = this.add;
      this.add = new Departamentos();
      return added;
   }
}
