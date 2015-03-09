package co.simasoft.models.base.direcciones;

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
public class Direccioness {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private long id;

    private Integer optlock;

    private int prueba;

    @ManyToOne
    private Personas personas;

    @ManyToOne
    private Empresas empresas;

    @OneToMany(mappedBy = "direccioness")
    private Set<Direcciones> direcciones = new HashSet<Direcciones>();

    public Direccioness() {
    }

    public Direccioness(int prueba) {
        this.prueba = prueba;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPrueba() {
        return prueba;
    }
    public void setPrueba(int prueba) {
        this.prueba = prueba;
    }

    public Personas getPersonas() {
        return personas;
    }
    public void setPersonas(Personas personas) {
        this.personas = personas;
    }

    public Empresas getEmpresas() {
        return empresas;
    }
    public void setEmpresas(Empresas empresas) {
        this.empresas = empresas;
    }

    public Set<Direcciones> getDirecciones() {
        return direcciones;
    }
    public void setDirecciones(Set<Direcciones> direcciones) {
        this.direcciones = direcciones;
    }

} // entity

