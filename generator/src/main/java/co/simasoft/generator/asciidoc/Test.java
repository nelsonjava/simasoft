package co.simasoft.generator.asciidoc;

import co.simasoft.utils.*;

import java.io.*;
import java.util.*;

public class Test extends FileTxt {

  public Test(String artifactId,String groupId) throws IOException {

      ArrayList<Entidad> entidades = new ArrayList<Entidad>();
      ArrayList<Atributos> atributos = new ArrayList<Atributos>();
      ArrayList<Relation> relations = new ArrayList<Relation>();

      PowerDesigner powerDesigner = new PowerDesigner("/dev/njava/modelos/uml/contab/contab.oob");
      entidades = powerDesigner.getEntidades();
      relations = powerDesigner.getRelations();

line("[[wildfly-test]]");

line("////");
line("a=&#225; e=&#233; i=&#237; o=&#243; u=&#250;");

line("A=&#193; E=&#201; I=&#205; O=&#211; U=&#218;");

line("n=&#241; N=&#209;");
line("////");

line("== TEST");
line("image::images/modelo.jpg[]");

line("*RELATIONS:*");
line("[options=\"header\"]");
line("|===");
line("|From      |Cardinality               |To       |Optionality  |Navigability ");

          for(Relation relation : relations) {
line("|"+relation.getFrom()+"|"+relation.getCardinality()+"|"+relation.getTo()+"|"+relation.getOptionality()+"|"+relation.getNavigability());
          } // for Relation
line("|===");

  } // Asciidoc

} // Test

