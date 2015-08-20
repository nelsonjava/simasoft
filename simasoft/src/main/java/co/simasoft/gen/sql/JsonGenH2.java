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
      int i=0;
      int j=0;
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
    i=0;
    j=0;
    for (String impor : imports) {

line("  \"GroupIds\": {");
line("     \"groupId\": \""+impor+"\",");
line("     \"artifactId\": \""+impor+"\",");
line("  }");

    } // for: imports

line("  \"Models\": {");
line("     \"groupId\": \""+domain.getGroupId()+"."+domain.getArtifactId()+"\",");
line("     \"artifactId\": \""+domain.getArtifactId()+"\",");
line("     \"version\": \""+domain.getVersion()+"\"");
line("  }");

//      ---------------------- Developments ------------------------

line("  \"Developments\": {");
line("     \"groupId\": \""+domain.getGroupId()+"\",");
line("     \"artifactId\": \""+domain.getArtifactId()+"\",");
line("     \"version\": \""+domain.getVersion()+"\",");
line("     \"models\": \""+domain.getArtifactId()+"\"");
line("  }");

//      ---------------------- Entities ------------------------

    i=0;
    j=0;
    for (Packages groupId : domain.getPackages()){

        for (Entidad entidad: groupId.getEntities()) {

line("  \"Entities\": {");
line("     \"name\": \""+entidad.getName()+"\",");
line("     \"groupIds\": \""+groupId.getGroupId()+"\",");

            for (Atributos attri: entidad.getAtributos()) {

line("     \"Attributes\":{");
line("        \"name\": \""+attri.getField()+"\",");
line("        \"isNullable\": \""+attri.getNulo()+"\",");
line("        \"isUnique\": \""+attri.getUnique()+"\",");
line("        \"AttributesTypes\": \""+attri.getType()+"\",");
line("     }");

            } // for: entidad.getAtributos()

line("  }");

        } // for: groupId.getEntities()

    } // for: domain.getPackages()

//      ---------------------- Relationships ------------------------

    for (Packages groupId : domain.getPackages()){
      
        for (Relation relation: groupId.getRelations()) {
          
line("  \"Relationships\": {");
line("     \"isOptionality\": "+relation.getOptionality()+",");
line("     \"isEmbedded\": false,");
line("     \"isSimplified\": false,");
line("     \"From\": \""+relation.getFrom()+"\",");
line("     \"To\": \""+relation.getTo()+"\",");
line("     \"Cardinalities\": \""+Cardinaly(relation.getCardinality())+"\",");
line("  }");

        } // for: groupId.getRelations()

    } // for: domain.getPackages()

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


