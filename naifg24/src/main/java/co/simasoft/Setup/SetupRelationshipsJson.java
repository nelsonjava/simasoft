package co.simasoft.setup;

import co.simasoft.beans.*;
import co.simasoft.utils.*;

import co.simasoft.models.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import javax.servlet.http.Part;


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
@Named("SetupRelationshipsJson")
public class SetupRelationshipsJson {

    @PersistenceContext(unitName = "naifg24PU-JTA")
    private EntityManager em;

    FindBean findBean = new FindBean();

    private static final Logger log = Logger.getLogger(naifgSetupJson.class.getName());
    private static final String filePath = "\\docs\\naifgRelationshipsSetup.json";

    public void data() throws IOException  {
    try {

         FileTxt f = new FileTxt();

/*

         f.line("paso1");

         String fileUpload = getFilename(file1);

         f.line("paso2");
         f.line(fileUpload);

         String filePath = "\\docs\\"+fileUpload;

         f.line("paso3");
         f.line(filePath);

         f.saveFile("\\docs", "PruebaWar.txt");
*/


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
/*
                relationships.setName(relationName);
                relationships.setIsOptionality(isOptionality);
                relationships.setIsEmbedded(isEmbedded);
                relationships.setIsSimplified(isSimplified);
                relationships.setIsCreate(true);
                relationships.setIsSearch(true);
                relationships.setIsView(true);
*/

                Entities entityFrom = new Entities();
                entityFrom = findBean.nameEntities(from,em);
                relationships.setFrom(entityFrom);

                Entities entityTo = new Entities();
                entityTo = findBean.nameEntities(to,em);
                relationships.setTo(entityTo);

                Cardinalities cardinality = new Cardinalities();
                cardinality = findBean.nameCardinalities(cardinalities,em);
                relationships.setCardinalities(cardinality);

                f.line("From:"+entityFrom.getName());
                f.line("To:"+entityTo.getName());
                f.line("Cardinalities:"+cardinality.getName());
                f.line("");

                em.persist(relationships);
                em.flush();

         }

         f.saveFile("\\docs", "naifgRelationshipsSetup.txt");


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

    private static String getFilename(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
    }

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
