package co.simasoft.setup;

import co.simasoft.beans.*;
import co.simasoft.utils.*;

import co.simasoft.models.*;

import java.util.*;
import java.util.Map.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jboss.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@Singleton
@LocalBean
@Named("fileUploadCsv")
public class FileUploadCsv {

    private String filePath = "";

    BufferedReader br = null;

    Integer i = 0;
    String entity = "";
    String line = "";
    String cvsSplitBy = ";";

    String[] types = new String[100];
    String[] fields = new String[100];

    @PersistenceContext(unitName = "leanCrmPU-JTA")
    private EntityManager em;

    private UploadedFile file;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public void data() {

    try {

        if(file != null) {

           FileTxt f = new FileTxt();

           filePath = "\\docs\\"+file.getFileName();

           FacesMessage message = new FacesMessage("Succesful", filePath + " is uploaded.");
           FacesContext.getCurrentInstance().addMessage(null, message);

           br = new BufferedReader(new FileReader(filePath));
           while ((line = br.readLine()) != null) {

              // use comma as separator
              String[] data = line.split(cvsSplitBy);

              i++;
              switch (i) {
                  case 1:
                       entity = data[data.length-1];
                       types = data;
                       f.line("Entidad:"+entity);
                       break;

                  case 2:
                       fields = data;
                       break;

                  default:
                       entitiesData(entity,fields,types,data,f,em);
                       break;
              }
           }
           f.saveFile("\\docs", entity+"Data.txt");

        } // if


    } catch (FileNotFoundException ex) {
             ex.printStackTrace();
    } catch (IOException ex) {
             ex.printStackTrace();
    } catch (NullPointerException ex) {
             ex.printStackTrace();
    } catch(Exception ioe) {
            ioe.printStackTrace();
    } finally {
        if (br != null) {
            try {
              br.close();
            }
            catch (IOException e) {
                  e.printStackTrace();
            }
        }
    }

    } // data()


    public void entitiesData(String entity,String[] fields,String[] types,String[] data,FileTxt f,EntityManager em) {

        switch (entity) {
            case "PhysicalAreas":
                 PhysicalAreas(entity,fields,types,data,f,em);
                 break;

            case "physicalAreasTypes" :
                 break;
        }

    } // Entities

    public void PhysicalAreas(String entity,String[] fields,String[] types,String[] data,FileTxt f,EntityManager em) {

        PhysicalAreas physicalAreas = new PhysicalAreas();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+fields[i]+"="+data[i]);

            switch (fields[i]) {
                case "name":
                     physicalAreas.setName(data[i]);
                     break;

                case "code":
                     physicalAreas.setCode(data[i]);
                     break;

                case "width":
                     physicalAreas.setWidth(Double.parseDouble(data[i]));
                     break;

                case "high":
                     physicalAreas.setHigh(Double.parseDouble(data[i]));
                     break;

                case "prof":
                     physicalAreas.setProf(Double.parseDouble(data[i]));
                     break;

                case "area":
                     physicalAreas.setArea(Double.parseDouble(data[i]));
                     break;

                case "volume":
                     physicalAreas.setVolume(Double.parseDouble(data[i]));
                     break;

                default:
                       break;
            }


        } // for

        em.persist(physicalAreas);
        em.flush();

    } // PhysicalAreas

}

