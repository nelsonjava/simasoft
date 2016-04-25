package co.simasoft.persistence.sqlite.django;

import co.simasoft.utils.*;

import java.io.*;
import java.lang.*;
import java.util.*;

import java.util.HashSet;
import java.util.Set;

/****************************************************************************************************************
* CLASE : EntitySqliteDjango                                                                                    *
*****************************************************************************************************************

AUTOR: Nelson A Fernández Gómez                FECHA DE INICIO: MIE 24 MAR/2016   FECHA FINAL: MIE 24 MAR/2016
       SIMASOFT Bucaramanga / SAN / Colombia   FECHA DE LA ULTIMA MODIFICACION:   MIE 24 MAR/2016 HORA: 11:00 AM

OBJETIVOS:

1- Genera el archivo python correspondiente a una entidad del modelo de datos.

*---------------------------------------------------------------------------------------------------------------*
*------------------------------------------- DECLARACION DE LA CLASE -------------------------------------------*
*---------------------------------------------------------------------------------------------------------------*/

public class EntitySqliteDjango extends FileTxt {

//>>DECLARACION DE INSTANCIAS
      private Entidad entity = new Entidad();                                // Entidad
      private ArrayList<Atributos> atributos = new ArrayList<Atributos>();   // Atributos de la Entidad
      private ArrayList<Relation> relations = new ArrayList<Relation>();     // Relaciones de la Entidad

      Integer nro = 4;                                                       // Número de Espacios de Margen
      String name = "";                                                      // Nombre del Atributo
      String type = "";                                                      // Tipo del Atributo
      String field = "";                                                     // Nombre del Campo
      Integer len = 0;                                                       // Longitud del Campo
      Integer prec = 0;                                                      // Decimales del Campo
      String annotations = "";
//>>DECLARACION DE INSTANCIAS

/****************************************************************************************************************
* METODO..: Constructor de la clase                                                                             *
*****************************************************************************************************************

AUTOR: Nelson A Fernández Gómez                FECHA DE INICIO: MIE 24 MAR/2016   FECHA FINAL: MIE 24 MAR/2016
       SIMASOFT Bucaramanga / SAN / Colombia   FECHA DE LA ULTIMA MODIFICACION:   MIE 24 MAR/2016 HORA: 11:00 AM

OBJETIVOS:

1- Inicializa los atributos de la clase, que se van a usar para construir el archivo .java del bean de entidad.

*---------------------------------------------------------------------------------------------------------------*
*                                           IMPLEMENTACION DEL METODO                                           *
*---------------------------------------------------------------------------------------------------------------*/

public EntitySqliteDjango(String artifactId,String groupId,Entidad entity,LinkedHashSet<String> imports) throws IOException {

//>>INICIALIZACION DE ATRIBUTOS
      this.entity = entity;
      this.atributos = entity.getAtributos();
      this.relations = entity.getRelations();
//>>FIN INICIALIZACION DE ATRIBUTOS

//>>DECLARACION DE LA CLASE
      line("class "+entity.getName()+"(models.Model):");
//>>FIN DECLARACION DE LA CLASE

//>>DECLARACION DE ATRIBUTOS
      for (Atributos attribute : atributos) {

          name  = attribute.getField();
          type  = attribute.getTypeDjango();

          line("    "+name+" = models."+type);
      } // for atributos
//>>DECLARACION DE ATRIBUTOS

//>>DECLARACION DE RELACIONES
      line("");
      for(Relation relation : relations) {

//********RELACION UNO A UNO
//********FIN RELACION UNO A UNO

//********RELACION MUCHOS A UNO
            if(relation.getCardinality().equals("*..1")) {
              if (relation.getFrom().equals(relation.getTo())){   // Relación Unitaria
//                 line("# ManyToOne "+relation.getTo()+" objPadre;\n");
              }
              else{
                 if(relation.getName() == null || relation.getName() == ""){
                   if (entity.getName().equals(relation.getFrom())){
//                      line("# @ManyToOne "+relation.getTo()+" "+Utils._1raMin(relation.getTo())+";\n");
                   }
                   else{
//                      line("# ManyToOne inversa1 "+relation.getFrom()+" "+Utils._1raMin(relation.getFrom())+";\n");
                      line("    "+Utils._1raMin(relation.getFrom())+" = models.ForeignKey("+relation.getFrom()+")");
                      // relación inversa.
                   }
                 }
                 else{
                   if (entity.getName().equals(relation.getFrom())){
//                      line("# ManyToOne "+ relation.getTo() +" "+ relation.getName()+";\n");
                   }
                   else{
//                      line("# ManyToOne inversa2 "+ relation.getFrom() +" "+ relation.getName()+";\n");
                      // relación inversa.
                   }
                 }
              }
            }
//********RELACION MUCHOS A UNO

//********RELACION UNO A MUCHOS
            if(relation.getCardinality().equals("1..*")) {
              if(relation.getFrom().equals(relation.getTo())){  // Relación Unitaria
//                line("# OneToMany(mappedBy = \"objPadre\")");
              }
              else{
                if(relation.getName() == null || relation.getName() == ""){
//                  line("#    @OneToMany(mappedBy = \""+Utils._1raMin(entity.getName())+"\")");
//                  line("#    private Set<"+relation.getTo()+"> "+Utils._1raMin(relation.getTo())+" = new HashSet<"+relation.getTo()+">();\n");
                }
                else{
//                  line("#    @OneToMany(mappedBy = \""+relation.getName()+"\")");
//                  line("#    private Set<"+relation.getTo()+"> "+relation.getName()+" = new HashSet<"+relation.getTo()+">();\n");
                }
              }
            }
//********FIN RELACION UNO A MUCHOS

//********RELACION MUCHOS A MUCHOS
            if(relation.getCardinality().equals("*..*")) {
              if(relation.getFrom().equals(relation.getTo())){  // Relación Unitaria
//                line("#    @ManyToMany(mappedBy = \"objPadre\")");
//                line("#    private Set<"+relation.getTo()+"> objHijos = new HashSet<"+relation.getTo()+">();\n");
              }
              else{
                if(relation.getName() == null || relation.getName() == ""){
                   if(relation.getUnidireccional()){
//                     line("#    @ManyToMany");
                   }
                   else{
//                     line("#    @ManyToMany(mappedBy = \""+Utils._1raMin(entity.getName())+"\")");
                   }

                   if (entity.getName().equals(relation.getFrom())){
//                      line("#    private Set<"+relation.getTo()+"> "+Utils._1raMin(relation.getTo())+" = new HashSet<"+relation.getTo()+">();\n");
                   }
                   else{ // relación inversa
//                     line("#    private Set<"+relation.getFrom()+"> "+Utils._1raMin(relation.getFrom())+" = new HashSet<"+relation.getFrom()+">();\n");
                   }
                }
                else{

                   if(relation.getUnidireccional()){
//                     line("#    @ManyToMany()");
                   }
                   else{
//                     line("#    @ManyToMany(mappedBy = \""+Utils._1raMin(entity.getName())+"\")");
                   }

                   if (entity.getName().equals(relation.getFrom())){
//                      line("#    private Set<"+relation.getTo()+"> "+relation.getName()+" = new HashSet<"+relation.getTo()+">();\n");
                   }
                   else{
//                      line("#    private Set<"+relation.getFrom()+"> "+relation.getName()+" = new HashSet<"+relation.getFrom()+">();\n");
                      // Relación inversa.
                   }

                }
              }
            }

//********FIN RELACION MUCHOS A MUCHOS

      } // for relations
//>>FIN DECLARACION DE RELACIONES

      line("");
      line("    def __str__(self):");
      line("        return self.id");

      line("    class Meta:");
      line("        ordering = ('id',)\n");


















    } // Entity1
//>>FIN GENERACION DEL ARCHIVO

} // class


