package co.simasoft.generator.asciidoc;

import co.simasoft.utils.*;

import java.io.*;
import java.util.*;

public class Test extends FileTxt {

    private Set<Relation> relations = new HashSet<Relation>(0);

    public void setRelations(Set<Relation> relations){
        this.relations = relations;
    }


    public Test(String artifactId,String groupId,Set<Relation> relations) throws IOException {

        this.relations = relations;

line("[[wildfly-test]]");

line("////");
line("a=&#225; e=&#233; i=&#237; o=&#243; u=&#250;");

line("A=&#193; E=&#201; I=&#205; O=&#211; U=&#218;");

line("n=&#241; N=&#209;");
line("////");

line("== TEST");
line("image::images/modelo.jpg[]");

line("*RELATIONS:*"+relations.size());
line("[options=\"header\"]");
line("|===");
line("|From      |Cardinality               |To       |Optionality  |Navigability ");

          for(Relation relation : relations) {
line("|"+relation.getFrom()+"|"+relation.getCardinality()+"|"+relation.getTo()+"|"+relation.getOptionality()+"|"+relation.getNavigability());
          } // for Relation
line("|===");

    } // Test

} // Test

