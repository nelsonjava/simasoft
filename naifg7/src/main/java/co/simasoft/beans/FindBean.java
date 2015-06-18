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

@Stateless
@LocalBean
public class FindBean {

    @PersistenceContext(unitName = "naifg7PU-JTA")
    private EntityManager em;

//      ---------------------- Entities ------------------------

    public List<Entities> AllEntities(EntityManager em) {
        List<Entities> results = em.createQuery("SELECT o FROM Entities o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Entities>();
        }
        return results;
    }

    public Entities idEntities(Long id,EntityManager em) {

        Entities entities = new Entities();
        List<Entities> results = em.createQuery("SELECT o FROM Entities o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           entities = results.get(0);
        }
        return entities;
    }

//      ---------------------- DomainModels ------------------------

    public List<DomainModels> AllDomainModels(EntityManager em) {
        List<DomainModels> results = em.createQuery("SELECT o FROM DomainModels o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<DomainModels>();
        }
        return results;
    }

    public DomainModels idDomainModels(Long id,EntityManager em) {

        DomainModels domainModels = new DomainModels();
        List<DomainModels> results = em.createQuery("SELECT o FROM DomainModels o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           domainModels = results.get(0);
        }
        return domainModels;
    }

//      ---------------------- AttributesProperties ------------------------

    public List<AttributesProperties> AllAttributesProperties(EntityManager em) {
        List<AttributesProperties> results = em.createQuery("SELECT o FROM AttributesProperties o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<AttributesProperties>();
        }
        return results;
    }

    public AttributesProperties idAttributesProperties(Long id,EntityManager em) {

        AttributesProperties attributesProperties = new AttributesProperties();
        List<AttributesProperties> results = em.createQuery("SELECT o FROM AttributesProperties o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           attributesProperties = results.get(0);
        }
        return attributesProperties;
    }

//      ---------------------- GroupIds ------------------------

    public List<GroupIds> AllGroupIds(EntityManager em) {
        List<GroupIds> results = em.createQuery("SELECT o FROM GroupIds o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<GroupIds>();
        }
        return results;
    }

    public GroupIds idGroupIds(Long id,EntityManager em) {

        GroupIds groupIds = new GroupIds();
        List<GroupIds> results = em.createQuery("SELECT o FROM GroupIds o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           groupIds = results.get(0);
        }
        return groupIds;
    }

//      ---------------------- AttributesTypes ------------------------

    public List<AttributesTypes> AllAttributesTypes() {
        List<AttributesTypes> results = em.createQuery("SELECT o FROM AttributesTypes o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<AttributesTypes>();
        }
        return results;
    }

    public AttributesTypes idAttributesTypes(Long id,EntityManager em) {

        AttributesTypes attributesTypes = new AttributesTypes();
        List<AttributesTypes> results = em.createQuery("SELECT o FROM AttributesTypes o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           attributesTypes = results.get(0);
        }
        return attributesTypes;
    }

//      ---------------------- Dependency ------------------------

    public List<Dependency> AllDependency() {
        List<Dependency> results = em.createQuery("SELECT o FROM Dependency o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Dependency>();
        }
        return results;
    }

    public Dependency idDependency(Long id,EntityManager em) {

        Dependency dependency = new Dependency();
        List<Dependency> results = em.createQuery("SELECT o FROM Dependency o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           dependency = results.get(0);
        }
        return dependency;
    }

//      ---------------------- LinksTypes ------------------------

    public List<LinksTypes> AllLinksTypes() {
        List<LinksTypes> results = em.createQuery("SELECT o FROM LinksTypes o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<LinksTypes>();
        }
        return results;
    }

    public LinksTypes idLinksTypes(Long id,EntityManager em) {

        LinksTypes linksTypes = new LinksTypes();
        List<LinksTypes> results = em.createQuery("SELECT o FROM LinksTypes o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           linksTypes = results.get(0);
        }
        return linksTypes;
    }

//      ---------------------- NameQueries ------------------------

    public List<NameQueries> AllNameQueries() {
        List<NameQueries> results = em.createQuery("SELECT o FROM NameQueries o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<NameQueries>();
        }
        return results;
    }

    public NameQueries idNameQueries(Long id,EntityManager em) {

        NameQueries nameQueries = new NameQueries();
        List<NameQueries> results = em.createQuery("SELECT o FROM NameQueries o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           nameQueries = results.get(0);
        }
        return nameQueries;
    }

//      ---------------------- Attributes ------------------------

    public List<Attributes> AllAttributes() {
        List<Attributes> results = em.createQuery("SELECT o FROM Attributes o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Attributes>();
        }
        return results;
    }

    public Attributes idAttributes(Long id,EntityManager em) {

        Attributes attributes = new Attributes();
        List<Attributes> results = em.createQuery("SELECT o FROM Attributes o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           attributes = results.get(0);
        }
        return attributes;
    }

//      ---------------------- FilesModels ------------------------

    public List<FilesModels> AllFilesModels() {
        List<FilesModels> results = em.createQuery("SELECT o FROM FilesModels o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<FilesModels>();
        }
        return results;
    }

    public FilesModels idFilesModels(Long id,EntityManager em) {

        FilesModels filesModels = new FilesModels();
        List<FilesModels> results = em.createQuery("SELECT o FROM FilesModels o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           filesModels = results.get(0);
        }
        return filesModels;
    }

//      ---------------------- Cardinalities ------------------------

    public List<Cardinalities> AllCardinalities() {
        List<Cardinalities> results = em.createQuery("SELECT o FROM Cardinalities o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Cardinalities>();
        }
        return results;
    }

    public Cardinalities idCardinalities(Long id,EntityManager em) {

        Cardinalities cardinalities = new Cardinalities();
        List<Cardinalities> results = em.createQuery("SELECT o FROM Cardinalities o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           cardinalities = results.get(0);
        }
        return cardinalities;
    }

//      ---------------------- SystemsModels ------------------------

    public List<SystemsModels> AllSystemsModels(EntityManager em) {
        List<SystemsModels> results = em.createQuery("SELECT o FROM SystemsModels o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<SystemsModels>();
        }
        return results;
    }

    public SystemsModels idSystemsModels(Long id,EntityManager em) {

        SystemsModels systemsModels = new SystemsModels();
        List<SystemsModels> results = em.createQuery("SELECT o FROM SystemsModels o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           systemsModels = results.get(0);
        }
        return systemsModels;
    }

//      ---------------------- Relationships ------------------------

    public List<Relationships> AllRelationships(EntityManager em) {
        List<Relationships> results = em.createQuery("SELECT o FROM Relationships o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Relationships>();
        }
        return results;
    }

    public Relationships idRelationships(Long id,EntityManager em) {

        Relationships relationships = new Relationships();
        List<Relationships> results = em.createQuery("SELECT o FROM Relationships o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           relationships = results.get(0);
        }
        return relationships;
    }

//      ---------------------- Imports ------------------------

    public List<Imports> AllImports(EntityManager em) {
        List<Imports> results = em.createQuery("SELECT o FROM Imports o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Imports>();
        }
        return results;
    }

    public Imports idImports(Long id,EntityManager em) {

        Imports imports = new Imports();
        List<Imports> results = em.createQuery("SELECT o FROM Imports o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           imports = results.get(0);
        }
        return imports;
    }

//      ---------------------- Links ------------------------

    public List<Links> AllLinks(EntityManager em) {
        List<Links> results = em.createQuery("SELECT o FROM Links o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Links>();
        }
        return results;
    }

    public Links idLinks(Long id,EntityManager em) {

        Links links = new Links();
        List<Links> results = em.createQuery("SELECT o FROM Links o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           links = results.get(0);
        }
        return links;
    }

//      ---------------------- Otras Busquedas ------------------------

    public SystemsModels nameSystemsModels(String search,EntityManager em) {

        SystemsModels systemsModels = new SystemsModels();
        List<SystemsModels> results = em.createQuery("SELECT o FROM SystemsModels o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           systemsModels = results.get(0);
        }
        return systemsModels;
    }

    public DomainModels artifactIdDomainModels(String search,EntityManager em) {

        DomainModels domainModels = new DomainModels();
        List<DomainModels> results = em.createQuery("SELECT o FROM DomainModels o WHERE o.artifactId LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           domainModels = results.get(0);
        }
        return domainModels;
    }

    public GroupIds groupIdGroupIds(String search,EntityManager em) {

        GroupIds groupIds = new GroupIds();
        List<GroupIds> results = em.createQuery("SELECT o FROM GroupIds o WHERE o.groupId LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           groupIds = results.get(0);
        }
        return groupIds;
    }

    public Entities nameEntities(String search,EntityManager em) {

        Entities entities = new Entities();
        List<Entities> results = em.createQuery("SELECT o FROM Entities o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           entities = results.get(0);
        }
        return entities;
    }

    public Attributes fieldAttributes(String search,EntityManager em) {

        Attributes attributes = new Attributes();
        List<Attributes> results = em.createQuery("SELECT o FROM Attributes o WHERE o.field LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           attributes = results.get(0);
        }
        return attributes;
    }

    public Dependency artifactIdDependency(String search,EntityManager em) {

        Dependency dependency = new Dependency();
        List<Dependency> results = em.createQuery("SELECT o FROM Dependency o WHERE o.artifactId LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           dependency = results.get(0);
        }
        return dependency;
    }

    public AttributesProperties nameAttributesProperties(String search,EntityManager em) {

        AttributesProperties propertiesAttributes = new AttributesProperties();
        List<AttributesProperties> results = em.createQuery("SELECT o FROM AttributesProperties o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           propertiesAttributes = results.get(0);
        }
        return propertiesAttributes;
    }

} // Fin de clase
