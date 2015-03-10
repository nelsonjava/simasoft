package co.simasoft.models.iso.procesos;

import co.simasoft.models.iso.lmd.*;
import co.simasoft.models.iso.lmr.*;
import co.simasoft.models.iso.procesos.*;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Procesos
{

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.TABLE)
   private long id;

   private Integer optlock;

   private String codigo;

   private String nombre;

   private String observaciones;

   @ManyToOne
   private TiposProcesos tiposProcesos;

   @OneToMany(mappedBy = "procesos")
   private Set<Lmds> lmds = new HashSet<Lmds>();

   @OneToMany(mappedBy = "procesos")
   private Set<Lmrs> lmrs = new HashSet<Lmrs>();

   public Procesos()
   {
   }

   public Procesos(String codigo, String nombre, String observaciones)
   {
      this.codigo = codigo;
      this.nombre = nombre;
      this.observaciones = observaciones;
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

   public String getObservaciones()
   {
      return observaciones;
   }

   public void setObservaciones(String observaciones)
   {
      this.observaciones = observaciones;
   }

   public TiposProcesos getTiposProcesos()
   {
      return tiposProcesos;
   }

   public void setTiposProcesos(TiposProcesos tiposProcesos)
   {
      this.tiposProcesos = tiposProcesos;
   }

   public Set<Lmds> getLmds()
   {
      return lmds;
   }

   public void setLmds(Set<Lmds> lmds)
   {
      this.lmds = lmds;
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

