package co.simasoft.gen.war.h2;

import co.simasoft.utils.*;

import java.io.*;
import java.lang.*;
import java.util.*;

import java.util.HashSet;
import java.util.Set;

public class H2FileUpload extends FileTxt {

  private ArrayList<Atributos> atributos = new ArrayList<Atributos>() ;

  public H2FileUpload(ArrayList<Entidad> entidades) {

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
line("@Named(\"fileUpload\")");
line("public class FileUpload {\n");

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

      for(Entidad entidad : entidades) {

line("    public void "+Utils._1raMin(entidad.getName())+"() {");
line("    try {\n");

line("        if(file != null) {\n");

line("           filePath = \"\\\\docs\\\\\"+file.getFileName();\n");

line("           FacesMessage message = new FacesMessage(\"Succesful\", filePath + \" is uploaded.\");");
line("           FacesContext.getCurrentInstance().addMessage(null, message);\n");

line("           FileTxt f = new FileTxt();\n");

line("           // read the json file");
line("           FileReader reader = new FileReader(filePath);\n");

line("           JSONParser jsonParser = new JSONParser();");
line("           JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);\n");

line("           // get an array from the JSON object");
line("           JSONArray arrayRelationships = (JSONArray) jsonObject.get(\""+entidad.getName()+"\");");
line("           Iterator iteRelation = arrayRelationships.iterator();");
line("           while (iteRelation.hasNext()) {\n");

line("                 JSONObject relationObj = (JSONObject) iteRelation.next();\n");


         atributos = entidad.getAtributos();
         Collections.sort(atributos);
         for(Atributos atributo : atributos ){
             switch (atributo.getType()) {
                 case "String":
line("                 String "+atributo.getField()+" = (String)relationObj.get(\""+atributo.getField()+"\");");
                      break;
                 default:
                      break;

             } // switch (atributo.getType())
         } // atributos

line("");
line("                 "+entidad.getName()+" "+Utils._1raMin(entidad.getName())+" = new "+entidad.getName()+"();\n");

         for(Atributos atributo : atributos ){
             switch (atributo.getType()) {
                 case "String":
line("                 "+Utils._1raMin(entidad.getName())+".set"+Utils._1raMay(atributo.getField())+"("+Utils._1raMin(atributo.getField())+");");
line("                 f.line("+Utils._1raMin(entidad.getName())+".get"+Utils._1raMay(atributo.getField())+"());");
line("                 f.line(\"\");\n");
                      break;
                 default:
                      break;

             } // switch (atributo.getType())
         } // atributos

line("                 em.persist("+Utils._1raMin(entidad.getName())+");");
line("                 em.flush();\n");

line("           } // while\n");

line("           f.saveFile(\"\\\\docs\", \""+Utils._1raMin(entidad.getName())+".txt\");\n");

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

line("    } // "+Utils._1raMin(entidad.getName())+"()\n");

      } // for
      
line("}\n");

  } // Contructor

} // Class