package co.simasoft.models.base.usuarios;

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
public class UsuariosRoles
{

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.TABLE)
   private long id;

   private Integer optlock;

   private int prueba;

   @ManyToOne
   private Usuarios usuarios;

   @ManyToOne
   private Roles roles;

   public UsuariosRoles()
   {
   }

   public UsuariosRoles(int prueba)
   {
      this.prueba = prueba;
   }

   public long getId()
   {
      return this.id;
   }

   public void setId(long id)
   {
      this.id = id;
   }

   public int getPrueba()
   {
      return prueba;
   }

   public void setPrueba(int prueba)
   {
      this.prueba = prueba;
   }

   public Usuarios getUsuarios()
   {
      return usuarios;
   }

   public void setUsuarios(Usuarios usuarios)
   {
      this.usuarios = usuarios;
   }

   public Roles getRoles()
   {
      return roles;
   }

   public void setRoles(Roles roles)
   {
      this.roles = roles;
   }

} // entity
