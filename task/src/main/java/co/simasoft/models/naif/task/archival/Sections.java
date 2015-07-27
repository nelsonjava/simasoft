package co.simasoft.models.naif.task.archival;

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

import co.simasoft.models.naif.task.sites.*;
import co.simasoft.models.naif.task.persons.*;
import co.simasoft.models.naif.task.archival.*;
import co.simasoft.models.naif.task.activities.*;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Store;
import org.hibernate.search.annotations.Indexed;
import javax.persistence.TemporalType;
import javax.persistence.Temporal;
import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.Resolution;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Indexed
@Entity
public class Sections implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@DocumentId
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@Version
	private Integer optlock;

	private double orden;

	@Column(nullable = true, unique = false)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String code;

	@Column(nullable = true, unique = false)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String name;

	@Column(nullable = true, unique = false)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String email;

	@OneToMany(mappedBy = "objPadre")
	private Set<Sections> objHijos = new HashSet<Sections>();

	@ManyToMany
	private Set<Series> series = new HashSet<Series>();

	@ManyToMany
	private Set<Tasks> tasks = new HashSet<Tasks>();

	@OneToMany(mappedBy = "sections")
	private Set<Activities> activities = new HashSet<Activities>();

	@ManyToOne
	private Sections objPadre;

	@ManyToOne
	private SectionsTypes sectionsTypes;

	@ManyToOne
	private Funds funds;

	@ManyToOne
	private Persons persons;

	public Sections() {
	}

	public Sections(String code, String name, String email) {
		this.code = code;
		this.name = name;
		this.email = email;
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

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Sections> getObjHijos() {
		return this.objHijos;
	}
	public void setObjHijos(Set<Sections> objHijos) {
		this.objHijos = objHijos;
	}

	public Set<Series> getSeries() {
		return series;
	}
	public void setSeries(Set<Series> series) {
		this.series = series;
	}

	public Set<Tasks> getTasks() {
		return tasks;
	}
	public void setTasks(Set<Tasks> tasks) {
		this.tasks = tasks;
	}

	public Set<Activities> getActivities() {
		return activities;
	}
	public void setActivities(Set<Activities> activities) {
		this.activities = activities;
	}

	public Sections getObjPadre() {
		return this.objPadre;
	}
	public void setObjPadre(Sections objPadre) {
		this.objPadre = objPadre;
	}

	public SectionsTypes getSectionsTypes() {
		return sectionsTypes;
	}
	public void setSectionsTypes(SectionsTypes sectionsTypes) {
		this.sectionsTypes = sectionsTypes;
	}

	public Funds getFunds() {
		return funds;
	}
	public void setFunds(Funds funds) {
		this.funds = funds;
	}

	public Persons getPersons() {
		return persons;
	}
	public void setPersons(Persons persons) {
		this.persons = persons;
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

		Sections other = (Sections) ojt;
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
