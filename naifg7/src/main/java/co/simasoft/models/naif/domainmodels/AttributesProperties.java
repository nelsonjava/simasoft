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

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

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

	private long orden;

	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	@Column(nullable = false, unique = true)
	private String name;

	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	@Column(nullable = true, unique = false)
	private String observations;

	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String link;

	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	@Column(nullable = false, unique = true)
	private String value;

	@ManyToMany
	private Set<Imports> imports = new HashSet<Imports>();

	@ManyToOne
	private Relationships relationships;

	@ManyToMany(mappedBy = "attributesProperties")
	private Set<Attributes> attributes = new HashSet<Attributes>();

	@ManyToMany(mappedBy = "attributesProperties")
	private Set<AttributesTypes> attributesTypes = new HashSet<AttributesTypes>();

	public AttributesProperties() {
	}

	public AttributesProperties(String name, String observations, String value) {
		this.name = name;
		this.observations = observations;
		this.value = value;
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

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}

	public String getObservations() {
		return observations;
	}
	public void setObservations(String observations) {
		this.observations = observations;
	}

	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	public Set<Imports> getImports() {
		return imports;
	}
	public void setImports(Set<Imports> imports) {
		this.imports = imports;
	}

	public Relationships getRelationships() {
		return relationships;
	}
	public void setRelationships(Relationships relationships) {
		this.relationships = relationships;
	}

	public Set<Attributes> getAttributes() {
		return attributes;
	}
	public void setAttributes(Set<Attributes> attributes) {
		this.attributes = attributes;
	}

	public Set<AttributesTypes> getAttributesTypes() {
		return attributesTypes;
	}
	public void setAttributesTypes(Set<AttributesTypes> attributesTypes) {
		this.attributesTypes = attributesTypes;
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

