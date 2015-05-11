package co.simasoft.models.naif.domainmodels;

import co.simasoft.models.naif.domainmodels.*;

import java.io.*;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class PropertiesAttributes implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@Version
	private Integer optlock;

	private long orden;

	private String value;

	private String observaciones;

	private String name;

	@ManyToMany(mappedBy = "propertiesAttributes")
	private Set<TypesAttributes> typesAttributes = new HashSet<TypesAttributes>();

	@ManyToOne
	private Relationships relationships;

	@ManyToOne
	private Imports imports;

	@ManyToOne
	private Attributes attributes;

	public PropertiesAttributes() {
	}

	public PropertiesAttributes(String value, String observaciones, String name) {
		this.value = value;
		this.observaciones = observaciones;
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

	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Set<TypesAttributes> getTypesAttributes() {
		return typesAttributes;
	}
	public void setTypesAttributes(Set<TypesAttributes> typesAttributes) {
		this.typesAttributes = typesAttributes;
	}

	public Relationships getRelationships() {
		return relationships;
	}
	public void setRelationships(Relationships relationships) {
		this.relationships = relationships;
	}

	public Imports getImports() {
		return imports;
	}
	public void setImports(Imports imports) {
		this.imports = imports;
	}

	public Attributes getAttributes() {
		return attributes;
	}
	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
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

		PropertiesAttributes other = (PropertiesAttributes) ojt;
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

