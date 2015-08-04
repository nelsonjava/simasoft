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
        
        ModelsGen modelsGen = new ModelsGen(developments.getGroupId(),developments.getArtifactId());
        modelsGen.setImports(imports);
        modelsGen.setPackages(packages);
        modelsGen.WarH2();

        saveFile("\\docs", "Prueba.txt");

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


} // DevelopmentsGen

