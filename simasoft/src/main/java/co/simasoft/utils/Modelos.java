package co.simasoft.utils;

public class Modelos {

    private String filePower  = "";
    private String groupId    = "";
    private String artifactId = "";

    public Modelos(String filePower,String groupId,String artifactId){
        this.filePower  = filePower;
        this.groupId    = groupId;
        this.artifactId = artifactId ;
    }

    public String getFilePower() {
        return filePower;
    }
    public void setFilePower(String filePower) {
        this.filePower = filePower;
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

} // Fin de clase