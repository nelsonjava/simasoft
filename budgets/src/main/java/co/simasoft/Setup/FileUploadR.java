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
Apus::Apus Uno a Muchos Bidirecccional No.5 ConstructionActivities 
ConstructionActivities::ConstructionActivities Uno a Muchos Bidirecccional No.5 WorkActivities 
ConstructionChapters::ConstructionChapters Uno a Muchos Bidirecccional No.5 ConstructionActivities 
TypesMeasurementUnits::TypesMeasurementUnits Uno a Muchos Bidirecccional No.5 MeasurementUnits 
MeasurementUnits::MeasurementUnits Uno a Muchos Bidirecccional No.5 Apus 
Years::Years Uno a Muchos Bidirecccional No.5 WorksConstruction 
WorksConstruction::WorksConstruction Uno a Muchos Bidirecccional No.5 Budgets 
WorksConstruction::WorksConstruction Uno a Muchos Bidirecccional No.5 WorksConstruction 
TypesWorksConstruction::TypesWorksConstruction Uno a Muchos Bidirecccional No.5 WorksConstruction 
WorkActivities::WorkActivities Uno a Muchos Bidirecccional No.5 Budgets 
TypesConstructionMaterials::TypesConstructionMaterials Uno a Muchos Bidirecccional No.5 ConstructionMaterials 
TypesConstructionTransports::TypesConstructionTransports Uno a Muchos Bidirecccional No.5 ConstructionTransports 
TypesConstructionWorkforce::TypesConstructionWorkforce Uno a Muchos Bidirecccional No.5 ConstructionWorkforce 
TypesConstructionEquipments::TypesConstructionEquipments Uno a Muchos Bidirecccional No.5 ConstructionEquipments 
*/

                 if (from.equals("Apus") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("ConstructionActivities") &&
                     name.equals("")){

                     Apus apusFrom = new Apus();

                     ConstructionActivities constructionActivitiesTo = new ConstructionActivities();

                     if (fromProperty.equals("code")){
                         apusFrom = findBean.codeApus(fromValue,em);
                         f.line("from:"+fromValue+":"+apusFrom.getCode());
                     } // apus

                     if (fromProperty.equals("name")){
                         apusFrom = findBean.nameApus(fromValue,em);
                         f.line("from:"+fromValue+":"+apusFrom.getName());
                     } // apus

                     if (toProperty.equals("code")){
                         constructionActivitiesTo = findBean.codeConstructionActivities(toValue,em);
                         f.line("to:"+toValue+":"+constructionActivitiesTo.getCode());
                     } // ConstructionActivities.code

                     if (toProperty.equals("name")){
                         constructionActivitiesTo = findBean.nameConstructionActivities(toValue,em);
                         f.line("to:"+toValue+":"+constructionActivitiesTo.getName());
                     } // ConstructionActivities.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         constructionActivitiesTo.setApus(apusFrom);
                     }

                     if (!isValidate) {
                         em.merge(constructionActivitiesTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "apus.txt");

                     }

                 } // from: Apus

                 if (from.equals("ConstructionActivities") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("WorkActivities") &&
                     name.equals("")){

                     ConstructionActivities constructionActivitiesFrom = new ConstructionActivities();

                     WorkActivities workActivitiesTo = new WorkActivities();

                     if (fromProperty.equals("code")){
                         constructionActivitiesFrom = findBean.codeConstructionActivities(fromValue,em);
                         f.line("from:"+fromValue+":"+constructionActivitiesFrom.getCode());
                     } // constructionActivities

                     if (fromProperty.equals("name")){
                         constructionActivitiesFrom = findBean.nameConstructionActivities(fromValue,em);
                         f.line("from:"+fromValue+":"+constructionActivitiesFrom.getName());
                     } // constructionActivities

                     if (toProperty.equals("code")){
                         workActivitiesTo = findBean.codeWorkActivities(toValue,em);
                         f.line("to:"+toValue+":"+workActivitiesTo.getCode());
                     } // WorkActivities.code

                     if (toProperty.equals("name")){
                         workActivitiesTo = findBean.nameWorkActivities(toValue,em);
                         f.line("to:"+toValue+":"+workActivitiesTo.getName());
                     } // WorkActivities.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         workActivitiesTo.setConstructionActivities(constructionActivitiesFrom);
                     }

                     if (!isValidate) {
                         em.merge(workActivitiesTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "constructionActivities.txt");

                     }

                 } // from: ConstructionActivities

                 if (from.equals("ConstructionChapters") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("ConstructionActivities") &&
                     name.equals("")){

                     ConstructionChapters constructionChaptersFrom = new ConstructionChapters();

                     ConstructionActivities constructionActivitiesTo = new ConstructionActivities();

                     if (fromProperty.equals("code")){
                         constructionChaptersFrom = findBean.codeConstructionChapters(fromValue,em);
                         f.line("from:"+fromValue+":"+constructionChaptersFrom.getCode());
                     } // constructionChapters

                     if (fromProperty.equals("name")){
                         constructionChaptersFrom = findBean.nameConstructionChapters(fromValue,em);
                         f.line("from:"+fromValue+":"+constructionChaptersFrom.getName());
                     } // constructionChapters

                     if (toProperty.equals("code")){
                         constructionActivitiesTo = findBean.codeConstructionActivities(toValue,em);
                         f.line("to:"+toValue+":"+constructionActivitiesTo.getCode());
                     } // ConstructionActivities.code

                     if (toProperty.equals("name")){
                         constructionActivitiesTo = findBean.nameConstructionActivities(toValue,em);
                         f.line("to:"+toValue+":"+constructionActivitiesTo.getName());
                     } // ConstructionActivities.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         constructionActivitiesTo.setConstructionChapters(constructionChaptersFrom);
                     }

                     if (!isValidate) {
                         em.merge(constructionActivitiesTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "constructionChapters.txt");

                     }

                 } // from: ConstructionChapters

                 if (from.equals("TypesMeasurementUnits") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("MeasurementUnits") &&
                     name.equals("")){

                     TypesMeasurementUnits typesMeasurementUnitsFrom = new TypesMeasurementUnits();

                     MeasurementUnits measurementUnitsTo = new MeasurementUnits();

                     if (fromProperty.equals("code")){
                         typesMeasurementUnitsFrom = findBean.codeTypesMeasurementUnits(fromValue,em);
                         f.line("from:"+fromValue+":"+typesMeasurementUnitsFrom.getCode());
                     } // typesMeasurementUnits

                     if (fromProperty.equals("name")){
                         typesMeasurementUnitsFrom = findBean.nameTypesMeasurementUnits(fromValue,em);
                         f.line("from:"+fromValue+":"+typesMeasurementUnitsFrom.getName());
                     } // typesMeasurementUnits

                     if (toProperty.equals("code")){
                         measurementUnitsTo = findBean.codeMeasurementUnits(toValue,em);
                         f.line("to:"+toValue+":"+measurementUnitsTo.getCode());
                     } // MeasurementUnits.code

                     if (toProperty.equals("name")){
                         measurementUnitsTo = findBean.nameMeasurementUnits(toValue,em);
                         f.line("to:"+toValue+":"+measurementUnitsTo.getName());
                     } // MeasurementUnits.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         measurementUnitsTo.setTypesMeasurementUnits(typesMeasurementUnitsFrom);
                     }

                     if (!isValidate) {
                         em.merge(measurementUnitsTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "typesMeasurementUnits.txt");

                     }

                 } // from: TypesMeasurementUnits

                 if (from.equals("MeasurementUnits") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("Apus") &&
                     name.equals("")){

                     MeasurementUnits measurementUnitsFrom = new MeasurementUnits();

                     Apus apusTo = new Apus();

                     if (fromProperty.equals("code")){
                         measurementUnitsFrom = findBean.codeMeasurementUnits(fromValue,em);
                         f.line("from:"+fromValue+":"+measurementUnitsFrom.getCode());
                     } // measurementUnits

                     if (fromProperty.equals("name")){
                         measurementUnitsFrom = findBean.nameMeasurementUnits(fromValue,em);
                         f.line("from:"+fromValue+":"+measurementUnitsFrom.getName());
                     } // measurementUnits

                     if (toProperty.equals("code")){
                         apusTo = findBean.codeApus(toValue,em);
                         f.line("to:"+toValue+":"+apusTo.getCode());
                     } // Apus.code

                     if (toProperty.equals("name")){
                         apusTo = findBean.nameApus(toValue,em);
                         f.line("to:"+toValue+":"+apusTo.getName());
                     } // Apus.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         apusTo.setMeasurementUnits(measurementUnitsFrom);
                     }

                     if (!isValidate) {
                         em.merge(apusTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "measurementUnits.txt");

                     }

                 } // from: MeasurementUnits

                 if (from.equals("Years") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("WorksConstruction") &&
                     name.equals("")){

                     Years yearsFrom = new Years();

                     WorksConstruction worksConstructionTo = new WorksConstruction();

                     if (fromProperty.equals("year")){
                         yearsFrom = findBean.yearYears(fromValue,em);
                         f.line("from:"+fromValue+":"+yearsFrom.getYear());
                     } // years

                     if (toProperty.equals("code")){
                         worksConstructionTo = findBean.codeWorksConstruction(toValue,em);
                         f.line("to:"+toValue+":"+worksConstructionTo.getCode());
                     } // WorksConstruction.code

                     if (toProperty.equals("name")){
                         worksConstructionTo = findBean.nameWorksConstruction(toValue,em);
                         f.line("to:"+toValue+":"+worksConstructionTo.getName());
                     } // WorksConstruction.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         worksConstructionTo.setYears(yearsFrom);
                     }

                     if (!isValidate) {
                         em.merge(worksConstructionTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "years.txt");

                     }

                 } // from: Years

                 if (from.equals("WorksConstruction") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("Budgets") &&
                     name.equals("")){

                     WorksConstruction worksConstructionFrom = new WorksConstruction();

                     Budgets budgetsTo = new Budgets();

                     if (fromProperty.equals("code")){
                         worksConstructionFrom = findBean.codeWorksConstruction(fromValue,em);
                         f.line("from:"+fromValue+":"+worksConstructionFrom.getCode());
                     } // worksConstruction

                     if (fromProperty.equals("name")){
                         worksConstructionFrom = findBean.nameWorksConstruction(fromValue,em);
                         f.line("from:"+fromValue+":"+worksConstructionFrom.getName());
                     } // worksConstruction

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         budgetsTo.setWorksConstruction(worksConstructionFrom);
                     }

                     if (!isValidate) {
                         em.merge(budgetsTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "worksConstruction.txt");

                     }

                 } // from: WorksConstruction

                 if (from.equals("WorksConstruction") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("WorksConstruction") &&
                     name.equals("")){

                     WorksConstruction worksConstructionFrom = new WorksConstruction();

                     WorksConstruction worksConstructionTo = new WorksConstruction();

                     if (fromProperty.equals("code")){
                         worksConstructionFrom = findBean.codeWorksConstruction(fromValue,em);
                         f.line("from:"+fromValue+":"+worksConstructionFrom.getCode());
                     } // worksConstruction

                     if (fromProperty.equals("name")){
                         worksConstructionFrom = findBean.nameWorksConstruction(fromValue,em);
                         f.line("from:"+fromValue+":"+worksConstructionFrom.getName());
                     } // worksConstruction

                     if (toProperty.equals("code")){
                         worksConstructionTo = findBean.codeWorksConstruction(toValue,em);
                         f.line("to:"+toValue+":"+worksConstructionTo.getCode());
                     } // WorksConstruction.code

                     if (toProperty.equals("name")){
                         worksConstructionTo = findBean.nameWorksConstruction(toValue,em);
                         f.line("to:"+toValue+":"+worksConstructionTo.getName());
                     } // WorksConstruction.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         worksConstructionTo.setObjPadre(worksConstructionFrom);
                     }

                     if (!isValidate) {
                         em.merge(worksConstructionTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "worksConstruction.txt");

                     }

                 } // from: WorksConstruction

                 if (from.equals("TypesWorksConstruction") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("WorksConstruction") &&
                     name.equals("")){

                     TypesWorksConstruction typesWorksConstructionFrom = new TypesWorksConstruction();

                     WorksConstruction worksConstructionTo = new WorksConstruction();

                     if (fromProperty.equals("code")){
                         typesWorksConstructionFrom = findBean.codeTypesWorksConstruction(fromValue,em);
                         f.line("from:"+fromValue+":"+typesWorksConstructionFrom.getCode());
                     } // typesWorksConstruction

                     if (fromProperty.equals("name")){
                         typesWorksConstructionFrom = findBean.nameTypesWorksConstruction(fromValue,em);
                         f.line("from:"+fromValue+":"+typesWorksConstructionFrom.getName());
                     } // typesWorksConstruction

                     if (toProperty.equals("code")){
                         worksConstructionTo = findBean.codeWorksConstruction(toValue,em);
                         f.line("to:"+toValue+":"+worksConstructionTo.getCode());
                     } // WorksConstruction.code

                     if (toProperty.equals("name")){
                         worksConstructionTo = findBean.nameWorksConstruction(toValue,em);
                         f.line("to:"+toValue+":"+worksConstructionTo.getName());
                     } // WorksConstruction.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         worksConstructionTo.setTypesWorksConstruction(typesWorksConstructionFrom);
                     }

                     if (!isValidate) {
                         em.merge(worksConstructionTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "typesWorksConstruction.txt");

                     }

                 } // from: TypesWorksConstruction

                 if (from.equals("WorkActivities") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("Budgets") &&
                     name.equals("")){

                     WorkActivities workActivitiesFrom = new WorkActivities();

                     Budgets budgetsTo = new Budgets();

                     if (fromProperty.equals("code")){
                         workActivitiesFrom = findBean.codeWorkActivities(fromValue,em);
                         f.line("from:"+fromValue+":"+workActivitiesFrom.getCode());
                     } // workActivities

                     if (fromProperty.equals("name")){
                         workActivitiesFrom = findBean.nameWorkActivities(fromValue,em);
                         f.line("from:"+fromValue+":"+workActivitiesFrom.getName());
                     } // workActivities

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         budgetsTo.setWorkActivities(workActivitiesFrom);
                     }

                     if (!isValidate) {
                         em.merge(budgetsTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "workActivities.txt");

                     }

                 } // from: WorkActivities

                 if (from.equals("TypesConstructionMaterials") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("ConstructionMaterials") &&
                     name.equals("")){

                     TypesConstructionMaterials typesConstructionMaterialsFrom = new TypesConstructionMaterials();

                     ConstructionMaterials constructionMaterialsTo = new ConstructionMaterials();

                     if (fromProperty.equals("code")){
                         typesConstructionMaterialsFrom = findBean.codeTypesConstructionMaterials(fromValue,em);
                         f.line("from:"+fromValue+":"+typesConstructionMaterialsFrom.getCode());
                     } // typesConstructionMaterials

                     if (fromProperty.equals("name")){
                         typesConstructionMaterialsFrom = findBean.nameTypesConstructionMaterials(fromValue,em);
                         f.line("from:"+fromValue+":"+typesConstructionMaterialsFrom.getName());
                     } // typesConstructionMaterials

                     if (toProperty.equals("code")){
                         constructionMaterialsTo = findBean.codeConstructionMaterials(toValue,em);
                         f.line("to:"+toValue+":"+constructionMaterialsTo.getCode());
                     } // ConstructionMaterials.code

                     if (toProperty.equals("name")){
                         constructionMaterialsTo = findBean.nameConstructionMaterials(toValue,em);
                         f.line("to:"+toValue+":"+constructionMaterialsTo.getName());
                     } // ConstructionMaterials.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         constructionMaterialsTo.setTypesConstructionMaterials(typesConstructionMaterialsFrom);
                     }

                     if (!isValidate) {
                         em.merge(constructionMaterialsTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "typesConstructionMaterials.txt");

                     }

                 } // from: TypesConstructionMaterials

                 if (from.equals("TypesConstructionTransports") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("ConstructionTransports") &&
                     name.equals("")){

                     TypesConstructionTransports typesConstructionTransportsFrom = new TypesConstructionTransports();

                     ConstructionTransports constructionTransportsTo = new ConstructionTransports();

                     if (fromProperty.equals("code")){
                         typesConstructionTransportsFrom = findBean.codeTypesConstructionTransports(fromValue,em);
                         f.line("from:"+fromValue+":"+typesConstructionTransportsFrom.getCode());
                     } // typesConstructionTransports

                     if (fromProperty.equals("name")){
                         typesConstructionTransportsFrom = findBean.nameTypesConstructionTransports(fromValue,em);
                         f.line("from:"+fromValue+":"+typesConstructionTransportsFrom.getName());
                     } // typesConstructionTransports

                     if (toProperty.equals("code")){
                         constructionTransportsTo = findBean.codeConstructionTransports(toValue,em);
                         f.line("to:"+toValue+":"+constructionTransportsTo.getCode());
                     } // ConstructionTransports.code

                     if (toProperty.equals("name")){
                         constructionTransportsTo = findBean.nameConstructionTransports(toValue,em);
                         f.line("to:"+toValue+":"+constructionTransportsTo.getName());
                     } // ConstructionTransports.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         constructionTransportsTo.setTypesConstructionTransports(typesConstructionTransportsFrom);
                     }

                     if (!isValidate) {
                         em.merge(constructionTransportsTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "typesConstructionTransports.txt");

                     }

                 } // from: TypesConstructionTransports

                 if (from.equals("TypesConstructionWorkforce") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("ConstructionWorkforce") &&
                     name.equals("")){

                     TypesConstructionWorkforce typesConstructionWorkforceFrom = new TypesConstructionWorkforce();

                     ConstructionWorkforce constructionWorkforceTo = new ConstructionWorkforce();

                     if (fromProperty.equals("code")){
                         typesConstructionWorkforceFrom = findBean.codeTypesConstructionWorkforce(fromValue,em);
                         f.line("from:"+fromValue+":"+typesConstructionWorkforceFrom.getCode());
                     } // typesConstructionWorkforce

                     if (fromProperty.equals("name")){
                         typesConstructionWorkforceFrom = findBean.nameTypesConstructionWorkforce(fromValue,em);
                         f.line("from:"+fromValue+":"+typesConstructionWorkforceFrom.getName());
                     } // typesConstructionWorkforce

                     if (toProperty.equals("code")){
                         constructionWorkforceTo = findBean.codeConstructionWorkforce(toValue,em);
                         f.line("to:"+toValue+":"+constructionWorkforceTo.getCode());
                     } // ConstructionWorkforce.code

                     if (toProperty.equals("name")){
                         constructionWorkforceTo = findBean.nameConstructionWorkforce(toValue,em);
                         f.line("to:"+toValue+":"+constructionWorkforceTo.getName());
                     } // ConstructionWorkforce.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         constructionWorkforceTo.setTypesConstructionWorkforce(typesConstructionWorkforceFrom);
                     }

                     if (!isValidate) {
                         em.merge(constructionWorkforceTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "typesConstructionWorkforce.txt");

                     }

                 } // from: TypesConstructionWorkforce

                 if (from.equals("TypesConstructionEquipments") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("ConstructionEquipments") &&
                     name.equals("")){

                     TypesConstructionEquipments typesConstructionEquipmentsFrom = new TypesConstructionEquipments();

                     ConstructionEquipments constructionEquipmentsTo = new ConstructionEquipments();

                     if (fromProperty.equals("code")){
                         typesConstructionEquipmentsFrom = findBean.codeTypesConstructionEquipments(fromValue,em);
                         f.line("from:"+fromValue+":"+typesConstructionEquipmentsFrom.getCode());
                     } // typesConstructionEquipments

                     if (fromProperty.equals("name")){
                         typesConstructionEquipmentsFrom = findBean.nameTypesConstructionEquipments(fromValue,em);
                         f.line("from:"+fromValue+":"+typesConstructionEquipmentsFrom.getName());
                     } // typesConstructionEquipments

                     if (toProperty.equals("code")){
                         constructionEquipmentsTo = findBean.codeConstructionEquipments(toValue,em);
                         f.line("to:"+toValue+":"+constructionEquipmentsTo.getCode());
                     } // ConstructionEquipments.code

                     if (toProperty.equals("name")){
                         constructionEquipmentsTo = findBean.nameConstructionEquipments(toValue,em);
                         f.line("to:"+toValue+":"+constructionEquipmentsTo.getName());
                     } // ConstructionEquipments.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         constructionEquipmentsTo.setTypesConstructionEquipments(typesConstructionEquipmentsFrom);
                     }

                     if (!isValidate) {
                         em.merge(constructionEquipmentsTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "typesConstructionEquipments.txt");

                     }

                 } // from: TypesConstructionEquipments

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

