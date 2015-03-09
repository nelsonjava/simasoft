package co.simasoft.models.base.empresas;

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
public class Empresas {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private long id;

    private Integer optlock;

    private String nombre;

    private String nombreSecundario;

    private String titulo;

    private String eslogan;

    private String vision;

    private String mision;

    private String politicaCalidad;

    private String objetivosCalidad;

    @OneToMany(mappedBy = "objPadre")
    private Set<Empresas> objHijos = new HashSet<Empresas>();

    @OneToMany(mappedBy = "empresas")
    private Set<Nits> nits = new HashSet<Nits>();

    @OneToMany(mappedBy = "empresas")
    private Set<Datos> datos = new HashSet<Datos>();

    @OneToMany(mappedBy = "empresas")
    private Set<Empleados> empleados = new HashSet<Empleados>();

    @ManyToOne
    private Empresas objPadre;

    @OneToMany(mappedBy = "empresas")
    private Set<UsuariosEmps> usuariosEmps = new HashSet<UsuariosEmps>();

    public Empresas() {
    }

    public Empresas(String nombre,String nombreSecundario,String titulo,String eslogan,String vision,String mision,String politicaCalidad,String objetivosCalidad) {
        this.nombre = nombre;
        this.nombreSecundario = nombreSecundario;
        this.titulo = titulo;
        this.eslogan = eslogan;
        this.vision = vision;
        this.mision = mision;
        this.politicaCalidad = politicaCalidad;
        this.objetivosCalidad = objetivosCalidad;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreSecundario() {
        return nombreSecundario;
    }
    public void setNombreSecundario(String nombreSecundario) {
        this.nombreSecundario = nombreSecundario;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEslogan() {
        return eslogan;
    }
    public void setEslogan(String eslogan) {
        this.eslogan = eslogan;
    }

    public String getVision() {
        return vision;
    }
    public void setVision(String vision) {
        this.vision = vision;
    }

    public String getMision() {
        return mision;
    }
    public void setMision(String mision) {
        this.mision = mision;
    }

    public String getPoliticaCalidad() {
        return politicaCalidad;
    }
    public void setPoliticaCalidad(String politicaCalidad) {
        this.politicaCalidad = politicaCalidad;
    }

    public String getObjetivosCalidad() {
        return objetivosCalidad;
    }
    public void setObjetivosCalidad(String objetivosCalidad) {
        this.objetivosCalidad = objetivosCalidad;
    }

    public Set<Empresas> getObjHijos() {
        return this.objHijos;
    }
    public void setObjHijos(Set<Empresas> objHijos) {
        this.objHijos = objHijos;
    }

    public Set<Nits> getNits() {
        return nits;
    }
    public void setNits(Set<Nits> nits) {
        this.nits = nits;
    }

    public Set<Datos> getDatos() {
        return datos;
    }
    public void setDatos(Set<Datos> datos) {
        this.datos = datos;
    }

    public Set<Empleados> getEmpleados() {
        return empleados;
    }
    public void setEmpleados(Set<Empleados> empleados) {
        this.empleados = empleados;
    }

    public Empresas getObjPadre() {
        return this.objPadre;
    }
    public void setObjPadre(Empresas objPadre) {
        this.objPadre = objPadre;
    }

    public Set<UsuariosEmps> getUsuariosEmps() {
        return usuariosEmps;
    }
    public void setUsuariosEmps(Set<UsuariosEmps> usuariosEmps) {
        this.usuariosEmps = usuariosEmps;
    }

} // entity

