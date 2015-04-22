package co.simasoft.gen.sql;

import co.simasoft.utils.*;

import java.io.*;
import java.lang.*;
import java.util.*;

import java.util.HashSet;
import java.util.Set;

/****************************************************************************************************************
* CLASE : SqlTest                                                                                               *
*****************************************************************************************************************

AUTOR: Nelson A Fernández Gómez                FECHA DE INICIO: JUE 26 MAR/2015   FECHA FINAL: JUE 26 MAR/2015
       SIMASOFT Bucaramanga / SAN / Colombia   FECHA DE LA ULTIMA MODIFICACION:   JUE 26 MAR/2015 HORA: 02:15 PM

OBJETIVOS:

1- Genera el codigo java para generar los registros de la entidad.

2- El id es de tipo long

3- Trabaja bien en H2.

*---------------------------------------------------------------------------------------------------------------*
*------------------------------------------- DECLARACION DE LA CLASE -------------------------------------------*
*---------------------------------------------------------------------------------------------------------------*/

public class SqlTest extends FileTxt {

//>>DECLARACION DE INSTANCIAS
      private Entidad entity = new Entidad();                                // Entidad
      private ArrayList<Atributos> atributos = new ArrayList<Atributos>();   // Atributos de la Entidad
      private ArrayList<Relation> relations = new ArrayList<Relation>();     // Relaciones de la Entidad

      Integer nro = 4;                                                       // Número de Espacios de Margen
      String name = "";                                                      // Nombre del Atributo
      String type = "";                                                      // Tipo del Atributo
      String field = "";                                                     // Nombre del Campo
      Integer len;                                                           // Longitud del Campo
      Integer prec;                                                          // Decimales del Campo
//>>DECLARACION DE INSTANCIAS

/****************************************************************************************************************
* METODO..: Constructor de la clase                                                                             *
*****************************************************************************************************************

AUTOR: Nelson A Fernández Gómez                FECHA DE INICIO: JUE 26 MAR/2015   FECHA FINAL: JUE 26 MAR/2015
       SIMASOFT Bucaramanga / SAN / Colombia   FECHA DE LA ULTIMA MODIFICACION:   JUE 26 MAR/2015 HORA: 02:15 PM

OBJETIVOS:

1- Inicializa los atributos de la clase, que se van a usar para construir el archivo .java del bean de entidad.

*---------------------------------------------------------------------------------------------------------------*
*                                           IMPLEMENTACION DEL METODO                                           *
*---------------------------------------------------------------------------------------------------------------*/

public SqlTest(String artifactId,String groupId,ArrayList<Entidad> entidades,ArrayList<Relation> relations,LinkedHashSet<String> imports) throws IOException {
  
        for(Entidad entidad : entidades) {

          if (entidad.isEntity()) {
line("        "+entidad.getName());
          }

        }

      for(int i=0;i<relations.size();i++) {

            Relation relation = relations.get(i);

            line("//  ---------------------- "+relation.getFrom()+" "+relation.getCardinality()+" "+relation.getTo()+" -------------------------\n");

      } // for relations  


} // Constructor

} // class


