package co.simasoft.generator.utils;

import co.simasoft.utils.*;
import co.simasoft.generator.jar.*;
import co.simasoft.generator.jar.hsqldb.*;
import co.simasoft.generator.war.*;

import java.io.*;
import java.util.*;

public class TypeApp{

    private static String fileJar = "g.jar";

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

    } // Jar Simple

    public static void JarHsqldb(String artifactId,String groupId) throws IOException {

        Utils.mkDirs(artifactId+".src.main.java."+groupId+".models");
        Utils.mkDirs(artifactId+".src.resources.META-INF");
        Utils.mkDirs(artifactId+".src.resources.sql");

        HsqldbPom hsqldbPom = new HsqldbPom(artifactId,groupId);
        Utils.fileMake(artifactId, "pom.xml", hsqldbPom);

        HsqldbBuild hsqldbBuild = new HsqldbBuild(artifactId,groupId);
        Utils.fileMake(artifactId, "build.xml", hsqldbBuild);

        HsqldbApp hsqldbApp = new HsqldbApp(artifactId,groupId);
        Utils.fileMake(artifactId+".src.main.java."+groupId, "App.java", hsqldbApp);

        HsqldbUser hsqldbUser = new HsqldbUser(artifactId,groupId);
        Utils.fileMake(artifactId+".src.main.java."+groupId+".models", "User.java", hsqldbUser);

        HsqldbPersistence hsqldbPersistence = new HsqldbPersistence(artifactId,groupId);
        Utils.fileMake(artifactId+".src.resources.META-INF", "persistence.xml", hsqldbPersistence);

        Utils.fileJar("log4j.properties",artifactId+"\\src\\resources\\",fileJar);
        Utils.fileJar("import.sql",artifactId+"\\src\\resources\\sql\\",fileJar);




    } // Jar Hsqldb

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

        Utils.fileJar("index.html",artifactId+"\\src\\main\\webapp\\",fileJar);
        Utils.fileJar("home.xhtml",artifactId+"\\src\\main\\webapp\\",fileJar);
        Utils.fileJar("default.xhtml",artifactId+"\\src\\main\\webapp\\resources\\templates\\",fileJar);
        Utils.fileJar("screen.css",artifactId+"\\src\\main\\webapp\\resources\\css\\",fileJar);
        Utils.fileJar("logo.jpg",artifactId+"\\src\\main\\webapp\\resources\\img\\",fileJar);

    } // War

} // TypeApp