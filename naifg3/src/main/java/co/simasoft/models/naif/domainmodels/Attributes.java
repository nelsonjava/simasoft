package co.simasoft.models.naif.domainmodels;

import co.simasoft.models.naif.domainmodels.*;

import java.io.*;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Attributes implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@Version
	private Integer optlock;

	private long orden;

	private String field;

	private String descripcion;

	private String columnDefinition;

	private String access;

	private Integer precision;

	private Integer length;

	private Boolean unico;

	private Boolean nullable;

	private String name;

	private String annotationsMethod;

	private String annotationsField;

	private String observaciones;

	@OneToMany(mappedBy = "attributes")
	private Set<PropertiesAttributes> propertiesAttributes = new HashSet<PropertiesAttributes>();

	@ManyToOne
	private TypesAttributes typesAttributes;

	@ManyToOne
	private Entities entities;

	public Attributes() {
	}

	public Attributes(String field, String descripcion,
			String columnDefinition, String access, Integer precision,
			Integer length, Boolean unico, Boolean nullable, String name,
			String annotationsMethod, String annotationsField,
			String observaciones) {
		this.field = field;
		this.descripcion = descripcion;
		this.columnDefinition = columnDefinition;
		this.access = access;
		this.precision = precision;
		this.length = length;
		this.unico = unico;
		this.nullable = nullable;
		this.name = name;
		this.annotationsMethod = annotationsMethod;
		this.annotationsField = annotationsField;
		this.observaciones = observaciones;
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

	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}

	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getColumnDefinition() {
		return columnDefinition;
	}
	public void setColumnDefinition(String columnDefinition) {
		this.columnDefinition = columnDefinition;
	}

	public String getAccess() {
		return access;
	}
	public void setAccess(String access) {
		this.access = access;
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

	public Boolean getUnico() {
		return unico;
	}
	public void setUnico(Boolean unico) {
		this.unico = unico;
	}

	public Boolean getNullable() {
		return nullable;
	}
	public void setNullable(Boolean nullable) {
		this.nullable = nullable;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getAnnotationsMethod() {
		return annotationsMethod;
	}
	public void setAnnotationsMethod(String annotationsMethod) {
		this.annotationsMethod = annotationsMethod;
	}

	public String getAnnotationsField() {
		return annotationsField;
	}
	public void setAnnotationsField(String annotationsField) {
		this.annotationsField = annotationsField;
	}

	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Set<PropertiesAttributes> getPropertiesAttributes() {
		return propertiesAttributes;
	}
	public void setPropertiesAttributes(
			Set<PropertiesAttributes> propertiesAttributes) {
		this.propertiesAttributes = propertiesAttributes;
	}

	public TypesAttributes getTypesAttributes() {
		return typesAttributes;
	}
	public void setTypesAttributes(TypesAttributes typesAttributes) {
		this.typesAttributes = typesAttributes;
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

