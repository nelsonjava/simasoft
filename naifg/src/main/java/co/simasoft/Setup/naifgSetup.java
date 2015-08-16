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
        entities1.setName("ModelsGroupIds");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId1 = new GroupIds();
        groupId1 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities1.setGroupIds(groupId1);
        em.persist(entities1);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes2 = new Attributes();
        attributes2.setName("isSimplified");
        attributes2.setIsNullable(true);
        attributes2.setIsUnique(false);
//      ...................... ModelsGroupIds ........................
        Entities entity2 = new Entities();
        entity2 = findBean.nameEntities("ModelsGroupIds",em);
        attributes2.setEntities(entity2);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes3 = new AttributesTypes();
        attributesTypes3 = findBean.nameAttributesTypes("Boolean",em);
        attributes2.setAttributesTypes(attributesTypes3);
        em.persist(attributes2);
        em.flush();

        Attributes attributes3 = new Attributes();
        attributes3.setName("isSingle");
        attributes3.setIsNullable(true);
        attributes3.setIsUnique(false);
//      ...................... ModelsGroupIds ........................
        Entities entity4 = new Entities();
        entity4 = findBean.nameEntities("ModelsGroupIds",em);
        attributes3.setEntities(entity4);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes5 = new AttributesTypes();
        attributesTypes5 = findBean.nameAttributesTypes("Boolean",em);
        attributes3.setAttributesTypes(attributesTypes5);
        em.persist(attributes3);
        em.flush();

        Entities entities4 = new Entities();
        entities4.setName("Models");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId6 = new GroupIds();
        groupId6 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities4.setGroupIds(groupId6);
        em.persist(entities4);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes5 = new Attributes();
        attributes5.setName("version");
        attributes5.setIsNullable(true);
        attributes5.setIsUnique(false);
//      ...................... Models ........................
        Entities entity7 = new Entities();
        entity7 = findBean.nameEntities("Models",em);
        attributes5.setEntities(entity7);
//      ...................... String ........................
        AttributesTypes attributesTypes8 = new AttributesTypes();
        attributesTypes8 = findBean.nameAttributesTypes("String",em);
        attributes5.setAttributesTypes(attributesTypes8);
        em.persist(attributes5);
        em.flush();

        Attributes attributes6 = new Attributes();
        attributes6.setName("date");
        attributes6.setIsNullable(true);
        attributes6.setIsUnique(false);
//      ...................... Models ........................
        Entities entity9 = new Entities();
        entity9 = findBean.nameEntities("Models",em);
        attributes6.setEntities(entity9);
//      ...................... Date ........................
        AttributesTypes attributesTypes10 = new AttributesTypes();
        attributesTypes10 = findBean.nameAttributesTypes("Date",em);
        attributes6.setAttributesTypes(attributesTypes10);
        em.persist(attributes6);
        em.flush();

        Attributes attributes7 = new Attributes();
        attributes7.setName("groupId");
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
        attributes9.setName("artifactId");
        attributes9.setIsNullable(false);
        attributes9.setIsUnique(true);
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

        Entities entities10 = new Entities();
        entities10.setName("GroupIds");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId17 = new GroupIds();
        groupId17 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities10.setGroupIds(groupId17);
        em.persist(entities10);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes11 = new Attributes();
        attributes11.setName("version");
        attributes11.setIsNullable(true);
        attributes11.setIsUnique(false);
//      ...................... GroupIds ........................
        Entities entity18 = new Entities();
        entity18 = findBean.nameEntities("GroupIds",em);
        attributes11.setEntities(entity18);
//      ...................... String ........................
        AttributesTypes attributesTypes19 = new AttributesTypes();
        attributesTypes19 = findBean.nameAttributesTypes("String",em);
        attributes11.setAttributesTypes(attributesTypes19);
        em.persist(attributes11);
        em.flush();

        Attributes attributes12 = new Attributes();
        attributes12.setName("code");
        attributes12.setIsNullable(true);
        attributes12.setIsUnique(false);
//      ...................... GroupIds ........................
        Entities entity20 = new Entities();
        entity20 = findBean.nameEntities("GroupIds",em);
        attributes12.setEntities(entity20);
//      ...................... String ........................
        AttributesTypes attributesTypes21 = new AttributesTypes();
        attributesTypes21 = findBean.nameAttributesTypes("String",em);
        attributes12.setAttributesTypes(attributesTypes21);
        em.persist(attributes12);
        em.flush();

        Attributes attributes13 = new Attributes();
        attributes13.setName("date");
        attributes13.setIsNullable(true);
        attributes13.setIsUnique(false);
//      ...................... GroupIds ........................
        Entities entity22 = new Entities();
        entity22 = findBean.nameEntities("GroupIds",em);
        attributes13.setEntities(entity22);
//      ...................... Date ........................
        AttributesTypes attributesTypes23 = new AttributesTypes();
        attributesTypes23 = findBean.nameAttributesTypes("Date",em);
        attributes13.setAttributesTypes(attributesTypes23);
        em.persist(attributes13);
        em.flush();

        Attributes attributes14 = new Attributes();
        attributes14.setName("artifactId");
        attributes14.setIsNullable(false);
        attributes14.setIsUnique(true);
//      ...................... GroupIds ........................
        Entities entity24 = new Entities();
        entity24 = findBean.nameEntities("GroupIds",em);
        attributes14.setEntities(entity24);
//      ...................... String ........................
        AttributesTypes attributesTypes25 = new AttributesTypes();
        attributesTypes25 = findBean.nameAttributesTypes("String",em);
        attributes14.setAttributesTypes(attributesTypes25);
        em.persist(attributes14);
        em.flush();

        Attributes attributes15 = new Attributes();
        attributes15.setName("groupId");
        attributes15.setIsNullable(false);
        attributes15.setIsUnique(true);
//      ...................... GroupIds ........................
        Entities entity26 = new Entities();
        entity26 = findBean.nameEntities("GroupIds",em);
        attributes15.setEntities(entity26);
//      ...................... String ........................
        AttributesTypes attributesTypes27 = new AttributesTypes();
        attributesTypes27 = findBean.nameAttributesTypes("String",em);
        attributes15.setAttributesTypes(attributesTypes27);
        em.persist(attributes15);
        em.flush();

        Entities entities16 = new Entities();
        entities16.setName("Developments");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId28 = new GroupIds();
        groupId28 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities16.setGroupIds(groupId28);
        em.persist(entities16);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes17 = new Attributes();
        attributes17.setName("code");
        attributes17.setIsNullable(true);
        attributes17.setIsUnique(false);
//      ...................... Developments ........................
        Entities entity29 = new Entities();
        entity29 = findBean.nameEntities("Developments",em);
        attributes17.setEntities(entity29);
//      ...................... String ........................
        AttributesTypes attributesTypes30 = new AttributesTypes();
        attributesTypes30 = findBean.nameAttributesTypes("String",em);
        attributes17.setAttributesTypes(attributesTypes30);
        em.persist(attributes17);
        em.flush();

        Attributes attributes18 = new Attributes();
        attributes18.setName("version");
        attributes18.setIsNullable(true);
        attributes18.setIsUnique(false);
//      ...................... Developments ........................
        Entities entity31 = new Entities();
        entity31 = findBean.nameEntities("Developments",em);
        attributes18.setEntities(entity31);
//      ...................... String ........................
        AttributesTypes attributesTypes32 = new AttributesTypes();
        attributesTypes32 = findBean.nameAttributesTypes("String",em);
        attributes18.setAttributesTypes(attributesTypes32);
        em.persist(attributes18);
        em.flush();

        Attributes attributes19 = new Attributes();
        attributes19.setName("groupId");
        attributes19.setIsNullable(true);
        attributes19.setIsUnique(false);
//      ...................... Developments ........................
        Entities entity33 = new Entities();
        entity33 = findBean.nameEntities("Developments",em);
        attributes19.setEntities(entity33);
//      ...................... String ........................
        AttributesTypes attributesTypes34 = new AttributesTypes();
        attributesTypes34 = findBean.nameAttributesTypes("String",em);
        attributes19.setAttributesTypes(attributesTypes34);
        em.persist(attributes19);
        em.flush();

        Attributes attributes20 = new Attributes();
        attributes20.setName("date");
        attributes20.setIsNullable(true);
        attributes20.setIsUnique(false);
//      ...................... Developments ........................
        Entities entity35 = new Entities();
        entity35 = findBean.nameEntities("Developments",em);
        attributes20.setEntities(entity35);
//      ...................... Date ........................
        AttributesTypes attributesTypes36 = new AttributesTypes();
        attributesTypes36 = findBean.nameAttributesTypes("Date",em);
        attributes20.setAttributesTypes(attributesTypes36);
        em.persist(attributes20);
        em.flush();

        Attributes attributes21 = new Attributes();
        attributes21.setName("artifactId");
        attributes21.setIsNullable(false);
        attributes21.setIsUnique(true);
//      ...................... Developments ........................
        Entities entity37 = new Entities();
        entity37 = findBean.nameEntities("Developments",em);
        attributes21.setEntities(entity37);
//      ...................... String ........................
        AttributesTypes attributesTypes38 = new AttributesTypes();
        attributesTypes38 = findBean.nameAttributesTypes("String",em);
        attributes21.setAttributesTypes(attributesTypes38);
        em.persist(attributes21);
        em.flush();

        Entities entities22 = new Entities();
        entities22.setName("NameQueries");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId39 = new GroupIds();
        groupId39 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities22.setGroupIds(groupId39);
        em.persist(entities22);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes23 = new Attributes();
        attributes23.setName("name");
        attributes23.setIsNullable(false);
        attributes23.setIsUnique(true);
//      ...................... NameQueries ........................
        Entities entity40 = new Entities();
        entity40 = findBean.nameEntities("NameQueries",em);
        attributes23.setEntities(entity40);
//      ...................... String ........................
        AttributesTypes attributesTypes41 = new AttributesTypes();
        attributesTypes41 = findBean.nameAttributesTypes("String",em);
        attributes23.setAttributesTypes(attributesTypes41);
        em.persist(attributes23);
        em.flush();

        Attributes attributes24 = new Attributes();
        attributes24.setName("query");
        attributes24.setIsNullable(false);
        attributes24.setIsUnique(true);
//      ...................... NameQueries ........................
        Entities entity42 = new Entities();
        entity42 = findBean.nameEntities("NameQueries",em);
        attributes24.setEntities(entity42);
//      ...................... String ........................
        AttributesTypes attributesTypes43 = new AttributesTypes();
        attributesTypes43 = findBean.nameAttributesTypes("String",em);
        attributes24.setAttributesTypes(attributesTypes43);
        em.persist(attributes24);
        em.flush();

        Entities entities25 = new Entities();
        entities25.setName("Attributes");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId44 = new GroupIds();
        groupId44 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities25.setGroupIds(groupId44);
        em.persist(entities25);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes26 = new Attributes();
        attributes26.setName("isUnique");
        attributes26.setIsNullable(true);
        attributes26.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity45 = new Entities();
        entity45 = findBean.nameEntities("Attributes",em);
        attributes26.setEntities(entity45);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes46 = new AttributesTypes();
        attributesTypes46 = findBean.nameAttributesTypes("Boolean",em);
        attributes26.setAttributesTypes(attributesTypes46);
        em.persist(attributes26);
        em.flush();

        Attributes attributes27 = new Attributes();
        attributes27.setName("isSimplified");
        attributes27.setIsNullable(true);
        attributes27.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity47 = new Entities();
        entity47 = findBean.nameEntities("Attributes",em);
        attributes27.setEntities(entity47);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes48 = new AttributesTypes();
        attributesTypes48 = findBean.nameAttributesTypes("Boolean",em);
        attributes27.setAttributesTypes(attributesTypes48);
        em.persist(attributes27);
        em.flush();

        Attributes attributes28 = new Attributes();
        attributes28.setName("description");
        attributes28.setIsNullable(true);
        attributes28.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity49 = new Entities();
        entity49 = findBean.nameEntities("Attributes",em);
        attributes28.setEntities(entity49);
//      ...................... String ........................
        AttributesTypes attributesTypes50 = new AttributesTypes();
        attributesTypes50 = findBean.nameAttributesTypes("String",em);
        attributes28.setAttributesTypes(attributesTypes50);
        em.persist(attributes28);
        em.flush();

        Attributes attributes29 = new Attributes();
        attributes29.setName("isNullable");
        attributes29.setIsNullable(true);
        attributes29.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity51 = new Entities();
        entity51 = findBean.nameEntities("Attributes",em);
        attributes29.setEntities(entity51);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes52 = new AttributesTypes();
        attributesTypes52 = findBean.nameAttributesTypes("Boolean",em);
        attributes29.setAttributesTypes(attributesTypes52);
        em.persist(attributes29);
        em.flush();

        Attributes attributes30 = new Attributes();
        attributes30.setName("precision");
        attributes30.setIsNullable(true);
        attributes30.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity53 = new Entities();
        entity53 = findBean.nameEntities("Attributes",em);
        attributes30.setEntities(entity53);
//      ...................... Integer ........................
        AttributesTypes attributesTypes54 = new AttributesTypes();
        attributesTypes54 = findBean.nameAttributesTypes("Integer",em);
        attributes30.setAttributesTypes(attributesTypes54);
        em.persist(attributes30);
        em.flush();

        Attributes attributes31 = new Attributes();
        attributes31.setName("length");
        attributes31.setIsNullable(true);
        attributes31.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity55 = new Entities();
        entity55 = findBean.nameEntities("Attributes",em);
        attributes31.setEntities(entity55);
//      ...................... Integer ........................
        AttributesTypes attributesTypes56 = new AttributesTypes();
        attributesTypes56 = findBean.nameAttributesTypes("Integer",em);
        attributes31.setAttributesTypes(attributesTypes56);
        em.persist(attributes31);
        em.flush();

        Attributes attributes32 = new Attributes();
        attributes32.setName("name");
        attributes32.setIsNullable(false);
        attributes32.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity57 = new Entities();
        entity57 = findBean.nameEntities("Attributes",em);
        attributes32.setEntities(entity57);
//      ...................... String ........................
        AttributesTypes attributesTypes58 = new AttributesTypes();
        attributesTypes58 = findBean.nameAttributesTypes("String",em);
        attributes32.setAttributesTypes(attributesTypes58);
        em.persist(attributes32);
        em.flush();

        Entities entities33 = new Entities();
        entities33.setName("Cardinalities");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId59 = new GroupIds();
        groupId59 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities33.setGroupIds(groupId59);
        em.persist(entities33);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes34 = new Attributes();
        attributes34.setName("name");
        attributes34.setIsNullable(false);
        attributes34.setIsUnique(true);
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
        attributes35.setName("cardinality");
        attributes35.setIsNullable(false);
        attributes35.setIsUnique(false);
//      ...................... Cardinalities ........................
        Entities entity62 = new Entities();
        entity62 = findBean.nameEntities("Cardinalities",em);
        attributes35.setEntities(entity62);
//      ...................... String ........................
        AttributesTypes attributesTypes63 = new AttributesTypes();
        attributesTypes63 = findBean.nameAttributesTypes("String",em);
        attributes35.setAttributesTypes(attributesTypes63);
        em.persist(attributes35);
        em.flush();

        Attributes attributes36 = new Attributes();
        attributes36.setName("isUnidirectional");
        attributes36.setIsNullable(true);
        attributes36.setIsUnique(false);
//      ...................... Cardinalities ........................
        Entities entity64 = new Entities();
        entity64 = findBean.nameEntities("Cardinalities",em);
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
        attributes40.setName("description");
        attributes40.setIsNullable(true);
        attributes40.setIsUnique(false);
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
        attributes42.setName("isSimplified");
        attributes42.setIsNullable(true);
        attributes42.setIsUnique(false);
//      ...................... Entities ........................
        Entities entity75 = new Entities();
        entity75 = findBean.nameEntities("Entities",em);
        attributes42.setEntities(entity75);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes76 = new AttributesTypes();
        attributesTypes76 = findBean.nameAttributesTypes("Boolean",em);
        attributes42.setAttributesTypes(attributesTypes76);
        em.persist(attributes42);
        em.flush();

        Entities entities43 = new Entities();
        entities43.setName("Relationships");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId77 = new GroupIds();
        groupId77 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities43.setGroupIds(groupId77);
        em.persist(entities43);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes44 = new Attributes();
        attributes44.setName("isOptionality");
        attributes44.setIsNullable(true);
        attributes44.setIsUnique(false);
//      ...................... Relationships ........................
        Entities entity78 = new Entities();
        entity78 = findBean.nameEntities("Relationships",em);
        attributes44.setEntities(entity78);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes79 = new AttributesTypes();
        attributesTypes79 = findBean.nameAttributesTypes("Boolean",em);
        attributes44.setAttributesTypes(attributesTypes79);
        em.persist(attributes44);
        em.flush();

        Attributes attributes45 = new Attributes();
        attributes45.setName("isEmbedded");
        attributes45.setIsNullable(true);
        attributes45.setIsUnique(false);
//      ...................... Relationships ........................
        Entities entity80 = new Entities();
        entity80 = findBean.nameEntities("Relationships",em);
        attributes45.setEntities(entity80);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes81 = new AttributesTypes();
        attributesTypes81 = findBean.nameAttributesTypes("Boolean",em);
        attributes45.setAttributesTypes(attributesTypes81);
        em.persist(attributes45);
        em.flush();

        Attributes attributes46 = new Attributes();
        attributes46.setName("isSimplified");
        attributes46.setIsNullable(true);
        attributes46.setIsUnique(false);
//      ...................... Relationships ........................
        Entities entity82 = new Entities();
        entity82 = findBean.nameEntities("Relationships",em);
        attributes46.setEntities(entity82);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes83 = new AttributesTypes();
        attributesTypes83 = findBean.nameAttributesTypes("Boolean",em);
        attributes46.setAttributesTypes(attributesTypes83);
        em.persist(attributes46);
        em.flush();

        Attributes attributes47 = new Attributes();
        attributes47.setName("name");
        attributes47.setIsNullable(true);
        attributes47.setIsUnique(false);
//      ...................... Relationships ........................
        Entities entity84 = new Entities();
        entity84 = findBean.nameEntities("Relationships",em);
        attributes47.setEntities(entity84);
//      ...................... String ........................
        AttributesTypes attributesTypes85 = new AttributesTypes();
        attributesTypes85 = findBean.nameAttributesTypes("String",em);
        attributes47.setAttributesTypes(attributesTypes85);
        em.persist(attributes47);
        em.flush();

        Entities entities48 = new Entities();
        entities48.setName("Dependencies");
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId86 = new GroupIds();
        groupId86 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities48.setGroupIds(groupId86);
        em.persist(entities48);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes49 = new Attributes();
        attributes49.setName("scope");
        attributes49.setIsNullable(true);
        attributes49.setIsUnique(false);
//      ...................... Dependencies ........................
        Entities entity87 = new Entities();
        entity87 = findBean.nameEntities("Dependencies",em);
        attributes49.setEntities(entity87);
//      ...................... String ........................
        AttributesTypes attributesTypes88 = new AttributesTypes();
        attributesTypes88 = findBean.nameAttributesTypes("String",em);
        attributes49.setAttributesTypes(attributesTypes88);
        em.persist(attributes49);
        em.flush();

        Attributes attributes50 = new Attributes();
        attributes50.setName("version");
        attributes50.setIsNullable(true);
        attributes50.setIsUnique(false);
//      ...................... Dependencies ........................
        Entities entity89 = new Entities();
        entity89 = findBean.nameEntities("Dependencies",em);
        attributes50.setEntities(entity89);
//      ...................... String ........................
        AttributesTypes attributesTypes90 = new AttributesTypes();
        attributesTypes90 = findBean.nameAttributesTypes("String",em);
        attributes50.setAttributesTypes(attributesTypes90);
        em.persist(attributes50);
        em.flush();

        Attributes attributes51 = new Attributes();
        attributes51.setName("type");
        attributes51.setIsNullable(true);
        attributes51.setIsUnique(false);
//      ...................... Dependencies ........................
        Entities entity91 = new Entities();
        entity91 = findBean.nameEntities("Dependencies",em);
        attributes51.setEntities(entity91);
//      ...................... String ........................
        AttributesTypes attributesTypes92 = new AttributesTypes();
        attributesTypes92 = findBean.nameAttributesTypes("String",em);
        attributes51.setAttributesTypes(attributesTypes92);
        em.persist(attributes51);
        em.flush();

        Attributes attributes52 = new Attributes();
        attributes52.setName("groupId");
        attributes52.setIsNullable(false);
        attributes52.setIsUnique(false);
//      ...................... Dependencies ........................
        Entities entity93 = new Entities();
        entity93 = findBean.nameEntities("Dependencies",em);
        attributes52.setEntities(entity93);
//      ...................... String ........................
        AttributesTypes attributesTypes94 = new AttributesTypes();
        attributesTypes94 = findBean.nameAttributesTypes("String",em);
        attributes52.setAttributesTypes(attributesTypes94);
        em.persist(attributes52);
        em.flush();

        Attributes attributes53 = new Attributes();
        attributes53.setName("artifactId");
        attributes53.setIsNullable(false);
        attributes53.setIsUnique(false);
//      ...................... Dependencies ........................
        Entities entity95 = new Entities();
        entity95 = findBean.nameEntities("Dependencies",em);
        attributes53.setEntities(entity95);
//      ...................... String ........................
        AttributesTypes attributesTypes96 = new AttributesTypes();
        attributesTypes96 = findBean.nameAttributesTypes("String",em);
        attributes53.setAttributesTypes(attributesTypes96);
        em.persist(attributes53);
        em.flush();

        Attributes attributes54 = new Attributes();
        attributes54.setName("maven");
        attributes54.setIsNullable(false);
        attributes54.setIsUnique(true);
//      ...................... Dependencies ........................
        Entities entity97 = new Entities();
        entity97 = findBean.nameEntities("Dependencies",em);
        attributes54.setEntities(entity97);
//      ...................... String ........................
        AttributesTypes attributesTypes98 = new AttributesTypes();
        attributesTypes98 = findBean.nameAttributesTypes("String",em);
        attributes54.setAttributesTypes(attributesTypes98);
        em.persist(attributes54);
        em.flush();

        Entities entities55 = new Entities();
        entities55.setName("Imports");
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId99 = new GroupIds();
        groupId99 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities55.setGroupIds(groupId99);
        em.persist(entities55);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes56 = new Attributes();
        attributes56.setName("name");
        attributes56.setIsNullable(false);
        attributes56.setIsUnique(true);
//      ...................... Imports ........................
        Entities entity100 = new Entities();
        entity100 = findBean.nameEntities("Imports",em);
        attributes56.setEntities(entity100);
//      ...................... String ........................
        AttributesTypes attributesTypes101 = new AttributesTypes();
        attributesTypes101 = findBean.nameAttributesTypes("String",em);
        attributes56.setAttributesTypes(attributesTypes101);
        em.persist(attributes56);
        em.flush();

        Entities entities57 = new Entities();
        entities57.setName("AttributesTypes");
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId102 = new GroupIds();
        groupId102 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities57.setGroupIds(groupId102);
        em.persist(entities57);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes58 = new Attributes();
        attributes58.setName("precision");
        attributes58.setIsNullable(true);
        attributes58.setIsUnique(false);
//      ...................... AttributesTypes ........................
        Entities entity103 = new Entities();
        entity103 = findBean.nameEntities("AttributesTypes",em);
        attributes58.setEntities(entity103);
//      ...................... Integer ........................
        AttributesTypes attributesTypes104 = new AttributesTypes();
        attributesTypes104 = findBean.nameAttributesTypes("Integer",em);
        attributes58.setAttributesTypes(attributesTypes104);
        em.persist(attributes58);
        em.flush();

        Attributes attributes59 = new Attributes();
        attributes59.setName("annotations");
        attributes59.setIsNullable(true);
        attributes59.setIsUnique(false);
//      ...................... AttributesTypes ........................
        Entities entity105 = new Entities();
        entity105 = findBean.nameEntities("AttributesTypes",em);
        attributes59.setEntities(entity105);
//      ...................... String ........................
        AttributesTypes attributesTypes106 = new AttributesTypes();
        attributesTypes106 = findBean.nameAttributesTypes("String",em);
        attributes59.setAttributesTypes(attributesTypes106);
        em.persist(attributes59);
        em.flush();

        Attributes attributes60 = new Attributes();
        attributes60.setName("length");
        attributes60.setIsNullable(true);
        attributes60.setIsUnique(false);
//      ...................... AttributesTypes ........................
        Entities entity107 = new Entities();
        entity107 = findBean.nameEntities("AttributesTypes",em);
        attributes60.setEntities(entity107);
//      ...................... Integer ........................
        AttributesTypes attributesTypes108 = new AttributesTypes();
        attributesTypes108 = findBean.nameAttributesTypes("Integer",em);
        attributes60.setAttributesTypes(attributesTypes108);
        em.persist(attributes60);
        em.flush();

        Attributes attributes61 = new Attributes();
        attributes61.setName("name");
        attributes61.setIsNullable(false);
        attributes61.setIsUnique(true);
//      ...................... AttributesTypes ........................
        Entities entity109 = new Entities();
        entity109 = findBean.nameEntities("AttributesTypes",em);
        attributes61.setEntities(entity109);
//      ...................... String ........................
        AttributesTypes attributesTypes110 = new AttributesTypes();
        attributesTypes110 = findBean.nameAttributesTypes("String",em);
        attributes61.setAttributesTypes(attributesTypes110);
        em.persist(attributes61);
        em.flush();

        Attributes attributes62 = new Attributes();
        attributes62.setName("type");
        attributes62.setIsNullable(false);
        attributes62.setIsUnique(false);
//      ...................... AttributesTypes ........................
        Entities entity111 = new Entities();
        entity111 = findBean.nameEntities("AttributesTypes",em);
        attributes62.setEntities(entity111);
//      ...................... String ........................
        AttributesTypes attributesTypes112 = new AttributesTypes();
        attributesTypes112 = findBean.nameAttributesTypes("String",em);
        attributes62.setAttributesTypes(attributesTypes112);
        em.persist(attributes62);
        em.flush();

        Entities entities63 = new Entities();
        entities63.setName("AttributesProperties");
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId113 = new GroupIds();
        groupId113 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities63.setGroupIds(groupId113);
        em.persist(entities63);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes64 = new Attributes();
        attributes64.setName("value");
        attributes64.setIsNullable(false);
        attributes64.setIsUnique(true);
//      ...................... AttributesProperties ........................
        Entities entity114 = new Entities();
        entity114 = findBean.nameEntities("AttributesProperties",em);
        attributes64.setEntities(entity114);
//      ...................... String ........................
        AttributesTypes attributesTypes115 = new AttributesTypes();
        attributesTypes115 = findBean.nameAttributesTypes("String",em);
        attributes64.setAttributesTypes(attributesTypes115);
        em.persist(attributes64);
        em.flush();

        Attributes attributes65 = new Attributes();
        attributes65.setName("name");
        attributes65.setIsNullable(false);
        attributes65.setIsUnique(true);
//      ...................... AttributesProperties ........................
        Entities entity116 = new Entities();
        entity116 = findBean.nameEntities("AttributesProperties",em);
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
. SitesTypes . *..* Sites
. SitesTypes . 1..* SitesTypes
. Models . 1..* ModelsGroupIds
. Models . *..* Sites
. GroupIds . 1..* ModelsGroupIds
. GroupIds . 1..* Entities
. Developments . *..* Sites
. Developments . *..* Models
. Attributes . *..* AttributesProperties
. Attributes . *..* Sites
. Cardinalities . 1..* Relationships
. Cardinalities . *..* Sites
. Cardinalities . *..* Imports
. Entities . 1..* Relationships
. Entities . 1..* Relationships
. Entities . 1..* Attributes
. Entities . *..* AttributesProperties
. Entities . *..* Imports
. Entities . 1..* NameQueries
. Entities . *..* Sites
. Relationships . *..* AttributesProperties
. Dependencies . *..* Sites
. Dependencies . 1..* Imports
. Imports . *..* Sites
. AttributesTypes . *..* AttributesProperties
. AttributesTypes . *..* Sites
. AttributesTypes . 1..* Attributes
. AttributesProperties . *..* Sites
. AttributesProperties . *..* Imports
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
//      ...................... SitesTypes ........................
        Entities entities124 = new Entities();
        entities124 = findBean.nameEntities("SitesTypes",em);
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
//      ...................... SitesTypes ........................
        Entities entities127 = new Entities();
        entities127 = findBean.nameEntities("SitesTypes",em);
        relationships4.setFrom(entities127);
//      ...................... SitesTypes ........................
        Entities entities128 = new Entities();
        entities128 = findBean.nameEntities("SitesTypes",em);
        relationships4.setTo(entities128);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities129 = new Cardinalities();
        cardinalities129 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships4.setCardinalities(cardinalities129);
        em.persist(relationships4);
        em.flush();

        Relationships relationships5 = new Relationships();
        relationships5.setIsOptionality(true);
        relationships5.setIsEmbedded(false);
        relationships5.setName("");
//      ...................... Models ........................
        Entities entities130 = new Entities();
        entities130 = findBean.nameEntities("Models",em);
        relationships5.setFrom(entities130);
//      ...................... ModelsGroupIds ........................
        Entities entities131 = new Entities();
        entities131 = findBean.nameEntities("ModelsGroupIds",em);
        relationships5.setTo(entities131);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities132 = new Cardinalities();
        cardinalities132 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships5.setCardinalities(cardinalities132);
        em.persist(relationships5);
        em.flush();

        Relationships relationships6 = new Relationships();
        relationships6.setIsOptionality(true);
        relationships6.setIsEmbedded(false);
        relationships6.setName("");
//      ...................... Models ........................
        Entities entities133 = new Entities();
        entities133 = findBean.nameEntities("Models",em);
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
//      ...................... GroupIds ........................
        Entities entities136 = new Entities();
        entities136 = findBean.nameEntities("GroupIds",em);
        relationships7.setFrom(entities136);
//      ...................... ModelsGroupIds ........................
        Entities entities137 = new Entities();
        entities137 = findBean.nameEntities("ModelsGroupIds",em);
        relationships7.setTo(entities137);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities138 = new Cardinalities();
        cardinalities138 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
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
//      ...................... Developments ........................
        Entities entities142 = new Entities();
        entities142 = findBean.nameEntities("Developments",em);
        relationships9.setFrom(entities142);
//      ...................... Sites ........................
        Entities entities143 = new Entities();
        entities143 = findBean.nameEntities("Sites",em);
        relationships9.setTo(entities143);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities144 = new Cardinalities();
        cardinalities144 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships9.setCardinalities(cardinalities144);
        em.persist(relationships9);
        em.flush();

        Relationships relationships10 = new Relationships();
        relationships10.setIsOptionality(true);
        relationships10.setIsEmbedded(false);
        relationships10.setName("");
//      ...................... Developments ........................
        Entities entities145 = new Entities();
        entities145 = findBean.nameEntities("Developments",em);
        relationships10.setFrom(entities145);
//      ...................... Models ........................
        Entities entities146 = new Entities();
        entities146 = findBean.nameEntities("Models",em);
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
//      ...................... Attributes ........................
        Entities entities148 = new Entities();
        entities148 = findBean.nameEntities("Attributes",em);
        relationships11.setFrom(entities148);
//      ...................... AttributesProperties ........................
        Entities entities149 = new Entities();
        entities149 = findBean.nameEntities("AttributesProperties",em);
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
//      ...................... Attributes ........................
        Entities entities151 = new Entities();
        entities151 = findBean.nameEntities("Attributes",em);
        relationships12.setFrom(entities151);
//      ...................... Sites ........................
        Entities entities152 = new Entities();
        entities152 = findBean.nameEntities("Sites",em);
        relationships12.setTo(entities152);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities153 = new Cardinalities();
        cardinalities153 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships12.setCardinalities(cardinalities153);
        em.persist(relationships12);
        em.flush();

        Relationships relationships13 = new Relationships();
        relationships13.setIsOptionality(true);
        relationships13.setIsEmbedded(false);
        relationships13.setName("");
//      ...................... Cardinalities ........................
        Entities entities154 = new Entities();
        entities154 = findBean.nameEntities("Cardinalities",em);
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
//      ...................... Cardinalities ........................
        Entities entities157 = new Entities();
        entities157 = findBean.nameEntities("Cardinalities",em);
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
//      ...................... Cardinalities ........................
        Entities entities160 = new Entities();
        entities160 = findBean.nameEntities("Cardinalities",em);
        relationships15.setFrom(entities160);
//      ...................... Imports ........................
        Entities entities161 = new Entities();
        entities161 = findBean.nameEntities("Imports",em);
        relationships15.setTo(entities161);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities162 = new Cardinalities();
        cardinalities162 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships15.setCardinalities(cardinalities162);
        em.persist(relationships15);
        em.flush();

        Relationships relationships16 = new Relationships();
        relationships16.setIsOptionality(true);
        relationships16.setIsEmbedded(false);
        relationships16.setName("from");
//      ...................... Entities ........................
        Entities entities163 = new Entities();
        entities163 = findBean.nameEntities("Entities",em);
        relationships16.setFrom(entities163);
//      ...................... Relationships ........................
        Entities entities164 = new Entities();
        entities164 = findBean.nameEntities("Relationships",em);
        relationships16.setTo(entities164);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities165 = new Cardinalities();
        cardinalities165 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships16.setCardinalities(cardinalities165);
        em.persist(relationships16);
        em.flush();

        Relationships relationships17 = new Relationships();
        relationships17.setIsOptionality(true);
        relationships17.setIsEmbedded(false);
        relationships17.setName("to");
//      ...................... Entities ........................
        Entities entities166 = new Entities();
        entities166 = findBean.nameEntities("Entities",em);
        relationships17.setFrom(entities166);
//      ...................... Relationships ........................
        Entities entities167 = new Entities();
        entities167 = findBean.nameEntities("Relationships",em);
        relationships17.setTo(entities167);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities168 = new Cardinalities();
        cardinalities168 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
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
        relationships19.setName("");
//      ...................... Entities ........................
        Entities entities172 = new Entities();
        entities172 = findBean.nameEntities("Entities",em);
        relationships19.setFrom(entities172);
//      ...................... AttributesProperties ........................
        Entities entities173 = new Entities();
        entities173 = findBean.nameEntities("AttributesProperties",em);
        relationships19.setTo(entities173);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities174 = new Cardinalities();
        cardinalities174 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships19.setCardinalities(cardinalities174);
        em.persist(relationships19);
        em.flush();

        Relationships relationships20 = new Relationships();
        relationships20.setIsOptionality(true);
        relationships20.setIsEmbedded(false);
        relationships20.setName("");
//      ...................... Entities ........................
        Entities entities175 = new Entities();
        entities175 = findBean.nameEntities("Entities",em);
        relationships20.setFrom(entities175);
//      ...................... Imports ........................
        Entities entities176 = new Entities();
        entities176 = findBean.nameEntities("Imports",em);
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
//      ...................... Entities ........................
        Entities entities178 = new Entities();
        entities178 = findBean.nameEntities("Entities",em);
        relationships21.setFrom(entities178);
//      ...................... NameQueries ........................
        Entities entities179 = new Entities();
        entities179 = findBean.nameEntities("NameQueries",em);
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
//      ...................... Entities ........................
        Entities entities181 = new Entities();
        entities181 = findBean.nameEntities("Entities",em);
        relationships22.setFrom(entities181);
//      ...................... Sites ........................
        Entities entities182 = new Entities();
        entities182 = findBean.nameEntities("Sites",em);
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
//      ...................... Relationships ........................
        Entities entities184 = new Entities();
        entities184 = findBean.nameEntities("Relationships",em);
        relationships23.setFrom(entities184);
//      ...................... AttributesProperties ........................
        Entities entities185 = new Entities();
        entities185 = findBean.nameEntities("AttributesProperties",em);
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
//      ...................... Dependencies ........................
        Entities entities187 = new Entities();
        entities187 = findBean.nameEntities("Dependencies",em);
        relationships24.setFrom(entities187);
//      ...................... Sites ........................
        Entities entities188 = new Entities();
        entities188 = findBean.nameEntities("Sites",em);
        relationships24.setTo(entities188);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities189 = new Cardinalities();
        cardinalities189 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships24.setCardinalities(cardinalities189);
        em.persist(relationships24);
        em.flush();

        Relationships relationships25 = new Relationships();
        relationships25.setIsOptionality(true);
        relationships25.setIsEmbedded(false);
        relationships25.setName("");
//      ...................... Dependencies ........................
        Entities entities190 = new Entities();
        entities190 = findBean.nameEntities("Dependencies",em);
        relationships25.setFrom(entities190);
//      ...................... Imports ........................
        Entities entities191 = new Entities();
        entities191 = findBean.nameEntities("Imports",em);
        relationships25.setTo(entities191);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities192 = new Cardinalities();
        cardinalities192 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships25.setCardinalities(cardinalities192);
        em.persist(relationships25);
        em.flush();

        Relationships relationships26 = new Relationships();
        relationships26.setIsOptionality(true);
        relationships26.setIsEmbedded(false);
        relationships26.setName("");
//      ...................... Imports ........................
        Entities entities193 = new Entities();
        entities193 = findBean.nameEntities("Imports",em);
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
//      ...................... AttributesTypes ........................
        Entities entities196 = new Entities();
        entities196 = findBean.nameEntities("AttributesTypes",em);
        relationships27.setFrom(entities196);
//      ...................... AttributesProperties ........................
        Entities entities197 = new Entities();
        entities197 = findBean.nameEntities("AttributesProperties",em);
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
//      ...................... AttributesTypes ........................
        Entities entities199 = new Entities();
        entities199 = findBean.nameEntities("AttributesTypes",em);
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
//      ...................... AttributesTypes ........................
        Entities entities202 = new Entities();
        entities202 = findBean.nameEntities("AttributesTypes",em);
        relationships29.setFrom(entities202);
//      ...................... Attributes ........................
        Entities entities203 = new Entities();
        entities203 = findBean.nameEntities("Attributes",em);
        relationships29.setTo(entities203);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities204 = new Cardinalities();
        cardinalities204 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships29.setCardinalities(cardinalities204);
        em.persist(relationships29);
        em.flush();

        Relationships relationships30 = new Relationships();
        relationships30.setIsOptionality(true);
        relationships30.setIsEmbedded(false);
        relationships30.setName("");
//      ...................... AttributesProperties ........................
        Entities entities205 = new Entities();
        entities205 = findBean.nameEntities("AttributesProperties",em);
        relationships30.setFrom(entities205);
//      ...................... Sites ........................
        Entities entities206 = new Entities();
        entities206 = findBean.nameEntities("Sites",em);
        relationships30.setTo(entities206);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities207 = new Cardinalities();
        cardinalities207 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships30.setCardinalities(cardinalities207);
        em.persist(relationships30);
        em.flush();

        Relationships relationships31 = new Relationships();
        relationships31.setIsOptionality(true);
        relationships31.setIsEmbedded(false);
        relationships31.setName("");
//      ...................... AttributesProperties ........................
        Entities entities208 = new Entities();
        entities208 = findBean.nameEntities("AttributesProperties",em);
        relationships31.setFrom(entities208);
//      ...................... Imports ........................
        Entities entities209 = new Entities();
        entities209 = findBean.nameEntities("Imports",em);
        relationships31.setTo(entities209);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities210 = new Cardinalities();
        cardinalities210 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships31.setCardinalities(cardinalities210);
        em.persist(relationships31);
        em.flush();

    } // data()

} // naifgSetup
