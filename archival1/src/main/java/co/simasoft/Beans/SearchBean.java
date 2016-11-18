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

    @PersistenceContext(unitName = "archivalPU-JTA")
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

    public List<SectionsTypes> selectAllSectionsTypes(EntityManager em) {
        prepare(SectionsTypes.class,em);

        Query query = qb.all().createQuery();

        List<SectionsTypes> results = execute(query,
                                              new Class[]{SectionsTypes.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<FrequentlyQuery> selectAllFrequentlyQuery(EntityManager em) {
        prepare(FrequentlyQuery.class,em);

        Query query = qb.all().createQuery();

        List<FrequentlyQuery> results = execute(query,
                                              new Class[]{FrequentlyQuery.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<Series> selectAllSeries(EntityManager em) {
        prepare(Series.class,em);

        Query query = qb.all().createQuery();

        List<Series> results = execute(query,
                                              new Class[]{Series.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<Funds> selectAllFunds(EntityManager em) {
        prepare(Funds.class,em);

        Query query = qb.all().createQuery();

        List<Funds> results = execute(query,
                                              new Class[]{Funds.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<Sections> selectAllSections(EntityManager em) {
        prepare(Sections.class,em);

        Query query = qb.all().createQuery();

        List<Sections> results = execute(query,
                                              new Class[]{Sections.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<DocumentalsUnits> selectAllDocumentalsUnits(EntityManager em) {
        prepare(DocumentalsUnits.class,em);

        Query query = qb.all().createQuery();

        List<DocumentalsUnits> results = execute(query,
                                              new Class[]{DocumentalsUnits.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<DocumentalsSupports> selectAllDocumentalsSupports(EntityManager em) {
        prepare(DocumentalsSupports.class,em);

        Query query = qb.all().createQuery();

        List<DocumentalsSupports> results = execute(query,
                                              new Class[]{DocumentalsSupports.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<InventoryFinality> selectAllInventoryFinality(EntityManager em) {
        prepare(InventoryFinality.class,em);

        Query query = qb.all().createQuery();

        List<InventoryFinality> results = execute(query,
                                              new Class[]{InventoryFinality.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<ConservationUnits> selectAllConservationUnits(EntityManager em) {
        prepare(ConservationUnits.class,em);

        Query query = qb.all().createQuery();

        List<ConservationUnits> results = execute(query,
                                              new Class[]{ConservationUnits.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<DocumentalRetention> selectAllDocumentalRetention(EntityManager em) {
        prepare(DocumentalRetention.class,em);

        Query query = qb.all().createQuery();

        List<DocumentalRetention> results = execute(query,
                                              new Class[]{DocumentalRetention.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<DocumentalInventory> selectAllDocumentalInventory(EntityManager em) {
        prepare(DocumentalInventory.class,em);

        Query query = qb.all().createQuery();

        List<DocumentalInventory> results = execute(query,
                                              new Class[]{DocumentalInventory.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<FundsLife> selectAllFundsLife(EntityManager em) {
        prepare(FundsLife.class,em);

        Query query = qb.all().createQuery();

        List<FundsLife> results = execute(query,
                                              new Class[]{FundsLife.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<FinalDisposition> selectAllFinalDisposition(EntityManager em) {
        prepare(FinalDisposition.class,em);

        Query query = qb.all().createQuery();

        List<FinalDisposition> results = execute(query,
                                              new Class[]{FinalDisposition.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<ConservationUnitsTypes> selectAllConservationUnitsTypes(EntityManager em) {
        prepare(ConservationUnitsTypes.class,em);

        Query query = qb.all().createQuery();

        List<ConservationUnitsTypes> results = execute(query,
                                              new Class[]{ConservationUnitsTypes.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<OriginalOrder> selectAllOriginalOrder(EntityManager em) {
        prepare(OriginalOrder.class,em);

        Query query = qb.all().createQuery();

        List<OriginalOrder> results = execute(query,
                                              new Class[]{OriginalOrder.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

} // Fin de clase
