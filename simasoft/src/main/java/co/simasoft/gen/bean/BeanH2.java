package co.simasoft.gen.bean;

import co.simasoft.utils.*;

import java.io.*;
import java.lang.*;
import java.util.*;

import java.util.HashSet;
import java.util.Set;

/****************************************************************************************************************
* CLASE : BeanH2                                                                                              *
*****************************************************************************************************************

AUTOR: Nelson A Fernández Gómez                FECHA DE INICIO: MAR 27 ENE/2015   FECHA FINAL: MAR 27 ENE/2015
       SIMASOFT Bucaramanga / SAN / Colombia   FECHA DE LA ULTIMA MODIFICACION:   MAR 27 ENE/2015 HORA: 02:15 PM

OBJETIVOS:

1- Genera el archivo java correspondiente al Bean de la entidad para el CRUD.

2- El id es de tipo long

3- Trabaja bien en H2.

*---------------------------------------------------------------------------------------------------------------*
*------------------------------------------- DECLARACION DE LA CLASE -------------------------------------------*
*---------------------------------------------------------------------------------------------------------------*/

public class BeanH2 extends FileTxt {

//>>DECLARACION DE INSTANCIAS
      private Entidad entity = new Entidad();                                // Entidad
      private ArrayList<Atributos> atributos = new ArrayList<Atributos>();   // Atributos de la Entidad
      private ArrayList<Relation> relations = new ArrayList<Relation>();     // Relaciones de la Entidad

      Integer nro = 4;                                                       // Número de Espacios de Margen
      String name = "";                                                      // Nombre del Atributo
      String type = "";                                                      // Tipo del Atributo
      String field = "";                                                     // Nombre del Campo
      Integer len;                                                           // Longitud del Campo
      Integer prec;                                                          // Decimales del Campo
//>>DECLARACION DE INSTANCIAS

/****************************************************************************************************************
* METODO..: Constructor de la clase                                                                             *
*****************************************************************************************************************

AUTOR: Nelson A Fernández Gómez                FECHA DE INICIO: MAR 27 ENE/2015   FECHA FINAL: MAR 27 ENE/2015
       SIMASOFT Bucaramanga / SAN / Colombia   FECHA DE LA ULTIMA MODIFICACION:   MAR 27 ENE/2015 HORA: 02:30 PM

OBJETIVOS:

1- Inicializa los atributos de la clase, que se van a usar para construir el archivo .java del bean de entidad.

*---------------------------------------------------------------------------------------------------------------*
*                                           IMPLEMENTACION DEL METODO                                           *
*---------------------------------------------------------------------------------------------------------------*/

public BeanH2(String artifactId,String groupId,Entidad entity,LinkedHashSet<String> imports) throws IOException {

//>>INICIALIZACION DE ATRIBUTOS
      this.entity = entity;
      this.atributos = entity.getAtributos();
      this.relations = entity.getRelations();
//>>FIN INICIALIZACION DE ATRIBUTOS

line("package co.simasoft.view;\n");

line("import java.io.Serializable;");
line("import java.util.ArrayList;");
line("import java.util.List;\n");

line("import javax.annotation.Resource;");
line("import javax.ejb.SessionContext;");
line("import javax.ejb.Stateful;");
line("import javax.enterprise.context.Conversation;");
line("import javax.enterprise.context.ConversationScoped;");
line("import javax.faces.application.FacesMessage;");
line("import javax.faces.component.UIComponent;");
line("import javax.faces.context.FacesContext;");
line("import javax.faces.convert.Converter;");
line("import javax.inject.Inject;");
line("import javax.inject.Named;");
line("import javax.persistence.EntityManager;");
line("import javax.persistence.PersistenceContext;");
line("import javax.persistence.PersistenceContextType;");
line("import javax.persistence.TypedQuery;");
line("import javax.persistence.criteria.CriteriaBuilder;");
line("import javax.persistence.criteria.CriteriaQuery;");
line("import javax.persistence.criteria.Predicate;");
line("import javax.persistence.criteria.Root;\n");

        for(String paquete : imports) {
line("import "+paquete+".*;");
        }
line("import java.util.Iterator;\n");

line("@Named");
line("@Stateful");
line("@ConversationScoped");
line("public class "+entity.getName()+"Bean implements Serializable{\n");

line("   private static final long serialVersionUID = 1L;\n");

line("   /*");
line("    * Support creating and retrieving "+entity.getName()+" entities");
line("   */\n");

line("   private Long id;\n");

line("   public Long getId(){");
line("      return this.id;");
line("   }\n");

line("   public void setId(Long id){");
line("      this.id = id;");
line("   }\n");

line("   private "+entity.getName()+" "+Utils._1raMin(entity.getName())+";\n");

line("   public "+entity.getName()+" get"+entity.getName()+"(){");
line("      return this."+Utils._1raMin(entity.getName())+";");
line("   }\n");

line("   public void set"+entity.getName()+"("+entity.getName()+" "+Utils._1raMin(entity.getName())+"){");
line("      this."+Utils._1raMin(entity.getName())+" = "+Utils._1raMin(entity.getName())+";");
line("   }\n");

line("   @Inject");
line("   private Conversation conversation;\n");

line("   @PersistenceContext(unitName = \""+artifactId+"PU-JTA\", type = PersistenceContextType.EXTENDED)");
line("   private EntityManager entityManager;\n");

line("   public String create(){");
line("      this.conversation.begin();");
line("      this.conversation.setTimeout(1800000L);");
line("      return \"create?faces-redirect=true\";");
line("   }\n");

line("   public void retrieve(){\n");

line("      if (FacesContext.getCurrentInstance().isPostback()){");
line("         return;");
line("      }\n");

line("      if (this.conversation.isTransient()){");
line("         this.conversation.begin();");
line("         this.conversation.setTimeout(1800000L);");
line("      }\n");

line("      if (this.id == null){");
line("         this."+Utils._1raMin(entity.getName())+" = this.example;");
line("      }");
line("      else{");
line("         this."+Utils._1raMin(entity.getName())+" = findById(getId());");
line("      }");
line("   }\n");

line("   public "+entity.getName()+" findById(Long id){");
line("      return this.entityManager.find("+entity.getName()+".class, id);");
line("   }\n");

line("   /*");
line("    * Support updating and deleting "+entity.getName()+" entities");
line("   */\n");

line("   public String update(){\n");

line("      this.conversation.end();\n");

line("      try{");
line("         if (this.id == null){");
line("            this.entityManager.persist(this."+Utils._1raMin(entity.getName())+");");
line("            return \"search?faces-redirect=true\";");
line("         }");
line("         else{");
line("            this.entityManager.merge(this."+Utils._1raMin(entity.getName())+");");
line("            return \"view?faces-redirect=true&id=\" + this."+Utils._1raMin(entity.getName())+".getId();");
line("         }");
line("      }\n");

line("      catch (Exception e){");
line("         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));");
line("         return null;");
line("      }\n");

line("   }");

line("   public String delete(){\n");

line("      this.conversation.end();\n");

line("      try{");

line("         "+entity.getName()+" deletableEntity = findById(getId());");

line("//OJO");

for(Relation relation : relations) {

   if(relation.getCardinality().equals("*..1")) {
     if (relation.getFrom().equals(relation.getTo())){   // Relación Unitaria

line("         "+relation.getTo()+" objPadre = deletableEntity.getObjPadre();");
line("         objPadre.getObjHijos().remove(deletableEntity);");
line("         deletableEntity.setObjPadre(null);");
line("         this.entityManager.merge(objPadre);");

     }
     else{
         if(relation.getName() == null || relation.getName() == "" ){

line("         "+relation.getTo()+" "+Utils._1raMin(relation.getTo())+" = deletableEntity.get"+relation.getTo()+"();");
line("         "+Utils._1raMin(relation.getTo())+".get"+entity.getName()+"().remove(deletableEntity);");
line("         deletableEntity.set"+relation.getTo()+"(null);");
line("         this.entityManager.merge("+Utils._1raMin(relation.getTo())+");");

         }

         else{

line("         "+relation.getTo()+" "+ relation.getName() +" = deletableEntity.get"+Utils._1raMay(relation.getName())+"();");
line("         "+ relation.getName() + ".get"+ Utils._1raMay(relation.getName()) +"().remove(deletableEntity);");
line("         deletableEntity.set"+ Utils._1raMay(relation.getName()) +"(null);");
line("         this.entityManager.merge("+ relation.getName() +");");

         }

     }
   }

   if(relation.getCardinality().equals("1..*")) {
      if(relation.getFrom().equals(relation.getTo())){  // Relación Unitaria

line("         Iterator<"+relation.getTo()+"> iterObjHijos = deletableEntity.getObjHijos().iterator();");
line("         for (; iterObjHijos.hasNext();){");
line("            "+relation.getTo()+" nextInObjHijos = iterObjHijos.next();");
line("            nextInObjHijos.setObjPadre(null);");
line("            iterObjHijos.remove();");
line("            this.entityManager.merge(nextInObjHijos);");
line("         }");

      }
      else{
         if(relation.getName() == null || relation.getName() == "" ){
line("         Iterator<"+relation.getTo()+"> iter"+relation.getTo()+" = deletableEntity.get"+relation.getTo()+"().iterator();");
line("         for (; iter"+relation.getTo()+".hasNext();){");
line("            "+relation.getTo()+" nextIn"+relation.getTo()+" = iter"+relation.getTo()+".next();");
line("            nextIn"+relation.getTo()+".set"+entity.getName()+"(null);");
line("            iter"+relation.getTo()+".remove();");
line("            this.entityManager.merge(nextIn"+relation.getTo()+");");
line("         }");
         }
         else{
line("         Iterator<" + relation.getTo() + "> iter"+ Utils._1raMay(relation.getName()) +" = deletableEntity.get"+ Utils._1raMay(relation.getName()) + "().iterator();");
line("         for (; iter"+Utils._1raMay(relation.getName())+".hasNext();){");
line("            "+relation.getTo()+" nextIn" + Utils._1raMay(relation.getName()) + " = iter" + Utils._1raMay(relation.getName()) + ".next();");
line("            nextIn" + Utils._1raMay(relation.getName()) + ".set"+ Utils._1raMay(relation.getName()) +"(null);");
line("            iter" + Utils._1raMay(relation.getName()) + ".remove();");
line("            this.entityManager.merge(nextIn" + Utils._1raMay(relation.getName()) + ");");
line("         }");
         }
      }
   }
}

line("         this.entityManager.remove(deletableEntity);");
line("         this.entityManager.flush();");
line("         return \"search?faces-redirect=true\";");
line("      }");
line("      catch (Exception e){");
line("         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));");
line("         return null;");
line("      }");
line("   }\n");

line("   /*");
line("    * Support searching "+entity.getName()+" entities with pagination");
line("   */\n");

line("   private int page;");
line("   private long count;\n");

line("   private List<"+entity.getName()+"> pageItems;");
line("   private "+entity.getName()+" example = new "+entity.getName()+"();\n");

line("   public int getPage(){");
line("      return this.page;");
line("   }\n");

line("   public void setPage(int page){");
line("      this.page = page;");
line("   }\n");

line("   public int getPageSize(){");
line("      return 10;");
line("   }\n");

line("   public "+entity.getName()+" getExample(){");
line("      return this.example;");
line("   }\n");

line("   public void setExample("+entity.getName()+" example){");
line("      this.example = example;");
line("   }\n");

line("   public String search(){");
line("      this.page = 0;");
line("      return null;");
line("   }\n");

line("   public void paginate(){\n");

line("      CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();\n");

line("      // Populate this.count\n");

line("      CriteriaQuery<Long> countCriteria = builder.createQuery(Long.class);");
line("      Root<"+entity.getName()+"> root = countCriteria.from("+entity.getName()+".class);");
line("      countCriteria = countCriteria.select(builder.count(root)).where(getSearchPredicates(root));");
line("      this.count = this.entityManager.createQuery(countCriteria).getSingleResult();\n");

line("      // Populate this.pageItems\n");

line("      CriteriaQuery<"+entity.getName()+"> criteria = builder.createQuery("+entity.getName()+".class);");
line("      root = criteria.from("+entity.getName()+".class);");
line("      TypedQuery<"+entity.getName()+"> query = this.entityManager.createQuery(criteria.select(root).where(getSearchPredicates(root)));");
line("      query.setFirstResult(this.page * getPageSize()).setMaxResults(getPageSize());");
line("      this.pageItems = query.getResultList();");
line("   }\n");

line("   private Predicate[] getSearchPredicates(Root<"+entity.getName()+"> root){\n");

line("      CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();");
line("      List<Predicate> predicatesList = new ArrayList<Predicate>();\n");


line("      // OJO");
/*
line("      String nombre = this.example.getNombre();");
line("      if (nombre != null && !\"\".equals(nombre)){");
line("         predicatesList.add(builder.like(builder.lower(root.<String> get(\"nombre\")), '%' + nombre.toLowerCase() + '%'));");
line("      }\n");
*/

line("      return predicatesList.toArray(new Predicate[predicatesList.size()]);");
line("   }\n");

line("   public List<"+entity.getName()+"> getPageItems(){");
line("      return this.pageItems;");
line("   }\n");

line("   public long getCount(){");
line("      return this.count;");
line("   }\n");

line("   /*");
line("    * Support listing and POSTing back "+entity.getName()+" entities (e.g. from inside an HtmlSelectOneMenu)");
line("   */\n");

line("   public List<"+entity.getName()+"> getAll(){");
line("      CriteriaQuery<"+entity.getName()+"> criteria = this.entityManager.getCriteriaBuilder().createQuery("+entity.getName()+".class);");
line("      return this.entityManager.createQuery(criteria.select(criteria.from("+entity.getName()+".class))).getResultList();");
line("   }\n");

line("   @Resource");
line("   private SessionContext sessionContext;\n");

line("   public Converter getConverter(){\n");

line("      final "+entity.getName()+"Bean ejbProxy = this.sessionContext.getBusinessObject("+entity.getName()+"Bean.class);\n");

line("      return new Converter(){\n");

line("         @Override");
line("         public Object getAsObject(FacesContext context,UIComponent component, String value){");
line("            return ejbProxy.findById(Long.valueOf(value));");
line("         }\n");

line("         @Override");
line("         public String getAsString(FacesContext context,UIComponent component, Object value){");
line("            if (value == null){");
line("               return \"\";");
line("            }");
line("            return String.valueOf((("+entity.getName()+") value).getId());");
line("         }\n");

line("      };");
line("   }\n");

line("   //OJO");
line("   /*");
line("    * Support adding children to bidirectional, one-to-many tables");
line("   */\n");

line("   private "+entity.getName()+" add = new "+entity.getName()+"();\n");

line("   public "+entity.getName()+" getAdd(){");
line("      return this.add;");
line("   }\n");

line("   public "+entity.getName()+" getAdded(){");
line("      "+entity.getName()+" added = this.add;");
line("      this.add = new "+entity.getName()+"();");
line("      return added;");
line("   }\n");

line("}");


  } // Constructor

} // Clase

