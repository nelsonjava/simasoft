package co.simasoft.models.pruebas.prueba;

import co.simasoft.models.pruebas.prueba.*;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Roles
{

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.TABLE)
   private long id;

   private Integer optlock;

   private String name;

   private boolean conditional;

   @OneToMany(mappedBy = "roles")
   private Set<RolesSistemas> rolesSistemas = new HashSet<RolesSistemas>();

   @OneToMany(mappedBy = "roles")
   private Set<UsuariosRoles> usuariosRoles = new HashSet<UsuariosRoles>();

   @OneToMany(mappedBy = "roles")
   private Set<RolesGrupos> rolesGrupos = new HashSet<RolesGrupos>();

   @OneToMany(mappedBy = "roles")
   private Set<Permisos> permisos = new HashSet<Permisos>();

   public Roles()
   {
   }

   public Roles(String name, boolean conditional)
   {
      this.name = name;
      this.conditional = conditional;
   }

   public long getId()
   {
      return this.id;
   }

   public void setId(long id)
   {
      this.id = id;
   }

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public boolean getConditional()
   {
      return conditional;
   }

   public void setConditional(boolean conditional)
   {
      this.conditional = conditional;
   }

   public Set<RolesSistemas> getRolesSistemas()
   {
      return rolesSistemas;
   }

   public void setRolesSistemas(Set<RolesSistemas> rolesSistemas)
   {
      this.rolesSistemas = rolesSistemas;
   }

   public Set<UsuariosRoles> getUsuariosRoles()
   {
      return usuariosRoles;
   }

   public void setUsuariosRoles(Set<UsuariosRoles> usuariosRoles)
   {
      this.usuariosRoles = usuariosRoles;
   }

   public Set<RolesGrupos> getRolesGrupos()
   {
      return rolesGrupos;
   }

   public void setRolesGrupos(Set<RolesGrupos> rolesGrupos)
   {
      this.rolesGrupos = rolesGrupos;
   }

   public Set<Permisos> getPermisos()
   {
      return permisos;
   }

   public void setPermisos(Set<Permisos> permisos)
   {
      this.permisos = permisos;
   }

} // entity

