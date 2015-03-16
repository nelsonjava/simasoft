package co.simasoft.models.pruebas.prueba;

import co.simasoft.models.pruebas.prueba.*;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class UsuariosEmps
{

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.TABLE)
   private long id;

   private Integer optlock;

   private boolean enabled;

   private Date ultimoIngreso;

   private String ip;

   @ManyToOne
   private Empresas empresas;

   @ManyToOne
   private Personas personas;

   @ManyToOne
   private Usuarios usuarios;

   public UsuariosEmps()
   {
   }

   public UsuariosEmps(boolean enabled, Date ultimoIngreso, String ip)
   {
      this.enabled = enabled;
      this.ultimoIngreso = ultimoIngreso;
      this.ip = ip;
   }

   public long getId()
   {
      return this.id;
   }

   public void setId(long id)
   {
      this.id = id;
   }

   public boolean getEnabled()
   {
      return enabled;
   }

   public void setEnabled(boolean enabled)
   {
      this.enabled = enabled;
   }

   public Date getUltimoIngreso()
   {
      return ultimoIngreso;
   }

   public void setUltimoIngreso(Date ultimoIngreso)
   {
      this.ultimoIngreso = ultimoIngreso;
   }

   public String getIp()
   {
      return ip;
   }

   public void setIp(String ip)
   {
      this.ip = ip;
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

   public Usuarios getUsuarios()
   {
      return usuarios;
   }

   public void setUsuarios(Usuarios usuarios)
   {
      this.usuarios = usuarios;
   }

} // entity

