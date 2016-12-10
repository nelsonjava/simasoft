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

    @PersistenceContext(unitName = "crmNaifgPU-JTA")
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

           if(file.getFileName().indexOf("R5") > 0){
//              relationshipsR5(filePath,em,isValidate,f);
           }

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
        String[] data;

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

    try{

        anterior = "";

        Brands brands = new Brands();
        Sites sites = new Sites();
        Companies companies = new Companies();
        Employees employees = new Employees();
        Charges charges = new Charges();
        CompaniesRoles companiesRoles = new CompaniesRoles();
        Dependencies dependencies = new Dependencies();
        Imports imports = new Imports();
        AttributesProperties attributesProperties = new AttributesProperties();
        AttributesTypes attributesTypes = new AttributesTypes();
        Developments developments = new Developments();
        ModelsGroups modelsGroups = new ModelsGroups();
        Models models = new Models();
        SitesTypes sitesTypes = new SitesTypes();
        Activities activities = new Activities();
        Calendars calendars = new Calendars();
        Tasks tasks = new Tasks();
        Diaries diaries = new Diaries();

        Set<Sites> sitess = new HashSet<Sites>();
        Set<Charges> chargess = new HashSet<Charges>();
        Set<CompaniesRoles> companiesRoless = new HashSet<CompaniesRoles>();
        Set<Imports> importss = new HashSet<Imports>();
        Set<AttributesProperties> attributesPropertiess = new HashSet<AttributesProperties>();
        Set<ModelsGroups> modelsGroupss = new HashSet<ModelsGroups>();
        Set<Models> modelss = new HashSet<Models>();
        Set<SitesTypes> sitesTypess = new HashSet<SitesTypes>();
        Set<Calendars> calendarss = new HashSet<Calendars>();

        br = new BufferedReader(new FileReader(filePath));
        while ((line = br.readLine()) != null) {

           i++;
           if (i==1){
               data = line.split("");
               cvsSplitBy = data[data.length-1];
               continue;
           }

           data = line.split(cvsSplitBy);

           from = data[0];
           fromProperty = data[1];
           fromValue = data[2];
           to = data[3];
           toProperty = data[4];
           toValue = data[5];
           name = data[6];
           cardinalities = data[7];

           if(cardinalities.equals("Cardinalities")){
              continue; // Descarta el primer registro
           }

           f.line(Integer.toString(i)+"=From:"+from+"\n"+
                                      " FromProperty:"+fromProperty+"\n"+
                                      " FromValue:"+fromValue+"\n"+
                                      " To:"+to+"\n"+
                                      " ToProperty:"+toProperty+"\n"+
                                      " ToValue:"+toValue+"\n"+
                                      " Name:"+name+"\n"+
                                      " Cardinalities:"+cardinalities);

           if(i==3){
             anterior = toValue;
           }

           actual = toValue;
           if (actual.equals(anterior)){
               isCambio = false;
           }
           else {
               isCambio = true;
               ant = anterior;
               anterior = actual;
f.line("Si Cambio="+String.valueOf(isCambio));
           }

/*
          f.line("AttributesProperties="+String.valueOf(from.equals("AttributesProperties")));
          f.line("Muchos a Muchos Bidirecccional No.7"+String.valueOf(cardinalities.equals("Muchos a Muchos Bidirecccional No.7")));
          f.line("Imports"+String.valueOf(to.equals("Imports")));
          f.line("Utils.isEmpty(name)"+String.valueOf(Utils.isEmpty(name)));
*/


           if (from.equals("AttributesProperties") &&
               cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
               to.equals("Imports") &&
               Utils.isEmpty(name)){

f.line(" "+Integer.toString(i)+":Anterior="+anterior+" Actual="+actual+" Cambio="+String.valueOf(isCambio));

f.line("PASOO Cambio="+String.valueOf(isCambio));

f.line("=======================================");

               if (isCambio){

f.line("PASOO Cambio="+String.valueOf(isCambio));

                  f.line("cambio:"+ant);

                  if (importss.size() > 0){

                      if (fromProperty.equals("name")){
                          attributesProperties = findBean.nameAttributesProperties(ant,em);
                          attributesProperties.setImports(importss);

                      } // attributesProperties

                      if (fromProperty.equals("value")){
                          attributesProperties = findBean.valueAttributesProperties(ant,em);
                          attributesProperties.setImports(importss);

                      } // attributesProperties

                      if (!isValidate) {

//                          em.merge(attributesProperties);
//                          em.flush();


f.line("name="+attributesProperties.getName());
f.line("value="+attributesProperties.getValue());
for(Imports imp : attributesProperties.getImports()){
   f.line("imports="+imp.getName());
}


f.line("PASO1:"+ant);

                          if (fromProperty.equals("name")){
f.line("PASO2:"+ant);
                              j = 0;
                              for(Imports importsx : importss){
                                  f.line("       "+Integer.toString(++j)+":"+importsx.getName());
f.line("PASO3:"+ant);
                              }
f.line("PASO4:"+ant);

                          } // attributesProperties

                      }

                  } // size()

                  importss = new HashSet<Imports>();
                  imports = new Imports();

               } // isCambio

              if (toProperty.equals("name")){
                  imports = findBean.nameImports(toValue,em);
              } // imports

              importss.add(imports);

           } // from: AttributesProperties

f.saveFile("\\docs", "PRUEBA1.txt");

        } // while


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
