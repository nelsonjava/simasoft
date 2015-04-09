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

public class Models{

    private String name;
    private String groupId;
    private String artifactId;
    private ArrayList<Entidad> entities = new ArrayList<Entidad>();
    private ArrayList<String> imports = new ArrayList<String>();

    private String fileJar = "../g.jar";
    private String pathDocs = "\\docs";

    public Models(String name,String groupId,String artifactId){
       this.name = name;
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

    public ArrayList<String> getImports(){
        return imports;
    }

    public void setImports(ArrayList<String> imports){
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

    public void WarH2() throws IOException {

        H2Pom filePom = new H2Pom(artifactId,groupId);
        Utils.fileMake(pathDocs+"."+name+"."+artifactId+".war.h2", "pom.xml", filePom);

        Build build = new Build(artifactId,groupId);
        Utils.fileMake(pathDocs+"."+name+"."+artifactId+".war.h2", "build.xml", build);

        for(Entidad entidad : entities) {
//            EntityH2 entityH2 = new EntityH2(artifactId,groupId+".models."+name+"."+artifactId,entidad,imports);
            EntityH2 entityH2 = new EntityH2(artifactId,groupId+".models."+name,entidad,imports);
//            Utils.fileMake(pathDocs+"."+name+"."+artifactId+".war.h2.src.main.java."+groupId+".models."+name+"."+artifactId,entidad.getName()+".java", entityH2);
            Utils.fileMake(pathDocs+"."+name+"."+artifactId+".war.h2.src.main.java."+groupId+".models."+name,entidad.getName()+".java", entityH2);
        }

        for(Entidad entidad : entities) {
//            BeanH2 beanH2 = new BeanH2(artifactId,groupId+".models."+name+"."+artifactId,entidad,imports);
            BeanH2 beanH2 = new BeanH2(artifactId,groupId+".models."+name,entidad,imports);
            Utils.fileMake(pathDocs+"."+name+"."+artifactId+".war.h2.src.main.java."+groupId+".view",entidad.getName()+"Bean.java", beanH2);
        }
        BeanUtils beanUtils = new BeanUtils(artifactId,groupId+".models."+name+"."+artifactId,imports);
        Utils.fileMake(pathDocs+"."+name+"."+artifactId+".war.h2.src.main.java."+groupId+".view","ViewUtils.java", beanUtils);

        for(Entidad entidad : entities) {

            CreateH2 createH2 = new CreateH2(artifactId,groupId+".models."+name+"."+artifactId,entidad,imports);
            Utils.fileMake(pathDocs+"."+name+"."+artifactId+".war.h2.src.main.webapp.admin."+Utils._1raMin(entidad.getName()),"create.xhtml", createH2);

            SearchH2 searchH2 = new SearchH2(artifactId,groupId+".models."+name+"."+artifactId,entidad,imports);
            Utils.fileMake(pathDocs+"."+name+"."+artifactId+".war.h2.src.main.webapp.admin."+Utils._1raMin(entidad.getName()),"search.xhtml", searchH2);

            ViewH2 viewH2 = new ViewH2(artifactId,groupId+".models."+name+"."+artifactId,entidad,imports);
            Utils.fileMake(pathDocs+"."+name+"."+artifactId+".war.h2.src.main.webapp.admin."+Utils._1raMin(entidad.getName()),"view.xhtml", viewH2);
        }

        H2Persistence h2Persistence = new H2Persistence(artifactId,groupId+".models."+name,entities);
        Utils.fileMake(pathDocs+"."+name+"."+artifactId+".war.h2.src.main.resources.META-INF", "persistence.xml", h2Persistence);

        H2Datasource h2datasource = new H2Datasource(artifactId,groupId,entities);
        Utils.fileMake(pathDocs+"."+name+"."+artifactId+".war.h2.src.main.webapp.WEB-INF",artifactId+"-ds.xml", h2datasource);

        H2Beans h2Beans = new H2Beans(artifactId,groupId);
        Utils.fileMake(pathDocs+"."+name+"."+artifactId+".war.h2.src.main.webapp.WEB-INF","beans.xml", h2Beans);

        H2FacesConfig h2FacesConfig = new H2FacesConfig(artifactId,groupId);
        Utils.fileMake(pathDocs+"."+name+"."+artifactId+".war.h2.src.main.webapp.WEB-INF","faces-config.xml", h2FacesConfig);

        H2Web h2Web = new H2Web(artifactId,groupId);
        Utils.fileMake(pathDocs+"."+name+"."+artifactId+".war.h2.src.main.webapp.WEB-INF","web.xml", h2Web);

        H2PageTemplate h2PageTemplate = new H2PageTemplate(artifactId,groupId+".models."+name,entities);
        Utils.fileMake(pathDocs+"."+name+"."+artifactId+".war.h2.src.main.webapp.resources.scaffold","pageTemplate.xhtml",h2PageTemplate);

        Paginator paginator = new Paginator(artifactId,groupId+".models."+name+"."+artifactId,imports);
        Utils.fileMake(pathDocs+"."+name+"."+artifactId+".war.h2.src.main.webapp.resources.scaffold","paginator.xhtml", paginator);

        Utils.fileJar("webH2/webapp/admin","index.html",pathDocs+"\\"+name+"\\"+artifactId+"\\war\\h2\\src\\main\\webapp\\admin\\",fileJar);
        Utils.fileJar("webH2/webapp/admin","index.xhtml",pathDocs+"\\"+name+"\\"+artifactId+"\\war\\h2\\src\\main\\webapp\\admin\\",fileJar);

        Utils.fileJar("webH2/webapp/resources","add.png",pathDocs+"\\"+name+"\\"+artifactId+"\\war\\h2\\src\\main\\webapp\\resources\\",fileJar);
        Utils.fileJar("webH2/webapp/resources","bootstrap.css",pathDocs+"\\"+name+"\\"+artifactId+"\\war\\h2\\src\\main\\webapp\\resources\\",fileJar);
        Utils.fileJar("webH2/webapp/resources","false.png",pathDocs+"\\"+name+"\\"+artifactId+"\\war\\h2\\src\\main\\webapp\\resources\\",fileJar);
        Utils.fileJar("webH2/webapp/resources","favicon.ico",pathDocs+"\\"+name+"\\"+artifactId+"\\war\\h2\\src\\main\\webapp\\resources\\",fileJar);
        Utils.fileJar("webH2/webapp/resources","forge-logo.png",pathDocs+"\\"+name+"\\"+artifactId+"\\war\\h2\\src\\main\\webapp\\resources\\",fileJar);
        Utils.fileJar("webH2/webapp/resources","forge-style.css",pathDocs+"\\"+name+"\\"+artifactId+"\\war\\h2\\src\\main\\webapp\\resources\\",fileJar);
        Utils.fileJar("webH2/webapp/resources","jboss-community.png",pathDocs+"\\"+name+"\\"+artifactId+"\\war\\h2\\src\\main\\webapp\\resources\\",fileJar);
        Utils.fileJar("webH2/webapp/resources","remove.png",pathDocs+"\\"+name+"\\"+artifactId+"\\war\\h2\\src\\main\\webapp\\resources\\",fileJar);
        Utils.fileJar("webH2/webapp/resources","search.png",pathDocs+"\\"+name+"\\"+artifactId+"\\war\\h2\\src\\main\\webapp\\resources\\",fileJar);
        Utils.fileJar("webH2/webapp/resources","true.png",pathDocs+"\\"+name+"\\"+artifactId+"\\war\\h2\\src\\main\\webapp\\resources\\",fileJar);

        Utils.fileJar("webH2/webapp/resources/css","screen.css",pathDocs+"\\"+name+"\\"+artifactId+"\\war\\h2\\src\\main\\webapp\\resources\\css\\",fileJar);
        Utils.fileJar("webH2/webapp/resources/img","logo.jpg",pathDocs+"\\"+name+"\\"+artifactId+"\\war\\h2\\src\\main\\webapp\\resources\\img\\",fileJar);
        Utils.fileJar("webH2/webapp/resources/templates","default.xhtml",pathDocs+"\\"+name+"\\"+artifactId+"\\war\\h2\\src\\main\\webapp\\resources\\templates\\",fileJar);

        Utils.fileJar("webH2/webapp","home.xhtml",pathDocs+"\\"+name+"\\"+artifactId+"\\war\\h2\\src\\main\\webapp\\",fileJar);
        Utils.fileJar("webH2/webapp","index.html",pathDocs+"\\"+name+"\\"+artifactId+"\\war\\h2\\src\\main\\webapp\\",fileJar);
        Utils.fileJar("webH2/webapp","error.xhtml",pathDocs+"\\"+name+"\\"+artifactId+"\\war\\h2\\src\\main\\webapp\\",fileJar);

    }


} // Models