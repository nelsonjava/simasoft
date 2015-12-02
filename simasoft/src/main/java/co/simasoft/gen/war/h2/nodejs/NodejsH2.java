package co.simasoft.gen.war.h2.nodejs;

import java.io.*;
import java.util.*;

import co.simasoft.utils.*;
import co.simasoft.gen.war.h2.nodejs.*;

public class NodejsH2 extends FileTxt {

    private AppModels appModels;

    private String pathDocs = "";
    private String groupId = "";
    private String artifactId = "";

    private String dataBase = "h2.nodejs";
    private String dirBuild = "build";
    private String dirDist = "dist";
    private String dirSrc = "src";
    private String dirTest = "test";

    public NodejsH2(AppModels appModels){

        this.appModels = appModels;
        this.pathDocs = this.appModels.getPathDocs();
        this.artifactId = this.appModels.getArtifactId();
        this.groupId = this.appModels.getGroupId();

        this.dirBuild = pathDocs+"."+dataBase+"."+artifactId+"."+dirBuild;
        this.dirDist = pathDocs+"."+dataBase+"."+artifactId+"."+dirDist;
        this.dirSrc = pathDocs+"."+dataBase+"."+artifactId+"."+dirSrc;
        this.dirSrc = pathDocs+"."+dataBase+"."+artifactId+"."+dirTest;

    }

    public void App() throws IOException {
    try {

        clearFileTxt();

        Utils.mkDirs(dirSrc);
        Utils.mkDirs(dirSrc+".api-client");
        Utils.mkDirs(dirBuild);
        Utils.mkDirs(dirDist);

        NodejsH2Readme nodejsH2Readme = new NodejsH2Readme(artifactId);
        Utils.fileMake(pathDocs+"."+dataBase+"."+artifactId, "README.md", nodejsH2Readme);
        
        NodejsH2Package nodejsH2Package = new NodejsH2Package(artifactId);
        Utils.fileMake(pathDocs+"."+dataBase+"."+artifactId, "package.json", nodejsH2Package);

    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    } // Jdocbook()

//    Utils.mkDirs();

}