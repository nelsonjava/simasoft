package co.simasoft.setup;

import co.simasoft.utils.*;
import co.simasoft.beans.*;

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
public class Setup extends FileTxt {

    @PersistenceContext(unitName = "naifg8PU-JTA")
    private EntityManager em;

    public void data() {

//      ---------------------- PropertiesAttributes -------------------------

        PropertiesAttributes varNotNull = new PropertiesAttributes();
        varNotNull.setOrden(1L);
        varNotNull.setName("@NotNull");
        varNotNull.setValue("@NotNull");
        em.persist(varNotNull);
        em.flush();

        PropertiesAttributes varSize0125 = new PropertiesAttributes();
        varSize0125.setOrden(2L);
        varSize0125.setName("@Size0125");
        varSize0125.setValue("@Size(min = 1, max = 25)");

        em.persist(varSize0125);
        em.flush();

        PropertiesAttributes varSize0912 = new PropertiesAttributes();
        varSize0912.setOrden(3L);
        varSize0912.setName("@Size0912");
        varSize0912.setValue("@Size(min = 9, max = 12)");
        em.persist(varSize0912);
        em.flush();

        PropertiesAttributes varLength0125 = new PropertiesAttributes();
        varLength0125.setOrden(4L);
        varLength0125.setName("@Length0125");
        varLength0125.setValue("@Length(min = 1, max = 25, message = \"Size must be between 1 and 25 digits\")");
        em.persist(varLength0125);
        em.flush();

        PropertiesAttributes varLength0912 = new PropertiesAttributes();
        varLength0912.setOrden(5L);
        varLength0912.setName("@Length0912");
        varLength0912.setValue("@Length(min = 9, max = 12, message = \"Size must be between 9 and 12 digits\")");
        em.persist(varLength0912);
        em.flush();

        PropertiesAttributes varPattern1 = new PropertiesAttributes();
        varPattern1.setOrden(6L);
        varPattern1.setName("@Pattern1");
        varPattern1.setValue("@Pattern(regexp = \"[A-Za-z ]*\", message = \"must contain only letters and spaces\")");

        em.persist(varPattern1);
        em.flush();

        PropertiesAttributes varPattern2 = new PropertiesAttributes();
        varPattern2.setOrden(7L);
        varPattern2.setName("@Pattern2");
        varPattern2.setValue("@Pattern(regexp = \"[^0-9]*\", message = \"Must not contain numbers\")");
        em.persist(varPattern2);
        em.flush();

        PropertiesAttributes varNotEmpty = new PropertiesAttributes();
        varNotEmpty.setOrden(8L);
        varNotEmpty.setName("@NotEmpty");
        varNotEmpty.setValue("@NotEmpty");
        em.persist(varNotEmpty);
        em.flush();

        PropertiesAttributes varEmail = new PropertiesAttributes();
        varEmail.setOrden(9L);
        varEmail.setName("@Email");
        varEmail.setValue("@Email(message = \"Invalid format\")");
        em.persist(varEmail);
        em.flush();

        PropertiesAttributes varDigits0012 = new PropertiesAttributes();
        varDigits0012.setOrden(10L);
        varDigits0012.setName("@Digits0012");
        varDigits0012.setValue("@Digits(fractionalDigits = 0, integerDigits = 12, message = \"Not allowed digit!\")");
        em.persist(varDigits0012);
        em.flush();

        PropertiesAttributes varColumn = new PropertiesAttributes();
        varColumn.setOrden(11L);
        varColumn.setName("@Column");
        varColumn.setValue("@Column");
        em.persist(varColumn);
        em.flush();

        PropertiesAttributes varNullUnique1 = new PropertiesAttributes();
        varNullUnique1.setOrden(12L);
        varNullUnique1.setName("NullUnique1");
        varNullUnique1.setValue("@Column(nullable = true, unique = true)");
        em.persist(varNullUnique1);
        em.flush();

        PropertiesAttributes varNullUnique2 = new PropertiesAttributes();
        varNullUnique2.setOrden(13L);
        varNullUnique2.setName("NullUnique2");
        varNullUnique2.setValue("@Column(nullable = true, unique = false)");
        em.persist(varNullUnique2);
        em.flush();

        PropertiesAttributes varNullUnique3 = new PropertiesAttributes();
        varNullUnique3.setOrden(14L);
        varNullUnique3.setName("NullUnique3");
        varNullUnique3.setValue("@Column(nullable = false, unique = true)");
        em.persist(varNullUnique3);
        em.flush();

        PropertiesAttributes varNullUnique4 = new PropertiesAttributes();
        varNullUnique4.setOrden(15L);
        varNullUnique4.setName("NullUnique4");
        varNullUnique4.setValue("@Column(nullable = false, unique = false)");
        em.persist(varNullUnique4);
        em.flush();

        PropertiesAttributes varBasic = new PropertiesAttributes();
        varBasic.setOrden(16L);
        varBasic.setName("@Basic");
        varBasic.setValue("@Basic");
        em.persist(varBasic);
        em.flush();

        PropertiesAttributes varBasic1 = new PropertiesAttributes();
        varBasic1.setOrden(17L);
        varBasic1.setName("@Basic1");
        varBasic1.setValue("@Basic(fetch=FetchType.LAZY)");
        em.persist(varBasic1);
        em.flush();

        PropertiesAttributes varLob = new PropertiesAttributes();
        varLob.setOrden(18L);
        varLob.setName("@Lob");
        varLob.setValue("@Lob");
        em.persist(varLob);
        em.flush();


    } // data

} // Setup
