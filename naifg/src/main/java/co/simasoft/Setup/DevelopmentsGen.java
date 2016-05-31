/*
line(Integer.toString(developments.getModels().size()));
*/

package co.simasoft.setup;

import co.simasoft.gen.jpa.*;
import co.simasoft.gen.war.h2.angular.*;
import co.simasoft.gen.war.h2.jquery.*;
import co.simasoft.gen.war.h2.nodejs.*;
import co.simasoft.gen.war.h2.react.*;
import co.simasoft.gen.war.sqlite.django.*;

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
        ArrayList<String> entitiesNames = EntitiesNames(developments);

        for (String entityName : entitiesNames){
            line(entityName);
        }

        for (Models models : developments.getModels()){

             for (ModelsGroupIds modelsGroupIds : models.getModelsGroupIds()){
                 imports.add("import "+modelsGroupIds.getGroupIds().getGroupId()+".*;");
             } // for: models.getModelsGroupIds()

        } // for: developments.getModels()

        ArrayList<Packages> packages = new ArrayList<Packages>();

        for (Models models : developments.getModels()){

             for (ModelsGroupIds modelsGroupIds : models.getModelsGroupIds()){

                 line(modelsGroupIds.getGroupIds().getGroupId());

                 for (GroupIdsEntities groupIdsEntities : modelsGroupIds.getGroupIds().getGroupIdsEntities()){

                      Entidad entidad = new Entidad(groupIdsEntities.getEntities().getName());

                      for (Attributes attribute : groupIdsEntities.getEntities().getAttributes()) {

                           Atributos atributos = new Atributos();
                           atributos.setOrden(attribute.getOrden());
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

                      for (Relationships relationships : groupIdsEntities.getEntities().getFrom()) {

                          if (!entitiesNames.contains(relationships.getTo().getName())){
                             continue;
                          }


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

                      } // for: groupIdsEntities.getEntities().getFrom()

                      for (Relationships relationships : groupIdsEntities.getEntities().getTo()) {

/*
                          if (!isRelationModel(relationships.getFrom().getGroupId(),
                                               relationships.getTo().getGroupId(),
                                               models.getGroupId())){

                             if (modelsGroupIds.getIsIsolated()){
                                continue;
                             }
                          }
*/

                          if (!entitiesNames.contains(relationships.getFrom().getName())){
                             continue;
                          }


line("************");
line("to  :"+relationships.getTo().getName());
line("from:"+relationships.getFrom().getName());

if (relationships.getFrom().equals(relationships.getTo())){  // Relación Unitaria
line("unitaria:si");
}
else {
line("unitaria:no");
}


if (entitiesNames.contains(relationships.getFrom().getName())){
line("valida:si");
}
else {
line("valida:no");
}
line(".***********");




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

                      } // for: groupIdsEntities.getEntities().getTo()

                      entidad.setGroupId(groupIdsEntities.getGroupIds().getGroupId());
                      entidades.add(entidad);
line(entidad.getName());

                 } // for: modelsGroupIds.getGroupIds().getGroupIdsEntities()

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
        modelsGen.RestH2();
        modelsGen.jdocbook();
//        war(developments);
//        jsonNaifg(developments);
        modelsGen.ForgeRestH2();
        modelsGen.ForgeWarH2();
        modelsGen.WarSqliteDjango();

        AppModels appModels = new AppModels(developments.getGroupId(),developments.getArtifactId());
        appModels.setImports(imports);
        appModels.setPackages(packages);
        appModels.setEntities(entidades);

        AngularH2 angularH2 = new AngularH2(appModels);
        angularH2.App();

        JqueryH2 jqueryH2 = new JqueryH2(appModels);
        jqueryH2.App();

        NodejsH2 nodejsH2 = new NodejsH2(appModels);
        nodejsH2.App();

        ReactH2 reactH2 = new ReactH2(appModels);
        reactH2.App();

        DjangoSqlite djangoSqlite = new DjangoSqlite(appModels);
        djangoSqlite.App();


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

    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    jsonDependencies(developments);

    } // json

    public void jsonDependencies(Developments developments) throws IOException {
    try {

    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    } // json


    public ArrayList<String> EntitiesNames(Developments developments){
        ArrayList<String> entitiesNames = new ArrayList<String>(0);
        for (Models models : developments.getModels()){
            for (ModelsGroupIds modelsGroupIds : models.getModelsGroupIds()){
                for (GroupIdsEntities groupIdsEntities : modelsGroupIds.getGroupIds().getGroupIdsEntities()){
                    entitiesNames.add(groupIdsEntities.getEntities().getName());
                } // for: modelsGroupIds.getGroupIds().getGroupIdsEntities()
            } // for: models.getModelsGroupIds()
        } // for: developments.getModels()
        return entitiesNames;
    } // EntitiesNames


} // DevelopmentsGen