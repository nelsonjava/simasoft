package co.simasoft.generator.utils;

import co.simasoft.utils.*;
import co.simasoft.generator.jar.*;

import java.io.*;

public class TypeApp{

    public static void Jar(String artifactId,String groupId){

        Utils.mkDirs(artifactId+".src.main.java."+groupId);

        Pom filePom = new Pom();
        filePom.Generar(artifactId,groupId);
        Utils.fileMake(artifactId, "pom.xml", filePom);

        App fileApp = new App();
        fileApp.Generar(groupId);
        Utils.fileMake(artifactId+".src.main.java."+groupId, "App.java", fileApp);


    } // typeApp

} // TypeApp