package co.simasoft.gen.sql;

import co.simasoft.utils.*;

import java.io.*;
import java.lang.*;
import java.util.*;

import java.util.HashSet;
import java.util.Set;

/****************************************************************************************************************
* CLASE : SqlH2                                                                                              *
*****************************************************************************************************************

AUTOR: Nelson A Fernández Gómez                FECHA DE INICIO: JUE 26 MAR/2015   FECHA FINAL: JUE 26 MAR/2015
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

AUTOR: Nelson A Fernández Gómez                FECHA DE INICIO: JUE 26 MAR/2015   FECHA FINAL: JUE 26 MAR/2015
       SIMASOFT Bucaramanga / SAN / Colombia   FECHA DE LA ULTIMA MODIFICACION:   JUE 26 MAR/2015 HORA: 02:15 PM

OBJETIVOS:

1- Inicializa los atributos de la clase, que se van a usar para construir el archivo .java del bean de entidad.

*---------------------------------------------------------------------------------------------------------------*
*                                           IMPLEMENTACION DEL METODO                                           *
*---------------------------------------------------------------------------------------------------------------*/

public SqlH2(String artifactId,String groupId,ArrayList<Entidad> entidades,ArrayList<String> imports) throws IOException {

line("package co.simasoft.setup;\n");

line("import co.simasoft.models.naif.DomainModels.*;\n");

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

line("    @PersistenceContext(unitName = \"DomainModelsPU-JTA\")");
line("    private EntityManager em;\n");

line("    private static final Logger log = Logger.getLogger("+artifactId+"Setup.class.getName());\n");

line("    public void data() {\n");

line("        DomainModels domainModels = new DomainModels();");
line("        domainModels.setName(\""+artifactId+"\");");
line("        em.persist(domainModels);");
line("        em.flush();\n");


        for(Entidad entidad : entidades) {

line("        "+entidad.getName()+"(domainModels);");
        }

line("    } // data()\n");

//>>ENTITIES
      for(Entidad entidad : entidades) {

         this.entity = entidad;
         this.atributos = entidad.getAtributos();
         this.relations = entidad.getRelations();

//=====ENTITY
         line("    public void "+entity.getName()+"(DomainModels domainModel) {\n");

         line("        Entities "+Utils._1raMin(entity.getName())+" = new Entities();");
         line("        "+Utils._1raMin(entity.getName())+".setName(\""+entity.getName()+"\");");
         line("        "+Utils._1raMin(entity.getName())+".setDomainModels(domainModel);");
         line("        em.persist("+Utils._1raMin(entity.getName())+");");
         line("        em.flush();\n");
//=====ENTITY

//=====ATTRIBUTOS
         for(Atributos attribute : atributos) {
            line("        Attributes "+attribute.getField()+" = new Attributes();");
            line("        "+attribute.getField()+".setName(\""+attribute.getField()+"\");");
            line("        "+attribute.getField()+".setType(\""+attribute.getType()+"\");");
            line("        "+attribute.getField()+".setEntities("+Utils._1raMin(entity.getName())+");");
            line("        em.persist("+attribute.getField()+");");
            line("        em.flush();\n");
         } // for atributos
//=====FIN ATTRIBUTOS

//=====RELACIONES DE LA CLASE
         for(Relation relation : relations) {

         } // for relations
//=====FIN RELACIONES DE LA CLASE

         line("    } // "+entity.getName()+"()\n");

      } // entidades
      line("} // DomainModelsSetup\n");
//>>FIN ENTITIES

    } // Contructor

} // class


