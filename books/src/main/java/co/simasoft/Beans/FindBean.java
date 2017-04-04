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

    public BooksTypes nameBooksTypes(String search,EntityManager em) {

        BooksTypes booksTypes = new BooksTypes();
        List<BooksTypes> results = em.createQuery("SELECT o FROM BooksTypes o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           booksTypes = results.get(0);
        }
        return booksTypes;
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

    public Books codeBooks(String search,EntityManager em) {

        Books books = new Books();
        List<Books> results = em.createQuery("SELECT o FROM Books o WHERE o.code LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           books = results.get(0);
        }
        return books;
    }

    public Books nameBooks(String search,EntityManager em) {

        Books books = new Books();
        List<Books> results = em.createQuery("SELECT o FROM Books o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           books = results.get(0);
        }
        return books;
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

    public Chapters codeChapters(String search,EntityManager em) {

        Chapters chapters = new Chapters();
        List<Chapters> results = em.createQuery("SELECT o FROM Chapters o WHERE o.code LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           chapters = results.get(0);
        }
        return chapters;
    }

    public Chapters nameChapters(String search,EntityManager em) {

        Chapters chapters = new Chapters();
        List<Chapters> results = em.createQuery("SELECT o FROM Chapters o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           chapters = results.get(0);
        }
        return chapters;
    }

//      ---------------------- TypesFilms ------------------------

    public List<TypesFilms> AllTypesFilms() {
        List<TypesFilms> results = em.createQuery("SELECT o FROM TypesFilms o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<TypesFilms>();
        }
        return results;
    }

    public TypesFilms idTypesFilms(Long id) {

        TypesFilms typesFilms = new TypesFilms();
        List<TypesFilms> results = em.createQuery("SELECT o FROM TypesFilms o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           typesFilms = results.get(0);
        }
        return typesFilms;
    }

    public TypesFilms nameTypesFilms(String search,EntityManager em) {

        TypesFilms typesFilms = new TypesFilms();
        List<TypesFilms> results = em.createQuery("SELECT o FROM TypesFilms o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           typesFilms = results.get(0);
        }
        return typesFilms;
    }

//      ---------------------- Films ------------------------

    public List<Films> AllFilms() {
        List<Films> results = em.createQuery("SELECT o FROM Films o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Films>();
        }
        return results;
    }

    public Films idFilms(Long id) {

        Films films = new Films();
        List<Films> results = em.createQuery("SELECT o FROM Films o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           films = results.get(0);
        }
        return films;
    }

    public Films nameFilms(String search,EntityManager em) {

        Films films = new Films();
        List<Films> results = em.createQuery("SELECT o FROM Films o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           films = results.get(0);
        }
        return films;
    }

//      ---------------------- Videos ------------------------

    public List<Videos> AllVideos() {
        List<Videos> results = em.createQuery("SELECT o FROM Videos o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Videos>();
        }
        return results;
    }

    public Videos idVideos(Long id) {

        Videos videos = new Videos();
        List<Videos> results = em.createQuery("SELECT o FROM Videos o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           videos = results.get(0);
        }
        return videos;
    }

    public Videos nameVideos(String search,EntityManager em) {

        Videos videos = new Videos();
        List<Videos> results = em.createQuery("SELECT o FROM Videos o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           videos = results.get(0);
        }
        return videos;
    }

    public Videos timeVideos(String search,EntityManager em) {

        Videos videos = new Videos();
        List<Videos> results = em.createQuery("SELECT o FROM Videos o WHERE o.time LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           videos = results.get(0);
        }
        return videos;
    }

//      ---------------------- VideoContents ------------------------

    public List<VideoContents> AllVideoContents() {
        List<VideoContents> results = em.createQuery("SELECT o FROM VideoContents o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<VideoContents>();
        }
        return results;
    }

    public VideoContents idVideoContents(Long id) {

        VideoContents videoContents = new VideoContents();
        List<VideoContents> results = em.createQuery("SELECT o FROM VideoContents o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           videoContents = results.get(0);
        }
        return videoContents;
    }

    public VideoContents nameVideoContents(String search,EntityManager em) {

        VideoContents videoContents = new VideoContents();
        List<VideoContents> results = em.createQuery("SELECT o FROM VideoContents o WHERE o.name LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           videoContents = results.get(0);
        }
        return videoContents;
    }

    public VideoContents startTimeVideoContents(String search,EntityManager em) {

        VideoContents videoContents = new VideoContents();
        List<VideoContents> results = em.createQuery("SELECT o FROM VideoContents o WHERE o.startTime LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           videoContents = results.get(0);
        }
        return videoContents;
    }

    public VideoContents endTimeVideoContents(String search,EntityManager em) {

        VideoContents videoContents = new VideoContents();
        List<VideoContents> results = em.createQuery("SELECT o FROM VideoContents o WHERE o.endTime LIKE :field").setParameter("field", search).getResultList();

        if (!results.isEmpty()) {
           videoContents = results.get(0);
        }
        return videoContents;
    }

} // Fin de clase
