package co.simasoft.gen.war.h2.jquery;

import java.io.*;
import java.util.*;

import co.simasoft.utils.*;
import co.simasoft.gen.war.h2.jquery.*;

public class JqueryH2 extends FileTxt {

    private AppModels appModels;

    private String pathDocs = "";
    private String groupId = "";
    private String artifactId = "";

    private String dataBase = "h2.jquery";
    private String dirBuild = "build";
    private String dirDist = "dist";
    private String dirSrc = "src";

    public JqueryH2(AppModels appModels){

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
        Utils.mkDirs(dirSrc+".api-client");        
        Utils.mkDirs(dirBuild);
        Utils.mkDirs(dirDist);

        JqueryH2Package jqueryH2Package = new JqueryH2Package(artifactId);
        Utils.fileMake(pathDocs+"."+dataBase+"."+artifactId, "package.json", jqueryH2Package);

        JqueryH2Readme jqueryH2Readme = new JqueryH2Readme(artifactId);
        Utils.fileMake(pathDocs+"."+dataBase+"."+artifactId, "README.md", jqueryH2Readme);

        JqueryH2Gitignore jqueryH2Gitignore = new JqueryH2Gitignore(artifactId);
        Utils.fileMake(pathDocs+"."+dataBase+"."+artifactId, ".gitignore", jqueryH2Gitignore);

    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    } // Jdocbook()

//    Utils.mkDirs();

}