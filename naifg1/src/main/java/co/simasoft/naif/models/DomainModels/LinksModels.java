package co.simasoft.naif.models.DomainModels;

import co.simasoft.naif.models.DomainModels.*;

import java.io.*;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class LinksModels implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@Version
	private Integer optlock;

	private long orden;

	private String observacion;

	private String titulo;

	private String link;

	@ManyToOne
	private TiposLinksModels tiposLinksModels;

	@ManyToOne
	private Packages packages;

	public LinksModels() {
	}

	public LinksModels(String observacion, String titulo, String link) {
		this.observacion = observacion;
		this.titulo = titulo;
		this.link = link;
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

	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}

	public TiposLinksModels getTiposLinksModels() {
		return tiposLinksModels;
	}
	public void setTiposLinksModels(TiposLinksModels tiposLinksModels) {
		this.tiposLinksModels = tiposLinksModels;
	}

	public Packages getPackages() {
		return packages;
	}
	public void setPackages(Packages packages) {
		this.packages = packages;
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

		LinksModels other = (LinksModels) ojt;
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

