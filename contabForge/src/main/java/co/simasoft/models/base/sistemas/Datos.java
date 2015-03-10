package co.simasoft.models.base.sistemas;

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
public class Datos
{

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.TABLE)
   private long id;

   private Integer optlock;

   private String xyz;

   private String abc;

   @ManyToOne
   private Empresas empresas;

   @ManyToOne
   private Personas personas;

   @ManyToOne
   private Sistemas sistemas;

   public Datos()
   {
   }

   public Datos(String xyz, String abc)
   {
      this.xyz = xyz;
      this.abc = abc;
   }

   public long getId()
   {
      return this.id;
   }

   public void setId(long id)
   {
      this.id = id;
   }

   public String getXyz()
   {
      return xyz;
   }

   public void setXyz(String xyz)
   {
      this.xyz = xyz;
   }

   public String getAbc()
   {
      return abc;
   }

   public void setAbc(String abc)
   {
      this.abc = abc;
   }

   public Empresas getEmpresas()
   {
      return empresas;
   }

   public void setEmpresas(Empresas empresas)
   {
      this.empresas = empresas;
   }

   public Personas getPersonas()
   {
      return personas;
   }

   public void setPersonas(Personas personas)
   {
      this.personas = personas;
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

