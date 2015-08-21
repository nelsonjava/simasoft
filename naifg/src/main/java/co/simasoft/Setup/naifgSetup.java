package co.simasoft.setup;

import co.simasoft.beans.*;
import co.simasoft.utils.*;

import co.simasoft.models.dev.naifg.sites.*;
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
        groupIds1.setArtifactId("co.simasoft.models.dev.naifg");
        em.persist(groupIds1);
        em.flush();

        GroupIds groupIds2 = new GroupIds();
        groupIds2.setGroupId("co.simasoft.models.dev.naifg.dependencies");
        groupIds2.setArtifactId("co.simasoft.models.dev.naifg.dependencies");
        em.persist(groupIds2);
        em.flush();

//      ---------------------- Models ------------------------

        Models models = new Models();
        models.setGroupId("co.simasoft.naifg");
        models.setArtifactId("naifg");
        models.setVersion("1.0-SNAPSHOT");
        em.persist(models);
        em.flush();

//      ---------------------- Developments ------------------------

        Developments dev = new Developments();
        dev.setGroupId("co.simasoft");
        dev.setArtifactId("naifg");
        dev.setVersion("1.0-SNAPSHOT");
        Set<Models> models1 = new HashSet<Models>();
        Models model1 = findBean.artifactIdModels("naifg",em);
        models1.add(model1);
        dev.setModels(models1);
        em.persist(dev);
        em.flush();

//      ---------------------- Entities ------------------------

//      ---------------------- Entities ------------------------

        Entities entities1 = new Entities();
        entities1.setName("Dependencies");
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId1 = new GroupIds();
        groupId1 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities1.setGroupIds(groupId1);
        em.persist(entities1);
        em.flush();

        Attributes attributes2 = new Attributes();
        attributes2.setName("groupId");
        attributes2.setIsNullable(false);
        attributes2.setIsUnique(false);
//      ...................... Dependencies ........................
        Entities entity2 = new Entities();
        entity2 = findBean.nameEntities("Dependencies",em);
        attributes2.setEntities(entity2);
//      ...................... String ........................
        AttributesTypes attributesTypes3 = new AttributesTypes();
        attributesTypes3 = findBean.nameAttributesTypes("String",em);
        attributes2.setAttributesTypes(attributesTypes3);
        em.persist(attributes2);
        em.flush();

        Attributes attributes3 = new Attributes();
        attributes3.setName("artifactId");
        attributes3.setIsNullable(false);
        attributes3.setIsUnique(false);
//      ...................... Dependencies ........................
        Entities entity4 = new Entities();
        entity4 = findBean.nameEntities("Dependencies",em);
        attributes3.setEntities(entity4);
//      ...................... String ........................
        AttributesTypes attributesTypes5 = new AttributesTypes();
        attributesTypes5 = findBean.nameAttributesTypes("String",em);
        attributes3.setAttributesTypes(attributesTypes5);
        em.persist(attributes3);
        em.flush();

        Attributes attributes4 = new Attributes();
        attributes4.setName("version");
        attributes4.setIsNullable(true);
        attributes4.setIsUnique(false);
//      ...................... Dependencies ........................
        Entities entity6 = new Entities();
        entity6 = findBean.nameEntities("Dependencies",em);
        attributes4.setEntities(entity6);
//      ...................... String ........................
        AttributesTypes attributesTypes7 = new AttributesTypes();
        attributesTypes7 = findBean.nameAttributesTypes("String",em);
        attributes4.setAttributesTypes(attributesTypes7);
        em.persist(attributes4);
        em.flush();

        Attributes attributes5 = new Attributes();
        attributes5.setName("type");
        attributes5.setIsNullable(true);
        attributes5.setIsUnique(false);
//      ...................... Dependencies ........................
        Entities entity8 = new Entities();
        entity8 = findBean.nameEntities("Dependencies",em);
        attributes5.setEntities(entity8);
//      ...................... String ........................
        AttributesTypes attributesTypes9 = new AttributesTypes();
        attributesTypes9 = findBean.nameAttributesTypes("String",em);
        attributes5.setAttributesTypes(attributesTypes9);
        em.persist(attributes5);
        em.flush();

        Attributes attributes6 = new Attributes();
        attributes6.setName("scope");
        attributes6.setIsNullable(true);
        attributes6.setIsUnique(false);
//      ...................... Dependencies ........................
        Entities entity10 = new Entities();
        entity10 = findBean.nameEntities("Dependencies",em);
        attributes6.setEntities(entity10);
//      ...................... String ........................
        AttributesTypes attributesTypes11 = new AttributesTypes();
        attributesTypes11 = findBean.nameAttributesTypes("String",em);
        attributes6.setAttributesTypes(attributesTypes11);
        em.persist(attributes6);
        em.flush();

        Attributes attributes7 = new Attributes();
        attributes7.setName("maven");
        attributes7.setIsNullable(false);
        attributes7.setIsUnique(true);
//      ...................... Dependencies ........................
        Entities entity12 = new Entities();
        entity12 = findBean.nameEntities("Dependencies",em);
        attributes7.setEntities(entity12);
//      ...................... String ........................
        AttributesTypes attributesTypes13 = new AttributesTypes();
        attributesTypes13 = findBean.nameAttributesTypes("String",em);
        attributes7.setAttributesTypes(attributesTypes13);
        em.persist(attributes7);
        em.flush();

        Entities entities8 = new Entities();
        entities8.setName("AttributesProperties");
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId14 = new GroupIds();
        groupId14 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities8.setGroupIds(groupId14);
        em.persist(entities8);
        em.flush();

        Attributes attributes9 = new Attributes();
        attributes9.setName("name");
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

        Attributes attributes10 = new Attributes();
        attributes10.setName("value");
        attributes10.setIsNullable(false);
        attributes10.setIsUnique(true);
//      ...................... AttributesProperties ........................
        Entities entity17 = new Entities();
        entity17 = findBean.nameEntities("AttributesProperties",em);
        attributes10.setEntities(entity17);
//      ...................... String ........................
        AttributesTypes attributesTypes18 = new AttributesTypes();
        attributesTypes18 = findBean.nameAttributesTypes("String",em);
        attributes10.setAttributesTypes(attributesTypes18);
        em.persist(attributes10);
        em.flush();

        Entities entities11 = new Entities();
        entities11.setName("AttributesTypes");
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId19 = new GroupIds();
        groupId19 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities11.setGroupIds(groupId19);
        em.persist(entities11);
        em.flush();

        Attributes attributes12 = new Attributes();
        attributes12.setName("name");
        attributes12.setIsNullable(false);
        attributes12.setIsUnique(true);
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

        Attributes attributes13 = new Attributes();
        attributes13.setName("type");
        attributes13.setIsNullable(false);
        attributes13.setIsUnique(false);
//      ...................... AttributesTypes ........................
        Entities entity22 = new Entities();
        entity22 = findBean.nameEntities("AttributesTypes",em);
        attributes13.setEntities(entity22);
//      ...................... String ........................
        AttributesTypes attributesTypes23 = new AttributesTypes();
        attributesTypes23 = findBean.nameAttributesTypes("String",em);
        attributes13.setAttributesTypes(attributesTypes23);
        em.persist(attributes13);
        em.flush();

        Attributes attributes14 = new Attributes();
        attributes14.setName("length");
        attributes14.setIsNullable(true);
        attributes14.setIsUnique(false);
//      ...................... AttributesTypes ........................
        Entities entity24 = new Entities();
        entity24 = findBean.nameEntities("AttributesTypes",em);
        attributes14.setEntities(entity24);
//      ...................... Integer ........................
        AttributesTypes attributesTypes25 = new AttributesTypes();
        attributesTypes25 = findBean.nameAttributesTypes("Integer",em);
        attributes14.setAttributesTypes(attributesTypes25);
        em.persist(attributes14);
        em.flush();

        Attributes attributes15 = new Attributes();
        attributes15.setName("precision");
        attributes15.setIsNullable(true);
        attributes15.setIsUnique(false);
//      ...................... AttributesTypes ........................
        Entities entity26 = new Entities();
        entity26 = findBean.nameEntities("AttributesTypes",em);
        attributes15.setEntities(entity26);
//      ...................... Integer ........................
        AttributesTypes attributesTypes27 = new AttributesTypes();
        attributesTypes27 = findBean.nameAttributesTypes("Integer",em);
        attributes15.setAttributesTypes(attributesTypes27);
        em.persist(attributes15);
        em.flush();

        Attributes attributes16 = new Attributes();
        attributes16.setName("annotations");
        attributes16.setIsNullable(true);
        attributes16.setIsUnique(false);
//      ...................... AttributesTypes ........................
        Entities entity28 = new Entities();
        entity28 = findBean.nameEntities("AttributesTypes",em);
        attributes16.setEntities(entity28);
//      ...................... String ........................
        AttributesTypes attributesTypes29 = new AttributesTypes();
        attributesTypes29 = findBean.nameAttributesTypes("String",em);
        attributes16.setAttributesTypes(attributesTypes29);
        em.persist(attributes16);
        em.flush();

        Entities entities17 = new Entities();
        entities17.setName("Imports");
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId30 = new GroupIds();
        groupId30 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities17.setGroupIds(groupId30);
        em.persist(entities17);
        em.flush();

        Attributes attributes18 = new Attributes();
        attributes18.setName("name");
        attributes18.setIsNullable(false);
        attributes18.setIsUnique(true);
//      ...................... Imports ........................
        Entities entity31 = new Entities();
        entity31 = findBean.nameEntities("Imports",em);
        attributes18.setEntities(entity31);
//      ...................... String ........................
        AttributesTypes attributesTypes32 = new AttributesTypes();
        attributesTypes32 = findBean.nameAttributesTypes("String",em);
        attributes18.setAttributesTypes(attributesTypes32);
        em.persist(attributes18);
        em.flush();

//      ---------------------- Entities ------------------------

//      ---------------------- Entities ------------------------

        Entities entities19 = new Entities();
        entities19.setName("Developments");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId33 = new GroupIds();
        groupId33 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities19.setGroupIds(groupId33);
        em.persist(entities19);
        em.flush();

        Attributes attributes20 = new Attributes();
        attributes20.setName("artifactId");
        attributes20.setIsNullable(false);
        attributes20.setIsUnique(true);
//      ...................... Developments ........................
        Entities entity34 = new Entities();
        entity34 = findBean.nameEntities("Developments",em);
        attributes20.setEntities(entity34);
//      ...................... String ........................
        AttributesTypes attributesTypes35 = new AttributesTypes();
        attributesTypes35 = findBean.nameAttributesTypes("String",em);
        attributes20.setAttributesTypes(attributesTypes35);
        em.persist(attributes20);
        em.flush();

        Attributes attributes21 = new Attributes();
        attributes21.setName("groupId");
        attributes21.setIsNullable(true);
        attributes21.setIsUnique(false);
//      ...................... Developments ........................
        Entities entity36 = new Entities();
        entity36 = findBean.nameEntities("Developments",em);
        attributes21.setEntities(entity36);
//      ...................... String ........................
        AttributesTypes attributesTypes37 = new AttributesTypes();
        attributesTypes37 = findBean.nameAttributesTypes("String",em);
        attributes21.setAttributesTypes(attributesTypes37);
        em.persist(attributes21);
        em.flush();

        Attributes attributes22 = new Attributes();
        attributes22.setName("version");
        attributes22.setIsNullable(true);
        attributes22.setIsUnique(false);
//      ...................... Developments ........................
        Entities entity38 = new Entities();
        entity38 = findBean.nameEntities("Developments",em);
        attributes22.setEntities(entity38);
//      ...................... String ........................
        AttributesTypes attributesTypes39 = new AttributesTypes();
        attributesTypes39 = findBean.nameAttributesTypes("String",em);
        attributes22.setAttributesTypes(attributesTypes39);
        em.persist(attributes22);
        em.flush();

        Attributes attributes23 = new Attributes();
        attributes23.setName("code");
        attributes23.setIsNullable(true);
        attributes23.setIsUnique(false);
//      ...................... Developments ........................
        Entities entity40 = new Entities();
        entity40 = findBean.nameEntities("Developments",em);
        attributes23.setEntities(entity40);
//      ...................... String ........................
        AttributesTypes attributesTypes41 = new AttributesTypes();
        attributesTypes41 = findBean.nameAttributesTypes("String",em);
        attributes23.setAttributesTypes(attributesTypes41);
        em.persist(attributes23);
        em.flush();

        Attributes attributes24 = new Attributes();
        attributes24.setName("date");
        attributes24.setIsNullable(true);
        attributes24.setIsUnique(false);
//      ...................... Developments ........................
        Entities entity42 = new Entities();
        entity42 = findBean.nameEntities("Developments",em);
        attributes24.setEntities(entity42);
//      ...................... Date ........................
        AttributesTypes attributesTypes43 = new AttributesTypes();
        attributesTypes43 = findBean.nameAttributesTypes("Date",em);
        attributes24.setAttributesTypes(attributesTypes43);
        em.persist(attributes24);
        em.flush();

        Entities entities25 = new Entities();
        entities25.setName("Entities");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId44 = new GroupIds();
        groupId44 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities25.setGroupIds(groupId44);
        em.persist(entities25);
        em.flush();

        Attributes attributes26 = new Attributes();
        attributes26.setName("name");
        attributes26.setIsNullable(false);
        attributes26.setIsUnique(true);
//      ...................... Entities ........................
        Entities entity45 = new Entities();
        entity45 = findBean.nameEntities("Entities",em);
        attributes26.setEntities(entity45);
//      ...................... String ........................
        AttributesTypes attributesTypes46 = new AttributesTypes();
        attributesTypes46 = findBean.nameAttributesTypes("String",em);
        attributes26.setAttributesTypes(attributesTypes46);
        em.persist(attributes26);
        em.flush();

        Attributes attributes27 = new Attributes();
        attributes27.setName("serialID");
        attributes27.setIsNullable(true);
        attributes27.setIsUnique(false);
//      ...................... Entities ........................
        Entities entity47 = new Entities();
        entity47 = findBean.nameEntities("Entities",em);
        attributes27.setEntities(entity47);
//      ...................... String ........................
        AttributesTypes attributesTypes48 = new AttributesTypes();
        attributesTypes48 = findBean.nameAttributesTypes("String",em);
        attributes27.setAttributesTypes(attributesTypes48);
        em.persist(attributes27);
        em.flush();

        Attributes attributes28 = new Attributes();
        attributes28.setName("table");
        attributes28.setIsNullable(true);
        attributes28.setIsUnique(false);
//      ...................... Entities ........................
        Entities entity49 = new Entities();
        entity49 = findBean.nameEntities("Entities",em);
        attributes28.setEntities(entity49);
//      ...................... String ........................
        AttributesTypes attributesTypes50 = new AttributesTypes();
        attributesTypes50 = findBean.nameAttributesTypes("String",em);
        attributes28.setAttributesTypes(attributesTypes50);
        em.persist(attributes28);
        em.flush();

        Attributes attributes29 = new Attributes();
        attributes29.setName("description");
        attributes29.setIsNullable(true);
        attributes29.setIsUnique(false);
//      ...................... Entities ........................
        Entities entity51 = new Entities();
        entity51 = findBean.nameEntities("Entities",em);
        attributes29.setEntities(entity51);
//      ...................... String ........................
        AttributesTypes attributesTypes52 = new AttributesTypes();
        attributesTypes52 = findBean.nameAttributesTypes("String",em);
        attributes29.setAttributesTypes(attributesTypes52);
        em.persist(attributes29);
        em.flush();

        Attributes attributes30 = new Attributes();
        attributes30.setName("isSimplified");
        attributes30.setIsNullable(true);
        attributes30.setIsUnique(false);
//      ...................... Entities ........................
        Entities entity53 = new Entities();
        entity53 = findBean.nameEntities("Entities",em);
        attributes30.setEntities(entity53);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes54 = new AttributesTypes();
        attributesTypes54 = findBean.nameAttributesTypes("Boolean",em);
        attributes30.setAttributesTypes(attributesTypes54);
        em.persist(attributes30);
        em.flush();

        Entities entities31 = new Entities();
        entities31.setName("Cardinalities");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId55 = new GroupIds();
        groupId55 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities31.setGroupIds(groupId55);
        em.persist(entities31);
        em.flush();

        Attributes attributes32 = new Attributes();
        attributes32.setName("name");
        attributes32.setIsNullable(false);
        attributes32.setIsUnique(true);
//      ...................... Cardinalities ........................
        Entities entity56 = new Entities();
        entity56 = findBean.nameEntities("Cardinalities",em);
        attributes32.setEntities(entity56);
//      ...................... String ........................
        AttributesTypes attributesTypes57 = new AttributesTypes();
        attributesTypes57 = findBean.nameAttributesTypes("String",em);
        attributes32.setAttributesTypes(attributesTypes57);
        em.persist(attributes32);
        em.flush();

        Attributes attributes33 = new Attributes();
        attributes33.setName("cardinality");
        attributes33.setIsNullable(false);
        attributes33.setIsUnique(false);
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
        attributes34.setName("isUnidirectional");
        attributes34.setIsNullable(true);
        attributes34.setIsUnique(false);
//      ...................... Cardinalities ........................
        Entities entity60 = new Entities();
        entity60 = findBean.nameEntities("Cardinalities",em);
        attributes34.setEntities(entity60);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes61 = new AttributesTypes();
        attributesTypes61 = findBean.nameAttributesTypes("Boolean",em);
        attributes34.setAttributesTypes(attributesTypes61);
        em.persist(attributes34);
        em.flush();

        Entities entities35 = new Entities();
        entities35.setName("Attributes");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId62 = new GroupIds();
        groupId62 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities35.setGroupIds(groupId62);
        em.persist(entities35);
        em.flush();

        Attributes attributes36 = new Attributes();
        attributes36.setName("name");
        attributes36.setIsNullable(false);
        attributes36.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity63 = new Entities();
        entity63 = findBean.nameEntities("Attributes",em);
        attributes36.setEntities(entity63);
//      ...................... String ........................
        AttributesTypes attributesTypes64 = new AttributesTypes();
        attributesTypes64 = findBean.nameAttributesTypes("String",em);
        attributes36.setAttributesTypes(attributesTypes64);
        em.persist(attributes36);
        em.flush();

        Attributes attributes37 = new Attributes();
        attributes37.setName("length");
        attributes37.setIsNullable(true);
        attributes37.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity65 = new Entities();
        entity65 = findBean.nameEntities("Attributes",em);
        attributes37.setEntities(entity65);
//      ...................... Integer ........................
        AttributesTypes attributesTypes66 = new AttributesTypes();
        attributesTypes66 = findBean.nameAttributesTypes("Integer",em);
        attributes37.setAttributesTypes(attributesTypes66);
        em.persist(attributes37);
        em.flush();

        Attributes attributes38 = new Attributes();
        attributes38.setName("precision");
        attributes38.setIsNullable(true);
        attributes38.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity67 = new Entities();
        entity67 = findBean.nameEntities("Attributes",em);
        attributes38.setEntities(entity67);
//      ...................... Integer ........................
        AttributesTypes attributesTypes68 = new AttributesTypes();
        attributesTypes68 = findBean.nameAttributesTypes("Integer",em);
        attributes38.setAttributesTypes(attributesTypes68);
        em.persist(attributes38);
        em.flush();

        Attributes attributes39 = new Attributes();
        attributes39.setName("isNullable");
        attributes39.setIsNullable(true);
        attributes39.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity69 = new Entities();
        entity69 = findBean.nameEntities("Attributes",em);
        attributes39.setEntities(entity69);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes70 = new AttributesTypes();
        attributesTypes70 = findBean.nameAttributesTypes("Boolean",em);
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
        attributes41.setName("description");
        attributes41.setIsNullable(true);
        attributes41.setIsUnique(false);
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
        attributes42.setName("isSimplified");
        attributes42.setIsNullable(true);
        attributes42.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity75 = new Entities();
        entity75 = findBean.nameEntities("Attributes",em);
        attributes42.setEntities(entity75);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes76 = new AttributesTypes();
        attributesTypes76 = findBean.nameAttributesTypes("Boolean",em);
        attributes42.setAttributesTypes(attributesTypes76);
        em.persist(attributes42);
        em.flush();

        Attributes attributes43 = new Attributes();
        attributes43.setName("isCreate");
        attributes43.setIsNullable(true);
        attributes43.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity77 = new Entities();
        entity77 = findBean.nameEntities("Attributes",em);
        attributes43.setEntities(entity77);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes78 = new AttributesTypes();
        attributesTypes78 = findBean.nameAttributesTypes("Boolean",em);
        attributes43.setAttributesTypes(attributesTypes78);
        em.persist(attributes43);
        em.flush();

        Attributes attributes44 = new Attributes();
        attributes44.setName("isSearch");
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

        Attributes attributes45 = new Attributes();
        attributes45.setName("isView");
        attributes45.setIsNullable(true);
        attributes45.setIsUnique(false);
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
        attributes46.setName("isViewRelation");
        attributes46.setIsNullable(true);
        attributes46.setIsUnique(false);
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

        Entities entities47 = new Entities();
        entities47.setName("GroupIds");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId85 = new GroupIds();
        groupId85 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities47.setGroupIds(groupId85);
        em.persist(entities47);
        em.flush();

        Attributes attributes48 = new Attributes();
        attributes48.setName("artifactId");
        attributes48.setIsNullable(false);
        attributes48.setIsUnique(true);
//      ...................... GroupIds ........................
        Entities entity86 = new Entities();
        entity86 = findBean.nameEntities("GroupIds",em);
        attributes48.setEntities(entity86);
//      ...................... String ........................
        AttributesTypes attributesTypes87 = new AttributesTypes();
        attributesTypes87 = findBean.nameAttributesTypes("String",em);
        attributes48.setAttributesTypes(attributesTypes87);
        em.persist(attributes48);
        em.flush();

        Attributes attributes49 = new Attributes();
        attributes49.setName("groupId");
        attributes49.setIsNullable(false);
        attributes49.setIsUnique(true);
//      ...................... GroupIds ........................
        Entities entity88 = new Entities();
        entity88 = findBean.nameEntities("GroupIds",em);
        attributes49.setEntities(entity88);
//      ...................... String ........................
        AttributesTypes attributesTypes89 = new AttributesTypes();
        attributesTypes89 = findBean.nameAttributesTypes("String",em);
        attributes49.setAttributesTypes(attributesTypes89);
        em.persist(attributes49);
        em.flush();

        Attributes attributes50 = new Attributes();
        attributes50.setName("version");
        attributes50.setIsNullable(true);
        attributes50.setIsUnique(false);
//      ...................... GroupIds ........................
        Entities entity90 = new Entities();
        entity90 = findBean.nameEntities("GroupIds",em);
        attributes50.setEntities(entity90);
//      ...................... String ........................
        AttributesTypes attributesTypes91 = new AttributesTypes();
        attributesTypes91 = findBean.nameAttributesTypes("String",em);
        attributes50.setAttributesTypes(attributesTypes91);
        em.persist(attributes50);
        em.flush();

        Attributes attributes51 = new Attributes();
        attributes51.setName("code");
        attributes51.setIsNullable(true);
        attributes51.setIsUnique(false);
//      ...................... GroupIds ........................
        Entities entity92 = new Entities();
        entity92 = findBean.nameEntities("GroupIds",em);
        attributes51.setEntities(entity92);
//      ...................... String ........................
        AttributesTypes attributesTypes93 = new AttributesTypes();
        attributesTypes93 = findBean.nameAttributesTypes("String",em);
        attributes51.setAttributesTypes(attributesTypes93);
        em.persist(attributes51);
        em.flush();

        Attributes attributes52 = new Attributes();
        attributes52.setName("date");
        attributes52.setIsNullable(true);
        attributes52.setIsUnique(false);
//      ...................... GroupIds ........................
        Entities entity94 = new Entities();
        entity94 = findBean.nameEntities("GroupIds",em);
        attributes52.setEntities(entity94);
//      ...................... Date ........................
        AttributesTypes attributesTypes95 = new AttributesTypes();
        attributesTypes95 = findBean.nameAttributesTypes("Date",em);
        attributes52.setAttributesTypes(attributesTypes95);
        em.persist(attributes52);
        em.flush();

        Entities entities53 = new Entities();
        entities53.setName("ModelsGroupIds");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId96 = new GroupIds();
        groupId96 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities53.setGroupIds(groupId96);
        em.persist(entities53);
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

        Attributes attributes55 = new Attributes();
        attributes55.setName("isSimplified");
        attributes55.setIsNullable(true);
        attributes55.setIsUnique(false);
//      ...................... ModelsGroupIds ........................
        Entities entity99 = new Entities();
        entity99 = findBean.nameEntities("ModelsGroupIds",em);
        attributes55.setEntities(entity99);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes100 = new AttributesTypes();
        attributesTypes100 = findBean.nameAttributesTypes("Boolean",em);
        attributes55.setAttributesTypes(attributesTypes100);
        em.persist(attributes55);
        em.flush();

        Entities entities56 = new Entities();
        entities56.setName("NameQueries");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId101 = new GroupIds();
        groupId101 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities56.setGroupIds(groupId101);
        em.persist(entities56);
        em.flush();

        Attributes attributes57 = new Attributes();
        attributes57.setName("name");
        attributes57.setIsNullable(false);
        attributes57.setIsUnique(true);
//      ...................... NameQueries ........................
        Entities entity102 = new Entities();
        entity102 = findBean.nameEntities("NameQueries",em);
        attributes57.setEntities(entity102);
//      ...................... String ........................
        AttributesTypes attributesTypes103 = new AttributesTypes();
        attributesTypes103 = findBean.nameAttributesTypes("String",em);
        attributes57.setAttributesTypes(attributesTypes103);
        em.persist(attributes57);
        em.flush();

        Attributes attributes58 = new Attributes();
        attributes58.setName("query");
        attributes58.setIsNullable(false);
        attributes58.setIsUnique(true);
//      ...................... NameQueries ........................
        Entities entity104 = new Entities();
        entity104 = findBean.nameEntities("NameQueries",em);
        attributes58.setEntities(entity104);
//      ...................... String ........................
        AttributesTypes attributesTypes105 = new AttributesTypes();
        attributesTypes105 = findBean.nameAttributesTypes("String",em);
        attributes58.setAttributesTypes(attributesTypes105);
        em.persist(attributes58);
        em.flush();

        Entities entities59 = new Entities();
        entities59.setName("Relationships");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId106 = new GroupIds();
        groupId106 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities59.setGroupIds(groupId106);
        em.persist(entities59);
        em.flush();

        Attributes attributes60 = new Attributes();
        attributes60.setName("name");
        attributes60.setIsNullable(true);
        attributes60.setIsUnique(false);
//      ...................... Relationships ........................
        Entities entity107 = new Entities();
        entity107 = findBean.nameEntities("Relationships",em);
        attributes60.setEntities(entity107);
//      ...................... String ........................
        AttributesTypes attributesTypes108 = new AttributesTypes();
        attributesTypes108 = findBean.nameAttributesTypes("String",em);
        attributes60.setAttributesTypes(attributesTypes108);
        em.persist(attributes60);
        em.flush();

        Attributes attributes61 = new Attributes();
        attributes61.setName("nameAttribute");
        attributes61.setIsNullable(true);
        attributes61.setIsUnique(false);
//      ...................... Relationships ........................
        Entities entity109 = new Entities();
        entity109 = findBean.nameEntities("Relationships",em);
        attributes61.setEntities(entity109);
//      ...................... String ........................
        AttributesTypes attributesTypes110 = new AttributesTypes();
        attributesTypes110 = findBean.nameAttributesTypes("String",em);
        attributes61.setAttributesTypes(attributesTypes110);
        em.persist(attributes61);
        em.flush();

        Attributes attributes62 = new Attributes();
        attributes62.setName("isOptionality");
        attributes62.setIsNullable(true);
        attributes62.setIsUnique(false);
//      ...................... Relationships ........................
        Entities entity111 = new Entities();
        entity111 = findBean.nameEntities("Relationships",em);
        attributes62.setEntities(entity111);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes112 = new AttributesTypes();
        attributesTypes112 = findBean.nameAttributesTypes("Boolean",em);
        attributes62.setAttributesTypes(attributesTypes112);
        em.persist(attributes62);
        em.flush();

        Attributes attributes63 = new Attributes();
        attributes63.setName("isEmbedded");
        attributes63.setIsNullable(true);
        attributes63.setIsUnique(false);
//      ...................... Relationships ........................
        Entities entity113 = new Entities();
        entity113 = findBean.nameEntities("Relationships",em);
        attributes63.setEntities(entity113);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes114 = new AttributesTypes();
        attributesTypes114 = findBean.nameAttributesTypes("Boolean",em);
        attributes63.setAttributesTypes(attributesTypes114);
        em.persist(attributes63);
        em.flush();

        Attributes attributes64 = new Attributes();
        attributes64.setName("isSimplified");
        attributes64.setIsNullable(true);
        attributes64.setIsUnique(false);
//      ...................... Relationships ........................
        Entities entity115 = new Entities();
        entity115 = findBean.nameEntities("Relationships",em);
        attributes64.setEntities(entity115);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes116 = new AttributesTypes();
        attributesTypes116 = findBean.nameAttributesTypes("Boolean",em);
        attributes64.setAttributesTypes(attributesTypes116);
        em.persist(attributes64);
        em.flush();

        Attributes attributes65 = new Attributes();
        attributes65.setName("isCreate");
        attributes65.setIsNullable(true);
        attributes65.setIsUnique(false);
//      ...................... Relationships ........................
        Entities entity117 = new Entities();
        entity117 = findBean.nameEntities("Relationships",em);
        attributes65.setEntities(entity117);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes118 = new AttributesTypes();
        attributesTypes118 = findBean.nameAttributesTypes("Boolean",em);
        attributes65.setAttributesTypes(attributesTypes118);
        em.persist(attributes65);
        em.flush();

        Attributes attributes66 = new Attributes();
        attributes66.setName("isSearch");
        attributes66.setIsNullable(true);
        attributes66.setIsUnique(false);
//      ...................... Relationships ........................
        Entities entity119 = new Entities();
        entity119 = findBean.nameEntities("Relationships",em);
        attributes66.setEntities(entity119);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes120 = new AttributesTypes();
        attributesTypes120 = findBean.nameAttributesTypes("Boolean",em);
        attributes66.setAttributesTypes(attributesTypes120);
        em.persist(attributes66);
        em.flush();

        Attributes attributes67 = new Attributes();
        attributes67.setName("isView");
        attributes67.setIsNullable(true);
        attributes67.setIsUnique(false);
//      ...................... Relationships ........................
        Entities entity121 = new Entities();
        entity121 = findBean.nameEntities("Relationships",em);
        attributes67.setEntities(entity121);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes122 = new AttributesTypes();
        attributesTypes122 = findBean.nameAttributesTypes("Boolean",em);
        attributes67.setAttributesTypes(attributesTypes122);
        em.persist(attributes67);
        em.flush();

        Entities entities68 = new Entities();
        entities68.setName("Models");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId123 = new GroupIds();
        groupId123 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities68.setGroupIds(groupId123);
        em.persist(entities68);
        em.flush();

        Attributes attributes69 = new Attributes();
        attributes69.setName("artifactId");
        attributes69.setIsNullable(false);
        attributes69.setIsUnique(true);
//      ...................... Models ........................
        Entities entity124 = new Entities();
        entity124 = findBean.nameEntities("Models",em);
        attributes69.setEntities(entity124);
//      ...................... String ........................
        AttributesTypes attributesTypes125 = new AttributesTypes();
        attributesTypes125 = findBean.nameAttributesTypes("String",em);
        attributes69.setAttributesTypes(attributesTypes125);
        em.persist(attributes69);
        em.flush();

        Attributes attributes70 = new Attributes();
        attributes70.setName("groupId");
        attributes70.setIsNullable(false);
        attributes70.setIsUnique(true);
//      ...................... Models ........................
        Entities entity126 = new Entities();
        entity126 = findBean.nameEntities("Models",em);
        attributes70.setEntities(entity126);
//      ...................... String ........................
        AttributesTypes attributesTypes127 = new AttributesTypes();
        attributesTypes127 = findBean.nameAttributesTypes("String",em);
        attributes70.setAttributesTypes(attributesTypes127);
        em.persist(attributes70);
        em.flush();

        Attributes attributes71 = new Attributes();
        attributes71.setName("version");
        attributes71.setIsNullable(true);
        attributes71.setIsUnique(false);
//      ...................... Models ........................
        Entities entity128 = new Entities();
        entity128 = findBean.nameEntities("Models",em);
        attributes71.setEntities(entity128);
//      ...................... String ........................
        AttributesTypes attributesTypes129 = new AttributesTypes();
        attributesTypes129 = findBean.nameAttributesTypes("String",em);
        attributes71.setAttributesTypes(attributesTypes129);
        em.persist(attributes71);
        em.flush();

        Attributes attributes72 = new Attributes();
        attributes72.setName("code");
        attributes72.setIsNullable(true);
        attributes72.setIsUnique(false);
//      ...................... Models ........................
        Entities entity130 = new Entities();
        entity130 = findBean.nameEntities("Models",em);
        attributes72.setEntities(entity130);
//      ...................... String ........................
        AttributesTypes attributesTypes131 = new AttributesTypes();
        attributesTypes131 = findBean.nameAttributesTypes("String",em);
        attributes72.setAttributesTypes(attributesTypes131);
        em.persist(attributes72);
        em.flush();

        Attributes attributes73 = new Attributes();
        attributes73.setName("date");
        attributes73.setIsNullable(true);
        attributes73.setIsUnique(false);
//      ...................... Models ........................
        Entities entity132 = new Entities();
        entity132 = findBean.nameEntities("Models",em);
        attributes73.setEntities(entity132);
//      ...................... Date ........................
        AttributesTypes attributesTypes133 = new AttributesTypes();
        attributesTypes133 = findBean.nameAttributesTypes("Date",em);
        attributes73.setAttributesTypes(attributesTypes133);
        em.persist(attributes73);
        em.flush();

//      ---------------------- Entities ------------------------

//      ---------------------- Entities ------------------------

//      ---------------------- Relationships ------------------------

/*
. Models . *..* Sites rolA:from rolB: OK

. Relationships . *..* AttributesProperties rolA:from rolB: OK

. AttributesTypes . 1..* Attributes rolA: rolB:

. Entities . *..* Sites rolA:from rolB: OK

. Developments . *..* Sites rolA:from rolB: OK

. Cardinalities . *..* Imports rolA:from rolB: OK

. Cardinalities . *..* Sites rolA:from rolB: OK

. Attributes . *..* AttributesProperties rolA:from rolB: OK

. Entities . *..* AttributesProperties rolA:from rolB: OK

. Attributes . *..* Sites rolA:from rolB: OK

. Entities . *..* Imports rolA:from rolB: OK

*/
        Relationships relationships1 = new Relationships();
        relationships1.setIsOptionality(true);
        relationships1.setIsEmbedded(false);
//      ...................... Models ........................
        Entities entities134 = new Entities();
        entities134 = findBean.nameEntities("Models",em);
        relationships1.setFrom(entities134);
//      ...................... Sites ........................
        Entities entities135 = new Entities();
        entities135 = findBean.nameEntities("Sites",em);
        relationships1.setTo(entities135);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities136 = new Cardinalities();
        cardinalities136 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships1.setCardinalities(cardinalities136);
        em.persist(relationships1);
        em.flush();

        Relationships relationships2 = new Relationships();
        relationships2.setIsOptionality(true);
        relationships2.setIsEmbedded(false);
//      ...................... Relationships ........................
        Entities entities137 = new Entities();
        entities137 = findBean.nameEntities("Relationships",em);
        relationships2.setFrom(entities137);
//      ...................... AttributesProperties ........................
        Entities entities138 = new Entities();
        entities138 = findBean.nameEntities("AttributesProperties",em);
        relationships2.setTo(entities138);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities139 = new Cardinalities();
        cardinalities139 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships2.setCardinalities(cardinalities139);
        em.persist(relationships2);
        em.flush();

        Relationships relationships3 = new Relationships();
        relationships3.setIsOptionality(true);
        relationships3.setIsEmbedded(false);
//      ...................... AttributesTypes ........................
        Entities entities140 = new Entities();
        entities140 = findBean.nameEntities("AttributesTypes",em);
        relationships3.setFrom(entities140);
//      ...................... Attributes ........................
        Entities entities141 = new Entities();
        entities141 = findBean.nameEntities("Attributes",em);
        relationships3.setTo(entities141);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities142 = new Cardinalities();
        cardinalities142 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships3.setCardinalities(cardinalities142);
        em.persist(relationships3);
        em.flush();

        Relationships relationships4 = new Relationships();
        relationships4.setIsOptionality(true);
        relationships4.setIsEmbedded(false);
//      ...................... Entities ........................
        Entities entities143 = new Entities();
        entities143 = findBean.nameEntities("Entities",em);
        relationships4.setFrom(entities143);
//      ...................... Sites ........................
        Entities entities144 = new Entities();
        entities144 = findBean.nameEntities("Sites",em);
        relationships4.setTo(entities144);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities145 = new Cardinalities();
        cardinalities145 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships4.setCardinalities(cardinalities145);
        em.persist(relationships4);
        em.flush();

        Relationships relationships5 = new Relationships();
        relationships5.setIsOptionality(true);
        relationships5.setIsEmbedded(false);
//      ...................... Developments ........................
        Entities entities146 = new Entities();
        entities146 = findBean.nameEntities("Developments",em);
        relationships5.setFrom(entities146);
//      ...................... Sites ........................
        Entities entities147 = new Entities();
        entities147 = findBean.nameEntities("Sites",em);
        relationships5.setTo(entities147);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities148 = new Cardinalities();
        cardinalities148 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships5.setCardinalities(cardinalities148);
        em.persist(relationships5);
        em.flush();

        Relationships relationships6 = new Relationships();
        relationships6.setIsOptionality(true);
        relationships6.setIsEmbedded(false);
//      ...................... Cardinalities ........................
        Entities entities149 = new Entities();
        entities149 = findBean.nameEntities("Cardinalities",em);
        relationships6.setFrom(entities149);
//      ...................... Imports ........................
        Entities entities150 = new Entities();
        entities150 = findBean.nameEntities("Imports",em);
        relationships6.setTo(entities150);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities151 = new Cardinalities();
        cardinalities151 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships6.setCardinalities(cardinalities151);
        em.persist(relationships6);
        em.flush();

        Relationships relationships7 = new Relationships();
        relationships7.setIsOptionality(true);
        relationships7.setIsEmbedded(false);
//      ...................... Cardinalities ........................
        Entities entities152 = new Entities();
        entities152 = findBean.nameEntities("Cardinalities",em);
        relationships7.setFrom(entities152);
//      ...................... Sites ........................
        Entities entities153 = new Entities();
        entities153 = findBean.nameEntities("Sites",em);
        relationships7.setTo(entities153);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities154 = new Cardinalities();
        cardinalities154 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships7.setCardinalities(cardinalities154);
        em.persist(relationships7);
        em.flush();

        Relationships relationships8 = new Relationships();
        relationships8.setIsOptionality(true);
        relationships8.setIsEmbedded(false);
//      ...................... Attributes ........................
        Entities entities155 = new Entities();
        entities155 = findBean.nameEntities("Attributes",em);
        relationships8.setFrom(entities155);
//      ...................... AttributesProperties ........................
        Entities entities156 = new Entities();
        entities156 = findBean.nameEntities("AttributesProperties",em);
        relationships8.setTo(entities156);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities157 = new Cardinalities();
        cardinalities157 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships8.setCardinalities(cardinalities157);
        em.persist(relationships8);
        em.flush();

        Relationships relationships9 = new Relationships();
        relationships9.setIsOptionality(true);
        relationships9.setIsEmbedded(false);
//      ...................... Entities ........................
        Entities entities158 = new Entities();
        entities158 = findBean.nameEntities("Entities",em);
        relationships9.setFrom(entities158);
//      ...................... AttributesProperties ........................
        Entities entities159 = new Entities();
        entities159 = findBean.nameEntities("AttributesProperties",em);
        relationships9.setTo(entities159);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities160 = new Cardinalities();
        cardinalities160 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships9.setCardinalities(cardinalities160);
        em.persist(relationships9);
        em.flush();

        Relationships relationships10 = new Relationships();
        relationships10.setIsOptionality(true);
        relationships10.setIsEmbedded(false);
//      ...................... Attributes ........................
        Entities entities161 = new Entities();
        entities161 = findBean.nameEntities("Attributes",em);
        relationships10.setFrom(entities161);
//      ...................... Sites ........................
        Entities entities162 = new Entities();
        entities162 = findBean.nameEntities("Sites",em);
        relationships10.setTo(entities162);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities163 = new Cardinalities();
        cardinalities163 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships10.setCardinalities(cardinalities163);
        em.persist(relationships10);
        em.flush();

        Relationships relationships11 = new Relationships();
        relationships11.setIsOptionality(true);
        relationships11.setIsEmbedded(false);
//      ...................... Entities ........................
        Entities entities164 = new Entities();
        entities164 = findBean.nameEntities("Entities",em);
        relationships11.setFrom(entities164);
//      ...................... Imports ........................
        Entities entities165 = new Entities();
        entities165 = findBean.nameEntities("Imports",em);
        relationships11.setTo(entities165);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities166 = new Cardinalities();
        cardinalities166 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships11.setCardinalities(cardinalities166);
        em.persist(relationships11);
        em.flush();

/*
*/
/*
. Imports . *..* Sites rolA:from rolB: OK

. Dependencies . *..* Sites rolA:from rolB: OK

. AttributesTypes . *..* Sites rolA:from rolB: OK

. AttributesProperties . *..* Sites rolA:from rolB: OK

*/
        Relationships relationships12 = new Relationships();
        relationships12.setIsOptionality(true);
        relationships12.setIsEmbedded(false);
//      ...................... Imports ........................
        Entities entities167 = new Entities();
        entities167 = findBean.nameEntities("Imports",em);
        relationships12.setFrom(entities167);
//      ...................... Sites ........................
        Entities entities168 = new Entities();
        entities168 = findBean.nameEntities("Sites",em);
        relationships12.setTo(entities168);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities169 = new Cardinalities();
        cardinalities169 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships12.setCardinalities(cardinalities169);
        em.persist(relationships12);
        em.flush();

        Relationships relationships13 = new Relationships();
        relationships13.setIsOptionality(true);
        relationships13.setIsEmbedded(false);
//      ...................... Dependencies ........................
        Entities entities170 = new Entities();
        entities170 = findBean.nameEntities("Dependencies",em);
        relationships13.setFrom(entities170);
//      ...................... Sites ........................
        Entities entities171 = new Entities();
        entities171 = findBean.nameEntities("Sites",em);
        relationships13.setTo(entities171);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities172 = new Cardinalities();
        cardinalities172 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships13.setCardinalities(cardinalities172);
        em.persist(relationships13);
        em.flush();

        Relationships relationships14 = new Relationships();
        relationships14.setIsOptionality(true);
        relationships14.setIsEmbedded(false);
//      ...................... AttributesTypes ........................
        Entities entities173 = new Entities();
        entities173 = findBean.nameEntities("AttributesTypes",em);
        relationships14.setFrom(entities173);
//      ...................... Sites ........................
        Entities entities174 = new Entities();
        entities174 = findBean.nameEntities("Sites",em);
        relationships14.setTo(entities174);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities175 = new Cardinalities();
        cardinalities175 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships14.setCardinalities(cardinalities175);
        em.persist(relationships14);
        em.flush();

        Relationships relationships15 = new Relationships();
        relationships15.setIsOptionality(true);
        relationships15.setIsEmbedded(false);
//      ...................... AttributesProperties ........................
        Entities entities176 = new Entities();
        entities176 = findBean.nameEntities("AttributesProperties",em);
        relationships15.setFrom(entities176);
//      ...................... Sites ........................
        Entities entities177 = new Entities();
        entities177 = findBean.nameEntities("Sites",em);
        relationships15.setTo(entities177);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities178 = new Cardinalities();
        cardinalities178 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships15.setCardinalities(cardinalities178);
        em.persist(relationships15);
        em.flush();

/*
*/
/*
. AttributesTypes . *..* AttributesProperties rolA:from rolB: OK

. AttributesProperties . *..* Imports rolA:from rolB: OK

. Dependencies . 1..* Imports rolA: rolB:

*/
        Relationships relationships16 = new Relationships();
        relationships16.setIsOptionality(true);
        relationships16.setIsEmbedded(false);
//      ...................... AttributesTypes ........................
        Entities entities179 = new Entities();
        entities179 = findBean.nameEntities("AttributesTypes",em);
        relationships16.setFrom(entities179);
//      ...................... AttributesProperties ........................
        Entities entities180 = new Entities();
        entities180 = findBean.nameEntities("AttributesProperties",em);
        relationships16.setTo(entities180);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities181 = new Cardinalities();
        cardinalities181 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships16.setCardinalities(cardinalities181);
        em.persist(relationships16);
        em.flush();

        Relationships relationships17 = new Relationships();
        relationships17.setIsOptionality(true);
        relationships17.setIsEmbedded(false);
//      ...................... AttributesProperties ........................
        Entities entities182 = new Entities();
        entities182 = findBean.nameEntities("AttributesProperties",em);
        relationships17.setFrom(entities182);
//      ...................... Imports ........................
        Entities entities183 = new Entities();
        entities183 = findBean.nameEntities("Imports",em);
        relationships17.setTo(entities183);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities184 = new Cardinalities();
        cardinalities184 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships17.setCardinalities(cardinalities184);
        em.persist(relationships17);
        em.flush();

        Relationships relationships18 = new Relationships();
        relationships18.setIsOptionality(true);
        relationships18.setIsEmbedded(false);
//      ...................... Dependencies ........................
        Entities entities185 = new Entities();
        entities185 = findBean.nameEntities("Dependencies",em);
        relationships18.setFrom(entities185);
//      ...................... Imports ........................
        Entities entities186 = new Entities();
        entities186 = findBean.nameEntities("Imports",em);
        relationships18.setTo(entities186);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities187 = new Cardinalities();
        cardinalities187 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships18.setCardinalities(cardinalities187);
        em.persist(relationships18);
        em.flush();

/*
. Entities . 1..* NameQueries rolA: rolB:

. Developments . *..* Models rolA:from rolB: OK

. Models . 1..* ModelsGroupIds rolA: rolB:

. Entities . 1..* Relationships rolA: rolB:

. GroupIds . 1..* Entities rolA: rolB:

. GroupIds . 1..* ModelsGroupIds rolA: rolB:

. Entities . 1..* Relationships rolA: rolB:

. Entities . 1..* Attributes rolA: rolB:

. Cardinalities . 1..* Relationships rolA: rolB:

*/
        Relationships relationships19 = new Relationships();
        relationships19.setIsOptionality(true);
        relationships19.setIsEmbedded(false);
//      ...................... Entities ........................
        Entities entities188 = new Entities();
        entities188 = findBean.nameEntities("Entities",em);
        relationships19.setFrom(entities188);
//      ...................... NameQueries ........................
        Entities entities189 = new Entities();
        entities189 = findBean.nameEntities("NameQueries",em);
        relationships19.setTo(entities189);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities190 = new Cardinalities();
        cardinalities190 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships19.setCardinalities(cardinalities190);
        em.persist(relationships19);
        em.flush();

        Relationships relationships20 = new Relationships();
        relationships20.setIsOptionality(true);
        relationships20.setIsEmbedded(false);
//      ...................... Developments ........................
        Entities entities191 = new Entities();
        entities191 = findBean.nameEntities("Developments",em);
        relationships20.setFrom(entities191);
//      ...................... Models ........................
        Entities entities192 = new Entities();
        entities192 = findBean.nameEntities("Models",em);
        relationships20.setTo(entities192);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities193 = new Cardinalities();
        cardinalities193 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships20.setCardinalities(cardinalities193);
        em.persist(relationships20);
        em.flush();

        Relationships relationships21 = new Relationships();
        relationships21.setIsOptionality(true);
        relationships21.setIsEmbedded(false);
//      ...................... Models ........................
        Entities entities194 = new Entities();
        entities194 = findBean.nameEntities("Models",em);
        relationships21.setFrom(entities194);
//      ...................... ModelsGroupIds ........................
        Entities entities195 = new Entities();
        entities195 = findBean.nameEntities("ModelsGroupIds",em);
        relationships21.setTo(entities195);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities196 = new Cardinalities();
        cardinalities196 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships21.setCardinalities(cardinalities196);
        em.persist(relationships21);
        em.flush();

        Relationships relationships22 = new Relationships();
        relationships22.setIsOptionality(true);
        relationships22.setIsEmbedded(false);
//      ...................... Entities ........................
        Entities entities197 = new Entities();
        entities197 = findBean.nameEntities("Entities",em);
        relationships22.setFrom(entities197);
//      ...................... Relationships ........................
        Entities entities198 = new Entities();
        entities198 = findBean.nameEntities("Relationships",em);
        relationships22.setTo(entities198);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities199 = new Cardinalities();
        cardinalities199 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships22.setCardinalities(cardinalities199);
        em.persist(relationships22);
        em.flush();

        Relationships relationships23 = new Relationships();
        relationships23.setIsOptionality(true);
        relationships23.setIsEmbedded(false);
//      ...................... GroupIds ........................
        Entities entities200 = new Entities();
        entities200 = findBean.nameEntities("GroupIds",em);
        relationships23.setFrom(entities200);
//      ...................... Entities ........................
        Entities entities201 = new Entities();
        entities201 = findBean.nameEntities("Entities",em);
        relationships23.setTo(entities201);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities202 = new Cardinalities();
        cardinalities202 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships23.setCardinalities(cardinalities202);
        em.persist(relationships23);
        em.flush();

        Relationships relationships24 = new Relationships();
        relationships24.setIsOptionality(true);
        relationships24.setIsEmbedded(false);
//      ...................... GroupIds ........................
        Entities entities203 = new Entities();
        entities203 = findBean.nameEntities("GroupIds",em);
        relationships24.setFrom(entities203);
//      ...................... ModelsGroupIds ........................
        Entities entities204 = new Entities();
        entities204 = findBean.nameEntities("ModelsGroupIds",em);
        relationships24.setTo(entities204);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities205 = new Cardinalities();
        cardinalities205 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships24.setCardinalities(cardinalities205);
        em.persist(relationships24);
        em.flush();

        Relationships relationships25 = new Relationships();
        relationships25.setIsOptionality(true);
        relationships25.setIsEmbedded(false);
//      ...................... Entities ........................
        Entities entities206 = new Entities();
        entities206 = findBean.nameEntities("Entities",em);
        relationships25.setFrom(entities206);
//      ...................... Relationships ........................
        Entities entities207 = new Entities();
        entities207 = findBean.nameEntities("Relationships",em);
        relationships25.setTo(entities207);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities208 = new Cardinalities();
        cardinalities208 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships25.setCardinalities(cardinalities208);
        em.persist(relationships25);
        em.flush();

        Relationships relationships26 = new Relationships();
        relationships26.setIsOptionality(true);
        relationships26.setIsEmbedded(false);
//      ...................... Entities ........................
        Entities entities209 = new Entities();
        entities209 = findBean.nameEntities("Entities",em);
        relationships26.setFrom(entities209);
//      ...................... Attributes ........................
        Entities entities210 = new Entities();
        entities210 = findBean.nameEntities("Attributes",em);
        relationships26.setTo(entities210);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities211 = new Cardinalities();
        cardinalities211 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships26.setCardinalities(cardinalities211);
        em.persist(relationships26);
        em.flush();

        Relationships relationships27 = new Relationships();
        relationships27.setIsOptionality(true);
        relationships27.setIsEmbedded(false);
//      ...................... Cardinalities ........................
        Entities entities212 = new Entities();
        entities212 = findBean.nameEntities("Cardinalities",em);
        relationships27.setFrom(entities212);
//      ...................... Relationships ........................
        Entities entities213 = new Entities();
        entities213 = findBean.nameEntities("Relationships",em);
        relationships27.setTo(entities213);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities214 = new Cardinalities();
        cardinalities214 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships27.setCardinalities(cardinalities214);
        em.persist(relationships27);
        em.flush();

    } // data()

} // naifg
