package co.simasoft.utils;

import java.util.*;

public class Packages{

    private String groupId    = "";
    private Set<Entidad> entities = new HashSet<Entidad>();
    private Set<Relation> relations = new HashSet<Relation>(0);
    private Set<Relation> relationsPower = new HashSet<Relation>();

    public Packages(){
    }

    public Packages(String groupId,Set<Entidad> entities){
       this.groupId = groupId;
       this.entities = entities;
    }

    public String getGroupId() {
        return groupId;
    }
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public Set<Entidad> getEntities(){
        return entities;
    }
    public void setEntities(Set<Entidad> entities){
        this.entities = entities;
    }

    public Set<Relation> getRelations(){
        return relations;
    }
    public void setRelations(Set<Relation> relations){
        this.relations = relations;
    }
    
    public Set<Relation> getRelationsPower(){
        return relationsPower;
    }
    public void setRelationsPower(Set<Relation> relationsPower){
        this.relationsPower = relationsPower;
    }

} // GroupIds

