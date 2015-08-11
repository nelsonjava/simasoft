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
        groupIds1.setGroupId("co.simasoft.models.dev.naifg.sites");
        groupIds1.setName("sites");
        em.persist(groupIds1);
        em.flush();

        GroupIds groupIds2 = new GroupIds();
        groupIds2.setGroupId("co.simasoft.models.dev.naifg.dependencies");
        groupIds2.setName("dependencies");
        em.persist(groupIds2);
        em.flush();

        GroupIds groupIds3 = new GroupIds();
        groupIds3.setGroupId("co.simasoft.models.dev.naifg");
        groupIds3.setName("naifg");
        em.persist(groupIds3);
        em.flush();

//      ---------------------- Models ------------------------

        Models models = new Models();
        models.setGroupId("co.simasoft.naifg.naifg.naifg");
        models.setArtifactId("naifg");
        models.setVersion("1.0-SNAPSHOT");
        models.setName("naifg");

        Set<GroupIds> modelsGroupIds = new HashSet<GroupIds>();

        GroupIds modelsGroupId1 = findBean.groupGroupIds("co.simasoft.models.dev.naifg.sites",em);
        modelsGroupIds.add(modelsGroupId1);

        GroupIds modelsGroupId2 = findBean.groupGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        modelsGroupIds.add(modelsGroupId2);

        GroupIds modelsGroupId3 = findBean.groupGroupIds("co.simasoft.models.dev.naifg",em);
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
        entities1.setName("SitesTypes");
//      ...................... co.simasoft.models.dev.naifg.sites ........................
        GroupIds groupId1 = new GroupIds();
        groupId1 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.sites",em);
        entities1.setGroupIds(groupId1);
        em.persist(entities1);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes2 = new Attributes();
        attributes2.setName("name");
        attributes2.setNullable(true);
        attributes2.setSingle(false);
//      ...................... SitesTypes ........................
        Entities entity2 = new Entities();
        entity2 = findBean.nameEntities("SitesTypes",em);
        attributes2.setEntities(entity2);
//      ...................... String ........................
        AttributesTypes attributesTypes3 = new AttributesTypes();
        attributesTypes3 = findBean.nameAttributesTypes("String",em);
        attributes2.setAttributesTypes(attributesTypes3);
        em.persist(attributes2);
        em.flush();

        Entities entities3 = new Entities();
        entities3.setName("Sites");
//      ...................... co.simasoft.models.dev.naifg.sites ........................
        GroupIds groupId4 = new GroupIds();
        groupId4 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.sites",em);
        entities3.setGroupIds(groupId4);
        em.persist(entities3);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes4 = new Attributes();
        attributes4.setName("link");
        attributes4.setNullable(false);
        attributes4.setSingle(true);
//      ...................... Sites ........................
        Entities entity5 = new Entities();
        entity5 = findBean.nameEntities("Sites",em);
        attributes4.setEntities(entity5);
//      ...................... String ........................
        AttributesTypes attributesTypes6 = new AttributesTypes();
        attributesTypes6 = findBean.nameAttributesTypes("String",em);
        attributes4.setAttributesTypes(attributesTypes6);
        em.persist(attributes4);
        em.flush();

        Attributes attributes5 = new Attributes();
        attributes5.setName("abc");
        attributes5.setNullable(true);
        attributes5.setSingle(false);
//      ...................... Sites ........................
        Entities entity7 = new Entities();
        entity7 = findBean.nameEntities("Sites",em);
        attributes5.setEntities(entity7);
//      ...................... String ........................
        AttributesTypes attributesTypes8 = new AttributesTypes();
        attributesTypes8 = findBean.nameAttributesTypes("String",em);
        attributes5.setAttributesTypes(attributesTypes8);
        em.persist(attributes5);
        em.flush();

        Attributes attributes6 = new Attributes();
        attributes6.setName("title");
        attributes6.setNullable(true);
        attributes6.setSingle(false);
//      ...................... Sites ........................
        Entities entity9 = new Entities();
        entity9 = findBean.nameEntities("Sites",em);
        attributes6.setEntities(entity9);
//      ...................... String ........................
        AttributesTypes attributesTypes10 = new AttributesTypes();
        attributesTypes10 = findBean.nameAttributesTypes("String",em);
        attributes6.setAttributesTypes(attributesTypes10);
        em.persist(attributes6);
        em.flush();

        Entities entities7 = new Entities();
        entities7.setName("AttributesTypes");
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId11 = new GroupIds();
        groupId11 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities7.setGroupIds(groupId11);
        em.persist(entities7);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes8 = new Attributes();
        attributes8.setName("length");
        attributes8.setNullable(true);
        attributes8.setSingle(false);
//      ...................... AttributesTypes ........................
        Entities entity12 = new Entities();
        entity12 = findBean.nameEntities("AttributesTypes",em);
        attributes8.setEntities(entity12);
//      ...................... Integer ........................
        AttributesTypes attributesTypes13 = new AttributesTypes();
        attributesTypes13 = findBean.nameAttributesTypes("Integer",em);
        attributes8.setAttributesTypes(attributesTypes13);
        em.persist(attributes8);
        em.flush();

        Attributes attributes9 = new Attributes();
        attributes9.setName("name");
        attributes9.setNullable(false);
        attributes9.setSingle(true);
//      ...................... AttributesTypes ........................
        Entities entity14 = new Entities();
        entity14 = findBean.nameEntities("AttributesTypes",em);
        attributes9.setEntities(entity14);
//      ...................... String ........................
        AttributesTypes attributesTypes15 = new AttributesTypes();
        attributesTypes15 = findBean.nameAttributesTypes("String",em);
        attributes9.setAttributesTypes(attributesTypes15);
        em.persist(attributes9);
        em.flush();

        Attributes attributes10 = new Attributes();
        attributes10.setName("precision");
        attributes10.setNullable(true);
        attributes10.setSingle(false);
//      ...................... AttributesTypes ........................
        Entities entity16 = new Entities();
        entity16 = findBean.nameEntities("AttributesTypes",em);
        attributes10.setEntities(entity16);
//      ...................... Integer ........................
        AttributesTypes attributesTypes17 = new AttributesTypes();
        attributesTypes17 = findBean.nameAttributesTypes("Integer",em);
        attributes10.setAttributesTypes(attributesTypes17);
        em.persist(attributes10);
        em.flush();

        Attributes attributes11 = new Attributes();
        attributes11.setName("type");
        attributes11.setNullable(false);
        attributes11.setSingle(false);
//      ...................... AttributesTypes ........................
        Entities entity18 = new Entities();
        entity18 = findBean.nameEntities("AttributesTypes",em);
        attributes11.setEntities(entity18);
//      ...................... String ........................
        AttributesTypes attributesTypes19 = new AttributesTypes();
        attributesTypes19 = findBean.nameAttributesTypes("String",em);
        attributes11.setAttributesTypes(attributesTypes19);
        em.persist(attributes11);
        em.flush();

        Attributes attributes12 = new Attributes();
        attributes12.setName("annotations");
        attributes12.setNullable(true);
        attributes12.setSingle(false);
//      ...................... AttributesTypes ........................
        Entities entity20 = new Entities();
        entity20 = findBean.nameEntities("AttributesTypes",em);
        attributes12.setEntities(entity20);
//      ...................... String ........................
        AttributesTypes attributesTypes21 = new AttributesTypes();
        attributesTypes21 = findBean.nameAttributesTypes("String",em);
        attributes12.setAttributesTypes(attributesTypes21);
        em.persist(attributes12);
        em.flush();

        Entities entities13 = new Entities();
        entities13.setName("Imports");
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId22 = new GroupIds();
        groupId22 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities13.setGroupIds(groupId22);
        em.persist(entities13);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes14 = new Attributes();
        attributes14.setName("name");
        attributes14.setNullable(false);
        attributes14.setSingle(true);
//      ...................... Imports ........................
        Entities entity23 = new Entities();
        entity23 = findBean.nameEntities("Imports",em);
        attributes14.setEntities(entity23);
//      ...................... String ........................
        AttributesTypes attributesTypes24 = new AttributesTypes();
        attributesTypes24 = findBean.nameAttributesTypes("String",em);
        attributes14.setAttributesTypes(attributesTypes24);
        em.persist(attributes14);
        em.flush();

        Entities entities15 = new Entities();
        entities15.setName("AttributesProperties");
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId25 = new GroupIds();
        groupId25 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities15.setGroupIds(groupId25);
        em.persist(entities15);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes16 = new Attributes();
        attributes16.setName("name");
        attributes16.setNullable(false);
        attributes16.setSingle(true);
//      ...................... AttributesProperties ........................
        Entities entity26 = new Entities();
        entity26 = findBean.nameEntities("AttributesProperties",em);
        attributes16.setEntities(entity26);
//      ...................... String ........................
        AttributesTypes attributesTypes27 = new AttributesTypes();
        attributesTypes27 = findBean.nameAttributesTypes("String",em);
        attributes16.setAttributesTypes(attributesTypes27);
        em.persist(attributes16);
        em.flush();

        Attributes attributes17 = new Attributes();
        attributes17.setName("value");
        attributes17.setNullable(false);
        attributes17.setSingle(true);
//      ...................... AttributesProperties ........................
        Entities entity28 = new Entities();
        entity28 = findBean.nameEntities("AttributesProperties",em);
        attributes17.setEntities(entity28);
//      ...................... String ........................
        AttributesTypes attributesTypes29 = new AttributesTypes();
        attributesTypes29 = findBean.nameAttributesTypes("String",em);
        attributes17.setAttributesTypes(attributesTypes29);
        em.persist(attributes17);
        em.flush();

        Entities entities18 = new Entities();
        entities18.setName("Dependencies");
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId30 = new GroupIds();
        groupId30 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities18.setGroupIds(groupId30);
        em.persist(entities18);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes19 = new Attributes();
        attributes19.setName("version");
        attributes19.setNullable(true);
        attributes19.setSingle(false);
//      ...................... Dependencies ........................
        Entities entity31 = new Entities();
        entity31 = findBean.nameEntities("Dependencies",em);
        attributes19.setEntities(entity31);
//      ...................... String ........................
        AttributesTypes attributesTypes32 = new AttributesTypes();
        attributesTypes32 = findBean.nameAttributesTypes("String",em);
        attributes19.setAttributesTypes(attributesTypes32);
        em.persist(attributes19);
        em.flush();

        Attributes attributes20 = new Attributes();
        attributes20.setName("groupId");
        attributes20.setNullable(false);
        attributes20.setSingle(false);
//      ...................... Dependencies ........................
        Entities entity33 = new Entities();
        entity33 = findBean.nameEntities("Dependencies",em);
        attributes20.setEntities(entity33);
//      ...................... String ........................
        AttributesTypes attributesTypes34 = new AttributesTypes();
        attributesTypes34 = findBean.nameAttributesTypes("String",em);
        attributes20.setAttributesTypes(attributesTypes34);
        em.persist(attributes20);
        em.flush();

        Attributes attributes21 = new Attributes();
        attributes21.setName("type");
        attributes21.setNullable(true);
        attributes21.setSingle(false);
//      ...................... Dependencies ........................
        Entities entity35 = new Entities();
        entity35 = findBean.nameEntities("Dependencies",em);
        attributes21.setEntities(entity35);
//      ...................... String ........................
        AttributesTypes attributesTypes36 = new AttributesTypes();
        attributesTypes36 = findBean.nameAttributesTypes("String",em);
        attributes21.setAttributesTypes(attributesTypes36);
        em.persist(attributes21);
        em.flush();

        Attributes attributes22 = new Attributes();
        attributes22.setName("scope");
        attributes22.setNullable(true);
        attributes22.setSingle(false);
//      ...................... Dependencies ........................
        Entities entity37 = new Entities();
        entity37 = findBean.nameEntities("Dependencies",em);
        attributes22.setEntities(entity37);
//      ...................... String ........................
        AttributesTypes attributesTypes38 = new AttributesTypes();
        attributesTypes38 = findBean.nameAttributesTypes("String",em);
        attributes22.setAttributesTypes(attributesTypes38);
        em.persist(attributes22);
        em.flush();

        Attributes attributes23 = new Attributes();
        attributes23.setName("artifactId");
        attributes23.setNullable(false);
        attributes23.setSingle(false);
//      ...................... Dependencies ........................
        Entities entity39 = new Entities();
        entity39 = findBean.nameEntities("Dependencies",em);
        attributes23.setEntities(entity39);
//      ...................... String ........................
        AttributesTypes attributesTypes40 = new AttributesTypes();
        attributesTypes40 = findBean.nameAttributesTypes("String",em);
        attributes23.setAttributesTypes(attributesTypes40);
        em.persist(attributes23);
        em.flush();

        Attributes attributes24 = new Attributes();
        attributes24.setName("maven");
        attributes24.setNullable(false);
        attributes24.setSingle(true);
//      ...................... Dependencies ........................
        Entities entity41 = new Entities();
        entity41 = findBean.nameEntities("Dependencies",em);
        attributes24.setEntities(entity41);
//      ...................... String ........................
        AttributesTypes attributesTypes42 = new AttributesTypes();
        attributesTypes42 = findBean.nameAttributesTypes("String",em);
        attributes24.setAttributesTypes(attributesTypes42);
        em.persist(attributes24);
        em.flush();

        Entities entities25 = new Entities();
        entities25.setName("NameQueries");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId43 = new GroupIds();
        groupId43 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities25.setGroupIds(groupId43);
        em.persist(entities25);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes26 = new Attributes();
        attributes26.setName("query");
        attributes26.setNullable(false);
        attributes26.setSingle(true);
//      ...................... NameQueries ........................
        Entities entity44 = new Entities();
        entity44 = findBean.nameEntities("NameQueries",em);
        attributes26.setEntities(entity44);
//      ...................... String ........................
        AttributesTypes attributesTypes45 = new AttributesTypes();
        attributesTypes45 = findBean.nameAttributesTypes("String",em);
        attributes26.setAttributesTypes(attributesTypes45);
        em.persist(attributes26);
        em.flush();

        Attributes attributes27 = new Attributes();
        attributes27.setName("observations");
        attributes27.setNullable(true);
        attributes27.setSingle(false);
//      ...................... NameQueries ........................
        Entities entity46 = new Entities();
        entity46 = findBean.nameEntities("NameQueries",em);
        attributes27.setEntities(entity46);
//      ...................... String ........................
        AttributesTypes attributesTypes47 = new AttributesTypes();
        attributesTypes47 = findBean.nameAttributesTypes("String",em);
        attributes27.setAttributesTypes(attributesTypes47);
        em.persist(attributes27);
        em.flush();

        Attributes attributes28 = new Attributes();
        attributes28.setName("name");
        attributes28.setNullable(false);
        attributes28.setSingle(true);
//      ...................... NameQueries ........................
        Entities entity48 = new Entities();
        entity48 = findBean.nameEntities("NameQueries",em);
        attributes28.setEntities(entity48);
//      ...................... String ........................
        AttributesTypes attributesTypes49 = new AttributesTypes();
        attributesTypes49 = findBean.nameAttributesTypes("String",em);
        attributes28.setAttributesTypes(attributesTypes49);
        em.persist(attributes28);
        em.flush();

        Entities entities29 = new Entities();
        entities29.setName("Cardinalities");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId50 = new GroupIds();
        groupId50 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities29.setGroupIds(groupId50);
        em.persist(entities29);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes30 = new Attributes();
        attributes30.setName("cardinality");
        attributes30.setNullable(false);
        attributes30.setSingle(false);
//      ...................... Cardinalities ........................
        Entities entity51 = new Entities();
        entity51 = findBean.nameEntities("Cardinalities",em);
        attributes30.setEntities(entity51);
//      ...................... String ........................
        AttributesTypes attributesTypes52 = new AttributesTypes();
        attributesTypes52 = findBean.nameAttributesTypes("String",em);
        attributes30.setAttributesTypes(attributesTypes52);
        em.persist(attributes30);
        em.flush();

        Attributes attributes31 = new Attributes();
        attributes31.setName("observations");
        attributes31.setNullable(true);
        attributes31.setSingle(false);
//      ...................... Cardinalities ........................
        Entities entity53 = new Entities();
        entity53 = findBean.nameEntities("Cardinalities",em);
        attributes31.setEntities(entity53);
//      ...................... String ........................
        AttributesTypes attributesTypes54 = new AttributesTypes();
        attributesTypes54 = findBean.nameAttributesTypes("String",em);
        attributes31.setAttributesTypes(attributesTypes54);
        em.persist(attributes31);
        em.flush();

        Attributes attributes32 = new Attributes();
        attributes32.setName("name");
        attributes32.setNullable(false);
        attributes32.setSingle(true);
//      ...................... Cardinalities ........................
        Entities entity55 = new Entities();
        entity55 = findBean.nameEntities("Cardinalities",em);
        attributes32.setEntities(entity55);
//      ...................... String ........................
        AttributesTypes attributesTypes56 = new AttributesTypes();
        attributesTypes56 = findBean.nameAttributesTypes("String",em);
        attributes32.setAttributesTypes(attributesTypes56);
        em.persist(attributes32);
        em.flush();

        Attributes attributes33 = new Attributes();
        attributes33.setName("unidirectional");
        attributes33.setNullable(true);
        attributes33.setSingle(false);
//      ...................... Cardinalities ........................
        Entities entity57 = new Entities();
        entity57 = findBean.nameEntities("Cardinalities",em);
        attributes33.setEntities(entity57);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes58 = new AttributesTypes();
        attributesTypes58 = findBean.nameAttributesTypes("Boolean",em);
        attributes33.setAttributesTypes(attributesTypes58);
        em.persist(attributes33);
        em.flush();

        Attributes attributes34 = new Attributes();
        attributes34.setName("annotations");
        attributes34.setNullable(true);
        attributes34.setSingle(false);
//      ...................... Cardinalities ........................
        Entities entity59 = new Entities();
        entity59 = findBean.nameEntities("Cardinalities",em);
        attributes34.setEntities(entity59);
//      ...................... String ........................
        AttributesTypes attributesTypes60 = new AttributesTypes();
        attributesTypes60 = findBean.nameAttributesTypes("String",em);
        attributes34.setAttributesTypes(attributesTypes60);
        em.persist(attributes34);
        em.flush();

        Entities entities35 = new Entities();
        entities35.setName("Entities");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId61 = new GroupIds();
        groupId61 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities35.setGroupIds(groupId61);
        em.persist(entities35);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes36 = new Attributes();
        attributes36.setName("serialID");
        attributes36.setNullable(true);
        attributes36.setSingle(true);
//      ...................... Entities ........................
        Entities entity62 = new Entities();
        entity62 = findBean.nameEntities("Entities",em);
        attributes36.setEntities(entity62);
//      ...................... String ........................
        AttributesTypes attributesTypes63 = new AttributesTypes();
        attributesTypes63 = findBean.nameAttributesTypes("String",em);
        attributes36.setAttributesTypes(attributesTypes63);
        em.persist(attributes36);
        em.flush();

        Attributes attributes37 = new Attributes();
        attributes37.setName("description");
        attributes37.setNullable(true);
        attributes37.setSingle(false);
//      ...................... Entities ........................
        Entities entity64 = new Entities();
        entity64 = findBean.nameEntities("Entities",em);
        attributes37.setEntities(entity64);
//      ...................... String ........................
        AttributesTypes attributesTypes65 = new AttributesTypes();
        attributesTypes65 = findBean.nameAttributesTypes("String",em);
        attributes37.setAttributesTypes(attributesTypes65);
        em.persist(attributes37);
        em.flush();

        Attributes attributes38 = new Attributes();
        attributes38.setName("source");
        attributes38.setNullable(true);
        attributes38.setSingle(false);
//      ...................... Entities ........................
        Entities entity66 = new Entities();
        entity66 = findBean.nameEntities("Entities",em);
        attributes38.setEntities(entity66);
//      ...................... String ........................
        AttributesTypes attributesTypes67 = new AttributesTypes();
        attributesTypes67 = findBean.nameAttributesTypes("String",em);
        attributes38.setAttributesTypes(attributesTypes67);
        em.persist(attributes38);
        em.flush();

        Attributes attributes39 = new Attributes();
        attributes39.setName("observations");
        attributes39.setNullable(true);
        attributes39.setSingle(false);
//      ...................... Entities ........................
        Entities entity68 = new Entities();
        entity68 = findBean.nameEntities("Entities",em);
        attributes39.setEntities(entity68);
//      ...................... String ........................
        AttributesTypes attributesTypes69 = new AttributesTypes();
        attributesTypes69 = findBean.nameAttributesTypes("String",em);
        attributes39.setAttributesTypes(attributesTypes69);
        em.persist(attributes39);
        em.flush();

        Attributes attributes40 = new Attributes();
        attributes40.setName("name");
        attributes40.setNullable(false);
        attributes40.setSingle(false);
//      ...................... Entities ........................
        Entities entity70 = new Entities();
        entity70 = findBean.nameEntities("Entities",em);
        attributes40.setEntities(entity70);
//      ...................... String ........................
        AttributesTypes attributesTypes71 = new AttributesTypes();
        attributesTypes71 = findBean.nameAttributesTypes("String",em);
        attributes40.setAttributesTypes(attributesTypes71);
        em.persist(attributes40);
        em.flush();

        Attributes attributes41 = new Attributes();
        attributes41.setName("table");
        attributes41.setNullable(true);
        attributes41.setSingle(false);
//      ...................... Entities ........................
        Entities entity72 = new Entities();
        entity72 = findBean.nameEntities("Entities",em);
        attributes41.setEntities(entity72);
//      ...................... String ........................
        AttributesTypes attributesTypes73 = new AttributesTypes();
        attributesTypes73 = findBean.nameAttributesTypes("String",em);
        attributes41.setAttributesTypes(attributesTypes73);
        em.persist(attributes41);
        em.flush();

        Attributes attributes42 = new Attributes();
        attributes42.setName("modifier");
        attributes42.setNullable(true);
        attributes42.setSingle(false);
//      ...................... Entities ........................
        Entities entity74 = new Entities();
        entity74 = findBean.nameEntities("Entities",em);
        attributes42.setEntities(entity74);
//      ...................... String ........................
        AttributesTypes attributesTypes75 = new AttributesTypes();
        attributesTypes75 = findBean.nameAttributesTypes("String",em);
        attributes42.setAttributesTypes(attributesTypes75);
        em.persist(attributes42);
        em.flush();

        Attributes attributes43 = new Attributes();
        attributes43.setName("tableSecuencia");
        attributes43.setNullable(true);
        attributes43.setSingle(false);
//      ...................... Entities ........................
        Entities entity76 = new Entities();
        entity76 = findBean.nameEntities("Entities",em);
        attributes43.setEntities(entity76);
//      ...................... String ........................
        AttributesTypes attributesTypes77 = new AttributesTypes();
        attributesTypes77 = findBean.nameAttributesTypes("String",em);
        attributes43.setAttributesTypes(attributesTypes77);
        em.persist(attributes43);
        em.flush();

        Attributes attributes44 = new Attributes();
        attributes44.setName("annotations");
        attributes44.setNullable(true);
        attributes44.setSingle(false);
//      ...................... Entities ........................
        Entities entity78 = new Entities();
        entity78 = findBean.nameEntities("Entities",em);
        attributes44.setEntities(entity78);
//      ...................... String ........................
        AttributesTypes attributesTypes79 = new AttributesTypes();
        attributesTypes79 = findBean.nameAttributesTypes("String",em);
        attributes44.setAttributesTypes(attributesTypes79);
        em.persist(attributes44);
        em.flush();

        Attributes attributes45 = new Attributes();
        attributes45.setName("extend");
        attributes45.setNullable(true);
        attributes45.setSingle(false);
//      ...................... Entities ........................
        Entities entity80 = new Entities();
        entity80 = findBean.nameEntities("Entities",em);
        attributes45.setEntities(entity80);
//      ...................... String ........................
        AttributesTypes attributesTypes81 = new AttributesTypes();
        attributesTypes81 = findBean.nameAttributesTypes("String",em);
        attributes45.setAttributesTypes(attributesTypes81);
        em.persist(attributes45);
        em.flush();

        Entities entities46 = new Entities();
        entities46.setName("GroupIds");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId82 = new GroupIds();
        groupId82 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities46.setGroupIds(groupId82);
        em.persist(entities46);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes47 = new Attributes();
        attributes47.setName("isSingle");
        attributes47.setNullable(true);
        attributes47.setSingle(false);
//      ...................... GroupIds ........................
        Entities entity83 = new Entities();
        entity83 = findBean.nameEntities("GroupIds",em);
        attributes47.setEntities(entity83);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes84 = new AttributesTypes();
        attributesTypes84 = findBean.nameAttributesTypes("Boolean",em);
        attributes47.setAttributesTypes(attributesTypes84);
        em.persist(attributes47);
        em.flush();

        Attributes attributes48 = new Attributes();
        attributes48.setName("groupId");
        attributes48.setNullable(false);
        attributes48.setSingle(false);
//      ...................... GroupIds ........................
        Entities entity85 = new Entities();
        entity85 = findBean.nameEntities("GroupIds",em);
        attributes48.setEntities(entity85);
//      ...................... String ........................
        AttributesTypes attributesTypes86 = new AttributesTypes();
        attributesTypes86 = findBean.nameAttributesTypes("String",em);
        attributes48.setAttributesTypes(attributesTypes86);
        em.persist(attributes48);
        em.flush();

        Attributes attributes49 = new Attributes();
        attributes49.setName("name");
        attributes49.setNullable(false);
        attributes49.setSingle(true);
//      ...................... GroupIds ........................
        Entities entity87 = new Entities();
        entity87 = findBean.nameEntities("GroupIds",em);
        attributes49.setEntities(entity87);
//      ...................... String ........................
        AttributesTypes attributesTypes88 = new AttributesTypes();
        attributesTypes88 = findBean.nameAttributesTypes("String",em);
        attributes49.setAttributesTypes(attributesTypes88);
        em.persist(attributes49);
        em.flush();

        Attributes attributes50 = new Attributes();
        attributes50.setName("date");
        attributes50.setNullable(true);
        attributes50.setSingle(false);
//      ...................... GroupIds ........................
        Entities entity89 = new Entities();
        entity89 = findBean.nameEntities("GroupIds",em);
        attributes50.setEntities(entity89);
//      ...................... Date ........................
        AttributesTypes attributesTypes90 = new AttributesTypes();
        attributesTypes90 = findBean.nameAttributesTypes("Date",em);
        attributes50.setAttributesTypes(attributesTypes90);
        em.persist(attributes50);
        em.flush();

        Attributes attributes51 = new Attributes();
        attributes51.setName("artifactId");
        attributes51.setNullable(true);
        attributes51.setSingle(true);
//      ...................... GroupIds ........................
        Entities entity91 = new Entities();
        entity91 = findBean.nameEntities("GroupIds",em);
        attributes51.setEntities(entity91);
//      ...................... String ........................
        AttributesTypes attributesTypes92 = new AttributesTypes();
        attributesTypes92 = findBean.nameAttributesTypes("String",em);
        attributes51.setAttributesTypes(attributesTypes92);
        em.persist(attributes51);
        em.flush();

        Attributes attributes52 = new Attributes();
        attributes52.setName("version");
        attributes52.setNullable(true);
        attributes52.setSingle(false);
//      ...................... GroupIds ........................
        Entities entity93 = new Entities();
        entity93 = findBean.nameEntities("GroupIds",em);
        attributes52.setEntities(entity93);
//      ...................... String ........................
        AttributesTypes attributesTypes94 = new AttributesTypes();
        attributesTypes94 = findBean.nameAttributesTypes("String",em);
        attributes52.setAttributesTypes(attributesTypes94);
        em.persist(attributes52);
        em.flush();

        Attributes attributes53 = new Attributes();
        attributes53.setName("code");
        attributes53.setNullable(true);
        attributes53.setSingle(true);
//      ...................... GroupIds ........................
        Entities entity95 = new Entities();
        entity95 = findBean.nameEntities("GroupIds",em);
        attributes53.setEntities(entity95);
//      ...................... String ........................
        AttributesTypes attributesTypes96 = new AttributesTypes();
        attributesTypes96 = findBean.nameAttributesTypes("String",em);
        attributes53.setAttributesTypes(attributesTypes96);
        em.persist(attributes53);
        em.flush();

        Entities entities54 = new Entities();
        entities54.setName("Relationships");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId97 = new GroupIds();
        groupId97 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities54.setGroupIds(groupId97);
        em.persist(entities54);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes55 = new Attributes();
        attributes55.setName("name");
        attributes55.setNullable(true);
        attributes55.setSingle(false);
//      ...................... Relationships ........................
        Entities entity98 = new Entities();
        entity98 = findBean.nameEntities("Relationships",em);
        attributes55.setEntities(entity98);
//      ...................... String ........................
        AttributesTypes attributesTypes99 = new AttributesTypes();
        attributesTypes99 = findBean.nameAttributesTypes("String",em);
        attributes55.setAttributesTypes(attributesTypes99);
        em.persist(attributes55);
        em.flush();

        Attributes attributes56 = new Attributes();
        attributes56.setName("optionality");
        attributes56.setNullable(true);
        attributes56.setSingle(false);
//      ...................... Relationships ........................
        Entities entity100 = new Entities();
        entity100 = findBean.nameEntities("Relationships",em);
        attributes56.setEntities(entity100);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes101 = new AttributesTypes();
        attributesTypes101 = findBean.nameAttributesTypes("Boolean",em);
        attributes56.setAttributesTypes(attributesTypes101);
        em.persist(attributes56);
        em.flush();

        Attributes attributes57 = new Attributes();
        attributes57.setName("isEmbedded");
        attributes57.setNullable(true);
        attributes57.setSingle(false);
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
        attributes58.setName("observations");
        attributes58.setNullable(true);
        attributes58.setSingle(false);
//      ...................... Relationships ........................
        Entities entity104 = new Entities();
        entity104 = findBean.nameEntities("Relationships",em);
        attributes58.setEntities(entity104);
//      ...................... String ........................
        AttributesTypes attributesTypes105 = new AttributesTypes();
        attributesTypes105 = findBean.nameAttributesTypes("String",em);
        attributes58.setAttributesTypes(attributesTypes105);
        em.persist(attributes58);
        em.flush();

        Entities entities59 = new Entities();
        entities59.setName("Attributes");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId106 = new GroupIds();
        groupId106 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities59.setGroupIds(groupId106);
        em.persist(entities59);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes60 = new Attributes();
        attributes60.setName("precision");
        attributes60.setNullable(true);
        attributes60.setSingle(false);
//      ...................... Attributes ........................
        Entities entity107 = new Entities();
        entity107 = findBean.nameEntities("Attributes",em);
        attributes60.setEntities(entity107);
//      ...................... Integer ........................
        AttributesTypes attributesTypes108 = new AttributesTypes();
        attributesTypes108 = findBean.nameAttributesTypes("Integer",em);
        attributes60.setAttributesTypes(attributesTypes108);
        em.persist(attributes60);
        em.flush();

        Attributes attributes61 = new Attributes();
        attributes61.setName("length");
        attributes61.setNullable(true);
        attributes61.setSingle(false);
//      ...................... Attributes ........................
        Entities entity109 = new Entities();
        entity109 = findBean.nameEntities("Attributes",em);
        attributes61.setEntities(entity109);
//      ...................... Integer ........................
        AttributesTypes attributesTypes110 = new AttributesTypes();
        attributesTypes110 = findBean.nameAttributesTypes("Integer",em);
        attributes61.setAttributesTypes(attributesTypes110);
        em.persist(attributes61);
        em.flush();

        Attributes attributes62 = new Attributes();
        attributes62.setName("name");
        attributes62.setNullable(false);
        attributes62.setSingle(false);
//      ...................... Attributes ........................
        Entities entity111 = new Entities();
        entity111 = findBean.nameEntities("Attributes",em);
        attributes62.setEntities(entity111);
//      ...................... String ........................
        AttributesTypes attributesTypes112 = new AttributesTypes();
        attributesTypes112 = findBean.nameAttributesTypes("String",em);
        attributes62.setAttributesTypes(attributesTypes112);
        em.persist(attributes62);
        em.flush();

        Attributes attributes63 = new Attributes();
        attributes63.setName("access");
        attributes63.setNullable(true);
        attributes63.setSingle(false);
//      ...................... Attributes ........................
        Entities entity113 = new Entities();
        entity113 = findBean.nameEntities("Attributes",em);
        attributes63.setEntities(entity113);
//      ...................... String ........................
        AttributesTypes attributesTypes114 = new AttributesTypes();
        attributesTypes114 = findBean.nameAttributesTypes("String",em);
        attributes63.setAttributesTypes(attributesTypes114);
        em.persist(attributes63);
        em.flush();

        Attributes attributes64 = new Attributes();
        attributes64.setName("field");
        attributes64.setNullable(true);
        attributes64.setSingle(false);
//      ...................... Attributes ........................
        Entities entity115 = new Entities();
        entity115 = findBean.nameEntities("Attributes",em);
        attributes64.setEntities(entity115);
//      ...................... String ........................
        AttributesTypes attributesTypes116 = new AttributesTypes();
        attributesTypes116 = findBean.nameAttributesTypes("String",em);
        attributes64.setAttributesTypes(attributesTypes116);
        em.persist(attributes64);
        em.flush();

        Attributes attributes65 = new Attributes();
        attributes65.setName("descripcion");
        attributes65.setNullable(true);
        attributes65.setSingle(false);
//      ...................... Attributes ........................
        Entities entity117 = new Entities();
        entity117 = findBean.nameEntities("Attributes",em);
        attributes65.setEntities(entity117);
//      ...................... String ........................
        AttributesTypes attributesTypes118 = new AttributesTypes();
        attributesTypes118 = findBean.nameAttributesTypes("String",em);
        attributes65.setAttributesTypes(attributesTypes118);
        em.persist(attributes65);
        em.flush();

        Attributes attributes66 = new Attributes();
        attributes66.setName("single");
        attributes66.setNullable(true);
        attributes66.setSingle(false);
//      ...................... Attributes ........................
        Entities entity119 = new Entities();
        entity119 = findBean.nameEntities("Attributes",em);
        attributes66.setEntities(entity119);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes120 = new AttributesTypes();
        attributesTypes120 = findBean.nameAttributesTypes("Boolean",em);
        attributes66.setAttributesTypes(attributesTypes120);
        em.persist(attributes66);
        em.flush();

        Attributes attributes67 = new Attributes();
        attributes67.setName("annotationsMethod");
        attributes67.setNullable(true);
        attributes67.setSingle(false);
//      ...................... Attributes ........................
        Entities entity121 = new Entities();
        entity121 = findBean.nameEntities("Attributes",em);
        attributes67.setEntities(entity121);
//      ...................... String ........................
        AttributesTypes attributesTypes122 = new AttributesTypes();
        attributesTypes122 = findBean.nameAttributesTypes("String",em);
        attributes67.setAttributesTypes(attributesTypes122);
        em.persist(attributes67);
        em.flush();

        Attributes attributes68 = new Attributes();
        attributes68.setName("annotationsField");
        attributes68.setNullable(true);
        attributes68.setSingle(false);
//      ...................... Attributes ........................
        Entities entity123 = new Entities();
        entity123 = findBean.nameEntities("Attributes",em);
        attributes68.setEntities(entity123);
//      ...................... String ........................
        AttributesTypes attributesTypes124 = new AttributesTypes();
        attributesTypes124 = findBean.nameAttributesTypes("String",em);
        attributes68.setAttributesTypes(attributesTypes124);
        em.persist(attributes68);
        em.flush();

        Attributes attributes69 = new Attributes();
        attributes69.setName("columnDefinition");
        attributes69.setNullable(true);
        attributes69.setSingle(false);
//      ...................... Attributes ........................
        Entities entity125 = new Entities();
        entity125 = findBean.nameEntities("Attributes",em);
        attributes69.setEntities(entity125);
//      ...................... String ........................
        AttributesTypes attributesTypes126 = new AttributesTypes();
        attributesTypes126 = findBean.nameAttributesTypes("String",em);
        attributes69.setAttributesTypes(attributesTypes126);
        em.persist(attributes69);
        em.flush();

        Attributes attributes70 = new Attributes();
        attributes70.setName("observations");
        attributes70.setNullable(true);
        attributes70.setSingle(false);
//      ...................... Attributes ........................
        Entities entity127 = new Entities();
        entity127 = findBean.nameEntities("Attributes",em);
        attributes70.setEntities(entity127);
//      ...................... String ........................
        AttributesTypes attributesTypes128 = new AttributesTypes();
        attributesTypes128 = findBean.nameAttributesTypes("String",em);
        attributes70.setAttributesTypes(attributesTypes128);
        em.persist(attributes70);
        em.flush();

        Attributes attributes71 = new Attributes();
        attributes71.setName("nullable");
        attributes71.setNullable(true);
        attributes71.setSingle(false);
//      ...................... Attributes ........................
        Entities entity129 = new Entities();
        entity129 = findBean.nameEntities("Attributes",em);
        attributes71.setEntities(entity129);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes130 = new AttributesTypes();
        attributesTypes130 = findBean.nameAttributesTypes("Boolean",em);
        attributes71.setAttributesTypes(attributesTypes130);
        em.persist(attributes71);
        em.flush();

        Entities entities72 = new Entities();
        entities72.setName("Developments");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId131 = new GroupIds();
        groupId131 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities72.setGroupIds(groupId131);
        em.persist(entities72);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes73 = new Attributes();
        attributes73.setName("groupId");
        attributes73.setNullable(false);
        attributes73.setSingle(false);
//      ...................... Developments ........................
        Entities entity132 = new Entities();
        entity132 = findBean.nameEntities("Developments",em);
        attributes73.setEntities(entity132);
//      ...................... String ........................
        AttributesTypes attributesTypes133 = new AttributesTypes();
        attributesTypes133 = findBean.nameAttributesTypes("String",em);
        attributes73.setAttributesTypes(attributesTypes133);
        em.persist(attributes73);
        em.flush();

        Attributes attributes74 = new Attributes();
        attributes74.setName("code");
        attributes74.setNullable(true);
        attributes74.setSingle(true);
//      ...................... Developments ........................
        Entities entity134 = new Entities();
        entity134 = findBean.nameEntities("Developments",em);
        attributes74.setEntities(entity134);
//      ...................... String ........................
        AttributesTypes attributesTypes135 = new AttributesTypes();
        attributesTypes135 = findBean.nameAttributesTypes("String",em);
        attributes74.setAttributesTypes(attributesTypes135);
        em.persist(attributes74);
        em.flush();

        Attributes attributes75 = new Attributes();
        attributes75.setName("version");
        attributes75.setNullable(true);
        attributes75.setSingle(false);
//      ...................... Developments ........................
        Entities entity136 = new Entities();
        entity136 = findBean.nameEntities("Developments",em);
        attributes75.setEntities(entity136);
//      ...................... String ........................
        AttributesTypes attributesTypes137 = new AttributesTypes();
        attributesTypes137 = findBean.nameAttributesTypes("String",em);
        attributes75.setAttributesTypes(attributesTypes137);
        em.persist(attributes75);
        em.flush();

        Attributes attributes76 = new Attributes();
        attributes76.setName("name");
        attributes76.setNullable(false);
        attributes76.setSingle(true);
//      ...................... Developments ........................
        Entities entity138 = new Entities();
        entity138 = findBean.nameEntities("Developments",em);
        attributes76.setEntities(entity138);
//      ...................... String ........................
        AttributesTypes attributesTypes139 = new AttributesTypes();
        attributesTypes139 = findBean.nameAttributesTypes("String",em);
        attributes76.setAttributesTypes(attributesTypes139);
        em.persist(attributes76);
        em.flush();

        Attributes attributes77 = new Attributes();
        attributes77.setName("artifactId");
        attributes77.setNullable(true);
        attributes77.setSingle(true);
//      ...................... Developments ........................
        Entities entity140 = new Entities();
        entity140 = findBean.nameEntities("Developments",em);
        attributes77.setEntities(entity140);
//      ...................... String ........................
        AttributesTypes attributesTypes141 = new AttributesTypes();
        attributesTypes141 = findBean.nameAttributesTypes("String",em);
        attributes77.setAttributesTypes(attributesTypes141);
        em.persist(attributes77);
        em.flush();

        Attributes attributes78 = new Attributes();
        attributes78.setName("date");
        attributes78.setNullable(true);
        attributes78.setSingle(false);
//      ...................... Developments ........................
        Entities entity142 = new Entities();
        entity142 = findBean.nameEntities("Developments",em);
        attributes78.setEntities(entity142);
//      ...................... Date ........................
        AttributesTypes attributesTypes143 = new AttributesTypes();
        attributesTypes143 = findBean.nameAttributesTypes("Date",em);
        attributes78.setAttributesTypes(attributesTypes143);
        em.persist(attributes78);
        em.flush();

        Entities entities79 = new Entities();
        entities79.setName("Models");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId144 = new GroupIds();
        groupId144 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities79.setGroupIds(groupId144);
        em.persist(entities79);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes80 = new Attributes();
        attributes80.setName("date");
        attributes80.setNullable(true);
        attributes80.setSingle(false);
//      ...................... Models ........................
        Entities entity145 = new Entities();
        entity145 = findBean.nameEntities("Models",em);
        attributes80.setEntities(entity145);
//      ...................... Date ........................
        AttributesTypes attributesTypes146 = new AttributesTypes();
        attributesTypes146 = findBean.nameAttributesTypes("Date",em);
        attributes80.setAttributesTypes(attributesTypes146);
        em.persist(attributes80);
        em.flush();

        Attributes attributes81 = new Attributes();
        attributes81.setName("version");
        attributes81.setNullable(true);
        attributes81.setSingle(false);
//      ...................... Models ........................
        Entities entity147 = new Entities();
        entity147 = findBean.nameEntities("Models",em);
        attributes81.setEntities(entity147);
//      ...................... String ........................
        AttributesTypes attributesTypes148 = new AttributesTypes();
        attributesTypes148 = findBean.nameAttributesTypes("String",em);
        attributes81.setAttributesTypes(attributesTypes148);
        em.persist(attributes81);
        em.flush();

        Attributes attributes82 = new Attributes();
        attributes82.setName("code");
        attributes82.setNullable(true);
        attributes82.setSingle(true);
//      ...................... Models ........................
        Entities entity149 = new Entities();
        entity149 = findBean.nameEntities("Models",em);
        attributes82.setEntities(entity149);
//      ...................... String ........................
        AttributesTypes attributesTypes150 = new AttributesTypes();
        attributesTypes150 = findBean.nameAttributesTypes("String",em);
        attributes82.setAttributesTypes(attributesTypes150);
        em.persist(attributes82);
        em.flush();

        Attributes attributes83 = new Attributes();
        attributes83.setName("groupId");
        attributes83.setNullable(false);
        attributes83.setSingle(false);
//      ...................... Models ........................
        Entities entity151 = new Entities();
        entity151 = findBean.nameEntities("Models",em);
        attributes83.setEntities(entity151);
//      ...................... String ........................
        AttributesTypes attributesTypes152 = new AttributesTypes();
        attributesTypes152 = findBean.nameAttributesTypes("String",em);
        attributes83.setAttributesTypes(attributesTypes152);
        em.persist(attributes83);
        em.flush();

        Attributes attributes84 = new Attributes();
        attributes84.setName("artifactId");
        attributes84.setNullable(true);
        attributes84.setSingle(true);
//      ...................... Models ........................
        Entities entity153 = new Entities();
        entity153 = findBean.nameEntities("Models",em);
        attributes84.setEntities(entity153);
//      ...................... String ........................
        AttributesTypes attributesTypes154 = new AttributesTypes();
        attributesTypes154 = findBean.nameAttributesTypes("String",em);
        attributes84.setAttributesTypes(attributesTypes154);
        em.persist(attributes84);
        em.flush();

        Attributes attributes85 = new Attributes();
        attributes85.setName("name");
        attributes85.setNullable(false);
        attributes85.setSingle(true);
//      ...................... Models ........................
        Entities entity155 = new Entities();
        entity155 = findBean.nameEntities("Models",em);
        attributes85.setEntities(entity155);
//      ...................... String ........................
        AttributesTypes attributesTypes156 = new AttributesTypes();
        attributesTypes156 = findBean.nameAttributesTypes("String",em);
        attributes85.setAttributesTypes(attributesTypes156);
        em.persist(attributes85);
        em.flush();

//      ---------------------- Relationships ------------------------

/*
. SitesTypes . 1..* SitesTypes
. SitesTypes . *..* Sites
. AttributesTypes . *..* AttributesProperties
. AttributesTypes . *..* Sites
. AttributesTypes . 1..* Attributes
. Imports . *..* Sites
. AttributesProperties . *..* Sites
. AttributesProperties . *..* Imports
. Dependencies . 1..* Imports
. Dependencies . *..* Sites
. Cardinalities . 1..* Relationships
. Cardinalities . *..* Imports
. Cardinalities . *..* Sites
. Entities . 1..* NameQueries
. Entities . 1..* Attributes
. Entities . *..* Imports
. Entities . 1..* Relationships
. Entities . *..* Sites
. Entities . 1..* Relationships
. GroupIds . 1..* Entities
. Relationships . *..* AttributesProperties
. Attributes . *..* AttributesProperties
. Attributes . *..* Sites
. Developments . *..* Models
. Developments . *..* Sites
. Models . *..* GroupIds
. Models . *..* Sites
*/
        Relationships relationships1 = new Relationships();
        relationships1.setOptionality(true);
        relationships1.setIsEmbedded(false);
        relationships1.setName("");
//      ...................... SitesTypes ........................
        Entities entities157 = new Entities();
        entities157 = findBean.nameEntities("SitesTypes",em);
        relationships1.setFrom(entities157);
//      ...................... SitesTypes ........................
        Entities entities158 = new Entities();
        entities158 = findBean.nameEntities("SitesTypes",em);
        relationships1.setTo(entities158);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities159 = new Cardinalities();
        cardinalities159 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships1.setCardinalities(cardinalities159);
        em.persist(relationships1);
        em.flush();

        Relationships relationships2 = new Relationships();
        relationships2.setOptionality(true);
        relationships2.setIsEmbedded(false);
        relationships2.setName("");
//      ...................... SitesTypes ........................
        Entities entities160 = new Entities();
        entities160 = findBean.nameEntities("SitesTypes",em);
        relationships2.setFrom(entities160);
//      ...................... Sites ........................
        Entities entities161 = new Entities();
        entities161 = findBean.nameEntities("Sites",em);
        relationships2.setTo(entities161);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities162 = new Cardinalities();
        cardinalities162 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships2.setCardinalities(cardinalities162);
        em.persist(relationships2);
        em.flush();

        Relationships relationships3 = new Relationships();
        relationships3.setOptionality(true);
        relationships3.setIsEmbedded(false);
        relationships3.setName("");
//      ...................... AttributesTypes ........................
        Entities entities163 = new Entities();
        entities163 = findBean.nameEntities("AttributesTypes",em);
        relationships3.setFrom(entities163);
//      ...................... AttributesProperties ........................
        Entities entities164 = new Entities();
        entities164 = findBean.nameEntities("AttributesProperties",em);
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
        relationships4.setName("");
//      ...................... AttributesTypes ........................
        Entities entities166 = new Entities();
        entities166 = findBean.nameEntities("AttributesTypes",em);
        relationships4.setFrom(entities166);
//      ...................... Sites ........................
        Entities entities167 = new Entities();
        entities167 = findBean.nameEntities("Sites",em);
        relationships4.setTo(entities167);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities168 = new Cardinalities();
        cardinalities168 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships4.setCardinalities(cardinalities168);
        em.persist(relationships4);
        em.flush();

        Relationships relationships5 = new Relationships();
        relationships5.setOptionality(true);
        relationships5.setIsEmbedded(false);
        relationships5.setName("");
//      ...................... AttributesTypes ........................
        Entities entities169 = new Entities();
        entities169 = findBean.nameEntities("AttributesTypes",em);
        relationships5.setFrom(entities169);
//      ...................... Attributes ........................
        Entities entities170 = new Entities();
        entities170 = findBean.nameEntities("Attributes",em);
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
//      ...................... Imports ........................
        Entities entities172 = new Entities();
        entities172 = findBean.nameEntities("Imports",em);
        relationships6.setFrom(entities172);
//      ...................... Sites ........................
        Entities entities173 = new Entities();
        entities173 = findBean.nameEntities("Sites",em);
        relationships6.setTo(entities173);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities174 = new Cardinalities();
        cardinalities174 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships6.setCardinalities(cardinalities174);
        em.persist(relationships6);
        em.flush();

        Relationships relationships7 = new Relationships();
        relationships7.setOptionality(true);
        relationships7.setIsEmbedded(false);
        relationships7.setName("");
//      ...................... AttributesProperties ........................
        Entities entities175 = new Entities();
        entities175 = findBean.nameEntities("AttributesProperties",em);
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
//      ...................... AttributesProperties ........................
        Entities entities178 = new Entities();
        entities178 = findBean.nameEntities("AttributesProperties",em);
        relationships8.setFrom(entities178);
//      ...................... Imports ........................
        Entities entities179 = new Entities();
        entities179 = findBean.nameEntities("Imports",em);
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
//      ...................... Dependencies ........................
        Entities entities181 = new Entities();
        entities181 = findBean.nameEntities("Dependencies",em);
        relationships9.setFrom(entities181);
//      ...................... Imports ........................
        Entities entities182 = new Entities();
        entities182 = findBean.nameEntities("Imports",em);
        relationships9.setTo(entities182);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities183 = new Cardinalities();
        cardinalities183 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships9.setCardinalities(cardinalities183);
        em.persist(relationships9);
        em.flush();

        Relationships relationships10 = new Relationships();
        relationships10.setOptionality(true);
        relationships10.setIsEmbedded(false);
        relationships10.setName("");
//      ...................... Dependencies ........................
        Entities entities184 = new Entities();
        entities184 = findBean.nameEntities("Dependencies",em);
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
//      ...................... Cardinalities ........................
        Entities entities187 = new Entities();
        entities187 = findBean.nameEntities("Cardinalities",em);
        relationships11.setFrom(entities187);
//      ...................... Relationships ........................
        Entities entities188 = new Entities();
        entities188 = findBean.nameEntities("Relationships",em);
        relationships11.setTo(entities188);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities189 = new Cardinalities();
        cardinalities189 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships11.setCardinalities(cardinalities189);
        em.persist(relationships11);
        em.flush();

        Relationships relationships12 = new Relationships();
        relationships12.setOptionality(true);
        relationships12.setIsEmbedded(false);
        relationships12.setName("");
//      ...................... Cardinalities ........................
        Entities entities190 = new Entities();
        entities190 = findBean.nameEntities("Cardinalities",em);
        relationships12.setFrom(entities190);
//      ...................... Imports ........................
        Entities entities191 = new Entities();
        entities191 = findBean.nameEntities("Imports",em);
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
//      ...................... Cardinalities ........................
        Entities entities193 = new Entities();
        entities193 = findBean.nameEntities("Cardinalities",em);
        relationships13.setFrom(entities193);
//      ...................... Sites ........................
        Entities entities194 = new Entities();
        entities194 = findBean.nameEntities("Sites",em);
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
//      ...................... Entities ........................
        Entities entities196 = new Entities();
        entities196 = findBean.nameEntities("Entities",em);
        relationships14.setFrom(entities196);
//      ...................... NameQueries ........................
        Entities entities197 = new Entities();
        entities197 = findBean.nameEntities("NameQueries",em);
        relationships14.setTo(entities197);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities198 = new Cardinalities();
        cardinalities198 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships14.setCardinalities(cardinalities198);
        em.persist(relationships14);
        em.flush();

        Relationships relationships15 = new Relationships();
        relationships15.setOptionality(true);
        relationships15.setIsEmbedded(false);
        relationships15.setName("");
//      ...................... Entities ........................
        Entities entities199 = new Entities();
        entities199 = findBean.nameEntities("Entities",em);
        relationships15.setFrom(entities199);
//      ...................... Attributes ........................
        Entities entities200 = new Entities();
        entities200 = findBean.nameEntities("Attributes",em);
        relationships15.setTo(entities200);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities201 = new Cardinalities();
        cardinalities201 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships15.setCardinalities(cardinalities201);
        em.persist(relationships15);
        em.flush();

        Relationships relationships16 = new Relationships();
        relationships16.setOptionality(true);
        relationships16.setIsEmbedded(false);
        relationships16.setName("");
//      ...................... Entities ........................
        Entities entities202 = new Entities();
        entities202 = findBean.nameEntities("Entities",em);
        relationships16.setFrom(entities202);
//      ...................... Imports ........................
        Entities entities203 = new Entities();
        entities203 = findBean.nameEntities("Imports",em);
        relationships16.setTo(entities203);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities204 = new Cardinalities();
        cardinalities204 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships16.setCardinalities(cardinalities204);
        em.persist(relationships16);
        em.flush();

        Relationships relationships17 = new Relationships();
        relationships17.setOptionality(true);
        relationships17.setIsEmbedded(false);
        relationships17.setName("from");
//      ...................... Entities ........................
        Entities entities205 = new Entities();
        entities205 = findBean.nameEntities("Entities",em);
        relationships17.setFrom(entities205);
//      ...................... Relationships ........................
        Entities entities206 = new Entities();
        entities206 = findBean.nameEntities("Relationships",em);
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
//      ...................... Entities ........................
        Entities entities208 = new Entities();
        entities208 = findBean.nameEntities("Entities",em);
        relationships18.setFrom(entities208);
//      ...................... Sites ........................
        Entities entities209 = new Entities();
        entities209 = findBean.nameEntities("Sites",em);
        relationships18.setTo(entities209);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities210 = new Cardinalities();
        cardinalities210 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships18.setCardinalities(cardinalities210);
        em.persist(relationships18);
        em.flush();

        Relationships relationships19 = new Relationships();
        relationships19.setOptionality(true);
        relationships19.setIsEmbedded(false);
        relationships19.setName("to");
//      ...................... Entities ........................
        Entities entities211 = new Entities();
        entities211 = findBean.nameEntities("Entities",em);
        relationships19.setFrom(entities211);
//      ...................... Relationships ........................
        Entities entities212 = new Entities();
        entities212 = findBean.nameEntities("Relationships",em);
        relationships19.setTo(entities212);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities213 = new Cardinalities();
        cardinalities213 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships19.setCardinalities(cardinalities213);
        em.persist(relationships19);
        em.flush();

        Relationships relationships20 = new Relationships();
        relationships20.setOptionality(true);
        relationships20.setIsEmbedded(false);
        relationships20.setName("");
//      ...................... GroupIds ........................
        Entities entities214 = new Entities();
        entities214 = findBean.nameEntities("GroupIds",em);
        relationships20.setFrom(entities214);
//      ...................... Entities ........................
        Entities entities215 = new Entities();
        entities215 = findBean.nameEntities("Entities",em);
        relationships20.setTo(entities215);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities216 = new Cardinalities();
        cardinalities216 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships20.setCardinalities(cardinalities216);
        em.persist(relationships20);
        em.flush();

        Relationships relationships21 = new Relationships();
        relationships21.setOptionality(true);
        relationships21.setIsEmbedded(false);
        relationships21.setName("");
//      ...................... Relationships ........................
        Entities entities217 = new Entities();
        entities217 = findBean.nameEntities("Relationships",em);
        relationships21.setFrom(entities217);
//      ...................... AttributesProperties ........................
        Entities entities218 = new Entities();
        entities218 = findBean.nameEntities("AttributesProperties",em);
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
//      ...................... Attributes ........................
        Entities entities220 = new Entities();
        entities220 = findBean.nameEntities("Attributes",em);
        relationships22.setFrom(entities220);
//      ...................... AttributesProperties ........................
        Entities entities221 = new Entities();
        entities221 = findBean.nameEntities("AttributesProperties",em);
        relationships22.setTo(entities221);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities222 = new Cardinalities();
        cardinalities222 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships22.setCardinalities(cardinalities222);
        em.persist(relationships22);
        em.flush();

        Relationships relationships23 = new Relationships();
        relationships23.setOptionality(true);
        relationships23.setIsEmbedded(false);
        relationships23.setName("");
//      ...................... Attributes ........................
        Entities entities223 = new Entities();
        entities223 = findBean.nameEntities("Attributes",em);
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
//      ...................... Developments ........................
        Entities entities226 = new Entities();
        entities226 = findBean.nameEntities("Developments",em);
        relationships24.setFrom(entities226);
//      ...................... Models ........................
        Entities entities227 = new Entities();
        entities227 = findBean.nameEntities("Models",em);
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
//      ...................... Developments ........................
        Entities entities229 = new Entities();
        entities229 = findBean.nameEntities("Developments",em);
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
//      ...................... Models ........................
        Entities entities232 = new Entities();
        entities232 = findBean.nameEntities("Models",em);
        relationships26.setFrom(entities232);
//      ...................... GroupIds ........................
        Entities entities233 = new Entities();
        entities233 = findBean.nameEntities("GroupIds",em);
        relationships26.setTo(entities233);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities234 = new Cardinalities();
        cardinalities234 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships26.setCardinalities(cardinalities234);
        em.persist(relationships26);
        em.flush();

        Relationships relationships27 = new Relationships();
        relationships27.setOptionality(true);
        relationships27.setIsEmbedded(false);
        relationships27.setName("");
//      ...................... Models ........................
        Entities entities235 = new Entities();
        entities235 = findBean.nameEntities("Models",em);
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
