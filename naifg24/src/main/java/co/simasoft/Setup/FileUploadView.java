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

@ManagedBean
public class FileUploadView {
  
    private String filePath = "";

    @PersistenceContext(unitName = "naifg24PU-JTA")
    private EntityManager em;

    FindBean findBean = new FindBean();

    private UploadedFile file;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }


    public void upload() throws IOException {
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
         JSONArray arrayEntities = (JSONArray) jsonObject.get("Entities");
         Iterator iteEntities = arrayEntities.iterator();
         while (iteEntities.hasNext()) {

                JSONObject entityObj = (JSONObject) iteEntities.next();

                String entityName = (String)entityObj.get("name");
//                String entityGroupId = (String)entityObj.get("groupId");

                f.line("name:"+entityName);
//                f.line("groupId:"+entityGroupId);
                f.line("");

                Entities entity = new Entities();
                entity.setName(entityName);

/*
                entity.setGroupId(entityGroupId);
*/

/*
                GroupIds entitiesGroupId = new GroupIds();
                entitiesGroupId = findBean.groupIdGroupIds(entityGroupId,em);
                entity.setGroupIds(entitiesGroupId);
*/

/*
                em.persist(entity);
                em.flush();
*/

         }

         JSONArray arrayAttributes = (JSONArray) jsonObject.get("Attributes");
         Iterator iteAttribute = arrayAttributes.iterator();
         while (iteAttribute.hasNext()) {

                JSONObject attributeObj = (JSONObject) iteAttribute.next();

                String attributeEntity = (String)attributeObj.get("entity");
                String attributeName = (String)attributeObj.get("name");
                Boolean attributeIsNullable = (Boolean)attributeObj.get("isNullable");
                Boolean attributeIsUnique = (Boolean)attributeObj.get("isUnique");
                String attributeAttributesTypes = (String)attributeObj.get("AttributesTypes");

                Boolean attributeIsSimplified = (Boolean)attributeObj.get("isSimplified");
                Boolean attributeIsCreate = (Boolean)attributeObj.get("isCreate");
                Boolean attributeIsSearch = (Boolean)attributeObj.get("isSearch");
                Boolean attributeIsView = (Boolean)attributeObj.get("isView");
                Boolean attributeIsViewRelation = (Boolean)attributeObj.get("isViewRelation");
                Boolean attributeIsViewColumn = (Boolean)attributeObj.get("isViewColumn");

                f.line("entity:"+attributeEntity);
                f.line("name:"+attributeName);
                f.line("isNullable:"+String.valueOf(attributeIsNullable));
                f.line("isUnique:"+String.valueOf(attributeIsUnique));
                f.line("AttributesTypes:"+attributeAttributesTypes);
                f.line("");

                Attributes attributes = new Attributes();
                attributes.setName(attributeName);
                attributes.setIsNullable(attributeIsNullable);
                attributes.setIsUnique(attributeIsUnique);
                attributes.setIsSimplified(attributeIsSimplified);
                attributes.setIsCreate(attributeIsCreate);
                attributes.setIsSearch(attributeIsSearch);
                attributes.setIsView(attributeIsView);
                attributes.setIsViewRelation(attributeIsViewRelation);
                attributes.setIsViewColumn(attributeIsViewColumn);

                Entities entity1 = new Entities();
                entity1 = findBean.nameEntities(attributeEntity,em);
                attributes.setEntities(entity1);

                AttributesTypes attributesTypes = new AttributesTypes();
                attributesTypes = findBean.nameAttributesTypes(attributeAttributesTypes,em);
                attributes.setAttributesTypes(attributesTypes);

/*
                em.persist(attributes);
                em.flush();
*/

         }


         f.saveFile("\\docs", "PruebaWar.txt");

        }

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

    }
}