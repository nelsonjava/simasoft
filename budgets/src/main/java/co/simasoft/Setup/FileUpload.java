package co.simasoft.setup;

import co.simasoft.beans.*;
import co.simasoft.utils.*;

import co.simasoft.models.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import java.util.*;
import java.util.Calendar;
import java.util.Random;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jboss.logging.Logger;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import javax.servlet.http.Part;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.inject.Named;

@Singleton
@LocalBean
@Named("fileUpload")
public class FileUpload {

    private String filePath = "";

    @PersistenceContext(unitName = "budgetsPU-JTA")
    private EntityManager em;

    FindBean findBean = new FindBean();

    private UploadedFile file;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public void apus() {
    try {

        if(file != null) {

           filePath = "\\docs\\"+file.getFileName();

           FacesMessage message = new FacesMessage("Succesful", filePath + " is uploaded.");
           FacesContext.getCurrentInstance().addMessage(null, message);

           FileTxt f = new FileTxt();

           // read the json file
           FileReader reader = new FileReader(filePath);

           JSONParser jsonParser = new JSONParser();
           JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

           // get an array from the JSON object
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("Apus");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String code = (String)relationObj.get("code");
                 String name = (String)relationObj.get("name");

                 Apus apus = new Apus();

                 apus.setCode(code);
                 f.line(apus.getCode());
                 f.line("");

                 apus.setName(name);
                 f.line(apus.getName());
                 f.line("");

                 em.persist(apus);
                 em.flush();

           } // while

           f.saveFile("\\docs", "apus.txt");

        } // if

    } catch (FileNotFoundException ex) {
             ex.printStackTrace();
    } catch (IOException ex) {
             ex.printStackTrace();
    } catch (ParseException ex) {
             ex.printStackTrace();
    } catch (NullPointerException ex) {
             ex.printStackTrace();
    } catch(Exception ioe) {
            ioe.printStackTrace();
    }

    } // apus()

    public void constructionActivities() {
    try {

        if(file != null) {

           filePath = "\\docs\\"+file.getFileName();

           FacesMessage message = new FacesMessage("Succesful", filePath + " is uploaded.");
           FacesContext.getCurrentInstance().addMessage(null, message);

           FileTxt f = new FileTxt();

           // read the json file
           FileReader reader = new FileReader(filePath);

           JSONParser jsonParser = new JSONParser();
           JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

           // get an array from the JSON object
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("ConstructionActivities");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String code = (String)relationObj.get("code");
                 String name = (String)relationObj.get("name");

                 ConstructionActivities constructionActivities = new ConstructionActivities();

                 constructionActivities.setCode(code);
                 f.line(constructionActivities.getCode());
                 f.line("");

                 constructionActivities.setName(name);
                 f.line(constructionActivities.getName());
                 f.line("");

                 em.persist(constructionActivities);
                 em.flush();

           } // while

           f.saveFile("\\docs", "constructionActivities.txt");

        } // if

    } catch (FileNotFoundException ex) {
             ex.printStackTrace();
    } catch (IOException ex) {
             ex.printStackTrace();
    } catch (ParseException ex) {
             ex.printStackTrace();
    } catch (NullPointerException ex) {
             ex.printStackTrace();
    } catch(Exception ioe) {
            ioe.printStackTrace();
    }

    } // constructionActivities()

    public void constructionChapters() {
    try {

        if(file != null) {

           filePath = "\\docs\\"+file.getFileName();

           FacesMessage message = new FacesMessage("Succesful", filePath + " is uploaded.");
           FacesContext.getCurrentInstance().addMessage(null, message);

           FileTxt f = new FileTxt();

           // read the json file
           FileReader reader = new FileReader(filePath);

           JSONParser jsonParser = new JSONParser();
           JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

           // get an array from the JSON object
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("ConstructionChapters");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String code = (String)relationObj.get("code");
                 String name = (String)relationObj.get("name");

                 ConstructionChapters constructionChapters = new ConstructionChapters();

                 constructionChapters.setCode(code);
                 f.line(constructionChapters.getCode());
                 f.line("");

                 constructionChapters.setName(name);
                 f.line(constructionChapters.getName());
                 f.line("");

                 em.persist(constructionChapters);
                 em.flush();

           } // while

           f.saveFile("\\docs", "constructionChapters.txt");

        } // if

    } catch (FileNotFoundException ex) {
             ex.printStackTrace();
    } catch (IOException ex) {
             ex.printStackTrace();
    } catch (ParseException ex) {
             ex.printStackTrace();
    } catch (NullPointerException ex) {
             ex.printStackTrace();
    } catch(Exception ioe) {
            ioe.printStackTrace();
    }

    } // constructionChapters()

    public void typesMeasurementUnits() {
    try {

        if(file != null) {

           filePath = "\\docs\\"+file.getFileName();

           FacesMessage message = new FacesMessage("Succesful", filePath + " is uploaded.");
           FacesContext.getCurrentInstance().addMessage(null, message);

           FileTxt f = new FileTxt();

           // read the json file
           FileReader reader = new FileReader(filePath);

           JSONParser jsonParser = new JSONParser();
           JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

           // get an array from the JSON object
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("TypesMeasurementUnits");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String code = (String)relationObj.get("code");
                 String name = (String)relationObj.get("name");

                 TypesMeasurementUnits typesMeasurementUnits = new TypesMeasurementUnits();

                 typesMeasurementUnits.setCode(code);
                 f.line(typesMeasurementUnits.getCode());
                 f.line("");

                 typesMeasurementUnits.setName(name);
                 f.line(typesMeasurementUnits.getName());
                 f.line("");

                 em.persist(typesMeasurementUnits);
                 em.flush();

           } // while

           f.saveFile("\\docs", "typesMeasurementUnits.txt");

        } // if

    } catch (FileNotFoundException ex) {
             ex.printStackTrace();
    } catch (IOException ex) {
             ex.printStackTrace();
    } catch (ParseException ex) {
             ex.printStackTrace();
    } catch (NullPointerException ex) {
             ex.printStackTrace();
    } catch(Exception ioe) {
            ioe.printStackTrace();
    }

    } // typesMeasurementUnits()

    public void measurementUnits() {
    try {

        if(file != null) {

           filePath = "\\docs\\"+file.getFileName();

           FacesMessage message = new FacesMessage("Succesful", filePath + " is uploaded.");
           FacesContext.getCurrentInstance().addMessage(null, message);

           FileTxt f = new FileTxt();

           // read the json file
           FileReader reader = new FileReader(filePath);

           JSONParser jsonParser = new JSONParser();
           JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

           // get an array from the JSON object
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("MeasurementUnits");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String code = (String)relationObj.get("code");
                 String name = (String)relationObj.get("name");

                 MeasurementUnits measurementUnits = new MeasurementUnits();

                 measurementUnits.setCode(code);
                 f.line(measurementUnits.getCode());
                 f.line("");

                 measurementUnits.setName(name);
                 f.line(measurementUnits.getName());
                 f.line("");

                 em.persist(measurementUnits);
                 em.flush();

           } // while

           f.saveFile("\\docs", "measurementUnits.txt");

        } // if

    } catch (FileNotFoundException ex) {
             ex.printStackTrace();
    } catch (IOException ex) {
             ex.printStackTrace();
    } catch (ParseException ex) {
             ex.printStackTrace();
    } catch (NullPointerException ex) {
             ex.printStackTrace();
    } catch(Exception ioe) {
            ioe.printStackTrace();
    }

    } // measurementUnits()

    public void years() {
    try {

        if(file != null) {

           filePath = "\\docs\\"+file.getFileName();

           FacesMessage message = new FacesMessage("Succesful", filePath + " is uploaded.");
           FacesContext.getCurrentInstance().addMessage(null, message);

           FileTxt f = new FileTxt();

           // read the json file
           FileReader reader = new FileReader(filePath);

           JSONParser jsonParser = new JSONParser();
           JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

           // get an array from the JSON object
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("Years");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String year = (String)relationObj.get("year");

                 Years years = new Years();

                 years.setYear(year);
                 f.line(years.getYear());
                 f.line("");

                 em.persist(years);
                 em.flush();

           } // while

           f.saveFile("\\docs", "years.txt");

        } // if

    } catch (FileNotFoundException ex) {
             ex.printStackTrace();
    } catch (IOException ex) {
             ex.printStackTrace();
    } catch (ParseException ex) {
             ex.printStackTrace();
    } catch (NullPointerException ex) {
             ex.printStackTrace();
    } catch(Exception ioe) {
            ioe.printStackTrace();
    }

    } // years()

    public void worksConstruction() {
    try {

        if(file != null) {

           filePath = "\\docs\\"+file.getFileName();

           FacesMessage message = new FacesMessage("Succesful", filePath + " is uploaded.");
           FacesContext.getCurrentInstance().addMessage(null, message);

           FileTxt f = new FileTxt();

           // read the json file
           FileReader reader = new FileReader(filePath);

           JSONParser jsonParser = new JSONParser();
           JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

           // get an array from the JSON object
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("WorksConstruction");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String code = (String)relationObj.get("code");
                 String name = (String)relationObj.get("name");

                 WorksConstruction worksConstruction = new WorksConstruction();

                 worksConstruction.setCode(code);
                 f.line(worksConstruction.getCode());
                 f.line("");

                 worksConstruction.setName(name);
                 f.line(worksConstruction.getName());
                 f.line("");

                 em.persist(worksConstruction);
                 em.flush();

           } // while

           f.saveFile("\\docs", "worksConstruction.txt");

        } // if

    } catch (FileNotFoundException ex) {
             ex.printStackTrace();
    } catch (IOException ex) {
             ex.printStackTrace();
    } catch (ParseException ex) {
             ex.printStackTrace();
    } catch (NullPointerException ex) {
             ex.printStackTrace();
    } catch(Exception ioe) {
            ioe.printStackTrace();
    }

    } // worksConstruction()

    public void typesWorksConstruction() {
    try {

        if(file != null) {

           filePath = "\\docs\\"+file.getFileName();

           FacesMessage message = new FacesMessage("Succesful", filePath + " is uploaded.");
           FacesContext.getCurrentInstance().addMessage(null, message);

           FileTxt f = new FileTxt();

           // read the json file
           FileReader reader = new FileReader(filePath);

           JSONParser jsonParser = new JSONParser();
           JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

           // get an array from the JSON object
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("TypesWorksConstruction");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String code = (String)relationObj.get("code");
                 String name = (String)relationObj.get("name");

                 TypesWorksConstruction typesWorksConstruction = new TypesWorksConstruction();

                 typesWorksConstruction.setCode(code);
                 f.line(typesWorksConstruction.getCode());
                 f.line("");

                 typesWorksConstruction.setName(name);
                 f.line(typesWorksConstruction.getName());
                 f.line("");

                 em.persist(typesWorksConstruction);
                 em.flush();

           } // while

           f.saveFile("\\docs", "typesWorksConstruction.txt");

        } // if

    } catch (FileNotFoundException ex) {
             ex.printStackTrace();
    } catch (IOException ex) {
             ex.printStackTrace();
    } catch (ParseException ex) {
             ex.printStackTrace();
    } catch (NullPointerException ex) {
             ex.printStackTrace();
    } catch(Exception ioe) {
            ioe.printStackTrace();
    }

    } // typesWorksConstruction()

    public void budgets() {
    try {

        if(file != null) {

           filePath = "\\docs\\"+file.getFileName();

           FacesMessage message = new FacesMessage("Succesful", filePath + " is uploaded.");
           FacesContext.getCurrentInstance().addMessage(null, message);

           FileTxt f = new FileTxt();

           // read the json file
           FileReader reader = new FileReader(filePath);

           JSONParser jsonParser = new JSONParser();
           JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

           // get an array from the JSON object
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("Budgets");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();


                 Budgets budgets = new Budgets();

                 em.persist(budgets);
                 em.flush();

           } // while

           f.saveFile("\\docs", "budgets.txt");

        } // if

    } catch (FileNotFoundException ex) {
             ex.printStackTrace();
    } catch (IOException ex) {
             ex.printStackTrace();
    } catch (ParseException ex) {
             ex.printStackTrace();
    } catch (NullPointerException ex) {
             ex.printStackTrace();
    } catch(Exception ioe) {
            ioe.printStackTrace();
    }

    } // budgets()

    public void workActivities() {
    try {

        if(file != null) {

           filePath = "\\docs\\"+file.getFileName();

           FacesMessage message = new FacesMessage("Succesful", filePath + " is uploaded.");
           FacesContext.getCurrentInstance().addMessage(null, message);

           FileTxt f = new FileTxt();

           // read the json file
           FileReader reader = new FileReader(filePath);

           JSONParser jsonParser = new JSONParser();
           JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

           // get an array from the JSON object
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("WorkActivities");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String code = (String)relationObj.get("code");
                 String name = (String)relationObj.get("name");

                 WorkActivities workActivities = new WorkActivities();

                 workActivities.setCode(code);
                 f.line(workActivities.getCode());
                 f.line("");

                 workActivities.setName(name);
                 f.line(workActivities.getName());
                 f.line("");

                 em.persist(workActivities);
                 em.flush();

           } // while

           f.saveFile("\\docs", "workActivities.txt");

        } // if

    } catch (FileNotFoundException ex) {
             ex.printStackTrace();
    } catch (IOException ex) {
             ex.printStackTrace();
    } catch (ParseException ex) {
             ex.printStackTrace();
    } catch (NullPointerException ex) {
             ex.printStackTrace();
    } catch(Exception ioe) {
            ioe.printStackTrace();
    }

    } // workActivities()

    public void constructionMaterials() {
    try {

        if(file != null) {

           filePath = "\\docs\\"+file.getFileName();

           FacesMessage message = new FacesMessage("Succesful", filePath + " is uploaded.");
           FacesContext.getCurrentInstance().addMessage(null, message);

           FileTxt f = new FileTxt();

           // read the json file
           FileReader reader = new FileReader(filePath);

           JSONParser jsonParser = new JSONParser();
           JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

           // get an array from the JSON object
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("ConstructionMaterials");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String code = (String)relationObj.get("code");
                 String name = (String)relationObj.get("name");

                 ConstructionMaterials constructionMaterials = new ConstructionMaterials();

                 constructionMaterials.setCode(code);
                 f.line(constructionMaterials.getCode());
                 f.line("");

                 constructionMaterials.setName(name);
                 f.line(constructionMaterials.getName());
                 f.line("");

                 em.persist(constructionMaterials);
                 em.flush();

           } // while

           f.saveFile("\\docs", "constructionMaterials.txt");

        } // if

    } catch (FileNotFoundException ex) {
             ex.printStackTrace();
    } catch (IOException ex) {
             ex.printStackTrace();
    } catch (ParseException ex) {
             ex.printStackTrace();
    } catch (NullPointerException ex) {
             ex.printStackTrace();
    } catch(Exception ioe) {
            ioe.printStackTrace();
    }

    } // constructionMaterials()

    public void constructionTransports() {
    try {

        if(file != null) {

           filePath = "\\docs\\"+file.getFileName();

           FacesMessage message = new FacesMessage("Succesful", filePath + " is uploaded.");
           FacesContext.getCurrentInstance().addMessage(null, message);

           FileTxt f = new FileTxt();

           // read the json file
           FileReader reader = new FileReader(filePath);

           JSONParser jsonParser = new JSONParser();
           JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

           // get an array from the JSON object
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("ConstructionTransports");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String code = (String)relationObj.get("code");
                 String name = (String)relationObj.get("name");

                 ConstructionTransports constructionTransports = new ConstructionTransports();

                 constructionTransports.setCode(code);
                 f.line(constructionTransports.getCode());
                 f.line("");

                 constructionTransports.setName(name);
                 f.line(constructionTransports.getName());
                 f.line("");

                 em.persist(constructionTransports);
                 em.flush();

           } // while

           f.saveFile("\\docs", "constructionTransports.txt");

        } // if

    } catch (FileNotFoundException ex) {
             ex.printStackTrace();
    } catch (IOException ex) {
             ex.printStackTrace();
    } catch (ParseException ex) {
             ex.printStackTrace();
    } catch (NullPointerException ex) {
             ex.printStackTrace();
    } catch(Exception ioe) {
            ioe.printStackTrace();
    }

    } // constructionTransports()

    public void constructionWorkforce() {
    try {

        if(file != null) {

           filePath = "\\docs\\"+file.getFileName();

           FacesMessage message = new FacesMessage("Succesful", filePath + " is uploaded.");
           FacesContext.getCurrentInstance().addMessage(null, message);

           FileTxt f = new FileTxt();

           // read the json file
           FileReader reader = new FileReader(filePath);

           JSONParser jsonParser = new JSONParser();
           JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

           // get an array from the JSON object
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("ConstructionWorkforce");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String code = (String)relationObj.get("code");
                 String name = (String)relationObj.get("name");

                 ConstructionWorkforce constructionWorkforce = new ConstructionWorkforce();

                 constructionWorkforce.setCode(code);
                 f.line(constructionWorkforce.getCode());
                 f.line("");

                 constructionWorkforce.setName(name);
                 f.line(constructionWorkforce.getName());
                 f.line("");

                 em.persist(constructionWorkforce);
                 em.flush();

           } // while

           f.saveFile("\\docs", "constructionWorkforce.txt");

        } // if

    } catch (FileNotFoundException ex) {
             ex.printStackTrace();
    } catch (IOException ex) {
             ex.printStackTrace();
    } catch (ParseException ex) {
             ex.printStackTrace();
    } catch (NullPointerException ex) {
             ex.printStackTrace();
    } catch(Exception ioe) {
            ioe.printStackTrace();
    }

    } // constructionWorkforce()

    public void constructionEquipments() {
    try {

        if(file != null) {

           filePath = "\\docs\\"+file.getFileName();

           FacesMessage message = new FacesMessage("Succesful", filePath + " is uploaded.");
           FacesContext.getCurrentInstance().addMessage(null, message);

           FileTxt f = new FileTxt();

           // read the json file
           FileReader reader = new FileReader(filePath);

           JSONParser jsonParser = new JSONParser();
           JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

           // get an array from the JSON object
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("ConstructionEquipments");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String code = (String)relationObj.get("code");
                 String name = (String)relationObj.get("name");

                 ConstructionEquipments constructionEquipments = new ConstructionEquipments();

                 constructionEquipments.setCode(code);
                 f.line(constructionEquipments.getCode());
                 f.line("");

                 constructionEquipments.setName(name);
                 f.line(constructionEquipments.getName());
                 f.line("");

                 em.persist(constructionEquipments);
                 em.flush();

           } // while

           f.saveFile("\\docs", "constructionEquipments.txt");

        } // if

    } catch (FileNotFoundException ex) {
             ex.printStackTrace();
    } catch (IOException ex) {
             ex.printStackTrace();
    } catch (ParseException ex) {
             ex.printStackTrace();
    } catch (NullPointerException ex) {
             ex.printStackTrace();
    } catch(Exception ioe) {
            ioe.printStackTrace();
    }

    } // constructionEquipments()

    public void typesConstructionMaterials() {
    try {

        if(file != null) {

           filePath = "\\docs\\"+file.getFileName();

           FacesMessage message = new FacesMessage("Succesful", filePath + " is uploaded.");
           FacesContext.getCurrentInstance().addMessage(null, message);

           FileTxt f = new FileTxt();

           // read the json file
           FileReader reader = new FileReader(filePath);

           JSONParser jsonParser = new JSONParser();
           JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

           // get an array from the JSON object
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("TypesConstructionMaterials");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String code = (String)relationObj.get("code");
                 String name = (String)relationObj.get("name");

                 TypesConstructionMaterials typesConstructionMaterials = new TypesConstructionMaterials();

                 typesConstructionMaterials.setCode(code);
                 f.line(typesConstructionMaterials.getCode());
                 f.line("");

                 typesConstructionMaterials.setName(name);
                 f.line(typesConstructionMaterials.getName());
                 f.line("");

                 em.persist(typesConstructionMaterials);
                 em.flush();

           } // while

           f.saveFile("\\docs", "typesConstructionMaterials.txt");

        } // if

    } catch (FileNotFoundException ex) {
             ex.printStackTrace();
    } catch (IOException ex) {
             ex.printStackTrace();
    } catch (ParseException ex) {
             ex.printStackTrace();
    } catch (NullPointerException ex) {
             ex.printStackTrace();
    } catch(Exception ioe) {
            ioe.printStackTrace();
    }

    } // typesConstructionMaterials()

    public void typesConstructionTransports() {
    try {

        if(file != null) {

           filePath = "\\docs\\"+file.getFileName();

           FacesMessage message = new FacesMessage("Succesful", filePath + " is uploaded.");
           FacesContext.getCurrentInstance().addMessage(null, message);

           FileTxt f = new FileTxt();

           // read the json file
           FileReader reader = new FileReader(filePath);

           JSONParser jsonParser = new JSONParser();
           JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

           // get an array from the JSON object
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("TypesConstructionTransports");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String code = (String)relationObj.get("code");
                 String name = (String)relationObj.get("name");

                 TypesConstructionTransports typesConstructionTransports = new TypesConstructionTransports();

                 typesConstructionTransports.setCode(code);
                 f.line(typesConstructionTransports.getCode());
                 f.line("");

                 typesConstructionTransports.setName(name);
                 f.line(typesConstructionTransports.getName());
                 f.line("");

                 em.persist(typesConstructionTransports);
                 em.flush();

           } // while

           f.saveFile("\\docs", "typesConstructionTransports.txt");

        } // if

    } catch (FileNotFoundException ex) {
             ex.printStackTrace();
    } catch (IOException ex) {
             ex.printStackTrace();
    } catch (ParseException ex) {
             ex.printStackTrace();
    } catch (NullPointerException ex) {
             ex.printStackTrace();
    } catch(Exception ioe) {
            ioe.printStackTrace();
    }

    } // typesConstructionTransports()

    public void typesConstructionWorkforce() {
    try {

        if(file != null) {

           filePath = "\\docs\\"+file.getFileName();

           FacesMessage message = new FacesMessage("Succesful", filePath + " is uploaded.");
           FacesContext.getCurrentInstance().addMessage(null, message);

           FileTxt f = new FileTxt();

           // read the json file
           FileReader reader = new FileReader(filePath);

           JSONParser jsonParser = new JSONParser();
           JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

           // get an array from the JSON object
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("TypesConstructionWorkforce");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String code = (String)relationObj.get("code");
                 String name = (String)relationObj.get("name");

                 TypesConstructionWorkforce typesConstructionWorkforce = new TypesConstructionWorkforce();

                 typesConstructionWorkforce.setCode(code);
                 f.line(typesConstructionWorkforce.getCode());
                 f.line("");

                 typesConstructionWorkforce.setName(name);
                 f.line(typesConstructionWorkforce.getName());
                 f.line("");

                 em.persist(typesConstructionWorkforce);
                 em.flush();

           } // while

           f.saveFile("\\docs", "typesConstructionWorkforce.txt");

        } // if

    } catch (FileNotFoundException ex) {
             ex.printStackTrace();
    } catch (IOException ex) {
             ex.printStackTrace();
    } catch (ParseException ex) {
             ex.printStackTrace();
    } catch (NullPointerException ex) {
             ex.printStackTrace();
    } catch(Exception ioe) {
            ioe.printStackTrace();
    }

    } // typesConstructionWorkforce()

    public void typesConstructionEquipments() {
    try {

        if(file != null) {

           filePath = "\\docs\\"+file.getFileName();

           FacesMessage message = new FacesMessage("Succesful", filePath + " is uploaded.");
           FacesContext.getCurrentInstance().addMessage(null, message);

           FileTxt f = new FileTxt();

           // read the json file
           FileReader reader = new FileReader(filePath);

           JSONParser jsonParser = new JSONParser();
           JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

           // get an array from the JSON object
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("TypesConstructionEquipments");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String code = (String)relationObj.get("code");
                 String name = (String)relationObj.get("name");

                 TypesConstructionEquipments typesConstructionEquipments = new TypesConstructionEquipments();

                 typesConstructionEquipments.setCode(code);
                 f.line(typesConstructionEquipments.getCode());
                 f.line("");

                 typesConstructionEquipments.setName(name);
                 f.line(typesConstructionEquipments.getName());
                 f.line("");

                 em.persist(typesConstructionEquipments);
                 em.flush();

           } // while

           f.saveFile("\\docs", "typesConstructionEquipments.txt");

        } // if

    } catch (FileNotFoundException ex) {
             ex.printStackTrace();
    } catch (IOException ex) {
             ex.printStackTrace();
    } catch (ParseException ex) {
             ex.printStackTrace();
    } catch (NullPointerException ex) {
             ex.printStackTrace();
    } catch(Exception ioe) {
            ioe.printStackTrace();
    }

    } // typesConstructionEquipments()

}

