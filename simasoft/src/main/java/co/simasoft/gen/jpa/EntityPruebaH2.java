package co.simasoft.gen.jpa;

import co.simasoft.utils.*;

import java.io.*;
import java.lang.*;
import java.util.*;

import java.util.HashSet;
import java.util.Set;

/****************************************************************************************************************
* CLASE : EntityPruebaH2                                                                                              *
*****************************************************************************************************************

AUTOR: Nelson A Fernández Gómez                FECHA DE INICIO: MAR 27 ENE/2015   FECHA FINAL: MAR 27 ENE/2015
       SIMASOFT Bucaramanga / SAN / Colombia   FECHA DE LA ULTIMA MODIFICACION:   MAR 27 ENE/2015 HORA: 02:15 PM

OBJETIVOS:

1- Genera el archivo java correspondiente a una entidad del modelo de datos.

2- El id es de tipo long

3- Trabaja bien en H2.

4- No genera relaciones.

*---------------------------------------------------------------------------------------------------------------*
*------------------------------------------- DECLARACION DE LA CLASE -------------------------------------------*
*---------------------------------------------------------------------------------------------------------------*/

public class EntityPruebaH2 extends FileTxt {

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

AUTOR: Nelson A Fernández Gómez                FECHA DE INICIO: MAR 27 ENE/2015   FECHA FINAL: MAR 27 ENE/2015
       SIMASOFT Bucaramanga / SAN / Colombia   FECHA DE LA ULTIMA MODIFICACION:   MAR 27 ENE/2015 HORA: 02:30 PM

OBJETIVOS:

1- Inicializa los atributos de la clase, que se van a usar para construir el archivo .java del bean de entidad.

*---------------------------------------------------------------------------------------------------------------*
*                                           IMPLEMENTACION DEL METODO                                           *
*---------------------------------------------------------------------------------------------------------------*/

public EntityPruebaH2(String artifactId,String groupId,Entidad entity,ArrayList<String> imports) throws IOException {

//>>INICIALIZACION DE ATRIBUTOS
      this.entity = entity;
      this.atributos = entity.getAtributos();
      this.relations = entity.getRelations();
//>>FIN INICIALIZACION DE ATRIBUTOS

//>>PAQUETE DE LA CLASE
      line("package "+groupId+";\n");
//>>FIN PAQUETE DE LA CLASE

//>>IMPORTS DE LA CLASE
      for(int x=0;x<imports.size();x++) {
         line("import "+imports.get(x)+".*;");
      }
      line("");

      line("import java.util.*;\n");
      line("import javax.persistence.*;");
      line("import javax.validation.constraints.*;\n");
//>>FIN IMPORTS DE LA CLASE

//>>DOCUMENTACION DE LA CLASE
//>>FIN DOCUMENTACION DE LA CLASE

//>>NAMEDQUERIES DE LA CLASE
//>>FIN NAMEDQUERIES DE LA CLASE

//>>ANNOTATIONS DE LA CLASE
      line("@Entity");
//>>FIN ANNOTATIONS DE LA CLASE

//>>DECLARACION DE LA CLASE
      // - La clase Hereda: Por defecto, no hereda NADA
      // - Modificador de la clase: - public - por defecto
      line("public class "+entity.getName()+" {\n");
//>>FIN DECLARACION DE LA CLASE

//>>ATTRIBUTOS POR DEFECTO
      line("    private static final long serialVersionUID = 1L;\n");

      line("    @Id");
      line("    @GeneratedValue(strategy=GenerationType.TABLE)");
      line("    private long id;\n");

      line("    private Integer optlock;\n");
//>>FIN ATTRIBUTOS POR DEFECTO

//>>ATTRIBUTOS DE LA CLASE
      for (Atributos attribute : atributos) {

//********ANNOTATIONS DEL ATTRIBUTO
           if (attribute.getNulo()) {
//               line("    @NotNull");
           }
//********FIN ANNOTATIONS DEL ATTRIBUTO

//********DECLARACION DEL ATTRIBUTO
            name  = attribute.getField();
            type  = attribute.getType();

            line("    private "+type+" "+name+";\n");
//********DECLARACION DEL ATTRIBUTO

      } // for atributos
//>>FIN ATTRIBUTOS DE LA CLASE

//>>RELACIONES DE LA CLASE
//>>FIN RELACIONES DE LA CLASE

//>>CONTRUCTOR DE LA CLASE No.1
      line("    public "+entity.getName()+"() {");
      line("    }\n");
//>>FIN CONTRUCTOR DE LA CLASE No.1

//>>CONTRUCTOR DE LA CLASE No.2
      line("    public "+entity.getName()+"("+entity.getParameters()+") {");
      for(Atributos atributo : atributos) {
          line("        this."+atributo.getField()+" = "+atributo.getField()+";");
      }
      line("    }\n");
//>>CONTRUCTOR DE LA CLASE No.2

//>>GET Y SET id
      line("    public long getId() {");
      line("        return this.id;");
      line("    }\n");
      line("    public void setId(long id) {");
      line("        this.id = id;");
      line("    }\n");
//>>FIN GET Y SET id

//>>GET Y SET DE ATRIBUTOS
      for(Atributos atributo : atributos) {

         line("    public " + atributo.getType() + " get" + Utils._1raMay(atributo.getField()) + "() {");
         line("        return " + atributo.getField() + ";");
         line("    }");
         line("    public void set" + Utils._1raMay(atributo.getField()) + "(" + atributo.getType() + " " + Utils._1raMin(atributo.getField()) + ") {");
         line("        this." + Utils._1raMin(atributo.getField()) + " = " + Utils._1raMin(atributo.getField()) + ";");
         line("    }\n");
      } // for atributos
//>>FIN GET Y SET DE ATRIBUTOS

//>>GET Y SET RELACIONES
//>>FIN GET Y SET RELACIONES


line("} // entity"+"\n");

    } // Entity1
//>>FIN GENERACION DEL ARCHIVO

} // class


