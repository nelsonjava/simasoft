package co.simasoft.models.naif.sgdea;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.FetchType;

import javax.persistence.Column;

import co.simasoft.models.naif.sgdea.*;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Store;
import org.hibernate.search.annotations.Indexed;
import javax.persistence.TemporalType;
import javax.persistence.Temporal;
import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.Resolution;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;

@Indexed
@Entity
public class UnidadesDocumentales implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@DocumentId
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@Version
	private Integer optlock;

	private double orden;

	@Column(nullable = true, unique = false)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String nombre;

	@OneToMany(mappedBy = "unidadesDocumentales")
	private Set<InventarioDocumental> inventarioDocumental = new HashSet<InventarioDocumental>();

	@ManyToMany
	private Set<SoporteDocumental> soporteDocumental = new HashSet<SoporteDocumental>();

	@OneToMany(mappedBy = "unidadesDocumentales")
	private Set<Series> series = new HashSet<Series>();

	@ManyToOne
	private UnidadesConservacion unidadesConservacion;

	@ManyToOne
	private FrecuenciasConsulta frecuenciasConsulta;

	public UnidadesDocumentales() {
	}

	public UnidadesDocumentales(String nombre) {
		this.nombre = nombre;
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

	public double getOrden() {
		return this.orden;
	}
	public void setOrden(double orden) {
		this.orden = orden;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<InventarioDocumental> getInventarioDocumental() {
		return inventarioDocumental;
	}
	public void setInventarioDocumental(
			Set<InventarioDocumental> inventarioDocumental) {
		this.inventarioDocumental = inventarioDocumental;
	}

	public Set<SoporteDocumental> getSoporteDocumental() {
		return soporteDocumental;
	}
	public void setSoporteDocumental(Set<SoporteDocumental> soporteDocumental) {
		this.soporteDocumental = soporteDocumental;
	}

	public Set<Series> getSeries() {
		return series;
	}
	public void setSeries(Set<Series> series) {
		this.series = series;
	}

	public UnidadesConservacion getUnidadesConservacion() {
		return unidadesConservacion;
	}
	public void setUnidadesConservacion(
			UnidadesConservacion unidadesConservacion) {
		this.unidadesConservacion = unidadesConservacion;
	}

	public FrecuenciasConsulta getFrecuenciasConsulta() {
		return frecuenciasConsulta;
	}
	public void setFrecuenciasConsulta(FrecuenciasConsulta frecuenciasConsulta) {
		this.frecuenciasConsulta = frecuenciasConsulta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		result = prime * result + ((id == null) ? 0 : id.hashCode());

		return result;
	}

	@Override
	public boolean equals(Object ojt) {
		if (this == ojt)
			return true;
		if (ojt == null)
			return false;
		if (getClass() != ojt.getClass())
			return false;

		UnidadesDocumentales other = (UnidadesDocumentales) ojt;
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

