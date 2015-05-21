package com.simavirtual;

import java.io.*;
import java.util.*;

import co.simasoft.utils.*;

import co.simasoft.gen.asciidoc.*;
import co.simasoft.gen.jpa.*;
import co.simasoft.gen.sql.*;
import co.simasoft.gen.bean.*;
import co.simasoft.gen.xhtml.*;
import co.simasoft.gen.war.*;
import co.simasoft.gen.war.h2.*;

public class App extends FileTxt{

    private static ArrayList<Packages> groupIds       = new ArrayList<Packages>();
    private static ArrayList<Entidad> entidades       = new ArrayList<Entidad>();
    private static Set<Relation> relations            = new HashSet<Relation>(0);
    private static ArrayList<Modelos> modelos         = new ArrayList<Modelos>();
    private static ArrayList<Relation> relationsPower = new ArrayList<Relation>();

    private static String fileJar = "../g.jar";
    private static String filePowerDesigner = "";
    private static String pathDocs = "\\docs";
    private static String artifactId = "";
    private static String asciidocImages = "src.main.asciidoc.en-US.images";
    private static String asciidocModules = "src.main.asciidoc.en-US.modules";

    public static void jdocbook(String modelo,String groupId,String artifactId,LinkedHashSet<String> imports) throws IOException {

        // Cleanup - Reinigung
        entidades.clear();
        relationsPower.clear();
        relations.clear();

        filePowerDesigner = "src/resources/models/"+modelo+"/"+artifactId+"/"+artifactId+".oom";

        PowerDesigner powerDesigner = new PowerDesigner(filePowerDesigner);
        entidades = powerDesigner.getEntidades();
        relations = powerDesigner.getRelations();
        relationsPower = powerDesigner.getRelationsPower();

        Utils.mkDirs(pathDocs+"."+modelo+"."+artifactId+".jdocbook."+asciidocImages);
        Utils.mkDirs(pathDocs+"."+modelo+"."+artifactId+".jdocbook."+asciidocModules);

        Utils.copyFile("src/resources/models/"+modelo+"/"+artifactId+"/"+artifactId+".jpg",
                       pathDocs+"/"+modelo+"/"+artifactId+"/jdocbook/src/main/asciidoc/en-US/images/modelo.jpg");

        Utils.fileJar("jdocbook","pom.xml",pathDocs+"\\"+modelo+"\\"+artifactId+"\\jdocbook\\",fileJar);
        Utils.fileJar("jdocbook","master.asciidoc",pathDocs+"\\"+modelo+"\\"+artifactId+"\\jdocbook\\src\\main\\asciidoc\\en-US\\",fileJar);
        Utils.fileJar("jdocbook","master-docinfo.xml",pathDocs+"\\"+modelo+"\\"+artifactId+"\\jdocbook\\src\\main\\asciidoc\\en-US\\",fileJar);

        Asciidoc fileAsciidoc = new Asciidoc(artifactId,groupId,entidades);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".jdocbook.src.main.asciidoc.en-US.modules", "modelo.asciidoc", fileAsciidoc);

        Test fileTest = new Test(artifactId,groupId,relations,relationsPower);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".jdocbook.src.main.asciidoc.en-US.modules", "test.asciidoc", fileTest);

    } // jdocbook

    public static void jpa(String modelo,String groupId,String artifactId,LinkedHashSet<String> imports) throws IOException {

        // Cleanup - Reinigung
        entidades.clear();
        relationsPower.clear();
        relations.clear();

        filePowerDesigner = "src/resources/models/"+modelo+"/"+artifactId+"/"+artifactId+".oom";

        PowerDesigner powerDesigner = new PowerDesigner(filePowerDesigner);
        entidades = powerDesigner.getEntidades();
        relations = powerDesigner.getRelations();
        relationsPower = powerDesigner.getRelationsPower();

        for(Entidad entidad : entidades) {

            Entity0 entity0 = new Entity0(artifactId,groupId+".models."+modelo+"."+artifactId,entidad,imports);
            Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".jpa.0",entidad.getName()+".java", entity0);

            EntityMongo entityMongo = new EntityMongo(artifactId,groupId+".models."+modelo+"."+artifactId,entidad,imports);
            Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".jpa.mongo",entidad.getName()+".java", entityMongo);

            EntityH2 entityH2 = new EntityH2(artifactId,groupId,entidad,imports);
            Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".jpa.h2",entidad.getName()+".java", entityH2);

            EntityPruebaMongo entityPruebaMongo = new EntityPruebaMongo(artifactId,groupId+".models."+modelo+"."+artifactId,entidad,imports);
            Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".jpa.pmongo",entidad.getName()+".java", entityPruebaMongo);

            EntityPruebaH2 entityPruebaH2 = new EntityPruebaH2(artifactId,groupId+"."+modelo+".models."+artifactId,entidad,imports);
            Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".jpa.ph2",entidad.getName()+".java", entityPruebaH2);

            EntityPrueba entityPrueba = new EntityPrueba(artifactId,groupId,entidad,imports);
            Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".jpa.pruebas",entidad.getName()+".java", entityPrueba);

        }

        Persistence persistence = new Persistence(artifactId,groupId+".models."+modelo,entidades);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".jpa", "persistence.xml", persistence);

        Datasource datasource = new Datasource(artifactId,groupId,entidades);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".jpa",artifactId+"-ds.xml", datasource);

        GuiFsh guiFsh = new GuiFsh(artifactId,groupId+".models."+modelo,imports);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".jpa", "gui.fsh", guiFsh);

    } // jpa

    public static void crud(String modelo,String groupId,String artifactId,LinkedHashSet<String> imports) throws IOException {

        // Cleanup - Reinigung
        entidades.clear();
        relationsPower.clear();
        relations.clear();

        filePowerDesigner = "src/resources/models/"+modelo+"/"+artifactId+"/"+artifactId+".oom";

        PowerDesigner powerDesigner = new PowerDesigner(filePowerDesigner);
        entidades = powerDesigner.getEntidades();
        relations = powerDesigner.getRelations();
        relationsPower = powerDesigner.getRelationsPower();

        for(Entidad entidad : entidades) {

            BeanH2 beanH2 = new BeanH2(artifactId,groupId+".models."+modelo+"."+artifactId,entidad,imports);
            Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".crud.src.main.java."+groupId+".models."+modelo+"."+artifactId+".bean.h2",entidad.getName()+"Bean.java", beanH2);
        }
        BeanUtils beanUtils = new BeanUtils(artifactId,groupId+".models."+modelo+"."+artifactId,imports);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".crud.src.main.java."+groupId+".models."+modelo+"."+artifactId+".bean","ViewUtils.java", beanUtils);

        for(Entidad entidad : entidades) {

            CreateH2 createH2 = new CreateH2(entidad);
            Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".crud.src.main.java."+groupId+".models."+modelo+"."+artifactId+".xhtml."+entidad.getName()+".h2","create.xhtml", createH2);

            SearchH2 searchH2 = new SearchH2(entidad);
            Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".crud.src.main.java."+groupId+".models."+modelo+"."+artifactId+".xhtml."+entidad.getName()+".h2","search.xhtml", searchH2);

            ViewH2 viewH2 = new ViewH2(entidad);
            Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".crud.src.main.java."+groupId+".models."+modelo+"."+artifactId+".xhtml."+entidad.getName()+".h2","view.xhtml", viewH2);
        }

        TemplateCrud templateCrud = new TemplateCrud(artifactId,groupId+".models."+modelo+"."+artifactId,imports);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".crud.src.main.java."+groupId+".models."+modelo+"."+artifactId+".xhtml","pageTemplate.xhtml", templateCrud);

        Paginator paginator = new Paginator();
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".crud.src.main.java."+groupId+".models."+modelo+"."+artifactId+".xhtml","paginator.xhtml", paginator);

    } // crud

    public static void warH2(String modelo,String groupId,String artifactId,LinkedHashSet<String> imports) throws IOException {

        // Cleanup - Reinigung
        entidades.clear();
        relationsPower.clear();
        relations.clear();

        filePowerDesigner = "src/resources/models/"+modelo+"/"+artifactId+"/"+artifactId+".oom";

        PowerDesigner powerDesigner = new PowerDesigner(filePowerDesigner);
        entidades = powerDesigner.getEntidades();
        relations = powerDesigner.getRelations();
        relationsPower = powerDesigner.getRelationsPower();

        H2Pom filePom = new H2Pom(artifactId,groupId);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".war.h2", "pom.xml", filePom);

        Build build = new Build(artifactId,groupId);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".war.h2", "build.xml", build);

        GuiFsh guiFsh = new GuiFsh(artifactId,groupId+".models."+modelo,imports);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".war.h2", "gui.fsh", guiFsh);

        for(Entidad entidad : entidades) {
            EntityH2 entityH2 = new EntityH2(artifactId,groupId,entidad,imports);
            Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".war.h2.src.main.java."+groupId,entidad.getName()+".java", entityH2);
        }

/*

        for(Entidad entidad : entidades) {
            BeanH2 beanH2 = new BeanH2(artifactId,groupId+".models."+modelo+"."+artifactId,entidad,imports);
            Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".war.h2.src.main.java."+groupId+".view",entidad.getName()+"Bean.java", beanH2);
        }
        BeanUtils beanUtils = new BeanUtils(artifactId,groupId+".models."+modelo+"."+artifactId,imports);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".war.h2.src.main.java."+groupId+".view","ViewUtils.java", beanUtils);

        for(Entidad entidad : entidades) {

            CreateH2 createH2 = new CreateH2(entidad);
            Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".war.h2.src.main.webapp.admin."+Utils._1raMin(entidad.getName()),"create.xhtml", createH2);

            SearchH2 searchH2 = new SearchH2(entidad);
            Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".war.h2.src.main.webapp.admin."+Utils._1raMin(entidad.getName()),"search.xhtml", searchH2);

            ViewH2 viewH2 = new ViewH2(entidad);
            Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".war.h2.src.main.webapp.admin."+Utils._1raMin(entidad.getName()),"view.xhtml", viewH2);
        }
*/

        Persistence persistence = new Persistence(artifactId,groupId,entidades);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".war.h2.src.main.resources.META-INF", "persistence.xml", persistence);


/*
        H2Persistence h2Persistence = new H2Persistence(artifactId,packages);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".war.h2.src.main.resources.META-INF", "persistence.xml", h2Persistence);
*/

        H2Datasource h2datasource = new H2Datasource(artifactId);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".war.h2.src.main.webapp.WEB-INF",artifactId+"-ds.xml", h2datasource);

        H2Beans h2Beans = new H2Beans(artifactId);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".war.h2.src.main.webapp.WEB-INF","beans.xml", h2Beans);

        H2FacesConfig h2FacesConfig = new H2FacesConfig(artifactId);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".war.h2.src.main.webapp.WEB-INF","faces-config.xml", h2FacesConfig);

        H2Web h2Web = new H2Web(artifactId);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".war.h2.src.main.webapp.WEB-INF","web.xml", h2Web);

        H2PageTemplate h2PageTemplate = new H2PageTemplate(artifactId,entidades);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".war.h2.src.main.webapp.resources.scaffold","pageTemplate.xhtml",h2PageTemplate);

        Paginator paginator = new Paginator();
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".war.h2.src.main.webapp.resources.scaffold","paginator.xhtml", paginator);


/*
        Utils.fileJar("webH2/webapp/admin","index.html",pathDocs+"\\"+modelo+"\\"+artifactId+"\\war\\h2\\src\\main\\webapp\\admin\\",fileJar);
        Utils.fileJar("webH2/webapp/admin","index.xhtml",pathDocs+"\\"+modelo+"\\"+artifactId+"\\war\\h2\\src\\main\\webapp\\admin\\",fileJar);
*/

        Utils.fileJar("webH2/webapp/resources","add.png",pathDocs+"\\"+modelo+"\\"+artifactId+"\\war\\h2\\src\\main\\webapp\\resources\\",fileJar);
        Utils.fileJar("webH2/webapp/resources","bootstrap.css",pathDocs+"\\"+modelo+"\\"+artifactId+"\\war\\h2\\src\\main\\webapp\\resources\\",fileJar);
        Utils.fileJar("webH2/webapp/resources","false.png",pathDocs+"\\"+modelo+"\\"+artifactId+"\\war\\h2\\src\\main\\webapp\\resources\\",fileJar);
        Utils.fileJar("webH2/webapp/resources","favicon.ico",pathDocs+"\\"+modelo+"\\"+artifactId+"\\war\\h2\\src\\main\\webapp\\resources\\",fileJar);
        Utils.fileJar("webH2/webapp/resources","forge-logo.png",pathDocs+"\\"+modelo+"\\"+artifactId+"\\war\\h2\\src\\main\\webapp\\resources\\",fileJar);
        Utils.fileJar("webH2/webapp/resources","forge-style.css",pathDocs+"\\"+modelo+"\\"+artifactId+"\\war\\h2\\src\\main\\webapp\\resources\\",fileJar);
        Utils.fileJar("webH2/webapp/resources","jboss-community.png",pathDocs+"\\"+modelo+"\\"+artifactId+"\\war\\h2\\src\\main\\webapp\\resources\\",fileJar);
        Utils.fileJar("webH2/webapp/resources","remove.png",pathDocs+"\\"+modelo+"\\"+artifactId+"\\war\\h2\\src\\main\\webapp\\resources\\",fileJar);
        Utils.fileJar("webH2/webapp/resources","search.png",pathDocs+"\\"+modelo+"\\"+artifactId+"\\war\\h2\\src\\main\\webapp\\resources\\",fileJar);
        Utils.fileJar("webH2/webapp/resources","true.png",pathDocs+"\\"+modelo+"\\"+artifactId+"\\war\\h2\\src\\main\\webapp\\resources\\",fileJar);

        Utils.fileJar("webH2/webapp/resources/css","screen.css",pathDocs+"\\"+modelo+"\\"+artifactId+"\\war\\h2\\src\\main\\webapp\\resources\\css\\",fileJar);
        Utils.fileJar("webH2/webapp/resources/img","logo.jpg",pathDocs+"\\"+modelo+"\\"+artifactId+"\\war\\h2\\src\\main\\webapp\\resources\\img\\",fileJar);
        Utils.fileJar("webH2/webapp/resources/templates","default.xhtml",pathDocs+"\\"+modelo+"\\"+artifactId+"\\war\\h2\\src\\main\\webapp\\resources\\templates\\",fileJar);

        Utils.fileJar("webH2/webapp","home.xhtml",pathDocs+"\\"+modelo+"\\"+artifactId+"\\war\\h2\\src\\main\\webapp\\",fileJar);
        Utils.fileJar("webH2/webapp","index.html",pathDocs+"\\"+modelo+"\\"+artifactId+"\\war\\h2\\src\\main\\webapp\\",fileJar);
        Utils.fileJar("webH2/webapp","error.xhtml",pathDocs+"\\"+modelo+"\\"+artifactId+"\\war\\h2\\src\\main\\webapp\\",fileJar);

    } // war

    public static void warPH2(String modelo,String groupId,String artifactId,LinkedHashSet<String> imports) throws IOException {

        // Cleanup - Reinigung
        entidades.clear();
        relationsPower.clear();
        relations.clear();

        filePowerDesigner = "src/resources/models/"+modelo+"/"+artifactId+"/"+artifactId+".oom";

        PowerDesigner powerDesigner = new PowerDesigner(filePowerDesigner);
        entidades = powerDesigner.getEntidades();
        relations = powerDesigner.getRelations();
        relationsPower = powerDesigner.getRelationsPower();

        H2Pom filePom = new H2Pom(artifactId,groupId);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".war.ph2", "pom.xml", filePom);

        Build build = new Build(artifactId,groupId);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".war.ph2", "build.xml", build);

        GuiFsh guiFsh = new GuiFsh(artifactId,groupId+".models."+modelo,imports);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".war.ph2", "gui.fsh", guiFsh);

        for(Entidad entidad : entidades) {
            EntityPrueba entityPrueba = new EntityPrueba(artifactId,groupId,entidad,imports);
            Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".war.ph2.src.main.java."+groupId,entidad.getName()+".java", entityPrueba);
        }


        Persistence persistence = new Persistence(artifactId,groupId,entidades);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".war.ph2.src.main.resources.META-INF", "persistence.xml", persistence);

        H2Datasource h2datasource = new H2Datasource(artifactId);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".war.ph2.src.main.webapp.WEB-INF",artifactId+"-ds.xml", h2datasource);

        H2Beans h2Beans = new H2Beans(artifactId);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".war.ph2.src.main.webapp.WEB-INF","beans.xml", h2Beans);

        H2FacesConfig h2FacesConfig = new H2FacesConfig(artifactId);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".war.ph2.src.main.webapp.WEB-INF","faces-config.xml", h2FacesConfig);

        H2Web h2Web = new H2Web(artifactId);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".war.ph2.src.main.webapp.WEB-INF","web.xml", h2Web);

        H2PageTemplate h2PageTemplate = new H2PageTemplate(artifactId,entidades);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".war.ph2.src.main.webapp.resources.scaffold","pageTemplate.xhtml",h2PageTemplate);

        Paginator paginator = new Paginator();
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".war.ph2.src.main.webapp.resources.scaffold","paginator.xhtml", paginator);

        Utils.fileJar("webH2/webapp/resources","add.png",pathDocs+"\\"+modelo+"\\"+artifactId+"\\war\\ph2\\src\\main\\webapp\\resources\\",fileJar);
        Utils.fileJar("webH2/webapp/resources","bootstrap.css",pathDocs+"\\"+modelo+"\\"+artifactId+"\\war\\ph2\\src\\main\\webapp\\resources\\",fileJar);
        Utils.fileJar("webH2/webapp/resources","false.png",pathDocs+"\\"+modelo+"\\"+artifactId+"\\war\\ph2\\src\\main\\webapp\\resources\\",fileJar);
        Utils.fileJar("webH2/webapp/resources","favicon.ico",pathDocs+"\\"+modelo+"\\"+artifactId+"\\war\\ph2\\src\\main\\webapp\\resources\\",fileJar);
        Utils.fileJar("webH2/webapp/resources","forge-logo.png",pathDocs+"\\"+modelo+"\\"+artifactId+"\\war\\ph2\\src\\main\\webapp\\resources\\",fileJar);
        Utils.fileJar("webH2/webapp/resources","forge-style.css",pathDocs+"\\"+modelo+"\\"+artifactId+"\\war\\ph2\\src\\main\\webapp\\resources\\",fileJar);
        Utils.fileJar("webH2/webapp/resources","jboss-community.png",pathDocs+"\\"+modelo+"\\"+artifactId+"\\war\\ph2\\src\\main\\webapp\\resources\\",fileJar);
        Utils.fileJar("webH2/webapp/resources","remove.png",pathDocs+"\\"+modelo+"\\"+artifactId+"\\war\\ph2\\src\\main\\webapp\\resources\\",fileJar);
        Utils.fileJar("webH2/webapp/resources","search.png",pathDocs+"\\"+modelo+"\\"+artifactId+"\\war\\ph2\\src\\main\\webapp\\resources\\",fileJar);
        Utils.fileJar("webH2/webapp/resources","true.png",pathDocs+"\\"+modelo+"\\"+artifactId+"\\war\\ph2\\src\\main\\webapp\\resources\\",fileJar);

        Utils.fileJar("webH2/webapp/resources/css","screen.css",pathDocs+"\\"+modelo+"\\"+artifactId+"\\war\\ph2\\src\\main\\webapp\\resources\\css\\",fileJar);
        Utils.fileJar("webH2/webapp/resources/img","logo.jpg",pathDocs+"\\"+modelo+"\\"+artifactId+"\\war\\ph2\\src\\main\\webapp\\resources\\img\\",fileJar);
        Utils.fileJar("webH2/webapp/resources/templates","default.xhtml",pathDocs+"\\"+modelo+"\\"+artifactId+"\\war\\ph2\\src\\main\\webapp\\resources\\templates\\",fileJar);

        Utils.fileJar("webH2/webapp","home.xhtml",pathDocs+"\\"+modelo+"\\"+artifactId+"\\war\\ph2\\src\\main\\webapp\\",fileJar);
        Utils.fileJar("webH2/webapp","index.html",pathDocs+"\\"+modelo+"\\"+artifactId+"\\war\\ph2\\src\\main\\webapp\\",fileJar);
        Utils.fileJar("webH2/webapp","error.xhtml",pathDocs+"\\"+modelo+"\\"+artifactId+"\\war\\ph2\\src\\main\\webapp\\",fileJar);

    } // war


    public static void sql(String modelo,String groupId,String artifactId,LinkedHashSet<String> imports) throws IOException {

        // Cleanup - Reinigung
        entidades.clear();
        relationsPower.clear();
        relations.clear();

        filePowerDesigner = "src/resources/models/"+modelo+"/"+artifactId+"/"+artifactId+".oom";

        PowerDesigner powerDesigner = new PowerDesigner(filePowerDesigner);
        entidades = powerDesigner.getEntidades();
        relations = powerDesigner.getRelations();
        relationsPower = powerDesigner.getRelationsPower();

        SqlH2 sqlH2  = new SqlH2(artifactId,groupId+".models."+modelo+"."+artifactId,entidades,imports);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".sql.h2",artifactId+"Setup.java", sqlH2);


    } // sqlH2

    public static void sqlAll(String name,String groupId,String artifactId,ArrayList<Modelos> modelos,LinkedHashSet<String> imports) throws IOException {

        ArrayList<Relation> relationships = new ArrayList<Relation>();

        groupIds.clear();
        for (Modelos modelo : modelos) {

            ArrayList<Entidad> entities = new ArrayList<Entidad>();

            // Cleanup - Reinigung
            entidades.clear();

            filePowerDesigner = "src/resources/models/"+modelo.getModelo()+"/"+modelo.getArtifactId()+"/"+modelo.getArtifactId()+".oom";
            PowerDesigner powerDesigner = new PowerDesigner(filePowerDesigner);
            entidades = powerDesigner.getEntidades();

            Packages packages = new Packages(modelo.getGroupId(),modelo.getGroupId());
            for (Entidad entidad : entidades) {

                if (entidad.isEntity()) {

                   entities.add(entidad);

                   for (Relation relation : entidad.getRelations()) {
                       if (relation.getCardinality().equals("1..*")) {

                          if (!relation.getTo().equals("")){
                             relationships.add(relation);
                          }

                       }
                   } // entidad.getRelations()

                } // entidad.isEntity()

            } // for entidades

            packages.setEntities(entities);
            groupIds.add(packages);

        } // modelos

        SqlAllH2 sqlAllH2 = new SqlAllH2(artifactId,groupIds,relationships,imports);
        Utils.fileMake(pathDocs+"."+name,artifactId+"AllSetup.java", sqlAllH2);


    } // sqlAll

    public static void warModels(String name,String groupId,String artifactId,LinkedHashSet<String> imports) throws IOException {

        // Cleanup - Reinigung
        entidades.clear();
        relationsPower.clear();
        relations.clear();

        filePowerDesigner = "src/resources/models/"+name+"/"+artifactId+"/"+artifactId+".oom";

        PowerDesigner powerDesigner = new PowerDesigner(filePowerDesigner);
        entidades = powerDesigner.getEntidades();
        relations = powerDesigner.getRelations();
        relationsPower = powerDesigner.getRelationsPower();

        Models models = new Models(groupId,artifactId);
        models.setImports(imports);
        models.setEntities(entidades);
        models.WarH2();

    } // sqlH2

    public static void generar(String name,String groupId,String artifactId,ArrayList<Modelos> modelos) throws IOException {

        LinkedHashSet<String> imports = new LinkedHashSet<String>();
        for (Modelos modelo : modelos) {
            imports.add(modelo.getGroupId());
        }

        sqlAll(name,groupId,artifactId,modelos,imports);

        for (Modelos modelo : modelos) {
            jdocbook(modelo.getModelo(),modelo.getGroupId(),modelo.getArtifactId(),imports);
            jpa(modelo.getModelo(),modelo.getGroupId(),modelo.getArtifactId(),imports);
            sql(modelo.getModelo(),modelo.getGroupId(),modelo.getArtifactId(),imports);
            crud(modelo.getModelo(),modelo.getGroupId(),modelo.getArtifactId(),imports);
            warH2(modelo.getModelo(),modelo.getGroupId(),modelo.getArtifactId(),imports);
            warPH2(modelo.getModelo(),modelo.getGroupId(),modelo.getArtifactId(),imports);
        }

    }

    public static void Models(ArrayList<Modelos> modelos) throws IOException {

        LinkedHashSet<String> imports = new LinkedHashSet<String>();
        for (Modelos modelo : modelos) {
            imports.add(modelo.getGroupId()+"."+modelo.getModelo()+".models."+modelo.getArtifactId());
        }

        for (Modelos modelo : modelos) {
            jdocbook(modelo.getModelo(),modelo.getGroupId(),modelo.getArtifactId(),imports);
            jpa(modelo.getModelo(),modelo.getGroupId(),modelo.getArtifactId(),imports);
            sql(modelo.getModelo(),modelo.getGroupId(),modelo.getArtifactId(),imports);
            crud(modelo.getModelo(),modelo.getGroupId(),modelo.getArtifactId(),imports);
            warH2(modelo.getModelo(),modelo.getGroupId(),modelo.getArtifactId(),imports);
            warModels(modelo.getModelo(),modelo.getGroupId(),modelo.getArtifactId(),imports);
        }

    }

    public static void main( String[] args ) throws IOException {

/*
        modelos.clear();
        modelos.add(new Modelos("contable","co.simasoft.models.naif.contabilidad","contabilidad"));
        generar("contable","co.simasoft","contabilidad",modelos);

        modelos.clear();
        modelos.add(new Modelos("iso","co.simasoft.models.naif.iso.procesos","procesos"));
        modelos.add(new Modelos("iso","co.simasoft.models.naif.iso.lmd","lmd"));
        modelos.add(new Modelos("iso","co.simasoft.models.naif.iso.lmr","lmr"));
        modelos.add(new Modelos("iso","co.simasoft.models.naif.iso.archivoInactivo","archivoinactivo"));
        generar("iso","co.simasoft","iso",modelos);

        modelos.clear();
        modelos.add(new Modelos("base","co.simasoft.models.naif.base.direcciones","direcciones"));
        modelos.add(new Modelos("base","co.simasoft.models.naif.base.paises","paises"));
        modelos.add(new Modelos("base","co.simasoft.models.naif.base.empresas","empresas"));
        modelos.add(new Modelos("base","co.simasoft.models.naif.base.mails","mails"));
        modelos.add(new Modelos("base","co.simasoft.models.naif.base.nits","nits"));
        modelos.add(new Modelos("base","co.simasoft.models.naif.base.permisos","permisos"));
        modelos.add(new Modelos("base","co.simasoft.models.naif.base.personas","personas"));
        modelos.add(new Modelos("base","co.simasoft.models.naif.base.sistemas","sistemas"));
        modelos.add(new Modelos("base","co.simasoft.models.naif.base.telefonos","telefonos"));
        modelos.add(new Modelos("base","co.simasoft.models.naif.base.usuarios","usuarios"));
        generar("base","co.simasoft","base",modelos);

        modelos.clear();
        modelos.add(new Modelos("pruebas","co.simasoft.models.naif.pruebas","prueba"));
        generar("pruebas","co.simasoft","prueba",modelos);
*/

        modelos.clear();
        modelos.add(new Modelos("pruebas","co.simasoft.models.naif.prueba1","prueba1"));
        generar("pruebas","co.simasoft","prueba1",modelos);

        modelos.clear();
        modelos.add(new Modelos("pruebas","co.simasoft.models.naif.prueba2","prueba2"));
        generar("pruebas","co.simasoft","prueba2",modelos);


        modelos.clear();
        modelos.add(new Modelos("pruebas","co.simasoft.models.naif.prueba3","prueba3"));
        generar("pruebas","co.simasoft","prueba3",modelos);

        modelos.clear();
        modelos.add(new Modelos("naif","co.simasoft.models.naif.domainmodels","DomainModels"));
        generar("naif","co.simasoft","DomainModels",modelos);

/*
        modelos.clear();
        modelos.add(new Modelos("naif","co.simasoft.models.naif.relacionesejb","RelacionesEjb"));
        generar("naif","co.simasoft","RelacionesEjb",modelos);

        modelos.clear();
        modelos.add(new Modelos("naif","co.simasoft","DomainModels"));
        War war = new War(modelos);

        modelos.clear();
        modelos.add(new Modelos("naif","co.simasoft","DomainModels"));
        Models(modelos);
*/


    } // main

} // App
