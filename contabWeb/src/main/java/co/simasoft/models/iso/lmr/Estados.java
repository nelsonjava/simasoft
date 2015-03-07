package co.simasoft.models.iso.lmr;

import co.simasoft.models.iso.lmr.*;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Estados {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private long id;

    private Integer optlock;

    private String nombre;

    @OneToMany(mappedBy = "estados")
    private Set<Lmrs> lmrs = new HashSet<Lmrs>();

    public Estados() {
    }

    public Estados(String nombre) {
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

