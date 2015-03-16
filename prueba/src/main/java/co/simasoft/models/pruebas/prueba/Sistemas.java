package co.simasoft.models.pruebas.prueba;

import co.simasoft.models.pruebas.prueba.*;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Sistemas
{

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.TABLE)
   private long id;

   private Integer optlock;

   private String codigo;

   private String nombre;

   private String titulo;

   private String descripcion;

   @OneToMany(mappedBy = "sistemas")
   private Set<Permisos> permisos = new HashSet<Permisos>();

   @OneToMany(mappedBy = "sistemas")
   private Set<Datos> datos = new HashSet<Datos>();

   @ManyToOne
   private Sistemas objPadre;

   @OneToMany(mappedBy = "sistemas")
   private Set<RolesSistemas> rolesSistemas = new HashSet<RolesSistemas>();

   @OneToMany(mappedBy = "sistemas")
   private Set<OpcionesSistemas> opcionesSistemas = new HashSet<OpcionesSistemas>();

   @OneToMany(mappedBy = "objPadre")
   private Set<Sistemas> objHijos = new HashSet<Sistemas>();

   @ManyToOne
   private TiposSistemas tiposSistemas;

   public Sistemas()
   {
   }

   public Sistemas(String codigo, String nombre, String titulo, String descripcion)
   {
      this.codigo = codigo;
      this.nombre = nombre;
      this.titulo = titulo;
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

   public String getTitulo()
   {
      return titulo;
   }

   public void setTitulo(String titulo)
   {
      this.titulo = titulo;
   }

   public String getDescripcion()
   {
      return descripcion;
   }

   public void setDescripcion(String descripcion)
   {
      this.descripcion = descripcion;
   }

   public Set<Permisos> getPermisos()
   {
      return permisos;
   }

   public void setPermisos(Set<Permisos> permisos)
   {
      this.permisos = permisos;
   }

   public Set<Datos> getDatos()
   {
      return datos;
   }

   public void setDatos(Set<Datos> datos)
   {
      this.datos = datos;
   }

   public Sistemas getObjPadre()
   {
      return this.objPadre;
   }

   public void setObjPadre(Sistemas objPadre)
   {
      this.objPadre = objPadre;
   }

   public Set<RolesSistemas> getRolesSistemas()
   {
      return rolesSistemas;
   }

   public void setRolesSistemas(Set<RolesSistemas> rolesSistemas)
   {
      this.rolesSistemas = rolesSistemas;
   }

   public Set<OpcionesSistemas> getOpcionesSistemas()
   {
      return opcionesSistemas;
   }

   public void setOpcionesSistemas(Set<OpcionesSistemas> opcionesSistemas)
   {
      this.opcionesSistemas = opcionesSistemas;
   }

   public Set<Sistemas> getObjHijos()
   {
      return this.objHijos;
   }

   public void setObjHijos(Set<Sistemas> objHijos)
   {
      this.objHijos = objHijos;
   }

   public TiposSistemas getTiposSistemas()
   {
      return tiposSistemas;
   }

   public void setTiposSistemas(TiposSistemas tiposSistemas)
   {
      this.tiposSistemas = tiposSistemas;
   }

} // entity

