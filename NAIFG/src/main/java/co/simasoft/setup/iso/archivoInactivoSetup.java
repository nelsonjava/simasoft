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
        Lmrs(domainModels);
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

//  ---------------------- Relationships -------------------------

    public void Relations() {

//  ---------------------- EntradasArchivos 1..* ArchivosInactivos -------------------------

        Entities fromEntradasArchivos1 = new Entities();
        Cardinalities EntradasArchivos1 = new Cardinalities();
        Entities   toEntradasArchivos1 = new Entities();
        fromEntradasArchivos1 = findEntities("EntradasArchivos");
        EntradasArchivos1 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toEntradasArchivos1 = findEntities("ArchivosInactivos");
        Relationships relEntradasArchivos1 = new Relationships();
        relEntradasArchivos1.setFrom(fromEntradasArchivos1);
        relEntradasArchivos1.setCardinalities(EntradasArchivos1);
        relEntradasArchivos1.setTo(toEntradasArchivos1);
        relEntradasArchivos1.setOptionality(true);
        em.persist(relEntradasArchivos1);
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

//  ---------------------- Lmrs 1..* EntradasArchivos -------------------------

        Entities fromLmrs0 = new Entities();
        Cardinalities Lmrs0 = new Cardinalities();
        Entities   toLmrs0 = new Entities();
        fromLmrs0 = findEntities("Lmrs");
        Lmrs0 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toLmrs0 = findEntities("EntradasArchivos");
        Relationships relLmrs0 = new Relationships();
        relLmrs0.setFrom(fromLmrs0);
        relLmrs0.setCardinalities(Lmrs0);
        relLmrs0.setTo(toLmrs0);
        relLmrs0.setOptionality(true);
        em.persist(relLmrs0);
        em.flush();

    } // Relations()
} // DomainModelsSetup

