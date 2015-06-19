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
        dependency1.setMaven("maven");
        em.persist(dependency1);
        em.flush();

        Dependency dependency2 = new Dependency();
        dependency2.setGroupId("javax.validation");
        dependency2.setArtifactId("validation-api");
        dependency2.setLink("http://docs.oracle.com/javaee/7/api/javax/validation/package-summary.html");
        dependency2.setMaven("maven");
        em.persist(dependency2);
        em.flush();

        Dependency dependency3 = new Dependency();
        dependency3.setGroupId("org.hibernate");
        dependency3.setArtifactId("hibernate-validator");
        dependency3.setLink("http://docs.jboss.org/hibernate/validator/5.1/api/");
        dependency3.setMaven("maven");
        em.persist(dependency3);
        em.flush();

        Dependency dependency4 = new Dependency();
        dependency4.setGroupId("org.hibernate");
        dependency4.setArtifactId("hibernate-search");
        dependency4.setLink("http://docs.jboss.org/hibernate/search/5.2/");
        dependency4.setMaven("maven");
        em.persist(dependency4);
        em.flush();

//      ---------------------- Imports ------------------------

        Imports imports1 = new Imports();
        imports1.setName("import javax.persistence.Column;");
        Dependency dependencyImports1 = new Dependency();
        dependencyImports1 = findBean.artifactIdDependency("persistence-api",em);
        imports1.setDependency(dependencyImports1);
        em.persist(imports1);
        em.flush();

        Imports imports2 = new Imports();
        imports2.setName("import javax.persistence.Basic;");
        Dependency dependencyImports2 = new Dependency();
        dependencyImports2 = findBean.artifactIdDependency("persistence-api",em);
        imports2.setDependency(dependencyImports2);
        em.persist(imports2);
        em.flush();

        Imports imports3 = new Imports();
        imports3.setName("import javax.persistence.Lob;");
        Dependency dependencyImports3 = new Dependency();
        dependencyImports3 = findBean.artifactIdDependency("persistence-api",em);
        imports3.setDependency(dependencyImports3);
        em.persist(imports3);
        em.flush();

        Imports imports4 = new Imports();
        imports4.setName("import javax.persistence.FetchType;");
        Dependency dependencyImports4 = new Dependency();
        dependencyImports4 = findBean.artifactIdDependency("persistence-api",em);
        imports4.setDependency(dependencyImports4);
        em.persist(imports4);
        em.flush();

        Imports imports5 = new Imports();
        imports5.setName("import javax.persistence.CascadeType;");
        Dependency dependencyImports5 = new Dependency();
        dependencyImports5 = findBean.artifactIdDependency("persistence-api",em);
        imports5.setDependency(dependencyImports5);
        em.persist(imports5);
        em.flush();

        Imports imports6 = new Imports();
        imports6.setName("import javax.validation.constraints.NotNull;");
        Dependency dependencyImports6 = new Dependency();
        dependencyImports6 = findBean.artifactIdDependency("validation-api",em);
        imports6.setDependency(dependencyImports6);
        em.persist(imports6);
        em.flush();

        Imports imports7 = new Imports();
        imports7.setName("import javax.validation.constraints.Size;");
        Dependency dependencyImports7 = new Dependency();
        dependencyImports7 = findBean.artifactIdDependency("validation-api",em);
        imports7.setDependency(dependencyImports7);
        em.persist(imports7);
        em.flush();

        Imports imports8 = new Imports();
        imports8.setName("import javax.validation.constraints.Pattern;");
        Dependency dependencyImports8 = new Dependency();
        dependencyImports8 = findBean.artifactIdDependency("validation-api",em);
        imports8.setDependency(dependencyImports8);
        em.persist(imports8);
        em.flush();

        Imports imports9 = new Imports();
        imports9.setName("import javax.validation.constraints.Digits;");
        Dependency dependencyImports9 = new Dependency();
        dependencyImports9 = findBean.artifactIdDependency("validation-api",em);
        imports9.setDependency(dependencyImports9);
        em.persist(imports9);
        em.flush();

        Imports imports10 = new Imports();
        imports10.setName("import org.hibernate.validator.Length;");
        Dependency dependencyImports10 = new Dependency();
        dependencyImports10 = findBean.artifactIdDependency("hibernate-validator",em);
        imports10.setDependency(dependencyImports10);
        em.persist(imports10);
        em.flush();

        Imports imports11 = new Imports();
        imports11.setName("import org.hibernate.search.annotations.Resolution;");
        Dependency dependencyImports11 = new Dependency();
        dependencyImports11 = findBean.artifactIdDependency("hibernate-search",em);
        imports11.setDependency(dependencyImports11);
        em.persist(imports11);
        em.flush();

        Imports imports12 = new Imports();
        imports12.setName("import org.hibernate.search.annotations.Store;");
        Dependency dependencyImports12 = new Dependency();
        dependencyImports12 = findBean.artifactIdDependency("hibernate-search",em);
        imports12.setDependency(dependencyImports12);
        em.persist(imports12);
        em.flush();

        Imports imports13 = new Imports();
        imports13.setName("import javax.persistence.Embedded;");
        Dependency dependencyImports13 = new Dependency();
        dependencyImports13 = findBean.artifactIdDependency("persistence-api",em);
        imports13.setDependency(dependencyImports13);
        em.persist(imports13);
        em.flush();

        Imports imports14 = new Imports();
        imports14.setName("import org.hibernate.search.annotations.NumericField;");
        Dependency dependencyImports14 = new Dependency();
        dependencyImports14 = findBean.artifactIdDependency("hibernate-search",em);
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
        imports17.setName("import org.hibernate.validator.constraints.NotEmpty;");
        Dependency dependencyImports17 = new Dependency();
        dependencyImports17 = findBean.artifactIdDependency("hibernate-validator",em);
        imports17.setDependency(dependencyImports17);
        em.persist(imports17);
        em.flush();

        Imports imports18 = new Imports();
        imports18.setName("import org.hibernate.validator.constraints.Email;");
        Dependency dependencyImports18 = new Dependency();
        dependencyImports18 = findBean.artifactIdDependency("hibernate-validator",em);
        imports18.setDependency(dependencyImports18);
        em.persist(imports18);
        em.flush();

        Imports imports19 = new Imports();
        imports19.setName("import java.util.Date;");
        em.persist(imports19);
        em.flush();

        Imports imports20 = new Imports();
        imports20.setName("import org.hibernate.search.annotations.Analyze;");
        Dependency dependencyImports20 = new Dependency();
        dependencyImports20 = findBean.artifactIdDependency("hibernate-search",em);
        imports20.setDependency(dependencyImports20);
        em.persist(imports20);
        em.flush();

        Imports imports21 = new Imports();
        imports21.setName("import org.hibernate.search.annotations.DateBridge;");
        Dependency dependencyImports21 = new Dependency();
        dependencyImports21 = findBean.artifactIdDependency("hibernate-search",em);
        imports21.setDependency(dependencyImports21);
        em.persist(imports21);
        em.flush();

        Imports imports22 = new Imports();
        imports22.setName("import org.hibernate.search.annotations.DocumentId;");
        Dependency dependencyImports22 = new Dependency();
        dependencyImports22 = findBean.artifactIdDependency("hibernate-search",em);
        imports22.setDependency(dependencyImports22);
        em.persist(imports22);
        em.flush();

        Imports imports23 = new Imports();
        imports23.setName("import org.hibernate.search.annotations.Field;");
        Dependency dependencyImports23 = new Dependency();
        dependencyImports23 = findBean.artifactIdDependency("hibernate-search",em);
        imports23.setDependency(dependencyImports23);
        em.persist(imports23);
        em.flush();

        Imports imports24 = new Imports();
        imports24.setName("import org.hibernate.search.annotations.Index;");
        Dependency dependencyImports24 = new Dependency();
        dependencyImports24 = findBean.artifactIdDependency("hibernate-search",em);
        imports24.setDependency(dependencyImports24);
        em.persist(imports24);
        em.flush();

        Imports imports25 = new Imports();
        imports25.setName("import org.hibernate.search.annotations.Indexed;");
        Dependency dependencyImports25 = new Dependency();
        dependencyImports25 = findBean.artifactIdDependency("hibernate-search",em);
        imports25.setDependency(dependencyImports25);
        em.persist(imports25);
        em.flush();

        Imports imports26 = new Imports();
        imports26.setName("import org.hibernate.search.annotations.IndexedEmbedded;");
        Dependency dependencyImports26 = new Dependency();
        dependencyImports26 = findBean.artifactIdDependency("hibernate-search",em);
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
        attributesProperties37.setName("@DateBridgeSE");
        attributesProperties37.setValue("@DateBridge(resolution = Resolution.SECOND)");
        em.persist(attributesProperties37);
        em.flush();

        PropertiesAttributes attributesProperties38 = new PropertiesAttributes();
        attributesProperties38.setName("@DateBridgeML");
        attributesProperties38.setValue("@DateBridge(resolution = Resolution.MILLISECOND)");
        em.persist(attributesProperties38);
        em.flush();

        PropertiesAttributes attributesProperties39 = new PropertiesAttributes();
        attributesProperties39.setName("@NumericField");
        attributesProperties39.setValue("@NumericField");
        em.persist(attributesProperties39);
        em.flush();

        PropertiesAttributes attributesProperties40 = new PropertiesAttributes();
        attributesProperties40.setName("@Field1");
        attributesProperties40.setValue("@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)");
        em.persist(attributesProperties40);
        em.flush();

        PropertiesAttributes attributesProperties41 = new PropertiesAttributes();
        attributesProperties41.setName("@Field2");
        attributesProperties41.setValue("@Field(index = Index.YES, analyze = Analyze.YES, store = Store.YES)");
        em.persist(attributesProperties41);
        em.flush();

        PropertiesAttributes attributesProperties42 = new PropertiesAttributes();
        attributesProperties42.setName("@DateBridgeYE");
        attributesProperties42.setValue("@DateBridge(resolution = Resolution.YEAR)");
        em.persist(attributesProperties42);
        em.flush();

        PropertiesAttributes attributesProperties43 = new PropertiesAttributes();
        attributesProperties43.setName("@Embedded");
        attributesProperties43.setValue("@Embedded");
        em.persist(attributesProperties43);
        em.flush();

        PropertiesAttributes attributesProperties44 = new PropertiesAttributes();
        attributesProperties44.setName("@IndexedEmbedded");
        attributesProperties44.setValue("@IndexedEmbedded");
        em.persist(attributesProperties44);
        em.flush();

        PropertiesAttributes attributesProperties45 = new PropertiesAttributes();
        attributesProperties45.setName("@Temporal");
        attributesProperties45.setValue("@Temporal(TemporalType.DATE)");
        em.persist(attributesProperties45);
        em.flush();

        PropertiesAttributes attributesProperties46 = new PropertiesAttributes();
        attributesProperties46.setName("@DateBridgeMO");
        attributesProperties46.setValue("@DateBridge(resolution = Resolution.MONTH)");
        em.persist(attributesProperties46);
        em.flush();

        PropertiesAttributes attributesProperties47 = new PropertiesAttributes();
        attributesProperties47.setName("@DateBridgeDA");
        attributesProperties47.setValue("@DateBridge(resolution = Resolution.DAY)");
        em.persist(attributesProperties47);
        em.flush();

        PropertiesAttributes attributesProperties48 = new PropertiesAttributes();
        attributesProperties48.setName("@DateBridgeHO");
        attributesProperties48.setValue("@DateBridge(resolution = Resolution.HOUR)");
        em.persist(attributesProperties48);
        em.flush();

        PropertiesAttributes attributesProperties49 = new PropertiesAttributes();
        attributesProperties49.setName("@DateBridgeMI");
        attributesProperties49.setValue("@DateBridge(resolution = Resolution.MINUTE)");
        em.persist(attributesProperties49);
        em.flush();

        PropertiesAttributes attributesProperties50 = new PropertiesAttributes();
        attributesProperties50.setName("@Column");
        attributesProperties50.setValue("@Column");
        em.persist(attributesProperties50);
        em.flush();

        PropertiesAttributes attributesProperties51 = new PropertiesAttributes();
        attributesProperties51.setName("NullUnique1");
        attributesProperties51.setValue("@Column(nullable = true, unique = true)");
        em.persist(attributesProperties51);
        em.flush();

        PropertiesAttributes attributesProperties52 = new PropertiesAttributes();
        attributesProperties52.setName("NullUnique2");
        attributesProperties52.setValue("@Column(nullable = true, unique = false)");
        em.persist(attributesProperties52);
        em.flush();

        PropertiesAttributes attributesProperties53 = new PropertiesAttributes();
        attributesProperties53.setName("NullUnique3");
        attributesProperties53.setValue("@Column(nullable = false, unique = true)");
        em.persist(attributesProperties53);
        em.flush();

        PropertiesAttributes attributesProperties54 = new PropertiesAttributes();
        attributesProperties54.setName("NullUnique4");
        attributesProperties54.setValue("@Column(nullable = false, unique = false)");
        em.persist(attributesProperties54);
        em.flush();

        PropertiesAttributes attributesProperties55 = new PropertiesAttributes();
        attributesProperties55.setName("@Basic");
        attributesProperties55.setValue("@Basic");
        em.persist(attributesProperties55);
        em.flush();

        PropertiesAttributes attributesProperties56 = new PropertiesAttributes();
        attributesProperties56.setName("@Basic1");
        attributesProperties56.setValue("@Basic(fetch=FetchType.LAZY)");
        em.persist(attributesProperties56);
        em.flush();

        PropertiesAttributes attributesProperties57 = new PropertiesAttributes();
        attributesProperties57.setName("@Lob");
        attributesProperties57.setValue("@Lob");
        em.persist(attributesProperties57);
        em.flush();

        PropertiesAttributes attributesProperties58 = new PropertiesAttributes();
        attributesProperties58.setName("@Indexed");
        attributesProperties58.setValue("@Indexed");
        em.persist(attributesProperties58);
        em.flush();

        PropertiesAttributes attributesProperties59 = new PropertiesAttributes();
        attributesProperties59.setName("@DocumentId");
        attributesProperties59.setValue("@DocumentId");
        em.persist(attributesProperties59);
        em.flush();

//      ---------------------- AttributesTypes ------------------------

        AttributesTypes attributesTypes1 = new AttributesTypes();
        attributesTypes1.setName("String");
        attributesTypes1.setType("String");
        attributesTypes1.setObservations("A \"short\" sequence of characters");

        Set<PropertiesAttributes> attributesTypesAttributesProperties1 = new HashSet<PropertiesAttributes>();
//      ...................... @Field1........................
        PropertiesAttributes attributeTypeAttributeProperty1 = findBean.nameAttributesProperties("@Field1",em);
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
        PropertiesAttributes attributeTypeAttributeProperty2 = findBean.nameAttributesProperties("@Field1",em);
        attributesTypesAttributesProperties2.add(attributeTypeAttributeProperty2);
//      ...................... @Lob........................
        PropertiesAttributes attributeTypeAttributeProperty3 = findBean.nameAttributesProperties("@Lob",em);
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
        attributesTypes4.setName("Float");
        attributesTypes4.setType("Float");
        attributesTypes4.setObservations("A floating point numerical type");
        em.persist(attributesTypes4);
        em.flush();

        AttributesTypes attributesTypes5 = new AttributesTypes();
        attributesTypes5.setName("Date");
        attributesTypes5.setType("Date");
        attributesTypes5.setObservations("A calendar date");

        Set<PropertiesAttributes> attributesTypesAttributesProperties5 = new HashSet<PropertiesAttributes>();
//      ...................... @Temporal........................
        PropertiesAttributes attributeTypeAttributeProperty4 = findBean.nameAttributesProperties("@Temporal",em);
        attributesTypesAttributesProperties5.add(attributeTypeAttributeProperty4);
//      ...................... @DateBridgeYE........................
        PropertiesAttributes attributeTypeAttributeProperty5 = findBean.nameAttributesProperties("@DateBridgeYE",em);
        attributesTypesAttributesProperties5.add(attributeTypeAttributeProperty5);
        attributesTypes5.setPropertiesAttributes(attributesTypesAttributesProperties5);

        em.persist(attributesTypes5);
        em.flush();

        AttributesTypes attributesTypes6 = new AttributesTypes();
        attributesTypes6.setName("Time");
        attributesTypes6.setType("Date");
        attributesTypes6.setObservations("A temporal instant of time");
        em.persist(attributesTypes6);
        em.flush();

        AttributesTypes attributesTypes7 = new AttributesTypes();
        attributesTypes7.setName("Boolean");
        attributesTypes7.setType("Boolean");
        attributesTypes7.setObservations("A true or false value");
        em.persist(attributesTypes7);
        em.flush();

        AttributesTypes attributesTypes8 = new AttributesTypes();
        attributesTypes8.setName("Enumeration");
        attributesTypes8.setType("Enumeration");
        attributesTypes8.setObservations("A sequence of user-defined values");
        em.persist(attributesTypes8);
        em.flush();

        AttributesTypes attributesTypes9 = new AttributesTypes();
        attributesTypes9.setName("Blob");
        attributesTypes9.setType("Blob");
        attributesTypes9.setObservations("A binanry large object, for example an image or a video, which must be handled in a special way because of its size. Blob type can be further refined by expressing their MIME type for example image/gif");
        em.persist(attributesTypes9);
        em.flush();

        AttributesTypes attributesTypes10 = new AttributesTypes();
        attributesTypes10.setName("Url");
        attributesTypes10.setType("Url");
        attributesTypes10.setObservations("A uniform resource locator of a web resource");
        em.persist(attributesTypes10);
        em.flush();

        AttributesTypes attributesTypes11 = new AttributesTypes();
        attributesTypes11.setName("byte");
        attributesTypes11.setType("byte");
        attributesTypes11.setObservations("A uniform resource locator of a web resource");

        Set<PropertiesAttributes> attributesTypesAttributesProperties11 = new HashSet<PropertiesAttributes>();
//      ...................... @Basic1........................
        PropertiesAttributes attributeTypeAttributeProperty6 = findBean.nameAttributesProperties("@Basic1",em);
        attributesTypesAttributesProperties11.add(attributeTypeAttributeProperty6);
//      ...................... @Lob........................
        PropertiesAttributes attributeTypeAttributeProperty7 = findBean.nameAttributesProperties("@Lob",em);
        attributesTypesAttributesProperties11.add(attributeTypeAttributeProperty7);
        attributesTypes11.setPropertiesAttributes(attributesTypesAttributesProperties11);

        em.persist(attributesTypes11);
        em.flush();

        AttributesTypes attributesTypes12 = new AttributesTypes();
        attributesTypes12.setName("double");
        attributesTypes12.setType("double");
        attributesTypes12.setObservations("A uniform resource locator of a web resource");

        Set<PropertiesAttributes> attributesTypesAttributesProperties12 = new HashSet<PropertiesAttributes>();
//      ...................... @NumericField........................
        PropertiesAttributes attributeTypeAttributeProperty8 = findBean.nameAttributesProperties("@NumericField",em);
        attributesTypesAttributesProperties12.add(attributeTypeAttributeProperty8);
//      ...................... @Field1........................
        PropertiesAttributes attributeTypeAttributeProperty9 = findBean.nameAttributesProperties("@Field1",em);
        attributesTypesAttributesProperties12.add(attributeTypeAttributeProperty9);
        attributesTypes12.setPropertiesAttributes(attributesTypesAttributesProperties12);

        em.persist(attributesTypes12);
        em.flush();

        AttributesTypes attributesTypes13 = new AttributesTypes();
        attributesTypes13.setName("Email");
        attributesTypes13.setType("Email");
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
