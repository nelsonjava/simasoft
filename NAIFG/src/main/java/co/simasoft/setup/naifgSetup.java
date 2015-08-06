import co.simasoft.models.dev.naifg.*;
import co.simasoft.models.dev.naifg.dependencies.*;


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

    @PersistenceContext(unitName = "naifgPU-JTA")
    private EntityManager em;

    FindBean findBean = new FindBean();

    private static final Logger log = Logger.getLogger(naifgSetup.class.getName());

    public void data() {

//      ---------------------- GroupIds ------------------------

        GroupIds groupIds1 = new GroupIds();
        groupIds1.setGroupId("co.simasoft.models.dev.naifg.dependencies");
        groupIds1.setName("dependencies");
        em.persist(groupIds1);
        em.flush();

        GroupIds groupIds2 = new GroupIds();
        groupIds2.setGroupId("co.simasoft.models.dev.naifg");
        groupIds2.setName("naifg");
        em.persist(groupIds2);
        em.flush();

//      ---------------------- Models ------------------------

        Models models = new Models();
        models.setGroupId("co.simasoft.models.dev.naifg");
        models.setArtifactId("naifg");
        models.setVersion("1.0-SNAPSHOT");
        models.setName("naifg");

        Set<GroupIds> modelsGroupIds1 = new HashSet<GroupIds>();

        GroupIds modelsGroupId1 = findBean.groupGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        modelsGroupIds1.add(modelsGroupId1);

        GroupIds modelsGroupId2 = findBean.groupGroupIds("co.simasoft.models.dev.naifg",em);
        modelsGroupIds1.add(modelsGroupId2);

        models.setGroupIds(modelsGroupIds1);

        em.persist(models);
        em.flush();

//      ---------------------- Developments ------------------------

        Developments dev = new Developments();
        dev.setGroupId("co.simasoft");
        dev.setArtifactId("naifg");
        dev.setVersion("1.0-SNAPSHOT");
        dev.setName("naifg");
        Set<Models> models1 = new HashSet<Models>();
        Models model1 = findBean.artifactIdModels("naifg",em);
        models1.add(model1);
        dev.setModels(models1);
        em.persist(dev);
        em.flush();


//      ---------------------- Entities ------------------------

        Entities entities1 = new Entities();
        entities1.setName("Imports");
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
//      ...................... Imports ........................
        Entities entity2 = new Entities();
        entity2 = findBean.nameEntities("Imports",em);
        attributes2.setEntities(entity2);
//      ...................... String ........................
        AttributesTypes attributesTypes3 = new AttributesTypes();
        attributesTypes3 = findBean.nameAttributesTypes("String",em);
        attributes2.setAttributesTypes(attributesTypes3);
        em.persist(attributes2);
        em.flush();

        Entities entities3 = new Entities();
        entities3.setName("Dependencies");
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId4 = new GroupIds();
        groupId4 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities3.setGroupIds(groupId4);
        em.persist(entities3);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes4 = new Attributes();
        attributes4.setName("groupId");
        attributes4.setNullable(false);
        attributes4.setSingle(false);
//      ...................... Dependencies ........................
        Entities entity5 = new Entities();
        entity5 = findBean.nameEntities("Dependencies",em);
        attributes4.setEntities(entity5);
//      ...................... String ........................
        AttributesTypes attributesTypes6 = new AttributesTypes();
        attributesTypes6 = findBean.nameAttributesTypes("String",em);
        attributes4.setAttributesTypes(attributesTypes6);
        em.persist(attributes4);
        em.flush();

        Attributes attributes5 = new Attributes();
        attributes5.setName("artifactId");
        attributes5.setNullable(false);
        attributes5.setSingle(false);
//      ...................... Dependencies ........................
        Entities entity7 = new Entities();
        entity7 = findBean.nameEntities("Dependencies",em);
        attributes5.setEntities(entity7);
//      ...................... String ........................
        AttributesTypes attributesTypes8 = new AttributesTypes();
        attributesTypes8 = findBean.nameAttributesTypes("String",em);
        attributes5.setAttributesTypes(attributesTypes8);
        em.persist(attributes5);
        em.flush();

        Attributes attributes6 = new Attributes();
        attributes6.setName("version");
        attributes6.setNullable(true);
        attributes6.setSingle(false);
//      ...................... Dependencies ........................
        Entities entity9 = new Entities();
        entity9 = findBean.nameEntities("Dependencies",em);
        attributes6.setEntities(entity9);
//      ...................... String ........................
        AttributesTypes attributesTypes10 = new AttributesTypes();
        attributesTypes10 = findBean.nameAttributesTypes("String",em);
        attributes6.setAttributesTypes(attributesTypes10);
        em.persist(attributes6);
        em.flush();

        Attributes attributes7 = new Attributes();
        attributes7.setName("type");
        attributes7.setNullable(true);
        attributes7.setSingle(false);
//      ...................... Dependencies ........................
        Entities entity11 = new Entities();
        entity11 = findBean.nameEntities("Dependencies",em);
        attributes7.setEntities(entity11);
//      ...................... String ........................
        AttributesTypes attributesTypes12 = new AttributesTypes();
        attributesTypes12 = findBean.nameAttributesTypes("String",em);
        attributes7.setAttributesTypes(attributesTypes12);
        em.persist(attributes7);
        em.flush();

        Attributes attributes8 = new Attributes();
        attributes8.setName("scope");
        attributes8.setNullable(true);
        attributes8.setSingle(false);
//      ...................... Dependencies ........................
        Entities entity13 = new Entities();
        entity13 = findBean.nameEntities("Dependencies",em);
        attributes8.setEntities(entity13);
//      ...................... String ........................
        AttributesTypes attributesTypes14 = new AttributesTypes();
        attributesTypes14 = findBean.nameAttributesTypes("String",em);
        attributes8.setAttributesTypes(attributesTypes14);
        em.persist(attributes8);
        em.flush();

        Attributes attributes9 = new Attributes();
        attributes9.setName("maven");
        attributes9.setNullable(false);
        attributes9.setSingle(true);
//      ...................... Dependencies ........................
        Entities entity15 = new Entities();
        entity15 = findBean.nameEntities("Dependencies",em);
        attributes9.setEntities(entity15);
//      ...................... String ........................
        AttributesTypes attributesTypes16 = new AttributesTypes();
        attributesTypes16 = findBean.nameAttributesTypes("String",em);
        attributes9.setAttributesTypes(attributesTypes16);
        em.persist(attributes9);
        em.flush();

        Entities entities10 = new Entities();
        entities10.setName("AttributesTypes");
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId17 = new GroupIds();
        groupId17 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities10.setGroupIds(groupId17);
        em.persist(entities10);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes11 = new Attributes();
        attributes11.setName("name");
        attributes11.setNullable(false);
        attributes11.setSingle(true);
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
        attributes12.setName("type");
        attributes12.setNullable(false);
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

        Attributes attributes13 = new Attributes();
        attributes13.setName("length");
        attributes13.setNullable(true);
        attributes13.setSingle(false);
//      ...................... AttributesTypes ........................
        Entities entity22 = new Entities();
        entity22 = findBean.nameEntities("AttributesTypes",em);
        attributes13.setEntities(entity22);
//      ...................... Integer ........................
        AttributesTypes attributesTypes23 = new AttributesTypes();
        attributesTypes23 = findBean.nameAttributesTypes("Integer",em);
        attributes13.setAttributesTypes(attributesTypes23);
        em.persist(attributes13);
        em.flush();

        Attributes attributes14 = new Attributes();
        attributes14.setName("precision");
        attributes14.setNullable(true);
        attributes14.setSingle(false);
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
        attributes15.setName("annotations");
        attributes15.setNullable(true);
        attributes15.setSingle(false);
//      ...................... AttributesTypes ........................
        Entities entity26 = new Entities();
        entity26 = findBean.nameEntities("AttributesTypes",em);
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
        attributes17.setName("name");
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
        attributes18.setName("value");
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

//      ---------------------- Attributes ------------------------

        Attributes attributes20 = new Attributes();
        attributes20.setName("name");
        attributes20.setNullable(false);
        attributes20.setSingle(true);
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
        attributes21.setNullable(false);
        attributes21.setSingle(false);
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
        attributes22.setName("artifactId");
        attributes22.setNullable(true);
        attributes22.setSingle(true);
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
        attributes23.setName("version");
        attributes23.setNullable(true);
        attributes23.setSingle(false);
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
        attributes24.setName("code");
        attributes24.setNullable(true);
        attributes24.setSingle(true);
//      ...................... Developments ........................
        Entities entity42 = new Entities();
        entity42 = findBean.nameEntities("Developments",em);
        attributes24.setEntities(entity42);
//      ...................... String ........................
        AttributesTypes attributesTypes43 = new AttributesTypes();
        attributesTypes43 = findBean.nameAttributesTypes("String",em);
        attributes24.setAttributesTypes(attributesTypes43);
        em.persist(attributes24);
        em.flush();

        Attributes attributes25 = new Attributes();
        attributes25.setName("date");
        attributes25.setNullable(true);
        attributes25.setSingle(false);
//      ...................... Developments ........................
        Entities entity44 = new Entities();
        entity44 = findBean.nameEntities("Developments",em);
        attributes25.setEntities(entity44);
//      ...................... Date ........................
        AttributesTypes attributesTypes45 = new AttributesTypes();
        attributesTypes45 = findBean.nameAttributesTypes("Date",em);
        attributes25.setAttributesTypes(attributesTypes45);
        em.persist(attributes25);
        em.flush();

        Entities entities26 = new Entities();
        entities26.setName("Cardinalities");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId46 = new GroupIds();
        groupId46 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities26.setGroupIds(groupId46);
        em.persist(entities26);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes27 = new Attributes();
        attributes27.setName("name");
        attributes27.setNullable(false);
        attributes27.setSingle(true);
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
        attributes28.setName("cardinality");
        attributes28.setNullable(false);
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

        Attributes attributes29 = new Attributes();
        attributes29.setName("unidirectional");
        attributes29.setNullable(true);
        attributes29.setSingle(false);
//      ...................... Cardinalities ........................
        Entities entity51 = new Entities();
        entity51 = findBean.nameEntities("Cardinalities",em);
        attributes29.setEntities(entity51);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes52 = new AttributesTypes();
        attributesTypes52 = findBean.nameAttributesTypes("Boolean",em);
        attributes29.setAttributesTypes(attributesTypes52);
        em.persist(attributes29);
        em.flush();

        Attributes attributes30 = new Attributes();
        attributes30.setName("annotations");
        attributes30.setNullable(true);
        attributes30.setSingle(false);
//      ...................... Cardinalities ........................
        Entities entity53 = new Entities();
        entity53 = findBean.nameEntities("Cardinalities",em);
        attributes30.setEntities(entity53);
//      ...................... String ........................
        AttributesTypes attributesTypes54 = new AttributesTypes();
        attributesTypes54 = findBean.nameAttributesTypes("String",em);
        attributes30.setAttributesTypes(attributesTypes54);
        em.persist(attributes30);
        em.flush();

        Attributes attributes31 = new Attributes();
        attributes31.setName("observations");
        attributes31.setNullable(true);
        attributes31.setSingle(false);
//      ...................... Cardinalities ........................
        Entities entity55 = new Entities();
        entity55 = findBean.nameEntities("Cardinalities",em);
        attributes31.setEntities(entity55);
//      ...................... String ........................
        AttributesTypes attributesTypes56 = new AttributesTypes();
        attributesTypes56 = findBean.nameAttributesTypes("String",em);
        attributes31.setAttributesTypes(attributesTypes56);
        em.persist(attributes31);
        em.flush();

        Entities entities32 = new Entities();
        entities32.setName("Entities");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId57 = new GroupIds();
        groupId57 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities32.setGroupIds(groupId57);
        em.persist(entities32);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes33 = new Attributes();
        attributes33.setName("name");
        attributes33.setNullable(false);
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
        attributes34.setName("serialID");
        attributes34.setNullable(true);
        attributes34.setSingle(true);
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
        attributes35.setName("table");
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
        attributes36.setName("tableSecuencia");
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
        attributes37.setName("modifier");
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
        attributes38.setName("extend");
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
        attributes39.setName("annotations");
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

        Attributes attributes40 = new Attributes();
        attributes40.setName("source");
        attributes40.setNullable(true);
        attributes40.setSingle(false);
//      ...................... Entities ........................
        Entities entity72 = new Entities();
        entity72 = findBean.nameEntities("Entities",em);
        attributes40.setEntities(entity72);
//      ...................... String ........................
        AttributesTypes attributesTypes73 = new AttributesTypes();
        attributesTypes73 = findBean.nameAttributesTypes("String",em);
        attributes40.setAttributesTypes(attributesTypes73);
        em.persist(attributes40);
        em.flush();

        Attributes attributes41 = new Attributes();
        attributes41.setName("description");
        attributes41.setNullable(true);
        attributes41.setSingle(false);
//      ...................... Entities ........................
        Entities entity74 = new Entities();
        entity74 = findBean.nameEntities("Entities",em);
        attributes41.setEntities(entity74);
//      ...................... String ........................
        AttributesTypes attributesTypes75 = new AttributesTypes();
        attributesTypes75 = findBean.nameAttributesTypes("String",em);
        attributes41.setAttributesTypes(attributesTypes75);
        em.persist(attributes41);
        em.flush();

        Attributes attributes42 = new Attributes();
        attributes42.setName("observations");
        attributes42.setNullable(true);
        attributes42.setSingle(false);
//      ...................... Entities ........................
        Entities entity76 = new Entities();
        entity76 = findBean.nameEntities("Entities",em);
        attributes42.setEntities(entity76);
//      ...................... String ........................
        AttributesTypes attributesTypes77 = new AttributesTypes();
        attributesTypes77 = findBean.nameAttributesTypes("String",em);
        attributes42.setAttributesTypes(attributesTypes77);
        em.persist(attributes42);
        em.flush();

        Entities entities43 = new Entities();
        entities43.setName("NameQueries");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId78 = new GroupIds();
        groupId78 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities43.setGroupIds(groupId78);
        em.persist(entities43);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes44 = new Attributes();
        attributes44.setName("name");
        attributes44.setNullable(false);
        attributes44.setSingle(true);
//      ...................... NameQueries ........................
        Entities entity79 = new Entities();
        entity79 = findBean.nameEntities("NameQueries",em);
        attributes44.setEntities(entity79);
//      ...................... String ........................
        AttributesTypes attributesTypes80 = new AttributesTypes();
        attributesTypes80 = findBean.nameAttributesTypes("String",em);
        attributes44.setAttributesTypes(attributesTypes80);
        em.persist(attributes44);
        em.flush();

        Attributes attributes45 = new Attributes();
        attributes45.setName("query");
        attributes45.setNullable(false);
        attributes45.setSingle(true);
//      ...................... NameQueries ........................
        Entities entity81 = new Entities();
        entity81 = findBean.nameEntities("NameQueries",em);
        attributes45.setEntities(entity81);
//      ...................... String ........................
        AttributesTypes attributesTypes82 = new AttributesTypes();
        attributesTypes82 = findBean.nameAttributesTypes("String",em);
        attributes45.setAttributesTypes(attributesTypes82);
        em.persist(attributes45);
        em.flush();

        Attributes attributes46 = new Attributes();
        attributes46.setName("observations");
        attributes46.setNullable(true);
        attributes46.setSingle(false);
//      ...................... NameQueries ........................
        Entities entity83 = new Entities();
        entity83 = findBean.nameEntities("NameQueries",em);
        attributes46.setEntities(entity83);
//      ...................... String ........................
        AttributesTypes attributesTypes84 = new AttributesTypes();
        attributesTypes84 = findBean.nameAttributesTypes("String",em);
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

//      ---------------------- Attributes ------------------------

        Attributes attributes48 = new Attributes();
        attributes48.setName("name");
        attributes48.setNullable(false);
        attributes48.setSingle(true);
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
        attributes49.setNullable(false);
        attributes49.setSingle(false);
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
        attributes50.setName("artifactId");
        attributes50.setNullable(true);
        attributes50.setSingle(true);
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
        attributes51.setName("version");
        attributes51.setNullable(true);
        attributes51.setSingle(false);
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
        attributes52.setName("code");
        attributes52.setNullable(true);
        attributes52.setSingle(true);
//      ...................... GroupIds ........................
        Entities entity94 = new Entities();
        entity94 = findBean.nameEntities("GroupIds",em);
        attributes52.setEntities(entity94);
//      ...................... String ........................
        AttributesTypes attributesTypes95 = new AttributesTypes();
        attributesTypes95 = findBean.nameAttributesTypes("String",em);
        attributes52.setAttributesTypes(attributesTypes95);
        em.persist(attributes52);
        em.flush();

        Attributes attributes53 = new Attributes();
        attributes53.setName("date");
        attributes53.setNullable(true);
        attributes53.setSingle(false);
//      ...................... GroupIds ........................
        Entities entity96 = new Entities();
        entity96 = findBean.nameEntities("GroupIds",em);
        attributes53.setEntities(entity96);
//      ...................... Date ........................
        AttributesTypes attributesTypes97 = new AttributesTypes();
        attributesTypes97 = findBean.nameAttributesTypes("Date",em);
        attributes53.setAttributesTypes(attributesTypes97);
        em.persist(attributes53);
        em.flush();

        Entities entities54 = new Entities();
        entities54.setName("Attributes");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId98 = new GroupIds();
        groupId98 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities54.setGroupIds(groupId98);
        em.persist(entities54);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes55 = new Attributes();
        attributes55.setName("name");
        attributes55.setNullable(false);
        attributes55.setSingle(false);
//      ...................... Attributes ........................
        Entities entity99 = new Entities();
        entity99 = findBean.nameEntities("Attributes",em);
        attributes55.setEntities(entity99);
//      ...................... String ........................
        AttributesTypes attributesTypes100 = new AttributesTypes();
        attributesTypes100 = findBean.nameAttributesTypes("String",em);
        attributes55.setAttributesTypes(attributesTypes100);
        em.persist(attributes55);
        em.flush();

        Attributes attributes56 = new Attributes();
        attributes56.setName("length");
        attributes56.setNullable(true);
        attributes56.setSingle(false);
//      ...................... Attributes ........................
        Entities entity101 = new Entities();
        entity101 = findBean.nameEntities("Attributes",em);
        attributes56.setEntities(entity101);
//      ...................... Integer ........................
        AttributesTypes attributesTypes102 = new AttributesTypes();
        attributesTypes102 = findBean.nameAttributesTypes("Integer",em);
        attributes56.setAttributesTypes(attributesTypes102);
        em.persist(attributes56);
        em.flush();

        Attributes attributes57 = new Attributes();
        attributes57.setName("precision");
        attributes57.setNullable(true);
        attributes57.setSingle(false);
//      ...................... Attributes ........................
        Entities entity103 = new Entities();
        entity103 = findBean.nameEntities("Attributes",em);
        attributes57.setEntities(entity103);
//      ...................... Integer ........................
        AttributesTypes attributesTypes104 = new AttributesTypes();
        attributesTypes104 = findBean.nameAttributesTypes("Integer",em);
        attributes57.setAttributesTypes(attributesTypes104);
        em.persist(attributes57);
        em.flush();

        Attributes attributes58 = new Attributes();
        attributes58.setName("nullable");
        attributes58.setNullable(true);
        attributes58.setSingle(false);
//      ...................... Attributes ........................
        Entities entity105 = new Entities();
        entity105 = findBean.nameEntities("Attributes",em);
        attributes58.setEntities(entity105);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes106 = new AttributesTypes();
        attributesTypes106 = findBean.nameAttributesTypes("Boolean",em);
        attributes58.setAttributesTypes(attributesTypes106);
        em.persist(attributes58);
        em.flush();

        Attributes attributes59 = new Attributes();
        attributes59.setName("single");
        attributes59.setNullable(true);
        attributes59.setSingle(false);
//      ...................... Attributes ........................
        Entities entity107 = new Entities();
        entity107 = findBean.nameEntities("Attributes",em);
        attributes59.setEntities(entity107);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes108 = new AttributesTypes();
        attributesTypes108 = findBean.nameAttributesTypes("Boolean",em);
        attributes59.setAttributesTypes(attributesTypes108);
        em.persist(attributes59);
        em.flush();

        Attributes attributes60 = new Attributes();
        attributes60.setName("descripcion");
        attributes60.setNullable(true);
        attributes60.setSingle(false);
//      ...................... Attributes ........................
        Entities entity109 = new Entities();
        entity109 = findBean.nameEntities("Attributes",em);
        attributes60.setEntities(entity109);
//      ...................... String ........................
        AttributesTypes attributesTypes110 = new AttributesTypes();
        attributesTypes110 = findBean.nameAttributesTypes("String",em);
        attributes60.setAttributesTypes(attributesTypes110);
        em.persist(attributes60);
        em.flush();

        Attributes attributes61 = new Attributes();
        attributes61.setName("field");
        attributes61.setNullable(true);
        attributes61.setSingle(false);
//      ...................... Attributes ........................
        Entities entity111 = new Entities();
        entity111 = findBean.nameEntities("Attributes",em);
        attributes61.setEntities(entity111);
//      ...................... String ........................
        AttributesTypes attributesTypes112 = new AttributesTypes();
        attributesTypes112 = findBean.nameAttributesTypes("String",em);
        attributes61.setAttributesTypes(attributesTypes112);
        em.persist(attributes61);
        em.flush();

        Attributes attributes62 = new Attributes();
        attributes62.setName("access");
        attributes62.setNullable(true);
        attributes62.setSingle(false);
//      ...................... Attributes ........................
        Entities entity113 = new Entities();
        entity113 = findBean.nameEntities("Attributes",em);
        attributes62.setEntities(entity113);
//      ...................... String ........................
        AttributesTypes attributesTypes114 = new AttributesTypes();
        attributesTypes114 = findBean.nameAttributesTypes("String",em);
        attributes62.setAttributesTypes(attributesTypes114);
        em.persist(attributes62);
        em.flush();

        Attributes attributes63 = new Attributes();
        attributes63.setName("columnDefinition");
        attributes63.setNullable(true);
        attributes63.setSingle(false);
//      ...................... Attributes ........................
        Entities entity115 = new Entities();
        entity115 = findBean.nameEntities("Attributes",em);
        attributes63.setEntities(entity115);
//      ...................... String ........................
        AttributesTypes attributesTypes116 = new AttributesTypes();
        attributesTypes116 = findBean.nameAttributesTypes("String",em);
        attributes63.setAttributesTypes(attributesTypes116);
        em.persist(attributes63);
        em.flush();

        Attributes attributes64 = new Attributes();
        attributes64.setName("annotationsField");
        attributes64.setNullable(true);
        attributes64.setSingle(false);
//      ...................... Attributes ........................
        Entities entity117 = new Entities();
        entity117 = findBean.nameEntities("Attributes",em);
        attributes64.setEntities(entity117);
//      ...................... String ........................
        AttributesTypes attributesTypes118 = new AttributesTypes();
        attributesTypes118 = findBean.nameAttributesTypes("String",em);
        attributes64.setAttributesTypes(attributesTypes118);
        em.persist(attributes64);
        em.flush();

        Attributes attributes65 = new Attributes();
        attributes65.setName("annotationsMethod");
        attributes65.setNullable(true);
        attributes65.setSingle(false);
//      ...................... Attributes ........................
        Entities entity119 = new Entities();
        entity119 = findBean.nameEntities("Attributes",em);
        attributes65.setEntities(entity119);
//      ...................... String ........................
        AttributesTypes attributesTypes120 = new AttributesTypes();
        attributesTypes120 = findBean.nameAttributesTypes("String",em);
        attributes65.setAttributesTypes(attributesTypes120);
        em.persist(attributes65);
        em.flush();

        Attributes attributes66 = new Attributes();
        attributes66.setName("observations");
        attributes66.setNullable(true);
        attributes66.setSingle(false);
//      ...................... Attributes ........................
        Entities entity121 = new Entities();
        entity121 = findBean.nameEntities("Attributes",em);
        attributes66.setEntities(entity121);
//      ...................... String ........................
        AttributesTypes attributesTypes122 = new AttributesTypes();
        attributesTypes122 = findBean.nameAttributesTypes("String",em);
        attributes66.setAttributesTypes(attributesTypes122);
        em.persist(attributes66);
        em.flush();

        Entities entities67 = new Entities();
        entities67.setName("Relationships");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId123 = new GroupIds();
        groupId123 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities67.setGroupIds(groupId123);
        em.persist(entities67);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes68 = new Attributes();
        attributes68.setName("name");
        attributes68.setNullable(true);
        attributes68.setSingle(false);
//      ...................... Relationships ........................
        Entities entity124 = new Entities();
        entity124 = findBean.nameEntities("Relationships",em);
        attributes68.setEntities(entity124);
//      ...................... String ........................
        AttributesTypes attributesTypes125 = new AttributesTypes();
        attributesTypes125 = findBean.nameAttributesTypes("String",em);
        attributes68.setAttributesTypes(attributesTypes125);
        em.persist(attributes68);
        em.flush();

        Attributes attributes69 = new Attributes();
        attributes69.setName("optionality");
        attributes69.setNullable(true);
        attributes69.setSingle(false);
//      ...................... Relationships ........................
        Entities entity126 = new Entities();
        entity126 = findBean.nameEntities("Relationships",em);
        attributes69.setEntities(entity126);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes127 = new AttributesTypes();
        attributesTypes127 = findBean.nameAttributesTypes("Boolean",em);
        attributes69.setAttributesTypes(attributesTypes127);
        em.persist(attributes69);
        em.flush();

        Attributes attributes70 = new Attributes();
        attributes70.setName("isEmbedded");
        attributes70.setNullable(true);
        attributes70.setSingle(false);
//      ...................... Relationships ........................
        Entities entity128 = new Entities();
        entity128 = findBean.nameEntities("Relationships",em);
        attributes70.setEntities(entity128);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes129 = new AttributesTypes();
        attributesTypes129 = findBean.nameAttributesTypes("Boolean",em);
        attributes70.setAttributesTypes(attributesTypes129);
        em.persist(attributes70);
        em.flush();

        Attributes attributes71 = new Attributes();
        attributes71.setName("observations");
        attributes71.setNullable(true);
        attributes71.setSingle(false);
//      ...................... Relationships ........................
        Entities entity130 = new Entities();
        entity130 = findBean.nameEntities("Relationships",em);
        attributes71.setEntities(entity130);
//      ...................... String ........................
        AttributesTypes attributesTypes131 = new AttributesTypes();
        attributesTypes131 = findBean.nameAttributesTypes("String",em);
        attributes71.setAttributesTypes(attributesTypes131);
        em.persist(attributes71);
        em.flush();

        Entities entities72 = new Entities();
        entities72.setName("Models");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId132 = new GroupIds();
        groupId132 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities72.setGroupIds(groupId132);
        em.persist(entities72);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes73 = new Attributes();
        attributes73.setName("name");
        attributes73.setNullable(false);
        attributes73.setSingle(true);
//      ...................... Models ........................
        Entities entity133 = new Entities();
        entity133 = findBean.nameEntities("Models",em);
        attributes73.setEntities(entity133);
//      ...................... String ........................
        AttributesTypes attributesTypes134 = new AttributesTypes();
        attributesTypes134 = findBean.nameAttributesTypes("String",em);
        attributes73.setAttributesTypes(attributesTypes134);
        em.persist(attributes73);
        em.flush();

        Attributes attributes74 = new Attributes();
        attributes74.setName("groupId");
        attributes74.setNullable(false);
        attributes74.setSingle(false);
//      ...................... Models ........................
        Entities entity135 = new Entities();
        entity135 = findBean.nameEntities("Models",em);
        attributes74.setEntities(entity135);
//      ...................... String ........................
        AttributesTypes attributesTypes136 = new AttributesTypes();
        attributesTypes136 = findBean.nameAttributesTypes("String",em);
        attributes74.setAttributesTypes(attributesTypes136);
        em.persist(attributes74);
        em.flush();

        Attributes attributes75 = new Attributes();
        attributes75.setName("artifactId");
        attributes75.setNullable(true);
        attributes75.setSingle(true);
//      ...................... Models ........................
        Entities entity137 = new Entities();
        entity137 = findBean.nameEntities("Models",em);
        attributes75.setEntities(entity137);
//      ...................... String ........................
        AttributesTypes attributesTypes138 = new AttributesTypes();
        attributesTypes138 = findBean.nameAttributesTypes("String",em);
        attributes75.setAttributesTypes(attributesTypes138);
        em.persist(attributes75);
        em.flush();

        Attributes attributes76 = new Attributes();
        attributes76.setName("version");
        attributes76.setNullable(true);
        attributes76.setSingle(false);
//      ...................... Models ........................
        Entities entity139 = new Entities();
        entity139 = findBean.nameEntities("Models",em);
        attributes76.setEntities(entity139);
//      ...................... String ........................
        AttributesTypes attributesTypes140 = new AttributesTypes();
        attributesTypes140 = findBean.nameAttributesTypes("String",em);
        attributes76.setAttributesTypes(attributesTypes140);
        em.persist(attributes76);
        em.flush();

        Attributes attributes77 = new Attributes();
        attributes77.setName("code");
        attributes77.setNullable(true);
        attributes77.setSingle(true);
//      ...................... Models ........................
        Entities entity141 = new Entities();
        entity141 = findBean.nameEntities("Models",em);
        attributes77.setEntities(entity141);
//      ...................... String ........................
        AttributesTypes attributesTypes142 = new AttributesTypes();
        attributesTypes142 = findBean.nameAttributesTypes("String",em);
        attributes77.setAttributesTypes(attributesTypes142);
        em.persist(attributes77);
        em.flush();

        Attributes attributes78 = new Attributes();
        attributes78.setName("date");
        attributes78.setNullable(true);
        attributes78.setSingle(false);
//      ...................... Models ........................
        Entities entity143 = new Entities();
        entity143 = findBean.nameEntities("Models",em);
        attributes78.setEntities(entity143);
//      ...................... Date ........................
        AttributesTypes attributesTypes144 = new AttributesTypes();
        attributesTypes144 = findBean.nameAttributesTypes("Date",em);
        attributes78.setAttributesTypes(attributesTypes144);
        em.persist(attributes78);
        em.flush();

//      ---------------------- Entities ------------------------

//      ---------------------- Relationships ------------------------

/*
. Dependencies . 1..* Imports rolA: rolB:

. AttributesProperties . *..* Imports rolA:from rolB: OK

. AttributesTypes . *..* AttributesProperties rolA:from rolB: OK

*/
        Relationships relationships1 = new Relationships();
        relationships1.setOptionality(true);
        relationships1.setIsEmbedded(false);
//      ...................... Dependencies ........................
        Entities entities145 = new Entities();
        entities145 = findBean.nameEntities("Dependencies",em);
        relationships1.setFrom(entities145);
//      ...................... Imports ........................
        Entities entities146 = new Entities();
        entities146 = findBean.nameEntities("Imports",em);
        relationships1.setTo(entities146);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities147 = new Cardinalities();
        cardinalities147 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships1.setCardinalities(cardinalities147);
        em.persist(relationships1);
        em.flush();

        Relationships relationships2 = new Relationships();
        relationships2.setOptionality(true);
        relationships2.setIsEmbedded(false);
//      ...................... AttributesProperties ........................
        Entities entities148 = new Entities();
        entities148 = findBean.nameEntities("AttributesProperties",em);
        relationships2.setFrom(entities148);
//      ...................... Imports ........................
        Entities entities149 = new Entities();
        entities149 = findBean.nameEntities("Imports",em);
        relationships2.setTo(entities149);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities150 = new Cardinalities();
        cardinalities150 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
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
. Entities . *..* Imports rolA:from rolB: OK

. Relationships . *..* AttributesProperties rolA:from rolB: OK

. Attributes . *..* AttributesProperties rolA:from rolB: OK

. AttributesTypes . 1..* Attributes rolA: rolB:

. Cardinalities . *..* Imports rolA:from rolB: OK

*/
        Relationships relationships4 = new Relationships();
        relationships4.setOptionality(true);
        relationships4.setIsEmbedded(false);
//      ...................... Entities ........................
        Entities entities154 = new Entities();
        entities154 = findBean.nameEntities("Entities",em);
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
//      ...................... Relationships ........................
        Entities entities157 = new Entities();
        entities157 = findBean.nameEntities("Relationships",em);
        relationships5.setFrom(entities157);
//      ...................... AttributesProperties ........................
        Entities entities158 = new Entities();
        entities158 = findBean.nameEntities("AttributesProperties",em);
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
//      ...................... Attributes ........................
        Entities entities160 = new Entities();
        entities160 = findBean.nameEntities("Attributes",em);
        relationships6.setFrom(entities160);
//      ...................... AttributesProperties ........................
        Entities entities161 = new Entities();
        entities161 = findBean.nameEntities("AttributesProperties",em);
        relationships6.setTo(entities161);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities162 = new Cardinalities();
        cardinalities162 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships6.setCardinalities(cardinalities162);
        em.persist(relationships6);
        em.flush();

        Relationships relationships7 = new Relationships();
        relationships7.setOptionality(true);
        relationships7.setIsEmbedded(false);
//      ...................... AttributesTypes ........................
        Entities entities163 = new Entities();
        entities163 = findBean.nameEntities("AttributesTypes",em);
        relationships7.setFrom(entities163);
//      ...................... Attributes ........................
        Entities entities164 = new Entities();
        entities164 = findBean.nameEntities("Attributes",em);
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

/*
*/
/*
. Models . 1..* GroupIds rolA: rolB:

. GroupIds . 1..* Entities rolA: rolB:

. Entities . 1..* Relationships rolA: rolB:

. Entities . 1..* Attributes rolA: rolB:

. Entities . 1..* Relationships rolA: rolB:

. Developments . *..* Models rolA:from rolB: OK

. Entities . 1..* NameQueries rolA: rolB:

. Cardinalities . 1..* Relationships rolA: rolB:

*/
        Relationships relationships9 = new Relationships();
        relationships9.setOptionality(true);
        relationships9.setIsEmbedded(false);
//      ...................... Models ........................
        Entities entities169 = new Entities();
        entities169 = findBean.nameEntities("Models",em);
        relationships9.setFrom(entities169);
//      ...................... GroupIds ........................
        Entities entities170 = new Entities();
        entities170 = findBean.nameEntities("GroupIds",em);
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
//      ...................... GroupIds ........................
        Entities entities172 = new Entities();
        entities172 = findBean.nameEntities("GroupIds",em);
        relationships10.setFrom(entities172);
//      ...................... Entities ........................
        Entities entities173 = new Entities();
        entities173 = findBean.nameEntities("Entities",em);
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
        relationships11.setName("from");
//      ...................... Entities ........................
        Entities entities175 = new Entities();
        entities175 = findBean.nameEntities("Entities",em);
        relationships11.setFrom(entities175);
//      ...................... Relationships ........................
        Entities entities176 = new Entities();
        entities176 = findBean.nameEntities("Relationships",em);
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
//      ...................... Entities ........................
        Entities entities178 = new Entities();
        entities178 = findBean.nameEntities("Entities",em);
        relationships12.setFrom(entities178);
//      ...................... Attributes ........................
        Entities entities179 = new Entities();
        entities179 = findBean.nameEntities("Attributes",em);
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
        relationships13.setName("to");
//      ...................... Entities ........................
        Entities entities181 = new Entities();
        entities181 = findBean.nameEntities("Entities",em);
        relationships13.setFrom(entities181);
//      ...................... Relationships ........................
        Entities entities182 = new Entities();
        entities182 = findBean.nameEntities("Relationships",em);
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
//      ...................... Developments ........................
        Entities entities184 = new Entities();
        entities184 = findBean.nameEntities("Developments",em);
        relationships14.setFrom(entities184);
//      ...................... Models ........................
        Entities entities185 = new Entities();
        entities185 = findBean.nameEntities("Models",em);
        relationships14.setTo(entities185);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities186 = new Cardinalities();
        cardinalities186 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships14.setCardinalities(cardinalities186);
        em.persist(relationships14);
        em.flush();

        Relationships relationships15 = new Relationships();
        relationships15.setOptionality(true);
        relationships15.setIsEmbedded(false);
//      ...................... Entities ........................
        Entities entities187 = new Entities();
        entities187 = findBean.nameEntities("Entities",em);
        relationships15.setFrom(entities187);
//      ...................... NameQueries ........................
        Entities entities188 = new Entities();
        entities188 = findBean.nameEntities("NameQueries",em);
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
//      ...................... Cardinalities ........................
        Entities entities190 = new Entities();
        entities190 = findBean.nameEntities("Cardinalities",em);
        relationships16.setFrom(entities190);
//      ...................... Relationships ........................
        Entities entities191 = new Entities();
        entities191 = findBean.nameEntities("Relationships",em);
        relationships16.setTo(entities191);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities192 = new Cardinalities();
        cardinalities192 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships16.setCardinalities(cardinalities192);
        em.persist(relationships16);
        em.flush();

    } // data()

} // naifg
