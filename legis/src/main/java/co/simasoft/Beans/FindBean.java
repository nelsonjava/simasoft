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

    @PersistenceContext(unitName = "legisPU-JTA")
    private EntityManager em;

//      ---------------------- LegisArtSubject ------------------------

    public List<LegisArtSubject> AllLegisArtSubject() {
        List<LegisArtSubject> results = em.createQuery("SELECT o FROM LegisArtSubject o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<LegisArtSubject>();
        }
        return results;
    }

    public LegisArtSubject idLegisArtSubject(Long id) {

        LegisArtSubject legisArtSubject = new LegisArtSubject();
        List<LegisArtSubject> results = em.createQuery("SELECT o FROM LegisArtSubject o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           legisArtSubject = results.get(0);
        }
        return legisArtSubject;
    }

//      ---------------------- LegisTypes ------------------------

    public List<LegisTypes> AllLegisTypes() {
        List<LegisTypes> results = em.createQuery("SELECT o FROM LegisTypes o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<LegisTypes>();
        }
        return results;
    }

    public LegisTypes idLegisTypes(Long id) {

        LegisTypes legisTypes = new LegisTypes();
        List<LegisTypes> results = em.createQuery("SELECT o FROM LegisTypes o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           legisTypes = results.get(0);
        }
        return legisTypes;
    }

//      ---------------------- Legis ------------------------

    public List<Legis> AllLegis() {
        List<Legis> results = em.createQuery("SELECT o FROM Legis o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Legis>();
        }
        return results;
    }

    public Legis idLegis(Long id) {

        Legis legis = new Legis();
        List<Legis> results = em.createQuery("SELECT o FROM Legis o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           legis = results.get(0);
        }
        return legis;
    }

//      ---------------------- LegisArt ------------------------

    public List<LegisArt> AllLegisArt() {
        List<LegisArt> results = em.createQuery("SELECT o FROM LegisArt o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<LegisArt>();
        }
        return results;
    }

    public LegisArt idLegisArt(Long id) {

        LegisArt legisArt = new LegisArt();
        List<LegisArt> results = em.createQuery("SELECT o FROM LegisArt o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           legisArt = results.get(0);
        }
        return legisArt;
    }

//      ---------------------- LegisSubject ------------------------

    public List<LegisSubject> AllLegisSubject() {
        List<LegisSubject> results = em.createQuery("SELECT o FROM LegisSubject o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<LegisSubject>();
        }
        return results;
    }

    public LegisSubject idLegisSubject(Long id) {

        LegisSubject legisSubject = new LegisSubject();
        List<LegisSubject> results = em.createQuery("SELECT o FROM LegisSubject o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           legisSubject = results.get(0);
        }
        return legisSubject;
    }

//      ---------------------- LegisTopic ------------------------

    public List<LegisTopic> AllLegisTopic() {
        List<LegisTopic> results = em.createQuery("SELECT o FROM LegisTopic o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<LegisTopic>();
        }
        return results;
    }

    public LegisTopic idLegisTopic(Long id) {

        LegisTopic legisTopic = new LegisTopic();
        List<LegisTopic> results = em.createQuery("SELECT o FROM LegisTopic o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           legisTopic = results.get(0);
        }
        return legisTopic;
    }

} // Fin de clase
