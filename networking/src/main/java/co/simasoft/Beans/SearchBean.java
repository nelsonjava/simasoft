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

    @PersistenceContext(unitName = "networkingPU-JTA")
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

    public List<Hosts> selectAllHosts(EntityManager em) {
        prepare(Hosts.class,em);

        Query query = qb.all().createQuery();

        List<Hosts> results = execute(query,
                                              new Class[]{Hosts.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<Address> selectAllAddress(EntityManager em) {
        prepare(Address.class,em);

        Query query = qb.all().createQuery();

        List<Address> results = execute(query,
                                              new Class[]{Address.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<Companies> selectAllCompanies(EntityManager em) {
        prepare(Companies.class,em);

        Query query = qb.all().createQuery();

        List<Companies> results = execute(query,
                                              new Class[]{Companies.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<PatchPanelsPorts> selectAllPatchPanelsPorts(EntityManager em) {
        prepare(PatchPanelsPorts.class,em);

        Query query = qb.all().createQuery();

        List<PatchPanelsPorts> results = execute(query,
                                              new Class[]{PatchPanelsPorts.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<Employees> selectAllEmployees(EntityManager em) {
        prepare(Employees.class,em);

        Query query = qb.all().createQuery();

        List<Employees> results = execute(query,
                                              new Class[]{Employees.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<ItemsNames> selectAllItemsNames(EntityManager em) {
        prepare(ItemsNames.class,em);

        Query query = qb.all().createQuery();

        List<ItemsNames> results = execute(query,
                                              new Class[]{ItemsNames.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<Persons> selectAllPersons(EntityManager em) {
        prepare(Persons.class,em);

        Query query = qb.all().createQuery();

        List<Persons> results = execute(query,
                                              new Class[]{Persons.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<Ids> selectAllIds(EntityManager em) {
        prepare(Ids.class,em);

        Query query = qb.all().createQuery();

        List<Ids> results = execute(query,
                                              new Class[]{Ids.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<Items> selectAllItems(EntityManager em) {
        prepare(Items.class,em);

        Query query = qb.all().createQuery();

        List<Items> results = execute(query,
                                              new Class[]{Items.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<Emails> selectAllEmails(EntityManager em) {
        prepare(Emails.class,em);

        Query query = qb.all().createQuery();

        List<Emails> results = execute(query,
                                              new Class[]{Emails.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<ItemsTypes> selectAllItemsTypes(EntityManager em) {
        prepare(ItemsTypes.class,em);

        Query query = qb.all().createQuery();

        List<ItemsTypes> results = execute(query,
                                              new Class[]{ItemsTypes.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<EmployeesTypes> selectAllEmployeesTypes(EntityManager em) {
        prepare(EmployeesTypes.class,em);

        Query query = qb.all().createQuery();

        List<EmployeesTypes> results = execute(query,
                                              new Class[]{EmployeesTypes.class}, null,
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

    public List<NetworkPorts> selectAllNetworkPorts(EntityManager em) {
        prepare(NetworkPorts.class,em);

        Query query = qb.all().createQuery();

        List<NetworkPorts> results = execute(query,
                                              new Class[]{NetworkPorts.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<HostsTypes> selectAllHostsTypes(EntityManager em) {
        prepare(HostsTypes.class,em);

        Query query = qb.all().createQuery();

        List<HostsTypes> results = execute(query,
                                              new Class[]{HostsTypes.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<Sites> selectAllSites(EntityManager em) {
        prepare(Sites.class,em);

        Query query = qb.all().createQuery();

        List<Sites> results = execute(query,
                                              new Class[]{Sites.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<SwitchesPorts> selectAllSwitchesPorts(EntityManager em) {
        prepare(SwitchesPorts.class,em);

        Query query = qb.all().createQuery();

        List<SwitchesPorts> results = execute(query,
                                              new Class[]{SwitchesPorts.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<TelephonesTypes> selectAllTelephonesTypes(EntityManager em) {
        prepare(TelephonesTypes.class,em);

        Query query = qb.all().createQuery();

        List<TelephonesTypes> results = execute(query,
                                              new Class[]{TelephonesTypes.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<Telephones> selectAllTelephones(EntityManager em) {
        prepare(Telephones.class,em);

        Query query = qb.all().createQuery();

        List<Telephones> results = execute(query,
                                              new Class[]{Telephones.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<Brands> selectAllBrands(EntityManager em) {
        prepare(Brands.class,em);

        Query query = qb.all().createQuery();

        List<Brands> results = execute(query,
                                              new Class[]{Brands.class}, null,
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

    public List<PositionsCompany> selectAllPositionsCompany(EntityManager em) {
        prepare(PositionsCompany.class,em);

        Query query = qb.all().createQuery();

        List<PositionsCompany> results = execute(query,
                                              new Class[]{PositionsCompany.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<IdsTypes> selectAllIdsTypes(EntityManager em) {
        prepare(IdsTypes.class,em);

        Query query = qb.all().createQuery();

        List<IdsTypes> results = execute(query,
                                              new Class[]{IdsTypes.class}, null,
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

    public List<Vlans> selectAllVlans(EntityManager em) {
        prepare(Vlans.class,em);

        Query query = qb.all().createQuery();

        List<Vlans> results = execute(query,
                                              new Class[]{Vlans.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<ItemsStates> selectAllItemsStates(EntityManager em) {
        prepare(ItemsStates.class,em);

        Query query = qb.all().createQuery();

        List<ItemsStates> results = execute(query,
                                              new Class[]{ItemsStates.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

} // Fin de clase
