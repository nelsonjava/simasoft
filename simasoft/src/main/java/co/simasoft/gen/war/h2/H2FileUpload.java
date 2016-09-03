package co.simasoft.gen.war.h2;

import co.simasoft.utils.*;

import java.io.*;
import java.lang.*;
import java.util.*;

import java.util.HashSet;
import java.util.Set;

public class H2FileUpload extends FileTxt {

  public H2FileUpload(String artifactId,String groupId) {

line("package co.simasoft.setup;\n");

line("import co.simasoft.beans.*;");
line("import co.simasoft.utils.*;\n");

line("import co.simasoft.models.*;\n");

line("import java.io.FileNotFoundException;");
line("import java.io.FileReader;");
line("import java.io.IOException;");
line("import java.util.Iterator;\n");

line("import java.util.*;");
line("import java.util.Calendar;");
line("import java.util.Random;");
line("import javax.ejb.LocalBean;");
line("import javax.ejb.Singleton;");
line("import javax.inject.Named;");
line("import javax.persistence.EntityManager;");
line("import javax.persistence.PersistenceContext;");
line("import org.jboss.logging.Logger;\n");

line("import org.json.simple.JSONArray;");
line("import org.json.simple.JSONObject;");
line("import org.json.simple.parser.JSONParser;");
line("import org.json.simple.parser.ParseException;");
line("import javax.servlet.http.Part;\n");

line("import javax.faces.application.FacesMessage;");
line("import javax.faces.bean.ManagedBean;");
line("import javax.faces.context.FacesContext;\n");

line("import org.primefaces.event.FileUploadEvent;");
line("import org.primefaces.model.UploadedFile;\n");

line("import javax.ejb.LocalBean;");
line("import javax.ejb.Singleton;");
line("import javax.inject.Named;\n");

line("@Singleton");
line("@LocalBean");
line("@Named(\"fileUploadItems\")");
line("public class FileUploadItems {\n");

line("    private String filePath = \"\";\n");

line("    @PersistenceContext(unitName = \"crmPU-JTA\")");
line("    private EntityManager em;\n");

line("    FindBean findBean = new FindBean();\n");

line("    private UploadedFile file;\n");

line("    public UploadedFile getFile() {");
line("        return file;");
line("    }\n");

line("    public void setFile(UploadedFile file) {");
line("        this.file = file;");
line("    }\n");

line("    public void upload() {");
line("    try {\n");

line("        if(file != null) {\n");

line("           filePath = \"\\docs\\\"+file.getFileName();\n");

line("           FacesMessage message = new FacesMessage(\"Succesful\", filePath + \" is uploaded.\");");
line("           FacesContext.getCurrentInstance().addMessage(null, message);\n");

line("           FileTxt f = new FileTxt();\n");

line("           // read the json file");
line("           FileReader reader = new FileReader(filePath);\n");

line("           JSONParser jsonParser = new JSONParser();");
line("           JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);\n");

line("           // get an array from the JSON object");
line("           JSONArray arrayRelationships = (JSONArray) jsonObject.get(\"Items\");");
line("           Iterator iteRelation = arrayRelationships.iterator();");
line("           while (iteRelation.hasNext()) {\n");

line("                 JSONObject relationObj = (JSONObject) iteRelation.next();\n");

line("                 String serial = (String)relationObj.get(\"SERIAL\");");
line("                 String located = \"99\";");
line("                 String itemsNames = (String)relationObj.get(\"AREA\");\n");

line("                 Items items = new Items();");
line("                 items.setSerial(serial);");
line("                 items.setLocated(located);\n");

line("                 f.line(items.getSerial());");
line("                 f.line(\"\");\n");

line("                 em.persist(items);");
line("                 em.flush();\n");

line("           } // while\n");

line("           f.saveFile(\"\\docs\", \"items.txt\");\n");

line("        } // if\n");

line("    } catch (FileNotFoundException ex) {");
line("             ex.printStackTrace();");
line("    } catch (IOException ex) {");
line("             ex.printStackTrace();");
line("    } catch (ParseException ex) {");
line("             ex.printStackTrace();");
line("    } catch (NullPointerException ex) {");
line("             ex.printStackTrace();");
line("    } catch(Exception ioe) {");
line("            ioe.printStackTrace();");
line("    }\n");

line("    } // upload()\n");

line("}\n");

  } // Contructor

} // Class