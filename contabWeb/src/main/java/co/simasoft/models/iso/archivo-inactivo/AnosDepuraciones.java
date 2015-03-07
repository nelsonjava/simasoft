package co.simasoft.models.archivo-inactivo;

import co.simasoft.models.archivo-inactivo.*;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class AnosDepuraciones {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private long id;

    private Integer optlock;

    private String nombre;

    @OneToMany(mappedBy = "anosDepuraciones")
    private Set<EntradasArchivos> entradasarchivos = new HashSet<EntradasArchivos>();

    public AnosDepuraciones() {
    }

    public AnosDepuraciones(String nombre) {
        this.nombre = nombre;
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

    public Set<EntradasArchivos> getEntradasArchivos() {
        return entradasArchivos;
    }
    public void setEntradasArchivos(Set<EntradasArchivos> entradasArchivos) {
        this.entradasArchivos = entradasArchivos;
    }

} // entity

