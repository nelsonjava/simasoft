package co.simasoft.models.naif.relacionesejb;

import co.simasoft.models.naif.relacionesejb.*;

import java.io.*;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Personas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private Long id;

    @Version
    private Integer optlock;

    private long orden;

    private String primerNombre;

    private String segundoNombre;

    private String primerApellido;

    private String segundoApellido;

    private String telefono;

    private String email;

    private byte foto;

    @OneToMany(mappedBy = "objPadre")
    private Set<Personas> objHijos = new HashSet<Personas>();

    @ManyToOne
    private Personas objPadre;

    @ManyToMany(mappedBy = "personas")
    private Set<Pasajes> pasajes = new HashSet<Pasajes>();

    public Personas() {
    }

    public Personas(String primerNombre,String segundoNombre,String primerApellido,String segundoApellido,String telefono,String email,byte foto) {
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.telefono = telefono;
        this.email = email;
        this.foto = foto;
    }

    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOptlock() {
        return this.optlock;
    }
    public void setOptlock(Integer optlock) {
        this.optlock = optlock;
    }

    public long getOrden() {
        return this.orden;
    }
    public void setOrden(long orden) {
        this.orden = orden;
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

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public byte getFoto() {
        return foto;
    }
    public void setFoto(byte foto) {
        this.foto = foto;
    }

    public Set<Personas> getObjHijos() {
        return this.objHijos;
    }
    public void setObjHijos(Set<Personas> objHijos) {
        this.objHijos = objHijos;
    }

    public Personas getObjPadre() {
        return this.objPadre;
    }
    public void setObjPadre(Personas objPadre) {
        this.objPadre = objPadre;
    }

    public Set<Pasajes> getPasajes() {
        return pasajes;
    }
    public void setPasajes(Set<Pasajes> pasajes) {
        this.pasajes = pasajes;
    }

   @Override
   public int hashCode() {
      final int prime  = 31;
            int result =  1;

      result = prime * result + ((id == null) ? 0 : id.hashCode());

      return result;
   }

   @Override
   public boolean equals(Object ojt) {
      if (      this == ojt           ) return true;
      if (       ojt == null          ) return false;
      if (getClass() != ojt.getClass()) return false;

      Personas other = (Personas) ojt;
      if (id == null) {
         if (other.id != null) {
            return false;
         }
      } else {
         if (!id.equals(other.id)) {
            return false;
         }
      }

      return true;
   }

} // entity

