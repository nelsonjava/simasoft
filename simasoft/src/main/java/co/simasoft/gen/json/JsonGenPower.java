package co.simasoft.gen.json;

import co.simasoft.utils.*;

import java.io.*;
import java.lang.*;
import java.util.*;

import java.util.HashSet;
import java.util.Set;

/****************************************************************************************************************
* CLASE : JsonGenPower                                                                                          *
*****************************************************************************************************************

AUTOR: Nelson A Fernández Gómez                FECHA DE INICIO: DOM 10 JUL/2016   FECHA FINAL: DOM 10 JUL/2016
       SIMASOFT Bucaramanga / SAN / Colombia   FECHA DE LA ULTIMA MODIFICACION:   DOM 10 JUL/2016 HORA: 07:20 AM

OBJETIVOS:

1- Genera el json para el intercambio de los datos de las entidades y sus atributos de acuerdo al diseño en
   powerDesiger.

2- Pendiente documentación

*---------------------------------------------------------------------------------------------------------------*
*------------------------------------------- DECLARACION DE LA CLASE -------------------------------------------*
*---------------------------------------------------------------------------------------------------------------*/

public class JsonGenPower extends FileTxt {

//>>DECLARACION DE INSTANCIAS
      private String fileOom = "";

      private static String name;
      private static String code;

      private static ArrayList<Entidad> entidades  = new ArrayList<Entidad>(0);
      private static ArrayList<Relation> relations = new ArrayList<Relation>(0);

      private int i=0;
      private int j=0;

//>>DECLARACION DE INSTANCIAS

/****************************************************************************************************************
* METODO..: Constructor de la clase                                                                             *
*****************************************************************************************************************

AUTOR: Nelson A Fernández Gómez                FECHA DE INICIO: LUN 29 JUN/2015   FECHA FINAL: LUN 29 JUN/2015
       SIMASOFT Bucaramanga / SAN / Colombia   FECHA DE LA ULTIMA MODIFICACION:   LUN 29 JUN/2015 HORA: 10:15 AM

OBJETIVOS:

1- Inicializa los atributos de la clase, que se van a usar para construir el archivo .java del bean de entidad.

*---------------------------------------------------------------------------------------------------------------*
*                                           IMPLEMENTACION DEL METODO                                           *
*---------------------------------------------------------------------------------------------------------------*/

public JsonGenPower(String fileOom) throws IOException {
    try {

      this.fileOom = fileOom;

      PowerDesigner powerDesigner = new PowerDesigner(fileOom);

           name = powerDesigner.getName();
           code = powerDesigner.getCode();
      entidades = powerDesigner.getEntidades();
      relations = powerDesigner.getRelations();
    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }


} // Constructor

public void entities(String fileJson) throws IOException {
    try {

    line("{");

    line("  \"properties\": [");
    line("    {");
    line("      \"groupIds\": \""+code+"\",");
    line("      \"version\": \""+name+"\"");
    line("    }");
    line("  ],");

    line("  \"Entities\": [");
    i = 1;
    for (Entidad entidad : entidades ) {
        line("    {");
        line("      \"orden\": \""+entidad.getOrden()+"\",");
        line("      \"name\": \""+entidad.getName()+"\"");


        if (i == entidades.size() ){
           line("    }");
        }
        else{
           line("    },");
        }
        i++;
    } // entidades
    line("  ]");

    line("}");

    saveFile("\\docs",fileJson+"Entities.json");

    attributes(fileJson);

    } // try
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

} // entities()

public void attributes(String fileJson) throws IOException {
    try {

    clearFileTxt();

    line("{");
    line("  \"Attributes\": [");
    i = 1;
    for (Entidad entidad : entidades ) {

        j = 1;
        for(Atributos attri : entidad.getAtributos() ){

           line("    {");
           line("      \"entity\": \""+entidad.getName()+"\",");
           line("      \"orden\": \""+Double.toString(attri.getOrden())+"\",");
           line("      \"name\": \""+attri.getField()+"\",");
           line("      \"isNullable\": "+attri.getNulo()+",");
           line("      \"isUnique\": "+attri.getUnique()+",");
           line("      \"AttributesTypes\": \""+attri.getType()+"\",");
           line("      \"isSimplified\": false,");
           line("      \"isCreate\": "+attri.getIsCreate()+",");
           line("      \"isSearch\": true,");
           line("      \"isView\": true,");
           line("      \"isViewRelation\": true,");
           line("      \"isViewColumn\": true");

           if (i == entidades.size() && j == entidad.getAtributos().size() ){
              line("    }");
           }
           else{
              line("    },");
           }
           j++;
        } // entidad.getAtributos()
        i++;
    } // entidades
    line("  ]");
    line("}");

    saveFile("\\docs",fileJson+"Attributes.json");

    } // try
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

} // attributes()

public void relations(String fileJson) throws IOException {
    try {

    line("{");

    line("  \"properties\": [");
    line("    {");
    line("      \"model\": \""+name+"\",");
    line("      \"groupIds\": \""+code+"\"");
    line("    }");
    line("  ],");

    line("  \"Relationships\": [");
    i = 1;
    for(Relation relation: relations) {

        line("    {");
        line("      \"From\": \""+relation.getFrom()+"\",");
        line("      \"To\": \""+relation.getTo()+"\",");
        line("      \"name\": \""+relation.getName()+"\",");
        line("      \"orden\": \""+relation.getOrden()+"\",");
        line("      \"isOptionality\": "+relation.getOptionality()+",");
        line("      \"isEmbedded\": false,");
        line("      \"isSimplified\": false,");
        line("      \"Cardinalities\": \""+Cardinaly(relation.getCardinality())+"\"");

        if (i == relations.size() ){
           line("    }");
        }
        else{
           line("    },");
        }
        i++;

    } // relations()
    line("  ]");

    line("}");

    saveFile("\\docs",fileJson+"relations.json");

    } // try
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

} // relations()

    public String Cardinaly(String cardinality) {

        switch (cardinality) {

            case "1..1":
                 return "Uno a Uno Bidirecccional No.2";

            case "*..1":
                 return "Uno a Muchos Bidirecccional No.5";

            case "1..*":
                 return "Uno a Muchos Bidirecccional No.5";

            case "*..*":
                 return "Muchos a Muchos Bidirecccional No.7";

        } // switch
        return "";

    } // Cardinaly



} // class