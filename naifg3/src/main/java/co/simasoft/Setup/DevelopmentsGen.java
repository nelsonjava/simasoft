/*
line(Integer.toString(developments.getModels().size()));
*/

package co.simasoft.setup;

import co.simasoft.gen.jpa.*;

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

    private int i=0;
    private int j=0;
    private int k=0;
    private int y=0;

    @PersistenceContext(unitName = "naifgPU-JTA")
    private EntityManager em;
    
    FindBean findBean = new FindBean();

    public void data(Developments developments) throws IOException {
    try {

        clearFileTxt();

        LinkedHashSet<String> imports = new LinkedHashSet<String>();
        ArrayList<Entidad> entidades = new ArrayList<Entidad>(0);

        System.out.println("Hello World!" + developments.getArtifactId());

        for (Models models : developments.getModels()){

             for (ModelsGroupIds modelsGroupIds : models.getModelsGroupIds()){
                 imports.add("import "+modelsGroupIds.getGroupIds().getGroupId()+".*;");
             } // for: models.getModelsGroupIds()

        } // for: developments.getModels()

        ArrayList<Packages> packages = new ArrayList<Packages>();

        for (Models models : developments.getModels()){

             for (ModelsGroupIds modelsGroupIds : models.getModelsGroupIds()){

//                 ArrayList<Entidad> entidades = new ArrayList<Entidad>(0);
                 for (Entities entity : modelsGroupIds.getGroupIds().getEntities()){

                      Entidad entidad = new Entidad(entity.getName());

                      for (Attributes attribute : entity.getAttributes()) {

                           Atributos atributos = new Atributos();
                           atributos.setField(attribute.getName());
                           atributos.setDescription(attribute.getDescription());
                           atributos.setType(attribute.getAttributesTypes().getType());
                           atributos.setLength(attribute.getLength());
                           atributos.setPrecision(attribute.getPrecision());
                           atributos.setNulo(attribute.getIsNullable());
                           atributos.setUnique(attribute.getIsUnique());
                           atributos.setIsSimplified(attribute.getIsSimplified());
                           atributos.setIsCreate(attribute.getIsCreate());
                           atributos.setIsSearch(attribute.getIsSearch());
                           atributos.setIsView(attribute.getIsView());
                           atributos.setIsViewColumn(attribute.getIsViewColumn());
                           if (Utils.isEmpty(attribute.getIsViewRelation())){
                              atributos.setIsViewRelation(false);
                           }
                           else{
                               atributos.setIsViewRelation(attribute.getIsViewRelation());
                           }

                           String annotations = "";

                           AttributesProperties properties = new AttributesProperties();
                           if (attribute.getIsNullable() & attribute.getIsUnique()){
                              properties = findAttributesProperties("NullUnique1");
                              annotations += "    "+properties.getValue();
                           }
                           if (attribute.getIsNullable() & !attribute.getIsUnique()){
                              properties = findAttributesProperties("NullUnique2");
                              annotations += "    "+properties.getValue();
                           }
                           if (!attribute.getIsNullable() & attribute.getIsUnique()){
                              properties = findAttributesProperties("NullUnique3");
                              annotations += "    "+properties.getValue();
                           }
                           if (!attribute.getIsNullable() & !attribute.getIsUnique()){
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
                                   imports.add("import javax.persistence.OneToOne;");
                                   // Pendiente
                                   break;

                              case "Uno a Uno Bidirecccional No.2":
                                   imports.add("import javax.persistence.OneToOne;");
                                   // Pendiente
                                   break;

                              case "Muchos a Uno Unidireccional No.3":
                                   entidad.addRelations(new Relation(relationships.getFrom().getName(),
                                                                     relationships.getTo().getName(),
                                                                     relationships.getCardinalities().getCardinality(),
                                                                     relationships.getCardinalities().getName(),
                                                                     relationships.getName(),true));
                                   imports.add("import javax.persistence.ManyToOne;");
                                   break;

                              case "Uno a Muchos Unidireccional No.4":
                                   entidad.addRelations(new Relation(relationships.getFrom().getName(),
                                                                     relationships.getTo().getName(),
                                                                     relationships.getCardinalities().getCardinality(),
                                                                     relationships.getCardinalities().getName(),
                                                                     relationships.getName(),true));
                                   imports.add("import javax.persistence.ManyToOne;");
                                   break;


                              case "Uno a Muchos Bidirecccional No.5":
                                   entidad.addRelations(new Relation(relationships.getFrom().getName(),
                                                                     relationships.getTo().getName(),
                                                                     relationships.getCardinalities().getCardinality(),
                                                                     relationships.getCardinalities().getName(),
                                                                     relationships.getName(),true));
                                   imports.add("import javax.persistence.OneToMany;");
                                   imports.add("import javax.persistence.ManyToOne;");
                                   break;

                              case "Muchos a Muchos Unidireccional No.6":
                                   entidad.addRelations(new Relation(relationships.getFrom().getName(),
                                                                     relationships.getTo().getName(),
                                                                     relationships.getCardinalities().getCardinality(),
                                                                     relationships.getCardinalities().getName(),
                                                                     relationships.getName(),true));
                                   imports.add("import javax.persistence.ManyToMany;");
                                   break;

                              case "Muchos a Muchos Bidirecccional No.7":
                                   entidad.addRelations(new Relation(relationships.getFrom().getName(),
                                                                     relationships.getTo().getName(),
                                                                     relationships.getCardinalities().getCardinality(),
                                                                     relationships.getCardinalities().getName(),
                                                                     relationships.getName(),true));
                                   imports.add("import javax.persistence.ManyToMany;");
                                   break;


                          } // switch

                      } // for: entity.getFrom()


                      for (Relationships relationships : entity.getTo()) {

                          if (!isRelationModel(relationships.getFrom().getGroupIds().getGroupId(),
                                              relationships.getTo().getGroupIds().getGroupId(),
                                              models.getGroupId())){

                             if (modelsGroupIds.getIsIsolated()){
                                continue;
                             }
                          }

/*
line("************");
line("     "+relationships.getTo().getGroupIds().getGroupId());
line("to  :"+relationships.getTo().getGroupIds().getGroupId()+"."+relationships.getTo().getName());
line("from:"+relationships.getFrom().getGroupIds().getGroupId()+"."+relationships.getFrom().getName());
line(".***********");
*/


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

                                   entidad.addRelations(new Relation(relationships.getFrom().getName(),
                                                                     relationships.getTo().getName(),
                                                                     "*..1",
                                                                     "Uno a Muchos Bidirecccional No.5",
                                                                     relationships.getName(),false));


/*
                                   entidad.addRelations(new Relation(relationships.getTo().getName(),
                                                                     relationships.getFrom().getName(),
                                                                     "*..1",
                                                                     "Uno a Muchos Bidirecccional No.5",
                                                                     relationships.getName(),false));
*/

                                   break;

                              case "Muchos a Muchos Unidireccional No.6":
                                   // Pasa por ser Unidireccional
                                   break;

                              case "Muchos a Muchos Bidirecccional No.7":

                                    entidad.addRelations(new Relation(relationships.getFrom().getName(),
                                                                      relationships.getTo().getName(),
                                                                      relationships.getCardinalities().getCardinality(),
                                                                      relationships.getCardinalities().getName(),
                                                                      relationships.getName(),false));

/*
                                    entidad.addRelations(new Relation(relationships.getTo().getName(),
                                                                      relationships.getFrom().getName(),
                                                                      relationships.getCardinalities().getCardinality(),
                                                                      relationships.getCardinalities().getName(),
                                                                      relationships.getName(),false));
*/

                                    break;

                          } // switch

                      } // for: entity.getTo()

                      entidad.setGroupId(modelsGroupIds.getGroupIds().getGroupId());
                      entidades.add(entidad);

                 } // for: modelsGroupIds.getGroupIds().getEntities()

/*
for (Entidad entidad : entidades) {
    EntityH2 entityH2 = new EntityH2(modelsGroupIds.getGroupIds().getGroupId(),modelsGroupIds.getGroupIds().getGroupId(),entidad,imports);
    Utils.fileMake("\\docs.h2.war."+developments.getArtifactId()+".src.main.java."+modelsGroupIds.getGroupIds().getGroupId(),entidad.getName()+".java", entityH2);
    line(entidad.getName());
} // for: groupIds.getEntities()
*/


                 packages.add(new Packages(modelsGroupIds.getGroupIds().getGroupId(),entidades));

             } // for: models.getModelsGroupIds()

        } // for: developments.getModels()

        saveFile("\\docs", "Prueba.txt");

        ModelsGen modelsGen = new ModelsGen(developments.getGroupId(),developments.getArtifactId());
        modelsGen.setImports(imports);
        modelsGen.setPackages(packages);
        modelsGen.setEntities(entidades);
        modelsGen.WarH2();
        modelsGen.jdocbook();
        war(developments);
        jsonNaifg(developments);
    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    } // data()

    public boolean isRelationModel(String groupIdFrom,String groupIdTo,String groupIdModel) {

/*
line("************");
line("     "+relationships.getTo().getGroupIds().getGroupId());
line("to  :"+relationships.getTo().getGroupIds().getGroupId()+"."+relationships.getTo().getName());
line("from:"+relationships.getFrom().getGroupIds().getGroupId()+"."+relationships.getFrom().getName());
line(".***********");
*/

        if (groupIdFrom.equals(groupIdTo)){
           return true;
        }
        else{
            if (groupIdFrom.indexOf (groupIdModel) != -1){ // Si se encuentra la cadena
               return true;
            }
            else{
               return false;
            }
        }

    } // isRelationModel();

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
        i=0;
        j=0;
        LinkedHashSet<String> imports = new LinkedHashSet<String>();

line("package "+developments.getGroupId()+".setup;\n");

line("import "+developments.getGroupId()+".beans.*;");
line("import "+developments.getGroupId()+".utils.*;");
line("import co.simasoft.models.dev.naifg.*;");
line("import co.simasoft.models.dev.naifg.dependencies.*;\n");

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

        for (ModelsGroupIds modelsGroupIds : models.getModelsGroupIds()){

            if (modelsGroupIds.getGroupIds().getGroupId().indexOf (models.getGroupId()) != -1){ // Si se encuentra la cadena
            }
            else{
               continue; // Descarta el modelo externo
            }

line("        GroupIds groupIds"+String.valueOf(++i)+" = new GroupIds();");
line("        groupIds"+String.valueOf(i)+".setArtifactId(\""+modelsGroupIds.getGroupIds().getArtifactId()+"\");");
line("        groupIds"+String.valueOf(i)+".setGroupId(\""+modelsGroupIds.getGroupIds().getGroupId()+"\");");
line("        groupIds"+String.valueOf(i)+".setVersion(\""+modelsGroupIds.getGroupIds().getVersion()+"\");");
line("        groupIds"+String.valueOf(i)+".setCode(\""+modelsGroupIds.getGroupIds().getCode()+"\");");
// line("        groupIds"+String.valueOf(i)+".setDate("+modelsGroupIds.getGroupIds().getDate()+");");
line("        em.persist(groupIds"+String.valueOf(i)+");");
line("        em.flush();\n");

        } // for: models.getModelsGroupIds()

    } // for: developments.getModels()

line("//      ---------------------- Models ------------------------\n");

    for (Models models : developments.getModels()) {

line("        Models models = new Models();");
line("        models.setArtifactId(\""+models.getArtifactId()+"\");");
line("        models.setGroupId(\""+models.getGroupId()+"\");");
line("        models.setVersion(\""+models.getVersion()+"\");");
line("        models.setCode(\""+models.getCode()+"\");");
// line("        models.setDate("+models.getDate()+");");
line("        em.persist(models);");
line("        em.flush();\n");

    } // for: developments.getModels()

line("//      ---------------------- ModelsGroupIds ----------------------\n");

    i=0;
    for (Models models : developments.getModels()) {

        for(ModelsGroupIds modelsGroupIds : models.getModelsGroupIds()){

line("        ModelsGroupIds modelsGroupIds"+String.valueOf(++i)+" = new ModelsGroupIds();");
line("        Models modelss"+String.valueOf(i)+" = findBean.artifactIdModels(\""+modelsGroupIds.getModels().getArtifactId()+"\",em);");
line("        GroupIds groupIdd"+String.valueOf(i)+" = findBean.artifactIdGroupIds(\""+modelsGroupIds.getGroupIds().getArtifactId()+"\",em);");
line("        modelsGroupIds"+String.valueOf(i)+".setModels(modelss"+String.valueOf(i)+");");
line("        modelsGroupIds"+String.valueOf(i)+".setGroupIds(groupIdd"+String.valueOf(i)+");");
line("        modelsGroupIds"+String.valueOf(i)+".setIsSingle("+modelsGroupIds.getIsIsolated()+");");
line("        modelsGroupIds"+String.valueOf(i)+".setIsSimplified("+modelsGroupIds.getIsSimplified()+");");
line("        em.persist(modelsGroupIds"+String.valueOf(i)+");");
line("        em.flush();\n");

        } // for: models.getModelsGroupIds()

    } // for: developments.getModels()

line("//      ---------------------- Developments ------------------------\n");

line("        Developments dev = new Developments();");
line("        dev.setGroupId(\""+developments.getGroupId()+"\");");
line("        dev.setArtifactId(\""+developments.getArtifactId()+"\");");
line("        dev.setVersion(\""+developments.getVersion()+"\");");
line("        dev.setCode(\""+developments.getCode()+"\");");
line("        Set<Models> models1 = new HashSet<Models>();");
line("        Models model1 = findBean.artifactIdModels(\""+developments.getArtifactId()+"\",em);");
line("        models1.add(model1);");
line("        dev.setModels(models1);");
// line("        dev.setObservations(\""+developments.getObservations()+"\");");
line("        dev.setVersion(\""+developments.getVersion()+"\");");
line("        dev.setCode(\""+developments.getCode()+"\");");
// line("        dev.setDate("+developments.getDate()+");");
line("        em.persist(dev);");
line("        em.flush();\n");

line("//      ---------------------- Entities ------------------------\n");

    i=0;
    j=0;
    for (Models models : developments.getModels()) {

        for (ModelsGroupIds modelsGroupIds : models.getModelsGroupIds()){

            if (modelsGroupIds.getGroupIds().getGroupId().indexOf (models.getGroupId()) != -1){ // Si se encuentra la cadena
            }
            else{
               continue; // Descarta el modelo externo
            }

            for (Entities entities : modelsGroupIds.getGroupIds().getEntities()){

line("        Entities entities"+String.valueOf(++i)+" = new Entities();");
line("        entities"+String.valueOf(i)+".setName(\""+entities.getName()+"\");");
line("//      ...................... "+modelsGroupIds.getGroupIds().getGroupId()+" ........................");
line("        GroupIds groupId"+String.valueOf(++j)+" = new GroupIds();");
line("        groupId"+String.valueOf(j)+" = findBean.groupIdGroupIds(\""+modelsGroupIds.getGroupIds().getGroupId()+"\",em);");
line("        entities"+String.valueOf(i)+".setGroupIds(groupId"+String.valueOf(j)+");");
line("        em.persist(entities"+String.valueOf(i)+");");
line("        em.flush();\n");

line("//      ---------------------- Attributes ------------------------\n");

              for (Attributes attributes: entities.getAttributes()) {

line("        Attributes attributes"+String.valueOf(++i)+" = new Attributes();");
line("        attributes"+String.valueOf(i)+".setName(\""+attributes.getName()+"\");");
line("        attributes"+String.valueOf(i)+".setIsNullable("+attributes.getIsNullable()+");");
line("        attributes"+String.valueOf(i)+".setIsUnique("+attributes.getIsUnique()+");");
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

              } // for: entities.getAttributes()

            } // for: modelsGroupIds.getGroupIds().getEntities()

        } // for: models.getModelsGroupIds()

    } // for: developments.getModels()

line("//      ---------------------- Relationships ------------------------\n");

line("/*");
    i=0;
    for (Models models : developments.getModels()) {

        for (ModelsGroupIds modelsGroupIds : models.getModelsGroupIds()){

            for (Entities entities : modelsGroupIds.getGroupIds().getEntities()){

                for (Relationships relationships: entities.getFrom() ) {

                    switch (relationships.getCardinalities().getCardinality()) {
                        case "1..1":
                        case "1..*":
                        case "*..*":
line(". "+relationships.getFrom().getName()+" . "+relationships.getCardinalities().getCardinality()+" "+relationships.getTo().getName());
                    } // switch

                } // for: entities.getFrom()

            } // for: modelsGroupIds.getGroupIds().getEntities()

        } // for: models.getModelsGroupIds()

    } // for: developments.getModels()

line("*/");

    i=0;
    for (Models models : developments.getModels()) {

        for (ModelsGroupIds modelsGroupIds : models.getModelsGroupIds()){

            for (Entities entities : modelsGroupIds.getGroupIds().getEntities()){

                for (Relationships relationships: entities.getFrom() ) {

                    switch (relationships.getCardinalities().getCardinality()) {
                        case "1..1":
                        case "1..*":
                        case "*..*":
line("        Relationships relationships"+String.valueOf(++i)+" = new Relationships();");
line("        relationships"+String.valueOf(i)+".setIsOptionality("+relationships.getIsOptionality()+");");
line("        relationships"+String.valueOf(i)+".setIsEmbedded("+relationships.getIsEmbedded()+");");
                          if(relationships.getName() == null || relationships.getName().isEmpty() ){
line("        relationships"+String.valueOf(i)+".setName(\"\");");
                          }
                          else{
line("        relationships"+String.valueOf(i)+".setName(\""+relationships.getName()+"\");");
                          }
line("//      ...................... "+relationships.getFrom().getName()+" ........................");
line("        Entities entities"+String.valueOf(++j)+" = new Entities();");
line("        entities"+String.valueOf(j)+" = findBean.nameEntities(\""+relationships.getFrom().getName()+"\",em);");
line("        relationships"+String.valueOf(i)+".setFrom(entities"+String.valueOf(j)+");");
line("//      ...................... "+relationships.getTo().getName()+" ........................");
line("        Entities entities"+String.valueOf(++j)+" = new Entities();");
line("        entities"+String.valueOf(j)+" = findBean.nameEntities(\""+relationships.getTo().getName()+"\",em);");
line("        relationships"+String.valueOf(i)+".setTo(entities"+String.valueOf(j)+");");
line("//      ...................... "+Cardinaly(relationships.getCardinalities().getCardinality())+" ........................");
line("        Cardinalities cardinalities"+String.valueOf(++j)+" = new Cardinalities();");
line("        cardinalities"+String.valueOf(j)+" = findBean.nameCardinalities(\""+Cardinaly(relationships.getCardinalities().getCardinality())+"\",em);");
line("        relationships"+String.valueOf(i)+".setCardinalities(cardinalities"+String.valueOf(j)+");");
line("        em.persist(relationships"+String.valueOf(i)+");");
line("        em.flush();\n");
                    } // switch


                } // for: entities.getFrom()

            } // for: modelsGroupIds.getGroupIds().getEntities()

        } // for: models.getModelsGroupIds()

    } // for: developments.getModels()

line("    } // data()\n");

line("} // "+developments.getArtifactId()+"Setup");

    saveFile("\\docs.h2.war."+developments.getArtifactId(),developments.getArtifactId()+"Setup.java");

    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    } // war

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

    public void jdocbook(Developments developments) throws IOException {
    try {

    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    } // jdocbook

    public void jsonRead(Developments developments) throws IOException {
    try {

    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    } // jdocbook

    public void jsonNaifg(Developments developments) throws IOException {
    try {

        clearFileTxt();
        LinkedHashSet<String> imports = new LinkedHashSet<String>();

line("{");
line("  \"GroupIds\": [");

    i=1;
    for (Models models : developments.getModels()) {

        j = 1;
        for (ModelsGroupIds modelsGroupIds : models.getModelsGroupIds()){
            if (modelsGroupIds.getGroupIds().getGroupId().indexOf (models.getGroupId()) != -1){ // Si se encuentra la cadena
            }
            else{
               j++;
               continue; // Descarta el modelo externo
            }
line("    {");
line("      \"artifactId\": \""+modelsGroupIds.getGroupIds().getArtifactId()+"\",");
line("      \"groupId\": \""+modelsGroupIds.getGroupIds().getGroupId()+"\",");
line("      \"version\": \""+modelsGroupIds.getGroupIds().getVersion()+"\",");
line("      \"code\": \""+modelsGroupIds.getGroupIds().getCode()+"\"");
          if (i == developments.getModels().size() && j == models.getModelsGroupIds().size() ){
line("    }");
          }
          else{
line("    },");
          }

/*
line("i="+String.valueOf(i)+" size="+String.valueOf(developments.getModels().size())+
     " : "+
     "j="+String.valueOf(j)+" size="+String.valueOf(models.getModelsGroupIds().size()));
*/

            j++;
        } // for: models.getModelsGroupIds()
        i++;
    } // for: developments.getModels()
line("  ],");

line("  \"Models\": [");
     i=1;
     for (Models models : developments.getModels()) {
line("    {");
line("      \"artifactId\": \""+models.getArtifactId()+"\",");
line("      \"groupId\": \""+models.getGroupId()+"\",");
line("      \"version\": \""+models.getVersion()+"\",");
line("      \"code\": \""+models.getCode()+"\"");
          if (i == developments.getModels().size()){
line("    }");
          }
          else{
line("    },");
          }
          i++;
     } // for: developments.getModels()
line("  ],");

/*
line("i="+String.valueOf(i)+" size="+String.valueOf(developments.getModels().size()));
*/

line("  \"ModelsGroupIds\": [");
    i=1;
    for (Models models : developments.getModels()) {

        j = 1;
        for(ModelsGroupIds modelsGroupIds : models.getModelsGroupIds()){

line("    {");
line("      \"isSimplified\": "+modelsGroupIds.getIsSimplified()+",");
line("      \"isIsolated\": "+modelsGroupIds.getIsIsolated()+",");
line("      \"GroupIds.groupId\": \""+modelsGroupIds.getGroupIds().getArtifactId()+"\",");
line("      \"Models.artifactId\": \""+modelsGroupIds.getModels().getArtifactId()+"\"");
          if (i == developments.getModels().size() && j == models.getModelsGroupIds().size() ){
line("    }");
          }
          else{
line("    },");
          }

/*
line("i="+String.valueOf(i)+" size="+String.valueOf(developments.getModels().size())+
     " : "+
     "j="+String.valueOf(j)+" size="+String.valueOf(models.getModelsGroupIds().size()));
*/

          j++;
        } // for: models.getModelsGroupIds()
        i++;
    } // for: developments.getModels()
line("  ],");

line("  \"Developments\": [");
line("    {");
line("      \"artifactId\": \""+developments.getArtifactId()+"\",");
line("      \"groupId\": \""+developments.getGroupId()+"\",");
line("      \"version\": \""+developments.getVersion()+"\",");
line("      \"code\": \""+developments.getCode()+"\",");
line("      \"Models.artifactId\": \""+developments.getArtifactId()+"\"");
line("    }");
line("  ],");

line("  \"Entities\": [");
    i=1;
    for (Models models : developments.getModels()) {

        j=1;
        for (ModelsGroupIds modelsGroupIds : models.getModelsGroupIds()){

            if (modelsGroupIds.getGroupIds().getGroupId().indexOf (models.getGroupId()) != -1){ // Si se encuentra la cadena
            }
            else{
               j++;
               continue; // Descarta el modelo externo
            }

            k=1;
            for (Entities entities : modelsGroupIds.getGroupIds().getEntities()){

line("    {");
line("      \"name\": \""+entities.getName()+"\",");
line("      \"groupIds\": \""+modelsGroupIds.getGroupIds().getGroupId()+"\"");
          if (i == developments.getModels().size() && j == models.getModelsGroupIds().size() && k == modelsGroupIds.getGroupIds().getEntities().size() ){
line("    }");
          }
          else{
line("    },");
          }

/*
line("i="+String.valueOf(i)+" size="+String.valueOf(developments.getModels().size())+
     " : "+
     "j="+String.valueOf(j)+" size="+String.valueOf(models.getModelsGroupIds().size())+
     " : "+
     "k="+String.valueOf(k)+" size="+String.valueOf(modelsGroupIds.getGroupIds().getEntities().size()));
*/

            k++;
            } // for: modelsGroupIds.getGroupIds().getEntities()
            j++;
        } // for: models.getModelsGroupIds()
        i++;
    } // for: developments.getModels()
line("  ],");


line("  \"Attributes\": [");
    i=1;
    for (Models models : developments.getModels()) {

        j = 1;
        for (ModelsGroupIds modelsGroupIds : models.getModelsGroupIds()){

            if (modelsGroupIds.getGroupIds().getGroupId().indexOf (models.getGroupId()) != -1){ // Si se encuentra la cadena
            }
            else{
               j++;
               continue; // Descarta el modelo externo
            }

            k=1;
            for (Entities entities : modelsGroupIds.getGroupIds().getEntities()){

                y=1;
                for (Attributes attributes: entities.getAttributes()) {

line("    {");
line("      \"entity\": \""+entities.getName()+"\",");
line("      \"name\": \""+attributes.getName()+"\",");
line("      \"isNullable\": "+attributes.getIsNullable()+",");
line("      \"isUnique\": "+attributes.getIsUnique()+",");
line("      \"AttributesTypes\": \""+attributes.getAttributesTypes().getName()+"\"");
          if (i == developments.getModels().size() && j == models.getModelsGroupIds().size() && k == modelsGroupIds.getGroupIds().getEntities().size() && y == entities.getAttributes().size() ){
line("    }");
          }
          else{
line("    },");
          }

/*
line("i="+String.valueOf(i)+" size="+String.valueOf(developments.getModels().size())+
     " : "+
     "j="+String.valueOf(j)+" size="+String.valueOf(models.getModelsGroupIds().size())+
     " : "+
     "k="+String.valueOf(k)+" size="+String.valueOf(modelsGroupIds.getGroupIds().getEntities().size())+
     " : "+
     "y="+String.valueOf(y)+" size="+String.valueOf(entities.getAttributes().size()));
*/

                y++;
                } // for: entities.getAttributes()
                k++;
            } // for: modelsGroupIds.getGroupIds().getEntities()
            j++;
        } // for: models.getModelsGroupIds()
        i++;
    } // for: developments.getModels()
line("  ],");

line("  \"Relationships\": [");
    i=1;
    for (Models models : developments.getModels()) {

        j=1;
        for (ModelsGroupIds modelsGroupIds : models.getModelsGroupIds()){

            k=1;
            for (Entities entities : modelsGroupIds.getGroupIds().getEntities()){

                y=1;
                for (Relationships relationships: entities.getFrom() ) {

                    switch (relationships.getCardinalities().getCardinality()) {
                        case "1..1":
                        case "1..*":
                        case "*..*":

line("    {");
line("      \"From\": \""+relationships.getFrom().getName()+"\",");
line("      \"To\": \""+relationships.getTo().getName()+"\",");
line("      \"name\": \""+relationships.getName()+"\",");
line("      \"isOptionality\": "+relationships.getIsOptionality()+",");
line("      \"isEmbedded\": "+relationships.getIsEmbedded()+",");
line("      \"isSimplified\": "+relationships.getIsSimplified()+",");
line("      \"Cardinalities\": \""+Cardinaly(relationships.getCardinalities().getCardinality())+"\"");
          if (i == developments.getModels().size() && j == models.getModelsGroupIds().size() && k == modelsGroupIds.getGroupIds().getEntities().size() && y == entities.getFrom().size() ){
line("    }");
          }
          else{
line("    },");
          }

/*
line("i="+String.valueOf(i)+" size="+String.valueOf(developments.getModels().size())+
     " : "+
     "j="+String.valueOf(j)+" size="+String.valueOf(models.getModelsGroupIds().size())+
     " : "+
     "k="+String.valueOf(k)+" size="+String.valueOf(modelsGroupIds.getGroupIds().getEntities().size())+
     " : "+
     "y="+String.valueOf(y)+" size="+String.valueOf(entities.getFrom().size()));
*/


                    } // switch

                   y++;
                } // for: entities.getFrom()
                k++;
            } // for: modelsGroupIds.getGroupIds().getEntities()
            j++;
        } // for: models.getModelsGroupIds()
        i++;
    } // for: developments.getModels()
line("  ]");

line("}");

    saveFile("\\docs.h2.war."+developments.getArtifactId(),developments.getArtifactId()+"Setup.json");

    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    jsonDependencies(developments);

    } // json

    public void jsonDependencies(Developments developments) throws IOException {
    try {

        clearFileTxt();

line("{");

line("  \"Dependencies\": [");
        List<Dependencies> dependencies = findBean.AllDependencies(em);
        i=1;
        for (Dependencies dependency : dependencies) {
line("    {");
line("      \"artifactId\": \""+dependency.getArtifactId()+"\",");
line("      \"groupId\": \""+dependency.getGroupId()+"\",");
line("      \"version\": \""+dependency.getVersion()+"\",");
line("      \"type\": \""+dependency.getType()+"\",");
line("      \"scope\": \""+dependency.getScope()+"\",");
line("      \"maven\": \""+dependency.getMaven()+"\"");
          if (i == dependencies.size()){
line("    }");
          }
          else{
line("    },");
          }
          i++;
        } // for: dependencies
line("  ],");

line("  \"Imports\": [");
        List<Imports> imports = findBean.AllImports(em);
        i=1;
        for (Imports impor : imports) {
line("    {");
line("      \"name\": \""+impor.getName()+"\",");
line("      \"dependencies.artifactId\": \""+impor.getName()+"\"");
// System.out.println(impor.getDependencies().getGroupId());
          if (i == imports.size()){
line("    }");
          }
          else{
line("    },");
          }
          i++;
        } // for:imports
line("  ],");

line("  \"AttributesProperties\": [");
        List<AttributesProperties> attributesProperties = findBean.AllAttributesProperties(em);
        i=1;
        for (AttributesProperties attributesProperty : attributesProperties ){
line("    {");
line("      \"name\": \""+attributesProperty.getName()+"\",");
line("      \"value\": \""+attributesProperty.getValue()+"\"");
          if (i == attributesProperties.size()){
line("    }");
          }
          else{
line("    },");
          }
          i++;
        } // for:
line("  ],");

line("  \"AttributesTypes\": [");
        List<AttributesTypes> attributesTypes = findBean.AllAttributesTypes(em);
        i=1;
        for (AttributesTypes attributesType : attributesTypes ) {

line("    {");
line("      \"name\": \""+attributesType.getName()+"\",");
line("      \"type\": \""+attributesType.getType()+"\",");
line("      \"length\": \""+String.valueOf(attributesType.getLength())+"\",");
line("      \"precision\": \""+String.valueOf(attributesType.getPrecision())+"\",");
line("      \"annotations\": \""+attributesType.getAnnotations()+"\"");
          if (i == attributesTypes.size()){
line("    }");
          }
          else{
line("    },");
          }
          i++;
        } // for: attributesTypes
line("  ]");
line("}");

    saveFile("\\docs.h2.war."+developments.getArtifactId(),"DependenciesSetup.json");

    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    } // json


} // DevelopmentsGen