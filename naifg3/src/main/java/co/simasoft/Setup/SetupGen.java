package co.simasoft.setup;

import co.simasoft.utils.*;
import co.simasoft.beans.*;

import co.simasoft.models.dev.naifg.*;
import co.simasoft.models.dev.naifg.dependencies.*;


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

    @PersistenceContext(unitName = "naifgPU-JTA")
    private EntityManager em;

    public void data() {
    try {

        System.out.println("Hello World Setup!");

        clearFileTxt();

        FindBean findBean = new FindBean();

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


line("//      ---------------------- Dependency ------------------------\n");

        int i=0;
        List<Dependencies> dependencys = findBean.AllDependencies(em);
        for (Dependencies dependency : dependencys) {

line("        Dependency dependency"+String.valueOf(++i)+" = new Dependency();");
//line("        dependency"+String.valueOf(i)+".setOrden();");
line("        dependency"+String.valueOf(i)+".setGroupId(\""+dependency.getGroupId()+"\");");
line("        dependency"+String.valueOf(i)+".setArtifactId(\""+dependency.getArtifactId()+"\");");
line("        em.persist(dependency"+String.valueOf(i)+");");
line("        em.flush();\n");

        } // dependencys

line("//      ---------------------- Imports ------------------------\n");

        i=0;
        List<Imports> importss = findBean.AllImports(em);
        for (Imports imports : importss) {

line("        Imports imports"+String.valueOf(++i)+" = new Imports();");
line("        imports"+String.valueOf(i)+".setName(\""+imports.getName()+"\");");
// line("        imports"+String.valueOf(i)+".setArtifactId(\""+imports.getDependencies().getArtifactId()+"\");");
line("        em.persist(imports"+String.valueOf(i)+");");
line("        em.flush();\n");

        } // Imports

line("//      ---------------------- AttributesTypes ------------------------\n");

        i=0;
        List<AttributesTypes> attributesTypes = findBean.AllAttributesTypes(em);
        for (AttributesTypes attributeType : attributesTypes) {

line("        AttributesTypes attributesTypes"+String.valueOf(++i)+" = new AttributesTypes();");
line("        attributesTypes"+String.valueOf(i)+".setName(\""+attributeType.getName()+"\");");
line("        attributesTypes"+String.valueOf(i)+".setType(\""+attributeType.getType()+"\");");
line("        attributesTypes"+String.valueOf(i)+".setObservations(\""+attributeType.getObservations()+"\");");
line("        em.persist(attributesTypes"+String.valueOf(i)+");");
line("        em.flush();\n");

        } // AttributesTypes


line("    } // data()\n");

line("} // Setup");

        saveFile("\\docs", "Setup.java");

    } // try
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    } // data



} // Setup
