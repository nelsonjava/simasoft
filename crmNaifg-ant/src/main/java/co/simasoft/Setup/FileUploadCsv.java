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
    String cvsSplitBy = ",";

    String[] types = new String[100];
    String[] fields = new String[100];

    @PersistenceContext(unitName = "crmNaifgPU-JTA")
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
            case "BooksTypes":
                 BooksTypes(entity,fields,types,data,f,em);
                 break;
            case "Books":
                 Books(entity,fields,types,data,f,em);
                 break;
            case "Chapters":
                 Chapters(entity,fields,types,data,f,em);
                 break;
            case "Brands":
                 Brands(entity,fields,types,data,f,em);
                 break;
            case "Companies":
                 Companies(entity,fields,types,data,f,em);
                 break;
            case "EmployeesTypes":
                 EmployeesTypes(entity,fields,types,data,f,em);
                 break;
            case "Employees":
                 Employees(entity,fields,types,data,f,em);
                 break;
            case "CompaniesRolesTypes":
                 CompaniesRolesTypes(entity,fields,types,data,f,em);
                 break;
            case "CompaniesRoles":
                 CompaniesRoles(entity,fields,types,data,f,em);
                 break;
            case "ChargesTypes":
                 ChargesTypes(entity,fields,types,data,f,em);
                 break;
            case "Charges":
                 Charges(entity,fields,types,data,f,em);
                 break;
            case "Pom":
                 Pom(entity,fields,types,data,f,em);
                 break;
            case "Dependencies":
                 Dependencies(entity,fields,types,data,f,em);
                 break;
            case "Imports":
                 Imports(entity,fields,types,data,f,em);
                 break;
            case "AttributesProperties":
                 AttributesProperties(entity,fields,types,data,f,em);
                 break;
            case "AttributesTypes":
                 AttributesTypes(entity,fields,types,data,f,em);
                 break;
            case "Fields":
                 Fields(entity,fields,types,data,f,em);
                 break;
            case "ImprovementTypes":
                 ImprovementTypes(entity,fields,types,data,f,em);
                 break;
            case "ImprovementSources":
                 ImprovementSources(entity,fields,types,data,f,em);
                 break;
            case "ContinualImprovements":
                 ContinualImprovements(entity,fields,types,data,f,em);
                 break;
            case "ActionPlans":
                 ActionPlans(entity,fields,types,data,f,em);
                 break;
            case "ImprovementVerifications":
                 ImprovementVerifications(entity,fields,types,data,f,em);
                 break;
            case "ImprovementClosures":
                 ImprovementClosures(entity,fields,types,data,f,em);
                 break;
            case "ClosingActivities":
                 ClosingActivities(entity,fields,types,data,f,em);
                 break;
            case "Developments":
                 Developments(entity,fields,types,data,f,em);
                 break;
            case "ModelsGroups":
                 ModelsGroups(entity,fields,types,data,f,em);
                 break;
            case "Models":
                 Models(entity,fields,types,data,f,em);
                 break;
            case "ModelRelationships":
                 ModelRelationships(entity,fields,types,data,f,em);
                 break;
            case "Relationships":
                 Relationships(entity,fields,types,data,f,em);
                 break;
            case "Cardinalities":
                 Cardinalities(entity,fields,types,data,f,em);
                 break;
            case "Entities":
                 Entities(entity,fields,types,data,f,em);
                 break;
            case "Attributes":
                 Attributes(entity,fields,types,data,f,em);
                 break;
            case "GroupIds":
                 GroupIds(entity,fields,types,data,f,em);
                 break;
            case "GroupIdsTypes":
                 GroupIdsTypes(entity,fields,types,data,f,em);
                 break;
            case "Persons":
                 Persons(entity,fields,types,data,f,em);
                 break;
            case "SitesTypes":
                 SitesTypes(entity,fields,types,data,f,em);
                 break;
            case "Sites":
                 Sites(entity,fields,types,data,f,em);
                 break;
            case "ActivitiesTypes":
                 ActivitiesTypes(entity,fields,types,data,f,em);
                 break;
            case "Activities":
                 Activities(entity,fields,types,data,f,em);
                 break;
            case "Calendars":
                 Calendars(entity,fields,types,data,f,em);
                 break;
            case "Tasks":
                 Tasks(entity,fields,types,data,f,em);
                 break;
            case "Priorities":
                 Priorities(entity,fields,types,data,f,em);
                 break;
            case "Diaries":
                 Diaries(entity,fields,types,data,f,em);
                 break;
        }

    } // Entities

    public void FundsLife(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        FundsLife fundsLife = new FundsLife();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "name":
                     fundsLife.setName(data[i]);
                     break;
            }

        } // for

        em.persist(fundsLife);
        em.flush();

    } // FundsLife

    public void Funds(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        Funds funds = new Funds();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
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

    public void SectionsTypes(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        SectionsTypes sectionsTypes = new SectionsTypes();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "name":
                     sectionsTypes.setName(data[i]);
                     break;
            }

        } // for

        em.persist(sectionsTypes);
        em.flush();

    } // SectionsTypes

    public void Sections(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        Sections sections = new Sections();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
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

    public void Series(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        Series series = new Series();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
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

    public void TrdSeries(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        TrdSeries trdSeries = new TrdSeries();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "name":
                     trdSeries.setName(data[i]);
                     break;
            }

        } // for

        em.persist(trdSeries);
        em.flush();

    } // TrdSeries

    public void Trd(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        Trd trd = new Trd();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "name":
                     trd.setName(data[i]);
                     break;
            }

        } // for

        em.persist(trd);
        em.flush();

    } // Trd

    public void FinalDisposition(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        FinalDisposition finalDisposition = new FinalDisposition();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "name":
                     finalDisposition.setName(data[i]);
                     break;
            }

        } // for

        em.persist(finalDisposition);
        em.flush();

    } // FinalDisposition

    public void DocumentalRetention(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        DocumentalRetention documentalRetention = new DocumentalRetention();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "name":
                     documentalRetention.setName(data[i]);
                     break;
            }

        } // for

        em.persist(documentalRetention);
        em.flush();

    } // DocumentalRetention

    public void FrequentlyQuery(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        FrequentlyQuery frequentlyQuery = new FrequentlyQuery();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "name":
                     frequentlyQuery.setName(data[i]);
                     break;
            }

        } // for

        em.persist(frequentlyQuery);
        em.flush();

    } // FrequentlyQuery

    public void DocumentalsUnits(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        DocumentalsUnits documentalsUnits = new DocumentalsUnits();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
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

    public void ConservationUnits(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        ConservationUnits conservationUnits = new ConservationUnits();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
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

    public void VersionsControls(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        VersionsControls versionsControls = new VersionsControls();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
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

    public void DocumentalInventory(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        DocumentalInventory documentalInventory = new DocumentalInventory();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "object":
                     documentalInventory.setObject(data[i]);
                     break;
            }

        } // for

        em.persist(documentalInventory);
        em.flush();

    } // DocumentalInventory

    public void OriginalOrders(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        OriginalOrders originalOrders = new OriginalOrders();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
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

    public void DocumentalsUnitsTypes(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        DocumentalsUnitsTypes documentalsUnitsTypes = new DocumentalsUnitsTypes();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "name":
                     documentalsUnitsTypes.setName(data[i]);
                     break;
            }

        } // for

        em.persist(documentalsUnitsTypes);
        em.flush();

    } // DocumentalsUnitsTypes

    public void Access(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        Access access = new Access();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "name":
                     access.setName(data[i]);
                     break;
            }

        } // for

        em.persist(access);
        em.flush();

    } // Access

    public void Organizeds(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        Organizeds organizeds = new Organizeds();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "name":
                     organizeds.setName(data[i]);
                     break;
            }

        } // for

        em.persist(organizeds);
        em.flush();

    } // Organizeds

    public void InventoryFinality(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        InventoryFinality inventoryFinality = new InventoryFinality();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "name":
                     inventoryFinality.setName(data[i]);
                     break;
            }

        } // for

        em.persist(inventoryFinality);
        em.flush();

    } // InventoryFinality

    public void DocumentalsSupports(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        DocumentalsSupports documentalsSupports = new DocumentalsSupports();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
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

    public void ConservationUnitsTypes(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        ConservationUnitsTypes conservationUnitsTypes = new ConservationUnitsTypes();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "name":
                     conservationUnitsTypes.setName(data[i]);
                     break;
            }

        } // for

        em.persist(conservationUnitsTypes);
        em.flush();

    } // ConservationUnitsTypes

    public void BooksTypes(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        BooksTypes booksTypes = new BooksTypes();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "name":
                     booksTypes.setName(data[i]);
                     break;
            }

        } // for

        em.persist(booksTypes);
        em.flush();

    } // BooksTypes

    public void Books(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        Books books = new Books();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "code":
                     books.setCode(data[i]);
                     break;
                case "name":
                     books.setName(data[i]);
                     break;
            }

        } // for

        em.persist(books);
        em.flush();

    } // Books

    public void Chapters(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        Chapters chapters = new Chapters();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "code":
                     chapters.setCode(data[i]);
                     break;
                case "name":
                     chapters.setName(data[i]);
                     break;
            }

        } // for

        em.persist(chapters);
        em.flush();

    } // Chapters

    public void Brands(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        Brands brands = new Brands();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "name":
                     brands.setName(data[i]);
                     break;
            }

        } // for

        em.persist(brands);
        em.flush();

    } // Brands

    public void Companies(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        Companies companies = new Companies();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "name":
                     companies.setName(data[i]);
                     break;
            }

        } // for

        em.persist(companies);
        em.flush();

    } // Companies

    public void EmployeesTypes(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        EmployeesTypes employeesTypes = new EmployeesTypes();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "name":
                     employeesTypes.setName(data[i]);
                     break;
            }

        } // for

        em.persist(employeesTypes);
        em.flush();

    } // EmployeesTypes

    public void Employees(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        Employees employees = new Employees();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "code":
                     employees.setCode(data[i]);
                     break;
            }

        } // for

        em.persist(employees);
        em.flush();

    } // Employees

    public void CompaniesRolesTypes(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        CompaniesRolesTypes companiesRolesTypes = new CompaniesRolesTypes();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "name":
                     companiesRolesTypes.setName(data[i]);
                     break;
            }

        } // for

        em.persist(companiesRolesTypes);
        em.flush();

    } // CompaniesRolesTypes

    public void CompaniesRoles(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        CompaniesRoles companiesRoles = new CompaniesRoles();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "name":
                     companiesRoles.setName(data[i]);
                     break;
            }

        } // for

        em.persist(companiesRoles);
        em.flush();

    } // CompaniesRoles

    public void ChargesTypes(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        ChargesTypes chargesTypes = new ChargesTypes();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "name":
                     chargesTypes.setName(data[i]);
                     break;
            }

        } // for

        em.persist(chargesTypes);
        em.flush();

    } // ChargesTypes

    public void Charges(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        Charges charges = new Charges();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "name":
                     charges.setName(data[i]);
                     break;
            }

        } // for

        em.persist(charges);
        em.flush();

    } // Charges

    public void Pom(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        Pom pom = new Pom();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "groupId":
                     pom.setGroupId(data[i]);
                     break;
                case "artifactId":
                     pom.setArtifactId(data[i]);
                     break;
                case "version":
                     pom.setVersion(data[i]);
                     break;
            }

        } // for

        em.persist(pom);
        em.flush();

    } // Pom

    public void Dependencies(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        Dependencies dependencies = new Dependencies();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "groupId":
                     dependencies.setGroupId(data[i]);
                     break;
                case "artifactId":
                     dependencies.setArtifactId(data[i]);
                     break;
                case "version":
                     dependencies.setVersion(data[i]);
                     break;
                case "type":
                     dependencies.setType(data[i]);
                     break;
                case "scope":
                     dependencies.setScope(data[i]);
                     break;
                case "maven":
                     dependencies.setMaven(data[i]);
                     break;
            }

        } // for

        em.persist(dependencies);
        em.flush();

    } // Dependencies

    public void Imports(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        Imports imports = new Imports();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "name":
                     imports.setName(data[i]);
                     break;
            }

        } // for

        em.persist(imports);
        em.flush();

    } // Imports

    public void AttributesProperties(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        AttributesProperties attributesProperties = new AttributesProperties();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "name":
                     attributesProperties.setName(data[i]);
                     break;
                case "value":
                     attributesProperties.setValue(data[i]);
                     break;
            }

        } // for

        em.persist(attributesProperties);
        em.flush();

    } // AttributesProperties

    public void AttributesTypes(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        AttributesTypes attributesTypes = new AttributesTypes();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "name":
                     attributesTypes.setName(data[i]);
                     break;
                case "type":
                     attributesTypes.setType(data[i]);
                     break;
                case "annotations":
                     attributesTypes.setAnnotations(data[i]);
                     break;
            }

        } // for

        em.persist(attributesTypes);
        em.flush();

    } // AttributesTypes

    public void Fields(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        Fields fields = new Fields();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "name":
                     fields.setName(data[i]);
                     break;
                case "description":
                     fields.setDescription(data[i]);
                     break;
            }

        } // for

        em.persist(fields);
        em.flush();

    } // Fields

    public void ImprovementTypes(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        ImprovementTypes improvementTypes = new ImprovementTypes();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "name":
                     improvementTypes.setName(data[i]);
                     break;
            }

        } // for

        em.persist(improvementTypes);
        em.flush();

    } // ImprovementTypes

    public void ImprovementSources(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        ImprovementSources improvementSources = new ImprovementSources();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "name":
                     improvementSources.setName(data[i]);
                     break;
            }

        } // for

        em.persist(improvementSources);
        em.flush();

    } // ImprovementSources

    public void ContinualImprovements(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        ContinualImprovements continualImprovements = new ContinualImprovements();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "code":
                     continualImprovements.setCode(data[i]);
                     break;
                case "description":
                     continualImprovements.setDescription(data[i]);
                     break;
                case "causesAnalysis":
                     continualImprovements.setCausesAnalysis(data[i]);
                     break;
                case "rootCause":
                     continualImprovements.setRootCause(data[i]);
                     break;
                case "immediateCorrection":
                     continualImprovements.setImmediateCorrection(data[i]);
                     break;
            }

        } // for

        em.persist(continualImprovements);
        em.flush();

    } // ContinualImprovements

    public void ActionPlans(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        ActionPlans actionPlans = new ActionPlans();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "evidences":
                     actionPlans.setEvidences(data[i]);
                     break;
            }

        } // for

        em.persist(actionPlans);
        em.flush();

    } // ActionPlans

    public void ImprovementVerifications(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        ImprovementVerifications improvementVerifications = new ImprovementVerifications();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
            }

        } // for

        em.persist(improvementVerifications);
        em.flush();

    } // ImprovementVerifications

    public void ImprovementClosures(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        ImprovementClosures improvementClosures = new ImprovementClosures();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
            }

        } // for

        em.persist(improvementClosures);
        em.flush();

    } // ImprovementClosures

    public void ClosingActivities(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        ClosingActivities closingActivities = new ClosingActivities();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "name":
                     closingActivities.setName(data[i]);
                     break;
            }

        } // for

        em.persist(closingActivities);
        em.flush();

    } // ClosingActivities

    public void Developments(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        Developments developments = new Developments();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "artifactId":
                     developments.setArtifactId(data[i]);
                     break;
                case "groupId":
                     developments.setGroupId(data[i]);
                     break;
                case "version":
                     developments.setVersion(data[i]);
                     break;
                case "code":
                     developments.setCode(data[i]);
                     break;
            }

        } // for

        em.persist(developments);
        em.flush();

    } // Developments

    public void ModelsGroups(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        ModelsGroups modelsGroups = new ModelsGroups();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "name":
                     modelsGroups.setName(data[i]);
                     break;
                case "code":
                     modelsGroups.setCode(data[i]);
                     break;
            }

        } // for

        em.persist(modelsGroups);
        em.flush();

    } // ModelsGroups

    public void Models(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        Models models = new Models();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "name":
                     models.setName(data[i]);
                     break;
                case "code":
                     models.setCode(data[i]);
                     break;
                case "version":
                     models.setVersion(data[i]);
                     break;
            }

        } // for

        em.persist(models);
        em.flush();

    } // Models

    public void ModelRelationships(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        ModelRelationships modelRelationships = new ModelRelationships();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "name":
                     modelRelationships.setName(data[i]);
                     break;
            }

        } // for

        em.persist(modelRelationships);
        em.flush();

    } // ModelRelationships

    public void Relationships(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        Relationships relationships = new Relationships();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "name":
                     relationships.setName(data[i]);
                     break;
            }

        } // for

        em.persist(relationships);
        em.flush();

    } // Relationships

    public void Cardinalities(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        Cardinalities cardinalities = new Cardinalities();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "name":
                     cardinalities.setName(data[i]);
                     break;
                case "cardinality":
                     cardinalities.setCardinality(data[i]);
                     break;
                case "isUnidirectional":
                     cardinalities.setIsUnidirectional(Boolean.valueOf(data[i]));
                     break;
            }

        } // for

        em.persist(cardinalities);
        em.flush();

    } // Cardinalities

    public void Entities(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        Entities entities = new Entities();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "name":
                     entities.setName(data[i]);
                     break;
                case "serialID":
                     entities.setSerialID(data[i]);
                     break;
                case "table":
                     entities.setTable(data[i]);
                     break;
                case "description":
                     entities.setDescription(data[i]);
                     break;
            }

        } // for

        em.persist(entities);
        em.flush();

    } // Entities

    public void Attributes(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        Attributes attributes = new Attributes();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "name":
                     attributes.setName(data[i]);
                     break;
                case "description":
                     attributes.setDescription(data[i]);
                     break;
            }

        } // for

        em.persist(attributes);
        em.flush();

    } // Attributes

    public void GroupIds(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        GroupIds groupIds = new GroupIds();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "artifactId":
                     groupIds.setArtifactId(data[i]);
                     break;
                case "groupId":
                     groupIds.setGroupId(data[i]);
                     break;
                case "version":
                     groupIds.setVersion(data[i]);
                     break;
                case "code":
                     groupIds.setCode(data[i]);
                     break;
            }

        } // for

        em.persist(groupIds);
        em.flush();

    } // GroupIds

    public void GroupIdsTypes(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        GroupIdsTypes groupIdsTypes = new GroupIdsTypes();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "name":
                     groupIdsTypes.setName(data[i]);
                     break;
            }

        } // for

        em.persist(groupIdsTypes);
        em.flush();

    } // GroupIdsTypes

    public void Persons(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        Persons persons = new Persons();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "firstName":
                     persons.setFirstName(data[i]);
                     break;
                case "secondName":
                     persons.setSecondName(data[i]);
                     break;
                case "firstLastName":
                     persons.setFirstLastName(data[i]);
                     break;
                case "secondLastName":
                     persons.setSecondLastName(data[i]);
                     break;
                case "email":
                     persons.setEmail(data[i]);
                     break;
                case "mobile":
                     persons.setMobile(data[i]);
                     break;
                case "telephone":
                     persons.setTelephone(data[i]);
                     break;
                case "skipe":
                     persons.setSkipe(data[i]);
                     break;
                case "address":
                     persons.setAddress(data[i]);
                     break;
            }

        } // for

        em.persist(persons);
        em.flush();

    } // Persons

    public void SitesTypes(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        SitesTypes sitesTypes = new SitesTypes();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "name":
                     sitesTypes.setName(data[i]);
                     break;
            }

        } // for

        em.persist(sitesTypes);
        em.flush();

    } // SitesTypes

    public void Sites(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        Sites sites = new Sites();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "title":
                     sites.setTitle(data[i]);
                     break;
                case "link":
                     sites.setLink(data[i]);
                     break;
                case "abc":
                     sites.setAbc(data[i]);
                     break;
                case "ipAddress1":
                     sites.setIpAddress1(data[i]);
                     break;
                case "ipAddress2":
                     sites.setIpAddress2(data[i]);
                     break;
                case "ipAddress3":
                     sites.setIpAddress3(data[i]);
                     break;
            }

        } // for

        em.persist(sites);
        em.flush();

    } // Sites

    public void ActivitiesTypes(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        ActivitiesTypes activitiesTypes = new ActivitiesTypes();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "name":
                     activitiesTypes.setName(data[i]);
                     break;
            }

        } // for

        em.persist(activitiesTypes);
        em.flush();

    } // ActivitiesTypes

    public void Activities(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        Activities activities = new Activities();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "name":
                     activities.setName(data[i]);
                     break;
            }

        } // for

        em.persist(activities);
        em.flush();

    } // Activities

    public void Calendars(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        Calendars calendars = new Calendars();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "name":
                     calendars.setName(data[i]);
                     break;
            }

        } // for

        em.persist(calendars);
        em.flush();

    } // Calendars

    public void Tasks(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        Tasks tasks = new Tasks();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "name":
                     tasks.setName(data[i]);
                     break;
            }

        } // for

        em.persist(tasks);
        em.flush();

    } // Tasks

    public void Priorities(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        Priorities priorities = new Priorities();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "name":
                     priorities.setName(data[i]);
                     break;
            }

        } // for

        em.persist(priorities);
        em.flush();

    } // Priorities

    public void Diaries(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        Diaries diaries = new Diaries();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "name":
                     diaries.setName(data[i]);
                     break;
                case "description":
                     diaries.setDescription(data[i]);
                     break;
            }

        } // for

        em.persist(diaries);
        em.flush();

    } // Diaries

}
