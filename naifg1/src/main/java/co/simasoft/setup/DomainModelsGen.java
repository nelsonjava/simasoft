package co.simasoft.setup;

import co.simasoft.utils.*;
import co.simasoft.models.naif.DomainModels.*;

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


@Singleton
@LocalBean
@Named("DomainModelsGen")
public class DomainModelsGen {

    private ArrayList<Packages> packages = new ArrayList<Packages>();
    private LinkedHashSet<String> imports = new LinkedHashSet<String>();

    private static final Logger log = Logger.getLogger(DomainModelsGen.class.getName());

    public void data(DomainModels domainModels) throws IOException {

        System.out.println("Hello World!" + domainModels.getName());

        for (GroupIds groupIds : domainModels.getGroupIds()){
            imports.add(groupIds.getGroupId());
        }

        for (GroupIds groupIds : domainModels.getGroupIds()){

            ArrayList<Entidad> entidades = new ArrayList<Entidad>();

            for (Entities entity : groupIds.getEntities()){
                Entidad entidad = new Entidad(entity.getName());

                for (Attributes attribute : entity.getAttributes()) {
                     entidad.addAtributo(new Atributos(attribute.getName(), attribute.getType()));
                } // for: entity.getAttributes()

                for (Relationships relationships : entity.getFrom()) {
                     entidad.addRelations(new Relation(relationships.getFrom().getName(),
                                                       relationships.getTo().getName(),
                                                       relationships.getCardinalities().getCardinality(),
                                                       relationships.getName()));
                } // for: entity.getFrom()

                for (Relationships relationships : entity.getTo()) {
                    entidad.addRelations(new Relation(relationships.getTo().getName(),
                                                      relationships.getFrom().getName(),
                                                      "*..1",relationships.getName()));
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

