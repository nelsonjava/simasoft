/*
  https://jsflive.wordpress.com/2013/04/23/jsf22-file-upload/
  https://github.com/creepid/jsf-fileupload
*/

package co.simasoft.setup;

import co.simasoft.utils.*;
import javax.servlet.http.Part;

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

public class Bean extends FileTxt {

  private Part file;
  private String fileContent;

  public void upload() throws IOException {
    try {

      line("paso1");
      fileContent = new Scanner(file.getInputStream()).useDelimiter("\\A").next();
      saveFile("\\docs", "Bean.txt");
      
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

  public Part getFile() {
//    line('paso1');
    return file;
  }

  public void setFile(Part file) {
//    line('paso2');
    this.file = file;
  }

/*
  public void validateFile(FacesContext ctx,UIComponent comp,Object value) {
      List<FacesMessage> msgs = new ArrayList<FacesMessage>();
      Part file = (Part)value;
      if (file.getSize() > 1024) {
          msgs.add(new FacesMessage("file too big"));
      }
      if (!"text/plain".equals(file.getContentType())) {
         msgs.add(new FacesMessage("not a text file"));
      }
      if (!msgs.isEmpty()) {
         throw new ValidatorException(msgs);
      }
  }
*/

}