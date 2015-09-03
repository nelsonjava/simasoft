package co.simasoft;

import co.simasoft.utils.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class App {

    private static final String filePath = "\\docs\\naifgSetup.json";

    public static void main( String[] args ){

		try {

                        FileTxt f = new FileTxt();

			// read the json file
			FileReader reader = new FileReader(filePath);

			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

			// get a String from the JSON object
			String firstName =  (String) jsonObject.get("firstname");
			f.line("firstname:"+firstName);

			// get a number from the JSON object
			long id =  (long) jsonObject.get("id");
			System.out.println("id: " + id);

			// get an array from the JSON object
			JSONArray lang= (JSONArray) jsonObject.get("GroupIds");

			// take the elements of the json array
			for(int i=0; i<lang.size(); i++){
				System.out.println("The " + i + " element of the array: "+lang.get(i));
			        f.line(lang.get(i)+"\n");
			}
			Iterator i = lang.iterator();

			// take each value from the json array separately
			while (i.hasNext()) {
				JSONObject innerObj = (JSONObject) i.next();
				System.out.println("language "+ innerObj.get("groupId") +
						" with level " + innerObj.get("artifactId"));
			        f.line("groupId:"+innerObj.get("groupId"));
			        f.line("artifactId:"+innerObj.get("artifactId"));
			        f.line("");
			}

			// get an array from the JSON object
			JSONArray models = (JSONArray) jsonObject.get("Models");
			Iterator model = models.iterator();

			while (model.hasNext()) {
				JSONObject modelObj = (JSONObject) model.next();
			        f.line("groupId:"+modelObj.get("groupId"));
			        f.line("artifactId:"+modelObj.get("artifactId"));
			        f.line("version:"+modelObj.get("version"));
			        f.line("");
			}

			// get an array from the JSON object
			JSONArray entities = (JSONArray) jsonObject.get("Entities");
			Iterator entity = entities.iterator();

			while (entity.hasNext()) {
				JSONObject entityObj = (JSONObject) entity.next();
			        f.line("name:"+entityObj.get("name"));
			        f.line("groupIds:"+entityObj.get("groupIds"));
			        f.line("");
			}


                        f.saveFile("\\docs", "Prueba.txt");

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

    } // main

} // App
