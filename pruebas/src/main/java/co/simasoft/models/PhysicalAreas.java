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
import org.hibernate.search.annotations.NumericField;

// @Indexed
@Entity
@XmlRootElement
public class PhysicalAreas implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@DocumentId
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@Version
	private Integer optlock;

	private double orden;

	private String alias;

	@Lob
	@Column(nullable = true, unique = false)
	// @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String observations;

	@Column(nullable = true, unique = false)
	// @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String name;

	@Column(nullable = true, unique = false)
	// @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String code;

	@Column(nullable = true, unique = false)
	// @NumericField
	// @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private Double width;

	@Column(nullable = true, unique = false)
	// @NumericField
	// @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private Double high;

	@Column(nullable = true, unique = false)
	// @NumericField
	// @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private Double prof;

	@Column(nullable = true, unique = false)
	// @NumericField
	// @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private Double area;

	@Column(nullable = true, unique = false)
	// @NumericField
	// @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private Double volume;

	@OneToMany(mappedBy = "objPadre")
	private Set<PhysicalAreas> objHijos = new HashSet<PhysicalAreas>();

	@ManyToMany(mappedBy = "physicalAreas")
	private Set<PhysicalSpaces> physicalSpaces = new HashSet<PhysicalSpaces>();

	@ManyToOne
	private PhysicalAreasTypes physicalAreasTypes;

	@ManyToOne
	private PhysicalAreas objPadre;

	public PhysicalAreas() {
	}

	public PhysicalAreas(String name, String code, Double width, Double high,
			Double prof, Double area, Double volume) {
		this.name = name;
		this.code = code;
		this.width = width;
		this.high = high;
		this.prof = prof;
		this.area = area;
		this.volume = volume;
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

	public String getAlias() {
		return this.alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
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

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public Double getWidth() {
		return width;
	}
	public void setWidth(Double width) {
		this.width = width;
	}

	public Double getHigh() {
		return high;
	}
	public void setHigh(Double high) {
		this.high = high;
	}

	public Double getProf() {
		return prof;
	}
	public void setProf(Double prof) {
		this.prof = prof;
	}

	public Double getArea() {
		return area;
	}
	public void setArea(Double area) {
		this.area = area;
	}

	public Double getVolume() {
		return volume;
	}
	public void setVolume(Double volume) {
		this.volume = volume;
	}

	public Set<PhysicalAreas> getObjHijos() {
		return this.objHijos;
	}
	public void setObjHijos(Set<PhysicalAreas> objHijos) {
		this.objHijos = objHijos;
	}

	public Set<PhysicalSpaces> getPhysicalSpaces() {
		return physicalSpaces;
	}
	public void setPhysicalSpaces(Set<PhysicalSpaces> physicalSpaces) {
		this.physicalSpaces = physicalSpaces;
	}

	public PhysicalAreasTypes getPhysicalAreasTypes() {
		return physicalAreasTypes;
	}
	public void setPhysicalAreasTypes(PhysicalAreasTypes physicalAreasTypes) {
		this.physicalAreasTypes = physicalAreasTypes;
	}

	public PhysicalAreas getObjPadre() {
		return this.objPadre;
	}
	public void setObjPadre(PhysicalAreas objPadre) {
		this.objPadre = objPadre;
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

		PhysicalAreas other = (PhysicalAreas) ojt;
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

