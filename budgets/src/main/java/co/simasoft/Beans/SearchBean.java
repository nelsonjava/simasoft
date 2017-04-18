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

    @PersistenceContext(unitName = "budgetsPU-JTA")
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

    public List<Apus> selectAllApus(EntityManager em) {
        prepare(Apus.class,em);

        Query query = qb.all().createQuery();

        List<Apus> results = execute(query,
                                              new Class[]{Apus.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<ConstructionActivities> selectAllConstructionActivities(EntityManager em) {
        prepare(ConstructionActivities.class,em);

        Query query = qb.all().createQuery();

        List<ConstructionActivities> results = execute(query,
                                              new Class[]{ConstructionActivities.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<ConstructionChapters> selectAllConstructionChapters(EntityManager em) {
        prepare(ConstructionChapters.class,em);

        Query query = qb.all().createQuery();

        List<ConstructionChapters> results = execute(query,
                                              new Class[]{ConstructionChapters.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<TypesMeasurementUnits> selectAllTypesMeasurementUnits(EntityManager em) {
        prepare(TypesMeasurementUnits.class,em);

        Query query = qb.all().createQuery();

        List<TypesMeasurementUnits> results = execute(query,
                                              new Class[]{TypesMeasurementUnits.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<MeasurementUnits> selectAllMeasurementUnits(EntityManager em) {
        prepare(MeasurementUnits.class,em);

        Query query = qb.all().createQuery();

        List<MeasurementUnits> results = execute(query,
                                              new Class[]{MeasurementUnits.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<Years> selectAllYears(EntityManager em) {
        prepare(Years.class,em);

        Query query = qb.all().createQuery();

        List<Years> results = execute(query,
                                              new Class[]{Years.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<WorksConstruction> selectAllWorksConstruction(EntityManager em) {
        prepare(WorksConstruction.class,em);

        Query query = qb.all().createQuery();

        List<WorksConstruction> results = execute(query,
                                              new Class[]{WorksConstruction.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<TypesWorksConstruction> selectAllTypesWorksConstruction(EntityManager em) {
        prepare(TypesWorksConstruction.class,em);

        Query query = qb.all().createQuery();

        List<TypesWorksConstruction> results = execute(query,
                                              new Class[]{TypesWorksConstruction.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<Budgets> selectAllBudgets(EntityManager em) {
        prepare(Budgets.class,em);

        Query query = qb.all().createQuery();

        List<Budgets> results = execute(query,
                                              new Class[]{Budgets.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<WorkActivities> selectAllWorkActivities(EntityManager em) {
        prepare(WorkActivities.class,em);

        Query query = qb.all().createQuery();

        List<WorkActivities> results = execute(query,
                                              new Class[]{WorkActivities.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<ConstructionMaterials> selectAllConstructionMaterials(EntityManager em) {
        prepare(ConstructionMaterials.class,em);

        Query query = qb.all().createQuery();

        List<ConstructionMaterials> results = execute(query,
                                              new Class[]{ConstructionMaterials.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<ConstructionTransports> selectAllConstructionTransports(EntityManager em) {
        prepare(ConstructionTransports.class,em);

        Query query = qb.all().createQuery();

        List<ConstructionTransports> results = execute(query,
                                              new Class[]{ConstructionTransports.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<ConstructionWorkforce> selectAllConstructionWorkforce(EntityManager em) {
        prepare(ConstructionWorkforce.class,em);

        Query query = qb.all().createQuery();

        List<ConstructionWorkforce> results = execute(query,
                                              new Class[]{ConstructionWorkforce.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<ConstructionEquipments> selectAllConstructionEquipments(EntityManager em) {
        prepare(ConstructionEquipments.class,em);

        Query query = qb.all().createQuery();

        List<ConstructionEquipments> results = execute(query,
                                              new Class[]{ConstructionEquipments.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<TypesConstructionMaterials> selectAllTypesConstructionMaterials(EntityManager em) {
        prepare(TypesConstructionMaterials.class,em);

        Query query = qb.all().createQuery();

        List<TypesConstructionMaterials> results = execute(query,
                                              new Class[]{TypesConstructionMaterials.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<TypesConstructionTransports> selectAllTypesConstructionTransports(EntityManager em) {
        prepare(TypesConstructionTransports.class,em);

        Query query = qb.all().createQuery();

        List<TypesConstructionTransports> results = execute(query,
                                              new Class[]{TypesConstructionTransports.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<TypesConstructionWorkforce> selectAllTypesConstructionWorkforce(EntityManager em) {
        prepare(TypesConstructionWorkforce.class,em);

        Query query = qb.all().createQuery();

        List<TypesConstructionWorkforce> results = execute(query,
                                              new Class[]{TypesConstructionWorkforce.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<TypesConstructionEquipments> selectAllTypesConstructionEquipments(EntityManager em) {
        prepare(TypesConstructionEquipments.class,em);

        Query query = qb.all().createQuery();

        List<TypesConstructionEquipments> results = execute(query,
                                              new Class[]{TypesConstructionEquipments.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

} // Fin de clase
