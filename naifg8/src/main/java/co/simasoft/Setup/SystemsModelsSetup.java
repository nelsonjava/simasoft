import co.simasoft.models.naif.domainmodels.*;

import co.simasoft.beans.*;

import co.simasoft.utils.*;

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
@Named("SystemsModelsSetup")
public class SystemsModelsSetup {

    @PersistenceContext(unitName = "naifg8PU-JTA")
    private EntityManager em;

    FindBean findBean = new FindBean();

    private static final Logger log = Logger.getLogger(DataDb.class.getName());

    public void data() {

//      ---------------------- DomainModels ------------------------

        DomainModels domainModels = new DomainModels();
        domainModels.setGroupId("co.simasof");
        domainModels.setArtifactId("SystemsModels");
        domainModels.setVersion("1.0-SNAPSHOT");
        em.persist(domainModels);
        em.flush();

//      ---------------------- GroupIds ------------------------

        GroupIds groupIds1 = new GroupIds();
        groupIds1.setGroupId("co.simasoft.models.naif.domainmodels.dependencies");
//      ...................... SystemsModels ........................
        DomainModels domainModel1 = new DomainModels();
        domainModel1 = findBean.artifactIdDomainModels("SystemsModels",em);
        groupIds1.setDomainModels(domainModel1);
        em.persist(groupIds1);
        em.flush();

//      ---------------------- Entities ------------------------

        Entities entities2 = new Entities();
        entities2.setName("AttributesProperties");
//      ...................... co.simasoft.models.naif.domainmodels.dependencies ........................
        GroupIds groupId2 = new GroupIds();
        groupId2 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels.dependencies",em);
        entities2.setGroupIds(groupId2);
        em.persist(entities2);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes3 = new Attributes();
        attributes3.setName("name");
        attributes3.setNullable(false);
        attributes3.setSingle(true);
//      ...................... AttributesProperties ........................
        Entities entity3 = new Entities();
        entity3 = findBean.nameEntities("AttributesProperties",em);
        attributes3.setEntities(entity3);
//      ...................... String ........................
        AttributesTypes attributesTypes4 = new AttributesTypes();
        attributesTypes4 = findBean.nameAttributesTypes("String",em);
        attributes3.setAttributesTypes(attributesTypes4);
        em.persist(attributes3);
        em.flush();

        Attributes attributes4 = new Attributes();
        attributes4.setName("value");
        attributes4.setNullable(false);
        attributes4.setSingle(true);
//      ...................... AttributesProperties ........................
        Entities entity5 = new Entities();
        entity5 = findBean.nameEntities("AttributesProperties",em);
        attributes4.setEntities(entity5);
//      ...................... String ........................
        AttributesTypes attributesTypes6 = new AttributesTypes();
        attributesTypes6 = findBean.nameAttributesTypes("String",em);
        attributes4.setAttributesTypes(attributesTypes6);
        em.persist(attributes4);
        em.flush();

        Attributes attributes5 = new Attributes();
        attributes5.setName("observations");
        attributes5.setNullable(true);
        attributes5.setSingle(false);
//      ...................... AttributesProperties ........................
        Entities entity7 = new Entities();
        entity7 = findBean.nameEntities("AttributesProperties",em);
        attributes5.setEntities(entity7);
//      ...................... String ........................
        AttributesTypes attributesTypes8 = new AttributesTypes();
        attributesTypes8 = findBean.nameAttributesTypes("String",em);
        attributes5.setAttributesTypes(attributesTypes8);
        em.persist(attributes5);
        em.flush();

        Entities entities6 = new Entities();
        entities6.setName("AttributesTypes");
//      ...................... co.simasoft.models.naif.domainmodels.dependencies ........................
        GroupIds groupId9 = new GroupIds();
        groupId9 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels.dependencies",em);
        entities6.setGroupIds(groupId9);
        em.persist(entities6);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes7 = new Attributes();
        attributes7.setName("name");
        attributes7.setNullable(false);
        attributes7.setSingle(true);
//      ...................... AttributesTypes ........................
        Entities entity10 = new Entities();
        entity10 = findBean.nameEntities("AttributesTypes",em);
        attributes7.setEntities(entity10);
//      ...................... String ........................
        AttributesTypes attributesTypes11 = new AttributesTypes();
        attributesTypes11 = findBean.nameAttributesTypes("String",em);
        attributes7.setAttributesTypes(attributesTypes11);
        em.persist(attributes7);
        em.flush();

        Attributes attributes8 = new Attributes();
        attributes8.setName("type");
        attributes8.setNullable(false);
        attributes8.setSingle(false);
//      ...................... AttributesTypes ........................
        Entities entity12 = new Entities();
        entity12 = findBean.nameEntities("AttributesTypes",em);
        attributes8.setEntities(entity12);
//      ...................... String ........................
        AttributesTypes attributesTypes13 = new AttributesTypes();
        attributesTypes13 = findBean.nameAttributesTypes("String",em);
        attributes8.setAttributesTypes(attributesTypes13);
        em.persist(attributes8);
        em.flush();

        Attributes attributes9 = new Attributes();
        attributes9.setName("length");
        attributes9.setNullable(true);
        attributes9.setSingle(false);
//      ...................... AttributesTypes ........................
        Entities entity14 = new Entities();
        entity14 = findBean.nameEntities("AttributesTypes",em);
        attributes9.setEntities(entity14);
//      ...................... Integer ........................
        AttributesTypes attributesTypes15 = new AttributesTypes();
        attributesTypes15 = findBean.nameAttributesTypes("Integer",em);
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
        attributes11.setName("annotations");
        attributes11.setNullable(true);
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
        attributes12.setName("observations");
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
        entities13.setName("Dependency");
//      ...................... co.simasoft.models.naif.domainmodels.dependencies ........................
        GroupIds groupId22 = new GroupIds();
        groupId22 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels.dependencies",em);
        entities13.setGroupIds(groupId22);
        em.persist(entities13);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes14 = new Attributes();
        attributes14.setName("groupId");
        attributes14.setNullable(false);
        attributes14.setSingle(false);
//      ...................... Dependency ........................
        Entities entity23 = new Entities();
        entity23 = findBean.nameEntities("Dependency",em);
        attributes14.setEntities(entity23);
//      ...................... String ........................
        AttributesTypes attributesTypes24 = new AttributesTypes();
        attributesTypes24 = findBean.nameAttributesTypes("String",em);
        attributes14.setAttributesTypes(attributesTypes24);
        em.persist(attributes14);
        em.flush();

        Attributes attributes15 = new Attributes();
        attributes15.setName("artifactId");
        attributes15.setNullable(false);
        attributes15.setSingle(false);
//      ...................... Dependency ........................
        Entities entity25 = new Entities();
        entity25 = findBean.nameEntities("Dependency",em);
        attributes15.setEntities(entity25);
//      ...................... String ........................
        AttributesTypes attributesTypes26 = new AttributesTypes();
        attributesTypes26 = findBean.nameAttributesTypes("String",em);
        attributes15.setAttributesTypes(attributesTypes26);
        em.persist(attributes15);
        em.flush();

        Attributes attributes16 = new Attributes();
        attributes16.setName("version");
        attributes16.setNullable(true);
        attributes16.setSingle(false);
//      ...................... Dependency ........................
        Entities entity27 = new Entities();
        entity27 = findBean.nameEntities("Dependency",em);
        attributes16.setEntities(entity27);
//      ...................... String ........................
        AttributesTypes attributesTypes28 = new AttributesTypes();
        attributesTypes28 = findBean.nameAttributesTypes("String",em);
        attributes16.setAttributesTypes(attributesTypes28);
        em.persist(attributes16);
        em.flush();

        Attributes attributes17 = new Attributes();
        attributes17.setName("type");
        attributes17.setNullable(true);
        attributes17.setSingle(false);
//      ...................... Dependency ........................
        Entities entity29 = new Entities();
        entity29 = findBean.nameEntities("Dependency",em);
        attributes17.setEntities(entity29);
//      ...................... String ........................
        AttributesTypes attributesTypes30 = new AttributesTypes();
        attributesTypes30 = findBean.nameAttributesTypes("String",em);
        attributes17.setAttributesTypes(attributesTypes30);
        em.persist(attributes17);
        em.flush();

        Attributes attributes18 = new Attributes();
        attributes18.setName("scope");
        attributes18.setNullable(true);
        attributes18.setSingle(false);
//      ...................... Dependency ........................
        Entities entity31 = new Entities();
        entity31 = findBean.nameEntities("Dependency",em);
        attributes18.setEntities(entity31);
//      ...................... String ........................
        AttributesTypes attributesTypes32 = new AttributesTypes();
        attributesTypes32 = findBean.nameAttributesTypes("String",em);
        attributes18.setAttributesTypes(attributesTypes32);
        em.persist(attributes18);
        em.flush();

        Attributes attributes19 = new Attributes();
        attributes19.setName("maven");
        attributes19.setNullable(false);
        attributes19.setSingle(true);
//      ...................... Dependency ........................
        Entities entity33 = new Entities();
        entity33 = findBean.nameEntities("Dependency",em);
        attributes19.setEntities(entity33);
//      ...................... String ........................
        AttributesTypes attributesTypes34 = new AttributesTypes();
        attributesTypes34 = findBean.nameAttributesTypes("String",em);
        attributes19.setAttributesTypes(attributesTypes34);
        em.persist(attributes19);
        em.flush();

        Attributes attributes20 = new Attributes();
        attributes20.setName("observations");
        attributes20.setNullable(true);
        attributes20.setSingle(false);
//      ...................... Dependency ........................
        Entities entity35 = new Entities();
        entity35 = findBean.nameEntities("Dependency",em);
        attributes20.setEntities(entity35);
//      ...................... String ........................
        AttributesTypes attributesTypes36 = new AttributesTypes();
        attributesTypes36 = findBean.nameAttributesTypes("String",em);
        attributes20.setAttributesTypes(attributesTypes36);
        em.persist(attributes20);
        em.flush();

        Entities entities21 = new Entities();
        entities21.setName("Imports");
//      ...................... co.simasoft.models.naif.domainmodels.dependencies ........................
        GroupIds groupId37 = new GroupIds();
        groupId37 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels.dependencies",em);
        entities21.setGroupIds(groupId37);
        em.persist(entities21);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes22 = new Attributes();
        attributes22.setName("name");
        attributes22.setNullable(false);
        attributes22.setSingle(true);
//      ...................... Imports ........................
        Entities entity38 = new Entities();
        entity38 = findBean.nameEntities("Imports",em);
        attributes22.setEntities(entity38);
//      ...................... String ........................
        AttributesTypes attributesTypes39 = new AttributesTypes();
        attributesTypes39 = findBean.nameAttributesTypes("String",em);
        attributes22.setAttributesTypes(attributesTypes39);
        em.persist(attributes22);
        em.flush();

        Attributes attributes23 = new Attributes();
        attributes23.setName("observations");
        attributes23.setNullable(true);
        attributes23.setSingle(false);
//      ...................... Imports ........................
        Entities entity40 = new Entities();
        entity40 = findBean.nameEntities("Imports",em);
        attributes23.setEntities(entity40);
//      ...................... String ........................
        AttributesTypes attributesTypes41 = new AttributesTypes();
        attributesTypes41 = findBean.nameAttributesTypes("String",em);
        attributes23.setAttributesTypes(attributesTypes41);
        em.persist(attributes23);
        em.flush();

        GroupIds groupIds24 = new GroupIds();
        groupIds24.setGroupId("co.simasoft.models.naif.domainmodels.links");
//      ...................... SystemsModels ........................
        DomainModels domainModel42 = new DomainModels();
        domainModel42 = findBean.artifactIdDomainModels("SystemsModels",em);
        groupIds24.setDomainModels(domainModel42);
        em.persist(groupIds24);
        em.flush();

//      ---------------------- Entities ------------------------

        Entities entities25 = new Entities();
        entities25.setName("Chapters");
//      ...................... co.simasoft.models.naif.domainmodels.links ........................
        GroupIds groupId43 = new GroupIds();
        groupId43 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels.links",em);
        entities25.setGroupIds(groupId43);
        em.persist(entities25);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes26 = new Attributes();
        attributes26.setName("name");
        attributes26.setNullable(true);
        attributes26.setSingle(false);
//      ...................... Chapters ........................
        Entities entity44 = new Entities();
        entity44 = findBean.nameEntities("Chapters",em);
        attributes26.setEntities(entity44);
//      ...................... String ........................
        AttributesTypes attributesTypes45 = new AttributesTypes();
        attributesTypes45 = findBean.nameAttributesTypes("String",em);
        attributes26.setAttributesTypes(attributesTypes45);
        em.persist(attributes26);
        em.flush();

        Attributes attributes27 = new Attributes();
        attributes27.setName("content");
        attributes27.setNullable(false);
        attributes27.setSingle(false);
//      ...................... Chapters ........................
        Entities entity46 = new Entities();
        entity46 = findBean.nameEntities("Chapters",em);
        attributes27.setEntities(entity46);
//      ...................... String ........................
        AttributesTypes attributesTypes47 = new AttributesTypes();
        attributesTypes47 = findBean.nameAttributesTypes("String",em);
        attributes27.setAttributesTypes(attributesTypes47);
        em.persist(attributes27);
        em.flush();

        Entities entities28 = new Entities();
        entities28.setName("LinksTypes");
//      ...................... co.simasoft.models.naif.domainmodels.links ........................
        GroupIds groupId48 = new GroupIds();
        groupId48 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels.links",em);
        entities28.setGroupIds(groupId48);
        em.persist(entities28);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes29 = new Attributes();
        attributes29.setName("name");
        attributes29.setNullable(false);
        attributes29.setSingle(true);
//      ...................... LinksTypes ........................
        Entities entity49 = new Entities();
        entity49 = findBean.nameEntities("LinksTypes",em);
        attributes29.setEntities(entity49);
//      ...................... String ........................
        AttributesTypes attributesTypes50 = new AttributesTypes();
        attributesTypes50 = findBean.nameAttributesTypes("String",em);
        attributes29.setAttributesTypes(attributesTypes50);
        em.persist(attributes29);
        em.flush();

        Attributes attributes30 = new Attributes();
        attributes30.setName("observations");
        attributes30.setNullable(true);
        attributes30.setSingle(false);
//      ...................... LinksTypes ........................
        Entities entity51 = new Entities();
        entity51 = findBean.nameEntities("LinksTypes",em);
        attributes30.setEntities(entity51);
//      ...................... String ........................
        AttributesTypes attributesTypes52 = new AttributesTypes();
        attributesTypes52 = findBean.nameAttributesTypes("String",em);
        attributes30.setAttributesTypes(attributesTypes52);
        em.persist(attributes30);
        em.flush();

        Entities entities31 = new Entities();
        entities31.setName("Books");
//      ...................... co.simasoft.models.naif.domainmodels.links ........................
        GroupIds groupId53 = new GroupIds();
        groupId53 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels.links",em);
        entities31.setGroupIds(groupId53);
        em.persist(entities31);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes32 = new Attributes();
        attributes32.setName("name");
        attributes32.setNullable(false);
        attributes32.setSingle(true);
//      ...................... Books ........................
        Entities entity54 = new Entities();
        entity54 = findBean.nameEntities("Books",em);
        attributes32.setEntities(entity54);
//      ...................... String ........................
        AttributesTypes attributesTypes55 = new AttributesTypes();
        attributesTypes55 = findBean.nameAttributesTypes("String",em);
        attributes32.setAttributesTypes(attributesTypes55);
        em.persist(attributes32);
        em.flush();

        Attributes attributes33 = new Attributes();
        attributes33.setName("content");
        attributes33.setNullable(false);
        attributes33.setSingle(false);
//      ...................... Books ........................
        Entities entity56 = new Entities();
        entity56 = findBean.nameEntities("Books",em);
        attributes33.setEntities(entity56);
//      ...................... String ........................
        AttributesTypes attributesTypes57 = new AttributesTypes();
        attributesTypes57 = findBean.nameAttributesTypes("String",em);
        attributes33.setAttributesTypes(attributesTypes57);
        em.persist(attributes33);
        em.flush();

        Entities entities34 = new Entities();
        entities34.setName("Links");
//      ...................... co.simasoft.models.naif.domainmodels.links ........................
        GroupIds groupId58 = new GroupIds();
        groupId58 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels.links",em);
        entities34.setGroupIds(groupId58);
        em.persist(entities34);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes35 = new Attributes();
        attributes35.setName("title");
        attributes35.setNullable(false);
        attributes35.setSingle(true);
//      ...................... Links ........................
        Entities entity59 = new Entities();
        entity59 = findBean.nameEntities("Links",em);
        attributes35.setEntities(entity59);
//      ...................... String ........................
        AttributesTypes attributesTypes60 = new AttributesTypes();
        attributesTypes60 = findBean.nameAttributesTypes("String",em);
        attributes35.setAttributesTypes(attributesTypes60);
        em.persist(attributes35);
        em.flush();

        Attributes attributes36 = new Attributes();
        attributes36.setName("link");
        attributes36.setNullable(false);
        attributes36.setSingle(true);
//      ...................... Links ........................
        Entities entity61 = new Entities();
        entity61 = findBean.nameEntities("Links",em);
        attributes36.setEntities(entity61);
//      ...................... String ........................
        AttributesTypes attributesTypes62 = new AttributesTypes();
        attributesTypes62 = findBean.nameAttributesTypes("String",em);
        attributes36.setAttributesTypes(attributesTypes62);
        em.persist(attributes36);
        em.flush();

        Attributes attributes37 = new Attributes();
        attributes37.setName("observations");
        attributes37.setNullable(true);
        attributes37.setSingle(false);
//      ...................... Links ........................
        Entities entity63 = new Entities();
        entity63 = findBean.nameEntities("Links",em);
        attributes37.setEntities(entity63);
//      ...................... String ........................
        AttributesTypes attributesTypes64 = new AttributesTypes();
        attributesTypes64 = findBean.nameAttributesTypes("String",em);
        attributes37.setAttributesTypes(attributesTypes64);
        em.persist(attributes37);
        em.flush();

        Entities entities38 = new Entities();
        entities38.setName("SubChapters");
//      ...................... co.simasoft.models.naif.domainmodels.links ........................
        GroupIds groupId65 = new GroupIds();
        groupId65 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels.links",em);
        entities38.setGroupIds(groupId65);
        em.persist(entities38);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes39 = new Attributes();
        attributes39.setName("name");
        attributes39.setNullable(true);
        attributes39.setSingle(false);
//      ...................... SubChapters ........................
        Entities entity66 = new Entities();
        entity66 = findBean.nameEntities("SubChapters",em);
        attributes39.setEntities(entity66);
//      ...................... String ........................
        AttributesTypes attributesTypes67 = new AttributesTypes();
        attributesTypes67 = findBean.nameAttributesTypes("String",em);
        attributes39.setAttributesTypes(attributesTypes67);
        em.persist(attributes39);
        em.flush();

        Attributes attributes40 = new Attributes();
        attributes40.setName("content");
        attributes40.setNullable(false);
        attributes40.setSingle(false);
//      ...................... SubChapters ........................
        Entities entity68 = new Entities();
        entity68 = findBean.nameEntities("SubChapters",em);
        attributes40.setEntities(entity68);
//      ...................... String ........................
        AttributesTypes attributesTypes69 = new AttributesTypes();
        attributesTypes69 = findBean.nameAttributesTypes("String",em);
        attributes40.setAttributesTypes(attributesTypes69);
        em.persist(attributes40);
        em.flush();

        Entities entities41 = new Entities();
        entities41.setName("Sections");
//      ...................... co.simasoft.models.naif.domainmodels.links ........................
        GroupIds groupId70 = new GroupIds();
        groupId70 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels.links",em);
        entities41.setGroupIds(groupId70);
        em.persist(entities41);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes42 = new Attributes();
        attributes42.setName("name");
        attributes42.setNullable(true);
        attributes42.setSingle(false);
//      ...................... Sections ........................
        Entities entity71 = new Entities();
        entity71 = findBean.nameEntities("Sections",em);
        attributes42.setEntities(entity71);
//      ...................... String ........................
        AttributesTypes attributesTypes72 = new AttributesTypes();
        attributesTypes72 = findBean.nameAttributesTypes("String",em);
        attributes42.setAttributesTypes(attributesTypes72);
        em.persist(attributes42);
        em.flush();

        Attributes attributes43 = new Attributes();
        attributes43.setName("content");
        attributes43.setNullable(false);
        attributes43.setSingle(false);
//      ...................... Sections ........................
        Entities entity73 = new Entities();
        entity73 = findBean.nameEntities("Sections",em);
        attributes43.setEntities(entity73);
//      ...................... String ........................
        AttributesTypes attributesTypes74 = new AttributesTypes();
        attributesTypes74 = findBean.nameAttributesTypes("String",em);
        attributes43.setAttributesTypes(attributesTypes74);
        em.persist(attributes43);
        em.flush();

        GroupIds groupIds44 = new GroupIds();
        groupIds44.setGroupId("co.simasoft.models.naif.domainmodels.entities");
//      ...................... SystemsModels ........................
        DomainModels domainModel75 = new DomainModels();
        domainModel75 = findBean.artifactIdDomainModels("SystemsModels",em);
        groupIds44.setDomainModels(domainModel75);
        em.persist(groupIds44);
        em.flush();

//      ---------------------- Entities ------------------------

        Entities entities45 = new Entities();
        entities45.setName("Relationships");
//      ...................... co.simasoft.models.naif.domainmodels.entities ........................
        GroupIds groupId76 = new GroupIds();
        groupId76 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels.entities",em);
        entities45.setGroupIds(groupId76);
        em.persist(entities45);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes46 = new Attributes();
        attributes46.setName("name");
        attributes46.setNullable(true);
        attributes46.setSingle(false);
//      ...................... Relationships ........................
        Entities entity77 = new Entities();
        entity77 = findBean.nameEntities("Relationships",em);
        attributes46.setEntities(entity77);
//      ...................... String ........................
        AttributesTypes attributesTypes78 = new AttributesTypes();
        attributesTypes78 = findBean.nameAttributesTypes("String",em);
        attributes46.setAttributesTypes(attributesTypes78);
        em.persist(attributes46);
        em.flush();

        Attributes attributes47 = new Attributes();
        attributes47.setName("optionality");
        attributes47.setNullable(true);
        attributes47.setSingle(false);
//      ...................... Relationships ........................
        Entities entity79 = new Entities();
        entity79 = findBean.nameEntities("Relationships",em);
        attributes47.setEntities(entity79);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes80 = new AttributesTypes();
        attributesTypes80 = findBean.nameAttributesTypes("Boolean",em);
        attributes47.setAttributesTypes(attributesTypes80);
        em.persist(attributes47);
        em.flush();

        Attributes attributes48 = new Attributes();
        attributes48.setName("isEmbedded");
        attributes48.setNullable(true);
        attributes48.setSingle(false);
//      ...................... Relationships ........................
        Entities entity81 = new Entities();
        entity81 = findBean.nameEntities("Relationships",em);
        attributes48.setEntities(entity81);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes82 = new AttributesTypes();
        attributesTypes82 = findBean.nameAttributesTypes("Boolean",em);
        attributes48.setAttributesTypes(attributesTypes82);
        em.persist(attributes48);
        em.flush();

        Attributes attributes49 = new Attributes();
        attributes49.setName("observations");
        attributes49.setNullable(true);
        attributes49.setSingle(false);
//      ...................... Relationships ........................
        Entities entity83 = new Entities();
        entity83 = findBean.nameEntities("Relationships",em);
        attributes49.setEntities(entity83);
//      ...................... String ........................
        AttributesTypes attributesTypes84 = new AttributesTypes();
        attributesTypes84 = findBean.nameAttributesTypes("String",em);
        attributes49.setAttributesTypes(attributesTypes84);
        em.persist(attributes49);
        em.flush();

        Entities entities50 = new Entities();
        entities50.setName("Attributes");
//      ...................... co.simasoft.models.naif.domainmodels.entities ........................
        GroupIds groupId85 = new GroupIds();
        groupId85 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels.entities",em);
        entities50.setGroupIds(groupId85);
        em.persist(entities50);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes51 = new Attributes();
        attributes51.setName("name");
        attributes51.setNullable(false);
        attributes51.setSingle(false);
//      ...................... Attributes ........................
        Entities entity86 = new Entities();
        entity86 = findBean.nameEntities("Attributes",em);
        attributes51.setEntities(entity86);
//      ...................... String ........................
        AttributesTypes attributesTypes87 = new AttributesTypes();
        attributesTypes87 = findBean.nameAttributesTypes("String",em);
        attributes51.setAttributesTypes(attributesTypes87);
        em.persist(attributes51);
        em.flush();

        Attributes attributes52 = new Attributes();
        attributes52.setName("length");
        attributes52.setNullable(true);
        attributes52.setSingle(false);
//      ...................... Attributes ........................
        Entities entity88 = new Entities();
        entity88 = findBean.nameEntities("Attributes",em);
        attributes52.setEntities(entity88);
//      ...................... Integer ........................
        AttributesTypes attributesTypes89 = new AttributesTypes();
        attributesTypes89 = findBean.nameAttributesTypes("Integer",em);
        attributes52.setAttributesTypes(attributesTypes89);
        em.persist(attributes52);
        em.flush();

        Attributes attributes53 = new Attributes();
        attributes53.setName("precision");
        attributes53.setNullable(true);
        attributes53.setSingle(false);
//      ...................... Attributes ........................
        Entities entity90 = new Entities();
        entity90 = findBean.nameEntities("Attributes",em);
        attributes53.setEntities(entity90);
//      ...................... Integer ........................
        AttributesTypes attributesTypes91 = new AttributesTypes();
        attributesTypes91 = findBean.nameAttributesTypes("Integer",em);
        attributes53.setAttributesTypes(attributesTypes91);
        em.persist(attributes53);
        em.flush();

        Attributes attributes54 = new Attributes();
        attributes54.setName("nullable");
        attributes54.setNullable(true);
        attributes54.setSingle(false);
//      ...................... Attributes ........................
        Entities entity92 = new Entities();
        entity92 = findBean.nameEntities("Attributes",em);
        attributes54.setEntities(entity92);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes93 = new AttributesTypes();
        attributesTypes93 = findBean.nameAttributesTypes("Boolean",em);
        attributes54.setAttributesTypes(attributesTypes93);
        em.persist(attributes54);
        em.flush();

        Attributes attributes55 = new Attributes();
        attributes55.setName("single");
        attributes55.setNullable(true);
        attributes55.setSingle(false);
//      ...................... Attributes ........................
        Entities entity94 = new Entities();
        entity94 = findBean.nameEntities("Attributes",em);
        attributes55.setEntities(entity94);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes95 = new AttributesTypes();
        attributesTypes95 = findBean.nameAttributesTypes("Boolean",em);
        attributes55.setAttributesTypes(attributesTypes95);
        em.persist(attributes55);
        em.flush();

        Attributes attributes56 = new Attributes();
        attributes56.setName("descripcion");
        attributes56.setNullable(true);
        attributes56.setSingle(false);
//      ...................... Attributes ........................
        Entities entity96 = new Entities();
        entity96 = findBean.nameEntities("Attributes",em);
        attributes56.setEntities(entity96);
//      ...................... String ........................
        AttributesTypes attributesTypes97 = new AttributesTypes();
        attributesTypes97 = findBean.nameAttributesTypes("String",em);
        attributes56.setAttributesTypes(attributesTypes97);
        em.persist(attributes56);
        em.flush();

        Attributes attributes57 = new Attributes();
        attributes57.setName("field");
        attributes57.setNullable(true);
        attributes57.setSingle(false);
//      ...................... Attributes ........................
        Entities entity98 = new Entities();
        entity98 = findBean.nameEntities("Attributes",em);
        attributes57.setEntities(entity98);
//      ...................... String ........................
        AttributesTypes attributesTypes99 = new AttributesTypes();
        attributesTypes99 = findBean.nameAttributesTypes("String",em);
        attributes57.setAttributesTypes(attributesTypes99);
        em.persist(attributes57);
        em.flush();

        Attributes attributes58 = new Attributes();
        attributes58.setName("access");
        attributes58.setNullable(true);
        attributes58.setSingle(false);
//      ...................... Attributes ........................
        Entities entity100 = new Entities();
        entity100 = findBean.nameEntities("Attributes",em);
        attributes58.setEntities(entity100);
//      ...................... String ........................
        AttributesTypes attributesTypes101 = new AttributesTypes();
        attributesTypes101 = findBean.nameAttributesTypes("String",em);
        attributes58.setAttributesTypes(attributesTypes101);
        em.persist(attributes58);
        em.flush();

        Attributes attributes59 = new Attributes();
        attributes59.setName("columnDefinition");
        attributes59.setNullable(true);
        attributes59.setSingle(false);
//      ...................... Attributes ........................
        Entities entity102 = new Entities();
        entity102 = findBean.nameEntities("Attributes",em);
        attributes59.setEntities(entity102);
//      ...................... String ........................
        AttributesTypes attributesTypes103 = new AttributesTypes();
        attributesTypes103 = findBean.nameAttributesTypes("String",em);
        attributes59.setAttributesTypes(attributesTypes103);
        em.persist(attributes59);
        em.flush();

        Attributes attributes60 = new Attributes();
        attributes60.setName("annotationsField");
        attributes60.setNullable(true);
        attributes60.setSingle(false);
//      ...................... Attributes ........................
        Entities entity104 = new Entities();
        entity104 = findBean.nameEntities("Attributes",em);
        attributes60.setEntities(entity104);
//      ...................... String ........................
        AttributesTypes attributesTypes105 = new AttributesTypes();
        attributesTypes105 = findBean.nameAttributesTypes("String",em);
        attributes60.setAttributesTypes(attributesTypes105);
        em.persist(attributes60);
        em.flush();

        Attributes attributes61 = new Attributes();
        attributes61.setName("annotationsMethod");
        attributes61.setNullable(true);
        attributes61.setSingle(false);
//      ...................... Attributes ........................
        Entities entity106 = new Entities();
        entity106 = findBean.nameEntities("Attributes",em);
        attributes61.setEntities(entity106);
//      ...................... String ........................
        AttributesTypes attributesTypes107 = new AttributesTypes();
        attributesTypes107 = findBean.nameAttributesTypes("String",em);
        attributes61.setAttributesTypes(attributesTypes107);
        em.persist(attributes61);
        em.flush();

        Attributes attributes62 = new Attributes();
        attributes62.setName("observations");
        attributes62.setNullable(true);
        attributes62.setSingle(false);
//      ...................... Attributes ........................
        Entities entity108 = new Entities();
        entity108 = findBean.nameEntities("Attributes",em);
        attributes62.setEntities(entity108);
//      ...................... String ........................
        AttributesTypes attributesTypes109 = new AttributesTypes();
        attributesTypes109 = findBean.nameAttributesTypes("String",em);
        attributes62.setAttributesTypes(attributesTypes109);
        em.persist(attributes62);
        em.flush();

        Entities entities63 = new Entities();
        entities63.setName("NameQueries");
//      ...................... co.simasoft.models.naif.domainmodels.entities ........................
        GroupIds groupId110 = new GroupIds();
        groupId110 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels.entities",em);
        entities63.setGroupIds(groupId110);
        em.persist(entities63);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes64 = new Attributes();
        attributes64.setName("name");
        attributes64.setNullable(false);
        attributes64.setSingle(true);
//      ...................... NameQueries ........................
        Entities entity111 = new Entities();
        entity111 = findBean.nameEntities("NameQueries",em);
        attributes64.setEntities(entity111);
//      ...................... String ........................
        AttributesTypes attributesTypes112 = new AttributesTypes();
        attributesTypes112 = findBean.nameAttributesTypes("String",em);
        attributes64.setAttributesTypes(attributesTypes112);
        em.persist(attributes64);
        em.flush();

        Attributes attributes65 = new Attributes();
        attributes65.setName("query");
        attributes65.setNullable(false);
        attributes65.setSingle(true);
//      ...................... NameQueries ........................
        Entities entity113 = new Entities();
        entity113 = findBean.nameEntities("NameQueries",em);
        attributes65.setEntities(entity113);
//      ...................... String ........................
        AttributesTypes attributesTypes114 = new AttributesTypes();
        attributesTypes114 = findBean.nameAttributesTypes("String",em);
        attributes65.setAttributesTypes(attributesTypes114);
        em.persist(attributes65);
        em.flush();

        Attributes attributes66 = new Attributes();
        attributes66.setName("observations");
        attributes66.setNullable(true);
        attributes66.setSingle(false);
//      ...................... NameQueries ........................
        Entities entity115 = new Entities();
        entity115 = findBean.nameEntities("NameQueries",em);
        attributes66.setEntities(entity115);
//      ...................... String ........................
        AttributesTypes attributesTypes116 = new AttributesTypes();
        attributesTypes116 = findBean.nameAttributesTypes("String",em);
        attributes66.setAttributesTypes(attributesTypes116);
        em.persist(attributes66);
        em.flush();

        Entities entities67 = new Entities();
        entities67.setName("Entities");
//      ...................... co.simasoft.models.naif.domainmodels.entities ........................
        GroupIds groupId117 = new GroupIds();
        groupId117 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels.entities",em);
        entities67.setGroupIds(groupId117);
        em.persist(entities67);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes68 = new Attributes();
        attributes68.setName("name");
        attributes68.setNullable(false);
        attributes68.setSingle(false);
//      ...................... Entities ........................
        Entities entity118 = new Entities();
        entity118 = findBean.nameEntities("Entities",em);
        attributes68.setEntities(entity118);
//      ...................... String ........................
        AttributesTypes attributesTypes119 = new AttributesTypes();
        attributesTypes119 = findBean.nameAttributesTypes("String",em);
        attributes68.setAttributesTypes(attributesTypes119);
        em.persist(attributes68);
        em.flush();

        Attributes attributes69 = new Attributes();
        attributes69.setName("serialID");
        attributes69.setNullable(true);
        attributes69.setSingle(true);
//      ...................... Entities ........................
        Entities entity120 = new Entities();
        entity120 = findBean.nameEntities("Entities",em);
        attributes69.setEntities(entity120);
//      ...................... String ........................
        AttributesTypes attributesTypes121 = new AttributesTypes();
        attributesTypes121 = findBean.nameAttributesTypes("String",em);
        attributes69.setAttributesTypes(attributesTypes121);
        em.persist(attributes69);
        em.flush();

        Attributes attributes70 = new Attributes();
        attributes70.setName("table");
        attributes70.setNullable(true);
        attributes70.setSingle(false);
//      ...................... Entities ........................
        Entities entity122 = new Entities();
        entity122 = findBean.nameEntities("Entities",em);
        attributes70.setEntities(entity122);
//      ...................... String ........................
        AttributesTypes attributesTypes123 = new AttributesTypes();
        attributesTypes123 = findBean.nameAttributesTypes("String",em);
        attributes70.setAttributesTypes(attributesTypes123);
        em.persist(attributes70);
        em.flush();

        Attributes attributes71 = new Attributes();
        attributes71.setName("tableSecuencia");
        attributes71.setNullable(true);
        attributes71.setSingle(false);
//      ...................... Entities ........................
        Entities entity124 = new Entities();
        entity124 = findBean.nameEntities("Entities",em);
        attributes71.setEntities(entity124);
//      ...................... String ........................
        AttributesTypes attributesTypes125 = new AttributesTypes();
        attributesTypes125 = findBean.nameAttributesTypes("String",em);
        attributes71.setAttributesTypes(attributesTypes125);
        em.persist(attributes71);
        em.flush();

        Attributes attributes72 = new Attributes();
        attributes72.setName("modifier");
        attributes72.setNullable(true);
        attributes72.setSingle(false);
//      ...................... Entities ........................
        Entities entity126 = new Entities();
        entity126 = findBean.nameEntities("Entities",em);
        attributes72.setEntities(entity126);
//      ...................... String ........................
        AttributesTypes attributesTypes127 = new AttributesTypes();
        attributesTypes127 = findBean.nameAttributesTypes("String",em);
        attributes72.setAttributesTypes(attributesTypes127);
        em.persist(attributes72);
        em.flush();

        Attributes attributes73 = new Attributes();
        attributes73.setName("extend");
        attributes73.setNullable(true);
        attributes73.setSingle(false);
//      ...................... Entities ........................
        Entities entity128 = new Entities();
        entity128 = findBean.nameEntities("Entities",em);
        attributes73.setEntities(entity128);
//      ...................... String ........................
        AttributesTypes attributesTypes129 = new AttributesTypes();
        attributesTypes129 = findBean.nameAttributesTypes("String",em);
        attributes73.setAttributesTypes(attributesTypes129);
        em.persist(attributes73);
        em.flush();

        Attributes attributes74 = new Attributes();
        attributes74.setName("annotations");
        attributes74.setNullable(true);
        attributes74.setSingle(false);
//      ...................... Entities ........................
        Entities entity130 = new Entities();
        entity130 = findBean.nameEntities("Entities",em);
        attributes74.setEntities(entity130);
//      ...................... String ........................
        AttributesTypes attributesTypes131 = new AttributesTypes();
        attributesTypes131 = findBean.nameAttributesTypes("String",em);
        attributes74.setAttributesTypes(attributesTypes131);
        em.persist(attributes74);
        em.flush();

        Attributes attributes75 = new Attributes();
        attributes75.setName("source");
        attributes75.setNullable(true);
        attributes75.setSingle(false);
//      ...................... Entities ........................
        Entities entity132 = new Entities();
        entity132 = findBean.nameEntities("Entities",em);
        attributes75.setEntities(entity132);
//      ...................... String ........................
        AttributesTypes attributesTypes133 = new AttributesTypes();
        attributesTypes133 = findBean.nameAttributesTypes("String",em);
        attributes75.setAttributesTypes(attributesTypes133);
        em.persist(attributes75);
        em.flush();

        Attributes attributes76 = new Attributes();
        attributes76.setName("description");
        attributes76.setNullable(true);
        attributes76.setSingle(false);
//      ...................... Entities ........................
        Entities entity134 = new Entities();
        entity134 = findBean.nameEntities("Entities",em);
        attributes76.setEntities(entity134);
//      ...................... String ........................
        AttributesTypes attributesTypes135 = new AttributesTypes();
        attributesTypes135 = findBean.nameAttributesTypes("String",em);
        attributes76.setAttributesTypes(attributesTypes135);
        em.persist(attributes76);
        em.flush();

        Attributes attributes77 = new Attributes();
        attributes77.setName("observations");
        attributes77.setNullable(true);
        attributes77.setSingle(false);
//      ...................... Entities ........................
        Entities entity136 = new Entities();
        entity136 = findBean.nameEntities("Entities",em);
        attributes77.setEntities(entity136);
//      ...................... String ........................
        AttributesTypes attributesTypes137 = new AttributesTypes();
        attributesTypes137 = findBean.nameAttributesTypes("String",em);
        attributes77.setAttributesTypes(attributesTypes137);
        em.persist(attributes77);
        em.flush();

        Entities entities78 = new Entities();
        entities78.setName("Cardinalities");
//      ...................... co.simasoft.models.naif.domainmodels.entities ........................
        GroupIds groupId138 = new GroupIds();
        groupId138 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels.entities",em);
        entities78.setGroupIds(groupId138);
        em.persist(entities78);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes79 = new Attributes();
        attributes79.setName("name");
        attributes79.setNullable(false);
        attributes79.setSingle(true);
//      ...................... Cardinalities ........................
        Entities entity139 = new Entities();
        entity139 = findBean.nameEntities("Cardinalities",em);
        attributes79.setEntities(entity139);
//      ...................... String ........................
        AttributesTypes attributesTypes140 = new AttributesTypes();
        attributesTypes140 = findBean.nameAttributesTypes("String",em);
        attributes79.setAttributesTypes(attributesTypes140);
        em.persist(attributes79);
        em.flush();

        Attributes attributes80 = new Attributes();
        attributes80.setName("cardinality");
        attributes80.setNullable(false);
        attributes80.setSingle(false);
//      ...................... Cardinalities ........................
        Entities entity141 = new Entities();
        entity141 = findBean.nameEntities("Cardinalities",em);
        attributes80.setEntities(entity141);
//      ...................... String ........................
        AttributesTypes attributesTypes142 = new AttributesTypes();
        attributesTypes142 = findBean.nameAttributesTypes("String",em);
        attributes80.setAttributesTypes(attributesTypes142);
        em.persist(attributes80);
        em.flush();

        Attributes attributes81 = new Attributes();
        attributes81.setName("unidirectional");
        attributes81.setNullable(true);
        attributes81.setSingle(false);
//      ...................... Cardinalities ........................
        Entities entity143 = new Entities();
        entity143 = findBean.nameEntities("Cardinalities",em);
        attributes81.setEntities(entity143);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes144 = new AttributesTypes();
        attributesTypes144 = findBean.nameAttributesTypes("Boolean",em);
        attributes81.setAttributesTypes(attributesTypes144);
        em.persist(attributes81);
        em.flush();

        Attributes attributes82 = new Attributes();
        attributes82.setName("annotations");
        attributes82.setNullable(true);
        attributes82.setSingle(false);
//      ...................... Cardinalities ........................
        Entities entity145 = new Entities();
        entity145 = findBean.nameEntities("Cardinalities",em);
        attributes82.setEntities(entity145);
//      ...................... String ........................
        AttributesTypes attributesTypes146 = new AttributesTypes();
        attributesTypes146 = findBean.nameAttributesTypes("String",em);
        attributes82.setAttributesTypes(attributesTypes146);
        em.persist(attributes82);
        em.flush();

        Attributes attributes83 = new Attributes();
        attributes83.setName("observations");
        attributes83.setNullable(true);
        attributes83.setSingle(false);
//      ...................... Cardinalities ........................
        Entities entity147 = new Entities();
        entity147 = findBean.nameEntities("Cardinalities",em);
        attributes83.setEntities(entity147);
//      ...................... String ........................
        AttributesTypes attributesTypes148 = new AttributesTypes();
        attributesTypes148 = findBean.nameAttributesTypes("String",em);
        attributes83.setAttributesTypes(attributesTypes148);
        em.persist(attributes83);
        em.flush();

        GroupIds groupIds84 = new GroupIds();
        groupIds84.setGroupId("co.simasoft.models.naif.domainmodels.modelsFiles");
//      ...................... SystemsModels ........................
        DomainModels domainModel149 = new DomainModels();
        domainModel149 = findBean.artifactIdDomainModels("SystemsModels",em);
        groupIds84.setDomainModels(domainModel149);
        em.persist(groupIds84);
        em.flush();

//      ---------------------- Entities ------------------------

        Entities entities85 = new Entities();
        entities85.setName("FilesModels");
//      ...................... co.simasoft.models.naif.domainmodels.modelsFiles ........................
        GroupIds groupId150 = new GroupIds();
        groupId150 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels.modelsFiles",em);
        entities85.setGroupIds(groupId150);
        em.persist(entities85);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes86 = new Attributes();
        attributes86.setName("name");
        attributes86.setNullable(false);
        attributes86.setSingle(true);
//      ...................... FilesModels ........................
        Entities entity151 = new Entities();
        entity151 = findBean.nameEntities("FilesModels",em);
        attributes86.setEntities(entity151);
//      ...................... String ........................
        AttributesTypes attributesTypes152 = new AttributesTypes();
        attributesTypes152 = findBean.nameAttributesTypes("String",em);
        attributes86.setAttributesTypes(attributesTypes152);
        em.persist(attributes86);
        em.flush();

        Attributes attributes87 = new Attributes();
        attributes87.setName("extension");
        attributes87.setNullable(false);
        attributes87.setSingle(false);
//      ...................... FilesModels ........................
        Entities entity153 = new Entities();
        entity153 = findBean.nameEntities("FilesModels",em);
        attributes87.setEntities(entity153);
//      ...................... String ........................
        AttributesTypes attributesTypes154 = new AttributesTypes();
        attributesTypes154 = findBean.nameAttributesTypes("String",em);
        attributes87.setAttributesTypes(attributesTypes154);
        em.persist(attributes87);
        em.flush();

        Attributes attributes88 = new Attributes();
        attributes88.setName("date");
        attributes88.setNullable(false);
        attributes88.setSingle(false);
//      ...................... FilesModels ........................
        Entities entity155 = new Entities();
        entity155 = findBean.nameEntities("FilesModels",em);
        attributes88.setEntities(entity155);
//      ...................... Date ........................
        AttributesTypes attributesTypes156 = new AttributesTypes();
        attributesTypes156 = findBean.nameAttributesTypes("Date",em);
        attributes88.setAttributesTypes(attributesTypes156);
        em.persist(attributes88);
        em.flush();

        Attributes attributes89 = new Attributes();
        attributes89.setName("url");
        attributes89.setNullable(false);
        attributes89.setSingle(false);
//      ...................... FilesModels ........................
        Entities entity157 = new Entities();
        entity157 = findBean.nameEntities("FilesModels",em);
        attributes89.setEntities(entity157);
//      ...................... String ........................
        AttributesTypes attributesTypes158 = new AttributesTypes();
        attributesTypes158 = findBean.nameAttributesTypes("String",em);
        attributes89.setAttributesTypes(attributesTypes158);
        em.persist(attributes89);
        em.flush();

        Attributes attributes90 = new Attributes();
        attributes90.setName("data");
        attributes90.setNullable(true);
        attributes90.setSingle(false);
//      ...................... FilesModels ........................
        Entities entity159 = new Entities();
        entity159 = findBean.nameEntities("FilesModels",em);
        attributes90.setEntities(entity159);
//      ...................... byte ........................
        AttributesTypes attributesTypes160 = new AttributesTypes();
        attributesTypes160 = findBean.nameAttributesTypes("byte",em);
        attributes90.setAttributesTypes(attributesTypes160);
        em.persist(attributes90);
        em.flush();

        Attributes attributes91 = new Attributes();
        attributes91.setName("observations");
        attributes91.setNullable(true);
        attributes91.setSingle(false);
//      ...................... FilesModels ........................
        Entities entity161 = new Entities();
        entity161 = findBean.nameEntities("FilesModels",em);
        attributes91.setEntities(entity161);
//      ...................... String ........................
        AttributesTypes attributesTypes162 = new AttributesTypes();
        attributesTypes162 = findBean.nameAttributesTypes("String",em);
        attributes91.setAttributesTypes(attributesTypes162);
        em.persist(attributes91);
        em.flush();

        GroupIds groupIds92 = new GroupIds();
        groupIds92.setGroupId("co.simasoft.models.naif.domainmodels.systemsModels");
//      ...................... SystemsModels ........................
        DomainModels domainModel163 = new DomainModels();
        domainModel163 = findBean.artifactIdDomainModels("SystemsModels",em);
        groupIds92.setDomainModels(domainModel163);
        em.persist(groupIds92);
        em.flush();

//      ---------------------- Entities ------------------------

        Entities entities93 = new Entities();
        entities93.setName("SystemsModels");
//      ...................... co.simasoft.models.naif.domainmodels.systemsModels ........................
        GroupIds groupId164 = new GroupIds();
        groupId164 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels.systemsModels",em);
        entities93.setGroupIds(groupId164);
        em.persist(entities93);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes94 = new Attributes();
        attributes94.setName("name");
        attributes94.setNullable(false);
        attributes94.setSingle(true);
//      ...................... SystemsModels ........................
        Entities entity165 = new Entities();
        entity165 = findBean.nameEntities("SystemsModels",em);
        attributes94.setEntities(entity165);
//      ...................... String ........................
        AttributesTypes attributesTypes166 = new AttributesTypes();
        attributesTypes166 = findBean.nameAttributesTypes("String",em);
        attributes94.setAttributesTypes(attributesTypes166);
        em.persist(attributes94);
        em.flush();

        Attributes attributes95 = new Attributes();
        attributes95.setName("description");
        attributes95.setNullable(true);
        attributes95.setSingle(false);
//      ...................... SystemsModels ........................
        Entities entity167 = new Entities();
        entity167 = findBean.nameEntities("SystemsModels",em);
        attributes95.setEntities(entity167);
//      ...................... String ........................
        AttributesTypes attributesTypes168 = new AttributesTypes();
        attributesTypes168 = findBean.nameAttributesTypes("String",em);
        attributes95.setAttributesTypes(attributesTypes168);
        em.persist(attributes95);
        em.flush();

        Attributes attributes96 = new Attributes();
        attributes96.setName("observations");
        attributes96.setNullable(true);
        attributes96.setSingle(false);
//      ...................... SystemsModels ........................
        Entities entity169 = new Entities();
        entity169 = findBean.nameEntities("SystemsModels",em);
        attributes96.setEntities(entity169);
//      ...................... String ........................
        AttributesTypes attributesTypes170 = new AttributesTypes();
        attributesTypes170 = findBean.nameAttributesTypes("String",em);
        attributes96.setAttributesTypes(attributesTypes170);
        em.persist(attributes96);
        em.flush();

        Entities entities97 = new Entities();
        entities97.setName("DomainModels");
//      ...................... co.simasoft.models.naif.domainmodels.systemsModels ........................
        GroupIds groupId171 = new GroupIds();
        groupId171 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels.systemsModels",em);
        entities97.setGroupIds(groupId171);
        em.persist(entities97);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes98 = new Attributes();
        attributes98.setName("name");
        attributes98.setNullable(true);
        attributes98.setSingle(false);
//      ...................... DomainModels ........................
        Entities entity172 = new Entities();
        entity172 = findBean.nameEntities("DomainModels",em);
        attributes98.setEntities(entity172);
//      ...................... String ........................
        AttributesTypes attributesTypes173 = new AttributesTypes();
        attributesTypes173 = findBean.nameAttributesTypes("String",em);
        attributes98.setAttributesTypes(attributesTypes173);
        em.persist(attributes98);
        em.flush();

        Attributes attributes99 = new Attributes();
        attributes99.setName("groupId");
        attributes99.setNullable(false);
        attributes99.setSingle(false);
//      ...................... DomainModels ........................
        Entities entity174 = new Entities();
        entity174 = findBean.nameEntities("DomainModels",em);
        attributes99.setEntities(entity174);
//      ...................... String ........................
        AttributesTypes attributesTypes175 = new AttributesTypes();
        attributesTypes175 = findBean.nameAttributesTypes("String",em);
        attributes99.setAttributesTypes(attributesTypes175);
        em.persist(attributes99);
        em.flush();

        Attributes attributes100 = new Attributes();
        attributes100.setName("artifactId");
        attributes100.setNullable(false);
        attributes100.setSingle(true);
//      ...................... DomainModels ........................
        Entities entity176 = new Entities();
        entity176 = findBean.nameEntities("DomainModels",em);
        attributes100.setEntities(entity176);
//      ...................... String ........................
        AttributesTypes attributesTypes177 = new AttributesTypes();
        attributesTypes177 = findBean.nameAttributesTypes("String",em);
        attributes100.setAttributesTypes(attributesTypes177);
        em.persist(attributes100);
        em.flush();

        Attributes attributes101 = new Attributes();
        attributes101.setName("version");
        attributes101.setNullable(false);
        attributes101.setSingle(false);
//      ...................... DomainModels ........................
        Entities entity178 = new Entities();
        entity178 = findBean.nameEntities("DomainModels",em);
        attributes101.setEntities(entity178);
//      ...................... String ........................
        AttributesTypes attributesTypes179 = new AttributesTypes();
        attributesTypes179 = findBean.nameAttributesTypes("String",em);
        attributes101.setAttributesTypes(attributesTypes179);
        em.persist(attributes101);
        em.flush();

        Attributes attributes102 = new Attributes();
        attributes102.setName("code");
        attributes102.setNullable(true);
        attributes102.setSingle(true);
//      ...................... DomainModels ........................
        Entities entity180 = new Entities();
        entity180 = findBean.nameEntities("DomainModels",em);
        attributes102.setEntities(entity180);
//      ...................... String ........................
        AttributesTypes attributesTypes181 = new AttributesTypes();
        attributesTypes181 = findBean.nameAttributesTypes("String",em);
        attributes102.setAttributesTypes(attributesTypes181);
        em.persist(attributes102);
        em.flush();

        Attributes attributes103 = new Attributes();
        attributes103.setName("date");
        attributes103.setNullable(true);
        attributes103.setSingle(false);
//      ...................... DomainModels ........................
        Entities entity182 = new Entities();
        entity182 = findBean.nameEntities("DomainModels",em);
        attributes103.setEntities(entity182);
//      ...................... Date ........................
        AttributesTypes attributesTypes183 = new AttributesTypes();
        attributesTypes183 = findBean.nameAttributesTypes("Date",em);
        attributes103.setAttributesTypes(attributesTypes183);
        em.persist(attributes103);
        em.flush();

        Attributes attributes104 = new Attributes();
        attributes104.setName("description");
        attributes104.setNullable(true);
        attributes104.setSingle(false);
//      ...................... DomainModels ........................
        Entities entity184 = new Entities();
        entity184 = findBean.nameEntities("DomainModels",em);
        attributes104.setEntities(entity184);
//      ...................... String ........................
        AttributesTypes attributesTypes185 = new AttributesTypes();
        attributesTypes185 = findBean.nameAttributesTypes("String",em);
        attributes104.setAttributesTypes(attributesTypes185);
        em.persist(attributes104);
        em.flush();

        Attributes attributes105 = new Attributes();
        attributes105.setName("observations");
        attributes105.setNullable(true);
        attributes105.setSingle(false);
//      ...................... DomainModels ........................
        Entities entity186 = new Entities();
        entity186 = findBean.nameEntities("DomainModels",em);
        attributes105.setEntities(entity186);
//      ...................... String ........................
        AttributesTypes attributesTypes187 = new AttributesTypes();
        attributesTypes187 = findBean.nameAttributesTypes("String",em);
        attributes105.setAttributesTypes(attributesTypes187);
        em.persist(attributes105);
        em.flush();

        Entities entities106 = new Entities();
        entities106.setName("GroupIds");
//      ...................... co.simasoft.models.naif.domainmodels.systemsModels ........................
        GroupIds groupId188 = new GroupIds();
        groupId188 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels.systemsModels",em);
        entities106.setGroupIds(groupId188);
        em.persist(entities106);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes107 = new Attributes();
        attributes107.setName("name");
        attributes107.setNullable(true);
        attributes107.setSingle(false);
//      ...................... GroupIds ........................
        Entities entity189 = new Entities();
        entity189 = findBean.nameEntities("GroupIds",em);
        attributes107.setEntities(entity189);
//      ...................... String ........................
        AttributesTypes attributesTypes190 = new AttributesTypes();
        attributesTypes190 = findBean.nameAttributesTypes("String",em);
        attributes107.setAttributesTypes(attributesTypes190);
        em.persist(attributes107);
        em.flush();

        Attributes attributes108 = new Attributes();
        attributes108.setName("groupId");
        attributes108.setNullable(false);
        attributes108.setSingle(false);
//      ...................... GroupIds ........................
        Entities entity191 = new Entities();
        entity191 = findBean.nameEntities("GroupIds",em);
        attributes108.setEntities(entity191);
//      ...................... String ........................
        AttributesTypes attributesTypes192 = new AttributesTypes();
        attributesTypes192 = findBean.nameAttributesTypes("String",em);
        attributes108.setAttributesTypes(attributesTypes192);
        em.persist(attributes108);
        em.flush();

        Attributes attributes109 = new Attributes();
        attributes109.setName("artifactId");
        attributes109.setNullable(true);
        attributes109.setSingle(true);
//      ...................... GroupIds ........................
        Entities entity193 = new Entities();
        entity193 = findBean.nameEntities("GroupIds",em);
        attributes109.setEntities(entity193);
//      ...................... String ........................
        AttributesTypes attributesTypes194 = new AttributesTypes();
        attributesTypes194 = findBean.nameAttributesTypes("String",em);
        attributes109.setAttributesTypes(attributesTypes194);
        em.persist(attributes109);
        em.flush();

        Attributes attributes110 = new Attributes();
        attributes110.setName("version");
        attributes110.setNullable(true);
        attributes110.setSingle(false);
//      ...................... GroupIds ........................
        Entities entity195 = new Entities();
        entity195 = findBean.nameEntities("GroupIds",em);
        attributes110.setEntities(entity195);
//      ...................... String ........................
        AttributesTypes attributesTypes196 = new AttributesTypes();
        attributesTypes196 = findBean.nameAttributesTypes("String",em);
        attributes110.setAttributesTypes(attributesTypes196);
        em.persist(attributes110);
        em.flush();

        Attributes attributes111 = new Attributes();
        attributes111.setName("code");
        attributes111.setNullable(true);
        attributes111.setSingle(true);
//      ...................... GroupIds ........................
        Entities entity197 = new Entities();
        entity197 = findBean.nameEntities("GroupIds",em);
        attributes111.setEntities(entity197);
//      ...................... String ........................
        AttributesTypes attributesTypes198 = new AttributesTypes();
        attributesTypes198 = findBean.nameAttributesTypes("String",em);
        attributes111.setAttributesTypes(attributesTypes198);
        em.persist(attributes111);
        em.flush();

        Attributes attributes112 = new Attributes();
        attributes112.setName("date");
        attributes112.setNullable(true);
        attributes112.setSingle(false);
//      ...................... GroupIds ........................
        Entities entity199 = new Entities();
        entity199 = findBean.nameEntities("GroupIds",em);
        attributes112.setEntities(entity199);
//      ...................... Date ........................
        AttributesTypes attributesTypes200 = new AttributesTypes();
        attributesTypes200 = findBean.nameAttributesTypes("Date",em);
        attributes112.setAttributesTypes(attributesTypes200);
        em.persist(attributes112);
        em.flush();

        Attributes attributes113 = new Attributes();
        attributes113.setName("description");
        attributes113.setNullable(true);
        attributes113.setSingle(false);
//      ...................... GroupIds ........................
        Entities entity201 = new Entities();
        entity201 = findBean.nameEntities("GroupIds",em);
        attributes113.setEntities(entity201);
//      ...................... String ........................
        AttributesTypes attributesTypes202 = new AttributesTypes();
        attributesTypes202 = findBean.nameAttributesTypes("String",em);
        attributes113.setAttributesTypes(attributesTypes202);
        em.persist(attributes113);
        em.flush();

        Attributes attributes114 = new Attributes();
        attributes114.setName("observations");
        attributes114.setNullable(true);
        attributes114.setSingle(false);
//      ...................... GroupIds ........................
        Entities entity203 = new Entities();
        entity203 = findBean.nameEntities("GroupIds",em);
        attributes114.setEntities(entity203);
//      ...................... String ........................
        AttributesTypes attributesTypes204 = new AttributesTypes();
        attributesTypes204 = findBean.nameAttributesTypes("String",em);
        attributes114.setAttributesTypes(attributesTypes204);
        em.persist(attributes114);
        em.flush();

//      ---------------------- Relationships ------------------------

        Relationships relationships1 = new Relationships();
        relationships1.setOptionality(true);
        relationships1.setIsEmbedded(false);
//      ...................... AttributesTypes ........................
        Entities entities205 = new Entities();
        entities205 = findBean.nameEntities("AttributesTypes",em);
        relationships1.setFrom(entities205);
//      ...................... AttributesProperties ........................
        Entities entities206 = new Entities();
        entities206 = findBean.nameEntities("AttributesProperties",em);
        relationships1.setTo(entities206);
//      ...................... *..* ........................
        Cardinalities cardinalities207 = new Cardinalities();
        cardinalities207 = findBean.cardinalityCardinalities("*..*",em);
        relationships1.setCardinalities(cardinalities207);
        em.persist(relationships1);
        em.flush();

        Relationships relationships2 = new Relationships();
        relationships2.setOptionality(true);
        relationships2.setIsEmbedded(false);
//      ...................... Imports ........................
        Entities entities208 = new Entities();
        entities208 = findBean.nameEntities("Imports",em);
        relationships2.setFrom(entities208);
//      ...................... AttributesProperties ........................
        Entities entities209 = new Entities();
        entities209 = findBean.nameEntities("AttributesProperties",em);
        relationships2.setTo(entities209);
//      ...................... *..* ........................
        Cardinalities cardinalities210 = new Cardinalities();
        cardinalities210 = findBean.cardinalityCardinalities("*..*",em);
        relationships2.setCardinalities(cardinalities210);
        em.persist(relationships2);
        em.flush();

        Relationships relationships3 = new Relationships();
        relationships3.setOptionality(true);
        relationships3.setIsEmbedded(false);
//      ...................... Dependency ........................
        Entities entities211 = new Entities();
        entities211 = findBean.nameEntities("Dependency",em);
        relationships3.setFrom(entities211);
//      ...................... Imports ........................
        Entities entities212 = new Entities();
        entities212 = findBean.nameEntities("Imports",em);
        relationships3.setTo(entities212);
//      ...................... 1..* ........................
        Cardinalities cardinalities213 = new Cardinalities();
        cardinalities213 = findBean.cardinalityCardinalities("1..*",em);
        relationships3.setCardinalities(cardinalities213);
        em.persist(relationships3);
        em.flush();

        Relationships relationships4 = new Relationships();
        relationships4.setOptionality(true);
        relationships4.setIsEmbedded(false);
//      ...................... Imports ........................
        Entities entities214 = new Entities();
        entities214 = findBean.nameEntities("Imports",em);
        relationships4.setFrom(entities214);
//      ...................... Dependency ........................
        Entities entities215 = new Entities();
        entities215 = findBean.nameEntities("Dependency",em);
        relationships4.setTo(entities215);
//      ...................... *..1 ........................
        Cardinalities cardinalities216 = new Cardinalities();
        cardinalities216 = findBean.cardinalityCardinalities("*..1",em);
        relationships4.setCardinalities(cardinalities216);
        em.persist(relationships4);
        em.flush();

        Relationships relationships5 = new Relationships();
        relationships5.setOptionality(true);
        relationships5.setIsEmbedded(false);
//      ...................... AttributesProperties ........................
        Entities entities217 = new Entities();
        entities217 = findBean.nameEntities("AttributesProperties",em);
        relationships5.setFrom(entities217);
//      ...................... Imports ........................
        Entities entities218 = new Entities();
        entities218 = findBean.nameEntities("Imports",em);
        relationships5.setTo(entities218);
//      ...................... *..* ........................
        Cardinalities cardinalities219 = new Cardinalities();
        cardinalities219 = findBean.cardinalityCardinalities("*..*",em);
        relationships5.setCardinalities(cardinalities219);
        em.persist(relationships5);
        em.flush();

        Relationships relationships6 = new Relationships();
        relationships6.setOptionality(true);
        relationships6.setIsEmbedded(false);
//      ...................... AttributesProperties ........................
        Entities entities220 = new Entities();
        entities220 = findBean.nameEntities("AttributesProperties",em);
        relationships6.setFrom(entities220);
//      ...................... AttributesTypes ........................
        Entities entities221 = new Entities();
        entities221 = findBean.nameEntities("AttributesTypes",em);
        relationships6.setTo(entities221);
//      ...................... *..* ........................
        Cardinalities cardinalities222 = new Cardinalities();
        cardinalities222 = findBean.cardinalityCardinalities("*..*",em);
        relationships6.setCardinalities(cardinalities222);
        em.persist(relationships6);
        em.flush();

        Relationships relationships7 = new Relationships();
        relationships7.setOptionality(true);
        relationships7.setIsEmbedded(false);
//      ...................... Links ........................
        Entities entities223 = new Entities();
        entities223 = findBean.nameEntities("Links",em);
        relationships7.setFrom(entities223);
//      ...................... Links ........................
        Entities entities224 = new Entities();
        entities224 = findBean.nameEntities("Links",em);
        relationships7.setTo(entities224);
//      ...................... *..1 ........................
        Cardinalities cardinalities225 = new Cardinalities();
        cardinalities225 = findBean.cardinalityCardinalities("*..1",em);
        relationships7.setCardinalities(cardinalities225);
        em.persist(relationships7);
        em.flush();

        Relationships relationships8 = new Relationships();
        relationships8.setOptionality(true);
        relationships8.setIsEmbedded(false);
//      ...................... Links ........................
        Entities entities226 = new Entities();
        entities226 = findBean.nameEntities("Links",em);
        relationships8.setFrom(entities226);
//      ...................... LinksTypes ........................
        Entities entities227 = new Entities();
        entities227 = findBean.nameEntities("LinksTypes",em);
        relationships8.setTo(entities227);
//      ...................... *..* ........................
        Cardinalities cardinalities228 = new Cardinalities();
        cardinalities228 = findBean.cardinalityCardinalities("*..*",em);
        relationships8.setCardinalities(cardinalities228);
        em.persist(relationships8);
        em.flush();

        Relationships relationships9 = new Relationships();
        relationships9.setOptionality(true);
        relationships9.setIsEmbedded(false);
//      ...................... LinksTypes ........................
        Entities entities229 = new Entities();
        entities229 = findBean.nameEntities("LinksTypes",em);
        relationships9.setFrom(entities229);
//      ...................... LinksTypes ........................
        Entities entities230 = new Entities();
        entities230 = findBean.nameEntities("LinksTypes",em);
        relationships9.setTo(entities230);
//      ...................... 1..* ........................
        Cardinalities cardinalities231 = new Cardinalities();
        cardinalities231 = findBean.cardinalityCardinalities("1..*",em);
        relationships9.setCardinalities(cardinalities231);
        em.persist(relationships9);
        em.flush();

        Relationships relationships10 = new Relationships();
        relationships10.setOptionality(true);
        relationships10.setIsEmbedded(false);
//      ...................... LinksTypes ........................
        Entities entities232 = new Entities();
        entities232 = findBean.nameEntities("LinksTypes",em);
        relationships10.setFrom(entities232);
//      ...................... LinksTypes ........................
        Entities entities233 = new Entities();
        entities233 = findBean.nameEntities("LinksTypes",em);
        relationships10.setTo(entities233);
//      ...................... *..1 ........................
        Cardinalities cardinalities234 = new Cardinalities();
        cardinalities234 = findBean.cardinalityCardinalities("*..1",em);
        relationships10.setCardinalities(cardinalities234);
        em.persist(relationships10);
        em.flush();

        Relationships relationships11 = new Relationships();
        relationships11.setOptionality(true);
        relationships11.setIsEmbedded(false);
//      ...................... Links ........................
        Entities entities235 = new Entities();
        entities235 = findBean.nameEntities("Links",em);
        relationships11.setFrom(entities235);
//      ...................... Links ........................
        Entities entities236 = new Entities();
        entities236 = findBean.nameEntities("Links",em);
        relationships11.setTo(entities236);
//      ...................... 1..* ........................
        Cardinalities cardinalities237 = new Cardinalities();
        cardinalities237 = findBean.cardinalityCardinalities("1..*",em);
        relationships11.setCardinalities(cardinalities237);
        em.persist(relationships11);
        em.flush();

        Relationships relationships12 = new Relationships();
        relationships12.setOptionality(true);
        relationships12.setIsEmbedded(false);
//      ...................... LinksTypes ........................
        Entities entities238 = new Entities();
        entities238 = findBean.nameEntities("LinksTypes",em);
        relationships12.setFrom(entities238);
//      ...................... Links ........................
        Entities entities239 = new Entities();
        entities239 = findBean.nameEntities("Links",em);
        relationships12.setTo(entities239);
//      ...................... *..* ........................
        Cardinalities cardinalities240 = new Cardinalities();
        cardinalities240 = findBean.cardinalityCardinalities("*..*",em);
        relationships12.setCardinalities(cardinalities240);
        em.persist(relationships12);
        em.flush();

        Relationships relationships13 = new Relationships();
        relationships13.setOptionality(true);
        relationships13.setIsEmbedded(false);
//      ...................... Relationships ........................
        Entities entities241 = new Entities();
        entities241 = findBean.nameEntities("Relationships",em);
        relationships13.setFrom(entities241);
//      ...................... AttributesProperties ........................
        Entities entities242 = new Entities();
        entities242 = findBean.nameEntities("AttributesProperties",em);
        relationships13.setTo(entities242);
//      ...................... *..* ........................
        Cardinalities cardinalities243 = new Cardinalities();
        cardinalities243 = findBean.cardinalityCardinalities("*..*",em);
        relationships13.setCardinalities(cardinalities243);
        em.persist(relationships13);
        em.flush();

        Relationships relationships14 = new Relationships();
        relationships14.setOptionality(true);
        relationships14.setIsEmbedded(false);
//      ...................... Relationships ........................
        Entities entities244 = new Entities();
        entities244 = findBean.nameEntities("Relationships",em);
        relationships14.setFrom(entities244);
//      ...................... Entities ........................
        Entities entities245 = new Entities();
        entities245 = findBean.nameEntities("Entities",em);
        relationships14.setTo(entities245);
//      ...................... *..1 ........................
        Cardinalities cardinalities246 = new Cardinalities();
        cardinalities246 = findBean.cardinalityCardinalities("*..1",em);
        relationships14.setCardinalities(cardinalities246);
        em.persist(relationships14);
        em.flush();

        Relationships relationships15 = new Relationships();
        relationships15.setOptionality(true);
        relationships15.setIsEmbedded(false);
//      ...................... Imports ........................
        Entities entities247 = new Entities();
        entities247 = findBean.nameEntities("Imports",em);
        relationships15.setFrom(entities247);
//      ...................... Cardinalities ........................
        Entities entities248 = new Entities();
        entities248 = findBean.nameEntities("Cardinalities",em);
        relationships15.setTo(entities248);
//      ...................... *..* ........................
        Cardinalities cardinalities249 = new Cardinalities();
        cardinalities249 = findBean.cardinalityCardinalities("*..*",em);
        relationships15.setCardinalities(cardinalities249);
        em.persist(relationships15);
        em.flush();

        Relationships relationships16 = new Relationships();
        relationships16.setOptionality(true);
        relationships16.setIsEmbedded(false);
//      ...................... Imports ........................
        Entities entities250 = new Entities();
        entities250 = findBean.nameEntities("Imports",em);
        relationships16.setFrom(entities250);
//      ...................... Entities ........................
        Entities entities251 = new Entities();
        entities251 = findBean.nameEntities("Entities",em);
        relationships16.setTo(entities251);
//      ...................... *..* ........................
        Cardinalities cardinalities252 = new Cardinalities();
        cardinalities252 = findBean.cardinalityCardinalities("*..*",em);
        relationships16.setCardinalities(cardinalities252);
        em.persist(relationships16);
        em.flush();

        Relationships relationships17 = new Relationships();
        relationships17.setOptionality(true);
        relationships17.setIsEmbedded(false);
//      ...................... AttributesProperties ........................
        Entities entities253 = new Entities();
        entities253 = findBean.nameEntities("AttributesProperties",em);
        relationships17.setFrom(entities253);
//      ...................... Relationships ........................
        Entities entities254 = new Entities();
        entities254 = findBean.nameEntities("Relationships",em);
        relationships17.setTo(entities254);
//      ...................... *..* ........................
        Cardinalities cardinalities255 = new Cardinalities();
        cardinalities255 = findBean.cardinalityCardinalities("*..*",em);
        relationships17.setCardinalities(cardinalities255);
        em.persist(relationships17);
        em.flush();

        Relationships relationships18 = new Relationships();
        relationships18.setOptionality(true);
        relationships18.setIsEmbedded(false);
//      ...................... Attributes ........................
        Entities entities256 = new Entities();
        entities256 = findBean.nameEntities("Attributes",em);
        relationships18.setFrom(entities256);
//      ...................... AttributesTypes ........................
        Entities entities257 = new Entities();
        entities257 = findBean.nameEntities("AttributesTypes",em);
        relationships18.setTo(entities257);
//      ...................... *..1 ........................
        Cardinalities cardinalities258 = new Cardinalities();
        cardinalities258 = findBean.cardinalityCardinalities("*..1",em);
        relationships18.setCardinalities(cardinalities258);
        em.persist(relationships18);
        em.flush();

        Relationships relationships19 = new Relationships();
        relationships19.setOptionality(true);
        relationships19.setIsEmbedded(false);
//      ...................... Entities ........................
        Entities entities259 = new Entities();
        entities259 = findBean.nameEntities("Entities",em);
        relationships19.setFrom(entities259);
//      ...................... Relationships ........................
        Entities entities260 = new Entities();
        entities260 = findBean.nameEntities("Relationships",em);
        relationships19.setTo(entities260);
//      ...................... 1..* ........................
        Cardinalities cardinalities261 = new Cardinalities();
        cardinalities261 = findBean.cardinalityCardinalities("1..*",em);
        relationships19.setCardinalities(cardinalities261);
        em.persist(relationships19);
        em.flush();

        Relationships relationships20 = new Relationships();
        relationships20.setOptionality(true);
        relationships20.setIsEmbedded(false);
//      ...................... FilesModels ........................
        Entities entities262 = new Entities();
        entities262 = findBean.nameEntities("FilesModels",em);
        relationships20.setFrom(entities262);
//      ...................... Entities ........................
        Entities entities263 = new Entities();
        entities263 = findBean.nameEntities("Entities",em);
        relationships20.setTo(entities263);
//      ...................... *..1 ........................
        Cardinalities cardinalities264 = new Cardinalities();
        cardinalities264 = findBean.cardinalityCardinalities("*..1",em);
        relationships20.setCardinalities(cardinalities264);
        em.persist(relationships20);
        em.flush();

        Relationships relationships21 = new Relationships();
        relationships21.setOptionality(true);
        relationships21.setIsEmbedded(false);
//      ...................... Relationships ........................
        Entities entities265 = new Entities();
        entities265 = findBean.nameEntities("Relationships",em);
        relationships21.setFrom(entities265);
//      ...................... Cardinalities ........................
        Entities entities266 = new Entities();
        entities266 = findBean.nameEntities("Cardinalities",em);
        relationships21.setTo(entities266);
//      ...................... *..1 ........................
        Cardinalities cardinalities267 = new Cardinalities();
        cardinalities267 = findBean.cardinalityCardinalities("*..1",em);
        relationships21.setCardinalities(cardinalities267);
        em.persist(relationships21);
        em.flush();

        Relationships relationships22 = new Relationships();
        relationships22.setOptionality(true);
        relationships22.setIsEmbedded(false);
//      ...................... Entities ........................
        Entities entities268 = new Entities();
        entities268 = findBean.nameEntities("Entities",em);
        relationships22.setFrom(entities268);
//      ...................... FilesModels ........................
        Entities entities269 = new Entities();
        entities269 = findBean.nameEntities("FilesModels",em);
        relationships22.setTo(entities269);
//      ...................... 1..* ........................
        Cardinalities cardinalities270 = new Cardinalities();
        cardinalities270 = findBean.cardinalityCardinalities("1..*",em);
        relationships22.setCardinalities(cardinalities270);
        em.persist(relationships22);
        em.flush();

        Relationships relationships23 = new Relationships();
        relationships23.setOptionality(true);
        relationships23.setIsEmbedded(false);
//      ...................... Attributes ........................
        Entities entities271 = new Entities();
        entities271 = findBean.nameEntities("Attributes",em);
        relationships23.setFrom(entities271);
//      ...................... Entities ........................
        Entities entities272 = new Entities();
        entities272 = findBean.nameEntities("Entities",em);
        relationships23.setTo(entities272);
//      ...................... *..1 ........................
        Cardinalities cardinalities273 = new Cardinalities();
        cardinalities273 = findBean.cardinalityCardinalities("*..1",em);
        relationships23.setCardinalities(cardinalities273);
        em.persist(relationships23);
        em.flush();

        Relationships relationships24 = new Relationships();
        relationships24.setOptionality(true);
        relationships24.setIsEmbedded(false);
//      ...................... Entities ........................
        Entities entities274 = new Entities();
        entities274 = findBean.nameEntities("Entities",em);
        relationships24.setFrom(entities274);
//      ...................... Relationships ........................
        Entities entities275 = new Entities();
        entities275 = findBean.nameEntities("Relationships",em);
        relationships24.setTo(entities275);
//      ...................... 1..* ........................
        Cardinalities cardinalities276 = new Cardinalities();
        cardinalities276 = findBean.cardinalityCardinalities("1..*",em);
        relationships24.setCardinalities(cardinalities276);
        em.persist(relationships24);
        em.flush();

        Relationships relationships25 = new Relationships();
        relationships25.setOptionality(true);
        relationships25.setIsEmbedded(false);
//      ...................... Relationships ........................
        Entities entities277 = new Entities();
        entities277 = findBean.nameEntities("Relationships",em);
        relationships25.setFrom(entities277);
//      ...................... Entities ........................
        Entities entities278 = new Entities();
        entities278 = findBean.nameEntities("Entities",em);
        relationships25.setTo(entities278);
//      ...................... *..1 ........................
        Cardinalities cardinalities279 = new Cardinalities();
        cardinalities279 = findBean.cardinalityCardinalities("*..1",em);
        relationships25.setCardinalities(cardinalities279);
        em.persist(relationships25);
        em.flush();

        Relationships relationships26 = new Relationships();
        relationships26.setOptionality(true);
        relationships26.setIsEmbedded(false);
//      ...................... Cardinalities ........................
        Entities entities280 = new Entities();
        entities280 = findBean.nameEntities("Cardinalities",em);
        relationships26.setFrom(entities280);
//      ...................... Imports ........................
        Entities entities281 = new Entities();
        entities281 = findBean.nameEntities("Imports",em);
        relationships26.setTo(entities281);
//      ...................... *..* ........................
        Cardinalities cardinalities282 = new Cardinalities();
        cardinalities282 = findBean.cardinalityCardinalities("*..*",em);
        relationships26.setCardinalities(cardinalities282);
        em.persist(relationships26);
        em.flush();

        Relationships relationships27 = new Relationships();
        relationships27.setOptionality(true);
        relationships27.setIsEmbedded(false);
//      ...................... NameQueries ........................
        Entities entities283 = new Entities();
        entities283 = findBean.nameEntities("NameQueries",em);
        relationships27.setFrom(entities283);
//      ...................... Entities ........................
        Entities entities284 = new Entities();
        entities284 = findBean.nameEntities("Entities",em);
        relationships27.setTo(entities284);
//      ...................... *..1 ........................
        Cardinalities cardinalities285 = new Cardinalities();
        cardinalities285 = findBean.cardinalityCardinalities("*..1",em);
        relationships27.setCardinalities(cardinalities285);
        em.persist(relationships27);
        em.flush();

        Relationships relationships28 = new Relationships();
        relationships28.setOptionality(true);
        relationships28.setIsEmbedded(false);
//      ...................... Entities ........................
        Entities entities286 = new Entities();
        entities286 = findBean.nameEntities("Entities",em);
        relationships28.setFrom(entities286);
//      ...................... Imports ........................
        Entities entities287 = new Entities();
        entities287 = findBean.nameEntities("Imports",em);
        relationships28.setTo(entities287);
//      ...................... *..* ........................
        Cardinalities cardinalities288 = new Cardinalities();
        cardinalities288 = findBean.cardinalityCardinalities("*..*",em);
        relationships28.setCardinalities(cardinalities288);
        em.persist(relationships28);
        em.flush();

        Relationships relationships29 = new Relationships();
        relationships29.setOptionality(true);
        relationships29.setIsEmbedded(false);
//      ...................... Attributes ........................
        Entities entities289 = new Entities();
        entities289 = findBean.nameEntities("Attributes",em);
        relationships29.setFrom(entities289);
//      ...................... AttributesProperties ........................
        Entities entities290 = new Entities();
        entities290 = findBean.nameEntities("AttributesProperties",em);
        relationships29.setTo(entities290);
//      ...................... *..* ........................
        Cardinalities cardinalities291 = new Cardinalities();
        cardinalities291 = findBean.cardinalityCardinalities("*..*",em);
        relationships29.setCardinalities(cardinalities291);
        em.persist(relationships29);
        em.flush();

        Relationships relationships30 = new Relationships();
        relationships30.setOptionality(true);
        relationships30.setIsEmbedded(false);
//      ...................... Entities ........................
        Entities entities292 = new Entities();
        entities292 = findBean.nameEntities("Entities",em);
        relationships30.setFrom(entities292);
//      ...................... NameQueries ........................
        Entities entities293 = new Entities();
        entities293 = findBean.nameEntities("NameQueries",em);
        relationships30.setTo(entities293);
//      ...................... 1..* ........................
        Cardinalities cardinalities294 = new Cardinalities();
        cardinalities294 = findBean.cardinalityCardinalities("1..*",em);
        relationships30.setCardinalities(cardinalities294);
        em.persist(relationships30);
        em.flush();

        Relationships relationships31 = new Relationships();
        relationships31.setOptionality(true);
        relationships31.setIsEmbedded(false);
//      ...................... Cardinalities ........................
        Entities entities295 = new Entities();
        entities295 = findBean.nameEntities("Cardinalities",em);
        relationships31.setFrom(entities295);
//      ...................... Relationships ........................
        Entities entities296 = new Entities();
        entities296 = findBean.nameEntities("Relationships",em);
        relationships31.setTo(entities296);
//      ...................... 1..* ........................
        Cardinalities cardinalities297 = new Cardinalities();
        cardinalities297 = findBean.cardinalityCardinalities("1..*",em);
        relationships31.setCardinalities(cardinalities297);
        em.persist(relationships31);
        em.flush();

        Relationships relationships32 = new Relationships();
        relationships32.setOptionality(true);
        relationships32.setIsEmbedded(false);
//      ...................... AttributesProperties ........................
        Entities entities298 = new Entities();
        entities298 = findBean.nameEntities("AttributesProperties",em);
        relationships32.setFrom(entities298);
//      ...................... Attributes ........................
        Entities entities299 = new Entities();
        entities299 = findBean.nameEntities("Attributes",em);
        relationships32.setTo(entities299);
//      ...................... *..* ........................
        Cardinalities cardinalities300 = new Cardinalities();
        cardinalities300 = findBean.cardinalityCardinalities("*..*",em);
        relationships32.setCardinalities(cardinalities300);
        em.persist(relationships32);
        em.flush();

        Relationships relationships33 = new Relationships();
        relationships33.setOptionality(true);
        relationships33.setIsEmbedded(false);
//      ...................... AttributesTypes ........................
        Entities entities301 = new Entities();
        entities301 = findBean.nameEntities("AttributesTypes",em);
        relationships33.setFrom(entities301);
//      ...................... Attributes ........................
        Entities entities302 = new Entities();
        entities302 = findBean.nameEntities("Attributes",em);
        relationships33.setTo(entities302);
//      ...................... 1..* ........................
        Cardinalities cardinalities303 = new Cardinalities();
        cardinalities303 = findBean.cardinalityCardinalities("1..*",em);
        relationships33.setCardinalities(cardinalities303);
        em.persist(relationships33);
        em.flush();

        Relationships relationships34 = new Relationships();
        relationships34.setOptionality(true);
        relationships34.setIsEmbedded(false);
//      ...................... Entities ........................
        Entities entities304 = new Entities();
        entities304 = findBean.nameEntities("Entities",em);
        relationships34.setFrom(entities304);
//      ...................... Attributes ........................
        Entities entities305 = new Entities();
        entities305 = findBean.nameEntities("Attributes",em);
        relationships34.setTo(entities305);
//      ...................... 1..* ........................
        Cardinalities cardinalities306 = new Cardinalities();
        cardinalities306 = findBean.cardinalityCardinalities("1..*",em);
        relationships34.setCardinalities(cardinalities306);
        em.persist(relationships34);
        em.flush();

        Relationships relationships35 = new Relationships();
        relationships35.setOptionality(true);
        relationships35.setIsEmbedded(false);
//      ...................... GroupIds ........................
        Entities entities307 = new Entities();
        entities307 = findBean.nameEntities("GroupIds",em);
        relationships35.setFrom(entities307);
//      ...................... FilesModels ........................
        Entities entities308 = new Entities();
        entities308 = findBean.nameEntities("FilesModels",em);
        relationships35.setTo(entities308);
//      ...................... 1..* ........................
        Cardinalities cardinalities309 = new Cardinalities();
        cardinalities309 = findBean.cardinalityCardinalities("1..*",em);
        relationships35.setCardinalities(cardinalities309);
        em.persist(relationships35);
        em.flush();

        Relationships relationships36 = new Relationships();
        relationships36.setOptionality(true);
        relationships36.setIsEmbedded(false);
//      ...................... FilesModels ........................
        Entities entities310 = new Entities();
        entities310 = findBean.nameEntities("FilesModels",em);
        relationships36.setFrom(entities310);
//      ...................... GroupIds ........................
        Entities entities311 = new Entities();
        entities311 = findBean.nameEntities("GroupIds",em);
        relationships36.setTo(entities311);
//      ...................... *..1 ........................
        Cardinalities cardinalities312 = new Cardinalities();
        cardinalities312 = findBean.cardinalityCardinalities("*..1",em);
        relationships36.setCardinalities(cardinalities312);
        em.persist(relationships36);
        em.flush();

        Relationships relationships37 = new Relationships();
        relationships37.setOptionality(true);
        relationships37.setIsEmbedded(false);
//      ...................... GroupIds ........................
        Entities entities313 = new Entities();
        entities313 = findBean.nameEntities("GroupIds",em);
        relationships37.setFrom(entities313);
//      ...................... DomainModels ........................
        Entities entities314 = new Entities();
        entities314 = findBean.nameEntities("DomainModels",em);
        relationships37.setTo(entities314);
//      ...................... *..1 ........................
        Cardinalities cardinalities315 = new Cardinalities();
        cardinalities315 = findBean.cardinalityCardinalities("*..1",em);
        relationships37.setCardinalities(cardinalities315);
        em.persist(relationships37);
        em.flush();

        Relationships relationships38 = new Relationships();
        relationships38.setOptionality(true);
        relationships38.setIsEmbedded(false);
//      ...................... DomainModels ........................
        Entities entities316 = new Entities();
        entities316 = findBean.nameEntities("DomainModels",em);
        relationships38.setFrom(entities316);
//      ...................... GroupIds ........................
        Entities entities317 = new Entities();
        entities317 = findBean.nameEntities("GroupIds",em);
        relationships38.setTo(entities317);
//      ...................... 1..* ........................
        Cardinalities cardinalities318 = new Cardinalities();
        cardinalities318 = findBean.cardinalityCardinalities("1..*",em);
        relationships38.setCardinalities(cardinalities318);
        em.persist(relationships38);
        em.flush();

        Relationships relationships39 = new Relationships();
        relationships39.setOptionality(true);
        relationships39.setIsEmbedded(false);
//      ...................... SystemsModels ........................
        Entities entities319 = new Entities();
        entities319 = findBean.nameEntities("SystemsModels",em);
        relationships39.setFrom(entities319);
//      ...................... DomainModels ........................
        Entities entities320 = new Entities();
        entities320 = findBean.nameEntities("DomainModels",em);
        relationships39.setTo(entities320);
//      ...................... 1..* ........................
        Cardinalities cardinalities321 = new Cardinalities();
        cardinalities321 = findBean.cardinalityCardinalities("1..*",em);
        relationships39.setCardinalities(cardinalities321);
        em.persist(relationships39);
        em.flush();

        Relationships relationships40 = new Relationships();
        relationships40.setOptionality(true);
        relationships40.setIsEmbedded(false);
//      ...................... FilesModels ........................
        Entities entities322 = new Entities();
        entities322 = findBean.nameEntities("FilesModels",em);
        relationships40.setFrom(entities322);
//      ...................... SystemsModels ........................
        Entities entities323 = new Entities();
        entities323 = findBean.nameEntities("SystemsModels",em);
        relationships40.setTo(entities323);
//      ...................... *..1 ........................
        Cardinalities cardinalities324 = new Cardinalities();
        cardinalities324 = findBean.cardinalityCardinalities("*..1",em);
        relationships40.setCardinalities(cardinalities324);
        em.persist(relationships40);
        em.flush();

        Relationships relationships41 = new Relationships();
        relationships41.setOptionality(true);
        relationships41.setIsEmbedded(false);
//      ...................... Entities ........................
        Entities entities325 = new Entities();
        entities325 = findBean.nameEntities("Entities",em);
        relationships41.setFrom(entities325);
//      ...................... GroupIds ........................
        Entities entities326 = new Entities();
        entities326 = findBean.nameEntities("GroupIds",em);
        relationships41.setTo(entities326);
//      ...................... *..1 ........................
        Cardinalities cardinalities327 = new Cardinalities();
        cardinalities327 = findBean.cardinalityCardinalities("*..1",em);
        relationships41.setCardinalities(cardinalities327);
        em.persist(relationships41);
        em.flush();

        Relationships relationships42 = new Relationships();
        relationships42.setOptionality(true);
        relationships42.setIsEmbedded(false);
//      ...................... GroupIds ........................
        Entities entities328 = new Entities();
        entities328 = findBean.nameEntities("GroupIds",em);
        relationships42.setFrom(entities328);
//      ...................... Entities ........................
        Entities entities329 = new Entities();
        entities329 = findBean.nameEntities("Entities",em);
        relationships42.setTo(entities329);
//      ...................... 1..* ........................
        Cardinalities cardinalities330 = new Cardinalities();
        cardinalities330 = findBean.cardinalityCardinalities("1..*",em);
        relationships42.setCardinalities(cardinalities330);
        em.persist(relationships42);
        em.flush();

        Relationships relationships43 = new Relationships();
        relationships43.setOptionality(true);
        relationships43.setIsEmbedded(false);
//      ...................... FilesModels ........................
        Entities entities331 = new Entities();
        entities331 = findBean.nameEntities("FilesModels",em);
        relationships43.setFrom(entities331);
//      ...................... DomainModels ........................
        Entities entities332 = new Entities();
        entities332 = findBean.nameEntities("DomainModels",em);
        relationships43.setTo(entities332);
//      ...................... *..1 ........................
        Cardinalities cardinalities333 = new Cardinalities();
        cardinalities333 = findBean.cardinalityCardinalities("*..1",em);
        relationships43.setCardinalities(cardinalities333);
        em.persist(relationships43);
        em.flush();

        Relationships relationships44 = new Relationships();
        relationships44.setOptionality(true);
        relationships44.setIsEmbedded(false);
//      ...................... DomainModels ........................
        Entities entities334 = new Entities();
        entities334 = findBean.nameEntities("DomainModels",em);
        relationships44.setFrom(entities334);
//      ...................... FilesModels ........................
        Entities entities335 = new Entities();
        entities335 = findBean.nameEntities("FilesModels",em);
        relationships44.setTo(entities335);
//      ...................... 1..* ........................
        Cardinalities cardinalities336 = new Cardinalities();
        cardinalities336 = findBean.cardinalityCardinalities("1..*",em);
        relationships44.setCardinalities(cardinalities336);
        em.persist(relationships44);
        em.flush();

        Relationships relationships45 = new Relationships();
        relationships45.setOptionality(true);
        relationships45.setIsEmbedded(false);
//      ...................... SystemsModels ........................
        Entities entities337 = new Entities();
        entities337 = findBean.nameEntities("SystemsModels",em);
        relationships45.setFrom(entities337);
//      ...................... FilesModels ........................
        Entities entities338 = new Entities();
        entities338 = findBean.nameEntities("FilesModels",em);
        relationships45.setTo(entities338);
//      ...................... 1..* ........................
        Cardinalities cardinalities339 = new Cardinalities();
        cardinalities339 = findBean.cardinalityCardinalities("1..*",em);
        relationships45.setCardinalities(cardinalities339);
        em.persist(relationships45);
        em.flush();

        Relationships relationships46 = new Relationships();
        relationships46.setOptionality(true);
        relationships46.setIsEmbedded(false);
//      ...................... DomainModels ........................
        Entities entities340 = new Entities();
        entities340 = findBean.nameEntities("DomainModels",em);
        relationships46.setFrom(entities340);
//      ...................... SystemsModels ........................
        Entities entities341 = new Entities();
        entities341 = findBean.nameEntities("SystemsModels",em);
        relationships46.setTo(entities341);
//      ...................... *..1 ........................
        Cardinalities cardinalities342 = new Cardinalities();
        cardinalities342 = findBean.cardinalityCardinalities("*..1",em);
        relationships46.setCardinalities(cardinalities342);
        em.persist(relationships46);
        em.flush();

    } // data()

} // SystemsModels
