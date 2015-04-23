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

    private LinkedHashSet<String> imports = new LinkedHashSet<String>();
    private Set<Entities> entities;
    private ArrayList<Entidad> entidades = new ArrayList<Entidad>();

    private static final Logger log = Logger.getLogger(DomainModelsGen.class.getName());

    public void data(DomainModels domainModels) throws IOException {

        System.out.println("Hello World!-1" + domainModels.getName());

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

