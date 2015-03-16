package co.simasoft.models.pruebas.prueba;

import co.simasoft.models.pruebas.prueba.*;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class TiposSistemas
{

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.TABLE)
   private long id;

   private Integer optlock;

   private String nombre;

   @OneToMany(mappedBy = "tiposSistemas")
   private Set<Sistemas> sistemas = new HashSet<Sistemas>();

   public TiposSistemas()
   {
   }

   public TiposSistemas(String nombre)
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

   public Set<Sistemas> getSistemas()
   {
      return sistemas;
   }

   public void setSistemas(Set<Sistemas> sistemas)
   {
      this.sistemas = sistemas;
   }

} // entity
