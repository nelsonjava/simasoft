package co.simasoft.setup;
import co.simasoft.models.naif.domainmodels.*;

import java.util.*;
import java.util.Calendar;
import java.util.Random;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jboss.logging.Logger;

@Singleton
@LocalBean
@Named("Setup")
public class Setup {

    @PersistenceContext(unitName = "naifg8PU-JTA")
    private EntityManager em;

    private static final Logger log = Logger.getLogger(Setup.class.getName());

    public void data() {

//      ---------------------- Dependency ------------------------

        Dependency dependency1 = new Dependency();
        dependency1.setGroupId("javax.persistence");
        dependency1.setArtifactId("persistence-api");
        dependency1.setLink("http://docs.oracle.com/javaee/7/api/javax/persistence/package-summary.html");
        dependency1.setMaven("Maven1");
        em.persist(dependency1);
        em.flush();

        Dependency dependency2 = new Dependency();
        dependency2.setGroupId("javax.validation");
        dependency2.setArtifactId("validation-api");
        dependency2.setLink("http://docs.oracle.com/javaee/7/api/javax/validation/package-summary.html");
        dependency2.setMaven("Maven2");
        em.persist(dependency2);
        em.flush();

        Dependency dependency3 = new Dependency();
        dependency3.setGroupId("org.hibernate");
        dependency3.setArtifactId("hibernate-validator");
        dependency3.setLink("http://docs.jboss.org/hibernate/validator/5.1/api/");
        dependency3.setMaven("Maven3");
        em.persist(dependency3);
        em.flush();

        Dependency dependency4 = new Dependency();
        dependency4.setGroupId("org.hibernate");
        dependency4.setArtifactId("hibernate-search");
        dependency4.setLink("http://docs.jboss.org/hibernate/search/5.2/");
        dependency4.setMaven("Maven4");
        em.persist(dependency4);
        em.flush();

//      ---------------------- Imports ------------------------

        Imports imports1 = new Imports();
        imports1.setName("import javax.persistence.Column;");
        imports1.setDependency(dependency1);
        em.persist(imports1);
        em.flush();

        Imports imports2 = new Imports();
        imports2.setName("import javax.persistence.Basic;");
        imports2.setDependency(dependency1);
        em.persist(imports2);
        em.flush();

        Imports imports3 = new Imports();
        imports3.setName("import javax.persistence.Lob;");
        imports3.setDependency(dependency1);
        em.persist(imports3);
        em.flush();

        Imports imports4 = new Imports();
        imports4.setName("import javax.persistence.FetchType;");
        imports4.setDependency(dependency1);
        em.persist(imports4);
        em.flush();

        Imports imports5 = new Imports();
        imports5.setName("import javax.persistence.CascadeType;");
        imports5.setDependency(dependency1);
        em.persist(imports5);
        em.flush();

        Imports imports6 = new Imports();
        imports6.setName("import javax.validation.constraints.NotNull;");
        imports6.setDependency(dependency2);
        em.persist(imports6);
        em.flush();

        Imports imports7 = new Imports();
        imports7.setName("import javax.validation.constraints.Size;");
        imports7.setDependency(dependency2);
        em.persist(imports7);
        em.flush();

        Imports imports8 = new Imports();
        imports8.setName("import javax.validation.constraints.Pattern;");
        imports8.setDependency(dependency2);
        em.persist(imports8);
        em.flush();

        Imports imports9 = new Imports();
        imports9.setName("import javax.validation.constraints.Digits;");
        imports9.setDependency(dependency2);
        em.persist(imports9);
        em.flush();

        Imports imports10 = new Imports();
        imports10.setName("import org.hibernate.validator.Length;");
        imports10.setDependency(dependency3);
        em.persist(imports10);
        em.flush();

        Imports imports11 = new Imports();
        imports11.setName("import org.hibernate.search.annotations.Resolution;");
        imports11.setDependency(dependency4);
        em.persist(imports11);
        em.flush();

        Imports imports12 = new Imports();
        imports12.setName("import org.hibernate.search.annotations.Store;");
        imports12.setDependency(dependency4);
        em.persist(imports12);
        em.flush();

        Imports imports13 = new Imports();
        imports13.setName("import javax.persistence.Embedded;");
        imports13.setDependency(dependency1);
        em.persist(imports13);
        em.flush();

        Imports imports14 = new Imports();
        imports14.setName("import org.hibernate.search.annotations.NumericField;");
        imports14.setDependency(dependency4);
        em.persist(imports14);
        em.flush();

        Imports imports15 = new Imports();
        imports15.setName("import javax.persistence.Temporal;");
        imports15.setDependency(dependency1);
        em.persist(imports15);
        em.flush();

        Imports imports16 = new Imports();
        imports16.setName("import javax.persistence.TemporalType;");
        imports16.setDependency(dependency1);
        em.persist(imports16);
        em.flush();

        Imports imports17 = new Imports();
        imports17.setName("import org.hibernate.validator.constraints.NotEmpty;");
        imports17.setDependency(dependency3);
        em.persist(imports17);
        em.flush();

        Imports imports18 = new Imports();
        imports18.setName("import org.hibernate.validator.constraints.Email;");
        imports18.setDependency(dependency3);
        em.persist(imports18);
        em.flush();

        Imports imports19 = new Imports();
        imports19.setName("import java.util.Date;");
        em.persist(imports19);
        em.flush();

        Imports imports20 = new Imports();
        imports20.setName("import org.hibernate.search.annotations.Analyze;");
        imports20.setDependency(dependency4);
        em.persist(imports20);
        em.flush();

        Imports imports21 = new Imports();
        imports21.setName("import org.hibernate.search.annotations.DateBridge;");
        imports21.setDependency(dependency4);
        em.persist(imports21);
        em.flush();

        Imports imports22 = new Imports();
        imports22.setName("import org.hibernate.search.annotations.DocumentId;");
        imports22.setDependency(dependency4);
        em.persist(imports22);
        em.flush();

        Imports imports23 = new Imports();
        imports23.setName("import org.hibernate.search.annotations.Field;");
        imports23.setDependency(dependency4);
        em.persist(imports23);
        em.flush();

        Imports imports24 = new Imports();
        imports24.setName("import org.hibernate.search.annotations.Index;");
        imports24.setDependency(dependency4);
        em.persist(imports24);
        em.flush();

        Imports imports25 = new Imports();
        imports25.setName("import org.hibernate.search.annotations.Indexed;");
        imports25.setDependency(dependency4);
        em.persist(imports25);
        em.flush();

        Imports imports26 = new Imports();
        imports26.setName("import org.hibernate.search.annotations.IndexedEmbedded;");
        imports26.setDependency(dependency4);
        em.persist(imports26);
        em.flush();

//      ---------------------- PropertiesAttributes ------------------------

        PropertiesAttributes PropertiesAttributes1 = new PropertiesAttributes();
        PropertiesAttributes1.setName("@NotNull");
        PropertiesAttributes1.setValue("@NotNull");
        Set<Imports> varImports1 = new HashSet<Imports>();
        varImports1.add(imports6);
        PropertiesAttributes1.setImports(varImports1);
        em.persist(PropertiesAttributes1);
        em.flush();

        PropertiesAttributes PropertiesAttributes2 = new PropertiesAttributes();
        PropertiesAttributes2.setName("@Size0125");
        PropertiesAttributes2.setValue("@Size(min = 1, max = 25)");
        Set<Imports> varImports2 = new HashSet<Imports>();
        varImports2.add(imports7);
        PropertiesAttributes2.setImports(varImports2);
        em.persist(PropertiesAttributes2);
        em.flush();

        PropertiesAttributes PropertiesAttributes3 = new PropertiesAttributes();
        PropertiesAttributes3.setName("@Size0912");
        PropertiesAttributes3.setValue("@Size(min = 9, max = 12)");
        Set<Imports> varImports3 = new HashSet<Imports>();
        varImports3.add(imports7);
        PropertiesAttributes3.setImports(varImports3);
        em.persist(PropertiesAttributes3);
        em.flush();

        PropertiesAttributes PropertiesAttributes4 = new PropertiesAttributes();
        PropertiesAttributes4.setName("@Length0125");
        PropertiesAttributes4.setValue("@Length(min = 1, max = 25, message = \"Size must be between 1 and 25 digits\")");
        Set<Imports> varImports4 = new HashSet<Imports>();
        varImports4.add(imports10);
        PropertiesAttributes4.setImports(varImports4);
        em.persist(PropertiesAttributes4);
        em.flush();

        PropertiesAttributes PropertiesAttributes5 = new PropertiesAttributes();
        PropertiesAttributes5.setName("@Length0912");
        PropertiesAttributes5.setValue("@Length(min = 9, max = 12, message = \"Size must be between 9 and 12 digits\")");
        Set<Imports> varImports5 = new HashSet<Imports>();
        varImports5.add(imports10);
        PropertiesAttributes5.setImports(varImports5);
        em.persist(PropertiesAttributes5);
        em.flush();

        PropertiesAttributes PropertiesAttributes6 = new PropertiesAttributes();
        PropertiesAttributes6.setName("@Pattern1");
        PropertiesAttributes6.setValue("@Pattern(regexp = \"[A-Za-z ]*\", message = \"must contain only letters and spaces\")");
        Set<Imports> varImports6 = new HashSet<Imports>();
        varImports6.add(imports8);
        PropertiesAttributes6.setImports(varImports6);
        em.persist(PropertiesAttributes6);
        em.flush();

        PropertiesAttributes PropertiesAttributes7 = new PropertiesAttributes();
        PropertiesAttributes7.setName("@Pattern2");
        PropertiesAttributes7.setValue("@Pattern(regexp = \"[^0-9]*\", message = \"Must not contain numbers\")");
        Set<Imports> varImports7 = new HashSet<Imports>();
        varImports7.add(imports8);
        PropertiesAttributes7.setImports(varImports7);
        em.persist(PropertiesAttributes7);
        em.flush();

        PropertiesAttributes PropertiesAttributes8 = new PropertiesAttributes();
        PropertiesAttributes8.setName("@NotEmpty");
        PropertiesAttributes8.setValue("@NotEmpty");
        Set<Imports> varImports8 = new HashSet<Imports>();
        varImports8.add(imports17);
        PropertiesAttributes8.setImports(varImports8);
        em.persist(PropertiesAttributes8);
        em.flush();

        PropertiesAttributes PropertiesAttributes9 = new PropertiesAttributes();
        PropertiesAttributes9.setName("@Email");
        PropertiesAttributes9.setValue("@Email(message = \"Invalid format\")");
        Set<Imports> varImports9 = new HashSet<Imports>();
        varImports9.add(imports18);
        PropertiesAttributes9.setImports(varImports9);
        em.persist(PropertiesAttributes9);
        em.flush();

        PropertiesAttributes PropertiesAttributes10 = new PropertiesAttributes();
        PropertiesAttributes10.setName("@Digits0012");
        PropertiesAttributes10.setValue("@Digits(fractionalDigits = 0, integerDigits = 12, message = \"Not allowed digit!\")");
        Set<Imports> varImports10 = new HashSet<Imports>();
        varImports10.add(imports9);
        PropertiesAttributes10.setImports(varImports10);
        em.persist(PropertiesAttributes10);
        em.flush();

        PropertiesAttributes PropertiesAttributes11 = new PropertiesAttributes();
        PropertiesAttributes11.setName("@Column");
        PropertiesAttributes11.setValue("@Column");
        Set<Imports> varImports11 = new HashSet<Imports>();
        varImports11.add(imports1);
        PropertiesAttributes11.setImports(varImports11);
        em.persist(PropertiesAttributes11);
        em.flush();

        PropertiesAttributes PropertiesAttributes12 = new PropertiesAttributes();
        PropertiesAttributes12.setName("NullUnique1");
        PropertiesAttributes12.setValue("@Column(nullable = true, unique = true)");
        Set<Imports> varImports12 = new HashSet<Imports>();
        varImports12.add(imports1);
        PropertiesAttributes12.setImports(varImports12);
        em.persist(PropertiesAttributes12);
        em.flush();

        PropertiesAttributes PropertiesAttributes13 = new PropertiesAttributes();
        PropertiesAttributes13.setName("NullUnique2");
        PropertiesAttributes13.setValue("@Column(nullable = true, unique = false)");
        Set<Imports> varImports13 = new HashSet<Imports>();
        varImports13.add(imports1);
        PropertiesAttributes13.setImports(varImports13);
        em.persist(PropertiesAttributes13);
        em.flush();

        PropertiesAttributes PropertiesAttributes14 = new PropertiesAttributes();
        PropertiesAttributes14.setName("NullUnique3");
        PropertiesAttributes14.setValue("@Column(nullable = false, unique = true)");
        Set<Imports> varImports14 = new HashSet<Imports>();
        varImports14.add(imports1);
        PropertiesAttributes14.setImports(varImports14);
        em.persist(PropertiesAttributes14);
        em.flush();

        PropertiesAttributes PropertiesAttributes15 = new PropertiesAttributes();
        PropertiesAttributes15.setName("NullUnique4");
        PropertiesAttributes15.setValue("@Column(nullable = false, unique = false)");
        Set<Imports> varImports15 = new HashSet<Imports>();
        varImports15.add(imports1);
        PropertiesAttributes15.setImports(varImports15);
        em.persist(PropertiesAttributes15);
        em.flush();

        PropertiesAttributes PropertiesAttributes16 = new PropertiesAttributes();
        PropertiesAttributes16.setName("@Basic");
        PropertiesAttributes16.setValue("@Basic");
        Set<Imports> varImports16 = new HashSet<Imports>();
        varImports16.add(imports2);
        PropertiesAttributes16.setImports(varImports16);
        em.persist(PropertiesAttributes16);
        em.flush();

        PropertiesAttributes PropertiesAttributes17 = new PropertiesAttributes();
        PropertiesAttributes17.setName("@Basic1");
        PropertiesAttributes17.setValue("@Basic(fetch=FetchType.LAZY)");
        Set<Imports> varImports17 = new HashSet<Imports>();
        varImports17.add(imports2);
        PropertiesAttributes17.setImports(varImports17);
        em.persist(PropertiesAttributes17);
        em.flush();

        PropertiesAttributes PropertiesAttributes18 = new PropertiesAttributes();
        PropertiesAttributes18.setName("@Lob");
        PropertiesAttributes18.setValue("@Lob");
        Set<Imports> varImports18 = new HashSet<Imports>();
        varImports18.add(imports3);
        PropertiesAttributes18.setImports(varImports18);
        em.persist(PropertiesAttributes18);
        em.flush();

        PropertiesAttributes PropertiesAttributes19 = new PropertiesAttributes();
        PropertiesAttributes19.setName("@Indexed");
        PropertiesAttributes19.setValue("@Indexed");
        Set<Imports> varImports19 = new HashSet<Imports>();
        varImports19.add(imports25);
        PropertiesAttributes19.setImports(varImports19);
        em.persist(PropertiesAttributes19);
        em.flush();

        PropertiesAttributes PropertiesAttributes20 = new PropertiesAttributes();
        PropertiesAttributes20.setName("@DocumentId");
        PropertiesAttributes20.setValue("@DocumentId");
        Set<Imports> varImports20 = new HashSet<Imports>();
        varImports20.add(imports22);
        PropertiesAttributes20.setImports(varImports20 );
        em.persist(PropertiesAttributes20);
        em.flush();

        PropertiesAttributes PropertiesAttributes21 = new PropertiesAttributes();
        PropertiesAttributes21.setName("@Field1");
        PropertiesAttributes21.setValue("@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)");
        Set<Imports> varImports21 = new HashSet<Imports>();
        varImports21.add(imports23);
        varImports21.add(imports24);
        varImports21.add(imports20);
        varImports21.add(imports12);
        PropertiesAttributes21.setImports(varImports21);
        em.persist(PropertiesAttributes21);
        em.flush();

        PropertiesAttributes PropertiesAttributes22 = new PropertiesAttributes();
        PropertiesAttributes22.setName("@Field2");
        PropertiesAttributes22.setValue("@Field(index = Index.YES, analyze = Analyze.YES, store = Store.YES)");
        Set<Imports> varImports22 = new HashSet<Imports>();
        varImports22.add(imports23);
        varImports22.add(imports24);
        varImports22.add(imports20);
        varImports22.add(imports12);
        PropertiesAttributes22.setImports(varImports22);
        em.persist(PropertiesAttributes22);
        em.flush();

        PropertiesAttributes PropertiesAttributes23 = new PropertiesAttributes();
        PropertiesAttributes23.setName("@DateBridgeYE");
        PropertiesAttributes23.setValue("@DateBridge(resolution = Resolution.YEAR)");
        Set<Imports> varImports23 = new HashSet<Imports>();
        varImports23.add(imports11);
        varImports23.add(imports21);
        PropertiesAttributes23.setImports(varImports23);
        em.persist(PropertiesAttributes23);
        em.flush();

        PropertiesAttributes PropertiesAttributes24 = new PropertiesAttributes();
        PropertiesAttributes24.setName("@Embedded");
        PropertiesAttributes24.setValue("@Embedded");
        Set<Imports> varImports24 = new HashSet<Imports>();
        varImports24.add(imports13);
        PropertiesAttributes24.setImports(varImports24);
        em.persist(PropertiesAttributes24);
        em.flush();

        PropertiesAttributes PropertiesAttributes25 = new PropertiesAttributes();
        PropertiesAttributes25.setName("@IndexedEmbedded");
        PropertiesAttributes25.setValue("@IndexedEmbedded");
        Set<Imports> varImports25 = new HashSet<Imports>();
        varImports25.add(imports26);
        PropertiesAttributes25.setImports(varImports25);
        em.persist(PropertiesAttributes25);
        em.flush();

        PropertiesAttributes PropertiesAttributes26 = new PropertiesAttributes();
        PropertiesAttributes26.setName("@Temporal");
        PropertiesAttributes26.setValue("@Temporal(TemporalType.DATE)");
        Set<Imports> varImports26 = new HashSet<Imports>();
        varImports26.add(imports15);
        varImports26.add(imports16);
        PropertiesAttributes26.setImports(varImports26);
        em.persist(PropertiesAttributes26);
        em.flush();

        PropertiesAttributes PropertiesAttributes27 = new PropertiesAttributes();
        PropertiesAttributes27.setName("@DateBridgeMO");
        PropertiesAttributes27.setValue("@DateBridge(resolution = Resolution.MONTH)");
        Set<Imports> varImports27 = new HashSet<Imports>();
        varImports27.add(imports11);
        varImports27.add(imports21);
        PropertiesAttributes27.setImports(varImports27);
        em.persist(PropertiesAttributes27);
        em.flush();

        PropertiesAttributes PropertiesAttributes28 = new PropertiesAttributes();
        PropertiesAttributes28.setName("@DateBridgeDA");
        PropertiesAttributes28.setValue("@DateBridge(resolution = Resolution.DAY)");
        Set<Imports> varImports28 = new HashSet<Imports>();
        varImports28.add(imports11);
        varImports28.add(imports21);
        PropertiesAttributes28.setImports(varImports28);
        em.persist(PropertiesAttributes28);
        em.flush();

        PropertiesAttributes PropertiesAttributes29 = new PropertiesAttributes();
        PropertiesAttributes29.setName("@DateBridgeHO");
        PropertiesAttributes29.setValue("@DateBridge(resolution = Resolution.HOUR)");
        Set<Imports> varImports29 = new HashSet<Imports>();
        varImports29.add(imports11);
        varImports29.add(imports21);
        PropertiesAttributes29.setImports(varImports29);
        em.persist(PropertiesAttributes29);
        em.flush();

        PropertiesAttributes PropertiesAttributes30 = new PropertiesAttributes();
        PropertiesAttributes30.setName("@DateBridgeMI");
        PropertiesAttributes30.setValue("@DateBridge(resolution = Resolution.MINUTE)");
        Set<Imports> varImports30 = new HashSet<Imports>();
        varImports30.add(imports11);
        varImports30.add(imports21);
        PropertiesAttributes30.setImports(varImports30);
        em.persist(PropertiesAttributes30);
        em.flush();

        PropertiesAttributes PropertiesAttributes31 = new PropertiesAttributes();
        PropertiesAttributes31.setName("@DateBridgeSE");
        PropertiesAttributes31.setValue("@DateBridge(resolution = Resolution.SECOND)");
        Set<Imports> varImports31 = new HashSet<Imports>();
        varImports31.add(imports11);
        varImports31.add(imports21);
        PropertiesAttributes31.setImports(varImports31);
        em.persist(PropertiesAttributes31);
        em.flush();

        PropertiesAttributes PropertiesAttributes32 = new PropertiesAttributes();
        PropertiesAttributes32.setName("@DateBridgeML");
        PropertiesAttributes32.setValue("@DateBridge(resolution = Resolution.MILLISECOND)");
        Set<Imports> varImports32 = new HashSet<Imports>();
        varImports32.add(imports11);
        varImports32.add(imports21);
        PropertiesAttributes32.setImports(varImports32);
        em.persist(PropertiesAttributes32);
        em.flush();

        PropertiesAttributes PropertiesAttributes33 = new PropertiesAttributes();
        PropertiesAttributes33.setName("@NumericField");
        PropertiesAttributes33.setValue("@NumericField");
        Set<Imports> varImports33 = new HashSet<Imports>();
        varImports33.add(imports14);
        PropertiesAttributes33.setImports(varImports33);
        em.persist(PropertiesAttributes33);
        em.flush();

//      ---------------------- AttributesTypes ------------------------

        AttributesTypes attributesTypes1 = new AttributesTypes();
        attributesTypes1.setName("Integer");
        attributesTypes1.setType("Integer");
        attributesTypes1.setObservations("An integer numerical type");
        em.persist(attributesTypes1);
        em.flush();

        AttributesTypes attributesTypes2 = new AttributesTypes();
        attributesTypes2.setName("Float");
        attributesTypes2.setType("Float");
        attributesTypes2.setObservations("A floating point numerical type");
        em.persist(attributesTypes2);
        em.flush();

        AttributesTypes attributesTypes3 = new AttributesTypes();
        attributesTypes3.setName("Date");
        attributesTypes3.setType("Date");
        attributesTypes3.setObservations("A calendar date");
        em.persist(attributesTypes3);
        em.flush();

        AttributesTypes attributesTypes4 = new AttributesTypes();
        attributesTypes4.setName("Time");
        attributesTypes4.setType("Date");
        attributesTypes4.setObservations("A temporal instant of time");
        em.persist(attributesTypes4);
        em.flush();

        AttributesTypes attributesTypes5 = new AttributesTypes();
        attributesTypes5.setName("Boolean");
        attributesTypes5.setType("Boolean");
        attributesTypes5.setObservations("A true or false value");
        em.persist(attributesTypes5);
        em.flush();

        AttributesTypes attributesTypes6 = new AttributesTypes();
        attributesTypes6.setName("Enumeration");
        attributesTypes6.setType("Enumeration");
        attributesTypes6.setObservations("A sequence of user-defined values");
        em.persist(attributesTypes6);
        em.flush();

        AttributesTypes attributesTypes7 = new AttributesTypes();
        attributesTypes7.setName("Blob");
        attributesTypes7.setType("Blob");
        attributesTypes7.setObservations("A binanry large object, for example an image or a video, which must be handled in a special way because of its size. Blob type can be further refined by expressing their MIME type for example image/gif");
        em.persist(attributesTypes7);
        em.flush();

        AttributesTypes attributesTypes8 = new AttributesTypes();
        attributesTypes8.setName("Url");
        attributesTypes8.setType("Url");
        attributesTypes8.setObservations("A uniform resource locator of a web resource");
        em.persist(attributesTypes8);
        em.flush();

        AttributesTypes attributesTypes9 = new AttributesTypes();
        attributesTypes9.setName("Text");
        attributesTypes9.setType("String");
        attributesTypes9.setObservations("A long sequence of characters");
        em.persist(attributesTypes9);
        em.flush();

        AttributesTypes attributesTypes10 = new AttributesTypes();
        attributesTypes10.setName("String");
        attributesTypes10.setType("String");
        attributesTypes10.setObservations("A short sequence of characters");
        em.persist(attributesTypes10);
        em.flush();

        AttributesTypes attributesTypes11 = new AttributesTypes();
        attributesTypes11.setName("double");
        attributesTypes11.setType("double");
        attributesTypes11.setObservations("An double numerical type");
        em.persist(attributesTypes11);
        em.flush();

        AttributesTypes attributesTypes12 = new AttributesTypes();
        attributesTypes12.setName("byte");
        attributesTypes12.setType("byte");
        attributesTypes12.setObservations("An byte numerical type");
        Set<PropertiesAttributes> propertiesByte = new HashSet<PropertiesAttributes>();
        propertiesByte.add(PropertiesAttributes18);
        attributesTypes12.setPropertiesAttributes(propertiesByte);
        em.persist(attributesTypes12);
        em.flush();

        AttributesTypes attributesTypes13 = new AttributesTypes();
        attributesTypes13.setName("Email");
        attributesTypes13.setType("Email");
        attributesTypes13.setObservations("An email type");
        em.persist(attributesTypes13);
        em.flush();

//      ---------------------- Cardinalities ------------------------

        Cardinalities cardinalities1 = new Cardinalities();
        cardinalities1.setName("Uno a Uno Unidireccional No.1");
        cardinalities1.setCardinality("1..1");
        cardinalities1.setUnidirectional(true);
        em.persist(cardinalities1);
        em.flush();

        Cardinalities cardinalities2 = new Cardinalities();
        cardinalities2.setName("Uno a Uno Bidirecccional No.2");
        cardinalities2.setCardinality("1..1");
        cardinalities2.setUnidirectional(false);
        em.persist(cardinalities2);
        em.flush();

        Cardinalities cardinalities3 = new Cardinalities();
        cardinalities3.setName("Muchos a Uno Unidireccional No.3");
        cardinalities3.setCardinality("*..1");
        cardinalities3.setUnidirectional(true);
        em.persist(cardinalities3);
        em.flush();

        Cardinalities cardinalities4 = new Cardinalities();
        cardinalities4.setName("Uno a Muchos Unidireccional No.4");
        cardinalities4.setCardinality("1..*");
        cardinalities4.setUnidirectional(true);
        em.persist(cardinalities4);
        em.flush();

        Cardinalities cardinalities5 = new Cardinalities();
        cardinalities5.setName("Uno a Muchos Bidirecccional No.5");
        cardinalities5.setCardinality("1..*");
        cardinalities5.setUnidirectional(false);
        em.persist(cardinalities5);
        em.flush();

        Cardinalities cardinalities6 = new Cardinalities();
        cardinalities6.setName("Muchos a Muchos Unidireccional No.6");
        cardinalities6.setCardinality("*..*");
        cardinalities6.setUnidirectional(true);
        em.persist(cardinalities6);
        em.flush();

        Cardinalities cardinalities7 = new Cardinalities();
        cardinalities7.setName("Muchos a Muchos Bidirecccional No.7");
        cardinalities7.setCardinality("*..*");
        cardinalities7.setUnidirectional(false);
        em.persist(cardinalities7);
        em.flush();

    } // data()

} // Setup
