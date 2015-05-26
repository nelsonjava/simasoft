package co.simasoft.models.naif.domainmodels;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.FetchType;

import co.simasoft.models.naif.domainmodels.*;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Dependency implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@Version
	private Integer optlock;

	private long orden;

	@Column(nullable = false, unique = false)
	private String artifactId;

	@Column(nullable = true, unique = false)
	private String version;

	@Column(nullable = false, unique = false)
	private String groupId;

	@Column(nullable = false, unique = true)
	private String maven;

	@Column(nullable = false, unique = false)
	private String link;

	@Column(nullable = true, unique = false)
	private String type;

	@Column(nullable = true, unique = false)
	private String scope;

	@Column(nullable = true, unique = false)
	private String observations;

	@OneToMany(mappedBy = "dependency")
	private Set<Imports> imports = new HashSet<Imports>();

	public Dependency() {
	}

	public Dependency(String artifactId, String version, String groupId,
			String maven, String link, String type, String scope,
			String observations) {
		this.artifactId = artifactId;
		this.version = version;
		this.groupId = groupId;
		this.maven = maven;
		this.link = link;
		this.type = type;
		this.scope = scope;
		this.observations = observations;
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

	public long getOrden() {
		return this.orden;
	}
	public void setOrden(long orden) {
		this.orden = orden;
	}

	public String getArtifactId() {
		return artifactId;
	}
	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}

	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}

	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getMaven() {
		return maven;
	}
	public void setMaven(String maven) {
		this.maven = maven;
	}

	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getObservations() {
		return observations;
	}
	public void setObservations(String observations) {
		this.observations = observations;
	}

	public Set<Imports> getImports() {
		return imports;
	}
	public void setImports(Set<Imports> imports) {
		this.imports = imports;
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

		Dependency other = (Dependency) ojt;
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

