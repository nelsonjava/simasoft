package co.simasoft.models.contab;

import co.simasoft.models.contab.*;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Terceros {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private long id;

    private Integer optlock;

    private String nit;

    private String nombre;

    private String telefono;

    private String direccion;

    private String observaciones;

    @OneToMany(mappedBy = "terceros")
    private Set<Saldos> saldos = new HashSet<Saldos>();

    @OneToMany(mappedBy = "terceros")
    private Set<Movimientos> movimientos = new HashSet<Movimientos>();

    public Terceros() {
    }

    public Terceros(String nit,String nombre,String telefono,String direccion,String observaciones) {
        this.nit = nit;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.observaciones = observaciones;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNit() {
        return nit;
    }
    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getObservaciones() {
        return observaciones;
    }
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Set<Saldos> getSaldos() {
        return saldos;
    }
    public void setSaldos(Set<Saldos> saldos) {
        this.saldos = saldos;
    }

    public Set<Movimientos> getMovimientos() {
        return movimientos;
    }
    public void setMovimientos(Set<Movimientos> movimientos) {
        this.movimientos = movimientos;
    }

} // entity

