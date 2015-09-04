package co.simasoft.gen.sql;

import co.simasoft.utils.*;

import java.io.*;
import java.lang.*;
import java.util.*;

import java.util.HashSet;
import java.util.Set;

/****************************************************************************************************************
* CLASE : JsonGenH2                                                                                             *
*****************************************************************************************************************

AUTOR: Nelson A Fernández Gómez                FECHA DE INICIO: LUN 29 JUN/2015   FECHA FINAL: LUN 29 JUN/2015
       SIMASOFT Bucaramanga / SAN / Colombia   FECHA DE LA ULTIMA MODIFICACION:   LUN 29 JUN/2015 HORA: 10:00 AM

OBJETIVOS:

1- Genera el json para el intercambio de los datos de las entidades y sus atributos de acuerdo al diseño en
   powerDesiger.

2- Pendiente documentación

*---------------------------------------------------------------------------------------------------------------*
*------------------------------------------- DECLARACION DE LA CLASE -------------------------------------------*
*---------------------------------------------------------------------------------------------------------------*/

public class JsonGenH2 extends FileTxt {

//>>DECLARACION DE INSTANCIAS
      LinkedHashSet<String> imports = new LinkedHashSet<String>();
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

public JsonGenH2(Domains domain) throws IOException {
    try {

    for (Packages groupId : domain.getPackages()){
        imports.add(groupId.getGroupId());
    }

line("{");
line("  \"id\": 1,");
line("  \"firstname\": \"Katerina\",");
line("  \"GroupIds\": [");
    Iterator iImpor = imports.iterator();
    while(iImpor.hasNext()){
       String impor = (String) iImpor.next();
line("    {");
line("      \"groupId\": \""+impor+"\",");
       if(iImpor.hasNext()){
line("      \"artifactId\": \""+impor+"\",");
       }
       else {
line("      \"artifactId\": \""+impor+"\"");
       }

line("    }");
    }
line("  ]");

line("  \"Models\": [");
line("    {");
line("      \"groupId\": \""+domain.getGroupId()+"."+domain.getArtifactId()+"\",");
line("      \"artifactId\": \""+domain.getArtifactId()+"\",");
line("      \"version\": \""+domain.getVersion()+"\"");
line("    }");
line("  ]");

//      ---------------------- Developments ------------------------

line("  \"Developments\": [");
line("    {");
line("      \"groupId\": \""+domain.getGroupId()+"\",");
line("      \"artifactId\": \""+domain.getArtifactId()+"\",");
line("      \"version\": \""+domain.getVersion()+"\",");
line("      \"models\": \""+domain.getArtifactId()+"\"");
line("    }");
line("  ]");

//      ---------------------- Entities ------------------------

line("  \"Entities\": [");
    for (Packages groupId : domain.getPackages()){
          for(int i=0; i<groupId.getEntities().size(); i++){
              Entidad entidad = groupId.getEntities().get(i);
line("    {");
line("      \"name\": \""+entidad.getName()+"\",");
              if(i<groupId.getEntities().size()){
line("      \"groupIds\": \""+groupId.getGroupId()+"\",");
       }
              else {
line("      \"groupIds\": \""+groupId.getGroupId()+"\"");
       }
line("    },");
        } // for: groupId.getEntities()
    } // for: domain.getPackages()
line("  ]");



//      ---------------------- Attributes ------------------------

line("  \"Attributes\": [");
    for (Packages groupId : domain.getPackages()){
        for (Entidad entidad: groupId.getEntities()) {
          for(int i=0; i<entidad.getAtributos().size(); i++){
              Atributos attri = entidad.getAtributos().get(i);
line("    {");
line("      \"entity\": \""+entidad.getName()+"\",");
line("      \"name\": \""+attri.getField()+"\",");
line("      \"isNullable\": \""+attri.getNulo()+"\",");
line("      \"isUnique\": \""+attri.getUnique()+"\",");
              if(i<entidad.getAtributos().size()){
line("      \"AttributesTypes\": \""+attri.getType()+"\",");
       }
              else {
line("      \"AttributesTypes\": \""+attri.getType()+"\"");
       }
line("    },");
            } // for: entidad.getAtributos()
        } // for: groupId.getEntities()
    } // for: domain.getPackages()
line("  ]");

//      ---------------------- Relationships ------------------------

line("  \"Relationships\": [");
    for (Packages groupId : domain.getPackages()){
//        for (Relation relation: groupId.getRelations()) {
        for(int i=0; i<groupId.getRelations().size(); i++){
            Relation relation = groupId.getRelations().get(i);

line("    {");
line("      \"From\": \""+relation.getFrom()+"\",");
line("      \"To\": \""+relation.getTo()+"\",");
line("      \"isOptionality\": "+relation.getOptionality()+",");
line("      \"isEmbedded\": false,");
line("      \"isSimplified\": false,");
              if(i<groupId.getRelations().size()){
line("      \"Cardinalities\": \""+Cardinaly(relation.getCardinality())+"\",");
       }
              else {
line("      \"Cardinalities\": \""+Cardinaly(relation.getCardinality())+"\"");
       }
line("    },");
        } // for: groupId.getRelations()
    } // for: domain.getPackages()
line("  ]");
line("}");

    saveFile("\\docs", domain.getArtifactId()+"Setup.json");

    } // try
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

} // Constructor

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