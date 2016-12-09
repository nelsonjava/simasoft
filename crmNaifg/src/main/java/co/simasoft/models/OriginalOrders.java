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
public class OriginalOrders implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @DocumentId
    @GeneratedValue(strategy=GenerationType.TABLE)
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
    private String subject;

    @Column(nullable = true, unique = false)
    // @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String code;

    @Column(nullable = true, unique = false)
    @DateBridge(resolution = Resolution.YEAR)
    @Temporal(TemporalType.DATE)
    private Date entryDate;

    @Column(nullable = true, unique = false)
    @DateBridge(resolution = Resolution.YEAR)
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(nullable = true, unique = false)
    @DateBridge(resolution = Resolution.YEAR)
    @Temporal(TemporalType.DATE)
    private Date finalDate;

    @Column(nullable = true, unique = false)
    private Integer folios;

    @Column(nullable = true, unique = false)
    private Integer quantity;

    @Column(nullable = true, unique = false)
    // @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String located;

    @Column(nullable = true, unique = false)
    // @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String mail;

    @Column(nullable = true, unique = false)
    // @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String notes;

    @Column(nullable = true, unique = false)
    // @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String fileName;

    @Column(nullable = true, unique = false)
    // @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String fileType;

    @Column(nullable = true, unique = false)
    // @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String filedir;

    @ManyToOne
    private ContinualImprovements continualImprovements;

    @ManyToOne
    private DocumentalsUnits documentalsUnits;

    @ManyToOne
    private DocumentalsSupports documentalsSupports;

    @ManyToOne
    private ConservationUnits conservationUnits;

    @ManyToOne
    private ConservationUnitsTypes conservationUnitsTypes;

    @ManyToOne
    private DocumentalInventory documentalInventory;

    public OriginalOrders() {
    }

    public OriginalOrders(String subject,String code,Date entryDate,Date startDate,Date finalDate,Integer folios,Integer quantity,String located,String mail,String notes,String fileName,String fileType,String filedir) {
        this.subject = subject;
        this.code = code;
        this.entryDate = entryDate;
        this.startDate = startDate;
        this.finalDate = finalDate;
        this.folios = folios;
        this.quantity = quantity;
        this.located = located;
        this.mail = mail;
        this.notes = notes;
        this.fileName = fileName;
        this.fileType = fileType;
        this.filedir = filedir;
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
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public Date getEntryDate() {
        return entryDate;
    }
    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
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

    public String getLocated() {
        return located;
    }
    public void setLocated(String located) {
        this.located = located;
    }

    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFiledir() {
        return filedir;
    }
    public void setFiledir(String filedir) {
        this.filedir = filedir;
    }

    public ContinualImprovements getContinualImprovements() {
        return continualImprovements;
    }
    public void setContinualImprovements(ContinualImprovements continualImprovements) {
        this.continualImprovements = continualImprovements;
    }

    public DocumentalsUnits getDocumentalsUnits() {
        return documentalsUnits;
    }
    public void setDocumentalsUnits(DocumentalsUnits documentalsUnits) {
        this.documentalsUnits = documentalsUnits;
    }

    public DocumentalsSupports getDocumentalsSupports() {
        return documentalsSupports;
    }
    public void setDocumentalsSupports(DocumentalsSupports documentalsSupports) {
        this.documentalsSupports = documentalsSupports;
    }

    public ConservationUnits getConservationUnits() {
        return conservationUnits;
    }
    public void setConservationUnits(ConservationUnits conservationUnits) {
        this.conservationUnits = conservationUnits;
    }

    public ConservationUnitsTypes getConservationUnitsTypes() {
        return conservationUnitsTypes;
    }
    public void setConservationUnitsTypes(ConservationUnitsTypes conservationUnitsTypes) {
        this.conservationUnitsTypes = conservationUnitsTypes;
    }

    public DocumentalInventory getDocumentalInventory() {
        return documentalInventory;
    }
    public void setDocumentalInventory(DocumentalInventory documentalInventory) {
        this.documentalInventory = documentalInventory;
    }

   @Override
   public int hashCode() {
      final int prime  = 31;
            int result =  1;

      result = prime * result + ((id == null) ? 0 : id.hashCode());

      return result;
   }

   @Override
   public boolean equals(Object ojt) {
      if (      this == ojt           ) return true;
      if (       ojt == null          ) return false;
      if (getClass() != ojt.getClass()) return false;

      OriginalOrders other = (OriginalOrders) ojt;
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

