package co.simasoft.models.dev.naifg.dependencies;

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

import co.simasoft.models.dev.naifg.*;
import co.simasoft.models.dev.naifg.dependencies.*;
import co.simasoft.models.dev.naifg.sites.*;
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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;

@Indexed
@Entity
public class AttributesProperties implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@DocumentId
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@Version
	private Integer optlock;

	private double orden;

	@Column(nullable = false, unique = true)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String value;

	@Column(nullable = false, unique = true)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String name;

	@ManyToMany
	private Set<Imports> imports = new HashSet<Imports>();

	@ManyToMany
	private Set<Sites> sites = new HashSet<Sites>();

	@ManyToMany(mappedBy = "attributesProperties")
	private Set<AttributesTypes> attributesTypes = new HashSet<AttributesTypes>();

	@ManyToMany(mappedBy = "attributesProperties")
	private Set<Attributes> attributes = new HashSet<Attributes>();

	@ManyToMany(mappedBy = "attributesProperties")
	private Set<Relationships> relationships = new HashSet<Relationships>();

	public AttributesProperties() {
	}

	public AttributesProperties(String value, String name) {
		this.value = value;
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

	public double getOrden() {
		return this.orden;
	}
	public void setOrden(double orden) {
		this.orden = orden;
	}

	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Set<Imports> getImports() {
		return imports;
	}
	public void setImports(Set<Imports> imports) {
		this.imports = imports;
	}

	public Set<Sites> getSites() {
		return sites;
	}
	public void setSites(Set<Sites> sites) {
		this.sites = sites;
	}

	public Set<AttributesTypes> getAttributesTypes() {
		return attributesTypes;
	}
	public void setAttributesTypes(Set<AttributesTypes> attributesTypes) {
		this.attributesTypes = attributesTypes;
	}

	public Set<Attributes> getAttributes() {
		return attributes;
	}
	public void setAttributes(Set<Attributes> attributes) {
		this.attributes = attributes;
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

		AttributesProperties other = (AttributesProperties) ojt;
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

