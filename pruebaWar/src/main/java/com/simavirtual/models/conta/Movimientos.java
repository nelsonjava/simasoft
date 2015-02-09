package com.simavirtual.models.conta;

import com.simavirtual.models.conta.*;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Movimientos {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private long id;

    private Integer optlock;

    private Date fecha;

    private String documento;

    private String tipo;

    private String detalle;

    private Terceros terceros;

    private Pucs pucs;

    public Movimientos() {
    }

    public Movimientos(Date fecha,String documento,String tipo,String detalle) {
        this.fecha = fecha;
        this.documento = documento;
        this.tipo = tipo;
        this.detalle = detalle;
    }

    @Id
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDocumento() {
        return documento;
    }
    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDetalle() {
        return detalle;
    }
    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    @ManyToOne
    public Terceros getTerceros() {
        return terceros;
    }
    public void setTerceros(Terceros terceros) {
        this.terceros = terceros;
    }

    @ManyToOne
    public Pucs getPucs() {
        return pucs;
    }
    public void setPucs(Pucs pucs) {
        this.pucs = pucs;
    }

} // entity

