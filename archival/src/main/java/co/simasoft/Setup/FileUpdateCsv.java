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
@Named("fileUpdateCsv")
public class FileUpdateCsv {

    private String filePath = "";

    @PersistenceContext(unitName = "archivalPU-JTA")
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

           entiyUpdate(filePath,em,isValidate,f);

        } // if

    } // data()

    public void entiyUpdate(String filePath,EntityManager em,Boolean isValidate,FileTxt f) {

        BufferedReader br = null;

        Integer i = 0;
        String line = "";
        String cvsSplitBy = ";";
        String[] fields = new String[100];

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
                    entiyUpdateData(fields,data,em,isValidate,f);
                    break;
           }


        }

        if (isValidate) {
            f.saveFile("\\docs", "entiyUpdate.txt");

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

    } // relationshipsR5

    public void entiyUpdateData(String[] fields,String[] data,EntityManager em,Boolean isValidate,FileTxt f) {

        String entity = data[0];
        String findProperty = data[1];
        String findValue = data[2];
        String updateProperty = data[3];
        String updateValue = data[4];

        FindBean findBean = new FindBean();

        if (entity.equals("DocumentalsUnits")){

            DocumentalsUnits documentalsUnits = new DocumentalsUnits();

            if (findProperty.equals("name")){

                documentalsUnits = findBean.nameDocumentalsUnits(findValue,em);

                if (updateProperty.equals("orden")){
                   documentalsUnits.setOrden(Double.parseDouble(updateValue));
                   f.line(findValue+"="+updateValue);
                }
                
                if (updateProperty.equals("observations")){
                   documentalsUnits.setObservations(updateValue);
                   f.line(findValue+"="+updateValue);
                }

            } // name


            if (!isValidate) {
                em.merge(documentalsUnits);
                em.flush();
            }

        } // from: DocumentalsUnits

    } // entiyUpdateData

} // Class
