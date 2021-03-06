package co.simasoft.gen.war.h2;

import co.simasoft.utils.*;

public class H2Web extends FileTxt {

  public H2Web(String artifactId) {

line("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");

line("<web-app xmlns=\"http://java.sun.com/xml/ns/javaee\"");
line("         xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" version=\"3.0\"");
line("         xsi:schemaLocation=\"http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd\">\n");

line("  <display-name>"+artifactId+"</display-name>\n");

line("  <session-config>");
line("    <session-timeout>30</session-timeout>");
line("  </session-config>\n");

line("  <mime-mapping>\n");

line("  <extension>ico</extension>");
line("    <mime-type>image/x-icon</mime-type>");
line("  </mime-mapping>\n");

line("  <context-param>");
line("    <param-name>javax.faces.DATETIMECONVERTER_DEFAULT_TIMEZONE_IS_SYSTEM_TIMEZONE</param-name>");
line("    <param-value>true</param-value>");
line("  </context-param>\n");

line("  <error-page>");
line("    <error-code>404</error-code>");
line("    <location>/faces/error.xhtml</location>");
line("  </error-page>\n");

line("  <error-page>");
line("    <error-code>500</error-code>");
line("    <location>/faces/error.xhtml</location>");
line("  </error-page>\n");

line("</web-app>");

  } // Constructor

} // Fin de clase
