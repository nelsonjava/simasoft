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
@Named("RelacionesEjbSetup")
public class RelacionesEjbSetup {

    private static final String QUERYA = "SELECT c FROM TypesAttributes c WHERE c.name LIKE :custName";
    private static final String QUERYB = "SELECT c FROM Entities c WHERE c.name LIKE :custName";
    private static final String QUERYC = "SELECT c FROM Cardinalities c WHERE c.name LIKE :custName";

    @PersistenceContext(unitName = "DomainModelsPU-JTA")
    private EntityManager em;

    private static final Logger log = Logger.getLogger(RelacionesEjbSetup.class.getName());

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

        GroupIds groupIds = new GroupIds();
        groupIds.setGroupId(Utils.nameRandom());
        groupIds.setDomainModels(domainModels);
        em.persist(groupIds);
        em.flush();

        Personas(groupIds);
        Direcciones(groupIds);
        Cedulas(groupIds);
        Pasajes(groupIds);
        Rutas(groupIds);
        Buses(groupIds);
        PuestosBuses(groupIds);
        Relations();

    } // data()

    public void Personas(GroupIds groupIds) {

        Entities personas = new Entities();
        personas.setName("Personas");
        personas.setGroupIds(groupIds);
        em.persist(personas);
        em.flush();

//      ---------------------- Attributes:Personas -------------------------

        TypesAttributes typesprimerNombre = new TypesAttributes();
        typesprimerNombre = findTypesAttributes("String");

        Attributes primerNombre = new Attributes();
        primerNombre.setName("primerNombre");
        primerNombre.setType("String");
        primerNombre.setTypesAttributes(typesprimerNombre);
        primerNombre.setEntities(personas);
        em.persist(primerNombre);
        em.flush();

        TypesAttributes typessegundoNombre = new TypesAttributes();
        typessegundoNombre = findTypesAttributes("String");

        Attributes segundoNombre = new Attributes();
        segundoNombre.setName("segundoNombre");
        segundoNombre.setType("String");
        segundoNombre.setTypesAttributes(typessegundoNombre);
        segundoNombre.setEntities(personas);
        em.persist(segundoNombre);
        em.flush();

        TypesAttributes typesprimerApellido = new TypesAttributes();
        typesprimerApellido = findTypesAttributes("String");

        Attributes primerApellido = new Attributes();
        primerApellido.setName("primerApellido");
        primerApellido.setType("String");
        primerApellido.setTypesAttributes(typesprimerApellido);
        primerApellido.setEntities(personas);
        em.persist(primerApellido);
        em.flush();

        TypesAttributes typessegundoApellido = new TypesAttributes();
        typessegundoApellido = findTypesAttributes("String");

        Attributes segundoApellido = new Attributes();
        segundoApellido.setName("segundoApellido");
        segundoApellido.setType("String");
        segundoApellido.setTypesAttributes(typessegundoApellido);
        segundoApellido.setEntities(personas);
        em.persist(segundoApellido);
        em.flush();

        TypesAttributes typestelefono = new TypesAttributes();
        typestelefono = findTypesAttributes("String");

        Attributes telefono = new Attributes();
        telefono.setName("telefono");
        telefono.setType("String");
        telefono.setTypesAttributes(typestelefono);
        telefono.setEntities(personas);
        em.persist(telefono);
        em.flush();

        TypesAttributes typesemail = new TypesAttributes();
        typesemail = findTypesAttributes("String");

        Attributes email = new Attributes();
        email.setName("email");
        email.setType("String");
        email.setTypesAttributes(typesemail);
        email.setEntities(personas);
        em.persist(email);
        em.flush();

        TypesAttributes typesfoto = new TypesAttributes();
        typesfoto = findTypesAttributes("byte");

        Attributes foto = new Attributes();
        foto.setName("foto");
        foto.setType("byte");
        foto.setTypesAttributes(typesfoto);
        foto.setEntities(personas);
        em.persist(foto);
        em.flush();

    } // Personas()

    public void Direcciones(GroupIds groupIds) {

        Entities direcciones = new Entities();
        direcciones.setName("Direcciones");
        direcciones.setGroupIds(groupIds);
        em.persist(direcciones);
        em.flush();

//      ---------------------- Attributes:Direcciones -------------------------

        TypesAttributes typesdireccion = new TypesAttributes();
        typesdireccion = findTypesAttributes("String");

        Attributes direccion = new Attributes();
        direccion.setName("direccion");
        direccion.setType("String");
        direccion.setTypesAttributes(typesdireccion);
        direccion.setEntities(direcciones);
        em.persist(direccion);
        em.flush();

        TypesAttributes typesbarrio = new TypesAttributes();
        typesbarrio = findTypesAttributes("String");

        Attributes barrio = new Attributes();
        barrio.setName("barrio");
        barrio.setType("String");
        barrio.setTypesAttributes(typesbarrio);
        barrio.setEntities(direcciones);
        em.persist(barrio);
        em.flush();

        TypesAttributes typeslatitud = new TypesAttributes();
        typeslatitud = findTypesAttributes("double");

        Attributes latitud = new Attributes();
        latitud.setName("latitud");
        latitud.setType("double");
        latitud.setTypesAttributes(typeslatitud);
        latitud.setEntities(direcciones);
        em.persist(latitud);
        em.flush();

        TypesAttributes typeslongitud = new TypesAttributes();
        typeslongitud = findTypesAttributes("double");

        Attributes longitud = new Attributes();
        longitud.setName("longitud");
        longitud.setType("double");
        longitud.setTypesAttributes(typeslongitud);
        longitud.setEntities(direcciones);
        em.persist(longitud);
        em.flush();

    } // Direcciones()

    public void Cedulas(GroupIds groupIds) {

        Entities cedulas = new Entities();
        cedulas.setName("Cedulas");
        cedulas.setGroupIds(groupIds);
        em.persist(cedulas);
        em.flush();

//      ---------------------- Attributes:Cedulas -------------------------

        TypesAttributes typesnumero = new TypesAttributes();
        typesnumero = findTypesAttributes("String");

        Attributes numero = new Attributes();
        numero.setName("numero");
        numero.setType("String");
        numero.setTypesAttributes(typesnumero);
        numero.setEntities(cedulas);
        em.persist(numero);
        em.flush();

        TypesAttributes typesfechaExpedicion = new TypesAttributes();
        typesfechaExpedicion = findTypesAttributes("Date");

        Attributes fechaExpedicion = new Attributes();
        fechaExpedicion.setName("fechaExpedicion");
        fechaExpedicion.setType("Date");
        fechaExpedicion.setTypesAttributes(typesfechaExpedicion);
        fechaExpedicion.setEntities(cedulas);
        em.persist(fechaExpedicion);
        em.flush();

    } // Cedulas()

    public void Pasajes(GroupIds groupIds) {

        Entities pasajes = new Entities();
        pasajes.setName("Pasajes");
        pasajes.setGroupIds(groupIds);
        em.persist(pasajes);
        em.flush();

//      ---------------------- Attributes:Pasajes -------------------------

        TypesAttributes typesnumero = new TypesAttributes();
        typesnumero = findTypesAttributes("Integer");

        Attributes numero = new Attributes();
        numero.setName("numero");
        numero.setType("Integer");
        numero.setTypesAttributes(typesnumero);
        numero.setEntities(pasajes);
        em.persist(numero);
        em.flush();

        TypesAttributes typesvalor = new TypesAttributes();
        typesvalor = findTypesAttributes("Float");

        Attributes valor = new Attributes();
        valor.setName("valor");
        valor.setType("Float");
        valor.setTypesAttributes(typesvalor);
        valor.setEntities(pasajes);
        em.persist(valor);
        em.flush();

    } // Pasajes()

    public void Rutas(GroupIds groupIds) {

        Entities rutas = new Entities();
        rutas.setName("Rutas");
        rutas.setGroupIds(groupIds);
        em.persist(rutas);
        em.flush();

//      ---------------------- Attributes:Rutas -------------------------

        TypesAttributes typesorigen = new TypesAttributes();
        typesorigen = findTypesAttributes("String");

        Attributes origen = new Attributes();
        origen.setName("origen");
        origen.setType("String");
        origen.setTypesAttributes(typesorigen);
        origen.setEntities(rutas);
        em.persist(origen);
        em.flush();

        TypesAttributes typesdestino = new TypesAttributes();
        typesdestino = findTypesAttributes("String");

        Attributes destino = new Attributes();
        destino.setName("destino");
        destino.setType("String");
        destino.setTypesAttributes(typesdestino);
        destino.setEntities(rutas);
        em.persist(destino);
        em.flush();

        TypesAttributes typesfechaSalida = new TypesAttributes();
        typesfechaSalida = findTypesAttributes("Date");

        Attributes fechaSalida = new Attributes();
        fechaSalida.setName("fechaSalida");
        fechaSalida.setType("Date");
        fechaSalida.setTypesAttributes(typesfechaSalida);
        fechaSalida.setEntities(rutas);
        em.persist(fechaSalida);
        em.flush();

        TypesAttributes typesfechaLLegada = new TypesAttributes();
        typesfechaLLegada = findTypesAttributes("Date");

        Attributes fechaLLegada = new Attributes();
        fechaLLegada.setName("fechaLLegada");
        fechaLLegada.setType("Date");
        fechaLLegada.setTypesAttributes(typesfechaLLegada);
        fechaLLegada.setEntities(rutas);
        em.persist(fechaLLegada);
        em.flush();

        TypesAttributes typesobservaciones = new TypesAttributes();
        typesobservaciones = findTypesAttributes("String");

        Attributes observaciones = new Attributes();
        observaciones.setName("observaciones");
        observaciones.setType("String");
        observaciones.setTypesAttributes(typesobservaciones);
        observaciones.setEntities(rutas);
        em.persist(observaciones);
        em.flush();

    } // Rutas()

    public void Buses(GroupIds groupIds) {

        Entities buses = new Entities();
        buses.setName("Buses");
        buses.setGroupIds(groupIds);
        em.persist(buses);
        em.flush();

//      ---------------------- Attributes:Buses -------------------------

        TypesAttributes typesnumero = new TypesAttributes();
        typesnumero = findTypesAttributes("String");

        Attributes numero = new Attributes();
        numero.setName("numero");
        numero.setType("String");
        numero.setTypesAttributes(typesnumero);
        numero.setEntities(buses);
        em.persist(numero);
        em.flush();

        TypesAttributes typesclase = new TypesAttributes();
        typesclase = findTypesAttributes("String");

        Attributes clase = new Attributes();
        clase.setName("clase");
        clase.setType("String");
        clase.setTypesAttributes(typesclase);
        clase.setEntities(buses);
        em.persist(clase);
        em.flush();

    } // Buses()

    public void PuestosBuses(GroupIds groupIds) {

        Entities puestosBuses = new Entities();
        puestosBuses.setName("PuestosBuses");
        puestosBuses.setGroupIds(groupIds);
        em.persist(puestosBuses);
        em.flush();

//      ---------------------- Attributes:PuestosBuses -------------------------

        TypesAttributes typesnumero = new TypesAttributes();
        typesnumero = findTypesAttributes("String");

        Attributes numero = new Attributes();
        numero.setName("numero");
        numero.setType("String");
        numero.setTypesAttributes(typesnumero);
        numero.setEntities(puestosBuses);
        em.persist(numero);
        em.flush();

        TypesAttributes typesventanilla = new TypesAttributes();
        typesventanilla = findTypesAttributes("Boolean");

        Attributes ventanilla = new Attributes();
        ventanilla.setName("ventanilla");
        ventanilla.setType("Boolean");
        ventanilla.setTypesAttributes(typesventanilla);
        ventanilla.setEntities(puestosBuses);
        em.persist(ventanilla);
        em.flush();

    } // PuestosBuses()

    public void relpersonaspasajes(GroupIds groupIds) {

        Entities relpersonaspasajes = new Entities();
        relpersonaspasajes.setName("relpersonaspasajes");
        relpersonaspasajes.setGroupIds(groupIds);
        em.persist(relpersonaspasajes);
        em.flush();

//      ---------------------- Attributes:relpersonaspasajes -------------------------

        TypesAttributes typesidpersona = new TypesAttributes();
        typesidpersona = findTypesAttributes("Long");

        Attributes idpersona = new Attributes();
        idpersona.setName("idpersona");
        idpersona.setType("Long");
        idpersona.setTypesAttributes(typesidpersona);
        idpersona.setEntities(relpersonaspasajes);
        em.persist(idpersona);
        em.flush();

        TypesAttributes typesidpasaje = new TypesAttributes();
        typesidpasaje = findTypesAttributes("Long");

        Attributes idpasaje = new Attributes();
        idpasaje.setName("idpasaje");
        idpasaje.setType("Long");
        idpasaje.setTypesAttributes(typesidpasaje);
        idpasaje.setEntities(relpersonaspasajes);
        em.persist(idpasaje);
        em.flush();

    } // relpersonaspasajes()

    public void relpasajespuestosbuses(GroupIds groupIds) {

        Entities relpasajespuestosbuses = new Entities();
        relpasajespuestosbuses.setName("relpasajespuestosbuses");
        relpasajespuestosbuses.setGroupIds(groupIds);
        em.persist(relpasajespuestosbuses);
        em.flush();

//      ---------------------- Attributes:relpasajespuestosbuses -------------------------

        TypesAttributes typesidpasaje = new TypesAttributes();
        typesidpasaje = findTypesAttributes("Long");

        Attributes idpasaje = new Attributes();
        idpasaje.setName("idpasaje");
        idpasaje.setType("Long");
        idpasaje.setTypesAttributes(typesidpasaje);
        idpasaje.setEntities(relpasajespuestosbuses);
        em.persist(idpasaje);
        em.flush();

        TypesAttributes typesidpuestobus = new TypesAttributes();
        typesidpuestobus = findTypesAttributes("Long");

        Attributes idpuestobus = new Attributes();
        idpuestobus.setName("idpuestobus");
        idpuestobus.setType("Long");
        idpuestobus.setTypesAttributes(typesidpuestobus);
        idpuestobus.setEntities(relpasajespuestosbuses);
        em.persist(idpuestobus);
        em.flush();

    } // relpasajespuestosbuses()

//  ---------------------- Relationships -------------------------

    public void Relations() {

//  ---------------------- Personas 1..* Personas -------------------------

        Entities fromPersonas4 = new Entities();
        Cardinalities Personas4 = new Cardinalities();
        Entities   toPersonas4 = new Entities();
        fromPersonas4 = findEntities("Personas");
        Personas4 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toPersonas4 = findEntities("Personas");
        Relationships relPersonas4 = new Relationships();
        relPersonas4.setFrom(fromPersonas4);
        relPersonas4.setCardinalities(Personas4);
        relPersonas4.setTo(toPersonas4);
        relPersonas4.setOptionality(true);
        em.persist(relPersonas4);
        em.flush();

//  ---------------------- Rutas 1..* Pasajes -------------------------

        Entities fromRutas1 = new Entities();
        Cardinalities Rutas1 = new Cardinalities();
        Entities   toRutas1 = new Entities();
        fromRutas1 = findEntities("Rutas");
        Rutas1 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toRutas1 = findEntities("Pasajes");
        Relationships relRutas1 = new Relationships();
        relRutas1.setFrom(fromRutas1);
        relRutas1.setCardinalities(Rutas1);
        relRutas1.setTo(toRutas1);
        relRutas1.setOptionality(true);
        em.persist(relRutas1);
        em.flush();

//  ---------------------- Buses 1..* PuestosBuses -------------------------

        Entities fromBuses0 = new Entities();
        Cardinalities Buses0 = new Cardinalities();
        Entities   toBuses0 = new Entities();
        fromBuses0 = findEntities("Buses");
        Buses0 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toBuses0 = findEntities("PuestosBuses");
        Relationships relBuses0 = new Relationships();
        relBuses0.setFrom(fromBuses0);
        relBuses0.setCardinalities(Buses0);
        relBuses0.setTo(toBuses0);
        relBuses0.setOptionality(true);
        em.persist(relBuses0);
        em.flush();

//  ---------------------- Buses 1..* Rutas -------------------------

        Entities fromBuses1 = new Entities();
        Cardinalities Buses1 = new Cardinalities();
        Entities   toBuses1 = new Entities();
        fromBuses1 = findEntities("Buses");
        Buses1 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toBuses1 = findEntities("Rutas");
        Relationships relBuses1 = new Relationships();
        relBuses1.setFrom(fromBuses1);
        relBuses1.setCardinalities(Buses1);
        relBuses1.setTo(toBuses1);
        relBuses1.setOptionality(true);
        em.persist(relBuses1);
        em.flush();

    } // Relations()
} // DomainModelsSetup

