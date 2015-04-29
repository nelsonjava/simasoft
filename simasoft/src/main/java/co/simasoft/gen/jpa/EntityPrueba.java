package co.simasoft.gen.jpa;

import co.simasoft.utils.*;

import java.io.*;
import java.lang.*;
import java.util.*;

import java.util.HashSet;
import java.util.Set;

/****************************************************************************************************************
* CLASE : EntityH2                                                                                              *
*****************************************************************************************************************

AUTOR: Nelson A Fernández Gómez                FECHA DE INICIO: MAR 27 ENE/2015   FECHA FINAL: MAR 27 ENE/2015
       SIMASOFT Bucaramanga / SAN / Colombia   FECHA DE LA ULTIMA MODIFICACION:   MAR 27 ENE/2015 HORA: 02:15 PM

OBJETIVOS:

1- Genera el archivo java correspondiente a una entidad del modelo de datos.

2- El id es de tipo long

3- Trabaja bien en H2.

*---------------------------------------------------------------------------------------------------------------*
*------------------------------------------- DECLARACION DE LA CLASE -------------------------------------------*
*---------------------------------------------------------------------------------------------------------------*/

public class EntityPrueba extends FileTxt {

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

public EntityPrueba(String artifactId,String groupId,Entidad entity,LinkedHashSet<String> imports) throws IOException {

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

      line("import java.io.*;");
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
      line("public class "+entity.getName()+" implements Serializable {\n");
//>>FIN DECLARACION DE LA CLASE

//>>ATTRIBUTOS POR DEFECTO
      line("    private static final long serialVersionUID = 1L;\n");

      line("    @Id");
      line("    @GeneratedValue(strategy=GenerationType.TABLE)");
      line("    private Long id;\n");

      line("    @Version");
      line("    private Integer optlock;\n");

      line("    private String name;");
      line("    private Integer valor;\n");
//>>FIN ATTRIBUTOS POR DEFECTO

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
                 if(relation.getName() == null || relation.getName() == ""){
                   line("    private "+relation.getTo()+" "+Utils._1raMin(relation.getTo())+";\n");
                 }
                 else{
                   line("    private "+ relation.getTo() +" "+ relation.getName()+";\n");
                 }

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
                if(relation.getName() == null || relation.getName() == ""){
                  line("    @OneToMany(mappedBy = \""+Utils._1raMin(entity.getName())+"\")");
                  line("    private Set<"+relation.getTo()+"> "+Utils._1raMin(relation.getTo())+" = new HashSet<"+relation.getTo()+">();\n");
                }
                else{
                  line("    @OneToMany(mappedBy = \""+relation.getName()+"\")");
                  line("    private Set<"+relation.getTo()+"> "+relation.getName()+" = new HashSet<"+relation.getTo()+">();\n");
                }
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

//>>GET Y SET PREDEFINIDOS
      line("    public Long getId() {");
      line("        return this.id;");
      line("    }");
      line("    public void setId(Long id) {");
      line("        this.id = id;");
      line("    }\n");

      line("    public Integer getOptlock() {");
      line("        return this.optlock;");
      line("    }");
      line("    public void setOptlock(Integer optlock) {");
      line("        this.optlock = optlock;");
      line("    }\n");

      line("	public String getName() {");
      line("        return name;");
      line("	}");
      line("	public void setName(String name) {");
      line("        this.name = name;");
      line("	}");

      line("	public Integer getValor() {");
      line("        return valor;");
      line("	}");
      line("	public void setValor(Integer valor) {");
      line("        this.valor = valor;");
      line("	}\n ");
//>>FIN GET Y SET PREDEFINIDOS

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
                 if(relation.getName() == null || relation.getName() == "" ){
                    line("    public " + relation.getTo() + " get" + Utils._1raMay(relation.getTo()) + "() {");
                    line("        return " + Utils._1raMin(relation.getTo()) + ";");
                    line("    }");
                    line("    public void set" + Utils._1raMay(relation.getTo()) + "(" + Utils._1raMay(relation.getTo()) + " " + Utils._1raMin(relation.getTo()) + ") {");
                    line("        this." + Utils._1raMin(relation.getTo()) + " = " + Utils._1raMin(relation.getTo()) + ";");
                    line("    }\n");
                 }
                 else{
                    line("    public " + relation.getTo() + " get" + Utils._1raMay(relation.getName()) + "() {");
                    line("        return " + relation.getName() + ";");
                    line("    }");
                    line("    public void set" + Utils._1raMay(relation.getName()) + "(" + Utils._1raMay(relation.getTo()) + " " + relation.getName() + ") {");
                    line("        this." + relation.getName() + " = " + relation.getName() + ";");
                    line("    }\n");
                 }
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
                 if(relation.getName() == null || relation.getName() == "") {
                   line("    public Set<" + relation.getTo() + "> get" + Utils._1raMay(relation.getTo()) + "() {");
                   line("        return " + Utils._1raMin(relation.getTo()) + ";");
                   line("    }");
                   line("    public void set" + Utils._1raMay(relation.getTo()) + "(Set<" + Utils._1raMay(relation.getTo()) + "> " + Utils._1raMin(relation.getTo()) + ") {");
                   line("        this." + Utils._1raMin(relation.getTo()) + " = " + Utils._1raMin(relation.getTo()) + ";");
                   line("    }\n");
                 }
                 else{
                   line("    public Set<" + relation.getTo() + "> get" + Utils._1raMay(relation.getName()) + "() {");
                   line("        return " + relation.getName() + ";");
                   line("    }");
                   line("    public void set" + Utils._1raMay(relation.getName()) + "(Set<" + Utils._1raMay(relation.getTo()) + "> " + relation.getName() + ") {");
                   line("        this." + relation.getName() + " = " + relation.getName() + ";");
                   line("    }\n");
                 }

              }

            }
//********FIN RELACION UNO A MUCHOS

//********RELACION MUCHOS A MUCHOS
//********FIN RELACION MUCHOS A MUCHOS

      } // for relations
//>>FIN GET Y SET RELACIONES

//>>HASHCODE
      line("   @Override");
      line("   public int hashCode() {");
      line("      final int prime  = 31;");
      line("            int result =  1;\n");

      line("      result = prime * result + ((id == null) ? 0 : id.hashCode());\n");

      line("      return result;");
      line("   }\n");
//>>FIN HASHCODE

//>>EQUALS
      line("   @Override");
      line("   public boolean equals(Object ojt) {");
      line("      if (      this == ojt           ) return true;");
      line("      if (       ojt == null          ) return false;");
      line("      if (getClass() != ojt.getClass()) return false;\n");

      line("      "+entity.getName()+" other = ("+entity.getName()+") ojt;");
      line("      if (id == null) {");
      line("         if (other.id != null) {");
      line("            return false;");
      line("         }");
      line("      } else {");
      line("         if (!id.equals(other.id)) {");
      line("            return false;");
      line("         }");
      line("      }\n");

      line("      return true;");
      line("   }\n");
//>>FIN EQUALS


line("} // entity"+"\n");

    } // Entity1
//>>FIN GENERACION DEL ARCHIVO

} // class


