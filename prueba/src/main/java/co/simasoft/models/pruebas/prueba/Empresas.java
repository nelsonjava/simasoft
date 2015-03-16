package co.simasoft.models.pruebas.prueba;

import co.simasoft.models.pruebas.prueba.*;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Empresas
{

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.TABLE)
   private long id;

   private Integer optlock;

   private String nombre;

   private String nombreSecundario;

   private String titulo;

   private String eslogan;

   private String vision;

   private String mision;

   private String politicaCalidad;

   private String objetivosCalidad;

   @OneToMany(mappedBy = "empresas")
   private Set<UsuariosEmps> usuariosEmps = new HashSet<UsuariosEmps>();

   @OneToMany(mappedBy = "empresas")
   private Set<Datos> datos = new HashSet<Datos>();

   public Empresas()
   {
   }

   public Empresas(String nombre, String nombreSecundario, String titulo, String eslogan, String vision, String mision, String politicaCalidad, String objetivosCalidad)
   {
      this.nombre = nombre;
      this.nombreSecundario = nombreSecundario;
      this.titulo = titulo;
      this.eslogan = eslogan;
      this.vision = vision;
      this.mision = mision;
      this.politicaCalidad = politicaCalidad;
      this.objetivosCalidad = objetivosCalidad;
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

   public String getNombreSecundario()
   {
      return nombreSecundario;
   }

   public void setNombreSecundario(String nombreSecundario)
   {
      this.nombreSecundario = nombreSecundario;
   }

   public String getTitulo()
   {
      return titulo;
   }

   public void setTitulo(String titulo)
   {
      this.titulo = titulo;
   }

   public String getEslogan()
   {
      return eslogan;
   }

   public void setEslogan(String eslogan)
   {
      this.eslogan = eslogan;
   }

   public String getVision()
   {
      return vision;
   }

   public void setVision(String vision)
   {
      this.vision = vision;
   }

   public String getMision()
   {
      return mision;
   }

   public void setMision(String mision)
   {
      this.mision = mision;
   }

   public String getPoliticaCalidad()
   {
      return politicaCalidad;
   }

   public void setPoliticaCalidad(String politicaCalidad)
   {
      this.politicaCalidad = politicaCalidad;
   }

   public String getObjetivosCalidad()
   {
      return objetivosCalidad;
   }

   public void setObjetivosCalidad(String objetivosCalidad)
   {
      this.objetivosCalidad = objetivosCalidad;
   }

   public Set<UsuariosEmps> getUsuariosEmps()
   {
      return usuariosEmps;
   }

   public void setUsuariosEmps(Set<UsuariosEmps> usuariosEmps)
   {
      this.usuariosEmps = usuariosEmps;
   }

   public Set<Datos> getDatos()
   {
      return datos;
   }

   public void setDatos(Set<Datos> datos)
   {
      this.datos = datos;
   }

} // entity

