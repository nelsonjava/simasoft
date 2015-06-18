package co.simasoft.setup;

import co.simasoft.utils.*;
import co.simasoft.models.naif.domainmodels.*;
import co.simasoft.beans.*;

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
@Named("DomainModelsGen")
public class DomainModelsGen extends FileTxt {

    private static final Logger log = Logger.getLogger(DomainModelsGen.class.getName());

    private static final String QUERYA = "SELECT c FROM PropertiesAttributes c WHERE c.name LIKE :custName";

    @PersistenceContext(unitName = "naifg8PU-JTA")
    private EntityManager em;

    public void data(DomainModels domainModels) throws IOException {

        LinkedHashSet<String> imports = new LinkedHashSet<String>();

        System.out.println("Hello World!" + domainModels.getName());

        for (GroupIds groupIds : domainModels.getGroupIds()){
            imports.add("import "+groupIds.getGroupId()+".*;");
        }

        ArrayList<Packages> packages = new ArrayList<Packages>();
        for (GroupIds groupIds : domainModels.getGroupIds()){

            ArrayList<Entidad> entidades = new ArrayList<Entidad>();

            for (Entities entity : groupIds.getEntities()){
                Entidad entidad = new Entidad(entity.getName());

                for (Attributes attribute : entity.getAttributes()) {

                    Atributos atributos = new Atributos(attribute.getName(), attribute.getAttributesTypes().getType());

                    String annotations = "";

                    PropertiesAttributes properties = new PropertiesAttributes();
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

                    Set<PropertiesAttributes> attributesProperties = attribute.getAttributesTypes().getPropertiesAttributes();
                    if(attributesProperties.size() > 0){
                      annotations += "\n";
                    }

                    int i=0;
                    for (PropertiesAttributes attributeProperties : attributesProperties ){
                         annotations += "    "+attributeProperties.getValue();
                         if (++i < attributesProperties.size()){
                            annotations += "\n";
                         }
                         for (Imports importss : attributeProperties.getImports() ){
                              imports.add(importss.getName());
                         }
                    }
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

                entidad.setGroupId(groupIds.getGroupId());
                entidades.add(entidad);

            } // for: groupIds.getEntities()

            packages.add(new Packages(groupIds.getGroupId(),domainModels.getArtifactId(),entidades));

        } // for: domainModels.getGroupIds()

        Models models = new Models(domainModels.getGroupId(),domainModels.getArtifactId());
        models.setImports(imports);
        models.setPackages(packages);
        models.WarH2();

    } // data()

    public PropertiesAttributes findAttributesProperties(String name) {

        PropertiesAttributes attributesProperties = new PropertiesAttributes();
        List<PropertiesAttributes> results = em.createQuery(QUERYA).setParameter("custName", name).getResultList();

        if (!results.isEmpty()) {
           attributesProperties = results.get(0);
        }
        return attributesProperties;
    }

    public void download(DomainModels domainModels) throws IOException {
        // !Generate first!
        data(domainModels);
        Download.files("\\docs\\"+domainModels.getArtifactId(),domainModels.getArtifactId()+".zip");
    } // end : download Method

    public void downloadProtected(DomainModels domainModels) throws IOException {

        BufferedInputStream  input  = null;
        BufferedOutputStream output = null;
        String fileName = "prueba.zip";

        // docs es la carpeta de entrada, y 44 la clave
        PZip.zipDirWithPassword("\\docs","pruebap.zip", "6424");

        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();

        ec.responseReset();
        ec.setResponseContentType("application/zip");
        ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        try {
            input  = new BufferedInputStream(new FileInputStream(fileName));
            output = new BufferedOutputStream(ec.getResponseOutputStream());

            byte[] buffer = new byte[10240];
            for (int length; (length = input.read(buffer)) > 0;) {
                output.write(buffer, 0, length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            input.close();
            output.close();
        }

        fc.responseComplete();

    } // end : download Method

    public void setup(DomainModels domainModels)  {
    try {

        System.out.println("Hello World Setup!" + domainModels.getName());

        clearFileTxt();
        NaifgBean naifgBean = new NaifgBean();

        int i=0;
        List<Cardinalities> cardinalities;
//        cardinalities = naifgBean.findAllCardinalities(em);
cardinalities = findAllCardinality();
line("//      ---------------------- Cardinalities:"+cardinalities.size()+"---------------------------------\n");
        for (Cardinalities cardinality : cardinalities) {
line("        Cardinalities cardinality"+String.valueOf(++i)+" = new Cardinalities();");
        } // Cardinalities


/*
        i=0;
        List<Dependency> dependencies;
        dependencies = naifgBean.findAllDependency(em);
line("//      ---------------------- Dependency:"+dependencies.size()+"---------------------------------\n");
        for (Dependency dependency : dependencies) {
line("        Dependency dependency"+String.valueOf(++i)+" = new Dependency();");
        } // Dependency
*/


        saveFile("\\docs", "Setup.java");

    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    } // Setup

    public List<Cardinalities> findAllCardinality() {

        FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search.getFullTextEntityManager(em);

        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Cardinalities.class).get();
        org.apache.lucene.search.Query query = queryBuilder.all().createQuery();

        FullTextQuery fullTextQuery = fullTextEntityManager.createFullTextQuery(query, Cardinalities.class);
        Sort sort = new Sort(new SortField("orden", SortField.LONG));
        fullTextQuery.setSort(sort);

        fullTextQuery.initializeObjectsWith(ObjectLookupMethod.SKIP, DatabaseRetrievalMethod.FIND_BY_ID);

        List<Cardinalities> results = fullTextQuery.getResultList();

        return results;

    }

} // DomainModelsSetup
