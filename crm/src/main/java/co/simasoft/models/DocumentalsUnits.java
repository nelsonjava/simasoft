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

import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
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
public class DocumentalsUnits implements Serializable {

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

	@Column(nullable = false, unique = true)
	// @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String name;

	@Column(nullable = true, unique = false)
	// @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String code;

	@Column(nullable = true, unique = false)
	@DateBridge(resolution = Resolution.YEAR)
	@Temporal(TemporalType.DATE)
	private Date startDate;

	@OneToMany(mappedBy = "documentalsUnits")
	private Set<ContinualImprovements> continualImprovements = new HashSet<ContinualImprovements>();

	@OneToMany(mappedBy = "documentalsUnits")
	private Set<OriginalOrders> originalOrders = new HashSet<OriginalOrders>();

	@OneToMany(mappedBy = "documentalsUnits")
	private Set<VersionsControls> versionsControls = new HashSet<VersionsControls>();

	@OneToMany(mappedBy = "objPadre")
	private Set<DocumentalsUnits> objHijos = new HashSet<DocumentalsUnits>();

	@ManyToOne
	private CompaniesRoles almacenamiento;

	@ManyToOne
	private CompaniesRoles proteccion;

	@ManyToOne
	private Series series;

	@ManyToOne
	private Organizeds organizeds;

	@ManyToOne
	private Access access;

	@ManyToOne
	private FrequentlyQuery frequentlyQuery;

	@ManyToOne
	private DocumentalsUnitsTypes documentalsUnitsTypes;

	@ManyToOne
	private DocumentalsUnits objPadre;

	public DocumentalsUnits() {
	}

	public DocumentalsUnits(String name, String code, Date startDate) {
		this.name = name;
		this.code = code;
		this.startDate = startDate;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Set<ContinualImprovements> getContinualImprovements() {
		return continualImprovements;
	}
	public void setContinualImprovements(
			Set<ContinualImprovements> continualImprovements) {
		this.continualImprovements = continualImprovements;
	}

	public Set<OriginalOrders> getOriginalOrders() {
		return originalOrders;
	}
	public void setOriginalOrders(Set<OriginalOrders> originalOrders) {
		this.originalOrders = originalOrders;
	}

	public Set<VersionsControls> getVersionsControls() {
		return versionsControls;
	}
	public void setVersionsControls(Set<VersionsControls> versionsControls) {
		this.versionsControls = versionsControls;
	}

	public Set<DocumentalsUnits> getObjHijos() {
		return this.objHijos;
	}
	public void setObjHijos(Set<DocumentalsUnits> objHijos) {
		this.objHijos = objHijos;
	}

	public CompaniesRoles getAlmacenamiento() {
		return almacenamiento;
	}
	public void setAlmacenamiento(CompaniesRoles almacenamiento) {
		this.almacenamiento = almacenamiento;
	}

	public CompaniesRoles getProteccion() {
		return proteccion;
	}
	public void setProteccion(CompaniesRoles proteccion) {
		this.proteccion = proteccion;
	}

	public Series getSeries() {
		return series;
	}
	public void setSeries(Series series) {
		this.series = series;
	}

	public Organizeds getOrganizeds() {
		return organizeds;
	}
	public void setOrganizeds(Organizeds organizeds) {
		this.organizeds = organizeds;
	}

	public Access getAccess() {
		return access;
	}
	public void setAccess(Access access) {
		this.access = access;
	}

	public FrequentlyQuery getFrequentlyQuery() {
		return frequentlyQuery;
	}
	public void setFrequentlyQuery(FrequentlyQuery frequentlyQuery) {
		this.frequentlyQuery = frequentlyQuery;
	}

	public DocumentalsUnitsTypes getDocumentalsUnitsTypes() {
		return documentalsUnitsTypes;
	}
	public void setDocumentalsUnitsTypes(
			DocumentalsUnitsTypes documentalsUnitsTypes) {
		this.documentalsUnitsTypes = documentalsUnitsTypes;
	}

	public DocumentalsUnits getObjPadre() {
		return this.objPadre;
	}
	public void setObjPadre(DocumentalsUnits objPadre) {
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
