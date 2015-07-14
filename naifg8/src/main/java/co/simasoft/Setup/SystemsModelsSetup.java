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
        entities2.setName("Imports");
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
//      ...................... Imports ........................
        Entities entity3 = new Entities();
        entity3 = findBean.nameEntities("Imports",em);
        attributes3.setEntities(entity3);
//      ...................... String ........................
        AttributesTypes attributesTypes4 = new AttributesTypes();
        attributesTypes4 = findBean.nameAttributesTypes("String",em);
        attributes3.setAttributesTypes(attributesTypes4);
        em.persist(attributes3);
        em.flush();

        Attributes attributes4 = new Attributes();
        attributes4.setName("observations");
        attributes4.setNullable(true);
        attributes4.setSingle(false);
//      ...................... Imports ........................
        Entities entity5 = new Entities();
        entity5 = findBean.nameEntities("Imports",em);
        attributes4.setEntities(entity5);
//      ...................... String ........................
        AttributesTypes attributesTypes6 = new AttributesTypes();
        attributesTypes6 = findBean.nameAttributesTypes("String",em);
        attributes4.setAttributesTypes(attributesTypes6);
        em.persist(attributes4);
        em.flush();

        Entities entities5 = new Entities();
        entities5.setName("AttributesProperties");
//      ...................... co.simasoft.models.naif.domainmodels.dependencies ........................
        GroupIds groupId7 = new GroupIds();
        groupId7 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels.dependencies",em);
        entities5.setGroupIds(groupId7);
        em.persist(entities5);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes6 = new Attributes();
        attributes6.setName("name");
        attributes6.setNullable(false);
        attributes6.setSingle(true);
//      ...................... AttributesProperties ........................
        Entities entity8 = new Entities();
        entity8 = findBean.nameEntities("AttributesProperties",em);
        attributes6.setEntities(entity8);
//      ...................... String ........................
        AttributesTypes attributesTypes9 = new AttributesTypes();
        attributesTypes9 = findBean.nameAttributesTypes("String",em);
        attributes6.setAttributesTypes(attributesTypes9);
        em.persist(attributes6);
        em.flush();

        Attributes attributes7 = new Attributes();
        attributes7.setName("value");
        attributes7.setNullable(false);
        attributes7.setSingle(true);
//      ...................... AttributesProperties ........................
        Entities entity10 = new Entities();
        entity10 = findBean.nameEntities("AttributesProperties",em);
        attributes7.setEntities(entity10);
//      ...................... String ........................
        AttributesTypes attributesTypes11 = new AttributesTypes();
        attributesTypes11 = findBean.nameAttributesTypes("String",em);
        attributes7.setAttributesTypes(attributesTypes11);
        em.persist(attributes7);
        em.flush();

        Attributes attributes8 = new Attributes();
        attributes8.setName("observations");
        attributes8.setNullable(true);
        attributes8.setSingle(false);
//      ...................... AttributesProperties ........................
        Entities entity12 = new Entities();
        entity12 = findBean.nameEntities("AttributesProperties",em);
        attributes8.setEntities(entity12);
//      ...................... String ........................
        AttributesTypes attributesTypes13 = new AttributesTypes();
        attributesTypes13 = findBean.nameAttributesTypes("String",em);
        attributes8.setAttributesTypes(attributesTypes13);
        em.persist(attributes8);
        em.flush();

        Entities entities9 = new Entities();
        entities9.setName("AttributesTypes");
//      ...................... co.simasoft.models.naif.domainmodels.dependencies ........................
        GroupIds groupId14 = new GroupIds();
        groupId14 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels.dependencies",em);
        entities9.setGroupIds(groupId14);
        em.persist(entities9);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes10 = new Attributes();
        attributes10.setName("name");
        attributes10.setNullable(false);
        attributes10.setSingle(true);
//      ...................... AttributesTypes ........................
        Entities entity15 = new Entities();
        entity15 = findBean.nameEntities("AttributesTypes",em);
        attributes10.setEntities(entity15);
//      ...................... String ........................
        AttributesTypes attributesTypes16 = new AttributesTypes();
        attributesTypes16 = findBean.nameAttributesTypes("String",em);
        attributes10.setAttributesTypes(attributesTypes16);
        em.persist(attributes10);
        em.flush();

        Attributes attributes11 = new Attributes();
        attributes11.setName("type");
        attributes11.setNullable(false);
        attributes11.setSingle(false);
//      ...................... AttributesTypes ........................
        Entities entity17 = new Entities();
        entity17 = findBean.nameEntities("AttributesTypes",em);
        attributes11.setEntities(entity17);
//      ...................... String ........................
        AttributesTypes attributesTypes18 = new AttributesTypes();
        attributesTypes18 = findBean.nameAttributesTypes("String",em);
        attributes11.setAttributesTypes(attributesTypes18);
        em.persist(attributes11);
        em.flush();

        Attributes attributes12 = new Attributes();
        attributes12.setName("length");
        attributes12.setNullable(true);
        attributes12.setSingle(false);
//      ...................... AttributesTypes ........................
        Entities entity19 = new Entities();
        entity19 = findBean.nameEntities("AttributesTypes",em);
        attributes12.setEntities(entity19);
//      ...................... Integer ........................
        AttributesTypes attributesTypes20 = new AttributesTypes();
        attributesTypes20 = findBean.nameAttributesTypes("Integer",em);
        attributes12.setAttributesTypes(attributesTypes20);
        em.persist(attributes12);
        em.flush();

        Attributes attributes13 = new Attributes();
        attributes13.setName("precision");
        attributes13.setNullable(true);
        attributes13.setSingle(false);
//      ...................... AttributesTypes ........................
        Entities entity21 = new Entities();
        entity21 = findBean.nameEntities("AttributesTypes",em);
        attributes13.setEntities(entity21);
//      ...................... Integer ........................
        AttributesTypes attributesTypes22 = new AttributesTypes();
        attributesTypes22 = findBean.nameAttributesTypes("Integer",em);
        attributes13.setAttributesTypes(attributesTypes22);
        em.persist(attributes13);
        em.flush();

        Attributes attributes14 = new Attributes();
        attributes14.setName("annotations");
        attributes14.setNullable(true);
        attributes14.setSingle(false);
//      ...................... AttributesTypes ........................
        Entities entity23 = new Entities();
        entity23 = findBean.nameEntities("AttributesTypes",em);
        attributes14.setEntities(entity23);
//      ...................... String ........................
        AttributesTypes attributesTypes24 = new AttributesTypes();
        attributesTypes24 = findBean.nameAttributesTypes("String",em);
        attributes14.setAttributesTypes(attributesTypes24);
        em.persist(attributes14);
        em.flush();

        Attributes attributes15 = new Attributes();
        attributes15.setName("observations");
        attributes15.setNullable(true);
        attributes15.setSingle(false);
//      ...................... AttributesTypes ........................
        Entities entity25 = new Entities();
        entity25 = findBean.nameEntities("AttributesTypes",em);
        attributes15.setEntities(entity25);
//      ...................... String ........................
        AttributesTypes attributesTypes26 = new AttributesTypes();
        attributesTypes26 = findBean.nameAttributesTypes("String",em);
        attributes15.setAttributesTypes(attributesTypes26);
        em.persist(attributes15);
        em.flush();

        Entities entities16 = new Entities();
        entities16.setName("Dependency");
//      ...................... co.simasoft.models.naif.domainmodels.dependencies ........................
        GroupIds groupId27 = new GroupIds();
        groupId27 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels.dependencies",em);
        entities16.setGroupIds(groupId27);
        em.persist(entities16);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes17 = new Attributes();
        attributes17.setName("groupId");
        attributes17.setNullable(false);
        attributes17.setSingle(false);
//      ...................... Dependency ........................
        Entities entity28 = new Entities();
        entity28 = findBean.nameEntities("Dependency",em);
        attributes17.setEntities(entity28);
//      ...................... String ........................
        AttributesTypes attributesTypes29 = new AttributesTypes();
        attributesTypes29 = findBean.nameAttributesTypes("String",em);
        attributes17.setAttributesTypes(attributesTypes29);
        em.persist(attributes17);
        em.flush();

        Attributes attributes18 = new Attributes();
        attributes18.setName("artifactId");
        attributes18.setNullable(false);
        attributes18.setSingle(false);
//      ...................... Dependency ........................
        Entities entity30 = new Entities();
        entity30 = findBean.nameEntities("Dependency",em);
        attributes18.setEntities(entity30);
//      ...................... String ........................
        AttributesTypes attributesTypes31 = new AttributesTypes();
        attributesTypes31 = findBean.nameAttributesTypes("String",em);
        attributes18.setAttributesTypes(attributesTypes31);
        em.persist(attributes18);
        em.flush();

        Attributes attributes19 = new Attributes();
        attributes19.setName("version");
        attributes19.setNullable(true);
        attributes19.setSingle(false);
//      ...................... Dependency ........................
        Entities entity32 = new Entities();
        entity32 = findBean.nameEntities("Dependency",em);
        attributes19.setEntities(entity32);
//      ...................... String ........................
        AttributesTypes attributesTypes33 = new AttributesTypes();
        attributesTypes33 = findBean.nameAttributesTypes("String",em);
        attributes19.setAttributesTypes(attributesTypes33);
        em.persist(attributes19);
        em.flush();

        Attributes attributes20 = new Attributes();
        attributes20.setName("type");
        attributes20.setNullable(true);
        attributes20.setSingle(false);
//      ...................... Dependency ........................
        Entities entity34 = new Entities();
        entity34 = findBean.nameEntities("Dependency",em);
        attributes20.setEntities(entity34);
//      ...................... String ........................
        AttributesTypes attributesTypes35 = new AttributesTypes();
        attributesTypes35 = findBean.nameAttributesTypes("String",em);
        attributes20.setAttributesTypes(attributesTypes35);
        em.persist(attributes20);
        em.flush();

        Attributes attributes21 = new Attributes();
        attributes21.setName("scope");
        attributes21.setNullable(true);
        attributes21.setSingle(false);
//      ...................... Dependency ........................
        Entities entity36 = new Entities();
        entity36 = findBean.nameEntities("Dependency",em);
        attributes21.setEntities(entity36);
//      ...................... String ........................
        AttributesTypes attributesTypes37 = new AttributesTypes();
        attributesTypes37 = findBean.nameAttributesTypes("String",em);
        attributes21.setAttributesTypes(attributesTypes37);
        em.persist(attributes21);
        em.flush();

        Attributes attributes22 = new Attributes();
        attributes22.setName("maven");
        attributes22.setNullable(false);
        attributes22.setSingle(true);
//      ...................... Dependency ........................
        Entities entity38 = new Entities();
        entity38 = findBean.nameEntities("Dependency",em);
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
//      ...................... Dependency ........................
        Entities entity40 = new Entities();
        entity40 = findBean.nameEntities("Dependency",em);
        attributes23.setEntities(entity40);
//      ...................... String ........................
        AttributesTypes attributesTypes41 = new AttributesTypes();
        attributesTypes41 = findBean.nameAttributesTypes("String",em);
        attributes23.setAttributesTypes(attributesTypes41);
        em.persist(attributes23);
        em.flush();

        GroupIds groupIds24 = new GroupIds();
        groupIds24.setGroupId("co.simasoft.models.naif.domainmodels.modelsFiles");
//      ...................... SystemsModels ........................
        DomainModels domainModel42 = new DomainModels();
        domainModel42 = findBean.artifactIdDomainModels("SystemsModels",em);
        groupIds24.setDomainModels(domainModel42);
        em.persist(groupIds24);
        em.flush();

//      ---------------------- Entities ------------------------

        Entities entities25 = new Entities();
        entities25.setName("FilesModels");
//      ...................... co.simasoft.models.naif.domainmodels.modelsFiles ........................
        GroupIds groupId43 = new GroupIds();
        groupId43 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels.modelsFiles",em);
        entities25.setGroupIds(groupId43);
        em.persist(entities25);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes26 = new Attributes();
        attributes26.setName("name");
        attributes26.setNullable(false);
        attributes26.setSingle(true);
//      ...................... FilesModels ........................
        Entities entity44 = new Entities();
        entity44 = findBean.nameEntities("FilesModels",em);
        attributes26.setEntities(entity44);
//      ...................... String ........................
        AttributesTypes attributesTypes45 = new AttributesTypes();
        attributesTypes45 = findBean.nameAttributesTypes("String",em);
        attributes26.setAttributesTypes(attributesTypes45);
        em.persist(attributes26);
        em.flush();

        Attributes attributes27 = new Attributes();
        attributes27.setName("extension");
        attributes27.setNullable(false);
        attributes27.setSingle(false);
//      ...................... FilesModels ........................
        Entities entity46 = new Entities();
        entity46 = findBean.nameEntities("FilesModels",em);
        attributes27.setEntities(entity46);
//      ...................... String ........................
        AttributesTypes attributesTypes47 = new AttributesTypes();
        attributesTypes47 = findBean.nameAttributesTypes("String",em);
        attributes27.setAttributesTypes(attributesTypes47);
        em.persist(attributes27);
        em.flush();

        Attributes attributes28 = new Attributes();
        attributes28.setName("date");
        attributes28.setNullable(false);
        attributes28.setSingle(false);
//      ...................... FilesModels ........................
        Entities entity48 = new Entities();
        entity48 = findBean.nameEntities("FilesModels",em);
        attributes28.setEntities(entity48);
//      ...................... Date ........................
        AttributesTypes attributesTypes49 = new AttributesTypes();
        attributesTypes49 = findBean.nameAttributesTypes("Date",em);
        attributes28.setAttributesTypes(attributesTypes49);
        em.persist(attributes28);
        em.flush();

        Attributes attributes29 = new Attributes();
        attributes29.setName("url");
        attributes29.setNullable(false);
        attributes29.setSingle(false);
//      ...................... FilesModels ........................
        Entities entity50 = new Entities();
        entity50 = findBean.nameEntities("FilesModels",em);
        attributes29.setEntities(entity50);
//      ...................... String ........................
        AttributesTypes attributesTypes51 = new AttributesTypes();
        attributesTypes51 = findBean.nameAttributesTypes("String",em);
        attributes29.setAttributesTypes(attributesTypes51);
        em.persist(attributes29);
        em.flush();

        Attributes attributes30 = new Attributes();
        attributes30.setName("data");
        attributes30.setNullable(true);
        attributes30.setSingle(false);
//      ...................... FilesModels ........................
        Entities entity52 = new Entities();
        entity52 = findBean.nameEntities("FilesModels",em);
        attributes30.setEntities(entity52);
//      ...................... byte ........................
        AttributesTypes attributesTypes53 = new AttributesTypes();
        attributesTypes53 = findBean.nameAttributesTypes("byte",em);
        attributes30.setAttributesTypes(attributesTypes53);
        em.persist(attributes30);
        em.flush();

        Attributes attributes31 = new Attributes();
        attributes31.setName("observations");
        attributes31.setNullable(true);
        attributes31.setSingle(false);
//      ...................... FilesModels ........................
        Entities entity54 = new Entities();
        entity54 = findBean.nameEntities("FilesModels",em);
        attributes31.setEntities(entity54);
//      ...................... String ........................
        AttributesTypes attributesTypes55 = new AttributesTypes();
        attributesTypes55 = findBean.nameAttributesTypes("String",em);
        attributes31.setAttributesTypes(attributesTypes55);
        em.persist(attributes31);
        em.flush();

        GroupIds groupIds32 = new GroupIds();
        groupIds32.setGroupId("co.simasoft.models.naif.domainmodels.systemsModels");
//      ...................... SystemsModels ........................
        DomainModels domainModel56 = new DomainModels();
        domainModel56 = findBean.artifactIdDomainModels("SystemsModels",em);
        groupIds32.setDomainModels(domainModel56);
        em.persist(groupIds32);
        em.flush();

//      ---------------------- Entities ------------------------

        Entities entities33 = new Entities();
        entities33.setName("GroupIds");
//      ...................... co.simasoft.models.naif.domainmodels.systemsModels ........................
        GroupIds groupId57 = new GroupIds();
        groupId57 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels.systemsModels",em);
        entities33.setGroupIds(groupId57);
        em.persist(entities33);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes34 = new Attributes();
        attributes34.setName("name");
        attributes34.setNullable(true);
        attributes34.setSingle(false);
//      ...................... GroupIds ........................
        Entities entity58 = new Entities();
        entity58 = findBean.nameEntities("GroupIds",em);
        attributes34.setEntities(entity58);
//      ...................... String ........................
        AttributesTypes attributesTypes59 = new AttributesTypes();
        attributesTypes59 = findBean.nameAttributesTypes("String",em);
        attributes34.setAttributesTypes(attributesTypes59);
        em.persist(attributes34);
        em.flush();

        Attributes attributes35 = new Attributes();
        attributes35.setName("groupId");
        attributes35.setNullable(false);
        attributes35.setSingle(false);
//      ...................... GroupIds ........................
        Entities entity60 = new Entities();
        entity60 = findBean.nameEntities("GroupIds",em);
        attributes35.setEntities(entity60);
//      ...................... String ........................
        AttributesTypes attributesTypes61 = new AttributesTypes();
        attributesTypes61 = findBean.nameAttributesTypes("String",em);
        attributes35.setAttributesTypes(attributesTypes61);
        em.persist(attributes35);
        em.flush();

        Attributes attributes36 = new Attributes();
        attributes36.setName("artifactId");
        attributes36.setNullable(true);
        attributes36.setSingle(true);
//      ...................... GroupIds ........................
        Entities entity62 = new Entities();
        entity62 = findBean.nameEntities("GroupIds",em);
        attributes36.setEntities(entity62);
//      ...................... String ........................
        AttributesTypes attributesTypes63 = new AttributesTypes();
        attributesTypes63 = findBean.nameAttributesTypes("String",em);
        attributes36.setAttributesTypes(attributesTypes63);
        em.persist(attributes36);
        em.flush();

        Attributes attributes37 = new Attributes();
        attributes37.setName("version");
        attributes37.setNullable(true);
        attributes37.setSingle(false);
//      ...................... GroupIds ........................
        Entities entity64 = new Entities();
        entity64 = findBean.nameEntities("GroupIds",em);
        attributes37.setEntities(entity64);
//      ...................... String ........................
        AttributesTypes attributesTypes65 = new AttributesTypes();
        attributesTypes65 = findBean.nameAttributesTypes("String",em);
        attributes37.setAttributesTypes(attributesTypes65);
        em.persist(attributes37);
        em.flush();

        Attributes attributes38 = new Attributes();
        attributes38.setName("code");
        attributes38.setNullable(true);
        attributes38.setSingle(true);
//      ...................... GroupIds ........................
        Entities entity66 = new Entities();
        entity66 = findBean.nameEntities("GroupIds",em);
        attributes38.setEntities(entity66);
//      ...................... String ........................
        AttributesTypes attributesTypes67 = new AttributesTypes();
        attributesTypes67 = findBean.nameAttributesTypes("String",em);
        attributes38.setAttributesTypes(attributesTypes67);
        em.persist(attributes38);
        em.flush();

        Attributes attributes39 = new Attributes();
        attributes39.setName("date");
        attributes39.setNullable(true);
        attributes39.setSingle(false);
//      ...................... GroupIds ........................
        Entities entity68 = new Entities();
        entity68 = findBean.nameEntities("GroupIds",em);
        attributes39.setEntities(entity68);
//      ...................... Date ........................
        AttributesTypes attributesTypes69 = new AttributesTypes();
        attributesTypes69 = findBean.nameAttributesTypes("Date",em);
        attributes39.setAttributesTypes(attributesTypes69);
        em.persist(attributes39);
        em.flush();

        Attributes attributes40 = new Attributes();
        attributes40.setName("description");
        attributes40.setNullable(true);
        attributes40.setSingle(false);
//      ...................... GroupIds ........................
        Entities entity70 = new Entities();
        entity70 = findBean.nameEntities("GroupIds",em);
        attributes40.setEntities(entity70);
//      ...................... String ........................
        AttributesTypes attributesTypes71 = new AttributesTypes();
        attributesTypes71 = findBean.nameAttributesTypes("String",em);
        attributes40.setAttributesTypes(attributesTypes71);
        em.persist(attributes40);
        em.flush();

        Attributes attributes41 = new Attributes();
        attributes41.setName("observations");
        attributes41.setNullable(true);
        attributes41.setSingle(false);
//      ...................... GroupIds ........................
        Entities entity72 = new Entities();
        entity72 = findBean.nameEntities("GroupIds",em);
        attributes41.setEntities(entity72);
//      ...................... String ........................
        AttributesTypes attributesTypes73 = new AttributesTypes();
        attributesTypes73 = findBean.nameAttributesTypes("String",em);
        attributes41.setAttributesTypes(attributesTypes73);
        em.persist(attributes41);
        em.flush();

        Entities entities42 = new Entities();
        entities42.setName("SystemsModels");
//      ...................... co.simasoft.models.naif.domainmodels.systemsModels ........................
        GroupIds groupId74 = new GroupIds();
        groupId74 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels.systemsModels",em);
        entities42.setGroupIds(groupId74);
        em.persist(entities42);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes43 = new Attributes();
        attributes43.setName("name");
        attributes43.setNullable(false);
        attributes43.setSingle(true);
//      ...................... SystemsModels ........................
        Entities entity75 = new Entities();
        entity75 = findBean.nameEntities("SystemsModels",em);
        attributes43.setEntities(entity75);
//      ...................... String ........................
        AttributesTypes attributesTypes76 = new AttributesTypes();
        attributesTypes76 = findBean.nameAttributesTypes("String",em);
        attributes43.setAttributesTypes(attributesTypes76);
        em.persist(attributes43);
        em.flush();

        Attributes attributes44 = new Attributes();
        attributes44.setName("description");
        attributes44.setNullable(true);
        attributes44.setSingle(false);
//      ...................... SystemsModels ........................
        Entities entity77 = new Entities();
        entity77 = findBean.nameEntities("SystemsModels",em);
        attributes44.setEntities(entity77);
//      ...................... String ........................
        AttributesTypes attributesTypes78 = new AttributesTypes();
        attributesTypes78 = findBean.nameAttributesTypes("String",em);
        attributes44.setAttributesTypes(attributesTypes78);
        em.persist(attributes44);
        em.flush();

        Attributes attributes45 = new Attributes();
        attributes45.setName("observations");
        attributes45.setNullable(true);
        attributes45.setSingle(false);
//      ...................... SystemsModels ........................
        Entities entity79 = new Entities();
        entity79 = findBean.nameEntities("SystemsModels",em);
        attributes45.setEntities(entity79);
//      ...................... String ........................
        AttributesTypes attributesTypes80 = new AttributesTypes();
        attributesTypes80 = findBean.nameAttributesTypes("String",em);
        attributes45.setAttributesTypes(attributesTypes80);
        em.persist(attributes45);
        em.flush();

        Entities entities46 = new Entities();
        entities46.setName("DomainModels");
//      ...................... co.simasoft.models.naif.domainmodels.systemsModels ........................
        GroupIds groupId81 = new GroupIds();
        groupId81 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels.systemsModels",em);
        entities46.setGroupIds(groupId81);
        em.persist(entities46);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes47 = new Attributes();
        attributes47.setName("name");
        attributes47.setNullable(true);
        attributes47.setSingle(false);
//      ...................... DomainModels ........................
        Entities entity82 = new Entities();
        entity82 = findBean.nameEntities("DomainModels",em);
        attributes47.setEntities(entity82);
//      ...................... String ........................
        AttributesTypes attributesTypes83 = new AttributesTypes();
        attributesTypes83 = findBean.nameAttributesTypes("String",em);
        attributes47.setAttributesTypes(attributesTypes83);
        em.persist(attributes47);
        em.flush();

        Attributes attributes48 = new Attributes();
        attributes48.setName("groupId");
        attributes48.setNullable(false);
        attributes48.setSingle(false);
//      ...................... DomainModels ........................
        Entities entity84 = new Entities();
        entity84 = findBean.nameEntities("DomainModels",em);
        attributes48.setEntities(entity84);
//      ...................... String ........................
        AttributesTypes attributesTypes85 = new AttributesTypes();
        attributesTypes85 = findBean.nameAttributesTypes("String",em);
        attributes48.setAttributesTypes(attributesTypes85);
        em.persist(attributes48);
        em.flush();

        Attributes attributes49 = new Attributes();
        attributes49.setName("artifactId");
        attributes49.setNullable(false);
        attributes49.setSingle(true);
//      ...................... DomainModels ........................
        Entities entity86 = new Entities();
        entity86 = findBean.nameEntities("DomainModels",em);
        attributes49.setEntities(entity86);
//      ...................... String ........................
        AttributesTypes attributesTypes87 = new AttributesTypes();
        attributesTypes87 = findBean.nameAttributesTypes("String",em);
        attributes49.setAttributesTypes(attributesTypes87);
        em.persist(attributes49);
        em.flush();

        Attributes attributes50 = new Attributes();
        attributes50.setName("version");
        attributes50.setNullable(false);
        attributes50.setSingle(false);
//      ...................... DomainModels ........................
        Entities entity88 = new Entities();
        entity88 = findBean.nameEntities("DomainModels",em);
        attributes50.setEntities(entity88);
//      ...................... String ........................
        AttributesTypes attributesTypes89 = new AttributesTypes();
        attributesTypes89 = findBean.nameAttributesTypes("String",em);
        attributes50.setAttributesTypes(attributesTypes89);
        em.persist(attributes50);
        em.flush();

        Attributes attributes51 = new Attributes();
        attributes51.setName("code");
        attributes51.setNullable(true);
        attributes51.setSingle(true);
//      ...................... DomainModels ........................
        Entities entity90 = new Entities();
        entity90 = findBean.nameEntities("DomainModels",em);
        attributes51.setEntities(entity90);
//      ...................... String ........................
        AttributesTypes attributesTypes91 = new AttributesTypes();
        attributesTypes91 = findBean.nameAttributesTypes("String",em);
        attributes51.setAttributesTypes(attributesTypes91);
        em.persist(attributes51);
        em.flush();

        Attributes attributes52 = new Attributes();
        attributes52.setName("date");
        attributes52.setNullable(true);
        attributes52.setSingle(false);
//      ...................... DomainModels ........................
        Entities entity92 = new Entities();
        entity92 = findBean.nameEntities("DomainModels",em);
        attributes52.setEntities(entity92);
//      ...................... Date ........................
        AttributesTypes attributesTypes93 = new AttributesTypes();
        attributesTypes93 = findBean.nameAttributesTypes("Date",em);
        attributes52.setAttributesTypes(attributesTypes93);
        em.persist(attributes52);
        em.flush();

        Attributes attributes53 = new Attributes();
        attributes53.setName("description");
        attributes53.setNullable(true);
        attributes53.setSingle(false);
//      ...................... DomainModels ........................
        Entities entity94 = new Entities();
        entity94 = findBean.nameEntities("DomainModels",em);
        attributes53.setEntities(entity94);
//      ...................... String ........................
        AttributesTypes attributesTypes95 = new AttributesTypes();
        attributesTypes95 = findBean.nameAttributesTypes("String",em);
        attributes53.setAttributesTypes(attributesTypes95);
        em.persist(attributes53);
        em.flush();

        Attributes attributes54 = new Attributes();
        attributes54.setName("observations");
        attributes54.setNullable(true);
        attributes54.setSingle(false);
//      ...................... DomainModels ........................
        Entities entity96 = new Entities();
        entity96 = findBean.nameEntities("DomainModels",em);
        attributes54.setEntities(entity96);
//      ...................... String ........................
        AttributesTypes attributesTypes97 = new AttributesTypes();
        attributesTypes97 = findBean.nameAttributesTypes("String",em);
        attributes54.setAttributesTypes(attributesTypes97);
        em.persist(attributes54);
        em.flush();

        GroupIds groupIds55 = new GroupIds();
        groupIds55.setGroupId("co.simasoft.models.naif.domainmodels.entities");
//      ...................... SystemsModels ........................
        DomainModels domainModel98 = new DomainModels();
        domainModel98 = findBean.artifactIdDomainModels("SystemsModels",em);
        groupIds55.setDomainModels(domainModel98);
        em.persist(groupIds55);
        em.flush();

//      ---------------------- Entities ------------------------

        Entities entities56 = new Entities();
        entities56.setName("Entities");
//      ...................... co.simasoft.models.naif.domainmodels.entities ........................
        GroupIds groupId99 = new GroupIds();
        groupId99 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels.entities",em);
        entities56.setGroupIds(groupId99);
        em.persist(entities56);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes57 = new Attributes();
        attributes57.setName("name");
        attributes57.setNullable(false);
        attributes57.setSingle(false);
//      ...................... Entities ........................
        Entities entity100 = new Entities();
        entity100 = findBean.nameEntities("Entities",em);
        attributes57.setEntities(entity100);
//      ...................... String ........................
        AttributesTypes attributesTypes101 = new AttributesTypes();
        attributesTypes101 = findBean.nameAttributesTypes("String",em);
        attributes57.setAttributesTypes(attributesTypes101);
        em.persist(attributes57);
        em.flush();

        Attributes attributes58 = new Attributes();
        attributes58.setName("serialID");
        attributes58.setNullable(true);
        attributes58.setSingle(true);
//      ...................... Entities ........................
        Entities entity102 = new Entities();
        entity102 = findBean.nameEntities("Entities",em);
        attributes58.setEntities(entity102);
//      ...................... String ........................
        AttributesTypes attributesTypes103 = new AttributesTypes();
        attributesTypes103 = findBean.nameAttributesTypes("String",em);
        attributes58.setAttributesTypes(attributesTypes103);
        em.persist(attributes58);
        em.flush();

        Attributes attributes59 = new Attributes();
        attributes59.setName("table");
        attributes59.setNullable(true);
        attributes59.setSingle(false);
//      ...................... Entities ........................
        Entities entity104 = new Entities();
        entity104 = findBean.nameEntities("Entities",em);
        attributes59.setEntities(entity104);
//      ...................... String ........................
        AttributesTypes attributesTypes105 = new AttributesTypes();
        attributesTypes105 = findBean.nameAttributesTypes("String",em);
        attributes59.setAttributesTypes(attributesTypes105);
        em.persist(attributes59);
        em.flush();

        Attributes attributes60 = new Attributes();
        attributes60.setName("tableSecuencia");
        attributes60.setNullable(true);
        attributes60.setSingle(false);
//      ...................... Entities ........................
        Entities entity106 = new Entities();
        entity106 = findBean.nameEntities("Entities",em);
        attributes60.setEntities(entity106);
//      ...................... String ........................
        AttributesTypes attributesTypes107 = new AttributesTypes();
        attributesTypes107 = findBean.nameAttributesTypes("String",em);
        attributes60.setAttributesTypes(attributesTypes107);
        em.persist(attributes60);
        em.flush();

        Attributes attributes61 = new Attributes();
        attributes61.setName("modifier");
        attributes61.setNullable(true);
        attributes61.setSingle(false);
//      ...................... Entities ........................
        Entities entity108 = new Entities();
        entity108 = findBean.nameEntities("Entities",em);
        attributes61.setEntities(entity108);
//      ...................... String ........................
        AttributesTypes attributesTypes109 = new AttributesTypes();
        attributesTypes109 = findBean.nameAttributesTypes("String",em);
        attributes61.setAttributesTypes(attributesTypes109);
        em.persist(attributes61);
        em.flush();

        Attributes attributes62 = new Attributes();
        attributes62.setName("extend");
        attributes62.setNullable(true);
        attributes62.setSingle(false);
//      ...................... Entities ........................
        Entities entity110 = new Entities();
        entity110 = findBean.nameEntities("Entities",em);
        attributes62.setEntities(entity110);
//      ...................... String ........................
        AttributesTypes attributesTypes111 = new AttributesTypes();
        attributesTypes111 = findBean.nameAttributesTypes("String",em);
        attributes62.setAttributesTypes(attributesTypes111);
        em.persist(attributes62);
        em.flush();

        Attributes attributes63 = new Attributes();
        attributes63.setName("annotations");
        attributes63.setNullable(true);
        attributes63.setSingle(false);
//      ...................... Entities ........................
        Entities entity112 = new Entities();
        entity112 = findBean.nameEntities("Entities",em);
        attributes63.setEntities(entity112);
//      ...................... String ........................
        AttributesTypes attributesTypes113 = new AttributesTypes();
        attributesTypes113 = findBean.nameAttributesTypes("String",em);
        attributes63.setAttributesTypes(attributesTypes113);
        em.persist(attributes63);
        em.flush();

        Attributes attributes64 = new Attributes();
        attributes64.setName("source");
        attributes64.setNullable(true);
        attributes64.setSingle(false);
//      ...................... Entities ........................
        Entities entity114 = new Entities();
        entity114 = findBean.nameEntities("Entities",em);
        attributes64.setEntities(entity114);
//      ...................... String ........................
        AttributesTypes attributesTypes115 = new AttributesTypes();
        attributesTypes115 = findBean.nameAttributesTypes("String",em);
        attributes64.setAttributesTypes(attributesTypes115);
        em.persist(attributes64);
        em.flush();

        Attributes attributes65 = new Attributes();
        attributes65.setName("description");
        attributes65.setNullable(true);
        attributes65.setSingle(false);
//      ...................... Entities ........................
        Entities entity116 = new Entities();
        entity116 = findBean.nameEntities("Entities",em);
        attributes65.setEntities(entity116);
//      ...................... String ........................
        AttributesTypes attributesTypes117 = new AttributesTypes();
        attributesTypes117 = findBean.nameAttributesTypes("String",em);
        attributes65.setAttributesTypes(attributesTypes117);
        em.persist(attributes65);
        em.flush();

        Attributes attributes66 = new Attributes();
        attributes66.setName("observations");
        attributes66.setNullable(true);
        attributes66.setSingle(false);
//      ...................... Entities ........................
        Entities entity118 = new Entities();
        entity118 = findBean.nameEntities("Entities",em);
        attributes66.setEntities(entity118);
//      ...................... String ........................
        AttributesTypes attributesTypes119 = new AttributesTypes();
        attributesTypes119 = findBean.nameAttributesTypes("String",em);
        attributes66.setAttributesTypes(attributesTypes119);
        em.persist(attributes66);
        em.flush();

        Entities entities67 = new Entities();
        entities67.setName("Relationships");
//      ...................... co.simasoft.models.naif.domainmodels.entities ........................
        GroupIds groupId120 = new GroupIds();
        groupId120 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels.entities",em);
        entities67.setGroupIds(groupId120);
        em.persist(entities67);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes68 = new Attributes();
        attributes68.setName("name");
        attributes68.setNullable(true);
        attributes68.setSingle(false);
//      ...................... Relationships ........................
        Entities entity121 = new Entities();
        entity121 = findBean.nameEntities("Relationships",em);
        attributes68.setEntities(entity121);
//      ...................... String ........................
        AttributesTypes attributesTypes122 = new AttributesTypes();
        attributesTypes122 = findBean.nameAttributesTypes("String",em);
        attributes68.setAttributesTypes(attributesTypes122);
        em.persist(attributes68);
        em.flush();

        Attributes attributes69 = new Attributes();
        attributes69.setName("optionality");
        attributes69.setNullable(true);
        attributes69.setSingle(false);
//      ...................... Relationships ........................
        Entities entity123 = new Entities();
        entity123 = findBean.nameEntities("Relationships",em);
        attributes69.setEntities(entity123);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes124 = new AttributesTypes();
        attributesTypes124 = findBean.nameAttributesTypes("Boolean",em);
        attributes69.setAttributesTypes(attributesTypes124);
        em.persist(attributes69);
        em.flush();

        Attributes attributes70 = new Attributes();
        attributes70.setName("isEmbedded");
        attributes70.setNullable(true);
        attributes70.setSingle(false);
//      ...................... Relationships ........................
        Entities entity125 = new Entities();
        entity125 = findBean.nameEntities("Relationships",em);
        attributes70.setEntities(entity125);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes126 = new AttributesTypes();
        attributesTypes126 = findBean.nameAttributesTypes("Boolean",em);
        attributes70.setAttributesTypes(attributesTypes126);
        em.persist(attributes70);
        em.flush();

        Attributes attributes71 = new Attributes();
        attributes71.setName("observations");
        attributes71.setNullable(true);
        attributes71.setSingle(false);
//      ...................... Relationships ........................
        Entities entity127 = new Entities();
        entity127 = findBean.nameEntities("Relationships",em);
        attributes71.setEntities(entity127);
//      ...................... String ........................
        AttributesTypes attributesTypes128 = new AttributesTypes();
        attributesTypes128 = findBean.nameAttributesTypes("String",em);
        attributes71.setAttributesTypes(attributesTypes128);
        em.persist(attributes71);
        em.flush();

        Entities entities72 = new Entities();
        entities72.setName("NameQueries");
//      ...................... co.simasoft.models.naif.domainmodels.entities ........................
        GroupIds groupId129 = new GroupIds();
        groupId129 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels.entities",em);
        entities72.setGroupIds(groupId129);
        em.persist(entities72);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes73 = new Attributes();
        attributes73.setName("name");
        attributes73.setNullable(false);
        attributes73.setSingle(true);
//      ...................... NameQueries ........................
        Entities entity130 = new Entities();
        entity130 = findBean.nameEntities("NameQueries",em);
        attributes73.setEntities(entity130);
//      ...................... String ........................
        AttributesTypes attributesTypes131 = new AttributesTypes();
        attributesTypes131 = findBean.nameAttributesTypes("String",em);
        attributes73.setAttributesTypes(attributesTypes131);
        em.persist(attributes73);
        em.flush();

        Attributes attributes74 = new Attributes();
        attributes74.setName("query");
        attributes74.setNullable(false);
        attributes74.setSingle(true);
//      ...................... NameQueries ........................
        Entities entity132 = new Entities();
        entity132 = findBean.nameEntities("NameQueries",em);
        attributes74.setEntities(entity132);
//      ...................... String ........................
        AttributesTypes attributesTypes133 = new AttributesTypes();
        attributesTypes133 = findBean.nameAttributesTypes("String",em);
        attributes74.setAttributesTypes(attributesTypes133);
        em.persist(attributes74);
        em.flush();

        Attributes attributes75 = new Attributes();
        attributes75.setName("observations");
        attributes75.setNullable(true);
        attributes75.setSingle(false);
//      ...................... NameQueries ........................
        Entities entity134 = new Entities();
        entity134 = findBean.nameEntities("NameQueries",em);
        attributes75.setEntities(entity134);
//      ...................... String ........................
        AttributesTypes attributesTypes135 = new AttributesTypes();
        attributesTypes135 = findBean.nameAttributesTypes("String",em);
        attributes75.setAttributesTypes(attributesTypes135);
        em.persist(attributes75);
        em.flush();

        Entities entities76 = new Entities();
        entities76.setName("Attributes");
//      ...................... co.simasoft.models.naif.domainmodels.entities ........................
        GroupIds groupId136 = new GroupIds();
        groupId136 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels.entities",em);
        entities76.setGroupIds(groupId136);
        em.persist(entities76);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes77 = new Attributes();
        attributes77.setName("name");
        attributes77.setNullable(false);
        attributes77.setSingle(false);
//      ...................... Attributes ........................
        Entities entity137 = new Entities();
        entity137 = findBean.nameEntities("Attributes",em);
        attributes77.setEntities(entity137);
//      ...................... String ........................
        AttributesTypes attributesTypes138 = new AttributesTypes();
        attributesTypes138 = findBean.nameAttributesTypes("String",em);
        attributes77.setAttributesTypes(attributesTypes138);
        em.persist(attributes77);
        em.flush();

        Attributes attributes78 = new Attributes();
        attributes78.setName("length");
        attributes78.setNullable(true);
        attributes78.setSingle(false);
//      ...................... Attributes ........................
        Entities entity139 = new Entities();
        entity139 = findBean.nameEntities("Attributes",em);
        attributes78.setEntities(entity139);
//      ...................... Integer ........................
        AttributesTypes attributesTypes140 = new AttributesTypes();
        attributesTypes140 = findBean.nameAttributesTypes("Integer",em);
        attributes78.setAttributesTypes(attributesTypes140);
        em.persist(attributes78);
        em.flush();

        Attributes attributes79 = new Attributes();
        attributes79.setName("precision");
        attributes79.setNullable(true);
        attributes79.setSingle(false);
//      ...................... Attributes ........................
        Entities entity141 = new Entities();
        entity141 = findBean.nameEntities("Attributes",em);
        attributes79.setEntities(entity141);
//      ...................... Integer ........................
        AttributesTypes attributesTypes142 = new AttributesTypes();
        attributesTypes142 = findBean.nameAttributesTypes("Integer",em);
        attributes79.setAttributesTypes(attributesTypes142);
        em.persist(attributes79);
        em.flush();

        Attributes attributes80 = new Attributes();
        attributes80.setName("nullable");
        attributes80.setNullable(true);
        attributes80.setSingle(false);
//      ...................... Attributes ........................
        Entities entity143 = new Entities();
        entity143 = findBean.nameEntities("Attributes",em);
        attributes80.setEntities(entity143);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes144 = new AttributesTypes();
        attributesTypes144 = findBean.nameAttributesTypes("Boolean",em);
        attributes80.setAttributesTypes(attributesTypes144);
        em.persist(attributes80);
        em.flush();

        Attributes attributes81 = new Attributes();
        attributes81.setName("single");
        attributes81.setNullable(true);
        attributes81.setSingle(false);
//      ...................... Attributes ........................
        Entities entity145 = new Entities();
        entity145 = findBean.nameEntities("Attributes",em);
        attributes81.setEntities(entity145);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes146 = new AttributesTypes();
        attributesTypes146 = findBean.nameAttributesTypes("Boolean",em);
        attributes81.setAttributesTypes(attributesTypes146);
        em.persist(attributes81);
        em.flush();

        Attributes attributes82 = new Attributes();
        attributes82.setName("descripcion");
        attributes82.setNullable(true);
        attributes82.setSingle(false);
//      ...................... Attributes ........................
        Entities entity147 = new Entities();
        entity147 = findBean.nameEntities("Attributes",em);
        attributes82.setEntities(entity147);
//      ...................... String ........................
        AttributesTypes attributesTypes148 = new AttributesTypes();
        attributesTypes148 = findBean.nameAttributesTypes("String",em);
        attributes82.setAttributesTypes(attributesTypes148);
        em.persist(attributes82);
        em.flush();

        Attributes attributes83 = new Attributes();
        attributes83.setName("field");
        attributes83.setNullable(true);
        attributes83.setSingle(false);
//      ...................... Attributes ........................
        Entities entity149 = new Entities();
        entity149 = findBean.nameEntities("Attributes",em);
        attributes83.setEntities(entity149);
//      ...................... String ........................
        AttributesTypes attributesTypes150 = new AttributesTypes();
        attributesTypes150 = findBean.nameAttributesTypes("String",em);
        attributes83.setAttributesTypes(attributesTypes150);
        em.persist(attributes83);
        em.flush();

        Attributes attributes84 = new Attributes();
        attributes84.setName("access");
        attributes84.setNullable(true);
        attributes84.setSingle(false);
//      ...................... Attributes ........................
        Entities entity151 = new Entities();
        entity151 = findBean.nameEntities("Attributes",em);
        attributes84.setEntities(entity151);
//      ...................... String ........................
        AttributesTypes attributesTypes152 = new AttributesTypes();
        attributesTypes152 = findBean.nameAttributesTypes("String",em);
        attributes84.setAttributesTypes(attributesTypes152);
        em.persist(attributes84);
        em.flush();

        Attributes attributes85 = new Attributes();
        attributes85.setName("columnDefinition");
        attributes85.setNullable(true);
        attributes85.setSingle(false);
//      ...................... Attributes ........................
        Entities entity153 = new Entities();
        entity153 = findBean.nameEntities("Attributes",em);
        attributes85.setEntities(entity153);
//      ...................... String ........................
        AttributesTypes attributesTypes154 = new AttributesTypes();
        attributesTypes154 = findBean.nameAttributesTypes("String",em);
        attributes85.setAttributesTypes(attributesTypes154);
        em.persist(attributes85);
        em.flush();

        Attributes attributes86 = new Attributes();
        attributes86.setName("annotationsField");
        attributes86.setNullable(true);
        attributes86.setSingle(false);
//      ...................... Attributes ........................
        Entities entity155 = new Entities();
        entity155 = findBean.nameEntities("Attributes",em);
        attributes86.setEntities(entity155);
//      ...................... String ........................
        AttributesTypes attributesTypes156 = new AttributesTypes();
        attributesTypes156 = findBean.nameAttributesTypes("String",em);
        attributes86.setAttributesTypes(attributesTypes156);
        em.persist(attributes86);
        em.flush();

        Attributes attributes87 = new Attributes();
        attributes87.setName("annotationsMethod");
        attributes87.setNullable(true);
        attributes87.setSingle(false);
//      ...................... Attributes ........................
        Entities entity157 = new Entities();
        entity157 = findBean.nameEntities("Attributes",em);
        attributes87.setEntities(entity157);
//      ...................... String ........................
        AttributesTypes attributesTypes158 = new AttributesTypes();
        attributesTypes158 = findBean.nameAttributesTypes("String",em);
        attributes87.setAttributesTypes(attributesTypes158);
        em.persist(attributes87);
        em.flush();

        Attributes attributes88 = new Attributes();
        attributes88.setName("observations");
        attributes88.setNullable(true);
        attributes88.setSingle(false);
//      ...................... Attributes ........................
        Entities entity159 = new Entities();
        entity159 = findBean.nameEntities("Attributes",em);
        attributes88.setEntities(entity159);
//      ...................... String ........................
        AttributesTypes attributesTypes160 = new AttributesTypes();
        attributesTypes160 = findBean.nameAttributesTypes("String",em);
        attributes88.setAttributesTypes(attributesTypes160);
        em.persist(attributes88);
        em.flush();

        Entities entities89 = new Entities();
        entities89.setName("Cardinalities");
//      ...................... co.simasoft.models.naif.domainmodels.entities ........................
        GroupIds groupId161 = new GroupIds();
        groupId161 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels.entities",em);
        entities89.setGroupIds(groupId161);
        em.persist(entities89);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes90 = new Attributes();
        attributes90.setName("name");
        attributes90.setNullable(false);
        attributes90.setSingle(true);
//      ...................... Cardinalities ........................
        Entities entity162 = new Entities();
        entity162 = findBean.nameEntities("Cardinalities",em);
        attributes90.setEntities(entity162);
//      ...................... String ........................
        AttributesTypes attributesTypes163 = new AttributesTypes();
        attributesTypes163 = findBean.nameAttributesTypes("String",em);
        attributes90.setAttributesTypes(attributesTypes163);
        em.persist(attributes90);
        em.flush();

        Attributes attributes91 = new Attributes();
        attributes91.setName("cardinality");
        attributes91.setNullable(false);
        attributes91.setSingle(false);
//      ...................... Cardinalities ........................
        Entities entity164 = new Entities();
        entity164 = findBean.nameEntities("Cardinalities",em);
        attributes91.setEntities(entity164);
//      ...................... String ........................
        AttributesTypes attributesTypes165 = new AttributesTypes();
        attributesTypes165 = findBean.nameAttributesTypes("String",em);
        attributes91.setAttributesTypes(attributesTypes165);
        em.persist(attributes91);
        em.flush();

        Attributes attributes92 = new Attributes();
        attributes92.setName("unidirectional");
        attributes92.setNullable(true);
        attributes92.setSingle(false);
//      ...................... Cardinalities ........................
        Entities entity166 = new Entities();
        entity166 = findBean.nameEntities("Cardinalities",em);
        attributes92.setEntities(entity166);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes167 = new AttributesTypes();
        attributesTypes167 = findBean.nameAttributesTypes("Boolean",em);
        attributes92.setAttributesTypes(attributesTypes167);
        em.persist(attributes92);
        em.flush();

        Attributes attributes93 = new Attributes();
        attributes93.setName("annotations");
        attributes93.setNullable(true);
        attributes93.setSingle(false);
//      ...................... Cardinalities ........................
        Entities entity168 = new Entities();
        entity168 = findBean.nameEntities("Cardinalities",em);
        attributes93.setEntities(entity168);
//      ...................... String ........................
        AttributesTypes attributesTypes169 = new AttributesTypes();
        attributesTypes169 = findBean.nameAttributesTypes("String",em);
        attributes93.setAttributesTypes(attributesTypes169);
        em.persist(attributes93);
        em.flush();

        Attributes attributes94 = new Attributes();
        attributes94.setName("observations");
        attributes94.setNullable(true);
        attributes94.setSingle(false);
//      ...................... Cardinalities ........................
        Entities entity170 = new Entities();
        entity170 = findBean.nameEntities("Cardinalities",em);
        attributes94.setEntities(entity170);
//      ...................... String ........................
        AttributesTypes attributesTypes171 = new AttributesTypes();
        attributesTypes171 = findBean.nameAttributesTypes("String",em);
        attributes94.setAttributesTypes(attributesTypes171);
        em.persist(attributes94);
        em.flush();

        GroupIds groupIds95 = new GroupIds();
        groupIds95.setGroupId("co.simasoft.models.naif.domainmodels.links");
//      ...................... SystemsModels ........................
        DomainModels domainModel172 = new DomainModels();
        domainModel172 = findBean.artifactIdDomainModels("SystemsModels",em);
        groupIds95.setDomainModels(domainModel172);
        em.persist(groupIds95);
        em.flush();

//      ---------------------- Entities ------------------------

        Entities entities96 = new Entities();
        entities96.setName("Sections");
//      ...................... co.simasoft.models.naif.domainmodels.links ........................
        GroupIds groupId173 = new GroupIds();
        groupId173 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels.links",em);
        entities96.setGroupIds(groupId173);
        em.persist(entities96);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes97 = new Attributes();
        attributes97.setName("name");
        attributes97.setNullable(true);
        attributes97.setSingle(false);
//      ...................... Sections ........................
        Entities entity174 = new Entities();
        entity174 = findBean.nameEntities("Sections",em);
        attributes97.setEntities(entity174);
//      ...................... String ........................
        AttributesTypes attributesTypes175 = new AttributesTypes();
        attributesTypes175 = findBean.nameAttributesTypes("String",em);
        attributes97.setAttributesTypes(attributesTypes175);
        em.persist(attributes97);
        em.flush();

        Attributes attributes98 = new Attributes();
        attributes98.setName("content");
        attributes98.setNullable(false);
        attributes98.setSingle(false);
//      ...................... Sections ........................
        Entities entity176 = new Entities();
        entity176 = findBean.nameEntities("Sections",em);
        attributes98.setEntities(entity176);
//      ...................... String ........................
        AttributesTypes attributesTypes177 = new AttributesTypes();
        attributesTypes177 = findBean.nameAttributesTypes("String",em);
        attributes98.setAttributesTypes(attributesTypes177);
        em.persist(attributes98);
        em.flush();

        Entities entities99 = new Entities();
        entities99.setName("SubChapters");
//      ...................... co.simasoft.models.naif.domainmodels.links ........................
        GroupIds groupId178 = new GroupIds();
        groupId178 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels.links",em);
        entities99.setGroupIds(groupId178);
        em.persist(entities99);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes100 = new Attributes();
        attributes100.setName("name");
        attributes100.setNullable(true);
        attributes100.setSingle(false);
//      ...................... SubChapters ........................
        Entities entity179 = new Entities();
        entity179 = findBean.nameEntities("SubChapters",em);
        attributes100.setEntities(entity179);
//      ...................... String ........................
        AttributesTypes attributesTypes180 = new AttributesTypes();
        attributesTypes180 = findBean.nameAttributesTypes("String",em);
        attributes100.setAttributesTypes(attributesTypes180);
        em.persist(attributes100);
        em.flush();

        Attributes attributes101 = new Attributes();
        attributes101.setName("content");
        attributes101.setNullable(false);
        attributes101.setSingle(false);
//      ...................... SubChapters ........................
        Entities entity181 = new Entities();
        entity181 = findBean.nameEntities("SubChapters",em);
        attributes101.setEntities(entity181);
//      ...................... String ........................
        AttributesTypes attributesTypes182 = new AttributesTypes();
        attributesTypes182 = findBean.nameAttributesTypes("String",em);
        attributes101.setAttributesTypes(attributesTypes182);
        em.persist(attributes101);
        em.flush();

        Entities entities102 = new Entities();
        entities102.setName("Chapters");
//      ...................... co.simasoft.models.naif.domainmodels.links ........................
        GroupIds groupId183 = new GroupIds();
        groupId183 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels.links",em);
        entities102.setGroupIds(groupId183);
        em.persist(entities102);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes103 = new Attributes();
        attributes103.setName("name");
        attributes103.setNullable(true);
        attributes103.setSingle(false);
//      ...................... Chapters ........................
        Entities entity184 = new Entities();
        entity184 = findBean.nameEntities("Chapters",em);
        attributes103.setEntities(entity184);
//      ...................... String ........................
        AttributesTypes attributesTypes185 = new AttributesTypes();
        attributesTypes185 = findBean.nameAttributesTypes("String",em);
        attributes103.setAttributesTypes(attributesTypes185);
        em.persist(attributes103);
        em.flush();

        Attributes attributes104 = new Attributes();
        attributes104.setName("content");
        attributes104.setNullable(false);
        attributes104.setSingle(false);
//      ...................... Chapters ........................
        Entities entity186 = new Entities();
        entity186 = findBean.nameEntities("Chapters",em);
        attributes104.setEntities(entity186);
//      ...................... String ........................
        AttributesTypes attributesTypes187 = new AttributesTypes();
        attributesTypes187 = findBean.nameAttributesTypes("String",em);
        attributes104.setAttributesTypes(attributesTypes187);
        em.persist(attributes104);
        em.flush();

        Entities entities105 = new Entities();
        entities105.setName("Books");
//      ...................... co.simasoft.models.naif.domainmodels.links ........................
        GroupIds groupId188 = new GroupIds();
        groupId188 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels.links",em);
        entities105.setGroupIds(groupId188);
        em.persist(entities105);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes106 = new Attributes();
        attributes106.setName("name");
        attributes106.setNullable(false);
        attributes106.setSingle(true);
//      ...................... Books ........................
        Entities entity189 = new Entities();
        entity189 = findBean.nameEntities("Books",em);
        attributes106.setEntities(entity189);
//      ...................... String ........................
        AttributesTypes attributesTypes190 = new AttributesTypes();
        attributesTypes190 = findBean.nameAttributesTypes("String",em);
        attributes106.setAttributesTypes(attributesTypes190);
        em.persist(attributes106);
        em.flush();

        Attributes attributes107 = new Attributes();
        attributes107.setName("content");
        attributes107.setNullable(false);
        attributes107.setSingle(false);
//      ...................... Books ........................
        Entities entity191 = new Entities();
        entity191 = findBean.nameEntities("Books",em);
        attributes107.setEntities(entity191);
//      ...................... String ........................
        AttributesTypes attributesTypes192 = new AttributesTypes();
        attributesTypes192 = findBean.nameAttributesTypes("String",em);
        attributes107.setAttributesTypes(attributesTypes192);
        em.persist(attributes107);
        em.flush();

        Entities entities108 = new Entities();
        entities108.setName("Links");
//      ...................... co.simasoft.models.naif.domainmodels.links ........................
        GroupIds groupId193 = new GroupIds();
        groupId193 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels.links",em);
        entities108.setGroupIds(groupId193);
        em.persist(entities108);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes109 = new Attributes();
        attributes109.setName("title");
        attributes109.setNullable(false);
        attributes109.setSingle(true);
//      ...................... Links ........................
        Entities entity194 = new Entities();
        entity194 = findBean.nameEntities("Links",em);
        attributes109.setEntities(entity194);
//      ...................... String ........................
        AttributesTypes attributesTypes195 = new AttributesTypes();
        attributesTypes195 = findBean.nameAttributesTypes("String",em);
        attributes109.setAttributesTypes(attributesTypes195);
        em.persist(attributes109);
        em.flush();

        Attributes attributes110 = new Attributes();
        attributes110.setName("link");
        attributes110.setNullable(false);
        attributes110.setSingle(true);
//      ...................... Links ........................
        Entities entity196 = new Entities();
        entity196 = findBean.nameEntities("Links",em);
        attributes110.setEntities(entity196);
//      ...................... String ........................
        AttributesTypes attributesTypes197 = new AttributesTypes();
        attributesTypes197 = findBean.nameAttributesTypes("String",em);
        attributes110.setAttributesTypes(attributesTypes197);
        em.persist(attributes110);
        em.flush();

        Attributes attributes111 = new Attributes();
        attributes111.setName("observations");
        attributes111.setNullable(true);
        attributes111.setSingle(false);
//      ...................... Links ........................
        Entities entity198 = new Entities();
        entity198 = findBean.nameEntities("Links",em);
        attributes111.setEntities(entity198);
//      ...................... String ........................
        AttributesTypes attributesTypes199 = new AttributesTypes();
        attributesTypes199 = findBean.nameAttributesTypes("String",em);
        attributes111.setAttributesTypes(attributesTypes199);
        em.persist(attributes111);
        em.flush();

        Entities entities112 = new Entities();
        entities112.setName("LinksTypes");
//      ...................... co.simasoft.models.naif.domainmodels.links ........................
        GroupIds groupId200 = new GroupIds();
        groupId200 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels.links",em);
        entities112.setGroupIds(groupId200);
        em.persist(entities112);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes113 = new Attributes();
        attributes113.setName("name");
        attributes113.setNullable(false);
        attributes113.setSingle(true);
//      ...................... LinksTypes ........................
        Entities entity201 = new Entities();
        entity201 = findBean.nameEntities("LinksTypes",em);
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
//      ...................... LinksTypes ........................
        Entities entity203 = new Entities();
        entity203 = findBean.nameEntities("LinksTypes",em);
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
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities207 = new Cardinalities();
        cardinalities207 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
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
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities210 = new Cardinalities();
        cardinalities210 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships2.setCardinalities(cardinalities210);
        em.persist(relationships2);
        em.flush();

        Relationships relationships3 = new Relationships();
        relationships3.setOptionality(true);
        relationships3.setIsEmbedded(false);
//      ...................... Imports ........................
        Entities entities211 = new Entities();
        entities211 = findBean.nameEntities("Imports",em);
        relationships3.setFrom(entities211);
//      ...................... Dependency ........................
        Entities entities212 = new Entities();
        entities212 = findBean.nameEntities("Dependency",em);
        relationships3.setTo(entities212);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities213 = new Cardinalities();
        cardinalities213 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships3.setCardinalities(cardinalities213);
        em.persist(relationships3);
        em.flush();

        Relationships relationships4 = new Relationships();
        relationships4.setOptionality(true);
        relationships4.setIsEmbedded(false);
//      ...................... AttributesProperties ........................
        Entities entities214 = new Entities();
        entities214 = findBean.nameEntities("AttributesProperties",em);
        relationships4.setFrom(entities214);
//      ...................... AttributesTypes ........................
        Entities entities215 = new Entities();
        entities215 = findBean.nameEntities("AttributesTypes",em);
        relationships4.setTo(entities215);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities216 = new Cardinalities();
        cardinalities216 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
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
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities219 = new Cardinalities();
        cardinalities219 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships5.setCardinalities(cardinalities219);
        em.persist(relationships5);
        em.flush();

        Relationships relationships6 = new Relationships();
        relationships6.setOptionality(true);
        relationships6.setIsEmbedded(false);
//      ...................... Dependency ........................
        Entities entities220 = new Entities();
        entities220 = findBean.nameEntities("Dependency",em);
        relationships6.setFrom(entities220);
//      ...................... Imports ........................
        Entities entities221 = new Entities();
        entities221 = findBean.nameEntities("Imports",em);
        relationships6.setTo(entities221);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities222 = new Cardinalities();
        cardinalities222 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships6.setCardinalities(cardinalities222);
        em.persist(relationships6);
        em.flush();

        Relationships relationships7 = new Relationships();
        relationships7.setOptionality(true);
        relationships7.setIsEmbedded(false);
//      ...................... DomainModels ........................
        Entities entities223 = new Entities();
        entities223 = findBean.nameEntities("DomainModels",em);
        relationships7.setFrom(entities223);
//      ...................... SystemsModels ........................
        Entities entities224 = new Entities();
        entities224 = findBean.nameEntities("SystemsModels",em);
        relationships7.setTo(entities224);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities225 = new Cardinalities();
        cardinalities225 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships7.setCardinalities(cardinalities225);
        em.persist(relationships7);
        em.flush();

        Relationships relationships8 = new Relationships();
        relationships8.setOptionality(true);
        relationships8.setIsEmbedded(false);
//      ...................... FilesModels ........................
        Entities entities226 = new Entities();
        entities226 = findBean.nameEntities("FilesModels",em);
        relationships8.setFrom(entities226);
//      ...................... GroupIds ........................
        Entities entities227 = new Entities();
        entities227 = findBean.nameEntities("GroupIds",em);
        relationships8.setTo(entities227);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities228 = new Cardinalities();
        cardinalities228 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships8.setCardinalities(cardinalities228);
        em.persist(relationships8);
        em.flush();

        Relationships relationships9 = new Relationships();
        relationships9.setOptionality(true);
        relationships9.setIsEmbedded(false);
//      ...................... FilesModels ........................
        Entities entities229 = new Entities();
        entities229 = findBean.nameEntities("FilesModels",em);
        relationships9.setFrom(entities229);
//      ...................... DomainModels ........................
        Entities entities230 = new Entities();
        entities230 = findBean.nameEntities("DomainModels",em);
        relationships9.setTo(entities230);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities231 = new Cardinalities();
        cardinalities231 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships9.setCardinalities(cardinalities231);
        em.persist(relationships9);
        em.flush();

        Relationships relationships10 = new Relationships();
        relationships10.setOptionality(true);
        relationships10.setIsEmbedded(false);
//      ...................... SystemsModels ........................
        Entities entities232 = new Entities();
        entities232 = findBean.nameEntities("SystemsModels",em);
        relationships10.setFrom(entities232);
//      ...................... DomainModels ........................
        Entities entities233 = new Entities();
        entities233 = findBean.nameEntities("DomainModels",em);
        relationships10.setTo(entities233);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities234 = new Cardinalities();
        cardinalities234 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships10.setCardinalities(cardinalities234);
        em.persist(relationships10);
        em.flush();

        Relationships relationships11 = new Relationships();
        relationships11.setOptionality(true);
        relationships11.setIsEmbedded(false);
//      ...................... FilesModels ........................
        Entities entities235 = new Entities();
        entities235 = findBean.nameEntities("FilesModels",em);
        relationships11.setFrom(entities235);
//      ...................... SystemsModels ........................
        Entities entities236 = new Entities();
        entities236 = findBean.nameEntities("SystemsModels",em);
        relationships11.setTo(entities236);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities237 = new Cardinalities();
        cardinalities237 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships11.setCardinalities(cardinalities237);
        em.persist(relationships11);
        em.flush();

        Relationships relationships12 = new Relationships();
        relationships12.setOptionality(true);
        relationships12.setIsEmbedded(false);
//      ...................... DomainModels ........................
        Entities entities238 = new Entities();
        entities238 = findBean.nameEntities("DomainModels",em);
        relationships12.setFrom(entities238);
//      ...................... FilesModels ........................
        Entities entities239 = new Entities();
        entities239 = findBean.nameEntities("FilesModels",em);
        relationships12.setTo(entities239);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities240 = new Cardinalities();
        cardinalities240 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships12.setCardinalities(cardinalities240);
        em.persist(relationships12);
        em.flush();

        Relationships relationships13 = new Relationships();
        relationships13.setOptionality(true);
        relationships13.setIsEmbedded(false);
//      ...................... GroupIds ........................
        Entities entities241 = new Entities();
        entities241 = findBean.nameEntities("GroupIds",em);
        relationships13.setFrom(entities241);
//      ...................... Entities ........................
        Entities entities242 = new Entities();
        entities242 = findBean.nameEntities("Entities",em);
        relationships13.setTo(entities242);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities243 = new Cardinalities();
        cardinalities243 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships13.setCardinalities(cardinalities243);
        em.persist(relationships13);
        em.flush();

        Relationships relationships14 = new Relationships();
        relationships14.setOptionality(true);
        relationships14.setIsEmbedded(false);
//      ...................... GroupIds ........................
        Entities entities244 = new Entities();
        entities244 = findBean.nameEntities("GroupIds",em);
        relationships14.setFrom(entities244);
//      ...................... DomainModels ........................
        Entities entities245 = new Entities();
        entities245 = findBean.nameEntities("DomainModels",em);
        relationships14.setTo(entities245);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities246 = new Cardinalities();
        cardinalities246 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships14.setCardinalities(cardinalities246);
        em.persist(relationships14);
        em.flush();

        Relationships relationships15 = new Relationships();
        relationships15.setOptionality(true);
        relationships15.setIsEmbedded(false);
//      ...................... SystemsModels ........................
        Entities entities247 = new Entities();
        entities247 = findBean.nameEntities("SystemsModels",em);
        relationships15.setFrom(entities247);
//      ...................... FilesModels ........................
        Entities entities248 = new Entities();
        entities248 = findBean.nameEntities("FilesModels",em);
        relationships15.setTo(entities248);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities249 = new Cardinalities();
        cardinalities249 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships15.setCardinalities(cardinalities249);
        em.persist(relationships15);
        em.flush();

        Relationships relationships16 = new Relationships();
        relationships16.setOptionality(true);
        relationships16.setIsEmbedded(false);
//      ...................... DomainModels ........................
        Entities entities250 = new Entities();
        entities250 = findBean.nameEntities("DomainModels",em);
        relationships16.setFrom(entities250);
//      ...................... GroupIds ........................
        Entities entities251 = new Entities();
        entities251 = findBean.nameEntities("GroupIds",em);
        relationships16.setTo(entities251);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities252 = new Cardinalities();
        cardinalities252 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships16.setCardinalities(cardinalities252);
        em.persist(relationships16);
        em.flush();

        Relationships relationships17 = new Relationships();
        relationships17.setOptionality(true);
        relationships17.setIsEmbedded(false);
//      ...................... Entities ........................
        Entities entities253 = new Entities();
        entities253 = findBean.nameEntities("Entities",em);
        relationships17.setFrom(entities253);
//      ...................... GroupIds ........................
        Entities entities254 = new Entities();
        entities254 = findBean.nameEntities("GroupIds",em);
        relationships17.setTo(entities254);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities255 = new Cardinalities();
        cardinalities255 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships17.setCardinalities(cardinalities255);
        em.persist(relationships17);
        em.flush();

        Relationships relationships18 = new Relationships();
        relationships18.setOptionality(true);
        relationships18.setIsEmbedded(false);
//      ...................... GroupIds ........................
        Entities entities256 = new Entities();
        entities256 = findBean.nameEntities("GroupIds",em);
        relationships18.setFrom(entities256);
//      ...................... FilesModels ........................
        Entities entities257 = new Entities();
        entities257 = findBean.nameEntities("FilesModels",em);
        relationships18.setTo(entities257);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities258 = new Cardinalities();
        cardinalities258 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships18.setCardinalities(cardinalities258);
        em.persist(relationships18);
        em.flush();

        Relationships relationships19 = new Relationships();
        relationships19.setOptionality(true);
        relationships19.setIsEmbedded(false);
//      ...................... FilesModels ........................
        Entities entities259 = new Entities();
        entities259 = findBean.nameEntities("FilesModels",em);
        relationships19.setFrom(entities259);
//      ...................... Entities ........................
        Entities entities260 = new Entities();
        entities260 = findBean.nameEntities("Entities",em);
        relationships19.setTo(entities260);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities261 = new Cardinalities();
        cardinalities261 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships19.setCardinalities(cardinalities261);
        em.persist(relationships19);
        em.flush();

        Relationships relationships20 = new Relationships();
        relationships20.setOptionality(true);
        relationships20.setIsEmbedded(false);
//      ...................... NameQueries ........................
        Entities entities262 = new Entities();
        entities262 = findBean.nameEntities("NameQueries",em);
        relationships20.setFrom(entities262);
//      ...................... Entities ........................
        Entities entities263 = new Entities();
        entities263 = findBean.nameEntities("Entities",em);
        relationships20.setTo(entities263);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities264 = new Cardinalities();
        cardinalities264 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships20.setCardinalities(cardinalities264);
        em.persist(relationships20);
        em.flush();

        Relationships relationships21 = new Relationships();
        relationships21.setOptionality(true);
        relationships21.setIsEmbedded(false);
//      ...................... Entities ........................
        Entities entities265 = new Entities();
        entities265 = findBean.nameEntities("Entities",em);
        relationships21.setFrom(entities265);
//      ...................... FilesModels ........................
        Entities entities266 = new Entities();
        entities266 = findBean.nameEntities("FilesModels",em);
        relationships21.setTo(entities266);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities267 = new Cardinalities();
        cardinalities267 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships21.setCardinalities(cardinalities267);
        em.persist(relationships21);
        em.flush();

        Relationships relationships22 = new Relationships();
        relationships22.setOptionality(true);
        relationships22.setIsEmbedded(false);
//      ...................... Imports ........................
        Entities entities268 = new Entities();
        entities268 = findBean.nameEntities("Imports",em);
        relationships22.setFrom(entities268);
//      ...................... Entities ........................
        Entities entities269 = new Entities();
        entities269 = findBean.nameEntities("Entities",em);
        relationships22.setTo(entities269);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities270 = new Cardinalities();
        cardinalities270 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships22.setCardinalities(cardinalities270);
        em.persist(relationships22);
        em.flush();

        Relationships relationships23 = new Relationships();
        relationships23.setOptionality(true);
        relationships23.setIsEmbedded(false);
//      ...................... Entities ........................
        Entities entities271 = new Entities();
        entities271 = findBean.nameEntities("Entities",em);
        relationships23.setFrom(entities271);
//      ...................... Imports ........................
        Entities entities272 = new Entities();
        entities272 = findBean.nameEntities("Imports",em);
        relationships23.setTo(entities272);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities273 = new Cardinalities();
        cardinalities273 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships23.setCardinalities(cardinalities273);
        em.persist(relationships23);
        em.flush();

        Relationships relationships24 = new Relationships();
        relationships24.setOptionality(true);
        relationships24.setIsEmbedded(false);
//      ...................... AttributesProperties ........................
        Entities entities274 = new Entities();
        entities274 = findBean.nameEntities("AttributesProperties",em);
        relationships24.setFrom(entities274);
//      ...................... Relationships ........................
        Entities entities275 = new Entities();
        entities275 = findBean.nameEntities("Relationships",em);
        relationships24.setTo(entities275);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities276 = new Cardinalities();
        cardinalities276 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
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
//      ...................... Cardinalities ........................
        Entities entities278 = new Entities();
        entities278 = findBean.nameEntities("Cardinalities",em);
        relationships25.setTo(entities278);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities279 = new Cardinalities();
        cardinalities279 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships25.setCardinalities(cardinalities279);
        em.persist(relationships25);
        em.flush();

        Relationships relationships26 = new Relationships();
        relationships26.setOptionality(true);
        relationships26.setIsEmbedded(false);
//      ...................... Relationships ........................
        Entities entities280 = new Entities();
        entities280 = findBean.nameEntities("Relationships",em);
        relationships26.setFrom(entities280);
//      ...................... Entities ........................
        Entities entities281 = new Entities();
        entities281 = findBean.nameEntities("Entities",em);
        relationships26.setTo(entities281);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities282 = new Cardinalities();
        cardinalities282 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships26.setCardinalities(cardinalities282);
        em.persist(relationships26);
        em.flush();

        Relationships relationships27 = new Relationships();
        relationships27.setOptionality(true);
        relationships27.setIsEmbedded(false);
//      ...................... Entities ........................
        Entities entities283 = new Entities();
        entities283 = findBean.nameEntities("Entities",em);
        relationships27.setFrom(entities283);
//      ...................... Relationships ........................
        Entities entities284 = new Entities();
        entities284 = findBean.nameEntities("Relationships",em);
        relationships27.setTo(entities284);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities285 = new Cardinalities();
        cardinalities285 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships27.setCardinalities(cardinalities285);
        em.persist(relationships27);
        em.flush();

        Relationships relationships28 = new Relationships();
        relationships28.setOptionality(true);
        relationships28.setIsEmbedded(false);
//      ...................... Imports ........................
        Entities entities286 = new Entities();
        entities286 = findBean.nameEntities("Imports",em);
        relationships28.setFrom(entities286);
//      ...................... Cardinalities ........................
        Entities entities287 = new Entities();
        entities287 = findBean.nameEntities("Cardinalities",em);
        relationships28.setTo(entities287);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities288 = new Cardinalities();
        cardinalities288 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships28.setCardinalities(cardinalities288);
        em.persist(relationships28);
        em.flush();

        Relationships relationships29 = new Relationships();
        relationships29.setOptionality(true);
        relationships29.setIsEmbedded(false);
//      ...................... Relationships ........................
        Entities entities289 = new Entities();
        entities289 = findBean.nameEntities("Relationships",em);
        relationships29.setFrom(entities289);
//      ...................... AttributesProperties ........................
        Entities entities290 = new Entities();
        entities290 = findBean.nameEntities("AttributesProperties",em);
        relationships29.setTo(entities290);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities291 = new Cardinalities();
        cardinalities291 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships29.setCardinalities(cardinalities291);
        em.persist(relationships29);
        em.flush();

        Relationships relationships30 = new Relationships();
        relationships30.setOptionality(true);
        relationships30.setIsEmbedded(false);
//      ...................... AttributesTypes ........................
        Entities entities292 = new Entities();
        entities292 = findBean.nameEntities("AttributesTypes",em);
        relationships30.setFrom(entities292);
//      ...................... Attributes ........................
        Entities entities293 = new Entities();
        entities293 = findBean.nameEntities("Attributes",em);
        relationships30.setTo(entities293);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities294 = new Cardinalities();
        cardinalities294 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships30.setCardinalities(cardinalities294);
        em.persist(relationships30);
        em.flush();

        Relationships relationships31 = new Relationships();
        relationships31.setOptionality(true);
        relationships31.setIsEmbedded(false);
//      ...................... Attributes ........................
        Entities entities295 = new Entities();
        entities295 = findBean.nameEntities("Attributes",em);
        relationships31.setFrom(entities295);
//      ...................... AttributesTypes ........................
        Entities entities296 = new Entities();
        entities296 = findBean.nameEntities("AttributesTypes",em);
        relationships31.setTo(entities296);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities297 = new Cardinalities();
        cardinalities297 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships31.setCardinalities(cardinalities297);
        em.persist(relationships31);
        em.flush();

        Relationships relationships32 = new Relationships();
        relationships32.setOptionality(true);
        relationships32.setIsEmbedded(false);
//      ...................... Cardinalities ........................
        Entities entities298 = new Entities();
        entities298 = findBean.nameEntities("Cardinalities",em);
        relationships32.setFrom(entities298);
//      ...................... Relationships ........................
        Entities entities299 = new Entities();
        entities299 = findBean.nameEntities("Relationships",em);
        relationships32.setTo(entities299);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities300 = new Cardinalities();
        cardinalities300 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships32.setCardinalities(cardinalities300);
        em.persist(relationships32);
        em.flush();

        Relationships relationships33 = new Relationships();
        relationships33.setOptionality(true);
        relationships33.setIsEmbedded(false);
//      ...................... Attributes ........................
        Entities entities301 = new Entities();
        entities301 = findBean.nameEntities("Attributes",em);
        relationships33.setFrom(entities301);
//      ...................... Entities ........................
        Entities entities302 = new Entities();
        entities302 = findBean.nameEntities("Entities",em);
        relationships33.setTo(entities302);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities303 = new Cardinalities();
        cardinalities303 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships33.setCardinalities(cardinalities303);
        em.persist(relationships33);
        em.flush();

        Relationships relationships34 = new Relationships();
        relationships34.setOptionality(true);
        relationships34.setIsEmbedded(false);
//      ...................... Relationships ........................
        Entities entities304 = new Entities();
        entities304 = findBean.nameEntities("Relationships",em);
        relationships34.setFrom(entities304);
//      ...................... Entities ........................
        Entities entities305 = new Entities();
        entities305 = findBean.nameEntities("Entities",em);
        relationships34.setTo(entities305);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities306 = new Cardinalities();
        cardinalities306 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships34.setCardinalities(cardinalities306);
        em.persist(relationships34);
        em.flush();

        Relationships relationships35 = new Relationships();
        relationships35.setOptionality(true);
        relationships35.setIsEmbedded(false);
//      ...................... Entities ........................
        Entities entities307 = new Entities();
        entities307 = findBean.nameEntities("Entities",em);
        relationships35.setFrom(entities307);
//      ...................... Attributes ........................
        Entities entities308 = new Entities();
        entities308 = findBean.nameEntities("Attributes",em);
        relationships35.setTo(entities308);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities309 = new Cardinalities();
        cardinalities309 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships35.setCardinalities(cardinalities309);
        em.persist(relationships35);
        em.flush();

        Relationships relationships36 = new Relationships();
        relationships36.setOptionality(true);
        relationships36.setIsEmbedded(false);
//      ...................... Attributes ........................
        Entities entities310 = new Entities();
        entities310 = findBean.nameEntities("Attributes",em);
        relationships36.setFrom(entities310);
//      ...................... AttributesProperties ........................
        Entities entities311 = new Entities();
        entities311 = findBean.nameEntities("AttributesProperties",em);
        relationships36.setTo(entities311);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities312 = new Cardinalities();
        cardinalities312 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships36.setCardinalities(cardinalities312);
        em.persist(relationships36);
        em.flush();

        Relationships relationships37 = new Relationships();
        relationships37.setOptionality(true);
        relationships37.setIsEmbedded(false);
//      ...................... AttributesProperties ........................
        Entities entities313 = new Entities();
        entities313 = findBean.nameEntities("AttributesProperties",em);
        relationships37.setFrom(entities313);
//      ...................... Attributes ........................
        Entities entities314 = new Entities();
        entities314 = findBean.nameEntities("Attributes",em);
        relationships37.setTo(entities314);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities315 = new Cardinalities();
        cardinalities315 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships37.setCardinalities(cardinalities315);
        em.persist(relationships37);
        em.flush();

        Relationships relationships38 = new Relationships();
        relationships38.setOptionality(true);
        relationships38.setIsEmbedded(false);
//      ...................... Entities ........................
        Entities entities316 = new Entities();
        entities316 = findBean.nameEntities("Entities",em);
        relationships38.setFrom(entities316);
//      ...................... Relationships ........................
        Entities entities317 = new Entities();
        entities317 = findBean.nameEntities("Relationships",em);
        relationships38.setTo(entities317);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities318 = new Cardinalities();
        cardinalities318 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships38.setCardinalities(cardinalities318);
        em.persist(relationships38);
        em.flush();

        Relationships relationships39 = new Relationships();
        relationships39.setOptionality(true);
        relationships39.setIsEmbedded(false);
//      ...................... Entities ........................
        Entities entities319 = new Entities();
        entities319 = findBean.nameEntities("Entities",em);
        relationships39.setFrom(entities319);
//      ...................... NameQueries ........................
        Entities entities320 = new Entities();
        entities320 = findBean.nameEntities("NameQueries",em);
        relationships39.setTo(entities320);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities321 = new Cardinalities();
        cardinalities321 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships39.setCardinalities(cardinalities321);
        em.persist(relationships39);
        em.flush();

        Relationships relationships40 = new Relationships();
        relationships40.setOptionality(true);
        relationships40.setIsEmbedded(false);
//      ...................... Cardinalities ........................
        Entities entities322 = new Entities();
        entities322 = findBean.nameEntities("Cardinalities",em);
        relationships40.setFrom(entities322);
//      ...................... Imports ........................
        Entities entities323 = new Entities();
        entities323 = findBean.nameEntities("Imports",em);
        relationships40.setTo(entities323);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities324 = new Cardinalities();
        cardinalities324 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships40.setCardinalities(cardinalities324);
        em.persist(relationships40);
        em.flush();

        Relationships relationships41 = new Relationships();
        relationships41.setOptionality(true);
        relationships41.setIsEmbedded(false);
//      ...................... Links ........................
        Entities entities325 = new Entities();
        entities325 = findBean.nameEntities("Links",em);
        relationships41.setFrom(entities325);
//      ...................... LinksTypes ........................
        Entities entities326 = new Entities();
        entities326 = findBean.nameEntities("LinksTypes",em);
        relationships41.setTo(entities326);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities327 = new Cardinalities();
        cardinalities327 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships41.setCardinalities(cardinalities327);
        em.persist(relationships41);
        em.flush();

        Relationships relationships42 = new Relationships();
        relationships42.setOptionality(true);
        relationships42.setIsEmbedded(false);
//      ...................... Links ........................
        Entities entities328 = new Entities();
        entities328 = findBean.nameEntities("Links",em);
        relationships42.setFrom(entities328);
//      ...................... Links ........................
        Entities entities329 = new Entities();
        entities329 = findBean.nameEntities("Links",em);
        relationships42.setTo(entities329);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities330 = new Cardinalities();
        cardinalities330 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships42.setCardinalities(cardinalities330);
        em.persist(relationships42);
        em.flush();

        Relationships relationships43 = new Relationships();
        relationships43.setOptionality(true);
        relationships43.setIsEmbedded(false);
//      ...................... LinksTypes ........................
        Entities entities331 = new Entities();
        entities331 = findBean.nameEntities("LinksTypes",em);
        relationships43.setFrom(entities331);
//      ...................... Links ........................
        Entities entities332 = new Entities();
        entities332 = findBean.nameEntities("Links",em);
        relationships43.setTo(entities332);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities333 = new Cardinalities();
        cardinalities333 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships43.setCardinalities(cardinalities333);
        em.persist(relationships43);
        em.flush();

        Relationships relationships44 = new Relationships();
        relationships44.setOptionality(true);
        relationships44.setIsEmbedded(false);
//      ...................... LinksTypes ........................
        Entities entities334 = new Entities();
        entities334 = findBean.nameEntities("LinksTypes",em);
        relationships44.setFrom(entities334);
//      ...................... LinksTypes ........................
        Entities entities335 = new Entities();
        entities335 = findBean.nameEntities("LinksTypes",em);
        relationships44.setTo(entities335);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities336 = new Cardinalities();
        cardinalities336 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships44.setCardinalities(cardinalities336);
        em.persist(relationships44);
        em.flush();

        Relationships relationships45 = new Relationships();
        relationships45.setOptionality(true);
        relationships45.setIsEmbedded(false);
//      ...................... LinksTypes ........................
        Entities entities337 = new Entities();
        entities337 = findBean.nameEntities("LinksTypes",em);
        relationships45.setFrom(entities337);
//      ...................... LinksTypes ........................
        Entities entities338 = new Entities();
        entities338 = findBean.nameEntities("LinksTypes",em);
        relationships45.setTo(entities338);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities339 = new Cardinalities();
        cardinalities339 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships45.setCardinalities(cardinalities339);
        em.persist(relationships45);
        em.flush();

        Relationships relationships46 = new Relationships();
        relationships46.setOptionality(true);
        relationships46.setIsEmbedded(false);
//      ...................... Links ........................
        Entities entities340 = new Entities();
        entities340 = findBean.nameEntities("Links",em);
        relationships46.setFrom(entities340);
//      ...................... Links ........................
        Entities entities341 = new Entities();
        entities341 = findBean.nameEntities("Links",em);
        relationships46.setTo(entities341);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities342 = new Cardinalities();
        cardinalities342 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships46.setCardinalities(cardinalities342);
        em.persist(relationships46);
        em.flush();

    } // data()

} // SystemsModels
