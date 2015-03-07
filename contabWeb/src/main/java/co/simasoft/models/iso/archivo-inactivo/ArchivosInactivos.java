package co.simasoft.models.archivo-inactivo;

import co.simasoft.models.archivo-inactivo.*;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class ArchivosInactivos {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private long id;

    private Integer optlock;

    private String observacion;

    @ManyToOne
    private Almacenamientos almacenamientos;

    @ManyToOne
    private EntradasArchivos entradasarchivos;

    public ArchivosInactivos() {
    }

    public ArchivosInactivos(String observacion) {
        this.observacion = observacion;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getObservacion() {
        return observacion;
    }
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Almacenamientos getAlmacenamientos() {
        return almacenamientos;
    }
    public void setAlmacenamientos(Almacenamientos almacenamientos) {
        this.almacenamientos = almacenamientos;
    }

    public EntradasArchivos getEntradasArchivos() {
        return entradasArchivos;
    }
    public void setEntradasArchivos(EntradasArchivos entradasArchivos) {
        this.entradasArchivos = entradasArchivos;
    }

} // entity

