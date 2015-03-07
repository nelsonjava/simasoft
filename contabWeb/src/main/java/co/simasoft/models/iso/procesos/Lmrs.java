package co.simasoft.models.procesos;

import co.simasoft.models.procesos.*;

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

    @ManyToOne
    private Procesos procesos;

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

    public Procesos getProcesos() {
        return procesos;
    }
    public void setProcesos(Procesos procesos) {
        this.procesos = procesos;
    }

} // entity

