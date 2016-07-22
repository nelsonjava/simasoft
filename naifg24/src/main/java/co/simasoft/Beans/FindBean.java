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

    @PersistenceContext(unitName = "naifg24PU-JTA")
    private EntityManager em;
    
//      ---------------------- Developments ------------------------

    public Developments artifactIdDevelopments(String search,EntityManager em) {

        Developments dev = new Developments();
        List<Developments> results = em.createQuery("SELECT o FROM Developments o WHERE o.artifactId LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           dev = results.get(0);
        }
        return dev;
    }

//      ---------------------- Models ------------------------

    public List<Models> AllModels(EntityManager em) {
        List<Models> results = em.createQuery("SELECT o FROM Models o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Models>();
        }
        return results;
    }

    public Models idModels(Long id,EntityManager em) {

        Models models = new Models();
        List<Models> results = em.createQuery("SELECT o FROM Models o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           models = results.get(0);
        }
        return models;
    }

    public Models artifactIdModels(String search,EntityManager em) {

        Models models = new Models();
        List<Models> results = em.createQuery("SELECT o FROM Models o WHERE o.artifactId LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           models = results.get(0);
        }
        return models;
    }


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

    public Entities nameEntities(String search,EntityManager em) {

        Entities entities = new Entities();
        List<Entities> results = em.createQuery("SELECT o FROM Entities o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           entities = results.get(0);
        }
        return entities;
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

    public GroupIds artifactIdGroupIds(String search,EntityManager em) {

        GroupIds groupIds = new GroupIds();
        List<GroupIds> results = em.createQuery("SELECT o FROM GroupIds o WHERE o.artifactId LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           groupIds = results.get(0);
        }
        return groupIds;
    }


    public GroupIds groupGroupIds(String search,EntityManager em) {

        GroupIds groupId = new GroupIds();
        List<GroupIds> results = em.createQuery("SELECT o FROM GroupIds o WHERE o.groupId LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           groupId = results.get(0);
        }
        return groupId;
    }

//      ---------------------- AttributesTypes ------------------------

    public List<AttributesTypes> AllAttributesTypes(EntityManager em) {
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

    public List<Dependencies> AllDependencies(EntityManager em) {
        List<Dependencies> results = em.createQuery("SELECT o FROM Dependencies o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Dependencies>();
        }
        return results;
    }

    public Dependencies idDependencies(Long id,EntityManager em) {

        Dependencies dependencies = new Dependencies();
        List<Dependencies> results = em.createQuery("SELECT o FROM Dependencies o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           dependencies = results.get(0);
        }
        return dependencies;
    }

    public Dependencies artifactIdDependency(String search,EntityManager em) {

        Dependencies dependency = new Dependencies();
        List<Dependencies> results = em.createQuery("SELECT o FROM Dependencies o WHERE o.artifactId LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           dependency = results.get(0);
        }
        return dependency;
    }

//      ---------------------- NameQueries ------------------------

    public List<NameQueries> AllNameQueries(EntityManager em) {
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

    public List<Attributes> AllAttributes(EntityManager em) {
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

//      ---------------------- Cardinalities ------------------------

    public List<Cardinalities> AllCardinalities(EntityManager em) {
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

    public Cardinalities nameCardinalities(String search,EntityManager em) {

        Cardinalities cardinalities = new Cardinalities();
        List<Cardinalities> results = em.createQuery("SELECT o FROM Cardinalities o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           cardinalities = results.get(0);
        }
        return cardinalities;
    }

    public Cardinalities cardinalityCardinalities(String search,EntityManager em) {

        Cardinalities cardinalities = new Cardinalities();
        List<Cardinalities> results = em.createQuery("SELECT o FROM Cardinalities o WHERE o.cardinality LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           cardinalities = results.get(0);
        }
        return cardinalities;
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

    public Relationships relationships(Long idFrom,Long idTo,Long idCardinalities,EntityManager em) {

        Relationships relationships = new Relationships();

        String query = "SELECT o"+
                       "FROM Relationships o "+
                       "WHERE o.from.id          LIKE :idFrom and "+
                             "o.to.id            LIKE :idTo   and "+
                             "o.cardinalities.id LIKE :idCardinalities";
        List<Relationships> results = em.createQuery(query).
                                         setParameter("idFrom", idFrom).
                                         setParameter("idTo", idTo).
                                         setParameter("idCardinalities", idCardinalities).
                                         getResultList();

        if (!results.isEmpty()) {

           relationships = results.get(0);
        }
        return relationships;
    }

    public Relationships xrelationships(Long idFrom,Long idTo,Long idCardinalities,EntityManager em) {

        Relationships relationships = new Relationships();

/*
        String query = "SELECT o"+
                       "FROM Relationships o "+
                       "WHERE o.from.id          LIKE :idFrom";
*/


        String query = "SELECT o FROM Relationships o WHERE o.from.id LIKE :fromId and o.to.id LIKE :toId and o.cardinalities.id LIKE :cardinalitiesId";

        List<Relationships> results = em.createQuery(query).
                                         setParameter("fromId", idFrom).
                                         setParameter("toId", idTo).
                                         setParameter("cardinalitiesId", idCardinalities).
                                         getResultList();

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

    public Imports nameImports(String search,EntityManager em) {

        Imports imports = new Imports();
        List<Imports> results = em.createQuery("SELECT o FROM Imports o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           imports = results.get(0);
        }
        return imports;
    }


//      ---------------------- Otras Busquedas ------------------------

    public GroupIds groupIdGroupIds(String search,EntityManager em) {

        GroupIds groupIds = new GroupIds();
        List<GroupIds> results = em.createQuery("SELECT o FROM GroupIds o WHERE o.groupId LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           groupIds = results.get(0);
        }
        return groupIds;
    }

    public Attributes fieldAttributes(String search,EntityManager em) {

        Attributes attributes = new Attributes();
        List<Attributes> results = em.createQuery("SELECT o FROM Attributes o WHERE o.field LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           attributes = results.get(0);
        }
        return attributes;
    }

    public AttributesTypes nameAttributesTypes(String search,EntityManager em) {

        AttributesTypes attributesTypes = new AttributesTypes();
        List<AttributesTypes> results = em.createQuery("SELECT o FROM AttributesTypes o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           attributesTypes = results.get(0);
        }
        return attributesTypes;
    }

    public AttributesProperties nameAttributesProperties(String search,EntityManager em) {

        AttributesProperties attributesProperties = new AttributesProperties();
        List<AttributesProperties> results = em.createQuery("SELECT o FROM AttributesProperties o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           attributesProperties = results.get(0);
        }
        return attributesProperties;
    }

} // Fin de clase
