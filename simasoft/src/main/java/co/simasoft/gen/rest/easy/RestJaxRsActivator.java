package co.simasoft.gen.jpa;

import co.simasoft.utils.*;

import java.io.*;
import java.lang.*;
import java.util.*;

import java.util.HashSet;
import java.util.Set;

/****************************************************************************************************************
* CLASE : RestJaxRsActivator                                                                                          *
*****************************************************************************************************************

AUTOR: NAIFG                                   FECHA DE INICIO: VIE 23 OCT/2015   FECHA FINAL: VIE 23 ENE/2016
       SIMASOFT Bucaramanga / SAN / Colombia   FECHA DE LA ULTIMA MODIFICACION:   VIE 23 OCT/2015 HORA: 14:30 PM

OBJETIVOS:

1- Pendiente la documentación

*---------------------------------------------------------------------------------------------------------------*
*------------------------------------------- DECLARACION DE LA CLASE -------------------------------------------*
*---------------------------------------------------------------------------------------------------------------*/

public class RestJaxRsActivator extends FileTxt {
  
//>>DECLARACION DE INSTANCIAS
      private Entidad entity = new Entidad();                                // Entidad
      private ArrayList<Atributos> atributos = new ArrayList<Atributos>();   // Atributos de la Entidad
      private ArrayList<Relation> relations = new ArrayList<Relation>();     // Relaciones de la Entidad

      Integer nro = 4;                                                       // Número de Espacios de Margen
      String name = "";                                                      // Nombre del Atributo
      String type = "";                                                      // Tipo del Atributo
      String field = "";                                                     // Nombre del Campo
      Integer len = 0;                                                           // Longitud del Campo
      Integer prec = 0;                                                          // Decimales del Campo
      String annotations = "";
//>>DECLARACION DE INSTANCIAS

/****************************************************************************************************************
* METODO..: Constructor de la clase                                                                             *
*****************************************************************************************************************

AUTOR: Nelson A Fernández Gómez                FECHA DE INICIO: MAR 27 ENE/2015   FECHA FINAL: MAR 27 ENE/2015
       SIMASOFT Bucaramanga / SAN / Colombia   FECHA DE LA ULTIMA MODIFICACION:   MAR 27 ENE/2015 HORA: 02:30 PM

OBJETIVOS:

1- Pendiente la documentacion

*---------------------------------------------------------------------------------------------------------------*
*                                           IMPLEMENTACION DEL METODO                                           *
*---------------------------------------------------------------------------------------------------------------*/

public RestJaxRsActivator(String artifactId,String groupId,Entidad entity,LinkedHashSet<String> imports) throws IOException {

//>>INICIALIZACION DE ATRIBUTOS
      this.entity = entity;
      this.atributos = entity.getAtributos();
      this.relations = entity.getRelations();
//>>FIN INICIALIZACION DE ATRIBUTOS

//>>GENERACION DEL ARCHIVO
      line("package "+groupId+";\n");

      line("import javax.ws.rs.ApplicationPath;");
      line("import javax.ws.rs.core.Application;");

      line("@ApplicationPath(\"/rest\")");
      line("public class JaxRsActivator extends Application {");
      line("}");
//>>GENERACION DEL ARCHIVO

    } // Constructor


}
