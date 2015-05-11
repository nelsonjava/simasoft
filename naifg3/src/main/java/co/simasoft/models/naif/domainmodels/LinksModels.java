package co.simasoft.models.naif.domainmodels;

import co.simasoft.models.naif.domainmodels.*;

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

	private String observaciones;

	private String link;

	private String titulo;

	@ManyToOne
	private TiposLinksModels tiposLinksModels;

	@ManyToOne
	private GroupIds groupIds;

	public LinksModels() {
	}

	public LinksModels(String observaciones, String link, String titulo) {
		this.observaciones = observaciones;
		this.link = link;
		this.titulo = titulo;
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

	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public TiposLinksModels getTiposLinksModels() {
		return tiposLinksModels;
	}
	public void setTiposLinksModels(TiposLinksModels tiposLinksModels) {
		this.tiposLinksModels = tiposLinksModels;
	}

	public GroupIds getGroupIds() {
		return groupIds;
	}
	public void setGroupIds(GroupIds groupIds) {
		this.groupIds = groupIds;
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

