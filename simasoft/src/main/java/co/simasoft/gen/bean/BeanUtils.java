package co.simasoft.gen.bean;

import co.simasoft.utils.*;

import java.io.*;
import java.lang.*;
import java.util.*;

import java.util.HashSet;
import java.util.Set;

/****************************************************************************************************************
* CLASE : ViewUtils                                                                                             *
*****************************************************************************************************************

AUTOR: NAIF                                    FECHA DE INICIO: JUE 12 MAR/2015   FECHA FINAL: JUE 12 MAR/2015
       SIMASOFT Bucaramanga / SAN / Colombia   FECHA DE LA ULTIMA MODIFICACION:   JUE 12 ENE/2015 HORA: 09:15 AM

OBJETIVOS:

1- Genera el archivo ViewUtils.java clase necesaria para el CRUD de las Entidades

2- El id es de tipo long

3- Trabaja bien en H2.

*---------------------------------------------------------------------------------------------------------------*
*------------------------------------------- DECLARACION DE LA CLASE -------------------------------------------*
*---------------------------------------------------------------------------------------------------------------*/

public class BeanUtils extends FileTxt {

//>>DECLARACION DE INSTANCIAS
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

public BeanUtils(String artifactId,String groupId,ArrayList<String> imports) throws IOException {

line("package co.simasoft.view;\n");

line("import java.beans.PropertyDescriptor;");
line("import java.lang.reflect.Field;");
line("import java.lang.reflect.Method;");
line("import java.util.ArrayList;");
line("import java.util.Collection;");
line("import java.util.List;");
line("import javax.persistence.Id;\n");

line("/**");
line(" * Utilities for working with Java Server Faces views.");
line("*/\n");

line("public final class ViewUtils{\n");

line("   public static <T> List<T> asList(Collection<T> collection){\n");

line("      if (collection == null){");
line("         return null;");
line("      }");
line("      return new ArrayList<T>(collection);");
line("   }\n");

line("   public static String display(Object object){\n");

line("      if (object == null){");
line("         return null;");
line("      }\n");

line("      try{");
line("         // Invoke toString if declared in the class. If not found, the NoSuchMethodException is caught and handled");
line("         object.getClass().getDeclaredMethod(\"toString\");");
line("         return object.toString();");
line("      }\n");

line("      catch (NoSuchMethodException noMethodEx){");
line("         try{");
line("            for (Field field : object.getClass().getDeclaredFields()){");
line("               // Find the primary key field and display it");
line("               if (field.getAnnotation(Id.class) != null){");
line("                  // Find a matching getter and invoke it to display the key");
line("                  for (Method method : object.getClass().getDeclaredMethods()){");
line("                     if (method.equals(new PropertyDescriptor(field.getName(), object.getClass()).getReadMethod())){");
line("                        return method.invoke(object).toString();");
line("                     }");
line("                  }");
line("               }");
line("            }");
line("            for(Method method : object.getClass().getDeclaredMethods()){");
line("               // Find the primary key as a property instead of a field, and display it");
line("               if (method.getAnnotation(Id.class) != null){");
line("                   return method.invoke(object).toString();");
line("               }");
line("            }");
line("         } // try\n");

line("         catch (Exception ex){");
line("            // Unlikely, but abort and stop view generation if any exception is thrown");
line("            throw new RuntimeException(ex);");
line("         }");
line("      } // catch\n");

line("      return null;");
line("   }\n");

line("   private ViewUtils(){");
line("      // Can never be called");
line("   }");
line("} // ViewUtils");

  } // Constructor

} // Clase