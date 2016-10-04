package co.simasoft.beans;

import co.simasoft.models.*;

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
public class SearchBean {

    @PersistenceContext(unitName = "pruebasPU-JTA")
    private EntityManager em;

    private QueryBuilder qb;
    private FullTextEntityManager fTEM;

    /**
     * Initializes the objects required for an Hibernate Search/Apache Lucene Query.
     *
     * @param entityClass Entity type used for data retrieval during query creation.
     */
    private void prepare(Class<?> entityClass, EntityManager em) {
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

    public List<Employees> selectAllEmployees(EntityManager em) {
        prepare(Employees.class,em);

        Query query = qb.all().createQuery();

        List<Employees> results = execute(query,
                                              new Class[]{Employees.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<Predio> selectAllPredio(EntityManager em) {
        prepare(Predio.class,em);

        Query query = qb.all().createQuery();

        List<Predio> results = execute(query,
                                              new Class[]{Predio.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<PhysicalSpaces> selectAllPhysicalSpaces(EntityManager em) {
        prepare(PhysicalSpaces.class,em);

        Query query = qb.all().createQuery();

        List<PhysicalSpaces> results = execute(query,
                                              new Class[]{PhysicalSpaces.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<PhysicalSpacesTypes> selectAllPhysicalSpacesTypes(EntityManager em) {
        prepare(PhysicalSpacesTypes.class,em);

        Query query = qb.all().createQuery();

        List<PhysicalSpacesTypes> results = execute(query,
                                              new Class[]{PhysicalSpacesTypes.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<PhysicalAreas> selectAllPhysicalAreas(EntityManager em) {
        prepare(PhysicalAreas.class,em);

        Query query = qb.all().createQuery();

        List<PhysicalAreas> results = execute(query,
                                              new Class[]{PhysicalAreas.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<PhysicalAreasTypes> selectAllPhysicalAreasTypes(EntityManager em) {
        prepare(PhysicalAreasTypes.class,em);

        Query query = qb.all().createQuery();

        List<PhysicalAreasTypes> results = execute(query,
                                              new Class[]{PhysicalAreasTypes.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

} // Fin de clase
