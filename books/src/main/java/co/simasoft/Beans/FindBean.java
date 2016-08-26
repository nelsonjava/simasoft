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

    @PersistenceContext(unitName = "booksPU-JTA")
    private EntityManager em;

//      ---------------------- BooksTypes ------------------------

    public List<BooksTypes> AllBooksTypes() {
        List<BooksTypes> results = em.createQuery("SELECT o FROM BooksTypes o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<BooksTypes>();
        }
        return results;
    }

    public BooksTypes idBooksTypes(Long id) {

        BooksTypes booksTypes = new BooksTypes();
        List<BooksTypes> results = em.createQuery("SELECT o FROM BooksTypes o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           booksTypes = results.get(0);
        }
        return booksTypes;
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

//      ---------------------- Chapters ------------------------

    public List<Chapters> AllChapters() {
        List<Chapters> results = em.createQuery("SELECT o FROM Chapters o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Chapters>();
        }
        return results;
    }

    public Chapters idChapters(Long id) {

        Chapters chapters = new Chapters();
        List<Chapters> results = em.createQuery("SELECT o FROM Chapters o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           chapters = results.get(0);
        }
        return chapters;
    }

//      ---------------------- Books ------------------------

    public List<Books> AllBooks() {
        List<Books> results = em.createQuery("SELECT o FROM Books o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Books>();
        }
        return results;
    }

    public Books idBooks(Long id) {

        Books books = new Books();
        List<Books> results = em.createQuery("SELECT o FROM Books o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           books = results.get(0);
        }
        return books;
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
