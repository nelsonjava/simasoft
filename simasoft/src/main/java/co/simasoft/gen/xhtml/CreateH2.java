package co.simasoft.gen.xhtml;

import co.simasoft.utils.*;

import java.io.*;
import java.lang.*;
import java.util.*;

import java.util.HashSet;
import java.util.Set;

/****************************************************************************************************************
* CLASE : CreateH2                                                                                              *
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

public class CreateH2 extends FileTxt {

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

public CreateH2(String artifactId,String groupId,Entidad entity,ArrayList<String> imports) throws IOException {

//>>INICIALIZACION DE ATRIBUTOS
      this.entity = entity;
      this.atributos = entity.getAtributos();
      this.relations = entity.getRelations();
//>>FIN INICIALIZACION DE ATRIBUTOS

line("<?xml version='1.0' encoding='UTF-8' ?>\n");

line("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");

line("<ui:composition xmlns=\"http://www.w3.org/1999/xhtml\"");
line("                xmlns:h=\"http://java.sun.com/jsf/html\"");
line("                xmlns:f=\"http://java.sun.com/jsf/core\"");
line("                xmlns:ui=\"http://java.sun.com/jsf/facelets\"");
line("                xmlns:c=\"http://java.sun.com/jsp/jstl/core\"");
line("                xmlns:forgeview=\"http://jboss.org/forge/view\"");
line("                template=\"/resources/scaffold/pageTemplate.xhtml\">\n");

line("  <f:metadata>");
line("    <f:viewParam name=\"id\" value='#{"+Utils._1raMin(entity.getName())+"Bean.id}'/>");
line("    <f:event type=\"preRenderView\" listener='#{"+Utils._1raMin(entity.getName())+"Bean.retrieve}'/>");
line("  </f:metadata>\n");

line("  <ui:param name=\"pageTitle\" value=\"Create "+entity.getName()+"\"/>\n");

line("  <ui:define name=\"header\">");
line("    "+entity.getName());
line("  </ui:define>\n");

line("  <ui:define name=\"subheader\">");
line("    <c:choose>");
line("      <c:when test='#{!empty "+Utils._1raMin(entity.getName())+"Bean.id}'>");
line("        Edit existing "+entity.getName());
line("      </c:when>");
line("      <c:otherwise>");
line("        Create a new "+entity.getName());
line("      </c:otherwise>");
line("    </c:choose>");
line("  </ui:define>\n");

line("  <ui:define name=\"footer\"/>\n");

line("  <ui:define name=\"main\">");

line("    <h:form id=\"create\">");

line("       <h:messages globalOnly=\"true\" styleClass=\"error\"/>");

line("       <h:panelGrid columnClasses=\"label,component,required\" columns=\"3\">");

          for(Atributos atributo : atributos) {
            
line(atributo.getField()+":"+atributo.getType());            

             if (atributo.getType().equals("String")) {


             }

          } // for atributos


line("       </h:panelGrid>");

line("       <div class=\"buttons\">");
line("         <h:commandLink value=\"Save\" action='#{"+Utils._1raMin(entity.getName())+"Bean.update}' styleClass=\"btn btn-primary\"/>");
line("         <c:choose>");
line("           <c:when test='#{!empty "+Utils._1raMin(entity.getName())+"Bean.id}'>");
line("              <h:link value=\"Cancel\" outcome=\"view\" styleClass=\"btn btn-primary\">");
line("                <f:param name=\"id\" value='#{"+Utils._1raMin(entity.getName())+"Bean.id}'/>");
line("              </h:link>");
line("              <h:commandLink value=\"Delete\" action='#{"+Utils._1raMin(entity.getName())+"Bean.delete}' styleClass=\"btn btn-primary\"/>");
line("           </c:when>");
line("           <c:otherwise>");
line("             <h:link value=\"Cancel\" outcome=\"search\" styleClass=\"btn btn-primary\"/>");
line("           </c:otherwise>");
line("         </c:choose>");
line("       </div>");

line("    </h:form>");


line("  </ui:define>\n");

line("</ui:composition>\n");


  } // Constructor

} // class


