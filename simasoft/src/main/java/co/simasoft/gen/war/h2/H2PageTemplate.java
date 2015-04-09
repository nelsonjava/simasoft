package co.simasoft.gen.war.h2;

import java.io.*;
import java.util.*;

import co.simasoft.utils.*;
import co.simasoft.gen.jpa.*;

public class H2PageTemplate extends FileTxt {

  public H2PageTemplate(String artifactId,String groupId,ArrayList<Entidad> entidades) {

line("<!DOCTYPE html>\n");

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
line("          "+artifactId);
line("          <h:outputText value=\", #{request.userPrincipal.name}\" rendered=\"#{request.userPrincipal !=null} \"/>");
line("        </h:link>");
line("        <div class=\"nav-collapse collapse\">");
line("          <ul class=\"nav\">");
line("            <li><a href=\"/"+artifactId+"/home.jsf\">Home</a></li>");
line("            <li><a href=\"/"+artifactId+"/admin/index.jsf\">Admin</a></li>");
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
        for(Entidad entidad : entidades) {
line("        <li><h:link outcome=\"/admin/"+Utils._1raMin(entidad.getName())+"/search\" value=\""+entidad.getName()+"\"/></li>");
        }
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


    } // Generar

} // Fin de clase