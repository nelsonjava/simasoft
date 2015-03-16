package co.simasoft.models.pruebas.prueba;

import co.simasoft.models.pruebas.prueba.*;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class OpcionesSistemas
{

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.TABLE)
   private long id;

   private Integer optlock;

   private boolean siPrincipal;

   @ManyToOne
   private Sistemas sistemas;

   @ManyToOne
   private Opciones opciones;

   public OpcionesSistemas()
   {
   }

   public OpcionesSistemas(boolean siPrincipal)
   {
      this.siPrincipal = siPrincipal;
   }

   public long getId()
   {
      return this.id;
   }

   public void setId(long id)
   {
      this.id = id;
   }

   public boolean getSiPrincipal()
   {
      return siPrincipal;
   }

   public void setSiPrincipal(boolean siPrincipal)
   {
      this.siPrincipal = siPrincipal;
   }

   public Sistemas getSistemas()
   {
      return sistemas;
   }

   public void setSistemas(Sistemas sistemas)
   {
      this.sistemas = sistemas;
   }

   public Opciones getOpciones()
   {
      return opciones;
   }

   public void setOpciones(Opciones opciones)
   {
      this.opciones = opciones;
   }

} // entity

