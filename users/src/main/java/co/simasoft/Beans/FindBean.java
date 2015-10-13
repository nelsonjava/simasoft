package co.simasoft.beans;

import co.simasoft.models.dev.users.*;

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

    @PersistenceContext(unitName = "usersPU-JTA")
    private EntityManager em;

//      ---------------------- Users ------------------------

    public List<Users> AllUsers() {
        List<Users> results = em.createQuery("SELECT o FROM Users o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Users>();
        }
        return results;
    }

    public Users idUsers(Long id) {

        Users users = new Users();
        List<Users> results = em.createQuery("SELECT o FROM Users o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           users = results.get(0);
        }
        return users;
    }

} // Fin de clase
