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
public class Series implements Serializable {

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
	private String located;

	@Column(nullable = true, unique = false)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String name;

	@Column(nullable = true, unique = false)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String link;

	@Column(nullable = true, unique = false)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String code;

	@OneToMany(mappedBy = "series")
	private Set<DocumentalsUnits> documentalsUnits = new HashSet<DocumentalsUnits>();

	@ManyToMany
	private Set<Sites> sites = new HashSet<Sites>();

	@OneToMany(mappedBy = "objPadre")
	private Set<Series> objHijos = new HashSet<Series>();

	@ManyToMany(mappedBy = "series")
	private Set<Sections> sections = new HashSet<Sections>();

	@ManyToOne
	private Series objPadre;

	@ManyToOne
	private DocumentsTypes documentsTypes;

	public Series() {
	}

	public Series(String located, String name, String link, String code) {
		this.located = located;
		this.name = name;
		this.link = link;
		this.code = code;
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

	public String getLocated() {
		return located;
	}
	public void setLocated(String located) {
		this.located = located;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public Set<DocumentalsUnits> getDocumentalsUnits() {
		return documentalsUnits;
	}
	public void setDocumentalsUnits(Set<DocumentalsUnits> documentalsUnits) {
		this.documentalsUnits = documentalsUnits;
	}

	public Set<Sites> getSites() {
		return sites;
	}
	public void setSites(Set<Sites> sites) {
		this.sites = sites;
	}

	public Set<Series> getObjHijos() {
		return this.objHijos;
	}
	public void setObjHijos(Set<Series> objHijos) {
		this.objHijos = objHijos;
	}

	public Set<Sections> getSections() {
		return sections;
	}
	public void setSections(Set<Sections> sections) {
		this.sections = sections;
	}

	public Series getObjPadre() {
		return this.objPadre;
	}
	public void setObjPadre(Series objPadre) {
		this.objPadre = objPadre;
	}

	public DocumentsTypes getDocumentsTypes() {
		return documentsTypes;
	}
	public void setDocumentsTypes(DocumentsTypes documentsTypes) {
		this.documentsTypes = documentsTypes;
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

		Series other = (Series) ojt;
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

