package co.simasoft.models;

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
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import co.simasoft.models.*;
import org.hibernate.search.annotations.Resolution;
import org.hibernate.search.annotations.DateBridge;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

// @Indexed
@Entity
@XmlRootElement
public class Relationships implements Serializable {

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
	// @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String observations;

	@Column(nullable = true, unique = false)
	// @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String name;

	@Column(nullable = true, unique = false)
	private Boolean isOptionality;

	@Column(nullable = true, unique = false)
	private Boolean isCreate;

	@Column(nullable = true, unique = false)
	private Boolean isSearch;

	@Column(nullable = true, unique = false)
	private Boolean isView;

	@OneToMany(mappedBy = "relationships")
	private Set<ModelRelationships> modelRelationships = new HashSet<ModelRelationships>();

	@ManyToMany
	private Set<AttributesProperties> attributesProperties = new HashSet<AttributesProperties>();

	@ManyToOne
	private Entities from;

	@ManyToOne
	private Cardinalities cardinalities;

	@ManyToOne
	private Entities to;

	public Relationships() {
	}

	public Relationships(String name, Boolean isOptionality, Boolean isCreate,
			Boolean isSearch, Boolean isView) {
		this.name = name;
		this.isOptionality = isOptionality;
		this.isCreate = isCreate;
		this.isSearch = isSearch;
		this.isView = isView;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Boolean getIsOptionality() {
		return isOptionality;
	}
	public void setIsOptionality(Boolean isOptionality) {
		this.isOptionality = isOptionality;
	}

	public Boolean getIsCreate() {
		return isCreate;
	}
	public void setIsCreate(Boolean isCreate) {
		this.isCreate = isCreate;
	}

	public Boolean getIsSearch() {
		return isSearch;
	}
	public void setIsSearch(Boolean isSearch) {
		this.isSearch = isSearch;
	}

	public Boolean getIsView() {
		return isView;
	}
	public void setIsView(Boolean isView) {
		this.isView = isView;
	}

	public Set<ModelRelationships> getModelRelationships() {
		return modelRelationships;
	}
	public void setModelRelationships(Set<ModelRelationships> modelRelationships) {
		this.modelRelationships = modelRelationships;
	}

	public Set<AttributesProperties> getAttributesProperties() {
		return attributesProperties;
	}
	public void setAttributesProperties(
			Set<AttributesProperties> attributesProperties) {
		this.attributesProperties = attributesProperties;
	}

	public Entities getFrom() {
		return from;
	}
	public void setFrom(Entities from) {
		this.from = from;
	}

	public Cardinalities getCardinalities() {
		return cardinalities;
	}
	public void setCardinalities(Cardinalities cardinalities) {
		this.cardinalities = cardinalities;
	}

	public Entities getTo() {
		return to;
	}
	public void setTo(Entities to) {
		this.to = to;
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

		Relationships other = (Relationships) ojt;
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

