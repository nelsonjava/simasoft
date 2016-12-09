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

    @PersistenceContext(unitName = "crmNaifgPU-JTA")
    private EntityManager em;

    FindBean findBean = new FindBean();

    private UploadedFile file;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public void fundsLife() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("FundsLife");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String name = (String)relationObj.get("name");

                 FundsLife fundsLife = new FundsLife();

                 fundsLife.setName(name);
                 f.line(fundsLife.getName());
                 f.line("");

                 em.persist(fundsLife);
                 em.flush();

           } // while

           f.saveFile("\\docs", "fundsLife.txt");

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

    } // fundsLife()

    public void funds() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("Funds");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String name = (String)relationObj.get("name");
                 String code = (String)relationObj.get("code");

                 Funds funds = new Funds();

                 funds.setName(name);
                 f.line(funds.getName());
                 f.line("");

                 funds.setCode(code);
                 f.line(funds.getCode());
                 f.line("");

                 em.persist(funds);
                 em.flush();

           } // while

           f.saveFile("\\docs", "funds.txt");

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

    } // funds()

    public void sectionsTypes() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("SectionsTypes");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String name = (String)relationObj.get("name");

                 SectionsTypes sectionsTypes = new SectionsTypes();

                 sectionsTypes.setName(name);
                 f.line(sectionsTypes.getName());
                 f.line("");

                 em.persist(sectionsTypes);
                 em.flush();

           } // while

           f.saveFile("\\docs", "sectionsTypes.txt");

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

    } // sectionsTypes()

    public void sections() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("Sections");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String name = (String)relationObj.get("name");
                 String code = (String)relationObj.get("code");
                 String dir = (String)relationObj.get("dir");

                 Sections sections = new Sections();

                 sections.setName(name);
                 f.line(sections.getName());
                 f.line("");

                 sections.setCode(code);
                 f.line(sections.getCode());
                 f.line("");

                 sections.setDir(dir);
                 f.line(sections.getDir());
                 f.line("");

                 em.persist(sections);
                 em.flush();

           } // while

           f.saveFile("\\docs", "sections.txt");

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

    } // sections()

    public void series() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("Series");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String name = (String)relationObj.get("name");
                 String code = (String)relationObj.get("code");
                 String located = (String)relationObj.get("located");
                 String procedures = (String)relationObj.get("procedures");
                 String dir = (String)relationObj.get("dir");

                 Series series = new Series();

                 series.setName(name);
                 f.line(series.getName());
                 f.line("");

                 series.setCode(code);
                 f.line(series.getCode());
                 f.line("");

                 series.setLocated(located);
                 f.line(series.getLocated());
                 f.line("");

                 series.setProcedures(procedures);
                 f.line(series.getProcedures());
                 f.line("");

                 series.setDir(dir);
                 f.line(series.getDir());
                 f.line("");

                 em.persist(series);
                 em.flush();

           } // while

           f.saveFile("\\docs", "series.txt");

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

    } // series()

    public void trdSeries() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("TrdSeries");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String name = (String)relationObj.get("name");

                 TrdSeries trdSeries = new TrdSeries();

                 trdSeries.setName(name);
                 f.line(trdSeries.getName());
                 f.line("");

                 em.persist(trdSeries);
                 em.flush();

           } // while

           f.saveFile("\\docs", "trdSeries.txt");

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

    } // trdSeries()

    public void trd() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("Trd");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String name = (String)relationObj.get("name");

                 Trd trd = new Trd();

                 trd.setName(name);
                 f.line(trd.getName());
                 f.line("");

                 em.persist(trd);
                 em.flush();

           } // while

           f.saveFile("\\docs", "trd.txt");

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

    } // trd()

    public void finalDisposition() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("FinalDisposition");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String name = (String)relationObj.get("name");

                 FinalDisposition finalDisposition = new FinalDisposition();

                 finalDisposition.setName(name);
                 f.line(finalDisposition.getName());
                 f.line("");

                 em.persist(finalDisposition);
                 em.flush();

           } // while

           f.saveFile("\\docs", "finalDisposition.txt");

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

    } // finalDisposition()

    public void documentalRetention() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("DocumentalRetention");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String name = (String)relationObj.get("name");

                 DocumentalRetention documentalRetention = new DocumentalRetention();

                 documentalRetention.setName(name);
                 f.line(documentalRetention.getName());
                 f.line("");

                 em.persist(documentalRetention);
                 em.flush();

           } // while

           f.saveFile("\\docs", "documentalRetention.txt");

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

    } // documentalRetention()

    public void frequentlyQuery() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("FrequentlyQuery");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String name = (String)relationObj.get("name");

                 FrequentlyQuery frequentlyQuery = new FrequentlyQuery();

                 frequentlyQuery.setName(name);
                 f.line(frequentlyQuery.getName());
                 f.line("");

                 em.persist(frequentlyQuery);
                 em.flush();

           } // while

           f.saveFile("\\docs", "frequentlyQuery.txt");

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

    } // frequentlyQuery()

    public void documentalsUnits() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("DocumentalsUnits");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String name = (String)relationObj.get("name");
                 String code = (String)relationObj.get("code");

                 DocumentalsUnits documentalsUnits = new DocumentalsUnits();

                 documentalsUnits.setName(name);
                 f.line(documentalsUnits.getName());
                 f.line("");

                 documentalsUnits.setCode(code);
                 f.line(documentalsUnits.getCode());
                 f.line("");

                 em.persist(documentalsUnits);
                 em.flush();

           } // while

           f.saveFile("\\docs", "documentalsUnits.txt");

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

    } // documentalsUnits()

    public void conservationUnits() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("ConservationUnits");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String name = (String)relationObj.get("name");
                 String code = (String)relationObj.get("code");

                 ConservationUnits conservationUnits = new ConservationUnits();

                 conservationUnits.setName(name);
                 f.line(conservationUnits.getName());
                 f.line("");

                 conservationUnits.setCode(code);
                 f.line(conservationUnits.getCode());
                 f.line("");

                 em.persist(conservationUnits);
                 em.flush();

           } // while

           f.saveFile("\\docs", "conservationUnits.txt");

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

    } // conservationUnits()

    public void versionsControls() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("VersionsControls");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String name = (String)relationObj.get("name");
                 String code = (String)relationObj.get("code");
                 String version = (String)relationObj.get("version");
                 String request = (String)relationObj.get("request");
                 String responsible = (String)relationObj.get("responsible");
                 String description = (String)relationObj.get("description");

                 VersionsControls versionsControls = new VersionsControls();

                 versionsControls.setName(name);
                 f.line(versionsControls.getName());
                 f.line("");

                 versionsControls.setCode(code);
                 f.line(versionsControls.getCode());
                 f.line("");

                 versionsControls.setVersion(version);
                 f.line(versionsControls.getVersion());
                 f.line("");

                 versionsControls.setRequest(request);
                 f.line(versionsControls.getRequest());
                 f.line("");

                 versionsControls.setResponsible(responsible);
                 f.line(versionsControls.getResponsible());
                 f.line("");

                 versionsControls.setDescription(description);
                 f.line(versionsControls.getDescription());
                 f.line("");

                 em.persist(versionsControls);
                 em.flush();

           } // while

           f.saveFile("\\docs", "versionsControls.txt");

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

    } // versionsControls()

    public void documentalInventory() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("DocumentalInventory");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String object = (String)relationObj.get("object");

                 DocumentalInventory documentalInventory = new DocumentalInventory();

                 documentalInventory.setObject(object);
                 f.line(documentalInventory.getObject());
                 f.line("");

                 em.persist(documentalInventory);
                 em.flush();

           } // while

           f.saveFile("\\docs", "documentalInventory.txt");

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

    } // documentalInventory()

    public void originalOrders() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("OriginalOrders");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String subject = (String)relationObj.get("subject");
                 String code = (String)relationObj.get("code");
                 String located = (String)relationObj.get("located");
                 String mail = (String)relationObj.get("mail");
                 String notes = (String)relationObj.get("notes");
                 String fileName = (String)relationObj.get("fileName");
                 String fileType = (String)relationObj.get("fileType");
                 String filedir = (String)relationObj.get("filedir");

                 OriginalOrders originalOrders = new OriginalOrders();

                 originalOrders.setSubject(subject);
                 f.line(originalOrders.getSubject());
                 f.line("");

                 originalOrders.setCode(code);
                 f.line(originalOrders.getCode());
                 f.line("");

                 originalOrders.setLocated(located);
                 f.line(originalOrders.getLocated());
                 f.line("");

                 originalOrders.setMail(mail);
                 f.line(originalOrders.getMail());
                 f.line("");

                 originalOrders.setNotes(notes);
                 f.line(originalOrders.getNotes());
                 f.line("");

                 originalOrders.setFileName(fileName);
                 f.line(originalOrders.getFileName());
                 f.line("");

                 originalOrders.setFileType(fileType);
                 f.line(originalOrders.getFileType());
                 f.line("");

                 originalOrders.setFiledir(filedir);
                 f.line(originalOrders.getFiledir());
                 f.line("");

                 em.persist(originalOrders);
                 em.flush();

           } // while

           f.saveFile("\\docs", "originalOrders.txt");

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

    } // originalOrders()

    public void documentalsUnitsTypes() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("DocumentalsUnitsTypes");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String name = (String)relationObj.get("name");

                 DocumentalsUnitsTypes documentalsUnitsTypes = new DocumentalsUnitsTypes();

                 documentalsUnitsTypes.setName(name);
                 f.line(documentalsUnitsTypes.getName());
                 f.line("");

                 em.persist(documentalsUnitsTypes);
                 em.flush();

           } // while

           f.saveFile("\\docs", "documentalsUnitsTypes.txt");

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

    } // documentalsUnitsTypes()

    public void access() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("Access");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String name = (String)relationObj.get("name");

                 Access access = new Access();

                 access.setName(name);
                 f.line(access.getName());
                 f.line("");

                 em.persist(access);
                 em.flush();

           } // while

           f.saveFile("\\docs", "access.txt");

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

    } // access()

    public void organizeds() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("Organizeds");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String name = (String)relationObj.get("name");

                 Organizeds organizeds = new Organizeds();

                 organizeds.setName(name);
                 f.line(organizeds.getName());
                 f.line("");

                 em.persist(organizeds);
                 em.flush();

           } // while

           f.saveFile("\\docs", "organizeds.txt");

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

    } // organizeds()

    public void inventoryFinality() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("InventoryFinality");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String name = (String)relationObj.get("name");

                 InventoryFinality inventoryFinality = new InventoryFinality();

                 inventoryFinality.setName(name);
                 f.line(inventoryFinality.getName());
                 f.line("");

                 em.persist(inventoryFinality);
                 em.flush();

           } // while

           f.saveFile("\\docs", "inventoryFinality.txt");

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

    } // inventoryFinality()

    public void documentalsSupports() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("DocumentalsSupports");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String name = (String)relationObj.get("name");
                 String code = (String)relationObj.get("code");

                 DocumentalsSupports documentalsSupports = new DocumentalsSupports();

                 documentalsSupports.setName(name);
                 f.line(documentalsSupports.getName());
                 f.line("");

                 documentalsSupports.setCode(code);
                 f.line(documentalsSupports.getCode());
                 f.line("");

                 em.persist(documentalsSupports);
                 em.flush();

           } // while

           f.saveFile("\\docs", "documentalsSupports.txt");

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

    } // documentalsSupports()

    public void conservationUnitsTypes() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("ConservationUnitsTypes");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String name = (String)relationObj.get("name");

                 ConservationUnitsTypes conservationUnitsTypes = new ConservationUnitsTypes();

                 conservationUnitsTypes.setName(name);
                 f.line(conservationUnitsTypes.getName());
                 f.line("");

                 em.persist(conservationUnitsTypes);
                 em.flush();

           } // while

           f.saveFile("\\docs", "conservationUnitsTypes.txt");

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

    } // conservationUnitsTypes()

    public void booksTypes() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("BooksTypes");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String name = (String)relationObj.get("name");

                 BooksTypes booksTypes = new BooksTypes();

                 booksTypes.setName(name);
                 f.line(booksTypes.getName());
                 f.line("");

                 em.persist(booksTypes);
                 em.flush();

           } // while

           f.saveFile("\\docs", "booksTypes.txt");

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

    } // booksTypes()

    public void books() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("Books");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String code = (String)relationObj.get("code");
                 String name = (String)relationObj.get("name");

                 Books books = new Books();

                 books.setCode(code);
                 f.line(books.getCode());
                 f.line("");

                 books.setName(name);
                 f.line(books.getName());
                 f.line("");

                 em.persist(books);
                 em.flush();

           } // while

           f.saveFile("\\docs", "books.txt");

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

    } // books()

    public void chapters() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("Chapters");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String code = (String)relationObj.get("code");
                 String name = (String)relationObj.get("name");

                 Chapters chapters = new Chapters();

                 chapters.setCode(code);
                 f.line(chapters.getCode());
                 f.line("");

                 chapters.setName(name);
                 f.line(chapters.getName());
                 f.line("");

                 em.persist(chapters);
                 em.flush();

           } // while

           f.saveFile("\\docs", "chapters.txt");

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

    } // chapters()

    public void brands() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("Brands");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String name = (String)relationObj.get("name");

                 Brands brands = new Brands();

                 brands.setName(name);
                 f.line(brands.getName());
                 f.line("");

                 em.persist(brands);
                 em.flush();

           } // while

           f.saveFile("\\docs", "brands.txt");

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

    } // brands()

    public void companies() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("Companies");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String name = (String)relationObj.get("name");

                 Companies companies = new Companies();

                 companies.setName(name);
                 f.line(companies.getName());
                 f.line("");

                 em.persist(companies);
                 em.flush();

           } // while

           f.saveFile("\\docs", "companies.txt");

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

    } // companies()

    public void employeesTypes() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("EmployeesTypes");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String name = (String)relationObj.get("name");

                 EmployeesTypes employeesTypes = new EmployeesTypes();

                 employeesTypes.setName(name);
                 f.line(employeesTypes.getName());
                 f.line("");

                 em.persist(employeesTypes);
                 em.flush();

           } // while

           f.saveFile("\\docs", "employeesTypes.txt");

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

    } // employeesTypes()

    public void employees() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("Employees");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String code = (String)relationObj.get("code");

                 Employees employees = new Employees();

                 employees.setCode(code);
                 f.line(employees.getCode());
                 f.line("");

                 em.persist(employees);
                 em.flush();

           } // while

           f.saveFile("\\docs", "employees.txt");

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

    } // employees()

    public void companiesRolesTypes() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("CompaniesRolesTypes");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String name = (String)relationObj.get("name");

                 CompaniesRolesTypes companiesRolesTypes = new CompaniesRolesTypes();

                 companiesRolesTypes.setName(name);
                 f.line(companiesRolesTypes.getName());
                 f.line("");

                 em.persist(companiesRolesTypes);
                 em.flush();

           } // while

           f.saveFile("\\docs", "companiesRolesTypes.txt");

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

    } // companiesRolesTypes()

    public void companiesRoles() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("CompaniesRoles");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String name = (String)relationObj.get("name");

                 CompaniesRoles companiesRoles = new CompaniesRoles();

                 companiesRoles.setName(name);
                 f.line(companiesRoles.getName());
                 f.line("");

                 em.persist(companiesRoles);
                 em.flush();

           } // while

           f.saveFile("\\docs", "companiesRoles.txt");

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

    } // companiesRoles()

    public void chargesTypes() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("ChargesTypes");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String name = (String)relationObj.get("name");

                 ChargesTypes chargesTypes = new ChargesTypes();

                 chargesTypes.setName(name);
                 f.line(chargesTypes.getName());
                 f.line("");

                 em.persist(chargesTypes);
                 em.flush();

           } // while

           f.saveFile("\\docs", "chargesTypes.txt");

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

    } // chargesTypes()

    public void charges() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("Charges");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String name = (String)relationObj.get("name");

                 Charges charges = new Charges();

                 charges.setName(name);
                 f.line(charges.getName());
                 f.line("");

                 em.persist(charges);
                 em.flush();

           } // while

           f.saveFile("\\docs", "charges.txt");

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

    } // charges()

    public void pom() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("Pom");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String groupId = (String)relationObj.get("groupId");
                 String artifactId = (String)relationObj.get("artifactId");
                 String version = (String)relationObj.get("version");

                 Pom pom = new Pom();

                 pom.setGroupId(groupId);
                 f.line(pom.getGroupId());
                 f.line("");

                 pom.setArtifactId(artifactId);
                 f.line(pom.getArtifactId());
                 f.line("");

                 pom.setVersion(version);
                 f.line(pom.getVersion());
                 f.line("");

                 em.persist(pom);
                 em.flush();

           } // while

           f.saveFile("\\docs", "pom.txt");

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

    } // pom()

    public void dependencies() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("Dependencies");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String groupId = (String)relationObj.get("groupId");
                 String artifactId = (String)relationObj.get("artifactId");
                 String version = (String)relationObj.get("version");
                 String type = (String)relationObj.get("type");
                 String scope = (String)relationObj.get("scope");
                 String maven = (String)relationObj.get("maven");

                 Dependencies dependencies = new Dependencies();

                 dependencies.setGroupId(groupId);
                 f.line(dependencies.getGroupId());
                 f.line("");

                 dependencies.setArtifactId(artifactId);
                 f.line(dependencies.getArtifactId());
                 f.line("");

                 dependencies.setVersion(version);
                 f.line(dependencies.getVersion());
                 f.line("");

                 dependencies.setType(type);
                 f.line(dependencies.getType());
                 f.line("");

                 dependencies.setScope(scope);
                 f.line(dependencies.getScope());
                 f.line("");

                 dependencies.setMaven(maven);
                 f.line(dependencies.getMaven());
                 f.line("");

                 em.persist(dependencies);
                 em.flush();

           } // while

           f.saveFile("\\docs", "dependencies.txt");

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

    } // dependencies()

    public void imports() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("Imports");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String name = (String)relationObj.get("name");

                 Imports imports = new Imports();

                 imports.setName(name);
                 f.line(imports.getName());
                 f.line("");

                 em.persist(imports);
                 em.flush();

           } // while

           f.saveFile("\\docs", "imports.txt");

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

    } // imports()

    public void attributesProperties() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("AttributesProperties");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String name = (String)relationObj.get("name");
                 String value = (String)relationObj.get("value");

                 AttributesProperties attributesProperties = new AttributesProperties();

                 attributesProperties.setName(name);
                 f.line(attributesProperties.getName());
                 f.line("");

                 attributesProperties.setValue(value);
                 f.line(attributesProperties.getValue());
                 f.line("");

                 em.persist(attributesProperties);
                 em.flush();

           } // while

           f.saveFile("\\docs", "attributesProperties.txt");

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

    } // attributesProperties()

    public void attributesTypes() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("AttributesTypes");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String name = (String)relationObj.get("name");
                 String type = (String)relationObj.get("type");
                 String annotations = (String)relationObj.get("annotations");

                 AttributesTypes attributesTypes = new AttributesTypes();

                 attributesTypes.setName(name);
                 f.line(attributesTypes.getName());
                 f.line("");

                 attributesTypes.setType(type);
                 f.line(attributesTypes.getType());
                 f.line("");

                 attributesTypes.setAnnotations(annotations);
                 f.line(attributesTypes.getAnnotations());
                 f.line("");

                 em.persist(attributesTypes);
                 em.flush();

           } // while

           f.saveFile("\\docs", "attributesTypes.txt");

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

    } // attributesTypes()

    public void fields() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("Fields");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String name = (String)relationObj.get("name");
                 String description = (String)relationObj.get("description");

                 Fields fields = new Fields();

                 fields.setName(name);
                 f.line(fields.getName());
                 f.line("");

                 fields.setDescription(description);
                 f.line(fields.getDescription());
                 f.line("");

                 em.persist(fields);
                 em.flush();

           } // while

           f.saveFile("\\docs", "fields.txt");

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

    } // fields()

    public void improvementTypes() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("ImprovementTypes");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String name = (String)relationObj.get("name");

                 ImprovementTypes improvementTypes = new ImprovementTypes();

                 improvementTypes.setName(name);
                 f.line(improvementTypes.getName());
                 f.line("");

                 em.persist(improvementTypes);
                 em.flush();

           } // while

           f.saveFile("\\docs", "improvementTypes.txt");

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

    } // improvementTypes()

    public void improvementSources() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("ImprovementSources");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String name = (String)relationObj.get("name");

                 ImprovementSources improvementSources = new ImprovementSources();

                 improvementSources.setName(name);
                 f.line(improvementSources.getName());
                 f.line("");

                 em.persist(improvementSources);
                 em.flush();

           } // while

           f.saveFile("\\docs", "improvementSources.txt");

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

    } // improvementSources()

    public void continualImprovements() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("ContinualImprovements");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String code = (String)relationObj.get("code");
                 String description = (String)relationObj.get("description");
                 String causesAnalysis = (String)relationObj.get("causesAnalysis");
                 String rootCause = (String)relationObj.get("rootCause");
                 String immediateCorrection = (String)relationObj.get("immediateCorrection");

                 ContinualImprovements continualImprovements = new ContinualImprovements();

                 continualImprovements.setCode(code);
                 f.line(continualImprovements.getCode());
                 f.line("");

                 continualImprovements.setDescription(description);
                 f.line(continualImprovements.getDescription());
                 f.line("");

                 continualImprovements.setCausesAnalysis(causesAnalysis);
                 f.line(continualImprovements.getCausesAnalysis());
                 f.line("");

                 continualImprovements.setRootCause(rootCause);
                 f.line(continualImprovements.getRootCause());
                 f.line("");

                 continualImprovements.setImmediateCorrection(immediateCorrection);
                 f.line(continualImprovements.getImmediateCorrection());
                 f.line("");

                 em.persist(continualImprovements);
                 em.flush();

           } // while

           f.saveFile("\\docs", "continualImprovements.txt");

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

    } // continualImprovements()

    public void actionPlans() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("ActionPlans");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String evidences = (String)relationObj.get("evidences");

                 ActionPlans actionPlans = new ActionPlans();

                 actionPlans.setEvidences(evidences);
                 f.line(actionPlans.getEvidences());
                 f.line("");

                 em.persist(actionPlans);
                 em.flush();

           } // while

           f.saveFile("\\docs", "actionPlans.txt");

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

    } // actionPlans()

    public void improvementVerifications() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("ImprovementVerifications");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();


                 ImprovementVerifications improvementVerifications = new ImprovementVerifications();

                 em.persist(improvementVerifications);
                 em.flush();

           } // while

           f.saveFile("\\docs", "improvementVerifications.txt");

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

    } // improvementVerifications()

    public void improvementClosures() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("ImprovementClosures");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();


                 ImprovementClosures improvementClosures = new ImprovementClosures();

                 em.persist(improvementClosures);
                 em.flush();

           } // while

           f.saveFile("\\docs", "improvementClosures.txt");

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

    } // improvementClosures()

    public void closingActivities() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("ClosingActivities");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String name = (String)relationObj.get("name");

                 ClosingActivities closingActivities = new ClosingActivities();

                 closingActivities.setName(name);
                 f.line(closingActivities.getName());
                 f.line("");

                 em.persist(closingActivities);
                 em.flush();

           } // while

           f.saveFile("\\docs", "closingActivities.txt");

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

    } // closingActivities()

    public void developments() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("Developments");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String artifactId = (String)relationObj.get("artifactId");
                 String groupId = (String)relationObj.get("groupId");
                 String version = (String)relationObj.get("version");
                 String code = (String)relationObj.get("code");

                 Developments developments = new Developments();

                 developments.setArtifactId(artifactId);
                 f.line(developments.getArtifactId());
                 f.line("");

                 developments.setGroupId(groupId);
                 f.line(developments.getGroupId());
                 f.line("");

                 developments.setVersion(version);
                 f.line(developments.getVersion());
                 f.line("");

                 developments.setCode(code);
                 f.line(developments.getCode());
                 f.line("");

                 em.persist(developments);
                 em.flush();

           } // while

           f.saveFile("\\docs", "developments.txt");

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

    } // developments()

    public void modelsGroups() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("ModelsGroups");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String name = (String)relationObj.get("name");
                 String code = (String)relationObj.get("code");

                 ModelsGroups modelsGroups = new ModelsGroups();

                 modelsGroups.setName(name);
                 f.line(modelsGroups.getName());
                 f.line("");

                 modelsGroups.setCode(code);
                 f.line(modelsGroups.getCode());
                 f.line("");

                 em.persist(modelsGroups);
                 em.flush();

           } // while

           f.saveFile("\\docs", "modelsGroups.txt");

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

    } // modelsGroups()

    public void models() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("Models");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String name = (String)relationObj.get("name");
                 String code = (String)relationObj.get("code");
                 String version = (String)relationObj.get("version");

                 Models models = new Models();

                 models.setName(name);
                 f.line(models.getName());
                 f.line("");

                 models.setCode(code);
                 f.line(models.getCode());
                 f.line("");

                 models.setVersion(version);
                 f.line(models.getVersion());
                 f.line("");

                 em.persist(models);
                 em.flush();

           } // while

           f.saveFile("\\docs", "models.txt");

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

    } // models()

    public void modelRelationships() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("ModelRelationships");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String name = (String)relationObj.get("name");

                 ModelRelationships modelRelationships = new ModelRelationships();

                 modelRelationships.setName(name);
                 f.line(modelRelationships.getName());
                 f.line("");

                 em.persist(modelRelationships);
                 em.flush();

           } // while

           f.saveFile("\\docs", "modelRelationships.txt");

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

    } // modelRelationships()

    public void relationships() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("Relationships");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String name = (String)relationObj.get("name");

                 Relationships relationships = new Relationships();

                 relationships.setName(name);
                 f.line(relationships.getName());
                 f.line("");

                 em.persist(relationships);
                 em.flush();

           } // while

           f.saveFile("\\docs", "relationships.txt");

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

    } // relationships()

    public void cardinalities() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("Cardinalities");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String name = (String)relationObj.get("name");
                 String cardinality = (String)relationObj.get("cardinality");

                 Cardinalities cardinalities = new Cardinalities();

                 cardinalities.setName(name);
                 f.line(cardinalities.getName());
                 f.line("");

                 cardinalities.setCardinality(cardinality);
                 f.line(cardinalities.getCardinality());
                 f.line("");

                 em.persist(cardinalities);
                 em.flush();

           } // while

           f.saveFile("\\docs", "cardinalities.txt");

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

    } // cardinalities()

    public void entities() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("Entities");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String name = (String)relationObj.get("name");
                 String serialID = (String)relationObj.get("serialID");
                 String table = (String)relationObj.get("table");
                 String description = (String)relationObj.get("description");

                 Entities entities = new Entities();

                 entities.setName(name);
                 f.line(entities.getName());
                 f.line("");

                 entities.setSerialID(serialID);
                 f.line(entities.getSerialID());
                 f.line("");

                 entities.setTable(table);
                 f.line(entities.getTable());
                 f.line("");

                 entities.setDescription(description);
                 f.line(entities.getDescription());
                 f.line("");

                 em.persist(entities);
                 em.flush();

           } // while

           f.saveFile("\\docs", "entities.txt");

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

    } // entities()

    public void attributes() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("Attributes");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String name = (String)relationObj.get("name");
                 String description = (String)relationObj.get("description");

                 Attributes attributes = new Attributes();

                 attributes.setName(name);
                 f.line(attributes.getName());
                 f.line("");

                 attributes.setDescription(description);
                 f.line(attributes.getDescription());
                 f.line("");

                 em.persist(attributes);
                 em.flush();

           } // while

           f.saveFile("\\docs", "attributes.txt");

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

    } // attributes()

    public void groupIds() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("GroupIds");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String artifactId = (String)relationObj.get("artifactId");
                 String groupId = (String)relationObj.get("groupId");
                 String version = (String)relationObj.get("version");
                 String code = (String)relationObj.get("code");

                 GroupIds groupIds = new GroupIds();

                 groupIds.setArtifactId(artifactId);
                 f.line(groupIds.getArtifactId());
                 f.line("");

                 groupIds.setGroupId(groupId);
                 f.line(groupIds.getGroupId());
                 f.line("");

                 groupIds.setVersion(version);
                 f.line(groupIds.getVersion());
                 f.line("");

                 groupIds.setCode(code);
                 f.line(groupIds.getCode());
                 f.line("");

                 em.persist(groupIds);
                 em.flush();

           } // while

           f.saveFile("\\docs", "groupIds.txt");

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

    } // groupIds()

    public void groupIdsTypes() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("GroupIdsTypes");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String name = (String)relationObj.get("name");

                 GroupIdsTypes groupIdsTypes = new GroupIdsTypes();

                 groupIdsTypes.setName(name);
                 f.line(groupIdsTypes.getName());
                 f.line("");

                 em.persist(groupIdsTypes);
                 em.flush();

           } // while

           f.saveFile("\\docs", "groupIdsTypes.txt");

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

    } // groupIdsTypes()

    public void persons() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("Persons");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String firstName = (String)relationObj.get("firstName");
                 String secondName = (String)relationObj.get("secondName");
                 String firstLastName = (String)relationObj.get("firstLastName");
                 String secondLastName = (String)relationObj.get("secondLastName");
                 String email = (String)relationObj.get("email");
                 String mobile = (String)relationObj.get("mobile");
                 String telephone = (String)relationObj.get("telephone");
                 String skipe = (String)relationObj.get("skipe");
                 String address = (String)relationObj.get("address");

                 Persons persons = new Persons();

                 persons.setFirstName(firstName);
                 f.line(persons.getFirstName());
                 f.line("");

                 persons.setSecondName(secondName);
                 f.line(persons.getSecondName());
                 f.line("");

                 persons.setFirstLastName(firstLastName);
                 f.line(persons.getFirstLastName());
                 f.line("");

                 persons.setSecondLastName(secondLastName);
                 f.line(persons.getSecondLastName());
                 f.line("");

                 persons.setEmail(email);
                 f.line(persons.getEmail());
                 f.line("");

                 persons.setMobile(mobile);
                 f.line(persons.getMobile());
                 f.line("");

                 persons.setTelephone(telephone);
                 f.line(persons.getTelephone());
                 f.line("");

                 persons.setSkipe(skipe);
                 f.line(persons.getSkipe());
                 f.line("");

                 persons.setAddress(address);
                 f.line(persons.getAddress());
                 f.line("");

                 em.persist(persons);
                 em.flush();

           } // while

           f.saveFile("\\docs", "persons.txt");

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

    } // persons()

    public void sitesTypes() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("SitesTypes");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String name = (String)relationObj.get("name");

                 SitesTypes sitesTypes = new SitesTypes();

                 sitesTypes.setName(name);
                 f.line(sitesTypes.getName());
                 f.line("");

                 em.persist(sitesTypes);
                 em.flush();

           } // while

           f.saveFile("\\docs", "sitesTypes.txt");

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

    } // sitesTypes()

    public void sites() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("Sites");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String title = (String)relationObj.get("title");
                 String link = (String)relationObj.get("link");
                 String abc = (String)relationObj.get("abc");
                 String ipAddress1 = (String)relationObj.get("ipAddress1");
                 String ipAddress2 = (String)relationObj.get("ipAddress2");
                 String ipAddress3 = (String)relationObj.get("ipAddress3");

                 Sites sites = new Sites();

                 sites.setTitle(title);
                 f.line(sites.getTitle());
                 f.line("");

                 sites.setLink(link);
                 f.line(sites.getLink());
                 f.line("");

                 sites.setAbc(abc);
                 f.line(sites.getAbc());
                 f.line("");

                 sites.setIpAddress1(ipAddress1);
                 f.line(sites.getIpAddress1());
                 f.line("");

                 sites.setIpAddress2(ipAddress2);
                 f.line(sites.getIpAddress2());
                 f.line("");

                 sites.setIpAddress3(ipAddress3);
                 f.line(sites.getIpAddress3());
                 f.line("");

                 em.persist(sites);
                 em.flush();

           } // while

           f.saveFile("\\docs", "sites.txt");

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

    } // sites()

    public void activitiesTypes() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("ActivitiesTypes");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String name = (String)relationObj.get("name");

                 ActivitiesTypes activitiesTypes = new ActivitiesTypes();

                 activitiesTypes.setName(name);
                 f.line(activitiesTypes.getName());
                 f.line("");

                 em.persist(activitiesTypes);
                 em.flush();

           } // while

           f.saveFile("\\docs", "activitiesTypes.txt");

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

    } // activitiesTypes()

    public void activities() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("Activities");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String name = (String)relationObj.get("name");

                 Activities activities = new Activities();

                 activities.setName(name);
                 f.line(activities.getName());
                 f.line("");

                 em.persist(activities);
                 em.flush();

           } // while

           f.saveFile("\\docs", "activities.txt");

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

    } // activities()

    public void calendars() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("Calendars");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String name = (String)relationObj.get("name");

                 Calendars calendars = new Calendars();

                 calendars.setName(name);
                 f.line(calendars.getName());
                 f.line("");

                 em.persist(calendars);
                 em.flush();

           } // while

           f.saveFile("\\docs", "calendars.txt");

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

    } // calendars()

    public void tasks() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("Tasks");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String name = (String)relationObj.get("name");

                 Tasks tasks = new Tasks();

                 tasks.setName(name);
                 f.line(tasks.getName());
                 f.line("");

                 em.persist(tasks);
                 em.flush();

           } // while

           f.saveFile("\\docs", "tasks.txt");

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

    } // tasks()

    public void priorities() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("Priorities");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String name = (String)relationObj.get("name");

                 Priorities priorities = new Priorities();

                 priorities.setName(name);
                 f.line(priorities.getName());
                 f.line("");

                 em.persist(priorities);
                 em.flush();

           } // while

           f.saveFile("\\docs", "priorities.txt");

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

    } // priorities()

    public void diaries() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("Diaries");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String name = (String)relationObj.get("name");
                 String description = (String)relationObj.get("description");

                 Diaries diaries = new Diaries();

                 diaries.setName(name);
                 f.line(diaries.getName());
                 f.line("");

                 diaries.setDescription(description);
                 f.line(diaries.getDescription());
                 f.line("");

                 em.persist(diaries);
                 em.flush();

           } // while

           f.saveFile("\\docs", "diaries.txt");

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

    } // diaries()

}

