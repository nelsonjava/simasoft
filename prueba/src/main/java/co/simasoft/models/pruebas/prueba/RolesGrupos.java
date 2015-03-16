package co.simasoft.models.pruebas.prueba;

import co.simasoft.models.pruebas.prueba.*;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class RolesGrupos
{

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.TABLE)
   private long id;

   private Integer optlock;

   private String nombre;

   @ManyToOne
   private Roles roles;

   public RolesGrupos()
   {
   }

   public RolesGrupos(String nombre)
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

   public Roles getRoles()
   {
      return roles;
   }

   public void setRoles(Roles roles)
   {
      this.roles = roles;
   }

} // entity

