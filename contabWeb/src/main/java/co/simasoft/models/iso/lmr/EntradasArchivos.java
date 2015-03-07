package co.simasoft.models.lmr;

import co.simasoft.models.lmr.*;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class EntradasArchivos {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private long id;

    private Integer optlock;

    private String entity;

    @ManyToOne
    private Lmrs lmrs;

    public EntradasArchivos() {
    }

    public EntradasArchivos(String entity) {
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

    public Lmrs getLmrs() {
        return lmrs;
    }
    public void setLmrs(Lmrs lmrs) {
        this.lmrs = lmrs;
    }

} // entity

