package co.simasoft.models.naif.domainmodels;

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

import co.simasoft.models.naif.domainmodels.*;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Store;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Index;
import javax.persistence.Lob;
import javax.persistence.TemporalType;
import javax.persistence.Temporal;
import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.Resolution;
import javax.persistence.Basic;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Entities implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private Long id;

    @Version
    private Integer optlock;

    private double orden;

    @Column(nullable = false, unique = false)
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String name;

    @Column(nullable = true, unique = true)
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String serialID;

    @Column(nullable = true, unique = false)
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String description;

    @Column(nullable = true, unique = false)
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    @Lob
    private String observations;

    @Column(nullable = true, unique = false)
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    @Lob
    private String annotations;

    @Column(nullable = true, unique = false)
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    @Lob
    private String source;

    @Column(nullable = true, unique = false)
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String modifier;

    @Column(nullable = true, unique = false)
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String extend;

    @Column(nullable = true, unique = false)
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String table;

    @Column(nullable = true, unique = false)
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String tableSecuencia;

    @OneToMany(mappedBy = "to")
    private Set<Relationships> to = new HashSet<Relationships>();

    @OneToMany(mappedBy = "entities")
    private Set<Attributes> attributes = new HashSet<Attributes>();

    @OneToMany(mappedBy = "entities")
    private Set<FilesModels> filesModels = new HashSet<FilesModels>();

    @OneToMany(mappedBy = "from")
    private Set<Relationships> from = new HashSet<Relationships>();

    @OneToMany(mappedBy = "entities")
    private Set<NameQueries> nameQueries = new HashSet<NameQueries>();

    @ManyToMany
    private Set<Imports> imports = new HashSet<Imports>();

    @ManyToOne
    private GroupIds groupIds;

    public Entities() {
    }

    public Entities(String name,String serialID,String description,String observations,String annotations,String source,String modifier,String extend,String table,String tableSecuencia) {
        this.name = name;
        this.serialID = serialID;
        this.description = description;
        this.observations = observations;
        this.annotations = annotations;
        this.source = source;
        this.modifier = modifier;
        this.extend = extend;
        this.table = table;
        this.tableSecuencia = tableSecuencia;
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

    public String getSerialID() {
        return serialID;
    }
    public void setSerialID(String serialID) {
        this.serialID = serialID;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getObservations() {
        return observations;
    }
    public void setObservations(String observations) {
        this.observations = observations;
    }

    public String getAnnotations() {
        return annotations;
    }
    public void setAnnotations(String annotations) {
        this.annotations = annotations;
    }

    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }

    public String getModifier() {
        return modifier;
    }
    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getExtend() {
        return extend;
    }
    public void setExtend(String extend) {
        this.extend = extend;
    }

    public String getTable() {
        return table;
    }
    public void setTable(String table) {
        this.table = table;
    }

    public String getTableSecuencia() {
        return tableSecuencia;
    }
    public void setTableSecuencia(String tableSecuencia) {
        this.tableSecuencia = tableSecuencia;
    }

    public Set<Relationships> getTo() {
        return to;
    }
    public void setTo(Set<Relationships> to) {
        this.to = to;
    }

    public Set<Attributes> getAttributes() {
        return attributes;
    }
    public void setAttributes(Set<Attributes> attributes) {
        this.attributes = attributes;
    }

    public Set<FilesModels> getFilesModels() {
        return filesModels;
    }
    public void setFilesModels(Set<FilesModels> filesModels) {
        this.filesModels = filesModels;
    }

    public Set<Relationships> getFrom() {
        return from;
    }
    public void setFrom(Set<Relationships> from) {
        this.from = from;
    }

    public Set<NameQueries> getNameQueries() {
        return nameQueries;
    }
    public void setNameQueries(Set<NameQueries> nameQueries) {
        this.nameQueries = nameQueries;
    }

    public Set<Imports> getImports() {
        return imports;
    }
    public void setImports(Set<Imports> imports) {
        this.imports = imports;
    }

    public GroupIds getGroupIds() {
        return groupIds;
    }
    public void setGroupIds(GroupIds groupIds) {
        this.groupIds = groupIds;
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

      Entities other = (Entities) ojt;
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

