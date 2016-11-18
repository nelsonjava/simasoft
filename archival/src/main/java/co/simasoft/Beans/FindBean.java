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

    @PersistenceContext(unitName = "archivalPU-JTA")
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

    public FundsLife nameFundsLife(String search,EntityManager em) {

        FundsLife fundsLife = new FundsLife();
        List<FundsLife> results = em.createQuery("SELECT o FROM FundsLife o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

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

    public Funds nameFunds(String search,EntityManager em) {

        Funds funds = new Funds();
        List<Funds> results = em.createQuery("SELECT o FROM Funds o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           funds = results.get(0);
        }
        return funds;
    }

    public Funds codeFunds(String search,EntityManager em) {

        Funds funds = new Funds();
        List<Funds> results = em.createQuery("SELECT o FROM Funds o WHERE o.code LIKE :field").setParameter("field", search).getResultList();

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

    public SectionsTypes nameSectionsTypes(String search,EntityManager em) {

        SectionsTypes sectionsTypes = new SectionsTypes();
        List<SectionsTypes> results = em.createQuery("SELECT o FROM SectionsTypes o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

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

    public Sections nameSections(String search,EntityManager em) {

        Sections sections = new Sections();
        List<Sections> results = em.createQuery("SELECT o FROM Sections o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           sections = results.get(0);
        }
        return sections;
    }

    public Sections codeSections(String search,EntityManager em) {

        Sections sections = new Sections();
        List<Sections> results = em.createQuery("SELECT o FROM Sections o WHERE o.code LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           sections = results.get(0);
        }
        return sections;
    }

    public Sections dirSections(String search,EntityManager em) {

        Sections sections = new Sections();
        List<Sections> results = em.createQuery("SELECT o FROM Sections o WHERE o.dir LIKE :field").setParameter("field", search).getResultList();

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

    public Series nameSeries(String search,EntityManager em) {

        Series series = new Series();
        List<Series> results = em.createQuery("SELECT o FROM Series o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           series = results.get(0);
        }
        return series;
    }

    public Series codeSeries(String search,EntityManager em) {

        Series series = new Series();
        List<Series> results = em.createQuery("SELECT o FROM Series o WHERE o.code LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           series = results.get(0);
        }
        return series;
    }

    public Series locatedSeries(String search,EntityManager em) {

        Series series = new Series();
        List<Series> results = em.createQuery("SELECT o FROM Series o WHERE o.located LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           series = results.get(0);
        }
        return series;
    }

    public Series proceduresSeries(String search,EntityManager em) {

        Series series = new Series();
        List<Series> results = em.createQuery("SELECT o FROM Series o WHERE o.procedures LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           series = results.get(0);
        }
        return series;
    }

    public Series dirSeries(String search,EntityManager em) {

        Series series = new Series();
        List<Series> results = em.createQuery("SELECT o FROM Series o WHERE o.dir LIKE :field").setParameter("field", search).getResultList();

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

    public TrdSeries nameTrdSeries(String search,EntityManager em) {

        TrdSeries trdSeries = new TrdSeries();
        List<TrdSeries> results = em.createQuery("SELECT o FROM TrdSeries o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

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

    public Trd nameTrd(String search,EntityManager em) {

        Trd trd = new Trd();
        List<Trd> results = em.createQuery("SELECT o FROM Trd o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

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

    public FinalDisposition nameFinalDisposition(String search,EntityManager em) {

        FinalDisposition finalDisposition = new FinalDisposition();
        List<FinalDisposition> results = em.createQuery("SELECT o FROM FinalDisposition o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

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

    public DocumentalRetention nameDocumentalRetention(String search,EntityManager em) {

        DocumentalRetention documentalRetention = new DocumentalRetention();
        List<DocumentalRetention> results = em.createQuery("SELECT o FROM DocumentalRetention o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

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

    public FrequentlyQuery nameFrequentlyQuery(String search,EntityManager em) {

        FrequentlyQuery frequentlyQuery = new FrequentlyQuery();
        List<FrequentlyQuery> results = em.createQuery("SELECT o FROM FrequentlyQuery o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

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

    public DocumentalsUnits nameDocumentalsUnits(String search,EntityManager em) {

        DocumentalsUnits documentalsUnits = new DocumentalsUnits();
        List<DocumentalsUnits> results = em.createQuery("SELECT o FROM DocumentalsUnits o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           documentalsUnits = results.get(0);
        }
        return documentalsUnits;
    }

    public DocumentalsUnits codeDocumentalsUnits(String search,EntityManager em) {

        DocumentalsUnits documentalsUnits = new DocumentalsUnits();
        List<DocumentalsUnits> results = em.createQuery("SELECT o FROM DocumentalsUnits o WHERE o.code LIKE :field").setParameter("field", search).getResultList();

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

    public ConservationUnits nameConservationUnits(String search,EntityManager em) {

        ConservationUnits conservationUnits = new ConservationUnits();
        List<ConservationUnits> results = em.createQuery("SELECT o FROM ConservationUnits o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           conservationUnits = results.get(0);
        }
        return conservationUnits;
    }

    public ConservationUnits codeConservationUnits(String search,EntityManager em) {

        ConservationUnits conservationUnits = new ConservationUnits();
        List<ConservationUnits> results = em.createQuery("SELECT o FROM ConservationUnits o WHERE o.code LIKE :field").setParameter("field", search).getResultList();

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

    public VersionsControls nameVersionsControls(String search,EntityManager em) {

        VersionsControls versionsControls = new VersionsControls();
        List<VersionsControls> results = em.createQuery("SELECT o FROM VersionsControls o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           versionsControls = results.get(0);
        }
        return versionsControls;
    }

    public VersionsControls codeVersionsControls(String search,EntityManager em) {

        VersionsControls versionsControls = new VersionsControls();
        List<VersionsControls> results = em.createQuery("SELECT o FROM VersionsControls o WHERE o.code LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           versionsControls = results.get(0);
        }
        return versionsControls;
    }

    public VersionsControls versionVersionsControls(String search,EntityManager em) {

        VersionsControls versionsControls = new VersionsControls();
        List<VersionsControls> results = em.createQuery("SELECT o FROM VersionsControls o WHERE o.version LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           versionsControls = results.get(0);
        }
        return versionsControls;
    }

    public VersionsControls requestVersionsControls(String search,EntityManager em) {

        VersionsControls versionsControls = new VersionsControls();
        List<VersionsControls> results = em.createQuery("SELECT o FROM VersionsControls o WHERE o.request LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           versionsControls = results.get(0);
        }
        return versionsControls;
    }

    public VersionsControls responsibleVersionsControls(String search,EntityManager em) {

        VersionsControls versionsControls = new VersionsControls();
        List<VersionsControls> results = em.createQuery("SELECT o FROM VersionsControls o WHERE o.responsible LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           versionsControls = results.get(0);
        }
        return versionsControls;
    }

    public VersionsControls descriptionVersionsControls(String search,EntityManager em) {

        VersionsControls versionsControls = new VersionsControls();
        List<VersionsControls> results = em.createQuery("SELECT o FROM VersionsControls o WHERE o.description LIKE :field").setParameter("field", search).getResultList();

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

    public DocumentalInventory objectDocumentalInventory(String search,EntityManager em) {

        DocumentalInventory documentalInventory = new DocumentalInventory();
        List<DocumentalInventory> results = em.createQuery("SELECT o FROM DocumentalInventory o WHERE o.object LIKE :field").setParameter("field", search).getResultList();

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

    public OriginalOrders subjectOriginalOrders(String search,EntityManager em) {

        OriginalOrders originalOrders = new OriginalOrders();
        List<OriginalOrders> results = em.createQuery("SELECT o FROM OriginalOrders o WHERE o.subject LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           originalOrders = results.get(0);
        }
        return originalOrders;
    }

    public OriginalOrders codeOriginalOrders(String search,EntityManager em) {

        OriginalOrders originalOrders = new OriginalOrders();
        List<OriginalOrders> results = em.createQuery("SELECT o FROM OriginalOrders o WHERE o.code LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           originalOrders = results.get(0);
        }
        return originalOrders;
    }

    public OriginalOrders locatedOriginalOrders(String search,EntityManager em) {

        OriginalOrders originalOrders = new OriginalOrders();
        List<OriginalOrders> results = em.createQuery("SELECT o FROM OriginalOrders o WHERE o.located LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           originalOrders = results.get(0);
        }
        return originalOrders;
    }

    public OriginalOrders mailOriginalOrders(String search,EntityManager em) {

        OriginalOrders originalOrders = new OriginalOrders();
        List<OriginalOrders> results = em.createQuery("SELECT o FROM OriginalOrders o WHERE o.mail LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           originalOrders = results.get(0);
        }
        return originalOrders;
    }

    public OriginalOrders notesOriginalOrders(String search,EntityManager em) {

        OriginalOrders originalOrders = new OriginalOrders();
        List<OriginalOrders> results = em.createQuery("SELECT o FROM OriginalOrders o WHERE o.notes LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           originalOrders = results.get(0);
        }
        return originalOrders;
    }

    public OriginalOrders fileNameOriginalOrders(String search,EntityManager em) {

        OriginalOrders originalOrders = new OriginalOrders();
        List<OriginalOrders> results = em.createQuery("SELECT o FROM OriginalOrders o WHERE o.fileName LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           originalOrders = results.get(0);
        }
        return originalOrders;
    }

    public OriginalOrders fileTypeOriginalOrders(String search,EntityManager em) {

        OriginalOrders originalOrders = new OriginalOrders();
        List<OriginalOrders> results = em.createQuery("SELECT o FROM OriginalOrders o WHERE o.fileType LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           originalOrders = results.get(0);
        }
        return originalOrders;
    }

    public OriginalOrders filedirOriginalOrders(String search,EntityManager em) {

        OriginalOrders originalOrders = new OriginalOrders();
        List<OriginalOrders> results = em.createQuery("SELECT o FROM OriginalOrders o WHERE o.filedir LIKE :field").setParameter("field", search).getResultList();

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

    public DocumentalsUnitsTypes nameDocumentalsUnitsTypes(String search,EntityManager em) {

        DocumentalsUnitsTypes documentalsUnitsTypes = new DocumentalsUnitsTypes();
        List<DocumentalsUnitsTypes> results = em.createQuery("SELECT o FROM DocumentalsUnitsTypes o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

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

    public Access nameAccess(String search,EntityManager em) {

        Access access = new Access();
        List<Access> results = em.createQuery("SELECT o FROM Access o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

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

    public Organizeds nameOrganizeds(String search,EntityManager em) {

        Organizeds organizeds = new Organizeds();
        List<Organizeds> results = em.createQuery("SELECT o FROM Organizeds o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

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

    public InventoryFinality nameInventoryFinality(String search,EntityManager em) {

        InventoryFinality inventoryFinality = new InventoryFinality();
        List<InventoryFinality> results = em.createQuery("SELECT o FROM InventoryFinality o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

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

    public DocumentalsSupports nameDocumentalsSupports(String search,EntityManager em) {

        DocumentalsSupports documentalsSupports = new DocumentalsSupports();
        List<DocumentalsSupports> results = em.createQuery("SELECT o FROM DocumentalsSupports o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           documentalsSupports = results.get(0);
        }
        return documentalsSupports;
    }

    public DocumentalsSupports codeDocumentalsSupports(String search,EntityManager em) {

        DocumentalsSupports documentalsSupports = new DocumentalsSupports();
        List<DocumentalsSupports> results = em.createQuery("SELECT o FROM DocumentalsSupports o WHERE o.code LIKE :field").setParameter("field", search).getResultList();

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

    public ConservationUnitsTypes nameConservationUnitsTypes(String search,EntityManager em) {

        ConservationUnitsTypes conservationUnitsTypes = new ConservationUnitsTypes();
        List<ConservationUnitsTypes> results = em.createQuery("SELECT o FROM ConservationUnitsTypes o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           conservationUnitsTypes = results.get(0);
        }
        return conservationUnitsTypes;
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

    public Companies nameCompanies(String search,EntityManager em) {

        Companies companies = new Companies();
        List<Companies> results = em.createQuery("SELECT o FROM Companies o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           companies = results.get(0);
        }
        return companies;
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

    public CompaniesRoles nameCompaniesRoles(String search,EntityManager em) {

        CompaniesRoles companiesRoles = new CompaniesRoles();
        List<CompaniesRoles> results = em.createQuery("SELECT o FROM CompaniesRoles o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           companiesRoles = results.get(0);
        }
        return companiesRoles;
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

    public Activities nameActivities(String search,EntityManager em) {

        Activities activities = new Activities();
        List<Activities> results = em.createQuery("SELECT o FROM Activities o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           activities = results.get(0);
        }
        return activities;
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

    public Tasks nameTasks(String search,EntityManager em) {

        Tasks tasks = new Tasks();
        List<Tasks> results = em.createQuery("SELECT o FROM Tasks o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           tasks = results.get(0);
        }
        return tasks;
    }

} // Fin de clase
