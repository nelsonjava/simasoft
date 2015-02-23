package co.simasoft.generator.war.mongo;

import co.simasoft.utils.*;

public class WarMongoPersistence extends FileTxt {

  public WarMongoPersistence(String artifactId,String groupId) {

line("<persistence xmlns=\"http://java.sun.com/xml/ns/persistence\"");
line("             xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");
line("             xsi:schemaLocation=\"http://java.sun.com/xml/ns/persistence");
line("             http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd\"");
line("             version=\"2.0\">\n");

line("  <!-- Use this for MongoDB -->");
line("  <persistence-unit name=\""+artifactId+"PU-JTA"+"\" transaction-type=\"JTA\">\n");

line("    <provider>org.hibernate.ogm.jpa.HibernateOgmPersistence</provider>\n");

line("    <class>"+groupId+".models.Person"+"</class>\n");

line("     <properties>");
line("       <property name=\"hibernate.ogm.datastore.provider\"        value=\"mongodb\" />");
line("       <property name=\"hibernate.ogm.datastore.database\"        value=\""+artifactId+"\" />");
line("       <property name=\"hibernate.ogm.datastore.create_database\" value=\"true\" />");
line("     </properties>\n");

line("  </persistence-unit>\n");

line("</persistence>");

    } // Generar

} // Fin de clase
