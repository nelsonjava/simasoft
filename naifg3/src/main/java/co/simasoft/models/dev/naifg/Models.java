package co.simasoft.models.dev.naifg;

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

import co.simasoft.models.dev.naifg.*;
import co.simasoft.models.dev.naifg.dependencies.*;
import co.simasoft.models.core.sites.*;
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
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;

@Indexed
@Entity
public class Models implements Serializable {

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
	private String groupId;

	@Column(nullable = true, unique = false)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String version;

	@Column(nullable = false, unique = true)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String artifactId;

	@Column(nullable = true, unique = false)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String code;

	@Column(nullable = true, unique = false)
	@Temporal(TemporalType.DATE)
	@DateBridge(resolution = Resolution.YEAR)
	private Date date;

	@OneToMany(mappedBy = "models")
	private Set<ModelsGroupIds> modelsGroupIds = new HashSet<ModelsGroupIds>();

	@ManyToMany
	private Set<Sites> sites = new HashSet<Sites>();

	@ManyToMany(mappedBy = "models")
	private Set<Developments> developments = new HashSet<Developments>();

	public Models() {
	}

	public Models(String groupId, String version, String artifactId,
			String code, Date date) {
		this.groupId = groupId;
		this.version = version;
		this.artifactId = artifactId;
		this.code = code;
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
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}

	public String getArtifactId() {
		return artifactId;
	}
	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public Set<ModelsGroupIds> getModelsGroupIds() {
		return modelsGroupIds;
	}
	public void setModelsGroupIds(Set<ModelsGroupIds> modelsGroupIds) {
		this.modelsGroupIds = modelsGroupIds;
	}

	public Set<Sites> getSites() {
		return sites;
	}
	public void setSites(Set<Sites> sites) {
		this.sites = sites;
	}

	public Set<Developments> getDevelopments() {
		return developments;
	}
	public void setDevelopments(Set<Developments> developments) {
		this.developments = developments;
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

		Models other = (Models) ojt;
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

