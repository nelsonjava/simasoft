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

    @PersistenceContext(unitName = "naifg25PU-JTA")
    private EntityManager em;

//      ---------------------- AttributesProperties ------------------------

    public List<AttributesProperties> AllAttributesProperties() {
        List<AttributesProperties> results = em.createQuery("SELECT o FROM AttributesProperties o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<AttributesProperties>();
        }
        return results;
    }

    public AttributesProperties idAttributesProperties(Long id) {

        AttributesProperties attributesProperties = new AttributesProperties();
        List<AttributesProperties> results = em.createQuery("SELECT o FROM AttributesProperties o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           attributesProperties = results.get(0);
        }
        return attributesProperties;
    }

//      ---------------------- ModelsGroupIds ------------------------

    public List<ModelsGroupIds> AllModelsGroupIds() {
        List<ModelsGroupIds> results = em.createQuery("SELECT o FROM ModelsGroupIds o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<ModelsGroupIds>();
        }
        return results;
    }

    public ModelsGroupIds idModelsGroupIds(Long id) {

        ModelsGroupIds modelsGroupIds = new ModelsGroupIds();
        List<ModelsGroupIds> results = em.createQuery("SELECT o FROM ModelsGroupIds o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           modelsGroupIds = results.get(0);
        }
        return modelsGroupIds;
    }

//      ---------------------- Attributes ------------------------

    public List<Attributes> AllAttributes() {
        List<Attributes> results = em.createQuery("SELECT o FROM Attributes o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Attributes>();
        }
        return results;
    }

    public Attributes idAttributes(Long id) {

        Attributes attributes = new Attributes();
        List<Attributes> results = em.createQuery("SELECT o FROM Attributes o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           attributes = results.get(0);
        }
        return attributes;
    }

//      ---------------------- Imports ------------------------

    public List<Imports> AllImports() {
        List<Imports> results = em.createQuery("SELECT o FROM Imports o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Imports>();
        }
        return results;
    }

    public Imports idImports(Long id) {

        Imports imports = new Imports();
        List<Imports> results = em.createQuery("SELECT o FROM Imports o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           imports = results.get(0);
        }
        return imports;
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

//      ---------------------- Entities ------------------------

    public List<Entities> AllEntities() {
        List<Entities> results = em.createQuery("SELECT o FROM Entities o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Entities>();
        }
        return results;
    }

    public Entities idEntities(Long id) {

        Entities entities = new Entities();
        List<Entities> results = em.createQuery("SELECT o FROM Entities o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           entities = results.get(0);
        }
        return entities;
    }

//      ---------------------- GroupIds ------------------------

    public List<GroupIds> AllGroupIds() {
        List<GroupIds> results = em.createQuery("SELECT o FROM GroupIds o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<GroupIds>();
        }
        return results;
    }

    public GroupIds idGroupIds(Long id) {

        GroupIds groupIds = new GroupIds();
        List<GroupIds> results = em.createQuery("SELECT o FROM GroupIds o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           groupIds = results.get(0);
        }
        return groupIds;
    }

//      ---------------------- Relationships ------------------------

    public List<Relationships> AllRelationships() {
        List<Relationships> results = em.createQuery("SELECT o FROM Relationships o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Relationships>();
        }
        return results;
    }

    public Relationships idRelationships(Long id) {

        Relationships relationships = new Relationships();
        List<Relationships> results = em.createQuery("SELECT o FROM Relationships o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           relationships = results.get(0);
        }
        return relationships;
    }

//      ---------------------- Fields ------------------------

    public List<Fields> AllFields() {
        List<Fields> results = em.createQuery("SELECT o FROM Fields o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Fields>();
        }
        return results;
    }

    public Fields idFields(Long id) {

        Fields fields = new Fields();
        List<Fields> results = em.createQuery("SELECT o FROM Fields o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           fields = results.get(0);
        }
        return fields;
    }

//      ---------------------- DevelopmentsModels ------------------------

    public List<DevelopmentsModels> AllDevelopmentsModels() {
        List<DevelopmentsModels> results = em.createQuery("SELECT o FROM DevelopmentsModels o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<DevelopmentsModels>();
        }
        return results;
    }

    public DevelopmentsModels idDevelopmentsModels(Long id) {

        DevelopmentsModels developmentsModels = new DevelopmentsModels();
        List<DevelopmentsModels> results = em.createQuery("SELECT o FROM DevelopmentsModels o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           developmentsModels = results.get(0);
        }
        return developmentsModels;
    }

//      ---------------------- AttributesTypes ------------------------

    public List<AttributesTypes> AllAttributesTypes() {
        List<AttributesTypes> results = em.createQuery("SELECT o FROM AttributesTypes o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<AttributesTypes>();
        }
        return results;
    }

    public AttributesTypes idAttributesTypes(Long id) {

        AttributesTypes attributesTypes = new AttributesTypes();
        List<AttributesTypes> results = em.createQuery("SELECT o FROM AttributesTypes o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           attributesTypes = results.get(0);
        }
        return attributesTypes;
    }

//      ---------------------- Cardinalities ------------------------

    public List<Cardinalities> AllCardinalities() {
        List<Cardinalities> results = em.createQuery("SELECT o FROM Cardinalities o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Cardinalities>();
        }
        return results;
    }

    public Cardinalities idCardinalities(Long id) {

        Cardinalities cardinalities = new Cardinalities();
        List<Cardinalities> results = em.createQuery("SELECT o FROM Cardinalities o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           cardinalities = results.get(0);
        }
        return cardinalities;
    }

//      ---------------------- GroupIdsRelationships ------------------------

    public List<GroupIdsRelationships> AllGroupIdsRelationships() {
        List<GroupIdsRelationships> results = em.createQuery("SELECT o FROM GroupIdsRelationships o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<GroupIdsRelationships>();
        }
        return results;
    }

    public GroupIdsRelationships idGroupIdsRelationships(Long id) {

        GroupIdsRelationships groupIdsRelationships = new GroupIdsRelationships();
        List<GroupIdsRelationships> results = em.createQuery("SELECT o FROM GroupIdsRelationships o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           groupIdsRelationships = results.get(0);
        }
        return groupIdsRelationships;
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

//      ---------------------- Models ------------------------

    public List<Models> AllModels() {
        List<Models> results = em.createQuery("SELECT o FROM Models o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Models>();
        }
        return results;
    }

    public Models idModels(Long id) {

        Models models = new Models();
        List<Models> results = em.createQuery("SELECT o FROM Models o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           models = results.get(0);
        }
        return models;
    }

//      ---------------------- Dependencies ------------------------

    public List<Dependencies> AllDependencies() {
        List<Dependencies> results = em.createQuery("SELECT o FROM Dependencies o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Dependencies>();
        }
        return results;
    }

    public Dependencies idDependencies(Long id) {

        Dependencies dependencies = new Dependencies();
        List<Dependencies> results = em.createQuery("SELECT o FROM Dependencies o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           dependencies = results.get(0);
        }
        return dependencies;
    }

//      ---------------------- NameQueries ------------------------

    public List<NameQueries> AllNameQueries() {
        List<NameQueries> results = em.createQuery("SELECT o FROM NameQueries o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<NameQueries>();
        }
        return results;
    }

    public NameQueries idNameQueries(Long id) {

        NameQueries nameQueries = new NameQueries();
        List<NameQueries> results = em.createQuery("SELECT o FROM NameQueries o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           nameQueries = results.get(0);
        }
        return nameQueries;
    }

//      ---------------------- Developments ------------------------

    public List<Developments> AllDevelopments() {
        List<Developments> results = em.createQuery("SELECT o FROM Developments o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Developments>();
        }
        return results;
    }

    public Developments idDevelopments(Long id) {

        Developments developments = new Developments();
        List<Developments> results = em.createQuery("SELECT o FROM Developments o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           developments = results.get(0);
        }
        return developments;
    }

} // Fin de clase
