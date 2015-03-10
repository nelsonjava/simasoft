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

import co.simasoft.models.iso.lmr.Lmrs;
import co.simasoft.models.iso.lmr.Dependencias;
import co.simasoft.models.iso.lmr.DisposicionFinal;
import co.simasoft.models.iso.lmr.Estados;
import co.simasoft.models.iso.lmr.Indexaciones;
import co.simasoft.models.iso.lmr.Instituciones;
import co.simasoft.models.iso.lmr.Medios;
import co.simasoft.models.iso.lmr.Responsables;
import co.simasoft.models.iso.lmr.TiposAccesos;
import co.simasoft.models.iso.lmr.TiposLmrs;
import co.simasoft.models.iso.lmr.TiposRegistros;
import co.simasoft.models.iso.lmr.TrdArchivos;
import co.simasoft.models.iso.lmr.TrdAreas;

/**
 * Backing bean for Lmrs entities.
 * <p/>
 * This class provides CRUD functionality for all Lmrs entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class LmrsBean implements Serializable
{

   private static final long serialVersionUID = 1L;

   /*
    * Support creating and retrieving Lmrs entities
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

   private Lmrs lmrs;

   public Lmrs getLmrs()
   {
      return this.lmrs;
   }

   public void setLmrs(Lmrs lmrs)
   {
      this.lmrs = lmrs;
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
         this.lmrs = this.example;
      }
      else
      {
         this.lmrs = findById(getId());
      }
   }

   public Lmrs findById(Long id)
   {

      return this.entityManager.find(Lmrs.class, id);
   }

   /*
    * Support updating and deleting Lmrs entities
    */

   public String update()
   {
      this.conversation.end();

      try
      {
         if (this.id == null)
         {
            this.entityManager.persist(this.lmrs);
            return "search?faces-redirect=true";
         }
         else
         {
            this.entityManager.merge(this.lmrs);
            return "view?faces-redirect=true&id=" + this.lmrs.getId();
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
         Lmrs deletableEntity = findById(getId());
         Estados estados = deletableEntity.getEstados();
         estados.getLmrs().remove(deletableEntity);
         deletableEntity.setEstados(null);
         this.entityManager.merge(estados);
         DisposicionFinal disposicionFinal = deletableEntity.getDisposicionFinal();
         disposicionFinal.getLmrs().remove(deletableEntity);
         deletableEntity.setDisposicionFinal(null);
         this.entityManager.merge(disposicionFinal);
         Responsables responsables = deletableEntity.getResponsables();
         responsables.getLmrs().remove(deletableEntity);
         deletableEntity.setResponsables(null);
         this.entityManager.merge(responsables);
         Instituciones instituciones = deletableEntity.getInstituciones();
         instituciones.getLmrs().remove(deletableEntity);
         deletableEntity.setInstituciones(null);
         this.entityManager.merge(instituciones);
         TiposAccesos tiposAccesos = deletableEntity.getTiposAccesos();
         tiposAccesos.getLmrs().remove(deletableEntity);
         deletableEntity.setTiposAccesos(null);
         this.entityManager.merge(tiposAccesos);
         TrdArchivos trdArchivos = deletableEntity.getTrdArchivos();
         trdArchivos.getLmrs().remove(deletableEntity);
         deletableEntity.setTrdArchivos(null);
         this.entityManager.merge(trdArchivos);
         Indexaciones indexaciones = deletableEntity.getIndexaciones();
         indexaciones.getLmrs().remove(deletableEntity);
         deletableEntity.setIndexaciones(null);
         this.entityManager.merge(indexaciones);
         TiposLmrs tiposLmrs = deletableEntity.getTiposLmrs();
         tiposLmrs.getLmrs().remove(deletableEntity);
         deletableEntity.setTiposLmrs(null);
         this.entityManager.merge(tiposLmrs);
         Dependencias dependencias = deletableEntity.getDependencias();
         dependencias.getLmrs().remove(deletableEntity);
         deletableEntity.setDependencias(null);
         this.entityManager.merge(dependencias);
         Medios medios = deletableEntity.getMedios();
         medios.getLmrs().remove(deletableEntity);
         deletableEntity.setMedios(null);
         this.entityManager.merge(medios);
         TiposRegistros tiposRegistros = deletableEntity.getTiposRegistros();
         tiposRegistros.getLmrs().remove(deletableEntity);
         deletableEntity.setTiposRegistros(null);
         this.entityManager.merge(tiposRegistros);
         TrdAreas trdAreas = deletableEntity.getTrdAreas();
         trdAreas.getLmrs().remove(deletableEntity);
         deletableEntity.setTrdAreas(null);
         this.entityManager.merge(trdAreas);
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
    * Support searching Lmrs entities with pagination
    */

   private int page;
   private long count;
   private List<Lmrs> pageItems;

   private Lmrs example = new Lmrs();

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

   public Lmrs getExample()
   {
      return this.example;
   }

   public void setExample(Lmrs example)
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
      Root<Lmrs> root = countCriteria.from(Lmrs.class);
      countCriteria = countCriteria.select(builder.count(root)).where(
            getSearchPredicates(root));
      this.count = this.entityManager.createQuery(countCriteria)
            .getSingleResult();

      // Populate this.pageItems

      CriteriaQuery<Lmrs> criteria = builder.createQuery(Lmrs.class);
      root = criteria.from(Lmrs.class);
      TypedQuery<Lmrs> query = this.entityManager.createQuery(criteria
            .select(root).where(getSearchPredicates(root)));
      query.setFirstResult(this.page * getPageSize()).setMaxResults(
            getPageSize());
      this.pageItems = query.getResultList();
   }

   private Predicate[] getSearchPredicates(Root<Lmrs> root)
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
      String estado = this.example.getEstado();
      if (estado != null && !"".equals(estado))
      {
         predicatesList.add(builder.like(builder.lower(root.<String> get("estado")), '%' + estado.toLowerCase() + '%'));
      }
      String ubicacion = this.example.getUbicacion();
      if (ubicacion != null && !"".equals(ubicacion))
      {
         predicatesList.add(builder.like(builder.lower(root.<String> get("ubicacion")), '%' + ubicacion.toLowerCase() + '%'));
      }

      return predicatesList.toArray(new Predicate[predicatesList.size()]);
   }

   public List<Lmrs> getPageItems()
   {
      return this.pageItems;
   }

   public long getCount()
   {
      return this.count;
   }

   /*
    * Support listing and POSTing back Lmrs entities (e.g. from inside an
    * HtmlSelectOneMenu)
    */

   public List<Lmrs> getAll()
   {

      CriteriaQuery<Lmrs> criteria = this.entityManager
            .getCriteriaBuilder().createQuery(Lmrs.class);
      return this.entityManager.createQuery(
            criteria.select(criteria.from(Lmrs.class))).getResultList();
   }

   @Resource
   private SessionContext sessionContext;

   public Converter getConverter()
   {

      final LmrsBean ejbProxy = this.sessionContext.getBusinessObject(LmrsBean.class);

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

            return String.valueOf(((Lmrs) value).getId());
         }
      };
   }

   /*
    * Support adding children to bidirectional, one-to-many tables
    */

   private Lmrs add = new Lmrs();

   public Lmrs getAdd()
   {
      return this.add;
   }

   public Lmrs getAdded()
   {
      Lmrs added = this.add;
      this.add = new Lmrs();
      return added;
   }
}
