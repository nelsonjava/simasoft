/*
fullTextSession.createIndexer().startAndWait();
*/

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
public class SearchBean {

    @PersistenceContext(unitName = "naifg7PU-JTA")
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

    try {

        if (query == null) {
            throw new NullPointerException("Lucene query object is null.");
        }
        if ( (entityClasses == null) || (entityClasses.length == 0) ) {
            throw new NullPointerException("There must be at least one entity class(.class type).");
        }

fTEM.createIndexer().startAndWait();

        FullTextQuery fTQ = fTEM.createFullTextQuery(query, entityClasses);

        if (projectionWith != null) {
            fTQ.setProjection(projectionWith);
        }
        if (sortByThisField != null) {
            fTQ.setSort(new Sort(sortByThisField));
        }

        fTQ.initializeObjectsWith(ObjectLookupMethod.SKIP, DatabaseRetrievalMethod.FIND_BY_ID);
        return fTQ.getResultList();
        
    } // try
    catch(Exception ioe) {
      ioe.printStackTrace();
    } // catch

    return null; // Revisar        

    } // end : execute Method

    // QUERIES //

    public List<Entities> selectAllEntities(EntityManager em) {
        prepare(Entities.class,em);

        Query query = qb.all().createQuery();

        List<Entities> results = execute(query,
                                              new Class[]{Entities.class}, null,
                                              new SortField("orden", SortField.LONG));
        return results;
    }

    public List<DomainModels> selectAllDomainModels(EntityManager em) {
        prepare(DomainModels.class,em);

        Query query = qb.all().createQuery();

        List<DomainModels> results = execute(query,
                                              new Class[]{DomainModels.class}, null,
                                              new SortField("orden", SortField.LONG));
        return results;
    }

    public List<AttributesProperties> selectAllAttributesProperties(EntityManager em) {
        prepare(AttributesProperties.class,em);

        Query query = qb.all().createQuery();

        List<AttributesProperties> results = execute(query,
                                              new Class[]{AttributesProperties.class}, null,
                                              new SortField("orden", SortField.LONG));
        return results;
    }

    public List<GroupIds> selectAllGroupIds(EntityManager em) {
        prepare(GroupIds.class,em);

        Query query = qb.all().createQuery();

        List<GroupIds> results = execute(query,
                                              new Class[]{GroupIds.class}, null,
                                              new SortField("orden", SortField.LONG));
        return results;
    }

    public List<AttributesTypes> selectAllAttributesTypes(EntityManager em) {
        prepare(AttributesTypes.class,em);

        Query query = qb.all().createQuery();

        List<AttributesTypes> results = execute(query,
                                              new Class[]{AttributesTypes.class}, null,
                                              new SortField("orden", SortField.LONG));
        return results;
    }

    public List<Dependency> selectAllDependency(EntityManager em) {
        prepare(Dependency.class,em);

        Query query = qb.all().createQuery();

        List<Dependency> results = execute(query,
                                              new Class[]{Dependency.class}, null,
                                              new SortField("orden", SortField.LONG));
        return results;
    }

    public List<LinksTypes> selectAllLinksTypes(EntityManager em) {
        prepare(LinksTypes.class,em);

        Query query = qb.all().createQuery();

        List<LinksTypes> results = execute(query,
                                              new Class[]{LinksTypes.class}, null,
                                              new SortField("orden", SortField.LONG));
        return results;
    }

    public List<NameQueries> selectAllNameQueries(EntityManager em) {
        prepare(NameQueries.class,em);

        Query query = qb.all().createQuery();

        List<NameQueries> results = execute(query,
                                              new Class[]{NameQueries.class}, null,
                                              new SortField("orden", SortField.LONG));
        return results;
    }

    public List<Attributes> selectAllAttributes(EntityManager em) {
        prepare(Attributes.class,em);

        Query query = qb.all().createQuery();

        List<Attributes> results = execute(query,
                                              new Class[]{Attributes.class}, null,
                                              new SortField("orden", SortField.LONG));
        return results;
    }

    public List<FilesModels> selectAllFilesModels(EntityManager em) {
        prepare(FilesModels.class,em);

        Query query = qb.all().createQuery();

        List<FilesModels> results = execute(query,
                                              new Class[]{FilesModels.class}, null,
                                              new SortField("orden", SortField.LONG));
        return results;
    }

    public List<Cardinalities> selectAllCardinalities(EntityManager em) {
        prepare(Cardinalities.class,em);

        Query query = qb.all().createQuery();

        List<Cardinalities> results = execute(query,
                                              new Class[]{Cardinalities.class}, null,
                                              new SortField("orden", SortField.LONG));
        return results;
    }

    public List<SystemsModels> selectAllSystemsModels(EntityManager em) {
        prepare(SystemsModels.class,em);

        Query query = qb.all().createQuery();

        List<SystemsModels> results = execute(query,
                                              new Class[]{SystemsModels.class}, null,
                                              new SortField("orden", SortField.LONG));
        return results;
    }

    public List<Relationships> selectAllRelationships(EntityManager em) {
        prepare(Relationships.class,em);

        Query query = qb.all().createQuery();

        List<Relationships> results = execute(query,
                                              new Class[]{Relationships.class}, null,
                                              new SortField("orden", SortField.LONG));
        return results;
    }

    public List<Imports> selectAllImports(EntityManager em) {
        prepare(Imports.class,em);

        Query query = qb.all().createQuery();

        List<Imports> results = execute(query,
                                              new Class[]{Imports.class}, null,
                                              new SortField("orden", SortField.LONG));
        return results;
    }

    public List<Links> selectAllLinks(EntityManager em) {
        prepare(Links.class,em);

        Query query = qb.all().createQuery();

        List<Links> results = execute(query,
                                              new Class[]{Links.class}, null,
                                              new SortField("orden", SortField.LONG));
        return results;
    }
    
// ------------------------------------------------------------------------------------------ //

    public Dependency artifactIdDependency(String dependencyToSearch,EntityManager em) {
        prepare(Dependency.class,em);

        Query query = qb.keyword().onField("artifactId").matching(dependencyToSearch).createQuery();

        List<Dependency> results = execute(query,
                                           new Class[]{Dependency.class},
                                           null, null);
        if (!results.isEmpty()) {
           return (Dependency) results.get(0);
        }
        return null;
    }

} // Fin de clase
