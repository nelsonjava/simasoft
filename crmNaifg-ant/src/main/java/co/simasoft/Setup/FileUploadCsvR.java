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

    @PersistenceContext(unitName = "crmNaifgPU-JTA")
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
        String cvsSplitBy = ",";
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
            } // dependencies

            if (toProperty.equals("artifactId")){
                dependenciesTo = findBean.artifactIdDependencies(toValue,em);
                f.line("to:"+toValue+":"+dependenciesTo.getArtifactId());
            } // dependencies

            if (toProperty.equals("version")){
                dependenciesTo = findBean.versionDependencies(toValue,em);
                f.line("to:"+toValue+":"+dependenciesTo.getVersion());
            } // dependencies

            if (toProperty.equals("type")){
                dependenciesTo = findBean.typeDependencies(toValue,em);
                f.line("to:"+toValue+":"+dependenciesTo.getType());
            } // dependencies

            if (toProperty.equals("scope")){
                dependenciesTo = findBean.scopeDependencies(toValue,em);
                f.line("to:"+toValue+":"+dependenciesTo.getScope());
            } // dependencies

            if (toProperty.equals("maven")){
                dependenciesTo = findBean.mavenDependencies(toValue,em);
                f.line("to:"+toValue+":"+dependenciesTo.getMaven());
            } // dependencies

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                dependenciesTo.setPom(pomFrom);
            }

            if (!isValidate) {
                em.merge(dependenciesTo);
                em.flush();
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
            } // imports

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                importsTo.setDependencies(dependenciesFrom);
            }

            if (!isValidate) {
                em.merge(importsTo);
                em.flush();
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
            } // fields

            if (toProperty.equals("description")){
                fieldsTo = findBean.descriptionFields(toValue,em);
                f.line("to:"+toValue+":"+fieldsTo.getDescription());
            } // fields

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                fieldsTo.setAttributesTypes(attributesTypesFrom);
            }

            if (!isValidate) {
                em.merge(fieldsTo);
                em.flush();
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
            } // modelRelationships

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                modelRelationshipsTo.setModels(modelsFrom);
            }

            if (!isValidate) {
                em.merge(modelRelationshipsTo);
                em.flush();
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
            } // modelRelationships

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                modelRelationshipsTo.setRelationships(relationshipsFrom);
            }

            if (!isValidate) {
                em.merge(modelRelationshipsTo);
                em.flush();
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
            } // cardinalities

            if (toProperty.equals("cardinality")){
                cardinalitiesTo = findBean.cardinalityCardinalities(toValue,em);
                f.line("to:"+toValue+":"+cardinalitiesTo.getCardinality());
            } // cardinalities

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                cardinalitiesTo.setObjPadre(cardinalitiesFrom);
            }

            if (!isValidate) {
                em.merge(cardinalitiesTo);
                em.flush();
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
            } // relationships

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                relationshipsTo.setCardinalities(cardinalitiesFrom);
            }

            if (!isValidate) {
                em.merge(relationshipsTo);
                em.flush();
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
            } // relationships

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                relationshipsTo.setFrom(entitiesFrom);
            }

            if (!isValidate) {
                em.merge(relationshipsTo);
                em.flush();
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
            } // attributes

            if (toProperty.equals("description")){
                attributesTo = findBean.descriptionAttributes(toValue,em);
                f.line("to:"+toValue+":"+attributesTo.getDescription());
            } // attributes

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                attributesTo.setEntities(entitiesFrom);
            }

            if (!isValidate) {
                em.merge(attributesTo);
                em.flush();
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
            } // relationships

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                relationshipsTo.setTo(entitiesFrom);
            }

            if (!isValidate) {
                em.merge(relationshipsTo);
                em.flush();
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
            } // models

            if (toProperty.equals("code")){
                modelsTo = findBean.codeModels(toValue,em);
                f.line("to:"+toValue+":"+modelsTo.getCode());
            } // models

            if (toProperty.equals("version")){
                modelsTo = findBean.versionModels(toValue,em);
                f.line("to:"+toValue+":"+modelsTo.getVersion());
            } // models

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                modelsTo.setGroupIds(groupIdsFrom);
            }

            if (!isValidate) {
                em.merge(modelsTo);
                em.flush();
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
            } // entities

            if (toProperty.equals("serialID")){
                entitiesTo = findBean.serialIDEntities(toValue,em);
                f.line("to:"+toValue+":"+entitiesTo.getSerialID());
            } // entities

            if (toProperty.equals("table")){
                entitiesTo = findBean.tableEntities(toValue,em);
                f.line("to:"+toValue+":"+entitiesTo.getTable());
            } // entities

            if (toProperty.equals("description")){
                entitiesTo = findBean.descriptionEntities(toValue,em);
                f.line("to:"+toValue+":"+entitiesTo.getDescription());
            } // entities

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                entitiesTo.setGroupIds(groupIdsFrom);
            }

            if (!isValidate) {
                em.merge(entitiesTo);
                em.flush();
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
            } // modelsGroups

            if (toProperty.equals("code")){
                modelsGroupsTo = findBean.codeModelsGroups(toValue,em);
                f.line("to:"+toValue+":"+modelsGroupsTo.getCode());
            } // modelsGroups

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                modelsGroupsTo.setGroupIdsTypes(groupIdsTypesFrom);
            }

            if (!isValidate) {
                em.merge(modelsGroupsTo);
                em.flush();
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
            } // groupIds

            if (toProperty.equals("groupId")){
                groupIdsTo = findBean.groupIdGroupIds(toValue,em);
                f.line("to:"+toValue+":"+groupIdsTo.getGroupId());
            } // groupIds

            if (toProperty.equals("version")){
                groupIdsTo = findBean.versionGroupIds(toValue,em);
                f.line("to:"+toValue+":"+groupIdsTo.getVersion());
            } // groupIds

            if (toProperty.equals("code")){
                groupIdsTo = findBean.codeGroupIds(toValue,em);
                f.line("to:"+toValue+":"+groupIdsTo.getCode());
            } // groupIds

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                groupIdsTo.setGroupIdsTypes(groupIdsTypesFrom);
            }

            if (!isValidate) {
                em.merge(groupIdsTo);
                em.flush();
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
        Integer j = 0;
        String line = "";
        String cvsSplitBy = ",";
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

        Brands brands = new Brands();
        Sites sites = new Sites();
        Companies companies = new Companies();
        Employees employees = new Employees();
        Charges charges = new Charges();
        CompaniesRoles companiesRoles = new CompaniesRoles();
        Dependencies dependencies = new Dependencies();
        Imports imports = new Imports();
        AttributesProperties attributesProperties = new AttributesProperties();
        AttributesTypes attributesTypes = new AttributesTypes();
        Developments developments = new Developments();
        ModelsGroups modelsGroups = new ModelsGroups();
        Models models = new Models();
        SitesTypes sitesTypes = new SitesTypes();
        Activities activities = new Activities();
        Calendars calendars = new Calendars();
        Tasks tasks = new Tasks();
        Diaries diaries = new Diaries();

        Set<Sites> sitess = new HashSet<Sites>();
        Set<Charges> chargess = new HashSet<Charges>();
        Set<CompaniesRoles> companiesRoless = new HashSet<CompaniesRoles>();
        Set<Imports> importss = new HashSet<Imports>();
        Set<AttributesProperties> attributesPropertiess = new HashSet<AttributesProperties>();
        Set<ModelsGroups> modelsGroupss = new HashSet<ModelsGroups>();
        Set<Models> modelss = new HashSet<Models>();
        Set<SitesTypes> sitesTypess = new HashSet<SitesTypes>();
        Set<Calendars> calendarss = new HashSet<Calendars>();

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

           if (from.equals("Brands") &&
               cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
               to.equals("Sites") &&
               Utils.isEmpty(name)){

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

                          if (fromProperty.equals("title")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getTitle());
                              }

                          } // brands

                          if (fromProperty.equals("link")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getLink());
                              }

                          } // brands

                          if (fromProperty.equals("abc")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getAbc());
                              }

                          } // brands

                          if (fromProperty.equals("ipAddress1")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress1());
                              }

                          } // brands

                          if (fromProperty.equals("ipAddress2")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress2());
                              }

                          } // brands

                          if (fromProperty.equals("ipAddress3")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress3());
                              }

                          } // brands

                      }

                  } // size()

                  sitess = new HashSet<Sites>();
                  sites = new Sites();

               } // isCambio 

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

           } // from: Brands

           if (from.equals("Companies") &&
               cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
               to.equals("Sites") &&
               Utils.isEmpty(name)){

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

                          if (fromProperty.equals("title")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getTitle());
                              }

                          } // companies

                          if (fromProperty.equals("link")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getLink());
                              }

                          } // companies

                          if (fromProperty.equals("abc")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getAbc());
                              }

                          } // companies

                          if (fromProperty.equals("ipAddress1")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress1());
                              }

                          } // companies

                          if (fromProperty.equals("ipAddress2")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress2());
                              }

                          } // companies

                          if (fromProperty.equals("ipAddress3")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress3());
                              }

                          } // companies

                      }

                  } // size()

                  sitess = new HashSet<Sites>();
                  sites = new Sites();

               } // isCambio 

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

           } // from: Companies

           if (from.equals("Employees") &&
               cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
               to.equals("Charges") &&
               Utils.isEmpty(name)){

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

                          if (fromProperty.equals("name")){
                              j = 0;
                              for(Charges chargesx : chargess){
                                  f.line("       "+Integer.toString(++j)+":"+chargesx.getName());
                              }

                          } // employees

                      }

                  } // size()

                  chargess = new HashSet<Charges>();
                  charges = new Charges();

               } // isCambio 

              if (toProperty.equals("name")){
                  charges = findBean.nameCharges(toValue,em);
              } // charges

              chargess.add(charges);

           } // from: Employees

           if (from.equals("Charges") &&
               cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
               to.equals("CompaniesRoles") &&
               Utils.isEmpty(name)){

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

                          if (fromProperty.equals("name")){
                              j = 0;
                              for(CompaniesRoles companiesRolesx : companiesRoless){
                                  f.line("       "+Integer.toString(++j)+":"+companiesRolesx.getName());
                              }

                          } // charges

                      }

                  } // size()

                  companiesRoless = new HashSet<CompaniesRoles>();
                  companiesRoles = new CompaniesRoles();

               } // isCambio 

              if (toProperty.equals("name")){
                  companiesRoles = findBean.nameCompaniesRoles(toValue,em);
              } // companiesRoles

              companiesRoless.add(companiesRoles);

           } // from: Charges

           if (from.equals("Dependencies") &&
               cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
               to.equals("Sites") &&
               Utils.isEmpty(name)){

               if (isCambio){

                  f.line("cambio:"+ant);

                  if (sitess.size() > 0){

                      if (fromProperty.equals("groupId")){
                          dependencies = findBean.groupIdDependencies(ant,em);
                          dependencies.setSites(sitess);

                      } // dependencies

                      if (fromProperty.equals("artifactId")){
                          dependencies = findBean.artifactIdDependencies(ant,em);
                          dependencies.setSites(sitess);

                      } // dependencies

                      if (fromProperty.equals("version")){
                          dependencies = findBean.versionDependencies(ant,em);
                          dependencies.setSites(sitess);

                      } // dependencies

                      if (fromProperty.equals("type")){
                          dependencies = findBean.typeDependencies(ant,em);
                          dependencies.setSites(sitess);

                      } // dependencies

                      if (fromProperty.equals("scope")){
                          dependencies = findBean.scopeDependencies(ant,em);
                          dependencies.setSites(sitess);

                      } // dependencies

                      if (fromProperty.equals("maven")){
                          dependencies = findBean.mavenDependencies(ant,em);
                          dependencies.setSites(sitess);

                      } // dependencies

                      if (!isValidate) {

                          em.merge(dependencies);
                          em.flush();

                          if (fromProperty.equals("title")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getTitle());
                              }

                          } // dependencies

                          if (fromProperty.equals("link")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getLink());
                              }

                          } // dependencies

                          if (fromProperty.equals("abc")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getAbc());
                              }

                          } // dependencies

                          if (fromProperty.equals("ipAddress1")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress1());
                              }

                          } // dependencies

                          if (fromProperty.equals("ipAddress2")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress2());
                              }

                          } // dependencies

                          if (fromProperty.equals("ipAddress3")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress3());
                              }

                          } // dependencies

                      }

                  } // size()

                  sitess = new HashSet<Sites>();
                  sites = new Sites();

               } // isCambio 

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

           } // from: Dependencies

           if (from.equals("Imports") &&
               cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
               to.equals("Sites") &&
               Utils.isEmpty(name)){

               if (isCambio){

                  f.line("cambio:"+ant);

                  if (sitess.size() > 0){

                      if (fromProperty.equals("name")){
                          imports = findBean.nameImports(ant,em);
                          imports.setSites(sitess);

                      } // imports

                      if (!isValidate) {

                          em.merge(imports);
                          em.flush();

                          if (fromProperty.equals("title")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getTitle());
                              }

                          } // imports

                          if (fromProperty.equals("link")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getLink());
                              }

                          } // imports

                          if (fromProperty.equals("abc")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getAbc());
                              }

                          } // imports

                          if (fromProperty.equals("ipAddress1")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress1());
                              }

                          } // imports

                          if (fromProperty.equals("ipAddress2")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress2());
                              }

                          } // imports

                          if (fromProperty.equals("ipAddress3")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress3());
                              }

                          } // imports

                      }

                  } // size()

                  sitess = new HashSet<Sites>();
                  sites = new Sites();

               } // isCambio 

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

           } // from: Imports

           if (from.equals("AttributesProperties") &&
               cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
               to.equals("Sites") &&
               Utils.isEmpty(name)){

               if (isCambio){

                  f.line("cambio:"+ant);

                  if (sitess.size() > 0){

                      if (fromProperty.equals("name")){
                          attributesProperties = findBean.nameAttributesProperties(ant,em);
                          attributesProperties.setSites(sitess);

                      } // attributesProperties

                      if (fromProperty.equals("value")){
                          attributesProperties = findBean.valueAttributesProperties(ant,em);
                          attributesProperties.setSites(sitess);

                      } // attributesProperties

                      if (!isValidate) {

                          em.merge(attributesProperties);
                          em.flush();

                          if (fromProperty.equals("title")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getTitle());
                              }

                          } // attributesProperties

                          if (fromProperty.equals("link")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getLink());
                              }

                          } // attributesProperties

                          if (fromProperty.equals("abc")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getAbc());
                              }

                          } // attributesProperties

                          if (fromProperty.equals("ipAddress1")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress1());
                              }

                          } // attributesProperties

                          if (fromProperty.equals("ipAddress2")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress2());
                              }

                          } // attributesProperties

                          if (fromProperty.equals("ipAddress3")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress3());
                              }

                          } // attributesProperties

                      }

                  } // size()

                  sitess = new HashSet<Sites>();
                  sites = new Sites();

               } // isCambio 

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

           } // from: AttributesProperties

           if (from.equals("AttributesProperties") &&
               cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
               to.equals("Imports") &&
               Utils.isEmpty(name)){

               if (isCambio){

                  f.line("cambio:"+ant);

                  if (importss.size() > 0){

                      if (fromProperty.equals("name")){
                          attributesProperties = findBean.nameAttributesProperties(ant,em);
                          attributesProperties.setImports(importss);

                      } // attributesProperties

                      if (fromProperty.equals("value")){
                          attributesProperties = findBean.valueAttributesProperties(ant,em);
                          attributesProperties.setImports(importss);

                      } // attributesProperties

                      if (!isValidate) {

                          em.merge(attributesProperties);
                          em.flush();

                          if (fromProperty.equals("name")){
                              j = 0;
                              for(Imports importsx : importss){
                                  f.line("       "+Integer.toString(++j)+":"+importsx.getName());
                              }

                          } // attributesProperties

                      }

                  } // size()

                  importss = new HashSet<Imports>();
                  imports = new Imports();

               } // isCambio 

              if (toProperty.equals("name")){
                  imports = findBean.nameImports(toValue,em);
              } // imports

              importss.add(imports);

           } // from: AttributesProperties

           if (from.equals("AttributesTypes") &&
               cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
               to.equals("Sites") &&
               Utils.isEmpty(name)){

               if (isCambio){

                  f.line("cambio:"+ant);

                  if (sitess.size() > 0){

                      if (fromProperty.equals("name")){
                          attributesTypes = findBean.nameAttributesTypes(ant,em);
                          attributesTypes.setSites(sitess);

                      } // attributesTypes

                      if (fromProperty.equals("type")){
                          attributesTypes = findBean.typeAttributesTypes(ant,em);
                          attributesTypes.setSites(sitess);

                      } // attributesTypes

                      if (fromProperty.equals("annotations")){
                          attributesTypes = findBean.annotationsAttributesTypes(ant,em);
                          attributesTypes.setSites(sitess);

                      } // attributesTypes

                      if (!isValidate) {

                          em.merge(attributesTypes);
                          em.flush();

                          if (fromProperty.equals("title")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getTitle());
                              }

                          } // attributesTypes

                          if (fromProperty.equals("link")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getLink());
                              }

                          } // attributesTypes

                          if (fromProperty.equals("abc")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getAbc());
                              }

                          } // attributesTypes

                          if (fromProperty.equals("ipAddress1")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress1());
                              }

                          } // attributesTypes

                          if (fromProperty.equals("ipAddress2")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress2());
                              }

                          } // attributesTypes

                          if (fromProperty.equals("ipAddress3")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress3());
                              }

                          } // attributesTypes

                      }

                  } // size()

                  sitess = new HashSet<Sites>();
                  sites = new Sites();

               } // isCambio 

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

           } // from: AttributesTypes

           if (from.equals("AttributesTypes") &&
               cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
               to.equals("AttributesProperties") &&
               Utils.isEmpty(name)){

               if (isCambio){

                  f.line("cambio:"+ant);

                  if (attributesPropertiess.size() > 0){

                      if (fromProperty.equals("name")){
                          attributesTypes = findBean.nameAttributesTypes(ant,em);
                          attributesTypes.setAttributesProperties(attributesPropertiess);

                      } // attributesTypes

                      if (fromProperty.equals("type")){
                          attributesTypes = findBean.typeAttributesTypes(ant,em);
                          attributesTypes.setAttributesProperties(attributesPropertiess);

                      } // attributesTypes

                      if (fromProperty.equals("annotations")){
                          attributesTypes = findBean.annotationsAttributesTypes(ant,em);
                          attributesTypes.setAttributesProperties(attributesPropertiess);

                      } // attributesTypes

                      if (!isValidate) {

                          em.merge(attributesTypes);
                          em.flush();

                          if (fromProperty.equals("name")){
                              j = 0;
                              for(AttributesProperties attributesPropertiesx : attributesPropertiess){
                                  f.line("       "+Integer.toString(++j)+":"+attributesPropertiesx.getName());
                              }

                          } // attributesTypes

                          if (fromProperty.equals("value")){
                              j = 0;
                              for(AttributesProperties attributesPropertiesx : attributesPropertiess){
                                  f.line("       "+Integer.toString(++j)+":"+attributesPropertiesx.getValue());
                              }

                          } // attributesTypes

                      }

                  } // size()

                  attributesPropertiess = new HashSet<AttributesProperties>();
                  attributesProperties = new AttributesProperties();

               } // isCambio 

              if (toProperty.equals("name")){
                  attributesProperties = findBean.nameAttributesProperties(toValue,em);
              } // attributesProperties

              if (toProperty.equals("value")){
                  attributesProperties = findBean.valueAttributesProperties(toValue,em);
              } // attributesProperties

              attributesPropertiess.add(attributesProperties);

           } // from: AttributesTypes

           if (from.equals("Developments") &&
               cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
               to.equals("ModelsGroups") &&
               Utils.isEmpty(name)){

               if (isCambio){

                  f.line("cambio:"+ant);

                  if (modelsGroupss.size() > 0){

                      if (fromProperty.equals("artifactId")){
                          developments = findBean.artifactIdDevelopments(ant,em);
                          developments.setModelsGroups(modelsGroupss);

                      } // developments

                      if (fromProperty.equals("groupId")){
                          developments = findBean.groupIdDevelopments(ant,em);
                          developments.setModelsGroups(modelsGroupss);

                      } // developments

                      if (fromProperty.equals("version")){
                          developments = findBean.versionDevelopments(ant,em);
                          developments.setModelsGroups(modelsGroupss);

                      } // developments

                      if (fromProperty.equals("code")){
                          developments = findBean.codeDevelopments(ant,em);
                          developments.setModelsGroups(modelsGroupss);

                      } // developments

                      if (!isValidate) {

                          em.merge(developments);
                          em.flush();

                          if (fromProperty.equals("name")){
                              j = 0;
                              for(ModelsGroups modelsGroupsx : modelsGroupss){
                                  f.line("       "+Integer.toString(++j)+":"+modelsGroupsx.getName());
                              }

                          } // developments

                          if (fromProperty.equals("code")){
                              j = 0;
                              for(ModelsGroups modelsGroupsx : modelsGroupss){
                                  f.line("       "+Integer.toString(++j)+":"+modelsGroupsx.getCode());
                              }

                          } // developments

                      }

                  } // size()

                  modelsGroupss = new HashSet<ModelsGroups>();
                  modelsGroups = new ModelsGroups();

               } // isCambio 

              if (toProperty.equals("name")){
                  modelsGroups = findBean.nameModelsGroups(toValue,em);
              } // modelsGroups

              if (toProperty.equals("code")){
                  modelsGroups = findBean.codeModelsGroups(toValue,em);
              } // modelsGroups

              modelsGroupss.add(modelsGroups);

           } // from: Developments

           if (from.equals("ModelsGroups") &&
               cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
               to.equals("Models") &&
               Utils.isEmpty(name)){

               if (isCambio){

                  f.line("cambio:"+ant);

                  if (modelss.size() > 0){

                      if (fromProperty.equals("name")){
                          modelsGroups = findBean.nameModelsGroups(ant,em);
                          modelsGroups.setModels(modelss);

                      } // modelsGroups

                      if (fromProperty.equals("code")){
                          modelsGroups = findBean.codeModelsGroups(ant,em);
                          modelsGroups.setModels(modelss);

                      } // modelsGroups

                      if (!isValidate) {

                          em.merge(modelsGroups);
                          em.flush();

                          if (fromProperty.equals("name")){
                              j = 0;
                              for(Models modelsx : modelss){
                                  f.line("       "+Integer.toString(++j)+":"+modelsx.getName());
                              }

                          } // modelsGroups

                          if (fromProperty.equals("code")){
                              j = 0;
                              for(Models modelsx : modelss){
                                  f.line("       "+Integer.toString(++j)+":"+modelsx.getCode());
                              }

                          } // modelsGroups

                          if (fromProperty.equals("version")){
                              j = 0;
                              for(Models modelsx : modelss){
                                  f.line("       "+Integer.toString(++j)+":"+modelsx.getVersion());
                              }

                          } // modelsGroups

                      }

                  } // size()

                  modelss = new HashSet<Models>();
                  models = new Models();

               } // isCambio 

              if (toProperty.equals("name")){
                  models = findBean.nameModels(toValue,em);
              } // models

              if (toProperty.equals("code")){
                  models = findBean.codeModels(toValue,em);
              } // models

              if (toProperty.equals("version")){
                  models = findBean.versionModels(toValue,em);
              } // models

              modelss.add(models);

           } // from: ModelsGroups

           if (from.equals("Sites") &&
               cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
               to.equals("SitesTypes") &&
               Utils.isEmpty(name)){

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

                          if (fromProperty.equals("name")){
                              j = 0;
                              for(SitesTypes sitesTypesx : sitesTypess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesTypesx.getName());
                              }

                          } // sites

                      }

                  } // size()

                  sitesTypess = new HashSet<SitesTypes>();
                  sitesTypes = new SitesTypes();

               } // isCambio 

              if (toProperty.equals("name")){
                  sitesTypes = findBean.nameSitesTypes(toValue,em);
              } // sitesTypes

              sitesTypess.add(sitesTypes);

           } // from: Sites

           if (from.equals("Activities") &&
               cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
               to.equals("Calendars") &&
               Utils.isEmpty(name)){

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

                          if (fromProperty.equals("name")){
                              j = 0;
                              for(Calendars calendarsx : calendarss){
                                  f.line("       "+Integer.toString(++j)+":"+calendarsx.getName());
                              }

                          } // activities

                      }

                  } // size()

                  calendarss = new HashSet<Calendars>();
                  calendars = new Calendars();

               } // isCambio 

              if (toProperty.equals("name")){
                  calendars = findBean.nameCalendars(toValue,em);
              } // calendars

              calendarss.add(calendars);

           } // from: Activities

           if (from.equals("Activities") &&
               cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
               to.equals("Sites") &&
               Utils.isEmpty(name)){

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

                          if (fromProperty.equals("title")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getTitle());
                              }

                          } // activities

                          if (fromProperty.equals("link")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getLink());
                              }

                          } // activities

                          if (fromProperty.equals("abc")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getAbc());
                              }

                          } // activities

                          if (fromProperty.equals("ipAddress1")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress1());
                              }

                          } // activities

                          if (fromProperty.equals("ipAddress2")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress2());
                              }

                          } // activities

                          if (fromProperty.equals("ipAddress3")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress3());
                              }

                          } // activities

                      }

                  } // size()

                  sitess = new HashSet<Sites>();
                  sites = new Sites();

               } // isCambio 

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

           } // from: Activities

           if (from.equals("Tasks") &&
               cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
               to.equals("Sites") &&
               Utils.isEmpty(name)){

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

                          if (fromProperty.equals("title")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getTitle());
                              }

                          } // tasks

                          if (fromProperty.equals("link")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getLink());
                              }

                          } // tasks

                          if (fromProperty.equals("abc")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getAbc());
                              }

                          } // tasks

                          if (fromProperty.equals("ipAddress1")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress1());
                              }

                          } // tasks

                          if (fromProperty.equals("ipAddress2")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress2());
                              }

                          } // tasks

                          if (fromProperty.equals("ipAddress3")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress3());
                              }

                          } // tasks

                      }

                  } // size()

                  sitess = new HashSet<Sites>();
                  sites = new Sites();

               } // isCambio 

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

           } // from: Tasks

           if (from.equals("Diaries") &&
               cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
               to.equals("Sites") &&
               Utils.isEmpty(name)){

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

                          if (fromProperty.equals("title")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getTitle());
                              }

                          } // diaries

                          if (fromProperty.equals("link")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getLink());
                              }

                          } // diaries

                          if (fromProperty.equals("abc")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getAbc());
                              }

                          } // diaries

                          if (fromProperty.equals("ipAddress1")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress1());
                              }

                          } // diaries

                          if (fromProperty.equals("ipAddress2")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress2());
                              }

                          } // diaries

                          if (fromProperty.equals("ipAddress3")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress3());
                              }

                          } // diaries

                      }

                  } // size()

                  sitess = new HashSet<Sites>();
                  sites = new Sites();

               } // isCambio 

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

           } // from: Diaries

        } // while

        if (from.equals("Brands") &&
            cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
            to.equals("Sites") &&
            Utils.isEmpty(name)){

            if (sitess.size() > 0){

                if (fromProperty.equals("name")){
                    brands = findBean.nameBrands(anterior,em);
                    brands.setSites(sitess);

                } // brands

            if (!isValidate) {

                em.merge(brands);
                em.flush();

                          if (fromProperty.equals("title")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getTitle());
                              }

                          } // brands

                          if (fromProperty.equals("link")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getLink());
                              }

                          } // brands

                          if (fromProperty.equals("abc")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getAbc());
                              }

                          } // brands

                          if (fromProperty.equals("ipAddress1")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress1());
                              }

                          } // brands

                          if (fromProperty.equals("ipAddress2")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress2());
                              }

                          } // brands

                          if (fromProperty.equals("ipAddress3")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress3());
                              }

                          } // brands

            }

            } //size()

        } // from: Brands

        if (from.equals("Companies") &&
            cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
            to.equals("Sites") &&
            Utils.isEmpty(name)){

            if (sitess.size() > 0){

                if (fromProperty.equals("name")){
                    companies = findBean.nameCompanies(anterior,em);
                    companies.setSites(sitess);

                } // companies

            if (!isValidate) {

                em.merge(companies);
                em.flush();

                          if (fromProperty.equals("title")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getTitle());
                              }

                          } // companies

                          if (fromProperty.equals("link")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getLink());
                              }

                          } // companies

                          if (fromProperty.equals("abc")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getAbc());
                              }

                          } // companies

                          if (fromProperty.equals("ipAddress1")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress1());
                              }

                          } // companies

                          if (fromProperty.equals("ipAddress2")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress2());
                              }

                          } // companies

                          if (fromProperty.equals("ipAddress3")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress3());
                              }

                          } // companies

            }

            } //size()

        } // from: Companies

        if (from.equals("Employees") &&
            cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
            to.equals("Charges") &&
            Utils.isEmpty(name)){

            if (chargess.size() > 0){

                if (fromProperty.equals("code")){
                    employees = findBean.codeEmployees(anterior,em);
                    employees.setCharges(chargess);

                } // employees

            if (!isValidate) {

                em.merge(employees);
                em.flush();

                          if (fromProperty.equals("name")){
                              j = 0;
                              for(Charges chargesx : chargess){
                                  f.line("       "+Integer.toString(++j)+":"+chargesx.getName());
                              }

                          } // employees

            }

            } //size()

        } // from: Employees

        if (from.equals("Charges") &&
            cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
            to.equals("CompaniesRoles") &&
            Utils.isEmpty(name)){

            if (companiesRoless.size() > 0){

                if (fromProperty.equals("name")){
                    charges = findBean.nameCharges(anterior,em);
                    charges.setCompaniesRoles(companiesRoless);

                } // charges

            if (!isValidate) {

                em.merge(charges);
                em.flush();

                          if (fromProperty.equals("name")){
                              j = 0;
                              for(CompaniesRoles companiesRolesx : companiesRoless){
                                  f.line("       "+Integer.toString(++j)+":"+companiesRolesx.getName());
                              }

                          } // charges

            }

            } //size()

        } // from: Charges

        if (from.equals("Dependencies") &&
            cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
            to.equals("Sites") &&
            Utils.isEmpty(name)){

            if (sitess.size() > 0){

                if (fromProperty.equals("groupId")){
                    dependencies = findBean.groupIdDependencies(anterior,em);
                    dependencies.setSites(sitess);

                } // dependencies

                if (fromProperty.equals("artifactId")){
                    dependencies = findBean.artifactIdDependencies(anterior,em);
                    dependencies.setSites(sitess);

                } // dependencies

                if (fromProperty.equals("version")){
                    dependencies = findBean.versionDependencies(anterior,em);
                    dependencies.setSites(sitess);

                } // dependencies

                if (fromProperty.equals("type")){
                    dependencies = findBean.typeDependencies(anterior,em);
                    dependencies.setSites(sitess);

                } // dependencies

                if (fromProperty.equals("scope")){
                    dependencies = findBean.scopeDependencies(anterior,em);
                    dependencies.setSites(sitess);

                } // dependencies

                if (fromProperty.equals("maven")){
                    dependencies = findBean.mavenDependencies(anterior,em);
                    dependencies.setSites(sitess);

                } // dependencies

            if (!isValidate) {

                em.merge(dependencies);
                em.flush();

                          if (fromProperty.equals("title")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getTitle());
                              }

                          } // dependencies

                          if (fromProperty.equals("link")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getLink());
                              }

                          } // dependencies

                          if (fromProperty.equals("abc")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getAbc());
                              }

                          } // dependencies

                          if (fromProperty.equals("ipAddress1")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress1());
                              }

                          } // dependencies

                          if (fromProperty.equals("ipAddress2")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress2());
                              }

                          } // dependencies

                          if (fromProperty.equals("ipAddress3")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress3());
                              }

                          } // dependencies

            }

            } //size()

        } // from: Dependencies

        if (from.equals("Imports") &&
            cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
            to.equals("Sites") &&
            Utils.isEmpty(name)){

            if (sitess.size() > 0){

                if (fromProperty.equals("name")){
                    imports = findBean.nameImports(anterior,em);
                    imports.setSites(sitess);

                } // imports

            if (!isValidate) {

                em.merge(imports);
                em.flush();

                          if (fromProperty.equals("title")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getTitle());
                              }

                          } // imports

                          if (fromProperty.equals("link")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getLink());
                              }

                          } // imports

                          if (fromProperty.equals("abc")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getAbc());
                              }

                          } // imports

                          if (fromProperty.equals("ipAddress1")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress1());
                              }

                          } // imports

                          if (fromProperty.equals("ipAddress2")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress2());
                              }

                          } // imports

                          if (fromProperty.equals("ipAddress3")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress3());
                              }

                          } // imports

            }

            } //size()

        } // from: Imports

        if (from.equals("AttributesProperties") &&
            cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
            to.equals("Sites") &&
            Utils.isEmpty(name)){

            if (sitess.size() > 0){

                if (fromProperty.equals("name")){
                    attributesProperties = findBean.nameAttributesProperties(anterior,em);
                    attributesProperties.setSites(sitess);

                } // attributesProperties

                if (fromProperty.equals("value")){
                    attributesProperties = findBean.valueAttributesProperties(anterior,em);
                    attributesProperties.setSites(sitess);

                } // attributesProperties

            if (!isValidate) {

                em.merge(attributesProperties);
                em.flush();

                          if (fromProperty.equals("title")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getTitle());
                              }

                          } // attributesProperties

                          if (fromProperty.equals("link")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getLink());
                              }

                          } // attributesProperties

                          if (fromProperty.equals("abc")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getAbc());
                              }

                          } // attributesProperties

                          if (fromProperty.equals("ipAddress1")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress1());
                              }

                          } // attributesProperties

                          if (fromProperty.equals("ipAddress2")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress2());
                              }

                          } // attributesProperties

                          if (fromProperty.equals("ipAddress3")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress3());
                              }

                          } // attributesProperties

            }

            } //size()

        } // from: AttributesProperties

        if (from.equals("AttributesProperties") &&
            cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
            to.equals("Imports") &&
            Utils.isEmpty(name)){

            if (importss.size() > 0){

                if (fromProperty.equals("name")){
                    attributesProperties = findBean.nameAttributesProperties(anterior,em);
                    attributesProperties.setImports(importss);

                } // attributesProperties

                if (fromProperty.equals("value")){
                    attributesProperties = findBean.valueAttributesProperties(anterior,em);
                    attributesProperties.setImports(importss);

                } // attributesProperties

            if (!isValidate) {

                em.merge(attributesProperties);
                em.flush();

                          if (fromProperty.equals("name")){
                              j = 0;
                              for(Imports importsx : importss){
                                  f.line("       "+Integer.toString(++j)+":"+importsx.getName());
                              }

                          } // attributesProperties

            }

            } //size()

        } // from: AttributesProperties

        if (from.equals("AttributesTypes") &&
            cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
            to.equals("Sites") &&
            Utils.isEmpty(name)){

            if (sitess.size() > 0){

                if (fromProperty.equals("name")){
                    attributesTypes = findBean.nameAttributesTypes(anterior,em);
                    attributesTypes.setSites(sitess);

                } // attributesTypes

                if (fromProperty.equals("type")){
                    attributesTypes = findBean.typeAttributesTypes(anterior,em);
                    attributesTypes.setSites(sitess);

                } // attributesTypes

                if (fromProperty.equals("annotations")){
                    attributesTypes = findBean.annotationsAttributesTypes(anterior,em);
                    attributesTypes.setSites(sitess);

                } // attributesTypes

            if (!isValidate) {

                em.merge(attributesTypes);
                em.flush();

                          if (fromProperty.equals("title")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getTitle());
                              }

                          } // attributesTypes

                          if (fromProperty.equals("link")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getLink());
                              }

                          } // attributesTypes

                          if (fromProperty.equals("abc")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getAbc());
                              }

                          } // attributesTypes

                          if (fromProperty.equals("ipAddress1")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress1());
                              }

                          } // attributesTypes

                          if (fromProperty.equals("ipAddress2")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress2());
                              }

                          } // attributesTypes

                          if (fromProperty.equals("ipAddress3")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress3());
                              }

                          } // attributesTypes

            }

            } //size()

        } // from: AttributesTypes

        if (from.equals("AttributesTypes") &&
            cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
            to.equals("AttributesProperties") &&
            Utils.isEmpty(name)){

            if (attributesPropertiess.size() > 0){

                if (fromProperty.equals("name")){
                    attributesTypes = findBean.nameAttributesTypes(anterior,em);
                    attributesTypes.setAttributesProperties(attributesPropertiess);

                } // attributesTypes

                if (fromProperty.equals("type")){
                    attributesTypes = findBean.typeAttributesTypes(anterior,em);
                    attributesTypes.setAttributesProperties(attributesPropertiess);

                } // attributesTypes

                if (fromProperty.equals("annotations")){
                    attributesTypes = findBean.annotationsAttributesTypes(anterior,em);
                    attributesTypes.setAttributesProperties(attributesPropertiess);

                } // attributesTypes

            if (!isValidate) {

                em.merge(attributesTypes);
                em.flush();

                          if (fromProperty.equals("name")){
                              j = 0;
                              for(AttributesProperties attributesPropertiesx : attributesPropertiess){
                                  f.line("       "+Integer.toString(++j)+":"+attributesPropertiesx.getName());
                              }

                          } // attributesTypes

                          if (fromProperty.equals("value")){
                              j = 0;
                              for(AttributesProperties attributesPropertiesx : attributesPropertiess){
                                  f.line("       "+Integer.toString(++j)+":"+attributesPropertiesx.getValue());
                              }

                          } // attributesTypes

            }

            } //size()

        } // from: AttributesTypes

        if (from.equals("Developments") &&
            cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
            to.equals("ModelsGroups") &&
            Utils.isEmpty(name)){

            if (modelsGroupss.size() > 0){

                if (fromProperty.equals("artifactId")){
                    developments = findBean.artifactIdDevelopments(anterior,em);
                    developments.setModelsGroups(modelsGroupss);

                } // developments

                if (fromProperty.equals("groupId")){
                    developments = findBean.groupIdDevelopments(anterior,em);
                    developments.setModelsGroups(modelsGroupss);

                } // developments

                if (fromProperty.equals("version")){
                    developments = findBean.versionDevelopments(anterior,em);
                    developments.setModelsGroups(modelsGroupss);

                } // developments

                if (fromProperty.equals("code")){
                    developments = findBean.codeDevelopments(anterior,em);
                    developments.setModelsGroups(modelsGroupss);

                } // developments

            if (!isValidate) {

                em.merge(developments);
                em.flush();

                          if (fromProperty.equals("name")){
                              j = 0;
                              for(ModelsGroups modelsGroupsx : modelsGroupss){
                                  f.line("       "+Integer.toString(++j)+":"+modelsGroupsx.getName());
                              }

                          } // developments

                          if (fromProperty.equals("code")){
                              j = 0;
                              for(ModelsGroups modelsGroupsx : modelsGroupss){
                                  f.line("       "+Integer.toString(++j)+":"+modelsGroupsx.getCode());
                              }

                          } // developments

            }

            } //size()

        } // from: Developments

        if (from.equals("ModelsGroups") &&
            cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
            to.equals("Models") &&
            Utils.isEmpty(name)){

            if (modelss.size() > 0){

                if (fromProperty.equals("name")){
                    modelsGroups = findBean.nameModelsGroups(anterior,em);
                    modelsGroups.setModels(modelss);

                } // modelsGroups

                if (fromProperty.equals("code")){
                    modelsGroups = findBean.codeModelsGroups(anterior,em);
                    modelsGroups.setModels(modelss);

                } // modelsGroups

            if (!isValidate) {

                em.merge(modelsGroups);
                em.flush();

                          if (fromProperty.equals("name")){
                              j = 0;
                              for(Models modelsx : modelss){
                                  f.line("       "+Integer.toString(++j)+":"+modelsx.getName());
                              }

                          } // modelsGroups

                          if (fromProperty.equals("code")){
                              j = 0;
                              for(Models modelsx : modelss){
                                  f.line("       "+Integer.toString(++j)+":"+modelsx.getCode());
                              }

                          } // modelsGroups

                          if (fromProperty.equals("version")){
                              j = 0;
                              for(Models modelsx : modelss){
                                  f.line("       "+Integer.toString(++j)+":"+modelsx.getVersion());
                              }

                          } // modelsGroups

            }

            } //size()

        } // from: ModelsGroups

        if (from.equals("Sites") &&
            cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
            to.equals("SitesTypes") &&
            Utils.isEmpty(name)){

            if (sitesTypess.size() > 0){

                if (fromProperty.equals("title")){
                    sites = findBean.titleSites(anterior,em);
                    sites.setSitesTypes(sitesTypess);

                } // sites

                if (fromProperty.equals("link")){
                    sites = findBean.linkSites(anterior,em);
                    sites.setSitesTypes(sitesTypess);

                } // sites

                if (fromProperty.equals("abc")){
                    sites = findBean.abcSites(anterior,em);
                    sites.setSitesTypes(sitesTypess);

                } // sites

                if (fromProperty.equals("ipAddress1")){
                    sites = findBean.ipAddress1Sites(anterior,em);
                    sites.setSitesTypes(sitesTypess);

                } // sites

                if (fromProperty.equals("ipAddress2")){
                    sites = findBean.ipAddress2Sites(anterior,em);
                    sites.setSitesTypes(sitesTypess);

                } // sites

                if (fromProperty.equals("ipAddress3")){
                    sites = findBean.ipAddress3Sites(anterior,em);
                    sites.setSitesTypes(sitesTypess);

                } // sites

            if (!isValidate) {

                em.merge(sites);
                em.flush();

                          if (fromProperty.equals("name")){
                              j = 0;
                              for(SitesTypes sitesTypesx : sitesTypess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesTypesx.getName());
                              }

                          } // sites

            }

            } //size()

        } // from: Sites

        if (from.equals("Activities") &&
            cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
            to.equals("Calendars") &&
            Utils.isEmpty(name)){

            if (calendarss.size() > 0){

                if (fromProperty.equals("name")){
                    activities = findBean.nameActivities(anterior,em);
                    activities.setCalendars(calendarss);

                } // activities

            if (!isValidate) {

                em.merge(activities);
                em.flush();

                          if (fromProperty.equals("name")){
                              j = 0;
                              for(Calendars calendarsx : calendarss){
                                  f.line("       "+Integer.toString(++j)+":"+calendarsx.getName());
                              }

                          } // activities

            }

            } //size()

        } // from: Activities

        if (from.equals("Activities") &&
            cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
            to.equals("Sites") &&
            Utils.isEmpty(name)){

            if (sitess.size() > 0){

                if (fromProperty.equals("name")){
                    activities = findBean.nameActivities(anterior,em);
                    activities.setSites(sitess);

                } // activities

            if (!isValidate) {

                em.merge(activities);
                em.flush();

                          if (fromProperty.equals("title")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getTitle());
                              }

                          } // activities

                          if (fromProperty.equals("link")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getLink());
                              }

                          } // activities

                          if (fromProperty.equals("abc")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getAbc());
                              }

                          } // activities

                          if (fromProperty.equals("ipAddress1")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress1());
                              }

                          } // activities

                          if (fromProperty.equals("ipAddress2")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress2());
                              }

                          } // activities

                          if (fromProperty.equals("ipAddress3")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress3());
                              }

                          } // activities

            }

            } //size()

        } // from: Activities

        if (from.equals("Tasks") &&
            cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
            to.equals("Sites") &&
            Utils.isEmpty(name)){

            if (sitess.size() > 0){

                if (fromProperty.equals("name")){
                    tasks = findBean.nameTasks(anterior,em);
                    tasks.setSites(sitess);

                } // tasks

            if (!isValidate) {

                em.merge(tasks);
                em.flush();

                          if (fromProperty.equals("title")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getTitle());
                              }

                          } // tasks

                          if (fromProperty.equals("link")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getLink());
                              }

                          } // tasks

                          if (fromProperty.equals("abc")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getAbc());
                              }

                          } // tasks

                          if (fromProperty.equals("ipAddress1")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress1());
                              }

                          } // tasks

                          if (fromProperty.equals("ipAddress2")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress2());
                              }

                          } // tasks

                          if (fromProperty.equals("ipAddress3")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress3());
                              }

                          } // tasks

            }

            } //size()

        } // from: Tasks

        if (from.equals("Diaries") &&
            cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
            to.equals("Sites") &&
            Utils.isEmpty(name)){

            if (sitess.size() > 0){

                if (fromProperty.equals("name")){
                    diaries = findBean.nameDiaries(anterior,em);
                    diaries.setSites(sitess);

                } // diaries

                if (fromProperty.equals("description")){
                    diaries = findBean.descriptionDiaries(anterior,em);
                    diaries.setSites(sitess);

                } // diaries

            if (!isValidate) {

                em.merge(diaries);
                em.flush();

                          if (fromProperty.equals("title")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getTitle());
                              }

                          } // diaries

                          if (fromProperty.equals("link")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getLink());
                              }

                          } // diaries

                          if (fromProperty.equals("abc")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getAbc());
                              }

                          } // diaries

                          if (fromProperty.equals("ipAddress1")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress1());
                              }

                          } // diaries

                          if (fromProperty.equals("ipAddress2")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress2());
                              }

                          } // diaries

                          if (fromProperty.equals("ipAddress3")){
                              j = 0;
                              for(Sites sitesx : sitess){
                                  f.line("       "+Integer.toString(++j)+":"+sitesx.getIpAddress3());
                              }

                          } // diaries

            }

            } //size()

        } // from: Diaries

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
