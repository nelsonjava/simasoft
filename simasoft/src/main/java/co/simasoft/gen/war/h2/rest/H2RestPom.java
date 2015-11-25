package co.simasoft.gen.war.h2.rest;

import co.simasoft.utils.*;

public class H2RestPom extends FileTxt {

  public H2RestPom(String artifactId,String groupId) {

line("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");

line("<project xmlns=\"http://maven.apache.org/POM/4.0.0\"");
line("         xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");
line("         xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0");
line("         http://maven.apache.org/maven-v4_0_0.xsd\">\n");

line("  <!-- http://sinjava.blogspot.com/2012/10/hola-mundo-jsf.html -->");
line("  <!-- http://localhost:8080/auth/admin/index.html -->");
line("  <!-- mvn wildfly:undeploy -->");
line("  <!-- mvn clean package wildfly:deploy -->");
line("  <!-- http://localhost:8080 -->");
line("  <!-- http://localhost:8080/"+artifactId+" -->");
line("  <!-- http://localhost:8080/auth/ -->\n");

line("  <modelVersion>4.0.0</modelVersion>\n");

line("  <groupId>"+groupId+"</groupId>");
line("  <artifactId>"+artifactId+"</artifactId>");
line("  <version>1.0.0-SNAPSHOT</version>");
line("  <packaging>war</packaging>\n");

line("  <properties>");
line("    <maven.compiler.source>1.7</maven.compiler.source>");
line("    <maven.compiler.target>1.7</maven.compiler.target>");
line("    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>");
line("  </properties>\n");

line("  <dependencyManagement>");
line("    <dependencies>\n");

line("      <!-- Define the version of JBoss' Java EE 7 APIs we want to import.");
line("           Any dependencies from org.jboss.spec will have their version defined by this");
line("           BOM -->");
line("      <!-- JBoss distributes a complete set of Java EE 7 APIs including");
line("           a Bill of Materials (BOM). A BOM specifies the versions of a \"stack\" (or");
line("           a collection) of artifacts. We use this here so that we always get the correct");
line("           versions of artifacts. Here we use the jboss-javaee-7.0 stack (you can");
line("           read this as the JBoss stack of the Java EE 7 APIs). You can actually");
line("           use this stack with any version of WildFly that implements Java EE 7, not");
line("           just WildFly 8! -->");
line("      <dependency>");
line("        <groupId>org.jboss.spec</groupId>");
line("        <artifactId>jboss-javaee-7.0</artifactId>");
line("        <version>1.0.0.Final</version>");
line("        <type>pom</type>");
line("        <scope>import</scope>");
line("      </dependency>\n");

line("    </dependencies>");
line("  </dependencyManagement>\n");

line("  <dependencies>\n");

line("    <dependency>");
line("      <groupId>co.simasoft</groupId>");
line("      <artifactId>simasoft</artifactId>");
line("      <version>1.0-SNAPSHOT</version>");
line("    </dependency>\n");

/*
line("    <dependency>");
line("      <groupId>org.hibernate.javax.persistence</groupId>");
line("      <artifactId>hibernate-jpa-2.0-api</artifactId>");
line("      <scope>provided</scope>");
line("    </dependency>\n");

line("    <dependency>");
line("      <groupId>org.jboss.spec.javax.servlet</groupId>");
line("      <artifactId>jboss-servlet-api_3.0_spec</artifactId>");
line("      <scope>provided</scope>");
line("    </dependency>\n");

line("    <dependency>");
line("      <groupId>org.jboss.spec.javax.ws.rs</groupId>");
line("      <artifactId>jboss-jaxrs-api_1.1_spec</artifactId>");
line("      <scope>provided</scope>");
line("    </dependency>\n");

line("    <dependency>");
line("      <groupId>org.jboss.spec.javax.ejb</groupId>");
line("      <artifactId>jboss-ejb-api_3.1_spec</artifactId>");
line("      <scope>provided</scope>");
line("    </dependency>\n");
*/

line("    <!-- Full text search engines like Apache Lucene are very powerful technologies to add efficient free text search capabilities to applications.  -->");
line("    <!-- https://docs.jboss.org/hibernate/search/5.5/reference/en-US/pdf/hibernate_search_reference.pdf  -->");
line("    <!-- https://docs.jboss.org/hibernate/search/5.5/api/  -->");
line("    <!-- <version>5.5.1.Final</version> genera error.  -->");
line("    <dependency>");
line("      <groupId>org.hibernate</groupId>");
line("      <artifactId>hibernate-search</artifactId>");
line("      <version>5.0.1.Final</version>");
line("    </dependency>\n");

line("    <!-- https://maven-repository.com/artifact/org.jboss.spec/jboss-javaee-all-7.0 -->");
line("    <dependency>");
line("      <groupId>org.jboss.spec</groupId>");
line("      <artifactId>jboss-javaee-all-7.0</artifactId>");
line("      <version>1.0.3.Final</version>");
line("    </dependency>");

/*
line("    <!-- This package specifies a means for obtaining objects in such a way as to maximize reusability,");
line("         testability and maintainability compared to traditional approaches such as constructors, factories, and service locators (e.g., JNDI).");
line("         This process, known as dependency injection, is beneficial to most nontrivial applications. -->");
line("    <!-- http://docs.oracle.com/javaee/6/api/javax/inject/package-summary.html -->");
line("    <!-- http://docs.oracle.com/javaee/7/api/javax/inject/package-summary.html -->");
line("    <!-- http://atinject.googlecode.com/svn/tags/1/javadoc/javax/inject/package-summary.html -->");
line("    <!-- falta estudiar bien la dependencia -->");
line("    <dependency>");
line("      <groupId>javax.inject</groupId>");
line("      <artifactId>javax.inject</artifactId>");
line("      <version>1</version>");
line("    </dependency>");
*/

line("  </dependencies>\n");

line("  <build>\n");

line("    <finalName>${project.artifactId}</finalName>\n");

line("    <plugins>\n");

line("      <plugin>");
line("        <artifactId>maven-war-plugin</artifactId>");
line("        <version>2.1.1</version>");
line("        <configuration>");
line("          <failOnMissingWebXml>false</failOnMissingWebXml>");
line("        </configuration>");
line("      </plugin>\n");

line("      <plugin>");
line("        <groupId>org.wildfly.plugins</groupId>");
line("        <artifactId>wildfly-maven-plugin</artifactId>");
line("        <version>1.0.2.Final</version>");
line("      </plugin>\n");

line("    </plugins>\n");

line("  </build>");
line("</project>");

  } // Generar

} // Fin de clase
