package co.simasoft.utils;

import java.io.*;
import java.util.*;

public class Entidad {

    private String name = "";
    private String ref = "";

    private ArrayList<Atributos> atributos;
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

    public ArrayList<Atributos> getAtributos(){
        return atributos;
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

} // Entidad