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

import co.simasoft.models.dev.naifg.*;
import co.simasoft.models.dev.naifg.dependencies.*;
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
import javax.persistence.ManyToOne;

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

	@Column(nullable = true, unique = false)
	private Boolean nullable;

	@Column(nullable = true, unique = false)
	private Integer precision;

	@Column(nullable = true, unique = false)
	private Integer length;

	@Column(nullable = false, unique = false)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String name;

	@Column(nullable = true, unique = false)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String field;

	@Column(nullable = true, unique = false)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String access;

	@Column(nullable = true, unique = false)
	private Boolean single;

	@Column(nullable = true, unique = false)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String descripcion;

	@Column(nullable = true, unique = false)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String annotationsMethod;

	@Column(nullable = true, unique = false)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String observations;

	@Column(nullable = true, unique = false)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String columnDefinition;

	@Column(nullable = true, unique = false)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String annotationsField;

	@ManyToMany
	private Set<AttributesProperties> attributesProperties = new HashSet<AttributesProperties>();

	@ManyToOne
	private Entities entities;

	@ManyToOne
	private AttributesTypes attributesTypes;

	public Attributes() {
	}

	public Attributes(Boolean nullable, Integer precision, Integer length,
			String name, String field, String access, Boolean single,
			String descripcion, String annotationsMethod, String observations,
			String columnDefinition, String annotationsField) {
		this.nullable = nullable;
		this.precision = precision;
		this.length = length;
		this.name = name;
		this.field = field;
		this.access = access;
		this.single = single;
		this.descripcion = descripcion;
		this.annotationsMethod = annotationsMethod;
		this.observations = observations;
		this.columnDefinition = columnDefinition;
		this.annotationsField = annotationsField;
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

	public Boolean getNullable() {
		return nullable;
	}
	public void setNullable(Boolean nullable) {
		this.nullable = nullable;
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

	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}

	public String getAccess() {
		return access;
	}
	public void setAccess(String access) {
		this.access = access;
	}

	public Boolean getSingle() {
		return single;
	}
	public void setSingle(Boolean single) {
		this.single = single;
	}

	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getAnnotationsMethod() {
		return annotationsMethod;
	}
	public void setAnnotationsMethod(String annotationsMethod) {
		this.annotationsMethod = annotationsMethod;
	}

	public String getObservations() {
		return observations;
	}
	public void setObservations(String observations) {
		this.observations = observations;
	}

	public String getColumnDefinition() {
		return columnDefinition;
	}
	public void setColumnDefinition(String columnDefinition) {
		this.columnDefinition = columnDefinition;
	}

	public String getAnnotationsField() {
		return annotationsField;
	}
	public void setAnnotationsField(String annotationsField) {
		this.annotationsField = annotationsField;
	}

	public Set<AttributesProperties> getAttributesProperties() {
		return attributesProperties;
	}
	public void setAttributesProperties(
			Set<AttributesProperties> attributesProperties) {
		this.attributesProperties = attributesProperties;
	}

	public Entities getEntities() {
		return entities;
	}
	public void setEntities(Entities entities) {
		this.entities = entities;
	}

	public AttributesTypes getAttributesTypes() {
		return attributesTypes;
	}
	public void setAttributesTypes(AttributesTypes attributesTypes) {
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

