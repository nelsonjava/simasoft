package co.simasoft.models.naif.domainmodels;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.FetchType;

import co.simasoft.models.naif.domainmodels.*;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Cardinalities implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@Version
	private Integer optlock;

	private long orden;

	@Column(nullable = true, unique = false)
	private String annotations;

	@Column(nullable = false, unique = false)
	private String cardinality;

	@Column(nullable = true, unique = false)
	private Boolean unidirectional;

	@Column(nullable = false, unique = true)
	private String name;

	@Column(nullable = true, unique = false)
	private String observations;

	@ManyToMany
	private Set<Imports> imports = new HashSet<Imports>();

	@OneToMany(mappedBy = "cardinalities")
	private Set<Relationships> relationships = new HashSet<Relationships>();

	public Cardinalities() {
	}

	public Cardinalities(String annotations, String cardinality,
			Boolean unidirectional, String name, String observations) {
		this.annotations = annotations;
		this.cardinality = cardinality;
		this.unidirectional = unidirectional;
		this.name = name;
		this.observations = observations;
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

	public Boolean getUnidirectional() {
		return unidirectional;
	}
	public void setUnidirectional(Boolean unidirectional) {
		this.unidirectional = unidirectional;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getObservations() {
		return observations;
	}
	public void setObservations(String observations) {
		this.observations = observations;
	}

	public Set<Imports> getImports() {
		return imports;
	}
	public void setImports(Set<Imports> imports) {
		this.imports = imports;
	}

	public Set<Relationships> getRelationships() {
		return relationships;
	}
	public void setRelationships(Set<Relationships> relationships) {
		this.relationships = relationships;
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

