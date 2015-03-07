package co.simasoft.models.archivo-inactivo;

import co.simasoft.models.archivo-inactivo.*;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Ubicaciones {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private long id;

    private Integer optlock;

    private String codigo;

    private String nombre;

    @OneToMany(mappedBy = "ubicaciones")
    private Set<Almacenamientos> almacenamientos = new HashSet<Almacenamientos>();

    @ManyToOne
    private TiposUbicaciones tiposubicaciones;

    public Ubicaciones() {
    }

    public Ubicaciones(String codigo,String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
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

    public Set<Almacenamientos> getAlmacenamientos() {
        return almacenamientos;
    }
    public void setAlmacenamientos(Set<Almacenamientos> almacenamientos) {
        this.almacenamientos = almacenamientos;
    }

    public TiposUbicaciones getTiposUbicaciones() {
        return tiposUbicaciones;
    }
    public void setTiposUbicaciones(TiposUbicaciones tiposUbicaciones) {
        this.tiposUbicaciones = tiposUbicaciones;
    }

} // entity

