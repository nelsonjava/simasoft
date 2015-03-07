package co.simasoft.models.archivo-inactivo;

import co.simasoft.models.archivo-inactivo.*;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Lmrs {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private long id;

    private Integer optlock;

    private String entity;

    @OneToMany(mappedBy = "lmrs")
    private Set<EntradasArchivos> entradasarchivos = new HashSet<EntradasArchivos>();

    public Lmrs() {
    }

    public Lmrs(String entity) {
        this.entity = entity;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEntity() {
        return entity;
    }
    public void setEntity(String entity) {
        this.entity = entity;
    }

    public Set<EntradasArchivos> getEntradasArchivos() {
        return entradasArchivos;
    }
    public void setEntradasArchivos(Set<EntradasArchivos> entradasArchivos) {
        this.entradasArchivos = entradasArchivos;
    }

} // entity

