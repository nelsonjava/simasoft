package co.simasoft.beans;

import co.simasoft.models.naif.task.activities.*;

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

    @PersistenceContext(unitName = "taskPU-JTA")
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

    public List<Calendars> selectAllCalendars(EntityManager em) {
        prepare(Calendars.class,em);

        Query query = qb.all().createQuery();

        List<Calendars> results = execute(query,
                                              new Class[]{Calendars.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<ActivitiesTypes> selectAllActivitiesTypes(EntityManager em) {
        prepare(ActivitiesTypes.class,em);

        Query query = qb.all().createQuery();

        List<ActivitiesTypes> results = execute(query,
                                              new Class[]{ActivitiesTypes.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<Tasks> selectAllTasks(EntityManager em) {
        prepare(Tasks.class,em);

        Query query = qb.all().createQuery();

        List<Tasks> results = execute(query,
                                              new Class[]{Tasks.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<Guides> selectAllGuides(EntityManager em) {
        prepare(Guides.class,em);

        Query query = qb.all().createQuery();

        List<Guides> results = execute(query,
                                              new Class[]{Guides.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<Diaries> selectAllDiaries(EntityManager em) {
        prepare(Diaries.class,em);

        Query query = qb.all().createQuery();

        List<Diaries> results = execute(query,
                                              new Class[]{Diaries.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<Activities> selectAllActivities(EntityManager em) {
        prepare(Activities.class,em);

        Query query = qb.all().createQuery();

        List<Activities> results = execute(query,
                                              new Class[]{Activities.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

} // Fin de clase
