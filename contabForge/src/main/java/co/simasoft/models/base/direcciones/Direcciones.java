package co.simasoft.models.base.direcciones;

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
public class Direcciones
{

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.TABLE)
   private long id;

   private Integer optlock;

   private String direccionCompleta;

   private String ubicacionBase;

   private String prefijoBase;

   private String ubicacionCruce;

   private String prefijoCruce;

   private String numeroCruce;

   private double latitud;

   private double longitud;

   private String codigozip;

   private String observaciones;

   @ManyToOne
   private Direcciones objPadre;

   @ManyToOne
   private Direccioness direccioness;

   @ManyToOne
   private Localidades localidades;

   @ManyToOne
   private TiposEdificaciones tiposEdificaciones;

   @OneToMany(mappedBy = "objPadre")
   private Set<Direcciones> objHijos = new HashSet<Direcciones>();

   @OneToMany(mappedBy = "direcciones")
   private Set<Telefonos> telefonos = new HashSet<Telefonos>();

   public Direcciones()
   {
   }

   public Direcciones(String direccionCompleta, String ubicacionBase, String prefijoBase, String ubicacionCruce, String prefijoCruce, String numeroCruce, double latitud, double longitud, String codigozip, String observaciones)
   {
      this.direccionCompleta = direccionCompleta;
      this.ubicacionBase = ubicacionBase;
      this.prefijoBase = prefijoBase;
      this.ubicacionCruce = ubicacionCruce;
      this.prefijoCruce = prefijoCruce;
      this.numeroCruce = numeroCruce;
      this.latitud = latitud;
      this.longitud = longitud;
      this.codigozip = codigozip;
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

   public String getDireccionCompleta()
   {
      return direccionCompleta;
   }

   public void setDireccionCompleta(String direccionCompleta)
   {
      this.direccionCompleta = direccionCompleta;
   }

   public String getUbicacionBase()
   {
      return ubicacionBase;
   }

   public void setUbicacionBase(String ubicacionBase)
   {
      this.ubicacionBase = ubicacionBase;
   }

   public String getPrefijoBase()
   {
      return prefijoBase;
   }

   public void setPrefijoBase(String prefijoBase)
   {
      this.prefijoBase = prefijoBase;
   }

   public String getUbicacionCruce()
   {
      return ubicacionCruce;
   }

   public void setUbicacionCruce(String ubicacionCruce)
   {
      this.ubicacionCruce = ubicacionCruce;
   }

   public String getPrefijoCruce()
   {
      return prefijoCruce;
   }

   public void setPrefijoCruce(String prefijoCruce)
   {
      this.prefijoCruce = prefijoCruce;
   }

   public String getNumeroCruce()
   {
      return numeroCruce;
   }

   public void setNumeroCruce(String numeroCruce)
   {
      this.numeroCruce = numeroCruce;
   }

   public double getLatitud()
   {
      return latitud;
   }

   public void setLatitud(double latitud)
   {
      this.latitud = latitud;
   }

   public double getLongitud()
   {
      return longitud;
   }

   public void setLongitud(double longitud)
   {
      this.longitud = longitud;
   }

   public String getCodigozip()
   {
      return codigozip;
   }

   public void setCodigozip(String codigozip)
   {
      this.codigozip = codigozip;
   }

   public String getObservaciones()
   {
      return observaciones;
   }

   public void setObservaciones(String observaciones)
   {
      this.observaciones = observaciones;
   }

   public Direcciones getObjPadre()
   {
      return this.objPadre;
   }

   public void setObjPadre(Direcciones objPadre)
   {
      this.objPadre = objPadre;
   }

   public Direccioness getDireccioness()
   {
      return direccioness;
   }

   public void setDireccioness(Direccioness direccioness)
   {
      this.direccioness = direccioness;
   }

   public Localidades getLocalidades()
   {
      return localidades;
   }

   public void setLocalidades(Localidades localidades)
   {
      this.localidades = localidades;
   }

   public TiposEdificaciones getTiposEdificaciones()
   {
      return tiposEdificaciones;
   }

   public void setTiposEdificaciones(TiposEdificaciones tiposEdificaciones)
   {
      this.tiposEdificaciones = tiposEdificaciones;
   }

   public Set<Direcciones> getObjHijos()
   {
      return this.objHijos;
   }

   public void setObjHijos(Set<Direcciones> objHijos)
   {
      this.objHijos = objHijos;
   }

   public Set<Telefonos> getTelefonos()
   {
      return telefonos;
   }

   public void setTelefonos(Set<Telefonos> telefonos)
   {
      this.telefonos = telefonos;
   }

} // entity

