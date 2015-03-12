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
public class TercerosBean implements Serializable{

   private static final long serialVersionUID = 1L;

   /*
    * Support creating and retrieving Terceros entities
   */

   private Long id;

   public Long getId(){
      return this.id;
   }

   public void setId(Long id){
      this.id = id;
   }

   private Terceros terceros;

   public Terceros getTerceros(){
      return this.terceros;
   }

   public void setTerceros(Terceros terceros){
      this.terceros = terceros;
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
         this.terceros = this.example;
      }
      else{
         this.terceros = findById(getId());
      }
   }

   public Terceros findById(Long id){
      return this.entityManager.find(Terceros.class, id);
   }

   /*
    * Support updating and deleting Terceros entities
   */

   public String update(){

      this.conversation.end();

      try{
         if (this.id == null){
            this.entityManager.persist(this.terceros);
            return "search?faces-redirect=true";
         }
         else{
            this.entityManager.merge(this.terceros);
            return "view?faces-redirect=true&id=" + this.terceros.getId();
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
         Terceros deletableEntity = findById(getId());
//OJO
         Iterator<Movimientos> iterMovimientos = deletableEntity.getMovimientos().iterator();
         for (; iterMovimientos.hasNext();){
            Movimientos nextInMovimientos = iterMovimientos.next();
            nextInMovimientos.setTerceros(null);
            iterMovimientos.remove();
            this.entityManager.merge(nextInMovimientos);
         }
         Iterator<Saldos> iterSaldos = deletableEntity.getSaldos().iterator();
         for (; iterSaldos.hasNext();){
            Saldos nextInSaldos = iterSaldos.next();
            nextInSaldos.setTerceros(null);
            iterSaldos.remove();
            this.entityManager.merge(nextInSaldos);
         }
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
    * Support searching Terceros entities with pagination
   */

   private int page;
   private long count;

   private List<Terceros> pageItems;
   private Terceros example = new Terceros();

   public int getPage(){
      return this.page;
   }

   public void setPage(int page){
      this.page = page;
   }

   public int getPageSize(){
      return 10;
   }

   public Terceros getExample(){
      return this.example;
   }

   public void setExample(Terceros example){
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
      Root<Terceros> root = countCriteria.from(Terceros.class);
      countCriteria = countCriteria.select(builder.count(root)).where(getSearchPredicates(root));
      this.count = this.entityManager.createQuery(countCriteria).getSingleResult();

      // Populate this.pageItems

      CriteriaQuery<Terceros> criteria = builder.createQuery(Terceros.class);
      root = criteria.from(Terceros.class);
      TypedQuery<Terceros> query = this.entityManager.createQuery(criteria.select(root).where(getSearchPredicates(root)));
      query.setFirstResult(this.page * getPageSize()).setMaxResults(getPageSize());
      this.pageItems = query.getResultList();
   }

   private Predicate[] getSearchPredicates(Root<Terceros> root){

      CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
      List<Predicate> predicatesList = new ArrayList<Predicate>();

      // OJO
      return predicatesList.toArray(new Predicate[predicatesList.size()]);
   }

   public List<Terceros> getPageItems(){
      return this.pageItems;
   }

   public long getCount(){
      return this.count;
   }

   /*
    * Support listing and POSTing back Terceros entities (e.g. from inside an HtmlSelectOneMenu)
   */

   public List<Terceros> getAll(){
      CriteriaQuery<Terceros> criteria = this.entityManager.getCriteriaBuilder().createQuery(Terceros.class);
      return this.entityManager.createQuery(criteria.select(criteria.from(Terceros.class))).getResultList();
   }

   @Resource
   private SessionContext sessionContext;

   public Converter getConverter(){

      final TercerosBean ejbProxy = this.sessionContext.getBusinessObject(TercerosBean.class);

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
            return String.valueOf(((Terceros) value).getId());
         }

      };
   }

   //OJO
   /*
    * Support adding children to bidirectional, one-to-many tables
   */

   private Terceros add = new Terceros();

   public Terceros getAdd(){
      return this.add;
   }

   public Terceros getAdded(){
      Terceros added = this.add;
      this.add = new Terceros();
      return added;
   }

}
