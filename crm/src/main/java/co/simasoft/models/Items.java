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
public class Items implements Serializable {

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
	private String serial;

	@Column(nullable = true, unique = false)
	// @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String eanCode;

	@Column(nullable = true, unique = false)
	@DateBridge(resolution = Resolution.YEAR)
	@Temporal(TemporalType.DATE)
	private Date expirationDate;

	@Column(nullable = true, unique = false)
	@DateBridge(resolution = Resolution.YEAR)
	@Temporal(TemporalType.DATE)
	private Date warrantyDate;

	@Column(nullable = true, unique = false)
	private Integer minStock;

	@Column(nullable = true, unique = false)
	private Integer maxStock;

	@Column(nullable = true, unique = false)
	private Integer quantity;

	@Column(nullable = true, unique = false)
	// @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String located;

	@Column(nullable = true, unique = false)
	// @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String cvNumber;

	@Column(nullable = true, unique = false)
	// @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String code;

	@Column(nullable = true, unique = false)
	// @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String inventoryCode;

	@OneToMany(mappedBy = "items")
	private Set<Hosts> hosts = new HashSet<Hosts>();

	@OneToMany(mappedBy = "objPadre")
	private Set<Items> objHijos = new HashSet<Items>();

	@ManyToOne
	private PhysicalAreas physicalAreas;

	@ManyToOne
	private ItemsNames itemsNames;

	@ManyToOne
	private ItemsStates itemsStates;

	@ManyToOne
	private Items objPadre;

	public Items() {
	}

	public Items(String serial, String eanCode, Date expirationDate,
			Date warrantyDate, Integer minStock, Integer maxStock,
			Integer quantity, String located, String cvNumber, String code,
			String inventoryCode) {
		this.serial = serial;
		this.eanCode = eanCode;
		this.expirationDate = expirationDate;
		this.warrantyDate = warrantyDate;
		this.minStock = minStock;
		this.maxStock = maxStock;
		this.quantity = quantity;
		this.located = located;
		this.cvNumber = cvNumber;
		this.code = code;
		this.inventoryCode = inventoryCode;
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
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getEanCode() {
		return eanCode;
	}
	public void setEanCode(String eanCode) {
		this.eanCode = eanCode;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Date getWarrantyDate() {
		return warrantyDate;
	}
	public void setWarrantyDate(Date warrantyDate) {
		this.warrantyDate = warrantyDate;
	}

	public Integer getMinStock() {
		return minStock;
	}
	public void setMinStock(Integer minStock) {
		this.minStock = minStock;
	}

	public Integer getMaxStock() {
		return maxStock;
	}
	public void setMaxStock(Integer maxStock) {
		this.maxStock = maxStock;
	}

	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getLocated() {
		return located;
	}
	public void setLocated(String located) {
		this.located = located;
	}

	public String getCvNumber() {
		return cvNumber;
	}
	public void setCvNumber(String cvNumber) {
		this.cvNumber = cvNumber;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public String getInventoryCode() {
		return inventoryCode;
	}
	public void setInventoryCode(String inventoryCode) {
		this.inventoryCode = inventoryCode;
	}

	public Set<Hosts> getHosts() {
		return hosts;
	}
	public void setHosts(Set<Hosts> hosts) {
		this.hosts = hosts;
	}

	public Set<Items> getObjHijos() {
		return this.objHijos;
	}
	public void setObjHijos(Set<Items> objHijos) {
		this.objHijos = objHijos;
	}

	public PhysicalAreas getPhysicalAreas() {
		return physicalAreas;
	}
	public void setPhysicalAreas(PhysicalAreas physicalAreas) {
		this.physicalAreas = physicalAreas;
	}

	public ItemsNames getItemsNames() {
		return itemsNames;
	}
	public void setItemsNames(ItemsNames itemsNames) {
		this.itemsNames = itemsNames;
	}

	public ItemsStates getItemsStates() {
		return itemsStates;
	}
	public void setItemsStates(ItemsStates itemsStates) {
		this.itemsStates = itemsStates;
	}

	public Items getObjPadre() {
		return this.objPadre;
	}
	public void setObjPadre(Items objPadre) {
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

		Items other = (Items) ojt;
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

