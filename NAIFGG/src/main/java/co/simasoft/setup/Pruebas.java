package co.simasoft.setup;

import co.simasoft.models.naif.DomainModels.*;

import java.util.*;

import java.util.Calendar;
import java.util.Random;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jboss.logging.Logger;

@Singleton
@LocalBean
@Named("Pruebas")
public class Pruebas {

    private static final String QUERYB = "SELECT c FROM Entities c WHERE c.name LIKE :custName";
    private static final String QUERYC = "SELECT c FROM Cardinalities c WHERE c.name LIKE :custName";

    @PersistenceContext(unitName = "DomainModelsPU-JTA")
    private EntityManager em;

    private static final Logger log = Logger.getLogger(Setup.class.getName());

    public Entities findEntities(String name) {

        Entities entities = new Entities();
        List<Entities> results = em.createQuery(QUERYB).setParameter("custName", name).getResultList();

        if (!results.isEmpty()) {
           entities = results.get(0);
        }
        return entities;
    }
    
    public Cardinalities findCardinalities(String name) {

        Cardinalities cardinalities = new Cardinalities();
        List<Cardinalities> results = em.createQuery(QUERYC).setParameter("custName", name).getResultList();

        if (!results.isEmpty()) {
           cardinalities = results.get(0);
        }
        return cardinalities;
    }

    public void data() {

        Entities from = new Entities();
        Cardinalities cardinalities = new Cardinalities();
        Entities   to = new Entities();

        from = findEntities("SystemsModels");
        cardinalities = findCardinalities("Uno a Muchos Bidirecccional No.5");
          to = findEntities("DomainModels");

        Relationships relationships = new Relationships();
        relationships.setFrom(from);
        relationships.setCardinalities(cardinalities);
        relationships.setTo(to);
        relationships.setOptionality(true);
        em.persist(relationships);
        em.flush();


    } // data()

} // DomainModelsSetup

