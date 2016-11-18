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
@Named("fileUploadR")
public class FileUploadR {

    private String filePath = "";

    @PersistenceContext(unitName = "archivalPU-JTA")
    private EntityManager em;

    FindBean findBean = new FindBean();

    private UploadedFile file;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public void relationshipsData(Boolean isValidate) {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("RelationshipsData");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String from = (String)relationObj.get("From");
                 String fromProperty = (String)relationObj.get("FromProperty");
                 String fromValue = (String)relationObj.get("FromValue");
                 String to = (String)relationObj.get("To");
                 String toProperty = (String)relationObj.get("ToProperty");
                 String toValue = (String)relationObj.get("ToValue");
                 String name = (String)relationObj.get("Name");
                 String cardinalities = (String)relationObj.get("Cardinalities");

/*
FundsLife::FundsLife Uno a Muchos Bidirecccional No.5 Funds 
Funds::Funds Uno a Muchos Bidirecccional No.5 Sections 
SectionsTypes::SectionsTypes Uno a Muchos Bidirecccional No.5 Sections 
Sections::Sections Uno a Muchos Bidirecccional No.5 Activities 
Sections::Sections Uno a Muchos Bidirecccional No.5 Tasks 
Sections::Sections Uno a Muchos Bidirecccional No.5 Sections 
Sections::Sections Uno a Muchos Bidirecccional No.5 Series 
Series::Series Uno a Muchos Bidirecccional No.5 Tasks 
Series::Series Uno a Muchos Bidirecccional No.5 DocumentalsUnits 
Series::Series Uno a Muchos Bidirecccional No.5 Series 
Series::Series Uno a Muchos Bidirecccional No.5 VersionsControls 
Series::Series Uno a Muchos Bidirecccional No.5 TrdSeries 
Trd::Trd Uno a Muchos Bidirecccional No.5 TrdSeries 
FinalDisposition::FinalDisposition Uno a Muchos Bidirecccional No.5 Trd 
DocumentalRetention::DocumentalRetention Uno a Muchos Bidirecccional No.5 Trd gestion
DocumentalRetention::DocumentalRetention Uno a Muchos Bidirecccional No.5 Trd central
FrequentlyQuery::FrequentlyQuery Uno a Muchos Bidirecccional No.5 DocumentalsUnits 
DocumentalsUnits::DocumentalsUnits Uno a Muchos Bidirecccional No.5 OriginalOrders 
DocumentalsUnits::DocumentalsUnits Uno a Muchos Bidirecccional No.5 VersionsControls 
DocumentalsUnits::DocumentalsUnits Uno a Muchos Bidirecccional No.5 DocumentalsUnits 
ConservationUnits::ConservationUnits Uno a Muchos Bidirecccional No.5 OriginalOrders 
DocumentalInventory::DocumentalInventory Uno a Muchos Bidirecccional No.5 OriginalOrders 
DocumentalsUnitsTypes::DocumentalsUnitsTypes Uno a Muchos Bidirecccional No.5 DocumentalsUnits 
Access::Access Uno a Muchos Bidirecccional No.5 DocumentalsUnits 
Organizeds::Organizeds Uno a Muchos Bidirecccional No.5 DocumentalsUnits 
InventoryFinality::InventoryFinality Uno a Muchos Bidirecccional No.5 DocumentalInventory 
DocumentalsSupports::DocumentalsSupports Uno a Muchos Bidirecccional No.5 OriginalOrders 
ConservationUnitsTypes::ConservationUnitsTypes Uno a Muchos Bidirecccional No.5 ConservationUnits 
ConservationUnitsTypes::ConservationUnitsTypes Uno a Muchos Bidirecccional No.5 OriginalOrders 
Companies::Companies Uno a Muchos Bidirecccional No.5 Funds 
CompaniesRoles::CompaniesRoles Uno a Muchos Bidirecccional No.5 DocumentalsUnits almacenamiento
CompaniesRoles::CompaniesRoles Uno a Muchos Bidirecccional No.5 DocumentalsUnits proteccion
*/

                 if (from.equals("FundsLife") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("Funds") &&
                     name.equals("")){

                     FundsLife fundsLifeFrom = new FundsLife();

                     Funds fundsTo = new Funds();

                     if (fromProperty.equals("name")){
                         fundsLifeFrom = findBean.nameFundsLife(fromValue,em);
                         f.line("from:"+fromValue+":"+fundsLifeFrom.getName());
                     } // fundsLife

                     if (toProperty.equals("name")){
                         fundsTo = findBean.nameFunds(toValue,em);
                         f.line("to:"+toValue+":"+fundsTo.getName());
                     } // Funds.name

                     if (toProperty.equals("code")){
                         fundsTo = findBean.codeFunds(toValue,em);
                         f.line("to:"+toValue+":"+fundsTo.getCode());
                     } // Funds.code

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         fundsTo.setFundsLife(fundsLifeFrom);
                     }

                     if (!isValidate) {
                         em.merge(fundsTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "fundsLife.txt");

                     }

                 } // from: FundsLife

                 if (from.equals("Funds") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("Sections") &&
                     name.equals("")){

                     Funds fundsFrom = new Funds();

                     Sections sectionsTo = new Sections();

                     if (fromProperty.equals("name")){
                         fundsFrom = findBean.nameFunds(fromValue,em);
                         f.line("from:"+fromValue+":"+fundsFrom.getName());
                     } // funds

                     if (fromProperty.equals("code")){
                         fundsFrom = findBean.codeFunds(fromValue,em);
                         f.line("from:"+fromValue+":"+fundsFrom.getCode());
                     } // funds

                     if (toProperty.equals("name")){
                         sectionsTo = findBean.nameSections(toValue,em);
                         f.line("to:"+toValue+":"+sectionsTo.getName());
                     } // Sections.name

                     if (toProperty.equals("code")){
                         sectionsTo = findBean.codeSections(toValue,em);
                         f.line("to:"+toValue+":"+sectionsTo.getCode());
                     } // Sections.code

                     if (toProperty.equals("dir")){
                         sectionsTo = findBean.dirSections(toValue,em);
                         f.line("to:"+toValue+":"+sectionsTo.getDir());
                     } // Sections.dir

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         sectionsTo.setFunds(fundsFrom);
                     }

                     if (!isValidate) {
                         em.merge(sectionsTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "funds.txt");

                     }

                 } // from: Funds

                 if (from.equals("SectionsTypes") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("Sections") &&
                     name.equals("")){

                     SectionsTypes sectionsTypesFrom = new SectionsTypes();

                     Sections sectionsTo = new Sections();

                     if (fromProperty.equals("name")){
                         sectionsTypesFrom = findBean.nameSectionsTypes(fromValue,em);
                         f.line("from:"+fromValue+":"+sectionsTypesFrom.getName());
                     } // sectionsTypes

                     if (toProperty.equals("name")){
                         sectionsTo = findBean.nameSections(toValue,em);
                         f.line("to:"+toValue+":"+sectionsTo.getName());
                     } // Sections.name

                     if (toProperty.equals("code")){
                         sectionsTo = findBean.codeSections(toValue,em);
                         f.line("to:"+toValue+":"+sectionsTo.getCode());
                     } // Sections.code

                     if (toProperty.equals("dir")){
                         sectionsTo = findBean.dirSections(toValue,em);
                         f.line("to:"+toValue+":"+sectionsTo.getDir());
                     } // Sections.dir

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         sectionsTo.setSectionsTypes(sectionsTypesFrom);
                     }

                     if (!isValidate) {
                         em.merge(sectionsTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "sectionsTypes.txt");

                     }

                 } // from: SectionsTypes

                 if (from.equals("Sections") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("Activities") &&
                     name.equals("")){

                     Sections sectionsFrom = new Sections();

                     Activities activitiesTo = new Activities();

                     if (fromProperty.equals("name")){
                         sectionsFrom = findBean.nameSections(fromValue,em);
                         f.line("from:"+fromValue+":"+sectionsFrom.getName());
                     } // sections

                     if (fromProperty.equals("code")){
                         sectionsFrom = findBean.codeSections(fromValue,em);
                         f.line("from:"+fromValue+":"+sectionsFrom.getCode());
                     } // sections

                     if (fromProperty.equals("dir")){
                         sectionsFrom = findBean.dirSections(fromValue,em);
                         f.line("from:"+fromValue+":"+sectionsFrom.getDir());
                     } // sections

                     if (toProperty.equals("name")){
                         activitiesTo = findBean.nameActivities(toValue,em);
                         f.line("to:"+toValue+":"+activitiesTo.getName());
                     } // Activities.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         activitiesTo.setSections(sectionsFrom);
                     }

                     if (!isValidate) {
                         em.merge(activitiesTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "sections.txt");

                     }

                 } // from: Sections

                 if (from.equals("Sections") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("Tasks") &&
                     name.equals("")){

                     Sections sectionsFrom = new Sections();

                     Tasks tasksTo = new Tasks();

                     if (fromProperty.equals("name")){
                         sectionsFrom = findBean.nameSections(fromValue,em);
                         f.line("from:"+fromValue+":"+sectionsFrom.getName());
                     } // sections

                     if (fromProperty.equals("code")){
                         sectionsFrom = findBean.codeSections(fromValue,em);
                         f.line("from:"+fromValue+":"+sectionsFrom.getCode());
                     } // sections

                     if (fromProperty.equals("dir")){
                         sectionsFrom = findBean.dirSections(fromValue,em);
                         f.line("from:"+fromValue+":"+sectionsFrom.getDir());
                     } // sections

                     if (toProperty.equals("name")){
                         tasksTo = findBean.nameTasks(toValue,em);
                         f.line("to:"+toValue+":"+tasksTo.getName());
                     } // Tasks.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         tasksTo.setSections(sectionsFrom);
                     }

                     if (!isValidate) {
                         em.merge(tasksTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "sections.txt");

                     }

                 } // from: Sections

                 if (from.equals("Sections") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("Sections") &&
                     name.equals("")){

                     Sections sectionsFrom = new Sections();

                     Sections sectionsTo = new Sections();

                     if (fromProperty.equals("name")){
                         sectionsFrom = findBean.nameSections(fromValue,em);
                         f.line("from:"+fromValue+":"+sectionsFrom.getName());
                     } // sections

                     if (fromProperty.equals("code")){
                         sectionsFrom = findBean.codeSections(fromValue,em);
                         f.line("from:"+fromValue+":"+sectionsFrom.getCode());
                     } // sections

                     if (fromProperty.equals("dir")){
                         sectionsFrom = findBean.dirSections(fromValue,em);
                         f.line("from:"+fromValue+":"+sectionsFrom.getDir());
                     } // sections

                     if (toProperty.equals("name")){
                         sectionsTo = findBean.nameSections(toValue,em);
                         f.line("to:"+toValue+":"+sectionsTo.getName());
                     } // Sections.name

                     if (toProperty.equals("code")){
                         sectionsTo = findBean.codeSections(toValue,em);
                         f.line("to:"+toValue+":"+sectionsTo.getCode());
                     } // Sections.code

                     if (toProperty.equals("dir")){
                         sectionsTo = findBean.dirSections(toValue,em);
                         f.line("to:"+toValue+":"+sectionsTo.getDir());
                     } // Sections.dir

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         sectionsTo.setObjPadre(sectionsFrom);
                     }

                     if (!isValidate) {
                         em.merge(sectionsTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "sections.txt");

                     }

                 } // from: Sections

                 if (from.equals("Sections") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("Series") &&
                     name.equals("")){

                     Sections sectionsFrom = new Sections();

                     Series seriesTo = new Series();

                     if (fromProperty.equals("name")){
                         sectionsFrom = findBean.nameSections(fromValue,em);
                         f.line("from:"+fromValue+":"+sectionsFrom.getName());
                     } // sections

                     if (fromProperty.equals("code")){
                         sectionsFrom = findBean.codeSections(fromValue,em);
                         f.line("from:"+fromValue+":"+sectionsFrom.getCode());
                     } // sections

                     if (fromProperty.equals("dir")){
                         sectionsFrom = findBean.dirSections(fromValue,em);
                         f.line("from:"+fromValue+":"+sectionsFrom.getDir());
                     } // sections

                     if (toProperty.equals("name")){
                         seriesTo = findBean.nameSeries(toValue,em);
                         f.line("to:"+toValue+":"+seriesTo.getName());
                     } // Series.name

                     if (toProperty.equals("code")){
                         seriesTo = findBean.codeSeries(toValue,em);
                         f.line("to:"+toValue+":"+seriesTo.getCode());
                     } // Series.code

                     if (toProperty.equals("located")){
                         seriesTo = findBean.locatedSeries(toValue,em);
                         f.line("to:"+toValue+":"+seriesTo.getLocated());
                     } // Series.located

                     if (toProperty.equals("procedures")){
                         seriesTo = findBean.proceduresSeries(toValue,em);
                         f.line("to:"+toValue+":"+seriesTo.getProcedures());
                     } // Series.procedures

                     if (toProperty.equals("dir")){
                         seriesTo = findBean.dirSeries(toValue,em);
                         f.line("to:"+toValue+":"+seriesTo.getDir());
                     } // Series.dir

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         seriesTo.setSections(sectionsFrom);
                     }

                     if (!isValidate) {
                         em.merge(seriesTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "sections.txt");

                     }

                 } // from: Sections

                 if (from.equals("Series") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("Tasks") &&
                     name.equals("")){

                     Series seriesFrom = new Series();

                     Tasks tasksTo = new Tasks();

                     if (fromProperty.equals("name")){
                         seriesFrom = findBean.nameSeries(fromValue,em);
                         f.line("from:"+fromValue+":"+seriesFrom.getName());
                     } // series

                     if (fromProperty.equals("code")){
                         seriesFrom = findBean.codeSeries(fromValue,em);
                         f.line("from:"+fromValue+":"+seriesFrom.getCode());
                     } // series

                     if (fromProperty.equals("located")){
                         seriesFrom = findBean.locatedSeries(fromValue,em);
                         f.line("from:"+fromValue+":"+seriesFrom.getLocated());
                     } // series

                     if (fromProperty.equals("procedures")){
                         seriesFrom = findBean.proceduresSeries(fromValue,em);
                         f.line("from:"+fromValue+":"+seriesFrom.getProcedures());
                     } // series

                     if (fromProperty.equals("dir")){
                         seriesFrom = findBean.dirSeries(fromValue,em);
                         f.line("from:"+fromValue+":"+seriesFrom.getDir());
                     } // series

                     if (toProperty.equals("name")){
                         tasksTo = findBean.nameTasks(toValue,em);
                         f.line("to:"+toValue+":"+tasksTo.getName());
                     } // Tasks.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         tasksTo.setSeries(seriesFrom);
                     }

                     if (!isValidate) {
                         em.merge(tasksTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "series.txt");

                     }

                 } // from: Series

                 if (from.equals("Series") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("DocumentalsUnits") &&
                     name.equals("")){

                     Series seriesFrom = new Series();

                     DocumentalsUnits documentalsUnitsTo = new DocumentalsUnits();

                     if (fromProperty.equals("name")){
                         seriesFrom = findBean.nameSeries(fromValue,em);
                         f.line("from:"+fromValue+":"+seriesFrom.getName());
                     } // series

                     if (fromProperty.equals("code")){
                         seriesFrom = findBean.codeSeries(fromValue,em);
                         f.line("from:"+fromValue+":"+seriesFrom.getCode());
                     } // series

                     if (fromProperty.equals("located")){
                         seriesFrom = findBean.locatedSeries(fromValue,em);
                         f.line("from:"+fromValue+":"+seriesFrom.getLocated());
                     } // series

                     if (fromProperty.equals("procedures")){
                         seriesFrom = findBean.proceduresSeries(fromValue,em);
                         f.line("from:"+fromValue+":"+seriesFrom.getProcedures());
                     } // series

                     if (fromProperty.equals("dir")){
                         seriesFrom = findBean.dirSeries(fromValue,em);
                         f.line("from:"+fromValue+":"+seriesFrom.getDir());
                     } // series

                     if (toProperty.equals("name")){
                         documentalsUnitsTo = findBean.nameDocumentalsUnits(toValue,em);
                         f.line("to:"+toValue+":"+documentalsUnitsTo.getName());
                     } // DocumentalsUnits.name

                     if (toProperty.equals("code")){
                         documentalsUnitsTo = findBean.codeDocumentalsUnits(toValue,em);
                         f.line("to:"+toValue+":"+documentalsUnitsTo.getCode());
                     } // DocumentalsUnits.code

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         documentalsUnitsTo.setSeries(seriesFrom);
                     }

                     if (!isValidate) {
                         em.merge(documentalsUnitsTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "series.txt");

                     }

                 } // from: Series

                 if (from.equals("Series") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("Series") &&
                     name.equals("")){

                     Series seriesFrom = new Series();

                     Series seriesTo = new Series();

                     if (fromProperty.equals("name")){
                         seriesFrom = findBean.nameSeries(fromValue,em);
                         f.line("from:"+fromValue+":"+seriesFrom.getName());
                     } // series

                     if (fromProperty.equals("code")){
                         seriesFrom = findBean.codeSeries(fromValue,em);
                         f.line("from:"+fromValue+":"+seriesFrom.getCode());
                     } // series

                     if (fromProperty.equals("located")){
                         seriesFrom = findBean.locatedSeries(fromValue,em);
                         f.line("from:"+fromValue+":"+seriesFrom.getLocated());
                     } // series

                     if (fromProperty.equals("procedures")){
                         seriesFrom = findBean.proceduresSeries(fromValue,em);
                         f.line("from:"+fromValue+":"+seriesFrom.getProcedures());
                     } // series

                     if (fromProperty.equals("dir")){
                         seriesFrom = findBean.dirSeries(fromValue,em);
                         f.line("from:"+fromValue+":"+seriesFrom.getDir());
                     } // series

                     if (toProperty.equals("name")){
                         seriesTo = findBean.nameSeries(toValue,em);
                         f.line("to:"+toValue+":"+seriesTo.getName());
                     } // Series.name

                     if (toProperty.equals("code")){
                         seriesTo = findBean.codeSeries(toValue,em);
                         f.line("to:"+toValue+":"+seriesTo.getCode());
                     } // Series.code

                     if (toProperty.equals("located")){
                         seriesTo = findBean.locatedSeries(toValue,em);
                         f.line("to:"+toValue+":"+seriesTo.getLocated());
                     } // Series.located

                     if (toProperty.equals("procedures")){
                         seriesTo = findBean.proceduresSeries(toValue,em);
                         f.line("to:"+toValue+":"+seriesTo.getProcedures());
                     } // Series.procedures

                     if (toProperty.equals("dir")){
                         seriesTo = findBean.dirSeries(toValue,em);
                         f.line("to:"+toValue+":"+seriesTo.getDir());
                     } // Series.dir

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         seriesTo.setObjPadre(seriesFrom);
                     }

                     if (!isValidate) {
                         em.merge(seriesTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "series.txt");

                     }

                 } // from: Series

                 if (from.equals("Series") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("VersionsControls") &&
                     name.equals("")){

                     Series seriesFrom = new Series();

                     VersionsControls versionsControlsTo = new VersionsControls();

                     if (fromProperty.equals("name")){
                         seriesFrom = findBean.nameSeries(fromValue,em);
                         f.line("from:"+fromValue+":"+seriesFrom.getName());
                     } // series

                     if (fromProperty.equals("code")){
                         seriesFrom = findBean.codeSeries(fromValue,em);
                         f.line("from:"+fromValue+":"+seriesFrom.getCode());
                     } // series

                     if (fromProperty.equals("located")){
                         seriesFrom = findBean.locatedSeries(fromValue,em);
                         f.line("from:"+fromValue+":"+seriesFrom.getLocated());
                     } // series

                     if (fromProperty.equals("procedures")){
                         seriesFrom = findBean.proceduresSeries(fromValue,em);
                         f.line("from:"+fromValue+":"+seriesFrom.getProcedures());
                     } // series

                     if (fromProperty.equals("dir")){
                         seriesFrom = findBean.dirSeries(fromValue,em);
                         f.line("from:"+fromValue+":"+seriesFrom.getDir());
                     } // series

                     if (toProperty.equals("name")){
                         versionsControlsTo = findBean.nameVersionsControls(toValue,em);
                         f.line("to:"+toValue+":"+versionsControlsTo.getName());
                     } // VersionsControls.name

                     if (toProperty.equals("code")){
                         versionsControlsTo = findBean.codeVersionsControls(toValue,em);
                         f.line("to:"+toValue+":"+versionsControlsTo.getCode());
                     } // VersionsControls.code

                     if (toProperty.equals("version")){
                         versionsControlsTo = findBean.versionVersionsControls(toValue,em);
                         f.line("to:"+toValue+":"+versionsControlsTo.getVersion());
                     } // VersionsControls.version

                     if (toProperty.equals("request")){
                         versionsControlsTo = findBean.requestVersionsControls(toValue,em);
                         f.line("to:"+toValue+":"+versionsControlsTo.getRequest());
                     } // VersionsControls.request

                     if (toProperty.equals("responsible")){
                         versionsControlsTo = findBean.responsibleVersionsControls(toValue,em);
                         f.line("to:"+toValue+":"+versionsControlsTo.getResponsible());
                     } // VersionsControls.responsible

                     if (toProperty.equals("description")){
                         versionsControlsTo = findBean.descriptionVersionsControls(toValue,em);
                         f.line("to:"+toValue+":"+versionsControlsTo.getDescription());
                     } // VersionsControls.description

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         versionsControlsTo.setSeries(seriesFrom);
                     }

                     if (!isValidate) {
                         em.merge(versionsControlsTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "series.txt");

                     }

                 } // from: Series

                 if (from.equals("Series") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("TrdSeries") &&
                     name.equals("")){

                     Series seriesFrom = new Series();

                     TrdSeries trdSeriesTo = new TrdSeries();

                     if (fromProperty.equals("name")){
                         seriesFrom = findBean.nameSeries(fromValue,em);
                         f.line("from:"+fromValue+":"+seriesFrom.getName());
                     } // series

                     if (fromProperty.equals("code")){
                         seriesFrom = findBean.codeSeries(fromValue,em);
                         f.line("from:"+fromValue+":"+seriesFrom.getCode());
                     } // series

                     if (fromProperty.equals("located")){
                         seriesFrom = findBean.locatedSeries(fromValue,em);
                         f.line("from:"+fromValue+":"+seriesFrom.getLocated());
                     } // series

                     if (fromProperty.equals("procedures")){
                         seriesFrom = findBean.proceduresSeries(fromValue,em);
                         f.line("from:"+fromValue+":"+seriesFrom.getProcedures());
                     } // series

                     if (fromProperty.equals("dir")){
                         seriesFrom = findBean.dirSeries(fromValue,em);
                         f.line("from:"+fromValue+":"+seriesFrom.getDir());
                     } // series

                     if (toProperty.equals("name")){
                         trdSeriesTo = findBean.nameTrdSeries(toValue,em);
                         f.line("to:"+toValue+":"+trdSeriesTo.getName());
                     } // TrdSeries.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         trdSeriesTo.setSeries(seriesFrom);
                     }

                     if (!isValidate) {
                         em.merge(trdSeriesTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "series.txt");

                     }

                 } // from: Series

                 if (from.equals("Trd") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("TrdSeries") &&
                     name.equals("")){

                     Trd trdFrom = new Trd();

                     TrdSeries trdSeriesTo = new TrdSeries();

                     if (fromProperty.equals("name")){
                         trdFrom = findBean.nameTrd(fromValue,em);
                         f.line("from:"+fromValue+":"+trdFrom.getName());
                     } // trd

                     if (toProperty.equals("name")){
                         trdSeriesTo = findBean.nameTrdSeries(toValue,em);
                         f.line("to:"+toValue+":"+trdSeriesTo.getName());
                     } // TrdSeries.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         trdSeriesTo.setTrd(trdFrom);
                     }

                     if (!isValidate) {
                         em.merge(trdSeriesTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "trd.txt");

                     }

                 } // from: Trd

                 if (from.equals("FinalDisposition") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("Trd") &&
                     name.equals("")){

                     FinalDisposition finalDispositionFrom = new FinalDisposition();

                     Trd trdTo = new Trd();

                     if (fromProperty.equals("name")){
                         finalDispositionFrom = findBean.nameFinalDisposition(fromValue,em);
                         f.line("from:"+fromValue+":"+finalDispositionFrom.getName());
                     } // finalDisposition

                     if (toProperty.equals("name")){
                         trdTo = findBean.nameTrd(toValue,em);
                         f.line("to:"+toValue+":"+trdTo.getName());
                     } // Trd.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         trdTo.setFinalDisposition(finalDispositionFrom);
                     }

                     if (!isValidate) {
                         em.merge(trdTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "finalDisposition.txt");

                     }

                 } // from: FinalDisposition

                 if (from.equals("DocumentalRetention") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("Trd") &&
                     name.equals("gestion")){

                     DocumentalRetention documentalRetentionFrom = new DocumentalRetention();

                     Trd trdTo = new Trd();

                     if (fromProperty.equals("name")){
                         documentalRetentionFrom = findBean.nameDocumentalRetention(fromValue,em);
                         f.line("from:"+fromValue+":"+documentalRetentionFrom.getName());
                     } // documentalRetention

                     if (toProperty.equals("name")){
                         trdTo = findBean.nameTrd(toValue,em);
                         f.line("to:"+toValue+":"+trdTo.getName());
                     } // Trd.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         trdTo.setGestion(documentalRetentionFrom);
                     }

                     if (!isValidate) {
                         em.merge(trdTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "documentalRetention.txt");

                     }

                 } // from: DocumentalRetention

                 if (from.equals("DocumentalRetention") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("Trd") &&
                     name.equals("central")){

                     DocumentalRetention documentalRetentionFrom = new DocumentalRetention();

                     Trd trdTo = new Trd();

                     if (fromProperty.equals("name")){
                         documentalRetentionFrom = findBean.nameDocumentalRetention(fromValue,em);
                         f.line("from:"+fromValue+":"+documentalRetentionFrom.getName());
                     } // documentalRetention

                     if (toProperty.equals("name")){
                         trdTo = findBean.nameTrd(toValue,em);
                         f.line("to:"+toValue+":"+trdTo.getName());
                     } // Trd.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         trdTo.setCentral(documentalRetentionFrom);
                     }

                     if (!isValidate) {
                         em.merge(trdTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "documentalRetention.txt");

                     }

                 } // from: DocumentalRetention

                 if (from.equals("FrequentlyQuery") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("DocumentalsUnits") &&
                     name.equals("")){

                     FrequentlyQuery frequentlyQueryFrom = new FrequentlyQuery();

                     DocumentalsUnits documentalsUnitsTo = new DocumentalsUnits();

                     if (fromProperty.equals("name")){
                         frequentlyQueryFrom = findBean.nameFrequentlyQuery(fromValue,em);
                         f.line("from:"+fromValue+":"+frequentlyQueryFrom.getName());
                     } // frequentlyQuery

                     if (toProperty.equals("name")){
                         documentalsUnitsTo = findBean.nameDocumentalsUnits(toValue,em);
                         f.line("to:"+toValue+":"+documentalsUnitsTo.getName());
                     } // DocumentalsUnits.name

                     if (toProperty.equals("code")){
                         documentalsUnitsTo = findBean.codeDocumentalsUnits(toValue,em);
                         f.line("to:"+toValue+":"+documentalsUnitsTo.getCode());
                     } // DocumentalsUnits.code

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         documentalsUnitsTo.setFrequentlyQuery(frequentlyQueryFrom);
                     }

                     if (!isValidate) {
                         em.merge(documentalsUnitsTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "frequentlyQuery.txt");

                     }

                 } // from: FrequentlyQuery

                 if (from.equals("DocumentalsUnits") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("OriginalOrders") &&
                     name.equals("")){

                     DocumentalsUnits documentalsUnitsFrom = new DocumentalsUnits();

                     OriginalOrders originalOrdersTo = new OriginalOrders();

                     if (fromProperty.equals("name")){
                         documentalsUnitsFrom = findBean.nameDocumentalsUnits(fromValue,em);
                         f.line("from:"+fromValue+":"+documentalsUnitsFrom.getName());
                     } // documentalsUnits

                     if (fromProperty.equals("code")){
                         documentalsUnitsFrom = findBean.codeDocumentalsUnits(fromValue,em);
                         f.line("from:"+fromValue+":"+documentalsUnitsFrom.getCode());
                     } // documentalsUnits

                     if (toProperty.equals("subject")){
                         originalOrdersTo = findBean.subjectOriginalOrders(toValue,em);
                         f.line("to:"+toValue+":"+originalOrdersTo.getSubject());
                     } // OriginalOrders.subject

                     if (toProperty.equals("code")){
                         originalOrdersTo = findBean.codeOriginalOrders(toValue,em);
                         f.line("to:"+toValue+":"+originalOrdersTo.getCode());
                     } // OriginalOrders.code

                     if (toProperty.equals("located")){
                         originalOrdersTo = findBean.locatedOriginalOrders(toValue,em);
                         f.line("to:"+toValue+":"+originalOrdersTo.getLocated());
                     } // OriginalOrders.located

                     if (toProperty.equals("mail")){
                         originalOrdersTo = findBean.mailOriginalOrders(toValue,em);
                         f.line("to:"+toValue+":"+originalOrdersTo.getMail());
                     } // OriginalOrders.mail

                     if (toProperty.equals("notes")){
                         originalOrdersTo = findBean.notesOriginalOrders(toValue,em);
                         f.line("to:"+toValue+":"+originalOrdersTo.getNotes());
                     } // OriginalOrders.notes

                     if (toProperty.equals("fileName")){
                         originalOrdersTo = findBean.fileNameOriginalOrders(toValue,em);
                         f.line("to:"+toValue+":"+originalOrdersTo.getFileName());
                     } // OriginalOrders.fileName

                     if (toProperty.equals("fileType")){
                         originalOrdersTo = findBean.fileTypeOriginalOrders(toValue,em);
                         f.line("to:"+toValue+":"+originalOrdersTo.getFileType());
                     } // OriginalOrders.fileType

                     if (toProperty.equals("filedir")){
                         originalOrdersTo = findBean.filedirOriginalOrders(toValue,em);
                         f.line("to:"+toValue+":"+originalOrdersTo.getFiledir());
                     } // OriginalOrders.filedir

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         originalOrdersTo.setDocumentalsUnits(documentalsUnitsFrom);
                     }

                     if (!isValidate) {
                         em.merge(originalOrdersTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "documentalsUnits.txt");

                     }

                 } // from: DocumentalsUnits

                 if (from.equals("DocumentalsUnits") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("VersionsControls") &&
                     name.equals("")){

                     DocumentalsUnits documentalsUnitsFrom = new DocumentalsUnits();

                     VersionsControls versionsControlsTo = new VersionsControls();

                     if (fromProperty.equals("name")){
                         documentalsUnitsFrom = findBean.nameDocumentalsUnits(fromValue,em);
                         f.line("from:"+fromValue+":"+documentalsUnitsFrom.getName());
                     } // documentalsUnits

                     if (fromProperty.equals("code")){
                         documentalsUnitsFrom = findBean.codeDocumentalsUnits(fromValue,em);
                         f.line("from:"+fromValue+":"+documentalsUnitsFrom.getCode());
                     } // documentalsUnits

                     if (toProperty.equals("name")){
                         versionsControlsTo = findBean.nameVersionsControls(toValue,em);
                         f.line("to:"+toValue+":"+versionsControlsTo.getName());
                     } // VersionsControls.name

                     if (toProperty.equals("code")){
                         versionsControlsTo = findBean.codeVersionsControls(toValue,em);
                         f.line("to:"+toValue+":"+versionsControlsTo.getCode());
                     } // VersionsControls.code

                     if (toProperty.equals("version")){
                         versionsControlsTo = findBean.versionVersionsControls(toValue,em);
                         f.line("to:"+toValue+":"+versionsControlsTo.getVersion());
                     } // VersionsControls.version

                     if (toProperty.equals("request")){
                         versionsControlsTo = findBean.requestVersionsControls(toValue,em);
                         f.line("to:"+toValue+":"+versionsControlsTo.getRequest());
                     } // VersionsControls.request

                     if (toProperty.equals("responsible")){
                         versionsControlsTo = findBean.responsibleVersionsControls(toValue,em);
                         f.line("to:"+toValue+":"+versionsControlsTo.getResponsible());
                     } // VersionsControls.responsible

                     if (toProperty.equals("description")){
                         versionsControlsTo = findBean.descriptionVersionsControls(toValue,em);
                         f.line("to:"+toValue+":"+versionsControlsTo.getDescription());
                     } // VersionsControls.description

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         versionsControlsTo.setDocumentalsUnits(documentalsUnitsFrom);
                     }

                     if (!isValidate) {
                         em.merge(versionsControlsTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "documentalsUnits.txt");

                     }

                 } // from: DocumentalsUnits

                 if (from.equals("DocumentalsUnits") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("DocumentalsUnits") &&
                     name.equals("")){

                     DocumentalsUnits documentalsUnitsFrom = new DocumentalsUnits();

                     DocumentalsUnits documentalsUnitsTo = new DocumentalsUnits();

                     if (fromProperty.equals("name")){
                         documentalsUnitsFrom = findBean.nameDocumentalsUnits(fromValue,em);
                         f.line("from:"+fromValue+":"+documentalsUnitsFrom.getName());
                     } // documentalsUnits

                     if (fromProperty.equals("code")){
                         documentalsUnitsFrom = findBean.codeDocumentalsUnits(fromValue,em);
                         f.line("from:"+fromValue+":"+documentalsUnitsFrom.getCode());
                     } // documentalsUnits

                     if (toProperty.equals("name")){
                         documentalsUnitsTo = findBean.nameDocumentalsUnits(toValue,em);
                         f.line("to:"+toValue+":"+documentalsUnitsTo.getName());
                     } // DocumentalsUnits.name

                     if (toProperty.equals("code")){
                         documentalsUnitsTo = findBean.codeDocumentalsUnits(toValue,em);
                         f.line("to:"+toValue+":"+documentalsUnitsTo.getCode());
                     } // DocumentalsUnits.code

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         documentalsUnitsTo.setObjPadre(documentalsUnitsFrom);
                     }

                     if (!isValidate) {
                         em.merge(documentalsUnitsTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "documentalsUnits.txt");

                     }

                 } // from: DocumentalsUnits

                 if (from.equals("ConservationUnits") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("OriginalOrders") &&
                     name.equals("")){

                     ConservationUnits conservationUnitsFrom = new ConservationUnits();

                     OriginalOrders originalOrdersTo = new OriginalOrders();

                     if (fromProperty.equals("name")){
                         conservationUnitsFrom = findBean.nameConservationUnits(fromValue,em);
                         f.line("from:"+fromValue+":"+conservationUnitsFrom.getName());
                     } // conservationUnits

                     if (fromProperty.equals("code")){
                         conservationUnitsFrom = findBean.codeConservationUnits(fromValue,em);
                         f.line("from:"+fromValue+":"+conservationUnitsFrom.getCode());
                     } // conservationUnits

                     if (toProperty.equals("subject")){
                         originalOrdersTo = findBean.subjectOriginalOrders(toValue,em);
                         f.line("to:"+toValue+":"+originalOrdersTo.getSubject());
                     } // OriginalOrders.subject

                     if (toProperty.equals("code")){
                         originalOrdersTo = findBean.codeOriginalOrders(toValue,em);
                         f.line("to:"+toValue+":"+originalOrdersTo.getCode());
                     } // OriginalOrders.code

                     if (toProperty.equals("located")){
                         originalOrdersTo = findBean.locatedOriginalOrders(toValue,em);
                         f.line("to:"+toValue+":"+originalOrdersTo.getLocated());
                     } // OriginalOrders.located

                     if (toProperty.equals("mail")){
                         originalOrdersTo = findBean.mailOriginalOrders(toValue,em);
                         f.line("to:"+toValue+":"+originalOrdersTo.getMail());
                     } // OriginalOrders.mail

                     if (toProperty.equals("notes")){
                         originalOrdersTo = findBean.notesOriginalOrders(toValue,em);
                         f.line("to:"+toValue+":"+originalOrdersTo.getNotes());
                     } // OriginalOrders.notes

                     if (toProperty.equals("fileName")){
                         originalOrdersTo = findBean.fileNameOriginalOrders(toValue,em);
                         f.line("to:"+toValue+":"+originalOrdersTo.getFileName());
                     } // OriginalOrders.fileName

                     if (toProperty.equals("fileType")){
                         originalOrdersTo = findBean.fileTypeOriginalOrders(toValue,em);
                         f.line("to:"+toValue+":"+originalOrdersTo.getFileType());
                     } // OriginalOrders.fileType

                     if (toProperty.equals("filedir")){
                         originalOrdersTo = findBean.filedirOriginalOrders(toValue,em);
                         f.line("to:"+toValue+":"+originalOrdersTo.getFiledir());
                     } // OriginalOrders.filedir

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         originalOrdersTo.setConservationUnits(conservationUnitsFrom);
                     }

                     if (!isValidate) {
                         em.merge(originalOrdersTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "conservationUnits.txt");

                     }

                 } // from: ConservationUnits

                 if (from.equals("DocumentalInventory") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("OriginalOrders") &&
                     name.equals("")){

                     DocumentalInventory documentalInventoryFrom = new DocumentalInventory();

                     OriginalOrders originalOrdersTo = new OriginalOrders();

                     if (fromProperty.equals("object")){
                         documentalInventoryFrom = findBean.objectDocumentalInventory(fromValue,em);
                         f.line("from:"+fromValue+":"+documentalInventoryFrom.getObject());
                     } // documentalInventory

                     if (toProperty.equals("subject")){
                         originalOrdersTo = findBean.subjectOriginalOrders(toValue,em);
                         f.line("to:"+toValue+":"+originalOrdersTo.getSubject());
                     } // OriginalOrders.subject

                     if (toProperty.equals("code")){
                         originalOrdersTo = findBean.codeOriginalOrders(toValue,em);
                         f.line("to:"+toValue+":"+originalOrdersTo.getCode());
                     } // OriginalOrders.code

                     if (toProperty.equals("located")){
                         originalOrdersTo = findBean.locatedOriginalOrders(toValue,em);
                         f.line("to:"+toValue+":"+originalOrdersTo.getLocated());
                     } // OriginalOrders.located

                     if (toProperty.equals("mail")){
                         originalOrdersTo = findBean.mailOriginalOrders(toValue,em);
                         f.line("to:"+toValue+":"+originalOrdersTo.getMail());
                     } // OriginalOrders.mail

                     if (toProperty.equals("notes")){
                         originalOrdersTo = findBean.notesOriginalOrders(toValue,em);
                         f.line("to:"+toValue+":"+originalOrdersTo.getNotes());
                     } // OriginalOrders.notes

                     if (toProperty.equals("fileName")){
                         originalOrdersTo = findBean.fileNameOriginalOrders(toValue,em);
                         f.line("to:"+toValue+":"+originalOrdersTo.getFileName());
                     } // OriginalOrders.fileName

                     if (toProperty.equals("fileType")){
                         originalOrdersTo = findBean.fileTypeOriginalOrders(toValue,em);
                         f.line("to:"+toValue+":"+originalOrdersTo.getFileType());
                     } // OriginalOrders.fileType

                     if (toProperty.equals("filedir")){
                         originalOrdersTo = findBean.filedirOriginalOrders(toValue,em);
                         f.line("to:"+toValue+":"+originalOrdersTo.getFiledir());
                     } // OriginalOrders.filedir

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         originalOrdersTo.setDocumentalInventory(documentalInventoryFrom);
                     }

                     if (!isValidate) {
                         em.merge(originalOrdersTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "documentalInventory.txt");

                     }

                 } // from: DocumentalInventory

                 if (from.equals("DocumentalsUnitsTypes") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("DocumentalsUnits") &&
                     name.equals("")){

                     DocumentalsUnitsTypes documentalsUnitsTypesFrom = new DocumentalsUnitsTypes();

                     DocumentalsUnits documentalsUnitsTo = new DocumentalsUnits();

                     if (fromProperty.equals("name")){
                         documentalsUnitsTypesFrom = findBean.nameDocumentalsUnitsTypes(fromValue,em);
                         f.line("from:"+fromValue+":"+documentalsUnitsTypesFrom.getName());
                     } // documentalsUnitsTypes

                     if (toProperty.equals("name")){
                         documentalsUnitsTo = findBean.nameDocumentalsUnits(toValue,em);
                         f.line("to:"+toValue+":"+documentalsUnitsTo.getName());
                     } // DocumentalsUnits.name

                     if (toProperty.equals("code")){
                         documentalsUnitsTo = findBean.codeDocumentalsUnits(toValue,em);
                         f.line("to:"+toValue+":"+documentalsUnitsTo.getCode());
                     } // DocumentalsUnits.code

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         documentalsUnitsTo.setDocumentalsUnitsTypes(documentalsUnitsTypesFrom);
                     }

                     if (!isValidate) {
                         em.merge(documentalsUnitsTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "documentalsUnitsTypes.txt");

                     }

                 } // from: DocumentalsUnitsTypes

                 if (from.equals("Access") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("DocumentalsUnits") &&
                     name.equals("")){

                     Access accessFrom = new Access();

                     DocumentalsUnits documentalsUnitsTo = new DocumentalsUnits();

                     if (fromProperty.equals("name")){
                         accessFrom = findBean.nameAccess(fromValue,em);
                         f.line("from:"+fromValue+":"+accessFrom.getName());
                     } // access

                     if (toProperty.equals("name")){
                         documentalsUnitsTo = findBean.nameDocumentalsUnits(toValue,em);
                         f.line("to:"+toValue+":"+documentalsUnitsTo.getName());
                     } // DocumentalsUnits.name

                     if (toProperty.equals("code")){
                         documentalsUnitsTo = findBean.codeDocumentalsUnits(toValue,em);
                         f.line("to:"+toValue+":"+documentalsUnitsTo.getCode());
                     } // DocumentalsUnits.code

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         documentalsUnitsTo.setAccess(accessFrom);
                     }

                     if (!isValidate) {
                         em.merge(documentalsUnitsTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "access.txt");

                     }

                 } // from: Access

                 if (from.equals("Organizeds") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("DocumentalsUnits") &&
                     name.equals("")){

                     Organizeds organizedsFrom = new Organizeds();

                     DocumentalsUnits documentalsUnitsTo = new DocumentalsUnits();

                     if (fromProperty.equals("name")){
                         organizedsFrom = findBean.nameOrganizeds(fromValue,em);
                         f.line("from:"+fromValue+":"+organizedsFrom.getName());
                     } // organizeds

                     if (toProperty.equals("name")){
                         documentalsUnitsTo = findBean.nameDocumentalsUnits(toValue,em);
                         f.line("to:"+toValue+":"+documentalsUnitsTo.getName());
                     } // DocumentalsUnits.name

                     if (toProperty.equals("code")){
                         documentalsUnitsTo = findBean.codeDocumentalsUnits(toValue,em);
                         f.line("to:"+toValue+":"+documentalsUnitsTo.getCode());
                     } // DocumentalsUnits.code

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         documentalsUnitsTo.setOrganizeds(organizedsFrom);
                     }

                     if (!isValidate) {
                         em.merge(documentalsUnitsTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "organizeds.txt");

                     }

                 } // from: Organizeds

                 if (from.equals("InventoryFinality") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("DocumentalInventory") &&
                     name.equals("")){

                     InventoryFinality inventoryFinalityFrom = new InventoryFinality();

                     DocumentalInventory documentalInventoryTo = new DocumentalInventory();

                     if (fromProperty.equals("name")){
                         inventoryFinalityFrom = findBean.nameInventoryFinality(fromValue,em);
                         f.line("from:"+fromValue+":"+inventoryFinalityFrom.getName());
                     } // inventoryFinality

                     if (toProperty.equals("object")){
                         documentalInventoryTo = findBean.objectDocumentalInventory(toValue,em);
                         f.line("to:"+toValue+":"+documentalInventoryTo.getObject());
                     } // DocumentalInventory.object

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         documentalInventoryTo.setInventoryFinality(inventoryFinalityFrom);
                     }

                     if (!isValidate) {
                         em.merge(documentalInventoryTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "inventoryFinality.txt");

                     }

                 } // from: InventoryFinality

                 if (from.equals("DocumentalsSupports") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("OriginalOrders") &&
                     name.equals("")){

                     DocumentalsSupports documentalsSupportsFrom = new DocumentalsSupports();

                     OriginalOrders originalOrdersTo = new OriginalOrders();

                     if (fromProperty.equals("name")){
                         documentalsSupportsFrom = findBean.nameDocumentalsSupports(fromValue,em);
                         f.line("from:"+fromValue+":"+documentalsSupportsFrom.getName());
                     } // documentalsSupports

                     if (fromProperty.equals("code")){
                         documentalsSupportsFrom = findBean.codeDocumentalsSupports(fromValue,em);
                         f.line("from:"+fromValue+":"+documentalsSupportsFrom.getCode());
                     } // documentalsSupports

                     if (toProperty.equals("subject")){
                         originalOrdersTo = findBean.subjectOriginalOrders(toValue,em);
                         f.line("to:"+toValue+":"+originalOrdersTo.getSubject());
                     } // OriginalOrders.subject

                     if (toProperty.equals("code")){
                         originalOrdersTo = findBean.codeOriginalOrders(toValue,em);
                         f.line("to:"+toValue+":"+originalOrdersTo.getCode());
                     } // OriginalOrders.code

                     if (toProperty.equals("located")){
                         originalOrdersTo = findBean.locatedOriginalOrders(toValue,em);
                         f.line("to:"+toValue+":"+originalOrdersTo.getLocated());
                     } // OriginalOrders.located

                     if (toProperty.equals("mail")){
                         originalOrdersTo = findBean.mailOriginalOrders(toValue,em);
                         f.line("to:"+toValue+":"+originalOrdersTo.getMail());
                     } // OriginalOrders.mail

                     if (toProperty.equals("notes")){
                         originalOrdersTo = findBean.notesOriginalOrders(toValue,em);
                         f.line("to:"+toValue+":"+originalOrdersTo.getNotes());
                     } // OriginalOrders.notes

                     if (toProperty.equals("fileName")){
                         originalOrdersTo = findBean.fileNameOriginalOrders(toValue,em);
                         f.line("to:"+toValue+":"+originalOrdersTo.getFileName());
                     } // OriginalOrders.fileName

                     if (toProperty.equals("fileType")){
                         originalOrdersTo = findBean.fileTypeOriginalOrders(toValue,em);
                         f.line("to:"+toValue+":"+originalOrdersTo.getFileType());
                     } // OriginalOrders.fileType

                     if (toProperty.equals("filedir")){
                         originalOrdersTo = findBean.filedirOriginalOrders(toValue,em);
                         f.line("to:"+toValue+":"+originalOrdersTo.getFiledir());
                     } // OriginalOrders.filedir

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         originalOrdersTo.setDocumentalsSupports(documentalsSupportsFrom);
                     }

                     if (!isValidate) {
                         em.merge(originalOrdersTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "documentalsSupports.txt");

                     }

                 } // from: DocumentalsSupports

                 if (from.equals("ConservationUnitsTypes") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("ConservationUnits") &&
                     name.equals("")){

                     ConservationUnitsTypes conservationUnitsTypesFrom = new ConservationUnitsTypes();

                     ConservationUnits conservationUnitsTo = new ConservationUnits();

                     if (fromProperty.equals("name")){
                         conservationUnitsTypesFrom = findBean.nameConservationUnitsTypes(fromValue,em);
                         f.line("from:"+fromValue+":"+conservationUnitsTypesFrom.getName());
                     } // conservationUnitsTypes

                     if (toProperty.equals("name")){
                         conservationUnitsTo = findBean.nameConservationUnits(toValue,em);
                         f.line("to:"+toValue+":"+conservationUnitsTo.getName());
                     } // ConservationUnits.name

                     if (toProperty.equals("code")){
                         conservationUnitsTo = findBean.codeConservationUnits(toValue,em);
                         f.line("to:"+toValue+":"+conservationUnitsTo.getCode());
                     } // ConservationUnits.code

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         conservationUnitsTo.setConservationUnitsTypes(conservationUnitsTypesFrom);
                     }

                     if (!isValidate) {
                         em.merge(conservationUnitsTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "conservationUnitsTypes.txt");

                     }

                 } // from: ConservationUnitsTypes

                 if (from.equals("ConservationUnitsTypes") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("OriginalOrders") &&
                     name.equals("")){

                     ConservationUnitsTypes conservationUnitsTypesFrom = new ConservationUnitsTypes();

                     OriginalOrders originalOrdersTo = new OriginalOrders();

                     if (fromProperty.equals("name")){
                         conservationUnitsTypesFrom = findBean.nameConservationUnitsTypes(fromValue,em);
                         f.line("from:"+fromValue+":"+conservationUnitsTypesFrom.getName());
                     } // conservationUnitsTypes

                     if (toProperty.equals("subject")){
                         originalOrdersTo = findBean.subjectOriginalOrders(toValue,em);
                         f.line("to:"+toValue+":"+originalOrdersTo.getSubject());
                     } // OriginalOrders.subject

                     if (toProperty.equals("code")){
                         originalOrdersTo = findBean.codeOriginalOrders(toValue,em);
                         f.line("to:"+toValue+":"+originalOrdersTo.getCode());
                     } // OriginalOrders.code

                     if (toProperty.equals("located")){
                         originalOrdersTo = findBean.locatedOriginalOrders(toValue,em);
                         f.line("to:"+toValue+":"+originalOrdersTo.getLocated());
                     } // OriginalOrders.located

                     if (toProperty.equals("mail")){
                         originalOrdersTo = findBean.mailOriginalOrders(toValue,em);
                         f.line("to:"+toValue+":"+originalOrdersTo.getMail());
                     } // OriginalOrders.mail

                     if (toProperty.equals("notes")){
                         originalOrdersTo = findBean.notesOriginalOrders(toValue,em);
                         f.line("to:"+toValue+":"+originalOrdersTo.getNotes());
                     } // OriginalOrders.notes

                     if (toProperty.equals("fileName")){
                         originalOrdersTo = findBean.fileNameOriginalOrders(toValue,em);
                         f.line("to:"+toValue+":"+originalOrdersTo.getFileName());
                     } // OriginalOrders.fileName

                     if (toProperty.equals("fileType")){
                         originalOrdersTo = findBean.fileTypeOriginalOrders(toValue,em);
                         f.line("to:"+toValue+":"+originalOrdersTo.getFileType());
                     } // OriginalOrders.fileType

                     if (toProperty.equals("filedir")){
                         originalOrdersTo = findBean.filedirOriginalOrders(toValue,em);
                         f.line("to:"+toValue+":"+originalOrdersTo.getFiledir());
                     } // OriginalOrders.filedir

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         originalOrdersTo.setConservationUnitsTypes(conservationUnitsTypesFrom);
                     }

                     if (!isValidate) {
                         em.merge(originalOrdersTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "conservationUnitsTypes.txt");

                     }

                 } // from: ConservationUnitsTypes

                 if (from.equals("Companies") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("Funds") &&
                     name.equals("")){

                     Companies companiesFrom = new Companies();

                     Funds fundsTo = new Funds();

                     if (fromProperty.equals("name")){
                         companiesFrom = findBean.nameCompanies(fromValue,em);
                         f.line("from:"+fromValue+":"+companiesFrom.getName());
                     } // companies

                     if (toProperty.equals("name")){
                         fundsTo = findBean.nameFunds(toValue,em);
                         f.line("to:"+toValue+":"+fundsTo.getName());
                     } // Funds.name

                     if (toProperty.equals("code")){
                         fundsTo = findBean.codeFunds(toValue,em);
                         f.line("to:"+toValue+":"+fundsTo.getCode());
                     } // Funds.code

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         fundsTo.setCompanies(companiesFrom);
                     }

                     if (!isValidate) {
                         em.merge(fundsTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "companies.txt");

                     }

                 } // from: Companies

                 if (from.equals("CompaniesRoles") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("DocumentalsUnits") &&
                     name.equals("almacenamiento")){

                     CompaniesRoles companiesRolesFrom = new CompaniesRoles();

                     DocumentalsUnits documentalsUnitsTo = new DocumentalsUnits();

                     if (fromProperty.equals("name")){
                         companiesRolesFrom = findBean.nameCompaniesRoles(fromValue,em);
                         f.line("from:"+fromValue+":"+companiesRolesFrom.getName());
                     } // companiesRoles

                     if (toProperty.equals("name")){
                         documentalsUnitsTo = findBean.nameDocumentalsUnits(toValue,em);
                         f.line("to:"+toValue+":"+documentalsUnitsTo.getName());
                     } // DocumentalsUnits.name

                     if (toProperty.equals("code")){
                         documentalsUnitsTo = findBean.codeDocumentalsUnits(toValue,em);
                         f.line("to:"+toValue+":"+documentalsUnitsTo.getCode());
                     } // DocumentalsUnits.code

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         documentalsUnitsTo.setAlmacenamiento(companiesRolesFrom);
                     }

                     if (!isValidate) {
                         em.merge(documentalsUnitsTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "companiesRoles.txt");

                     }

                 } // from: CompaniesRoles

                 if (from.equals("CompaniesRoles") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("DocumentalsUnits") &&
                     name.equals("proteccion")){

                     CompaniesRoles companiesRolesFrom = new CompaniesRoles();

                     DocumentalsUnits documentalsUnitsTo = new DocumentalsUnits();

                     if (fromProperty.equals("name")){
                         companiesRolesFrom = findBean.nameCompaniesRoles(fromValue,em);
                         f.line("from:"+fromValue+":"+companiesRolesFrom.getName());
                     } // companiesRoles

                     if (toProperty.equals("name")){
                         documentalsUnitsTo = findBean.nameDocumentalsUnits(toValue,em);
                         f.line("to:"+toValue+":"+documentalsUnitsTo.getName());
                     } // DocumentalsUnits.name

                     if (toProperty.equals("code")){
                         documentalsUnitsTo = findBean.codeDocumentalsUnits(toValue,em);
                         f.line("to:"+toValue+":"+documentalsUnitsTo.getCode());
                     } // DocumentalsUnits.code

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         documentalsUnitsTo.setProteccion(companiesRolesFrom);
                     }

                     if (!isValidate) {
                         em.merge(documentalsUnitsTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "companiesRoles.txt");

                     }

                 } // from: CompaniesRoles

           } // while

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

    } // relationshipsData()

}

