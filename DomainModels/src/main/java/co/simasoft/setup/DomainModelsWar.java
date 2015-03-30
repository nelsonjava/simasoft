package co.simasoft.setup;

import co.simasoft.models.naif.DomainModels.*;

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
@Named("DomainModelsWar")
public class DomainModelsWar {

    private static final Logger log = Logger.getLogger(DomainModelsWar.class.getName());

    public void data() {

System.out.println("Hello World!");


    } // data()

} // DomainModelsSetup

