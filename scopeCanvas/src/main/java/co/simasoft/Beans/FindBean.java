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

    @PersistenceContext(unitName = "scopeCanvasPU-JTA")
    private EntityManager em;

//      ---------------------- ScopeCanvas ------------------------

    public List<ScopeCanvas> AllScopeCanvas() {
        List<ScopeCanvas> results = em.createQuery("SELECT o FROM ScopeCanvas o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<ScopeCanvas>();
        }
        return results;
    }

    public ScopeCanvas idScopeCanvas(Long id) {

        ScopeCanvas scopeCanvas = new ScopeCanvas();
        List<ScopeCanvas> results = em.createQuery("SELECT o FROM ScopeCanvas o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           scopeCanvas = results.get(0);
        }
        return scopeCanvas;
    }

//      ---------------------- Postits ------------------------

    public List<Postits> AllPostits() {
        List<Postits> results = em.createQuery("SELECT o FROM Postits o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Postits>();
        }
        return results;
    }

    public Postits idPostits(Long id) {

        Postits postits = new Postits();
        List<Postits> results = em.createQuery("SELECT o FROM Postits o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           postits = results.get(0);
        }
        return postits;
    }

//      ---------------------- SectionsScopeCanvas ------------------------

    public List<SectionsScopeCanvas> AllSectionsScopeCanvas() {
        List<SectionsScopeCanvas> results = em.createQuery("SELECT o FROM SectionsScopeCanvas o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<SectionsScopeCanvas>();
        }
        return results;
    }

    public SectionsScopeCanvas idSectionsScopeCanvas(Long id) {

        SectionsScopeCanvas sectionsScopeCanvas = new SectionsScopeCanvas();
        List<SectionsScopeCanvas> results = em.createQuery("SELECT o FROM SectionsScopeCanvas o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           sectionsScopeCanvas = results.get(0);
        }
        return sectionsScopeCanvas;
    }

} // Fin de clase
