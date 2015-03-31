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

    private static ArrayList<Entidad> entidades       = new ArrayList<Entidad>();
    private static ArrayList<Relation> relationsPower = new ArrayList<Relation>();
    private static Set<Relation> relations            = new HashSet<Relation>(0);
    private static ArrayList<Modelos> modelos         = new ArrayList<Modelos>();

    private static String fileJar = "../g.jar";
    private static String filePowerDesigner = "";
    private static String pathDocs = "\\docs";
    private static String artifactId = "";
    private static String asciidocImages = "src.main.asciidoc.en-US.images";
    private static String asciidocModules = "src.main.asciidoc.en-US.modules";

    public static void jdocbook(String modelo,String groupId,String artifactId,ArrayList<String> imports) throws IOException {

        // Cleanup - Reinigung
        entidades.clear();
        relationsPower.clear();
        relations.clear();

        filePowerDesigner = "src/resources/models/"+modelo+"/"+artifactId+"/"+artifactId+".oob";

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

    public static void jpa(String modelo,String groupId,String artifactId,ArrayList<String> imports) throws IOException {

        // Cleanup - Reinigung
        entidades.clear();
        relationsPower.clear();
        relations.clear();

        filePowerDesigner = "src/resources/models/"+modelo+"/"+artifactId+"/"+artifactId+".oob";

        PowerDesigner powerDesigner = new PowerDesigner(filePowerDesigner);
        entidades = powerDesigner.getEntidades();
        relations = powerDesigner.getRelations();
        relationsPower = powerDesigner.getRelationsPower();

        for(Entidad entidad : entidades) {

            Entity0 entity0 = new Entity0(artifactId,groupId+".models."+modelo+"."+artifactId,entidad,imports);
            Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".jpa.src.main.java."+groupId+".models."+modelo+"."+artifactId+".jpa.0",entidad.getName()+".java", entity0);

            EntityMongo entityMongo = new EntityMongo(artifactId,groupId+".models."+modelo+"."+artifactId,entidad,imports);
            Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".jpa.src.main.java."+groupId+".models."+modelo+"."+artifactId+".jpa.mongo",entidad.getName()+".java", entityMongo);

            EntityH2 entityH2 = new EntityH2(artifactId,groupId+".models."+modelo+"."+artifactId,entidad,imports);
            Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".jpa.src.main.java."+groupId+".models."+modelo+"."+artifactId+".jpa.h2",entidad.getName()+".java", entityH2);

            EntityPruebaMongo entityPruebaMongo = new EntityPruebaMongo(artifactId,groupId+".models."+modelo+"."+artifactId,entidad,imports);
            Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".jpa.src.main.java."+groupId+".models."+modelo+"."+artifactId+".jpa.pmongo",entidad.getName()+".java", entityPruebaMongo);

            EntityPruebaH2 entityPruebaH2 = new EntityPruebaH2(artifactId,groupId+".models."+modelo+"."+artifactId,entidad,imports);
            Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".jpa.src.main.java."+groupId+".models."+modelo+"."+artifactId+".jpa.ph2",entidad.getName()+".java", entityPruebaH2);
        }

        Persistence persistence = new Persistence(artifactId,groupId+".models."+modelo,entidades);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".jpa.src.main.java."+groupId+".models."+modelo+"."+artifactId, "persistence.xml", persistence);

        Datasource datasource = new Datasource(artifactId,groupId,entidades);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".jpa.src.main.java."+groupId+".models."+modelo+"."+artifactId,artifactId+"-ds.xml", datasource);

        GuiFsh guiFsh = new GuiFsh(artifactId,groupId+".models."+modelo,imports);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".jpa.src.main.java."+groupId+".models."+modelo+"."+artifactId, "gui.fsh", guiFsh);

    } // jpa

    public static void crud(String modelo,String groupId,String artifactId,ArrayList<String> imports) throws IOException {

        // Cleanup - Reinigung
        entidades.clear();
        relationsPower.clear();
        relations.clear();

        filePowerDesigner = "src/resources/models/"+modelo+"/"+artifactId+"/"+artifactId+".oob";

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

            CreateH2 createH2 = new CreateH2(artifactId,groupId+".models."+modelo+"."+artifactId,entidad,imports);
            Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".crud.src.main.java."+groupId+".models."+modelo+"."+artifactId+".xhtml."+entidad.getName()+".h2","create.xhtml", createH2);

            SearchH2 searchH2 = new SearchH2(artifactId,groupId+".models."+modelo+"."+artifactId,entidad,imports);
            Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".crud.src.main.java."+groupId+".models."+modelo+"."+artifactId+".xhtml."+entidad.getName()+".h2","search.xhtml", searchH2);

            ViewH2 viewH2 = new ViewH2(artifactId,groupId+".models."+modelo+"."+artifactId,entidad,imports);
            Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".crud.src.main.java."+groupId+".models."+modelo+"."+artifactId+".xhtml."+entidad.getName()+".h2","view.xhtml", viewH2);
        }

        TemplateCrud templateCrud = new TemplateCrud(artifactId,groupId+".models."+modelo+"."+artifactId,imports);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".crud.src.main.java."+groupId+".models."+modelo+"."+artifactId+".xhtml","pageTemplate.xhtml", templateCrud);

        Paginator paginator = new Paginator(artifactId,groupId+".models."+modelo+"."+artifactId,imports);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".crud.src.main.java."+groupId+".models."+modelo+"."+artifactId+".xhtml","paginator.xhtml", paginator);

    } // crud

    public static void warH2(String modelo,String groupId,String artifactId,ArrayList<String> imports) throws IOException {

        // Cleanup - Reinigung
        entidades.clear();
        relationsPower.clear();
        relations.clear();

        filePowerDesigner = "src/resources/models/"+modelo+"/"+artifactId+"/"+artifactId+".oob";

        PowerDesigner powerDesigner = new PowerDesigner(filePowerDesigner);
        entidades = powerDesigner.getEntidades();
        relations = powerDesigner.getRelations();
        relationsPower = powerDesigner.getRelationsPower();

        H2Pom filePom = new H2Pom(artifactId,groupId);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".war.h2", "pom.xml", filePom);

        Build build = new Build(artifactId,groupId);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".war.h2", "build.xml", build);

        for(Entidad entidad : entidades) {
            EntityH2 entityH2 = new EntityH2(artifactId,groupId+".models."+modelo+"."+artifactId,entidad,imports);
            Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".war.h2.src.main.java."+groupId+".models."+modelo+"."+artifactId,entidad.getName()+".java", entityH2);
        }

        for(Entidad entidad : entidades) {
            BeanH2 beanH2 = new BeanH2(artifactId,groupId+".models."+modelo+"."+artifactId,entidad,imports);
            Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".war.h2.src.main.java."+groupId+".view",entidad.getName()+"Bean.java", beanH2);
        }
        BeanUtils beanUtils = new BeanUtils(artifactId,groupId+".models."+modelo+"."+artifactId,imports);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".war.h2.src.main.java."+groupId+".view","ViewUtils.java", beanUtils);

        for(Entidad entidad : entidades) {

            CreateH2 createH2 = new CreateH2(artifactId,groupId+".models."+modelo+"."+artifactId,entidad,imports);
            Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".war.h2.src.main.webapp.admin."+Utils._1raMin(entidad.getName()),"create.xhtml", createH2);

            SearchH2 searchH2 = new SearchH2(artifactId,groupId+".models."+modelo+"."+artifactId,entidad,imports);
            Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".war.h2.src.main.webapp.admin."+Utils._1raMin(entidad.getName()),"search.xhtml", searchH2);

            ViewH2 viewH2 = new ViewH2(artifactId,groupId+".models."+modelo+"."+artifactId,entidad,imports);
            Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".war.h2.src.main.webapp.admin."+Utils._1raMin(entidad.getName()),"view.xhtml", viewH2);
        }


        H2Persistence h2Persistence = new H2Persistence(artifactId,groupId+".models."+modelo,entidades);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".war.h2.src.main.resources.META-INF", "persistence.xml", h2Persistence);

        H2Datasource h2datasource = new H2Datasource(artifactId,groupId,entidades);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".war.h2.src.main.webapp.WEB-INF",artifactId+"-ds.xml", h2datasource);

        H2Beans h2Beans = new H2Beans(artifactId,groupId);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".war.h2.src.main.webapp.WEB-INF","beans.xml", h2Beans);

        H2FacesConfig h2FacesConfig = new H2FacesConfig(artifactId,groupId);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".war.h2.src.main.webapp.WEB-INF","faces-config.xml", h2FacesConfig);

        H2Web h2Web = new H2Web(artifactId,groupId);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".war.h2.src.main.webapp.WEB-INF","web.xml", h2Web);

        H2PageTemplate h2PageTemplate = new H2PageTemplate(artifactId,groupId+".models."+modelo,entidades);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".war.h2.src.main.webapp.resources.scaffold","pageTemplate.xhtml",h2PageTemplate);

        Paginator paginator = new Paginator(artifactId,groupId+".models."+modelo+"."+artifactId,imports);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".war.h2.src.main.webapp.resources.scaffold","paginator.xhtml", paginator);

        Utils.fileJar("webH2/webapp/admin","index.html",pathDocs+"\\"+modelo+"\\"+artifactId+"\\war\\h2\\src\\main\\webapp\\admin\\",fileJar);
        Utils.fileJar("webH2/webapp/admin","index.xhtml",pathDocs+"\\"+modelo+"\\"+artifactId+"\\war\\h2\\src\\main\\webapp\\admin\\",fileJar);

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


    public static void sql(String modelo,String groupId,String artifactId,ArrayList<String> imports) throws IOException {

        // Cleanup - Reinigung
        entidades.clear();
        relationsPower.clear();
        relations.clear();

        filePowerDesigner = "src/resources/models/"+modelo+"/"+artifactId+"/"+artifactId+".oob";

        PowerDesigner powerDesigner = new PowerDesigner(filePowerDesigner);
        entidades = powerDesigner.getEntidades();
        relations = powerDesigner.getRelations();
        relationsPower = powerDesigner.getRelationsPower();

        SqlH2 sqlH2  = new SqlH2(artifactId,groupId+".models."+modelo+"."+artifactId,entidades,imports);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".sql.h2",artifactId+"Setup.java", sqlH2);


    } // sqlH2

    public static void warModels(String name,String groupId,String artifactId,ArrayList<String> imports) throws IOException {

        // Cleanup - Reinigung
        entidades.clear();
        relationsPower.clear();
        relations.clear();

        filePowerDesigner = "src/resources/models/"+name+"/"+artifactId+"/"+artifactId+".oob";

        PowerDesigner powerDesigner = new PowerDesigner(filePowerDesigner);
        entidades = powerDesigner.getEntidades();
        relations = powerDesigner.getRelations();
        relationsPower = powerDesigner.getRelationsPower();

        Models models = new Models(name,groupId,artifactId);
        models.setImports(imports);
        models.setEntities(entidades);
        models.WarH2();

    } // sqlH2




    public static void generar(ArrayList<Modelos> modelos) throws IOException {

        ArrayList<String> imports = new ArrayList<String>();
        for (Modelos modelo : modelos) {
            imports.add(modelo.getGroupId()+".models."+modelo.getModelo()+"."+modelo.getArtifactId());
        }

        for (Modelos modelo : modelos) {
            jdocbook(modelo.getModelo(),modelo.getGroupId(),modelo.getArtifactId(),imports);
            jpa(modelo.getModelo(),modelo.getGroupId(),modelo.getArtifactId(),imports);
            sql(modelo.getModelo(),modelo.getGroupId(),modelo.getArtifactId(),imports);
            crud(modelo.getModelo(),modelo.getGroupId(),modelo.getArtifactId(),imports);
            warH2(modelo.getModelo(),modelo.getGroupId(),modelo.getArtifactId(),imports);
        }

    }

    public static void Models(ArrayList<Modelos> modelos) throws IOException {

        ArrayList<String> imports = new ArrayList<String>();
        for (Modelos modelo : modelos) {
            imports.add(modelo.getGroupId()+".models."+modelo.getModelo()+"."+modelo.getArtifactId());
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

        modelos.clear();
        modelos.add(new Modelos("contable","co.simasoft","contabilidad"));
        generar(modelos);

        modelos.clear();
        modelos.add(new Modelos("iso","co.simasoft","archivo-inactivo"));
        modelos.add(new Modelos("iso","co.simasoft","lmd"));
        modelos.add(new Modelos("iso","co.simasoft","lmr"));
        modelos.add(new Modelos("iso","co.simasoft","procesos"));
        generar(modelos);

        modelos.clear();
        modelos.add(new Modelos("base","co.simasoft","direcciones"));
        modelos.add(new Modelos("base","co.simasoft","paises"));
        modelos.add(new Modelos("base","co.simasoft","empresas"));
        modelos.add(new Modelos("base","co.simasoft","mails"));
        modelos.add(new Modelos("base","co.simasoft","nits"));
        modelos.add(new Modelos("base","co.simasoft","permisos"));
        modelos.add(new Modelos("base","co.simasoft","personas"));
        modelos.add(new Modelos("base","co.simasoft","sistemas"));
        modelos.add(new Modelos("base","co.simasoft","telefonos"));
        modelos.add(new Modelos("base","co.simasoft","usuarios"));
        generar(modelos);

        modelos.clear();
        modelos.add(new Modelos("pruebas","co.simasoft","prueba"));
        generar(modelos);

        modelos.clear();
        modelos.add(new Modelos("pruebas","co.simasoft","prueba1"));
        generar(modelos);

        modelos.clear();
        modelos.add(new Modelos("pruebas","co.simasoft","prueba2"));
        generar(modelos);

        modelos.clear();
        modelos.add(new Modelos("naif","co.simasoft","DomainModels"));
        generar(modelos);

        modelos.clear();
        modelos.add(new Modelos("naif","co.simasoft","RelacionesEjb"));
        generar(modelos);

        modelos.clear();
        modelos.add(new Modelos("naif","co.simasoft","DomainModels"));
        War war = new War(modelos);

        modelos.clear();
        modelos.add(new Modelos("naif","co.simasoft","DomainModels"));
        Models(modelos);


    } // main

} // App
