package co.simasoft.gen.rest;

import co.simasoft.utils.*;

import java.io.*;
import java.lang.*;
import java.util.*;

import java.util.HashSet;
import java.util.Set;

/****************************************************************************************************************
* CLASE : RestApplication                                                                                          *
*****************************************************************************************************************

AUTOR: NAIFG                                   FECHA DE INICIO: VIE 23 OCT/2015   FECHA FINAL: VIE 23 ENE/2016
       SIMASOFT Bucaramanga / SAN / Colombia   FECHA DE LA ULTIMA MODIFICACION:   VIE 23 OCT/2015 HORA: 14:30 PM

OBJETIVOS:

1- Pendiente la documentación

*---------------------------------------------------------------------------------------------------------------*
*------------------------------------------- DECLARACION DE LA CLASE -------------------------------------------*
*---------------------------------------------------------------------------------------------------------------*/

public class RestApplication extends FileTxt {

/****************************************************************************************************************
* METODO..: Constructor de la clase                                                                             *
*****************************************************************************************************************

AUTOR: Nelson A Fernández Gómez                FECHA DE INICIO: MAR 27 ENE/2015   FECHA FINAL: MAR 27 ENE/2015
       SIMASOFT Bucaramanga / SAN / Colombia   FECHA DE LA ULTIMA MODIFICACION:   MAR 27 ENE/2015 HORA: 02:30 PM

OBJETIVOS:

1- Pendiente la documentacion

*---------------------------------------------------------------------------------------------------------------*
*                                           IMPLEMENTACION DEL METODO                                           *
*---------------------------------------------------------------------------------------------------------------*/

public RestApplication(String groupId) throws IOException {

//>>GENERACION DEL ARCHIVO
      line("package "+groupId+".rest;\n");

      line("import javax.ws.rs.ApplicationPath;");
      line("import javax.ws.rs.core.Application;\n");

      line("@ApplicationPath(\"/rest\")");
      line("public class RestApplication extends Application {");
      line("}");
//>>GENERACION DEL ARCHIVO

    } // Constructor


}
