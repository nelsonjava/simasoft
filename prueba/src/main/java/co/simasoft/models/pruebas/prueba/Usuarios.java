package co.simasoft.models.pruebas.prueba;

import co.simasoft.models.pruebas.prueba.*;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Usuarios
{

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.TABLE)
   private long id;

   private Integer optlock;

   private String cuenta;

   private String password;

   private boolean enabled;

   @OneToMany(mappedBy = "usuarios")
   private Set<Permisos> permisos = new HashSet<Permisos>();

   @OneToMany(mappedBy = "usuarios")
   private Set<UsuariosEmps> usuariosEmps = new HashSet<UsuariosEmps>();

   @OneToMany(mappedBy = "usuarios")
   private Set<UsuariosRoles> usuariosRoles = new HashSet<UsuariosRoles>();

   public Usuarios()
   {
   }

   public Usuarios(String cuenta, String password, boolean enabled)
   {
      this.cuenta = cuenta;
      this.password = password;
      this.enabled = enabled;
   }

   public long getId()
   {
      return this.id;
   }

   public void setId(long id)
   {
      this.id = id;
   }

   public String getCuenta()
   {
      return cuenta;
   }

   public void setCuenta(String cuenta)
   {
      this.cuenta = cuenta;
   }

   public String getPassword()
   {
      return password;
   }

   public void setPassword(String password)
   {
      this.password = password;
   }

   public boolean getEnabled()
   {
      return enabled;
   }

   public void setEnabled(boolean enabled)
   {
      this.enabled = enabled;
   }

   public Set<Permisos> getPermisos()
   {
      return permisos;
   }

   public void setPermisos(Set<Permisos> permisos)
   {
      this.permisos = permisos;
   }

   public Set<UsuariosEmps> getUsuariosEmps()
   {
      return usuariosEmps;
   }

   public void setUsuariosEmps(Set<UsuariosEmps> usuariosEmps)
   {
      this.usuariosEmps = usuariosEmps;
   }

   public Set<UsuariosRoles> getUsuariosRoles()
   {
      return usuariosRoles;
   }

   public void setUsuariosRoles(Set<UsuariosRoles> usuariosRoles)
   {
      this.usuariosRoles = usuariosRoles;
   }

} // entity
