package co.simasoft.utils;

public class Modelos {

    private String filePower  = "";
    private String groupId    = "";

    public Modelos(String filePower,String groupId){
        this.filePower  = filePower;
        this.groupId    = groupId;
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

} // Fin de clase