package co.simasoft.beans;

import co.simasoft.models.naif.domainmodels.*;

import java.util.*;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;
import org.apache.lucene.search.NumericRangeQuery;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.query.DatabaseRetrievalMethod;
import org.hibernate.search.query.ObjectLookupMethod;
import org.hibernate.search.query.dsl.QueryBuilder;

public class NaifgBean {

    @PersistenceContext(unitName = "naifg8PU-JTA")
    private EntityManager em;

    public List<Cardinalities> findAllCardinalities(EntityManager em) {
    try {

        FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search.getFullTextEntityManager(em);
        fullTextEntityManager.createIndexer().startAndWait();

        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Cardinalities.class).get();
        org.apache.lucene.search.Query query = queryBuilder.all().createQuery();

        FullTextQuery fullTextQuery = fullTextEntityManager.createFullTextQuery(query, Cardinalities.class);
        Sort sort = new Sort(new SortField("orden", SortField.DOUBLE));
        fullTextQuery.setSort(sort);

        fullTextQuery.initializeObjectsWith(ObjectLookupMethod.SKIP, DatabaseRetrievalMethod.FIND_BY_ID);

        List<Cardinalities> results = fullTextQuery.getResultList();
        
        return results;

    } // try
    catch(Exception ioe) {
      ioe.printStackTrace();
    } // catch

    return new ArrayList<Cardinalities>();

    } // findAllCardinalities


    public List<Cardinalities> findAllCardinality(EntityManager em) {

        Cardinalities cardinalities = new Cardinalities();
        List<Cardinalities> results = em.createQuery("SELECT c FROM Cardinalities c").getResultList();

        if (results.isEmpty()) {
            return new ArrayList<Cardinalities>();
        }

        return results;
    }


} // NaifgBean
