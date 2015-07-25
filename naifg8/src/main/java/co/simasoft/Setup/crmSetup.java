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
@Named("crmSetup")
public class crmSetup {

    @PersistenceContext(unitName = "naifg8PU-JTA")
    private EntityManager em;

    FindBean findBean = new FindBean();

    private static final Logger log = Logger.getLogger(DataDb.class.getName());

    public void data() {

//      ---------------------- DomainModels ------------------------

        DomainModels domainModels = new DomainModels();
        domainModels.setGroupId("co.simasoft");
        domainModels.setArtifactId("crm");
        domainModels.setVersion("1.0-SNAPSHOT");
        em.persist(domainModels);
        em.flush();

//      ---------------------- GroupIds ------------------------

        GroupIds groupIds1 = new GroupIds();
        groupIds1.setGroupId("co.simasoft.models.naif.crm");
//      ...................... crm ........................
        DomainModels domainModel1 = new DomainModels();
        domainModel1 = findBean.artifactIdDomainModels("crm",em);
        groupIds1.setDomainModels(domainModel1);
        em.persist(groupIds1);
        em.flush();

//      ---------------------- Entities ------------------------

        Entities entities2 = new Entities();
        entities2.setName("SectionsTypes");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId2 = new GroupIds();
        groupId2 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities2.setGroupIds(groupId2);
        em.persist(entities2);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes3 = new Attributes();
        attributes3.setName("name");
        attributes3.setNullable(true);
        attributes3.setSingle(false);
//      ...................... SectionsTypes ........................
        Entities entity3 = new Entities();
        entity3 = findBean.nameEntities("SectionsTypes",em);
        attributes3.setEntities(entity3);
//      ...................... String ........................
        AttributesTypes attributesTypes4 = new AttributesTypes();
        attributesTypes4 = findBean.nameAttributesTypes("String",em);
        attributes3.setAttributesTypes(attributesTypes4);
        em.persist(attributes3);
        em.flush();

        Entities entities4 = new Entities();
        entities4.setName("TasksTypes");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId5 = new GroupIds();
        groupId5 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities4.setGroupIds(groupId5);
        em.persist(entities4);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes5 = new Attributes();
        attributes5.setName("name");
        attributes5.setNullable(true);
        attributes5.setSingle(false);
//      ...................... TasksTypes ........................
        Entities entity6 = new Entities();
        entity6 = findBean.nameEntities("TasksTypes",em);
        attributes5.setEntities(entity6);
//      ...................... String ........................
        AttributesTypes attributesTypes7 = new AttributesTypes();
        attributesTypes7 = findBean.nameAttributesTypes("String",em);
        attributes5.setAttributesTypes(attributesTypes7);
        em.persist(attributes5);
        em.flush();

        Entities entities6 = new Entities();
        entities6.setName("Items");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId8 = new GroupIds();
        groupId8 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities6.setGroupIds(groupId8);
        em.persist(entities6);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes7 = new Attributes();
        attributes7.setName("cvNumber");
        attributes7.setNullable(true);
        attributes7.setSingle(false);
//      ...................... Items ........................
        Entities entity9 = new Entities();
        entity9 = findBean.nameEntities("Items",em);
        attributes7.setEntities(entity9);
//      ...................... String ........................
        AttributesTypes attributesTypes10 = new AttributesTypes();
        attributesTypes10 = findBean.nameAttributesTypes("String",em);
        attributes7.setAttributesTypes(attributesTypes10);
        em.persist(attributes7);
        em.flush();

        Attributes attributes8 = new Attributes();
        attributes8.setName("code");
        attributes8.setNullable(true);
        attributes8.setSingle(false);
//      ...................... Items ........................
        Entities entity11 = new Entities();
        entity11 = findBean.nameEntities("Items",em);
        attributes8.setEntities(entity11);
//      ...................... String ........................
        AttributesTypes attributesTypes12 = new AttributesTypes();
        attributesTypes12 = findBean.nameAttributesTypes("String",em);
        attributes8.setAttributesTypes(attributesTypes12);
        em.persist(attributes8);
        em.flush();

        Attributes attributes9 = new Attributes();
        attributes9.setName("inventoryCode");
        attributes9.setNullable(true);
        attributes9.setSingle(false);
//      ...................... Items ........................
        Entities entity13 = new Entities();
        entity13 = findBean.nameEntities("Items",em);
        attributes9.setEntities(entity13);
//      ...................... String ........................
        AttributesTypes attributesTypes14 = new AttributesTypes();
        attributesTypes14 = findBean.nameAttributesTypes("String",em);
        attributes9.setAttributesTypes(attributesTypes14);
        em.persist(attributes9);
        em.flush();

        Attributes attributes10 = new Attributes();
        attributes10.setName("serial");
        attributes10.setNullable(true);
        attributes10.setSingle(false);
//      ...................... Items ........................
        Entities entity15 = new Entities();
        entity15 = findBean.nameEntities("Items",em);
        attributes10.setEntities(entity15);
//      ...................... String ........................
        AttributesTypes attributesTypes16 = new AttributesTypes();
        attributesTypes16 = findBean.nameAttributesTypes("String",em);
        attributes10.setAttributesTypes(attributesTypes16);
        em.persist(attributes10);
        em.flush();

        Attributes attributes11 = new Attributes();
        attributes11.setName("barCode");
        attributes11.setNullable(true);
        attributes11.setSingle(false);
//      ...................... Items ........................
        Entities entity17 = new Entities();
        entity17 = findBean.nameEntities("Items",em);
        attributes11.setEntities(entity17);
//      ...................... String ........................
        AttributesTypes attributesTypes18 = new AttributesTypes();
        attributesTypes18 = findBean.nameAttributesTypes("String",em);
        attributes11.setAttributesTypes(attributesTypes18);
        em.persist(attributes11);
        em.flush();

        Attributes attributes12 = new Attributes();
        attributes12.setName("buyDate");
        attributes12.setNullable(true);
        attributes12.setSingle(false);
//      ...................... Items ........................
        Entities entity19 = new Entities();
        entity19 = findBean.nameEntities("Items",em);
        attributes12.setEntities(entity19);
//      ...................... Date ........................
        AttributesTypes attributesTypes20 = new AttributesTypes();
        attributesTypes20 = findBean.nameAttributesTypes("Date",em);
        attributes12.setAttributesTypes(attributesTypes20);
        em.persist(attributes12);
        em.flush();

        Attributes attributes13 = new Attributes();
        attributes13.setName("expirationDate");
        attributes13.setNullable(true);
        attributes13.setSingle(false);
//      ...................... Items ........................
        Entities entity21 = new Entities();
        entity21 = findBean.nameEntities("Items",em);
        attributes13.setEntities(entity21);
//      ...................... Date ........................
        AttributesTypes attributesTypes22 = new AttributesTypes();
        attributesTypes22 = findBean.nameAttributesTypes("Date",em);
        attributes13.setAttributesTypes(attributesTypes22);
        em.persist(attributes13);
        em.flush();

        Attributes attributes14 = new Attributes();
        attributes14.setName("warrantyDate");
        attributes14.setNullable(true);
        attributes14.setSingle(false);
//      ...................... Items ........................
        Entities entity23 = new Entities();
        entity23 = findBean.nameEntities("Items",em);
        attributes14.setEntities(entity23);
//      ...................... Date ........................
        AttributesTypes attributesTypes24 = new AttributesTypes();
        attributesTypes24 = findBean.nameAttributesTypes("Date",em);
        attributes14.setAttributesTypes(attributesTypes24);
        em.persist(attributes14);
        em.flush();

        Attributes attributes15 = new Attributes();
        attributes15.setName("minStock");
        attributes15.setNullable(true);
        attributes15.setSingle(false);
//      ...................... Items ........................
        Entities entity25 = new Entities();
        entity25 = findBean.nameEntities("Items",em);
        attributes15.setEntities(entity25);
//      ...................... Integer ........................
        AttributesTypes attributesTypes26 = new AttributesTypes();
        attributesTypes26 = findBean.nameAttributesTypes("Integer",em);
        attributes15.setAttributesTypes(attributesTypes26);
        em.persist(attributes15);
        em.flush();

        Attributes attributes16 = new Attributes();
        attributes16.setName("maxStock");
        attributes16.setNullable(true);
        attributes16.setSingle(false);
//      ...................... Items ........................
        Entities entity27 = new Entities();
        entity27 = findBean.nameEntities("Items",em);
        attributes16.setEntities(entity27);
//      ...................... Integer ........................
        AttributesTypes attributesTypes28 = new AttributesTypes();
        attributesTypes28 = findBean.nameAttributesTypes("Integer",em);
        attributes16.setAttributesTypes(attributesTypes28);
        em.persist(attributes16);
        em.flush();

        Attributes attributes17 = new Attributes();
        attributes17.setName("quantity");
        attributes17.setNullable(true);
        attributes17.setSingle(false);
//      ...................... Items ........................
        Entities entity29 = new Entities();
        entity29 = findBean.nameEntities("Items",em);
        attributes17.setEntities(entity29);
//      ...................... Integer ........................
        AttributesTypes attributesTypes30 = new AttributesTypes();
        attributesTypes30 = findBean.nameAttributesTypes("Integer",em);
        attributes17.setAttributesTypes(attributesTypes30);
        em.persist(attributes17);
        em.flush();

        Attributes attributes18 = new Attributes();
        attributes18.setName("located");
        attributes18.setNullable(true);
        attributes18.setSingle(false);
//      ...................... Items ........................
        Entities entity31 = new Entities();
        entity31 = findBean.nameEntities("Items",em);
        attributes18.setEntities(entity31);
//      ...................... String ........................
        AttributesTypes attributesTypes32 = new AttributesTypes();
        attributesTypes32 = findBean.nameAttributesTypes("String",em);
        attributes18.setAttributesTypes(attributesTypes32);
        em.persist(attributes18);
        em.flush();

        Entities entities19 = new Entities();
        entities19.setName("ItemsTypes");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId33 = new GroupIds();
        groupId33 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities19.setGroupIds(groupId33);
        em.persist(entities19);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes20 = new Attributes();
        attributes20.setName("nombre");
        attributes20.setNullable(true);
        attributes20.setSingle(false);
//      ...................... ItemsTypes ........................
        Entities entity34 = new Entities();
        entity34 = findBean.nameEntities("ItemsTypes",em);
        attributes20.setEntities(entity34);
//      ...................... String ........................
        AttributesTypes attributesTypes35 = new AttributesTypes();
        attributesTypes35 = findBean.nameAttributesTypes("String",em);
        attributes20.setAttributesTypes(attributesTypes35);
        em.persist(attributes20);
        em.flush();

        Entities entities21 = new Entities();
        entities21.setName("ItemsNames");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId36 = new GroupIds();
        groupId36 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities21.setGroupIds(groupId36);
        em.persist(entities21);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes22 = new Attributes();
        attributes22.setName("name");
        attributes22.setNullable(true);
        attributes22.setSingle(false);
//      ...................... ItemsNames ........................
        Entities entity37 = new Entities();
        entity37 = findBean.nameEntities("ItemsNames",em);
        attributes22.setEntities(entity37);
//      ...................... String ........................
        AttributesTypes attributesTypes38 = new AttributesTypes();
        attributesTypes38 = findBean.nameAttributesTypes("String",em);
        attributes22.setAttributesTypes(attributesTypes38);
        em.persist(attributes22);
        em.flush();

        Attributes attributes23 = new Attributes();
        attributes23.setName("model");
        attributes23.setNullable(true);
        attributes23.setSingle(false);
//      ...................... ItemsNames ........................
        Entities entity39 = new Entities();
        entity39 = findBean.nameEntities("ItemsNames",em);
        attributes23.setEntities(entity39);
//      ...................... String ........................
        AttributesTypes attributesTypes40 = new AttributesTypes();
        attributesTypes40 = findBean.nameAttributesTypes("String",em);
        attributes23.setAttributesTypes(attributesTypes40);
        em.persist(attributes23);
        em.flush();

        Attributes attributes24 = new Attributes();
        attributes24.setName("productNumber");
        attributes24.setNullable(true);
        attributes24.setSingle(false);
//      ...................... ItemsNames ........................
        Entities entity41 = new Entities();
        entity41 = findBean.nameEntities("ItemsNames",em);
        attributes24.setEntities(entity41);
//      ...................... String ........................
        AttributesTypes attributesTypes42 = new AttributesTypes();
        attributesTypes42 = findBean.nameAttributesTypes("String",em);
        attributes24.setAttributesTypes(attributesTypes42);
        em.persist(attributes24);
        em.flush();

        Attributes attributes25 = new Attributes();
        attributes25.setName("partNumber");
        attributes25.setNullable(true);
        attributes25.setSingle(false);
//      ...................... ItemsNames ........................
        Entities entity43 = new Entities();
        entity43 = findBean.nameEntities("ItemsNames",em);
        attributes25.setEntities(entity43);
//      ...................... String ........................
        AttributesTypes attributesTypes44 = new AttributesTypes();
        attributesTypes44 = findBean.nameAttributesTypes("String",em);
        attributes25.setAttributesTypes(attributesTypes44);
        em.persist(attributes25);
        em.flush();

        Attributes attributes26 = new Attributes();
        attributes26.setName("link");
        attributes26.setNullable(true);
        attributes26.setSingle(false);
//      ...................... ItemsNames ........................
        Entities entity45 = new Entities();
        entity45 = findBean.nameEntities("ItemsNames",em);
        attributes26.setEntities(entity45);
//      ...................... String ........................
        AttributesTypes attributesTypes46 = new AttributesTypes();
        attributesTypes46 = findBean.nameAttributesTypes("String",em);
        attributes26.setAttributesTypes(attributesTypes46);
        em.persist(attributes26);
        em.flush();

        Entities entities27 = new Entities();
        entities27.setName("Switches");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId47 = new GroupIds();
        groupId47 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities27.setGroupIds(groupId47);
        em.persist(entities27);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes28 = new Attributes();
        attributes28.setName("name");
        attributes28.setNullable(true);
        attributes28.setSingle(false);
//      ...................... Switches ........................
        Entities entity48 = new Entities();
        entity48 = findBean.nameEntities("Switches",em);
        attributes28.setEntities(entity48);
//      ...................... String ........................
        AttributesTypes attributesTypes49 = new AttributesTypes();
        attributesTypes49 = findBean.nameAttributesTypes("String",em);
        attributes28.setAttributesTypes(attributesTypes49);
        em.persist(attributes28);
        em.flush();

        Entities entities29 = new Entities();
        entities29.setName("DocumentsTypes");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId50 = new GroupIds();
        groupId50 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities29.setGroupIds(groupId50);
        em.persist(entities29);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes30 = new Attributes();
        attributes30.setName("name");
        attributes30.setNullable(true);
        attributes30.setSingle(false);
//      ...................... DocumentsTypes ........................
        Entities entity51 = new Entities();
        entity51 = findBean.nameEntities("DocumentsTypes",em);
        attributes30.setEntities(entity51);
//      ...................... String ........................
        AttributesTypes attributesTypes52 = new AttributesTypes();
        attributesTypes52 = findBean.nameAttributesTypes("String",em);
        attributes30.setAttributesTypes(attributesTypes52);
        em.persist(attributes30);
        em.flush();

        Entities entities31 = new Entities();
        entities31.setName("Calendars");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId53 = new GroupIds();
        groupId53 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities31.setGroupIds(groupId53);
        em.persist(entities31);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes32 = new Attributes();
        attributes32.setName("name");
        attributes32.setNullable(true);
        attributes32.setSingle(false);
//      ...................... Calendars ........................
        Entities entity54 = new Entities();
        entity54 = findBean.nameEntities("Calendars",em);
        attributes32.setEntities(entity54);
//      ...................... String ........................
        AttributesTypes attributesTypes55 = new AttributesTypes();
        attributesTypes55 = findBean.nameAttributesTypes("String",em);
        attributes32.setAttributesTypes(attributesTypes55);
        em.persist(attributes32);
        em.flush();

        Attributes attributes33 = new Attributes();
        attributes33.setName("date");
        attributes33.setNullable(true);
        attributes33.setSingle(false);
//      ...................... Calendars ........................
        Entities entity56 = new Entities();
        entity56 = findBean.nameEntities("Calendars",em);
        attributes33.setEntities(entity56);
//      ...................... Date ........................
        AttributesTypes attributesTypes57 = new AttributesTypes();
        attributesTypes57 = findBean.nameAttributesTypes("Date",em);
        attributes33.setAttributesTypes(attributesTypes57);
        em.persist(attributes33);
        em.flush();

        Entities entities34 = new Entities();
        entities34.setName("PhysicalAreas");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId58 = new GroupIds();
        groupId58 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities34.setGroupIds(groupId58);
        em.persist(entities34);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes35 = new Attributes();
        attributes35.setName("name");
        attributes35.setNullable(true);
        attributes35.setSingle(false);
//      ...................... PhysicalAreas ........................
        Entities entity59 = new Entities();
        entity59 = findBean.nameEntities("PhysicalAreas",em);
        attributes35.setEntities(entity59);
//      ...................... String ........................
        AttributesTypes attributesTypes60 = new AttributesTypes();
        attributesTypes60 = findBean.nameAttributesTypes("String",em);
        attributes35.setAttributesTypes(attributesTypes60);
        em.persist(attributes35);
        em.flush();

        Entities entities36 = new Entities();
        entities36.setName("Activities");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId61 = new GroupIds();
        groupId61 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities36.setGroupIds(groupId61);
        em.persist(entities36);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes37 = new Attributes();
        attributes37.setName("name");
        attributes37.setNullable(true);
        attributes37.setSingle(false);
//      ...................... Activities ........................
        Entities entity62 = new Entities();
        entity62 = findBean.nameEntities("Activities",em);
        attributes37.setEntities(entity62);
//      ...................... String ........................
        AttributesTypes attributesTypes63 = new AttributesTypes();
        attributesTypes63 = findBean.nameAttributesTypes("String",em);
        attributes37.setAttributesTypes(attributesTypes63);
        em.persist(attributes37);
        em.flush();

        Attributes attributes38 = new Attributes();
        attributes38.setName("detail");
        attributes38.setNullable(true);
        attributes38.setSingle(false);
//      ...................... Activities ........................
        Entities entity64 = new Entities();
        entity64 = findBean.nameEntities("Activities",em);
        attributes38.setEntities(entity64);
//      ...................... String ........................
        AttributesTypes attributesTypes65 = new AttributesTypes();
        attributesTypes65 = findBean.nameAttributesTypes("String",em);
        attributes38.setAttributesTypes(attributesTypes65);
        em.persist(attributes38);
        em.flush();

        Entities entities39 = new Entities();
        entities39.setName("Sections");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId66 = new GroupIds();
        groupId66 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities39.setGroupIds(groupId66);
        em.persist(entities39);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes40 = new Attributes();
        attributes40.setName("name");
        attributes40.setNullable(true);
        attributes40.setSingle(false);
//      ...................... Sections ........................
        Entities entity67 = new Entities();
        entity67 = findBean.nameEntities("Sections",em);
        attributes40.setEntities(entity67);
//      ...................... String ........................
        AttributesTypes attributesTypes68 = new AttributesTypes();
        attributesTypes68 = findBean.nameAttributesTypes("String",em);
        attributes40.setAttributesTypes(attributesTypes68);
        em.persist(attributes40);
        em.flush();

        Attributes attributes41 = new Attributes();
        attributes41.setName("code");
        attributes41.setNullable(true);
        attributes41.setSingle(false);
//      ...................... Sections ........................
        Entities entity69 = new Entities();
        entity69 = findBean.nameEntities("Sections",em);
        attributes41.setEntities(entity69);
//      ...................... String ........................
        AttributesTypes attributesTypes70 = new AttributesTypes();
        attributesTypes70 = findBean.nameAttributesTypes("String",em);
        attributes41.setAttributesTypes(attributesTypes70);
        em.persist(attributes41);
        em.flush();

        Attributes attributes42 = new Attributes();
        attributes42.setName("email");
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

        Entities entities43 = new Entities();
        entities43.setName("InventoriesTypes");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId73 = new GroupIds();
        groupId73 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities43.setGroupIds(groupId73);
        em.persist(entities43);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes44 = new Attributes();
        attributes44.setName("name");
        attributes44.setNullable(true);
        attributes44.setSingle(false);
//      ...................... InventoriesTypes ........................
        Entities entity74 = new Entities();
        entity74 = findBean.nameEntities("InventoriesTypes",em);
        attributes44.setEntities(entity74);
//      ...................... String ........................
        AttributesTypes attributesTypes75 = new AttributesTypes();
        attributesTypes75 = findBean.nameAttributesTypes("String",em);
        attributes44.setAttributesTypes(attributesTypes75);
        em.persist(attributes44);
        em.flush();

        Attributes attributes45 = new Attributes();
        attributes45.setName("observations");
        attributes45.setNullable(true);
        attributes45.setSingle(false);
//      ...................... InventoriesTypes ........................
        Entities entity76 = new Entities();
        entity76 = findBean.nameEntities("InventoriesTypes",em);
        attributes45.setEntities(entity76);
//      ...................... String ........................
        AttributesTypes attributesTypes77 = new AttributesTypes();
        attributesTypes77 = findBean.nameAttributesTypes("String",em);
        attributes45.setAttributesTypes(attributesTypes77);
        em.persist(attributes45);
        em.flush();

        Entities entities46 = new Entities();
        entities46.setName("Inventories");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId78 = new GroupIds();
        groupId78 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities46.setGroupIds(groupId78);
        em.persist(entities46);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes47 = new Attributes();
        attributes47.setName("name");
        attributes47.setNullable(true);
        attributes47.setSingle(false);
//      ...................... Inventories ........................
        Entities entity79 = new Entities();
        entity79 = findBean.nameEntities("Inventories",em);
        attributes47.setEntities(entity79);
//      ...................... String ........................
        AttributesTypes attributesTypes80 = new AttributesTypes();
        attributesTypes80 = findBean.nameAttributesTypes("String",em);
        attributes47.setAttributesTypes(attributesTypes80);
        em.persist(attributes47);
        em.flush();

        Entities entities48 = new Entities();
        entities48.setName("Tasks");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId81 = new GroupIds();
        groupId81 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities48.setGroupIds(groupId81);
        em.persist(entities48);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes49 = new Attributes();
        attributes49.setName("name");
        attributes49.setNullable(true);
        attributes49.setSingle(false);
//      ...................... Tasks ........................
        Entities entity82 = new Entities();
        entity82 = findBean.nameEntities("Tasks",em);
        attributes49.setEntities(entity82);
//      ...................... String ........................
        AttributesTypes attributesTypes83 = new AttributesTypes();
        attributesTypes83 = findBean.nameAttributesTypes("String",em);
        attributes49.setAttributesTypes(attributesTypes83);
        em.persist(attributes49);
        em.flush();

        Attributes attributes50 = new Attributes();
        attributes50.setName("date");
        attributes50.setNullable(true);
        attributes50.setSingle(false);
//      ...................... Tasks ........................
        Entities entity84 = new Entities();
        entity84 = findBean.nameEntities("Tasks",em);
        attributes50.setEntities(entity84);
//      ...................... Date ........................
        AttributesTypes attributesTypes85 = new AttributesTypes();
        attributesTypes85 = findBean.nameAttributesTypes("Date",em);
        attributes50.setAttributesTypes(attributesTypes85);
        em.persist(attributes50);
        em.flush();

        Attributes attributes51 = new Attributes();
        attributes51.setName("priority");
        attributes51.setNullable(true);
        attributes51.setSingle(false);
//      ...................... Tasks ........................
        Entities entity86 = new Entities();
        entity86 = findBean.nameEntities("Tasks",em);
        attributes51.setEntities(entity86);
//      ...................... Integer ........................
        AttributesTypes attributesTypes87 = new AttributesTypes();
        attributesTypes87 = findBean.nameAttributesTypes("Integer",em);
        attributes51.setAttributesTypes(attributesTypes87);
        em.persist(attributes51);
        em.flush();

        Attributes attributes52 = new Attributes();
        attributes52.setName("detail");
        attributes52.setNullable(true);
        attributes52.setSingle(false);
//      ...................... Tasks ........................
        Entities entity88 = new Entities();
        entity88 = findBean.nameEntities("Tasks",em);
        attributes52.setEntities(entity88);
//      ...................... String ........................
        AttributesTypes attributesTypes89 = new AttributesTypes();
        attributesTypes89 = findBean.nameAttributesTypes("String",em);
        attributes52.setAttributesTypes(attributesTypes89);
        em.persist(attributes52);
        em.flush();

        Attributes attributes53 = new Attributes();
        attributes53.setName("isOpen");
        attributes53.setNullable(true);
        attributes53.setSingle(false);
//      ...................... Tasks ........................
        Entities entity90 = new Entities();
        entity90 = findBean.nameEntities("Tasks",em);
        attributes53.setEntities(entity90);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes91 = new AttributesTypes();
        attributesTypes91 = findBean.nameAttributesTypes("Boolean",em);
        attributes53.setAttributesTypes(attributesTypes91);
        em.persist(attributes53);
        em.flush();

        Entities entities54 = new Entities();
        entities54.setName("PhysicalAreasTypes");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId92 = new GroupIds();
        groupId92 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities54.setGroupIds(groupId92);
        em.persist(entities54);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes55 = new Attributes();
        attributes55.setName("name");
        attributes55.setNullable(true);
        attributes55.setSingle(false);
//      ...................... PhysicalAreasTypes ........................
        Entities entity93 = new Entities();
        entity93 = findBean.nameEntities("PhysicalAreasTypes",em);
        attributes55.setEntities(entity93);
//      ...................... String ........................
        AttributesTypes attributesTypes94 = new AttributesTypes();
        attributesTypes94 = findBean.nameAttributesTypes("String",em);
        attributes55.setAttributesTypes(attributesTypes94);
        em.persist(attributes55);
        em.flush();

        Entities entities56 = new Entities();
        entities56.setName("Series");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId95 = new GroupIds();
        groupId95 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities56.setGroupIds(groupId95);
        em.persist(entities56);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes57 = new Attributes();
        attributes57.setName("name");
        attributes57.setNullable(true);
        attributes57.setSingle(false);
//      ...................... Series ........................
        Entities entity96 = new Entities();
        entity96 = findBean.nameEntities("Series",em);
        attributes57.setEntities(entity96);
//      ...................... String ........................
        AttributesTypes attributesTypes97 = new AttributesTypes();
        attributesTypes97 = findBean.nameAttributesTypes("String",em);
        attributes57.setAttributesTypes(attributesTypes97);
        em.persist(attributes57);
        em.flush();

        Attributes attributes58 = new Attributes();
        attributes58.setName("code");
        attributes58.setNullable(true);
        attributes58.setSingle(false);
//      ...................... Series ........................
        Entities entity98 = new Entities();
        entity98 = findBean.nameEntities("Series",em);
        attributes58.setEntities(entity98);
//      ...................... String ........................
        AttributesTypes attributesTypes99 = new AttributesTypes();
        attributesTypes99 = findBean.nameAttributesTypes("String",em);
        attributes58.setAttributesTypes(attributesTypes99);
        em.persist(attributes58);
        em.flush();

        Entities entities59 = new Entities();
        entities59.setName("SwitchesPorts");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId100 = new GroupIds();
        groupId100 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities59.setGroupIds(groupId100);
        em.persist(entities59);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes60 = new Attributes();
        attributes60.setName("port");
        attributes60.setNullable(true);
        attributes60.setSingle(false);
//      ...................... SwitchesPorts ........................
        Entities entity101 = new Entities();
        entity101 = findBean.nameEntities("SwitchesPorts",em);
        attributes60.setEntities(entity101);
//      ...................... String ........................
        AttributesTypes attributesTypes102 = new AttributesTypes();
        attributesTypes102 = findBean.nameAttributesTypes("String",em);
        attributes60.setAttributesTypes(attributesTypes102);
        em.persist(attributes60);
        em.flush();

        Attributes attributes61 = new Attributes();
        attributes61.setName("code");
        attributes61.setNullable(true);
        attributes61.setSingle(false);
//      ...................... SwitchesPorts ........................
        Entities entity103 = new Entities();
        entity103 = findBean.nameEntities("SwitchesPorts",em);
        attributes61.setEntities(entity103);
//      ...................... String ........................
        AttributesTypes attributesTypes104 = new AttributesTypes();
        attributesTypes104 = findBean.nameAttributesTypes("String",em);
        attributes61.setAttributesTypes(attributesTypes104);
        em.persist(attributes61);
        em.flush();

        Attributes attributes62 = new Attributes();
        attributes62.setName("state");
        attributes62.setNullable(true);
        attributes62.setSingle(false);
//      ...................... SwitchesPorts ........................
        Entities entity105 = new Entities();
        entity105 = findBean.nameEntities("SwitchesPorts",em);
        attributes62.setEntities(entity105);
//      ...................... String ........................
        AttributesTypes attributesTypes106 = new AttributesTypes();
        attributesTypes106 = findBean.nameAttributesTypes("String",em);
        attributes62.setAttributesTypes(attributesTypes106);
        em.persist(attributes62);
        em.flush();

        Entities entities63 = new Entities();
        entities63.setName("Brands");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId107 = new GroupIds();
        groupId107 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities63.setGroupIds(groupId107);
        em.persist(entities63);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes64 = new Attributes();
        attributes64.setName("name");
        attributes64.setNullable(true);
        attributes64.setSingle(false);
//      ...................... Brands ........................
        Entities entity108 = new Entities();
        entity108 = findBean.nameEntities("Brands",em);
        attributes64.setEntities(entity108);
//      ...................... String ........................
        AttributesTypes attributesTypes109 = new AttributesTypes();
        attributesTypes109 = findBean.nameAttributesTypes("String",em);
        attributes64.setAttributesTypes(attributesTypes109);
        em.persist(attributes64);
        em.flush();

        Entities entities65 = new Entities();
        entities65.setName("Invoices");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId110 = new GroupIds();
        groupId110 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities65.setGroupIds(groupId110);
        em.persist(entities65);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes66 = new Attributes();
        attributes66.setName("number");
        attributes66.setNullable(true);
        attributes66.setSingle(false);
//      ...................... Invoices ........................
        Entities entity111 = new Entities();
        entity111 = findBean.nameEntities("Invoices",em);
        attributes66.setEntities(entity111);
//      ...................... String ........................
        AttributesTypes attributesTypes112 = new AttributesTypes();
        attributesTypes112 = findBean.nameAttributesTypes("String",em);
        attributes66.setAttributesTypes(attributesTypes112);
        em.persist(attributes66);
        em.flush();

        Entities entities67 = new Entities();
        entities67.setName("ItemsStates");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId113 = new GroupIds();
        groupId113 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities67.setGroupIds(groupId113);
        em.persist(entities67);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes68 = new Attributes();
        attributes68.setName("name");
        attributes68.setNullable(true);
        attributes68.setSingle(false);
//      ...................... ItemsStates ........................
        Entities entity114 = new Entities();
        entity114 = findBean.nameEntities("ItemsStates",em);
        attributes68.setEntities(entity114);
//      ...................... String ........................
        AttributesTypes attributesTypes115 = new AttributesTypes();
        attributesTypes115 = findBean.nameAttributesTypes("String",em);
        attributes68.setAttributesTypes(attributesTypes115);
        em.persist(attributes68);
        em.flush();

        Entities entities69 = new Entities();
        entities69.setName("IpAddresses");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId116 = new GroupIds();
        groupId116 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities69.setGroupIds(groupId116);
        em.persist(entities69);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes70 = new Attributes();
        attributes70.setName("ip");
        attributes70.setNullable(true);
        attributes70.setSingle(false);
//      ...................... IpAddresses ........................
        Entities entity117 = new Entities();
        entity117 = findBean.nameEntities("IpAddresses",em);
        attributes70.setEntities(entity117);
//      ...................... String ........................
        AttributesTypes attributesTypes118 = new AttributesTypes();
        attributesTypes118 = findBean.nameAttributesTypes("String",em);
        attributes70.setAttributesTypes(attributesTypes118);
        em.persist(attributes70);
        em.flush();

        Attributes attributes71 = new Attributes();
        attributes71.setName("link");
        attributes71.setNullable(true);
        attributes71.setSingle(false);
//      ...................... IpAddresses ........................
        Entities entity119 = new Entities();
        entity119 = findBean.nameEntities("IpAddresses",em);
        attributes71.setEntities(entity119);
//      ...................... String ........................
        AttributesTypes attributesTypes120 = new AttributesTypes();
        attributesTypes120 = findBean.nameAttributesTypes("String",em);
        attributes71.setAttributesTypes(attributesTypes120);
        em.persist(attributes71);
        em.flush();

        Attributes attributes72 = new Attributes();
        attributes72.setName("isSecure");
        attributes72.setNullable(true);
        attributes72.setSingle(false);
//      ...................... IpAddresses ........................
        Entities entity121 = new Entities();
        entity121 = findBean.nameEntities("IpAddresses",em);
        attributes72.setEntities(entity121);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes122 = new AttributesTypes();
        attributesTypes122 = findBean.nameAttributesTypes("Boolean",em);
        attributes72.setAttributesTypes(attributesTypes122);
        em.persist(attributes72);
        em.flush();

        Entities entities73 = new Entities();
        entities73.setName("Companies");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId123 = new GroupIds();
        groupId123 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities73.setGroupIds(groupId123);
        em.persist(entities73);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes74 = new Attributes();
        attributes74.setName("name");
        attributes74.setNullable(true);
        attributes74.setSingle(false);
//      ...................... Companies ........................
        Entities entity124 = new Entities();
        entity124 = findBean.nameEntities("Companies",em);
        attributes74.setEntities(entity124);
//      ...................... String ........................
        AttributesTypes attributesTypes125 = new AttributesTypes();
        attributesTypes125 = findBean.nameAttributesTypes("String",em);
        attributes74.setAttributesTypes(attributesTypes125);
        em.persist(attributes74);
        em.flush();

        Attributes attributes75 = new Attributes();
        attributes75.setName("nit");
        attributes75.setNullable(true);
        attributes75.setSingle(false);
//      ...................... Companies ........................
        Entities entity126 = new Entities();
        entity126 = findBean.nameEntities("Companies",em);
        attributes75.setEntities(entity126);
//      ...................... String ........................
        AttributesTypes attributesTypes127 = new AttributesTypes();
        attributesTypes127 = findBean.nameAttributesTypes("String",em);
        attributes75.setAttributesTypes(attributesTypes127);
        em.persist(attributes75);
        em.flush();

        Attributes attributes76 = new Attributes();
        attributes76.setName("link");
        attributes76.setNullable(true);
        attributes76.setSingle(false);
//      ...................... Companies ........................
        Entities entity128 = new Entities();
        entity128 = findBean.nameEntities("Companies",em);
        attributes76.setEntities(entity128);
//      ...................... String ........................
        AttributesTypes attributesTypes129 = new AttributesTypes();
        attributesTypes129 = findBean.nameAttributesTypes("String",em);
        attributes76.setAttributesTypes(attributesTypes129);
        em.persist(attributes76);
        em.flush();

        Attributes attributes77 = new Attributes();
        attributes77.setName("address");
        attributes77.setNullable(true);
        attributes77.setSingle(false);
//      ...................... Companies ........................
        Entities entity130 = new Entities();
        entity130 = findBean.nameEntities("Companies",em);
        attributes77.setEntities(entity130);
//      ...................... String ........................
        AttributesTypes attributesTypes131 = new AttributesTypes();
        attributesTypes131 = findBean.nameAttributesTypes("String",em);
        attributes77.setAttributesTypes(attributesTypes131);
        em.persist(attributes77);
        em.flush();

        Attributes attributes78 = new Attributes();
        attributes78.setName("telephones");
        attributes78.setNullable(true);
        attributes78.setSingle(false);
//      ...................... Companies ........................
        Entities entity132 = new Entities();
        entity132 = findBean.nameEntities("Companies",em);
        attributes78.setEntities(entity132);
//      ...................... String ........................
        AttributesTypes attributesTypes133 = new AttributesTypes();
        attributesTypes133 = findBean.nameAttributesTypes("String",em);
        attributes78.setAttributesTypes(attributesTypes133);
        em.persist(attributes78);
        em.flush();

        Attributes attributes79 = new Attributes();
        attributes79.setName("email");
        attributes79.setNullable(true);
        attributes79.setSingle(false);
//      ...................... Companies ........................
        Entities entity134 = new Entities();
        entity134 = findBean.nameEntities("Companies",em);
        attributes79.setEntities(entity134);
//      ...................... String ........................
        AttributesTypes attributesTypes135 = new AttributesTypes();
        attributesTypes135 = findBean.nameAttributesTypes("String",em);
        attributes79.setAttributesTypes(attributesTypes135);
        em.persist(attributes79);
        em.flush();

        Entities entities80 = new Entities();
        entities80.setName("Persons");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId136 = new GroupIds();
        groupId136 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities80.setGroupIds(groupId136);
        em.persist(entities80);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes81 = new Attributes();
        attributes81.setName("firstLastName");
        attributes81.setNullable(true);
        attributes81.setSingle(false);
//      ...................... Persons ........................
        Entities entity137 = new Entities();
        entity137 = findBean.nameEntities("Persons",em);
        attributes81.setEntities(entity137);
//      ...................... String ........................
        AttributesTypes attributesTypes138 = new AttributesTypes();
        attributesTypes138 = findBean.nameAttributesTypes("String",em);
        attributes81.setAttributesTypes(attributesTypes138);
        em.persist(attributes81);
        em.flush();

        Attributes attributes82 = new Attributes();
        attributes82.setName("secondLastName");
        attributes82.setNullable(true);
        attributes82.setSingle(false);
//      ...................... Persons ........................
        Entities entity139 = new Entities();
        entity139 = findBean.nameEntities("Persons",em);
        attributes82.setEntities(entity139);
//      ...................... String ........................
        AttributesTypes attributesTypes140 = new AttributesTypes();
        attributesTypes140 = findBean.nameAttributesTypes("String",em);
        attributes82.setAttributesTypes(attributesTypes140);
        em.persist(attributes82);
        em.flush();

        Attributes attributes83 = new Attributes();
        attributes83.setName("firstName");
        attributes83.setNullable(true);
        attributes83.setSingle(false);
//      ...................... Persons ........................
        Entities entity141 = new Entities();
        entity141 = findBean.nameEntities("Persons",em);
        attributes83.setEntities(entity141);
//      ...................... String ........................
        AttributesTypes attributesTypes142 = new AttributesTypes();
        attributesTypes142 = findBean.nameAttributesTypes("String",em);
        attributes83.setAttributesTypes(attributesTypes142);
        em.persist(attributes83);
        em.flush();

        Attributes attributes84 = new Attributes();
        attributes84.setName("secondName");
        attributes84.setNullable(true);
        attributes84.setSingle(false);
//      ...................... Persons ........................
        Entities entity143 = new Entities();
        entity143 = findBean.nameEntities("Persons",em);
        attributes84.setEntities(entity143);
//      ...................... String ........................
        AttributesTypes attributesTypes144 = new AttributesTypes();
        attributesTypes144 = findBean.nameAttributesTypes("String",em);
        attributes84.setAttributesTypes(attributesTypes144);
        em.persist(attributes84);
        em.flush();

        Attributes attributes85 = new Attributes();
        attributes85.setName("address");
        attributes85.setNullable(true);
        attributes85.setSingle(false);
//      ...................... Persons ........................
        Entities entity145 = new Entities();
        entity145 = findBean.nameEntities("Persons",em);
        attributes85.setEntities(entity145);
//      ...................... String ........................
        AttributesTypes attributesTypes146 = new AttributesTypes();
        attributesTypes146 = findBean.nameAttributesTypes("String",em);
        attributes85.setAttributesTypes(attributesTypes146);
        em.persist(attributes85);
        em.flush();

        Attributes attributes86 = new Attributes();
        attributes86.setName("telephones");
        attributes86.setNullable(true);
        attributes86.setSingle(false);
//      ...................... Persons ........................
        Entities entity147 = new Entities();
        entity147 = findBean.nameEntities("Persons",em);
        attributes86.setEntities(entity147);
//      ...................... String ........................
        AttributesTypes attributesTypes148 = new AttributesTypes();
        attributesTypes148 = findBean.nameAttributesTypes("String",em);
        attributes86.setAttributesTypes(attributesTypes148);
        em.persist(attributes86);
        em.flush();

        Attributes attributes87 = new Attributes();
        attributes87.setName("email");
        attributes87.setNullable(true);
        attributes87.setSingle(false);
//      ...................... Persons ........................
        Entities entity149 = new Entities();
        entity149 = findBean.nameEntities("Persons",em);
        attributes87.setEntities(entity149);
//      ...................... String ........................
        AttributesTypes attributesTypes150 = new AttributesTypes();
        attributesTypes150 = findBean.nameAttributesTypes("String",em);
        attributes87.setAttributesTypes(attributesTypes150);
        em.persist(attributes87);
        em.flush();

        Entities entities88 = new Entities();
        entities88.setName("SitesTypes");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId151 = new GroupIds();
        groupId151 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities88.setGroupIds(groupId151);
        em.persist(entities88);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes89 = new Attributes();
        attributes89.setName("name");
        attributes89.setNullable(true);
        attributes89.setSingle(false);
//      ...................... SitesTypes ........................
        Entities entity152 = new Entities();
        entity152 = findBean.nameEntities("SitesTypes",em);
        attributes89.setEntities(entity152);
//      ...................... String ........................
        AttributesTypes attributesTypes153 = new AttributesTypes();
        attributesTypes153 = findBean.nameAttributesTypes("String",em);
        attributes89.setAttributesTypes(attributesTypes153);
        em.persist(attributes89);
        em.flush();

        Entities entities90 = new Entities();
        entities90.setName("ActivitiesTypes");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId154 = new GroupIds();
        groupId154 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities90.setGroupIds(groupId154);
        em.persist(entities90);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes91 = new Attributes();
        attributes91.setName("name");
        attributes91.setNullable(true);
        attributes91.setSingle(false);
//      ...................... ActivitiesTypes ........................
        Entities entity155 = new Entities();
        entity155 = findBean.nameEntities("ActivitiesTypes",em);
        attributes91.setEntities(entity155);
//      ...................... String ........................
        AttributesTypes attributesTypes156 = new AttributesTypes();
        attributesTypes156 = findBean.nameAttributesTypes("String",em);
        attributes91.setAttributesTypes(attributesTypes156);
        em.persist(attributes91);
        em.flush();

        Entities entities92 = new Entities();
        entities92.setName("InvoicesItems");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId157 = new GroupIds();
        groupId157 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities92.setGroupIds(groupId157);
        em.persist(entities92);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes93 = new Attributes();
        attributes93.setName("quantity");
        attributes93.setNullable(true);
        attributes93.setSingle(false);
//      ...................... InvoicesItems ........................
        Entities entity158 = new Entities();
        entity158 = findBean.nameEntities("InvoicesItems",em);
        attributes93.setEntities(entity158);
//      ...................... Integer ........................
        AttributesTypes attributesTypes159 = new AttributesTypes();
        attributesTypes159 = findBean.nameAttributesTypes("Integer",em);
        attributes93.setAttributesTypes(attributesTypes159);
        em.persist(attributes93);
        em.flush();

        Attributes attributes94 = new Attributes();
        attributes94.setName("unitPrice");
        attributes94.setNullable(true);
        attributes94.setSingle(false);
//      ...................... InvoicesItems ........................
        Entities entity160 = new Entities();
        entity160 = findBean.nameEntities("InvoicesItems",em);
        attributes94.setEntities(entity160);
//      ...................... double ........................
        AttributesTypes attributesTypes161 = new AttributesTypes();
        attributesTypes161 = findBean.nameAttributesTypes("double",em);
        attributes94.setAttributesTypes(attributesTypes161);
        em.persist(attributes94);
        em.flush();

        Entities entities95 = new Entities();
        entities95.setName("NetworkPorts");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId162 = new GroupIds();
        groupId162 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities95.setGroupIds(groupId162);
        em.persist(entities95);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes96 = new Attributes();
        attributes96.setName("ipAddress");
        attributes96.setNullable(true);
        attributes96.setSingle(false);
//      ...................... NetworkPorts ........................
        Entities entity163 = new Entities();
        entity163 = findBean.nameEntities("NetworkPorts",em);
        attributes96.setEntities(entity163);
//      ...................... String ........................
        AttributesTypes attributesTypes164 = new AttributesTypes();
        attributesTypes164 = findBean.nameAttributesTypes("String",em);
        attributes96.setAttributesTypes(attributesTypes164);
        em.persist(attributes96);
        em.flush();

        Attributes attributes97 = new Attributes();
        attributes97.setName("macAddress");
        attributes97.setNullable(true);
        attributes97.setSingle(false);
//      ...................... NetworkPorts ........................
        Entities entity165 = new Entities();
        entity165 = findBean.nameEntities("NetworkPorts",em);
        attributes97.setEntities(entity165);
//      ...................... String ........................
        AttributesTypes attributesTypes166 = new AttributesTypes();
        attributesTypes166 = findBean.nameAttributesTypes("String",em);
        attributes97.setAttributesTypes(attributesTypes166);
        em.persist(attributes97);
        em.flush();

        Attributes attributes98 = new Attributes();
        attributes98.setName("isActive");
        attributes98.setNullable(true);
        attributes98.setSingle(false);
//      ...................... NetworkPorts ........................
        Entities entity167 = new Entities();
        entity167 = findBean.nameEntities("NetworkPorts",em);
        attributes98.setEntities(entity167);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes168 = new AttributesTypes();
        attributesTypes168 = findBean.nameAttributesTypes("Boolean",em);
        attributes98.setAttributesTypes(attributesTypes168);
        em.persist(attributes98);
        em.flush();

        Entities entities99 = new Entities();
        entities99.setName("PersonalType");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId169 = new GroupIds();
        groupId169 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities99.setGroupIds(groupId169);
        em.persist(entities99);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes100 = new Attributes();
        attributes100.setName("name");
        attributes100.setNullable(true);
        attributes100.setSingle(false);
//      ...................... PersonalType ........................
        Entities entity170 = new Entities();
        entity170 = findBean.nameEntities("PersonalType",em);
        attributes100.setEntities(entity170);
//      ...................... String ........................
        AttributesTypes attributesTypes171 = new AttributesTypes();
        attributesTypes171 = findBean.nameAttributesTypes("String",em);
        attributes100.setAttributesTypes(attributesTypes171);
        em.persist(attributes100);
        em.flush();

        Entities entities101 = new Entities();
        entities101.setName("Sites");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId172 = new GroupIds();
        groupId172 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities101.setGroupIds(groupId172);
        em.persist(entities101);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes102 = new Attributes();
        attributes102.setName("title");
        attributes102.setNullable(true);
        attributes102.setSingle(false);
//      ...................... Sites ........................
        Entities entity173 = new Entities();
        entity173 = findBean.nameEntities("Sites",em);
        attributes102.setEntities(entity173);
//      ...................... String ........................
        AttributesTypes attributesTypes174 = new AttributesTypes();
        attributesTypes174 = findBean.nameAttributesTypes("String",em);
        attributes102.setAttributesTypes(attributesTypes174);
        em.persist(attributes102);
        em.flush();

        Attributes attributes103 = new Attributes();
        attributes103.setName("link");
        attributes103.setNullable(false);
        attributes103.setSingle(true);
//      ...................... Sites ........................
        Entities entity175 = new Entities();
        entity175 = findBean.nameEntities("Sites",em);
        attributes103.setEntities(entity175);
//      ...................... String ........................
        AttributesTypes attributesTypes176 = new AttributesTypes();
        attributesTypes176 = findBean.nameAttributesTypes("String",em);
        attributes103.setAttributesTypes(attributesTypes176);
        em.persist(attributes103);
        em.flush();

        Entities entities104 = new Entities();
        entities104.setName("VLan");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId177 = new GroupIds();
        groupId177 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities104.setGroupIds(groupId177);
        em.persist(entities104);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes105 = new Attributes();
        attributes105.setName("name");
        attributes105.setNullable(true);
        attributes105.setSingle(false);
//      ...................... VLan ........................
        Entities entity178 = new Entities();
        entity178 = findBean.nameEntities("VLan",em);
        attributes105.setEntities(entity178);
//      ...................... String ........................
        AttributesTypes attributesTypes179 = new AttributesTypes();
        attributesTypes179 = findBean.nameAttributesTypes("String",em);
        attributes105.setAttributesTypes(attributesTypes179);
        em.persist(attributes105);
        em.flush();

        Attributes attributes106 = new Attributes();
        attributes106.setName("ipAddress");
        attributes106.setNullable(true);
        attributes106.setSingle(false);
//      ...................... VLan ........................
        Entities entity180 = new Entities();
        entity180 = findBean.nameEntities("VLan",em);
        attributes106.setEntities(entity180);
//      ...................... String ........................
        AttributesTypes attributesTypes181 = new AttributesTypes();
        attributesTypes181 = findBean.nameAttributesTypes("String",em);
        attributes106.setAttributesTypes(attributesTypes181);
        em.persist(attributes106);
        em.flush();

//      ---------------------- Relationships ------------------------

/*
. Items . 1..* InvoicesItems rolA: rolB:

. Brands . *..* Companies rolA:from rolB: OK

. ItemsTypes . 1..* Items rolA: rolB:

. SitesTypes . *..* Sites rolA: rolB:from OK

. NetworkPorts . 1..1 SwitchesPorts rolA:from rolB: OK

. Activities . *..* Sites rolA: rolB:from OK

. Tasks . *..* Sites rolA:from rolB: OK

. VLan . 1..* NetworkPorts rolA: rolB:

. Invoices . 1..* InvoicesItems rolA: rolB:

. Series . 1..* Sites rolA: rolB:

. PhysicalAreas . 1..* Items rolA: rolB:

. Activities . *..* Tasks rolA:from rolB: OK

. Companies . *..* Sites rolA: rolB:from OK

. SitesTypes . 1..* SitesTypes rolA: rolB:

. Series . 1..* Series rolA: rolB:

. SectionsTypes . 1..* Sections rolA: rolB:

. ItemsStates . 1..* Items rolA: rolB:

. ActivitiesTypes . *..* Activities rolA: rolB:from OK

. Items . 1..* Items rolA: rolB:

. PhysicalAreasTypes . 1..* PhysicalAreas rolA: rolB:

. PersonalType . 1..* Persons rolA: rolB:

. Items . 1..* NetworkPorts rolA: rolB:

. PhysicalAreas . 1..* PhysicalAreas rolA: rolB:

. Calendars . *..* Activities rolA: rolB:from OK

. Inventories . 1..* Items rolA: rolB:

. ItemsNames . 1..* Items rolA: rolB:

. Companies . 1..* Invoices rolA: rolB:

. Sections . *..* Tasks rolA:from rolB: OK

. DocumentsTypes . 1..* Series rolA: rolB:

. Items . 1..* Switches rolA: rolB:

. Persons . *..* Activities rolA:from rolB: OK

. Sections . *..* Series rolA:from rolB: OK

. Sections . *..* Activities rolA: rolB:from OK

. Persons . 1..* Sections rolA: rolB:

. Switches . 1..* SwitchesPorts rolA: rolB:

. Persons . *..* Sites rolA: rolB:from OK

. Sites . 1..* IpAddresses rolA: rolB:

. Sections . 1..* Items rolA: rolB:

. TasksTypes . 1..* Tasks rolA: rolB:

. Brands . 1..* ItemsNames rolA: rolB:

. Sections . 1..* Sections rolA: rolB:

. InventoriesTypes . 1..* Inventories rolA: rolB:

. Companies . 1..* Persons rolA: rolB:

*/
        Relationships relationships1 = new Relationships();
        relationships1.setOptionality(true);
        relationships1.setIsEmbedded(false);
//      ...................... Items ........................
        Entities entities182 = new Entities();
        entities182 = findBean.nameEntities("Items",em);
        relationships1.setFrom(entities182);
//      ...................... InvoicesItems ........................
        Entities entities183 = new Entities();
        entities183 = findBean.nameEntities("InvoicesItems",em);
        relationships1.setTo(entities183);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities184 = new Cardinalities();
        cardinalities184 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships1.setCardinalities(cardinalities184);
        em.persist(relationships1);
        em.flush();

        Relationships relationships2 = new Relationships();
        relationships2.setOptionality(true);
        relationships2.setIsEmbedded(false);
//      ...................... Brands ........................
        Entities entities185 = new Entities();
        entities185 = findBean.nameEntities("Brands",em);
        relationships2.setFrom(entities185);
//      ...................... Companies ........................
        Entities entities186 = new Entities();
        entities186 = findBean.nameEntities("Companies",em);
        relationships2.setTo(entities186);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities187 = new Cardinalities();
        cardinalities187 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships2.setCardinalities(cardinalities187);
        em.persist(relationships2);
        em.flush();

        Relationships relationships3 = new Relationships();
        relationships3.setOptionality(true);
        relationships3.setIsEmbedded(false);
//      ...................... ItemsTypes ........................
        Entities entities188 = new Entities();
        entities188 = findBean.nameEntities("ItemsTypes",em);
        relationships3.setFrom(entities188);
//      ...................... Items ........................
        Entities entities189 = new Entities();
        entities189 = findBean.nameEntities("Items",em);
        relationships3.setTo(entities189);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities190 = new Cardinalities();
        cardinalities190 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships3.setCardinalities(cardinalities190);
        em.persist(relationships3);
        em.flush();

        Relationships relationships4 = new Relationships();
        relationships4.setOptionality(true);
        relationships4.setIsEmbedded(false);
//      ...................... SitesTypes ........................
        Entities entities191 = new Entities();
        entities191 = findBean.nameEntities("SitesTypes",em);
        relationships4.setFrom(entities191);
//      ...................... Sites ........................
        Entities entities192 = new Entities();
        entities192 = findBean.nameEntities("Sites",em);
        relationships4.setTo(entities192);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities193 = new Cardinalities();
        cardinalities193 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships4.setCardinalities(cardinalities193);
        em.persist(relationships4);
        em.flush();

        Relationships relationships5 = new Relationships();
        relationships5.setOptionality(true);
        relationships5.setIsEmbedded(false);
//      ...................... NetworkPorts ........................
        Entities entities194 = new Entities();
        entities194 = findBean.nameEntities("NetworkPorts",em);
        relationships5.setFrom(entities194);
//      ...................... SwitchesPorts ........................
        Entities entities195 = new Entities();
        entities195 = findBean.nameEntities("SwitchesPorts",em);
        relationships5.setTo(entities195);
//      ...................... Uno a Uno Bidirecccional No.2 ........................
        Cardinalities cardinalities196 = new Cardinalities();
        cardinalities196 = findBean.nameCardinalities("Uno a Uno Bidirecccional No.2",em);
        relationships5.setCardinalities(cardinalities196);
        em.persist(relationships5);
        em.flush();

        Relationships relationships6 = new Relationships();
        relationships6.setOptionality(true);
        relationships6.setIsEmbedded(false);
//      ...................... Activities ........................
        Entities entities197 = new Entities();
        entities197 = findBean.nameEntities("Activities",em);
        relationships6.setFrom(entities197);
//      ...................... Sites ........................
        Entities entities198 = new Entities();
        entities198 = findBean.nameEntities("Sites",em);
        relationships6.setTo(entities198);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities199 = new Cardinalities();
        cardinalities199 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships6.setCardinalities(cardinalities199);
        em.persist(relationships6);
        em.flush();

        Relationships relationships7 = new Relationships();
        relationships7.setOptionality(true);
        relationships7.setIsEmbedded(false);
//      ...................... Tasks ........................
        Entities entities200 = new Entities();
        entities200 = findBean.nameEntities("Tasks",em);
        relationships7.setFrom(entities200);
//      ...................... Sites ........................
        Entities entities201 = new Entities();
        entities201 = findBean.nameEntities("Sites",em);
        relationships7.setTo(entities201);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities202 = new Cardinalities();
        cardinalities202 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships7.setCardinalities(cardinalities202);
        em.persist(relationships7);
        em.flush();

        Relationships relationships8 = new Relationships();
        relationships8.setOptionality(true);
        relationships8.setIsEmbedded(false);
//      ...................... VLan ........................
        Entities entities203 = new Entities();
        entities203 = findBean.nameEntities("VLan",em);
        relationships8.setFrom(entities203);
//      ...................... NetworkPorts ........................
        Entities entities204 = new Entities();
        entities204 = findBean.nameEntities("NetworkPorts",em);
        relationships8.setTo(entities204);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities205 = new Cardinalities();
        cardinalities205 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships8.setCardinalities(cardinalities205);
        em.persist(relationships8);
        em.flush();

        Relationships relationships9 = new Relationships();
        relationships9.setOptionality(true);
        relationships9.setIsEmbedded(false);
//      ...................... Invoices ........................
        Entities entities206 = new Entities();
        entities206 = findBean.nameEntities("Invoices",em);
        relationships9.setFrom(entities206);
//      ...................... InvoicesItems ........................
        Entities entities207 = new Entities();
        entities207 = findBean.nameEntities("InvoicesItems",em);
        relationships9.setTo(entities207);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities208 = new Cardinalities();
        cardinalities208 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships9.setCardinalities(cardinalities208);
        em.persist(relationships9);
        em.flush();

        Relationships relationships10 = new Relationships();
        relationships10.setOptionality(true);
        relationships10.setIsEmbedded(false);
//      ...................... Series ........................
        Entities entities209 = new Entities();
        entities209 = findBean.nameEntities("Series",em);
        relationships10.setFrom(entities209);
//      ...................... Sites ........................
        Entities entities210 = new Entities();
        entities210 = findBean.nameEntities("Sites",em);
        relationships10.setTo(entities210);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities211 = new Cardinalities();
        cardinalities211 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships10.setCardinalities(cardinalities211);
        em.persist(relationships10);
        em.flush();

        Relationships relationships11 = new Relationships();
        relationships11.setOptionality(true);
        relationships11.setIsEmbedded(false);
//      ...................... PhysicalAreas ........................
        Entities entities212 = new Entities();
        entities212 = findBean.nameEntities("PhysicalAreas",em);
        relationships11.setFrom(entities212);
//      ...................... Items ........................
        Entities entities213 = new Entities();
        entities213 = findBean.nameEntities("Items",em);
        relationships11.setTo(entities213);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities214 = new Cardinalities();
        cardinalities214 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships11.setCardinalities(cardinalities214);
        em.persist(relationships11);
        em.flush();

        Relationships relationships12 = new Relationships();
        relationships12.setOptionality(true);
        relationships12.setIsEmbedded(false);
//      ...................... Activities ........................
        Entities entities215 = new Entities();
        entities215 = findBean.nameEntities("Activities",em);
        relationships12.setFrom(entities215);
//      ...................... Tasks ........................
        Entities entities216 = new Entities();
        entities216 = findBean.nameEntities("Tasks",em);
        relationships12.setTo(entities216);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities217 = new Cardinalities();
        cardinalities217 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships12.setCardinalities(cardinalities217);
        em.persist(relationships12);
        em.flush();

        Relationships relationships13 = new Relationships();
        relationships13.setOptionality(true);
        relationships13.setIsEmbedded(false);
//      ...................... Companies ........................
        Entities entities218 = new Entities();
        entities218 = findBean.nameEntities("Companies",em);
        relationships13.setFrom(entities218);
//      ...................... Sites ........................
        Entities entities219 = new Entities();
        entities219 = findBean.nameEntities("Sites",em);
        relationships13.setTo(entities219);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities220 = new Cardinalities();
        cardinalities220 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships13.setCardinalities(cardinalities220);
        em.persist(relationships13);
        em.flush();

        Relationships relationships14 = new Relationships();
        relationships14.setOptionality(true);
        relationships14.setIsEmbedded(false);
//      ...................... SitesTypes ........................
        Entities entities221 = new Entities();
        entities221 = findBean.nameEntities("SitesTypes",em);
        relationships14.setFrom(entities221);
//      ...................... SitesTypes ........................
        Entities entities222 = new Entities();
        entities222 = findBean.nameEntities("SitesTypes",em);
        relationships14.setTo(entities222);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities223 = new Cardinalities();
        cardinalities223 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships14.setCardinalities(cardinalities223);
        em.persist(relationships14);
        em.flush();

        Relationships relationships15 = new Relationships();
        relationships15.setOptionality(true);
        relationships15.setIsEmbedded(false);
//      ...................... Series ........................
        Entities entities224 = new Entities();
        entities224 = findBean.nameEntities("Series",em);
        relationships15.setFrom(entities224);
//      ...................... Series ........................
        Entities entities225 = new Entities();
        entities225 = findBean.nameEntities("Series",em);
        relationships15.setTo(entities225);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities226 = new Cardinalities();
        cardinalities226 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships15.setCardinalities(cardinalities226);
        em.persist(relationships15);
        em.flush();

        Relationships relationships16 = new Relationships();
        relationships16.setOptionality(true);
        relationships16.setIsEmbedded(false);
//      ...................... SectionsTypes ........................
        Entities entities227 = new Entities();
        entities227 = findBean.nameEntities("SectionsTypes",em);
        relationships16.setFrom(entities227);
//      ...................... Sections ........................
        Entities entities228 = new Entities();
        entities228 = findBean.nameEntities("Sections",em);
        relationships16.setTo(entities228);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities229 = new Cardinalities();
        cardinalities229 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships16.setCardinalities(cardinalities229);
        em.persist(relationships16);
        em.flush();

        Relationships relationships17 = new Relationships();
        relationships17.setOptionality(true);
        relationships17.setIsEmbedded(false);
//      ...................... ItemsStates ........................
        Entities entities230 = new Entities();
        entities230 = findBean.nameEntities("ItemsStates",em);
        relationships17.setFrom(entities230);
//      ...................... Items ........................
        Entities entities231 = new Entities();
        entities231 = findBean.nameEntities("Items",em);
        relationships17.setTo(entities231);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities232 = new Cardinalities();
        cardinalities232 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships17.setCardinalities(cardinalities232);
        em.persist(relationships17);
        em.flush();

        Relationships relationships18 = new Relationships();
        relationships18.setOptionality(true);
        relationships18.setIsEmbedded(false);
//      ...................... ActivitiesTypes ........................
        Entities entities233 = new Entities();
        entities233 = findBean.nameEntities("ActivitiesTypes",em);
        relationships18.setFrom(entities233);
//      ...................... Activities ........................
        Entities entities234 = new Entities();
        entities234 = findBean.nameEntities("Activities",em);
        relationships18.setTo(entities234);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities235 = new Cardinalities();
        cardinalities235 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships18.setCardinalities(cardinalities235);
        em.persist(relationships18);
        em.flush();

        Relationships relationships19 = new Relationships();
        relationships19.setOptionality(true);
        relationships19.setIsEmbedded(false);
//      ...................... Items ........................
        Entities entities236 = new Entities();
        entities236 = findBean.nameEntities("Items",em);
        relationships19.setFrom(entities236);
//      ...................... Items ........................
        Entities entities237 = new Entities();
        entities237 = findBean.nameEntities("Items",em);
        relationships19.setTo(entities237);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities238 = new Cardinalities();
        cardinalities238 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships19.setCardinalities(cardinalities238);
        em.persist(relationships19);
        em.flush();

        Relationships relationships20 = new Relationships();
        relationships20.setOptionality(true);
        relationships20.setIsEmbedded(false);
//      ...................... PhysicalAreasTypes ........................
        Entities entities239 = new Entities();
        entities239 = findBean.nameEntities("PhysicalAreasTypes",em);
        relationships20.setFrom(entities239);
//      ...................... PhysicalAreas ........................
        Entities entities240 = new Entities();
        entities240 = findBean.nameEntities("PhysicalAreas",em);
        relationships20.setTo(entities240);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities241 = new Cardinalities();
        cardinalities241 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships20.setCardinalities(cardinalities241);
        em.persist(relationships20);
        em.flush();

        Relationships relationships21 = new Relationships();
        relationships21.setOptionality(true);
        relationships21.setIsEmbedded(false);
//      ...................... PersonalType ........................
        Entities entities242 = new Entities();
        entities242 = findBean.nameEntities("PersonalType",em);
        relationships21.setFrom(entities242);
//      ...................... Persons ........................
        Entities entities243 = new Entities();
        entities243 = findBean.nameEntities("Persons",em);
        relationships21.setTo(entities243);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities244 = new Cardinalities();
        cardinalities244 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships21.setCardinalities(cardinalities244);
        em.persist(relationships21);
        em.flush();

        Relationships relationships22 = new Relationships();
        relationships22.setOptionality(true);
        relationships22.setIsEmbedded(false);
//      ...................... Items ........................
        Entities entities245 = new Entities();
        entities245 = findBean.nameEntities("Items",em);
        relationships22.setFrom(entities245);
//      ...................... NetworkPorts ........................
        Entities entities246 = new Entities();
        entities246 = findBean.nameEntities("NetworkPorts",em);
        relationships22.setTo(entities246);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities247 = new Cardinalities();
        cardinalities247 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships22.setCardinalities(cardinalities247);
        em.persist(relationships22);
        em.flush();

        Relationships relationships23 = new Relationships();
        relationships23.setOptionality(true);
        relationships23.setIsEmbedded(false);
//      ...................... PhysicalAreas ........................
        Entities entities248 = new Entities();
        entities248 = findBean.nameEntities("PhysicalAreas",em);
        relationships23.setFrom(entities248);
//      ...................... PhysicalAreas ........................
        Entities entities249 = new Entities();
        entities249 = findBean.nameEntities("PhysicalAreas",em);
        relationships23.setTo(entities249);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities250 = new Cardinalities();
        cardinalities250 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships23.setCardinalities(cardinalities250);
        em.persist(relationships23);
        em.flush();

        Relationships relationships24 = new Relationships();
        relationships24.setOptionality(true);
        relationships24.setIsEmbedded(false);
//      ...................... Calendars ........................
        Entities entities251 = new Entities();
        entities251 = findBean.nameEntities("Calendars",em);
        relationships24.setFrom(entities251);
//      ...................... Activities ........................
        Entities entities252 = new Entities();
        entities252 = findBean.nameEntities("Activities",em);
        relationships24.setTo(entities252);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities253 = new Cardinalities();
        cardinalities253 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships24.setCardinalities(cardinalities253);
        em.persist(relationships24);
        em.flush();

        Relationships relationships25 = new Relationships();
        relationships25.setOptionality(true);
        relationships25.setIsEmbedded(false);
//      ...................... Inventories ........................
        Entities entities254 = new Entities();
        entities254 = findBean.nameEntities("Inventories",em);
        relationships25.setFrom(entities254);
//      ...................... Items ........................
        Entities entities255 = new Entities();
        entities255 = findBean.nameEntities("Items",em);
        relationships25.setTo(entities255);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities256 = new Cardinalities();
        cardinalities256 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships25.setCardinalities(cardinalities256);
        em.persist(relationships25);
        em.flush();

        Relationships relationships26 = new Relationships();
        relationships26.setOptionality(true);
        relationships26.setIsEmbedded(false);
//      ...................... ItemsNames ........................
        Entities entities257 = new Entities();
        entities257 = findBean.nameEntities("ItemsNames",em);
        relationships26.setFrom(entities257);
//      ...................... Items ........................
        Entities entities258 = new Entities();
        entities258 = findBean.nameEntities("Items",em);
        relationships26.setTo(entities258);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities259 = new Cardinalities();
        cardinalities259 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships26.setCardinalities(cardinalities259);
        em.persist(relationships26);
        em.flush();

        Relationships relationships27 = new Relationships();
        relationships27.setOptionality(true);
        relationships27.setIsEmbedded(false);
//      ...................... Companies ........................
        Entities entities260 = new Entities();
        entities260 = findBean.nameEntities("Companies",em);
        relationships27.setFrom(entities260);
//      ...................... Invoices ........................
        Entities entities261 = new Entities();
        entities261 = findBean.nameEntities("Invoices",em);
        relationships27.setTo(entities261);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities262 = new Cardinalities();
        cardinalities262 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships27.setCardinalities(cardinalities262);
        em.persist(relationships27);
        em.flush();

        Relationships relationships28 = new Relationships();
        relationships28.setOptionality(true);
        relationships28.setIsEmbedded(false);
//      ...................... Sections ........................
        Entities entities263 = new Entities();
        entities263 = findBean.nameEntities("Sections",em);
        relationships28.setFrom(entities263);
//      ...................... Tasks ........................
        Entities entities264 = new Entities();
        entities264 = findBean.nameEntities("Tasks",em);
        relationships28.setTo(entities264);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities265 = new Cardinalities();
        cardinalities265 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships28.setCardinalities(cardinalities265);
        em.persist(relationships28);
        em.flush();

        Relationships relationships29 = new Relationships();
        relationships29.setOptionality(true);
        relationships29.setIsEmbedded(false);
//      ...................... DocumentsTypes ........................
        Entities entities266 = new Entities();
        entities266 = findBean.nameEntities("DocumentsTypes",em);
        relationships29.setFrom(entities266);
//      ...................... Series ........................
        Entities entities267 = new Entities();
        entities267 = findBean.nameEntities("Series",em);
        relationships29.setTo(entities267);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities268 = new Cardinalities();
        cardinalities268 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships29.setCardinalities(cardinalities268);
        em.persist(relationships29);
        em.flush();

        Relationships relationships30 = new Relationships();
        relationships30.setOptionality(true);
        relationships30.setIsEmbedded(false);
//      ...................... Items ........................
        Entities entities269 = new Entities();
        entities269 = findBean.nameEntities("Items",em);
        relationships30.setFrom(entities269);
//      ...................... Switches ........................
        Entities entities270 = new Entities();
        entities270 = findBean.nameEntities("Switches",em);
        relationships30.setTo(entities270);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities271 = new Cardinalities();
        cardinalities271 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships30.setCardinalities(cardinalities271);
        em.persist(relationships30);
        em.flush();

        Relationships relationships31 = new Relationships();
        relationships31.setOptionality(true);
        relationships31.setIsEmbedded(false);
//      ...................... Persons ........................
        Entities entities272 = new Entities();
        entities272 = findBean.nameEntities("Persons",em);
        relationships31.setFrom(entities272);
//      ...................... Activities ........................
        Entities entities273 = new Entities();
        entities273 = findBean.nameEntities("Activities",em);
        relationships31.setTo(entities273);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities274 = new Cardinalities();
        cardinalities274 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships31.setCardinalities(cardinalities274);
        em.persist(relationships31);
        em.flush();

        Relationships relationships32 = new Relationships();
        relationships32.setOptionality(true);
        relationships32.setIsEmbedded(false);
//      ...................... Sections ........................
        Entities entities275 = new Entities();
        entities275 = findBean.nameEntities("Sections",em);
        relationships32.setFrom(entities275);
//      ...................... Series ........................
        Entities entities276 = new Entities();
        entities276 = findBean.nameEntities("Series",em);
        relationships32.setTo(entities276);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities277 = new Cardinalities();
        cardinalities277 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships32.setCardinalities(cardinalities277);
        em.persist(relationships32);
        em.flush();

        Relationships relationships33 = new Relationships();
        relationships33.setOptionality(true);
        relationships33.setIsEmbedded(false);
//      ...................... Sections ........................
        Entities entities278 = new Entities();
        entities278 = findBean.nameEntities("Sections",em);
        relationships33.setFrom(entities278);
//      ...................... Activities ........................
        Entities entities279 = new Entities();
        entities279 = findBean.nameEntities("Activities",em);
        relationships33.setTo(entities279);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities280 = new Cardinalities();
        cardinalities280 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships33.setCardinalities(cardinalities280);
        em.persist(relationships33);
        em.flush();

        Relationships relationships34 = new Relationships();
        relationships34.setOptionality(true);
        relationships34.setIsEmbedded(false);
//      ...................... Persons ........................
        Entities entities281 = new Entities();
        entities281 = findBean.nameEntities("Persons",em);
        relationships34.setFrom(entities281);
//      ...................... Sections ........................
        Entities entities282 = new Entities();
        entities282 = findBean.nameEntities("Sections",em);
        relationships34.setTo(entities282);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities283 = new Cardinalities();
        cardinalities283 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships34.setCardinalities(cardinalities283);
        em.persist(relationships34);
        em.flush();

        Relationships relationships35 = new Relationships();
        relationships35.setOptionality(true);
        relationships35.setIsEmbedded(false);
//      ...................... Switches ........................
        Entities entities284 = new Entities();
        entities284 = findBean.nameEntities("Switches",em);
        relationships35.setFrom(entities284);
//      ...................... SwitchesPorts ........................
        Entities entities285 = new Entities();
        entities285 = findBean.nameEntities("SwitchesPorts",em);
        relationships35.setTo(entities285);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities286 = new Cardinalities();
        cardinalities286 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships35.setCardinalities(cardinalities286);
        em.persist(relationships35);
        em.flush();

        Relationships relationships36 = new Relationships();
        relationships36.setOptionality(true);
        relationships36.setIsEmbedded(false);
//      ...................... Persons ........................
        Entities entities287 = new Entities();
        entities287 = findBean.nameEntities("Persons",em);
        relationships36.setFrom(entities287);
//      ...................... Sites ........................
        Entities entities288 = new Entities();
        entities288 = findBean.nameEntities("Sites",em);
        relationships36.setTo(entities288);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities289 = new Cardinalities();
        cardinalities289 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships36.setCardinalities(cardinalities289);
        em.persist(relationships36);
        em.flush();

        Relationships relationships37 = new Relationships();
        relationships37.setOptionality(true);
        relationships37.setIsEmbedded(false);
//      ...................... Sites ........................
        Entities entities290 = new Entities();
        entities290 = findBean.nameEntities("Sites",em);
        relationships37.setFrom(entities290);
//      ...................... IpAddresses ........................
        Entities entities291 = new Entities();
        entities291 = findBean.nameEntities("IpAddresses",em);
        relationships37.setTo(entities291);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities292 = new Cardinalities();
        cardinalities292 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships37.setCardinalities(cardinalities292);
        em.persist(relationships37);
        em.flush();

        Relationships relationships38 = new Relationships();
        relationships38.setOptionality(true);
        relationships38.setIsEmbedded(false);
//      ...................... Sections ........................
        Entities entities293 = new Entities();
        entities293 = findBean.nameEntities("Sections",em);
        relationships38.setFrom(entities293);
//      ...................... Items ........................
        Entities entities294 = new Entities();
        entities294 = findBean.nameEntities("Items",em);
        relationships38.setTo(entities294);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities295 = new Cardinalities();
        cardinalities295 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships38.setCardinalities(cardinalities295);
        em.persist(relationships38);
        em.flush();

        Relationships relationships39 = new Relationships();
        relationships39.setOptionality(true);
        relationships39.setIsEmbedded(false);
//      ...................... TasksTypes ........................
        Entities entities296 = new Entities();
        entities296 = findBean.nameEntities("TasksTypes",em);
        relationships39.setFrom(entities296);
//      ...................... Tasks ........................
        Entities entities297 = new Entities();
        entities297 = findBean.nameEntities("Tasks",em);
        relationships39.setTo(entities297);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities298 = new Cardinalities();
        cardinalities298 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships39.setCardinalities(cardinalities298);
        em.persist(relationships39);
        em.flush();

        Relationships relationships40 = new Relationships();
        relationships40.setOptionality(true);
        relationships40.setIsEmbedded(false);
//      ...................... Brands ........................
        Entities entities299 = new Entities();
        entities299 = findBean.nameEntities("Brands",em);
        relationships40.setFrom(entities299);
//      ...................... ItemsNames ........................
        Entities entities300 = new Entities();
        entities300 = findBean.nameEntities("ItemsNames",em);
        relationships40.setTo(entities300);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities301 = new Cardinalities();
        cardinalities301 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships40.setCardinalities(cardinalities301);
        em.persist(relationships40);
        em.flush();

        Relationships relationships41 = new Relationships();
        relationships41.setOptionality(true);
        relationships41.setIsEmbedded(false);
//      ...................... Sections ........................
        Entities entities302 = new Entities();
        entities302 = findBean.nameEntities("Sections",em);
        relationships41.setFrom(entities302);
//      ...................... Sections ........................
        Entities entities303 = new Entities();
        entities303 = findBean.nameEntities("Sections",em);
        relationships41.setTo(entities303);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities304 = new Cardinalities();
        cardinalities304 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships41.setCardinalities(cardinalities304);
        em.persist(relationships41);
        em.flush();

        Relationships relationships42 = new Relationships();
        relationships42.setOptionality(true);
        relationships42.setIsEmbedded(false);
//      ...................... InventoriesTypes ........................
        Entities entities305 = new Entities();
        entities305 = findBean.nameEntities("InventoriesTypes",em);
        relationships42.setFrom(entities305);
//      ...................... Inventories ........................
        Entities entities306 = new Entities();
        entities306 = findBean.nameEntities("Inventories",em);
        relationships42.setTo(entities306);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities307 = new Cardinalities();
        cardinalities307 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships42.setCardinalities(cardinalities307);
        em.persist(relationships42);
        em.flush();

        Relationships relationships43 = new Relationships();
        relationships43.setOptionality(true);
        relationships43.setIsEmbedded(false);
//      ...................... Companies ........................
        Entities entities308 = new Entities();
        entities308 = findBean.nameEntities("Companies",em);
        relationships43.setFrom(entities308);
//      ...................... Persons ........................
        Entities entities309 = new Entities();
        entities309 = findBean.nameEntities("Persons",em);
        relationships43.setTo(entities309);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities310 = new Cardinalities();
        cardinalities310 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships43.setCardinalities(cardinalities310);
        em.persist(relationships43);
        em.flush();

    } // data()

} // crm
