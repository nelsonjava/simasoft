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

    @PersistenceContext(unitName = "relationships2PU-JTA")
    private EntityManager em;

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

} // Fin de clase
