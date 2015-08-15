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
@Named("coreSetup")
public class coreSetup {

    @PersistenceContext(unitName = "naifgPU-JTA")
    private EntityManager em;

    FindBean findBean = new FindBean();

    private static final Logger log = Logger.getLogger(coreSetup.class.getName());

    public void data() {

//      ---------------------- GroupIds ------------------------

        GroupIds groupIds1 = new GroupIds();
        groupIds1.setGroupId("co.simasoft.models.core.archival");
        groupIds1.setArtifactId("co.simasoft.models.core.archival");
        em.persist(groupIds1);
        em.flush();

        GroupIds groupIds2 = new GroupIds();
        groupIds2.setGroupId("co.simasoft.models.core.books");
        groupIds2.setArtifactId("co.simasoft.models.core.books");
        em.persist(groupIds2);
        em.flush();

        GroupIds groupIds3 = new GroupIds();
        groupIds3.setGroupId("co.simasoft.models.core.regulations");
        groupIds3.setArtifactId("co.simasoft.models.core.regulations");
        em.persist(groupIds3);
        em.flush();

        GroupIds groupIds4 = new GroupIds();
        groupIds4.setGroupId("co.simasoft.models.core.companies");
        groupIds4.setArtifactId("co.simasoft.models.core.companies");
        em.persist(groupIds4);
        em.flush();

        GroupIds groupIds5 = new GroupIds();
        groupIds5.setGroupId("co.simasoft.models.core.sites");
        groupIds5.setArtifactId("co.simasoft.models.core.sites");
        em.persist(groupIds5);
        em.flush();

//      ---------------------- Models ------------------------

        Models models = new Models();
        models.setGroupId("co.simasoft.core");
        models.setArtifactId("core");
        models.setVersion("1.0-SNAPSHOT");

        em.persist(models);
        em.flush();

//      ---------------------- Developments ------------------------

        Developments dev = new Developments();
        dev.setGroupId("co.simasoft");
        dev.setArtifactId("core");
        dev.setVersion("1.0-SNAPSHOT");
        Set<Models> models1 = new HashSet<Models>();
        Models model1 = findBean.artifactIdModels("core",em);
        models1.add(model1);
        dev.setModels(models1);
        em.persist(dev);
        em.flush();

//      ---------------------- Entities ------------------------

//      ---------------------- Entities ------------------------

//      ---------------------- Entities ------------------------

//      ---------------------- Entities ------------------------

//      ---------------------- Entities ------------------------

//      ---------------------- Entities ------------------------

//      ---------------------- Entities ------------------------

        Entities entities1 = new Entities();
        entities1.setName("RegulationsText");
//      ...................... co.simasoft.models.core.regulations ........................
        GroupIds groupId1 = new GroupIds();
        groupId1 = findBean.groupIdGroupIds("co.simasoft.models.core.regulations",em);
        entities1.setGroupIds(groupId1);
        em.persist(entities1);
        em.flush();

        Attributes attributes2 = new Attributes();
        attributes2.setName("code");
        attributes2.setIsNullable(true);
        attributes2.setIsUnique(false);
//      ...................... RegulationsText ........................
        Entities entity2 = new Entities();
        entity2 = findBean.nameEntities("RegulationsText",em);
        attributes2.setEntities(entity2);
//      ...................... String ........................
        AttributesTypes attributesTypes3 = new AttributesTypes();
        attributesTypes3 = findBean.nameAttributesTypes("String",em);
        attributes2.setAttributesTypes(attributesTypes3);
        em.persist(attributes2);
        em.flush();

        Attributes attributes3 = new Attributes();
        attributes3.setName("name");
        attributes3.setIsNullable(true);
        attributes3.setIsUnique(false);
//      ...................... RegulationsText ........................
        Entities entity4 = new Entities();
        entity4 = findBean.nameEntities("RegulationsText",em);
        attributes3.setEntities(entity4);
//      ...................... String ........................
        AttributesTypes attributesTypes5 = new AttributesTypes();
        attributesTypes5 = findBean.nameAttributesTypes("String",em);
        attributes3.setAttributesTypes(attributesTypes5);
        em.persist(attributes3);
        em.flush();

        Attributes attributes4 = new Attributes();
        attributes4.setName("text");
        attributes4.setIsNullable(true);
        attributes4.setIsUnique(false);
//      ...................... RegulationsText ........................
        Entities entity6 = new Entities();
        entity6 = findBean.nameEntities("RegulationsText",em);
        attributes4.setEntities(entity6);
//      ...................... String ........................
        AttributesTypes attributesTypes7 = new AttributesTypes();
        attributesTypes7 = findBean.nameAttributesTypes("String",em);
        attributes4.setAttributesTypes(attributesTypes7);
        em.persist(attributes4);
        em.flush();

        Entities entities5 = new Entities();
        entities5.setName("Regulations");
//      ...................... co.simasoft.models.core.regulations ........................
        GroupIds groupId8 = new GroupIds();
        groupId8 = findBean.groupIdGroupIds("co.simasoft.models.core.regulations",em);
        entities5.setGroupIds(groupId8);
        em.persist(entities5);
        em.flush();

        Attributes attributes6 = new Attributes();
        attributes6.setName("name");
        attributes6.setIsNullable(true);
        attributes6.setIsUnique(false);
//      ...................... Regulations ........................
        Entities entity9 = new Entities();
        entity9 = findBean.nameEntities("Regulations",em);
        attributes6.setEntities(entity9);
//      ...................... String ........................
        AttributesTypes attributesTypes10 = new AttributesTypes();
        attributesTypes10 = findBean.nameAttributesTypes("String",em);
        attributes6.setAttributesTypes(attributesTypes10);
        em.persist(attributes6);
        em.flush();

        Attributes attributes7 = new Attributes();
        attributes7.setName("date");
        attributes7.setIsNullable(true);
        attributes7.setIsUnique(false);
//      ...................... Regulations ........................
        Entities entity11 = new Entities();
        entity11 = findBean.nameEntities("Regulations",em);
        attributes7.setEntities(entity11);
//      ...................... Date ........................
        AttributesTypes attributesTypes12 = new AttributesTypes();
        attributesTypes12 = findBean.nameAttributesTypes("Date",em);
        attributes7.setAttributesTypes(attributesTypes12);
        em.persist(attributes7);
        em.flush();

        Entities entities8 = new Entities();
        entities8.setName("RegulationsTypes");
//      ...................... co.simasoft.models.core.regulations ........................
        GroupIds groupId13 = new GroupIds();
        groupId13 = findBean.groupIdGroupIds("co.simasoft.models.core.regulations",em);
        entities8.setGroupIds(groupId13);
        em.persist(entities8);
        em.flush();

        Attributes attributes9 = new Attributes();
        attributes9.setName("name");
        attributes9.setIsNullable(true);
        attributes9.setIsUnique(false);
//      ...................... RegulationsTypes ........................
        Entities entity14 = new Entities();
        entity14 = findBean.nameEntities("RegulationsTypes",em);
        attributes9.setEntities(entity14);
//      ...................... String ........................
        AttributesTypes attributesTypes15 = new AttributesTypes();
        attributesTypes15 = findBean.nameAttributesTypes("String",em);
        attributes9.setAttributesTypes(attributesTypes15);
        em.persist(attributes9);
        em.flush();

//      ---------------------- Entities ------------------------

//      ---------------------- Entities ------------------------

//      ---------------------- Entities ------------------------

//      ---------------------- Entities ------------------------

        Entities entities10 = new Entities();
        entities10.setName("Brands");
//      ...................... co.simasoft.models.core.companies ........................
        GroupIds groupId16 = new GroupIds();
        groupId16 = findBean.groupIdGroupIds("co.simasoft.models.core.companies",em);
        entities10.setGroupIds(groupId16);
        em.persist(entities10);
        em.flush();

        Attributes attributes11 = new Attributes();
        attributes11.setName("name");
        attributes11.setIsNullable(true);
        attributes11.setIsUnique(false);
//      ...................... Brands ........................
        Entities entity17 = new Entities();
        entity17 = findBean.nameEntities("Brands",em);
        attributes11.setEntities(entity17);
//      ...................... String ........................
        AttributesTypes attributesTypes18 = new AttributesTypes();
        attributesTypes18 = findBean.nameAttributesTypes("String",em);
        attributes11.setAttributesTypes(attributesTypes18);
        em.persist(attributes11);
        em.flush();

        Entities entities12 = new Entities();
        entities12.setName("Companies");
//      ...................... co.simasoft.models.core.companies ........................
        GroupIds groupId19 = new GroupIds();
        groupId19 = findBean.groupIdGroupIds("co.simasoft.models.core.companies",em);
        entities12.setGroupIds(groupId19);
        em.persist(entities12);
        em.flush();

        Attributes attributes13 = new Attributes();
        attributes13.setName("name");
        attributes13.setIsNullable(true);
        attributes13.setIsUnique(false);
//      ...................... Companies ........................
        Entities entity20 = new Entities();
        entity20 = findBean.nameEntities("Companies",em);
        attributes13.setEntities(entity20);
//      ...................... String ........................
        AttributesTypes attributesTypes21 = new AttributesTypes();
        attributesTypes21 = findBean.nameAttributesTypes("String",em);
        attributes13.setAttributesTypes(attributesTypes21);
        em.persist(attributes13);
        em.flush();

        Attributes attributes14 = new Attributes();
        attributes14.setName("nit");
        attributes14.setIsNullable(true);
        attributes14.setIsUnique(false);
//      ...................... Companies ........................
        Entities entity22 = new Entities();
        entity22 = findBean.nameEntities("Companies",em);
        attributes14.setEntities(entity22);
//      ...................... String ........................
        AttributesTypes attributesTypes23 = new AttributesTypes();
        attributesTypes23 = findBean.nameAttributesTypes("String",em);
        attributes14.setAttributesTypes(attributesTypes23);
        em.persist(attributes14);
        em.flush();

        Attributes attributes15 = new Attributes();
        attributes15.setName("address");
        attributes15.setIsNullable(true);
        attributes15.setIsUnique(false);
//      ...................... Companies ........................
        Entities entity24 = new Entities();
        entity24 = findBean.nameEntities("Companies",em);
        attributes15.setEntities(entity24);
//      ...................... String ........................
        AttributesTypes attributesTypes25 = new AttributesTypes();
        attributesTypes25 = findBean.nameAttributesTypes("String",em);
        attributes15.setAttributesTypes(attributesTypes25);
        em.persist(attributes15);
        em.flush();

        Attributes attributes16 = new Attributes();
        attributes16.setName("telephones");
        attributes16.setIsNullable(true);
        attributes16.setIsUnique(false);
//      ...................... Companies ........................
        Entities entity26 = new Entities();
        entity26 = findBean.nameEntities("Companies",em);
        attributes16.setEntities(entity26);
//      ...................... String ........................
        AttributesTypes attributesTypes27 = new AttributesTypes();
        attributesTypes27 = findBean.nameAttributesTypes("String",em);
        attributes16.setAttributesTypes(attributesTypes27);
        em.persist(attributes16);
        em.flush();

        Attributes attributes17 = new Attributes();
        attributes17.setName("email");
        attributes17.setIsNullable(true);
        attributes17.setIsUnique(false);
//      ...................... Companies ........................
        Entities entity28 = new Entities();
        entity28 = findBean.nameEntities("Companies",em);
        attributes17.setEntities(entity28);
//      ...................... String ........................
        AttributesTypes attributesTypes29 = new AttributesTypes();
        attributesTypes29 = findBean.nameAttributesTypes("String",em);
        attributes17.setAttributesTypes(attributesTypes29);
        em.persist(attributes17);
        em.flush();

//      ---------------------- Entities ------------------------

        Entities entities18 = new Entities();
        entities18.setName("BooksTypes");
//      ...................... co.simasoft.models.core.books ........................
        GroupIds groupId30 = new GroupIds();
        groupId30 = findBean.groupIdGroupIds("co.simasoft.models.core.books",em);
        entities18.setGroupIds(groupId30);
        em.persist(entities18);
        em.flush();

        Attributes attributes19 = new Attributes();
        attributes19.setName("name");
        attributes19.setIsNullable(true);
        attributes19.setIsUnique(false);
//      ...................... BooksTypes ........................
        Entities entity31 = new Entities();
        entity31 = findBean.nameEntities("BooksTypes",em);
        attributes19.setEntities(entity31);
//      ...................... String ........................
        AttributesTypes attributesTypes32 = new AttributesTypes();
        attributesTypes32 = findBean.nameAttributesTypes("String",em);
        attributes19.setAttributesTypes(attributesTypes32);
        em.persist(attributes19);
        em.flush();

        Entities entities20 = new Entities();
        entities20.setName("Chapters");
//      ...................... co.simasoft.models.core.books ........................
        GroupIds groupId33 = new GroupIds();
        groupId33 = findBean.groupIdGroupIds("co.simasoft.models.core.books",em);
        entities20.setGroupIds(groupId33);
        em.persist(entities20);
        em.flush();

        Attributes attributes21 = new Attributes();
        attributes21.setName("code");
        attributes21.setIsNullable(true);
        attributes21.setIsUnique(false);
//      ...................... Chapters ........................
        Entities entity34 = new Entities();
        entity34 = findBean.nameEntities("Chapters",em);
        attributes21.setEntities(entity34);
//      ...................... String ........................
        AttributesTypes attributesTypes35 = new AttributesTypes();
        attributesTypes35 = findBean.nameAttributesTypes("String",em);
        attributes21.setAttributesTypes(attributesTypes35);
        em.persist(attributes21);
        em.flush();

        Attributes attributes22 = new Attributes();
        attributes22.setName("name");
        attributes22.setIsNullable(true);
        attributes22.setIsUnique(false);
//      ...................... Chapters ........................
        Entities entity36 = new Entities();
        entity36 = findBean.nameEntities("Chapters",em);
        attributes22.setEntities(entity36);
//      ...................... String ........................
        AttributesTypes attributesTypes37 = new AttributesTypes();
        attributesTypes37 = findBean.nameAttributesTypes("String",em);
        attributes22.setAttributesTypes(attributesTypes37);
        em.persist(attributes22);
        em.flush();

        Attributes attributes23 = new Attributes();
        attributes23.setName("content");
        attributes23.setIsNullable(false);
        attributes23.setIsUnique(false);
//      ...................... Chapters ........................
        Entities entity38 = new Entities();
        entity38 = findBean.nameEntities("Chapters",em);
        attributes23.setEntities(entity38);
//      ...................... String ........................
        AttributesTypes attributesTypes39 = new AttributesTypes();
        attributesTypes39 = findBean.nameAttributesTypes("String",em);
        attributes23.setAttributesTypes(attributesTypes39);
        em.persist(attributes23);
        em.flush();

        Entities entities24 = new Entities();
        entities24.setName("Books");
//      ...................... co.simasoft.models.core.books ........................
        GroupIds groupId40 = new GroupIds();
        groupId40 = findBean.groupIdGroupIds("co.simasoft.models.core.books",em);
        entities24.setGroupIds(groupId40);
        em.persist(entities24);
        em.flush();

        Attributes attributes25 = new Attributes();
        attributes25.setName("code");
        attributes25.setIsNullable(true);
        attributes25.setIsUnique(false);
//      ...................... Books ........................
        Entities entity41 = new Entities();
        entity41 = findBean.nameEntities("Books",em);
        attributes25.setEntities(entity41);
//      ...................... String ........................
        AttributesTypes attributesTypes42 = new AttributesTypes();
        attributesTypes42 = findBean.nameAttributesTypes("String",em);
        attributes25.setAttributesTypes(attributesTypes42);
        em.persist(attributes25);
        em.flush();

        Attributes attributes26 = new Attributes();
        attributes26.setName("name");
        attributes26.setIsNullable(false);
        attributes26.setIsUnique(true);
//      ...................... Books ........................
        Entities entity43 = new Entities();
        entity43 = findBean.nameEntities("Books",em);
        attributes26.setEntities(entity43);
//      ...................... String ........................
        AttributesTypes attributesTypes44 = new AttributesTypes();
        attributesTypes44 = findBean.nameAttributesTypes("String",em);
        attributes26.setAttributesTypes(attributesTypes44);
        em.persist(attributes26);
        em.flush();

        Attributes attributes27 = new Attributes();
        attributes27.setName("content");
        attributes27.setIsNullable(false);
        attributes27.setIsUnique(false);
//      ...................... Books ........................
        Entities entity45 = new Entities();
        entity45 = findBean.nameEntities("Books",em);
        attributes27.setEntities(entity45);
//      ...................... String ........................
        AttributesTypes attributesTypes46 = new AttributesTypes();
        attributesTypes46 = findBean.nameAttributesTypes("String",em);
        attributes27.setAttributesTypes(attributesTypes46);
        em.persist(attributes27);
        em.flush();

//      ---------------------- Entities ------------------------

        Entities entities28 = new Entities();
        entities28.setName("SitesTypes");
//      ...................... co.simasoft.models.core.sites ........................
        GroupIds groupId47 = new GroupIds();
        groupId47 = findBean.groupIdGroupIds("co.simasoft.models.core.sites",em);
        entities28.setGroupIds(groupId47);
        em.persist(entities28);
        em.flush();

        Attributes attributes29 = new Attributes();
        attributes29.setName("name");
        attributes29.setIsNullable(true);
        attributes29.setIsUnique(false);
//      ...................... SitesTypes ........................
        Entities entity48 = new Entities();
        entity48 = findBean.nameEntities("SitesTypes",em);
        attributes29.setEntities(entity48);
//      ...................... String ........................
        AttributesTypes attributesTypes49 = new AttributesTypes();
        attributesTypes49 = findBean.nameAttributesTypes("String",em);
        attributes29.setAttributesTypes(attributesTypes49);
        em.persist(attributes29);
        em.flush();

        Entities entities30 = new Entities();
        entities30.setName("Sites");
//      ...................... co.simasoft.models.core.sites ........................
        GroupIds groupId50 = new GroupIds();
        groupId50 = findBean.groupIdGroupIds("co.simasoft.models.core.sites",em);
        entities30.setGroupIds(groupId50);
        em.persist(entities30);
        em.flush();

        Attributes attributes31 = new Attributes();
        attributes31.setName("title");
        attributes31.setIsNullable(true);
        attributes31.setIsUnique(false);
//      ...................... Sites ........................
        Entities entity51 = new Entities();
        entity51 = findBean.nameEntities("Sites",em);
        attributes31.setEntities(entity51);
//      ...................... String ........................
        AttributesTypes attributesTypes52 = new AttributesTypes();
        attributesTypes52 = findBean.nameAttributesTypes("String",em);
        attributes31.setAttributesTypes(attributesTypes52);
        em.persist(attributes31);
        em.flush();

        Attributes attributes32 = new Attributes();
        attributes32.setName("link");
        attributes32.setIsNullable(false);
        attributes32.setIsUnique(true);
//      ...................... Sites ........................
        Entities entity53 = new Entities();
        entity53 = findBean.nameEntities("Sites",em);
        attributes32.setEntities(entity53);
//      ...................... String ........................
        AttributesTypes attributesTypes54 = new AttributesTypes();
        attributesTypes54 = findBean.nameAttributesTypes("String",em);
        attributes32.setAttributesTypes(attributesTypes54);
        em.persist(attributes32);
        em.flush();

        Attributes attributes33 = new Attributes();
        attributes33.setName("abc");
        attributes33.setIsNullable(true);
        attributes33.setIsUnique(false);
//      ...................... Sites ........................
        Entities entity55 = new Entities();
        entity55 = findBean.nameEntities("Sites",em);
        attributes33.setEntities(entity55);
//      ...................... String ........................
        AttributesTypes attributesTypes56 = new AttributesTypes();
        attributesTypes56 = findBean.nameAttributesTypes("String",em);
        attributes33.setAttributesTypes(attributesTypes56);
        em.persist(attributes33);
        em.flush();

//      ---------------------- Entities ------------------------

        Entities entities34 = new Entities();
        entities34.setName("DocumentalRetention");
//      ...................... co.simasoft.models.core.archival ........................
        GroupIds groupId57 = new GroupIds();
        groupId57 = findBean.groupIdGroupIds("co.simasoft.models.core.archival",em);
        entities34.setGroupIds(groupId57);
        em.persist(entities34);
        em.flush();

        Attributes attributes35 = new Attributes();
        attributes35.setName("year");
        attributes35.setIsNullable(true);
        attributes35.setIsUnique(false);
//      ...................... DocumentalRetention ........................
        Entities entity58 = new Entities();
        entity58 = findBean.nameEntities("DocumentalRetention",em);
        attributes35.setEntities(entity58);
//      ...................... Integer ........................
        AttributesTypes attributesTypes59 = new AttributesTypes();
        attributesTypes59 = findBean.nameAttributesTypes("Integer",em);
        attributes35.setAttributesTypes(attributesTypes59);
        em.persist(attributes35);
        em.flush();

        Attributes attributes36 = new Attributes();
        attributes36.setName("name");
        attributes36.setIsNullable(true);
        attributes36.setIsUnique(false);
//      ...................... DocumentalRetention ........................
        Entities entity60 = new Entities();
        entity60 = findBean.nameEntities("DocumentalRetention",em);
        attributes36.setEntities(entity60);
//      ...................... String ........................
        AttributesTypes attributesTypes61 = new AttributesTypes();
        attributesTypes61 = findBean.nameAttributesTypes("String",em);
        attributes36.setAttributesTypes(attributesTypes61);
        em.persist(attributes36);
        em.flush();

        Entities entities37 = new Entities();
        entities37.setName("FrequentlyQuery");
//      ...................... co.simasoft.models.core.archival ........................
        GroupIds groupId62 = new GroupIds();
        groupId62 = findBean.groupIdGroupIds("co.simasoft.models.core.archival",em);
        entities37.setGroupIds(groupId62);
        em.persist(entities37);
        em.flush();

        Attributes attributes38 = new Attributes();
        attributes38.setName("name");
        attributes38.setIsNullable(true);
        attributes38.setIsUnique(false);
//      ...................... FrequentlyQuery ........................
        Entities entity63 = new Entities();
        entity63 = findBean.nameEntities("FrequentlyQuery",em);
        attributes38.setEntities(entity63);
//      ...................... Integer ........................
        AttributesTypes attributesTypes64 = new AttributesTypes();
        attributesTypes64 = findBean.nameAttributesTypes("Integer",em);
        attributes38.setAttributesTypes(attributesTypes64);
        em.persist(attributes38);
        em.flush();

        Entities entities39 = new Entities();
        entities39.setName("FundsLife");
//      ...................... co.simasoft.models.core.archival ........................
        GroupIds groupId65 = new GroupIds();
        groupId65 = findBean.groupIdGroupIds("co.simasoft.models.core.archival",em);
        entities39.setGroupIds(groupId65);
        em.persist(entities39);
        em.flush();

        Attributes attributes40 = new Attributes();
        attributes40.setName("name");
        attributes40.setIsNullable(true);
        attributes40.setIsUnique(false);
//      ...................... FundsLife ........................
        Entities entity66 = new Entities();
        entity66 = findBean.nameEntities("FundsLife",em);
        attributes40.setEntities(entity66);
//      ...................... String ........................
        AttributesTypes attributesTypes67 = new AttributesTypes();
        attributesTypes67 = findBean.nameAttributesTypes("String",em);
        attributes40.setAttributesTypes(attributesTypes67);
        em.persist(attributes40);
        em.flush();

        Attributes attributes41 = new Attributes();
        attributes41.setName("isOpen");
        attributes41.setIsNullable(true);
        attributes41.setIsUnique(false);
//      ...................... FundsLife ........................
        Entities entity68 = new Entities();
        entity68 = findBean.nameEntities("FundsLife",em);
        attributes41.setEntities(entity68);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes69 = new AttributesTypes();
        attributesTypes69 = findBean.nameAttributesTypes("Boolean",em);
        attributes41.setAttributesTypes(attributesTypes69);
        em.persist(attributes41);
        em.flush();

        Entities entities42 = new Entities();
        entities42.setName("InventoryFinality");
//      ...................... co.simasoft.models.core.archival ........................
        GroupIds groupId70 = new GroupIds();
        groupId70 = findBean.groupIdGroupIds("co.simasoft.models.core.archival",em);
        entities42.setGroupIds(groupId70);
        em.persist(entities42);
        em.flush();

        Attributes attributes43 = new Attributes();
        attributes43.setName("name");
        attributes43.setIsNullable(true);
        attributes43.setIsUnique(false);
//      ...................... InventoryFinality ........................
        Entities entity71 = new Entities();
        entity71 = findBean.nameEntities("InventoryFinality",em);
        attributes43.setEntities(entity71);
//      ...................... String ........................
        AttributesTypes attributesTypes72 = new AttributesTypes();
        attributesTypes72 = findBean.nameAttributesTypes("String",em);
        attributes43.setAttributesTypes(attributesTypes72);
        em.persist(attributes43);
        em.flush();

        Entities entities44 = new Entities();
        entities44.setName("FinalDisposition");
//      ...................... co.simasoft.models.core.archival ........................
        GroupIds groupId73 = new GroupIds();
        groupId73 = findBean.groupIdGroupIds("co.simasoft.models.core.archival",em);
        entities44.setGroupIds(groupId73);
        em.persist(entities44);
        em.flush();

        Attributes attributes45 = new Attributes();
        attributes45.setName("name");
        attributes45.setIsNullable(true);
        attributes45.setIsUnique(false);
//      ...................... FinalDisposition ........................
        Entities entity74 = new Entities();
        entity74 = findBean.nameEntities("FinalDisposition",em);
        attributes45.setEntities(entity74);
//      ...................... String ........................
        AttributesTypes attributesTypes75 = new AttributesTypes();
        attributesTypes75 = findBean.nameAttributesTypes("String",em);
        attributes45.setAttributesTypes(attributesTypes75);
        em.persist(attributes45);
        em.flush();

        Entities entities46 = new Entities();
        entities46.setName("Funds");
//      ...................... co.simasoft.models.core.archival ........................
        GroupIds groupId76 = new GroupIds();
        groupId76 = findBean.groupIdGroupIds("co.simasoft.models.core.archival",em);
        entities46.setGroupIds(groupId76);
        em.persist(entities46);
        em.flush();

        Attributes attributes47 = new Attributes();
        attributes47.setName("code");
        attributes47.setIsNullable(true);
        attributes47.setIsUnique(false);
//      ...................... Funds ........................
        Entities entity77 = new Entities();
        entity77 = findBean.nameEntities("Funds",em);
        attributes47.setEntities(entity77);
//      ...................... String ........................
        AttributesTypes attributesTypes78 = new AttributesTypes();
        attributesTypes78 = findBean.nameAttributesTypes("String",em);
        attributes47.setAttributesTypes(attributesTypes78);
        em.persist(attributes47);
        em.flush();

        Attributes attributes48 = new Attributes();
        attributes48.setName("name");
        attributes48.setIsNullable(true);
        attributes48.setIsUnique(false);
//      ...................... Funds ........................
        Entities entity79 = new Entities();
        entity79 = findBean.nameEntities("Funds",em);
        attributes48.setEntities(entity79);
//      ...................... String ........................
        AttributesTypes attributesTypes80 = new AttributesTypes();
        attributesTypes80 = findBean.nameAttributesTypes("String",em);
        attributes48.setAttributesTypes(attributesTypes80);
        em.persist(attributes48);
        em.flush();

        Entities entities49 = new Entities();
        entities49.setName("DocumentalInventory");
//      ...................... co.simasoft.models.core.archival ........................
        GroupIds groupId81 = new GroupIds();
        groupId81 = findBean.groupIdGroupIds("co.simasoft.models.core.archival",em);
        entities49.setGroupIds(groupId81);
        em.persist(entities49);
        em.flush();

        Attributes attributes50 = new Attributes();
        attributes50.setName("deliveryDate");
        attributes50.setIsNullable(true);
        attributes50.setIsUnique(false);
//      ...................... DocumentalInventory ........................
        Entities entity82 = new Entities();
        entity82 = findBean.nameEntities("DocumentalInventory",em);
        attributes50.setEntities(entity82);
//      ...................... Date ........................
        AttributesTypes attributesTypes83 = new AttributesTypes();
        attributesTypes83 = findBean.nameAttributesTypes("Date",em);
        attributes50.setAttributesTypes(attributesTypes83);
        em.persist(attributes50);
        em.flush();

        Attributes attributes51 = new Attributes();
        attributes51.setName("transferNumber");
        attributes51.setIsNullable(true);
        attributes51.setIsUnique(false);
//      ...................... DocumentalInventory ........................
        Entities entity84 = new Entities();
        entity84 = findBean.nameEntities("DocumentalInventory",em);
        attributes51.setEntities(entity84);
//      ...................... Integer ........................
        AttributesTypes attributesTypes85 = new AttributesTypes();
        attributesTypes85 = findBean.nameAttributesTypes("Integer",em);
        attributes51.setAttributesTypes(attributesTypes85);
        em.persist(attributes51);
        em.flush();

        Attributes attributes52 = new Attributes();
        attributes52.setName("startDate");
        attributes52.setIsNullable(true);
        attributes52.setIsUnique(false);
//      ...................... DocumentalInventory ........................
        Entities entity86 = new Entities();
        entity86 = findBean.nameEntities("DocumentalInventory",em);
        attributes52.setEntities(entity86);
//      ...................... Date ........................
        AttributesTypes attributesTypes87 = new AttributesTypes();
        attributesTypes87 = findBean.nameAttributesTypes("Date",em);
        attributes52.setAttributesTypes(attributesTypes87);
        em.persist(attributes52);
        em.flush();

        Attributes attributes53 = new Attributes();
        attributes53.setName("finalDate");
        attributes53.setIsNullable(true);
        attributes53.setIsUnique(false);
//      ...................... DocumentalInventory ........................
        Entities entity88 = new Entities();
        entity88 = findBean.nameEntities("DocumentalInventory",em);
        attributes53.setEntities(entity88);
//      ...................... Date ........................
        AttributesTypes attributesTypes89 = new AttributesTypes();
        attributesTypes89 = findBean.nameAttributesTypes("Date",em);
        attributes53.setAttributesTypes(attributesTypes89);
        em.persist(attributes53);
        em.flush();

        Attributes attributes54 = new Attributes();
        attributes54.setName("folios");
        attributes54.setIsNullable(true);
        attributes54.setIsUnique(false);
//      ...................... DocumentalInventory ........................
        Entities entity90 = new Entities();
        entity90 = findBean.nameEntities("DocumentalInventory",em);
        attributes54.setEntities(entity90);
//      ...................... Integer ........................
        AttributesTypes attributesTypes91 = new AttributesTypes();
        attributesTypes91 = findBean.nameAttributesTypes("Integer",em);
        attributes54.setAttributesTypes(attributesTypes91);
        em.persist(attributes54);
        em.flush();

        Attributes attributes55 = new Attributes();
        attributes55.setName("quantity");
        attributes55.setIsNullable(true);
        attributes55.setIsUnique(false);
//      ...................... DocumentalInventory ........................
        Entities entity92 = new Entities();
        entity92 = findBean.nameEntities("DocumentalInventory",em);
        attributes55.setEntities(entity92);
//      ...................... Integer ........................
        AttributesTypes attributesTypes93 = new AttributesTypes();
        attributesTypes93 = findBean.nameAttributesTypes("Integer",em);
        attributes55.setAttributesTypes(attributesTypes93);
        em.persist(attributes55);
        em.flush();

        Attributes attributes56 = new Attributes();
        attributes56.setName("debugDate");
        attributes56.setIsNullable(true);
        attributes56.setIsUnique(false);
//      ...................... DocumentalInventory ........................
        Entities entity94 = new Entities();
        entity94 = findBean.nameEntities("DocumentalInventory",em);
        attributes56.setEntities(entity94);
//      ...................... Date ........................
        AttributesTypes attributesTypes95 = new AttributesTypes();
        attributesTypes95 = findBean.nameAttributesTypes("Date",em);
        attributes56.setAttributesTypes(attributesTypes95);
        em.persist(attributes56);
        em.flush();

        Attributes attributes57 = new Attributes();
        attributes57.setName("finalDisposition");
        attributes57.setIsNullable(true);
        attributes57.setIsUnique(false);
//      ...................... DocumentalInventory ........................
        Entities entity96 = new Entities();
        entity96 = findBean.nameEntities("DocumentalInventory",em);
        attributes57.setEntities(entity96);
//      ...................... String ........................
        AttributesTypes attributesTypes97 = new AttributesTypes();
        attributesTypes97 = findBean.nameAttributesTypes("String",em);
        attributes57.setAttributesTypes(attributesTypes97);
        em.persist(attributes57);
        em.flush();

        Entities entities58 = new Entities();
        entities58.setName("DocumentalsUnits");
//      ...................... co.simasoft.models.core.archival ........................
        GroupIds groupId98 = new GroupIds();
        groupId98 = findBean.groupIdGroupIds("co.simasoft.models.core.archival",em);
        entities58.setGroupIds(groupId98);
        em.persist(entities58);
        em.flush();

        Attributes attributes59 = new Attributes();
        attributes59.setName("name");
        attributes59.setIsNullable(true);
        attributes59.setIsUnique(false);
//      ...................... DocumentalsUnits ........................
        Entities entity99 = new Entities();
        entity99 = findBean.nameEntities("DocumentalsUnits",em);
        attributes59.setEntities(entity99);
//      ...................... String ........................
        AttributesTypes attributesTypes100 = new AttributesTypes();
        attributesTypes100 = findBean.nameAttributesTypes("String",em);
        attributes59.setAttributesTypes(attributesTypes100);
        em.persist(attributes59);
        em.flush();

        Attributes attributes60 = new Attributes();
        attributes60.setName("creationDate");
        attributes60.setIsNullable(true);
        attributes60.setIsUnique(false);
//      ...................... DocumentalsUnits ........................
        Entities entity101 = new Entities();
        entity101 = findBean.nameEntities("DocumentalsUnits",em);
        attributes60.setEntities(entity101);
//      ...................... Date ........................
        AttributesTypes attributesTypes102 = new AttributesTypes();
        attributesTypes102 = findBean.nameAttributesTypes("Date",em);
        attributes60.setAttributesTypes(attributesTypes102);
        em.persist(attributes60);
        em.flush();

        Entities entities61 = new Entities();
        entities61.setName("DocumentsTypes");
//      ...................... co.simasoft.models.core.archival ........................
        GroupIds groupId103 = new GroupIds();
        groupId103 = findBean.groupIdGroupIds("co.simasoft.models.core.archival",em);
        entities61.setGroupIds(groupId103);
        em.persist(entities61);
        em.flush();

        Attributes attributes62 = new Attributes();
        attributes62.setName("name");
        attributes62.setIsNullable(true);
        attributes62.setIsUnique(false);
//      ...................... DocumentsTypes ........................
        Entities entity104 = new Entities();
        entity104 = findBean.nameEntities("DocumentsTypes",em);
        attributes62.setEntities(entity104);
//      ...................... String ........................
        AttributesTypes attributesTypes105 = new AttributesTypes();
        attributesTypes105 = findBean.nameAttributesTypes("String",em);
        attributes62.setAttributesTypes(attributesTypes105);
        em.persist(attributes62);
        em.flush();

        Entities entities63 = new Entities();
        entities63.setName("SectionsTypes");
//      ...................... co.simasoft.models.core.archival ........................
        GroupIds groupId106 = new GroupIds();
        groupId106 = findBean.groupIdGroupIds("co.simasoft.models.core.archival",em);
        entities63.setGroupIds(groupId106);
        em.persist(entities63);
        em.flush();

        Attributes attributes64 = new Attributes();
        attributes64.setName("name");
        attributes64.setIsNullable(true);
        attributes64.setIsUnique(false);
//      ...................... SectionsTypes ........................
        Entities entity107 = new Entities();
        entity107 = findBean.nameEntities("SectionsTypes",em);
        attributes64.setEntities(entity107);
//      ...................... String ........................
        AttributesTypes attributesTypes108 = new AttributesTypes();
        attributesTypes108 = findBean.nameAttributesTypes("String",em);
        attributes64.setAttributesTypes(attributesTypes108);
        em.persist(attributes64);
        em.flush();

        Entities entities65 = new Entities();
        entities65.setName("ConservationUnits");
//      ...................... co.simasoft.models.core.archival ........................
        GroupIds groupId109 = new GroupIds();
        groupId109 = findBean.groupIdGroupIds("co.simasoft.models.core.archival",em);
        entities65.setGroupIds(groupId109);
        em.persist(entities65);
        em.flush();

        Attributes attributes66 = new Attributes();
        attributes66.setName("code");
        attributes66.setIsNullable(true);
        attributes66.setIsUnique(false);
//      ...................... ConservationUnits ........................
        Entities entity110 = new Entities();
        entity110 = findBean.nameEntities("ConservationUnits",em);
        attributes66.setEntities(entity110);
//      ...................... String ........................
        AttributesTypes attributesTypes111 = new AttributesTypes();
        attributesTypes111 = findBean.nameAttributesTypes("String",em);
        attributes66.setAttributesTypes(attributesTypes111);
        em.persist(attributes66);
        em.flush();

        Attributes attributes67 = new Attributes();
        attributes67.setName("name");
        attributes67.setIsNullable(true);
        attributes67.setIsUnique(false);
//      ...................... ConservationUnits ........................
        Entities entity112 = new Entities();
        entity112 = findBean.nameEntities("ConservationUnits",em);
        attributes67.setEntities(entity112);
//      ...................... String ........................
        AttributesTypes attributesTypes113 = new AttributesTypes();
        attributesTypes113 = findBean.nameAttributesTypes("String",em);
        attributes67.setAttributesTypes(attributesTypes113);
        em.persist(attributes67);
        em.flush();

        Entities entities68 = new Entities();
        entities68.setName("Trd");
//      ...................... co.simasoft.models.core.archival ........................
        GroupIds groupId114 = new GroupIds();
        groupId114 = findBean.groupIdGroupIds("co.simasoft.models.core.archival",em);
        entities68.setGroupIds(groupId114);
        em.persist(entities68);
        em.flush();

        Attributes attributes69 = new Attributes();
        attributes69.setName("procedures");
        attributes69.setIsNullable(true);
        attributes69.setIsUnique(false);
//      ...................... Trd ........................
        Entities entity115 = new Entities();
        entity115 = findBean.nameEntities("Trd",em);
        attributes69.setEntities(entity115);
//      ...................... String ........................
        AttributesTypes attributesTypes116 = new AttributesTypes();
        attributesTypes116 = findBean.nameAttributesTypes("String",em);
        attributes69.setAttributesTypes(attributesTypes116);
        em.persist(attributes69);
        em.flush();

        Entities entities70 = new Entities();
        entities70.setName("Sections");
//      ...................... co.simasoft.models.core.archival ........................
        GroupIds groupId117 = new GroupIds();
        groupId117 = findBean.groupIdGroupIds("co.simasoft.models.core.archival",em);
        entities70.setGroupIds(groupId117);
        em.persist(entities70);
        em.flush();

        Attributes attributes71 = new Attributes();
        attributes71.setName("code");
        attributes71.setIsNullable(true);
        attributes71.setIsUnique(false);
//      ...................... Sections ........................
        Entities entity118 = new Entities();
        entity118 = findBean.nameEntities("Sections",em);
        attributes71.setEntities(entity118);
//      ...................... String ........................
        AttributesTypes attributesTypes119 = new AttributesTypes();
        attributesTypes119 = findBean.nameAttributesTypes("String",em);
        attributes71.setAttributesTypes(attributesTypes119);
        em.persist(attributes71);
        em.flush();

        Attributes attributes72 = new Attributes();
        attributes72.setName("name");
        attributes72.setIsNullable(true);
        attributes72.setIsUnique(false);
//      ...................... Sections ........................
        Entities entity120 = new Entities();
        entity120 = findBean.nameEntities("Sections",em);
        attributes72.setEntities(entity120);
//      ...................... String ........................
        AttributesTypes attributesTypes121 = new AttributesTypes();
        attributesTypes121 = findBean.nameAttributesTypes("String",em);
        attributes72.setAttributesTypes(attributesTypes121);
        em.persist(attributes72);
        em.flush();

        Attributes attributes73 = new Attributes();
        attributes73.setName("email");
        attributes73.setIsNullable(true);
        attributes73.setIsUnique(false);
//      ...................... Sections ........................
        Entities entity122 = new Entities();
        entity122 = findBean.nameEntities("Sections",em);
        attributes73.setEntities(entity122);
//      ...................... String ........................
        AttributesTypes attributesTypes123 = new AttributesTypes();
        attributesTypes123 = findBean.nameAttributesTypes("String",em);
        attributes73.setAttributesTypes(attributesTypes123);
        em.persist(attributes73);
        em.flush();

        Entities entities74 = new Entities();
        entities74.setName("DocumentalsSupports");
//      ...................... co.simasoft.models.core.archival ........................
        GroupIds groupId124 = new GroupIds();
        groupId124 = findBean.groupIdGroupIds("co.simasoft.models.core.archival",em);
        entities74.setGroupIds(groupId124);
        em.persist(entities74);
        em.flush();

        Attributes attributes75 = new Attributes();
        attributes75.setName("code");
        attributes75.setIsNullable(true);
        attributes75.setIsUnique(false);
//      ...................... DocumentalsSupports ........................
        Entities entity125 = new Entities();
        entity125 = findBean.nameEntities("DocumentalsSupports",em);
        attributes75.setEntities(entity125);
//      ...................... String ........................
        AttributesTypes attributesTypes126 = new AttributesTypes();
        attributesTypes126 = findBean.nameAttributesTypes("String",em);
        attributes75.setAttributesTypes(attributesTypes126);
        em.persist(attributes75);
        em.flush();

        Attributes attributes76 = new Attributes();
        attributes76.setName("name");
        attributes76.setIsNullable(true);
        attributes76.setIsUnique(false);
//      ...................... DocumentalsSupports ........................
        Entities entity127 = new Entities();
        entity127 = findBean.nameEntities("DocumentalsSupports",em);
        attributes76.setEntities(entity127);
//      ...................... String ........................
        AttributesTypes attributesTypes128 = new AttributesTypes();
        attributesTypes128 = findBean.nameAttributesTypes("String",em);
        attributes76.setAttributesTypes(attributesTypes128);
        em.persist(attributes76);
        em.flush();

        Entities entities77 = new Entities();
        entities77.setName("Series");
//      ...................... co.simasoft.models.core.archival ........................
        GroupIds groupId129 = new GroupIds();
        groupId129 = findBean.groupIdGroupIds("co.simasoft.models.core.archival",em);
        entities77.setGroupIds(groupId129);
        em.persist(entities77);
        em.flush();

        Attributes attributes78 = new Attributes();
        attributes78.setName("code");
        attributes78.setIsNullable(true);
        attributes78.setIsUnique(false);
//      ...................... Series ........................
        Entities entity130 = new Entities();
        entity130 = findBean.nameEntities("Series",em);
        attributes78.setEntities(entity130);
//      ...................... String ........................
        AttributesTypes attributesTypes131 = new AttributesTypes();
        attributesTypes131 = findBean.nameAttributesTypes("String",em);
        attributes78.setAttributesTypes(attributesTypes131);
        em.persist(attributes78);
        em.flush();

        Attributes attributes79 = new Attributes();
        attributes79.setName("name");
        attributes79.setIsNullable(true);
        attributes79.setIsUnique(false);
//      ...................... Series ........................
        Entities entity132 = new Entities();
        entity132 = findBean.nameEntities("Series",em);
        attributes79.setEntities(entity132);
//      ...................... String ........................
        AttributesTypes attributesTypes133 = new AttributesTypes();
        attributesTypes133 = findBean.nameAttributesTypes("String",em);
        attributes79.setAttributesTypes(attributesTypes133);
        em.persist(attributes79);
        em.flush();

        Attributes attributes80 = new Attributes();
        attributes80.setName("located");
        attributes80.setIsNullable(true);
        attributes80.setIsUnique(false);
//      ...................... Series ........................
        Entities entity134 = new Entities();
        entity134 = findBean.nameEntities("Series",em);
        attributes80.setEntities(entity134);
//      ...................... String ........................
        AttributesTypes attributesTypes135 = new AttributesTypes();
        attributesTypes135 = findBean.nameAttributesTypes("String",em);
        attributes80.setAttributesTypes(attributesTypes135);
        em.persist(attributes80);
        em.flush();

        Attributes attributes81 = new Attributes();
        attributes81.setName("link");
        attributes81.setIsNullable(true);
        attributes81.setIsUnique(false);
//      ...................... Series ........................
        Entities entity136 = new Entities();
        entity136 = findBean.nameEntities("Series",em);
        attributes81.setEntities(entity136);
//      ...................... String ........................
        AttributesTypes attributesTypes137 = new AttributesTypes();
        attributesTypes137 = findBean.nameAttributesTypes("String",em);
        attributes81.setAttributesTypes(attributesTypes137);
        em.persist(attributes81);
        em.flush();

        Entities entities82 = new Entities();
        entities82.setName("OriginalOrder");
//      ...................... co.simasoft.models.core.archival ........................
        GroupIds groupId138 = new GroupIds();
        groupId138 = findBean.groupIdGroupIds("co.simasoft.models.core.archival",em);
        entities82.setGroupIds(groupId138);
        em.persist(entities82);
        em.flush();

        Attributes attributes83 = new Attributes();
        attributes83.setName("entryDate");
        attributes83.setIsNullable(true);
        attributes83.setIsUnique(false);
//      ...................... OriginalOrder ........................
        Entities entity139 = new Entities();
        entity139 = findBean.nameEntities("OriginalOrder",em);
        attributes83.setEntities(entity139);
//      ...................... Date ........................
        AttributesTypes attributesTypes140 = new AttributesTypes();
        attributesTypes140 = findBean.nameAttributesTypes("Date",em);
        attributes83.setAttributesTypes(attributesTypes140);
        em.persist(attributes83);
        em.flush();

        Attributes attributes84 = new Attributes();
        attributes84.setName("startDate");
        attributes84.setIsNullable(true);
        attributes84.setIsUnique(false);
//      ...................... OriginalOrder ........................
        Entities entity141 = new Entities();
        entity141 = findBean.nameEntities("OriginalOrder",em);
        attributes84.setEntities(entity141);
//      ...................... Date ........................
        AttributesTypes attributesTypes142 = new AttributesTypes();
        attributesTypes142 = findBean.nameAttributesTypes("Date",em);
        attributes84.setAttributesTypes(attributesTypes142);
        em.persist(attributes84);
        em.flush();

        Attributes attributes85 = new Attributes();
        attributes85.setName("finalDate");
        attributes85.setIsNullable(true);
        attributes85.setIsUnique(false);
//      ...................... OriginalOrder ........................
        Entities entity143 = new Entities();
        entity143 = findBean.nameEntities("OriginalOrder",em);
        attributes85.setEntities(entity143);
//      ...................... Date ........................
        AttributesTypes attributesTypes144 = new AttributesTypes();
        attributesTypes144 = findBean.nameAttributesTypes("Date",em);
        attributes85.setAttributesTypes(attributesTypes144);
        em.persist(attributes85);
        em.flush();

        Attributes attributes86 = new Attributes();
        attributes86.setName("folios");
        attributes86.setIsNullable(true);
        attributes86.setIsUnique(false);
//      ...................... OriginalOrder ........................
        Entities entity145 = new Entities();
        entity145 = findBean.nameEntities("OriginalOrder",em);
        attributes86.setEntities(entity145);
//      ...................... Integer ........................
        AttributesTypes attributesTypes146 = new AttributesTypes();
        attributesTypes146 = findBean.nameAttributesTypes("Integer",em);
        attributes86.setAttributesTypes(attributesTypes146);
        em.persist(attributes86);
        em.flush();

        Attributes attributes87 = new Attributes();
        attributes87.setName("located");
        attributes87.setIsNullable(true);
        attributes87.setIsUnique(false);
//      ...................... OriginalOrder ........................
        Entities entity147 = new Entities();
        entity147 = findBean.nameEntities("OriginalOrder",em);
        attributes87.setEntities(entity147);
//      ...................... String ........................
        AttributesTypes attributesTypes148 = new AttributesTypes();
        attributesTypes148 = findBean.nameAttributesTypes("String",em);
        attributes87.setAttributesTypes(attributesTypes148);
        em.persist(attributes87);
        em.flush();

//      ---------------------- Entities ------------------------

//      ---------------------- Relationships ------------------------

/*
. DocumentalsUnits . 1..* DocumentalInventory rolA: rolB:

. Series . 1..* Series rolA: rolB:

. DocumentsTypes . 1..* Series rolA: rolB:

. Trd . 1..* Series rolA: rolB:

. Series . 1..* DocumentalsUnits rolA: rolB:

. Sections . 1..* Sections rolA: rolB:

. FundsLife . 1..* Funds rolA: rolB:

. DocumentalsSupports . 1..* OriginalOrder rolA: rolB:

. Funds . 1..* Sections rolA: rolB:

. Series . *..* FinalDisposition rolA:from rolB: OK

. DocumentsTypes . 1..* OriginalOrder rolA: rolB:

. DocumentalRetention . 1..* Trd rolA: rolB:

. Sections . 1..* Series rolA: rolB:

. ConservationUnits . 1..* DocumentalsUnits rolA: rolB:

. FrequentlyQuery . 1..* DocumentalsUnits rolA: rolB:

. InventoryFinality . 1..* DocumentalInventory rolA: rolB:

. DocumentalsUnits . 1..* OriginalOrder rolA: rolB:

. SectionsTypes . 1..* Sections rolA: rolB:

. DocumentalRetention . 1..* Trd rolA: rolB:

*/
        Relationships relationships1 = new Relationships();
        relationships1.setIsOptionality(true);
        relationships1.setIsEmbedded(false);
//      ...................... DocumentalsUnits ........................
        Entities entities149 = new Entities();
        entities149 = findBean.nameEntities("DocumentalsUnits",em);
        relationships1.setFrom(entities149);
//      ...................... DocumentalInventory ........................
        Entities entities150 = new Entities();
        entities150 = findBean.nameEntities("DocumentalInventory",em);
        relationships1.setTo(entities150);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities151 = new Cardinalities();
        cardinalities151 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships1.setCardinalities(cardinalities151);
        em.persist(relationships1);
        em.flush();

        Relationships relationships2 = new Relationships();
        relationships2.setIsOptionality(true);
        relationships2.setIsEmbedded(false);
//      ...................... Series ........................
        Entities entities152 = new Entities();
        entities152 = findBean.nameEntities("Series",em);
        relationships2.setFrom(entities152);
//      ...................... Series ........................
        Entities entities153 = new Entities();
        entities153 = findBean.nameEntities("Series",em);
        relationships2.setTo(entities153);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities154 = new Cardinalities();
        cardinalities154 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships2.setCardinalities(cardinalities154);
        em.persist(relationships2);
        em.flush();

        Relationships relationships3 = new Relationships();
        relationships3.setIsOptionality(true);
        relationships3.setIsEmbedded(false);
//      ...................... DocumentsTypes ........................
        Entities entities155 = new Entities();
        entities155 = findBean.nameEntities("DocumentsTypes",em);
        relationships3.setFrom(entities155);
//      ...................... Series ........................
        Entities entities156 = new Entities();
        entities156 = findBean.nameEntities("Series",em);
        relationships3.setTo(entities156);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities157 = new Cardinalities();
        cardinalities157 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships3.setCardinalities(cardinalities157);
        em.persist(relationships3);
        em.flush();

        Relationships relationships4 = new Relationships();
        relationships4.setIsOptionality(true);
        relationships4.setIsEmbedded(false);
//      ...................... Trd ........................
        Entities entities158 = new Entities();
        entities158 = findBean.nameEntities("Trd",em);
        relationships4.setFrom(entities158);
//      ...................... Series ........................
        Entities entities159 = new Entities();
        entities159 = findBean.nameEntities("Series",em);
        relationships4.setTo(entities159);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities160 = new Cardinalities();
        cardinalities160 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships4.setCardinalities(cardinalities160);
        em.persist(relationships4);
        em.flush();

        Relationships relationships5 = new Relationships();
        relationships5.setIsOptionality(true);
        relationships5.setIsEmbedded(false);
//      ...................... Series ........................
        Entities entities161 = new Entities();
        entities161 = findBean.nameEntities("Series",em);
        relationships5.setFrom(entities161);
//      ...................... DocumentalsUnits ........................
        Entities entities162 = new Entities();
        entities162 = findBean.nameEntities("DocumentalsUnits",em);
        relationships5.setTo(entities162);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities163 = new Cardinalities();
        cardinalities163 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships5.setCardinalities(cardinalities163);
        em.persist(relationships5);
        em.flush();

        Relationships relationships6 = new Relationships();
        relationships6.setIsOptionality(true);
        relationships6.setIsEmbedded(false);
//      ...................... Sections ........................
        Entities entities164 = new Entities();
        entities164 = findBean.nameEntities("Sections",em);
        relationships6.setFrom(entities164);
//      ...................... Sections ........................
        Entities entities165 = new Entities();
        entities165 = findBean.nameEntities("Sections",em);
        relationships6.setTo(entities165);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities166 = new Cardinalities();
        cardinalities166 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships6.setCardinalities(cardinalities166);
        em.persist(relationships6);
        em.flush();

        Relationships relationships7 = new Relationships();
        relationships7.setIsOptionality(true);
        relationships7.setIsEmbedded(false);
//      ...................... FundsLife ........................
        Entities entities167 = new Entities();
        entities167 = findBean.nameEntities("FundsLife",em);
        relationships7.setFrom(entities167);
//      ...................... Funds ........................
        Entities entities168 = new Entities();
        entities168 = findBean.nameEntities("Funds",em);
        relationships7.setTo(entities168);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities169 = new Cardinalities();
        cardinalities169 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships7.setCardinalities(cardinalities169);
        em.persist(relationships7);
        em.flush();

        Relationships relationships8 = new Relationships();
        relationships8.setIsOptionality(true);
        relationships8.setIsEmbedded(false);
//      ...................... DocumentalsSupports ........................
        Entities entities170 = new Entities();
        entities170 = findBean.nameEntities("DocumentalsSupports",em);
        relationships8.setFrom(entities170);
//      ...................... OriginalOrder ........................
        Entities entities171 = new Entities();
        entities171 = findBean.nameEntities("OriginalOrder",em);
        relationships8.setTo(entities171);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities172 = new Cardinalities();
        cardinalities172 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships8.setCardinalities(cardinalities172);
        em.persist(relationships8);
        em.flush();

        Relationships relationships9 = new Relationships();
        relationships9.setIsOptionality(true);
        relationships9.setIsEmbedded(false);
//      ...................... Funds ........................
        Entities entities173 = new Entities();
        entities173 = findBean.nameEntities("Funds",em);
        relationships9.setFrom(entities173);
//      ...................... Sections ........................
        Entities entities174 = new Entities();
        entities174 = findBean.nameEntities("Sections",em);
        relationships9.setTo(entities174);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities175 = new Cardinalities();
        cardinalities175 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships9.setCardinalities(cardinalities175);
        em.persist(relationships9);
        em.flush();

        Relationships relationships10 = new Relationships();
        relationships10.setIsOptionality(true);
        relationships10.setIsEmbedded(false);
//      ...................... Series ........................
        Entities entities176 = new Entities();
        entities176 = findBean.nameEntities("Series",em);
        relationships10.setFrom(entities176);
//      ...................... FinalDisposition ........................
        Entities entities177 = new Entities();
        entities177 = findBean.nameEntities("FinalDisposition",em);
        relationships10.setTo(entities177);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities178 = new Cardinalities();
        cardinalities178 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships10.setCardinalities(cardinalities178);
        em.persist(relationships10);
        em.flush();

        Relationships relationships11 = new Relationships();
        relationships11.setIsOptionality(true);
        relationships11.setIsEmbedded(false);
//      ...................... DocumentsTypes ........................
        Entities entities179 = new Entities();
        entities179 = findBean.nameEntities("DocumentsTypes",em);
        relationships11.setFrom(entities179);
//      ...................... OriginalOrder ........................
        Entities entities180 = new Entities();
        entities180 = findBean.nameEntities("OriginalOrder",em);
        relationships11.setTo(entities180);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities181 = new Cardinalities();
        cardinalities181 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships11.setCardinalities(cardinalities181);
        em.persist(relationships11);
        em.flush();

        Relationships relationships12 = new Relationships();
        relationships12.setIsOptionality(true);
        relationships12.setIsEmbedded(false);
//      ...................... DocumentalRetention ........................
        Entities entities182 = new Entities();
        entities182 = findBean.nameEntities("DocumentalRetention",em);
        relationships12.setFrom(entities182);
//      ...................... Trd ........................
        Entities entities183 = new Entities();
        entities183 = findBean.nameEntities("Trd",em);
        relationships12.setTo(entities183);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities184 = new Cardinalities();
        cardinalities184 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships12.setCardinalities(cardinalities184);
        em.persist(relationships12);
        em.flush();

        Relationships relationships13 = new Relationships();
        relationships13.setIsOptionality(true);
        relationships13.setIsEmbedded(false);
//      ...................... Sections ........................
        Entities entities185 = new Entities();
        entities185 = findBean.nameEntities("Sections",em);
        relationships13.setFrom(entities185);
//      ...................... Series ........................
        Entities entities186 = new Entities();
        entities186 = findBean.nameEntities("Series",em);
        relationships13.setTo(entities186);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities187 = new Cardinalities();
        cardinalities187 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships13.setCardinalities(cardinalities187);
        em.persist(relationships13);
        em.flush();

        Relationships relationships14 = new Relationships();
        relationships14.setIsOptionality(true);
        relationships14.setIsEmbedded(false);
//      ...................... ConservationUnits ........................
        Entities entities188 = new Entities();
        entities188 = findBean.nameEntities("ConservationUnits",em);
        relationships14.setFrom(entities188);
//      ...................... DocumentalsUnits ........................
        Entities entities189 = new Entities();
        entities189 = findBean.nameEntities("DocumentalsUnits",em);
        relationships14.setTo(entities189);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities190 = new Cardinalities();
        cardinalities190 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships14.setCardinalities(cardinalities190);
        em.persist(relationships14);
        em.flush();

        Relationships relationships15 = new Relationships();
        relationships15.setIsOptionality(true);
        relationships15.setIsEmbedded(false);
//      ...................... FrequentlyQuery ........................
        Entities entities191 = new Entities();
        entities191 = findBean.nameEntities("FrequentlyQuery",em);
        relationships15.setFrom(entities191);
//      ...................... DocumentalsUnits ........................
        Entities entities192 = new Entities();
        entities192 = findBean.nameEntities("DocumentalsUnits",em);
        relationships15.setTo(entities192);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities193 = new Cardinalities();
        cardinalities193 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships15.setCardinalities(cardinalities193);
        em.persist(relationships15);
        em.flush();

        Relationships relationships16 = new Relationships();
        relationships16.setIsOptionality(true);
        relationships16.setIsEmbedded(false);
//      ...................... InventoryFinality ........................
        Entities entities194 = new Entities();
        entities194 = findBean.nameEntities("InventoryFinality",em);
        relationships16.setFrom(entities194);
//      ...................... DocumentalInventory ........................
        Entities entities195 = new Entities();
        entities195 = findBean.nameEntities("DocumentalInventory",em);
        relationships16.setTo(entities195);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities196 = new Cardinalities();
        cardinalities196 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships16.setCardinalities(cardinalities196);
        em.persist(relationships16);
        em.flush();

        Relationships relationships17 = new Relationships();
        relationships17.setIsOptionality(true);
        relationships17.setIsEmbedded(false);
//      ...................... DocumentalsUnits ........................
        Entities entities197 = new Entities();
        entities197 = findBean.nameEntities("DocumentalsUnits",em);
        relationships17.setFrom(entities197);
//      ...................... OriginalOrder ........................
        Entities entities198 = new Entities();
        entities198 = findBean.nameEntities("OriginalOrder",em);
        relationships17.setTo(entities198);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities199 = new Cardinalities();
        cardinalities199 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships17.setCardinalities(cardinalities199);
        em.persist(relationships17);
        em.flush();

        Relationships relationships18 = new Relationships();
        relationships18.setIsOptionality(true);
        relationships18.setIsEmbedded(false);
//      ...................... SectionsTypes ........................
        Entities entities200 = new Entities();
        entities200 = findBean.nameEntities("SectionsTypes",em);
        relationships18.setFrom(entities200);
//      ...................... Sections ........................
        Entities entities201 = new Entities();
        entities201 = findBean.nameEntities("Sections",em);
        relationships18.setTo(entities201);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities202 = new Cardinalities();
        cardinalities202 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships18.setCardinalities(cardinalities202);
        em.persist(relationships18);
        em.flush();

        Relationships relationships19 = new Relationships();
        relationships19.setIsOptionality(true);
        relationships19.setIsEmbedded(false);
//      ...................... DocumentalRetention ........................
        Entities entities203 = new Entities();
        entities203 = findBean.nameEntities("DocumentalRetention",em);
        relationships19.setFrom(entities203);
//      ...................... Trd ........................
        Entities entities204 = new Entities();
        entities204 = findBean.nameEntities("Trd",em);
        relationships19.setTo(entities204);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities205 = new Cardinalities();
        cardinalities205 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships19.setCardinalities(cardinalities205);
        em.persist(relationships19);
        em.flush();

/*
. BooksTypes . *..* Sites rolA:from rolB: OK

. Chapters . *..* Sites rolA:from rolB: OK

. Books . *..* Sites rolA:from rolB: OK

. Chapters . 1..* RegulationsText rolA:from rolB: OK

*/
        Relationships relationships20 = new Relationships();
        relationships20.setIsOptionality(true);
        relationships20.setIsEmbedded(false);
//      ...................... BooksTypes ........................
        Entities entities206 = new Entities();
        entities206 = findBean.nameEntities("BooksTypes",em);
        relationships20.setFrom(entities206);
//      ...................... Sites ........................
        Entities entities207 = new Entities();
        entities207 = findBean.nameEntities("Sites",em);
        relationships20.setTo(entities207);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities208 = new Cardinalities();
        cardinalities208 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships20.setCardinalities(cardinalities208);
        em.persist(relationships20);
        em.flush();

        Relationships relationships21 = new Relationships();
        relationships21.setIsOptionality(true);
        relationships21.setIsEmbedded(false);
//      ...................... Chapters ........................
        Entities entities209 = new Entities();
        entities209 = findBean.nameEntities("Chapters",em);
        relationships21.setFrom(entities209);
//      ...................... Sites ........................
        Entities entities210 = new Entities();
        entities210 = findBean.nameEntities("Sites",em);
        relationships21.setTo(entities210);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities211 = new Cardinalities();
        cardinalities211 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships21.setCardinalities(cardinalities211);
        em.persist(relationships21);
        em.flush();

        Relationships relationships22 = new Relationships();
        relationships22.setIsOptionality(true);
        relationships22.setIsEmbedded(false);
//      ...................... Books ........................
        Entities entities212 = new Entities();
        entities212 = findBean.nameEntities("Books",em);
        relationships22.setFrom(entities212);
//      ...................... Sites ........................
        Entities entities213 = new Entities();
        entities213 = findBean.nameEntities("Sites",em);
        relationships22.setTo(entities213);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities214 = new Cardinalities();
        cardinalities214 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships22.setCardinalities(cardinalities214);
        em.persist(relationships22);
        em.flush();

        Relationships relationships23 = new Relationships();
        relationships23.setIsOptionality(true);
        relationships23.setIsEmbedded(false);
//      ...................... Chapters ........................
        Entities entities215 = new Entities();
        entities215 = findBean.nameEntities("Chapters",em);
        relationships23.setFrom(entities215);
//      ...................... RegulationsText ........................
        Entities entities216 = new Entities();
        entities216 = findBean.nameEntities("RegulationsText",em);
        relationships23.setTo(entities216);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities217 = new Cardinalities();
        cardinalities217 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships23.setCardinalities(cardinalities217);
        em.persist(relationships23);
        em.flush();

/*
. Regulations . 1..* Sites rolA: rolB:

*/
        Relationships relationships24 = new Relationships();
        relationships24.setIsOptionality(true);
        relationships24.setIsEmbedded(false);
//      ...................... Regulations ........................
        Entities entities218 = new Entities();
        entities218 = findBean.nameEntities("Regulations",em);
        relationships24.setFrom(entities218);
//      ...................... Sites ........................
        Entities entities219 = new Entities();
        entities219 = findBean.nameEntities("Sites",em);
        relationships24.setTo(entities219);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities220 = new Cardinalities();
        cardinalities220 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships24.setCardinalities(cardinalities220);
        em.persist(relationships24);
        em.flush();

/*
. Companies . 1..* RegulationsText rolA: rolB:

. Brands . 1..* RegulationsText rolA: rolB:

. Brands . 1..* Sites rolA: rolB:

. Companies . 1..* Sites rolA: rolB:

*/
        Relationships relationships25 = new Relationships();
        relationships25.setIsOptionality(true);
        relationships25.setIsEmbedded(false);
//      ...................... Companies ........................
        Entities entities221 = new Entities();
        entities221 = findBean.nameEntities("Companies",em);
        relationships25.setFrom(entities221);
//      ...................... RegulationsText ........................
        Entities entities222 = new Entities();
        entities222 = findBean.nameEntities("RegulationsText",em);
        relationships25.setTo(entities222);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities223 = new Cardinalities();
        cardinalities223 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships25.setCardinalities(cardinalities223);
        em.persist(relationships25);
        em.flush();

        Relationships relationships26 = new Relationships();
        relationships26.setIsOptionality(true);
        relationships26.setIsEmbedded(false);
//      ...................... Brands ........................
        Entities entities224 = new Entities();
        entities224 = findBean.nameEntities("Brands",em);
        relationships26.setFrom(entities224);
//      ...................... RegulationsText ........................
        Entities entities225 = new Entities();
        entities225 = findBean.nameEntities("RegulationsText",em);
        relationships26.setTo(entities225);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities226 = new Cardinalities();
        cardinalities226 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships26.setCardinalities(cardinalities226);
        em.persist(relationships26);
        em.flush();

        Relationships relationships27 = new Relationships();
        relationships27.setIsOptionality(true);
        relationships27.setIsEmbedded(false);
//      ...................... Brands ........................
        Entities entities227 = new Entities();
        entities227 = findBean.nameEntities("Brands",em);
        relationships27.setFrom(entities227);
//      ...................... Sites ........................
        Entities entities228 = new Entities();
        entities228 = findBean.nameEntities("Sites",em);
        relationships27.setTo(entities228);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities229 = new Cardinalities();
        cardinalities229 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships27.setCardinalities(cardinalities229);
        em.persist(relationships27);
        em.flush();

        Relationships relationships28 = new Relationships();
        relationships28.setIsOptionality(true);
        relationships28.setIsEmbedded(false);
//      ...................... Companies ........................
        Entities entities230 = new Entities();
        entities230 = findBean.nameEntities("Companies",em);
        relationships28.setFrom(entities230);
//      ...................... Sites ........................
        Entities entities231 = new Entities();
        entities231 = findBean.nameEntities("Sites",em);
        relationships28.setTo(entities231);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities232 = new Cardinalities();
        cardinalities232 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships28.setCardinalities(cardinalities232);
        em.persist(relationships28);
        em.flush();

/*
. Books . 1..* Chapters rolA: rolB:

. BooksTypes . 1..* Books rolA: rolB:

. Chapters . 1..* Chapters rolA: rolB:

. BooksTypes . 1..* BooksTypes rolA: rolB:

*/
        Relationships relationships29 = new Relationships();
        relationships29.setIsOptionality(true);
        relationships29.setIsEmbedded(false);
//      ...................... Books ........................
        Entities entities233 = new Entities();
        entities233 = findBean.nameEntities("Books",em);
        relationships29.setFrom(entities233);
//      ...................... Chapters ........................
        Entities entities234 = new Entities();
        entities234 = findBean.nameEntities("Chapters",em);
        relationships29.setTo(entities234);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities235 = new Cardinalities();
        cardinalities235 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships29.setCardinalities(cardinalities235);
        em.persist(relationships29);
        em.flush();

        Relationships relationships30 = new Relationships();
        relationships30.setIsOptionality(true);
        relationships30.setIsEmbedded(false);
//      ...................... BooksTypes ........................
        Entities entities236 = new Entities();
        entities236 = findBean.nameEntities("BooksTypes",em);
        relationships30.setFrom(entities236);
//      ...................... Books ........................
        Entities entities237 = new Entities();
        entities237 = findBean.nameEntities("Books",em);
        relationships30.setTo(entities237);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities238 = new Cardinalities();
        cardinalities238 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships30.setCardinalities(cardinalities238);
        em.persist(relationships30);
        em.flush();

        Relationships relationships31 = new Relationships();
        relationships31.setIsOptionality(true);
        relationships31.setIsEmbedded(false);
//      ...................... Chapters ........................
        Entities entities239 = new Entities();
        entities239 = findBean.nameEntities("Chapters",em);
        relationships31.setFrom(entities239);
//      ...................... Chapters ........................
        Entities entities240 = new Entities();
        entities240 = findBean.nameEntities("Chapters",em);
        relationships31.setTo(entities240);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities241 = new Cardinalities();
        cardinalities241 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships31.setCardinalities(cardinalities241);
        em.persist(relationships31);
        em.flush();

        Relationships relationships32 = new Relationships();
        relationships32.setIsOptionality(true);
        relationships32.setIsEmbedded(false);
//      ...................... BooksTypes ........................
        Entities entities242 = new Entities();
        entities242 = findBean.nameEntities("BooksTypes",em);
        relationships32.setFrom(entities242);
//      ...................... BooksTypes ........................
        Entities entities243 = new Entities();
        entities243 = findBean.nameEntities("BooksTypes",em);
        relationships32.setTo(entities243);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities244 = new Cardinalities();
        cardinalities244 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships32.setCardinalities(cardinalities244);
        em.persist(relationships32);
        em.flush();

/*
*/
/*
. SitesTypes . *..* Sites rolA:from rolB: OK

. SitesTypes . 1..* SitesTypes rolA: rolB:

*/
        Relationships relationships33 = new Relationships();
        relationships33.setIsOptionality(true);
        relationships33.setIsEmbedded(false);
//      ...................... SitesTypes ........................
        Entities entities245 = new Entities();
        entities245 = findBean.nameEntities("SitesTypes",em);
        relationships33.setFrom(entities245);
//      ...................... Sites ........................
        Entities entities246 = new Entities();
        entities246 = findBean.nameEntities("Sites",em);
        relationships33.setTo(entities246);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities247 = new Cardinalities();
        cardinalities247 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships33.setCardinalities(cardinalities247);
        em.persist(relationships33);
        em.flush();

        Relationships relationships34 = new Relationships();
        relationships34.setIsOptionality(true);
        relationships34.setIsEmbedded(false);
//      ...................... SitesTypes ........................
        Entities entities248 = new Entities();
        entities248 = findBean.nameEntities("SitesTypes",em);
        relationships34.setFrom(entities248);
//      ...................... SitesTypes ........................
        Entities entities249 = new Entities();
        entities249 = findBean.nameEntities("SitesTypes",em);
        relationships34.setTo(entities249);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities250 = new Cardinalities();
        cardinalities250 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships34.setCardinalities(cardinalities250);
        em.persist(relationships34);
        em.flush();

/*
. OriginalOrder . 1..* Sites rolA: rolB:

. Series . 1..* RegulationsText rolA: rolB:

. Series . 1..* Sites rolA: rolB:

. Series . 1..* Chapters rolA: rolB:

. Companies . 1..* Funds rolA: rolB:

*/
        Relationships relationships35 = new Relationships();
        relationships35.setIsOptionality(true);
        relationships35.setIsEmbedded(false);
//      ...................... OriginalOrder ........................
        Entities entities251 = new Entities();
        entities251 = findBean.nameEntities("OriginalOrder",em);
        relationships35.setFrom(entities251);
//      ...................... Sites ........................
        Entities entities252 = new Entities();
        entities252 = findBean.nameEntities("Sites",em);
        relationships35.setTo(entities252);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities253 = new Cardinalities();
        cardinalities253 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships35.setCardinalities(cardinalities253);
        em.persist(relationships35);
        em.flush();

        Relationships relationships36 = new Relationships();
        relationships36.setIsOptionality(true);
        relationships36.setIsEmbedded(false);
//      ...................... Series ........................
        Entities entities254 = new Entities();
        entities254 = findBean.nameEntities("Series",em);
        relationships36.setFrom(entities254);
//      ...................... RegulationsText ........................
        Entities entities255 = new Entities();
        entities255 = findBean.nameEntities("RegulationsText",em);
        relationships36.setTo(entities255);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities256 = new Cardinalities();
        cardinalities256 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships36.setCardinalities(cardinalities256);
        em.persist(relationships36);
        em.flush();

        Relationships relationships37 = new Relationships();
        relationships37.setIsOptionality(true);
        relationships37.setIsEmbedded(false);
//      ...................... Series ........................
        Entities entities257 = new Entities();
        entities257 = findBean.nameEntities("Series",em);
        relationships37.setFrom(entities257);
//      ...................... Sites ........................
        Entities entities258 = new Entities();
        entities258 = findBean.nameEntities("Sites",em);
        relationships37.setTo(entities258);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities259 = new Cardinalities();
        cardinalities259 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships37.setCardinalities(cardinalities259);
        em.persist(relationships37);
        em.flush();

        Relationships relationships38 = new Relationships();
        relationships38.setIsOptionality(true);
        relationships38.setIsEmbedded(false);
//      ...................... Series ........................
        Entities entities260 = new Entities();
        entities260 = findBean.nameEntities("Series",em);
        relationships38.setFrom(entities260);
//      ...................... Chapters ........................
        Entities entities261 = new Entities();
        entities261 = findBean.nameEntities("Chapters",em);
        relationships38.setTo(entities261);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities262 = new Cardinalities();
        cardinalities262 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships38.setCardinalities(cardinalities262);
        em.persist(relationships38);
        em.flush();

        Relationships relationships39 = new Relationships();
        relationships39.setIsOptionality(true);
        relationships39.setIsEmbedded(false);
//      ...................... Companies ........................
        Entities entities263 = new Entities();
        entities263 = findBean.nameEntities("Companies",em);
        relationships39.setFrom(entities263);
//      ...................... Funds ........................
        Entities entities264 = new Entities();
        entities264 = findBean.nameEntities("Funds",em);
        relationships39.setTo(entities264);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities265 = new Cardinalities();
        cardinalities265 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships39.setCardinalities(cardinalities265);
        em.persist(relationships39);
        em.flush();

/*
. Companies . 1..* Companies rolA: rolB:

. Companies . 1..* Brands rolA: rolB:

*/
        Relationships relationships40 = new Relationships();
        relationships40.setIsOptionality(true);
        relationships40.setIsEmbedded(false);
//      ...................... Companies ........................
        Entities entities266 = new Entities();
        entities266 = findBean.nameEntities("Companies",em);
        relationships40.setFrom(entities266);
//      ...................... Companies ........................
        Entities entities267 = new Entities();
        entities267 = findBean.nameEntities("Companies",em);
        relationships40.setTo(entities267);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities268 = new Cardinalities();
        cardinalities268 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships40.setCardinalities(cardinalities268);
        em.persist(relationships40);
        em.flush();

        Relationships relationships41 = new Relationships();
        relationships41.setIsOptionality(true);
        relationships41.setIsEmbedded(false);
//      ...................... Companies ........................
        Entities entities269 = new Entities();
        entities269 = findBean.nameEntities("Companies",em);
        relationships41.setFrom(entities269);
//      ...................... Brands ........................
        Entities entities270 = new Entities();
        entities270 = findBean.nameEntities("Brands",em);
        relationships41.setTo(entities270);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities271 = new Cardinalities();
        cardinalities271 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships41.setCardinalities(cardinalities271);
        em.persist(relationships41);
        em.flush();

/*
*/
/*
*/
/*
*/
/*
*/
/*
. RegulationsTypes . 1..* Regulations rolA: rolB:

. RegulationsText . 1..* RegulationsText rolA: rolB:

. RegulationsTypes . 1..* RegulationsTypes rolA: rolB:

. Regulations . 1..* RegulationsText rolA: rolB:

*/
        Relationships relationships42 = new Relationships();
        relationships42.setIsOptionality(true);
        relationships42.setIsEmbedded(false);
//      ...................... RegulationsTypes ........................
        Entities entities272 = new Entities();
        entities272 = findBean.nameEntities("RegulationsTypes",em);
        relationships42.setFrom(entities272);
//      ...................... Regulations ........................
        Entities entities273 = new Entities();
        entities273 = findBean.nameEntities("Regulations",em);
        relationships42.setTo(entities273);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities274 = new Cardinalities();
        cardinalities274 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships42.setCardinalities(cardinalities274);
        em.persist(relationships42);
        em.flush();

        Relationships relationships43 = new Relationships();
        relationships43.setIsOptionality(true);
        relationships43.setIsEmbedded(false);
//      ...................... RegulationsText ........................
        Entities entities275 = new Entities();
        entities275 = findBean.nameEntities("RegulationsText",em);
        relationships43.setFrom(entities275);
//      ...................... RegulationsText ........................
        Entities entities276 = new Entities();
        entities276 = findBean.nameEntities("RegulationsText",em);
        relationships43.setTo(entities276);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities277 = new Cardinalities();
        cardinalities277 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships43.setCardinalities(cardinalities277);
        em.persist(relationships43);
        em.flush();

        Relationships relationships44 = new Relationships();
        relationships44.setIsOptionality(true);
        relationships44.setIsEmbedded(false);
//      ...................... RegulationsTypes ........................
        Entities entities278 = new Entities();
        entities278 = findBean.nameEntities("RegulationsTypes",em);
        relationships44.setFrom(entities278);
//      ...................... RegulationsTypes ........................
        Entities entities279 = new Entities();
        entities279 = findBean.nameEntities("RegulationsTypes",em);
        relationships44.setTo(entities279);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities280 = new Cardinalities();
        cardinalities280 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships44.setCardinalities(cardinalities280);
        em.persist(relationships44);
        em.flush();

        Relationships relationships45 = new Relationships();
        relationships45.setIsOptionality(true);
        relationships45.setIsEmbedded(false);
//      ...................... Regulations ........................
        Entities entities281 = new Entities();
        entities281 = findBean.nameEntities("Regulations",em);
        relationships45.setFrom(entities281);
//      ...................... RegulationsText ........................
        Entities entities282 = new Entities();
        entities282 = findBean.nameEntities("RegulationsText",em);
        relationships45.setTo(entities282);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities283 = new Cardinalities();
        cardinalities283 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships45.setCardinalities(cardinalities283);
        em.persist(relationships45);
        em.flush();

    } // data()

} // core
