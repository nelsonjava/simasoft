package co.simasoft.models.pruebas.prueba;

import co.simasoft.models.pruebas.prueba.*;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Permisos
{

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.TABLE)
   private long id;

   private Integer optlock;

   private String recipient;

   private String target;

   private String action;

   private String discriminator;

   @ManyToOne
   private Usuarios usuarios;

   @ManyToOne
   private Roles roles;

   @ManyToOne
   private Sistemas sistemas;

   @OneToMany(mappedBy = "permisos")
   private Set<Opciones> opciones = new HashSet<Opciones>();

   public Permisos()
   {
   }

   public Permisos(String recipient, String target, String action, String discriminator)
   {
      this.recipient = recipient;
      this.target = target;
      this.action = action;
      this.discriminator = discriminator;
   }

   public long getId()
   {
      return this.id;
   }

   public void setId(long id)
   {
      this.id = id;
   }

   public String getRecipient()
   {
      return recipient;
   }

   public void setRecipient(String recipient)
   {
      this.recipient = recipient;
   }

   public String getTarget()
   {
      return target;
   }

   public void setTarget(String target)
   {
      this.target = target;
   }

   public String getAction()
   {
      return action;
   }

   public void setAction(String action)
   {
      this.action = action;
   }

   public String getDiscriminator()
   {
      return discriminator;
   }

   public void setDiscriminator(String discriminator)
   {
      this.discriminator = discriminator;
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

   public Sistemas getSistemas()
   {
      return sistemas;
   }

   public void setSistemas(Sistemas sistemas)
   {
      this.sistemas = sistemas;
   }

   public Set<Opciones> getOpciones()
   {
      return opciones;
   }

   public void setOpciones(Set<Opciones> opciones)
   {
      this.opciones = opciones;
   }

} // entity

