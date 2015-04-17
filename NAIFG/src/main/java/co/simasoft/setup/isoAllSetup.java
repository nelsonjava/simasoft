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
@Named("isoAllSetup")
public class isoAllSetup {

    private static final String QUERYA = "SELECT c FROM TypesAttributes c WHERE c.name LIKE :custName";
    private static final String QUERYB = "SELECT c FROM Entities c WHERE c.name LIKE :custName";
    private static final String QUERYC = "SELECT c FROM Cardinalities c WHERE c.name LIKE :custName";

    @PersistenceContext(unitName = "DomainModelsPU-JTA")
    private EntityManager em;

    private static final Logger log = Logger.getLogger(isoAllSetup.class.getName());

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
        domainModels.setName("iso");
        em.persist(domainModels);
        em.flush();

        EntradasArchivos(domainModels);
        Almacenamientos(domainModels);
        TiposAlmacenamientos(domainModels);
        TiposArchivos(domainModels);
        Ubicaciones(domainModels);
        TiposUbicaciones(domainModels);
        AnosDepuraciones(domainModels);
        ArchivosInactivos(domainModels);
        OtrosArchivos(domainModels);
        TiposDocumentos(domainModels);
        Lmds(domainModels);
        EstadosDocuementos(domainModels);
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
        TiposProcesos(domainModels);
        Procesos(domainModels);
        Relations();

    } // data()

    public void EntradasArchivos(DomainModels domainModel) {

        Entities entradasArchivos = new Entities();
        entradasArchivos.setName("EntradasArchivos");
        entradasArchivos.setDomainModels(domainModel);
        em.persist(entradasArchivos);
        em.flush();

//      ---------------------- Attributes:EntradasArchivos -------------------------

        TypesAttributes typesalmacenamiento = new TypesAttributes();
        typesalmacenamiento = findTypesAttributes("String");

        Attributes almacenamiento = new Attributes();
        almacenamiento.setName("almacenamiento");
        almacenamiento.setType("String");
        almacenamiento.setTypesAttributes(typesalmacenamiento);
        almacenamiento.setEntities(entradasArchivos);
        em.persist(almacenamiento);
        em.flush();

        TypesAttributes typesfolios = new TypesAttributes();
        typesfolios = findTypesAttributes("String");

        Attributes folios = new Attributes();
        folios.setName("folios");
        folios.setType("String");
        folios.setTypesAttributes(typesfolios);
        folios.setEntities(entradasArchivos);
        em.persist(folios);
        em.flush();

        TypesAttributes typesfechaIngreso = new TypesAttributes();
        typesfechaIngreso = findTypesAttributes("Date");

        Attributes fechaIngreso = new Attributes();
        fechaIngreso.setName("fechaIngreso");
        fechaIngreso.setType("Date");
        fechaIngreso.setTypesAttributes(typesfechaIngreso);
        fechaIngreso.setEntities(entradasArchivos);
        em.persist(fechaIngreso);
        em.flush();

        TypesAttributes typesfechaInicial = new TypesAttributes();
        typesfechaInicial = findTypesAttributes("Date");

        Attributes fechaInicial = new Attributes();
        fechaInicial.setName("fechaInicial");
        fechaInicial.setType("Date");
        fechaInicial.setTypesAttributes(typesfechaInicial);
        fechaInicial.setEntities(entradasArchivos);
        em.persist(fechaInicial);
        em.flush();

        TypesAttributes typesfechaFinal = new TypesAttributes();
        typesfechaFinal = findTypesAttributes("Date");

        Attributes fechaFinal = new Attributes();
        fechaFinal.setName("fechaFinal");
        fechaFinal.setType("Date");
        fechaFinal.setTypesAttributes(typesfechaFinal);
        fechaFinal.setEntities(entradasArchivos);
        em.persist(fechaFinal);
        em.flush();

        TypesAttributes typesfechaDepuracion = new TypesAttributes();
        typesfechaDepuracion = findTypesAttributes("Date");

        Attributes fechaDepuracion = new Attributes();
        fechaDepuracion.setName("fechaDepuracion");
        fechaDepuracion.setType("Date");
        fechaDepuracion.setTypesAttributes(typesfechaDepuracion);
        fechaDepuracion.setEntities(entradasArchivos);
        em.persist(fechaDepuracion);
        em.flush();

        TypesAttributes typesobservacion = new TypesAttributes();
        typesobservacion = findTypesAttributes("String");

        Attributes observacion = new Attributes();
        observacion.setName("observacion");
        observacion.setType("String");
        observacion.setTypesAttributes(typesobservacion);
        observacion.setEntities(entradasArchivos);
        em.persist(observacion);
        em.flush();

        TypesAttributes typessiDepurado = new TypesAttributes();
        typessiDepurado = findTypesAttributes("Boolean");

        Attributes siDepurado = new Attributes();
        siDepurado.setName("siDepurado");
        siDepurado.setType("Boolean");
        siDepurado.setTypesAttributes(typessiDepurado);
        siDepurado.setEntities(entradasArchivos);
        em.persist(siDepurado);
        em.flush();

    } // EntradasArchivos()

    public void Almacenamientos(DomainModels domainModel) {

        Entities almacenamientos = new Entities();
        almacenamientos.setName("Almacenamientos");
        almacenamientos.setDomainModels(domainModel);
        em.persist(almacenamientos);
        em.flush();

//      ---------------------- Attributes:Almacenamientos -------------------------

        TypesAttributes typescodigo = new TypesAttributes();
        typescodigo = findTypesAttributes("String");

        Attributes codigo = new Attributes();
        codigo.setName("codigo");
        codigo.setType("String");
        codigo.setTypesAttributes(typescodigo);
        codigo.setEntities(almacenamientos);
        em.persist(codigo);
        em.flush();

        TypesAttributes typesnombre = new TypesAttributes();
        typesnombre = findTypesAttributes("String");

        Attributes nombre = new Attributes();
        nombre.setName("nombre");
        nombre.setType("String");
        nombre.setTypesAttributes(typesnombre);
        nombre.setEntities(almacenamientos);
        em.persist(nombre);
        em.flush();

    } // Almacenamientos()

    public void TiposAlmacenamientos(DomainModels domainModel) {

        Entities tiposAlmacenamientos = new Entities();
        tiposAlmacenamientos.setName("TiposAlmacenamientos");
        tiposAlmacenamientos.setDomainModels(domainModel);
        em.persist(tiposAlmacenamientos);
        em.flush();

//      ---------------------- Attributes:TiposAlmacenamientos -------------------------

        TypesAttributes typescodigo = new TypesAttributes();
        typescodigo = findTypesAttributes("String");

        Attributes codigo = new Attributes();
        codigo.setName("codigo");
        codigo.setType("String");
        codigo.setTypesAttributes(typescodigo);
        codigo.setEntities(tiposAlmacenamientos);
        em.persist(codigo);
        em.flush();

        TypesAttributes typesnombre = new TypesAttributes();
        typesnombre = findTypesAttributes("String");

        Attributes nombre = new Attributes();
        nombre.setName("nombre");
        nombre.setType("String");
        nombre.setTypesAttributes(typesnombre);
        nombre.setEntities(tiposAlmacenamientos);
        em.persist(nombre);
        em.flush();

        TypesAttributes typesdescripcion = new TypesAttributes();
        typesdescripcion = findTypesAttributes("String");

        Attributes descripcion = new Attributes();
        descripcion.setName("descripcion");
        descripcion.setType("String");
        descripcion.setTypesAttributes(typesdescripcion);
        descripcion.setEntities(tiposAlmacenamientos);
        em.persist(descripcion);
        em.flush();

        TypesAttributes typeslink = new TypesAttributes();
        typeslink = findTypesAttributes("String");

        Attributes link = new Attributes();
        link.setName("link");
        link.setType("String");
        link.setTypesAttributes(typeslink);
        link.setEntities(tiposAlmacenamientos);
        em.persist(link);
        em.flush();

    } // TiposAlmacenamientos()

    public void TiposArchivos(DomainModels domainModel) {

        Entities tiposArchivos = new Entities();
        tiposArchivos.setName("TiposArchivos");
        tiposArchivos.setDomainModels(domainModel);
        em.persist(tiposArchivos);
        em.flush();

//      ---------------------- Attributes:TiposArchivos -------------------------

        TypesAttributes typesnombre = new TypesAttributes();
        typesnombre = findTypesAttributes("String");

        Attributes nombre = new Attributes();
        nombre.setName("nombre");
        nombre.setType("String");
        nombre.setTypesAttributes(typesnombre);
        nombre.setEntities(tiposArchivos);
        em.persist(nombre);
        em.flush();

    } // TiposArchivos()

    public void Ubicaciones(DomainModels domainModel) {

        Entities ubicaciones = new Entities();
        ubicaciones.setName("Ubicaciones");
        ubicaciones.setDomainModels(domainModel);
        em.persist(ubicaciones);
        em.flush();

//      ---------------------- Attributes:Ubicaciones -------------------------

        TypesAttributes typescodigo = new TypesAttributes();
        typescodigo = findTypesAttributes("String");

        Attributes codigo = new Attributes();
        codigo.setName("codigo");
        codigo.setType("String");
        codigo.setTypesAttributes(typescodigo);
        codigo.setEntities(ubicaciones);
        em.persist(codigo);
        em.flush();

        TypesAttributes typesnombre = new TypesAttributes();
        typesnombre = findTypesAttributes("String");

        Attributes nombre = new Attributes();
        nombre.setName("nombre");
        nombre.setType("String");
        nombre.setTypesAttributes(typesnombre);
        nombre.setEntities(ubicaciones);
        em.persist(nombre);
        em.flush();

    } // Ubicaciones()

    public void TiposUbicaciones(DomainModels domainModel) {

        Entities tiposUbicaciones = new Entities();
        tiposUbicaciones.setName("TiposUbicaciones");
        tiposUbicaciones.setDomainModels(domainModel);
        em.persist(tiposUbicaciones);
        em.flush();

//      ---------------------- Attributes:TiposUbicaciones -------------------------

        TypesAttributes typescodigo = new TypesAttributes();
        typescodigo = findTypesAttributes("String");

        Attributes codigo = new Attributes();
        codigo.setName("codigo");
        codigo.setType("String");
        codigo.setTypesAttributes(typescodigo);
        codigo.setEntities(tiposUbicaciones);
        em.persist(codigo);
        em.flush();

        TypesAttributes typesnombre = new TypesAttributes();
        typesnombre = findTypesAttributes("String");

        Attributes nombre = new Attributes();
        nombre.setName("nombre");
        nombre.setType("String");
        nombre.setTypesAttributes(typesnombre);
        nombre.setEntities(tiposUbicaciones);
        em.persist(nombre);
        em.flush();

        TypesAttributes typesdescripcion = new TypesAttributes();
        typesdescripcion = findTypesAttributes("String");

        Attributes descripcion = new Attributes();
        descripcion.setName("descripcion");
        descripcion.setType("String");
        descripcion.setTypesAttributes(typesdescripcion);
        descripcion.setEntities(tiposUbicaciones);
        em.persist(descripcion);
        em.flush();

        TypesAttributes typeslink = new TypesAttributes();
        typeslink = findTypesAttributes("String");

        Attributes link = new Attributes();
        link.setName("link");
        link.setType("String");
        link.setTypesAttributes(typeslink);
        link.setEntities(tiposUbicaciones);
        em.persist(link);
        em.flush();

    } // TiposUbicaciones()

    public void AnosDepuraciones(DomainModels domainModel) {

        Entities anosDepuraciones = new Entities();
        anosDepuraciones.setName("AnosDepuraciones");
        anosDepuraciones.setDomainModels(domainModel);
        em.persist(anosDepuraciones);
        em.flush();

//      ---------------------- Attributes:AnosDepuraciones -------------------------

        TypesAttributes typesnombre = new TypesAttributes();
        typesnombre = findTypesAttributes("String");

        Attributes nombre = new Attributes();
        nombre.setName("nombre");
        nombre.setType("String");
        nombre.setTypesAttributes(typesnombre);
        nombre.setEntities(anosDepuraciones);
        em.persist(nombre);
        em.flush();

    } // AnosDepuraciones()

    public void ArchivosInactivos(DomainModels domainModel) {

        Entities archivosInactivos = new Entities();
        archivosInactivos.setName("ArchivosInactivos");
        archivosInactivos.setDomainModels(domainModel);
        em.persist(archivosInactivos);
        em.flush();

//      ---------------------- Attributes:ArchivosInactivos -------------------------

        TypesAttributes typesobservacion = new TypesAttributes();
        typesobservacion = findTypesAttributes("String");

        Attributes observacion = new Attributes();
        observacion.setName("observacion");
        observacion.setType("String");
        observacion.setTypesAttributes(typesobservacion);
        observacion.setEntities(archivosInactivos);
        em.persist(observacion);
        em.flush();

    } // ArchivosInactivos()

    public void OtrosArchivos(DomainModels domainModel) {

        Entities otrosArchivos = new Entities();
        otrosArchivos.setName("OtrosArchivos");
        otrosArchivos.setDomainModels(domainModel);
        em.persist(otrosArchivos);
        em.flush();

//      ---------------------- Attributes:OtrosArchivos -------------------------

        TypesAttributes typesnombre = new TypesAttributes();
        typesnombre = findTypesAttributes("String");

        Attributes nombre = new Attributes();
        nombre.setName("nombre");
        nombre.setType("String");
        nombre.setTypesAttributes(typesnombre);
        nombre.setEntities(otrosArchivos);
        em.persist(nombre);
        em.flush();

        TypesAttributes typesalmacenamiento = new TypesAttributes();
        typesalmacenamiento = findTypesAttributes("String");

        Attributes almacenamiento = new Attributes();
        almacenamiento.setName("almacenamiento");
        almacenamiento.setType("String");
        almacenamiento.setTypesAttributes(typesalmacenamiento);
        almacenamiento.setEntities(otrosArchivos);
        em.persist(almacenamiento);
        em.flush();

        TypesAttributes typesobservaciones = new TypesAttributes();
        typesobservaciones = findTypesAttributes("String");

        Attributes observaciones = new Attributes();
        observaciones.setName("observaciones");
        observaciones.setType("String");
        observaciones.setTypesAttributes(typesobservaciones);
        observaciones.setEntities(otrosArchivos);
        em.persist(observaciones);
        em.flush();

    } // OtrosArchivos()

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

//  ---------------------- Relationships -------------------------

    public void Relations() {

//  ---------------------- EntradasArchivos 1..* ArchivosInactivos -------------------------

        Entities fromEntradasArchivos0 = new Entities();
        Cardinalities EntradasArchivos0 = new Cardinalities();
        Entities   toEntradasArchivos0 = new Entities();
        fromEntradasArchivos0 = findEntities("EntradasArchivos");
        EntradasArchivos0 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toEntradasArchivos0 = findEntities("ArchivosInactivos");
        Relationships relEntradasArchivos0 = new Relationships();
        relEntradasArchivos0.setFrom(fromEntradasArchivos0);
        relEntradasArchivos0.setCardinalities(EntradasArchivos0);
        relEntradasArchivos0.setTo(toEntradasArchivos0);
        relEntradasArchivos0.setOptionality(true);
        em.persist(relEntradasArchivos0);
        em.flush();

//  ---------------------- Almacenamientos 1..* ArchivosInactivos -------------------------

        Entities fromAlmacenamientos1 = new Entities();
        Cardinalities Almacenamientos1 = new Cardinalities();
        Entities   toAlmacenamientos1 = new Entities();
        fromAlmacenamientos1 = findEntities("Almacenamientos");
        Almacenamientos1 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toAlmacenamientos1 = findEntities("ArchivosInactivos");
        Relationships relAlmacenamientos1 = new Relationships();
        relAlmacenamientos1.setFrom(fromAlmacenamientos1);
        relAlmacenamientos1.setCardinalities(Almacenamientos1);
        relAlmacenamientos1.setTo(toAlmacenamientos1);
        relAlmacenamientos1.setOptionality(true);
        em.persist(relAlmacenamientos1);
        em.flush();

//  ---------------------- Almacenamientos 1..* OtrosArchivos -------------------------

        Entities fromAlmacenamientos2 = new Entities();
        Cardinalities Almacenamientos2 = new Cardinalities();
        Entities   toAlmacenamientos2 = new Entities();
        fromAlmacenamientos2 = findEntities("Almacenamientos");
        Almacenamientos2 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toAlmacenamientos2 = findEntities("OtrosArchivos");
        Relationships relAlmacenamientos2 = new Relationships();
        relAlmacenamientos2.setFrom(fromAlmacenamientos2);
        relAlmacenamientos2.setCardinalities(Almacenamientos2);
        relAlmacenamientos2.setTo(toAlmacenamientos2);
        relAlmacenamientos2.setOptionality(true);
        em.persist(relAlmacenamientos2);
        em.flush();

//  ---------------------- TiposAlmacenamientos 1..* Almacenamientos -------------------------

        Entities fromTiposAlmacenamientos3 = new Entities();
        Cardinalities TiposAlmacenamientos3 = new Cardinalities();
        Entities   toTiposAlmacenamientos3 = new Entities();
        fromTiposAlmacenamientos3 = findEntities("TiposAlmacenamientos");
        TiposAlmacenamientos3 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toTiposAlmacenamientos3 = findEntities("Almacenamientos");
        Relationships relTiposAlmacenamientos3 = new Relationships();
        relTiposAlmacenamientos3.setFrom(fromTiposAlmacenamientos3);
        relTiposAlmacenamientos3.setCardinalities(TiposAlmacenamientos3);
        relTiposAlmacenamientos3.setTo(toTiposAlmacenamientos3);
        relTiposAlmacenamientos3.setOptionality(true);
        em.persist(relTiposAlmacenamientos3);
        em.flush();

//  ---------------------- TiposArchivos 1..* EntradasArchivos -------------------------

        Entities fromTiposArchivos4 = new Entities();
        Cardinalities TiposArchivos4 = new Cardinalities();
        Entities   toTiposArchivos4 = new Entities();
        fromTiposArchivos4 = findEntities("TiposArchivos");
        TiposArchivos4 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toTiposArchivos4 = findEntities("EntradasArchivos");
        Relationships relTiposArchivos4 = new Relationships();
        relTiposArchivos4.setFrom(fromTiposArchivos4);
        relTiposArchivos4.setCardinalities(TiposArchivos4);
        relTiposArchivos4.setTo(toTiposArchivos4);
        relTiposArchivos4.setOptionality(true);
        em.persist(relTiposArchivos4);
        em.flush();

//  ---------------------- Ubicaciones 1..* Almacenamientos -------------------------

        Entities fromUbicaciones5 = new Entities();
        Cardinalities Ubicaciones5 = new Cardinalities();
        Entities   toUbicaciones5 = new Entities();
        fromUbicaciones5 = findEntities("Ubicaciones");
        Ubicaciones5 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toUbicaciones5 = findEntities("Almacenamientos");
        Relationships relUbicaciones5 = new Relationships();
        relUbicaciones5.setFrom(fromUbicaciones5);
        relUbicaciones5.setCardinalities(Ubicaciones5);
        relUbicaciones5.setTo(toUbicaciones5);
        relUbicaciones5.setOptionality(true);
        em.persist(relUbicaciones5);
        em.flush();

//  ---------------------- TiposUbicaciones 1..* Ubicaciones -------------------------

        Entities fromTiposUbicaciones6 = new Entities();
        Cardinalities TiposUbicaciones6 = new Cardinalities();
        Entities   toTiposUbicaciones6 = new Entities();
        fromTiposUbicaciones6 = findEntities("TiposUbicaciones");
        TiposUbicaciones6 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toTiposUbicaciones6 = findEntities("Ubicaciones");
        Relationships relTiposUbicaciones6 = new Relationships();
        relTiposUbicaciones6.setFrom(fromTiposUbicaciones6);
        relTiposUbicaciones6.setCardinalities(TiposUbicaciones6);
        relTiposUbicaciones6.setTo(toTiposUbicaciones6);
        relTiposUbicaciones6.setOptionality(true);
        em.persist(relTiposUbicaciones6);
        em.flush();

//  ---------------------- AnosDepuraciones 1..* EntradasArchivos -------------------------

        Entities fromAnosDepuraciones7 = new Entities();
        Cardinalities AnosDepuraciones7 = new Cardinalities();
        Entities   toAnosDepuraciones7 = new Entities();
        fromAnosDepuraciones7 = findEntities("AnosDepuraciones");
        AnosDepuraciones7 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toAnosDepuraciones7 = findEntities("EntradasArchivos");
        Relationships relAnosDepuraciones7 = new Relationships();
        relAnosDepuraciones7.setFrom(fromAnosDepuraciones7);
        relAnosDepuraciones7.setCardinalities(AnosDepuraciones7);
        relAnosDepuraciones7.setTo(toAnosDepuraciones7);
        relAnosDepuraciones7.setOptionality(true);
        em.persist(relAnosDepuraciones7);
        em.flush();

//  ---------------------- TiposDocumentos 1..* Lmds -------------------------

        Entities fromTiposDocumentos8 = new Entities();
        Cardinalities TiposDocumentos8 = new Cardinalities();
        Entities   toTiposDocumentos8 = new Entities();
        fromTiposDocumentos8 = findEntities("TiposDocumentos");
        TiposDocumentos8 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toTiposDocumentos8 = findEntities("Lmds");
        Relationships relTiposDocumentos8 = new Relationships();
        relTiposDocumentos8.setFrom(fromTiposDocumentos8);
        relTiposDocumentos8.setCardinalities(TiposDocumentos8);
        relTiposDocumentos8.setTo(toTiposDocumentos8);
        relTiposDocumentos8.setOptionality(true);
        em.persist(relTiposDocumentos8);
        em.flush();

//  ---------------------- EstadosDocuementos 1..* Lmds -------------------------

        Entities fromEstadosDocuementos9 = new Entities();
        Cardinalities EstadosDocuementos9 = new Cardinalities();
        Entities   toEstadosDocuementos9 = new Entities();
        fromEstadosDocuementos9 = findEntities("EstadosDocuementos");
        EstadosDocuementos9 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toEstadosDocuementos9 = findEntities("Lmds");
        Relationships relEstadosDocuementos9 = new Relationships();
        relEstadosDocuementos9.setFrom(fromEstadosDocuementos9);
        relEstadosDocuementos9.setCardinalities(EstadosDocuementos9);
        relEstadosDocuementos9.setTo(toEstadosDocuementos9);
        relEstadosDocuementos9.setOptionality(true);
        em.persist(relEstadosDocuementos9);
        em.flush();

//  ---------------------- Lmrs 1..* EntradasArchivos -------------------------

        Entities fromLmrs10 = new Entities();
        Cardinalities Lmrs10 = new Cardinalities();
        Entities   toLmrs10 = new Entities();
        fromLmrs10 = findEntities("Lmrs");
        Lmrs10 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toLmrs10 = findEntities("EntradasArchivos");
        Relationships relLmrs10 = new Relationships();
        relLmrs10.setFrom(fromLmrs10);
        relLmrs10.setCardinalities(Lmrs10);
        relLmrs10.setTo(toLmrs10);
        relLmrs10.setOptionality(true);
        em.persist(relLmrs10);
        em.flush();

//  ---------------------- Instituciones 1..* Lmrs -------------------------

        Entities fromInstituciones11 = new Entities();
        Cardinalities Instituciones11 = new Cardinalities();
        Entities   toInstituciones11 = new Entities();
        fromInstituciones11 = findEntities("Instituciones");
        Instituciones11 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toInstituciones11 = findEntities("Lmrs");
        Relationships relInstituciones11 = new Relationships();
        relInstituciones11.setFrom(fromInstituciones11);
        relInstituciones11.setCardinalities(Instituciones11);
        relInstituciones11.setTo(toInstituciones11);
        relInstituciones11.setOptionality(true);
        em.persist(relInstituciones11);
        em.flush();

//  ---------------------- TiposRegistros 1..* Lmrs -------------------------

        Entities fromTiposRegistros12 = new Entities();
        Cardinalities TiposRegistros12 = new Cardinalities();
        Entities   toTiposRegistros12 = new Entities();
        fromTiposRegistros12 = findEntities("TiposRegistros");
        TiposRegistros12 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toTiposRegistros12 = findEntities("Lmrs");
        Relationships relTiposRegistros12 = new Relationships();
        relTiposRegistros12.setFrom(fromTiposRegistros12);
        relTiposRegistros12.setCardinalities(TiposRegistros12);
        relTiposRegistros12.setTo(toTiposRegistros12);
        relTiposRegistros12.setOptionality(true);
        em.persist(relTiposRegistros12);
        em.flush();

//  ---------------------- Medios 1..* Lmrs -------------------------

        Entities fromMedios13 = new Entities();
        Cardinalities Medios13 = new Cardinalities();
        Entities   toMedios13 = new Entities();
        fromMedios13 = findEntities("Medios");
        Medios13 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toMedios13 = findEntities("Lmrs");
        Relationships relMedios13 = new Relationships();
        relMedios13.setFrom(fromMedios13);
        relMedios13.setCardinalities(Medios13);
        relMedios13.setTo(toMedios13);
        relMedios13.setOptionality(true);
        em.persist(relMedios13);
        em.flush();

//  ---------------------- Dependencias 1..* Lmrs -------------------------

        Entities fromDependencias14 = new Entities();
        Cardinalities Dependencias14 = new Cardinalities();
        Entities   toDependencias14 = new Entities();
        fromDependencias14 = findEntities("Dependencias");
        Dependencias14 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toDependencias14 = findEntities("Lmrs");
        Relationships relDependencias14 = new Relationships();
        relDependencias14.setFrom(fromDependencias14);
        relDependencias14.setCardinalities(Dependencias14);
        relDependencias14.setTo(toDependencias14);
        relDependencias14.setOptionality(true);
        em.persist(relDependencias14);
        em.flush();

//  ---------------------- Indexaciones 1..* Lmrs -------------------------

        Entities fromIndexaciones15 = new Entities();
        Cardinalities Indexaciones15 = new Cardinalities();
        Entities   toIndexaciones15 = new Entities();
        fromIndexaciones15 = findEntities("Indexaciones");
        Indexaciones15 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toIndexaciones15 = findEntities("Lmrs");
        Relationships relIndexaciones15 = new Relationships();
        relIndexaciones15.setFrom(fromIndexaciones15);
        relIndexaciones15.setCardinalities(Indexaciones15);
        relIndexaciones15.setTo(toIndexaciones15);
        relIndexaciones15.setOptionality(true);
        em.persist(relIndexaciones15);
        em.flush();

//  ---------------------- Responsables 1..* Lmrs -------------------------

        Entities fromResponsables16 = new Entities();
        Cardinalities Responsables16 = new Cardinalities();
        Entities   toResponsables16 = new Entities();
        fromResponsables16 = findEntities("Responsables");
        Responsables16 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toResponsables16 = findEntities("Lmrs");
        Relationships relResponsables16 = new Relationships();
        relResponsables16.setFrom(fromResponsables16);
        relResponsables16.setCardinalities(Responsables16);
        relResponsables16.setTo(toResponsables16);
        relResponsables16.setOptionality(true);
        em.persist(relResponsables16);
        em.flush();

//  ---------------------- TiposAccesos 1..* Lmrs -------------------------

        Entities fromTiposAccesos17 = new Entities();
        Cardinalities TiposAccesos17 = new Cardinalities();
        Entities   toTiposAccesos17 = new Entities();
        fromTiposAccesos17 = findEntities("TiposAccesos");
        TiposAccesos17 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toTiposAccesos17 = findEntities("Lmrs");
        Relationships relTiposAccesos17 = new Relationships();
        relTiposAccesos17.setFrom(fromTiposAccesos17);
        relTiposAccesos17.setCardinalities(TiposAccesos17);
        relTiposAccesos17.setTo(toTiposAccesos17);
        relTiposAccesos17.setOptionality(true);
        em.persist(relTiposAccesos17);
        em.flush();

//  ---------------------- TrdAreas 1..* Lmrs -------------------------

        Entities fromTrdAreas18 = new Entities();
        Cardinalities TrdAreas18 = new Cardinalities();
        Entities   toTrdAreas18 = new Entities();
        fromTrdAreas18 = findEntities("TrdAreas");
        TrdAreas18 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toTrdAreas18 = findEntities("Lmrs");
        Relationships relTrdAreas18 = new Relationships();
        relTrdAreas18.setFrom(fromTrdAreas18);
        relTrdAreas18.setCardinalities(TrdAreas18);
        relTrdAreas18.setTo(toTrdAreas18);
        relTrdAreas18.setOptionality(true);
        em.persist(relTrdAreas18);
        em.flush();

//  ---------------------- DisposicionFinal 1..* Lmrs -------------------------

        Entities fromDisposicionFinal19 = new Entities();
        Cardinalities DisposicionFinal19 = new Cardinalities();
        Entities   toDisposicionFinal19 = new Entities();
        fromDisposicionFinal19 = findEntities("DisposicionFinal");
        DisposicionFinal19 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toDisposicionFinal19 = findEntities("Lmrs");
        Relationships relDisposicionFinal19 = new Relationships();
        relDisposicionFinal19.setFrom(fromDisposicionFinal19);
        relDisposicionFinal19.setCardinalities(DisposicionFinal19);
        relDisposicionFinal19.setTo(toDisposicionFinal19);
        relDisposicionFinal19.setOptionality(true);
        em.persist(relDisposicionFinal19);
        em.flush();

//  ---------------------- Estados 1..* Lmrs -------------------------

        Entities fromEstados20 = new Entities();
        Cardinalities Estados20 = new Cardinalities();
        Entities   toEstados20 = new Entities();
        fromEstados20 = findEntities("Estados");
        Estados20 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toEstados20 = findEntities("Lmrs");
        Relationships relEstados20 = new Relationships();
        relEstados20.setFrom(fromEstados20);
        relEstados20.setCardinalities(Estados20);
        relEstados20.setTo(toEstados20);
        relEstados20.setOptionality(true);
        em.persist(relEstados20);
        em.flush();

//  ---------------------- TiposLmrs 1..* Lmrs -------------------------

        Entities fromTiposLmrs21 = new Entities();
        Cardinalities TiposLmrs21 = new Cardinalities();
        Entities   toTiposLmrs21 = new Entities();
        fromTiposLmrs21 = findEntities("TiposLmrs");
        TiposLmrs21 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toTiposLmrs21 = findEntities("Lmrs");
        Relationships relTiposLmrs21 = new Relationships();
        relTiposLmrs21.setFrom(fromTiposLmrs21);
        relTiposLmrs21.setCardinalities(TiposLmrs21);
        relTiposLmrs21.setTo(toTiposLmrs21);
        relTiposLmrs21.setOptionality(true);
        em.persist(relTiposLmrs21);
        em.flush();

//  ---------------------- TrdArchivos 1..* Lmrs -------------------------

        Entities fromTrdArchivos22 = new Entities();
        Cardinalities TrdArchivos22 = new Cardinalities();
        Entities   toTrdArchivos22 = new Entities();
        fromTrdArchivos22 = findEntities("TrdArchivos");
        TrdArchivos22 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toTrdArchivos22 = findEntities("Lmrs");
        Relationships relTrdArchivos22 = new Relationships();
        relTrdArchivos22.setFrom(fromTrdArchivos22);
        relTrdArchivos22.setCardinalities(TrdArchivos22);
        relTrdArchivos22.setTo(toTrdArchivos22);
        relTrdArchivos22.setOptionality(true);
        em.persist(relTrdArchivos22);
        em.flush();

//  ---------------------- TiposProcesos 1..* Procesos -------------------------

        Entities fromTiposProcesos23 = new Entities();
        Cardinalities TiposProcesos23 = new Cardinalities();
        Entities   toTiposProcesos23 = new Entities();
        fromTiposProcesos23 = findEntities("TiposProcesos");
        TiposProcesos23 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toTiposProcesos23 = findEntities("Procesos");
        Relationships relTiposProcesos23 = new Relationships();
        relTiposProcesos23.setFrom(fromTiposProcesos23);
        relTiposProcesos23.setCardinalities(TiposProcesos23);
        relTiposProcesos23.setTo(toTiposProcesos23);
        relTiposProcesos23.setOptionality(true);
        em.persist(relTiposProcesos23);
        em.flush();

//  ---------------------- Procesos 1..* Lmds -------------------------

        Entities fromProcesos24 = new Entities();
        Cardinalities Procesos24 = new Cardinalities();
        Entities   toProcesos24 = new Entities();
        fromProcesos24 = findEntities("Procesos");
        Procesos24 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toProcesos24 = findEntities("Lmds");
        Relationships relProcesos24 = new Relationships();
        relProcesos24.setFrom(fromProcesos24);
        relProcesos24.setCardinalities(Procesos24);
        relProcesos24.setTo(toProcesos24);
        relProcesos24.setOptionality(true);
        em.persist(relProcesos24);
        em.flush();

//  ---------------------- Procesos 1..* Lmrs -------------------------

        Entities fromProcesos25 = new Entities();
        Cardinalities Procesos25 = new Cardinalities();
        Entities   toProcesos25 = new Entities();
        fromProcesos25 = findEntities("Procesos");
        Procesos25 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toProcesos25 = findEntities("Lmrs");
        Relationships relProcesos25 = new Relationships();
        relProcesos25.setFrom(fromProcesos25);
        relProcesos25.setCardinalities(Procesos25);
        relProcesos25.setTo(toProcesos25);
        relProcesos25.setOptionality(true);
        em.persist(relProcesos25);
        em.flush();

//  ---------------------- Procesos 1..* Procesos -------------------------

        Entities fromProcesos26 = new Entities();
        Cardinalities Procesos26 = new Cardinalities();
        Entities   toProcesos26 = new Entities();
        fromProcesos26 = findEntities("Procesos");
        Procesos26 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toProcesos26 = findEntities("Procesos");
        Relationships relProcesos26 = new Relationships();
        relProcesos26.setFrom(fromProcesos26);
        relProcesos26.setCardinalities(Procesos26);
        relProcesos26.setTo(toProcesos26);
        relProcesos26.setOptionality(true);
        em.persist(relProcesos26);
        em.flush();

    } // Relations()
} // DomainModelsSetup

