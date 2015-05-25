package co.simasoft.setup;

import co.simasoft.models.naif.domainmodels.*;

import co.simasoft.utils.*;

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
@Named("DomainModelsSetup")
public class DomainModelsSetup {

    private static final String QUERYA = "SELECT c FROM TypesAttributes c WHERE c.name LIKE :custName";
    private static final String QUERYB = "SELECT c FROM Entities c WHERE c.name LIKE :custName";
    private static final String QUERYC = "SELECT c FROM Cardinalities c WHERE c.name LIKE :custName";

    @PersistenceContext(unitName = "DomainModelsPU-JTA")
    private EntityManager em;

    private static final Logger log = Logger.getLogger(DomainModelsSetup.class.getName());


    public TypesAttributes findTypesAttributes(String name) {

        TypesAttributes typesAttributes = new TypesAttributes();
//        List<TypesAttributes> results = em.createQuery(QUERYA).setParameter("custName", name).getResultList();
/*
        List<TypesAttributes> results = em.createNamedQuery("AttributesTypes.findByName",
                                                            TypesAttributes.class).setParameter("custName", name).getResultList();
*/
        List<TypesAttributes> results = em.createNamedQuery("AttributesTypes.findByName",
                                                            TypesAttributes.class).getResultList();

        if (!results.isEmpty()) {
           typesAttributes = results.get(0);
        }
        return typesAttributes;
    }


    public Entities findEntities(String name) {

        Entities entities = new Entities();
        List<Entities> results = em.createQuery(QUERYB).setParameter("custName", name).getResultList();

        if (!results.isEmpty()) {
           entities = results.get(0);
        }
        return entities;
    }

    public Cardinalities findCardinalities(String name) {

        Cardinalities cardinalities = new Cardinalities();
        List<Cardinalities> results = em.createQuery(QUERYC).setParameter("custName", name).getResultList();

        if (!results.isEmpty()) {
           cardinalities = results.get(0);
        }
        return cardinalities;
    }

    public void data() {

        DomainModels domainModels = new DomainModels();
        domainModels.setName(Utils.nameRandom());
        em.persist(domainModels);
        em.flush();

        GroupIds groupIds = new GroupIds();
        groupIds.setGroupId(Utils.nameRandom());
        groupIds.setDomainModels(domainModels);
        em.persist(groupIds);
        em.flush();

        Relationships(groupIds);
/*
        Entities(groupIds);
        Attributes(groupIds);
        Cardinalities(groupIds);
        GroupIds(groupIds);
        PropertiesAttributes(groupIds);
        FilesModels(groupIds);
        LinksModels(groupIds);
        TiposLinksModels(groupIds);
        NameQueries(groupIds);
        TypesAttributes(groupIds);
        DomainModels(groupIds);
        SystemsModels(groupIds);
        Imports(groupIds);
        Dependency(groupIds);
        Relations();
*/

    } // data()

    public void Relationships(GroupIds groupIds) {

        Entities relationships = new Entities();
        relationships.setName("Relationships");
        relationships.setGroupIds(groupIds);
        em.persist(relationships);
        em.flush();

//      ---------------------- Attributes:Relationships -------------------------


        TypesAttributes typesentity = new TypesAttributes();
        typesentity = findTypesAttributes("String");

        Attributes entity = new Attributes();
        entity.setName("entity");
        entity.setNullable(true);
        entity.setUnico(false);
        entity.setTypesAttributes(typesentity);
        entity.setEntities(relationships);
        em.persist(entity);
        em.flush();


    } // Relationships()

} // DomainModelsSetup

