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

    @PersistenceContext(unitName = "leanCrmPU-JTA")
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

    public List<ItemsTypes> selectAllItemsTypes(EntityManager em) {
        prepare(ItemsTypes.class,em);

        Query query = qb.all().createQuery();

        List<ItemsTypes> results = execute(query,
                                              new Class[]{ItemsTypes.class}, null,
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

    public List<Items> selectAllItems(EntityManager em) {
        prepare(Items.class,em);

        Query query = qb.all().createQuery();

        List<Items> results = execute(query,
                                              new Class[]{Items.class}, null,
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

    public List<LeanProjects> selectAllLeanProjects(EntityManager em) {
        prepare(LeanProjects.class,em);

        Query query = qb.all().createQuery();

        List<LeanProjects> results = execute(query,
                                              new Class[]{LeanProjects.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<ModelsCanvas> selectAllModelsCanvas(EntityManager em) {
        prepare(ModelsCanvas.class,em);

        Query query = qb.all().createQuery();

        List<ModelsCanvas> results = execute(query,
                                              new Class[]{ModelsCanvas.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<ModelsCanvasSections> selectAllModelsCanvasSections(EntityManager em) {
        prepare(ModelsCanvasSections.class,em);

        Query query = qb.all().createQuery();

        List<ModelsCanvasSections> results = execute(query,
                                              new Class[]{ModelsCanvasSections.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<Postits> selectAllPostits(EntityManager em) {
        prepare(Postits.class,em);

        Query query = qb.all().createQuery();

        List<Postits> results = execute(query,
                                              new Class[]{Postits.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<LegisTypes> selectAllLegisTypes(EntityManager em) {
        prepare(LegisTypes.class,em);

        Query query = qb.all().createQuery();

        List<LegisTypes> results = execute(query,
                                              new Class[]{LegisTypes.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<Legis> selectAllLegis(EntityManager em) {
        prepare(Legis.class,em);

        Query query = qb.all().createQuery();

        List<Legis> results = execute(query,
                                              new Class[]{Legis.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<LegisArt> selectAllLegisArt(EntityManager em) {
        prepare(LegisArt.class,em);

        Query query = qb.all().createQuery();

        List<LegisArt> results = execute(query,
                                              new Class[]{LegisArt.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<LegisArtSubject> selectAllLegisArtSubject(EntityManager em) {
        prepare(LegisArtSubject.class,em);

        Query query = qb.all().createQuery();

        List<LegisArtSubject> results = execute(query,
                                              new Class[]{LegisArtSubject.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<LegisSubject> selectAllLegisSubject(EntityManager em) {
        prepare(LegisSubject.class,em);

        Query query = qb.all().createQuery();

        List<LegisSubject> results = execute(query,
                                              new Class[]{LegisSubject.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<LegisTopic> selectAllLegisTopic(EntityManager em) {
        prepare(LegisTopic.class,em);

        Query query = qb.all().createQuery();

        List<LegisTopic> results = execute(query,
                                              new Class[]{LegisTopic.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<LegisTopicTypes> selectAllLegisTopicTypes(EntityManager em) {
        prepare(LegisTopicTypes.class,em);

        Query query = qb.all().createQuery();

        List<LegisTopicTypes> results = execute(query,
                                              new Class[]{LegisTopicTypes.class}, null,
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

    public List<Predio> selectAllPredio(EntityManager em) {
        prepare(Predio.class,em);

        Query query = qb.all().createQuery();

        List<Predio> results = execute(query,
                                              new Class[]{Predio.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<PhysicalSpaces> selectAllPhysicalSpaces(EntityManager em) {
        prepare(PhysicalSpaces.class,em);

        Query query = qb.all().createQuery();

        List<PhysicalSpaces> results = execute(query,
                                              new Class[]{PhysicalSpaces.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<PhysicalSpacesTypes> selectAllPhysicalSpacesTypes(EntityManager em) {
        prepare(PhysicalSpacesTypes.class,em);

        Query query = qb.all().createQuery();

        List<PhysicalSpacesTypes> results = execute(query,
                                              new Class[]{PhysicalSpacesTypes.class}, null,
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

    public List<PhysicalAreasTypes> selectAllPhysicalAreasTypes(EntityManager em) {
        prepare(PhysicalAreasTypes.class,em);

        Query query = qb.all().createQuery();

        List<PhysicalAreasTypes> results = execute(query,
                                              new Class[]{PhysicalAreasTypes.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<SectionsReports> selectAllSectionsReports(EntityManager em) {
        prepare(SectionsReports.class,em);

        Query query = qb.all().createQuery();

        List<SectionsReports> results = execute(query,
                                              new Class[]{SectionsReports.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<SeriesReports> selectAllSeriesReports(EntityManager em) {
        prepare(SeriesReports.class,em);

        Query query = qb.all().createQuery();

        List<SeriesReports> results = execute(query,
                                              new Class[]{SeriesReports.class}, null,
                                              new SortField("orden", SortField.DOUBLE));
        return results;
    }

    public List<Reports> selectAllReports(EntityManager em) {
        prepare(Reports.class,em);

        Query query = qb.all().createQuery();

        List<Reports> results = execute(query,
                                              new Class[]{Reports.class}, null,
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
