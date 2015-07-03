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

line("import co.simasoft.models.naif.domainmodels.*;\n");

line("import co.simasoft.beans.*;\n");

line("import co.simasoft.utils.*;\n");

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

line("    @PersistenceContext(unitName = \"naifg8PU-JTA\")");
line("    private EntityManager em;\n");

line("    FindBean findBean = new FindBean();\n");

line("    private static final Logger log = Logger.getLogger(DataDb.class.getName());\n");

line("    public void data() {\n");

line("//      ---------------------- DomainModels ------------------------\n");

line("        DomainModels domainModels = new DomainModels();");
line("        domainModels.setGroupId(\""+domain.getGroupId()+"\");");
line("        domainModels.setArtifactId(\""+domain.getArtifactId()+"\");");
line("        em.persist(domainModels);");
line("        em.flush();\n");

line("//      ---------------------- GroupIds ------------------------\n");

    i=0;
    j=0;
    for (Packages groupId : domain.getPackages()){

line("        GroupIds groupIds"+String.valueOf(++i)+" = new GroupIds();");
line("        groupIds"+String.valueOf(i)+".setGroupId(\""+groupId.getGroupId()+"\");");
line("//      ...................... "+domain.getArtifactId()+" ........................");
line("        DomainModels domainModel"+String.valueOf(++j)+" = new DomainModels();");
line("        domainModel"+String.valueOf(j)+" = findBean.artifactIdDomainModels(\""+domain.getArtifactId()+"\",em);");
line("        groupIds"+String.valueOf(i)+".setDomainModels(domainModel"+String.valueOf(j)+");");
line("        em.persist(groupIds"+String.valueOf(i)+");");
line("        em.flush();\n");

line("//      ---------------------- Entities ------------------------\n");

        for (Entidad entidad: groupId.getEntities()) {

line("        Entities entities"+String.valueOf(++i)+" = new Entities();");
line("        entities"+String.valueOf(i)+".setName(\""+entidad.getName()+"\");");
line("//      ...................... "+groupId.getGroupId()+" ........................");
line("        GroupIds groupIds"+String.valueOf(++j)+" = new GroupIds();");
line("        groupIds"+String.valueOf(j)+" = findBean.groupIdGroupIds(\""+groupId.getGroupId()+"\",em);");
line("        entities"+String.valueOf(i)+".setGroupIds(groupIds"+String.valueOf(j)+");");
line("        em.persist(entities"+String.valueOf(i)+");");
line("        em.flush();\n");

line("//      ---------------------- Attributes ------------------------\n");

            for (Atributos attri: entidad.getAtributos()) {

line("        Attributes attributes"+String.valueOf(++i)+" = new Attributes();");
line("        attributes"+String.valueOf(i)+".setName(\""+attri.getName()+"\");");
line("        attributes"+String.valueOf(i)+".setNullable("+attri.getNullable()+");");
line("        attributes"+String.valueOf(i)+".setSingle("+attri.getSingle()+");");
line("//      ...................... "+attri.getEntities().getName()+" ........................");
line("        Entities entities"+String.valueOf(++j)+" = new Entities();");
line("        entities"+String.valueOf(j)+" = findBean.nameEntities(\""+attri.getEntities().getName()+"\",em);");
line("        attributes"+String.valueOf(i)+".setEntities(entities"+String.valueOf(j)+");");
line("//      ...................... "+attri.getAttributesTypes().getName()+" ........................");
line("        AttributesTypes attributesTypes"+String.valueOf(++j)+" = new AttributesTypes();");
line("        attributesTypes"+String.valueOf(j)+" = findBean.nameAttributesTypes(\""+attri.getAttributesTypes().getName()+"\",em);");
line("        attributes"+String.valueOf(i)+".setAttributesTypes(attributesTypes"+String.valueOf(j)+");");
line("        em.persist(attributes"+String.valueOf(i)+");");
line("        em.flush();\n");

            } // for


        } // for

    } // for

    for (Packages packages : domain.getPackages()){

        for (Relation relation: packages.getRelations()) {

line(relation.getFrom()+" "+relation.getCardinality()+" "+relation.getTo());

        } // for

    } // for


    saveFile("\\docs", domain.getArtifactId()+"Setup.java");

    } // try
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

} // Constructor

} // class


