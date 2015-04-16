package co.simasoft.gen.jpa;

import co.simasoft.utils.*;

import java.io.*;
import java.lang.*;
import java.util.*;

import java.util.HashSet;
import java.util.Set;

/****************************************************************************************************************
* CLASE : Entity2                                                                                               *
*****************************************************************************************************************

AUTOR: Nelson A Fernández Gómez                FECHA DE INICIO: MAR 27 ENE/2015   FECHA FINAL: MAR 27 ENE/2015
       SIMASOFT Bucaramanga / SAN / Colombia   FECHA DE LA ULTIMA MODIFICACION:   MAR 27 ENE/2015 HORA: 02:15 PM

OBJETIVOS:

1- Genera el archivo java correspondiente a una entidad del modelo de datos.

*---------------------------------------------------------------------------------------------------------------*
*------------------------------------------- DECLARACION DE LA CLASE -------------------------------------------*
*---------------------------------------------------------------------------------------------------------------*/

public class EntityMongo extends FileTxt {

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

2- El id es de tipo String

3- Trabaja bien en Mongo pero H2 no porque crea problemas por el id de tipo String.

*---------------------------------------------------------------------------------------------------------------*
*                                           IMPLEMENTACION DEL METODO                                           *
*---------------------------------------------------------------------------------------------------------------*/

public EntityMongo(String artifactId,String groupId,Entidad entity,LinkedHashSet<String> imports) throws IOException {

//>>INICIALIZACION DE ATRIBUTOS
      this.entity = entity;
      this.atributos = entity.getAtributos();
      this.relations = entity.getRelations();
//>>FIN INICIALIZACION DE ATRIBUTOS

//>>PAQUETE DE LA CLASE
      line("package "+groupId+";\n");
//>>FIN PAQUETE DE LA CLASE

//>>IMPORTS DE LA CLASE
      for (String impor : imports) {
         line("import "+impor+".*;");
      }
      line("");

      line("import java.util.*;\n");
      line("import javax.persistence.*;");
      line("import javax.validation.constraints.*;");
      line("import org.hibernate.annotations.GenericGenerator;\n");
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
      line("    @GeneratedValue(generator = \"uuid\")");
      line("    @GenericGenerator(name = \"uuid\", strategy = \"uuid2\")");
      line("    private String id;\n");

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
      for(Relation relation : relations) {

//********RELACION UNO A UNO
//********FIN RELACION UNO A UNO

//********RELACION MUCHOS A UNO
            if(relation.getCardinality().equals("*..1")) {
              if (relation.getFrom().equals(relation.getTo())){   // Relación Unitaria
                 line("    @ManyToOne");
                 line("    private "+relation.getTo()+" objPadre;\n");
              }
              else{
                 line("    @ManyToOne");
                 line("    private "+relation.getTo()+" "+Utils._1raMin(relation.getTo())+";\n");
              }
            }
//********RELACION MUCHOS A UNO

//********RELACION UNO A MUCHOS
            if(relation.getCardinality().equals("1..*")) {
              if(relation.getFrom().equals(relation.getTo())){  // Relación Unitaria
                line("    @OneToMany(mappedBy = \"objPadre\")");
                line("    private Set<"+relation.getTo()+"> objHijos = new HashSet<"+relation.getTo()+">();\n");
              }
              else{
                line("    @OneToMany(mappedBy = \""+Utils._1raMin(entity.getName())+"\")");
                line("    private Set<"+relation.getTo()+"> "+Utils._1raMin(relation.getTo())+" = new HashSet<"+relation.getTo()+">();\n");
              }
            }
//********FIN RELACION UNO A MUCHOS

//********RELACION MUCHOS A MUCHOS
//********FIN RELACION MUCHOS A MUCHOS

      } // for relations
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
      line("    public String getId() {");
      line("        return this.id;");
      line("    }\n");
      line("    public void setId(String id) {");
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
      for(Relation relation : relations) {

//********RELACION UNO A UNO
//********FIN RELACION UNO A UNO

//********RELACION MUCHOS A UNO
            if(relation.getCardinality().equals("*..1")) {

              if(relation.getFrom().equals(relation.getTo())){  // Relación Unitaria
                 line("    public " + relation.getTo() + " getObjPadre() {");
                 line("        return this.objPadre;");
                 line("    }");
                 line("    public void setObjPadre(" + Utils._1raMay(relation.getTo()) + " objPadre) {");
                 line("        this.objPadre = objPadre;");
                 line("    }\n");
              }
              else{
                 line("    public " + relation.getTo() + " get" + Utils._1raMay(relation.getTo()) + "() {");
                 line("        return " + Utils._1raMin(relation.getTo()) + ";");
                 line("    }");
                 line("    public void set" + Utils._1raMay(relation.getTo()) + "(" + Utils._1raMay(relation.getTo()) + " " + Utils._1raMin(relation.getTo()) + ") {");
                 line("        this." + Utils._1raMin(relation.getTo()) + " = " + Utils._1raMin(relation.getTo()) + ";");
                 line("    }\n");
              }

            }
//********RELACION MUCHOS A UNO

//********RELACION UNO A MUCHOS
            if(relation.getCardinality().equals("1..*")) {

              if(relation.getFrom().equals(relation.getTo())){  // Relación Unitaria
                 line("    public Set<" + relation.getTo() + "> getObjHijos() {");
                 line("        return this.objHijos;");
                 line("    }");
                 line("    public void setObjHijos(Set<" + Utils._1raMay(relation.getTo()) + "> objHijos) {");
                 line("        this.objHijos = objHijos;");
                 line("    }\n");
              }
              else{
                 line("    public Set<" + relation.getTo() + "> get" + Utils._1raMay(relation.getTo()) + "() {");
                 line("        return " + Utils._1raMin(relation.getTo()) + ";");
                 line("    }");
                 line("    public void set" + Utils._1raMay(relation.getTo()) + "(Set<" + Utils._1raMay(relation.getTo()) + "> " + Utils._1raMin(relation.getTo()) + ") {");
                 line("        this." + Utils._1raMin(relation.getTo()) + " = " + Utils._1raMin(relation.getTo()) + ";");
                 line("    }\n");
              }

            }
//********FIN RELACION UNO A MUCHOS

//********RELACION MUCHOS A MUCHOS
//********FIN RELACION MUCHOS A MUCHOS

      } // for relations
//>>FIN GET Y SET RELACIONES


line("} // entity"+"\n");

    } // Entity1
//>>FIN GENERACION DEL ARCHIVO

} // class


