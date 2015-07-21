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
public class Series implements Serializable {

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

	@Column(nullable = true, unique = false)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String codigo;

	@Column(nullable = true, unique = false)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String observaciones;

	@OneToMany(mappedBy = "objPadre")
	private Set<Series> objHijos = new HashSet<Series>();

	@ManyToOne
	private Series objPadre;

	@ManyToMany(mappedBy = "series")
	private Set<Secciones> secciones = new HashSet<Secciones>();

	@ManyToOne
	private UnidadesDocumentales unidadesDocumentales;

	@ManyToMany(mappedBy = "series")
	private Set<TiposDocumentales> tiposDocumentales = new HashSet<TiposDocumentales>();

	@ManyToOne
	private Trd trd;

	public Series() {
	}

	public Series(String nombre, String codigo, String observaciones) {
		this.nombre = nombre;
		this.codigo = codigo;
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

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Set<Series> getObjHijos() {
		return this.objHijos;
	}
	public void setObjHijos(Set<Series> objHijos) {
		this.objHijos = objHijos;
	}

	public Series getObjPadre() {
		return this.objPadre;
	}
	public void setObjPadre(Series objPadre) {
		this.objPadre = objPadre;
	}

	public Set<Secciones> getSecciones() {
		return secciones;
	}
	public void setSecciones(Set<Secciones> secciones) {
		this.secciones = secciones;
	}

	public UnidadesDocumentales getUnidadesDocumentales() {
		return unidadesDocumentales;
	}
	public void setUnidadesDocumentales(
			UnidadesDocumentales unidadesDocumentales) {
		this.unidadesDocumentales = unidadesDocumentales;
	}

	public Set<TiposDocumentales> getTiposDocumentales() {
		return tiposDocumentales;
	}
	public void setTiposDocumentales(Set<TiposDocumentales> tiposDocumentales) {
		this.tiposDocumentales = tiposDocumentales;
	}

	public Trd getTrd() {
		return trd;
	}
	public void setTrd(Trd trd) {
		this.trd = trd;
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

		Series other = (Series) ojt;
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

