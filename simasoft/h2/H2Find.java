package co.simasoft.gen.war.h2;

import co.simasoft.utils.*;

import java.io.*;
import java.lang.*;
import java.util.*;

import java.util.HashSet;
import java.util.Set;

public class H2Find extends FileTxt {

  private LinkedHashSet<String> imports = new LinkedHashSet<String>();

  public H2Find(String artifactId,String groupId,ArrayList<Entidad> entities) {

         for(Entidad entidad : entities) {
            imports.add(entidad.getGroupId());
         } // for entities

line("package "+groupId+".beans;\n");

         for (String impor : imports) {
line("import "+impor+".*;");
         }
line("");

line("import java.util.*;\n");

line("import java.util.Calendar;");
line("import java.util.HashMap;");
line("import java.util.List;");
line("import java.util.Map;");
line("import java.util.Random;");
line("import java.util.StringTokenizer;\n");

line("import javax.ejb.LocalBean;");
line("import javax.ejb.Stateless;");
line("import javax.persistence.EntityManager;");
line("import javax.persistence.LockModeType;");
line("import javax.persistence.OptimisticLockException;");
line("import javax.persistence.PersistenceContext;\n");

line("@Stateless");
line("@LocalBean");
line("public class FindBean {\n");

line("    @PersistenceContext(unitName = \""+artifactId+"PU-JTA\")");
line("    private EntityManager em;\n");

            for(Entidad entidad : entities) {

line("//      ---------------------- "+entidad.getName()+" ------------------------\n");

line("    public List<"+entidad.getName()+"> All"+entidad.getName()+"() {");

line("        List<"+entidad.getName()+"> results = em.createQuery(\"SELECT o FROM "+entidad.getName()+" o\").getResultList();");

line("        if (results.isEmpty()) {");
line("            return new ArrayList<"+entidad.getName()+">();");
line("        }");

line("        return results;");
line("    }\n");


line("    public "+entidad.getName()+" id"+entidad.getName()+"(Long id) {\n");

line("        "+entidad.getName()+" "+Utils._1raMin(entidad.getName())+" = new "+entidad.getName()+"();");
line("        List<"+entidad.getName()+"> results = em.createQuery(\"SELECT o FROM "+entidad.getName()+" o WHERE o.id LIKE :custId\").setParameter(\"custId\", id).getResultList();\n");

line("        if (!results.isEmpty()) {\n");
line("           "+Utils._1raMin(entidad.getName())+" = results.get(0);");
line("        }");
line("        return "+Utils._1raMin(entidad.getName())+";");
line("    }\n");

                for(Atributos atributo : entidad.getAtributos()) {

                    switch (atributo.getType()) {
                        case "String":

line("    public "+entidad.getName()+" "+atributo.getField()+entidad.getName()+"(String search,EntityManager em) {\n");

line("        "+entidad.getName()+" "+Utils._1raMin(entidad.getName())+" = new "+entidad.getName()+"();");
line("        List<"+entidad.getName()+"> results = em.createQuery(\"SELECT o FROM "+entidad.getName()+" o WHERE o."+atributo.getField()+" LIKE :field\").setParameter(\"field\", search).getResultList();\n");

line("        if (!results.isEmpty()) {");
line("           "+Utils._1raMin(entidad.getName())+" = results.get(0);");
line("        }");
line("        return "+Utils._1raMin(entidad.getName())+";");
line("    }\n");

                             break;
                        default:
                             break;
                    } // switch (atributo.getType())

                } // entidad.getAtributos()

            } // for entities


line("} // Fin de clase");

  } // Contructor

} // Claas