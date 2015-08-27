package co.simasoft.gen.war.h2;

import java.io.*;
import java.util.*;

import co.simasoft.utils.*;
import co.simasoft.gen.jpa.*;

public class H2Persistence extends FileTxt {

  public H2Persistence(String artifactId,Set<Entidad> entities) {

line("<persistence xmlns=\"http://java.sun.com/xml/ns/persistence\"");
line("             xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");
line("             xsi:schemaLocation=\"http://java.sun.com/xml/ns/persistence");
line("             http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd\"");
line("             version=\"2.0\">\n");

line("  <!-- Use this for H2 -->");
line("  <persistence-unit name=\""+artifactId+"PU-JTA"+"\" transaction-type=\"JTA\">\n");

line("    <provider>org.hibernate.ejb.HibernatePersistence</provider>\n");

         for(Entidad entidad : entities) {
line("    <class>"+entidad.getGroupId()+"."+entidad.getName()+"</class>");
         } // for package.getEntities()

line("");

line("    <exclude-unlisted-classes>true</exclude-unlisted-classes>");
line("    <jta-data-source>java:jboss/datasources/"+artifactId+"DS</jta-data-source>");
line("    <properties>");
line("      <!-- <property name=\"javax.persistence.jdbc.url\"      value=\"jdbc:h2:/db/"+artifactId+"/data\"/>  -->");
line("      <!-- <property name=\"javax.persistence.jdbc.user\"     value=\"sa\"/>  -->");
line("      <!-- <property name=\"javax.persistence.jdbc.password\" value=\"\"/>  -->");
line("      <property name=\"hibernate.connection.driver_class\"    value=\"org.h2.Driver\"/>");
line("      <property name=\"hibernate.dialect\"                    value=\"org.hibernate.dialect.H2Dialect\"/>");
line("      <property name=\"hibernate.hbm2ddl.auto\"               value=\"update\" />");
line("      <property name=\"hibernate.show_sql\"                   value=\"true\" />");
line("      <property name=\"hibernate.format_sql\"                 value=\"true\"/>");
line("    </properties>");

line("  </persistence-unit>\n");


line("</persistence>");

    } // Generar

} // Fin de clase