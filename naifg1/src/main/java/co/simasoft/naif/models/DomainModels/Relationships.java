package co.simasoft.naif.models.DomainModels;

import co.simasoft.naif.models.DomainModels.*;

import java.io.*;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Relationships implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@Version
	private Integer optlock;

	private long orden;

	private String mappedby;

	private String idTabla1;

	private Boolean optionality;

	private String entity;

	private String description;

	private String tabla;

	private String annotationsField;

	private String name;

	private String idTabla2;

	private String annotationsMethod;

	private String observaciones;

	@OneToMany(mappedBy = "relationships")
	private Set<PropertiesAttributes> propertiesAttributes = new HashSet<PropertiesAttributes>();

	@ManyToOne
	private Entities to;

	@ManyToOne
	private Entities from;

	@ManyToOne
	private Cardinalities cardinalities;

	public Relationships() {
	}

	public Relationships(String mappedby, String idTabla1, Boolean optionality,
			String entity, String description, String tabla,
			String annotationsField, String name, String idTabla2,
			String annotationsMethod, String observaciones) {
		this.mappedby = mappedby;
		this.idTabla1 = idTabla1;
		this.optionality = optionality;
		this.entity = entity;
		this.description = description;
		this.tabla = tabla;
		this.annotationsField = annotationsField;
		this.name = name;
		this.idTabla2 = idTabla2;
		this.annotationsMethod = annotationsMethod;
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

	public String getMappedby() {
		return mappedby;
	}
	public void setMappedby(String mappedby) {
		this.mappedby = mappedby;
	}

	public String getIdTabla1() {
		return idTabla1;
	}
	public void setIdTabla1(String idTabla1) {
		this.idTabla1 = idTabla1;
	}

	public Boolean getOptionality() {
		return optionality;
	}
	public void setOptionality(Boolean optionality) {
		this.optionality = optionality;
	}

	public String getEntity() {
		return entity;
	}
	public void setEntity(String entity) {
		this.entity = entity;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getTabla() {
		return tabla;
	}
	public void setTabla(String tabla) {
		this.tabla = tabla;
	}

	public String getAnnotationsField() {
		return annotationsField;
	}
	public void setAnnotationsField(String annotationsField) {
		this.annotationsField = annotationsField;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getIdTabla2() {
		return idTabla2;
	}
	public void setIdTabla2(String idTabla2) {
		this.idTabla2 = idTabla2;
	}

	public String getAnnotationsMethod() {
		return annotationsMethod;
	}
	public void setAnnotationsMethod(String annotationsMethod) {
		this.annotationsMethod = annotationsMethod;
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

	public Entities getTo() {
		return to;
	}
	public void setTo(Entities to) {
		this.to = to;
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

