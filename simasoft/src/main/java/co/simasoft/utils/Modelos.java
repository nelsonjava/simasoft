package co.simasoft.utils;

public class Modelos {

    private String modelo     = "";
    private String groupId    = "";
    private String artifactId = "";

    public Modelos(String modelo,String groupId,String artifactId){
        this.modelo     = modelo;
        this.groupId    = groupId;
        this.artifactId = artifactId ;
    }

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
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