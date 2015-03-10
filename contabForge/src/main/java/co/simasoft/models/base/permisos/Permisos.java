package co.simasoft.models.base.permisos;

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
   private Sistemas sistemas;

   @OneToMany(mappedBy = "permisos")
   private Set<Opciones> opciones = new HashSet<Opciones>();

   @ManyToOne
   private Roles roles;

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

   public Roles getRoles()
   {
      return roles;
   }

   public void setRoles(Roles roles)
   {
      this.roles = roles;
   }

} // entity

