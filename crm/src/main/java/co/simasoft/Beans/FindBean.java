package co.simasoft.beans;

import co.simasoft.models.*;

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

@Stateless
@LocalBean
public class FindBean {

    @PersistenceContext(unitName = "crmPU-JTA")
    private EntityManager em;

//      ---------------------- FundsLife ------------------------

    public List<FundsLife> AllFundsLife() {
        List<FundsLife> results = em.createQuery("SELECT o FROM FundsLife o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<FundsLife>();
        }
        return results;
    }

    public FundsLife idFundsLife(Long id) {

        FundsLife fundsLife = new FundsLife();
        List<FundsLife> results = em.createQuery("SELECT o FROM FundsLife o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           fundsLife = results.get(0);
        }
        return fundsLife;
    }

//      ---------------------- Funds ------------------------

    public List<Funds> AllFunds() {
        List<Funds> results = em.createQuery("SELECT o FROM Funds o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Funds>();
        }
        return results;
    }

    public Funds idFunds(Long id) {

        Funds funds = new Funds();
        List<Funds> results = em.createQuery("SELECT o FROM Funds o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           funds = results.get(0);
        }
        return funds;
    }

//      ---------------------- SectionsTypes ------------------------

    public List<SectionsTypes> AllSectionsTypes() {
        List<SectionsTypes> results = em.createQuery("SELECT o FROM SectionsTypes o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<SectionsTypes>();
        }
        return results;
    }

    public SectionsTypes idSectionsTypes(Long id) {

        SectionsTypes sectionsTypes = new SectionsTypes();
        List<SectionsTypes> results = em.createQuery("SELECT o FROM SectionsTypes o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           sectionsTypes = results.get(0);
        }
        return sectionsTypes;
    }

//      ---------------------- Sections ------------------------

    public List<Sections> AllSections() {
        List<Sections> results = em.createQuery("SELECT o FROM Sections o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Sections>();
        }
        return results;
    }

    public Sections idSections(Long id) {

        Sections sections = new Sections();
        List<Sections> results = em.createQuery("SELECT o FROM Sections o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           sections = results.get(0);
        }
        return sections;
    }

//      ---------------------- Series ------------------------

    public List<Series> AllSeries() {
        List<Series> results = em.createQuery("SELECT o FROM Series o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Series>();
        }
        return results;
    }

    public Series idSeries(Long id) {

        Series series = new Series();
        List<Series> results = em.createQuery("SELECT o FROM Series o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           series = results.get(0);
        }
        return series;
    }

//      ---------------------- TrdSeries ------------------------

    public List<TrdSeries> AllTrdSeries() {
        List<TrdSeries> results = em.createQuery("SELECT o FROM TrdSeries o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<TrdSeries>();
        }
        return results;
    }

    public TrdSeries idTrdSeries(Long id) {

        TrdSeries trdSeries = new TrdSeries();
        List<TrdSeries> results = em.createQuery("SELECT o FROM TrdSeries o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           trdSeries = results.get(0);
        }
        return trdSeries;
    }

//      ---------------------- Trd ------------------------

    public List<Trd> AllTrd() {
        List<Trd> results = em.createQuery("SELECT o FROM Trd o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Trd>();
        }
        return results;
    }

    public Trd idTrd(Long id) {

        Trd trd = new Trd();
        List<Trd> results = em.createQuery("SELECT o FROM Trd o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           trd = results.get(0);
        }
        return trd;
    }

//      ---------------------- FinalDisposition ------------------------

    public List<FinalDisposition> AllFinalDisposition() {
        List<FinalDisposition> results = em.createQuery("SELECT o FROM FinalDisposition o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<FinalDisposition>();
        }
        return results;
    }

    public FinalDisposition idFinalDisposition(Long id) {

        FinalDisposition finalDisposition = new FinalDisposition();
        List<FinalDisposition> results = em.createQuery("SELECT o FROM FinalDisposition o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           finalDisposition = results.get(0);
        }
        return finalDisposition;
    }

//      ---------------------- DocumentalRetention ------------------------

    public List<DocumentalRetention> AllDocumentalRetention() {
        List<DocumentalRetention> results = em.createQuery("SELECT o FROM DocumentalRetention o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<DocumentalRetention>();
        }
        return results;
    }

    public DocumentalRetention idDocumentalRetention(Long id) {

        DocumentalRetention documentalRetention = new DocumentalRetention();
        List<DocumentalRetention> results = em.createQuery("SELECT o FROM DocumentalRetention o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           documentalRetention = results.get(0);
        }
        return documentalRetention;
    }

//      ---------------------- FrequentlyQuery ------------------------

    public List<FrequentlyQuery> AllFrequentlyQuery() {
        List<FrequentlyQuery> results = em.createQuery("SELECT o FROM FrequentlyQuery o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<FrequentlyQuery>();
        }
        return results;
    }

    public FrequentlyQuery idFrequentlyQuery(Long id) {

        FrequentlyQuery frequentlyQuery = new FrequentlyQuery();
        List<FrequentlyQuery> results = em.createQuery("SELECT o FROM FrequentlyQuery o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           frequentlyQuery = results.get(0);
        }
        return frequentlyQuery;
    }

//      ---------------------- DocumentalsUnits ------------------------

    public List<DocumentalsUnits> AllDocumentalsUnits() {
        List<DocumentalsUnits> results = em.createQuery("SELECT o FROM DocumentalsUnits o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<DocumentalsUnits>();
        }
        return results;
    }

    public DocumentalsUnits idDocumentalsUnits(Long id) {

        DocumentalsUnits documentalsUnits = new DocumentalsUnits();
        List<DocumentalsUnits> results = em.createQuery("SELECT o FROM DocumentalsUnits o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           documentalsUnits = results.get(0);
        }
        return documentalsUnits;
    }

//      ---------------------- ConservationUnits ------------------------

    public List<ConservationUnits> AllConservationUnits() {
        List<ConservationUnits> results = em.createQuery("SELECT o FROM ConservationUnits o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<ConservationUnits>();
        }
        return results;
    }

    public ConservationUnits idConservationUnits(Long id) {

        ConservationUnits conservationUnits = new ConservationUnits();
        List<ConservationUnits> results = em.createQuery("SELECT o FROM ConservationUnits o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           conservationUnits = results.get(0);
        }
        return conservationUnits;
    }

//      ---------------------- VersionsControls ------------------------

    public List<VersionsControls> AllVersionsControls() {
        List<VersionsControls> results = em.createQuery("SELECT o FROM VersionsControls o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<VersionsControls>();
        }
        return results;
    }

    public VersionsControls idVersionsControls(Long id) {

        VersionsControls versionsControls = new VersionsControls();
        List<VersionsControls> results = em.createQuery("SELECT o FROM VersionsControls o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           versionsControls = results.get(0);
        }
        return versionsControls;
    }

//      ---------------------- DocumentalInventory ------------------------

    public List<DocumentalInventory> AllDocumentalInventory() {
        List<DocumentalInventory> results = em.createQuery("SELECT o FROM DocumentalInventory o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<DocumentalInventory>();
        }
        return results;
    }

    public DocumentalInventory idDocumentalInventory(Long id) {

        DocumentalInventory documentalInventory = new DocumentalInventory();
        List<DocumentalInventory> results = em.createQuery("SELECT o FROM DocumentalInventory o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           documentalInventory = results.get(0);
        }
        return documentalInventory;
    }

//      ---------------------- OriginalOrders ------------------------

    public List<OriginalOrders> AllOriginalOrders() {
        List<OriginalOrders> results = em.createQuery("SELECT o FROM OriginalOrders o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<OriginalOrders>();
        }
        return results;
    }

    public OriginalOrders idOriginalOrders(Long id) {

        OriginalOrders originalOrders = new OriginalOrders();
        List<OriginalOrders> results = em.createQuery("SELECT o FROM OriginalOrders o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           originalOrders = results.get(0);
        }
        return originalOrders;
    }

//      ---------------------- DocumentalsUnitsTypes ------------------------

    public List<DocumentalsUnitsTypes> AllDocumentalsUnitsTypes() {
        List<DocumentalsUnitsTypes> results = em.createQuery("SELECT o FROM DocumentalsUnitsTypes o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<DocumentalsUnitsTypes>();
        }
        return results;
    }

    public DocumentalsUnitsTypes idDocumentalsUnitsTypes(Long id) {

        DocumentalsUnitsTypes documentalsUnitsTypes = new DocumentalsUnitsTypes();
        List<DocumentalsUnitsTypes> results = em.createQuery("SELECT o FROM DocumentalsUnitsTypes o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           documentalsUnitsTypes = results.get(0);
        }
        return documentalsUnitsTypes;
    }

//      ---------------------- Access ------------------------

    public List<Access> AllAccess() {
        List<Access> results = em.createQuery("SELECT o FROM Access o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Access>();
        }
        return results;
    }

    public Access idAccess(Long id) {

        Access access = new Access();
        List<Access> results = em.createQuery("SELECT o FROM Access o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           access = results.get(0);
        }
        return access;
    }

//      ---------------------- Organizeds ------------------------

    public List<Organizeds> AllOrganizeds() {
        List<Organizeds> results = em.createQuery("SELECT o FROM Organizeds o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Organizeds>();
        }
        return results;
    }

    public Organizeds idOrganizeds(Long id) {

        Organizeds organizeds = new Organizeds();
        List<Organizeds> results = em.createQuery("SELECT o FROM Organizeds o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           organizeds = results.get(0);
        }
        return organizeds;
    }

//      ---------------------- InventoryFinality ------------------------

    public List<InventoryFinality> AllInventoryFinality() {
        List<InventoryFinality> results = em.createQuery("SELECT o FROM InventoryFinality o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<InventoryFinality>();
        }
        return results;
    }

    public InventoryFinality idInventoryFinality(Long id) {

        InventoryFinality inventoryFinality = new InventoryFinality();
        List<InventoryFinality> results = em.createQuery("SELECT o FROM InventoryFinality o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           inventoryFinality = results.get(0);
        }
        return inventoryFinality;
    }

//      ---------------------- DocumentalsSupports ------------------------

    public List<DocumentalsSupports> AllDocumentalsSupports() {
        List<DocumentalsSupports> results = em.createQuery("SELECT o FROM DocumentalsSupports o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<DocumentalsSupports>();
        }
        return results;
    }

    public DocumentalsSupports idDocumentalsSupports(Long id) {

        DocumentalsSupports documentalsSupports = new DocumentalsSupports();
        List<DocumentalsSupports> results = em.createQuery("SELECT o FROM DocumentalsSupports o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           documentalsSupports = results.get(0);
        }
        return documentalsSupports;
    }

//      ---------------------- ConservationUnitsTypes ------------------------

    public List<ConservationUnitsTypes> AllConservationUnitsTypes() {
        List<ConservationUnitsTypes> results = em.createQuery("SELECT o FROM ConservationUnitsTypes o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<ConservationUnitsTypes>();
        }
        return results;
    }

    public ConservationUnitsTypes idConservationUnitsTypes(Long id) {

        ConservationUnitsTypes conservationUnitsTypes = new ConservationUnitsTypes();
        List<ConservationUnitsTypes> results = em.createQuery("SELECT o FROM ConservationUnitsTypes o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           conservationUnitsTypes = results.get(0);
        }
        return conservationUnitsTypes;
    }

//      ---------------------- BooksTypes ------------------------

    public List<BooksTypes> AllBooksTypes() {
        List<BooksTypes> results = em.createQuery("SELECT o FROM BooksTypes o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<BooksTypes>();
        }
        return results;
    }

    public BooksTypes idBooksTypes(Long id) {

        BooksTypes booksTypes = new BooksTypes();
        List<BooksTypes> results = em.createQuery("SELECT o FROM BooksTypes o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           booksTypes = results.get(0);
        }
        return booksTypes;
    }

//      ---------------------- Books ------------------------

    public List<Books> AllBooks() {
        List<Books> results = em.createQuery("SELECT o FROM Books o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Books>();
        }
        return results;
    }

    public Books idBooks(Long id) {

        Books books = new Books();
        List<Books> results = em.createQuery("SELECT o FROM Books o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           books = results.get(0);
        }
        return books;
    }

//      ---------------------- Chapters ------------------------

    public List<Chapters> AllChapters() {
        List<Chapters> results = em.createQuery("SELECT o FROM Chapters o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Chapters>();
        }
        return results;
    }

    public Chapters idChapters(Long id) {

        Chapters chapters = new Chapters();
        List<Chapters> results = em.createQuery("SELECT o FROM Chapters o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           chapters = results.get(0);
        }
        return chapters;
    }

//      ---------------------- Brands ------------------------

    public List<Brands> AllBrands() {
        List<Brands> results = em.createQuery("SELECT o FROM Brands o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Brands>();
        }
        return results;
    }

    public Brands idBrands(Long id) {

        Brands brands = new Brands();
        List<Brands> results = em.createQuery("SELECT o FROM Brands o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           brands = results.get(0);
        }
        return brands;
    }

//      ---------------------- Companies ------------------------

    public List<Companies> AllCompanies() {
        List<Companies> results = em.createQuery("SELECT o FROM Companies o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Companies>();
        }
        return results;
    }

    public Companies idCompanies(Long id) {

        Companies companies = new Companies();
        List<Companies> results = em.createQuery("SELECT o FROM Companies o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           companies = results.get(0);
        }
        return companies;
    }

//      ---------------------- EmployeesTypes ------------------------

    public List<EmployeesTypes> AllEmployeesTypes() {
        List<EmployeesTypes> results = em.createQuery("SELECT o FROM EmployeesTypes o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<EmployeesTypes>();
        }
        return results;
    }

    public EmployeesTypes idEmployeesTypes(Long id) {

        EmployeesTypes employeesTypes = new EmployeesTypes();
        List<EmployeesTypes> results = em.createQuery("SELECT o FROM EmployeesTypes o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           employeesTypes = results.get(0);
        }
        return employeesTypes;
    }

//      ---------------------- Employees ------------------------

    public List<Employees> AllEmployees() {
        List<Employees> results = em.createQuery("SELECT o FROM Employees o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Employees>();
        }
        return results;
    }

    public Employees idEmployees(Long id) {

        Employees employees = new Employees();
        List<Employees> results = em.createQuery("SELECT o FROM Employees o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           employees = results.get(0);
        }
        return employees;
    }

//      ---------------------- CompaniesRolesTypes ------------------------

    public List<CompaniesRolesTypes> AllCompaniesRolesTypes() {
        List<CompaniesRolesTypes> results = em.createQuery("SELECT o FROM CompaniesRolesTypes o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<CompaniesRolesTypes>();
        }
        return results;
    }

    public CompaniesRolesTypes idCompaniesRolesTypes(Long id) {

        CompaniesRolesTypes companiesRolesTypes = new CompaniesRolesTypes();
        List<CompaniesRolesTypes> results = em.createQuery("SELECT o FROM CompaniesRolesTypes o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           companiesRolesTypes = results.get(0);
        }
        return companiesRolesTypes;
    }

//      ---------------------- CompaniesRoles ------------------------

    public List<CompaniesRoles> AllCompaniesRoles() {
        List<CompaniesRoles> results = em.createQuery("SELECT o FROM CompaniesRoles o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<CompaniesRoles>();
        }
        return results;
    }

    public CompaniesRoles idCompaniesRoles(Long id) {

        CompaniesRoles companiesRoles = new CompaniesRoles();
        List<CompaniesRoles> results = em.createQuery("SELECT o FROM CompaniesRoles o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           companiesRoles = results.get(0);
        }
        return companiesRoles;
    }

//      ---------------------- ChargesTypes ------------------------

    public List<ChargesTypes> AllChargesTypes() {
        List<ChargesTypes> results = em.createQuery("SELECT o FROM ChargesTypes o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<ChargesTypes>();
        }
        return results;
    }

    public ChargesTypes idChargesTypes(Long id) {

        ChargesTypes chargesTypes = new ChargesTypes();
        List<ChargesTypes> results = em.createQuery("SELECT o FROM ChargesTypes o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           chargesTypes = results.get(0);
        }
        return chargesTypes;
    }

//      ---------------------- Charges ------------------------

    public List<Charges> AllCharges() {
        List<Charges> results = em.createQuery("SELECT o FROM Charges o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Charges>();
        }
        return results;
    }

    public Charges idCharges(Long id) {

        Charges charges = new Charges();
        List<Charges> results = em.createQuery("SELECT o FROM Charges o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           charges = results.get(0);
        }
        return charges;
    }

//      ---------------------- ImprovementTypes ------------------------

    public List<ImprovementTypes> AllImprovementTypes() {
        List<ImprovementTypes> results = em.createQuery("SELECT o FROM ImprovementTypes o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<ImprovementTypes>();
        }
        return results;
    }

    public ImprovementTypes idImprovementTypes(Long id) {

        ImprovementTypes improvementTypes = new ImprovementTypes();
        List<ImprovementTypes> results = em.createQuery("SELECT o FROM ImprovementTypes o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           improvementTypes = results.get(0);
        }
        return improvementTypes;
    }

//      ---------------------- ImprovementSources ------------------------

    public List<ImprovementSources> AllImprovementSources() {
        List<ImprovementSources> results = em.createQuery("SELECT o FROM ImprovementSources o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<ImprovementSources>();
        }
        return results;
    }

    public ImprovementSources idImprovementSources(Long id) {

        ImprovementSources improvementSources = new ImprovementSources();
        List<ImprovementSources> results = em.createQuery("SELECT o FROM ImprovementSources o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           improvementSources = results.get(0);
        }
        return improvementSources;
    }

//      ---------------------- ContinualImprovements ------------------------

    public List<ContinualImprovements> AllContinualImprovements() {
        List<ContinualImprovements> results = em.createQuery("SELECT o FROM ContinualImprovements o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<ContinualImprovements>();
        }
        return results;
    }

    public ContinualImprovements idContinualImprovements(Long id) {

        ContinualImprovements continualImprovements = new ContinualImprovements();
        List<ContinualImprovements> results = em.createQuery("SELECT o FROM ContinualImprovements o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           continualImprovements = results.get(0);
        }
        return continualImprovements;
    }

//      ---------------------- ActionPlans ------------------------

    public List<ActionPlans> AllActionPlans() {
        List<ActionPlans> results = em.createQuery("SELECT o FROM ActionPlans o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<ActionPlans>();
        }
        return results;
    }

    public ActionPlans idActionPlans(Long id) {

        ActionPlans actionPlans = new ActionPlans();
        List<ActionPlans> results = em.createQuery("SELECT o FROM ActionPlans o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           actionPlans = results.get(0);
        }
        return actionPlans;
    }

//      ---------------------- ImprovementVerifications ------------------------

    public List<ImprovementVerifications> AllImprovementVerifications() {
        List<ImprovementVerifications> results = em.createQuery("SELECT o FROM ImprovementVerifications o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<ImprovementVerifications>();
        }
        return results;
    }

    public ImprovementVerifications idImprovementVerifications(Long id) {

        ImprovementVerifications improvementVerifications = new ImprovementVerifications();
        List<ImprovementVerifications> results = em.createQuery("SELECT o FROM ImprovementVerifications o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           improvementVerifications = results.get(0);
        }
        return improvementVerifications;
    }

//      ---------------------- ImprovementClosures ------------------------

    public List<ImprovementClosures> AllImprovementClosures() {
        List<ImprovementClosures> results = em.createQuery("SELECT o FROM ImprovementClosures o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<ImprovementClosures>();
        }
        return results;
    }

    public ImprovementClosures idImprovementClosures(Long id) {

        ImprovementClosures improvementClosures = new ImprovementClosures();
        List<ImprovementClosures> results = em.createQuery("SELECT o FROM ImprovementClosures o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           improvementClosures = results.get(0);
        }
        return improvementClosures;
    }

//      ---------------------- ClosingActivities ------------------------

    public List<ClosingActivities> AllClosingActivities() {
        List<ClosingActivities> results = em.createQuery("SELECT o FROM ClosingActivities o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<ClosingActivities>();
        }
        return results;
    }

    public ClosingActivities idClosingActivities(Long id) {

        ClosingActivities closingActivities = new ClosingActivities();
        List<ClosingActivities> results = em.createQuery("SELECT o FROM ClosingActivities o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           closingActivities = results.get(0);
        }
        return closingActivities;
    }

//      ---------------------- ItemsTypes ------------------------

    public List<ItemsTypes> AllItemsTypes() {
        List<ItemsTypes> results = em.createQuery("SELECT o FROM ItemsTypes o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<ItemsTypes>();
        }
        return results;
    }

    public ItemsTypes idItemsTypes(Long id) {

        ItemsTypes itemsTypes = new ItemsTypes();
        List<ItemsTypes> results = em.createQuery("SELECT o FROM ItemsTypes o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           itemsTypes = results.get(0);
        }
        return itemsTypes;
    }

//      ---------------------- ItemsNames ------------------------

    public List<ItemsNames> AllItemsNames() {
        List<ItemsNames> results = em.createQuery("SELECT o FROM ItemsNames o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<ItemsNames>();
        }
        return results;
    }

    public ItemsNames idItemsNames(Long id) {

        ItemsNames itemsNames = new ItemsNames();
        List<ItemsNames> results = em.createQuery("SELECT o FROM ItemsNames o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           itemsNames = results.get(0);
        }
        return itemsNames;
    }

//      ---------------------- Items ------------------------

    public List<Items> AllItems() {
        List<Items> results = em.createQuery("SELECT o FROM Items o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Items>();
        }
        return results;
    }

    public Items idItems(Long id) {

        Items items = new Items();
        List<Items> results = em.createQuery("SELECT o FROM Items o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           items = results.get(0);
        }
        return items;
    }

//      ---------------------- ItemsStates ------------------------

    public List<ItemsStates> AllItemsStates() {
        List<ItemsStates> results = em.createQuery("SELECT o FROM ItemsStates o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<ItemsStates>();
        }
        return results;
    }

    public ItemsStates idItemsStates(Long id) {

        ItemsStates itemsStates = new ItemsStates();
        List<ItemsStates> results = em.createQuery("SELECT o FROM ItemsStates o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           itemsStates = results.get(0);
        }
        return itemsStates;
    }

//      ---------------------- HostsTypes ------------------------

    public List<HostsTypes> AllHostsTypes() {
        List<HostsTypes> results = em.createQuery("SELECT o FROM HostsTypes o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<HostsTypes>();
        }
        return results;
    }

    public HostsTypes idHostsTypes(Long id) {

        HostsTypes hostsTypes = new HostsTypes();
        List<HostsTypes> results = em.createQuery("SELECT o FROM HostsTypes o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           hostsTypes = results.get(0);
        }
        return hostsTypes;
    }

//      ---------------------- Hosts ------------------------

    public List<Hosts> AllHosts() {
        List<Hosts> results = em.createQuery("SELECT o FROM Hosts o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Hosts>();
        }
        return results;
    }

    public Hosts idHosts(Long id) {

        Hosts hosts = new Hosts();
        List<Hosts> results = em.createQuery("SELECT o FROM Hosts o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           hosts = results.get(0);
        }
        return hosts;
    }

//      ---------------------- NetworkPorts ------------------------

    public List<NetworkPorts> AllNetworkPorts() {
        List<NetworkPorts> results = em.createQuery("SELECT o FROM NetworkPorts o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<NetworkPorts>();
        }
        return results;
    }

    public NetworkPorts idNetworkPorts(Long id) {

        NetworkPorts networkPorts = new NetworkPorts();
        List<NetworkPorts> results = em.createQuery("SELECT o FROM NetworkPorts o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           networkPorts = results.get(0);
        }
        return networkPorts;
    }

//      ---------------------- PatchPanelsPorts ------------------------

    public List<PatchPanelsPorts> AllPatchPanelsPorts() {
        List<PatchPanelsPorts> results = em.createQuery("SELECT o FROM PatchPanelsPorts o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<PatchPanelsPorts>();
        }
        return results;
    }

    public PatchPanelsPorts idPatchPanelsPorts(Long id) {

        PatchPanelsPorts patchPanelsPorts = new PatchPanelsPorts();
        List<PatchPanelsPorts> results = em.createQuery("SELECT o FROM PatchPanelsPorts o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           patchPanelsPorts = results.get(0);
        }
        return patchPanelsPorts;
    }

//      ---------------------- SwitchesPorts ------------------------

    public List<SwitchesPorts> AllSwitchesPorts() {
        List<SwitchesPorts> results = em.createQuery("SELECT o FROM SwitchesPorts o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<SwitchesPorts>();
        }
        return results;
    }

    public SwitchesPorts idSwitchesPorts(Long id) {

        SwitchesPorts switchesPorts = new SwitchesPorts();
        List<SwitchesPorts> results = em.createQuery("SELECT o FROM SwitchesPorts o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           switchesPorts = results.get(0);
        }
        return switchesPorts;
    }

//      ---------------------- Vlans ------------------------

    public List<Vlans> AllVlans() {
        List<Vlans> results = em.createQuery("SELECT o FROM Vlans o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Vlans>();
        }
        return results;
    }

    public Vlans idVlans(Long id) {

        Vlans vlans = new Vlans();
        List<Vlans> results = em.createQuery("SELECT o FROM Vlans o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           vlans = results.get(0);
        }
        return vlans;
    }

//      ---------------------- Persons ------------------------

    public List<Persons> AllPersons() {
        List<Persons> results = em.createQuery("SELECT o FROM Persons o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Persons>();
        }
        return results;
    }

    public Persons idPersons(Long id) {

        Persons persons = new Persons();
        List<Persons> results = em.createQuery("SELECT o FROM Persons o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           persons = results.get(0);
        }
        return persons;
    }

//      ---------------------- PhysicalAreasTypes ------------------------

    public List<PhysicalAreasTypes> AllPhysicalAreasTypes() {
        List<PhysicalAreasTypes> results = em.createQuery("SELECT o FROM PhysicalAreasTypes o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<PhysicalAreasTypes>();
        }
        return results;
    }

    public PhysicalAreasTypes idPhysicalAreasTypes(Long id) {

        PhysicalAreasTypes physicalAreasTypes = new PhysicalAreasTypes();
        List<PhysicalAreasTypes> results = em.createQuery("SELECT o FROM PhysicalAreasTypes o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           physicalAreasTypes = results.get(0);
        }
        return physicalAreasTypes;
    }

//      ---------------------- PhysicalAreas ------------------------

    public List<PhysicalAreas> AllPhysicalAreas() {
        List<PhysicalAreas> results = em.createQuery("SELECT o FROM PhysicalAreas o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<PhysicalAreas>();
        }
        return results;
    }

    public PhysicalAreas idPhysicalAreas(Long id) {

        PhysicalAreas physicalAreas = new PhysicalAreas();
        List<PhysicalAreas> results = em.createQuery("SELECT o FROM PhysicalAreas o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           physicalAreas = results.get(0);
        }
        return physicalAreas;
    }

//      ---------------------- SitesTypes ------------------------

    public List<SitesTypes> AllSitesTypes() {
        List<SitesTypes> results = em.createQuery("SELECT o FROM SitesTypes o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<SitesTypes>();
        }
        return results;
    }

    public SitesTypes idSitesTypes(Long id) {

        SitesTypes sitesTypes = new SitesTypes();
        List<SitesTypes> results = em.createQuery("SELECT o FROM SitesTypes o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           sitesTypes = results.get(0);
        }
        return sitesTypes;
    }

//      ---------------------- Sites ------------------------

    public List<Sites> AllSites() {
        List<Sites> results = em.createQuery("SELECT o FROM Sites o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Sites>();
        }
        return results;
    }

    public Sites idSites(Long id) {

        Sites sites = new Sites();
        List<Sites> results = em.createQuery("SELECT o FROM Sites o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           sites = results.get(0);
        }
        return sites;
    }

//      ---------------------- ActivitiesTypes ------------------------

    public List<ActivitiesTypes> AllActivitiesTypes() {
        List<ActivitiesTypes> results = em.createQuery("SELECT o FROM ActivitiesTypes o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<ActivitiesTypes>();
        }
        return results;
    }

    public ActivitiesTypes idActivitiesTypes(Long id) {

        ActivitiesTypes activitiesTypes = new ActivitiesTypes();
        List<ActivitiesTypes> results = em.createQuery("SELECT o FROM ActivitiesTypes o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           activitiesTypes = results.get(0);
        }
        return activitiesTypes;
    }

//      ---------------------- Activities ------------------------

    public List<Activities> AllActivities() {
        List<Activities> results = em.createQuery("SELECT o FROM Activities o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Activities>();
        }
        return results;
    }

    public Activities idActivities(Long id) {

        Activities activities = new Activities();
        List<Activities> results = em.createQuery("SELECT o FROM Activities o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           activities = results.get(0);
        }
        return activities;
    }

//      ---------------------- Calendars ------------------------

    public List<Calendars> AllCalendars() {
        List<Calendars> results = em.createQuery("SELECT o FROM Calendars o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Calendars>();
        }
        return results;
    }

    public Calendars idCalendars(Long id) {

        Calendars calendars = new Calendars();
        List<Calendars> results = em.createQuery("SELECT o FROM Calendars o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           calendars = results.get(0);
        }
        return calendars;
    }

//      ---------------------- Tasks ------------------------

    public List<Tasks> AllTasks() {
        List<Tasks> results = em.createQuery("SELECT o FROM Tasks o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Tasks>();
        }
        return results;
    }

    public Tasks idTasks(Long id) {

        Tasks tasks = new Tasks();
        List<Tasks> results = em.createQuery("SELECT o FROM Tasks o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           tasks = results.get(0);
        }
        return tasks;
    }

//      ---------------------- Priorities ------------------------

    public List<Priorities> AllPriorities() {
        List<Priorities> results = em.createQuery("SELECT o FROM Priorities o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Priorities>();
        }
        return results;
    }

    public Priorities idPriorities(Long id) {

        Priorities priorities = new Priorities();
        List<Priorities> results = em.createQuery("SELECT o FROM Priorities o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           priorities = results.get(0);
        }
        return priorities;
    }

//      ---------------------- Diaries ------------------------

    public List<Diaries> AllDiaries() {
        List<Diaries> results = em.createQuery("SELECT o FROM Diaries o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Diaries>();
        }
        return results;
    }

    public Diaries idDiaries(Long id) {

        Diaries diaries = new Diaries();
        List<Diaries> results = em.createQuery("SELECT o FROM Diaries o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           diaries = results.get(0);
        }
        return diaries;
    }

} // Fin de clase
