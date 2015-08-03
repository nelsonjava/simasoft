package co.simasoft.beans;

import co.simasoft.models.dev.naifg.dependencies.*;

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

    @PersistenceContext(unitName = "naifgPU-JTA")
    private EntityManager em;

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

    public Dependencies artifactIdDependency(String search,EntityManager em) {

        Dependencies dependency = new Dependencies();
        List<Dependencies> results = em.createQuery("SELECT o FROM Dependencies o WHERE o.artifactId LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           dependency = results.get(0);
        }
        return dependency;
    }

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
    
    public Imports nameImports(String search,EntityManager em) {

        Imports imports = new Imports();
        List<Imports> results = em.createQuery("SELECT o FROM Imports o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           imports = results.get(0);
        }
        return imports;
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
    
    public AttributesProperties nameAttributesProperties(String search,EntityManager em) {

        AttributesProperties propertiesAttributes = new AttributesProperties();
        List<AttributesProperties> results = em.createQuery("SELECT o FROM AttributesProperties o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           propertiesAttributes = results.get(0);
        }
        return propertiesAttributes;
    }

} // Fin de clase
