package co.simasoft.models.base.paises;

import co.simasoft.models.base.direcciones.*;
import co.simasoft.models.base.paises.*;
import co.simasoft.models.base.empresas.*;
import co.simasoft.models.base.mails.*;
import co.simasoft.models.base.nits.*;
import co.simasoft.models.base.permisos.*;
import co.simasoft.models.base.personas.*;
import co.simasoft.models.base.sistemas.*;
import co.simasoft.models.base.telefonos.*;
import co.simasoft.models.base.usuarios.*;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Paises {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private long id;

    private Integer optlock;

    private String codigo;

    private String nombre;

    private String codigoDane;

    @ManyToOne
    private Continentes continentes;

    @OneToMany(mappedBy = "paises")
    private Set<Departamentos> departamentos = new HashSet<Departamentos>();

    public Paises() {
    }

    public Paises(String codigo,String nombre,String codigoDane) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.codigoDane = codigoDane;
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

    public String getCodigoDane() {
        return codigoDane;
    }
    public void setCodigoDane(String codigoDane) {
        this.codigoDane = codigoDane;
    }

    public Continentes getContinentes() {
        return continentes;
    }
    public void setContinentes(Continentes continentes) {
        this.continentes = continentes;
    }

    public Set<Departamentos> getDepartamentos() {
        return departamentos;
    }
    public void setDepartamentos(Set<Departamentos> departamentos) {
        this.departamentos = departamentos;
    }

} // entity

