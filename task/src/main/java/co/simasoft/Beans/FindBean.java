package co.simasoft.beans;

import co.simasoft.models.naif.task.activities.*;

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

    @PersistenceContext(unitName = "taskPU-JTA")
    private EntityManager em;

//      ---------------------- Calendars ------------------------

    public List<Calendars> AllCalendars() {
        List<Calendars> results = em.createQuery("SELECT o FROM Calendars o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Calendars>();
        }
        return results;
    }

    public Calendars idCalendars(Long id) {

        Calendars calendars = new Calendars();
        List<Calendars> results = em.createQuery("SELECT o FROM Calendars o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           calendars = results.get(0);
        }
        return calendars;
    }

//      ---------------------- ActivitiesTypes ------------------------

    public List<ActivitiesTypes> AllActivitiesTypes() {
        List<ActivitiesTypes> results = em.createQuery("SELECT o FROM ActivitiesTypes o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<ActivitiesTypes>();
        }
        return results;
    }

    public ActivitiesTypes idActivitiesTypes(Long id) {

        ActivitiesTypes activitiesTypes = new ActivitiesTypes();
        List<ActivitiesTypes> results = em.createQuery("SELECT o FROM ActivitiesTypes o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           activitiesTypes = results.get(0);
        }
        return activitiesTypes;
    }

//      ---------------------- Tasks ------------------------

    public List<Tasks> AllTasks() {
        List<Tasks> results = em.createQuery("SELECT o FROM Tasks o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Tasks>();
        }
        return results;
    }

    public Tasks idTasks(Long id) {

        Tasks tasks = new Tasks();
        List<Tasks> results = em.createQuery("SELECT o FROM Tasks o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           tasks = results.get(0);
        }
        return tasks;
    }

//      ---------------------- Guides ------------------------

    public List<Guides> AllGuides() {
        List<Guides> results = em.createQuery("SELECT o FROM Guides o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Guides>();
        }
        return results;
    }

    public Guides idGuides(Long id) {

        Guides guides = new Guides();
        List<Guides> results = em.createQuery("SELECT o FROM Guides o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           guides = results.get(0);
        }
        return guides;
    }

//      ---------------------- Diaries ------------------------

    public List<Diaries> AllDiaries() {
        List<Diaries> results = em.createQuery("SELECT o FROM Diaries o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Diaries>();
        }
        return results;
    }

    public Diaries idDiaries(Long id) {

        Diaries diaries = new Diaries();
        List<Diaries> results = em.createQuery("SELECT o FROM Diaries o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           diaries = results.get(0);
        }
        return diaries;
    }

//      ---------------------- Activities ------------------------

    public List<Activities> AllActivities() {
        List<Activities> results = em.createQuery("SELECT o FROM Activities o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Activities>();
        }
        return results;
    }

    public Activities idActivities(Long id) {

        Activities activities = new Activities();
        List<Activities> results = em.createQuery("SELECT o FROM Activities o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           activities = results.get(0);
        }
        return activities;
    }

} // Fin de clase
