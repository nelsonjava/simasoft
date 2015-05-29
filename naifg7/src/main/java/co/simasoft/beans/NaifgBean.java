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
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.query.DatabaseRetrievalMethod;
import org.hibernate.search.query.ObjectLookupMethod;
import org.hibernate.search.query.dsl.QueryBuilder;

@Stateless
@LocalBean
public class NaifgBean {

    @PersistenceContext(unitName = "naifg7PU-JTA")
    private EntityManager em;

    public AttributesTypes findAttributesTypes(String name) {

        AttributesTypes attributesTypes = new AttributesTypes();
        List<AttributesTypes> results = em.createQuery("SELECT c FROM AttributesTypes c WHERE c.name LIKE :custName").setParameter("custName", name).getResultList();

        if (!results.isEmpty()) {
           attributesTypes = results.get(0);
        }
        return attributesTypes;

    }

} // NaifgBean
