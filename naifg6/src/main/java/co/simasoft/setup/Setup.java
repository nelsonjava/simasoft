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

    @PersistenceContext(unitName = "DomainModelsPU-JTA")
    private EntityManager em;

    private static final Logger log = Logger.getLogger(Setup.class.getName());

    public void data() {

//      ---------------------- Dependency ------------------------

        Dependency persistence_api = new Dependency();
        persistence_api.setOrden(1L);
        persistence_api.setGroupId("javax.persistence");
        persistence_api.setArtifactId("persistence-api");
        persistence_api.setLink("http://mvnrepository.com/artifact/javax.persistence/persistence-api");
        persistence_api.setMaven("&lt;dependency&gt;<br/>"+
                             "&nbsp;&nbsp;&#09;&lt;groupId&gt;javax.persistence&lt;/groupId&gt;<br/>"+
                             "&nbsp;&nbsp;&#09;&lt;artifactId&gt;persistence-api&lt;/artifactId&gt;<br/>"+
                             "&nbsp;&nbsp;&#09;&lt;version&gt;1.0.2&lt;/version&gt;<br/>"+
                             "&lt;/dependency&gt;");
        em.persist(persistence_api);
        em.flush();

        Dependency validation_api = new Dependency();
        validation_api.setOrden(2L);
        validation_api.setGroupId("javax.validation");
        validation_api.setArtifactId("validation-api");
        validation_api.setLink("http://mvnrepository.com/artifact/org.hibernate/hibernate-validator");
        validation_api.setMaven("&lt;dependency&gt;<br/>"+
                             "&nbsp;&nbsp;&#09;&lt;groupId&gt;javax.validation&lt;/groupId&gt;<br/>"+
                             "&nbsp;&nbsp;&#09;&lt;artifactId&gt;validation-api&lt;/artifactId&gt;<br/>"+
                             "&nbsp;&nbsp;&#09;&lt;version&gt;1.1.0.Final&lt;/version&gt;<br/>"+
                             "&lt;/dependency&gt;");
        em.persist(validation_api);
        em.flush();

        Dependency hibernate_validator = new Dependency();
        hibernate_validator.setOrden(3L);
        hibernate_validator.setGroupId("org.hibernate");
        hibernate_validator.setArtifactId("hibernate-validator");
        hibernate_validator.setLink("http://mvnrepository.com/artifact/org.hibernate/hibernate-validator");
        hibernate_validator.setMaven("&lt;dependency&gt;<br/>"+
                             "&nbsp;&nbsp;&#09;&lt;groupId&gt;org.hibernate&lt;/groupId&gt;<br/>"+
                             "&nbsp;&nbsp;&#09;&lt;artifactId&gt;hibernate-validator&lt;/artifactId&gt;<br/>"+
                             "&nbsp;&nbsp;&#09;&lt;version&gt;5.1.3.Final&lt;/version&gt;<br/>"+
                             "&lt;/dependency&gt;");
        em.persist(hibernate_validator);
        em.flush();

//      ---------------------- Imports() -------------------------

/*
        Imports imports1 = new Imports();
        imports1.setOrden(1L);
        imports1.setName("import javax.persistence.Entity;");
        imports1.setDependency(persistence_api);
        em.persist(imports1);
        em.flush();

        Imports imports2 = new Imports();
        imports2.setOrden(2L);
        imports2.setName("import javax.persistence.Id;");
        imports2.setDependency(persistence_api);
        em.persist(imports2);
        em.flush();

        Imports imports3 = new Imports();
        imports3.setOrden(3L);
        imports3.setName("import javax.persistence.Version;");
        imports3.setDependency(persistence_api);
        em.persist(imports3);
        em.flush();

        Imports imports4 = new Imports();
        imports4.setOrden(4L);
        imports4.setName("import javax.persistence.GenerationType;");
        imports4.setDependency(persistence_api);
        em.persist(imports4);
        em.flush();

        Imports imports5 = new Imports();
        imports5.setOrden(5L);
        imports5.setName("import javax.persistence.GeneratedValue;");
        imports5.setDependency(persistence_api);
        em.persist(imports5);
        em.flush();

        Imports imports6 = new Imports();
        imports6.setOrden(6L);
        imports6.setName("import javax.persistence.FetchType;");
        imports6.setDependency(persistence_api);
        em.persist(imports6);
        em.flush();

        Imports imports7 = new Imports();
        imports7.setOrden(7L);
        imports7.setName("import javax.persistence.OneToOne;");
        imports7.setDependency(persistence_api);
        em.persist(imports7);
        em.flush();

        Imports imports8 = new Imports();
        imports8.setOrden(8L);
        imports8.setName("import javax.persistence.ManyToOne;");
        imports8.setDependency(persistence_api);
        em.persist(imports8);
        em.flush();

        Imports imports9 = new Imports();
        imports9.setOrden(9L);
        imports9.setName("import javax.persistence.OneToMany;");
        imports9.setDependency(persistence_api);
        em.persist(imports9);
        em.flush();

        Imports imports10 = new Imports();
        imports10.setOrden(10L);
        imports10.setName("import javax.persistence.ManyToMany;");
        imports10.setDependency(persistence_api);
        em.persist(imports10);
        em.flush();
*/        

        Imports imports11 = new Imports();
        imports11.setOrden(11L);
        imports11.setName("import javax.persistence.Column;");
        imports11.setDependency(persistence_api);
        em.persist(imports11); //1
        em.flush();

        Imports imports12 = new Imports();
        imports12.setOrden(12L);
        imports12.setName("import javax.persistence.Basic;");
        imports12.setDependency(persistence_api);
        em.persist(imports12); //2
        em.flush();

        Imports imports13 = new Imports();
        imports13.setOrden(13L);
        imports13.setName("import javax.persistence.Lob;");
        imports13.setDependency(persistence_api);
        em.persist(imports13); //22
        em.flush();

        Imports imports14 = new Imports();
        imports14.setOrden(14L);
        imports14.setName("import javax.persistence.FetchType;");
        imports14.setDependency(persistence_api);
        em.persist(imports14); //24
        em.flush();

        Imports imports15 = new Imports();
        imports15.setOrden(15L);
        imports15.setName("import javax.persistence.CascadeType;");
        imports15.setDependency(persistence_api);
        em.persist(imports15); //23
        em.flush();

        Imports imports16 = new Imports();
        imports16.setOrden(16L);
        imports16.setName("import javax.validation.constraints.NotNull;");
        imports16.setDependency(validation_api);
        em.persist(imports16); //3
        em.flush();

        Imports imports17 = new Imports();
        imports17.setOrden(17L);
        imports17.setName("import javax.validation.constraints.Size;");
        imports17.setDependency(validation_api);
        em.persist(imports17); //4
        em.flush();

        Imports imports18 = new Imports();
        imports18.setOrden(18L);
        imports18.setName("import javax.validation.constraints.Pattern;");
        imports18.setDependency(validation_api);
        em.persist(imports18); //5
        em.flush();

        Imports imports19 = new Imports();
        imports19.setOrden(19L);
        imports19.setName("import javax.validation.constraints.Digits;");
        imports19.setDependency(validation_api);
        em.persist(imports19); //6
        em.flush();

        Imports imports20 = new Imports();
        imports20.setOrden(20L);
        imports20.setName("import org.hibernate.validator.Length;");
        imports20.setDependency(hibernate_validator);
        em.persist(imports20); //7
        em.flush();

        Imports imports21 = new Imports();
        imports21.setOrden(21L);
        imports21.setName("import org.hibernate.validator.constraints.NotEmpty;");
        imports21.setDependency(hibernate_validator);
        em.persist(imports21); //8
        em.flush();

        Imports imports22 = new Imports();
        imports22.setOrden(22L);
        imports22.setName("import org.hibernate.validator.constraints.Email;");
        imports22.setDependency(hibernate_validator);
        em.persist(imports22); //9
        em.flush();


//      ---------------------- Cardinalities -------------------------

        Cardinalities oto = new Cardinalities();
        oto.setOrden(1L);
        oto.setCardinality("1..1");
        oto.setName("Uno a Uno Unidireccional No.1");
        oto.setUnidirectional(true);
        Set<Imports> importsOto = new HashSet<Imports>();
//        importsOto.add(imports7);
        oto.setImports(importsOto);
        em.persist(oto);
        em.flush();

        Cardinalities oob = new Cardinalities();
        oob.setOrden(2L);
        oob.setCardinality("1..1");
        oob.setName("Uno a Uno Bidirecccional No.2");
        oob.setUnidirectional(false);
/*
        Set<Imports> importsOob = new HashSet<Imports>();
        importsOob.add(imports7);
        oob.setImports(importsOob);
*/
        em.persist(oob);
        em.flush();

        Cardinalities mto = new Cardinalities();
        mto.setOrden(3L);
        mto.setCardinality("*..1");
        mto.setName("Muchos a Uno Unidireccional No.3");
        mto.setUnidirectional(true);
/*
        Set<Imports> importsMto = new HashSet<Imports>();
        importsMto.add(imports8);
        mto.setImports(importsMto);
*/
        em.persist(mto);
        em.flush();

        Cardinalities otm = new Cardinalities();
        otm.setOrden(4L);
        otm.setCardinality("1..*");
        otm.setName("Uno a Muchos Unidireccional No.4");
        otm.setUnidirectional(true);
/*
        Set<Imports> importsOtm = new HashSet<Imports>();
        importsOtm.add(imports9);
        otm.setImports(importsOtm);
*/
        em.persist(otm);
        em.flush();

        Cardinalities omb = new Cardinalities();
        omb.setOrden(5L);
        omb.setCardinality("1..*");
        omb.setName("Uno a Muchos Bidirecccional No.5");
        omb.setUnidirectional(false);
/*
        Set<Imports> importsOmb = new HashSet<Imports>();
        importsOmb.add(imports9);
        omb.setImports(importsOmb);
*/
        em.persist(omb);
        em.flush();

        Cardinalities mtm = new Cardinalities();
        mtm.setOrden(6L);
        mtm.setCardinality("*..*");
        mtm.setName("Muchos a Muchos Unidireccional No.6");
        mtm.setUnidirectional(true);
/*
        Set<Imports> importsMtm = new HashSet<Imports>();
        importsMtm.add(imports10);
        mtm.setImports(importsMtm);
*/
        em.persist(mtm);
        em.flush();

        Cardinalities mmb = new Cardinalities();
        mmb.setOrden(7L);
        mmb.setCardinality("*..*");
        mmb.setName("Muchos a Muchos Bidirecccional No.7");
        mmb.setUnidirectional(false);
/*
        Set<Imports> importsMmb = new HashSet<Imports>();
        importsMmb.add(imports10);
        mmb.setImports(importsMmb);
*/
        em.persist(mmb);
        em.flush();

//      ---------------------- PropertiesAttributes -------------------------

        PropertiesAttributes varNotNull = new PropertiesAttributes();
        varNotNull.setOrden(1L);
        varNotNull.setName("@NotNull");
        varNotNull.setValue("@NotNull");
        Set<Imports> importsNotNull = new HashSet<Imports>();
        importsNotNull.add(imports16);
        varNotNull.setImports(importsNotNull);
        em.persist(varNotNull);
        em.flush();

        PropertiesAttributes varSize0125 = new PropertiesAttributes();
        varSize0125.setOrden(2L);
        varSize0125.setName("@Size0125");
        varSize0125.setValue("@Size(min = 1, max = 25)");
        Set<Imports> importsSize0125 = new HashSet<Imports>();
        importsSize0125.add(imports17);
        varSize0125.setImports(importsSize0125);
        em.persist(varSize0125);
        em.flush();

        PropertiesAttributes varSize0912 = new PropertiesAttributes();
        varSize0912.setOrden(3L);
        varSize0912.setName("@Size0912");
        varSize0912.setValue("@Size(min = 9, max = 12)");
        Set<Imports> importsSize0912 = new HashSet<Imports>();
        importsSize0912.add(imports17);
        varSize0912.setImports(importsSize0912);
        em.persist(varSize0912);
        em.flush();

        PropertiesAttributes varLength0125 = new PropertiesAttributes();
        varLength0125.setOrden(4L);
        varLength0125.setName("@Length0125");
        varLength0125.setValue("@Length(min = 1, max = 25, message = \"Size must be between 1 and 25 digits\")");
        Set<Imports> importsLength0125 = new HashSet<Imports>();
        importsLength0125.add(imports20);
        varLength0125.setImports(importsLength0125);
        em.persist(varLength0125);
        em.flush();

        PropertiesAttributes varLength0912 = new PropertiesAttributes();
        varLength0912.setOrden(5L);
        varLength0912.setName("@Length0912");
        varLength0912.setValue("@Length(min = 9, max = 12, message = \"Size must be between 9 and 12 digits\")");
        Set<Imports> importsLength0912 = new HashSet<Imports>();
        importsLength0912.add(imports20);
        varLength0912.setImports(importsLength0912);
        em.persist(varLength0912);
        em.flush();

        PropertiesAttributes varPattern1 = new PropertiesAttributes();
        varPattern1.setOrden(6L);
        varPattern1.setName("@Pattern1");
        varPattern1.setValue("@Pattern(regexp = \"[A-Za-z ]*\", message = \"must contain only letters and spaces\")");
        Set<Imports> importsPattern1 = new HashSet<Imports>();
        importsPattern1.add(imports18);
        varPattern1.setImports(importsPattern1);
        em.persist(varPattern1);
        em.flush();

        PropertiesAttributes varPattern2 = new PropertiesAttributes();
        varPattern2.setOrden(7L);
        varPattern2.setName("@Pattern2");
        varPattern2.setValue("@Pattern(regexp = \"[^0-9]*\", message = \"Must not contain numbers\")");
        Set<Imports> importsPattern2 = new HashSet<Imports>();
        importsPattern2.add(imports18);
        varPattern2.setImports(importsPattern2);
        em.persist(varPattern2);
        em.flush();

        PropertiesAttributes varNotEmpty = new PropertiesAttributes();
        varNotEmpty.setOrden(8L);
        varNotEmpty.setName("@NotEmpty");
        varNotEmpty.setValue("@NotEmpty");
        Set<Imports> importsNotEmpty = new HashSet<Imports>();
        importsNotEmpty.add(imports21);
        varNotEmpty.setImports(importsNotEmpty);
        em.persist(varNotEmpty);
        em.flush();

        PropertiesAttributes varEmail = new PropertiesAttributes();
        varEmail.setOrden(9L);
        varEmail.setName("@Email");
        varEmail.setValue("@Email(message = \"Invalid format\")");
        Set<Imports> importsEmail = new HashSet<Imports>();
        importsEmail.add(imports22);
        varEmail.setImports(importsEmail);
        em.persist(varEmail);
        em.flush();

        PropertiesAttributes varDigits0012 = new PropertiesAttributes();
        varDigits0012.setOrden(10L);
        varDigits0012.setName("@Digits0012");
        varDigits0012.setValue("@Digits(fractionalDigits = 0, integerDigits = 12, message = \"Not allowed digit!\")");
        Set<Imports> importsDigits0012 = new HashSet<Imports>();
        importsDigits0012.add(imports19);
        varDigits0012.setImports(importsDigits0012);
        em.persist(varDigits0012);
        em.flush();

        PropertiesAttributes varColumn = new PropertiesAttributes();
        varColumn.setOrden(11L);
        varColumn.setName("@Column");
        varColumn.setValue("@Column");
        Set<Imports> importsColumn = new HashSet<Imports>();
        importsColumn.add(imports11);
        varColumn.setImports(importsColumn);
        em.persist(varColumn);
        em.flush();

        PropertiesAttributes varColumn1 = new PropertiesAttributes();
        varColumn1.setOrden(12L);
        varColumn1.setName("@Column1");
        varColumn1.setValue("@Column(name=\"file\")");
        Set<Imports> importsColumn1 = new HashSet<Imports>();
        importsColumn1.add(imports11);
        varColumn1.setImports(importsColumn1);
        em.persist(varColumn1);
        em.flush();

        PropertiesAttributes varNullUnique1 = new PropertiesAttributes();
        varNullUnique1.setOrden(13L);
        varNullUnique1.setName("NullUnique1");
        varNullUnique1.setValue("@Column(nullable = true, unique = true)");
        Set<Imports> importsNullUnique1 = new HashSet<Imports>();
        importsNullUnique1.add(imports11);
        varNullUnique1.setImports(importsNullUnique1);
        em.persist(varNullUnique1);
        em.flush();

        PropertiesAttributes varNullUnique2 = new PropertiesAttributes();
        varNullUnique2.setOrden(14L);
        varNullUnique2.setName("NullUnique2");
        varNullUnique2.setValue("@Column(nullable = true, unique = false)");
        Set<Imports> importsNullUnique2 = new HashSet<Imports>();
        importsNullUnique2.add(imports11);
        varNullUnique2.setImports(importsNullUnique2);
        em.persist(varNullUnique2);
        em.flush();

        PropertiesAttributes varNullUnique3 = new PropertiesAttributes();
        varNullUnique3.setOrden(15L);
        varNullUnique3.setName("NullUnique3");
        varNullUnique3.setValue("@Column(nullable = false, unique = true)");
        Set<Imports> importsNullUnique3 = new HashSet<Imports>();
        importsNullUnique3.add(imports11);
        varNullUnique3.setImports(importsNullUnique3);
        em.persist(varNullUnique3);
        em.flush();

        PropertiesAttributes varNullUnique4 = new PropertiesAttributes();
        varNullUnique4.setOrden(16L);
        varNullUnique4.setName("NullUnique4");
        varNullUnique4.setValue("@Column(nullable = false, unique = false)");
        Set<Imports> importsNullUnique4 = new HashSet<Imports>();
        importsNullUnique4.add(imports11);
        varNullUnique4.setImports(importsNullUnique4);
        em.persist(varNullUnique4);
        em.flush();

        PropertiesAttributes varBasic = new PropertiesAttributes();
        varBasic.setOrden(17L);
        varBasic.setName("@Basic");
        varBasic.setValue("@Basic");
        Set<Imports> importsBasic = new HashSet<Imports>();
        importsBasic.add(imports12);
        varBasic.setImports(importsBasic);
        em.persist(varBasic);
        em.flush();

        PropertiesAttributes varBasic1 = new PropertiesAttributes();
        varBasic1.setOrden(18L);
        varBasic1.setName("@Basic1");
        varBasic1.setValue("@Basic(fetch=FetchType.LAZY)");
        Set<Imports> importsBasic1 = new HashSet<Imports>();
        importsBasic1.add(imports12);
        varBasic1.setImports(importsBasic1);
        em.persist(varBasic1);
        em.flush();

        PropertiesAttributes varLob = new PropertiesAttributes();
        varLob.setOrden(19L);
        varLob.setName("@Lob");
        varLob.setValue("@Lob");
        Set<Imports> importsLob = new HashSet<Imports>();
        importsLob.add(imports13);
        varLob.setImports(importsLob);
        em.persist(varLob);
        em.flush();

//      ---------------------- TypesAttributes -------------------------

        TypesAttributes varString = new TypesAttributes();
        varString.setOrden(1L);
        varString.setName("String");
        varString.setType("String");
        varString.setObservations("A \"short\" sequence of characters");
        em.persist(varString);
        em.flush();

        TypesAttributes varText = new TypesAttributes();
        varText.setOrden(2L);
        varText.setName("Text");
        varText.setType("String");
        varText.setObservations("A \"long\" sequence of characters");
        em.persist(varText);
        em.flush();

        TypesAttributes varInteger = new TypesAttributes();
        varInteger.setOrden(3L);
        varInteger.setName("Integer");
        varInteger.setType("Integer");
        varInteger.setObservations("An integer numerical type");
        em.persist(varInteger);
        em.flush();

        TypesAttributes varFloat = new TypesAttributes();
        varFloat.setOrden(4L);
        varFloat.setName("Float");
        varFloat.setType("Float");
        varFloat.setObservations("A floating point numerical type");
        em.persist(varFloat);
        em.flush();

        TypesAttributes varDate = new TypesAttributes();
        varDate.setOrden(5L);
        varDate.setName("Date");
        varDate.setType("Date");
        varDate.setObservations("A calendar date");
        em.persist(varDate);
        em.flush();

        TypesAttributes varTime = new TypesAttributes();
        varTime.setOrden(6L);
        varTime.setName("Time");
        varTime.setType("Date");
        varTime.setObservations("A temporal instant of time");
        em.persist(varTime);
        em.flush();

        TypesAttributes varBoolean = new TypesAttributes();
        varBoolean.setOrden(7L);
        varBoolean.setName("Boolean");
        varBoolean.setType("Boolean");
        varBoolean.setObservations("A true or false value");
        em.persist(varBoolean);
        em.flush();

        TypesAttributes varEnumeration = new TypesAttributes();
        varEnumeration.setOrden(8L);
        varEnumeration.setName("Enumeration");
        varEnumeration.setType("Enumeration");
        varEnumeration.setObservations("A sequence of user-defined values");
        em.persist(varEnumeration);
        em.flush();

        TypesAttributes varBlob = new TypesAttributes();
        varBlob.setOrden(9L);
        varBlob.setName("Blob");
        varBlob.setType("Blob");
        varBlob.setObservations("A binanry large object, for example an image or a video, which must be handled in a special way because of its size. Blob type can be further refined by expressing their MIME type for example image/gif");
        em.persist(varBlob);
        em.flush();

        TypesAttributes varUrl = new TypesAttributes();
        varUrl.setOrden(10L);
        varUrl.setName("Url");
        varUrl.setType("Url");
        varUrl.setObservations("A uniform resource locator of a web resource");
        em.persist(varUrl);
        em.flush();

        TypesAttributes varByte = new TypesAttributes();
        varByte.setOrden(11L);
        varByte.setName("byte");
        varByte.setType("byte");
        varByte.setObservations("A uniform resource locator of a web resource");

        Set<PropertiesAttributes> propertiesByte = new HashSet<PropertiesAttributes>();
        propertiesByte.add(varBasic1);
        propertiesByte.add(varLob);
        propertiesByte.add(varColumn1);
        varByte.setPropertiesAttributes(propertiesByte);

        em.persist(varByte);
        em.flush();

        TypesAttributes varDouble = new TypesAttributes();
        varDouble.setOrden(12L);
        varDouble.setName("double");
        varDouble.setType("double");
        varDouble.setObservations("A uniform resource locator of a web resource");
        em.persist(varDouble);
        em.flush();

        TypesAttributes varEmails = new TypesAttributes();
        varEmails.setOrden(13L);
        varEmails.setName("Email");
        varEmails.setType("Email");
        varEmails.setObservations("A uniform resource locator of a web resource");
        em.persist(varEmails);
        em.flush();

    } // data()

} // DomainModelsSetup

