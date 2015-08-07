/*
line(Integer.toString(developments.getModels().size()));
*/

package co.simasoft.setup;

import co.simasoft.utils.*;
import co.simasoft.beans.*;
import co.simasoft.models.dev.naifg.*;
import co.simasoft.models.dev.naifg.dependencies.*;

import java.io.*;
import java.util.*;

import java.util.Calendar;
import java.util.Random;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jboss.logging.Logger;
import javax.faces.context.FacesContext;
import javax.faces.context.ExternalContext;

import org.apache.lucene.search.NumericRangeQuery;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.query.DatabaseRetrievalMethod;
import org.hibernate.search.query.ObjectLookupMethod;
import org.hibernate.search.query.dsl.QueryBuilder;

/*
  Pruebas a archivo texto
  FileTxt fileTxt = new FileTxt();
  fileTxt.line("Prueba");
  Utils.fileMake("\\docs","leame.txt",fileTxt );
*/


@Singleton
@LocalBean
@Named("DevelopmentsGen")
public class DevelopmentsGen extends FileTxt {

    private static final Logger log = Logger.getLogger(DevelopmentsGen.class.getName());

    private static final String QUERYA = "SELECT c FROM AttributesProperties c WHERE c.name LIKE :custName";

    @PersistenceContext(unitName = "naifgPU-JTA")
    private EntityManager em;

    public void data(Developments developments) throws IOException {
    try {

        LinkedHashSet<String> imports = new LinkedHashSet<String>();

        System.out.println("Hello World!" + developments.getName());

        for (Models models : developments.getModels()){
             for (GroupIds groupId : models.getGroupIds()){
                 imports.add("import "+groupId.getGroupId()+".*;");
line("import "+groupId.getGroupId()+".*;");
             }
        }

        ArrayList<Packages> packages = new ArrayList<Packages>();
        for (Models models : developments.getModels()){

             for (GroupIds groupId : models.getGroupIds()){

                 Set<Entidad> entidades = new HashSet<Entidad>(0);
                 for (Entities entity : groupId.getEntities()){

                      Entidad entidad = new Entidad(entity.getName());

                      for (Attributes attribute : entity.getAttributes()) {

line(entidad.getName()+":"+attribute.getName());

                           Atributos atributos = new Atributos(attribute.getName(), attribute.getAttributesTypes().getType());

                           String annotations = "";

                           AttributesProperties properties = new AttributesProperties();
                           if (attribute.getNullable() & attribute.getSingle()){
                              properties = findAttributesProperties("NullUnique1");
                              annotations += "    "+properties.getValue();
                           }
                           if (attribute.getNullable() & !attribute.getSingle()){
                              properties = findAttributesProperties("NullUnique2");
                              annotations += "    "+properties.getValue();
                           }
                           if (!attribute.getNullable() & attribute.getSingle()){
                              properties = findAttributesProperties("NullUnique3");
                              annotations += "    "+properties.getValue();
                           }
                           if (!attribute.getNullable() & !attribute.getSingle()){
                              properties = findAttributesProperties("NullUnique4");
                              annotations += "    "+properties.getValue();
                           }

                           Set<AttributesProperties> attributesProperties = attribute.getAttributesTypes().getAttributesProperties();
                           if(attributesProperties.size() > 0){
                              annotations += "\n";
                           }

                           int i=0;
                           for (AttributesProperties attributeProperties : attributesProperties ){
                               annotations += "    "+attributeProperties.getValue();
                               if (++i < attributesProperties.size()){
                                  annotations += "\n";
                               }
                               for (Imports importss : attributeProperties.getImports() ){
                                   imports.add(importss.getName());
                               } // for: attributeProperties.getImports()
                           } // for: attributesProperties

                           atributos.setAnnotations(annotations);
                           entidad.addAtributo(atributos);

                      } // for: entity.getAttributes()

                      for (Relationships relationships : entity.getFrom()) {

                          switch (relationships.getCardinalities().getName()) {

                              case "Uno a Uno Unidireccional No.1":
                                   // Pendiente
                                   break;

                              case "Uno a Uno Bidirecccional No.2":
                                   // Pendiente
                                   break;

                              case "Muchos a Uno Unidireccional No.3":
                                   entidad.addRelations(new Relation(relationships.getFrom().getName(),
                                                                     relationships.getTo().getName(),
                                                                     relationships.getCardinalities().getCardinality(),
                                                                     relationships.getName(),true));
                                   break;

                              case "Uno a Muchos Unidireccional No.4":
                                   entidad.addRelations(new Relation(relationships.getFrom().getName(),
                                                                     relationships.getTo().getName(),
                                                                     relationships.getCardinalities().getCardinality(),
                                                                     relationships.getName(),true));
                                   break;


                              case "Uno a Muchos Bidirecccional No.5":
                                   entidad.addRelations(new Relation(relationships.getFrom().getName(),
                                                                     relationships.getTo().getName(),
                                                                     relationships.getCardinalities().getCardinality(),
                                                                     relationships.getName(),true));
                                   break;

                              case "Muchos a Muchos Unidireccional No.6":
                                   entidad.addRelations(new Relation(relationships.getFrom().getName(),
                                                                     relationships.getTo().getName(),
                                                                     relationships.getCardinalities().getCardinality(),
                                                                     relationships.getName(),true));
                                   break;

                              case "Muchos a Muchos Bidirecccional No.7":
                                   entidad.addRelations(new Relation(relationships.getFrom().getName(),
                                                                     relationships.getTo().getName(),
                                                                     relationships.getCardinalities().getCardinality(),
                                                                     relationships.getName(),true));
                                   break;


                          } // switch

                      } // for: entity.getFrom()

                      for (Relationships relationships : entity.getTo()) {

                          switch (relationships.getCardinalities().getName()) {

                              case "Uno a Uno Unidireccional No.1":
                                   // Pendiente
                                   break;

                              case "Uno a Uno Bidirecccional No.2":
                                   // Pendiente
                                   break;

                              case "Muchos a Uno Unidireccional No.3":
                                   // Pasa por ser Unidireccional
                                   break;

                              case "Uno a Muchos Unidireccional No.4":
                                   // Pasa por ser Unidireccional
                                   break;

                              case "Uno a Muchos Bidirecccional No.5":
                                   entidad.addRelations(new Relation(relationships.getTo().getName(),
                                                                     relationships.getFrom().getName(),
                                                                     "*..1",
                                                                     relationships.getName(),false));
                                   break;

                              case "Muchos a Muchos Unidireccional No.6":
                                   // Pasa por ser Unidireccional
                                   break;

                              case "Muchos a Muchos Bidirecccional No.7":
                                    entidad.addRelations(new Relation(relationships.getTo().getName(),
                                                                      relationships.getFrom().getName(),
                                                                      relationships.getCardinalities().getCardinality(),
                                                                      relationships.getName(),false));
                                    break;

                          } // switch

                      } // for: entity.getTo()

                      entidad.setGroupId(groupId.getGroupId());
                      entidades.add(entidad);

                 } // for: groupId.getEntities()

                 packages.add(new Packages(groupId.getGroupId(),entidades));

             } // models.getGroupIds()

        } // developments.getModels()

        saveFile("\\docs", "Prueba.txt");

        ModelsGen modelsGen = new ModelsGen(developments.getGroupId(),developments.getArtifactId());
        modelsGen.setImports(imports);
        modelsGen.setPackages(packages);
        modelsGen.WarH2();
        war(developments);


    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    } // data()

    public AttributesProperties findAttributesProperties(String name) {

        AttributesProperties attributesProperties = new AttributesProperties();
        List<AttributesProperties> results = em.createQuery(QUERYA).setParameter("custName", name).getResultList();

        if (!results.isEmpty()) {
           attributesProperties = results.get(0);
        }
        return attributesProperties;
    }

    public void war(Developments developments) throws IOException {
    try {

        clearFileTxt();
        int i=0;
        int j=0;
        LinkedHashSet<String> imports = new LinkedHashSet<String>();

line("package "+developments.getGroupId()+".setup;\n");

line("import "+developments.getGroupId()+".beans.*;");
line("import "+developments.getGroupId()+".utils.*;\n");

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

line("@Named(\""+developments.getArtifactId()+"Setup\")");
line("public class "+developments.getArtifactId()+"Setup {\n");

line("    @PersistenceContext(unitName = \"naifgPU-JTA\")");
line("    private EntityManager em;\n");

line("    FindBean findBean = new FindBean();\n");

line("    private static final Logger log = Logger.getLogger("+developments.getArtifactId()+"Setup.class.getName());\n");

line("    public void data() {\n");

line("//      ---------------------- GroupIds ------------------------\n");


    for (Models models : developments.getModels()) {

        for (GroupIds groupId : models.getGroupIds()) {

line("        GroupIds groupIds"+String.valueOf(++i)+" = new GroupIds();");
line("        groupIds"+String.valueOf(i)+".setGroupId(\""+groupId.getGroupId()+"\");");
line("        groupIds"+String.valueOf(i)+".setName(\""+groupId.getName()+"\");");
line("        em.persist(groupIds"+String.valueOf(i)+");");
line("        em.flush();\n");

        } // models.getGroupIds()

    } // developments.getModels()

line("//      ---------------------- Models ------------------------\n");

    for (Models models : developments.getModels()) {

line("        Models models = new Models();");
line("        models.setGroupId(\""+models.getGroupId()+"."+models.getArtifactId()+"\");");
line("        models.setArtifactId(\""+models.getArtifactId()+"\");");
line("        models.setVersion(\""+models.getVersion()+"\");");
line("        models.setName(\""+models.getArtifactId()+"\");\n");

line("        Set<GroupIds> modelsGroupIds = new HashSet<GroupIds>();\n");

        i=0;
        for (GroupIds groupId : models.getGroupIds()) {

line("        GroupIds modelsGroupId"+String.valueOf(++i)+" = findBean.groupGroupIds(\""+groupId.getGroupId()+"\",em);");
line("        modelsGroupIds.add(modelsGroupId"+String.valueOf(i)+");\n");

        } // models.getGroupIds()

line("        models.setGroupIds(modelsGroupIds);\n");

line("        em.persist(models);");
line("        em.flush();\n");

    } // developments.getModels()

line("//      ---------------------- Developments ------------------------\n");

line("        Developments dev = new Developments();");
line("        dev.setGroupId(\""+developments.getGroupId()+"\");");
line("        dev.setArtifactId(\""+developments.getArtifactId()+"\");");
line("        dev.setVersion(\""+developments.getVersion()+"\");");
line("        dev.setCode(\""+developments.getCode()+"\");");
line("        dev.setName(\""+developments.getName()+"\");");
line("        Set<Models> models1 = new HashSet<Models>();");
line("        Models model1 = findBean.artifactIdModels(\""+developments.getArtifactId()+"\",em);");
line("        models1.add(model1);");
line("        dev.setModels(models1);");
line("        em.persist(dev);");
line("        em.flush();\n");

line("//      ---------------------- Entities ------------------------\n");

    i=0;
    j=0;
    for (Models models : developments.getModels()) {

        for (GroupIds groupId : models.getGroupIds()) {

            for (Entities entities: groupId.getEntities()) {

line("        Entities entities"+String.valueOf(++i)+" = new Entities();");
line("        entities"+String.valueOf(i)+".setName(\""+entities.getName()+"\");");
line("//      ...................... "+groupId.getGroupId()+" ........................");
line("        GroupIds groupId"+String.valueOf(++j)+" = new GroupIds();");
line("        groupId"+String.valueOf(j)+" = findBean.groupIdGroupIds(\""+groupId.getGroupId()+"\",em);");
line("        entities"+String.valueOf(i)+".setGroupIds(groupId"+String.valueOf(j)+");");
line("        em.persist(entities"+String.valueOf(i)+");");
line("        em.flush();\n");

line("//      ---------------------- Attributes ------------------------\n");

              for (Attributes attributes: entities.getAttributes()) {

line("        Attributes attributes"+String.valueOf(++i)+" = new Attributes();");
line("        attributes"+String.valueOf(i)+".setName(\""+attributes.getName()+"\");");
line("        attributes"+String.valueOf(i)+".setNullable("+attributes.getNullable()+");");
line("        attributes"+String.valueOf(i)+".setSingle("+attributes.getSingle()+");");
line("//      ...................... "+entities.getName()+" ........................");
line("        Entities entity"+String.valueOf(++j)+" = new Entities();");
line("        entity"+String.valueOf(j)+" = findBean.nameEntities(\""+entities.getName()+"\",em);");
line("        attributes"+String.valueOf(i)+".setEntities(entity"+String.valueOf(j)+");");
line("//      ...................... "+attributes.getAttributesTypes().getName()+" ........................");
line("        AttributesTypes attributesTypes"+String.valueOf(++j)+" = new AttributesTypes();");
line("        attributesTypes"+String.valueOf(j)+" = findBean.nameAttributesTypes(\""+attributes.getAttributesTypes().getName()+"\",em);");
line("        attributes"+String.valueOf(i)+".setAttributesTypes(attributesTypes"+String.valueOf(j)+");");
line("        em.persist(attributes"+String.valueOf(i)+");");
line("        em.flush();\n");

              }


            } // groupId.getEntities()

        } // models.getGroupIds()

    } // developments.getModels()
    
line("//      ---------------------- Relationships ------------------------\n");

    


    saveFile("\\docs.h2.war."+developments.getArtifactId(),developments.getArtifactId()+"Setup.java");

    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    } // war



} // DevelopmentsGen

