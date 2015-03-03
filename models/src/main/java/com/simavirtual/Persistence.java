package com.simavirtual;

import java.io.*;
import java.util.*;

import co.simasoft.utils.*;
import co.simasoft.gen.jpa.*;

public class Persistence extends FileTxt {

  public Persistence(String artifactId,String groupId,ArrayList<Entidad> entidades) {

line("<persistence xmlns=\"http://java.sun.com/xml/ns/persistence\"");
line("             xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");
line("             xsi:schemaLocation=\"http://java.sun.com/xml/ns/persistence");
line("             http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd\"");
line("             version=\"2.0\">\n");

line("  <!-- Use this for App Standalone H2 -->");
line("  <persistence-unit name=\""+artifactId+"PU"+"\" transaction-type=\"RESOURCE_LOCAL\">\n");

line("    <provider>org.hibernate.ejb.HibernatePersistence</provider>\n");

        for(Entidad entidad : entidades) {
line("    <class>"+groupId+".models."+entidad.getName()+"</class>");
        }

line("");

line("    <properties>");
line("      <property name=\"javax.persistence.jdbc.driver\"   value=\"org.hsqldb.jdbcDriver\"/>");
line("      <property name=\"javax.persistence.jdbc.url\"      value=\"jdbc:hsqldb:mem:standalone\"/>");
line("      <property name=\"javax.persistence.jdbc.user\"     value=\"sa\"/>");
line("      <property name=\"javax.persistence.jdbc.password\" value=\"\"/>");
line("      <property name=\"hibernate.dialect\"               value=\"org.hibernate.dialect.HSQLDialect\"/>");
line("      <property name=\"hibernate.hbm2ddl.auto\"          value=\"create\"/>");
line("      <property name=\"hibernate.hbm2ddl.import_files\"  value=\"sql/import.sql\"/>");
line("      <property name=\"hibernate.show_sql\"              value=\"true\"/>");
line("      <property name=\"hibernate.format_sql\"            value=\"false\"/>");
line("    </properties>\n");

line("  </persistence-unit>\n");

//-------------------------------------------------//

line("  <!-- Use this for MongoDB -->");
line("  <persistence-unit name=\""+artifactId+"PU-JTA"+"\" transaction-type=\"JTA\">\n");

line("    <provider>org.hibernate.ogm.jpa.HibernateOgmPersistence</provider>\n");

        for(Entidad entidad : entidades) {
line("    <class>"+groupId+".models."+entidad.getName()+"</class>");
        }

line("");

line("    <properties>");
line("      <property name=\"hibernate.ogm.datastore.provider\"        value=\"mongodb\" />");
line("      <property name=\"hibernate.ogm.datastore.database\"        value=\""+artifactId+"\" />");
line("      <property name=\"hibernate.ogm.datastore.create_database\" value=\"true\" />");
line("    </properties>\n");

line("  </persistence-unit>\n");

//-------------------------------------------------//

line("  <!-- Use this for H2 -->");
line("  <persistence-unit name=\""+artifactId+"PU-JTA"+"\" transaction-type=\"JTA\">\n");

line("    <provider>org.hibernate.ejb.HibernatePersistence</provider>\n");

        for(Entidad entidad : entidades) {
line("    <class>"+groupId+".models."+entidad.getName()+"</class>");
        }

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