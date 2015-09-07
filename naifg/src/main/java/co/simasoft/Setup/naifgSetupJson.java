package co.simasoft.setup;

import co.simasoft.beans.*;
import co.simasoft.utils.*;

import co.simasoft.models.core.sites.*;
import co.simasoft.models.dev.naifg.*;
import co.simasoft.models.dev.naifg.dependencies.*;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.util.*;
import java.util.Calendar;
import java.util.Random;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jboss.logging.Logger;

@Singleton
@LocalBean
@Named("naifgSetupJson")
public class naifgSetupJson {

    @PersistenceContext(unitName = "naifgPU-JTA")
    private EntityManager em;

    FindBean findBean = new FindBean();

    private static final Logger log = Logger.getLogger(naifgSetup.class.getName());
    private static final String filePath = "\\docs\\naifgSetup.json";

    public void data() throws IOException  {
    try {

         FileTxt f = new FileTxt();

         // read the json file
         FileReader reader = new FileReader(filePath);

         JSONParser jsonParser = new JSONParser();
         JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

         // get a String from the JSON object
         String firstName =  (String) jsonObject.get("firstname");
         f.line("firstname:"+firstName);

         JSONArray arrayGroupIds = (JSONArray) jsonObject.get("GroupIds");
         Iterator iteGroupId = arrayGroupIds.iterator();
         while (iteGroupId.hasNext()) {

                JSONObject groupIdObj = (JSONObject) iteGroupId.next();

                String groupIdsGroupId = (String)groupIdObj.get("groupId");
                String groupIdsArtifactId = (String)groupIdObj.get("artifactId");

                f.line("groupId:"+groupIdsGroupId);
                f.line("artifactId:"+groupIdsArtifactId);
                f.line("");

                GroupIds groupIds = new GroupIds();
                groupIds.setGroupId(groupIdsGroupId);
                groupIds.setArtifactId(groupIdsArtifactId);
                em.persist(groupIds);
                em.flush();

         }

         JSONArray arrayModels = (JSONArray) jsonObject.get("Models");
         Iterator iteModels = arrayModels.iterator();
         while (iteModels.hasNext()) {

                JSONObject modelObj = (JSONObject) iteModels.next();

                String modelsGroupId = (String)modelObj.get("groupId");
                String modelsArtifactId = (String)modelObj.get("artifactId");
                String modelsVersion = (String)modelObj.get("artifactId");

                f.line("groupId:"+modelsGroupId);
                f.line("artifactId:"+modelsArtifactId);
                f.line("version:"+modelsVersion);
                f.line("");

                Models models = new Models();
                models.setGroupId(modelsGroupId);
                models.setArtifactId(modelsArtifactId);
                models.setVersion(modelsVersion);
                em.persist(models);
                em.flush();

         }

         // get an array from the JSON object
         JSONArray arrayEntities = (JSONArray) jsonObject.get("Entities");
         Iterator iteEntities = arrayEntities.iterator();
         while (iteEntities.hasNext()) {

                JSONObject entityObj = (JSONObject) iteEntities.next();

                String entityName = (String)entityObj.get("name");
                String entityGroupId = (String)entityObj.get("groupIds");

                f.line("name:"+entityName);
                f.line("groupIds:"+entityGroupId);
                f.line("");

                Entities entity = new Entities();
                entity.setName(entityName);
                entity.setIsSimplified(false);

                GroupIds entitiesGroupId = new GroupIds();
                entitiesGroupId = findBean.groupIdGroupIds(entityGroupId,em);

                entity.setGroupIds(entitiesGroupId);
                em.persist(entity);
                em.flush();

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

                f.line("OJOentity:"+attributeEntity);
                f.line("name:"+attributeName);
                f.line("isNullable:"+String.valueOf(attributeIsNullable));
                f.line("isUnique:"+String.valueOf(attributeIsUnique));
                f.line("AttributesTypes:"+attributeAttributesTypes);
                f.line("");

                Attributes attributes = new Attributes();
                attributes.setName(attributeName);
                attributes.setIsNullable(attributeIsNullable);
                attributes.setIsUnique(attributeIsUnique);
                attributes.setIsSimplified(false);
                attributes.setIsCreate(true);
                attributes.setIsSearch(true);
                attributes.setIsView(true);
                attributes.setIsViewRelation(true);
                attributes.setIsViewColumn(true);

                Entities entity1 = new Entities();
                entity1 = findBean.nameEntities(attributeEntity,em);
                attributes.setEntities(entity1);

                AttributesTypes attributesTypes = new AttributesTypes();
                attributesTypes = findBean.nameAttributesTypes(attributeAttributesTypes,em);
                attributes.setAttributesTypes(attributesTypes);

                em.persist(attributes);
                em.flush();




         }

         // get an array from the JSON object
         JSONArray arrayRelationships = (JSONArray) jsonObject.get("Relationships");
         Iterator iteRelation = arrayRelationships.iterator();
         while (iteRelation.hasNext()) {

                JSONObject relationObj = (JSONObject) iteRelation.next();

                String from = (String)relationObj.get("From");
                String to = (String)relationObj.get("To");
                Boolean isOptionality = (Boolean)relationObj.get("isOptionality");
                Boolean isEmbedded = (Boolean)relationObj.get("isEmbedded");
                Boolean isSimplified = (Boolean)relationObj.get("isSimplified");
                String cardinalities = (String)relationObj.get("Cardinalities");

/*
                f.line("From:"+from);
                f.line("To:"+to);
                f.line("isOptionality:"+isOptionality);
                f.line("isEmbedded:"+isEmbedded);
                f.line("isSimplified:"+isSimplified);
                f.line("Cardinalities:"+cardinalities);
                f.line("");
*/

                Relationships relationships = new Relationships();
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

                em.persist(relationships);
                em.flush();

         }

         f.saveFile("\\docs", "PruebaWar.txt");


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




    } // data()

} // naifgSetupJson

/*
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
*/
