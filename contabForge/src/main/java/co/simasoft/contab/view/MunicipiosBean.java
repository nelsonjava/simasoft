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

import co.simasoft.models.base.paises.Municipios;
import co.simasoft.models.base.paises.Departamentos;
import co.simasoft.models.base.paises.Localidades;
import co.simasoft.models.base.paises.TiposMunicipios;
import java.util.Iterator;

/**
 * Backing bean for Municipios entities.
 * <p/>
 * This class provides CRUD functionality for all Municipios entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class MunicipiosBean implements Serializable
{

   private static final long serialVersionUID = 1L;

   /*
    * Support creating and retrieving Municipios entities
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

   private Municipios municipios;

   public Municipios getMunicipios()
   {
      return this.municipios;
   }

   public void setMunicipios(Municipios municipios)
   {
      this.municipios = municipios;
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
         this.municipios = this.example;
      }
      else
      {
         this.municipios = findById(getId());
      }
   }

   public Municipios findById(Long id)
   {

      return this.entityManager.find(Municipios.class, id);
   }

   /*
    * Support updating and deleting Municipios entities
    */

   public String update()
   {
      this.conversation.end();

      try
      {
         if (this.id == null)
         {
            this.entityManager.persist(this.municipios);
            return "search?faces-redirect=true";
         }
         else
         {
            this.entityManager.merge(this.municipios);
            return "view?faces-redirect=true&id=" + this.municipios.getId();
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
         Municipios deletableEntity = findById(getId());
         TiposMunicipios tiposMunicipios = deletableEntity.getTiposMunicipios();
         tiposMunicipios.getMunicipios().remove(deletableEntity);
         deletableEntity.setTiposMunicipios(null);
         this.entityManager.merge(tiposMunicipios);
         Departamentos departamentos = deletableEntity.getDepartamentos();
         departamentos.getMunicipios().remove(deletableEntity);
         deletableEntity.setDepartamentos(null);
         this.entityManager.merge(departamentos);
         Iterator<Localidades> iterLocalidades = deletableEntity.getLocalidades().iterator();
         for (; iterLocalidades.hasNext();)
         {
            Localidades nextInLocalidades = iterLocalidades.next();
            nextInLocalidades.setMunicipios(null);
            iterLocalidades.remove();
            this.entityManager.merge(nextInLocalidades);
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
    * Support searching Municipios entities with pagination
    */

   private int page;
   private long count;
   private List<Municipios> pageItems;

   private Municipios example = new Municipios();

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

   public Municipios getExample()
   {
      return this.example;
   }

   public void setExample(Municipios example)
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
      Root<Municipios> root = countCriteria.from(Municipios.class);
      countCriteria = countCriteria.select(builder.count(root)).where(
            getSearchPredicates(root));
      this.count = this.entityManager.createQuery(countCriteria)
            .getSingleResult();

      // Populate this.pageItems

      CriteriaQuery<Municipios> criteria = builder.createQuery(Municipios.class);
      root = criteria.from(Municipios.class);
      TypedQuery<Municipios> query = this.entityManager.createQuery(criteria
            .select(root).where(getSearchPredicates(root)));
      query.setFirstResult(this.page * getPageSize()).setMaxResults(
            getPageSize());
      this.pageItems = query.getResultList();
   }

   private Predicate[] getSearchPredicates(Root<Municipios> root)
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
      TiposMunicipios tiposMunicipios = this.example.getTiposMunicipios();
      if (tiposMunicipios != null)
      {
         predicatesList.add(builder.equal(root.get("tiposMunicipios"), tiposMunicipios));
      }
      Departamentos departamentos = this.example.getDepartamentos();
      if (departamentos != null)
      {
         predicatesList.add(builder.equal(root.get("departamentos"), departamentos));
      }

      return predicatesList.toArray(new Predicate[predicatesList.size()]);
   }

   public List<Municipios> getPageItems()
   {
      return this.pageItems;
   }

   public long getCount()
   {
      return this.count;
   }

   /*
    * Support listing and POSTing back Municipios entities (e.g. from inside an
    * HtmlSelectOneMenu)
    */

   public List<Municipios> getAll()
   {

      CriteriaQuery<Municipios> criteria = this.entityManager
            .getCriteriaBuilder().createQuery(Municipios.class);
      return this.entityManager.createQuery(
            criteria.select(criteria.from(Municipios.class))).getResultList();
   }

   @Resource
   private SessionContext sessionContext;

   public Converter getConverter()
   {

      final MunicipiosBean ejbProxy = this.sessionContext.getBusinessObject(MunicipiosBean.class);

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

            return String.valueOf(((Municipios) value).getId());
         }
      };
   }

   /*
    * Support adding children to bidirectional, one-to-many tables
    */

   private Municipios add = new Municipios();

   public Municipios getAdd()
   {
      return this.add;
   }

   public Municipios getAdded()
   {
      Municipios added = this.add;
      this.add = new Municipios();
      return added;
   }
}
