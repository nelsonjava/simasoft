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
import org.hibernate.search.annotations.NumericField;

// @Indexed
@Entity
@XmlRootElement
public class Predio implements Serializable {

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
	private String nomenclatura;

	@Column(nullable = true, unique = false)
	// @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String predial;

	@Column(nullable = true, unique = false)
	// @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String estrato;

	@Column(nullable = true, unique = false)
	// @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String matricula;

	@Column(nullable = true, unique = false)
	// @NumericField
	// @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private Double area;

	@OneToMany(mappedBy = "predio")
	private Set<PhysicalSpaces> physicalSpaces = new HashSet<PhysicalSpaces>();

	@OneToMany(mappedBy = "objPadre")
	private Set<Predio> objHijos = new HashSet<Predio>();

	@ManyToOne
	private Predio objPadre;

	public Predio() {
	}

	public Predio(String nomenclatura, String predial, String estrato,
			String matricula, Double area) {
		this.nomenclatura = nomenclatura;
		this.predial = predial;
		this.estrato = estrato;
		this.matricula = matricula;
		this.area = area;
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
	public String getNomenclatura() {
		return nomenclatura;
	}
	public void setNomenclatura(String nomenclatura) {
		this.nomenclatura = nomenclatura;
	}

	public String getPredial() {
		return predial;
	}
	public void setPredial(String predial) {
		this.predial = predial;
	}

	public String getEstrato() {
		return estrato;
	}
	public void setEstrato(String estrato) {
		this.estrato = estrato;
	}

	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Double getArea() {
		return area;
	}
	public void setArea(Double area) {
		this.area = area;
	}

	public Set<PhysicalSpaces> getPhysicalSpaces() {
		return physicalSpaces;
	}
	public void setPhysicalSpaces(Set<PhysicalSpaces> physicalSpaces) {
		this.physicalSpaces = physicalSpaces;
	}

	public Set<Predio> getObjHijos() {
		return this.objHijos;
	}
	public void setObjHijos(Set<Predio> objHijos) {
		this.objHijos = objHijos;
	}

	public Predio getObjPadre() {
		return this.objPadre;
	}
	public void setObjPadre(Predio objPadre) {
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

		Predio other = (Predio) ojt;
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

