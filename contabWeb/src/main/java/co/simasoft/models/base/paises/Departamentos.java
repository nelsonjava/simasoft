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
public class Departamentos {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private long id;

    private Integer optlock;

    private String codigo;

    private String nombre;

    private String codigoDane;

    @OneToMany(mappedBy = "departamentos")
    private Set<Municipios> municipios = new HashSet<Municipios>();

    @ManyToOne
    private Paises paises;

    public Departamentos() {
    }

    public Departamentos(String codigo,String nombre,String codigoDane) {
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

    public Set<Municipios> getMunicipios() {
        return municipios;
    }
    public void setMunicipios(Set<Municipios> municipios) {
        this.municipios = municipios;
    }

    public Paises getPaises() {
        return paises;
    }
    public void setPaises(Paises paises) {
        this.paises = paises;
    }

} // entity

