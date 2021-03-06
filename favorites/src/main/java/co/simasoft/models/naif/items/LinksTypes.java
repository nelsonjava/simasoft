package co.simasoft.models.naif.items;

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
import javax.persistence.Lob;

import javax.persistence.Column;

import co.simasoft.models.naif.items.*;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Store;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Index;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;

@Entity
public class LinksTypes implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@Version
	private Integer optlock;

	private double orden;

	@Column(nullable = false, unique = true)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String name;

        @Lob
	@Column(nullable = true, unique = false)
	private String observations;

	@OneToMany(mappedBy = "objPadre")
	private Set<LinksTypes> objHijos = new HashSet<LinksTypes>();

	@ManyToMany
	private Set<Links> links = new HashSet<Links>();

	@ManyToOne
	private LinksTypes objPadre;

	public LinksTypes() {
	}

	public LinksTypes(String name, String observations) {
		this.name = name;
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

	public String getObservations() {
		return observations;
	}
	public void setObservations(String observations) {
		this.observations = observations;
	}

	public Set<LinksTypes> getObjHijos() {
		return this.objHijos;
	}
	public void setObjHijos(Set<LinksTypes> objHijos) {
		this.objHijos = objHijos;
	}

	public Set<Links> getLinks() {
		return links;
	}
	public void setLinks(Set<Links> links) {
		this.links = links;
	}

	public LinksTypes getObjPadre() {
		return this.objPadre;
	}
	public void setObjPadre(LinksTypes objPadre) {
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

		LinksTypes other = (LinksTypes) ojt;
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

