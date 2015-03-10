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

   @OneToMany(mappedBy = "opciones")
   private Set<OpcionesSistemas> opcionesSistemas = new HashSet<OpcionesSistemas>();

   @ManyToOne
   private Opciones objPadre;

   @ManyToOne
   private Permisos permisos;

   @ManyToOne
   private TiposOpciones tiposOpciones;

   @OneToMany(mappedBy = "objPadre")
   private Set<Opciones> objHijos = new HashSet<Opciones>();

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

   public Permisos getPermisos()
   {
      return permisos;
   }

   public void setPermisos(Permisos permisos)
   {
      this.permisos = permisos;
   }

   public TiposOpciones getTiposOpciones()
   {
      return tiposOpciones;
   }

   public void setTiposOpciones(TiposOpciones tiposOpciones)
   {
      this.tiposOpciones = tiposOpciones;
   }

   public Set<Opciones> getObjHijos()
   {
      return this.objHijos;
   }

   public void setObjHijos(Set<Opciones> objHijos)
   {
      this.objHijos = objHijos;
   }

} // entity

