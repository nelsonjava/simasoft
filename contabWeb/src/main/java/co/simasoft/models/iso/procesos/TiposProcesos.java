package co.simasoft.models.iso.procesos;

import co.simasoft.models.iso.lmd.*;
import co.simasoft.models.iso.lmr.*;
import co.simasoft.models.iso.procesos.*;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class TiposProcesos {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private long id;

    private Integer optlock;

    private String codigo;

    private String nombre;

    @OneToMany(mappedBy = "tiposProcesos")
    private Set<Procesos> procesos = new HashSet<Procesos>();

    public TiposProcesos() {
    }

    public TiposProcesos(String codigo,String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Procesos> getProcesos() {
        return procesos;
    }
    public void setProcesos(Set<Procesos> procesos) {
        this.procesos = procesos;
    }

} // entity

