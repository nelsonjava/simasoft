package co.simasoft.generator.utils;

import co.simasoft.utils.*;
import co.simasoft.generator.jar.*;
import co.simasoft.generator.war.*;
import co.simasoft.generator.asciidoc.*;

import java.io.*;
import java.util.*;

public class TypeApp{

    public static void Jar(String artifactId,String groupId){

        Utils.mkDirs(artifactId+".src.main.java."+groupId);
        Utils.mkDirs(artifactId+".src.resources");

        JarPom filePom = new JarPom(artifactId,groupId);
        Utils.fileMake(artifactId, "pom.xml", filePom);

        BuildJar fileBuildJar = new BuildJar(artifactId,groupId);
        Utils.fileMake(artifactId, "build.xml", fileBuildJar);

        App fileApp = new App();
        fileApp.Generar(groupId);
        Utils.fileMake(artifactId+".src.main.java."+groupId, "App.java", fileApp);

    } // Jar

    public static void War(String artifactId,String groupId) throws IOException {

        Utils.mkDirs(artifactId+".src.main.java."+groupId);
        Utils.mkDirs(artifactId+".src.main.resources");
        Utils.mkDirs(artifactId+".src.main.webapp.resources.css");
        Utils.mkDirs(artifactId+".src.main.webapp.resources.img");
        Utils.mkDirs(artifactId+".src.main.webapp.resources.templates");
        Utils.mkDirs(artifactId+".src.main.webapp.WEB-INF");

        Utils.mkDirs(artifactId+".src.test.java");
        Utils.mkDirs(artifactId+".src.test.resources");

        WarPom filePom = new WarPom(artifactId,groupId);
        Utils.fileMake(artifactId, "pom.xml", filePom);

        BuildWar fileBuildWar = new BuildWar(artifactId,groupId);
        Utils.fileMake(artifactId, "build.xml", fileBuildWar);

        Home fileHome = new Home(artifactId,groupId);
        Utils.fileMake(artifactId+".src.main.webapp", "home.xhtml", fileHome);

        Index fileIndex = new Index(artifactId,groupId);
        Utils.fileMake(artifactId+".src.main.webapp", "index.html", fileIndex);

        Beans fileBeans = new Beans(artifactId,groupId);
        Utils.fileMake(artifactId+".src.main.webapp.WEB-INF", "beans.xml", fileBeans);

        FacesConfig fileFacesConfig = new FacesConfig(artifactId,groupId);
        Utils.fileMake(artifactId+".src.main.webapp.WEB-INF", "faces-config.xml", fileFacesConfig);

        Utils.fileJar("index.html",artifactId+"\\src\\main\\webapp\\");
        Utils.fileJar("home.xhtml",artifactId+"\\src\\main\\webapp\\");
        Utils.fileJar("default.xhtml",artifactId+"\\src\\main\\webapp\\resources\\templates\\");
        Utils.fileJar("screen.css",artifactId+"\\src\\main\\webapp\\resources\\css\\");
        Utils.fileJar("logo.jpg",artifactId+"\\src\\main\\webapp\\resources\\img\\");



    } // War

    public static void ModeloAsciidoc(String artifactId,String groupId) throws IOException {

        Utils.mkDirs(artifactId+".src.main.asciidoc.en-US.images");
        Utils.mkDirs(artifactId+".src.main.asciidoc.en-US.modules");

        Utils.fileJar("pom.xml",artifactId+"\\");
        Utils.fileJar("master.asciidoc",artifactId+"\\src\\main\\asciidoc\\en-US\\");
        Utils.fileJar("master-docinfo.xml",artifactId+"\\src\\main\\asciidoc\\en-US\\");

        Asciidoc fileAsciidoc = new Asciidoc(artifactId,groupId);
        Utils.fileMake(artifactId+".src.main.asciidoc.en-US.modules", "modelo.asciidoc", fileAsciidoc);

        Test fileTest = new Test(artifactId,groupId);
        Utils.fileMake(artifactId+".src.main.asciidoc.en-US.modules", "test.asciidoc", fileTest);



/*
        ArrayList<Entidad> entidades = new ArrayList<Entidad>();
        ArrayList<Atributos> atributos = new ArrayList<Atributos>();

        PowerDesigner.Entidades("/dev/njava/modelos/uml/contab/contab.oob");

        for(int i=0;i<entidades.size();i++) {

          Entidad entidad = entidades.get(i);
          System.out.println(entidad.getName());

          atributos = entidad.getAtributos();
          for(int j=0;j<atributos.size();j++) {
              Atributos atributo = atributos.get(j);
              System.out.println("------");
              System.out.println("    campo:"+atributo.getField());
              System.out.println("    unico:"+atributo.getUnique());
              System.out.println("    tipo:"+atributo.getType());
              System.out.println("    nulo:"+atributo.getLength());
              System.out.println("    len:"+atributo.getNulo());

          } // for atributos


        } // for entidades

*/

    } // ModeloAsciidoc





} // TypeApp