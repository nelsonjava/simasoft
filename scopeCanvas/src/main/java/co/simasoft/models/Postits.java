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

import co.simasoft.models.*;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;

// @Indexed
@Entity
@XmlRootElement
public class Postits implements Serializable , Comparable<Postits> {

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
	private String note;

	@Column(nullable = true, unique = false)
	private Boolean isValid;

	@OneToMany(mappedBy = "objPadre")
	private Set<Postits> objHijos = new HashSet<Postits>();

	@ManyToOne
	private ScopeCanvas scopeCanvas;

	@ManyToOne
	private Postits objPadre;

	@ManyToOne
	private SectionsScopeCanvas sectionsScopeCanvas;

	public Postits() {
	}

	public Postits(String note, Boolean isValid) {
		this.note = note;
		this.isValid = isValid;
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
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

	public Boolean getIsValid() {
		return isValid;
	}
	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}

	public Set<Postits> getObjHijos() {
		return this.objHijos;
	}
	public void setObjHijos(Set<Postits> objHijos) {
		this.objHijos = objHijos;
	}

	public ScopeCanvas getScopeCanvas() {
		return scopeCanvas;
	}
	public void setScopeCanvas(ScopeCanvas scopeCanvas) {
		this.scopeCanvas = scopeCanvas;
	}

	public Postits getObjPadre() {
		return this.objPadre;
	}
	public void setObjPadre(Postits objPadre) {
		this.objPadre = objPadre;
	}

	public SectionsScopeCanvas getSectionsScopeCanvas() {
		return sectionsScopeCanvas;
	}
	public void setSectionsScopeCanvas(SectionsScopeCanvas sectionsScopeCanvas) {
		this.sectionsScopeCanvas = sectionsScopeCanvas;
	}

        @Override
        public int compareTo(Postits a) {
           if (orden < a.orden) {
              return -1;
           }
           if (orden > a.orden) {
              return 1;
           }
           return 0;
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

		Postits other = (Postits) ojt;
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

