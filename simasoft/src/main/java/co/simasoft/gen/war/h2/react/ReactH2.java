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
    private String dirComponents = "components";

    public ReactH2(AppModels appModels){

        this.appModels = appModels;
        this.pathDocs = this.appModels.getPathDocs();
        this.artifactId = this.appModels.getArtifactId();
        this.groupId = this.appModels.getGroupId();

        this.dirBuild = pathDocs+"."+dataBase+"."+artifactId+"."+dirBuild;
        this.dirDist = pathDocs+"."+dataBase+"."+artifactId+"."+dirDist;
        this.dirSrc = pathDocs+"."+dataBase+"."+artifactId+"."+dirSrc;
        this.dirComponents = this.dirSrc+"."+dirComponents;

    }

    public void App() throws IOException {
    try {

        clearFileTxt();

        Utils.mkDirs(dirComponents);
        Utils.mkDirs(dirBuild);
        Utils.mkDirs(dirDist);

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

    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    } // Jdocbook()

//    Utils.mkDirs();

}