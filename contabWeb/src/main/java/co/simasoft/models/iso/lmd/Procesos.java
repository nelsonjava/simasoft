package co.simasoft.models.lmd;

import co.simasoft.models.lmd.*;

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

    private String entitiy;

    @OneToMany(mappedBy = "procesos")
    private Set<Lmds> lmds = new HashSet<Lmds>();

    public Procesos() {
    }

    public Procesos(String entitiy) {
        this.entitiy = entitiy;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEntitiy() {
        return entitiy;
    }
    public void setEntitiy(String entitiy) {
        this.entitiy = entitiy;
    }

    public Set<Lmds> getLmds() {
        return lmds;
    }
    public void setLmds(Set<Lmds> lmds) {
        this.lmds = lmds;
    }

} // entity

