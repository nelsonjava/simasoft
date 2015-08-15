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
        groupIds1.setName("co.simasoft.models.dev.naifg");
        em.persist(groupIds1);
        em.flush();

        GroupIds groupIds2 = new GroupIds();
        groupIds2.setArtifactId("co.simasoft.models.dev.naifg.dependencies");
        groupIds2.setGroupId("co.simasoft.models.dev.naifg.dependencies");
        groupIds2.setName("co.simasoft.models.dev.naifg.dependencies");
        em.persist(groupIds2);
        em.flush();

        GroupIds groupIds3 = new GroupIds();
        groupIds3.setArtifactId("co.simasoft.models.dev.naifg.sites");
        groupIds3.setGroupId("co.simasoft.models.dev.naifg.sites");
        groupIds3.setName("co.simasoft.models.dev.naifg.sites");
        em.persist(groupIds3);
        em.flush();

//      ---------------------- Models ------------------------

        Models models = new Models();
        models.setArtifactId("naifg");
        models.setGroupId("co.simasoft.naifg.naifg");
        models.setVersion("1.0-SNAPSHOT");
        models.setName("naifg");

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
        entities1.setName("NameQueries");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId1 = new GroupIds();
        groupId1 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities1.setGroupIds(groupId1);
        em.persist(entities1);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes2 = new Attributes();
        attributes2.setName("query");
        attributes2.setIsNullable(false);
        attributes2.setIsUnique(true);
//      ...................... NameQueries ........................
        Entities entity2 = new Entities();
        entity2 = findBean.nameEntities("NameQueries",em);
        attributes2.setEntities(entity2);
//      ...................... String ........................
        AttributesTypes attributesTypes3 = new AttributesTypes();
        attributesTypes3 = findBean.nameAttributesTypes("String",em);
        attributes2.setAttributesTypes(attributesTypes3);
        em.persist(attributes2);
        em.flush();

        Attributes attributes3 = new Attributes();
        attributes3.setName("name");
        attributes3.setIsNullable(false);
        attributes3.setIsUnique(true);
//      ...................... NameQueries ........................
        Entities entity4 = new Entities();
        entity4 = findBean.nameEntities("NameQueries",em);
        attributes3.setEntities(entity4);
//      ...................... String ........................
        AttributesTypes attributesTypes5 = new AttributesTypes();
        attributesTypes5 = findBean.nameAttributesTypes("String",em);
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
        attributes5.setName("artifactId");
        attributes5.setIsNullable(false);
        attributes5.setIsUnique(true);
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
        attributes6.setName("groupId");
        attributes6.setIsNullable(false);
        attributes6.setIsUnique(true);
//      ...................... Models ........................
        Entities entity9 = new Entities();
        entity9 = findBean.nameEntities("Models",em);
        attributes6.setEntities(entity9);
//      ...................... String ........................
        AttributesTypes attributesTypes10 = new AttributesTypes();
        attributesTypes10 = findBean.nameAttributesTypes("String",em);
        attributes6.setAttributesTypes(attributesTypes10);
        em.persist(attributes6);
        em.flush();

        Attributes attributes7 = new Attributes();
        attributes7.setName("code");
        attributes7.setIsNullable(true);
        attributes7.setIsUnique(false);
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
        attributes8.setName("version");
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
        attributes9.setName("date");
        attributes9.setIsNullable(true);
        attributes9.setIsUnique(false);
//      ...................... Models ........................
        Entities entity15 = new Entities();
        entity15 = findBean.nameEntities("Models",em);
        attributes9.setEntities(entity15);
//      ...................... Date ........................
        AttributesTypes attributesTypes16 = new AttributesTypes();
        attributesTypes16 = findBean.nameAttributesTypes("Date",em);
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
        attributes11.setName("groupId");
        attributes11.setIsNullable(false);
        attributes11.setIsUnique(true);
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
        attributes12.setName("date");
        attributes12.setIsNullable(true);
        attributes12.setIsUnique(false);
//      ...................... GroupIds ........................
        Entities entity20 = new Entities();
        entity20 = findBean.nameEntities("GroupIds",em);
        attributes12.setEntities(entity20);
//      ...................... Date ........................
        AttributesTypes attributesTypes21 = new AttributesTypes();
        attributesTypes21 = findBean.nameAttributesTypes("Date",em);
        attributes12.setAttributesTypes(attributesTypes21);
        em.persist(attributes12);
        em.flush();

        Attributes attributes13 = new Attributes();
        attributes13.setName("code");
        attributes13.setIsNullable(true);
        attributes13.setIsUnique(false);
//      ...................... GroupIds ........................
        Entities entity22 = new Entities();
        entity22 = findBean.nameEntities("GroupIds",em);
        attributes13.setEntities(entity22);
//      ...................... String ........................
        AttributesTypes attributesTypes23 = new AttributesTypes();
        attributesTypes23 = findBean.nameAttributesTypes("String",em);
        attributes13.setAttributesTypes(attributesTypes23);
        em.persist(attributes13);
        em.flush();

        Attributes attributes14 = new Attributes();
        attributes14.setName("version");
        attributes14.setIsNullable(true);
        attributes14.setIsUnique(false);
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
        attributes15.setName("artifactId");
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
        entities16.setName("Relationships");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId28 = new GroupIds();
        groupId28 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities16.setGroupIds(groupId28);
        em.persist(entities16);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes17 = new Attributes();
        attributes17.setName("name");
        attributes17.setIsNullable(true);
        attributes17.setIsUnique(false);
//      ...................... Relationships ........................
        Entities entity29 = new Entities();
        entity29 = findBean.nameEntities("Relationships",em);
        attributes17.setEntities(entity29);
//      ...................... String ........................
        AttributesTypes attributesTypes30 = new AttributesTypes();
        attributesTypes30 = findBean.nameAttributesTypes("String",em);
        attributes17.setAttributesTypes(attributesTypes30);
        em.persist(attributes17);
        em.flush();

        Attributes attributes18 = new Attributes();
        attributes18.setName("isOptionality");
        attributes18.setIsNullable(true);
        attributes18.setIsUnique(false);
//      ...................... Relationships ........................
        Entities entity31 = new Entities();
        entity31 = findBean.nameEntities("Relationships",em);
        attributes18.setEntities(entity31);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes32 = new AttributesTypes();
        attributesTypes32 = findBean.nameAttributesTypes("Boolean",em);
        attributes18.setAttributesTypes(attributesTypes32);
        em.persist(attributes18);
        em.flush();

        Attributes attributes19 = new Attributes();
        attributes19.setName("isEmbedded");
        attributes19.setIsNullable(true);
        attributes19.setIsUnique(false);
//      ...................... Relationships ........................
        Entities entity33 = new Entities();
        entity33 = findBean.nameEntities("Relationships",em);
        attributes19.setEntities(entity33);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes34 = new AttributesTypes();
        attributesTypes34 = findBean.nameAttributesTypes("Boolean",em);
        attributes19.setAttributesTypes(attributesTypes34);
        em.persist(attributes19);
        em.flush();

        Attributes attributes20 = new Attributes();
        attributes20.setName("isSimplified");
        attributes20.setIsNullable(true);
        attributes20.setIsUnique(false);
//      ...................... Relationships ........................
        Entities entity35 = new Entities();
        entity35 = findBean.nameEntities("Relationships",em);
        attributes20.setEntities(entity35);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes36 = new AttributesTypes();
        attributesTypes36 = findBean.nameAttributesTypes("Boolean",em);
        attributes20.setAttributesTypes(attributesTypes36);
        em.persist(attributes20);
        em.flush();

        Entities entities21 = new Entities();
        entities21.setName("Entities");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId37 = new GroupIds();
        groupId37 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities21.setGroupIds(groupId37);
        em.persist(entities21);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes22 = new Attributes();
        attributes22.setName("name");
        attributes22.setIsNullable(false);
        attributes22.setIsUnique(true);
//      ...................... Entities ........................
        Entities entity38 = new Entities();
        entity38 = findBean.nameEntities("Entities",em);
        attributes22.setEntities(entity38);
//      ...................... String ........................
        AttributesTypes attributesTypes39 = new AttributesTypes();
        attributesTypes39 = findBean.nameAttributesTypes("String",em);
        attributes22.setAttributesTypes(attributesTypes39);
        em.persist(attributes22);
        em.flush();

        Attributes attributes23 = new Attributes();
        attributes23.setName("table");
        attributes23.setIsNullable(true);
        attributes23.setIsUnique(false);
//      ...................... Entities ........................
        Entities entity40 = new Entities();
        entity40 = findBean.nameEntities("Entities",em);
        attributes23.setEntities(entity40);
//      ...................... String ........................
        AttributesTypes attributesTypes41 = new AttributesTypes();
        attributesTypes41 = findBean.nameAttributesTypes("String",em);
        attributes23.setAttributesTypes(attributesTypes41);
        em.persist(attributes23);
        em.flush();

        Attributes attributes24 = new Attributes();
        attributes24.setName("serialID");
        attributes24.setIsNullable(true);
        attributes24.setIsUnique(false);
//      ...................... Entities ........................
        Entities entity42 = new Entities();
        entity42 = findBean.nameEntities("Entities",em);
        attributes24.setEntities(entity42);
//      ...................... String ........................
        AttributesTypes attributesTypes43 = new AttributesTypes();
        attributesTypes43 = findBean.nameAttributesTypes("String",em);
        attributes24.setAttributesTypes(attributesTypes43);
        em.persist(attributes24);
        em.flush();

        Attributes attributes25 = new Attributes();
        attributes25.setName("description");
        attributes25.setIsNullable(true);
        attributes25.setIsUnique(false);
//      ...................... Entities ........................
        Entities entity44 = new Entities();
        entity44 = findBean.nameEntities("Entities",em);
        attributes25.setEntities(entity44);
//      ...................... String ........................
        AttributesTypes attributesTypes45 = new AttributesTypes();
        attributesTypes45 = findBean.nameAttributesTypes("String",em);
        attributes25.setAttributesTypes(attributesTypes45);
        em.persist(attributes25);
        em.flush();

        Attributes attributes26 = new Attributes();
        attributes26.setName("isSimplified");
        attributes26.setIsNullable(true);
        attributes26.setIsUnique(false);
//      ...................... Entities ........................
        Entities entity46 = new Entities();
        entity46 = findBean.nameEntities("Entities",em);
        attributes26.setEntities(entity46);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes47 = new AttributesTypes();
        attributesTypes47 = findBean.nameAttributesTypes("Boolean",em);
        attributes26.setAttributesTypes(attributesTypes47);
        em.persist(attributes26);
        em.flush();

        Entities entities27 = new Entities();
        entities27.setName("Developments");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId48 = new GroupIds();
        groupId48 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities27.setGroupIds(groupId48);
        em.persist(entities27);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes28 = new Attributes();
        attributes28.setName("groupId");
        attributes28.setIsNullable(false);
        attributes28.setIsUnique(true);
//      ...................... Developments ........................
        Entities entity49 = new Entities();
        entity49 = findBean.nameEntities("Developments",em);
        attributes28.setEntities(entity49);
//      ...................... String ........................
        AttributesTypes attributesTypes50 = new AttributesTypes();
        attributesTypes50 = findBean.nameAttributesTypes("String",em);
        attributes28.setAttributesTypes(attributesTypes50);
        em.persist(attributes28);
        em.flush();

        Attributes attributes29 = new Attributes();
        attributes29.setName("artifactId");
        attributes29.setIsNullable(false);
        attributes29.setIsUnique(true);
//      ...................... Developments ........................
        Entities entity51 = new Entities();
        entity51 = findBean.nameEntities("Developments",em);
        attributes29.setEntities(entity51);
//      ...................... String ........................
        AttributesTypes attributesTypes52 = new AttributesTypes();
        attributesTypes52 = findBean.nameAttributesTypes("String",em);
        attributes29.setAttributesTypes(attributesTypes52);
        em.persist(attributes29);
        em.flush();

        Attributes attributes30 = new Attributes();
        attributes30.setName("version");
        attributes30.setIsNullable(true);
        attributes30.setIsUnique(false);
//      ...................... Developments ........................
        Entities entity53 = new Entities();
        entity53 = findBean.nameEntities("Developments",em);
        attributes30.setEntities(entity53);
//      ...................... String ........................
        AttributesTypes attributesTypes54 = new AttributesTypes();
        attributesTypes54 = findBean.nameAttributesTypes("String",em);
        attributes30.setAttributesTypes(attributesTypes54);
        em.persist(attributes30);
        em.flush();

        Attributes attributes31 = new Attributes();
        attributes31.setName("code");
        attributes31.setIsNullable(true);
        attributes31.setIsUnique(false);
//      ...................... Developments ........................
        Entities entity55 = new Entities();
        entity55 = findBean.nameEntities("Developments",em);
        attributes31.setEntities(entity55);
//      ...................... String ........................
        AttributesTypes attributesTypes56 = new AttributesTypes();
        attributesTypes56 = findBean.nameAttributesTypes("String",em);
        attributes31.setAttributesTypes(attributesTypes56);
        em.persist(attributes31);
        em.flush();

        Attributes attributes32 = new Attributes();
        attributes32.setName("date");
        attributes32.setIsNullable(true);
        attributes32.setIsUnique(false);
//      ...................... Developments ........................
        Entities entity57 = new Entities();
        entity57 = findBean.nameEntities("Developments",em);
        attributes32.setEntities(entity57);
//      ...................... Date ........................
        AttributesTypes attributesTypes58 = new AttributesTypes();
        attributesTypes58 = findBean.nameAttributesTypes("Date",em);
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
        attributes36.setName("name");
        attributes36.setIsNullable(false);
        attributes36.setIsUnique(true);
//      ...................... Cardinalities ........................
        Entities entity64 = new Entities();
        entity64 = findBean.nameEntities("Cardinalities",em);
        attributes36.setEntities(entity64);
//      ...................... String ........................
        AttributesTypes attributesTypes65 = new AttributesTypes();
        attributesTypes65 = findBean.nameAttributesTypes("String",em);
        attributes36.setAttributesTypes(attributesTypes65);
        em.persist(attributes36);
        em.flush();

        Entities entities37 = new Entities();
        entities37.setName("ModelsGroupIds");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId66 = new GroupIds();
        groupId66 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities37.setGroupIds(groupId66);
        em.persist(entities37);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes38 = new Attributes();
        attributes38.setName("isSimplified");
        attributes38.setIsNullable(true);
        attributes38.setIsUnique(false);
//      ...................... ModelsGroupIds ........................
        Entities entity67 = new Entities();
        entity67 = findBean.nameEntities("ModelsGroupIds",em);
        attributes38.setEntities(entity67);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes68 = new AttributesTypes();
        attributesTypes68 = findBean.nameAttributesTypes("Boolean",em);
        attributes38.setAttributesTypes(attributesTypes68);
        em.persist(attributes38);
        em.flush();

        Attributes attributes39 = new Attributes();
        attributes39.setName("isSingle");
        attributes39.setIsNullable(true);
        attributes39.setIsUnique(false);
//      ...................... ModelsGroupIds ........................
        Entities entity69 = new Entities();
        entity69 = findBean.nameEntities("ModelsGroupIds",em);
        attributes39.setEntities(entity69);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes70 = new AttributesTypes();
        attributesTypes70 = findBean.nameAttributesTypes("Boolean",em);
        attributes39.setAttributesTypes(attributesTypes70);
        em.persist(attributes39);
        em.flush();

        Attributes attributes40 = new Attributes();
        attributes40.setName("groupId");
        attributes40.setIsNullable(true);
        attributes40.setIsUnique(false);
//      ...................... ModelsGroupIds ........................
        Entities entity71 = new Entities();
        entity71 = findBean.nameEntities("ModelsGroupIds",em);
        attributes40.setEntities(entity71);
//      ...................... String ........................
        AttributesTypes attributesTypes72 = new AttributesTypes();
        attributesTypes72 = findBean.nameAttributesTypes("String",em);
        attributes40.setAttributesTypes(attributesTypes72);
        em.persist(attributes40);
        em.flush();

        Entities entities41 = new Entities();
        entities41.setName("Attributes");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId73 = new GroupIds();
        groupId73 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities41.setGroupIds(groupId73);
        em.persist(entities41);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes42 = new Attributes();
        attributes42.setName("description");
        attributes42.setIsNullable(true);
        attributes42.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity74 = new Entities();
        entity74 = findBean.nameEntities("Attributes",em);
        attributes42.setEntities(entity74);
//      ...................... String ........................
        AttributesTypes attributesTypes75 = new AttributesTypes();
        attributesTypes75 = findBean.nameAttributesTypes("String",em);
        attributes42.setAttributesTypes(attributesTypes75);
        em.persist(attributes42);
        em.flush();

        Attributes attributes43 = new Attributes();
        attributes43.setName("isSimplified");
        attributes43.setIsNullable(true);
        attributes43.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity76 = new Entities();
        entity76 = findBean.nameEntities("Attributes",em);
        attributes43.setEntities(entity76);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes77 = new AttributesTypes();
        attributesTypes77 = findBean.nameAttributesTypes("Boolean",em);
        attributes43.setAttributesTypes(attributesTypes77);
        em.persist(attributes43);
        em.flush();

        Attributes attributes44 = new Attributes();
        attributes44.setName("isUnique");
        attributes44.setIsNullable(true);
        attributes44.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity78 = new Entities();
        entity78 = findBean.nameEntities("Attributes",em);
        attributes44.setEntities(entity78);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes79 = new AttributesTypes();
        attributesTypes79 = findBean.nameAttributesTypes("Boolean",em);
        attributes44.setAttributesTypes(attributesTypes79);
        em.persist(attributes44);
        em.flush();

        Attributes attributes45 = new Attributes();
        attributes45.setName("isNullable");
        attributes45.setIsNullable(true);
        attributes45.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity80 = new Entities();
        entity80 = findBean.nameEntities("Attributes",em);
        attributes45.setEntities(entity80);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes81 = new AttributesTypes();
        attributesTypes81 = findBean.nameAttributesTypes("Boolean",em);
        attributes45.setAttributesTypes(attributesTypes81);
        em.persist(attributes45);
        em.flush();

        Attributes attributes46 = new Attributes();
        attributes46.setName("precision");
        attributes46.setIsNullable(true);
        attributes46.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity82 = new Entities();
        entity82 = findBean.nameEntities("Attributes",em);
        attributes46.setEntities(entity82);
//      ...................... Integer ........................
        AttributesTypes attributesTypes83 = new AttributesTypes();
        attributesTypes83 = findBean.nameAttributesTypes("Integer",em);
        attributes46.setAttributesTypes(attributesTypes83);
        em.persist(attributes46);
        em.flush();

        Attributes attributes47 = new Attributes();
        attributes47.setName("length");
        attributes47.setIsNullable(true);
        attributes47.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity84 = new Entities();
        entity84 = findBean.nameEntities("Attributes",em);
        attributes47.setEntities(entity84);
//      ...................... Integer ........................
        AttributesTypes attributesTypes85 = new AttributesTypes();
        attributesTypes85 = findBean.nameAttributesTypes("Integer",em);
        attributes47.setAttributesTypes(attributesTypes85);
        em.persist(attributes47);
        em.flush();

        Attributes attributes48 = new Attributes();
        attributes48.setName("name");
        attributes48.setIsNullable(false);
        attributes48.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity86 = new Entities();
        entity86 = findBean.nameEntities("Attributes",em);
        attributes48.setEntities(entity86);
//      ...................... String ........................
        AttributesTypes attributesTypes87 = new AttributesTypes();
        attributesTypes87 = findBean.nameAttributesTypes("String",em);
        attributes48.setAttributesTypes(attributesTypes87);
        em.persist(attributes48);
        em.flush();

        Entities entities49 = new Entities();
        entities49.setName("Imports");
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId88 = new GroupIds();
        groupId88 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities49.setGroupIds(groupId88);
        em.persist(entities49);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes50 = new Attributes();
        attributes50.setName("name");
        attributes50.setIsNullable(false);
        attributes50.setIsUnique(true);
//      ...................... Imports ........................
        Entities entity89 = new Entities();
        entity89 = findBean.nameEntities("Imports",em);
        attributes50.setEntities(entity89);
//      ...................... String ........................
        AttributesTypes attributesTypes90 = new AttributesTypes();
        attributesTypes90 = findBean.nameAttributesTypes("String",em);
        attributes50.setAttributesTypes(attributesTypes90);
        em.persist(attributes50);
        em.flush();

        Entities entities51 = new Entities();
        entities51.setName("AttributesProperties");
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId91 = new GroupIds();
        groupId91 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities51.setGroupIds(groupId91);
        em.persist(entities51);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes52 = new Attributes();
        attributes52.setName("value");
        attributes52.setIsNullable(false);
        attributes52.setIsUnique(true);
//      ...................... AttributesProperties ........................
        Entities entity92 = new Entities();
        entity92 = findBean.nameEntities("AttributesProperties",em);
        attributes52.setEntities(entity92);
//      ...................... String ........................
        AttributesTypes attributesTypes93 = new AttributesTypes();
        attributesTypes93 = findBean.nameAttributesTypes("String",em);
        attributes52.setAttributesTypes(attributesTypes93);
        em.persist(attributes52);
        em.flush();

        Attributes attributes53 = new Attributes();
        attributes53.setName("name");
        attributes53.setIsNullable(false);
        attributes53.setIsUnique(true);
//      ...................... AttributesProperties ........................
        Entities entity94 = new Entities();
        entity94 = findBean.nameEntities("AttributesProperties",em);
        attributes53.setEntities(entity94);
//      ...................... String ........................
        AttributesTypes attributesTypes95 = new AttributesTypes();
        attributesTypes95 = findBean.nameAttributesTypes("String",em);
        attributes53.setAttributesTypes(attributesTypes95);
        em.persist(attributes53);
        em.flush();

        Entities entities54 = new Entities();
        entities54.setName("AttributesTypes");
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId96 = new GroupIds();
        groupId96 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities54.setGroupIds(groupId96);
        em.persist(entities54);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes55 = new Attributes();
        attributes55.setName("type");
        attributes55.setIsNullable(false);
        attributes55.setIsUnique(false);
//      ...................... AttributesTypes ........................
        Entities entity97 = new Entities();
        entity97 = findBean.nameEntities("AttributesTypes",em);
        attributes55.setEntities(entity97);
//      ...................... String ........................
        AttributesTypes attributesTypes98 = new AttributesTypes();
        attributesTypes98 = findBean.nameAttributesTypes("String",em);
        attributes55.setAttributesTypes(attributesTypes98);
        em.persist(attributes55);
        em.flush();

        Attributes attributes56 = new Attributes();
        attributes56.setName("length");
        attributes56.setIsNullable(true);
        attributes56.setIsUnique(false);
//      ...................... AttributesTypes ........................
        Entities entity99 = new Entities();
        entity99 = findBean.nameEntities("AttributesTypes",em);
        attributes56.setEntities(entity99);
//      ...................... Integer ........................
        AttributesTypes attributesTypes100 = new AttributesTypes();
        attributesTypes100 = findBean.nameAttributesTypes("Integer",em);
        attributes56.setAttributesTypes(attributesTypes100);
        em.persist(attributes56);
        em.flush();

        Attributes attributes57 = new Attributes();
        attributes57.setName("name");
        attributes57.setIsNullable(false);
        attributes57.setIsUnique(true);
//      ...................... AttributesTypes ........................
        Entities entity101 = new Entities();
        entity101 = findBean.nameEntities("AttributesTypes",em);
        attributes57.setEntities(entity101);
//      ...................... String ........................
        AttributesTypes attributesTypes102 = new AttributesTypes();
        attributesTypes102 = findBean.nameAttributesTypes("String",em);
        attributes57.setAttributesTypes(attributesTypes102);
        em.persist(attributes57);
        em.flush();

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

        Entities entities60 = new Entities();
        entities60.setName("Dependencies");
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId107 = new GroupIds();
        groupId107 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities60.setGroupIds(groupId107);
        em.persist(entities60);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes61 = new Attributes();
        attributes61.setName("type");
        attributes61.setIsNullable(true);
        attributes61.setIsUnique(false);
//      ...................... Dependencies ........................
        Entities entity108 = new Entities();
        entity108 = findBean.nameEntities("Dependencies",em);
        attributes61.setEntities(entity108);
//      ...................... String ........................
        AttributesTypes attributesTypes109 = new AttributesTypes();
        attributesTypes109 = findBean.nameAttributesTypes("String",em);
        attributes61.setAttributesTypes(attributesTypes109);
        em.persist(attributes61);
        em.flush();

        Attributes attributes62 = new Attributes();
        attributes62.setName("scope");
        attributes62.setIsNullable(true);
        attributes62.setIsUnique(false);
//      ...................... Dependencies ........................
        Entities entity110 = new Entities();
        entity110 = findBean.nameEntities("Dependencies",em);
        attributes62.setEntities(entity110);
//      ...................... String ........................
        AttributesTypes attributesTypes111 = new AttributesTypes();
        attributesTypes111 = findBean.nameAttributesTypes("String",em);
        attributes62.setAttributesTypes(attributesTypes111);
        em.persist(attributes62);
        em.flush();

        Attributes attributes63 = new Attributes();
        attributes63.setName("artifactId");
        attributes63.setIsNullable(false);
        attributes63.setIsUnique(false);
//      ...................... Dependencies ........................
        Entities entity112 = new Entities();
        entity112 = findBean.nameEntities("Dependencies",em);
        attributes63.setEntities(entity112);
//      ...................... String ........................
        AttributesTypes attributesTypes113 = new AttributesTypes();
        attributesTypes113 = findBean.nameAttributesTypes("String",em);
        attributes63.setAttributesTypes(attributesTypes113);
        em.persist(attributes63);
        em.flush();

        Attributes attributes64 = new Attributes();
        attributes64.setName("version");
        attributes64.setIsNullable(true);
        attributes64.setIsUnique(false);
//      ...................... Dependencies ........................
        Entities entity114 = new Entities();
        entity114 = findBean.nameEntities("Dependencies",em);
        attributes64.setEntities(entity114);
//      ...................... String ........................
        AttributesTypes attributesTypes115 = new AttributesTypes();
        attributesTypes115 = findBean.nameAttributesTypes("String",em);
        attributes64.setAttributesTypes(attributesTypes115);
        em.persist(attributes64);
        em.flush();

        Attributes attributes65 = new Attributes();
        attributes65.setName("maven");
        attributes65.setIsNullable(false);
        attributes65.setIsUnique(true);
//      ...................... Dependencies ........................
        Entities entity116 = new Entities();
        entity116 = findBean.nameEntities("Dependencies",em);
        attributes65.setEntities(entity116);
//      ...................... String ........................
        AttributesTypes attributesTypes117 = new AttributesTypes();
        attributesTypes117 = findBean.nameAttributesTypes("String",em);
        attributes65.setAttributesTypes(attributesTypes117);
        em.persist(attributes65);
        em.flush();

        Attributes attributes66 = new Attributes();
        attributes66.setName("groupId");
        attributes66.setIsNullable(false);
        attributes66.setIsUnique(false);
//      ...................... Dependencies ........................
        Entities entity118 = new Entities();
        entity118 = findBean.nameEntities("Dependencies",em);
        attributes66.setEntities(entity118);
//      ...................... String ........................
        AttributesTypes attributesTypes119 = new AttributesTypes();
        attributesTypes119 = findBean.nameAttributesTypes("String",em);
        attributes66.setAttributesTypes(attributesTypes119);
        em.persist(attributes66);
        em.flush();

        Entities entities67 = new Entities();
        entities67.setName("Sites");
//      ...................... co.simasoft.models.dev.naifg.sites ........................
        GroupIds groupId120 = new GroupIds();
        groupId120 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.sites",em);
        entities67.setGroupIds(groupId120);
        em.persist(entities67);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes68 = new Attributes();
        attributes68.setName("link");
        attributes68.setIsNullable(false);
        attributes68.setIsUnique(true);
//      ...................... Sites ........................
        Entities entity121 = new Entities();
        entity121 = findBean.nameEntities("Sites",em);
        attributes68.setEntities(entity121);
//      ...................... String ........................
        AttributesTypes attributesTypes122 = new AttributesTypes();
        attributesTypes122 = findBean.nameAttributesTypes("String",em);
        attributes68.setAttributesTypes(attributesTypes122);
        em.persist(attributes68);
        em.flush();

        Attributes attributes69 = new Attributes();
        attributes69.setName("title");
        attributes69.setIsNullable(true);
        attributes69.setIsUnique(false);
//      ...................... Sites ........................
        Entities entity123 = new Entities();
        entity123 = findBean.nameEntities("Sites",em);
        attributes69.setEntities(entity123);
//      ...................... String ........................
        AttributesTypes attributesTypes124 = new AttributesTypes();
        attributesTypes124 = findBean.nameAttributesTypes("String",em);
        attributes69.setAttributesTypes(attributesTypes124);
        em.persist(attributes69);
        em.flush();

        Attributes attributes70 = new Attributes();
        attributes70.setName("abc");
        attributes70.setIsNullable(true);
        attributes70.setIsUnique(false);
//      ...................... Sites ........................
        Entities entity125 = new Entities();
        entity125 = findBean.nameEntities("Sites",em);
        attributes70.setEntities(entity125);
//      ...................... String ........................
        AttributesTypes attributesTypes126 = new AttributesTypes();
        attributesTypes126 = findBean.nameAttributesTypes("String",em);
        attributes70.setAttributesTypes(attributesTypes126);
        em.persist(attributes70);
        em.flush();

        Entities entities71 = new Entities();
        entities71.setName("SitesTypes");
//      ...................... co.simasoft.models.dev.naifg.sites ........................
        GroupIds groupId127 = new GroupIds();
        groupId127 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.sites",em);
        entities71.setGroupIds(groupId127);
        em.persist(entities71);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes72 = new Attributes();
        attributes72.setName("name");
        attributes72.setIsNullable(true);
        attributes72.setIsUnique(false);
//      ...................... SitesTypes ........................
        Entities entity128 = new Entities();
        entity128 = findBean.nameEntities("SitesTypes",em);
        attributes72.setEntities(entity128);
//      ...................... String ........................
        AttributesTypes attributesTypes129 = new AttributesTypes();
        attributesTypes129 = findBean.nameAttributesTypes("String",em);
        attributes72.setAttributesTypes(attributesTypes129);
        em.persist(attributes72);
        em.flush();

//      ---------------------- Relationships ------------------------

/*
. Models . 1..* ModelsGroupIds
. Models . *..* Sites
. GroupIds . 1..* ModelsGroupIds
. GroupIds . 1..* Entities
. Relationships . *..* AttributesProperties
. Entities . 1..* Attributes
. Entities . *..* Sites
. Entities . *..* AttributesProperties
. Entities . 1..* NameQueries
. Entities . 1..* Relationships
. Entities . 1..* Relationships
. Entities . *..* Imports
. Developments . *..* Sites
. Developments . *..* Models
. Cardinalities . *..* Sites
. Cardinalities . *..* Imports
. Cardinalities . 1..* Relationships
. Attributes . *..* AttributesProperties
. Attributes . *..* Sites
. Imports . *..* Sites
. AttributesProperties . *..* Sites
. AttributesProperties . *..* Imports
. AttributesTypes . 1..* Attributes
. AttributesTypes . *..* Sites
. AttributesTypes . *..* AttributesProperties
. Dependencies . *..* Sites
. Dependencies . 1..* Imports
. SitesTypes . *..* Sites
. SitesTypes . 1..* SitesTypes
*/
        Relationships relationships1 = new Relationships();
        relationships1.setIsOptionality(true);
        relationships1.setIsEmbedded(false);
        relationships1.setName("");
//      ...................... Models ........................
        Entities entities130 = new Entities();
        entities130 = findBean.nameEntities("Models",em);
        relationships1.setFrom(entities130);
//      ...................... ModelsGroupIds ........................
        Entities entities131 = new Entities();
        entities131 = findBean.nameEntities("ModelsGroupIds",em);
        relationships1.setTo(entities131);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities132 = new Cardinalities();
        cardinalities132 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships1.setCardinalities(cardinalities132);
        em.persist(relationships1);
        em.flush();

        Relationships relationships2 = new Relationships();
        relationships2.setIsOptionality(true);
        relationships2.setIsEmbedded(false);
        relationships2.setName("");
//      ...................... Models ........................
        Entities entities133 = new Entities();
        entities133 = findBean.nameEntities("Models",em);
        relationships2.setFrom(entities133);
//      ...................... Sites ........................
        Entities entities134 = new Entities();
        entities134 = findBean.nameEntities("Sites",em);
        relationships2.setTo(entities134);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities135 = new Cardinalities();
        cardinalities135 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships2.setCardinalities(cardinalities135);
        em.persist(relationships2);
        em.flush();

        Relationships relationships3 = new Relationships();
        relationships3.setIsOptionality(true);
        relationships3.setIsEmbedded(false);
        relationships3.setName("");
//      ...................... GroupIds ........................
        Entities entities136 = new Entities();
        entities136 = findBean.nameEntities("GroupIds",em);
        relationships3.setFrom(entities136);
//      ...................... ModelsGroupIds ........................
        Entities entities137 = new Entities();
        entities137 = findBean.nameEntities("ModelsGroupIds",em);
        relationships3.setTo(entities137);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities138 = new Cardinalities();
        cardinalities138 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships3.setCardinalities(cardinalities138);
        em.persist(relationships3);
        em.flush();

        Relationships relationships4 = new Relationships();
        relationships4.setIsOptionality(true);
        relationships4.setIsEmbedded(false);
        relationships4.setName("");
//      ...................... GroupIds ........................
        Entities entities139 = new Entities();
        entities139 = findBean.nameEntities("GroupIds",em);
        relationships4.setFrom(entities139);
//      ...................... Entities ........................
        Entities entities140 = new Entities();
        entities140 = findBean.nameEntities("Entities",em);
        relationships4.setTo(entities140);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities141 = new Cardinalities();
        cardinalities141 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships4.setCardinalities(cardinalities141);
        em.persist(relationships4);
        em.flush();

        Relationships relationships5 = new Relationships();
        relationships5.setIsOptionality(true);
        relationships5.setIsEmbedded(false);
        relationships5.setName("");
//      ...................... Relationships ........................
        Entities entities142 = new Entities();
        entities142 = findBean.nameEntities("Relationships",em);
        relationships5.setFrom(entities142);
//      ...................... AttributesProperties ........................
        Entities entities143 = new Entities();
        entities143 = findBean.nameEntities("AttributesProperties",em);
        relationships5.setTo(entities143);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities144 = new Cardinalities();
        cardinalities144 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships5.setCardinalities(cardinalities144);
        em.persist(relationships5);
        em.flush();

        Relationships relationships6 = new Relationships();
        relationships6.setIsOptionality(true);
        relationships6.setIsEmbedded(false);
        relationships6.setName("");
//      ...................... Entities ........................
        Entities entities145 = new Entities();
        entities145 = findBean.nameEntities("Entities",em);
        relationships6.setFrom(entities145);
//      ...................... Attributes ........................
        Entities entities146 = new Entities();
        entities146 = findBean.nameEntities("Attributes",em);
        relationships6.setTo(entities146);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities147 = new Cardinalities();
        cardinalities147 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships6.setCardinalities(cardinalities147);
        em.persist(relationships6);
        em.flush();

        Relationships relationships7 = new Relationships();
        relationships7.setIsOptionality(true);
        relationships7.setIsEmbedded(false);
        relationships7.setName("");
//      ...................... Entities ........................
        Entities entities148 = new Entities();
        entities148 = findBean.nameEntities("Entities",em);
        relationships7.setFrom(entities148);
//      ...................... Sites ........................
        Entities entities149 = new Entities();
        entities149 = findBean.nameEntities("Sites",em);
        relationships7.setTo(entities149);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities150 = new Cardinalities();
        cardinalities150 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships7.setCardinalities(cardinalities150);
        em.persist(relationships7);
        em.flush();

        Relationships relationships8 = new Relationships();
        relationships8.setIsOptionality(true);
        relationships8.setIsEmbedded(false);
        relationships8.setName("");
//      ...................... Entities ........................
        Entities entities151 = new Entities();
        entities151 = findBean.nameEntities("Entities",em);
        relationships8.setFrom(entities151);
//      ...................... AttributesProperties ........................
        Entities entities152 = new Entities();
        entities152 = findBean.nameEntities("AttributesProperties",em);
        relationships8.setTo(entities152);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities153 = new Cardinalities();
        cardinalities153 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships8.setCardinalities(cardinalities153);
        em.persist(relationships8);
        em.flush();

        Relationships relationships9 = new Relationships();
        relationships9.setIsOptionality(true);
        relationships9.setIsEmbedded(false);
        relationships9.setName("");
//      ...................... Entities ........................
        Entities entities154 = new Entities();
        entities154 = findBean.nameEntities("Entities",em);
        relationships9.setFrom(entities154);
//      ...................... NameQueries ........................
        Entities entities155 = new Entities();
        entities155 = findBean.nameEntities("NameQueries",em);
        relationships9.setTo(entities155);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities156 = new Cardinalities();
        cardinalities156 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships9.setCardinalities(cardinalities156);
        em.persist(relationships9);
        em.flush();

        Relationships relationships10 = new Relationships();
        relationships10.setIsOptionality(true);
        relationships10.setIsEmbedded(false);
        relationships10.setName("from");
//      ...................... Entities ........................
        Entities entities157 = new Entities();
        entities157 = findBean.nameEntities("Entities",em);
        relationships10.setFrom(entities157);
//      ...................... Relationships ........................
        Entities entities158 = new Entities();
        entities158 = findBean.nameEntities("Relationships",em);
        relationships10.setTo(entities158);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities159 = new Cardinalities();
        cardinalities159 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships10.setCardinalities(cardinalities159);
        em.persist(relationships10);
        em.flush();

        Relationships relationships11 = new Relationships();
        relationships11.setIsOptionality(true);
        relationships11.setIsEmbedded(false);
        relationships11.setName("to");
//      ...................... Entities ........................
        Entities entities160 = new Entities();
        entities160 = findBean.nameEntities("Entities",em);
        relationships11.setFrom(entities160);
//      ...................... Relationships ........................
        Entities entities161 = new Entities();
        entities161 = findBean.nameEntities("Relationships",em);
        relationships11.setTo(entities161);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities162 = new Cardinalities();
        cardinalities162 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships11.setCardinalities(cardinalities162);
        em.persist(relationships11);
        em.flush();

        Relationships relationships12 = new Relationships();
        relationships12.setIsOptionality(true);
        relationships12.setIsEmbedded(false);
        relationships12.setName("");
//      ...................... Entities ........................
        Entities entities163 = new Entities();
        entities163 = findBean.nameEntities("Entities",em);
        relationships12.setFrom(entities163);
//      ...................... Imports ........................
        Entities entities164 = new Entities();
        entities164 = findBean.nameEntities("Imports",em);
        relationships12.setTo(entities164);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities165 = new Cardinalities();
        cardinalities165 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships12.setCardinalities(cardinalities165);
        em.persist(relationships12);
        em.flush();

        Relationships relationships13 = new Relationships();
        relationships13.setIsOptionality(true);
        relationships13.setIsEmbedded(false);
        relationships13.setName("");
//      ...................... Developments ........................
        Entities entities166 = new Entities();
        entities166 = findBean.nameEntities("Developments",em);
        relationships13.setFrom(entities166);
//      ...................... Sites ........................
        Entities entities167 = new Entities();
        entities167 = findBean.nameEntities("Sites",em);
        relationships13.setTo(entities167);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities168 = new Cardinalities();
        cardinalities168 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships13.setCardinalities(cardinalities168);
        em.persist(relationships13);
        em.flush();

        Relationships relationships14 = new Relationships();
        relationships14.setIsOptionality(true);
        relationships14.setIsEmbedded(false);
        relationships14.setName("");
//      ...................... Developments ........................
        Entities entities169 = new Entities();
        entities169 = findBean.nameEntities("Developments",em);
        relationships14.setFrom(entities169);
//      ...................... Models ........................
        Entities entities170 = new Entities();
        entities170 = findBean.nameEntities("Models",em);
        relationships14.setTo(entities170);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities171 = new Cardinalities();
        cardinalities171 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships14.setCardinalities(cardinalities171);
        em.persist(relationships14);
        em.flush();

        Relationships relationships15 = new Relationships();
        relationships15.setIsOptionality(true);
        relationships15.setIsEmbedded(false);
        relationships15.setName("");
//      ...................... Cardinalities ........................
        Entities entities172 = new Entities();
        entities172 = findBean.nameEntities("Cardinalities",em);
        relationships15.setFrom(entities172);
//      ...................... Sites ........................
        Entities entities173 = new Entities();
        entities173 = findBean.nameEntities("Sites",em);
        relationships15.setTo(entities173);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities174 = new Cardinalities();
        cardinalities174 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships15.setCardinalities(cardinalities174);
        em.persist(relationships15);
        em.flush();

        Relationships relationships16 = new Relationships();
        relationships16.setIsOptionality(true);
        relationships16.setIsEmbedded(false);
        relationships16.setName("");
//      ...................... Cardinalities ........................
        Entities entities175 = new Entities();
        entities175 = findBean.nameEntities("Cardinalities",em);
        relationships16.setFrom(entities175);
//      ...................... Imports ........................
        Entities entities176 = new Entities();
        entities176 = findBean.nameEntities("Imports",em);
        relationships16.setTo(entities176);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities177 = new Cardinalities();
        cardinalities177 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships16.setCardinalities(cardinalities177);
        em.persist(relationships16);
        em.flush();

        Relationships relationships17 = new Relationships();
        relationships17.setIsOptionality(true);
        relationships17.setIsEmbedded(false);
        relationships17.setName("");
//      ...................... Cardinalities ........................
        Entities entities178 = new Entities();
        entities178 = findBean.nameEntities("Cardinalities",em);
        relationships17.setFrom(entities178);
//      ...................... Relationships ........................
        Entities entities179 = new Entities();
        entities179 = findBean.nameEntities("Relationships",em);
        relationships17.setTo(entities179);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities180 = new Cardinalities();
        cardinalities180 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships17.setCardinalities(cardinalities180);
        em.persist(relationships17);
        em.flush();

        Relationships relationships18 = new Relationships();
        relationships18.setIsOptionality(true);
        relationships18.setIsEmbedded(false);
        relationships18.setName("");
//      ...................... Attributes ........................
        Entities entities181 = new Entities();
        entities181 = findBean.nameEntities("Attributes",em);
        relationships18.setFrom(entities181);
//      ...................... AttributesProperties ........................
        Entities entities182 = new Entities();
        entities182 = findBean.nameEntities("AttributesProperties",em);
        relationships18.setTo(entities182);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities183 = new Cardinalities();
        cardinalities183 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships18.setCardinalities(cardinalities183);
        em.persist(relationships18);
        em.flush();

        Relationships relationships19 = new Relationships();
        relationships19.setIsOptionality(true);
        relationships19.setIsEmbedded(false);
        relationships19.setName("");
//      ...................... Attributes ........................
        Entities entities184 = new Entities();
        entities184 = findBean.nameEntities("Attributes",em);
        relationships19.setFrom(entities184);
//      ...................... Sites ........................
        Entities entities185 = new Entities();
        entities185 = findBean.nameEntities("Sites",em);
        relationships19.setTo(entities185);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities186 = new Cardinalities();
        cardinalities186 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships19.setCardinalities(cardinalities186);
        em.persist(relationships19);
        em.flush();

        Relationships relationships20 = new Relationships();
        relationships20.setIsOptionality(true);
        relationships20.setIsEmbedded(false);
        relationships20.setName("");
//      ...................... Imports ........................
        Entities entities187 = new Entities();
        entities187 = findBean.nameEntities("Imports",em);
        relationships20.setFrom(entities187);
//      ...................... Sites ........................
        Entities entities188 = new Entities();
        entities188 = findBean.nameEntities("Sites",em);
        relationships20.setTo(entities188);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities189 = new Cardinalities();
        cardinalities189 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships20.setCardinalities(cardinalities189);
        em.persist(relationships20);
        em.flush();

        Relationships relationships21 = new Relationships();
        relationships21.setIsOptionality(true);
        relationships21.setIsEmbedded(false);
        relationships21.setName("");
//      ...................... AttributesProperties ........................
        Entities entities190 = new Entities();
        entities190 = findBean.nameEntities("AttributesProperties",em);
        relationships21.setFrom(entities190);
//      ...................... Sites ........................
        Entities entities191 = new Entities();
        entities191 = findBean.nameEntities("Sites",em);
        relationships21.setTo(entities191);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities192 = new Cardinalities();
        cardinalities192 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships21.setCardinalities(cardinalities192);
        em.persist(relationships21);
        em.flush();

        Relationships relationships22 = new Relationships();
        relationships22.setIsOptionality(true);
        relationships22.setIsEmbedded(false);
        relationships22.setName("");
//      ...................... AttributesProperties ........................
        Entities entities193 = new Entities();
        entities193 = findBean.nameEntities("AttributesProperties",em);
        relationships22.setFrom(entities193);
//      ...................... Imports ........................
        Entities entities194 = new Entities();
        entities194 = findBean.nameEntities("Imports",em);
        relationships22.setTo(entities194);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities195 = new Cardinalities();
        cardinalities195 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships22.setCardinalities(cardinalities195);
        em.persist(relationships22);
        em.flush();

        Relationships relationships23 = new Relationships();
        relationships23.setIsOptionality(true);
        relationships23.setIsEmbedded(false);
        relationships23.setName("");
//      ...................... AttributesTypes ........................
        Entities entities196 = new Entities();
        entities196 = findBean.nameEntities("AttributesTypes",em);
        relationships23.setFrom(entities196);
//      ...................... Attributes ........................
        Entities entities197 = new Entities();
        entities197 = findBean.nameEntities("Attributes",em);
        relationships23.setTo(entities197);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities198 = new Cardinalities();
        cardinalities198 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships23.setCardinalities(cardinalities198);
        em.persist(relationships23);
        em.flush();

        Relationships relationships24 = new Relationships();
        relationships24.setIsOptionality(true);
        relationships24.setIsEmbedded(false);
        relationships24.setName("");
//      ...................... AttributesTypes ........................
        Entities entities199 = new Entities();
        entities199 = findBean.nameEntities("AttributesTypes",em);
        relationships24.setFrom(entities199);
//      ...................... Sites ........................
        Entities entities200 = new Entities();
        entities200 = findBean.nameEntities("Sites",em);
        relationships24.setTo(entities200);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities201 = new Cardinalities();
        cardinalities201 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships24.setCardinalities(cardinalities201);
        em.persist(relationships24);
        em.flush();

        Relationships relationships25 = new Relationships();
        relationships25.setIsOptionality(true);
        relationships25.setIsEmbedded(false);
        relationships25.setName("");
//      ...................... AttributesTypes ........................
        Entities entities202 = new Entities();
        entities202 = findBean.nameEntities("AttributesTypes",em);
        relationships25.setFrom(entities202);
//      ...................... AttributesProperties ........................
        Entities entities203 = new Entities();
        entities203 = findBean.nameEntities("AttributesProperties",em);
        relationships25.setTo(entities203);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities204 = new Cardinalities();
        cardinalities204 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships25.setCardinalities(cardinalities204);
        em.persist(relationships25);
        em.flush();

        Relationships relationships26 = new Relationships();
        relationships26.setIsOptionality(true);
        relationships26.setIsEmbedded(false);
        relationships26.setName("");
//      ...................... Dependencies ........................
        Entities entities205 = new Entities();
        entities205 = findBean.nameEntities("Dependencies",em);
        relationships26.setFrom(entities205);
//      ...................... Sites ........................
        Entities entities206 = new Entities();
        entities206 = findBean.nameEntities("Sites",em);
        relationships26.setTo(entities206);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities207 = new Cardinalities();
        cardinalities207 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships26.setCardinalities(cardinalities207);
        em.persist(relationships26);
        em.flush();

        Relationships relationships27 = new Relationships();
        relationships27.setIsOptionality(true);
        relationships27.setIsEmbedded(false);
        relationships27.setName("");
//      ...................... Dependencies ........................
        Entities entities208 = new Entities();
        entities208 = findBean.nameEntities("Dependencies",em);
        relationships27.setFrom(entities208);
//      ...................... Imports ........................
        Entities entities209 = new Entities();
        entities209 = findBean.nameEntities("Imports",em);
        relationships27.setTo(entities209);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities210 = new Cardinalities();
        cardinalities210 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships27.setCardinalities(cardinalities210);
        em.persist(relationships27);
        em.flush();

        Relationships relationships28 = new Relationships();
        relationships28.setIsOptionality(true);
        relationships28.setIsEmbedded(false);
        relationships28.setName("");
//      ...................... SitesTypes ........................
        Entities entities211 = new Entities();
        entities211 = findBean.nameEntities("SitesTypes",em);
        relationships28.setFrom(entities211);
//      ...................... Sites ........................
        Entities entities212 = new Entities();
        entities212 = findBean.nameEntities("Sites",em);
        relationships28.setTo(entities212);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities213 = new Cardinalities();
        cardinalities213 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships28.setCardinalities(cardinalities213);
        em.persist(relationships28);
        em.flush();

        Relationships relationships29 = new Relationships();
        relationships29.setIsOptionality(true);
        relationships29.setIsEmbedded(false);
        relationships29.setName("");
//      ...................... SitesTypes ........................
        Entities entities214 = new Entities();
        entities214 = findBean.nameEntities("SitesTypes",em);
        relationships29.setFrom(entities214);
//      ...................... SitesTypes ........................
        Entities entities215 = new Entities();
        entities215 = findBean.nameEntities("SitesTypes",em);
        relationships29.setTo(entities215);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities216 = new Cardinalities();
        cardinalities216 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships29.setCardinalities(cardinalities216);
        em.persist(relationships29);
        em.flush();

    } // data()

} // naifgSetup
