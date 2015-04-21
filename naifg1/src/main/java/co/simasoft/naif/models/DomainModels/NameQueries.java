package co.simasoft.naif.models.DomainModels;

import co.simasoft.naif.models.DomainModels.*;

import java.io.*;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class NameQueries implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@Version
	private Integer optlock;

	private long orden;

	private String observaciones;

	private String query;

	private String name;

	@ManyToOne
	private Entities entities;

	public NameQueries() {
	}

	public NameQueries(String observaciones, String query, String name) {
		this.observaciones = observaciones;
		this.query = query;
		this.name = name;
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

	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Entities getEntities() {
		return entities;
	}
	public void setEntities(Entities entities) {
		this.entities = entities;
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

		NameQueries other = (NameQueries) ojt;
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

