package co.simasoft.naifg.setup;

import co.simasoft.beans.*;
import co.simasoft.utils.*;

import co.simasoft.models.dev.naifg.*;
import co.simasoft.models.dev.naifg.dependencies.*;


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

    @PersistenceContext(unitName = "naifgPU-JTA")
    private EntityManager em;

    FindBean findBean = new FindBean();

    private static final Logger log = Logger.getLogger(naifgSetup.class.getName());

    public void data() {

//      ---------------------- GroupIds ------------------------

        GroupIds groupIds1 = new GroupIds();
        groupIds1.setArtifactId("co.simasoft.models.dev.naifg");
        groupIds1.setGroupId("co.simasoft.models.dev.naifg");
        groupIds1.setVersion("null");
        groupIds1.setCode("null");
        em.persist(groupIds1);
        em.flush();

        GroupIds groupIds2 = new GroupIds();
        groupIds2.setArtifactId("co.simasoft.models.dev.naifg.dependencies");
        groupIds2.setGroupId("co.simasoft.models.dev.naifg.dependencies");
        groupIds2.setVersion("null");
        groupIds2.setCode("null");
        em.persist(groupIds2);
        em.flush();

//      ---------------------- Models ------------------------

        Models models = new Models();
        models.setArtifactId("naifg");
        models.setGroupId("co.simasoft.naifg");
        models.setVersion("1.0-SNAPSHOT");
        models.setCode("null");
        em.persist(models);
        em.flush();

//      ---------------------- ModelsGroupIds ----------------------

        ModelsGroupIds modelsGroupIds1 = new ModelsGroupIds();
        Models modelss1 = findBean.artifactIdModels("naifg",em);
        GroupIds groupIdd1 = findBean.artifactIdGroupIds("co.simasoft.models.dev.naifg",em);
        modelsGroupIds1.setModels(modelss1);
        modelsGroupIds1.setGroupIds(groupIdd1);
        modelsGroupIds1.setGroupId("");
        modelsGroupIds1.setIsSingle(null);
        modelsGroupIds1.setIsSimplified(null);
        em.persist(modelsGroupIds1);
        em.flush();

        ModelsGroupIds modelsGroupIds2 = new ModelsGroupIds();
        Models modelss2 = findBean.artifactIdModels("naifg",em);
        GroupIds groupIdd2 = findBean.artifactIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        modelsGroupIds2.setModels(modelss2);
        modelsGroupIds2.setGroupIds(groupIdd2);
        modelsGroupIds2.setGroupId("");
        modelsGroupIds2.setIsSingle(null);
        modelsGroupIds2.setIsSimplified(null);
        em.persist(modelsGroupIds2);
        em.flush();

//      ---------------------- Developments ------------------------

        Developments dev = new Developments();
        dev.setGroupId("co.simasoft.naifg");
        dev.setArtifactId("naifg");
        dev.setVersion("1.0-SNAPSHOT");
        dev.setCode("null");
        Set<Models> models1 = new HashSet<Models>();
        Models model1 = findBean.artifactIdModels("naifg",em);
        models1.add(model1);
        dev.setModels(models1);
        dev.setVersion("1.0-SNAPSHOT");
        dev.setCode("null");
        em.persist(dev);
        em.flush();

//      ---------------------- Entities ------------------------

        Entities entities1 = new Entities();
        entities1.setName("Cardinalities");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId1 = new GroupIds();
        groupId1 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities1.setGroupIds(groupId1);
        em.persist(entities1);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes2 = new Attributes();
        attributes2.setName("name");
        attributes2.setIsNullable(false);
        attributes2.setIsUnique(true);
//      ...................... Cardinalities ........................
        Entities entity2 = new Entities();
        entity2 = findBean.nameEntities("Cardinalities",em);
        attributes2.setEntities(entity2);
//      ...................... String ........................
        AttributesTypes attributesTypes3 = new AttributesTypes();
        attributesTypes3 = findBean.nameAttributesTypes("String",em);
        attributes2.setAttributesTypes(attributesTypes3);
        em.persist(attributes2);
        em.flush();

        Attributes attributes3 = new Attributes();
        attributes3.setName("cardinality");
        attributes3.setIsNullable(false);
        attributes3.setIsUnique(false);
//      ...................... Cardinalities ........................
        Entities entity4 = new Entities();
        entity4 = findBean.nameEntities("Cardinalities",em);
        attributes3.setEntities(entity4);
//      ...................... String ........................
        AttributesTypes attributesTypes5 = new AttributesTypes();
        attributesTypes5 = findBean.nameAttributesTypes("String",em);
        attributes3.setAttributesTypes(attributesTypes5);
        em.persist(attributes3);
        em.flush();

        Attributes attributes4 = new Attributes();
        attributes4.setName("isUnidirectional");
        attributes4.setIsNullable(true);
        attributes4.setIsUnique(false);
//      ...................... Cardinalities ........................
        Entities entity6 = new Entities();
        entity6 = findBean.nameEntities("Cardinalities",em);
        attributes4.setEntities(entity6);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes7 = new AttributesTypes();
        attributesTypes7 = findBean.nameAttributesTypes("Boolean",em);
        attributes4.setAttributesTypes(attributesTypes7);
        em.persist(attributes4);
        em.flush();

        Entities entities5 = new Entities();
        entities5.setName("Models");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId8 = new GroupIds();
        groupId8 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities5.setGroupIds(groupId8);
        em.persist(entities5);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes6 = new Attributes();
        attributes6.setName("groupId");
        attributes6.setIsNullable(false);
        attributes6.setIsUnique(true);
//      ...................... Models ........................
        Entities entity9 = new Entities();
        entity9 = findBean.nameEntities("Models",em);
        attributes6.setEntities(entity9);
//      ...................... String ........................
        AttributesTypes attributesTypes10 = new AttributesTypes();
        attributesTypes10 = findBean.nameAttributesTypes("String",em);
        attributes6.setAttributesTypes(attributesTypes10);
        em.persist(attributes6);
        em.flush();

        Attributes attributes7 = new Attributes();
        attributes7.setName("artifactId");
        attributes7.setIsNullable(false);
        attributes7.setIsUnique(true);
//      ...................... Models ........................
        Entities entity11 = new Entities();
        entity11 = findBean.nameEntities("Models",em);
        attributes7.setEntities(entity11);
//      ...................... String ........................
        AttributesTypes attributesTypes12 = new AttributesTypes();
        attributesTypes12 = findBean.nameAttributesTypes("String",em);
        attributes7.setAttributesTypes(attributesTypes12);
        em.persist(attributes7);
        em.flush();

        Attributes attributes8 = new Attributes();
        attributes8.setName("code");
        attributes8.setIsNullable(true);
        attributes8.setIsUnique(false);
//      ...................... Models ........................
        Entities entity13 = new Entities();
        entity13 = findBean.nameEntities("Models",em);
        attributes8.setEntities(entity13);
//      ...................... String ........................
        AttributesTypes attributesTypes14 = new AttributesTypes();
        attributesTypes14 = findBean.nameAttributesTypes("String",em);
        attributes8.setAttributesTypes(attributesTypes14);
        em.persist(attributes8);
        em.flush();

        Attributes attributes9 = new Attributes();
        attributes9.setName("version");
        attributes9.setIsNullable(true);
        attributes9.setIsUnique(false);
//      ...................... Models ........................
        Entities entity15 = new Entities();
        entity15 = findBean.nameEntities("Models",em);
        attributes9.setEntities(entity15);
//      ...................... String ........................
        AttributesTypes attributesTypes16 = new AttributesTypes();
        attributesTypes16 = findBean.nameAttributesTypes("String",em);
        attributes9.setAttributesTypes(attributesTypes16);
        em.persist(attributes9);
        em.flush();

        Attributes attributes10 = new Attributes();
        attributes10.setName("date");
        attributes10.setIsNullable(true);
        attributes10.setIsUnique(false);
//      ...................... Models ........................
        Entities entity17 = new Entities();
        entity17 = findBean.nameEntities("Models",em);
        attributes10.setEntities(entity17);
//      ...................... Date ........................
        AttributesTypes attributesTypes18 = new AttributesTypes();
        attributesTypes18 = findBean.nameAttributesTypes("Date",em);
        attributes10.setAttributesTypes(attributesTypes18);
        em.persist(attributes10);
        em.flush();

        Entities entities11 = new Entities();
        entities11.setName("ModelsGroupIds");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId19 = new GroupIds();
        groupId19 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities11.setGroupIds(groupId19);
        em.persist(entities11);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes12 = new Attributes();
        attributes12.setName("groupId");
        attributes12.setIsNullable(true);
        attributes12.setIsUnique(false);
//      ...................... ModelsGroupIds ........................
        Entities entity20 = new Entities();
        entity20 = findBean.nameEntities("ModelsGroupIds",em);
        attributes12.setEntities(entity20);
//      ...................... String ........................
        AttributesTypes attributesTypes21 = new AttributesTypes();
        attributesTypes21 = findBean.nameAttributesTypes("String",em);
        attributes12.setAttributesTypes(attributesTypes21);
        em.persist(attributes12);
        em.flush();

        Attributes attributes13 = new Attributes();
        attributes13.setName("isSingle");
        attributes13.setIsNullable(true);
        attributes13.setIsUnique(false);
//      ...................... ModelsGroupIds ........................
        Entities entity22 = new Entities();
        entity22 = findBean.nameEntities("ModelsGroupIds",em);
        attributes13.setEntities(entity22);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes23 = new AttributesTypes();
        attributesTypes23 = findBean.nameAttributesTypes("Boolean",em);
        attributes13.setAttributesTypes(attributesTypes23);
        em.persist(attributes13);
        em.flush();

        Attributes attributes14 = new Attributes();
        attributes14.setName("isSimplified");
        attributes14.setIsNullable(true);
        attributes14.setIsUnique(false);
//      ...................... ModelsGroupIds ........................
        Entities entity24 = new Entities();
        entity24 = findBean.nameEntities("ModelsGroupIds",em);
        attributes14.setEntities(entity24);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes25 = new AttributesTypes();
        attributesTypes25 = findBean.nameAttributesTypes("Boolean",em);
        attributes14.setAttributesTypes(attributesTypes25);
        em.persist(attributes14);
        em.flush();

        Entities entities15 = new Entities();
        entities15.setName("NameQueries");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId26 = new GroupIds();
        groupId26 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities15.setGroupIds(groupId26);
        em.persist(entities15);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes16 = new Attributes();
        attributes16.setName("name");
        attributes16.setIsNullable(false);
        attributes16.setIsUnique(true);
//      ...................... NameQueries ........................
        Entities entity27 = new Entities();
        entity27 = findBean.nameEntities("NameQueries",em);
        attributes16.setEntities(entity27);
//      ...................... String ........................
        AttributesTypes attributesTypes28 = new AttributesTypes();
        attributesTypes28 = findBean.nameAttributesTypes("String",em);
        attributes16.setAttributesTypes(attributesTypes28);
        em.persist(attributes16);
        em.flush();

        Attributes attributes17 = new Attributes();
        attributes17.setName("query");
        attributes17.setIsNullable(false);
        attributes17.setIsUnique(true);
//      ...................... NameQueries ........................
        Entities entity29 = new Entities();
        entity29 = findBean.nameEntities("NameQueries",em);
        attributes17.setEntities(entity29);
//      ...................... String ........................
        AttributesTypes attributesTypes30 = new AttributesTypes();
        attributesTypes30 = findBean.nameAttributesTypes("String",em);
        attributes17.setAttributesTypes(attributesTypes30);
        em.persist(attributes17);
        em.flush();

        Entities entities18 = new Entities();
        entities18.setName("GroupIds");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId31 = new GroupIds();
        groupId31 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities18.setGroupIds(groupId31);
        em.persist(entities18);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes19 = new Attributes();
        attributes19.setName("version");
        attributes19.setIsNullable(true);
        attributes19.setIsUnique(false);
//      ...................... GroupIds ........................
        Entities entity32 = new Entities();
        entity32 = findBean.nameEntities("GroupIds",em);
        attributes19.setEntities(entity32);
//      ...................... String ........................
        AttributesTypes attributesTypes33 = new AttributesTypes();
        attributesTypes33 = findBean.nameAttributesTypes("String",em);
        attributes19.setAttributesTypes(attributesTypes33);
        em.persist(attributes19);
        em.flush();

        Attributes attributes20 = new Attributes();
        attributes20.setName("groupId");
        attributes20.setIsNullable(false);
        attributes20.setIsUnique(true);
//      ...................... GroupIds ........................
        Entities entity34 = new Entities();
        entity34 = findBean.nameEntities("GroupIds",em);
        attributes20.setEntities(entity34);
//      ...................... String ........................
        AttributesTypes attributesTypes35 = new AttributesTypes();
        attributesTypes35 = findBean.nameAttributesTypes("String",em);
        attributes20.setAttributesTypes(attributesTypes35);
        em.persist(attributes20);
        em.flush();

        Attributes attributes21 = new Attributes();
        attributes21.setName("artifactId");
        attributes21.setIsNullable(false);
        attributes21.setIsUnique(true);
//      ...................... GroupIds ........................
        Entities entity36 = new Entities();
        entity36 = findBean.nameEntities("GroupIds",em);
        attributes21.setEntities(entity36);
//      ...................... String ........................
        AttributesTypes attributesTypes37 = new AttributesTypes();
        attributesTypes37 = findBean.nameAttributesTypes("String",em);
        attributes21.setAttributesTypes(attributesTypes37);
        em.persist(attributes21);
        em.flush();

        Attributes attributes22 = new Attributes();
        attributes22.setName("date");
        attributes22.setIsNullable(true);
        attributes22.setIsUnique(false);
//      ...................... GroupIds ........................
        Entities entity38 = new Entities();
        entity38 = findBean.nameEntities("GroupIds",em);
        attributes22.setEntities(entity38);
//      ...................... Date ........................
        AttributesTypes attributesTypes39 = new AttributesTypes();
        attributesTypes39 = findBean.nameAttributesTypes("Date",em);
        attributes22.setAttributesTypes(attributesTypes39);
        em.persist(attributes22);
        em.flush();

        Attributes attributes23 = new Attributes();
        attributes23.setName("code");
        attributes23.setIsNullable(true);
        attributes23.setIsUnique(false);
//      ...................... GroupIds ........................
        Entities entity40 = new Entities();
        entity40 = findBean.nameEntities("GroupIds",em);
        attributes23.setEntities(entity40);
//      ...................... String ........................
        AttributesTypes attributesTypes41 = new AttributesTypes();
        attributesTypes41 = findBean.nameAttributesTypes("String",em);
        attributes23.setAttributesTypes(attributesTypes41);
        em.persist(attributes23);
        em.flush();

        Entities entities24 = new Entities();
        entities24.setName("Attributes");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId42 = new GroupIds();
        groupId42 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities24.setGroupIds(groupId42);
        em.persist(entities24);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes25 = new Attributes();
        attributes25.setName("description");
        attributes25.setIsNullable(true);
        attributes25.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity43 = new Entities();
        entity43 = findBean.nameEntities("Attributes",em);
        attributes25.setEntities(entity43);
//      ...................... String ........................
        AttributesTypes attributesTypes44 = new AttributesTypes();
        attributesTypes44 = findBean.nameAttributesTypes("String",em);
        attributes25.setAttributesTypes(attributesTypes44);
        em.persist(attributes25);
        em.flush();

        Attributes attributes26 = new Attributes();
        attributes26.setName("length");
        attributes26.setIsNullable(true);
        attributes26.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity45 = new Entities();
        entity45 = findBean.nameEntities("Attributes",em);
        attributes26.setEntities(entity45);
//      ...................... Integer ........................
        AttributesTypes attributesTypes46 = new AttributesTypes();
        attributesTypes46 = findBean.nameAttributesTypes("Integer",em);
        attributes26.setAttributesTypes(attributesTypes46);
        em.persist(attributes26);
        em.flush();

        Attributes attributes27 = new Attributes();
        attributes27.setName("name");
        attributes27.setIsNullable(false);
        attributes27.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity47 = new Entities();
        entity47 = findBean.nameEntities("Attributes",em);
        attributes27.setEntities(entity47);
//      ...................... String ........................
        AttributesTypes attributesTypes48 = new AttributesTypes();
        attributesTypes48 = findBean.nameAttributesTypes("String",em);
        attributes27.setAttributesTypes(attributesTypes48);
        em.persist(attributes27);
        em.flush();

        Attributes attributes28 = new Attributes();
        attributes28.setName("isNullable");
        attributes28.setIsNullable(true);
        attributes28.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity49 = new Entities();
        entity49 = findBean.nameEntities("Attributes",em);
        attributes28.setEntities(entity49);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes50 = new AttributesTypes();
        attributesTypes50 = findBean.nameAttributesTypes("Boolean",em);
        attributes28.setAttributesTypes(attributesTypes50);
        em.persist(attributes28);
        em.flush();

        Attributes attributes29 = new Attributes();
        attributes29.setName("precision");
        attributes29.setIsNullable(true);
        attributes29.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity51 = new Entities();
        entity51 = findBean.nameEntities("Attributes",em);
        attributes29.setEntities(entity51);
//      ...................... Integer ........................
        AttributesTypes attributesTypes52 = new AttributesTypes();
        attributesTypes52 = findBean.nameAttributesTypes("Integer",em);
        attributes29.setAttributesTypes(attributesTypes52);
        em.persist(attributes29);
        em.flush();

        Attributes attributes30 = new Attributes();
        attributes30.setName("isSimplified");
        attributes30.setIsNullable(true);
        attributes30.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity53 = new Entities();
        entity53 = findBean.nameEntities("Attributes",em);
        attributes30.setEntities(entity53);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes54 = new AttributesTypes();
        attributesTypes54 = findBean.nameAttributesTypes("Boolean",em);
        attributes30.setAttributesTypes(attributesTypes54);
        em.persist(attributes30);
        em.flush();

        Attributes attributes31 = new Attributes();
        attributes31.setName("isUnique");
        attributes31.setIsNullable(true);
        attributes31.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity55 = new Entities();
        entity55 = findBean.nameEntities("Attributes",em);
        attributes31.setEntities(entity55);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes56 = new AttributesTypes();
        attributesTypes56 = findBean.nameAttributesTypes("Boolean",em);
        attributes31.setAttributesTypes(attributesTypes56);
        em.persist(attributes31);
        em.flush();

        Entities entities32 = new Entities();
        entities32.setName("Relationships");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId57 = new GroupIds();
        groupId57 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities32.setGroupIds(groupId57);
        em.persist(entities32);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes33 = new Attributes();
        attributes33.setName("name");
        attributes33.setIsNullable(true);
        attributes33.setIsUnique(false);
//      ...................... Relationships ........................
        Entities entity58 = new Entities();
        entity58 = findBean.nameEntities("Relationships",em);
        attributes33.setEntities(entity58);
//      ...................... String ........................
        AttributesTypes attributesTypes59 = new AttributesTypes();
        attributesTypes59 = findBean.nameAttributesTypes("String",em);
        attributes33.setAttributesTypes(attributesTypes59);
        em.persist(attributes33);
        em.flush();

        Attributes attributes34 = new Attributes();
        attributes34.setName("isOptionality");
        attributes34.setIsNullable(true);
        attributes34.setIsUnique(false);
//      ...................... Relationships ........................
        Entities entity60 = new Entities();
        entity60 = findBean.nameEntities("Relationships",em);
        attributes34.setEntities(entity60);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes61 = new AttributesTypes();
        attributesTypes61 = findBean.nameAttributesTypes("Boolean",em);
        attributes34.setAttributesTypes(attributesTypes61);
        em.persist(attributes34);
        em.flush();

        Attributes attributes35 = new Attributes();
        attributes35.setName("isEmbedded");
        attributes35.setIsNullable(true);
        attributes35.setIsUnique(false);
//      ...................... Relationships ........................
        Entities entity62 = new Entities();
        entity62 = findBean.nameEntities("Relationships",em);
        attributes35.setEntities(entity62);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes63 = new AttributesTypes();
        attributesTypes63 = findBean.nameAttributesTypes("Boolean",em);
        attributes35.setAttributesTypes(attributesTypes63);
        em.persist(attributes35);
        em.flush();

        Attributes attributes36 = new Attributes();
        attributes36.setName("isSimplified");
        attributes36.setIsNullable(true);
        attributes36.setIsUnique(false);
//      ...................... Relationships ........................
        Entities entity64 = new Entities();
        entity64 = findBean.nameEntities("Relationships",em);
        attributes36.setEntities(entity64);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes65 = new AttributesTypes();
        attributesTypes65 = findBean.nameAttributesTypes("Boolean",em);
        attributes36.setAttributesTypes(attributesTypes65);
        em.persist(attributes36);
        em.flush();

        Entities entities37 = new Entities();
        entities37.setName("Entities");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId66 = new GroupIds();
        groupId66 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities37.setGroupIds(groupId66);
        em.persist(entities37);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes38 = new Attributes();
        attributes38.setName("name");
        attributes38.setIsNullable(false);
        attributes38.setIsUnique(true);
//      ...................... Entities ........................
        Entities entity67 = new Entities();
        entity67 = findBean.nameEntities("Entities",em);
        attributes38.setEntities(entity67);
//      ...................... String ........................
        AttributesTypes attributesTypes68 = new AttributesTypes();
        attributesTypes68 = findBean.nameAttributesTypes("String",em);
        attributes38.setAttributesTypes(attributesTypes68);
        em.persist(attributes38);
        em.flush();

        Attributes attributes39 = new Attributes();
        attributes39.setName("description");
        attributes39.setIsNullable(true);
        attributes39.setIsUnique(false);
//      ...................... Entities ........................
        Entities entity69 = new Entities();
        entity69 = findBean.nameEntities("Entities",em);
        attributes39.setEntities(entity69);
//      ...................... String ........................
        AttributesTypes attributesTypes70 = new AttributesTypes();
        attributesTypes70 = findBean.nameAttributesTypes("String",em);
        attributes39.setAttributesTypes(attributesTypes70);
        em.persist(attributes39);
        em.flush();

        Attributes attributes40 = new Attributes();
        attributes40.setName("isSimplified");
        attributes40.setIsNullable(true);
        attributes40.setIsUnique(false);
//      ...................... Entities ........................
        Entities entity71 = new Entities();
        entity71 = findBean.nameEntities("Entities",em);
        attributes40.setEntities(entity71);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes72 = new AttributesTypes();
        attributesTypes72 = findBean.nameAttributesTypes("Boolean",em);
        attributes40.setAttributesTypes(attributesTypes72);
        em.persist(attributes40);
        em.flush();

        Attributes attributes41 = new Attributes();
        attributes41.setName("table");
        attributes41.setIsNullable(true);
        attributes41.setIsUnique(false);
//      ...................... Entities ........................
        Entities entity73 = new Entities();
        entity73 = findBean.nameEntities("Entities",em);
        attributes41.setEntities(entity73);
//      ...................... String ........................
        AttributesTypes attributesTypes74 = new AttributesTypes();
        attributesTypes74 = findBean.nameAttributesTypes("String",em);
        attributes41.setAttributesTypes(attributesTypes74);
        em.persist(attributes41);
        em.flush();

        Attributes attributes42 = new Attributes();
        attributes42.setName("serialID");
        attributes42.setIsNullable(true);
        attributes42.setIsUnique(false);
//      ...................... Entities ........................
        Entities entity75 = new Entities();
        entity75 = findBean.nameEntities("Entities",em);
        attributes42.setEntities(entity75);
//      ...................... String ........................
        AttributesTypes attributesTypes76 = new AttributesTypes();
        attributesTypes76 = findBean.nameAttributesTypes("String",em);
        attributes42.setAttributesTypes(attributesTypes76);
        em.persist(attributes42);
        em.flush();

        Entities entities43 = new Entities();
        entities43.setName("Developments");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId77 = new GroupIds();
        groupId77 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities43.setGroupIds(groupId77);
        em.persist(entities43);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes44 = new Attributes();
        attributes44.setName("code");
        attributes44.setIsNullable(true);
        attributes44.setIsUnique(false);
//      ...................... Developments ........................
        Entities entity78 = new Entities();
        entity78 = findBean.nameEntities("Developments",em);
        attributes44.setEntities(entity78);
//      ...................... String ........................
        AttributesTypes attributesTypes79 = new AttributesTypes();
        attributesTypes79 = findBean.nameAttributesTypes("String",em);
        attributes44.setAttributesTypes(attributesTypes79);
        em.persist(attributes44);
        em.flush();

        Attributes attributes45 = new Attributes();
        attributes45.setName("version");
        attributes45.setIsNullable(true);
        attributes45.setIsUnique(false);
//      ...................... Developments ........................
        Entities entity80 = new Entities();
        entity80 = findBean.nameEntities("Developments",em);
        attributes45.setEntities(entity80);
//      ...................... String ........................
        AttributesTypes attributesTypes81 = new AttributesTypes();
        attributesTypes81 = findBean.nameAttributesTypes("String",em);
        attributes45.setAttributesTypes(attributesTypes81);
        em.persist(attributes45);
        em.flush();

        Attributes attributes46 = new Attributes();
        attributes46.setName("date");
        attributes46.setIsNullable(true);
        attributes46.setIsUnique(false);
//      ...................... Developments ........................
        Entities entity82 = new Entities();
        entity82 = findBean.nameEntities("Developments",em);
        attributes46.setEntities(entity82);
//      ...................... Date ........................
        AttributesTypes attributesTypes83 = new AttributesTypes();
        attributesTypes83 = findBean.nameAttributesTypes("Date",em);
        attributes46.setAttributesTypes(attributesTypes83);
        em.persist(attributes46);
        em.flush();

        Attributes attributes47 = new Attributes();
        attributes47.setName("artifactId");
        attributes47.setIsNullable(false);
        attributes47.setIsUnique(true);
//      ...................... Developments ........................
        Entities entity84 = new Entities();
        entity84 = findBean.nameEntities("Developments",em);
        attributes47.setEntities(entity84);
//      ...................... String ........................
        AttributesTypes attributesTypes85 = new AttributesTypes();
        attributesTypes85 = findBean.nameAttributesTypes("String",em);
        attributes47.setAttributesTypes(attributesTypes85);
        em.persist(attributes47);
        em.flush();

        Attributes attributes48 = new Attributes();
        attributes48.setName("groupId");
        attributes48.setIsNullable(false);
        attributes48.setIsUnique(true);
//      ...................... Developments ........................
        Entities entity86 = new Entities();
        entity86 = findBean.nameEntities("Developments",em);
        attributes48.setEntities(entity86);
//      ...................... String ........................
        AttributesTypes attributesTypes87 = new AttributesTypes();
        attributesTypes87 = findBean.nameAttributesTypes("String",em);
        attributes48.setAttributesTypes(attributesTypes87);
        em.persist(attributes48);
        em.flush();

        Entities entities49 = new Entities();
        entities49.setName("Imports");
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId88 = new GroupIds();
        groupId88 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities49.setGroupIds(groupId88);
        em.persist(entities49);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes50 = new Attributes();
        attributes50.setName("name");
        attributes50.setIsNullable(false);
        attributes50.setIsUnique(true);
//      ...................... Imports ........................
        Entities entity89 = new Entities();
        entity89 = findBean.nameEntities("Imports",em);
        attributes50.setEntities(entity89);
//      ...................... String ........................
        AttributesTypes attributesTypes90 = new AttributesTypes();
        attributesTypes90 = findBean.nameAttributesTypes("String",em);
        attributes50.setAttributesTypes(attributesTypes90);
        em.persist(attributes50);
        em.flush();

        Entities entities51 = new Entities();
        entities51.setName("Dependencies");
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId91 = new GroupIds();
        groupId91 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities51.setGroupIds(groupId91);
        em.persist(entities51);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes52 = new Attributes();
        attributes52.setName("artifactId");
        attributes52.setIsNullable(false);
        attributes52.setIsUnique(false);
//      ...................... Dependencies ........................
        Entities entity92 = new Entities();
        entity92 = findBean.nameEntities("Dependencies",em);
        attributes52.setEntities(entity92);
//      ...................... String ........................
        AttributesTypes attributesTypes93 = new AttributesTypes();
        attributesTypes93 = findBean.nameAttributesTypes("String",em);
        attributes52.setAttributesTypes(attributesTypes93);
        em.persist(attributes52);
        em.flush();

        Attributes attributes53 = new Attributes();
        attributes53.setName("version");
        attributes53.setIsNullable(true);
        attributes53.setIsUnique(false);
//      ...................... Dependencies ........................
        Entities entity94 = new Entities();
        entity94 = findBean.nameEntities("Dependencies",em);
        attributes53.setEntities(entity94);
//      ...................... String ........................
        AttributesTypes attributesTypes95 = new AttributesTypes();
        attributesTypes95 = findBean.nameAttributesTypes("String",em);
        attributes53.setAttributesTypes(attributesTypes95);
        em.persist(attributes53);
        em.flush();

        Attributes attributes54 = new Attributes();
        attributes54.setName("groupId");
        attributes54.setIsNullable(false);
        attributes54.setIsUnique(false);
//      ...................... Dependencies ........................
        Entities entity96 = new Entities();
        entity96 = findBean.nameEntities("Dependencies",em);
        attributes54.setEntities(entity96);
//      ...................... String ........................
        AttributesTypes attributesTypes97 = new AttributesTypes();
        attributesTypes97 = findBean.nameAttributesTypes("String",em);
        attributes54.setAttributesTypes(attributesTypes97);
        em.persist(attributes54);
        em.flush();

        Attributes attributes55 = new Attributes();
        attributes55.setName("maven");
        attributes55.setIsNullable(false);
        attributes55.setIsUnique(true);
//      ...................... Dependencies ........................
        Entities entity98 = new Entities();
        entity98 = findBean.nameEntities("Dependencies",em);
        attributes55.setEntities(entity98);
//      ...................... String ........................
        AttributesTypes attributesTypes99 = new AttributesTypes();
        attributesTypes99 = findBean.nameAttributesTypes("String",em);
        attributes55.setAttributesTypes(attributesTypes99);
        em.persist(attributes55);
        em.flush();

        Attributes attributes56 = new Attributes();
        attributes56.setName("type");
        attributes56.setIsNullable(true);
        attributes56.setIsUnique(false);
//      ...................... Dependencies ........................
        Entities entity100 = new Entities();
        entity100 = findBean.nameEntities("Dependencies",em);
        attributes56.setEntities(entity100);
//      ...................... String ........................
        AttributesTypes attributesTypes101 = new AttributesTypes();
        attributesTypes101 = findBean.nameAttributesTypes("String",em);
        attributes56.setAttributesTypes(attributesTypes101);
        em.persist(attributes56);
        em.flush();

        Attributes attributes57 = new Attributes();
        attributes57.setName("scope");
        attributes57.setIsNullable(true);
        attributes57.setIsUnique(false);
//      ...................... Dependencies ........................
        Entities entity102 = new Entities();
        entity102 = findBean.nameEntities("Dependencies",em);
        attributes57.setEntities(entity102);
//      ...................... String ........................
        AttributesTypes attributesTypes103 = new AttributesTypes();
        attributesTypes103 = findBean.nameAttributesTypes("String",em);
        attributes57.setAttributesTypes(attributesTypes103);
        em.persist(attributes57);
        em.flush();

        Entities entities58 = new Entities();
        entities58.setName("AttributesProperties");
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId104 = new GroupIds();
        groupId104 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities58.setGroupIds(groupId104);
        em.persist(entities58);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes59 = new Attributes();
        attributes59.setName("name");
        attributes59.setIsNullable(false);
        attributes59.setIsUnique(true);
//      ...................... AttributesProperties ........................
        Entities entity105 = new Entities();
        entity105 = findBean.nameEntities("AttributesProperties",em);
        attributes59.setEntities(entity105);
//      ...................... String ........................
        AttributesTypes attributesTypes106 = new AttributesTypes();
        attributesTypes106 = findBean.nameAttributesTypes("String",em);
        attributes59.setAttributesTypes(attributesTypes106);
        em.persist(attributes59);
        em.flush();

        Attributes attributes60 = new Attributes();
        attributes60.setName("value");
        attributes60.setIsNullable(false);
        attributes60.setIsUnique(true);
//      ...................... AttributesProperties ........................
        Entities entity107 = new Entities();
        entity107 = findBean.nameEntities("AttributesProperties",em);
        attributes60.setEntities(entity107);
//      ...................... String ........................
        AttributesTypes attributesTypes108 = new AttributesTypes();
        attributesTypes108 = findBean.nameAttributesTypes("String",em);
        attributes60.setAttributesTypes(attributesTypes108);
        em.persist(attributes60);
        em.flush();

        Entities entities61 = new Entities();
        entities61.setName("AttributesTypes");
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId109 = new GroupIds();
        groupId109 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities61.setGroupIds(groupId109);
        em.persist(entities61);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes62 = new Attributes();
        attributes62.setName("annotations");
        attributes62.setIsNullable(true);
        attributes62.setIsUnique(false);
//      ...................... AttributesTypes ........................
        Entities entity110 = new Entities();
        entity110 = findBean.nameEntities("AttributesTypes",em);
        attributes62.setEntities(entity110);
//      ...................... String ........................
        AttributesTypes attributesTypes111 = new AttributesTypes();
        attributesTypes111 = findBean.nameAttributesTypes("String",em);
        attributes62.setAttributesTypes(attributesTypes111);
        em.persist(attributes62);
        em.flush();

        Attributes attributes63 = new Attributes();
        attributes63.setName("precision");
        attributes63.setIsNullable(true);
        attributes63.setIsUnique(false);
//      ...................... AttributesTypes ........................
        Entities entity112 = new Entities();
        entity112 = findBean.nameEntities("AttributesTypes",em);
        attributes63.setEntities(entity112);
//      ...................... Integer ........................
        AttributesTypes attributesTypes113 = new AttributesTypes();
        attributesTypes113 = findBean.nameAttributesTypes("Integer",em);
        attributes63.setAttributesTypes(attributesTypes113);
        em.persist(attributes63);
        em.flush();

        Attributes attributes64 = new Attributes();
        attributes64.setName("length");
        attributes64.setIsNullable(true);
        attributes64.setIsUnique(false);
//      ...................... AttributesTypes ........................
        Entities entity114 = new Entities();
        entity114 = findBean.nameEntities("AttributesTypes",em);
        attributes64.setEntities(entity114);
//      ...................... Integer ........................
        AttributesTypes attributesTypes115 = new AttributesTypes();
        attributesTypes115 = findBean.nameAttributesTypes("Integer",em);
        attributes64.setAttributesTypes(attributesTypes115);
        em.persist(attributes64);
        em.flush();

        Attributes attributes65 = new Attributes();
        attributes65.setName("type");
        attributes65.setIsNullable(false);
        attributes65.setIsUnique(false);
//      ...................... AttributesTypes ........................
        Entities entity116 = new Entities();
        entity116 = findBean.nameEntities("AttributesTypes",em);
        attributes65.setEntities(entity116);
//      ...................... String ........................
        AttributesTypes attributesTypes117 = new AttributesTypes();
        attributesTypes117 = findBean.nameAttributesTypes("String",em);
        attributes65.setAttributesTypes(attributesTypes117);
        em.persist(attributes65);
        em.flush();

        Attributes attributes66 = new Attributes();
        attributes66.setName("name");
        attributes66.setIsNullable(false);
        attributes66.setIsUnique(true);
//      ...................... AttributesTypes ........................
        Entities entity118 = new Entities();
        entity118 = findBean.nameEntities("AttributesTypes",em);
        attributes66.setEntities(entity118);
//      ...................... String ........................
        AttributesTypes attributesTypes119 = new AttributesTypes();
        attributesTypes119 = findBean.nameAttributesTypes("String",em);
        attributes66.setAttributesTypes(attributesTypes119);
        em.persist(attributes66);
        em.flush();

//      ---------------------- Relationships ------------------------

/*
. Cardinalities . 1..* Relationships
. Cardinalities . *..* Imports
. Cardinalities . *..* Sites
. Models . *..* Sites
. Models . 1..* ModelsGroupIds
. GroupIds . 1..* ModelsGroupIds
. GroupIds . 1..* Entities
. Attributes . *..* AttributesProperties
. Attributes . *..* Sites
. Relationships . *..* AttributesProperties
. Entities . 1..* NameQueries
. Entities . *..* Sites
. Entities . 1..* Relationships
. Entities . 1..* Relationships
. Entities . 1..* Attributes
. Entities . *..* AttributesProperties
. Entities . *..* Imports
. Developments . *..* Sites
. Developments . *..* Models
. Imports . *..* Sites
. Dependencies . 1..* Imports
. Dependencies . *..* Sites
. AttributesProperties . *..* Imports
. AttributesProperties . *..* Sites
. AttributesTypes . 1..* Attributes
. AttributesTypes . *..* AttributesProperties
. AttributesTypes . *..* Sites
*/
        Relationships relationships1 = new Relationships();
        relationships1.setIsOptionality(true);
        relationships1.setIsEmbedded(false);
        relationships1.setName("");
//      ...................... Cardinalities ........................
        Entities entities120 = new Entities();
        entities120 = findBean.nameEntities("Cardinalities",em);
        relationships1.setFrom(entities120);
//      ...................... Relationships ........................
        Entities entities121 = new Entities();
        entities121 = findBean.nameEntities("Relationships",em);
        relationships1.setTo(entities121);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities122 = new Cardinalities();
        cardinalities122 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships1.setCardinalities(cardinalities122);
        em.persist(relationships1);
        em.flush();

        Relationships relationships2 = new Relationships();
        relationships2.setIsOptionality(true);
        relationships2.setIsEmbedded(false);
        relationships2.setName("");
//      ...................... Cardinalities ........................
        Entities entities123 = new Entities();
        entities123 = findBean.nameEntities("Cardinalities",em);
        relationships2.setFrom(entities123);
//      ...................... Imports ........................
        Entities entities124 = new Entities();
        entities124 = findBean.nameEntities("Imports",em);
        relationships2.setTo(entities124);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities125 = new Cardinalities();
        cardinalities125 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships2.setCardinalities(cardinalities125);
        em.persist(relationships2);
        em.flush();

        Relationships relationships3 = new Relationships();
        relationships3.setIsOptionality(true);
        relationships3.setIsEmbedded(false);
        relationships3.setName("");
//      ...................... Cardinalities ........................
        Entities entities126 = new Entities();
        entities126 = findBean.nameEntities("Cardinalities",em);
        relationships3.setFrom(entities126);
//      ...................... Sites ........................
        Entities entities127 = new Entities();
        entities127 = findBean.nameEntities("Sites",em);
        relationships3.setTo(entities127);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities128 = new Cardinalities();
        cardinalities128 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships3.setCardinalities(cardinalities128);
        em.persist(relationships3);
        em.flush();

        Relationships relationships4 = new Relationships();
        relationships4.setIsOptionality(true);
        relationships4.setIsEmbedded(false);
        relationships4.setName("");
//      ...................... Models ........................
        Entities entities129 = new Entities();
        entities129 = findBean.nameEntities("Models",em);
        relationships4.setFrom(entities129);
//      ...................... Sites ........................
        Entities entities130 = new Entities();
        entities130 = findBean.nameEntities("Sites",em);
        relationships4.setTo(entities130);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities131 = new Cardinalities();
        cardinalities131 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships4.setCardinalities(cardinalities131);
        em.persist(relationships4);
        em.flush();

        Relationships relationships5 = new Relationships();
        relationships5.setIsOptionality(true);
        relationships5.setIsEmbedded(false);
        relationships5.setName("");
//      ...................... Models ........................
        Entities entities132 = new Entities();
        entities132 = findBean.nameEntities("Models",em);
        relationships5.setFrom(entities132);
//      ...................... ModelsGroupIds ........................
        Entities entities133 = new Entities();
        entities133 = findBean.nameEntities("ModelsGroupIds",em);
        relationships5.setTo(entities133);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities134 = new Cardinalities();
        cardinalities134 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships5.setCardinalities(cardinalities134);
        em.persist(relationships5);
        em.flush();

        Relationships relationships6 = new Relationships();
        relationships6.setIsOptionality(true);
        relationships6.setIsEmbedded(false);
        relationships6.setName("");
//      ...................... GroupIds ........................
        Entities entities135 = new Entities();
        entities135 = findBean.nameEntities("GroupIds",em);
        relationships6.setFrom(entities135);
//      ...................... ModelsGroupIds ........................
        Entities entities136 = new Entities();
        entities136 = findBean.nameEntities("ModelsGroupIds",em);
        relationships6.setTo(entities136);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities137 = new Cardinalities();
        cardinalities137 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships6.setCardinalities(cardinalities137);
        em.persist(relationships6);
        em.flush();

        Relationships relationships7 = new Relationships();
        relationships7.setIsOptionality(true);
        relationships7.setIsEmbedded(false);
        relationships7.setName("");
//      ...................... GroupIds ........................
        Entities entities138 = new Entities();
        entities138 = findBean.nameEntities("GroupIds",em);
        relationships7.setFrom(entities138);
//      ...................... Entities ........................
        Entities entities139 = new Entities();
        entities139 = findBean.nameEntities("Entities",em);
        relationships7.setTo(entities139);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities140 = new Cardinalities();
        cardinalities140 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships7.setCardinalities(cardinalities140);
        em.persist(relationships7);
        em.flush();

        Relationships relationships8 = new Relationships();
        relationships8.setIsOptionality(true);
        relationships8.setIsEmbedded(false);
        relationships8.setName("");
//      ...................... Attributes ........................
        Entities entities141 = new Entities();
        entities141 = findBean.nameEntities("Attributes",em);
        relationships8.setFrom(entities141);
//      ...................... AttributesProperties ........................
        Entities entities142 = new Entities();
        entities142 = findBean.nameEntities("AttributesProperties",em);
        relationships8.setTo(entities142);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities143 = new Cardinalities();
        cardinalities143 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships8.setCardinalities(cardinalities143);
        em.persist(relationships8);
        em.flush();

        Relationships relationships9 = new Relationships();
        relationships9.setIsOptionality(true);
        relationships9.setIsEmbedded(false);
        relationships9.setName("");
//      ...................... Attributes ........................
        Entities entities144 = new Entities();
        entities144 = findBean.nameEntities("Attributes",em);
        relationships9.setFrom(entities144);
//      ...................... Sites ........................
        Entities entities145 = new Entities();
        entities145 = findBean.nameEntities("Sites",em);
        relationships9.setTo(entities145);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities146 = new Cardinalities();
        cardinalities146 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships9.setCardinalities(cardinalities146);
        em.persist(relationships9);
        em.flush();

        Relationships relationships10 = new Relationships();
        relationships10.setIsOptionality(true);
        relationships10.setIsEmbedded(false);
        relationships10.setName("");
//      ...................... Relationships ........................
        Entities entities147 = new Entities();
        entities147 = findBean.nameEntities("Relationships",em);
        relationships10.setFrom(entities147);
//      ...................... AttributesProperties ........................
        Entities entities148 = new Entities();
        entities148 = findBean.nameEntities("AttributesProperties",em);
        relationships10.setTo(entities148);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities149 = new Cardinalities();
        cardinalities149 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships10.setCardinalities(cardinalities149);
        em.persist(relationships10);
        em.flush();

        Relationships relationships11 = new Relationships();
        relationships11.setIsOptionality(true);
        relationships11.setIsEmbedded(false);
        relationships11.setName("");
//      ...................... Entities ........................
        Entities entities150 = new Entities();
        entities150 = findBean.nameEntities("Entities",em);
        relationships11.setFrom(entities150);
//      ...................... NameQueries ........................
        Entities entities151 = new Entities();
        entities151 = findBean.nameEntities("NameQueries",em);
        relationships11.setTo(entities151);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities152 = new Cardinalities();
        cardinalities152 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships11.setCardinalities(cardinalities152);
        em.persist(relationships11);
        em.flush();

        Relationships relationships12 = new Relationships();
        relationships12.setIsOptionality(true);
        relationships12.setIsEmbedded(false);
        relationships12.setName("");
//      ...................... Entities ........................
        Entities entities153 = new Entities();
        entities153 = findBean.nameEntities("Entities",em);
        relationships12.setFrom(entities153);
//      ...................... Sites ........................
        Entities entities154 = new Entities();
        entities154 = findBean.nameEntities("Sites",em);
        relationships12.setTo(entities154);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities155 = new Cardinalities();
        cardinalities155 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships12.setCardinalities(cardinalities155);
        em.persist(relationships12);
        em.flush();

        Relationships relationships13 = new Relationships();
        relationships13.setIsOptionality(true);
        relationships13.setIsEmbedded(false);
        relationships13.setName("from");
//      ...................... Entities ........................
        Entities entities156 = new Entities();
        entities156 = findBean.nameEntities("Entities",em);
        relationships13.setFrom(entities156);
//      ...................... Relationships ........................
        Entities entities157 = new Entities();
        entities157 = findBean.nameEntities("Relationships",em);
        relationships13.setTo(entities157);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities158 = new Cardinalities();
        cardinalities158 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships13.setCardinalities(cardinalities158);
        em.persist(relationships13);
        em.flush();

        Relationships relationships14 = new Relationships();
        relationships14.setIsOptionality(true);
        relationships14.setIsEmbedded(false);
        relationships14.setName("to");
//      ...................... Entities ........................
        Entities entities159 = new Entities();
        entities159 = findBean.nameEntities("Entities",em);
        relationships14.setFrom(entities159);
//      ...................... Relationships ........................
        Entities entities160 = new Entities();
        entities160 = findBean.nameEntities("Relationships",em);
        relationships14.setTo(entities160);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities161 = new Cardinalities();
        cardinalities161 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships14.setCardinalities(cardinalities161);
        em.persist(relationships14);
        em.flush();

        Relationships relationships15 = new Relationships();
        relationships15.setIsOptionality(true);
        relationships15.setIsEmbedded(false);
        relationships15.setName("");
//      ...................... Entities ........................
        Entities entities162 = new Entities();
        entities162 = findBean.nameEntities("Entities",em);
        relationships15.setFrom(entities162);
//      ...................... Attributes ........................
        Entities entities163 = new Entities();
        entities163 = findBean.nameEntities("Attributes",em);
        relationships15.setTo(entities163);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities164 = new Cardinalities();
        cardinalities164 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships15.setCardinalities(cardinalities164);
        em.persist(relationships15);
        em.flush();

        Relationships relationships16 = new Relationships();
        relationships16.setIsOptionality(true);
        relationships16.setIsEmbedded(false);
        relationships16.setName("");
//      ...................... Entities ........................
        Entities entities165 = new Entities();
        entities165 = findBean.nameEntities("Entities",em);
        relationships16.setFrom(entities165);
//      ...................... AttributesProperties ........................
        Entities entities166 = new Entities();
        entities166 = findBean.nameEntities("AttributesProperties",em);
        relationships16.setTo(entities166);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities167 = new Cardinalities();
        cardinalities167 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships16.setCardinalities(cardinalities167);
        em.persist(relationships16);
        em.flush();

        Relationships relationships17 = new Relationships();
        relationships17.setIsOptionality(true);
        relationships17.setIsEmbedded(false);
        relationships17.setName("");
//      ...................... Entities ........................
        Entities entities168 = new Entities();
        entities168 = findBean.nameEntities("Entities",em);
        relationships17.setFrom(entities168);
//      ...................... Imports ........................
        Entities entities169 = new Entities();
        entities169 = findBean.nameEntities("Imports",em);
        relationships17.setTo(entities169);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities170 = new Cardinalities();
        cardinalities170 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships17.setCardinalities(cardinalities170);
        em.persist(relationships17);
        em.flush();

        Relationships relationships18 = new Relationships();
        relationships18.setIsOptionality(true);
        relationships18.setIsEmbedded(false);
        relationships18.setName("");
//      ...................... Developments ........................
        Entities entities171 = new Entities();
        entities171 = findBean.nameEntities("Developments",em);
        relationships18.setFrom(entities171);
//      ...................... Sites ........................
        Entities entities172 = new Entities();
        entities172 = findBean.nameEntities("Sites",em);
        relationships18.setTo(entities172);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities173 = new Cardinalities();
        cardinalities173 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships18.setCardinalities(cardinalities173);
        em.persist(relationships18);
        em.flush();

        Relationships relationships19 = new Relationships();
        relationships19.setIsOptionality(true);
        relationships19.setIsEmbedded(false);
        relationships19.setName("");
//      ...................... Developments ........................
        Entities entities174 = new Entities();
        entities174 = findBean.nameEntities("Developments",em);
        relationships19.setFrom(entities174);
//      ...................... Models ........................
        Entities entities175 = new Entities();
        entities175 = findBean.nameEntities("Models",em);
        relationships19.setTo(entities175);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities176 = new Cardinalities();
        cardinalities176 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships19.setCardinalities(cardinalities176);
        em.persist(relationships19);
        em.flush();

        Relationships relationships20 = new Relationships();
        relationships20.setIsOptionality(true);
        relationships20.setIsEmbedded(false);
        relationships20.setName("");
//      ...................... Imports ........................
        Entities entities177 = new Entities();
        entities177 = findBean.nameEntities("Imports",em);
        relationships20.setFrom(entities177);
//      ...................... Sites ........................
        Entities entities178 = new Entities();
        entities178 = findBean.nameEntities("Sites",em);
        relationships20.setTo(entities178);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities179 = new Cardinalities();
        cardinalities179 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships20.setCardinalities(cardinalities179);
        em.persist(relationships20);
        em.flush();

        Relationships relationships21 = new Relationships();
        relationships21.setIsOptionality(true);
        relationships21.setIsEmbedded(false);
        relationships21.setName("");
//      ...................... Dependencies ........................
        Entities entities180 = new Entities();
        entities180 = findBean.nameEntities("Dependencies",em);
        relationships21.setFrom(entities180);
//      ...................... Imports ........................
        Entities entities181 = new Entities();
        entities181 = findBean.nameEntities("Imports",em);
        relationships21.setTo(entities181);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities182 = new Cardinalities();
        cardinalities182 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships21.setCardinalities(cardinalities182);
        em.persist(relationships21);
        em.flush();

        Relationships relationships22 = new Relationships();
        relationships22.setIsOptionality(true);
        relationships22.setIsEmbedded(false);
        relationships22.setName("");
//      ...................... Dependencies ........................
        Entities entities183 = new Entities();
        entities183 = findBean.nameEntities("Dependencies",em);
        relationships22.setFrom(entities183);
//      ...................... Sites ........................
        Entities entities184 = new Entities();
        entities184 = findBean.nameEntities("Sites",em);
        relationships22.setTo(entities184);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities185 = new Cardinalities();
        cardinalities185 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships22.setCardinalities(cardinalities185);
        em.persist(relationships22);
        em.flush();

        Relationships relationships23 = new Relationships();
        relationships23.setIsOptionality(true);
        relationships23.setIsEmbedded(false);
        relationships23.setName("");
//      ...................... AttributesProperties ........................
        Entities entities186 = new Entities();
        entities186 = findBean.nameEntities("AttributesProperties",em);
        relationships23.setFrom(entities186);
//      ...................... Imports ........................
        Entities entities187 = new Entities();
        entities187 = findBean.nameEntities("Imports",em);
        relationships23.setTo(entities187);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities188 = new Cardinalities();
        cardinalities188 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships23.setCardinalities(cardinalities188);
        em.persist(relationships23);
        em.flush();

        Relationships relationships24 = new Relationships();
        relationships24.setIsOptionality(true);
        relationships24.setIsEmbedded(false);
        relationships24.setName("");
//      ...................... AttributesProperties ........................
        Entities entities189 = new Entities();
        entities189 = findBean.nameEntities("AttributesProperties",em);
        relationships24.setFrom(entities189);
//      ...................... Sites ........................
        Entities entities190 = new Entities();
        entities190 = findBean.nameEntities("Sites",em);
        relationships24.setTo(entities190);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities191 = new Cardinalities();
        cardinalities191 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships24.setCardinalities(cardinalities191);
        em.persist(relationships24);
        em.flush();

        Relationships relationships25 = new Relationships();
        relationships25.setIsOptionality(true);
        relationships25.setIsEmbedded(false);
        relationships25.setName("");
//      ...................... AttributesTypes ........................
        Entities entities192 = new Entities();
        entities192 = findBean.nameEntities("AttributesTypes",em);
        relationships25.setFrom(entities192);
//      ...................... Attributes ........................
        Entities entities193 = new Entities();
        entities193 = findBean.nameEntities("Attributes",em);
        relationships25.setTo(entities193);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities194 = new Cardinalities();
        cardinalities194 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships25.setCardinalities(cardinalities194);
        em.persist(relationships25);
        em.flush();

        Relationships relationships26 = new Relationships();
        relationships26.setIsOptionality(true);
        relationships26.setIsEmbedded(false);
        relationships26.setName("");
//      ...................... AttributesTypes ........................
        Entities entities195 = new Entities();
        entities195 = findBean.nameEntities("AttributesTypes",em);
        relationships26.setFrom(entities195);
//      ...................... AttributesProperties ........................
        Entities entities196 = new Entities();
        entities196 = findBean.nameEntities("AttributesProperties",em);
        relationships26.setTo(entities196);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities197 = new Cardinalities();
        cardinalities197 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships26.setCardinalities(cardinalities197);
        em.persist(relationships26);
        em.flush();

        Relationships relationships27 = new Relationships();
        relationships27.setIsOptionality(true);
        relationships27.setIsEmbedded(false);
        relationships27.setName("");
//      ...................... AttributesTypes ........................
        Entities entities198 = new Entities();
        entities198 = findBean.nameEntities("AttributesTypes",em);
        relationships27.setFrom(entities198);
//      ...................... Sites ........................
        Entities entities199 = new Entities();
        entities199 = findBean.nameEntities("Sites",em);
        relationships27.setTo(entities199);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities200 = new Cardinalities();
        cardinalities200 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships27.setCardinalities(cardinalities200);
        em.persist(relationships27);
        em.flush();

    } // data()

} // naifgSetup
