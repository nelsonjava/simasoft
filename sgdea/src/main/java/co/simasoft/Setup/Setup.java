package co.simasoft.setup;

import co.simasoft.models.naif.sgdea.*;

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
public class Setup {

    @PersistenceContext(unitName = "sgdeaPU-JTA")
    private EntityManager em;

    private static final Logger log = Logger.getLogger(Setup.class.getName());

    public void data() {

//      ---------------------- VigenciaFondos ------------------------

        VigenciaFondos vigenciaFondos1 = new VigenciaFondos();
        vigenciaFondos1.setNombre("Abierto");
        vigenciaFondos1.setSiAbierto(true);
        em.persist(vigenciaFondos1);
        em.flush();

        VigenciaFondos vigenciaFondos2 = new VigenciaFondos();
        vigenciaFondos2.setNombre("Acumulado");
        vigenciaFondos2.setSiAbierto(true);
        em.persist(vigenciaFondos2);
        em.flush();

        VigenciaFondos vigenciaFondos3 = new VigenciaFondos();
        vigenciaFondos3.setNombre("Cerrado");
        vigenciaFondos3.setSiAbierto(false);
        em.persist(vigenciaFondos3);
        em.flush();


    } // data

} // Setup
