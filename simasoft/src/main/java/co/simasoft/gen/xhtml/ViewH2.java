package co.simasoft.gen.xhtml;

import co.simasoft.utils.*;

import java.io.*;
import java.lang.*;
import java.util.*;

import java.util.HashSet;
import java.util.Set;

/****************************************************************************************************************
* CLASE : ViewH2                                                                                                *
*****************************************************************************************************************

AUTOR: Nelson A Fernández Gómez                FECHA DE INICIO: MAR 27 ENE/2015   FECHA FINAL: MAR 27 ENE/2015
       SIMASOFT Bucaramanga / SAN / Colombia   FECHA DE LA ULTIMA MODIFICACION:   MAR 27 ENE/2015 HORA: 02:15 PM

OBJETIVOS:

1- Genera el archivo xhtml correspondiente a la consulta.

2- El id es de tipo long

3- Trabaja bien en H2.

*---------------------------------------------------------------------------------------------------------------*
*------------------------------------------- DECLARACION DE LA CLASE -------------------------------------------*
*---------------------------------------------------------------------------------------------------------------*/

public class ViewH2 extends FileTxt {

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

public ViewH2(Entidad entity) throws IOException {

//>>INICIALIZACION DE ATRIBUTOS
      this.entity = entity;
      this.atributos = entity.getAtributos();
      this.relations = entity.getRelations();
//>>FIN INICIALIZACION DE ATRIBUTOS

line("<?xml version='1.0' encoding='UTF-8' ?>");
line("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">");
line("<ui:composition xmlns=\"http://www.w3.org/1999/xhtml\"");
line("        xmlns:h=\"http://java.sun.com/jsf/html\"");
line("        xmlns:f=\"http://java.sun.com/jsf/core\"");
line("        xmlns:ui=\"http://java.sun.com/jsf/facelets\"");
line("        xmlns:p=\"http://primefaces.org/ui\"");
line("        xmlns:forgeview=\"http://jboss.org/forge/view\"");
line("        template=\"/resources/scaffold/pageTemplate.xhtml\">\n");

line("        <f:metadata>");
line("                <f:viewParam name=\"id\" value='#{"+Utils._1raMin(entity.getName())+"Bean.id}'/>");
line("                <f:event type=\"preRenderView\" listener='#{"+Utils._1raMin(entity.getName())+"Bean.retrieve}'/>");
line("        </f:metadata>\n");

line("        <ui:param name=\"pageTitle\" value=\"View "+entity.getName()+"\"/>\n");

line("        <ui:define name=\"header\">");
line("                "+entity.getName());
line("        </ui:define>\n");

line("        <ui:define name=\"subheader\">");
line("                View existing "+entity.getName());
line("        </ui:define>\n");

line("        <ui:define name=\"footer\"/>\n");

line("        <ui:define name=\"main\">");
line("                <h:panelGrid columnClasses=\"label,component,required\" columns=\"3\">\n");

line(entity.attributeView("orden","double"));

          for (Atributos atributo : entity.getAtributos()){
line(entity.attributeView(atributo.getField(),atributo.getType()));
          } // entity.getAtributos()

line(entity.attributeView("observations","Text"));

          for(Relation relation : relations) {

line(entity.relationView(relation));

          } // relations

line("                </h:panelGrid>\n");

line("                <div class=\"buttons\">");
line("                        <h:link value=\"View All\" outcome=\"search\" styleClass=\"btn btn-primary\"/>");
line("                        <h:link value=\"Edit\" outcome=\"create\" includeViewParams=\"true\" styleClass=\"btn btn-primary\"/>");
line("                        <h:link value=\"Create New\" outcome=\"create\" styleClass=\"btn btn-primary\"/>");
line("                </div>");
line("        </ui:define>");
line("</ui:composition>");


    } // ViewH2

} // END : CLASS