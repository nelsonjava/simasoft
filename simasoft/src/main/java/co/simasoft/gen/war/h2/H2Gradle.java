package co.simasoft.gen.war.h2;

import co.simasoft.utils.*;

public class H2Gradle extends FileTxt {

  public H2Gradle(String artifactId,String groupId) {

line("buildscript {");
line("    repositories {");
line("        mavenCentral()");
line("    }");
line("}\n");

line("repositories {");
line("    mavenCentral()");
line("}\n");

line("apply plugin: 'java'");
line("apply plugin: 'war'");
line("apply plugin: 'eclipse'");
line("apply plugin: 'idea'\n");

line("sourceCompatibility = 1.8");
line("targetCompatibility = 1.8\n");

line("war {");
line("    baseName = '"+artifactId+"'");
line("    version = '0.0.1-SNAPSHOT'");
line("}\n");

line("dependencies {");
line("    compile 'org.springframework:spring-context:4.2.1.RELEASE'");
line("}");

  } // Generar

} // Fin de clase
