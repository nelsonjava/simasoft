package co.simasoft;

/**
 * Hello world!
 *
*/

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import co.simasoft.models.*;

public class App{

    private static Logger log = LoggerFactory.getLogger(App.class);

    public static void main( String[] args ){

        System.out.println( "Hello World!" );

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("naifgPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        User found = entityManager.find(User.class, 1L);
        log.info("found=" + found);
        System.out.println( "Paso!" );

    } // main

} // App
