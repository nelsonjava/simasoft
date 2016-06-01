package co.simasoft.gen.xhtml;

import co.simasoft.utils.*;

import java.io.*;
import java.lang.*;
import java.util.*;

import java.util.HashSet;
import java.util.Set;

/****************************************************************************************************************
* CLASE : SearchH2                                                                                              *
*****************************************************************************************************************

AUTOR: Nelson A Fernández Gómez                FECHA DE INICIO: MAR 27 ENE/2015   FECHA FINAL: MAR 27 ENE/2015
       SIMASOFT Bucaramanga / SAN / Colombia   FECHA DE LA ULTIMA MODIFICACION:   MAR 27 ENE/2015 HORA: 02:15 PM

OBJETIVOS:

1- Genera el archivo xhtml correspondiente a la busqueda.

2- El id es de tipo long

3- Trabaja bien en H2.

*---------------------------------------------------------------------------------------------------------------*
*------------------------------------------- DECLARACION DE LA CLASE -------------------------------------------*
*---------------------------------------------------------------------------------------------------------------*/

public class SearchH2 extends FileTxt {

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

public SearchH2(Entidad entity) throws IOException {

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
line("        template=\"/resources/scaffold/pageTemplate.xhtml\">\n");

line("        <f:metadata>");
line("                <f:viewParam name=\"page\" value='#{"+Utils._1raMin(entity.getName())+"Bean.page}'/>");
line("                <f:event type=\"preRenderView\" listener='#{"+Utils._1raMin(entity.getName())+"Bean.paginate}'/>");
line("        </f:metadata>\n");

line("        <ui:param name=\"pageTitle\" value=\"Search "+entity.getName()+" entities\"/>\n");

line("        <ui:define name=\"header\">");
line("                "+entity.getName());
line("        </ui:define>\n");

line("        <ui:define name=\"subheader\">");
line("                Search "+entity.getName()+" entities");
line("        </ui:define>\n");

line("        <ui:define name=\"footer\"/>\n");

line("        <ui:define name=\"main\">");
line("                <h:form id=\"search\">");
line("                        <f:validateBean disabled=\"true\">");
line("                                <h:panelGroup styleClass=\"search\">\n");

line("                                        <h:panelGrid columnClasses=\"label,component,required\" columns=\"3\">");

      for(Atributos atributo : atributos) {

         if (atributo.getIsSearch()){
             line(entity.attributeSearch(atributo.getField(),atributo.getType(),atributo.getNulo()));
         }

      } // for: atributos


line("                                        </h:panelGrid>");
line("                                        <h:panelGroup styleClass=\"buttons\">");
line("                                                <h:commandLink value=\"Search\" action='#{"+Utils._1raMin(entity.getName())+"Bean.search}' styleClass=\"btn btn-primary\"/>");
line("                                                <h:commandLink value=\"Create New\" action='#{"+Utils._1raMin(entity.getName())+"Bean.create}' styleClass=\"btn btn-primary\"/>");
line("                                        </h:panelGroup>");
line("                                </h:panelGroup>");
line("                        </f:validateBean>\n");

line("                        <h:dataTable id=\""+Utils._1raMin(entity.getName())+"BeanPageItems\" styleClass=\"data-table\" value=\"#{"+Utils._1raMin(entity.getName())+"Bean.pageItems}\" var=\"_item\">\n");


line("                                <h:column>");
line("                                        <f:facet name=\"header\">");
line("                                                <h:outputText value=\"Orden\"/>");
line("                                        </f:facet>");
line("                                        <h:link outcome=\"/admin/"+Utils._1raMin(entity.getName())+"/view\">");
line("                                                <f:param name=\"id\" value=\"#{_item.orden}\"/>");
line("                                                <h:outputText id=\"itemOrden\" value=\"#{_item.orden}\"/>");
line("                                        </h:link>");
line("                                </h:column>\n");


      for(Atributos atributo : atributos) {

         if (atributo.getIsViewColumn()){
             line(entity.columnSearch(atributo.getField(),atributo.getType()));
         }



      } // for: atributos

line("                        </h:dataTable>");

line("                        <ui:include src=\"/resources/scaffold/paginator.xhtml\">");
line("                                <ui:param name=\"paginatorBean\" value='#{"+Utils._1raMin(entity.getName())+"Bean}'/>");
line("                        </ui:include>");

line("                </h:form>\n");
line("        </ui:define>\n");
line("</ui:composition>");

    } // Constructor

} // END : CLASS