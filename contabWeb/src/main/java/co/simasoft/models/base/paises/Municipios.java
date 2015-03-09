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
public class Municipios {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private long id;

    private Integer optlock;

    private String codigo;

    private String nombre;

    private String codigoDane;

    @ManyToOne
    private TiposMunicipios tiposMunicipios;

    @ManyToOne
    private Departamentos departamentos;

    @OneToMany(mappedBy = "municipios")
    private Set<Localidades> localidades = new HashSet<Localidades>();

    public Municipios() {
    }

    public Municipios(String codigo,String nombre,String codigoDane) {
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

    public TiposMunicipios getTiposMunicipios() {
        return tiposMunicipios;
    }
    public void setTiposMunicipios(TiposMunicipios tiposMunicipios) {
        this.tiposMunicipios = tiposMunicipios;
    }

    public Departamentos getDepartamentos() {
        return departamentos;
    }
    public void setDepartamentos(Departamentos departamentos) {
        this.departamentos = departamentos;
    }

    public Set<Localidades> getLocalidades() {
        return localidades;
    }
    public void setLocalidades(Set<Localidades> localidades) {
        this.localidades = localidades;
    }

} // entity

