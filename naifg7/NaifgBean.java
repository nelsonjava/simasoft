package co.simasoft.beans;

import co.simasoft.models.naif.domainmodels.*;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;

import org.apache.lucene.search.NumericRangeQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.DatabaseRetrievalMethod;
import org.hibernate.search.query.ObjectLookupMethod;
import org.hibernate.search.query.dsl.QueryBuilder;

@Stateless
@LocalBean
public class NaifgBean {

    @PersistenceContext(unitName = "naifg7PU-JTA")
    private EntityManager em;

    private QueryBuilder qb;
    private FullTextEntityManager fTEM;


    /**
     * Initializes the objects required for an Hibernate Search/Apache Lucene Query.
     *
     * @param entityClass Entity type used for data retrieval during query creation.
     */
    private void prepare(Class<?> entityClass) {
        if (entityClass == null) {
            throw new NullPointerException("Entity class(.class type) is null.");
        }

        if (fTEM == null) {
            fTEM = Search.getFullTextEntityManager(em);
        }
        qb = fTEM.getSearchFactory().buildQueryBuilder().forEntity(entityClass).get();
    } // end : prepare Method

    /**
     * Finishes the Hibernate Search Query wrap-up, and begins execution.
     *
     * @param query Hibernate search/Apache Lucene query.
     * @param entityClasses Entity types that will be returned by the query.
     * @param projectionWith Entity fields to be projected with the query.
     * @param sortByThisField Field used to order the query results.
     * @return A untyped list of the results.
     */
    private List execute(Query query,
                         Class<?>[] entityClasses,
                         String[] projectionWith,
                         SortField sortByThisField) {
        if (query == null) {
            throw new NullPointerException("Lucene query object is null.");
        }
        if ( (entityClasses == null) || (entityClasses.length == 0) ) {
            throw new NullPointerException("There must be at least one entity class(.class type).");
        }

        FullTextQuery fTQ = fTEM.createFullTextQuery(query, entityClasses);

        if (projectionWith != null) {
            fTQ.setProjection(projectionWith);
        }
        if (sortByThisField != null) {
            fTQ.setSort(new Sort(sortByThisField));
        }

        fTQ.initializeObjectsWith(ObjectLookupMethod.SKIP, DatabaseRetrievalMethod.FIND_BY_ID);
        return fTQ.getResultList();
    } // end : execute Method


    // QUERIES //

    public List<Cardinalities> selectAllCardinalities() {
        prepare(Cardinalities.class);

        Query query = qb.all().createQuery();

        List<Cardinalities> results = execute(query,
                                              new Class[]{Cardinalities.class}, null,
                                              new SortField("orden", SortField.LONG));
        return results;
    }

    public List<Dependency> selectAllDependencies() {
        prepare(Dependency.class);

        Query query = qb.all().createQuery();

        List<Dependency> results = execute(query,
                                           new Class[]{Dependency.class}, null,
                                           new SortField("orden", SortField.LONG));
        return results;
    }

    public Dependency findADependency(String dependencyToSearch) {
        prepare(Dependency.class);

        Query query = qb.keyword().onField("artifactId").matching(dependencyToSearch).createQuery();

        List<Dependency> results = execute(query, 
                                           new Class[]{Dependency.class},
                                           null, null);
        if (!results.isEmpty()) {
           return (Dependency) results.get(0);
        }
        return null;
    }

    public List<Object[]> exampleWithProjection() {
        prepare(Dependency.class);

        Query query = qb.all().createQuery();
        String[] project = {FullTextQuery.ID, "orden"};

        List<Object[]> results = execute(query,
                                         new Class[]{Dependency.class}, project,
                                         new SortField("orden", SortField.LONG));
        return results;
    }


} // END : NaifgBean : CLASS