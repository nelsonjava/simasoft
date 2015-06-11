package co.simasoft.setup;

import co.simasoft.utils.*;
import co.simasoft.beans.*;

import co.simasoft.models.naif.domainmodels.*;

import java.util.*;
import java.util.Calendar;
import java.util.Random;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jboss.logging.Logger;

@Singleton
@LocalBean
@Named("SetupGen")
public class SetupGen extends FileTxt {

    @PersistenceContext(unitName = "naifg8PU-JTA")
    private EntityManager em;

    public void data() {
    try {

        System.out.println("Hello World Setup!");

        clearFileTxt();

        SearchBean searchBean = new SearchBean();

line("package co.simasoft.setup;");

line("import co.simasoft.models.naif.domainmodels.*;\n");

line("import java.util.*;");
line("import java.util.Calendar;");
line("import java.util.Random;");
line("import javax.ejb.LocalBean;");
line("import javax.ejb.Singleton;");
line("import javax.inject.Named;");
line("import javax.persistence.EntityManager;");
line("import javax.persistence.PersistenceContext;");
line("import org.jboss.logging.Logger;\n");

line("@Singleton");
line("@LocalBean");
line("@Named(\"Setup\")");
line("public class Setup {\n");

line("    @PersistenceContext(unitName = \"naifg8PU-JTA\")");
line("    private EntityManager em;\n");

line("    private static final Logger log = Logger.getLogger(Setup.class.getName());\n");

line("    public void data() {\n");

line("    } // data()\n");

line("//      ---------------------- Dependency ------------------------\n");

        int i=0;
        List<Dependency> dependencys = searchBean.selectAllDependency(em);
        for (Dependency dependency : dependencys) {

line("        Dependency dependency"+String.valueOf(++i)+" = new Dependency();");
//line("        dependency"+String.valueOf(i)+".setOrden();");
line("        dependency"+String.valueOf(i)+".setGroupId(\""+dependency.getGroupId()+"\");");
line("        dependency"+String.valueOf(i)+".setArtifactId(\""+dependency.getArtifactId()+"\");");
line("        em.persist(dependency"+String.valueOf(i)+");");
line("        em.flush();\n");

        } // dependencys

line("//      ---------------------- Imports ------------------------\n");

        i=0;
        List<Imports> importss = searchBean.selectAllImports(em);
        for (Imports imports : importss) {

line("        Imports imports"+String.valueOf(++i)+" = new Dependency();");
line("        imports"+String.valueOf(i)+".setName(\""+imports.getName()+"\");");
line("        em.persist(imports"+String.valueOf(i)+");");
line("        em.flush();\n");

        } // Imports
        
line("//      ---------------------- Imports ------------------------\n");

        i=0;
        List<Imports> importss = searchBean.selectAllImports(em);
        for (Imports imports : importss) {

line("        Imports imports"+String.valueOf(++i)+" = new Dependency();");
line("        imports"+String.valueOf(i)+".setName(\""+imports.getName()+"\");");
line("        em.persist(imports"+String.valueOf(i)+");");
line("        em.flush();\n");

        } // Imports







line("} // Setup");








/*
        Naifg8Bean naifg8Bean = new Naifg8Bean();
        List<Cardinalities> cars = naifg8Bean.selectAllCardinalities(em);
        for (Cardinalities car : cars) {
            line(car.getName());
        line("PASOX");
        } // Cardinalities

        NaifgBean naifgBean = new NaifgBean();
        List<Cardinalities> cars = naifgBean.findAllCardinality(em);
        for (Cardinalities car : cars) {
            line(car.getName());
        } // Cardinalities

*/


        saveFile("\\docs", "Setup.java");

    } // try
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    } // data



} // Setup
