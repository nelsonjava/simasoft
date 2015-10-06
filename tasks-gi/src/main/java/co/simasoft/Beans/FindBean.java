package co.simasoft.beans;

import co.simasoft.models.dev.tasks.*;
import co.simasoft.models.core.persons.*;
import co.simasoft.models.core.archival.*;
import co.simasoft.models.core.sites.*;

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

    @PersistenceContext(unitName = "tasks-giPU-JTA")
    private EntityManager em;

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

//      ---------------------- Persons ------------------------

    public List<Persons> AllPersons() {
        List<Persons> results = em.createQuery("SELECT o FROM Persons o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Persons>();
        }
        return results;
    }

    public Persons idPersons(Long id) {

        Persons persons = new Persons();
        List<Persons> results = em.createQuery("SELECT o FROM Persons o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           persons = results.get(0);
        }
        return persons;
    }

//      ---------------------- Sections ------------------------

    public List<Sections> AllSections() {
        List<Sections> results = em.createQuery("SELECT o FROM Sections o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Sections>();
        }
        return results;
    }

    public Sections idSections(Long id) {

        Sections sections = new Sections();
        List<Sections> results = em.createQuery("SELECT o FROM Sections o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           sections = results.get(0);
        }
        return sections;
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

} // Fin de clase
