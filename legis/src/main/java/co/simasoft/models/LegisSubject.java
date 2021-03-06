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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.Resolution;
import javax.persistence.Lob;

// @Indexed
@Entity
@XmlRootElement
public class LegisSubject implements Serializable {

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
	private String code;

	@Column(nullable = true, unique = false)
	// @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String name;

	@OneToMany(mappedBy = "legisSubject")
	private Set<LegisArtSubject> legisArtSubject = new HashSet<LegisArtSubject>();

	@OneToMany(mappedBy = "legisSubject")
	private Set<LegisTopic> legisTopic = new HashSet<LegisTopic>();

	@OneToMany(mappedBy = "objPadre")
	private Set<LegisSubject> objHijos = new HashSet<LegisSubject>();

	@ManyToOne
	private LegisSubject objPadre;

	public LegisSubject() {
	}

	public LegisSubject(String code, String name) {
		this.code = code;
		this.name = name;
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Set<LegisArtSubject> getLegisArtSubject() {
		return legisArtSubject;
	}
	public void setLegisArtSubject(Set<LegisArtSubject> legisArtSubject) {
		this.legisArtSubject = legisArtSubject;
	}

	public Set<LegisTopic> getLegisTopic() {
		return legisTopic;
	}
	public void setLegisTopic(Set<LegisTopic> legisTopic) {
		this.legisTopic = legisTopic;
	}

	public Set<LegisSubject> getObjHijos() {
		return this.objHijos;
	}
	public void setObjHijos(Set<LegisSubject> objHijos) {
		this.objHijos = objHijos;
	}

	public LegisSubject getObjPadre() {
		return this.objPadre;
	}
	public void setObjPadre(LegisSubject objPadre) {
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

		LegisSubject other = (LegisSubject) ojt;
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

