package co.simasoft.generator.asciidoc;

import co.simasoft.utils.*;

import java.io.*;
import java.util.*;

public class Asciidoc extends FileTxt {

    private ArrayList<Entidad> entidades = new ArrayList<Entidad>();
    private ArrayList<Atributos> atributos = new ArrayList<Atributos>();
    private ArrayList<Relation> relations = new ArrayList<Relation>();

    public Asciidoc(String artifactId,String groupId,ArrayList<Entidad> entidades) throws IOException {

        this.entidades = entidades;

line("[[wildfly-instalacion]]");

line("////");
line("a=&#225; e=&#233; i=&#237; o=&#243; u=&#250;");

line("A=&#193; E=&#201; I=&#205; O=&#211; U=&#218;");

line("n=&#241; N=&#209;");
line("////");

line("== MODELO");
line("image::images/modelo.jpg[]");

      for(Entidad entidad : entidades) {

line("== ENTITY:"+entidad.getName());

line("*ATRIBUTES:*");
line("[options=\"header\"]");
line("|===");
line("|Atribute      |Type               |Length       |Null  |Unique ");

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

line("*RELATIONS:*");
line("[options=\"header\"]");
line("|===");
line("|From      |Cardinality               |To       |Optionality  |Navigability ");

          relations = entidad.getRelations();

          for(Relation relation : relations) {
line("|"+relation.getFrom()+"|"+relation.getCardinality()+"|"+relation.getTo()+"|"+relation.getOptionality()+"|"+relation.getNavigability());
          } // for Relation
line("|===");

    } // for entidades


  } // Asciidoc

} // Asciidoc

