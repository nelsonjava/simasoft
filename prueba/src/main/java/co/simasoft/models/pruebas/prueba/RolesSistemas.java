package co.simasoft.models.pruebas.prueba;

import co.simasoft.models.pruebas.prueba.*;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class RolesSistemas
{

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.TABLE)
   private long id;

   private Integer optlock;

   private int prueba;

   @ManyToOne
   private Roles roles;

   @ManyToOne
   private Sistemas sistemas;

   public RolesSistemas()
   {
   }

   public RolesSistemas(int prueba)
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

   public Roles getRoles()
   {
      return roles;
   }

   public void setRoles(Roles roles)
   {
      this.roles = roles;
   }

   public Sistemas getSistemas()
   {
      return sistemas;
   }

   public void setSistemas(Sistemas sistemas)
   {
      this.sistemas = sistemas;
   }

} // entity

