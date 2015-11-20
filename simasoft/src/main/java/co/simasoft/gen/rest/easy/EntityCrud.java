package co.simasoft.gen.rest;

import co.simasoft.utils.*;

import java.io.*;
import java.lang.*;
import java.util.*;

import java.util.HashSet;
import java.util.Set;

/****************************************************************************************************************
* CLASE : EntityCrud                                                                                          *
*****************************************************************************************************************

AUTOR: NAIFG                                   FECHA DE INICIO: VIE 20 NOV/2015   FECHA FINAL: VIE 20 NOV/2015
       SIMASOFT Bucaramanga / SAN / Colombia   FECHA DE LA ULTIMA MODIFICACION:   VIE 20 NOV/2015 HORA: 08:50 AM

OBJETIVOS:

1- Genera el archivo java correspondiente a

2-

3-

*---------------------------------------------------------------------------------------------------------------*
*------------------------------------------- DECLARACION DE LA CLASE -------------------------------------------*
*---------------------------------------------------------------------------------------------------------------*/

public class EntityCrud extends FileTxt {

//>>DECLARACION DE INSTANCIAS
//>>FIN DECLARACION DE INSTANCIAS

/****************************************************************************************************************
* METODO..: Constructor de la clase                                                                             *
*****************************************************************************************************************

AUTOR: NAIFG                                   FECHA DE INICIO: VIE 20 NOV/2015   FECHA FINAL: VIE 20 NOV/2015
       SIMASOFT Bucaramanga / SAN / Colombia   FECHA DE LA ULTIMA MODIFICACION:   VIE 20 NOV/2015 HORA: 08:55 AM

OBJETIVOS:

1-

*---------------------------------------------------------------------------------------------------------------*
*                                           IMPLEMENTACION DEL METODO                                           *
*---------------------------------------------------------------------------------------------------------------*/

public EntityCrud() throws IOException {

line("package co.simasoft.services;\n");

line("import java.util.List;\n");

line("import javax.ejb.Stateless;");
line("import javax.persistence.EntityManager;");
line("import javax.persistence.NoResultException;");
line("import javax.persistence.PersistenceContext;\n");

line("@Stateless");
line("public class EntityCrud<T> {\n");

line("    @PersistenceContext(unitName = \"tasksPU-JTA\")");
line("    private EntityManager em;\n");

line("    // ----------------- CRUD OPERATIONS ----------------- //\n");

line("    public void create(T entity) {\n");

line("        em.persist(entity);");
line("        em.flush();");
line("    } // end : create Method\n");

line("    public T retrieveOne(long id, Class<T> classType) {\n");

line("        String entityName;");
line("        String query;");
line("        List<T> results;");
line("        T entityFound = null;\n");

line("        if (classType == null) {");
line("            throw new NullPointerException(\"Please specify a class type(AnEntity.class).\");");
line("        }\n");

line("        entityName = classType.getSimpleName();");
line("        query = \"SELECT o FROM \" + entityName + \" o WHERE o.id LIKE :reqId\";");
line("        results = em.createQuery(query)");
line("                                 .setParameter(\"reqId\", id)");
line("                                 .getResultList();\n");

line("        if (!results.isEmpty()) {");
line("           entityFound = results.get(0);");
line("        }\n");

line("        return entityFound;");
line("    } // end : retrieveOne Method\n");

line("    public List<T> retrieveAll(int start,int size,String orderBy,Class<T> classType) throws Exception {\n");

line("        String entityName;");
line("        String query;\n");

line("        if (classType == null) {");
line("            throw new NullPointerException(\"Please specify a class type(AnEntity.class).\");");
line("        }\n");

line("        if ( (start < 0) || (size < 1) ) {");
line("        	 throw new IllegalArgumentException(\"Numeric parameters must be possitive.\");");
line("        }\n");

line("        entityName  = classType.getSimpleName();");
line("        query = \"SELECT o FROM \" + entityName + \" o\";\n");

line("        if ( (orderBy != null) && (!orderBy.equals(\"none\")) ) {");
line("            query += \" ORDER BY o.\" + orderBy;");
line("        }\n");

line("        return em.createQuery(query)");
line("                 .setFirstResult(start)");
line("                 .setMaxResults(size)");
line("                 .getResultList();");
line("    } // end : retrieveAll Method\n");

line("    public T update(T entity) {");
line("        return em.merge(entity);");
line("    } // end : update Method\n");

line("    public void delete(long id, Class<T> classType) {\n");

line("        if (classType == null) {");
line("            throw new NullPointerException(\"Please specify a class type(AnEntity.class).\");");
line("        }\n");

line("        T entity = (T) em.find(classType, id);\n");

line("        if (entity == null) {");
line("            throw new NoResultException(\"Record not found.\");");
line("        }\n");

line("        em.remove(entity);");
line("	} // end : delete Method\n");

line("	public void delete(T entity) {");
line("	    em.remove(entity);");
line("	} // end : delete Method\n");

line("}\n");

} // Constructor


} // class