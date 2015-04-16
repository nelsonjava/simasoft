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
        Lmrs(domainModels);
        Lmds(domainModels);
        Relations();

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

    public void Lmrs(DomainModels domainModel) {

        Entities lmrs = new Entities();
        lmrs.setName("Lmrs");
        lmrs.setDomainModels(domainModel);
        em.persist(lmrs);
        em.flush();

//      ---------------------- Attributes:Lmrs -------------------------

        TypesAttributes typesentity = new TypesAttributes();
        typesentity = findTypesAttributes("String");

        Attributes entity = new Attributes();
        entity.setName("entity");
        entity.setType("String");
        entity.setTypesAttributes(typesentity);
        entity.setEntities(lmrs);
        em.persist(entity);
        em.flush();

    } // Lmrs()

    public void Lmds(DomainModels domainModel) {

        Entities lmds = new Entities();
        lmds.setName("Lmds");
        lmds.setDomainModels(domainModel);
        em.persist(lmds);
        em.flush();

//      ---------------------- Attributes:Lmds -------------------------

        TypesAttributes typesentity = new TypesAttributes();
        typesentity = findTypesAttributes("String");

        Attributes entity = new Attributes();
        entity.setName("entity");
        entity.setType("String");
        entity.setTypesAttributes(typesentity);
        entity.setEntities(lmds);
        em.persist(entity);
        em.flush();

    } // Lmds()

//  ---------------------- Relationships -------------------------

    public void Relations() {

//  ---------------------- Procesos 1..* Lmds -------------------------

        Entities fromProcesos1 = new Entities();
        Cardinalities Procesos1 = new Cardinalities();
        Entities   toProcesos1 = new Entities();
        fromProcesos1 = findEntities("Procesos");
        Procesos1 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toProcesos1 = findEntities("Lmds");
        Relationships relProcesos1 = new Relationships();
        relProcesos1.setFrom(fromProcesos1);
        relProcesos1.setCardinalities(Procesos1);
        relProcesos1.setTo(toProcesos1);
        relProcesos1.setOptionality(true);
        em.persist(relProcesos1);
        em.flush();

//  ---------------------- Procesos 1..* Lmrs -------------------------

        Entities fromProcesos2 = new Entities();
        Cardinalities Procesos2 = new Cardinalities();
        Entities   toProcesos2 = new Entities();
        fromProcesos2 = findEntities("Procesos");
        Procesos2 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toProcesos2 = findEntities("Lmrs");
        Relationships relProcesos2 = new Relationships();
        relProcesos2.setFrom(fromProcesos2);
        relProcesos2.setCardinalities(Procesos2);
        relProcesos2.setTo(toProcesos2);
        relProcesos2.setOptionality(true);
        em.persist(relProcesos2);
        em.flush();

//  ---------------------- TiposProcesos 1..* Procesos -------------------------

        Entities fromTiposProcesos0 = new Entities();
        Cardinalities TiposProcesos0 = new Cardinalities();
        Entities   toTiposProcesos0 = new Entities();
        fromTiposProcesos0 = findEntities("TiposProcesos");
        TiposProcesos0 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toTiposProcesos0 = findEntities("Procesos");
        Relationships relTiposProcesos0 = new Relationships();
        relTiposProcesos0.setFrom(fromTiposProcesos0);
        relTiposProcesos0.setCardinalities(TiposProcesos0);
        relTiposProcesos0.setTo(toTiposProcesos0);
        relTiposProcesos0.setOptionality(true);
        em.persist(relTiposProcesos0);
        em.flush();

    } // Relations()
} // DomainModelsSetup

