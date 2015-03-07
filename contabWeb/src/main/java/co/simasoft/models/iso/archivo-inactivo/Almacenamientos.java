package co.simasoft.models.archivo-inactivo;

import co.simasoft.models.archivo-inactivo.*;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Almacenamientos {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private long id;

    private Integer optlock;

    private String codigo;

    private String nombre;

    @ManyToOne
    private Ubicaciones ubicaciones;

    @OneToMany(mappedBy = "almacenamientos")
    private Set<OtrosArchivos> otrosarchivos = new HashSet<OtrosArchivos>();

    @OneToMany(mappedBy = "almacenamientos")
    private Set<ArchivosInactivos> archivosinactivos = new HashSet<ArchivosInactivos>();

    @ManyToOne
    private TiposAlmacenamientos tiposalmacenamientos;

    public Almacenamientos() {
    }

    public Almacenamientos(String codigo,String nombre) {
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

    public Ubicaciones getUbicaciones() {
        return ubicaciones;
    }
    public void setUbicaciones(Ubicaciones ubicaciones) {
        this.ubicaciones = ubicaciones;
    }

    public Set<OtrosArchivos> getOtrosArchivos() {
        return otrosArchivos;
    }
    public void setOtrosArchivos(Set<OtrosArchivos> otrosArchivos) {
        this.otrosArchivos = otrosArchivos;
    }

    public Set<ArchivosInactivos> getArchivosInactivos() {
        return archivosInactivos;
    }
    public void setArchivosInactivos(Set<ArchivosInactivos> archivosInactivos) {
        this.archivosInactivos = archivosInactivos;
    }

    public TiposAlmacenamientos getTiposAlmacenamientos() {
        return tiposAlmacenamientos;
    }
    public void setTiposAlmacenamientos(TiposAlmacenamientos tiposAlmacenamientos) {
        this.tiposAlmacenamientos = tiposAlmacenamientos;
    }

} // entity

