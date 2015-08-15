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
        groupIds1.setGroupId("co.simasoft.models.dev.naifg.sites");
        groupIds1.setArtifactId("co.simasoft.models.dev.naifg.sites");
        em.persist(groupIds1);
        em.flush();

        GroupIds groupIds2 = new GroupIds();
        groupIds2.setGroupId("co.simasoft.models.dev.naifg");
        groupIds2.setArtifactId("co.simasoft.models.dev.naifg");
        em.persist(groupIds2);
        em.flush();

        GroupIds groupIds3 = new GroupIds();
        groupIds3.setGroupId("co.simasoft.models.dev.naifg.dependencies");
        groupIds3.setArtifactId("co.simasoft.models.dev.naifg.dependencies");
        em.persist(groupIds3);
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

        Attributes attributes2 = new Attributes();
        attributes2.setName("name");
        attributes2.setIsNullable(false);
        attributes2.setIsUnique(false);
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
        attributes3.setIsNullable(true);
        attributes3.setIsUnique(false);
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
        attributes4.setIsNullable(true);
        attributes4.setIsUnique(false);
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
        attributes5.setName("isNullable");
        attributes5.setIsNullable(true);
        attributes5.setIsUnique(false);
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
        attributes6.setName("isUnique");
        attributes6.setIsNullable(true);
        attributes6.setIsUnique(false);
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
        attributes7.setName("isSimplified");
        attributes7.setIsNullable(true);
        attributes7.setIsUnique(false);
//      ...................... Attributes ........................
        Entities entity12 = new Entities();
        entity12 = findBean.nameEntities("Attributes",em);
        attributes7.setEntities(entity12);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes13 = new AttributesTypes();
        attributesTypes13 = findBean.nameAttributesTypes("Boolean",em);
        attributes7.setAttributesTypes(attributesTypes13);
        em.persist(attributes7);
        em.flush();

        Attributes attributes8 = new Attributes();
        attributes8.setName("description");
        attributes8.setIsNullable(true);
        attributes8.setIsUnique(false);
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

        Entities entities9 = new Entities();
        entities9.setName("Entities");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId16 = new GroupIds();
        groupId16 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities9.setGroupIds(groupId16);
        em.persist(entities9);
        em.flush();

        Attributes attributes10 = new Attributes();
        attributes10.setName("name");
        attributes10.setIsNullable(false);
        attributes10.setIsUnique(true);
//      ...................... Entities ........................
        Entities entity17 = new Entities();
        entity17 = findBean.nameEntities("Entities",em);
        attributes10.setEntities(entity17);
//      ...................... String ........................
        AttributesTypes attributesTypes18 = new AttributesTypes();
        attributesTypes18 = findBean.nameAttributesTypes("String",em);
        attributes10.setAttributesTypes(attributesTypes18);
        em.persist(attributes10);
        em.flush();

        Attributes attributes11 = new Attributes();
        attributes11.setName("serialID");
        attributes11.setIsNullable(true);
        attributes11.setIsUnique(false);
//      ...................... Entities ........................
        Entities entity19 = new Entities();
        entity19 = findBean.nameEntities("Entities",em);
        attributes11.setEntities(entity19);
//      ...................... String ........................
        AttributesTypes attributesTypes20 = new AttributesTypes();
        attributesTypes20 = findBean.nameAttributesTypes("String",em);
        attributes11.setAttributesTypes(attributesTypes20);
        em.persist(attributes11);
        em.flush();

        Attributes attributes12 = new Attributes();
        attributes12.setName("table");
        attributes12.setIsNullable(true);
        attributes12.setIsUnique(false);
//      ...................... Entities ........................
        Entities entity21 = new Entities();
        entity21 = findBean.nameEntities("Entities",em);
        attributes12.setEntities(entity21);
//      ...................... String ........................
        AttributesTypes attributesTypes22 = new AttributesTypes();
        attributesTypes22 = findBean.nameAttributesTypes("String",em);
        attributes12.setAttributesTypes(attributesTypes22);
        em.persist(attributes12);
        em.flush();

        Attributes attributes13 = new Attributes();
        attributes13.setName("isSimplified");
        attributes13.setIsNullable(true);
        attributes13.setIsUnique(false);
//      ...................... Entities ........................
        Entities entity23 = new Entities();
        entity23 = findBean.nameEntities("Entities",em);
        attributes13.setEntities(entity23);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes24 = new AttributesTypes();
        attributesTypes24 = findBean.nameAttributesTypes("Boolean",em);
        attributes13.setAttributesTypes(attributesTypes24);
        em.persist(attributes13);
        em.flush();

        Attributes attributes14 = new Attributes();
        attributes14.setName("description");
        attributes14.setIsNullable(true);
        attributes14.setIsUnique(false);
//      ...................... Entities ........................
        Entities entity25 = new Entities();
        entity25 = findBean.nameEntities("Entities",em);
        attributes14.setEntities(entity25);
//      ...................... String ........................
        AttributesTypes attributesTypes26 = new AttributesTypes();
        attributesTypes26 = findBean.nameAttributesTypes("String",em);
        attributes14.setAttributesTypes(attributesTypes26);
        em.persist(attributes14);
        em.flush();

        Entities entities15 = new Entities();
        entities15.setName("ModelsGroupIds");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId27 = new GroupIds();
        groupId27 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities15.setGroupIds(groupId27);
        em.persist(entities15);
        em.flush();

        Attributes attributes16 = new Attributes();
        attributes16.setName("groupId");
        attributes16.setIsNullable(true);
        attributes16.setIsUnique(false);
//      ...................... ModelsGroupIds ........................
        Entities entity28 = new Entities();
        entity28 = findBean.nameEntities("ModelsGroupIds",em);
        attributes16.setEntities(entity28);
//      ...................... String ........................
        AttributesTypes attributesTypes29 = new AttributesTypes();
        attributesTypes29 = findBean.nameAttributesTypes("String",em);
        attributes16.setAttributesTypes(attributesTypes29);
        em.persist(attributes16);
        em.flush();

        Attributes attributes17 = new Attributes();
        attributes17.setName("isSingle");
        attributes17.setIsNullable(true);
        attributes17.setIsUnique(false);
//      ...................... ModelsGroupIds ........................
        Entities entity30 = new Entities();
        entity30 = findBean.nameEntities("ModelsGroupIds",em);
        attributes17.setEntities(entity30);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes31 = new AttributesTypes();
        attributesTypes31 = findBean.nameAttributesTypes("Boolean",em);
        attributes17.setAttributesTypes(attributesTypes31);
        em.persist(attributes17);
        em.flush();

        Attributes attributes18 = new Attributes();
        attributes18.setName("isSimplified");
        attributes18.setIsNullable(true);
        attributes18.setIsUnique(false);
//      ...................... ModelsGroupIds ........................
        Entities entity32 = new Entities();
        entity32 = findBean.nameEntities("ModelsGroupIds",em);
        attributes18.setEntities(entity32);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes33 = new AttributesTypes();
        attributesTypes33 = findBean.nameAttributesTypes("Boolean",em);
        attributes18.setAttributesTypes(attributesTypes33);
        em.persist(attributes18);
        em.flush();

        Entities entities19 = new Entities();
        entities19.setName("Models");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId34 = new GroupIds();
        groupId34 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities19.setGroupIds(groupId34);
        em.persist(entities19);
        em.flush();

        Attributes attributes20 = new Attributes();
        attributes20.setName("name");
        attributes20.setIsNullable(false);
        attributes20.setIsUnique(true);
//      ...................... Models ........................
        Entities entity35 = new Entities();
        entity35 = findBean.nameEntities("Models",em);
        attributes20.setEntities(entity35);
//      ...................... String ........................
        AttributesTypes attributesTypes36 = new AttributesTypes();
        attributesTypes36 = findBean.nameAttributesTypes("String",em);
        attributes20.setAttributesTypes(attributesTypes36);
        em.persist(attributes20);
        em.flush();

        Attributes attributes21 = new Attributes();
        attributes21.setName("groupId");
        attributes21.setIsNullable(false);
        attributes21.setIsUnique(true);
//      ...................... Models ........................
        Entities entity37 = new Entities();
        entity37 = findBean.nameEntities("Models",em);
        attributes21.setEntities(entity37);
//      ...................... String ........................
        AttributesTypes attributesTypes38 = new AttributesTypes();
        attributesTypes38 = findBean.nameAttributesTypes("String",em);
        attributes21.setAttributesTypes(attributesTypes38);
        em.persist(attributes21);
        em.flush();

        Attributes attributes22 = new Attributes();
        attributes22.setName("artifactId");
        attributes22.setIsNullable(false);
        attributes22.setIsUnique(true);
//      ...................... Models ........................
        Entities entity39 = new Entities();
        entity39 = findBean.nameEntities("Models",em);
        attributes22.setEntities(entity39);
//      ...................... String ........................
        AttributesTypes attributesTypes40 = new AttributesTypes();
        attributesTypes40 = findBean.nameAttributesTypes("String",em);
        attributes22.setAttributesTypes(attributesTypes40);
        em.persist(attributes22);
        em.flush();

        Attributes attributes23 = new Attributes();
        attributes23.setName("version");
        attributes23.setIsNullable(true);
        attributes23.setIsUnique(false);
//      ...................... Models ........................
        Entities entity41 = new Entities();
        entity41 = findBean.nameEntities("Models",em);
        attributes23.setEntities(entity41);
//      ...................... String ........................
        AttributesTypes attributesTypes42 = new AttributesTypes();
        attributesTypes42 = findBean.nameAttributesTypes("String",em);
        attributes23.setAttributesTypes(attributesTypes42);
        em.persist(attributes23);
        em.flush();

        Attributes attributes24 = new Attributes();
        attributes24.setName("code");
        attributes24.setIsNullable(true);
        attributes24.setIsUnique(false);
//      ...................... Models ........................
        Entities entity43 = new Entities();
        entity43 = findBean.nameEntities("Models",em);
        attributes24.setEntities(entity43);
//      ...................... String ........................
        AttributesTypes attributesTypes44 = new AttributesTypes();
        attributesTypes44 = findBean.nameAttributesTypes("String",em);
        attributes24.setAttributesTypes(attributesTypes44);
        em.persist(attributes24);
        em.flush();

        Attributes attributes25 = new Attributes();
        attributes25.setName("date");
        attributes25.setIsNullable(true);
        attributes25.setIsUnique(false);
//      ...................... Models ........................
        Entities entity45 = new Entities();
        entity45 = findBean.nameEntities("Models",em);
        attributes25.setEntities(entity45);
//      ...................... Date ........................
        AttributesTypes attributesTypes46 = new AttributesTypes();
        attributesTypes46 = findBean.nameAttributesTypes("Date",em);
        attributes25.setAttributesTypes(attributesTypes46);
        em.persist(attributes25);
        em.flush();

        Entities entities26 = new Entities();
        entities26.setName("Relationships");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId47 = new GroupIds();
        groupId47 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities26.setGroupIds(groupId47);
        em.persist(entities26);
        em.flush();

        Attributes attributes27 = new Attributes();
        attributes27.setName("name");
        attributes27.setIsNullable(true);
        attributes27.setIsUnique(false);
//      ...................... Relationships ........................
        Entities entity48 = new Entities();
        entity48 = findBean.nameEntities("Relationships",em);
        attributes27.setEntities(entity48);
//      ...................... String ........................
        AttributesTypes attributesTypes49 = new AttributesTypes();
        attributesTypes49 = findBean.nameAttributesTypes("String",em);
        attributes27.setAttributesTypes(attributesTypes49);
        em.persist(attributes27);
        em.flush();

        Attributes attributes28 = new Attributes();
        attributes28.setName("isOptionality");
        attributes28.setIsNullable(true);
        attributes28.setIsUnique(false);
//      ...................... Relationships ........................
        Entities entity50 = new Entities();
        entity50 = findBean.nameEntities("Relationships",em);
        attributes28.setEntities(entity50);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes51 = new AttributesTypes();
        attributesTypes51 = findBean.nameAttributesTypes("Boolean",em);
        attributes28.setAttributesTypes(attributesTypes51);
        em.persist(attributes28);
        em.flush();

        Attributes attributes29 = new Attributes();
        attributes29.setName("isEmbedded");
        attributes29.setIsNullable(true);
        attributes29.setIsUnique(false);
//      ...................... Relationships ........................
        Entities entity52 = new Entities();
        entity52 = findBean.nameEntities("Relationships",em);
        attributes29.setEntities(entity52);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes53 = new AttributesTypes();
        attributesTypes53 = findBean.nameAttributesTypes("Boolean",em);
        attributes29.setAttributesTypes(attributesTypes53);
        em.persist(attributes29);
        em.flush();

        Attributes attributes30 = new Attributes();
        attributes30.setName("isSimplified");
        attributes30.setIsNullable(true);
        attributes30.setIsUnique(false);
//      ...................... Relationships ........................
        Entities entity54 = new Entities();
        entity54 = findBean.nameEntities("Relationships",em);
        attributes30.setEntities(entity54);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes55 = new AttributesTypes();
        attributesTypes55 = findBean.nameAttributesTypes("Boolean",em);
        attributes30.setAttributesTypes(attributesTypes55);
        em.persist(attributes30);
        em.flush();

        Entities entities31 = new Entities();
        entities31.setName("Developments");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId56 = new GroupIds();
        groupId56 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities31.setGroupIds(groupId56);
        em.persist(entities31);
        em.flush();

        Attributes attributes32 = new Attributes();
        attributes32.setName("name");
        attributes32.setIsNullable(false);
        attributes32.setIsUnique(true);
//      ...................... Developments ........................
        Entities entity57 = new Entities();
        entity57 = findBean.nameEntities("Developments",em);
        attributes32.setEntities(entity57);
//      ...................... String ........................
        AttributesTypes attributesTypes58 = new AttributesTypes();
        attributesTypes58 = findBean.nameAttributesTypes("String",em);
        attributes32.setAttributesTypes(attributesTypes58);
        em.persist(attributes32);
        em.flush();

        Attributes attributes33 = new Attributes();
        attributes33.setName("groupId");
        attributes33.setIsNullable(false);
        attributes33.setIsUnique(true);
//      ...................... Developments ........................
        Entities entity59 = new Entities();
        entity59 = findBean.nameEntities("Developments",em);
        attributes33.setEntities(entity59);
//      ...................... String ........................
        AttributesTypes attributesTypes60 = new AttributesTypes();
        attributesTypes60 = findBean.nameAttributesTypes("String",em);
        attributes33.setAttributesTypes(attributesTypes60);
        em.persist(attributes33);
        em.flush();

        Attributes attributes34 = new Attributes();
        attributes34.setName("artifactId");
        attributes34.setIsNullable(false);
        attributes34.setIsUnique(true);
//      ...................... Developments ........................
        Entities entity61 = new Entities();
        entity61 = findBean.nameEntities("Developments",em);
        attributes34.setEntities(entity61);
//      ...................... String ........................
        AttributesTypes attributesTypes62 = new AttributesTypes();
        attributesTypes62 = findBean.nameAttributesTypes("String",em);
        attributes34.setAttributesTypes(attributesTypes62);
        em.persist(attributes34);
        em.flush();

        Attributes attributes35 = new Attributes();
        attributes35.setName("version");
        attributes35.setIsNullable(true);
        attributes35.setIsUnique(false);
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
        attributes36.setName("code");
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
        attributes37.setName("date");
        attributes37.setIsNullable(true);
        attributes37.setIsUnique(false);
//      ...................... Developments ........................
        Entities entity67 = new Entities();
        entity67 = findBean.nameEntities("Developments",em);
        attributes37.setEntities(entity67);
//      ...................... Date ........................
        AttributesTypes attributesTypes68 = new AttributesTypes();
        attributesTypes68 = findBean.nameAttributesTypes("Date",em);
        attributes37.setAttributesTypes(attributesTypes68);
        em.persist(attributes37);
        em.flush();

        Entities entities38 = new Entities();
        entities38.setName("GroupIds");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId69 = new GroupIds();
        groupId69 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities38.setGroupIds(groupId69);
        em.persist(entities38);
        em.flush();

        Attributes attributes39 = new Attributes();
        attributes39.setName("name");
        attributes39.setIsNullable(false);
        attributes39.setIsUnique(true);
//      ...................... GroupIds ........................
        Entities entity70 = new Entities();
        entity70 = findBean.nameEntities("GroupIds",em);
        attributes39.setEntities(entity70);
//      ...................... String ........................
        AttributesTypes attributesTypes71 = new AttributesTypes();
        attributesTypes71 = findBean.nameAttributesTypes("String",em);
        attributes39.setAttributesTypes(attributesTypes71);
        em.persist(attributes39);
        em.flush();

        Attributes attributes40 = new Attributes();
        attributes40.setName("groupId");
        attributes40.setIsNullable(false);
        attributes40.setIsUnique(true);
//      ...................... GroupIds ........................
        Entities entity72 = new Entities();
        entity72 = findBean.nameEntities("GroupIds",em);
        attributes40.setEntities(entity72);
//      ...................... String ........................
        AttributesTypes attributesTypes73 = new AttributesTypes();
        attributesTypes73 = findBean.nameAttributesTypes("String",em);
        attributes40.setAttributesTypes(attributesTypes73);
        em.persist(attributes40);
        em.flush();

        Attributes attributes41 = new Attributes();
        attributes41.setName("artifactId");
        attributes41.setIsNullable(false);
        attributes41.setIsUnique(true);
//      ...................... GroupIds ........................
        Entities entity74 = new Entities();
        entity74 = findBean.nameEntities("GroupIds",em);
        attributes41.setEntities(entity74);
//      ...................... String ........................
        AttributesTypes attributesTypes75 = new AttributesTypes();
        attributesTypes75 = findBean.nameAttributesTypes("String",em);
        attributes41.setAttributesTypes(attributesTypes75);
        em.persist(attributes41);
        em.flush();

        Attributes attributes42 = new Attributes();
        attributes42.setName("version");
        attributes42.setIsNullable(true);
        attributes42.setIsUnique(false);
//      ...................... GroupIds ........................
        Entities entity76 = new Entities();
        entity76 = findBean.nameEntities("GroupIds",em);
        attributes42.setEntities(entity76);
//      ...................... String ........................
        AttributesTypes attributesTypes77 = new AttributesTypes();
        attributesTypes77 = findBean.nameAttributesTypes("String",em);
        attributes42.setAttributesTypes(attributesTypes77);
        em.persist(attributes42);
        em.flush();

        Attributes attributes43 = new Attributes();
        attributes43.setName("code");
        attributes43.setIsNullable(true);
        attributes43.setIsUnique(false);
//      ...................... GroupIds ........................
        Entities entity78 = new Entities();
        entity78 = findBean.nameEntities("GroupIds",em);
        attributes43.setEntities(entity78);
//      ...................... String ........................
        AttributesTypes attributesTypes79 = new AttributesTypes();
        attributesTypes79 = findBean.nameAttributesTypes("String",em);
        attributes43.setAttributesTypes(attributesTypes79);
        em.persist(attributes43);
        em.flush();

        Attributes attributes44 = new Attributes();
        attributes44.setName("date");
        attributes44.setIsNullable(true);
        attributes44.setIsUnique(false);
//      ...................... GroupIds ........................
        Entities entity80 = new Entities();
        entity80 = findBean.nameEntities("GroupIds",em);
        attributes44.setEntities(entity80);
//      ...................... Date ........................
        AttributesTypes attributesTypes81 = new AttributesTypes();
        attributesTypes81 = findBean.nameAttributesTypes("Date",em);
        attributes44.setAttributesTypes(attributesTypes81);
        em.persist(attributes44);
        em.flush();

        Entities entities45 = new Entities();
        entities45.setName("Cardinalities");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId82 = new GroupIds();
        groupId82 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities45.setGroupIds(groupId82);
        em.persist(entities45);
        em.flush();

        Attributes attributes46 = new Attributes();
        attributes46.setName("name");
        attributes46.setIsNullable(false);
        attributes46.setIsUnique(true);
//      ...................... Cardinalities ........................
        Entities entity83 = new Entities();
        entity83 = findBean.nameEntities("Cardinalities",em);
        attributes46.setEntities(entity83);
//      ...................... String ........................
        AttributesTypes attributesTypes84 = new AttributesTypes();
        attributesTypes84 = findBean.nameAttributesTypes("String",em);
        attributes46.setAttributesTypes(attributesTypes84);
        em.persist(attributes46);
        em.flush();

        Attributes attributes47 = new Attributes();
        attributes47.setName("cardinality");
        attributes47.setIsNullable(false);
        attributes47.setIsUnique(false);
//      ...................... Cardinalities ........................
        Entities entity85 = new Entities();
        entity85 = findBean.nameEntities("Cardinalities",em);
        attributes47.setEntities(entity85);
//      ...................... String ........................
        AttributesTypes attributesTypes86 = new AttributesTypes();
        attributesTypes86 = findBean.nameAttributesTypes("String",em);
        attributes47.setAttributesTypes(attributesTypes86);
        em.persist(attributes47);
        em.flush();

        Attributes attributes48 = new Attributes();
        attributes48.setName("isUnidirectional");
        attributes48.setIsNullable(true);
        attributes48.setIsUnique(false);
//      ...................... Cardinalities ........................
        Entities entity87 = new Entities();
        entity87 = findBean.nameEntities("Cardinalities",em);
        attributes48.setEntities(entity87);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes88 = new AttributesTypes();
        attributesTypes88 = findBean.nameAttributesTypes("Boolean",em);
        attributes48.setAttributesTypes(attributesTypes88);
        em.persist(attributes48);
        em.flush();

        Entities entities49 = new Entities();
        entities49.setName("NameQueries");
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId89 = new GroupIds();
        groupId89 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities49.setGroupIds(groupId89);
        em.persist(entities49);
        em.flush();

        Attributes attributes50 = new Attributes();
        attributes50.setName("name");
        attributes50.setIsNullable(false);
        attributes50.setIsUnique(true);
//      ...................... NameQueries ........................
        Entities entity90 = new Entities();
        entity90 = findBean.nameEntities("NameQueries",em);
        attributes50.setEntities(entity90);
//      ...................... String ........................
        AttributesTypes attributesTypes91 = new AttributesTypes();
        attributesTypes91 = findBean.nameAttributesTypes("String",em);
        attributes50.setAttributesTypes(attributesTypes91);
        em.persist(attributes50);
        em.flush();

        Attributes attributes51 = new Attributes();
        attributes51.setName("query");
        attributes51.setIsNullable(false);
        attributes51.setIsUnique(true);
//      ...................... NameQueries ........................
        Entities entity92 = new Entities();
        entity92 = findBean.nameEntities("NameQueries",em);
        attributes51.setEntities(entity92);
//      ...................... String ........................
        AttributesTypes attributesTypes93 = new AttributesTypes();
        attributesTypes93 = findBean.nameAttributesTypes("String",em);
        attributes51.setAttributesTypes(attributesTypes93);
        em.persist(attributes51);
        em.flush();

//      ---------------------- Entities ------------------------

        Entities entities52 = new Entities();
        entities52.setName("Imports");
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId94 = new GroupIds();
        groupId94 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities52.setGroupIds(groupId94);
        em.persist(entities52);
        em.flush();

        Attributes attributes53 = new Attributes();
        attributes53.setName("name");
        attributes53.setIsNullable(false);
        attributes53.setIsUnique(true);
//      ...................... Imports ........................
        Entities entity95 = new Entities();
        entity95 = findBean.nameEntities("Imports",em);
        attributes53.setEntities(entity95);
//      ...................... String ........................
        AttributesTypes attributesTypes96 = new AttributesTypes();
        attributesTypes96 = findBean.nameAttributesTypes("String",em);
        attributes53.setAttributesTypes(attributesTypes96);
        em.persist(attributes53);
        em.flush();

        Entities entities54 = new Entities();
        entities54.setName("AttributesProperties");
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId97 = new GroupIds();
        groupId97 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities54.setGroupIds(groupId97);
        em.persist(entities54);
        em.flush();

        Attributes attributes55 = new Attributes();
        attributes55.setName("name");
        attributes55.setIsNullable(false);
        attributes55.setIsUnique(true);
//      ...................... AttributesProperties ........................
        Entities entity98 = new Entities();
        entity98 = findBean.nameEntities("AttributesProperties",em);
        attributes55.setEntities(entity98);
//      ...................... String ........................
        AttributesTypes attributesTypes99 = new AttributesTypes();
        attributesTypes99 = findBean.nameAttributesTypes("String",em);
        attributes55.setAttributesTypes(attributesTypes99);
        em.persist(attributes55);
        em.flush();

        Attributes attributes56 = new Attributes();
        attributes56.setName("value");
        attributes56.setIsNullable(false);
        attributes56.setIsUnique(true);
//      ...................... AttributesProperties ........................
        Entities entity100 = new Entities();
        entity100 = findBean.nameEntities("AttributesProperties",em);
        attributes56.setEntities(entity100);
//      ...................... String ........................
        AttributesTypes attributesTypes101 = new AttributesTypes();
        attributesTypes101 = findBean.nameAttributesTypes("String",em);
        attributes56.setAttributesTypes(attributesTypes101);
        em.persist(attributes56);
        em.flush();

        Entities entities57 = new Entities();
        entities57.setName("AttributesTypes");
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId102 = new GroupIds();
        groupId102 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities57.setGroupIds(groupId102);
        em.persist(entities57);
        em.flush();

        Attributes attributes58 = new Attributes();
        attributes58.setName("name");
        attributes58.setIsNullable(false);
        attributes58.setIsUnique(true);
//      ...................... AttributesTypes ........................
        Entities entity103 = new Entities();
        entity103 = findBean.nameEntities("AttributesTypes",em);
        attributes58.setEntities(entity103);
//      ...................... String ........................
        AttributesTypes attributesTypes104 = new AttributesTypes();
        attributesTypes104 = findBean.nameAttributesTypes("String",em);
        attributes58.setAttributesTypes(attributesTypes104);
        em.persist(attributes58);
        em.flush();

        Attributes attributes59 = new Attributes();
        attributes59.setName("type");
        attributes59.setIsNullable(false);
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

        Attributes attributes60 = new Attributes();
        attributes60.setName("length");
        attributes60.setIsNullable(true);
        attributes60.setIsUnique(false);
//      ...................... AttributesTypes ........................
        Entities entity107 = new Entities();
        entity107 = findBean.nameEntities("AttributesTypes",em);
        attributes60.setEntities(entity107);
//      ...................... Integer ........................
        AttributesTypes attributesTypes108 = new AttributesTypes();
        attributesTypes108 = findBean.nameAttributesTypes("Integer",em);
        attributes60.setAttributesTypes(attributesTypes108);
        em.persist(attributes60);
        em.flush();

        Attributes attributes61 = new Attributes();
        attributes61.setName("precision");
        attributes61.setIsNullable(true);
        attributes61.setIsUnique(false);
//      ...................... AttributesTypes ........................
        Entities entity109 = new Entities();
        entity109 = findBean.nameEntities("AttributesTypes",em);
        attributes61.setEntities(entity109);
//      ...................... Integer ........................
        AttributesTypes attributesTypes110 = new AttributesTypes();
        attributesTypes110 = findBean.nameAttributesTypes("Integer",em);
        attributes61.setAttributesTypes(attributesTypes110);
        em.persist(attributes61);
        em.flush();

        Attributes attributes62 = new Attributes();
        attributes62.setName("annotations");
        attributes62.setIsNullable(true);
        attributes62.setIsUnique(false);
//      ...................... AttributesTypes ........................
        Entities entity111 = new Entities();
        entity111 = findBean.nameEntities("AttributesTypes",em);
        attributes62.setEntities(entity111);
//      ...................... String ........................
        AttributesTypes attributesTypes112 = new AttributesTypes();
        attributesTypes112 = findBean.nameAttributesTypes("String",em);
        attributes62.setAttributesTypes(attributesTypes112);
        em.persist(attributes62);
        em.flush();

        Entities entities63 = new Entities();
        entities63.setName("Dependencies");
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId113 = new GroupIds();
        groupId113 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities63.setGroupIds(groupId113);
        em.persist(entities63);
        em.flush();

        Attributes attributes64 = new Attributes();
        attributes64.setName("groupId");
        attributes64.setIsNullable(false);
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
        attributes65.setName("artifactId");
        attributes65.setIsNullable(false);
        attributes65.setIsUnique(false);
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
        attributes66.setName("version");
        attributes66.setIsNullable(true);
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

        Attributes attributes67 = new Attributes();
        attributes67.setName("type");
        attributes67.setIsNullable(true);
        attributes67.setIsUnique(false);
//      ...................... Dependencies ........................
        Entities entity120 = new Entities();
        entity120 = findBean.nameEntities("Dependencies",em);
        attributes67.setEntities(entity120);
//      ...................... String ........................
        AttributesTypes attributesTypes121 = new AttributesTypes();
        attributesTypes121 = findBean.nameAttributesTypes("String",em);
        attributes67.setAttributesTypes(attributesTypes121);
        em.persist(attributes67);
        em.flush();

        Attributes attributes68 = new Attributes();
        attributes68.setName("scope");
        attributes68.setIsNullable(true);
        attributes68.setIsUnique(false);
//      ...................... Dependencies ........................
        Entities entity122 = new Entities();
        entity122 = findBean.nameEntities("Dependencies",em);
        attributes68.setEntities(entity122);
//      ...................... String ........................
        AttributesTypes attributesTypes123 = new AttributesTypes();
        attributesTypes123 = findBean.nameAttributesTypes("String",em);
        attributes68.setAttributesTypes(attributesTypes123);
        em.persist(attributes68);
        em.flush();

        Attributes attributes69 = new Attributes();
        attributes69.setName("maven");
        attributes69.setIsNullable(false);
        attributes69.setIsUnique(true);
//      ...................... Dependencies ........................
        Entities entity124 = new Entities();
        entity124 = findBean.nameEntities("Dependencies",em);
        attributes69.setEntities(entity124);
//      ...................... String ........................
        AttributesTypes attributesTypes125 = new AttributesTypes();
        attributesTypes125 = findBean.nameAttributesTypes("String",em);
        attributes69.setAttributesTypes(attributesTypes125);
        em.persist(attributes69);
        em.flush();

//      ---------------------- Entities ------------------------

        Entities entities70 = new Entities();
        entities70.setName("SitesTypes");
//      ...................... co.simasoft.models.dev.naifg.sites ........................
        GroupIds groupId126 = new GroupIds();
        groupId126 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.sites",em);
        entities70.setGroupIds(groupId126);
        em.persist(entities70);
        em.flush();

        Attributes attributes71 = new Attributes();
        attributes71.setName("name");
        attributes71.setIsNullable(true);
        attributes71.setIsUnique(false);
//      ...................... SitesTypes ........................
        Entities entity127 = new Entities();
        entity127 = findBean.nameEntities("SitesTypes",em);
        attributes71.setEntities(entity127);
//      ...................... String ........................
        AttributesTypes attributesTypes128 = new AttributesTypes();
        attributesTypes128 = findBean.nameAttributesTypes("String",em);
        attributes71.setAttributesTypes(attributesTypes128);
        em.persist(attributes71);
        em.flush();

        Entities entities72 = new Entities();
        entities72.setName("Sites");
//      ...................... co.simasoft.models.dev.naifg.sites ........................
        GroupIds groupId129 = new GroupIds();
        groupId129 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.sites",em);
        entities72.setGroupIds(groupId129);
        em.persist(entities72);
        em.flush();

        Attributes attributes73 = new Attributes();
        attributes73.setName("title");
        attributes73.setIsNullable(true);
        attributes73.setIsUnique(false);
//      ...................... Sites ........................
        Entities entity130 = new Entities();
        entity130 = findBean.nameEntities("Sites",em);
        attributes73.setEntities(entity130);
//      ...................... String ........................
        AttributesTypes attributesTypes131 = new AttributesTypes();
        attributesTypes131 = findBean.nameAttributesTypes("String",em);
        attributes73.setAttributesTypes(attributesTypes131);
        em.persist(attributes73);
        em.flush();

        Attributes attributes74 = new Attributes();
        attributes74.setName("link");
        attributes74.setIsNullable(false);
        attributes74.setIsUnique(true);
//      ...................... Sites ........................
        Entities entity132 = new Entities();
        entity132 = findBean.nameEntities("Sites",em);
        attributes74.setEntities(entity132);
//      ...................... String ........................
        AttributesTypes attributesTypes133 = new AttributesTypes();
        attributesTypes133 = findBean.nameAttributesTypes("String",em);
        attributes74.setAttributesTypes(attributesTypes133);
        em.persist(attributes74);
        em.flush();

        Attributes attributes75 = new Attributes();
        attributes75.setName("abc");
        attributes75.setIsNullable(true);
        attributes75.setIsUnique(false);
//      ...................... Sites ........................
        Entities entity134 = new Entities();
        entity134 = findBean.nameEntities("Sites",em);
        attributes75.setEntities(entity134);
//      ...................... String ........................
        AttributesTypes attributesTypes135 = new AttributesTypes();
        attributesTypes135 = findBean.nameAttributesTypes("String",em);
        attributes75.setAttributesTypes(attributesTypes135);
        em.persist(attributes75);
        em.flush();

//      ---------------------- Entities ------------------------

//      ---------------------- Entities ------------------------

//      ---------------------- Entities ------------------------

//      ---------------------- Relationships ------------------------

/*
. SitesTypes . 1..* SitesTypes rolA: rolB:

. SitesTypes . *..* Sites rolA:from rolB: OK

*/
        Relationships relationships1 = new Relationships();
        relationships1.setIsOptionality(true);
        relationships1.setIsEmbedded(false);
//      ...................... SitesTypes ........................
        Entities entities136 = new Entities();
        entities136 = findBean.nameEntities("SitesTypes",em);
        relationships1.setFrom(entities136);
//      ...................... SitesTypes ........................
        Entities entities137 = new Entities();
        entities137 = findBean.nameEntities("SitesTypes",em);
        relationships1.setTo(entities137);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities138 = new Cardinalities();
        cardinalities138 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships1.setCardinalities(cardinalities138);
        em.persist(relationships1);
        em.flush();

        Relationships relationships2 = new Relationships();
        relationships2.setIsOptionality(true);
        relationships2.setIsEmbedded(false);
//      ...................... SitesTypes ........................
        Entities entities139 = new Entities();
        entities139 = findBean.nameEntities("SitesTypes",em);
        relationships2.setFrom(entities139);
//      ...................... Sites ........................
        Entities entities140 = new Entities();
        entities140 = findBean.nameEntities("Sites",em);
        relationships2.setTo(entities140);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities141 = new Cardinalities();
        cardinalities141 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships2.setCardinalities(cardinalities141);
        em.persist(relationships2);
        em.flush();

/*
. Cardinalities . *..* Imports rolA:from rolB: OK

. Entities . *..* Imports rolA:from rolB: OK

. Models . *..* Sites rolA:from rolB: OK

. Entities . *..* Sites rolA:from rolB: OK

. Developments . *..* Sites rolA:from rolB: OK

. Entities . *..* AttributesProperties rolA:from rolB: OK

. Cardinalities . *..* Sites rolA:from rolB: OK

. AttributesTypes . 1..* Attributes rolA: rolB:

. Attributes . *..* AttributesProperties rolA:from rolB: OK

. Relationships . *..* AttributesProperties rolA:from rolB: OK

. Attributes . *..* Sites rolA:from rolB: OK

*/
        Relationships relationships3 = new Relationships();
        relationships3.setIsOptionality(true);
        relationships3.setIsEmbedded(false);
//      ...................... Cardinalities ........................
        Entities entities142 = new Entities();
        entities142 = findBean.nameEntities("Cardinalities",em);
        relationships3.setFrom(entities142);
//      ...................... Imports ........................
        Entities entities143 = new Entities();
        entities143 = findBean.nameEntities("Imports",em);
        relationships3.setTo(entities143);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities144 = new Cardinalities();
        cardinalities144 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships3.setCardinalities(cardinalities144);
        em.persist(relationships3);
        em.flush();

        Relationships relationships4 = new Relationships();
        relationships4.setIsOptionality(true);
        relationships4.setIsEmbedded(false);
//      ...................... Entities ........................
        Entities entities145 = new Entities();
        entities145 = findBean.nameEntities("Entities",em);
        relationships4.setFrom(entities145);
//      ...................... Imports ........................
        Entities entities146 = new Entities();
        entities146 = findBean.nameEntities("Imports",em);
        relationships4.setTo(entities146);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities147 = new Cardinalities();
        cardinalities147 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships4.setCardinalities(cardinalities147);
        em.persist(relationships4);
        em.flush();

        Relationships relationships5 = new Relationships();
        relationships5.setIsOptionality(true);
        relationships5.setIsEmbedded(false);
//      ...................... Models ........................
        Entities entities148 = new Entities();
        entities148 = findBean.nameEntities("Models",em);
        relationships5.setFrom(entities148);
//      ...................... Sites ........................
        Entities entities149 = new Entities();
        entities149 = findBean.nameEntities("Sites",em);
        relationships5.setTo(entities149);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities150 = new Cardinalities();
        cardinalities150 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships5.setCardinalities(cardinalities150);
        em.persist(relationships5);
        em.flush();

        Relationships relationships6 = new Relationships();
        relationships6.setIsOptionality(true);
        relationships6.setIsEmbedded(false);
//      ...................... Entities ........................
        Entities entities151 = new Entities();
        entities151 = findBean.nameEntities("Entities",em);
        relationships6.setFrom(entities151);
//      ...................... Sites ........................
        Entities entities152 = new Entities();
        entities152 = findBean.nameEntities("Sites",em);
        relationships6.setTo(entities152);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities153 = new Cardinalities();
        cardinalities153 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships6.setCardinalities(cardinalities153);
        em.persist(relationships6);
        em.flush();

        Relationships relationships7 = new Relationships();
        relationships7.setIsOptionality(true);
        relationships7.setIsEmbedded(false);
//      ...................... Developments ........................
        Entities entities154 = new Entities();
        entities154 = findBean.nameEntities("Developments",em);
        relationships7.setFrom(entities154);
//      ...................... Sites ........................
        Entities entities155 = new Entities();
        entities155 = findBean.nameEntities("Sites",em);
        relationships7.setTo(entities155);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities156 = new Cardinalities();
        cardinalities156 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships7.setCardinalities(cardinalities156);
        em.persist(relationships7);
        em.flush();

        Relationships relationships8 = new Relationships();
        relationships8.setIsOptionality(true);
        relationships8.setIsEmbedded(false);
//      ...................... Entities ........................
        Entities entities157 = new Entities();
        entities157 = findBean.nameEntities("Entities",em);
        relationships8.setFrom(entities157);
//      ...................... AttributesProperties ........................
        Entities entities158 = new Entities();
        entities158 = findBean.nameEntities("AttributesProperties",em);
        relationships8.setTo(entities158);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities159 = new Cardinalities();
        cardinalities159 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships8.setCardinalities(cardinalities159);
        em.persist(relationships8);
        em.flush();

        Relationships relationships9 = new Relationships();
        relationships9.setIsOptionality(true);
        relationships9.setIsEmbedded(false);
//      ...................... Cardinalities ........................
        Entities entities160 = new Entities();
        entities160 = findBean.nameEntities("Cardinalities",em);
        relationships9.setFrom(entities160);
//      ...................... Sites ........................
        Entities entities161 = new Entities();
        entities161 = findBean.nameEntities("Sites",em);
        relationships9.setTo(entities161);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities162 = new Cardinalities();
        cardinalities162 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships9.setCardinalities(cardinalities162);
        em.persist(relationships9);
        em.flush();

        Relationships relationships10 = new Relationships();
        relationships10.setIsOptionality(true);
        relationships10.setIsEmbedded(false);
//      ...................... AttributesTypes ........................
        Entities entities163 = new Entities();
        entities163 = findBean.nameEntities("AttributesTypes",em);
        relationships10.setFrom(entities163);
//      ...................... Attributes ........................
        Entities entities164 = new Entities();
        entities164 = findBean.nameEntities("Attributes",em);
        relationships10.setTo(entities164);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities165 = new Cardinalities();
        cardinalities165 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships10.setCardinalities(cardinalities165);
        em.persist(relationships10);
        em.flush();

        Relationships relationships11 = new Relationships();
        relationships11.setIsOptionality(true);
        relationships11.setIsEmbedded(false);
//      ...................... Attributes ........................
        Entities entities166 = new Entities();
        entities166 = findBean.nameEntities("Attributes",em);
        relationships11.setFrom(entities166);
//      ...................... AttributesProperties ........................
        Entities entities167 = new Entities();
        entities167 = findBean.nameEntities("AttributesProperties",em);
        relationships11.setTo(entities167);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities168 = new Cardinalities();
        cardinalities168 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships11.setCardinalities(cardinalities168);
        em.persist(relationships11);
        em.flush();

        Relationships relationships12 = new Relationships();
        relationships12.setIsOptionality(true);
        relationships12.setIsEmbedded(false);
//      ...................... Relationships ........................
        Entities entities169 = new Entities();
        entities169 = findBean.nameEntities("Relationships",em);
        relationships12.setFrom(entities169);
//      ...................... AttributesProperties ........................
        Entities entities170 = new Entities();
        entities170 = findBean.nameEntities("AttributesProperties",em);
        relationships12.setTo(entities170);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities171 = new Cardinalities();
        cardinalities171 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships12.setCardinalities(cardinalities171);
        em.persist(relationships12);
        em.flush();

        Relationships relationships13 = new Relationships();
        relationships13.setIsOptionality(true);
        relationships13.setIsEmbedded(false);
//      ...................... Attributes ........................
        Entities entities172 = new Entities();
        entities172 = findBean.nameEntities("Attributes",em);
        relationships13.setFrom(entities172);
//      ...................... Sites ........................
        Entities entities173 = new Entities();
        entities173 = findBean.nameEntities("Sites",em);
        relationships13.setTo(entities173);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities174 = new Cardinalities();
        cardinalities174 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships13.setCardinalities(cardinalities174);
        em.persist(relationships13);
        em.flush();

/*
*/
/*
*/
/*
*/
/*
. Dependencies . 1..* Imports rolA: rolB:

. AttributesTypes . *..* AttributesProperties rolA:from rolB: OK

. AttributesProperties . *..* Imports rolA:from rolB: OK

*/
        Relationships relationships14 = new Relationships();
        relationships14.setIsOptionality(true);
        relationships14.setIsEmbedded(false);
//      ...................... Dependencies ........................
        Entities entities175 = new Entities();
        entities175 = findBean.nameEntities("Dependencies",em);
        relationships14.setFrom(entities175);
//      ...................... Imports ........................
        Entities entities176 = new Entities();
        entities176 = findBean.nameEntities("Imports",em);
        relationships14.setTo(entities176);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities177 = new Cardinalities();
        cardinalities177 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships14.setCardinalities(cardinalities177);
        em.persist(relationships14);
        em.flush();

        Relationships relationships15 = new Relationships();
        relationships15.setIsOptionality(true);
        relationships15.setIsEmbedded(false);
//      ...................... AttributesTypes ........................
        Entities entities178 = new Entities();
        entities178 = findBean.nameEntities("AttributesTypes",em);
        relationships15.setFrom(entities178);
//      ...................... AttributesProperties ........................
        Entities entities179 = new Entities();
        entities179 = findBean.nameEntities("AttributesProperties",em);
        relationships15.setTo(entities179);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities180 = new Cardinalities();
        cardinalities180 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships15.setCardinalities(cardinalities180);
        em.persist(relationships15);
        em.flush();

        Relationships relationships16 = new Relationships();
        relationships16.setIsOptionality(true);
        relationships16.setIsEmbedded(false);
//      ...................... AttributesProperties ........................
        Entities entities181 = new Entities();
        entities181 = findBean.nameEntities("AttributesProperties",em);
        relationships16.setFrom(entities181);
//      ...................... Imports ........................
        Entities entities182 = new Entities();
        entities182 = findBean.nameEntities("Imports",em);
        relationships16.setTo(entities182);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities183 = new Cardinalities();
        cardinalities183 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships16.setCardinalities(cardinalities183);
        em.persist(relationships16);
        em.flush();

/*
. Cardinalities . 1..* Relationships rolA: rolB:

. Developments . *..* Models rolA:from rolB: OK

. Entities . 1..* NameQueries rolA: rolB:

. Entities . 1..* Relationships rolA: rolB:

. Entities . 1..* Relationships rolA: rolB:

. Models . 1..* ModelsGroupIds rolA: rolB:

. Entities . 1..* Attributes rolA: rolB:

. GroupIds . 1..* ModelsGroupIds rolA: rolB:

. GroupIds . 1..* Entities rolA: rolB:

*/
        Relationships relationships17 = new Relationships();
        relationships17.setIsOptionality(true);
        relationships17.setIsEmbedded(false);
//      ...................... Cardinalities ........................
        Entities entities184 = new Entities();
        entities184 = findBean.nameEntities("Cardinalities",em);
        relationships17.setFrom(entities184);
//      ...................... Relationships ........................
        Entities entities185 = new Entities();
        entities185 = findBean.nameEntities("Relationships",em);
        relationships17.setTo(entities185);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities186 = new Cardinalities();
        cardinalities186 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships17.setCardinalities(cardinalities186);
        em.persist(relationships17);
        em.flush();

        Relationships relationships18 = new Relationships();
        relationships18.setIsOptionality(true);
        relationships18.setIsEmbedded(false);
//      ...................... Developments ........................
        Entities entities187 = new Entities();
        entities187 = findBean.nameEntities("Developments",em);
        relationships18.setFrom(entities187);
//      ...................... Models ........................
        Entities entities188 = new Entities();
        entities188 = findBean.nameEntities("Models",em);
        relationships18.setTo(entities188);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities189 = new Cardinalities();
        cardinalities189 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships18.setCardinalities(cardinalities189);
        em.persist(relationships18);
        em.flush();

        Relationships relationships19 = new Relationships();
        relationships19.setIsOptionality(true);
        relationships19.setIsEmbedded(false);
//      ...................... Entities ........................
        Entities entities190 = new Entities();
        entities190 = findBean.nameEntities("Entities",em);
        relationships19.setFrom(entities190);
//      ...................... NameQueries ........................
        Entities entities191 = new Entities();
        entities191 = findBean.nameEntities("NameQueries",em);
        relationships19.setTo(entities191);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities192 = new Cardinalities();
        cardinalities192 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships19.setCardinalities(cardinalities192);
        em.persist(relationships19);
        em.flush();

        Relationships relationships20 = new Relationships();
        relationships20.setIsOptionality(true);
        relationships20.setIsEmbedded(false);
//      ...................... Entities ........................
        Entities entities193 = new Entities();
        entities193 = findBean.nameEntities("Entities",em);
        relationships20.setFrom(entities193);
//      ...................... Relationships ........................
        Entities entities194 = new Entities();
        entities194 = findBean.nameEntities("Relationships",em);
        relationships20.setTo(entities194);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities195 = new Cardinalities();
        cardinalities195 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships20.setCardinalities(cardinalities195);
        em.persist(relationships20);
        em.flush();

        Relationships relationships21 = new Relationships();
        relationships21.setIsOptionality(true);
        relationships21.setIsEmbedded(false);
//      ...................... Entities ........................
        Entities entities196 = new Entities();
        entities196 = findBean.nameEntities("Entities",em);
        relationships21.setFrom(entities196);
//      ...................... Relationships ........................
        Entities entities197 = new Entities();
        entities197 = findBean.nameEntities("Relationships",em);
        relationships21.setTo(entities197);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities198 = new Cardinalities();
        cardinalities198 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships21.setCardinalities(cardinalities198);
        em.persist(relationships21);
        em.flush();

        Relationships relationships22 = new Relationships();
        relationships22.setIsOptionality(true);
        relationships22.setIsEmbedded(false);
//      ...................... Models ........................
        Entities entities199 = new Entities();
        entities199 = findBean.nameEntities("Models",em);
        relationships22.setFrom(entities199);
//      ...................... ModelsGroupIds ........................
        Entities entities200 = new Entities();
        entities200 = findBean.nameEntities("ModelsGroupIds",em);
        relationships22.setTo(entities200);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities201 = new Cardinalities();
        cardinalities201 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships22.setCardinalities(cardinalities201);
        em.persist(relationships22);
        em.flush();

        Relationships relationships23 = new Relationships();
        relationships23.setIsOptionality(true);
        relationships23.setIsEmbedded(false);
//      ...................... Entities ........................
        Entities entities202 = new Entities();
        entities202 = findBean.nameEntities("Entities",em);
        relationships23.setFrom(entities202);
//      ...................... Attributes ........................
        Entities entities203 = new Entities();
        entities203 = findBean.nameEntities("Attributes",em);
        relationships23.setTo(entities203);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities204 = new Cardinalities();
        cardinalities204 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships23.setCardinalities(cardinalities204);
        em.persist(relationships23);
        em.flush();

        Relationships relationships24 = new Relationships();
        relationships24.setIsOptionality(true);
        relationships24.setIsEmbedded(false);
//      ...................... GroupIds ........................
        Entities entities205 = new Entities();
        entities205 = findBean.nameEntities("GroupIds",em);
        relationships24.setFrom(entities205);
//      ...................... ModelsGroupIds ........................
        Entities entities206 = new Entities();
        entities206 = findBean.nameEntities("ModelsGroupIds",em);
        relationships24.setTo(entities206);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities207 = new Cardinalities();
        cardinalities207 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships24.setCardinalities(cardinalities207);
        em.persist(relationships24);
        em.flush();

        Relationships relationships25 = new Relationships();
        relationships25.setIsOptionality(true);
        relationships25.setIsEmbedded(false);
//      ...................... GroupIds ........................
        Entities entities208 = new Entities();
        entities208 = findBean.nameEntities("GroupIds",em);
        relationships25.setFrom(entities208);
//      ...................... Entities ........................
        Entities entities209 = new Entities();
        entities209 = findBean.nameEntities("Entities",em);
        relationships25.setTo(entities209);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities210 = new Cardinalities();
        cardinalities210 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships25.setCardinalities(cardinalities210);
        em.persist(relationships25);
        em.flush();

/*
. AttributesProperties . *..* Sites rolA:from rolB: OK

. Imports . *..* Sites rolA:from rolB: OK

. AttributesTypes . *..* Sites rolA:from rolB: OK

. Dependencies . *..* Sites rolA:from rolB: OK

*/
        Relationships relationships26 = new Relationships();
        relationships26.setIsOptionality(true);
        relationships26.setIsEmbedded(false);
//      ...................... AttributesProperties ........................
        Entities entities211 = new Entities();
        entities211 = findBean.nameEntities("AttributesProperties",em);
        relationships26.setFrom(entities211);
//      ...................... Sites ........................
        Entities entities212 = new Entities();
        entities212 = findBean.nameEntities("Sites",em);
        relationships26.setTo(entities212);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities213 = new Cardinalities();
        cardinalities213 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships26.setCardinalities(cardinalities213);
        em.persist(relationships26);
        em.flush();

        Relationships relationships27 = new Relationships();
        relationships27.setIsOptionality(true);
        relationships27.setIsEmbedded(false);
//      ...................... Imports ........................
        Entities entities214 = new Entities();
        entities214 = findBean.nameEntities("Imports",em);
        relationships27.setFrom(entities214);
//      ...................... Sites ........................
        Entities entities215 = new Entities();
        entities215 = findBean.nameEntities("Sites",em);
        relationships27.setTo(entities215);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities216 = new Cardinalities();
        cardinalities216 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships27.setCardinalities(cardinalities216);
        em.persist(relationships27);
        em.flush();

        Relationships relationships28 = new Relationships();
        relationships28.setIsOptionality(true);
        relationships28.setIsEmbedded(false);
//      ...................... AttributesTypes ........................
        Entities entities217 = new Entities();
        entities217 = findBean.nameEntities("AttributesTypes",em);
        relationships28.setFrom(entities217);
//      ...................... Sites ........................
        Entities entities218 = new Entities();
        entities218 = findBean.nameEntities("Sites",em);
        relationships28.setTo(entities218);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities219 = new Cardinalities();
        cardinalities219 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships28.setCardinalities(cardinalities219);
        em.persist(relationships28);
        em.flush();

        Relationships relationships29 = new Relationships();
        relationships29.setIsOptionality(true);
        relationships29.setIsEmbedded(false);
//      ...................... Dependencies ........................
        Entities entities220 = new Entities();
        entities220 = findBean.nameEntities("Dependencies",em);
        relationships29.setFrom(entities220);
//      ...................... Sites ........................
        Entities entities221 = new Entities();
        entities221 = findBean.nameEntities("Sites",em);
        relationships29.setTo(entities221);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities222 = new Cardinalities();
        cardinalities222 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships29.setCardinalities(cardinalities222);
        em.persist(relationships29);
        em.flush();

    } // data()

} // naifg
