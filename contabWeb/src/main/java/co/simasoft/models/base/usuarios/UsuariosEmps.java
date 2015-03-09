package co.simasoft.models.base.usuarios;

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
public class UsuariosEmps {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private long id;

    private Integer optlock;

    private boolean enabled;

    private Date ultimoIngreso;

    private String ip;

    @ManyToOne
    private Personas personas;

    @ManyToOne
    private Usuarios usuarios;

    @ManyToOne
    private Empresas empresas;

    public UsuariosEmps() {
    }

    public UsuariosEmps(boolean enabled,Date ultimoIngreso,String ip) {
        this.enabled = enabled;
        this.ultimoIngreso = ultimoIngreso;
        this.ip = ip;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean getEnabled() {
        return enabled;
    }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Date getUltimoIngreso() {
        return ultimoIngreso;
    }
    public void setUltimoIngreso(Date ultimoIngreso) {
        this.ultimoIngreso = ultimoIngreso;
    }

    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }

    public Personas getPersonas() {
        return personas;
    }
    public void setPersonas(Personas personas) {
        this.personas = personas;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }
    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public Empresas getEmpresas() {
        return empresas;
    }
    public void setEmpresas(Empresas empresas) {
        this.empresas = empresas;
    }

} // entity

