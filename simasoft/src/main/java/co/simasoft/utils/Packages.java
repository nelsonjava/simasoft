package co.simasoft.utils;

import java.util.*;

public class Packages{

    private String groupId    = "";
    private String artifactId = "";
    private ArrayList<Entidad> entities = new ArrayList<Entidad>();

    public Packages(String groupId,String artifactId){
       this.groupId = groupId;
       this.artifactId = artifactId;
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

    public ArrayList<Entidad> getEntities(){
        return entities;
    }
    public void setEntities(ArrayList<Entidad> entities){
        this.entities = entities;
    }

} // GroupIds

