package co.simasoft.models.pruebas.prueba;

import co.simasoft.models.pruebas.prueba.*;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Opciones
{

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.TABLE)
   private long id;

   private Integer optlock;

   private String codigo;

   private String nombre;

   private String wwwUrl;

   private String descripcion;

   @OneToMany(mappedBy = "objPadre")
   private Set<Opciones> objHijos = new HashSet<Opciones>();

   @ManyToOne
   private TiposOpciones tiposOpciones;

   @ManyToOne
   private Permisos permisos;

   @OneToMany(mappedBy = "opciones")
   private Set<OpcionesSistemas> opcionesSistemas = new HashSet<OpcionesSistemas>();

   @ManyToOne
   private Opciones objPadre;

   public Opciones()
   {
   }

   public Opciones(String codigo, String nombre, String wwwUrl, String descripcion)
   {
      this.codigo = codigo;
      this.nombre = nombre;
      this.wwwUrl = wwwUrl;
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

   public String getWwwUrl()
   {
      return wwwUrl;
   }

   public void setWwwUrl(String wwwUrl)
   {
      this.wwwUrl = wwwUrl;
   }

   public String getDescripcion()
   {
      return descripcion;
   }

   public void setDescripcion(String descripcion)
   {
      this.descripcion = descripcion;
   }

   public Set<Opciones> getObjHijos()
   {
      return this.objHijos;
   }

   public void setObjHijos(Set<Opciones> objHijos)
   {
      this.objHijos = objHijos;
   }

   public TiposOpciones getTiposOpciones()
   {
      return tiposOpciones;
   }

   public void setTiposOpciones(TiposOpciones tiposOpciones)
   {
      this.tiposOpciones = tiposOpciones;
   }

   public Permisos getPermisos()
   {
      return permisos;
   }

   public void setPermisos(Permisos permisos)
   {
      this.permisos = permisos;
   }

   public Set<OpcionesSistemas> getOpcionesSistemas()
   {
      return opcionesSistemas;
   }

   public void setOpcionesSistemas(Set<OpcionesSistemas> opcionesSistemas)
   {
      this.opcionesSistemas = opcionesSistemas;
   }

   public Opciones getObjPadre()
   {
      return this.objPadre;
   }

   public void setObjPadre(Opciones objPadre)
   {
      this.objPadre = objPadre;
   }

} // entity

