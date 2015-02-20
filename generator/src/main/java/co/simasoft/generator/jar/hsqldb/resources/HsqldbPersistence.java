package co.simasoft.generator.jar.hsqldb;

import co.simasoft.utils.*;

public class HsqldbPersistence extends FileTxt {

  public HsqldbPersistence(String artifactId,String groupId) {

line("<persistence xmlns=\"http://java.sun.com/xml/ns/persistence\"");
line("             xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");
line("             xsi:schemaLocation=\"http://java.sun.com/xml/ns/persistence");
line("             http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd\"");
line("             version=\"2.0\">\n");

line("  <persistence-unit name=\""+artifactId+"PU"+"\" transaction-type=\"RESOURCE_LOCAL\">\n");

line("    <provider>org.hibernate.ejb.HibernatePersistence</provider>\n");

line("    <class>"+groupId+".models.User"+"</class>\n");

line("     <properties>");
line("       <property name=\"javax.persistence.jdbc.driver\"   value=\"org.hsqldb.jdbcDriver\"/>");
line("       <property name=\"javax.persistence.jdbc.url\"      value=\"jdbc:hsqldb:mem:standalone\"/>");
line("       <property name=\"javax.persistence.jdbc.user\"     value=\"sa\"/>");
line("       <property name=\"javax.persistence.jdbc.password\" value=\"\"/>");
line("       <property name=\"hibernate.dialect\"               value=\"org.hibernate.dialect.HSQLDialect\"/>");
line("       <property name=\"hibernate.hbm2ddl.auto\"          value=\"create\"/>");
line("       <property name=\"hibernate.hbm2ddl.import_files\"  value=\"sql/import.sql\"/>");
line("       <property name=\"hibernate.show_sql\"              value=\"true\"/>");
line("       <property name=\"hibernate.format_sql\"            value=\"false\"/>");
line("     </properties>\n");

line("  </persistence-unit>\n");

line("</persistence>");

    } // Generar

} // Fin de clase
