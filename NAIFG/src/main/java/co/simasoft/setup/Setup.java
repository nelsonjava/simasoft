package co.simasoft.setup;

import co.simasoft.models.naif.DomainModels.*;

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

        System.out.println("Cardinalities!");

        Cardinalities oto = new Cardinalities();
        oto.setCardinality("1..1");
        oto.setName("Uno a Uno Unidireccional No.1");
        oto.setUnidireccional(true);
        em.persist(oto);
        em.flush();

        Cardinalities oob = new Cardinalities();
        oob.setCardinality("1..1");
        oob.setName("Uno a Uno Bidirecccional No.2");
        oob.setUnidireccional(false);
        em.persist(oob);
        em.flush();

        Cardinalities mto = new Cardinalities();
        mto.setCardinality("*..1");
        mto.setName("Muchos a Uno Unidireccional No.3");
        mto.setUnidireccional(true);
        em.persist(mto);
        em.flush();

        Cardinalities otm = new Cardinalities();
        otm.setCardinality("1..*");
        otm.setName("Uno a Muchos Unidireccional No.4");
        otm.setUnidireccional(true);
        em.persist(otm);
        em.flush();

        Cardinalities omb = new Cardinalities();
        omb.setCardinality("1..*");
        omb.setName("Uno a Muchos Bidirecccional No.5");
        omb.setUnidireccional(false);
        em.persist(omb);
        em.flush();

        Cardinalities mtm = new Cardinalities();
        mtm.setCardinality("*..*");
        mtm.setName("Muchos a Muchos Unidireccional No.6");
        mtm.setUnidireccional(true);
        em.persist(mtm);
        em.flush();

        Cardinalities mmb = new Cardinalities();
        mmb.setCardinality("*..*");
        mmb.setName("Muchos a Muchos Bidirecccional No.6");
        mmb.setUnidireccional(false);
        em.persist(mmb);
        em.flush();

        TypesAttributes varString = new TypesAttributes();
        varString.setName("String");
        varString.setObservaciones("A \"short\" sequence of characters");
        em.persist(varString);
        em.flush();

        TypesAttributes varText = new TypesAttributes();
        varText.setName("Text");
        varText.setObservaciones("A \"long\" sequence of characters");
        em.persist(varText);
        em.flush();

        TypesAttributes varInteger = new TypesAttributes();
        varInteger.setName("Integer");
        varInteger.setObservaciones("An integer numerical type");
        em.persist(varInteger);
        em.flush();

        TypesAttributes varFloat = new TypesAttributes();
        varFloat.setName("Float");
        varFloat.setObservaciones("A floating point numerical type");
        em.persist(varFloat);
        em.flush();

        TypesAttributes varDate = new TypesAttributes();
        varDate.setName("Date");
        varDate.setObservaciones("A calendar date");
        em.persist(varDate);
        em.flush();

        TypesAttributes varTime = new TypesAttributes();
        varTime.setName("Time");
        varTime.setObservaciones("A temporal instant of time");
        em.persist(varTime);
        em.flush();

        TypesAttributes varBoolean = new TypesAttributes();
        varBoolean.setName("Boolean");
        varBoolean.setObservaciones("A true or false value");
        em.persist(varBoolean);
        em.flush();

        TypesAttributes varEnumeration = new TypesAttributes();
        varEnumeration.setName("Enumeration");
        varEnumeration.setObservaciones("A sequence of user-defined values");
        em.persist(varEnumeration);
        em.flush();

        TypesAttributes varBlob = new TypesAttributes();
        varBlob.setName("Blob");
        varBlob.setObservaciones("A binanry large object, for example an image or a video, which must be handled in a special way because of its size. Blob type can be further refined by expressing their MIME type for example image/gif");
        em.persist(varBlob);
        em.flush();

        TypesAttributes varUrl = new TypesAttributes();
        varUrl.setName("Url");
        varUrl.setObservaciones("A uniform resource locator of a web resource");
        em.persist(varUrl);
        em.flush();

    } // data()

} // DomainModelsSetup

