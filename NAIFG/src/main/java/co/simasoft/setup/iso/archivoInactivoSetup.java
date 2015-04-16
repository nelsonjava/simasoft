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
@Named("archivoInactivoSetup")
public class archivoInactivoSetup {

    private static final String QUERYA = "SELECT c FROM TypesAttributes c WHERE c.name LIKE :custName";
    private static final String QUERYB = "SELECT c FROM Entities c WHERE c.name LIKE :custName";
    private static final String QUERYC = "SELECT c FROM Cardinalities c WHERE c.name LIKE :custName";

    @PersistenceContext(unitName = "DomainModelsPU-JTA")
    private EntityManager em;

    private static final Logger log = Logger.getLogger(archivoInactivoSetup.class.getName());

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
        domainModels.setName("archivoInactivo");
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

        Entities fromAlmacenamientos0 = new Entities();
        Cardinalities Almacenamientos0 = new Cardinalities();
        Entities   toAlmacenamientos0 = new Entities();
        fromAlmacenamientos0 = findEntities("Almacenamientos");
        Almacenamientos0 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toAlmacenamientos0 = findEntities("ArchivosInactivos");
        Relationships relAlmacenamientos0 = new Relationships();
        relAlmacenamientos0.setFrom(fromAlmacenamientos0);
        relAlmacenamientos0.setCardinalities(Almacenamientos0);
        relAlmacenamientos0.setTo(toAlmacenamientos0);
        relAlmacenamientos0.setOptionality(true);
        em.persist(relAlmacenamientos0);
        em.flush();

//  ---------------------- Almacenamientos 1..* OtrosArchivos -------------------------

        Entities fromAlmacenamientos1 = new Entities();
        Cardinalities Almacenamientos1 = new Cardinalities();
        Entities   toAlmacenamientos1 = new Entities();
        fromAlmacenamientos1 = findEntities("Almacenamientos");
        Almacenamientos1 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toAlmacenamientos1 = findEntities("OtrosArchivos");
        Relationships relAlmacenamientos1 = new Relationships();
        relAlmacenamientos1.setFrom(fromAlmacenamientos1);
        relAlmacenamientos1.setCardinalities(Almacenamientos1);
        relAlmacenamientos1.setTo(toAlmacenamientos1);
        relAlmacenamientos1.setOptionality(true);
        em.persist(relAlmacenamientos1);
        em.flush();

//  ---------------------- TiposAlmacenamientos 1..* Almacenamientos -------------------------

        Entities fromTiposAlmacenamientos0 = new Entities();
        Cardinalities TiposAlmacenamientos0 = new Cardinalities();
        Entities   toTiposAlmacenamientos0 = new Entities();
        fromTiposAlmacenamientos0 = findEntities("TiposAlmacenamientos");
        TiposAlmacenamientos0 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toTiposAlmacenamientos0 = findEntities("Almacenamientos");
        Relationships relTiposAlmacenamientos0 = new Relationships();
        relTiposAlmacenamientos0.setFrom(fromTiposAlmacenamientos0);
        relTiposAlmacenamientos0.setCardinalities(TiposAlmacenamientos0);
        relTiposAlmacenamientos0.setTo(toTiposAlmacenamientos0);
        relTiposAlmacenamientos0.setOptionality(true);
        em.persist(relTiposAlmacenamientos0);
        em.flush();

//  ---------------------- TiposArchivos 1..* EntradasArchivos -------------------------

        Entities fromTiposArchivos0 = new Entities();
        Cardinalities TiposArchivos0 = new Cardinalities();
        Entities   toTiposArchivos0 = new Entities();
        fromTiposArchivos0 = findEntities("TiposArchivos");
        TiposArchivos0 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toTiposArchivos0 = findEntities("EntradasArchivos");
        Relationships relTiposArchivos0 = new Relationships();
        relTiposArchivos0.setFrom(fromTiposArchivos0);
        relTiposArchivos0.setCardinalities(TiposArchivos0);
        relTiposArchivos0.setTo(toTiposArchivos0);
        relTiposArchivos0.setOptionality(true);
        em.persist(relTiposArchivos0);
        em.flush();

//  ---------------------- Ubicaciones 1..* Almacenamientos -------------------------

        Entities fromUbicaciones1 = new Entities();
        Cardinalities Ubicaciones1 = new Cardinalities();
        Entities   toUbicaciones1 = new Entities();
        fromUbicaciones1 = findEntities("Ubicaciones");
        Ubicaciones1 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toUbicaciones1 = findEntities("Almacenamientos");
        Relationships relUbicaciones1 = new Relationships();
        relUbicaciones1.setFrom(fromUbicaciones1);
        relUbicaciones1.setCardinalities(Ubicaciones1);
        relUbicaciones1.setTo(toUbicaciones1);
        relUbicaciones1.setOptionality(true);
        em.persist(relUbicaciones1);
        em.flush();

//  ---------------------- TiposUbicaciones 1..* Ubicaciones -------------------------

        Entities fromTiposUbicaciones0 = new Entities();
        Cardinalities TiposUbicaciones0 = new Cardinalities();
        Entities   toTiposUbicaciones0 = new Entities();
        fromTiposUbicaciones0 = findEntities("TiposUbicaciones");
        TiposUbicaciones0 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toTiposUbicaciones0 = findEntities("Ubicaciones");
        Relationships relTiposUbicaciones0 = new Relationships();
        relTiposUbicaciones0.setFrom(fromTiposUbicaciones0);
        relTiposUbicaciones0.setCardinalities(TiposUbicaciones0);
        relTiposUbicaciones0.setTo(toTiposUbicaciones0);
        relTiposUbicaciones0.setOptionality(true);
        em.persist(relTiposUbicaciones0);
        em.flush();

//  ---------------------- AnosDepuraciones 1..* EntradasArchivos -------------------------

        Entities fromAnosDepuraciones0 = new Entities();
        Cardinalities AnosDepuraciones0 = new Cardinalities();
        Entities   toAnosDepuraciones0 = new Entities();
        fromAnosDepuraciones0 = findEntities("AnosDepuraciones");
        AnosDepuraciones0 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toAnosDepuraciones0 = findEntities("EntradasArchivos");
        Relationships relAnosDepuraciones0 = new Relationships();
        relAnosDepuraciones0.setFrom(fromAnosDepuraciones0);
        relAnosDepuraciones0.setCardinalities(AnosDepuraciones0);
        relAnosDepuraciones0.setTo(toAnosDepuraciones0);
        relAnosDepuraciones0.setOptionality(true);
        em.persist(relAnosDepuraciones0);
        em.flush();
        
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

