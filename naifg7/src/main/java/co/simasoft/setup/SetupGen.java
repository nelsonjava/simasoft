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

    @PersistenceContext(unitName = "naifg7PU-JTA")
    private EntityManager em;

    public void data() {
    try {

        System.out.println("Hello World Setup!");

        clearFileTxt();

        NaifgBean naifgBean = new NaifgBean();

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

line("    @PersistenceContext(unitName = \"naifg7PU-JTA\")");
line("    private EntityManager em;\n");

line("    private static final Logger log = Logger.getLogger(Setup.class.getName());\n");

line("    public void data() {\n");

line("    } // data()\n");

line("//      ---------------------- AttributesProperties ------------------------\n");

        int i=0;
        List<AttributesProperties> attributesProperties = naifgBean.findAllAttributesProperties(em);
        for (AttributesProperties attributeProperty : attributesProperties) {

line("        AttributesProperties attributesProperties"+String.valueOf(++i)+" = new AttributesTypes();");
line("        attributesProperties"+String.valueOf(i)+".setName(\""+attributeProperty.getName()+"\");");
line("        attributesProperties"+String.valueOf(i)+".setCardinality(\""+attributeProperty.getValue()+"\");");
line("        em.persist(attributesProperties"+String.valueOf(i)+");");
line("        em.flush();\n");

        } // AttributesTypes


line("//      ---------------------- Cardinalities ------------------------\n");

        i=0;
        List<Cardinalities> cardinalities = naifgBean.findAllCardinalities(em);
        for (Cardinalities cardinality : cardinalities) {

line("        Cardinalities cardinalities"+String.valueOf(++i)+" = new AttributesTypes();");
line("        cardinalities"+String.valueOf(i)+".setName(\""+cardinality.getName()+"\");");
line("        cardinalities"+String.valueOf(i)+".setCardinality(\""+cardinality.getCardinality()+"\");");
line("        cardinalities"+String.valueOf(i)+".setUnidirectional(\""+cardinality.getUnidirectional()+"\");");
line("        em.persist(cardinalities"+String.valueOf(i)+");");
line("        em.flush();\n");

        } // AttributesTypes

line("} // Setup");


        saveFile("\\docs", "Setup.java");

    } // try
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    } // data



} // Setup
