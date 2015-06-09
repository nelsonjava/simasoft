package co.simasoft.gen.war.h2;

import co.simasoft.utils.*;

import java.io.*;
import java.lang.*;
import java.util.*;

import java.util.HashSet;
import java.util.Set;

public class H2Search extends FileTxt {

  public H2Search(String artifactId,String groupId) {

line("package co.simasoft.beans;\n");

line("import co.simasoft.models.naif.domainmodels.*;\n");

line("import java.util.Calendar;");
line("import java.util.HashMap;");
line("import java.util.List;");
line("import java.util.Map;");
line("import java.util.Random;");
line("import java.util.StringTokenizer;\n");

line("import javax.ejb.LocalBean;");
line("import javax.ejb.Stateless;");
line("import javax.persistence.EntityManager;");
line("import javax.persistence.LockModeType;");
line("import javax.persistence.OptimisticLockException;");
line("import javax.persistence.PersistenceContext;\n");

line("import org.apache.lucene.search.NumericRangeQuery;");
line("import org.apache.lucene.search.Query;");
line("import org.apache.lucene.search.Sort;");
line("import org.apache.lucene.search.SortField;\n");

line("import org.hibernate.search.jpa.FullTextEntityManager;");
line("import org.hibernate.search.jpa.FullTextQuery;");
line("import org.hibernate.search.jpa.Search;");
line("import org.hibernate.search.query.DatabaseRetrievalMethod;");
line("import org.hibernate.search.query.ObjectLookupMethod;");
line("import org.hibernate.search.query.dsl.QueryBuilder;\n");

line("@Stateless");
line("@LocalBean");
line("public class "+Utils._1raMay(artifactId)+"Bean {\n");

line("    @PersistenceContext(unitName = \""+artifactId+"PU-JTA\")");
line("    private EntityManager em;\n");

line("    private QueryBuilder qb;");
line("    private FullTextEntityManager fTEM;\n");

line("    /**");
line("     * Initializes the objects required for an Hibernate Search/Apache Lucene Query.");
line("     *");
line("     * @param entityClass Entity type used for data retrieval during query creation.");
line("     */");
line("    private void prepare(Class<?> entityClass) {");
line("        if (entityClass == null) {");
line("            throw new NullPointerException(\"Entity class(.class type) is null.\");");
line("        }\n");

line("        if (fTEM == null) {");
line("            fTEM = Search.getFullTextEntityManager(em);");
line("        }");
line("        qb = fTEM.getSearchFactory().buildQueryBuilder().forEntity(entityClass).get();");
line("    } // end : prepare Method\n");

line("    /**");
line("     * Finishes the Hibernate Search Query wrap-up, and begins execution.");
line("     *");
line("     * @param query Hibernate search/Apache Lucene query.");
line("     * @param entityClasses Entity types that will be returned by the query.");
line("     * @param projectionWith Entity fields to be projected with the query.");
line("     * @param sortByThisField Field used to order the query results.");
line("     * @return A untyped list of the results.");
line("     */");
line("    private List execute(Query query,");
line("                         Class<?>[] entityClasses,");
line("                         String[] projectionWith,");
line("                         SortField sortByThisField) {");
line("        if (query == null) {");
line("            throw new NullPointerException(\"Lucene query object is null.\");");
line("        }");
line("        if ( (entityClasses == null) || (entityClasses.length == 0) ) {");
line("            throw new NullPointerException(\"There must be at least one entity class(.class type).\");");
line("        }\n");

line("        FullTextQuery fTQ = fTEM.createFullTextQuery(query, entityClasses);\n");

line("        if (projectionWith != null) {");
line("            fTQ.setProjection(projectionWith);");
line("        }");
line("        if (sortByThisField != null) {");
line("            fTQ.setSort(new Sort(sortByThisField));");
line("        }\n");

line("        fTQ.initializeObjectsWith(ObjectLookupMethod.SKIP, DatabaseRetrievalMethod.FIND_BY_ID);");
line("        return fTQ.getResultList();");
line("    } // end : execute Method\n");


line("    // QUERIES //\n");

line("} // Fin de clase");

  } // Contructor

} // Claas