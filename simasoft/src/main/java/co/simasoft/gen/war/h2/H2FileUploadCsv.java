package co.simasoft.gen.war.h2;

import co.simasoft.utils.*;

import java.io.*;
import java.lang.*;
import java.util.*;

import java.util.HashSet;
import java.util.Set;

public class H2FileUploadCsv extends FileTxt {

  private ArrayList<Atributos> atributos = new ArrayList<Atributos>() ;

  public H2FileUploadCsv(ArrayList<Entidad> entidades) {

line("package co.simasoft.setup;\n");

line("import co.simasoft.beans.*;");
line("import co.simasoft.utils.*;\n");

line("import co.simasoft.models.*;\n");

line("import java.util.*;");
line("import java.text.*;");
line("import java.util.Map.*;\n");

line("import java.io.BufferedReader;");
line("import java.io.FileNotFoundException;");
line("import java.io.FileReader;");
line("import java.io.IOException;\n");

line("import javax.ejb.LocalBean;");
line("import javax.ejb.Singleton;");
line("import javax.inject.Named;");
line("import javax.persistence.EntityManager;");
line("import javax.persistence.PersistenceContext;");
line("import org.jboss.logging.Logger;\n");

line("import javax.faces.application.FacesMessage;");
line("import javax.faces.context.FacesContext;\n");

line("import org.primefaces.event.FileUploadEvent;");
line("import org.primefaces.model.UploadedFile;\n");

line("@Singleton");
line("@LocalBean");
line("@Named(\"fileUploadCsv\")");
line("public class FileUploadCsv {\n");

line("    private String filePath = \"\";\n");

line("    BufferedReader br = null;\n");

line("    Integer i = 0;");
line("    String entity = \"\";");
line("    String line = \"\";");
line("    SimpleDateFormat formatter = new SimpleDateFormat(\"dd/MM/yyyy\");");
line("    String cvsSplitBy = null;\n");

line("    String[] types = new String[100];");
line("    String[] fields = new String[100];");
line("    String[] data;\n");

line("    @PersistenceContext(unitName = \"leanCrmPU-JTA\")");
line("    private EntityManager em;\n");

line("    private UploadedFile file;\n");

line("    public UploadedFile getFile() {");
line("        return file;");
line("    }\n");

line("    public void setFile(UploadedFile file) {");
line("        this.file = file;");
line("    }\n");

line("    public void data() {\n");

line("    try {\n");

line("        if(file != null) {\n");

line("           i = 0;");

line("           FileTxt f = new FileTxt();\n");

line("           filePath = \"\\\\docs\\\\\"+file.getFileName();\n");

line("           FacesMessage message = new FacesMessage(\"Succesful\", filePath + \" is uploaded.\");");
line("           FacesContext.getCurrentInstance().addMessage(null, message);\n");

line("           br = new BufferedReader(new FileReader(filePath));");
line("           while ((line = br.readLine()) != null) {\n");

line("              i++;");
line("              if (i==1){");
line("                  data = line.split(\"\");");
line("                  cvsSplitBy = data[data.length-1];");
line("              }");
line("              else{");
line("                  data = line.split(cvsSplitBy);");
line("              }\n");

line("              switch (i) {");
line("                  case 1:");
line("                       f.line(\"cvsSplitBy=\"+cvsSplitBy);");
line("                       break;");
line("                  case 2:");
line("                       entity = data[data.length-1];");
line("                       types = data;");
line("                       f.line(\"Entidad:\"+entity);");
line("                       break;");
line("                  case 3:");
line("                       fields = data;");
line("                       break;");
line("                  default:");
line("                       entitiesData(entity,fields,types,data,f,em);");
line("                       break;");
line("              }\n");

line("           }");
line("           f.saveFile(\"\\\\docs\", entity+\"Data.txt\");\n");

line("        } // if\n");


line("    } catch (FileNotFoundException ex) {");
line("             ex.printStackTrace();");
line("    } catch (IOException ex) {");
line("             ex.printStackTrace();");
line("    } catch (NullPointerException ex) {");
line("             ex.printStackTrace();");
line("    } catch(Exception ioe) {");
line("            ioe.printStackTrace();");
line("    } finally {");
line("        if (br != null) {");
line("            try {");
line("              br.close();");
line("            }");
line("            catch (IOException e) {");
line("                  e.printStackTrace();");
line("            }");
line("        }");
line("    }\n");

line("    } // data()\n");


line("    public void entitiesData(String entity,String[] fields,String[] types,String[] data,FileTxt f,EntityManager em) {\n");

line("        switch (entity) {");

      for(Entidad entidad : entidades) {

line("            case \""+entidad.getName()+"\":");
line("                 "+entidad.getName()+"(entity,fields,types,data,f,em);");
line("                 break;");

      }

line("        }\n");

line("    } // Entities\n");

      for(Entidad entidad : entidades) {


line("    public void "+entidad.getName()+"(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {\n");

line("        "+entidad.getName()+" "+Utils._1raMin(entidad.getName())+" = new "+entidad.getName()+"();\n");

line("        for(Integer i=0;i<=data.length-1;i+=1){\n");

line("            f.line(\"(\"+types[i]+\")\"+field[i]+\"=\"+data[i]);\n");

line("            switch (field[i]) {");

         atributos = entidad.getAtributos();
         Collections.sort(atributos);
         for(Atributos atributo : atributos ){

             switch (atributo.getType()) {
                 case "String":

line("                case \""+atributo.getField()+"\":");
line("                     "+Utils._1raMin(entidad.getName())+".set"+Utils._1raMay(atributo.getField())+"(data[i]);");
line("                     break;");

                      break;

                 case "Integer":

line("                case \""+atributo.getField()+"\":");
line("                     "+Utils._1raMin(entidad.getName())+".set"+Utils._1raMay(atributo.getField())+"(Integer.parseInt(data[i]));");
line("                     break;");

                      break;

                 case "Float":

line("                case \""+atributo.getField()+"\":");
line("                     "+Utils._1raMin(entidad.getName())+".set"+Utils._1raMay(atributo.getField())+"(Float.valueOf(data[i]));");
line("                     break;");

                      break;

                 case "Double":

line("                case \""+atributo.getField()+"\":");
line("                     "+Utils._1raMin(entidad.getName())+".set"+Utils._1raMay(atributo.getField())+"(Double.parseDouble(data[i]));");
line("                     break;");

                      break;

                 case "Boolean":

line("                case \""+atributo.getField()+"\":");
line("                     "+Utils._1raMin(entidad.getName())+".set"+Utils._1raMay(atributo.getField())+"(Boolean.valueOf(data[i]));");
line("                     break;");

                      break;

                 case "Date":

line("                case \""+atributo.getField()+"\":");
line("                     try {");
line("                       "+Utils._1raMin(entidad.getName())+".set"+Utils._1raMay(atributo.getField())+"(formatter.parse(data[i]));");
line("                     }");
line("                     catch (ParseException e) {");
line("                       e.printStackTrace();");
line("                     }");
line("                     break;");

                      break;

                 default:
                      break;
             } // switch (atributo.getType())

         }
line("            }\n");

line("        } // for\n");

line("        em.persist("+Utils._1raMin(entidad.getName())+");");
line("        em.flush();\n");

line("    } // "+entidad.getName()+"\n");

      } // for entidades

line("}");

  } // Contructor

} // Class