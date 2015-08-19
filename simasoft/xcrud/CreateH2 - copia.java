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

public CreateH2(Entidad entity) throws IOException {

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
line("        xmlns:c=\"http://java.sun.com/jsp/jstl/core\"");
line("        xmlns:forgeview=\"http://jboss.org/forge/view\"");
line("        template=\"/resources/scaffold/pageTemplate.xhtml\">\n");

line("        <f:metadata>");
line("                <f:viewParam name=\"id\" value='#{"+Utils._1raMin(entity.getName())+"Bean.id}'/>");
line("                <f:event type=\"preRenderView\" listener='#{"+Utils._1raMin(entity.getName())+"Bean.retrieve}'/>");
line("        </f:metadata>\n");

line("        <ui:param name=\"pageTitle\" value=\"Create "+entity.getName()+"\"/>\n");

line("        <ui:define name=\"header\">");
line("               "+entity.getName());
line("        </ui:define>\n");

line("        <ui:define name=\"subheader\">");
line("                <c:choose>");
line("                        <c:when test='#{!empty "+Utils._1raMin(entity.getName())+"Bean.id}'>");
line("                                Edit existing "+entity.getName());
line("                        </c:when>");
line("                        <c:otherwise>");
line("                                Create a new "+entity.getName());
line("                        </c:otherwise>");
line("                </c:choose>");
line("        </ui:define>\n");

line("        <ui:define name=\"footer\"/>\n");

line("    <ui:define name=\"main\">");
line("        <h:form id=\"create\">");
line("            <h:messages globalOnly=\"true\" styleClass=\"error\"/>\n");

line("            <h:panelGrid columnClasses=\"label,component,required\" columns=\"3\">");

          // There are atributo(co.simasoft.utils.Atributos class)
          // types don't supported yet:
          // For example: long, boolean(no present explicitly)
          //              and default.
          //
          // It is not possible to depend of 'x' to put <h:outputText>
          // tag, a boolean flag would be used temporary.
          boolean isFirstTime = true;

          for(int x = 0; x < atributos.size(); x++) {

              Atributos atributo = atributos.get(x);

              if (atributo.getType().equals("String")) {

                  if (isFirstTime) {isFirstTime = false;}
                  else { //if (x != 0) {
line("                <h:outputText/>");
                  }
line("                <h:outputLabel for=\""+Utils._1raMin(entity.getName())+"Bean"+entity.getName()+Utils._1raMay(atributo.getField())+"\" value=\""+Utils._1raMay(atributo.getField())+":\"/>");
line("                <h:panelGroup>");
line("                    <h:inputText id=\""+Utils._1raMin(entity.getName())+"Bean"+entity.getName()+Utils._1raMay(atributo.getField())+"\" value=\"#{"+Utils._1raMin(entity.getName())+"Bean."+Utils._1raMin(entity.getName())+"."+Utils._1raMin(atributo.getField())+"}\"/>");
line("                    <h:message for=\"movimientosBeanMovimientosValor\" styleClass=\"error\"/>");
line("                </h:panelGroup>");
                  continue;
              }

              if (atributo.getType().equals("Date")) {

                  if (isFirstTime) {isFirstTime = false;}                   
                  else { //if (x != 0) {
line("                <h:outputText/>");
                  }
line("                <h:outputLabel for=\""+Utils._1raMin(entity.getName())+"Bean"+entity.getName()+Utils._1raMay(atributo.getField())+"\" value=\""+Utils._1raMay(atributo.getField())+":\"/>");
line("                <h:panelGroup>");
line("                    <h:inputText id=\""+Utils._1raMin(entity.getName())+"Bean"+entity.getName()+Utils._1raMay(atributo.getField())+"\" value=\"#{"+Utils._1raMin(entity.getName())+"Bean."+Utils._1raMin(entity.getName())+"."+Utils._1raMin(atributo.getField())+"}\">");
line("                        <f:convertDateTime/>");
line("                    </h:inputText>");
line("                    <h:message for=\""+Utils._1raMin(entity.getName())+"Bean"+entity.getName()+Utils._1raMay(atributo.getField())+"\" styleClass=\"error\"/>");
line("                </h:panelGroup>");
                  continue;
              }

              if (atributo.getType().equals("float")) {

                  if (isFirstTime) {isFirstTime = false;}                   
                  else { //if (x != 0) {
line("                <h:outputText/>");
                  }
line("                <h:outputLabel for=\""+Utils._1raMin(entity.getName())+"Bean"+entity.getName()+Utils._1raMay(atributo.getField())+"\" value=\""+Utils._1raMay(atributo.getField())+":\"/>");
line("                <h:panelGroup>");
line("                    <h:inputText id=\""+Utils._1raMin(entity.getName())+"Bean"+entity.getName()+Utils._1raMay(atributo.getField())+"\" value=\"#{"+Utils._1raMin(entity.getName())+"Bean."+Utils._1raMin(entity.getName())+"."+Utils._1raMin(atributo.getField())+"}\"/>");
line("                    <h:message for=\"movimientosBeanMovimientosValor\" styleClass=\"error\"/>");
line("                </h:panelGroup>\n");
                  continue;
              }

              if (atributo.getType().equals("boolean")) {

                  if (isFirstTime) {isFirstTime = false;}                   
                  else { //if (x != 0) {
line("                <h:outputText/>");
                  }
line("                <h:outputLabel for=\""+Utils._1raMin(entity.getName())+"Bean"+entity.getName()+Utils._1raMay(atributo.getField())+"\" value=\""+Utils._1raMay(atributo.getField())+":\"/>");
line("                <h:panelGroup>");
line("                    <h:selectBooleanCheckbox id=\""+Utils._1raMin(entity.getName())+"Bean"+entity.getName()+Utils._1raMay(atributo.getField())+"\" value=\"#{"+Utils._1raMin(entity.getName())+"Bean."+Utils._1raMin(entity.getName())+"."+Utils._1raMin(atributo.getField())+"}\"/>");
line("                    <h:message for=\"pucsBeanPucsSiRegistra\" styleClass=\"error\"/>");
line("                </h:panelGroup>");
                  continue;
              }

          } // end : FOR : atributos


          for(int x = 0; x < relations.size(); x++) {

              Relation relation = relations.get(x);

              if (relation.getCardinality().equals("*..1")) {

                  if (relation.getFrom().equals(relation.getTo())) {  // Relación Unitaria

line("                <h:outputText/>");
line("                <h:outputLabel for=\""+Utils._1raMin(relation.getTo())+"Bean"+relation.getTo()+"ObjPadre\" value=\"Obj Padre:\"/>");
line("                <h:panelGroup>");
line("                    <h:selectOneMenu converter=\"#{"+relation.getTo()+"Bean.converter}\" id=\""+Utils._1raMin(relation.getTo())+"Bean"+relation.getTo()+"ObjPadre\" value=\"#{"+Utils._1raMin(relation.getTo())+"Bean.pucs.objPadre}\">");
line("                        <f:selectItem/>");
line("                        <f:selectItems itemLabel=\"#{forgeview:display(_item)}\" itemValue=\"#{_item}\" value=\"#{"+Utils._1raMin(relation.getTo())+"Bean.all}\" var=\"_item\"/>");
line("                    </h:selectOneMenu>");
line("                    <h:message for=\""+Utils._1raMin(relation.getTo())+"Bean"+relation.getTo()+"ObjPadre\" styleClass=\"error\"/>");
line("                </h:panelGroup>");

                      if (x == (relations.size() - 1)) {
line("                <h:outputText/>");
                      }

                  }
                  else {
line("                <h:outputText/>");
line("                <h:outputLabel for=\""+Utils._1raMin(entity.getName())+"Bean"+entity.getName()+relation.getTo()+"\" value=\""+Utils._1raMay(relation.getTo())+":\"/>");
line("                <h:panelGroup>");
line("                    <h:selectOneMenu converter=\"#{"+Utils._1raMin(relation.getTo())+"Bean.converter}\" id=\""+Utils._1raMin(entity.getName())+"Bean"+entity.getName()+relation.getTo()+"\" value=\"#{"+Utils._1raMin(entity.getName())+"Bean."+Utils._1raMin(entity.getName())+"."+Utils._1raMin(relation.getTo())+"}\">");
line("                        <f:selectItem/>");
line("                        <f:selectItems itemLabel=\"#{forgeview:display(_item)}\" itemValue=\"#{_item}\" value=\"#{"+Utils._1raMin(relation.getTo())+"Bean.all}\" var=\"_item\"/>");
line("                    </h:selectOneMenu>");
line("                    <h:message for=\""+Utils._1raMin(entity.getName())+"Bean"+entity.getName()+relation.getTo()+"\" styleClass=\"error\"/>");
line("                </h:panelGroup>");

                      if(x == (relations.size() - 1)) {
line("                <h:outputText/>");
                      }

                  } // if

              } // if *..1

          } // end : FOR : relations
line("            </h:panelGrid>\n");

line("            <div class=\"buttons\">");
line("                <h:commandLink value=\"Save\" action='#{"+Utils._1raMin(entity.getName())+"Bean.update}' styleClass=\"btn btn-primary\"/>");
line("                <c:choose>");
line("                    <c:when test='#{!empty "+Utils._1raMin(entity.getName())+"Bean.id}'>");
line("                        <h:link value=\"Cancel\" outcome=\"view\" styleClass=\"btn btn-primary\">");
line("                            <f:param name=\"id\" value='#{"+Utils._1raMin(entity.getName())+"Bean.id}'/>");
line("                        </h:link>");
line("                        <h:commandLink value=\"Delete\" action='#{"+Utils._1raMin(entity.getName())+"Bean.delete}' styleClass=\"btn btn-primary\"/>");
line("                    </c:when>");
line("                    <c:otherwise>");
line("                        <h:link value=\"Cancel\" outcome=\"search\" styleClass=\"btn btn-primary\"/>");
line("                    </c:otherwise>");
line("                </c:choose>");
line("            </div>");

line("        </h:form>");
line("  </ui:define>\n");

line("</ui:composition>");

    } // Constructor

} // END : CLASS