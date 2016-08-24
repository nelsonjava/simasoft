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

    @PersistenceContext(unitName = "naifg29PU-JTA")
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

           String model = "";
           String groupIds = "";
           Models models = new Models();

           // read the json file
           FileReader reader = new FileReader(filePath);

           JSONParser jsonParser = new JSONParser();
           JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

           // get an array from the JSON object
           JSONArray arrayProperties = (JSONArray) jsonObject.get("properties");
           Iterator iteProperties = arrayProperties.iterator();
           while (iteProperties.hasNext()) {

                 JSONObject propertiesObj = (JSONObject) iteProperties.next();

                 model = (String)propertiesObj.get("model");
                 groupIds = (String)propertiesObj.get("groupIds");
                 
                 models = findBean.nameModels(model,em);
                 if (models  == null){

                    models = new Models();
                    models.setName(model);

                    GroupIds groupId = new GroupIds();
                    groupId = findBean.artifactIdGroupIds(groupIds,em);
                    models.setGroupIds(groupId);

                    f.line("model:"+models.getName());
                    f.line("groupIds:"+models.getGroupIds().getArtifactId());

                 }

                 em.persist(models);
                 em.flush();

                 models = findBean.nameModels(model,em);

           } // while

           // get an array from the JSON object
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("Relationships");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String relationshipsOrden = (String)relationObj.get("orden");
                 String from = (String)relationObj.get("From");
                 String to = (String)relationObj.get("To");
                 String relationName = (String)relationObj.get("name");
                 Boolean isOptionality = (Boolean)relationObj.get("isOptionality");
                 Boolean isEmbedded = (Boolean)relationObj.get("isEmbedded");
                 Boolean isSimplified = (Boolean)relationObj.get("isSimplified");
                 String cardinalities = (String)relationObj.get("Cardinalities");

                 Relationships relationships = new Relationships();
                 relationships.setOrden(Double.parseDouble(relationshipsOrden));
                 relationships.setName(relationName);
                 relationships.setIsOptionality(isOptionality);
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

                 models = findBean.nameModels(model,em);

                 ModelRelationships modelRelationships = new ModelRelationships();
                 modelRelationships.setOrden(relations.getOrden());
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