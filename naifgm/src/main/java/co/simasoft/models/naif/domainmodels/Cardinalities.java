package co.simasoft.models.naif.domainmodels;

import co.simasoft.models.naif.domainmodels.*;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Lob;

import java.io.*;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Cardinalities implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

	@Version
	private Integer optlock;

	private long orden;

	private String annotations;

	private String cardinality;

	private Boolean unidireccional;

	private String name;

	private String observaciones;

	@OneToMany(mappedBy = "cardinalities")
	private Set<Relationships> relationships = new HashSet<Relationships>();

	@ManyToMany
	private Set<Imports> imports = new HashSet<Imports>();

	public Cardinalities() {
	}

	public Cardinalities(String annotations, String cardinality,
			Boolean unidireccional, String name, String observaciones) {
		this.annotations = annotations;
		this.cardinality = cardinality;
		this.unidireccional = unidireccional;
		this.name = name;
		this.observaciones = observaciones;
	}

	public String getId() {
		return this.id;
	}
	public void setId(String id) {
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

	public String getAnnotations() {
		return annotations;
	}
	public void setAnnotations(String annotations) {
		this.annotations = annotations;
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

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Set<Relationships> getRelationships() {
		return relationships;
	}
	public void setRelationships(Set<Relationships> relationships) {
		this.relationships = relationships;
	}

	public Set<Imports> getImports() {
		return imports;
	}
	public void setImports(Set<Imports> imports) {
		this.imports = imports;
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

		Cardinalities other = (Cardinalities) ojt;
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

