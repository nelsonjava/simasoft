package co.simasoft.generator.war.mongo;

import co.simasoft.utils.*;

public class MongoHome extends FileTxt {

  public MongoHome(String artifactId,String groupId) {

line("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");

line("<ui:composition xmlns=\"http://www.w3.org/1999/xhtml\"");
line("    xmlns:ui=\"http://java.sun.com/jsf/facelets\"");
line("    xmlns:f=\"http://java.sun.com/jsf/core\"");
line("    xmlns:h=\"http://java.sun.com/jsf/html\"");
line("    template=\"/resources/templates/default.xhtml\">\n");

line("    <ui:define name=\"content\">\n");

line("        <h1>>Hello World!</h1>\n");

line("        <div>");
line("            <p>You have successfully deployed a Java EE 6 Enterprise Application.</p>");
line("        </div>\n");

line("        <h:form>");
line("          <h:commandButton value=\"Click Me to Populate!\" action=\"#{setupbean.populateTest()}\" />");
line("        </h:form>\n");

line("    </ui:define>");
line("</ui:composition>");

  } // Generar

} // Fin de clase
