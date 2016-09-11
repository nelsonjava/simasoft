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

    @PersistenceContext(unitName = "crmPU-JTA")
    private EntityManager em;

    FindBean findBean = new FindBean();

    private UploadedFile file;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public void relationshipsData() {
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
ImprovementTypes::ImprovementTypes Uno a Muchos Bidirecccional No.5 ContinualImprovements
ImprovementSources::ImprovementSources Uno a Muchos Bidirecccional No.5 ContinualImprovements
ContinualImprovements::ContinualImprovements Uno a Muchos Bidirecccional No.5 OriginalOrders
ContinualImprovements::ContinualImprovements Uno a Muchos Bidirecccional No.5 ActionPlans
ImprovementVerifications::ImprovementVerifications Uno a Muchos Bidirecccional No.5 ContinualImprovements
ImprovementClosures::ImprovementClosures Uno a Muchos Bidirecccional No.5 ClosingActivities
ImprovementClosures::ImprovementClosures Uno a Muchos Bidirecccional No.5 ContinualImprovements
ItemsTypes::ItemsTypes Uno a Muchos Bidirecccional No.5 ItemsTypes
ItemsTypes::ItemsTypes Uno a Muchos Bidirecccional No.5 ItemsNames
ItemsNames::ItemsNames Uno a Muchos Bidirecccional No.5 Items
Items::Items Uno a Muchos Bidirecccional No.5 Hosts
Items::Items Uno a Muchos Bidirecccional No.5 Items
ItemsStates::ItemsStates Uno a Muchos Bidirecccional No.5 Items
HostsTypes::HostsTypes Uno a Muchos Bidirecccional No.5 Hosts
Hosts::Hosts Uno a Muchos Bidirecccional No.5 NetworkPorts
Hosts::Hosts Uno a Muchos Bidirecccional No.5 PatchPanelsPorts
Hosts::Hosts Uno a Muchos Bidirecccional No.5 SwitchesPorts
PatchPanelsPorts::PatchPanelsPorts Uno a Muchos Bidirecccional No.5 NetworkPorts
SwitchesPorts::SwitchesPorts Uno a Muchos Bidirecccional No.5 PatchPanelsPorts
Vlans::Vlans Uno a Muchos Bidirecccional No.5 SwitchesPorts
Persons::Persons Uno a Muchos Bidirecccional No.5 Tasks
Persons::Persons Uno a Muchos Bidirecccional No.5 Activities
Persons::Persons Uno a Muchos Bidirecccional No.5 Employees
PhysicalAreasTypes::PhysicalAreasTypes Uno a Muchos Bidirecccional No.5 PhysicalAreas
PhysicalAreasTypes::PhysicalAreasTypes Uno a Muchos Bidirecccional No.5 PhysicalAreasTypes
PhysicalAreas::PhysicalAreas Uno a Muchos Bidirecccional No.5 Employees
PhysicalAreas::PhysicalAreas Uno a Muchos Bidirecccional No.5 Items
SitesTypes::SitesTypes Uno a Muchos Bidirecccional No.5 SitesTypes
ActivitiesTypes::ActivitiesTypes Uno a Muchos Bidirecccional No.5 Activities
Activities::Activities Uno a Muchos Bidirecccional No.5 Activities
Activities::Activities Uno a Muchos Bidirecccional No.5 Tasks
Tasks::Tasks Uno a Muchos Bidirecccional No.5 Diaries
Priorities::Priorities Uno a Muchos Bidirecccional No.5 Tasks
*/

                 if (from.equals("FundsLife")){

                     FundsLife fundsLifeFrom = new FundsLife();

                     if (fromProperty.equals("name")){
                         fundsLifeFrom = findBean.nameFundsLife(fromValue,em);
                         f.line(fundsLifeFrom.getName());
                     } // fundsLife

                     if (to.equals("Funds")){

                         Funds fundsTo = new Funds();

                         if (toProperty.equals("name")){
                             fundsTo = findBean.nameFunds(toValue,em);
                         } // Funds.name

                         if (toProperty.equals("code")){
                             fundsTo = findBean.codeFunds(toValue,em);
                         } // Funds.code

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             fundsTo.setFundsLife(fundsLifeFrom);
                         }

                         em.persist(fundsTo);
                         em.flush();

                     } // to: Funds
                 } // from: FundsLife

                 if (from.equals("Funds")){

                     Funds fundsFrom = new Funds();

                     if (fromProperty.equals("name")){
                         fundsFrom = findBean.nameFunds(fromValue,em);
                         f.line(fundsFrom.getName());
                     } // funds

                     if (fromProperty.equals("code")){
                         fundsFrom = findBean.codeFunds(fromValue,em);
                         f.line(fundsFrom.getCode());
                     } // funds

                     if (to.equals("Sections")){

                         Sections sectionsTo = new Sections();

                         if (toProperty.equals("name")){
                             sectionsTo = findBean.nameSections(toValue,em);
                         } // Sections.name

                         if (toProperty.equals("code")){
                             sectionsTo = findBean.codeSections(toValue,em);
                         } // Sections.code

                         if (toProperty.equals("dir")){
                             sectionsTo = findBean.dirSections(toValue,em);
                         } // Sections.dir

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             sectionsTo.setFunds(fundsFrom);
                         }

                         em.persist(sectionsTo);
                         em.flush();

                     } // to: Sections
                 } // from: Funds

                 if (from.equals("SectionsTypes")){

                     SectionsTypes sectionsTypesFrom = new SectionsTypes();

                     if (fromProperty.equals("name")){
                         sectionsTypesFrom = findBean.nameSectionsTypes(fromValue,em);
                         f.line(sectionsTypesFrom.getName());
                     } // sectionsTypes

                     if (to.equals("Sections")){

                         Sections sectionsTo = new Sections();

                         if (toProperty.equals("name")){
                             sectionsTo = findBean.nameSections(toValue,em);
                         } // Sections.name

                         if (toProperty.equals("code")){
                             sectionsTo = findBean.codeSections(toValue,em);
                         } // Sections.code

                         if (toProperty.equals("dir")){
                             sectionsTo = findBean.dirSections(toValue,em);
                         } // Sections.dir

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             sectionsTo.setSectionsTypes(sectionsTypesFrom);
                         }

                         em.persist(sectionsTo);
                         em.flush();

                     } // to: Sections
                 } // from: SectionsTypes

                 if (from.equals("Sections")){

                     Sections sectionsFrom = new Sections();

                     if (fromProperty.equals("name")){
                         sectionsFrom = findBean.nameSections(fromValue,em);
                         f.line(sectionsFrom.getName());
                     } // sections

                     if (fromProperty.equals("code")){
                         sectionsFrom = findBean.codeSections(fromValue,em);
                         f.line(sectionsFrom.getCode());
                     } // sections

                     if (fromProperty.equals("dir")){
                         sectionsFrom = findBean.dirSections(fromValue,em);
                         f.line(sectionsFrom.getDir());
                     } // sections

                     if (to.equals("Activities")){

                         Activities activitiesTo = new Activities();

                         if (toProperty.equals("name")){
                             activitiesTo = findBean.nameActivities(toValue,em);
                         } // Activities.name

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             activitiesTo.setSections(sectionsFrom);
                         }

                         em.persist(activitiesTo);
                         em.flush();

                     } // to: Activities
                 } // from: Sections

                 if (from.equals("Sections")){

                     Sections sectionsFrom = new Sections();

                     if (fromProperty.equals("name")){
                         sectionsFrom = findBean.nameSections(fromValue,em);
                         f.line(sectionsFrom.getName());
                     } // sections

                     if (fromProperty.equals("code")){
                         sectionsFrom = findBean.codeSections(fromValue,em);
                         f.line(sectionsFrom.getCode());
                     } // sections

                     if (fromProperty.equals("dir")){
                         sectionsFrom = findBean.dirSections(fromValue,em);
                         f.line(sectionsFrom.getDir());
                     } // sections

                     if (to.equals("Tasks")){

                         Tasks tasksTo = new Tasks();

                         if (toProperty.equals("name")){
                             tasksTo = findBean.nameTasks(toValue,em);
                         } // Tasks.name

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             tasksTo.setSections(sectionsFrom);
                         }

                         em.persist(tasksTo);
                         em.flush();

                     } // to: Tasks
                 } // from: Sections

                 if (from.equals("Sections")){

                     Sections sectionsFrom = new Sections();

                     if (fromProperty.equals("name")){
                         sectionsFrom = findBean.nameSections(fromValue,em);
                         f.line(sectionsFrom.getName());
                     } // sections

                     if (fromProperty.equals("code")){
                         sectionsFrom = findBean.codeSections(fromValue,em);
                         f.line(sectionsFrom.getCode());
                     } // sections

                     if (fromProperty.equals("dir")){
                         sectionsFrom = findBean.dirSections(fromValue,em);
                         f.line(sectionsFrom.getDir());
                     } // sections

                     if (to.equals("Sections")){

                         Sections sectionsTo = new Sections();

                         if (toProperty.equals("name")){
                             sectionsTo = findBean.nameSections(toValue,em);
                         } // Sections.name

                         if (toProperty.equals("code")){
                             sectionsTo = findBean.codeSections(toValue,em);
                         } // Sections.code

                         if (toProperty.equals("dir")){
                             sectionsTo = findBean.dirSections(toValue,em);
                         } // Sections.dir

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             sectionsTo.setObjPadre(sectionsFrom);
                         }

                         em.persist(sectionsTo);
                         em.flush();

                     } // to: Sections
                 } // from: Sections

                 if (from.equals("Sections")){

                     Sections sectionsFrom = new Sections();

                     if (fromProperty.equals("name")){
                         sectionsFrom = findBean.nameSections(fromValue,em);
                         f.line(sectionsFrom.getName());
                     } // sections

                     if (fromProperty.equals("code")){
                         sectionsFrom = findBean.codeSections(fromValue,em);
                         f.line(sectionsFrom.getCode());
                     } // sections

                     if (fromProperty.equals("dir")){
                         sectionsFrom = findBean.dirSections(fromValue,em);
                         f.line(sectionsFrom.getDir());
                     } // sections

                     if (to.equals("Series")){

                         Series seriesTo = new Series();

                         if (toProperty.equals("name")){
                             seriesTo = findBean.nameSeries(toValue,em);
                         } // Series.name

                         if (toProperty.equals("code")){
                             seriesTo = findBean.codeSeries(toValue,em);
                         } // Series.code

                         if (toProperty.equals("located")){
                             seriesTo = findBean.locatedSeries(toValue,em);
                         } // Series.located

                         if (toProperty.equals("procedures")){
                             seriesTo = findBean.proceduresSeries(toValue,em);
                         } // Series.procedures

                         if (toProperty.equals("dir")){
                             seriesTo = findBean.dirSeries(toValue,em);
                         } // Series.dir

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             seriesTo.setSections(sectionsFrom);
                         }

                         em.persist(seriesTo);
                         em.flush();

                     } // to: Series
                 } // from: Sections

                 if (from.equals("Series")){

                     Series seriesFrom = new Series();

                     if (fromProperty.equals("name")){
                         seriesFrom = findBean.nameSeries(fromValue,em);
                         f.line(seriesFrom.getName());
                     } // series

                     if (fromProperty.equals("code")){
                         seriesFrom = findBean.codeSeries(fromValue,em);
                         f.line(seriesFrom.getCode());
                     } // series

                     if (fromProperty.equals("located")){
                         seriesFrom = findBean.locatedSeries(fromValue,em);
                         f.line(seriesFrom.getLocated());
                     } // series

                     if (fromProperty.equals("procedures")){
                         seriesFrom = findBean.proceduresSeries(fromValue,em);
                         f.line(seriesFrom.getProcedures());
                     } // series

                     if (fromProperty.equals("dir")){
                         seriesFrom = findBean.dirSeries(fromValue,em);
                         f.line(seriesFrom.getDir());
                     } // series

                     if (to.equals("Tasks")){

                         Tasks tasksTo = new Tasks();

                         if (toProperty.equals("name")){
                             tasksTo = findBean.nameTasks(toValue,em);
                         } // Tasks.name

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             tasksTo.setSeries(seriesFrom);
                         }

                         em.persist(tasksTo);
                         em.flush();

                     } // to: Tasks
                 } // from: Series

                 if (from.equals("Series")){

                     Series seriesFrom = new Series();

                     if (fromProperty.equals("name")){
                         seriesFrom = findBean.nameSeries(fromValue,em);
                         f.line(seriesFrom.getName());
                     } // series

                     if (fromProperty.equals("code")){
                         seriesFrom = findBean.codeSeries(fromValue,em);
                         f.line(seriesFrom.getCode());
                     } // series

                     if (fromProperty.equals("located")){
                         seriesFrom = findBean.locatedSeries(fromValue,em);
                         f.line(seriesFrom.getLocated());
                     } // series

                     if (fromProperty.equals("procedures")){
                         seriesFrom = findBean.proceduresSeries(fromValue,em);
                         f.line(seriesFrom.getProcedures());
                     } // series

                     if (fromProperty.equals("dir")){
                         seriesFrom = findBean.dirSeries(fromValue,em);
                         f.line(seriesFrom.getDir());
                     } // series

                     if (to.equals("DocumentalsUnits")){

                         DocumentalsUnits documentalsUnitsTo = new DocumentalsUnits();

                         if (toProperty.equals("name")){
                             documentalsUnitsTo = findBean.nameDocumentalsUnits(toValue,em);
                         } // DocumentalsUnits.name

                         if (toProperty.equals("code")){
                             documentalsUnitsTo = findBean.codeDocumentalsUnits(toValue,em);
                         } // DocumentalsUnits.code

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             documentalsUnitsTo.setSeries(seriesFrom);
                         }

                         em.persist(documentalsUnitsTo);
                         em.flush();

                     } // to: DocumentalsUnits
                 } // from: Series

                 if (from.equals("Series")){

                     Series seriesFrom = new Series();

                     if (fromProperty.equals("name")){
                         seriesFrom = findBean.nameSeries(fromValue,em);
                         f.line(seriesFrom.getName());
                     } // series

                     if (fromProperty.equals("code")){
                         seriesFrom = findBean.codeSeries(fromValue,em);
                         f.line(seriesFrom.getCode());
                     } // series

                     if (fromProperty.equals("located")){
                         seriesFrom = findBean.locatedSeries(fromValue,em);
                         f.line(seriesFrom.getLocated());
                     } // series

                     if (fromProperty.equals("procedures")){
                         seriesFrom = findBean.proceduresSeries(fromValue,em);
                         f.line(seriesFrom.getProcedures());
                     } // series

                     if (fromProperty.equals("dir")){
                         seriesFrom = findBean.dirSeries(fromValue,em);
                         f.line(seriesFrom.getDir());
                     } // series

                     if (to.equals("Series")){

                         Series seriesTo = new Series();

                         if (toProperty.equals("name")){
                             seriesTo = findBean.nameSeries(toValue,em);
                         } // Series.name

                         if (toProperty.equals("code")){
                             seriesTo = findBean.codeSeries(toValue,em);
                         } // Series.code

                         if (toProperty.equals("located")){
                             seriesTo = findBean.locatedSeries(toValue,em);
                         } // Series.located

                         if (toProperty.equals("procedures")){
                             seriesTo = findBean.proceduresSeries(toValue,em);
                         } // Series.procedures

                         if (toProperty.equals("dir")){
                             seriesTo = findBean.dirSeries(toValue,em);
                         } // Series.dir

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             seriesTo.setObjPadre(seriesFrom);
                         }

                         em.persist(seriesTo);
                         em.flush();

                     } // to: Series
                 } // from: Series

                 if (from.equals("Series")){

                     Series seriesFrom = new Series();

                     if (fromProperty.equals("name")){
                         seriesFrom = findBean.nameSeries(fromValue,em);
                         f.line(seriesFrom.getName());
                     } // series

                     if (fromProperty.equals("code")){
                         seriesFrom = findBean.codeSeries(fromValue,em);
                         f.line(seriesFrom.getCode());
                     } // series

                     if (fromProperty.equals("located")){
                         seriesFrom = findBean.locatedSeries(fromValue,em);
                         f.line(seriesFrom.getLocated());
                     } // series

                     if (fromProperty.equals("procedures")){
                         seriesFrom = findBean.proceduresSeries(fromValue,em);
                         f.line(seriesFrom.getProcedures());
                     } // series

                     if (fromProperty.equals("dir")){
                         seriesFrom = findBean.dirSeries(fromValue,em);
                         f.line(seriesFrom.getDir());
                     } // series

                     if (to.equals("VersionsControls")){

                         VersionsControls versionsControlsTo = new VersionsControls();

                         if (toProperty.equals("name")){
                             versionsControlsTo = findBean.nameVersionsControls(toValue,em);
                         } // VersionsControls.name

                         if (toProperty.equals("code")){
                             versionsControlsTo = findBean.codeVersionsControls(toValue,em);
                         } // VersionsControls.code

                         if (toProperty.equals("version")){
                             versionsControlsTo = findBean.versionVersionsControls(toValue,em);
                         } // VersionsControls.version

                         if (toProperty.equals("request")){
                             versionsControlsTo = findBean.requestVersionsControls(toValue,em);
                         } // VersionsControls.request

                         if (toProperty.equals("responsible")){
                             versionsControlsTo = findBean.responsibleVersionsControls(toValue,em);
                         } // VersionsControls.responsible

                         if (toProperty.equals("description")){
                             versionsControlsTo = findBean.descriptionVersionsControls(toValue,em);
                         } // VersionsControls.description

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             versionsControlsTo.setSeries(seriesFrom);
                         }

                         em.persist(versionsControlsTo);
                         em.flush();

                     } // to: VersionsControls
                 } // from: Series

                 if (from.equals("Series")){

                     Series seriesFrom = new Series();

                     if (fromProperty.equals("name")){
                         seriesFrom = findBean.nameSeries(fromValue,em);
                         f.line(seriesFrom.getName());
                     } // series

                     if (fromProperty.equals("code")){
                         seriesFrom = findBean.codeSeries(fromValue,em);
                         f.line(seriesFrom.getCode());
                     } // series

                     if (fromProperty.equals("located")){
                         seriesFrom = findBean.locatedSeries(fromValue,em);
                         f.line(seriesFrom.getLocated());
                     } // series

                     if (fromProperty.equals("procedures")){
                         seriesFrom = findBean.proceduresSeries(fromValue,em);
                         f.line(seriesFrom.getProcedures());
                     } // series

                     if (fromProperty.equals("dir")){
                         seriesFrom = findBean.dirSeries(fromValue,em);
                         f.line(seriesFrom.getDir());
                     } // series

                     if (to.equals("TrdSeries")){

                         TrdSeries trdSeriesTo = new TrdSeries();

                         if (toProperty.equals("name")){
                             trdSeriesTo = findBean.nameTrdSeries(toValue,em);
                         } // TrdSeries.name

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             trdSeriesTo.setSeries(seriesFrom);
                         }

                         em.persist(trdSeriesTo);
                         em.flush();

                     } // to: TrdSeries
                 } // from: Series

                 if (from.equals("Trd")){

                     Trd trdFrom = new Trd();

                     if (fromProperty.equals("name")){
                         trdFrom = findBean.nameTrd(fromValue,em);
                         f.line(trdFrom.getName());
                     } // trd

                     if (to.equals("TrdSeries")){

                         TrdSeries trdSeriesTo = new TrdSeries();

                         if (toProperty.equals("name")){
                             trdSeriesTo = findBean.nameTrdSeries(toValue,em);
                         } // TrdSeries.name

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             trdSeriesTo.setTrd(trdFrom);
                         }

                         em.persist(trdSeriesTo);
                         em.flush();

                     } // to: TrdSeries
                 } // from: Trd

                 if (from.equals("FinalDisposition")){

                     FinalDisposition finalDispositionFrom = new FinalDisposition();

                     if (fromProperty.equals("name")){
                         finalDispositionFrom = findBean.nameFinalDisposition(fromValue,em);
                         f.line(finalDispositionFrom.getName());
                     } // finalDisposition

                     if (to.equals("Trd")){

                         Trd trdTo = new Trd();

                         if (toProperty.equals("name")){
                             trdTo = findBean.nameTrd(toValue,em);
                         } // Trd.name

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             trdTo.setFinalDisposition(finalDispositionFrom);
                         }

                         em.persist(trdTo);
                         em.flush();

                     } // to: Trd
                 } // from: FinalDisposition

                 if (from.equals("DocumentalRetention")){

                     DocumentalRetention documentalRetentionFrom = new DocumentalRetention();

                     if (fromProperty.equals("name")){
                         documentalRetentionFrom = findBean.nameDocumentalRetention(fromValue,em);
                         f.line(documentalRetentionFrom.getName());
                     } // documentalRetention

                     if (to.equals("Trd")){

                         Trd trdTo = new Trd();

                         if (toProperty.equals("name")){
                             trdTo = findBean.nameTrd(toValue,em);
                         } // Trd.name

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             trdTo.setGestion(documentalRetentionFrom);
                         }

                         em.persist(trdTo);
                         em.flush();

                     } // to: Trd
                 } // from: DocumentalRetention

                 if (from.equals("DocumentalRetention")){

                     DocumentalRetention documentalRetentionFrom = new DocumentalRetention();

                     if (fromProperty.equals("name")){
                         documentalRetentionFrom = findBean.nameDocumentalRetention(fromValue,em);
                         f.line(documentalRetentionFrom.getName());
                     } // documentalRetention

                     if (to.equals("Trd")){

                         Trd trdTo = new Trd();

                         if (toProperty.equals("name")){
                             trdTo = findBean.nameTrd(toValue,em);
                         } // Trd.name

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             trdTo.setCentral(documentalRetentionFrom);
                         }

                         em.persist(trdTo);
                         em.flush();

                     } // to: Trd
                 } // from: DocumentalRetention

                 if (from.equals("FrequentlyQuery")){

                     FrequentlyQuery frequentlyQueryFrom = new FrequentlyQuery();

                     if (fromProperty.equals("name")){
                         frequentlyQueryFrom = findBean.nameFrequentlyQuery(fromValue,em);
                         f.line(frequentlyQueryFrom.getName());
                     } // frequentlyQuery

                     if (to.equals("DocumentalsUnits")){

                         DocumentalsUnits documentalsUnitsTo = new DocumentalsUnits();

                         if (toProperty.equals("name")){
                             documentalsUnitsTo = findBean.nameDocumentalsUnits(toValue,em);
                         } // DocumentalsUnits.name

                         if (toProperty.equals("code")){
                             documentalsUnitsTo = findBean.codeDocumentalsUnits(toValue,em);
                         } // DocumentalsUnits.code

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             documentalsUnitsTo.setFrequentlyQuery(frequentlyQueryFrom);
                         }

                         em.persist(documentalsUnitsTo);
                         em.flush();

                     } // to: DocumentalsUnits
                 } // from: FrequentlyQuery

                 if (from.equals("DocumentalsUnits")){

                     DocumentalsUnits documentalsUnitsFrom = new DocumentalsUnits();

                     if (fromProperty.equals("name")){
                         documentalsUnitsFrom = findBean.nameDocumentalsUnits(fromValue,em);
                         f.line(documentalsUnitsFrom.getName());
                     } // documentalsUnits

                     if (fromProperty.equals("code")){
                         documentalsUnitsFrom = findBean.codeDocumentalsUnits(fromValue,em);
                         f.line(documentalsUnitsFrom.getCode());
                     } // documentalsUnits

                     if (to.equals("ContinualImprovements")){

                         ContinualImprovements continualImprovementsTo = new ContinualImprovements();

                         if (toProperty.equals("code")){
                             continualImprovementsTo = findBean.codeContinualImprovements(toValue,em);
                         } // ContinualImprovements.code

                         if (toProperty.equals("description")){
                             continualImprovementsTo = findBean.descriptionContinualImprovements(toValue,em);
                         } // ContinualImprovements.description

                         if (toProperty.equals("causesAnalysis")){
                             continualImprovementsTo = findBean.causesAnalysisContinualImprovements(toValue,em);
                         } // ContinualImprovements.causesAnalysis

                         if (toProperty.equals("rootCause")){
                             continualImprovementsTo = findBean.rootCauseContinualImprovements(toValue,em);
                         } // ContinualImprovements.rootCause

                         if (toProperty.equals("immediateCorrection")){
                             continualImprovementsTo = findBean.immediateCorrectionContinualImprovements(toValue,em);
                         } // ContinualImprovements.immediateCorrection

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             continualImprovementsTo.setDocumentalsUnits(documentalsUnitsFrom);
                         }

                         em.persist(continualImprovementsTo);
                         em.flush();

                     } // to: ContinualImprovements
                 } // from: DocumentalsUnits

                 if (from.equals("DocumentalsUnits")){

                     DocumentalsUnits documentalsUnitsFrom = new DocumentalsUnits();

                     if (fromProperty.equals("name")){
                         documentalsUnitsFrom = findBean.nameDocumentalsUnits(fromValue,em);
                         f.line(documentalsUnitsFrom.getName());
                     } // documentalsUnits

                     if (fromProperty.equals("code")){
                         documentalsUnitsFrom = findBean.codeDocumentalsUnits(fromValue,em);
                         f.line(documentalsUnitsFrom.getCode());
                     } // documentalsUnits

                     if (to.equals("OriginalOrders")){

                         OriginalOrders originalOrdersTo = new OriginalOrders();

                         if (toProperty.equals("subject")){
                             originalOrdersTo = findBean.subjectOriginalOrders(toValue,em);
                         } // OriginalOrders.subject

                         if (toProperty.equals("code")){
                             originalOrdersTo = findBean.codeOriginalOrders(toValue,em);
                         } // OriginalOrders.code

                         if (toProperty.equals("located")){
                             originalOrdersTo = findBean.locatedOriginalOrders(toValue,em);
                         } // OriginalOrders.located

                         if (toProperty.equals("mail")){
                             originalOrdersTo = findBean.mailOriginalOrders(toValue,em);
                         } // OriginalOrders.mail

                         if (toProperty.equals("notes")){
                             originalOrdersTo = findBean.notesOriginalOrders(toValue,em);
                         } // OriginalOrders.notes

                         if (toProperty.equals("fileName")){
                             originalOrdersTo = findBean.fileNameOriginalOrders(toValue,em);
                         } // OriginalOrders.fileName

                         if (toProperty.equals("fileType")){
                             originalOrdersTo = findBean.fileTypeOriginalOrders(toValue,em);
                         } // OriginalOrders.fileType

                         if (toProperty.equals("filedir")){
                             originalOrdersTo = findBean.filedirOriginalOrders(toValue,em);
                         } // OriginalOrders.filedir

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             originalOrdersTo.setDocumentalsUnits(documentalsUnitsFrom);
                         }

                         em.persist(originalOrdersTo);
                         em.flush();

                     } // to: OriginalOrders
                 } // from: DocumentalsUnits

                 if (from.equals("DocumentalsUnits")){

                     DocumentalsUnits documentalsUnitsFrom = new DocumentalsUnits();

                     if (fromProperty.equals("name")){
                         documentalsUnitsFrom = findBean.nameDocumentalsUnits(fromValue,em);
                         f.line(documentalsUnitsFrom.getName());
                     } // documentalsUnits

                     if (fromProperty.equals("code")){
                         documentalsUnitsFrom = findBean.codeDocumentalsUnits(fromValue,em);
                         f.line(documentalsUnitsFrom.getCode());
                     } // documentalsUnits

                     if (to.equals("VersionsControls")){

                         VersionsControls versionsControlsTo = new VersionsControls();

                         if (toProperty.equals("name")){
                             versionsControlsTo = findBean.nameVersionsControls(toValue,em);
                         } // VersionsControls.name

                         if (toProperty.equals("code")){
                             versionsControlsTo = findBean.codeVersionsControls(toValue,em);
                         } // VersionsControls.code

                         if (toProperty.equals("version")){
                             versionsControlsTo = findBean.versionVersionsControls(toValue,em);
                         } // VersionsControls.version

                         if (toProperty.equals("request")){
                             versionsControlsTo = findBean.requestVersionsControls(toValue,em);
                         } // VersionsControls.request

                         if (toProperty.equals("responsible")){
                             versionsControlsTo = findBean.responsibleVersionsControls(toValue,em);
                         } // VersionsControls.responsible

                         if (toProperty.equals("description")){
                             versionsControlsTo = findBean.descriptionVersionsControls(toValue,em);
                         } // VersionsControls.description

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             versionsControlsTo.setDocumentalsUnits(documentalsUnitsFrom);
                         }

                         em.persist(versionsControlsTo);
                         em.flush();

                     } // to: VersionsControls
                 } // from: DocumentalsUnits

                 if (from.equals("DocumentalsUnits")){

                     DocumentalsUnits documentalsUnitsFrom = new DocumentalsUnits();

                     if (fromProperty.equals("name")){
                         documentalsUnitsFrom = findBean.nameDocumentalsUnits(fromValue,em);
                         f.line(documentalsUnitsFrom.getName());
                     } // documentalsUnits

                     if (fromProperty.equals("code")){
                         documentalsUnitsFrom = findBean.codeDocumentalsUnits(fromValue,em);
                         f.line(documentalsUnitsFrom.getCode());
                     } // documentalsUnits

                     if (to.equals("DocumentalsUnits")){

                         DocumentalsUnits documentalsUnitsTo = new DocumentalsUnits();

                         if (toProperty.equals("name")){
                             documentalsUnitsTo = findBean.nameDocumentalsUnits(toValue,em);
                         } // DocumentalsUnits.name

                         if (toProperty.equals("code")){
                             documentalsUnitsTo = findBean.codeDocumentalsUnits(toValue,em);
                         } // DocumentalsUnits.code

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             documentalsUnitsTo.setObjPadre(documentalsUnitsFrom);
                         }

                         em.persist(documentalsUnitsTo);
                         em.flush();

                     } // to: DocumentalsUnits
                 } // from: DocumentalsUnits

                 if (from.equals("ConservationUnits")){

                     ConservationUnits conservationUnitsFrom = new ConservationUnits();

                     if (fromProperty.equals("name")){
                         conservationUnitsFrom = findBean.nameConservationUnits(fromValue,em);
                         f.line(conservationUnitsFrom.getName());
                     } // conservationUnits

                     if (fromProperty.equals("code")){
                         conservationUnitsFrom = findBean.codeConservationUnits(fromValue,em);
                         f.line(conservationUnitsFrom.getCode());
                     } // conservationUnits

                     if (to.equals("OriginalOrders")){

                         OriginalOrders originalOrdersTo = new OriginalOrders();

                         if (toProperty.equals("subject")){
                             originalOrdersTo = findBean.subjectOriginalOrders(toValue,em);
                         } // OriginalOrders.subject

                         if (toProperty.equals("code")){
                             originalOrdersTo = findBean.codeOriginalOrders(toValue,em);
                         } // OriginalOrders.code

                         if (toProperty.equals("located")){
                             originalOrdersTo = findBean.locatedOriginalOrders(toValue,em);
                         } // OriginalOrders.located

                         if (toProperty.equals("mail")){
                             originalOrdersTo = findBean.mailOriginalOrders(toValue,em);
                         } // OriginalOrders.mail

                         if (toProperty.equals("notes")){
                             originalOrdersTo = findBean.notesOriginalOrders(toValue,em);
                         } // OriginalOrders.notes

                         if (toProperty.equals("fileName")){
                             originalOrdersTo = findBean.fileNameOriginalOrders(toValue,em);
                         } // OriginalOrders.fileName

                         if (toProperty.equals("fileType")){
                             originalOrdersTo = findBean.fileTypeOriginalOrders(toValue,em);
                         } // OriginalOrders.fileType

                         if (toProperty.equals("filedir")){
                             originalOrdersTo = findBean.filedirOriginalOrders(toValue,em);
                         } // OriginalOrders.filedir

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             originalOrdersTo.setConservationUnits(conservationUnitsFrom);
                         }

                         em.persist(originalOrdersTo);
                         em.flush();

                     } // to: OriginalOrders
                 } // from: ConservationUnits

                 if (from.equals("DocumentalInventory")){

                     DocumentalInventory documentalInventoryFrom = new DocumentalInventory();

                     if (fromProperty.equals("object")){
                         documentalInventoryFrom = findBean.objectDocumentalInventory(fromValue,em);
                         f.line(documentalInventoryFrom.getObject());
                     } // documentalInventory

                     if (to.equals("OriginalOrders")){

                         OriginalOrders originalOrdersTo = new OriginalOrders();

                         if (toProperty.equals("subject")){
                             originalOrdersTo = findBean.subjectOriginalOrders(toValue,em);
                         } // OriginalOrders.subject

                         if (toProperty.equals("code")){
                             originalOrdersTo = findBean.codeOriginalOrders(toValue,em);
                         } // OriginalOrders.code

                         if (toProperty.equals("located")){
                             originalOrdersTo = findBean.locatedOriginalOrders(toValue,em);
                         } // OriginalOrders.located

                         if (toProperty.equals("mail")){
                             originalOrdersTo = findBean.mailOriginalOrders(toValue,em);
                         } // OriginalOrders.mail

                         if (toProperty.equals("notes")){
                             originalOrdersTo = findBean.notesOriginalOrders(toValue,em);
                         } // OriginalOrders.notes

                         if (toProperty.equals("fileName")){
                             originalOrdersTo = findBean.fileNameOriginalOrders(toValue,em);
                         } // OriginalOrders.fileName

                         if (toProperty.equals("fileType")){
                             originalOrdersTo = findBean.fileTypeOriginalOrders(toValue,em);
                         } // OriginalOrders.fileType

                         if (toProperty.equals("filedir")){
                             originalOrdersTo = findBean.filedirOriginalOrders(toValue,em);
                         } // OriginalOrders.filedir

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             originalOrdersTo.setDocumentalInventory(documentalInventoryFrom);
                         }

                         em.persist(originalOrdersTo);
                         em.flush();

                     } // to: OriginalOrders
                 } // from: DocumentalInventory

                 if (from.equals("DocumentalsUnitsTypes")){

                     DocumentalsUnitsTypes documentalsUnitsTypesFrom = new DocumentalsUnitsTypes();

                     if (fromProperty.equals("name")){
                         documentalsUnitsTypesFrom = findBean.nameDocumentalsUnitsTypes(fromValue,em);
                         f.line(documentalsUnitsTypesFrom.getName());
                     } // documentalsUnitsTypes

                     if (to.equals("DocumentalsUnits")){

                         DocumentalsUnits documentalsUnitsTo = new DocumentalsUnits();

                         if (toProperty.equals("name")){
                             documentalsUnitsTo = findBean.nameDocumentalsUnits(toValue,em);
                         } // DocumentalsUnits.name

                         if (toProperty.equals("code")){
                             documentalsUnitsTo = findBean.codeDocumentalsUnits(toValue,em);
                         } // DocumentalsUnits.code

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             documentalsUnitsTo.setDocumentalsUnitsTypes(documentalsUnitsTypesFrom);
                         }

                         em.persist(documentalsUnitsTo);
                         em.flush();

                     } // to: DocumentalsUnits
                 } // from: DocumentalsUnitsTypes

                 if (from.equals("Access")){

                     Access accessFrom = new Access();

                     if (fromProperty.equals("name")){
                         accessFrom = findBean.nameAccess(fromValue,em);
                         f.line(accessFrom.getName());
                     } // access

                     if (to.equals("DocumentalsUnits")){

                         DocumentalsUnits documentalsUnitsTo = new DocumentalsUnits();

                         if (toProperty.equals("name")){
                             documentalsUnitsTo = findBean.nameDocumentalsUnits(toValue,em);
                         } // DocumentalsUnits.name

                         if (toProperty.equals("code")){
                             documentalsUnitsTo = findBean.codeDocumentalsUnits(toValue,em);
                         } // DocumentalsUnits.code

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             documentalsUnitsTo.setAccess(accessFrom);
                         }

                         em.persist(documentalsUnitsTo);
                         em.flush();

                     } // to: DocumentalsUnits
                 } // from: Access

                 if (from.equals("Organizeds")){

                     Organizeds organizedsFrom = new Organizeds();

                     if (fromProperty.equals("name")){
                         organizedsFrom = findBean.nameOrganizeds(fromValue,em);
                         f.line(organizedsFrom.getName());
                     } // organizeds

                     if (to.equals("DocumentalsUnits")){

                         DocumentalsUnits documentalsUnitsTo = new DocumentalsUnits();

                         if (toProperty.equals("name")){
                             documentalsUnitsTo = findBean.nameDocumentalsUnits(toValue,em);
                         } // DocumentalsUnits.name

                         if (toProperty.equals("code")){
                             documentalsUnitsTo = findBean.codeDocumentalsUnits(toValue,em);
                         } // DocumentalsUnits.code

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             documentalsUnitsTo.setOrganizeds(organizedsFrom);
                         }

                         em.persist(documentalsUnitsTo);
                         em.flush();

                     } // to: DocumentalsUnits
                 } // from: Organizeds

                 if (from.equals("InventoryFinality")){

                     InventoryFinality inventoryFinalityFrom = new InventoryFinality();

                     if (fromProperty.equals("name")){
                         inventoryFinalityFrom = findBean.nameInventoryFinality(fromValue,em);
                         f.line(inventoryFinalityFrom.getName());
                     } // inventoryFinality

                     if (to.equals("DocumentalInventory")){

                         DocumentalInventory documentalInventoryTo = new DocumentalInventory();

                         if (toProperty.equals("object")){
                             documentalInventoryTo = findBean.objectDocumentalInventory(toValue,em);
                         } // DocumentalInventory.object

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             documentalInventoryTo.setInventoryFinality(inventoryFinalityFrom);
                         }

                         em.persist(documentalInventoryTo);
                         em.flush();

                     } // to: DocumentalInventory
                 } // from: InventoryFinality

                 if (from.equals("DocumentalsSupports")){

                     DocumentalsSupports documentalsSupportsFrom = new DocumentalsSupports();

                     if (fromProperty.equals("name")){
                         documentalsSupportsFrom = findBean.nameDocumentalsSupports(fromValue,em);
                         f.line(documentalsSupportsFrom.getName());
                     } // documentalsSupports

                     if (fromProperty.equals("code")){
                         documentalsSupportsFrom = findBean.codeDocumentalsSupports(fromValue,em);
                         f.line(documentalsSupportsFrom.getCode());
                     } // documentalsSupports

                     if (to.equals("OriginalOrders")){

                         OriginalOrders originalOrdersTo = new OriginalOrders();

                         if (toProperty.equals("subject")){
                             originalOrdersTo = findBean.subjectOriginalOrders(toValue,em);
                         } // OriginalOrders.subject

                         if (toProperty.equals("code")){
                             originalOrdersTo = findBean.codeOriginalOrders(toValue,em);
                         } // OriginalOrders.code

                         if (toProperty.equals("located")){
                             originalOrdersTo = findBean.locatedOriginalOrders(toValue,em);
                         } // OriginalOrders.located

                         if (toProperty.equals("mail")){
                             originalOrdersTo = findBean.mailOriginalOrders(toValue,em);
                         } // OriginalOrders.mail

                         if (toProperty.equals("notes")){
                             originalOrdersTo = findBean.notesOriginalOrders(toValue,em);
                         } // OriginalOrders.notes

                         if (toProperty.equals("fileName")){
                             originalOrdersTo = findBean.fileNameOriginalOrders(toValue,em);
                         } // OriginalOrders.fileName

                         if (toProperty.equals("fileType")){
                             originalOrdersTo = findBean.fileTypeOriginalOrders(toValue,em);
                         } // OriginalOrders.fileType

                         if (toProperty.equals("filedir")){
                             originalOrdersTo = findBean.filedirOriginalOrders(toValue,em);
                         } // OriginalOrders.filedir

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             originalOrdersTo.setDocumentalsSupports(documentalsSupportsFrom);
                         }

                         em.persist(originalOrdersTo);
                         em.flush();

                     } // to: OriginalOrders
                 } // from: DocumentalsSupports

                 if (from.equals("ConservationUnitsTypes")){

                     ConservationUnitsTypes conservationUnitsTypesFrom = new ConservationUnitsTypes();

                     if (fromProperty.equals("name")){
                         conservationUnitsTypesFrom = findBean.nameConservationUnitsTypes(fromValue,em);
                         f.line(conservationUnitsTypesFrom.getName());
                     } // conservationUnitsTypes

                     if (to.equals("ConservationUnits")){

                         ConservationUnits conservationUnitsTo = new ConservationUnits();

                         if (toProperty.equals("name")){
                             conservationUnitsTo = findBean.nameConservationUnits(toValue,em);
                         } // ConservationUnits.name

                         if (toProperty.equals("code")){
                             conservationUnitsTo = findBean.codeConservationUnits(toValue,em);
                         } // ConservationUnits.code

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             conservationUnitsTo.setConservationUnitsTypes(conservationUnitsTypesFrom);
                         }

                         em.persist(conservationUnitsTo);
                         em.flush();

                     } // to: ConservationUnits
                 } // from: ConservationUnitsTypes

                 if (from.equals("ConservationUnitsTypes")){

                     ConservationUnitsTypes conservationUnitsTypesFrom = new ConservationUnitsTypes();

                     if (fromProperty.equals("name")){
                         conservationUnitsTypesFrom = findBean.nameConservationUnitsTypes(fromValue,em);
                         f.line(conservationUnitsTypesFrom.getName());
                     } // conservationUnitsTypes

                     if (to.equals("OriginalOrders")){

                         OriginalOrders originalOrdersTo = new OriginalOrders();

                         if (toProperty.equals("subject")){
                             originalOrdersTo = findBean.subjectOriginalOrders(toValue,em);
                         } // OriginalOrders.subject

                         if (toProperty.equals("code")){
                             originalOrdersTo = findBean.codeOriginalOrders(toValue,em);
                         } // OriginalOrders.code

                         if (toProperty.equals("located")){
                             originalOrdersTo = findBean.locatedOriginalOrders(toValue,em);
                         } // OriginalOrders.located

                         if (toProperty.equals("mail")){
                             originalOrdersTo = findBean.mailOriginalOrders(toValue,em);
                         } // OriginalOrders.mail

                         if (toProperty.equals("notes")){
                             originalOrdersTo = findBean.notesOriginalOrders(toValue,em);
                         } // OriginalOrders.notes

                         if (toProperty.equals("fileName")){
                             originalOrdersTo = findBean.fileNameOriginalOrders(toValue,em);
                         } // OriginalOrders.fileName

                         if (toProperty.equals("fileType")){
                             originalOrdersTo = findBean.fileTypeOriginalOrders(toValue,em);
                         } // OriginalOrders.fileType

                         if (toProperty.equals("filedir")){
                             originalOrdersTo = findBean.filedirOriginalOrders(toValue,em);
                         } // OriginalOrders.filedir

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             originalOrdersTo.setConservationUnitsTypes(conservationUnitsTypesFrom);
                         }

                         em.persist(originalOrdersTo);
                         em.flush();

                     } // to: OriginalOrders
                 } // from: ConservationUnitsTypes

                 if (from.equals("BooksTypes")){

                     BooksTypes booksTypesFrom = new BooksTypes();

                     if (fromProperty.equals("name")){
                         booksTypesFrom = findBean.nameBooksTypes(fromValue,em);
                         f.line(booksTypesFrom.getName());
                     } // booksTypes

                     if (to.equals("Books")){

                         Books booksTo = new Books();

                         if (toProperty.equals("code")){
                             booksTo = findBean.codeBooks(toValue,em);
                         } // Books.code

                         if (toProperty.equals("name")){
                             booksTo = findBean.nameBooks(toValue,em);
                         } // Books.name

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             booksTo.setBooksTypes(booksTypesFrom);
                         }

                         em.persist(booksTo);
                         em.flush();

                     } // to: Books
                 } // from: BooksTypes

                 if (from.equals("BooksTypes")){

                     BooksTypes booksTypesFrom = new BooksTypes();

                     if (fromProperty.equals("name")){
                         booksTypesFrom = findBean.nameBooksTypes(fromValue,em);
                         f.line(booksTypesFrom.getName());
                     } // booksTypes

                     if (to.equals("BooksTypes")){

                         BooksTypes booksTypesTo = new BooksTypes();

                         if (toProperty.equals("name")){
                             booksTypesTo = findBean.nameBooksTypes(toValue,em);
                         } // BooksTypes.name

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             booksTypesTo.setObjPadre(booksTypesFrom);
                         }

                         em.persist(booksTypesTo);
                         em.flush();

                     } // to: BooksTypes
                 } // from: BooksTypes

                 if (from.equals("Books")){

                     Books booksFrom = new Books();

                     if (fromProperty.equals("code")){
                         booksFrom = findBean.codeBooks(fromValue,em);
                         f.line(booksFrom.getCode());
                     } // books

                     if (fromProperty.equals("name")){
                         booksFrom = findBean.nameBooks(fromValue,em);
                         f.line(booksFrom.getName());
                     } // books

                     if (to.equals("Activities")){

                         Activities activitiesTo = new Activities();

                         if (toProperty.equals("name")){
                             activitiesTo = findBean.nameActivities(toValue,em);
                         } // Activities.name

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             activitiesTo.setBooks(booksFrom);
                         }

                         em.persist(activitiesTo);
                         em.flush();

                     } // to: Activities
                 } // from: Books

                 if (from.equals("Books")){

                     Books booksFrom = new Books();

                     if (fromProperty.equals("code")){
                         booksFrom = findBean.codeBooks(fromValue,em);
                         f.line(booksFrom.getCode());
                     } // books

                     if (fromProperty.equals("name")){
                         booksFrom = findBean.nameBooks(fromValue,em);
                         f.line(booksFrom.getName());
                     } // books

                     if (to.equals("Chapters")){

                         Chapters chaptersTo = new Chapters();

                         if (toProperty.equals("code")){
                             chaptersTo = findBean.codeChapters(toValue,em);
                         } // Chapters.code

                         if (toProperty.equals("name")){
                             chaptersTo = findBean.nameChapters(toValue,em);
                         } // Chapters.name

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             chaptersTo.setBooks(booksFrom);
                         }

                         em.persist(chaptersTo);
                         em.flush();

                     } // to: Chapters
                 } // from: Books

                 if (from.equals("Chapters")){

                     Chapters chaptersFrom = new Chapters();

                     if (fromProperty.equals("code")){
                         chaptersFrom = findBean.codeChapters(fromValue,em);
                         f.line(chaptersFrom.getCode());
                     } // chapters

                     if (fromProperty.equals("name")){
                         chaptersFrom = findBean.nameChapters(fromValue,em);
                         f.line(chaptersFrom.getName());
                     } // chapters

                     if (to.equals("Diaries")){

                         Diaries diariesTo = new Diaries();

                         if (toProperty.equals("name")){
                             diariesTo = findBean.nameDiaries(toValue,em);
                         } // Diaries.name

                         if (toProperty.equals("description")){
                             diariesTo = findBean.descriptionDiaries(toValue,em);
                         } // Diaries.description

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             diariesTo.setChapters(chaptersFrom);
                         }

                         em.persist(diariesTo);
                         em.flush();

                     } // to: Diaries
                 } // from: Chapters

                 if (from.equals("Chapters")){

                     Chapters chaptersFrom = new Chapters();

                     if (fromProperty.equals("code")){
                         chaptersFrom = findBean.codeChapters(fromValue,em);
                         f.line(chaptersFrom.getCode());
                     } // chapters

                     if (fromProperty.equals("name")){
                         chaptersFrom = findBean.nameChapters(fromValue,em);
                         f.line(chaptersFrom.getName());
                     } // chapters

                     if (to.equals("Tasks")){

                         Tasks tasksTo = new Tasks();

                         if (toProperty.equals("name")){
                             tasksTo = findBean.nameTasks(toValue,em);
                         } // Tasks.name

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             tasksTo.setChapters(chaptersFrom);
                         }

                         em.persist(tasksTo);
                         em.flush();

                     } // to: Tasks
                 } // from: Chapters

                 if (from.equals("Chapters")){

                     Chapters chaptersFrom = new Chapters();

                     if (fromProperty.equals("code")){
                         chaptersFrom = findBean.codeChapters(fromValue,em);
                         f.line(chaptersFrom.getCode());
                     } // chapters

                     if (fromProperty.equals("name")){
                         chaptersFrom = findBean.nameChapters(fromValue,em);
                         f.line(chaptersFrom.getName());
                     } // chapters

                     if (to.equals("Chapters")){

                         Chapters chaptersTo = new Chapters();

                         if (toProperty.equals("code")){
                             chaptersTo = findBean.codeChapters(toValue,em);
                         } // Chapters.code

                         if (toProperty.equals("name")){
                             chaptersTo = findBean.nameChapters(toValue,em);
                         } // Chapters.name

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             chaptersTo.setObjPadre(chaptersFrom);
                         }

                         em.persist(chaptersTo);
                         em.flush();

                     } // to: Chapters
                 } // from: Chapters

                 if (from.equals("Companies")){

                     Companies companiesFrom = new Companies();

                     if (fromProperty.equals("name")){
                         companiesFrom = findBean.nameCompanies(fromValue,em);
                         f.line(companiesFrom.getName());
                     } // companies

                     if (to.equals("Funds")){

                         Funds fundsTo = new Funds();

                         if (toProperty.equals("name")){
                             fundsTo = findBean.nameFunds(toValue,em);
                         } // Funds.name

                         if (toProperty.equals("code")){
                             fundsTo = findBean.codeFunds(toValue,em);
                         } // Funds.code

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             fundsTo.setCompanies(companiesFrom);
                         }

                         em.persist(fundsTo);
                         em.flush();

                     } // to: Funds
                 } // from: Companies

                 if (from.equals("Companies")){

                     Companies companiesFrom = new Companies();

                     if (fromProperty.equals("name")){
                         companiesFrom = findBean.nameCompanies(fromValue,em);
                         f.line(companiesFrom.getName());
                     } // companies

                     if (to.equals("Brands")){

                         Brands brandsTo = new Brands();

                         if (toProperty.equals("name")){
                             brandsTo = findBean.nameBrands(toValue,em);
                         } // Brands.name

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             brandsTo.setCompanies(companiesFrom);
                         }

                         em.persist(brandsTo);
                         em.flush();

                     } // to: Brands
                 } // from: Companies

                 if (from.equals("Companies")){

                     Companies companiesFrom = new Companies();

                     if (fromProperty.equals("name")){
                         companiesFrom = findBean.nameCompanies(fromValue,em);
                         f.line(companiesFrom.getName());
                     } // companies

                     if (to.equals("Employees")){

                         Employees employeesTo = new Employees();

                         if (toProperty.equals("code")){
                             employeesTo = findBean.codeEmployees(toValue,em);
                         } // Employees.code

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             employeesTo.setCompanies(companiesFrom);
                         }

                         em.persist(employeesTo);
                         em.flush();

                     } // to: Employees
                 } // from: Companies

                 if (from.equals("Companies")){

                     Companies companiesFrom = new Companies();

                     if (fromProperty.equals("name")){
                         companiesFrom = findBean.nameCompanies(fromValue,em);
                         f.line(companiesFrom.getName());
                     } // companies

                     if (to.equals("Companies")){

                         Companies companiesTo = new Companies();

                         if (toProperty.equals("name")){
                             companiesTo = findBean.nameCompanies(toValue,em);
                         } // Companies.name

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             companiesTo.setObjPadre(companiesFrom);
                         }

                         em.persist(companiesTo);
                         em.flush();

                     } // to: Companies
                 } // from: Companies

                 if (from.equals("EmployeesTypes")){

                     EmployeesTypes employeesTypesFrom = new EmployeesTypes();

                     if (fromProperty.equals("name")){
                         employeesTypesFrom = findBean.nameEmployeesTypes(fromValue,em);
                         f.line(employeesTypesFrom.getName());
                     } // employeesTypes

                     if (to.equals("Employees")){

                         Employees employeesTo = new Employees();

                         if (toProperty.equals("code")){
                             employeesTo = findBean.codeEmployees(toValue,em);
                         } // Employees.code

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             employeesTo.setEmployeesTypes(employeesTypesFrom);
                         }

                         em.persist(employeesTo);
                         em.flush();

                     } // to: Employees
                 } // from: EmployeesTypes

                 if (from.equals("CompaniesRolesTypes")){

                     CompaniesRolesTypes companiesRolesTypesFrom = new CompaniesRolesTypes();

                     if (fromProperty.equals("name")){
                         companiesRolesTypesFrom = findBean.nameCompaniesRolesTypes(fromValue,em);
                         f.line(companiesRolesTypesFrom.getName());
                     } // companiesRolesTypes

                     if (to.equals("CompaniesRoles")){

                         CompaniesRoles companiesRolesTo = new CompaniesRoles();

                         if (toProperty.equals("name")){
                             companiesRolesTo = findBean.nameCompaniesRoles(toValue,em);
                         } // CompaniesRoles.name

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             companiesRolesTo.setCompaniesRolesTypes(companiesRolesTypesFrom);
                         }

                         em.persist(companiesRolesTo);
                         em.flush();

                     } // to: CompaniesRoles
                 } // from: CompaniesRolesTypes

                 if (from.equals("CompaniesRolesTypes")){

                     CompaniesRolesTypes companiesRolesTypesFrom = new CompaniesRolesTypes();

                     if (fromProperty.equals("name")){
                         companiesRolesTypesFrom = findBean.nameCompaniesRolesTypes(fromValue,em);
                         f.line(companiesRolesTypesFrom.getName());
                     } // companiesRolesTypes

                     if (to.equals("CompaniesRolesTypes")){

                         CompaniesRolesTypes companiesRolesTypesTo = new CompaniesRolesTypes();

                         if (toProperty.equals("name")){
                             companiesRolesTypesTo = findBean.nameCompaniesRolesTypes(toValue,em);
                         } // CompaniesRolesTypes.name

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             companiesRolesTypesTo.setObjPadre(companiesRolesTypesFrom);
                         }

                         em.persist(companiesRolesTypesTo);
                         em.flush();

                     } // to: CompaniesRolesTypes
                 } // from: CompaniesRolesTypes

                 if (from.equals("CompaniesRoles")){

                     CompaniesRoles companiesRolesFrom = new CompaniesRoles();

                     if (fromProperty.equals("name")){
                         companiesRolesFrom = findBean.nameCompaniesRoles(fromValue,em);
                         f.line(companiesRolesFrom.getName());
                     } // companiesRoles

                     if (to.equals("DocumentalsUnits")){

                         DocumentalsUnits documentalsUnitsTo = new DocumentalsUnits();

                         if (toProperty.equals("name")){
                             documentalsUnitsTo = findBean.nameDocumentalsUnits(toValue,em);
                         } // DocumentalsUnits.name

                         if (toProperty.equals("code")){
                             documentalsUnitsTo = findBean.codeDocumentalsUnits(toValue,em);
                         } // DocumentalsUnits.code

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             documentalsUnitsTo.setAlmacenamiento(companiesRolesFrom);
                         }

                         em.persist(documentalsUnitsTo);
                         em.flush();

                     } // to: DocumentalsUnits
                 } // from: CompaniesRoles

                 if (from.equals("CompaniesRoles")){

                     CompaniesRoles companiesRolesFrom = new CompaniesRoles();

                     if (fromProperty.equals("name")){
                         companiesRolesFrom = findBean.nameCompaniesRoles(fromValue,em);
                         f.line(companiesRolesFrom.getName());
                     } // companiesRoles

                     if (to.equals("DocumentalsUnits")){

                         DocumentalsUnits documentalsUnitsTo = new DocumentalsUnits();

                         if (toProperty.equals("name")){
                             documentalsUnitsTo = findBean.nameDocumentalsUnits(toValue,em);
                         } // DocumentalsUnits.name

                         if (toProperty.equals("code")){
                             documentalsUnitsTo = findBean.codeDocumentalsUnits(toValue,em);
                         } // DocumentalsUnits.code

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             documentalsUnitsTo.setProteccion(companiesRolesFrom);
                         }

                         em.persist(documentalsUnitsTo);
                         em.flush();

                     } // to: DocumentalsUnits
                 } // from: CompaniesRoles

                 if (from.equals("ChargesTypes")){

                     ChargesTypes chargesTypesFrom = new ChargesTypes();

                     if (fromProperty.equals("name")){
                         chargesTypesFrom = findBean.nameChargesTypes(fromValue,em);
                         f.line(chargesTypesFrom.getName());
                     } // chargesTypes

                     if (to.equals("Charges")){

                         Charges chargesTo = new Charges();

                         if (toProperty.equals("name")){
                             chargesTo = findBean.nameCharges(toValue,em);
                         } // Charges.name

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             chargesTo.setChargesTypes(chargesTypesFrom);
                         }

                         em.persist(chargesTo);
                         em.flush();

                     } // to: Charges
                 } // from: ChargesTypes

                 if (from.equals("ChargesTypes")){

                     ChargesTypes chargesTypesFrom = new ChargesTypes();

                     if (fromProperty.equals("name")){
                         chargesTypesFrom = findBean.nameChargesTypes(fromValue,em);
                         f.line(chargesTypesFrom.getName());
                     } // chargesTypes

                     if (to.equals("ChargesTypes")){

                         ChargesTypes chargesTypesTo = new ChargesTypes();

                         if (toProperty.equals("name")){
                             chargesTypesTo = findBean.nameChargesTypes(toValue,em);
                         } // ChargesTypes.name

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             chargesTypesTo.setObjPadre(chargesTypesFrom);
                         }

                         em.persist(chargesTypesTo);
                         em.flush();

                     } // to: ChargesTypes
                 } // from: ChargesTypes

                 if (from.equals("ImprovementTypes")){

                     ImprovementTypes improvementTypesFrom = new ImprovementTypes();

                     if (fromProperty.equals("name")){
                         improvementTypesFrom = findBean.nameImprovementTypes(fromValue,em);
                         f.line(improvementTypesFrom.getName());
                     } // improvementTypes

                     if (to.equals("ContinualImprovements")){

                         ContinualImprovements continualImprovementsTo = new ContinualImprovements();

                         if (toProperty.equals("code")){
                             continualImprovementsTo = findBean.codeContinualImprovements(toValue,em);
                         } // ContinualImprovements.code

                         if (toProperty.equals("description")){
                             continualImprovementsTo = findBean.descriptionContinualImprovements(toValue,em);
                         } // ContinualImprovements.description

                         if (toProperty.equals("causesAnalysis")){
                             continualImprovementsTo = findBean.causesAnalysisContinualImprovements(toValue,em);
                         } // ContinualImprovements.causesAnalysis

                         if (toProperty.equals("rootCause")){
                             continualImprovementsTo = findBean.rootCauseContinualImprovements(toValue,em);
                         } // ContinualImprovements.rootCause

                         if (toProperty.equals("immediateCorrection")){
                             continualImprovementsTo = findBean.immediateCorrectionContinualImprovements(toValue,em);
                         } // ContinualImprovements.immediateCorrection

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             continualImprovementsTo.setImprovementTypes(improvementTypesFrom);
                         }

                         em.persist(continualImprovementsTo);
                         em.flush();

                     } // to: ContinualImprovements
                 } // from: ImprovementTypes

                 if (from.equals("ImprovementSources")){

                     ImprovementSources improvementSourcesFrom = new ImprovementSources();

                     if (fromProperty.equals("name")){
                         improvementSourcesFrom = findBean.nameImprovementSources(fromValue,em);
                         f.line(improvementSourcesFrom.getName());
                     } // improvementSources

                     if (to.equals("ContinualImprovements")){

                         ContinualImprovements continualImprovementsTo = new ContinualImprovements();

                         if (toProperty.equals("code")){
                             continualImprovementsTo = findBean.codeContinualImprovements(toValue,em);
                         } // ContinualImprovements.code

                         if (toProperty.equals("description")){
                             continualImprovementsTo = findBean.descriptionContinualImprovements(toValue,em);
                         } // ContinualImprovements.description

                         if (toProperty.equals("causesAnalysis")){
                             continualImprovementsTo = findBean.causesAnalysisContinualImprovements(toValue,em);
                         } // ContinualImprovements.causesAnalysis

                         if (toProperty.equals("rootCause")){
                             continualImprovementsTo = findBean.rootCauseContinualImprovements(toValue,em);
                         } // ContinualImprovements.rootCause

                         if (toProperty.equals("immediateCorrection")){
                             continualImprovementsTo = findBean.immediateCorrectionContinualImprovements(toValue,em);
                         } // ContinualImprovements.immediateCorrection

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             continualImprovementsTo.setImprovementSources(improvementSourcesFrom);
                         }

                         em.persist(continualImprovementsTo);
                         em.flush();

                     } // to: ContinualImprovements
                 } // from: ImprovementSources

                 if (from.equals("ContinualImprovements")){

                     ContinualImprovements continualImprovementsFrom = new ContinualImprovements();

                     if (fromProperty.equals("code")){
                         continualImprovementsFrom = findBean.codeContinualImprovements(fromValue,em);
                         f.line(continualImprovementsFrom.getCode());
                     } // continualImprovements

                     if (fromProperty.equals("description")){
                         continualImprovementsFrom = findBean.descriptionContinualImprovements(fromValue,em);
                         f.line(continualImprovementsFrom.getDescription());
                     } // continualImprovements

                     if (fromProperty.equals("causesAnalysis")){
                         continualImprovementsFrom = findBean.causesAnalysisContinualImprovements(fromValue,em);
                         f.line(continualImprovementsFrom.getCausesAnalysis());
                     } // continualImprovements

                     if (fromProperty.equals("rootCause")){
                         continualImprovementsFrom = findBean.rootCauseContinualImprovements(fromValue,em);
                         f.line(continualImprovementsFrom.getRootCause());
                     } // continualImprovements

                     if (fromProperty.equals("immediateCorrection")){
                         continualImprovementsFrom = findBean.immediateCorrectionContinualImprovements(fromValue,em);
                         f.line(continualImprovementsFrom.getImmediateCorrection());
                     } // continualImprovements

                     if (to.equals("OriginalOrders")){

                         OriginalOrders originalOrdersTo = new OriginalOrders();

                         if (toProperty.equals("subject")){
                             originalOrdersTo = findBean.subjectOriginalOrders(toValue,em);
                         } // OriginalOrders.subject

                         if (toProperty.equals("code")){
                             originalOrdersTo = findBean.codeOriginalOrders(toValue,em);
                         } // OriginalOrders.code

                         if (toProperty.equals("located")){
                             originalOrdersTo = findBean.locatedOriginalOrders(toValue,em);
                         } // OriginalOrders.located

                         if (toProperty.equals("mail")){
                             originalOrdersTo = findBean.mailOriginalOrders(toValue,em);
                         } // OriginalOrders.mail

                         if (toProperty.equals("notes")){
                             originalOrdersTo = findBean.notesOriginalOrders(toValue,em);
                         } // OriginalOrders.notes

                         if (toProperty.equals("fileName")){
                             originalOrdersTo = findBean.fileNameOriginalOrders(toValue,em);
                         } // OriginalOrders.fileName

                         if (toProperty.equals("fileType")){
                             originalOrdersTo = findBean.fileTypeOriginalOrders(toValue,em);
                         } // OriginalOrders.fileType

                         if (toProperty.equals("filedir")){
                             originalOrdersTo = findBean.filedirOriginalOrders(toValue,em);
                         } // OriginalOrders.filedir

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             originalOrdersTo.setContinualImprovements(continualImprovementsFrom);
                         }

                         em.persist(originalOrdersTo);
                         em.flush();

                     } // to: OriginalOrders
                 } // from: ContinualImprovements

                 if (from.equals("ContinualImprovements")){

                     ContinualImprovements continualImprovementsFrom = new ContinualImprovements();

                     if (fromProperty.equals("code")){
                         continualImprovementsFrom = findBean.codeContinualImprovements(fromValue,em);
                         f.line(continualImprovementsFrom.getCode());
                     } // continualImprovements

                     if (fromProperty.equals("description")){
                         continualImprovementsFrom = findBean.descriptionContinualImprovements(fromValue,em);
                         f.line(continualImprovementsFrom.getDescription());
                     } // continualImprovements

                     if (fromProperty.equals("causesAnalysis")){
                         continualImprovementsFrom = findBean.causesAnalysisContinualImprovements(fromValue,em);
                         f.line(continualImprovementsFrom.getCausesAnalysis());
                     } // continualImprovements

                     if (fromProperty.equals("rootCause")){
                         continualImprovementsFrom = findBean.rootCauseContinualImprovements(fromValue,em);
                         f.line(continualImprovementsFrom.getRootCause());
                     } // continualImprovements

                     if (fromProperty.equals("immediateCorrection")){
                         continualImprovementsFrom = findBean.immediateCorrectionContinualImprovements(fromValue,em);
                         f.line(continualImprovementsFrom.getImmediateCorrection());
                     } // continualImprovements

                     if (to.equals("ActionPlans")){

                         ActionPlans actionPlansTo = new ActionPlans();

                         if (toProperty.equals("evidences")){
                             actionPlansTo = findBean.evidencesActionPlans(toValue,em);
                         } // ActionPlans.evidences

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             actionPlansTo.setContinualImprovements(continualImprovementsFrom);
                         }

                         em.persist(actionPlansTo);
                         em.flush();

                     } // to: ActionPlans
                 } // from: ContinualImprovements

                 if (from.equals("ImprovementVerifications")){

                     ImprovementVerifications improvementVerificationsFrom = new ImprovementVerifications();

                     if (to.equals("ContinualImprovements")){

                         ContinualImprovements continualImprovementsTo = new ContinualImprovements();

                         if (toProperty.equals("code")){
                             continualImprovementsTo = findBean.codeContinualImprovements(toValue,em);
                         } // ContinualImprovements.code

                         if (toProperty.equals("description")){
                             continualImprovementsTo = findBean.descriptionContinualImprovements(toValue,em);
                         } // ContinualImprovements.description

                         if (toProperty.equals("causesAnalysis")){
                             continualImprovementsTo = findBean.causesAnalysisContinualImprovements(toValue,em);
                         } // ContinualImprovements.causesAnalysis

                         if (toProperty.equals("rootCause")){
                             continualImprovementsTo = findBean.rootCauseContinualImprovements(toValue,em);
                         } // ContinualImprovements.rootCause

                         if (toProperty.equals("immediateCorrection")){
                             continualImprovementsTo = findBean.immediateCorrectionContinualImprovements(toValue,em);
                         } // ContinualImprovements.immediateCorrection

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             continualImprovementsTo.setImprovementVerifications(improvementVerificationsFrom);
                         }

                         em.persist(continualImprovementsTo);
                         em.flush();

                     } // to: ContinualImprovements
                 } // from: ImprovementVerifications

                 if (from.equals("ImprovementClosures")){

                     ImprovementClosures improvementClosuresFrom = new ImprovementClosures();

                     if (to.equals("ClosingActivities")){

                         ClosingActivities closingActivitiesTo = new ClosingActivities();

                         if (toProperty.equals("name")){
                             closingActivitiesTo = findBean.nameClosingActivities(toValue,em);
                         } // ClosingActivities.name

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             closingActivitiesTo.setImprovementClosures(improvementClosuresFrom);
                         }

                         em.persist(closingActivitiesTo);
                         em.flush();

                     } // to: ClosingActivities
                 } // from: ImprovementClosures

                 if (from.equals("ImprovementClosures")){

                     ImprovementClosures improvementClosuresFrom = new ImprovementClosures();

                     if (to.equals("ContinualImprovements")){

                         ContinualImprovements continualImprovementsTo = new ContinualImprovements();

                         if (toProperty.equals("code")){
                             continualImprovementsTo = findBean.codeContinualImprovements(toValue,em);
                         } // ContinualImprovements.code

                         if (toProperty.equals("description")){
                             continualImprovementsTo = findBean.descriptionContinualImprovements(toValue,em);
                         } // ContinualImprovements.description

                         if (toProperty.equals("causesAnalysis")){
                             continualImprovementsTo = findBean.causesAnalysisContinualImprovements(toValue,em);
                         } // ContinualImprovements.causesAnalysis

                         if (toProperty.equals("rootCause")){
                             continualImprovementsTo = findBean.rootCauseContinualImprovements(toValue,em);
                         } // ContinualImprovements.rootCause

                         if (toProperty.equals("immediateCorrection")){
                             continualImprovementsTo = findBean.immediateCorrectionContinualImprovements(toValue,em);
                         } // ContinualImprovements.immediateCorrection

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             continualImprovementsTo.setImprovementClosures(improvementClosuresFrom);
                         }

                         em.persist(continualImprovementsTo);
                         em.flush();

                     } // to: ContinualImprovements
                 } // from: ImprovementClosures

                 if (from.equals("ItemsTypes")){

                     ItemsTypes itemsTypesFrom = new ItemsTypes();

                     if (fromProperty.equals("name")){
                         itemsTypesFrom = findBean.nameItemsTypes(fromValue,em);
                         f.line(itemsTypesFrom.getName());
                     } // itemsTypes

                     if (to.equals("ItemsTypes")){

                         ItemsTypes itemsTypesTo = new ItemsTypes();

                         if (toProperty.equals("name")){
                             itemsTypesTo = findBean.nameItemsTypes(toValue,em);
                         } // ItemsTypes.name

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             itemsTypesTo.setObjPadre(itemsTypesFrom);
                         }

                         em.persist(itemsTypesTo);
                         em.flush();

                     } // to: ItemsTypes
                 } // from: ItemsTypes

                 if (from.equals("ItemsTypes")){

                     ItemsTypes itemsTypesFrom = new ItemsTypes();

                     if (fromProperty.equals("name")){
                         itemsTypesFrom = findBean.nameItemsTypes(fromValue,em);
                         f.line(itemsTypesFrom.getName());
                     } // itemsTypes

                     if (to.equals("ItemsNames")){

                         ItemsNames itemsNamesTo = new ItemsNames();

                         if (toProperty.equals("name")){
                             itemsNamesTo = findBean.nameItemsNames(toValue,em);
                         } // ItemsNames.name

                         if (toProperty.equals("model")){
                             itemsNamesTo = findBean.modelItemsNames(toValue,em);
                         } // ItemsNames.model

                         if (toProperty.equals("productNumber")){
                             itemsNamesTo = findBean.productNumberItemsNames(toValue,em);
                         } // ItemsNames.productNumber

                         if (toProperty.equals("partNumber")){
                             itemsNamesTo = findBean.partNumberItemsNames(toValue,em);
                         } // ItemsNames.partNumber

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             itemsNamesTo.setItemsTypes(itemsTypesFrom);
                         }

                         em.persist(itemsNamesTo);
                         em.flush();

                     } // to: ItemsNames
                 } // from: ItemsTypes

                 if (from.equals("ItemsNames")){

                     ItemsNames itemsNamesFrom = new ItemsNames();

                     if (fromProperty.equals("name")){
                         itemsNamesFrom = findBean.nameItemsNames(fromValue,em);
                         f.line(itemsNamesFrom.getName());
                     } // itemsNames

                     if (fromProperty.equals("model")){
                         itemsNamesFrom = findBean.modelItemsNames(fromValue,em);
                         f.line(itemsNamesFrom.getModel());
                     } // itemsNames

                     if (fromProperty.equals("productNumber")){
                         itemsNamesFrom = findBean.productNumberItemsNames(fromValue,em);
                         f.line(itemsNamesFrom.getProductNumber());
                     } // itemsNames

                     if (fromProperty.equals("partNumber")){
                         itemsNamesFrom = findBean.partNumberItemsNames(fromValue,em);
                         f.line(itemsNamesFrom.getPartNumber());
                     } // itemsNames

                     if (to.equals("Items")){

                         Items itemsTo = new Items();

                         if (toProperty.equals("cvNumber")){
                             itemsTo = findBean.cvNumberItems(toValue,em);
                         } // Items.cvNumber

                         if (toProperty.equals("code")){
                             itemsTo = findBean.codeItems(toValue,em);
                         } // Items.code

                         if (toProperty.equals("inventoryCode")){
                             itemsTo = findBean.inventoryCodeItems(toValue,em);
                         } // Items.inventoryCode

                         if (toProperty.equals("serial")){
                             itemsTo = findBean.serialItems(toValue,em);
                         } // Items.serial

                         if (toProperty.equals("eanCode")){
                             itemsTo = findBean.eanCodeItems(toValue,em);
                         } // Items.eanCode

                         if (toProperty.equals("located")){
                             itemsTo = findBean.locatedItems(toValue,em);
                         } // Items.located

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             itemsTo.setItemsNames(itemsNamesFrom);
                         }

                         em.persist(itemsTo);
                         em.flush();

                     } // to: Items
                 } // from: ItemsNames

                 if (from.equals("Items")){

                     Items itemsFrom = new Items();

                     if (fromProperty.equals("cvNumber")){
                         itemsFrom = findBean.cvNumberItems(fromValue,em);
                         f.line(itemsFrom.getCvNumber());
                     } // items

                     if (fromProperty.equals("code")){
                         itemsFrom = findBean.codeItems(fromValue,em);
                         f.line(itemsFrom.getCode());
                     } // items

                     if (fromProperty.equals("inventoryCode")){
                         itemsFrom = findBean.inventoryCodeItems(fromValue,em);
                         f.line(itemsFrom.getInventoryCode());
                     } // items

                     if (fromProperty.equals("serial")){
                         itemsFrom = findBean.serialItems(fromValue,em);
                         f.line(itemsFrom.getSerial());
                     } // items

                     if (fromProperty.equals("eanCode")){
                         itemsFrom = findBean.eanCodeItems(fromValue,em);
                         f.line(itemsFrom.getEanCode());
                     } // items

                     if (fromProperty.equals("located")){
                         itemsFrom = findBean.locatedItems(fromValue,em);
                         f.line(itemsFrom.getLocated());
                     } // items

                     if (to.equals("Hosts")){

                         Hosts hostsTo = new Hosts();

                         if (toProperty.equals("name")){
                             hostsTo = findBean.nameHosts(toValue,em);
                         } // Hosts.name

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             hostsTo.setItems(itemsFrom);
                         }

                         em.persist(hostsTo);
                         em.flush();

                     } // to: Hosts
                 } // from: Items

                 if (from.equals("Items")){

                     Items itemsFrom = new Items();

                     if (fromProperty.equals("cvNumber")){
                         itemsFrom = findBean.cvNumberItems(fromValue,em);
                         f.line(itemsFrom.getCvNumber());
                     } // items

                     if (fromProperty.equals("code")){
                         itemsFrom = findBean.codeItems(fromValue,em);
                         f.line(itemsFrom.getCode());
                     } // items

                     if (fromProperty.equals("inventoryCode")){
                         itemsFrom = findBean.inventoryCodeItems(fromValue,em);
                         f.line(itemsFrom.getInventoryCode());
                     } // items

                     if (fromProperty.equals("serial")){
                         itemsFrom = findBean.serialItems(fromValue,em);
                         f.line(itemsFrom.getSerial());
                     } // items

                     if (fromProperty.equals("eanCode")){
                         itemsFrom = findBean.eanCodeItems(fromValue,em);
                         f.line(itemsFrom.getEanCode());
                     } // items

                     if (fromProperty.equals("located")){
                         itemsFrom = findBean.locatedItems(fromValue,em);
                         f.line(itemsFrom.getLocated());
                     } // items

                     if (to.equals("Items")){

                         Items itemsTo = new Items();

                         if (toProperty.equals("cvNumber")){
                             itemsTo = findBean.cvNumberItems(toValue,em);
                         } // Items.cvNumber

                         if (toProperty.equals("code")){
                             itemsTo = findBean.codeItems(toValue,em);
                         } // Items.code

                         if (toProperty.equals("inventoryCode")){
                             itemsTo = findBean.inventoryCodeItems(toValue,em);
                         } // Items.inventoryCode

                         if (toProperty.equals("serial")){
                             itemsTo = findBean.serialItems(toValue,em);
                         } // Items.serial

                         if (toProperty.equals("eanCode")){
                             itemsTo = findBean.eanCodeItems(toValue,em);
                         } // Items.eanCode

                         if (toProperty.equals("located")){
                             itemsTo = findBean.locatedItems(toValue,em);
                         } // Items.located

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             itemsTo.setObjPadre(itemsFrom);
                         }

                         em.persist(itemsTo);
                         em.flush();

                     } // to: Items
                 } // from: Items

                 if (from.equals("ItemsStates")){

                     ItemsStates itemsStatesFrom = new ItemsStates();

                     if (fromProperty.equals("name")){
                         itemsStatesFrom = findBean.nameItemsStates(fromValue,em);
                         f.line(itemsStatesFrom.getName());
                     } // itemsStates

                     if (to.equals("Items")){

                         Items itemsTo = new Items();

                         if (toProperty.equals("cvNumber")){
                             itemsTo = findBean.cvNumberItems(toValue,em);
                         } // Items.cvNumber

                         if (toProperty.equals("code")){
                             itemsTo = findBean.codeItems(toValue,em);
                         } // Items.code

                         if (toProperty.equals("inventoryCode")){
                             itemsTo = findBean.inventoryCodeItems(toValue,em);
                         } // Items.inventoryCode

                         if (toProperty.equals("serial")){
                             itemsTo = findBean.serialItems(toValue,em);
                         } // Items.serial

                         if (toProperty.equals("eanCode")){
                             itemsTo = findBean.eanCodeItems(toValue,em);
                         } // Items.eanCode

                         if (toProperty.equals("located")){
                             itemsTo = findBean.locatedItems(toValue,em);
                         } // Items.located

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             itemsTo.setItemsStates(itemsStatesFrom);
                         }

                         em.persist(itemsTo);
                         em.flush();

                     } // to: Items
                 } // from: ItemsStates

                 if (from.equals("HostsTypes")){

                     HostsTypes hostsTypesFrom = new HostsTypes();

                     if (fromProperty.equals("name")){
                         hostsTypesFrom = findBean.nameHostsTypes(fromValue,em);
                         f.line(hostsTypesFrom.getName());
                     } // hostsTypes

                     if (to.equals("Hosts")){

                         Hosts hostsTo = new Hosts();

                         if (toProperty.equals("name")){
                             hostsTo = findBean.nameHosts(toValue,em);
                         } // Hosts.name

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             hostsTo.setHostsTypes(hostsTypesFrom);
                         }

                         em.persist(hostsTo);
                         em.flush();

                     } // to: Hosts
                 } // from: HostsTypes

                 if (from.equals("Hosts")){

                     Hosts hostsFrom = new Hosts();

                     if (fromProperty.equals("name")){
                         hostsFrom = findBean.nameHosts(fromValue,em);
                         f.line(hostsFrom.getName());
                     } // hosts

                     if (to.equals("NetworkPorts")){

                         NetworkPorts networkPortsTo = new NetworkPorts();

                         if (toProperty.equals("macAddress")){
                             networkPortsTo = findBean.macAddressNetworkPorts(toValue,em);
                         } // NetworkPorts.macAddress

                         if (toProperty.equals("ipAddress")){
                             networkPortsTo = findBean.ipAddressNetworkPorts(toValue,em);
                         } // NetworkPorts.ipAddress

                         if (toProperty.equals("state")){
                             networkPortsTo = findBean.stateNetworkPorts(toValue,em);
                         } // NetworkPorts.state

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             networkPortsTo.setHosts(hostsFrom);
                         }

                         em.persist(networkPortsTo);
                         em.flush();

                     } // to: NetworkPorts
                 } // from: Hosts

                 if (from.equals("Hosts")){

                     Hosts hostsFrom = new Hosts();

                     if (fromProperty.equals("name")){
                         hostsFrom = findBean.nameHosts(fromValue,em);
                         f.line(hostsFrom.getName());
                     } // hosts

                     if (to.equals("PatchPanelsPorts")){

                         PatchPanelsPorts patchPanelsPortsTo = new PatchPanelsPorts();

                         if (toProperty.equals("port")){
                             patchPanelsPortsTo = findBean.portPatchPanelsPorts(toValue,em);
                         } // PatchPanelsPorts.port

                         if (toProperty.equals("code")){
                             patchPanelsPortsTo = findBean.codePatchPanelsPorts(toValue,em);
                         } // PatchPanelsPorts.code

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             patchPanelsPortsTo.setHosts(hostsFrom);
                         }

                         em.persist(patchPanelsPortsTo);
                         em.flush();

                     } // to: PatchPanelsPorts
                 } // from: Hosts

                 if (from.equals("Hosts")){

                     Hosts hostsFrom = new Hosts();

                     if (fromProperty.equals("name")){
                         hostsFrom = findBean.nameHosts(fromValue,em);
                         f.line(hostsFrom.getName());
                     } // hosts

                     if (to.equals("SwitchesPorts")){

                         SwitchesPorts switchesPortsTo = new SwitchesPorts();

                         if (toProperty.equals("port")){
                             switchesPortsTo = findBean.portSwitchesPorts(toValue,em);
                         } // SwitchesPorts.port

                         if (toProperty.equals("code")){
                             switchesPortsTo = findBean.codeSwitchesPorts(toValue,em);
                         } // SwitchesPorts.code

                         if (toProperty.equals("state")){
                             switchesPortsTo = findBean.stateSwitchesPorts(toValue,em);
                         } // SwitchesPorts.state

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             switchesPortsTo.setHosts(hostsFrom);
                         }

                         em.persist(switchesPortsTo);
                         em.flush();

                     } // to: SwitchesPorts
                 } // from: Hosts

                 if (from.equals("PatchPanelsPorts")){

                     PatchPanelsPorts patchPanelsPortsFrom = new PatchPanelsPorts();

                     if (fromProperty.equals("port")){
                         patchPanelsPortsFrom = findBean.portPatchPanelsPorts(fromValue,em);
                         f.line(patchPanelsPortsFrom.getPort());
                     } // patchPanelsPorts

                     if (fromProperty.equals("code")){
                         patchPanelsPortsFrom = findBean.codePatchPanelsPorts(fromValue,em);
                         f.line(patchPanelsPortsFrom.getCode());
                     } // patchPanelsPorts

                     if (to.equals("NetworkPorts")){

                         NetworkPorts networkPortsTo = new NetworkPorts();

                         if (toProperty.equals("macAddress")){
                             networkPortsTo = findBean.macAddressNetworkPorts(toValue,em);
                         } // NetworkPorts.macAddress

                         if (toProperty.equals("ipAddress")){
                             networkPortsTo = findBean.ipAddressNetworkPorts(toValue,em);
                         } // NetworkPorts.ipAddress

                         if (toProperty.equals("state")){
                             networkPortsTo = findBean.stateNetworkPorts(toValue,em);
                         } // NetworkPorts.state

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             networkPortsTo.setPatchPanelsPorts(patchPanelsPortsFrom);
                         }

                         em.persist(networkPortsTo);
                         em.flush();

                     } // to: NetworkPorts
                 } // from: PatchPanelsPorts

                 if (from.equals("SwitchesPorts")){

                     SwitchesPorts switchesPortsFrom = new SwitchesPorts();

                     if (fromProperty.equals("port")){
                         switchesPortsFrom = findBean.portSwitchesPorts(fromValue,em);
                         f.line(switchesPortsFrom.getPort());
                     } // switchesPorts

                     if (fromProperty.equals("code")){
                         switchesPortsFrom = findBean.codeSwitchesPorts(fromValue,em);
                         f.line(switchesPortsFrom.getCode());
                     } // switchesPorts

                     if (fromProperty.equals("state")){
                         switchesPortsFrom = findBean.stateSwitchesPorts(fromValue,em);
                         f.line(switchesPortsFrom.getState());
                     } // switchesPorts

                     if (to.equals("PatchPanelsPorts")){

                         PatchPanelsPorts patchPanelsPortsTo = new PatchPanelsPorts();

                         if (toProperty.equals("port")){
                             patchPanelsPortsTo = findBean.portPatchPanelsPorts(toValue,em);
                         } // PatchPanelsPorts.port

                         if (toProperty.equals("code")){
                             patchPanelsPortsTo = findBean.codePatchPanelsPorts(toValue,em);
                         } // PatchPanelsPorts.code

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             patchPanelsPortsTo.setSwitchesPorts(switchesPortsFrom);
                         }

                         em.persist(patchPanelsPortsTo);
                         em.flush();

                     } // to: PatchPanelsPorts
                 } // from: SwitchesPorts

                 if (from.equals("Vlans")){

                     Vlans vlansFrom = new Vlans();

                     if (fromProperty.equals("name")){
                         vlansFrom = findBean.nameVlans(fromValue,em);
                         f.line(vlansFrom.getName());
                     } // vlans

                     if (fromProperty.equals("ipMask")){
                         vlansFrom = findBean.ipMaskVlans(fromValue,em);
                         f.line(vlansFrom.getIpMask());
                     } // vlans

                     if (fromProperty.equals("ipGateway")){
                         vlansFrom = findBean.ipGatewayVlans(fromValue,em);
                         f.line(vlansFrom.getIpGateway());
                     } // vlans

                     if (to.equals("SwitchesPorts")){

                         SwitchesPorts switchesPortsTo = new SwitchesPorts();

                         if (toProperty.equals("port")){
                             switchesPortsTo = findBean.portSwitchesPorts(toValue,em);
                         } // SwitchesPorts.port

                         if (toProperty.equals("code")){
                             switchesPortsTo = findBean.codeSwitchesPorts(toValue,em);
                         } // SwitchesPorts.code

                         if (toProperty.equals("state")){
                             switchesPortsTo = findBean.stateSwitchesPorts(toValue,em);
                         } // SwitchesPorts.state

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             switchesPortsTo.setVlans(vlansFrom);
                         }

                         em.persist(switchesPortsTo);
                         em.flush();

                     } // to: SwitchesPorts
                 } // from: Vlans

                 if (from.equals("Persons")){

                     Persons personsFrom = new Persons();

                     if (fromProperty.equals("firstName")){
                         personsFrom = findBean.firstNamePersons(fromValue,em);
                         f.line(personsFrom.getFirstName());
                     } // persons

                     if (fromProperty.equals("secondName")){
                         personsFrom = findBean.secondNamePersons(fromValue,em);
                         f.line(personsFrom.getSecondName());
                     } // persons

                     if (fromProperty.equals("firstLastName")){
                         personsFrom = findBean.firstLastNamePersons(fromValue,em);
                         f.line(personsFrom.getFirstLastName());
                     } // persons

                     if (fromProperty.equals("secondLastName")){
                         personsFrom = findBean.secondLastNamePersons(fromValue,em);
                         f.line(personsFrom.getSecondLastName());
                     } // persons

                     if (fromProperty.equals("email")){
                         personsFrom = findBean.emailPersons(fromValue,em);
                         f.line(personsFrom.getEmail());
                     } // persons

                     if (fromProperty.equals("mobile")){
                         personsFrom = findBean.mobilePersons(fromValue,em);
                         f.line(personsFrom.getMobile());
                     } // persons

                     if (fromProperty.equals("telephone")){
                         personsFrom = findBean.telephonePersons(fromValue,em);
                         f.line(personsFrom.getTelephone());
                     } // persons

                     if (fromProperty.equals("skipe")){
                         personsFrom = findBean.skipePersons(fromValue,em);
                         f.line(personsFrom.getSkipe());
                     } // persons

                     if (fromProperty.equals("address")){
                         personsFrom = findBean.addressPersons(fromValue,em);
                         f.line(personsFrom.getAddress());
                     } // persons

                     if (to.equals("Tasks")){

                         Tasks tasksTo = new Tasks();

                         if (toProperty.equals("name")){
                             tasksTo = findBean.nameTasks(toValue,em);
                         } // Tasks.name

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             tasksTo.setPersons(personsFrom);
                         }

                         em.persist(tasksTo);
                         em.flush();

                     } // to: Tasks
                 } // from: Persons

                 if (from.equals("Persons")){

                     Persons personsFrom = new Persons();

                     if (fromProperty.equals("firstName")){
                         personsFrom = findBean.firstNamePersons(fromValue,em);
                         f.line(personsFrom.getFirstName());
                     } // persons

                     if (fromProperty.equals("secondName")){
                         personsFrom = findBean.secondNamePersons(fromValue,em);
                         f.line(personsFrom.getSecondName());
                     } // persons

                     if (fromProperty.equals("firstLastName")){
                         personsFrom = findBean.firstLastNamePersons(fromValue,em);
                         f.line(personsFrom.getFirstLastName());
                     } // persons

                     if (fromProperty.equals("secondLastName")){
                         personsFrom = findBean.secondLastNamePersons(fromValue,em);
                         f.line(personsFrom.getSecondLastName());
                     } // persons

                     if (fromProperty.equals("email")){
                         personsFrom = findBean.emailPersons(fromValue,em);
                         f.line(personsFrom.getEmail());
                     } // persons

                     if (fromProperty.equals("mobile")){
                         personsFrom = findBean.mobilePersons(fromValue,em);
                         f.line(personsFrom.getMobile());
                     } // persons

                     if (fromProperty.equals("telephone")){
                         personsFrom = findBean.telephonePersons(fromValue,em);
                         f.line(personsFrom.getTelephone());
                     } // persons

                     if (fromProperty.equals("skipe")){
                         personsFrom = findBean.skipePersons(fromValue,em);
                         f.line(personsFrom.getSkipe());
                     } // persons

                     if (fromProperty.equals("address")){
                         personsFrom = findBean.addressPersons(fromValue,em);
                         f.line(personsFrom.getAddress());
                     } // persons

                     if (to.equals("Activities")){

                         Activities activitiesTo = new Activities();

                         if (toProperty.equals("name")){
                             activitiesTo = findBean.nameActivities(toValue,em);
                         } // Activities.name

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             activitiesTo.setPersons(personsFrom);
                         }

                         em.persist(activitiesTo);
                         em.flush();

                     } // to: Activities
                 } // from: Persons

                 if (from.equals("Persons")){

                     Persons personsFrom = new Persons();

                     if (fromProperty.equals("firstName")){
                         personsFrom = findBean.firstNamePersons(fromValue,em);
                         f.line(personsFrom.getFirstName());
                     } // persons

                     if (fromProperty.equals("secondName")){
                         personsFrom = findBean.secondNamePersons(fromValue,em);
                         f.line(personsFrom.getSecondName());
                     } // persons

                     if (fromProperty.equals("firstLastName")){
                         personsFrom = findBean.firstLastNamePersons(fromValue,em);
                         f.line(personsFrom.getFirstLastName());
                     } // persons

                     if (fromProperty.equals("secondLastName")){
                         personsFrom = findBean.secondLastNamePersons(fromValue,em);
                         f.line(personsFrom.getSecondLastName());
                     } // persons

                     if (fromProperty.equals("email")){
                         personsFrom = findBean.emailPersons(fromValue,em);
                         f.line(personsFrom.getEmail());
                     } // persons

                     if (fromProperty.equals("mobile")){
                         personsFrom = findBean.mobilePersons(fromValue,em);
                         f.line(personsFrom.getMobile());
                     } // persons

                     if (fromProperty.equals("telephone")){
                         personsFrom = findBean.telephonePersons(fromValue,em);
                         f.line(personsFrom.getTelephone());
                     } // persons

                     if (fromProperty.equals("skipe")){
                         personsFrom = findBean.skipePersons(fromValue,em);
                         f.line(personsFrom.getSkipe());
                     } // persons

                     if (fromProperty.equals("address")){
                         personsFrom = findBean.addressPersons(fromValue,em);
                         f.line(personsFrom.getAddress());
                     } // persons

                     if (to.equals("Employees")){

                         Employees employeesTo = new Employees();

                         if (toProperty.equals("code")){
                             employeesTo = findBean.codeEmployees(toValue,em);
                         } // Employees.code

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             employeesTo.setPersons(personsFrom);
                         }

                         em.persist(employeesTo);
                         em.flush();

                     } // to: Employees
                 } // from: Persons

                 if (from.equals("PhysicalAreasTypes")){

                     PhysicalAreasTypes physicalAreasTypesFrom = new PhysicalAreasTypes();

                     if (fromProperty.equals("name")){
                         physicalAreasTypesFrom = findBean.namePhysicalAreasTypes(fromValue,em);
                         f.line(physicalAreasTypesFrom.getName());
                     } // physicalAreasTypes

                     if (to.equals("PhysicalAreas")){

                         PhysicalAreas physicalAreasTo = new PhysicalAreas();

                         if (toProperty.equals("name")){
                             physicalAreasTo = findBean.namePhysicalAreas(toValue,em);
                         } // PhysicalAreas.name

                         if (toProperty.equals("code")){
                             physicalAreasTo = findBean.codePhysicalAreas(toValue,em);
                         } // PhysicalAreas.code

                         if (toProperty.equals("telExt")){
                             physicalAreasTo = findBean.telExtPhysicalAreas(toValue,em);
                         } // PhysicalAreas.telExt

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             physicalAreasTo.setPhysicalAreasTypes(physicalAreasTypesFrom);
                         }

                         em.persist(physicalAreasTo);
                         em.flush();

                     } // to: PhysicalAreas
                 } // from: PhysicalAreasTypes

                 if (from.equals("PhysicalAreasTypes")){

                     PhysicalAreasTypes physicalAreasTypesFrom = new PhysicalAreasTypes();

                     if (fromProperty.equals("name")){
                         physicalAreasTypesFrom = findBean.namePhysicalAreasTypes(fromValue,em);
                         f.line(physicalAreasTypesFrom.getName());
                     } // physicalAreasTypes

                     if (to.equals("PhysicalAreasTypes")){

                         PhysicalAreasTypes physicalAreasTypesTo = new PhysicalAreasTypes();

                         if (toProperty.equals("name")){
                             physicalAreasTypesTo = findBean.namePhysicalAreasTypes(toValue,em);
                         } // PhysicalAreasTypes.name

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             physicalAreasTypesTo.setObjPadre(physicalAreasTypesFrom);
                         }

                         em.persist(physicalAreasTypesTo);
                         em.flush();

                     } // to: PhysicalAreasTypes
                 } // from: PhysicalAreasTypes

                 if (from.equals("PhysicalAreas")){

                     PhysicalAreas physicalAreasFrom = new PhysicalAreas();

                     if (fromProperty.equals("name")){
                         physicalAreasFrom = findBean.namePhysicalAreas(fromValue,em);
                         f.line(physicalAreasFrom.getName());
                     } // physicalAreas

                     if (fromProperty.equals("code")){
                         physicalAreasFrom = findBean.codePhysicalAreas(fromValue,em);
                         f.line(physicalAreasFrom.getCode());
                     } // physicalAreas

                     if (fromProperty.equals("telExt")){
                         physicalAreasFrom = findBean.telExtPhysicalAreas(fromValue,em);
                         f.line(physicalAreasFrom.getTelExt());
                     } // physicalAreas

                     if (to.equals("Employees")){

                         Employees employeesTo = new Employees();

                         if (toProperty.equals("code")){
                             employeesTo = findBean.codeEmployees(toValue,em);
                         } // Employees.code

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             employeesTo.setPhysicalAreas(physicalAreasFrom);
                         }

                         em.persist(employeesTo);
                         em.flush();

                     } // to: Employees
                 } // from: PhysicalAreas

                 if (from.equals("PhysicalAreas")){

                     PhysicalAreas physicalAreasFrom = new PhysicalAreas();

                     if (fromProperty.equals("name")){
                         physicalAreasFrom = findBean.namePhysicalAreas(fromValue,em);
                         f.line(physicalAreasFrom.getName());
                     } // physicalAreas

                     if (fromProperty.equals("code")){
                         physicalAreasFrom = findBean.codePhysicalAreas(fromValue,em);
                         f.line(physicalAreasFrom.getCode());
                     } // physicalAreas

                     if (fromProperty.equals("telExt")){
                         physicalAreasFrom = findBean.telExtPhysicalAreas(fromValue,em);
                         f.line(physicalAreasFrom.getTelExt());
                     } // physicalAreas

                     if (to.equals("Items")){

                         Items itemsTo = new Items();

                         if (toProperty.equals("cvNumber")){
                             itemsTo = findBean.cvNumberItems(toValue,em);
                         } // Items.cvNumber

                         if (toProperty.equals("code")){
                             itemsTo = findBean.codeItems(toValue,em);
                         } // Items.code

                         if (toProperty.equals("inventoryCode")){
                             itemsTo = findBean.inventoryCodeItems(toValue,em);
                         } // Items.inventoryCode

                         if (toProperty.equals("serial")){
                             itemsTo = findBean.serialItems(toValue,em);
                         } // Items.serial

                         if (toProperty.equals("eanCode")){
                             itemsTo = findBean.eanCodeItems(toValue,em);
                         } // Items.eanCode

                         if (toProperty.equals("located")){
                             itemsTo = findBean.locatedItems(toValue,em);
                         } // Items.located

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             itemsTo.setPhysicalAreas(physicalAreasFrom);
                         }

                         em.persist(itemsTo);
                         em.flush();

                     } // to: Items
                 } // from: PhysicalAreas

                 if (from.equals("SitesTypes")){

                     SitesTypes sitesTypesFrom = new SitesTypes();

                     if (fromProperty.equals("name")){
                         sitesTypesFrom = findBean.nameSitesTypes(fromValue,em);
                         f.line(sitesTypesFrom.getName());
                     } // sitesTypes

                     if (to.equals("SitesTypes")){

                         SitesTypes sitesTypesTo = new SitesTypes();

                         if (toProperty.equals("name")){
                             sitesTypesTo = findBean.nameSitesTypes(toValue,em);
                         } // SitesTypes.name

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             sitesTypesTo.setObjPadre(sitesTypesFrom);
                         }

                         em.persist(sitesTypesTo);
                         em.flush();

                     } // to: SitesTypes
                 } // from: SitesTypes

                 if (from.equals("ActivitiesTypes")){

                     ActivitiesTypes activitiesTypesFrom = new ActivitiesTypes();

                     if (fromProperty.equals("name")){
                         activitiesTypesFrom = findBean.nameActivitiesTypes(fromValue,em);
                         f.line(activitiesTypesFrom.getName());
                     } // activitiesTypes

                     if (to.equals("Activities")){

                         Activities activitiesTo = new Activities();

                         if (toProperty.equals("name")){
                             activitiesTo = findBean.nameActivities(toValue,em);
                         } // Activities.name

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             activitiesTo.setActivitiesTypes(activitiesTypesFrom);
                         }

                         em.persist(activitiesTo);
                         em.flush();

                     } // to: Activities
                 } // from: ActivitiesTypes

                 if (from.equals("Activities")){

                     Activities activitiesFrom = new Activities();

                     if (fromProperty.equals("name")){
                         activitiesFrom = findBean.nameActivities(fromValue,em);
                         f.line(activitiesFrom.getName());
                     } // activities

                     if (to.equals("Activities")){

                         Activities activitiesTo = new Activities();

                         if (toProperty.equals("name")){
                             activitiesTo = findBean.nameActivities(toValue,em);
                         } // Activities.name

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             activitiesTo.setObjPadre(activitiesFrom);
                         }

                         em.persist(activitiesTo);
                         em.flush();

                     } // to: Activities
                 } // from: Activities

                 if (from.equals("Activities")){

                     Activities activitiesFrom = new Activities();

                     if (fromProperty.equals("name")){
                         activitiesFrom = findBean.nameActivities(fromValue,em);
                         f.line(activitiesFrom.getName());
                     } // activities

                     if (to.equals("Tasks")){

                         Tasks tasksTo = new Tasks();

                         if (toProperty.equals("name")){
                             tasksTo = findBean.nameTasks(toValue,em);
                         } // Tasks.name

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             tasksTo.setActivities(activitiesFrom);
                         }

                         em.persist(tasksTo);
                         em.flush();

                     } // to: Tasks
                 } // from: Activities

                 if (from.equals("Tasks")){

                     Tasks tasksFrom = new Tasks();

                     if (fromProperty.equals("name")){
                         tasksFrom = findBean.nameTasks(fromValue,em);
                         f.line(tasksFrom.getName());
                     } // tasks

                     if (to.equals("Diaries")){

                         Diaries diariesTo = new Diaries();

                         if (toProperty.equals("name")){
                             diariesTo = findBean.nameDiaries(toValue,em);
                         } // Diaries.name

                         if (toProperty.equals("description")){
                             diariesTo = findBean.descriptionDiaries(toValue,em);
                         } // Diaries.description

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             diariesTo.setTasks(tasksFrom);
                         }

                         em.persist(diariesTo);
                         em.flush();

                     } // to: Diaries
                 } // from: Tasks

                 if (from.equals("Priorities")){

                     Priorities prioritiesFrom = new Priorities();

                     if (fromProperty.equals("name")){
                         prioritiesFrom = findBean.namePriorities(fromValue,em);
                         f.line(prioritiesFrom.getName());
                     } // priorities

                     if (to.equals("Tasks")){

                         Tasks tasksTo = new Tasks();

                         if (toProperty.equals("name")){
                             tasksTo = findBean.nameTasks(toValue,em);
                         } // Tasks.name

                         if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                             tasksTo.setPriorities(prioritiesFrom);
                         }

                         em.persist(tasksTo);
                         em.flush();

                     } // to: Tasks
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

