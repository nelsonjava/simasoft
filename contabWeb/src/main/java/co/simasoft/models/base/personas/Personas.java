package co.simasoft.models.base.personas;

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
public class Personas {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private long id;

    private Integer optlock;

    private String primerNombre;

    private String segundoNombre;

    private String primerApellido;

    private String segundoApellido;

    private String nombreCompleto;

    private Date fechaNacimiento;

    private Date fechadefuncion;

    private String estrato;

    @OneToMany(mappedBy = "personas")
    private Set<UsuariosEmps> usuariosEmps = new HashSet<UsuariosEmps>();

    @OneToMany(mappedBy = "personas")
    private Set<Datos> datos = new HashSet<Datos>();

    @OneToMany(mappedBy = "personas")
    private Set<Nits> nits = new HashSet<Nits>();

    public Personas() {
    }

    public Personas(String primerNombre,String segundoNombre,String primerApellido,String segundoApellido,String nombreCompleto,Date fechaNacimiento,Date fechadefuncion,String estrato) {
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.fechadefuncion = fechadefuncion;
        this.estrato = estrato;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }
    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }
    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }
    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechadefuncion() {
        return fechadefuncion;
    }
    public void setFechadefuncion(Date fechadefuncion) {
        this.fechadefuncion = fechadefuncion;
    }

    public String getEstrato() {
        return estrato;
    }
    public void setEstrato(String estrato) {
        this.estrato = estrato;
    }

    public Set<UsuariosEmps> getUsuariosEmps() {
        return usuariosEmps;
    }
    public void setUsuariosEmps(Set<UsuariosEmps> usuariosEmps) {
        this.usuariosEmps = usuariosEmps;
    }

    public Set<Datos> getDatos() {
        return datos;
    }
    public void setDatos(Set<Datos> datos) {
        this.datos = datos;
    }

    public Set<Nits> getNits() {
        return nits;
    }
    public void setNits(Set<Nits> nits) {
        this.nits = nits;
    }

} // entity

