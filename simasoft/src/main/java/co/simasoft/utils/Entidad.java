package co.simasoft.utils;

import java.io.*;
import java.util.*;

public class Entidad {

    private String groupId = "";
    private String name = "";
    private String ref = "";

    private ArrayList<Atributos> atributos = new ArrayList<Atributos>() ;
    private ArrayList<Relation> relations = new ArrayList<Relation>();

    public Entidad() {
    }

    public Entidad(String name) {
        this.name = name;
    }

    public String getRef(){
        return ref;
    }

    public void setRef(String ref){
        this.ref = ref;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public String getGroupId() {
        return groupId;
    }
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public ArrayList<Atributos> getAtributos(){
        return atributos;
    }

    public String getParameters(){

        String parameters = "";
        int j = 0;

        for(int i=0;i<atributos.size();i++) {

            Atributos  atributo = atributos.get(i);
            parameters = parameters+atributo.getType()+" "+atributo.getField();

            if (++j<atributos.size()){
               parameters = parameters+",";
            }
        }
        return parameters;
    }

    public void setAtributos(ArrayList<Atributos> atributos){
        this.atributos = atributos;
    }

    public void addAtributo(Atributos atributos){
        this.atributos.add(atributos);
    }

    public ArrayList<Relation> getRelations(){
        return relations;
    }

    public void setRelations(ArrayList<Relation> relations){
        this.relations = relations;
    }

    public void addRelations(Relation relations){
        this.relations.add(relations);
    }

    public boolean isEntity(){

      for (Atributos attribute : atributos) {
          if (attribute.getField().toLowerCase().equals("entity")) {
             return false;
          }
      }
      return true;
    }

} // Entidad