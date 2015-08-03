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
@Named("procesosSetup")
public class procesosSetup {

    private static final String QUERYA = "SELECT c FROM TypesAttributes c WHERE c.name LIKE :custName";
    private static final String QUERYB = "SELECT c FROM Entities c WHERE c.name LIKE :custName";
    private static final String QUERYC = "SELECT c FROM Cardinalities c WHERE c.name LIKE :custName";

    @PersistenceContext(unitName = "DomainModelsPU-JTA")
    private EntityManager em;

    private static final Logger log = Logger.getLogger(procesosSetup.class.getName());

    public TypesAttributes findTypesAttributes(String name) {

        TypesAttributes typesAttributes = new TypesAttributes();
        List<TypesAttributes> results = em.createQuery(QUERYA).setParameter("custName", name).getResultList();

        if (!results.isEmpty()) {
           typesAttributes = results.get(0);
        }
        return typesAttributes;
    }

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

        DomainModels domainModels = new DomainModels();
        domainModels.setName("procesos");
        em.persist(domainModels);
        em.flush();

        Procesos(domainModels);
        TiposProcesos(domainModels);


    } // data()

    public void Procesos(DomainModels domainModel) {

        Entities procesos = new Entities();
        procesos.setName("Procesos");
        procesos.setDomainModels(domainModel);
        em.persist(procesos);
        em.flush();

//      ---------------------- Attributes:Procesos -------------------------

        TypesAttributes typescodigo = new TypesAttributes();
        typescodigo = findTypesAttributes("String");

        Attributes codigo = new Attributes();
        codigo.setName("codigo");
        codigo.setType("String");
        codigo.setTypesAttributes(typescodigo);
        codigo.setEntities(procesos);
        em.persist(codigo);
        em.flush();

        TypesAttributes typesnombre = new TypesAttributes();
        typesnombre = findTypesAttributes("String");

        Attributes nombre = new Attributes();
        nombre.setName("nombre");
        nombre.setType("String");
        nombre.setTypesAttributes(typesnombre);
        nombre.setEntities(procesos);
        em.persist(nombre);
        em.flush();

        TypesAttributes typesobservaciones = new TypesAttributes();
        typesobservaciones = findTypesAttributes("String");

        Attributes observaciones = new Attributes();
        observaciones.setName("observaciones");
        observaciones.setType("String");
        observaciones.setTypesAttributes(typesobservaciones);
        observaciones.setEntities(procesos);
        em.persist(observaciones);
        em.flush();

    } // Procesos()

    public void TiposProcesos(DomainModels domainModel) {

        Entities tiposProcesos = new Entities();
        tiposProcesos.setName("TiposProcesos");
        tiposProcesos.setDomainModels(domainModel);
        em.persist(tiposProcesos);
        em.flush();

//      ---------------------- Attributes:TiposProcesos -------------------------

        TypesAttributes typescodigo = new TypesAttributes();
        typescodigo = findTypesAttributes("String");

        Attributes codigo = new Attributes();
        codigo.setName("codigo");
        codigo.setType("String");
        codigo.setTypesAttributes(typescodigo);
        codigo.setEntities(tiposProcesos);
        em.persist(codigo);
        em.flush();

        TypesAttributes typesnombre = new TypesAttributes();
        typesnombre = findTypesAttributes("String");

        Attributes nombre = new Attributes();
        nombre.setName("nombre");
        nombre.setType("String");
        nombre.setTypesAttributes(typesnombre);
        nombre.setEntities(tiposProcesos);
        em.persist(nombre);
        em.flush();

    } // TiposProcesos()

} // DomainModelsSetup

