package co.simasoft.setup;

import co.simasoft.beans.*;
import co.simasoft.utils.*;

import co.simasoft.models.*;

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

    String csvFile = "/Users/mkyong/csv/country.csv";
    BufferedReader br = null;

    int i = 0;
    int j = 0;
    String entity = "";
    String fieldType = "";
    String fieldName = "";
    String fieldValue = "";
    String line = "";
    String cvsSplitBy = ";";

    @PersistenceContext(unitName = "leanCrmPU-JTA")
    private EntityManager em;

    FindBean findBean = new FindBean();

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

           filePath = "\\docs\\"+file.getFileName();

           FacesMessage message = new FacesMessage("Succesful", filePath + " is uploaded.");
           FacesContext.getCurrentInstance().addMessage(null, message);

           FileTxt f = new FileTxt();

           br = new BufferedReader(new FileReader(filePath));
           while ((line = br.readLine()) != null) {

              // use comma as separator
              String[] data = line.split(cvsSplitBy);

              i++;
              switch (i) {
                  case 1 :

                       entity = data[data.length-1];

                       j = 0;
                       fieldType = "";
                       for (String type : data) {
                           j++;
                           if (j < data.length-1 ){
                               fieldType += type+";";
                           }
                       }

                       f.line("Entidad:"+entity);
                       f.line("Tipos:"+fieldType);
                       break;

                  case 2:

                       j = 0;
                       fieldName = "";
                       for (String field : data) {
                           j++;
                           if (j < data.length-1 ){
                               fieldName += field+";";
                           }
                       }
                       f.line("campos:");
                       f.line(fieldName);
                       break;

                  default:
                       f.line("registro:");
                       j = 0;
                       fieldValue = "";
                       for (String value : data) {
                            fieldValue += value+";";
                       }

                       f.line(fieldValue);
                       break;
              } // switch (atributo.getType())

           }

           f.saveFile("\\docs", "logcvs.txt");


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

}

