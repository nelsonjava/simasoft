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
import co.simasoft.models.core.persons.*;
import co.simasoft.models.core.archival.*;
import co.simasoft.models.core.sites.*;
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

@Indexed
@Entity
public class Guides implements Serializable {

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
	@Lob
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String detail;

	@OneToMany(mappedBy = "guides")
	private Set<Activities> activities = new HashSet<Activities>();

	@ManyToMany(mappedBy = "guides")
	private Set<Sites> sites = new HashSet<Sites>();

	public Guides() {
	}

	public Guides(String name, String detail) {
		this.name = name;
		this.detail = detail;
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

	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Set<Activities> getActivities() {
		return activities;
	}
	public void setActivities(Set<Activities> activities) {
		this.activities = activities;
	}

	public Set<Sites> getSites() {
		return sites;
	}
	public void setSites(Set<Sites> sites) {
		this.sites = sites;
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

		Guides other = (Guides) ojt;
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

