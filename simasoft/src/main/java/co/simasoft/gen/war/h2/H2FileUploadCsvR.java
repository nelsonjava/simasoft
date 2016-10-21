package co.simasoft.gen.war.h2;

import co.simasoft.utils.*;

import java.io.*;
import java.lang.*;
import java.util.*;

import java.util.HashSet;
import java.util.Set;

public class H2FileUploadCsvR extends FileTxt {

    private ArrayList<Atributos> atributos = new ArrayList<Atributos>() ;
    private ArrayList<Relation> relations = new ArrayList<Relation>();
    private Entidad entityFrom = new Entidad();
    private Entidad entityTo = new Entidad();
    private String cardinality = "";
    private String relationName = "";

    private LinkedHashSet<Entidad> entities = new LinkedHashSet<Entidad>();
    private LinkedHashSet<Entidad> entitiesTo = new LinkedHashSet<Entidad>();

    public H2FileUploadCsvR(ArrayList<Entidad> entidades) {

line("package co.simasoft.setup;\n");

line("import co.simasoft.beans.*;");
line("import co.simasoft.utils.*;\n");

line("import co.simasoft.models.*;\n");

line("import java.util.*;");
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
line("@Named(\"fileUploadCsvR\")");
line("public class FileUploadCsvR {\n");

line("    private String filePath = \"\";\n");

line("    @PersistenceContext(unitName = \"leanCrmPU-JTA\")");
line("    private EntityManager em;\n");

line("    private UploadedFile file;\n");

line("    public UploadedFile getFile() {");
line("        return file;");
line("    }\n");

line("    public void setFile(UploadedFile file) {");
line("        this.file = file;");
line("    }\n");

line("    public void data(Boolean isValidate) {\n");

line("        if(file != null) {\n");

line("           filePath = \"\\\\docs\\\\\"+file.getFileName();\n");

line("           FileTxt f = new FileTxt();\n");

line("           FacesMessage message = new FacesMessage(\"Succesful\", filePath + \" is uploaded.\");");
line("           FacesContext.getCurrentInstance().addMessage(null, message);\n");

line("           if(file.getFileName().indexOf(\"R5\") > 0){");
line("              relationshipsR5(filePath,em,isValidate,f);");
line("           }\n");

line("           if(file.getFileName().indexOf(\"R7\") > 0){");
line("              relationshipsR7(filePath,em,isValidate,f);");
line("           }\n");

line("        } // if\n");

line("    } // data()\n");

line("    public void relationshipsR5(String filePath,EntityManager em,Boolean isValidate,FileTxt f) {\n");

line("        BufferedReader br = null;\n");

line("        Integer i = 0;");
line("        String line = \"\";");
line("        String cvsSplitBy = \";\";");
line("        String[] fields = new String[100];\n");

line("    try {\n");

line("        br = new BufferedReader(new FileReader(filePath));");
line("        while ((line = br.readLine()) != null) {\n");

line("           // use comma as separator");
line("           String[] data = line.split(cvsSplitBy);\n");

line("           i++;");
line("           switch (i) {");
line("               case 1:");
line("                    fields = data;");
line("                    break;");
line("               default:");
line("                    relationshipsR5Data(fields,data,em,isValidate,f);");
line("                    break;");
line("           }");
line("        }\n");

line("        if (isValidate) {");
line("            f.saveFile(\"\\\\docs\", \"R5.txt\");\n");
line("        }\n");

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

line("    } // relationshipsR5\n");

line("    public void relationshipsR5Data(String[] fields,String[] data,EntityManager em,Boolean isValidate,FileTxt f) {\n");

line("        String from = data[0];");
line("        String fromProperty = data[1];");
line("        String fromValue = data[2];");
line("        String to = data[3];");
line("        String toProperty = data[4];");
line("        String toValue = data[5];");
line("        String name = data[6];");
line("        String cardinalities = data[7];\n");

line("        FindBean findBean = new FindBean();\n");

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

            if (relationName == null || relationName.equals("")){
line("        if (from.equals(\""+entityFrom.getName()+"\") &&");
line("            cardinalities.equals(\"Uno a Muchos Bidirecccional No.5\") &&");
line("            to.equals(\""+entityTo.getName()+"\") &&");
line("            name.equals(\"\")){\n");
            }
            else{
line("        if (from.equals(\""+entityFrom.getName()+"\") &&");
line("            cardinalities.equals(\"Uno a Muchos Bidirecccional No.5\") &&");
line("            to.equals(\""+entityTo.getName()+"\") &&");
line("            name.equals(\""+relationName+"\")){\n");
            }

line("            "+entityFrom.getName()+" "+Utils._1raMin(entityFrom.getName())+"From = new "+entityFrom.getName()+"();");
line("            "+entityTo.getName()+" "+Utils._1raMin(entityTo.getName())+"To = new "+entityTo.getName()+"();\n");


            atributos = entityFrom.getAtributos();
            Collections.sort(atributos);
            for(Atributos atributo : atributos ){ // from

                switch (atributo.getType()) {
                    case "String":

line("            if (fromProperty.equals(\""+atributo.getField()+"\")){");
line("                "+Utils._1raMin(entityFrom.getName())+"From = findBean."+atributo.getField()+entityFrom.getName()+"(fromValue,em);");
line("                f.line(\"from:\"+fromValue+\":\"+"+Utils._1raMin(entityFrom.getName())+"From.get"+Utils._1raMay(atributo.getField())+"());");
line("            } // "+Utils._1raMin(entityFrom.getName())+"\n");

                         break;
                    default:
                         break;
                } // switch (atributo.getType())

            } // atributos

            atributos = entityTo.getAtributos();
            Collections.sort(atributos);
            for(Atributos atributo : atributos ){ // to

                switch (atributo.getType()) {
                    case "String":

line("            if (toProperty.equals(\""+atributo.getField()+"\")){");
line("                "+Utils._1raMin(entityTo.getName())+"To = findBean."+atributo.getField()+entityTo.getName()+"(toValue,em);");
line("                f.line(\"to:\"+toValue+\":\"+"+Utils._1raMin(entityTo.getName())+"To.get"+Utils._1raMay(atributo.getField())+"());");
line("            } // "+Utils._1raMin(entityTo.getName())+"\n");

                         break;
                    default:
                         break;
                } // switch (atributo.getType())

            } // atributos

line("            if (cardinalities.equals(\""+cardinality+"\")){");

            if (entityFrom.getName().equals(entityTo.getName())){
line("                "+Utils._1raMin(entityTo.getName())+"To.setObjPadre("+Utils._1raMin(entityFrom.getName())+"From);");
            }
            else{
                 if(Utils.isEmpty(relationName)){
line("                "+Utils._1raMin(entityTo.getName())+"To.set"+entityFrom.getName()+"("+Utils._1raMin(entityFrom.getName())+"From);");
                 }
                 else{
line("                "+Utils._1raMin(entityTo.getName())+"To.set"+Utils._1raMay(relationName)+"("+Utils._1raMin(entityFrom.getName())+"From);");
                 }
            }


line("            }\n");


line("            if (!isValidate) {");
line("                em.merge("+Utils._1raMin(entityTo.getName())+"To);");
line("                em.flush();");
line("            }\n");

line("        } // from: "+entityFrom.getName()+"\n");

        } // entidad.getRelations()

    } // entidades

line("    } // relationshipsR5Data\n");

line("    public void relationshipsR7(String filePath,EntityManager em,Boolean isValidate,FileTxt f) {\n");

line("        BufferedReader br = null;\n");

line("        Integer i = 0;");
line("        Integer j = 0;");
line("        String line = \"\";");
line("        String cvsSplitBy = \";\";");
line("        String[] fields = new String[100];\n");

line("        String ant = \"\";");
line("        String actual = \"\";");
line("        String anterior = \"\";");
line("        Boolean isCambio = false;\n");

line("        String from = \"\";");
line("        String fromProperty = \"\";");
line("        String fromValue = \"\";");
line("        String to = \"\";");
line("        String toProperty = \"\";");
line("        String toValue = \"\";");
line("        String name = \"\";");
line("        String cardinalities = \"\";\n");

line("        FindBean findBean = new FindBean();\n");

line("    try {\n");

line("            anterior = \"\";\n");

    for(Entidad entidad : entidades) {

        for(Relation relation : entidad.getRelations()) {

            entityFrom = relation.getEntityFrom();
            entityTo = relation.getEntityTo();
            cardinality = relation.getNameCardinality();
            relationName = relation.getName();

            entities.add(entityFrom);
            entities.add(entityTo);
            entitiesTo.add(entityTo);

        } // entidad.getRelations()

    } // entidades

    for(Entidad entity : entities) {
line("            "+entity.getName()+" "+Utils._1raMin(entity.getName())+" = new "+entity.getName()+"();");
    } //

line("");

    for(Entidad entity : entitiesTo) {
line("            Set<"+entity.getName()+"> "+Utils._1raMin(entity.getName())+"s = new HashSet<"+entity.getName()+">();");
    } //
    
line("            br = new BufferedReader(new FileReader(filePath));");

==
voy aqui
==

line("} // Class");

  } // Contructor

} // Class