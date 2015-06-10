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

    @PersistenceContext(unitName = "naifg8PU-JTA")
    private EntityManager em;

    public void data() {
    try {

        System.out.println("Hello World Setup!");

        clearFileTxt();

        line("PASO1");

/*
        Naifg8Bean naifg8Bean = new Naifg8Bean();
        List<Cardinalities> cars = naifg8Bean.selectAllCardinalities(em);
        for (Cardinalities car : cars) {
            line(car.getName());
        line("PASOX");
        } // Cardinalities
*/

        NaifgBean naifgBean = new NaifgBean();
        List<Cardinalities> cars = naifgBean.findAllCardinality(em);
        for (Cardinalities car : cars) {
            line(car.getName());
        } // Cardinalities


        saveFile("\\docs", "Setup.java");

    } // try
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    } // data



} // Setup
