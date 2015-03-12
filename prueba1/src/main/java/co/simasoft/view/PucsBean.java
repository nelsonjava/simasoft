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
public class PucsBean implements Serializable{

   private static final long serialVersionUID = 1L;

   /*
    * Support creating and retrieving Pucs entities
   */

   private Long id;

   public Long getId(){
      return this.id;
   }

   public void setId(Long id){
      this.id = id;
   }

   private Pucs pucs;

   public Pucs getPucs(){
      return this.pucs;
   }

   public void setPucs(Pucs pucs){
      this.pucs = pucs;
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
         this.pucs = this.example;
      }
      else{
         this.pucs = findById(getId());
      }
   }

   public Pucs findById(Long id){
      return this.entityManager.find(Pucs.class, id);
   }

   /*
    * Support updating and deleting Pucs entities
   */

   public String update(){

      this.conversation.end();

      try{
         if (this.id == null){
            this.entityManager.persist(this.pucs);
            return "search?faces-redirect=true";
         }
         else{
            this.entityManager.merge(this.pucs);
            return "view?faces-redirect=true&id=" + this.pucs.getId();
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
         Pucs deletableEntity = findById(getId());
//OJO
         Iterator<Saldos> iterSaldos = deletableEntity.getSaldos().iterator();
         for (; iterSaldos.hasNext();){
            Saldos nextInSaldos = iterSaldos.next();
            nextInSaldos.setPucs(null);
            iterSaldos.remove();
            this.entityManager.merge(nextInSaldos);
         }
         Iterator<Pucs> iterObjHijos = deletableEntity.getObjHijos().iterator();
         for (; iterObjHijos.hasNext();){
            Pucs nextInObjHijos = iterObjHijos.next();
            nextInObjHijos.setObjPadre(null);
            iterObjHijos.remove();
            this.entityManager.merge(nextInObjHijos);
         }
         Iterator<Movimientos> iterMovimientos = deletableEntity.getMovimientos().iterator();
         for (; iterMovimientos.hasNext();){
            Movimientos nextInMovimientos = iterMovimientos.next();
            nextInMovimientos.setPucs(null);
            iterMovimientos.remove();
            this.entityManager.merge(nextInMovimientos);
         }
         Pucs objPadre = deletableEntity.getObjPadre();
         objPadre.getObjHijos().remove(deletableEntity);
         deletableEntity.setObjPadre(null);
         this.entityManager.merge(objPadre);
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
    * Support searching Pucs entities with pagination
   */

   private int page;
   private long count;

   private List<Pucs> pageItems;
   private Pucs example = new Pucs();

   public int getPage(){
      return this.page;
   }

   public void setPage(int page){
      this.page = page;
   }

   public int getPageSize(){
      return 10;
   }

   public Pucs getExample(){
      return this.example;
   }

   public void setExample(Pucs example){
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
      Root<Pucs> root = countCriteria.from(Pucs.class);
      countCriteria = countCriteria.select(builder.count(root)).where(getSearchPredicates(root));
      this.count = this.entityManager.createQuery(countCriteria).getSingleResult();

      // Populate this.pageItems

      CriteriaQuery<Pucs> criteria = builder.createQuery(Pucs.class);
      root = criteria.from(Pucs.class);
      TypedQuery<Pucs> query = this.entityManager.createQuery(criteria.select(root).where(getSearchPredicates(root)));
      query.setFirstResult(this.page * getPageSize()).setMaxResults(getPageSize());
      this.pageItems = query.getResultList();
   }

   private Predicate[] getSearchPredicates(Root<Pucs> root){

      CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
      List<Predicate> predicatesList = new ArrayList<Predicate>();

      // OJO
      return predicatesList.toArray(new Predicate[predicatesList.size()]);
   }

   public List<Pucs> getPageItems(){
      return this.pageItems;
   }

   public long getCount(){
      return this.count;
   }

   /*
    * Support listing and POSTing back Pucs entities (e.g. from inside an HtmlSelectOneMenu)
   */

   public List<Pucs> getAll(){
      CriteriaQuery<Pucs> criteria = this.entityManager.getCriteriaBuilder().createQuery(Pucs.class);
      return this.entityManager.createQuery(criteria.select(criteria.from(Pucs.class))).getResultList();
   }

   @Resource
   private SessionContext sessionContext;

   public Converter getConverter(){

      final PucsBean ejbProxy = this.sessionContext.getBusinessObject(PucsBean.class);

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
            return String.valueOf(((Pucs) value).getId());
         }

      };
   }

   //OJO
   /*
    * Support adding children to bidirectional, one-to-many tables
   */

   private Pucs add = new Pucs();

   public Pucs getAdd(){
      return this.add;
   }

   public Pucs getAdded(){
      Pucs added = this.add;
      this.add = new Pucs();
      return added;
   }

}
