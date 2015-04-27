package co.simasoft.gen.war.h2;

import java.io.*;
import java.util.*;

import co.simasoft.utils.*;
import co.simasoft.gen.jpa.*;

public class H2Datasource extends FileTxt {

  public H2Datasource(String artifactId) {

line("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");

line("<datasources xmlns=\"http://www.jboss.org/ironjacamar/schema\"");
line("             xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");
line("             xsi:schemaLocation=\"http://www.jboss.org/ironjacamar/schema");
line("             http://docs.jboss.org/ironjacamar/schema/datasources_1_0.xsd\">\n");

line("   <datasource jndi-name=\"java:jboss/datasources/"+artifactId+"DS\"");
line("               pool-name=\""+artifactId+"\"");
line("               enabled=\"true\"");
line("               use-java-context=\"true\">\n");

line("     <connection-url>jdbc:h2:/db/"+artifactId+"/data</connection-url>");
line("       <driver>h2</driver>");
line("       <security>");
line("         <user-name>sa</user-name>");
line("         <password></password>");
line("       </security>");
line("   </datasource>\n");

line("</datasources>");

    } // Generar

} // Fin de clase