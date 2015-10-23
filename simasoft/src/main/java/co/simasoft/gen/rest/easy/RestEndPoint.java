package co.simasoft.gen.jpa;

import co.simasoft.utils.*;

import java.io.*;
import java.lang.*;
import java.util.*;

import java.util.HashSet;
import java.util.Set;

/****************************************************************************************************************
* CLASE : RestEndPoint                                                                                          *
*****************************************************************************************************************

AUTOR: NAIFG                                   FECHA DE INICIO: VIE 23 OCT/2015   FECHA FINAL: VIE 23 ENE/2016
       SIMASOFT Bucaramanga / SAN / Colombia   FECHA DE LA ULTIMA MODIFICACION:   VIE 23 OCT/2015 HORA: 14:30 PM

OBJETIVOS:

1- Genera el archivo java correspondiente a una entidad del modelo de datos.

2- El id es de tipo long

3- Trabaja bien en H2.

*---------------------------------------------------------------------------------------------------------------*
*------------------------------------------- DECLARACION DE LA CLASE -------------------------------------------*
*---------------------------------------------------------------------------------------------------------------*/

public class RestEndPoint extends FileTxt {

//>>DECLARACION DE INSTANCIAS
      private Entidad entity = new Entidad();                                // Entidad
      private ArrayList<Atributos> atributos = new ArrayList<Atributos>();   // Atributos de la Entidad
      private ArrayList<Relation> relations = new ArrayList<Relation>();     // Relaciones de la Entidad

      Integer nro = 4;                                                       // Número de Espacios de Margen
      String name = "";                                                      // Nombre del Atributo
      String type = "";                                                      // Tipo del Atributo
      String field = "";                                                     // Nombre del Campo
      Integer len = 0;                                                           // Longitud del Campo
      Integer prec = 0;                                                          // Decimales del Campo
      String annotations = "";
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

public RestEndPoint(String artifactId,String groupId,Entidad entity,LinkedHashSet<String> imports) throws IOException {

//>>INICIALIZACION DE ATRIBUTOS
      this.entity = entity;
      this.atributos = entity.getAtributos();
      this.relations = entity.getRelations();
//>>FIN INICIALIZACION DE ATRIBUTOS

//>>PAQUETE DE LA CLASE
      line("package "+groupId+";\n");
//>>FIN PAQUETE DE LA CLASE

//>>IMPORTS DE LA CLASE
      line("import java.util.ArrayList;");
      line("import java.util.List;\n");

      line("import org.w3c.dom.Document;");
      line("import org.w3c.dom.Element;");
      line("import org.w3c.dom.NodeList;\n");

      line("import javax.persistence.EntityManager;");
      line("import javax.persistence.NoResultException;");
      line("import javax.persistence.OptimisticLockException;");
      line("import javax.persistence.PersistenceContext;");
      line("import javax.persistence.TypedQuery;\n");

      line("import javax.ws.rs.Consumes;");
      line("import javax.ws.rs.DELETE;");
      line("import javax.ws.rs.GET;");
      line("import javax.ws.rs.POST;");
      line("import javax.ws.rs.PUT;");
      line("import javax.ws.rs.Path;");
      line("import javax.ws.rs.PathParam;");
      line("import javax.ws.rs.Produces;");
      line("import javax.ws.rs.QueryParam;");
      line("import javax.ws.rs.WebApplicationException;\n");

      line("import javax.ws.rs.core.Response;");
      line("import javax.ws.rs.core.Response.Status;");
      line("import javax.ws.rs.core.UriBuilder;");
      line("import javax.ws.rs.core.StreamingOutput;\n");

      line("import javax.xml.parsers.DocumentBuilder;");
      line("import javax.xml.parsers.DocumentBuilderFactory;\n");

      for (String impor : imports) {
         line(impor);
      }
      line("\n");
//>>FIN IMPORTS DE LA CLASE

//>>ENDPOINT
      line("@Stateless");
      line("@Path(\""+artifactId.toLowerCase()+"/"+entity.getName().toLowerCase()+"\")");
      line("public class "+entity.getName()+"EndPoint {\n");

      line("   @GET");
      line("   @Produces(\"application/json\")");
      line("   public List<PerformanceDTO> listAll(@QueryParam(\"start\") Integer startPosition, @QueryParam(\"max\") Integer maxResult){");
      line("      TypedQuery<Performance> findAllQuery = em.createQuery(\"SELECT DISTINCT p FROM Performance p LEFT JOIN FETCH p.show ORDER BY p.id\", Performance.class);");
      line("      if (startPosition != null){");
      line("         findAllQuery.setFirstResult(startPosition);");
      line("      }");
      line("      if (maxResult != null){");
      line("         findAllQuery.setMaxResults(maxResult);");
      line("      }");
      line("      final List<Performance> searchResults = findAllQuery.getResultList();");
      line("      final List<PerformanceDTO> results = new ArrayList<PerformanceDTO>();");
      line("      for (Performance searchResult : searchResults){");
      line("         PerformanceDTO dto = new PerformanceDTO(searchResult);");
      line("         results.add(dto);");
      line("      }");
      line("      return results;");
      line("   }");

      line("} // EndPoint"+"\n");
//>>ENDPOINT

    } // RestEndPoint
//>>FIN GENERACION DEL ARCHIVO

} // class


