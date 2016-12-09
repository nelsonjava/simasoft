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
DocumentalsUnits::DocumentalsUnits Uno a Muchos Bidirecccional No.5 ContinualImprovements 
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
BooksTypes::BooksTypes Uno a Muchos Bidirecccional No.5 Books 
BooksTypes::BooksTypes Uno a Muchos Bidirecccional No.5 BooksTypes 
Books::Books Uno a Muchos Bidirecccional No.5 Activities 
Books::Books Uno a Muchos Bidirecccional No.5 Chapters 
Chapters::Chapters Uno a Muchos Bidirecccional No.5 Diaries 
Chapters::Chapters Uno a Muchos Bidirecccional No.5 Tasks 
Chapters::Chapters Uno a Muchos Bidirecccional No.5 Chapters 
Companies::Companies Uno a Muchos Bidirecccional No.5 Funds 
Companies::Companies Uno a Muchos Bidirecccional No.5 Brands 
Companies::Companies Uno a Muchos Bidirecccional No.5 Employees 
Companies::Companies Uno a Muchos Bidirecccional No.5 Companies 
EmployeesTypes::EmployeesTypes Uno a Muchos Bidirecccional No.5 Employees 
CompaniesRolesTypes::CompaniesRolesTypes Uno a Muchos Bidirecccional No.5 CompaniesRoles 
CompaniesRolesTypes::CompaniesRolesTypes Uno a Muchos Bidirecccional No.5 CompaniesRolesTypes 
CompaniesRoles::CompaniesRoles Uno a Muchos Bidirecccional No.5 DocumentalsUnits almacenamiento
CompaniesRoles::CompaniesRoles Uno a Muchos Bidirecccional No.5 DocumentalsUnits proteccion
ChargesTypes::ChargesTypes Uno a Muchos Bidirecccional No.5 Charges 
ChargesTypes::ChargesTypes Uno a Muchos Bidirecccional No.5 ChargesTypes 
Pom::Pom Uno a Muchos Bidirecccional No.5 Dependencies 
Dependencies::Dependencies Uno a Muchos Bidirecccional No.5 Imports 
AttributesTypes::AttributesTypes Uno a Muchos Bidirecccional No.5 Fields 
ImprovementTypes::ImprovementTypes Uno a Muchos Bidirecccional No.5 ContinualImprovements 
ImprovementSources::ImprovementSources Uno a Muchos Bidirecccional No.5 ContinualImprovements 
ContinualImprovements::ContinualImprovements Uno a Muchos Bidirecccional No.5 OriginalOrders 
ContinualImprovements::ContinualImprovements Uno a Muchos Bidirecccional No.5 ActionPlans 
ImprovementVerifications::ImprovementVerifications Uno a Muchos Bidirecccional No.5 ContinualImprovements 
ImprovementClosures::ImprovementClosures Uno a Muchos Bidirecccional No.5 ClosingActivities 
ImprovementClosures::ImprovementClosures Uno a Muchos Bidirecccional No.5 ContinualImprovements 
Models::Models Uno a Muchos Bidirecccional No.5 ModelRelationships 
Relationships::Relationships Uno a Muchos Bidirecccional No.5 ModelRelationships 
Cardinalities::Cardinalities Uno a Muchos Bidirecccional No.5 Cardinalities 
Cardinalities::Cardinalities Uno a Muchos Bidirecccional No.5 Relationships 
Entities::Entities Uno a Muchos Bidirecccional No.5 Relationships from
Entities::Entities Uno a Muchos Bidirecccional No.5 Attributes 
Entities::Entities Uno a Muchos Bidirecccional No.5 Relationships to
GroupIds::GroupIds Uno a Muchos Bidirecccional No.5 Models 
GroupIds::GroupIds Uno a Muchos Bidirecccional No.5 Entities 
GroupIdsTypes::GroupIdsTypes Uno a Muchos Bidirecccional No.5 ModelsGroups 
GroupIdsTypes::GroupIdsTypes Uno a Muchos Bidirecccional No.5 GroupIds 
Persons::Persons Uno a Muchos Bidirecccional No.5 Tasks 
Persons::Persons Uno a Muchos Bidirecccional No.5 Activities 
Persons::Persons Uno a Muchos Bidirecccional No.5 Employees 
SitesTypes::SitesTypes Uno a Muchos Bidirecccional No.5 SitesTypes 
ActivitiesTypes::ActivitiesTypes Uno a Muchos Bidirecccional No.5 Activities 
Activities::Activities Uno a Muchos Bidirecccional No.5 Activities 
Activities::Activities Uno a Muchos Bidirecccional No.5 Tasks 
Tasks::Tasks Uno a Muchos Bidirecccional No.5 Diaries 
Priorities::Priorities Uno a Muchos Bidirecccional No.5 Tasks 
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
                     to.equals("ContinualImprovements") &&
                     name.equals("")){

                     DocumentalsUnits documentalsUnitsFrom = new DocumentalsUnits();

                     ContinualImprovements continualImprovementsTo = new ContinualImprovements();

                     if (fromProperty.equals("name")){
                         documentalsUnitsFrom = findBean.nameDocumentalsUnits(fromValue,em);
                         f.line("from:"+fromValue+":"+documentalsUnitsFrom.getName());
                     } // documentalsUnits

                     if (fromProperty.equals("code")){
                         documentalsUnitsFrom = findBean.codeDocumentalsUnits(fromValue,em);
                         f.line("from:"+fromValue+":"+documentalsUnitsFrom.getCode());
                     } // documentalsUnits

                     if (toProperty.equals("code")){
                         continualImprovementsTo = findBean.codeContinualImprovements(toValue,em);
                         f.line("to:"+toValue+":"+continualImprovementsTo.getCode());
                     } // ContinualImprovements.code

                     if (toProperty.equals("description")){
                         continualImprovementsTo = findBean.descriptionContinualImprovements(toValue,em);
                         f.line("to:"+toValue+":"+continualImprovementsTo.getDescription());
                     } // ContinualImprovements.description

                     if (toProperty.equals("causesAnalysis")){
                         continualImprovementsTo = findBean.causesAnalysisContinualImprovements(toValue,em);
                         f.line("to:"+toValue+":"+continualImprovementsTo.getCausesAnalysis());
                     } // ContinualImprovements.causesAnalysis

                     if (toProperty.equals("rootCause")){
                         continualImprovementsTo = findBean.rootCauseContinualImprovements(toValue,em);
                         f.line("to:"+toValue+":"+continualImprovementsTo.getRootCause());
                     } // ContinualImprovements.rootCause

                     if (toProperty.equals("immediateCorrection")){
                         continualImprovementsTo = findBean.immediateCorrectionContinualImprovements(toValue,em);
                         f.line("to:"+toValue+":"+continualImprovementsTo.getImmediateCorrection());
                     } // ContinualImprovements.immediateCorrection

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         continualImprovementsTo.setDocumentalsUnits(documentalsUnitsFrom);
                     }

                     if (!isValidate) {
                         em.merge(continualImprovementsTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "documentalsUnits.txt");

                     }

                 } // from: DocumentalsUnits

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

                 if (from.equals("BooksTypes") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("Books") &&
                     name.equals("")){

                     BooksTypes booksTypesFrom = new BooksTypes();

                     Books booksTo = new Books();

                     if (fromProperty.equals("name")){
                         booksTypesFrom = findBean.nameBooksTypes(fromValue,em);
                         f.line("from:"+fromValue+":"+booksTypesFrom.getName());
                     } // booksTypes

                     if (toProperty.equals("code")){
                         booksTo = findBean.codeBooks(toValue,em);
                         f.line("to:"+toValue+":"+booksTo.getCode());
                     } // Books.code

                     if (toProperty.equals("name")){
                         booksTo = findBean.nameBooks(toValue,em);
                         f.line("to:"+toValue+":"+booksTo.getName());
                     } // Books.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         booksTo.setBooksTypes(booksTypesFrom);
                     }

                     if (!isValidate) {
                         em.merge(booksTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "booksTypes.txt");

                     }

                 } // from: BooksTypes

                 if (from.equals("BooksTypes") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("BooksTypes") &&
                     name.equals("")){

                     BooksTypes booksTypesFrom = new BooksTypes();

                     BooksTypes booksTypesTo = new BooksTypes();

                     if (fromProperty.equals("name")){
                         booksTypesFrom = findBean.nameBooksTypes(fromValue,em);
                         f.line("from:"+fromValue+":"+booksTypesFrom.getName());
                     } // booksTypes

                     if (toProperty.equals("name")){
                         booksTypesTo = findBean.nameBooksTypes(toValue,em);
                         f.line("to:"+toValue+":"+booksTypesTo.getName());
                     } // BooksTypes.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         booksTypesTo.setObjPadre(booksTypesFrom);
                     }

                     if (!isValidate) {
                         em.merge(booksTypesTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "booksTypes.txt");

                     }

                 } // from: BooksTypes

                 if (from.equals("Books") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("Activities") &&
                     name.equals("")){

                     Books booksFrom = new Books();

                     Activities activitiesTo = new Activities();

                     if (fromProperty.equals("code")){
                         booksFrom = findBean.codeBooks(fromValue,em);
                         f.line("from:"+fromValue+":"+booksFrom.getCode());
                     } // books

                     if (fromProperty.equals("name")){
                         booksFrom = findBean.nameBooks(fromValue,em);
                         f.line("from:"+fromValue+":"+booksFrom.getName());
                     } // books

                     if (toProperty.equals("name")){
                         activitiesTo = findBean.nameActivities(toValue,em);
                         f.line("to:"+toValue+":"+activitiesTo.getName());
                     } // Activities.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         activitiesTo.setBooks(booksFrom);
                     }

                     if (!isValidate) {
                         em.merge(activitiesTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "books.txt");

                     }

                 } // from: Books

                 if (from.equals("Books") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("Chapters") &&
                     name.equals("")){

                     Books booksFrom = new Books();

                     Chapters chaptersTo = new Chapters();

                     if (fromProperty.equals("code")){
                         booksFrom = findBean.codeBooks(fromValue,em);
                         f.line("from:"+fromValue+":"+booksFrom.getCode());
                     } // books

                     if (fromProperty.equals("name")){
                         booksFrom = findBean.nameBooks(fromValue,em);
                         f.line("from:"+fromValue+":"+booksFrom.getName());
                     } // books

                     if (toProperty.equals("code")){
                         chaptersTo = findBean.codeChapters(toValue,em);
                         f.line("to:"+toValue+":"+chaptersTo.getCode());
                     } // Chapters.code

                     if (toProperty.equals("name")){
                         chaptersTo = findBean.nameChapters(toValue,em);
                         f.line("to:"+toValue+":"+chaptersTo.getName());
                     } // Chapters.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         chaptersTo.setBooks(booksFrom);
                     }

                     if (!isValidate) {
                         em.merge(chaptersTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "books.txt");

                     }

                 } // from: Books

                 if (from.equals("Chapters") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("Diaries") &&
                     name.equals("")){

                     Chapters chaptersFrom = new Chapters();

                     Diaries diariesTo = new Diaries();

                     if (fromProperty.equals("code")){
                         chaptersFrom = findBean.codeChapters(fromValue,em);
                         f.line("from:"+fromValue+":"+chaptersFrom.getCode());
                     } // chapters

                     if (fromProperty.equals("name")){
                         chaptersFrom = findBean.nameChapters(fromValue,em);
                         f.line("from:"+fromValue+":"+chaptersFrom.getName());
                     } // chapters

                     if (toProperty.equals("name")){
                         diariesTo = findBean.nameDiaries(toValue,em);
                         f.line("to:"+toValue+":"+diariesTo.getName());
                     } // Diaries.name

                     if (toProperty.equals("description")){
                         diariesTo = findBean.descriptionDiaries(toValue,em);
                         f.line("to:"+toValue+":"+diariesTo.getDescription());
                     } // Diaries.description

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         diariesTo.setChapters(chaptersFrom);
                     }

                     if (!isValidate) {
                         em.merge(diariesTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "chapters.txt");

                     }

                 } // from: Chapters

                 if (from.equals("Chapters") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("Tasks") &&
                     name.equals("")){

                     Chapters chaptersFrom = new Chapters();

                     Tasks tasksTo = new Tasks();

                     if (fromProperty.equals("code")){
                         chaptersFrom = findBean.codeChapters(fromValue,em);
                         f.line("from:"+fromValue+":"+chaptersFrom.getCode());
                     } // chapters

                     if (fromProperty.equals("name")){
                         chaptersFrom = findBean.nameChapters(fromValue,em);
                         f.line("from:"+fromValue+":"+chaptersFrom.getName());
                     } // chapters

                     if (toProperty.equals("name")){
                         tasksTo = findBean.nameTasks(toValue,em);
                         f.line("to:"+toValue+":"+tasksTo.getName());
                     } // Tasks.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         tasksTo.setChapters(chaptersFrom);
                     }

                     if (!isValidate) {
                         em.merge(tasksTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "chapters.txt");

                     }

                 } // from: Chapters

                 if (from.equals("Chapters") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("Chapters") &&
                     name.equals("")){

                     Chapters chaptersFrom = new Chapters();

                     Chapters chaptersTo = new Chapters();

                     if (fromProperty.equals("code")){
                         chaptersFrom = findBean.codeChapters(fromValue,em);
                         f.line("from:"+fromValue+":"+chaptersFrom.getCode());
                     } // chapters

                     if (fromProperty.equals("name")){
                         chaptersFrom = findBean.nameChapters(fromValue,em);
                         f.line("from:"+fromValue+":"+chaptersFrom.getName());
                     } // chapters

                     if (toProperty.equals("code")){
                         chaptersTo = findBean.codeChapters(toValue,em);
                         f.line("to:"+toValue+":"+chaptersTo.getCode());
                     } // Chapters.code

                     if (toProperty.equals("name")){
                         chaptersTo = findBean.nameChapters(toValue,em);
                         f.line("to:"+toValue+":"+chaptersTo.getName());
                     } // Chapters.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         chaptersTo.setObjPadre(chaptersFrom);
                     }

                     if (!isValidate) {
                         em.merge(chaptersTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "chapters.txt");

                     }

                 } // from: Chapters

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

                 if (from.equals("Companies") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("Brands") &&
                     name.equals("")){

                     Companies companiesFrom = new Companies();

                     Brands brandsTo = new Brands();

                     if (fromProperty.equals("name")){
                         companiesFrom = findBean.nameCompanies(fromValue,em);
                         f.line("from:"+fromValue+":"+companiesFrom.getName());
                     } // companies

                     if (toProperty.equals("name")){
                         brandsTo = findBean.nameBrands(toValue,em);
                         f.line("to:"+toValue+":"+brandsTo.getName());
                     } // Brands.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         brandsTo.setCompanies(companiesFrom);
                     }

                     if (!isValidate) {
                         em.merge(brandsTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "companies.txt");

                     }

                 } // from: Companies

                 if (from.equals("Companies") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("Employees") &&
                     name.equals("")){

                     Companies companiesFrom = new Companies();

                     Employees employeesTo = new Employees();

                     if (fromProperty.equals("name")){
                         companiesFrom = findBean.nameCompanies(fromValue,em);
                         f.line("from:"+fromValue+":"+companiesFrom.getName());
                     } // companies

                     if (toProperty.equals("code")){
                         employeesTo = findBean.codeEmployees(toValue,em);
                         f.line("to:"+toValue+":"+employeesTo.getCode());
                     } // Employees.code

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         employeesTo.setCompanies(companiesFrom);
                     }

                     if (!isValidate) {
                         em.merge(employeesTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "companies.txt");

                     }

                 } // from: Companies

                 if (from.equals("Companies") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("Companies") &&
                     name.equals("")){

                     Companies companiesFrom = new Companies();

                     Companies companiesTo = new Companies();

                     if (fromProperty.equals("name")){
                         companiesFrom = findBean.nameCompanies(fromValue,em);
                         f.line("from:"+fromValue+":"+companiesFrom.getName());
                     } // companies

                     if (toProperty.equals("name")){
                         companiesTo = findBean.nameCompanies(toValue,em);
                         f.line("to:"+toValue+":"+companiesTo.getName());
                     } // Companies.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         companiesTo.setObjPadre(companiesFrom);
                     }

                     if (!isValidate) {
                         em.merge(companiesTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "companies.txt");

                     }

                 } // from: Companies

                 if (from.equals("EmployeesTypes") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("Employees") &&
                     name.equals("")){

                     EmployeesTypes employeesTypesFrom = new EmployeesTypes();

                     Employees employeesTo = new Employees();

                     if (fromProperty.equals("name")){
                         employeesTypesFrom = findBean.nameEmployeesTypes(fromValue,em);
                         f.line("from:"+fromValue+":"+employeesTypesFrom.getName());
                     } // employeesTypes

                     if (toProperty.equals("code")){
                         employeesTo = findBean.codeEmployees(toValue,em);
                         f.line("to:"+toValue+":"+employeesTo.getCode());
                     } // Employees.code

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         employeesTo.setEmployeesTypes(employeesTypesFrom);
                     }

                     if (!isValidate) {
                         em.merge(employeesTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "employeesTypes.txt");

                     }

                 } // from: EmployeesTypes

                 if (from.equals("CompaniesRolesTypes") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("CompaniesRoles") &&
                     name.equals("")){

                     CompaniesRolesTypes companiesRolesTypesFrom = new CompaniesRolesTypes();

                     CompaniesRoles companiesRolesTo = new CompaniesRoles();

                     if (fromProperty.equals("name")){
                         companiesRolesTypesFrom = findBean.nameCompaniesRolesTypes(fromValue,em);
                         f.line("from:"+fromValue+":"+companiesRolesTypesFrom.getName());
                     } // companiesRolesTypes

                     if (toProperty.equals("name")){
                         companiesRolesTo = findBean.nameCompaniesRoles(toValue,em);
                         f.line("to:"+toValue+":"+companiesRolesTo.getName());
                     } // CompaniesRoles.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         companiesRolesTo.setCompaniesRolesTypes(companiesRolesTypesFrom);
                     }

                     if (!isValidate) {
                         em.merge(companiesRolesTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "companiesRolesTypes.txt");

                     }

                 } // from: CompaniesRolesTypes

                 if (from.equals("CompaniesRolesTypes") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("CompaniesRolesTypes") &&
                     name.equals("")){

                     CompaniesRolesTypes companiesRolesTypesFrom = new CompaniesRolesTypes();

                     CompaniesRolesTypes companiesRolesTypesTo = new CompaniesRolesTypes();

                     if (fromProperty.equals("name")){
                         companiesRolesTypesFrom = findBean.nameCompaniesRolesTypes(fromValue,em);
                         f.line("from:"+fromValue+":"+companiesRolesTypesFrom.getName());
                     } // companiesRolesTypes

                     if (toProperty.equals("name")){
                         companiesRolesTypesTo = findBean.nameCompaniesRolesTypes(toValue,em);
                         f.line("to:"+toValue+":"+companiesRolesTypesTo.getName());
                     } // CompaniesRolesTypes.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         companiesRolesTypesTo.setObjPadre(companiesRolesTypesFrom);
                     }

                     if (!isValidate) {
                         em.merge(companiesRolesTypesTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "companiesRolesTypes.txt");

                     }

                 } // from: CompaniesRolesTypes

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

                 if (from.equals("ChargesTypes") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("Charges") &&
                     name.equals("")){

                     ChargesTypes chargesTypesFrom = new ChargesTypes();

                     Charges chargesTo = new Charges();

                     if (fromProperty.equals("name")){
                         chargesTypesFrom = findBean.nameChargesTypes(fromValue,em);
                         f.line("from:"+fromValue+":"+chargesTypesFrom.getName());
                     } // chargesTypes

                     if (toProperty.equals("name")){
                         chargesTo = findBean.nameCharges(toValue,em);
                         f.line("to:"+toValue+":"+chargesTo.getName());
                     } // Charges.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         chargesTo.setChargesTypes(chargesTypesFrom);
                     }

                     if (!isValidate) {
                         em.merge(chargesTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "chargesTypes.txt");

                     }

                 } // from: ChargesTypes

                 if (from.equals("ChargesTypes") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("ChargesTypes") &&
                     name.equals("")){

                     ChargesTypes chargesTypesFrom = new ChargesTypes();

                     ChargesTypes chargesTypesTo = new ChargesTypes();

                     if (fromProperty.equals("name")){
                         chargesTypesFrom = findBean.nameChargesTypes(fromValue,em);
                         f.line("from:"+fromValue+":"+chargesTypesFrom.getName());
                     } // chargesTypes

                     if (toProperty.equals("name")){
                         chargesTypesTo = findBean.nameChargesTypes(toValue,em);
                         f.line("to:"+toValue+":"+chargesTypesTo.getName());
                     } // ChargesTypes.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         chargesTypesTo.setObjPadre(chargesTypesFrom);
                     }

                     if (!isValidate) {
                         em.merge(chargesTypesTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "chargesTypes.txt");

                     }

                 } // from: ChargesTypes

                 if (from.equals("Pom") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("Dependencies") &&
                     name.equals("")){

                     Pom pomFrom = new Pom();

                     Dependencies dependenciesTo = new Dependencies();

                     if (fromProperty.equals("groupId")){
                         pomFrom = findBean.groupIdPom(fromValue,em);
                         f.line("from:"+fromValue+":"+pomFrom.getGroupId());
                     } // pom

                     if (fromProperty.equals("artifactId")){
                         pomFrom = findBean.artifactIdPom(fromValue,em);
                         f.line("from:"+fromValue+":"+pomFrom.getArtifactId());
                     } // pom

                     if (fromProperty.equals("version")){
                         pomFrom = findBean.versionPom(fromValue,em);
                         f.line("from:"+fromValue+":"+pomFrom.getVersion());
                     } // pom

                     if (toProperty.equals("groupId")){
                         dependenciesTo = findBean.groupIdDependencies(toValue,em);
                         f.line("to:"+toValue+":"+dependenciesTo.getGroupId());
                     } // Dependencies.groupId

                     if (toProperty.equals("artifactId")){
                         dependenciesTo = findBean.artifactIdDependencies(toValue,em);
                         f.line("to:"+toValue+":"+dependenciesTo.getArtifactId());
                     } // Dependencies.artifactId

                     if (toProperty.equals("version")){
                         dependenciesTo = findBean.versionDependencies(toValue,em);
                         f.line("to:"+toValue+":"+dependenciesTo.getVersion());
                     } // Dependencies.version

                     if (toProperty.equals("type")){
                         dependenciesTo = findBean.typeDependencies(toValue,em);
                         f.line("to:"+toValue+":"+dependenciesTo.getType());
                     } // Dependencies.type

                     if (toProperty.equals("scope")){
                         dependenciesTo = findBean.scopeDependencies(toValue,em);
                         f.line("to:"+toValue+":"+dependenciesTo.getScope());
                     } // Dependencies.scope

                     if (toProperty.equals("maven")){
                         dependenciesTo = findBean.mavenDependencies(toValue,em);
                         f.line("to:"+toValue+":"+dependenciesTo.getMaven());
                     } // Dependencies.maven

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         dependenciesTo.setPom(pomFrom);
                     }

                     if (!isValidate) {
                         em.merge(dependenciesTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "pom.txt");

                     }

                 } // from: Pom

                 if (from.equals("Dependencies") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("Imports") &&
                     name.equals("")){

                     Dependencies dependenciesFrom = new Dependencies();

                     Imports importsTo = new Imports();

                     if (fromProperty.equals("groupId")){
                         dependenciesFrom = findBean.groupIdDependencies(fromValue,em);
                         f.line("from:"+fromValue+":"+dependenciesFrom.getGroupId());
                     } // dependencies

                     if (fromProperty.equals("artifactId")){
                         dependenciesFrom = findBean.artifactIdDependencies(fromValue,em);
                         f.line("from:"+fromValue+":"+dependenciesFrom.getArtifactId());
                     } // dependencies

                     if (fromProperty.equals("version")){
                         dependenciesFrom = findBean.versionDependencies(fromValue,em);
                         f.line("from:"+fromValue+":"+dependenciesFrom.getVersion());
                     } // dependencies

                     if (fromProperty.equals("type")){
                         dependenciesFrom = findBean.typeDependencies(fromValue,em);
                         f.line("from:"+fromValue+":"+dependenciesFrom.getType());
                     } // dependencies

                     if (fromProperty.equals("scope")){
                         dependenciesFrom = findBean.scopeDependencies(fromValue,em);
                         f.line("from:"+fromValue+":"+dependenciesFrom.getScope());
                     } // dependencies

                     if (fromProperty.equals("maven")){
                         dependenciesFrom = findBean.mavenDependencies(fromValue,em);
                         f.line("from:"+fromValue+":"+dependenciesFrom.getMaven());
                     } // dependencies

                     if (toProperty.equals("name")){
                         importsTo = findBean.nameImports(toValue,em);
                         f.line("to:"+toValue+":"+importsTo.getName());
                     } // Imports.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         importsTo.setDependencies(dependenciesFrom);
                     }

                     if (!isValidate) {
                         em.merge(importsTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "dependencies.txt");

                     }

                 } // from: Dependencies

                 if (from.equals("AttributesTypes") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("Fields") &&
                     name.equals("")){

                     AttributesTypes attributesTypesFrom = new AttributesTypes();

                     Fields fieldsTo = new Fields();

                     if (fromProperty.equals("name")){
                         attributesTypesFrom = findBean.nameAttributesTypes(fromValue,em);
                         f.line("from:"+fromValue+":"+attributesTypesFrom.getName());
                     } // attributesTypes

                     if (fromProperty.equals("type")){
                         attributesTypesFrom = findBean.typeAttributesTypes(fromValue,em);
                         f.line("from:"+fromValue+":"+attributesTypesFrom.getType());
                     } // attributesTypes

                     if (fromProperty.equals("annotations")){
                         attributesTypesFrom = findBean.annotationsAttributesTypes(fromValue,em);
                         f.line("from:"+fromValue+":"+attributesTypesFrom.getAnnotations());
                     } // attributesTypes

                     if (toProperty.equals("name")){
                         fieldsTo = findBean.nameFields(toValue,em);
                         f.line("to:"+toValue+":"+fieldsTo.getName());
                     } // Fields.name

                     if (toProperty.equals("description")){
                         fieldsTo = findBean.descriptionFields(toValue,em);
                         f.line("to:"+toValue+":"+fieldsTo.getDescription());
                     } // Fields.description

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         fieldsTo.setAttributesTypes(attributesTypesFrom);
                     }

                     if (!isValidate) {
                         em.merge(fieldsTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "attributesTypes.txt");

                     }

                 } // from: AttributesTypes

                 if (from.equals("ImprovementTypes") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("ContinualImprovements") &&
                     name.equals("")){

                     ImprovementTypes improvementTypesFrom = new ImprovementTypes();

                     ContinualImprovements continualImprovementsTo = new ContinualImprovements();

                     if (fromProperty.equals("name")){
                         improvementTypesFrom = findBean.nameImprovementTypes(fromValue,em);
                         f.line("from:"+fromValue+":"+improvementTypesFrom.getName());
                     } // improvementTypes

                     if (toProperty.equals("code")){
                         continualImprovementsTo = findBean.codeContinualImprovements(toValue,em);
                         f.line("to:"+toValue+":"+continualImprovementsTo.getCode());
                     } // ContinualImprovements.code

                     if (toProperty.equals("description")){
                         continualImprovementsTo = findBean.descriptionContinualImprovements(toValue,em);
                         f.line("to:"+toValue+":"+continualImprovementsTo.getDescription());
                     } // ContinualImprovements.description

                     if (toProperty.equals("causesAnalysis")){
                         continualImprovementsTo = findBean.causesAnalysisContinualImprovements(toValue,em);
                         f.line("to:"+toValue+":"+continualImprovementsTo.getCausesAnalysis());
                     } // ContinualImprovements.causesAnalysis

                     if (toProperty.equals("rootCause")){
                         continualImprovementsTo = findBean.rootCauseContinualImprovements(toValue,em);
                         f.line("to:"+toValue+":"+continualImprovementsTo.getRootCause());
                     } // ContinualImprovements.rootCause

                     if (toProperty.equals("immediateCorrection")){
                         continualImprovementsTo = findBean.immediateCorrectionContinualImprovements(toValue,em);
                         f.line("to:"+toValue+":"+continualImprovementsTo.getImmediateCorrection());
                     } // ContinualImprovements.immediateCorrection

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         continualImprovementsTo.setImprovementTypes(improvementTypesFrom);
                     }

                     if (!isValidate) {
                         em.merge(continualImprovementsTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "improvementTypes.txt");

                     }

                 } // from: ImprovementTypes

                 if (from.equals("ImprovementSources") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("ContinualImprovements") &&
                     name.equals("")){

                     ImprovementSources improvementSourcesFrom = new ImprovementSources();

                     ContinualImprovements continualImprovementsTo = new ContinualImprovements();

                     if (fromProperty.equals("name")){
                         improvementSourcesFrom = findBean.nameImprovementSources(fromValue,em);
                         f.line("from:"+fromValue+":"+improvementSourcesFrom.getName());
                     } // improvementSources

                     if (toProperty.equals("code")){
                         continualImprovementsTo = findBean.codeContinualImprovements(toValue,em);
                         f.line("to:"+toValue+":"+continualImprovementsTo.getCode());
                     } // ContinualImprovements.code

                     if (toProperty.equals("description")){
                         continualImprovementsTo = findBean.descriptionContinualImprovements(toValue,em);
                         f.line("to:"+toValue+":"+continualImprovementsTo.getDescription());
                     } // ContinualImprovements.description

                     if (toProperty.equals("causesAnalysis")){
                         continualImprovementsTo = findBean.causesAnalysisContinualImprovements(toValue,em);
                         f.line("to:"+toValue+":"+continualImprovementsTo.getCausesAnalysis());
                     } // ContinualImprovements.causesAnalysis

                     if (toProperty.equals("rootCause")){
                         continualImprovementsTo = findBean.rootCauseContinualImprovements(toValue,em);
                         f.line("to:"+toValue+":"+continualImprovementsTo.getRootCause());
                     } // ContinualImprovements.rootCause

                     if (toProperty.equals("immediateCorrection")){
                         continualImprovementsTo = findBean.immediateCorrectionContinualImprovements(toValue,em);
                         f.line("to:"+toValue+":"+continualImprovementsTo.getImmediateCorrection());
                     } // ContinualImprovements.immediateCorrection

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         continualImprovementsTo.setImprovementSources(improvementSourcesFrom);
                     }

                     if (!isValidate) {
                         em.merge(continualImprovementsTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "improvementSources.txt");

                     }

                 } // from: ImprovementSources

                 if (from.equals("ContinualImprovements") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("OriginalOrders") &&
                     name.equals("")){

                     ContinualImprovements continualImprovementsFrom = new ContinualImprovements();

                     OriginalOrders originalOrdersTo = new OriginalOrders();

                     if (fromProperty.equals("code")){
                         continualImprovementsFrom = findBean.codeContinualImprovements(fromValue,em);
                         f.line("from:"+fromValue+":"+continualImprovementsFrom.getCode());
                     } // continualImprovements

                     if (fromProperty.equals("description")){
                         continualImprovementsFrom = findBean.descriptionContinualImprovements(fromValue,em);
                         f.line("from:"+fromValue+":"+continualImprovementsFrom.getDescription());
                     } // continualImprovements

                     if (fromProperty.equals("causesAnalysis")){
                         continualImprovementsFrom = findBean.causesAnalysisContinualImprovements(fromValue,em);
                         f.line("from:"+fromValue+":"+continualImprovementsFrom.getCausesAnalysis());
                     } // continualImprovements

                     if (fromProperty.equals("rootCause")){
                         continualImprovementsFrom = findBean.rootCauseContinualImprovements(fromValue,em);
                         f.line("from:"+fromValue+":"+continualImprovementsFrom.getRootCause());
                     } // continualImprovements

                     if (fromProperty.equals("immediateCorrection")){
                         continualImprovementsFrom = findBean.immediateCorrectionContinualImprovements(fromValue,em);
                         f.line("from:"+fromValue+":"+continualImprovementsFrom.getImmediateCorrection());
                     } // continualImprovements

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
                         originalOrdersTo.setContinualImprovements(continualImprovementsFrom);
                     }

                     if (!isValidate) {
                         em.merge(originalOrdersTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "continualImprovements.txt");

                     }

                 } // from: ContinualImprovements

                 if (from.equals("ContinualImprovements") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("ActionPlans") &&
                     name.equals("")){

                     ContinualImprovements continualImprovementsFrom = new ContinualImprovements();

                     ActionPlans actionPlansTo = new ActionPlans();

                     if (fromProperty.equals("code")){
                         continualImprovementsFrom = findBean.codeContinualImprovements(fromValue,em);
                         f.line("from:"+fromValue+":"+continualImprovementsFrom.getCode());
                     } // continualImprovements

                     if (fromProperty.equals("description")){
                         continualImprovementsFrom = findBean.descriptionContinualImprovements(fromValue,em);
                         f.line("from:"+fromValue+":"+continualImprovementsFrom.getDescription());
                     } // continualImprovements

                     if (fromProperty.equals("causesAnalysis")){
                         continualImprovementsFrom = findBean.causesAnalysisContinualImprovements(fromValue,em);
                         f.line("from:"+fromValue+":"+continualImprovementsFrom.getCausesAnalysis());
                     } // continualImprovements

                     if (fromProperty.equals("rootCause")){
                         continualImprovementsFrom = findBean.rootCauseContinualImprovements(fromValue,em);
                         f.line("from:"+fromValue+":"+continualImprovementsFrom.getRootCause());
                     } // continualImprovements

                     if (fromProperty.equals("immediateCorrection")){
                         continualImprovementsFrom = findBean.immediateCorrectionContinualImprovements(fromValue,em);
                         f.line("from:"+fromValue+":"+continualImprovementsFrom.getImmediateCorrection());
                     } // continualImprovements

                     if (toProperty.equals("evidences")){
                         actionPlansTo = findBean.evidencesActionPlans(toValue,em);
                         f.line("to:"+toValue+":"+actionPlansTo.getEvidences());
                     } // ActionPlans.evidences

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         actionPlansTo.setContinualImprovements(continualImprovementsFrom);
                     }

                     if (!isValidate) {
                         em.merge(actionPlansTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "continualImprovements.txt");

                     }

                 } // from: ContinualImprovements

                 if (from.equals("ImprovementVerifications") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("ContinualImprovements") &&
                     name.equals("")){

                     ImprovementVerifications improvementVerificationsFrom = new ImprovementVerifications();

                     ContinualImprovements continualImprovementsTo = new ContinualImprovements();

                     if (toProperty.equals("code")){
                         continualImprovementsTo = findBean.codeContinualImprovements(toValue,em);
                         f.line("to:"+toValue+":"+continualImprovementsTo.getCode());
                     } // ContinualImprovements.code

                     if (toProperty.equals("description")){
                         continualImprovementsTo = findBean.descriptionContinualImprovements(toValue,em);
                         f.line("to:"+toValue+":"+continualImprovementsTo.getDescription());
                     } // ContinualImprovements.description

                     if (toProperty.equals("causesAnalysis")){
                         continualImprovementsTo = findBean.causesAnalysisContinualImprovements(toValue,em);
                         f.line("to:"+toValue+":"+continualImprovementsTo.getCausesAnalysis());
                     } // ContinualImprovements.causesAnalysis

                     if (toProperty.equals("rootCause")){
                         continualImprovementsTo = findBean.rootCauseContinualImprovements(toValue,em);
                         f.line("to:"+toValue+":"+continualImprovementsTo.getRootCause());
                     } // ContinualImprovements.rootCause

                     if (toProperty.equals("immediateCorrection")){
                         continualImprovementsTo = findBean.immediateCorrectionContinualImprovements(toValue,em);
                         f.line("to:"+toValue+":"+continualImprovementsTo.getImmediateCorrection());
                     } // ContinualImprovements.immediateCorrection

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         continualImprovementsTo.setImprovementVerifications(improvementVerificationsFrom);
                     }

                     if (!isValidate) {
                         em.merge(continualImprovementsTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "improvementVerifications.txt");

                     }

                 } // from: ImprovementVerifications

                 if (from.equals("ImprovementClosures") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("ClosingActivities") &&
                     name.equals("")){

                     ImprovementClosures improvementClosuresFrom = new ImprovementClosures();

                     ClosingActivities closingActivitiesTo = new ClosingActivities();

                     if (toProperty.equals("name")){
                         closingActivitiesTo = findBean.nameClosingActivities(toValue,em);
                         f.line("to:"+toValue+":"+closingActivitiesTo.getName());
                     } // ClosingActivities.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         closingActivitiesTo.setImprovementClosures(improvementClosuresFrom);
                     }

                     if (!isValidate) {
                         em.merge(closingActivitiesTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "improvementClosures.txt");

                     }

                 } // from: ImprovementClosures

                 if (from.equals("ImprovementClosures") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("ContinualImprovements") &&
                     name.equals("")){

                     ImprovementClosures improvementClosuresFrom = new ImprovementClosures();

                     ContinualImprovements continualImprovementsTo = new ContinualImprovements();

                     if (toProperty.equals("code")){
                         continualImprovementsTo = findBean.codeContinualImprovements(toValue,em);
                         f.line("to:"+toValue+":"+continualImprovementsTo.getCode());
                     } // ContinualImprovements.code

                     if (toProperty.equals("description")){
                         continualImprovementsTo = findBean.descriptionContinualImprovements(toValue,em);
                         f.line("to:"+toValue+":"+continualImprovementsTo.getDescription());
                     } // ContinualImprovements.description

                     if (toProperty.equals("causesAnalysis")){
                         continualImprovementsTo = findBean.causesAnalysisContinualImprovements(toValue,em);
                         f.line("to:"+toValue+":"+continualImprovementsTo.getCausesAnalysis());
                     } // ContinualImprovements.causesAnalysis

                     if (toProperty.equals("rootCause")){
                         continualImprovementsTo = findBean.rootCauseContinualImprovements(toValue,em);
                         f.line("to:"+toValue+":"+continualImprovementsTo.getRootCause());
                     } // ContinualImprovements.rootCause

                     if (toProperty.equals("immediateCorrection")){
                         continualImprovementsTo = findBean.immediateCorrectionContinualImprovements(toValue,em);
                         f.line("to:"+toValue+":"+continualImprovementsTo.getImmediateCorrection());
                     } // ContinualImprovements.immediateCorrection

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         continualImprovementsTo.setImprovementClosures(improvementClosuresFrom);
                     }

                     if (!isValidate) {
                         em.merge(continualImprovementsTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "improvementClosures.txt");

                     }

                 } // from: ImprovementClosures

                 if (from.equals("Models") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("ModelRelationships") &&
                     name.equals("")){

                     Models modelsFrom = new Models();

                     ModelRelationships modelRelationshipsTo = new ModelRelationships();

                     if (fromProperty.equals("name")){
                         modelsFrom = findBean.nameModels(fromValue,em);
                         f.line("from:"+fromValue+":"+modelsFrom.getName());
                     } // models

                     if (fromProperty.equals("code")){
                         modelsFrom = findBean.codeModels(fromValue,em);
                         f.line("from:"+fromValue+":"+modelsFrom.getCode());
                     } // models

                     if (fromProperty.equals("version")){
                         modelsFrom = findBean.versionModels(fromValue,em);
                         f.line("from:"+fromValue+":"+modelsFrom.getVersion());
                     } // models

                     if (toProperty.equals("name")){
                         modelRelationshipsTo = findBean.nameModelRelationships(toValue,em);
                         f.line("to:"+toValue+":"+modelRelationshipsTo.getName());
                     } // ModelRelationships.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         modelRelationshipsTo.setModels(modelsFrom);
                     }

                     if (!isValidate) {
                         em.merge(modelRelationshipsTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "models.txt");

                     }

                 } // from: Models

                 if (from.equals("Relationships") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("ModelRelationships") &&
                     name.equals("")){

                     Relationships relationshipsFrom = new Relationships();

                     ModelRelationships modelRelationshipsTo = new ModelRelationships();

                     if (fromProperty.equals("name")){
                         relationshipsFrom = findBean.nameRelationships(fromValue,em);
                         f.line("from:"+fromValue+":"+relationshipsFrom.getName());
                     } // relationships

                     if (toProperty.equals("name")){
                         modelRelationshipsTo = findBean.nameModelRelationships(toValue,em);
                         f.line("to:"+toValue+":"+modelRelationshipsTo.getName());
                     } // ModelRelationships.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         modelRelationshipsTo.setRelationships(relationshipsFrom);
                     }

                     if (!isValidate) {
                         em.merge(modelRelationshipsTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "relationships.txt");

                     }

                 } // from: Relationships

                 if (from.equals("Cardinalities") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("Cardinalities") &&
                     name.equals("")){

                     Cardinalities cardinalitiesFrom = new Cardinalities();

                     Cardinalities cardinalitiesTo = new Cardinalities();

                     if (fromProperty.equals("name")){
                         cardinalitiesFrom = findBean.nameCardinalities(fromValue,em);
                         f.line("from:"+fromValue+":"+cardinalitiesFrom.getName());
                     } // cardinalities

                     if (fromProperty.equals("cardinality")){
                         cardinalitiesFrom = findBean.cardinalityCardinalities(fromValue,em);
                         f.line("from:"+fromValue+":"+cardinalitiesFrom.getCardinality());
                     } // cardinalities

                     if (toProperty.equals("name")){
                         cardinalitiesTo = findBean.nameCardinalities(toValue,em);
                         f.line("to:"+toValue+":"+cardinalitiesTo.getName());
                     } // Cardinalities.name

                     if (toProperty.equals("cardinality")){
                         cardinalitiesTo = findBean.cardinalityCardinalities(toValue,em);
                         f.line("to:"+toValue+":"+cardinalitiesTo.getCardinality());
                     } // Cardinalities.cardinality

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         cardinalitiesTo.setObjPadre(cardinalitiesFrom);
                     }

                     if (!isValidate) {
                         em.merge(cardinalitiesTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "cardinalities.txt");

                     }

                 } // from: Cardinalities

                 if (from.equals("Cardinalities") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("Relationships") &&
                     name.equals("")){

                     Cardinalities cardinalitiesFrom = new Cardinalities();

                     Relationships relationshipsTo = new Relationships();

                     if (fromProperty.equals("name")){
                         cardinalitiesFrom = findBean.nameCardinalities(fromValue,em);
                         f.line("from:"+fromValue+":"+cardinalitiesFrom.getName());
                     } // cardinalities

                     if (fromProperty.equals("cardinality")){
                         cardinalitiesFrom = findBean.cardinalityCardinalities(fromValue,em);
                         f.line("from:"+fromValue+":"+cardinalitiesFrom.getCardinality());
                     } // cardinalities

                     if (toProperty.equals("name")){
                         relationshipsTo = findBean.nameRelationships(toValue,em);
                         f.line("to:"+toValue+":"+relationshipsTo.getName());
                     } // Relationships.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         relationshipsTo.setCardinalities(cardinalitiesFrom);
                     }

                     if (!isValidate) {
                         em.merge(relationshipsTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "cardinalities.txt");

                     }

                 } // from: Cardinalities

                 if (from.equals("Entities") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("Relationships") &&
                     name.equals("from")){

                     Entities entitiesFrom = new Entities();

                     Relationships relationshipsTo = new Relationships();

                     if (fromProperty.equals("name")){
                         entitiesFrom = findBean.nameEntities(fromValue,em);
                         f.line("from:"+fromValue+":"+entitiesFrom.getName());
                     } // entities

                     if (fromProperty.equals("serialID")){
                         entitiesFrom = findBean.serialIDEntities(fromValue,em);
                         f.line("from:"+fromValue+":"+entitiesFrom.getSerialID());
                     } // entities

                     if (fromProperty.equals("table")){
                         entitiesFrom = findBean.tableEntities(fromValue,em);
                         f.line("from:"+fromValue+":"+entitiesFrom.getTable());
                     } // entities

                     if (fromProperty.equals("description")){
                         entitiesFrom = findBean.descriptionEntities(fromValue,em);
                         f.line("from:"+fromValue+":"+entitiesFrom.getDescription());
                     } // entities

                     if (toProperty.equals("name")){
                         relationshipsTo = findBean.nameRelationships(toValue,em);
                         f.line("to:"+toValue+":"+relationshipsTo.getName());
                     } // Relationships.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         relationshipsTo.setFrom(entitiesFrom);
                     }

                     if (!isValidate) {
                         em.merge(relationshipsTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "entities.txt");

                     }

                 } // from: Entities

                 if (from.equals("Entities") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("Attributes") &&
                     name.equals("")){

                     Entities entitiesFrom = new Entities();

                     Attributes attributesTo = new Attributes();

                     if (fromProperty.equals("name")){
                         entitiesFrom = findBean.nameEntities(fromValue,em);
                         f.line("from:"+fromValue+":"+entitiesFrom.getName());
                     } // entities

                     if (fromProperty.equals("serialID")){
                         entitiesFrom = findBean.serialIDEntities(fromValue,em);
                         f.line("from:"+fromValue+":"+entitiesFrom.getSerialID());
                     } // entities

                     if (fromProperty.equals("table")){
                         entitiesFrom = findBean.tableEntities(fromValue,em);
                         f.line("from:"+fromValue+":"+entitiesFrom.getTable());
                     } // entities

                     if (fromProperty.equals("description")){
                         entitiesFrom = findBean.descriptionEntities(fromValue,em);
                         f.line("from:"+fromValue+":"+entitiesFrom.getDescription());
                     } // entities

                     if (toProperty.equals("name")){
                         attributesTo = findBean.nameAttributes(toValue,em);
                         f.line("to:"+toValue+":"+attributesTo.getName());
                     } // Attributes.name

                     if (toProperty.equals("description")){
                         attributesTo = findBean.descriptionAttributes(toValue,em);
                         f.line("to:"+toValue+":"+attributesTo.getDescription());
                     } // Attributes.description

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         attributesTo.setEntities(entitiesFrom);
                     }

                     if (!isValidate) {
                         em.merge(attributesTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "entities.txt");

                     }

                 } // from: Entities

                 if (from.equals("Entities") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("Relationships") &&
                     name.equals("to")){

                     Entities entitiesFrom = new Entities();

                     Relationships relationshipsTo = new Relationships();

                     if (fromProperty.equals("name")){
                         entitiesFrom = findBean.nameEntities(fromValue,em);
                         f.line("from:"+fromValue+":"+entitiesFrom.getName());
                     } // entities

                     if (fromProperty.equals("serialID")){
                         entitiesFrom = findBean.serialIDEntities(fromValue,em);
                         f.line("from:"+fromValue+":"+entitiesFrom.getSerialID());
                     } // entities

                     if (fromProperty.equals("table")){
                         entitiesFrom = findBean.tableEntities(fromValue,em);
                         f.line("from:"+fromValue+":"+entitiesFrom.getTable());
                     } // entities

                     if (fromProperty.equals("description")){
                         entitiesFrom = findBean.descriptionEntities(fromValue,em);
                         f.line("from:"+fromValue+":"+entitiesFrom.getDescription());
                     } // entities

                     if (toProperty.equals("name")){
                         relationshipsTo = findBean.nameRelationships(toValue,em);
                         f.line("to:"+toValue+":"+relationshipsTo.getName());
                     } // Relationships.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         relationshipsTo.setTo(entitiesFrom);
                     }

                     if (!isValidate) {
                         em.merge(relationshipsTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "entities.txt");

                     }

                 } // from: Entities

                 if (from.equals("GroupIds") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("Models") &&
                     name.equals("")){

                     GroupIds groupIdsFrom = new GroupIds();

                     Models modelsTo = new Models();

                     if (fromProperty.equals("artifactId")){
                         groupIdsFrom = findBean.artifactIdGroupIds(fromValue,em);
                         f.line("from:"+fromValue+":"+groupIdsFrom.getArtifactId());
                     } // groupIds

                     if (fromProperty.equals("groupId")){
                         groupIdsFrom = findBean.groupIdGroupIds(fromValue,em);
                         f.line("from:"+fromValue+":"+groupIdsFrom.getGroupId());
                     } // groupIds

                     if (fromProperty.equals("version")){
                         groupIdsFrom = findBean.versionGroupIds(fromValue,em);
                         f.line("from:"+fromValue+":"+groupIdsFrom.getVersion());
                     } // groupIds

                     if (fromProperty.equals("code")){
                         groupIdsFrom = findBean.codeGroupIds(fromValue,em);
                         f.line("from:"+fromValue+":"+groupIdsFrom.getCode());
                     } // groupIds

                     if (toProperty.equals("name")){
                         modelsTo = findBean.nameModels(toValue,em);
                         f.line("to:"+toValue+":"+modelsTo.getName());
                     } // Models.name

                     if (toProperty.equals("code")){
                         modelsTo = findBean.codeModels(toValue,em);
                         f.line("to:"+toValue+":"+modelsTo.getCode());
                     } // Models.code

                     if (toProperty.equals("version")){
                         modelsTo = findBean.versionModels(toValue,em);
                         f.line("to:"+toValue+":"+modelsTo.getVersion());
                     } // Models.version

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         modelsTo.setGroupIds(groupIdsFrom);
                     }

                     if (!isValidate) {
                         em.merge(modelsTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "groupIds.txt");

                     }

                 } // from: GroupIds

                 if (from.equals("GroupIds") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("Entities") &&
                     name.equals("")){

                     GroupIds groupIdsFrom = new GroupIds();

                     Entities entitiesTo = new Entities();

                     if (fromProperty.equals("artifactId")){
                         groupIdsFrom = findBean.artifactIdGroupIds(fromValue,em);
                         f.line("from:"+fromValue+":"+groupIdsFrom.getArtifactId());
                     } // groupIds

                     if (fromProperty.equals("groupId")){
                         groupIdsFrom = findBean.groupIdGroupIds(fromValue,em);
                         f.line("from:"+fromValue+":"+groupIdsFrom.getGroupId());
                     } // groupIds

                     if (fromProperty.equals("version")){
                         groupIdsFrom = findBean.versionGroupIds(fromValue,em);
                         f.line("from:"+fromValue+":"+groupIdsFrom.getVersion());
                     } // groupIds

                     if (fromProperty.equals("code")){
                         groupIdsFrom = findBean.codeGroupIds(fromValue,em);
                         f.line("from:"+fromValue+":"+groupIdsFrom.getCode());
                     } // groupIds

                     if (toProperty.equals("name")){
                         entitiesTo = findBean.nameEntities(toValue,em);
                         f.line("to:"+toValue+":"+entitiesTo.getName());
                     } // Entities.name

                     if (toProperty.equals("serialID")){
                         entitiesTo = findBean.serialIDEntities(toValue,em);
                         f.line("to:"+toValue+":"+entitiesTo.getSerialID());
                     } // Entities.serialID

                     if (toProperty.equals("table")){
                         entitiesTo = findBean.tableEntities(toValue,em);
                         f.line("to:"+toValue+":"+entitiesTo.getTable());
                     } // Entities.table

                     if (toProperty.equals("description")){
                         entitiesTo = findBean.descriptionEntities(toValue,em);
                         f.line("to:"+toValue+":"+entitiesTo.getDescription());
                     } // Entities.description

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         entitiesTo.setGroupIds(groupIdsFrom);
                     }

                     if (!isValidate) {
                         em.merge(entitiesTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "groupIds.txt");

                     }

                 } // from: GroupIds

                 if (from.equals("GroupIdsTypes") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("ModelsGroups") &&
                     name.equals("")){

                     GroupIdsTypes groupIdsTypesFrom = new GroupIdsTypes();

                     ModelsGroups modelsGroupsTo = new ModelsGroups();

                     if (fromProperty.equals("name")){
                         groupIdsTypesFrom = findBean.nameGroupIdsTypes(fromValue,em);
                         f.line("from:"+fromValue+":"+groupIdsTypesFrom.getName());
                     } // groupIdsTypes

                     if (toProperty.equals("name")){
                         modelsGroupsTo = findBean.nameModelsGroups(toValue,em);
                         f.line("to:"+toValue+":"+modelsGroupsTo.getName());
                     } // ModelsGroups.name

                     if (toProperty.equals("code")){
                         modelsGroupsTo = findBean.codeModelsGroups(toValue,em);
                         f.line("to:"+toValue+":"+modelsGroupsTo.getCode());
                     } // ModelsGroups.code

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         modelsGroupsTo.setGroupIdsTypes(groupIdsTypesFrom);
                     }

                     if (!isValidate) {
                         em.merge(modelsGroupsTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "groupIdsTypes.txt");

                     }

                 } // from: GroupIdsTypes

                 if (from.equals("GroupIdsTypes") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("GroupIds") &&
                     name.equals("")){

                     GroupIdsTypes groupIdsTypesFrom = new GroupIdsTypes();

                     GroupIds groupIdsTo = new GroupIds();

                     if (fromProperty.equals("name")){
                         groupIdsTypesFrom = findBean.nameGroupIdsTypes(fromValue,em);
                         f.line("from:"+fromValue+":"+groupIdsTypesFrom.getName());
                     } // groupIdsTypes

                     if (toProperty.equals("artifactId")){
                         groupIdsTo = findBean.artifactIdGroupIds(toValue,em);
                         f.line("to:"+toValue+":"+groupIdsTo.getArtifactId());
                     } // GroupIds.artifactId

                     if (toProperty.equals("groupId")){
                         groupIdsTo = findBean.groupIdGroupIds(toValue,em);
                         f.line("to:"+toValue+":"+groupIdsTo.getGroupId());
                     } // GroupIds.groupId

                     if (toProperty.equals("version")){
                         groupIdsTo = findBean.versionGroupIds(toValue,em);
                         f.line("to:"+toValue+":"+groupIdsTo.getVersion());
                     } // GroupIds.version

                     if (toProperty.equals("code")){
                         groupIdsTo = findBean.codeGroupIds(toValue,em);
                         f.line("to:"+toValue+":"+groupIdsTo.getCode());
                     } // GroupIds.code

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         groupIdsTo.setGroupIdsTypes(groupIdsTypesFrom);
                     }

                     if (!isValidate) {
                         em.merge(groupIdsTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "groupIdsTypes.txt");

                     }

                 } // from: GroupIdsTypes

                 if (from.equals("Persons") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("Tasks") &&
                     name.equals("")){

                     Persons personsFrom = new Persons();

                     Tasks tasksTo = new Tasks();

                     if (fromProperty.equals("firstName")){
                         personsFrom = findBean.firstNamePersons(fromValue,em);
                         f.line("from:"+fromValue+":"+personsFrom.getFirstName());
                     } // persons

                     if (fromProperty.equals("secondName")){
                         personsFrom = findBean.secondNamePersons(fromValue,em);
                         f.line("from:"+fromValue+":"+personsFrom.getSecondName());
                     } // persons

                     if (fromProperty.equals("firstLastName")){
                         personsFrom = findBean.firstLastNamePersons(fromValue,em);
                         f.line("from:"+fromValue+":"+personsFrom.getFirstLastName());
                     } // persons

                     if (fromProperty.equals("secondLastName")){
                         personsFrom = findBean.secondLastNamePersons(fromValue,em);
                         f.line("from:"+fromValue+":"+personsFrom.getSecondLastName());
                     } // persons

                     if (fromProperty.equals("email")){
                         personsFrom = findBean.emailPersons(fromValue,em);
                         f.line("from:"+fromValue+":"+personsFrom.getEmail());
                     } // persons

                     if (fromProperty.equals("mobile")){
                         personsFrom = findBean.mobilePersons(fromValue,em);
                         f.line("from:"+fromValue+":"+personsFrom.getMobile());
                     } // persons

                     if (fromProperty.equals("telephone")){
                         personsFrom = findBean.telephonePersons(fromValue,em);
                         f.line("from:"+fromValue+":"+personsFrom.getTelephone());
                     } // persons

                     if (fromProperty.equals("skipe")){
                         personsFrom = findBean.skipePersons(fromValue,em);
                         f.line("from:"+fromValue+":"+personsFrom.getSkipe());
                     } // persons

                     if (fromProperty.equals("address")){
                         personsFrom = findBean.addressPersons(fromValue,em);
                         f.line("from:"+fromValue+":"+personsFrom.getAddress());
                     } // persons

                     if (toProperty.equals("name")){
                         tasksTo = findBean.nameTasks(toValue,em);
                         f.line("to:"+toValue+":"+tasksTo.getName());
                     } // Tasks.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         tasksTo.setPersons(personsFrom);
                     }

                     if (!isValidate) {
                         em.merge(tasksTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "persons.txt");

                     }

                 } // from: Persons

                 if (from.equals("Persons") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("Activities") &&
                     name.equals("")){

                     Persons personsFrom = new Persons();

                     Activities activitiesTo = new Activities();

                     if (fromProperty.equals("firstName")){
                         personsFrom = findBean.firstNamePersons(fromValue,em);
                         f.line("from:"+fromValue+":"+personsFrom.getFirstName());
                     } // persons

                     if (fromProperty.equals("secondName")){
                         personsFrom = findBean.secondNamePersons(fromValue,em);
                         f.line("from:"+fromValue+":"+personsFrom.getSecondName());
                     } // persons

                     if (fromProperty.equals("firstLastName")){
                         personsFrom = findBean.firstLastNamePersons(fromValue,em);
                         f.line("from:"+fromValue+":"+personsFrom.getFirstLastName());
                     } // persons

                     if (fromProperty.equals("secondLastName")){
                         personsFrom = findBean.secondLastNamePersons(fromValue,em);
                         f.line("from:"+fromValue+":"+personsFrom.getSecondLastName());
                     } // persons

                     if (fromProperty.equals("email")){
                         personsFrom = findBean.emailPersons(fromValue,em);
                         f.line("from:"+fromValue+":"+personsFrom.getEmail());
                     } // persons

                     if (fromProperty.equals("mobile")){
                         personsFrom = findBean.mobilePersons(fromValue,em);
                         f.line("from:"+fromValue+":"+personsFrom.getMobile());
                     } // persons

                     if (fromProperty.equals("telephone")){
                         personsFrom = findBean.telephonePersons(fromValue,em);
                         f.line("from:"+fromValue+":"+personsFrom.getTelephone());
                     } // persons

                     if (fromProperty.equals("skipe")){
                         personsFrom = findBean.skipePersons(fromValue,em);
                         f.line("from:"+fromValue+":"+personsFrom.getSkipe());
                     } // persons

                     if (fromProperty.equals("address")){
                         personsFrom = findBean.addressPersons(fromValue,em);
                         f.line("from:"+fromValue+":"+personsFrom.getAddress());
                     } // persons

                     if (toProperty.equals("name")){
                         activitiesTo = findBean.nameActivities(toValue,em);
                         f.line("to:"+toValue+":"+activitiesTo.getName());
                     } // Activities.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         activitiesTo.setPersons(personsFrom);
                     }

                     if (!isValidate) {
                         em.merge(activitiesTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "persons.txt");

                     }

                 } // from: Persons

                 if (from.equals("Persons") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("Employees") &&
                     name.equals("")){

                     Persons personsFrom = new Persons();

                     Employees employeesTo = new Employees();

                     if (fromProperty.equals("firstName")){
                         personsFrom = findBean.firstNamePersons(fromValue,em);
                         f.line("from:"+fromValue+":"+personsFrom.getFirstName());
                     } // persons

                     if (fromProperty.equals("secondName")){
                         personsFrom = findBean.secondNamePersons(fromValue,em);
                         f.line("from:"+fromValue+":"+personsFrom.getSecondName());
                     } // persons

                     if (fromProperty.equals("firstLastName")){
                         personsFrom = findBean.firstLastNamePersons(fromValue,em);
                         f.line("from:"+fromValue+":"+personsFrom.getFirstLastName());
                     } // persons

                     if (fromProperty.equals("secondLastName")){
                         personsFrom = findBean.secondLastNamePersons(fromValue,em);
                         f.line("from:"+fromValue+":"+personsFrom.getSecondLastName());
                     } // persons

                     if (fromProperty.equals("email")){
                         personsFrom = findBean.emailPersons(fromValue,em);
                         f.line("from:"+fromValue+":"+personsFrom.getEmail());
                     } // persons

                     if (fromProperty.equals("mobile")){
                         personsFrom = findBean.mobilePersons(fromValue,em);
                         f.line("from:"+fromValue+":"+personsFrom.getMobile());
                     } // persons

                     if (fromProperty.equals("telephone")){
                         personsFrom = findBean.telephonePersons(fromValue,em);
                         f.line("from:"+fromValue+":"+personsFrom.getTelephone());
                     } // persons

                     if (fromProperty.equals("skipe")){
                         personsFrom = findBean.skipePersons(fromValue,em);
                         f.line("from:"+fromValue+":"+personsFrom.getSkipe());
                     } // persons

                     if (fromProperty.equals("address")){
                         personsFrom = findBean.addressPersons(fromValue,em);
                         f.line("from:"+fromValue+":"+personsFrom.getAddress());
                     } // persons

                     if (toProperty.equals("code")){
                         employeesTo = findBean.codeEmployees(toValue,em);
                         f.line("to:"+toValue+":"+employeesTo.getCode());
                     } // Employees.code

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         employeesTo.setPersons(personsFrom);
                     }

                     if (!isValidate) {
                         em.merge(employeesTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "persons.txt");

                     }

                 } // from: Persons

                 if (from.equals("SitesTypes") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("SitesTypes") &&
                     name.equals("")){

                     SitesTypes sitesTypesFrom = new SitesTypes();

                     SitesTypes sitesTypesTo = new SitesTypes();

                     if (fromProperty.equals("name")){
                         sitesTypesFrom = findBean.nameSitesTypes(fromValue,em);
                         f.line("from:"+fromValue+":"+sitesTypesFrom.getName());
                     } // sitesTypes

                     if (toProperty.equals("name")){
                         sitesTypesTo = findBean.nameSitesTypes(toValue,em);
                         f.line("to:"+toValue+":"+sitesTypesTo.getName());
                     } // SitesTypes.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         sitesTypesTo.setObjPadre(sitesTypesFrom);
                     }

                     if (!isValidate) {
                         em.merge(sitesTypesTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "sitesTypes.txt");

                     }

                 } // from: SitesTypes

                 if (from.equals("ActivitiesTypes") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("Activities") &&
                     name.equals("")){

                     ActivitiesTypes activitiesTypesFrom = new ActivitiesTypes();

                     Activities activitiesTo = new Activities();

                     if (fromProperty.equals("name")){
                         activitiesTypesFrom = findBean.nameActivitiesTypes(fromValue,em);
                         f.line("from:"+fromValue+":"+activitiesTypesFrom.getName());
                     } // activitiesTypes

                     if (toProperty.equals("name")){
                         activitiesTo = findBean.nameActivities(toValue,em);
                         f.line("to:"+toValue+":"+activitiesTo.getName());
                     } // Activities.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         activitiesTo.setActivitiesTypes(activitiesTypesFrom);
                     }

                     if (!isValidate) {
                         em.merge(activitiesTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "activitiesTypes.txt");

                     }

                 } // from: ActivitiesTypes

                 if (from.equals("Activities") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("Activities") &&
                     name.equals("")){

                     Activities activitiesFrom = new Activities();

                     Activities activitiesTo = new Activities();

                     if (fromProperty.equals("name")){
                         activitiesFrom = findBean.nameActivities(fromValue,em);
                         f.line("from:"+fromValue+":"+activitiesFrom.getName());
                     } // activities

                     if (toProperty.equals("name")){
                         activitiesTo = findBean.nameActivities(toValue,em);
                         f.line("to:"+toValue+":"+activitiesTo.getName());
                     } // Activities.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         activitiesTo.setObjPadre(activitiesFrom);
                     }

                     if (!isValidate) {
                         em.merge(activitiesTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "activities.txt");

                     }

                 } // from: Activities

                 if (from.equals("Activities") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("Tasks") &&
                     name.equals("")){

                     Activities activitiesFrom = new Activities();

                     Tasks tasksTo = new Tasks();

                     if (fromProperty.equals("name")){
                         activitiesFrom = findBean.nameActivities(fromValue,em);
                         f.line("from:"+fromValue+":"+activitiesFrom.getName());
                     } // activities

                     if (toProperty.equals("name")){
                         tasksTo = findBean.nameTasks(toValue,em);
                         f.line("to:"+toValue+":"+tasksTo.getName());
                     } // Tasks.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         tasksTo.setActivities(activitiesFrom);
                     }

                     if (!isValidate) {
                         em.merge(tasksTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "activities.txt");

                     }

                 } // from: Activities

                 if (from.equals("Tasks") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("Diaries") &&
                     name.equals("")){

                     Tasks tasksFrom = new Tasks();

                     Diaries diariesTo = new Diaries();

                     if (fromProperty.equals("name")){
                         tasksFrom = findBean.nameTasks(fromValue,em);
                         f.line("from:"+fromValue+":"+tasksFrom.getName());
                     } // tasks

                     if (toProperty.equals("name")){
                         diariesTo = findBean.nameDiaries(toValue,em);
                         f.line("to:"+toValue+":"+diariesTo.getName());
                     } // Diaries.name

                     if (toProperty.equals("description")){
                         diariesTo = findBean.descriptionDiaries(toValue,em);
                         f.line("to:"+toValue+":"+diariesTo.getDescription());
                     } // Diaries.description

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         diariesTo.setTasks(tasksFrom);
                     }

                     if (!isValidate) {
                         em.merge(diariesTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "tasks.txt");

                     }

                 } // from: Tasks

                 if (from.equals("Priorities") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("Tasks") &&
                     name.equals("")){

                     Priorities prioritiesFrom = new Priorities();

                     Tasks tasksTo = new Tasks();

                     if (fromProperty.equals("name")){
                         prioritiesFrom = findBean.namePriorities(fromValue,em);
                         f.line("from:"+fromValue+":"+prioritiesFrom.getName());
                     } // priorities

                     if (toProperty.equals("name")){
                         tasksTo = findBean.nameTasks(toValue,em);
                         f.line("to:"+toValue+":"+tasksTo.getName());
                     } // Tasks.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         tasksTo.setPriorities(prioritiesFrom);
                     }

                     if (!isValidate) {
                         em.merge(tasksTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "priorities.txt");

                     }

                 } // from: Priorities

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

