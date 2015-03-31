package co.simasoft.setup;

import co.simasoft.utils.*;
import co.simasoft.models.naif.DomainModels.*;

import java.io.*;
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
@Named("DomainModelsGen")
public class DomainModelsGen {

    ArrayList<String> imports = new ArrayList<String>();
    private Set<Entities> entities;
    private ArrayList<Entidad> entidades = new ArrayList<Entidad>();

    private static final Logger log = Logger.getLogger(DomainModelsSetup.class.getName());

    public void data(DomainModels domainModels) throws IOException {

        System.out.println("Hello World!-1" + domainModels.getName());

        entities = domainModels.getEntities();

        System.out.println();
        System.out.println(">> Entities:");

        entidades.clear();

        for (Entities entity : entities) {
            System.out.println(" - " + entity.getName());

            Entidad entidad = new Entidad(entity.getName());

            for (Attributes attribute : entity.getAttributes()) {
                entidad.addAtributo(new Atributos(attribute.getName(), attribute.getType()));
            } // end : attributes : for

            entidades.add(entidad);

        } // end : entities : for

        imports.add(domainModels.getName()+".models");

        Models models = new Models(domainModels.getName(),domainModels.getName(),domainModels.getName());
        models.setImports(imports);
        models.setEntities(entidades);
        models.WarH2();

    } // data()


} // DomainModelsSetup

