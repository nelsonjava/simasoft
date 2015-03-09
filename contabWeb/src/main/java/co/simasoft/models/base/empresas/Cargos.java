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
public class Cargos {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private long id;

    private Integer optlock;

    private String nombre;

    @ManyToOne
    private Empleados empleados;

    @ManyToOne
    private TiposCargos tiposCargos;

    public Cargos() {
    }

    public Cargos(String nombre) {
        this.nombre = nombre;
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

    public Empleados getEmpleados() {
        return empleados;
    }
    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }

    public TiposCargos getTiposCargos() {
        return tiposCargos;
    }
    public void setTiposCargos(TiposCargos tiposCargos) {
        this.tiposCargos = tiposCargos;
    }

} // entity

