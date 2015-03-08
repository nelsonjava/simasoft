package co.simasoft.models.iso.lmd;

import co.simasoft.models.iso.lmd.*;
import co.simasoft.models.iso.lmr.*;
import co.simasoft.models.iso.procesos.*;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Lmds {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private long id;

    private Integer optlock;

    private String codigo;

    private String nombre;

    private String version;

    private Date fecha;

    private String ubicacion;

    private String link;

    private String observaciones;

    @ManyToOne
    private Procesos procesos;

    @ManyToOne
    private TiposDocumentos tiposDocumentos;

    @ManyToOne
    private EstadosDocuementos estadosDocuementos;

    public Lmds() {
    }

    public Lmds(String codigo,String nombre,String version,Date fecha,String ubicacion,String link,String observaciones) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.version = version;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.link = link;
        this.observaciones = observaciones;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }

    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }

    public String getObservaciones() {
        return observaciones;
    }
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Procesos getProcesos() {
        return procesos;
    }
    public void setProcesos(Procesos procesos) {
        this.procesos = procesos;
    }

    public TiposDocumentos getTiposDocumentos() {
        return tiposDocumentos;
    }
    public void setTiposDocumentos(TiposDocumentos tiposDocumentos) {
        this.tiposDocumentos = tiposDocumentos;
    }

    public EstadosDocuementos getEstadosDocuementos() {
        return estadosDocuementos;
    }
    public void setEstadosDocuementos(EstadosDocuementos estadosDocuementos) {
        this.estadosDocuementos = estadosDocuementos;
    }

} // entity

