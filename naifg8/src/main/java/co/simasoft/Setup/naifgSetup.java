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
@Named("naifgSetup")
public class naifgSetup {

    @PersistenceContext(unitName = "naifg8PU-JTA")
    private EntityManager em;

    FindBean findBean = new FindBean();

    private static final Logger log = Logger.getLogger(DataDb.class.getName());

    public void data() {

//      ---------------------- DomainModels ------------------------

        DomainModels domainModels = new DomainModels();
        domainModels.setGroupId("co.simasoft");
        domainModels.setArtifactId("naifg");
        domainModels.setVersion("1.0-SNAPSHOT");
        em.persist(domainModels);
        em.flush();

//      ---------------------- GroupIds ------------------------

        GroupIds groupIds1 = new GroupIds();
        groupIds1.setGroupId("co.simasoft.models.dev.naifg.dependencies");
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        DomainModels domainModel1 = new DomainModels();
        domainModel1 = findBean.artifactIdDomainModels("naifg",em);
        groupIds1.setDomainModels(domainModel1);
        em.persist(groupIds1);
        em.flush();

        GroupIds groupIds2 = new GroupIds();
        groupIds2.setGroupId("co.simasoft.models.dev.naifg");
//      ...................... co.simasoft.models.dev.naifg ........................
        DomainModels domainModel2 = new DomainModels();
        domainModel2 = findBean.artifactIdDomainModels("naifg",em);
        groupIds2.setDomainModels(domainModel2);
        em.persist(groupIds2);
        em.flush();

//      ---------------------- Entities ------------------------

//      ---------------------- Entities ------------------------

        Entities entities1 = new Entities();
        entities1.setName("Attributes");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId1 = new GroupIds();
        groupId1 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities1.setGroupIds(groupId1);
        em.persist(entities1);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes2 = new Attributes();
        attributes2.setName("name");
        attributes2.setNullable(false);
        attributes2.setSingle(false);
//      ...................... Attributes ........................
        Entities entity2 = new Entities();
        entity2 = findBean.nameEntities("Attributes",em);
        attributes2.setEntities(entity2);
//      ...................... String ........................
        AttributesTypes attributesTypes3 = new AttributesTypes();
        attributesTypes3 = findBean.nameAttributesTypes("String",em);
        attributes2.setAttributesTypes(attributesTypes3);
        em.persist(attributes2);
        em.flush();

        Attributes attributes3 = new Attributes();
        attributes3.setName("length");
        attributes3.setNullable(true);
        attributes3.setSingle(false);
//      ...................... Attributes ........................
        Entities entity4 = new Entities();
        entity4 = findBean.nameEntities("Attributes",em);
        attributes3.setEntities(entity4);
//      ...................... Integer ........................
        AttributesTypes attributesTypes5 = new AttributesTypes();
        attributesTypes5 = findBean.nameAttributesTypes("Integer",em);
        attributes3.setAttributesTypes(attributesTypes5);
        em.persist(attributes3);
        em.flush();

        Attributes attributes4 = new Attributes();
        attributes4.setName("precision");
        attributes4.setNullable(true);
        attributes4.setSingle(false);
//      ...................... Attributes ........................
        Entities entity6 = new Entities();
        entity6 = findBean.nameEntities("Attributes",em);
        attributes4.setEntities(entity6);
//      ...................... Integer ........................
        AttributesTypes attributesTypes7 = new AttributesTypes();
        attributesTypes7 = findBean.nameAttributesTypes("Integer",em);
        attributes4.setAttributesTypes(attributesTypes7);
        em.persist(attributes4);
        em.flush();

        Attributes attributes5 = new Attributes();
        attributes5.setName("nullable");
        attributes5.setNullable(true);
        attributes5.setSingle(false);
//      ...................... Attributes ........................
        Entities entity8 = new Entities();
        entity8 = findBean.nameEntities("Attributes",em);
        attributes5.setEntities(entity8);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes9 = new AttributesTypes();
        attributesTypes9 = findBean.nameAttributesTypes("Boolean",em);
        attributes5.setAttributesTypes(attributesTypes9);
        em.persist(attributes5);
        em.flush();

        Attributes attributes6 = new Attributes();
        attributes6.setName("single");
        attributes6.setNullable(true);
        attributes6.setSingle(false);
//      ...................... Attributes ........................
        Entities entity10 = new Entities();
        entity10 = findBean.nameEntities("Attributes",em);
        attributes6.setEntities(entity10);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes11 = new AttributesTypes();
        attributesTypes11 = findBean.nameAttributesTypes("Boolean",em);
        attributes6.setAttributesTypes(attributesTypes11);
        em.persist(attributes6);
        em.flush();

        Attributes attributes7 = new Attributes();
        attributes7.setName("descripcion");
        attributes7.setNullable(true);
        attributes7.setSingle(false);
//      ...................... Attributes ........................
        Entities entity12 = new Entities();
        entity12 = findBean.nameEntities("Attributes",em);
        attributes7.setEntities(entity12);
//      ...................... String ........................
        AttributesTypes attributesTypes13 = new AttributesTypes();
        attributesTypes13 = findBean.nameAttributesTypes("String",em);
        attributes7.setAttributesTypes(attributesTypes13);
        em.persist(attributes7);
        em.flush();

        Attributes attributes8 = new Attributes();
        attributes8.setName("field");
        attributes8.setNullable(true);
        attributes8.setSingle(false);
//      ...................... Attributes ........................
        Entities entity14 = new Entities();
        entity14 = findBean.nameEntities("Attributes",em);
        attributes8.setEntities(entity14);
//      ...................... String ........................
        AttributesTypes attributesTypes15 = new AttributesTypes();
        attributesTypes15 = findBean.nameAttributesTypes("String",em);
        attributes8.setAttributesTypes(attributesTypes15);
        em.persist(attributes8);
        em.flush();

        Attributes attributes9 = new Attributes();
        attributes9.setName("access");
        attributes9.setNullable(true);
        attributes9.setSingle(false);
//      ...................... Attributes ........................
        Entities entity16 = new Entities();
        entity16 = findBean.nameEntities("Attributes",em);
        attributes9.setEntities(entity16);
//      ...................... String ........................
        AttributesTypes attributesTypes17 = new AttributesTypes();
        attributesTypes17 = findBean.nameAttributesTypes("String",em);
        attributes9.setAttributesTypes(attributesTypes17);
        em.persist(attributes9);
        em.flush();

        Attributes attributes10 = new Attributes();
        attributes10.setName("columnDefinition");
        attributes10.setNullable(true);
        attributes10.setSingle(false);
//      ...................... Attributes ........................
        Entities entity18 = new Entities();
        entity18 = findBean.nameEntities("Attributes",em);
        attributes10.setEntities(entity18);
//      ...................... String ........................
        AttributesTypes attributesTypes19 = new AttributesTypes();
        attributesTypes19 = findBean.nameAttributesTypes("String",em);
        attributes10.setAttributesTypes(attributesTypes19);
        em.persist(attributes10);
        em.flush();

        Attributes attributes11 = new Attributes();
        attributes11.setName("annotationsField");
        attributes11.setNullable(true);
        attributes11.setSingle(false);
//      ...................... Attributes ........................
        Entities entity20 = new Entities();
        entity20 = findBean.nameEntities("Attributes",em);
        attributes11.setEntities(entity20);
//      ...................... String ........................
        AttributesTypes attributesTypes21 = new AttributesTypes();
        attributesTypes21 = findBean.nameAttributesTypes("String",em);
        attributes11.setAttributesTypes(attributesTypes21);
        em.persist(attributes11);
        em.flush();

        Attributes attributes12 = new Attributes();
        attributes12.setName("annotationsMethod");
        attributes12.setNullable(true);
        attributes12.setSingle(false);
//      ...................... Attributes ........................
        Entities entity22 = new Entities();
        entity22 = findBean.nameEntities("Attributes",em);
        attributes12.setEntities(entity22);
//      ...................... String ........................
        AttributesTypes attributesTypes23 = new AttributesTypes();
        attributesTypes23 = findBean.nameAttributesTypes("String",em);
        attributes12.setAttributesTypes(attributesTypes23);
        em.persist(attributes12);
        em.flush();

        Attributes attributes13 = new Attributes();
        attributes13.setName("observations");
        attributes13.setNullable(true);
        attributes13.setSingle(false);
//      ...................... Attributes ........................
        Entities entity24 = new Entities();
        entity24 = findBean.nameEntities("Attributes",em);
        attributes13.setEntities(entity24);
//      ...................... String ........................
        AttributesTypes attributesTypes25 = new AttributesTypes();
        attributesTypes25 = findBean.nameAttributesTypes("String",em);
        attributes13.setAttributesTypes(attributesTypes25);
        em.persist(attributes13);
        em.flush();

        Entities entities14 = new Entities();
        entities14.setName("Cardinalities");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId26 = new GroupIds();
        groupId26 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities14.setGroupIds(groupId26);
        em.persist(entities14);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes15 = new Attributes();
        attributes15.setName("name");
        attributes15.setNullable(false);
        attributes15.setSingle(true);
//      ...................... Cardinalities ........................
        Entities entity27 = new Entities();
        entity27 = findBean.nameEntities("Cardinalities",em);
        attributes15.setEntities(entity27);
//      ...................... String ........................
        AttributesTypes attributesTypes28 = new AttributesTypes();
        attributesTypes28 = findBean.nameAttributesTypes("String",em);
        attributes15.setAttributesTypes(attributesTypes28);
        em.persist(attributes15);
        em.flush();

        Attributes attributes16 = new Attributes();
        attributes16.setName("cardinality");
        attributes16.setNullable(false);
        attributes16.setSingle(false);
//      ...................... Cardinalities ........................
        Entities entity29 = new Entities();
        entity29 = findBean.nameEntities("Cardinalities",em);
        attributes16.setEntities(entity29);
//      ...................... String ........................
        AttributesTypes attributesTypes30 = new AttributesTypes();
        attributesTypes30 = findBean.nameAttributesTypes("String",em);
        attributes16.setAttributesTypes(attributesTypes30);
        em.persist(attributes16);
        em.flush();

        Attributes attributes17 = new Attributes();
        attributes17.setName("unidirectional");
        attributes17.setNullable(true);
        attributes17.setSingle(false);
//      ...................... Cardinalities ........................
        Entities entity31 = new Entities();
        entity31 = findBean.nameEntities("Cardinalities",em);
        attributes17.setEntities(entity31);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes32 = new AttributesTypes();
        attributesTypes32 = findBean.nameAttributesTypes("Boolean",em);
        attributes17.setAttributesTypes(attributesTypes32);
        em.persist(attributes17);
        em.flush();

        Attributes attributes18 = new Attributes();
        attributes18.setName("annotations");
        attributes18.setNullable(true);
        attributes18.setSingle(false);
//      ...................... Cardinalities ........................
        Entities entity33 = new Entities();
        entity33 = findBean.nameEntities("Cardinalities",em);
        attributes18.setEntities(entity33);
//      ...................... String ........................
        AttributesTypes attributesTypes34 = new AttributesTypes();
        attributesTypes34 = findBean.nameAttributesTypes("String",em);
        attributes18.setAttributesTypes(attributesTypes34);
        em.persist(attributes18);
        em.flush();

        Attributes attributes19 = new Attributes();
        attributes19.setName("observations");
        attributes19.setNullable(true);
        attributes19.setSingle(false);
//      ...................... Cardinalities ........................
        Entities entity35 = new Entities();
        entity35 = findBean.nameEntities("Cardinalities",em);
        attributes19.setEntities(entity35);
//      ...................... String ........................
        AttributesTypes attributesTypes36 = new AttributesTypes();
        attributesTypes36 = findBean.nameAttributesTypes("String",em);
        attributes19.setAttributesTypes(attributesTypes36);
        em.persist(attributes19);
        em.flush();

        Entities entities20 = new Entities();
        entities20.setName("Relationships");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId37 = new GroupIds();
        groupId37 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities20.setGroupIds(groupId37);
        em.persist(entities20);
        em.flush();

//      ---------------------- Attributes ------------------------

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
        attributes22.setName("optionality");
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
        attributes23.setName("isEmbedded");
        attributes23.setNullable(true);
        attributes23.setSingle(false);
//      ...................... Relationships ........................
        Entities entity42 = new Entities();
        entity42 = findBean.nameEntities("Relationships",em);
        attributes23.setEntities(entity42);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes43 = new AttributesTypes();
        attributesTypes43 = findBean.nameAttributesTypes("Boolean",em);
        attributes23.setAttributesTypes(attributesTypes43);
        em.persist(attributes23);
        em.flush();

        Attributes attributes24 = new Attributes();
        attributes24.setName("observations");
        attributes24.setNullable(true);
        attributes24.setSingle(false);
//      ...................... Relationships ........................
        Entities entity44 = new Entities();
        entity44 = findBean.nameEntities("Relationships",em);
        attributes24.setEntities(entity44);
//      ...................... String ........................
        AttributesTypes attributesTypes45 = new AttributesTypes();
        attributesTypes45 = findBean.nameAttributesTypes("String",em);
        attributes24.setAttributesTypes(attributesTypes45);
        em.persist(attributes24);
        em.flush();

        Entities entities25 = new Entities();
        entities25.setName("NameQueries");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId46 = new GroupIds();
        groupId46 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities25.setGroupIds(groupId46);
        em.persist(entities25);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes26 = new Attributes();
        attributes26.setName("name");
        attributes26.setNullable(false);
        attributes26.setSingle(true);
//      ...................... NameQueries ........................
        Entities entity47 = new Entities();
        entity47 = findBean.nameEntities("NameQueries",em);
        attributes26.setEntities(entity47);
//      ...................... String ........................
        AttributesTypes attributesTypes48 = new AttributesTypes();
        attributesTypes48 = findBean.nameAttributesTypes("String",em);
        attributes26.setAttributesTypes(attributesTypes48);
        em.persist(attributes26);
        em.flush();

        Attributes attributes27 = new Attributes();
        attributes27.setName("query");
        attributes27.setNullable(false);
        attributes27.setSingle(true);
//      ...................... NameQueries ........................
        Entities entity49 = new Entities();
        entity49 = findBean.nameEntities("NameQueries",em);
        attributes27.setEntities(entity49);
//      ...................... String ........................
        AttributesTypes attributesTypes50 = new AttributesTypes();
        attributesTypes50 = findBean.nameAttributesTypes("String",em);
        attributes27.setAttributesTypes(attributesTypes50);
        em.persist(attributes27);
        em.flush();

        Attributes attributes28 = new Attributes();
        attributes28.setName("observations");
        attributes28.setNullable(true);
        attributes28.setSingle(false);
//      ...................... NameQueries ........................
        Entities entity51 = new Entities();
        entity51 = findBean.nameEntities("NameQueries",em);
        attributes28.setEntities(entity51);
//      ...................... String ........................
        AttributesTypes attributesTypes52 = new AttributesTypes();
        attributesTypes52 = findBean.nameAttributesTypes("String",em);
        attributes28.setAttributesTypes(attributesTypes52);
        em.persist(attributes28);
        em.flush();

        Entities entities29 = new Entities();
        entities29.setName("Developments");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId53 = new GroupIds();
        groupId53 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities29.setGroupIds(groupId53);
        em.persist(entities29);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes30 = new Attributes();
        attributes30.setName("name");
        attributes30.setNullable(false);
        attributes30.setSingle(true);
//      ...................... Developments ........................
        Entities entity54 = new Entities();
        entity54 = findBean.nameEntities("Developments",em);
        attributes30.setEntities(entity54);
//      ...................... String ........................
        AttributesTypes attributesTypes55 = new AttributesTypes();
        attributesTypes55 = findBean.nameAttributesTypes("String",em);
        attributes30.setAttributesTypes(attributesTypes55);
        em.persist(attributes30);
        em.flush();

        Attributes attributes31 = new Attributes();
        attributes31.setName("groupId");
        attributes31.setNullable(false);
        attributes31.setSingle(false);
//      ...................... Developments ........................
        Entities entity56 = new Entities();
        entity56 = findBean.nameEntities("Developments",em);
        attributes31.setEntities(entity56);
//      ...................... String ........................
        AttributesTypes attributesTypes57 = new AttributesTypes();
        attributesTypes57 = findBean.nameAttributesTypes("String",em);
        attributes31.setAttributesTypes(attributesTypes57);
        em.persist(attributes31);
        em.flush();

        Attributes attributes32 = new Attributes();
        attributes32.setName("artifactId");
        attributes32.setNullable(true);
        attributes32.setSingle(true);
//      ...................... Developments ........................
        Entities entity58 = new Entities();
        entity58 = findBean.nameEntities("Developments",em);
        attributes32.setEntities(entity58);
//      ...................... String ........................
        AttributesTypes attributesTypes59 = new AttributesTypes();
        attributesTypes59 = findBean.nameAttributesTypes("String",em);
        attributes32.setAttributesTypes(attributesTypes59);
        em.persist(attributes32);
        em.flush();

        Attributes attributes33 = new Attributes();
        attributes33.setName("version");
        attributes33.setNullable(true);
        attributes33.setSingle(false);
//      ...................... Developments ........................
        Entities entity60 = new Entities();
        entity60 = findBean.nameEntities("Developments",em);
        attributes33.setEntities(entity60);
//      ...................... String ........................
        AttributesTypes attributesTypes61 = new AttributesTypes();
        attributesTypes61 = findBean.nameAttributesTypes("String",em);
        attributes33.setAttributesTypes(attributesTypes61);
        em.persist(attributes33);
        em.flush();

        Attributes attributes34 = new Attributes();
        attributes34.setName("code");
        attributes34.setNullable(true);
        attributes34.setSingle(true);
//      ...................... Developments ........................
        Entities entity62 = new Entities();
        entity62 = findBean.nameEntities("Developments",em);
        attributes34.setEntities(entity62);
//      ...................... String ........................
        AttributesTypes attributesTypes63 = new AttributesTypes();
        attributesTypes63 = findBean.nameAttributesTypes("String",em);
        attributes34.setAttributesTypes(attributesTypes63);
        em.persist(attributes34);
        em.flush();

        Attributes attributes35 = new Attributes();
        attributes35.setName("date");
        attributes35.setNullable(true);
        attributes35.setSingle(false);
//      ...................... Developments ........................
        Entities entity64 = new Entities();
        entity64 = findBean.nameEntities("Developments",em);
        attributes35.setEntities(entity64);
//      ...................... Date ........................
        AttributesTypes attributesTypes65 = new AttributesTypes();
        attributesTypes65 = findBean.nameAttributesTypes("Date",em);
        attributes35.setAttributesTypes(attributesTypes65);
        em.persist(attributes35);
        em.flush();

        Entities entities36 = new Entities();
        entities36.setName("Entities");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId66 = new GroupIds();
        groupId66 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities36.setGroupIds(groupId66);
        em.persist(entities36);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes37 = new Attributes();
        attributes37.setName("name");
        attributes37.setNullable(false);
        attributes37.setSingle(false);
//      ...................... Entities ........................
        Entities entity67 = new Entities();
        entity67 = findBean.nameEntities("Entities",em);
        attributes37.setEntities(entity67);
//      ...................... String ........................
        AttributesTypes attributesTypes68 = new AttributesTypes();
        attributesTypes68 = findBean.nameAttributesTypes("String",em);
        attributes37.setAttributesTypes(attributesTypes68);
        em.persist(attributes37);
        em.flush();

        Attributes attributes38 = new Attributes();
        attributes38.setName("serialID");
        attributes38.setNullable(true);
        attributes38.setSingle(true);
//      ...................... Entities ........................
        Entities entity69 = new Entities();
        entity69 = findBean.nameEntities("Entities",em);
        attributes38.setEntities(entity69);
//      ...................... String ........................
        AttributesTypes attributesTypes70 = new AttributesTypes();
        attributesTypes70 = findBean.nameAttributesTypes("String",em);
        attributes38.setAttributesTypes(attributesTypes70);
        em.persist(attributes38);
        em.flush();

        Attributes attributes39 = new Attributes();
        attributes39.setName("table");
        attributes39.setNullable(true);
        attributes39.setSingle(false);
//      ...................... Entities ........................
        Entities entity71 = new Entities();
        entity71 = findBean.nameEntities("Entities",em);
        attributes39.setEntities(entity71);
//      ...................... String ........................
        AttributesTypes attributesTypes72 = new AttributesTypes();
        attributesTypes72 = findBean.nameAttributesTypes("String",em);
        attributes39.setAttributesTypes(attributesTypes72);
        em.persist(attributes39);
        em.flush();

        Attributes attributes40 = new Attributes();
        attributes40.setName("tableSecuencia");
        attributes40.setNullable(true);
        attributes40.setSingle(false);
//      ...................... Entities ........................
        Entities entity73 = new Entities();
        entity73 = findBean.nameEntities("Entities",em);
        attributes40.setEntities(entity73);
//      ...................... String ........................
        AttributesTypes attributesTypes74 = new AttributesTypes();
        attributesTypes74 = findBean.nameAttributesTypes("String",em);
        attributes40.setAttributesTypes(attributesTypes74);
        em.persist(attributes40);
        em.flush();

        Attributes attributes41 = new Attributes();
        attributes41.setName("modifier");
        attributes41.setNullable(true);
        attributes41.setSingle(false);
//      ...................... Entities ........................
        Entities entity75 = new Entities();
        entity75 = findBean.nameEntities("Entities",em);
        attributes41.setEntities(entity75);
//      ...................... String ........................
        AttributesTypes attributesTypes76 = new AttributesTypes();
        attributesTypes76 = findBean.nameAttributesTypes("String",em);
        attributes41.setAttributesTypes(attributesTypes76);
        em.persist(attributes41);
        em.flush();

        Attributes attributes42 = new Attributes();
        attributes42.setName("extend");
        attributes42.setNullable(true);
        attributes42.setSingle(false);
//      ...................... Entities ........................
        Entities entity77 = new Entities();
        entity77 = findBean.nameEntities("Entities",em);
        attributes42.setEntities(entity77);
//      ...................... String ........................
        AttributesTypes attributesTypes78 = new AttributesTypes();
        attributesTypes78 = findBean.nameAttributesTypes("String",em);
        attributes42.setAttributesTypes(attributesTypes78);
        em.persist(attributes42);
        em.flush();

        Attributes attributes43 = new Attributes();
        attributes43.setName("annotations");
        attributes43.setNullable(true);
        attributes43.setSingle(false);
//      ...................... Entities ........................
        Entities entity79 = new Entities();
        entity79 = findBean.nameEntities("Entities",em);
        attributes43.setEntities(entity79);
//      ...................... String ........................
        AttributesTypes attributesTypes80 = new AttributesTypes();
        attributesTypes80 = findBean.nameAttributesTypes("String",em);
        attributes43.setAttributesTypes(attributesTypes80);
        em.persist(attributes43);
        em.flush();

        Attributes attributes44 = new Attributes();
        attributes44.setName("source");
        attributes44.setNullable(true);
        attributes44.setSingle(false);
//      ...................... Entities ........................
        Entities entity81 = new Entities();
        entity81 = findBean.nameEntities("Entities",em);
        attributes44.setEntities(entity81);
//      ...................... String ........................
        AttributesTypes attributesTypes82 = new AttributesTypes();
        attributesTypes82 = findBean.nameAttributesTypes("String",em);
        attributes44.setAttributesTypes(attributesTypes82);
        em.persist(attributes44);
        em.flush();

        Attributes attributes45 = new Attributes();
        attributes45.setName("description");
        attributes45.setNullable(true);
        attributes45.setSingle(false);
//      ...................... Entities ........................
        Entities entity83 = new Entities();
        entity83 = findBean.nameEntities("Entities",em);
        attributes45.setEntities(entity83);
//      ...................... String ........................
        AttributesTypes attributesTypes84 = new AttributesTypes();
        attributesTypes84 = findBean.nameAttributesTypes("String",em);
        attributes45.setAttributesTypes(attributesTypes84);
        em.persist(attributes45);
        em.flush();

        Attributes attributes46 = new Attributes();
        attributes46.setName("observations");
        attributes46.setNullable(true);
        attributes46.setSingle(false);
//      ...................... Entities ........................
        Entities entity85 = new Entities();
        entity85 = findBean.nameEntities("Entities",em);
        attributes46.setEntities(entity85);
//      ...................... String ........................
        AttributesTypes attributesTypes86 = new AttributesTypes();
        attributesTypes86 = findBean.nameAttributesTypes("String",em);
        attributes46.setAttributesTypes(attributesTypes86);
        em.persist(attributes46);
        em.flush();

        Entities entities47 = new Entities();
        entities47.setName("GroupIds");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId87 = new GroupIds();
        groupId87 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities47.setGroupIds(groupId87);
        em.persist(entities47);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes48 = new Attributes();
        attributes48.setName("name");
        attributes48.setNullable(false);
        attributes48.setSingle(true);
//      ...................... GroupIds ........................
        Entities entity88 = new Entities();
        entity88 = findBean.nameEntities("GroupIds",em);
        attributes48.setEntities(entity88);
//      ...................... String ........................
        AttributesTypes attributesTypes89 = new AttributesTypes();
        attributesTypes89 = findBean.nameAttributesTypes("String",em);
        attributes48.setAttributesTypes(attributesTypes89);
        em.persist(attributes48);
        em.flush();

        Attributes attributes49 = new Attributes();
        attributes49.setName("groupId");
        attributes49.setNullable(false);
        attributes49.setSingle(false);
//      ...................... GroupIds ........................
        Entities entity90 = new Entities();
        entity90 = findBean.nameEntities("GroupIds",em);
        attributes49.setEntities(entity90);
//      ...................... String ........................
        AttributesTypes attributesTypes91 = new AttributesTypes();
        attributesTypes91 = findBean.nameAttributesTypes("String",em);
        attributes49.setAttributesTypes(attributesTypes91);
        em.persist(attributes49);
        em.flush();

        Attributes attributes50 = new Attributes();
        attributes50.setName("artifactId");
        attributes50.setNullable(true);
        attributes50.setSingle(true);
//      ...................... GroupIds ........................
        Entities entity92 = new Entities();
        entity92 = findBean.nameEntities("GroupIds",em);
        attributes50.setEntities(entity92);
//      ...................... String ........................
        AttributesTypes attributesTypes93 = new AttributesTypes();
        attributesTypes93 = findBean.nameAttributesTypes("String",em);
        attributes50.setAttributesTypes(attributesTypes93);
        em.persist(attributes50);
        em.flush();

        Attributes attributes51 = new Attributes();
        attributes51.setName("version");
        attributes51.setNullable(true);
        attributes51.setSingle(false);
//      ...................... GroupIds ........................
        Entities entity94 = new Entities();
        entity94 = findBean.nameEntities("GroupIds",em);
        attributes51.setEntities(entity94);
//      ...................... String ........................
        AttributesTypes attributesTypes95 = new AttributesTypes();
        attributesTypes95 = findBean.nameAttributesTypes("String",em);
        attributes51.setAttributesTypes(attributesTypes95);
        em.persist(attributes51);
        em.flush();

        Attributes attributes52 = new Attributes();
        attributes52.setName("code");
        attributes52.setNullable(true);
        attributes52.setSingle(true);
//      ...................... GroupIds ........................
        Entities entity96 = new Entities();
        entity96 = findBean.nameEntities("GroupIds",em);
        attributes52.setEntities(entity96);
//      ...................... String ........................
        AttributesTypes attributesTypes97 = new AttributesTypes();
        attributesTypes97 = findBean.nameAttributesTypes("String",em);
        attributes52.setAttributesTypes(attributesTypes97);
        em.persist(attributes52);
        em.flush();

        Attributes attributes53 = new Attributes();
        attributes53.setName("date");
        attributes53.setNullable(true);
        attributes53.setSingle(false);
//      ...................... GroupIds ........................
        Entities entity98 = new Entities();
        entity98 = findBean.nameEntities("GroupIds",em);
        attributes53.setEntities(entity98);
//      ...................... Date ........................
        AttributesTypes attributesTypes99 = new AttributesTypes();
        attributesTypes99 = findBean.nameAttributesTypes("Date",em);
        attributes53.setAttributesTypes(attributesTypes99);
        em.persist(attributes53);
        em.flush();

        Entities entities54 = new Entities();
        entities54.setName("Models");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId100 = new GroupIds();
        groupId100 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities54.setGroupIds(groupId100);
        em.persist(entities54);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes55 = new Attributes();
        attributes55.setName("name");
        attributes55.setNullable(false);
        attributes55.setSingle(true);
//      ...................... Models ........................
        Entities entity101 = new Entities();
        entity101 = findBean.nameEntities("Models",em);
        attributes55.setEntities(entity101);
//      ...................... String ........................
        AttributesTypes attributesTypes102 = new AttributesTypes();
        attributesTypes102 = findBean.nameAttributesTypes("String",em);
        attributes55.setAttributesTypes(attributesTypes102);
        em.persist(attributes55);
        em.flush();

        Attributes attributes56 = new Attributes();
        attributes56.setName("groupId");
        attributes56.setNullable(false);
        attributes56.setSingle(false);
//      ...................... Models ........................
        Entities entity103 = new Entities();
        entity103 = findBean.nameEntities("Models",em);
        attributes56.setEntities(entity103);
//      ...................... String ........................
        AttributesTypes attributesTypes104 = new AttributesTypes();
        attributesTypes104 = findBean.nameAttributesTypes("String",em);
        attributes56.setAttributesTypes(attributesTypes104);
        em.persist(attributes56);
        em.flush();

        Attributes attributes57 = new Attributes();
        attributes57.setName("artifactId");
        attributes57.setNullable(true);
        attributes57.setSingle(true);
//      ...................... Models ........................
        Entities entity105 = new Entities();
        entity105 = findBean.nameEntities("Models",em);
        attributes57.setEntities(entity105);
//      ...................... String ........................
        AttributesTypes attributesTypes106 = new AttributesTypes();
        attributesTypes106 = findBean.nameAttributesTypes("String",em);
        attributes57.setAttributesTypes(attributesTypes106);
        em.persist(attributes57);
        em.flush();

        Attributes attributes58 = new Attributes();
        attributes58.setName("version");
        attributes58.setNullable(true);
        attributes58.setSingle(false);
//      ...................... Models ........................
        Entities entity107 = new Entities();
        entity107 = findBean.nameEntities("Models",em);
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
//      ...................... Models ........................
        Entities entity109 = new Entities();
        entity109 = findBean.nameEntities("Models",em);
        attributes59.setEntities(entity109);
//      ...................... String ........................
        AttributesTypes attributesTypes110 = new AttributesTypes();
        attributesTypes110 = findBean.nameAttributesTypes("String",em);
        attributes59.setAttributesTypes(attributesTypes110);
        em.persist(attributes59);
        em.flush();

        Attributes attributes60 = new Attributes();
        attributes60.setName("date");
        attributes60.setNullable(true);
        attributes60.setSingle(false);
//      ...................... Models ........................
        Entities entity111 = new Entities();
        entity111 = findBean.nameEntities("Models",em);
        attributes60.setEntities(entity111);
//      ...................... Date ........................
        AttributesTypes attributesTypes112 = new AttributesTypes();
        attributesTypes112 = findBean.nameAttributesTypes("Date",em);
        attributes60.setAttributesTypes(attributesTypes112);
        em.persist(attributes60);
        em.flush();

//      ---------------------- Entities ------------------------

        Entities entities61 = new Entities();
        entities61.setName("AttributesProperties");
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId113 = new GroupIds();
        groupId113 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities61.setGroupIds(groupId113);
        em.persist(entities61);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes62 = new Attributes();
        attributes62.setName("name");
        attributes62.setNullable(false);
        attributes62.setSingle(true);
//      ...................... AttributesProperties ........................
        Entities entity114 = new Entities();
        entity114 = findBean.nameEntities("AttributesProperties",em);
        attributes62.setEntities(entity114);
//      ...................... String ........................
        AttributesTypes attributesTypes115 = new AttributesTypes();
        attributesTypes115 = findBean.nameAttributesTypes("String",em);
        attributes62.setAttributesTypes(attributesTypes115);
        em.persist(attributes62);
        em.flush();

        Attributes attributes63 = new Attributes();
        attributes63.setName("value");
        attributes63.setNullable(false);
        attributes63.setSingle(true);
//      ...................... AttributesProperties ........................
        Entities entity116 = new Entities();
        entity116 = findBean.nameEntities("AttributesProperties",em);
        attributes63.setEntities(entity116);
//      ...................... String ........................
        AttributesTypes attributesTypes117 = new AttributesTypes();
        attributesTypes117 = findBean.nameAttributesTypes("String",em);
        attributes63.setAttributesTypes(attributesTypes117);
        em.persist(attributes63);
        em.flush();

        Entities entities64 = new Entities();
        entities64.setName("AttributesTypes");
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId118 = new GroupIds();
        groupId118 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities64.setGroupIds(groupId118);
        em.persist(entities64);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes65 = new Attributes();
        attributes65.setName("name");
        attributes65.setNullable(false);
        attributes65.setSingle(true);
//      ...................... AttributesTypes ........................
        Entities entity119 = new Entities();
        entity119 = findBean.nameEntities("AttributesTypes",em);
        attributes65.setEntities(entity119);
//      ...................... String ........................
        AttributesTypes attributesTypes120 = new AttributesTypes();
        attributesTypes120 = findBean.nameAttributesTypes("String",em);
        attributes65.setAttributesTypes(attributesTypes120);
        em.persist(attributes65);
        em.flush();

        Attributes attributes66 = new Attributes();
        attributes66.setName("type");
        attributes66.setNullable(false);
        attributes66.setSingle(false);
//      ...................... AttributesTypes ........................
        Entities entity121 = new Entities();
        entity121 = findBean.nameEntities("AttributesTypes",em);
        attributes66.setEntities(entity121);
//      ...................... String ........................
        AttributesTypes attributesTypes122 = new AttributesTypes();
        attributesTypes122 = findBean.nameAttributesTypes("String",em);
        attributes66.setAttributesTypes(attributesTypes122);
        em.persist(attributes66);
        em.flush();

        Attributes attributes67 = new Attributes();
        attributes67.setName("length");
        attributes67.setNullable(true);
        attributes67.setSingle(false);
//      ...................... AttributesTypes ........................
        Entities entity123 = new Entities();
        entity123 = findBean.nameEntities("AttributesTypes",em);
        attributes67.setEntities(entity123);
//      ...................... Integer ........................
        AttributesTypes attributesTypes124 = new AttributesTypes();
        attributesTypes124 = findBean.nameAttributesTypes("Integer",em);
        attributes67.setAttributesTypes(attributesTypes124);
        em.persist(attributes67);
        em.flush();

        Attributes attributes68 = new Attributes();
        attributes68.setName("precision");
        attributes68.setNullable(true);
        attributes68.setSingle(false);
//      ...................... AttributesTypes ........................
        Entities entity125 = new Entities();
        entity125 = findBean.nameEntities("AttributesTypes",em);
        attributes68.setEntities(entity125);
//      ...................... Integer ........................
        AttributesTypes attributesTypes126 = new AttributesTypes();
        attributesTypes126 = findBean.nameAttributesTypes("Integer",em);
        attributes68.setAttributesTypes(attributesTypes126);
        em.persist(attributes68);
        em.flush();

        Attributes attributes69 = new Attributes();
        attributes69.setName("annotations");
        attributes69.setNullable(true);
        attributes69.setSingle(false);
//      ...................... AttributesTypes ........................
        Entities entity127 = new Entities();
        entity127 = findBean.nameEntities("AttributesTypes",em);
        attributes69.setEntities(entity127);
//      ...................... String ........................
        AttributesTypes attributesTypes128 = new AttributesTypes();
        attributesTypes128 = findBean.nameAttributesTypes("String",em);
        attributes69.setAttributesTypes(attributesTypes128);
        em.persist(attributes69);
        em.flush();

        Entities entities70 = new Entities();
        entities70.setName("Imports");
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId129 = new GroupIds();
        groupId129 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities70.setGroupIds(groupId129);
        em.persist(entities70);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes71 = new Attributes();
        attributes71.setName("name");
        attributes71.setNullable(false);
        attributes71.setSingle(true);
//      ...................... Imports ........................
        Entities entity130 = new Entities();
        entity130 = findBean.nameEntities("Imports",em);
        attributes71.setEntities(entity130);
//      ...................... String ........................
        AttributesTypes attributesTypes131 = new AttributesTypes();
        attributesTypes131 = findBean.nameAttributesTypes("String",em);
        attributes71.setAttributesTypes(attributesTypes131);
        em.persist(attributes71);
        em.flush();

        Entities entities72 = new Entities();
        entities72.setName("Dependencies");
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId132 = new GroupIds();
        groupId132 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities72.setGroupIds(groupId132);
        em.persist(entities72);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes73 = new Attributes();
        attributes73.setName("groupId");
        attributes73.setNullable(false);
        attributes73.setSingle(false);
//      ...................... Dependencies ........................
        Entities entity133 = new Entities();
        entity133 = findBean.nameEntities("Dependencies",em);
        attributes73.setEntities(entity133);
//      ...................... String ........................
        AttributesTypes attributesTypes134 = new AttributesTypes();
        attributesTypes134 = findBean.nameAttributesTypes("String",em);
        attributes73.setAttributesTypes(attributesTypes134);
        em.persist(attributes73);
        em.flush();

        Attributes attributes74 = new Attributes();
        attributes74.setName("artifactId");
        attributes74.setNullable(false);
        attributes74.setSingle(false);
//      ...................... Dependencies ........................
        Entities entity135 = new Entities();
        entity135 = findBean.nameEntities("Dependencies",em);
        attributes74.setEntities(entity135);
//      ...................... String ........................
        AttributesTypes attributesTypes136 = new AttributesTypes();
        attributesTypes136 = findBean.nameAttributesTypes("String",em);
        attributes74.setAttributesTypes(attributesTypes136);
        em.persist(attributes74);
        em.flush();

        Attributes attributes75 = new Attributes();
        attributes75.setName("version");
        attributes75.setNullable(true);
        attributes75.setSingle(false);
//      ...................... Dependencies ........................
        Entities entity137 = new Entities();
        entity137 = findBean.nameEntities("Dependencies",em);
        attributes75.setEntities(entity137);
//      ...................... String ........................
        AttributesTypes attributesTypes138 = new AttributesTypes();
        attributesTypes138 = findBean.nameAttributesTypes("String",em);
        attributes75.setAttributesTypes(attributesTypes138);
        em.persist(attributes75);
        em.flush();

        Attributes attributes76 = new Attributes();
        attributes76.setName("type");
        attributes76.setNullable(true);
        attributes76.setSingle(false);
//      ...................... Dependencies ........................
        Entities entity139 = new Entities();
        entity139 = findBean.nameEntities("Dependencies",em);
        attributes76.setEntities(entity139);
//      ...................... String ........................
        AttributesTypes attributesTypes140 = new AttributesTypes();
        attributesTypes140 = findBean.nameAttributesTypes("String",em);
        attributes76.setAttributesTypes(attributesTypes140);
        em.persist(attributes76);
        em.flush();

        Attributes attributes77 = new Attributes();
        attributes77.setName("scope");
        attributes77.setNullable(true);
        attributes77.setSingle(false);
//      ...................... Dependencies ........................
        Entities entity141 = new Entities();
        entity141 = findBean.nameEntities("Dependencies",em);
        attributes77.setEntities(entity141);
//      ...................... String ........................
        AttributesTypes attributesTypes142 = new AttributesTypes();
        attributesTypes142 = findBean.nameAttributesTypes("String",em);
        attributes77.setAttributesTypes(attributesTypes142);
        em.persist(attributes77);
        em.flush();

        Attributes attributes78 = new Attributes();
        attributes78.setName("maven");
        attributes78.setNullable(false);
        attributes78.setSingle(true);
//      ...................... Dependencies ........................
        Entities entity143 = new Entities();
        entity143 = findBean.nameEntities("Dependencies",em);
        attributes78.setEntities(entity143);
//      ...................... String ........................
        AttributesTypes attributesTypes144 = new AttributesTypes();
        attributesTypes144 = findBean.nameAttributesTypes("String",em);
        attributes78.setAttributesTypes(attributesTypes144);
        em.persist(attributes78);
        em.flush();

//      ---------------------- Entities ------------------------

//      ---------------------- Entities ------------------------

//      ---------------------- Entities ------------------------

//      ---------------------- Relationships ------------------------

/*
. AttributesProperties . *..* Imports rolA:from rolB: OK

. Dependencies . 1..* Imports rolA: rolB:

. AttributesTypes . *..* AttributesProperties rolA:from rolB: OK

*/
        Relationships relationships1 = new Relationships();
        relationships1.setOptionality(true);
        relationships1.setIsEmbedded(false);
//      ...................... AttributesProperties ........................
        Entities entities145 = new Entities();
        entities145 = findBean.nameEntities("AttributesProperties",em);
        relationships1.setFrom(entities145);
//      ...................... Imports ........................
        Entities entities146 = new Entities();
        entities146 = findBean.nameEntities("Imports",em);
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
//      ...................... Dependencies ........................
        Entities entities148 = new Entities();
        entities148 = findBean.nameEntities("Dependencies",em);
        relationships2.setFrom(entities148);
//      ...................... Imports ........................
        Entities entities149 = new Entities();
        entities149 = findBean.nameEntities("Imports",em);
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
//      ...................... AttributesTypes ........................
        Entities entities151 = new Entities();
        entities151 = findBean.nameEntities("AttributesTypes",em);
        relationships3.setFrom(entities151);
//      ...................... AttributesProperties ........................
        Entities entities152 = new Entities();
        entities152 = findBean.nameEntities("AttributesProperties",em);
        relationships3.setTo(entities152);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities153 = new Cardinalities();
        cardinalities153 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships3.setCardinalities(cardinalities153);
        em.persist(relationships3);
        em.flush();

/*
*/
/*
*/
/*
. Relationships . *..* AttributesProperties rolA:from rolB: OK

. Entities . *..* Imports rolA:from rolB: OK

. Relationships . 1..* Chapters rolA: rolB:

. AttributesProperties . 1..* Chapters rolA: rolB:

. Developments . 1..* Series rolA: rolB:

. Cardinalities . *..* Imports rolA:from rolB: OK

. Developments . 1..* Chapters rolA: rolB:

. Attributes . *..* AttributesProperties rolA:from rolB: OK

. Cardinalities . 1..* Chapters rolA: rolB:

. AttributesTypes . 1..* Attributes rolA: rolB:

. Models . 1..* Series rolA: rolB:

. Companies . 1..* Developments rolA: rolB:

. Entities . 1..* Series rolA: rolB:

. Models . 1..* Chapters rolA: rolB:

*/
        Relationships relationships4 = new Relationships();
        relationships4.setOptionality(true);
        relationships4.setIsEmbedded(false);
//      ...................... Relationships ........................
        Entities entities154 = new Entities();
        entities154 = findBean.nameEntities("Relationships",em);
        relationships4.setFrom(entities154);
//      ...................... AttributesProperties ........................
        Entities entities155 = new Entities();
        entities155 = findBean.nameEntities("AttributesProperties",em);
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
//      ...................... Entities ........................
        Entities entities157 = new Entities();
        entities157 = findBean.nameEntities("Entities",em);
        relationships5.setFrom(entities157);
//      ...................... Imports ........................
        Entities entities158 = new Entities();
        entities158 = findBean.nameEntities("Imports",em);
        relationships5.setTo(entities158);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities159 = new Cardinalities();
        cardinalities159 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships5.setCardinalities(cardinalities159);
        em.persist(relationships5);
        em.flush();

        Relationships relationships6 = new Relationships();
        relationships6.setOptionality(true);
        relationships6.setIsEmbedded(false);
//      ...................... Relationships ........................
        Entities entities160 = new Entities();
        entities160 = findBean.nameEntities("Relationships",em);
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
//      ...................... AttributesProperties ........................
        Entities entities163 = new Entities();
        entities163 = findBean.nameEntities("AttributesProperties",em);
        relationships7.setFrom(entities163);
//      ...................... Chapters ........................
        Entities entities164 = new Entities();
        entities164 = findBean.nameEntities("Chapters",em);
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
//      ...................... Developments ........................
        Entities entities166 = new Entities();
        entities166 = findBean.nameEntities("Developments",em);
        relationships8.setFrom(entities166);
//      ...................... Series ........................
        Entities entities167 = new Entities();
        entities167 = findBean.nameEntities("Series",em);
        relationships8.setTo(entities167);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities168 = new Cardinalities();
        cardinalities168 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships8.setCardinalities(cardinalities168);
        em.persist(relationships8);
        em.flush();

        Relationships relationships9 = new Relationships();
        relationships9.setOptionality(true);
        relationships9.setIsEmbedded(false);
//      ...................... Cardinalities ........................
        Entities entities169 = new Entities();
        entities169 = findBean.nameEntities("Cardinalities",em);
        relationships9.setFrom(entities169);
//      ...................... Imports ........................
        Entities entities170 = new Entities();
        entities170 = findBean.nameEntities("Imports",em);
        relationships9.setTo(entities170);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities171 = new Cardinalities();
        cardinalities171 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships9.setCardinalities(cardinalities171);
        em.persist(relationships9);
        em.flush();

        Relationships relationships10 = new Relationships();
        relationships10.setOptionality(true);
        relationships10.setIsEmbedded(false);
//      ...................... Developments ........................
        Entities entities172 = new Entities();
        entities172 = findBean.nameEntities("Developments",em);
        relationships10.setFrom(entities172);
//      ...................... Chapters ........................
        Entities entities173 = new Entities();
        entities173 = findBean.nameEntities("Chapters",em);
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
//      ...................... Attributes ........................
        Entities entities175 = new Entities();
        entities175 = findBean.nameEntities("Attributes",em);
        relationships11.setFrom(entities175);
//      ...................... AttributesProperties ........................
        Entities entities176 = new Entities();
        entities176 = findBean.nameEntities("AttributesProperties",em);
        relationships11.setTo(entities176);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities177 = new Cardinalities();
        cardinalities177 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships11.setCardinalities(cardinalities177);
        em.persist(relationships11);
        em.flush();

        Relationships relationships12 = new Relationships();
        relationships12.setOptionality(true);
        relationships12.setIsEmbedded(false);
//      ...................... Cardinalities ........................
        Entities entities178 = new Entities();
        entities178 = findBean.nameEntities("Cardinalities",em);
        relationships12.setFrom(entities178);
//      ...................... Chapters ........................
        Entities entities179 = new Entities();
        entities179 = findBean.nameEntities("Chapters",em);
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
//      ...................... AttributesTypes ........................
        Entities entities181 = new Entities();
        entities181 = findBean.nameEntities("AttributesTypes",em);
        relationships13.setFrom(entities181);
//      ...................... Attributes ........................
        Entities entities182 = new Entities();
        entities182 = findBean.nameEntities("Attributes",em);
        relationships13.setTo(entities182);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities183 = new Cardinalities();
        cardinalities183 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships13.setCardinalities(cardinalities183);
        em.persist(relationships13);
        em.flush();

        Relationships relationships14 = new Relationships();
        relationships14.setOptionality(true);
        relationships14.setIsEmbedded(false);
//      ...................... Models ........................
        Entities entities184 = new Entities();
        entities184 = findBean.nameEntities("Models",em);
        relationships14.setFrom(entities184);
//      ...................... Series ........................
        Entities entities185 = new Entities();
        entities185 = findBean.nameEntities("Series",em);
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
//      ...................... Companies ........................
        Entities entities187 = new Entities();
        entities187 = findBean.nameEntities("Companies",em);
        relationships15.setFrom(entities187);
//      ...................... Developments ........................
        Entities entities188 = new Entities();
        entities188 = findBean.nameEntities("Developments",em);
        relationships15.setTo(entities188);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities189 = new Cardinalities();
        cardinalities189 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships15.setCardinalities(cardinalities189);
        em.persist(relationships15);
        em.flush();

        Relationships relationships16 = new Relationships();
        relationships16.setOptionality(true);
        relationships16.setIsEmbedded(false);
//      ...................... Entities ........................
        Entities entities190 = new Entities();
        entities190 = findBean.nameEntities("Entities",em);
        relationships16.setFrom(entities190);
//      ...................... Series ........................
        Entities entities191 = new Entities();
        entities191 = findBean.nameEntities("Series",em);
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
//      ...................... Models ........................
        Entities entities193 = new Entities();
        entities193 = findBean.nameEntities("Models",em);
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

/*
. Entities . 1..* Relationships rolA: rolB:

. GroupIds . 1..* Entities rolA: rolB:

. Models . 1..* GroupIds rolA: rolB:

. Entities . 1..* Relationships rolA: rolB:

. Entities . 1..* Attributes rolA: rolB:

. Cardinalities . 1..* Relationships rolA: rolB:

. Developments . *..* Models rolA: rolB:

. Entities . 1..* NameQueries rolA: rolB:

. Models . *..* Developments rolA: rolB:

*/
        Relationships relationships18 = new Relationships();
        relationships18.setOptionality(true);
        relationships18.setIsEmbedded(false);
//      ...................... Entities ........................
        Entities entities196 = new Entities();
        entities196 = findBean.nameEntities("Entities",em);
        relationships18.setFrom(entities196);
//      ...................... Relationships ........................
        Entities entities197 = new Entities();
        entities197 = findBean.nameEntities("Relationships",em);
        relationships18.setTo(entities197);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities198 = new Cardinalities();
        cardinalities198 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships18.setCardinalities(cardinalities198);
        em.persist(relationships18);
        em.flush();

        Relationships relationships19 = new Relationships();
        relationships19.setOptionality(true);
        relationships19.setIsEmbedded(false);
//      ...................... GroupIds ........................
        Entities entities199 = new Entities();
        entities199 = findBean.nameEntities("GroupIds",em);
        relationships19.setFrom(entities199);
//      ...................... Entities ........................
        Entities entities200 = new Entities();
        entities200 = findBean.nameEntities("Entities",em);
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
//      ...................... Models ........................
        Entities entities202 = new Entities();
        entities202 = findBean.nameEntities("Models",em);
        relationships20.setFrom(entities202);
//      ...................... GroupIds ........................
        Entities entities203 = new Entities();
        entities203 = findBean.nameEntities("GroupIds",em);
        relationships20.setTo(entities203);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities204 = new Cardinalities();
        cardinalities204 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships20.setCardinalities(cardinalities204);
        em.persist(relationships20);
        em.flush();

        Relationships relationships21 = new Relationships();
        relationships21.setOptionality(true);
        relationships21.setIsEmbedded(false);
//      ...................... Entities ........................
        Entities entities205 = new Entities();
        entities205 = findBean.nameEntities("Entities",em);
        relationships21.setFrom(entities205);
//      ...................... Relationships ........................
        Entities entities206 = new Entities();
        entities206 = findBean.nameEntities("Relationships",em);
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
//      ...................... Entities ........................
        Entities entities208 = new Entities();
        entities208 = findBean.nameEntities("Entities",em);
        relationships22.setFrom(entities208);
//      ...................... Attributes ........................
        Entities entities209 = new Entities();
        entities209 = findBean.nameEntities("Attributes",em);
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
//      ...................... Cardinalities ........................
        Entities entities211 = new Entities();
        entities211 = findBean.nameEntities("Cardinalities",em);
        relationships23.setFrom(entities211);
//      ...................... Relationships ........................
        Entities entities212 = new Entities();
        entities212 = findBean.nameEntities("Relationships",em);
        relationships23.setTo(entities212);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities213 = new Cardinalities();
        cardinalities213 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships23.setCardinalities(cardinalities213);
        em.persist(relationships23);
        em.flush();

        Relationships relationships24 = new Relationships();
        relationships24.setOptionality(true);
        relationships24.setIsEmbedded(false);
//      ...................... Developments ........................
        Entities entities214 = new Entities();
        entities214 = findBean.nameEntities("Developments",em);
        relationships24.setFrom(entities214);
//      ...................... Models ........................
        Entities entities215 = new Entities();
        entities215 = findBean.nameEntities("Models",em);
        relationships24.setTo(entities215);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities216 = new Cardinalities();
        cardinalities216 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships24.setCardinalities(cardinalities216);
        em.persist(relationships24);
        em.flush();

        Relationships relationships25 = new Relationships();
        relationships25.setOptionality(true);
        relationships25.setIsEmbedded(false);
//      ...................... Entities ........................
        Entities entities217 = new Entities();
        entities217 = findBean.nameEntities("Entities",em);
        relationships25.setFrom(entities217);
//      ...................... NameQueries ........................
        Entities entities218 = new Entities();
        entities218 = findBean.nameEntities("NameQueries",em);
        relationships25.setTo(entities218);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities219 = new Cardinalities();
        cardinalities219 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships25.setCardinalities(cardinalities219);
        em.persist(relationships25);
        em.flush();

        Relationships relationships26 = new Relationships();
        relationships26.setOptionality(true);
        relationships26.setIsEmbedded(false);
//      ...................... Models ........................
        Entities entities220 = new Entities();
        entities220 = findBean.nameEntities("Models",em);
        relationships26.setFrom(entities220);
//      ...................... Developments ........................
        Entities entities221 = new Entities();
        entities221 = findBean.nameEntities("Developments",em);
        relationships26.setTo(entities221);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities222 = new Cardinalities();
        cardinalities222 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships26.setCardinalities(cardinalities222);
        em.persist(relationships26);
        em.flush();

/*
. Dependencies . 1..* Chapters rolA: rolB:

. AttributesProperties . 1..* Chapters rolA: rolB:

. Imports . 1..* Sites rolA: rolB:

. Imports . 1..* Chapters rolA: rolB:

. AttributesTypes . 1..* Sites rolA: rolB:

. Dependencies . 1..* Sites rolA: rolB:

. AttributesTypes . 1..* Chapters rolA: rolB:

. AttributesProperties . 1..* Sites rolA: rolB:

*/
        Relationships relationships27 = new Relationships();
        relationships27.setOptionality(true);
        relationships27.setIsEmbedded(false);
//      ...................... Dependencies ........................
        Entities entities223 = new Entities();
        entities223 = findBean.nameEntities("Dependencies",em);
        relationships27.setFrom(entities223);
//      ...................... Chapters ........................
        Entities entities224 = new Entities();
        entities224 = findBean.nameEntities("Chapters",em);
        relationships27.setTo(entities224);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities225 = new Cardinalities();
        cardinalities225 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships27.setCardinalities(cardinalities225);
        em.persist(relationships27);
        em.flush();

        Relationships relationships28 = new Relationships();
        relationships28.setOptionality(true);
        relationships28.setIsEmbedded(false);
//      ...................... AttributesProperties ........................
        Entities entities226 = new Entities();
        entities226 = findBean.nameEntities("AttributesProperties",em);
        relationships28.setFrom(entities226);
//      ...................... Chapters ........................
        Entities entities227 = new Entities();
        entities227 = findBean.nameEntities("Chapters",em);
        relationships28.setTo(entities227);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities228 = new Cardinalities();
        cardinalities228 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships28.setCardinalities(cardinalities228);
        em.persist(relationships28);
        em.flush();

        Relationships relationships29 = new Relationships();
        relationships29.setOptionality(true);
        relationships29.setIsEmbedded(false);
//      ...................... Imports ........................
        Entities entities229 = new Entities();
        entities229 = findBean.nameEntities("Imports",em);
        relationships29.setFrom(entities229);
//      ...................... Sites ........................
        Entities entities230 = new Entities();
        entities230 = findBean.nameEntities("Sites",em);
        relationships29.setTo(entities230);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities231 = new Cardinalities();
        cardinalities231 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships29.setCardinalities(cardinalities231);
        em.persist(relationships29);
        em.flush();

        Relationships relationships30 = new Relationships();
        relationships30.setOptionality(true);
        relationships30.setIsEmbedded(false);
//      ...................... Imports ........................
        Entities entities232 = new Entities();
        entities232 = findBean.nameEntities("Imports",em);
        relationships30.setFrom(entities232);
//      ...................... Chapters ........................
        Entities entities233 = new Entities();
        entities233 = findBean.nameEntities("Chapters",em);
        relationships30.setTo(entities233);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities234 = new Cardinalities();
        cardinalities234 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships30.setCardinalities(cardinalities234);
        em.persist(relationships30);
        em.flush();

        Relationships relationships31 = new Relationships();
        relationships31.setOptionality(true);
        relationships31.setIsEmbedded(false);
//      ...................... AttributesTypes ........................
        Entities entities235 = new Entities();
        entities235 = findBean.nameEntities("AttributesTypes",em);
        relationships31.setFrom(entities235);
//      ...................... Sites ........................
        Entities entities236 = new Entities();
        entities236 = findBean.nameEntities("Sites",em);
        relationships31.setTo(entities236);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities237 = new Cardinalities();
        cardinalities237 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships31.setCardinalities(cardinalities237);
        em.persist(relationships31);
        em.flush();

        Relationships relationships32 = new Relationships();
        relationships32.setOptionality(true);
        relationships32.setIsEmbedded(false);
//      ...................... Dependencies ........................
        Entities entities238 = new Entities();
        entities238 = findBean.nameEntities("Dependencies",em);
        relationships32.setFrom(entities238);
//      ...................... Sites ........................
        Entities entities239 = new Entities();
        entities239 = findBean.nameEntities("Sites",em);
        relationships32.setTo(entities239);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities240 = new Cardinalities();
        cardinalities240 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships32.setCardinalities(cardinalities240);
        em.persist(relationships32);
        em.flush();

        Relationships relationships33 = new Relationships();
        relationships33.setOptionality(true);
        relationships33.setIsEmbedded(false);
//      ...................... AttributesTypes ........................
        Entities entities241 = new Entities();
        entities241 = findBean.nameEntities("AttributesTypes",em);
        relationships33.setFrom(entities241);
//      ...................... Chapters ........................
        Entities entities242 = new Entities();
        entities242 = findBean.nameEntities("Chapters",em);
        relationships33.setTo(entities242);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities243 = new Cardinalities();
        cardinalities243 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships33.setCardinalities(cardinalities243);
        em.persist(relationships33);
        em.flush();

        Relationships relationships34 = new Relationships();
        relationships34.setOptionality(true);
        relationships34.setIsEmbedded(false);
//      ...................... AttributesProperties ........................
        Entities entities244 = new Entities();
        entities244 = findBean.nameEntities("AttributesProperties",em);
        relationships34.setFrom(entities244);
//      ...................... Sites ........................
        Entities entities245 = new Entities();
        entities245 = findBean.nameEntities("Sites",em);
        relationships34.setTo(entities245);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities246 = new Cardinalities();
        cardinalities246 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships34.setCardinalities(cardinalities246);
        em.persist(relationships34);
        em.flush();

    } // data()

} // naifg
