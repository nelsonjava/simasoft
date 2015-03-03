package co.simasoft.models.contab;

import co.simasoft.models.contab.*;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Saldos {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private Integer optlock;

    private Date year;

    private Date mes;

    private float debitos;

    private float creditos;

    private float saldoInicial;

    private float saldoFinal;

    private Terceros terceros;

    private Pucs pucs;

    public Saldos() {
    }

    public Saldos(Date year,Date mes,float debitos,float creditos,float saldoInicial,float saldoFinal) {
        this.year = year;
        this.mes = mes;
        this.debitos = debitos;
        this.creditos = creditos;
        this.saldoInicial = saldoInicial;
        this.saldoFinal = saldoFinal;
    }

    @Id
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getYear() {
        return year;
    }
    public void setYear(Date year) {
        this.year = year;
    }

    public Date getMes() {
        return mes;
    }
    public void setMes(Date mes) {
        this.mes = mes;
    }

    public float getDebitos() {
        return debitos;
    }
    public void setDebitos(float debitos) {
        this.debitos = debitos;
    }

    public float getCreditos() {
        return creditos;
    }
    public void setCreditos(float creditos) {
        this.creditos = creditos;
    }

    public float getSaldoInicial() {
        return saldoInicial;
    }
    public void setSaldoInicial(float saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public float getSaldoFinal() {
        return saldoFinal;
    }
    public void setSaldoFinal(float saldoFinal) {
        this.saldoFinal = saldoFinal;
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

