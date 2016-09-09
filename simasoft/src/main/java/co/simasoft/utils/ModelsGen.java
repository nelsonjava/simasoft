package co.simasoft.utils;

import co.simasoft.utils.*;
import co.simasoft.gen.asciidoc.*;
import co.simasoft.gen.jpa.*;
import co.simasoft.gen.rest.*;
import co.simasoft.gen.sql.*;
import co.simasoft.gen.bean.*;
import co.simasoft.gen.xhtml.*;
import co.simasoft.gen.war.*;
import co.simasoft.gen.war.h2.*;
import co.simasoft.gen.war.h2.rest.*;
import co.simasoft.persistence.sqlite.django.*;


import java.io.*;
import java.util.*;

public class ModelsGen extends FileTxt {

    private String name;
    private String groupId;
    private String artifactId;
    private ArrayList<Packages> packages = new ArrayList<Packages>();
    private ArrayList<Entidad> entities = new ArrayList<Entidad>(0);
    private Set<String> groupIdsArtifactId = new HashSet<String>();

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

    public ArrayList<Entidad> getEntities(){
        return entities;
    }
    public void setEntities(ArrayList<Entidad> entities){
        this.entities = entities;
    }

    public void addEntities(Entidad entity){
        this.entities.add(entity);
    }

    public Set<String> getGroupIdsArtifactId(){
        return groupIdsArtifactId;
    }
    public void setGroupIdsArtifactId(Set<String> groupIdsArtifactId){
        this.groupIdsArtifactId = groupIdsArtifactId;
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

                   Entidad entityFrom = seekEntidad(relation.getFrom());
                   entityFrom.setFieldCreate(entityFrom.fieldCreate());
                   relation.setEntityFrom(entityFrom);

                   Entidad entityTo = seekEntidad(relation.getTo());
                   entityTo.setFieldCreate(entityTo.fieldCreate());
                   relation.setEntityTo(entityTo);


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

/*
line("OJOOOO");
saveFile("\\docs", "OjoGen.txt");
*/


    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    } // WarH2()

    public void WarSqliteDjango() throws IOException {
    try {

        clearFileTxt();
        relationTo();
        entiyWarSqliteDjango();

    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    } // WarSqliteDjango()


    public void entiyWarSqliteDjango() throws IOException {

    try {

/*
        for (Entidad entidad : entities) {
            EntitySqliteDjango entitySqliteDjango = new EntitySqliteDjango(entidad.getGroupId(),entidad.getGroupId(),entidad,imports);
            Utils.fileMake(pathDocs+".sqlite.django."+artifactId+".models",entidad.getName()+".py", entitySqliteDjango);
        } // groupIds.getEntities()
*/

        ArrayList<FileTxt> entitiesSqliteDjango = new ArrayList<FileTxt>();
        for (Entidad entidad : entities) {
            EntitySqliteDjango entitySqliteDjango = new EntitySqliteDjango(entidad.getGroupId(),entidad.getGroupId(),entidad,imports);
            entitiesSqliteDjango.add(entitySqliteDjango);
        } // groupIds.getEntities()

        FileTxt models = new FileTxt();
        models.line("from __future__ import unicode_literals");
        models.line("from django.db import models\n");
        for (FileTxt entidad : entitiesSqliteDjango) {
             models.line(entidad.getSource());
        } // groupIds.getEntities()
        Utils.fileMake(pathDocs+".sqlite.django."+artifactId+".models","models.py", models);


    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }
    } // entiyWarSqliteDjango


    public void jdocbook() throws IOException {
    try {

        clearFileTxt();

        relationTo();

        Utils.fileJar("jdocbook","pom.xml",pathDocs+"\\h2\\war\\"+artifactId+"\\jdocbook\\",fileJar);
        Utils.fileJar("jdocbook","master.asciidoc",pathDocs+"\\h2\\war\\"+artifactId+"\\jdocbook\\src\\main\\asciidoc\\en-US\\",fileJar);
        Utils.fileJar("jdocbook","master-docinfo.xml",pathDocs+"\\h2\\war\\"+artifactId+"\\jdocbook\\src\\main\\asciidoc\\en-US\\",fileJar);

        Asciidoc fileAsciidoc = new Asciidoc(artifactId,groupId,entities);
        Utils.fileMake(pathDocs+".h2.war."+artifactId+".jdocbook.src.main.asciidoc.en-US.modules", "modelo.asciidoc", fileAsciidoc);

    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    } // Jdocbook()


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

        H2Gradle fileGradle = new H2Gradle(artifactId,groupId);
        Utils.fileMake(pathDocs+".h2.war."+artifactId, "build.gradle", fileGradle);

        Build build = new Build(artifactId,groupId);
        Utils.fileMake(pathDocs+".h2.war."+artifactId, "build.xml", build);

        H2Keycloak h2Keycloak = new H2Keycloak();
        Utils.fileMake(pathDocs+".h2.war."+artifactId,"keycloak.json", h2Keycloak);

        H2Datasource h2datasource = new H2Datasource(artifactId);
        Utils.fileMake(pathDocs+".h2.war."+artifactId+".src.main.webapp.WEB-INF",artifactId+"-ds.xml", h2datasource);

        H2Beans h2Beans = new H2Beans(artifactId);
        Utils.fileMake(pathDocs+".h2.war."+artifactId+".src.main.webapp.WEB-INF","beans.xml", h2Beans);

        H2FacesConfig h2FacesConfig = new H2FacesConfig(artifactId);
        Utils.fileMake(pathDocs+".h2.war."+artifactId+".src.main.webapp.WEB-INF","faces-config.xml", h2FacesConfig);

        H2Web h2Web = new H2Web(artifactId);
        Utils.fileMake(pathDocs+".h2.war."+artifactId+".src.main.webapp.WEB-INF","web.xml", h2Web);

        H2PropertyBean h2PropertyBean = new H2PropertyBean();
        Utils.fileMake(pathDocs+".h2.war."+artifactId+".src.main.java."+groupId+".authentication","PropertyBean.java", h2PropertyBean);

        H2Resources h2Resources = new H2Resources();
        Utils.fileMake(pathDocs+".h2.war."+artifactId+".src.main.java."+groupId+".authentication","Resources.java", h2Resources);

        H2SimpleAuthenticator h2SimpleAuthenticator = new H2SimpleAuthenticator();
        Utils.fileMake(pathDocs+".h2.war."+artifactId+".src.main.java."+groupId+".authentication","SimpleAuthenticator.java", h2SimpleAuthenticator);

        H2PageTemplateGen(pathDocs+".h2.war."+artifactId+".admin",artifactId,entities,groupIdsArtifactId);
        H2SetupTemplateGen(pathDocs+".h2.war."+artifactId+".src.main.webapp.resources.templates",artifactId,entities,groupIdsArtifactId);

        H2FileCsv h2FileCsv = new H2FileCsv();
        h2FileCsv.data(entities);

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
        Utils.fileJar("webH2/webapp/resources/templates","templateSetupp.xhtml",pathDocs+"\\h2\\war\\"+artifactId+"\\src\\main\\webapp\\resources\\templates\\",fileJar);
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

int i = 1;
line("entidades:"+Integer.toString(entities.size()));

        for (Entidad entidad : entities) {

line(Integer.toString(i++)+":"+entidad.getName());


            EntityH2 entityH2 = new EntityH2(entidad.getGroupId(),entidad.getGroupId(),entidad,imports);
            Utils.fileMake(pathDocs+".h2.war."+artifactId+".src.main.java."+entidad.getGroupId(),entidad.getName()+".java", entityH2);

            H2Find h2Find = new H2Find(artifactId,groupId,entities);
            Utils.fileMake(pathDocs+".h2.war."+artifactId+".src.main.java."+groupId+".Beans","FindBean.java", h2Find);

            H2Search h2Search = new H2Search(artifactId,groupId,entities);
            Utils.fileMake(pathDocs+".h2.war."+artifactId+".src.main.java."+groupId+".Beans","SearchBean.java", h2Search);

            H2Setup h2Setup = new H2Setup(artifactId,entidad.getGroupId());
            Utils.fileMake(pathDocs+".h2.war."+artifactId+".src.main.java."+groupId+".Setup","Setup.java", h2Setup);

            H2FileUpload h2FileUpload = new H2FileUpload(entities);
            Utils.fileMake(pathDocs+".h2.war."+artifactId+".src.main.java."+groupId+".Setup","FileUpload.java", h2FileUpload);
            
            H2FileUploadR h2FileUploadR = new H2FileUploadR(entities);
            Utils.fileMake(pathDocs+".h2.war."+artifactId+".src.main.java."+groupId+".Setup","FileUploadR.java", h2FileUpload);


            ViewH2 viewH2 = new ViewH2(entidad);
            Utils.fileMake(pathDocs+".h2.war."+artifactId+".admin."+Utils._1raMin(entidad.getName()),"view.xhtml", viewH2);

            CreateH2 createH2 = new CreateH2(entidad);
            Utils.fileMake(pathDocs+".h2.war."+artifactId+".admin."+Utils._1raMin(entidad.getName()),"create.xhtml", createH2);

            SearchH2 searchH2 = new SearchH2(entidad);
            Utils.fileMake(pathDocs+".h2.war."+artifactId+".admin."+Utils._1raMin(entidad.getName()),"search.xhtml", searchH2);

            BeanH2 beanH2 = new BeanH2(artifactId,groupId,entidad,imports);
            Utils.fileMake(pathDocs+".h2.war."+artifactId+".view",entidad.getName()+"Bean.java", beanH2);

        } // groupIds.getEntities()


    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }
    } // entiyWarH2()

    public void RestH2() throws IOException {
    try {

        clearFileTxt();

        relationTo();

        templateRestH2();

        entiyRestH2();

line("Rest");
saveFile("\\docs", "OjoGen.txt");


    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    } // RestH2()

    public void templateRestH2() throws IOException {
    try {

        H2RestPom filePom = new H2RestPom("r"+artifactId,groupId);
        Utils.fileMake(pathDocs+".h2.rest.r"+artifactId, "pom.xml", filePom);

        H2RestPomBak filePomBak = new H2RestPomBak("r"+artifactId,groupId);
        Utils.fileMake(pathDocs+".h2.rest.r"+artifactId, "pombak.xml", filePomBak);

        H2RestGradle fileGradle = new H2RestGradle(artifactId,groupId);
        Utils.fileMake(pathDocs+".h2.rest.r"+artifactId, "build.gradle", fileGradle);

        Build build = new Build(artifactId,groupId);
        Utils.fileMake(pathDocs+".h2.rest.r"+artifactId, "build.xml", build);

        H2RestDatasource h2RestDatasource = new H2RestDatasource("r"+artifactId);
        Utils.fileMake(pathDocs+".h2.rest.r"+artifactId+".src.main.webapp.WEB-INF","r"+artifactId+"-ds.xml", h2RestDatasource);

        H2RestWeb h2RestWeb = new H2RestWeb(artifactId);
        Utils.fileMake(pathDocs+".h2.rest.r"+artifactId+".src.main.webapp.WEB-INF","web.xml", h2RestWeb);

        BaseResource baseResource = new BaseResource();
        Utils.fileMake(pathDocs+".h2.rest.r"+artifactId+".src.main.java."+groupId+".service","BaseResource.java", baseResource);

        EntityCrud entityCrud = new EntityCrud();
        Utils.fileMake(pathDocs+".h2.rest.r"+artifactId+".src.main.java."+groupId+".service","EntityCrud.java", entityCrud);

        RestApplication restServiceApplication = new RestApplication(groupId,"services");
        Utils.fileMake(pathDocs+".h2.rest.r"+artifactId+".src.main.java."+groupId+".service", "RestApplication.java", restServiceApplication);

        RestApplication restApplication = new RestApplication(groupId,"rest");
        Utils.fileMake(pathDocs+".h2.rest.r"+artifactId+".src.main.java."+groupId+".rest", "RestApplication.java", restApplication);


    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    } // templateWarH22()

    public void entiyRestH2() throws IOException {
    try {

        H2RestPersistence h2RestPersistence = new H2RestPersistence("r"+artifactId,entities);
        Utils.fileMake(pathDocs+".h2.rest.r"+artifactId+".src.main.resources.META-INF", "persistence.xml", h2RestPersistence);

int i = 1;
line("entidades:"+Integer.toString(entities.size()));

        for (Entidad entidad : entities) {

line(Integer.toString(i++)+":"+entidad.getName());


            EntityH2 entityH2 = new EntityH2(entidad.getGroupId(),entidad.getGroupId(),entidad,imports);
            Utils.fileMake(pathDocs+".h2.rest.r"+artifactId+".src.main.java."+entidad.getGroupId(),entidad.getName()+".java", entityH2);

            Resource resource = new Resource(artifactId,groupId,entidad,imports);
            Utils.fileMake(pathDocs+".h2.rest.r"+artifactId+".src.main.java."+groupId+".service",entidad.getName()+"Resource.java", resource);

/*
            EntityRestEasy entityRestEasy = new EntityRestEasy(entidad.getGroupId(),entidad.getGroupId(),entidad,imports);
            Utils.fileMake(pathDocs+".h2.rest.r"+artifactId+".src.main.java."+entidad.getGroupId(),entidad.getName()+".java", entityRestEasy);
*/

            RestEndPoint restEndPoint = new RestEndPoint("r"+artifactId,groupId+".rest",entidad,imports);
            Utils.fileMake(pathDocs+".h2.rest.r"+artifactId+".src.main.java."+groupId+".rest",entidad.getName()+"Endpoint.java", restEndPoint);


        } // groupIds.getEntities()


    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }
    } // entiyWarH2()

/*
---------------------------------------- ForgeRestH2() --------------------------
*/

    public void ForgeRestH2() throws IOException {
    try {

        clearFileTxt();

        relationTo();

        line("#  jpa-generate-entities-from-tables --databaseTables * --targetPackage co.simasoft.models --hibernateDialect org.hibernate.dialect.H2Dialect --driverClass org.h2.Driver --jdbcUrl jdbc:h2:/db/tasks/data --userName sa --driverLocation D:/javasrv/keycloak-demo-1.5.0.Final/keycloak/modules/system/layers/base/com/h2database/h2/main/h2-1.3.173.jar;");
        line("project-new --named r"+artifactId+" --topLevelPackage co.simasoft");

        entiyForgeH2();

        saveFile("\\docs.h2.rest","b"+artifactId+".fsh");

        clearFileTxt();
        entiyForgeAngularH2();
        saveFile("\\docs.h2.rest","a"+artifactId+".fsh");

    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    } // ForgeRestH2()

/*
---------------------------------------- ForgeWarH2() --------------------------
*/

    public void ForgeWarH2() throws IOException {
    try {

        clearFileTxt();

        relationTo();

        line("scaffold-setup --provider Faces");
        line("scaffold-generate --web-root /admin --provider Faces --targets co.simasoft.models.*;");

        line("project-new --named w"+artifactId);
        line("jpa-setup");
        line("scaffold-setup --provider AngularJS\n");

        entiyForgeH2();


        saveFile("\\docs.h2.war","f"+artifactId+".fsh");

    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    } // ForgeWartH2()

/*
---------------------------------------- entiyForgeH2() --------------------------
*/

    public void entiyForgeH2() throws IOException {
    try {

/*
---------------------------------------- entities --------------------------
*/
        for (Entidad entidad : entities) {

            line("#  "+entidad.getName()+" entity");
            line("#  ############");
            line("jpa-new-entity --named "+entidad.getName()+" --targetPackage "+entidad.getGroupId());

            for (Atributos attribute :  entidad.getAtributos()){

                if (attribute.getType().equals("Date")){
                   line("jpa-new-field --named "+attribute.getField()+" --type java.util.Date --temporalType TIMESTAMP");
                }
                else{
                   line("jpa-new-field --named "+attribute.getField()+" --type "+attribute.getType());
                }

            }
            line("");

        } // groupIds.getEntities()

/*
---------------------------------------- Relations --------------------------
*/

        for (Entidad entidad : entities) {

//>>RELACIONES DE LA CLASE
      line("#  "+entidad.getName()+" Relationships ");
      line("#  ############");
      for(Relation relation : entidad.getRelations()) {

      line("#  ############"+relation.getCardinality());

//*******RELACION UNO A UNO
           if(relation.getCardinality().equals("1..1")) {

             if (relation.getEntityFrom().getName().equals(relation.getEntityTo().getName())){

                line("#Unitaria  "+relation.getEntityFrom().getName()+" "+relation.getNameCardinality()+" "+relation.getEntityTo().getName());
                line("cd ..");
                line("cd "+entidad.getName()+".java");
                line("jpa-new-field --named "+Utils._1raMin(relation.getEntityTo().getName())+
                                  " --type "+entidad.getGroupId()+"."+relation.getEntityTo().getName()+
                                  " --relationshipType One-to-One "+
                                  " ----inverseFieldName "+ Utils._1raMin(relation.getEntityFrom().getName()) +";\n");
             }
             else{
                if (entidad.getName().equals(relation.getEntityFrom().getName())){

                   line("#  "+relation.getEntityFrom().getName()+" "+relation.getNameCardinality()+" "+relation.getEntityTo().getName());
                   line("cd ..");
                   line("cd "+entidad.getName()+".java");
                   line("jpa-new-field --named "+Utils._1raMin(relation.getEntityTo().getName())+
                                   " --type "+entidad.getGroupId()+"."+relation.getEntityTo().getName()+
                                   " --relationshipType One-to-One "+
                                   " ----inverseFieldName "+ Utils._1raMin(relation.getEntityFrom().getName()) +";\n");
                }
                else{

                   line("#  "+relation.getEntityFrom().getName()+" "+relation.getNameCardinality()+" "+relation.getEntityTo().getName());
                   line("cd ..");
                   line("cd "+entidad.getName()+".java");
                   line("jpa-new-field --named "+Utils._1raMin(relation.getEntityFrom().getName())+
                                   " --type "+entidad.getGroupId()+"."+relation.getEntityFrom().getName()+
                                   " --relationshipType One-to-One "+
                                   " ----inverseFieldName "+Utils._1raMin(relation.getEntityTo().getName())+";\n");
                }
             }


           }
//*******FIN RELACION UNO A UNO

//*******RELACION MUCHOS A UNO
           if(relation.getCardinality().equals("*..1")) {

             if (relation.getEntityFrom().getName().equals(relation.getEntityTo().getName())){

                line("#Unitaria  "+relation.getEntityFrom().getName()+" "+relation.getNameCardinality()+" "+relation.getEntityTo().getName());
                line("cd ..");
                line("cd "+entidad.getName()+".java");
                line("jpa-new-field --named objPadre"+
                                  " --type "+entidad.getGroupId()+"."+relation.getEntityTo().getName()+
                                  " --relationshipType Many-to-One;\n");
             }
             else{
                if (entidad.getName().equals(relation.getEntityFrom().getName())){
                   line("#  "+relation.getEntityFrom().getName()+" "+relation.getNameCardinality()+" "+relation.getEntityTo().getName());
                   line("cd ..");
                   line("cd "+entidad.getName()+".java");
                   line("jpa-new-field --named "+Utils._1raMin(relation.getEntityTo().getName())+
                                     " --type "+entidad.getGroupId()+"."+relation.getEntityTo().getName()+
                                     " --relationshipType Many-to-One;\n");
                }
                else{
                   line("#  "+relation.getEntityFrom().getName()+" "+relation.getNameCardinality()+" "+relation.getEntityTo().getName());
                   line("cd ..");
                   line("cd "+entidad.getName()+".java");
                   line("jpa-new-field --named "+Utils._1raMin(relation.getEntityFrom().getName())+
                                     " --type "+entidad.getGroupId()+"."+relation.getEntityFrom().getName()+
                                     " --relationshipType Many-to-One;\n");
                }
             }

           }
//*******FIN RELACION MUCHOS A UNO

//*******RELACION UNO A MUCHOS
           if(relation.getCardinality().equals("1..*")) {

             if (relation.getEntityFrom().getName().equals(relation.getEntityTo().getName())){

                line("#Unitaria  "+relation.getEntityFrom().getName()+" "+relation.getNameCardinality()+" "+relation.getEntityTo().getName());
                line("cd ..");
                line("cd "+entidad.getName()+".java");
                line("jpa-new-field --named objHijos"+
                                  " --type "+entidad.getGroupId()+"."+relation.getEntityTo().getName()+
                                  " --relationshipType One-to-Many;\n");

             }
             else{
                if (entidad.getName().equals(relation.getEntityFrom().getName())){
                   line("#  "+relation.getEntityFrom().getName()+" "+relation.getNameCardinality()+" "+relation.getEntityTo().getName());
                   line("cd ..");
                   line("cd "+entidad.getName()+".java");
                   line("jpa-new-field --named "+Utils._1raMin(relation.getEntityTo().getName())+
                                     " --type "+entidad.getGroupId()+"."+relation.getEntityTo().getName()+
                                     " --relationshipType One-to-Many;\n");
                }
                else{
                   line("#  "+relation.getEntityFrom().getName()+" "+relation.getNameCardinality()+" "+relation.getEntityTo().getName());
                   line("cd ..");
                   line("cd "+entidad.getName()+".java");
                   line("jpa-new-field --named "+Utils._1raMin(relation.getEntityTo().getName())+
                                     " --type "+entidad.getGroupId()+"."+relation.getEntityTo().getName()+
                                     " --relationshipType One-to-Many;\n");
                }
             }

           }
//*******FIN RELACION UNO A MUCHOS

//*******RELACION MUCHOS A MUCHOS
           if(relation.getCardinality().equals("*..*")) {

             if (relation.getEntityFrom().getName().equals(relation.getEntityTo().getName())){

                line("#Unitaria  "+relation.getEntityFrom().getName()+" "+relation.getNameCardinality()+" "+relation.getEntityTo().getName());
                line("cd ..");
                line("cd "+entidad.getName()+".java");
                line("jpa-new-field --named "+Utils._1raMin(relation.getEntityTo().getName())+
                                  " --type "+entidad.getGroupId()+"."+relation.getEntityTo().getName()+
                                  " --relationshipType Many-to-Many "+
                                  " ----inverseFieldName "+ Utils._1raMin(relation.getEntityFrom().getName()) +";\n");
             }
             else{
                if (entidad.getName().equals(relation.getEntityFrom().getName())){

                   line("#  "+relation.getEntityFrom().getName()+" "+relation.getNameCardinality()+" "+relation.getEntityTo().getName());
                   line("cd ..");
                   line("cd "+entidad.getName()+".java");
                   line("jpa-new-field --named "+Utils._1raMin(relation.getEntityTo().getName())+
                                   " --type "+entidad.getGroupId()+"."+relation.getEntityTo().getName()+
                                   " --relationshipType Many-to-Many "+
                                   " ----inverseFieldName "+ Utils._1raMin(relation.getEntityFrom().getName()) +";\n");
                }
                else{

                   line("#  "+relation.getEntityFrom().getName()+" "+relation.getNameCardinality()+" "+relation.getEntityTo().getName());
                   line("cd ..");
                   line("cd "+entidad.getName()+".java");
                   line("jpa-new-field --named "+Utils._1raMin(relation.getEntityFrom().getName())+
                                   " --type "+entidad.getGroupId()+"."+relation.getEntityFrom().getName()+
                                   " --relationshipType Many-to-Many "+
                                   " ----inverseFieldName "+Utils._1raMin(relation.getEntityTo().getName())+";\n");
                }
             }

           }
//*******FIN RELACION MUCHOS A MUCHOS

      }
//>>FIN RELACIONES DE LA CLASE

        } // groupIds.getEntities()

//      line("scaffold-generate --provider AngularJS --targets "+entidad.getGroupId()+"."+entidad.getName());
        line("rest-generate-endpoints-from-entities --targets co.simasoft.models.*");

    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }
    } // entiyForgeH2()


/*
---------------------------------------- entiyForgeAngularH2() --------------------------
*/

    public void entiyForgeAngularH2() throws IOException {
    try {

        line("scaffold-setup --provider AngularJS\n");
        for (Entidad entidad : entities) {
             line("scaffold-generate --provider AngularJS --targets "+entidad.getGroupId()+"."+entidad.getName());
             line("");
        } // entities

    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }
    } // entiyForgeAngularH2

/*
---------------------------------------- H2PageTemplate() --------------------------
*/

    public void H2PageTemplateGen(String path,String artifactId,ArrayList<Entidad> entidades, Set<String> groupIdsArtifactId) {

        H2PageTemplate h2PageTemplate = new H2PageTemplate(artifactId,entities,groupIdsArtifactId,null);
        Utils.fileMake(path,"pageTemplate.xhtml", h2PageTemplate);

        for (String groupIds : groupIdsArtifactId) {
            h2PageTemplate = new H2PageTemplate(artifactId,entities,null,groupIds);
            Utils.fileMake(path,groupIds+"Template.xhtml", h2PageTemplate);
        }

    } // H2PageTemplate

/*
---------------------------------------- H2PageTemplate() --------------------------
*/

    public void H2SetupTemplateGen(String path,String artifactId,ArrayList<Entidad> entidades, Set<String> groupIdsArtifactId) {

        H2SetupTemplate h2SetupTemplate = new H2SetupTemplate(artifactId,entities,groupIdsArtifactId,null);
        Utils.fileMake(path,"templateSetup.xhtml", h2SetupTemplate);

        for (String groupIds : groupIdsArtifactId) {
            h2SetupTemplate = new H2SetupTemplate(artifactId,entities,null,groupIds);
            Utils.fileMake(path,groupIds+"Template.xhtml", h2SetupTemplate);
        }

    } // H2PageTemplate


} // ModelsGen