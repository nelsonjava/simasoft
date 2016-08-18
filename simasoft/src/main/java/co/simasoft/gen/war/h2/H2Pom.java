package co.simasoft.gen.war.h2;

import co.simasoft.utils.*;

public class H2Pom extends FileTxt {

  public H2Pom(String artifactId,String groupId) {

line("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");

line("<project xmlns=\"http://maven.apache.org/POM/4.0.0\"");
line("         xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");
line("         xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0");
line("         http://maven.apache.org/maven-v4_0_0.xsd\">\n");

line("  <!-- http://www.csvjson.com/csv2json  -->");
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

line("      <dependency>");
line("        <groupId>org.wildfly.bom</groupId>");
line("        <artifactId>jboss-javaee-7.0-with-hibernate</artifactId>");
line("        <version>8.2.1.Final</version>");
line("        <type>pom</type>");
line("        <scope>import</scope>");
line("      </dependency>\n");

line("      <dependency>");
line("        <groupId>org.hibernate.ogm</groupId>");
line("        <artifactId>hibernate-ogm-bom</artifactId>");
line("        <version>4.1.1.Final</version>");
line("        <type>pom</type>");
line("        <scope>import</scope>");
line("      </dependency>\n");

line("      <dependency>");
line("        <groupId>org.picketlink</groupId>");
line("        <artifactId>picketlink-javaee-6.0</artifactId>");
line("        <version>2.7.0-SNAPSHOT</version>");
line("        <type>pom</type>");
line("        <scope>import</scope>");
line("      </dependency>\n");

line("      <dependency>");
line("        <groupId>org.jboss.spec</groupId>");
line("        <artifactId>jboss-javaee-6.0</artifactId>");
line("        <version>3.0.2.Final</version>");
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

line("    <dependency>");
line("      <groupId>org.keycloak</groupId>");
line("      <artifactId>keycloak-core</artifactId>");
line("      <version>1.5.0.Final</version>");
line("    </dependency>\n");

line("    <dependency>");
line("      <groupId>org.keycloak</groupId>");
line("      <artifactId>keycloak-adapter-core</artifactId>");
line("      <version>1.5.0.Final</version>");
line("    </dependency>\n");

line("    <dependency>");
line("      <groupId>org.primefaces</groupId>");
line("      <artifactId>primefaces</artifactId>");
line("      <version>5.1</version>");
line("      <scope>import</scope>");
line("    </dependency>\n");

line("    <dependency>");
line("      <groupId>org.hibernate.ogm</groupId>");
line("      <artifactId>hibernate-ogm-mongodb</artifactId>");
line("    </dependency>\n");

line("    <dependency>");
line("      <groupId>org.hibernate</groupId>");
line("      <artifactId>hibernate-core</artifactId>");
line("      <version>4.3.8.Final</version>");
line("    </dependency>\n");

line("    <dependency>");
line("      <groupId>org.hibernate</groupId>");
line("      <artifactId>hibernate-search-orm</artifactId>");
line("    </dependency>\n");

line("    <dependency>");
line("      <groupId>org.hibernate</groupId>");
line("      <artifactId>hibernate-search</artifactId>");
line("      <version>5.0.1.Final</version>");
line("    </dependency>\n");

line("    <dependency>");
line("      <groupId>org.hibernate</groupId>");
line("      <artifactId>hibernate-validator</artifactId>");
line("      <scope>provided</scope>");
line("      <exclusions>");
line("        <exclusion>");
line("          <artifactId>slf4j-api</artifactId>");
line("          <groupId>org.slf4j</groupId>");
line("        </exclusion>");
line("      </exclusions>");
line("    </dependency>\n");

line("    <dependency>");
line("      <groupId>org.picketlink</groupId>");
line("      <artifactId>picketlink</artifactId>");
line("      <scope>compile</scope>");
line("    </dependency>\n");

line("    <dependency>");
line("      <groupId>com.h2database</groupId>");
line("      <artifactId>h2</artifactId>");
line("      <version>1.3.161</version>");
line("    </dependency>\n");

line("    <dependency>");
line("      <groupId>org.jboss.jbossts</groupId>");
line("      <artifactId>jbossjta</artifactId>");
line("    </dependency>\n");


line("    <dependency>");
line("      <groupId>javax.enterprise</groupId>");
line("      <artifactId>cdi-api</artifactId>");
line("      <scope>provided</scope>");
line("    </dependency>\n");

line("    <dependency>");
line("      <groupId>org.jboss.spec.javax.annotation</groupId>");
line("      <artifactId>jboss-annotations-api_1.2_spec</artifactId>");
line("      <scope>provided</scope>");
line("    </dependency>\n");

line("    <dependency>");
line("      <groupId>org.jboss.spec.javax.faces</groupId>");
line("      <artifactId>jboss-jsf-api_2.2_spec</artifactId>");
line("      <scope>provided</scope>");
line("    </dependency>\n");

line("    <dependency>");
line("      <groupId>org.jboss.spec</groupId>");
line("      <artifactId>jboss-javaee-all-7.0</artifactId>");
line("      <version>1.0.2.Final</version>");
line("    </dependency>\n");

line("    <dependency>");
line("      <groupId>org.jboss.spec.javax.interceptor</groupId>");
line("      <artifactId>jboss-interceptors-api_1.1_spec</artifactId>");
line("      <scope>provided</scope>");
line("    </dependency>\n");

line("    <dependency>");
line("      <groupId>org.jboss.spec.javax.ejb</groupId>");
line("      <artifactId>jboss-ejb-api_3.1_spec</artifactId>");
line("      <scope>provided</scope>");
line("    </dependency>\n");

line("    <dependency>");
line("      <groupId>org.jboss.spec.javax.servlet</groupId>");
line("      <artifactId>jboss-servlet-api_3.0_spec</artifactId>");
line("      <scope>provided</scope>");
line("    </dependency>\n");

line("    <dependency>");
line("      <groupId>org.jboss.spec.javax.faces</groupId>");
line("      <artifactId>jboss-jsf-api_2.1_spec</artifactId>");
line("      <scope>provided</scope>");
line("    </dependency>\n");

line("  </dependencies>\n");

line("  <repositories>");
line("    <repository>");
line("      <id>JBOSS_NEXUS</id>");
line("      <url>http://repository.jboss.org/nexus/content/groups/public</url>");
line("    </repository>");
line("  </repositories>\n");

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

line("      <plugin>");
line("        <artifactId>maven-compiler-plugin</artifactId>");
line("        <version>3.1</version>");
line("        <configuration>");
line("          <source>1.7</source>");
line("          <target>1.7</target>");
line("          <encoding>UTF-8</encoding>");
line("        </configuration>");
line("      </plugin>\n");

line("    </plugins>\n");

line("  </build>");
line("</project>");

  } // Generar

} // Fin de clase
