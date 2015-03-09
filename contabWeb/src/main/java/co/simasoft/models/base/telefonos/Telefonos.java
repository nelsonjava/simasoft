package co.simasoft.models.base.telefonos;

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
public class Telefonos {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private long id;

    private Integer optlock;

    private String telefono;

    @ManyToOne
    private Direcciones direcciones;

    @ManyToOne
    private Empresas empresas;

    @ManyToOne
    private Personas personas;

    public Telefonos() {
    }

    public Telefonos(String telefono) {
        this.telefono = telefono;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Direcciones getDirecciones() {
        return direcciones;
    }
    public void setDirecciones(Direcciones direcciones) {
        this.direcciones = direcciones;
    }

    public Empresas getEmpresas() {
        return empresas;
    }
    public void setEmpresas(Empresas empresas) {
        this.empresas = empresas;
    }

    public Personas getPersonas() {
        return personas;
    }
    public void setPersonas(Personas personas) {
        this.personas = personas;
    }

} // entity

