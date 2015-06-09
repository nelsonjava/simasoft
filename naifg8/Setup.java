package co.simasoft.setup;

import co.simasoft.utils.*;
import co.simasoft.beans.*;

import co.simasoft.models.naif.domainmodels.*;

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
@Named("Setup")
public class Setup extends FileTxt {

    private static final String QUERYC = "SELECT c FROM Cardinalities c WHERE c.name LIKE :custName";

    @PersistenceContext(unitName = "naifg8PU-JTA")
    private EntityManager em;

    private static final Logger log = Logger.getLogger(Setup.class.getName());

    public void data() {
    try {

        System.out.println("Hello World Setup!");

        clearFileTxt();
        Naifg8Bean naifg8Bean = new Naifg8Bean();

        int i=0;
        List<Cardinalities> cardinalities;

        cardinalities = naifg8Bean.selectAllCardinalities();

        for (Cardinalities cardinality : cardinalities) {
line("        Cardinalities cardinality"+String.valueOf(++i)+" = new Cardinalities();");
        } // Cardinalities


line("        PASO");
        Cardinalities cardinality = new Cardinalities();
        cardinality = findCardinalities("Uno a Muchos Bidirecccional No.5");
line(cardinality.getName());

        saveFile("\\docs", "Setup.java");

    } // try
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    } // data

    public Cardinalities findCardinalities(String name) {

        Cardinalities cardinalities = new Cardinalities();
        List<Cardinalities> results = em.createQuery(QUERYC).setParameter("custName", name).getResultList();

        if (!results.isEmpty()) {
           cardinalities = results.get(0);
        }
        return cardinalities;
    }

} // Setup
