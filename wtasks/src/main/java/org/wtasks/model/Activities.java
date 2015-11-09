package org.wtasks.model;

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

import org.wtasks.model.*;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.Resolution;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlRootElement;

@Indexed
@Entity
@XmlRootElement
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

	@Column(nullable = false, unique = true)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String name;

	@Column(nullable = true, unique = false)
	@Temporal(TemporalType.DATE)
	@DateBridge(resolution = Resolution.YEAR)
	private Date startDate;

	@Column(nullable = true, unique = false)
	@Temporal(TemporalType.DATE)
	@DateBridge(resolution = Resolution.YEAR)
	private Date optimisticDate;

	@Column(nullable = true, unique = false)
	@Temporal(TemporalType.DATE)
	@DateBridge(resolution = Resolution.YEAR)
	private Date pessimisticDate;

	@Column(nullable = true, unique = false)
	@Temporal(TemporalType.DATE)
	@DateBridge(resolution = Resolution.YEAR)
	private Date finalDate;

	@Column(nullable = true, unique = false)
	private Integer priority;

	@ManyToMany
	private Set<Persons> persons = new HashSet<Persons>();

	@OneToMany(mappedBy = "activities")
	private Set<Tasks> tasks = new HashSet<Tasks>();

	@ManyToMany
	private Set<Sections> sections = new HashSet<Sections>();

	@ManyToMany
	private Set<Calendars> calendars = new HashSet<Calendars>();

	@OneToMany(mappedBy = "objPadre")
	private Set<Activities> objHijos = new HashSet<Activities>();

	@ManyToMany(mappedBy = "activities")
	private Set<Sites> sites = new HashSet<Sites>();

	@ManyToOne
	private ActivitiesTypes activitiesTypes;

	@ManyToOne
	private Guides guides;

	@ManyToOne
	private Activities objPadre;

	public Activities() {
	}

	public Activities(String name, Date startDate, Date optimisticDate,
			Date pessimisticDate, Date finalDate, Integer priority) {
		this.name = name;
		this.startDate = startDate;
		this.optimisticDate = optimisticDate;
		this.pessimisticDate = pessimisticDate;
		this.finalDate = finalDate;
		this.priority = priority;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getOptimisticDate() {
		return optimisticDate;
	}
	public void setOptimisticDate(Date optimisticDate) {
		this.optimisticDate = optimisticDate;
	}

	public Date getPessimisticDate() {
		return pessimisticDate;
	}
	public void setPessimisticDate(Date pessimisticDate) {
		this.pessimisticDate = pessimisticDate;
	}

	public Date getFinalDate() {
		return finalDate;
	}
	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}

	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Set<Persons> getPersons() {
		return persons;
	}
	public void setPersons(Set<Persons> persons) {
		this.persons = persons;
	}

	public Set<Tasks> getTasks() {
		return tasks;
	}
	public void setTasks(Set<Tasks> tasks) {
		this.tasks = tasks;
	}

	public Set<Sections> getSections() {
		return sections;
	}
	public void setSections(Set<Sections> sections) {
		this.sections = sections;
	}

	public Set<Calendars> getCalendars() {
		return calendars;
	}
	public void setCalendars(Set<Calendars> calendars) {
		this.calendars = calendars;
	}

	public Set<Activities> getObjHijos() {
		return this.objHijos;
	}
	public void setObjHijos(Set<Activities> objHijos) {
		this.objHijos = objHijos;
	}

	public Set<Sites> getSites() {
		return sites;
	}
	public void setSites(Set<Sites> sites) {
		this.sites = sites;
	}

	public ActivitiesTypes getActivitiesTypes() {
		return activitiesTypes;
	}
	public void setActivitiesTypes(ActivitiesTypes activitiesTypes) {
		this.activitiesTypes = activitiesTypes;
	}

	public Guides getGuides() {
		return guides;
	}
	public void setGuides(Guides guides) {
		this.guides = guides;
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

