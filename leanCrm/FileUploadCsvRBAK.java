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

    BufferedReader br = null;
    BufferedReader bb = null;

    private String actual = "";
    private String anterior = "";
    private Boolean isCambio = false;

    Integer i = 0;
    String line = "";
    String cvsSplitBy = ";";

    String[] fields = new String[100];

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

    public void data(Boolean isValidate) {

    try {

        if(file != null) {

           i = 0;

           FileTxt f = new FileTxt();

           filePath = "\\docs\\"+file.getFileName();

           FacesMessage message = new FacesMessage("Succesful", filePath + " is uploaded.");
           FacesContext.getCurrentInstance().addMessage(null, message);

           br = new BufferedReader(new FileReader(filePath));
           bb = br;
           anterior = fromValue(bb);
           f.line("anterior:"+anterior);
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
                          anterior = actual;
                       }
                       relationshipsData(fields,data,f,em,isCambio,isValidate);
                       break;
              }
           }

           if (isValidate) {
               f.saveFile("\\docs", "predio.txt");
           }


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

    public String fromValue(BufferedReader br) {
        Integer i = 0;
        String fromValue = "";
    try {
        while ((line = br.readLine()) != null) {
           String[] data = line.split(cvsSplitBy);
           i++;
           if (i > 1){
              fromValue = data[2];
              break;
           }
        }
    } catch (FileNotFoundException ex) {
             ex.printStackTrace();
    } catch (IOException ex) {
             ex.printStackTrace();
    } catch (NullPointerException ex) {
             ex.printStackTrace();
    } catch(Exception ioe) {
            ioe.printStackTrace();
    }

    return fromValue;

    } // fromValue

    public void relationshipsData(String[] fields,String[] data,FileTxt f,EntityManager em,Boolean isCambio,Boolean isValidate) {

        String from = data[0];
        String fromProperty = data[1];
        String fromValue = data[2];
        String to = data[3];
        String toProperty = data[4];
        String toValue = data[5];
        String name = data[6];
        String cardinalities = data[7];
        
        Set<PhysicalAreas> physicalAreas = new HashSet<PhysicalAreas>();
        PhysicalAreas physicalArea = new PhysicalAreas();


        if (from.equals("Predio") &&
            cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
            to.equals("PhysicalSpaces") &&
            name.equals("")){

            Predio predioFrom = new Predio();

            PhysicalSpaces physicalSpacesTo = new PhysicalSpaces();

            if (fromProperty.equals("nomenclatura")){
                predioFrom = findBean.nomenclaturaPredio(fromValue,em);
                f.line("from:"+fromValue+":"+predioFrom.getNomenclatura());
            } // predio

            if (fromProperty.equals("predial")){
                predioFrom = findBean.predialPredio(fromValue,em);
                f.line("from:"+fromValue+":"+predioFrom.getPredial());
            } // predio

            if (fromProperty.equals("estrato")){
                predioFrom = findBean.estratoPredio(fromValue,em);
                f.line("from:"+fromValue+":"+predioFrom.getEstrato());
            } // predio

            if (fromProperty.equals("matricula")){
                predioFrom = findBean.matriculaPredio(fromValue,em);
                f.line("from:"+fromValue+":"+predioFrom.getMatricula());
            } // predio

            if (toProperty.equals("name")){
                physicalSpacesTo = findBean.namePhysicalSpaces(toValue,em);
                f.line("to:"+toValue+":"+physicalSpacesTo.getName());
            } // PhysicalSpaces.name

            if (toProperty.equals("telExt")){
                physicalSpacesTo = findBean.telExtPhysicalSpaces(toValue,em);
                f.line("to:"+toValue+":"+physicalSpacesTo.getTelExt());
            } // PhysicalSpaces.telExt

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                physicalSpacesTo.setPredio(predioFrom);
            }

            if (!isValidate) {
                em.merge(physicalSpacesTo);
                em.flush();
            }

        } // from: Predio

        if (from.equals("PhysicalSpaces") &&
            cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
            to.equals("PhysicalAreas") &&
            name.equals("")){

            if (isCambio){
                f.line("cambio");
                physicalAreas = null;
            }
            else{
                f.line("igual");
            }

            physicalArea = findBean.namePhysicalAreas(toValue,em);
            physicalAreas.add(physicalArea);


            f.line("from:"+fromValue+" to:"+toValue);

        }  // from: PhysicalSpaces


    } // Entities

}
