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

    @PersistenceContext(unitName = "budgetsPU-JTA")
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
              relationshipsR5(filePath,em,isValidate,f);
           }

           if(file.getFileName().indexOf("R7") > 0){
              relationshipsR7(filePath,em,isValidate,f);
           }

        } // if

    } // data()

    public void relationshipsR5(String filePath,EntityManager em,Boolean isValidate,FileTxt f) {

        BufferedReader br = null;

        Integer i = 0;
        String line = "";
        String cvsSplitBy = null;
        String[] fields = new String[100];
        String[] data;

    try {

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
                    fields = data;
                    break;
               default:
                    relationshipsR5Data(fields,data,em,isValidate,f);
                    break;
           }

        }

        if (isValidate) {
            f.saveFile("\\docs", "R5.txt");

        }
        else{
            f.saveFile("\\docs", "VR5.txt");

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
            } // constructionActivities

            if (toProperty.equals("name")){
                constructionActivitiesTo = findBean.nameConstructionActivities(toValue,em);
                f.line("to:"+toValue+":"+constructionActivitiesTo.getName());
            } // constructionActivities

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                constructionActivitiesTo.setApus(apusFrom);
            }

            if (!isValidate) {
                em.merge(constructionActivitiesTo);
                em.flush();
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
            } // workActivities

            if (toProperty.equals("name")){
                workActivitiesTo = findBean.nameWorkActivities(toValue,em);
                f.line("to:"+toValue+":"+workActivitiesTo.getName());
            } // workActivities

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                workActivitiesTo.setConstructionActivities(constructionActivitiesFrom);
            }

            if (!isValidate) {
                em.merge(workActivitiesTo);
                em.flush();
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
            } // constructionActivities

            if (toProperty.equals("name")){
                constructionActivitiesTo = findBean.nameConstructionActivities(toValue,em);
                f.line("to:"+toValue+":"+constructionActivitiesTo.getName());
            } // constructionActivities

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                constructionActivitiesTo.setConstructionChapters(constructionChaptersFrom);
            }

            if (!isValidate) {
                em.merge(constructionActivitiesTo);
                em.flush();
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
            } // measurementUnits

            if (toProperty.equals("name")){
                measurementUnitsTo = findBean.nameMeasurementUnits(toValue,em);
                f.line("to:"+toValue+":"+measurementUnitsTo.getName());
            } // measurementUnits

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                measurementUnitsTo.setTypesMeasurementUnits(typesMeasurementUnitsFrom);
            }

            if (!isValidate) {
                em.merge(measurementUnitsTo);
                em.flush();
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
            } // apus

            if (toProperty.equals("name")){
                apusTo = findBean.nameApus(toValue,em);
                f.line("to:"+toValue+":"+apusTo.getName());
            } // apus

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                apusTo.setMeasurementUnits(measurementUnitsFrom);
            }

            if (!isValidate) {
                em.merge(apusTo);
                em.flush();
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
            } // worksConstruction

            if (toProperty.equals("name")){
                worksConstructionTo = findBean.nameWorksConstruction(toValue,em);
                f.line("to:"+toValue+":"+worksConstructionTo.getName());
            } // worksConstruction

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                worksConstructionTo.setYears(yearsFrom);
            }

            if (!isValidate) {
                em.merge(worksConstructionTo);
                em.flush();
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
            } // worksConstruction

            if (toProperty.equals("name")){
                worksConstructionTo = findBean.nameWorksConstruction(toValue,em);
                f.line("to:"+toValue+":"+worksConstructionTo.getName());
            } // worksConstruction

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                worksConstructionTo.setObjPadre(worksConstructionFrom);
            }

            if (!isValidate) {
                em.merge(worksConstructionTo);
                em.flush();
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
            } // worksConstruction

            if (toProperty.equals("name")){
                worksConstructionTo = findBean.nameWorksConstruction(toValue,em);
                f.line("to:"+toValue+":"+worksConstructionTo.getName());
            } // worksConstruction

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                worksConstructionTo.setTypesWorksConstruction(typesWorksConstructionFrom);
            }

            if (!isValidate) {
                em.merge(worksConstructionTo);
                em.flush();
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
            } // constructionMaterials

            if (toProperty.equals("name")){
                constructionMaterialsTo = findBean.nameConstructionMaterials(toValue,em);
                f.line("to:"+toValue+":"+constructionMaterialsTo.getName());
            } // constructionMaterials

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                constructionMaterialsTo.setTypesConstructionMaterials(typesConstructionMaterialsFrom);
            }

            if (!isValidate) {
                em.merge(constructionMaterialsTo);
                em.flush();
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
            } // constructionTransports

            if (toProperty.equals("name")){
                constructionTransportsTo = findBean.nameConstructionTransports(toValue,em);
                f.line("to:"+toValue+":"+constructionTransportsTo.getName());
            } // constructionTransports

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                constructionTransportsTo.setTypesConstructionTransports(typesConstructionTransportsFrom);
            }

            if (!isValidate) {
                em.merge(constructionTransportsTo);
                em.flush();
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
            } // constructionWorkforce

            if (toProperty.equals("name")){
                constructionWorkforceTo = findBean.nameConstructionWorkforce(toValue,em);
                f.line("to:"+toValue+":"+constructionWorkforceTo.getName());
            } // constructionWorkforce

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                constructionWorkforceTo.setTypesConstructionWorkforce(typesConstructionWorkforceFrom);
            }

            if (!isValidate) {
                em.merge(constructionWorkforceTo);
                em.flush();
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
            } // constructionEquipments

            if (toProperty.equals("name")){
                constructionEquipmentsTo = findBean.nameConstructionEquipments(toValue,em);
                f.line("to:"+toValue+":"+constructionEquipmentsTo.getName());
            } // constructionEquipments

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                constructionEquipmentsTo.setTypesConstructionEquipments(typesConstructionEquipmentsFrom);
            }

            if (!isValidate) {
                em.merge(constructionEquipmentsTo);
                em.flush();
            }

        } // from: TypesConstructionEquipments

    } // relationshipsR5Data

    public void relationshipsR7(String filePath,EntityManager em,Boolean isValidate,FileTxt f) {

        BufferedReader br = null;

        Integer i = 0;
        Integer j = 0;
        String line = "";
        String cvsSplitBy = null;
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

        Apus apus = new Apus();
        ConstructionMaterials constructionMaterials = new ConstructionMaterials();
        ConstructionWorkforce constructionWorkforce = new ConstructionWorkforce();
        ConstructionEquipments constructionEquipments = new ConstructionEquipments();
        ConstructionTransports constructionTransports = new ConstructionTransports();
        TypesWorksConstruction typesWorksConstruction = new TypesWorksConstruction();
        ConstructionActivities constructionActivities = new ConstructionActivities();

        Set<ConstructionMaterials> constructionMaterialss = new HashSet<ConstructionMaterials>();
        Set<ConstructionWorkforce> constructionWorkforces = new HashSet<ConstructionWorkforce>();
        Set<ConstructionEquipments> constructionEquipmentss = new HashSet<ConstructionEquipments>();
        Set<ConstructionTransports> constructionTransportss = new HashSet<ConstructionTransports>();
        Set<ConstructionActivities> constructionActivitiess = new HashSet<ConstructionActivities>();

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

           f.line(Integer.toString(i)+"=From:"+from+"\n"+
                                      " FromProperty:"+fromProperty+"\n"+
                                      " FromValue:"+fromValue+"\n"+
                                      " To:"+to+"\n"+
                                      " ToProperty:"+toProperty+"\n"+
                                      " ToValue:"+toValue+"\n"+
                                      " Name:"+name+"\n"+
                                      " Cardinalities:"+cardinalities);

           if(cardinalities.equals("Cardinalities")){
              continue; // Descarta el segundo registro
           }

           if(i==3){
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

           if (from.equals("Apus") &&
               cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
               to.equals("ConstructionMaterials") &&
               Utils.isEmpty(name)){

               if (isCambio){

                  f.line("cambio:"+ant);

                  if (constructionMaterialss.size() > 0){

                      if (fromProperty.equals("code")){
                          apus = findBean.codeApus(ant,em);
                          apus.setConstructionMaterials(constructionMaterialss);
                          f.line("No."+Integer.toString(i)+" id="+String.valueOf(apus.getId())+" code="+apus.getCode());

                      } // apus

                      if (fromProperty.equals("name")){
                          apus = findBean.nameApus(ant,em);
                          apus.setConstructionMaterials(constructionMaterialss);
                          f.line("No."+Integer.toString(i)+" id="+String.valueOf(apus.getId())+" name="+apus.getName());

                      } // apus

                      if (!isValidate) {

                          em.merge(apus);
                          em.flush();

                      }

                      if (fromProperty.equals("code")){
                          j = 0;
                          for(ConstructionMaterials constructionMaterialsx : constructionMaterialss){
                              f.line("id="+String.valueOf(constructionMaterialsx.getId())+" code="+constructionMaterialsx.getCode());
                          }

                          f.line("===========");
                      } // apus

                      if (fromProperty.equals("name")){
                          j = 0;
                          for(ConstructionMaterials constructionMaterialsx : constructionMaterialss){
                              f.line("id="+String.valueOf(constructionMaterialsx.getId())+" name="+constructionMaterialsx.getName());
                          }

                          f.line("===========");
                      } // apus

                  } // size()

                  constructionMaterialss = new HashSet<ConstructionMaterials>();
                  constructionMaterials = new ConstructionMaterials();

               } // isCambio 

              if (toProperty.equals("code")){
                  constructionMaterials = findBean.codeConstructionMaterials(toValue,em);
              } // constructionMaterials

              if (toProperty.equals("name")){
                  constructionMaterials = findBean.nameConstructionMaterials(toValue,em);
              } // constructionMaterials

              constructionMaterialss.add(constructionMaterials);

           } // from: Apus

           if (from.equals("Apus") &&
               cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
               to.equals("ConstructionWorkforce") &&
               Utils.isEmpty(name)){

               if (isCambio){

                  f.line("cambio:"+ant);

                  if (constructionWorkforces.size() > 0){

                      if (fromProperty.equals("code")){
                          apus = findBean.codeApus(ant,em);
                          apus.setConstructionWorkforce(constructionWorkforces);
                          f.line("No."+Integer.toString(i)+" id="+String.valueOf(apus.getId())+" code="+apus.getCode());

                      } // apus

                      if (fromProperty.equals("name")){
                          apus = findBean.nameApus(ant,em);
                          apus.setConstructionWorkforce(constructionWorkforces);
                          f.line("No."+Integer.toString(i)+" id="+String.valueOf(apus.getId())+" name="+apus.getName());

                      } // apus

                      if (!isValidate) {

                          em.merge(apus);
                          em.flush();

                      }

                      if (fromProperty.equals("code")){
                          j = 0;
                          for(ConstructionWorkforce constructionWorkforcex : constructionWorkforces){
                              f.line("id="+String.valueOf(constructionWorkforcex.getId())+" code="+constructionWorkforcex.getCode());
                          }

                          f.line("===========");
                      } // apus

                      if (fromProperty.equals("name")){
                          j = 0;
                          for(ConstructionWorkforce constructionWorkforcex : constructionWorkforces){
                              f.line("id="+String.valueOf(constructionWorkforcex.getId())+" name="+constructionWorkforcex.getName());
                          }

                          f.line("===========");
                      } // apus

                  } // size()

                  constructionWorkforces = new HashSet<ConstructionWorkforce>();
                  constructionWorkforce = new ConstructionWorkforce();

               } // isCambio 

              if (toProperty.equals("code")){
                  constructionWorkforce = findBean.codeConstructionWorkforce(toValue,em);
              } // constructionWorkforce

              if (toProperty.equals("name")){
                  constructionWorkforce = findBean.nameConstructionWorkforce(toValue,em);
              } // constructionWorkforce

              constructionWorkforces.add(constructionWorkforce);

           } // from: Apus

           if (from.equals("Apus") &&
               cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
               to.equals("ConstructionEquipments") &&
               Utils.isEmpty(name)){

               if (isCambio){

                  f.line("cambio:"+ant);

                  if (constructionEquipmentss.size() > 0){

                      if (fromProperty.equals("code")){
                          apus = findBean.codeApus(ant,em);
                          apus.setConstructionEquipments(constructionEquipmentss);
                          f.line("No."+Integer.toString(i)+" id="+String.valueOf(apus.getId())+" code="+apus.getCode());

                      } // apus

                      if (fromProperty.equals("name")){
                          apus = findBean.nameApus(ant,em);
                          apus.setConstructionEquipments(constructionEquipmentss);
                          f.line("No."+Integer.toString(i)+" id="+String.valueOf(apus.getId())+" name="+apus.getName());

                      } // apus

                      if (!isValidate) {

                          em.merge(apus);
                          em.flush();

                      }

                      if (fromProperty.equals("code")){
                          j = 0;
                          for(ConstructionEquipments constructionEquipmentsx : constructionEquipmentss){
                              f.line("id="+String.valueOf(constructionEquipmentsx.getId())+" code="+constructionEquipmentsx.getCode());
                          }

                          f.line("===========");
                      } // apus

                      if (fromProperty.equals("name")){
                          j = 0;
                          for(ConstructionEquipments constructionEquipmentsx : constructionEquipmentss){
                              f.line("id="+String.valueOf(constructionEquipmentsx.getId())+" name="+constructionEquipmentsx.getName());
                          }

                          f.line("===========");
                      } // apus

                  } // size()

                  constructionEquipmentss = new HashSet<ConstructionEquipments>();
                  constructionEquipments = new ConstructionEquipments();

               } // isCambio 

              if (toProperty.equals("code")){
                  constructionEquipments = findBean.codeConstructionEquipments(toValue,em);
              } // constructionEquipments

              if (toProperty.equals("name")){
                  constructionEquipments = findBean.nameConstructionEquipments(toValue,em);
              } // constructionEquipments

              constructionEquipmentss.add(constructionEquipments);

           } // from: Apus

           if (from.equals("Apus") &&
               cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
               to.equals("ConstructionTransports") &&
               Utils.isEmpty(name)){

               if (isCambio){

                  f.line("cambio:"+ant);

                  if (constructionTransportss.size() > 0){

                      if (fromProperty.equals("code")){
                          apus = findBean.codeApus(ant,em);
                          apus.setConstructionTransports(constructionTransportss);
                          f.line("No."+Integer.toString(i)+" id="+String.valueOf(apus.getId())+" code="+apus.getCode());

                      } // apus

                      if (fromProperty.equals("name")){
                          apus = findBean.nameApus(ant,em);
                          apus.setConstructionTransports(constructionTransportss);
                          f.line("No."+Integer.toString(i)+" id="+String.valueOf(apus.getId())+" name="+apus.getName());

                      } // apus

                      if (!isValidate) {

                          em.merge(apus);
                          em.flush();

                      }

                      if (fromProperty.equals("code")){
                          j = 0;
                          for(ConstructionTransports constructionTransportsx : constructionTransportss){
                              f.line("id="+String.valueOf(constructionTransportsx.getId())+" code="+constructionTransportsx.getCode());
                          }

                          f.line("===========");
                      } // apus

                      if (fromProperty.equals("name")){
                          j = 0;
                          for(ConstructionTransports constructionTransportsx : constructionTransportss){
                              f.line("id="+String.valueOf(constructionTransportsx.getId())+" name="+constructionTransportsx.getName());
                          }

                          f.line("===========");
                      } // apus

                  } // size()

                  constructionTransportss = new HashSet<ConstructionTransports>();
                  constructionTransports = new ConstructionTransports();

               } // isCambio 

              if (toProperty.equals("code")){
                  constructionTransports = findBean.codeConstructionTransports(toValue,em);
              } // constructionTransports

              if (toProperty.equals("name")){
                  constructionTransports = findBean.nameConstructionTransports(toValue,em);
              } // constructionTransports

              constructionTransportss.add(constructionTransports);

           } // from: Apus

           if (from.equals("TypesWorksConstruction") &&
               cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
               to.equals("ConstructionActivities") &&
               Utils.isEmpty(name)){

               if (isCambio){

                  f.line("cambio:"+ant);

                  if (constructionActivitiess.size() > 0){

                      if (fromProperty.equals("code")){
                          typesWorksConstruction = findBean.codeTypesWorksConstruction(ant,em);
                          typesWorksConstruction.setConstructionActivities(constructionActivitiess);
                          f.line("No."+Integer.toString(i)+" id="+String.valueOf(typesWorksConstruction.getId())+" code="+typesWorksConstruction.getCode());

                      } // typesWorksConstruction

                      if (fromProperty.equals("name")){
                          typesWorksConstruction = findBean.nameTypesWorksConstruction(ant,em);
                          typesWorksConstruction.setConstructionActivities(constructionActivitiess);
                          f.line("No."+Integer.toString(i)+" id="+String.valueOf(typesWorksConstruction.getId())+" name="+typesWorksConstruction.getName());

                      } // typesWorksConstruction

                      if (!isValidate) {

                          em.merge(typesWorksConstruction);
                          em.flush();

                      }

                      if (fromProperty.equals("code")){
                          j = 0;
                          for(ConstructionActivities constructionActivitiesx : constructionActivitiess){
                              f.line("id="+String.valueOf(constructionActivitiesx.getId())+" code="+constructionActivitiesx.getCode());
                          }

                          f.line("===========");
                      } // typesWorksConstruction

                      if (fromProperty.equals("name")){
                          j = 0;
                          for(ConstructionActivities constructionActivitiesx : constructionActivitiess){
                              f.line("id="+String.valueOf(constructionActivitiesx.getId())+" name="+constructionActivitiesx.getName());
                          }

                          f.line("===========");
                      } // typesWorksConstruction

                  } // size()

                  constructionActivitiess = new HashSet<ConstructionActivities>();
                  constructionActivities = new ConstructionActivities();

               } // isCambio 

              if (toProperty.equals("code")){
                  constructionActivities = findBean.codeConstructionActivities(toValue,em);
              } // constructionActivities

              if (toProperty.equals("name")){
                  constructionActivities = findBean.nameConstructionActivities(toValue,em);
              } // constructionActivities

              constructionActivitiess.add(constructionActivities);

           } // from: TypesWorksConstruction

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
