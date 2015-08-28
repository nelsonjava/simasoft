package co.simasoft.utils;

import co.simasoft.utils.*;
import co.simasoft.gen.asciidoc.*;
import co.simasoft.gen.jpa.*;
import co.simasoft.gen.sql.*;
import co.simasoft.gen.bean.*;
import co.simasoft.gen.xhtml.*;
import co.simasoft.gen.war.*;
import co.simasoft.gen.war.h2.*;

import java.io.*;
import java.util.*;

public class ModelsGen extends FileTxt {

    private String name;
    private String groupId;
    private String artifactId;
    private ArrayList<Packages> packages = new ArrayList<Packages>();
    private Set<Entidad> entities = new HashSet<Entidad>(0);


    private LinkedHashSet<String> imports = new LinkedHashSet<String>();

    private String fileJar = "../g.jar";
    private String pathDocs = "\\docs";

    public ModelsGen(String groupId,String artifactId){
       this.groupId = groupId;
       this.artifactId = artifactId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getGroupId() {
        return groupId;
    }
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }
    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public LinkedHashSet<String> getImports(){
        return imports;
    }
    public void setImports(LinkedHashSet<String> imports){
        this.imports = imports;
    }

    public Set<Entidad> getEntities(){
        return entities;
    }
    public void setEntities(Set<Entidad> entities){
        this.entities = entities;
    }

    public void addEntities(Entidad entity){
        this.entities.add(entity);
    }

    public ArrayList<Packages> getPackages(){
        return packages;
    }
    public void setPackages(ArrayList<Packages> packages){
        this.packages = packages;
    }

    private void relationTo(){

        for(Packages groupIds : packages) {

            for(Entidad entidad : groupIds.getEntities()) {

               for(Relation relation : entidad.getRelations()) {

                   relation.setEntityTo(seekEntidad(relation.getTo()));

               } // entidad.getRelations()

            } // for: groupIds.getEntities()

        } // for: packages

    } // relationTo()

    private Entidad seekEntidad(String name){

        for(Packages groupIds : packages) {

            for(Entidad entidad : groupIds.getEntities()) {

                if (entidad.getName().equals(name)){
                   return entidad;
                }

            } // for: groupIds.getEntities()

        } // for: packages

        return null;

    } // seekEntidad()

    public void WarH2() throws IOException {
    try {

        clearFileTxt();

        relationTo();

        templateWarH2();

        entiyWarH2();


    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    } // WarH2()



    public void WarH22() throws IOException {
    try {

        clearFileTxt();

        relationTo();

        H2Pom filePom = new H2Pom(artifactId,groupId);
        Utils.fileMake(pathDocs+".h2.war."+artifactId, "pom.xml", filePom);

        Build build = new Build(artifactId,groupId);
        Utils.fileMake(pathDocs+".h2.war."+artifactId, "build.xml", build);

// Prueba verificar
/*
for (Packages groupIds : packages) {
    for (Entidad entidad : groupIds.getEntities()) {
         EntityH2 entityH2 = new EntityH2(groupIds.getGroupId(),groupIds.getGroupId(),entidad,imports);
         Utils.fileMake(pathDocs+".h2.war."+artifactId+".src.main.java."+groupIds.getGroupId(),entidad.getName()+".java", entityH2);
         line(entidad.getName());
    } // for: groupIds.getEntities()
} // for: packages
*/

        for (Packages groupIds : packages) {

            for (Entidad entidad : groupIds.getEntities()) {

                LinkedHashSet<String> cardinalityImports = new LinkedHashSet<String>();

                for (Relation relation : entidad.getRelations()) {

                     switch (relation.getCardinality()) {
                         case "1..1":
                              cardinalityImports.add("import javax.persistence.OneToOne;");
                              break;

                         case "*..1":
                              cardinalityImports.add("import javax.persistence.ManyToOne;");
                              break;

                         case "1..*":
                              cardinalityImports.add("import javax.persistence.OneToMany;");
                              cardinalityImports.add("import javax.persistence.ManyToOne;");
                              break;

                         case "*..*":
                              cardinalityImports.add("import javax.persistence.ManyToMany;");
                              break;

                   } // switch

                } // for: entidad.getRelations()

                for (String impor : cardinalityImports) {
                    imports.add(impor);
                } // for: cardinalityImports)

line(entidad.getName());
saveFile("\\docs", "ModelsGen.txt");

                EntityH2 entityH2 = new EntityH2(groupIds.getGroupId(),groupIds.getGroupId(),entidad,imports);
                Utils.fileMake(pathDocs+".h2.war."+artifactId+".src.main.java."+groupIds.getGroupId(),entidad.getName()+".java", entityH2);

/*
                H2Search h2Search = new H2Search(artifactId,groupIds.getGroupId(),groupIds.getEntities());
                Utils.fileMake(pathDocs+".h2.war."+artifactId+".src.main.java."+groupId+".Beans","SearchBean.java", h2Search);

                H2Find h2Find = new H2Find(artifactId,groupIds.getGroupId(),groupIds.getEntities());
                Utils.fileMake(pathDocs+".h2.war."+artifactId+".src.main.java."+groupId+".Beans","FindBean.java", h2Find);
*/

                H2Setup h2Setup = new H2Setup(artifactId,groupIds.getGroupId());
                Utils.fileMake(pathDocs+".h2.war."+artifactId+".src.main.java."+groupId+".Setup","Setup.java", h2Setup);

                ViewH2 viewH2 = new ViewH2(entidad);
                Utils.fileMake(pathDocs+".h2.war."+artifactId+".admin."+Utils._1raMin(entidad.getName()),"view.xhtml", viewH2);

                CreateH2 createH2 = new CreateH2(entidad);
                Utils.fileMake(pathDocs+".h2.war."+artifactId+".admin."+Utils._1raMin(entidad.getName()),"create.xhtml", createH2);

                SearchH2 searchH2 = new SearchH2(entidad);
                Utils.fileMake(pathDocs+".h2.war."+artifactId+".admin."+Utils._1raMin(entidad.getName()),"search.xhtml", searchH2);

/*
                BeanH2 beanH2 = new BeanH2(artifactId,groupId,entidad,imports);
                Utils.fileMake(pathDocs+"."+artifactId+".h2.war.src.main.java."+groupId+".view",entidad.getName()+"Bean.java", beanH2);

                CreateH2 createH2 = new CreateH2(entidad);
                Utils.fileMake(pathDocs+"."+artifactId+".h2.war.src.main.webapp.admin."+Utils._1raMin(entidad.getName()),"create.xhtml", createH2);

                SearchH2 searchH2 = new SearchH2(entidad);
                Utils.fileMake(pathDocs+"."+artifactId+".h2.war.src.main.webapp.admin."+Utils._1raMin(entidad.getName()),"search.xhtml", searchH2);

                ViewH2 viewH2 = new ViewH2(entidad);
                Utils.fileMake(pathDocs+"."+artifactId+".h2.war.src.main.webapp.admin."+Utils._1raMin(entidad.getName()),"view.xhtml", viewH2);
*/


            } // for: groupIds.getEntities()

        } // for: packages

/*
        BeanUtils beanUtils = new BeanUtils(artifactId,groupId,imports);
        Utils.fileMake(pathDocs+"."+artifactId+".h2.war.src.main.java."+groupId+".view","ViewUtils.java", beanUtils);
*/

        H2Persistence h2Persistence = new H2Persistence(artifactId,entities);
        Utils.fileMake(pathDocs+".h2.war."+artifactId+".src.main.resources.META-INF", "persistence.xml", h2Persistence);

        H2Datasource h2datasource = new H2Datasource(artifactId);
        Utils.fileMake(pathDocs+".h2.war."+artifactId+".src.main.webapp.WEB-INF",artifactId+"-ds.xml", h2datasource);

        H2Beans h2Beans = new H2Beans(artifactId);
        Utils.fileMake(pathDocs+".h2.war."+artifactId+".src.main.webapp.WEB-INF","beans.xml", h2Beans);

        H2FacesConfig h2FacesConfig = new H2FacesConfig(artifactId);
        Utils.fileMake(pathDocs+".h2.war."+artifactId+".src.main.webapp.WEB-INF","faces-config.xml", h2FacesConfig);

        H2Web h2Web = new H2Web(artifactId);
        Utils.fileMake(pathDocs+".h2.war."+artifactId+".src.main.webapp.WEB-INF","web.xml", h2Web);

/*
        H2PageTemplate h2PageTemplate = new H2PageTemplate(artifactId,entities);
        Utils.fileMake(pathDocs+"."+artifactId+".h2.war.src.main.webapp.resources.scaffold","pageTemplate.xhtml",h2PageTemplate);

        Paginator paginator = new Paginator();
        Utils.fileMake(pathDocs+"."+artifactId+".h2.war.src.main.webapp.resources.scaffold","paginator.xhtml", paginator);

        Utils.fileJar("webH2/webapp/admin","index.html",pathDocs+"\\"+artifactId+"\\h2\\war\\src\\main\\webapp\\admin\\",fileJar);
        Utils.fileJar("webH2/webapp/admin","index.xhtml",pathDocs+"\\"+artifactId+"\\h2\\war\\src\\main\\webapp\\admin\\",fileJar);
*/

        Utils.fileJar("webH2/webapp/resources","add.png",pathDocs+"\\h2\\war\\"+artifactId+"\\src\\main\\webapp\\resources\\",fileJar);
        Utils.fileJar("webH2/webapp/resources","bootstrap.css",pathDocs+"\\h2\\war\\"+artifactId+"\\src\\main\\webapp\\resources\\",fileJar);
        Utils.fileJar("webH2/webapp/resources","false.png",pathDocs+"\\h2\\war\\"+artifactId+"\\src\\main\\webapp\\resources\\",fileJar);
        Utils.fileJar("webH2/webapp/resources","favicon.ico",pathDocs+"\\h2\\war\\"+artifactId+"\\src\\main\\webapp\\resources\\",fileJar);
        Utils.fileJar("webH2/webapp/resources","forge-logo.png",pathDocs+"\\h2\\war\\"+artifactId+"\\src\\main\\webapp\\resources\\",fileJar);
        Utils.fileJar("webH2/webapp/resources","forge-style.css",pathDocs+"\\h2\\war\\"+artifactId+"\\src\\main\\webapp\\resources\\",fileJar);
        Utils.fileJar("webH2/webapp/resources","jboss-community.png",pathDocs+"\\h2\\war\\"+artifactId+"\\src\\main\\webapp\\resources\\",fileJar);
        Utils.fileJar("webH2/webapp/resources","remove.png",pathDocs+"\\h2\\war\\"+artifactId+"\\src\\main\\webapp\\resources\\",fileJar);
        Utils.fileJar("webH2/webapp/resources","search.png",pathDocs+"\\h2\\war\\"+artifactId+"\\src\\main\\webapp\\resources\\",fileJar);
        Utils.fileJar("webH2/webapp/resources","true.png",pathDocs+"\\h2\\war\\"+artifactId+"\\src\\main\\webapp\\resources\\",fileJar);

        Utils.fileJar("webH2/webapp/resources/css","screen.css",pathDocs+"\\h2\\war\\"+artifactId+"\\src\\main\\webapp\\resources\\css\\",fileJar);
        Utils.fileJar("webH2/webapp/resources/img","logo.jpg",pathDocs+"\\h2\\war\\"+artifactId+"\\src\\main\\webapp\\resources\\img\\",fileJar);
        Utils.fileJar("webH2/webapp/resources/templates","default.xhtml",pathDocs+"\\h2\\war\\"+artifactId+"\\src\\main\\webapp\\resources\\templates\\",fileJar);
        Utils.fileJar("webH2/webapp/resources/templates","templateSetup.xhtml",pathDocs+"\\h2\\war\\"+artifactId+"\\src\\main\\webapp\\resources\\templates\\",fileJar);
//        Utils.fileJar("webH2/webapp/resources","forge.taglib.xml",pathDocs+"\\"+artifactId+"\\h2\\war\\src\\main\\webapp\\WEB-INF\\classes\\META-INF\\",fileJar);

        Utils.fileJar("webH2/webapp/setup","index.xhtml",pathDocs+"\\h2\\war\\"+artifactId+"\\src\\main\\webapp\\setup\\",fileJar);
        Utils.fileJar("webH2/webapp/setup","index.xhtml",pathDocs+"\\h2\\war\\"+artifactId+"\\src\\main\\webapp\\setup\\",fileJar);
        Utils.fileJar("webH2/webapp/setup","index.html",pathDocs+"\\h2\\war\\"+artifactId+"\\src\\main\\webapp\\setup\\",fileJar);

        Utils.fileJar("webH2/webapp","home.xhtml",pathDocs+"\\h2\\war\\"+artifactId+"\\src\\main\\webapp\\",fileJar);
        Utils.fileJar("webH2/webapp","index.html",pathDocs+"\\h2\\war\\"+artifactId+"\\src\\main\\webapp\\",fileJar);
        Utils.fileJar("webH2/webapp","error.xhtml",pathDocs+"\\h2\\war\\"+artifactId+"\\src\\main\\webapp\\",fileJar);

        saveFile("\\docs", "ModelsGen.txt");

    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    } // WarH2()

    public void templateWarH2() throws IOException {
    try {

        H2Pom filePom = new H2Pom(artifactId,groupId);
        Utils.fileMake(pathDocs+".h2.war."+artifactId, "pom.xml", filePom);

        Build build = new Build(artifactId,groupId);
        Utils.fileMake(pathDocs+".h2.war."+artifactId, "build.xml", build);

        H2Datasource h2datasource = new H2Datasource(artifactId);
        Utils.fileMake(pathDocs+".h2.war."+artifactId+".src.main.webapp.WEB-INF",artifactId+"-ds.xml", h2datasource);

        H2Beans h2Beans = new H2Beans(artifactId);
        Utils.fileMake(pathDocs+".h2.war."+artifactId+".src.main.webapp.WEB-INF","beans.xml", h2Beans);

        H2FacesConfig h2FacesConfig = new H2FacesConfig(artifactId);
        Utils.fileMake(pathDocs+".h2.war."+artifactId+".src.main.webapp.WEB-INF","faces-config.xml", h2FacesConfig);

        H2Web h2Web = new H2Web(artifactId);
        Utils.fileMake(pathDocs+".h2.war."+artifactId+".src.main.webapp.WEB-INF","web.xml", h2Web);

        Utils.fileJar("webH2/webapp/resources","add.png",pathDocs+"\\h2\\war\\"+artifactId+"\\src\\main\\webapp\\resources\\",fileJar);
        Utils.fileJar("webH2/webapp/resources","bootstrap.css",pathDocs+"\\h2\\war\\"+artifactId+"\\src\\main\\webapp\\resources\\",fileJar);
        Utils.fileJar("webH2/webapp/resources","false.png",pathDocs+"\\h2\\war\\"+artifactId+"\\src\\main\\webapp\\resources\\",fileJar);
        Utils.fileJar("webH2/webapp/resources","favicon.ico",pathDocs+"\\h2\\war\\"+artifactId+"\\src\\main\\webapp\\resources\\",fileJar);
        Utils.fileJar("webH2/webapp/resources","forge-logo.png",pathDocs+"\\h2\\war\\"+artifactId+"\\src\\main\\webapp\\resources\\",fileJar);
        Utils.fileJar("webH2/webapp/resources","forge-style.css",pathDocs+"\\h2\\war\\"+artifactId+"\\src\\main\\webapp\\resources\\",fileJar);
        Utils.fileJar("webH2/webapp/resources","jboss-community.png",pathDocs+"\\h2\\war\\"+artifactId+"\\src\\main\\webapp\\resources\\",fileJar);
        Utils.fileJar("webH2/webapp/resources","remove.png",pathDocs+"\\h2\\war\\"+artifactId+"\\src\\main\\webapp\\resources\\",fileJar);
        Utils.fileJar("webH2/webapp/resources","search.png",pathDocs+"\\h2\\war\\"+artifactId+"\\src\\main\\webapp\\resources\\",fileJar);
        Utils.fileJar("webH2/webapp/resources","true.png",pathDocs+"\\h2\\war\\"+artifactId+"\\src\\main\\webapp\\resources\\",fileJar);

        Utils.fileJar("webH2/webapp/resources/css","screen.css",pathDocs+"\\h2\\war\\"+artifactId+"\\src\\main\\webapp\\resources\\css\\",fileJar);
        Utils.fileJar("webH2/webapp/resources/img","logo.jpg",pathDocs+"\\h2\\war\\"+artifactId+"\\src\\main\\webapp\\resources\\img\\",fileJar);
        Utils.fileJar("webH2/webapp/resources/templates","default.xhtml",pathDocs+"\\h2\\war\\"+artifactId+"\\src\\main\\webapp\\resources\\templates\\",fileJar);
        Utils.fileJar("webH2/webapp/resources/templates","templateSetup.xhtml",pathDocs+"\\h2\\war\\"+artifactId+"\\src\\main\\webapp\\resources\\templates\\",fileJar);
//        Utils.fileJar("webH2/webapp/resources","forge.taglib.xml",pathDocs+"\\"+artifactId+"\\h2\\war\\src\\main\\webapp\\WEB-INF\\classes\\META-INF\\",fileJar);

        Utils.fileJar("webH2/webapp/setup","index.xhtml",pathDocs+"\\h2\\war\\"+artifactId+"\\src\\main\\webapp\\setup\\",fileJar);
        Utils.fileJar("webH2/webapp/setup","index.xhtml",pathDocs+"\\h2\\war\\"+artifactId+"\\src\\main\\webapp\\setup\\",fileJar);
        Utils.fileJar("webH2/webapp/setup","index.html",pathDocs+"\\h2\\war\\"+artifactId+"\\src\\main\\webapp\\setup\\",fileJar);

        Utils.fileJar("webH2/webapp","home.xhtml",pathDocs+"\\h2\\war\\"+artifactId+"\\src\\main\\webapp\\",fileJar);
        Utils.fileJar("webH2/webapp","index.html",pathDocs+"\\h2\\war\\"+artifactId+"\\src\\main\\webapp\\",fileJar);
        Utils.fileJar("webH2/webapp","error.xhtml",pathDocs+"\\h2\\war\\"+artifactId+"\\src\\main\\webapp\\",fileJar);

    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    } // templateWarH22()

    public void entiyWarH2() throws IOException {
    try {

        H2Persistence h2Persistence = new H2Persistence(artifactId,entities);
        Utils.fileMake(pathDocs+".h2.war."+artifactId+".src.main.resources.META-INF", "persistence.xml", h2Persistence);

        for (Entidad entidad : entities) {

            EntityH2 entityH2 = new EntityH2(entidad.getGroupId(),entidad.getGroupId(),entidad,imports);
            Utils.fileMake(pathDocs+".h2.war."+artifactId+".src.main.java."+entidad.getGroupId(),entidad.getName()+".java", entityH2);
            
            H2Find h2Find = new H2Find(artifactId,groupId,entities);
            Utils.fileMake(pathDocs+".h2.war."+artifactId+".src.main.java."+groupId+".Beans","FindBean.java", h2Find);

            H2Search h2Search = new H2Search(artifactId,groupId,entities);
            Utils.fileMake(pathDocs+".h2.war."+artifactId+".src.main.java."+groupId+".Beans","SearchBean.java", h2Search);

            H2Setup h2Setup = new H2Setup(artifactId,entidad.getGroupId());
            Utils.fileMake(pathDocs+".h2.war."+artifactId+".src.main.java."+groupId+".Setup","Setup.java", h2Setup);

            ViewH2 viewH2 = new ViewH2(entidad);
            Utils.fileMake(pathDocs+".h2.war."+artifactId+".admin."+Utils._1raMin(entidad.getName()),"view.xhtml", viewH2);

            CreateH2 createH2 = new CreateH2(entidad);
            Utils.fileMake(pathDocs+".h2.war."+artifactId+".admin."+Utils._1raMin(entidad.getName()),"create.xhtml", createH2);

            SearchH2 searchH2 = new SearchH2(entidad);
            Utils.fileMake(pathDocs+".h2.war."+artifactId+".admin."+Utils._1raMin(entidad.getName()),"search.xhtml", searchH2);

        } // groupIds.getEntities()


    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }
    } // entiyWarH2()


} // ModelsGen