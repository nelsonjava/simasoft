package co.simasoft.gen.war.h2;

import java.io.*;
import java.util.*;

import co.simasoft.utils.*;

public class H2FileCsv extends FileTxt {

    private String path = "";
    private Set<String> groupIdsArtifactId = new HashSet<String>();
    private ArrayList<Entidad> entidades = new ArrayList<Entidad>(0);
    private ArrayList<Atributos> atributos = new ArrayList<Atributos>();
    private ArrayList<Relation> relations = new ArrayList<Relation>();

    public H2FileCsv(String path,Set<String> groupIdsArtifactId,ArrayList<Entidad> entidades) {
        this.path = path;
        this.groupIdsArtifactId = groupIdsArtifactId;
        this.entidades = entidades;
        data();
    }

    public void data() {
        Collections.sort(entidades);
        for(Entidad entidad : entidades) {
            entityData(entidad);
        }
    }

    public void entityData(Entidad entidad) {
    try {
        clearFileTxt();
        atributos = entidad.getAtributos();
        Collections.sort(atributos);
        String fieldType = "";
        String fieldName = "";
        for(Atributos atributo : atributos) {
           switch (atributo.getType()) {
               case "String":
                    fieldType += atributo.getType()+";";
                    fieldName += atributo.getField()+";";
                    break;

               case "Integer":
                    fieldType += atributo.getType()+";";
                    fieldName += atributo.getField()+";";
                    break;

               case "Float":
                    fieldType += atributo.getType()+";";
                    fieldName += atributo.getField()+";";
                    break;

               case "Double":
                    fieldType += atributo.getType()+";";
                    fieldName += atributo.getField()+";";
                    break;
               case "Boolean":
                    fieldType += atributo.getType()+";";
                    fieldName += atributo.getField()+";";
                    break;
               case "Date":
                    fieldType += atributo.getType()+";";
                    fieldName += atributo.getField()+";";
                    break;
               default:
                    break;
           } // switch (atributo.getType())
        }
        fieldType += entidad.getName()+";";
        line("\";\"");
        line(fieldType);
        line(fieldName);
        saveFile(path+"."+entidad.getGroupIds()+"."+entidad.getName()+".data",entidad.getName()+".csv");

        clearFileTxt();
        relations = entidad.getRelations();
        for(Relation relation : relations) {

            switch (relation.getNameCardinality()) {
                case "Uno a Muchos Bidirecccional No.5":
                     clearFileTxt();
                     line("From;FromProperty;FromValue;To;ToProperty;ToValue;Name;Cardinalities;");
                     line(relation.getEntityFrom().getName()+";"+"        ;        ;"+relation.getEntityTo().getName()+";        ;        ;       ;Uno a Muchos Bidirecccional No.5");
                     saveFile(path+"."+entidad.getGroupIds()+"."+entidad.getName()+".relations",relation.getEntityFrom().getName()+"R5"+relation.getEntityTo().getName()+".csv");
                     break;
                case "Muchos a Muchos Bidirecccional No.7":
                     clearFileTxt();
                     line("From;FromProperty;FromValue;To;ToProperty;ToValue;Name;Cardinalities;");
                     line(relation.getEntityFrom().getName()+";"+"        ;        ;"+relation.getEntityTo().getName()+";        ;        ;       ;Muchos a Muchos Bidirecccional No.7");
                     saveFile(path+"."+entidad.getGroupIds()+"."+entidad.getName()+".relations",relation.getEntityFrom().getName()+"R7"+relation.getEntityTo().getName()+".csv");
                     break;

                default:
                     break;
            } // switch (atributo.getType())

        }

    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }
    } // entityData(()



} // DevelopmentsGen