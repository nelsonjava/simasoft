package co.simasoft.setup;

import co.simasoft.models.naif.DomainModels.*;

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

    @PersistenceContext(unitName = "DomainModelsPU-JTA")
    private EntityManager em;

    private static final Logger log = Logger.getLogger(RelacionesEjbSetup.class.getName());

    public void data() {

        DomainModels domainModels = new DomainModels();
        domainModels.setName("RelacionesEjb");
        em.persist(domainModels);
        em.flush();

        Personas(domainModels);
        Direcciones(domainModels);
        Cedulas(domainModels);
        Pasajes(domainModels);
        Rutas(domainModels);
        Buses(domainModels);
        PuestosBuses(domainModels);
        relpersonaspasajes(domainModels);
        relpasajespuestosbuses(domainModels);
    } // data()

    public void Personas(DomainModels domainModel) {

        Entities personas = new Entities();
        personas.setName("Personas");
        personas.setDomainModels(domainModel);
        em.persist(personas);
        em.flush();

        Attributes primerNombre = new Attributes();
        primerNombre.setName("primerNombre");
        primerNombre.setType("String");
        primerNombre.setEntities(personas);
        em.persist(primerNombre);
        em.flush();

        Attributes segundoNombre = new Attributes();
        segundoNombre.setName("segundoNombre");
        segundoNombre.setType("String");
        segundoNombre.setEntities(personas);
        em.persist(segundoNombre);
        em.flush();

        Attributes primerApellido = new Attributes();
        primerApellido.setName("primerApellido");
        primerApellido.setType("String");
        primerApellido.setEntities(personas);
        em.persist(primerApellido);
        em.flush();

        Attributes segundoApellido = new Attributes();
        segundoApellido.setName("segundoApellido");
        segundoApellido.setType("String");
        segundoApellido.setEntities(personas);
        em.persist(segundoApellido);
        em.flush();

        Attributes telefono = new Attributes();
        telefono.setName("telefono");
        telefono.setType("String");
        telefono.setEntities(personas);
        em.persist(telefono);
        em.flush();

        Attributes email = new Attributes();
        email.setName("email");
        email.setType("String");
        email.setEntities(personas);
        em.persist(email);
        em.flush();

        Attributes foto = new Attributes();
        foto.setName("foto");
        foto.setType("byte");
        foto.setEntities(personas);
        em.persist(foto);
        em.flush();

    } // Personas()

    public void Direcciones(DomainModels domainModel) {

        Entities direcciones = new Entities();
        direcciones.setName("Direcciones");
        direcciones.setDomainModels(domainModel);
        em.persist(direcciones);
        em.flush();

        Attributes direccion = new Attributes();
        direccion.setName("direccion");
        direccion.setType("String");
        direccion.setEntities(direcciones);
        em.persist(direccion);
        em.flush();

        Attributes barrio = new Attributes();
        barrio.setName("barrio");
        barrio.setType("String");
        barrio.setEntities(direcciones);
        em.persist(barrio);
        em.flush();

        Attributes latitud = new Attributes();
        latitud.setName("latitud");
        latitud.setType("double");
        latitud.setEntities(direcciones);
        em.persist(latitud);
        em.flush();

        Attributes longitud = new Attributes();
        longitud.setName("longitud");
        longitud.setType("double");
        longitud.setEntities(direcciones);
        em.persist(longitud);
        em.flush();

    } // Direcciones()

    public void Cedulas(DomainModels domainModel) {

        Entities cedulas = new Entities();
        cedulas.setName("Cedulas");
        cedulas.setDomainModels(domainModel);
        em.persist(cedulas);
        em.flush();

        Attributes numero = new Attributes();
        numero.setName("numero");
        numero.setType("String");
        numero.setEntities(cedulas);
        em.persist(numero);
        em.flush();

        Attributes fechaExpedicion = new Attributes();
        fechaExpedicion.setName("fechaExpedicion");
        fechaExpedicion.setType("Date");
        fechaExpedicion.setEntities(cedulas);
        em.persist(fechaExpedicion);
        em.flush();

    } // Cedulas()

    public void Pasajes(DomainModels domainModel) {

        Entities pasajes = new Entities();
        pasajes.setName("Pasajes");
        pasajes.setDomainModels(domainModel);
        em.persist(pasajes);
        em.flush();

        Attributes numero = new Attributes();
        numero.setName("numero");
        numero.setType("Integer");
        numero.setEntities(pasajes);
        em.persist(numero);
        em.flush();

        Attributes valor = new Attributes();
        valor.setName("valor");
        valor.setType("float");
        valor.setEntities(pasajes);
        em.persist(valor);
        em.flush();

    } // Pasajes()

    public void Rutas(DomainModels domainModel) {

        Entities rutas = new Entities();
        rutas.setName("Rutas");
        rutas.setDomainModels(domainModel);
        em.persist(rutas);
        em.flush();

        Attributes origen = new Attributes();
        origen.setName("origen");
        origen.setType("String");
        origen.setEntities(rutas);
        em.persist(origen);
        em.flush();

        Attributes destino = new Attributes();
        destino.setName("destino");
        destino.setType("String");
        destino.setEntities(rutas);
        em.persist(destino);
        em.flush();

        Attributes fechaSalida = new Attributes();
        fechaSalida.setName("fechaSalida");
        fechaSalida.setType("Datetime");
        fechaSalida.setEntities(rutas);
        em.persist(fechaSalida);
        em.flush();

        Attributes fechaLLegada = new Attributes();
        fechaLLegada.setName("fechaLLegada");
        fechaLLegada.setType("Datetime");
        fechaLLegada.setEntities(rutas);
        em.persist(fechaLLegada);
        em.flush();

        Attributes observaciones = new Attributes();
        observaciones.setName("observaciones");
        observaciones.setType("String");
        observaciones.setEntities(rutas);
        em.persist(observaciones);
        em.flush();

    } // Rutas()

    public void Buses(DomainModels domainModel) {

        Entities buses = new Entities();
        buses.setName("Buses");
        buses.setDomainModels(domainModel);
        em.persist(buses);
        em.flush();

        Attributes numero = new Attributes();
        numero.setName("numero");
        numero.setType("String");
        numero.setEntities(buses);
        em.persist(numero);
        em.flush();

        Attributes clase = new Attributes();
        clase.setName("clase");
        clase.setType("String");
        clase.setEntities(buses);
        em.persist(clase);
        em.flush();

    } // Buses()

    public void PuestosBuses(DomainModels domainModel) {

        Entities puestosBuses = new Entities();
        puestosBuses.setName("PuestosBuses");
        puestosBuses.setDomainModels(domainModel);
        em.persist(puestosBuses);
        em.flush();

        Attributes numero = new Attributes();
        numero.setName("numero");
        numero.setType("String");
        numero.setEntities(puestosBuses);
        em.persist(numero);
        em.flush();

        Attributes ventanilla = new Attributes();
        ventanilla.setName("ventanilla");
        ventanilla.setType("boolean");
        ventanilla.setEntities(puestosBuses);
        em.persist(ventanilla);
        em.flush();

    } // PuestosBuses()

    public void relpersonaspasajes(DomainModels domainModel) {

        Entities relpersonaspasajes = new Entities();
        relpersonaspasajes.setName("relpersonaspasajes");
        relpersonaspasajes.setDomainModels(domainModel);
        em.persist(relpersonaspasajes);
        em.flush();

        Attributes idpersona = new Attributes();
        idpersona.setName("idpersona");
        idpersona.setType("long");
        idpersona.setEntities(relpersonaspasajes);
        em.persist(idpersona);
        em.flush();

        Attributes idpasaje = new Attributes();
        idpasaje.setName("idpasaje");
        idpasaje.setType("long");
        idpasaje.setEntities(relpersonaspasajes);
        em.persist(idpasaje);
        em.flush();

    } // relpersonaspasajes()

    public void relpasajespuestosbuses(DomainModels domainModel) {

        Entities relpasajespuestosbuses = new Entities();
        relpasajespuestosbuses.setName("relpasajespuestosbuses");
        relpasajespuestosbuses.setDomainModels(domainModel);
        em.persist(relpasajespuestosbuses);
        em.flush();

        Attributes idpasaje = new Attributes();
        idpasaje.setName("idpasaje");
        idpasaje.setType("long");
        idpasaje.setEntities(relpasajespuestosbuses);
        em.persist(idpasaje);
        em.flush();

        Attributes idpuestobus = new Attributes();
        idpuestobus.setName("idpuestobus");
        idpuestobus.setType("long");
        idpuestobus.setEntities(relpasajespuestosbuses);
        em.persist(idpuestobus);
        em.flush();

    } // relpasajespuestosbuses()

} // DomainModelsSetup

