package com.simasoft.contab.setup;

import co.simasoft.models.contab.*;

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
@Named("setuph2bean")
public class SetupH2Bean {

    @PersistenceContext(unitName = "contabPU-JTA")
    private EntityManager em;

    private static final Logger log = Logger.getLogger(SetupH2Bean.class.getName());


    public void populateTest() {

        log.info("Please wait while preparing database data H2... ");

        Person p = new Person("Pedro","Perez");
        em.persist(p);
        em.flush();

        Pucs pucs = new Pucs("CUENTAS POR PAGAR");
        em.persist(pucs);
        em.flush();

        log.info("Database successfully populated H2... ");

    } // end : populateTest Method

}
