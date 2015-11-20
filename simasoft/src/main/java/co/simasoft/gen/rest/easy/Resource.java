package co.simasoft.gen.rest;

import co.simasoft.utils.*;

import java.io.*;
import java.lang.*;
import java.util.*;

import java.util.HashSet;
import java.util.Set;

/****************************************************************************************************************
* CLASE : Resource                                                                                          *
*****************************************************************************************************************

AUTOR: NAIFG                                   FECHA DE INICIO: VIE 20 NOV/2015   FECHA FINAL: VIE 20 NOV/2015
       SIMASOFT Bucaramanga / SAN / Colombia   FECHA DE LA ULTIMA MODIFICACION:   VIE 20 NOV/2015 HORA: 08:45 AM

OBJETIVOS:

1- Genera el archivo java correspondiente a

2-

3-

*---------------------------------------------------------------------------------------------------------------*
*------------------------------------------- DECLARACION DE LA CLASE -------------------------------------------*
*---------------------------------------------------------------------------------------------------------------*/

public class Resource extends FileTxt {

//>>DECLARACION DE INSTANCIAS
      private Entidad entity = new Entidad();                                // Entidad
      private ArrayList<Atributos> atributos = new ArrayList<Atributos>();   // Atributos de la Entidad
      private ArrayList<Relation> relations = new ArrayList<Relation>();     // Relaciones de la Entidad
//>>DECLARACION DE INSTANCIAS

/****************************************************************************************************************
* METODO..: Constructor de la clase                                                                             *
*****************************************************************************************************************

AUTOR: NAIFG                                   FECHA DE INICIO: VIE 20 NOV/2015   FECHA FINAL: VIE 20 NOV/2015
       SIMASOFT Bucaramanga / SAN / Colombia   FECHA DE LA ULTIMA MODIFICACION:   VIE 20 NOV/2015 HORA: 08:45 AM

OBJETIVOS:

1-

*---------------------------------------------------------------------------------------------------------------*
*                                           IMPLEMENTACION DEL METODO                                           *
*---------------------------------------------------------------------------------------------------------------*/

public Resource(String artifactId,String groupId,Entidad entity,LinkedHashSet<String> imports) throws IOException {

//>>INICIALIZACION DE ATRIBUTOS
      this.entity = entity;
      this.atributos = entity.getAtributos();
      this.relations = entity.getRelations();
//>>FIN INICIALIZACION DE ATRIBUTOS

//>>PAQUETE
      line("package co.simasoft.services;");
//>>FIN PAQUETE

//>>IMPORTS
      line("import javax.ws.rs.Path;\n");

      for (String impor : imports) {
         line(impor);
      }
      line("\n");
//>>FIN IMPORTS

//>>GENERACION DEL ARCHIVO
      line("@Path(\"/"+entity.getName().toLowerCase()+"\")");
      line("public class "+entity.getName()+"Resource extends BaseResource<"+entity.getName()+"> {");

      line("    public "+entity.getName()+"Resource() {");
      line("    	super("+entity.getName()+".class);");
      line("    }");

      line("}");
//>>FIN GENERACION DEL ARCHIVO

} // Constructor

} // class