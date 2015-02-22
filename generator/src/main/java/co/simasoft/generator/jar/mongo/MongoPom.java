package co.simasoft.generator.jar.mongo;

import co.simasoft.utils.*;

public class MongoPom extends FileTxt {

  public MongoPom(String artifactId,String groupId) {

line("<project xmlns=\"http://maven.apache.org/POM/4.0.0\"");
line("         xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");
line("         xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd\">\n");

line("  <!-- java -jar target/"+artifactId+"-1.0-SNAPSHOT.jar -->");
line("  <!-- java -jar target/"+artifactId+"-1.0-SNAPSHOT-jar-with-dependencies.jar  -->");
line("  <!-- mvn clean compile assembly:single -->\n");

line("  <!-- 1. Maven add classpath to manifest -->");
line("  <!-- 2. Copy dependencies to target folder -->");
line("  <!-- 3. Add third-party libraries -->");
line("  <!-- 4. maven add dependencies to jar -->");
line("  <!-- http://stackoverflow.com/questions/574594/how-can-i-create-an-executable-jar-with-dependencies-using-maven  -->\n");

line("  <!-- Mongo Comands -->");
line("  <!-- show databases -->");
line("  <!-- use "+artifactId+" -->");
line("  <!-- show collections -->");
line("  <!-- db.Person.find().pretty() -->\n");

line("  <modelVersion>4.0.0</modelVersion>\n");

line("  <groupId>"+groupId+"</groupId>");
line("  <artifactId>"+artifactId+"</artifactId>");
line("  <packaging>jar</packaging>");
line("  <version>1.0-SNAPSHOT</version>");
line("  <name>"+artifactId+"</name>");
line("  <url>http://maven.apache.org</url>\n");

line("  <properties>");
line("    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>");
line("  </properties>\n");

line("  <dependencyManagement>");
line("    <dependencies>");
line("      <dependency>");
line("        <groupId>org.hibernate.ogm</groupId>");
line("        <artifactId>hibernate-ogm-bom</artifactId>");
line("        <type>pom</type>");
line("        <version>4.1.1.Final</version>");
line("        <scope>import</scope>");
line("      </dependency>");
line("    </dependencies>");
line("  </dependencyManagement>\n");

line("  <dependencies>\n");

line("    <dependency>");
line("      <groupId>co.simasoft</groupId>");
line("      <artifactId>simasoft</artifactId>");
line("      <version>1.0-SNAPSHOT</version>");
line("    </dependency>\n");

line("    <!-- Use this for MongoDB -->");
line("    <dependency>");
line("      <groupId>org.hibernate.ogm</groupId>");
line("      <artifactId>hibernate-ogm-mongodb</artifactId>");
line("    </dependency>\n");

line("    <dependency>");
line("      <groupId>org.jboss.jbossts</groupId>");
line("      <artifactId>jbossjta</artifactId>");
line("    </dependency>\n");

line("    <!-- Hibernate Search -->");
line("    <dependency>");
line("      <groupId>org.hibernate</groupId>");
line("      <artifactId>hibernate-search-orm</artifactId>");
line("    </dependency>\n");

line("  </dependencies>\n");

line("  <build>");

line("    <resources>");
line("      <resource>");
line("        <directory>src/resources</directory>");
line("        <excludes><exclude>**/*.java</exclude></excludes>");
line("      </resource>");
line("    </resources>\n");

line("    <pluginManagement>");
line("      <plugins>\n");

line("        <!-- Compiler plugin enforces Java 1.7 compatibility and activates annotation processors -->");
line("        <!-- mvn archetype:generate > a.txt -->");
line("        <plugin>");
line("          <artifactId>maven-compiler-plugin</artifactId>");
line("          <version>3.1</version>");
line("          <configuration>");
line("            <source>1.7</source>");
line("            <target>1.7</target>");
line("            <encoding>UTF-8</encoding>");
line("          </configuration>");
line("        </plugin>\n");

line("        <plugin>");
line("          <groupId>org.apache.maven.plugins</groupId>");
line("          <artifactId>maven-jar-plugin</artifactId>");
line("          <version>2.4</version>");
line("          <configuration>");
line("            <archive>");
line("              <manifest>");
line("                <mainClass>"+groupId+".App</mainClass>");
line("              </manifest>");
line("            </archive>");
line("          </configuration>");
line("        </plugin>\n");

line("        <plugin>");
line("          <artifactId>maven-assembly-plugin</artifactId>");
line("          <configuration>");
line("            <archive>");
line("              <manifest>");
line("                <mainClass>"+groupId+".App</mainClass>");
line("              </manifest>");
line("            </archive>");
line("            <descriptorRefs>");
line("              <descriptorRef>jar-with-dependencies</descriptorRef>");
line("            </descriptorRefs>");
line("          </configuration>");
line("          <executions>");
line("            <execution>");
line("              <id>make-assembly</id> <!-- this is used for inheritance merges -->");
line("              <phase>package</phase> <!-- bind to the packaging phase -->");
line("              <goals>");
line("                <goal>single</goal>");
line("              </goals>");
line("            </execution>");
line("          </executions>");
line("        </plugin>\n");

line("      </plugins>\n");

line("    </pluginManagement>\n");

line("  </build>\n");

line("</project>\n");


  } // Generar

} // Fin de clase
