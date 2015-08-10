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
        groupIds1.setGroupId("co.simasoft.models.dev.naifg.dependencies");
        groupIds1.setName("co.simasoft.models.dev.naifg.dependencies");
        em.persist(groupIds1);
        em.flush();

        GroupIds groupIds2 = new GroupIds();
        groupIds2.setGroupId("co.simasoft.models.dev.naifg");
        groupIds2.setName("naifg");
        em.persist(groupIds2);
        em.flush();

//      ---------------------- Models ------------------------

        Models models = new Models();
        models.setGroupId("co.simasoft.naifg.naifg");
        models.setArtifactId("naifg");
        models.setVersion("1.0-SNAPSHOT");
        models.setName("naifg");

        Set<GroupIds> modelsGroupIds = new HashSet<GroupIds>();

        GroupIds modelsGroupId1 = findBean.groupGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        modelsGroupIds.add(modelsGroupId1);

        GroupIds modelsGroupId2 = findBean.groupGroupIds("co.simasoft.models.dev.naifg",em);
        modelsGroupIds.add(modelsGroupId2);

        models.setGroupIds(modelsGroupIds);

        em.persist(models);
        em.flush();

//      ---------------------- Developments ------------------------

        Developments dev = new Developments();
        dev.setGroupId("co.simasoft");
        dev.setArtifactId("naifg");
        dev.setVersion("1.0-SNAPSHOT");
        dev.setCode("null");
        dev.setName("naifg");
        Set<Models> models1 = new HashSet<Models>();
        Models model1 = findBean.artifactIdModels("naifg",em);
        models1.add(model1);
        dev.setModels(models1);
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
        attributes2.setName("name");
        attributes2.setNullable(false);
        attributes2.setSingle(true);
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
        attributes3.setName("type");
        attributes3.setNullable(false);
        attributes3.setSingle(false);
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
        attributes4.setName("length");
        attributes4.setNullable(true);
        attributes4.setSingle(false);
//      ...................... AttributesTypes ........................
        Entities entity6 = new Entities();
        entity6 = findBean.nameEntities("AttributesTypes",em);
        attributes4.setEntities(entity6);
//      ...................... Integer ........................
        AttributesTypes attributesTypes7 = new AttributesTypes();
        attributesTypes7 = findBean.nameAttributesTypes("Integer",em);
        attributes4.setAttributesTypes(attributesTypes7);
        em.persist(attributes4);
        em.flush();

        Attributes attributes5 = new Attributes();
        attributes5.setName("precision");
        attributes5.setNullable(true);
        attributes5.setSingle(false);
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
        attributes6.setName("annotations");
        attributes6.setNullable(true);
        attributes6.setSingle(false);
//      ...................... AttributesTypes ........................
        Entities entity10 = new Entities();
        entity10 = findBean.nameEntities("AttributesTypes",em);
        attributes6.setEntities(entity10);
//      ...................... String ........................
        AttributesTypes attributesTypes11 = new AttributesTypes();
        attributesTypes11 = findBean.nameAttributesTypes("String",em);
        attributes6.setAttributesTypes(attributesTypes11);
        em.persist(attributes6);
        em.flush();

        Entities entities7 = new Entities();
        entities7.setName("Imports");
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId12 = new GroupIds();
        groupId12 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities7.setGroupIds(groupId12);
        em.persist(entities7);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes8 = new Attributes();
        attributes8.setName("name");
        attributes8.setNullable(false);
        attributes8.setSingle(true);
//      ...................... Imports ........................
        Entities entity13 = new Entities();
        entity13 = findBean.nameEntities("Imports",em);
        attributes8.setEntities(entity13);
//      ...................... String ........................
        AttributesTypes attributesTypes14 = new AttributesTypes();
        attributesTypes14 = findBean.nameAttributesTypes("String",em);
        attributes8.setAttributesTypes(attributesTypes14);
        em.persist(attributes8);
        em.flush();

        Entities entities9 = new Entities();
        entities9.setName("Dependencies");
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId15 = new GroupIds();
        groupId15 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities9.setGroupIds(groupId15);
        em.persist(entities9);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes10 = new Attributes();
        attributes10.setName("groupId");
        attributes10.setNullable(false);
        attributes10.setSingle(false);
//      ...................... Dependencies ........................
        Entities entity16 = new Entities();
        entity16 = findBean.nameEntities("Dependencies",em);
        attributes10.setEntities(entity16);
//      ...................... String ........................
        AttributesTypes attributesTypes17 = new AttributesTypes();
        attributesTypes17 = findBean.nameAttributesTypes("String",em);
        attributes10.setAttributesTypes(attributesTypes17);
        em.persist(attributes10);
        em.flush();

        Attributes attributes11 = new Attributes();
        attributes11.setName("artifactId");
        attributes11.setNullable(false);
        attributes11.setSingle(false);
//      ...................... Dependencies ........................
        Entities entity18 = new Entities();
        entity18 = findBean.nameEntities("Dependencies",em);
        attributes11.setEntities(entity18);
//      ...................... String ........................
        AttributesTypes attributesTypes19 = new AttributesTypes();
        attributesTypes19 = findBean.nameAttributesTypes("String",em);
        attributes11.setAttributesTypes(attributesTypes19);
        em.persist(attributes11);
        em.flush();

        Attributes attributes12 = new Attributes();
        attributes12.setName("version");
        attributes12.setNullable(true);
        attributes12.setSingle(false);
//      ...................... Dependencies ........................
        Entities entity20 = new Entities();
        entity20 = findBean.nameEntities("Dependencies",em);
        attributes12.setEntities(entity20);
//      ...................... String ........................
        AttributesTypes attributesTypes21 = new AttributesTypes();
        attributesTypes21 = findBean.nameAttributesTypes("String",em);
        attributes12.setAttributesTypes(attributesTypes21);
        em.persist(attributes12);
        em.flush();

        Attributes attributes13 = new Attributes();
        attributes13.setName("type");
        attributes13.setNullable(true);
        attributes13.setSingle(false);
//      ...................... Dependencies ........................
        Entities entity22 = new Entities();
        entity22 = findBean.nameEntities("Dependencies",em);
        attributes13.setEntities(entity22);
//      ...................... String ........................
        AttributesTypes attributesTypes23 = new AttributesTypes();
        attributesTypes23 = findBean.nameAttributesTypes("String",em);
        attributes13.setAttributesTypes(attributesTypes23);
        em.persist(attributes13);
        em.flush();

        Attributes attributes14 = new Attributes();
        attributes14.setName("scope");
        attributes14.setNullable(true);
        attributes14.setSingle(false);
//      ...................... Dependencies ........................
        Entities entity24 = new Entities();
        entity24 = findBean.nameEntities("Dependencies",em);
        attributes14.setEntities(entity24);
//      ...................... String ........................
        AttributesTypes attributesTypes25 = new AttributesTypes();
        attributesTypes25 = findBean.nameAttributesTypes("String",em);
        attributes14.setAttributesTypes(attributesTypes25);
        em.persist(attributes14);
        em.flush();

        Attributes attributes15 = new Attributes();
        attributes15.setName("maven");
        attributes15.setNullable(false);
        attributes15.setSingle(true);
//      ...................... Dependencies ........................
        Entities entity26 = new Entities();
        entity26 = findBean.nameEntities("Dependencies",em);
        attributes15.setEntities(entity26);
//      ...................... String ........................
        AttributesTypes attributesTypes27 = new AttributesTypes();
        attributesTypes27 = findBean.nameAttributesTypes("String",em);
        attributes15.setAttributesTypes(attributesTypes27);
        em.persist(attributes15);
        em.flush();

        Entities entities16 = new Entities();
        entities16.setName("AttributesProperties");
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId28 = new GroupIds();
        groupId28 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities16.setGroupIds(groupId28);
        em.persist(entities16);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes17 = new Attributes();
        attributes17.setName("value");
        attributes17.setNullable(false);
        attributes17.setSingle(true);
//      ...................... AttributesProperties ........................
        Entities entity29 = new Entities();
        entity29 = findBean.nameEntities("AttributesProperties",em);
        attributes17.setEntities(entity29);
//      ...................... String ........................
        AttributesTypes attributesTypes30 = new AttributesTypes();
        attributesTypes30 = findBean.nameAttributesTypes("String",em);
        attributes17.setAttributesTypes(attributesTypes30);
        em.persist(attributes17);
        em.flush();

        Attributes attributes18 = new Attributes();
        attributes18.setName("name");
        attributes18.setNullable(false);
        attributes18.setSingle(true);
//      ...................... AttributesProperties ........................
        Entities entity31 = new Entities();
        entity31 = findBean.nameEntities("AttributesProperties",em);
        attributes18.setEntities(entity31);
//      ...................... String ........................
        AttributesTypes attributesTypes32 = new AttributesTypes();
        attributesTypes32 = findBean.nameAttributesTypes("String",em);
        attributes18.setAttributesTypes(attributesTypes32);
        em.persist(attributes18);
        em.flush();

        Entities entities19 = new Entities();
        entities19.setName("NameQueries");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId33 = new GroupIds();
        groupId33 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities19.setGroupIds(groupId33);
        em.persist(entities19);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes20 = new Attributes();
        attributes20.setName("name");
        attributes20.setNullable(false);
        attributes20.setSingle(true);
//      ...................... NameQueries ........................
        Entities entity34 = new Entities();
        entity34 = findBean.nameEntities("NameQueries",em);
        attributes20.setEntities(entity34);
//      ...................... String ........................
        AttributesTypes attributesTypes35 = new AttributesTypes();
        attributesTypes35 = findBean.nameAttributesTypes("String",em);
        attributes20.setAttributesTypes(attributesTypes35);
        em.persist(attributes20);
        em.flush();

        Attributes attributes21 = new Attributes();
        attributes21.setName("query");
        attributes21.setNullable(false);
        attributes21.setSingle(true);
//      ...................... NameQueries ........................
        Entities entity36 = new Entities();
        entity36 = findBean.nameEntities("NameQueries",em);
        attributes21.setEntities(entity36);
//      ...................... String ........................
        AttributesTypes attributesTypes37 = new AttributesTypes();
        attributesTypes37 = findBean.nameAttributesTypes("String",em);
        attributes21.setAttributesTypes(attributesTypes37);
        em.persist(attributes21);
        em.flush();

        Attributes attributes22 = new Attributes();
        attributes22.setName("observations");
        attributes22.setNullable(true);
        attributes22.setSingle(false);
//      ...................... NameQueries ........................
        Entities entity38 = new Entities();
        entity38 = findBean.nameEntities("NameQueries",em);
        attributes22.setEntities(entity38);
//      ...................... String ........................
        AttributesTypes attributesTypes39 = new AttributesTypes();
        attributesTypes39 = findBean.nameAttributesTypes("String",em);
        attributes22.setAttributesTypes(attributesTypes39);
        em.persist(attributes22);
        em.flush();

        Entities entities23 = new Entities();
        entities23.setName("Cardinalities");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId40 = new GroupIds();
        groupId40 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities23.setGroupIds(groupId40);
        em.persist(entities23);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes24 = new Attributes();
        attributes24.setName("name");
        attributes24.setNullable(false);
        attributes24.setSingle(true);
//      ...................... Cardinalities ........................
        Entities entity41 = new Entities();
        entity41 = findBean.nameEntities("Cardinalities",em);
        attributes24.setEntities(entity41);
//      ...................... String ........................
        AttributesTypes attributesTypes42 = new AttributesTypes();
        attributesTypes42 = findBean.nameAttributesTypes("String",em);
        attributes24.setAttributesTypes(attributesTypes42);
        em.persist(attributes24);
        em.flush();

        Attributes attributes25 = new Attributes();
        attributes25.setName("cardinality");
        attributes25.setNullable(false);
        attributes25.setSingle(false);
//      ...................... Cardinalities ........................
        Entities entity43 = new Entities();
        entity43 = findBean.nameEntities("Cardinalities",em);
        attributes25.setEntities(entity43);
//      ...................... String ........................
        AttributesTypes attributesTypes44 = new AttributesTypes();
        attributesTypes44 = findBean.nameAttributesTypes("String",em);
        attributes25.setAttributesTypes(attributesTypes44);
        em.persist(attributes25);
        em.flush();

        Attributes attributes26 = new Attributes();
        attributes26.setName("unidirectional");
        attributes26.setNullable(true);
        attributes26.setSingle(false);
//      ...................... Cardinalities ........................
        Entities entity45 = new Entities();
        entity45 = findBean.nameEntities("Cardinalities",em);
        attributes26.setEntities(entity45);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes46 = new AttributesTypes();
        attributesTypes46 = findBean.nameAttributesTypes("Boolean",em);
        attributes26.setAttributesTypes(attributesTypes46);
        em.persist(attributes26);
        em.flush();

        Attributes attributes27 = new Attributes();
        attributes27.setName("annotations");
        attributes27.setNullable(true);
        attributes27.setSingle(false);
//      ...................... Cardinalities ........................
        Entities entity47 = new Entities();
        entity47 = findBean.nameEntities("Cardinalities",em);
        attributes27.setEntities(entity47);
//      ...................... String ........................
        AttributesTypes attributesTypes48 = new AttributesTypes();
        attributesTypes48 = findBean.nameAttributesTypes("String",em);
        attributes27.setAttributesTypes(attributesTypes48);
        em.persist(attributes27);
        em.flush();

        Attributes attributes28 = new Attributes();
        attributes28.setName("observations");
        attributes28.setNullable(true);
        attributes28.setSingle(false);
//      ...................... Cardinalities ........................
        Entities entity49 = new Entities();
        entity49 = findBean.nameEntities("Cardinalities",em);
        attributes28.setEntities(entity49);
//      ...................... String ........................
        AttributesTypes attributesTypes50 = new AttributesTypes();
        attributesTypes50 = findBean.nameAttributesTypes("String",em);
        attributes28.setAttributesTypes(attributesTypes50);
        em.persist(attributes28);
        em.flush();

        Entities entities29 = new Entities();
        entities29.setName("Entities");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId51 = new GroupIds();
        groupId51 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities29.setGroupIds(groupId51);
        em.persist(entities29);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes30 = new Attributes();
        attributes30.setName("name");
        attributes30.setNullable(false);
        attributes30.setSingle(false);
//      ...................... Entities ........................
        Entities entity52 = new Entities();
        entity52 = findBean.nameEntities("Entities",em);
        attributes30.setEntities(entity52);
//      ...................... String ........................
        AttributesTypes attributesTypes53 = new AttributesTypes();
        attributesTypes53 = findBean.nameAttributesTypes("String",em);
        attributes30.setAttributesTypes(attributesTypes53);
        em.persist(attributes30);
        em.flush();

        Attributes attributes31 = new Attributes();
        attributes31.setName("serialID");
        attributes31.setNullable(true);
        attributes31.setSingle(true);
//      ...................... Entities ........................
        Entities entity54 = new Entities();
        entity54 = findBean.nameEntities("Entities",em);
        attributes31.setEntities(entity54);
//      ...................... String ........................
        AttributesTypes attributesTypes55 = new AttributesTypes();
        attributesTypes55 = findBean.nameAttributesTypes("String",em);
        attributes31.setAttributesTypes(attributesTypes55);
        em.persist(attributes31);
        em.flush();

        Attributes attributes32 = new Attributes();
        attributes32.setName("table");
        attributes32.setNullable(true);
        attributes32.setSingle(false);
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
        attributes33.setName("tableSecuencia");
        attributes33.setNullable(true);
        attributes33.setSingle(false);
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
        attributes34.setName("modifier");
        attributes34.setNullable(true);
        attributes34.setSingle(false);
//      ...................... Entities ........................
        Entities entity60 = new Entities();
        entity60 = findBean.nameEntities("Entities",em);
        attributes34.setEntities(entity60);
//      ...................... String ........................
        AttributesTypes attributesTypes61 = new AttributesTypes();
        attributesTypes61 = findBean.nameAttributesTypes("String",em);
        attributes34.setAttributesTypes(attributesTypes61);
        em.persist(attributes34);
        em.flush();

        Attributes attributes35 = new Attributes();
        attributes35.setName("extend");
        attributes35.setNullable(true);
        attributes35.setSingle(false);
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
        attributes36.setName("annotations");
        attributes36.setNullable(true);
        attributes36.setSingle(false);
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

        Attributes attributes37 = new Attributes();
        attributes37.setName("source");
        attributes37.setNullable(true);
        attributes37.setSingle(false);
//      ...................... Entities ........................
        Entities entity66 = new Entities();
        entity66 = findBean.nameEntities("Entities",em);
        attributes37.setEntities(entity66);
//      ...................... String ........................
        AttributesTypes attributesTypes67 = new AttributesTypes();
        attributesTypes67 = findBean.nameAttributesTypes("String",em);
        attributes37.setAttributesTypes(attributesTypes67);
        em.persist(attributes37);
        em.flush();

        Attributes attributes38 = new Attributes();
        attributes38.setName("description");
        attributes38.setNullable(true);
        attributes38.setSingle(false);
//      ...................... Entities ........................
        Entities entity68 = new Entities();
        entity68 = findBean.nameEntities("Entities",em);
        attributes38.setEntities(entity68);
//      ...................... String ........................
        AttributesTypes attributesTypes69 = new AttributesTypes();
        attributesTypes69 = findBean.nameAttributesTypes("String",em);
        attributes38.setAttributesTypes(attributesTypes69);
        em.persist(attributes38);
        em.flush();

        Attributes attributes39 = new Attributes();
        attributes39.setName("observations");
        attributes39.setNullable(true);
        attributes39.setSingle(false);
//      ...................... Entities ........................
        Entities entity70 = new Entities();
        entity70 = findBean.nameEntities("Entities",em);
        attributes39.setEntities(entity70);
//      ...................... String ........................
        AttributesTypes attributesTypes71 = new AttributesTypes();
        attributesTypes71 = findBean.nameAttributesTypes("String",em);
        attributes39.setAttributesTypes(attributesTypes71);
        em.persist(attributes39);
        em.flush();

        Entities entities40 = new Entities();
        entities40.setName("Attributes");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId72 = new GroupIds();
        groupId72 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities40.setGroupIds(groupId72);
        em.persist(entities40);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes41 = new Attributes();
        attributes41.setName("observations");
        attributes41.setNullable(true);
        attributes41.setSingle(false);
//      ...................... Attributes ........................
        Entities entity73 = new Entities();
        entity73 = findBean.nameEntities("Attributes",em);
        attributes41.setEntities(entity73);
//      ...................... String ........................
        AttributesTypes attributesTypes74 = new AttributesTypes();
        attributesTypes74 = findBean.nameAttributesTypes("String",em);
        attributes41.setAttributesTypes(attributesTypes74);
        em.persist(attributes41);
        em.flush();

        Attributes attributes42 = new Attributes();
        attributes42.setName("name");
        attributes42.setNullable(false);
        attributes42.setSingle(false);
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
        attributes43.setNullable(true);
        attributes43.setSingle(false);
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
        attributes44.setName("precision");
        attributes44.setNullable(true);
        attributes44.setSingle(false);
//      ...................... Attributes ........................
        Entities entity79 = new Entities();
        entity79 = findBean.nameEntities("Attributes",em);
        attributes44.setEntities(entity79);
//      ...................... Integer ........................
        AttributesTypes attributesTypes80 = new AttributesTypes();
        attributesTypes80 = findBean.nameAttributesTypes("Integer",em);
        attributes44.setAttributesTypes(attributesTypes80);
        em.persist(attributes44);
        em.flush();

        Attributes attributes45 = new Attributes();
        attributes45.setName("nullable");
        attributes45.setNullable(true);
        attributes45.setSingle(false);
//      ...................... Attributes ........................
        Entities entity81 = new Entities();
        entity81 = findBean.nameEntities("Attributes",em);
        attributes45.setEntities(entity81);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes82 = new AttributesTypes();
        attributesTypes82 = findBean.nameAttributesTypes("Boolean",em);
        attributes45.setAttributesTypes(attributesTypes82);
        em.persist(attributes45);
        em.flush();

        Attributes attributes46 = new Attributes();
        attributes46.setName("single");
        attributes46.setNullable(true);
        attributes46.setSingle(false);
//      ...................... Attributes ........................
        Entities entity83 = new Entities();
        entity83 = findBean.nameEntities("Attributes",em);
        attributes46.setEntities(entity83);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes84 = new AttributesTypes();
        attributesTypes84 = findBean.nameAttributesTypes("Boolean",em);
        attributes46.setAttributesTypes(attributesTypes84);
        em.persist(attributes46);
        em.flush();

        Attributes attributes47 = new Attributes();
        attributes47.setName("descripcion");
        attributes47.setNullable(true);
        attributes47.setSingle(false);
//      ...................... Attributes ........................
        Entities entity85 = new Entities();
        entity85 = findBean.nameEntities("Attributes",em);
        attributes47.setEntities(entity85);
//      ...................... String ........................
        AttributesTypes attributesTypes86 = new AttributesTypes();
        attributesTypes86 = findBean.nameAttributesTypes("String",em);
        attributes47.setAttributesTypes(attributesTypes86);
        em.persist(attributes47);
        em.flush();

        Attributes attributes48 = new Attributes();
        attributes48.setName("field");
        attributes48.setNullable(true);
        attributes48.setSingle(false);
//      ...................... Attributes ........................
        Entities entity87 = new Entities();
        entity87 = findBean.nameEntities("Attributes",em);
        attributes48.setEntities(entity87);
//      ...................... String ........................
        AttributesTypes attributesTypes88 = new AttributesTypes();
        attributesTypes88 = findBean.nameAttributesTypes("String",em);
        attributes48.setAttributesTypes(attributesTypes88);
        em.persist(attributes48);
        em.flush();

        Attributes attributes49 = new Attributes();
        attributes49.setName("access");
        attributes49.setNullable(true);
        attributes49.setSingle(false);
//      ...................... Attributes ........................
        Entities entity89 = new Entities();
        entity89 = findBean.nameEntities("Attributes",em);
        attributes49.setEntities(entity89);
//      ...................... String ........................
        AttributesTypes attributesTypes90 = new AttributesTypes();
        attributesTypes90 = findBean.nameAttributesTypes("String",em);
        attributes49.setAttributesTypes(attributesTypes90);
        em.persist(attributes49);
        em.flush();

        Attributes attributes50 = new Attributes();
        attributes50.setName("columnDefinition");
        attributes50.setNullable(true);
        attributes50.setSingle(false);
//      ...................... Attributes ........................
        Entities entity91 = new Entities();
        entity91 = findBean.nameEntities("Attributes",em);
        attributes50.setEntities(entity91);
//      ...................... String ........................
        AttributesTypes attributesTypes92 = new AttributesTypes();
        attributesTypes92 = findBean.nameAttributesTypes("String",em);
        attributes50.setAttributesTypes(attributesTypes92);
        em.persist(attributes50);
        em.flush();

        Attributes attributes51 = new Attributes();
        attributes51.setName("annotationsField");
        attributes51.setNullable(true);
        attributes51.setSingle(false);
//      ...................... Attributes ........................
        Entities entity93 = new Entities();
        entity93 = findBean.nameEntities("Attributes",em);
        attributes51.setEntities(entity93);
//      ...................... String ........................
        AttributesTypes attributesTypes94 = new AttributesTypes();
        attributesTypes94 = findBean.nameAttributesTypes("String",em);
        attributes51.setAttributesTypes(attributesTypes94);
        em.persist(attributes51);
        em.flush();

        Attributes attributes52 = new Attributes();
        attributes52.setName("annotationsMethod");
        attributes52.setNullable(true);
        attributes52.setSingle(false);
//      ...................... Attributes ........................
        Entities entity95 = new Entities();
        entity95 = findBean.nameEntities("Attributes",em);
        attributes52.setEntities(entity95);
//      ...................... String ........................
        AttributesTypes attributesTypes96 = new AttributesTypes();
        attributesTypes96 = findBean.nameAttributesTypes("String",em);
        attributes52.setAttributesTypes(attributesTypes96);
        em.persist(attributes52);
        em.flush();

        Entities entities53 = new Entities();
        entities53.setName("GroupIds");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId97 = new GroupIds();
        groupId97 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities53.setGroupIds(groupId97);
        em.persist(entities53);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes54 = new Attributes();
        attributes54.setName("name");
        attributes54.setNullable(false);
        attributes54.setSingle(true);
//      ...................... GroupIds ........................
        Entities entity98 = new Entities();
        entity98 = findBean.nameEntities("GroupIds",em);
        attributes54.setEntities(entity98);
//      ...................... String ........................
        AttributesTypes attributesTypes99 = new AttributesTypes();
        attributesTypes99 = findBean.nameAttributesTypes("String",em);
        attributes54.setAttributesTypes(attributesTypes99);
        em.persist(attributes54);
        em.flush();

        Attributes attributes55 = new Attributes();
        attributes55.setName("groupId");
        attributes55.setNullable(false);
        attributes55.setSingle(false);
//      ...................... GroupIds ........................
        Entities entity100 = new Entities();
        entity100 = findBean.nameEntities("GroupIds",em);
        attributes55.setEntities(entity100);
//      ...................... String ........................
        AttributesTypes attributesTypes101 = new AttributesTypes();
        attributesTypes101 = findBean.nameAttributesTypes("String",em);
        attributes55.setAttributesTypes(attributesTypes101);
        em.persist(attributes55);
        em.flush();

        Attributes attributes56 = new Attributes();
        attributes56.setName("artifactId");
        attributes56.setNullable(true);
        attributes56.setSingle(true);
//      ...................... GroupIds ........................
        Entities entity102 = new Entities();
        entity102 = findBean.nameEntities("GroupIds",em);
        attributes56.setEntities(entity102);
//      ...................... String ........................
        AttributesTypes attributesTypes103 = new AttributesTypes();
        attributesTypes103 = findBean.nameAttributesTypes("String",em);
        attributes56.setAttributesTypes(attributesTypes103);
        em.persist(attributes56);
        em.flush();

        Attributes attributes57 = new Attributes();
        attributes57.setName("version");
        attributes57.setNullable(true);
        attributes57.setSingle(false);
//      ...................... GroupIds ........................
        Entities entity104 = new Entities();
        entity104 = findBean.nameEntities("GroupIds",em);
        attributes57.setEntities(entity104);
//      ...................... String ........................
        AttributesTypes attributesTypes105 = new AttributesTypes();
        attributesTypes105 = findBean.nameAttributesTypes("String",em);
        attributes57.setAttributesTypes(attributesTypes105);
        em.persist(attributes57);
        em.flush();

        Attributes attributes58 = new Attributes();
        attributes58.setName("code");
        attributes58.setNullable(true);
        attributes58.setSingle(true);
//      ...................... GroupIds ........................
        Entities entity106 = new Entities();
        entity106 = findBean.nameEntities("GroupIds",em);
        attributes58.setEntities(entity106);
//      ...................... String ........................
        AttributesTypes attributesTypes107 = new AttributesTypes();
        attributesTypes107 = findBean.nameAttributesTypes("String",em);
        attributes58.setAttributesTypes(attributesTypes107);
        em.persist(attributes58);
        em.flush();

        Attributes attributes59 = new Attributes();
        attributes59.setName("date");
        attributes59.setNullable(true);
        attributes59.setSingle(false);
//      ...................... GroupIds ........................
        Entities entity108 = new Entities();
        entity108 = findBean.nameEntities("GroupIds",em);
        attributes59.setEntities(entity108);
//      ...................... Date ........................
        AttributesTypes attributesTypes109 = new AttributesTypes();
        attributesTypes109 = findBean.nameAttributesTypes("Date",em);
        attributes59.setAttributesTypes(attributesTypes109);
        em.persist(attributes59);
        em.flush();

        Entities entities60 = new Entities();
        entities60.setName("Relationships");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId110 = new GroupIds();
        groupId110 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities60.setGroupIds(groupId110);
        em.persist(entities60);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes61 = new Attributes();
        attributes61.setName("name");
        attributes61.setNullable(true);
        attributes61.setSingle(false);
//      ...................... Relationships ........................
        Entities entity111 = new Entities();
        entity111 = findBean.nameEntities("Relationships",em);
        attributes61.setEntities(entity111);
//      ...................... String ........................
        AttributesTypes attributesTypes112 = new AttributesTypes();
        attributesTypes112 = findBean.nameAttributesTypes("String",em);
        attributes61.setAttributesTypes(attributesTypes112);
        em.persist(attributes61);
        em.flush();

        Attributes attributes62 = new Attributes();
        attributes62.setName("optionality");
        attributes62.setNullable(true);
        attributes62.setSingle(false);
//      ...................... Relationships ........................
        Entities entity113 = new Entities();
        entity113 = findBean.nameEntities("Relationships",em);
        attributes62.setEntities(entity113);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes114 = new AttributesTypes();
        attributesTypes114 = findBean.nameAttributesTypes("Boolean",em);
        attributes62.setAttributesTypes(attributesTypes114);
        em.persist(attributes62);
        em.flush();

        Attributes attributes63 = new Attributes();
        attributes63.setName("isEmbedded");
        attributes63.setNullable(true);
        attributes63.setSingle(false);
//      ...................... Relationships ........................
        Entities entity115 = new Entities();
        entity115 = findBean.nameEntities("Relationships",em);
        attributes63.setEntities(entity115);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes116 = new AttributesTypes();
        attributesTypes116 = findBean.nameAttributesTypes("Boolean",em);
        attributes63.setAttributesTypes(attributesTypes116);
        em.persist(attributes63);
        em.flush();

        Attributes attributes64 = new Attributes();
        attributes64.setName("observations");
        attributes64.setNullable(true);
        attributes64.setSingle(false);
//      ...................... Relationships ........................
        Entities entity117 = new Entities();
        entity117 = findBean.nameEntities("Relationships",em);
        attributes64.setEntities(entity117);
//      ...................... String ........................
        AttributesTypes attributesTypes118 = new AttributesTypes();
        attributesTypes118 = findBean.nameAttributesTypes("String",em);
        attributes64.setAttributesTypes(attributesTypes118);
        em.persist(attributes64);
        em.flush();

        Entities entities65 = new Entities();
        entities65.setName("Models");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId119 = new GroupIds();
        groupId119 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities65.setGroupIds(groupId119);
        em.persist(entities65);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes66 = new Attributes();
        attributes66.setName("version");
        attributes66.setNullable(true);
        attributes66.setSingle(false);
//      ...................... Models ........................
        Entities entity120 = new Entities();
        entity120 = findBean.nameEntities("Models",em);
        attributes66.setEntities(entity120);
//      ...................... String ........................
        AttributesTypes attributesTypes121 = new AttributesTypes();
        attributesTypes121 = findBean.nameAttributesTypes("String",em);
        attributes66.setAttributesTypes(attributesTypes121);
        em.persist(attributes66);
        em.flush();

        Attributes attributes67 = new Attributes();
        attributes67.setName("code");
        attributes67.setNullable(true);
        attributes67.setSingle(true);
//      ...................... Models ........................
        Entities entity122 = new Entities();
        entity122 = findBean.nameEntities("Models",em);
        attributes67.setEntities(entity122);
//      ...................... String ........................
        AttributesTypes attributesTypes123 = new AttributesTypes();
        attributesTypes123 = findBean.nameAttributesTypes("String",em);
        attributes67.setAttributesTypes(attributesTypes123);
        em.persist(attributes67);
        em.flush();

        Attributes attributes68 = new Attributes();
        attributes68.setName("date");
        attributes68.setNullable(true);
        attributes68.setSingle(false);
//      ...................... Models ........................
        Entities entity124 = new Entities();
        entity124 = findBean.nameEntities("Models",em);
        attributes68.setEntities(entity124);
//      ...................... Date ........................
        AttributesTypes attributesTypes125 = new AttributesTypes();
        attributesTypes125 = findBean.nameAttributesTypes("Date",em);
        attributes68.setAttributesTypes(attributesTypes125);
        em.persist(attributes68);
        em.flush();

        Attributes attributes69 = new Attributes();
        attributes69.setName("name");
        attributes69.setNullable(false);
        attributes69.setSingle(true);
//      ...................... Models ........................
        Entities entity126 = new Entities();
        entity126 = findBean.nameEntities("Models",em);
        attributes69.setEntities(entity126);
//      ...................... String ........................
        AttributesTypes attributesTypes127 = new AttributesTypes();
        attributesTypes127 = findBean.nameAttributesTypes("String",em);
        attributes69.setAttributesTypes(attributesTypes127);
        em.persist(attributes69);
        em.flush();

        Attributes attributes70 = new Attributes();
        attributes70.setName("groupId");
        attributes70.setNullable(false);
        attributes70.setSingle(false);
//      ...................... Models ........................
        Entities entity128 = new Entities();
        entity128 = findBean.nameEntities("Models",em);
        attributes70.setEntities(entity128);
//      ...................... String ........................
        AttributesTypes attributesTypes129 = new AttributesTypes();
        attributesTypes129 = findBean.nameAttributesTypes("String",em);
        attributes70.setAttributesTypes(attributesTypes129);
        em.persist(attributes70);
        em.flush();

        Attributes attributes71 = new Attributes();
        attributes71.setName("artifactId");
        attributes71.setNullable(true);
        attributes71.setSingle(true);
//      ...................... Models ........................
        Entities entity130 = new Entities();
        entity130 = findBean.nameEntities("Models",em);
        attributes71.setEntities(entity130);
//      ...................... String ........................
        AttributesTypes attributesTypes131 = new AttributesTypes();
        attributesTypes131 = findBean.nameAttributesTypes("String",em);
        attributes71.setAttributesTypes(attributesTypes131);
        em.persist(attributes71);
        em.flush();

        Entities entities72 = new Entities();
        entities72.setName("Developments");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId132 = new GroupIds();
        groupId132 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities72.setGroupIds(groupId132);
        em.persist(entities72);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes73 = new Attributes();
        attributes73.setName("artifactId");
        attributes73.setNullable(true);
        attributes73.setSingle(true);
//      ...................... Developments ........................
        Entities entity133 = new Entities();
        entity133 = findBean.nameEntities("Developments",em);
        attributes73.setEntities(entity133);
//      ...................... String ........................
        AttributesTypes attributesTypes134 = new AttributesTypes();
        attributesTypes134 = findBean.nameAttributesTypes("String",em);
        attributes73.setAttributesTypes(attributesTypes134);
        em.persist(attributes73);
        em.flush();

        Attributes attributes74 = new Attributes();
        attributes74.setName("version");
        attributes74.setNullable(true);
        attributes74.setSingle(false);
//      ...................... Developments ........................
        Entities entity135 = new Entities();
        entity135 = findBean.nameEntities("Developments",em);
        attributes74.setEntities(entity135);
//      ...................... String ........................
        AttributesTypes attributesTypes136 = new AttributesTypes();
        attributesTypes136 = findBean.nameAttributesTypes("String",em);
        attributes74.setAttributesTypes(attributesTypes136);
        em.persist(attributes74);
        em.flush();

        Attributes attributes75 = new Attributes();
        attributes75.setName("code");
        attributes75.setNullable(true);
        attributes75.setSingle(true);
//      ...................... Developments ........................
        Entities entity137 = new Entities();
        entity137 = findBean.nameEntities("Developments",em);
        attributes75.setEntities(entity137);
//      ...................... String ........................
        AttributesTypes attributesTypes138 = new AttributesTypes();
        attributesTypes138 = findBean.nameAttributesTypes("String",em);
        attributes75.setAttributesTypes(attributesTypes138);
        em.persist(attributes75);
        em.flush();

        Attributes attributes76 = new Attributes();
        attributes76.setName("date");
        attributes76.setNullable(true);
        attributes76.setSingle(false);
//      ...................... Developments ........................
        Entities entity139 = new Entities();
        entity139 = findBean.nameEntities("Developments",em);
        attributes76.setEntities(entity139);
//      ...................... Date ........................
        AttributesTypes attributesTypes140 = new AttributesTypes();
        attributesTypes140 = findBean.nameAttributesTypes("Date",em);
        attributes76.setAttributesTypes(attributesTypes140);
        em.persist(attributes76);
        em.flush();

        Attributes attributes77 = new Attributes();
        attributes77.setName("name");
        attributes77.setNullable(false);
        attributes77.setSingle(true);
//      ...................... Developments ........................
        Entities entity141 = new Entities();
        entity141 = findBean.nameEntities("Developments",em);
        attributes77.setEntities(entity141);
//      ...................... String ........................
        AttributesTypes attributesTypes142 = new AttributesTypes();
        attributesTypes142 = findBean.nameAttributesTypes("String",em);
        attributes77.setAttributesTypes(attributesTypes142);
        em.persist(attributes77);
        em.flush();

        Attributes attributes78 = new Attributes();
        attributes78.setName("groupId");
        attributes78.setNullable(false);
        attributes78.setSingle(false);
//      ...................... Developments ........................
        Entities entity143 = new Entities();
        entity143 = findBean.nameEntities("Developments",em);
        attributes78.setEntities(entity143);
//      ...................... String ........................
        AttributesTypes attributesTypes144 = new AttributesTypes();
        attributesTypes144 = findBean.nameAttributesTypes("String",em);
        attributes78.setAttributesTypes(attributesTypes144);
        em.persist(attributes78);
        em.flush();

//      ---------------------- Relationships ------------------------

/*
. AttributesTypes . *..* AttributesProperties
. AttributesTypes . 1..* Attributes
. Dependencies . 1..* Imports
. AttributesProperties . *..* Imports
. AttributesProperties . 1..* Chapters
. Cardinalities . 1..* Chapters
. Cardinalities . 1..* Relationships
. Cardinalities . *..* Imports
. Entities . 1..* Series
. Entities . 1..* Relationships
. Entities . 1..* Attributes
. Entities . 1..* NameQueries
. Entities . *..* Imports
. Entities . 1..* Relationships
. Attributes . *..* AttributesProperties
. GroupIds . 1..* Entities
. Relationships . 1..* Chapters
. Relationships . *..* AttributesProperties
. Models . 1..* Series
. Models . *..* GroupIds
. Models . 1..* Chapters
. Developments . 1..* Series
. Developments . *..* Models
. Developments . 1..* Chapters
*/
        Relationships relationships1 = new Relationships();
        relationships1.setOptionality(true);
        relationships1.setIsEmbedded(false);
        relationships1.setName("");
//      ...................... AttributesTypes ........................
        Entities entities145 = new Entities();
        entities145 = findBean.nameEntities("AttributesTypes",em);
        relationships1.setFrom(entities145);
//      ...................... AttributesProperties ........................
        Entities entities146 = new Entities();
        entities146 = findBean.nameEntities("AttributesProperties",em);
        relationships1.setTo(entities146);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities147 = new Cardinalities();
        cardinalities147 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships1.setCardinalities(cardinalities147);
        em.persist(relationships1);
        em.flush();

        Relationships relationships2 = new Relationships();
        relationships2.setOptionality(true);
        relationships2.setIsEmbedded(false);
        relationships2.setName("");
//      ...................... AttributesTypes ........................
        Entities entities148 = new Entities();
        entities148 = findBean.nameEntities("AttributesTypes",em);
        relationships2.setFrom(entities148);
//      ...................... Attributes ........................
        Entities entities149 = new Entities();
        entities149 = findBean.nameEntities("Attributes",em);
        relationships2.setTo(entities149);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities150 = new Cardinalities();
        cardinalities150 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships2.setCardinalities(cardinalities150);
        em.persist(relationships2);
        em.flush();

        Relationships relationships3 = new Relationships();
        relationships3.setOptionality(true);
        relationships3.setIsEmbedded(false);
        relationships3.setName("");
//      ...................... Dependencies ........................
        Entities entities151 = new Entities();
        entities151 = findBean.nameEntities("Dependencies",em);
        relationships3.setFrom(entities151);
//      ...................... Imports ........................
        Entities entities152 = new Entities();
        entities152 = findBean.nameEntities("Imports",em);
        relationships3.setTo(entities152);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities153 = new Cardinalities();
        cardinalities153 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships3.setCardinalities(cardinalities153);
        em.persist(relationships3);
        em.flush();

        Relationships relationships4 = new Relationships();
        relationships4.setOptionality(true);
        relationships4.setIsEmbedded(false);
        relationships4.setName("");
//      ...................... AttributesProperties ........................
        Entities entities154 = new Entities();
        entities154 = findBean.nameEntities("AttributesProperties",em);
        relationships4.setFrom(entities154);
//      ...................... Imports ........................
        Entities entities155 = new Entities();
        entities155 = findBean.nameEntities("Imports",em);
        relationships4.setTo(entities155);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities156 = new Cardinalities();
        cardinalities156 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships4.setCardinalities(cardinalities156);
        em.persist(relationships4);
        em.flush();

        Relationships relationships5 = new Relationships();
        relationships5.setOptionality(true);
        relationships5.setIsEmbedded(false);
        relationships5.setName("");
//      ...................... AttributesProperties ........................
        Entities entities157 = new Entities();
        entities157 = findBean.nameEntities("AttributesProperties",em);
        relationships5.setFrom(entities157);
//      ...................... Chapters ........................
        Entities entities158 = new Entities();
        entities158 = findBean.nameEntities("Chapters",em);
        relationships5.setTo(entities158);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities159 = new Cardinalities();
        cardinalities159 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships5.setCardinalities(cardinalities159);
        em.persist(relationships5);
        em.flush();

        Relationships relationships6 = new Relationships();
        relationships6.setOptionality(true);
        relationships6.setIsEmbedded(false);
        relationships6.setName("");
//      ...................... Cardinalities ........................
        Entities entities160 = new Entities();
        entities160 = findBean.nameEntities("Cardinalities",em);
        relationships6.setFrom(entities160);
//      ...................... Chapters ........................
        Entities entities161 = new Entities();
        entities161 = findBean.nameEntities("Chapters",em);
        relationships6.setTo(entities161);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities162 = new Cardinalities();
        cardinalities162 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships6.setCardinalities(cardinalities162);
        em.persist(relationships6);
        em.flush();

        Relationships relationships7 = new Relationships();
        relationships7.setOptionality(true);
        relationships7.setIsEmbedded(false);
        relationships7.setName("");
//      ...................... Cardinalities ........................
        Entities entities163 = new Entities();
        entities163 = findBean.nameEntities("Cardinalities",em);
        relationships7.setFrom(entities163);
//      ...................... Relationships ........................
        Entities entities164 = new Entities();
        entities164 = findBean.nameEntities("Relationships",em);
        relationships7.setTo(entities164);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities165 = new Cardinalities();
        cardinalities165 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships7.setCardinalities(cardinalities165);
        em.persist(relationships7);
        em.flush();

        Relationships relationships8 = new Relationships();
        relationships8.setOptionality(true);
        relationships8.setIsEmbedded(false);
        relationships8.setName("");
//      ...................... Cardinalities ........................
        Entities entities166 = new Entities();
        entities166 = findBean.nameEntities("Cardinalities",em);
        relationships8.setFrom(entities166);
//      ...................... Imports ........................
        Entities entities167 = new Entities();
        entities167 = findBean.nameEntities("Imports",em);
        relationships8.setTo(entities167);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities168 = new Cardinalities();
        cardinalities168 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships8.setCardinalities(cardinalities168);
        em.persist(relationships8);
        em.flush();

        Relationships relationships9 = new Relationships();
        relationships9.setOptionality(true);
        relationships9.setIsEmbedded(false);
        relationships9.setName("");
//      ...................... Entities ........................
        Entities entities169 = new Entities();
        entities169 = findBean.nameEntities("Entities",em);
        relationships9.setFrom(entities169);
//      ...................... Series ........................
        Entities entities170 = new Entities();
        entities170 = findBean.nameEntities("Series",em);
        relationships9.setTo(entities170);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities171 = new Cardinalities();
        cardinalities171 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships9.setCardinalities(cardinalities171);
        em.persist(relationships9);
        em.flush();

        Relationships relationships10 = new Relationships();
        relationships10.setOptionality(true);
        relationships10.setIsEmbedded(false);
        relationships10.setName("from");
//      ...................... Entities ........................
        Entities entities172 = new Entities();
        entities172 = findBean.nameEntities("Entities",em);
        relationships10.setFrom(entities172);
//      ...................... Relationships ........................
        Entities entities173 = new Entities();
        entities173 = findBean.nameEntities("Relationships",em);
        relationships10.setTo(entities173);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities174 = new Cardinalities();
        cardinalities174 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships10.setCardinalities(cardinalities174);
        em.persist(relationships10);
        em.flush();

        Relationships relationships11 = new Relationships();
        relationships11.setOptionality(true);
        relationships11.setIsEmbedded(false);
        relationships11.setName("");
//      ...................... Entities ........................
        Entities entities175 = new Entities();
        entities175 = findBean.nameEntities("Entities",em);
        relationships11.setFrom(entities175);
//      ...................... Attributes ........................
        Entities entities176 = new Entities();
        entities176 = findBean.nameEntities("Attributes",em);
        relationships11.setTo(entities176);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities177 = new Cardinalities();
        cardinalities177 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships11.setCardinalities(cardinalities177);
        em.persist(relationships11);
        em.flush();

        Relationships relationships12 = new Relationships();
        relationships12.setOptionality(true);
        relationships12.setIsEmbedded(false);
        relationships12.setName("");
//      ...................... Entities ........................
        Entities entities178 = new Entities();
        entities178 = findBean.nameEntities("Entities",em);
        relationships12.setFrom(entities178);
//      ...................... NameQueries ........................
        Entities entities179 = new Entities();
        entities179 = findBean.nameEntities("NameQueries",em);
        relationships12.setTo(entities179);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities180 = new Cardinalities();
        cardinalities180 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships12.setCardinalities(cardinalities180);
        em.persist(relationships12);
        em.flush();

        Relationships relationships13 = new Relationships();
        relationships13.setOptionality(true);
        relationships13.setIsEmbedded(false);
        relationships13.setName("");
//      ...................... Entities ........................
        Entities entities181 = new Entities();
        entities181 = findBean.nameEntities("Entities",em);
        relationships13.setFrom(entities181);
//      ...................... Imports ........................
        Entities entities182 = new Entities();
        entities182 = findBean.nameEntities("Imports",em);
        relationships13.setTo(entities182);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities183 = new Cardinalities();
        cardinalities183 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships13.setCardinalities(cardinalities183);
        em.persist(relationships13);
        em.flush();

        Relationships relationships14 = new Relationships();
        relationships14.setOptionality(true);
        relationships14.setIsEmbedded(false);
        relationships14.setName("to");
//      ...................... Entities ........................
        Entities entities184 = new Entities();
        entities184 = findBean.nameEntities("Entities",em);
        relationships14.setFrom(entities184);
//      ...................... Relationships ........................
        Entities entities185 = new Entities();
        entities185 = findBean.nameEntities("Relationships",em);
        relationships14.setTo(entities185);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities186 = new Cardinalities();
        cardinalities186 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships14.setCardinalities(cardinalities186);
        em.persist(relationships14);
        em.flush();

        Relationships relationships15 = new Relationships();
        relationships15.setOptionality(true);
        relationships15.setIsEmbedded(false);
        relationships15.setName("");
//      ...................... Attributes ........................
        Entities entities187 = new Entities();
        entities187 = findBean.nameEntities("Attributes",em);
        relationships15.setFrom(entities187);
//      ...................... AttributesProperties ........................
        Entities entities188 = new Entities();
        entities188 = findBean.nameEntities("AttributesProperties",em);
        relationships15.setTo(entities188);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities189 = new Cardinalities();
        cardinalities189 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships15.setCardinalities(cardinalities189);
        em.persist(relationships15);
        em.flush();

        Relationships relationships16 = new Relationships();
        relationships16.setOptionality(true);
        relationships16.setIsEmbedded(false);
        relationships16.setName("");
//      ...................... GroupIds ........................
        Entities entities190 = new Entities();
        entities190 = findBean.nameEntities("GroupIds",em);
        relationships16.setFrom(entities190);
//      ...................... Entities ........................
        Entities entities191 = new Entities();
        entities191 = findBean.nameEntities("Entities",em);
        relationships16.setTo(entities191);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities192 = new Cardinalities();
        cardinalities192 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships16.setCardinalities(cardinalities192);
        em.persist(relationships16);
        em.flush();

        Relationships relationships17 = new Relationships();
        relationships17.setOptionality(true);
        relationships17.setIsEmbedded(false);
        relationships17.setName("");
//      ...................... Relationships ........................
        Entities entities193 = new Entities();
        entities193 = findBean.nameEntities("Relationships",em);
        relationships17.setFrom(entities193);
//      ...................... Chapters ........................
        Entities entities194 = new Entities();
        entities194 = findBean.nameEntities("Chapters",em);
        relationships17.setTo(entities194);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities195 = new Cardinalities();
        cardinalities195 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships17.setCardinalities(cardinalities195);
        em.persist(relationships17);
        em.flush();

        Relationships relationships18 = new Relationships();
        relationships18.setOptionality(true);
        relationships18.setIsEmbedded(false);
        relationships18.setName("");
//      ...................... Relationships ........................
        Entities entities196 = new Entities();
        entities196 = findBean.nameEntities("Relationships",em);
        relationships18.setFrom(entities196);
//      ...................... AttributesProperties ........................
        Entities entities197 = new Entities();
        entities197 = findBean.nameEntities("AttributesProperties",em);
        relationships18.setTo(entities197);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities198 = new Cardinalities();
        cardinalities198 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships18.setCardinalities(cardinalities198);
        em.persist(relationships18);
        em.flush();

        Relationships relationships19 = new Relationships();
        relationships19.setOptionality(true);
        relationships19.setIsEmbedded(false);
        relationships19.setName("");
//      ...................... Models ........................
        Entities entities199 = new Entities();
        entities199 = findBean.nameEntities("Models",em);
        relationships19.setFrom(entities199);
//      ...................... Series ........................
        Entities entities200 = new Entities();
        entities200 = findBean.nameEntities("Series",em);
        relationships19.setTo(entities200);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities201 = new Cardinalities();
        cardinalities201 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships19.setCardinalities(cardinalities201);
        em.persist(relationships19);
        em.flush();

        Relationships relationships20 = new Relationships();
        relationships20.setOptionality(true);
        relationships20.setIsEmbedded(false);
        relationships20.setName("");
//      ...................... Models ........................
        Entities entities202 = new Entities();
        entities202 = findBean.nameEntities("Models",em);
        relationships20.setFrom(entities202);
//      ...................... GroupIds ........................
        Entities entities203 = new Entities();
        entities203 = findBean.nameEntities("GroupIds",em);
        relationships20.setTo(entities203);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities204 = new Cardinalities();
        cardinalities204 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships20.setCardinalities(cardinalities204);
        em.persist(relationships20);
        em.flush();

        Relationships relationships21 = new Relationships();
        relationships21.setOptionality(true);
        relationships21.setIsEmbedded(false);
        relationships21.setName("");
//      ...................... Models ........................
        Entities entities205 = new Entities();
        entities205 = findBean.nameEntities("Models",em);
        relationships21.setFrom(entities205);
//      ...................... Chapters ........................
        Entities entities206 = new Entities();
        entities206 = findBean.nameEntities("Chapters",em);
        relationships21.setTo(entities206);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities207 = new Cardinalities();
        cardinalities207 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships21.setCardinalities(cardinalities207);
        em.persist(relationships21);
        em.flush();

        Relationships relationships22 = new Relationships();
        relationships22.setOptionality(true);
        relationships22.setIsEmbedded(false);
        relationships22.setName("");
//      ...................... Developments ........................
        Entities entities208 = new Entities();
        entities208 = findBean.nameEntities("Developments",em);
        relationships22.setFrom(entities208);
//      ...................... Series ........................
        Entities entities209 = new Entities();
        entities209 = findBean.nameEntities("Series",em);
        relationships22.setTo(entities209);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities210 = new Cardinalities();
        cardinalities210 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships22.setCardinalities(cardinalities210);
        em.persist(relationships22);
        em.flush();

        Relationships relationships23 = new Relationships();
        relationships23.setOptionality(true);
        relationships23.setIsEmbedded(false);
        relationships23.setName("");
//      ...................... Developments ........................
        Entities entities211 = new Entities();
        entities211 = findBean.nameEntities("Developments",em);
        relationships23.setFrom(entities211);
//      ...................... Models ........................
        Entities entities212 = new Entities();
        entities212 = findBean.nameEntities("Models",em);
        relationships23.setTo(entities212);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities213 = new Cardinalities();
        cardinalities213 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships23.setCardinalities(cardinalities213);
        em.persist(relationships23);
        em.flush();

        Relationships relationships24 = new Relationships();
        relationships24.setOptionality(true);
        relationships24.setIsEmbedded(false);
        relationships24.setName("");
//      ...................... Developments ........................
        Entities entities214 = new Entities();
        entities214 = findBean.nameEntities("Developments",em);
        relationships24.setFrom(entities214);
//      ...................... Chapters ........................
        Entities entities215 = new Entities();
        entities215 = findBean.nameEntities("Chapters",em);
        relationships24.setTo(entities215);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities216 = new Cardinalities();
        cardinalities216 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships24.setCardinalities(cardinalities216);
        em.persist(relationships24);
        em.flush();

    } // data()

} // naifgSetup
