package co.simasoft.utils;

import java.io.*;
import java.util.*;

import co.simasoft.utils.*;

public class FilePowerDesigner{

    private String fileOom = "";
    private static ArrayList<Entidad> entidades  = new ArrayList<Entidad>(0);
    private static Set<Relation> relations = new HashSet<Relation>(0);
    private static Set<Relation> relationsPower = new HashSet<Relation>();

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

    public Set<Relation> getRelationsPower() {
        return relationsPower;
    }

} // FilePowerDesigner

