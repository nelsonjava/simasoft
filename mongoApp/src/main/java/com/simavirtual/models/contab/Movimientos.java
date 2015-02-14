package com.simavirtual.models.contab;

import com.simavirtual.models.contab.*;

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

    private float valor;

    private String tipo;

    private float base;

    private String detalle;

    private Pucs pucs;

    private Terceros terceros;

    Movimientos() {
    }

    Movimientos(Date fecha,String documento,float valor,String tipo,float base,String detalle) {
        this.fecha = fecha;
        this.documento = documento;
        this.valor = valor;
        this.tipo = tipo;
        this.base = base;
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

    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getBase() {
        return base;
    }
    public void setBase(float base) {
        this.base = base;
    }

    public String getDetalle() {
        return detalle;
    }
    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

} // entity

