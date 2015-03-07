package co.simasoft.models.archivo-inactivo;

import co.simasoft.models.archivo-inactivo.*;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class EntradasArchivos {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private long id;

    private Integer optlock;

    private String almacenamiento;

    private String folios;

    private Date fechaIngreso;

    private Date fechaInicial;

    private Date fechaFinal;

    private Date fechaDepuracion;

    private String observacion;

    private boolean siDepurado;

    @ManyToOne
    private TiposArchivos tiposarchivos;

    @ManyToOne
    private Lmrs lmrs;

    @ManyToOne
    private AnosDepuraciones anosdepuraciones;

    @OneToMany(mappedBy = "entradasArchivos")
    private Set<ArchivosInactivos> archivosinactivos = new HashSet<ArchivosInactivos>();

    public EntradasArchivos() {
    }

    public EntradasArchivos(String almacenamiento,String folios,Date fechaIngreso,Date fechaInicial,Date fechaFinal,Date fechaDepuracion,String observacion,boolean siDepurado) {
        this.almacenamiento = almacenamiento;
        this.folios = folios;
        this.fechaIngreso = fechaIngreso;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.fechaDepuracion = fechaDepuracion;
        this.observacion = observacion;
        this.siDepurado = siDepurado;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAlmacenamiento() {
        return almacenamiento;
    }
    public void setAlmacenamiento(String almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public String getFolios() {
        return folios;
    }
    public void setFolios(String folios) {
        this.folios = folios;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }
    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }
    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }
    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Date getFechaDepuracion() {
        return fechaDepuracion;
    }
    public void setFechaDepuracion(Date fechaDepuracion) {
        this.fechaDepuracion = fechaDepuracion;
    }

    public String getObservacion() {
        return observacion;
    }
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public boolean getSiDepurado() {
        return siDepurado;
    }
    public void setSiDepurado(boolean siDepurado) {
        this.siDepurado = siDepurado;
    }

    public TiposArchivos getTiposArchivos() {
        return tiposArchivos;
    }
    public void setTiposArchivos(TiposArchivos tiposArchivos) {
        this.tiposArchivos = tiposArchivos;
    }

    public Lmrs getLmrs() {
        return lmrs;
    }
    public void setLmrs(Lmrs lmrs) {
        this.lmrs = lmrs;
    }

    public AnosDepuraciones getAnosDepuraciones() {
        return anosDepuraciones;
    }
    public void setAnosDepuraciones(AnosDepuraciones anosDepuraciones) {
        this.anosDepuraciones = anosDepuraciones;
    }

    public Set<ArchivosInactivos> getArchivosInactivos() {
        return archivosInactivos;
    }
    public void setArchivosInactivos(Set<ArchivosInactivos> archivosInactivos) {
        this.archivosInactivos = archivosInactivos;
    }

} // entity

