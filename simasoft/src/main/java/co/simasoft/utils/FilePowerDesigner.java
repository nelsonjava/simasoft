package co.simasoft.utils;

import java.io.*;
import java.util.*;

import co.simasoft.utils.*;

public class FilePowerDesigner{

    private String fileOom = "";
    private static ArrayList<Entidad> entidades = new ArrayList<Entidad>();
    private static Set<Relation> relations = new HashSet<Relation>(0);
    private static ArrayList<Relation> relationsPower = new ArrayList<Relation>();

    public FilePowerDesigner(String fileOom) throws IOException {
        this.fileOom = "src/resources/models/"+fileOom;
        PowerDesigner powerDesigner = new PowerDesigner(this.fileOom);
        entidades = powerDesigner.getEntidades();
        relations = powerDesigner.getRelations();
        relationsPower = powerDesigner.getRelationsPower();
    }

    public ArrayList<Entidad> getEntidades() {
        return entidades;
    }

    public Set<Relation> getRelations() {
        return relations;
    }

    public ArrayList<Relation> getRelationsPower() {
        return relationsPower;
    }

} // FilePowerDesigner

