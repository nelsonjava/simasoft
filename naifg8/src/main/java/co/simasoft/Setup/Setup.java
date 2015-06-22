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
        attributesProperties27.setName("@Column");
        attributesProperties27.setValue("@Column");
        Set<Imports> attributesPropertiesImports27 = new HashSet<Imports>();
//      ...................... import javax.persistence.Column; ........................
        Imports attributePropertyImports10 = findBean.nameImports("import javax.persistence.Column;",em);
        attributesPropertiesImports27.add(attributePropertyImports10);
        attributesProperties27.setImports(attributesPropertiesImports27);
        em.persist(attributesProperties27);
        em.flush();

        PropertiesAttributes attributesProperties28 = new PropertiesAttributes();
        attributesProperties28.setName("NullUnique1");
        attributesProperties28.setValue("@Column(nullable = true, unique = true)");
        Set<Imports> attributesPropertiesImports28 = new HashSet<Imports>();
//      ...................... import javax.persistence.Column; ........................
        Imports attributePropertyImports11 = findBean.nameImports("import javax.persistence.Column;",em);
        attributesPropertiesImports28.add(attributePropertyImports11);
        attributesProperties28.setImports(attributesPropertiesImports28);
        em.persist(attributesProperties28);
        em.flush();

        PropertiesAttributes attributesProperties29 = new PropertiesAttributes();
        attributesProperties29.setName("NullUnique2");
        attributesProperties29.setValue("@Column(nullable = true, unique = false)");
        Set<Imports> attributesPropertiesImports29 = new HashSet<Imports>();
//      ...................... import javax.persistence.Column; ........................
        Imports attributePropertyImports12 = findBean.nameImports("import javax.persistence.Column;",em);
        attributesPropertiesImports29.add(attributePropertyImports12);
        attributesProperties29.setImports(attributesPropertiesImports29);
        em.persist(attributesProperties29);
        em.flush();

        PropertiesAttributes attributesProperties30 = new PropertiesAttributes();
        attributesProperties30.setName("NullUnique3");
        attributesProperties30.setValue("@Column(nullable = false, unique = true)");
        Set<Imports> attributesPropertiesImports30 = new HashSet<Imports>();
//      ...................... import javax.persistence.Column; ........................
        Imports attributePropertyImports13 = findBean.nameImports("import javax.persistence.Column;",em);
        attributesPropertiesImports30.add(attributePropertyImports13);
        attributesProperties30.setImports(attributesPropertiesImports30);
        em.persist(attributesProperties30);
        em.flush();

        PropertiesAttributes attributesProperties31 = new PropertiesAttributes();
        attributesProperties31.setName("NullUnique4");
        attributesProperties31.setValue("@Column(nullable = false, unique = false)");
        Set<Imports> attributesPropertiesImports31 = new HashSet<Imports>();
//      ...................... import javax.persistence.Column; ........................
        Imports attributePropertyImports14 = findBean.nameImports("import javax.persistence.Column;",em);
        attributesPropertiesImports31.add(attributePropertyImports14);
        attributesProperties31.setImports(attributesPropertiesImports31);
        em.persist(attributesProperties31);
        em.flush();

        PropertiesAttributes attributesProperties32 = new PropertiesAttributes();
        attributesProperties32.setName("@Basic");
        attributesProperties32.setValue("@Basic");
        Set<Imports> attributesPropertiesImports32 = new HashSet<Imports>();
//      ...................... import javax.persistence.Basic; ........................
        Imports attributePropertyImports15 = findBean.nameImports("import javax.persistence.Basic;",em);
        attributesPropertiesImports32.add(attributePropertyImports15);
        attributesProperties32.setImports(attributesPropertiesImports32);
        em.persist(attributesProperties32);
        em.flush();

        PropertiesAttributes attributesProperties33 = new PropertiesAttributes();
        attributesProperties33.setName("@Basic1");
        attributesProperties33.setValue("@Basic(fetch=FetchType.LAZY)");
        Set<Imports> attributesPropertiesImports33 = new HashSet<Imports>();
//      ...................... import javax.persistence.Basic; ........................
        Imports attributePropertyImports16 = findBean.nameImports("import javax.persistence.Basic;",em);
        attributesPropertiesImports33.add(attributePropertyImports16);
        attributesProperties33.setImports(attributesPropertiesImports33);
        em.persist(attributesProperties33);
        em.flush();

        PropertiesAttributes attributesProperties34 = new PropertiesAttributes();
        attributesProperties34.setName("@Lob");
        attributesProperties34.setValue("@Lob");
        Set<Imports> attributesPropertiesImports34 = new HashSet<Imports>();
//      ...................... import javax.persistence.Lob; ........................
        Imports attributePropertyImports17 = findBean.nameImports("import javax.persistence.Lob;",em);
        attributesPropertiesImports34.add(attributePropertyImports17);
        attributesProperties34.setImports(attributesPropertiesImports34);
        em.persist(attributesProperties34);
        em.flush();

        PropertiesAttributes attributesProperties35 = new PropertiesAttributes();
        attributesProperties35.setName("@Indexed");
        attributesProperties35.setValue("@Indexed");
        Set<Imports> attributesPropertiesImports35 = new HashSet<Imports>();
//      ...................... import org.hibernate.search.annotations.Indexed; ........................
        Imports attributePropertyImports18 = findBean.nameImports("import org.hibernate.search.annotations.Indexed;",em);
        attributesPropertiesImports35.add(attributePropertyImports18);
        attributesProperties35.setImports(attributesPropertiesImports35);
        em.persist(attributesProperties35);
        em.flush();

        PropertiesAttributes attributesProperties36 = new PropertiesAttributes();
        attributesProperties36.setName("@DocumentId");
        attributesProperties36.setValue("@DocumentId");
        Set<Imports> attributesPropertiesImports36 = new HashSet<Imports>();
//      ...................... import org.hibernate.search.annotations.DocumentId; ........................
        Imports attributePropertyImports19 = findBean.nameImports("import org.hibernate.search.annotations.DocumentId;",em);
        attributesPropertiesImports36.add(attributePropertyImports19);
        attributesProperties36.setImports(attributesPropertiesImports36);
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
        Set<Imports> attributesPropertiesImports39 = new HashSet<Imports>();
//      ...................... import org.hibernate.search.annotations.NumericField; ........................
        Imports attributePropertyImports20 = findBean.nameImports("import org.hibernate.search.annotations.NumericField;",em);
        attributesPropertiesImports39.add(attributePropertyImports20);
        attributesProperties39.setImports(attributesPropertiesImports39);
        em.persist(attributesProperties39);
        em.flush();

        PropertiesAttributes attributesProperties40 = new PropertiesAttributes();
        attributesProperties40.setName("@Field1");
        attributesProperties40.setValue("@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)");
        Set<Imports> attributesPropertiesImports40 = new HashSet<Imports>();
//      ...................... import org.hibernate.search.annotations.Analyze; ........................
        Imports attributePropertyImports21 = findBean.nameImports("import org.hibernate.search.annotations.Analyze;",em);
        attributesPropertiesImports40.add(attributePropertyImports21);
//      ...................... import org.hibernate.search.annotations.DocumentId; ........................
        Imports attributePropertyImports22 = findBean.nameImports("import org.hibernate.search.annotations.DocumentId;",em);
        attributesPropertiesImports40.add(attributePropertyImports22);
//      ...................... import org.hibernate.search.annotations.Field; ........................
        Imports attributePropertyImports23 = findBean.nameImports("import org.hibernate.search.annotations.Field;",em);
        attributesPropertiesImports40.add(attributePropertyImports23);
//      ...................... import org.hibernate.search.annotations.Store; ........................
        Imports attributePropertyImports24 = findBean.nameImports("import org.hibernate.search.annotations.Store;",em);
        attributesPropertiesImports40.add(attributePropertyImports24);
//      ...................... import org.hibernate.search.annotations.Indexed; ........................
        Imports attributePropertyImports25 = findBean.nameImports("import org.hibernate.search.annotations.Indexed;",em);
        attributesPropertiesImports40.add(attributePropertyImports25);
//      ...................... import org.hibernate.search.annotations.Index; ........................
        Imports attributePropertyImports26 = findBean.nameImports("import org.hibernate.search.annotations.Index;",em);
        attributesPropertiesImports40.add(attributePropertyImports26);
        attributesProperties40.setImports(attributesPropertiesImports40);
        em.persist(attributesProperties40);
        em.flush();

        PropertiesAttributes attributesProperties41 = new PropertiesAttributes();
        attributesProperties41.setName("@Field2");
        attributesProperties41.setValue("@Field(index = Index.YES, analyze = Analyze.YES, store = Store.YES)");
        Set<Imports> attributesPropertiesImports41 = new HashSet<Imports>();
//      ...................... import org.hibernate.search.annotations.Field; ........................
        Imports attributePropertyImports27 = findBean.nameImports("import org.hibernate.search.annotations.Field;",em);
        attributesPropertiesImports41.add(attributePropertyImports27);
        attributesProperties41.setImports(attributesPropertiesImports41);
        em.persist(attributesProperties41);
        em.flush();

        PropertiesAttributes attributesProperties42 = new PropertiesAttributes();
        attributesProperties42.setName("@DateBridgeYE");
        attributesProperties42.setValue("@DateBridge(resolution = Resolution.YEAR)");
        Set<Imports> attributesPropertiesImports42 = new HashSet<Imports>();
//      ...................... import org.hibernate.search.annotations.DateBridge; ........................
        Imports attributePropertyImports28 = findBean.nameImports("import org.hibernate.search.annotations.DateBridge;",em);
        attributesPropertiesImports42.add(attributePropertyImports28);
//      ...................... import org.hibernate.search.annotations.Resolution; ........................
        Imports attributePropertyImports29 = findBean.nameImports("import org.hibernate.search.annotations.Resolution;",em);
        attributesPropertiesImports42.add(attributePropertyImports29);
        attributesProperties42.setImports(attributesPropertiesImports42);
        em.persist(attributesProperties42);
        em.flush();

        PropertiesAttributes attributesProperties43 = new PropertiesAttributes();
        attributesProperties43.setName("@Embedded");
        attributesProperties43.setValue("@Embedded");
        Set<Imports> attributesPropertiesImports43 = new HashSet<Imports>();
//      ...................... import javax.persistence.Embedded; ........................
        Imports attributePropertyImports30 = findBean.nameImports("import javax.persistence.Embedded;",em);
        attributesPropertiesImports43.add(attributePropertyImports30);
        attributesProperties43.setImports(attributesPropertiesImports43);
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
        Set<Imports> attributesPropertiesImports45 = new HashSet<Imports>();
//      ...................... import javax.persistence.TemporalType; ........................
        Imports attributePropertyImports31 = findBean.nameImports("import javax.persistence.TemporalType;",em);
        attributesPropertiesImports45.add(attributePropertyImports31);
//      ...................... import javax.persistence.Temporal; ........................
        Imports attributePropertyImports32 = findBean.nameImports("import javax.persistence.Temporal;",em);
        attributesPropertiesImports45.add(attributePropertyImports32);
        attributesProperties45.setImports(attributesPropertiesImports45);
        em.persist(attributesProperties45);
        em.flush();

        PropertiesAttributes attributesProperties46 = new PropertiesAttributes();
        attributesProperties46.setName("@DateBridgeMO");
        attributesProperties46.setValue("@DateBridge(resolution = Resolution.MONTH)");
        Set<Imports> attributesPropertiesImports46 = new HashSet<Imports>();
//      ...................... import org.hibernate.search.annotations.DateBridge; ........................
        Imports attributePropertyImports33 = findBean.nameImports("import org.hibernate.search.annotations.DateBridge;",em);
        attributesPropertiesImports46.add(attributePropertyImports33);
        attributesProperties46.setImports(attributesPropertiesImports46);
        em.persist(attributesProperties46);
        em.flush();

        PropertiesAttributes attributesProperties47 = new PropertiesAttributes();
        attributesProperties47.setName("@DateBridgeDA");
        attributesProperties47.setValue("@DateBridge(resolution = Resolution.DAY)");
        Set<Imports> attributesPropertiesImports47 = new HashSet<Imports>();
//      ...................... import org.hibernate.search.annotations.DateBridge; ........................
        Imports attributePropertyImports34 = findBean.nameImports("import org.hibernate.search.annotations.DateBridge;",em);
        attributesPropertiesImports47.add(attributePropertyImports34);
        attributesProperties47.setImports(attributesPropertiesImports47);
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
        Set<Imports> attributesPropertiesImports49 = new HashSet<Imports>();
//      ...................... import org.hibernate.search.annotations.DateBridge; ........................
        Imports attributePropertyImports35 = findBean.nameImports("import org.hibernate.search.annotations.DateBridge;",em);
        attributesPropertiesImports49.add(attributePropertyImports35);
        attributesProperties49.setImports(attributesPropertiesImports49);
        em.persist(attributesProperties49);
        em.flush();

        PropertiesAttributes attributesProperties50 = new PropertiesAttributes();
        attributesProperties50.setName("@NotNull");
        attributesProperties50.setValue("@NotNull");
        Set<Imports> attributesPropertiesImports50 = new HashSet<Imports>();
//      ...................... import javax.validation.constraints.NotNull; ........................
        Imports attributePropertyImports36 = findBean.nameImports("import javax.validation.constraints.NotNull;",em);
        attributesPropertiesImports50.add(attributePropertyImports36);
        attributesProperties50.setImports(attributesPropertiesImports50);
        em.persist(attributesProperties50);
        em.flush();

        PropertiesAttributes attributesProperties51 = new PropertiesAttributes();
        attributesProperties51.setName("@Size0125");
        attributesProperties51.setValue("@Size(min = 1, max = 25)");
        Set<Imports> attributesPropertiesImports51 = new HashSet<Imports>();
//      ...................... import javax.validation.constraints.Size; ........................
        Imports attributePropertyImports37 = findBean.nameImports("import javax.validation.constraints.Size;",em);
        attributesPropertiesImports51.add(attributePropertyImports37);
        attributesProperties51.setImports(attributesPropertiesImports51);
        em.persist(attributesProperties51);
        em.flush();

        PropertiesAttributes attributesProperties52 = new PropertiesAttributes();
        attributesProperties52.setName("@Size0912");
        attributesProperties52.setValue("@Size(min = 9, max = 12)");
        Set<Imports> attributesPropertiesImports52 = new HashSet<Imports>();
//      ...................... import javax.validation.constraints.Size; ........................
        Imports attributePropertyImports38 = findBean.nameImports("import javax.validation.constraints.Size;",em);
        attributesPropertiesImports52.add(attributePropertyImports38);
        attributesProperties52.setImports(attributesPropertiesImports52);
        em.persist(attributesProperties52);
        em.flush();

        PropertiesAttributes attributesProperties53 = new PropertiesAttributes();
        attributesProperties53.setName("@Length0125");
        attributesProperties53.setValue("@Length(min = 1, max = 25, message = \"Size must be between 1 and 25 digits\")");
        Set<Imports> attributesPropertiesImports53 = new HashSet<Imports>();
//      ...................... import org.hibernate.validator.Length; ........................
        Imports attributePropertyImports39 = findBean.nameImports("import org.hibernate.validator.Length;",em);
        attributesPropertiesImports53.add(attributePropertyImports39);
        attributesProperties53.setImports(attributesPropertiesImports53);
        em.persist(attributesProperties53);
        em.flush();

        PropertiesAttributes attributesProperties54 = new PropertiesAttributes();
        attributesProperties54.setName("@Length0912");
        attributesProperties54.setValue("@Length(min = 9, max = 12, message = \"Size must be between 9 and 12 digits\")");
        Set<Imports> attributesPropertiesImports54 = new HashSet<Imports>();
//      ...................... import org.hibernate.validator.Length; ........................
        Imports attributePropertyImports40 = findBean.nameImports("import org.hibernate.validator.Length;",em);
        attributesPropertiesImports54.add(attributePropertyImports40);
        attributesProperties54.setImports(attributesPropertiesImports54);
        em.persist(attributesProperties54);
        em.flush();

        PropertiesAttributes attributesProperties55 = new PropertiesAttributes();
        attributesProperties55.setName("@Pattern1");
        attributesProperties55.setValue("@Pattern(regexp = \"[A-Za-z ]*\", message = \"must contain only letters and spaces\")");
        Set<Imports> attributesPropertiesImports55 = new HashSet<Imports>();
//      ...................... import javax.validation.constraints.Pattern; ........................
        Imports attributePropertyImports41 = findBean.nameImports("import javax.validation.constraints.Pattern;",em);
        attributesPropertiesImports55.add(attributePropertyImports41);
        attributesProperties55.setImports(attributesPropertiesImports55);
        em.persist(attributesProperties55);
        em.flush();

        PropertiesAttributes attributesProperties56 = new PropertiesAttributes();
        attributesProperties56.setName("@Pattern2");
        attributesProperties56.setValue("@Pattern(regexp = \"[^0-9]*\", message = \"Must not contain numbers\")");
        Set<Imports> attributesPropertiesImports56 = new HashSet<Imports>();
//      ...................... import javax.validation.constraints.Pattern; ........................
        Imports attributePropertyImports42 = findBean.nameImports("import javax.validation.constraints.Pattern;",em);
        attributesPropertiesImports56.add(attributePropertyImports42);
        attributesProperties56.setImports(attributesPropertiesImports56);
        em.persist(attributesProperties56);
        em.flush();

        PropertiesAttributes attributesProperties57 = new PropertiesAttributes();
        attributesProperties57.setName("@NotEmpty");
        attributesProperties57.setValue("@NotEmpty");
        Set<Imports> attributesPropertiesImports57 = new HashSet<Imports>();
//      ...................... import org.hibernate.validator.constraints.NotEmpty; ........................
        Imports attributePropertyImports43 = findBean.nameImports("import org.hibernate.validator.constraints.NotEmpty;",em);
        attributesPropertiesImports57.add(attributePropertyImports43);
        attributesProperties57.setImports(attributesPropertiesImports57);
        em.persist(attributesProperties57);
        em.flush();

        PropertiesAttributes attributesProperties58 = new PropertiesAttributes();
        attributesProperties58.setName("@Email");
        attributesProperties58.setValue("@Email(message = \"Invalid format\")");
        Set<Imports> attributesPropertiesImports58 = new HashSet<Imports>();
//      ...................... import org.hibernate.validator.constraints.Email; ........................
        Imports attributePropertyImports44 = findBean.nameImports("import org.hibernate.validator.constraints.Email;",em);
        attributesPropertiesImports58.add(attributePropertyImports44);
        attributesProperties58.setImports(attributesPropertiesImports58);
        em.persist(attributesProperties58);
        em.flush();

        PropertiesAttributes attributesProperties59 = new PropertiesAttributes();
        attributesProperties59.setName("@Digits0012");
        attributesProperties59.setValue("@Digits(fractionalDigits = 0, integerDigits = 12, message = \"Not allowed digit!\")");
        Set<Imports> attributesPropertiesImports59 = new HashSet<Imports>();
//      ...................... import javax.validation.constraints.Digits; ........................
        Imports attributePropertyImports45 = findBean.nameImports("import javax.validation.constraints.Digits;",em);
        attributesPropertiesImports59.add(attributePropertyImports45);
        attributesProperties59.setImports(attributesPropertiesImports59);
        em.persist(attributesProperties59);
        em.flush();

//      ---------------------- AttributesTypes ------------------------

        AttributesTypes attributesTypes1 = new AttributesTypes();
        attributesTypes1.setName("byte");
        attributesTypes1.setType("byte");
        attributesTypes1.setObservations("A uniform resource locator of a web resource");

        Set<PropertiesAttributes> attributesTypesAttributesProperties1 = new HashSet<PropertiesAttributes>();
//      ...................... @Basic1........................
        PropertiesAttributes attributeTypeAttributeProperty1 = findBean.nameAttributesProperties("@Basic1",em);
        attributesTypesAttributesProperties1.add(attributeTypeAttributeProperty1);
//      ...................... @Lob........................
        PropertiesAttributes attributeTypeAttributeProperty2 = findBean.nameAttributesProperties("@Lob",em);
        attributesTypesAttributesProperties1.add(attributeTypeAttributeProperty2);
        attributesTypes1.setPropertiesAttributes(attributesTypesAttributesProperties1);

        em.persist(attributesTypes1);
        em.flush();

        AttributesTypes attributesTypes2 = new AttributesTypes();
        attributesTypes2.setName("double");
        attributesTypes2.setType("double");
        attributesTypes2.setObservations("A uniform resource locator of a web resource");

        Set<PropertiesAttributes> attributesTypesAttributesProperties2 = new HashSet<PropertiesAttributes>();
//      ...................... @NumericField........................
        PropertiesAttributes attributeTypeAttributeProperty3 = findBean.nameAttributesProperties("@NumericField",em);
        attributesTypesAttributesProperties2.add(attributeTypeAttributeProperty3);
//      ...................... @Field1........................
        PropertiesAttributes attributeTypeAttributeProperty4 = findBean.nameAttributesProperties("@Field1",em);
        attributesTypesAttributesProperties2.add(attributeTypeAttributeProperty4);
        attributesTypes2.setPropertiesAttributes(attributesTypesAttributesProperties2);

        em.persist(attributesTypes2);
        em.flush();

        AttributesTypes attributesTypes3 = new AttributesTypes();
        attributesTypes3.setName("Email");
        attributesTypes3.setType("Email");
        attributesTypes3.setObservations("A uniform resource locator of a web resource");
        em.persist(attributesTypes3);
        em.flush();

        AttributesTypes attributesTypes4 = new AttributesTypes();
        attributesTypes4.setName("String");
        attributesTypes4.setType("String");
        attributesTypes4.setObservations("A \"short\" sequence of characters");

        Set<PropertiesAttributes> attributesTypesAttributesProperties4 = new HashSet<PropertiesAttributes>();
//      ...................... @Field1........................
        PropertiesAttributes attributeTypeAttributeProperty5 = findBean.nameAttributesProperties("@Field1",em);
        attributesTypesAttributesProperties4.add(attributeTypeAttributeProperty5);
        attributesTypes4.setPropertiesAttributes(attributesTypesAttributesProperties4);

        em.persist(attributesTypes4);
        em.flush();

        AttributesTypes attributesTypes5 = new AttributesTypes();
        attributesTypes5.setName("Text");
        attributesTypes5.setType("String");
        attributesTypes5.setObservations("A \"long\" sequence of characters");

        Set<PropertiesAttributes> attributesTypesAttributesProperties5 = new HashSet<PropertiesAttributes>();
//      ...................... @Field1........................
        PropertiesAttributes attributeTypeAttributeProperty6 = findBean.nameAttributesProperties("@Field1",em);
        attributesTypesAttributesProperties5.add(attributeTypeAttributeProperty6);
//      ...................... @Lob........................
        PropertiesAttributes attributeTypeAttributeProperty7 = findBean.nameAttributesProperties("@Lob",em);
        attributesTypesAttributesProperties5.add(attributeTypeAttributeProperty7);
        attributesTypes5.setPropertiesAttributes(attributesTypesAttributesProperties5);

        em.persist(attributesTypes5);
        em.flush();

        AttributesTypes attributesTypes6 = new AttributesTypes();
        attributesTypes6.setName("Integer");
        attributesTypes6.setType("Integer");
        attributesTypes6.setObservations("An integer numerical type");
        em.persist(attributesTypes6);
        em.flush();

        AttributesTypes attributesTypes7 = new AttributesTypes();
        attributesTypes7.setName("Float");
        attributesTypes7.setType("Float");
        attributesTypes7.setObservations("A floating point numerical type");
        em.persist(attributesTypes7);
        em.flush();

        AttributesTypes attributesTypes8 = new AttributesTypes();
        attributesTypes8.setName("Date");
        attributesTypes8.setType("Date");
        attributesTypes8.setObservations("A calendar date");

        Set<PropertiesAttributes> attributesTypesAttributesProperties8 = new HashSet<PropertiesAttributes>();
//      ...................... @Temporal........................
        PropertiesAttributes attributeTypeAttributeProperty8 = findBean.nameAttributesProperties("@Temporal",em);
        attributesTypesAttributesProperties8.add(attributeTypeAttributeProperty8);
//      ...................... @DateBridgeYE........................
        PropertiesAttributes attributeTypeAttributeProperty9 = findBean.nameAttributesProperties("@DateBridgeYE",em);
        attributesTypesAttributesProperties8.add(attributeTypeAttributeProperty9);
        attributesTypes8.setPropertiesAttributes(attributesTypesAttributesProperties8);

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
