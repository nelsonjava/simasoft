package co.simasoft.naif.models.DomainModels;

import co.simasoft.naif.models.DomainModels.*;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Cardinalities {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long id;

	private Integer optlock;

	private String name;

	private String cardinality;

	private Boolean unidireccional;

	private String observaciones;

	public Cardinalities() {
	}

	public Cardinalities(String name, String cardinality,
			Boolean unidireccional, String observaciones) {
		this.name = name;
		this.cardinality = cardinality;
		this.unidireccional = unidireccional;
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

	public String getCardinality() {
		return cardinality;
	}
	public void setCardinality(String cardinality) {
		this.cardinality = cardinality;
	}

	public Boolean getUnidireccional() {
		return unidireccional;
	}
	public void setUnidireccional(Boolean unidireccional) {
		this.unidireccional = unidireccional;
	}

	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

} // entity

