package co.simasoft.models.lmr;

import co.simasoft.models.lmr.*;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Procesos {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private long id;

    private Integer optlock;

    private String entity;

    @OneToMany(mappedBy = "procesos")
    private Set<Lmrs> lmrs = new HashSet<Lmrs>();

    public Procesos() {
    }

    public Procesos(String entity) {
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

    public Set<Lmrs> getLmrs() {
        return lmrs;
    }
    public void setLmrs(Set<Lmrs> lmrs) {
        this.lmrs = lmrs;
    }

} // entity

