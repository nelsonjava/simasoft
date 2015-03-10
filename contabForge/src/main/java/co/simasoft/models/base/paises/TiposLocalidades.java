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
public class TiposLocalidades
{

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.TABLE)
   private long id;

   private Integer optlock;

   private String codigo;

   private String nombre;

   private String codigoDane;

   @OneToMany(mappedBy = "tiposLocalidades")
   private Set<Localidades> localidades = new HashSet<Localidades>();

   @ManyToOne
   private TiposLocalidades objPadre;

   @OneToMany(mappedBy = "objPadre")
   private Set<TiposLocalidades> objHijos = new HashSet<TiposLocalidades>();

   public TiposLocalidades()
   {
   }

   public TiposLocalidades(String codigo, String nombre, String codigoDane)
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

   public Set<Localidades> getLocalidades()
   {
      return localidades;
   }

   public void setLocalidades(Set<Localidades> localidades)
   {
      this.localidades = localidades;
   }

   public TiposLocalidades getObjPadre()
   {
      return this.objPadre;
   }

   public void setObjPadre(TiposLocalidades objPadre)
   {
      this.objPadre = objPadre;
   }

   public Set<TiposLocalidades> getObjHijos()
   {
      return this.objHijos;
   }

   public void setObjHijos(Set<TiposLocalidades> objHijos)
   {
      this.objHijos = objHijos;
   }

} // entity

