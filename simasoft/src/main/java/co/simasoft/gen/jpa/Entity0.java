package co.simasoft.gen.jpa;

import co.simasoft.utils.*;

import java.io.*;
import java.lang.*;
import java.util.*;

import java.util.HashSet;
import java.util.Set;

/****************************************************************************************************************
* CLASE : Entity0                                                                                               *
*****************************************************************************************************************

AUTOR: Nelson A Fernández Gómez                FECHA DE INICIO: MAR 27 ENE/2015   FECHA FINAL: MAR 27 ENE/2015
       SIMASOFT Bucaramanga / SAN / Colombia   FECHA DE LA ULTIMA MODIFICACION:   MAR 27 ENE/2015 HORA: 02:15 PM

OBJETIVOS:

1- Genera el archivo java correspondiente a una entidad del modelo de datos.

*---------------------------------------------------------------------------------------------------------------*
*------------------------------------------- DECLARACION DE LA CLASE -------------------------------------------*
*---------------------------------------------------------------------------------------------------------------*/

public class Entity0 extends FileTxt {

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

public Entity0(String artifactId,String groupId,Entidad entity) throws IOException {

//>>INICIALIZACION DE ATRIBUTOS
      this.entity = entity;
      this.atributos = entity.getAtributos();
      this.relations = entity.getRelations();
//>>FIN INICIALIZACION DE ATRIBUTOS

//>>PAQUETE DE LA CLASE
      line("package "+groupId+";\n");
//>>FIN PAQUETE DE LA CLASE

//>>IMPORTS DE LA CLASE
      line("import "+groupId+".*;\n");

      line("import java.util.ArrayList;");
      line("import java.util.List;\n");

      line("import javax.persistence.ElementCollection;");
      line("import javax.persistence.Entity;");
      line("import javax.persistence.GeneratedValue;");
      line("import javax.persistence.GenerationType;");
      line("import javax.persistence.Id;");
      line("import javax.persistence.ManyToOne;");
      line("import javax.persistence.OrderColumn;");
      line("import javax.validation.constraints.NotNull;\n");
//>>FIN IMPORTS DE LA CLASE

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
               line("    @NotNull");
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
              line("    private "+relation.getTo()+" "+relation.getTo().toLowerCase()+";\n");
            }
//********RELACION MUCHOS A UNO

//********RELACION UNO A MUCHOS
            if(relation.getCardinality().equals("1..*")) {
              line("    private Set<"+relation.getTo()+"> "+relation.getTo().toLowerCase()+" = new HashSet<>();\n");
            }
//********FIN RELACION UNO A MUCHOS

//********RELACION MUCHOS A MUCHOS
//********FIN RELACION MUCHOS A MUCHOS

      } // for relations
//>>FIN RELACIONES DE LA CLASE

//>>CONTRUCTOR DE LA CLASE No.1
      line("    "+entity.getName()+"() {");
      line("    }\n");
//>>FIN CONTRUCTOR DE LA CLASE No.1

//>>CONTRUCTOR DE LA CLASE No.2
      line("    "+entity.getName()+"("+entity.getParameters()+") {");
      for(Atributos atributo : atributos) {
          line("        this."+atributo.getField()+" = "+atributo.getField()+";");
      }
      line("    }\n");
//>>CONTRUCTOR DE LA CLASE No.2

//>>GET Y SET id
      line("    @Id");
      line("    @GeneratedValue(strategy = IDENTITY)");
      line("    @Column(name = \"id\", nullable=false, unique=true, length=0, precision=0, columnDefinition=\"\")");
      line("    public Long getId() {");
      line("        return this.id;");
      line("    public void setId(Long id) {");
      line("        this.id = id;");
      line("    }\n");
//>>FIN GET Y SET id

//>>GET Y SET optlock
      line("    @Version");
      line("    @Column(name = \"optlock\", nullable=true, unique=false, length=0, precision=0, columnDefinition=\"\")");
      line("    public Integer getOptlock() {");
      line("        return this.optlock;");
      line("    }");
      line("    public void setOptlock(Integer optlock) {");
      line("        this.optlock = optlock;");
      line("    }\n");
//>>FIN GET Y SET optlock

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
               line("    @ManyToOne");
               line("    public " + relation.getTo() + " get" + Utils._1raMay(relation.getTo()) + "() {");
               line("        return " + relation.getTo() + ";");
               line("    }");
               line("    public void set" + Utils._1raMay(relation.getTo()) + "(" + Utils._1raMay(relation.getTo()) + " " + Utils._1raMin(relation.getTo()) + ") {");
               line("        this." + Utils._1raMin(relation.getTo()) + " = " + Utils._1raMin(relation.getTo()) + ";");
               line("    }\n");
            }
//********RELACION MUCHOS A UNO

//********RELACION UNO A MUCHOS
            if(relation.getCardinality().equals("1..*")) {
               line("    @OneToMany");
               line("    public " + relation.getTo() + " get" + Utils._1raMay(relation.getTo()) + "() {");
               line("        return " + relation.getTo() + ";");
               line("    }");
               line("    public void set" + Utils._1raMay(relation.getTo()) + "(" + Utils._1raMay(relation.getTo()) + " " + Utils._1raMin(relation.getTo()) + ") {");
               line("        this." + Utils._1raMin(relation.getTo()) + " = " + Utils._1raMin(relation.getTo()) + ";");
               line("    }\n");
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


