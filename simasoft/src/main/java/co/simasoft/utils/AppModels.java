package co.simasoft.utils;

import co.simasoft.utils.*;
import co.simasoft.gen.asciidoc.*;
import co.simasoft.gen.jpa.*;
import co.simasoft.gen.rest.*;
import co.simasoft.gen.sql.*;
import co.simasoft.gen.bean.*;
import co.simasoft.gen.xhtml.*;
import co.simasoft.gen.war.*;
import co.simasoft.gen.war.h2.*;
import co.simasoft.gen.war.h2.rest.*;


import java.io.*;
import java.util.*;

public class AppModels extends FileTxt {

    private String name;
    private String groupId;
    private String artifactId;
    private ArrayList<Packages> packages = new ArrayList<Packages>();
    private ArrayList<Entidad> entities = new ArrayList<Entidad>(0);


    private LinkedHashSet<String> imports = new LinkedHashSet<String>();

    private String fileJar = "../g.jar";
    private String pathDocs = "\\docs";

    public AppModels(String groupId,String artifactId){
       this.groupId = groupId;
       this.artifactId = artifactId;
       relationTo();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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

    public String getPathDocs() {
        return pathDocs;
    }
    public void setPathDocs(String pathDocs) {
        this.pathDocs = pathDocs;
    }

    public LinkedHashSet<String> getImports(){
        return imports;
    }
    public void setImports(LinkedHashSet<String> imports){
        this.imports = imports;
    }

    public ArrayList<Entidad> getEntities(){
        return entities;
    }
    public void setEntities(ArrayList<Entidad> entities){
        this.entities = entities;
    }

    public void addEntities(Entidad entity){
        this.entities.add(entity);
    }

    public ArrayList<Packages> getPackages(){
        return packages;
    }
    public void setPackages(ArrayList<Packages> packages){
        this.packages = packages;
    }

    private void relationTo(){

        for(Packages groupIds : packages) {

            for(Entidad entidad : groupIds.getEntities()) {

               for(Relation relation : entidad.getRelations()) {

                   Entidad entityFrom = seekEntidad(relation.getFrom());
                   entityFrom.setFieldCreate(entityFrom.fieldCreate());
                   relation.setEntityFrom(entityFrom);

                   Entidad entityTo = seekEntidad(relation.getTo());
                   entityTo.setFieldCreate(entityTo.fieldCreate());
                   relation.setEntityTo(entityTo);


               } // entidad.getRelations()

            } // for: groupIds.getEntities()

        } // for: packages

    } // relationTo()

    private Entidad seekEntidad(String name){

        for(Packages groupIds : packages) {

            for(Entidad entidad : groupIds.getEntities()) {

                if (entidad.getName().equals(name)){
                   return entidad;
                }

            } // for: groupIds.getEntities()

        } // for: packages

        return null;

    } // seekEntidad()


} // AppGenerator