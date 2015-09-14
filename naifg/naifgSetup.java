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
        models.setVersion("naifg");
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
        modelsGroupIds2.setIsSingle(false);
        modelsGroupIds2.setIsSimplified(false);
        em.persist(modelsGroupIds2);
        em.flush();

        ModelsGroupIds modelsGroupIds3 = new ModelsGroupIds();
        Models modelss3 = findBean.artifactIdModels("naifg",em);
        GroupIds groupIdd3 = findBean.artifactIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        modelsGroupIds3.setModels(modelss3);
        modelsGroupIds3.setGroupIds(groupIdd3);
        modelsGroupIds3.setIsSingle(false);
        modelsGroupIds3.setIsSimplified(false);
        em.persist(modelsGroupIds3);
        em.flush();

//      ---------------------- Developments ------------------------

        Developments dev = new Developments();
        dev.setGroupId("co.simasoft");
        dev.setArtifactId("naifg");
        dev.setVersion("1.0-SNAPSHOT");
        dev.setCode("");
        Set<Models> models1 = new HashSet<Models>();
        Models model1 = findBean.artifactIdModels("naifg",em);
        models1.add(model1);
        dev.setModels(models1);
        dev.setVersion("1.0-SNAPSHOT");
        dev.setCode("");
        em.persist(dev);
        em.flush();

//      ---------------------- Entities ------------------------

        Entities entities1 = new Entities();
        entities1.setName("Relationships");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId1 = new GroupIds();
        groupId1 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities1.setGroupIds(groupId1);
        em.persist(entities1);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes2 = new Attributes();
        attributes2.setName("isOptionality");
        attributes2.setIsNullable(true);
        attributes2.setIsUnique(false);
//      ...................... Relationships ........................
        Entities entity2 = new Entities();
        entity2 = findBean.nameEntities("Relationships",em);
        attributes2.setEntities(entity2);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes3 = new AttributesTypes();
        attributesTypes3 = findBean.nameAttributesTypes("Boolean",em);
        attributes2.setAttributesTypes(attributesTypes3);
        em.persist(attributes2);
        em.flush();

        Attributes attributes3 = new Attributes();
        attributes3.setName("isEmbedded");
        attributes3.setIsNullable(true);
        attributes3.setIsUnique(false);
//      ...................... Relationships ........................
        Entities entity4 = new Entities();
        entity4 = findBean.nameEntities("Relationships",em);
        attributes3.setEntities(entity4);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes5 = new AttributesTypes();
        attributesTypes5 = findBean.nameAttributesTypes("Boolean",em);
        attributes3.setAttributesTypes(attributesTypes5);
        em.persist(attributes3);
        em.flush();

        Attributes attributes4 = new Attributes();
        attributes4.setName("isSimplified");
        attributes4.setIsNullable(true);
        attributes4.setIsUnique(false);
//      ...................... Relationships ........................
        Entities entity6 = new Entities();
        entity6 = findBean.nameEntities("Relationships",em);
        attributes4.setEntities(entity6);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes7 = new AttributesTypes();
        attributesTypes7 = findBean.nameAttributesTypes("Boolean",em);
        attributes4.setAttributesTypes(attributesTypes7);
        em.persist(attributes4);
        em.flush();

        Attributes attributes5 = new Attributes();
        attributes5.setName("isSearch");
        attributes5.setIsNullable(true);
        attributes5.setIsUnique(false);
//      ...................... Relationships ........................
        Entities entity8 = new Entities();
        entity8 = findBean.nameEntities("Relationships",em);
        attributes5.setEntities(entity8);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes9 = new AttributesTypes();
        attributesTypes9 = findBean.nameAttributesTypes("Boolean",em);
        attributes5.setAttributesTypes(attributesTypes9);
        em.persist(attributes5);
        em.flush();

        Attributes attributes6 = new Attributes();
        attributes6.setName("isCreate");
        attributes6.setIsNullable(true);
        attributes6.setIsUnique(false);
//      ...................... Relationships ........................
        Entities entity10 = new Entities();
        entity10 = findBean.nameEntities("Relationships",em);
        attributes6.setEntities(entity10);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes11 = new AttributesTypes();
        attributesTypes11 = findBean.nameAttributesTypes("Boolean",em);
        attributes6.setAttributesTypes(attributesTypes11);
        em.persist(attributes6);
        em.flush();

        Attributes attributes7 = new Attributes();
        attributes7.setName("name");
        attributes7.setIsNullable(true);
        attributes7.setIsUnique(false);
//      ...................... Relationships ........................
        Entities entity12 = new Entities();
        entity12 = findBean.nameEntities("Relationships",em);
        attributes7.setEntities(entity12);
//      ...................... String ........................
        AttributesTypes attributesTypes13 = new AttributesTypes();
        attributesTypes13 = findBean.nameAttributesTypes("String",em);
        attributes7.setAttributesTypes(attributesTypes13);
        em.persist(attributes7);
        em.flush();

        Attributes attributes8 = new Attributes();
        attributes8.setName("isView");
        attributes8.setIsNullable(true);
        attributes8.setIsUnique(false);
//      ...................... Relationships ........................
        Entities entity14 = new Entities();
        entity14 = findBean.nameEntities("Relationships",em);
        attributes8.setEntities(entity14);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes15 = new AttributesTypes();
        attributesTypes15 = findBean.nameAttributesTypes("Boolean",em);
        attributes8.setAttributesTypes(attributesTypes15);
        em.persist(attributes8);
        em.flush();

        Entities entities9 = new Entities();
        entities9.setName("NameQueries");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId16 = new GroupIds();
        groupId16 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities9.setGroupIds(groupId16);
        em.persist(entities9);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes10 = new Attributes();
        attributes10.setName("name");
        attributes10.setIsNullable(false);
        attributes10.setIsUnique(true);
//      ...................... NameQueries ........................
        Entities entity17 = new Entities();
        entity17 = findBean.nameEntities("NameQueries",em);
        attributes10.setEntities(entity17);
//      ...................... String ........................
        AttributesTypes attributesTypes18 = new AttributesTypes();
        attributesTypes18 = findBean.nameAttributesTypes("String",em);
        attributes10.setAttributesTypes(attributesTypes18);
        em.persist(attributes10);
        em.flush();

        Attributes attributes11 = new Attributes();
        attributes11.setName("query");
        attributes11.setIsNullable(false);
        attributes11.setIsUnique(true);
//      ...................... NameQueries ........................
        Entities entity19 = new Entities();
        entity19 = findBean.nameEntities("NameQueries",em);
        attributes11.setEntities(entity19);
//      ...................... String ........................
        AttributesTypes attributesTypes20 = new AttributesTypes();
        attributesTypes20 = findBean.nameAttributesTypes("String",em);
        attributes11.setAttributesTypes(attributesTypes20);
        em.persist(attributes11);
        em.flush();

        Entities entities12 = new Entities();
        entities12.setName("Cardinalities");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId21 = new GroupIds();
        groupId21 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities12.setGroupIds(groupId21);
        em.persist(entities12);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes13 = new Attributes();
        attributes13.setName("cardinality");
        attributes13.setIsNullable(false);
        attributes13.setIsUnique(false);
//      ...................... Cardinalities ........................
        Entities entity22 = new Entities();
        entity22 = findBean.nameEntities("Cardinalities",em);
        attributes13.setEntities(entity22);
//      ...................... String ........................
        AttributesTypes attributesTypes23 = new AttributesTypes();
        attributesTypes23 = findBean.nameAttributesTypes("String",em);
        attributes13.setAttributesTypes(attributesTypes23);
        em.persist(attributes13);
        em.flush();

        Attributes attributes14 = new Attributes();
        attributes14.setName("name");
        attributes14.setIsNullable(false);
        attributes14.setIsUnique(true);
//      ...................... Cardinalities ........................
        Entities entity24 = new Entities();
        entity24 = findBean.nameEntities("Cardinalities",em);
        attributes14.setEntities(entity24);
//      ...................... String ........................
        AttributesTypes attributesTypes25 = new AttributesTypes();
        attributesTypes25 = findBean.nameAttributesTypes("String",em);
        attributes14.setAttributesTypes(attributesTypes25);
        em.persist(attributes14);
        em.flush();

        Attributes attributes15 = new Attributes();
        attributes15.setName("isUnidirectional");
        attributes15.setIsNullable(true);
        attributes15.setIsUnique(false);
//      ...................... Cardinalities ........................
        Entities entity26 = new Entities();
        entity26 = findBean.nameEntities("Cardinalities",em);
        attributes15.setEntities(entity26);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes27 = new AttributesTypes();
        attributesTypes27 = findBean.nameAttributesTypes("Boolean",em);
        attributes15.setAttributesTypes(attributesTypes27);
        em.persist(attributes15);
        em.flush();

        Entities entities16 = new Entities();
        entities16.setName("Attributes");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId28 = new GroupIds();
        groupId28 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities16.setGroupIds(groupId28);
        em.persist(entities16);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes17 = new Attributes();
        attributes17.setName("isCreate");
        attributes17.setIsNullable(true);
        attributes17.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity29 = new Entities();
        entity29 = findBean.nameEntities("Attributes",em);
        attributes17.setEntities(entity29);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes30 = new AttributesTypes();
        attributesTypes30 = findBean.nameAttributesTypes("Boolean",em);
        attributes17.setAttributesTypes(attributesTypes30);
        em.persist(attributes17);
        em.flush();

        Attributes attributes18 = new Attributes();
        attributes18.setName("isSimplified");
        attributes18.setIsNullable(true);
        attributes18.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity31 = new Entities();
        entity31 = findBean.nameEntities("Attributes",em);
        attributes18.setEntities(entity31);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes32 = new AttributesTypes();
        attributesTypes32 = findBean.nameAttributesTypes("Boolean",em);
        attributes18.setAttributesTypes(attributesTypes32);
        em.persist(attributes18);
        em.flush();

        Attributes attributes19 = new Attributes();
        attributes19.setName("isView");
        attributes19.setIsNullable(true);
        attributes19.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity33 = new Entities();
        entity33 = findBean.nameEntities("Attributes",em);
        attributes19.setEntities(entity33);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes34 = new AttributesTypes();
        attributesTypes34 = findBean.nameAttributesTypes("Boolean",em);
        attributes19.setAttributesTypes(attributesTypes34);
        em.persist(attributes19);
        em.flush();

        Attributes attributes20 = new Attributes();
        attributes20.setName("isSearch");
        attributes20.setIsNullable(true);
        attributes20.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity35 = new Entities();
        entity35 = findBean.nameEntities("Attributes",em);
        attributes20.setEntities(entity35);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes36 = new AttributesTypes();
        attributesTypes36 = findBean.nameAttributesTypes("Boolean",em);
        attributes20.setAttributesTypes(attributesTypes36);
        em.persist(attributes20);
        em.flush();

        Attributes attributes21 = new Attributes();
        attributes21.setName("isViewRelation");
        attributes21.setIsNullable(true);
        attributes21.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity37 = new Entities();
        entity37 = findBean.nameEntities("Attributes",em);
        attributes21.setEntities(entity37);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes38 = new AttributesTypes();
        attributesTypes38 = findBean.nameAttributesTypes("Boolean",em);
        attributes21.setAttributesTypes(attributesTypes38);
        em.persist(attributes21);
        em.flush();

        Attributes attributes22 = new Attributes();
        attributes22.setName("isViewColumn");
        attributes22.setIsNullable(true);
        attributes22.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity39 = new Entities();
        entity39 = findBean.nameEntities("Attributes",em);
        attributes22.setEntities(entity39);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes40 = new AttributesTypes();
        attributesTypes40 = findBean.nameAttributesTypes("Boolean",em);
        attributes22.setAttributesTypes(attributesTypes40);
        em.persist(attributes22);
        em.flush();

        Attributes attributes23 = new Attributes();
        attributes23.setName("name");
        attributes23.setIsNullable(false);
        attributes23.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity41 = new Entities();
        entity41 = findBean.nameEntities("Attributes",em);
        attributes23.setEntities(entity41);
//      ...................... String ........................
        AttributesTypes attributesTypes42 = new AttributesTypes();
        attributesTypes42 = findBean.nameAttributesTypes("String",em);
        attributes23.setAttributesTypes(attributesTypes42);
        em.persist(attributes23);
        em.flush();

        Attributes attributes24 = new Attributes();
        attributes24.setName("description");
        attributes24.setIsNullable(true);
        attributes24.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity43 = new Entities();
        entity43 = findBean.nameEntities("Attributes",em);
        attributes24.setEntities(entity43);
//      ...................... String ........................
        AttributesTypes attributesTypes44 = new AttributesTypes();
        attributesTypes44 = findBean.nameAttributesTypes("String",em);
        attributes24.setAttributesTypes(attributesTypes44);
        em.persist(attributes24);
        em.flush();

        Attributes attributes25 = new Attributes();
        attributes25.setName("length");
        attributes25.setIsNullable(true);
        attributes25.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity45 = new Entities();
        entity45 = findBean.nameEntities("Attributes",em);
        attributes25.setEntities(entity45);
//      ...................... Integer ........................
        AttributesTypes attributesTypes46 = new AttributesTypes();
        attributesTypes46 = findBean.nameAttributesTypes("Integer",em);
        attributes25.setAttributesTypes(attributesTypes46);
        em.persist(attributes25);
        em.flush();

        Attributes attributes26 = new Attributes();
        attributes26.setName("precision");
        attributes26.setIsNullable(true);
        attributes26.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity47 = new Entities();
        entity47 = findBean.nameEntities("Attributes",em);
        attributes26.setEntities(entity47);
//      ...................... Integer ........................
        AttributesTypes attributesTypes48 = new AttributesTypes();
        attributesTypes48 = findBean.nameAttributesTypes("Integer",em);
        attributes26.setAttributesTypes(attributesTypes48);
        em.persist(attributes26);
        em.flush();

        Attributes attributes27 = new Attributes();
        attributes27.setName("isNullable");
        attributes27.setIsNullable(true);
        attributes27.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity49 = new Entities();
        entity49 = findBean.nameEntities("Attributes",em);
        attributes27.setEntities(entity49);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes50 = new AttributesTypes();
        attributesTypes50 = findBean.nameAttributesTypes("Boolean",em);
        attributes27.setAttributesTypes(attributesTypes50);
        em.persist(attributes27);
        em.flush();

        Attributes attributes28 = new Attributes();
        attributes28.setName("isUnique");
        attributes28.setIsNullable(true);
        attributes28.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity51 = new Entities();
        entity51 = findBean.nameEntities("Attributes",em);
        attributes28.setEntities(entity51);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes52 = new AttributesTypes();
        attributesTypes52 = findBean.nameAttributesTypes("Boolean",em);
        attributes28.setAttributesTypes(attributesTypes52);
        em.persist(attributes28);
        em.flush();

        Entities entities29 = new Entities();
        entities29.setName("GroupIdsFiles");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId53 = new GroupIds();
        groupId53 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities29.setGroupIds(groupId53);
        em.persist(entities29);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes30 = new Attributes();
        attributes30.setName("name");
        attributes30.setIsNullable(false);
        attributes30.setIsUnique(true);
//      ...................... GroupIdsFiles ........................
        Entities entity54 = new Entities();
        entity54 = findBean.nameEntities("GroupIdsFiles",em);
        attributes30.setEntities(entity54);
//      ...................... String ........................
        AttributesTypes attributesTypes55 = new AttributesTypes();
        attributesTypes55 = findBean.nameAttributesTypes("String",em);
        attributes30.setAttributesTypes(attributesTypes55);
        em.persist(attributes30);
        em.flush();

        Attributes attributes31 = new Attributes();
        attributes31.setName("type");
        attributes31.setIsNullable(false);
        attributes31.setIsUnique(false);
//      ...................... GroupIdsFiles ........................
        Entities entity56 = new Entities();
        entity56 = findBean.nameEntities("GroupIdsFiles",em);
        attributes31.setEntities(entity56);
//      ...................... String ........................
        AttributesTypes attributesTypes57 = new AttributesTypes();
        attributesTypes57 = findBean.nameAttributesTypes("String",em);
        attributes31.setAttributesTypes(attributesTypes57);
        em.persist(attributes31);
        em.flush();

        Attributes attributes32 = new Attributes();
        attributes32.setName("data");
        attributes32.setIsNullable(false);
        attributes32.setIsUnique(false);
//      ...................... GroupIdsFiles ........................
        Entities entity58 = new Entities();
        entity58 = findBean.nameEntities("GroupIdsFiles",em);
        attributes32.setEntities(entity58);
//      ...................... Blob ........................
        AttributesTypes attributesTypes59 = new AttributesTypes();
        attributesTypes59 = findBean.nameAttributesTypes("Blob",em);
        attributes32.setAttributesTypes(attributesTypes59);
        em.persist(attributes32);
        em.flush();

        Entities entities33 = new Entities();
        entities33.setName("Developments");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId60 = new GroupIds();
        groupId60 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities33.setGroupIds(groupId60);
        em.persist(entities33);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes34 = new Attributes();
        attributes34.setName("date");
        attributes34.setIsNullable(true);
        attributes34.setIsUnique(false);
//      ...................... Developments ........................
        Entities entity61 = new Entities();
        entity61 = findBean.nameEntities("Developments",em);
        attributes34.setEntities(entity61);
//      ...................... Date ........................
        AttributesTypes attributesTypes62 = new AttributesTypes();
        attributesTypes62 = findBean.nameAttributesTypes("Date",em);
        attributes34.setAttributesTypes(attributesTypes62);
        em.persist(attributes34);
        em.flush();

        Attributes attributes35 = new Attributes();
        attributes35.setName("artifactId");
        attributes35.setIsNullable(false);
        attributes35.setIsUnique(true);
//      ...................... Developments ........................
        Entities entity63 = new Entities();
        entity63 = findBean.nameEntities("Developments",em);
        attributes35.setEntities(entity63);
//      ...................... String ........................
        AttributesTypes attributesTypes64 = new AttributesTypes();
        attributesTypes64 = findBean.nameAttributesTypes("String",em);
        attributes35.setAttributesTypes(attributesTypes64);
        em.persist(attributes35);
        em.flush();

        Attributes attributes36 = new Attributes();
        attributes36.setName("groupId");
        attributes36.setIsNullable(true);
        attributes36.setIsUnique(false);
//      ...................... Developments ........................
        Entities entity65 = new Entities();
        entity65 = findBean.nameEntities("Developments",em);
        attributes36.setEntities(entity65);
//      ...................... String ........................
        AttributesTypes attributesTypes66 = new AttributesTypes();
        attributesTypes66 = findBean.nameAttributesTypes("String",em);
        attributes36.setAttributesTypes(attributesTypes66);
        em.persist(attributes36);
        em.flush();

        Attributes attributes37 = new Attributes();
        attributes37.setName("code");
        attributes37.setIsNullable(true);
        attributes37.setIsUnique(false);
//      ...................... Developments ........................
        Entities entity67 = new Entities();
        entity67 = findBean.nameEntities("Developments",em);
        attributes37.setEntities(entity67);
//      ...................... String ........................
        AttributesTypes attributesTypes68 = new AttributesTypes();
        attributesTypes68 = findBean.nameAttributesTypes("String",em);
        attributes37.setAttributesTypes(attributesTypes68);
        em.persist(attributes37);
        em.flush();

        Attributes attributes38 = new Attributes();
        attributes38.setName("version");
        attributes38.setIsNullable(true);
        attributes38.setIsUnique(false);
//      ...................... Developments ........................
        Entities entity69 = new Entities();
        entity69 = findBean.nameEntities("Developments",em);
        attributes38.setEntities(entity69);
//      ...................... String ........................
        AttributesTypes attributesTypes70 = new AttributesTypes();
        attributesTypes70 = findBean.nameAttributesTypes("String",em);
        attributes38.setAttributesTypes(attributesTypes70);
        em.persist(attributes38);
        em.flush();

        Entities entities39 = new Entities();
        entities39.setName("Models");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId71 = new GroupIds();
        groupId71 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities39.setGroupIds(groupId71);
        em.persist(entities39);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes40 = new Attributes();
        attributes40.setName("version");
        attributes40.setIsNullable(true);
        attributes40.setIsUnique(false);
//      ...................... Models ........................
        Entities entity72 = new Entities();
        entity72 = findBean.nameEntities("Models",em);
        attributes40.setEntities(entity72);
//      ...................... String ........................
        AttributesTypes attributesTypes73 = new AttributesTypes();
        attributesTypes73 = findBean.nameAttributesTypes("String",em);
        attributes40.setAttributesTypes(attributesTypes73);
        em.persist(attributes40);
        em.flush();

        Attributes attributes41 = new Attributes();
        attributes41.setName("groupId");
        attributes41.setIsNullable(false);
        attributes41.setIsUnique(true);
//      ...................... Models ........................
        Entities entity74 = new Entities();
        entity74 = findBean.nameEntities("Models",em);
        attributes41.setEntities(entity74);
//      ...................... String ........................
        AttributesTypes attributesTypes75 = new AttributesTypes();
        attributesTypes75 = findBean.nameAttributesTypes("String",em);
        attributes41.setAttributesTypes(attributesTypes75);
        em.persist(attributes41);
        em.flush();

        Attributes attributes42 = new Attributes();
        attributes42.setName("artifactId");
        attributes42.setIsNullable(false);
        attributes42.setIsUnique(true);
//      ...................... Models ........................
        Entities entity76 = new Entities();
        entity76 = findBean.nameEntities("Models",em);
        attributes42.setEntities(entity76);
//      ...................... String ........................
        AttributesTypes attributesTypes77 = new AttributesTypes();
        attributesTypes77 = findBean.nameAttributesTypes("String",em);
        attributes42.setAttributesTypes(attributesTypes77);
        em.persist(attributes42);
        em.flush();

        Attributes attributes43 = new Attributes();
        attributes43.setName("date");
        attributes43.setIsNullable(true);
        attributes43.setIsUnique(false);
//      ...................... Models ........................
        Entities entity78 = new Entities();
        entity78 = findBean.nameEntities("Models",em);
        attributes43.setEntities(entity78);
//      ...................... Date ........................
        AttributesTypes attributesTypes79 = new AttributesTypes();
        attributesTypes79 = findBean.nameAttributesTypes("Date",em);
        attributes43.setAttributesTypes(attributesTypes79);
        em.persist(attributes43);
        em.flush();

        Attributes attributes44 = new Attributes();
        attributes44.setName("code");
        attributes44.setIsNullable(true);
        attributes44.setIsUnique(false);
//      ...................... Models ........................
        Entities entity80 = new Entities();
        entity80 = findBean.nameEntities("Models",em);
        attributes44.setEntities(entity80);
//      ...................... String ........................
        AttributesTypes attributesTypes81 = new AttributesTypes();
        attributesTypes81 = findBean.nameAttributesTypes("String",em);
        attributes44.setAttributesTypes(attributesTypes81);
        em.persist(attributes44);
        em.flush();

        Entities entities45 = new Entities();
        entities45.setName("GroupIdsEntities");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId82 = new GroupIds();
        groupId82 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities45.setGroupIds(groupId82);
        em.persist(entities45);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes46 = new Attributes();
        attributes46.setName("isSimplified");
        attributes46.setIsNullable(true);
        attributes46.setIsUnique(false);
//      ...................... GroupIdsEntities ........................
        Entities entity83 = new Entities();
        entity83 = findBean.nameEntities("GroupIdsEntities",em);
        attributes46.setEntities(entity83);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes84 = new AttributesTypes();
        attributesTypes84 = findBean.nameAttributesTypes("Boolean",em);
        attributes46.setAttributesTypes(attributesTypes84);
        em.persist(attributes46);
        em.flush();

        Entities entities47 = new Entities();
        entities47.setName("Entities");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId85 = new GroupIds();
        groupId85 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities47.setGroupIds(groupId85);
        em.persist(entities47);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes48 = new Attributes();
        attributes48.setName("name");
        attributes48.setIsNullable(false);
        attributes48.setIsUnique(true);
//      ...................... Entities ........................
        Entities entity86 = new Entities();
        entity86 = findBean.nameEntities("Entities",em);
        attributes48.setEntities(entity86);
//      ...................... String ........................
        AttributesTypes attributesTypes87 = new AttributesTypes();
        attributesTypes87 = findBean.nameAttributesTypes("String",em);
        attributes48.setAttributesTypes(attributesTypes87);
        em.persist(attributes48);
        em.flush();

        Attributes attributes49 = new Attributes();
        attributes49.setName("serialID");
        attributes49.setIsNullable(true);
        attributes49.setIsUnique(false);
//      ...................... Entities ........................
        Entities entity88 = new Entities();
        entity88 = findBean.nameEntities("Entities",em);
        attributes49.setEntities(entity88);
//      ...................... String ........................
        AttributesTypes attributesTypes89 = new AttributesTypes();
        attributesTypes89 = findBean.nameAttributesTypes("String",em);
        attributes49.setAttributesTypes(attributesTypes89);
        em.persist(attributes49);
        em.flush();

        Attributes attributes50 = new Attributes();
        attributes50.setName("table");
        attributes50.setIsNullable(true);
        attributes50.setIsUnique(false);
//      ...................... Entities ........................
        Entities entity90 = new Entities();
        entity90 = findBean.nameEntities("Entities",em);
        attributes50.setEntities(entity90);
//      ...................... String ........................
        AttributesTypes attributesTypes91 = new AttributesTypes();
        attributesTypes91 = findBean.nameAttributesTypes("String",em);
        attributes50.setAttributesTypes(attributesTypes91);
        em.persist(attributes50);
        em.flush();

        Attributes attributes51 = new Attributes();
        attributes51.setName("description");
        attributes51.setIsNullable(true);
        attributes51.setIsUnique(false);
//      ...................... Entities ........................
        Entities entity92 = new Entities();
        entity92 = findBean.nameEntities("Entities",em);
        attributes51.setEntities(entity92);
//      ...................... String ........................
        AttributesTypes attributesTypes93 = new AttributesTypes();
        attributesTypes93 = findBean.nameAttributesTypes("String",em);
        attributes51.setAttributesTypes(attributesTypes93);
        em.persist(attributes51);
        em.flush();

        Entities entities52 = new Entities();
        entities52.setName("ModelsGroupIds");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId94 = new GroupIds();
        groupId94 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities52.setGroupIds(groupId94);
        em.persist(entities52);
        em.flush();

//      ---------------------- Attributes ------------------------

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
        attributes54.setName("isIsolated");
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
        entities55.setName("GroupIds");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId99 = new GroupIds();
        groupId99 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities55.setGroupIds(groupId99);
        em.persist(entities55);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes56 = new Attributes();
        attributes56.setName("date");
        attributes56.setIsNullable(true);
        attributes56.setIsUnique(false);
//      ...................... GroupIds ........................
        Entities entity100 = new Entities();
        entity100 = findBean.nameEntities("GroupIds",em);
        attributes56.setEntities(entity100);
//      ...................... Date ........................
        AttributesTypes attributesTypes101 = new AttributesTypes();
        attributesTypes101 = findBean.nameAttributesTypes("Date",em);
        attributes56.setAttributesTypes(attributesTypes101);
        em.persist(attributes56);
        em.flush();

        Attributes attributes57 = new Attributes();
        attributes57.setName("version");
        attributes57.setIsNullable(true);
        attributes57.setIsUnique(false);
//      ...................... GroupIds ........................
        Entities entity102 = new Entities();
        entity102 = findBean.nameEntities("GroupIds",em);
        attributes57.setEntities(entity102);
//      ...................... String ........................
        AttributesTypes attributesTypes103 = new AttributesTypes();
        attributesTypes103 = findBean.nameAttributesTypes("String",em);
        attributes57.setAttributesTypes(attributesTypes103);
        em.persist(attributes57);
        em.flush();

        Attributes attributes58 = new Attributes();
        attributes58.setName("code");
        attributes58.setIsNullable(true);
        attributes58.setIsUnique(false);
//      ...................... GroupIds ........................
        Entities entity104 = new Entities();
        entity104 = findBean.nameEntities("GroupIds",em);
        attributes58.setEntities(entity104);
//      ...................... String ........................
        AttributesTypes attributesTypes105 = new AttributesTypes();
        attributesTypes105 = findBean.nameAttributesTypes("String",em);
        attributes58.setAttributesTypes(attributesTypes105);
        em.persist(attributes58);
        em.flush();

        Attributes attributes59 = new Attributes();
        attributes59.setName("artifactId");
        attributes59.setIsNullable(false);
        attributes59.setIsUnique(true);
//      ...................... GroupIds ........................
        Entities entity106 = new Entities();
        entity106 = findBean.nameEntities("GroupIds",em);
        attributes59.setEntities(entity106);
//      ...................... String ........................
        AttributesTypes attributesTypes107 = new AttributesTypes();
        attributesTypes107 = findBean.nameAttributesTypes("String",em);
        attributes59.setAttributesTypes(attributesTypes107);
        em.persist(attributes59);
        em.flush();

        Attributes attributes60 = new Attributes();
        attributes60.setName("groupId");
        attributes60.setIsNullable(false);
        attributes60.setIsUnique(true);
//      ...................... GroupIds ........................
        Entities entity108 = new Entities();
        entity108 = findBean.nameEntities("GroupIds",em);
        attributes60.setEntities(entity108);
//      ...................... String ........................
        AttributesTypes attributesTypes109 = new AttributesTypes();
        attributesTypes109 = findBean.nameAttributesTypes("String",em);
        attributes60.setAttributesTypes(attributesTypes109);
        em.persist(attributes60);
        em.flush();

        Entities entities61 = new Entities();
        entities61.setName("Dependencies");
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId110 = new GroupIds();
        groupId110 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities61.setGroupIds(groupId110);
        em.persist(entities61);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes62 = new Attributes();
        attributes62.setName("scope");
        attributes62.setIsNullable(true);
        attributes62.setIsUnique(false);
//      ...................... Dependencies ........................
        Entities entity111 = new Entities();
        entity111 = findBean.nameEntities("Dependencies",em);
        attributes62.setEntities(entity111);
//      ...................... String ........................
        AttributesTypes attributesTypes112 = new AttributesTypes();
        attributesTypes112 = findBean.nameAttributesTypes("String",em);
        attributes62.setAttributesTypes(attributesTypes112);
        em.persist(attributes62);
        em.flush();

        Attributes attributes63 = new Attributes();
        attributes63.setName("type");
        attributes63.setIsNullable(true);
        attributes63.setIsUnique(false);
//      ...................... Dependencies ........................
        Entities entity113 = new Entities();
        entity113 = findBean.nameEntities("Dependencies",em);
        attributes63.setEntities(entity113);
//      ...................... String ........................
        AttributesTypes attributesTypes114 = new AttributesTypes();
        attributesTypes114 = findBean.nameAttributesTypes("String",em);
        attributes63.setAttributesTypes(attributesTypes114);
        em.persist(attributes63);
        em.flush();

        Attributes attributes64 = new Attributes();
        attributes64.setName("version");
        attributes64.setIsNullable(true);
        attributes64.setIsUnique(false);
//      ...................... Dependencies ........................
        Entities entity115 = new Entities();
        entity115 = findBean.nameEntities("Dependencies",em);
        attributes64.setEntities(entity115);
//      ...................... String ........................
        AttributesTypes attributesTypes116 = new AttributesTypes();
        attributesTypes116 = findBean.nameAttributesTypes("String",em);
        attributes64.setAttributesTypes(attributesTypes116);
        em.persist(attributes64);
        em.flush();

        Attributes attributes65 = new Attributes();
        attributes65.setName("artifactId");
        attributes65.setIsNullable(false);
        attributes65.setIsUnique(false);
//      ...................... Dependencies ........................
        Entities entity117 = new Entities();
        entity117 = findBean.nameEntities("Dependencies",em);
        attributes65.setEntities(entity117);
//      ...................... String ........................
        AttributesTypes attributesTypes118 = new AttributesTypes();
        attributesTypes118 = findBean.nameAttributesTypes("String",em);
        attributes65.setAttributesTypes(attributesTypes118);
        em.persist(attributes65);
        em.flush();

        Attributes attributes66 = new Attributes();
        attributes66.setName("groupId");
        attributes66.setIsNullable(false);
        attributes66.setIsUnique(false);
//      ...................... Dependencies ........................
        Entities entity119 = new Entities();
        entity119 = findBean.nameEntities("Dependencies",em);
        attributes66.setEntities(entity119);
//      ...................... String ........................
        AttributesTypes attributesTypes120 = new AttributesTypes();
        attributesTypes120 = findBean.nameAttributesTypes("String",em);
        attributes66.setAttributesTypes(attributesTypes120);
        em.persist(attributes66);
        em.flush();

        Attributes attributes67 = new Attributes();
        attributes67.setName("maven");
        attributes67.setIsNullable(false);
        attributes67.setIsUnique(true);
//      ...................... Dependencies ........................
        Entities entity121 = new Entities();
        entity121 = findBean.nameEntities("Dependencies",em);
        attributes67.setEntities(entity121);
//      ...................... String ........................
        AttributesTypes attributesTypes122 = new AttributesTypes();
        attributesTypes122 = findBean.nameAttributesTypes("String",em);
        attributes67.setAttributesTypes(attributesTypes122);
        em.persist(attributes67);
        em.flush();

        Entities entities68 = new Entities();
        entities68.setName("Imports");
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId123 = new GroupIds();
        groupId123 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities68.setGroupIds(groupId123);
        em.persist(entities68);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes69 = new Attributes();
        attributes69.setName("name");
        attributes69.setIsNullable(false);
        attributes69.setIsUnique(true);
//      ...................... Imports ........................
        Entities entity124 = new Entities();
        entity124 = findBean.nameEntities("Imports",em);
        attributes69.setEntities(entity124);
//      ...................... String ........................
        AttributesTypes attributesTypes125 = new AttributesTypes();
        attributesTypes125 = findBean.nameAttributesTypes("String",em);
        attributes69.setAttributesTypes(attributesTypes125);
        em.persist(attributes69);
        em.flush();

        Entities entities70 = new Entities();
        entities70.setName("AttributesTypes");
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId126 = new GroupIds();
        groupId126 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities70.setGroupIds(groupId126);
        em.persist(entities70);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes71 = new Attributes();
        attributes71.setName("annotations");
        attributes71.setIsNullable(true);
        attributes71.setIsUnique(false);
//      ...................... AttributesTypes ........................
        Entities entity127 = new Entities();
        entity127 = findBean.nameEntities("AttributesTypes",em);
        attributes71.setEntities(entity127);
//      ...................... String ........................
        AttributesTypes attributesTypes128 = new AttributesTypes();
        attributesTypes128 = findBean.nameAttributesTypes("String",em);
        attributes71.setAttributesTypes(attributesTypes128);
        em.persist(attributes71);
        em.flush();

        Attributes attributes72 = new Attributes();
        attributes72.setName("length");
        attributes72.setIsNullable(true);
        attributes72.setIsUnique(false);
//      ...................... AttributesTypes ........................
        Entities entity129 = new Entities();
        entity129 = findBean.nameEntities("AttributesTypes",em);
        attributes72.setEntities(entity129);
//      ...................... Integer ........................
        AttributesTypes attributesTypes130 = new AttributesTypes();
        attributesTypes130 = findBean.nameAttributesTypes("Integer",em);
        attributes72.setAttributesTypes(attributesTypes130);
        em.persist(attributes72);
        em.flush();

        Attributes attributes73 = new Attributes();
        attributes73.setName("precision");
        attributes73.setIsNullable(true);
        attributes73.setIsUnique(false);
//      ...................... AttributesTypes ........................
        Entities entity131 = new Entities();
        entity131 = findBean.nameEntities("AttributesTypes",em);
        attributes73.setEntities(entity131);
//      ...................... Integer ........................
        AttributesTypes attributesTypes132 = new AttributesTypes();
        attributesTypes132 = findBean.nameAttributesTypes("Integer",em);
        attributes73.setAttributesTypes(attributesTypes132);
        em.persist(attributes73);
        em.flush();

        Attributes attributes74 = new Attributes();
        attributes74.setName("name");
        attributes74.setIsNullable(false);
        attributes74.setIsUnique(true);
//      ...................... AttributesTypes ........................
        Entities entity133 = new Entities();
        entity133 = findBean.nameEntities("AttributesTypes",em);
        attributes74.setEntities(entity133);
//      ...................... String ........................
        AttributesTypes attributesTypes134 = new AttributesTypes();
        attributesTypes134 = findBean.nameAttributesTypes("String",em);
        attributes74.setAttributesTypes(attributesTypes134);
        em.persist(attributes74);
        em.flush();

        Attributes attributes75 = new Attributes();
        attributes75.setName("type");
        attributes75.setIsNullable(false);
        attributes75.setIsUnique(false);
//      ...................... AttributesTypes ........................
        Entities entity135 = new Entities();
        entity135 = findBean.nameEntities("AttributesTypes",em);
        attributes75.setEntities(entity135);
//      ...................... String ........................
        AttributesTypes attributesTypes136 = new AttributesTypes();
        attributesTypes136 = findBean.nameAttributesTypes("String",em);
        attributes75.setAttributesTypes(attributesTypes136);
        em.persist(attributes75);
        em.flush();

        Entities entities76 = new Entities();
        entities76.setName("AttributesProperties");
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId137 = new GroupIds();
        groupId137 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities76.setGroupIds(groupId137);
        em.persist(entities76);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes77 = new Attributes();
        attributes77.setName("value");
        attributes77.setIsNullable(false);
        attributes77.setIsUnique(true);
//      ...................... AttributesProperties ........................
        Entities entity138 = new Entities();
        entity138 = findBean.nameEntities("AttributesProperties",em);
        attributes77.setEntities(entity138);
//      ...................... String ........................
        AttributesTypes attributesTypes139 = new AttributesTypes();
        attributesTypes139 = findBean.nameAttributesTypes("String",em);
        attributes77.setAttributesTypes(attributesTypes139);
        em.persist(attributes77);
        em.flush();

        Attributes attributes78 = new Attributes();
        attributes78.setName("name");
        attributes78.setIsNullable(false);
        attributes78.setIsUnique(true);
//      ...................... AttributesProperties ........................
        Entities entity140 = new Entities();
        entity140 = findBean.nameEntities("AttributesProperties",em);
        attributes78.setEntities(entity140);
//      ...................... String ........................
        AttributesTypes attributesTypes141 = new AttributesTypes();
        attributesTypes141 = findBean.nameAttributesTypes("String",em);
        attributes78.setAttributesTypes(attributesTypes141);
        em.persist(attributes78);
        em.flush();

//      ---------------------- Relationships ------------------------

/*
. SitesTypes . 1..* SitesTypes
. SitesTypes . *..* Sites
. SitesTypes . 1..* SitesTypes
. SitesTypes . *..* Sites
. SitesTypes . 1..* SitesTypes
. SitesTypes . *..* Sites
. Relationships . *..* AttributesProperties
. Cardinalities . 1..* Relationships
. Cardinalities . *..* Sites
. Cardinalities . *..* Imports
. Attributes . *..* Sites
. Attributes . *..* AttributesProperties
. Developments . *..* Sites
. Developments . *..* Models
. Models . *..* Sites
. Models . 1..* ModelsGroupIds
. Entities . 1..* Attributes
. Entities . 1..* NameQueries
. Entities . *..* Imports
. Entities . *..* Sites
. Entities . 1..* Relationships
. Entities . 1..* GroupIdsEntities
. Entities . *..* AttributesProperties
. Entities . 1..* Relationships
. GroupIds . 1..* ModelsGroupIds
. GroupIds . 1..* GroupIdsEntities
. GroupIds . 1..* GroupIdsFiles
. Dependencies . *..* Sites
. Dependencies . 1..* Imports
. Imports . *..* Sites
. AttributesTypes . 1..* Attributes
. AttributesTypes . *..* AttributesProperties
. AttributesTypes . *..* Sites
. AttributesProperties . *..* Sites
. AttributesProperties . *..* Imports
*/
        Relationships relationships1 = new Relationships();
        relationships1.setIsOptionality(true);
        relationships1.setIsEmbedded(false);
        relationships1.setName("");
//      ...................... SitesTypes ........................
        Entities entities142 = new Entities();
        entities142 = findBean.nameEntities("SitesTypes",em);
        relationships1.setFrom(entities142);
//      ...................... SitesTypes ........................
        Entities entities143 = new Entities();
        entities143 = findBean.nameEntities("SitesTypes",em);
        relationships1.setTo(entities143);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities144 = new Cardinalities();
        cardinalities144 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships1.setCardinalities(cardinalities144);
        em.persist(relationships1);
        em.flush();

        Relationships relationships2 = new Relationships();
        relationships2.setIsOptionality(true);
        relationships2.setIsEmbedded(false);
        relationships2.setName("");
//      ...................... SitesTypes ........................
        Entities entities145 = new Entities();
        entities145 = findBean.nameEntities("SitesTypes",em);
        relationships2.setFrom(entities145);
//      ...................... Sites ........................
        Entities entities146 = new Entities();
        entities146 = findBean.nameEntities("Sites",em);
        relationships2.setTo(entities146);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities147 = new Cardinalities();
        cardinalities147 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships2.setCardinalities(cardinalities147);
        em.persist(relationships2);
        em.flush();

        Relationships relationships3 = new Relationships();
        relationships3.setIsOptionality(true);
        relationships3.setIsEmbedded(false);
        relationships3.setName("");
//      ...................... SitesTypes ........................
        Entities entities148 = new Entities();
        entities148 = findBean.nameEntities("SitesTypes",em);
        relationships3.setFrom(entities148);
//      ...................... SitesTypes ........................
        Entities entities149 = new Entities();
        entities149 = findBean.nameEntities("SitesTypes",em);
        relationships3.setTo(entities149);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities150 = new Cardinalities();
        cardinalities150 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships3.setCardinalities(cardinalities150);
        em.persist(relationships3);
        em.flush();

        Relationships relationships4 = new Relationships();
        relationships4.setIsOptionality(true);
        relationships4.setIsEmbedded(false);
        relationships4.setName("");
//      ...................... SitesTypes ........................
        Entities entities151 = new Entities();
        entities151 = findBean.nameEntities("SitesTypes",em);
        relationships4.setFrom(entities151);
//      ...................... Sites ........................
        Entities entities152 = new Entities();
        entities152 = findBean.nameEntities("Sites",em);
        relationships4.setTo(entities152);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities153 = new Cardinalities();
        cardinalities153 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships4.setCardinalities(cardinalities153);
        em.persist(relationships4);
        em.flush();

        Relationships relationships5 = new Relationships();
        relationships5.setIsOptionality(true);
        relationships5.setIsEmbedded(false);
        relationships5.setName("");
//      ...................... SitesTypes ........................
        Entities entities154 = new Entities();
        entities154 = findBean.nameEntities("SitesTypes",em);
        relationships5.setFrom(entities154);
//      ...................... SitesTypes ........................
        Entities entities155 = new Entities();
        entities155 = findBean.nameEntities("SitesTypes",em);
        relationships5.setTo(entities155);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities156 = new Cardinalities();
        cardinalities156 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships5.setCardinalities(cardinalities156);
        em.persist(relationships5);
        em.flush();

        Relationships relationships6 = new Relationships();
        relationships6.setIsOptionality(true);
        relationships6.setIsEmbedded(false);
        relationships6.setName("");
//      ...................... SitesTypes ........................
        Entities entities157 = new Entities();
        entities157 = findBean.nameEntities("SitesTypes",em);
        relationships6.setFrom(entities157);
//      ...................... Sites ........................
        Entities entities158 = new Entities();
        entities158 = findBean.nameEntities("Sites",em);
        relationships6.setTo(entities158);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities159 = new Cardinalities();
        cardinalities159 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships6.setCardinalities(cardinalities159);
        em.persist(relationships6);
        em.flush();

        Relationships relationships7 = new Relationships();
        relationships7.setIsOptionality(true);
        relationships7.setIsEmbedded(false);
        relationships7.setName("");
//      ...................... Relationships ........................
        Entities entities160 = new Entities();
        entities160 = findBean.nameEntities("Relationships",em);
        relationships7.setFrom(entities160);
//      ...................... AttributesProperties ........................
        Entities entities161 = new Entities();
        entities161 = findBean.nameEntities("AttributesProperties",em);
        relationships7.setTo(entities161);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities162 = new Cardinalities();
        cardinalities162 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships7.setCardinalities(cardinalities162);
        em.persist(relationships7);
        em.flush();

        Relationships relationships8 = new Relationships();
        relationships8.setIsOptionality(true);
        relationships8.setIsEmbedded(false);
        relationships8.setName("");
//      ...................... Cardinalities ........................
        Entities entities163 = new Entities();
        entities163 = findBean.nameEntities("Cardinalities",em);
        relationships8.setFrom(entities163);
//      ...................... Relationships ........................
        Entities entities164 = new Entities();
        entities164 = findBean.nameEntities("Relationships",em);
        relationships8.setTo(entities164);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities165 = new Cardinalities();
        cardinalities165 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships8.setCardinalities(cardinalities165);
        em.persist(relationships8);
        em.flush();

        Relationships relationships9 = new Relationships();
        relationships9.setIsOptionality(true);
        relationships9.setIsEmbedded(false);
        relationships9.setName("");
//      ...................... Cardinalities ........................
        Entities entities166 = new Entities();
        entities166 = findBean.nameEntities("Cardinalities",em);
        relationships9.setFrom(entities166);
//      ...................... Sites ........................
        Entities entities167 = new Entities();
        entities167 = findBean.nameEntities("Sites",em);
        relationships9.setTo(entities167);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities168 = new Cardinalities();
        cardinalities168 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships9.setCardinalities(cardinalities168);
        em.persist(relationships9);
        em.flush();

        Relationships relationships10 = new Relationships();
        relationships10.setIsOptionality(true);
        relationships10.setIsEmbedded(false);
        relationships10.setName("");
//      ...................... Cardinalities ........................
        Entities entities169 = new Entities();
        entities169 = findBean.nameEntities("Cardinalities",em);
        relationships10.setFrom(entities169);
//      ...................... Imports ........................
        Entities entities170 = new Entities();
        entities170 = findBean.nameEntities("Imports",em);
        relationships10.setTo(entities170);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities171 = new Cardinalities();
        cardinalities171 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships10.setCardinalities(cardinalities171);
        em.persist(relationships10);
        em.flush();

        Relationships relationships11 = new Relationships();
        relationships11.setIsOptionality(true);
        relationships11.setIsEmbedded(false);
        relationships11.setName("");
//      ...................... Attributes ........................
        Entities entities172 = new Entities();
        entities172 = findBean.nameEntities("Attributes",em);
        relationships11.setFrom(entities172);
//      ...................... Sites ........................
        Entities entities173 = new Entities();
        entities173 = findBean.nameEntities("Sites",em);
        relationships11.setTo(entities173);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities174 = new Cardinalities();
        cardinalities174 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships11.setCardinalities(cardinalities174);
        em.persist(relationships11);
        em.flush();

        Relationships relationships12 = new Relationships();
        relationships12.setIsOptionality(true);
        relationships12.setIsEmbedded(false);
        relationships12.setName("");
//      ...................... Attributes ........................
        Entities entities175 = new Entities();
        entities175 = findBean.nameEntities("Attributes",em);
        relationships12.setFrom(entities175);
//      ...................... AttributesProperties ........................
        Entities entities176 = new Entities();
        entities176 = findBean.nameEntities("AttributesProperties",em);
        relationships12.setTo(entities176);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities177 = new Cardinalities();
        cardinalities177 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships12.setCardinalities(cardinalities177);
        em.persist(relationships12);
        em.flush();

        Relationships relationships13 = new Relationships();
        relationships13.setIsOptionality(true);
        relationships13.setIsEmbedded(false);
        relationships13.setName("");
//      ...................... Developments ........................
        Entities entities178 = new Entities();
        entities178 = findBean.nameEntities("Developments",em);
        relationships13.setFrom(entities178);
//      ...................... Sites ........................
        Entities entities179 = new Entities();
        entities179 = findBean.nameEntities("Sites",em);
        relationships13.setTo(entities179);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities180 = new Cardinalities();
        cardinalities180 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships13.setCardinalities(cardinalities180);
        em.persist(relationships13);
        em.flush();

        Relationships relationships14 = new Relationships();
        relationships14.setIsOptionality(true);
        relationships14.setIsEmbedded(false);
        relationships14.setName("");
//      ...................... Developments ........................
        Entities entities181 = new Entities();
        entities181 = findBean.nameEntities("Developments",em);
        relationships14.setFrom(entities181);
//      ...................... Models ........................
        Entities entities182 = new Entities();
        entities182 = findBean.nameEntities("Models",em);
        relationships14.setTo(entities182);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities183 = new Cardinalities();
        cardinalities183 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships14.setCardinalities(cardinalities183);
        em.persist(relationships14);
        em.flush();

        Relationships relationships15 = new Relationships();
        relationships15.setIsOptionality(true);
        relationships15.setIsEmbedded(false);
        relationships15.setName("");
//      ...................... Models ........................
        Entities entities184 = new Entities();
        entities184 = findBean.nameEntities("Models",em);
        relationships15.setFrom(entities184);
//      ...................... Sites ........................
        Entities entities185 = new Entities();
        entities185 = findBean.nameEntities("Sites",em);
        relationships15.setTo(entities185);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities186 = new Cardinalities();
        cardinalities186 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships15.setCardinalities(cardinalities186);
        em.persist(relationships15);
        em.flush();

        Relationships relationships16 = new Relationships();
        relationships16.setIsOptionality(true);
        relationships16.setIsEmbedded(false);
        relationships16.setName("");
//      ...................... Models ........................
        Entities entities187 = new Entities();
        entities187 = findBean.nameEntities("Models",em);
        relationships16.setFrom(entities187);
//      ...................... ModelsGroupIds ........................
        Entities entities188 = new Entities();
        entities188 = findBean.nameEntities("ModelsGroupIds",em);
        relationships16.setTo(entities188);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities189 = new Cardinalities();
        cardinalities189 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships16.setCardinalities(cardinalities189);
        em.persist(relationships16);
        em.flush();

        Relationships relationships17 = new Relationships();
        relationships17.setIsOptionality(true);
        relationships17.setIsEmbedded(false);
        relationships17.setName("");
//      ...................... Entities ........................
        Entities entities190 = new Entities();
        entities190 = findBean.nameEntities("Entities",em);
        relationships17.setFrom(entities190);
//      ...................... Attributes ........................
        Entities entities191 = new Entities();
        entities191 = findBean.nameEntities("Attributes",em);
        relationships17.setTo(entities191);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities192 = new Cardinalities();
        cardinalities192 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships17.setCardinalities(cardinalities192);
        em.persist(relationships17);
        em.flush();

        Relationships relationships18 = new Relationships();
        relationships18.setIsOptionality(true);
        relationships18.setIsEmbedded(false);
        relationships18.setName("");
//      ...................... Entities ........................
        Entities entities193 = new Entities();
        entities193 = findBean.nameEntities("Entities",em);
        relationships18.setFrom(entities193);
//      ...................... NameQueries ........................
        Entities entities194 = new Entities();
        entities194 = findBean.nameEntities("NameQueries",em);
        relationships18.setTo(entities194);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities195 = new Cardinalities();
        cardinalities195 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships18.setCardinalities(cardinalities195);
        em.persist(relationships18);
        em.flush();

        Relationships relationships19 = new Relationships();
        relationships19.setIsOptionality(true);
        relationships19.setIsEmbedded(false);
        relationships19.setName("");
//      ...................... Entities ........................
        Entities entities196 = new Entities();
        entities196 = findBean.nameEntities("Entities",em);
        relationships19.setFrom(entities196);
//      ...................... Imports ........................
        Entities entities197 = new Entities();
        entities197 = findBean.nameEntities("Imports",em);
        relationships19.setTo(entities197);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities198 = new Cardinalities();
        cardinalities198 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships19.setCardinalities(cardinalities198);
        em.persist(relationships19);
        em.flush();

        Relationships relationships20 = new Relationships();
        relationships20.setIsOptionality(true);
        relationships20.setIsEmbedded(false);
        relationships20.setName("");
//      ...................... Entities ........................
        Entities entities199 = new Entities();
        entities199 = findBean.nameEntities("Entities",em);
        relationships20.setFrom(entities199);
//      ...................... Sites ........................
        Entities entities200 = new Entities();
        entities200 = findBean.nameEntities("Sites",em);
        relationships20.setTo(entities200);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities201 = new Cardinalities();
        cardinalities201 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships20.setCardinalities(cardinalities201);
        em.persist(relationships20);
        em.flush();

        Relationships relationships21 = new Relationships();
        relationships21.setIsOptionality(true);
        relationships21.setIsEmbedded(false);
        relationships21.setName("from");
//      ...................... Entities ........................
        Entities entities202 = new Entities();
        entities202 = findBean.nameEntities("Entities",em);
        relationships21.setFrom(entities202);
//      ...................... Relationships ........................
        Entities entities203 = new Entities();
        entities203 = findBean.nameEntities("Relationships",em);
        relationships21.setTo(entities203);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities204 = new Cardinalities();
        cardinalities204 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships21.setCardinalities(cardinalities204);
        em.persist(relationships21);
        em.flush();

        Relationships relationships22 = new Relationships();
        relationships22.setIsOptionality(true);
        relationships22.setIsEmbedded(false);
        relationships22.setName("");
//      ...................... Entities ........................
        Entities entities205 = new Entities();
        entities205 = findBean.nameEntities("Entities",em);
        relationships22.setFrom(entities205);
//      ...................... GroupIdsEntities ........................
        Entities entities206 = new Entities();
        entities206 = findBean.nameEntities("GroupIdsEntities",em);
        relationships22.setTo(entities206);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities207 = new Cardinalities();
        cardinalities207 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships22.setCardinalities(cardinalities207);
        em.persist(relationships22);
        em.flush();

        Relationships relationships23 = new Relationships();
        relationships23.setIsOptionality(true);
        relationships23.setIsEmbedded(false);
        relationships23.setName("");
//      ...................... Entities ........................
        Entities entities208 = new Entities();
        entities208 = findBean.nameEntities("Entities",em);
        relationships23.setFrom(entities208);
//      ...................... AttributesProperties ........................
        Entities entities209 = new Entities();
        entities209 = findBean.nameEntities("AttributesProperties",em);
        relationships23.setTo(entities209);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities210 = new Cardinalities();
        cardinalities210 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships23.setCardinalities(cardinalities210);
        em.persist(relationships23);
        em.flush();

        Relationships relationships24 = new Relationships();
        relationships24.setIsOptionality(true);
        relationships24.setIsEmbedded(false);
        relationships24.setName("to");
//      ...................... Entities ........................
        Entities entities211 = new Entities();
        entities211 = findBean.nameEntities("Entities",em);
        relationships24.setFrom(entities211);
//      ...................... Relationships ........................
        Entities entities212 = new Entities();
        entities212 = findBean.nameEntities("Relationships",em);
        relationships24.setTo(entities212);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities213 = new Cardinalities();
        cardinalities213 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships24.setCardinalities(cardinalities213);
        em.persist(relationships24);
        em.flush();

        Relationships relationships25 = new Relationships();
        relationships25.setIsOptionality(true);
        relationships25.setIsEmbedded(false);
        relationships25.setName("");
//      ...................... GroupIds ........................
        Entities entities214 = new Entities();
        entities214 = findBean.nameEntities("GroupIds",em);
        relationships25.setFrom(entities214);
//      ...................... ModelsGroupIds ........................
        Entities entities215 = new Entities();
        entities215 = findBean.nameEntities("ModelsGroupIds",em);
        relationships25.setTo(entities215);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities216 = new Cardinalities();
        cardinalities216 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships25.setCardinalities(cardinalities216);
        em.persist(relationships25);
        em.flush();

        Relationships relationships26 = new Relationships();
        relationships26.setIsOptionality(true);
        relationships26.setIsEmbedded(false);
        relationships26.setName("");
//      ...................... GroupIds ........................
        Entities entities217 = new Entities();
        entities217 = findBean.nameEntities("GroupIds",em);
        relationships26.setFrom(entities217);
//      ...................... GroupIdsEntities ........................
        Entities entities218 = new Entities();
        entities218 = findBean.nameEntities("GroupIdsEntities",em);
        relationships26.setTo(entities218);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities219 = new Cardinalities();
        cardinalities219 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships26.setCardinalities(cardinalities219);
        em.persist(relationships26);
        em.flush();

        Relationships relationships27 = new Relationships();
        relationships27.setIsOptionality(true);
        relationships27.setIsEmbedded(false);
        relationships27.setName("");
//      ...................... GroupIds ........................
        Entities entities220 = new Entities();
        entities220 = findBean.nameEntities("GroupIds",em);
        relationships27.setFrom(entities220);
//      ...................... GroupIdsFiles ........................
        Entities entities221 = new Entities();
        entities221 = findBean.nameEntities("GroupIdsFiles",em);
        relationships27.setTo(entities221);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities222 = new Cardinalities();
        cardinalities222 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships27.setCardinalities(cardinalities222);
        em.persist(relationships27);
        em.flush();

        Relationships relationships28 = new Relationships();
        relationships28.setIsOptionality(true);
        relationships28.setIsEmbedded(false);
        relationships28.setName("");
//      ...................... Dependencies ........................
        Entities entities223 = new Entities();
        entities223 = findBean.nameEntities("Dependencies",em);
        relationships28.setFrom(entities223);
//      ...................... Sites ........................
        Entities entities224 = new Entities();
        entities224 = findBean.nameEntities("Sites",em);
        relationships28.setTo(entities224);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities225 = new Cardinalities();
        cardinalities225 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships28.setCardinalities(cardinalities225);
        em.persist(relationships28);
        em.flush();

        Relationships relationships29 = new Relationships();
        relationships29.setIsOptionality(true);
        relationships29.setIsEmbedded(false);
        relationships29.setName("");
//      ...................... Dependencies ........................
        Entities entities226 = new Entities();
        entities226 = findBean.nameEntities("Dependencies",em);
        relationships29.setFrom(entities226);
//      ...................... Imports ........................
        Entities entities227 = new Entities();
        entities227 = findBean.nameEntities("Imports",em);
        relationships29.setTo(entities227);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities228 = new Cardinalities();
        cardinalities228 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships29.setCardinalities(cardinalities228);
        em.persist(relationships29);
        em.flush();

        Relationships relationships30 = new Relationships();
        relationships30.setIsOptionality(true);
        relationships30.setIsEmbedded(false);
        relationships30.setName("");
//      ...................... Imports ........................
        Entities entities229 = new Entities();
        entities229 = findBean.nameEntities("Imports",em);
        relationships30.setFrom(entities229);
//      ...................... Sites ........................
        Entities entities230 = new Entities();
        entities230 = findBean.nameEntities("Sites",em);
        relationships30.setTo(entities230);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities231 = new Cardinalities();
        cardinalities231 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships30.setCardinalities(cardinalities231);
        em.persist(relationships30);
        em.flush();

        Relationships relationships31 = new Relationships();
        relationships31.setIsOptionality(true);
        relationships31.setIsEmbedded(false);
        relationships31.setName("");
//      ...................... AttributesTypes ........................
        Entities entities232 = new Entities();
        entities232 = findBean.nameEntities("AttributesTypes",em);
        relationships31.setFrom(entities232);
//      ...................... Attributes ........................
        Entities entities233 = new Entities();
        entities233 = findBean.nameEntities("Attributes",em);
        relationships31.setTo(entities233);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities234 = new Cardinalities();
        cardinalities234 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships31.setCardinalities(cardinalities234);
        em.persist(relationships31);
        em.flush();

        Relationships relationships32 = new Relationships();
        relationships32.setIsOptionality(true);
        relationships32.setIsEmbedded(false);
        relationships32.setName("");
//      ...................... AttributesTypes ........................
        Entities entities235 = new Entities();
        entities235 = findBean.nameEntities("AttributesTypes",em);
        relationships32.setFrom(entities235);
//      ...................... AttributesProperties ........................
        Entities entities236 = new Entities();
        entities236 = findBean.nameEntities("AttributesProperties",em);
        relationships32.setTo(entities236);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities237 = new Cardinalities();
        cardinalities237 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships32.setCardinalities(cardinalities237);
        em.persist(relationships32);
        em.flush();

        Relationships relationships33 = new Relationships();
        relationships33.setIsOptionality(true);
        relationships33.setIsEmbedded(false);
        relationships33.setName("");
//      ...................... AttributesTypes ........................
        Entities entities238 = new Entities();
        entities238 = findBean.nameEntities("AttributesTypes",em);
        relationships33.setFrom(entities238);
//      ...................... Sites ........................
        Entities entities239 = new Entities();
        entities239 = findBean.nameEntities("Sites",em);
        relationships33.setTo(entities239);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities240 = new Cardinalities();
        cardinalities240 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships33.setCardinalities(cardinalities240);
        em.persist(relationships33);
        em.flush();

        Relationships relationships34 = new Relationships();
        relationships34.setIsOptionality(true);
        relationships34.setIsEmbedded(false);
        relationships34.setName("");
//      ...................... AttributesProperties ........................
        Entities entities241 = new Entities();
        entities241 = findBean.nameEntities("AttributesProperties",em);
        relationships34.setFrom(entities241);
//      ...................... Sites ........................
        Entities entities242 = new Entities();
        entities242 = findBean.nameEntities("Sites",em);
        relationships34.setTo(entities242);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities243 = new Cardinalities();
        cardinalities243 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships34.setCardinalities(cardinalities243);
        em.persist(relationships34);
        em.flush();

        Relationships relationships35 = new Relationships();
        relationships35.setIsOptionality(true);
        relationships35.setIsEmbedded(false);
        relationships35.setName("");
//      ...................... AttributesProperties ........................
        Entities entities244 = new Entities();
        entities244 = findBean.nameEntities("AttributesProperties",em);
        relationships35.setFrom(entities244);
//      ...................... Imports ........................
        Entities entities245 = new Entities();
        entities245 = findBean.nameEntities("Imports",em);
        relationships35.setTo(entities245);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities246 = new Cardinalities();
        cardinalities246 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships35.setCardinalities(cardinalities246);
        em.persist(relationships35);
        em.flush();

    } // data()

} // naifgSetup
