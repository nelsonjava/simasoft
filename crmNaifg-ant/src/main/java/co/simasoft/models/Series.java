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

// @Indexed
@Entity
@XmlRootElement
public class Series implements Serializable {

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
	private String name;

	@Column(nullable = true, unique = false)
	// @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String code;

	@Column(nullable = true, unique = false)
	// @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String located;

	@Column(nullable = true, unique = false)
	// @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String procedures;

	@Column(nullable = true, unique = false)
	// @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String dir;

	@OneToMany(mappedBy = "series")
	private Set<Tasks> tasks = new HashSet<Tasks>();

	@OneToMany(mappedBy = "series")
	private Set<DocumentalsUnits> documentalsUnits = new HashSet<DocumentalsUnits>();

	@OneToMany(mappedBy = "objPadre")
	private Set<Series> objHijos = new HashSet<Series>();

	@OneToMany(mappedBy = "series")
	private Set<VersionsControls> versionsControls = new HashSet<VersionsControls>();

	@OneToMany(mappedBy = "series")
	private Set<TrdSeries> trdSeries = new HashSet<TrdSeries>();

	@ManyToOne
	private Sections sections;

	@ManyToOne
	private Series objPadre;

	public Series() {
	}

	public Series(String name, String code, String located, String procedures,
			String dir) {
		this.name = name;
		this.code = code;
		this.located = located;
		this.procedures = procedures;
		this.dir = dir;
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

	public String getLocated() {
		return located;
	}
	public void setLocated(String located) {
		this.located = located;
	}

	public String getProcedures() {
		return procedures;
	}
	public void setProcedures(String procedures) {
		this.procedures = procedures;
	}

	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}

	public Set<Tasks> getTasks() {
		return tasks;
	}
	public void setTasks(Set<Tasks> tasks) {
		this.tasks = tasks;
	}

	public Set<DocumentalsUnits> getDocumentalsUnits() {
		return documentalsUnits;
	}
	public void setDocumentalsUnits(Set<DocumentalsUnits> documentalsUnits) {
		this.documentalsUnits = documentalsUnits;
	}

	public Set<Series> getObjHijos() {
		return this.objHijos;
	}
	public void setObjHijos(Set<Series> objHijos) {
		this.objHijos = objHijos;
	}

	public Set<VersionsControls> getVersionsControls() {
		return versionsControls;
	}
	public void setVersionsControls(Set<VersionsControls> versionsControls) {
		this.versionsControls = versionsControls;
	}

	public Set<TrdSeries> getTrdSeries() {
		return trdSeries;
	}
	public void setTrdSeries(Set<TrdSeries> trdSeries) {
		this.trdSeries = trdSeries;
	}

	public Sections getSections() {
		return sections;
	}
	public void setSections(Sections sections) {
		this.sections = sections;
	}

	public Series getObjPadre() {
		return this.objPadre;
	}
	public void setObjPadre(Series objPadre) {
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

		Series other = (Series) ojt;
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

