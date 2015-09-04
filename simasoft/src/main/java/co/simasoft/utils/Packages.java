package co.simasoft.utils;

import java.util.*;

public class Packages{

    private String groupId    = "";
    private ArrayList<Entidad> entities = new ArrayList<Entidad>();
    private ArrayList<Relation> relations = new ArrayList<Relation>(0);
    private Set<Relation> relationsPower = new HashSet<Relation>();

    public Packages(){
    }

    public Packages(String groupId,ArrayList<Entidad> entities){
       this.groupId = groupId;
       this.entities = entities;
    }

    public String getGroupId() {
        return groupId;
    }
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public ArrayList<Entidad> getEntities(){
        return entities;
    }
    public void setEntities(ArrayList<Entidad> entities){
        this.entities = entities;
    }

    public ArrayList<Relation> getRelations(){
        return relations;
    }
    public void setRelations(ArrayList<Relation> relations){
        this.relations = relations;
    }

    public Set<Relation> getRelationsPower(){
        return relationsPower;
    }
    public void setRelationsPower(Set<Relation> relationsPower){
        this.relationsPower = relationsPower;
    }

} // GroupIds

