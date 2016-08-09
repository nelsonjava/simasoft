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

    @PersistenceContext(unitName = "naifg28PU-JTA")
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

    public List<Sites> selectAllSites(EntityManager em) {
        prepare(Sites.class,em);

        Query query = qb.all().createQuery();

        List<Sites> results = execute(query,
                                              new Class[]{Sites.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<SitesTypes> selectAllSitesTypes(EntityManager em) {
        prepare(SitesTypes.class,em);

        Query query = qb.all().createQuery();

        List<SitesTypes> results = execute(query,
                                              new Class[]{SitesTypes.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<Models> selectAllModels(EntityManager em) {
        prepare(Models.class,em);

        Query query = qb.all().createQuery();

        List<Models> results = execute(query,
                                              new Class[]{Models.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<ModelRelationships> selectAllModelRelationships(EntityManager em) {
        prepare(ModelRelationships.class,em);

        Query query = qb.all().createQuery();

        List<ModelRelationships> results = execute(query,
                                              new Class[]{ModelRelationships.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<Entities> selectAllEntities(EntityManager em) {
        prepare(Entities.class,em);

        Query query = qb.all().createQuery();

        List<Entities> results = execute(query,
                                              new Class[]{Entities.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<Attributes> selectAllAttributes(EntityManager em) {
        prepare(Attributes.class,em);

        Query query = qb.all().createQuery();

        List<Attributes> results = execute(query,
                                              new Class[]{Attributes.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<Cardinalities> selectAllCardinalities(EntityManager em) {
        prepare(Cardinalities.class,em);

        Query query = qb.all().createQuery();

        List<Cardinalities> results = execute(query,
                                              new Class[]{Cardinalities.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<Relationships> selectAllRelationships(EntityManager em) {
        prepare(Relationships.class,em);

        Query query = qb.all().createQuery();

        List<Relationships> results = execute(query,
                                              new Class[]{Relationships.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<Developments> selectAllDevelopments(EntityManager em) {
        prepare(Developments.class,em);

        Query query = qb.all().createQuery();

        List<Developments> results = execute(query,
                                              new Class[]{Developments.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<Dependencies> selectAllDependencies(EntityManager em) {
        prepare(Dependencies.class,em);

        Query query = qb.all().createQuery();

        List<Dependencies> results = execute(query,
                                              new Class[]{Dependencies.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<Imports> selectAllImports(EntityManager em) {
        prepare(Imports.class,em);

        Query query = qb.all().createQuery();

        List<Imports> results = execute(query,
                                              new Class[]{Imports.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<AttributesProperties> selectAllAttributesProperties(EntityManager em) {
        prepare(AttributesProperties.class,em);

        Query query = qb.all().createQuery();

        List<AttributesProperties> results = execute(query,
                                              new Class[]{AttributesProperties.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<AttributesTypes> selectAllAttributesTypes(EntityManager em) {
        prepare(AttributesTypes.class,em);

        Query query = qb.all().createQuery();

        List<AttributesTypes> results = execute(query,
                                              new Class[]{AttributesTypes.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

} // Fin de clase
