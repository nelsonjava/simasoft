package co.simasoft.setup;

import co.simasoft.models.*;

import java.io.*;
import java.lang.*;

public class Actividades implements Comparable<Actividades> {

    private String item = "";
    private String descripcion = "";
    private String unidad = "";
    private Double cantidad = 0.0;
    private Double vlrUnitario = 0.0;
    private Double total = 0.0;

    public Actividades() {
    }

    public String getItem() {
        return this.item;
    }
    public void setItem(String item) {
        this.item = item;
    }

    public String getDescripcion() {
        return this.descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUnidad() {
        return this.unidad;
    }
    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public Double getCantidad() {
        return cantidad;
    }
    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getVlrUnitario() {
        return vlrUnitario;
    }
    public void setVlrUnitario(Double vlrUnitario) {
        this.vlrUnitario = vlrUnitario;
    }

    public Double getTotal() {
        return total;
    }
    public void setTotal(Double vlrUnitario) {
        this.total = total;
    }

    @Override
    public int compareTo(Actividades o) {

        String a=new String(this.item);
        String b=new String(o.getItem());

        return a.compareTo(b);

    }

} // Budgets
