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
public class DocumentalsUnits implements Serializable {

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
	private String name;

	@Column(nullable = true, unique = false)
	@Temporal(TemporalType.DATE)
	@DateBridge(resolution = Resolution.YEAR)
	private Date creationDate;

	@OneToMany(mappedBy = "documentalsUnits")
	private Set<OriginalOrder> originalOrder = new HashSet<OriginalOrder>();

	@ManyToOne
	private Series series;

	@ManyToOne
	private ConservationUnits conservationUnits;

	public DocumentalsUnits() {
	}

	public DocumentalsUnits(String name, Date creationDate) {
		this.name = name;
		this.creationDate = creationDate;
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

	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Set<OriginalOrder> getOriginalOrder() {
		return originalOrder;
	}
	public void setOriginalOrder(Set<OriginalOrder> originalOrder) {
		this.originalOrder = originalOrder;
	}

	public Series getSeries() {
		return series;
	}
	public void setSeries(Series series) {
		this.series = series;
	}

	public ConservationUnits getConservationUnits() {
		return conservationUnits;
	}
	public void setConservationUnits(ConservationUnits conservationUnits) {
		this.conservationUnits = conservationUnits;
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

		DocumentalsUnits other = (DocumentalsUnits) ojt;
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
