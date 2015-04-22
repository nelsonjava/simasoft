package co.simasoft.models.naif.DomainModels;

import co.simasoft.models.naif.DomainModels.*;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class NameQueries {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long id;

	private Integer optlock;

	private String name;

	private String query;

	private String observaciones;

	@ManyToOne
	private Entities entities;

	public NameQueries() {
	}

	public NameQueries(String name, String query, String observaciones) {
		this.name = name;
		this.query = query;
		this.observaciones = observaciones;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Entities getEntities() {
		return entities;
	}

	public void setEntities(Entities entities) {
		this.entities = entities;
	}

} // entity

