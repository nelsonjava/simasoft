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

                 } // from: DocumentalRetention Uno a Muchos Bidirecccional No.5 Trd

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

                 } // from: DocumentalRetention Uno a Muchos Bidirecccional No.5 Trd

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

