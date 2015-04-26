package co.simasoft.setup;

import co.simasoft.models.naif.DomainModels.*;

import co.simasoft.utils.*;

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
        domainModels.setName(Utils.nameRandom());
        em.persist(domainModels);
        em.flush();

        GroupIds groupId0 = new GroupIds();
        groupId0.setGroupId("co.simasoft.models.naif.iso.procesos");
        groupId0.setDomainModels(domainModels);
        em.persist(groupId0);
        em.flush();

        TiposProcesos(groupId0);
        Procesos(groupId0);

        GroupIds groupId1 = new GroupIds();
        groupId1.setGroupId("co.simasoft.models.naif.iso.lmd");
        groupId1.setDomainModels(domainModels);
        em.persist(groupId1);
        em.flush();

        TiposDocumentos(groupId1);
        Lmds(groupId1);
        EstadosDocuementos(groupId1);

        GroupIds groupId2 = new GroupIds();
        groupId2.setGroupId("co.simasoft.models.naif.iso.lmr");
        groupId2.setDomainModels(domainModels);
        em.persist(groupId2);
        em.flush();

        Lmrs(groupId2);
        Instituciones(groupId2);
        TiposRegistros(groupId2);
        Medios(groupId2);
        Dependencias(groupId2);
        Indexaciones(groupId2);
        Responsables(groupId2);
        TiposAccesos(groupId2);
        TrdAreas(groupId2);
        DisposicionFinal(groupId2);
        Estados(groupId2);
        TiposLmrs(groupId2);
        TrdArchivos(groupId2);

        GroupIds groupId3 = new GroupIds();
        groupId3.setGroupId("co.simasoft.models.naif.iso.archivoInactivo");
        groupId3.setDomainModels(domainModels);
        em.persist(groupId3);
        em.flush();

        EntradasArchivos(groupId3);
        Almacenamientos(groupId3);
        TiposAlmacenamientos(groupId3);
        TiposArchivos(groupId3);
        Ubicaciones(groupId3);
        TiposUbicaciones(groupId3);
        AnosDepuraciones(groupId3);
        ArchivosInactivos(groupId3);
        OtrosArchivos(groupId3);

        Relations();

    } // data()

    public void TiposProcesos(GroupIds groupIds) {

        Entities tiposProcesos = new Entities();
        tiposProcesos.setName("TiposProcesos");
        tiposProcesos.setGroupIds(groupIds);
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

    public void Procesos(GroupIds groupIds) {

        Entities procesos = new Entities();
        procesos.setName("Procesos");
        procesos.setGroupIds(groupIds);
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

    public void TiposDocumentos(GroupIds groupIds) {

        Entities tiposDocumentos = new Entities();
        tiposDocumentos.setName("TiposDocumentos");
        tiposDocumentos.setGroupIds(groupIds);
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

    public void Lmds(GroupIds groupIds) {

        Entities lmds = new Entities();
        lmds.setName("Lmds");
        lmds.setGroupIds(groupIds);
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

    public void EstadosDocuementos(GroupIds groupIds) {

        Entities estadosDocuementos = new Entities();
        estadosDocuementos.setName("EstadosDocuementos");
        estadosDocuementos.setGroupIds(groupIds);
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

    public void Lmrs(GroupIds groupIds) {

        Entities lmrs = new Entities();
        lmrs.setName("Lmrs");
        lmrs.setGroupIds(groupIds);
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

    public void Instituciones(GroupIds groupIds) {

        Entities instituciones = new Entities();
        instituciones.setName("Instituciones");
        instituciones.setGroupIds(groupIds);
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

    public void TiposRegistros(GroupIds groupIds) {

        Entities tiposRegistros = new Entities();
        tiposRegistros.setName("TiposRegistros");
        tiposRegistros.setGroupIds(groupIds);
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

    public void Medios(GroupIds groupIds) {

        Entities medios = new Entities();
        medios.setName("Medios");
        medios.setGroupIds(groupIds);
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

    public void Dependencias(GroupIds groupIds) {

        Entities dependencias = new Entities();
        dependencias.setName("Dependencias");
        dependencias.setGroupIds(groupIds);
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

    public void Indexaciones(GroupIds groupIds) {

        Entities indexaciones = new Entities();
        indexaciones.setName("Indexaciones");
        indexaciones.setGroupIds(groupIds);
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

    public void Responsables(GroupIds groupIds) {

        Entities responsables = new Entities();
        responsables.setName("Responsables");
        responsables.setGroupIds(groupIds);
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

    public void TiposAccesos(GroupIds groupIds) {

        Entities tiposAccesos = new Entities();
        tiposAccesos.setName("TiposAccesos");
        tiposAccesos.setGroupIds(groupIds);
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

    public void TrdAreas(GroupIds groupIds) {

        Entities trdAreas = new Entities();
        trdAreas.setName("TrdAreas");
        trdAreas.setGroupIds(groupIds);
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

    public void DisposicionFinal(GroupIds groupIds) {

        Entities disposicionFinal = new Entities();
        disposicionFinal.setName("DisposicionFinal");
        disposicionFinal.setGroupIds(groupIds);
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

    public void Estados(GroupIds groupIds) {

        Entities estados = new Entities();
        estados.setName("Estados");
        estados.setGroupIds(groupIds);
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

    public void TiposLmrs(GroupIds groupIds) {

        Entities tiposLmrs = new Entities();
        tiposLmrs.setName("TiposLmrs");
        tiposLmrs.setGroupIds(groupIds);
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

    public void TrdArchivos(GroupIds groupIds) {

        Entities trdArchivos = new Entities();
        trdArchivos.setName("TrdArchivos");
        trdArchivos.setGroupIds(groupIds);
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

    public void EntradasArchivos(GroupIds groupIds) {

        Entities entradasArchivos = new Entities();
        entradasArchivos.setName("EntradasArchivos");
        entradasArchivos.setGroupIds(groupIds);
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

    public void Almacenamientos(GroupIds groupIds) {

        Entities almacenamientos = new Entities();
        almacenamientos.setName("Almacenamientos");
        almacenamientos.setGroupIds(groupIds);
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

    public void TiposAlmacenamientos(GroupIds groupIds) {

        Entities tiposAlmacenamientos = new Entities();
        tiposAlmacenamientos.setName("TiposAlmacenamientos");
        tiposAlmacenamientos.setGroupIds(groupIds);
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

    public void TiposArchivos(GroupIds groupIds) {

        Entities tiposArchivos = new Entities();
        tiposArchivos.setName("TiposArchivos");
        tiposArchivos.setGroupIds(groupIds);
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

    public void Ubicaciones(GroupIds groupIds) {

        Entities ubicaciones = new Entities();
        ubicaciones.setName("Ubicaciones");
        ubicaciones.setGroupIds(groupIds);
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

    public void TiposUbicaciones(GroupIds groupIds) {

        Entities tiposUbicaciones = new Entities();
        tiposUbicaciones.setName("TiposUbicaciones");
        tiposUbicaciones.setGroupIds(groupIds);
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

    public void AnosDepuraciones(GroupIds groupIds) {

        Entities anosDepuraciones = new Entities();
        anosDepuraciones.setName("AnosDepuraciones");
        anosDepuraciones.setGroupIds(groupIds);
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

    public void ArchivosInactivos(GroupIds groupIds) {

        Entities archivosInactivos = new Entities();
        archivosInactivos.setName("ArchivosInactivos");
        archivosInactivos.setGroupIds(groupIds);
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

    public void OtrosArchivos(GroupIds groupIds) {

        Entities otrosArchivos = new Entities();
        otrosArchivos.setName("OtrosArchivos");
        otrosArchivos.setGroupIds(groupIds);
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

//  ---------------------- Relationships -------------------------

    public void Relations() {

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

//  ---------------------- Procesos 1..* Lmrs -------------------------

        Entities fromProcesos1 = new Entities();
        Cardinalities Procesos1 = new Cardinalities();
        Entities   toProcesos1 = new Entities();
        fromProcesos1 = findEntities("Procesos");
        Procesos1 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toProcesos1 = findEntities("Lmrs");
        Relationships relProcesos1 = new Relationships();
        relProcesos1.setFrom(fromProcesos1);
        relProcesos1.setCardinalities(Procesos1);
        relProcesos1.setTo(toProcesos1);
        relProcesos1.setOptionality(true);
        em.persist(relProcesos1);
        em.flush();

//  ---------------------- Procesos 1..* Lmds -------------------------

        Entities fromProcesos2 = new Entities();
        Cardinalities Procesos2 = new Cardinalities();
        Entities   toProcesos2 = new Entities();
        fromProcesos2 = findEntities("Procesos");
        Procesos2 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toProcesos2 = findEntities("Lmds");
        Relationships relProcesos2 = new Relationships();
        relProcesos2.setFrom(fromProcesos2);
        relProcesos2.setCardinalities(Procesos2);
        relProcesos2.setTo(toProcesos2);
        relProcesos2.setOptionality(true);
        em.persist(relProcesos2);
        em.flush();

//  ---------------------- TiposDocumentos 1..* Lmds -------------------------

        Entities fromTiposDocumentos3 = new Entities();
        Cardinalities TiposDocumentos3 = new Cardinalities();
        Entities   toTiposDocumentos3 = new Entities();
        fromTiposDocumentos3 = findEntities("TiposDocumentos");
        TiposDocumentos3 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toTiposDocumentos3 = findEntities("Lmds");
        Relationships relTiposDocumentos3 = new Relationships();
        relTiposDocumentos3.setFrom(fromTiposDocumentos3);
        relTiposDocumentos3.setCardinalities(TiposDocumentos3);
        relTiposDocumentos3.setTo(toTiposDocumentos3);
        relTiposDocumentos3.setOptionality(true);
        em.persist(relTiposDocumentos3);
        em.flush();

//  ---------------------- EstadosDocuementos 1..* Lmds -------------------------

        Entities fromEstadosDocuementos4 = new Entities();
        Cardinalities EstadosDocuementos4 = new Cardinalities();
        Entities   toEstadosDocuementos4 = new Entities();
        fromEstadosDocuementos4 = findEntities("EstadosDocuementos");
        EstadosDocuementos4 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toEstadosDocuementos4 = findEntities("Lmds");
        Relationships relEstadosDocuementos4 = new Relationships();
        relEstadosDocuementos4.setFrom(fromEstadosDocuementos4);
        relEstadosDocuementos4.setCardinalities(EstadosDocuementos4);
        relEstadosDocuementos4.setTo(toEstadosDocuementos4);
        relEstadosDocuementos4.setOptionality(true);
        em.persist(relEstadosDocuementos4);
        em.flush();

//  ---------------------- Lmrs 1..* EntradasArchivos -------------------------

        Entities fromLmrs5 = new Entities();
        Cardinalities Lmrs5 = new Cardinalities();
        Entities   toLmrs5 = new Entities();
        fromLmrs5 = findEntities("Lmrs");
        Lmrs5 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toLmrs5 = findEntities("EntradasArchivos");
        Relationships relLmrs5 = new Relationships();
        relLmrs5.setFrom(fromLmrs5);
        relLmrs5.setCardinalities(Lmrs5);
        relLmrs5.setTo(toLmrs5);
        relLmrs5.setOptionality(true);
        em.persist(relLmrs5);
        em.flush();

//  ---------------------- Instituciones 1..* Lmrs -------------------------

        Entities fromInstituciones6 = new Entities();
        Cardinalities Instituciones6 = new Cardinalities();
        Entities   toInstituciones6 = new Entities();
        fromInstituciones6 = findEntities("Instituciones");
        Instituciones6 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toInstituciones6 = findEntities("Lmrs");
        Relationships relInstituciones6 = new Relationships();
        relInstituciones6.setFrom(fromInstituciones6);
        relInstituciones6.setCardinalities(Instituciones6);
        relInstituciones6.setTo(toInstituciones6);
        relInstituciones6.setOptionality(true);
        em.persist(relInstituciones6);
        em.flush();

//  ---------------------- TiposRegistros 1..* Lmrs -------------------------

        Entities fromTiposRegistros7 = new Entities();
        Cardinalities TiposRegistros7 = new Cardinalities();
        Entities   toTiposRegistros7 = new Entities();
        fromTiposRegistros7 = findEntities("TiposRegistros");
        TiposRegistros7 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toTiposRegistros7 = findEntities("Lmrs");
        Relationships relTiposRegistros7 = new Relationships();
        relTiposRegistros7.setFrom(fromTiposRegistros7);
        relTiposRegistros7.setCardinalities(TiposRegistros7);
        relTiposRegistros7.setTo(toTiposRegistros7);
        relTiposRegistros7.setOptionality(true);
        em.persist(relTiposRegistros7);
        em.flush();

//  ---------------------- Medios 1..* Lmrs -------------------------

        Entities fromMedios8 = new Entities();
        Cardinalities Medios8 = new Cardinalities();
        Entities   toMedios8 = new Entities();
        fromMedios8 = findEntities("Medios");
        Medios8 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toMedios8 = findEntities("Lmrs");
        Relationships relMedios8 = new Relationships();
        relMedios8.setFrom(fromMedios8);
        relMedios8.setCardinalities(Medios8);
        relMedios8.setTo(toMedios8);
        relMedios8.setOptionality(true);
        em.persist(relMedios8);
        em.flush();

//  ---------------------- Dependencias 1..* Lmrs -------------------------

        Entities fromDependencias9 = new Entities();
        Cardinalities Dependencias9 = new Cardinalities();
        Entities   toDependencias9 = new Entities();
        fromDependencias9 = findEntities("Dependencias");
        Dependencias9 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toDependencias9 = findEntities("Lmrs");
        Relationships relDependencias9 = new Relationships();
        relDependencias9.setFrom(fromDependencias9);
        relDependencias9.setCardinalities(Dependencias9);
        relDependencias9.setTo(toDependencias9);
        relDependencias9.setOptionality(true);
        em.persist(relDependencias9);
        em.flush();

//  ---------------------- Indexaciones 1..* Lmrs -------------------------

        Entities fromIndexaciones10 = new Entities();
        Cardinalities Indexaciones10 = new Cardinalities();
        Entities   toIndexaciones10 = new Entities();
        fromIndexaciones10 = findEntities("Indexaciones");
        Indexaciones10 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toIndexaciones10 = findEntities("Lmrs");
        Relationships relIndexaciones10 = new Relationships();
        relIndexaciones10.setFrom(fromIndexaciones10);
        relIndexaciones10.setCardinalities(Indexaciones10);
        relIndexaciones10.setTo(toIndexaciones10);
        relIndexaciones10.setOptionality(true);
        em.persist(relIndexaciones10);
        em.flush();

//  ---------------------- Responsables 1..* Lmrs -------------------------

        Entities fromResponsables11 = new Entities();
        Cardinalities Responsables11 = new Cardinalities();
        Entities   toResponsables11 = new Entities();
        fromResponsables11 = findEntities("Responsables");
        Responsables11 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toResponsables11 = findEntities("Lmrs");
        Relationships relResponsables11 = new Relationships();
        relResponsables11.setFrom(fromResponsables11);
        relResponsables11.setCardinalities(Responsables11);
        relResponsables11.setTo(toResponsables11);
        relResponsables11.setOptionality(true);
        em.persist(relResponsables11);
        em.flush();

//  ---------------------- TiposAccesos 1..* Lmrs -------------------------

        Entities fromTiposAccesos12 = new Entities();
        Cardinalities TiposAccesos12 = new Cardinalities();
        Entities   toTiposAccesos12 = new Entities();
        fromTiposAccesos12 = findEntities("TiposAccesos");
        TiposAccesos12 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toTiposAccesos12 = findEntities("Lmrs");
        Relationships relTiposAccesos12 = new Relationships();
        relTiposAccesos12.setFrom(fromTiposAccesos12);
        relTiposAccesos12.setCardinalities(TiposAccesos12);
        relTiposAccesos12.setTo(toTiposAccesos12);
        relTiposAccesos12.setOptionality(true);
        em.persist(relTiposAccesos12);
        em.flush();

//  ---------------------- TrdAreas 1..* Lmrs -------------------------

        Entities fromTrdAreas13 = new Entities();
        Cardinalities TrdAreas13 = new Cardinalities();
        Entities   toTrdAreas13 = new Entities();
        fromTrdAreas13 = findEntities("TrdAreas");
        TrdAreas13 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toTrdAreas13 = findEntities("Lmrs");
        Relationships relTrdAreas13 = new Relationships();
        relTrdAreas13.setFrom(fromTrdAreas13);
        relTrdAreas13.setCardinalities(TrdAreas13);
        relTrdAreas13.setTo(toTrdAreas13);
        relTrdAreas13.setOptionality(true);
        em.persist(relTrdAreas13);
        em.flush();

//  ---------------------- DisposicionFinal 1..* Lmrs -------------------------

        Entities fromDisposicionFinal14 = new Entities();
        Cardinalities DisposicionFinal14 = new Cardinalities();
        Entities   toDisposicionFinal14 = new Entities();
        fromDisposicionFinal14 = findEntities("DisposicionFinal");
        DisposicionFinal14 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toDisposicionFinal14 = findEntities("Lmrs");
        Relationships relDisposicionFinal14 = new Relationships();
        relDisposicionFinal14.setFrom(fromDisposicionFinal14);
        relDisposicionFinal14.setCardinalities(DisposicionFinal14);
        relDisposicionFinal14.setTo(toDisposicionFinal14);
        relDisposicionFinal14.setOptionality(true);
        em.persist(relDisposicionFinal14);
        em.flush();

//  ---------------------- Estados 1..* Lmrs -------------------------

        Entities fromEstados15 = new Entities();
        Cardinalities Estados15 = new Cardinalities();
        Entities   toEstados15 = new Entities();
        fromEstados15 = findEntities("Estados");
        Estados15 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toEstados15 = findEntities("Lmrs");
        Relationships relEstados15 = new Relationships();
        relEstados15.setFrom(fromEstados15);
        relEstados15.setCardinalities(Estados15);
        relEstados15.setTo(toEstados15);
        relEstados15.setOptionality(true);
        em.persist(relEstados15);
        em.flush();

//  ---------------------- TiposLmrs 1..* Lmrs -------------------------

        Entities fromTiposLmrs16 = new Entities();
        Cardinalities TiposLmrs16 = new Cardinalities();
        Entities   toTiposLmrs16 = new Entities();
        fromTiposLmrs16 = findEntities("TiposLmrs");
        TiposLmrs16 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toTiposLmrs16 = findEntities("Lmrs");
        Relationships relTiposLmrs16 = new Relationships();
        relTiposLmrs16.setFrom(fromTiposLmrs16);
        relTiposLmrs16.setCardinalities(TiposLmrs16);
        relTiposLmrs16.setTo(toTiposLmrs16);
        relTiposLmrs16.setOptionality(true);
        em.persist(relTiposLmrs16);
        em.flush();

//  ---------------------- TrdArchivos 1..* Lmrs -------------------------

        Entities fromTrdArchivos17 = new Entities();
        Cardinalities TrdArchivos17 = new Cardinalities();
        Entities   toTrdArchivos17 = new Entities();
        fromTrdArchivos17 = findEntities("TrdArchivos");
        TrdArchivos17 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toTrdArchivos17 = findEntities("Lmrs");
        Relationships relTrdArchivos17 = new Relationships();
        relTrdArchivos17.setFrom(fromTrdArchivos17);
        relTrdArchivos17.setCardinalities(TrdArchivos17);
        relTrdArchivos17.setTo(toTrdArchivos17);
        relTrdArchivos17.setOptionality(true);
        em.persist(relTrdArchivos17);
        em.flush();

//  ---------------------- EntradasArchivos 1..* ArchivosInactivos -------------------------

        Entities fromEntradasArchivos18 = new Entities();
        Cardinalities EntradasArchivos18 = new Cardinalities();
        Entities   toEntradasArchivos18 = new Entities();
        fromEntradasArchivos18 = findEntities("EntradasArchivos");
        EntradasArchivos18 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toEntradasArchivos18 = findEntities("ArchivosInactivos");
        Relationships relEntradasArchivos18 = new Relationships();
        relEntradasArchivos18.setFrom(fromEntradasArchivos18);
        relEntradasArchivos18.setCardinalities(EntradasArchivos18);
        relEntradasArchivos18.setTo(toEntradasArchivos18);
        relEntradasArchivos18.setOptionality(true);
        em.persist(relEntradasArchivos18);
        em.flush();

//  ---------------------- Almacenamientos 1..* OtrosArchivos -------------------------

        Entities fromAlmacenamientos19 = new Entities();
        Cardinalities Almacenamientos19 = new Cardinalities();
        Entities   toAlmacenamientos19 = new Entities();
        fromAlmacenamientos19 = findEntities("Almacenamientos");
        Almacenamientos19 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toAlmacenamientos19 = findEntities("OtrosArchivos");
        Relationships relAlmacenamientos19 = new Relationships();
        relAlmacenamientos19.setFrom(fromAlmacenamientos19);
        relAlmacenamientos19.setCardinalities(Almacenamientos19);
        relAlmacenamientos19.setTo(toAlmacenamientos19);
        relAlmacenamientos19.setOptionality(true);
        em.persist(relAlmacenamientos19);
        em.flush();

//  ---------------------- Almacenamientos 1..* ArchivosInactivos -------------------------

        Entities fromAlmacenamientos20 = new Entities();
        Cardinalities Almacenamientos20 = new Cardinalities();
        Entities   toAlmacenamientos20 = new Entities();
        fromAlmacenamientos20 = findEntities("Almacenamientos");
        Almacenamientos20 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toAlmacenamientos20 = findEntities("ArchivosInactivos");
        Relationships relAlmacenamientos20 = new Relationships();
        relAlmacenamientos20.setFrom(fromAlmacenamientos20);
        relAlmacenamientos20.setCardinalities(Almacenamientos20);
        relAlmacenamientos20.setTo(toAlmacenamientos20);
        relAlmacenamientos20.setOptionality(true);
        em.persist(relAlmacenamientos20);
        em.flush();

//  ---------------------- TiposAlmacenamientos 1..* Almacenamientos -------------------------

        Entities fromTiposAlmacenamientos21 = new Entities();
        Cardinalities TiposAlmacenamientos21 = new Cardinalities();
        Entities   toTiposAlmacenamientos21 = new Entities();
        fromTiposAlmacenamientos21 = findEntities("TiposAlmacenamientos");
        TiposAlmacenamientos21 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toTiposAlmacenamientos21 = findEntities("Almacenamientos");
        Relationships relTiposAlmacenamientos21 = new Relationships();
        relTiposAlmacenamientos21.setFrom(fromTiposAlmacenamientos21);
        relTiposAlmacenamientos21.setCardinalities(TiposAlmacenamientos21);
        relTiposAlmacenamientos21.setTo(toTiposAlmacenamientos21);
        relTiposAlmacenamientos21.setOptionality(true);
        em.persist(relTiposAlmacenamientos21);
        em.flush();

//  ---------------------- TiposArchivos 1..* EntradasArchivos -------------------------

        Entities fromTiposArchivos22 = new Entities();
        Cardinalities TiposArchivos22 = new Cardinalities();
        Entities   toTiposArchivos22 = new Entities();
        fromTiposArchivos22 = findEntities("TiposArchivos");
        TiposArchivos22 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toTiposArchivos22 = findEntities("EntradasArchivos");
        Relationships relTiposArchivos22 = new Relationships();
        relTiposArchivos22.setFrom(fromTiposArchivos22);
        relTiposArchivos22.setCardinalities(TiposArchivos22);
        relTiposArchivos22.setTo(toTiposArchivos22);
        relTiposArchivos22.setOptionality(true);
        em.persist(relTiposArchivos22);
        em.flush();

//  ---------------------- Ubicaciones 1..* Almacenamientos -------------------------

        Entities fromUbicaciones23 = new Entities();
        Cardinalities Ubicaciones23 = new Cardinalities();
        Entities   toUbicaciones23 = new Entities();
        fromUbicaciones23 = findEntities("Ubicaciones");
        Ubicaciones23 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toUbicaciones23 = findEntities("Almacenamientos");
        Relationships relUbicaciones23 = new Relationships();
        relUbicaciones23.setFrom(fromUbicaciones23);
        relUbicaciones23.setCardinalities(Ubicaciones23);
        relUbicaciones23.setTo(toUbicaciones23);
        relUbicaciones23.setOptionality(true);
        em.persist(relUbicaciones23);
        em.flush();

//  ---------------------- TiposUbicaciones 1..* Ubicaciones -------------------------

        Entities fromTiposUbicaciones24 = new Entities();
        Cardinalities TiposUbicaciones24 = new Cardinalities();
        Entities   toTiposUbicaciones24 = new Entities();
        fromTiposUbicaciones24 = findEntities("TiposUbicaciones");
        TiposUbicaciones24 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toTiposUbicaciones24 = findEntities("Ubicaciones");
        Relationships relTiposUbicaciones24 = new Relationships();
        relTiposUbicaciones24.setFrom(fromTiposUbicaciones24);
        relTiposUbicaciones24.setCardinalities(TiposUbicaciones24);
        relTiposUbicaciones24.setTo(toTiposUbicaciones24);
        relTiposUbicaciones24.setOptionality(true);
        em.persist(relTiposUbicaciones24);
        em.flush();

//  ---------------------- AnosDepuraciones 1..* EntradasArchivos -------------------------

        Entities fromAnosDepuraciones25 = new Entities();
        Cardinalities AnosDepuraciones25 = new Cardinalities();
        Entities   toAnosDepuraciones25 = new Entities();
        fromAnosDepuraciones25 = findEntities("AnosDepuraciones");
        AnosDepuraciones25 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toAnosDepuraciones25 = findEntities("EntradasArchivos");
        Relationships relAnosDepuraciones25 = new Relationships();
        relAnosDepuraciones25.setFrom(fromAnosDepuraciones25);
        relAnosDepuraciones25.setCardinalities(AnosDepuraciones25);
        relAnosDepuraciones25.setTo(toAnosDepuraciones25);
        relAnosDepuraciones25.setOptionality(true);
        em.persist(relAnosDepuraciones25);
        em.flush();

    } // Relations()
} // DomainModelsSetup

