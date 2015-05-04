package co.simasoft.models.naif.relacionesejb;

import co.simasoft.models.naif.relacionesejb.*;

import java.io.*;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Rutas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private Long id;

    @Version
    private Integer optlock;

    private long orden;

    private String origen;

    private String destino;

    private Date fechaSalida;

    private Date fechaLLegada;

    private String observaciones;

    @ManyToOne
    private Buses buses;

    @OneToMany(mappedBy = "rutas")
    private Set<Pasajes> pasajes = new HashSet<Pasajes>();

    public Rutas() {
    }

    public Rutas(String origen,String destino,Date fechaSalida,Date fechaLLegada,String observaciones) {
        this.origen = origen;
        this.destino = destino;
        this.fechaSalida = fechaSalida;
        this.fechaLLegada = fechaLLegada;
        this.observaciones = observaciones;
    }

    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOptlock() {
        return this.optlock;
    }
    public void setOptlock(Integer optlock) {
        this.optlock = optlock;
    }

    public long getOrden() {
        return this.orden;
    }
    public void setOrden(long orden) {
        this.orden = orden;
    }

    public String getOrigen() {
        return origen;
    }
    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }
    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }
    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Date getFechaLLegada() {
        return fechaLLegada;
    }
    public void setFechaLLegada(Date fechaLLegada) {
        this.fechaLLegada = fechaLLegada;
    }

    public String getObservaciones() {
        return observaciones;
    }
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Buses getBuses() {
        return buses;
    }
    public void setBuses(Buses buses) {
        this.buses = buses;
    }

    public Set<Pasajes> getPasajes() {
        return pasajes;
    }
    public void setPasajes(Set<Pasajes> pasajes) {
        this.pasajes = pasajes;
    }

   @Override
   public int hashCode() {
      final int prime  = 31;
            int result =  1;

      result = prime * result + ((id == null) ? 0 : id.hashCode());

      return result;
   }

   @Override
   public boolean equals(Object ojt) {
      if (      this == ojt           ) return true;
      if (       ojt == null          ) return false;
      if (getClass() != ojt.getClass()) return false;

      Rutas other = (Rutas) ojt;
      if (id == null) {
         if (other.id != null) {
            return false;
         }
      } else {
         if (!id.equals(other.id)) {
            return false;
         }
      }

      return true;
   }

} // entity

