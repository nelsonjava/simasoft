package co.simasoft.gen.xhtml;

import co.simasoft.utils.*;

import java.io.*;
import java.lang.*;
import java.util.*;

import java.util.HashSet;
import java.util.Set;

/****************************************************************************************************************
* CLASE : Paginator                                                                                             *
*****************************************************************************************************************

AUTOR: Nelson A Fernández Gómez                FECHA DE INICIO: MAR 27 ENE/2015   FECHA FINAL: MAR 27 ENE/2015
       SIMASOFT Bucaramanga / SAN / Colombia   FECHA DE LA ULTIMA MODIFICACION:   MAR 27 ENE/2015 HORA: 02:15 PM

OBJETIVOS:

1- Genera el archivo xhtml correspondiente a una create.

2- El id es de tipo long

3- Trabaja bien en H2.

*---------------------------------------------------------------------------------------------------------------*
*------------------------------------------- DECLARACION DE LA CLASE -------------------------------------------*
*---------------------------------------------------------------------------------------------------------------*/

public class Paginator extends FileTxt {

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

public Paginator(String artifactId,String groupId,Entidad entity,ArrayList<String> imports) throws IOException {

//>>INICIALIZACION DE ATRIBUTOS
      this.entity = entity;
      this.atributos = entity.getAtributos();
      this.relations = entity.getRelations();
//>>FIN INICIALIZACION DE ATRIBUTOS

line("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");

line("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">");

line("<ui:composition xmlns=\"http://www.w3.org/1999/xhtml\"");
line("                xmlns:f=\"http://java.sun.com/jsf/core\"");
line("                xmlns:h=\"http://java.sun.com/jsf/html\"");
line("                xmlns:fn=\"http://java.sun.com/jsp/jstl/functions\"");
line("                xmlns:ui=\"http://java.sun.com/jsf/facelets\">");

line("  <h:panelGroup styleClass=\"paginator\" rendered=\"#{paginatorBean.count gt paginatorBean.pageSize}\">");

line("    <!-- Use commandLink, not outputLink, so that search criteria is not lost -->");

line("    <h:commandLink styleClass=\"btn btn-primary\" rendered=\"#{paginatorBean.page gt 0}\">");
line("      <f:param name=\"page\" value=\"#{paginatorBean.page - 1}\"/>");
line("      &lt; Previous");
line("    </h:commandLink>");

line("    <h:outputText styleClass=\"paginator-content\"");
line("                  value=\"#{paginatorBean.page * paginatorBean.pageSize + 1} to");
line("                         #{paginatorBean.page * paginatorBean.pageSize + fn:length(paginatorBean.pageItems)}");
line("                         (of #{paginatorBean.count})\"/>");

line("    <h:commandLink styleClass=\"btn btn-primary\" rendered=\"#{(paginatorBean.page + 1) * paginatorBean.pageSize lt paginatorBean.count}\">");
line("      <f:param name=\"page\" value=\"#{paginatorBean.page + 1}\"/>");
line("        Next &gt;");
line("    </h:commandLink>");

line("  </h:panelGroup>");

line("</ui:composition>");

  } // Constructor

} // class


