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
public class Localidades
{

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.TABLE)
   private long id;

   private Integer optlock;

   private String codigo;

   private String nombre;

   private String codigoDane;

   @ManyToOne
   private Localidades objPadre;

   @OneToMany(mappedBy = "localidades")
   private Set<Direcciones> direcciones = new HashSet<Direcciones>();

   @OneToMany(mappedBy = "objPadre")
   private Set<Localidades> objHijos = new HashSet<Localidades>();

   @ManyToOne
   private TiposLocalidades tiposLocalidades;

   @ManyToOne
   private Municipios municipios;

   public Localidades()
   {
   }

   public Localidades(String codigo, String nombre, String codigoDane)
   {
      this.codigo = codigo;
      this.nombre = nombre;
      this.codigoDane = codigoDane;
   }

   public long getId()
   {
      return this.id;
   }

   public void setId(long id)
   {
      this.id = id;
   }

   public String getCodigo()
   {
      return codigo;
   }

   public void setCodigo(String codigo)
   {
      this.codigo = codigo;
   }

   public String getNombre()
   {
      return nombre;
   }

   public void setNombre(String nombre)
   {
      this.nombre = nombre;
   }

   public String getCodigoDane()
   {
      return codigoDane;
   }

   public void setCodigoDane(String codigoDane)
   {
      this.codigoDane = codigoDane;
   }

   public Localidades getObjPadre()
   {
      return this.objPadre;
   }

   public void setObjPadre(Localidades objPadre)
   {
      this.objPadre = objPadre;
   }

   public Set<Direcciones> getDirecciones()
   {
      return direcciones;
   }

   public void setDirecciones(Set<Direcciones> direcciones)
   {
      this.direcciones = direcciones;
   }

   public Set<Localidades> getObjHijos()
   {
      return this.objHijos;
   }

   public void setObjHijos(Set<Localidades> objHijos)
   {
      this.objHijos = objHijos;
   }

   public TiposLocalidades getTiposLocalidades()
   {
      return tiposLocalidades;
   }

   public void setTiposLocalidades(TiposLocalidades tiposLocalidades)
   {
      this.tiposLocalidades = tiposLocalidades;
   }

   public Municipios getMunicipios()
   {
      return municipios;
   }

   public void setMunicipios(Municipios municipios)
   {
      this.municipios = municipios;
   }

} // entity

