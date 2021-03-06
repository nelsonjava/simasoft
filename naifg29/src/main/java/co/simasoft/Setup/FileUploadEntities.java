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
@Named("fileUploadEntities")
public class FileUploadEntities {

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

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void upload() throws IOException  {
    try {

        FileTxt f = new FileTxt();

        if(file != null) {
           filePath = "\\docs\\"+file.getFileName();
        }

        if(!filePath.equals("")) {


           FacesMessage message = new FacesMessage("Succesful", filePath + " is uploaded.");
           FacesContext.getCurrentInstance().addMessage(null, message);

           GroupIds groupId = new GroupIds();

           // read the json file
           FileReader reader = new FileReader(filePath);

           JSONParser jsonParser = new JSONParser();
           JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

           // get an array from the JSON object
           JSONArray arrayProperties = (JSONArray) jsonObject.get("properties");
           Iterator iteProperties = arrayProperties.iterator();
           while (iteProperties.hasNext()) {

                 JSONObject propertiesObj = (JSONObject) iteProperties.next();

                 String artifactId = (String)propertiesObj.get("groupIds");
                 String version = (String)propertiesObj.get("version");

                 groupId = findBean.artifactIdGroupIds(artifactId,em);
                 if (groupId  == null){

                    groupId = new GroupIds();
                    groupId.setArtifactId(artifactId);
                    groupId.setGroupId("co.simasoft.models");
                    groupId.setVersion(version);

                    em.persist(groupId);
                    em.flush();

                 }
                 f.line("groupIds:"+groupId.getArtifactId());
                 f.line("version:"+groupId.getVersion());

                 groupId = findBean.artifactIdGroupIds(artifactId,em);

           } // while


           // get an array from the JSON object
           JSONArray arrayEntities = (JSONArray) jsonObject.get("Entities");
           Iterator iteEntities = arrayEntities.iterator();
           while (iteEntities.hasNext()) {

                 JSONObject entityObj = (JSONObject) iteEntities.next();

                 String entityOrden = (String)entityObj.get("orden");
                 String entityName  = (String)entityObj.get("name");

                 GroupIds groupIds = new GroupIds();
                 groupIds = findBean.artifactIdGroupIds(groupId.getArtifactId(),em);

                 Entities entity = new Entities();
                 entity.setOrden(Double.parseDouble(entityOrden));

                 entity.setName(entityName);
                 entity.setGroupIds(groupIds);

                 f.line("name:"+entity.getName());


                 em.persist(entity);
                 em.flush();

           } // while

           f.saveFile("\\docs", "Entities.txt");

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