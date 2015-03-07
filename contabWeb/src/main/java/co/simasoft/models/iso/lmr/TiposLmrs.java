package co.simasoft.models.lmr;

import co.simasoft.models.lmr.*;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class TiposLmrs {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private long id;

    private Integer optlock;

    private String nombre;

    @OneToMany(mappedBy = "tiposLmrs")
    private Set<Lmrs> lmrs = new HashSet<Lmrs>();

    public TiposLmrs() {
    }

    public TiposLmrs(String nombre) {
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

    public Set<Lmrs> getLmrs() {
        return lmrs;
    }
    public void setLmrs(Set<Lmrs> lmrs) {
        this.lmrs = lmrs;
    }

} // entity

