package co.simasoft.setup;

import co.simasoft.beans.*;
import co.simasoft.utils.*;

import co.simasoft.models.*;

import java.util.*;
import java.text.*;
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
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    String cvsSplitBy = null;

    String[] types = new String[100];
    String[] fields = new String[100];
    String[] data;

    @PersistenceContext(unitName = "budgetsPU-JTA")
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

           i = 0;
           FileTxt f = new FileTxt();

           filePath = "\\docs\\"+file.getFileName();

           FacesMessage message = new FacesMessage("Succesful", filePath + " is uploaded.");
           FacesContext.getCurrentInstance().addMessage(null, message);

           br = new BufferedReader(new FileReader(filePath));
           while ((line = br.readLine()) != null) {

              i++;
              if (i==1){
                  data = line.split("");
                  cvsSplitBy = data[data.length-1];
              }
              else{
                  data = line.split(cvsSplitBy);
              }

              switch (i) {
                  case 1:
                       f.line("cvsSplitBy="+cvsSplitBy);
                       break;
                  case 2:
                       entity = data[data.length-1];
                       types = data;
                       f.line("Entidad:"+entity);
                       break;
                  case 3:
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
            case "Apus":
                 Apus(entity,fields,types,data,f,em);
                 break;
            case "ConstructionActivities":
                 ConstructionActivities(entity,fields,types,data,f,em);
                 break;
            case "ConstructionChapters":
                 ConstructionChapters(entity,fields,types,data,f,em);
                 break;
            case "TypesMeasurementUnits":
                 TypesMeasurementUnits(entity,fields,types,data,f,em);
                 break;
            case "MeasurementUnits":
                 MeasurementUnits(entity,fields,types,data,f,em);
                 break;
            case "Years":
                 Years(entity,fields,types,data,f,em);
                 break;
            case "WorksConstruction":
                 WorksConstruction(entity,fields,types,data,f,em);
                 break;
            case "TypesWorksConstruction":
                 TypesWorksConstruction(entity,fields,types,data,f,em);
                 break;
            case "Budgets":
                 Budgets(entity,fields,types,data,f,em);
                 break;
            case "WorkActivities":
                 WorkActivities(entity,fields,types,data,f,em);
                 break;
            case "ConstructionMaterials":
                 ConstructionMaterials(entity,fields,types,data,f,em);
                 break;
            case "ConstructionTransports":
                 ConstructionTransports(entity,fields,types,data,f,em);
                 break;
            case "ConstructionWorkforce":
                 ConstructionWorkforce(entity,fields,types,data,f,em);
                 break;
            case "ConstructionEquipments":
                 ConstructionEquipments(entity,fields,types,data,f,em);
                 break;
            case "TypesConstructionMaterials":
                 TypesConstructionMaterials(entity,fields,types,data,f,em);
                 break;
            case "TypesConstructionTransports":
                 TypesConstructionTransports(entity,fields,types,data,f,em);
                 break;
            case "TypesConstructionWorkforce":
                 TypesConstructionWorkforce(entity,fields,types,data,f,em);
                 break;
            case "TypesConstructionEquipments":
                 TypesConstructionEquipments(entity,fields,types,data,f,em);
                 break;
        }

    } // Entities

    public void Apus(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        Apus apus = new Apus();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "code":
                     apus.setCode(data[i]);
                     break;
                case "name":
                     apus.setName(data[i]);
                     break;
            }

        } // for

        em.persist(apus);
        em.flush();

    } // Apus

    public void ConstructionActivities(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        ConstructionActivities constructionActivities = new ConstructionActivities();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "code":
                     constructionActivities.setCode(data[i]);
                     break;
                case "name":
                     constructionActivities.setName(data[i]);
                     break;
            }

        } // for

        em.persist(constructionActivities);
        em.flush();

    } // ConstructionActivities

    public void ConstructionChapters(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        ConstructionChapters constructionChapters = new ConstructionChapters();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "code":
                     constructionChapters.setCode(data[i]);
                     break;
                case "name":
                     constructionChapters.setName(data[i]);
                     break;
            }

        } // for

        em.persist(constructionChapters);
        em.flush();

    } // ConstructionChapters

    public void TypesMeasurementUnits(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        TypesMeasurementUnits typesMeasurementUnits = new TypesMeasurementUnits();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "code":
                     typesMeasurementUnits.setCode(data[i]);
                     break;
                case "name":
                     typesMeasurementUnits.setName(data[i]);
                     break;
            }

        } // for

        em.persist(typesMeasurementUnits);
        em.flush();

    } // TypesMeasurementUnits

    public void MeasurementUnits(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        MeasurementUnits measurementUnits = new MeasurementUnits();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "code":
                     measurementUnits.setCode(data[i]);
                     break;
                case "name":
                     measurementUnits.setName(data[i]);
                     break;
            }

        } // for

        em.persist(measurementUnits);
        em.flush();

    } // MeasurementUnits

    public void Years(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        Years years = new Years();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "year":
                     years.setYear(data[i]);
                     break;
                case "ipc":
                     years.setIpc(Double.parseDouble(data[i]));
                     break;
            }

        } // for

        em.persist(years);
        em.flush();

    } // Years

    public void WorksConstruction(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        WorksConstruction worksConstruction = new WorksConstruction();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "code":
                     worksConstruction.setCode(data[i]);
                     break;
                case "name":
                     worksConstruction.setName(data[i]);
                     break;
                case "date":
                     try {
                       worksConstruction.setDate(formatter.parse(data[i]));
                     }
                     catch (ParseException e) {
                       e.printStackTrace();
                     }
                     break;
            }

        } // for

        em.persist(worksConstruction);
        em.flush();

    } // WorksConstruction

    public void TypesWorksConstruction(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        TypesWorksConstruction typesWorksConstruction = new TypesWorksConstruction();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "code":
                     typesWorksConstruction.setCode(data[i]);
                     break;
                case "name":
                     typesWorksConstruction.setName(data[i]);
                     break;
            }

        } // for

        em.persist(typesWorksConstruction);
        em.flush();

    } // TypesWorksConstruction

    public void Budgets(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        Budgets budgets = new Budgets();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "quantity":
                     budgets.setQuantity(Double.parseDouble(data[i]));
                     break;
                case "total":
                     budgets.setTotal(Double.parseDouble(data[i]));
                     break;
            }

        } // for

        em.persist(budgets);
        em.flush();

    } // Budgets

    public void WorkActivities(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        WorkActivities workActivities = new WorkActivities();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "code":
                     workActivities.setCode(data[i]);
                     break;
                case "name":
                     workActivities.setName(data[i]);
                     break;
            }

        } // for

        em.persist(workActivities);
        em.flush();

    } // WorkActivities

    public void ConstructionMaterials(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        ConstructionMaterials constructionMaterials = new ConstructionMaterials();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "code":
                     constructionMaterials.setCode(data[i]);
                     break;
                case "name":
                     constructionMaterials.setName(data[i]);
                     break;
                case "price":
                     constructionMaterials.setPrice(Double.parseDouble(data[i]));
                     break;
            }

        } // for

        em.persist(constructionMaterials);
        em.flush();

    } // ConstructionMaterials

    public void ConstructionTransports(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        ConstructionTransports constructionTransports = new ConstructionTransports();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "code":
                     constructionTransports.setCode(data[i]);
                     break;
                case "name":
                     constructionTransports.setName(data[i]);
                     break;
                case "rate":
                     constructionTransports.setRate(Double.parseDouble(data[i]));
                     break;
            }

        } // for

        em.persist(constructionTransports);
        em.flush();

    } // ConstructionTransports

    public void ConstructionWorkforce(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        ConstructionWorkforce constructionWorkforce = new ConstructionWorkforce();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "code":
                     constructionWorkforce.setCode(data[i]);
                     break;
                case "name":
                     constructionWorkforce.setName(data[i]);
                     break;
                case "basic":
                     constructionWorkforce.setBasic(Double.parseDouble(data[i]));
                     break;
                case "benefits":
                     constructionWorkforce.setBenefits(Double.parseDouble(data[i]));
                     break;
                case "salary":
                     constructionWorkforce.setSalary(Double.parseDouble(data[i]));
                     break;
            }

        } // for

        em.persist(constructionWorkforce);
        em.flush();

    } // ConstructionWorkforce

    public void ConstructionEquipments(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        ConstructionEquipments constructionEquipments = new ConstructionEquipments();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "code":
                     constructionEquipments.setCode(data[i]);
                     break;
                case "name":
                     constructionEquipments.setName(data[i]);
                     break;
                case "rate":
                     constructionEquipments.setRate(Double.parseDouble(data[i]));
                     break;
            }

        } // for

        em.persist(constructionEquipments);
        em.flush();

    } // ConstructionEquipments

    public void TypesConstructionMaterials(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        TypesConstructionMaterials typesConstructionMaterials = new TypesConstructionMaterials();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "code":
                     typesConstructionMaterials.setCode(data[i]);
                     break;
                case "name":
                     typesConstructionMaterials.setName(data[i]);
                     break;
            }

        } // for

        em.persist(typesConstructionMaterials);
        em.flush();

    } // TypesConstructionMaterials

    public void TypesConstructionTransports(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        TypesConstructionTransports typesConstructionTransports = new TypesConstructionTransports();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "code":
                     typesConstructionTransports.setCode(data[i]);
                     break;
                case "name":
                     typesConstructionTransports.setName(data[i]);
                     break;
            }

        } // for

        em.persist(typesConstructionTransports);
        em.flush();

    } // TypesConstructionTransports

    public void TypesConstructionWorkforce(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        TypesConstructionWorkforce typesConstructionWorkforce = new TypesConstructionWorkforce();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "code":
                     typesConstructionWorkforce.setCode(data[i]);
                     break;
                case "name":
                     typesConstructionWorkforce.setName(data[i]);
                     break;
            }

        } // for

        em.persist(typesConstructionWorkforce);
        em.flush();

    } // TypesConstructionWorkforce

    public void TypesConstructionEquipments(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        TypesConstructionEquipments typesConstructionEquipments = new TypesConstructionEquipments();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "code":
                     typesConstructionEquipments.setCode(data[i]);
                     break;
                case "name":
                     typesConstructionEquipments.setName(data[i]);
                     break;
            }

        } // for

        em.persist(typesConstructionEquipments);
        em.flush();

    } // TypesConstructionEquipments

}
