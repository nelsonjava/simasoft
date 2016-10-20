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

    @PersistenceContext(unitName = "leanCrmPU-JTA")
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
            } // continualImprovements

            if (toProperty.equals("description")){
                continualImprovementsTo = findBean.descriptionContinualImprovements(toValue,em);
                f.line("to:"+toValue+":"+continualImprovementsTo.getDescription());
            } // continualImprovements

            if (toProperty.equals("causesAnalysis")){
                continualImprovementsTo = findBean.causesAnalysisContinualImprovements(toValue,em);
                f.line("to:"+toValue+":"+continualImprovementsTo.getCausesAnalysis());
            } // continualImprovements

            if (toProperty.equals("rootCause")){
                continualImprovementsTo = findBean.rootCauseContinualImprovements(toValue,em);
                f.line("to:"+toValue+":"+continualImprovementsTo.getRootCause());
            } // continualImprovements

            if (toProperty.equals("immediateCorrection")){
                continualImprovementsTo = findBean.immediateCorrectionContinualImprovements(toValue,em);
                f.line("to:"+toValue+":"+continualImprovementsTo.getImmediateCorrection());
            } // continualImprovements

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                continualImprovementsTo.setDocumentalsUnits(documentalsUnitsFrom);
            }

            if (!isValidate) {
                em.merge(continualImprovementsTo);
                em.flush();
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
            } // books

            if (toProperty.equals("name")){
                booksTo = findBean.nameBooks(toValue,em);
                f.line("to:"+toValue+":"+booksTo.getName());
            } // books

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                booksTo.setBooksTypes(booksTypesFrom);
            }

            if (!isValidate) {
                em.merge(booksTo);
                em.flush();
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
            } // booksTypes

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                booksTypesTo.setObjPadre(booksTypesFrom);
            }

            if (!isValidate) {
                em.merge(booksTypesTo);
                em.flush();
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
            } // activities

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                activitiesTo.setBooks(booksFrom);
            }

            if (!isValidate) {
                em.merge(activitiesTo);
                em.flush();
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
            } // chapters

            if (toProperty.equals("name")){
                chaptersTo = findBean.nameChapters(toValue,em);
                f.line("to:"+toValue+":"+chaptersTo.getName());
            } // chapters

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                chaptersTo.setBooks(booksFrom);
            }

            if (!isValidate) {
                em.merge(chaptersTo);
                em.flush();
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
            } // diaries

            if (toProperty.equals("description")){
                diariesTo = findBean.descriptionDiaries(toValue,em);
                f.line("to:"+toValue+":"+diariesTo.getDescription());
            } // diaries

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                diariesTo.setChapters(chaptersFrom);
            }

            if (!isValidate) {
                em.merge(diariesTo);
                em.flush();
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
            } // tasks

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                tasksTo.setChapters(chaptersFrom);
            }

            if (!isValidate) {
                em.merge(tasksTo);
                em.flush();
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
            } // chapters

            if (toProperty.equals("name")){
                chaptersTo = findBean.nameChapters(toValue,em);
                f.line("to:"+toValue+":"+chaptersTo.getName());
            } // chapters

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                chaptersTo.setObjPadre(chaptersFrom);
            }

            if (!isValidate) {
                em.merge(chaptersTo);
                em.flush();
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
            } // brands

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                brandsTo.setCompanies(companiesFrom);
            }

            if (!isValidate) {
                em.merge(brandsTo);
                em.flush();
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
            } // employees

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                employeesTo.setCompanies(companiesFrom);
            }

            if (!isValidate) {
                em.merge(employeesTo);
                em.flush();
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
            } // companies

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                companiesTo.setObjPadre(companiesFrom);
            }

            if (!isValidate) {
                em.merge(companiesTo);
                em.flush();
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
            } // employees

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                employeesTo.setEmployeesTypes(employeesTypesFrom);
            }

            if (!isValidate) {
                em.merge(employeesTo);
                em.flush();
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
            } // companiesRoles

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                companiesRolesTo.setCompaniesRolesTypes(companiesRolesTypesFrom);
            }

            if (!isValidate) {
                em.merge(companiesRolesTo);
                em.flush();
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
            } // companiesRolesTypes

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                companiesRolesTypesTo.setObjPadre(companiesRolesTypesFrom);
            }

            if (!isValidate) {
                em.merge(companiesRolesTypesTo);
                em.flush();
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
            } // charges

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                chargesTo.setChargesTypes(chargesTypesFrom);
            }

            if (!isValidate) {
                em.merge(chargesTo);
                em.flush();
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
            } // chargesTypes

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                chargesTypesTo.setObjPadre(chargesTypesFrom);
            }

            if (!isValidate) {
                em.merge(chargesTypesTo);
                em.flush();
            }

        } // from: ChargesTypes

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
            } // continualImprovements

            if (toProperty.equals("description")){
                continualImprovementsTo = findBean.descriptionContinualImprovements(toValue,em);
                f.line("to:"+toValue+":"+continualImprovementsTo.getDescription());
            } // continualImprovements

            if (toProperty.equals("causesAnalysis")){
                continualImprovementsTo = findBean.causesAnalysisContinualImprovements(toValue,em);
                f.line("to:"+toValue+":"+continualImprovementsTo.getCausesAnalysis());
            } // continualImprovements

            if (toProperty.equals("rootCause")){
                continualImprovementsTo = findBean.rootCauseContinualImprovements(toValue,em);
                f.line("to:"+toValue+":"+continualImprovementsTo.getRootCause());
            } // continualImprovements

            if (toProperty.equals("immediateCorrection")){
                continualImprovementsTo = findBean.immediateCorrectionContinualImprovements(toValue,em);
                f.line("to:"+toValue+":"+continualImprovementsTo.getImmediateCorrection());
            } // continualImprovements

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                continualImprovementsTo.setImprovementTypes(improvementTypesFrom);
            }

            if (!isValidate) {
                em.merge(continualImprovementsTo);
                em.flush();
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
            } // continualImprovements

            if (toProperty.equals("description")){
                continualImprovementsTo = findBean.descriptionContinualImprovements(toValue,em);
                f.line("to:"+toValue+":"+continualImprovementsTo.getDescription());
            } // continualImprovements

            if (toProperty.equals("causesAnalysis")){
                continualImprovementsTo = findBean.causesAnalysisContinualImprovements(toValue,em);
                f.line("to:"+toValue+":"+continualImprovementsTo.getCausesAnalysis());
            } // continualImprovements

            if (toProperty.equals("rootCause")){
                continualImprovementsTo = findBean.rootCauseContinualImprovements(toValue,em);
                f.line("to:"+toValue+":"+continualImprovementsTo.getRootCause());
            } // continualImprovements

            if (toProperty.equals("immediateCorrection")){
                continualImprovementsTo = findBean.immediateCorrectionContinualImprovements(toValue,em);
                f.line("to:"+toValue+":"+continualImprovementsTo.getImmediateCorrection());
            } // continualImprovements

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                continualImprovementsTo.setImprovementSources(improvementSourcesFrom);
            }

            if (!isValidate) {
                em.merge(continualImprovementsTo);
                em.flush();
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
                originalOrdersTo.setContinualImprovements(continualImprovementsFrom);
            }

            if (!isValidate) {
                em.merge(originalOrdersTo);
                em.flush();
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
            } // actionPlans

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                actionPlansTo.setContinualImprovements(continualImprovementsFrom);
            }

            if (!isValidate) {
                em.merge(actionPlansTo);
                em.flush();
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
            } // continualImprovements

            if (toProperty.equals("description")){
                continualImprovementsTo = findBean.descriptionContinualImprovements(toValue,em);
                f.line("to:"+toValue+":"+continualImprovementsTo.getDescription());
            } // continualImprovements

            if (toProperty.equals("causesAnalysis")){
                continualImprovementsTo = findBean.causesAnalysisContinualImprovements(toValue,em);
                f.line("to:"+toValue+":"+continualImprovementsTo.getCausesAnalysis());
            } // continualImprovements

            if (toProperty.equals("rootCause")){
                continualImprovementsTo = findBean.rootCauseContinualImprovements(toValue,em);
                f.line("to:"+toValue+":"+continualImprovementsTo.getRootCause());
            } // continualImprovements

            if (toProperty.equals("immediateCorrection")){
                continualImprovementsTo = findBean.immediateCorrectionContinualImprovements(toValue,em);
                f.line("to:"+toValue+":"+continualImprovementsTo.getImmediateCorrection());
            } // continualImprovements

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                continualImprovementsTo.setImprovementVerifications(improvementVerificationsFrom);
            }

            if (!isValidate) {
                em.merge(continualImprovementsTo);
                em.flush();
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
            } // closingActivities

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                closingActivitiesTo.setImprovementClosures(improvementClosuresFrom);
            }

            if (!isValidate) {
                em.merge(closingActivitiesTo);
                em.flush();
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
            } // continualImprovements

            if (toProperty.equals("description")){
                continualImprovementsTo = findBean.descriptionContinualImprovements(toValue,em);
                f.line("to:"+toValue+":"+continualImprovementsTo.getDescription());
            } // continualImprovements

            if (toProperty.equals("causesAnalysis")){
                continualImprovementsTo = findBean.causesAnalysisContinualImprovements(toValue,em);
                f.line("to:"+toValue+":"+continualImprovementsTo.getCausesAnalysis());
            } // continualImprovements

            if (toProperty.equals("rootCause")){
                continualImprovementsTo = findBean.rootCauseContinualImprovements(toValue,em);
                f.line("to:"+toValue+":"+continualImprovementsTo.getRootCause());
            } // continualImprovements

            if (toProperty.equals("immediateCorrection")){
                continualImprovementsTo = findBean.immediateCorrectionContinualImprovements(toValue,em);
                f.line("to:"+toValue+":"+continualImprovementsTo.getImmediateCorrection());
            } // continualImprovements

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                continualImprovementsTo.setImprovementClosures(improvementClosuresFrom);
            }

            if (!isValidate) {
                em.merge(continualImprovementsTo);
                em.flush();
            }

        } // from: ImprovementClosures

        if (from.equals("ItemsTypes") &&
            cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
            to.equals("ItemsTypes") &&
            name.equals("")){

            ItemsTypes itemsTypesFrom = new ItemsTypes();
            ItemsTypes itemsTypesTo = new ItemsTypes();

            if (fromProperty.equals("name")){
                itemsTypesFrom = findBean.nameItemsTypes(fromValue,em);
                f.line("from:"+fromValue+":"+itemsTypesFrom.getName());
            } // itemsTypes

            if (toProperty.equals("name")){
                itemsTypesTo = findBean.nameItemsTypes(toValue,em);
                f.line("to:"+toValue+":"+itemsTypesTo.getName());
            } // itemsTypes

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                itemsTypesTo.setObjPadre(itemsTypesFrom);
            }

            if (!isValidate) {
                em.merge(itemsTypesTo);
                em.flush();
            }

        } // from: ItemsTypes

        if (from.equals("ItemsTypes") &&
            cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
            to.equals("ItemsNames") &&
            name.equals("")){

            ItemsTypes itemsTypesFrom = new ItemsTypes();
            ItemsNames itemsNamesTo = new ItemsNames();

            if (fromProperty.equals("name")){
                itemsTypesFrom = findBean.nameItemsTypes(fromValue,em);
                f.line("from:"+fromValue+":"+itemsTypesFrom.getName());
            } // itemsTypes

            if (toProperty.equals("name")){
                itemsNamesTo = findBean.nameItemsNames(toValue,em);
                f.line("to:"+toValue+":"+itemsNamesTo.getName());
            } // itemsNames

            if (toProperty.equals("model")){
                itemsNamesTo = findBean.modelItemsNames(toValue,em);
                f.line("to:"+toValue+":"+itemsNamesTo.getModel());
            } // itemsNames

            if (toProperty.equals("productNumber")){
                itemsNamesTo = findBean.productNumberItemsNames(toValue,em);
                f.line("to:"+toValue+":"+itemsNamesTo.getProductNumber());
            } // itemsNames

            if (toProperty.equals("partNumber")){
                itemsNamesTo = findBean.partNumberItemsNames(toValue,em);
                f.line("to:"+toValue+":"+itemsNamesTo.getPartNumber());
            } // itemsNames

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                itemsNamesTo.setItemsTypes(itemsTypesFrom);
            }

            if (!isValidate) {
                em.merge(itemsNamesTo);
                em.flush();
            }

        } // from: ItemsTypes

        if (from.equals("ItemsNames") &&
            cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
            to.equals("Items") &&
            name.equals("")){

            ItemsNames itemsNamesFrom = new ItemsNames();
            Items itemsTo = new Items();

            if (fromProperty.equals("name")){
                itemsNamesFrom = findBean.nameItemsNames(fromValue,em);
                f.line("from:"+fromValue+":"+itemsNamesFrom.getName());
            } // itemsNames

            if (fromProperty.equals("model")){
                itemsNamesFrom = findBean.modelItemsNames(fromValue,em);
                f.line("from:"+fromValue+":"+itemsNamesFrom.getModel());
            } // itemsNames

            if (fromProperty.equals("productNumber")){
                itemsNamesFrom = findBean.productNumberItemsNames(fromValue,em);
                f.line("from:"+fromValue+":"+itemsNamesFrom.getProductNumber());
            } // itemsNames

            if (fromProperty.equals("partNumber")){
                itemsNamesFrom = findBean.partNumberItemsNames(fromValue,em);
                f.line("from:"+fromValue+":"+itemsNamesFrom.getPartNumber());
            } // itemsNames

            if (toProperty.equals("cvNumber")){
                itemsTo = findBean.cvNumberItems(toValue,em);
                f.line("to:"+toValue+":"+itemsTo.getCvNumber());
            } // items

            if (toProperty.equals("code")){
                itemsTo = findBean.codeItems(toValue,em);
                f.line("to:"+toValue+":"+itemsTo.getCode());
            } // items

            if (toProperty.equals("inventoryCode")){
                itemsTo = findBean.inventoryCodeItems(toValue,em);
                f.line("to:"+toValue+":"+itemsTo.getInventoryCode());
            } // items

            if (toProperty.equals("serial")){
                itemsTo = findBean.serialItems(toValue,em);
                f.line("to:"+toValue+":"+itemsTo.getSerial());
            } // items

            if (toProperty.equals("eanCode")){
                itemsTo = findBean.eanCodeItems(toValue,em);
                f.line("to:"+toValue+":"+itemsTo.getEanCode());
            } // items

            if (toProperty.equals("located")){
                itemsTo = findBean.locatedItems(toValue,em);
                f.line("to:"+toValue+":"+itemsTo.getLocated());
            } // items

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                itemsTo.setItemsNames(itemsNamesFrom);
            }

            if (!isValidate) {
                em.merge(itemsTo);
                em.flush();
            }

        } // from: ItemsNames

        if (from.equals("Items") &&
            cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
            to.equals("Items") &&
            name.equals("")){

            Items itemsFrom = new Items();
            Items itemsTo = new Items();

            if (fromProperty.equals("cvNumber")){
                itemsFrom = findBean.cvNumberItems(fromValue,em);
                f.line("from:"+fromValue+":"+itemsFrom.getCvNumber());
            } // items

            if (fromProperty.equals("code")){
                itemsFrom = findBean.codeItems(fromValue,em);
                f.line("from:"+fromValue+":"+itemsFrom.getCode());
            } // items

            if (fromProperty.equals("inventoryCode")){
                itemsFrom = findBean.inventoryCodeItems(fromValue,em);
                f.line("from:"+fromValue+":"+itemsFrom.getInventoryCode());
            } // items

            if (fromProperty.equals("serial")){
                itemsFrom = findBean.serialItems(fromValue,em);
                f.line("from:"+fromValue+":"+itemsFrom.getSerial());
            } // items

            if (fromProperty.equals("eanCode")){
                itemsFrom = findBean.eanCodeItems(fromValue,em);
                f.line("from:"+fromValue+":"+itemsFrom.getEanCode());
            } // items

            if (fromProperty.equals("located")){
                itemsFrom = findBean.locatedItems(fromValue,em);
                f.line("from:"+fromValue+":"+itemsFrom.getLocated());
            } // items

            if (toProperty.equals("cvNumber")){
                itemsTo = findBean.cvNumberItems(toValue,em);
                f.line("to:"+toValue+":"+itemsTo.getCvNumber());
            } // items

            if (toProperty.equals("code")){
                itemsTo = findBean.codeItems(toValue,em);
                f.line("to:"+toValue+":"+itemsTo.getCode());
            } // items

            if (toProperty.equals("inventoryCode")){
                itemsTo = findBean.inventoryCodeItems(toValue,em);
                f.line("to:"+toValue+":"+itemsTo.getInventoryCode());
            } // items

            if (toProperty.equals("serial")){
                itemsTo = findBean.serialItems(toValue,em);
                f.line("to:"+toValue+":"+itemsTo.getSerial());
            } // items

            if (toProperty.equals("eanCode")){
                itemsTo = findBean.eanCodeItems(toValue,em);
                f.line("to:"+toValue+":"+itemsTo.getEanCode());
            } // items

            if (toProperty.equals("located")){
                itemsTo = findBean.locatedItems(toValue,em);
                f.line("to:"+toValue+":"+itemsTo.getLocated());
            } // items

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                itemsTo.setObjPadre(itemsFrom);
            }

            if (!isValidate) {
                em.merge(itemsTo);
                em.flush();
            }

        } // from: Items

        if (from.equals("ItemsStates") &&
            cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
            to.equals("Items") &&
            name.equals("")){

            ItemsStates itemsStatesFrom = new ItemsStates();
            Items itemsTo = new Items();

            if (fromProperty.equals("name")){
                itemsStatesFrom = findBean.nameItemsStates(fromValue,em);
                f.line("from:"+fromValue+":"+itemsStatesFrom.getName());
            } // itemsStates

            if (toProperty.equals("cvNumber")){
                itemsTo = findBean.cvNumberItems(toValue,em);
                f.line("to:"+toValue+":"+itemsTo.getCvNumber());
            } // items

            if (toProperty.equals("code")){
                itemsTo = findBean.codeItems(toValue,em);
                f.line("to:"+toValue+":"+itemsTo.getCode());
            } // items

            if (toProperty.equals("inventoryCode")){
                itemsTo = findBean.inventoryCodeItems(toValue,em);
                f.line("to:"+toValue+":"+itemsTo.getInventoryCode());
            } // items

            if (toProperty.equals("serial")){
                itemsTo = findBean.serialItems(toValue,em);
                f.line("to:"+toValue+":"+itemsTo.getSerial());
            } // items

            if (toProperty.equals("eanCode")){
                itemsTo = findBean.eanCodeItems(toValue,em);
                f.line("to:"+toValue+":"+itemsTo.getEanCode());
            } // items

            if (toProperty.equals("located")){
                itemsTo = findBean.locatedItems(toValue,em);
                f.line("to:"+toValue+":"+itemsTo.getLocated());
            } // items

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                itemsTo.setItemsStates(itemsStatesFrom);
            }

            if (!isValidate) {
                em.merge(itemsTo);
                em.flush();
            }

        } // from: ItemsStates

        if (from.equals("LeanProjects") &&
            cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
            to.equals("ModelsCanvas") &&
            name.equals("")){

            LeanProjects leanProjectsFrom = new LeanProjects();
            ModelsCanvas modelsCanvasTo = new ModelsCanvas();

            if (fromProperty.equals("name")){
                leanProjectsFrom = findBean.nameLeanProjects(fromValue,em);
                f.line("from:"+fromValue+":"+leanProjectsFrom.getName());
            } // leanProjects

            if (toProperty.equals("name")){
                modelsCanvasTo = findBean.nameModelsCanvas(toValue,em);
                f.line("to:"+toValue+":"+modelsCanvasTo.getName());
            } // modelsCanvas

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                modelsCanvasTo.setLeanProjects(leanProjectsFrom);
            }

            if (!isValidate) {
                em.merge(modelsCanvasTo);
                em.flush();
            }

        } // from: LeanProjects

        if (from.equals("ModelsCanvasSections") &&
            cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
            to.equals("Postits") &&
            name.equals("")){

            ModelsCanvasSections modelsCanvasSectionsFrom = new ModelsCanvasSections();
            Postits postitsTo = new Postits();

            if (fromProperty.equals("name")){
                modelsCanvasSectionsFrom = findBean.nameModelsCanvasSections(fromValue,em);
                f.line("from:"+fromValue+":"+modelsCanvasSectionsFrom.getName());
            } // modelsCanvasSections

            if (toProperty.equals("note")){
                postitsTo = findBean.notePostits(toValue,em);
                f.line("to:"+toValue+":"+postitsTo.getNote());
            } // postits

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                postitsTo.setModelsCanvasSections(modelsCanvasSectionsFrom);
            }

            if (!isValidate) {
                em.merge(postitsTo);
                em.flush();
            }

        } // from: ModelsCanvasSections

        if (from.equals("Postits") &&
            cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
            to.equals("Postits") &&
            name.equals("")){

            Postits postitsFrom = new Postits();
            Postits postitsTo = new Postits();

            if (fromProperty.equals("note")){
                postitsFrom = findBean.notePostits(fromValue,em);
                f.line("from:"+fromValue+":"+postitsFrom.getNote());
            } // postits

            if (toProperty.equals("note")){
                postitsTo = findBean.notePostits(toValue,em);
                f.line("to:"+toValue+":"+postitsTo.getNote());
            } // postits

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                postitsTo.setObjPadre(postitsFrom);
            }

            if (!isValidate) {
                em.merge(postitsTo);
                em.flush();
            }

        } // from: Postits

        if (from.equals("LegisTypes") &&
            cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
            to.equals("Legis") &&
            name.equals("")){

            LegisTypes legisTypesFrom = new LegisTypes();
            Legis legisTo = new Legis();

            if (fromProperty.equals("name")){
                legisTypesFrom = findBean.nameLegisTypes(fromValue,em);
                f.line("from:"+fromValue+":"+legisTypesFrom.getName());
            } // legisTypes

            if (toProperty.equals("code")){
                legisTo = findBean.codeLegis(toValue,em);
                f.line("to:"+toValue+":"+legisTo.getCode());
            } // legis

            if (toProperty.equals("name")){
                legisTo = findBean.nameLegis(toValue,em);
                f.line("to:"+toValue+":"+legisTo.getName());
            } // legis

            if (toProperty.equals("link")){
                legisTo = findBean.linkLegis(toValue,em);
                f.line("to:"+toValue+":"+legisTo.getLink());
            } // legis

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                legisTo.setLegisTypes(legisTypesFrom);
            }

            if (!isValidate) {
                em.merge(legisTo);
                em.flush();
            }

        } // from: LegisTypes

        if (from.equals("Legis") &&
            cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
            to.equals("LegisArt") &&
            name.equals("")){

            Legis legisFrom = new Legis();
            LegisArt legisArtTo = new LegisArt();

            if (fromProperty.equals("code")){
                legisFrom = findBean.codeLegis(fromValue,em);
                f.line("from:"+fromValue+":"+legisFrom.getCode());
            } // legis

            if (fromProperty.equals("name")){
                legisFrom = findBean.nameLegis(fromValue,em);
                f.line("from:"+fromValue+":"+legisFrom.getName());
            } // legis

            if (fromProperty.equals("link")){
                legisFrom = findBean.linkLegis(fromValue,em);
                f.line("from:"+fromValue+":"+legisFrom.getLink());
            } // legis

            if (toProperty.equals("code")){
                legisArtTo = findBean.codeLegisArt(toValue,em);
                f.line("to:"+toValue+":"+legisArtTo.getCode());
            } // legisArt

            if (toProperty.equals("name")){
                legisArtTo = findBean.nameLegisArt(toValue,em);
                f.line("to:"+toValue+":"+legisArtTo.getName());
            } // legisArt

            if (toProperty.equals("content")){
                legisArtTo = findBean.contentLegisArt(toValue,em);
                f.line("to:"+toValue+":"+legisArtTo.getContent());
            } // legisArt

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                legisArtTo.setLegis(legisFrom);
            }

            if (!isValidate) {
                em.merge(legisArtTo);
                em.flush();
            }

        } // from: Legis

        if (from.equals("LegisArt") &&
            cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
            to.equals("LegisArtSubject") &&
            name.equals("")){

            LegisArt legisArtFrom = new LegisArt();
            LegisArtSubject legisArtSubjectTo = new LegisArtSubject();

            if (fromProperty.equals("code")){
                legisArtFrom = findBean.codeLegisArt(fromValue,em);
                f.line("from:"+fromValue+":"+legisArtFrom.getCode());
            } // legisArt

            if (fromProperty.equals("name")){
                legisArtFrom = findBean.nameLegisArt(fromValue,em);
                f.line("from:"+fromValue+":"+legisArtFrom.getName());
            } // legisArt

            if (fromProperty.equals("content")){
                legisArtFrom = findBean.contentLegisArt(fromValue,em);
                f.line("from:"+fromValue+":"+legisArtFrom.getContent());
            } // legisArt

            if (toProperty.equals("name")){
                legisArtSubjectTo = findBean.nameLegisArtSubject(toValue,em);
                f.line("to:"+toValue+":"+legisArtSubjectTo.getName());
            } // legisArtSubject

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                legisArtSubjectTo.setLegisArt(legisArtFrom);
            }

            if (!isValidate) {
                em.merge(legisArtSubjectTo);
                em.flush();
            }

        } // from: LegisArt

        if (from.equals("LegisSubject") &&
            cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
            to.equals("LegisSubject") &&
            name.equals("")){

            LegisSubject legisSubjectFrom = new LegisSubject();
            LegisSubject legisSubjectTo = new LegisSubject();

            if (fromProperty.equals("code")){
                legisSubjectFrom = findBean.codeLegisSubject(fromValue,em);
                f.line("from:"+fromValue+":"+legisSubjectFrom.getCode());
            } // legisSubject

            if (fromProperty.equals("name")){
                legisSubjectFrom = findBean.nameLegisSubject(fromValue,em);
                f.line("from:"+fromValue+":"+legisSubjectFrom.getName());
            } // legisSubject

            if (toProperty.equals("code")){
                legisSubjectTo = findBean.codeLegisSubject(toValue,em);
                f.line("to:"+toValue+":"+legisSubjectTo.getCode());
            } // legisSubject

            if (toProperty.equals("name")){
                legisSubjectTo = findBean.nameLegisSubject(toValue,em);
                f.line("to:"+toValue+":"+legisSubjectTo.getName());
            } // legisSubject

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                legisSubjectTo.setObjPadre(legisSubjectFrom);
            }

            if (!isValidate) {
                em.merge(legisSubjectTo);
                em.flush();
            }

        } // from: LegisSubject

        if (from.equals("LegisSubject") &&
            cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
            to.equals("LegisTopic") &&
            name.equals("")){

            LegisSubject legisSubjectFrom = new LegisSubject();
            LegisTopic legisTopicTo = new LegisTopic();

            if (fromProperty.equals("code")){
                legisSubjectFrom = findBean.codeLegisSubject(fromValue,em);
                f.line("from:"+fromValue+":"+legisSubjectFrom.getCode());
            } // legisSubject

            if (fromProperty.equals("name")){
                legisSubjectFrom = findBean.nameLegisSubject(fromValue,em);
                f.line("from:"+fromValue+":"+legisSubjectFrom.getName());
            } // legisSubject

            if (toProperty.equals("code")){
                legisTopicTo = findBean.codeLegisTopic(toValue,em);
                f.line("to:"+toValue+":"+legisTopicTo.getCode());
            } // legisTopic

            if (toProperty.equals("name")){
                legisTopicTo = findBean.nameLegisTopic(toValue,em);
                f.line("to:"+toValue+":"+legisTopicTo.getName());
            } // legisTopic

            if (toProperty.equals("link")){
                legisTopicTo = findBean.linkLegisTopic(toValue,em);
                f.line("to:"+toValue+":"+legisTopicTo.getLink());
            } // legisTopic

            if (toProperty.equals("located")){
                legisTopicTo = findBean.locatedLegisTopic(toValue,em);
                f.line("to:"+toValue+":"+legisTopicTo.getLocated());
            } // legisTopic

            if (toProperty.equals("linkMail")){
                legisTopicTo = findBean.linkMailLegisTopic(toValue,em);
                f.line("to:"+toValue+":"+legisTopicTo.getLinkMail());
            } // legisTopic

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                legisTopicTo.setLegisSubject(legisSubjectFrom);
            }

            if (!isValidate) {
                em.merge(legisTopicTo);
                em.flush();
            }

        } // from: LegisSubject

        if (from.equals("LegisSubject") &&
            cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
            to.equals("LegisArtSubject") &&
            name.equals("")){

            LegisSubject legisSubjectFrom = new LegisSubject();
            LegisArtSubject legisArtSubjectTo = new LegisArtSubject();

            if (fromProperty.equals("code")){
                legisSubjectFrom = findBean.codeLegisSubject(fromValue,em);
                f.line("from:"+fromValue+":"+legisSubjectFrom.getCode());
            } // legisSubject

            if (fromProperty.equals("name")){
                legisSubjectFrom = findBean.nameLegisSubject(fromValue,em);
                f.line("from:"+fromValue+":"+legisSubjectFrom.getName());
            } // legisSubject

            if (toProperty.equals("name")){
                legisArtSubjectTo = findBean.nameLegisArtSubject(toValue,em);
                f.line("to:"+toValue+":"+legisArtSubjectTo.getName());
            } // legisArtSubject

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                legisArtSubjectTo.setLegisSubject(legisSubjectFrom);
            }

            if (!isValidate) {
                em.merge(legisArtSubjectTo);
                em.flush();
            }

        } // from: LegisSubject

        if (from.equals("LegisTopicTypes") &&
            cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
            to.equals("LegisTopic") &&
            name.equals("")){

            LegisTopicTypes legisTopicTypesFrom = new LegisTopicTypes();
            LegisTopic legisTopicTo = new LegisTopic();

            if (fromProperty.equals("name")){
                legisTopicTypesFrom = findBean.nameLegisTopicTypes(fromValue,em);
                f.line("from:"+fromValue+":"+legisTopicTypesFrom.getName());
            } // legisTopicTypes

            if (toProperty.equals("code")){
                legisTopicTo = findBean.codeLegisTopic(toValue,em);
                f.line("to:"+toValue+":"+legisTopicTo.getCode());
            } // legisTopic

            if (toProperty.equals("name")){
                legisTopicTo = findBean.nameLegisTopic(toValue,em);
                f.line("to:"+toValue+":"+legisTopicTo.getName());
            } // legisTopic

            if (toProperty.equals("link")){
                legisTopicTo = findBean.linkLegisTopic(toValue,em);
                f.line("to:"+toValue+":"+legisTopicTo.getLink());
            } // legisTopic

            if (toProperty.equals("located")){
                legisTopicTo = findBean.locatedLegisTopic(toValue,em);
                f.line("to:"+toValue+":"+legisTopicTo.getLocated());
            } // legisTopic

            if (toProperty.equals("linkMail")){
                legisTopicTo = findBean.linkMailLegisTopic(toValue,em);
                f.line("to:"+toValue+":"+legisTopicTo.getLinkMail());
            } // legisTopic

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                legisTopicTo.setLegisTopicTypes(legisTopicTypesFrom);
            }

            if (!isValidate) {
                em.merge(legisTopicTo);
                em.flush();
            }

        } // from: LegisTopicTypes

        if (from.equals("LegisTopicTypes") &&
            cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
            to.equals("LegisTopicTypes") &&
            name.equals("")){

            LegisTopicTypes legisTopicTypesFrom = new LegisTopicTypes();
            LegisTopicTypes legisTopicTypesTo = new LegisTopicTypes();

            if (fromProperty.equals("name")){
                legisTopicTypesFrom = findBean.nameLegisTopicTypes(fromValue,em);
                f.line("from:"+fromValue+":"+legisTopicTypesFrom.getName());
            } // legisTopicTypes

            if (toProperty.equals("name")){
                legisTopicTypesTo = findBean.nameLegisTopicTypes(toValue,em);
                f.line("to:"+toValue+":"+legisTopicTypesTo.getName());
            } // legisTopicTypes

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                legisTopicTypesTo.setObjPadre(legisTopicTypesFrom);
            }

            if (!isValidate) {
                em.merge(legisTopicTypesTo);
                em.flush();
            }

        } // from: LegisTopicTypes

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
            } // tasks

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                tasksTo.setPersons(personsFrom);
            }

            if (!isValidate) {
                em.merge(tasksTo);
                em.flush();
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
            } // activities

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                activitiesTo.setPersons(personsFrom);
            }

            if (!isValidate) {
                em.merge(activitiesTo);
                em.flush();
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
            } // employees

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                employeesTo.setPersons(personsFrom);
            }

            if (!isValidate) {
                em.merge(employeesTo);
                em.flush();
            }

        } // from: Persons

        if (from.equals("Predio") &&
            cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
            to.equals("PhysicalSpaces") &&
            name.equals("")){

            Predio predioFrom = new Predio();
            PhysicalSpaces physicalSpacesTo = new PhysicalSpaces();

            if (fromProperty.equals("nomenclatura")){
                predioFrom = findBean.nomenclaturaPredio(fromValue,em);
                f.line("from:"+fromValue+":"+predioFrom.getNomenclatura());
            } // predio

            if (fromProperty.equals("predial")){
                predioFrom = findBean.predialPredio(fromValue,em);
                f.line("from:"+fromValue+":"+predioFrom.getPredial());
            } // predio

            if (fromProperty.equals("code")){
                predioFrom = findBean.codePredio(fromValue,em);
                f.line("from:"+fromValue+":"+predioFrom.getCode());
            } // predio

            if (fromProperty.equals("estrato")){
                predioFrom = findBean.estratoPredio(fromValue,em);
                f.line("from:"+fromValue+":"+predioFrom.getEstrato());
            } // predio

            if (fromProperty.equals("matricula")){
                predioFrom = findBean.matriculaPredio(fromValue,em);
                f.line("from:"+fromValue+":"+predioFrom.getMatricula());
            } // predio

            if (toProperty.equals("name")){
                physicalSpacesTo = findBean.namePhysicalSpaces(toValue,em);
                f.line("to:"+toValue+":"+physicalSpacesTo.getName());
            } // physicalSpaces

            if (toProperty.equals("telExt")){
                physicalSpacesTo = findBean.telExtPhysicalSpaces(toValue,em);
                f.line("to:"+toValue+":"+physicalSpacesTo.getTelExt());
            } // physicalSpaces

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                physicalSpacesTo.setPredio(predioFrom);
            }

            if (!isValidate) {
                em.merge(physicalSpacesTo);
                em.flush();
            }

        } // from: Predio

        if (from.equals("Predio") &&
            cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
            to.equals("Predio") &&
            name.equals("")){

            Predio predioFrom = new Predio();
            Predio predioTo = new Predio();

            if (fromProperty.equals("nomenclatura")){
                predioFrom = findBean.nomenclaturaPredio(fromValue,em);
                f.line("from:"+fromValue+":"+predioFrom.getNomenclatura());
            } // predio

            if (fromProperty.equals("predial")){
                predioFrom = findBean.predialPredio(fromValue,em);
                f.line("from:"+fromValue+":"+predioFrom.getPredial());
            } // predio

            if (fromProperty.equals("code")){
                predioFrom = findBean.codePredio(fromValue,em);
                f.line("from:"+fromValue+":"+predioFrom.getCode());
            } // predio

            if (fromProperty.equals("estrato")){
                predioFrom = findBean.estratoPredio(fromValue,em);
                f.line("from:"+fromValue+":"+predioFrom.getEstrato());
            } // predio

            if (fromProperty.equals("matricula")){
                predioFrom = findBean.matriculaPredio(fromValue,em);
                f.line("from:"+fromValue+":"+predioFrom.getMatricula());
            } // predio

            if (toProperty.equals("nomenclatura")){
                predioTo = findBean.nomenclaturaPredio(toValue,em);
                f.line("to:"+toValue+":"+predioTo.getNomenclatura());
            } // predio

            if (toProperty.equals("predial")){
                predioTo = findBean.predialPredio(toValue,em);
                f.line("to:"+toValue+":"+predioTo.getPredial());
            } // predio

            if (toProperty.equals("code")){
                predioTo = findBean.codePredio(toValue,em);
                f.line("to:"+toValue+":"+predioTo.getCode());
            } // predio

            if (toProperty.equals("estrato")){
                predioTo = findBean.estratoPredio(toValue,em);
                f.line("to:"+toValue+":"+predioTo.getEstrato());
            } // predio

            if (toProperty.equals("matricula")){
                predioTo = findBean.matriculaPredio(toValue,em);
                f.line("to:"+toValue+":"+predioTo.getMatricula());
            } // predio

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                predioTo.setObjPadre(predioFrom);
            }

            if (!isValidate) {
                em.merge(predioTo);
                em.flush();
            }

        } // from: Predio

        if (from.equals("PhysicalSpaces") &&
            cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
            to.equals("PhysicalSpaces") &&
            name.equals("")){

            PhysicalSpaces physicalSpacesFrom = new PhysicalSpaces();
            PhysicalSpaces physicalSpacesTo = new PhysicalSpaces();

            if (fromProperty.equals("name")){
                physicalSpacesFrom = findBean.namePhysicalSpaces(fromValue,em);
                f.line("from:"+fromValue+":"+physicalSpacesFrom.getName());
            } // physicalSpaces

            if (fromProperty.equals("telExt")){
                physicalSpacesFrom = findBean.telExtPhysicalSpaces(fromValue,em);
                f.line("from:"+fromValue+":"+physicalSpacesFrom.getTelExt());
            } // physicalSpaces

            if (toProperty.equals("name")){
                physicalSpacesTo = findBean.namePhysicalSpaces(toValue,em);
                f.line("to:"+toValue+":"+physicalSpacesTo.getName());
            } // physicalSpaces

            if (toProperty.equals("telExt")){
                physicalSpacesTo = findBean.telExtPhysicalSpaces(toValue,em);
                f.line("to:"+toValue+":"+physicalSpacesTo.getTelExt());
            } // physicalSpaces

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                physicalSpacesTo.setObjPadre(physicalSpacesFrom);
            }

            if (!isValidate) {
                em.merge(physicalSpacesTo);
                em.flush();
            }

        } // from: PhysicalSpaces

        if (from.equals("PhysicalSpaces") &&
            cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
            to.equals("Employees") &&
            name.equals("")){

            PhysicalSpaces physicalSpacesFrom = new PhysicalSpaces();
            Employees employeesTo = new Employees();

            if (fromProperty.equals("name")){
                physicalSpacesFrom = findBean.namePhysicalSpaces(fromValue,em);
                f.line("from:"+fromValue+":"+physicalSpacesFrom.getName());
            } // physicalSpaces

            if (fromProperty.equals("telExt")){
                physicalSpacesFrom = findBean.telExtPhysicalSpaces(fromValue,em);
                f.line("from:"+fromValue+":"+physicalSpacesFrom.getTelExt());
            } // physicalSpaces

            if (toProperty.equals("code")){
                employeesTo = findBean.codeEmployees(toValue,em);
                f.line("to:"+toValue+":"+employeesTo.getCode());
            } // employees

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                employeesTo.setPhysicalSpaces(physicalSpacesFrom);
            }

            if (!isValidate) {
                em.merge(employeesTo);
                em.flush();
            }

        } // from: PhysicalSpaces

        if (from.equals("PhysicalSpaces") &&
            cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
            to.equals("Items") &&
            name.equals("")){

            PhysicalSpaces physicalSpacesFrom = new PhysicalSpaces();
            Items itemsTo = new Items();

            if (fromProperty.equals("name")){
                physicalSpacesFrom = findBean.namePhysicalSpaces(fromValue,em);
                f.line("from:"+fromValue+":"+physicalSpacesFrom.getName());
            } // physicalSpaces

            if (fromProperty.equals("telExt")){
                physicalSpacesFrom = findBean.telExtPhysicalSpaces(fromValue,em);
                f.line("from:"+fromValue+":"+physicalSpacesFrom.getTelExt());
            } // physicalSpaces

            if (toProperty.equals("cvNumber")){
                itemsTo = findBean.cvNumberItems(toValue,em);
                f.line("to:"+toValue+":"+itemsTo.getCvNumber());
            } // items

            if (toProperty.equals("code")){
                itemsTo = findBean.codeItems(toValue,em);
                f.line("to:"+toValue+":"+itemsTo.getCode());
            } // items

            if (toProperty.equals("inventoryCode")){
                itemsTo = findBean.inventoryCodeItems(toValue,em);
                f.line("to:"+toValue+":"+itemsTo.getInventoryCode());
            } // items

            if (toProperty.equals("serial")){
                itemsTo = findBean.serialItems(toValue,em);
                f.line("to:"+toValue+":"+itemsTo.getSerial());
            } // items

            if (toProperty.equals("eanCode")){
                itemsTo = findBean.eanCodeItems(toValue,em);
                f.line("to:"+toValue+":"+itemsTo.getEanCode());
            } // items

            if (toProperty.equals("located")){
                itemsTo = findBean.locatedItems(toValue,em);
                f.line("to:"+toValue+":"+itemsTo.getLocated());
            } // items

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                itemsTo.setPhysicalSpaces(physicalSpacesFrom);
            }

            if (!isValidate) {
                em.merge(itemsTo);
                em.flush();
            }

        } // from: PhysicalSpaces

        if (from.equals("PhysicalSpacesTypes") &&
            cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
            to.equals("PhysicalSpaces") &&
            name.equals("")){

            PhysicalSpacesTypes physicalSpacesTypesFrom = new PhysicalSpacesTypes();
            PhysicalSpaces physicalSpacesTo = new PhysicalSpaces();

            if (fromProperty.equals("name")){
                physicalSpacesTypesFrom = findBean.namePhysicalSpacesTypes(fromValue,em);
                f.line("from:"+fromValue+":"+physicalSpacesTypesFrom.getName());
            } // physicalSpacesTypes

            if (fromProperty.equals("code")){
                physicalSpacesTypesFrom = findBean.codePhysicalSpacesTypes(fromValue,em);
                f.line("from:"+fromValue+":"+physicalSpacesTypesFrom.getCode());
            } // physicalSpacesTypes

            if (toProperty.equals("name")){
                physicalSpacesTo = findBean.namePhysicalSpaces(toValue,em);
                f.line("to:"+toValue+":"+physicalSpacesTo.getName());
            } // physicalSpaces

            if (toProperty.equals("telExt")){
                physicalSpacesTo = findBean.telExtPhysicalSpaces(toValue,em);
                f.line("to:"+toValue+":"+physicalSpacesTo.getTelExt());
            } // physicalSpaces

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                physicalSpacesTo.setPhysicalSpacesTypes(physicalSpacesTypesFrom);
            }

            if (!isValidate) {
                em.merge(physicalSpacesTo);
                em.flush();
            }

        } // from: PhysicalSpacesTypes

        if (from.equals("PhysicalSpacesTypes") &&
            cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
            to.equals("PhysicalSpacesTypes") &&
            name.equals("")){

            PhysicalSpacesTypes physicalSpacesTypesFrom = new PhysicalSpacesTypes();
            PhysicalSpacesTypes physicalSpacesTypesTo = new PhysicalSpacesTypes();

            if (fromProperty.equals("name")){
                physicalSpacesTypesFrom = findBean.namePhysicalSpacesTypes(fromValue,em);
                f.line("from:"+fromValue+":"+physicalSpacesTypesFrom.getName());
            } // physicalSpacesTypes

            if (fromProperty.equals("code")){
                physicalSpacesTypesFrom = findBean.codePhysicalSpacesTypes(fromValue,em);
                f.line("from:"+fromValue+":"+physicalSpacesTypesFrom.getCode());
            } // physicalSpacesTypes

            if (toProperty.equals("name")){
                physicalSpacesTypesTo = findBean.namePhysicalSpacesTypes(toValue,em);
                f.line("to:"+toValue+":"+physicalSpacesTypesTo.getName());
            } // physicalSpacesTypes

            if (toProperty.equals("code")){
                physicalSpacesTypesTo = findBean.codePhysicalSpacesTypes(toValue,em);
                f.line("to:"+toValue+":"+physicalSpacesTypesTo.getCode());
            } // physicalSpacesTypes

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                physicalSpacesTypesTo.setObjPadre(physicalSpacesTypesFrom);
            }

            if (!isValidate) {
                em.merge(physicalSpacesTypesTo);
                em.flush();
            }

        } // from: PhysicalSpacesTypes

        if (from.equals("PhysicalAreas") &&
            cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
            to.equals("PhysicalAreas") &&
            name.equals("")){

            PhysicalAreas physicalAreasFrom = new PhysicalAreas();
            PhysicalAreas physicalAreasTo = new PhysicalAreas();

            if (fromProperty.equals("name")){
                physicalAreasFrom = findBean.namePhysicalAreas(fromValue,em);
                f.line("from:"+fromValue+":"+physicalAreasFrom.getName());
            } // physicalAreas

            if (fromProperty.equals("code")){
                physicalAreasFrom = findBean.codePhysicalAreas(fromValue,em);
                f.line("from:"+fromValue+":"+physicalAreasFrom.getCode());
            } // physicalAreas

            if (toProperty.equals("name")){
                physicalAreasTo = findBean.namePhysicalAreas(toValue,em);
                f.line("to:"+toValue+":"+physicalAreasTo.getName());
            } // physicalAreas

            if (toProperty.equals("code")){
                physicalAreasTo = findBean.codePhysicalAreas(toValue,em);
                f.line("to:"+toValue+":"+physicalAreasTo.getCode());
            } // physicalAreas

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                physicalAreasTo.setObjPadre(physicalAreasFrom);
            }

            if (!isValidate) {
                em.merge(physicalAreasTo);
                em.flush();
            }

        } // from: PhysicalAreas

        if (from.equals("PhysicalAreasTypes") &&
            cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
            to.equals("PhysicalAreas") &&
            name.equals("")){

            PhysicalAreasTypes physicalAreasTypesFrom = new PhysicalAreasTypes();
            PhysicalAreas physicalAreasTo = new PhysicalAreas();

            if (fromProperty.equals("name")){
                physicalAreasTypesFrom = findBean.namePhysicalAreasTypes(fromValue,em);
                f.line("from:"+fromValue+":"+physicalAreasTypesFrom.getName());
            } // physicalAreasTypes

            if (fromProperty.equals("code")){
                physicalAreasTypesFrom = findBean.codePhysicalAreasTypes(fromValue,em);
                f.line("from:"+fromValue+":"+physicalAreasTypesFrom.getCode());
            } // physicalAreasTypes

            if (toProperty.equals("name")){
                physicalAreasTo = findBean.namePhysicalAreas(toValue,em);
                f.line("to:"+toValue+":"+physicalAreasTo.getName());
            } // physicalAreas

            if (toProperty.equals("code")){
                physicalAreasTo = findBean.codePhysicalAreas(toValue,em);
                f.line("to:"+toValue+":"+physicalAreasTo.getCode());
            } // physicalAreas

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                physicalAreasTo.setPhysicalAreasTypes(physicalAreasTypesFrom);
            }

            if (!isValidate) {
                em.merge(physicalAreasTo);
                em.flush();
            }

        } // from: PhysicalAreasTypes

        if (from.equals("SectionsReports") &&
            cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
            to.equals("SeriesReports") &&
            name.equals("")){

            SectionsReports sectionsReportsFrom = new SectionsReports();
            SeriesReports seriesReportsTo = new SeriesReports();

            if (fromProperty.equals("name")){
                sectionsReportsFrom = findBean.nameSectionsReports(fromValue,em);
                f.line("from:"+fromValue+":"+sectionsReportsFrom.getName());
            } // sectionsReports

            if (fromProperty.equals("code")){
                sectionsReportsFrom = findBean.codeSectionsReports(fromValue,em);
                f.line("from:"+fromValue+":"+sectionsReportsFrom.getCode());
            } // sectionsReports

            if (toProperty.equals("name")){
                seriesReportsTo = findBean.nameSeriesReports(toValue,em);
                f.line("to:"+toValue+":"+seriesReportsTo.getName());
            } // seriesReports

            if (toProperty.equals("code")){
                seriesReportsTo = findBean.codeSeriesReports(toValue,em);
                f.line("to:"+toValue+":"+seriesReportsTo.getCode());
            } // seriesReports

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                seriesReportsTo.setSectionsReports(sectionsReportsFrom);
            }

            if (!isValidate) {
                em.merge(seriesReportsTo);
                em.flush();
            }

        } // from: SectionsReports

        if (from.equals("SeriesReports") &&
            cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
            to.equals("Reports") &&
            name.equals("")){

            SeriesReports seriesReportsFrom = new SeriesReports();
            Reports reportsTo = new Reports();

            if (fromProperty.equals("name")){
                seriesReportsFrom = findBean.nameSeriesReports(fromValue,em);
                f.line("from:"+fromValue+":"+seriesReportsFrom.getName());
            } // seriesReports

            if (fromProperty.equals("code")){
                seriesReportsFrom = findBean.codeSeriesReports(fromValue,em);
                f.line("from:"+fromValue+":"+seriesReportsFrom.getCode());
            } // seriesReports

            if (toProperty.equals("name")){
                reportsTo = findBean.nameReports(toValue,em);
                f.line("to:"+toValue+":"+reportsTo.getName());
            } // reports

            if (toProperty.equals("code")){
                reportsTo = findBean.codeReports(toValue,em);
                f.line("to:"+toValue+":"+reportsTo.getCode());
            } // reports

            if (toProperty.equals("link")){
                reportsTo = findBean.linkReports(toValue,em);
                f.line("to:"+toValue+":"+reportsTo.getLink());
            } // reports

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                reportsTo.setSeriesReports(seriesReportsFrom);
            }

            if (!isValidate) {
                em.merge(reportsTo);
                em.flush();
            }

        } // from: SeriesReports

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
            } // sitesTypes

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                sitesTypesTo.setObjPadre(sitesTypesFrom);
            }

            if (!isValidate) {
                em.merge(sitesTypesTo);
                em.flush();
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
            } // activities

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                activitiesTo.setActivitiesTypes(activitiesTypesFrom);
            }

            if (!isValidate) {
                em.merge(activitiesTo);
                em.flush();
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
            } // activities

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                activitiesTo.setObjPadre(activitiesFrom);
            }

            if (!isValidate) {
                em.merge(activitiesTo);
                em.flush();
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
            } // tasks

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                tasksTo.setActivities(activitiesFrom);
            }

            if (!isValidate) {
                em.merge(tasksTo);
                em.flush();
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
            } // diaries

            if (toProperty.equals("description")){
                diariesTo = findBean.descriptionDiaries(toValue,em);
                f.line("to:"+toValue+":"+diariesTo.getDescription());
            } // diaries

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                diariesTo.setTasks(tasksFrom);
            }

            if (!isValidate) {
                em.merge(diariesTo);
                em.flush();
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
            } // tasks

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                tasksTo.setPriorities(prioritiesFrom);
            }

            if (!isValidate) {
                em.merge(tasksTo);
                em.flush();
            }

        } // from: Priorities

    } // relationshipsR5Data

    public void relationshipsR7(String filePath,EntityManager em,Boolean isValidate,FileTxt f) {

        BufferedReader br = null;

        Integer i = 0;
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

    try {

        if (from.equals("Brands") &&
            cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
            to.equals("Sites") &&
            name.equals("")){

            Brands brands = new Brands();

            Set<Sites> sitess = new HashSet<Sites>();
            Sites sites = new Sites();

            anterior = "xyz";

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

               if (i > 1){

                  actual = data[2];
                  if (actual.equals(anterior)){
                      isCambio = false;
                  }
                  else {
                      isCambio = true;
                      ant = anterior;
                      anterior = actual;
                  }

                  if (isCambio){

                      f.line("cambio:"+ant);

                      if (sitess.size() > 0){

                          if (fromProperty.equals("name")){
                              brands = findBean.nameBrands(ant,em);
                              brands.setSites(sitess);

                          } // brands

                          if (!isValidate) {
                              em.merge(brands);
                              em.flush();
                          }
                      }

                      sitess = new HashSet<Sites>();
                      sites = new Sites();

                  } 

                  if (toProperty.equals("title")){
                      sites = findBean.titleSites(toValue,em);
                  } // sites

                  if (toProperty.equals("link")){
                      sites = findBean.linkSites(toValue,em);
                  } // sites

                  if (toProperty.equals("abc")){
                      sites = findBean.abcSites(toValue,em);
                  } // sites

                  if (toProperty.equals("ipAddress1")){
                      sites = findBean.ipAddress1Sites(toValue,em);
                  } // sites

                  if (toProperty.equals("ipAddress2")){
                      sites = findBean.ipAddress2Sites(toValue,em);
                  } // sites

                  if (toProperty.equals("ipAddress3")){
                      sites = findBean.ipAddress3Sites(toValue,em);
                  } // sites

                  sitess.add(sites);

                  f.line("from:"+fromValue+" to:"+toValue);

               } // i > 1

            } // while

            if (sitess.size() > 0){

               if (fromProperty.equals("name")){
                   brands = findBean.nameBrands(ant,em);
                   brands.setSites(sitess);

               } // sites

               if (!isValidate) {
                   em.merge(brands);
                   em.flush();
               }
            }

        } // from: Brands

        if (from.equals("Companies") &&
            cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
            to.equals("Sites") &&
            name.equals("")){

            Companies companies = new Companies();

            Set<Sites> sitess = new HashSet<Sites>();
            Sites sites = new Sites();

            anterior = "xyz";

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

               if (i > 1){

                  actual = data[2];
                  if (actual.equals(anterior)){
                      isCambio = false;
                  }
                  else {
                      isCambio = true;
                      ant = anterior;
                      anterior = actual;
                  }

                  if (isCambio){

                      f.line("cambio:"+ant);

                      if (sitess.size() > 0){

                          if (fromProperty.equals("name")){
                              companies = findBean.nameCompanies(ant,em);
                              companies.setSites(sitess);

                          } // companies

                          if (!isValidate) {
                              em.merge(companies);
                              em.flush();
                          }
                      }

                      sitess = new HashSet<Sites>();
                      sites = new Sites();

                  } 

                  if (toProperty.equals("title")){
                      sites = findBean.titleSites(toValue,em);
                  } // sites

                  if (toProperty.equals("link")){
                      sites = findBean.linkSites(toValue,em);
                  } // sites

                  if (toProperty.equals("abc")){
                      sites = findBean.abcSites(toValue,em);
                  } // sites

                  if (toProperty.equals("ipAddress1")){
                      sites = findBean.ipAddress1Sites(toValue,em);
                  } // sites

                  if (toProperty.equals("ipAddress2")){
                      sites = findBean.ipAddress2Sites(toValue,em);
                  } // sites

                  if (toProperty.equals("ipAddress3")){
                      sites = findBean.ipAddress3Sites(toValue,em);
                  } // sites

                  sitess.add(sites);

                  f.line("from:"+fromValue+" to:"+toValue);

               } // i > 1

            } // while

            if (sitess.size() > 0){

               if (fromProperty.equals("name")){
                   companies = findBean.nameCompanies(ant,em);
                   companies.setSites(sitess);

               } // sites

               if (!isValidate) {
                   em.merge(companies);
                   em.flush();
               }
            }

        } // from: Companies

        if (from.equals("Employees") &&
            cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
            to.equals("Charges") &&
            name.equals("")){

            Employees employees = new Employees();

            Set<Charges> chargess = new HashSet<Charges>();
            Charges charges = new Charges();

            anterior = "xyz";

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

               if (i > 1){

                  actual = data[2];
                  if (actual.equals(anterior)){
                      isCambio = false;
                  }
                  else {
                      isCambio = true;
                      ant = anterior;
                      anterior = actual;
                  }

                  if (isCambio){

                      f.line("cambio:"+ant);

                      if (chargess.size() > 0){

                          if (fromProperty.equals("code")){
                              employees = findBean.codeEmployees(ant,em);
                              employees.setCharges(chargess);

                          } // employees

                          if (!isValidate) {
                              em.merge(employees);
                              em.flush();
                          }
                      }

                      chargess = new HashSet<Charges>();
                      charges = new Charges();

                  } 

                  if (toProperty.equals("name")){
                      charges = findBean.nameCharges(toValue,em);
                  } // charges

                  chargess.add(charges);

                  f.line("from:"+fromValue+" to:"+toValue);

               } // i > 1

            } // while

            if (chargess.size() > 0){

               if (fromProperty.equals("code")){
                   employees = findBean.codeEmployees(ant,em);
                   employees.setCharges(chargess);

               } // charges

               if (!isValidate) {
                   em.merge(employees);
                   em.flush();
               }
            }

        } // from: Employees

        if (from.equals("Charges") &&
            cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
            to.equals("CompaniesRoles") &&
            name.equals("")){

            Charges charges = new Charges();

            Set<CompaniesRoles> companiesRoless = new HashSet<CompaniesRoles>();
            CompaniesRoles companiesRoles = new CompaniesRoles();

            anterior = "xyz";

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

               if (i > 1){

                  actual = data[2];
                  if (actual.equals(anterior)){
                      isCambio = false;
                  }
                  else {
                      isCambio = true;
                      ant = anterior;
                      anterior = actual;
                  }

                  if (isCambio){

                      f.line("cambio:"+ant);

                      if (companiesRoless.size() > 0){

                          if (fromProperty.equals("name")){
                              charges = findBean.nameCharges(ant,em);
                              charges.setCompaniesRoles(companiesRoless);

                          } // charges

                          if (!isValidate) {
                              em.merge(charges);
                              em.flush();
                          }
                      }

                      companiesRoless = new HashSet<CompaniesRoles>();
                      companiesRoles = new CompaniesRoles();

                  } 

                  if (toProperty.equals("name")){
                      companiesRoles = findBean.nameCompaniesRoles(toValue,em);
                  } // companiesRoles

                  companiesRoless.add(companiesRoles);

                  f.line("from:"+fromValue+" to:"+toValue);

               } // i > 1

            } // while

            if (companiesRoless.size() > 0){

               if (fromProperty.equals("name")){
                   charges = findBean.nameCharges(ant,em);
                   charges.setCompaniesRoles(companiesRoless);

               } // companiesRoles

               if (!isValidate) {
                   em.merge(charges);
                   em.flush();
               }
            }

        } // from: Charges

        if (from.equals("ModelsCanvas") &&
            cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
            to.equals("ModelsCanvasSections") &&
            name.equals("")){

            ModelsCanvas modelsCanvas = new ModelsCanvas();

            Set<ModelsCanvasSections> modelsCanvasSectionss = new HashSet<ModelsCanvasSections>();
            ModelsCanvasSections modelsCanvasSections = new ModelsCanvasSections();

            anterior = "xyz";

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

               if (i > 1){

                  actual = data[2];
                  if (actual.equals(anterior)){
                      isCambio = false;
                  }
                  else {
                      isCambio = true;
                      ant = anterior;
                      anterior = actual;
                  }

                  if (isCambio){

                      f.line("cambio:"+ant);

                      if (modelsCanvasSectionss.size() > 0){

                          if (fromProperty.equals("name")){
                              modelsCanvas = findBean.nameModelsCanvas(ant,em);
                              modelsCanvas.setModelsCanvasSections(modelsCanvasSectionss);

                          } // modelsCanvas

                          if (!isValidate) {
                              em.merge(modelsCanvas);
                              em.flush();
                          }
                      }

                      modelsCanvasSectionss = new HashSet<ModelsCanvasSections>();
                      modelsCanvasSections = new ModelsCanvasSections();

                  } 

                  if (toProperty.equals("name")){
                      modelsCanvasSections = findBean.nameModelsCanvasSections(toValue,em);
                  } // modelsCanvasSections

                  modelsCanvasSectionss.add(modelsCanvasSections);

                  f.line("from:"+fromValue+" to:"+toValue);

               } // i > 1

            } // while

            if (modelsCanvasSectionss.size() > 0){

               if (fromProperty.equals("name")){
                   modelsCanvas = findBean.nameModelsCanvas(ant,em);
                   modelsCanvas.setModelsCanvasSections(modelsCanvasSectionss);

               } // modelsCanvasSections

               if (!isValidate) {
                   em.merge(modelsCanvas);
                   em.flush();
               }
            }

        } // from: ModelsCanvas

        if (from.equals("PhysicalSpaces") &&
            cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
            to.equals("PhysicalAreas") &&
            name.equals("")){

            PhysicalSpaces physicalSpaces = new PhysicalSpaces();

            Set<PhysicalAreas> physicalAreass = new HashSet<PhysicalAreas>();
            PhysicalAreas physicalAreas = new PhysicalAreas();

            anterior = "xyz";

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

               if (i > 1){

                  actual = data[2];
                  if (actual.equals(anterior)){
                      isCambio = false;
                  }
                  else {
                      isCambio = true;
                      ant = anterior;
                      anterior = actual;
                  }

                  if (isCambio){

                      f.line("cambio:"+ant);

                      if (physicalAreass.size() > 0){

                          if (fromProperty.equals("name")){
                              physicalSpaces = findBean.namePhysicalSpaces(ant,em);
                              physicalSpaces.setPhysicalAreas(physicalAreass);

                          } // physicalSpaces

                          if (fromProperty.equals("telExt")){
                              physicalSpaces = findBean.telExtPhysicalSpaces(ant,em);
                              physicalSpaces.setPhysicalAreas(physicalAreass);

                          } // physicalSpaces

                          if (!isValidate) {
                              em.merge(physicalSpaces);
                              em.flush();
                          }
                      }

                      physicalAreass = new HashSet<PhysicalAreas>();
                      physicalAreas = new PhysicalAreas();

                  } 

                  if (toProperty.equals("name")){
                      physicalAreas = findBean.namePhysicalAreas(toValue,em);
                  } // physicalAreas

                  if (toProperty.equals("code")){
                      physicalAreas = findBean.codePhysicalAreas(toValue,em);
                  } // physicalAreas

                  physicalAreass.add(physicalAreas);

                  f.line("from:"+fromValue+" to:"+toValue);

               } // i > 1

            } // while

            if (physicalAreass.size() > 0){

               if (fromProperty.equals("name")){
                   physicalSpaces = findBean.namePhysicalSpaces(ant,em);
                   physicalSpaces.setPhysicalAreas(physicalAreass);

               } // physicalAreas

               if (fromProperty.equals("telExt")){
                   physicalSpaces = findBean.telExtPhysicalSpaces(ant,em);
                   physicalSpaces.setPhysicalAreas(physicalAreass);

               } // physicalAreas

               if (!isValidate) {
                   em.merge(physicalSpaces);
                   em.flush();
               }
            }

        } // from: PhysicalSpaces

        if (from.equals("Sites") &&
            cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
            to.equals("SitesTypes") &&
            name.equals("")){

            Sites sites = new Sites();

            Set<SitesTypes> sitesTypess = new HashSet<SitesTypes>();
            SitesTypes sitesTypes = new SitesTypes();

            anterior = "xyz";

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

               if (i > 1){

                  actual = data[2];
                  if (actual.equals(anterior)){
                      isCambio = false;
                  }
                  else {
                      isCambio = true;
                      ant = anterior;
                      anterior = actual;
                  }

                  if (isCambio){

                      f.line("cambio:"+ant);

                      if (sitesTypess.size() > 0){

                          if (fromProperty.equals("title")){
                              sites = findBean.titleSites(ant,em);
                              sites.setSitesTypes(sitesTypess);

                          } // sites

                          if (fromProperty.equals("link")){
                              sites = findBean.linkSites(ant,em);
                              sites.setSitesTypes(sitesTypess);

                          } // sites

                          if (fromProperty.equals("abc")){
                              sites = findBean.abcSites(ant,em);
                              sites.setSitesTypes(sitesTypess);

                          } // sites

                          if (fromProperty.equals("ipAddress1")){
                              sites = findBean.ipAddress1Sites(ant,em);
                              sites.setSitesTypes(sitesTypess);

                          } // sites

                          if (fromProperty.equals("ipAddress2")){
                              sites = findBean.ipAddress2Sites(ant,em);
                              sites.setSitesTypes(sitesTypess);

                          } // sites

                          if (fromProperty.equals("ipAddress3")){
                              sites = findBean.ipAddress3Sites(ant,em);
                              sites.setSitesTypes(sitesTypess);

                          } // sites

                          if (!isValidate) {
                              em.merge(sites);
                              em.flush();
                          }
                      }

                      sitesTypess = new HashSet<SitesTypes>();
                      sitesTypes = new SitesTypes();

                  } 

                  if (toProperty.equals("name")){
                      sitesTypes = findBean.nameSitesTypes(toValue,em);
                  } // sitesTypes

                  sitesTypess.add(sitesTypes);

                  f.line("from:"+fromValue+" to:"+toValue);

               } // i > 1

            } // while

            if (sitesTypess.size() > 0){

               if (fromProperty.equals("title")){
                   sites = findBean.titleSites(ant,em);
                   sites.setSitesTypes(sitesTypess);

               } // sitesTypes

               if (fromProperty.equals("link")){
                   sites = findBean.linkSites(ant,em);
                   sites.setSitesTypes(sitesTypess);

               } // sitesTypes

               if (fromProperty.equals("abc")){
                   sites = findBean.abcSites(ant,em);
                   sites.setSitesTypes(sitesTypess);

               } // sitesTypes

               if (fromProperty.equals("ipAddress1")){
                   sites = findBean.ipAddress1Sites(ant,em);
                   sites.setSitesTypes(sitesTypess);

               } // sitesTypes

               if (fromProperty.equals("ipAddress2")){
                   sites = findBean.ipAddress2Sites(ant,em);
                   sites.setSitesTypes(sitesTypess);

               } // sitesTypes

               if (fromProperty.equals("ipAddress3")){
                   sites = findBean.ipAddress3Sites(ant,em);
                   sites.setSitesTypes(sitesTypess);

               } // sitesTypes

               if (!isValidate) {
                   em.merge(sites);
                   em.flush();
               }
            }

        } // from: Sites

        if (from.equals("Activities") &&
            cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
            to.equals("Calendars") &&
            name.equals("")){

            Activities activities = new Activities();

            Set<Calendars> calendarss = new HashSet<Calendars>();
            Calendars calendars = new Calendars();

            anterior = "xyz";

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

               if (i > 1){

                  actual = data[2];
                  if (actual.equals(anterior)){
                      isCambio = false;
                  }
                  else {
                      isCambio = true;
                      ant = anterior;
                      anterior = actual;
                  }

                  if (isCambio){

                      f.line("cambio:"+ant);

                      if (calendarss.size() > 0){

                          if (fromProperty.equals("name")){
                              activities = findBean.nameActivities(ant,em);
                              activities.setCalendars(calendarss);

                          } // activities

                          if (!isValidate) {
                              em.merge(activities);
                              em.flush();
                          }
                      }

                      calendarss = new HashSet<Calendars>();
                      calendars = new Calendars();

                  } 

                  if (toProperty.equals("name")){
                      calendars = findBean.nameCalendars(toValue,em);
                  } // calendars

                  calendarss.add(calendars);

                  f.line("from:"+fromValue+" to:"+toValue);

               } // i > 1

            } // while

            if (calendarss.size() > 0){

               if (fromProperty.equals("name")){
                   activities = findBean.nameActivities(ant,em);
                   activities.setCalendars(calendarss);

               } // calendars

               if (!isValidate) {
                   em.merge(activities);
                   em.flush();
               }
            }

        } // from: Activities

        if (from.equals("Activities") &&
            cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
            to.equals("Sites") &&
            name.equals("")){

            Activities activities = new Activities();

            Set<Sites> sitess = new HashSet<Sites>();
            Sites sites = new Sites();

            anterior = "xyz";

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

               if (i > 1){

                  actual = data[2];
                  if (actual.equals(anterior)){
                      isCambio = false;
                  }
                  else {
                      isCambio = true;
                      ant = anterior;
                      anterior = actual;
                  }

                  if (isCambio){

                      f.line("cambio:"+ant);

                      if (sitess.size() > 0){

                          if (fromProperty.equals("name")){
                              activities = findBean.nameActivities(ant,em);
                              activities.setSites(sitess);

                          } // activities

                          if (!isValidate) {
                              em.merge(activities);
                              em.flush();
                          }
                      }

                      sitess = new HashSet<Sites>();
                      sites = new Sites();

                  } 

                  if (toProperty.equals("title")){
                      sites = findBean.titleSites(toValue,em);
                  } // sites

                  if (toProperty.equals("link")){
                      sites = findBean.linkSites(toValue,em);
                  } // sites

                  if (toProperty.equals("abc")){
                      sites = findBean.abcSites(toValue,em);
                  } // sites

                  if (toProperty.equals("ipAddress1")){
                      sites = findBean.ipAddress1Sites(toValue,em);
                  } // sites

                  if (toProperty.equals("ipAddress2")){
                      sites = findBean.ipAddress2Sites(toValue,em);
                  } // sites

                  if (toProperty.equals("ipAddress3")){
                      sites = findBean.ipAddress3Sites(toValue,em);
                  } // sites

                  sitess.add(sites);

                  f.line("from:"+fromValue+" to:"+toValue);

               } // i > 1

            } // while

            if (sitess.size() > 0){

               if (fromProperty.equals("name")){
                   activities = findBean.nameActivities(ant,em);
                   activities.setSites(sitess);

               } // sites

               if (!isValidate) {
                   em.merge(activities);
                   em.flush();
               }
            }

        } // from: Activities

        if (from.equals("Tasks") &&
            cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
            to.equals("Sites") &&
            name.equals("")){

            Tasks tasks = new Tasks();

            Set<Sites> sitess = new HashSet<Sites>();
            Sites sites = new Sites();

            anterior = "xyz";

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

               if (i > 1){

                  actual = data[2];
                  if (actual.equals(anterior)){
                      isCambio = false;
                  }
                  else {
                      isCambio = true;
                      ant = anterior;
                      anterior = actual;
                  }

                  if (isCambio){

                      f.line("cambio:"+ant);

                      if (sitess.size() > 0){

                          if (fromProperty.equals("name")){
                              tasks = findBean.nameTasks(ant,em);
                              tasks.setSites(sitess);

                          } // tasks

                          if (!isValidate) {
                              em.merge(tasks);
                              em.flush();
                          }
                      }

                      sitess = new HashSet<Sites>();
                      sites = new Sites();

                  } 

                  if (toProperty.equals("title")){
                      sites = findBean.titleSites(toValue,em);
                  } // sites

                  if (toProperty.equals("link")){
                      sites = findBean.linkSites(toValue,em);
                  } // sites

                  if (toProperty.equals("abc")){
                      sites = findBean.abcSites(toValue,em);
                  } // sites

                  if (toProperty.equals("ipAddress1")){
                      sites = findBean.ipAddress1Sites(toValue,em);
                  } // sites

                  if (toProperty.equals("ipAddress2")){
                      sites = findBean.ipAddress2Sites(toValue,em);
                  } // sites

                  if (toProperty.equals("ipAddress3")){
                      sites = findBean.ipAddress3Sites(toValue,em);
                  } // sites

                  sitess.add(sites);

                  f.line("from:"+fromValue+" to:"+toValue);

               } // i > 1

            } // while

            if (sitess.size() > 0){

               if (fromProperty.equals("name")){
                   tasks = findBean.nameTasks(ant,em);
                   tasks.setSites(sitess);

               } // sites

               if (!isValidate) {
                   em.merge(tasks);
                   em.flush();
               }
            }

        } // from: Tasks

        if (from.equals("Diaries") &&
            cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
            to.equals("Sites") &&
            name.equals("")){

            Diaries diaries = new Diaries();

            Set<Sites> sitess = new HashSet<Sites>();
            Sites sites = new Sites();

            anterior = "xyz";

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

               if (i > 1){

                  actual = data[2];
                  if (actual.equals(anterior)){
                      isCambio = false;
                  }
                  else {
                      isCambio = true;
                      ant = anterior;
                      anterior = actual;
                  }

                  if (isCambio){

                      f.line("cambio:"+ant);

                      if (sitess.size() > 0){

                          if (fromProperty.equals("name")){
                              diaries = findBean.nameDiaries(ant,em);
                              diaries.setSites(sitess);

                          } // diaries

                          if (fromProperty.equals("description")){
                              diaries = findBean.descriptionDiaries(ant,em);
                              diaries.setSites(sitess);

                          } // diaries

                          if (!isValidate) {
                              em.merge(diaries);
                              em.flush();
                          }
                      }

                      sitess = new HashSet<Sites>();
                      sites = new Sites();

                  } 

                  if (toProperty.equals("title")){
                      sites = findBean.titleSites(toValue,em);
                  } // sites

                  if (toProperty.equals("link")){
                      sites = findBean.linkSites(toValue,em);
                  } // sites

                  if (toProperty.equals("abc")){
                      sites = findBean.abcSites(toValue,em);
                  } // sites

                  if (toProperty.equals("ipAddress1")){
                      sites = findBean.ipAddress1Sites(toValue,em);
                  } // sites

                  if (toProperty.equals("ipAddress2")){
                      sites = findBean.ipAddress2Sites(toValue,em);
                  } // sites

                  if (toProperty.equals("ipAddress3")){
                      sites = findBean.ipAddress3Sites(toValue,em);
                  } // sites

                  sitess.add(sites);

                  f.line("from:"+fromValue+" to:"+toValue);

               } // i > 1

            } // while

            if (sitess.size() > 0){

               if (fromProperty.equals("name")){
                   diaries = findBean.nameDiaries(ant,em);
                   diaries.setSites(sitess);

               } // sites

               if (fromProperty.equals("description")){
                   diaries = findBean.descriptionDiaries(ant,em);
                   diaries.setSites(sitess);

               } // sites

               if (!isValidate) {
                   em.merge(diaries);
                   em.flush();
               }
            }

        } // from: Diaries

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
