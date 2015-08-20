package co.simasoft.gen.sql;

import co.simasoft.utils.*;

import java.io.*;
import java.lang.*;
import java.util.*;

import java.util.HashSet;
import java.util.Set;

/****************************************************************************************************************
* CLASE : DataGenH2                                                                                             *
*****************************************************************************************************************

AUTOR: Nelson A Fernández Gómez                FECHA DE INICIO: LUN 29 JUN/2015   FECHA FINAL: LUN 29 JUN/2015
       SIMASOFT Bucaramanga / SAN / Colombia   FECHA DE LA ULTIMA MODIFICACION:   LUN 29 JUN/2015 HORA: 10:00 AM

OBJETIVOS:

1- Genera el codigo java para generar los registros de las entidades y sus atributos de acuerdo al diseño en
   powerDesiger.

2- Permite varios diseños que conforman un solo modelo.

2- El id es de tipo long

3- Trabaja bien en H2.

*---------------------------------------------------------------------------------------------------------------*
*------------------------------------------- DECLARACION DE LA CLASE -------------------------------------------*
*---------------------------------------------------------------------------------------------------------------*/

public class DataGenH2 extends FileTxt {

//>>DECLARACION DE INSTANCIAS
      int i=0;
      int j=0;
      LinkedHashSet<String> imports = new LinkedHashSet<String>();
//>>DECLARACION DE INSTANCIAS

/****************************************************************************************************************
* METODO..: Constructor de la clase                                                                             *
*****************************************************************************************************************

AUTOR: Nelson A Fernández Gómez                FECHA DE INICIO: LUN 29 JUN/2015   FECHA FINAL: LUN 29 JUN/2015
       SIMASOFT Bucaramanga / SAN / Colombia   FECHA DE LA ULTIMA MODIFICACION:   LUN 29 JUN/2015 HORA: 10:15 AM

OBJETIVOS:

1- Inicializa los atributos de la clase, que se van a usar para construir el archivo .java del bean de entidad.

*---------------------------------------------------------------------------------------------------------------*
*                                           IMPLEMENTACION DEL METODO                                           *
*---------------------------------------------------------------------------------------------------------------*/

public DataGenH2(Domains domain) throws IOException {
    try {

    for (Packages groupId : domain.getPackages()){
        imports.add(groupId.getGroupId());
    }

line("package "+domain.getGroupId()+".setup;\n");

line("import "+domain.getGroupId()+".beans.*;");
line("import "+domain.getGroupId()+".utils.*;\n");

line("import co.simasoft.models.dev.naifg.sites.*;");
line("import co.simasoft.models.dev.naifg.*;");
line("import co.simasoft.models.dev.naifg.dependencies.*;");

/*
    i=0;
    for (String impor : imports) {

line("import "+impor+".*;");

    } // for: imports
*/

line("");

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
line("@Named(\""+domain.getArtifactId()+"Setup\")");
line("public class "+domain.getArtifactId()+"Setup {\n");

line("    @PersistenceContext(unitName = \"naifgPU-JTA\")");
line("    private EntityManager em;\n");

line("    FindBean findBean = new FindBean();\n");

line("    private static final Logger log = Logger.getLogger("+domain.getArtifactId()+"Setup.class.getName());\n");

line("    public void data() {\n");

line("//      ---------------------- GroupIds ------------------------\n");

    i=0;
    j=0;
    for (String impor : imports) {

line("        GroupIds groupIds"+String.valueOf(++i)+" = new GroupIds();");
line("        groupIds"+String.valueOf(i)+".setGroupId(\""+impor+"\");");
line("        groupIds"+String.valueOf(i)+".setArtifactId(\""+impor+"\");");
line("        em.persist(groupIds"+String.valueOf(i)+");");
line("        em.flush();\n");

    } // for: imports

line("//      ---------------------- Models ------------------------\n");

line("        Models models = new Models();");
line("        models.setGroupId(\""+domain.getGroupId()+"."+domain.getArtifactId()+"\");");
line("        models.setArtifactId(\""+domain.getArtifactId()+"\");");
line("        models.setVersion(\""+domain.getVersion()+"\");");
line("        em.persist(models);");
line("        em.flush();\n");

line("//      ---------------------- Developments ------------------------\n");

line("        Developments dev = new Developments();");
line("        dev.setGroupId(\""+domain.getGroupId()+"\");");
line("        dev.setArtifactId(\""+domain.getArtifactId()+"\");");
line("        dev.setVersion(\""+domain.getVersion()+"\");");
line("        Set<Models> models1 = new HashSet<Models>();");
line("        Models model1 = findBean.artifactIdModels(\""+domain.getArtifactId()+"\",em);");
line("        models1.add(model1);");
line("        dev.setModels(models1);");
line("        em.persist(dev);");
line("        em.flush();\n");

    i=0;
    j=0;
    for (Packages groupId : domain.getPackages()){


line("//      ---------------------- Entities ------------------------\n");

        for (Entidad entidad: groupId.getEntities()) {

line("        Entities entities"+String.valueOf(++i)+" = new Entities();");
line("        entities"+String.valueOf(i)+".setName(\""+entidad.getName()+"\");");
line("//      ...................... "+groupId.getGroupId()+" ........................");
line("        GroupIds groupId"+String.valueOf(++j)+" = new GroupIds();");
line("        groupId"+String.valueOf(j)+" = findBean.groupIdGroupIds(\""+groupId.getGroupId()+"\",em);");
line("        entities"+String.valueOf(i)+".setGroupIds(groupId"+String.valueOf(j)+");");
line("        em.persist(entities"+String.valueOf(i)+");");
line("        em.flush();\n");

            for (Atributos attri: entidad.getAtributos()) {

line("        Attributes attributes"+String.valueOf(++i)+" = new Attributes();");
line("        attributes"+String.valueOf(i)+".setName(\""+attri.getField()+"\");");
line("        attributes"+String.valueOf(i)+".setIsNullable("+attri.getNulo()+");");
line("        attributes"+String.valueOf(i)+".setIsUnique("+attri.getUnique()+");");
line("//      ...................... "+entidad.getName()+" ........................");
line("        Entities entity"+String.valueOf(++j)+" = new Entities();");
line("        entity"+String.valueOf(j)+" = findBean.nameEntities(\""+entidad.getName()+"\",em);");
line("        attributes"+String.valueOf(i)+".setEntities(entity"+String.valueOf(j)+");");
line("//      ...................... "+attri.getType()+" ........................");
line("        AttributesTypes attributesTypes"+String.valueOf(++j)+" = new AttributesTypes();");
line("        attributesTypes"+String.valueOf(j)+" = findBean.nameAttributesTypes(\""+attri.getType()+"\",em);");
line("        attributes"+String.valueOf(i)+".setAttributesTypes(attributesTypes"+String.valueOf(j)+");");
line("        em.persist(attributes"+String.valueOf(i)+");");
line("        em.flush();\n");

            } // for: entidad.getAtributos()

        } // for: groupId.getEntities()

    } // for: domain.getPackages()

line("//      ---------------------- Relationships ------------------------\n");

    i=0;
    for (Packages packages : domain.getPackages()){

line("/*");
        for (Relation relation: packages.getRelations()) {

            switch (relation.getCardinality()) {
                case "1..1":
                case "1..*":
                case "*..*":
                     if (relation.getRolA().equals("from") || relation.getRolB().equals("from") ){
line(". "+relation.getFrom()+" . "+relation.getCardinality()+" "+relation.getTo()+" rolA:"+relation.getRolA()+" rolB:"+relation.getRolB()+" OK\n");
                     }
                     else{
line(". "+relation.getFrom()+" . "+relation.getCardinality()+" "+relation.getTo()+" rolA:"+relation.getRolA()+" rolB:"+relation.getRolB()+"\n");
                     }
            } // switch

        } // for: packages.getRelations()
line("*/");

        for (Relation relation: packages.getRelations()) {

            switch (relation.getCardinality()) {
                case "1..1":
                case "1..*":
                case "*..*":
line("        Relationships relationships"+String.valueOf(++i)+" = new Relationships();");
line("        relationships"+String.valueOf(i)+".setIsOptionality("+relation.getOptionality()+");");
line("        relationships"+String.valueOf(i)+".setIsEmbedded(false);");
line("//      ...................... "+relation.getFrom()+" ........................");
line("        Entities entities"+String.valueOf(++j)+" = new Entities();");
line("        entities"+String.valueOf(j)+" = findBean.nameEntities(\""+relation.getFrom()+"\",em);");
line("        relationships"+String.valueOf(i)+".setFrom(entities"+String.valueOf(j)+");");
line("//      ...................... "+relation.getTo()+" ........................");
line("        Entities entities"+String.valueOf(++j)+" = new Entities();");
line("        entities"+String.valueOf(j)+" = findBean.nameEntities(\""+relation.getTo()+"\",em);");
line("        relationships"+String.valueOf(i)+".setTo(entities"+String.valueOf(j)+");");
line("//      ...................... "+Cardinaly(relation.getCardinality())+" ........................");
line("        Cardinalities cardinalities"+String.valueOf(++j)+" = new Cardinalities();");
line("        cardinalities"+String.valueOf(j)+" = findBean.nameCardinalities(\""+Cardinaly(relation.getCardinality())+"\",em);");
line("        relationships"+String.valueOf(i)+".setCardinalities(cardinalities"+String.valueOf(j)+");");
line("        em.persist(relationships"+String.valueOf(i)+");");
line("        em.flush();\n");
            } // switch

        } // for: packages.getRelations()

    } // for: domain.getPackages()

line("    } // data()\n");

line("} // "+domain.getArtifactId());

    saveFile("\\docs", domain.getArtifactId()+"Setup.java");

    } // try
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

} // Constructor

    public String Cardinaly(String cardinality) {

        switch (cardinality) {

            case "1..1":
                 return "Uno a Uno Bidirecccional No.2";

            case "*..1":
                 return "Uno a Muchos Bidirecccional No.5";

            case "1..*":
                 return "Uno a Muchos Bidirecccional No.5";

            case "*..*":
                 return "Muchos a Muchos Bidirecccional No.7";

        } // switch
        return "";

    } // Cardinaly

} // class


