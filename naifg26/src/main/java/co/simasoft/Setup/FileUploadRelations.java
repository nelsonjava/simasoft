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
@Named("fileUploadRelations")
public class FileUploadRelations {

    private String filePath = "";

    @PersistenceContext(unitName = "naifg26PU-JTA")
    private EntityManager em;

    FindBean findBean = new FindBean();

    private UploadedFile file;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public void upload() {
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
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("Relationships");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String from = (String)relationObj.get("From");
                 String to = (String)relationObj.get("To");
                 String relationName = (String)relationObj.get("name");
                 Boolean isOptionality = (Boolean)relationObj.get("isOptionality");
                 Boolean isEmbedded = (Boolean)relationObj.get("isEmbedded");
                 Boolean isSimplified = (Boolean)relationObj.get("isSimplified");
                 String cardinalities = (String)relationObj.get("Cardinalities");

                 Relationships relationships = new Relationships();
                 relationships.setName(relationName);
                 relationships.setIsOptionality(isOptionality);
                 relationships.setIsEmbedded(isEmbedded);
                 relationships.setIsSimplified(isSimplified);
                 relationships.setIsCreate(true);
                 relationships.setIsSearch(true);
                 relationships.setIsView(true);

                 Entities entityFrom = new Entities();
                 entityFrom = findBean.nameEntities(from,em);
                 relationships.setFrom(entityFrom);

                 Entities entityTo = new Entities();
                 entityTo = findBean.nameEntities(to,em);
                 relationships.setTo(entityTo);

                 Cardinalities cardinality = new Cardinalities();
                 cardinality = findBean.nameCardinalities(cardinalities,em);
                 relationships.setCardinalities(cardinality);

                 f.line(String.valueOf(relationships.getFrom().getId())+":"+
                        relationships.getFrom().getName()+" "+
                        relationships.getCardinalities().getName()+" "+
                        String.valueOf(relationships.getTo().getId())+":"+
                        relationships.getTo().getName());
                 f.line("");

                 em.persist(relationships);
                 em.flush();

                 Relationships relations = new Relationships();
//                 relations = findBean.relationships(relationships.getFrom().getId(),relationships.getTo().getId(),relationships.getCardinalities().getId(),em);

/*
                 Long ff = 112L;
                 Long tt = 117L;
                 Long cc = 81L;
*/

                 Long ff = entityFrom.getId();
                 Long tt = entityTo.getId();
                 Long cc = cardinality.getId();


                 relations = findBean.xrelationships(ff,tt,cc,em);

                 f.line("---");
                 f.line(String.valueOf(relations.getId()));
                 f.line(String.valueOf(relations.getFrom().getId()));
                 f.line(String.valueOf(relations.getTo().getId()));
                 f.line(String.valueOf(relations.getCardinalities().getId()));

                 Models models = new Models();
                 models = findBean.nameModels("tem",em);

                 ModelRelationships modelRelationships = new ModelRelationships();
                 modelRelationships.setName(Utils.nameRandom());
                 modelRelationships.setModels(models);
                 modelRelationships.setRelationships(relations);

                 em.persist(modelRelationships);
                 em.flush();


           } // while

           f.saveFile("\\docs", "relations.txt");

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

    } // upload()

}