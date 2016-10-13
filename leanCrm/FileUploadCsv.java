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

    String csvFile = "/Users/mkyong/csv/country.csv";
    BufferedReader br = null;

    Integer i = 0;
    Integer j = 0;

    String entity = "";
    String fieldType = "";
    String fieldName = "";
    String fieldValue = "";
    String line = "";
    String cvsSplitBy = ";";

    Map<Integer, String> types = new HashMap<Integer, String>();
    Map<Integer, String> fields = new HashMap<Integer, String>();
    Map<Integer, String> registro = new HashMap<Integer, String>();

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
                               types.put(j,type);
                               fieldType += type+";";
                           }
                       }

                       f.line("Entidad:"+entity);
//                       f.line("Tipos:"+fieldType);

                       for (Entry<Integer, String> e: types.entrySet()) {
                            System.out.println("["+e.getKey() + "=" + e.getValue()+"]");
                       }

                       break;

                  case 2:

                       j = 0;
                       fieldName = "";
                       for (String field : data) {
                           j++;
                           if (j < data.length-1 ){
                               fields.put(j,field);
                               fieldName += field+";";
                           }
                       }
                       f.line("campos:");
//                       f.line(fieldName);

                       for (Entry<Integer, String> e: fields.entrySet()) {
                            System.out.println("["+e.getKey() + "=" + e.getValue()+"]");
                       }

                       break;

                  default:
                       f.line("registro:");
                       j = 0;
                       fieldValue = "";
                       for (String value : data) {
                            fieldValue += value+";";
                            registro.put(j,value);
                       }

/*
                       for (Entry<Integer, String> e: registro.entrySet()) {
                            System.out.println("["+e.getKey() + "=" + e.getValue()+"]");
                            f.line(fieldValue);
                            f.line("["+e.getKey() + "=" + e.getValue()+"]");
                       }
*/


                       for (Entry<Integer, String> e: registro.keySet()) {
                            System.out.println("["+e.getKey() + "=" + e.getValue()+"]");
                            f.line(fieldValue);
                            f.line("["+e.getKey() + "=" + e.getValue()+"]");
                       }


/*
                       Iterator it = registro.keySet().iterator();
                       while(it.hasNext()){
                              Integer key = it.next();
                              System.out.println("Clave: " + key + " -> Valor: " + registro.get(key));
                       }
*/


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

