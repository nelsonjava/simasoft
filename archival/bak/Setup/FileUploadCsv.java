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
@Named("fileUploadCsv")
public class FileUploadCsv {

    private String filePath = "";

    BufferedReader br = null;

    Integer i = 0;
    String entity = "";
    String line = "";
    String cvsSplitBy = ";";

    String[] types = new String[100];
    String[] fields = new String[100];

    @PersistenceContext(unitName = "archivalPU-JTA")
    private EntityManager em;

    private UploadedFile file;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public void data() {

    try {

        if(file != null) {

           i = 0;
           FileTxt f = new FileTxt();

           filePath = "\\docs\\"+file.getFileName();

           FacesMessage message = new FacesMessage("Succesful", filePath + " is uploaded.");
           FacesContext.getCurrentInstance().addMessage(null, message);

           br = new BufferedReader(new FileReader(filePath));
           while ((line = br.readLine()) != null) {

              // use comma as separator
              String[] data = line.split(cvsSplitBy);

              i++;
              switch (i) {
                  case 1:
                       entity = data[data.length-1];
                       types = data;
                       f.line("Entidad:"+entity);
                       break;
                  case 2:
                       fields = data;
                       break;
                  default:
                       entitiesData(entity,fields,types,data,f,em);
                       break;
              }
           }
           f.saveFile("\\docs", entity+"Data.txt");

        } // if

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

    } // data()

    public void entitiesData(String entity,String[] fields,String[] types,String[] data,FileTxt f,EntityManager em) {

        switch (entity) {
            case "FundsLife":
                 FundsLife(entity,fields,types,data,f,em);
                 break;
            case "Funds":
                 Funds(entity,fields,types,data,f,em);
                 break;
            case "SectionsTypes":
                 SectionsTypes(entity,fields,types,data,f,em);
                 break;
            case "Sections":
                 Sections(entity,fields,types,data,f,em);
                 break;
            case "Series":
                 Series(entity,fields,types,data,f,em);
                 break;
            case "TrdSeries":
                 TrdSeries(entity,fields,types,data,f,em);
                 break;
            case "Trd":
                 Trd(entity,fields,types,data,f,em);
                 break;
            case "FinalDisposition":
                 FinalDisposition(entity,fields,types,data,f,em);
                 break;
            case "DocumentalRetention":
                 DocumentalRetention(entity,fields,types,data,f,em);
                 break;
            case "FrequentlyQuery":
                 FrequentlyQuery(entity,fields,types,data,f,em);
                 break;
            case "DocumentalsUnits":
                 DocumentalsUnits(entity,fields,types,data,f,em);
                 break;
            case "ConservationUnits":
                 ConservationUnits(entity,fields,types,data,f,em);
                 break;
            case "VersionsControls":
                 VersionsControls(entity,fields,types,data,f,em);
                 break;
            case "DocumentalInventory":
                 DocumentalInventory(entity,fields,types,data,f,em);
                 break;
            case "OriginalOrders":
                 OriginalOrders(entity,fields,types,data,f,em);
                 break;
            case "DocumentalsUnitsTypes":
                 DocumentalsUnitsTypes(entity,fields,types,data,f,em);
                 break;
            case "Access":
                 Access(entity,fields,types,data,f,em);
                 break;
            case "Organizeds":
                 Organizeds(entity,fields,types,data,f,em);
                 break;
            case "InventoryFinality":
                 InventoryFinality(entity,fields,types,data,f,em);
                 break;
            case "DocumentalsSupports":
                 DocumentalsSupports(entity,fields,types,data,f,em);
                 break;
            case "ConservationUnitsTypes":
                 ConservationUnitsTypes(entity,fields,types,data,f,em);
                 break;
            case "Companies":
                 Companies(entity,fields,types,data,f,em);
                 break;
            case "CompaniesRoles":
                 CompaniesRoles(entity,fields,types,data,f,em);
                 break;
            case "Activities":
                 Activities(entity,fields,types,data,f,em);
                 break;
            case "Tasks":
                 Tasks(entity,fields,types,data,f,em);
                 break;
        }

    } // Entities

    public void FundsLife(String entity,String[] fields,String[] types,String[] data,FileTxt f,EntityManager em) {

        FundsLife fundsLife = new FundsLife();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+fields[i]+"="+data[i]);

            switch (fields[i]) {
                case "name":
                     fundsLife.setName(data[i]);
                     break;
            }

        } // for

        em.persist(fundsLife);
        em.flush();

    } // FundsLife

    public void Funds(String entity,String[] fields,String[] types,String[] data,FileTxt f,EntityManager em) {

        Funds funds = new Funds();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+fields[i]+"="+data[i]);

            switch (fields[i]) {
                case "name":
                     funds.setName(data[i]);
                     break;
                case "code":
                     funds.setCode(data[i]);
                     break;
            }

        } // for

        em.persist(funds);
        em.flush();

    } // Funds

    public void SectionsTypes(String entity,String[] fields,String[] types,String[] data,FileTxt f,EntityManager em) {

        SectionsTypes sectionsTypes = new SectionsTypes();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+fields[i]+"="+data[i]);

            switch (fields[i]) {
                case "name":
                     sectionsTypes.setName(data[i]);
                     break;
            }

        } // for

        em.persist(sectionsTypes);
        em.flush();

    } // SectionsTypes

    public void Sections(String entity,String[] fields,String[] types,String[] data,FileTxt f,EntityManager em) {

        Sections sections = new Sections();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+fields[i]+"="+data[i]);

            switch (fields[i]) {
                case "name":
                     sections.setName(data[i]);
                     break;
                case "code":
                     sections.setCode(data[i]);
                     break;
                case "dir":
                     sections.setDir(data[i]);
                     break;
            }

        } // for

        em.persist(sections);
        em.flush();

    } // Sections

    public void Series(String entity,String[] fields,String[] types,String[] data,FileTxt f,EntityManager em) {

        Series series = new Series();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+fields[i]+"="+data[i]);

            switch (fields[i]) {
                case "name":
                     series.setName(data[i]);
                     break;
                case "code":
                     series.setCode(data[i]);
                     break;
                case "located":
                     series.setLocated(data[i]);
                     break;
                case "procedures":
                     series.setProcedures(data[i]);
                     break;
                case "dir":
                     series.setDir(data[i]);
                     break;
            }

        } // for

        em.persist(series);
        em.flush();

    } // Series

    public void TrdSeries(String entity,String[] fields,String[] types,String[] data,FileTxt f,EntityManager em) {

        TrdSeries trdSeries = new TrdSeries();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+fields[i]+"="+data[i]);

            switch (fields[i]) {
                case "name":
                     trdSeries.setName(data[i]);
                     break;
            }

        } // for

        em.persist(trdSeries);
        em.flush();

    } // TrdSeries

    public void Trd(String entity,String[] fields,String[] types,String[] data,FileTxt f,EntityManager em) {

        Trd trd = new Trd();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+fields[i]+"="+data[i]);

            switch (fields[i]) {
                case "name":
                     trd.setName(data[i]);
                     break;
            }

        } // for

        em.persist(trd);
        em.flush();

    } // Trd

    public void FinalDisposition(String entity,String[] fields,String[] types,String[] data,FileTxt f,EntityManager em) {

        FinalDisposition finalDisposition = new FinalDisposition();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+fields[i]+"="+data[i]);

            switch (fields[i]) {
                case "name":
                     finalDisposition.setName(data[i]);
                     break;
            }

        } // for

        em.persist(finalDisposition);
        em.flush();

    } // FinalDisposition

    public void DocumentalRetention(String entity,String[] fields,String[] types,String[] data,FileTxt f,EntityManager em) {

        DocumentalRetention documentalRetention = new DocumentalRetention();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+fields[i]+"="+data[i]);

            switch (fields[i]) {
                case "name":
                     documentalRetention.setName(data[i]);
                     break;
            }

        } // for

        em.persist(documentalRetention);
        em.flush();

    } // DocumentalRetention

    public void FrequentlyQuery(String entity,String[] fields,String[] types,String[] data,FileTxt f,EntityManager em) {

        FrequentlyQuery frequentlyQuery = new FrequentlyQuery();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+fields[i]+"="+data[i]);

            switch (fields[i]) {
                case "name":
                     frequentlyQuery.setName(data[i]);
                     break;
            }

        } // for

        em.persist(frequentlyQuery);
        em.flush();

    } // FrequentlyQuery

    public void DocumentalsUnits(String entity,String[] fields,String[] types,String[] data,FileTxt f,EntityManager em) {

        DocumentalsUnits documentalsUnits = new DocumentalsUnits();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+fields[i]+"="+data[i]);

            switch (fields[i]) {
                case "name":
                     documentalsUnits.setName(data[i]);
                     break;
                case "code":
                     documentalsUnits.setCode(data[i]);
                     break;
            }

        } // for

        em.persist(documentalsUnits);
        em.flush();

    } // DocumentalsUnits

    public void ConservationUnits(String entity,String[] fields,String[] types,String[] data,FileTxt f,EntityManager em) {

        ConservationUnits conservationUnits = new ConservationUnits();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+fields[i]+"="+data[i]);

            switch (fields[i]) {
                case "name":
                     conservationUnits.setName(data[i]);
                     break;
                case "code":
                     conservationUnits.setCode(data[i]);
                     break;
            }

        } // for

        em.persist(conservationUnits);
        em.flush();

    } // ConservationUnits

    public void VersionsControls(String entity,String[] fields,String[] types,String[] data,FileTxt f,EntityManager em) {

        VersionsControls versionsControls = new VersionsControls();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+fields[i]+"="+data[i]);

            switch (fields[i]) {
                case "name":
                     versionsControls.setName(data[i]);
                     break;
                case "code":
                     versionsControls.setCode(data[i]);
                     break;
                case "version":
                     versionsControls.setVersion(data[i]);
                     break;
                case "request":
                     versionsControls.setRequest(data[i]);
                     break;
                case "responsible":
                     versionsControls.setResponsible(data[i]);
                     break;
                case "description":
                     versionsControls.setDescription(data[i]);
                     break;
            }

        } // for

        em.persist(versionsControls);
        em.flush();

    } // VersionsControls

    public void DocumentalInventory(String entity,String[] fields,String[] types,String[] data,FileTxt f,EntityManager em) {

        DocumentalInventory documentalInventory = new DocumentalInventory();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+fields[i]+"="+data[i]);

            switch (fields[i]) {
                case "object":
                     documentalInventory.setObject(data[i]);
                     break;
            }

        } // for

        em.persist(documentalInventory);
        em.flush();

    } // DocumentalInventory

    public void OriginalOrders(String entity,String[] fields,String[] types,String[] data,FileTxt f,EntityManager em) {

        OriginalOrders originalOrders = new OriginalOrders();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+fields[i]+"="+data[i]);

            switch (fields[i]) {
                case "subject":
                     originalOrders.setSubject(data[i]);
                     break;
                case "code":
                     originalOrders.setCode(data[i]);
                     break;
                case "located":
                     originalOrders.setLocated(data[i]);
                     break;
                case "mail":
                     originalOrders.setMail(data[i]);
                     break;
                case "notes":
                     originalOrders.setNotes(data[i]);
                     break;
                case "fileName":
                     originalOrders.setFileName(data[i]);
                     break;
                case "fileType":
                     originalOrders.setFileType(data[i]);
                     break;
                case "filedir":
                     originalOrders.setFiledir(data[i]);
                     break;
            }

        } // for

        em.persist(originalOrders);
        em.flush();

    } // OriginalOrders

    public void DocumentalsUnitsTypes(String entity,String[] fields,String[] types,String[] data,FileTxt f,EntityManager em) {

        DocumentalsUnitsTypes documentalsUnitsTypes = new DocumentalsUnitsTypes();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+fields[i]+"="+data[i]);

            switch (fields[i]) {
                case "name":
                     documentalsUnitsTypes.setName(data[i]);
                     break;
            }

        } // for

        em.persist(documentalsUnitsTypes);
        em.flush();

    } // DocumentalsUnitsTypes

    public void Access(String entity,String[] fields,String[] types,String[] data,FileTxt f,EntityManager em) {

        Access access = new Access();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+fields[i]+"="+data[i]);

            switch (fields[i]) {
                case "name":
                     access.setName(data[i]);
                     break;
            }

        } // for

        em.persist(access);
        em.flush();

    } // Access

    public void Organizeds(String entity,String[] fields,String[] types,String[] data,FileTxt f,EntityManager em) {

        Organizeds organizeds = new Organizeds();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+fields[i]+"="+data[i]);

            switch (fields[i]) {
                case "name":
                     organizeds.setName(data[i]);
                     break;
            }

        } // for

        em.persist(organizeds);
        em.flush();

    } // Organizeds

    public void InventoryFinality(String entity,String[] fields,String[] types,String[] data,FileTxt f,EntityManager em) {

        InventoryFinality inventoryFinality = new InventoryFinality();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+fields[i]+"="+data[i]);

            switch (fields[i]) {
                case "name":
                     inventoryFinality.setName(data[i]);
                     break;
            }

        } // for

        em.persist(inventoryFinality);
        em.flush();

    } // InventoryFinality

    public void DocumentalsSupports(String entity,String[] fields,String[] types,String[] data,FileTxt f,EntityManager em) {

        DocumentalsSupports documentalsSupports = new DocumentalsSupports();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+fields[i]+"="+data[i]);

            switch (fields[i]) {
                case "name":
                     documentalsSupports.setName(data[i]);
                     break;
                case "code":
                     documentalsSupports.setCode(data[i]);
                     break;
            }

        } // for

        em.persist(documentalsSupports);
        em.flush();

    } // DocumentalsSupports

    public void ConservationUnitsTypes(String entity,String[] fields,String[] types,String[] data,FileTxt f,EntityManager em) {

        ConservationUnitsTypes conservationUnitsTypes = new ConservationUnitsTypes();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+fields[i]+"="+data[i]);

            switch (fields[i]) {
                case "name":
                     conservationUnitsTypes.setName(data[i]);
                     break;
            }

        } // for

        em.persist(conservationUnitsTypes);
        em.flush();

    } // ConservationUnitsTypes

    public void Companies(String entity,String[] fields,String[] types,String[] data,FileTxt f,EntityManager em) {

        Companies companies = new Companies();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+fields[i]+"="+data[i]);

            switch (fields[i]) {
                case "name":
                     companies.setName(data[i]);
                     break;
            }

        } // for

        em.persist(companies);
        em.flush();

    } // Companies

    public void CompaniesRoles(String entity,String[] fields,String[] types,String[] data,FileTxt f,EntityManager em) {

        CompaniesRoles companiesRoles = new CompaniesRoles();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+fields[i]+"="+data[i]);

            switch (fields[i]) {
                case "name":
                     companiesRoles.setName(data[i]);
                     break;
            }

        } // for

        em.persist(companiesRoles);
        em.flush();

    } // CompaniesRoles

    public void Activities(String entity,String[] fields,String[] types,String[] data,FileTxt f,EntityManager em) {

        Activities activities = new Activities();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+fields[i]+"="+data[i]);

            switch (fields[i]) {
                case "name":
                     activities.setName(data[i]);
                     break;
            }

        } // for

        em.persist(activities);
        em.flush();

    } // Activities

    public void Tasks(String entity,String[] fields,String[] types,String[] data,FileTxt f,EntityManager em) {

        Tasks tasks = new Tasks();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+fields[i]+"="+data[i]);

            switch (fields[i]) {
                case "name":
                     tasks.setName(data[i]);
                     break;
            }

        } // for

        em.persist(tasks);
        em.flush();

    } // Tasks

}
