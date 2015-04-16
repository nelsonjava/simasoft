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
@Named("lmdSetup")
public class lmdSetup {

    private static final String QUERYA = "SELECT c FROM TypesAttributes c WHERE c.name LIKE :custName";
    private static final String QUERYB = "SELECT c FROM Entities c WHERE c.name LIKE :custName";
    private static final String QUERYC = "SELECT c FROM Cardinalities c WHERE c.name LIKE :custName";

    @PersistenceContext(unitName = "DomainModelsPU-JTA")
    private EntityManager em;

    private static final Logger log = Logger.getLogger(lmdSetup.class.getName());

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
        domainModels.setName("lmd");
        em.persist(domainModels);
        em.flush();

        TiposDocumentos(domainModels);
        Lmds(domainModels);
        EstadosDocuementos(domainModels);
        Procesos(domainModels);
        Relations();

    } // data()

    public void TiposDocumentos(DomainModels domainModel) {

        Entities tiposDocumentos = new Entities();
        tiposDocumentos.setName("TiposDocumentos");
        tiposDocumentos.setDomainModels(domainModel);
        em.persist(tiposDocumentos);
        em.flush();

//      ---------------------- Attributes:TiposDocumentos -------------------------

        TypesAttributes typescodigo = new TypesAttributes();
        typescodigo = findTypesAttributes("String");

        Attributes codigo = new Attributes();
        codigo.setName("codigo");
        codigo.setType("String");
        codigo.setTypesAttributes(typescodigo);
        codigo.setEntities(tiposDocumentos);
        em.persist(codigo);
        em.flush();

        TypesAttributes typesnombre = new TypesAttributes();
        typesnombre = findTypesAttributes("String");

        Attributes nombre = new Attributes();
        nombre.setName("nombre");
        nombre.setType("String");
        nombre.setTypesAttributes(typesnombre);
        nombre.setEntities(tiposDocumentos);
        em.persist(nombre);
        em.flush();

    } // TiposDocumentos()

    public void Lmds(DomainModels domainModel) {

        Entities lmds = new Entities();
        lmds.setName("Lmds");
        lmds.setDomainModels(domainModel);
        em.persist(lmds);
        em.flush();

//      ---------------------- Attributes:Lmds -------------------------

        TypesAttributes typescodigo = new TypesAttributes();
        typescodigo = findTypesAttributes("String");

        Attributes codigo = new Attributes();
        codigo.setName("codigo");
        codigo.setType("String");
        codigo.setTypesAttributes(typescodigo);
        codigo.setEntities(lmds);
        em.persist(codigo);
        em.flush();

        TypesAttributes typesnombre = new TypesAttributes();
        typesnombre = findTypesAttributes("String");

        Attributes nombre = new Attributes();
        nombre.setName("nombre");
        nombre.setType("String");
        nombre.setTypesAttributes(typesnombre);
        nombre.setEntities(lmds);
        em.persist(nombre);
        em.flush();

        TypesAttributes typesversion = new TypesAttributes();
        typesversion = findTypesAttributes("String");

        Attributes version = new Attributes();
        version.setName("version");
        version.setType("String");
        version.setTypesAttributes(typesversion);
        version.setEntities(lmds);
        em.persist(version);
        em.flush();

        TypesAttributes typesfecha = new TypesAttributes();
        typesfecha = findTypesAttributes("Date");

        Attributes fecha = new Attributes();
        fecha.setName("fecha");
        fecha.setType("Date");
        fecha.setTypesAttributes(typesfecha);
        fecha.setEntities(lmds);
        em.persist(fecha);
        em.flush();

        TypesAttributes typesubicacion = new TypesAttributes();
        typesubicacion = findTypesAttributes("String");

        Attributes ubicacion = new Attributes();
        ubicacion.setName("ubicacion");
        ubicacion.setType("String");
        ubicacion.setTypesAttributes(typesubicacion);
        ubicacion.setEntities(lmds);
        em.persist(ubicacion);
        em.flush();

        TypesAttributes typeslink = new TypesAttributes();
        typeslink = findTypesAttributes("String");

        Attributes link = new Attributes();
        link.setName("link");
        link.setType("String");
        link.setTypesAttributes(typeslink);
        link.setEntities(lmds);
        em.persist(link);
        em.flush();

        TypesAttributes typesobservaciones = new TypesAttributes();
        typesobservaciones = findTypesAttributes("String");

        Attributes observaciones = new Attributes();
        observaciones.setName("observaciones");
        observaciones.setType("String");
        observaciones.setTypesAttributes(typesobservaciones);
        observaciones.setEntities(lmds);
        em.persist(observaciones);
        em.flush();

    } // Lmds()

    public void EstadosDocuementos(DomainModels domainModel) {

        Entities estadosDocuementos = new Entities();
        estadosDocuementos.setName("EstadosDocuementos");
        estadosDocuementos.setDomainModels(domainModel);
        em.persist(estadosDocuementos);
        em.flush();

//      ---------------------- Attributes:EstadosDocuementos -------------------------

        TypesAttributes typesnombre = new TypesAttributes();
        typesnombre = findTypesAttributes("String");

        Attributes nombre = new Attributes();
        nombre.setName("nombre");
        nombre.setType("String");
        nombre.setTypesAttributes(typesnombre);
        nombre.setEntities(estadosDocuementos);
        em.persist(nombre);
        em.flush();

    } // EstadosDocuementos()

    public void Procesos(DomainModels domainModel) {

        Entities procesos = new Entities();
        procesos.setName("Procesos");
        procesos.setDomainModels(domainModel);
        em.persist(procesos);
        em.flush();

//      ---------------------- Attributes:Procesos -------------------------

        TypesAttributes typesentitiy = new TypesAttributes();
        typesentitiy = findTypesAttributes("String");

        Attributes entitiy = new Attributes();
        entitiy.setName("entitiy");
        entitiy.setType("String");
        entitiy.setTypesAttributes(typesentitiy);
        entitiy.setEntities(procesos);
        em.persist(entitiy);
        em.flush();

    } // Procesos()

//  ---------------------- Relationships -------------------------

    public void Relations() {

//  ---------------------- TiposDocumentos 1..* Lmds -------------------------

        Entities fromTiposDocumentos0 = new Entities();
        Cardinalities TiposDocumentos0 = new Cardinalities();
        Entities   toTiposDocumentos0 = new Entities();
        fromTiposDocumentos0 = findEntities("TiposDocumentos");
        TiposDocumentos0 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toTiposDocumentos0 = findEntities("Lmds");
        Relationships relTiposDocumentos0 = new Relationships();
        relTiposDocumentos0.setFrom(fromTiposDocumentos0);
        relTiposDocumentos0.setCardinalities(TiposDocumentos0);
        relTiposDocumentos0.setTo(toTiposDocumentos0);
        relTiposDocumentos0.setOptionality(true);
        em.persist(relTiposDocumentos0);
        em.flush();

//  ---------------------- EstadosDocuementos 1..* Lmds -------------------------

        Entities fromEstadosDocuementos0 = new Entities();
        Cardinalities EstadosDocuementos0 = new Cardinalities();
        Entities   toEstadosDocuementos0 = new Entities();
        fromEstadosDocuementos0 = findEntities("EstadosDocuementos");
        EstadosDocuementos0 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toEstadosDocuementos0 = findEntities("Lmds");
        Relationships relEstadosDocuementos0 = new Relationships();
        relEstadosDocuementos0.setFrom(fromEstadosDocuementos0);
        relEstadosDocuementos0.setCardinalities(EstadosDocuementos0);
        relEstadosDocuementos0.setTo(toEstadosDocuementos0);
        relEstadosDocuementos0.setOptionality(true);
        em.persist(relEstadosDocuementos0);
        em.flush();

//  ---------------------- Procesos 1..* Lmds -------------------------

        Entities fromProcesos0 = new Entities();
        Cardinalities Procesos0 = new Cardinalities();
        Entities   toProcesos0 = new Entities();
        fromProcesos0 = findEntities("Procesos");
        Procesos0 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toProcesos0 = findEntities("Lmds");
        Relationships relProcesos0 = new Relationships();
        relProcesos0.setFrom(fromProcesos0);
        relProcesos0.setCardinalities(Procesos0);
        relProcesos0.setTo(toProcesos0);
        relProcesos0.setOptionality(true);
        em.persist(relProcesos0);
        em.flush();

    } // Relations()
} // DomainModelsSetup

