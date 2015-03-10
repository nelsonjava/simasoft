package co.simasoft.models.iso.lmr;

import co.simasoft.models.iso.lmd.*;
import co.simasoft.models.iso.lmr.*;
import co.simasoft.models.iso.procesos.*;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class TiposRegistros
{

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.TABLE)
   private long id;

   private Integer optlock;

   private String codigo;

   private String nombre;

   @OneToMany(mappedBy = "tiposRegistros")
   private Set<Lmrs> lmrs = new HashSet<Lmrs>();

   public TiposRegistros()
   {
   }

   public TiposRegistros(String codigo, String nombre)
   {
      this.codigo = codigo;
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

   public String getCodigo()
   {
      return codigo;
   }

   public void setCodigo(String codigo)
   {
      this.codigo = codigo;
   }

   public String getNombre()
   {
      return nombre;
   }

   public void setNombre(String nombre)
   {
      this.nombre = nombre;
   }

   public Set<Lmrs> getLmrs()
   {
      return lmrs;
   }

   public void setLmrs(Set<Lmrs> lmrs)
   {
      this.lmrs = lmrs;
   }

} // entity

