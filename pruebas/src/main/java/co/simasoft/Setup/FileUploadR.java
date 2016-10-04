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

    @PersistenceContext(unitName = "pruebasPU-JTA")
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
Predio::Predio Uno a Muchos Bidirecccional No.5 PhysicalSpaces 
Predio::Predio Uno a Muchos Bidirecccional No.5 Predio 
PhysicalSpaces::PhysicalSpaces Uno a Muchos Bidirecccional No.5 PhysicalSpaces 
PhysicalSpaces::PhysicalSpaces Uno a Muchos Bidirecccional No.5 Employees 
PhysicalSpacesTypes::PhysicalSpacesTypes Uno a Muchos Bidirecccional No.5 PhysicalSpaces 
PhysicalSpacesTypes::PhysicalSpacesTypes Uno a Muchos Bidirecccional No.5 PhysicalSpacesTypes 
PhysicalAreas::PhysicalAreas Uno a Muchos Bidirecccional No.5 PhysicalAreas 
PhysicalAreasTypes::PhysicalAreasTypes Uno a Muchos Bidirecccional No.5 PhysicalAreas 
*/

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
                     } // PhysicalSpaces.name

                     if (toProperty.equals("code")){
                         physicalSpacesTo = findBean.codePhysicalSpaces(toValue,em);
                         f.line("to:"+toValue+":"+physicalSpacesTo.getCode());
                     } // PhysicalSpaces.code

                     if (toProperty.equals("telExt")){
                         physicalSpacesTo = findBean.telExtPhysicalSpaces(toValue,em);
                         f.line("to:"+toValue+":"+physicalSpacesTo.getTelExt());
                     } // PhysicalSpaces.telExt

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         physicalSpacesTo.setPredio(predioFrom);
                     }

                     if (!isValidate) {
                         em.merge(physicalSpacesTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "predio.txt");

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
                     } // Predio.nomenclatura

                     if (toProperty.equals("predial")){
                         predioTo = findBean.predialPredio(toValue,em);
                         f.line("to:"+toValue+":"+predioTo.getPredial());
                     } // Predio.predial

                     if (toProperty.equals("estrato")){
                         predioTo = findBean.estratoPredio(toValue,em);
                         f.line("to:"+toValue+":"+predioTo.getEstrato());
                     } // Predio.estrato

                     if (toProperty.equals("matricula")){
                         predioTo = findBean.matriculaPredio(toValue,em);
                         f.line("to:"+toValue+":"+predioTo.getMatricula());
                     } // Predio.matricula

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         predioTo.setObjPadre(predioFrom);
                     }

                     if (!isValidate) {
                         em.merge(predioTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "predio.txt");

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

                     if (fromProperty.equals("code")){
                         physicalSpacesFrom = findBean.codePhysicalSpaces(fromValue,em);
                         f.line("from:"+fromValue+":"+physicalSpacesFrom.getCode());
                     } // physicalSpaces

                     if (fromProperty.equals("telExt")){
                         physicalSpacesFrom = findBean.telExtPhysicalSpaces(fromValue,em);
                         f.line("from:"+fromValue+":"+physicalSpacesFrom.getTelExt());
                     } // physicalSpaces

                     if (toProperty.equals("name")){
                         physicalSpacesTo = findBean.namePhysicalSpaces(toValue,em);
                         f.line("to:"+toValue+":"+physicalSpacesTo.getName());
                     } // PhysicalSpaces.name

                     if (toProperty.equals("code")){
                         physicalSpacesTo = findBean.codePhysicalSpaces(toValue,em);
                         f.line("to:"+toValue+":"+physicalSpacesTo.getCode());
                     } // PhysicalSpaces.code

                     if (toProperty.equals("telExt")){
                         physicalSpacesTo = findBean.telExtPhysicalSpaces(toValue,em);
                         f.line("to:"+toValue+":"+physicalSpacesTo.getTelExt());
                     } // PhysicalSpaces.telExt

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         physicalSpacesTo.setObjPadre(physicalSpacesFrom);
                     }

                     if (!isValidate) {
                         em.merge(physicalSpacesTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "physicalSpaces.txt");

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

                     if (fromProperty.equals("code")){
                         physicalSpacesFrom = findBean.codePhysicalSpaces(fromValue,em);
                         f.line("from:"+fromValue+":"+physicalSpacesFrom.getCode());
                     } // physicalSpaces

                     if (fromProperty.equals("telExt")){
                         physicalSpacesFrom = findBean.telExtPhysicalSpaces(fromValue,em);
                         f.line("from:"+fromValue+":"+physicalSpacesFrom.getTelExt());
                     } // physicalSpaces

                     if (toProperty.equals("code")){
                         employeesTo = findBean.codeEmployees(toValue,em);
                         f.line("to:"+toValue+":"+employeesTo.getCode());
                     } // Employees.code

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         employeesTo.setPhysicalSpaces(physicalSpacesFrom);
                     }

                     if (!isValidate) {
                         em.merge(employeesTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "physicalSpaces.txt");

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

                     if (toProperty.equals("name")){
                         physicalSpacesTo = findBean.namePhysicalSpaces(toValue,em);
                         f.line("to:"+toValue+":"+physicalSpacesTo.getName());
                     } // PhysicalSpaces.name

                     if (toProperty.equals("code")){
                         physicalSpacesTo = findBean.codePhysicalSpaces(toValue,em);
                         f.line("to:"+toValue+":"+physicalSpacesTo.getCode());
                     } // PhysicalSpaces.code

                     if (toProperty.equals("telExt")){
                         physicalSpacesTo = findBean.telExtPhysicalSpaces(toValue,em);
                         f.line("to:"+toValue+":"+physicalSpacesTo.getTelExt());
                     } // PhysicalSpaces.telExt

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         physicalSpacesTo.setPhysicalSpacesTypes(physicalSpacesTypesFrom);
                     }

                     if (!isValidate) {
                         em.merge(physicalSpacesTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "physicalSpacesTypes.txt");

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

                     if (toProperty.equals("name")){
                         physicalSpacesTypesTo = findBean.namePhysicalSpacesTypes(toValue,em);
                         f.line("to:"+toValue+":"+physicalSpacesTypesTo.getName());
                     } // PhysicalSpacesTypes.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         physicalSpacesTypesTo.setObjPadre(physicalSpacesTypesFrom);
                     }

                     if (!isValidate) {
                         em.merge(physicalSpacesTypesTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "physicalSpacesTypes.txt");

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
                     } // PhysicalAreas.name

                     if (toProperty.equals("code")){
                         physicalAreasTo = findBean.codePhysicalAreas(toValue,em);
                         f.line("to:"+toValue+":"+physicalAreasTo.getCode());
                     } // PhysicalAreas.code

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         physicalAreasTo.setObjPadre(physicalAreasFrom);
                     }

                     if (!isValidate) {
                         em.merge(physicalAreasTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "physicalAreas.txt");

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

                     if (toProperty.equals("name")){
                         physicalAreasTo = findBean.namePhysicalAreas(toValue,em);
                         f.line("to:"+toValue+":"+physicalAreasTo.getName());
                     } // PhysicalAreas.name

                     if (toProperty.equals("code")){
                         physicalAreasTo = findBean.codePhysicalAreas(toValue,em);
                         f.line("to:"+toValue+":"+physicalAreasTo.getCode());
                     } // PhysicalAreas.code

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         physicalAreasTo.setPhysicalAreasTypes(physicalAreasTypesFrom);
                     }

                     if (!isValidate) {
                         em.merge(physicalAreasTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "physicalAreasTypes.txt");

                     }

                 } // from: PhysicalAreasTypes

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

