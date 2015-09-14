package co.simasoft.core.setup;

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
@Named("coreSetup")
public class coreSetup {

    @PersistenceContext(unitName = "naifgPU-JTA")
    private EntityManager em;

    FindBean findBean = new FindBean();

    private static final Logger log = Logger.getLogger(coreSetup.class.getName());

    public void data() {

//      ---------------------- GroupIds ------------------------

        GroupIds groupIds1 = new GroupIds();
        groupIds1.setArtifactId("co.simasoft.models.core.books");
        groupIds1.setGroupId("co.simasoft.models.core.books");
        groupIds1.setVersion("null");
        groupIds1.setCode("null");
        em.persist(groupIds1);
        em.flush();

        GroupIds groupIds2 = new GroupIds();
        groupIds2.setArtifactId("co.simasoft.models.core.archival");
        groupIds2.setGroupId("co.simasoft.models.core.archival");
        groupIds2.setVersion("null");
        groupIds2.setCode("null");
        em.persist(groupIds2);
        em.flush();

        GroupIds groupIds3 = new GroupIds();
        groupIds3.setArtifactId("co.simasoft.models.core.companies");
        groupIds3.setGroupId("co.simasoft.models.core.companies");
        groupIds3.setVersion("null");
        groupIds3.setCode("null");
        em.persist(groupIds3);
        em.flush();

        GroupIds groupIds4 = new GroupIds();
        groupIds4.setArtifactId("co.simasoft.models.core.regulations");
        groupIds4.setGroupId("co.simasoft.models.core.regulations");
        groupIds4.setVersion("null");
        groupIds4.setCode("null");
        em.persist(groupIds4);
        em.flush();

        GroupIds groupIds5 = new GroupIds();
        groupIds5.setArtifactId("co.simasoft.models.core.sites");
        groupIds5.setGroupId("co.simasoft.models.core.sites");
        groupIds5.setVersion("null");
        groupIds5.setCode("null");
        em.persist(groupIds5);
        em.flush();

//      ---------------------- Models ------------------------

        Models models = new Models();
        models.setArtifactId("core");
        models.setGroupId("co.simasoft.core");
        models.setVersion("1.0-SNAPSHOT");
        models.setCode("null");
        em.persist(models);
        em.flush();

//      ---------------------- ModelsGroupIds ----------------------

        ModelsGroupIds modelsGroupIds1 = new ModelsGroupIds();
        Models modelss1 = findBean.artifactIdModels("core",em);
        GroupIds groupIdd1 = findBean.artifactIdGroupIds("co.simasoft.models.core.books",em);
        modelsGroupIds1.setModels(modelss1);
        modelsGroupIds1.setGroupIds(groupIdd1);
        modelsGroupIds1.setGroupId("");
        modelsGroupIds1.setIsSingle(null);
        modelsGroupIds1.setIsSimplified(null);
        em.persist(modelsGroupIds1);
        em.flush();

        ModelsGroupIds modelsGroupIds2 = new ModelsGroupIds();
        Models modelss2 = findBean.artifactIdModels("core",em);
        GroupIds groupIdd2 = findBean.artifactIdGroupIds("co.simasoft.models.core.archival",em);
        modelsGroupIds2.setModels(modelss2);
        modelsGroupIds2.setGroupIds(groupIdd2);
        modelsGroupIds2.setGroupId("");
        modelsGroupIds2.setIsSingle(null);
        modelsGroupIds2.setIsSimplified(null);
        em.persist(modelsGroupIds2);
        em.flush();

        ModelsGroupIds modelsGroupIds3 = new ModelsGroupIds();
        Models modelss3 = findBean.artifactIdModels("core",em);
        GroupIds groupIdd3 = findBean.artifactIdGroupIds("co.simasoft.models.core.companies",em);
        modelsGroupIds3.setModels(modelss3);
        modelsGroupIds3.setGroupIds(groupIdd3);
        modelsGroupIds3.setGroupId("");
        modelsGroupIds3.setIsSingle(null);
        modelsGroupIds3.setIsSimplified(null);
        em.persist(modelsGroupIds3);
        em.flush();

        ModelsGroupIds modelsGroupIds4 = new ModelsGroupIds();
        Models modelss4 = findBean.artifactIdModels("core",em);
        GroupIds groupIdd4 = findBean.artifactIdGroupIds("co.simasoft.models.core.regulations",em);
        modelsGroupIds4.setModels(modelss4);
        modelsGroupIds4.setGroupIds(groupIdd4);
        modelsGroupIds4.setGroupId("");
        modelsGroupIds4.setIsSingle(null);
        modelsGroupIds4.setIsSimplified(null);
        em.persist(modelsGroupIds4);
        em.flush();

        ModelsGroupIds modelsGroupIds5 = new ModelsGroupIds();
        Models modelss5 = findBean.artifactIdModels("core",em);
        GroupIds groupIdd5 = findBean.artifactIdGroupIds("co.simasoft.models.core.sites",em);
        modelsGroupIds5.setModels(modelss5);
        modelsGroupIds5.setGroupIds(groupIdd5);
        modelsGroupIds5.setGroupId("");
        modelsGroupIds5.setIsSingle(null);
        modelsGroupIds5.setIsSimplified(null);
        em.persist(modelsGroupIds5);
        em.flush();

//      ---------------------- Developments ------------------------

        Developments dev = new Developments();
        dev.setGroupId("co.simasoft.core");
        dev.setArtifactId("core");
        dev.setVersion("1.0-SNAPSHOT");
        dev.setCode("null");
        Set<Models> models1 = new HashSet<Models>();
        Models model1 = findBean.artifactIdModels("core",em);
        models1.add(model1);
        dev.setModels(models1);
        dev.setVersion("1.0-SNAPSHOT");
        dev.setCode("null");
        em.persist(dev);
        em.flush();

//      ---------------------- Entities ------------------------

        Entities entities1 = new Entities();
        entities1.setName("BooksTypes");
//      ...................... co.simasoft.models.core.books ........................
        GroupIds groupId1 = new GroupIds();
        groupId1 = findBean.groupIdGroupIds("co.simasoft.models.core.books",em);
        entities1.setGroupIds(groupId1);
        em.persist(entities1);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes2 = new Attributes();
        attributes2.setName("name");
        attributes2.setIsNullable(true);
        attributes2.setIsUnique(false);
//      ...................... BooksTypes ........................
        Entities entity2 = new Entities();
        entity2 = findBean.nameEntities("BooksTypes",em);
        attributes2.setEntities(entity2);
//      ...................... String ........................
        AttributesTypes attributesTypes3 = new AttributesTypes();
        attributesTypes3 = findBean.nameAttributesTypes("String",em);
        attributes2.setAttributesTypes(attributesTypes3);
        em.persist(attributes2);
        em.flush();

        Entities entities3 = new Entities();
        entities3.setName("Books");
//      ...................... co.simasoft.models.core.books ........................
        GroupIds groupId4 = new GroupIds();
        groupId4 = findBean.groupIdGroupIds("co.simasoft.models.core.books",em);
        entities3.setGroupIds(groupId4);
        em.persist(entities3);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes4 = new Attributes();
        attributes4.setName("code");
        attributes4.setIsNullable(true);
        attributes4.setIsUnique(false);
//      ...................... Books ........................
        Entities entity5 = new Entities();
        entity5 = findBean.nameEntities("Books",em);
        attributes4.setEntities(entity5);
//      ...................... String ........................
        AttributesTypes attributesTypes6 = new AttributesTypes();
        attributesTypes6 = findBean.nameAttributesTypes("String",em);
        attributes4.setAttributesTypes(attributesTypes6);
        em.persist(attributes4);
        em.flush();

        Attributes attributes5 = new Attributes();
        attributes5.setName("content");
        attributes5.setIsNullable(false);
        attributes5.setIsUnique(false);
//      ...................... Books ........................
        Entities entity7 = new Entities();
        entity7 = findBean.nameEntities("Books",em);
        attributes5.setEntities(entity7);
//      ...................... String ........................
        AttributesTypes attributesTypes8 = new AttributesTypes();
        attributesTypes8 = findBean.nameAttributesTypes("String",em);
        attributes5.setAttributesTypes(attributesTypes8);
        em.persist(attributes5);
        em.flush();

        Attributes attributes6 = new Attributes();
        attributes6.setName("name");
        attributes6.setIsNullable(false);
        attributes6.setIsUnique(true);
//      ...................... Books ........................
        Entities entity9 = new Entities();
        entity9 = findBean.nameEntities("Books",em);
        attributes6.setEntities(entity9);
//      ...................... String ........................
        AttributesTypes attributesTypes10 = new AttributesTypes();
        attributesTypes10 = findBean.nameAttributesTypes("String",em);
        attributes6.setAttributesTypes(attributesTypes10);
        em.persist(attributes6);
        em.flush();

        Entities entities7 = new Entities();
        entities7.setName("Chapters");
//      ...................... co.simasoft.models.core.books ........................
        GroupIds groupId11 = new GroupIds();
        groupId11 = findBean.groupIdGroupIds("co.simasoft.models.core.books",em);
        entities7.setGroupIds(groupId11);
        em.persist(entities7);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes8 = new Attributes();
        attributes8.setName("code");
        attributes8.setIsNullable(true);
        attributes8.setIsUnique(false);
//      ...................... Chapters ........................
        Entities entity12 = new Entities();
        entity12 = findBean.nameEntities("Chapters",em);
        attributes8.setEntities(entity12);
//      ...................... String ........................
        AttributesTypes attributesTypes13 = new AttributesTypes();
        attributesTypes13 = findBean.nameAttributesTypes("String",em);
        attributes8.setAttributesTypes(attributesTypes13);
        em.persist(attributes8);
        em.flush();

        Attributes attributes9 = new Attributes();
        attributes9.setName("content");
        attributes9.setIsNullable(false);
        attributes9.setIsUnique(false);
//      ...................... Chapters ........................
        Entities entity14 = new Entities();
        entity14 = findBean.nameEntities("Chapters",em);
        attributes9.setEntities(entity14);
//      ...................... String ........................
        AttributesTypes attributesTypes15 = new AttributesTypes();
        attributesTypes15 = findBean.nameAttributesTypes("String",em);
        attributes9.setAttributesTypes(attributesTypes15);
        em.persist(attributes9);
        em.flush();

        Attributes attributes10 = new Attributes();
        attributes10.setName("name");
        attributes10.setIsNullable(true);
        attributes10.setIsUnique(false);
//      ...................... Chapters ........................
        Entities entity16 = new Entities();
        entity16 = findBean.nameEntities("Chapters",em);
        attributes10.setEntities(entity16);
//      ...................... String ........................
        AttributesTypes attributesTypes17 = new AttributesTypes();
        attributesTypes17 = findBean.nameAttributesTypes("String",em);
        attributes10.setAttributesTypes(attributesTypes17);
        em.persist(attributes10);
        em.flush();

        Entities entities11 = new Entities();
        entities11.setName("Series");
//      ...................... co.simasoft.models.core.archival ........................
        GroupIds groupId18 = new GroupIds();
        groupId18 = findBean.groupIdGroupIds("co.simasoft.models.core.archival",em);
        entities11.setGroupIds(groupId18);
        em.persist(entities11);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes12 = new Attributes();
        attributes12.setName("name");
        attributes12.setIsNullable(true);
        attributes12.setIsUnique(false);
//      ...................... Series ........................
        Entities entity19 = new Entities();
        entity19 = findBean.nameEntities("Series",em);
        attributes12.setEntities(entity19);
//      ...................... String ........................
        AttributesTypes attributesTypes20 = new AttributesTypes();
        attributesTypes20 = findBean.nameAttributesTypes("String",em);
        attributes12.setAttributesTypes(attributesTypes20);
        em.persist(attributes12);
        em.flush();

        Attributes attributes13 = new Attributes();
        attributes13.setName("code");
        attributes13.setIsNullable(true);
        attributes13.setIsUnique(false);
//      ...................... Series ........................
        Entities entity21 = new Entities();
        entity21 = findBean.nameEntities("Series",em);
        attributes13.setEntities(entity21);
//      ...................... String ........................
        AttributesTypes attributesTypes22 = new AttributesTypes();
        attributesTypes22 = findBean.nameAttributesTypes("String",em);
        attributes13.setAttributesTypes(attributesTypes22);
        em.persist(attributes13);
        em.flush();

        Attributes attributes14 = new Attributes();
        attributes14.setName("link");
        attributes14.setIsNullable(true);
        attributes14.setIsUnique(false);
//      ...................... Series ........................
        Entities entity23 = new Entities();
        entity23 = findBean.nameEntities("Series",em);
        attributes14.setEntities(entity23);
//      ...................... String ........................
        AttributesTypes attributesTypes24 = new AttributesTypes();
        attributesTypes24 = findBean.nameAttributesTypes("String",em);
        attributes14.setAttributesTypes(attributesTypes24);
        em.persist(attributes14);
        em.flush();

        Attributes attributes15 = new Attributes();
        attributes15.setName("located");
        attributes15.setIsNullable(true);
        attributes15.setIsUnique(false);
//      ...................... Series ........................
        Entities entity25 = new Entities();
        entity25 = findBean.nameEntities("Series",em);
        attributes15.setEntities(entity25);
//      ...................... String ........................
        AttributesTypes attributesTypes26 = new AttributesTypes();
        attributesTypes26 = findBean.nameAttributesTypes("String",em);
        attributes15.setAttributesTypes(attributesTypes26);
        em.persist(attributes15);
        em.flush();

        Entities entities16 = new Entities();
        entities16.setName("DocumentalsUnits");
//      ...................... co.simasoft.models.core.archival ........................
        GroupIds groupId27 = new GroupIds();
        groupId27 = findBean.groupIdGroupIds("co.simasoft.models.core.archival",em);
        entities16.setGroupIds(groupId27);
        em.persist(entities16);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes17 = new Attributes();
        attributes17.setName("name");
        attributes17.setIsNullable(true);
        attributes17.setIsUnique(false);
//      ...................... DocumentalsUnits ........................
        Entities entity28 = new Entities();
        entity28 = findBean.nameEntities("DocumentalsUnits",em);
        attributes17.setEntities(entity28);
//      ...................... String ........................
        AttributesTypes attributesTypes29 = new AttributesTypes();
        attributesTypes29 = findBean.nameAttributesTypes("String",em);
        attributes17.setAttributesTypes(attributesTypes29);
        em.persist(attributes17);
        em.flush();

        Attributes attributes18 = new Attributes();
        attributes18.setName("creationDate");
        attributes18.setIsNullable(true);
        attributes18.setIsUnique(false);
//      ...................... DocumentalsUnits ........................
        Entities entity30 = new Entities();
        entity30 = findBean.nameEntities("DocumentalsUnits",em);
        attributes18.setEntities(entity30);
//      ...................... Date ........................
        AttributesTypes attributesTypes31 = new AttributesTypes();
        attributesTypes31 = findBean.nameAttributesTypes("Date",em);
        attributes18.setAttributesTypes(attributesTypes31);
        em.persist(attributes18);
        em.flush();

        Entities entities19 = new Entities();
        entities19.setName("DocumentalsSupports");
//      ...................... co.simasoft.models.core.archival ........................
        GroupIds groupId32 = new GroupIds();
        groupId32 = findBean.groupIdGroupIds("co.simasoft.models.core.archival",em);
        entities19.setGroupIds(groupId32);
        em.persist(entities19);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes20 = new Attributes();
        attributes20.setName("name");
        attributes20.setIsNullable(true);
        attributes20.setIsUnique(false);
//      ...................... DocumentalsSupports ........................
        Entities entity33 = new Entities();
        entity33 = findBean.nameEntities("DocumentalsSupports",em);
        attributes20.setEntities(entity33);
//      ...................... String ........................
        AttributesTypes attributesTypes34 = new AttributesTypes();
        attributesTypes34 = findBean.nameAttributesTypes("String",em);
        attributes20.setAttributesTypes(attributesTypes34);
        em.persist(attributes20);
        em.flush();

        Attributes attributes21 = new Attributes();
        attributes21.setName("code");
        attributes21.setIsNullable(true);
        attributes21.setIsUnique(false);
//      ...................... DocumentalsSupports ........................
        Entities entity35 = new Entities();
        entity35 = findBean.nameEntities("DocumentalsSupports",em);
        attributes21.setEntities(entity35);
//      ...................... String ........................
        AttributesTypes attributesTypes36 = new AttributesTypes();
        attributesTypes36 = findBean.nameAttributesTypes("String",em);
        attributes21.setAttributesTypes(attributesTypes36);
        em.persist(attributes21);
        em.flush();

        Entities entities22 = new Entities();
        entities22.setName("DocumentalRetention");
//      ...................... co.simasoft.models.core.archival ........................
        GroupIds groupId37 = new GroupIds();
        groupId37 = findBean.groupIdGroupIds("co.simasoft.models.core.archival",em);
        entities22.setGroupIds(groupId37);
        em.persist(entities22);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes23 = new Attributes();
        attributes23.setName("year");
        attributes23.setIsNullable(true);
        attributes23.setIsUnique(false);
//      ...................... DocumentalRetention ........................
        Entities entity38 = new Entities();
        entity38 = findBean.nameEntities("DocumentalRetention",em);
        attributes23.setEntities(entity38);
//      ...................... Integer ........................
        AttributesTypes attributesTypes39 = new AttributesTypes();
        attributesTypes39 = findBean.nameAttributesTypes("Integer",em);
        attributes23.setAttributesTypes(attributesTypes39);
        em.persist(attributes23);
        em.flush();

        Attributes attributes24 = new Attributes();
        attributes24.setName("name");
        attributes24.setIsNullable(true);
        attributes24.setIsUnique(false);
//      ...................... DocumentalRetention ........................
        Entities entity40 = new Entities();
        entity40 = findBean.nameEntities("DocumentalRetention",em);
        attributes24.setEntities(entity40);
//      ...................... String ........................
        AttributesTypes attributesTypes41 = new AttributesTypes();
        attributesTypes41 = findBean.nameAttributesTypes("String",em);
        attributes24.setAttributesTypes(attributesTypes41);
        em.persist(attributes24);
        em.flush();

        Entities entities25 = new Entities();
        entities25.setName("FundsLife");
//      ...................... co.simasoft.models.core.archival ........................
        GroupIds groupId42 = new GroupIds();
        groupId42 = findBean.groupIdGroupIds("co.simasoft.models.core.archival",em);
        entities25.setGroupIds(groupId42);
        em.persist(entities25);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes26 = new Attributes();
        attributes26.setName("name");
        attributes26.setIsNullable(true);
        attributes26.setIsUnique(false);
//      ...................... FundsLife ........................
        Entities entity43 = new Entities();
        entity43 = findBean.nameEntities("FundsLife",em);
        attributes26.setEntities(entity43);
//      ...................... String ........................
        AttributesTypes attributesTypes44 = new AttributesTypes();
        attributesTypes44 = findBean.nameAttributesTypes("String",em);
        attributes26.setAttributesTypes(attributesTypes44);
        em.persist(attributes26);
        em.flush();

        Attributes attributes27 = new Attributes();
        attributes27.setName("isOpen");
        attributes27.setIsNullable(true);
        attributes27.setIsUnique(false);
//      ...................... FundsLife ........................
        Entities entity45 = new Entities();
        entity45 = findBean.nameEntities("FundsLife",em);
        attributes27.setEntities(entity45);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes46 = new AttributesTypes();
        attributesTypes46 = findBean.nameAttributesTypes("Boolean",em);
        attributes27.setAttributesTypes(attributesTypes46);
        em.persist(attributes27);
        em.flush();

        Entities entities28 = new Entities();
        entities28.setName("FinalDisposition");
//      ...................... co.simasoft.models.core.archival ........................
        GroupIds groupId47 = new GroupIds();
        groupId47 = findBean.groupIdGroupIds("co.simasoft.models.core.archival",em);
        entities28.setGroupIds(groupId47);
        em.persist(entities28);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes29 = new Attributes();
        attributes29.setName("name");
        attributes29.setIsNullable(true);
        attributes29.setIsUnique(false);
//      ...................... FinalDisposition ........................
        Entities entity48 = new Entities();
        entity48 = findBean.nameEntities("FinalDisposition",em);
        attributes29.setEntities(entity48);
//      ...................... String ........................
        AttributesTypes attributesTypes49 = new AttributesTypes();
        attributesTypes49 = findBean.nameAttributesTypes("String",em);
        attributes29.setAttributesTypes(attributesTypes49);
        em.persist(attributes29);
        em.flush();

        Entities entities30 = new Entities();
        entities30.setName("DocumentsTypes");
//      ...................... co.simasoft.models.core.archival ........................
        GroupIds groupId50 = new GroupIds();
        groupId50 = findBean.groupIdGroupIds("co.simasoft.models.core.archival",em);
        entities30.setGroupIds(groupId50);
        em.persist(entities30);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes31 = new Attributes();
        attributes31.setName("name");
        attributes31.setIsNullable(true);
        attributes31.setIsUnique(false);
//      ...................... DocumentsTypes ........................
        Entities entity51 = new Entities();
        entity51 = findBean.nameEntities("DocumentsTypes",em);
        attributes31.setEntities(entity51);
//      ...................... String ........................
        AttributesTypes attributesTypes52 = new AttributesTypes();
        attributesTypes52 = findBean.nameAttributesTypes("String",em);
        attributes31.setAttributesTypes(attributesTypes52);
        em.persist(attributes31);
        em.flush();

        Entities entities32 = new Entities();
        entities32.setName("Trd");
//      ...................... co.simasoft.models.core.archival ........................
        GroupIds groupId53 = new GroupIds();
        groupId53 = findBean.groupIdGroupIds("co.simasoft.models.core.archival",em);
        entities32.setGroupIds(groupId53);
        em.persist(entities32);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes33 = new Attributes();
        attributes33.setName("procedures");
        attributes33.setIsNullable(true);
        attributes33.setIsUnique(false);
//      ...................... Trd ........................
        Entities entity54 = new Entities();
        entity54 = findBean.nameEntities("Trd",em);
        attributes33.setEntities(entity54);
//      ...................... String ........................
        AttributesTypes attributesTypes55 = new AttributesTypes();
        attributesTypes55 = findBean.nameAttributesTypes("String",em);
        attributes33.setAttributesTypes(attributesTypes55);
        em.persist(attributes33);
        em.flush();

        Entities entities34 = new Entities();
        entities34.setName("OriginalOrder");
//      ...................... co.simasoft.models.core.archival ........................
        GroupIds groupId56 = new GroupIds();
        groupId56 = findBean.groupIdGroupIds("co.simasoft.models.core.archival",em);
        entities34.setGroupIds(groupId56);
        em.persist(entities34);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes35 = new Attributes();
        attributes35.setName("entryDate");
        attributes35.setIsNullable(true);
        attributes35.setIsUnique(false);
//      ...................... OriginalOrder ........................
        Entities entity57 = new Entities();
        entity57 = findBean.nameEntities("OriginalOrder",em);
        attributes35.setEntities(entity57);
//      ...................... Date ........................
        AttributesTypes attributesTypes58 = new AttributesTypes();
        attributesTypes58 = findBean.nameAttributesTypes("Date",em);
        attributes35.setAttributesTypes(attributesTypes58);
        em.persist(attributes35);
        em.flush();

        Attributes attributes36 = new Attributes();
        attributes36.setName("startDate");
        attributes36.setIsNullable(true);
        attributes36.setIsUnique(false);
//      ...................... OriginalOrder ........................
        Entities entity59 = new Entities();
        entity59 = findBean.nameEntities("OriginalOrder",em);
        attributes36.setEntities(entity59);
//      ...................... Date ........................
        AttributesTypes attributesTypes60 = new AttributesTypes();
        attributesTypes60 = findBean.nameAttributesTypes("Date",em);
        attributes36.setAttributesTypes(attributesTypes60);
        em.persist(attributes36);
        em.flush();

        Attributes attributes37 = new Attributes();
        attributes37.setName("finalDate");
        attributes37.setIsNullable(true);
        attributes37.setIsUnique(false);
//      ...................... OriginalOrder ........................
        Entities entity61 = new Entities();
        entity61 = findBean.nameEntities("OriginalOrder",em);
        attributes37.setEntities(entity61);
//      ...................... Date ........................
        AttributesTypes attributesTypes62 = new AttributesTypes();
        attributesTypes62 = findBean.nameAttributesTypes("Date",em);
        attributes37.setAttributesTypes(attributesTypes62);
        em.persist(attributes37);
        em.flush();

        Attributes attributes38 = new Attributes();
        attributes38.setName("folios");
        attributes38.setIsNullable(true);
        attributes38.setIsUnique(false);
//      ...................... OriginalOrder ........................
        Entities entity63 = new Entities();
        entity63 = findBean.nameEntities("OriginalOrder",em);
        attributes38.setEntities(entity63);
//      ...................... Integer ........................
        AttributesTypes attributesTypes64 = new AttributesTypes();
        attributesTypes64 = findBean.nameAttributesTypes("Integer",em);
        attributes38.setAttributesTypes(attributesTypes64);
        em.persist(attributes38);
        em.flush();

        Attributes attributes39 = new Attributes();
        attributes39.setName("located");
        attributes39.setIsNullable(true);
        attributes39.setIsUnique(false);
//      ...................... OriginalOrder ........................
        Entities entity65 = new Entities();
        entity65 = findBean.nameEntities("OriginalOrder",em);
        attributes39.setEntities(entity65);
//      ...................... String ........................
        AttributesTypes attributesTypes66 = new AttributesTypes();
        attributesTypes66 = findBean.nameAttributesTypes("String",em);
        attributes39.setAttributesTypes(attributesTypes66);
        em.persist(attributes39);
        em.flush();

        Entities entities40 = new Entities();
        entities40.setName("SectionsTypes");
//      ...................... co.simasoft.models.core.archival ........................
        GroupIds groupId67 = new GroupIds();
        groupId67 = findBean.groupIdGroupIds("co.simasoft.models.core.archival",em);
        entities40.setGroupIds(groupId67);
        em.persist(entities40);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes41 = new Attributes();
        attributes41.setName("name");
        attributes41.setIsNullable(true);
        attributes41.setIsUnique(false);
//      ...................... SectionsTypes ........................
        Entities entity68 = new Entities();
        entity68 = findBean.nameEntities("SectionsTypes",em);
        attributes41.setEntities(entity68);
//      ...................... String ........................
        AttributesTypes attributesTypes69 = new AttributesTypes();
        attributesTypes69 = findBean.nameAttributesTypes("String",em);
        attributes41.setAttributesTypes(attributesTypes69);
        em.persist(attributes41);
        em.flush();

        Entities entities42 = new Entities();
        entities42.setName("FrequentlyQuery");
//      ...................... co.simasoft.models.core.archival ........................
        GroupIds groupId70 = new GroupIds();
        groupId70 = findBean.groupIdGroupIds("co.simasoft.models.core.archival",em);
        entities42.setGroupIds(groupId70);
        em.persist(entities42);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes43 = new Attributes();
        attributes43.setName("name");
        attributes43.setIsNullable(true);
        attributes43.setIsUnique(false);
//      ...................... FrequentlyQuery ........................
        Entities entity71 = new Entities();
        entity71 = findBean.nameEntities("FrequentlyQuery",em);
        attributes43.setEntities(entity71);
//      ...................... Integer ........................
        AttributesTypes attributesTypes72 = new AttributesTypes();
        attributesTypes72 = findBean.nameAttributesTypes("Integer",em);
        attributes43.setAttributesTypes(attributesTypes72);
        em.persist(attributes43);
        em.flush();

        Entities entities44 = new Entities();
        entities44.setName("Funds");
//      ...................... co.simasoft.models.core.archival ........................
        GroupIds groupId73 = new GroupIds();
        groupId73 = findBean.groupIdGroupIds("co.simasoft.models.core.archival",em);
        entities44.setGroupIds(groupId73);
        em.persist(entities44);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes45 = new Attributes();
        attributes45.setName("code");
        attributes45.setIsNullable(true);
        attributes45.setIsUnique(false);
//      ...................... Funds ........................
        Entities entity74 = new Entities();
        entity74 = findBean.nameEntities("Funds",em);
        attributes45.setEntities(entity74);
//      ...................... String ........................
        AttributesTypes attributesTypes75 = new AttributesTypes();
        attributesTypes75 = findBean.nameAttributesTypes("String",em);
        attributes45.setAttributesTypes(attributesTypes75);
        em.persist(attributes45);
        em.flush();

        Attributes attributes46 = new Attributes();
        attributes46.setName("name");
        attributes46.setIsNullable(true);
        attributes46.setIsUnique(false);
//      ...................... Funds ........................
        Entities entity76 = new Entities();
        entity76 = findBean.nameEntities("Funds",em);
        attributes46.setEntities(entity76);
//      ...................... String ........................
        AttributesTypes attributesTypes77 = new AttributesTypes();
        attributesTypes77 = findBean.nameAttributesTypes("String",em);
        attributes46.setAttributesTypes(attributesTypes77);
        em.persist(attributes46);
        em.flush();

        Entities entities47 = new Entities();
        entities47.setName("Sections");
//      ...................... co.simasoft.models.core.archival ........................
        GroupIds groupId78 = new GroupIds();
        groupId78 = findBean.groupIdGroupIds("co.simasoft.models.core.archival",em);
        entities47.setGroupIds(groupId78);
        em.persist(entities47);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes48 = new Attributes();
        attributes48.setName("code");
        attributes48.setIsNullable(true);
        attributes48.setIsUnique(false);
//      ...................... Sections ........................
        Entities entity79 = new Entities();
        entity79 = findBean.nameEntities("Sections",em);
        attributes48.setEntities(entity79);
//      ...................... String ........................
        AttributesTypes attributesTypes80 = new AttributesTypes();
        attributesTypes80 = findBean.nameAttributesTypes("String",em);
        attributes48.setAttributesTypes(attributesTypes80);
        em.persist(attributes48);
        em.flush();

        Attributes attributes49 = new Attributes();
        attributes49.setName("name");
        attributes49.setIsNullable(true);
        attributes49.setIsUnique(false);
//      ...................... Sections ........................
        Entities entity81 = new Entities();
        entity81 = findBean.nameEntities("Sections",em);
        attributes49.setEntities(entity81);
//      ...................... String ........................
        AttributesTypes attributesTypes82 = new AttributesTypes();
        attributesTypes82 = findBean.nameAttributesTypes("String",em);
        attributes49.setAttributesTypes(attributesTypes82);
        em.persist(attributes49);
        em.flush();

        Attributes attributes50 = new Attributes();
        attributes50.setName("email");
        attributes50.setIsNullable(true);
        attributes50.setIsUnique(false);
//      ...................... Sections ........................
        Entities entity83 = new Entities();
        entity83 = findBean.nameEntities("Sections",em);
        attributes50.setEntities(entity83);
//      ...................... String ........................
        AttributesTypes attributesTypes84 = new AttributesTypes();
        attributesTypes84 = findBean.nameAttributesTypes("String",em);
        attributes50.setAttributesTypes(attributesTypes84);
        em.persist(attributes50);
        em.flush();

        Entities entities51 = new Entities();
        entities51.setName("InventoryFinality");
//      ...................... co.simasoft.models.core.archival ........................
        GroupIds groupId85 = new GroupIds();
        groupId85 = findBean.groupIdGroupIds("co.simasoft.models.core.archival",em);
        entities51.setGroupIds(groupId85);
        em.persist(entities51);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes52 = new Attributes();
        attributes52.setName("name");
        attributes52.setIsNullable(true);
        attributes52.setIsUnique(false);
//      ...................... InventoryFinality ........................
        Entities entity86 = new Entities();
        entity86 = findBean.nameEntities("InventoryFinality",em);
        attributes52.setEntities(entity86);
//      ...................... String ........................
        AttributesTypes attributesTypes87 = new AttributesTypes();
        attributesTypes87 = findBean.nameAttributesTypes("String",em);
        attributes52.setAttributesTypes(attributesTypes87);
        em.persist(attributes52);
        em.flush();

        Entities entities53 = new Entities();
        entities53.setName("ConservationUnits");
//      ...................... co.simasoft.models.core.archival ........................
        GroupIds groupId88 = new GroupIds();
        groupId88 = findBean.groupIdGroupIds("co.simasoft.models.core.archival",em);
        entities53.setGroupIds(groupId88);
        em.persist(entities53);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes54 = new Attributes();
        attributes54.setName("code");
        attributes54.setIsNullable(true);
        attributes54.setIsUnique(false);
//      ...................... ConservationUnits ........................
        Entities entity89 = new Entities();
        entity89 = findBean.nameEntities("ConservationUnits",em);
        attributes54.setEntities(entity89);
//      ...................... String ........................
        AttributesTypes attributesTypes90 = new AttributesTypes();
        attributesTypes90 = findBean.nameAttributesTypes("String",em);
        attributes54.setAttributesTypes(attributesTypes90);
        em.persist(attributes54);
        em.flush();

        Attributes attributes55 = new Attributes();
        attributes55.setName("name");
        attributes55.setIsNullable(true);
        attributes55.setIsUnique(false);
//      ...................... ConservationUnits ........................
        Entities entity91 = new Entities();
        entity91 = findBean.nameEntities("ConservationUnits",em);
        attributes55.setEntities(entity91);
//      ...................... String ........................
        AttributesTypes attributesTypes92 = new AttributesTypes();
        attributesTypes92 = findBean.nameAttributesTypes("String",em);
        attributes55.setAttributesTypes(attributesTypes92);
        em.persist(attributes55);
        em.flush();

        Entities entities56 = new Entities();
        entities56.setName("DocumentalInventory");
//      ...................... co.simasoft.models.core.archival ........................
        GroupIds groupId93 = new GroupIds();
        groupId93 = findBean.groupIdGroupIds("co.simasoft.models.core.archival",em);
        entities56.setGroupIds(groupId93);
        em.persist(entities56);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes57 = new Attributes();
        attributes57.setName("folios");
        attributes57.setIsNullable(true);
        attributes57.setIsUnique(false);
//      ...................... DocumentalInventory ........................
        Entities entity94 = new Entities();
        entity94 = findBean.nameEntities("DocumentalInventory",em);
        attributes57.setEntities(entity94);
//      ...................... Integer ........................
        AttributesTypes attributesTypes95 = new AttributesTypes();
        attributesTypes95 = findBean.nameAttributesTypes("Integer",em);
        attributes57.setAttributesTypes(attributesTypes95);
        em.persist(attributes57);
        em.flush();

        Attributes attributes58 = new Attributes();
        attributes58.setName("quantity");
        attributes58.setIsNullable(true);
        attributes58.setIsUnique(false);
//      ...................... DocumentalInventory ........................
        Entities entity96 = new Entities();
        entity96 = findBean.nameEntities("DocumentalInventory",em);
        attributes58.setEntities(entity96);
//      ...................... Integer ........................
        AttributesTypes attributesTypes97 = new AttributesTypes();
        attributesTypes97 = findBean.nameAttributesTypes("Integer",em);
        attributes58.setAttributesTypes(attributesTypes97);
        em.persist(attributes58);
        em.flush();

        Attributes attributes59 = new Attributes();
        attributes59.setName("startDate");
        attributes59.setIsNullable(true);
        attributes59.setIsUnique(false);
//      ...................... DocumentalInventory ........................
        Entities entity98 = new Entities();
        entity98 = findBean.nameEntities("DocumentalInventory",em);
        attributes59.setEntities(entity98);
//      ...................... Date ........................
        AttributesTypes attributesTypes99 = new AttributesTypes();
        attributesTypes99 = findBean.nameAttributesTypes("Date",em);
        attributes59.setAttributesTypes(attributesTypes99);
        em.persist(attributes59);
        em.flush();

        Attributes attributes60 = new Attributes();
        attributes60.setName("finalDate");
        attributes60.setIsNullable(true);
        attributes60.setIsUnique(false);
//      ...................... DocumentalInventory ........................
        Entities entity100 = new Entities();
        entity100 = findBean.nameEntities("DocumentalInventory",em);
        attributes60.setEntities(entity100);
//      ...................... Date ........................
        AttributesTypes attributesTypes101 = new AttributesTypes();
        attributesTypes101 = findBean.nameAttributesTypes("Date",em);
        attributes60.setAttributesTypes(attributesTypes101);
        em.persist(attributes60);
        em.flush();

        Attributes attributes61 = new Attributes();
        attributes61.setName("debugDate");
        attributes61.setIsNullable(true);
        attributes61.setIsUnique(false);
//      ...................... DocumentalInventory ........................
        Entities entity102 = new Entities();
        entity102 = findBean.nameEntities("DocumentalInventory",em);
        attributes61.setEntities(entity102);
//      ...................... Date ........................
        AttributesTypes attributesTypes103 = new AttributesTypes();
        attributesTypes103 = findBean.nameAttributesTypes("Date",em);
        attributes61.setAttributesTypes(attributesTypes103);
        em.persist(attributes61);
        em.flush();

        Attributes attributes62 = new Attributes();
        attributes62.setName("finalDisposition");
        attributes62.setIsNullable(true);
        attributes62.setIsUnique(false);
//      ...................... DocumentalInventory ........................
        Entities entity104 = new Entities();
        entity104 = findBean.nameEntities("DocumentalInventory",em);
        attributes62.setEntities(entity104);
//      ...................... String ........................
        AttributesTypes attributesTypes105 = new AttributesTypes();
        attributesTypes105 = findBean.nameAttributesTypes("String",em);
        attributes62.setAttributesTypes(attributesTypes105);
        em.persist(attributes62);
        em.flush();

        Attributes attributes63 = new Attributes();
        attributes63.setName("deliveryDate");
        attributes63.setIsNullable(true);
        attributes63.setIsUnique(false);
//      ...................... DocumentalInventory ........................
        Entities entity106 = new Entities();
        entity106 = findBean.nameEntities("DocumentalInventory",em);
        attributes63.setEntities(entity106);
//      ...................... Date ........................
        AttributesTypes attributesTypes107 = new AttributesTypes();
        attributesTypes107 = findBean.nameAttributesTypes("Date",em);
        attributes63.setAttributesTypes(attributesTypes107);
        em.persist(attributes63);
        em.flush();

        Attributes attributes64 = new Attributes();
        attributes64.setName("transferNumber");
        attributes64.setIsNullable(true);
        attributes64.setIsUnique(false);
//      ...................... DocumentalInventory ........................
        Entities entity108 = new Entities();
        entity108 = findBean.nameEntities("DocumentalInventory",em);
        attributes64.setEntities(entity108);
//      ...................... Integer ........................
        AttributesTypes attributesTypes109 = new AttributesTypes();
        attributesTypes109 = findBean.nameAttributesTypes("Integer",em);
        attributes64.setAttributesTypes(attributesTypes109);
        em.persist(attributes64);
        em.flush();

        Entities entities65 = new Entities();
        entities65.setName("Brands");
//      ...................... co.simasoft.models.core.companies ........................
        GroupIds groupId110 = new GroupIds();
        groupId110 = findBean.groupIdGroupIds("co.simasoft.models.core.companies",em);
        entities65.setGroupIds(groupId110);
        em.persist(entities65);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes66 = new Attributes();
        attributes66.setName("name");
        attributes66.setIsNullable(true);
        attributes66.setIsUnique(false);
//      ...................... Brands ........................
        Entities entity111 = new Entities();
        entity111 = findBean.nameEntities("Brands",em);
        attributes66.setEntities(entity111);
//      ...................... String ........................
        AttributesTypes attributesTypes112 = new AttributesTypes();
        attributesTypes112 = findBean.nameAttributesTypes("String",em);
        attributes66.setAttributesTypes(attributesTypes112);
        em.persist(attributes66);
        em.flush();

        Entities entities67 = new Entities();
        entities67.setName("Companies");
//      ...................... co.simasoft.models.core.companies ........................
        GroupIds groupId113 = new GroupIds();
        groupId113 = findBean.groupIdGroupIds("co.simasoft.models.core.companies",em);
        entities67.setGroupIds(groupId113);
        em.persist(entities67);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes68 = new Attributes();
        attributes68.setName("address");
        attributes68.setIsNullable(true);
        attributes68.setIsUnique(false);
//      ...................... Companies ........................
        Entities entity114 = new Entities();
        entity114 = findBean.nameEntities("Companies",em);
        attributes68.setEntities(entity114);
//      ...................... String ........................
        AttributesTypes attributesTypes115 = new AttributesTypes();
        attributesTypes115 = findBean.nameAttributesTypes("String",em);
        attributes68.setAttributesTypes(attributesTypes115);
        em.persist(attributes68);
        em.flush();

        Attributes attributes69 = new Attributes();
        attributes69.setName("nit");
        attributes69.setIsNullable(true);
        attributes69.setIsUnique(false);
//      ...................... Companies ........................
        Entities entity116 = new Entities();
        entity116 = findBean.nameEntities("Companies",em);
        attributes69.setEntities(entity116);
//      ...................... String ........................
        AttributesTypes attributesTypes117 = new AttributesTypes();
        attributesTypes117 = findBean.nameAttributesTypes("String",em);
        attributes69.setAttributesTypes(attributesTypes117);
        em.persist(attributes69);
        em.flush();

        Attributes attributes70 = new Attributes();
        attributes70.setName("email");
        attributes70.setIsNullable(true);
        attributes70.setIsUnique(false);
//      ...................... Companies ........................
        Entities entity118 = new Entities();
        entity118 = findBean.nameEntities("Companies",em);
        attributes70.setEntities(entity118);
//      ...................... String ........................
        AttributesTypes attributesTypes119 = new AttributesTypes();
        attributesTypes119 = findBean.nameAttributesTypes("String",em);
        attributes70.setAttributesTypes(attributesTypes119);
        em.persist(attributes70);
        em.flush();

        Attributes attributes71 = new Attributes();
        attributes71.setName("telephones");
        attributes71.setIsNullable(true);
        attributes71.setIsUnique(false);
//      ...................... Companies ........................
        Entities entity120 = new Entities();
        entity120 = findBean.nameEntities("Companies",em);
        attributes71.setEntities(entity120);
//      ...................... String ........................
        AttributesTypes attributesTypes121 = new AttributesTypes();
        attributesTypes121 = findBean.nameAttributesTypes("String",em);
        attributes71.setAttributesTypes(attributesTypes121);
        em.persist(attributes71);
        em.flush();

        Attributes attributes72 = new Attributes();
        attributes72.setName("name");
        attributes72.setIsNullable(true);
        attributes72.setIsUnique(false);
//      ...................... Companies ........................
        Entities entity122 = new Entities();
        entity122 = findBean.nameEntities("Companies",em);
        attributes72.setEntities(entity122);
//      ...................... String ........................
        AttributesTypes attributesTypes123 = new AttributesTypes();
        attributesTypes123 = findBean.nameAttributesTypes("String",em);
        attributes72.setAttributesTypes(attributesTypes123);
        em.persist(attributes72);
        em.flush();

        Entities entities73 = new Entities();
        entities73.setName("RegulationsText");
//      ...................... co.simasoft.models.core.regulations ........................
        GroupIds groupId124 = new GroupIds();
        groupId124 = findBean.groupIdGroupIds("co.simasoft.models.core.regulations",em);
        entities73.setGroupIds(groupId124);
        em.persist(entities73);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes74 = new Attributes();
        attributes74.setName("name");
        attributes74.setIsNullable(true);
        attributes74.setIsUnique(false);
//      ...................... RegulationsText ........................
        Entities entity125 = new Entities();
        entity125 = findBean.nameEntities("RegulationsText",em);
        attributes74.setEntities(entity125);
//      ...................... String ........................
        AttributesTypes attributesTypes126 = new AttributesTypes();
        attributesTypes126 = findBean.nameAttributesTypes("String",em);
        attributes74.setAttributesTypes(attributesTypes126);
        em.persist(attributes74);
        em.flush();

        Attributes attributes75 = new Attributes();
        attributes75.setName("code");
        attributes75.setIsNullable(true);
        attributes75.setIsUnique(false);
//      ...................... RegulationsText ........................
        Entities entity127 = new Entities();
        entity127 = findBean.nameEntities("RegulationsText",em);
        attributes75.setEntities(entity127);
//      ...................... String ........................
        AttributesTypes attributesTypes128 = new AttributesTypes();
        attributesTypes128 = findBean.nameAttributesTypes("String",em);
        attributes75.setAttributesTypes(attributesTypes128);
        em.persist(attributes75);
        em.flush();

        Attributes attributes76 = new Attributes();
        attributes76.setName("text");
        attributes76.setIsNullable(true);
        attributes76.setIsUnique(false);
//      ...................... RegulationsText ........................
        Entities entity129 = new Entities();
        entity129 = findBean.nameEntities("RegulationsText",em);
        attributes76.setEntities(entity129);
//      ...................... String ........................
        AttributesTypes attributesTypes130 = new AttributesTypes();
        attributesTypes130 = findBean.nameAttributesTypes("String",em);
        attributes76.setAttributesTypes(attributesTypes130);
        em.persist(attributes76);
        em.flush();

        Entities entities77 = new Entities();
        entities77.setName("RegulationsTypes");
//      ...................... co.simasoft.models.core.regulations ........................
        GroupIds groupId131 = new GroupIds();
        groupId131 = findBean.groupIdGroupIds("co.simasoft.models.core.regulations",em);
        entities77.setGroupIds(groupId131);
        em.persist(entities77);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes78 = new Attributes();
        attributes78.setName("name");
        attributes78.setIsNullable(true);
        attributes78.setIsUnique(false);
//      ...................... RegulationsTypes ........................
        Entities entity132 = new Entities();
        entity132 = findBean.nameEntities("RegulationsTypes",em);
        attributes78.setEntities(entity132);
//      ...................... String ........................
        AttributesTypes attributesTypes133 = new AttributesTypes();
        attributesTypes133 = findBean.nameAttributesTypes("String",em);
        attributes78.setAttributesTypes(attributesTypes133);
        em.persist(attributes78);
        em.flush();

        Entities entities79 = new Entities();
        entities79.setName("Regulations");
//      ...................... co.simasoft.models.core.regulations ........................
        GroupIds groupId134 = new GroupIds();
        groupId134 = findBean.groupIdGroupIds("co.simasoft.models.core.regulations",em);
        entities79.setGroupIds(groupId134);
        em.persist(entities79);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes80 = new Attributes();
        attributes80.setName("date");
        attributes80.setIsNullable(true);
        attributes80.setIsUnique(false);
//      ...................... Regulations ........................
        Entities entity135 = new Entities();
        entity135 = findBean.nameEntities("Regulations",em);
        attributes80.setEntities(entity135);
//      ...................... Date ........................
        AttributesTypes attributesTypes136 = new AttributesTypes();
        attributesTypes136 = findBean.nameAttributesTypes("Date",em);
        attributes80.setAttributesTypes(attributesTypes136);
        em.persist(attributes80);
        em.flush();

        Attributes attributes81 = new Attributes();
        attributes81.setName("name");
        attributes81.setIsNullable(true);
        attributes81.setIsUnique(false);
//      ...................... Regulations ........................
        Entities entity137 = new Entities();
        entity137 = findBean.nameEntities("Regulations",em);
        attributes81.setEntities(entity137);
//      ...................... String ........................
        AttributesTypes attributesTypes138 = new AttributesTypes();
        attributesTypes138 = findBean.nameAttributesTypes("String",em);
        attributes81.setAttributesTypes(attributesTypes138);
        em.persist(attributes81);
        em.flush();

        Entities entities82 = new Entities();
        entities82.setName("Sites");
//      ...................... co.simasoft.models.core.sites ........................
        GroupIds groupId139 = new GroupIds();
        groupId139 = findBean.groupIdGroupIds("co.simasoft.models.core.sites",em);
        entities82.setGroupIds(groupId139);
        em.persist(entities82);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes83 = new Attributes();
        attributes83.setName("abc");
        attributes83.setIsNullable(true);
        attributes83.setIsUnique(false);
//      ...................... Sites ........................
        Entities entity140 = new Entities();
        entity140 = findBean.nameEntities("Sites",em);
        attributes83.setEntities(entity140);
//      ...................... String ........................
        AttributesTypes attributesTypes141 = new AttributesTypes();
        attributesTypes141 = findBean.nameAttributesTypes("String",em);
        attributes83.setAttributesTypes(attributesTypes141);
        em.persist(attributes83);
        em.flush();

        Attributes attributes84 = new Attributes();
        attributes84.setName("link");
        attributes84.setIsNullable(false);
        attributes84.setIsUnique(true);
//      ...................... Sites ........................
        Entities entity142 = new Entities();
        entity142 = findBean.nameEntities("Sites",em);
        attributes84.setEntities(entity142);
//      ...................... String ........................
        AttributesTypes attributesTypes143 = new AttributesTypes();
        attributesTypes143 = findBean.nameAttributesTypes("String",em);
        attributes84.setAttributesTypes(attributesTypes143);
        em.persist(attributes84);
        em.flush();

        Attributes attributes85 = new Attributes();
        attributes85.setName("title");
        attributes85.setIsNullable(true);
        attributes85.setIsUnique(false);
//      ...................... Sites ........................
        Entities entity144 = new Entities();
        entity144 = findBean.nameEntities("Sites",em);
        attributes85.setEntities(entity144);
//      ...................... String ........................
        AttributesTypes attributesTypes145 = new AttributesTypes();
        attributesTypes145 = findBean.nameAttributesTypes("String",em);
        attributes85.setAttributesTypes(attributesTypes145);
        em.persist(attributes85);
        em.flush();

        Entities entities86 = new Entities();
        entities86.setName("SitesTypes");
//      ...................... co.simasoft.models.core.sites ........................
        GroupIds groupId146 = new GroupIds();
        groupId146 = findBean.groupIdGroupIds("co.simasoft.models.core.sites",em);
        entities86.setGroupIds(groupId146);
        em.persist(entities86);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes87 = new Attributes();
        attributes87.setName("name");
        attributes87.setIsNullable(true);
        attributes87.setIsUnique(false);
//      ...................... SitesTypes ........................
        Entities entity147 = new Entities();
        entity147 = findBean.nameEntities("SitesTypes",em);
        attributes87.setEntities(entity147);
//      ...................... String ........................
        AttributesTypes attributesTypes148 = new AttributesTypes();
        attributesTypes148 = findBean.nameAttributesTypes("String",em);
        attributes87.setAttributesTypes(attributesTypes148);
        em.persist(attributes87);
        em.flush();

//      ---------------------- Relationships ------------------------

/*
. BooksTypes . 1..* Books
. BooksTypes . *..* Sites
. BooksTypes . 1..* BooksTypes
. Books . 1..* Chapters
. Books . *..* Sites
. Chapters . 1..* Chapters
. Chapters . 1..* RegulationsText
. Chapters . *..* Sites
. Series . 1..* DocumentalsUnits
. Series . *..* FinalDisposition
. Series . 1..* Chapters
. Series . 1..* RegulationsText
. Series . 1..* Sites
. Series . 1..* Series
. DocumentalsUnits . 1..* OriginalOrder
. DocumentalsUnits . 1..* DocumentalInventory
. DocumentalsSupports . 1..* OriginalOrder
. DocumentalRetention . 1..* Trd
. DocumentalRetention . 1..* Trd
. FundsLife . 1..* Funds
. DocumentsTypes . 1..* OriginalOrder
. DocumentsTypes . 1..* Series
. Trd . 1..* Series
. OriginalOrder . 1..* Sites
. SectionsTypes . 1..* Sections
. FrequentlyQuery . 1..* DocumentalsUnits
. Funds . 1..* Sections
. Sections . 1..* Sections
. Sections . 1..* Series
. InventoryFinality . 1..* DocumentalInventory
. ConservationUnits . 1..* DocumentalsUnits
. Brands . 1..* RegulationsText
. Brands . 1..* Sites
. Companies . 1..* Sites
. Companies . 1..* Funds
. Companies . 1..* Brands
. Companies . 1..* Companies
. Companies . 1..* RegulationsText
. RegulationsText . 1..* RegulationsText
. RegulationsTypes . 1..* Regulations
. RegulationsTypes . 1..* RegulationsTypes
. Regulations . 1..* RegulationsText
. Regulations . 1..* Sites
. SitesTypes . *..* Sites
. SitesTypes . 1..* SitesTypes
*/
        Relationships relationships1 = new Relationships();
        relationships1.setIsOptionality(true);
        relationships1.setIsEmbedded(false);
        relationships1.setName("");
//      ...................... BooksTypes ........................
        Entities entities149 = new Entities();
        entities149 = findBean.nameEntities("BooksTypes",em);
        relationships1.setFrom(entities149);
//      ...................... Books ........................
        Entities entities150 = new Entities();
        entities150 = findBean.nameEntities("Books",em);
        relationships1.setTo(entities150);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities151 = new Cardinalities();
        cardinalities151 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships1.setCardinalities(cardinalities151);
        em.persist(relationships1);
        em.flush();

        Relationships relationships2 = new Relationships();
        relationships2.setIsOptionality(true);
        relationships2.setIsEmbedded(false);
        relationships2.setName("");
//      ...................... BooksTypes ........................
        Entities entities152 = new Entities();
        entities152 = findBean.nameEntities("BooksTypes",em);
        relationships2.setFrom(entities152);
//      ...................... Sites ........................
        Entities entities153 = new Entities();
        entities153 = findBean.nameEntities("Sites",em);
        relationships2.setTo(entities153);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities154 = new Cardinalities();
        cardinalities154 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships2.setCardinalities(cardinalities154);
        em.persist(relationships2);
        em.flush();

        Relationships relationships3 = new Relationships();
        relationships3.setIsOptionality(true);
        relationships3.setIsEmbedded(false);
        relationships3.setName("");
//      ...................... BooksTypes ........................
        Entities entities155 = new Entities();
        entities155 = findBean.nameEntities("BooksTypes",em);
        relationships3.setFrom(entities155);
//      ...................... BooksTypes ........................
        Entities entities156 = new Entities();
        entities156 = findBean.nameEntities("BooksTypes",em);
        relationships3.setTo(entities156);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities157 = new Cardinalities();
        cardinalities157 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships3.setCardinalities(cardinalities157);
        em.persist(relationships3);
        em.flush();

        Relationships relationships4 = new Relationships();
        relationships4.setIsOptionality(true);
        relationships4.setIsEmbedded(false);
        relationships4.setName("");
//      ...................... Books ........................
        Entities entities158 = new Entities();
        entities158 = findBean.nameEntities("Books",em);
        relationships4.setFrom(entities158);
//      ...................... Chapters ........................
        Entities entities159 = new Entities();
        entities159 = findBean.nameEntities("Chapters",em);
        relationships4.setTo(entities159);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities160 = new Cardinalities();
        cardinalities160 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships4.setCardinalities(cardinalities160);
        em.persist(relationships4);
        em.flush();

        Relationships relationships5 = new Relationships();
        relationships5.setIsOptionality(true);
        relationships5.setIsEmbedded(false);
        relationships5.setName("");
//      ...................... Books ........................
        Entities entities161 = new Entities();
        entities161 = findBean.nameEntities("Books",em);
        relationships5.setFrom(entities161);
//      ...................... Sites ........................
        Entities entities162 = new Entities();
        entities162 = findBean.nameEntities("Sites",em);
        relationships5.setTo(entities162);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities163 = new Cardinalities();
        cardinalities163 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships5.setCardinalities(cardinalities163);
        em.persist(relationships5);
        em.flush();

        Relationships relationships6 = new Relationships();
        relationships6.setIsOptionality(true);
        relationships6.setIsEmbedded(false);
        relationships6.setName("");
//      ...................... Chapters ........................
        Entities entities164 = new Entities();
        entities164 = findBean.nameEntities("Chapters",em);
        relationships6.setFrom(entities164);
//      ...................... Chapters ........................
        Entities entities165 = new Entities();
        entities165 = findBean.nameEntities("Chapters",em);
        relationships6.setTo(entities165);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities166 = new Cardinalities();
        cardinalities166 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships6.setCardinalities(cardinalities166);
        em.persist(relationships6);
        em.flush();

        Relationships relationships7 = new Relationships();
        relationships7.setIsOptionality(true);
        relationships7.setIsEmbedded(false);
        relationships7.setName("");
//      ...................... Chapters ........................
        Entities entities167 = new Entities();
        entities167 = findBean.nameEntities("Chapters",em);
        relationships7.setFrom(entities167);
//      ...................... RegulationsText ........................
        Entities entities168 = new Entities();
        entities168 = findBean.nameEntities("RegulationsText",em);
        relationships7.setTo(entities168);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities169 = new Cardinalities();
        cardinalities169 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships7.setCardinalities(cardinalities169);
        em.persist(relationships7);
        em.flush();

        Relationships relationships8 = new Relationships();
        relationships8.setIsOptionality(true);
        relationships8.setIsEmbedded(false);
        relationships8.setName("");
//      ...................... Chapters ........................
        Entities entities170 = new Entities();
        entities170 = findBean.nameEntities("Chapters",em);
        relationships8.setFrom(entities170);
//      ...................... Sites ........................
        Entities entities171 = new Entities();
        entities171 = findBean.nameEntities("Sites",em);
        relationships8.setTo(entities171);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities172 = new Cardinalities();
        cardinalities172 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships8.setCardinalities(cardinalities172);
        em.persist(relationships8);
        em.flush();

        Relationships relationships9 = new Relationships();
        relationships9.setIsOptionality(true);
        relationships9.setIsEmbedded(false);
        relationships9.setName("");
//      ...................... Series ........................
        Entities entities173 = new Entities();
        entities173 = findBean.nameEntities("Series",em);
        relationships9.setFrom(entities173);
//      ...................... DocumentalsUnits ........................
        Entities entities174 = new Entities();
        entities174 = findBean.nameEntities("DocumentalsUnits",em);
        relationships9.setTo(entities174);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities175 = new Cardinalities();
        cardinalities175 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships9.setCardinalities(cardinalities175);
        em.persist(relationships9);
        em.flush();

        Relationships relationships10 = new Relationships();
        relationships10.setIsOptionality(true);
        relationships10.setIsEmbedded(false);
        relationships10.setName("");
//      ...................... Series ........................
        Entities entities176 = new Entities();
        entities176 = findBean.nameEntities("Series",em);
        relationships10.setFrom(entities176);
//      ...................... FinalDisposition ........................
        Entities entities177 = new Entities();
        entities177 = findBean.nameEntities("FinalDisposition",em);
        relationships10.setTo(entities177);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities178 = new Cardinalities();
        cardinalities178 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships10.setCardinalities(cardinalities178);
        em.persist(relationships10);
        em.flush();

        Relationships relationships11 = new Relationships();
        relationships11.setIsOptionality(true);
        relationships11.setIsEmbedded(false);
        relationships11.setName("");
//      ...................... Series ........................
        Entities entities179 = new Entities();
        entities179 = findBean.nameEntities("Series",em);
        relationships11.setFrom(entities179);
//      ...................... Chapters ........................
        Entities entities180 = new Entities();
        entities180 = findBean.nameEntities("Chapters",em);
        relationships11.setTo(entities180);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities181 = new Cardinalities();
        cardinalities181 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships11.setCardinalities(cardinalities181);
        em.persist(relationships11);
        em.flush();

        Relationships relationships12 = new Relationships();
        relationships12.setIsOptionality(true);
        relationships12.setIsEmbedded(false);
        relationships12.setName("");
//      ...................... Series ........................
        Entities entities182 = new Entities();
        entities182 = findBean.nameEntities("Series",em);
        relationships12.setFrom(entities182);
//      ...................... RegulationsText ........................
        Entities entities183 = new Entities();
        entities183 = findBean.nameEntities("RegulationsText",em);
        relationships12.setTo(entities183);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities184 = new Cardinalities();
        cardinalities184 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships12.setCardinalities(cardinalities184);
        em.persist(relationships12);
        em.flush();

        Relationships relationships13 = new Relationships();
        relationships13.setIsOptionality(true);
        relationships13.setIsEmbedded(false);
        relationships13.setName("");
//      ...................... Series ........................
        Entities entities185 = new Entities();
        entities185 = findBean.nameEntities("Series",em);
        relationships13.setFrom(entities185);
//      ...................... Sites ........................
        Entities entities186 = new Entities();
        entities186 = findBean.nameEntities("Sites",em);
        relationships13.setTo(entities186);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities187 = new Cardinalities();
        cardinalities187 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships13.setCardinalities(cardinalities187);
        em.persist(relationships13);
        em.flush();

        Relationships relationships14 = new Relationships();
        relationships14.setIsOptionality(true);
        relationships14.setIsEmbedded(false);
        relationships14.setName("");
//      ...................... Series ........................
        Entities entities188 = new Entities();
        entities188 = findBean.nameEntities("Series",em);
        relationships14.setFrom(entities188);
//      ...................... Series ........................
        Entities entities189 = new Entities();
        entities189 = findBean.nameEntities("Series",em);
        relationships14.setTo(entities189);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities190 = new Cardinalities();
        cardinalities190 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships14.setCardinalities(cardinalities190);
        em.persist(relationships14);
        em.flush();

        Relationships relationships15 = new Relationships();
        relationships15.setIsOptionality(true);
        relationships15.setIsEmbedded(false);
        relationships15.setName("");
//      ...................... DocumentalsUnits ........................
        Entities entities191 = new Entities();
        entities191 = findBean.nameEntities("DocumentalsUnits",em);
        relationships15.setFrom(entities191);
//      ...................... OriginalOrder ........................
        Entities entities192 = new Entities();
        entities192 = findBean.nameEntities("OriginalOrder",em);
        relationships15.setTo(entities192);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities193 = new Cardinalities();
        cardinalities193 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships15.setCardinalities(cardinalities193);
        em.persist(relationships15);
        em.flush();

        Relationships relationships16 = new Relationships();
        relationships16.setIsOptionality(true);
        relationships16.setIsEmbedded(false);
        relationships16.setName("");
//      ...................... DocumentalsUnits ........................
        Entities entities194 = new Entities();
        entities194 = findBean.nameEntities("DocumentalsUnits",em);
        relationships16.setFrom(entities194);
//      ...................... DocumentalInventory ........................
        Entities entities195 = new Entities();
        entities195 = findBean.nameEntities("DocumentalInventory",em);
        relationships16.setTo(entities195);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities196 = new Cardinalities();
        cardinalities196 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships16.setCardinalities(cardinalities196);
        em.persist(relationships16);
        em.flush();

        Relationships relationships17 = new Relationships();
        relationships17.setIsOptionality(true);
        relationships17.setIsEmbedded(false);
        relationships17.setName("");
//      ...................... DocumentalsSupports ........................
        Entities entities197 = new Entities();
        entities197 = findBean.nameEntities("DocumentalsSupports",em);
        relationships17.setFrom(entities197);
//      ...................... OriginalOrder ........................
        Entities entities198 = new Entities();
        entities198 = findBean.nameEntities("OriginalOrder",em);
        relationships17.setTo(entities198);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities199 = new Cardinalities();
        cardinalities199 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships17.setCardinalities(cardinalities199);
        em.persist(relationships17);
        em.flush();

        Relationships relationships18 = new Relationships();
        relationships18.setIsOptionality(true);
        relationships18.setIsEmbedded(false);
        relationships18.setName("");
//      ...................... DocumentalRetention ........................
        Entities entities200 = new Entities();
        entities200 = findBean.nameEntities("DocumentalRetention",em);
        relationships18.setFrom(entities200);
//      ...................... Trd ........................
        Entities entities201 = new Entities();
        entities201 = findBean.nameEntities("Trd",em);
        relationships18.setTo(entities201);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities202 = new Cardinalities();
        cardinalities202 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships18.setCardinalities(cardinalities202);
        em.persist(relationships18);
        em.flush();

        Relationships relationships19 = new Relationships();
        relationships19.setIsOptionality(true);
        relationships19.setIsEmbedded(false);
        relationships19.setName("");
//      ...................... DocumentalRetention ........................
        Entities entities203 = new Entities();
        entities203 = findBean.nameEntities("DocumentalRetention",em);
        relationships19.setFrom(entities203);
//      ...................... Trd ........................
        Entities entities204 = new Entities();
        entities204 = findBean.nameEntities("Trd",em);
        relationships19.setTo(entities204);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities205 = new Cardinalities();
        cardinalities205 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships19.setCardinalities(cardinalities205);
        em.persist(relationships19);
        em.flush();

        Relationships relationships20 = new Relationships();
        relationships20.setIsOptionality(true);
        relationships20.setIsEmbedded(false);
        relationships20.setName("");
//      ...................... FundsLife ........................
        Entities entities206 = new Entities();
        entities206 = findBean.nameEntities("FundsLife",em);
        relationships20.setFrom(entities206);
//      ...................... Funds ........................
        Entities entities207 = new Entities();
        entities207 = findBean.nameEntities("Funds",em);
        relationships20.setTo(entities207);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities208 = new Cardinalities();
        cardinalities208 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships20.setCardinalities(cardinalities208);
        em.persist(relationships20);
        em.flush();

        Relationships relationships21 = new Relationships();
        relationships21.setIsOptionality(true);
        relationships21.setIsEmbedded(false);
        relationships21.setName("");
//      ...................... DocumentsTypes ........................
        Entities entities209 = new Entities();
        entities209 = findBean.nameEntities("DocumentsTypes",em);
        relationships21.setFrom(entities209);
//      ...................... OriginalOrder ........................
        Entities entities210 = new Entities();
        entities210 = findBean.nameEntities("OriginalOrder",em);
        relationships21.setTo(entities210);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities211 = new Cardinalities();
        cardinalities211 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships21.setCardinalities(cardinalities211);
        em.persist(relationships21);
        em.flush();

        Relationships relationships22 = new Relationships();
        relationships22.setIsOptionality(true);
        relationships22.setIsEmbedded(false);
        relationships22.setName("");
//      ...................... DocumentsTypes ........................
        Entities entities212 = new Entities();
        entities212 = findBean.nameEntities("DocumentsTypes",em);
        relationships22.setFrom(entities212);
//      ...................... Series ........................
        Entities entities213 = new Entities();
        entities213 = findBean.nameEntities("Series",em);
        relationships22.setTo(entities213);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities214 = new Cardinalities();
        cardinalities214 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships22.setCardinalities(cardinalities214);
        em.persist(relationships22);
        em.flush();

        Relationships relationships23 = new Relationships();
        relationships23.setIsOptionality(true);
        relationships23.setIsEmbedded(false);
        relationships23.setName("");
//      ...................... Trd ........................
        Entities entities215 = new Entities();
        entities215 = findBean.nameEntities("Trd",em);
        relationships23.setFrom(entities215);
//      ...................... Series ........................
        Entities entities216 = new Entities();
        entities216 = findBean.nameEntities("Series",em);
        relationships23.setTo(entities216);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities217 = new Cardinalities();
        cardinalities217 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships23.setCardinalities(cardinalities217);
        em.persist(relationships23);
        em.flush();

        Relationships relationships24 = new Relationships();
        relationships24.setIsOptionality(true);
        relationships24.setIsEmbedded(false);
        relationships24.setName("");
//      ...................... OriginalOrder ........................
        Entities entities218 = new Entities();
        entities218 = findBean.nameEntities("OriginalOrder",em);
        relationships24.setFrom(entities218);
//      ...................... Sites ........................
        Entities entities219 = new Entities();
        entities219 = findBean.nameEntities("Sites",em);
        relationships24.setTo(entities219);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities220 = new Cardinalities();
        cardinalities220 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships24.setCardinalities(cardinalities220);
        em.persist(relationships24);
        em.flush();

        Relationships relationships25 = new Relationships();
        relationships25.setIsOptionality(true);
        relationships25.setIsEmbedded(false);
        relationships25.setName("");
//      ...................... SectionsTypes ........................
        Entities entities221 = new Entities();
        entities221 = findBean.nameEntities("SectionsTypes",em);
        relationships25.setFrom(entities221);
//      ...................... Sections ........................
        Entities entities222 = new Entities();
        entities222 = findBean.nameEntities("Sections",em);
        relationships25.setTo(entities222);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities223 = new Cardinalities();
        cardinalities223 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships25.setCardinalities(cardinalities223);
        em.persist(relationships25);
        em.flush();

        Relationships relationships26 = new Relationships();
        relationships26.setIsOptionality(true);
        relationships26.setIsEmbedded(false);
        relationships26.setName("");
//      ...................... FrequentlyQuery ........................
        Entities entities224 = new Entities();
        entities224 = findBean.nameEntities("FrequentlyQuery",em);
        relationships26.setFrom(entities224);
//      ...................... DocumentalsUnits ........................
        Entities entities225 = new Entities();
        entities225 = findBean.nameEntities("DocumentalsUnits",em);
        relationships26.setTo(entities225);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities226 = new Cardinalities();
        cardinalities226 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships26.setCardinalities(cardinalities226);
        em.persist(relationships26);
        em.flush();

        Relationships relationships27 = new Relationships();
        relationships27.setIsOptionality(true);
        relationships27.setIsEmbedded(false);
        relationships27.setName("");
//      ...................... Funds ........................
        Entities entities227 = new Entities();
        entities227 = findBean.nameEntities("Funds",em);
        relationships27.setFrom(entities227);
//      ...................... Sections ........................
        Entities entities228 = new Entities();
        entities228 = findBean.nameEntities("Sections",em);
        relationships27.setTo(entities228);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities229 = new Cardinalities();
        cardinalities229 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships27.setCardinalities(cardinalities229);
        em.persist(relationships27);
        em.flush();

        Relationships relationships28 = new Relationships();
        relationships28.setIsOptionality(true);
        relationships28.setIsEmbedded(false);
        relationships28.setName("");
//      ...................... Sections ........................
        Entities entities230 = new Entities();
        entities230 = findBean.nameEntities("Sections",em);
        relationships28.setFrom(entities230);
//      ...................... Sections ........................
        Entities entities231 = new Entities();
        entities231 = findBean.nameEntities("Sections",em);
        relationships28.setTo(entities231);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities232 = new Cardinalities();
        cardinalities232 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships28.setCardinalities(cardinalities232);
        em.persist(relationships28);
        em.flush();

        Relationships relationships29 = new Relationships();
        relationships29.setIsOptionality(true);
        relationships29.setIsEmbedded(false);
        relationships29.setName("");
//      ...................... Sections ........................
        Entities entities233 = new Entities();
        entities233 = findBean.nameEntities("Sections",em);
        relationships29.setFrom(entities233);
//      ...................... Series ........................
        Entities entities234 = new Entities();
        entities234 = findBean.nameEntities("Series",em);
        relationships29.setTo(entities234);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities235 = new Cardinalities();
        cardinalities235 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships29.setCardinalities(cardinalities235);
        em.persist(relationships29);
        em.flush();

        Relationships relationships30 = new Relationships();
        relationships30.setIsOptionality(true);
        relationships30.setIsEmbedded(false);
        relationships30.setName("");
//      ...................... InventoryFinality ........................
        Entities entities236 = new Entities();
        entities236 = findBean.nameEntities("InventoryFinality",em);
        relationships30.setFrom(entities236);
//      ...................... DocumentalInventory ........................
        Entities entities237 = new Entities();
        entities237 = findBean.nameEntities("DocumentalInventory",em);
        relationships30.setTo(entities237);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities238 = new Cardinalities();
        cardinalities238 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships30.setCardinalities(cardinalities238);
        em.persist(relationships30);
        em.flush();

        Relationships relationships31 = new Relationships();
        relationships31.setIsOptionality(true);
        relationships31.setIsEmbedded(false);
        relationships31.setName("");
//      ...................... ConservationUnits ........................
        Entities entities239 = new Entities();
        entities239 = findBean.nameEntities("ConservationUnits",em);
        relationships31.setFrom(entities239);
//      ...................... DocumentalsUnits ........................
        Entities entities240 = new Entities();
        entities240 = findBean.nameEntities("DocumentalsUnits",em);
        relationships31.setTo(entities240);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities241 = new Cardinalities();
        cardinalities241 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships31.setCardinalities(cardinalities241);
        em.persist(relationships31);
        em.flush();

        Relationships relationships32 = new Relationships();
        relationships32.setIsOptionality(true);
        relationships32.setIsEmbedded(false);
        relationships32.setName("");
//      ...................... Brands ........................
        Entities entities242 = new Entities();
        entities242 = findBean.nameEntities("Brands",em);
        relationships32.setFrom(entities242);
//      ...................... RegulationsText ........................
        Entities entities243 = new Entities();
        entities243 = findBean.nameEntities("RegulationsText",em);
        relationships32.setTo(entities243);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities244 = new Cardinalities();
        cardinalities244 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships32.setCardinalities(cardinalities244);
        em.persist(relationships32);
        em.flush();

        Relationships relationships33 = new Relationships();
        relationships33.setIsOptionality(true);
        relationships33.setIsEmbedded(false);
        relationships33.setName("");
//      ...................... Brands ........................
        Entities entities245 = new Entities();
        entities245 = findBean.nameEntities("Brands",em);
        relationships33.setFrom(entities245);
//      ...................... Sites ........................
        Entities entities246 = new Entities();
        entities246 = findBean.nameEntities("Sites",em);
        relationships33.setTo(entities246);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities247 = new Cardinalities();
        cardinalities247 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships33.setCardinalities(cardinalities247);
        em.persist(relationships33);
        em.flush();

        Relationships relationships34 = new Relationships();
        relationships34.setIsOptionality(true);
        relationships34.setIsEmbedded(false);
        relationships34.setName("");
//      ...................... Companies ........................
        Entities entities248 = new Entities();
        entities248 = findBean.nameEntities("Companies",em);
        relationships34.setFrom(entities248);
//      ...................... Sites ........................
        Entities entities249 = new Entities();
        entities249 = findBean.nameEntities("Sites",em);
        relationships34.setTo(entities249);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities250 = new Cardinalities();
        cardinalities250 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships34.setCardinalities(cardinalities250);
        em.persist(relationships34);
        em.flush();

        Relationships relationships35 = new Relationships();
        relationships35.setIsOptionality(true);
        relationships35.setIsEmbedded(false);
        relationships35.setName("");
//      ...................... Companies ........................
        Entities entities251 = new Entities();
        entities251 = findBean.nameEntities("Companies",em);
        relationships35.setFrom(entities251);
//      ...................... Funds ........................
        Entities entities252 = new Entities();
        entities252 = findBean.nameEntities("Funds",em);
        relationships35.setTo(entities252);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities253 = new Cardinalities();
        cardinalities253 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships35.setCardinalities(cardinalities253);
        em.persist(relationships35);
        em.flush();

        Relationships relationships36 = new Relationships();
        relationships36.setIsOptionality(true);
        relationships36.setIsEmbedded(false);
        relationships36.setName("");
//      ...................... Companies ........................
        Entities entities254 = new Entities();
        entities254 = findBean.nameEntities("Companies",em);
        relationships36.setFrom(entities254);
//      ...................... Brands ........................
        Entities entities255 = new Entities();
        entities255 = findBean.nameEntities("Brands",em);
        relationships36.setTo(entities255);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities256 = new Cardinalities();
        cardinalities256 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships36.setCardinalities(cardinalities256);
        em.persist(relationships36);
        em.flush();

        Relationships relationships37 = new Relationships();
        relationships37.setIsOptionality(true);
        relationships37.setIsEmbedded(false);
        relationships37.setName("");
//      ...................... Companies ........................
        Entities entities257 = new Entities();
        entities257 = findBean.nameEntities("Companies",em);
        relationships37.setFrom(entities257);
//      ...................... Companies ........................
        Entities entities258 = new Entities();
        entities258 = findBean.nameEntities("Companies",em);
        relationships37.setTo(entities258);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities259 = new Cardinalities();
        cardinalities259 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships37.setCardinalities(cardinalities259);
        em.persist(relationships37);
        em.flush();

        Relationships relationships38 = new Relationships();
        relationships38.setIsOptionality(true);
        relationships38.setIsEmbedded(false);
        relationships38.setName("");
//      ...................... Companies ........................
        Entities entities260 = new Entities();
        entities260 = findBean.nameEntities("Companies",em);
        relationships38.setFrom(entities260);
//      ...................... RegulationsText ........................
        Entities entities261 = new Entities();
        entities261 = findBean.nameEntities("RegulationsText",em);
        relationships38.setTo(entities261);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities262 = new Cardinalities();
        cardinalities262 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships38.setCardinalities(cardinalities262);
        em.persist(relationships38);
        em.flush();

        Relationships relationships39 = new Relationships();
        relationships39.setIsOptionality(true);
        relationships39.setIsEmbedded(false);
        relationships39.setName("");
//      ...................... RegulationsText ........................
        Entities entities263 = new Entities();
        entities263 = findBean.nameEntities("RegulationsText",em);
        relationships39.setFrom(entities263);
//      ...................... RegulationsText ........................
        Entities entities264 = new Entities();
        entities264 = findBean.nameEntities("RegulationsText",em);
        relationships39.setTo(entities264);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities265 = new Cardinalities();
        cardinalities265 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships39.setCardinalities(cardinalities265);
        em.persist(relationships39);
        em.flush();

        Relationships relationships40 = new Relationships();
        relationships40.setIsOptionality(true);
        relationships40.setIsEmbedded(false);
        relationships40.setName("");
//      ...................... RegulationsTypes ........................
        Entities entities266 = new Entities();
        entities266 = findBean.nameEntities("RegulationsTypes",em);
        relationships40.setFrom(entities266);
//      ...................... Regulations ........................
        Entities entities267 = new Entities();
        entities267 = findBean.nameEntities("Regulations",em);
        relationships40.setTo(entities267);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities268 = new Cardinalities();
        cardinalities268 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships40.setCardinalities(cardinalities268);
        em.persist(relationships40);
        em.flush();

        Relationships relationships41 = new Relationships();
        relationships41.setIsOptionality(true);
        relationships41.setIsEmbedded(false);
        relationships41.setName("");
//      ...................... RegulationsTypes ........................
        Entities entities269 = new Entities();
        entities269 = findBean.nameEntities("RegulationsTypes",em);
        relationships41.setFrom(entities269);
//      ...................... RegulationsTypes ........................
        Entities entities270 = new Entities();
        entities270 = findBean.nameEntities("RegulationsTypes",em);
        relationships41.setTo(entities270);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities271 = new Cardinalities();
        cardinalities271 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships41.setCardinalities(cardinalities271);
        em.persist(relationships41);
        em.flush();

        Relationships relationships42 = new Relationships();
        relationships42.setIsOptionality(true);
        relationships42.setIsEmbedded(false);
        relationships42.setName("");
//      ...................... Regulations ........................
        Entities entities272 = new Entities();
        entities272 = findBean.nameEntities("Regulations",em);
        relationships42.setFrom(entities272);
//      ...................... RegulationsText ........................
        Entities entities273 = new Entities();
        entities273 = findBean.nameEntities("RegulationsText",em);
        relationships42.setTo(entities273);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities274 = new Cardinalities();
        cardinalities274 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships42.setCardinalities(cardinalities274);
        em.persist(relationships42);
        em.flush();

        Relationships relationships43 = new Relationships();
        relationships43.setIsOptionality(true);
        relationships43.setIsEmbedded(false);
        relationships43.setName("");
//      ...................... Regulations ........................
        Entities entities275 = new Entities();
        entities275 = findBean.nameEntities("Regulations",em);
        relationships43.setFrom(entities275);
//      ...................... Sites ........................
        Entities entities276 = new Entities();
        entities276 = findBean.nameEntities("Sites",em);
        relationships43.setTo(entities276);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities277 = new Cardinalities();
        cardinalities277 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships43.setCardinalities(cardinalities277);
        em.persist(relationships43);
        em.flush();

        Relationships relationships44 = new Relationships();
        relationships44.setIsOptionality(true);
        relationships44.setIsEmbedded(false);
        relationships44.setName("");
//      ...................... SitesTypes ........................
        Entities entities278 = new Entities();
        entities278 = findBean.nameEntities("SitesTypes",em);
        relationships44.setFrom(entities278);
//      ...................... Sites ........................
        Entities entities279 = new Entities();
        entities279 = findBean.nameEntities("Sites",em);
        relationships44.setTo(entities279);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities280 = new Cardinalities();
        cardinalities280 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships44.setCardinalities(cardinalities280);
        em.persist(relationships44);
        em.flush();

        Relationships relationships45 = new Relationships();
        relationships45.setIsOptionality(true);
        relationships45.setIsEmbedded(false);
        relationships45.setName("");
//      ...................... SitesTypes ........................
        Entities entities281 = new Entities();
        entities281 = findBean.nameEntities("SitesTypes",em);
        relationships45.setFrom(entities281);
//      ...................... SitesTypes ........................
        Entities entities282 = new Entities();
        entities282 = findBean.nameEntities("SitesTypes",em);
        relationships45.setTo(entities282);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities283 = new Cardinalities();
        cardinalities283 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships45.setCardinalities(cardinalities283);
        em.persist(relationships45);
        em.flush();

    } // data()

} // coreSetup
