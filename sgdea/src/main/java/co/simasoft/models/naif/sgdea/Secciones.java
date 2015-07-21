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
public class Secciones implements Serializable {

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
	private String observaciones;

	@Column(nullable = true, unique = false)
	private Integer nroTransferencias;

	@Column(nullable = true, unique = false)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String codigo;

	@Column(nullable = true, unique = false)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String nombre;

	@OneToMany(mappedBy = "objPadre")
	private Set<Secciones> objHijos = new HashSet<Secciones>();

	@ManyToMany
	private Set<Series> series = new HashSet<Series>();

	@ManyToOne
	private Secciones objPadre;

	@ManyToOne
	private Personas personas;

	@ManyToOne
	private FondosDocumentales fondosDocumentales;

	public Secciones() {
	}

	public Secciones(String observaciones, Integer nroTransferencias,
			String codigo, String nombre) {
		this.observaciones = observaciones;
		this.nroTransferencias = nroTransferencias;
		this.codigo = codigo;
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

	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Integer getNroTransferencias() {
		return nroTransferencias;
	}
	public void setNroTransferencias(Integer nroTransferencias) {
		this.nroTransferencias = nroTransferencias;
	}

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Secciones> getObjHijos() {
		return this.objHijos;
	}
	public void setObjHijos(Set<Secciones> objHijos) {
		this.objHijos = objHijos;
	}

	public Set<Series> getSeries() {
		return series;
	}
	public void setSeries(Set<Series> series) {
		this.series = series;
	}

	public Secciones getObjPadre() {
		return this.objPadre;
	}
	public void setObjPadre(Secciones objPadre) {
		this.objPadre = objPadre;
	}

	public Personas getPersonas() {
		return personas;
	}
	public void setPersonas(Personas personas) {
		this.personas = personas;
	}

	public FondosDocumentales getFondosDocumentales() {
		return fondosDocumentales;
	}
	public void setFondosDocumentales(FondosDocumentales fondosDocumentales) {
		this.fondosDocumentales = fondosDocumentales;
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

		Secciones other = (Secciones) ojt;
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

