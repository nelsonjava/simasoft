package co.simasoft.gen.asciidoc;

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

          } // for atributos
line("|===");

          relations = entidad.getRelations();

          if (relations.size() > 0){
line("*RELATIONS:* "+relations.size());
line("[options=\"header\"]");
line("|===");
line("|From | multiplicityA | multiplicityB | Cardinality | To | Optionality | Navigability ");
          }

          for(Relation relation : relations) {
line("|"+relation.getFrom()+"|"+relation.getMultiplicityA()+"|"+relation.getMultiplicityB()+"|"+relation.getCardinality()+"|"+relation.getTo()+"|"+relation.getOptionality()+"|"+relation.getNavigability());
          } // for Relation
          if (relations.size() > 0){
line("|===");
          }

    } // for entidades


  } // Asciidoc

} // Asciidoc

