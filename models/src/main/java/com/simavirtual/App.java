package com.simavirtual;

import java.io.*;
import java.util.*;

import co.simasoft.utils.*;

import co.simasoft.gen.asciidoc.*;
import co.simasoft.gen.jpa.*;

public class App{

    private static ArrayList<Entidad> entidades = new ArrayList<Entidad>();
    private static ArrayList<Relation> relationsPower = new ArrayList<Relation>();
    private static Set<Relation> relations = new HashSet<Relation>(0);

    private static String path = "";

    private static String fileJar = "../g.jar";
    private static String filePowerDesigner = "";
    private static String pathDocs = "docs";
    private static String artifactId = "";
    private static String groupId = "com.simavirtual";
    private static String asciidocImages = "src.main.asciidoc.en-US.images";
    private static String asciidocModules = "src.main.asciidoc.en-US.modules";

    public static void generarModelo(String pathPaquete,String artifactId) throws IOException {

        // Cleanup - Reinigung
        entidades.clear();
        relationsPower.clear();
        relations.clear();

        path = Utils.Paths(pathPaquete);

        filePowerDesigner = "src/resources/models/"+path+"/"+artifactId+"/"+artifactId+".oob";

        PowerDesigner powerDesigner = new PowerDesigner(filePowerDesigner);
        entidades = powerDesigner.getEntidades();
        relations = powerDesigner.getRelations();
        relationsPower = powerDesigner.getRelationsPower();

        Utils.mkDirs(pathDocs+"."+pathPaquete+"."+artifactId+"."+asciidocImages);
        Utils.mkDirs(pathDocs+"."+pathPaquete+"."+artifactId+"."+asciidocModules);

        Utils.copyFile("src/resources/models/"+path+"/"+artifactId+"/"+artifactId+".jpg",pathDocs+"/"+path+"/"+artifactId+"/src/main/asciidoc/en-US/images/modelo.jpg");

        Utils.fileJar("poma.xml",pathDocs+"\\"+path+"\\"+artifactId+"\\",fileJar);
        Utils.fileJar("master.asciidoc",pathDocs+"\\"+path+"\\"+artifactId+"\\src\\main\\asciidoc\\en-US\\",fileJar);
        Utils.fileJar("master-docinfo.xml",pathDocs+"\\"+path+"\\"+artifactId+"\\src\\main\\asciidoc\\en-US\\",fileJar);

        Asciidoc fileAsciidoc = new Asciidoc(artifactId,groupId,entidades);
        Utils.fileMake(pathDocs+"."+path+"."+artifactId+".src.main.asciidoc.en-US.modules", "modelo.asciidoc", fileAsciidoc);

        Test fileTest = new Test(artifactId,groupId,relations,relationsPower);
        Utils.fileMake(pathDocs+"."+path+"."+artifactId+".src.main.asciidoc.en-US.modules", "test.asciidoc", fileTest);

        for(Entidad entidad : entidades) {

            Entity0 entity0 = new Entity0(artifactId,groupId+".models."+artifactId,entidad);
            Utils.fileMake(pathDocs+"."+path+"."+artifactId+".src.main.java."+groupId+".models."+artifactId+".0",entidad.getName()+".java", entity0);

            Entity1 entity1 = new Entity1(artifactId,groupId+".models."+artifactId,entidad);
            Utils.fileMake(pathDocs+"."+path+"."+artifactId+".src.main.java."+groupId+".models."+artifactId+".1",entidad.getName()+".java", entity1);
        }

    }

    public static void main( String[] args ) throws IOException {

        generarModelo("conta","conta");  // Prueba
        generarModelo("contab","contab");
        generarModelo("iso","archivo-inactivo");
        generarModelo("iso","lmd");
        generarModelo("iso","lmr");
        generarModelo("iso","procesos");


    } // main

} // App
