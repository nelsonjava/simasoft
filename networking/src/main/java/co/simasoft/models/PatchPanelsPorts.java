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
public class PatchPanelsPorts implements Serializable {

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
	private String code;

	@Column(nullable = true, unique = false)
	private Integer mts;

	@Column(nullable = false, unique = true)
	// @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String port;

	@OneToMany(mappedBy = "patchPanelsPorts")
	private Set<NetworkPorts> networkPorts = new HashSet<NetworkPorts>();

	@ManyToOne
	private SwitchesPorts switchesPorts;

	@ManyToOne
	private Hosts hosts;

	public PatchPanelsPorts() {
	}

	public PatchPanelsPorts(String code, Integer mts, String port) {
		this.code = code;
		this.mts = mts;
		this.port = port;
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public Integer getMts() {
		return mts;
	}
	public void setMts(Integer mts) {
		this.mts = mts;
	}

	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}

	public Set<NetworkPorts> getNetworkPorts() {
		return networkPorts;
	}
	public void setNetworkPorts(Set<NetworkPorts> networkPorts) {
		this.networkPorts = networkPorts;
	}

	public SwitchesPorts getSwitchesPorts() {
		return switchesPorts;
	}
	public void setSwitchesPorts(SwitchesPorts switchesPorts) {
		this.switchesPorts = switchesPorts;
	}

	public Hosts getHosts() {
		return hosts;
	}
	public void setHosts(Hosts hosts) {
		this.hosts = hosts;
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

		PatchPanelsPorts other = (PatchPanelsPorts) ojt;
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

