package co.simasoft.generator.war.mongo;

import co.simasoft.utils.*;

public class MongoWarPom extends FileTxt {

  public MongoWarPom(String artifactId,String groupId) {

line("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");

line("<project xmlns=\"http://maven.apache.org/POM/4.0.0\"");
line("         xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");
line("         xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0");
line("         http://maven.apache.org/maven-v4_0_0.xsd\">\n");

line("  <!-- http://sinjava.blogspot.com/2012/10/hola-mundo-jsf.html -->");
line("  <!-- mvn clean package wildfly:deploy -->");
line("  <!-- http://localhost:8080 -->");
line("  <!-- http://localhost:8080/"+artifactId+" -->\n");


line("  <modelVersion>4.0.0</modelVersion>\n");

line("  <groupId>"+groupId+"</groupId>");
line("  <artifactId>"+artifactId+"</artifactId>");
line("  <version>1.0.0-SNAPSHOT</version>");
line("  <packaging>war</packaging>\n");

line("  <repositories>");
line("    <repository>");
line("      <id>JBOSS_NEXUS</id>");
line("      <url>http://repository.jboss.org/nexus/content/groups/public</url>");
line("    </repository>");
line("  </repositories>\n");

line("    <properties>");
line("      <!-- Explicitly declaring the source encoding eliminates the following message: -->");
line("      <!-- [WARNING] Using platform encoding (UTF-8 actually) to copy filtered");
line("           resources, i.e. build is platform dependent! -->");
line("      <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>");
line("    </properties>\n");

line("  <dependencyManagement>");
line("    <dependencies>");

line("      <dependency>");
line("        <groupId>org.jboss.spec</groupId>");
line("        <artifactId>jboss-javaee-7.0</artifactId>");
line("        <version>1.0.0.Final</version>");
line("        <type>pom</type>");
line("        <scope>import</scope>");
line("      </dependency>");

line("      <dependency>");
line("        <groupId>org.wildfly.bom</groupId>");
line("        <artifactId>jboss-javaee-7.0-with-hibernate</artifactId>");
line("        <version>8.2.1.Final</version>");
line("        <type>pom</type>");
line("         <scope>import</scope>");
line("      </dependency>");

line("      <dependency>");
line("        <groupId>org.hibernate.ogm</groupId>");
line("        <artifactId>hibernate-ogm-bom</artifactId>");
line("        <type>pom</type>");
line("        <version>4.1.1.Final</version>");
line("        <scope>import</scope>");
line("      </dependency>");

line("    </dependencies>");
line("  </dependencyManagement>");

line("  <dependencies>");

line("    <!-- Use this for MongoDB -->");
line("    <dependency>");
line("      <groupId>org.hibernate.ogm</groupId>");
line("      <artifactId>hibernate-ogm-mongodb</artifactId>");
line("    </dependency>");

line("    <dependency>");
line("      <groupId>org.hibernate</groupId>");
line("      <artifactId>hibernate-core</artifactId>");
line("      <version>4.3.8.Final</version>");
line("    </dependency>");

line("    <!-- Hibernate Search -->");
line("    <dependency>");
line("      <groupId>org.hibernate</groupId>");
line("      <artifactId>hibernate-search-orm</artifactId>");
line("    </dependency>");

line("    <dependency>");
line("      <groupId>org.hibernate</groupId>");
line("      <artifactId>hibernate-search</artifactId>");
line("      <version>5.0.1.Final</version>");
line("    </dependency>");

line("    <!-- JSR-303 (Bean Validation) Implementation -->");
line("    <!-- Provides portable constraints such as @Email -->");
line("    <!-- Hibernate Validator is shipped in JBoss WildFly -->");
line("    <dependency>");
line("      <groupId>org.hibernate</groupId>");
line("      <artifactId>hibernate-validator</artifactId>");
line("      <scope>provided</scope>");
line("      <exclusions>");
line("        <exclusion>");
line("          <groupId>org.slf4j</groupId>");
line("          <artifactId>slf4j-api</artifactId>");
line("        </exclusion>");
line("      </exclusions>");
line("    </dependency>");

line("    <dependency>");
line("      <groupId>org.jboss.jbossts</groupId>");
line("       <artifactId>jbossjta</artifactId>");
line("    </dependency>");

line("    <!-- Import the CDI API, we use provided scope as the API is included in JBoss WildFly -->");
line("    <dependency>");
line("      <groupId>javax.enterprise</groupId>");
line("      <artifactId>cdi-api</artifactId>");
line("      <scope>provided</scope>");
line("    </dependency>");

line("    <!-- Import the Common Annotations API (JSR-250), we use provided scope");
line("         as the API is included in JBoss WildFly -->");
line("    <dependency>");
line("      <groupId>org.jboss.spec.javax.annotation</groupId>");
line("      <artifactId>jboss-annotations-api_1.2_spec</artifactId>");
line("      <scope>provided</scope>");
line("    </dependency>");

line("    <dependency>");
line("      <groupId>org.jboss.spec.javax.faces</groupId>");
line("      <artifactId>jboss-jsf-api_2.2_spec</artifactId>");
line("      <scope>provided</scope>");
line("    </dependency>");

line("    <dependency>");
line("      <groupId>org.jboss.spec</groupId>");
line("      <artifactId>jboss-javaee-all-7.0</artifactId>");
line("      <version>1.0.2.Final</version>");
line("    </dependency>");

line("  </dependencies>");

line("  <build>");
line("    <finalName>${project.artifactId}</finalName>");
line("    <plugins>\n");

line("      <plugin>");
line("        <artifactId>maven-war-plugin</artifactId>");
line("        <version>2.1.1</version>");
line("        <configuration>");
line("          <!-- Java EE 7 doesn't require web.xml, Maven needs to catch up! -->");
line("          <failOnMissingWebXml>false</failOnMissingWebXml>");
line("        </configuration>");
line("      </plugin>\n");

line("      <!-- WildFly plugin to deploy war -->");
line("      <plugin>");
line("        <groupId>org.wildfly.plugins</groupId>");
line("        <artifactId>wildfly-maven-plugin</artifactId>");
line("        <version>1.0.2.Final</version>");
line("      </plugin>\n");

line("      <!-- Compiler plugin enforces Java 1.7 compatibility and activates annotation processors -->");
line("      <!-- mvn archetype:generate > a.txt -->");
line("      <plugin>");
line("        <artifactId>maven-compiler-plugin</artifactId>");
line("        <version>3.1</version>");
line("        <configuration>");
line("          <source>1.7</source>");
line("          <target>1.7</target>");
line("          <encoding>UTF-8</encoding>");
line("        </configuration>");
line("      </plugin>\n");

line("    </plugins>");
line("  </build>");
line("</project>");

  } // Generar

} // Fin de clase
