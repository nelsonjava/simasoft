package co.simasoft.models.dev.naifg;

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
import javax.persistence.Lob;

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
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;

@Indexed
@Entity
public class Attributes implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@DocumentId
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@Version
	private Integer optlock;

	private double orden;

	@Lob
	@Column(nullable = true, unique = false)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String observations;

	@Column(nullable = true, unique = false)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String description;

	@Column(nullable = true, unique = false)
	private Boolean isSimplified;

	@Column(nullable = true, unique = false)
	private Boolean isUnique;

	@Column(nullable = true, unique = false)
	private Boolean isNullable;

	@Column(nullable = true, unique = false)
	private Integer precision;

	@Column(nullable = true, unique = false)
	private Integer length;

	@Column(nullable = false, unique = false)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String name;

	@ManyToMany
	private Set<AttributesProperties> attributesProperties = new HashSet<AttributesProperties>();

	@ManyToMany
	private Set<Sites> sites = new HashSet<Sites>();

	@ManyToOne
	private AttributesTypes attributesTypes;

	@ManyToOne
	private Entities entities;

	public Attributes() {
	}

	public Attributes(String description, Boolean isSimplified,
			Boolean isUnique, Boolean isNullable, Integer precision,
			Integer length, String name) {
		this.description = description;
		this.isSimplified = isSimplified;
		this.isUnique = isUnique;
		this.isNullable = isNullable;
		this.precision = precision;
		this.length = length;
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

	public String getObservations() {
		return observations;
	}
	public void setObservations(String observations) {
		this.observations = observations;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsSimplified() {
		return isSimplified;
	}
	public void setIsSimplified(Boolean isSimplified) {
		this.isSimplified = isSimplified;
	}

	public Boolean getIsUnique() {
		return isUnique;
	}
	public void setIsUnique(Boolean isUnique) {
		this.isUnique = isUnique;
	}

	public Boolean getIsNullable() {
		return isNullable;
	}
	public void setIsNullable(Boolean isNullable) {
		this.isNullable = isNullable;
	}

	public Integer getPrecision() {
		return precision;
	}
	public void setPrecision(Integer precision) {
		this.precision = precision;
	}

	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Set<AttributesProperties> getAttributesProperties() {
		return attributesProperties;
	}
	public void setAttributesProperties(
			Set<AttributesProperties> attributesProperties) {
		this.attributesProperties = attributesProperties;
	}

	public Set<Sites> getSites() {
		return sites;
	}
	public void setSites(Set<Sites> sites) {
		this.sites = sites;
	}

	public AttributesTypes getAttributesTypes() {
		return attributesTypes;
	}
	public void setAttributesTypes(AttributesTypes attributesTypes) {
		this.attributesTypes = attributesTypes;
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

		Attributes other = (Attributes) ojt;
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

