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

    @PersistenceContext(unitName = "pruebasPU-JTA")
    private EntityManager em;

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

    public Employees codeEmployees(String search,EntityManager em) {

        Employees employees = new Employees();
        List<Employees> results = em.createQuery("SELECT o FROM Employees o WHERE o.code LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           employees = results.get(0);
        }
        return employees;
    }

//      ---------------------- Predio ------------------------

    public List<Predio> AllPredio() {
        List<Predio> results = em.createQuery("SELECT o FROM Predio o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Predio>();
        }
        return results;
    }

    public Predio idPredio(Long id) {

        Predio predio = new Predio();
        List<Predio> results = em.createQuery("SELECT o FROM Predio o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           predio = results.get(0);
        }
        return predio;
    }

    public Predio nomenclaturaPredio(String search,EntityManager em) {

        Predio predio = new Predio();
        List<Predio> results = em.createQuery("SELECT o FROM Predio o WHERE o.nomenclatura LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           predio = results.get(0);
        }
        return predio;
    }

    public Predio predialPredio(String search,EntityManager em) {

        Predio predio = new Predio();
        List<Predio> results = em.createQuery("SELECT o FROM Predio o WHERE o.predial LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           predio = results.get(0);
        }
        return predio;
    }

    public Predio estratoPredio(String search,EntityManager em) {

        Predio predio = new Predio();
        List<Predio> results = em.createQuery("SELECT o FROM Predio o WHERE o.estrato LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           predio = results.get(0);
        }
        return predio;
    }

    public Predio matriculaPredio(String search,EntityManager em) {

        Predio predio = new Predio();
        List<Predio> results = em.createQuery("SELECT o FROM Predio o WHERE o.matricula LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           predio = results.get(0);
        }
        return predio;
    }

//      ---------------------- PhysicalSpaces ------------------------

    public List<PhysicalSpaces> AllPhysicalSpaces() {
        List<PhysicalSpaces> results = em.createQuery("SELECT o FROM PhysicalSpaces o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<PhysicalSpaces>();
        }
        return results;
    }

    public PhysicalSpaces idPhysicalSpaces(Long id) {

        PhysicalSpaces physicalSpaces = new PhysicalSpaces();
        List<PhysicalSpaces> results = em.createQuery("SELECT o FROM PhysicalSpaces o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           physicalSpaces = results.get(0);
        }
        return physicalSpaces;
    }

    public PhysicalSpaces namePhysicalSpaces(String search,EntityManager em) {

        PhysicalSpaces physicalSpaces = new PhysicalSpaces();
        List<PhysicalSpaces> results = em.createQuery("SELECT o FROM PhysicalSpaces o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           physicalSpaces = results.get(0);
        }
        return physicalSpaces;
    }

    public PhysicalSpaces codePhysicalSpaces(String search,EntityManager em) {

        PhysicalSpaces physicalSpaces = new PhysicalSpaces();
        List<PhysicalSpaces> results = em.createQuery("SELECT o FROM PhysicalSpaces o WHERE o.code LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           physicalSpaces = results.get(0);
        }
        return physicalSpaces;
    }

    public PhysicalSpaces telExtPhysicalSpaces(String search,EntityManager em) {

        PhysicalSpaces physicalSpaces = new PhysicalSpaces();
        List<PhysicalSpaces> results = em.createQuery("SELECT o FROM PhysicalSpaces o WHERE o.telExt LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           physicalSpaces = results.get(0);
        }
        return physicalSpaces;
    }

//      ---------------------- PhysicalSpacesTypes ------------------------

    public List<PhysicalSpacesTypes> AllPhysicalSpacesTypes() {
        List<PhysicalSpacesTypes> results = em.createQuery("SELECT o FROM PhysicalSpacesTypes o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<PhysicalSpacesTypes>();
        }
        return results;
    }

    public PhysicalSpacesTypes idPhysicalSpacesTypes(Long id) {

        PhysicalSpacesTypes physicalSpacesTypes = new PhysicalSpacesTypes();
        List<PhysicalSpacesTypes> results = em.createQuery("SELECT o FROM PhysicalSpacesTypes o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           physicalSpacesTypes = results.get(0);
        }
        return physicalSpacesTypes;
    }

    public PhysicalSpacesTypes namePhysicalSpacesTypes(String search,EntityManager em) {

        PhysicalSpacesTypes physicalSpacesTypes = new PhysicalSpacesTypes();
        List<PhysicalSpacesTypes> results = em.createQuery("SELECT o FROM PhysicalSpacesTypes o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           physicalSpacesTypes = results.get(0);
        }
        return physicalSpacesTypes;
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

    public PhysicalAreas namePhysicalAreas(String search,EntityManager em) {

        PhysicalAreas physicalAreas = new PhysicalAreas();
        List<PhysicalAreas> results = em.createQuery("SELECT o FROM PhysicalAreas o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           physicalAreas = results.get(0);
        }
        return physicalAreas;
    }

    public PhysicalAreas codePhysicalAreas(String search,EntityManager em) {

        PhysicalAreas physicalAreas = new PhysicalAreas();
        List<PhysicalAreas> results = em.createQuery("SELECT o FROM PhysicalAreas o WHERE o.code LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           physicalAreas = results.get(0);
        }
        return physicalAreas;
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

    public PhysicalAreasTypes namePhysicalAreasTypes(String search,EntityManager em) {

        PhysicalAreasTypes physicalAreasTypes = new PhysicalAreasTypes();
        List<PhysicalAreasTypes> results = em.createQuery("SELECT o FROM PhysicalAreasTypes o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           physicalAreasTypes = results.get(0);
        }
        return physicalAreasTypes;
    }

} // Fin de clase
