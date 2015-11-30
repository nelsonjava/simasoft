package co.simasoft.gen.war.h2.angular;

import java.io.*;
import java.util.*;

import co.simasoft.utils.*;

public class AngularH2 extends FileTxt {

    private AppModels appModels;

    private String pathDocs = "";
    private String groupId = "";
    private String artifactId = "";

    private String dataBase = "h2.angular";
    private String dirBuild = "build";
    private String dirDist = "dist";
    private String dirSrc = "src";

    public AngularH2(AppModels appModels){

        this.appModels = appModels;
        this.pathDocs = this.appModels.getPathDocs();
        this.artifactId = this.appModels.getArtifactId();
        this.groupId = this.appModels.getGroupId();

        this.dirBuild = pathDocs+"."+dataBase+"."+artifactId+"."+dirBuild;
        this.dirDist = pathDocs+"."+dataBase+"."+artifactId+"."+dirDist;
        this.dirSrc = pathDocs+"."+dataBase+"."+artifactId+"."+dirSrc;

    }

    public void App() throws IOException {
    try {

        clearFileTxt();

        Utils.mkDirs(dirSrc);
        Utils.mkDirs(dirBuild);
        Utils.mkDirs(dirDist);

        AngularH2Readme angularH2Readme = new AngularH2Readme(artifactId);
        Utils.fileMake(pathDocs+"."+dataBase+"."+artifactId, "README.md", angularH2Readme);

        AngularH2Gulpfile angularH2Gulpfile = new AngularH2Gulpfile(artifactId);
        Utils.fileMake(pathDocs+"."+dataBase+"."+artifactId, "gulpfile.js", angularH2Gulpfile);

        AngularH2Gulpfile1 angularH2Gulpfile1 = new AngularH2Gulpfile1(artifactId);
        Utils.fileMake(pathDocs+"."+dataBase+"."+artifactId, "gulpfile1.js", angularH2Gulpfile1);

    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    } // Jdocbook()

//    Utils.mkDirs();

}