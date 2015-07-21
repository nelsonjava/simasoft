package co.simasoft.beans;

import co.simasoft.models.naif.sgdea.*;

import java.util.*;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class FindBean {

    @PersistenceContext(unitName = "sgdeaPU-JTA")
    private EntityManager em;

//      ---------------------- InventarioDocumental ------------------------

    public List<InventarioDocumental> AllInventarioDocumental() {
        List<InventarioDocumental> results = em.createQuery("SELECT o FROM InventarioDocumental o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<InventarioDocumental>();
        }
        return results;
    }

    public InventarioDocumental idInventarioDocumental(Long id) {

        InventarioDocumental inventarioDocumental = new InventarioDocumental();
        List<InventarioDocumental> results = em.createQuery("SELECT o FROM InventarioDocumental o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           inventarioDocumental = results.get(0);
        }
        return inventarioDocumental;
    }

//      ---------------------- UnidadesConservacion ------------------------

    public List<UnidadesConservacion> AllUnidadesConservacion() {
        List<UnidadesConservacion> results = em.createQuery("SELECT o FROM UnidadesConservacion o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<UnidadesConservacion>();
        }
        return results;
    }

    public UnidadesConservacion idUnidadesConservacion(Long id) {

        UnidadesConservacion unidadesConservacion = new UnidadesConservacion();
        List<UnidadesConservacion> results = em.createQuery("SELECT o FROM UnidadesConservacion o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           unidadesConservacion = results.get(0);
        }
        return unidadesConservacion;
    }

//      ---------------------- VigenciaFondos ------------------------

    public List<VigenciaFondos> AllVigenciaFondos() {
        List<VigenciaFondos> results = em.createQuery("SELECT o FROM VigenciaFondos o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<VigenciaFondos>();
        }
        return results;
    }

    public VigenciaFondos idVigenciaFondos(Long id) {

        VigenciaFondos vigenciaFondos = new VigenciaFondos();
        List<VigenciaFondos> results = em.createQuery("SELECT o FROM VigenciaFondos o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           vigenciaFondos = results.get(0);
        }
        return vigenciaFondos;
    }

//      ---------------------- Series ------------------------

    public List<Series> AllSeries() {
        List<Series> results = em.createQuery("SELECT o FROM Series o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Series>();
        }
        return results;
    }

    public Series idSeries(Long id) {

        Series series = new Series();
        List<Series> results = em.createQuery("SELECT o FROM Series o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           series = results.get(0);
        }
        return series;
    }

//      ---------------------- FondosDocumentales ------------------------

    public List<FondosDocumentales> AllFondosDocumentales() {
        List<FondosDocumentales> results = em.createQuery("SELECT o FROM FondosDocumentales o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<FondosDocumentales>();
        }
        return results;
    }

    public FondosDocumentales idFondosDocumentales(Long id) {

        FondosDocumentales fondosDocumentales = new FondosDocumentales();
        List<FondosDocumentales> results = em.createQuery("SELECT o FROM FondosDocumentales o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           fondosDocumentales = results.get(0);
        }
        return fondosDocumentales;
    }

//      ---------------------- RetencionDocumental ------------------------

    public List<RetencionDocumental> AllRetencionDocumental() {
        List<RetencionDocumental> results = em.createQuery("SELECT o FROM RetencionDocumental o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<RetencionDocumental>();
        }
        return results;
    }

    public RetencionDocumental idRetencionDocumental(Long id) {

        RetencionDocumental retencionDocumental = new RetencionDocumental();
        List<RetencionDocumental> results = em.createQuery("SELECT o FROM RetencionDocumental o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           retencionDocumental = results.get(0);
        }
        return retencionDocumental;
    }

//      ---------------------- UnidadesDocumentales ------------------------

    public List<UnidadesDocumentales> AllUnidadesDocumentales() {
        List<UnidadesDocumentales> results = em.createQuery("SELECT o FROM UnidadesDocumentales o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<UnidadesDocumentales>();
        }
        return results;
    }

    public UnidadesDocumentales idUnidadesDocumentales(Long id) {

        UnidadesDocumentales unidadesDocumentales = new UnidadesDocumentales();
        List<UnidadesDocumentales> results = em.createQuery("SELECT o FROM UnidadesDocumentales o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           unidadesDocumentales = results.get(0);
        }
        return unidadesDocumentales;
    }

//      ---------------------- Empresas ------------------------

    public List<Empresas> AllEmpresas() {
        List<Empresas> results = em.createQuery("SELECT o FROM Empresas o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Empresas>();
        }
        return results;
    }

    public Empresas idEmpresas(Long id) {

        Empresas empresas = new Empresas();
        List<Empresas> results = em.createQuery("SELECT o FROM Empresas o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           empresas = results.get(0);
        }
        return empresas;
    }

//      ---------------------- DisposicionFinal ------------------------

    public List<DisposicionFinal> AllDisposicionFinal() {
        List<DisposicionFinal> results = em.createQuery("SELECT o FROM DisposicionFinal o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<DisposicionFinal>();
        }
        return results;
    }

    public DisposicionFinal idDisposicionFinal(Long id) {

        DisposicionFinal disposicionFinal = new DisposicionFinal();
        List<DisposicionFinal> results = em.createQuery("SELECT o FROM DisposicionFinal o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           disposicionFinal = results.get(0);
        }
        return disposicionFinal;
    }

//      ---------------------- Personas ------------------------

    public List<Personas> AllPersonas() {
        List<Personas> results = em.createQuery("SELECT o FROM Personas o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Personas>();
        }
        return results;
    }

    public Personas idPersonas(Long id) {

        Personas personas = new Personas();
        List<Personas> results = em.createQuery("SELECT o FROM Personas o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           personas = results.get(0);
        }
        return personas;
    }

//      ---------------------- Secciones ------------------------

    public List<Secciones> AllSecciones() {
        List<Secciones> results = em.createQuery("SELECT o FROM Secciones o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Secciones>();
        }
        return results;
    }

    public Secciones idSecciones(Long id) {

        Secciones secciones = new Secciones();
        List<Secciones> results = em.createQuery("SELECT o FROM Secciones o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           secciones = results.get(0);
        }
        return secciones;
    }

//      ---------------------- SoporteDocumental ------------------------

    public List<SoporteDocumental> AllSoporteDocumental() {
        List<SoporteDocumental> results = em.createQuery("SELECT o FROM SoporteDocumental o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<SoporteDocumental>();
        }
        return results;
    }

    public SoporteDocumental idSoporteDocumental(Long id) {

        SoporteDocumental soporteDocumental = new SoporteDocumental();
        List<SoporteDocumental> results = em.createQuery("SELECT o FROM SoporteDocumental o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           soporteDocumental = results.get(0);
        }
        return soporteDocumental;
    }

//      ---------------------- FrecuenciasConsulta ------------------------

    public List<FrecuenciasConsulta> AllFrecuenciasConsulta() {
        List<FrecuenciasConsulta> results = em.createQuery("SELECT o FROM FrecuenciasConsulta o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<FrecuenciasConsulta>();
        }
        return results;
    }

    public FrecuenciasConsulta idFrecuenciasConsulta(Long id) {

        FrecuenciasConsulta frecuenciasConsulta = new FrecuenciasConsulta();
        List<FrecuenciasConsulta> results = em.createQuery("SELECT o FROM FrecuenciasConsulta o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           frecuenciasConsulta = results.get(0);
        }
        return frecuenciasConsulta;
    }

//      ---------------------- TiposDocumentales ------------------------

    public List<TiposDocumentales> AllTiposDocumentales() {
        List<TiposDocumentales> results = em.createQuery("SELECT o FROM TiposDocumentales o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<TiposDocumentales>();
        }
        return results;
    }

    public TiposDocumentales idTiposDocumentales(Long id) {

        TiposDocumentales tiposDocumentales = new TiposDocumentales();
        List<TiposDocumentales> results = em.createQuery("SELECT o FROM TiposDocumentales o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           tiposDocumentales = results.get(0);
        }
        return tiposDocumentales;
    }

//      ---------------------- Trd ------------------------

    public List<Trd> AllTrd() {
        List<Trd> results = em.createQuery("SELECT o FROM Trd o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<Trd>();
        }
        return results;
    }

    public Trd idTrd(Long id) {

        Trd trd = new Trd();
        List<Trd> results = em.createQuery("SELECT o FROM Trd o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           trd = results.get(0);
        }
        return trd;
    }

//      ---------------------- FinalidadInventario ------------------------

    public List<FinalidadInventario> AllFinalidadInventario() {
        List<FinalidadInventario> results = em.createQuery("SELECT o FROM FinalidadInventario o").getResultList();
        if (results.isEmpty()) {
            return new ArrayList<FinalidadInventario>();
        }
        return results;
    }

    public FinalidadInventario idFinalidadInventario(Long id) {

        FinalidadInventario finalidadInventario = new FinalidadInventario();
        List<FinalidadInventario> results = em.createQuery("SELECT o FROM FinalidadInventario o WHERE o.id LIKE :custId").setParameter("custId", id).getResultList();

        if (!results.isEmpty()) {

           finalidadInventario = results.get(0);
        }
        return finalidadInventario;
    }

} // Fin de clase
