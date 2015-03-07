package co.simasoft.models.iso.lmd;

import co.simasoft.models.iso.lmd.*;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class EstadosDocuementos {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private long id;

    private Integer optlock;

    private String nombre;

    @OneToMany(mappedBy = "estadosDocuementos")
    private Set<Lmds> lmds = new HashSet<Lmds>();

    public EstadosDocuementos() {
    }

    public EstadosDocuementos(String nombre) {
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

    public Set<Lmds> getLmds() {
        return lmds;
    }
    public void setLmds(Set<Lmds> lmds) {
        this.lmds = lmds;
    }

} // entity

