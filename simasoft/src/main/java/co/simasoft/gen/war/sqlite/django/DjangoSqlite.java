package co.simasoft.gen.war.sqlite.django;

import java.io.*;
import java.util.*;

import co.simasoft.utils.*;
import co.simasoft.gen.war.sqlite.django.*;

public class DjangoSqlite extends FileTxt {

    private AppModels appModels;

    private String pathDocs = "";
    private String groupId = "";
    private String artifactId = "";

    private String dataBase = "ssqlite.django";
    private String dirSrc = "";

    public DjangoSqlite(AppModels appModels){

        this.appModels = appModels;
        this.pathDocs = this.appModels.getPathDocs();
        this.artifactId = this.appModels.getArtifactId();
        this.groupId = this.appModels.getGroupId();

        this.dirSrc = pathDocs+"."+dataBase+"."+artifactId+".models";

    }

    public void App() throws IOException {
    try {

        clearFileTxt();

        Utils.mkDirs(dirSrc);

    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    } // Jdocbook()

//    Utils.mkDirs();

}