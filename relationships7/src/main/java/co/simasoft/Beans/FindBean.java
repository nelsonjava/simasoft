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

    @PersistenceContext(unitName = "relationships7PU-JTA")
    private EntityManager em;

//      ---------------------- IpAddress ------------------------

    public List<IpAddress> AllIpAddress() {
        List<IpAddress> results = em.createQuery("SELECT o FROM IpAddress o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<IpAddress>();
        }
        return results;
    }

    public IpAddress idIpAddress(Long id) {

        IpAddress ipAddress = new IpAddress();
        List<IpAddress> results = em.createQuery("SELECT o FROM IpAddress o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           ipAddress = results.get(0);
        }
        return ipAddress;
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

} // Fin de clase
