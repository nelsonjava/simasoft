import co.simasoft.models.naif.domainmodels.*;

import co.simasoft.beans.*;

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
@Named("naifgSetup")
public class naifgSetup {

    @PersistenceContext(unitName = "naifg8PU-JTA")
    private EntityManager em;

    FindBean findBean = new FindBean();

    private static final Logger log = Logger.getLogger(DataDb.class.getName());

    public void data() {

//      ---------------------- DomainModels ------------------------

        DomainModels domainModels = new DomainModels();
        domainModels.setGroupId("co.simasoft");
        domainModels.setArtifactId("naifg");
        domainModels.setVersion("1.0-SNAPSHOT");
        em.persist(domainModels);
        em.flush();

//      ---------------------- GroupIds ------------------------

        GroupIds groupIds1 = new GroupIds();
        groupIds1.setGroupId("co.simasoft.models.dev.naifg");
//      ...................... naifg ........................
        DomainModels domainModel1 = new DomainModels();
        domainModel1 = findBean.artifactIdDomainModels("naifg",em);
        groupIds1.setDomainModels(domainModel1);
        em.persist(groupIds1);
        em.flush();

//      ---------------------- Entities ------------------------

        GroupIds groupIds2 = new GroupIds();
        groupIds2.setGroupId("co.simasoft.models.dev.naifg");
//      ...................... naifg ........................
        DomainModels domainModel2 = new DomainModels();
        domainModel2 = findBean.artifactIdDomainModels("naifg",em);
        groupIds2.setDomainModels(domainModel2);
        em.persist(groupIds2);
        em.flush();

//      ---------------------- Entities ------------------------

        Entities entities3 = new Entities();
        entities3.setName("Entities");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId3 = new GroupIds();
        groupId3 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities3.setGroupIds(groupId3);
        em.persist(entities3);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes4 = new Attributes();
        attributes4.setName("name");
        attributes4.setNullable(false);
        attributes4.setSingle(false);
//      ...................... Entities ........................
        Entities entity4 = new Entities();
        entity4 = findBean.nameEntities("Entities",em);
        attributes4.setEntities(entity4);
//      ...................... String ........................
        AttributesTypes attributesTypes5 = new AttributesTypes();
        attributesTypes5 = findBean.nameAttributesTypes("String",em);
        attributes4.setAttributesTypes(attributesTypes5);
        em.persist(attributes4);
        em.flush();

        Attributes attributes5 = new Attributes();
        attributes5.setName("serialID");
        attributes5.setNullable(true);
        attributes5.setSingle(true);
//      ...................... Entities ........................
        Entities entity6 = new Entities();
        entity6 = findBean.nameEntities("Entities",em);
        attributes5.setEntities(entity6);
//      ...................... String ........................
        AttributesTypes attributesTypes7 = new AttributesTypes();
        attributesTypes7 = findBean.nameAttributesTypes("String",em);
        attributes5.setAttributesTypes(attributesTypes7);
        em.persist(attributes5);
        em.flush();

        Attributes attributes6 = new Attributes();
        attributes6.setName("table");
        attributes6.setNullable(true);
        attributes6.setSingle(false);
//      ...................... Entities ........................
        Entities entity8 = new Entities();
        entity8 = findBean.nameEntities("Entities",em);
        attributes6.setEntities(entity8);
//      ...................... String ........................
        AttributesTypes attributesTypes9 = new AttributesTypes();
        attributesTypes9 = findBean.nameAttributesTypes("String",em);
        attributes6.setAttributesTypes(attributesTypes9);
        em.persist(attributes6);
        em.flush();

        Attributes attributes7 = new Attributes();
        attributes7.setName("tableSecuencia");
        attributes7.setNullable(true);
        attributes7.setSingle(false);
//      ...................... Entities ........................
        Entities entity10 = new Entities();
        entity10 = findBean.nameEntities("Entities",em);
        attributes7.setEntities(entity10);
//      ...................... String ........................
        AttributesTypes attributesTypes11 = new AttributesTypes();
        attributesTypes11 = findBean.nameAttributesTypes("String",em);
        attributes7.setAttributesTypes(attributesTypes11);
        em.persist(attributes7);
        em.flush();

        Attributes attributes8 = new Attributes();
        attributes8.setName("modifier");
        attributes8.setNullable(true);
        attributes8.setSingle(false);
//      ...................... Entities ........................
        Entities entity12 = new Entities();
        entity12 = findBean.nameEntities("Entities",em);
        attributes8.setEntities(entity12);
//      ...................... String ........................
        AttributesTypes attributesTypes13 = new AttributesTypes();
        attributesTypes13 = findBean.nameAttributesTypes("String",em);
        attributes8.setAttributesTypes(attributesTypes13);
        em.persist(attributes8);
        em.flush();

        Attributes attributes9 = new Attributes();
        attributes9.setName("extend");
        attributes9.setNullable(true);
        attributes9.setSingle(false);
//      ...................... Entities ........................
        Entities entity14 = new Entities();
        entity14 = findBean.nameEntities("Entities",em);
        attributes9.setEntities(entity14);
//      ...................... String ........................
        AttributesTypes attributesTypes15 = new AttributesTypes();
        attributesTypes15 = findBean.nameAttributesTypes("String",em);
        attributes9.setAttributesTypes(attributesTypes15);
        em.persist(attributes9);
        em.flush();

        Attributes attributes10 = new Attributes();
        attributes10.setName("annotations");
        attributes10.setNullable(true);
        attributes10.setSingle(false);
//      ...................... Entities ........................
        Entities entity16 = new Entities();
        entity16 = findBean.nameEntities("Entities",em);
        attributes10.setEntities(entity16);
//      ...................... String ........................
        AttributesTypes attributesTypes17 = new AttributesTypes();
        attributesTypes17 = findBean.nameAttributesTypes("String",em);
        attributes10.setAttributesTypes(attributesTypes17);
        em.persist(attributes10);
        em.flush();

        Attributes attributes11 = new Attributes();
        attributes11.setName("source");
        attributes11.setNullable(true);
        attributes11.setSingle(false);
//      ...................... Entities ........................
        Entities entity18 = new Entities();
        entity18 = findBean.nameEntities("Entities",em);
        attributes11.setEntities(entity18);
//      ...................... String ........................
        AttributesTypes attributesTypes19 = new AttributesTypes();
        attributesTypes19 = findBean.nameAttributesTypes("String",em);
        attributes11.setAttributesTypes(attributesTypes19);
        em.persist(attributes11);
        em.flush();

        Attributes attributes12 = new Attributes();
        attributes12.setName("description");
        attributes12.setNullable(true);
        attributes12.setSingle(false);
//      ...................... Entities ........................
        Entities entity20 = new Entities();
        entity20 = findBean.nameEntities("Entities",em);
        attributes12.setEntities(entity20);
//      ...................... String ........................
        AttributesTypes attributesTypes21 = new AttributesTypes();
        attributesTypes21 = findBean.nameAttributesTypes("String",em);
        attributes12.setAttributesTypes(attributesTypes21);
        em.persist(attributes12);
        em.flush();

        Attributes attributes13 = new Attributes();
        attributes13.setName("observations");
        attributes13.setNullable(true);
        attributes13.setSingle(false);
//      ...................... Entities ........................
        Entities entity22 = new Entities();
        entity22 = findBean.nameEntities("Entities",em);
        attributes13.setEntities(entity22);
//      ...................... String ........................
        AttributesTypes attributesTypes23 = new AttributesTypes();
        attributesTypes23 = findBean.nameAttributesTypes("String",em);
        attributes13.setAttributesTypes(attributesTypes23);
        em.persist(attributes13);
        em.flush();

        Entities entities14 = new Entities();
        entities14.setName("GroupIds");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId24 = new GroupIds();
        groupId24 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities14.setGroupIds(groupId24);
        em.persist(entities14);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes15 = new Attributes();
        attributes15.setName("name");
        attributes15.setNullable(false);
        attributes15.setSingle(true);
//      ...................... GroupIds ........................
        Entities entity25 = new Entities();
        entity25 = findBean.nameEntities("GroupIds",em);
        attributes15.setEntities(entity25);
//      ...................... String ........................
        AttributesTypes attributesTypes26 = new AttributesTypes();
        attributesTypes26 = findBean.nameAttributesTypes("String",em);
        attributes15.setAttributesTypes(attributesTypes26);
        em.persist(attributes15);
        em.flush();

        Attributes attributes16 = new Attributes();
        attributes16.setName("groupId");
        attributes16.setNullable(false);
        attributes16.setSingle(false);
//      ...................... GroupIds ........................
        Entities entity27 = new Entities();
        entity27 = findBean.nameEntities("GroupIds",em);
        attributes16.setEntities(entity27);
//      ...................... String ........................
        AttributesTypes attributesTypes28 = new AttributesTypes();
        attributesTypes28 = findBean.nameAttributesTypes("String",em);
        attributes16.setAttributesTypes(attributesTypes28);
        em.persist(attributes16);
        em.flush();

        Attributes attributes17 = new Attributes();
        attributes17.setName("artifactId");
        attributes17.setNullable(true);
        attributes17.setSingle(true);
//      ...................... GroupIds ........................
        Entities entity29 = new Entities();
        entity29 = findBean.nameEntities("GroupIds",em);
        attributes17.setEntities(entity29);
//      ...................... String ........................
        AttributesTypes attributesTypes30 = new AttributesTypes();
        attributesTypes30 = findBean.nameAttributesTypes("String",em);
        attributes17.setAttributesTypes(attributesTypes30);
        em.persist(attributes17);
        em.flush();

        Attributes attributes18 = new Attributes();
        attributes18.setName("version");
        attributes18.setNullable(true);
        attributes18.setSingle(false);
//      ...................... GroupIds ........................
        Entities entity31 = new Entities();
        entity31 = findBean.nameEntities("GroupIds",em);
        attributes18.setEntities(entity31);
//      ...................... String ........................
        AttributesTypes attributesTypes32 = new AttributesTypes();
        attributesTypes32 = findBean.nameAttributesTypes("String",em);
        attributes18.setAttributesTypes(attributesTypes32);
        em.persist(attributes18);
        em.flush();

        Attributes attributes19 = new Attributes();
        attributes19.setName("code");
        attributes19.setNullable(true);
        attributes19.setSingle(true);
//      ...................... GroupIds ........................
        Entities entity33 = new Entities();
        entity33 = findBean.nameEntities("GroupIds",em);
        attributes19.setEntities(entity33);
//      ...................... String ........................
        AttributesTypes attributesTypes34 = new AttributesTypes();
        attributesTypes34 = findBean.nameAttributesTypes("String",em);
        attributes19.setAttributesTypes(attributesTypes34);
        em.persist(attributes19);
        em.flush();

        Attributes attributes20 = new Attributes();
        attributes20.setName("date");
        attributes20.setNullable(true);
        attributes20.setSingle(false);
//      ...................... GroupIds ........................
        Entities entity35 = new Entities();
        entity35 = findBean.nameEntities("GroupIds",em);
        attributes20.setEntities(entity35);
//      ...................... Date ........................
        AttributesTypes attributesTypes36 = new AttributesTypes();
        attributesTypes36 = findBean.nameAttributesTypes("Date",em);
        attributes20.setAttributesTypes(attributesTypes36);
        em.persist(attributes20);
        em.flush();

        Entities entities21 = new Entities();
        entities21.setName("Relationships");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId37 = new GroupIds();
        groupId37 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities21.setGroupIds(groupId37);
        em.persist(entities21);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes22 = new Attributes();
        attributes22.setName("name");
        attributes22.setNullable(true);
        attributes22.setSingle(false);
//      ...................... Relationships ........................
        Entities entity38 = new Entities();
        entity38 = findBean.nameEntities("Relationships",em);
        attributes22.setEntities(entity38);
//      ...................... String ........................
        AttributesTypes attributesTypes39 = new AttributesTypes();
        attributesTypes39 = findBean.nameAttributesTypes("String",em);
        attributes22.setAttributesTypes(attributesTypes39);
        em.persist(attributes22);
        em.flush();

        Attributes attributes23 = new Attributes();
        attributes23.setName("optionality");
        attributes23.setNullable(true);
        attributes23.setSingle(false);
//      ...................... Relationships ........................
        Entities entity40 = new Entities();
        entity40 = findBean.nameEntities("Relationships",em);
        attributes23.setEntities(entity40);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes41 = new AttributesTypes();
        attributesTypes41 = findBean.nameAttributesTypes("Boolean",em);
        attributes23.setAttributesTypes(attributesTypes41);
        em.persist(attributes23);
        em.flush();

        Attributes attributes24 = new Attributes();
        attributes24.setName("isEmbedded");
        attributes24.setNullable(true);
        attributes24.setSingle(false);
//      ...................... Relationships ........................
        Entities entity42 = new Entities();
        entity42 = findBean.nameEntities("Relationships",em);
        attributes24.setEntities(entity42);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes43 = new AttributesTypes();
        attributesTypes43 = findBean.nameAttributesTypes("Boolean",em);
        attributes24.setAttributesTypes(attributesTypes43);
        em.persist(attributes24);
        em.flush();

        Attributes attributes25 = new Attributes();
        attributes25.setName("observations");
        attributes25.setNullable(true);
        attributes25.setSingle(false);
//      ...................... Relationships ........................
        Entities entity44 = new Entities();
        entity44 = findBean.nameEntities("Relationships",em);
        attributes25.setEntities(entity44);
//      ...................... String ........................
        AttributesTypes attributesTypes45 = new AttributesTypes();
        attributesTypes45 = findBean.nameAttributesTypes("String",em);
        attributes25.setAttributesTypes(attributesTypes45);
        em.persist(attributes25);
        em.flush();

        Entities entities26 = new Entities();
        entities26.setName("NameQueries");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId46 = new GroupIds();
        groupId46 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities26.setGroupIds(groupId46);
        em.persist(entities26);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes27 = new Attributes();
        attributes27.setName("name");
        attributes27.setNullable(false);
        attributes27.setSingle(true);
//      ...................... NameQueries ........................
        Entities entity47 = new Entities();
        entity47 = findBean.nameEntities("NameQueries",em);
        attributes27.setEntities(entity47);
//      ...................... String ........................
        AttributesTypes attributesTypes48 = new AttributesTypes();
        attributesTypes48 = findBean.nameAttributesTypes("String",em);
        attributes27.setAttributesTypes(attributesTypes48);
        em.persist(attributes27);
        em.flush();

        Attributes attributes28 = new Attributes();
        attributes28.setName("query");
        attributes28.setNullable(false);
        attributes28.setSingle(true);
//      ...................... NameQueries ........................
        Entities entity49 = new Entities();
        entity49 = findBean.nameEntities("NameQueries",em);
        attributes28.setEntities(entity49);
//      ...................... String ........................
        AttributesTypes attributesTypes50 = new AttributesTypes();
        attributesTypes50 = findBean.nameAttributesTypes("String",em);
        attributes28.setAttributesTypes(attributesTypes50);
        em.persist(attributes28);
        em.flush();

        Attributes attributes29 = new Attributes();
        attributes29.setName("observations");
        attributes29.setNullable(true);
        attributes29.setSingle(false);
//      ...................... NameQueries ........................
        Entities entity51 = new Entities();
        entity51 = findBean.nameEntities("NameQueries",em);
        attributes29.setEntities(entity51);
//      ...................... String ........................
        AttributesTypes attributesTypes52 = new AttributesTypes();
        attributesTypes52 = findBean.nameAttributesTypes("String",em);
        attributes29.setAttributesTypes(attributesTypes52);
        em.persist(attributes29);
        em.flush();

        Entities entities30 = new Entities();
        entities30.setName("Models");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId53 = new GroupIds();
        groupId53 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities30.setGroupIds(groupId53);
        em.persist(entities30);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes31 = new Attributes();
        attributes31.setName("name");
        attributes31.setNullable(false);
        attributes31.setSingle(true);
//      ...................... Models ........................
        Entities entity54 = new Entities();
        entity54 = findBean.nameEntities("Models",em);
        attributes31.setEntities(entity54);
//      ...................... String ........................
        AttributesTypes attributesTypes55 = new AttributesTypes();
        attributesTypes55 = findBean.nameAttributesTypes("String",em);
        attributes31.setAttributesTypes(attributesTypes55);
        em.persist(attributes31);
        em.flush();

        Attributes attributes32 = new Attributes();
        attributes32.setName("groupId");
        attributes32.setNullable(false);
        attributes32.setSingle(false);
//      ...................... Models ........................
        Entities entity56 = new Entities();
        entity56 = findBean.nameEntities("Models",em);
        attributes32.setEntities(entity56);
//      ...................... String ........................
        AttributesTypes attributesTypes57 = new AttributesTypes();
        attributesTypes57 = findBean.nameAttributesTypes("String",em);
        attributes32.setAttributesTypes(attributesTypes57);
        em.persist(attributes32);
        em.flush();

        Attributes attributes33 = new Attributes();
        attributes33.setName("artifactId");
        attributes33.setNullable(true);
        attributes33.setSingle(true);
//      ...................... Models ........................
        Entities entity58 = new Entities();
        entity58 = findBean.nameEntities("Models",em);
        attributes33.setEntities(entity58);
//      ...................... String ........................
        AttributesTypes attributesTypes59 = new AttributesTypes();
        attributesTypes59 = findBean.nameAttributesTypes("String",em);
        attributes33.setAttributesTypes(attributesTypes59);
        em.persist(attributes33);
        em.flush();

        Attributes attributes34 = new Attributes();
        attributes34.setName("version");
        attributes34.setNullable(true);
        attributes34.setSingle(false);
//      ...................... Models ........................
        Entities entity60 = new Entities();
        entity60 = findBean.nameEntities("Models",em);
        attributes34.setEntities(entity60);
//      ...................... String ........................
        AttributesTypes attributesTypes61 = new AttributesTypes();
        attributesTypes61 = findBean.nameAttributesTypes("String",em);
        attributes34.setAttributesTypes(attributesTypes61);
        em.persist(attributes34);
        em.flush();

        Attributes attributes35 = new Attributes();
        attributes35.setName("code");
        attributes35.setNullable(true);
        attributes35.setSingle(true);
//      ...................... Models ........................
        Entities entity62 = new Entities();
        entity62 = findBean.nameEntities("Models",em);
        attributes35.setEntities(entity62);
//      ...................... String ........................
        AttributesTypes attributesTypes63 = new AttributesTypes();
        attributesTypes63 = findBean.nameAttributesTypes("String",em);
        attributes35.setAttributesTypes(attributesTypes63);
        em.persist(attributes35);
        em.flush();

        Attributes attributes36 = new Attributes();
        attributes36.setName("date");
        attributes36.setNullable(true);
        attributes36.setSingle(false);
//      ...................... Models ........................
        Entities entity64 = new Entities();
        entity64 = findBean.nameEntities("Models",em);
        attributes36.setEntities(entity64);
//      ...................... Date ........................
        AttributesTypes attributesTypes65 = new AttributesTypes();
        attributesTypes65 = findBean.nameAttributesTypes("Date",em);
        attributes36.setAttributesTypes(attributesTypes65);
        em.persist(attributes36);
        em.flush();

        Entities entities37 = new Entities();
        entities37.setName("Cardinalities");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId66 = new GroupIds();
        groupId66 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities37.setGroupIds(groupId66);
        em.persist(entities37);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes38 = new Attributes();
        attributes38.setName("name");
        attributes38.setNullable(false);
        attributes38.setSingle(true);
//      ...................... Cardinalities ........................
        Entities entity67 = new Entities();
        entity67 = findBean.nameEntities("Cardinalities",em);
        attributes38.setEntities(entity67);
//      ...................... String ........................
        AttributesTypes attributesTypes68 = new AttributesTypes();
        attributesTypes68 = findBean.nameAttributesTypes("String",em);
        attributes38.setAttributesTypes(attributesTypes68);
        em.persist(attributes38);
        em.flush();

        Attributes attributes39 = new Attributes();
        attributes39.setName("cardinality");
        attributes39.setNullable(false);
        attributes39.setSingle(false);
//      ...................... Cardinalities ........................
        Entities entity69 = new Entities();
        entity69 = findBean.nameEntities("Cardinalities",em);
        attributes39.setEntities(entity69);
//      ...................... String ........................
        AttributesTypes attributesTypes70 = new AttributesTypes();
        attributesTypes70 = findBean.nameAttributesTypes("String",em);
        attributes39.setAttributesTypes(attributesTypes70);
        em.persist(attributes39);
        em.flush();

        Attributes attributes40 = new Attributes();
        attributes40.setName("unidirectional");
        attributes40.setNullable(true);
        attributes40.setSingle(false);
//      ...................... Cardinalities ........................
        Entities entity71 = new Entities();
        entity71 = findBean.nameEntities("Cardinalities",em);
        attributes40.setEntities(entity71);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes72 = new AttributesTypes();
        attributesTypes72 = findBean.nameAttributesTypes("Boolean",em);
        attributes40.setAttributesTypes(attributesTypes72);
        em.persist(attributes40);
        em.flush();

        Attributes attributes41 = new Attributes();
        attributes41.setName("annotations");
        attributes41.setNullable(true);
        attributes41.setSingle(false);
//      ...................... Cardinalities ........................
        Entities entity73 = new Entities();
        entity73 = findBean.nameEntities("Cardinalities",em);
        attributes41.setEntities(entity73);
//      ...................... String ........................
        AttributesTypes attributesTypes74 = new AttributesTypes();
        attributesTypes74 = findBean.nameAttributesTypes("String",em);
        attributes41.setAttributesTypes(attributesTypes74);
        em.persist(attributes41);
        em.flush();

        Attributes attributes42 = new Attributes();
        attributes42.setName("observations");
        attributes42.setNullable(true);
        attributes42.setSingle(false);
//      ...................... Cardinalities ........................
        Entities entity75 = new Entities();
        entity75 = findBean.nameEntities("Cardinalities",em);
        attributes42.setEntities(entity75);
//      ...................... String ........................
        AttributesTypes attributesTypes76 = new AttributesTypes();
        attributesTypes76 = findBean.nameAttributesTypes("String",em);
        attributes42.setAttributesTypes(attributesTypes76);
        em.persist(attributes42);
        em.flush();

        Entities entities43 = new Entities();
        entities43.setName("Attributes");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId77 = new GroupIds();
        groupId77 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities43.setGroupIds(groupId77);
        em.persist(entities43);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes44 = new Attributes();
        attributes44.setName("name");
        attributes44.setNullable(false);
        attributes44.setSingle(false);
//      ...................... Attributes ........................
        Entities entity78 = new Entities();
        entity78 = findBean.nameEntities("Attributes",em);
        attributes44.setEntities(entity78);
//      ...................... String ........................
        AttributesTypes attributesTypes79 = new AttributesTypes();
        attributesTypes79 = findBean.nameAttributesTypes("String",em);
        attributes44.setAttributesTypes(attributesTypes79);
        em.persist(attributes44);
        em.flush();

        Attributes attributes45 = new Attributes();
        attributes45.setName("length");
        attributes45.setNullable(true);
        attributes45.setSingle(false);
//      ...................... Attributes ........................
        Entities entity80 = new Entities();
        entity80 = findBean.nameEntities("Attributes",em);
        attributes45.setEntities(entity80);
//      ...................... Integer ........................
        AttributesTypes attributesTypes81 = new AttributesTypes();
        attributesTypes81 = findBean.nameAttributesTypes("Integer",em);
        attributes45.setAttributesTypes(attributesTypes81);
        em.persist(attributes45);
        em.flush();

        Attributes attributes46 = new Attributes();
        attributes46.setName("precision");
        attributes46.setNullable(true);
        attributes46.setSingle(false);
//      ...................... Attributes ........................
        Entities entity82 = new Entities();
        entity82 = findBean.nameEntities("Attributes",em);
        attributes46.setEntities(entity82);
//      ...................... Integer ........................
        AttributesTypes attributesTypes83 = new AttributesTypes();
        attributesTypes83 = findBean.nameAttributesTypes("Integer",em);
        attributes46.setAttributesTypes(attributesTypes83);
        em.persist(attributes46);
        em.flush();

        Attributes attributes47 = new Attributes();
        attributes47.setName("nullable");
        attributes47.setNullable(true);
        attributes47.setSingle(false);
//      ...................... Attributes ........................
        Entities entity84 = new Entities();
        entity84 = findBean.nameEntities("Attributes",em);
        attributes47.setEntities(entity84);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes85 = new AttributesTypes();
        attributesTypes85 = findBean.nameAttributesTypes("Boolean",em);
        attributes47.setAttributesTypes(attributesTypes85);
        em.persist(attributes47);
        em.flush();

        Attributes attributes48 = new Attributes();
        attributes48.setName("single");
        attributes48.setNullable(true);
        attributes48.setSingle(false);
//      ...................... Attributes ........................
        Entities entity86 = new Entities();
        entity86 = findBean.nameEntities("Attributes",em);
        attributes48.setEntities(entity86);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes87 = new AttributesTypes();
        attributesTypes87 = findBean.nameAttributesTypes("Boolean",em);
        attributes48.setAttributesTypes(attributesTypes87);
        em.persist(attributes48);
        em.flush();

        Attributes attributes49 = new Attributes();
        attributes49.setName("descripcion");
        attributes49.setNullable(true);
        attributes49.setSingle(false);
//      ...................... Attributes ........................
        Entities entity88 = new Entities();
        entity88 = findBean.nameEntities("Attributes",em);
        attributes49.setEntities(entity88);
//      ...................... String ........................
        AttributesTypes attributesTypes89 = new AttributesTypes();
        attributesTypes89 = findBean.nameAttributesTypes("String",em);
        attributes49.setAttributesTypes(attributesTypes89);
        em.persist(attributes49);
        em.flush();

        Attributes attributes50 = new Attributes();
        attributes50.setName("field");
        attributes50.setNullable(true);
        attributes50.setSingle(false);
//      ...................... Attributes ........................
        Entities entity90 = new Entities();
        entity90 = findBean.nameEntities("Attributes",em);
        attributes50.setEntities(entity90);
//      ...................... String ........................
        AttributesTypes attributesTypes91 = new AttributesTypes();
        attributesTypes91 = findBean.nameAttributesTypes("String",em);
        attributes50.setAttributesTypes(attributesTypes91);
        em.persist(attributes50);
        em.flush();

        Attributes attributes51 = new Attributes();
        attributes51.setName("access");
        attributes51.setNullable(true);
        attributes51.setSingle(false);
//      ...................... Attributes ........................
        Entities entity92 = new Entities();
        entity92 = findBean.nameEntities("Attributes",em);
        attributes51.setEntities(entity92);
//      ...................... String ........................
        AttributesTypes attributesTypes93 = new AttributesTypes();
        attributesTypes93 = findBean.nameAttributesTypes("String",em);
        attributes51.setAttributesTypes(attributesTypes93);
        em.persist(attributes51);
        em.flush();

        Attributes attributes52 = new Attributes();
        attributes52.setName("columnDefinition");
        attributes52.setNullable(true);
        attributes52.setSingle(false);
//      ...................... Attributes ........................
        Entities entity94 = new Entities();
        entity94 = findBean.nameEntities("Attributes",em);
        attributes52.setEntities(entity94);
//      ...................... String ........................
        AttributesTypes attributesTypes95 = new AttributesTypes();
        attributesTypes95 = findBean.nameAttributesTypes("String",em);
        attributes52.setAttributesTypes(attributesTypes95);
        em.persist(attributes52);
        em.flush();

        Attributes attributes53 = new Attributes();
        attributes53.setName("annotationsField");
        attributes53.setNullable(true);
        attributes53.setSingle(false);
//      ...................... Attributes ........................
        Entities entity96 = new Entities();
        entity96 = findBean.nameEntities("Attributes",em);
        attributes53.setEntities(entity96);
//      ...................... String ........................
        AttributesTypes attributesTypes97 = new AttributesTypes();
        attributesTypes97 = findBean.nameAttributesTypes("String",em);
        attributes53.setAttributesTypes(attributesTypes97);
        em.persist(attributes53);
        em.flush();

        Attributes attributes54 = new Attributes();
        attributes54.setName("annotationsMethod");
        attributes54.setNullable(true);
        attributes54.setSingle(false);
//      ...................... Attributes ........................
        Entities entity98 = new Entities();
        entity98 = findBean.nameEntities("Attributes",em);
        attributes54.setEntities(entity98);
//      ...................... String ........................
        AttributesTypes attributesTypes99 = new AttributesTypes();
        attributesTypes99 = findBean.nameAttributesTypes("String",em);
        attributes54.setAttributesTypes(attributesTypes99);
        em.persist(attributes54);
        em.flush();

        Attributes attributes55 = new Attributes();
        attributes55.setName("observations");
        attributes55.setNullable(true);
        attributes55.setSingle(false);
//      ...................... Attributes ........................
        Entities entity100 = new Entities();
        entity100 = findBean.nameEntities("Attributes",em);
        attributes55.setEntities(entity100);
//      ...................... String ........................
        AttributesTypes attributesTypes101 = new AttributesTypes();
        attributesTypes101 = findBean.nameAttributesTypes("String",em);
        attributes55.setAttributesTypes(attributesTypes101);
        em.persist(attributes55);
        em.flush();

        Entities entities56 = new Entities();
        entities56.setName("Developments");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId102 = new GroupIds();
        groupId102 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities56.setGroupIds(groupId102);
        em.persist(entities56);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes57 = new Attributes();
        attributes57.setName("name");
        attributes57.setNullable(false);
        attributes57.setSingle(true);
//      ...................... Developments ........................
        Entities entity103 = new Entities();
        entity103 = findBean.nameEntities("Developments",em);
        attributes57.setEntities(entity103);
//      ...................... String ........................
        AttributesTypes attributesTypes104 = new AttributesTypes();
        attributesTypes104 = findBean.nameAttributesTypes("String",em);
        attributes57.setAttributesTypes(attributesTypes104);
        em.persist(attributes57);
        em.flush();

        Attributes attributes58 = new Attributes();
        attributes58.setName("groupId");
        attributes58.setNullable(false);
        attributes58.setSingle(false);
//      ...................... Developments ........................
        Entities entity105 = new Entities();
        entity105 = findBean.nameEntities("Developments",em);
        attributes58.setEntities(entity105);
//      ...................... String ........................
        AttributesTypes attributesTypes106 = new AttributesTypes();
        attributesTypes106 = findBean.nameAttributesTypes("String",em);
        attributes58.setAttributesTypes(attributesTypes106);
        em.persist(attributes58);
        em.flush();

        Attributes attributes59 = new Attributes();
        attributes59.setName("artifactId");
        attributes59.setNullable(true);
        attributes59.setSingle(true);
//      ...................... Developments ........................
        Entities entity107 = new Entities();
        entity107 = findBean.nameEntities("Developments",em);
        attributes59.setEntities(entity107);
//      ...................... String ........................
        AttributesTypes attributesTypes108 = new AttributesTypes();
        attributesTypes108 = findBean.nameAttributesTypes("String",em);
        attributes59.setAttributesTypes(attributesTypes108);
        em.persist(attributes59);
        em.flush();

        Attributes attributes60 = new Attributes();
        attributes60.setName("version");
        attributes60.setNullable(true);
        attributes60.setSingle(false);
//      ...................... Developments ........................
        Entities entity109 = new Entities();
        entity109 = findBean.nameEntities("Developments",em);
        attributes60.setEntities(entity109);
//      ...................... String ........................
        AttributesTypes attributesTypes110 = new AttributesTypes();
        attributesTypes110 = findBean.nameAttributesTypes("String",em);
        attributes60.setAttributesTypes(attributesTypes110);
        em.persist(attributes60);
        em.flush();

        Attributes attributes61 = new Attributes();
        attributes61.setName("code");
        attributes61.setNullable(true);
        attributes61.setSingle(true);
//      ...................... Developments ........................
        Entities entity111 = new Entities();
        entity111 = findBean.nameEntities("Developments",em);
        attributes61.setEntities(entity111);
//      ...................... String ........................
        AttributesTypes attributesTypes112 = new AttributesTypes();
        attributesTypes112 = findBean.nameAttributesTypes("String",em);
        attributes61.setAttributesTypes(attributesTypes112);
        em.persist(attributes61);
        em.flush();

        Attributes attributes62 = new Attributes();
        attributes62.setName("date");
        attributes62.setNullable(true);
        attributes62.setSingle(false);
//      ...................... Developments ........................
        Entities entity113 = new Entities();
        entity113 = findBean.nameEntities("Developments",em);
        attributes62.setEntities(entity113);
//      ...................... Date ........................
        AttributesTypes attributesTypes114 = new AttributesTypes();
        attributesTypes114 = findBean.nameAttributesTypes("Date",em);
        attributes62.setAttributesTypes(attributesTypes114);
        em.persist(attributes62);
        em.flush();

        GroupIds groupIds63 = new GroupIds();
        groupIds63.setGroupId("co.simasoft.models.dev.naifg");
//      ...................... naifg ........................
        DomainModels domainModel115 = new DomainModels();
        domainModel115 = findBean.artifactIdDomainModels("naifg",em);
        groupIds63.setDomainModels(domainModel115);
        em.persist(groupIds63);
        em.flush();

//      ---------------------- Entities ------------------------

//      ---------------------- Relationships ------------------------

/*
. GroupIds . 1..* Entities rolA: rolB:

. Developments . *..* Models rolA: rolB:

. Entities . 1..* NameQueries rolA: rolB:

. Entities . 1..* Relationships rolA: rolB:

. Entities . 1..* Attributes rolA: rolB:

. Models . 1..* GroupIds rolA: rolB:

. Entities . 1..* Relationships rolA: rolB:

. Cardinalities . 1..* Relationships rolA: rolB:

. Models . *..* Developments rolA: rolB:

*/
        Relationships relationships1 = new Relationships();
        relationships1.setOptionality(true);
        relationships1.setIsEmbedded(false);
//      ...................... GroupIds ........................
        Entities entities116 = new Entities();
        entities116 = findBean.nameEntities("GroupIds",em);
        relationships1.setFrom(entities116);
//      ...................... Entities ........................
        Entities entities117 = new Entities();
        entities117 = findBean.nameEntities("Entities",em);
        relationships1.setTo(entities117);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities118 = new Cardinalities();
        cardinalities118 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships1.setCardinalities(cardinalities118);
        em.persist(relationships1);
        em.flush();

        Relationships relationships2 = new Relationships();
        relationships2.setOptionality(true);
        relationships2.setIsEmbedded(false);
//      ...................... Developments ........................
        Entities entities119 = new Entities();
        entities119 = findBean.nameEntities("Developments",em);
        relationships2.setFrom(entities119);
//      ...................... Models ........................
        Entities entities120 = new Entities();
        entities120 = findBean.nameEntities("Models",em);
        relationships2.setTo(entities120);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities121 = new Cardinalities();
        cardinalities121 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships2.setCardinalities(cardinalities121);
        em.persist(relationships2);
        em.flush();

        Relationships relationships3 = new Relationships();
        relationships3.setOptionality(true);
        relationships3.setIsEmbedded(false);
//      ...................... Entities ........................
        Entities entities122 = new Entities();
        entities122 = findBean.nameEntities("Entities",em);
        relationships3.setFrom(entities122);
//      ...................... NameQueries ........................
        Entities entities123 = new Entities();
        entities123 = findBean.nameEntities("NameQueries",em);
        relationships3.setTo(entities123);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities124 = new Cardinalities();
        cardinalities124 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships3.setCardinalities(cardinalities124);
        em.persist(relationships3);
        em.flush();

        Relationships relationships4 = new Relationships();
        relationships4.setOptionality(true);
        relationships4.setIsEmbedded(false);
//      ...................... Entities ........................
        Entities entities125 = new Entities();
        entities125 = findBean.nameEntities("Entities",em);
        relationships4.setFrom(entities125);
//      ...................... Relationships ........................
        Entities entities126 = new Entities();
        entities126 = findBean.nameEntities("Relationships",em);
        relationships4.setTo(entities126);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities127 = new Cardinalities();
        cardinalities127 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships4.setCardinalities(cardinalities127);
        em.persist(relationships4);
        em.flush();

        Relationships relationships5 = new Relationships();
        relationships5.setOptionality(true);
        relationships5.setIsEmbedded(false);
//      ...................... Entities ........................
        Entities entities128 = new Entities();
        entities128 = findBean.nameEntities("Entities",em);
        relationships5.setFrom(entities128);
//      ...................... Attributes ........................
        Entities entities129 = new Entities();
        entities129 = findBean.nameEntities("Attributes",em);
        relationships5.setTo(entities129);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities130 = new Cardinalities();
        cardinalities130 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships5.setCardinalities(cardinalities130);
        em.persist(relationships5);
        em.flush();

        Relationships relationships6 = new Relationships();
        relationships6.setOptionality(true);
        relationships6.setIsEmbedded(false);
//      ...................... Models ........................
        Entities entities131 = new Entities();
        entities131 = findBean.nameEntities("Models",em);
        relationships6.setFrom(entities131);
//      ...................... GroupIds ........................
        Entities entities132 = new Entities();
        entities132 = findBean.nameEntities("GroupIds",em);
        relationships6.setTo(entities132);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities133 = new Cardinalities();
        cardinalities133 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships6.setCardinalities(cardinalities133);
        em.persist(relationships6);
        em.flush();

        Relationships relationships7 = new Relationships();
        relationships7.setOptionality(true);
        relationships7.setIsEmbedded(false);
//      ...................... Entities ........................
        Entities entities134 = new Entities();
        entities134 = findBean.nameEntities("Entities",em);
        relationships7.setFrom(entities134);
//      ...................... Relationships ........................
        Entities entities135 = new Entities();
        entities135 = findBean.nameEntities("Relationships",em);
        relationships7.setTo(entities135);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities136 = new Cardinalities();
        cardinalities136 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships7.setCardinalities(cardinalities136);
        em.persist(relationships7);
        em.flush();

        Relationships relationships8 = new Relationships();
        relationships8.setOptionality(true);
        relationships8.setIsEmbedded(false);
//      ...................... Cardinalities ........................
        Entities entities137 = new Entities();
        entities137 = findBean.nameEntities("Cardinalities",em);
        relationships8.setFrom(entities137);
//      ...................... Relationships ........................
        Entities entities138 = new Entities();
        entities138 = findBean.nameEntities("Relationships",em);
        relationships8.setTo(entities138);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities139 = new Cardinalities();
        cardinalities139 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships8.setCardinalities(cardinalities139);
        em.persist(relationships8);
        em.flush();

        Relationships relationships9 = new Relationships();
        relationships9.setOptionality(true);
        relationships9.setIsEmbedded(false);
//      ...................... Models ........................
        Entities entities140 = new Entities();
        entities140 = findBean.nameEntities("Models",em);
        relationships9.setFrom(entities140);
//      ...................... Developments ........................
        Entities entities141 = new Entities();
        entities141 = findBean.nameEntities("Developments",em);
        relationships9.setTo(entities141);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities142 = new Cardinalities();
        cardinalities142 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships9.setCardinalities(cardinalities142);
        em.persist(relationships9);
        em.flush();

/*
*/
/*
. Relationships . *..* AttributesProperties rolA:from rolB: OK

. Entities . *..* Imports rolA:from rolB: OK

. Developments . 1..* Chapters rolA: rolB:

. Models . 1..* Chapters rolA: rolB:

. Companies . 1..* Developments rolA: rolB:

. Developments . 1..* Series rolA: rolB:

. Attributes . *..* AttributesProperties rolA:from rolB: OK

. Entities . 1..* Series rolA: rolB:

. Models . 1..* Series rolA: rolB:

. Relationships . 1..* Chapters rolA: rolB:

. Cardinalities . 1..* Chapters rolA: rolB:

. AttributesProperties . 1..* Chapters rolA: rolB:

. Cardinalities . *..* Imports rolA:from rolB: OK

. AttributesTypes . 1..* Attributes rolA: rolB:

*/
        Relationships relationships10 = new Relationships();
        relationships10.setOptionality(true);
        relationships10.setIsEmbedded(false);
//      ...................... Relationships ........................
        Entities entities143 = new Entities();
        entities143 = findBean.nameEntities("Relationships",em);
        relationships10.setFrom(entities143);
//      ...................... AttributesProperties ........................
        Entities entities144 = new Entities();
        entities144 = findBean.nameEntities("AttributesProperties",em);
        relationships10.setTo(entities144);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities145 = new Cardinalities();
        cardinalities145 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships10.setCardinalities(cardinalities145);
        em.persist(relationships10);
        em.flush();

        Relationships relationships11 = new Relationships();
        relationships11.setOptionality(true);
        relationships11.setIsEmbedded(false);
//      ...................... Entities ........................
        Entities entities146 = new Entities();
        entities146 = findBean.nameEntities("Entities",em);
        relationships11.setFrom(entities146);
//      ...................... Imports ........................
        Entities entities147 = new Entities();
        entities147 = findBean.nameEntities("Imports",em);
        relationships11.setTo(entities147);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities148 = new Cardinalities();
        cardinalities148 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships11.setCardinalities(cardinalities148);
        em.persist(relationships11);
        em.flush();

        Relationships relationships12 = new Relationships();
        relationships12.setOptionality(true);
        relationships12.setIsEmbedded(false);
//      ...................... Developments ........................
        Entities entities149 = new Entities();
        entities149 = findBean.nameEntities("Developments",em);
        relationships12.setFrom(entities149);
//      ...................... Chapters ........................
        Entities entities150 = new Entities();
        entities150 = findBean.nameEntities("Chapters",em);
        relationships12.setTo(entities150);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities151 = new Cardinalities();
        cardinalities151 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships12.setCardinalities(cardinalities151);
        em.persist(relationships12);
        em.flush();

        Relationships relationships13 = new Relationships();
        relationships13.setOptionality(true);
        relationships13.setIsEmbedded(false);
//      ...................... Models ........................
        Entities entities152 = new Entities();
        entities152 = findBean.nameEntities("Models",em);
        relationships13.setFrom(entities152);
//      ...................... Chapters ........................
        Entities entities153 = new Entities();
        entities153 = findBean.nameEntities("Chapters",em);
        relationships13.setTo(entities153);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities154 = new Cardinalities();
        cardinalities154 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships13.setCardinalities(cardinalities154);
        em.persist(relationships13);
        em.flush();

        Relationships relationships14 = new Relationships();
        relationships14.setOptionality(true);
        relationships14.setIsEmbedded(false);
//      ...................... Companies ........................
        Entities entities155 = new Entities();
        entities155 = findBean.nameEntities("Companies",em);
        relationships14.setFrom(entities155);
//      ...................... Developments ........................
        Entities entities156 = new Entities();
        entities156 = findBean.nameEntities("Developments",em);
        relationships14.setTo(entities156);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities157 = new Cardinalities();
        cardinalities157 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships14.setCardinalities(cardinalities157);
        em.persist(relationships14);
        em.flush();

        Relationships relationships15 = new Relationships();
        relationships15.setOptionality(true);
        relationships15.setIsEmbedded(false);
//      ...................... Developments ........................
        Entities entities158 = new Entities();
        entities158 = findBean.nameEntities("Developments",em);
        relationships15.setFrom(entities158);
//      ...................... Series ........................
        Entities entities159 = new Entities();
        entities159 = findBean.nameEntities("Series",em);
        relationships15.setTo(entities159);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities160 = new Cardinalities();
        cardinalities160 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships15.setCardinalities(cardinalities160);
        em.persist(relationships15);
        em.flush();

        Relationships relationships16 = new Relationships();
        relationships16.setOptionality(true);
        relationships16.setIsEmbedded(false);
//      ...................... Attributes ........................
        Entities entities161 = new Entities();
        entities161 = findBean.nameEntities("Attributes",em);
        relationships16.setFrom(entities161);
//      ...................... AttributesProperties ........................
        Entities entities162 = new Entities();
        entities162 = findBean.nameEntities("AttributesProperties",em);
        relationships16.setTo(entities162);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities163 = new Cardinalities();
        cardinalities163 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships16.setCardinalities(cardinalities163);
        em.persist(relationships16);
        em.flush();

        Relationships relationships17 = new Relationships();
        relationships17.setOptionality(true);
        relationships17.setIsEmbedded(false);
//      ...................... Entities ........................
        Entities entities164 = new Entities();
        entities164 = findBean.nameEntities("Entities",em);
        relationships17.setFrom(entities164);
//      ...................... Series ........................
        Entities entities165 = new Entities();
        entities165 = findBean.nameEntities("Series",em);
        relationships17.setTo(entities165);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities166 = new Cardinalities();
        cardinalities166 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships17.setCardinalities(cardinalities166);
        em.persist(relationships17);
        em.flush();

        Relationships relationships18 = new Relationships();
        relationships18.setOptionality(true);
        relationships18.setIsEmbedded(false);
//      ...................... Models ........................
        Entities entities167 = new Entities();
        entities167 = findBean.nameEntities("Models",em);
        relationships18.setFrom(entities167);
//      ...................... Series ........................
        Entities entities168 = new Entities();
        entities168 = findBean.nameEntities("Series",em);
        relationships18.setTo(entities168);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities169 = new Cardinalities();
        cardinalities169 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships18.setCardinalities(cardinalities169);
        em.persist(relationships18);
        em.flush();

        Relationships relationships19 = new Relationships();
        relationships19.setOptionality(true);
        relationships19.setIsEmbedded(false);
//      ...................... Relationships ........................
        Entities entities170 = new Entities();
        entities170 = findBean.nameEntities("Relationships",em);
        relationships19.setFrom(entities170);
//      ...................... Chapters ........................
        Entities entities171 = new Entities();
        entities171 = findBean.nameEntities("Chapters",em);
        relationships19.setTo(entities171);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities172 = new Cardinalities();
        cardinalities172 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships19.setCardinalities(cardinalities172);
        em.persist(relationships19);
        em.flush();

        Relationships relationships20 = new Relationships();
        relationships20.setOptionality(true);
        relationships20.setIsEmbedded(false);
//      ...................... Cardinalities ........................
        Entities entities173 = new Entities();
        entities173 = findBean.nameEntities("Cardinalities",em);
        relationships20.setFrom(entities173);
//      ...................... Chapters ........................
        Entities entities174 = new Entities();
        entities174 = findBean.nameEntities("Chapters",em);
        relationships20.setTo(entities174);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities175 = new Cardinalities();
        cardinalities175 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships20.setCardinalities(cardinalities175);
        em.persist(relationships20);
        em.flush();

        Relationships relationships21 = new Relationships();
        relationships21.setOptionality(true);
        relationships21.setIsEmbedded(false);
//      ...................... AttributesProperties ........................
        Entities entities176 = new Entities();
        entities176 = findBean.nameEntities("AttributesProperties",em);
        relationships21.setFrom(entities176);
//      ...................... Chapters ........................
        Entities entities177 = new Entities();
        entities177 = findBean.nameEntities("Chapters",em);
        relationships21.setTo(entities177);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities178 = new Cardinalities();
        cardinalities178 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships21.setCardinalities(cardinalities178);
        em.persist(relationships21);
        em.flush();

        Relationships relationships22 = new Relationships();
        relationships22.setOptionality(true);
        relationships22.setIsEmbedded(false);
//      ...................... Cardinalities ........................
        Entities entities179 = new Entities();
        entities179 = findBean.nameEntities("Cardinalities",em);
        relationships22.setFrom(entities179);
//      ...................... Imports ........................
        Entities entities180 = new Entities();
        entities180 = findBean.nameEntities("Imports",em);
        relationships22.setTo(entities180);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities181 = new Cardinalities();
        cardinalities181 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships22.setCardinalities(cardinalities181);
        em.persist(relationships22);
        em.flush();

        Relationships relationships23 = new Relationships();
        relationships23.setOptionality(true);
        relationships23.setIsEmbedded(false);
//      ...................... AttributesTypes ........................
        Entities entities182 = new Entities();
        entities182 = findBean.nameEntities("AttributesTypes",em);
        relationships23.setFrom(entities182);
//      ...................... Attributes ........................
        Entities entities183 = new Entities();
        entities183 = findBean.nameEntities("Attributes",em);
        relationships23.setTo(entities183);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities184 = new Cardinalities();
        cardinalities184 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships23.setCardinalities(cardinalities184);
        em.persist(relationships23);
        em.flush();

    } // data()

} // naifg
