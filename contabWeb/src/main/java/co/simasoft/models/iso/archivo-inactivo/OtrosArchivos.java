package co.simasoft.models.archivo-inactivo;

import co.simasoft.models.archivo-inactivo.*;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class OtrosArchivos {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private long id;

    private Integer optlock;

    private String nombre;

    private String almacenamiento;

    private String observaciones;

    @ManyToOne
    private Almacenamientos almacenamientos;

    public OtrosArchivos() {
    }

    public OtrosArchivos(String nombre,String almacenamiento,String observaciones) {
        this.nombre = nombre;
        this.almacenamiento = almacenamiento;
        this.observaciones = observaciones;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAlmacenamiento() {
        return almacenamiento;
    }
    public void setAlmacenamiento(String almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public String getObservaciones() {
        return observaciones;
    }
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Almacenamientos getAlmacenamientos() {
        return almacenamientos;
    }
    public void setAlmacenamientos(Almacenamientos almacenamientos) {
        this.almacenamientos = almacenamientos;
    }

} // entity

