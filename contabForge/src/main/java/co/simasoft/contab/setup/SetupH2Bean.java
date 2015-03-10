package com.simasoft.contab.setup;

import co.simasoft.models.base.direcciones.*;
import co.simasoft.models.base.paises.*;
import co.simasoft.models.base.empresas.*;
import co.simasoft.models.base.mails.*;
import co.simasoft.models.base.nits.*;
import co.simasoft.models.base.permisos.*;
import co.simasoft.models.base.personas.*;
import co.simasoft.models.base.sistemas.*;
import co.simasoft.models.base.telefonos.*;
import co.simasoft.models.base.usuarios.*;
import co.simasoft.models.iso.lmd.*;
import co.simasoft.models.iso.lmr.*;
import co.simasoft.models.iso.procesos.*;
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

        TiposProcesos tiposProcesos = new TiposProcesos();
        tiposProcesos.setNombre("PROCESO DIRECTIVO");
        em.persist(tiposProcesos);
        em.flush();

        tiposProcesos.setNombre("PROCESOS DE MISIONALES");
        em.persist(tiposProcesos);
        em.flush();

        tiposProcesos.setNombre("PROCESOS DE APOYO");
        em.persist(tiposProcesos);
        em.flush();

        tiposProcesos.setNombre("PROCESO DE SEGUIMIENTO Y MEDICION");
        em.persist(tiposProcesos);
        em.flush();

        Procesos procesos = new Procesos();
        procesos.setCodigo("GD");
        procesos.setNombre("GESTION DIRECTIVA");
        em.persist(procesos);
        em.flush();

        procesos.setCodigo("AM");
        procesos.setNombre("ADMISIONES Y MATRICULAS");
        em.persist(procesos);
        em.flush();

        procesos.setCodigo("GE");
        procesos.setNombre("GESTION EDUCATIVA");
        em.persist(procesos);
        em.flush();

        procesos.setCodigo("GT");
        procesos.setNombre("GESTION DEL TALENTO HUMANO");
        em.persist(procesos);
        em.flush();

        procesos.setCodigo("GF");
        procesos.setNombre("GESTION FINANCIERA");
        em.persist(procesos);
        em.flush();

        procesos.setCodigo("GC");
        procesos.setNombre("GESTION DE COMPRAS Y SUMINISTROS");
        em.persist(procesos);
        em.flush();

        procesos.setCodigo("SG");
        procesos.setNombre("SERVICIOS GENERALES");
        em.persist(procesos);
        em.flush();

        procesos.setCodigo("SC");
        procesos.setNombre("GESTION DE SERVICIOS COMPLEMENTARIOS");
        em.persist(procesos);
        em.flush();

        procesos.setCodigo("GI");
        procesos.setNombre("GESTION DE LA INFORMACION");
        em.persist(procesos);
        em.flush();

        procesos.setCodigo("GQ");
        procesos.setNombre("GESTION DE LA CALIDAD");
        em.persist(procesos);
        em.flush();

        log.info("Database successfully populated H2... ");


    } // end : populateTest Method

}




