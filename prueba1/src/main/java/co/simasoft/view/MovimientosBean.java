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

import co.simasoft.models.contable.contabilidad.*;
import java.util.Iterator;

@Named
@Stateful
@ConversationScoped
public class MovimientosBean implements Serializable{

   private static final long serialVersionUID = 1L;

   /*
    * Support creating and retrieving Movimientos entities
   */

   private Long id;

   public Long getId(){
      return this.id;
   }

   public void setId(Long id){
      this.id = id;
   }

   private Movimientos movimientos;

   public Movimientos getMovimientos(){
      return this.movimientos;
   }

   public void setMovimientos(Movimientos movimientos){
      this.movimientos = movimientos;
   }

   @Inject
   private Conversation conversation;

   @PersistenceContext(unitName = "prueba1PU-JTA", type = PersistenceContextType.EXTENDED)
   private EntityManager entityManager;

   public String create(){
      this.conversation.begin();
      this.conversation.setTimeout(1800000L);
      return "create?faces-redirect=true";
   }

   public void retrieve(){

      if (FacesContext.getCurrentInstance().isPostback()){
         return;
      }

      if (this.conversation.isTransient()){
         this.conversation.begin();
         this.conversation.setTimeout(1800000L);
      }

      if (this.id == null){
         this.movimientos = this.example;
      }
      else{
         this.movimientos = findById(getId());
      }
   }

   public Movimientos findById(Long id){
      return this.entityManager.find(Movimientos.class, id);
   }

   /*
    * Support updating and deleting Movimientos entities
   */

   public String update(){

      this.conversation.end();

      try{
         if (this.id == null){
            this.entityManager.persist(this.movimientos);
            return "search?faces-redirect=true";
         }
         else{
            this.entityManager.merge(this.movimientos);
            return "view?faces-redirect=true&id=" + this.movimientos.getId();
         }
      }

      catch (Exception e){
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
         return null;
      }

   }
   public String delete(){

      this.conversation.end();

      try{
         Movimientos deletableEntity = findById(getId());
//OJO
         Terceros terceros = deletableEntity.getTerceros();
         terceros.getMovimientos().remove(deletableEntity);
         deletableEntity.setTerceros(null);
         this.entityManager.merge(terceros);
         Pucs pucs = deletableEntity.getPucs();
         pucs.getMovimientos().remove(deletableEntity);
         deletableEntity.setPucs(null);
         this.entityManager.merge(pucs);
         this.entityManager.remove(deletableEntity);
         this.entityManager.flush();
         return "search?faces-redirect=true";
      }
      catch (Exception e){
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
         return null;
      }
   }

   /*
    * Support searching Movimientos entities with pagination
   */

   private int page;
   private long count;

   private List<Movimientos> pageItems;
   private Movimientos example = new Movimientos();

   public int getPage(){
      return this.page;
   }

   public void setPage(int page){
      this.page = page;
   }

   public int getPageSize(){
      return 10;
   }

   public Movimientos getExample(){
      return this.example;
   }

   public void setExample(Movimientos example){
      this.example = example;
   }

   public String search(){
      this.page = 0;
      return null;
   }

   public void paginate(){

      CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();

      // Populate this.count

      CriteriaQuery<Long> countCriteria = builder.createQuery(Long.class);
      Root<Movimientos> root = countCriteria.from(Movimientos.class);
      countCriteria = countCriteria.select(builder.count(root)).where(getSearchPredicates(root));
      this.count = this.entityManager.createQuery(countCriteria).getSingleResult();

      // Populate this.pageItems

      CriteriaQuery<Movimientos> criteria = builder.createQuery(Movimientos.class);
      root = criteria.from(Movimientos.class);
      TypedQuery<Movimientos> query = this.entityManager.createQuery(criteria.select(root).where(getSearchPredicates(root)));
      query.setFirstResult(this.page * getPageSize()).setMaxResults(getPageSize());
      this.pageItems = query.getResultList();
   }

   private Predicate[] getSearchPredicates(Root<Movimientos> root){

      CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
      List<Predicate> predicatesList = new ArrayList<Predicate>();

      // OJO
      return predicatesList.toArray(new Predicate[predicatesList.size()]);
   }

   public List<Movimientos> getPageItems(){
      return this.pageItems;
   }

   public long getCount(){
      return this.count;
   }

   /*
    * Support listing and POSTing back Movimientos entities (e.g. from inside an HtmlSelectOneMenu)
   */

   public List<Movimientos> getAll(){
      CriteriaQuery<Movimientos> criteria = this.entityManager.getCriteriaBuilder().createQuery(Movimientos.class);
      return this.entityManager.createQuery(criteria.select(criteria.from(Movimientos.class))).getResultList();
   }

   @Resource
   private SessionContext sessionContext;

   public Converter getConverter(){

      final MovimientosBean ejbProxy = this.sessionContext.getBusinessObject(MovimientosBean.class);

      return new Converter(){

         @Override
         public Object getAsObject(FacesContext context,UIComponent component, String value){
            return ejbProxy.findById(Long.valueOf(value));
         }

         @Override
         public String getAsString(FacesContext context,UIComponent component, Object value){
            if (value == null){
               return "";
            }
            return String.valueOf(((Movimientos) value).getId());
         }

      };
   }

   //OJO
   /*
    * Support adding children to bidirectional, one-to-many tables
   */

   private Movimientos add = new Movimientos();

   public Movimientos getAdd(){
      return this.add;
   }

   public Movimientos getAdded(){
      Movimientos added = this.add;
      this.add = new Movimientos();
      return added;
   }

}
