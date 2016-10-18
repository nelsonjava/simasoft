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

relationshipsR7(filePath,em,isValidate,f);


/*
           if("R5".indexOf(file.getFileName()) == - 1){
              relationshipsR5(filePath,em,isValidate,f);
           }

           if("R7".indexOf(file.getFileName()) == - 1){
              relationshipsR7(filePath,em,isValidate,f);
           }
*/


        } // if


    } // data()

    public void relationshipsR5(String filePath,EntityManager em,Boolean isValidate,FileTxt f) {

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
                    relationshipsR5Data(fields,data,em,isValidate,f);
                    break;
           }
        }

        if (isValidate) {
            f.saveFile("\\docs", "R5predio.txt");
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

    public void relationshipsR5Data(String[] fields,String[] data,EntityManager em,Boolean isValidate,FileTxt f) {

        String from = data[0];
        String fromProperty = data[1];
        String fromValue = data[2];
        String to = data[3];
        String toProperty = data[4];
        String toValue = data[5];
        String name = data[6];
        String cardinalities = data[7];

        FindBean findBean = new FindBean();

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

    } // relationshipsR5Data

    public void relationshipsR7(String filePath,EntityManager em,Boolean isValidate,FileTxt f) {

        BufferedReader br = null;

        Integer i = 0;
        String line = "";
        String cvsSplitBy = ";";
        String[] fields = new String[100];

        String ant = "";
        String actual = "";
        String anterior = "";
        Boolean isCambio = false;

        String from = "";
        String fromProperty = "";
        String fromValue = "";
        String to = "";
        String toProperty = "";
        String toValue = "";
        String name = "";
        String cardinalities = "";

        FindBean findBean = new FindBean();

        Set<PhysicalAreas> physicalAreas = new HashSet<PhysicalAreas>();
        PhysicalAreas physicalArea = new PhysicalAreas();


    try {

        anterior = "xyz";
        br = new BufferedReader(new FileReader(filePath));
        while ((line = br.readLine()) != null) {

           String[] data = line.split(cvsSplitBy);

f.line(line);

           from = data[0];
           fromProperty = data[1];
           fromValue = data[2];
           to = data[3];
           toProperty = data[4];
           toValue = data[5];
           name = data[6];
           cardinalities = data[7];

           i++;
           if (i > 1){

              if (from.equals("PhysicalSpaces") &&
                  cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
                  to.equals("PhysicalAreas") &&
                  name.equals("")){

                  actual = data[2];
                  if (actual.equals(anterior)){
                      isCambio = false;
                  }
                  else {
                      isCambio = true;
                      ant = anterior;
                      anterior = actual;
                  }

                  if (isCambio){
                      f.line("cambio:"+ant);

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

                  }
                  else{
                      f.line("igual");
                  }

//                  f.line("from:"+fromValue+" to:"+toValue);

                  physicalArea = findBean.namePhysicalAreas(toValue,em);

                  f.line(toValue+"="+physicalArea.getName());

                  physicalAreas.add(physicalArea);

              }  // from: PhysicalSpaces

           } // i > 1

        } // while

        if (physicalAreas.size() > 0){
            PhysicalSpaces physicalSpaces = findBean.namePhysicalSpaces(fromValue,em);
            physicalSpaces.setPhysicalAreas(physicalAreas);
            if (!isValidate) {
                em.merge(physicalSpaces);
                em.flush();
            }
        }

        if (isValidate) {
            f.saveFile("\\docs", "R7predio.txt");
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



} // Class
