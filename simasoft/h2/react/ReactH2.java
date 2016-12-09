package co.simasoft.gen.war.h2.react;

import java.io.*;
import java.util.*;

import co.simasoft.utils.*;
import co.simasoft.gen.war.h2.react.*;

public class ReactH2 extends FileTxt {

    private AppModels appModels;

    private String pathDocs = "";
    private String groupId = "";
    private String artifactId = "";

    private String dataBase = "h2.react";
    private String dirBuild = "build";
    private String dirDist = "dist";
    private String dirSrc = "src";
    private String dirClient = "client";
    private String dirServer = "server";
    private String dirComponents = "components";
    private String dirApi = "db-api";
    private String dirCss = "css";
    private String dirImg = "img";
    private String dirScripts = "scripts";
    private String dirTemplates = "templates";

    public ReactH2(AppModels appModels){

        this.appModels = appModels;
        this.pathDocs = this.appModels.getPathDocs();
        this.artifactId = this.appModels.getArtifactId();
        this.groupId = this.appModels.getGroupId();

        this.dirBuild = pathDocs+"."+dataBase+"."+artifactId+"."+dirBuild;

        this.dirDist = pathDocs+"."+dataBase+"."+artifactId+"."+dirDist;

        this.dirSrc = pathDocs+"."+dataBase+"."+artifactId+"."+dirSrc;
        this.dirClient = this.dirSrc+"."+dirClient;
        this.dirServer = this.dirSrc+"."+dirServer;

        this.dirCss = this.dirClient+"."+dirCss;
        this.dirImg = this.dirClient+"."+dirImg;
        this.dirScripts = this.dirClient+"."+dirScripts;
        this.dirComponents = this.dirScripts+"."+dirComponents;
        this.dirApi = this.dirScripts+"."+dirApi;
        this.dirTemplates = this.dirClient+"."+dirTemplates;
    }

    public void App() throws IOException {
    try {

        clearFileTxt();

        Utils.mkDirs(dirBuild);
        Utils.mkDirs(dirDist+".css");
        Utils.mkDirs(dirDist+".img");
        Utils.mkDirs(dirDist+".scripts");

        Utils.mkDirs(dirServer);

        Utils.mkDirs(dirCss);
        Utils.mkDirs(dirImg);
        Utils.mkDirs(dirTemplates);
        Utils.mkDirs(dirComponents);
        Utils.mkDirs(dirApi);

        ReactH2Package reactH2Package = new ReactH2Package(artifactId);
        Utils.fileMake(pathDocs+"."+dataBase+"."+artifactId, "package.json", reactH2Package);

        ReactH2Readme reactH2Readme = new ReactH2Readme(artifactId);
        Utils.fileMake(pathDocs+"."+dataBase+"."+artifactId, "README.md", reactH2Readme);

        ReactH2Gulpfile reactH2Gulpfile = new ReactH2Gulpfile(artifactId);
        Utils.fileMake(pathDocs+"."+dataBase+"."+artifactId, "gulpfile.js", reactH2Gulpfile);

        ReactH2Gitignore reactH2Gitignore = new ReactH2Gitignore(artifactId);
        Utils.fileMake(pathDocs+"."+dataBase+"."+artifactId, ".gitignore", reactH2Gitignore);

        ReactH2Build reactH2Build = new ReactH2Build(artifactId);
        Utils.fileMake(pathDocs+"."+dataBase+"."+artifactId, "build.xml", reactH2Build);

        ReactH2EntitiesJS reactH2EntitiesJS = new ReactH2EntitiesJS(artifactId,appModels.getEntities());
        Utils.fileMake(dirApi, "entities.js", reactH2EntitiesJS);

        ReactH2Index reactH2Index = new ReactH2Index(artifactId);
        Utils.fileMake(dirSrc, "index.html", reactH2Index);

        ReactH2Css reactH2Css = new ReactH2Css(artifactId);
        Utils.fileMake(dirCss, "app.css", reactH2Css);

    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    } // Jdocbook()

//    Utils.mkDirs();

}