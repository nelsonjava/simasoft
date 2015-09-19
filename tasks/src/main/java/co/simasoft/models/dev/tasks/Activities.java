package co.simasoft.models.dev.tasks;

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

import co.simasoft.models.dev.tasks.*;
import co.simasoft.models.core.sites.*;
import co.simasoft.models.core.archival.*;
import co.simasoft.models.core.persons.*;
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
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;

@Indexed
@Entity
public class Activities implements Serializable {

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
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String observations;

	@Column(nullable = true, unique = false)
	@Temporal(TemporalType.DATE)
	@DateBridge(resolution = Resolution.YEAR)
	private Date untimelyDate;

	@Column(nullable = true, unique = false)
	@Temporal(TemporalType.DATE)
	@DateBridge(resolution = Resolution.YEAR)
	private Date timelyDate;

	@Column(nullable = true, unique = false)
	@Temporal(TemporalType.DATE)
	@DateBridge(resolution = Resolution.YEAR)
	private Date finalDate;

	@Column(nullable = true, unique = false)
	@Temporal(TemporalType.DATE)
	@DateBridge(resolution = Resolution.YEAR)
	private Date startDate;

	@Column(nullable = true, unique = false)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String detail;

	@Column(nullable = true, unique = false)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String name;

	@ManyToMany
	private Set<Calendars> calendars = new HashSet<Calendars>();

	@OneToMany(mappedBy = "activities")
	private Set<Tasks> tasks = new HashSet<Tasks>();

	@ManyToMany
	private Set<Sites> sites = new HashSet<Sites>();

	@OneToMany(mappedBy = "objPadre")
	private Set<Activities> objHijos = new HashSet<Activities>();

	@ManyToMany
	private Set<Guides> guides = new HashSet<Guides>();

	@ManyToOne
	private ActivitiesTypes activitiesTypes;

	@ManyToMany(mappedBy = "activities")
	private Set<Sections> sections = new HashSet<Sections>();

	@ManyToMany(mappedBy = "activities")
	private Set<Persons> persons = new HashSet<Persons>();

	@ManyToOne
	private Activities objPadre;

	public Activities() {
	}

	public Activities(Date untimelyDate, Date timelyDate, Date finalDate,
			Date startDate, String detail, String name) {
		this.untimelyDate = untimelyDate;
		this.timelyDate = timelyDate;
		this.finalDate = finalDate;
		this.startDate = startDate;
		this.detail = detail;
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
	public Date getUntimelyDate() {
		return untimelyDate;
	}
	public void setUntimelyDate(Date untimelyDate) {
		this.untimelyDate = untimelyDate;
	}

	public Date getTimelyDate() {
		return timelyDate;
	}
	public void setTimelyDate(Date timelyDate) {
		this.timelyDate = timelyDate;
	}

	public Date getFinalDate() {
		return finalDate;
	}
	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}

	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Set<Calendars> getCalendars() {
		return calendars;
	}
	public void setCalendars(Set<Calendars> calendars) {
		this.calendars = calendars;
	}

	public Set<Tasks> getTasks() {
		return tasks;
	}
	public void setTasks(Set<Tasks> tasks) {
		this.tasks = tasks;
	}

	public Set<Sites> getSites() {
		return sites;
	}
	public void setSites(Set<Sites> sites) {
		this.sites = sites;
	}

	public Set<Activities> getObjHijos() {
		return this.objHijos;
	}
	public void setObjHijos(Set<Activities> objHijos) {
		this.objHijos = objHijos;
	}

	public Set<Guides> getGuides() {
		return guides;
	}
	public void setGuides(Set<Guides> guides) {
		this.guides = guides;
	}

	public ActivitiesTypes getActivitiesTypes() {
		return activitiesTypes;
	}
	public void setActivitiesTypes(ActivitiesTypes activitiesTypes) {
		this.activitiesTypes = activitiesTypes;
	}

	public Set<Sections> getSections() {
		return sections;
	}
	public void setSections(Set<Sections> sections) {
		this.sections = sections;
	}

	public Set<Persons> getPersons() {
		return persons;
	}
	public void setPersons(Set<Persons> persons) {
		this.persons = persons;
	}

	public Activities getObjPadre() {
		return this.objPadre;
	}
	public void setObjPadre(Activities objPadre) {
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

		Activities other = (Activities) ojt;
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

