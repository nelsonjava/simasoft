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

    } // data()

//      ---------------------- Dependency ------------------------

        Dependency dependency1 = new Dependency();
        dependency1.setGroupId("javax.persistence");
        dependency1.setArtifactId("persistence-api");
        em.persist(dependency1);
        em.flush();

        Dependency dependency2 = new Dependency();
        dependency2.setGroupId("javax.validation");
        dependency2.setArtifactId("validation-api");
        em.persist(dependency2);
        em.flush();

        Dependency dependency3 = new Dependency();
        dependency3.setGroupId("org.hibernate");
        dependency3.setArtifactId("hibernate-validator");
        em.persist(dependency3);
        em.flush();

        Dependency dependency4 = new Dependency();
        dependency4.setGroupId("org.hibernate");
        dependency4.setArtifactId("hibernate-search");
        em.persist(dependency4);
        em.flush();

//      ---------------------- Imports ------------------------

        Imports imports1 = new Imports();
        imports1.setName("import javax.persistence.Column;");
        em.persist(imports1);
        em.flush();

        Imports imports2 = new Imports();
        imports2.setName("import javax.persistence.Basic;");
        em.persist(imports2);
        em.flush();

        Imports imports3 = new Imports();
        imports3.setName("import javax.persistence.Lob;");
        em.persist(imports3);
        em.flush();

        Imports imports4 = new Imports();
        imports4.setName("import javax.persistence.FetchType;");
        em.persist(imports4);
        em.flush();

        Imports imports5 = new Imports();
        imports5.setName("import javax.persistence.CascadeType;");
        em.persist(imports5);
        em.flush();

        Imports imports6 = new Imports();
        imports6.setName("import javax.validation.constraints.NotNull;");
        em.persist(imports6);
        em.flush();

        Imports imports7 = new Imports();
        imports7.setName("import javax.validation.constraints.Size;");
        em.persist(imports7);
        em.flush();

        Imports imports8 = new Imports();
        imports8.setName("import javax.validation.constraints.Pattern;");
        em.persist(imports8);
        em.flush();

        Imports imports9 = new Imports();
        imports9.setName("import javax.validation.constraints.Digits;");
        em.persist(imports9);
        em.flush();

        Imports imports10 = new Imports();
        imports10.setName("import org.hibernate.validator.Length;");
        em.persist(imports10);
        em.flush();

        Imports imports11 = new Imports();
        imports11.setName("import org.hibernate.search.annotations.Resolution;");
        em.persist(imports11);
        em.flush();

        Imports imports12 = new Imports();
        imports12.setName("import org.hibernate.search.annotations.Store;");
        em.persist(imports12);
        em.flush();

        Imports imports13 = new Imports();
        imports13.setName("import javax.persistence.Embedded;");
        em.persist(imports13);
        em.flush();

        Imports imports14 = new Imports();
        imports14.setName("import org.hibernate.search.annotations.NumericField;");
        em.persist(imports14);
        em.flush();

        Imports imports15 = new Imports();
        imports15.setName("import javax.persistence.Temporal;");
        em.persist(imports15);
        em.flush();

        Imports imports16 = new Imports();
        imports16.setName("import javax.persistence.TemporalType;");
        em.persist(imports16);
        em.flush();

        Imports imports17 = new Imports();
        imports17.setName("import org.hibernate.validator.constraints.NotEmpty;");
        em.persist(imports17);
        em.flush();

        Imports imports18 = new Imports();
        imports18.setName("import org.hibernate.validator.constraints.Email;");
        em.persist(imports18);
        em.flush();

        Imports imports19 = new Imports();
        imports19.setName("import java.util.Date;");
        em.persist(imports19);
        em.flush();

        Imports imports20 = new Imports();
        imports20.setName("import org.hibernate.search.annotations.Analyze;");
        em.persist(imports20);
        em.flush();

        Imports imports21 = new Imports();
        imports21.setName("import org.hibernate.search.annotations.DateBridge;");
        em.persist(imports21);
        em.flush();

        Imports imports22 = new Imports();
        imports22.setName("import org.hibernate.search.annotations.DocumentId;");
        em.persist(imports22);
        em.flush();

        Imports imports23 = new Imports();
        imports23.setName("import org.hibernate.search.annotations.Field;");
        em.persist(imports23);
        em.flush();

        Imports imports24 = new Imports();
        imports24.setName("import org.hibernate.search.annotations.Index;");
        em.persist(imports24);
        em.flush();

        Imports imports25 = new Imports();
        imports25.setName("import org.hibernate.search.annotations.Indexed;");
        em.persist(imports25);
        em.flush();

        Imports imports26 = new Imports();
        imports26.setName("import org.hibernate.search.annotations.IndexedEmbedded;");
        em.persist(imports26);
        em.flush();
        
//      ---------------------- AttributesProperties ------------------------

        AttributesProperties attributesProperties1 = new AttributesTypes();
        attributesProperties1.setName("@NotNull");
        attributesProperties1.setCardinality("@NotNull");
        em.persist(attributesProperties1);
        em.flush();

        AttributesProperties attributesProperties2 = new AttributesTypes();
        attributesProperties2.setName("@Size0125");
        attributesProperties2.setCardinality("@Size(min = 1, max = 25)");
        em.persist(attributesProperties2);
        em.flush();

        AttributesProperties attributesProperties3 = new AttributesTypes();
        attributesProperties3.setName("@Size0912");
        attributesProperties3.setCardinality("@Size(min = 9, max = 12)");
        em.persist(attributesProperties3);
        em.flush();

        AttributesProperties attributesProperties4 = new AttributesTypes();
        attributesProperties4.setName("@Length0125");
        attributesProperties4.setCardinality("@Length(min = 1, max = 25, message = "Size must be between 1 and 25 digits")");
        em.persist(attributesProperties4);
        em.flush();

        AttributesProperties attributesProperties5 = new AttributesTypes();
        attributesProperties5.setName("@Length0912");
        attributesProperties5.setCardinality("@Length(min = 9, max = 12, message = "Size must be between 9 and 12 digits")");
        em.persist(attributesProperties5);
        em.flush();

        AttributesProperties attributesProperties6 = new AttributesTypes();
        attributesProperties6.setName("@Pattern1");
        attributesProperties6.setCardinality("@Pattern(regexp = "[A-Za-z ]*", message = "must contain only letters and spaces")");
        em.persist(attributesProperties6);
        em.flush();

        AttributesProperties attributesProperties7 = new AttributesTypes();
        attributesProperties7.setName("@Pattern2");
        attributesProperties7.setCardinality("@Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")");
        em.persist(attributesProperties7);
        em.flush();

        AttributesProperties attributesProperties8 = new AttributesTypes();
        attributesProperties8.setName("@NotEmpty");
        attributesProperties8.setCardinality("@NotEmpty");
        em.persist(attributesProperties8);
        em.flush();

        AttributesProperties attributesProperties9 = new AttributesTypes();
        attributesProperties9.setName("@Email");
        attributesProperties9.setCardinality("@Email(message = "Invalid format")");
        em.persist(attributesProperties9);
        em.flush();

        AttributesProperties attributesProperties10 = new AttributesTypes();
        attributesProperties10.setName("@Digits0012");
        attributesProperties10.setCardinality("@Digits(fractionalDigits = 0, integerDigits = 12, message = "Not allowed digit!")");
        em.persist(attributesProperties10);
        em.flush();

        AttributesProperties attributesProperties11 = new AttributesTypes();
        attributesProperties11.setName("@Column");
        attributesProperties11.setCardinality("@Column");
        em.persist(attributesProperties11);
        em.flush();

        AttributesProperties attributesProperties12 = new AttributesTypes();
        attributesProperties12.setName("NullUnique1");
        attributesProperties12.setCardinality("@Column(nullable = true, unique = true)");
        em.persist(attributesProperties12);
        em.flush();

        AttributesProperties attributesProperties13 = new AttributesTypes();
        attributesProperties13.setName("NullUnique2");
        attributesProperties13.setCardinality("@Column(nullable = true, unique = false)");
        em.persist(attributesProperties13);
        em.flush();

        AttributesProperties attributesProperties14 = new AttributesTypes();
        attributesProperties14.setName("NullUnique3");
        attributesProperties14.setCardinality("@Column(nullable = false, unique = true)");
        em.persist(attributesProperties14);
        em.flush();

        AttributesProperties attributesProperties15 = new AttributesTypes();
        attributesProperties15.setName("NullUnique4");
        attributesProperties15.setCardinality("@Column(nullable = false, unique = false)");
        em.persist(attributesProperties15);
        em.flush();

        AttributesProperties attributesProperties16 = new AttributesTypes();
        attributesProperties16.setName("@Basic");
        attributesProperties16.setCardinality("@Basic");
        em.persist(attributesProperties16);
        em.flush();

        AttributesProperties attributesProperties17 = new AttributesTypes();
        attributesProperties17.setName("@Basic1");
        attributesProperties17.setCardinality("@Basic(fetch=FetchType.LAZY)");
        em.persist(attributesProperties17);
        em.flush();

        AttributesProperties attributesProperties18 = new AttributesTypes();
        attributesProperties18.setName("@Lob");
        attributesProperties18.setCardinality("@Lob");
        em.persist(attributesProperties18);
        em.flush();

        AttributesProperties attributesProperties19 = new AttributesTypes();
        attributesProperties19.setName("@Indexed");
        attributesProperties19.setCardinality("@Indexed");
        em.persist(attributesProperties19);
        em.flush();

        AttributesProperties attributesProperties20 = new AttributesTypes();
        attributesProperties20.setName("@DocumentId");
        attributesProperties20.setCardinality("@DocumentId");
        em.persist(attributesProperties20);
        em.flush();

        AttributesProperties attributesProperties21 = new AttributesTypes();
        attributesProperties21.setName("@Field1");
        attributesProperties21.setCardinality("@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)");
        em.persist(attributesProperties21);
        em.flush();

        AttributesProperties attributesProperties22 = new AttributesTypes();
        attributesProperties22.setName("@Field2");
        attributesProperties22.setCardinality("@Field(index = Index.YES, analyze = Analyze.YES, store = Store.YES)");
        em.persist(attributesProperties22);
        em.flush();

        AttributesProperties attributesProperties23 = new AttributesTypes();
        attributesProperties23.setName("@DateBridgeYE");
        attributesProperties23.setCardinality("@DateBridge(resolution = Resolution.YEAR)");
        em.persist(attributesProperties23);
        em.flush();

        AttributesProperties attributesProperties24 = new AttributesTypes();
        attributesProperties24.setName("@Embedded");
        attributesProperties24.setCardinality("@Embedded");
        em.persist(attributesProperties24);
        em.flush();

        AttributesProperties attributesProperties25 = new AttributesTypes();
        attributesProperties25.setName("@IndexedEmbedded");
        attributesProperties25.setCardinality("@IndexedEmbedded");
        em.persist(attributesProperties25);
        em.flush();

        AttributesProperties attributesProperties26 = new AttributesTypes();
        attributesProperties26.setName("@Temporal");
        attributesProperties26.setCardinality("@Temporal(TemporalType.DATE)");
        em.persist(attributesProperties26);
        em.flush();

        AttributesProperties attributesProperties27 = new AttributesTypes();
        attributesProperties27.setName("@DateBridgeMO");
        attributesProperties27.setCardinality("@DateBridge(resolution = Resolution.MONTH)");
        em.persist(attributesProperties27);
        em.flush();

        AttributesProperties attributesProperties28 = new AttributesTypes();
        attributesProperties28.setName("@DateBridgeDA");
        attributesProperties28.setCardinality("@DateBridge(resolution = Resolution.DAY)");
        em.persist(attributesProperties28);
        em.flush();

        AttributesProperties attributesProperties29 = new AttributesTypes();
        attributesProperties29.setName("@DateBridgeHO");
        attributesProperties29.setCardinality("@DateBridge(resolution = Resolution.HOUR)");
        em.persist(attributesProperties29);
        em.flush();

        AttributesProperties attributesProperties30 = new AttributesTypes();
        attributesProperties30.setName("@DateBridgeMI");
        attributesProperties30.setCardinality("@DateBridge(resolution = Resolution.MINUTE)");
        em.persist(attributesProperties30);
        em.flush();

        AttributesProperties attributesProperties31 = new AttributesTypes();
        attributesProperties31.setName("@DateBridgeSE");
        attributesProperties31.setCardinality("@DateBridge(resolution = Resolution.SECOND)");
        em.persist(attributesProperties31);
        em.flush();

        AttributesProperties attributesProperties32 = new AttributesTypes();
        attributesProperties32.setName("@DateBridgeML");
        attributesProperties32.setCardinality("@DateBridge(resolution = Resolution.MILLISECOND)");
        em.persist(attributesProperties32);
        em.flush();

        AttributesProperties attributesProperties33 = new AttributesTypes();
        attributesProperties33.setName("@NumericField");
        attributesProperties33.setCardinality("@NumericField");
        em.persist(attributesProperties33);
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
        em.persist(attributesTypes12);
        em.flush();

        AttributesTypes attributesTypes13 = new AttributesTypes();
        attributesTypes13.setName("Email");
        attributesTypes13.setType("Email");
        attributesTypes13.setObservations("An email type");
        em.persist(attributesTypes13);
        em.flush();

//      ---------------------- Cardinalities ------------------------

        Cardinalities cardinalities1 = new AttributesTypes();
        cardinalities1.setName("Uno a Uno Unidireccional No.1");
        cardinalities1.setCardinality("1..1");
        cardinalities1.setUnidirectional("true");
        em.persist(cardinalities1);
        em.flush();

        Cardinalities cardinalities2 = new AttributesTypes();
        cardinalities2.setName("Uno a Uno Bidirecccional No.2");
        cardinalities2.setCardinality("1..1");
        cardinalities2.setUnidirectional("false");
        em.persist(cardinalities2);
        em.flush();

        Cardinalities cardinalities3 = new AttributesTypes();
        cardinalities3.setName("Muchos a Uno Unidireccional No.3");
        cardinalities3.setCardinality("*..1");
        cardinalities3.setUnidirectional("true");
        em.persist(cardinalities3);
        em.flush();

        Cardinalities cardinalities4 = new AttributesTypes();
        cardinalities4.setName("Uno a Muchos Unidireccional No.4");
        cardinalities4.setCardinality("1..*");
        cardinalities4.setUnidirectional("true");
        em.persist(cardinalities4);
        em.flush();

        Cardinalities cardinalities5 = new AttributesTypes();
        cardinalities5.setName("Uno a Muchos Bidirecccional No.5");
        cardinalities5.setCardinality("1..*");
        cardinalities5.setUnidirectional("false");
        em.persist(cardinalities5);
        em.flush();

        Cardinalities cardinalities6 = new AttributesTypes();
        cardinalities6.setName("Muchos a Muchos Unidireccional No.6");
        cardinalities6.setCardinality("*..*");
        cardinalities6.setUnidirectional("true");
        em.persist(cardinalities6);
        em.flush();

        Cardinalities cardinalities7 = new AttributesTypes();
        cardinalities7.setName("Muchos a Muchos Bidirecccional No.7");
        cardinalities7.setCardinality("*..*");
        cardinalities7.setUnidirectional("false");
        em.persist(cardinalities7);
        em.flush();

} // Setup
