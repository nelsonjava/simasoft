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
      
      private int i=0;
      private int j=0;
      private int k=0;
      private int y=0;

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
line("  \"GroupIds\": [");

    i=1;
    for (String impor : imports) {

line("    {");
line("      \"artifactId\": \""+impor+"\",");
line("      \"groupId\": \""+impor+"\",");
line("      \"version\": \"\",");
line("      \"code\": \"\"");
          if (i == imports.size()){
line("    }");
          }
          else{
line("    },");
          }
    i++;
    }
line("  ],");

//      -------------------------- Models ---------------------------

line("  \"Models\": [");
line("    {");
line("      \"artifactId\": \""+domain.getArtifactId()+"\",");
line("      \"groupId\": \""+domain.getGroupId()+"."+domain.getArtifactId()+"\",");
line("      \"version\": \""+domain.getVersion()+"\",");
line("      \"code\": \"\"");
line("    }");
line("  ],");

//      ---------------------- ModelsGroupIds ------------------------

line("  \"ModelsGroupIds\": [");
line("    {");
line("      \"isSimplified\": false,");
line("      \"isIsolated\": false,");
line("      \"GroupIds.groupId\": \""+domain.getGroupId()+"."+domain.getArtifactId()+"\",");
line("      \"Models.artifactId\": \""+domain.getArtifactId()+"\"");
line("    }");
line("  ],");

//      ---------------------- Developments ------------------------

line("  \"Developments\": [");
line("    {");
line("      \"artifactId\": \""+domain.getArtifactId()+"\",");
line("      \"groupId\": \""+domain.getGroupId()+"\",");
line("      \"version\": \""+domain.getVersion()+"\",");
line("      \"code\": \"\",");
line("      \"Models.artifactId\": \""+domain.getArtifactId()+"\"");
line("    }");
line("  ],");

//      ---------------------- Entities ------------------------
//      line(" paso1     x="+Integer.toString(x));
//      line("      xsize="+Integer.toString(domain.getPackages().size()));
//      line(" paso2     x="+Integer.toString(x));
//       line("      j="+Integer.toString(j)+" size="+Integer.toString(groupId.getEntities().size()));


    i = 1;
line("  \"Entities\": [");
    for (Packages groupId : domain.getPackages()){
        j = 1;
        for (Entidad entidad : groupId.getEntities() ) {

line("    {");
line("      \"name\": \""+entidad.getName()+"\",");
line("      \"groupId\": \""+groupId.getGroupId()+"\",");
line("      \"groupIds\": \""+groupId.getGroupId()+"\"");
          if (i == domain.getPackages().size() && j == groupId.getEntities().size() ){
line("    }");
          }
          else{
line("    },");
          }
            j++;
        } // for: groupId.getEntities()
        i++;
    } // for: domain.getPackages()
line("  ],");

//      ---------------------- GroupIdsEntities ------------------------

    i = 1;
line("  \"GroupIdsEntities\": [");
    for (Packages groupId : domain.getPackages()){
        j = 1;
        for (Entidad entidad : groupId.getEntities() ) {

line("    {");
line("      \"entity\": \""+entidad.getName()+"\",");
line("      \"groupIds.artifactId\": \""+domain.getArtifactId()+"\",");
line("      \"isIsolated\": false,");
line("      \"isSimplified\": false");

          if (i == domain.getPackages().size() && j == groupId.getEntities().size() ){
line("    }");
          }
          else{
line("    },");
          }
            j++;
        } // for: groupId.getEntities()
        i++;
    } // for: domain.getPackages()
line("  ],");


//      ---------------------- Attributes ------------------------

    i = 1;
line("  \"Attributes\": [");
    for (Packages groupId : domain.getPackages()){
        j = 1;
        for (Entidad entidad: groupId.getEntities()) {
          k = 1;
          for(Atributos attri : entidad.getAtributos() ){

line("    {");
line("      \"entity\": \""+entidad.getName()+"\",");
line("      \"name\": \""+attri.getField()+"\",");
line("      \"isNullable\": "+attri.getNulo()+",");
line("      \"isUnique\": "+attri.getUnique()+",");
line("      \"AttributesTypes\": \""+attri.getType()+"\"");
          if (i == domain.getPackages().size() && j == groupId.getEntities().size() && k == entidad.getAtributos().size() ){
line("    }");
          }
          else{
line("    },");
          }
          k++;
          } // for: entidad.getAtributos()
        j++;
        } // for: groupId.getEntities()
    i++;
    } // for: domain.getPackages()
line("  ],");

//      ---------------------- Relationships ------------------------

line("  \"Relationships\": [");
    i = 1;
    for (Packages groupId : domain.getPackages()){
        j = 1;
        for (Relation relation: groupId.getRelations()) {

line("    {");
line("      \"From\": \""+relation.getFrom()+"\",");
line("      \"To\": \""+relation.getTo()+"\",");
line("      \"name\": \"\",");
line("      \"isOptionality\": "+relation.getOptionality()+",");
line("      \"isEmbedded\": false,");
line("      \"isSimplified\": false,");
line("      \"Cardinalities\": \""+Cardinaly(relation.getCardinality())+"\"");
          if (i == domain.getPackages().size() && j == groupId.getRelations().size() ){
line("    }");
          }
          else{
line("    },");
          }
          j++;
        } // for: groupId.getRelations()
        i++;
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