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
        Integer j = 0;
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

    try {

        anterior = "";

        PhysicalSpaces physicalSpaces = new PhysicalSpaces();

        Set<PhysicalAreas> physicalAreass = new HashSet<PhysicalAreas>();
        PhysicalAreas physicalAreas = new PhysicalAreas();

        br = new BufferedReader(new FileReader(filePath));
        while ((line = br.readLine()) != null) {

              String[] data = line.split(cvsSplitBy);

              from = data[0];
              fromProperty = data[1];
              fromValue = data[2];
              to = data[3];
              toProperty = data[4];
              toValue = data[5];
              name = data[6];
              cardinalities = data[7];
              
              i++;
              f.line(Integer.toString(i)+"=From:"+from+"\n"+
                                         "  FromProperty:"+fromProperty+"\n"+
                                         "  FromValue:"+fromValue+"\n"+
                                         "  To:"+to+"\n"+
                                         "  ToProperty:"+toProperty+"\n"+
                                         "  ToValue:"+toValue+"\n"+
                                         "  Name:"+name+"\n"+
                                         "  Cardinalities:"+cardinalities);

              if(cardinalities.equals("Cardinalities")){
                 continue; // Descarta el primer registro
              }

              if(i==2){
                 anterior = fromValue;
              }

              actual = fromValue;
              if (actual.equals(anterior)){
                  isCambio = false;
              }
              else {
                  isCambio = true;
                  ant = anterior;
                  anterior = actual;
              }

              if (from.equals("PhysicalSpaces") &&
                  cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
                  to.equals("PhysicalAreas") &&
                  Utils.isEmpty(name)){

                  if (isCambio){

                      f.line("cambio:"+ant);

                      if (physicalAreass.size() > 0){

                         if(fromProperty.equals("name")){
                            physicalSpaces = findBean.namePhysicalSpaces(ant,em);
                            physicalSpaces.setPhysicalAreas(physicalAreass);
                         } // physicalSpaces

                         if(fromProperty.equals("telExt")){
                            physicalSpaces = findBean.telExtPhysicalSpaces(ant,em);
                            physicalSpaces.setPhysicalAreas(physicalAreass);
                         } // physicalSpaces

                         if(!isValidate) {

                            em.merge(physicalSpaces);
                            em.flush();

                            j = 0;
                            for(PhysicalAreas physicalAreasx : physicalAreass){
                                f.line("       "+Integer.toString(++j)+":"+physicalAreasx.getName());
                            }

                         }

                      } // size()

                      physicalAreass = new HashSet<PhysicalAreas>();
                      physicalAreas = new PhysicalAreas();

                  } // Cambio

                  if(toProperty.equals("name")){
                     physicalAreas = findBean.namePhysicalAreas(toValue,em);
                  } // physicalAreas

                  if(toProperty.equals("code")){
                     physicalAreas = findBean.codePhysicalAreas(toValue,em);
                  } // physicalAreas

                  physicalAreass.add(physicalAreas);

              } // from: PhysicalSpaces

        } // while

        if (from.equals("PhysicalSpaces") &&
            cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
            to.equals("PhysicalAreas") &&
            name.equals("")){

            if (physicalAreass.size() > 0){

                if (fromProperty.equals("name")){
                    physicalSpaces = findBean.namePhysicalSpaces(anterior,em);
                    physicalSpaces.setPhysicalAreas(physicalAreass);
                } // physicalAreas

                if (fromProperty.equals("telExt")){
                   physicalSpaces = findBean.telExtPhysicalSpaces(anterior,em);
                   physicalSpaces.setPhysicalAreas(physicalAreass);
                } // physicalAreas

                if (!isValidate) {
                   em.merge(physicalSpaces);
                   em.flush();
                }
            }

        } // from: PhysicalSpaces

        if (isValidate) {
            f.saveFile("\\docs", "VR7.txt");
        }
        else{
            f.saveFile("\\docs", "DR7.txt");
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
