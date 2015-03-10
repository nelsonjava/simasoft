package co.simasoft.models.base.mails;

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
public class Mails
{

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.TABLE)
   private long id;

   private Integer optlock;

   private String mail;

   private String observacion;

   @ManyToOne
   private Personas personas;

   @ManyToOne
   private Empresas empresas;

   public Mails()
   {
   }

   public Mails(String mail, String observacion)
   {
      this.mail = mail;
      this.observacion = observacion;
   }

   public long getId()
   {
      return this.id;
   }

   public void setId(long id)
   {
      this.id = id;
   }

   public String getMail()
   {
      return mail;
   }

   public void setMail(String mail)
   {
      this.mail = mail;
   }

   public String getObservacion()
   {
      return observacion;
   }

   public void setObservacion(String observacion)
   {
      this.observacion = observacion;
   }

   public Personas getPersonas()
   {
      return personas;
   }

   public void setPersonas(Personas personas)
   {
      this.personas = personas;
   }

   public Empresas getEmpresas()
   {
      return empresas;
   }

   public void setEmpresas(Empresas empresas)
   {
      this.empresas = empresas;
   }

} // entity

