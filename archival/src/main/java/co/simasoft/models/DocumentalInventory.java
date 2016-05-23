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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.Resolution;

// @Indexed
@Entity
@XmlRootElement
public class DocumentalInventory implements Serializable {

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
	private Integer folios;

	@Column(nullable = true, unique = false)
	private Integer quantity;

	@Column(nullable = true, unique = false)
	@Temporal(TemporalType.DATE)
	@DateBridge(resolution = Resolution.YEAR)
	private Date startDate;

	@Column(nullable = true, unique = false)
	@Temporal(TemporalType.DATE)
	@DateBridge(resolution = Resolution.YEAR)
	private Date finalDate;

	@Column(nullable = true, unique = false)
	@Temporal(TemporalType.DATE)
	@DateBridge(resolution = Resolution.YEAR)
	private Date debugDate;

	@Column(nullable = true, unique = false)
	// @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String finalDisposition;

	@Column(nullable = true, unique = false)
	@Temporal(TemporalType.DATE)
	@DateBridge(resolution = Resolution.YEAR)
	private Date deliveryDate;

	@Column(nullable = true, unique = false)
	private Integer transferNumber;

	@ManyToOne
	private DocumentalsUnits documentalsUnits;

	@ManyToOne
	private InventoryFinality inventoryFinality;

	public DocumentalInventory() {
	}

	public DocumentalInventory(Integer folios, Integer quantity,
			Date startDate, Date finalDate, Date debugDate,
			String finalDisposition, Date deliveryDate, Integer transferNumber) {
		this.folios = folios;
		this.quantity = quantity;
		this.startDate = startDate;
		this.finalDate = finalDate;
		this.debugDate = debugDate;
		this.finalDisposition = finalDisposition;
		this.deliveryDate = deliveryDate;
		this.transferNumber = transferNumber;
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
	public Integer getFolios() {
		return folios;
	}
	public void setFolios(Integer folios) {
		this.folios = folios;
	}

	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getFinalDate() {
		return finalDate;
	}
	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}

	public Date getDebugDate() {
		return debugDate;
	}
	public void setDebugDate(Date debugDate) {
		this.debugDate = debugDate;
	}

	public String getFinalDisposition() {
		return finalDisposition;
	}
	public void setFinalDisposition(String finalDisposition) {
		this.finalDisposition = finalDisposition;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Integer getTransferNumber() {
		return transferNumber;
	}
	public void setTransferNumber(Integer transferNumber) {
		this.transferNumber = transferNumber;
	}

	public DocumentalsUnits getDocumentalsUnits() {
		return documentalsUnits;
	}
	public void setDocumentalsUnits(DocumentalsUnits documentalsUnits) {
		this.documentalsUnits = documentalsUnits;
	}

	public InventoryFinality getInventoryFinality() {
		return inventoryFinality;
	}
	public void setInventoryFinality(InventoryFinality inventoryFinality) {
		this.inventoryFinality = inventoryFinality;
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

		DocumentalInventory other = (DocumentalInventory) ojt;
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

