package com.simavirtual.models.contab;

import com.simavirtual.models.contab.*;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

/****************************************************************************************************************
* CLASE : Pucs                                                                                   *
*****************************************************************************************************************

AUTOR: Nelson A Fernández Gómez                FECHA DE INICIO: DIA DD MES/AAAA   FECHA FINAL: DIA DD MES/AAAA
       SIMASOFT Bucaramanga / SAN / Colombia   FECHA DE LA ULTIMA MODIFICACION:   DIA DD MES/AAAA HORA: HH:MM AM-PM

OBJETIVOS:

1- Entiy para MongoDb.

*---------------------------------------------------------------------------------------------------------------*
*------------------------------------------- DECLARACION DE LA CLASE -------------------------------------------*
*---------------------------------------------------------------------------------------------------------------*/

@Entity
public class Pucs {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private long id;

    private Integer optlock;

    private String nombre;

    private boolean siRegistra;

    private boolean siTercero;

    private boolean siBase;

    private String observaciones;

    private Pucs objPadre;

    private Set<Saldos> saldos = new HashSet<Saldos>();

    private Set<Pucs> objHijos = new HashSet<Pucs>();

    private Set<Movimientos> movimientos = new HashSet<Movimientos>();

    Pucs() {
    }

    Pucs(String nombre,boolean siRegistra,boolean siTercero,boolean siBase,String observaciones) {
        this.nombre = nombre;
        this.siRegistra = siRegistra;
        this.siTercero = siTercero;
        this.siBase = siBase;
        this.observaciones = observaciones;
    }

    @Id
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

} // entity

