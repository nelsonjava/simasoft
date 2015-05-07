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

	private String access;

	private String field;

	private String annotationsField;

	private String columnDefinition;

	private Boolean nullable;

	private Integer precision;

	private String descripcion;

	private Boolean unico;

	private String name;

	private Integer length;

	private String observaciones;

	private String annotationsMethod;

	@OneToMany(mappedBy = "attributes")
	private Set<PropertiesAttributes> propertiesAttributes = new HashSet<PropertiesAttributes>();

	@ManyToOne
	private TypesAttributes typesAttributes;

	@ManyToOne
	private Entities entities;

	public Attributes() {
	}

	public Attributes(String access, String field, String annotationsField,
			String columnDefinition, Boolean nullable, Integer precision,
			String descripcion, Boolean unico, String name, Integer length,
			String observaciones, String annotationsMethod) {
		this.access = access;
		this.field = field;
		this.annotationsField = annotationsField;
		this.columnDefinition = columnDefinition;
		this.nullable = nullable;
		this.precision = precision;
		this.descripcion = descripcion;
		this.unico = unico;
		this.name = name;
		this.length = length;
		this.observaciones = observaciones;
		this.annotationsMethod = annotationsMethod;
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

	public String getAccess() {
		return access;
	}
	public void setAccess(String access) {
		this.access = access;
	}

	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}

	public String getAnnotationsField() {
		return annotationsField;
	}
	public void setAnnotationsField(String annotationsField) {
		this.annotationsField = annotationsField;
	}

	public String getColumnDefinition() {
		return columnDefinition;
	}
	public void setColumnDefinition(String columnDefinition) {
		this.columnDefinition = columnDefinition;
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

	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getUnico() {
		return unico;
	}
	public void setUnico(Boolean unico) {
		this.unico = unico;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}

	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getAnnotationsMethod() {
		return annotationsMethod;
	}
	public void setAnnotationsMethod(String annotationsMethod) {
		this.annotationsMethod = annotationsMethod;
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

