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

} // DomainModelsSetup

