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
public class Series implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @DocumentId
    @GeneratedValue(strategy=GenerationType.TABLE)
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
    private String procedures;

    @Column(nullable = true, unique = false)
    // @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String name;

    @Column(nullable = true, unique = false)
    // @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String dir;

    @Column(nullable = true, unique = false)
    // @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String code;

    @Column(nullable = true, unique = false)
    // @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String link;

    @Column(nullable = true, unique = false)
    // @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String located;

    @OneToMany(mappedBy = "objPadre")
    private Set<Series> objHijos = new HashSet<Series>();

    @OneToMany(mappedBy = "series")
    private Set<DocumentalsUnits> documentalsUnits = new HashSet<DocumentalsUnits>();

    @ManyToOne
    private FinalDisposition finalDisposition;

    @ManyToOne
    private Series objPadre;

    @ManyToOne
    private Sections sections;

    @ManyToOne
    private DocumentalRetention gestion;

    @ManyToOne
    private DocumentalRetention central;

    public Series() {
    }

    public Series(String procedures,String name,String dir,String code,String link,String located) {
        this.procedures = procedures;
        this.name = name;
        this.dir = dir;
        this.code = code;
        this.link = link;
        this.located = located;
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
    public String getProcedures() {
        return procedures;
    }
    public void setProcedures(String procedures) {
        this.procedures = procedures;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDir() {
        return dir;
    }
    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }

    public String getLocated() {
        return located;
    }
    public void setLocated(String located) {
        this.located = located;
    }

    public Set<Series> getObjHijos() {
        return this.objHijos;
    }
    public void setObjHijos(Set<Series> objHijos) {
        this.objHijos = objHijos;
    }

    public Set<DocumentalsUnits> getDocumentalsUnits() {
        return documentalsUnits;
    }
    public void setDocumentalsUnits(Set<DocumentalsUnits> documentalsUnits) {
        this.documentalsUnits = documentalsUnits;
    }

    public FinalDisposition getFinalDisposition() {
        return finalDisposition;
    }
    public void setFinalDisposition(FinalDisposition finalDisposition) {
        this.finalDisposition = finalDisposition;
    }

    public Series getObjPadre() {
        return this.objPadre;
    }
    public void setObjPadre(Series objPadre) {
        this.objPadre = objPadre;
    }

    public Sections getSections() {
        return sections;
    }
    public void setSections(Sections sections) {
        this.sections = sections;
    }

    public DocumentalRetention getGestion() {
        return gestion;
    }
    public void setGestion(DocumentalRetention gestion) {
        this.gestion = gestion;
    }

    public DocumentalRetention getCentral() {
        return central;
    }
    public void setCentral(DocumentalRetention central) {
        this.central = central;
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

