package co.simasoft.gen.sql;

import co.simasoft.utils.*;

import java.io.*;
import java.lang.*;
import java.util.*;

import java.util.HashSet;
import java.util.Set;

/****************************************************************************************************************
* CLASE : SqlH2                                                                                                 *
*****************************************************************************************************************

AUTOR: Nelson A Fern�ndez G�mez                FECHA DE INICIO: JUE 26 MAR/2015   FECHA FINAL: JUE 26 MAR/2015
       SIMASOFT Bucaramanga / SAN / Colombia   FECHA DE LA ULTIMA MODIFICACION:   JUE 26 MAR/2015 HORA: 02:15 PM

OBJETIVOS:

1- Genera el codigo java para generar los registros de la entidad.

2- El id es de tipo long

3- Trabaja bien en H2.

*---------------------------------------------------------------------------------------------------------------*
*------------------------------------------- DECLARACION DE LA CLASE -------------------------------------------*
*---------------------------------------------------------------------------------------------------------------*/

public class SqlH2 extends FileTxt {

//>>DECLARACION DE INSTANCIAS
      private Entidad entity = new Entidad();                                // Entidad
      private ArrayList<Atributos> atributos = new ArrayList<Atributos>();   // Atributos de la Entidad
      private ArrayList<Relation> relations = new ArrayList<Relation>();     // Relaciones de la Entidad

      Integer nro = 4;                                                       // N�mero de Espacios de Margen
      String name = "";                                                      // Nombre del Atributo
      String type = "";                                                      // Tipo del Atributo
      String field = "";                                                     // Nombre del Campo
      Integer len;                                                           // Longitud del Campo
      Integer prec;                                                          // Decimales del Campo
//>>DECLARACION DE INSTANCIAS

/****************************************************************************************************************
* METODO..: Constructor de la clase                                                                             *
*****************************************************************************************************************

AUTOR: Nelson A Fern�ndez G�mez                FECHA DE INICIO: JUE 26 MAR/2015   FECHA FINAL: JUE 26 MAR/2015
       SIMASOFT Bucaramanga / SAN / Colombia   FECHA DE LA ULTIMA MODIFICACION:   JUE 26 MAR/2015 HORA: 02:15 PM

OBJETIVOS:

1- Inicializa los atributos de la clase, que se van a usar para construir el archivo .java del bean de entidad.

*---------------------------------------------------------------------------------------------------------------*
*                                           IMPLEMENTACION DEL METODO                                           *
*---------------------------------------------------------------------------------------------------------------*/

public SqlH2(String artifactId,String groupId,ArrayList<Entidad> entidades,LinkedHashSet<String> imports) throws IOException {

line("package co.simasoft.setup;\n");

line("import co.simasoft.models.naif.domainmodels.*;\n");

line("import co.simasoft.utils.*;\n");

line("import java.util.*;");
line("import java.util.Calendar;");
line("import java.util.Random;");
line("import javax.ejb.LocalBean;");
line("import javax.ejb.Singleton;");
line("import javax.inject.Named;");
line("import javax.persistence.EntityManager;");
line("import javax.persistence.PersistenceContext;");
line("import org.jboss.logging.Logger;\n");

line("@Singleton");
line("@LocalBean");
line("@Named(\""+artifactId+"Setup\")");
line("public class "+artifactId+"Setup {\n");

line("    private static final String QUERYA = \"SELECT c FROM TypesAttributes c WHERE c.name LIKE :custName\";");
line("    private static final String QUERYB = \"SELECT c FROM Entities c WHERE c.name LIKE :custName\";");
line("    private static final String QUERYC = \"SELECT c FROM Cardinalities c WHERE c.name LIKE :custName\";\n");

line("    @PersistenceContext(unitName = \"DomainModelsPU-JTA\")");
line("    private EntityManager em;\n");

line("    private static final Logger log = Logger.getLogger("+artifactId+"Setup.class.getName());\n");

line("    public TypesAttributes findTypesAttributes(String name) {\n");

line("        TypesAttributes typesAttributes = new TypesAttributes();");
line("        List<TypesAttributes> results = em.createQuery(QUERYA).setParameter(\"custName\", name).getResultList();\n");

line("        if (!results.isEmpty()) {");
line("           typesAttributes = results.get(0);");
line("        }");
line("        return typesAttributes;");
line("    }\n");

line("    public Entities findEntities(String name) {\n");

line("        Entities entities = new Entities();");
line("        List<Entities> results = em.createQuery(QUERYB).setParameter(\"custName\", name).getResultList();\n");

line("        if (!results.isEmpty()) {");
line("           entities = results.get(0);");
line("        }");
line("        return entities;");
line("    }\n");

line("    public Cardinalities findCardinalities(String name) {\n");

line("        Cardinalities cardinalities = new Cardinalities();");
line("        List<Cardinalities> results = em.createQuery(QUERYC).setParameter(\"custName\", name).getResultList();\n");

line("        if (!results.isEmpty()) {");
line("           cardinalities = results.get(0);");
line("        }");
line("        return cardinalities;");
line("    }\n");

line("    public void data() {\n");

line("        DomainModels domainModels = new DomainModels();");
line("        domainModels.setName(Utils.nameRandom());");
line("        em.persist(domainModels);");
line("        em.flush();\n");

line("        GroupIds groupIds = new GroupIds();");
line("        groupIds.setGroupId(Utils.nameRandom());");
line("        groupIds.setDomainModels(domainModels);");
line("        em.persist(groupIds);");
line("        em.flush();\n");


        for(Entidad entidad : entidades) {

          if (entidad.isEntity()) {
line("        "+entidad.getName()+"(groupIds);");
          }

        }
line("        Relations();\n");

line("    } // data()\n");

//>>ENTITIES
      for(Entidad entidad : entidades) {

         this.entity = entidad;
         this.atributos = entidad.getAtributos();
         this.relations = entidad.getRelations();

//=====VALIDADACION
          if (!entidad.isEntity()) {
              continue;
          }
//=====FIN VALIDADACION

//=====ENTITY
         line("    public void "+entity.getName()+"(GroupIds groupIds) {\n");
         switch (entity.getName()) {
             case "GroupIds":
                  line("        Entities groupId = new Entities();");
                  line("        groupId.setName(\"GroupIds\");");
                  line("        groupId.setGroupIds(groupIds);");
                  line("        em.persist(groupId);");
                  line("        em.flush();");
                  break;
             default:
                  line("        Entities "+Utils._1raMin(entity.getName())+" = new Entities();");
                  line("        "+Utils._1raMin(entity.getName())+".setName(\""+entity.getName()+"\");");
                  line("        "+Utils._1raMin(entity.getName())+".setGroupIds(groupIds);");
                  line("        em.persist("+Utils._1raMin(entity.getName())+");");
                  line("        em.flush();\n");

                 break;
         } // switch
//=====ENTITY

//=====ATTRIBUTOS
            line("//      ---------------------- Attributes:"+entity.getName()+" -------------------------\n");
         for(Atributos attribute : atributos) {

            line("        TypesAttributes types"+attribute.getField()+" = new TypesAttributes();");
            line("        types"+attribute.getField()+" = findTypesAttributes(\""+attribute.getType()+"\");\n");

            switch (entity.getName()) {
                case "GroupIds":
                     if(attribute.getField().equals("groupId")){
                       line("        Attributes attributes = new Attributes();");
                       line("        attributes.setName(\"groupId\");");
                       line("        attributes.setNullable("+attribute.getNulo()+");");
                       line("        attributes.setUnico("+attribute.getUnique()+");");
                       line("        attributes.setTypesAttributes(typesgroupId);");
                       line("        attributes.setEntities(groupId);");
                       line("        em.persist(attributes);");
                       line("        em.flush();");
                     }
                     else{
                         line("        Attributes "+attribute.getField()+" = new Attributes();");
                         line("        "+attribute.getField()+".setName(\""+attribute.getField()+"\");");
                         line("        "+attribute.getField()+".setNullable("+attribute.getNulo()+");");
                         line("        "+attribute.getField()+".setUnico("+attribute.getUnique()+");");
                         line("        "+attribute.getField()+".setTypesAttributes(types"+attribute.getField()+");");
                         line("        "+attribute.getField()+".setEntities(groupId);");
                         line("        em.persist("+attribute.getField()+");");
                         line("        em.flush();\n");
                     }

                     break;
                default:
                     line("        Attributes "+attribute.getField()+" = new Attributes();");
                     line("        "+attribute.getField()+".setName(\""+attribute.getField()+"\");");
                     line("        "+attribute.getField()+".setNullable("+attribute.getNulo()+");");
                     line("        "+attribute.getField()+".setUnico("+attribute.getUnique()+");");
                     line("        "+attribute.getField()+".setTypesAttributes(types"+attribute.getField()+");");
                     line("        "+attribute.getField()+".setEntities("+Utils._1raMin(entity.getName())+");");
                     line("        em.persist("+attribute.getField()+");");
                     line("        em.flush();\n");
                     break;
            } // switch
         } // for atributos
//=====FIN ATTRIBUTOS

         line("    } // "+entity.getName()+"()\n");

      } // entidades
//>>FIN ENTITIES

//>>RELATIONS
      line("//  ---------------------- Relationships -------------------------\n");
      line("    public void Relations() {\n");
      for(Entidad entidad : entidades) {

         this.entity = entidad;
         this.atributos = entidad.getAtributos();
         this.relations = entidad.getRelations();

         for(int i=0;i<relations.size();i++) {

            Relation relation = relations.get(i);
            String n = String.valueOf(i);

            if(relation.getCardinality().equals("1..*")) {

              line("//  ---------------------- "+relation.getFrom()+" "+relation.getCardinality()+" "+relation.getTo()+" -------------------------\n");

              line("        Entities from"+relation.getFrom()+n+" = new Entities();");
              line("        Cardinalities "+relation.getFrom()+n+" = new Cardinalities();");
              line("        Entities   to"+relation.getFrom()+n+" = new Entities();");

              line("        from"+relation.getFrom()+n+" = findEntities(\""+relation.getFrom()+"\");");
              line("        "+relation.getFrom()+n+" = findCardinalities(\"Uno a Muchos Bidirecccional No.5\");");
              line("        to"+relation.getFrom()+n+" = findEntities(\""+relation.getTo()+"\");");

              line("        Relationships rel"+relation.getFrom()+n+" = new Relationships();");
              line("        rel"+relation.getFrom()+n+".setFrom(from"+relation.getFrom()+n+");");
              line("        rel"+relation.getFrom()+n+".setCardinalities("+relation.getFrom()+n+");");
              line("        rel"+relation.getFrom()+n+".setTo(to"+relation.getFrom()+n+");");
              line("        rel"+relation.getFrom()+n+".setOptionality(true);");
              line("        rel"+relation.getFrom()+n+".setIsEmbedded(false);");
              line("        em.persist(rel"+relation.getFrom()+n+");");
              line("        em.flush();\n");
            }

            if(relation.getCardinality().equals("*..*")) {

              line("//  ---------------------- "+relation.getFrom()+" "+relation.getCardinality()+" "+relation.getTo()+" -------------------------\n");

              line("        Entities from"+relation.getFrom()+n+" = new Entities();");
              line("        Cardinalities "+relation.getFrom()+n+" = new Cardinalities();");
              line("        Entities   to"+relation.getFrom()+n+" = new Entities();");

              line("        from"+relation.getFrom()+n+" = findEntities(\""+relation.getFrom()+"\");");
              line("        "+relation.getFrom()+n+" = findCardinalities(\"Muchos a Muchos Bidirecccional No.7\");");
              line("        to"+relation.getFrom()+n+" = findEntities(\""+relation.getTo()+"\");");

              line("        Relationships rel"+relation.getFrom()+n+" = new Relationships();");
              line("        rel"+relation.getFrom()+n+".setFrom(from"+relation.getFrom()+n+");");
              line("        rel"+relation.getFrom()+n+".setCardinalities("+relation.getFrom()+n+");");
              line("        rel"+relation.getFrom()+n+".setTo(to"+relation.getFrom()+n+");");
              line("        rel"+relation.getFrom()+n+".setOptionality(true);");
              line("        rel"+relation.getFrom()+n+".setIsEmbedded(false);");
              line("        em.persist(rel"+relation.getFrom()+n+");");
              line("        em.flush();\n");
            }

         } // for relations

      }
      line("    } // Relations()");
//>>FIN RELATIONS

      line("} // DomainModelsSetup\n");

    } // Contructor

} // class


