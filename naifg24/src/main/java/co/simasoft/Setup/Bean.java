/*
  https://jsflive.wordpress.com/2013/04/23/jsf22-file-upload/
*/

package co.simasoft.setup;

import co.simasoft.utils.*;

import java.io.*;
import java.util.*;
import javax.servlet.http.Part;

public class Bean extends FileTxt {

  private Part file;
  private String fileContent;

  public void upload() {
    try {
      line("'paso1');
      fileContent = new Scanner(file.getInputStream()).useDelimiter("\\A").next();
//      saveFile("\\docs", "Bean.txt");
    } catch (IOException e) {
      // Error handling
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