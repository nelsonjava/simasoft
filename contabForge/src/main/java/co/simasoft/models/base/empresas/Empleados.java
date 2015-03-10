package co.simasoft.models.base.empresas;

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
public class Empleados
{

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.TABLE)
   private long id;

   private Integer optlock;

   private Date fechaIngreso;

   private Date fechaRetiro;

   private String descripcion;

   @ManyToOne
   private Personas personas;

   @ManyToOne
   private Empresas empresas;

   @OneToMany(mappedBy = "empleados")
   private Set<Cargos> cargos = new HashSet<Cargos>();

   public Empleados()
   {
   }

   public Empleados(Date fechaIngreso, Date fechaRetiro, String descripcion)
   {
      this.fechaIngreso = fechaIngreso;
      this.fechaRetiro = fechaRetiro;
      this.descripcion = descripcion;
   }

   public long getId()
   {
      return this.id;
   }

   public void setId(long id)
   {
      this.id = id;
   }

   public Date getFechaIngreso()
   {
      return fechaIngreso;
   }

   public void setFechaIngreso(Date fechaIngreso)
   {
      this.fechaIngreso = fechaIngreso;
   }

   public Date getFechaRetiro()
   {
      return fechaRetiro;
   }

   public void setFechaRetiro(Date fechaRetiro)
   {
      this.fechaRetiro = fechaRetiro;
   }

   public String getDescripcion()
   {
      return descripcion;
   }

   public void setDescripcion(String descripcion)
   {
      this.descripcion = descripcion;
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

   public Set<Cargos> getCargos()
   {
      return cargos;
   }

   public void setCargos(Set<Cargos> cargos)
   {
      this.cargos = cargos;
   }

} // entity

