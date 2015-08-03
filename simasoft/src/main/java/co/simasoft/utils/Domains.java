package co.simasoft.utils;

import java.io.*;
import java.util.*;

import co.simasoft.utils.*;

public class Domains{

    private String groupId    = "";
    private String artifactId = "";
    private String version = "";
    private ArrayList<Modelos> modelos = new ArrayList<Modelos>();

    private Set<Entidad> entities = new HashSet<Entidad>(0);
    private Set<Packages> packages = new HashSet<Packages>(0);


    public Domains(String groupId,String artifactId,String version,ArrayList<Modelos> modelos) throws IOException {
       this.groupId = groupId;
       this.artifactId = artifactId;
       this.version = version;
       this.modelos = modelos;
       generar();
    }

    public void generar() throws IOException  {

        for(Modelos modelo : modelos) {

           FilePowerDesigner filePowerDesigner = new FilePowerDesigner(modelo.getFilePower());

           entities = new HashSet<Entidad>(0);

           for(Entidad entidad : filePowerDesigner.getEntidades()) {
              if (!entidad.isEntity()){
                 continue;
              }
              entities.add(entidad);
           } // for

           Packages grupoId = new Packages(modelo.getGroupId(),entities);
           grupoId.setRelations(filePowerDesigner.getRelations());
           grupoId.setRelationsPower(filePowerDesigner.getRelationsPower());
           packages.add(grupoId);


        } // for
    }

    public String getGroupId() {
        return groupId;
    }
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }
    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }

    public Set<Packages> getPackages() {
        return packages;
    }




} // GroupIds

