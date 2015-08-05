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
@Named("coreSetup")
public class coreSetup {

    @PersistenceContext(unitName = "naifgPU-JTA")
    private EntityManager em;

    FindBean findBean = new FindBean();

    private static final Logger log = Logger.getLogger(coreSetup.class.getName());

    public void data() {

//      ---------------------- GroupIds ------------------------

        GroupIds groupIds1 = new GroupIds();
        groupIds1.setGroupId("co.simasoft.models.core.regulations");
        groupIds1.setName("regulations");
        em.persist(groupIds1);
        em.flush();

        GroupIds groupIds2 = new GroupIds();
        groupIds2.setGroupId("co.simasoft.models.core.archival");
        groupIds2.setName("archival");
        em.persist(groupIds2);
        em.flush();

        GroupIds groupIds3 = new GroupIds();
        groupIds3.setGroupId("co.simasoft.models.core.companies");
        groupIds3.setName("companies");
        em.persist(groupIds3);
        em.flush();

        GroupIds groupIds4 = new GroupIds();
        groupIds4.setGroupId("co.simasoft.models.core.sites");
        groupIds4.setName("sites");
        em.persist(groupIds4);
        em.flush();

        GroupIds groupIds5 = new GroupIds();
        groupIds5.setGroupId("co.simasoft.models.core.books");
        groupIds5.setName("books");
        em.persist(groupIds5);
        em.flush();

//      ---------------------- Models ------------------------

        Models models = new Models();
        models.setGroupId("co.simasoft.models.dev.core");
        models.setArtifactId("core");
        models.setVersion("1.0-SNAPSHOT");
        models.setName("core");

        Set<GroupIds> modelsGroupId1 = new HashSet<GroupIds>();

        GroupIds group1 = findBean.groupGroupIds("co.simasoft.models.core.regulations",em);
        modelsGroupId1.add(group1);

        GroupIds group2 = findBean.groupGroupIds("co.simasoft.models.core.archival",em);
        modelsGroupId1.add(group2);

        GroupIds group3 = findBean.groupGroupIds("co.simasoft.models.core.companies",em);
        modelsGroupId1.add(group3);

        GroupIds group4 = findBean.groupGroupIds("co.simasoft.models.core.sites",em);
        modelsGroupId1.add(group4);

        GroupIds group5 = findBean.groupGroupIds("co.simasoft.models.core.books",em);
        modelsGroupId1.add(group5);

        models.setGroupIds(modelsGroupId1);

        em.persist(models);
        em.flush();


//      ---------------------- Developments ------------------------

        Developments dev = new Developments();
        dev.setGroupId("co.simasoft");
        dev.setArtifactId("core");
        dev.setVersion("1.0-SNAPSHOT");
        dev.setName("core");
        Set<Models> models1 = new HashSet<Models>();
        Models model1 = findBean.artifactIdModels("core",em);
        models1.add(model1);
        dev.setModels(models1);
        em.persist(dev);
        em.flush();

//      ---------------------- Entities ------------------------

        Entities entities1 = new Entities();
        entities1.setName("RegulationsText");
//      ...................... co.simasoft.models.core.regulations ........................
        GroupIds groupId1 = new GroupIds();
        groupId1 = findBean.groupIdGroupIds("co.simasoft.models.core.regulations",em);
        entities1.setGroupIds(groupId1);
        em.persist(entities1);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes2 = new Attributes();
        attributes2.setName("code");
        attributes2.setNullable(true);
        attributes2.setSingle(false);
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
        attributes3.setNullable(true);
        attributes3.setSingle(false);
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
        attributes4.setNullable(true);
        attributes4.setSingle(false);
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

//      ---------------------- Attributes ------------------------

        Attributes attributes6 = new Attributes();
        attributes6.setName("name");
        attributes6.setNullable(true);
        attributes6.setSingle(false);
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
        attributes7.setNullable(true);
        attributes7.setSingle(false);
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

//      ---------------------- Attributes ------------------------

        Attributes attributes9 = new Attributes();
        attributes9.setName("name");
        attributes9.setNullable(true);
        attributes9.setSingle(false);
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

//      ---------------------- Attributes ------------------------

        Attributes attributes11 = new Attributes();
        attributes11.setName("name");
        attributes11.setNullable(true);
        attributes11.setSingle(false);
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

//      ---------------------- Attributes ------------------------

        Attributes attributes13 = new Attributes();
        attributes13.setName("name");
        attributes13.setNullable(true);
        attributes13.setSingle(false);
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
        attributes14.setNullable(true);
        attributes14.setSingle(false);
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
        attributes15.setNullable(true);
        attributes15.setSingle(false);
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
        attributes16.setNullable(true);
        attributes16.setSingle(false);
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
        attributes17.setNullable(true);
        attributes17.setSingle(false);
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
        entities18.setName("Funds");
//      ...................... co.simasoft.models.core.archival ........................
        GroupIds groupId30 = new GroupIds();
        groupId30 = findBean.groupIdGroupIds("co.simasoft.models.core.archival",em);
        entities18.setGroupIds(groupId30);
        em.persist(entities18);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes19 = new Attributes();
        attributes19.setName("code");
        attributes19.setNullable(true);
        attributes19.setSingle(false);
//      ...................... Funds ........................
        Entities entity31 = new Entities();
        entity31 = findBean.nameEntities("Funds",em);
        attributes19.setEntities(entity31);
//      ...................... String ........................
        AttributesTypes attributesTypes32 = new AttributesTypes();
        attributesTypes32 = findBean.nameAttributesTypes("String",em);
        attributes19.setAttributesTypes(attributesTypes32);
        em.persist(attributes19);
        em.flush();

        Attributes attributes20 = new Attributes();
        attributes20.setName("name");
        attributes20.setNullable(true);
        attributes20.setSingle(false);
//      ...................... Funds ........................
        Entities entity33 = new Entities();
        entity33 = findBean.nameEntities("Funds",em);
        attributes20.setEntities(entity33);
//      ...................... String ........................
        AttributesTypes attributesTypes34 = new AttributesTypes();
        attributesTypes34 = findBean.nameAttributesTypes("String",em);
        attributes20.setAttributesTypes(attributesTypes34);
        em.persist(attributes20);
        em.flush();

        Entities entities21 = new Entities();
        entities21.setName("DocumentsTypes");
//      ...................... co.simasoft.models.core.archival ........................
        GroupIds groupId35 = new GroupIds();
        groupId35 = findBean.groupIdGroupIds("co.simasoft.models.core.archival",em);
        entities21.setGroupIds(groupId35);
        em.persist(entities21);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes22 = new Attributes();
        attributes22.setName("name");
        attributes22.setNullable(true);
        attributes22.setSingle(false);
//      ...................... DocumentsTypes ........................
        Entities entity36 = new Entities();
        entity36 = findBean.nameEntities("DocumentsTypes",em);
        attributes22.setEntities(entity36);
//      ...................... String ........................
        AttributesTypes attributesTypes37 = new AttributesTypes();
        attributesTypes37 = findBean.nameAttributesTypes("String",em);
        attributes22.setAttributesTypes(attributesTypes37);
        em.persist(attributes22);
        em.flush();

        Entities entities23 = new Entities();
        entities23.setName("Series");
//      ...................... co.simasoft.models.core.archival ........................
        GroupIds groupId38 = new GroupIds();
        groupId38 = findBean.groupIdGroupIds("co.simasoft.models.core.archival",em);
        entities23.setGroupIds(groupId38);
        em.persist(entities23);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes24 = new Attributes();
        attributes24.setName("code");
        attributes24.setNullable(true);
        attributes24.setSingle(false);
//      ...................... Series ........................
        Entities entity39 = new Entities();
        entity39 = findBean.nameEntities("Series",em);
        attributes24.setEntities(entity39);
//      ...................... String ........................
        AttributesTypes attributesTypes40 = new AttributesTypes();
        attributesTypes40 = findBean.nameAttributesTypes("String",em);
        attributes24.setAttributesTypes(attributesTypes40);
        em.persist(attributes24);
        em.flush();

        Attributes attributes25 = new Attributes();
        attributes25.setName("name");
        attributes25.setNullable(true);
        attributes25.setSingle(false);
//      ...................... Series ........................
        Entities entity41 = new Entities();
        entity41 = findBean.nameEntities("Series",em);
        attributes25.setEntities(entity41);
//      ...................... String ........................
        AttributesTypes attributesTypes42 = new AttributesTypes();
        attributesTypes42 = findBean.nameAttributesTypes("String",em);
        attributes25.setAttributesTypes(attributesTypes42);
        em.persist(attributes25);
        em.flush();

        Attributes attributes26 = new Attributes();
        attributes26.setName("located");
        attributes26.setNullable(true);
        attributes26.setSingle(false);
//      ...................... Series ........................
        Entities entity43 = new Entities();
        entity43 = findBean.nameEntities("Series",em);
        attributes26.setEntities(entity43);
//      ...................... String ........................
        AttributesTypes attributesTypes44 = new AttributesTypes();
        attributesTypes44 = findBean.nameAttributesTypes("String",em);
        attributes26.setAttributesTypes(attributesTypes44);
        em.persist(attributes26);
        em.flush();

        Attributes attributes27 = new Attributes();
        attributes27.setName("link");
        attributes27.setNullable(true);
        attributes27.setSingle(false);
//      ...................... Series ........................
        Entities entity45 = new Entities();
        entity45 = findBean.nameEntities("Series",em);
        attributes27.setEntities(entity45);
//      ...................... String ........................
        AttributesTypes attributesTypes46 = new AttributesTypes();
        attributesTypes46 = findBean.nameAttributesTypes("String",em);
        attributes27.setAttributesTypes(attributesTypes46);
        em.persist(attributes27);
        em.flush();

        Entities entities28 = new Entities();
        entities28.setName("SectionsTypes");
//      ...................... co.simasoft.models.core.archival ........................
        GroupIds groupId47 = new GroupIds();
        groupId47 = findBean.groupIdGroupIds("co.simasoft.models.core.archival",em);
        entities28.setGroupIds(groupId47);
        em.persist(entities28);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes29 = new Attributes();
        attributes29.setName("name");
        attributes29.setNullable(true);
        attributes29.setSingle(false);
//      ...................... SectionsTypes ........................
        Entities entity48 = new Entities();
        entity48 = findBean.nameEntities("SectionsTypes",em);
        attributes29.setEntities(entity48);
//      ...................... String ........................
        AttributesTypes attributesTypes49 = new AttributesTypes();
        attributesTypes49 = findBean.nameAttributesTypes("String",em);
        attributes29.setAttributesTypes(attributesTypes49);
        em.persist(attributes29);
        em.flush();

        Entities entities30 = new Entities();
        entities30.setName("DocumentalsSupports");
//      ...................... co.simasoft.models.core.archival ........................
        GroupIds groupId50 = new GroupIds();
        groupId50 = findBean.groupIdGroupIds("co.simasoft.models.core.archival",em);
        entities30.setGroupIds(groupId50);
        em.persist(entities30);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes31 = new Attributes();
        attributes31.setName("code");
        attributes31.setNullable(true);
        attributes31.setSingle(false);
//      ...................... DocumentalsSupports ........................
        Entities entity51 = new Entities();
        entity51 = findBean.nameEntities("DocumentalsSupports",em);
        attributes31.setEntities(entity51);
//      ...................... String ........................
        AttributesTypes attributesTypes52 = new AttributesTypes();
        attributesTypes52 = findBean.nameAttributesTypes("String",em);
        attributes31.setAttributesTypes(attributesTypes52);
        em.persist(attributes31);
        em.flush();

        Attributes attributes32 = new Attributes();
        attributes32.setName("name");
        attributes32.setNullable(true);
        attributes32.setSingle(false);
//      ...................... DocumentalsSupports ........................
        Entities entity53 = new Entities();
        entity53 = findBean.nameEntities("DocumentalsSupports",em);
        attributes32.setEntities(entity53);
//      ...................... String ........................
        AttributesTypes attributesTypes54 = new AttributesTypes();
        attributesTypes54 = findBean.nameAttributesTypes("String",em);
        attributes32.setAttributesTypes(attributesTypes54);
        em.persist(attributes32);
        em.flush();

        Entities entities33 = new Entities();
        entities33.setName("FrequentlyQuery");
//      ...................... co.simasoft.models.core.archival ........................
        GroupIds groupId55 = new GroupIds();
        groupId55 = findBean.groupIdGroupIds("co.simasoft.models.core.archival",em);
        entities33.setGroupIds(groupId55);
        em.persist(entities33);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes34 = new Attributes();
        attributes34.setName("name");
        attributes34.setNullable(true);
        attributes34.setSingle(false);
//      ...................... FrequentlyQuery ........................
        Entities entity56 = new Entities();
        entity56 = findBean.nameEntities("FrequentlyQuery",em);
        attributes34.setEntities(entity56);
//      ...................... Integer ........................
        AttributesTypes attributesTypes57 = new AttributesTypes();
        attributesTypes57 = findBean.nameAttributesTypes("Integer",em);
        attributes34.setAttributesTypes(attributesTypes57);
        em.persist(attributes34);
        em.flush();

        Entities entities35 = new Entities();
        entities35.setName("Sections");
//      ...................... co.simasoft.models.core.archival ........................
        GroupIds groupId58 = new GroupIds();
        groupId58 = findBean.groupIdGroupIds("co.simasoft.models.core.archival",em);
        entities35.setGroupIds(groupId58);
        em.persist(entities35);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes36 = new Attributes();
        attributes36.setName("code");
        attributes36.setNullable(true);
        attributes36.setSingle(false);
//      ...................... Sections ........................
        Entities entity59 = new Entities();
        entity59 = findBean.nameEntities("Sections",em);
        attributes36.setEntities(entity59);
//      ...................... String ........................
        AttributesTypes attributesTypes60 = new AttributesTypes();
        attributesTypes60 = findBean.nameAttributesTypes("String",em);
        attributes36.setAttributesTypes(attributesTypes60);
        em.persist(attributes36);
        em.flush();

        Attributes attributes37 = new Attributes();
        attributes37.setName("name");
        attributes37.setNullable(true);
        attributes37.setSingle(false);
//      ...................... Sections ........................
        Entities entity61 = new Entities();
        entity61 = findBean.nameEntities("Sections",em);
        attributes37.setEntities(entity61);
//      ...................... String ........................
        AttributesTypes attributesTypes62 = new AttributesTypes();
        attributesTypes62 = findBean.nameAttributesTypes("String",em);
        attributes37.setAttributesTypes(attributesTypes62);
        em.persist(attributes37);
        em.flush();

        Attributes attributes38 = new Attributes();
        attributes38.setName("email");
        attributes38.setNullable(true);
        attributes38.setSingle(false);
//      ...................... Sections ........................
        Entities entity63 = new Entities();
        entity63 = findBean.nameEntities("Sections",em);
        attributes38.setEntities(entity63);
//      ...................... String ........................
        AttributesTypes attributesTypes64 = new AttributesTypes();
        attributesTypes64 = findBean.nameAttributesTypes("String",em);
        attributes38.setAttributesTypes(attributesTypes64);
        em.persist(attributes38);
        em.flush();

        Entities entities39 = new Entities();
        entities39.setName("DocumentalsInventory");
//      ...................... co.simasoft.models.core.archival ........................
        GroupIds groupId65 = new GroupIds();
        groupId65 = findBean.groupIdGroupIds("co.simasoft.models.core.archival",em);
        entities39.setGroupIds(groupId65);
        em.persist(entities39);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes40 = new Attributes();
        attributes40.setName("deliveryDate");
        attributes40.setNullable(true);
        attributes40.setSingle(false);
//      ...................... DocumentalsInventory ........................
        Entities entity66 = new Entities();
        entity66 = findBean.nameEntities("DocumentalsInventory",em);
        attributes40.setEntities(entity66);
//      ...................... Date ........................
        AttributesTypes attributesTypes67 = new AttributesTypes();
        attributesTypes67 = findBean.nameAttributesTypes("Date",em);
        attributes40.setAttributesTypes(attributesTypes67);
        em.persist(attributes40);
        em.flush();

        Attributes attributes41 = new Attributes();
        attributes41.setName("transferNumber");
        attributes41.setNullable(true);
        attributes41.setSingle(false);
//      ...................... DocumentalsInventory ........................
        Entities entity68 = new Entities();
        entity68 = findBean.nameEntities("DocumentalsInventory",em);
        attributes41.setEntities(entity68);
//      ...................... Integer ........................
        AttributesTypes attributesTypes69 = new AttributesTypes();
        attributesTypes69 = findBean.nameAttributesTypes("Integer",em);
        attributes41.setAttributesTypes(attributesTypes69);
        em.persist(attributes41);
        em.flush();

        Attributes attributes42 = new Attributes();
        attributes42.setName("startDate");
        attributes42.setNullable(true);
        attributes42.setSingle(false);
//      ...................... DocumentalsInventory ........................
        Entities entity70 = new Entities();
        entity70 = findBean.nameEntities("DocumentalsInventory",em);
        attributes42.setEntities(entity70);
//      ...................... Date ........................
        AttributesTypes attributesTypes71 = new AttributesTypes();
        attributesTypes71 = findBean.nameAttributesTypes("Date",em);
        attributes42.setAttributesTypes(attributesTypes71);
        em.persist(attributes42);
        em.flush();

        Attributes attributes43 = new Attributes();
        attributes43.setName("finalDate");
        attributes43.setNullable(true);
        attributes43.setSingle(false);
//      ...................... DocumentalsInventory ........................
        Entities entity72 = new Entities();
        entity72 = findBean.nameEntities("DocumentalsInventory",em);
        attributes43.setEntities(entity72);
//      ...................... Date ........................
        AttributesTypes attributesTypes73 = new AttributesTypes();
        attributesTypes73 = findBean.nameAttributesTypes("Date",em);
        attributes43.setAttributesTypes(attributesTypes73);
        em.persist(attributes43);
        em.flush();

        Attributes attributes44 = new Attributes();
        attributes44.setName("folios");
        attributes44.setNullable(true);
        attributes44.setSingle(false);
//      ...................... DocumentalsInventory ........................
        Entities entity74 = new Entities();
        entity74 = findBean.nameEntities("DocumentalsInventory",em);
        attributes44.setEntities(entity74);
//      ...................... Integer ........................
        AttributesTypes attributesTypes75 = new AttributesTypes();
        attributesTypes75 = findBean.nameAttributesTypes("Integer",em);
        attributes44.setAttributesTypes(attributesTypes75);
        em.persist(attributes44);
        em.flush();

        Attributes attributes45 = new Attributes();
        attributes45.setName("quantity");
        attributes45.setNullable(true);
        attributes45.setSingle(false);
//      ...................... DocumentalsInventory ........................
        Entities entity76 = new Entities();
        entity76 = findBean.nameEntities("DocumentalsInventory",em);
        attributes45.setEntities(entity76);
//      ...................... Integer ........................
        AttributesTypes attributesTypes77 = new AttributesTypes();
        attributesTypes77 = findBean.nameAttributesTypes("Integer",em);
        attributes45.setAttributesTypes(attributesTypes77);
        em.persist(attributes45);
        em.flush();

        Attributes attributes46 = new Attributes();
        attributes46.setName("debugDate");
        attributes46.setNullable(true);
        attributes46.setSingle(false);
//      ...................... DocumentalsInventory ........................
        Entities entity78 = new Entities();
        entity78 = findBean.nameEntities("DocumentalsInventory",em);
        attributes46.setEntities(entity78);
//      ...................... Date ........................
        AttributesTypes attributesTypes79 = new AttributesTypes();
        attributesTypes79 = findBean.nameAttributesTypes("Date",em);
        attributes46.setAttributesTypes(attributesTypes79);
        em.persist(attributes46);
        em.flush();

        Attributes attributes47 = new Attributes();
        attributes47.setName("finalDisposition");
        attributes47.setNullable(true);
        attributes47.setSingle(false);
//      ...................... DocumentalsInventory ........................
        Entities entity80 = new Entities();
        entity80 = findBean.nameEntities("DocumentalsInventory",em);
        attributes47.setEntities(entity80);
//      ...................... String ........................
        AttributesTypes attributesTypes81 = new AttributesTypes();
        attributesTypes81 = findBean.nameAttributesTypes("String",em);
        attributes47.setAttributesTypes(attributesTypes81);
        em.persist(attributes47);
        em.flush();

        Entities entities48 = new Entities();
        entities48.setName("Inventoryfinality");
//      ...................... co.simasoft.models.core.archival ........................
        GroupIds groupId82 = new GroupIds();
        groupId82 = findBean.groupIdGroupIds("co.simasoft.models.core.archival",em);
        entities48.setGroupIds(groupId82);
        em.persist(entities48);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes49 = new Attributes();
        attributes49.setName("name");
        attributes49.setNullable(true);
        attributes49.setSingle(false);
//      ...................... Inventoryfinality ........................
        Entities entity83 = new Entities();
        entity83 = findBean.nameEntities("Inventoryfinality",em);
        attributes49.setEntities(entity83);
//      ...................... String ........................
        AttributesTypes attributesTypes84 = new AttributesTypes();
        attributesTypes84 = findBean.nameAttributesTypes("String",em);
        attributes49.setAttributesTypes(attributesTypes84);
        em.persist(attributes49);
        em.flush();

        Entities entities50 = new Entities();
        entities50.setName("FinalDisposition");
//      ...................... co.simasoft.models.core.archival ........................
        GroupIds groupId85 = new GroupIds();
        groupId85 = findBean.groupIdGroupIds("co.simasoft.models.core.archival",em);
        entities50.setGroupIds(groupId85);
        em.persist(entities50);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes51 = new Attributes();
        attributes51.setName("name");
        attributes51.setNullable(true);
        attributes51.setSingle(false);
//      ...................... FinalDisposition ........................
        Entities entity86 = new Entities();
        entity86 = findBean.nameEntities("FinalDisposition",em);
        attributes51.setEntities(entity86);
//      ...................... String ........................
        AttributesTypes attributesTypes87 = new AttributesTypes();
        attributesTypes87 = findBean.nameAttributesTypes("String",em);
        attributes51.setAttributesTypes(attributesTypes87);
        em.persist(attributes51);
        em.flush();

        Entities entities52 = new Entities();
        entities52.setName("FundsLife");
//      ...................... co.simasoft.models.core.archival ........................
        GroupIds groupId88 = new GroupIds();
        groupId88 = findBean.groupIdGroupIds("co.simasoft.models.core.archival",em);
        entities52.setGroupIds(groupId88);
        em.persist(entities52);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes53 = new Attributes();
        attributes53.setName("name");
        attributes53.setNullable(true);
        attributes53.setSingle(false);
//      ...................... FundsLife ........................
        Entities entity89 = new Entities();
        entity89 = findBean.nameEntities("FundsLife",em);
        attributes53.setEntities(entity89);
//      ...................... String ........................
        AttributesTypes attributesTypes90 = new AttributesTypes();
        attributesTypes90 = findBean.nameAttributesTypes("String",em);
        attributes53.setAttributesTypes(attributesTypes90);
        em.persist(attributes53);
        em.flush();

        Attributes attributes54 = new Attributes();
        attributes54.setName("isOpen");
        attributes54.setNullable(true);
        attributes54.setSingle(false);
//      ...................... FundsLife ........................
        Entities entity91 = new Entities();
        entity91 = findBean.nameEntities("FundsLife",em);
        attributes54.setEntities(entity91);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes92 = new AttributesTypes();
        attributesTypes92 = findBean.nameAttributesTypes("Boolean",em);
        attributes54.setAttributesTypes(attributesTypes92);
        em.persist(attributes54);
        em.flush();

        Entities entities55 = new Entities();
        entities55.setName("DocumentaryRetention");
//      ...................... co.simasoft.models.core.archival ........................
        GroupIds groupId93 = new GroupIds();
        groupId93 = findBean.groupIdGroupIds("co.simasoft.models.core.archival",em);
        entities55.setGroupIds(groupId93);
        em.persist(entities55);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes56 = new Attributes();
        attributes56.setName("year");
        attributes56.setNullable(true);
        attributes56.setSingle(false);
//      ...................... DocumentaryRetention ........................
        Entities entity94 = new Entities();
        entity94 = findBean.nameEntities("DocumentaryRetention",em);
        attributes56.setEntities(entity94);
//      ...................... Integer ........................
        AttributesTypes attributesTypes95 = new AttributesTypes();
        attributesTypes95 = findBean.nameAttributesTypes("Integer",em);
        attributes56.setAttributesTypes(attributesTypes95);
        em.persist(attributes56);
        em.flush();

        Attributes attributes57 = new Attributes();
        attributes57.setName("name");
        attributes57.setNullable(true);
        attributes57.setSingle(false);
//      ...................... DocumentaryRetention ........................
        Entities entity96 = new Entities();
        entity96 = findBean.nameEntities("DocumentaryRetention",em);
        attributes57.setEntities(entity96);
//      ...................... String ........................
        AttributesTypes attributesTypes97 = new AttributesTypes();
        attributesTypes97 = findBean.nameAttributesTypes("String",em);
        attributes57.setAttributesTypes(attributesTypes97);
        em.persist(attributes57);
        em.flush();

        Entities entities58 = new Entities();
        entities58.setName("ConservationUnits");
//      ...................... co.simasoft.models.core.archival ........................
        GroupIds groupId98 = new GroupIds();
        groupId98 = findBean.groupIdGroupIds("co.simasoft.models.core.archival",em);
        entities58.setGroupIds(groupId98);
        em.persist(entities58);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes59 = new Attributes();
        attributes59.setName("code");
        attributes59.setNullable(true);
        attributes59.setSingle(false);
//      ...................... ConservationUnits ........................
        Entities entity99 = new Entities();
        entity99 = findBean.nameEntities("ConservationUnits",em);
        attributes59.setEntities(entity99);
//      ...................... String ........................
        AttributesTypes attributesTypes100 = new AttributesTypes();
        attributesTypes100 = findBean.nameAttributesTypes("String",em);
        attributes59.setAttributesTypes(attributesTypes100);
        em.persist(attributes59);
        em.flush();

        Attributes attributes60 = new Attributes();
        attributes60.setName("name");
        attributes60.setNullable(true);
        attributes60.setSingle(false);
//      ...................... ConservationUnits ........................
        Entities entity101 = new Entities();
        entity101 = findBean.nameEntities("ConservationUnits",em);
        attributes60.setEntities(entity101);
//      ...................... String ........................
        AttributesTypes attributesTypes102 = new AttributesTypes();
        attributesTypes102 = findBean.nameAttributesTypes("String",em);
        attributes60.setAttributesTypes(attributesTypes102);
        em.persist(attributes60);
        em.flush();

        Entities entities61 = new Entities();
        entities61.setName("DocumentalsUnits");
//      ...................... co.simasoft.models.core.archival ........................
        GroupIds groupId103 = new GroupIds();
        groupId103 = findBean.groupIdGroupIds("co.simasoft.models.core.archival",em);
        entities61.setGroupIds(groupId103);
        em.persist(entities61);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes62 = new Attributes();
        attributes62.setName("name");
        attributes62.setNullable(true);
        attributes62.setSingle(false);
//      ...................... DocumentalsUnits ........................
        Entities entity104 = new Entities();
        entity104 = findBean.nameEntities("DocumentalsUnits",em);
        attributes62.setEntities(entity104);
//      ...................... String ........................
        AttributesTypes attributesTypes105 = new AttributesTypes();
        attributesTypes105 = findBean.nameAttributesTypes("String",em);
        attributes62.setAttributesTypes(attributesTypes105);
        em.persist(attributes62);
        em.flush();

        Attributes attributes63 = new Attributes();
        attributes63.setName("creationDate");
        attributes63.setNullable(true);
        attributes63.setSingle(false);
//      ...................... DocumentalsUnits ........................
        Entities entity106 = new Entities();
        entity106 = findBean.nameEntities("DocumentalsUnits",em);
        attributes63.setEntities(entity106);
//      ...................... Date ........................
        AttributesTypes attributesTypes107 = new AttributesTypes();
        attributesTypes107 = findBean.nameAttributesTypes("Date",em);
        attributes63.setAttributesTypes(attributesTypes107);
        em.persist(attributes63);
        em.flush();

        Entities entities64 = new Entities();
        entities64.setName("Trd");
//      ...................... co.simasoft.models.core.archival ........................
        GroupIds groupId108 = new GroupIds();
        groupId108 = findBean.groupIdGroupIds("co.simasoft.models.core.archival",em);
        entities64.setGroupIds(groupId108);
        em.persist(entities64);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes65 = new Attributes();
        attributes65.setName("procedures");
        attributes65.setNullable(true);
        attributes65.setSingle(false);
//      ...................... Trd ........................
        Entities entity109 = new Entities();
        entity109 = findBean.nameEntities("Trd",em);
        attributes65.setEntities(entity109);
//      ...................... String ........................
        AttributesTypes attributesTypes110 = new AttributesTypes();
        attributesTypes110 = findBean.nameAttributesTypes("String",em);
        attributes65.setAttributesTypes(attributesTypes110);
        em.persist(attributes65);
        em.flush();

        Entities entities66 = new Entities();
        entities66.setName("OriginalOrder");
//      ...................... co.simasoft.models.core.archival ........................
        GroupIds groupId111 = new GroupIds();
        groupId111 = findBean.groupIdGroupIds("co.simasoft.models.core.archival",em);
        entities66.setGroupIds(groupId111);
        em.persist(entities66);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes67 = new Attributes();
        attributes67.setName("entryDate");
        attributes67.setNullable(true);
        attributes67.setSingle(false);
//      ...................... OriginalOrder ........................
        Entities entity112 = new Entities();
        entity112 = findBean.nameEntities("OriginalOrder",em);
        attributes67.setEntities(entity112);
//      ...................... Date ........................
        AttributesTypes attributesTypes113 = new AttributesTypes();
        attributesTypes113 = findBean.nameAttributesTypes("Date",em);
        attributes67.setAttributesTypes(attributesTypes113);
        em.persist(attributes67);
        em.flush();

        Attributes attributes68 = new Attributes();
        attributes68.setName("startDate");
        attributes68.setNullable(true);
        attributes68.setSingle(false);
//      ...................... OriginalOrder ........................
        Entities entity114 = new Entities();
        entity114 = findBean.nameEntities("OriginalOrder",em);
        attributes68.setEntities(entity114);
//      ...................... Date ........................
        AttributesTypes attributesTypes115 = new AttributesTypes();
        attributesTypes115 = findBean.nameAttributesTypes("Date",em);
        attributes68.setAttributesTypes(attributesTypes115);
        em.persist(attributes68);
        em.flush();

        Attributes attributes69 = new Attributes();
        attributes69.setName("finalDate");
        attributes69.setNullable(true);
        attributes69.setSingle(false);
//      ...................... OriginalOrder ........................
        Entities entity116 = new Entities();
        entity116 = findBean.nameEntities("OriginalOrder",em);
        attributes69.setEntities(entity116);
//      ...................... Date ........................
        AttributesTypes attributesTypes117 = new AttributesTypes();
        attributesTypes117 = findBean.nameAttributesTypes("Date",em);
        attributes69.setAttributesTypes(attributesTypes117);
        em.persist(attributes69);
        em.flush();

        Attributes attributes70 = new Attributes();
        attributes70.setName("folios");
        attributes70.setNullable(true);
        attributes70.setSingle(false);
//      ...................... OriginalOrder ........................
        Entities entity118 = new Entities();
        entity118 = findBean.nameEntities("OriginalOrder",em);
        attributes70.setEntities(entity118);
//      ...................... Integer ........................
        AttributesTypes attributesTypes119 = new AttributesTypes();
        attributesTypes119 = findBean.nameAttributesTypes("Integer",em);
        attributes70.setAttributesTypes(attributesTypes119);
        em.persist(attributes70);
        em.flush();

        Attributes attributes71 = new Attributes();
        attributes71.setName("located");
        attributes71.setNullable(true);
        attributes71.setSingle(false);
//      ...................... OriginalOrder ........................
        Entities entity120 = new Entities();
        entity120 = findBean.nameEntities("OriginalOrder",em);
        attributes71.setEntities(entity120);
//      ...................... String ........................
        AttributesTypes attributesTypes121 = new AttributesTypes();
        attributesTypes121 = findBean.nameAttributesTypes("String",em);
        attributes71.setAttributesTypes(attributesTypes121);
        em.persist(attributes71);
        em.flush();

//      ---------------------- Entities ------------------------

//      ---------------------- Entities ------------------------

        Entities entities72 = new Entities();
        entities72.setName("Sites");
//      ...................... co.simasoft.models.core.sites ........................
        GroupIds groupId122 = new GroupIds();
        groupId122 = findBean.groupIdGroupIds("co.simasoft.models.core.sites",em);
        entities72.setGroupIds(groupId122);
        em.persist(entities72);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes73 = new Attributes();
        attributes73.setName("title");
        attributes73.setNullable(true);
        attributes73.setSingle(false);
//      ...................... Sites ........................
        Entities entity123 = new Entities();
        entity123 = findBean.nameEntities("Sites",em);
        attributes73.setEntities(entity123);
//      ...................... String ........................
        AttributesTypes attributesTypes124 = new AttributesTypes();
        attributesTypes124 = findBean.nameAttributesTypes("String",em);
        attributes73.setAttributesTypes(attributesTypes124);
        em.persist(attributes73);
        em.flush();

        Attributes attributes74 = new Attributes();
        attributes74.setName("link");
        attributes74.setNullable(false);
        attributes74.setSingle(true);
//      ...................... Sites ........................
        Entities entity125 = new Entities();
        entity125 = findBean.nameEntities("Sites",em);
        attributes74.setEntities(entity125);
//      ...................... String ........................
        AttributesTypes attributesTypes126 = new AttributesTypes();
        attributesTypes126 = findBean.nameAttributesTypes("String",em);
        attributes74.setAttributesTypes(attributesTypes126);
        em.persist(attributes74);
        em.flush();

        Attributes attributes75 = new Attributes();
        attributes75.setName("abc");
        attributes75.setNullable(true);
        attributes75.setSingle(false);
//      ...................... Sites ........................
        Entities entity127 = new Entities();
        entity127 = findBean.nameEntities("Sites",em);
        attributes75.setEntities(entity127);
//      ...................... String ........................
        AttributesTypes attributesTypes128 = new AttributesTypes();
        attributesTypes128 = findBean.nameAttributesTypes("String",em);
        attributes75.setAttributesTypes(attributesTypes128);
        em.persist(attributes75);
        em.flush();

        Entities entities76 = new Entities();
        entities76.setName("SitesTypes");
//      ...................... co.simasoft.models.core.sites ........................
        GroupIds groupId129 = new GroupIds();
        groupId129 = findBean.groupIdGroupIds("co.simasoft.models.core.sites",em);
        entities76.setGroupIds(groupId129);
        em.persist(entities76);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes77 = new Attributes();
        attributes77.setName("name");
        attributes77.setNullable(true);
        attributes77.setSingle(false);
//      ...................... SitesTypes ........................
        Entities entity130 = new Entities();
        entity130 = findBean.nameEntities("SitesTypes",em);
        attributes77.setEntities(entity130);
//      ...................... String ........................
        AttributesTypes attributesTypes131 = new AttributesTypes();
        attributesTypes131 = findBean.nameAttributesTypes("String",em);
        attributes77.setAttributesTypes(attributesTypes131);
        em.persist(attributes77);
        em.flush();

//      ---------------------- Entities ------------------------

//      ---------------------- Entities ------------------------

        Entities entities78 = new Entities();
        entities78.setName("BooksTypes");
//      ...................... co.simasoft.models.core.books ........................
        GroupIds groupId132 = new GroupIds();
        groupId132 = findBean.groupIdGroupIds("co.simasoft.models.core.books",em);
        entities78.setGroupIds(groupId132);
        em.persist(entities78);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes79 = new Attributes();
        attributes79.setName("name");
        attributes79.setNullable(true);
        attributes79.setSingle(false);
//      ...................... BooksTypes ........................
        Entities entity133 = new Entities();
        entity133 = findBean.nameEntities("BooksTypes",em);
        attributes79.setEntities(entity133);
//      ...................... String ........................
        AttributesTypes attributesTypes134 = new AttributesTypes();
        attributesTypes134 = findBean.nameAttributesTypes("String",em);
        attributes79.setAttributesTypes(attributesTypes134);
        em.persist(attributes79);
        em.flush();

        Entities entities80 = new Entities();
        entities80.setName("Chapters");
//      ...................... co.simasoft.models.core.books ........................
        GroupIds groupId135 = new GroupIds();
        groupId135 = findBean.groupIdGroupIds("co.simasoft.models.core.books",em);
        entities80.setGroupIds(groupId135);
        em.persist(entities80);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes81 = new Attributes();
        attributes81.setName("code");
        attributes81.setNullable(true);
        attributes81.setSingle(false);
//      ...................... Chapters ........................
        Entities entity136 = new Entities();
        entity136 = findBean.nameEntities("Chapters",em);
        attributes81.setEntities(entity136);
//      ...................... String ........................
        AttributesTypes attributesTypes137 = new AttributesTypes();
        attributesTypes137 = findBean.nameAttributesTypes("String",em);
        attributes81.setAttributesTypes(attributesTypes137);
        em.persist(attributes81);
        em.flush();

        Attributes attributes82 = new Attributes();
        attributes82.setName("name");
        attributes82.setNullable(true);
        attributes82.setSingle(false);
//      ...................... Chapters ........................
        Entities entity138 = new Entities();
        entity138 = findBean.nameEntities("Chapters",em);
        attributes82.setEntities(entity138);
//      ...................... String ........................
        AttributesTypes attributesTypes139 = new AttributesTypes();
        attributesTypes139 = findBean.nameAttributesTypes("String",em);
        attributes82.setAttributesTypes(attributesTypes139);
        em.persist(attributes82);
        em.flush();

        Attributes attributes83 = new Attributes();
        attributes83.setName("content");
        attributes83.setNullable(false);
        attributes83.setSingle(false);
//      ...................... Chapters ........................
        Entities entity140 = new Entities();
        entity140 = findBean.nameEntities("Chapters",em);
        attributes83.setEntities(entity140);
//      ...................... String ........................
        AttributesTypes attributesTypes141 = new AttributesTypes();
        attributesTypes141 = findBean.nameAttributesTypes("String",em);
        attributes83.setAttributesTypes(attributesTypes141);
        em.persist(attributes83);
        em.flush();

        Entities entities84 = new Entities();
        entities84.setName("Books");
//      ...................... co.simasoft.models.core.books ........................
        GroupIds groupId142 = new GroupIds();
        groupId142 = findBean.groupIdGroupIds("co.simasoft.models.core.books",em);
        entities84.setGroupIds(groupId142);
        em.persist(entities84);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes85 = new Attributes();
        attributes85.setName("code");
        attributes85.setNullable(true);
        attributes85.setSingle(false);
//      ...................... Books ........................
        Entities entity143 = new Entities();
        entity143 = findBean.nameEntities("Books",em);
        attributes85.setEntities(entity143);
//      ...................... String ........................
        AttributesTypes attributesTypes144 = new AttributesTypes();
        attributesTypes144 = findBean.nameAttributesTypes("String",em);
        attributes85.setAttributesTypes(attributesTypes144);
        em.persist(attributes85);
        em.flush();

        Attributes attributes86 = new Attributes();
        attributes86.setName("name");
        attributes86.setNullable(false);
        attributes86.setSingle(true);
//      ...................... Books ........................
        Entities entity145 = new Entities();
        entity145 = findBean.nameEntities("Books",em);
        attributes86.setEntities(entity145);
//      ...................... String ........................
        AttributesTypes attributesTypes146 = new AttributesTypes();
        attributesTypes146 = findBean.nameAttributesTypes("String",em);
        attributes86.setAttributesTypes(attributesTypes146);
        em.persist(attributes86);
        em.flush();

        Attributes attributes87 = new Attributes();
        attributes87.setName("content");
        attributes87.setNullable(false);
        attributes87.setSingle(false);
//      ...................... Books ........................
        Entities entity147 = new Entities();
        entity147 = findBean.nameEntities("Books",em);
        attributes87.setEntities(entity147);
//      ...................... String ........................
        AttributesTypes attributesTypes148 = new AttributesTypes();
        attributesTypes148 = findBean.nameAttributesTypes("String",em);
        attributes87.setAttributesTypes(attributesTypes148);
        em.persist(attributes87);
        em.flush();

//      ---------------------- Entities ------------------------

//      ---------------------- Entities ------------------------

//      ---------------------- Entities ------------------------

//      ---------------------- Entities ------------------------

//      ---------------------- Relationships ------------------------

/*
*/
/*
. RegulationsTypes . 1..* Regulations rolA: rolB:

. Regulations . 1..* RegulationsText rolA: rolB:

. RegulationsText . 1..* RegulationsText rolA: rolB:

. RegulationsTypes . 1..* RegulationsTypes rolA: rolB:

*/
        Relationships relationships1 = new Relationships();
        relationships1.setOptionality(true);
        relationships1.setIsEmbedded(false);
//      ...................... RegulationsTypes ........................
        Entities entities149 = new Entities();
        entities149 = findBean.nameEntities("RegulationsTypes",em);
        relationships1.setFrom(entities149);
//      ...................... Regulations ........................
        Entities entities150 = new Entities();
        entities150 = findBean.nameEntities("Regulations",em);
        relationships1.setTo(entities150);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities151 = new Cardinalities();
        cardinalities151 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships1.setCardinalities(cardinalities151);
        em.persist(relationships1);
        em.flush();

        Relationships relationships2 = new Relationships();
        relationships2.setOptionality(true);
        relationships2.setIsEmbedded(false);
//      ...................... Regulations ........................
        Entities entities152 = new Entities();
        entities152 = findBean.nameEntities("Regulations",em);
        relationships2.setFrom(entities152);
//      ...................... RegulationsText ........................
        Entities entities153 = new Entities();
        entities153 = findBean.nameEntities("RegulationsText",em);
        relationships2.setTo(entities153);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities154 = new Cardinalities();
        cardinalities154 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships2.setCardinalities(cardinalities154);
        em.persist(relationships2);
        em.flush();

        Relationships relationships3 = new Relationships();
        relationships3.setOptionality(true);
        relationships3.setIsEmbedded(false);
//      ...................... RegulationsText ........................
        Entities entities155 = new Entities();
        entities155 = findBean.nameEntities("RegulationsText",em);
        relationships3.setFrom(entities155);
//      ...................... RegulationsText ........................
        Entities entities156 = new Entities();
        entities156 = findBean.nameEntities("RegulationsText",em);
        relationships3.setTo(entities156);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities157 = new Cardinalities();
        cardinalities157 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships3.setCardinalities(cardinalities157);
        em.persist(relationships3);
        em.flush();

        Relationships relationships4 = new Relationships();
        relationships4.setOptionality(true);
        relationships4.setIsEmbedded(false);
//      ...................... RegulationsTypes ........................
        Entities entities158 = new Entities();
        entities158 = findBean.nameEntities("RegulationsTypes",em);
        relationships4.setFrom(entities158);
//      ...................... RegulationsTypes ........................
        Entities entities159 = new Entities();
        entities159 = findBean.nameEntities("RegulationsTypes",em);
        relationships4.setTo(entities159);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities160 = new Cardinalities();
        cardinalities160 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships4.setCardinalities(cardinalities160);
        em.persist(relationships4);
        em.flush();

/*
. SectionsTypes . 1..* Sections rolA: rolB:

. Sections . 1..* Sections rolA: rolB:

. Series . *..* FinalDisposition rolA:from rolB: OK

. FrequentlyQuery . 1..* DocumentalsUnits rolA: rolB:

. DocumentalsSupports . 1..* OriginalOrder rolA: rolB:

. Trd . 1..* Series rolA: rolB:

. Series . 1..* DocumentalsUnits rolA: rolB:

. DocumentsTypes . 1..* OriginalOrder rolA: rolB:

. Funds . 1..* Sections rolA: rolB:

. DocumentaryRetention . 1..* Trd rolA: rolB:

. DocumentaryRetention . 1..* Trd rolA: rolB:

. DocumentalsUnits . 1..* DocumentalsInventory rolA: rolB:

. Sections . 1..* Series rolA: rolB:

. Series . 1..* Series rolA: rolB:

. DocumentsTypes . 1..* Series rolA: rolB:

. ConservationUnits . 1..* DocumentalsUnits rolA: rolB:

. Inventoryfinality . 1..* DocumentalsInventory rolA: rolB:

. FundsLife . 1..* Funds rolA: rolB:

. DocumentalsUnits . 1..* OriginalOrder rolA: rolB:

*/
        Relationships relationships5 = new Relationships();
        relationships5.setOptionality(true);
        relationships5.setIsEmbedded(false);
//      ...................... SectionsTypes ........................
        Entities entities161 = new Entities();
        entities161 = findBean.nameEntities("SectionsTypes",em);
        relationships5.setFrom(entities161);
//      ...................... Sections ........................
        Entities entities162 = new Entities();
        entities162 = findBean.nameEntities("Sections",em);
        relationships5.setTo(entities162);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities163 = new Cardinalities();
        cardinalities163 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships5.setCardinalities(cardinalities163);
        em.persist(relationships5);
        em.flush();

        Relationships relationships6 = new Relationships();
        relationships6.setOptionality(true);
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
        relationships7.setOptionality(true);
        relationships7.setIsEmbedded(false);
//      ...................... Series ........................
        Entities entities167 = new Entities();
        entities167 = findBean.nameEntities("Series",em);
        relationships7.setFrom(entities167);
//      ...................... FinalDisposition ........................
        Entities entities168 = new Entities();
        entities168 = findBean.nameEntities("FinalDisposition",em);
        relationships7.setTo(entities168);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities169 = new Cardinalities();
        cardinalities169 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships7.setCardinalities(cardinalities169);
        em.persist(relationships7);
        em.flush();

        Relationships relationships8 = new Relationships();
        relationships8.setOptionality(true);
        relationships8.setIsEmbedded(false);
//      ...................... FrequentlyQuery ........................
        Entities entities170 = new Entities();
        entities170 = findBean.nameEntities("FrequentlyQuery",em);
        relationships8.setFrom(entities170);
//      ...................... DocumentalsUnits ........................
        Entities entities171 = new Entities();
        entities171 = findBean.nameEntities("DocumentalsUnits",em);
        relationships8.setTo(entities171);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities172 = new Cardinalities();
        cardinalities172 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships8.setCardinalities(cardinalities172);
        em.persist(relationships8);
        em.flush();

        Relationships relationships9 = new Relationships();
        relationships9.setOptionality(true);
        relationships9.setIsEmbedded(false);
//      ...................... DocumentalsSupports ........................
        Entities entities173 = new Entities();
        entities173 = findBean.nameEntities("DocumentalsSupports",em);
        relationships9.setFrom(entities173);
//      ...................... OriginalOrder ........................
        Entities entities174 = new Entities();
        entities174 = findBean.nameEntities("OriginalOrder",em);
        relationships9.setTo(entities174);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities175 = new Cardinalities();
        cardinalities175 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships9.setCardinalities(cardinalities175);
        em.persist(relationships9);
        em.flush();

        Relationships relationships10 = new Relationships();
        relationships10.setOptionality(true);
        relationships10.setIsEmbedded(false);
//      ...................... Trd ........................
        Entities entities176 = new Entities();
        entities176 = findBean.nameEntities("Trd",em);
        relationships10.setFrom(entities176);
//      ...................... Series ........................
        Entities entities177 = new Entities();
        entities177 = findBean.nameEntities("Series",em);
        relationships10.setTo(entities177);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities178 = new Cardinalities();
        cardinalities178 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships10.setCardinalities(cardinalities178);
        em.persist(relationships10);
        em.flush();

        Relationships relationships11 = new Relationships();
        relationships11.setOptionality(true);
        relationships11.setIsEmbedded(false);
//      ...................... Series ........................
        Entities entities179 = new Entities();
        entities179 = findBean.nameEntities("Series",em);
        relationships11.setFrom(entities179);
//      ...................... DocumentalsUnits ........................
        Entities entities180 = new Entities();
        entities180 = findBean.nameEntities("DocumentalsUnits",em);
        relationships11.setTo(entities180);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities181 = new Cardinalities();
        cardinalities181 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships11.setCardinalities(cardinalities181);
        em.persist(relationships11);
        em.flush();

        Relationships relationships12 = new Relationships();
        relationships12.setOptionality(true);
        relationships12.setIsEmbedded(false);
//      ...................... DocumentsTypes ........................
        Entities entities182 = new Entities();
        entities182 = findBean.nameEntities("DocumentsTypes",em);
        relationships12.setFrom(entities182);
//      ...................... OriginalOrder ........................
        Entities entities183 = new Entities();
        entities183 = findBean.nameEntities("OriginalOrder",em);
        relationships12.setTo(entities183);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities184 = new Cardinalities();
        cardinalities184 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships12.setCardinalities(cardinalities184);
        em.persist(relationships12);
        em.flush();

        Relationships relationships13 = new Relationships();
        relationships13.setOptionality(true);
        relationships13.setIsEmbedded(false);
//      ...................... Funds ........................
        Entities entities185 = new Entities();
        entities185 = findBean.nameEntities("Funds",em);
        relationships13.setFrom(entities185);
//      ...................... Sections ........................
        Entities entities186 = new Entities();
        entities186 = findBean.nameEntities("Sections",em);
        relationships13.setTo(entities186);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities187 = new Cardinalities();
        cardinalities187 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships13.setCardinalities(cardinalities187);
        em.persist(relationships13);
        em.flush();

        Relationships relationships14 = new Relationships();
        relationships14.setOptionality(true);
        relationships14.setIsEmbedded(false);
        relationships14.setName("gestion");
//      ...................... DocumentaryRetention ........................
        Entities entities188 = new Entities();
        entities188 = findBean.nameEntities("DocumentaryRetention",em);
        relationships14.setFrom(entities188);
//      ...................... Trd ........................
        Entities entities189 = new Entities();
        entities189 = findBean.nameEntities("Trd",em);
        relationships14.setTo(entities189);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities190 = new Cardinalities();
        cardinalities190 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships14.setCardinalities(cardinalities190);
        em.persist(relationships14);
        em.flush();

        Relationships relationships15 = new Relationships();
        relationships15.setOptionality(true);
        relationships15.setIsEmbedded(false);
        relationships15.setName("central");
//      ...................... DocumentaryRetention ........................
        Entities entities191 = new Entities();
        entities191 = findBean.nameEntities("DocumentaryRetention",em);
        relationships15.setFrom(entities191);
//      ...................... Trd ........................
        Entities entities192 = new Entities();
        entities192 = findBean.nameEntities("Trd",em);
        relationships15.setTo(entities192);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities193 = new Cardinalities();
        cardinalities193 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships15.setCardinalities(cardinalities193);
        em.persist(relationships15);
        em.flush();

        Relationships relationships16 = new Relationships();
        relationships16.setOptionality(true);
        relationships16.setIsEmbedded(false);
//      ...................... DocumentalsUnits ........................
        Entities entities194 = new Entities();
        entities194 = findBean.nameEntities("DocumentalsUnits",em);
        relationships16.setFrom(entities194);
//      ...................... DocumentalsInventory ........................
        Entities entities195 = new Entities();
        entities195 = findBean.nameEntities("DocumentalsInventory",em);
        relationships16.setTo(entities195);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities196 = new Cardinalities();
        cardinalities196 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships16.setCardinalities(cardinalities196);
        em.persist(relationships16);
        em.flush();

        Relationships relationships17 = new Relationships();
        relationships17.setOptionality(true);
        relationships17.setIsEmbedded(false);
//      ...................... Sections ........................
        Entities entities197 = new Entities();
        entities197 = findBean.nameEntities("Sections",em);
        relationships17.setFrom(entities197);
//      ...................... Series ........................
        Entities entities198 = new Entities();
        entities198 = findBean.nameEntities("Series",em);
        relationships17.setTo(entities198);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities199 = new Cardinalities();
        cardinalities199 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships17.setCardinalities(cardinalities199);
        em.persist(relationships17);
        em.flush();

        Relationships relationships18 = new Relationships();
        relationships18.setOptionality(true);
        relationships18.setIsEmbedded(false);
//      ...................... Series ........................
        Entities entities200 = new Entities();
        entities200 = findBean.nameEntities("Series",em);
        relationships18.setFrom(entities200);
//      ...................... Series ........................
        Entities entities201 = new Entities();
        entities201 = findBean.nameEntities("Series",em);
        relationships18.setTo(entities201);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities202 = new Cardinalities();
        cardinalities202 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships18.setCardinalities(cardinalities202);
        em.persist(relationships18);
        em.flush();

        Relationships relationships19 = new Relationships();
        relationships19.setOptionality(true);
        relationships19.setIsEmbedded(false);
//      ...................... DocumentsTypes ........................
        Entities entities203 = new Entities();
        entities203 = findBean.nameEntities("DocumentsTypes",em);
        relationships19.setFrom(entities203);
//      ...................... Series ........................
        Entities entities204 = new Entities();
        entities204 = findBean.nameEntities("Series",em);
        relationships19.setTo(entities204);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities205 = new Cardinalities();
        cardinalities205 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships19.setCardinalities(cardinalities205);
        em.persist(relationships19);
        em.flush();

        Relationships relationships20 = new Relationships();
        relationships20.setOptionality(true);
        relationships20.setIsEmbedded(false);
//      ...................... ConservationUnits ........................
        Entities entities206 = new Entities();
        entities206 = findBean.nameEntities("ConservationUnits",em);
        relationships20.setFrom(entities206);
//      ...................... DocumentalsUnits ........................
        Entities entities207 = new Entities();
        entities207 = findBean.nameEntities("DocumentalsUnits",em);
        relationships20.setTo(entities207);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities208 = new Cardinalities();
        cardinalities208 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships20.setCardinalities(cardinalities208);
        em.persist(relationships20);
        em.flush();

        Relationships relationships21 = new Relationships();
        relationships21.setOptionality(true);
        relationships21.setIsEmbedded(false);
//      ...................... Inventoryfinality ........................
        Entities entities209 = new Entities();
        entities209 = findBean.nameEntities("Inventoryfinality",em);
        relationships21.setFrom(entities209);
//      ...................... DocumentalsInventory ........................
        Entities entities210 = new Entities();
        entities210 = findBean.nameEntities("DocumentalsInventory",em);
        relationships21.setTo(entities210);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities211 = new Cardinalities();
        cardinalities211 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships21.setCardinalities(cardinalities211);
        em.persist(relationships21);
        em.flush();

        Relationships relationships22 = new Relationships();
        relationships22.setOptionality(true);
        relationships22.setIsEmbedded(false);
//      ...................... FundsLife ........................
        Entities entities212 = new Entities();
        entities212 = findBean.nameEntities("FundsLife",em);
        relationships22.setFrom(entities212);
//      ...................... Funds ........................
        Entities entities213 = new Entities();
        entities213 = findBean.nameEntities("Funds",em);
        relationships22.setTo(entities213);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities214 = new Cardinalities();
        cardinalities214 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships22.setCardinalities(cardinalities214);
        em.persist(relationships22);
        em.flush();

        Relationships relationships23 = new Relationships();
        relationships23.setOptionality(true);
        relationships23.setIsEmbedded(false);
//      ...................... DocumentalsUnits ........................
        Entities entities215 = new Entities();
        entities215 = findBean.nameEntities("DocumentalsUnits",em);
        relationships23.setFrom(entities215);
//      ...................... OriginalOrder ........................
        Entities entities216 = new Entities();
        entities216 = findBean.nameEntities("OriginalOrder",em);
        relationships23.setTo(entities216);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities217 = new Cardinalities();
        cardinalities217 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships23.setCardinalities(cardinalities217);
        em.persist(relationships23);
        em.flush();

/*
. Companies . 1..* Companies rolA: rolB:

. Companies . 1..* Brands rolA: rolB:

*/
        Relationships relationships24 = new Relationships();
        relationships24.setOptionality(true);
        relationships24.setIsEmbedded(false);
//      ...................... Companies ........................
        Entities entities218 = new Entities();
        entities218 = findBean.nameEntities("Companies",em);
        relationships24.setFrom(entities218);
//      ...................... Companies ........................
        Entities entities219 = new Entities();
        entities219 = findBean.nameEntities("Companies",em);
        relationships24.setTo(entities219);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities220 = new Cardinalities();
        cardinalities220 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships24.setCardinalities(cardinalities220);
        em.persist(relationships24);
        em.flush();

        Relationships relationships25 = new Relationships();
        relationships25.setOptionality(true);
        relationships25.setIsEmbedded(false);
//      ...................... Companies ........................
        Entities entities221 = new Entities();
        entities221 = findBean.nameEntities("Companies",em);
        relationships25.setFrom(entities221);
//      ...................... Brands ........................
        Entities entities222 = new Entities();
        entities222 = findBean.nameEntities("Brands",em);
        relationships25.setTo(entities222);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities223 = new Cardinalities();
        cardinalities223 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships25.setCardinalities(cardinalities223);
        em.persist(relationships25);
        em.flush();

/*
*/
/*
*/
/*
. Series . 1..* RegulationsText rolA: rolB:

. Companies . 1..* Funds rolA: rolB:

. OriginalOrder . 1..* Sites rolA: rolB:

. Series . 1..* Chapters rolA: rolB:

. Series . 1..* Sites rolA: rolB:

*/
        Relationships relationships26 = new Relationships();
        relationships26.setOptionality(true);
        relationships26.setIsEmbedded(false);
//      ...................... Series ........................
        Entities entities224 = new Entities();
        entities224 = findBean.nameEntities("Series",em);
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
        relationships27.setOptionality(true);
        relationships27.setIsEmbedded(false);
//      ...................... Companies ........................
        Entities entities227 = new Entities();
        entities227 = findBean.nameEntities("Companies",em);
        relationships27.setFrom(entities227);
//      ...................... Funds ........................
        Entities entities228 = new Entities();
        entities228 = findBean.nameEntities("Funds",em);
        relationships27.setTo(entities228);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities229 = new Cardinalities();
        cardinalities229 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships27.setCardinalities(cardinalities229);
        em.persist(relationships27);
        em.flush();

        Relationships relationships28 = new Relationships();
        relationships28.setOptionality(true);
        relationships28.setIsEmbedded(false);
//      ...................... OriginalOrder ........................
        Entities entities230 = new Entities();
        entities230 = findBean.nameEntities("OriginalOrder",em);
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

        Relationships relationships29 = new Relationships();
        relationships29.setOptionality(true);
        relationships29.setIsEmbedded(false);
//      ...................... Series ........................
        Entities entities233 = new Entities();
        entities233 = findBean.nameEntities("Series",em);
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
        relationships30.setOptionality(true);
        relationships30.setIsEmbedded(false);
//      ...................... Series ........................
        Entities entities236 = new Entities();
        entities236 = findBean.nameEntities("Series",em);
        relationships30.setFrom(entities236);
//      ...................... Sites ........................
        Entities entities237 = new Entities();
        entities237 = findBean.nameEntities("Sites",em);
        relationships30.setTo(entities237);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities238 = new Cardinalities();
        cardinalities238 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships30.setCardinalities(cardinalities238);
        em.persist(relationships30);
        em.flush();

/*
*/
/*
. Books . *..* Sites rolA:from rolB: OK

. Chapters . 1..* RegulationsText rolA:from rolB: OK

. Chapters . *..* Sites rolA:from rolB: OK

. BooksTypes . *..* Sites rolA:from rolB: OK

*/
        Relationships relationships31 = new Relationships();
        relationships31.setOptionality(true);
        relationships31.setIsEmbedded(false);
//      ...................... Books ........................
        Entities entities239 = new Entities();
        entities239 = findBean.nameEntities("Books",em);
        relationships31.setFrom(entities239);
//      ...................... Sites ........................
        Entities entities240 = new Entities();
        entities240 = findBean.nameEntities("Sites",em);
        relationships31.setTo(entities240);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities241 = new Cardinalities();
        cardinalities241 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships31.setCardinalities(cardinalities241);
        em.persist(relationships31);
        em.flush();

        Relationships relationships32 = new Relationships();
        relationships32.setOptionality(true);
        relationships32.setIsEmbedded(false);
//      ...................... Chapters ........................
        Entities entities242 = new Entities();
        entities242 = findBean.nameEntities("Chapters",em);
        relationships32.setFrom(entities242);
//      ...................... RegulationsText ........................
        Entities entities243 = new Entities();
        entities243 = findBean.nameEntities("RegulationsText",em);
        relationships32.setTo(entities243);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities244 = new Cardinalities();
        cardinalities244 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships32.setCardinalities(cardinalities244);
        em.persist(relationships32);
        em.flush();

        Relationships relationships33 = new Relationships();
        relationships33.setOptionality(true);
        relationships33.setIsEmbedded(false);
//      ...................... Chapters ........................
        Entities entities245 = new Entities();
        entities245 = findBean.nameEntities("Chapters",em);
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
        relationships34.setOptionality(true);
        relationships34.setIsEmbedded(false);
//      ...................... BooksTypes ........................
        Entities entities248 = new Entities();
        entities248 = findBean.nameEntities("BooksTypes",em);
        relationships34.setFrom(entities248);
//      ...................... Sites ........................
        Entities entities249 = new Entities();
        entities249 = findBean.nameEntities("Sites",em);
        relationships34.setTo(entities249);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities250 = new Cardinalities();
        cardinalities250 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships34.setCardinalities(cardinalities250);
        em.persist(relationships34);
        em.flush();

/*
*/
/*
. Books . 1..* Chapters rolA: rolB:

. BooksTypes . 1..* Books rolA: rolB:

. Chapters . 1..* Chapters rolA: rolB:

. BooksTypes . 1..* BooksTypes rolA: rolB:

*/
        Relationships relationships35 = new Relationships();
        relationships35.setOptionality(true);
        relationships35.setIsEmbedded(false);
//      ...................... Books ........................
        Entities entities251 = new Entities();
        entities251 = findBean.nameEntities("Books",em);
        relationships35.setFrom(entities251);
//      ...................... Chapters ........................
        Entities entities252 = new Entities();
        entities252 = findBean.nameEntities("Chapters",em);
        relationships35.setTo(entities252);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities253 = new Cardinalities();
        cardinalities253 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships35.setCardinalities(cardinalities253);
        em.persist(relationships35);
        em.flush();

        Relationships relationships36 = new Relationships();
        relationships36.setOptionality(true);
        relationships36.setIsEmbedded(false);
//      ...................... BooksTypes ........................
        Entities entities254 = new Entities();
        entities254 = findBean.nameEntities("BooksTypes",em);
        relationships36.setFrom(entities254);
//      ...................... Books ........................
        Entities entities255 = new Entities();
        entities255 = findBean.nameEntities("Books",em);
        relationships36.setTo(entities255);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities256 = new Cardinalities();
        cardinalities256 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships36.setCardinalities(cardinalities256);
        em.persist(relationships36);
        em.flush();

        Relationships relationships37 = new Relationships();
        relationships37.setOptionality(true);
        relationships37.setIsEmbedded(false);
//      ...................... Chapters ........................
        Entities entities257 = new Entities();
        entities257 = findBean.nameEntities("Chapters",em);
        relationships37.setFrom(entities257);
//      ...................... Chapters ........................
        Entities entities258 = new Entities();
        entities258 = findBean.nameEntities("Chapters",em);
        relationships37.setTo(entities258);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities259 = new Cardinalities();
        cardinalities259 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships37.setCardinalities(cardinalities259);
        em.persist(relationships37);
        em.flush();

        Relationships relationships38 = new Relationships();
        relationships38.setOptionality(true);
        relationships38.setIsEmbedded(false);
//      ...................... BooksTypes ........................
        Entities entities260 = new Entities();
        entities260 = findBean.nameEntities("BooksTypes",em);
        relationships38.setFrom(entities260);
//      ...................... BooksTypes ........................
        Entities entities261 = new Entities();
        entities261 = findBean.nameEntities("BooksTypes",em);
        relationships38.setTo(entities261);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities262 = new Cardinalities();
        cardinalities262 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships38.setCardinalities(cardinalities262);
        em.persist(relationships38);
        em.flush();

/*
. SitesTypes . 1..* SitesTypes rolA: rolB:

. SitesTypes . *..* Sites rolA:from rolB: OK

*/
        Relationships relationships39 = new Relationships();
        relationships39.setOptionality(true);
        relationships39.setIsEmbedded(false);
//      ...................... SitesTypes ........................
        Entities entities263 = new Entities();
        entities263 = findBean.nameEntities("SitesTypes",em);
        relationships39.setFrom(entities263);
//      ...................... SitesTypes ........................
        Entities entities264 = new Entities();
        entities264 = findBean.nameEntities("SitesTypes",em);
        relationships39.setTo(entities264);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities265 = new Cardinalities();
        cardinalities265 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships39.setCardinalities(cardinalities265);
        em.persist(relationships39);
        em.flush();

        Relationships relationships40 = new Relationships();
        relationships40.setOptionality(true);
        relationships40.setIsEmbedded(false);
//      ...................... SitesTypes ........................
        Entities entities266 = new Entities();
        entities266 = findBean.nameEntities("SitesTypes",em);
        relationships40.setFrom(entities266);
//      ...................... Sites ........................
        Entities entities267 = new Entities();
        entities267 = findBean.nameEntities("Sites",em);
        relationships40.setTo(entities267);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities268 = new Cardinalities();
        cardinalities268 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships40.setCardinalities(cardinalities268);
        em.persist(relationships40);
        em.flush();

/*
. Brands . 1..* RegulationsText rolA: rolB:

. Companies . 1..* RegulationsText rolA: rolB:

. Brands . 1..* Sites rolA: rolB:

. Companies . 1..* Sites rolA: rolB:

*/
        Relationships relationships41 = new Relationships();
        relationships41.setOptionality(true);
        relationships41.setIsEmbedded(false);
//      ...................... Brands ........................
        Entities entities269 = new Entities();
        entities269 = findBean.nameEntities("Brands",em);
        relationships41.setFrom(entities269);
//      ...................... RegulationsText ........................
        Entities entities270 = new Entities();
        entities270 = findBean.nameEntities("RegulationsText",em);
        relationships41.setTo(entities270);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities271 = new Cardinalities();
        cardinalities271 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships41.setCardinalities(cardinalities271);
        em.persist(relationships41);
        em.flush();

        Relationships relationships42 = new Relationships();
        relationships42.setOptionality(true);
        relationships42.setIsEmbedded(false);
//      ...................... Companies ........................
        Entities entities272 = new Entities();
        entities272 = findBean.nameEntities("Companies",em);
        relationships42.setFrom(entities272);
//      ...................... RegulationsText ........................
        Entities entities273 = new Entities();
        entities273 = findBean.nameEntities("RegulationsText",em);
        relationships42.setTo(entities273);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities274 = new Cardinalities();
        cardinalities274 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships42.setCardinalities(cardinalities274);
        em.persist(relationships42);
        em.flush();

        Relationships relationships43 = new Relationships();
        relationships43.setOptionality(true);
        relationships43.setIsEmbedded(false);
//      ...................... Brands ........................
        Entities entities275 = new Entities();
        entities275 = findBean.nameEntities("Brands",em);
        relationships43.setFrom(entities275);
//      ...................... Sites ........................
        Entities entities276 = new Entities();
        entities276 = findBean.nameEntities("Sites",em);
        relationships43.setTo(entities276);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities277 = new Cardinalities();
        cardinalities277 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships43.setCardinalities(cardinalities277);
        em.persist(relationships43);
        em.flush();

        Relationships relationships44 = new Relationships();
        relationships44.setOptionality(true);
        relationships44.setIsEmbedded(false);
//      ...................... Companies ........................
        Entities entities278 = new Entities();
        entities278 = findBean.nameEntities("Companies",em);
        relationships44.setFrom(entities278);
//      ...................... Sites ........................
        Entities entities279 = new Entities();
        entities279 = findBean.nameEntities("Sites",em);
        relationships44.setTo(entities279);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities280 = new Cardinalities();
        cardinalities280 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships44.setCardinalities(cardinalities280);
        em.persist(relationships44);
        em.flush();

/*
. Regulations . 1..* Sites rolA: rolB:

*/
        Relationships relationships45 = new Relationships();
        relationships45.setOptionality(true);
        relationships45.setIsEmbedded(false);
//      ...................... Regulations ........................
        Entities entities281 = new Entities();
        entities281 = findBean.nameEntities("Regulations",em);
        relationships45.setFrom(entities281);
//      ...................... Sites ........................
        Entities entities282 = new Entities();
        entities282 = findBean.nameEntities("Sites",em);
        relationships45.setTo(entities282);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities283 = new Cardinalities();
        cardinalities283 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships45.setCardinalities(cardinalities283);
        em.persist(relationships45);
        em.flush();

    } // data()

} // core
