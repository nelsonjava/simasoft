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
@Named("lmrSetup")
public class lmrSetup {

    private static final String QUERYA = "SELECT c FROM TypesAttributes c WHERE c.name LIKE :custName";
    private static final String QUERYB = "SELECT c FROM Entities c WHERE c.name LIKE :custName";
    private static final String QUERYC = "SELECT c FROM Cardinalities c WHERE c.name LIKE :custName";

    @PersistenceContext(unitName = "DomainModelsPU-JTA")
    private EntityManager em;

    private static final Logger log = Logger.getLogger(lmrSetup.class.getName());

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
        domainModels.setName("lmr");
        em.persist(domainModels);
        em.flush();

        Lmrs(domainModels);
        Instituciones(domainModels);
        TiposRegistros(domainModels);
        Medios(domainModels);
        Dependencias(domainModels);
        Indexaciones(domainModels);
        Responsables(domainModels);
        TiposAccesos(domainModels);
        TrdAreas(domainModels);
        DisposicionFinal(domainModels);
        Estados(domainModels);
        TiposLmrs(domainModels);
        TrdArchivos(domainModels);
        EntradasArchivos(domainModels);
        Procesos(domainModels);
        Relations();

    } // data()

    public void Lmrs(DomainModels domainModel) {

        Entities lmrs = new Entities();
        lmrs.setName("Lmrs");
        lmrs.setDomainModels(domainModel);
        em.persist(lmrs);
        em.flush();

//      ---------------------- Attributes:Lmrs -------------------------

        TypesAttributes typescodigo = new TypesAttributes();
        typescodigo = findTypesAttributes("String");

        Attributes codigo = new Attributes();
        codigo.setName("codigo");
        codigo.setType("String");
        codigo.setTypesAttributes(typescodigo);
        codigo.setEntities(lmrs);
        em.persist(codigo);
        em.flush();

        TypesAttributes typesnombre = new TypesAttributes();
        typesnombre = findTypesAttributes("String");

        Attributes nombre = new Attributes();
        nombre.setName("nombre");
        nombre.setType("String");
        nombre.setTypesAttributes(typesnombre);
        nombre.setEntities(lmrs);
        em.persist(nombre);
        em.flush();

        TypesAttributes typesversion = new TypesAttributes();
        typesversion = findTypesAttributes("String");

        Attributes version = new Attributes();
        version.setName("version");
        version.setType("String");
        version.setTypesAttributes(typesversion);
        version.setEntities(lmrs);
        em.persist(version);
        em.flush();

        TypesAttributes typesfecha = new TypesAttributes();
        typesfecha = findTypesAttributes("Date");

        Attributes fecha = new Attributes();
        fecha.setName("fecha");
        fecha.setType("Date");
        fecha.setTypesAttributes(typesfecha);
        fecha.setEntities(lmrs);
        em.persist(fecha);
        em.flush();

        TypesAttributes typesestado = new TypesAttributes();
        typesestado = findTypesAttributes("String");

        Attributes estado = new Attributes();
        estado.setName("estado");
        estado.setType("String");
        estado.setTypesAttributes(typesestado);
        estado.setEntities(lmrs);
        em.persist(estado);
        em.flush();

        TypesAttributes typesubicacion = new TypesAttributes();
        typesubicacion = findTypesAttributes("String");

        Attributes ubicacion = new Attributes();
        ubicacion.setName("ubicacion");
        ubicacion.setType("String");
        ubicacion.setTypesAttributes(typesubicacion);
        ubicacion.setEntities(lmrs);
        em.persist(ubicacion);
        em.flush();

        TypesAttributes typeslink = new TypesAttributes();
        typeslink = findTypesAttributes("String");

        Attributes link = new Attributes();
        link.setName("link");
        link.setType("String");
        link.setTypesAttributes(typeslink);
        link.setEntities(lmrs);
        em.persist(link);
        em.flush();

        TypesAttributes typesordenar = new TypesAttributes();
        typesordenar = findTypesAttributes("String");

        Attributes ordenar = new Attributes();
        ordenar.setName("ordenar");
        ordenar.setType("String");
        ordenar.setTypesAttributes(typesordenar);
        ordenar.setEntities(lmrs);
        em.persist(ordenar);
        em.flush();

        TypesAttributes typesobservaciones = new TypesAttributes();
        typesobservaciones = findTypesAttributes("String");

        Attributes observaciones = new Attributes();
        observaciones.setName("observaciones");
        observaciones.setType("String");
        observaciones.setTypesAttributes(typesobservaciones);
        observaciones.setEntities(lmrs);
        em.persist(observaciones);
        em.flush();

    } // Lmrs()

    public void Instituciones(DomainModels domainModel) {

        Entities instituciones = new Entities();
        instituciones.setName("Instituciones");
        instituciones.setDomainModels(domainModel);
        em.persist(instituciones);
        em.flush();

//      ---------------------- Attributes:Instituciones -------------------------

        TypesAttributes typesnombre = new TypesAttributes();
        typesnombre = findTypesAttributes("String");

        Attributes nombre = new Attributes();
        nombre.setName("nombre");
        nombre.setType("String");
        nombre.setTypesAttributes(typesnombre);
        nombre.setEntities(instituciones);
        em.persist(nombre);
        em.flush();

    } // Instituciones()

    public void TiposRegistros(DomainModels domainModel) {

        Entities tiposRegistros = new Entities();
        tiposRegistros.setName("TiposRegistros");
        tiposRegistros.setDomainModels(domainModel);
        em.persist(tiposRegistros);
        em.flush();

//      ---------------------- Attributes:TiposRegistros -------------------------

        TypesAttributes typescodigo = new TypesAttributes();
        typescodigo = findTypesAttributes("String");

        Attributes codigo = new Attributes();
        codigo.setName("codigo");
        codigo.setType("String");
        codigo.setTypesAttributes(typescodigo);
        codigo.setEntities(tiposRegistros);
        em.persist(codigo);
        em.flush();

        TypesAttributes typesnombre = new TypesAttributes();
        typesnombre = findTypesAttributes("String");

        Attributes nombre = new Attributes();
        nombre.setName("nombre");
        nombre.setType("String");
        nombre.setTypesAttributes(typesnombre);
        nombre.setEntities(tiposRegistros);
        em.persist(nombre);
        em.flush();

    } // TiposRegistros()

    public void Medios(DomainModels domainModel) {

        Entities medios = new Entities();
        medios.setName("Medios");
        medios.setDomainModels(domainModel);
        em.persist(medios);
        em.flush();

//      ---------------------- Attributes:Medios -------------------------

        TypesAttributes typesnombre = new TypesAttributes();
        typesnombre = findTypesAttributes("String");

        Attributes nombre = new Attributes();
        nombre.setName("nombre");
        nombre.setType("String");
        nombre.setTypesAttributes(typesnombre);
        nombre.setEntities(medios);
        em.persist(nombre);
        em.flush();

    } // Medios()

    public void Dependencias(DomainModels domainModel) {

        Entities dependencias = new Entities();
        dependencias.setName("Dependencias");
        dependencias.setDomainModels(domainModel);
        em.persist(dependencias);
        em.flush();

//      ---------------------- Attributes:Dependencias -------------------------

        TypesAttributes typesnombre = new TypesAttributes();
        typesnombre = findTypesAttributes("String");

        Attributes nombre = new Attributes();
        nombre.setName("nombre");
        nombre.setType("String");
        nombre.setTypesAttributes(typesnombre);
        nombre.setEntities(dependencias);
        em.persist(nombre);
        em.flush();

    } // Dependencias()

    public void Indexaciones(DomainModels domainModel) {

        Entities indexaciones = new Entities();
        indexaciones.setName("Indexaciones");
        indexaciones.setDomainModels(domainModel);
        em.persist(indexaciones);
        em.flush();

//      ---------------------- Attributes:Indexaciones -------------------------

        TypesAttributes typesnombre = new TypesAttributes();
        typesnombre = findTypesAttributes("String");

        Attributes nombre = new Attributes();
        nombre.setName("nombre");
        nombre.setType("String");
        nombre.setTypesAttributes(typesnombre);
        nombre.setEntities(indexaciones);
        em.persist(nombre);
        em.flush();

    } // Indexaciones()

    public void Responsables(DomainModels domainModel) {

        Entities responsables = new Entities();
        responsables.setName("Responsables");
        responsables.setDomainModels(domainModel);
        em.persist(responsables);
        em.flush();

//      ---------------------- Attributes:Responsables -------------------------

        TypesAttributes typesnombre = new TypesAttributes();
        typesnombre = findTypesAttributes("String");

        Attributes nombre = new Attributes();
        nombre.setName("nombre");
        nombre.setType("String");
        nombre.setTypesAttributes(typesnombre);
        nombre.setEntities(responsables);
        em.persist(nombre);
        em.flush();

    } // Responsables()

    public void TiposAccesos(DomainModels domainModel) {

        Entities tiposAccesos = new Entities();
        tiposAccesos.setName("TiposAccesos");
        tiposAccesos.setDomainModels(domainModel);
        em.persist(tiposAccesos);
        em.flush();

//      ---------------------- Attributes:TiposAccesos -------------------------

        TypesAttributes typesnombre = new TypesAttributes();
        typesnombre = findTypesAttributes("String");

        Attributes nombre = new Attributes();
        nombre.setName("nombre");
        nombre.setType("String");
        nombre.setTypesAttributes(typesnombre);
        nombre.setEntities(tiposAccesos);
        em.persist(nombre);
        em.flush();

    } // TiposAccesos()

    public void TrdAreas(DomainModels domainModel) {

        Entities trdAreas = new Entities();
        trdAreas.setName("TrdAreas");
        trdAreas.setDomainModels(domainModel);
        em.persist(trdAreas);
        em.flush();

//      ---------------------- Attributes:TrdAreas -------------------------

        TypesAttributes typesnombre = new TypesAttributes();
        typesnombre = findTypesAttributes("String");

        Attributes nombre = new Attributes();
        nombre.setName("nombre");
        nombre.setType("String");
        nombre.setTypesAttributes(typesnombre);
        nombre.setEntities(trdAreas);
        em.persist(nombre);
        em.flush();

    } // TrdAreas()

    public void DisposicionFinal(DomainModels domainModel) {

        Entities disposicionFinal = new Entities();
        disposicionFinal.setName("DisposicionFinal");
        disposicionFinal.setDomainModels(domainModel);
        em.persist(disposicionFinal);
        em.flush();

//      ---------------------- Attributes:DisposicionFinal -------------------------

        TypesAttributes typesnombre = new TypesAttributes();
        typesnombre = findTypesAttributes("String");

        Attributes nombre = new Attributes();
        nombre.setName("nombre");
        nombre.setType("String");
        nombre.setTypesAttributes(typesnombre);
        nombre.setEntities(disposicionFinal);
        em.persist(nombre);
        em.flush();

    } // DisposicionFinal()

    public void Estados(DomainModels domainModel) {

        Entities estados = new Entities();
        estados.setName("Estados");
        estados.setDomainModels(domainModel);
        em.persist(estados);
        em.flush();

//      ---------------------- Attributes:Estados -------------------------

        TypesAttributes typesnombre = new TypesAttributes();
        typesnombre = findTypesAttributes("String");

        Attributes nombre = new Attributes();
        nombre.setName("nombre");
        nombre.setType("String");
        nombre.setTypesAttributes(typesnombre);
        nombre.setEntities(estados);
        em.persist(nombre);
        em.flush();

    } // Estados()

    public void TiposLmrs(DomainModels domainModel) {

        Entities tiposLmrs = new Entities();
        tiposLmrs.setName("TiposLmrs");
        tiposLmrs.setDomainModels(domainModel);
        em.persist(tiposLmrs);
        em.flush();

//      ---------------------- Attributes:TiposLmrs -------------------------

        TypesAttributes typesnombre = new TypesAttributes();
        typesnombre = findTypesAttributes("String");

        Attributes nombre = new Attributes();
        nombre.setName("nombre");
        nombre.setType("String");
        nombre.setTypesAttributes(typesnombre);
        nombre.setEntities(tiposLmrs);
        em.persist(nombre);
        em.flush();

    } // TiposLmrs()

    public void TrdArchivos(DomainModels domainModel) {

        Entities trdArchivos = new Entities();
        trdArchivos.setName("TrdArchivos");
        trdArchivos.setDomainModels(domainModel);
        em.persist(trdArchivos);
        em.flush();

//      ---------------------- Attributes:TrdArchivos -------------------------

        TypesAttributes typesnombre = new TypesAttributes();
        typesnombre = findTypesAttributes("String");

        Attributes nombre = new Attributes();
        nombre.setName("nombre");
        nombre.setType("String");
        nombre.setTypesAttributes(typesnombre);
        nombre.setEntities(trdArchivos);
        em.persist(nombre);
        em.flush();

    } // TrdArchivos()

    public void EntradasArchivos(DomainModels domainModel) {

        Entities entradasArchivos = new Entities();
        entradasArchivos.setName("EntradasArchivos");
        entradasArchivos.setDomainModels(domainModel);
        em.persist(entradasArchivos);
        em.flush();

//      ---------------------- Attributes:EntradasArchivos -------------------------

        TypesAttributes typesentity = new TypesAttributes();
        typesentity = findTypesAttributes("String");

        Attributes entity = new Attributes();
        entity.setName("entity");
        entity.setType("String");
        entity.setTypesAttributes(typesentity);
        entity.setEntities(entradasArchivos);
        em.persist(entity);
        em.flush();

    } // EntradasArchivos()

    public void Procesos(DomainModels domainModel) {

        Entities procesos = new Entities();
        procesos.setName("Procesos");
        procesos.setDomainModels(domainModel);
        em.persist(procesos);
        em.flush();

//      ---------------------- Attributes:Procesos -------------------------

        TypesAttributes typesentity = new TypesAttributes();
        typesentity = findTypesAttributes("String");

        Attributes entity = new Attributes();
        entity.setName("entity");
        entity.setType("String");
        entity.setTypesAttributes(typesentity);
        entity.setEntities(procesos);
        em.persist(entity);
        em.flush();

    } // Procesos()

//  ---------------------- Relationships -------------------------

    public void Relations() {

//  ---------------------- Lmrs 1..* EntradasArchivos -------------------------

        Entities fromLmrs11 = new Entities();
        Cardinalities Lmrs11 = new Cardinalities();
        Entities   toLmrs11 = new Entities();
        fromLmrs11 = findEntities("Lmrs");
        Lmrs11 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toLmrs11 = findEntities("EntradasArchivos");
        Relationships relLmrs11 = new Relationships();
        relLmrs11.setFrom(fromLmrs11);
        relLmrs11.setCardinalities(Lmrs11);
        relLmrs11.setTo(toLmrs11);
        relLmrs11.setOptionality(true);
        em.persist(relLmrs11);
        em.flush();

//  ---------------------- Instituciones 1..* Lmrs -------------------------

        Entities fromInstituciones0 = new Entities();
        Cardinalities Instituciones0 = new Cardinalities();
        Entities   toInstituciones0 = new Entities();
        fromInstituciones0 = findEntities("Instituciones");
        Instituciones0 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toInstituciones0 = findEntities("Lmrs");
        Relationships relInstituciones0 = new Relationships();
        relInstituciones0.setFrom(fromInstituciones0);
        relInstituciones0.setCardinalities(Instituciones0);
        relInstituciones0.setTo(toInstituciones0);
        relInstituciones0.setOptionality(true);
        em.persist(relInstituciones0);
        em.flush();

//  ---------------------- TiposRegistros 1..* Lmrs -------------------------

        Entities fromTiposRegistros0 = new Entities();
        Cardinalities TiposRegistros0 = new Cardinalities();
        Entities   toTiposRegistros0 = new Entities();
        fromTiposRegistros0 = findEntities("TiposRegistros");
        TiposRegistros0 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toTiposRegistros0 = findEntities("Lmrs");
        Relationships relTiposRegistros0 = new Relationships();
        relTiposRegistros0.setFrom(fromTiposRegistros0);
        relTiposRegistros0.setCardinalities(TiposRegistros0);
        relTiposRegistros0.setTo(toTiposRegistros0);
        relTiposRegistros0.setOptionality(true);
        em.persist(relTiposRegistros0);
        em.flush();

//  ---------------------- Medios 1..* Lmrs -------------------------

        Entities fromMedios0 = new Entities();
        Cardinalities Medios0 = new Cardinalities();
        Entities   toMedios0 = new Entities();
        fromMedios0 = findEntities("Medios");
        Medios0 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toMedios0 = findEntities("Lmrs");
        Relationships relMedios0 = new Relationships();
        relMedios0.setFrom(fromMedios0);
        relMedios0.setCardinalities(Medios0);
        relMedios0.setTo(toMedios0);
        relMedios0.setOptionality(true);
        em.persist(relMedios0);
        em.flush();

//  ---------------------- Dependencias 1..* Lmrs -------------------------

        Entities fromDependencias0 = new Entities();
        Cardinalities Dependencias0 = new Cardinalities();
        Entities   toDependencias0 = new Entities();
        fromDependencias0 = findEntities("Dependencias");
        Dependencias0 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toDependencias0 = findEntities("Lmrs");
        Relationships relDependencias0 = new Relationships();
        relDependencias0.setFrom(fromDependencias0);
        relDependencias0.setCardinalities(Dependencias0);
        relDependencias0.setTo(toDependencias0);
        relDependencias0.setOptionality(true);
        em.persist(relDependencias0);
        em.flush();

//  ---------------------- Indexaciones 1..* Lmrs -------------------------

        Entities fromIndexaciones0 = new Entities();
        Cardinalities Indexaciones0 = new Cardinalities();
        Entities   toIndexaciones0 = new Entities();
        fromIndexaciones0 = findEntities("Indexaciones");
        Indexaciones0 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toIndexaciones0 = findEntities("Lmrs");
        Relationships relIndexaciones0 = new Relationships();
        relIndexaciones0.setFrom(fromIndexaciones0);
        relIndexaciones0.setCardinalities(Indexaciones0);
        relIndexaciones0.setTo(toIndexaciones0);
        relIndexaciones0.setOptionality(true);
        em.persist(relIndexaciones0);
        em.flush();

//  ---------------------- Responsables 1..* Lmrs -------------------------

        Entities fromResponsables0 = new Entities();
        Cardinalities Responsables0 = new Cardinalities();
        Entities   toResponsables0 = new Entities();
        fromResponsables0 = findEntities("Responsables");
        Responsables0 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toResponsables0 = findEntities("Lmrs");
        Relationships relResponsables0 = new Relationships();
        relResponsables0.setFrom(fromResponsables0);
        relResponsables0.setCardinalities(Responsables0);
        relResponsables0.setTo(toResponsables0);
        relResponsables0.setOptionality(true);
        em.persist(relResponsables0);
        em.flush();

//  ---------------------- TiposAccesos 1..* Lmrs -------------------------

        Entities fromTiposAccesos0 = new Entities();
        Cardinalities TiposAccesos0 = new Cardinalities();
        Entities   toTiposAccesos0 = new Entities();
        fromTiposAccesos0 = findEntities("TiposAccesos");
        TiposAccesos0 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toTiposAccesos0 = findEntities("Lmrs");
        Relationships relTiposAccesos0 = new Relationships();
        relTiposAccesos0.setFrom(fromTiposAccesos0);
        relTiposAccesos0.setCardinalities(TiposAccesos0);
        relTiposAccesos0.setTo(toTiposAccesos0);
        relTiposAccesos0.setOptionality(true);
        em.persist(relTiposAccesos0);
        em.flush();

//  ---------------------- TrdAreas 1..* Lmrs -------------------------

        Entities fromTrdAreas0 = new Entities();
        Cardinalities TrdAreas0 = new Cardinalities();
        Entities   toTrdAreas0 = new Entities();
        fromTrdAreas0 = findEntities("TrdAreas");
        TrdAreas0 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toTrdAreas0 = findEntities("Lmrs");
        Relationships relTrdAreas0 = new Relationships();
        relTrdAreas0.setFrom(fromTrdAreas0);
        relTrdAreas0.setCardinalities(TrdAreas0);
        relTrdAreas0.setTo(toTrdAreas0);
        relTrdAreas0.setOptionality(true);
        em.persist(relTrdAreas0);
        em.flush();

//  ---------------------- DisposicionFinal 1..* Lmrs -------------------------

        Entities fromDisposicionFinal0 = new Entities();
        Cardinalities DisposicionFinal0 = new Cardinalities();
        Entities   toDisposicionFinal0 = new Entities();
        fromDisposicionFinal0 = findEntities("DisposicionFinal");
        DisposicionFinal0 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toDisposicionFinal0 = findEntities("Lmrs");
        Relationships relDisposicionFinal0 = new Relationships();
        relDisposicionFinal0.setFrom(fromDisposicionFinal0);
        relDisposicionFinal0.setCardinalities(DisposicionFinal0);
        relDisposicionFinal0.setTo(toDisposicionFinal0);
        relDisposicionFinal0.setOptionality(true);
        em.persist(relDisposicionFinal0);
        em.flush();

//  ---------------------- Estados 1..* Lmrs -------------------------

        Entities fromEstados0 = new Entities();
        Cardinalities Estados0 = new Cardinalities();
        Entities   toEstados0 = new Entities();
        fromEstados0 = findEntities("Estados");
        Estados0 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toEstados0 = findEntities("Lmrs");
        Relationships relEstados0 = new Relationships();
        relEstados0.setFrom(fromEstados0);
        relEstados0.setCardinalities(Estados0);
        relEstados0.setTo(toEstados0);
        relEstados0.setOptionality(true);
        em.persist(relEstados0);
        em.flush();

//  ---------------------- TiposLmrs 1..* Lmrs -------------------------

        Entities fromTiposLmrs0 = new Entities();
        Cardinalities TiposLmrs0 = new Cardinalities();
        Entities   toTiposLmrs0 = new Entities();
        fromTiposLmrs0 = findEntities("TiposLmrs");
        TiposLmrs0 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toTiposLmrs0 = findEntities("Lmrs");
        Relationships relTiposLmrs0 = new Relationships();
        relTiposLmrs0.setFrom(fromTiposLmrs0);
        relTiposLmrs0.setCardinalities(TiposLmrs0);
        relTiposLmrs0.setTo(toTiposLmrs0);
        relTiposLmrs0.setOptionality(true);
        em.persist(relTiposLmrs0);
        em.flush();

//  ---------------------- TrdArchivos 1..* Lmrs -------------------------

        Entities fromTrdArchivos0 = new Entities();
        Cardinalities TrdArchivos0 = new Cardinalities();
        Entities   toTrdArchivos0 = new Entities();
        fromTrdArchivos0 = findEntities("TrdArchivos");
        TrdArchivos0 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toTrdArchivos0 = findEntities("Lmrs");
        Relationships relTrdArchivos0 = new Relationships();
        relTrdArchivos0.setFrom(fromTrdArchivos0);
        relTrdArchivos0.setCardinalities(TrdArchivos0);
        relTrdArchivos0.setTo(toTrdArchivos0);
        relTrdArchivos0.setOptionality(true);
        em.persist(relTrdArchivos0);
        em.flush();

//  ---------------------- Procesos 1..* Lmrs -------------------------

        Entities fromProcesos0 = new Entities();
        Cardinalities Procesos0 = new Cardinalities();
        Entities   toProcesos0 = new Entities();
        fromProcesos0 = findEntities("Procesos");
        Procesos0 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toProcesos0 = findEntities("Lmrs");
        Relationships relProcesos0 = new Relationships();
        relProcesos0.setFrom(fromProcesos0);
        relProcesos0.setCardinalities(Procesos0);
        relProcesos0.setTo(toProcesos0);
        relProcesos0.setOptionality(true);
        em.persist(relProcesos0);
        em.flush();

    } // Relations()
} // DomainModelsSetup

