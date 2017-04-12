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

    @PersistenceContext(unitName = "archivalPU-JTA")
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
        String cvsSplitBy = ";";
        String[] fields = new String[100];

    try {

        br = new BufferedReader(new FileReader(filePath));
        while ((line = br.readLine()) != null) {

           // use comma as separator
           String[] data = line.split(cvsSplitBy);

           i++;
           switch (i) {
               case 1:
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
            } // funds

            if (toProperty.equals("code")){
                fundsTo = findBean.codeFunds(toValue,em);
                f.line("to:"+toValue+":"+fundsTo.getCode());
            } // funds

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                fundsTo.setFundsLife(fundsLifeFrom);
            }

            if (!isValidate) {
                em.merge(fundsTo);
                em.flush();
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
            } // sections

            if (toProperty.equals("code")){
                sectionsTo = findBean.codeSections(toValue,em);
                f.line("to:"+toValue+":"+sectionsTo.getCode());
            } // sections

            if (toProperty.equals("dir")){
                sectionsTo = findBean.dirSections(toValue,em);
                f.line("to:"+toValue+":"+sectionsTo.getDir());
            } // sections

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                sectionsTo.setFunds(fundsFrom);
            }

            if (!isValidate) {
                em.merge(sectionsTo);
                em.flush();
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
            } // sections

            if (toProperty.equals("code")){
                sectionsTo = findBean.codeSections(toValue,em);
                f.line("to:"+toValue+":"+sectionsTo.getCode());
            } // sections

            if (toProperty.equals("dir")){
                sectionsTo = findBean.dirSections(toValue,em);
                f.line("to:"+toValue+":"+sectionsTo.getDir());
            } // sections

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                sectionsTo.setSectionsTypes(sectionsTypesFrom);
            }

            if (!isValidate) {
                em.merge(sectionsTo);
                em.flush();
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
            } // activities

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                activitiesTo.setSections(sectionsFrom);
            }

            if (!isValidate) {
                em.merge(activitiesTo);
                em.flush();
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
            } // tasks

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                tasksTo.setSections(sectionsFrom);
            }

            if (!isValidate) {
                em.merge(tasksTo);
                em.flush();
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
            } // sections

            if (toProperty.equals("code")){
                sectionsTo = findBean.codeSections(toValue,em);
                f.line("to:"+toValue+":"+sectionsTo.getCode());
            } // sections

            if (toProperty.equals("dir")){
                sectionsTo = findBean.dirSections(toValue,em);
                f.line("to:"+toValue+":"+sectionsTo.getDir());
            } // sections

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                sectionsTo.setObjPadre(sectionsFrom);
            }

            if (!isValidate) {
                em.merge(sectionsTo);
                em.flush();
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
//                f.line("to:"+toValue+":"+seriesTo.getName());
                f.line("to:"+toValue+":"+toValue);
            } // series

            if (toProperty.equals("code")){
                seriesTo = findBean.codeSeries(toValue,em);
                f.line("to:"+toValue+":"+seriesTo.getCode());
            } // series

            if (toProperty.equals("located")){
                seriesTo = findBean.locatedSeries(toValue,em);
                f.line("to:"+toValue+":"+seriesTo.getLocated());
            } // series

            if (toProperty.equals("procedures")){
                seriesTo = findBean.proceduresSeries(toValue,em);
                f.line("to:"+toValue+":"+seriesTo.getProcedures());
            } // series

            if (toProperty.equals("dir")){
                seriesTo = findBean.dirSeries(toValue,em);
                f.line("to:"+toValue+":"+seriesTo.getDir());
            } // series

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                seriesTo.setSections(sectionsFrom);
            }

            if (!isValidate) {
                em.merge(seriesTo);
                em.flush();
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
            } // tasks

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                tasksTo.setSeries(seriesFrom);
            }

            if (!isValidate) {
                em.merge(tasksTo);
                em.flush();
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
            } // documentalsUnits

            if (toProperty.equals("code")){
                documentalsUnitsTo = findBean.codeDocumentalsUnits(toValue,em);
                f.line("to:"+toValue+":"+documentalsUnitsTo.getCode());
            } // documentalsUnits

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                documentalsUnitsTo.setSeries(seriesFrom);
            }

            if (!isValidate) {
                em.merge(documentalsUnitsTo);
                em.flush();
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
            } // series

            if (toProperty.equals("code")){
                seriesTo = findBean.codeSeries(toValue,em);
                f.line("to:"+toValue+":"+seriesTo.getCode());
            } // series

            if (toProperty.equals("located")){
                seriesTo = findBean.locatedSeries(toValue,em);
                f.line("to:"+toValue+":"+seriesTo.getLocated());
            } // series

            if (toProperty.equals("procedures")){
                seriesTo = findBean.proceduresSeries(toValue,em);
                f.line("to:"+toValue+":"+seriesTo.getProcedures());
            } // series

            if (toProperty.equals("dir")){
                seriesTo = findBean.dirSeries(toValue,em);
                f.line("to:"+toValue+":"+seriesTo.getDir());
            } // series

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                seriesTo.setObjPadre(seriesFrom);
            }

            if (!isValidate) {
                em.merge(seriesTo);
                em.flush();
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
            } // versionsControls

            if (toProperty.equals("code")){
                versionsControlsTo = findBean.codeVersionsControls(toValue,em);
                f.line("to:"+toValue+":"+versionsControlsTo.getCode());
            } // versionsControls

            if (toProperty.equals("version")){
                versionsControlsTo = findBean.versionVersionsControls(toValue,em);
                f.line("to:"+toValue+":"+versionsControlsTo.getVersion());
            } // versionsControls

            if (toProperty.equals("request")){
                versionsControlsTo = findBean.requestVersionsControls(toValue,em);
                f.line("to:"+toValue+":"+versionsControlsTo.getRequest());
            } // versionsControls

            if (toProperty.equals("responsible")){
                versionsControlsTo = findBean.responsibleVersionsControls(toValue,em);
                f.line("to:"+toValue+":"+versionsControlsTo.getResponsible());
            } // versionsControls

            if (toProperty.equals("description")){
                versionsControlsTo = findBean.descriptionVersionsControls(toValue,em);
                f.line("to:"+toValue+":"+versionsControlsTo.getDescription());
            } // versionsControls

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                versionsControlsTo.setSeries(seriesFrom);
            }

            if (!isValidate) {
                em.merge(versionsControlsTo);
                em.flush();
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
            } // trdSeries

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                trdSeriesTo.setSeries(seriesFrom);
            }

            if (!isValidate) {
                em.merge(trdSeriesTo);
                em.flush();
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
            } // trdSeries

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                trdSeriesTo.setTrd(trdFrom);
            }

            if (!isValidate) {
                em.merge(trdSeriesTo);
                em.flush();
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
            } // trd

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                trdTo.setFinalDisposition(finalDispositionFrom);
            }

            if (!isValidate) {
                em.merge(trdTo);
                em.flush();
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
            } // trd

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                trdTo.setGestion(documentalRetentionFrom);
            }

            if (!isValidate) {
                em.merge(trdTo);
                em.flush();
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
            } // trd

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                trdTo.setCentral(documentalRetentionFrom);
            }

            if (!isValidate) {
                em.merge(trdTo);
                em.flush();
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
            } // documentalsUnits

            if (toProperty.equals("code")){
                documentalsUnitsTo = findBean.codeDocumentalsUnits(toValue,em);
                f.line("to:"+toValue+":"+documentalsUnitsTo.getCode());
            } // documentalsUnits

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                documentalsUnitsTo.setFrequentlyQuery(frequentlyQueryFrom);
            }

            if (!isValidate) {
                em.merge(documentalsUnitsTo);
                em.flush();
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
            } // originalOrders

            if (toProperty.equals("code")){
                originalOrdersTo = findBean.codeOriginalOrders(toValue,em);
                f.line("to:"+toValue+":"+originalOrdersTo.getCode());
            } // originalOrders

            if (toProperty.equals("located")){
                originalOrdersTo = findBean.locatedOriginalOrders(toValue,em);
                f.line("to:"+toValue+":"+originalOrdersTo.getLocated());
            } // originalOrders

            if (toProperty.equals("mail")){
                originalOrdersTo = findBean.mailOriginalOrders(toValue,em);
                f.line("to:"+toValue+":"+originalOrdersTo.getMail());
            } // originalOrders

            if (toProperty.equals("notes")){
                originalOrdersTo = findBean.notesOriginalOrders(toValue,em);
                f.line("to:"+toValue+":"+originalOrdersTo.getNotes());
            } // originalOrders

            if (toProperty.equals("fileName")){
                originalOrdersTo = findBean.fileNameOriginalOrders(toValue,em);
                f.line("to:"+toValue+":"+originalOrdersTo.getFileName());
            } // originalOrders

            if (toProperty.equals("fileType")){
                originalOrdersTo = findBean.fileTypeOriginalOrders(toValue,em);
                f.line("to:"+toValue+":"+originalOrdersTo.getFileType());
            } // originalOrders

            if (toProperty.equals("filedir")){
                originalOrdersTo = findBean.filedirOriginalOrders(toValue,em);
                f.line("to:"+toValue+":"+originalOrdersTo.getFiledir());
            } // originalOrders

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                originalOrdersTo.setDocumentalsUnits(documentalsUnitsFrom);
            }

            if (!isValidate) {
                em.merge(originalOrdersTo);
                em.flush();
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
            } // versionsControls

            if (toProperty.equals("code")){
                versionsControlsTo = findBean.codeVersionsControls(toValue,em);
                f.line("to:"+toValue+":"+versionsControlsTo.getCode());
            } // versionsControls

            if (toProperty.equals("version")){
                versionsControlsTo = findBean.versionVersionsControls(toValue,em);
                f.line("to:"+toValue+":"+versionsControlsTo.getVersion());
            } // versionsControls

            if (toProperty.equals("request")){
                versionsControlsTo = findBean.requestVersionsControls(toValue,em);
                f.line("to:"+toValue+":"+versionsControlsTo.getRequest());
            } // versionsControls

            if (toProperty.equals("responsible")){
                versionsControlsTo = findBean.responsibleVersionsControls(toValue,em);
                f.line("to:"+toValue+":"+versionsControlsTo.getResponsible());
            } // versionsControls

            if (toProperty.equals("description")){
                versionsControlsTo = findBean.descriptionVersionsControls(toValue,em);
                f.line("to:"+toValue+":"+versionsControlsTo.getDescription());
            } // versionsControls

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                versionsControlsTo.setDocumentalsUnits(documentalsUnitsFrom);
            }

            if (!isValidate) {
                em.merge(versionsControlsTo);
                em.flush();
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
            } // documentalsUnits

            if (toProperty.equals("code")){
                documentalsUnitsTo = findBean.codeDocumentalsUnits(toValue,em);
                f.line("to:"+toValue+":"+documentalsUnitsTo.getCode());
            } // documentalsUnits

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                documentalsUnitsTo.setObjPadre(documentalsUnitsFrom);
            }

            if (!isValidate) {
                em.merge(documentalsUnitsTo);
                em.flush();
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
            } // originalOrders

            if (toProperty.equals("code")){
                originalOrdersTo = findBean.codeOriginalOrders(toValue,em);
                f.line("to:"+toValue+":"+originalOrdersTo.getCode());
            } // originalOrders

            if (toProperty.equals("located")){
                originalOrdersTo = findBean.locatedOriginalOrders(toValue,em);
                f.line("to:"+toValue+":"+originalOrdersTo.getLocated());
            } // originalOrders

            if (toProperty.equals("mail")){
                originalOrdersTo = findBean.mailOriginalOrders(toValue,em);
                f.line("to:"+toValue+":"+originalOrdersTo.getMail());
            } // originalOrders

            if (toProperty.equals("notes")){
                originalOrdersTo = findBean.notesOriginalOrders(toValue,em);
                f.line("to:"+toValue+":"+originalOrdersTo.getNotes());
            } // originalOrders

            if (toProperty.equals("fileName")){
                originalOrdersTo = findBean.fileNameOriginalOrders(toValue,em);
                f.line("to:"+toValue+":"+originalOrdersTo.getFileName());
            } // originalOrders

            if (toProperty.equals("fileType")){
                originalOrdersTo = findBean.fileTypeOriginalOrders(toValue,em);
                f.line("to:"+toValue+":"+originalOrdersTo.getFileType());
            } // originalOrders

            if (toProperty.equals("filedir")){
                originalOrdersTo = findBean.filedirOriginalOrders(toValue,em);
                f.line("to:"+toValue+":"+originalOrdersTo.getFiledir());
            } // originalOrders

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                originalOrdersTo.setConservationUnits(conservationUnitsFrom);
            }

            if (!isValidate) {
                em.merge(originalOrdersTo);
                em.flush();
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
            } // originalOrders

            if (toProperty.equals("code")){
                originalOrdersTo = findBean.codeOriginalOrders(toValue,em);
                f.line("to:"+toValue+":"+originalOrdersTo.getCode());
            } // originalOrders

            if (toProperty.equals("located")){
                originalOrdersTo = findBean.locatedOriginalOrders(toValue,em);
                f.line("to:"+toValue+":"+originalOrdersTo.getLocated());
            } // originalOrders

            if (toProperty.equals("mail")){
                originalOrdersTo = findBean.mailOriginalOrders(toValue,em);
                f.line("to:"+toValue+":"+originalOrdersTo.getMail());
            } // originalOrders

            if (toProperty.equals("notes")){
                originalOrdersTo = findBean.notesOriginalOrders(toValue,em);
                f.line("to:"+toValue+":"+originalOrdersTo.getNotes());
            } // originalOrders

            if (toProperty.equals("fileName")){
                originalOrdersTo = findBean.fileNameOriginalOrders(toValue,em);
                f.line("to:"+toValue+":"+originalOrdersTo.getFileName());
            } // originalOrders

            if (toProperty.equals("fileType")){
                originalOrdersTo = findBean.fileTypeOriginalOrders(toValue,em);
                f.line("to:"+toValue+":"+originalOrdersTo.getFileType());
            } // originalOrders

            if (toProperty.equals("filedir")){
                originalOrdersTo = findBean.filedirOriginalOrders(toValue,em);
                f.line("to:"+toValue+":"+originalOrdersTo.getFiledir());
            } // originalOrders

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                originalOrdersTo.setDocumentalInventory(documentalInventoryFrom);
            }

            if (!isValidate) {
                em.merge(originalOrdersTo);
                em.flush();
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
            } // documentalsUnits

            if (toProperty.equals("code")){
                documentalsUnitsTo = findBean.codeDocumentalsUnits(toValue,em);
                f.line("to:"+toValue+":"+documentalsUnitsTo.getCode());
            } // documentalsUnits

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                documentalsUnitsTo.setDocumentalsUnitsTypes(documentalsUnitsTypesFrom);
            }

            if (!isValidate) {
                em.merge(documentalsUnitsTo);
                em.flush();
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
            } // documentalsUnits

            if (toProperty.equals("code")){
                documentalsUnitsTo = findBean.codeDocumentalsUnits(toValue,em);
                f.line("to:"+toValue+":"+documentalsUnitsTo.getCode());
            } // documentalsUnits

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                documentalsUnitsTo.setAccess(accessFrom);
            }

            if (!isValidate) {
                em.merge(documentalsUnitsTo);
                em.flush();
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
            } // documentalsUnits

            if (toProperty.equals("code")){
                documentalsUnitsTo = findBean.codeDocumentalsUnits(toValue,em);
                f.line("to:"+toValue+":"+documentalsUnitsTo.getCode());
            } // documentalsUnits

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                documentalsUnitsTo.setOrganizeds(organizedsFrom);
            }

            if (!isValidate) {
                em.merge(documentalsUnitsTo);
                em.flush();
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
            } // documentalInventory

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                documentalInventoryTo.setInventoryFinality(inventoryFinalityFrom);
            }

            if (!isValidate) {
                em.merge(documentalInventoryTo);
                em.flush();
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
            } // originalOrders

            if (toProperty.equals("code")){
                originalOrdersTo = findBean.codeOriginalOrders(toValue,em);
                f.line("to:"+toValue+":"+originalOrdersTo.getCode());
            } // originalOrders

            if (toProperty.equals("located")){
                originalOrdersTo = findBean.locatedOriginalOrders(toValue,em);
                f.line("to:"+toValue+":"+originalOrdersTo.getLocated());
            } // originalOrders

            if (toProperty.equals("mail")){
                originalOrdersTo = findBean.mailOriginalOrders(toValue,em);
                f.line("to:"+toValue+":"+originalOrdersTo.getMail());
            } // originalOrders

            if (toProperty.equals("notes")){
                originalOrdersTo = findBean.notesOriginalOrders(toValue,em);
                f.line("to:"+toValue+":"+originalOrdersTo.getNotes());
            } // originalOrders

            if (toProperty.equals("fileName")){
                originalOrdersTo = findBean.fileNameOriginalOrders(toValue,em);
                f.line("to:"+toValue+":"+originalOrdersTo.getFileName());
            } // originalOrders

            if (toProperty.equals("fileType")){
                originalOrdersTo = findBean.fileTypeOriginalOrders(toValue,em);
                f.line("to:"+toValue+":"+originalOrdersTo.getFileType());
            } // originalOrders

            if (toProperty.equals("filedir")){
                originalOrdersTo = findBean.filedirOriginalOrders(toValue,em);
                f.line("to:"+toValue+":"+originalOrdersTo.getFiledir());
            } // originalOrders

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                originalOrdersTo.setDocumentalsSupports(documentalsSupportsFrom);
            }

            if (!isValidate) {
                em.merge(originalOrdersTo);
                em.flush();
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
            } // conservationUnits

            if (toProperty.equals("code")){
                conservationUnitsTo = findBean.codeConservationUnits(toValue,em);
                f.line("to:"+toValue+":"+conservationUnitsTo.getCode());
            } // conservationUnits

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                conservationUnitsTo.setConservationUnitsTypes(conservationUnitsTypesFrom);
            }

            if (!isValidate) {
                em.merge(conservationUnitsTo);
                em.flush();
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
            } // originalOrders

            if (toProperty.equals("code")){
                originalOrdersTo = findBean.codeOriginalOrders(toValue,em);
                f.line("to:"+toValue+":"+originalOrdersTo.getCode());
            } // originalOrders

            if (toProperty.equals("located")){
                originalOrdersTo = findBean.locatedOriginalOrders(toValue,em);
                f.line("to:"+toValue+":"+originalOrdersTo.getLocated());
            } // originalOrders

            if (toProperty.equals("mail")){
                originalOrdersTo = findBean.mailOriginalOrders(toValue,em);
                f.line("to:"+toValue+":"+originalOrdersTo.getMail());
            } // originalOrders

            if (toProperty.equals("notes")){
                originalOrdersTo = findBean.notesOriginalOrders(toValue,em);
                f.line("to:"+toValue+":"+originalOrdersTo.getNotes());
            } // originalOrders

            if (toProperty.equals("fileName")){
                originalOrdersTo = findBean.fileNameOriginalOrders(toValue,em);
                f.line("to:"+toValue+":"+originalOrdersTo.getFileName());
            } // originalOrders

            if (toProperty.equals("fileType")){
                originalOrdersTo = findBean.fileTypeOriginalOrders(toValue,em);
                f.line("to:"+toValue+":"+originalOrdersTo.getFileType());
            } // originalOrders

            if (toProperty.equals("filedir")){
                originalOrdersTo = findBean.filedirOriginalOrders(toValue,em);
                f.line("to:"+toValue+":"+originalOrdersTo.getFiledir());
            } // originalOrders

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                originalOrdersTo.setConservationUnitsTypes(conservationUnitsTypesFrom);
            }

            if (!isValidate) {
                em.merge(originalOrdersTo);
                em.flush();
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
            } // funds

            if (toProperty.equals("code")){
                fundsTo = findBean.codeFunds(toValue,em);
                f.line("to:"+toValue+":"+fundsTo.getCode());
            } // funds

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                fundsTo.setCompanies(companiesFrom);
            }

            if (!isValidate) {
                em.merge(fundsTo);
                em.flush();
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
            } // documentalsUnits

            if (toProperty.equals("code")){
                documentalsUnitsTo = findBean.codeDocumentalsUnits(toValue,em);
                f.line("to:"+toValue+":"+documentalsUnitsTo.getCode());
            } // documentalsUnits

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                documentalsUnitsTo.setAlmacenamiento(companiesRolesFrom);
            }

            if (!isValidate) {
                em.merge(documentalsUnitsTo);
                em.flush();
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
            } // documentalsUnits

            if (toProperty.equals("code")){
                documentalsUnitsTo = findBean.codeDocumentalsUnits(toValue,em);
                f.line("to:"+toValue+":"+documentalsUnitsTo.getCode());
            } // documentalsUnits

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                documentalsUnitsTo.setProteccion(companiesRolesFrom);
            }

            if (!isValidate) {
                em.merge(documentalsUnitsTo);
                em.flush();
            }

        } // from: CompaniesRoles

    } // relationshipsR5Data

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

    try{

        anterior = "";



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
                                      " FromProperty:"+fromProperty+"\n"+
                                      " FromValue:"+fromValue+"\n"+
                                      " To:"+to+"\n"+
                                      " ToProperty:"+toProperty+"\n"+
                                      " ToValue:"+toValue+"\n"+
                                      " Name:"+name+"\n"+
                                      " Cardinalities:"+cardinalities);

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
