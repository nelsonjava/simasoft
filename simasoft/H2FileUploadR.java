package co.simasoft.gen.war.h2;

import co.simasoft.utils.*;

import java.io.*;
import java.lang.*;
import java.util.*;

import java.util.HashSet;
import java.util.Set;

public class H2FileUploadR extends FileTxt {

  private ArrayList<Atributos> atributos = new ArrayList<Atributos>() ;
  private ArrayList<Relation> relations = new ArrayList<Relation>();
  private Entidad entityFrom = new Entidad();
  private Entidad entityTo = new Entidad();
  private String cardinality = "";
  private String relationName = "";

  public H2FileUploadR(ArrayList<Entidad> entidades) {

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
line("@Named(\"fileUploadR\")");
line("public class FileUploadR {\n");

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

line("    public void relationshipsData(Boolean isValidate) {");
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
line("           JSONArray arrayRelationships = (JSONArray) jsonObject.get(\"RelationshipsData\");");
line("           Iterator iteRelation = arrayRelationships.iterator();");
line("           while (iteRelation.hasNext()) {\n");

line("                 JSONObject relationObj = (JSONObject) iteRelation.next();\n");

line("                 String from = (String)relationObj.get(\"From\");");
line("                 String fromProperty = (String)relationObj.get(\"FromProperty\");");
line("                 String fromValue = (String)relationObj.get(\"FromValue\");");
line("                 String to = (String)relationObj.get(\"To\");");
line("                 String toProperty = (String)relationObj.get(\"ToProperty\");");
line("                 String toValue = (String)relationObj.get(\"ToValue\");");
line("                 String name = (String)relationObj.get(\"Name\");");
line("                 String cardinalities = (String)relationObj.get(\"Cardinalities\");\n");

for (Entidad entidad : entidades) {

    for (Relation relation :entidad.getRelations()) {

        entityFrom = relation.getEntityFrom();
        entityTo = relation.getEntityTo();
        cardinality = relation.getNameCardinality();
        relationName = relation.getName();

        if (!(entidad.getName().equals(entityFrom.getName()))){
           continue;
        }
        if (!(cardinality.equals("Uno a Muchos Bidirecccional No.5"))){
           continue;
        }


line(entidad.getName()+"::"+entityFrom.getName()+" "+cardinality+" "+entityTo.getName()+" "+relationName);

    }

}

      for(Entidad entidad : entidades) {

         for(Relation relation :entidad.getRelations()) {

             entityFrom = relation.getEntityFrom();
             entityTo = relation.getEntityTo();
             cardinality = relation.getNameCardinality();
             relationName = relation.getName();

             if (!(entidad.getName().equals(entityFrom.getName()))){
                continue;
             }
             if (!(cardinality.equals("Uno a Muchos Bidirecccional No.5"))){
                continue;
             }

line("                 if (from.equals(\""+entityFrom.getName()+"\")){\n");

line("                     "+entityFrom.getName()+" "+Utils._1raMin(entityFrom.getName())+"From = new "+entityFrom.getName()+"();\n");

             atributos = entityFrom.getAtributos();
             Collections.sort(atributos);
             for(Atributos atributo : atributos ){

                 switch (atributo.getType()) {
                     case "String":

line("                     if (fromProperty.equals(\""+atributo.getField()+"\")){");
line("                         "+Utils._1raMin(entidad.getName())+"From = findBean."+atributo.getField()+entityFrom.getName()+"(fromValue,em);");
line("                         f.line(\"from:\"+fromValue+\":\"+"+Utils._1raMin(entidad.getName())+"From.get"+Utils._1raMay(atributo.getField())+"());");
line("                     } // "+Utils._1raMin(entidad.getName())+"\n");


                          break;
                     default:
                          break;
                 } // switch (atributo.getType())

             } // for: atributos

line("                     if (to.equals(\""+entityTo.getName()+"\")){\n");

line("                         "+entityTo.getName()+" "+Utils._1raMin(entityTo.getName())+"To = new "+entityTo.getName()+"();\n");


             atributos = entityTo.getAtributos();
             Collections.sort(atributos);
             for(Atributos atributo : atributos ){

                 switch (atributo.getType()) {
                     case "String":

line("                         if (toProperty.equals(\""+atributo.getField()+"\")){");
line("                             "+Utils._1raMin(entityTo.getName())+"To = findBean."+atributo.getField()+entityTo.getName()+"(toValue,em);");
line("                             f.line(\"to:\"+toValue+\":\"+"+Utils._1raMin(entityTo.getName())+"To.get"+Utils._1raMay(atributo.getField())+"());");
line("                         } // "+entityTo.getName()+"."+atributo.getField()+"\n");


                          break;
                     default:
                          break;
                 } // switch (atributo.getType())

             } // for: atributos

             switch (cardinality) {
                 case "Uno a Muchos Bidirecccional No.5":

line("                         if (cardinalities.equals(\"Uno a Muchos Bidirecccional No.5\")){");
                      if (entityFrom.getName().equals(entityTo.getName())){
line("                             "+Utils._1raMin(entityTo.getName())+"To.setObjPadre("+Utils._1raMin(entityFrom.getName())+"From);");
                      }
                      else{

                           if (relationName == null || relationName.equals("")){
line("                             "+Utils._1raMin(entityTo.getName())+"To.set"+entityFrom.getName()+"("+Utils._1raMin(entityFrom.getName())+"From);");
                           }
                           else{
line("                             "+Utils._1raMin(entityTo.getName())+"To.set"+Utils._1raMay(relationName)+"("+Utils._1raMin(entityFrom.getName())+"From);");
                           }

                      }


line("                         }\n");

line("                         if (!isValidate) {");
line("                             em.merge("+Utils._1raMin(entityTo.getName())+"To);");
line("                             em.flush();");
line("                         }\n");

line("                     } // to: "+entityTo.getName()+"\n");

line("                     if (isValidate) {");
line("                         f.saveFile(\"\\\\docs\", \""+Utils._1raMin(entityFrom.getName())+".txt\");\n");
line("                     }\n");


line("                 } // from: "+entityFrom.getName()+"\n");


                      break;
                 default:
                      break;
             } // switch (atributo.getType())

         } // entidad.getRelations()

      } // entidades

line("           } // while\n");

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

line("    } // relationshipsData()\n");

line("}\n");

  } // Contructor

} // Class