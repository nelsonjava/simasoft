package co.simasoft.models.lmr;

import co.simasoft.models.lmr.*;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class DisposicionFinal {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private long id;

    private Integer optlock;

    private String nombre;

    @OneToMany(mappedBy = "disposicionFinal")
    private Set<Lmrs> lmrs = new HashSet<Lmrs>();

    public DisposicionFinal() {
    }

    public DisposicionFinal(String nombre) {
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

