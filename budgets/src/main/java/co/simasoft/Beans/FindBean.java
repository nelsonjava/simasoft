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

    @PersistenceContext(unitName = "budgetsPU-JTA")
    private EntityManager em;

//      ---------------------- Apus ------------------------

    public List<Apus> AllApus() {
        List<Apus> results = em.createQuery("SELECT o FROM Apus o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Apus>();
        }
        return results;
    }

    public Apus idApus(Long id) {

        Apus apus = new Apus();
        List<Apus> results = em.createQuery("SELECT o FROM Apus o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           apus = results.get(0);
        }
        return apus;
    }

    public Apus codeApus(String search,EntityManager em) {

        Apus apus = new Apus();
        List<Apus> results = em.createQuery("SELECT o FROM Apus o WHERE o.code LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           apus = results.get(0);
        }
        return apus;
    }

    public Apus nameApus(String search,EntityManager em) {

        Apus apus = new Apus();
        List<Apus> results = em.createQuery("SELECT o FROM Apus o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           apus = results.get(0);
        }
        return apus;
    }

//      ---------------------- ConstructionActivities ------------------------

    public List<ConstructionActivities> AllConstructionActivities() {
        List<ConstructionActivities> results = em.createQuery("SELECT o FROM ConstructionActivities o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<ConstructionActivities>();
        }
        return results;
    }

    public ConstructionActivities idConstructionActivities(Long id) {

        ConstructionActivities constructionActivities = new ConstructionActivities();
        List<ConstructionActivities> results = em.createQuery("SELECT o FROM ConstructionActivities o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           constructionActivities = results.get(0);
        }
        return constructionActivities;
    }

    public ConstructionActivities codeConstructionActivities(String search,EntityManager em) {

        ConstructionActivities constructionActivities = new ConstructionActivities();
        List<ConstructionActivities> results = em.createQuery("SELECT o FROM ConstructionActivities o WHERE o.code LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           constructionActivities = results.get(0);
        }
        return constructionActivities;
    }

    public ConstructionActivities nameConstructionActivities(String search,EntityManager em) {

        ConstructionActivities constructionActivities = new ConstructionActivities();
        List<ConstructionActivities> results = em.createQuery("SELECT o FROM ConstructionActivities o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           constructionActivities = results.get(0);
        }
        return constructionActivities;
    }

//      ---------------------- ConstructionChapters ------------------------

    public List<ConstructionChapters> AllConstructionChapters() {
        List<ConstructionChapters> results = em.createQuery("SELECT o FROM ConstructionChapters o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<ConstructionChapters>();
        }
        return results;
    }

    public ConstructionChapters idConstructionChapters(Long id) {

        ConstructionChapters constructionChapters = new ConstructionChapters();
        List<ConstructionChapters> results = em.createQuery("SELECT o FROM ConstructionChapters o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           constructionChapters = results.get(0);
        }
        return constructionChapters;
    }

    public ConstructionChapters codeConstructionChapters(String search,EntityManager em) {

        ConstructionChapters constructionChapters = new ConstructionChapters();
        List<ConstructionChapters> results = em.createQuery("SELECT o FROM ConstructionChapters o WHERE o.code LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           constructionChapters = results.get(0);
        }
        return constructionChapters;
    }

    public ConstructionChapters nameConstructionChapters(String search,EntityManager em) {

        ConstructionChapters constructionChapters = new ConstructionChapters();
        List<ConstructionChapters> results = em.createQuery("SELECT o FROM ConstructionChapters o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           constructionChapters = results.get(0);
        }
        return constructionChapters;
    }

//      ---------------------- TypesMeasurementUnits ------------------------

    public List<TypesMeasurementUnits> AllTypesMeasurementUnits() {
        List<TypesMeasurementUnits> results = em.createQuery("SELECT o FROM TypesMeasurementUnits o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<TypesMeasurementUnits>();
        }
        return results;
    }

    public TypesMeasurementUnits idTypesMeasurementUnits(Long id) {

        TypesMeasurementUnits typesMeasurementUnits = new TypesMeasurementUnits();
        List<TypesMeasurementUnits> results = em.createQuery("SELECT o FROM TypesMeasurementUnits o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           typesMeasurementUnits = results.get(0);
        }
        return typesMeasurementUnits;
    }

    public TypesMeasurementUnits codeTypesMeasurementUnits(String search,EntityManager em) {

        TypesMeasurementUnits typesMeasurementUnits = new TypesMeasurementUnits();
        List<TypesMeasurementUnits> results = em.createQuery("SELECT o FROM TypesMeasurementUnits o WHERE o.code LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           typesMeasurementUnits = results.get(0);
        }
        return typesMeasurementUnits;
    }

    public TypesMeasurementUnits nameTypesMeasurementUnits(String search,EntityManager em) {

        TypesMeasurementUnits typesMeasurementUnits = new TypesMeasurementUnits();
        List<TypesMeasurementUnits> results = em.createQuery("SELECT o FROM TypesMeasurementUnits o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           typesMeasurementUnits = results.get(0);
        }
        return typesMeasurementUnits;
    }

//      ---------------------- MeasurementUnits ------------------------

    public List<MeasurementUnits> AllMeasurementUnits() {
        List<MeasurementUnits> results = em.createQuery("SELECT o FROM MeasurementUnits o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<MeasurementUnits>();
        }
        return results;
    }

    public MeasurementUnits idMeasurementUnits(Long id) {

        MeasurementUnits measurementUnits = new MeasurementUnits();
        List<MeasurementUnits> results = em.createQuery("SELECT o FROM MeasurementUnits o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           measurementUnits = results.get(0);
        }
        return measurementUnits;
    }

    public MeasurementUnits codeMeasurementUnits(String search,EntityManager em) {

        MeasurementUnits measurementUnits = new MeasurementUnits();
        List<MeasurementUnits> results = em.createQuery("SELECT o FROM MeasurementUnits o WHERE o.code LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           measurementUnits = results.get(0);
        }
        return measurementUnits;
    }

    public MeasurementUnits nameMeasurementUnits(String search,EntityManager em) {

        MeasurementUnits measurementUnits = new MeasurementUnits();
        List<MeasurementUnits> results = em.createQuery("SELECT o FROM MeasurementUnits o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           measurementUnits = results.get(0);
        }
        return measurementUnits;
    }

//      ---------------------- Years ------------------------

    public List<Years> AllYears() {
        List<Years> results = em.createQuery("SELECT o FROM Years o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Years>();
        }
        return results;
    }

    public Years idYears(Long id) {

        Years years = new Years();
        List<Years> results = em.createQuery("SELECT o FROM Years o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           years = results.get(0);
        }
        return years;
    }

    public Years yearYears(String search,EntityManager em) {

        Years years = new Years();
        List<Years> results = em.createQuery("SELECT o FROM Years o WHERE o.year LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           years = results.get(0);
        }
        return years;
    }

//      ---------------------- WorksConstruction ------------------------

    public List<WorksConstruction> AllWorksConstruction() {
        List<WorksConstruction> results = em.createQuery("SELECT o FROM WorksConstruction o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<WorksConstruction>();
        }
        return results;
    }

    public WorksConstruction idWorksConstruction(Long id) {

        WorksConstruction worksConstruction = new WorksConstruction();
        List<WorksConstruction> results = em.createQuery("SELECT o FROM WorksConstruction o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           worksConstruction = results.get(0);
        }
        return worksConstruction;
    }

    public WorksConstruction codeWorksConstruction(String search,EntityManager em) {

        WorksConstruction worksConstruction = new WorksConstruction();
        List<WorksConstruction> results = em.createQuery("SELECT o FROM WorksConstruction o WHERE o.code LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           worksConstruction = results.get(0);
        }
        return worksConstruction;
    }

    public WorksConstruction nameWorksConstruction(String search,EntityManager em) {

        WorksConstruction worksConstruction = new WorksConstruction();
        List<WorksConstruction> results = em.createQuery("SELECT o FROM WorksConstruction o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           worksConstruction = results.get(0);
        }
        return worksConstruction;
    }

//      ---------------------- TypesWorksConstruction ------------------------

    public List<TypesWorksConstruction> AllTypesWorksConstruction() {
        List<TypesWorksConstruction> results = em.createQuery("SELECT o FROM TypesWorksConstruction o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<TypesWorksConstruction>();
        }
        return results;
    }

    public TypesWorksConstruction idTypesWorksConstruction(Long id) {

        TypesWorksConstruction typesWorksConstruction = new TypesWorksConstruction();
        List<TypesWorksConstruction> results = em.createQuery("SELECT o FROM TypesWorksConstruction o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           typesWorksConstruction = results.get(0);
        }
        return typesWorksConstruction;
    }

    public TypesWorksConstruction codeTypesWorksConstruction(String search,EntityManager em) {

        TypesWorksConstruction typesWorksConstruction = new TypesWorksConstruction();
        List<TypesWorksConstruction> results = em.createQuery("SELECT o FROM TypesWorksConstruction o WHERE o.code LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           typesWorksConstruction = results.get(0);
        }
        return typesWorksConstruction;
    }

    public TypesWorksConstruction nameTypesWorksConstruction(String search,EntityManager em) {

        TypesWorksConstruction typesWorksConstruction = new TypesWorksConstruction();
        List<TypesWorksConstruction> results = em.createQuery("SELECT o FROM TypesWorksConstruction o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           typesWorksConstruction = results.get(0);
        }
        return typesWorksConstruction;
    }

//      ---------------------- Budgets ------------------------

    public List<Budgets> AllBudgets() {
        List<Budgets> results = em.createQuery("SELECT o FROM Budgets o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Budgets>();
        }
        return results;
    }

    public Budgets idBudgets(Long id) {

        Budgets budgets = new Budgets();
        List<Budgets> results = em.createQuery("SELECT o FROM Budgets o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           budgets = results.get(0);
        }
        return budgets;
    }

//      ---------------------- WorkActivities ------------------------

    public List<WorkActivities> AllWorkActivities() {
        List<WorkActivities> results = em.createQuery("SELECT o FROM WorkActivities o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<WorkActivities>();
        }
        return results;
    }

    public WorkActivities idWorkActivities(Long id) {

        WorkActivities workActivities = new WorkActivities();
        List<WorkActivities> results = em.createQuery("SELECT o FROM WorkActivities o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           workActivities = results.get(0);
        }
        return workActivities;
    }

    public WorkActivities codeWorkActivities(String search,EntityManager em) {

        WorkActivities workActivities = new WorkActivities();
        List<WorkActivities> results = em.createQuery("SELECT o FROM WorkActivities o WHERE o.code LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           workActivities = results.get(0);
        }
        return workActivities;
    }

    public WorkActivities nameWorkActivities(String search,EntityManager em) {

        WorkActivities workActivities = new WorkActivities();
        List<WorkActivities> results = em.createQuery("SELECT o FROM WorkActivities o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           workActivities = results.get(0);
        }
        return workActivities;
    }

//      ---------------------- ConstructionMaterials ------------------------

    public List<ConstructionMaterials> AllConstructionMaterials() {
        List<ConstructionMaterials> results = em.createQuery("SELECT o FROM ConstructionMaterials o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<ConstructionMaterials>();
        }
        return results;
    }

    public ConstructionMaterials idConstructionMaterials(Long id) {

        ConstructionMaterials constructionMaterials = new ConstructionMaterials();
        List<ConstructionMaterials> results = em.createQuery("SELECT o FROM ConstructionMaterials o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           constructionMaterials = results.get(0);
        }
        return constructionMaterials;
    }

    public ConstructionMaterials codeConstructionMaterials(String search,EntityManager em) {

        ConstructionMaterials constructionMaterials = new ConstructionMaterials();
        List<ConstructionMaterials> results = em.createQuery("SELECT o FROM ConstructionMaterials o WHERE o.code LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           constructionMaterials = results.get(0);
        }
        return constructionMaterials;
    }

    public ConstructionMaterials nameConstructionMaterials(String search,EntityManager em) {

        ConstructionMaterials constructionMaterials = new ConstructionMaterials();
        List<ConstructionMaterials> results = em.createQuery("SELECT o FROM ConstructionMaterials o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           constructionMaterials = results.get(0);
        }
        return constructionMaterials;
    }

//      ---------------------- ConstructionTransports ------------------------

    public List<ConstructionTransports> AllConstructionTransports() {
        List<ConstructionTransports> results = em.createQuery("SELECT o FROM ConstructionTransports o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<ConstructionTransports>();
        }
        return results;
    }

    public ConstructionTransports idConstructionTransports(Long id) {

        ConstructionTransports constructionTransports = new ConstructionTransports();
        List<ConstructionTransports> results = em.createQuery("SELECT o FROM ConstructionTransports o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           constructionTransports = results.get(0);
        }
        return constructionTransports;
    }

    public ConstructionTransports codeConstructionTransports(String search,EntityManager em) {

        ConstructionTransports constructionTransports = new ConstructionTransports();
        List<ConstructionTransports> results = em.createQuery("SELECT o FROM ConstructionTransports o WHERE o.code LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           constructionTransports = results.get(0);
        }
        return constructionTransports;
    }

    public ConstructionTransports nameConstructionTransports(String search,EntityManager em) {

        ConstructionTransports constructionTransports = new ConstructionTransports();
        List<ConstructionTransports> results = em.createQuery("SELECT o FROM ConstructionTransports o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           constructionTransports = results.get(0);
        }
        return constructionTransports;
    }

//      ---------------------- ConstructionWorkforce ------------------------

    public List<ConstructionWorkforce> AllConstructionWorkforce() {
        List<ConstructionWorkforce> results = em.createQuery("SELECT o FROM ConstructionWorkforce o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<ConstructionWorkforce>();
        }
        return results;
    }

    public ConstructionWorkforce idConstructionWorkforce(Long id) {

        ConstructionWorkforce constructionWorkforce = new ConstructionWorkforce();
        List<ConstructionWorkforce> results = em.createQuery("SELECT o FROM ConstructionWorkforce o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           constructionWorkforce = results.get(0);
        }
        return constructionWorkforce;
    }

    public ConstructionWorkforce codeConstructionWorkforce(String search,EntityManager em) {

        ConstructionWorkforce constructionWorkforce = new ConstructionWorkforce();
        List<ConstructionWorkforce> results = em.createQuery("SELECT o FROM ConstructionWorkforce o WHERE o.code LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           constructionWorkforce = results.get(0);
        }
        return constructionWorkforce;
    }

    public ConstructionWorkforce nameConstructionWorkforce(String search,EntityManager em) {

        ConstructionWorkforce constructionWorkforce = new ConstructionWorkforce();
        List<ConstructionWorkforce> results = em.createQuery("SELECT o FROM ConstructionWorkforce o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           constructionWorkforce = results.get(0);
        }
        return constructionWorkforce;
    }

//      ---------------------- ConstructionEquipments ------------------------

    public List<ConstructionEquipments> AllConstructionEquipments() {
        List<ConstructionEquipments> results = em.createQuery("SELECT o FROM ConstructionEquipments o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<ConstructionEquipments>();
        }
        return results;
    }

    public ConstructionEquipments idConstructionEquipments(Long id) {

        ConstructionEquipments constructionEquipments = new ConstructionEquipments();
        List<ConstructionEquipments> results = em.createQuery("SELECT o FROM ConstructionEquipments o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           constructionEquipments = results.get(0);
        }
        return constructionEquipments;
    }

    public ConstructionEquipments codeConstructionEquipments(String search,EntityManager em) {

        ConstructionEquipments constructionEquipments = new ConstructionEquipments();
        List<ConstructionEquipments> results = em.createQuery("SELECT o FROM ConstructionEquipments o WHERE o.code LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           constructionEquipments = results.get(0);
        }
        return constructionEquipments;
    }

    public ConstructionEquipments nameConstructionEquipments(String search,EntityManager em) {

        ConstructionEquipments constructionEquipments = new ConstructionEquipments();
        List<ConstructionEquipments> results = em.createQuery("SELECT o FROM ConstructionEquipments o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           constructionEquipments = results.get(0);
        }
        return constructionEquipments;
    }

//      ---------------------- TypesConstructionMaterials ------------------------

    public List<TypesConstructionMaterials> AllTypesConstructionMaterials() {
        List<TypesConstructionMaterials> results = em.createQuery("SELECT o FROM TypesConstructionMaterials o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<TypesConstructionMaterials>();
        }
        return results;
    }

    public TypesConstructionMaterials idTypesConstructionMaterials(Long id) {

        TypesConstructionMaterials typesConstructionMaterials = new TypesConstructionMaterials();
        List<TypesConstructionMaterials> results = em.createQuery("SELECT o FROM TypesConstructionMaterials o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           typesConstructionMaterials = results.get(0);
        }
        return typesConstructionMaterials;
    }

    public TypesConstructionMaterials codeTypesConstructionMaterials(String search,EntityManager em) {

        TypesConstructionMaterials typesConstructionMaterials = new TypesConstructionMaterials();
        List<TypesConstructionMaterials> results = em.createQuery("SELECT o FROM TypesConstructionMaterials o WHERE o.code LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           typesConstructionMaterials = results.get(0);
        }
        return typesConstructionMaterials;
    }

    public TypesConstructionMaterials nameTypesConstructionMaterials(String search,EntityManager em) {

        TypesConstructionMaterials typesConstructionMaterials = new TypesConstructionMaterials();
        List<TypesConstructionMaterials> results = em.createQuery("SELECT o FROM TypesConstructionMaterials o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           typesConstructionMaterials = results.get(0);
        }
        return typesConstructionMaterials;
    }

//      ---------------------- TypesConstructionTransports ------------------------

    public List<TypesConstructionTransports> AllTypesConstructionTransports() {
        List<TypesConstructionTransports> results = em.createQuery("SELECT o FROM TypesConstructionTransports o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<TypesConstructionTransports>();
        }
        return results;
    }

    public TypesConstructionTransports idTypesConstructionTransports(Long id) {

        TypesConstructionTransports typesConstructionTransports = new TypesConstructionTransports();
        List<TypesConstructionTransports> results = em.createQuery("SELECT o FROM TypesConstructionTransports o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           typesConstructionTransports = results.get(0);
        }
        return typesConstructionTransports;
    }

    public TypesConstructionTransports codeTypesConstructionTransports(String search,EntityManager em) {

        TypesConstructionTransports typesConstructionTransports = new TypesConstructionTransports();
        List<TypesConstructionTransports> results = em.createQuery("SELECT o FROM TypesConstructionTransports o WHERE o.code LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           typesConstructionTransports = results.get(0);
        }
        return typesConstructionTransports;
    }

    public TypesConstructionTransports nameTypesConstructionTransports(String search,EntityManager em) {

        TypesConstructionTransports typesConstructionTransports = new TypesConstructionTransports();
        List<TypesConstructionTransports> results = em.createQuery("SELECT o FROM TypesConstructionTransports o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           typesConstructionTransports = results.get(0);
        }
        return typesConstructionTransports;
    }

//      ---------------------- TypesConstructionWorkforce ------------------------

    public List<TypesConstructionWorkforce> AllTypesConstructionWorkforce() {
        List<TypesConstructionWorkforce> results = em.createQuery("SELECT o FROM TypesConstructionWorkforce o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<TypesConstructionWorkforce>();
        }
        return results;
    }

    public TypesConstructionWorkforce idTypesConstructionWorkforce(Long id) {

        TypesConstructionWorkforce typesConstructionWorkforce = new TypesConstructionWorkforce();
        List<TypesConstructionWorkforce> results = em.createQuery("SELECT o FROM TypesConstructionWorkforce o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           typesConstructionWorkforce = results.get(0);
        }
        return typesConstructionWorkforce;
    }

    public TypesConstructionWorkforce codeTypesConstructionWorkforce(String search,EntityManager em) {

        TypesConstructionWorkforce typesConstructionWorkforce = new TypesConstructionWorkforce();
        List<TypesConstructionWorkforce> results = em.createQuery("SELECT o FROM TypesConstructionWorkforce o WHERE o.code LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           typesConstructionWorkforce = results.get(0);
        }
        return typesConstructionWorkforce;
    }

    public TypesConstructionWorkforce nameTypesConstructionWorkforce(String search,EntityManager em) {

        TypesConstructionWorkforce typesConstructionWorkforce = new TypesConstructionWorkforce();
        List<TypesConstructionWorkforce> results = em.createQuery("SELECT o FROM TypesConstructionWorkforce o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           typesConstructionWorkforce = results.get(0);
        }
        return typesConstructionWorkforce;
    }

//      ---------------------- TypesConstructionEquipments ------------------------

    public List<TypesConstructionEquipments> AllTypesConstructionEquipments() {
        List<TypesConstructionEquipments> results = em.createQuery("SELECT o FROM TypesConstructionEquipments o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<TypesConstructionEquipments>();
        }
        return results;
    }

    public TypesConstructionEquipments idTypesConstructionEquipments(Long id) {

        TypesConstructionEquipments typesConstructionEquipments = new TypesConstructionEquipments();
        List<TypesConstructionEquipments> results = em.createQuery("SELECT o FROM TypesConstructionEquipments o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           typesConstructionEquipments = results.get(0);
        }
        return typesConstructionEquipments;
    }

    public TypesConstructionEquipments codeTypesConstructionEquipments(String search,EntityManager em) {

        TypesConstructionEquipments typesConstructionEquipments = new TypesConstructionEquipments();
        List<TypesConstructionEquipments> results = em.createQuery("SELECT o FROM TypesConstructionEquipments o WHERE o.code LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           typesConstructionEquipments = results.get(0);
        }
        return typesConstructionEquipments;
    }

    public TypesConstructionEquipments nameTypesConstructionEquipments(String search,EntityManager em) {

        TypesConstructionEquipments typesConstructionEquipments = new TypesConstructionEquipments();
        List<TypesConstructionEquipments> results = em.createQuery("SELECT o FROM TypesConstructionEquipments o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           typesConstructionEquipments = results.get(0);
        }
        return typesConstructionEquipments;
    }

} // Fin de clase
