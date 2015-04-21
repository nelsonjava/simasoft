package co.simasoft.naif.models.DomainModels;

import co.simasoft.naif.models.DomainModels.*;

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

	private String annotationsField;

	private String observaciones;

	private String field;

	private String descripcion;

	private String columnDefinition;

	private String name;

	private String annotationsMethod;

	private Integer length;

	private String access;

	private Boolean unico;

	private String type;

	private Boolean nullable;

	private Integer precision;

	@OneToMany(mappedBy = "attributes")
	private Set<PropertiesAttributes> propertiesAttributes = new HashSet<PropertiesAttributes>();

	@ManyToOne
	private Entities entities;

	@ManyToOne
	private TypesAttributes typesAttributes;

	public Attributes() {
	}

	public Attributes(String annotationsField, String observaciones,
			String field, String descripcion, String columnDefinition,
			String name, String annotationsMethod, Integer length,
			String access, Boolean unico, String type, Boolean nullable,
			Integer precision) {
		this.annotationsField = annotationsField;
		this.observaciones = observaciones;
		this.field = field;
		this.descripcion = descripcion;
		this.columnDefinition = columnDefinition;
		this.name = name;
		this.annotationsMethod = annotationsMethod;
		this.length = length;
		this.access = access;
		this.unico = unico;
		this.type = type;
		this.nullable = nullable;
		this.precision = precision;
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

	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}

	public String getAccess() {
		return access;
	}
	public void setAccess(String access) {
		this.access = access;
	}

	public Boolean getUnico() {
		return unico;
	}
	public void setUnico(Boolean unico) {
		this.unico = unico;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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

	public Set<PropertiesAttributes> getPropertiesAttributes() {
		return propertiesAttributes;
	}
	public void setPropertiesAttributes(
			Set<PropertiesAttributes> propertiesAttributes) {
		this.propertiesAttributes = propertiesAttributes;
	}

	public Entities getEntities() {
		return entities;
	}
	public void setEntities(Entities entities) {
		this.entities = entities;
	}

	public TypesAttributes getTypesAttributes() {
		return typesAttributes;
	}
	public void setTypesAttributes(TypesAttributes typesAttributes) {
		this.typesAttributes = typesAttributes;
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

