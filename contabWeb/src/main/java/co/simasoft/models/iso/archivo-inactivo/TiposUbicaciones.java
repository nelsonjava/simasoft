package co.simasoft.models.archivo-inactivo;

import co.simasoft.models.archivo-inactivo.*;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class TiposUbicaciones {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private long id;

    private Integer optlock;

    private String codigo;

    private String nombre;

    private String descripcion;

    private String link;

    @OneToMany(mappedBy = "tiposUbicaciones")
    private Set<Ubicaciones> ubicaciones = new HashSet<Ubicaciones>();

    public TiposUbicaciones() {
    }

    public TiposUbicaciones(String codigo,String nombre,String descripcion,String link) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.link = link;
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

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }

    public Set<Ubicaciones> getUbicaciones() {
        return ubicaciones;
    }
    public void setUbicaciones(Set<Ubicaciones> ubicaciones) {
        this.ubicaciones = ubicaciones;
    }

} // entity

