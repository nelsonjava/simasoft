package co.simasoft.gen.rest;

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
      Integer len = 0;                                                       // Longitud del Campo
      Integer prec = 0;                                                      // Decimales del Campo
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
      String joins = Join(relations);
//>>FIN INICIALIZACION DE ATRIBUTOS

//>>PAQUETE DE LA CLASE
      line("package "+groupId+";\n");
//>>FIN PAQUETE DE LA CLASE

//>>IMPORTS DE LA CLASE
      line("import java.util.List;\n");

      line("import javax.ejb.Stateless;");
      line("import javax.persistence.EntityManager;");
      line("import javax.persistence.NoResultException;");
      line("import javax.persistence.OptimisticLockException;");
      line("import javax.persistence.PersistenceContext;");
      line("import javax.persistence.TypedQuery;");
      line("import javax.ws.rs.Consumes;");
      line("import javax.ws.rs.DELETE;");
      line("import javax.ws.rs.GET;");
      line("import javax.ws.rs.POST;");
      line("import javax.ws.rs.PUT;");
      line("import javax.ws.rs.Path;");
      line("import javax.ws.rs.PathParam;");
      line("import javax.ws.rs.Produces;");
      line("import javax.ws.rs.QueryParam;");
      line("import javax.ws.rs.core.Response;");
      line("import javax.ws.rs.core.Response.Status;");
      line("import javax.ws.rs.core.UriBuilder;");
      line("import "+entity.getGroupId()+"."+entity.getName()+";\n");
//>>FIN IMPORTS DE LA CLASE

      line("/**");
      line(" *");
      line(" */");

//>>ENDPOINT
      line("@Stateless");
      line("@Path(\"forge"+"/"+entity.getName().toLowerCase()+"\")");
      line("public class "+entity.getName()+"Endpoint {");
      line("	@PersistenceContext(unitName = \""+artifactId+"PU-JTA\")");
      line("	private EntityManager em;\n");

      line("	@POST");
      line("	@Consumes(\"application/json\")");
      line("	public Response create("+entity.getName()+" entity) {");
      line("		em.persist(entity);");
      line("		return Response.created(");
      line("				UriBuilder.fromResource("+entity.getName()+"Endpoint.class)");
      line("						.path(String.valueOf(entity.getId())).build()).build();");
      line("	}\n");

      line("	@DELETE");
      line("	@Path(\"/{id:[0-9][0-9]*}\")");
      line("	public Response deleteById(@PathParam(\"id\") Long id) {");
      line("		"+entity.getName()+" entity = em.find("+entity.getName()+".class, id);");
      line("		if (entity == null) {");
      line("			return Response.status(Status.NOT_FOUND).build();");
      line("		}");
      line("		em.remove(entity);");
      line("		return Response.noContent().build();");
      line("	}\n");

      line("	@GET");
      line("	@Path(\"/{id:[0-9][0-9]*}\")");
      line("	@Produces(\"application/json\")");
      line("	public Response findById(@PathParam(\"id\") Long id) {");
      line("		TypedQuery<"+entity.getName()+"> findByIdQuery = em");
      line("				.createQuery(");
      line("						"+"\"SELECT DISTINCT a FROM "+entity.getName()+" a "+joins+" WHERE a.id = :entityId ORDER BY a.id\""+",");
      line("						"+entity.getName()+".class);");
      line("		findByIdQuery.setParameter(\"entityId\", id);");
      line("		"+entity.getName()+" entity;");
      line("		try {");
      line("			entity = findByIdQuery.getSingleResult();");
      line("		} catch (NoResultException nre) {");
      line("			entity = null;");
      line("		}");
      line("		if (entity == null) {");
      line("			return Response.status(Status.NOT_FOUND).build();");
      line("		}");
      line("		return Response.ok(entity).build();");
      line("	}\n");

      line("	@GET");
      line("	@Produces(\"application/json\")");
      line("	public List<"+entity.getName()+"> listAll(@QueryParam(\"start\") Integer startPosition,");
      line("			@QueryParam(\"max\") Integer maxResult) {");
      line("		TypedQuery<"+entity.getName()+"> findAllQuery = em");
      line("				.createQuery(");
      line("						"+"\"SELECT DISTINCT a FROM "+entity.getName()+" a "+joins+" ORDER BY a.id\""+",");
      line("						"+entity.getName()+".class);");
      line("		if (startPosition != null) {");
      line("			findAllQuery.setFirstResult(startPosition);");
      line("		}");
      line("		if (maxResult != null) {");
      line("			findAllQuery.setMaxResults(maxResult);");
      line("		}");
      line("		final List<"+entity.getName()+"> results = findAllQuery.getResultList();");
      line("		return results;");
      line("	}\n");

      line("	@PUT");
      line("	@Path(\"/{id:[0-9][0-9]*}\")");
      line("	@Consumes(\"application/json\")");
      line("	public Response update(@PathParam(\"id\") Long id, "+entity.getName()+" entity) {");
      line("		if (entity == null) {");
      line("			return Response.status(Status.BAD_REQUEST).build();");
      line("		}");
      line("		if (id == null) {");
      line("			return Response.status(Status.BAD_REQUEST).build();");
      line("		}");
      line("		if (!id.equals(entity.getId())) {");
      line("			return Response.status(Status.CONFLICT).entity(entity).build();");
      line("		}");
      line("		if (em.find("+entity.getName()+".class, id) == null) {");
      line("			return Response.status(Status.NOT_FOUND).build();");
      line("		}");
      line("		try {");
      line("			entity = em.merge(entity);");
      line("		} catch (OptimisticLockException e) {");
      line("			return Response.status(Response.Status.CONFLICT)");
      line("					.entity(e.getEntity()).build();");
      line("		}\n");

      line("		return Response.noContent().build();");
      line("	}\n");


      line("} // EndPoint"+"\n");
//>>ENDPOINT

    } // RestEndPoint
//>>FIN GENERACION DEL ARCHIVO

/****************************************************************************************************************
* METODO..: Join                                                                             *
*****************************************************************************************************************

AUTOR: Nelson A Fernández Gómez                FECHA DE INICIO: MAR 27 ENE/2015   FECHA FINAL: MAR 27 ENE/2015
       SIMASOFT Bucaramanga / SAN / Colombia   FECHA DE LA ULTIMA MODIFICACION:   MAR 27 ENE/2015 HORA: 02:30 PM

OBJETIVOS:

1- Pendiente la documentación

*---------------------------------------------------------------------------------------------------------------*
*                                           IMPLEMENTACION DEL METODO                                           *
*---------------------------------------------------------------------------------------------------------------*/

public String Join(ArrayList<Relation> relations) {

//>>DECLARACION DE VARIABLES
      String join = "";
//>>DECLARACION DE VARIABLES

//>>RECORRIDO DE LAS RELACIONES
      for(Relation relation : relations) {

//*******ANALISIS DE LA RELACION
           if (relation.getEntityFrom().getName().equals(entity.getName())){

//============ANALISIS DE LA RELACION
                if (relation.getEntityFrom().getName().equals(relation.getEntityTo().getName())){

//-----------------RELACION UNITARIA
                     switch (relation.getCardinality()) {
                         case "1..1":
                              join += " LEFT JOIN FETCH a.objPadre";
                              break;

                         case "*..1":
                              join += " LEFT JOIN FETCH a.objPadre";
                              break;

                         case "1..*":
                              join += " LEFT JOIN FETCH a.objHijos";
                              break;

                         case "*..*":
                              join += " LEFT JOIN FETCH a.objHijos";
                              break;
                     } // switch
//-----------------FIN RELACION UNITARIA

                }
                else{
                     join += " LEFT JOIN FETCH a."+Utils._1raMin(relation.getEntityTo().getName());
                }
//============FIN RELACION UNITARIA

         }
         else{
            join += " LEFT JOIN FETCH a."+Utils._1raMin(relation.getEntityFrom().getName());

         }
//*******FIN ANALISIS DE LA RELACION

      } // for: relations
      return join;
//>>FIN RECORRIDO DE LAS RELACIONES


} // Join

} // class


