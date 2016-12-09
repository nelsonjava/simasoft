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
public class ContinualImprovements implements Serializable {

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

    @Column(nullable = false, unique = true)
    // @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String code;

    @Column(nullable = true, unique = false)
    // @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String description;

    @Column(nullable = true, unique = false)
    // @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String causesAnalysis;

    @Column(nullable = true, unique = false)
    // @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String rootCause;

    @Column(nullable = true, unique = false)
    // @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String immediateCorrection;

    @Column(nullable = true, unique = false)
    @DateBridge(resolution = Resolution.YEAR)
    @Temporal(TemporalType.DATE)
    private Date dateCorrection;

    @OneToMany(mappedBy = "continualImprovements")
    private Set<OriginalOrders> originalOrders = new HashSet<OriginalOrders>();

    @OneToMany(mappedBy = "continualImprovements")
    private Set<ActionPlans> actionPlans = new HashSet<ActionPlans>();

    @ManyToOne
    private DocumentalsUnits documentalsUnits;

    @ManyToOne
    private ImprovementClosures improvementClosures;

    @ManyToOne
    private ImprovementTypes improvementTypes;

    @ManyToOne
    private ImprovementSources improvementSources;

    @ManyToOne
    private ImprovementVerifications improvementVerifications;

    public ContinualImprovements() {
    }

    public ContinualImprovements(String code,String description,String causesAnalysis,String rootCause,String immediateCorrection,Date dateCorrection) {
        this.code = code;
        this.description = description;
        this.causesAnalysis = causesAnalysis;
        this.rootCause = rootCause;
        this.immediateCorrection = immediateCorrection;
        this.dateCorrection = dateCorrection;
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
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getCausesAnalysis() {
        return causesAnalysis;
    }
    public void setCausesAnalysis(String causesAnalysis) {
        this.causesAnalysis = causesAnalysis;
    }

    public String getRootCause() {
        return rootCause;
    }
    public void setRootCause(String rootCause) {
        this.rootCause = rootCause;
    }

    public String getImmediateCorrection() {
        return immediateCorrection;
    }
    public void setImmediateCorrection(String immediateCorrection) {
        this.immediateCorrection = immediateCorrection;
    }

    public Date getDateCorrection() {
        return dateCorrection;
    }
    public void setDateCorrection(Date dateCorrection) {
        this.dateCorrection = dateCorrection;
    }

    public Set<OriginalOrders> getOriginalOrders() {
        return originalOrders;
    }
    public void setOriginalOrders(Set<OriginalOrders> originalOrders) {
        this.originalOrders = originalOrders;
    }

    public Set<ActionPlans> getActionPlans() {
        return actionPlans;
    }
    public void setActionPlans(Set<ActionPlans> actionPlans) {
        this.actionPlans = actionPlans;
    }

    public DocumentalsUnits getDocumentalsUnits() {
        return documentalsUnits;
    }
    public void setDocumentalsUnits(DocumentalsUnits documentalsUnits) {
        this.documentalsUnits = documentalsUnits;
    }

    public ImprovementClosures getImprovementClosures() {
        return improvementClosures;
    }
    public void setImprovementClosures(ImprovementClosures improvementClosures) {
        this.improvementClosures = improvementClosures;
    }

    public ImprovementTypes getImprovementTypes() {
        return improvementTypes;
    }
    public void setImprovementTypes(ImprovementTypes improvementTypes) {
        this.improvementTypes = improvementTypes;
    }

    public ImprovementSources getImprovementSources() {
        return improvementSources;
    }
    public void setImprovementSources(ImprovementSources improvementSources) {
        this.improvementSources = improvementSources;
    }

    public ImprovementVerifications getImprovementVerifications() {
        return improvementVerifications;
    }
    public void setImprovementVerifications(ImprovementVerifications improvementVerifications) {
        this.improvementVerifications = improvementVerifications;
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

      ContinualImprovements other = (ContinualImprovements) ojt;
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

