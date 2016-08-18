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
public class Sites implements Serializable {

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

	@Column(nullable = true, unique = false)
	// @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String title;

	@Column(nullable = false, unique = true)
	// @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String link;

	@Column(nullable = true, unique = false)
	// @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String abc;

	@Column(nullable = true, unique = false)
	// @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String ipAddress1;

	@Column(nullable = true, unique = false)
	// @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String ipAddress2;

	@Column(nullable = true, unique = false)
	// @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String ipAddress3;

	@ManyToMany
	private Set<SitesTypes> sitesTypes = new HashSet<SitesTypes>();

	@ManyToMany(mappedBy = "sites")
	private Set<NetworkPorts> networkPorts = new HashSet<NetworkPorts>();

	@ManyToMany(mappedBy = "sites")
	private Set<Companies> companies = new HashSet<Companies>();

	@ManyToMany(mappedBy = "sites")
	private Set<Brands> brands = new HashSet<Brands>();

	public Sites() {
	}

	public Sites(String title, String link, String abc, String ipAddress1,
			String ipAddress2, String ipAddress3) {
		this.title = title;
		this.link = link;
		this.abc = abc;
		this.ipAddress1 = ipAddress1;
		this.ipAddress2 = ipAddress2;
		this.ipAddress3 = ipAddress3;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}

	public String getAbc() {
		return abc;
	}
	public void setAbc(String abc) {
		this.abc = abc;
	}

	public String getIpAddress1() {
		return ipAddress1;
	}
	public void setIpAddress1(String ipAddress1) {
		this.ipAddress1 = ipAddress1;
	}

	public String getIpAddress2() {
		return ipAddress2;
	}
	public void setIpAddress2(String ipAddress2) {
		this.ipAddress2 = ipAddress2;
	}

	public String getIpAddress3() {
		return ipAddress3;
	}
	public void setIpAddress3(String ipAddress3) {
		this.ipAddress3 = ipAddress3;
	}

	public Set<SitesTypes> getSitesTypes() {
		return sitesTypes;
	}
	public void setSitesTypes(Set<SitesTypes> sitesTypes) {
		this.sitesTypes = sitesTypes;
	}

	public Set<NetworkPorts> getNetworkPorts() {
		return networkPorts;
	}
	public void setNetworkPorts(Set<NetworkPorts> networkPorts) {
		this.networkPorts = networkPorts;
	}

	public Set<Companies> getCompanies() {
		return companies;
	}
	public void setCompanies(Set<Companies> companies) {
		this.companies = companies;
	}

	public Set<Brands> getBrands() {
		return brands;
	}
	public void setBrands(Set<Brands> brands) {
		this.brands = brands;
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

		Sites other = (Sites) ojt;
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

