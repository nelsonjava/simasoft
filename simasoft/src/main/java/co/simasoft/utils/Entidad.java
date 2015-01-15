package co.simasoft.utils;

import java.io.*;
import java.util.*;

public class Entidad {

    private String name = "";
    private String ref = "";

    private ArrayList<Atributos> atributos;

    public Entidad() {
    }

    public Entidad(String name) {
        this.name = name;
    }

    public void setRef(String ref){
        this.ref = ref;
    }
    
    public String getRef(){
        return ref;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setAtributos(ArrayList<Atributos> atributos){
        this.atributos = atributos;
    }
    
    public ArrayList<Atributos> getAtributos(){
        return atributos;
    }

    public void addAtributo(Atributos atributos){
        this.atributos.add(atributos);
    }

} // Entidad