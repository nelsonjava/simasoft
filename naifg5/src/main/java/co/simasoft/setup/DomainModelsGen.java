package co.simasoft.setup;

import co.simasoft.utils.*;
import co.simasoft.models.naif.domainmodels.*;

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

/*
  Pruebas a archivo texto
  FileTxt fileTxt = new FileTxt();  
  fileTxt.line("Prueba");
  Utils.fileMake("\\docs","leame.txt",fileTxt );
*/


@Singleton
@LocalBean
@Named("DomainModelsGen")
public class DomainModelsGen {

    private static final Logger log = Logger.getLogger(DomainModelsGen.class.getName());

    public void data(DomainModels domainModels) throws IOException {

        FileTxt fileTxt = new FileTxt();

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

                    Atributos atributos = new Atributos(attribute.getName(), attribute.getTypesAttributes().getType());

                    Set<PropertiesAttributes> propertiesAttributes = attribute.getTypesAttributes().getPropertiesAttributes();

                    String annotations = "";
                    int i=0;
                    for (PropertiesAttributes propertiesAttribute : propertiesAttributes ){
                         annotations += "    "+propertiesAttribute.getValue();
                         if (++i < propertiesAttributes.size()){
                            annotations += "\n";
                         }
                         for (Imports importss : propertiesAttribute.getImports() ){
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

    public void download(DomainModels domainModels) throws IOException {
        // !Generate first!
        data(domainModels);
        Download.files("\\docs\\"+domainModels.getName()+"\\"+domainModels.getName()+"\\war\\h2",domainModels.getName()+".zip");
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

} // DomainModelsSetup

