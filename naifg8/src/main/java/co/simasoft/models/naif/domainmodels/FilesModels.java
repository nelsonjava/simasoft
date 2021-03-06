package co.simasoft.models.naif.domainmodels;

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

import co.simasoft.models.naif.domainmodels.*;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Store;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Index;
import javax.persistence.Lob;
import javax.persistence.TemporalType;
import javax.persistence.Temporal;
import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.Resolution;
import javax.persistence.Basic;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Indexed
@Entity
public class FilesModels implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@DocumentId
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@Version
	private Integer optlock;

	private double orden;

	@Column(nullable = false, unique = true)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String name;

	@Column(nullable = false, unique = false)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String extension;

	@Column(nullable = false, unique = false)
	@Temporal(TemporalType.DATE)
	@DateBridge(resolution = Resolution.YEAR)
	private Date date;

	@Column(nullable = false, unique = false)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String url;

	@Column(nullable = true, unique = false)
	@Basic(fetch = FetchType.LAZY)
	@Lob
	private byte data;

	@Column(nullable = true, unique = false)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	@Lob
	private String observations;

	@ManyToOne
	private GroupIds groupIds;

	@ManyToOne
	private SystemsModels systemsModels;

	@ManyToOne
	private Entities entities;

	@ManyToOne
	private DomainModels domainModels;

	public FilesModels() {
	}

	public FilesModels(String name, String extension, Date date, String url,
			byte data, String observations) {
		this.name = name;
		this.extension = extension;
		this.date = date;
		this.url = url;
		this.data = data;
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

	public double getOrden() {
		return this.orden;
	}
	public void setOrden(double orden) {
		this.orden = orden;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public byte getData() {
		return data;
	}
	public void setData(byte data) {
		this.data = data;
	}

	public String getObservations() {
		return observations;
	}
	public void setObservations(String observations) {
		this.observations = observations;
	}

	public GroupIds getGroupIds() {
		return groupIds;
	}
	public void setGroupIds(GroupIds groupIds) {
		this.groupIds = groupIds;
	}

	public SystemsModels getSystemsModels() {
		return systemsModels;
	}
	public void setSystemsModels(SystemsModels systemsModels) {
		this.systemsModels = systemsModels;
	}

	public Entities getEntities() {
		return entities;
	}
	public void setEntities(Entities entities) {
		this.entities = entities;
	}

	public DomainModels getDomainModels() {
		return domainModels;
	}
	public void setDomainModels(DomainModels domainModels) {
		this.domainModels = domainModels;
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

		FilesModels other = (FilesModels) ojt;
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

