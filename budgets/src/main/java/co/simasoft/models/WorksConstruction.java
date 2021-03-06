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
public class WorksConstruction implements Serializable {

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

	@Column(nullable = false, unique = true)
	// @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String code;

	@Column(nullable = false, unique = true)
	// @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String name;

	@Column(nullable = true, unique = false)
	@DateBridge(resolution = Resolution.YEAR)
	@Temporal(TemporalType.DATE)
	private Date date;

	@OneToMany(mappedBy = "worksConstruction")
	private Set<Budgets> budgets = new HashSet<Budgets>();

	@OneToMany(mappedBy = "objPadre")
	private Set<WorksConstruction> objHijos = new HashSet<WorksConstruction>();

	@ManyToOne
	private Years years;

	@ManyToOne
	private WorksConstruction objPadre;

	@ManyToOne
	private TypesWorksConstruction typesWorksConstruction;

	public WorksConstruction() {
	}

	public WorksConstruction(String code, String name, Date date) {
		this.code = code;
		this.name = name;
		this.date = date;
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

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public Set<Budgets> getBudgets() {
		return budgets;
	}
	public void setBudgets(Set<Budgets> budgets) {
		this.budgets = budgets;
	}

	public Set<WorksConstruction> getObjHijos() {
		return this.objHijos;
	}
	public void setObjHijos(Set<WorksConstruction> objHijos) {
		this.objHijos = objHijos;
	}

	public Years getYears() {
		return years;
	}
	public void setYears(Years years) {
		this.years = years;
	}

	public WorksConstruction getObjPadre() {
		return this.objPadre;
	}
	public void setObjPadre(WorksConstruction objPadre) {
		this.objPadre = objPadre;
	}

	public TypesWorksConstruction getTypesWorksConstruction() {
		return typesWorksConstruction;
	}
	public void setTypesWorksConstruction(
			TypesWorksConstruction typesWorksConstruction) {
		this.typesWorksConstruction = typesWorksConstruction;
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

		WorksConstruction other = (WorksConstruction) ojt;
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

