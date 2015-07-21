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
public class Trd implements Serializable {

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
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String procedimientos;

	@OneToMany(mappedBy = "trd")
	private Set<Series> series = new HashSet<Series>();

	@ManyToOne
	private RetencionDocumental gestion;

	@ManyToOne
	private RetencionDocumental central;

	@ManyToOne
	private DisposicionFinal disposicionFinal;

	public Trd() {
	}

	public Trd(String observaciones, String procedimientos) {
		this.observaciones = observaciones;
		this.procedimientos = procedimientos;
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

	public String getProcedimientos() {
		return procedimientos;
	}
	public void setProcedimientos(String procedimientos) {
		this.procedimientos = procedimientos;
	}

	public Set<Series> getSeries() {
		return series;
	}
	public void setSeries(Set<Series> series) {
		this.series = series;
	}

	public RetencionDocumental getGestion() {
		return gestion;
	}
	public void setGestion(RetencionDocumental gestion) {
		this.gestion = gestion;
	}

	public RetencionDocumental getCentral() {
		return central;
	}
	public void setCentral(RetencionDocumental central) {
		this.central = central;
	}

	public DisposicionFinal getDisposicionFinal() {
		return disposicionFinal;
	}
	public void setDisposicionFinal(DisposicionFinal disposicionFinal) {
		this.disposicionFinal = disposicionFinal;
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

		Trd other = (Trd) ojt;
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

