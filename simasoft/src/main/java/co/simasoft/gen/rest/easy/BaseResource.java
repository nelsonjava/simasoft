package co.simasoft.gen.rest;

import co.simasoft.utils.*;

import java.io.*;
import java.lang.*;
import java.util.*;

import java.util.HashSet;
import java.util.Set;

/****************************************************************************************************************
* CLASE : BaseResource                                                                                          *
*****************************************************************************************************************

AUTOR: NAIFG                                   FECHA DE INICIO: VIE 20 NOV/2015   FECHA FINAL: VIE 20 NOV/2015
       SIMASOFT Bucaramanga / SAN / Colombia   FECHA DE LA ULTIMA MODIFICACION:   VIE 20 NOV/2015 HORA: 08:45 AM

OBJETIVOS:

1- Genera el archivo java correspondiente a

2-

3-

*---------------------------------------------------------------------------------------------------------------*
*------------------------------------------- DECLARACION DE LA CLASE -------------------------------------------*
*---------------------------------------------------------------------------------------------------------------*/

public class BaseResource extends FileTxt {

//>>DECLARACION DE INSTANCIAS
//>>FIN DECLARACION DE INSTANCIAS

/****************************************************************************************************************
* METODO..: Constructor de la clase                                                                             *
*****************************************************************************************************************

AUTOR: NAIFG                                   FECHA DE INICIO: VIE 20 NOV/2015   FECHA FINAL: VIE 20 NOV/2015
       SIMASOFT Bucaramanga / SAN / Colombia   FECHA DE LA ULTIMA MODIFICACION:   VIE 20 NOV/2015 HORA: 08:45 AM

OBJETIVOS:

1-

*---------------------------------------------------------------------------------------------------------------*
*                                           IMPLEMENTACION DEL METODO                                           *
*---------------------------------------------------------------------------------------------------------------*/

public BaseResource() throws IOException {

line("package co.simasoft.services;\n");

line("import java.util.List;\n");

line("import javax.inject.Inject;");
line("import javax.persistence.NoResultException;");
line("import javax.persistence.OptimisticLockException;");
line("import javax.persistence.PersistenceContext;");
line("import javax.ws.rs.Consumes;");
line("import javax.ws.rs.DefaultValue;");
line("import javax.ws.rs.DELETE;");
line("import javax.ws.rs.GET;");
line("import javax.ws.rs.POST;");
line("import javax.ws.rs.PUT;");
line("import javax.ws.rs.Path;");
line("import javax.ws.rs.PathParam;");
line("import javax.ws.rs.Produces;");
line("import javax.ws.rs.QueryParam;");
line("import javax.ws.rs.core.MediaType;");
line("import javax.ws.rs.core.Response;");
line("import javax.ws.rs.core.Response.Status;\n");

line("public abstract class BaseResource<T> {\n");

line("    @Inject");
line("    private EntityCrud<T> crud;\n");

line("    private Class<T> entityClass;\n");

line("    public BaseResource(Class<T> entityClass) {");
line("        this.entityClass = entityClass;");
line("    } // end : constructor\n");

line("    @POST");
line("    @Path(\"/create\")");
line("    @Consumes(MediaType.APPLICATION_JSON)");
line("    public Response createNewEntity(T t) {\n");

line("        if (t == null) {");
line("            return Response.status(Status.BAD_REQUEST).entity(\"There is not Record to create(null).\").build();");
line("        }\n");

line("        try {");
line("            crud.create(t);");
line("        } catch(Exception e) {");
line("            e.printStackTrace();");
line("        }\n");

line("        return Response.status(201).entity(\"New Record created successfully.\").build();");
line("    } // end : createNewEntity Method\n");

line("    @GET");
line("    @Path(\"/getOne/{id: \\\\d+}\")");
line("    @Produces(MediaType.APPLICATION_JSON)");
line("    public Response findAnEntity(@PathParam(\"id\") long id) {\n");

line("      	T entityFound = null;\n");

line("      	try {");
line("            entityFound = crud.retrieveOne(id, entityClass);");

line("         	  if (entityFound == null) {");
line("            	  return Response.status(Status.NOT_FOUND).entity(\"Record not found.\").build();");
line("         	  }");
line("      	} catch (Exception e) {");
line("            return Response.status(Status.NOT_FOUND).entity(e.getMessage()).build();");
line("      	}\n");

line("      	return Response.ok(entityFound, MediaType.APPLICATION_JSON).build();");
line("    } // end : findAnEntity Method\n");

line("    @GET");
line("    @Path(\"/get\")");
line("    @Produces(MediaType.APPLICATION_JSON)");
line("    public Response findEntities(@DefaultValue(\"0\")    @QueryParam(\"start\")   int start,");
line("                                 @DefaultValue(\"10\")   @QueryParam(\"size\")    int size,");
line("                                 @DefaultValue(\"none\") @QueryParam(\"orderBy\") String orderBy) {\n");

line("      	List<T> results;\n");

line("      	try {");
line("            results = crud.retrieveAll(start, size, orderBy, entityClass);");

line("         	  if (results.isEmpty()) {");
line("                return Response.status(Status.NOT_FOUND).entity(\"Records were not found.\").build();");
line("         	  }");
line("      	} catch (Exception e) {");
line("         	  return Response.status(Status.NOT_FOUND).entity(e.getMessage()).build();");
line("      	}\n");

line("      	return Response.ok(results, MediaType.APPLICATION_JSON).build();");
line("    } // end : findActivitiesTypes Method\n");

line("    @PUT");
line("    @Path(\"/update/{id: \\\\d+}\")");
line("    @Consumes(MediaType.APPLICATION_JSON)");
line("    public Response updateAnEntity(@PathParam(\"id\") long id, T t) {\n");

line("        T entityFound = null;\n");

line("        if (t == null) {");
line("            return Response.status(Status.BAD_REQUEST).entity(\"There is not Record to update(null).\").build();");
line("        }\n");

line("        try {");
line("            entityFound = crud.retrieveOne(id, entityClass);");

line("            if (entityFound == null) {");
line("                return Response.status(Status.NOT_FOUND).entity(\"Record not found.\").build();");
line("            }\n");

line("            entityFound = crud.update(t);");
line("        } catch (OptimisticLockException ole) {");
line("            return Response.status(Status.CONFLICT).entity(ole.getEntity()).build();");
line("        } catch (Exception e) {");
line("            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();");
line("        }\n");

line("        return Response.noContent().build();");
line("    } // end : updateAnEntity Method\n");

line("    @DELETE");
line("    @Path(\"/delete/{id: \\\\d+}\")");
line("    public Response deleteById(@PathParam(\"id\") long id) {");
line("        try {");
line("            crud.delete(id, entityClass);");
line("        } catch (NoResultException nre) {");
line("            return Response.status(Status.NOT_FOUND).entity(nre.getMessage()).build();");
line("        } catch (Exception e) {");
line("            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();");
line("        }\n");

line("        return Response.noContent().build();");
line("    } // end : deleteById Method\n");

line("}");

} // Constructor

} // class