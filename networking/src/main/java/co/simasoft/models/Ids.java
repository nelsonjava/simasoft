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

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.DocumentId;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import co.simasoft.models.*;
import org.hibernate.search.annotations.Resolution;
import org.hibernate.search.annotations.DateBridge;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

// @Indexed
@Entity
@XmlRootElement
public class Ids implements Serializable {

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
	private String nit;

	@Column(nullable = true, unique = false)
	// @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String checkDigit;

	@Column(nullable = true, unique = false)
	@DateBridge(resolution = Resolution.YEAR)
	@Temporal(TemporalType.DATE)
	private Date creationDate;

	@Column(nullable = true, unique = false)
	private Boolean isPhotocopy;

	@ManyToOne
	private Persons persons;

	@ManyToOne
	private IdsTypes idsTypes;

	public Ids() {
	}

	public Ids(String nit, String checkDigit, Date creationDate,
			Boolean isPhotocopy) {
		this.nit = nit;
		this.checkDigit = checkDigit;
		this.creationDate = creationDate;
		this.isPhotocopy = isPhotocopy;
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
	public String getNit() {
		return nit;
	}
	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getCheckDigit() {
		return checkDigit;
	}
	public void setCheckDigit(String checkDigit) {
		this.checkDigit = checkDigit;
	}

	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Boolean getIsPhotocopy() {
		return isPhotocopy;
	}
	public void setIsPhotocopy(Boolean isPhotocopy) {
		this.isPhotocopy = isPhotocopy;
	}

	public Persons getPersons() {
		return persons;
	}
	public void setPersons(Persons persons) {
		this.persons = persons;
	}

	public IdsTypes getIdsTypes() {
		return idsTypes;
	}
	public void setIdsTypes(IdsTypes idsTypes) {
		this.idsTypes = idsTypes;
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

		Ids other = (Ids) ojt;
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

