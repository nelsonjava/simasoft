package com.simavirtual;

import java.io.*;
import java.util.*;

import co.simasoft.utils.*;

import co.simasoft.gen.asciidoc.*;
import co.simasoft.gen.jpa.*;

public class App extends FileTxt{

    private static ArrayList<Entidad> entidades       = new ArrayList<Entidad>();
    private static ArrayList<Relation> relationsPower = new ArrayList<Relation>();
    private static Set<Relation> relations            = new HashSet<Relation>(0);
    private static ArrayList<Modelos> modelos         = new ArrayList<Modelos>();

    private static String fileJar = "../g.jar";
    private static String filePowerDesigner = "";
    private static String pathDocs = "docs";
    private static String artifactId = "";
    private static String asciidocImages = "src.main.asciidoc.en-US.images";
    private static String asciidocModules = "src.main.asciidoc.en-US.modules";

    public static void generarModelo(String modelo,String groupId,String artifactId,ArrayList<String> imports) throws IOException {

        // Cleanup - Reinigung
        entidades.clear();
        relationsPower.clear();
        relations.clear();

        filePowerDesigner = "src/resources/models/"+modelo+"/"+artifactId+"/"+artifactId+".oob";

        PowerDesigner powerDesigner = new PowerDesigner(filePowerDesigner);
        entidades = powerDesigner.getEntidades();
        relations = powerDesigner.getRelations();
        relationsPower = powerDesigner.getRelationsPower();

        Utils.mkDirs(pathDocs+"."+modelo+"."+artifactId+"."+asciidocImages);
        Utils.mkDirs(pathDocs+"."+modelo+"."+artifactId+"."+asciidocModules);

        Utils.copyFile("src/resources/models/"+modelo+"/"+artifactId+"/"+artifactId+".jpg",
                       pathDocs+"/"+modelo+"/"+artifactId+"/src/main/asciidoc/en-US/images/modelo.jpg");

        Utils.fileJar("jdocbook","pom.xml",pathDocs+"\\"+modelo+"\\"+artifactId+"\\",fileJar);
        Utils.fileJar("jdocbook","master.asciidoc",pathDocs+"\\"+modelo+"\\"+artifactId+"\\src\\main\\asciidoc\\en-US\\",fileJar);
        Utils.fileJar("jdocbook","master-docinfo.xml",pathDocs+"\\"+modelo+"\\"+artifactId+"\\src\\main\\asciidoc\\en-US\\",fileJar);

        Asciidoc fileAsciidoc = new Asciidoc(artifactId,groupId,entidades);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".src.main.asciidoc.en-US.modules", "modelo.asciidoc", fileAsciidoc);

        Test fileTest = new Test(artifactId,groupId,relations,relationsPower);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".src.main.asciidoc.en-US.modules", "test.asciidoc", fileTest);

        for(Entidad entidad : entidades) {

            Entity0 entity0 = new Entity0(artifactId,groupId+".models."+modelo+"."+artifactId,entidad,imports);
            Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".src.main.java."+groupId+".models."+modelo+"."+artifactId+".0",entidad.getName()+".java", entity0);

            EntityMongo entityMongo = new EntityMongo(artifactId,groupId+".models."+modelo+"."+artifactId,entidad,imports);
            Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".src.main.java."+groupId+".models."+modelo+"."+artifactId+".mongo",entidad.getName()+".java", entityMongo);

            EntityH2 entityH2 = new EntityH2(artifactId,groupId+".models."+modelo+"."+artifactId,entidad,imports);
            Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".src.main.java."+groupId+".models."+modelo+"."+artifactId+".h2",entidad.getName()+".java", entityH2);

            EntityPruebaMongo entityPruebaMongo = new EntityPruebaMongo(artifactId,groupId+".models."+modelo+"."+artifactId,entidad,imports);
            Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".src.main.java."+groupId+".models."+modelo+"."+artifactId+".pmongo",entidad.getName()+".java", entityPruebaMongo);

            EntityPruebaH2 entityPruebaH2 = new EntityPruebaH2(artifactId,groupId+".models."+modelo+"."+artifactId,entidad,imports);
            Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".src.main.java."+groupId+".models."+modelo+"."+artifactId+".ph2",entidad.getName()+".java", entityPruebaH2);
        }

        Persistence persistence = new Persistence(artifactId,groupId+".models."+modelo,entidades);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".src.main.java."+groupId+".models."+modelo+"."+artifactId, "persistence.xml", persistence);

        Datasource datasource = new Datasource(artifactId,groupId,entidades);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".src.main.java."+groupId+".models."+modelo+"."+artifactId,artifactId+"-ds.xml", datasource);

    }

    public static void generar(ArrayList<Modelos> modelos) throws IOException {

        ArrayList<String> imports = new ArrayList<String>();
        for (Modelos modelo : modelos) {
            imports.add(modelo.getGroupId()+".models."+modelo.getModelo()+"."+modelo.getArtifactId());
        }

        for (Modelos modelo : modelos) {
             generarModelo(modelo.getModelo(),modelo.getGroupId(),modelo.getArtifactId(),imports);
        }

/*
        for(int x=0;x<imports.size();x++) {
           System.out.println(imports.get(x));
        }
*/

    }

    public static void main( String[] args ) throws IOException {

        modelos.add(new Modelos("contable","co.simasoft","contabilidad"));
        generar(modelos);
        modelos.clear();

//        modelos.add(new Modelos("iso","co.simasoft","archivo-inactivo"));
        modelos.add(new Modelos("iso","co.simasoft","lmd"));
        modelos.add(new Modelos("iso","co.simasoft","lmr"));
        modelos.add(new Modelos("iso","co.simasoft","procesos"));
        generar(modelos);
        modelos.clear();


    } // main

} // App
