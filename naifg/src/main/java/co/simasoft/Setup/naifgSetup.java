package co.simasoft.setup;

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
        groupIds1.setArtifactId("dependencies");
        groupIds1.setGroupId("co.simasoft.models.dev.naifg.dependencies");
        groupIds1.setVersion("null");
        groupIds1.setCode("null");
        em.persist(groupIds1);
        em.flush();

        GroupIds groupIds2 = new GroupIds();
        groupIds2.setArtifactId("naifg");
        groupIds2.setGroupId("co.simasoft.models.dev.naifg");
        groupIds2.setVersion("null");
        groupIds2.setCode("null");
        em.persist(groupIds2);
        em.flush();

        GroupIds groupIds3 = new GroupIds();
        groupIds3.setArtifactId("sites");
        groupIds3.setGroupId("co.simasoft.models.dev.naifg.sites");
        groupIds3.setVersion("null");
        groupIds3.setCode("null");
        em.persist(groupIds3);
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
        GroupIds groupIdd1 = findBean.artifactIdGroupIds("dependencies",em);
        modelsGroupIds1.setModels(modelss1);
        modelsGroupIds1.setGroupIds(groupIdd1);
        modelsGroupIds1.setGroupId("co.simasoft.models.dev.naifg.dependencies");
        modelsGroupIds1.setIsSingle(false);
        modelsGroupIds1.setIsSimplified(false);
        em.persist(modelsGroupIds1);
        em.flush();

        ModelsGroupIds modelsGroupIds2 = new ModelsGroupIds();
        Models modelss2 = findBean.artifactIdModels("naifg",em);
        GroupIds groupIdd2 = findBean.artifactIdGroupIds("naifg",em);
        modelsGroupIds2.setModels(modelss2);
        modelsGroupIds2.setGroupIds(groupIdd2);
        modelsGroupIds2.setGroupId("co.simasoft.models.dev.naifg");
        modelsGroupIds2.setIsSingle(false);
        modelsGroupIds2.setIsSimplified(false);
        em.persist(modelsGroupIds2);
        em.flush();

        ModelsGroupIds modelsGroupIds3 = new ModelsGroupIds();
        Models modelss3 = findBean.artifactIdModels("naifg",em);
        GroupIds groupIdd3 = findBean.artifactIdGroupIds("sites",em);
        modelsGroupIds3.setModels(modelss3);
        modelsGroupIds3.setGroupIds(groupIdd3);
        modelsGroupIds3.setGroupId("co.simasoft.models.dev.naifg.sites");
        modelsGroupIds3.setIsSingle(false);
        modelsGroupIds3.setIsSimplified(false);
        em.persist(modelsGroupIds3);
        em.flush();

//      ---------------------- Developments ------------------------

        Developments dev = new Developments();
        dev.setGroupId("co.simasoft");
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
        entities1.setName("AttributesTypes");
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId1 = new GroupIds();
        groupId1 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities1.setGroupIds(groupId1);
        em.persist(entities1);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes2 = new Attributes();
        attributes2.setName("annotations");
        attributes2.setIsNullable(true);
        attributes2.setIsUnique(false);
//      ...................... AttributesTypes ........................
        Entities entity2 = new Entities();
        entity2 = findBean.nameEntities("AttributesTypes",em);
        attributes2.setEntities(entity2);
//      ...................... String ........................
        AttributesTypes attributesTypes3 = new AttributesTypes();
        attributesTypes3 = findBean.nameAttributesTypes("String",em);
        attributes2.setAttributesTypes(attributesTypes3);
        em.persist(attributes2);
        em.flush();

        Attributes attributes3 = new Attributes();
        attributes3.setName("name");
        attributes3.setIsNullable(false);
        attributes3.setIsUnique(true);
//      ...................... AttributesTypes ........................
        Entities entity4 = new Entities();
        entity4 = findBean.nameEntities("AttributesTypes",em);
        attributes3.setEntities(entity4);
//      ...................... String ........................
        AttributesTypes attributesTypes5 = new AttributesTypes();
        attributesTypes5 = findBean.nameAttributesTypes("String",em);
        attributes3.setAttributesTypes(attributesTypes5);
        em.persist(attributes3);
        em.flush();

        Attributes attributes4 = new Attributes();
        attributes4.setName("type");
        attributes4.setIsNullable(false);
        attributes4.setIsUnique(false);
//      ...................... AttributesTypes ........................
        Entities entity6 = new Entities();
        entity6 = findBean.nameEntities("AttributesTypes",em);
        attributes4.setEntities(entity6);
//      ...................... String ........................
        AttributesTypes attributesTypes7 = new AttributesTypes();
        attributesTypes7 = findBean.nameAttributesTypes("String",em);
        attributes4.setAttributesTypes(attributesTypes7);
        em.persist(attributes4);
        em.flush();

        Attributes attributes5 = new Attributes();
        attributes5.setName("length");
        attributes5.setIsNullable(true);
        attributes5.setIsUnique(false);
//      ...................... AttributesTypes ........................
        Entities entity8 = new Entities();
        entity8 = findBean.nameEntities("AttributesTypes",em);
        attributes5.setEntities(entity8);
//      ...................... Integer ........................
        AttributesTypes attributesTypes9 = new AttributesTypes();
        attributesTypes9 = findBean.nameAttributesTypes("Integer",em);
        attributes5.setAttributesTypes(attributesTypes9);
        em.persist(attributes5);
        em.flush();

        Attributes attributes6 = new Attributes();
        attributes6.setName("precision");
        attributes6.setIsNullable(true);
        attributes6.setIsUnique(false);
//      ...................... AttributesTypes ........................
        Entities entity10 = new Entities();
        entity10 = findBean.nameEntities("AttributesTypes",em);
        attributes6.setEntities(entity10);
//      ...................... Integer ........................
        AttributesTypes attributesTypes11 = new AttributesTypes();
        attributesTypes11 = findBean.nameAttributesTypes("Integer",em);
        attributes6.setAttributesTypes(attributesTypes11);
        em.persist(attributes6);
        em.flush();

        Entities entities7 = new Entities();
        entities7.setName("AttributesProperties");
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId12 = new GroupIds();
        groupId12 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities7.setGroupIds(groupId12);
        em.persist(entities7);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes8 = new Attributes();
        attributes8.setName("name");
        attributes8.setIsNullable(false);
        attributes8.setIsUnique(true);
//      ...................... AttributesProperties ........................
        Entities entity13 = new Entities();
        entity13 = findBean.nameEntities("AttributesProperties",em);
        attributes8.setEntities(entity13);
//      ...................... String ........................
        AttributesTypes attributesTypes14 = new AttributesTypes();
        attributesTypes14 = findBean.nameAttributesTypes("String",em);
        attributes8.setAttributesTypes(attributesTypes14);
        em.persist(attributes8);
        em.flush();

        Attributes attributes9 = new Attributes();
        attributes9.setName("value");
        attributes9.setIsNullable(false);
        attributes9.setIsUnique(true);
//      ...................... AttributesProperties ........................
        Entities entity15 = new Entities();
        entity15 = findBean.nameEntities("AttributesProperties",em);
        attributes9.setEntities(entity15);
//      ...................... String ........................
        AttributesTypes attributesTypes16 = new AttributesTypes();
        attributesTypes16 = findBean.nameAttributesTypes("String",em);
        attributes9.setAttributesTypes(attributesTypes16);
        em.persist(attributes9);
        em.flush();

        Entities entities10 = new Entities();
        entities10.setName("Imports");
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId17 = new GroupIds();
        groupId17 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities10.setGroupIds(groupId17);
        em.persist(entities10);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes11 = new Attributes();
        attributes11.setName("name");
        attributes11.setIsNullable(false);
        attributes11.setIsUnique(true);
//      ...................... Imports ........................
        Entities entity18 = new Entities();
        entity18 = findBean.nameEntities("Imports",em);
        attributes11.setEntities(entity18);
//      ...................... String ........................
        AttributesTypes attributesTypes19 = new AttributesTypes();
        attributesTypes19 = findBean.nameAttributesTypes("String",em);
        attributes11.setAttributesTypes(attributesTypes19);
        em.persist(attributes11);
        em.flush();

        Entities entities12 = new Entities();
        entities12.setName("Dependencies");
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId20 = new GroupIds();
        groupId20 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities12.setGroupIds(groupId20);
        em.persist(entities12);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes13 = new Attributes();
        attributes13.setName("groupId");
        attributes13.setIsNullable(false);
        attributes13.setIsUnique(false);
//      ...................... Dependencies ........................
        Entities entity21 = new Entities();
        entity21 = findBean.nameEntities("Dependencies",em);
        attributes13.setEntities(entity21);
//      ...................... String ........................
        AttributesTypes attributesTypes22 = new AttributesTypes();
        attributesTypes22 = findBean.nameAttributesTypes("String",em);
        attributes13.setAttributesTypes(attributesTypes22);
        em.persist(attributes13);
        em.flush();

        Attributes attributes14 = new Attributes();
        attributes14.setName("scope");
        attributes14.setIsNullable(true);
        attributes14.setIsUnique(false);
//      ...................... Dependencies ........................
        Entities entity23 = new Entities();
        entity23 = findBean.nameEntities("Dependencies",em);
        attributes14.setEntities(entity23);
//      ...................... String ........................
        AttributesTypes attributesTypes24 = new AttributesTypes();
        attributesTypes24 = findBean.nameAttributesTypes("String",em);
        attributes14.setAttributesTypes(attributesTypes24);
        em.persist(attributes14);
        em.flush();

        Attributes attributes15 = new Attributes();
        attributes15.setName("maven");
        attributes15.setIsNullable(false);
        attributes15.setIsUnique(true);
//      ...................... Dependencies ........................
        Entities entity25 = new Entities();
        entity25 = findBean.nameEntities("Dependencies",em);
        attributes15.setEntities(entity25);
//      ...................... String ........................
        AttributesTypes attributesTypes26 = new AttributesTypes();
        attributesTypes26 = findBean.nameAttributesTypes("String",em);
        attributes15.setAttributesTypes(attributesTypes26);
        em.persist(attributes15);
        em.flush();

        Attributes attributes16 = new Attributes();
        attributes16.setName("version");
        attributes16.setIsNullable(true);
        attributes16.setIsUnique(false);
//      ...................... Dependencies ........................
        Entities entity27 = new Entities();
        entity27 = findBean.nameEntities("Dependencies",em);
        attributes16.setEntities(entity27);
//      ...................... String ........................
        AttributesTypes attributesTypes28 = new AttributesTypes();
        attributesTypes28 = findBean.nameAttributesTypes("String",em);
        attributes16.setAttributesTypes(attributesTypes28);
        em.persist(attributes16);
        em.flush();

        Attributes attributes17 = new Attributes();
        attributes17.setName("artifactId");
        attributes17.setIsNullable(false);
        attributes17.setIsUnique(false);
//      ...................... Dependencies ........................
        Entities entity29 = new Entities();
        entity29 = findBean.nameEntities("Dependencies",em);
        attributes17.setEntities(entity29);
//      ...................... String ........................
        AttributesTypes attributesTypes30 = new AttributesTypes();
        attributesTypes30 = findBean.nameAttributesTypes("String",em);
        attributes17.setAttributesTypes(attributesTypes30);
        em.persist(attributes17);
        em.flush();

        Attributes attributes18 = new Attributes();
        attributes18.setName("type");
        attributes18.setIsNullable(true);
        attributes18.setIsUnique(false);
//      ...................... Dependencies ........................
        Entities entity31 = new Entities();
        entity31 = findBean.nameEntities("Dependencies",em);
        attributes18.setEntities(entity31);
//      ...................... String ........................
        AttributesTypes attributesTypes32 = new AttributesTypes();
        attributesTypes32 = findBean.nameAttributesTypes("String",em);
        attributes18.setAttributesTypes(attributesTypes32);
        em.persist(attributes18);
        em.flush();

        Entities entities19 = new Entities();
        entities19.setName("Models");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId33 = new GroupIds();
        groupId33 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities19.setGroupIds(groupId33);
        em.persist(entities19);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes20 = new Attributes();
        attributes20.setName("code");
        attributes20.setIsNullable(true);
        attributes20.setIsUnique(false);
//      ...................... Models ........................
        Entities entity34 = new Entities();
        entity34 = findBean.nameEntities("Models",em);
        attributes20.setEntities(entity34);
//      ...................... String ........................
        AttributesTypes attributesTypes35 = new AttributesTypes();
        attributesTypes35 = findBean.nameAttributesTypes("String",em);
        attributes20.setAttributesTypes(attributesTypes35);
        em.persist(attributes20);
        em.flush();

        Attributes attributes21 = new Attributes();
        attributes21.setName("groupId");
        attributes21.setIsNullable(false);
        attributes21.setIsUnique(true);
//      ...................... Models ........................
        Entities entity36 = new Entities();
        entity36 = findBean.nameEntities("Models",em);
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
//      ...................... Models ........................
        Entities entity38 = new Entities();
        entity38 = findBean.nameEntities("Models",em);
        attributes22.setEntities(entity38);
//      ...................... Date ........................
        AttributesTypes attributesTypes39 = new AttributesTypes();
        attributesTypes39 = findBean.nameAttributesTypes("Date",em);
        attributes22.setAttributesTypes(attributesTypes39);
        em.persist(attributes22);
        em.flush();

        Attributes attributes23 = new Attributes();
        attributes23.setName("artifactId");
        attributes23.setIsNullable(false);
        attributes23.setIsUnique(true);
//      ...................... Models ........................
        Entities entity40 = new Entities();
        entity40 = findBean.nameEntities("Models",em);
        attributes23.setEntities(entity40);
//      ...................... String ........................
        AttributesTypes attributesTypes41 = new AttributesTypes();
        attributesTypes41 = findBean.nameAttributesTypes("String",em);
        attributes23.setAttributesTypes(attributesTypes41);
        em.persist(attributes23);
        em.flush();

        Attributes attributes24 = new Attributes();
        attributes24.setName("version");
        attributes24.setIsNullable(true);
        attributes24.setIsUnique(false);
//      ...................... Models ........................
        Entities entity42 = new Entities();
        entity42 = findBean.nameEntities("Models",em);
        attributes24.setEntities(entity42);
//      ...................... String ........................
        AttributesTypes attributesTypes43 = new AttributesTypes();
        attributesTypes43 = findBean.nameAttributesTypes("String",em);
        attributes24.setAttributesTypes(attributesTypes43);
        em.persist(attributes24);
        em.flush();

        Entities entities25 = new Entities();
        entities25.setName("GroupIds");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId44 = new GroupIds();
        groupId44 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities25.setGroupIds(groupId44);
        em.persist(entities25);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes26 = new Attributes();
        attributes26.setName("code");
        attributes26.setIsNullable(true);
        attributes26.setIsUnique(false);
//      ...................... GroupIds ........................
        Entities entity45 = new Entities();
        entity45 = findBean.nameEntities("GroupIds",em);
        attributes26.setEntities(entity45);
//      ...................... String ........................
        AttributesTypes attributesTypes46 = new AttributesTypes();
        attributesTypes46 = findBean.nameAttributesTypes("String",em);
        attributes26.setAttributesTypes(attributesTypes46);
        em.persist(attributes26);
        em.flush();

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
        attributes28.setName("date");
        attributes28.setIsNullable(true);
        attributes28.setIsUnique(false);
//      ...................... GroupIds ........................
        Entities entity49 = new Entities();
        entity49 = findBean.nameEntities("GroupIds",em);
        attributes28.setEntities(entity49);
//      ...................... Date ........................
        AttributesTypes attributesTypes50 = new AttributesTypes();
        attributesTypes50 = findBean.nameAttributesTypes("Date",em);
        attributes28.setAttributesTypes(attributesTypes50);
        em.persist(attributes28);
        em.flush();

        Attributes attributes29 = new Attributes();
        attributes29.setName("groupId");
        attributes29.setIsNullable(false);
        attributes29.setIsUnique(true);
//      ...................... GroupIds ........................
        Entities entity51 = new Entities();
        entity51 = findBean.nameEntities("GroupIds",em);
        attributes29.setEntities(entity51);
//      ...................... String ........................
        AttributesTypes attributesTypes52 = new AttributesTypes();
        attributesTypes52 = findBean.nameAttributesTypes("String",em);
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

        Entities entities31 = new Entities();
        entities31.setName("Entities");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId55 = new GroupIds();
        groupId55 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities31.setGroupIds(groupId55);
        em.persist(entities31);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes32 = new Attributes();
        attributes32.setName("name");
        attributes32.setIsNullable(false);
        attributes32.setIsUnique(true);
//      ...................... Entities ........................
        Entities entity56 = new Entities();
        entity56 = findBean.nameEntities("Entities",em);
        attributes32.setEntities(entity56);
//      ...................... String ........................
        AttributesTypes attributesTypes57 = new AttributesTypes();
        attributesTypes57 = findBean.nameAttributesTypes("String",em);
        attributes32.setAttributesTypes(attributesTypes57);
        em.persist(attributes32);
        em.flush();

        Attributes attributes33 = new Attributes();
        attributes33.setName("serialID");
        attributes33.setIsNullable(true);
        attributes33.setIsUnique(false);
//      ...................... Entities ........................
        Entities entity58 = new Entities();
        entity58 = findBean.nameEntities("Entities",em);
        attributes33.setEntities(entity58);
//      ...................... String ........................
        AttributesTypes attributesTypes59 = new AttributesTypes();
        attributesTypes59 = findBean.nameAttributesTypes("String",em);
        attributes33.setAttributesTypes(attributesTypes59);
        em.persist(attributes33);
        em.flush();

        Attributes attributes34 = new Attributes();
        attributes34.setName("isSimplified");
        attributes34.setIsNullable(true);
        attributes34.setIsUnique(false);
//      ...................... Entities ........................
        Entities entity60 = new Entities();
        entity60 = findBean.nameEntities("Entities",em);
        attributes34.setEntities(entity60);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes61 = new AttributesTypes();
        attributesTypes61 = findBean.nameAttributesTypes("Boolean",em);
        attributes34.setAttributesTypes(attributesTypes61);
        em.persist(attributes34);
        em.flush();

        Attributes attributes35 = new Attributes();
        attributes35.setName("description");
        attributes35.setIsNullable(true);
        attributes35.setIsUnique(false);
//      ...................... Entities ........................
        Entities entity62 = new Entities();
        entity62 = findBean.nameEntities("Entities",em);
        attributes35.setEntities(entity62);
//      ...................... String ........................
        AttributesTypes attributesTypes63 = new AttributesTypes();
        attributesTypes63 = findBean.nameAttributesTypes("String",em);
        attributes35.setAttributesTypes(attributesTypes63);
        em.persist(attributes35);
        em.flush();

        Attributes attributes36 = new Attributes();
        attributes36.setName("table");
        attributes36.setIsNullable(true);
        attributes36.setIsUnique(false);
//      ...................... Entities ........................
        Entities entity64 = new Entities();
        entity64 = findBean.nameEntities("Entities",em);
        attributes36.setEntities(entity64);
//      ...................... String ........................
        AttributesTypes attributesTypes65 = new AttributesTypes();
        attributesTypes65 = findBean.nameAttributesTypes("String",em);
        attributes36.setAttributesTypes(attributesTypes65);
        em.persist(attributes36);
        em.flush();

        Entities entities37 = new Entities();
        entities37.setName("Attributes");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId66 = new GroupIds();
        groupId66 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities37.setGroupIds(groupId66);
        em.persist(entities37);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes38 = new Attributes();
        attributes38.setName("description");
        attributes38.setIsNullable(true);
        attributes38.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity67 = new Entities();
        entity67 = findBean.nameEntities("Attributes",em);
        attributes38.setEntities(entity67);
//      ...................... String ........................
        AttributesTypes attributesTypes68 = new AttributesTypes();
        attributesTypes68 = findBean.nameAttributesTypes("String",em);
        attributes38.setAttributesTypes(attributesTypes68);
        em.persist(attributes38);
        em.flush();

        Attributes attributes39 = new Attributes();
        attributes39.setName("precision");
        attributes39.setIsNullable(true);
        attributes39.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity69 = new Entities();
        entity69 = findBean.nameEntities("Attributes",em);
        attributes39.setEntities(entity69);
//      ...................... Integer ........................
        AttributesTypes attributesTypes70 = new AttributesTypes();
        attributesTypes70 = findBean.nameAttributesTypes("Integer",em);
        attributes39.setAttributesTypes(attributesTypes70);
        em.persist(attributes39);
        em.flush();

        Attributes attributes40 = new Attributes();
        attributes40.setName("isUnique");
        attributes40.setIsNullable(true);
        attributes40.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity71 = new Entities();
        entity71 = findBean.nameEntities("Attributes",em);
        attributes40.setEntities(entity71);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes72 = new AttributesTypes();
        attributesTypes72 = findBean.nameAttributesTypes("Boolean",em);
        attributes40.setAttributesTypes(attributesTypes72);
        em.persist(attributes40);
        em.flush();

        Attributes attributes41 = new Attributes();
        attributes41.setName("isNullable");
        attributes41.setIsNullable(true);
        attributes41.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity73 = new Entities();
        entity73 = findBean.nameEntities("Attributes",em);
        attributes41.setEntities(entity73);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes74 = new AttributesTypes();
        attributesTypes74 = findBean.nameAttributesTypes("Boolean",em);
        attributes41.setAttributesTypes(attributesTypes74);
        em.persist(attributes41);
        em.flush();

        Attributes attributes42 = new Attributes();
        attributes42.setName("name");
        attributes42.setIsNullable(false);
        attributes42.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity75 = new Entities();
        entity75 = findBean.nameEntities("Attributes",em);
        attributes42.setEntities(entity75);
//      ...................... String ........................
        AttributesTypes attributesTypes76 = new AttributesTypes();
        attributesTypes76 = findBean.nameAttributesTypes("String",em);
        attributes42.setAttributesTypes(attributesTypes76);
        em.persist(attributes42);
        em.flush();

        Attributes attributes43 = new Attributes();
        attributes43.setName("length");
        attributes43.setIsNullable(true);
        attributes43.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity77 = new Entities();
        entity77 = findBean.nameEntities("Attributes",em);
        attributes43.setEntities(entity77);
//      ...................... Integer ........................
        AttributesTypes attributesTypes78 = new AttributesTypes();
        attributesTypes78 = findBean.nameAttributesTypes("Integer",em);
        attributes43.setAttributesTypes(attributesTypes78);
        em.persist(attributes43);
        em.flush();

        Attributes attributes44 = new Attributes();
        attributes44.setName("isSimplified");
        attributes44.setIsNullable(true);
        attributes44.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity79 = new Entities();
        entity79 = findBean.nameEntities("Attributes",em);
        attributes44.setEntities(entity79);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes80 = new AttributesTypes();
        attributesTypes80 = findBean.nameAttributesTypes("Boolean",em);
        attributes44.setAttributesTypes(attributesTypes80);
        em.persist(attributes44);
        em.flush();

        Entities entities45 = new Entities();
        entities45.setName("Developments");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId81 = new GroupIds();
        groupId81 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities45.setGroupIds(groupId81);
        em.persist(entities45);
        em.flush();

//      ---------------------- Attributes ------------------------

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
        attributes47.setName("groupId");
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
        attributes48.setName("version");
        attributes48.setIsNullable(true);
        attributes48.setIsUnique(false);
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

        Attributes attributes49 = new Attributes();
        attributes49.setName("artifactId");
        attributes49.setIsNullable(false);
        attributes49.setIsUnique(true);
//      ...................... Developments ........................
        Entities entity88 = new Entities();
        entity88 = findBean.nameEntities("Developments",em);
        attributes49.setEntities(entity88);
//      ...................... String ........................
        AttributesTypes attributesTypes89 = new AttributesTypes();
        attributesTypes89 = findBean.nameAttributesTypes("String",em);
        attributes49.setAttributesTypes(attributesTypes89);
        em.persist(attributes49);
        em.flush();

        Attributes attributes50 = new Attributes();
        attributes50.setName("code");
        attributes50.setIsNullable(true);
        attributes50.setIsUnique(false);
//      ...................... Developments ........................
        Entities entity90 = new Entities();
        entity90 = findBean.nameEntities("Developments",em);
        attributes50.setEntities(entity90);
//      ...................... String ........................
        AttributesTypes attributesTypes91 = new AttributesTypes();
        attributesTypes91 = findBean.nameAttributesTypes("String",em);
        attributes50.setAttributesTypes(attributesTypes91);
        em.persist(attributes50);
        em.flush();

        Entities entities51 = new Entities();
        entities51.setName("ModelsGroupIds");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId92 = new GroupIds();
        groupId92 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities51.setGroupIds(groupId92);
        em.persist(entities51);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes52 = new Attributes();
        attributes52.setName("groupId");
        attributes52.setIsNullable(true);
        attributes52.setIsUnique(false);
//      ...................... ModelsGroupIds ........................
        Entities entity93 = new Entities();
        entity93 = findBean.nameEntities("ModelsGroupIds",em);
        attributes52.setEntities(entity93);
//      ...................... String ........................
        AttributesTypes attributesTypes94 = new AttributesTypes();
        attributesTypes94 = findBean.nameAttributesTypes("String",em);
        attributes52.setAttributesTypes(attributesTypes94);
        em.persist(attributes52);
        em.flush();

        Attributes attributes53 = new Attributes();
        attributes53.setName("isSimplified");
        attributes53.setIsNullable(true);
        attributes53.setIsUnique(false);
//      ...................... ModelsGroupIds ........................
        Entities entity95 = new Entities();
        entity95 = findBean.nameEntities("ModelsGroupIds",em);
        attributes53.setEntities(entity95);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes96 = new AttributesTypes();
        attributesTypes96 = findBean.nameAttributesTypes("Boolean",em);
        attributes53.setAttributesTypes(attributesTypes96);
        em.persist(attributes53);
        em.flush();

        Attributes attributes54 = new Attributes();
        attributes54.setName("isSingle");
        attributes54.setIsNullable(true);
        attributes54.setIsUnique(false);
//      ...................... ModelsGroupIds ........................
        Entities entity97 = new Entities();
        entity97 = findBean.nameEntities("ModelsGroupIds",em);
        attributes54.setEntities(entity97);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes98 = new AttributesTypes();
        attributesTypes98 = findBean.nameAttributesTypes("Boolean",em);
        attributes54.setAttributesTypes(attributesTypes98);
        em.persist(attributes54);
        em.flush();

        Entities entities55 = new Entities();
        entities55.setName("Relationships");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId99 = new GroupIds();
        groupId99 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities55.setGroupIds(groupId99);
        em.persist(entities55);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes56 = new Attributes();
        attributes56.setName("name");
        attributes56.setIsNullable(true);
        attributes56.setIsUnique(false);
//      ...................... Relationships ........................
        Entities entity100 = new Entities();
        entity100 = findBean.nameEntities("Relationships",em);
        attributes56.setEntities(entity100);
//      ...................... String ........................
        AttributesTypes attributesTypes101 = new AttributesTypes();
        attributesTypes101 = findBean.nameAttributesTypes("String",em);
        attributes56.setAttributesTypes(attributesTypes101);
        em.persist(attributes56);
        em.flush();

        Attributes attributes57 = new Attributes();
        attributes57.setName("isSimplified");
        attributes57.setIsNullable(true);
        attributes57.setIsUnique(false);
//      ...................... Relationships ........................
        Entities entity102 = new Entities();
        entity102 = findBean.nameEntities("Relationships",em);
        attributes57.setEntities(entity102);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes103 = new AttributesTypes();
        attributesTypes103 = findBean.nameAttributesTypes("Boolean",em);
        attributes57.setAttributesTypes(attributesTypes103);
        em.persist(attributes57);
        em.flush();

        Attributes attributes58 = new Attributes();
        attributes58.setName("isOptionality");
        attributes58.setIsNullable(true);
        attributes58.setIsUnique(false);
//      ...................... Relationships ........................
        Entities entity104 = new Entities();
        entity104 = findBean.nameEntities("Relationships",em);
        attributes58.setEntities(entity104);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes105 = new AttributesTypes();
        attributesTypes105 = findBean.nameAttributesTypes("Boolean",em);
        attributes58.setAttributesTypes(attributesTypes105);
        em.persist(attributes58);
        em.flush();

        Attributes attributes59 = new Attributes();
        attributes59.setName("isEmbedded");
        attributes59.setIsNullable(true);
        attributes59.setIsUnique(false);
//      ...................... Relationships ........................
        Entities entity106 = new Entities();
        entity106 = findBean.nameEntities("Relationships",em);
        attributes59.setEntities(entity106);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes107 = new AttributesTypes();
        attributesTypes107 = findBean.nameAttributesTypes("Boolean",em);
        attributes59.setAttributesTypes(attributesTypes107);
        em.persist(attributes59);
        em.flush();

        Entities entities60 = new Entities();
        entities60.setName("NameQueries");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId108 = new GroupIds();
        groupId108 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities60.setGroupIds(groupId108);
        em.persist(entities60);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes61 = new Attributes();
        attributes61.setName("name");
        attributes61.setIsNullable(false);
        attributes61.setIsUnique(true);
//      ...................... NameQueries ........................
        Entities entity109 = new Entities();
        entity109 = findBean.nameEntities("NameQueries",em);
        attributes61.setEntities(entity109);
//      ...................... String ........................
        AttributesTypes attributesTypes110 = new AttributesTypes();
        attributesTypes110 = findBean.nameAttributesTypes("String",em);
        attributes61.setAttributesTypes(attributesTypes110);
        em.persist(attributes61);
        em.flush();

        Attributes attributes62 = new Attributes();
        attributes62.setName("query");
        attributes62.setIsNullable(false);
        attributes62.setIsUnique(true);
//      ...................... NameQueries ........................
        Entities entity111 = new Entities();
        entity111 = findBean.nameEntities("NameQueries",em);
        attributes62.setEntities(entity111);
//      ...................... String ........................
        AttributesTypes attributesTypes112 = new AttributesTypes();
        attributesTypes112 = findBean.nameAttributesTypes("String",em);
        attributes62.setAttributesTypes(attributesTypes112);
        em.persist(attributes62);
        em.flush();

        Entities entities63 = new Entities();
        entities63.setName("Cardinalities");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId113 = new GroupIds();
        groupId113 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities63.setGroupIds(groupId113);
        em.persist(entities63);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes64 = new Attributes();
        attributes64.setName("isUnidirectional");
        attributes64.setIsNullable(true);
        attributes64.setIsUnique(false);
//      ...................... Cardinalities ........................
        Entities entity114 = new Entities();
        entity114 = findBean.nameEntities("Cardinalities",em);
        attributes64.setEntities(entity114);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes115 = new AttributesTypes();
        attributesTypes115 = findBean.nameAttributesTypes("Boolean",em);
        attributes64.setAttributesTypes(attributesTypes115);
        em.persist(attributes64);
        em.flush();

        Attributes attributes65 = new Attributes();
        attributes65.setName("cardinality");
        attributes65.setIsNullable(false);
        attributes65.setIsUnique(false);
//      ...................... Cardinalities ........................
        Entities entity116 = new Entities();
        entity116 = findBean.nameEntities("Cardinalities",em);
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
//      ...................... Cardinalities ........................
        Entities entity118 = new Entities();
        entity118 = findBean.nameEntities("Cardinalities",em);
        attributes66.setEntities(entity118);
//      ...................... String ........................
        AttributesTypes attributesTypes119 = new AttributesTypes();
        attributesTypes119 = findBean.nameAttributesTypes("String",em);
        attributes66.setAttributesTypes(attributesTypes119);
        em.persist(attributes66);
        em.flush();

        Entities entities67 = new Entities();
        entities67.setName("SitesTypes");
//      ...................... co.simasoft.models.dev.naifg.sites ........................
        GroupIds groupId120 = new GroupIds();
        groupId120 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.sites",em);
        entities67.setGroupIds(groupId120);
        em.persist(entities67);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes68 = new Attributes();
        attributes68.setName("name");
        attributes68.setIsNullable(true);
        attributes68.setIsUnique(false);
//      ...................... SitesTypes ........................
        Entities entity121 = new Entities();
        entity121 = findBean.nameEntities("SitesTypes",em);
        attributes68.setEntities(entity121);
//      ...................... String ........................
        AttributesTypes attributesTypes122 = new AttributesTypes();
        attributesTypes122 = findBean.nameAttributesTypes("String",em);
        attributes68.setAttributesTypes(attributesTypes122);
        em.persist(attributes68);
        em.flush();

        Entities entities69 = new Entities();
        entities69.setName("Sites");
//      ...................... co.simasoft.models.dev.naifg.sites ........................
        GroupIds groupId123 = new GroupIds();
        groupId123 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.sites",em);
        entities69.setGroupIds(groupId123);
        em.persist(entities69);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes70 = new Attributes();
        attributes70.setName("title");
        attributes70.setIsNullable(true);
        attributes70.setIsUnique(false);
//      ...................... Sites ........................
        Entities entity124 = new Entities();
        entity124 = findBean.nameEntities("Sites",em);
        attributes70.setEntities(entity124);
//      ...................... String ........................
        AttributesTypes attributesTypes125 = new AttributesTypes();
        attributesTypes125 = findBean.nameAttributesTypes("String",em);
        attributes70.setAttributesTypes(attributesTypes125);
        em.persist(attributes70);
        em.flush();

        Attributes attributes71 = new Attributes();
        attributes71.setName("abc");
        attributes71.setIsNullable(true);
        attributes71.setIsUnique(false);
//      ...................... Sites ........................
        Entities entity126 = new Entities();
        entity126 = findBean.nameEntities("Sites",em);
        attributes71.setEntities(entity126);
//      ...................... String ........................
        AttributesTypes attributesTypes127 = new AttributesTypes();
        attributesTypes127 = findBean.nameAttributesTypes("String",em);
        attributes71.setAttributesTypes(attributesTypes127);
        em.persist(attributes71);
        em.flush();

        Attributes attributes72 = new Attributes();
        attributes72.setName("link");
        attributes72.setIsNullable(false);
        attributes72.setIsUnique(true);
//      ...................... Sites ........................
        Entities entity128 = new Entities();
        entity128 = findBean.nameEntities("Sites",em);
        attributes72.setEntities(entity128);
//      ...................... String ........................
        AttributesTypes attributesTypes129 = new AttributesTypes();
        attributesTypes129 = findBean.nameAttributesTypes("String",em);
        attributes72.setAttributesTypes(attributesTypes129);
        em.persist(attributes72);
        em.flush();

//      ---------------------- Relationships ------------------------

/*
. AttributesTypes . *..* Sites
. AttributesTypes . *..* AttributesProperties
. AttributesTypes . 1..* Attributes
. AttributesProperties . *..* Imports
. AttributesProperties . *..* Sites
. Imports . *..* Sites
. Dependencies . 1..* Imports
. Dependencies . *..* Sites
. Models . *..* Sites
. Models . 1..* ModelsGroupIds
. GroupIds . 1..* Entities
. GroupIds . 1..* ModelsGroupIds
. Entities . *..* Imports
. Entities . *..* Sites
. Entities . 1..* Relationships
. Entities . 1..* Relationships
. Entities . 1..* Attributes
. Entities . *..* AttributesProperties
. Entities . 1..* NameQueries
. Attributes . *..* Sites
. Attributes . *..* AttributesProperties
. Developments . *..* Sites
. Developments . *..* Models
. Relationships . *..* AttributesProperties
. Cardinalities . *..* Sites
. Cardinalities . 1..* Relationships
. Cardinalities . *..* Imports
. SitesTypes . 1..* SitesTypes
. SitesTypes . *..* Sites
*/
        Relationships relationships1 = new Relationships();
        relationships1.setIsOptionality(true);
        relationships1.setIsEmbedded(false);
        relationships1.setName("");
//      ...................... AttributesTypes ........................
        Entities entities130 = new Entities();
        entities130 = findBean.nameEntities("AttributesTypes",em);
        relationships1.setFrom(entities130);
//      ...................... Sites ........................
        Entities entities131 = new Entities();
        entities131 = findBean.nameEntities("Sites",em);
        relationships1.setTo(entities131);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities132 = new Cardinalities();
        cardinalities132 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships1.setCardinalities(cardinalities132);
        em.persist(relationships1);
        em.flush();

        Relationships relationships2 = new Relationships();
        relationships2.setIsOptionality(true);
        relationships2.setIsEmbedded(false);
        relationships2.setName("");
//      ...................... AttributesTypes ........................
        Entities entities133 = new Entities();
        entities133 = findBean.nameEntities("AttributesTypes",em);
        relationships2.setFrom(entities133);
//      ...................... AttributesProperties ........................
        Entities entities134 = new Entities();
        entities134 = findBean.nameEntities("AttributesProperties",em);
        relationships2.setTo(entities134);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities135 = new Cardinalities();
        cardinalities135 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships2.setCardinalities(cardinalities135);
        em.persist(relationships2);
        em.flush();

        Relationships relationships3 = new Relationships();
        relationships3.setIsOptionality(true);
        relationships3.setIsEmbedded(false);
        relationships3.setName("");
//      ...................... AttributesTypes ........................
        Entities entities136 = new Entities();
        entities136 = findBean.nameEntities("AttributesTypes",em);
        relationships3.setFrom(entities136);
//      ...................... Attributes ........................
        Entities entities137 = new Entities();
        entities137 = findBean.nameEntities("Attributes",em);
        relationships3.setTo(entities137);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities138 = new Cardinalities();
        cardinalities138 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships3.setCardinalities(cardinalities138);
        em.persist(relationships3);
        em.flush();

        Relationships relationships4 = new Relationships();
        relationships4.setIsOptionality(true);
        relationships4.setIsEmbedded(false);
        relationships4.setName("");
//      ...................... AttributesProperties ........................
        Entities entities139 = new Entities();
        entities139 = findBean.nameEntities("AttributesProperties",em);
        relationships4.setFrom(entities139);
//      ...................... Imports ........................
        Entities entities140 = new Entities();
        entities140 = findBean.nameEntities("Imports",em);
        relationships4.setTo(entities140);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities141 = new Cardinalities();
        cardinalities141 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships4.setCardinalities(cardinalities141);
        em.persist(relationships4);
        em.flush();

        Relationships relationships5 = new Relationships();
        relationships5.setIsOptionality(true);
        relationships5.setIsEmbedded(false);
        relationships5.setName("");
//      ...................... AttributesProperties ........................
        Entities entities142 = new Entities();
        entities142 = findBean.nameEntities("AttributesProperties",em);
        relationships5.setFrom(entities142);
//      ...................... Sites ........................
        Entities entities143 = new Entities();
        entities143 = findBean.nameEntities("Sites",em);
        relationships5.setTo(entities143);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities144 = new Cardinalities();
        cardinalities144 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships5.setCardinalities(cardinalities144);
        em.persist(relationships5);
        em.flush();

        Relationships relationships6 = new Relationships();
        relationships6.setIsOptionality(true);
        relationships6.setIsEmbedded(false);
        relationships6.setName("");
//      ...................... Imports ........................
        Entities entities145 = new Entities();
        entities145 = findBean.nameEntities("Imports",em);
        relationships6.setFrom(entities145);
//      ...................... Sites ........................
        Entities entities146 = new Entities();
        entities146 = findBean.nameEntities("Sites",em);
        relationships6.setTo(entities146);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities147 = new Cardinalities();
        cardinalities147 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships6.setCardinalities(cardinalities147);
        em.persist(relationships6);
        em.flush();

        Relationships relationships7 = new Relationships();
        relationships7.setIsOptionality(true);
        relationships7.setIsEmbedded(false);
        relationships7.setName("");
//      ...................... Dependencies ........................
        Entities entities148 = new Entities();
        entities148 = findBean.nameEntities("Dependencies",em);
        relationships7.setFrom(entities148);
//      ...................... Imports ........................
        Entities entities149 = new Entities();
        entities149 = findBean.nameEntities("Imports",em);
        relationships7.setTo(entities149);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities150 = new Cardinalities();
        cardinalities150 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships7.setCardinalities(cardinalities150);
        em.persist(relationships7);
        em.flush();

        Relationships relationships8 = new Relationships();
        relationships8.setIsOptionality(true);
        relationships8.setIsEmbedded(false);
        relationships8.setName("");
//      ...................... Dependencies ........................
        Entities entities151 = new Entities();
        entities151 = findBean.nameEntities("Dependencies",em);
        relationships8.setFrom(entities151);
//      ...................... Sites ........................
        Entities entities152 = new Entities();
        entities152 = findBean.nameEntities("Sites",em);
        relationships8.setTo(entities152);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities153 = new Cardinalities();
        cardinalities153 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships8.setCardinalities(cardinalities153);
        em.persist(relationships8);
        em.flush();

        Relationships relationships9 = new Relationships();
        relationships9.setIsOptionality(true);
        relationships9.setIsEmbedded(false);
        relationships9.setName("");
//      ...................... Models ........................
        Entities entities154 = new Entities();
        entities154 = findBean.nameEntities("Models",em);
        relationships9.setFrom(entities154);
//      ...................... Sites ........................
        Entities entities155 = new Entities();
        entities155 = findBean.nameEntities("Sites",em);
        relationships9.setTo(entities155);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities156 = new Cardinalities();
        cardinalities156 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships9.setCardinalities(cardinalities156);
        em.persist(relationships9);
        em.flush();

        Relationships relationships10 = new Relationships();
        relationships10.setIsOptionality(true);
        relationships10.setIsEmbedded(false);
        relationships10.setName("");
//      ...................... Models ........................
        Entities entities157 = new Entities();
        entities157 = findBean.nameEntities("Models",em);
        relationships10.setFrom(entities157);
//      ...................... ModelsGroupIds ........................
        Entities entities158 = new Entities();
        entities158 = findBean.nameEntities("ModelsGroupIds",em);
        relationships10.setTo(entities158);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities159 = new Cardinalities();
        cardinalities159 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships10.setCardinalities(cardinalities159);
        em.persist(relationships10);
        em.flush();

        Relationships relationships11 = new Relationships();
        relationships11.setIsOptionality(true);
        relationships11.setIsEmbedded(false);
        relationships11.setName("");
//      ...................... GroupIds ........................
        Entities entities160 = new Entities();
        entities160 = findBean.nameEntities("GroupIds",em);
        relationships11.setFrom(entities160);
//      ...................... Entities ........................
        Entities entities161 = new Entities();
        entities161 = findBean.nameEntities("Entities",em);
        relationships11.setTo(entities161);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities162 = new Cardinalities();
        cardinalities162 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships11.setCardinalities(cardinalities162);
        em.persist(relationships11);
        em.flush();

        Relationships relationships12 = new Relationships();
        relationships12.setIsOptionality(true);
        relationships12.setIsEmbedded(false);
        relationships12.setName("");
//      ...................... GroupIds ........................
        Entities entities163 = new Entities();
        entities163 = findBean.nameEntities("GroupIds",em);
        relationships12.setFrom(entities163);
//      ...................... ModelsGroupIds ........................
        Entities entities164 = new Entities();
        entities164 = findBean.nameEntities("ModelsGroupIds",em);
        relationships12.setTo(entities164);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities165 = new Cardinalities();
        cardinalities165 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships12.setCardinalities(cardinalities165);
        em.persist(relationships12);
        em.flush();

        Relationships relationships13 = new Relationships();
        relationships13.setIsOptionality(true);
        relationships13.setIsEmbedded(false);
        relationships13.setName("");
//      ...................... Entities ........................
        Entities entities166 = new Entities();
        entities166 = findBean.nameEntities("Entities",em);
        relationships13.setFrom(entities166);
//      ...................... Imports ........................
        Entities entities167 = new Entities();
        entities167 = findBean.nameEntities("Imports",em);
        relationships13.setTo(entities167);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities168 = new Cardinalities();
        cardinalities168 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships13.setCardinalities(cardinalities168);
        em.persist(relationships13);
        em.flush();

        Relationships relationships14 = new Relationships();
        relationships14.setIsOptionality(true);
        relationships14.setIsEmbedded(false);
        relationships14.setName("");
//      ...................... Entities ........................
        Entities entities169 = new Entities();
        entities169 = findBean.nameEntities("Entities",em);
        relationships14.setFrom(entities169);
//      ...................... Sites ........................
        Entities entities170 = new Entities();
        entities170 = findBean.nameEntities("Sites",em);
        relationships14.setTo(entities170);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities171 = new Cardinalities();
        cardinalities171 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships14.setCardinalities(cardinalities171);
        em.persist(relationships14);
        em.flush();

        Relationships relationships15 = new Relationships();
        relationships15.setIsOptionality(true);
        relationships15.setIsEmbedded(false);
        relationships15.setName("from");
//      ...................... Entities ........................
        Entities entities172 = new Entities();
        entities172 = findBean.nameEntities("Entities",em);
        relationships15.setFrom(entities172);
//      ...................... Relationships ........................
        Entities entities173 = new Entities();
        entities173 = findBean.nameEntities("Relationships",em);
        relationships15.setTo(entities173);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities174 = new Cardinalities();
        cardinalities174 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships15.setCardinalities(cardinalities174);
        em.persist(relationships15);
        em.flush();

        Relationships relationships16 = new Relationships();
        relationships16.setIsOptionality(true);
        relationships16.setIsEmbedded(false);
        relationships16.setName("to");
//      ...................... Entities ........................
        Entities entities175 = new Entities();
        entities175 = findBean.nameEntities("Entities",em);
        relationships16.setFrom(entities175);
//      ...................... Relationships ........................
        Entities entities176 = new Entities();
        entities176 = findBean.nameEntities("Relationships",em);
        relationships16.setTo(entities176);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities177 = new Cardinalities();
        cardinalities177 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships16.setCardinalities(cardinalities177);
        em.persist(relationships16);
        em.flush();

        Relationships relationships17 = new Relationships();
        relationships17.setIsOptionality(true);
        relationships17.setIsEmbedded(false);
        relationships17.setName("");
//      ...................... Entities ........................
        Entities entities178 = new Entities();
        entities178 = findBean.nameEntities("Entities",em);
        relationships17.setFrom(entities178);
//      ...................... Attributes ........................
        Entities entities179 = new Entities();
        entities179 = findBean.nameEntities("Attributes",em);
        relationships17.setTo(entities179);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities180 = new Cardinalities();
        cardinalities180 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships17.setCardinalities(cardinalities180);
        em.persist(relationships17);
        em.flush();

        Relationships relationships18 = new Relationships();
        relationships18.setIsOptionality(true);
        relationships18.setIsEmbedded(false);
        relationships18.setName("");
//      ...................... Entities ........................
        Entities entities181 = new Entities();
        entities181 = findBean.nameEntities("Entities",em);
        relationships18.setFrom(entities181);
//      ...................... AttributesProperties ........................
        Entities entities182 = new Entities();
        entities182 = findBean.nameEntities("AttributesProperties",em);
        relationships18.setTo(entities182);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities183 = new Cardinalities();
        cardinalities183 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships18.setCardinalities(cardinalities183);
        em.persist(relationships18);
        em.flush();

        Relationships relationships19 = new Relationships();
        relationships19.setIsOptionality(true);
        relationships19.setIsEmbedded(false);
        relationships19.setName("");
//      ...................... Entities ........................
        Entities entities184 = new Entities();
        entities184 = findBean.nameEntities("Entities",em);
        relationships19.setFrom(entities184);
//      ...................... NameQueries ........................
        Entities entities185 = new Entities();
        entities185 = findBean.nameEntities("NameQueries",em);
        relationships19.setTo(entities185);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities186 = new Cardinalities();
        cardinalities186 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships19.setCardinalities(cardinalities186);
        em.persist(relationships19);
        em.flush();

        Relationships relationships20 = new Relationships();
        relationships20.setIsOptionality(true);
        relationships20.setIsEmbedded(false);
        relationships20.setName("");
//      ...................... Attributes ........................
        Entities entities187 = new Entities();
        entities187 = findBean.nameEntities("Attributes",em);
        relationships20.setFrom(entities187);
//      ...................... Sites ........................
        Entities entities188 = new Entities();
        entities188 = findBean.nameEntities("Sites",em);
        relationships20.setTo(entities188);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities189 = new Cardinalities();
        cardinalities189 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships20.setCardinalities(cardinalities189);
        em.persist(relationships20);
        em.flush();

        Relationships relationships21 = new Relationships();
        relationships21.setIsOptionality(true);
        relationships21.setIsEmbedded(false);
        relationships21.setName("");
//      ...................... Attributes ........................
        Entities entities190 = new Entities();
        entities190 = findBean.nameEntities("Attributes",em);
        relationships21.setFrom(entities190);
//      ...................... AttributesProperties ........................
        Entities entities191 = new Entities();
        entities191 = findBean.nameEntities("AttributesProperties",em);
        relationships21.setTo(entities191);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities192 = new Cardinalities();
        cardinalities192 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships21.setCardinalities(cardinalities192);
        em.persist(relationships21);
        em.flush();

        Relationships relationships22 = new Relationships();
        relationships22.setIsOptionality(true);
        relationships22.setIsEmbedded(false);
        relationships22.setName("");
//      ...................... Developments ........................
        Entities entities193 = new Entities();
        entities193 = findBean.nameEntities("Developments",em);
        relationships22.setFrom(entities193);
//      ...................... Sites ........................
        Entities entities194 = new Entities();
        entities194 = findBean.nameEntities("Sites",em);
        relationships22.setTo(entities194);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities195 = new Cardinalities();
        cardinalities195 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships22.setCardinalities(cardinalities195);
        em.persist(relationships22);
        em.flush();

        Relationships relationships23 = new Relationships();
        relationships23.setIsOptionality(true);
        relationships23.setIsEmbedded(false);
        relationships23.setName("");
//      ...................... Developments ........................
        Entities entities196 = new Entities();
        entities196 = findBean.nameEntities("Developments",em);
        relationships23.setFrom(entities196);
//      ...................... Models ........................
        Entities entities197 = new Entities();
        entities197 = findBean.nameEntities("Models",em);
        relationships23.setTo(entities197);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities198 = new Cardinalities();
        cardinalities198 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships23.setCardinalities(cardinalities198);
        em.persist(relationships23);
        em.flush();

        Relationships relationships24 = new Relationships();
        relationships24.setIsOptionality(true);
        relationships24.setIsEmbedded(false);
        relationships24.setName("");
//      ...................... Relationships ........................
        Entities entities199 = new Entities();
        entities199 = findBean.nameEntities("Relationships",em);
        relationships24.setFrom(entities199);
//      ...................... AttributesProperties ........................
        Entities entities200 = new Entities();
        entities200 = findBean.nameEntities("AttributesProperties",em);
        relationships24.setTo(entities200);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities201 = new Cardinalities();
        cardinalities201 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships24.setCardinalities(cardinalities201);
        em.persist(relationships24);
        em.flush();

        Relationships relationships25 = new Relationships();
        relationships25.setIsOptionality(true);
        relationships25.setIsEmbedded(false);
        relationships25.setName("");
//      ...................... Cardinalities ........................
        Entities entities202 = new Entities();
        entities202 = findBean.nameEntities("Cardinalities",em);
        relationships25.setFrom(entities202);
//      ...................... Sites ........................
        Entities entities203 = new Entities();
        entities203 = findBean.nameEntities("Sites",em);
        relationships25.setTo(entities203);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities204 = new Cardinalities();
        cardinalities204 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships25.setCardinalities(cardinalities204);
        em.persist(relationships25);
        em.flush();

        Relationships relationships26 = new Relationships();
        relationships26.setIsOptionality(true);
        relationships26.setIsEmbedded(false);
        relationships26.setName("");
//      ...................... Cardinalities ........................
        Entities entities205 = new Entities();
        entities205 = findBean.nameEntities("Cardinalities",em);
        relationships26.setFrom(entities205);
//      ...................... Relationships ........................
        Entities entities206 = new Entities();
        entities206 = findBean.nameEntities("Relationships",em);
        relationships26.setTo(entities206);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities207 = new Cardinalities();
        cardinalities207 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships26.setCardinalities(cardinalities207);
        em.persist(relationships26);
        em.flush();

        Relationships relationships27 = new Relationships();
        relationships27.setIsOptionality(true);
        relationships27.setIsEmbedded(false);
        relationships27.setName("");
//      ...................... Cardinalities ........................
        Entities entities208 = new Entities();
        entities208 = findBean.nameEntities("Cardinalities",em);
        relationships27.setFrom(entities208);
//      ...................... Imports ........................
        Entities entities209 = new Entities();
        entities209 = findBean.nameEntities("Imports",em);
        relationships27.setTo(entities209);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities210 = new Cardinalities();
        cardinalities210 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships27.setCardinalities(cardinalities210);
        em.persist(relationships27);
        em.flush();

        Relationships relationships28 = new Relationships();
        relationships28.setIsOptionality(true);
        relationships28.setIsEmbedded(false);
        relationships28.setName("");
//      ...................... SitesTypes ........................
        Entities entities211 = new Entities();
        entities211 = findBean.nameEntities("SitesTypes",em);
        relationships28.setFrom(entities211);
//      ...................... SitesTypes ........................
        Entities entities212 = new Entities();
        entities212 = findBean.nameEntities("SitesTypes",em);
        relationships28.setTo(entities212);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities213 = new Cardinalities();
        cardinalities213 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships28.setCardinalities(cardinalities213);
        em.persist(relationships28);
        em.flush();

        Relationships relationships29 = new Relationships();
        relationships29.setIsOptionality(true);
        relationships29.setIsEmbedded(false);
        relationships29.setName("");
//      ...................... SitesTypes ........................
        Entities entities214 = new Entities();
        entities214 = findBean.nameEntities("SitesTypes",em);
        relationships29.setFrom(entities214);
//      ...................... Sites ........................
        Entities entities215 = new Entities();
        entities215 = findBean.nameEntities("Sites",em);
        relationships29.setTo(entities215);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities216 = new Cardinalities();
        cardinalities216 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships29.setCardinalities(cardinalities216);
        em.persist(relationships29);
        em.flush();

    } // data()

} // naifgSetup
