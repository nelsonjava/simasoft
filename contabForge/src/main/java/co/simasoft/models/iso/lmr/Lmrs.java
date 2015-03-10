package co.simasoft.models.iso.lmr;

import co.simasoft.models.iso.lmd.*;
import co.simasoft.models.iso.lmr.*;
import co.simasoft.models.iso.procesos.*;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Lmrs
{

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.TABLE)
   private long id;

   private Integer optlock;

   private String codigo;

   private String nombre;

   private String version;

   private Date fecha;

   private String estado;

   private String ubicacion;

   private String link;

   private String ordenar;

   private String observaciones;

   @ManyToOne
   private Estados estados;

   @ManyToOne
   private DisposicionFinal disposicionFinal;

   @ManyToOne
   private Responsables responsables;

   @ManyToOne
   private Instituciones instituciones;

   @ManyToOne
   private TiposAccesos tiposAccesos;

   @ManyToOne
   private TrdArchivos trdArchivos;

   @ManyToOne
   private Indexaciones indexaciones;

   @ManyToOne
   private TiposLmrs tiposLmrs;

   @ManyToOne
   private Dependencias dependencias;

   @ManyToOne
   private Medios medios;

   @ManyToOne
   private TiposRegistros tiposRegistros;

   @ManyToOne
   private TrdAreas trdAreas;

   @ManyToOne
   private Procesos procesos;

   public Lmrs()
   {
   }

   public Lmrs(String codigo, String nombre, String version, Date fecha, String estado, String ubicacion, String link, String ordenar, String observaciones)
   {
      this.codigo = codigo;
      this.nombre = nombre;
      this.version = version;
      this.fecha = fecha;
      this.estado = estado;
      this.ubicacion = ubicacion;
      this.link = link;
      this.ordenar = ordenar;
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

   public String getVersion()
   {
      return version;
   }

   public void setVersion(String version)
   {
      this.version = version;
   }

   public Date getFecha()
   {
      return fecha;
   }

   public void setFecha(Date fecha)
   {
      this.fecha = fecha;
   }

   public String getEstado()
   {
      return estado;
   }

   public void setEstado(String estado)
   {
      this.estado = estado;
   }

   public String getUbicacion()
   {
      return ubicacion;
   }

   public void setUbicacion(String ubicacion)
   {
      this.ubicacion = ubicacion;
   }

   public String getLink()
   {
      return link;
   }

   public void setLink(String link)
   {
      this.link = link;
   }

   public String getOrdenar()
   {
      return ordenar;
   }

   public void setOrdenar(String ordenar)
   {
      this.ordenar = ordenar;
   }

   public String getObservaciones()
   {
      return observaciones;
   }

   public void setObservaciones(String observaciones)
   {
      this.observaciones = observaciones;
   }

   public Estados getEstados()
   {
      return estados;
   }

   public void setEstados(Estados estados)
   {
      this.estados = estados;
   }

   public DisposicionFinal getDisposicionFinal()
   {
      return disposicionFinal;
   }

   public void setDisposicionFinal(DisposicionFinal disposicionFinal)
   {
      this.disposicionFinal = disposicionFinal;
   }

   public Responsables getResponsables()
   {
      return responsables;
   }

   public void setResponsables(Responsables responsables)
   {
      this.responsables = responsables;
   }

   public Instituciones getInstituciones()
   {
      return instituciones;
   }

   public void setInstituciones(Instituciones instituciones)
   {
      this.instituciones = instituciones;
   }

   public TiposAccesos getTiposAccesos()
   {
      return tiposAccesos;
   }

   public void setTiposAccesos(TiposAccesos tiposAccesos)
   {
      this.tiposAccesos = tiposAccesos;
   }

   public TrdArchivos getTrdArchivos()
   {
      return trdArchivos;
   }

   public void setTrdArchivos(TrdArchivos trdArchivos)
   {
      this.trdArchivos = trdArchivos;
   }

   public Indexaciones getIndexaciones()
   {
      return indexaciones;
   }

   public void setIndexaciones(Indexaciones indexaciones)
   {
      this.indexaciones = indexaciones;
   }

   public TiposLmrs getTiposLmrs()
   {
      return tiposLmrs;
   }

   public void setTiposLmrs(TiposLmrs tiposLmrs)
   {
      this.tiposLmrs = tiposLmrs;
   }

   public Dependencias getDependencias()
   {
      return dependencias;
   }

   public void setDependencias(Dependencias dependencias)
   {
      this.dependencias = dependencias;
   }

   public Medios getMedios()
   {
      return medios;
   }

   public void setMedios(Medios medios)
   {
      this.medios = medios;
   }

   public TiposRegistros getTiposRegistros()
   {
      return tiposRegistros;
   }

   public void setTiposRegistros(TiposRegistros tiposRegistros)
   {
      this.tiposRegistros = tiposRegistros;
   }

   public TrdAreas getTrdAreas()
   {
      return trdAreas;
   }

   public void setTrdAreas(TrdAreas trdAreas)
   {
      this.trdAreas = trdAreas;
   }

   public Procesos getProcesos()
   {
      return procesos;
   }

   public void setProcesos(Procesos procesos)
   {
      this.procesos = procesos;
   }

} // entity

