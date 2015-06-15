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

/*
Entities
DomainModels
GroupIds
LinksTypes
NameQueries
Attributes
FilesModels
SystemsModels
Relationships
Links

Cardinalities
AttributesTypes
AttributesProperties
Imports
Dependency

*/



public class NaifgBean {

    public List<Dependency> findAllDependency(EntityManager em) {

    try {

        FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search.getFullTextEntityManager(em);
        fullTextEntityManager.createIndexer().startAndWait();

        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Dependency.class).get();
        org.apache.lucene.search.Query query = queryBuilder.all().createQuery();

        FullTextQuery fullTextQuery = fullTextEntityManager.createFullTextQuery(query, Dependency.class);
        Sort sort = new Sort(new SortField("orden", SortField.LONG));
        fullTextQuery.setSort(sort);

        fullTextQuery.initializeObjectsWith(ObjectLookupMethod.SKIP, DatabaseRetrievalMethod.FIND_BY_ID);

        List<Dependency> results = fullTextQuery.getResultList();

        return results;

    } // try
    catch(Exception ioe) {
      ioe.printStackTrace();
    } // catch

    return null;

    }
    
    public List<Imports> findAllImports(EntityManager em) {

    try {

        FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search.getFullTextEntityManager(em);
        fullTextEntityManager.createIndexer().startAndWait();

        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Imports.class).get();
        org.apache.lucene.search.Query query = queryBuilder.all().createQuery();

        FullTextQuery fullTextQuery = fullTextEntityManager.createFullTextQuery(query, Imports.class);
        Sort sort = new Sort(new SortField("orden", SortField.LONG));
        fullTextQuery.setSort(sort);

        fullTextQuery.initializeObjectsWith(ObjectLookupMethod.SKIP, DatabaseRetrievalMethod.FIND_BY_ID);

        List<Imports> results = fullTextQuery.getResultList();

        return results;

    } // try
    catch(Exception ioe) {
      ioe.printStackTrace();
    } // catch

    return null;

    }



    public List<AttributesProperties> findAllAttributesProperties(EntityManager em) {

    try {
        FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search.getFullTextEntityManager(em);
        fullTextEntityManager.createIndexer().startAndWait();

        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(AttributesProperties.class).get();
        org.apache.lucene.search.Query query = queryBuilder.all().createQuery();

        FullTextQuery fullTextQuery = fullTextEntityManager.createFullTextQuery(query, AttributesProperties.class);
        Sort sort = new Sort(new SortField("orden", SortField.LONG));
        fullTextQuery.setSort(sort);

        fullTextQuery.initializeObjectsWith(ObjectLookupMethod.SKIP, DatabaseRetrievalMethod.FIND_BY_ID);

        List<AttributesProperties> results = fullTextQuery.getResultList();

        return results;

    } // try
    catch(Exception ioe) {
      ioe.printStackTrace();
    } // catch

    return new ArrayList<AttributesProperties>();

    } // findAllAttributesProperties

    public List<Cardinalities> findAllCardinalities(EntityManager em) {

        FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search.getFullTextEntityManager(em);

        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Cardinalities.class).get();
        org.apache.lucene.search.Query query = queryBuilder.all().createQuery();

        FullTextQuery fullTextQuery = fullTextEntityManager.createFullTextQuery(query, Cardinalities.class);
        Sort sort = new Sort(new SortField("orden", SortField.LONG));
        fullTextQuery.setSort(sort);

        fullTextQuery.initializeObjectsWith(ObjectLookupMethod.SKIP, DatabaseRetrievalMethod.FIND_BY_ID);

        List<Cardinalities> results = fullTextQuery.getResultList();

        return results;

    }

    public Dependency findDependency(String search,EntityManager em) {

        FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search.getFullTextEntityManager(em);

        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Dependency.class).get();
        org.apache.lucene.search.Query query = queryBuilder.keyword().onField("artifactId").matching(search).createQuery();

        FullTextQuery fullTextQuery = fullTextEntityManager.createFullTextQuery(query, Dependency.class);

        fullTextQuery.initializeObjectsWith(ObjectLookupMethod.SKIP, DatabaseRetrievalMethod.FIND_BY_ID);

        List results = fullTextQuery.getResultList();

        if (results.isEmpty()) {
           return null;
        }

        Dependency dependency = new Dependency();
        dependency = (Dependency) results.get(0);

        return dependency;

    }

} // NaifgBean
