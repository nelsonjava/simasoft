package co.simasoft.setup;
import co.simasoft.models.naif.domainmodels.*;

import co.simasoft.beans.*;

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

    FindBean findBean = new FindBean();

    public void data() {

//      ---------------------- Dependency ------------------------

        Dependency dependency1 = new Dependency();
        dependency1.setGroupId("javax.persistence");
        dependency1.setArtifactId("persistence-api");
        dependency1.setLink("http://docs.oracle.com/javaee/7/api/javax/persistence/package-summary.html");
        dependency1.setMaven("maven1");
        em.persist(dependency1);
        em.flush();

        Dependency dependency2 = new Dependency();
        dependency2.setGroupId("javax.validation");
        dependency2.setArtifactId("validation-api");
        dependency2.setLink("http://docs.oracle.com/javaee/7/api/javax/validation/package-summary.html");
        dependency2.setMaven("maven2");
        em.persist(dependency2);
        em.flush();

        Dependency dependency3 = new Dependency();
        dependency3.setGroupId("org.hibernate");
        dependency3.setArtifactId("hibernate-validator");
        dependency3.setLink("http://docs.jboss.org/hibernate/validator/5.1/api/");
        dependency3.setMaven("maven3");
        em.persist(dependency3);
        em.flush();

        Dependency dependency4 = new Dependency();
        dependency4.setGroupId("org.hibernate");
        dependency4.setArtifactId("hibernate-search");
        dependency4.setLink("http://docs.jboss.org/hibernate/search/5.2/");
        dependency4.setMaven("maven4");
        em.persist(dependency4);
        em.flush();

//      ---------------------- Imports ------------------------

        Imports imports1 = new Imports();
        imports1.setName("import org.hibernate.validator.constraints.NotEmpty;");
        Dependency dependencyImports1 = new Dependency();
        dependencyImports1 = findBean.idDependency(3L,em);
        imports1.setDependency(dependencyImports1);
        em.persist(imports1);
        em.flush();

        Imports imports2 = new Imports();
        imports2.setName("import org.hibernate.validator.constraints.Email;");
        Dependency dependencyImports2 = new Dependency();
        dependencyImports2 = findBean.idDependency(3L,em);
        imports2.setDependency(dependencyImports2);
        em.persist(imports2);
        em.flush();

        Imports imports3 = new Imports();
        imports3.setName("import java.util.Date;");
        em.persist(imports3);
        em.flush();

        Imports imports4 = new Imports();
        imports4.setName("import org.hibernate.search.annotations.Analyze;");
        Dependency dependencyImports4 = new Dependency();
        dependencyImports4 = findBean.idDependency(188L,em);
        imports4.setDependency(dependencyImports4);
        em.persist(imports4);
        em.flush();

        Imports imports5 = new Imports();
        imports5.setName("import org.hibernate.search.annotations.DateBridge;");
        Dependency dependencyImports5 = new Dependency();
        dependencyImports5 = findBean.idDependency(188L,em);
        imports5.setDependency(dependencyImports5);
        em.persist(imports5);
        em.flush();

        Imports imports6 = new Imports();
        imports6.setName("import org.hibernate.search.annotations.DocumentId;");
        Dependency dependencyImports6 = new Dependency();
        dependencyImports6 = findBean.idDependency(188L,em);
        imports6.setDependency(dependencyImports6);
        em.persist(imports6);
        em.flush();

        Imports imports7 = new Imports();
        imports7.setName("import org.hibernate.search.annotations.Field;");
        Dependency dependencyImports7 = new Dependency();
        dependencyImports7 = findBean.idDependency(188L,em);
        imports7.setDependency(dependencyImports7);
        em.persist(imports7);
        em.flush();

        Imports imports8 = new Imports();
        imports8.setName("import org.hibernate.search.annotations.Index;");
        Dependency dependencyImports8 = new Dependency();
        dependencyImports8 = findBean.idDependency(188L,em);
        imports8.setDependency(dependencyImports8);
        em.persist(imports8);
        em.flush();

        Imports imports9 = new Imports();
        imports9.setName("import org.hibernate.search.annotations.Indexed;");
        Dependency dependencyImports9 = new Dependency();
        dependencyImports9 = findBean.idDependency(188L,em);
        imports9.setDependency(dependencyImports9);
        em.persist(imports9);
        em.flush();

        Imports imports10 = new Imports();
        imports10.setName("import org.hibernate.search.annotations.IndexedEmbedded;");
        Dependency dependencyImports10 = new Dependency();
        dependencyImports10 = findBean.idDependency(188L,em);
        imports10.setDependency(dependencyImports10);
        em.persist(imports10);
        em.flush();

        Imports imports11 = new Imports();
        imports11.setName("import org.hibernate.search.annotations.Resolution;");
        Dependency dependencyImports11 = new Dependency();
        dependencyImports11 = findBean.idDependency(188L,em);
        imports11.setDependency(dependencyImports11);
        em.persist(imports11);
        em.flush();

        Imports imports12 = new Imports();
        imports12.setName("import org.hibernate.search.annotations.Store;");
        Dependency dependencyImports12 = new Dependency();
        dependencyImports12 = findBean.idDependency(188L,em);
        imports12.setDependency(dependencyImports12);
        em.persist(imports12);
        em.flush();

        Imports imports13 = new Imports();
        imports13.setName("import javax.persistence.Embedded;");
        Dependency dependencyImports13 = new Dependency();
        dependencyImports13 = findBean.idDependency(1L,em);
        imports13.setDependency(dependencyImports13);
        em.persist(imports13);
        em.flush();

        Imports imports14 = new Imports();
        imports14.setName("import org.hibernate.search.annotations.NumericField;");
        Dependency dependencyImports14 = new Dependency();
        dependencyImports14 = findBean.idDependency(188L,em);
        imports14.setDependency(dependencyImports14);
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
        imports17.setName("import javax.persistence.Column;");
        Dependency dependencyImports17 = new Dependency();
        dependencyImports17 = findBean.idDependency(1L,em);
        imports17.setDependency(dependencyImports17);
        em.persist(imports17);
        em.flush();

        Imports imports18 = new Imports();
        imports18.setName("import javax.persistence.Basic;");
        Dependency dependencyImports18 = new Dependency();
        dependencyImports18 = findBean.idDependency(1L,em);
        imports18.setDependency(dependencyImports18);
        em.persist(imports18);
        em.flush();

        Imports imports19 = new Imports();
        imports19.setName("import javax.persistence.Lob;");
        Dependency dependencyImports19 = new Dependency();
        dependencyImports19 = findBean.idDependency(1L,em);
        imports19.setDependency(dependencyImports19);
        em.persist(imports19);
        em.flush();

        Imports imports20 = new Imports();
        imports20.setName("import javax.persistence.FetchType;");
        Dependency dependencyImports20 = new Dependency();
        dependencyImports20 = findBean.idDependency(1L,em);
        imports20.setDependency(dependencyImports20);
        em.persist(imports20);
        em.flush();

        Imports imports21 = new Imports();
        imports21.setName("import javax.persistence.CascadeType;");
        Dependency dependencyImports21 = new Dependency();
        dependencyImports21 = findBean.idDependency(1L,em);
        imports21.setDependency(dependencyImports21);
        em.persist(imports21);
        em.flush();

        Imports imports22 = new Imports();
        imports22.setName("import javax.validation.constraints.NotNull;");
        Dependency dependencyImports22 = new Dependency();
        dependencyImports22 = findBean.idDependency(2L,em);
        imports22.setDependency(dependencyImports22);
        em.persist(imports22);
        em.flush();

        Imports imports23 = new Imports();
        imports23.setName("import javax.validation.constraints.Size;");
        Dependency dependencyImports23 = new Dependency();
        dependencyImports23 = findBean.idDependency(2L,em);
        imports23.setDependency(dependencyImports23);
        em.persist(imports23);
        em.flush();

        Imports imports24 = new Imports();
        imports24.setName("import javax.validation.constraints.Pattern;");
        Dependency dependencyImports24 = new Dependency();
        dependencyImports24 = findBean.idDependency(2L,em);
        imports24.setDependency(dependencyImports24);
        em.persist(imports24);
        em.flush();

        Imports imports25 = new Imports();
        imports25.setName("import javax.validation.constraints.Digits;");
        Dependency dependencyImports25 = new Dependency();
        dependencyImports25 = findBean.idDependency(2L,em);
        imports25.setDependency(dependencyImports25);
        em.persist(imports25);
        em.flush();

        Imports imports26 = new Imports();
        imports26.setName("import org.hibernate.validator.Length;");
        Dependency dependencyImports26 = new Dependency();
        dependencyImports26 = findBean.idDependency(3L,em);
        imports26.setDependency(dependencyImports26);
        em.persist(imports26);
        em.flush();

//      ---------------------- AttributesProperties ------------------------

        PropertiesAttributes attributesProperties27 = new PropertiesAttributes();
        attributesProperties27.setName("@NotNull");
        attributesProperties27.setValue("@NotNull");
        em.persist(attributesProperties27);
        em.flush();

        PropertiesAttributes attributesProperties28 = new PropertiesAttributes();
        attributesProperties28.setName("@Size0125");
        attributesProperties28.setValue("@Size(min = 1, max = 25)");
        em.persist(attributesProperties28);
        em.flush();

        PropertiesAttributes attributesProperties29 = new PropertiesAttributes();
        attributesProperties29.setName("@Size0912");
        attributesProperties29.setValue("@Size(min = 9, max = 12)");
        em.persist(attributesProperties29);
        em.flush();

        PropertiesAttributes attributesProperties30 = new PropertiesAttributes();
        attributesProperties30.setName("@Length0125");
        attributesProperties30.setValue("@Length(min = 1, max = 25, message = \"Size must be between 1 and 25 digits\")");
        em.persist(attributesProperties30);
        em.flush();

        PropertiesAttributes attributesProperties31 = new PropertiesAttributes();
        attributesProperties31.setName("@Length0912");
        attributesProperties31.setValue("@Length(min = 9, max = 12, message = \"Size must be between 9 and 12 digits\")");
        em.persist(attributesProperties31);
        em.flush();

        PropertiesAttributes attributesProperties32 = new PropertiesAttributes();
        attributesProperties32.setName("@Pattern1");
        attributesProperties32.setValue("@Pattern(regexp = \"[A-Za-z ]*\", message = \"must contain only letters and spaces\")");
        em.persist(attributesProperties32);
        em.flush();

        PropertiesAttributes attributesProperties33 = new PropertiesAttributes();
        attributesProperties33.setName("@Pattern2");
        attributesProperties33.setValue("@Pattern(regexp = \"[^0-9]*\", message = \"Must not contain numbers\")");
        em.persist(attributesProperties33);
        em.flush();

        PropertiesAttributes attributesProperties34 = new PropertiesAttributes();
        attributesProperties34.setName("@NotEmpty");
        attributesProperties34.setValue("@NotEmpty");
        em.persist(attributesProperties34);
        em.flush();

        PropertiesAttributes attributesProperties35 = new PropertiesAttributes();
        attributesProperties35.setName("@Email");
        attributesProperties35.setValue("@Email(message = \"Invalid format\")");
        em.persist(attributesProperties35);
        em.flush();

        PropertiesAttributes attributesProperties36 = new PropertiesAttributes();
        attributesProperties36.setName("@Digits0012");
        attributesProperties36.setValue("@Digits(fractionalDigits = 0, integerDigits = 12, message = \"Not allowed digit!\")");
        em.persist(attributesProperties36);
        em.flush();

        PropertiesAttributes attributesProperties37 = new PropertiesAttributes();
        attributesProperties37.setName("@Column");
        attributesProperties37.setValue("@Column");
        em.persist(attributesProperties37);
        em.flush();

        PropertiesAttributes attributesProperties38 = new PropertiesAttributes();
        attributesProperties38.setName("NullUnique1");
        attributesProperties38.setValue("@Column(nullable = true, unique = true)");
        em.persist(attributesProperties38);
        em.flush();

        PropertiesAttributes attributesProperties39 = new PropertiesAttributes();
        attributesProperties39.setName("NullUnique2");
        attributesProperties39.setValue("@Column(nullable = true, unique = false)");
        em.persist(attributesProperties39);
        em.flush();

        PropertiesAttributes attributesProperties40 = new PropertiesAttributes();
        attributesProperties40.setName("NullUnique3");
        attributesProperties40.setValue("@Column(nullable = false, unique = true)");
        em.persist(attributesProperties40);
        em.flush();

        PropertiesAttributes attributesProperties41 = new PropertiesAttributes();
        attributesProperties41.setName("NullUnique4");
        attributesProperties41.setValue("@Column(nullable = false, unique = false)");
        em.persist(attributesProperties41);
        em.flush();

        PropertiesAttributes attributesProperties42 = new PropertiesAttributes();
        attributesProperties42.setName("@Basic");
        attributesProperties42.setValue("@Basic");
        em.persist(attributesProperties42);
        em.flush();

        PropertiesAttributes attributesProperties43 = new PropertiesAttributes();
        attributesProperties43.setName("@Basic1");
        attributesProperties43.setValue("@Basic(fetch=FetchType.LAZY)");
        em.persist(attributesProperties43);
        em.flush();

        PropertiesAttributes attributesProperties44 = new PropertiesAttributes();
        attributesProperties44.setName("@Lob");
        attributesProperties44.setValue("@Lob");
        em.persist(attributesProperties44);
        em.flush();

        PropertiesAttributes attributesProperties45 = new PropertiesAttributes();
        attributesProperties45.setName("@Indexed");
        attributesProperties45.setValue("@Indexed");
        em.persist(attributesProperties45);
        em.flush();

        PropertiesAttributes attributesProperties46 = new PropertiesAttributes();
        attributesProperties46.setName("@DocumentId");
        attributesProperties46.setValue("@DocumentId");
        em.persist(attributesProperties46);
        em.flush();

        PropertiesAttributes attributesProperties47 = new PropertiesAttributes();
        attributesProperties47.setName("@DateBridgeSE");
        attributesProperties47.setValue("@DateBridge(resolution = Resolution.SECOND)");
        em.persist(attributesProperties47);
        em.flush();

        PropertiesAttributes attributesProperties48 = new PropertiesAttributes();
        attributesProperties48.setName("@DateBridgeML");
        attributesProperties48.setValue("@DateBridge(resolution = Resolution.MILLISECOND)");
        em.persist(attributesProperties48);
        em.flush();

        PropertiesAttributes attributesProperties49 = new PropertiesAttributes();
        attributesProperties49.setName("@NumericField");
        attributesProperties49.setValue("@NumericField");
        em.persist(attributesProperties49);
        em.flush();

        PropertiesAttributes attributesProperties50 = new PropertiesAttributes();
        attributesProperties50.setName("@Field1");
        attributesProperties50.setValue("@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)");
        em.persist(attributesProperties50);
        em.flush();

        PropertiesAttributes attributesProperties51 = new PropertiesAttributes();
        attributesProperties51.setName("@Field2");
        attributesProperties51.setValue("@Field(index = Index.YES, analyze = Analyze.YES, store = Store.YES)");
        em.persist(attributesProperties51);
        em.flush();

        PropertiesAttributes attributesProperties52 = new PropertiesAttributes();
        attributesProperties52.setName("@DateBridgeYE");
        attributesProperties52.setValue("@DateBridge(resolution = Resolution.YEAR)");
        em.persist(attributesProperties52);
        em.flush();

        PropertiesAttributes attributesProperties53 = new PropertiesAttributes();
        attributesProperties53.setName("@Embedded");
        attributesProperties53.setValue("@Embedded");
        em.persist(attributesProperties53);
        em.flush();

        PropertiesAttributes attributesProperties54 = new PropertiesAttributes();
        attributesProperties54.setName("@IndexedEmbedded");
        attributesProperties54.setValue("@IndexedEmbedded");
        em.persist(attributesProperties54);
        em.flush();

        PropertiesAttributes attributesProperties55 = new PropertiesAttributes();
        attributesProperties55.setName("@Temporal");
        attributesProperties55.setValue("@Temporal(TemporalType.DATE)");
        em.persist(attributesProperties55);
        em.flush();

        PropertiesAttributes attributesProperties56 = new PropertiesAttributes();
        attributesProperties56.setName("@DateBridgeMO");
        attributesProperties56.setValue("@DateBridge(resolution = Resolution.MONTH)");
        em.persist(attributesProperties56);
        em.flush();

        PropertiesAttributes attributesProperties57 = new PropertiesAttributes();
        attributesProperties57.setName("@DateBridgeDA");
        attributesProperties57.setValue("@DateBridge(resolution = Resolution.DAY)");
        em.persist(attributesProperties57);
        em.flush();

        PropertiesAttributes attributesProperties58 = new PropertiesAttributes();
        attributesProperties58.setName("@DateBridgeHO");
        attributesProperties58.setValue("@DateBridge(resolution = Resolution.HOUR)");
        em.persist(attributesProperties58);
        em.flush();

        PropertiesAttributes attributesProperties59 = new PropertiesAttributes();
        attributesProperties59.setName("@DateBridgeMI");
        attributesProperties59.setValue("@DateBridge(resolution = Resolution.MINUTE)");
        em.persist(attributesProperties59);
        em.flush();

//      ---------------------- AttributesTypes ------------------------

        AttributesTypes attributesTypes1 = new AttributesTypes();
        attributesTypes1.setName("String");
        attributesTypes1.setType("String");
        attributesTypes1.setObservations("A \"short\" sequence of characters");

        Set<PropertiesAttributes> attributesTypesAttributesProperties1 = new HashSet<PropertiesAttributes>();
//      ...................... @Field1........................
        PropertiesAttributes attributeTypeAttributeProperty1 = findBean.idAttributesProperties(200L,em);
        attributesTypesAttributesProperties1.add(attributeTypeAttributeProperty1);
        attributesTypes1.setPropertiesAttributes(attributesTypesAttributesProperties1);

        em.persist(attributesTypes1);
        em.flush();

        AttributesTypes attributesTypes2 = new AttributesTypes();
        attributesTypes2.setName("Text");
        attributesTypes2.setType("String");
        attributesTypes2.setObservations("A \"long\" sequence of characters");

        Set<PropertiesAttributes> attributesTypesAttributesProperties2 = new HashSet<PropertiesAttributes>();
//      ...................... @Field1........................
        PropertiesAttributes attributeTypeAttributeProperty2 = findBean.idAttributesProperties(200L,em);
        attributesTypesAttributesProperties2.add(attributeTypeAttributeProperty2);
//      ...................... @Lob........................
        PropertiesAttributes attributeTypeAttributeProperty3 = findBean.idAttributesProperties(41L,em);
        attributesTypesAttributesProperties2.add(attributeTypeAttributeProperty3);
        attributesTypes2.setPropertiesAttributes(attributesTypesAttributesProperties2);

        em.persist(attributesTypes2);
        em.flush();

        AttributesTypes attributesTypes3 = new AttributesTypes();
        attributesTypes3.setName("Integer");
        attributesTypes3.setType("Integer");
        attributesTypes3.setObservations("An integer numerical type");
        em.persist(attributesTypes3);
        em.flush();

        AttributesTypes attributesTypes4 = new AttributesTypes();
        attributesTypes4.setName("byte");
        attributesTypes4.setType("byte");
        attributesTypes4.setObservations("A uniform resource locator of a web resource");

        Set<PropertiesAttributes> attributesTypesAttributesProperties4 = new HashSet<PropertiesAttributes>();
//      ...................... @Basic1........................
        PropertiesAttributes attributeTypeAttributeProperty4 = findBean.idAttributesProperties(40L,em);
        attributesTypesAttributesProperties4.add(attributeTypeAttributeProperty4);
//      ...................... @Lob........................
        PropertiesAttributes attributeTypeAttributeProperty5 = findBean.idAttributesProperties(41L,em);
        attributesTypesAttributesProperties4.add(attributeTypeAttributeProperty5);
        attributesTypes4.setPropertiesAttributes(attributesTypesAttributesProperties4);

        em.persist(attributesTypes4);
        em.flush();

        AttributesTypes attributesTypes5 = new AttributesTypes();
        attributesTypes5.setName("Float");
        attributesTypes5.setType("Float");
        attributesTypes5.setObservations("A floating point numerical type");
        em.persist(attributesTypes5);
        em.flush();

        AttributesTypes attributesTypes6 = new AttributesTypes();
        attributesTypes6.setName("double");
        attributesTypes6.setType("double");
        attributesTypes6.setObservations("A uniform resource locator of a web resource");

        Set<PropertiesAttributes> attributesTypesAttributesProperties6 = new HashSet<PropertiesAttributes>();
//      ...................... @NumericField........................
        PropertiesAttributes attributeTypeAttributeProperty6 = findBean.idAttributesProperties(215L,em);
        attributesTypesAttributesProperties6.add(attributeTypeAttributeProperty6);
//      ...................... @Field1........................
        PropertiesAttributes attributeTypeAttributeProperty7 = findBean.idAttributesProperties(200L,em);
        attributesTypesAttributesProperties6.add(attributeTypeAttributeProperty7);
        attributesTypes6.setPropertiesAttributes(attributesTypesAttributesProperties6);

        em.persist(attributesTypes6);
        em.flush();

        AttributesTypes attributesTypes7 = new AttributesTypes();
        attributesTypes7.setName("Date");
        attributesTypes7.setType("Date");
        attributesTypes7.setObservations("A calendar date");

        Set<PropertiesAttributes> attributesTypesAttributesProperties7 = new HashSet<PropertiesAttributes>();
//      ...................... @Temporal........................
        PropertiesAttributes attributeTypeAttributeProperty8 = findBean.idAttributesProperties(208L,em);
        attributesTypesAttributesProperties7.add(attributeTypeAttributeProperty8);
//      ...................... @DateBridgeYE........................
        PropertiesAttributes attributeTypeAttributeProperty9 = findBean.idAttributesProperties(202L,em);
        attributesTypesAttributesProperties7.add(attributeTypeAttributeProperty9);
        attributesTypes7.setPropertiesAttributes(attributesTypesAttributesProperties7);

        em.persist(attributesTypes7);
        em.flush();

        AttributesTypes attributesTypes8 = new AttributesTypes();
        attributesTypes8.setName("Email");
        attributesTypes8.setType("Email");
        attributesTypes8.setObservations("A uniform resource locator of a web resource");
        em.persist(attributesTypes8);
        em.flush();

        AttributesTypes attributesTypes9 = new AttributesTypes();
        attributesTypes9.setName("Time");
        attributesTypes9.setType("Date");
        attributesTypes9.setObservations("A temporal instant of time");
        em.persist(attributesTypes9);
        em.flush();

        AttributesTypes attributesTypes10 = new AttributesTypes();
        attributesTypes10.setName("Boolean");
        attributesTypes10.setType("Boolean");
        attributesTypes10.setObservations("A true or false value");
        em.persist(attributesTypes10);
        em.flush();

        AttributesTypes attributesTypes11 = new AttributesTypes();
        attributesTypes11.setName("Enumeration");
        attributesTypes11.setType("Enumeration");
        attributesTypes11.setObservations("A sequence of user-defined values");
        em.persist(attributesTypes11);
        em.flush();

        AttributesTypes attributesTypes12 = new AttributesTypes();
        attributesTypes12.setName("Blob");
        attributesTypes12.setType("Blob");
        attributesTypes12.setObservations("A binanry large object, for example an image or a video, which must be handled in a special way because of its size. Blob type can be further refined by expressing their MIME type for example image/gif");
        em.persist(attributesTypes12);
        em.flush();

        AttributesTypes attributesTypes13 = new AttributesTypes();
        attributesTypes13.setName("Url");
        attributesTypes13.setType("Url");
        attributesTypes13.setObservations("A uniform resource locator of a web resource");
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
