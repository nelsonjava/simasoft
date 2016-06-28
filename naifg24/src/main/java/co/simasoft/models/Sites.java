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

import co.simasoft.models.*;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.Resolution;

// @Indexed
@Entity
@XmlRootElement
public class Sites implements Serializable {

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
	private String abc;

	@Column(nullable = false, unique = true)
	// @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String link;

	@Column(nullable = true, unique = false)
	// @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String title;

	@OneToMany(mappedBy = "sites")
	private Set<SitesTypes> sitesTypes = new HashSet<SitesTypes>();

	@ManyToMany
	private Set<AttributesTypes> attributesTypes = new HashSet<AttributesTypes>();

	@ManyToMany
	private Set<Imports> imports = new HashSet<Imports>();

	@ManyToMany
	private Set<Dependencies> dependencies = new HashSet<Dependencies>();

	@ManyToMany
	private Set<AttributesProperties> attributesProperties = new HashSet<AttributesProperties>();

	@OneToMany(mappedBy = "sites")
	private Set<Models> models = new HashSet<Models>();

	@ManyToMany
	private Set<Developments> developments = new HashSet<Developments>();

	@ManyToMany
	private Set<Entities> entities = new HashSet<Entities>();

	@ManyToMany
	private Set<Attributes> attributes = new HashSet<Attributes>();

	@ManyToMany
	private Set<Cardinalities> cardinalities = new HashSet<Cardinalities>();

	public Sites() {
	}

	public Sites(String abc, String link, String title) {
		this.abc = abc;
		this.link = link;
		this.title = title;
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
	public String getAbc() {
		return abc;
	}
	public void setAbc(String abc) {
		this.abc = abc;
	}

	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public Set<SitesTypes> getSitesTypes() {
		return sitesTypes;
	}
	public void setSitesTypes(Set<SitesTypes> sitesTypes) {
		this.sitesTypes = sitesTypes;
	}

	public Set<AttributesTypes> getAttributesTypes() {
		return attributesTypes;
	}
	public void setAttributesTypes(Set<AttributesTypes> attributesTypes) {
		this.attributesTypes = attributesTypes;
	}

	public Set<Imports> getImports() {
		return imports;
	}
	public void setImports(Set<Imports> imports) {
		this.imports = imports;
	}

	public Set<Dependencies> getDependencies() {
		return dependencies;
	}
	public void setDependencies(Set<Dependencies> dependencies) {
		this.dependencies = dependencies;
	}

	public Set<AttributesProperties> getAttributesProperties() {
		return attributesProperties;
	}
	public void setAttributesProperties(
			Set<AttributesProperties> attributesProperties) {
		this.attributesProperties = attributesProperties;
	}

	public Set<Models> getModels() {
		return models;
	}
	public void setModels(Set<Models> models) {
		this.models = models;
	}

	public Set<Developments> getDevelopments() {
		return developments;
	}
	public void setDevelopments(Set<Developments> developments) {
		this.developments = developments;
	}

	public Set<Entities> getEntities() {
		return entities;
	}
	public void setEntities(Set<Entities> entities) {
		this.entities = entities;
	}

	public Set<Attributes> getAttributes() {
		return attributes;
	}
	public void setAttributes(Set<Attributes> attributes) {
		this.attributes = attributes;
	}

	public Set<Cardinalities> getCardinalities() {
		return cardinalities;
	}
	public void setCardinalities(Set<Cardinalities> cardinalities) {
		this.cardinalities = cardinalities;
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

		Sites other = (Sites) ojt;
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

