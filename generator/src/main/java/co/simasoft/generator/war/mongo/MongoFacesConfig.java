package co.simasoft.generator.war.mongo;

import co.simasoft.utils.*;

public class MongoFacesConfig extends FileTxt {

  public MongoFacesConfig(String artifactId,String groupId) {

line("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");

line("<!-- Marker file indicating JSF 2.2 should be enabled in the application -->");
line("<faces-config version=\"2.2\"");
line("              xmlns=\"http://xmlns.jcp.org/xml/ns/javaee\"");
line("              xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");
line("              xsi:schemaLocation=\"http://xmlns.jcp.org/xml/ns/javaee");
line("                                  http://xmlns.jcp.org/xml/ns/javaee/web-facesconfig_2_2.xsd\">");
line("</faces-config>");

  } // Constructor

} // Fin de clase
