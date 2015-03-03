package co.simasoft.models.contab;

import co.simasoft.models.contab.*;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Pucs {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private Integer optlock;

    private String nombre;

    private boolean siRegistra;

    private boolean siTercero;

    private boolean siBase;

    private String observaciones;

    private Set<Pucs> objHijos = new HashSet<Pucs>();

    private Set<Movimientos> movimientos = new HashSet<Movimientos>();

    private Pucs objPadre;

    private Set<Saldos> saldos = new HashSet<Saldos>();

    public Pucs() {
    }

    public Pucs(String nombre,boolean siRegistra,boolean siTercero,boolean siBase,String observaciones) {
        this.nombre = nombre;
        this.siRegistra = siRegistra;
        this.siTercero = siTercero;
        this.siBase = siBase;
        this.observaciones = observaciones;
    }

    @Id
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getSiRegistra() {
        return siRegistra;
    }
    public void setSiRegistra(boolean siRegistra) {
        this.siRegistra = siRegistra;
    }

    public boolean getSiTercero() {
        return siTercero;
    }
    public void setSiTercero(boolean siTercero) {
        this.siTercero = siTercero;
    }

    public boolean getSiBase() {
        return siBase;
    }
    public void setSiBase(boolean siBase) {
        this.siBase = siBase;
    }

    public String getObservaciones() {
        return observaciones;
    }
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @OneToMany
    public Set<Pucs> getObjHijos() {
        return this.objHijos;
    }
    public void setObjHijos(Set<Pucs> objHijos) {
        this.objHijos = objHijos;
    }

    @OneToMany
    public Set<Movimientos> getMovimientos() {
        return movimientos;
    }
    public void setMovimientos(Set<Movimientos> movimientos) {
        this.movimientos = movimientos;
    }

    @ManyToOne
    public Pucs getObjPadre() {
        return this.objPadre;
    }
    public void setObjPadre(Pucs objPadre) {
        this.objPadre = objPadre;
    }

    @OneToMany
    public Set<Saldos> getSaldos() {
        return saldos;
    }
    public void setSaldos(Set<Saldos> saldos) {
        this.saldos = saldos;
    }

} // entity

