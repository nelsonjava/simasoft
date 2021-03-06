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

    @PersistenceContext(unitName = "crmNaifgPU-JTA")
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

    public List<FundsLife> selectAllFundsLife(EntityManager em) {
        prepare(FundsLife.class,em);

        Query query = qb.all().createQuery();

        List<FundsLife> results = execute(query,
                                              new Class[]{FundsLife.class}, null,
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

    public List<SectionsTypes> selectAllSectionsTypes(EntityManager em) {
        prepare(SectionsTypes.class,em);

        Query query = qb.all().createQuery();

        List<SectionsTypes> results = execute(query,
                                              new Class[]{SectionsTypes.class}, null,
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

    public List<Series> selectAllSeries(EntityManager em) {
        prepare(Series.class,em);

        Query query = qb.all().createQuery();

        List<Series> results = execute(query,
                                              new Class[]{Series.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<TrdSeries> selectAllTrdSeries(EntityManager em) {
        prepare(TrdSeries.class,em);

        Query query = qb.all().createQuery();

        List<TrdSeries> results = execute(query,
                                              new Class[]{TrdSeries.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<Trd> selectAllTrd(EntityManager em) {
        prepare(Trd.class,em);

        Query query = qb.all().createQuery();

        List<Trd> results = execute(query,
                                              new Class[]{Trd.class}, null,
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

    public List<DocumentalRetention> selectAllDocumentalRetention(EntityManager em) {
        prepare(DocumentalRetention.class,em);

        Query query = qb.all().createQuery();

        List<DocumentalRetention> results = execute(query,
                                              new Class[]{DocumentalRetention.class}, null,
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

    public List<DocumentalsUnits> selectAllDocumentalsUnits(EntityManager em) {
        prepare(DocumentalsUnits.class,em);

        Query query = qb.all().createQuery();

        List<DocumentalsUnits> results = execute(query,
                                              new Class[]{DocumentalsUnits.class}, null,
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

    public List<VersionsControls> selectAllVersionsControls(EntityManager em) {
        prepare(VersionsControls.class,em);

        Query query = qb.all().createQuery();

        List<VersionsControls> results = execute(query,
                                              new Class[]{VersionsControls.class}, null,
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

    public List<OriginalOrders> selectAllOriginalOrders(EntityManager em) {
        prepare(OriginalOrders.class,em);

        Query query = qb.all().createQuery();

        List<OriginalOrders> results = execute(query,
                                              new Class[]{OriginalOrders.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<DocumentalsUnitsTypes> selectAllDocumentalsUnitsTypes(EntityManager em) {
        prepare(DocumentalsUnitsTypes.class,em);

        Query query = qb.all().createQuery();

        List<DocumentalsUnitsTypes> results = execute(query,
                                              new Class[]{DocumentalsUnitsTypes.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<Access> selectAllAccess(EntityManager em) {
        prepare(Access.class,em);

        Query query = qb.all().createQuery();

        List<Access> results = execute(query,
                                              new Class[]{Access.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<Organizeds> selectAllOrganizeds(EntityManager em) {
        prepare(Organizeds.class,em);

        Query query = qb.all().createQuery();

        List<Organizeds> results = execute(query,
                                              new Class[]{Organizeds.class}, null,
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

    public List<DocumentalsSupports> selectAllDocumentalsSupports(EntityManager em) {
        prepare(DocumentalsSupports.class,em);

        Query query = qb.all().createQuery();

        List<DocumentalsSupports> results = execute(query,
                                              new Class[]{DocumentalsSupports.class}, null,
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

    public List<BooksTypes> selectAllBooksTypes(EntityManager em) {
        prepare(BooksTypes.class,em);

        Query query = qb.all().createQuery();

        List<BooksTypes> results = execute(query,
                                              new Class[]{BooksTypes.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<Books> selectAllBooks(EntityManager em) {
        prepare(Books.class,em);

        Query query = qb.all().createQuery();

        List<Books> results = execute(query,
                                              new Class[]{Books.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<Chapters> selectAllChapters(EntityManager em) {
        prepare(Chapters.class,em);

        Query query = qb.all().createQuery();

        List<Chapters> results = execute(query,
                                              new Class[]{Chapters.class}, null,
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

    public List<Companies> selectAllCompanies(EntityManager em) {
        prepare(Companies.class,em);

        Query query = qb.all().createQuery();

        List<Companies> results = execute(query,
                                              new Class[]{Companies.class}, null,
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

    public List<Employees> selectAllEmployees(EntityManager em) {
        prepare(Employees.class,em);

        Query query = qb.all().createQuery();

        List<Employees> results = execute(query,
                                              new Class[]{Employees.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<CompaniesRolesTypes> selectAllCompaniesRolesTypes(EntityManager em) {
        prepare(CompaniesRolesTypes.class,em);

        Query query = qb.all().createQuery();

        List<CompaniesRolesTypes> results = execute(query,
                                              new Class[]{CompaniesRolesTypes.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<CompaniesRoles> selectAllCompaniesRoles(EntityManager em) {
        prepare(CompaniesRoles.class,em);

        Query query = qb.all().createQuery();

        List<CompaniesRoles> results = execute(query,
                                              new Class[]{CompaniesRoles.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<ChargesTypes> selectAllChargesTypes(EntityManager em) {
        prepare(ChargesTypes.class,em);

        Query query = qb.all().createQuery();

        List<ChargesTypes> results = execute(query,
                                              new Class[]{ChargesTypes.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<Charges> selectAllCharges(EntityManager em) {
        prepare(Charges.class,em);

        Query query = qb.all().createQuery();

        List<Charges> results = execute(query,
                                              new Class[]{Charges.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<Pom> selectAllPom(EntityManager em) {
        prepare(Pom.class,em);

        Query query = qb.all().createQuery();

        List<Pom> results = execute(query,
                                              new Class[]{Pom.class}, null,
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

    public List<Fields> selectAllFields(EntityManager em) {
        prepare(Fields.class,em);

        Query query = qb.all().createQuery();

        List<Fields> results = execute(query,
                                              new Class[]{Fields.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<ImprovementTypes> selectAllImprovementTypes(EntityManager em) {
        prepare(ImprovementTypes.class,em);

        Query query = qb.all().createQuery();

        List<ImprovementTypes> results = execute(query,
                                              new Class[]{ImprovementTypes.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<ImprovementSources> selectAllImprovementSources(EntityManager em) {
        prepare(ImprovementSources.class,em);

        Query query = qb.all().createQuery();

        List<ImprovementSources> results = execute(query,
                                              new Class[]{ImprovementSources.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<ContinualImprovements> selectAllContinualImprovements(EntityManager em) {
        prepare(ContinualImprovements.class,em);

        Query query = qb.all().createQuery();

        List<ContinualImprovements> results = execute(query,
                                              new Class[]{ContinualImprovements.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<ActionPlans> selectAllActionPlans(EntityManager em) {
        prepare(ActionPlans.class,em);

        Query query = qb.all().createQuery();

        List<ActionPlans> results = execute(query,
                                              new Class[]{ActionPlans.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<ImprovementVerifications> selectAllImprovementVerifications(EntityManager em) {
        prepare(ImprovementVerifications.class,em);

        Query query = qb.all().createQuery();

        List<ImprovementVerifications> results = execute(query,
                                              new Class[]{ImprovementVerifications.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<ImprovementClosures> selectAllImprovementClosures(EntityManager em) {
        prepare(ImprovementClosures.class,em);

        Query query = qb.all().createQuery();

        List<ImprovementClosures> results = execute(query,
                                              new Class[]{ImprovementClosures.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<ClosingActivities> selectAllClosingActivities(EntityManager em) {
        prepare(ClosingActivities.class,em);

        Query query = qb.all().createQuery();

        List<ClosingActivities> results = execute(query,
                                              new Class[]{ClosingActivities.class}, null,
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

    public List<ModelsGroups> selectAllModelsGroups(EntityManager em) {
        prepare(ModelsGroups.class,em);

        Query query = qb.all().createQuery();

        List<ModelsGroups> results = execute(query,
                                              new Class[]{ModelsGroups.class}, null,
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

    public List<Relationships> selectAllRelationships(EntityManager em) {
        prepare(Relationships.class,em);

        Query query = qb.all().createQuery();

        List<Relationships> results = execute(query,
                                              new Class[]{Relationships.class}, null,
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

    public List<GroupIds> selectAllGroupIds(EntityManager em) {
        prepare(GroupIds.class,em);

        Query query = qb.all().createQuery();

        List<GroupIds> results = execute(query,
                                              new Class[]{GroupIds.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<GroupIdsTypes> selectAllGroupIdsTypes(EntityManager em) {
        prepare(GroupIdsTypes.class,em);

        Query query = qb.all().createQuery();

        List<GroupIdsTypes> results = execute(query,
                                              new Class[]{GroupIdsTypes.class}, null,
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

    public List<SitesTypes> selectAllSitesTypes(EntityManager em) {
        prepare(SitesTypes.class,em);

        Query query = qb.all().createQuery();

        List<SitesTypes> results = execute(query,
                                              new Class[]{SitesTypes.class}, null,
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

    public List<ActivitiesTypes> selectAllActivitiesTypes(EntityManager em) {
        prepare(ActivitiesTypes.class,em);

        Query query = qb.all().createQuery();

        List<ActivitiesTypes> results = execute(query,
                                              new Class[]{ActivitiesTypes.class}, null,
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

    public List<Calendars> selectAllCalendars(EntityManager em) {
        prepare(Calendars.class,em);

        Query query = qb.all().createQuery();

        List<Calendars> results = execute(query,
                                              new Class[]{Calendars.class}, null,
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

    public List<Priorities> selectAllPriorities(EntityManager em) {
        prepare(Priorities.class,em);

        Query query = qb.all().createQuery();

        List<Priorities> results = execute(query,
                                              new Class[]{Priorities.class}, null,
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

} // Fin de clase
