package co.simasoft.gen.war.h2;

import co.simasoft.utils.*;

public class H2Beans extends FileTxt {

  public H2Beans(String artifactId,String groupId) {
    
line("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");

line("<!-- Marker file indicating CDI should be enabled -->");
line("<beans xmlns=\"http://xmlns.jcp.org/xml/ns/javaee\"");
line("       xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");
line("       xsi:schemaLocation=\"http://xmlns.jcp.org/xml/ns/javaee");
line("                            http://xmlns.jcp.org/xml/ns/javaee/beans_1_1.xsd\">");
line("</beans>");

  } // Constructor

} // Fin de clase
