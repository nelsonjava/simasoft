package co.simasoft.models.base.direcciones;

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
public class TiposEdificaciones
{

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.TABLE)
   private long id;

   private Integer optlock;

   private String nombre;

   @OneToMany(mappedBy = "tiposEdificaciones")
   private Set<Direcciones> direcciones = new HashSet<Direcciones>();

   public TiposEdificaciones()
   {
   }

   public TiposEdificaciones(String nombre)
   {
      this.nombre = nombre;
   }

   public long getId()
   {
      return this.id;
   }

   public void setId(long id)
   {
      this.id = id;
   }

   public String getNombre()
   {
      return nombre;
   }

   public void setNombre(String nombre)
   {
      this.nombre = nombre;
   }

   public Set<Direcciones> getDirecciones()
   {
      return direcciones;
   }

   public void setDirecciones(Set<Direcciones> direcciones)
   {
      this.direcciones = direcciones;
   }

} // entity

