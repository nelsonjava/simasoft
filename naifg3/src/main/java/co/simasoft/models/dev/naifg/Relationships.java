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
import co.simasoft.models.core.sites.*;
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
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String observations;

	@Column(nullable = true, unique = false)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String name;

	@Column(nullable = true, unique = false)
	private Boolean isEmbedded;

	@Column(nullable = true, unique = false)
	private Boolean isOptionality;

	@Column(nullable = true, unique = false)
	private Boolean isCreate;

	@Column(nullable = true, unique = false)
	private Boolean isSimplified;

	@Column(nullable = true, unique = false)
	private Boolean isView;

	@Column(nullable = true, unique = false)
	private Boolean isSearch;

	@ManyToMany
	private Set<AttributesProperties> attributesProperties = new HashSet<AttributesProperties>();

	@ManyToOne
	private Cardinalities cardinalities;

	@ManyToOne
	private Entities from;

	@ManyToOne
	private Entities to;

	public Relationships() {
	}

	public Relationships(String name, Boolean isEmbedded,
			Boolean isOptionality, Boolean isCreate, Boolean isSimplified,
			Boolean isView, Boolean isSearch) {
		this.name = name;
		this.isEmbedded = isEmbedded;
		this.isOptionality = isOptionality;
		this.isCreate = isCreate;
		this.isSimplified = isSimplified;
		this.isView = isView;
		this.isSearch = isSearch;
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

	public Boolean getIsEmbedded() {
		return isEmbedded;
	}
	public void setIsEmbedded(Boolean isEmbedded) {
		this.isEmbedded = isEmbedded;
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

	public Boolean getIsSimplified() {
		return isSimplified;
	}
	public void setIsSimplified(Boolean isSimplified) {
		this.isSimplified = isSimplified;
	}

	public Boolean getIsView() {
		return isView;
	}
	public void setIsView(Boolean isView) {
		this.isView = isView;
	}

	public Boolean getIsSearch() {
		return isSearch;
	}
	public void setIsSearch(Boolean isSearch) {
		this.isSearch = isSearch;
	}

	public Set<AttributesProperties> getAttributesProperties() {
		return attributesProperties;
	}
	public void setAttributesProperties(
			Set<AttributesProperties> attributesProperties) {
		this.attributesProperties = attributesProperties;
	}

	public Cardinalities getCardinalities() {
		return cardinalities;
	}
	public void setCardinalities(Cardinalities cardinalities) {
		this.cardinalities = cardinalities;
	}

	public Entities getFrom() {
		return from;
	}
	public void setFrom(Entities from) {
		this.from = from;
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

