package co.simasoft.models.base.nits;

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
public class Ids
{

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.TABLE)
   private long id;

   private Integer optlock;

   private String numero;

   private String digitoVerificacion;

   private Date fechaExpedicion;

   private boolean siFotocopia;

   @ManyToOne
   private TiposIds tiposIds;

   @ManyToOne
   private Municipios municipios;

   @OneToMany(mappedBy = "ids")
   private Set<Nits> nits = new HashSet<Nits>();

   public Ids()
   {
   }

   public Ids(String numero, String digitoVerificacion, Date fechaExpedicion, boolean siFotocopia)
   {
      this.numero = numero;
      this.digitoVerificacion = digitoVerificacion;
      this.fechaExpedicion = fechaExpedicion;
      this.siFotocopia = siFotocopia;
   }

   public long getId()
   {
      return this.id;
   }

   public void setId(long id)
   {
      this.id = id;
   }

   public String getNumero()
   {
      return numero;
   }

   public void setNumero(String numero)
   {
      this.numero = numero;
   }

   public String getDigitoVerificacion()
   {
      return digitoVerificacion;
   }

   public void setDigitoVerificacion(String digitoVerificacion)
   {
      this.digitoVerificacion = digitoVerificacion;
   }

   public Date getFechaExpedicion()
   {
      return fechaExpedicion;
   }

   public void setFechaExpedicion(Date fechaExpedicion)
   {
      this.fechaExpedicion = fechaExpedicion;
   }

   public boolean getSiFotocopia()
   {
      return siFotocopia;
   }

   public void setSiFotocopia(boolean siFotocopia)
   {
      this.siFotocopia = siFotocopia;
   }

   public TiposIds getTiposIds()
   {
      return tiposIds;
   }

   public void setTiposIds(TiposIds tiposIds)
   {
      this.tiposIds = tiposIds;
   }

   public Municipios getMunicipios()
   {
      return municipios;
   }

   public void setMunicipios(Municipios municipios)
   {
      this.municipios = municipios;
   }

   public Set<Nits> getNits()
   {
      return nits;
   }

   public void setNits(Set<Nits> nits)
   {
      this.nits = nits;
   }

} // entity

