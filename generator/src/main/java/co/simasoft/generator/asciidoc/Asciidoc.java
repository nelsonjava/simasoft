package co.simasoft.generator.asciidoc;

import co.simasoft.utils.*;

import java.io.*;
import java.util.*;

public class Asciidoc extends FileTxt {

  public Asciidoc(String artifactId,String groupId) throws IOException {

      ArrayList<Entidad> entidades = new ArrayList<Entidad>();
      ArrayList<Atributos> atributos = new ArrayList<Atributos>();


line("[[wildfly-instalacion]]");

line("////");
line("a=&#225; e=&#233; i=&#237; o=&#243; u=&#250;");

line("A=&#193; E=&#201; I=&#205; O=&#211; U=&#218;");

line("n=&#241; N=&#209;");
line("////");

      entidades = PowerDesigner.Entidades("/dev/njava/modelos/uml/contab/contab.oob");

      for(Entidad entidad : entidades) {

line("== "+entidad.getName());

line("[options=\"header\"]");
line("|===");
line("|Atributo      |Type               |Length       |Null  |Unique ");

          atributos = entidad.getAtributos();

          for(Atributos atributo : atributos) {

line("|"+atributo.getField()+"|"+atributo.getType()+"|"+atributo.getLength()+"|"+atributo.getNulo()+"|"+atributo.getUnique());

/*
line("=== "+atributo.getField());
line("* unico:"+atributo.getUnique());
line("* tipo:"+atributo.getType());
line("* nulo:"+atributo.getLength());
line("* len:"+atributo.getNulo());
*/

          } // for atributos
line("|===");


      } // for entidades


  } // Asciidoc

} // Asciidoc




