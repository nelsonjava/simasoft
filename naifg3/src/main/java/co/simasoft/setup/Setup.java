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

//      ---------------------- Cardinalities -------------------------

        Cardinalities oto = new Cardinalities();
        oto.setOrden(1L);
        oto.setCardinality("1..1");
        oto.setName("Uno a Uno Unidireccional No.1");
        oto.setUnidireccional(true);
        em.persist(oto);
        em.flush();

        Cardinalities oob = new Cardinalities();
        oob.setOrden(2L);
        oob.setCardinality("1..1");
        oob.setName("Uno a Uno Bidirecccional No.2");
        oob.setUnidireccional(false);
        em.persist(oob);
        em.flush();

        Cardinalities mto = new Cardinalities();
        mto.setOrden(3L);
        mto.setCardinality("*..1");
        mto.setName("Muchos a Uno Unidireccional No.3");
        mto.setUnidireccional(true);
        em.persist(mto);
        em.flush();

        Cardinalities otm = new Cardinalities();
        otm.setOrden(4L);
        otm.setCardinality("1..*");
        otm.setName("Uno a Muchos Unidireccional No.4");
        otm.setUnidireccional(true);
        em.persist(otm);
        em.flush();

        Cardinalities omb = new Cardinalities();
        omb.setOrden(5L);
        omb.setCardinality("1..*");
        omb.setName("Uno a Muchos Bidirecccional No.5");
        omb.setUnidireccional(false);
        em.persist(omb);
        em.flush();

        Cardinalities mtm = new Cardinalities();
        mtm.setOrden(6L);
        mtm.setCardinality("*..*");
        mtm.setName("Muchos a Muchos Unidireccional No.6");
        mtm.setUnidireccional(true);
        em.persist(mtm);
        em.flush();

        Cardinalities mmb = new Cardinalities();
        mmb.setOrden(7L);
        mmb.setCardinality("*..*");
        mmb.setName("Muchos a Muchos Bidirecccional No.7");
        mmb.setUnidireccional(false);
        em.persist(mmb);
        em.flush();

//      ---------------------- TypesAttributes -------------------------

        TypesAttributes varString = new TypesAttributes();
        varString.setOrden(1L);
        varString.setName("String");
        varString.setType("String");
        varString.setObservaciones("A \"short\" sequence of characters");
        em.persist(varString);
        em.flush();

        TypesAttributes varText = new TypesAttributes();
        varText.setOrden(2L);
        varText.setName("Text");
        varText.setType("String");
        varText.setObservaciones("A \"long\" sequence of characters");
        em.persist(varText);
        em.flush();

        TypesAttributes varInteger = new TypesAttributes();
        varInteger.setOrden(3L);
        varInteger.setName("Integer");
        varInteger.setType("Integer");
        varInteger.setObservaciones("An integer numerical type");
        em.persist(varInteger);
        em.flush();

        TypesAttributes varFloat = new TypesAttributes();
        varFloat.setOrden(4L);
        varFloat.setName("Float");
        varFloat.setType("Float");
        varFloat.setObservaciones("A floating point numerical type");
        em.persist(varFloat);
        em.flush();

        TypesAttributes varDate = new TypesAttributes();
        varDate.setOrden(5L);
        varDate.setName("Date");
        varDate.setType("Date");
        varDate.setObservaciones("A calendar date");
        em.persist(varDate);
        em.flush();

        TypesAttributes varTime = new TypesAttributes();
        varTime.setOrden(6L);
        varTime.setName("Time");
        varTime.setType("Date");
        varTime.setObservaciones("A temporal instant of time");
        em.persist(varTime);
        em.flush();

        TypesAttributes varBoolean = new TypesAttributes();
        varBoolean.setOrden(7L);
        varBoolean.setName("Boolean");
        varBoolean.setType("Boolean");
        varBoolean.setObservaciones("A true or false value");
        em.persist(varBoolean);
        em.flush();

        TypesAttributes varEnumeration = new TypesAttributes();
        varEnumeration.setOrden(8L);
        varEnumeration.setName("Enumeration");
        varEnumeration.setType("Enumeration");
        varEnumeration.setObservaciones("A sequence of user-defined values");
        em.persist(varEnumeration);
        em.flush();

        TypesAttributes varBlob = new TypesAttributes();
        varBlob.setOrden(9L);
        varBlob.setName("Blob");
        varBlob.setType("Blob");
        varBlob.setObservaciones("A binanry large object, for example an image or a video, which must be handled in a special way because of its size. Blob type can be further refined by expressing their MIME type for example image/gif");
        em.persist(varBlob);
        em.flush();

        TypesAttributes varUrl = new TypesAttributes();
        varUrl.setOrden(10L);
        varUrl.setName("Url");
        varUrl.setType("Url");
        varUrl.setObservaciones("A uniform resource locator of a web resource");
        em.persist(varUrl);
        em.flush();

        TypesAttributes varByte = new TypesAttributes();
        varByte.setOrden(11L);
        varByte.setName("byte");
        varByte.setType("byte");
        varByte.setObservaciones("A uniform resource locator of a web resource");
        em.persist(varByte);
        em.flush();

        TypesAttributes varDouble = new TypesAttributes();
        varDouble.setOrden(12L);
        varDouble.setName("double");
        varDouble.setType("double");
        varDouble.setObservaciones("A uniform resource locator of a web resource");
        em.persist(varDouble);
        em.flush();

        TypesAttributes varEmails = new TypesAttributes();
        varEmails.setOrden(13L);
        varEmails.setName("Email");
        varEmails.setType("Email");
        varEmails.setObservaciones("A uniform resource locator of a web resource");
        em.persist(varEmails);
        em.flush();


//      ---------------------- Imports() -------------------------

        Imports imports1 = new Imports();
        imports1.setOrden(1L);
        imports1.setName("import javax.persistence.Column;");
        em.persist(imports1);
        em.flush();

        Imports imports2 = new Imports();
        imports2.setOrden(2L);
        imports2.setName("import javax.persistence.Basic;");
        em.persist(imports2);
        em.flush();

        Imports imports3 = new Imports();
        imports3.setOrden(3L);
        imports3.setName("import javax.validation.constraints.NotNull;");
        em.persist(imports3);
        em.flush();

        Imports imports4 = new Imports();
        imports4.setOrden(4L);
        imports4.setName("import javax.validation.constraints.Size;");
        em.persist(imports4);
        em.flush();

        Imports imports5 = new Imports();
        imports5.setOrden(5L);
        imports5.setName("import javax.validation.constraints.Pattern;");
        em.persist(imports5);
        em.flush();

        Imports imports6 = new Imports();
        imports6.setOrden(6L);
        imports6.setName("import javax.validation.constraints.Digits;");
        em.persist(imports6);
        em.flush();

        Imports imports7 = new Imports();
        imports7.setOrden(7L);
        imports7.setName("import org.hibernate.validator.Length;");
        em.persist(imports7);
        em.flush();

        Imports imports8 = new Imports();
        imports8.setOrden(8L);
        imports8.setName("import org.hibernate.validator.constraints.NotEmpty;");
        em.persist(imports8);
        em.flush();

        Imports imports9 = new Imports();
        imports9.setOrden(9L);
        imports9.setName("import org.hibernate.validator.constraints.Email;");
        em.persist(imports9);
        em.flush();

//      ---------------------- PropertiesAttributes -------------------------


        PropertiesAttributes varNotNull = new PropertiesAttributes();
        varNotNull.setOrden(1L);
        varNotNull.setName("@NotNull");
        varNotNull.setValue("@NotNull");
        varNotNull.setImports(imports3);
        em.persist(varNotNull);
        em.flush();

        PropertiesAttributes varSize0125 = new PropertiesAttributes();
        varSize0125.setOrden(2L);
        varSize0125.setName("@Size0125");
        varSize0125.setValue("@Size(min = 1, max = 25)");
        varSize0125.setImports(imports4);
        em.persist(varSize0125);
        em.flush();

        PropertiesAttributes varSize0912 = new PropertiesAttributes();
        varSize0912.setOrden(3L);
        varSize0912.setName("@Size0912");
        varSize0912.setValue("@Size(min = 9, max = 12)");
        varSize0912.setImports(imports4);
        em.persist(varSize0912);
        em.flush();

        PropertiesAttributes varLength0125 = new PropertiesAttributes();
        varLength0125.setOrden(4L);
        varLength0125.setName("@Length0125");
        varLength0125.setValue("@Length(min = 1, max = 25, message = \"Size must be between 1 and 25 digits\")");
        varLength0125.setImports(imports7);
        em.persist(varLength0125);
        em.flush();

        PropertiesAttributes varLength0912 = new PropertiesAttributes();
        varLength0912.setOrden(5L);
        varLength0912.setName("@Length0912");
        varLength0912.setValue("@Length(min = 9, max = 12, message = \"Size must be between 9 and 12 digits\")");
        varLength0912.setImports(imports7);
        em.persist(varLength0912);
        em.flush();

        PropertiesAttributes varPattern1 = new PropertiesAttributes();
        varPattern1.setOrden(6L);
        varPattern1.setName("@Pattern1");
        varPattern1.setValue("@Pattern(regexp = \"[A-Za-z ]*\", message = \"must contain only letters and spaces\")");
        varPattern1.setImports(imports5);
        em.persist(varPattern1);
        em.flush();

        PropertiesAttributes varPattern2 = new PropertiesAttributes();
        varPattern2.setOrden(7L);
        varPattern2.setName("@Pattern2");
        varPattern2.setValue("@Pattern(regexp = \"[^0-9]*\", message = \"Must not contain numbers\")");
        varPattern2.setImports(imports5);
        em.persist(varPattern2);
        em.flush();

        PropertiesAttributes varNotEmpty = new PropertiesAttributes();
        varNotEmpty.setOrden(8L);
        varNotEmpty.setName("@NotEmpty");
        varNotEmpty.setValue("@NotEmpty");
        varNotEmpty.setImports(imports8);
        em.persist(varNotEmpty);
        em.flush();

        PropertiesAttributes varEmail = new PropertiesAttributes();
        varEmail.setOrden(9L);
        varEmail.setName("@Email");
        varEmail.setValue("@Email(message = \"Invalid format\")");
        varEmail.setImports(imports9);
        em.persist(varEmail);
        em.flush();

        PropertiesAttributes varDigits0012 = new PropertiesAttributes();
        varDigits0012.setOrden(10L);
        varDigits0012.setName("@Digits0012");
        varDigits0012.setValue("@Digits(fractionalDigits = 0, integerDigits = 12, message = \"Not allowed digit!\")");
        varDigits0012.setImports(imports6);
        em.persist(varDigits0012);
        em.flush();

        PropertiesAttributes varColumn = new PropertiesAttributes();
        varColumn.setOrden(11L);
        varColumn.setName("@Column");
        varColumn.setValue("@Column");
        varColumn.setImports(imports1);
        em.persist(varColumn);
        em.flush();

        PropertiesAttributes varNullUnique1 = new PropertiesAttributes();
        varNullUnique1.setOrden(12L);
        varNullUnique1.setName("NullUnique1");
        varNullUnique1.setValue("@Column(nullable = true, unique = true)");
        varNullUnique1.setImports(imports1);
        em.persist(varNullUnique1);
        em.flush();

        PropertiesAttributes varNullUnique2 = new PropertiesAttributes();
        varNullUnique2.setOrden(13L);
        varNullUnique2.setName("NullUnique2");
        varNullUnique2.setValue("@Column(nullable = true, unique = false)");
        varNullUnique2.setImports(imports1);
        em.persist(varNullUnique2);
        em.flush();

        PropertiesAttributes varNullUnique3 = new PropertiesAttributes();
        varNullUnique3.setOrden(14L);
        varNullUnique3.setName("NullUnique3");
        varNullUnique3.setValue("@Column(nullable = false, unique = true)");
        varNullUnique3.setImports(imports1);
        em.persist(varNullUnique3);
        em.flush();

        PropertiesAttributes varNullUnique4 = new PropertiesAttributes();
        varNullUnique4.setOrden(15L);
        varNullUnique4.setName("NullUnique4");
        varNullUnique4.setValue("@Column(nullable = false, unique = false)");
        varNullUnique4.setImports(imports1);
        em.persist(varNullUnique4);
        em.flush();

        PropertiesAttributes varBasic = new PropertiesAttributes();
        varBasic.setOrden(16L);
        varBasic.setName("@Basic");
        varBasic.setValue("@Basic");
        varBasic.setImports(imports2);
        em.persist(varBasic);
        em.flush();

    } // data()

} // DomainModelsSetup

