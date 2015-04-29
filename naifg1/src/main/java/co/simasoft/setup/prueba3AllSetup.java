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
@Named("prueba3AllSetup")
public class prueba3AllSetup {

    private static final String QUERYA = "SELECT c FROM TypesAttributes c WHERE c.name LIKE :custName";
    private static final String QUERYB = "SELECT c FROM Entities c WHERE c.name LIKE :custName";
    private static final String QUERYC = "SELECT c FROM Cardinalities c WHERE c.name LIKE :custName";

    @PersistenceContext(unitName = "DomainModelsPU-JTA")
    private EntityManager em;

    private static final Logger log = Logger.getLogger(prueba3AllSetup.class.getName());

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
        groupId0.setGroupId("co.simasoft.models.naif.prueba3");
        groupId0.setDomainModels(domainModels);
        em.persist(groupId0);
        em.flush();

        Instituciones(groupId0);
        TiposRegistros(groupId0);
        Medios(groupId0);
        Dependencias(groupId0);
        Indexaciones(groupId0);
        Responsables(groupId0);
        TiposAccesos(groupId0);
        TrdAreas(groupId0);
        DisposicionFinal(groupId0);
        Estados(groupId0);
        TiposFormatos(groupId0);
        TrdArchivos(groupId0);
        Formatos(groupId0);
        Lmrs(groupId0);
        Procesos(groupId0);
        TiposProcesos(groupId0);
        Lmds(groupId0);
        TiposDocumentos(groupId0);
        EstadosDocumentos(groupId0);
        Almacenamientos(groupId0);
        OtrosArchivos(groupId0);
        ArchivosInactivos(groupId0);
        EntradasArchivos(groupId0);
        TiposArchivos(groupId0);
        TiposAlmacenamientos(groupId0);
        Ubicaciones(groupId0);
        TiposUbicaciones(groupId0);
        AnosDepuraciones(groupId0);

        Relations();

    } // data()

    public void Instituciones(GroupIds groupIds) {

        Entities instituciones = new Entities();
        instituciones.setName("Instituciones");
        instituciones.setGroupIds(groupIds);
        em.persist(instituciones);
        em.flush();

//      ---------------------- Attributes:Instituciones -------------------------

    } // Instituciones()

    public void TiposRegistros(GroupIds groupIds) {

        Entities tiposRegistros = new Entities();
        tiposRegistros.setName("TiposRegistros");
        tiposRegistros.setGroupIds(groupIds);
        em.persist(tiposRegistros);
        em.flush();

//      ---------------------- Attributes:TiposRegistros -------------------------

    } // TiposRegistros()

    public void Medios(GroupIds groupIds) {

        Entities medios = new Entities();
        medios.setName("Medios");
        medios.setGroupIds(groupIds);
        em.persist(medios);
        em.flush();

//      ---------------------- Attributes:Medios -------------------------

    } // Medios()

    public void Dependencias(GroupIds groupIds) {

        Entities dependencias = new Entities();
        dependencias.setName("Dependencias");
        dependencias.setGroupIds(groupIds);
        em.persist(dependencias);
        em.flush();

//      ---------------------- Attributes:Dependencias -------------------------

    } // Dependencias()

    public void Indexaciones(GroupIds groupIds) {

        Entities indexaciones = new Entities();
        indexaciones.setName("Indexaciones");
        indexaciones.setGroupIds(groupIds);
        em.persist(indexaciones);
        em.flush();

//      ---------------------- Attributes:Indexaciones -------------------------

    } // Indexaciones()

    public void Responsables(GroupIds groupIds) {

        Entities responsables = new Entities();
        responsables.setName("Responsables");
        responsables.setGroupIds(groupIds);
        em.persist(responsables);
        em.flush();

//      ---------------------- Attributes:Responsables -------------------------

    } // Responsables()

    public void TiposAccesos(GroupIds groupIds) {

        Entities tiposAccesos = new Entities();
        tiposAccesos.setName("TiposAccesos");
        tiposAccesos.setGroupIds(groupIds);
        em.persist(tiposAccesos);
        em.flush();

//      ---------------------- Attributes:TiposAccesos -------------------------

    } // TiposAccesos()

    public void TrdAreas(GroupIds groupIds) {

        Entities trdAreas = new Entities();
        trdAreas.setName("TrdAreas");
        trdAreas.setGroupIds(groupIds);
        em.persist(trdAreas);
        em.flush();

//      ---------------------- Attributes:TrdAreas -------------------------

    } // TrdAreas()

    public void DisposicionFinal(GroupIds groupIds) {

        Entities disposicionFinal = new Entities();
        disposicionFinal.setName("DisposicionFinal");
        disposicionFinal.setGroupIds(groupIds);
        em.persist(disposicionFinal);
        em.flush();

//      ---------------------- Attributes:DisposicionFinal -------------------------

    } // DisposicionFinal()

    public void Estados(GroupIds groupIds) {

        Entities estados = new Entities();
        estados.setName("Estados");
        estados.setGroupIds(groupIds);
        em.persist(estados);
        em.flush();

//      ---------------------- Attributes:Estados -------------------------

    } // Estados()

    public void TiposFormatos(GroupIds groupIds) {

        Entities tiposFormatos = new Entities();
        tiposFormatos.setName("TiposFormatos");
        tiposFormatos.setGroupIds(groupIds);
        em.persist(tiposFormatos);
        em.flush();

//      ---------------------- Attributes:TiposFormatos -------------------------

    } // TiposFormatos()

    public void TrdArchivos(GroupIds groupIds) {

        Entities trdArchivos = new Entities();
        trdArchivos.setName("TrdArchivos");
        trdArchivos.setGroupIds(groupIds);
        em.persist(trdArchivos);
        em.flush();

//      ---------------------- Attributes:TrdArchivos -------------------------

    } // TrdArchivos()

    public void Formatos(GroupIds groupIds) {

        Entities formatos = new Entities();
        formatos.setName("Formatos");
        formatos.setGroupIds(groupIds);
        em.persist(formatos);
        em.flush();

//      ---------------------- Attributes:Formatos -------------------------

    } // Formatos()

    public void Lmrs(GroupIds groupIds) {

        Entities lmrs = new Entities();
        lmrs.setName("Lmrs");
        lmrs.setGroupIds(groupIds);
        em.persist(lmrs);
        em.flush();

//      ---------------------- Attributes:Lmrs -------------------------

    } // Lmrs()

    public void Procesos(GroupIds groupIds) {

        Entities procesos = new Entities();
        procesos.setName("Procesos");
        procesos.setGroupIds(groupIds);
        em.persist(procesos);
        em.flush();

//      ---------------------- Attributes:Procesos -------------------------

    } // Procesos()

    public void TiposProcesos(GroupIds groupIds) {

        Entities tiposProcesos = new Entities();
        tiposProcesos.setName("TiposProcesos");
        tiposProcesos.setGroupIds(groupIds);
        em.persist(tiposProcesos);
        em.flush();

//      ---------------------- Attributes:TiposProcesos -------------------------

    } // TiposProcesos()

    public void Lmds(GroupIds groupIds) {

        Entities lmds = new Entities();
        lmds.setName("Lmds");
        lmds.setGroupIds(groupIds);
        em.persist(lmds);
        em.flush();

//      ---------------------- Attributes:Lmds -------------------------

    } // Lmds()

    public void TiposDocumentos(GroupIds groupIds) {

        Entities tiposDocumentos = new Entities();
        tiposDocumentos.setName("TiposDocumentos");
        tiposDocumentos.setGroupIds(groupIds);
        em.persist(tiposDocumentos);
        em.flush();

//      ---------------------- Attributes:TiposDocumentos -------------------------

    } // TiposDocumentos()

    public void EstadosDocumentos(GroupIds groupIds) {

        Entities estadosDocumentos = new Entities();
        estadosDocumentos.setName("EstadosDocumentos");
        estadosDocumentos.setGroupIds(groupIds);
        em.persist(estadosDocumentos);
        em.flush();

//      ---------------------- Attributes:EstadosDocumentos -------------------------

    } // EstadosDocumentos()

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

//  ---------------------- Relationships -------------------------

    public void Relations() {

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

        Entities fromTiposRegistros1 = new Entities();
        Cardinalities TiposRegistros1 = new Cardinalities();
        Entities   toTiposRegistros1 = new Entities();
        fromTiposRegistros1 = findEntities("TiposRegistros");
        TiposRegistros1 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toTiposRegistros1 = findEntities("Lmrs");
        Relationships relTiposRegistros1 = new Relationships();
        relTiposRegistros1.setFrom(fromTiposRegistros1);
        relTiposRegistros1.setCardinalities(TiposRegistros1);
        relTiposRegistros1.setTo(toTiposRegistros1);
        relTiposRegistros1.setOptionality(true);
        em.persist(relTiposRegistros1);
        em.flush();

//  ---------------------- Medios 1..* Lmrs -------------------------

        Entities fromMedios2 = new Entities();
        Cardinalities Medios2 = new Cardinalities();
        Entities   toMedios2 = new Entities();
        fromMedios2 = findEntities("Medios");
        Medios2 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toMedios2 = findEntities("Lmrs");
        Relationships relMedios2 = new Relationships();
        relMedios2.setFrom(fromMedios2);
        relMedios2.setCardinalities(Medios2);
        relMedios2.setTo(toMedios2);
        relMedios2.setOptionality(true);
        em.persist(relMedios2);
        em.flush();

//  ---------------------- Dependencias 1..* Formatos -------------------------

        Entities fromDependencias3 = new Entities();
        Cardinalities Dependencias3 = new Cardinalities();
        Entities   toDependencias3 = new Entities();
        fromDependencias3 = findEntities("Dependencias");
        Dependencias3 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toDependencias3 = findEntities("Formatos");
        Relationships relDependencias3 = new Relationships();
        relDependencias3.setFrom(fromDependencias3);
        relDependencias3.setCardinalities(Dependencias3);
        relDependencias3.setTo(toDependencias3);
        relDependencias3.setOptionality(true);
        em.persist(relDependencias3);
        em.flush();

//  ---------------------- Indexaciones 1..* Formatos -------------------------

        Entities fromIndexaciones4 = new Entities();
        Cardinalities Indexaciones4 = new Cardinalities();
        Entities   toIndexaciones4 = new Entities();
        fromIndexaciones4 = findEntities("Indexaciones");
        Indexaciones4 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toIndexaciones4 = findEntities("Formatos");
        Relationships relIndexaciones4 = new Relationships();
        relIndexaciones4.setFrom(fromIndexaciones4);
        relIndexaciones4.setCardinalities(Indexaciones4);
        relIndexaciones4.setTo(toIndexaciones4);
        relIndexaciones4.setOptionality(true);
        em.persist(relIndexaciones4);
        em.flush();

//  ---------------------- Responsables 1..* Formatos -------------------------

        Entities fromResponsables5 = new Entities();
        Cardinalities Responsables5 = new Cardinalities();
        Entities   toResponsables5 = new Entities();
        fromResponsables5 = findEntities("Responsables");
        Responsables5 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toResponsables5 = findEntities("Formatos");
        Relationships relResponsables5 = new Relationships();
        relResponsables5.setFrom(fromResponsables5);
        relResponsables5.setCardinalities(Responsables5);
        relResponsables5.setTo(toResponsables5);
        relResponsables5.setOptionality(true);
        em.persist(relResponsables5);
        em.flush();

//  ---------------------- TiposAccesos 1..* Formatos -------------------------

        Entities fromTiposAccesos6 = new Entities();
        Cardinalities TiposAccesos6 = new Cardinalities();
        Entities   toTiposAccesos6 = new Entities();
        fromTiposAccesos6 = findEntities("TiposAccesos");
        TiposAccesos6 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toTiposAccesos6 = findEntities("Formatos");
        Relationships relTiposAccesos6 = new Relationships();
        relTiposAccesos6.setFrom(fromTiposAccesos6);
        relTiposAccesos6.setCardinalities(TiposAccesos6);
        relTiposAccesos6.setTo(toTiposAccesos6);
        relTiposAccesos6.setOptionality(true);
        em.persist(relTiposAccesos6);
        em.flush();

//  ---------------------- TrdAreas 1..* Lmrs -------------------------

        Entities fromTrdAreas7 = new Entities();
        Cardinalities TrdAreas7 = new Cardinalities();
        Entities   toTrdAreas7 = new Entities();
        fromTrdAreas7 = findEntities("TrdAreas");
        TrdAreas7 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toTrdAreas7 = findEntities("Lmrs");
        Relationships relTrdAreas7 = new Relationships();
        relTrdAreas7.setFrom(fromTrdAreas7);
        relTrdAreas7.setCardinalities(TrdAreas7);
        relTrdAreas7.setTo(toTrdAreas7);
        relTrdAreas7.setOptionality(true);
        em.persist(relTrdAreas7);
        em.flush();

//  ---------------------- DisposicionFinal 1..* Formatos -------------------------

        Entities fromDisposicionFinal8 = new Entities();
        Cardinalities DisposicionFinal8 = new Cardinalities();
        Entities   toDisposicionFinal8 = new Entities();
        fromDisposicionFinal8 = findEntities("DisposicionFinal");
        DisposicionFinal8 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toDisposicionFinal8 = findEntities("Formatos");
        Relationships relDisposicionFinal8 = new Relationships();
        relDisposicionFinal8.setFrom(fromDisposicionFinal8);
        relDisposicionFinal8.setCardinalities(DisposicionFinal8);
        relDisposicionFinal8.setTo(toDisposicionFinal8);
        relDisposicionFinal8.setOptionality(true);
        em.persist(relDisposicionFinal8);
        em.flush();

//  ---------------------- Estados 1..* Formatos -------------------------

        Entities fromEstados9 = new Entities();
        Cardinalities Estados9 = new Cardinalities();
        Entities   toEstados9 = new Entities();
        fromEstados9 = findEntities("Estados");
        Estados9 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toEstados9 = findEntities("Formatos");
        Relationships relEstados9 = new Relationships();
        relEstados9.setFrom(fromEstados9);
        relEstados9.setCardinalities(Estados9);
        relEstados9.setTo(toEstados9);
        relEstados9.setOptionality(true);
        em.persist(relEstados9);
        em.flush();

//  ---------------------- TiposFormatos 1..* Formatos -------------------------

        Entities fromTiposFormatos10 = new Entities();
        Cardinalities TiposFormatos10 = new Cardinalities();
        Entities   toTiposFormatos10 = new Entities();
        fromTiposFormatos10 = findEntities("TiposFormatos");
        TiposFormatos10 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toTiposFormatos10 = findEntities("Formatos");
        Relationships relTiposFormatos10 = new Relationships();
        relTiposFormatos10.setFrom(fromTiposFormatos10);
        relTiposFormatos10.setCardinalities(TiposFormatos10);
        relTiposFormatos10.setTo(toTiposFormatos10);
        relTiposFormatos10.setOptionality(true);
        em.persist(relTiposFormatos10);
        em.flush();

//  ---------------------- TrdArchivos 1..* Lmrs -------------------------

        Entities fromTrdArchivos11 = new Entities();
        Cardinalities TrdArchivos11 = new Cardinalities();
        Entities   toTrdArchivos11 = new Entities();
        fromTrdArchivos11 = findEntities("TrdArchivos");
        TrdArchivos11 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toTrdArchivos11 = findEntities("Lmrs");
        Relationships relTrdArchivos11 = new Relationships();
        relTrdArchivos11.setFrom(fromTrdArchivos11);
        relTrdArchivos11.setCardinalities(TrdArchivos11);
        relTrdArchivos11.setTo(toTrdArchivos11);
        relTrdArchivos11.setOptionality(true);
        em.persist(relTrdArchivos11);
        em.flush();

//  ---------------------- Formatos 1..* Lmrs -------------------------

        Entities fromFormatos12 = new Entities();
        Cardinalities Formatos12 = new Cardinalities();
        Entities   toFormatos12 = new Entities();
        fromFormatos12 = findEntities("Formatos");
        Formatos12 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toFormatos12 = findEntities("Lmrs");
        Relationships relFormatos12 = new Relationships();
        relFormatos12.setFrom(fromFormatos12);
        relFormatos12.setCardinalities(Formatos12);
        relFormatos12.setTo(toFormatos12);
        relFormatos12.setOptionality(true);
        em.persist(relFormatos12);
        em.flush();

//  ---------------------- Lmrs 1..* EntradasArchivos -------------------------

        Entities fromLmrs13 = new Entities();
        Cardinalities Lmrs13 = new Cardinalities();
        Entities   toLmrs13 = new Entities();
        fromLmrs13 = findEntities("Lmrs");
        Lmrs13 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toLmrs13 = findEntities("EntradasArchivos");
        Relationships relLmrs13 = new Relationships();
        relLmrs13.setFrom(fromLmrs13);
        relLmrs13.setCardinalities(Lmrs13);
        relLmrs13.setTo(toLmrs13);
        relLmrs13.setOptionality(true);
        em.persist(relLmrs13);
        em.flush();

//  ---------------------- Procesos 1..* Formatos -------------------------

        Entities fromProcesos14 = new Entities();
        Cardinalities Procesos14 = new Cardinalities();
        Entities   toProcesos14 = new Entities();
        fromProcesos14 = findEntities("Procesos");
        Procesos14 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toProcesos14 = findEntities("Formatos");
        Relationships relProcesos14 = new Relationships();
        relProcesos14.setFrom(fromProcesos14);
        relProcesos14.setCardinalities(Procesos14);
        relProcesos14.setTo(toProcesos14);
        relProcesos14.setOptionality(true);
        em.persist(relProcesos14);
        em.flush();

//  ---------------------- Procesos 1..* Lmds -------------------------

        Entities fromProcesos15 = new Entities();
        Cardinalities Procesos15 = new Cardinalities();
        Entities   toProcesos15 = new Entities();
        fromProcesos15 = findEntities("Procesos");
        Procesos15 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toProcesos15 = findEntities("Lmds");
        Relationships relProcesos15 = new Relationships();
        relProcesos15.setFrom(fromProcesos15);
        relProcesos15.setCardinalities(Procesos15);
        relProcesos15.setTo(toProcesos15);
        relProcesos15.setOptionality(true);
        em.persist(relProcesos15);
        em.flush();

//  ---------------------- TiposProcesos 1..* Procesos -------------------------

        Entities fromTiposProcesos16 = new Entities();
        Cardinalities TiposProcesos16 = new Cardinalities();
        Entities   toTiposProcesos16 = new Entities();
        fromTiposProcesos16 = findEntities("TiposProcesos");
        TiposProcesos16 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toTiposProcesos16 = findEntities("Procesos");
        Relationships relTiposProcesos16 = new Relationships();
        relTiposProcesos16.setFrom(fromTiposProcesos16);
        relTiposProcesos16.setCardinalities(TiposProcesos16);
        relTiposProcesos16.setTo(toTiposProcesos16);
        relTiposProcesos16.setOptionality(true);
        em.persist(relTiposProcesos16);
        em.flush();

//  ---------------------- TiposDocumentos 1..* Lmds -------------------------

        Entities fromTiposDocumentos17 = new Entities();
        Cardinalities TiposDocumentos17 = new Cardinalities();
        Entities   toTiposDocumentos17 = new Entities();
        fromTiposDocumentos17 = findEntities("TiposDocumentos");
        TiposDocumentos17 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toTiposDocumentos17 = findEntities("Lmds");
        Relationships relTiposDocumentos17 = new Relationships();
        relTiposDocumentos17.setFrom(fromTiposDocumentos17);
        relTiposDocumentos17.setCardinalities(TiposDocumentos17);
        relTiposDocumentos17.setTo(toTiposDocumentos17);
        relTiposDocumentos17.setOptionality(true);
        em.persist(relTiposDocumentos17);
        em.flush();

//  ---------------------- EstadosDocumentos 1..* Lmds -------------------------

        Entities fromEstadosDocumentos18 = new Entities();
        Cardinalities EstadosDocumentos18 = new Cardinalities();
        Entities   toEstadosDocumentos18 = new Entities();
        fromEstadosDocumentos18 = findEntities("EstadosDocumentos");
        EstadosDocumentos18 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toEstadosDocumentos18 = findEntities("Lmds");
        Relationships relEstadosDocumentos18 = new Relationships();
        relEstadosDocumentos18.setFrom(fromEstadosDocumentos18);
        relEstadosDocumentos18.setCardinalities(EstadosDocumentos18);
        relEstadosDocumentos18.setTo(toEstadosDocumentos18);
        relEstadosDocumentos18.setOptionality(true);
        em.persist(relEstadosDocumentos18);
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

//  ---------------------- EntradasArchivos 1..* ArchivosInactivos -------------------------

        Entities fromEntradasArchivos21 = new Entities();
        Cardinalities EntradasArchivos21 = new Cardinalities();
        Entities   toEntradasArchivos21 = new Entities();
        fromEntradasArchivos21 = findEntities("EntradasArchivos");
        EntradasArchivos21 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toEntradasArchivos21 = findEntities("ArchivosInactivos");
        Relationships relEntradasArchivos21 = new Relationships();
        relEntradasArchivos21.setFrom(fromEntradasArchivos21);
        relEntradasArchivos21.setCardinalities(EntradasArchivos21);
        relEntradasArchivos21.setTo(toEntradasArchivos21);
        relEntradasArchivos21.setOptionality(true);
        em.persist(relEntradasArchivos21);
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

//  ---------------------- TiposAlmacenamientos 1..* Almacenamientos -------------------------

        Entities fromTiposAlmacenamientos23 = new Entities();
        Cardinalities TiposAlmacenamientos23 = new Cardinalities();
        Entities   toTiposAlmacenamientos23 = new Entities();
        fromTiposAlmacenamientos23 = findEntities("TiposAlmacenamientos");
        TiposAlmacenamientos23 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toTiposAlmacenamientos23 = findEntities("Almacenamientos");
        Relationships relTiposAlmacenamientos23 = new Relationships();
        relTiposAlmacenamientos23.setFrom(fromTiposAlmacenamientos23);
        relTiposAlmacenamientos23.setCardinalities(TiposAlmacenamientos23);
        relTiposAlmacenamientos23.setTo(toTiposAlmacenamientos23);
        relTiposAlmacenamientos23.setOptionality(true);
        em.persist(relTiposAlmacenamientos23);
        em.flush();

//  ---------------------- Ubicaciones 1..* Almacenamientos -------------------------

        Entities fromUbicaciones24 = new Entities();
        Cardinalities Ubicaciones24 = new Cardinalities();
        Entities   toUbicaciones24 = new Entities();
        fromUbicaciones24 = findEntities("Ubicaciones");
        Ubicaciones24 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toUbicaciones24 = findEntities("Almacenamientos");
        Relationships relUbicaciones24 = new Relationships();
        relUbicaciones24.setFrom(fromUbicaciones24);
        relUbicaciones24.setCardinalities(Ubicaciones24);
        relUbicaciones24.setTo(toUbicaciones24);
        relUbicaciones24.setOptionality(true);
        em.persist(relUbicaciones24);
        em.flush();

//  ---------------------- TiposUbicaciones 1..* Ubicaciones -------------------------

        Entities fromTiposUbicaciones25 = new Entities();
        Cardinalities TiposUbicaciones25 = new Cardinalities();
        Entities   toTiposUbicaciones25 = new Entities();
        fromTiposUbicaciones25 = findEntities("TiposUbicaciones");
        TiposUbicaciones25 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toTiposUbicaciones25 = findEntities("Ubicaciones");
        Relationships relTiposUbicaciones25 = new Relationships();
        relTiposUbicaciones25.setFrom(fromTiposUbicaciones25);
        relTiposUbicaciones25.setCardinalities(TiposUbicaciones25);
        relTiposUbicaciones25.setTo(toTiposUbicaciones25);
        relTiposUbicaciones25.setOptionality(true);
        em.persist(relTiposUbicaciones25);
        em.flush();

//  ---------------------- AnosDepuraciones 1..* EntradasArchivos -------------------------

        Entities fromAnosDepuraciones26 = new Entities();
        Cardinalities AnosDepuraciones26 = new Cardinalities();
        Entities   toAnosDepuraciones26 = new Entities();
        fromAnosDepuraciones26 = findEntities("AnosDepuraciones");
        AnosDepuraciones26 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toAnosDepuraciones26 = findEntities("EntradasArchivos");
        Relationships relAnosDepuraciones26 = new Relationships();
        relAnosDepuraciones26.setFrom(fromAnosDepuraciones26);
        relAnosDepuraciones26.setCardinalities(AnosDepuraciones26);
        relAnosDepuraciones26.setTo(toAnosDepuraciones26);
        relAnosDepuraciones26.setOptionality(true);
        em.persist(relAnosDepuraciones26);
        em.flush();

    } // Relations()
} // DomainModelsSetup

