package co.simasoft.gen.xhtml;

import co.simasoft.utils.*;

import java.io.*;
import java.lang.*;
import java.util.*;

import java.util.HashSet;
import java.util.Set;

/****************************************************************************************************************
* CLASE : TemplateCrud                                                                                          *
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

public class TemplateCrud extends FileTxt {

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

public TemplateCrud(String artifactId,String groupId,LinkedHashSet<String> imports) throws IOException {

//>>INICIALIZACION DE ATRIBUTOS
      this.entity = entity;
      this.atributos = entity.getAtributos();
      this.relations = entity.getRelations();
//>>FIN INICIALIZACION DE ATRIBUTOS

line("<!DOCTYPE html>");

line("<html xmlns=\"http://www.w3.org/1999/xhtml\"");
line("      xmlns:h=\"http://java.sun.com/jsf/html\"");
line("      xmlns:ui=\"http://java.sun.com/jsf/facelets\">\n");

line("<h:head>");
line("  <title>#{empty pageTitle ? 'Page Title' : pageTitle}</title>");
line("  <link rel=\"icon\" href='#{resource[\"favicon.ico\"]}' />");
line("  <h:outputStylesheet name=\"bootstrap.css\" />");
line("  <h:outputStylesheet name=\"forge-style.css\" />");
line("</h:head>\n");

line("<h:body>");
line("  <ui:debug rendered=\"#{facesContext.application.projectStage == 'Development'}\" />");
line("  <div class=\"navbar navbar-fixed-top\">");
line("    <div class=\"navbar-inner\">");
line("      <div class=\"container\">");
line("        <h:link id=\"brandLink\" outcome=\"/index.xhtml\" styleClass=\"brand\">");
line("          <h:outputText value=\"Welcome to \" rendered=\" #{request.userPrincipal !=null} \"/>");
line("          Prueba 1");
line("          <h:outputText value=\", #{request.userPrincipal.name}\" rendered=\"#{request.userPrincipal !=null} \"/>");
line("        </h:link>");
line("        <div class=\"nav-collapse collapse\">");
line("          <ul class=\"nav\">");
line("            <li><a href=\"http://forge.jboss.org/docs/important_plugins/ui-scaffolding.html\">How to Customize</a></li>");
line("          </ul>");
line("        </div>");
line("      </div>");
line("    </div>");
line("  </div>\n");

line("  <div class=\"container forgecontainer\">");
line("    <div id=\"navigation\">");
line("      <h:link id=\"homeLink\" outcome=\"/index.xhtml\">");
line("        <img src='#{resource[\"forge-logo.png\"]}' alt=\"Forge... get hammered\" border=\"0\" />");
line("      </h:link>");
line("      <ul>");
line("        <li><h:link outcome=\"/admin/movimientos/search\" value=\"Movimientos\"/></li>");
line("        <li><h:link outcome=\"/admin/pucs/search\" value=\"Pucs\"/></li>");
line("        <li><h:link outcome=\"/admin/saldos/search\" value=\"Saldos\"/></li>");
line("        <li><h:link outcome=\"/admin/terceros/search\" value=\"Terceros\"/></li>");
line("      </ul>");
line("    </div>\n");

line("    <div id=\"content\">");
line("      <h1><ui:insert name=\"header\" /></h1>");
line("      <h2><ui:insert name=\"subheader\" /></h2>");
line("      <ui:insert name=\"main\" />");
line("    </div>");
line("  </div>\n");

line("  <footer>");
line("    <div id=\"footer-wrapper\">");
line("      <p>Powered by <a href=\"http://jboss.org/forge\">Forge</a></p>");
line("    </div>");
line("  </footer>\n");

line("</h:body>");
line("</html>");

  } // Constructor

} // class


