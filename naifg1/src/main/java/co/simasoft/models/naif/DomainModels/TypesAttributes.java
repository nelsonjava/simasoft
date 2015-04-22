package co.simasoft.models.naif.DomainModels;

import co.simasoft.models.naif.DomainModels.*;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class TypesAttributes {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long id;

	private Integer optlock;

	private String name;

	private Integer length;

	private Integer precision;

	private String annotations;

	private String observaciones;

	@OneToMany(mappedBy = "typesAttributes")
	private Set<Attributes> attributes = new HashSet<Attributes>();

	public TypesAttributes() {
	}

	public TypesAttributes(String name, Integer length, Integer precision,
			String annotations, String observaciones) {
		this.name = name;
		this.length = length;
		this.precision = precision;
		this.annotations = annotations;
		this.observaciones = observaciones;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Integer getPrecision() {
		return precision;
	}

	public void setPrecision(Integer precision) {
		this.precision = precision;
	}

	public String getAnnotations() {
		return annotations;
	}

	public void setAnnotations(String annotations) {
		this.annotations = annotations;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Set<Attributes> getAttributes() {
		return attributes;
	}

	public void setAttributes(Set<Attributes> attributes) {
		this.attributes = attributes;
	}

} // entity

