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
@Named("fileUploadCsvR")
public class FileUploadCsvR {

    private String filePath = "";

    @PersistenceContext(unitName = "leanCrmPU-JTA")
    private EntityManager em;

    private UploadedFile file;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public void data(Boolean isValidate) {

        if(file != null) {

           filePath = "\\docs\\"+file.getFileName();

           FileTxt f = new FileTxt();

           FacesMessage message = new FacesMessage("Succesful", filePath + " is uploaded.");
           FacesContext.getCurrentInstance().addMessage(null, message);

           if(file.getFileName().indexOf("R7") > 0){
              relationshipsR7(filePath,em,isValidate,f);
           }

        } // if


    } // data()

    public void relationshipsR7(String filePath,EntityManager em,Boolean isValidate,FileTxt f) {

        BufferedReader br = null;

        Integer i = 0;
        String line = "";
        String cvsSplitBy = ";";
        String[] fields = new String[100];

        String ant = "";
        String anterior = "zyz";
        String actual = "";
        Boolean isCambio = false;


    try {

        br = new BufferedReader(new FileReader(filePath));
        while ((line = br.readLine()) != null) {

           // use comma as separator
           String[] data = line.split(cvsSplitBy);

           i++;
           switch (i) {
               case 1:
                    fields = data;
                    break;
               default:

                    actual = data[2];
                    if (actual.equals(anterior)){
                       isCambio = false;
                    }
                    else {
                       isCambio = true;
                       ant = anterior;
                       anterior = actual;
                    }

                    relationshipsR7Data(fields,data,em,isValidate,f,isCambio,ant);
                    break;
           }
        } // while

        if (isValidate) {
            f.saveFile("\\docs", "R7.txt");
        }

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

    } // relationshipsR7

    public void relationshipsR7Data(String[] fields,String[] data,EntityManager em,Boolean isValidate,FileTxt f,Boolean isCambio,String ant) {

        String from = data[0];
        String fromProperty = data[1];
        String fromValue = data[2];
        String to = data[3];
        String toProperty = data[4];
        String toValue = data[5];
        String name = data[6];
        String cardinalities = data[7];

        FindBean findBean = new FindBean();

        if (from.equals("PhysicalSpaces") &&
                  cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
                  to.equals("PhysicalAreas") &&
                  name.equals("")){

            Set<PhysicalAreas> physicalAreas = new HashSet<PhysicalAreas>();
            PhysicalAreas physicalArea = new PhysicalAreas();

            if (isCambio){

                f.line("cambio");

                if (physicalAreas.size() > 0){
                    PhysicalSpaces physicalSpaces = findBean.namePhysicalSpaces(ant,em);
                    physicalSpaces.setPhysicalAreas(physicalAreas);
                    if (!isValidate) {
                        em.merge(physicalSpaces);
                        em.flush();
                    }
                }

                physicalAreas = new HashSet<PhysicalAreas>();
                physicalArea = new PhysicalAreas();

            } // isCambio

            physicalArea = findBean.namePhysicalAreas(toValue,em);
            physicalAreas.add(physicalArea);

            f.line("from:"+fromValue+" to:"+toValue);

        } // from: PhysicalSpaces

    } // relationshipsR7

} // Class
