package com.simasoft.contab.setup;

import co.simasoft.models.contable.contabilidad.*;

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

    @PersistenceContext(unitName = "contabilidadPU-JTA")
    private EntityManager em;

    private static final Logger log = Logger.getLogger(SetupH2Bean.class.getName());


    public void populateTest() {

        log.info("Please wait while preparing database data H2... ");

        Pucs pucs = new Pucs();
        pucs.setNombre("CUENTAS POR COBRAR");
        em.persist(pucs);
        em.flush();

        Terceros terceros = new Terceros();
        terceros.setNit("214070");
        terceros.setNombre("ABRIL GUTIERREZ DANIEL ALEJANDRO");
        em.persist(terceros);
        em.flush();

        Movimientos movimientos = new Movimientos();
        movimientos.setDetalle("CAUSACION RECIBO DE PENSION MES DE FEBRERO");
        movimientos.setPucs(pucs);
        movimientos.setTerceros(terceros);
        em.persist(movimientos);
        em.flush();

        Saldos saldos = new Saldos();
        saldos.setCreditos(651073);
        saldos.setPucs(pucs);
        saldos.setTerceros(terceros);
        em.persist(saldos);
        em.flush();

        log.info("Database successfully populated H2... ");


    } // end : populateTest Method

}




