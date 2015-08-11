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
        groupIds1.setGroupId("co.simasoft.models.dev.naifg");
        groupIds1.setName("naifg");
        em.persist(groupIds1);
        em.flush();

        GroupIds groupIds2 = new GroupIds();
        groupIds2.setGroupId("co.simasoft.models.dev.naifg.dependencies");
        groupIds2.setName("dependencies");
        em.persist(groupIds2);
        em.flush();

        GroupIds groupIds3 = new GroupIds();
        groupIds3.setGroupId("co.simasoft.models.dev.naifg.sites");
        groupIds3.setName("sites");
        em.persist(groupIds3);
        em.flush();

//      ---------------------- Models ------------------------

        Models models = new Models();
        models.setGroupId("co.simasoft.naifg.naifg.naifg.naifg");
        models.setArtifactId("naifg");
        models.setVersion("1.0-SNAPSHOT");
        models.setName("naifg");

        Set<GroupIds> modelsGroupIds = new HashSet<GroupIds>();

        GroupIds modelsGroupId1 = findBean.groupGroupIds("co.simasoft.models.dev.naifg",em);
        modelsGroupIds.add(modelsGroupId1);

        GroupIds modelsGroupId2 = findBean.groupGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        modelsGroupIds.add(modelsGroupId2);

        GroupIds modelsGroupId3 = findBean.groupGroupIds("co.simasoft.models.dev.naifg.sites",em);
        modelsGroupIds.add(modelsGroupId3);

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
        entities1.setName("Entities");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId1 = new GroupIds();
        groupId1 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities1.setGroupIds(groupId1);
        em.persist(entities1);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes2 = new Attributes();
        attributes2.setName("serialID");
        attributes2.setNullable(true);
        attributes2.setSingle(true);
//      ...................... Entities ........................
        Entities entity2 = new Entities();
        entity2 = findBean.nameEntities("Entities",em);
        attributes2.setEntities(entity2);
//      ...................... String ........................
        AttributesTypes attributesTypes3 = new AttributesTypes();
        attributesTypes3 = findBean.nameAttributesTypes("String",em);
        attributes2.setAttributesTypes(attributesTypes3);
        em.persist(attributes2);
        em.flush();

        Attributes attributes3 = new Attributes();
        attributes3.setName("description");
        attributes3.setNullable(true);
        attributes3.setSingle(false);
//      ...................... Entities ........................
        Entities entity4 = new Entities();
        entity4 = findBean.nameEntities("Entities",em);
        attributes3.setEntities(entity4);
//      ...................... String ........................
        AttributesTypes attributesTypes5 = new AttributesTypes();
        attributesTypes5 = findBean.nameAttributesTypes("String",em);
        attributes3.setAttributesTypes(attributesTypes5);
        em.persist(attributes3);
        em.flush();

        Attributes attributes4 = new Attributes();
        attributes4.setName("source");
        attributes4.setNullable(true);
        attributes4.setSingle(false);
//      ...................... Entities ........................
        Entities entity6 = new Entities();
        entity6 = findBean.nameEntities("Entities",em);
        attributes4.setEntities(entity6);
//      ...................... String ........................
        AttributesTypes attributesTypes7 = new AttributesTypes();
        attributesTypes7 = findBean.nameAttributesTypes("String",em);
        attributes4.setAttributesTypes(attributesTypes7);
        em.persist(attributes4);
        em.flush();

        Attributes attributes5 = new Attributes();
        attributes5.setName("observations");
        attributes5.setNullable(true);
        attributes5.setSingle(false);
//      ...................... Entities ........................
        Entities entity8 = new Entities();
        entity8 = findBean.nameEntities("Entities",em);
        attributes5.setEntities(entity8);
//      ...................... String ........................
        AttributesTypes attributesTypes9 = new AttributesTypes();
        attributesTypes9 = findBean.nameAttributesTypes("String",em);
        attributes5.setAttributesTypes(attributesTypes9);
        em.persist(attributes5);
        em.flush();

        Attributes attributes6 = new Attributes();
        attributes6.setName("name");
        attributes6.setNullable(false);
        attributes6.setSingle(false);
//      ...................... Entities ........................
        Entities entity10 = new Entities();
        entity10 = findBean.nameEntities("Entities",em);
        attributes6.setEntities(entity10);
//      ...................... String ........................
        AttributesTypes attributesTypes11 = new AttributesTypes();
        attributesTypes11 = findBean.nameAttributesTypes("String",em);
        attributes6.setAttributesTypes(attributesTypes11);
        em.persist(attributes6);
        em.flush();

        Attributes attributes7 = new Attributes();
        attributes7.setName("annotations");
        attributes7.setNullable(true);
        attributes7.setSingle(false);
//      ...................... Entities ........................
        Entities entity12 = new Entities();
        entity12 = findBean.nameEntities("Entities",em);
        attributes7.setEntities(entity12);
//      ...................... String ........................
        AttributesTypes attributesTypes13 = new AttributesTypes();
        attributesTypes13 = findBean.nameAttributesTypes("String",em);
        attributes7.setAttributesTypes(attributesTypes13);
        em.persist(attributes7);
        em.flush();

        Attributes attributes8 = new Attributes();
        attributes8.setName("tableSecuencia");
        attributes8.setNullable(true);
        attributes8.setSingle(false);
//      ...................... Entities ........................
        Entities entity14 = new Entities();
        entity14 = findBean.nameEntities("Entities",em);
        attributes8.setEntities(entity14);
//      ...................... String ........................
        AttributesTypes attributesTypes15 = new AttributesTypes();
        attributesTypes15 = findBean.nameAttributesTypes("String",em);
        attributes8.setAttributesTypes(attributesTypes15);
        em.persist(attributes8);
        em.flush();

        Attributes attributes9 = new Attributes();
        attributes9.setName("modifier");
        attributes9.setNullable(true);
        attributes9.setSingle(false);
//      ...................... Entities ........................
        Entities entity16 = new Entities();
        entity16 = findBean.nameEntities("Entities",em);
        attributes9.setEntities(entity16);
//      ...................... String ........................
        AttributesTypes attributesTypes17 = new AttributesTypes();
        attributesTypes17 = findBean.nameAttributesTypes("String",em);
        attributes9.setAttributesTypes(attributesTypes17);
        em.persist(attributes9);
        em.flush();

        Attributes attributes10 = new Attributes();
        attributes10.setName("table");
        attributes10.setNullable(true);
        attributes10.setSingle(false);
//      ...................... Entities ........................
        Entities entity18 = new Entities();
        entity18 = findBean.nameEntities("Entities",em);
        attributes10.setEntities(entity18);
//      ...................... String ........................
        AttributesTypes attributesTypes19 = new AttributesTypes();
        attributesTypes19 = findBean.nameAttributesTypes("String",em);
        attributes10.setAttributesTypes(attributesTypes19);
        em.persist(attributes10);
        em.flush();

        Attributes attributes11 = new Attributes();
        attributes11.setName("extend");
        attributes11.setNullable(true);
        attributes11.setSingle(false);
//      ...................... Entities ........................
        Entities entity20 = new Entities();
        entity20 = findBean.nameEntities("Entities",em);
        attributes11.setEntities(entity20);
//      ...................... String ........................
        AttributesTypes attributesTypes21 = new AttributesTypes();
        attributesTypes21 = findBean.nameAttributesTypes("String",em);
        attributes11.setAttributesTypes(attributesTypes21);
        em.persist(attributes11);
        em.flush();

        Entities entities12 = new Entities();
        entities12.setName("Developments");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId22 = new GroupIds();
        groupId22 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities12.setGroupIds(groupId22);
        em.persist(entities12);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes13 = new Attributes();
        attributes13.setName("date");
        attributes13.setNullable(true);
        attributes13.setSingle(false);
//      ...................... Developments ........................
        Entities entity23 = new Entities();
        entity23 = findBean.nameEntities("Developments",em);
        attributes13.setEntities(entity23);
//      ...................... Date ........................
        AttributesTypes attributesTypes24 = new AttributesTypes();
        attributesTypes24 = findBean.nameAttributesTypes("Date",em);
        attributes13.setAttributesTypes(attributesTypes24);
        em.persist(attributes13);
        em.flush();

        Attributes attributes14 = new Attributes();
        attributes14.setName("artifactId");
        attributes14.setNullable(true);
        attributes14.setSingle(true);
//      ...................... Developments ........................
        Entities entity25 = new Entities();
        entity25 = findBean.nameEntities("Developments",em);
        attributes14.setEntities(entity25);
//      ...................... String ........................
        AttributesTypes attributesTypes26 = new AttributesTypes();
        attributesTypes26 = findBean.nameAttributesTypes("String",em);
        attributes14.setAttributesTypes(attributesTypes26);
        em.persist(attributes14);
        em.flush();

        Attributes attributes15 = new Attributes();
        attributes15.setName("code");
        attributes15.setNullable(true);
        attributes15.setSingle(true);
//      ...................... Developments ........................
        Entities entity27 = new Entities();
        entity27 = findBean.nameEntities("Developments",em);
        attributes15.setEntities(entity27);
//      ...................... String ........................
        AttributesTypes attributesTypes28 = new AttributesTypes();
        attributesTypes28 = findBean.nameAttributesTypes("String",em);
        attributes15.setAttributesTypes(attributesTypes28);
        em.persist(attributes15);
        em.flush();

        Attributes attributes16 = new Attributes();
        attributes16.setName("groupId");
        attributes16.setNullable(false);
        attributes16.setSingle(false);
//      ...................... Developments ........................
        Entities entity29 = new Entities();
        entity29 = findBean.nameEntities("Developments",em);
        attributes16.setEntities(entity29);
//      ...................... String ........................
        AttributesTypes attributesTypes30 = new AttributesTypes();
        attributesTypes30 = findBean.nameAttributesTypes("String",em);
        attributes16.setAttributesTypes(attributesTypes30);
        em.persist(attributes16);
        em.flush();

        Attributes attributes17 = new Attributes();
        attributes17.setName("name");
        attributes17.setNullable(false);
        attributes17.setSingle(true);
//      ...................... Developments ........................
        Entities entity31 = new Entities();
        entity31 = findBean.nameEntities("Developments",em);
        attributes17.setEntities(entity31);
//      ...................... String ........................
        AttributesTypes attributesTypes32 = new AttributesTypes();
        attributesTypes32 = findBean.nameAttributesTypes("String",em);
        attributes17.setAttributesTypes(attributesTypes32);
        em.persist(attributes17);
        em.flush();

        Attributes attributes18 = new Attributes();
        attributes18.setName("version");
        attributes18.setNullable(true);
        attributes18.setSingle(false);
//      ...................... Developments ........................
        Entities entity33 = new Entities();
        entity33 = findBean.nameEntities("Developments",em);
        attributes18.setEntities(entity33);
//      ...................... String ........................
        AttributesTypes attributesTypes34 = new AttributesTypes();
        attributesTypes34 = findBean.nameAttributesTypes("String",em);
        attributes18.setAttributesTypes(attributesTypes34);
        em.persist(attributes18);
        em.flush();

        Entities entities19 = new Entities();
        entities19.setName("Relationships");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId35 = new GroupIds();
        groupId35 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities19.setGroupIds(groupId35);
        em.persist(entities19);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes20 = new Attributes();
        attributes20.setName("optionality");
        attributes20.setNullable(true);
        attributes20.setSingle(false);
//      ...................... Relationships ........................
        Entities entity36 = new Entities();
        entity36 = findBean.nameEntities("Relationships",em);
        attributes20.setEntities(entity36);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes37 = new AttributesTypes();
        attributesTypes37 = findBean.nameAttributesTypes("Boolean",em);
        attributes20.setAttributesTypes(attributesTypes37);
        em.persist(attributes20);
        em.flush();

        Attributes attributes21 = new Attributes();
        attributes21.setName("name");
        attributes21.setNullable(true);
        attributes21.setSingle(false);
//      ...................... Relationships ........................
        Entities entity38 = new Entities();
        entity38 = findBean.nameEntities("Relationships",em);
        attributes21.setEntities(entity38);
//      ...................... String ........................
        AttributesTypes attributesTypes39 = new AttributesTypes();
        attributesTypes39 = findBean.nameAttributesTypes("String",em);
        attributes21.setAttributesTypes(attributesTypes39);
        em.persist(attributes21);
        em.flush();

        Attributes attributes22 = new Attributes();
        attributes22.setName("isEmbedded");
        attributes22.setNullable(true);
        attributes22.setSingle(false);
//      ...................... Relationships ........................
        Entities entity40 = new Entities();
        entity40 = findBean.nameEntities("Relationships",em);
        attributes22.setEntities(entity40);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes41 = new AttributesTypes();
        attributesTypes41 = findBean.nameAttributesTypes("Boolean",em);
        attributes22.setAttributesTypes(attributesTypes41);
        em.persist(attributes22);
        em.flush();

        Attributes attributes23 = new Attributes();
        attributes23.setName("observations");
        attributes23.setNullable(true);
        attributes23.setSingle(false);
//      ...................... Relationships ........................
        Entities entity42 = new Entities();
        entity42 = findBean.nameEntities("Relationships",em);
        attributes23.setEntities(entity42);
//      ...................... String ........................
        AttributesTypes attributesTypes43 = new AttributesTypes();
        attributesTypes43 = findBean.nameAttributesTypes("String",em);
        attributes23.setAttributesTypes(attributesTypes43);
        em.persist(attributes23);
        em.flush();

        Entities entities24 = new Entities();
        entities24.setName("Attributes");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId44 = new GroupIds();
        groupId44 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities24.setGroupIds(groupId44);
        em.persist(entities24);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes25 = new Attributes();
        attributes25.setName("annotationsMethod");
        attributes25.setNullable(true);
        attributes25.setSingle(false);
//      ...................... Attributes ........................
        Entities entity45 = new Entities();
        entity45 = findBean.nameEntities("Attributes",em);
        attributes25.setEntities(entity45);
//      ...................... String ........................
        AttributesTypes attributesTypes46 = new AttributesTypes();
        attributesTypes46 = findBean.nameAttributesTypes("String",em);
        attributes25.setAttributesTypes(attributesTypes46);
        em.persist(attributes25);
        em.flush();

        Attributes attributes26 = new Attributes();
        attributes26.setName("annotationsField");
        attributes26.setNullable(true);
        attributes26.setSingle(false);
//      ...................... Attributes ........................
        Entities entity47 = new Entities();
        entity47 = findBean.nameEntities("Attributes",em);
        attributes26.setEntities(entity47);
//      ...................... String ........................
        AttributesTypes attributesTypes48 = new AttributesTypes();
        attributesTypes48 = findBean.nameAttributesTypes("String",em);
        attributes26.setAttributesTypes(attributesTypes48);
        em.persist(attributes26);
        em.flush();

        Attributes attributes27 = new Attributes();
        attributes27.setName("descripcion");
        attributes27.setNullable(true);
        attributes27.setSingle(false);
//      ...................... Attributes ........................
        Entities entity49 = new Entities();
        entity49 = findBean.nameEntities("Attributes",em);
        attributes27.setEntities(entity49);
//      ...................... String ........................
        AttributesTypes attributesTypes50 = new AttributesTypes();
        attributesTypes50 = findBean.nameAttributesTypes("String",em);
        attributes27.setAttributesTypes(attributesTypes50);
        em.persist(attributes27);
        em.flush();

        Attributes attributes28 = new Attributes();
        attributes28.setName("single");
        attributes28.setNullable(true);
        attributes28.setSingle(false);
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

        Attributes attributes29 = new Attributes();
        attributes29.setName("nullable");
        attributes29.setNullable(true);
        attributes29.setSingle(false);
//      ...................... Attributes ........................
        Entities entity53 = new Entities();
        entity53 = findBean.nameEntities("Attributes",em);
        attributes29.setEntities(entity53);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes54 = new AttributesTypes();
        attributesTypes54 = findBean.nameAttributesTypes("Boolean",em);
        attributes29.setAttributesTypes(attributesTypes54);
        em.persist(attributes29);
        em.flush();

        Attributes attributes30 = new Attributes();
        attributes30.setName("columnDefinition");
        attributes30.setNullable(true);
        attributes30.setSingle(false);
//      ...................... Attributes ........................
        Entities entity55 = new Entities();
        entity55 = findBean.nameEntities("Attributes",em);
        attributes30.setEntities(entity55);
//      ...................... String ........................
        AttributesTypes attributesTypes56 = new AttributesTypes();
        attributesTypes56 = findBean.nameAttributesTypes("String",em);
        attributes30.setAttributesTypes(attributesTypes56);
        em.persist(attributes30);
        em.flush();

        Attributes attributes31 = new Attributes();
        attributes31.setName("observations");
        attributes31.setNullable(true);
        attributes31.setSingle(false);
//      ...................... Attributes ........................
        Entities entity57 = new Entities();
        entity57 = findBean.nameEntities("Attributes",em);
        attributes31.setEntities(entity57);
//      ...................... String ........................
        AttributesTypes attributesTypes58 = new AttributesTypes();
        attributesTypes58 = findBean.nameAttributesTypes("String",em);
        attributes31.setAttributesTypes(attributesTypes58);
        em.persist(attributes31);
        em.flush();

        Attributes attributes32 = new Attributes();
        attributes32.setName("precision");
        attributes32.setNullable(true);
        attributes32.setSingle(false);
//      ...................... Attributes ........................
        Entities entity59 = new Entities();
        entity59 = findBean.nameEntities("Attributes",em);
        attributes32.setEntities(entity59);
//      ...................... Integer ........................
        AttributesTypes attributesTypes60 = new AttributesTypes();
        attributesTypes60 = findBean.nameAttributesTypes("Integer",em);
        attributes32.setAttributesTypes(attributesTypes60);
        em.persist(attributes32);
        em.flush();

        Attributes attributes33 = new Attributes();
        attributes33.setName("access");
        attributes33.setNullable(true);
        attributes33.setSingle(false);
//      ...................... Attributes ........................
        Entities entity61 = new Entities();
        entity61 = findBean.nameEntities("Attributes",em);
        attributes33.setEntities(entity61);
//      ...................... String ........................
        AttributesTypes attributesTypes62 = new AttributesTypes();
        attributesTypes62 = findBean.nameAttributesTypes("String",em);
        attributes33.setAttributesTypes(attributesTypes62);
        em.persist(attributes33);
        em.flush();

        Attributes attributes34 = new Attributes();
        attributes34.setName("field");
        attributes34.setNullable(true);
        attributes34.setSingle(false);
//      ...................... Attributes ........................
        Entities entity63 = new Entities();
        entity63 = findBean.nameEntities("Attributes",em);
        attributes34.setEntities(entity63);
//      ...................... String ........................
        AttributesTypes attributesTypes64 = new AttributesTypes();
        attributesTypes64 = findBean.nameAttributesTypes("String",em);
        attributes34.setAttributesTypes(attributesTypes64);
        em.persist(attributes34);
        em.flush();

        Attributes attributes35 = new Attributes();
        attributes35.setName("length");
        attributes35.setNullable(true);
        attributes35.setSingle(false);
//      ...................... Attributes ........................
        Entities entity65 = new Entities();
        entity65 = findBean.nameEntities("Attributes",em);
        attributes35.setEntities(entity65);
//      ...................... Integer ........................
        AttributesTypes attributesTypes66 = new AttributesTypes();
        attributesTypes66 = findBean.nameAttributesTypes("Integer",em);
        attributes35.setAttributesTypes(attributesTypes66);
        em.persist(attributes35);
        em.flush();

        Attributes attributes36 = new Attributes();
        attributes36.setName("name");
        attributes36.setNullable(false);
        attributes36.setSingle(false);
//      ...................... Attributes ........................
        Entities entity67 = new Entities();
        entity67 = findBean.nameEntities("Attributes",em);
        attributes36.setEntities(entity67);
//      ...................... String ........................
        AttributesTypes attributesTypes68 = new AttributesTypes();
        attributesTypes68 = findBean.nameAttributesTypes("String",em);
        attributes36.setAttributesTypes(attributesTypes68);
        em.persist(attributes36);
        em.flush();

        Entities entities37 = new Entities();
        entities37.setName("NameQueries");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId69 = new GroupIds();
        groupId69 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities37.setGroupIds(groupId69);
        em.persist(entities37);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes38 = new Attributes();
        attributes38.setName("query");
        attributes38.setNullable(false);
        attributes38.setSingle(true);
//      ...................... NameQueries ........................
        Entities entity70 = new Entities();
        entity70 = findBean.nameEntities("NameQueries",em);
        attributes38.setEntities(entity70);
//      ...................... String ........................
        AttributesTypes attributesTypes71 = new AttributesTypes();
        attributesTypes71 = findBean.nameAttributesTypes("String",em);
        attributes38.setAttributesTypes(attributesTypes71);
        em.persist(attributes38);
        em.flush();

        Attributes attributes39 = new Attributes();
        attributes39.setName("observations");
        attributes39.setNullable(true);
        attributes39.setSingle(false);
//      ...................... NameQueries ........................
        Entities entity72 = new Entities();
        entity72 = findBean.nameEntities("NameQueries",em);
        attributes39.setEntities(entity72);
//      ...................... String ........................
        AttributesTypes attributesTypes73 = new AttributesTypes();
        attributesTypes73 = findBean.nameAttributesTypes("String",em);
        attributes39.setAttributesTypes(attributesTypes73);
        em.persist(attributes39);
        em.flush();

        Attributes attributes40 = new Attributes();
        attributes40.setName("name");
        attributes40.setNullable(false);
        attributes40.setSingle(true);
//      ...................... NameQueries ........................
        Entities entity74 = new Entities();
        entity74 = findBean.nameEntities("NameQueries",em);
        attributes40.setEntities(entity74);
//      ...................... String ........................
        AttributesTypes attributesTypes75 = new AttributesTypes();
        attributesTypes75 = findBean.nameAttributesTypes("String",em);
        attributes40.setAttributesTypes(attributesTypes75);
        em.persist(attributes40);
        em.flush();

        Entities entities41 = new Entities();
        entities41.setName("Models");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId76 = new GroupIds();
        groupId76 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities41.setGroupIds(groupId76);
        em.persist(entities41);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes42 = new Attributes();
        attributes42.setName("name");
        attributes42.setNullable(false);
        attributes42.setSingle(true);
//      ...................... Models ........................
        Entities entity77 = new Entities();
        entity77 = findBean.nameEntities("Models",em);
        attributes42.setEntities(entity77);
//      ...................... String ........................
        AttributesTypes attributesTypes78 = new AttributesTypes();
        attributesTypes78 = findBean.nameAttributesTypes("String",em);
        attributes42.setAttributesTypes(attributesTypes78);
        em.persist(attributes42);
        em.flush();

        Attributes attributes43 = new Attributes();
        attributes43.setName("code");
        attributes43.setNullable(true);
        attributes43.setSingle(true);
//      ...................... Models ........................
        Entities entity79 = new Entities();
        entity79 = findBean.nameEntities("Models",em);
        attributes43.setEntities(entity79);
//      ...................... String ........................
        AttributesTypes attributesTypes80 = new AttributesTypes();
        attributesTypes80 = findBean.nameAttributesTypes("String",em);
        attributes43.setAttributesTypes(attributesTypes80);
        em.persist(attributes43);
        em.flush();

        Attributes attributes44 = new Attributes();
        attributes44.setName("version");
        attributes44.setNullable(true);
        attributes44.setSingle(false);
//      ...................... Models ........................
        Entities entity81 = new Entities();
        entity81 = findBean.nameEntities("Models",em);
        attributes44.setEntities(entity81);
//      ...................... String ........................
        AttributesTypes attributesTypes82 = new AttributesTypes();
        attributesTypes82 = findBean.nameAttributesTypes("String",em);
        attributes44.setAttributesTypes(attributesTypes82);
        em.persist(attributes44);
        em.flush();

        Attributes attributes45 = new Attributes();
        attributes45.setName("artifactId");
        attributes45.setNullable(true);
        attributes45.setSingle(true);
//      ...................... Models ........................
        Entities entity83 = new Entities();
        entity83 = findBean.nameEntities("Models",em);
        attributes45.setEntities(entity83);
//      ...................... String ........................
        AttributesTypes attributesTypes84 = new AttributesTypes();
        attributesTypes84 = findBean.nameAttributesTypes("String",em);
        attributes45.setAttributesTypes(attributesTypes84);
        em.persist(attributes45);
        em.flush();

        Attributes attributes46 = new Attributes();
        attributes46.setName("groupId");
        attributes46.setNullable(false);
        attributes46.setSingle(false);
//      ...................... Models ........................
        Entities entity85 = new Entities();
        entity85 = findBean.nameEntities("Models",em);
        attributes46.setEntities(entity85);
//      ...................... String ........................
        AttributesTypes attributesTypes86 = new AttributesTypes();
        attributesTypes86 = findBean.nameAttributesTypes("String",em);
        attributes46.setAttributesTypes(attributesTypes86);
        em.persist(attributes46);
        em.flush();

        Attributes attributes47 = new Attributes();
        attributes47.setName("date");
        attributes47.setNullable(true);
        attributes47.setSingle(false);
//      ...................... Models ........................
        Entities entity87 = new Entities();
        entity87 = findBean.nameEntities("Models",em);
        attributes47.setEntities(entity87);
//      ...................... Date ........................
        AttributesTypes attributesTypes88 = new AttributesTypes();
        attributesTypes88 = findBean.nameAttributesTypes("Date",em);
        attributes47.setAttributesTypes(attributesTypes88);
        em.persist(attributes47);
        em.flush();

        Entities entities48 = new Entities();
        entities48.setName("Cardinalities");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId89 = new GroupIds();
        groupId89 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities48.setGroupIds(groupId89);
        em.persist(entities48);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes49 = new Attributes();
        attributes49.setName("unidirectional");
        attributes49.setNullable(true);
        attributes49.setSingle(false);
//      ...................... Cardinalities ........................
        Entities entity90 = new Entities();
        entity90 = findBean.nameEntities("Cardinalities",em);
        attributes49.setEntities(entity90);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes91 = new AttributesTypes();
        attributesTypes91 = findBean.nameAttributesTypes("Boolean",em);
        attributes49.setAttributesTypes(attributesTypes91);
        em.persist(attributes49);
        em.flush();

        Attributes attributes50 = new Attributes();
        attributes50.setName("annotations");
        attributes50.setNullable(true);
        attributes50.setSingle(false);
//      ...................... Cardinalities ........................
        Entities entity92 = new Entities();
        entity92 = findBean.nameEntities("Cardinalities",em);
        attributes50.setEntities(entity92);
//      ...................... String ........................
        AttributesTypes attributesTypes93 = new AttributesTypes();
        attributesTypes93 = findBean.nameAttributesTypes("String",em);
        attributes50.setAttributesTypes(attributesTypes93);
        em.persist(attributes50);
        em.flush();

        Attributes attributes51 = new Attributes();
        attributes51.setName("cardinality");
        attributes51.setNullable(false);
        attributes51.setSingle(false);
//      ...................... Cardinalities ........................
        Entities entity94 = new Entities();
        entity94 = findBean.nameEntities("Cardinalities",em);
        attributes51.setEntities(entity94);
//      ...................... String ........................
        AttributesTypes attributesTypes95 = new AttributesTypes();
        attributesTypes95 = findBean.nameAttributesTypes("String",em);
        attributes51.setAttributesTypes(attributesTypes95);
        em.persist(attributes51);
        em.flush();

        Attributes attributes52 = new Attributes();
        attributes52.setName("observations");
        attributes52.setNullable(true);
        attributes52.setSingle(false);
//      ...................... Cardinalities ........................
        Entities entity96 = new Entities();
        entity96 = findBean.nameEntities("Cardinalities",em);
        attributes52.setEntities(entity96);
//      ...................... String ........................
        AttributesTypes attributesTypes97 = new AttributesTypes();
        attributesTypes97 = findBean.nameAttributesTypes("String",em);
        attributes52.setAttributesTypes(attributesTypes97);
        em.persist(attributes52);
        em.flush();

        Attributes attributes53 = new Attributes();
        attributes53.setName("name");
        attributes53.setNullable(false);
        attributes53.setSingle(true);
//      ...................... Cardinalities ........................
        Entities entity98 = new Entities();
        entity98 = findBean.nameEntities("Cardinalities",em);
        attributes53.setEntities(entity98);
//      ...................... String ........................
        AttributesTypes attributesTypes99 = new AttributesTypes();
        attributesTypes99 = findBean.nameAttributesTypes("String",em);
        attributes53.setAttributesTypes(attributesTypes99);
        em.persist(attributes53);
        em.flush();

        Entities entities54 = new Entities();
        entities54.setName("GroupIds");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId100 = new GroupIds();
        groupId100 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities54.setGroupIds(groupId100);
        em.persist(entities54);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes55 = new Attributes();
        attributes55.setName("version");
        attributes55.setNullable(true);
        attributes55.setSingle(false);
//      ...................... GroupIds ........................
        Entities entity101 = new Entities();
        entity101 = findBean.nameEntities("GroupIds",em);
        attributes55.setEntities(entity101);
//      ...................... String ........................
        AttributesTypes attributesTypes102 = new AttributesTypes();
        attributesTypes102 = findBean.nameAttributesTypes("String",em);
        attributes55.setAttributesTypes(attributesTypes102);
        em.persist(attributes55);
        em.flush();

        Attributes attributes56 = new Attributes();
        attributes56.setName("artifactId");
        attributes56.setNullable(true);
        attributes56.setSingle(true);
//      ...................... GroupIds ........................
        Entities entity103 = new Entities();
        entity103 = findBean.nameEntities("GroupIds",em);
        attributes56.setEntities(entity103);
//      ...................... String ........................
        AttributesTypes attributesTypes104 = new AttributesTypes();
        attributesTypes104 = findBean.nameAttributesTypes("String",em);
        attributes56.setAttributesTypes(attributesTypes104);
        em.persist(attributes56);
        em.flush();

        Attributes attributes57 = new Attributes();
        attributes57.setName("date");
        attributes57.setNullable(true);
        attributes57.setSingle(false);
//      ...................... GroupIds ........................
        Entities entity105 = new Entities();
        entity105 = findBean.nameEntities("GroupIds",em);
        attributes57.setEntities(entity105);
//      ...................... Date ........................
        AttributesTypes attributesTypes106 = new AttributesTypes();
        attributesTypes106 = findBean.nameAttributesTypes("Date",em);
        attributes57.setAttributesTypes(attributesTypes106);
        em.persist(attributes57);
        em.flush();

        Attributes attributes58 = new Attributes();
        attributes58.setName("name");
        attributes58.setNullable(false);
        attributes58.setSingle(true);
//      ...................... GroupIds ........................
        Entities entity107 = new Entities();
        entity107 = findBean.nameEntities("GroupIds",em);
        attributes58.setEntities(entity107);
//      ...................... String ........................
        AttributesTypes attributesTypes108 = new AttributesTypes();
        attributesTypes108 = findBean.nameAttributesTypes("String",em);
        attributes58.setAttributesTypes(attributesTypes108);
        em.persist(attributes58);
        em.flush();

        Attributes attributes59 = new Attributes();
        attributes59.setName("code");
        attributes59.setNullable(true);
        attributes59.setSingle(true);
//      ...................... GroupIds ........................
        Entities entity109 = new Entities();
        entity109 = findBean.nameEntities("GroupIds",em);
        attributes59.setEntities(entity109);
//      ...................... String ........................
        AttributesTypes attributesTypes110 = new AttributesTypes();
        attributesTypes110 = findBean.nameAttributesTypes("String",em);
        attributes59.setAttributesTypes(attributesTypes110);
        em.persist(attributes59);
        em.flush();

        Attributes attributes60 = new Attributes();
        attributes60.setName("groupId");
        attributes60.setNullable(false);
        attributes60.setSingle(false);
//      ...................... GroupIds ........................
        Entities entity111 = new Entities();
        entity111 = findBean.nameEntities("GroupIds",em);
        attributes60.setEntities(entity111);
//      ...................... String ........................
        AttributesTypes attributesTypes112 = new AttributesTypes();
        attributesTypes112 = findBean.nameAttributesTypes("String",em);
        attributes60.setAttributesTypes(attributesTypes112);
        em.persist(attributes60);
        em.flush();

        Attributes attributes61 = new Attributes();
        attributes61.setName("isSingle");
        attributes61.setNullable(true);
        attributes61.setSingle(false);
//      ...................... GroupIds ........................
        Entities entity113 = new Entities();
        entity113 = findBean.nameEntities("GroupIds",em);
        attributes61.setEntities(entity113);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes114 = new AttributesTypes();
        attributesTypes114 = findBean.nameAttributesTypes("Boolean",em);
        attributes61.setAttributesTypes(attributesTypes114);
        em.persist(attributes61);
        em.flush();

        Entities entities62 = new Entities();
        entities62.setName("Dependencies");
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId115 = new GroupIds();
        groupId115 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities62.setGroupIds(groupId115);
        em.persist(entities62);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes63 = new Attributes();
        attributes63.setName("groupId");
        attributes63.setNullable(false);
        attributes63.setSingle(false);
//      ...................... Dependencies ........................
        Entities entity116 = new Entities();
        entity116 = findBean.nameEntities("Dependencies",em);
        attributes63.setEntities(entity116);
//      ...................... String ........................
        AttributesTypes attributesTypes117 = new AttributesTypes();
        attributesTypes117 = findBean.nameAttributesTypes("String",em);
        attributes63.setAttributesTypes(attributesTypes117);
        em.persist(attributes63);
        em.flush();

        Attributes attributes64 = new Attributes();
        attributes64.setName("version");
        attributes64.setNullable(true);
        attributes64.setSingle(false);
//      ...................... Dependencies ........................
        Entities entity118 = new Entities();
        entity118 = findBean.nameEntities("Dependencies",em);
        attributes64.setEntities(entity118);
//      ...................... String ........................
        AttributesTypes attributesTypes119 = new AttributesTypes();
        attributesTypes119 = findBean.nameAttributesTypes("String",em);
        attributes64.setAttributesTypes(attributesTypes119);
        em.persist(attributes64);
        em.flush();

        Attributes attributes65 = new Attributes();
        attributes65.setName("scope");
        attributes65.setNullable(true);
        attributes65.setSingle(false);
//      ...................... Dependencies ........................
        Entities entity120 = new Entities();
        entity120 = findBean.nameEntities("Dependencies",em);
        attributes65.setEntities(entity120);
//      ...................... String ........................
        AttributesTypes attributesTypes121 = new AttributesTypes();
        attributesTypes121 = findBean.nameAttributesTypes("String",em);
        attributes65.setAttributesTypes(attributesTypes121);
        em.persist(attributes65);
        em.flush();

        Attributes attributes66 = new Attributes();
        attributes66.setName("type");
        attributes66.setNullable(true);
        attributes66.setSingle(false);
//      ...................... Dependencies ........................
        Entities entity122 = new Entities();
        entity122 = findBean.nameEntities("Dependencies",em);
        attributes66.setEntities(entity122);
//      ...................... String ........................
        AttributesTypes attributesTypes123 = new AttributesTypes();
        attributesTypes123 = findBean.nameAttributesTypes("String",em);
        attributes66.setAttributesTypes(attributesTypes123);
        em.persist(attributes66);
        em.flush();

        Attributes attributes67 = new Attributes();
        attributes67.setName("maven");
        attributes67.setNullable(false);
        attributes67.setSingle(true);
//      ...................... Dependencies ........................
        Entities entity124 = new Entities();
        entity124 = findBean.nameEntities("Dependencies",em);
        attributes67.setEntities(entity124);
//      ...................... String ........................
        AttributesTypes attributesTypes125 = new AttributesTypes();
        attributesTypes125 = findBean.nameAttributesTypes("String",em);
        attributes67.setAttributesTypes(attributesTypes125);
        em.persist(attributes67);
        em.flush();

        Attributes attributes68 = new Attributes();
        attributes68.setName("artifactId");
        attributes68.setNullable(false);
        attributes68.setSingle(false);
//      ...................... Dependencies ........................
        Entities entity126 = new Entities();
        entity126 = findBean.nameEntities("Dependencies",em);
        attributes68.setEntities(entity126);
//      ...................... String ........................
        AttributesTypes attributesTypes127 = new AttributesTypes();
        attributesTypes127 = findBean.nameAttributesTypes("String",em);
        attributes68.setAttributesTypes(attributesTypes127);
        em.persist(attributes68);
        em.flush();

        Entities entities69 = new Entities();
        entities69.setName("AttributesTypes");
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId128 = new GroupIds();
        groupId128 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities69.setGroupIds(groupId128);
        em.persist(entities69);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes70 = new Attributes();
        attributes70.setName("precision");
        attributes70.setNullable(true);
        attributes70.setSingle(false);
//      ...................... AttributesTypes ........................
        Entities entity129 = new Entities();
        entity129 = findBean.nameEntities("AttributesTypes",em);
        attributes70.setEntities(entity129);
//      ...................... Integer ........................
        AttributesTypes attributesTypes130 = new AttributesTypes();
        attributesTypes130 = findBean.nameAttributesTypes("Integer",em);
        attributes70.setAttributesTypes(attributesTypes130);
        em.persist(attributes70);
        em.flush();

        Attributes attributes71 = new Attributes();
        attributes71.setName("length");
        attributes71.setNullable(true);
        attributes71.setSingle(false);
//      ...................... AttributesTypes ........................
        Entities entity131 = new Entities();
        entity131 = findBean.nameEntities("AttributesTypes",em);
        attributes71.setEntities(entity131);
//      ...................... Integer ........................
        AttributesTypes attributesTypes132 = new AttributesTypes();
        attributesTypes132 = findBean.nameAttributesTypes("Integer",em);
        attributes71.setAttributesTypes(attributesTypes132);
        em.persist(attributes71);
        em.flush();

        Attributes attributes72 = new Attributes();
        attributes72.setName("name");
        attributes72.setNullable(false);
        attributes72.setSingle(true);
//      ...................... AttributesTypes ........................
        Entities entity133 = new Entities();
        entity133 = findBean.nameEntities("AttributesTypes",em);
        attributes72.setEntities(entity133);
//      ...................... String ........................
        AttributesTypes attributesTypes134 = new AttributesTypes();
        attributesTypes134 = findBean.nameAttributesTypes("String",em);
        attributes72.setAttributesTypes(attributesTypes134);
        em.persist(attributes72);
        em.flush();

        Attributes attributes73 = new Attributes();
        attributes73.setName("annotations");
        attributes73.setNullable(true);
        attributes73.setSingle(false);
//      ...................... AttributesTypes ........................
        Entities entity135 = new Entities();
        entity135 = findBean.nameEntities("AttributesTypes",em);
        attributes73.setEntities(entity135);
//      ...................... String ........................
        AttributesTypes attributesTypes136 = new AttributesTypes();
        attributesTypes136 = findBean.nameAttributesTypes("String",em);
        attributes73.setAttributesTypes(attributesTypes136);
        em.persist(attributes73);
        em.flush();

        Attributes attributes74 = new Attributes();
        attributes74.setName("type");
        attributes74.setNullable(false);
        attributes74.setSingle(false);
//      ...................... AttributesTypes ........................
        Entities entity137 = new Entities();
        entity137 = findBean.nameEntities("AttributesTypes",em);
        attributes74.setEntities(entity137);
//      ...................... String ........................
        AttributesTypes attributesTypes138 = new AttributesTypes();
        attributesTypes138 = findBean.nameAttributesTypes("String",em);
        attributes74.setAttributesTypes(attributesTypes138);
        em.persist(attributes74);
        em.flush();

        Entities entities75 = new Entities();
        entities75.setName("Imports");
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId139 = new GroupIds();
        groupId139 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities75.setGroupIds(groupId139);
        em.persist(entities75);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes76 = new Attributes();
        attributes76.setName("name");
        attributes76.setNullable(false);
        attributes76.setSingle(true);
//      ...................... Imports ........................
        Entities entity140 = new Entities();
        entity140 = findBean.nameEntities("Imports",em);
        attributes76.setEntities(entity140);
//      ...................... String ........................
        AttributesTypes attributesTypes141 = new AttributesTypes();
        attributesTypes141 = findBean.nameAttributesTypes("String",em);
        attributes76.setAttributesTypes(attributesTypes141);
        em.persist(attributes76);
        em.flush();

        Entities entities77 = new Entities();
        entities77.setName("AttributesProperties");
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId142 = new GroupIds();
        groupId142 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities77.setGroupIds(groupId142);
        em.persist(entities77);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes78 = new Attributes();
        attributes78.setName("value");
        attributes78.setNullable(false);
        attributes78.setSingle(true);
//      ...................... AttributesProperties ........................
        Entities entity143 = new Entities();
        entity143 = findBean.nameEntities("AttributesProperties",em);
        attributes78.setEntities(entity143);
//      ...................... String ........................
        AttributesTypes attributesTypes144 = new AttributesTypes();
        attributesTypes144 = findBean.nameAttributesTypes("String",em);
        attributes78.setAttributesTypes(attributesTypes144);
        em.persist(attributes78);
        em.flush();

        Attributes attributes79 = new Attributes();
        attributes79.setName("name");
        attributes79.setNullable(false);
        attributes79.setSingle(true);
//      ...................... AttributesProperties ........................
        Entities entity145 = new Entities();
        entity145 = findBean.nameEntities("AttributesProperties",em);
        attributes79.setEntities(entity145);
//      ...................... String ........................
        AttributesTypes attributesTypes146 = new AttributesTypes();
        attributesTypes146 = findBean.nameAttributesTypes("String",em);
        attributes79.setAttributesTypes(attributesTypes146);
        em.persist(attributes79);
        em.flush();

        Entities entities80 = new Entities();
        entities80.setName("Sites");
//      ...................... co.simasoft.models.dev.naifg.sites ........................
        GroupIds groupId147 = new GroupIds();
        groupId147 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.sites",em);
        entities80.setGroupIds(groupId147);
        em.persist(entities80);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes81 = new Attributes();
        attributes81.setName("title");
        attributes81.setNullable(true);
        attributes81.setSingle(false);
//      ...................... Sites ........................
        Entities entity148 = new Entities();
        entity148 = findBean.nameEntities("Sites",em);
        attributes81.setEntities(entity148);
//      ...................... String ........................
        AttributesTypes attributesTypes149 = new AttributesTypes();
        attributesTypes149 = findBean.nameAttributesTypes("String",em);
        attributes81.setAttributesTypes(attributesTypes149);
        em.persist(attributes81);
        em.flush();

        Attributes attributes82 = new Attributes();
        attributes82.setName("abc");
        attributes82.setNullable(true);
        attributes82.setSingle(false);
//      ...................... Sites ........................
        Entities entity150 = new Entities();
        entity150 = findBean.nameEntities("Sites",em);
        attributes82.setEntities(entity150);
//      ...................... String ........................
        AttributesTypes attributesTypes151 = new AttributesTypes();
        attributesTypes151 = findBean.nameAttributesTypes("String",em);
        attributes82.setAttributesTypes(attributesTypes151);
        em.persist(attributes82);
        em.flush();

        Attributes attributes83 = new Attributes();
        attributes83.setName("link");
        attributes83.setNullable(false);
        attributes83.setSingle(true);
//      ...................... Sites ........................
        Entities entity152 = new Entities();
        entity152 = findBean.nameEntities("Sites",em);
        attributes83.setEntities(entity152);
//      ...................... String ........................
        AttributesTypes attributesTypes153 = new AttributesTypes();
        attributesTypes153 = findBean.nameAttributesTypes("String",em);
        attributes83.setAttributesTypes(attributesTypes153);
        em.persist(attributes83);
        em.flush();

        Entities entities84 = new Entities();
        entities84.setName("SitesTypes");
//      ...................... co.simasoft.models.dev.naifg.sites ........................
        GroupIds groupId154 = new GroupIds();
        groupId154 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.sites",em);
        entities84.setGroupIds(groupId154);
        em.persist(entities84);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes85 = new Attributes();
        attributes85.setName("name");
        attributes85.setNullable(true);
        attributes85.setSingle(false);
//      ...................... SitesTypes ........................
        Entities entity155 = new Entities();
        entity155 = findBean.nameEntities("SitesTypes",em);
        attributes85.setEntities(entity155);
//      ...................... String ........................
        AttributesTypes attributesTypes156 = new AttributesTypes();
        attributesTypes156 = findBean.nameAttributesTypes("String",em);
        attributes85.setAttributesTypes(attributesTypes156);
        em.persist(attributes85);
        em.flush();

//      ---------------------- Relationships ------------------------

/*
. Entities . *..* Imports
. Entities . 1..* Relationships
. Entities . *..* Sites
. Entities . 1..* Relationships
. Entities . 1..* NameQueries
. Entities . 1..* Attributes
. Developments . *..* Sites
. Developments . *..* Models
. Relationships . *..* AttributesProperties
. Attributes . *..* Sites
. Attributes . *..* AttributesProperties
. Models . *..* Sites
. Models . *..* GroupIds
. Cardinalities . *..* Imports
. Cardinalities . *..* Sites
. Cardinalities . 1..* Relationships
. GroupIds . 1..* Entities
. Dependencies . 1..* Imports
. Dependencies . *..* Sites
. AttributesTypes . *..* AttributesProperties
. AttributesTypes . *..* Sites
. AttributesTypes . 1..* Attributes
. Imports . *..* Sites
. AttributesProperties . *..* Imports
. AttributesProperties . *..* Sites
. SitesTypes . 1..* SitesTypes
. SitesTypes . *..* Sites
*/
        Relationships relationships1 = new Relationships();
        relationships1.setOptionality(true);
        relationships1.setIsEmbedded(false);
        relationships1.setName("");
//      ...................... Entities ........................
        Entities entities157 = new Entities();
        entities157 = findBean.nameEntities("Entities",em);
        relationships1.setFrom(entities157);
//      ...................... Imports ........................
        Entities entities158 = new Entities();
        entities158 = findBean.nameEntities("Imports",em);
        relationships1.setTo(entities158);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities159 = new Cardinalities();
        cardinalities159 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships1.setCardinalities(cardinalities159);
        em.persist(relationships1);
        em.flush();

        Relationships relationships2 = new Relationships();
        relationships2.setOptionality(true);
        relationships2.setIsEmbedded(false);
        relationships2.setName("from");
//      ...................... Entities ........................
        Entities entities160 = new Entities();
        entities160 = findBean.nameEntities("Entities",em);
        relationships2.setFrom(entities160);
//      ...................... Relationships ........................
        Entities entities161 = new Entities();
        entities161 = findBean.nameEntities("Relationships",em);
        relationships2.setTo(entities161);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities162 = new Cardinalities();
        cardinalities162 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships2.setCardinalities(cardinalities162);
        em.persist(relationships2);
        em.flush();

        Relationships relationships3 = new Relationships();
        relationships3.setOptionality(true);
        relationships3.setIsEmbedded(false);
        relationships3.setName("");
//      ...................... Entities ........................
        Entities entities163 = new Entities();
        entities163 = findBean.nameEntities("Entities",em);
        relationships3.setFrom(entities163);
//      ...................... Sites ........................
        Entities entities164 = new Entities();
        entities164 = findBean.nameEntities("Sites",em);
        relationships3.setTo(entities164);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities165 = new Cardinalities();
        cardinalities165 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships3.setCardinalities(cardinalities165);
        em.persist(relationships3);
        em.flush();

        Relationships relationships4 = new Relationships();
        relationships4.setOptionality(true);
        relationships4.setIsEmbedded(false);
        relationships4.setName("to");
//      ...................... Entities ........................
        Entities entities166 = new Entities();
        entities166 = findBean.nameEntities("Entities",em);
        relationships4.setFrom(entities166);
//      ...................... Relationships ........................
        Entities entities167 = new Entities();
        entities167 = findBean.nameEntities("Relationships",em);
        relationships4.setTo(entities167);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities168 = new Cardinalities();
        cardinalities168 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships4.setCardinalities(cardinalities168);
        em.persist(relationships4);
        em.flush();

        Relationships relationships5 = new Relationships();
        relationships5.setOptionality(true);
        relationships5.setIsEmbedded(false);
        relationships5.setName("");
//      ...................... Entities ........................
        Entities entities169 = new Entities();
        entities169 = findBean.nameEntities("Entities",em);
        relationships5.setFrom(entities169);
//      ...................... NameQueries ........................
        Entities entities170 = new Entities();
        entities170 = findBean.nameEntities("NameQueries",em);
        relationships5.setTo(entities170);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities171 = new Cardinalities();
        cardinalities171 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships5.setCardinalities(cardinalities171);
        em.persist(relationships5);
        em.flush();

        Relationships relationships6 = new Relationships();
        relationships6.setOptionality(true);
        relationships6.setIsEmbedded(false);
        relationships6.setName("");
//      ...................... Entities ........................
        Entities entities172 = new Entities();
        entities172 = findBean.nameEntities("Entities",em);
        relationships6.setFrom(entities172);
//      ...................... Attributes ........................
        Entities entities173 = new Entities();
        entities173 = findBean.nameEntities("Attributes",em);
        relationships6.setTo(entities173);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities174 = new Cardinalities();
        cardinalities174 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships6.setCardinalities(cardinalities174);
        em.persist(relationships6);
        em.flush();

        Relationships relationships7 = new Relationships();
        relationships7.setOptionality(true);
        relationships7.setIsEmbedded(false);
        relationships7.setName("");
//      ...................... Developments ........................
        Entities entities175 = new Entities();
        entities175 = findBean.nameEntities("Developments",em);
        relationships7.setFrom(entities175);
//      ...................... Sites ........................
        Entities entities176 = new Entities();
        entities176 = findBean.nameEntities("Sites",em);
        relationships7.setTo(entities176);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities177 = new Cardinalities();
        cardinalities177 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships7.setCardinalities(cardinalities177);
        em.persist(relationships7);
        em.flush();

        Relationships relationships8 = new Relationships();
        relationships8.setOptionality(true);
        relationships8.setIsEmbedded(false);
        relationships8.setName("");
//      ...................... Developments ........................
        Entities entities178 = new Entities();
        entities178 = findBean.nameEntities("Developments",em);
        relationships8.setFrom(entities178);
//      ...................... Models ........................
        Entities entities179 = new Entities();
        entities179 = findBean.nameEntities("Models",em);
        relationships8.setTo(entities179);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities180 = new Cardinalities();
        cardinalities180 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships8.setCardinalities(cardinalities180);
        em.persist(relationships8);
        em.flush();

        Relationships relationships9 = new Relationships();
        relationships9.setOptionality(true);
        relationships9.setIsEmbedded(false);
        relationships9.setName("");
//      ...................... Relationships ........................
        Entities entities181 = new Entities();
        entities181 = findBean.nameEntities("Relationships",em);
        relationships9.setFrom(entities181);
//      ...................... AttributesProperties ........................
        Entities entities182 = new Entities();
        entities182 = findBean.nameEntities("AttributesProperties",em);
        relationships9.setTo(entities182);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities183 = new Cardinalities();
        cardinalities183 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships9.setCardinalities(cardinalities183);
        em.persist(relationships9);
        em.flush();

        Relationships relationships10 = new Relationships();
        relationships10.setOptionality(true);
        relationships10.setIsEmbedded(false);
        relationships10.setName("");
//      ...................... Attributes ........................
        Entities entities184 = new Entities();
        entities184 = findBean.nameEntities("Attributes",em);
        relationships10.setFrom(entities184);
//      ...................... Sites ........................
        Entities entities185 = new Entities();
        entities185 = findBean.nameEntities("Sites",em);
        relationships10.setTo(entities185);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities186 = new Cardinalities();
        cardinalities186 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships10.setCardinalities(cardinalities186);
        em.persist(relationships10);
        em.flush();

        Relationships relationships11 = new Relationships();
        relationships11.setOptionality(true);
        relationships11.setIsEmbedded(false);
        relationships11.setName("");
//      ...................... Attributes ........................
        Entities entities187 = new Entities();
        entities187 = findBean.nameEntities("Attributes",em);
        relationships11.setFrom(entities187);
//      ...................... AttributesProperties ........................
        Entities entities188 = new Entities();
        entities188 = findBean.nameEntities("AttributesProperties",em);
        relationships11.setTo(entities188);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities189 = new Cardinalities();
        cardinalities189 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships11.setCardinalities(cardinalities189);
        em.persist(relationships11);
        em.flush();

        Relationships relationships12 = new Relationships();
        relationships12.setOptionality(true);
        relationships12.setIsEmbedded(false);
        relationships12.setName("");
//      ...................... Models ........................
        Entities entities190 = new Entities();
        entities190 = findBean.nameEntities("Models",em);
        relationships12.setFrom(entities190);
//      ...................... Sites ........................
        Entities entities191 = new Entities();
        entities191 = findBean.nameEntities("Sites",em);
        relationships12.setTo(entities191);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities192 = new Cardinalities();
        cardinalities192 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships12.setCardinalities(cardinalities192);
        em.persist(relationships12);
        em.flush();

        Relationships relationships13 = new Relationships();
        relationships13.setOptionality(true);
        relationships13.setIsEmbedded(false);
        relationships13.setName("");
//      ...................... Models ........................
        Entities entities193 = new Entities();
        entities193 = findBean.nameEntities("Models",em);
        relationships13.setFrom(entities193);
//      ...................... GroupIds ........................
        Entities entities194 = new Entities();
        entities194 = findBean.nameEntities("GroupIds",em);
        relationships13.setTo(entities194);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities195 = new Cardinalities();
        cardinalities195 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships13.setCardinalities(cardinalities195);
        em.persist(relationships13);
        em.flush();

        Relationships relationships14 = new Relationships();
        relationships14.setOptionality(true);
        relationships14.setIsEmbedded(false);
        relationships14.setName("");
//      ...................... Cardinalities ........................
        Entities entities196 = new Entities();
        entities196 = findBean.nameEntities("Cardinalities",em);
        relationships14.setFrom(entities196);
//      ...................... Imports ........................
        Entities entities197 = new Entities();
        entities197 = findBean.nameEntities("Imports",em);
        relationships14.setTo(entities197);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities198 = new Cardinalities();
        cardinalities198 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships14.setCardinalities(cardinalities198);
        em.persist(relationships14);
        em.flush();

        Relationships relationships15 = new Relationships();
        relationships15.setOptionality(true);
        relationships15.setIsEmbedded(false);
        relationships15.setName("");
//      ...................... Cardinalities ........................
        Entities entities199 = new Entities();
        entities199 = findBean.nameEntities("Cardinalities",em);
        relationships15.setFrom(entities199);
//      ...................... Sites ........................
        Entities entities200 = new Entities();
        entities200 = findBean.nameEntities("Sites",em);
        relationships15.setTo(entities200);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities201 = new Cardinalities();
        cardinalities201 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships15.setCardinalities(cardinalities201);
        em.persist(relationships15);
        em.flush();

        Relationships relationships16 = new Relationships();
        relationships16.setOptionality(true);
        relationships16.setIsEmbedded(false);
        relationships16.setName("");
//      ...................... Cardinalities ........................
        Entities entities202 = new Entities();
        entities202 = findBean.nameEntities("Cardinalities",em);
        relationships16.setFrom(entities202);
//      ...................... Relationships ........................
        Entities entities203 = new Entities();
        entities203 = findBean.nameEntities("Relationships",em);
        relationships16.setTo(entities203);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities204 = new Cardinalities();
        cardinalities204 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships16.setCardinalities(cardinalities204);
        em.persist(relationships16);
        em.flush();

        Relationships relationships17 = new Relationships();
        relationships17.setOptionality(true);
        relationships17.setIsEmbedded(false);
        relationships17.setName("");
//      ...................... GroupIds ........................
        Entities entities205 = new Entities();
        entities205 = findBean.nameEntities("GroupIds",em);
        relationships17.setFrom(entities205);
//      ...................... Entities ........................
        Entities entities206 = new Entities();
        entities206 = findBean.nameEntities("Entities",em);
        relationships17.setTo(entities206);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities207 = new Cardinalities();
        cardinalities207 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships17.setCardinalities(cardinalities207);
        em.persist(relationships17);
        em.flush();

        Relationships relationships18 = new Relationships();
        relationships18.setOptionality(true);
        relationships18.setIsEmbedded(false);
        relationships18.setName("");
//      ...................... Dependencies ........................
        Entities entities208 = new Entities();
        entities208 = findBean.nameEntities("Dependencies",em);
        relationships18.setFrom(entities208);
//      ...................... Imports ........................
        Entities entities209 = new Entities();
        entities209 = findBean.nameEntities("Imports",em);
        relationships18.setTo(entities209);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities210 = new Cardinalities();
        cardinalities210 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships18.setCardinalities(cardinalities210);
        em.persist(relationships18);
        em.flush();

        Relationships relationships19 = new Relationships();
        relationships19.setOptionality(true);
        relationships19.setIsEmbedded(false);
        relationships19.setName("");
//      ...................... Dependencies ........................
        Entities entities211 = new Entities();
        entities211 = findBean.nameEntities("Dependencies",em);
        relationships19.setFrom(entities211);
//      ...................... Sites ........................
        Entities entities212 = new Entities();
        entities212 = findBean.nameEntities("Sites",em);
        relationships19.setTo(entities212);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities213 = new Cardinalities();
        cardinalities213 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships19.setCardinalities(cardinalities213);
        em.persist(relationships19);
        em.flush();

        Relationships relationships20 = new Relationships();
        relationships20.setOptionality(true);
        relationships20.setIsEmbedded(false);
        relationships20.setName("");
//      ...................... AttributesTypes ........................
        Entities entities214 = new Entities();
        entities214 = findBean.nameEntities("AttributesTypes",em);
        relationships20.setFrom(entities214);
//      ...................... AttributesProperties ........................
        Entities entities215 = new Entities();
        entities215 = findBean.nameEntities("AttributesProperties",em);
        relationships20.setTo(entities215);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities216 = new Cardinalities();
        cardinalities216 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships20.setCardinalities(cardinalities216);
        em.persist(relationships20);
        em.flush();

        Relationships relationships21 = new Relationships();
        relationships21.setOptionality(true);
        relationships21.setIsEmbedded(false);
        relationships21.setName("");
//      ...................... AttributesTypes ........................
        Entities entities217 = new Entities();
        entities217 = findBean.nameEntities("AttributesTypes",em);
        relationships21.setFrom(entities217);
//      ...................... Sites ........................
        Entities entities218 = new Entities();
        entities218 = findBean.nameEntities("Sites",em);
        relationships21.setTo(entities218);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities219 = new Cardinalities();
        cardinalities219 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships21.setCardinalities(cardinalities219);
        em.persist(relationships21);
        em.flush();

        Relationships relationships22 = new Relationships();
        relationships22.setOptionality(true);
        relationships22.setIsEmbedded(false);
        relationships22.setName("");
//      ...................... AttributesTypes ........................
        Entities entities220 = new Entities();
        entities220 = findBean.nameEntities("AttributesTypes",em);
        relationships22.setFrom(entities220);
//      ...................... Attributes ........................
        Entities entities221 = new Entities();
        entities221 = findBean.nameEntities("Attributes",em);
        relationships22.setTo(entities221);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities222 = new Cardinalities();
        cardinalities222 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships22.setCardinalities(cardinalities222);
        em.persist(relationships22);
        em.flush();

        Relationships relationships23 = new Relationships();
        relationships23.setOptionality(true);
        relationships23.setIsEmbedded(false);
        relationships23.setName("");
//      ...................... Imports ........................
        Entities entities223 = new Entities();
        entities223 = findBean.nameEntities("Imports",em);
        relationships23.setFrom(entities223);
//      ...................... Sites ........................
        Entities entities224 = new Entities();
        entities224 = findBean.nameEntities("Sites",em);
        relationships23.setTo(entities224);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities225 = new Cardinalities();
        cardinalities225 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships23.setCardinalities(cardinalities225);
        em.persist(relationships23);
        em.flush();

        Relationships relationships24 = new Relationships();
        relationships24.setOptionality(true);
        relationships24.setIsEmbedded(false);
        relationships24.setName("");
//      ...................... AttributesProperties ........................
        Entities entities226 = new Entities();
        entities226 = findBean.nameEntities("AttributesProperties",em);
        relationships24.setFrom(entities226);
//      ...................... Imports ........................
        Entities entities227 = new Entities();
        entities227 = findBean.nameEntities("Imports",em);
        relationships24.setTo(entities227);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities228 = new Cardinalities();
        cardinalities228 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships24.setCardinalities(cardinalities228);
        em.persist(relationships24);
        em.flush();

        Relationships relationships25 = new Relationships();
        relationships25.setOptionality(true);
        relationships25.setIsEmbedded(false);
        relationships25.setName("");
//      ...................... AttributesProperties ........................
        Entities entities229 = new Entities();
        entities229 = findBean.nameEntities("AttributesProperties",em);
        relationships25.setFrom(entities229);
//      ...................... Sites ........................
        Entities entities230 = new Entities();
        entities230 = findBean.nameEntities("Sites",em);
        relationships25.setTo(entities230);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities231 = new Cardinalities();
        cardinalities231 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships25.setCardinalities(cardinalities231);
        em.persist(relationships25);
        em.flush();

        Relationships relationships26 = new Relationships();
        relationships26.setOptionality(true);
        relationships26.setIsEmbedded(false);
        relationships26.setName("");
//      ...................... SitesTypes ........................
        Entities entities232 = new Entities();
        entities232 = findBean.nameEntities("SitesTypes",em);
        relationships26.setFrom(entities232);
//      ...................... SitesTypes ........................
        Entities entities233 = new Entities();
        entities233 = findBean.nameEntities("SitesTypes",em);
        relationships26.setTo(entities233);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities234 = new Cardinalities();
        cardinalities234 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships26.setCardinalities(cardinalities234);
        em.persist(relationships26);
        em.flush();

        Relationships relationships27 = new Relationships();
        relationships27.setOptionality(true);
        relationships27.setIsEmbedded(false);
        relationships27.setName("");
//      ...................... SitesTypes ........................
        Entities entities235 = new Entities();
        entities235 = findBean.nameEntities("SitesTypes",em);
        relationships27.setFrom(entities235);
//      ...................... Sites ........................
        Entities entities236 = new Entities();
        entities236 = findBean.nameEntities("Sites",em);
        relationships27.setTo(entities236);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities237 = new Cardinalities();
        cardinalities237 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships27.setCardinalities(cardinalities237);
        em.persist(relationships27);
        em.flush();

    } // data()

} // naifgSetup
