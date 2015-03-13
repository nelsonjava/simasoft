package com.simavirtual;

import java.io.*;
import java.util.*;

import co.simasoft.utils.*;

import co.simasoft.gen.asciidoc.*;
import co.simasoft.gen.jpa.*;
import co.simasoft.gen.bean.*;
import co.simasoft.gen.xhtml.*;

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
            Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".src.main.java."+groupId+".models."+modelo+"."+artifactId+".jpa.0",entidad.getName()+".java", entity0);

            EntityMongo entityMongo = new EntityMongo(artifactId,groupId+".models."+modelo+"."+artifactId,entidad,imports);
            Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".src.main.java."+groupId+".models."+modelo+"."+artifactId+".jpa.mongo",entidad.getName()+".java", entityMongo);

            EntityH2 entityH2 = new EntityH2(artifactId,groupId+".models."+modelo+"."+artifactId,entidad,imports);
            Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".src.main.java."+groupId+".models."+modelo+"."+artifactId+".jpa.h2",entidad.getName()+".java", entityH2);

            EntityPruebaMongo entityPruebaMongo = new EntityPruebaMongo(artifactId,groupId+".models."+modelo+"."+artifactId,entidad,imports);
            Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".src.main.java."+groupId+".models."+modelo+"."+artifactId+".jpa.pmongo",entidad.getName()+".java", entityPruebaMongo);

            EntityPruebaH2 entityPruebaH2 = new EntityPruebaH2(artifactId,groupId+".models."+modelo+"."+artifactId,entidad,imports);
            Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".src.main.java."+groupId+".models."+modelo+"."+artifactId+".jpa.ph2",entidad.getName()+".java", entityPruebaH2);
        }

        for(Entidad entidad : entidades) {

            BeanH2 beanH2 = new BeanH2(artifactId,groupId+".models."+modelo+"."+artifactId,entidad,imports);
            Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".src.main.java."+groupId+".models."+modelo+"."+artifactId+".bean.h2",entidad.getName()+"Bean.java", beanH2);
        }
        BeanUtils beanUtils = new BeanUtils(artifactId,groupId+".models."+modelo+"."+artifactId,imports);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".src.main.java."+groupId+".models."+modelo+"."+artifactId+".bean","ViewUtils.java", beanUtils);

        for(Entidad entidad : entidades) {

            CreateH2 createH2 = new CreateH2(artifactId,groupId+".models."+modelo+"."+artifactId,entidad,imports);
            Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".src.main.java."+groupId+".models."+modelo+"."+artifactId+".xhtml."+entidad.getName()+".h2","create.xhtml", createH2);

            SearchH2 searchH2 = new SearchH2(artifactId,groupId+".models."+modelo+"."+artifactId,entidad,imports);
            Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".src.main.java."+groupId+".models."+modelo+"."+artifactId+".xhtml."+entidad.getName()+".h2","search.xhtml", searchH2);

            ViewH2 viewH2 = new ViewH2(artifactId,groupId+".models."+modelo+"."+artifactId,entidad,imports);
            Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".src.main.java."+groupId+".models."+modelo+"."+artifactId+".xhtml."+entidad.getName()+".h2","view.xhtml", viewH2);
        }

        TemplateCrud templateCrud = new TemplateCrud(artifactId,groupId+".models."+modelo+"."+artifactId,imports);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".src.main.java."+groupId+".models."+modelo+"."+artifactId+".xhtml","pageTemplate.xhtml", templateCrud);

        Paginator paginator = new Paginator(artifactId,groupId+".models."+modelo+"."+artifactId,imports);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".src.main.java."+groupId+".models."+modelo+"."+artifactId+".xhtml","paginator.xhtml", paginator);


        Persistence persistence = new Persistence(artifactId,groupId+".models."+modelo,entidades);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".src.main.java."+groupId+".models."+modelo+"."+artifactId, "persistence.xml", persistence);

        Datasource datasource = new Datasource(artifactId,groupId,entidades);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".src.main.java."+groupId+".models."+modelo+"."+artifactId,artifactId+"-ds.xml", datasource);

        GuiFsh guiFsh = new GuiFsh(artifactId,groupId+".models."+modelo,imports);
        Utils.fileMake(pathDocs+"."+modelo+"."+artifactId+".src.main.java."+groupId+".models."+modelo+"."+artifactId, "gui.fsh", guiFsh);

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
        modelos.add(new Modelos("pruebas","co.simasoft","prueba1"));
        modelos.add(new Modelos("pruebas","co.simasoft","prueba2"));
        generar(modelos);

    } // main

} // App
