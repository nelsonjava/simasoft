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
        groupIds1.setArtifactId("co.simasoft.models.core.sites");
        groupIds1.setGroupId("co.simasoft.models.core.sites");
        groupIds1.setVersion("null");
        groupIds1.setCode("null");
        em.persist(groupIds1);
        em.flush();

        GroupIds groupIds2 = new GroupIds();
        groupIds2.setArtifactId("co.simasoft.models.dev.naifg");
        groupIds2.setGroupId("co.simasoft.models.dev.naifg");
        groupIds2.setVersion("null");
        groupIds2.setCode("null");
        em.persist(groupIds2);
        em.flush();

        GroupIds groupIds3 = new GroupIds();
        groupIds3.setArtifactId("co.simasoft.models.dev.naifg.dependencies");
        groupIds3.setGroupId("co.simasoft.models.dev.naifg.dependencies");
        groupIds3.setVersion("null");
        groupIds3.setCode("null");
        em.persist(groupIds3);
        em.flush();

//      ---------------------- Models ------------------------

        Models models = new Models();
        models.setArtifactId("naifg");
        models.setGroupId("co.simasoft.models.dev.naifg");
        models.setVersion("1.0-SNAPSHOT");
        models.setCode("null");
        em.persist(models);
        em.flush();

//      ---------------------- ModelsGroupIds ----------------------

        ModelsGroupIds modelsGroupIds1 = new ModelsGroupIds();
        Models modelss1 = findBean.artifactIdModels("naifg",em);
        GroupIds groupIdd1 = findBean.artifactIdGroupIds("co.simasoft.models.core.sites",em);
        modelsGroupIds1.setModels(modelss1);
        modelsGroupIds1.setGroupIds(groupIdd1);
        modelsGroupIds1.setIsSingle(true);
        modelsGroupIds1.setIsSimplified(true);
        em.persist(modelsGroupIds1);
        em.flush();

        ModelsGroupIds modelsGroupIds2 = new ModelsGroupIds();
        Models modelss2 = findBean.artifactIdModels("naifg",em);
        GroupIds groupIdd2 = findBean.artifactIdGroupIds("co.simasoft.models.dev.naifg",em);
        modelsGroupIds2.setModels(modelss2);
        modelsGroupIds2.setGroupIds(groupIdd2);
        modelsGroupIds2.setIsSingle(null);
        modelsGroupIds2.setIsSimplified(null);
        em.persist(modelsGroupIds2);
        em.flush();

        ModelsGroupIds modelsGroupIds3 = new ModelsGroupIds();
        Models modelss3 = findBean.artifactIdModels("naifg",em);
        GroupIds groupIdd3 = findBean.artifactIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        modelsGroupIds3.setModels(modelss3);
        modelsGroupIds3.setGroupIds(groupIdd3);
        modelsGroupIds3.setIsSingle(null);
        modelsGroupIds3.setIsSimplified(null);
        em.persist(modelsGroupIds3);
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
        entities1.setName("Attributes");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId1 = new GroupIds();
        groupId1 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities1.setGroupIds(groupId1);
        em.persist(entities1);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes2 = new Attributes();
        attributes2.setName("description");
        attributes2.setIsNullable(true);
        attributes2.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity2 = new Entities();
        entity2 = findBean.nameEntities("Attributes",em);
        attributes2.setEntities(entity2);
//      ...................... String ........................
        AttributesTypes attributesTypes3 = new AttributesTypes();
        attributesTypes3 = findBean.nameAttributesTypes("String",em);
        attributes2.setAttributesTypes(attributesTypes3);
        em.persist(attributes2);
        em.flush();

        Attributes attributes3 = new Attributes();
        attributes3.setName("length");
        attributes3.setIsNullable(true);
        attributes3.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity4 = new Entities();
        entity4 = findBean.nameEntities("Attributes",em);
        attributes3.setEntities(entity4);
//      ...................... Integer ........................
        AttributesTypes attributesTypes5 = new AttributesTypes();
        attributesTypes5 = findBean.nameAttributesTypes("Integer",em);
        attributes3.setAttributesTypes(attributesTypes5);
        em.persist(attributes3);
        em.flush();

        Attributes attributes4 = new Attributes();
        attributes4.setName("name");
        attributes4.setIsNullable(false);
        attributes4.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity6 = new Entities();
        entity6 = findBean.nameEntities("Attributes",em);
        attributes4.setEntities(entity6);
//      ...................... String ........................
        AttributesTypes attributesTypes7 = new AttributesTypes();
        attributesTypes7 = findBean.nameAttributesTypes("String",em);
        attributes4.setAttributesTypes(attributesTypes7);
        em.persist(attributes4);
        em.flush();

        Attributes attributes5 = new Attributes();
        attributes5.setName("isNullable");
        attributes5.setIsNullable(true);
        attributes5.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity8 = new Entities();
        entity8 = findBean.nameEntities("Attributes",em);
        attributes5.setEntities(entity8);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes9 = new AttributesTypes();
        attributesTypes9 = findBean.nameAttributesTypes("Boolean",em);
        attributes5.setAttributesTypes(attributesTypes9);
        em.persist(attributes5);
        em.flush();

        Attributes attributes6 = new Attributes();
        attributes6.setName("precision");
        attributes6.setIsNullable(true);
        attributes6.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity10 = new Entities();
        entity10 = findBean.nameEntities("Attributes",em);
        attributes6.setEntities(entity10);
//      ...................... Integer ........................
        AttributesTypes attributesTypes11 = new AttributesTypes();
        attributesTypes11 = findBean.nameAttributesTypes("Integer",em);
        attributes6.setAttributesTypes(attributesTypes11);
        em.persist(attributes6);
        em.flush();

        Attributes attributes7 = new Attributes();
        attributes7.setName("isSimplified");
        attributes7.setIsNullable(true);
        attributes7.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity12 = new Entities();
        entity12 = findBean.nameEntities("Attributes",em);
        attributes7.setEntities(entity12);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes13 = new AttributesTypes();
        attributesTypes13 = findBean.nameAttributesTypes("Boolean",em);
        attributes7.setAttributesTypes(attributesTypes13);
        em.persist(attributes7);
        em.flush();

        Attributes attributes8 = new Attributes();
        attributes8.setName("isUnique");
        attributes8.setIsNullable(true);
        attributes8.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity14 = new Entities();
        entity14 = findBean.nameEntities("Attributes",em);
        attributes8.setEntities(entity14);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes15 = new AttributesTypes();
        attributesTypes15 = findBean.nameAttributesTypes("Boolean",em);
        attributes8.setAttributesTypes(attributesTypes15);
        em.persist(attributes8);
        em.flush();

        Entities entities9 = new Entities();
        entities9.setName("ModelsGroupIds");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId16 = new GroupIds();
        groupId16 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities9.setGroupIds(groupId16);
        em.persist(entities9);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes10 = new Attributes();
        attributes10.setName("isSimplified");
        attributes10.setIsNullable(true);
        attributes10.setIsUnique(false);
//      ...................... ModelsGroupIds ........................
        Entities entity17 = new Entities();
        entity17 = findBean.nameEntities("ModelsGroupIds",em);
        attributes10.setEntities(entity17);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes18 = new AttributesTypes();
        attributesTypes18 = findBean.nameAttributesTypes("Boolean",em);
        attributes10.setAttributesTypes(attributesTypes18);
        em.persist(attributes10);
        em.flush();

        Attributes attributes11 = new Attributes();
        attributes11.setName("isSingle");
        attributes11.setIsNullable(true);
        attributes11.setIsUnique(false);
//      ...................... ModelsGroupIds ........................
        Entities entity19 = new Entities();
        entity19 = findBean.nameEntities("ModelsGroupIds",em);
        attributes11.setEntities(entity19);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes20 = new AttributesTypes();
        attributesTypes20 = findBean.nameAttributesTypes("Boolean",em);
        attributes11.setAttributesTypes(attributesTypes20);
        em.persist(attributes11);
        em.flush();

        Entities entities12 = new Entities();
        entities12.setName("Developments");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId21 = new GroupIds();
        groupId21 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities12.setGroupIds(groupId21);
        em.persist(entities12);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes13 = new Attributes();
        attributes13.setName("version");
        attributes13.setIsNullable(true);
        attributes13.setIsUnique(false);
//      ...................... Developments ........................
        Entities entity22 = new Entities();
        entity22 = findBean.nameEntities("Developments",em);
        attributes13.setEntities(entity22);
//      ...................... String ........................
        AttributesTypes attributesTypes23 = new AttributesTypes();
        attributesTypes23 = findBean.nameAttributesTypes("String",em);
        attributes13.setAttributesTypes(attributesTypes23);
        em.persist(attributes13);
        em.flush();

        Attributes attributes14 = new Attributes();
        attributes14.setName("code");
        attributes14.setIsNullable(true);
        attributes14.setIsUnique(false);
//      ...................... Developments ........................
        Entities entity24 = new Entities();
        entity24 = findBean.nameEntities("Developments",em);
        attributes14.setEntities(entity24);
//      ...................... String ........................
        AttributesTypes attributesTypes25 = new AttributesTypes();
        attributesTypes25 = findBean.nameAttributesTypes("String",em);
        attributes14.setAttributesTypes(attributesTypes25);
        em.persist(attributes14);
        em.flush();

        Attributes attributes15 = new Attributes();
        attributes15.setName("artifactId");
        attributes15.setIsNullable(false);
        attributes15.setIsUnique(true);
//      ...................... Developments ........................
        Entities entity26 = new Entities();
        entity26 = findBean.nameEntities("Developments",em);
        attributes15.setEntities(entity26);
//      ...................... String ........................
        AttributesTypes attributesTypes27 = new AttributesTypes();
        attributesTypes27 = findBean.nameAttributesTypes("String",em);
        attributes15.setAttributesTypes(attributesTypes27);
        em.persist(attributes15);
        em.flush();

        Attributes attributes16 = new Attributes();
        attributes16.setName("date");
        attributes16.setIsNullable(true);
        attributes16.setIsUnique(false);
//      ...................... Developments ........................
        Entities entity28 = new Entities();
        entity28 = findBean.nameEntities("Developments",em);
        attributes16.setEntities(entity28);
//      ...................... Date ........................
        AttributesTypes attributesTypes29 = new AttributesTypes();
        attributesTypes29 = findBean.nameAttributesTypes("Date",em);
        attributes16.setAttributesTypes(attributesTypes29);
        em.persist(attributes16);
        em.flush();

        Attributes attributes17 = new Attributes();
        attributes17.setName("groupId");
        attributes17.setIsNullable(true);
        attributes17.setIsUnique(false);
//      ...................... Developments ........................
        Entities entity30 = new Entities();
        entity30 = findBean.nameEntities("Developments",em);
        attributes17.setEntities(entity30);
//      ...................... String ........................
        AttributesTypes attributesTypes31 = new AttributesTypes();
        attributesTypes31 = findBean.nameAttributesTypes("String",em);
        attributes17.setAttributesTypes(attributesTypes31);
        em.persist(attributes17);
        em.flush();

        Entities entities18 = new Entities();
        entities18.setName("NameQueries");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId32 = new GroupIds();
        groupId32 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities18.setGroupIds(groupId32);
        em.persist(entities18);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes19 = new Attributes();
        attributes19.setName("query");
        attributes19.setIsNullable(false);
        attributes19.setIsUnique(true);
//      ...................... NameQueries ........................
        Entities entity33 = new Entities();
        entity33 = findBean.nameEntities("NameQueries",em);
        attributes19.setEntities(entity33);
//      ...................... String ........................
        AttributesTypes attributesTypes34 = new AttributesTypes();
        attributesTypes34 = findBean.nameAttributesTypes("String",em);
        attributes19.setAttributesTypes(attributesTypes34);
        em.persist(attributes19);
        em.flush();

        Attributes attributes20 = new Attributes();
        attributes20.setName("name");
        attributes20.setIsNullable(false);
        attributes20.setIsUnique(true);
//      ...................... NameQueries ........................
        Entities entity35 = new Entities();
        entity35 = findBean.nameEntities("NameQueries",em);
        attributes20.setEntities(entity35);
//      ...................... String ........................
        AttributesTypes attributesTypes36 = new AttributesTypes();
        attributesTypes36 = findBean.nameAttributesTypes("String",em);
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
        attributes22.setIsNullable(true);
        attributes22.setIsUnique(false);
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
        attributes23.setName("isOptionality");
        attributes23.setIsNullable(true);
        attributes23.setIsUnique(false);
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
        attributes24.setIsNullable(true);
        attributes24.setIsUnique(false);
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
        attributes25.setName("isSimplified");
        attributes25.setIsNullable(true);
        attributes25.setIsUnique(false);
//      ...................... Relationships ........................
        Entities entity44 = new Entities();
        entity44 = findBean.nameEntities("Relationships",em);
        attributes25.setEntities(entity44);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes45 = new AttributesTypes();
        attributesTypes45 = findBean.nameAttributesTypes("Boolean",em);
        attributes25.setAttributesTypes(attributesTypes45);
        em.persist(attributes25);
        em.flush();

        Entities entities26 = new Entities();
        entities26.setName("GroupIds");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId46 = new GroupIds();
        groupId46 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities26.setGroupIds(groupId46);
        em.persist(entities26);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes27 = new Attributes();
        attributes27.setName("version");
        attributes27.setIsNullable(true);
        attributes27.setIsUnique(false);
//      ...................... GroupIds ........................
        Entities entity47 = new Entities();
        entity47 = findBean.nameEntities("GroupIds",em);
        attributes27.setEntities(entity47);
//      ...................... String ........................
        AttributesTypes attributesTypes48 = new AttributesTypes();
        attributesTypes48 = findBean.nameAttributesTypes("String",em);
        attributes27.setAttributesTypes(attributesTypes48);
        em.persist(attributes27);
        em.flush();

        Attributes attributes28 = new Attributes();
        attributes28.setName("code");
        attributes28.setIsNullable(true);
        attributes28.setIsUnique(false);
//      ...................... GroupIds ........................
        Entities entity49 = new Entities();
        entity49 = findBean.nameEntities("GroupIds",em);
        attributes28.setEntities(entity49);
//      ...................... String ........................
        AttributesTypes attributesTypes50 = new AttributesTypes();
        attributesTypes50 = findBean.nameAttributesTypes("String",em);
        attributes28.setAttributesTypes(attributesTypes50);
        em.persist(attributes28);
        em.flush();

        Attributes attributes29 = new Attributes();
        attributes29.setName("date");
        attributes29.setIsNullable(true);
        attributes29.setIsUnique(false);
//      ...................... GroupIds ........................
        Entities entity51 = new Entities();
        entity51 = findBean.nameEntities("GroupIds",em);
        attributes29.setEntities(entity51);
//      ...................... Date ........................
        AttributesTypes attributesTypes52 = new AttributesTypes();
        attributesTypes52 = findBean.nameAttributesTypes("Date",em);
        attributes29.setAttributesTypes(attributesTypes52);
        em.persist(attributes29);
        em.flush();

        Attributes attributes30 = new Attributes();
        attributes30.setName("artifactId");
        attributes30.setIsNullable(false);
        attributes30.setIsUnique(true);
//      ...................... GroupIds ........................
        Entities entity53 = new Entities();
        entity53 = findBean.nameEntities("GroupIds",em);
        attributes30.setEntities(entity53);
//      ...................... String ........................
        AttributesTypes attributesTypes54 = new AttributesTypes();
        attributesTypes54 = findBean.nameAttributesTypes("String",em);
        attributes30.setAttributesTypes(attributesTypes54);
        em.persist(attributes30);
        em.flush();

        Attributes attributes31 = new Attributes();
        attributes31.setName("groupId");
        attributes31.setIsNullable(false);
        attributes31.setIsUnique(true);
//      ...................... GroupIds ........................
        Entities entity55 = new Entities();
        entity55 = findBean.nameEntities("GroupIds",em);
        attributes31.setEntities(entity55);
//      ...................... String ........................
        AttributesTypes attributesTypes56 = new AttributesTypes();
        attributesTypes56 = findBean.nameAttributesTypes("String",em);
        attributes31.setAttributesTypes(attributesTypes56);
        em.persist(attributes31);
        em.flush();

        Entities entities32 = new Entities();
        entities32.setName("Cardinalities");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId57 = new GroupIds();
        groupId57 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities32.setGroupIds(groupId57);
        em.persist(entities32);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes33 = new Attributes();
        attributes33.setName("name");
        attributes33.setIsNullable(false);
        attributes33.setIsUnique(true);
//      ...................... Cardinalities ........................
        Entities entity58 = new Entities();
        entity58 = findBean.nameEntities("Cardinalities",em);
        attributes33.setEntities(entity58);
//      ...................... String ........................
        AttributesTypes attributesTypes59 = new AttributesTypes();
        attributesTypes59 = findBean.nameAttributesTypes("String",em);
        attributes33.setAttributesTypes(attributesTypes59);
        em.persist(attributes33);
        em.flush();

        Attributes attributes34 = new Attributes();
        attributes34.setName("cardinality");
        attributes34.setIsNullable(false);
        attributes34.setIsUnique(false);
//      ...................... Cardinalities ........................
        Entities entity60 = new Entities();
        entity60 = findBean.nameEntities("Cardinalities",em);
        attributes34.setEntities(entity60);
//      ...................... String ........................
        AttributesTypes attributesTypes61 = new AttributesTypes();
        attributesTypes61 = findBean.nameAttributesTypes("String",em);
        attributes34.setAttributesTypes(attributesTypes61);
        em.persist(attributes34);
        em.flush();

        Attributes attributes35 = new Attributes();
        attributes35.setName("isUnidirectional");
        attributes35.setIsNullable(true);
        attributes35.setIsUnique(false);
//      ...................... Cardinalities ........................
        Entities entity62 = new Entities();
        entity62 = findBean.nameEntities("Cardinalities",em);
        attributes35.setEntities(entity62);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes63 = new AttributesTypes();
        attributesTypes63 = findBean.nameAttributesTypes("Boolean",em);
        attributes35.setAttributesTypes(attributesTypes63);
        em.persist(attributes35);
        em.flush();

        Entities entities36 = new Entities();
        entities36.setName("Entities");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId64 = new GroupIds();
        groupId64 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities36.setGroupIds(groupId64);
        em.persist(entities36);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes37 = new Attributes();
        attributes37.setName("table");
        attributes37.setIsNullable(true);
        attributes37.setIsUnique(false);
//      ...................... Entities ........................
        Entities entity65 = new Entities();
        entity65 = findBean.nameEntities("Entities",em);
        attributes37.setEntities(entity65);
//      ...................... String ........................
        AttributesTypes attributesTypes66 = new AttributesTypes();
        attributesTypes66 = findBean.nameAttributesTypes("String",em);
        attributes37.setAttributesTypes(attributesTypes66);
        em.persist(attributes37);
        em.flush();

        Attributes attributes38 = new Attributes();
        attributes38.setName("isSimplified");
        attributes38.setIsNullable(true);
        attributes38.setIsUnique(false);
//      ...................... Entities ........................
        Entities entity67 = new Entities();
        entity67 = findBean.nameEntities("Entities",em);
        attributes38.setEntities(entity67);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes68 = new AttributesTypes();
        attributesTypes68 = findBean.nameAttributesTypes("Boolean",em);
        attributes38.setAttributesTypes(attributesTypes68);
        em.persist(attributes38);
        em.flush();

        Attributes attributes39 = new Attributes();
        attributes39.setName("serialID");
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
        attributes40.setName("name");
        attributes40.setIsNullable(false);
        attributes40.setIsUnique(true);
//      ...................... Entities ........................
        Entities entity71 = new Entities();
        entity71 = findBean.nameEntities("Entities",em);
        attributes40.setEntities(entity71);
//      ...................... String ........................
        AttributesTypes attributesTypes72 = new AttributesTypes();
        attributesTypes72 = findBean.nameAttributesTypes("String",em);
        attributes40.setAttributesTypes(attributesTypes72);
        em.persist(attributes40);
        em.flush();

        Attributes attributes41 = new Attributes();
        attributes41.setName("description");
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

        Entities entities42 = new Entities();
        entities42.setName("Models");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId75 = new GroupIds();
        groupId75 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities42.setGroupIds(groupId75);
        em.persist(entities42);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes43 = new Attributes();
        attributes43.setName("date");
        attributes43.setIsNullable(true);
        attributes43.setIsUnique(false);
//      ...................... Models ........................
        Entities entity76 = new Entities();
        entity76 = findBean.nameEntities("Models",em);
        attributes43.setEntities(entity76);
//      ...................... Date ........................
        AttributesTypes attributesTypes77 = new AttributesTypes();
        attributesTypes77 = findBean.nameAttributesTypes("Date",em);
        attributes43.setAttributesTypes(attributesTypes77);
        em.persist(attributes43);
        em.flush();

        Attributes attributes44 = new Attributes();
        attributes44.setName("version");
        attributes44.setIsNullable(true);
        attributes44.setIsUnique(false);
//      ...................... Models ........................
        Entities entity78 = new Entities();
        entity78 = findBean.nameEntities("Models",em);
        attributes44.setEntities(entity78);
//      ...................... String ........................
        AttributesTypes attributesTypes79 = new AttributesTypes();
        attributesTypes79 = findBean.nameAttributesTypes("String",em);
        attributes44.setAttributesTypes(attributesTypes79);
        em.persist(attributes44);
        em.flush();

        Attributes attributes45 = new Attributes();
        attributes45.setName("code");
        attributes45.setIsNullable(true);
        attributes45.setIsUnique(false);
//      ...................... Models ........................
        Entities entity80 = new Entities();
        entity80 = findBean.nameEntities("Models",em);
        attributes45.setEntities(entity80);
//      ...................... String ........................
        AttributesTypes attributesTypes81 = new AttributesTypes();
        attributesTypes81 = findBean.nameAttributesTypes("String",em);
        attributes45.setAttributesTypes(attributesTypes81);
        em.persist(attributes45);
        em.flush();

        Attributes attributes46 = new Attributes();
        attributes46.setName("groupId");
        attributes46.setIsNullable(false);
        attributes46.setIsUnique(true);
//      ...................... Models ........................
        Entities entity82 = new Entities();
        entity82 = findBean.nameEntities("Models",em);
        attributes46.setEntities(entity82);
//      ...................... String ........................
        AttributesTypes attributesTypes83 = new AttributesTypes();
        attributesTypes83 = findBean.nameAttributesTypes("String",em);
        attributes46.setAttributesTypes(attributesTypes83);
        em.persist(attributes46);
        em.flush();

        Attributes attributes47 = new Attributes();
        attributes47.setName("artifactId");
        attributes47.setIsNullable(false);
        attributes47.setIsUnique(true);
//      ...................... Models ........................
        Entities entity84 = new Entities();
        entity84 = findBean.nameEntities("Models",em);
        attributes47.setEntities(entity84);
//      ...................... String ........................
        AttributesTypes attributesTypes85 = new AttributesTypes();
        attributesTypes85 = findBean.nameAttributesTypes("String",em);
        attributes47.setAttributesTypes(attributesTypes85);
        em.persist(attributes47);
        em.flush();

        Entities entities48 = new Entities();
        entities48.setName("AttributesTypes");
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId86 = new GroupIds();
        groupId86 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities48.setGroupIds(groupId86);
        em.persist(entities48);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes49 = new Attributes();
        attributes49.setName("annotations");
        attributes49.setIsNullable(true);
        attributes49.setIsUnique(false);
//      ...................... AttributesTypes ........................
        Entities entity87 = new Entities();
        entity87 = findBean.nameEntities("AttributesTypes",em);
        attributes49.setEntities(entity87);
//      ...................... String ........................
        AttributesTypes attributesTypes88 = new AttributesTypes();
        attributesTypes88 = findBean.nameAttributesTypes("String",em);
        attributes49.setAttributesTypes(attributesTypes88);
        em.persist(attributes49);
        em.flush();

        Attributes attributes50 = new Attributes();
        attributes50.setName("precision");
        attributes50.setIsNullable(true);
        attributes50.setIsUnique(false);
//      ...................... AttributesTypes ........................
        Entities entity89 = new Entities();
        entity89 = findBean.nameEntities("AttributesTypes",em);
        attributes50.setEntities(entity89);
//      ...................... Integer ........................
        AttributesTypes attributesTypes90 = new AttributesTypes();
        attributesTypes90 = findBean.nameAttributesTypes("Integer",em);
        attributes50.setAttributesTypes(attributesTypes90);
        em.persist(attributes50);
        em.flush();

        Attributes attributes51 = new Attributes();
        attributes51.setName("name");
        attributes51.setIsNullable(false);
        attributes51.setIsUnique(true);
//      ...................... AttributesTypes ........................
        Entities entity91 = new Entities();
        entity91 = findBean.nameEntities("AttributesTypes",em);
        attributes51.setEntities(entity91);
//      ...................... String ........................
        AttributesTypes attributesTypes92 = new AttributesTypes();
        attributesTypes92 = findBean.nameAttributesTypes("String",em);
        attributes51.setAttributesTypes(attributesTypes92);
        em.persist(attributes51);
        em.flush();

        Attributes attributes52 = new Attributes();
        attributes52.setName("length");
        attributes52.setIsNullable(true);
        attributes52.setIsUnique(false);
//      ...................... AttributesTypes ........................
        Entities entity93 = new Entities();
        entity93 = findBean.nameEntities("AttributesTypes",em);
        attributes52.setEntities(entity93);
//      ...................... Integer ........................
        AttributesTypes attributesTypes94 = new AttributesTypes();
        attributesTypes94 = findBean.nameAttributesTypes("Integer",em);
        attributes52.setAttributesTypes(attributesTypes94);
        em.persist(attributes52);
        em.flush();

        Attributes attributes53 = new Attributes();
        attributes53.setName("type");
        attributes53.setIsNullable(false);
        attributes53.setIsUnique(false);
//      ...................... AttributesTypes ........................
        Entities entity95 = new Entities();
        entity95 = findBean.nameEntities("AttributesTypes",em);
        attributes53.setEntities(entity95);
//      ...................... String ........................
        AttributesTypes attributesTypes96 = new AttributesTypes();
        attributesTypes96 = findBean.nameAttributesTypes("String",em);
        attributes53.setAttributesTypes(attributesTypes96);
        em.persist(attributes53);
        em.flush();

        Entities entities54 = new Entities();
        entities54.setName("AttributesProperties");
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId97 = new GroupIds();
        groupId97 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities54.setGroupIds(groupId97);
        em.persist(entities54);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes55 = new Attributes();
        attributes55.setName("value");
        attributes55.setIsNullable(false);
        attributes55.setIsUnique(true);
//      ...................... AttributesProperties ........................
        Entities entity98 = new Entities();
        entity98 = findBean.nameEntities("AttributesProperties",em);
        attributes55.setEntities(entity98);
//      ...................... String ........................
        AttributesTypes attributesTypes99 = new AttributesTypes();
        attributesTypes99 = findBean.nameAttributesTypes("String",em);
        attributes55.setAttributesTypes(attributesTypes99);
        em.persist(attributes55);
        em.flush();

        Attributes attributes56 = new Attributes();
        attributes56.setName("name");
        attributes56.setIsNullable(false);
        attributes56.setIsUnique(true);
//      ...................... AttributesProperties ........................
        Entities entity100 = new Entities();
        entity100 = findBean.nameEntities("AttributesProperties",em);
        attributes56.setEntities(entity100);
//      ...................... String ........................
        AttributesTypes attributesTypes101 = new AttributesTypes();
        attributesTypes101 = findBean.nameAttributesTypes("String",em);
        attributes56.setAttributesTypes(attributesTypes101);
        em.persist(attributes56);
        em.flush();

        Entities entities57 = new Entities();
        entities57.setName("Imports");
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId102 = new GroupIds();
        groupId102 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities57.setGroupIds(groupId102);
        em.persist(entities57);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes58 = new Attributes();
        attributes58.setName("name");
        attributes58.setIsNullable(false);
        attributes58.setIsUnique(true);
//      ...................... Imports ........................
        Entities entity103 = new Entities();
        entity103 = findBean.nameEntities("Imports",em);
        attributes58.setEntities(entity103);
//      ...................... String ........................
        AttributesTypes attributesTypes104 = new AttributesTypes();
        attributesTypes104 = findBean.nameAttributesTypes("String",em);
        attributes58.setAttributesTypes(attributesTypes104);
        em.persist(attributes58);
        em.flush();

        Entities entities59 = new Entities();
        entities59.setName("Dependencies");
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId105 = new GroupIds();
        groupId105 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities59.setGroupIds(groupId105);
        em.persist(entities59);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes60 = new Attributes();
        attributes60.setName("type");
        attributes60.setIsNullable(true);
        attributes60.setIsUnique(false);
//      ...................... Dependencies ........................
        Entities entity106 = new Entities();
        entity106 = findBean.nameEntities("Dependencies",em);
        attributes60.setEntities(entity106);
//      ...................... String ........................
        AttributesTypes attributesTypes107 = new AttributesTypes();
        attributesTypes107 = findBean.nameAttributesTypes("String",em);
        attributes60.setAttributesTypes(attributesTypes107);
        em.persist(attributes60);
        em.flush();

        Attributes attributes61 = new Attributes();
        attributes61.setName("scope");
        attributes61.setIsNullable(true);
        attributes61.setIsUnique(false);
//      ...................... Dependencies ........................
        Entities entity108 = new Entities();
        entity108 = findBean.nameEntities("Dependencies",em);
        attributes61.setEntities(entity108);
//      ...................... String ........................
        AttributesTypes attributesTypes109 = new AttributesTypes();
        attributesTypes109 = findBean.nameAttributesTypes("String",em);
        attributes61.setAttributesTypes(attributesTypes109);
        em.persist(attributes61);
        em.flush();

        Attributes attributes62 = new Attributes();
        attributes62.setName("version");
        attributes62.setIsNullable(true);
        attributes62.setIsUnique(false);
//      ...................... Dependencies ........................
        Entities entity110 = new Entities();
        entity110 = findBean.nameEntities("Dependencies",em);
        attributes62.setEntities(entity110);
//      ...................... String ........................
        AttributesTypes attributesTypes111 = new AttributesTypes();
        attributesTypes111 = findBean.nameAttributesTypes("String",em);
        attributes62.setAttributesTypes(attributesTypes111);
        em.persist(attributes62);
        em.flush();

        Attributes attributes63 = new Attributes();
        attributes63.setName("artifactId");
        attributes63.setIsNullable(false);
        attributes63.setIsUnique(false);
//      ...................... Dependencies ........................
        Entities entity112 = new Entities();
        entity112 = findBean.nameEntities("Dependencies",em);
        attributes63.setEntities(entity112);
//      ...................... String ........................
        AttributesTypes attributesTypes113 = new AttributesTypes();
        attributesTypes113 = findBean.nameAttributesTypes("String",em);
        attributes63.setAttributesTypes(attributesTypes113);
        em.persist(attributes63);
        em.flush();

        Attributes attributes64 = new Attributes();
        attributes64.setName("maven");
        attributes64.setIsNullable(false);
        attributes64.setIsUnique(true);
//      ...................... Dependencies ........................
        Entities entity114 = new Entities();
        entity114 = findBean.nameEntities("Dependencies",em);
        attributes64.setEntities(entity114);
//      ...................... String ........................
        AttributesTypes attributesTypes115 = new AttributesTypes();
        attributesTypes115 = findBean.nameAttributesTypes("String",em);
        attributes64.setAttributesTypes(attributesTypes115);
        em.persist(attributes64);
        em.flush();

        Attributes attributes65 = new Attributes();
        attributes65.setName("groupId");
        attributes65.setIsNullable(false);
        attributes65.setIsUnique(false);
//      ...................... Dependencies ........................
        Entities entity116 = new Entities();
        entity116 = findBean.nameEntities("Dependencies",em);
        attributes65.setEntities(entity116);
//      ...................... String ........................
        AttributesTypes attributesTypes117 = new AttributesTypes();
        attributesTypes117 = findBean.nameAttributesTypes("String",em);
        attributes65.setAttributesTypes(attributesTypes117);
        em.persist(attributes65);
        em.flush();

//      ---------------------- Relationships ------------------------

/*
. SitesTypes . 1..* SitesTypes
. SitesTypes . *..* Sites
. Attributes . *..* Sites
. Attributes . *..* AttributesProperties
. Developments . *..* Models
. Developments . *..* Sites
. Relationships . *..* AttributesProperties
. GroupIds . 1..* Entities
. GroupIds . 1..* ModelsGroupIds
. Cardinalities . *..* Imports
. Cardinalities . *..* Sites
. Cardinalities . 1..* Relationships
. Entities . 1..* Relationships
. Entities . *..* Sites
. Entities . 1..* NameQueries
. Entities . *..* Imports
. Entities . *..* AttributesProperties
. Entities . 1..* Attributes
. Entities . 1..* Relationships
. Models . *..* Sites
. Models . 1..* ModelsGroupIds
. AttributesTypes . *..* AttributesProperties
. AttributesTypes . *..* Sites
. AttributesTypes . 1..* Attributes
. AttributesProperties . *..* Imports
. AttributesProperties . *..* Sites
. Imports . *..* Sites
. Dependencies . *..* Sites
. Dependencies . 1..* Imports
*/
        Relationships relationships1 = new Relationships();
        relationships1.setIsOptionality(true);
        relationships1.setIsEmbedded(false);
        relationships1.setName("");
//      ...................... SitesTypes ........................
        Entities entities118 = new Entities();
        entities118 = findBean.nameEntities("SitesTypes",em);
        relationships1.setFrom(entities118);
//      ...................... SitesTypes ........................
        Entities entities119 = new Entities();
        entities119 = findBean.nameEntities("SitesTypes",em);
        relationships1.setTo(entities119);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities120 = new Cardinalities();
        cardinalities120 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships1.setCardinalities(cardinalities120);
        em.persist(relationships1);
        em.flush();

        Relationships relationships2 = new Relationships();
        relationships2.setIsOptionality(true);
        relationships2.setIsEmbedded(false);
        relationships2.setName("");
//      ...................... SitesTypes ........................
        Entities entities121 = new Entities();
        entities121 = findBean.nameEntities("SitesTypes",em);
        relationships2.setFrom(entities121);
//      ...................... Sites ........................
        Entities entities122 = new Entities();
        entities122 = findBean.nameEntities("Sites",em);
        relationships2.setTo(entities122);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities123 = new Cardinalities();
        cardinalities123 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships2.setCardinalities(cardinalities123);
        em.persist(relationships2);
        em.flush();

        Relationships relationships3 = new Relationships();
        relationships3.setIsOptionality(true);
        relationships3.setIsEmbedded(false);
        relationships3.setName("");
//      ...................... Attributes ........................
        Entities entities124 = new Entities();
        entities124 = findBean.nameEntities("Attributes",em);
        relationships3.setFrom(entities124);
//      ...................... Sites ........................
        Entities entities125 = new Entities();
        entities125 = findBean.nameEntities("Sites",em);
        relationships3.setTo(entities125);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities126 = new Cardinalities();
        cardinalities126 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships3.setCardinalities(cardinalities126);
        em.persist(relationships3);
        em.flush();

        Relationships relationships4 = new Relationships();
        relationships4.setIsOptionality(true);
        relationships4.setIsEmbedded(false);
        relationships4.setName("");
//      ...................... Attributes ........................
        Entities entities127 = new Entities();
        entities127 = findBean.nameEntities("Attributes",em);
        relationships4.setFrom(entities127);
//      ...................... AttributesProperties ........................
        Entities entities128 = new Entities();
        entities128 = findBean.nameEntities("AttributesProperties",em);
        relationships4.setTo(entities128);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities129 = new Cardinalities();
        cardinalities129 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships4.setCardinalities(cardinalities129);
        em.persist(relationships4);
        em.flush();

        Relationships relationships5 = new Relationships();
        relationships5.setIsOptionality(true);
        relationships5.setIsEmbedded(false);
        relationships5.setName("");
//      ...................... Developments ........................
        Entities entities130 = new Entities();
        entities130 = findBean.nameEntities("Developments",em);
        relationships5.setFrom(entities130);
//      ...................... Models ........................
        Entities entities131 = new Entities();
        entities131 = findBean.nameEntities("Models",em);
        relationships5.setTo(entities131);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities132 = new Cardinalities();
        cardinalities132 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships5.setCardinalities(cardinalities132);
        em.persist(relationships5);
        em.flush();

        Relationships relationships6 = new Relationships();
        relationships6.setIsOptionality(true);
        relationships6.setIsEmbedded(false);
        relationships6.setName("");
//      ...................... Developments ........................
        Entities entities133 = new Entities();
        entities133 = findBean.nameEntities("Developments",em);
        relationships6.setFrom(entities133);
//      ...................... Sites ........................
        Entities entities134 = new Entities();
        entities134 = findBean.nameEntities("Sites",em);
        relationships6.setTo(entities134);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities135 = new Cardinalities();
        cardinalities135 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships6.setCardinalities(cardinalities135);
        em.persist(relationships6);
        em.flush();

        Relationships relationships7 = new Relationships();
        relationships7.setIsOptionality(true);
        relationships7.setIsEmbedded(false);
        relationships7.setName("");
//      ...................... Relationships ........................
        Entities entities136 = new Entities();
        entities136 = findBean.nameEntities("Relationships",em);
        relationships7.setFrom(entities136);
//      ...................... AttributesProperties ........................
        Entities entities137 = new Entities();
        entities137 = findBean.nameEntities("AttributesProperties",em);
        relationships7.setTo(entities137);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities138 = new Cardinalities();
        cardinalities138 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships7.setCardinalities(cardinalities138);
        em.persist(relationships7);
        em.flush();

        Relationships relationships8 = new Relationships();
        relationships8.setIsOptionality(true);
        relationships8.setIsEmbedded(false);
        relationships8.setName("");
//      ...................... GroupIds ........................
        Entities entities139 = new Entities();
        entities139 = findBean.nameEntities("GroupIds",em);
        relationships8.setFrom(entities139);
//      ...................... Entities ........................
        Entities entities140 = new Entities();
        entities140 = findBean.nameEntities("Entities",em);
        relationships8.setTo(entities140);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities141 = new Cardinalities();
        cardinalities141 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships8.setCardinalities(cardinalities141);
        em.persist(relationships8);
        em.flush();

        Relationships relationships9 = new Relationships();
        relationships9.setIsOptionality(true);
        relationships9.setIsEmbedded(false);
        relationships9.setName("");
//      ...................... GroupIds ........................
        Entities entities142 = new Entities();
        entities142 = findBean.nameEntities("GroupIds",em);
        relationships9.setFrom(entities142);
//      ...................... ModelsGroupIds ........................
        Entities entities143 = new Entities();
        entities143 = findBean.nameEntities("ModelsGroupIds",em);
        relationships9.setTo(entities143);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities144 = new Cardinalities();
        cardinalities144 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships9.setCardinalities(cardinalities144);
        em.persist(relationships9);
        em.flush();

        Relationships relationships10 = new Relationships();
        relationships10.setIsOptionality(true);
        relationships10.setIsEmbedded(false);
        relationships10.setName("");
//      ...................... Cardinalities ........................
        Entities entities145 = new Entities();
        entities145 = findBean.nameEntities("Cardinalities",em);
        relationships10.setFrom(entities145);
//      ...................... Imports ........................
        Entities entities146 = new Entities();
        entities146 = findBean.nameEntities("Imports",em);
        relationships10.setTo(entities146);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities147 = new Cardinalities();
        cardinalities147 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships10.setCardinalities(cardinalities147);
        em.persist(relationships10);
        em.flush();

        Relationships relationships11 = new Relationships();
        relationships11.setIsOptionality(true);
        relationships11.setIsEmbedded(false);
        relationships11.setName("");
//      ...................... Cardinalities ........................
        Entities entities148 = new Entities();
        entities148 = findBean.nameEntities("Cardinalities",em);
        relationships11.setFrom(entities148);
//      ...................... Sites ........................
        Entities entities149 = new Entities();
        entities149 = findBean.nameEntities("Sites",em);
        relationships11.setTo(entities149);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities150 = new Cardinalities();
        cardinalities150 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships11.setCardinalities(cardinalities150);
        em.persist(relationships11);
        em.flush();

        Relationships relationships12 = new Relationships();
        relationships12.setIsOptionality(true);
        relationships12.setIsEmbedded(false);
        relationships12.setName("");
//      ...................... Cardinalities ........................
        Entities entities151 = new Entities();
        entities151 = findBean.nameEntities("Cardinalities",em);
        relationships12.setFrom(entities151);
//      ...................... Relationships ........................
        Entities entities152 = new Entities();
        entities152 = findBean.nameEntities("Relationships",em);
        relationships12.setTo(entities152);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities153 = new Cardinalities();
        cardinalities153 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships12.setCardinalities(cardinalities153);
        em.persist(relationships12);
        em.flush();

        Relationships relationships13 = new Relationships();
        relationships13.setIsOptionality(true);
        relationships13.setIsEmbedded(false);
        relationships13.setName("from");
//      ...................... Entities ........................
        Entities entities154 = new Entities();
        entities154 = findBean.nameEntities("Entities",em);
        relationships13.setFrom(entities154);
//      ...................... Relationships ........................
        Entities entities155 = new Entities();
        entities155 = findBean.nameEntities("Relationships",em);
        relationships13.setTo(entities155);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities156 = new Cardinalities();
        cardinalities156 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships13.setCardinalities(cardinalities156);
        em.persist(relationships13);
        em.flush();

        Relationships relationships14 = new Relationships();
        relationships14.setIsOptionality(true);
        relationships14.setIsEmbedded(false);
        relationships14.setName("");
//      ...................... Entities ........................
        Entities entities157 = new Entities();
        entities157 = findBean.nameEntities("Entities",em);
        relationships14.setFrom(entities157);
//      ...................... Sites ........................
        Entities entities158 = new Entities();
        entities158 = findBean.nameEntities("Sites",em);
        relationships14.setTo(entities158);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities159 = new Cardinalities();
        cardinalities159 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships14.setCardinalities(cardinalities159);
        em.persist(relationships14);
        em.flush();

        Relationships relationships15 = new Relationships();
        relationships15.setIsOptionality(true);
        relationships15.setIsEmbedded(false);
        relationships15.setName("");
//      ...................... Entities ........................
        Entities entities160 = new Entities();
        entities160 = findBean.nameEntities("Entities",em);
        relationships15.setFrom(entities160);
//      ...................... NameQueries ........................
        Entities entities161 = new Entities();
        entities161 = findBean.nameEntities("NameQueries",em);
        relationships15.setTo(entities161);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities162 = new Cardinalities();
        cardinalities162 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships15.setCardinalities(cardinalities162);
        em.persist(relationships15);
        em.flush();

        Relationships relationships16 = new Relationships();
        relationships16.setIsOptionality(true);
        relationships16.setIsEmbedded(false);
        relationships16.setName("");
//      ...................... Entities ........................
        Entities entities163 = new Entities();
        entities163 = findBean.nameEntities("Entities",em);
        relationships16.setFrom(entities163);
//      ...................... Imports ........................
        Entities entities164 = new Entities();
        entities164 = findBean.nameEntities("Imports",em);
        relationships16.setTo(entities164);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities165 = new Cardinalities();
        cardinalities165 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships16.setCardinalities(cardinalities165);
        em.persist(relationships16);
        em.flush();

        Relationships relationships17 = new Relationships();
        relationships17.setIsOptionality(true);
        relationships17.setIsEmbedded(false);
        relationships17.setName("");
//      ...................... Entities ........................
        Entities entities166 = new Entities();
        entities166 = findBean.nameEntities("Entities",em);
        relationships17.setFrom(entities166);
//      ...................... AttributesProperties ........................
        Entities entities167 = new Entities();
        entities167 = findBean.nameEntities("AttributesProperties",em);
        relationships17.setTo(entities167);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities168 = new Cardinalities();
        cardinalities168 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships17.setCardinalities(cardinalities168);
        em.persist(relationships17);
        em.flush();

        Relationships relationships18 = new Relationships();
        relationships18.setIsOptionality(true);
        relationships18.setIsEmbedded(false);
        relationships18.setName("");
//      ...................... Entities ........................
        Entities entities169 = new Entities();
        entities169 = findBean.nameEntities("Entities",em);
        relationships18.setFrom(entities169);
//      ...................... Attributes ........................
        Entities entities170 = new Entities();
        entities170 = findBean.nameEntities("Attributes",em);
        relationships18.setTo(entities170);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities171 = new Cardinalities();
        cardinalities171 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships18.setCardinalities(cardinalities171);
        em.persist(relationships18);
        em.flush();

        Relationships relationships19 = new Relationships();
        relationships19.setIsOptionality(true);
        relationships19.setIsEmbedded(false);
        relationships19.setName("to");
//      ...................... Entities ........................
        Entities entities172 = new Entities();
        entities172 = findBean.nameEntities("Entities",em);
        relationships19.setFrom(entities172);
//      ...................... Relationships ........................
        Entities entities173 = new Entities();
        entities173 = findBean.nameEntities("Relationships",em);
        relationships19.setTo(entities173);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities174 = new Cardinalities();
        cardinalities174 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships19.setCardinalities(cardinalities174);
        em.persist(relationships19);
        em.flush();

        Relationships relationships20 = new Relationships();
        relationships20.setIsOptionality(true);
        relationships20.setIsEmbedded(false);
        relationships20.setName("");
//      ...................... Models ........................
        Entities entities175 = new Entities();
        entities175 = findBean.nameEntities("Models",em);
        relationships20.setFrom(entities175);
//      ...................... Sites ........................
        Entities entities176 = new Entities();
        entities176 = findBean.nameEntities("Sites",em);
        relationships20.setTo(entities176);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities177 = new Cardinalities();
        cardinalities177 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships20.setCardinalities(cardinalities177);
        em.persist(relationships20);
        em.flush();

        Relationships relationships21 = new Relationships();
        relationships21.setIsOptionality(true);
        relationships21.setIsEmbedded(false);
        relationships21.setName("");
//      ...................... Models ........................
        Entities entities178 = new Entities();
        entities178 = findBean.nameEntities("Models",em);
        relationships21.setFrom(entities178);
//      ...................... ModelsGroupIds ........................
        Entities entities179 = new Entities();
        entities179 = findBean.nameEntities("ModelsGroupIds",em);
        relationships21.setTo(entities179);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities180 = new Cardinalities();
        cardinalities180 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships21.setCardinalities(cardinalities180);
        em.persist(relationships21);
        em.flush();

        Relationships relationships22 = new Relationships();
        relationships22.setIsOptionality(true);
        relationships22.setIsEmbedded(false);
        relationships22.setName("");
//      ...................... AttributesTypes ........................
        Entities entities181 = new Entities();
        entities181 = findBean.nameEntities("AttributesTypes",em);
        relationships22.setFrom(entities181);
//      ...................... AttributesProperties ........................
        Entities entities182 = new Entities();
        entities182 = findBean.nameEntities("AttributesProperties",em);
        relationships22.setTo(entities182);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities183 = new Cardinalities();
        cardinalities183 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships22.setCardinalities(cardinalities183);
        em.persist(relationships22);
        em.flush();

        Relationships relationships23 = new Relationships();
        relationships23.setIsOptionality(true);
        relationships23.setIsEmbedded(false);
        relationships23.setName("");
//      ...................... AttributesTypes ........................
        Entities entities184 = new Entities();
        entities184 = findBean.nameEntities("AttributesTypes",em);
        relationships23.setFrom(entities184);
//      ...................... Sites ........................
        Entities entities185 = new Entities();
        entities185 = findBean.nameEntities("Sites",em);
        relationships23.setTo(entities185);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities186 = new Cardinalities();
        cardinalities186 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships23.setCardinalities(cardinalities186);
        em.persist(relationships23);
        em.flush();

        Relationships relationships24 = new Relationships();
        relationships24.setIsOptionality(true);
        relationships24.setIsEmbedded(false);
        relationships24.setName("");
//      ...................... AttributesTypes ........................
        Entities entities187 = new Entities();
        entities187 = findBean.nameEntities("AttributesTypes",em);
        relationships24.setFrom(entities187);
//      ...................... Attributes ........................
        Entities entities188 = new Entities();
        entities188 = findBean.nameEntities("Attributes",em);
        relationships24.setTo(entities188);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities189 = new Cardinalities();
        cardinalities189 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships24.setCardinalities(cardinalities189);
        em.persist(relationships24);
        em.flush();

        Relationships relationships25 = new Relationships();
        relationships25.setIsOptionality(true);
        relationships25.setIsEmbedded(false);
        relationships25.setName("");
//      ...................... AttributesProperties ........................
        Entities entities190 = new Entities();
        entities190 = findBean.nameEntities("AttributesProperties",em);
        relationships25.setFrom(entities190);
//      ...................... Imports ........................
        Entities entities191 = new Entities();
        entities191 = findBean.nameEntities("Imports",em);
        relationships25.setTo(entities191);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities192 = new Cardinalities();
        cardinalities192 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships25.setCardinalities(cardinalities192);
        em.persist(relationships25);
        em.flush();

        Relationships relationships26 = new Relationships();
        relationships26.setIsOptionality(true);
        relationships26.setIsEmbedded(false);
        relationships26.setName("");
//      ...................... AttributesProperties ........................
        Entities entities193 = new Entities();
        entities193 = findBean.nameEntities("AttributesProperties",em);
        relationships26.setFrom(entities193);
//      ...................... Sites ........................
        Entities entities194 = new Entities();
        entities194 = findBean.nameEntities("Sites",em);
        relationships26.setTo(entities194);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities195 = new Cardinalities();
        cardinalities195 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships26.setCardinalities(cardinalities195);
        em.persist(relationships26);
        em.flush();

        Relationships relationships27 = new Relationships();
        relationships27.setIsOptionality(true);
        relationships27.setIsEmbedded(false);
        relationships27.setName("");
//      ...................... Imports ........................
        Entities entities196 = new Entities();
        entities196 = findBean.nameEntities("Imports",em);
        relationships27.setFrom(entities196);
//      ...................... Sites ........................
        Entities entities197 = new Entities();
        entities197 = findBean.nameEntities("Sites",em);
        relationships27.setTo(entities197);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities198 = new Cardinalities();
        cardinalities198 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships27.setCardinalities(cardinalities198);
        em.persist(relationships27);
        em.flush();

        Relationships relationships28 = new Relationships();
        relationships28.setIsOptionality(true);
        relationships28.setIsEmbedded(false);
        relationships28.setName("");
//      ...................... Dependencies ........................
        Entities entities199 = new Entities();
        entities199 = findBean.nameEntities("Dependencies",em);
        relationships28.setFrom(entities199);
//      ...................... Sites ........................
        Entities entities200 = new Entities();
        entities200 = findBean.nameEntities("Sites",em);
        relationships28.setTo(entities200);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities201 = new Cardinalities();
        cardinalities201 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships28.setCardinalities(cardinalities201);
        em.persist(relationships28);
        em.flush();

        Relationships relationships29 = new Relationships();
        relationships29.setIsOptionality(true);
        relationships29.setIsEmbedded(false);
        relationships29.setName("");
//      ...................... Dependencies ........................
        Entities entities202 = new Entities();
        entities202 = findBean.nameEntities("Dependencies",em);
        relationships29.setFrom(entities202);
//      ...................... Imports ........................
        Entities entities203 = new Entities();
        entities203 = findBean.nameEntities("Imports",em);
        relationships29.setTo(entities203);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities204 = new Cardinalities();
        cardinalities204 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships29.setCardinalities(cardinalities204);
        em.persist(relationships29);
        em.flush();

    } // data()

} // naifgSetup
