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

    private static final String comillas = "\\\\\"";

    @PersistenceContext(unitName = "naifg7PU-JTA")
    private EntityManager em;

    int i=0;
    int j=0;

    public void data() {
    try {

        System.out.println("Hello World Setup!");

        clearFileTxt();

        SearchBean searchBean = new SearchBean();
        NaifgBean naifgBean = new NaifgBean();

line("package co.simasoft.setup;");

line("import co.simasoft.models.naif.domainmodels.*;\n");

line("import co.simasoft.beans.*;\n");

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

line("    SearchBean searchBean = new SearchBean();\n");

line("    public void data() {\n");


line("//      ---------------------- Dependency ------------------------\n");

        i=0;

//        List<Dependency> dependencys = searchBean.selectAllDependency(em);

        List<Dependency> dependencys = naifgBean.findAllDependency(em);
        for (Dependency dependency : dependencys) {

line("        Dependency dependency"+String.valueOf(++i)+" = new Dependency();");
//line("        dependency"+String.valueOf(i)+".setOrden();");
line("        dependency"+String.valueOf(i)+".setGroupId(\""+dependency.getGroupId()+"\");");
line("        dependency"+String.valueOf(i)+".setArtifactId(\""+dependency.getArtifactId()+"\");");
line("        dependency"+String.valueOf(i)+".setLink(\""+dependency.getLink()+"\");");
line("        dependency"+String.valueOf(i)+".setMaven(\""+dependency.getMaven()+"\");");
line("        em.persist(dependency"+String.valueOf(i)+");");
line("        em.flush();\n");

        } // dependencys

line("//      ---------------------- Imports ------------------------\n");

        i=0;
//        List<Imports> importss = searchBean.selectAllImports(em);
        List<Imports> importss = naifgBean.findAllImports(em);
        for (Imports imports : importss) {

line("        Imports imports"+String.valueOf(++i)+" = new Imports();");
line("        imports"+String.valueOf(i)+".setName(\""+imports.getName()+"\");");
              if (imports.getDependency() != null){
line("        Dependency dependencyImports"+String.valueOf(i)+" = new Dependency();");
line("        dependencyImports"+String.valueOf(i)+" = searchBean.artifactIdDependency(\""+imports.getDependency().getArtifactId()+"\",em);");
line("        imports"+String.valueOf(i)+".setDependency(dependencyImports"+String.valueOf(i)+");");
              }
line("        em.persist(imports"+String.valueOf(i)+");");
line("        em.flush();\n");

        } // Imports

line("//      ---------------------- AttributesProperties ------------------------\n");

        List<AttributesProperties> attributesProperties = searchBean.selectAllAttributesProperties(em);
        for (AttributesProperties attributeProperty : attributesProperties) {

line("        PropertiesAttributes attributesProperties"+String.valueOf(++i)+" = new PropertiesAttributes();");
line("        attributesProperties"+String.valueOf(i)+".setName(\""+attributeProperty.getName()+"\");");
line("        attributesProperties"+String.valueOf(i)+".setValue(\""+attributeProperty.getValue().replaceAll("\"",comillas)+"\");");
line("        em.persist(attributesProperties"+String.valueOf(i)+");");
line("        em.flush();\n");
        } // AttributesProperties

line("//      ---------------------- AttributesTypes ------------------------\n");

        i=0;
        j=0;
        List<AttributesTypes> attributesTypes = searchBean.selectAllAttributesTypes(em);
        for (AttributesTypes attributeType : attributesTypes) {

line("        AttributesTypes attributesTypes"+String.valueOf(++i)+" = new AttributesTypes();");
line("        attributesTypes"+String.valueOf(i)+".setName(\""+attributeType.getName()+"\");");
line("        attributesTypes"+String.valueOf(i)+".setType(\""+attributeType.getType()+"\");");
line("        attributesTypes"+String.valueOf(i)+".setObservations(\""+attributeType.getObservations().replaceAll("\"",comillas)+"\");");
              if (!attributeType.getAttributesProperties().isEmpty()){
line("");
line("        Set<PropertiesAttributes> attributesTypesAttributesProperties"+String.valueOf(i)+" = new HashSet<PropertiesAttributes>();");
                 for (AttributesProperties attributesProperty : attributeType.getAttributesProperties() ) {
line("//      ...................... "+attributesProperty.getName()+"........................");
line("        PropertiesAttributes attributeTypeAttributeProperty"+String.valueOf(++j)+" = searchBean.namePropertiesAttributes(\""+attributesProperty.getName()+"\",em);");
line("        attributesTypesAttributesProperties"+String.valueOf(i)+".add(attributeTypeAttributeProperty"+String.valueOf(j)+");");
                 }
line("        attributesTypes"+String.valueOf(i)+".setPropertiesAttributes(attributesTypesAttributesProperties"+String.valueOf(i)+");\n");
              }
line("        em.persist(attributesTypes"+String.valueOf(i)+");");
line("        em.flush();\n");

        } // AttributesTypes

line("//      ---------------------- Cardinalities ------------------------\n");

        i=0;
        List<Cardinalities> cardinalities = searchBean.selectAllCardinalities(em);
        for (Cardinalities cardinality : cardinalities) {

line("        Cardinalities cardinalities"+String.valueOf(++i)+" = new Cardinalities();");
line("        cardinalities"+String.valueOf(i)+".setName(\""+cardinality.getName()+"\");");
line("        cardinalities"+String.valueOf(i)+".setCardinality(\""+cardinality.getCardinality()+"\");");
line("        cardinalities"+String.valueOf(i)+".setUnidirectional("+cardinality.getUnidirectional()+");");
line("        em.persist(cardinalities"+String.valueOf(i)+");");
line("        em.flush();\n");

        } // Cardinalities

line("    } // data()\n");

line("} // Setup");

        saveFile("\\docs", "Setup.java");

    } // try
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    } // data



} // Setup
