package co.simasoft.generator.utils;

import co.simasoft.utils.*;
import co.simasoft.generator.jar.*;
import co.simasoft.generator.war.*;

import java.io.*;

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

    public static void War(String artifactId,String groupId){

        Utils.mkDirs(artifactId+".src.main.java."+groupId);
        Utils.mkDirs(artifactId+".src.main.resources");
        Utils.mkDirs(artifactId+".src.main.webapp.WEB-INF");

        Utils.mkDirs(artifactId+".src.test.java");
        Utils.mkDirs(artifactId+".src.test.resources");

        WarPom filePom = new WarPom(artifactId,groupId);
        Utils.fileMake(artifactId, "pom.xml", filePom);

        Home fileHome = new Home(artifactId,groupId);
        Utils.fileMake(artifactId+".src.main.webapp", "home.xhtml", fileHome);

        Index fileIndex = new Index(artifactId,groupId);
        Utils.fileMake(artifactId+".src.main.webapp", "index.html", fileIndex);

        Beans fileBeans = new Beans(artifactId,groupId);
        Utils.fileMake(artifactId+".src.main.webapp.WEB-INF", "beans.xml", fileBeans);

        FacesConfig fileFacesConfig = new FacesConfig(artifactId,groupId);
        Utils.fileMake(artifactId+".src.main.webapp.WEB-INF", "faces-config.xml", fileFacesConfig);

    } // War




} // TypeApp