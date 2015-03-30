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

public class War {

    private ArrayList<Entidad> entidades       = new ArrayList<Entidad>();
    private ArrayList<Relation> relationsPower = new ArrayList<Relation>();
    private Set<Relation> relations            = new HashSet<Relation>(0);
    private ArrayList<Modelos> modelos         = new ArrayList<Modelos>();

    private String fileJar = "../g.jar";
    private String filePowerDesigner = "";
    private String pathDocs = "docs";
    private String artifactId = "";
    private String asciidocImages = "src.main.asciidoc.en-US.images";
    private String asciidocModules = "src.main.asciidoc.en-US.modules";
    
    public War() {
    }

    public War(ArrayList<Modelos> modelos) throws IOException {

        ArrayList<String> imports = new ArrayList<String>();
        for (Modelos modelo : modelos) {
            imports.add(modelo.getGroupId()+".models."+modelo.getModelo()+"."+modelo.getArtifactId());
        }

        for (Modelos modelo : modelos) {
            H2(modelo.getModelo(),modelo.getGroupId(),modelo.getArtifactId(),imports);
        }

    }

    public void H2(String modelo,String groupId,String artifactId,ArrayList<String> imports) throws IOException {

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


} // War