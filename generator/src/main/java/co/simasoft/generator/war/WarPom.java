package co.simasoft.generator.war;

import co.simasoft.utils.*;

public class WarPom extends FileTxt {

  public WarPom(String artifactId,String groupId) {

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

line("    <dependencyManagement>");
line("      <dependencies>");
line("        <!-- Define the version of JBoss' Java EE 7 APIs we want to import.");
line("             Any dependencies from org.jboss.spec will have their version defined by this");
line("             BOM -->");
line("        <!-- JBoss distributes a complete set of Java EE 7 APIs including");
line("             a Bill of Materials (BOM). A BOM specifies the versions of a \"stack\" (or");
line("             a collection) of artifacts. We use this here so that we always get the correct");
line("             versions of artifacts. Here we use the jboss-javaee-7.0 stack (you can");
line("             read this as the JBoss stack of the Java EE 7 APIs). You can actually");
line("             use this stack with any version of WildFly that implements Java EE 7, not");
line("             just WildFly 8! -->");
line("        <dependency>");
line("          <groupId>org.jboss.spec</groupId>");
line("          <artifactId>jboss-javaee-7.0</artifactId>");
line("          <version>1.0.0.Final</version>");
line("          <type>pom</type>");
line("          <scope>import</scope>");
line("        </dependency>");
line("      </dependencies>");
line("    </dependencyManagement>\n");

line("  <dependencies>\n");

line("    <!-- Import the CDI API, we use provided scope as the API is included in JBoss WildFly -->");
line("    <dependency>");
line("      <groupId>javax.enterprise</groupId>");
line("      <artifactId>cdi-api</artifactId>");
line("      <scope>provided</scope>");
line("    </dependency>\n");

line("    <!-- Import the Common Annotations API (JSR-250), we use provided scope");
line("         as the API is included in JBoss WildFly -->");
line("    <dependency>");
line("      <groupId>org.jboss.spec.javax.annotation</groupId>");
line("      <artifactId>jboss-annotations-api_1.2_spec</artifactId>");
line("      <scope>provided</scope>");
line("    </dependency>\n");

line("    <!-- https://www.jcp.org/en/jsr/detail?id=314 - JSR 314: JavaServer Faces 2.0 -->");
line("    <!-- https://www.jcp.org/en/jsr/detail?id=344 - JSR 344: JavaServerTM Faces 2.2 -->");
line("    <!-- Import the JSF API, we use provided scope as the API is included in JBoss WildFly -->");
line("    <dependency>");
line("      <groupId>org.jboss.spec.javax.faces</groupId>");
line("      <artifactId>jboss-jsf-api_2.2_spec</artifactId>");
line("      <scope>provided</scope>");
line("    </dependency>\n");

line("  </dependencies>\n");

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
line("      </plugin>");

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
