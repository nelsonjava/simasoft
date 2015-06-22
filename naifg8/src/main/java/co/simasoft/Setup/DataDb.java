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
@Named("DataDb")
public class DataDb {

    @PersistenceContext(unitName = "naifg8PU-JTA")
    private EntityManager em;

    FindBean findBean = new FindBean();

    private static final Logger log = Logger.getLogger(DataDb.class.getName());

    public void data() {

//      ---------------------- SystemsModels ------------------------

        SystemsModels systemsModels1 = new SystemsModels();
        systemsModels1.setName("NAIF");
        em.persist(systemsModels1);
        em.flush();

//      ---------------------- DomainModels ------------------------

        DomainModels domainModels1 = new DomainModels();
        domainModels1.setGroupId("co.simasoft");
        domainModels1.setArtifactId("naifg8");
        domainModels1.setVersion("1.0.0-SNAPSHOT");
//      ...................... NAIF........................
        SystemsModels systemModel1 = new SystemsModels();
        systemModel1 = findBean.nameSystemsModels("NAIF",em);
        domainModels1.setSystemsModels(systemModel1);
        em.persist(domainModels1);
        em.flush();

        DomainModels domainModels2 = new DomainModels();
        domainModels2.setGroupId("co.simasoft");
        domainModels2.setArtifactId("favorites");
        domainModels2.setVersion("1.0.0-SNAPSHOT");
//      ...................... NAIF........................
        SystemsModels systemModel2 = new SystemsModels();
        systemModel2 = findBean.nameSystemsModels("NAIF",em);
        domainModels2.setSystemsModels(systemModel2);
        em.persist(domainModels2);
        em.flush();

//      ---------------------- GroupIds ------------------------

        GroupIds groupIds1 = new GroupIds();
        groupIds1.setGroupId("co.simasoft.models.naif.domainmodels");
//      ...................... naifg8 ........................
        DomainModels domainModel3 = new DomainModels();
        domainModel3 = findBean.artifactIdDomainModels("naifg8",em);
        groupIds1.setDomainModels(domainModel3);
        em.persist(groupIds1);
        em.flush();

        GroupIds groupIds2 = new GroupIds();
        groupIds2.setGroupId("co.simasoft.models.naif.items");
//      ...................... favorites ........................
        DomainModels domainModel4 = new DomainModels();
        domainModel4 = findBean.artifactIdDomainModels("favorites",em);
        groupIds2.setDomainModels(domainModel4);
        em.persist(groupIds2);
        em.flush();

//      ---------------------- Entities ------------------------

        Entities entities1 = new Entities();
        entities1.setName("Relationships");
//      ...................... co.simasoft.models.naif.domainmodels ........................
        GroupIds groupIds5 = new GroupIds();
        groupIds5 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels",em);
        entities1.setGroupIds(groupIds5);
        em.persist(entities1);
        em.flush();

        Entities entities2 = new Entities();
        entities2.setName("Entities");
//      ...................... co.simasoft.models.naif.domainmodels ........................
        GroupIds groupIds6 = new GroupIds();
        groupIds6 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels",em);
        entities2.setGroupIds(groupIds6);
        em.persist(entities2);
        em.flush();

        Entities entities3 = new Entities();
        entities3.setName("Attributes");
//      ...................... co.simasoft.models.naif.domainmodels ........................
        GroupIds groupIds7 = new GroupIds();
        groupIds7 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels",em);
        entities3.setGroupIds(groupIds7);
        em.persist(entities3);
        em.flush();

        Entities entities4 = new Entities();
        entities4.setName("Cardinalities");
//      ...................... co.simasoft.models.naif.domainmodels ........................
        GroupIds groupIds8 = new GroupIds();
        groupIds8 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels",em);
        entities4.setGroupIds(groupIds8);
        em.persist(entities4);
        em.flush();

        Entities entities5 = new Entities();
        entities5.setName("GroupIds");
//      ...................... co.simasoft.models.naif.domainmodels ........................
        GroupIds groupIds9 = new GroupIds();
        groupIds9 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels",em);
        entities5.setGroupIds(groupIds9);
        em.persist(entities5);
        em.flush();

        Entities entities6 = new Entities();
        entities6.setName("AttributesProperties");
//      ...................... co.simasoft.models.naif.domainmodels ........................
        GroupIds groupIds10 = new GroupIds();
        groupIds10 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels",em);
        entities6.setGroupIds(groupIds10);
        em.persist(entities6);
        em.flush();

        Entities entities7 = new Entities();
        entities7.setName("FilesModels");
//      ...................... co.simasoft.models.naif.domainmodels ........................
        GroupIds groupIds11 = new GroupIds();
        groupIds11 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels",em);
        entities7.setGroupIds(groupIds11);
        em.persist(entities7);
        em.flush();

        Entities entities8 = new Entities();
        entities8.setName("Links");
//      ...................... co.simasoft.models.naif.domainmodels ........................
        GroupIds groupIds12 = new GroupIds();
        groupIds12 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels",em);
        entities8.setGroupIds(groupIds12);
        em.persist(entities8);
        em.flush();

        Entities entities9 = new Entities();
        entities9.setName("LinksTypes");
//      ...................... co.simasoft.models.naif.domainmodels ........................
        GroupIds groupIds13 = new GroupIds();
        groupIds13 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels",em);
        entities9.setGroupIds(groupIds13);
        em.persist(entities9);
        em.flush();

        Entities entities10 = new Entities();
        entities10.setName("NameQueries");
//      ...................... co.simasoft.models.naif.domainmodels ........................
        GroupIds groupIds14 = new GroupIds();
        groupIds14 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels",em);
        entities10.setGroupIds(groupIds14);
        em.persist(entities10);
        em.flush();

        Entities entities11 = new Entities();
        entities11.setName("AttributesTypes");
//      ...................... co.simasoft.models.naif.domainmodels ........................
        GroupIds groupIds15 = new GroupIds();
        groupIds15 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels",em);
        entities11.setGroupIds(groupIds15);
        em.persist(entities11);
        em.flush();

        Entities entities12 = new Entities();
        entities12.setName("DomainModels");
//      ...................... co.simasoft.models.naif.domainmodels ........................
        GroupIds groupIds16 = new GroupIds();
        groupIds16 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels",em);
        entities12.setGroupIds(groupIds16);
        em.persist(entities12);
        em.flush();

        Entities entities13 = new Entities();
        entities13.setName("SystemsModels");
//      ...................... co.simasoft.models.naif.domainmodels ........................
        GroupIds groupIds17 = new GroupIds();
        groupIds17 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels",em);
        entities13.setGroupIds(groupIds17);
        em.persist(entities13);
        em.flush();

        Entities entities14 = new Entities();
        entities14.setName("Imports");
//      ...................... co.simasoft.models.naif.domainmodels ........................
        GroupIds groupIds18 = new GroupIds();
        groupIds18 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels",em);
        entities14.setGroupIds(groupIds18);
        em.persist(entities14);
        em.flush();

        Entities entities15 = new Entities();
        entities15.setName("Dependency");
//      ...................... co.simasoft.models.naif.domainmodels ........................
        GroupIds groupIds19 = new GroupIds();
        groupIds19 = findBean.groupIdGroupIds("co.simasoft.models.naif.domainmodels",em);
        entities15.setGroupIds(groupIds19);
        em.persist(entities15);
        em.flush();

        Entities entities16 = new Entities();
        entities16.setName("LinksTypes1");
//      ...................... co.simasoft.models.naif.items ........................
        GroupIds groupIds20 = new GroupIds();
        groupIds20 = findBean.groupIdGroupIds("co.simasoft.models.naif.items",em);
        entities16.setGroupIds(groupIds20);
        em.persist(entities16);
        em.flush();

        Entities entities17 = new Entities();
        entities17.setName("Links1");
//      ...................... co.simasoft.models.naif.items ........................
        GroupIds groupIds21 = new GroupIds();
        groupIds21 = findBean.groupIdGroupIds("co.simasoft.models.naif.items",em);
        entities17.setGroupIds(groupIds21);
        em.persist(entities17);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes1 = new Attributes();
        attributes1.setName("entity");
        attributes1.setNullable(true);
        attributes1.setSingle(false);
//      ...................... Relationships ........................
        Entities entities22 = new Entities();
        entities22 = findBean.nameEntities("Relationships",em);
        attributes1.setEntities(entities22);
//      ...................... String ........................
        AttributesTypes attributesTypes23 = new AttributesTypes();
        attributesTypes23 = findBean.nameAttributesTypes("String",em);
        attributes1.setAttributesTypes(attributesTypes23);
        em.persist(attributes1);
        em.flush();

        Attributes attributes2 = new Attributes();
        attributes2.setName("isEmbedded");
        attributes2.setNullable(true);
        attributes2.setSingle(false);
//      ...................... Relationships ........................
        Entities entities24 = new Entities();
        entities24 = findBean.nameEntities("Relationships",em);
        attributes2.setEntities(entities24);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes25 = new AttributesTypes();
        attributesTypes25 = findBean.nameAttributesTypes("Boolean",em);
        attributes2.setAttributesTypes(attributesTypes25);
        em.persist(attributes2);
        em.flush();

        Attributes attributes3 = new Attributes();
        attributes3.setName("optionality");
        attributes3.setNullable(true);
        attributes3.setSingle(false);
//      ...................... Relationships ........................
        Entities entities26 = new Entities();
        entities26 = findBean.nameEntities("Relationships",em);
        attributes3.setEntities(entities26);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes27 = new AttributesTypes();
        attributesTypes27 = findBean.nameAttributesTypes("Boolean",em);
        attributes3.setAttributesTypes(attributesTypes27);
        em.persist(attributes3);
        em.flush();

        Attributes attributes4 = new Attributes();
        attributes4.setName("name");
        attributes4.setNullable(true);
        attributes4.setSingle(false);
//      ...................... Relationships ........................
        Entities entities28 = new Entities();
        entities28 = findBean.nameEntities("Relationships",em);
        attributes4.setEntities(entities28);
//      ...................... String ........................
        AttributesTypes attributesTypes29 = new AttributesTypes();
        attributesTypes29 = findBean.nameAttributesTypes("String",em);
        attributes4.setAttributesTypes(attributesTypes29);
        em.persist(attributes4);
        em.flush();

        Attributes attributes5 = new Attributes();
        attributes5.setName("mappedby");
        attributes5.setNullable(true);
        attributes5.setSingle(false);
//      ...................... Relationships ........................
        Entities entities30 = new Entities();
        entities30 = findBean.nameEntities("Relationships",em);
        attributes5.setEntities(entities30);
//      ...................... String ........................
        AttributesTypes attributesTypes31 = new AttributesTypes();
        attributesTypes31 = findBean.nameAttributesTypes("String",em);
        attributes5.setAttributesTypes(attributesTypes31);
        em.persist(attributes5);
        em.flush();

        Attributes attributes6 = new Attributes();
        attributes6.setName("annotationsMethod");
        attributes6.setNullable(true);
        attributes6.setSingle(false);
//      ...................... Relationships ........................
        Entities entities32 = new Entities();
        entities32 = findBean.nameEntities("Relationships",em);
        attributes6.setEntities(entities32);
//      ...................... String ........................
        AttributesTypes attributesTypes33 = new AttributesTypes();
        attributesTypes33 = findBean.nameAttributesTypes("String",em);
        attributes6.setAttributesTypes(attributesTypes33);
        em.persist(attributes6);
        em.flush();

        Attributes attributes7 = new Attributes();
        attributes7.setName("annotationsField");
        attributes7.setNullable(true);
        attributes7.setSingle(false);
//      ...................... Relationships ........................
        Entities entities34 = new Entities();
        entities34 = findBean.nameEntities("Relationships",em);
        attributes7.setEntities(entities34);
//      ...................... String ........................
        AttributesTypes attributesTypes35 = new AttributesTypes();
        attributesTypes35 = findBean.nameAttributesTypes("String",em);
        attributes7.setAttributesTypes(attributesTypes35);
        em.persist(attributes7);
        em.flush();

        Attributes attributes8 = new Attributes();
        attributes8.setName("table");
        attributes8.setNullable(true);
        attributes8.setSingle(false);
//      ...................... Relationships ........................
        Entities entities36 = new Entities();
        entities36 = findBean.nameEntities("Relationships",em);
        attributes8.setEntities(entities36);
//      ...................... String ........................
        AttributesTypes attributesTypes37 = new AttributesTypes();
        attributesTypes37 = findBean.nameAttributesTypes("String",em);
        attributes8.setAttributesTypes(attributesTypes37);
        em.persist(attributes8);
        em.flush();

        Attributes attributes9 = new Attributes();
        attributes9.setName("idTable1");
        attributes9.setNullable(true);
        attributes9.setSingle(false);
//      ...................... Relationships ........................
        Entities entities38 = new Entities();
        entities38 = findBean.nameEntities("Relationships",em);
        attributes9.setEntities(entities38);
//      ...................... String ........................
        AttributesTypes attributesTypes39 = new AttributesTypes();
        attributesTypes39 = findBean.nameAttributesTypes("String",em);
        attributes9.setAttributesTypes(attributesTypes39);
        em.persist(attributes9);
        em.flush();

        Attributes attributes10 = new Attributes();
        attributes10.setName("idTable2");
        attributes10.setNullable(true);
        attributes10.setSingle(false);
//      ...................... Relationships ........................
        Entities entities40 = new Entities();
        entities40 = findBean.nameEntities("Relationships",em);
        attributes10.setEntities(entities40);
//      ...................... String ........................
        AttributesTypes attributesTypes41 = new AttributesTypes();
        attributesTypes41 = findBean.nameAttributesTypes("String",em);
        attributes10.setAttributesTypes(attributesTypes41);
        em.persist(attributes10);
        em.flush();

        Attributes attributes11 = new Attributes();
        attributes11.setName("description");
        attributes11.setNullable(true);
        attributes11.setSingle(false);
//      ...................... Relationships ........................
        Entities entities42 = new Entities();
        entities42 = findBean.nameEntities("Relationships",em);
        attributes11.setEntities(entities42);
//      ...................... String ........................
        AttributesTypes attributesTypes43 = new AttributesTypes();
        attributesTypes43 = findBean.nameAttributesTypes("String",em);
        attributes11.setAttributesTypes(attributesTypes43);
        em.persist(attributes11);
        em.flush();

        Attributes attributes12 = new Attributes();
        attributes12.setName("observations");
        attributes12.setNullable(true);
        attributes12.setSingle(false);
//      ...................... Relationships ........................
        Entities entities44 = new Entities();
        entities44 = findBean.nameEntities("Relationships",em);
        attributes12.setEntities(entities44);
//      ...................... String ........................
        AttributesTypes attributesTypes45 = new AttributesTypes();
        attributesTypes45 = findBean.nameAttributesTypes("String",em);
        attributes12.setAttributesTypes(attributesTypes45);
        em.persist(attributes12);
        em.flush();

        Attributes attributes13 = new Attributes();
        attributes13.setName("name");
        attributes13.setNullable(false);
        attributes13.setSingle(false);
//      ...................... Entities ........................
        Entities entities46 = new Entities();
        entities46 = findBean.nameEntities("Entities",em);
        attributes13.setEntities(entities46);
//      ...................... String ........................
        AttributesTypes attributesTypes47 = new AttributesTypes();
        attributesTypes47 = findBean.nameAttributesTypes("String",em);
        attributes13.setAttributesTypes(attributesTypes47);
        em.persist(attributes13);
        em.flush();

        Attributes attributes14 = new Attributes();
        attributes14.setName("serialID");
        attributes14.setNullable(true);
        attributes14.setSingle(true);
//      ...................... Entities ........................
        Entities entities48 = new Entities();
        entities48 = findBean.nameEntities("Entities",em);
        attributes14.setEntities(entities48);
//      ...................... String ........................
        AttributesTypes attributesTypes49 = new AttributesTypes();
        attributesTypes49 = findBean.nameAttributesTypes("String",em);
        attributes14.setAttributesTypes(attributesTypes49);
        em.persist(attributes14);
        em.flush();

        Attributes attributes15 = new Attributes();
        attributes15.setName("table");
        attributes15.setNullable(true);
        attributes15.setSingle(false);
//      ...................... Entities ........................
        Entities entities50 = new Entities();
        entities50 = findBean.nameEntities("Entities",em);
        attributes15.setEntities(entities50);
//      ...................... String ........................
        AttributesTypes attributesTypes51 = new AttributesTypes();
        attributesTypes51 = findBean.nameAttributesTypes("String",em);
        attributes15.setAttributesTypes(attributesTypes51);
        em.persist(attributes15);
        em.flush();

        Attributes attributes16 = new Attributes();
        attributes16.setName("tableSecuencia");
        attributes16.setNullable(true);
        attributes16.setSingle(false);
//      ...................... Entities ........................
        Entities entities52 = new Entities();
        entities52 = findBean.nameEntities("Entities",em);
        attributes16.setEntities(entities52);
//      ...................... String ........................
        AttributesTypes attributesTypes53 = new AttributesTypes();
        attributesTypes53 = findBean.nameAttributesTypes("String",em);
        attributes16.setAttributesTypes(attributesTypes53);
        em.persist(attributes16);
        em.flush();

        Attributes attributes17 = new Attributes();
        attributes17.setName("modifier");
        attributes17.setNullable(true);
        attributes17.setSingle(false);
//      ...................... Entities ........................
        Entities entities54 = new Entities();
        entities54 = findBean.nameEntities("Entities",em);
        attributes17.setEntities(entities54);
//      ...................... String ........................
        AttributesTypes attributesTypes55 = new AttributesTypes();
        attributesTypes55 = findBean.nameAttributesTypes("String",em);
        attributes17.setAttributesTypes(attributesTypes55);
        em.persist(attributes17);
        em.flush();

        Attributes attributes18 = new Attributes();
        attributes18.setName("extend");
        attributes18.setNullable(true);
        attributes18.setSingle(false);
//      ...................... Entities ........................
        Entities entities56 = new Entities();
        entities56 = findBean.nameEntities("Entities",em);
        attributes18.setEntities(entities56);
//      ...................... String ........................
        AttributesTypes attributesTypes57 = new AttributesTypes();
        attributesTypes57 = findBean.nameAttributesTypes("String",em);
        attributes18.setAttributesTypes(attributesTypes57);
        em.persist(attributes18);
        em.flush();

        Attributes attributes19 = new Attributes();
        attributes19.setName("annotations");
        attributes19.setNullable(true);
        attributes19.setSingle(false);
//      ...................... Entities ........................
        Entities entities58 = new Entities();
        entities58 = findBean.nameEntities("Entities",em);
        attributes19.setEntities(entities58);
//      ...................... Text ........................
        AttributesTypes attributesTypes59 = new AttributesTypes();
        attributesTypes59 = findBean.nameAttributesTypes("Text",em);
        attributes19.setAttributesTypes(attributesTypes59);
        em.persist(attributes19);
        em.flush();

        Attributes attributes20 = new Attributes();
        attributes20.setName("source");
        attributes20.setNullable(true);
        attributes20.setSingle(false);
//      ...................... Entities ........................
        Entities entities60 = new Entities();
        entities60 = findBean.nameEntities("Entities",em);
        attributes20.setEntities(entities60);
//      ...................... Text ........................
        AttributesTypes attributesTypes61 = new AttributesTypes();
        attributesTypes61 = findBean.nameAttributesTypes("Text",em);
        attributes20.setAttributesTypes(attributesTypes61);
        em.persist(attributes20);
        em.flush();

        Attributes attributes21 = new Attributes();
        attributes21.setName("description");
        attributes21.setNullable(true);
        attributes21.setSingle(false);
//      ...................... Entities ........................
        Entities entities62 = new Entities();
        entities62 = findBean.nameEntities("Entities",em);
        attributes21.setEntities(entities62);
//      ...................... String ........................
        AttributesTypes attributesTypes63 = new AttributesTypes();
        attributesTypes63 = findBean.nameAttributesTypes("String",em);
        attributes21.setAttributesTypes(attributesTypes63);
        em.persist(attributes21);
        em.flush();

        Attributes attributes22 = new Attributes();
        attributes22.setName("observations");
        attributes22.setNullable(true);
        attributes22.setSingle(false);
//      ...................... Entities ........................
        Entities entities64 = new Entities();
        entities64 = findBean.nameEntities("Entities",em);
        attributes22.setEntities(entities64);
//      ...................... Text ........................
        AttributesTypes attributesTypes65 = new AttributesTypes();
        attributesTypes65 = findBean.nameAttributesTypes("Text",em);
        attributes22.setAttributesTypes(attributesTypes65);
        em.persist(attributes22);
        em.flush();

        Attributes attributes23 = new Attributes();
        attributes23.setName("name");
        attributes23.setNullable(false);
        attributes23.setSingle(false);
//      ...................... Attributes ........................
        Entities entities66 = new Entities();
        entities66 = findBean.nameEntities("Attributes",em);
        attributes23.setEntities(entities66);
//      ...................... String ........................
        AttributesTypes attributesTypes67 = new AttributesTypes();
        attributesTypes67 = findBean.nameAttributesTypes("String",em);
        attributes23.setAttributesTypes(attributesTypes67);
        em.persist(attributes23);
        em.flush();

        Attributes attributes24 = new Attributes();
        attributes24.setName("length");
        attributes24.setNullable(true);
        attributes24.setSingle(false);
//      ...................... Attributes ........................
        Entities entities68 = new Entities();
        entities68 = findBean.nameEntities("Attributes",em);
        attributes24.setEntities(entities68);
//      ...................... Integer ........................
        AttributesTypes attributesTypes69 = new AttributesTypes();
        attributesTypes69 = findBean.nameAttributesTypes("Integer",em);
        attributes24.setAttributesTypes(attributesTypes69);
        em.persist(attributes24);
        em.flush();

        Attributes attributes25 = new Attributes();
        attributes25.setName("precision");
        attributes25.setNullable(true);
        attributes25.setSingle(false);
//      ...................... Attributes ........................
        Entities entities70 = new Entities();
        entities70 = findBean.nameEntities("Attributes",em);
        attributes25.setEntities(entities70);
//      ...................... Integer ........................
        AttributesTypes attributesTypes71 = new AttributesTypes();
        attributesTypes71 = findBean.nameAttributesTypes("Integer",em);
        attributes25.setAttributesTypes(attributesTypes71);
        em.persist(attributes25);
        em.flush();

        Attributes attributes26 = new Attributes();
        attributes26.setName("nullable");
        attributes26.setNullable(true);
        attributes26.setSingle(false);
//      ...................... Attributes ........................
        Entities entities72 = new Entities();
        entities72 = findBean.nameEntities("Attributes",em);
        attributes26.setEntities(entities72);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes73 = new AttributesTypes();
        attributesTypes73 = findBean.nameAttributesTypes("Boolean",em);
        attributes26.setAttributesTypes(attributesTypes73);
        em.persist(attributes26);
        em.flush();

        Attributes attributes27 = new Attributes();
        attributes27.setName("single");
        attributes27.setNullable(true);
        attributes27.setSingle(false);
//      ...................... Attributes ........................
        Entities entities74 = new Entities();
        entities74 = findBean.nameEntities("Attributes",em);
        attributes27.setEntities(entities74);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes75 = new AttributesTypes();
        attributesTypes75 = findBean.nameAttributesTypes("Boolean",em);
        attributes27.setAttributesTypes(attributesTypes75);
        em.persist(attributes27);
        em.flush();

        Attributes attributes28 = new Attributes();
        attributes28.setName("descripcion");
        attributes28.setNullable(true);
        attributes28.setSingle(false);
//      ...................... Attributes ........................
        Entities entities76 = new Entities();
        entities76 = findBean.nameEntities("Attributes",em);
        attributes28.setEntities(entities76);
//      ...................... String ........................
        AttributesTypes attributesTypes77 = new AttributesTypes();
        attributesTypes77 = findBean.nameAttributesTypes("String",em);
        attributes28.setAttributesTypes(attributesTypes77);
        em.persist(attributes28);
        em.flush();

        Attributes attributes29 = new Attributes();
        attributes29.setName("field");
        attributes29.setNullable(true);
        attributes29.setSingle(false);
//      ...................... Attributes ........................
        Entities entities78 = new Entities();
        entities78 = findBean.nameEntities("Attributes",em);
        attributes29.setEntities(entities78);
//      ...................... String ........................
        AttributesTypes attributesTypes79 = new AttributesTypes();
        attributesTypes79 = findBean.nameAttributesTypes("String",em);
        attributes29.setAttributesTypes(attributesTypes79);
        em.persist(attributes29);
        em.flush();

        Attributes attributes30 = new Attributes();
        attributes30.setName("access");
        attributes30.setNullable(true);
        attributes30.setSingle(false);
//      ...................... Attributes ........................
        Entities entities80 = new Entities();
        entities80 = findBean.nameEntities("Attributes",em);
        attributes30.setEntities(entities80);
//      ...................... String ........................
        AttributesTypes attributesTypes81 = new AttributesTypes();
        attributesTypes81 = findBean.nameAttributesTypes("String",em);
        attributes30.setAttributesTypes(attributesTypes81);
        em.persist(attributes30);
        em.flush();

        Attributes attributes31 = new Attributes();
        attributes31.setName("columnDefinition");
        attributes31.setNullable(true);
        attributes31.setSingle(false);
//      ...................... Attributes ........................
        Entities entities82 = new Entities();
        entities82 = findBean.nameEntities("Attributes",em);
        attributes31.setEntities(entities82);
//      ...................... String ........................
        AttributesTypes attributesTypes83 = new AttributesTypes();
        attributesTypes83 = findBean.nameAttributesTypes("String",em);
        attributes31.setAttributesTypes(attributesTypes83);
        em.persist(attributes31);
        em.flush();

        Attributes attributes32 = new Attributes();
        attributes32.setName("annotationsField");
        attributes32.setNullable(true);
        attributes32.setSingle(false);
//      ...................... Attributes ........................
        Entities entities84 = new Entities();
        entities84 = findBean.nameEntities("Attributes",em);
        attributes32.setEntities(entities84);
//      ...................... Text ........................
        AttributesTypes attributesTypes85 = new AttributesTypes();
        attributesTypes85 = findBean.nameAttributesTypes("Text",em);
        attributes32.setAttributesTypes(attributesTypes85);
        em.persist(attributes32);
        em.flush();

        Attributes attributes33 = new Attributes();
        attributes33.setName("annotationsMethod");
        attributes33.setNullable(true);
        attributes33.setSingle(false);
//      ...................... Attributes ........................
        Entities entities86 = new Entities();
        entities86 = findBean.nameEntities("Attributes",em);
        attributes33.setEntities(entities86);
//      ...................... Text ........................
        AttributesTypes attributesTypes87 = new AttributesTypes();
        attributesTypes87 = findBean.nameAttributesTypes("Text",em);
        attributes33.setAttributesTypes(attributesTypes87);
        em.persist(attributes33);
        em.flush();

        Attributes attributes34 = new Attributes();
        attributes34.setName("observations");
        attributes34.setNullable(true);
        attributes34.setSingle(false);
//      ...................... Attributes ........................
        Entities entities88 = new Entities();
        entities88 = findBean.nameEntities("Attributes",em);
        attributes34.setEntities(entities88);
//      ...................... Text ........................
        AttributesTypes attributesTypes89 = new AttributesTypes();
        attributesTypes89 = findBean.nameAttributesTypes("Text",em);
        attributes34.setAttributesTypes(attributesTypes89);
        em.persist(attributes34);
        em.flush();

        Attributes attributes35 = new Attributes();
        attributes35.setName("name");
        attributes35.setNullable(false);
        attributes35.setSingle(true);
//      ...................... Cardinalities ........................
        Entities entities90 = new Entities();
        entities90 = findBean.nameEntities("Cardinalities",em);
        attributes35.setEntities(entities90);
//      ...................... String ........................
        AttributesTypes attributesTypes91 = new AttributesTypes();
        attributesTypes91 = findBean.nameAttributesTypes("String",em);
        attributes35.setAttributesTypes(attributesTypes91);
        em.persist(attributes35);
        em.flush();

        Attributes attributes36 = new Attributes();
        attributes36.setName("cardinality");
        attributes36.setNullable(false);
        attributes36.setSingle(false);
//      ...................... Cardinalities ........................
        Entities entities92 = new Entities();
        entities92 = findBean.nameEntities("Cardinalities",em);
        attributes36.setEntities(entities92);
//      ...................... String ........................
        AttributesTypes attributesTypes93 = new AttributesTypes();
        attributesTypes93 = findBean.nameAttributesTypes("String",em);
        attributes36.setAttributesTypes(attributesTypes93);
        em.persist(attributes36);
        em.flush();

        Attributes attributes37 = new Attributes();
        attributes37.setName("unidirectional");
        attributes37.setNullable(true);
        attributes37.setSingle(false);
//      ...................... Cardinalities ........................
        Entities entities94 = new Entities();
        entities94 = findBean.nameEntities("Cardinalities",em);
        attributes37.setEntities(entities94);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes95 = new AttributesTypes();
        attributesTypes95 = findBean.nameAttributesTypes("Boolean",em);
        attributes37.setAttributesTypes(attributesTypes95);
        em.persist(attributes37);
        em.flush();

        Attributes attributes38 = new Attributes();
        attributes38.setName("annotations");
        attributes38.setNullable(true);
        attributes38.setSingle(false);
//      ...................... Cardinalities ........................
        Entities entities96 = new Entities();
        entities96 = findBean.nameEntities("Cardinalities",em);
        attributes38.setEntities(entities96);
//      ...................... Text ........................
        AttributesTypes attributesTypes97 = new AttributesTypes();
        attributesTypes97 = findBean.nameAttributesTypes("Text",em);
        attributes38.setAttributesTypes(attributesTypes97);
        em.persist(attributes38);
        em.flush();

        Attributes attributes39 = new Attributes();
        attributes39.setName("observations");
        attributes39.setNullable(true);
        attributes39.setSingle(false);
//      ...................... Cardinalities ........................
        Entities entities98 = new Entities();
        entities98 = findBean.nameEntities("Cardinalities",em);
        attributes39.setEntities(entities98);
//      ...................... Text ........................
        AttributesTypes attributesTypes99 = new AttributesTypes();
        attributesTypes99 = findBean.nameAttributesTypes("Text",em);
        attributes39.setAttributesTypes(attributesTypes99);
        em.persist(attributes39);
        em.flush();

        Attributes attributes40 = new Attributes();
        attributes40.setName("name");
        attributes40.setNullable(true);
        attributes40.setSingle(false);
//      ...................... GroupIds ........................
        Entities entities100 = new Entities();
        entities100 = findBean.nameEntities("GroupIds",em);
        attributes40.setEntities(entities100);
//      ...................... String ........................
        AttributesTypes attributesTypes101 = new AttributesTypes();
        attributesTypes101 = findBean.nameAttributesTypes("String",em);
        attributes40.setAttributesTypes(attributesTypes101);
        em.persist(attributes40);
        em.flush();

        Attributes attributes41 = new Attributes();
        attributes41.setName("groupId");
        attributes41.setNullable(false);
        attributes41.setSingle(false);
//      ...................... GroupIds ........................
        Entities entities102 = new Entities();
        entities102 = findBean.nameEntities("GroupIds",em);
        attributes41.setEntities(entities102);
//      ...................... String ........................
        AttributesTypes attributesTypes103 = new AttributesTypes();
        attributesTypes103 = findBean.nameAttributesTypes("String",em);
        attributes41.setAttributesTypes(attributesTypes103);
        em.persist(attributes41);
        em.flush();

        Attributes attributes42 = new Attributes();
        attributes42.setName("artifactId");
        attributes42.setNullable(true);
        attributes42.setSingle(true);
//      ...................... GroupIds ........................
        Entities entities104 = new Entities();
        entities104 = findBean.nameEntities("GroupIds",em);
        attributes42.setEntities(entities104);
//      ...................... String ........................
        AttributesTypes attributesTypes105 = new AttributesTypes();
        attributesTypes105 = findBean.nameAttributesTypes("String",em);
        attributes42.setAttributesTypes(attributesTypes105);
        em.persist(attributes42);
        em.flush();

        Attributes attributes43 = new Attributes();
        attributes43.setName("version");
        attributes43.setNullable(true);
        attributes43.setSingle(false);
//      ...................... GroupIds ........................
        Entities entities106 = new Entities();
        entities106 = findBean.nameEntities("GroupIds",em);
        attributes43.setEntities(entities106);
//      ...................... String ........................
        AttributesTypes attributesTypes107 = new AttributesTypes();
        attributesTypes107 = findBean.nameAttributesTypes("String",em);
        attributes43.setAttributesTypes(attributesTypes107);
        em.persist(attributes43);
        em.flush();

        Attributes attributes44 = new Attributes();
        attributes44.setName("code");
        attributes44.setNullable(true);
        attributes44.setSingle(true);
//      ...................... GroupIds ........................
        Entities entities108 = new Entities();
        entities108 = findBean.nameEntities("GroupIds",em);
        attributes44.setEntities(entities108);
//      ...................... String ........................
        AttributesTypes attributesTypes109 = new AttributesTypes();
        attributesTypes109 = findBean.nameAttributesTypes("String",em);
        attributes44.setAttributesTypes(attributesTypes109);
        em.persist(attributes44);
        em.flush();

        Attributes attributes45 = new Attributes();
        attributes45.setName("date");
        attributes45.setNullable(true);
        attributes45.setSingle(false);
//      ...................... GroupIds ........................
        Entities entities110 = new Entities();
        entities110 = findBean.nameEntities("GroupIds",em);
        attributes45.setEntities(entities110);
//      ...................... Date ........................
        AttributesTypes attributesTypes111 = new AttributesTypes();
        attributesTypes111 = findBean.nameAttributesTypes("Date",em);
        attributes45.setAttributesTypes(attributesTypes111);
        em.persist(attributes45);
        em.flush();

        Attributes attributes46 = new Attributes();
        attributes46.setName("description");
        attributes46.setNullable(true);
        attributes46.setSingle(false);
//      ...................... GroupIds ........................
        Entities entities112 = new Entities();
        entities112 = findBean.nameEntities("GroupIds",em);
        attributes46.setEntities(entities112);
//      ...................... String ........................
        AttributesTypes attributesTypes113 = new AttributesTypes();
        attributesTypes113 = findBean.nameAttributesTypes("String",em);
        attributes46.setAttributesTypes(attributesTypes113);
        em.persist(attributes46);
        em.flush();

        Attributes attributes47 = new Attributes();
        attributes47.setName("observations");
        attributes47.setNullable(true);
        attributes47.setSingle(false);
//      ...................... GroupIds ........................
        Entities entities114 = new Entities();
        entities114 = findBean.nameEntities("GroupIds",em);
        attributes47.setEntities(entities114);
//      ...................... Text ........................
        AttributesTypes attributesTypes115 = new AttributesTypes();
        attributesTypes115 = findBean.nameAttributesTypes("Text",em);
        attributes47.setAttributesTypes(attributesTypes115);
        em.persist(attributes47);
        em.flush();

        Attributes attributes48 = new Attributes();
        attributes48.setName("name");
        attributes48.setNullable(false);
        attributes48.setSingle(true);
//      ...................... AttributesProperties ........................
        Entities entities116 = new Entities();
        entities116 = findBean.nameEntities("AttributesProperties",em);
        attributes48.setEntities(entities116);
//      ...................... String ........................
        AttributesTypes attributesTypes117 = new AttributesTypes();
        attributesTypes117 = findBean.nameAttributesTypes("String",em);
        attributes48.setAttributesTypes(attributesTypes117);
        em.persist(attributes48);
        em.flush();

        Attributes attributes49 = new Attributes();
        attributes49.setName("value");
        attributes49.setNullable(false);
        attributes49.setSingle(true);
//      ...................... AttributesProperties ........................
        Entities entities118 = new Entities();
        entities118 = findBean.nameEntities("AttributesProperties",em);
        attributes49.setEntities(entities118);
//      ...................... String ........................
        AttributesTypes attributesTypes119 = new AttributesTypes();
        attributesTypes119 = findBean.nameAttributesTypes("String",em);
        attributes49.setAttributesTypes(attributesTypes119);
        em.persist(attributes49);
        em.flush();

        Attributes attributes50 = new Attributes();
        attributes50.setName("observations");
        attributes50.setNullable(true);
        attributes50.setSingle(false);
//      ...................... AttributesProperties ........................
        Entities entities120 = new Entities();
        entities120 = findBean.nameEntities("AttributesProperties",em);
        attributes50.setEntities(entities120);
//      ...................... Text ........................
        AttributesTypes attributesTypes121 = new AttributesTypes();
        attributesTypes121 = findBean.nameAttributesTypes("Text",em);
        attributes50.setAttributesTypes(attributesTypes121);
        em.persist(attributes50);
        em.flush();

        Attributes attributes51 = new Attributes();
        attributes51.setName("name");
        attributes51.setNullable(false);
        attributes51.setSingle(true);
//      ...................... FilesModels ........................
        Entities entities122 = new Entities();
        entities122 = findBean.nameEntities("FilesModels",em);
        attributes51.setEntities(entities122);
//      ...................... String ........................
        AttributesTypes attributesTypes123 = new AttributesTypes();
        attributesTypes123 = findBean.nameAttributesTypes("String",em);
        attributes51.setAttributesTypes(attributesTypes123);
        em.persist(attributes51);
        em.flush();

        Attributes attributes52 = new Attributes();
        attributes52.setName("extension");
        attributes52.setNullable(false);
        attributes52.setSingle(false);
//      ...................... FilesModels ........................
        Entities entities124 = new Entities();
        entities124 = findBean.nameEntities("FilesModels",em);
        attributes52.setEntities(entities124);
//      ...................... String ........................
        AttributesTypes attributesTypes125 = new AttributesTypes();
        attributesTypes125 = findBean.nameAttributesTypes("String",em);
        attributes52.setAttributesTypes(attributesTypes125);
        em.persist(attributes52);
        em.flush();

        Attributes attributes53 = new Attributes();
        attributes53.setName("date");
        attributes53.setNullable(false);
        attributes53.setSingle(false);
//      ...................... FilesModels ........................
        Entities entities126 = new Entities();
        entities126 = findBean.nameEntities("FilesModels",em);
        attributes53.setEntities(entities126);
//      ...................... Date ........................
        AttributesTypes attributesTypes127 = new AttributesTypes();
        attributesTypes127 = findBean.nameAttributesTypes("Date",em);
        attributes53.setAttributesTypes(attributesTypes127);
        em.persist(attributes53);
        em.flush();

        Attributes attributes54 = new Attributes();
        attributes54.setName("url");
        attributes54.setNullable(false);
        attributes54.setSingle(false);
//      ...................... FilesModels ........................
        Entities entities128 = new Entities();
        entities128 = findBean.nameEntities("FilesModels",em);
        attributes54.setEntities(entities128);
//      ...................... String ........................
        AttributesTypes attributesTypes129 = new AttributesTypes();
        attributesTypes129 = findBean.nameAttributesTypes("String",em);
        attributes54.setAttributesTypes(attributesTypes129);
        em.persist(attributes54);
        em.flush();

        Attributes attributes55 = new Attributes();
        attributes55.setName("data");
        attributes55.setNullable(true);
        attributes55.setSingle(false);
//      ...................... FilesModels ........................
        Entities entities130 = new Entities();
        entities130 = findBean.nameEntities("FilesModels",em);
        attributes55.setEntities(entities130);
//      ...................... byte ........................
        AttributesTypes attributesTypes131 = new AttributesTypes();
        attributesTypes131 = findBean.nameAttributesTypes("byte",em);
        attributes55.setAttributesTypes(attributesTypes131);
        em.persist(attributes55);
        em.flush();

        Attributes attributes56 = new Attributes();
        attributes56.setName("observations");
        attributes56.setNullable(true);
        attributes56.setSingle(false);
//      ...................... FilesModels ........................
        Entities entities132 = new Entities();
        entities132 = findBean.nameEntities("FilesModels",em);
        attributes56.setEntities(entities132);
//      ...................... Text ........................
        AttributesTypes attributesTypes133 = new AttributesTypes();
        attributesTypes133 = findBean.nameAttributesTypes("Text",em);
        attributes56.setAttributesTypes(attributesTypes133);
        em.persist(attributes56);
        em.flush();

        Attributes attributes57 = new Attributes();
        attributes57.setName("title");
        attributes57.setNullable(false);
        attributes57.setSingle(true);
//      ...................... Links ........................
        Entities entities134 = new Entities();
        entities134 = findBean.nameEntities("Links",em);
        attributes57.setEntities(entities134);
//      ...................... String ........................
        AttributesTypes attributesTypes135 = new AttributesTypes();
        attributesTypes135 = findBean.nameAttributesTypes("String",em);
        attributes57.setAttributesTypes(attributesTypes135);
        em.persist(attributes57);
        em.flush();

        Attributes attributes58 = new Attributes();
        attributes58.setName("link");
        attributes58.setNullable(false);
        attributes58.setSingle(true);
//      ...................... Links ........................
        Entities entities136 = new Entities();
        entities136 = findBean.nameEntities("Links",em);
        attributes58.setEntities(entities136);
//      ...................... String ........................
        AttributesTypes attributesTypes137 = new AttributesTypes();
        attributesTypes137 = findBean.nameAttributesTypes("String",em);
        attributes58.setAttributesTypes(attributesTypes137);
        em.persist(attributes58);
        em.flush();

        Attributes attributes59 = new Attributes();
        attributes59.setName("observations");
        attributes59.setNullable(true);
        attributes59.setSingle(false);
//      ...................... Links ........................
        Entities entities138 = new Entities();
        entities138 = findBean.nameEntities("Links",em);
        attributes59.setEntities(entities138);
//      ...................... Text ........................
        AttributesTypes attributesTypes139 = new AttributesTypes();
        attributesTypes139 = findBean.nameAttributesTypes("Text",em);
        attributes59.setAttributesTypes(attributesTypes139);
        em.persist(attributes59);
        em.flush();

        Attributes attributes60 = new Attributes();
        attributes60.setName("name");
        attributes60.setNullable(false);
        attributes60.setSingle(true);
//      ...................... LinksTypes ........................
        Entities entities140 = new Entities();
        entities140 = findBean.nameEntities("LinksTypes",em);
        attributes60.setEntities(entities140);
//      ...................... String ........................
        AttributesTypes attributesTypes141 = new AttributesTypes();
        attributesTypes141 = findBean.nameAttributesTypes("String",em);
        attributes60.setAttributesTypes(attributesTypes141);
        em.persist(attributes60);
        em.flush();

        Attributes attributes61 = new Attributes();
        attributes61.setName("name");
        attributes61.setNullable(false);
        attributes61.setSingle(true);
//      ...................... NameQueries ........................
        Entities entities142 = new Entities();
        entities142 = findBean.nameEntities("NameQueries",em);
        attributes61.setEntities(entities142);
//      ...................... String ........................
        AttributesTypes attributesTypes143 = new AttributesTypes();
        attributesTypes143 = findBean.nameAttributesTypes("String",em);
        attributes61.setAttributesTypes(attributesTypes143);
        em.persist(attributes61);
        em.flush();

        Attributes attributes62 = new Attributes();
        attributes62.setName("query");
        attributes62.setNullable(false);
        attributes62.setSingle(true);
//      ...................... NameQueries ........................
        Entities entities144 = new Entities();
        entities144 = findBean.nameEntities("NameQueries",em);
        attributes62.setEntities(entities144);
//      ...................... Text ........................
        AttributesTypes attributesTypes145 = new AttributesTypes();
        attributesTypes145 = findBean.nameAttributesTypes("Text",em);
        attributes62.setAttributesTypes(attributesTypes145);
        em.persist(attributes62);
        em.flush();

        Attributes attributes63 = new Attributes();
        attributes63.setName("observations");
        attributes63.setNullable(true);
        attributes63.setSingle(false);
//      ...................... NameQueries ........................
        Entities entities146 = new Entities();
        entities146 = findBean.nameEntities("NameQueries",em);
        attributes63.setEntities(entities146);
//      ...................... Text ........................
        AttributesTypes attributesTypes147 = new AttributesTypes();
        attributesTypes147 = findBean.nameAttributesTypes("Text",em);
        attributes63.setAttributesTypes(attributesTypes147);
        em.persist(attributes63);
        em.flush();

        Attributes attributes64 = new Attributes();
        attributes64.setName("name");
        attributes64.setNullable(false);
        attributes64.setSingle(true);
//      ...................... AttributesTypes ........................
        Entities entities148 = new Entities();
        entities148 = findBean.nameEntities("AttributesTypes",em);
        attributes64.setEntities(entities148);
//      ...................... String ........................
        AttributesTypes attributesTypes149 = new AttributesTypes();
        attributesTypes149 = findBean.nameAttributesTypes("String",em);
        attributes64.setAttributesTypes(attributesTypes149);
        em.persist(attributes64);
        em.flush();

        Attributes attributes65 = new Attributes();
        attributes65.setName("type");
        attributes65.setNullable(false);
        attributes65.setSingle(false);
//      ...................... AttributesTypes ........................
        Entities entities150 = new Entities();
        entities150 = findBean.nameEntities("AttributesTypes",em);
        attributes65.setEntities(entities150);
//      ...................... String ........................
        AttributesTypes attributesTypes151 = new AttributesTypes();
        attributesTypes151 = findBean.nameAttributesTypes("String",em);
        attributes65.setAttributesTypes(attributesTypes151);
        em.persist(attributes65);
        em.flush();

        Attributes attributes66 = new Attributes();
        attributes66.setName("length");
        attributes66.setNullable(true);
        attributes66.setSingle(false);
//      ...................... AttributesTypes ........................
        Entities entities152 = new Entities();
        entities152 = findBean.nameEntities("AttributesTypes",em);
        attributes66.setEntities(entities152);
//      ...................... Integer ........................
        AttributesTypes attributesTypes153 = new AttributesTypes();
        attributesTypes153 = findBean.nameAttributesTypes("Integer",em);
        attributes66.setAttributesTypes(attributesTypes153);
        em.persist(attributes66);
        em.flush();

        Attributes attributes67 = new Attributes();
        attributes67.setName("precision");
        attributes67.setNullable(true);
        attributes67.setSingle(false);
//      ...................... AttributesTypes ........................
        Entities entities154 = new Entities();
        entities154 = findBean.nameEntities("AttributesTypes",em);
        attributes67.setEntities(entities154);
//      ...................... Integer ........................
        AttributesTypes attributesTypes155 = new AttributesTypes();
        attributesTypes155 = findBean.nameAttributesTypes("Integer",em);
        attributes67.setAttributesTypes(attributesTypes155);
        em.persist(attributes67);
        em.flush();

        Attributes attributes68 = new Attributes();
        attributes68.setName("annotations");
        attributes68.setNullable(true);
        attributes68.setSingle(false);
//      ...................... AttributesTypes ........................
        Entities entities156 = new Entities();
        entities156 = findBean.nameEntities("AttributesTypes",em);
        attributes68.setEntities(entities156);
//      ...................... Text ........................
        AttributesTypes attributesTypes157 = new AttributesTypes();
        attributesTypes157 = findBean.nameAttributesTypes("Text",em);
        attributes68.setAttributesTypes(attributesTypes157);
        em.persist(attributes68);
        em.flush();

        Attributes attributes69 = new Attributes();
        attributes69.setName("observations");
        attributes69.setNullable(true);
        attributes69.setSingle(false);
//      ...................... AttributesTypes ........................
        Entities entities158 = new Entities();
        entities158 = findBean.nameEntities("AttributesTypes",em);
        attributes69.setEntities(entities158);
//      ...................... Text ........................
        AttributesTypes attributesTypes159 = new AttributesTypes();
        attributesTypes159 = findBean.nameAttributesTypes("Text",em);
        attributes69.setAttributesTypes(attributesTypes159);
        em.persist(attributes69);
        em.flush();

        Attributes attributes70 = new Attributes();
        attributes70.setName("name");
        attributes70.setNullable(true);
        attributes70.setSingle(false);
//      ...................... DomainModels ........................
        Entities entities160 = new Entities();
        entities160 = findBean.nameEntities("DomainModels",em);
        attributes70.setEntities(entities160);
//      ...................... String ........................
        AttributesTypes attributesTypes161 = new AttributesTypes();
        attributesTypes161 = findBean.nameAttributesTypes("String",em);
        attributes70.setAttributesTypes(attributesTypes161);
        em.persist(attributes70);
        em.flush();

        Attributes attributes71 = new Attributes();
        attributes71.setName("groupId");
        attributes71.setNullable(false);
        attributes71.setSingle(false);
//      ...................... DomainModels ........................
        Entities entities162 = new Entities();
        entities162 = findBean.nameEntities("DomainModels",em);
        attributes71.setEntities(entities162);
//      ...................... String ........................
        AttributesTypes attributesTypes163 = new AttributesTypes();
        attributesTypes163 = findBean.nameAttributesTypes("String",em);
        attributes71.setAttributesTypes(attributesTypes163);
        em.persist(attributes71);
        em.flush();

        Attributes attributes72 = new Attributes();
        attributes72.setName("artifactId");
        attributes72.setNullable(false);
        attributes72.setSingle(true);
//      ...................... DomainModels ........................
        Entities entities164 = new Entities();
        entities164 = findBean.nameEntities("DomainModels",em);
        attributes72.setEntities(entities164);
//      ...................... String ........................
        AttributesTypes attributesTypes165 = new AttributesTypes();
        attributesTypes165 = findBean.nameAttributesTypes("String",em);
        attributes72.setAttributesTypes(attributesTypes165);
        em.persist(attributes72);
        em.flush();

        Attributes attributes73 = new Attributes();
        attributes73.setName("version");
        attributes73.setNullable(false);
        attributes73.setSingle(false);
//      ...................... DomainModels ........................
        Entities entities166 = new Entities();
        entities166 = findBean.nameEntities("DomainModels",em);
        attributes73.setEntities(entities166);
//      ...................... String ........................
        AttributesTypes attributesTypes167 = new AttributesTypes();
        attributesTypes167 = findBean.nameAttributesTypes("String",em);
        attributes73.setAttributesTypes(attributesTypes167);
        em.persist(attributes73);
        em.flush();

        Attributes attributes74 = new Attributes();
        attributes74.setName("code");
        attributes74.setNullable(true);
        attributes74.setSingle(true);
//      ...................... DomainModels ........................
        Entities entities168 = new Entities();
        entities168 = findBean.nameEntities("DomainModels",em);
        attributes74.setEntities(entities168);
//      ...................... String ........................
        AttributesTypes attributesTypes169 = new AttributesTypes();
        attributesTypes169 = findBean.nameAttributesTypes("String",em);
        attributes74.setAttributesTypes(attributesTypes169);
        em.persist(attributes74);
        em.flush();

        Attributes attributes75 = new Attributes();
        attributes75.setName("date");
        attributes75.setNullable(true);
        attributes75.setSingle(false);
//      ...................... DomainModels ........................
        Entities entities170 = new Entities();
        entities170 = findBean.nameEntities("DomainModels",em);
        attributes75.setEntities(entities170);
//      ...................... Date ........................
        AttributesTypes attributesTypes171 = new AttributesTypes();
        attributesTypes171 = findBean.nameAttributesTypes("Date",em);
        attributes75.setAttributesTypes(attributesTypes171);
        em.persist(attributes75);
        em.flush();

        Attributes attributes76 = new Attributes();
        attributes76.setName("description");
        attributes76.setNullable(true);
        attributes76.setSingle(false);
//      ...................... DomainModels ........................
        Entities entities172 = new Entities();
        entities172 = findBean.nameEntities("DomainModels",em);
        attributes76.setEntities(entities172);
//      ...................... String ........................
        AttributesTypes attributesTypes173 = new AttributesTypes();
        attributesTypes173 = findBean.nameAttributesTypes("String",em);
        attributes76.setAttributesTypes(attributesTypes173);
        em.persist(attributes76);
        em.flush();

        Attributes attributes77 = new Attributes();
        attributes77.setName("observations");
        attributes77.setNullable(true);
        attributes77.setSingle(false);
//      ...................... DomainModels ........................
        Entities entities174 = new Entities();
        entities174 = findBean.nameEntities("DomainModels",em);
        attributes77.setEntities(entities174);
//      ...................... Text ........................
        AttributesTypes attributesTypes175 = new AttributesTypes();
        attributesTypes175 = findBean.nameAttributesTypes("Text",em);
        attributes77.setAttributesTypes(attributesTypes175);
        em.persist(attributes77);
        em.flush();

        Attributes attributes78 = new Attributes();
        attributes78.setName("name");
        attributes78.setNullable(false);
        attributes78.setSingle(true);
//      ...................... SystemsModels ........................
        Entities entities176 = new Entities();
        entities176 = findBean.nameEntities("SystemsModels",em);
        attributes78.setEntities(entities176);
//      ...................... String ........................
        AttributesTypes attributesTypes177 = new AttributesTypes();
        attributesTypes177 = findBean.nameAttributesTypes("String",em);
        attributes78.setAttributesTypes(attributesTypes177);
        em.persist(attributes78);
        em.flush();

        Attributes attributes79 = new Attributes();
        attributes79.setName("description");
        attributes79.setNullable(true);
        attributes79.setSingle(false);
//      ...................... SystemsModels ........................
        Entities entities178 = new Entities();
        entities178 = findBean.nameEntities("SystemsModels",em);
        attributes79.setEntities(entities178);
//      ...................... String ........................
        AttributesTypes attributesTypes179 = new AttributesTypes();
        attributesTypes179 = findBean.nameAttributesTypes("String",em);
        attributes79.setAttributesTypes(attributesTypes179);
        em.persist(attributes79);
        em.flush();

        Attributes attributes80 = new Attributes();
        attributes80.setName("observations");
        attributes80.setNullable(true);
        attributes80.setSingle(false);
//      ...................... SystemsModels ........................
        Entities entities180 = new Entities();
        entities180 = findBean.nameEntities("SystemsModels",em);
        attributes80.setEntities(entities180);
//      ...................... Text ........................
        AttributesTypes attributesTypes181 = new AttributesTypes();
        attributesTypes181 = findBean.nameAttributesTypes("Text",em);
        attributes80.setAttributesTypes(attributesTypes181);
        em.persist(attributes80);
        em.flush();

        Attributes attributes81 = new Attributes();
        attributes81.setName("name");
        attributes81.setNullable(false);
        attributes81.setSingle(true);
//      ...................... Imports ........................
        Entities entities182 = new Entities();
        entities182 = findBean.nameEntities("Imports",em);
        attributes81.setEntities(entities182);
//      ...................... String ........................
        AttributesTypes attributesTypes183 = new AttributesTypes();
        attributesTypes183 = findBean.nameAttributesTypes("String",em);
        attributes81.setAttributesTypes(attributesTypes183);
        em.persist(attributes81);
        em.flush();

        Attributes attributes82 = new Attributes();
        attributes82.setName("observations");
        attributes82.setNullable(true);
        attributes82.setSingle(false);
//      ...................... Imports ........................
        Entities entities184 = new Entities();
        entities184 = findBean.nameEntities("Imports",em);
        attributes82.setEntities(entities184);
//      ...................... Text ........................
        AttributesTypes attributesTypes185 = new AttributesTypes();
        attributesTypes185 = findBean.nameAttributesTypes("Text",em);
        attributes82.setAttributesTypes(attributesTypes185);
        em.persist(attributes82);
        em.flush();

        Attributes attributes83 = new Attributes();
        attributes83.setName("groupId");
        attributes83.setNullable(false);
        attributes83.setSingle(false);
//      ...................... Dependency ........................
        Entities entities186 = new Entities();
        entities186 = findBean.nameEntities("Dependency",em);
        attributes83.setEntities(entities186);
//      ...................... String ........................
        AttributesTypes attributesTypes187 = new AttributesTypes();
        attributesTypes187 = findBean.nameAttributesTypes("String",em);
        attributes83.setAttributesTypes(attributesTypes187);
        em.persist(attributes83);
        em.flush();

        Attributes attributes84 = new Attributes();
        attributes84.setName("artifactId");
        attributes84.setNullable(false);
        attributes84.setSingle(false);
//      ...................... Dependency ........................
        Entities entities188 = new Entities();
        entities188 = findBean.nameEntities("Dependency",em);
        attributes84.setEntities(entities188);
//      ...................... String ........................
        AttributesTypes attributesTypes189 = new AttributesTypes();
        attributesTypes189 = findBean.nameAttributesTypes("String",em);
        attributes84.setAttributesTypes(attributesTypes189);
        em.persist(attributes84);
        em.flush();

        Attributes attributes85 = new Attributes();
        attributes85.setName("version");
        attributes85.setNullable(true);
        attributes85.setSingle(false);
//      ...................... Dependency ........................
        Entities entities190 = new Entities();
        entities190 = findBean.nameEntities("Dependency",em);
        attributes85.setEntities(entities190);
//      ...................... String ........................
        AttributesTypes attributesTypes191 = new AttributesTypes();
        attributesTypes191 = findBean.nameAttributesTypes("String",em);
        attributes85.setAttributesTypes(attributesTypes191);
        em.persist(attributes85);
        em.flush();

        Attributes attributes86 = new Attributes();
        attributes86.setName("type");
        attributes86.setNullable(true);
        attributes86.setSingle(false);
//      ...................... Dependency ........................
        Entities entities192 = new Entities();
        entities192 = findBean.nameEntities("Dependency",em);
        attributes86.setEntities(entities192);
//      ...................... String ........................
        AttributesTypes attributesTypes193 = new AttributesTypes();
        attributesTypes193 = findBean.nameAttributesTypes("String",em);
        attributes86.setAttributesTypes(attributesTypes193);
        em.persist(attributes86);
        em.flush();

        Attributes attributes87 = new Attributes();
        attributes87.setName("scope");
        attributes87.setNullable(true);
        attributes87.setSingle(false);
//      ...................... Dependency ........................
        Entities entities194 = new Entities();
        entities194 = findBean.nameEntities("Dependency",em);
        attributes87.setEntities(entities194);
//      ...................... String ........................
        AttributesTypes attributesTypes195 = new AttributesTypes();
        attributesTypes195 = findBean.nameAttributesTypes("String",em);
        attributes87.setAttributesTypes(attributesTypes195);
        em.persist(attributes87);
        em.flush();

        Attributes attributes88 = new Attributes();
        attributes88.setName("maven");
        attributes88.setNullable(false);
        attributes88.setSingle(true);
//      ...................... Dependency ........................
        Entities entities196 = new Entities();
        entities196 = findBean.nameEntities("Dependency",em);
        attributes88.setEntities(entities196);
//      ...................... Text ........................
        AttributesTypes attributesTypes197 = new AttributesTypes();
        attributesTypes197 = findBean.nameAttributesTypes("Text",em);
        attributes88.setAttributesTypes(attributesTypes197);
        em.persist(attributes88);
        em.flush();

        Attributes attributes89 = new Attributes();
        attributes89.setName("link");
        attributes89.setNullable(false);
        attributes89.setSingle(false);
//      ...................... Dependency ........................
        Entities entities198 = new Entities();
        entities198 = findBean.nameEntities("Dependency",em);
        attributes89.setEntities(entities198);
//      ...................... String ........................
        AttributesTypes attributesTypes199 = new AttributesTypes();
        attributesTypes199 = findBean.nameAttributesTypes("String",em);
        attributes89.setAttributesTypes(attributesTypes199);
        em.persist(attributes89);
        em.flush();

        Attributes attributes90 = new Attributes();
        attributes90.setName("observations");
        attributes90.setNullable(true);
        attributes90.setSingle(false);
//      ...................... Dependency ........................
        Entities entities200 = new Entities();
        entities200 = findBean.nameEntities("Dependency",em);
        attributes90.setEntities(entities200);
//      ...................... Text ........................
        AttributesTypes attributesTypes201 = new AttributesTypes();
        attributesTypes201 = findBean.nameAttributesTypes("Text",em);
        attributes90.setAttributesTypes(attributesTypes201);
        em.persist(attributes90);
        em.flush();

        Attributes attributes91 = new Attributes();
        attributes91.setName("name");
        attributes91.setNullable(false);
        attributes91.setSingle(true);
//      ...................... LinksTypes1 ........................
        Entities entities202 = new Entities();
        entities202 = findBean.nameEntities("LinksTypes1",em);
        attributes91.setEntities(entities202);
//      ...................... String ........................
        AttributesTypes attributesTypes203 = new AttributesTypes();
        attributesTypes203 = findBean.nameAttributesTypes("String",em);
        attributes91.setAttributesTypes(attributesTypes203);
        em.persist(attributes91);
        em.flush();

        Attributes attributes92 = new Attributes();
        attributes92.setName("observations");
        attributes92.setNullable(true);
        attributes92.setSingle(false);
//      ...................... LinksTypes1 ........................
        Entities entities204 = new Entities();
        entities204 = findBean.nameEntities("LinksTypes1",em);
        attributes92.setEntities(entities204);
//      ...................... Text ........................
        AttributesTypes attributesTypes205 = new AttributesTypes();
        attributesTypes205 = findBean.nameAttributesTypes("Text",em);
        attributes92.setAttributesTypes(attributesTypes205);
        em.persist(attributes92);
        em.flush();

        Attributes attributes93 = new Attributes();
        attributes93.setName("title");
        attributes93.setNullable(false);
        attributes93.setSingle(true);
//      ...................... Links1 ........................
        Entities entities206 = new Entities();
        entities206 = findBean.nameEntities("Links1",em);
        attributes93.setEntities(entities206);
//      ...................... String ........................
        AttributesTypes attributesTypes207 = new AttributesTypes();
        attributesTypes207 = findBean.nameAttributesTypes("String",em);
        attributes93.setAttributesTypes(attributesTypes207);
        em.persist(attributes93);
        em.flush();

        Attributes attributes94 = new Attributes();
        attributes94.setName("link");
        attributes94.setNullable(false);
        attributes94.setSingle(true);
//      ...................... Links1 ........................
        Entities entities208 = new Entities();
        entities208 = findBean.nameEntities("Links1",em);
        attributes94.setEntities(entities208);
//      ...................... String ........................
        AttributesTypes attributesTypes209 = new AttributesTypes();
        attributesTypes209 = findBean.nameAttributesTypes("String",em);
        attributes94.setAttributesTypes(attributesTypes209);
        em.persist(attributes94);
        em.flush();

        Attributes attributes95 = new Attributes();
        attributes95.setName("observations");
        attributes95.setNullable(true);
        attributes95.setSingle(false);
//      ...................... Links1 ........................
        Entities entities210 = new Entities();
        entities210 = findBean.nameEntities("Links1",em);
        attributes95.setEntities(entities210);
//      ...................... Text ........................
        AttributesTypes attributesTypes211 = new AttributesTypes();
        attributesTypes211 = findBean.nameAttributesTypes("Text",em);
        attributes95.setAttributesTypes(attributesTypes211);
        em.persist(attributes95);
        em.flush();

//      ---------------------- Relationships ------------------------

        Relationships relationships1 = new Relationships();
        relationships1.setOptionality(true);
        relationships1.setIsEmbedded(false);
        relationships1.setName("from");
//      ...................... Entities ........................
        Entities entities212 = new Entities();
        entities212 = findBean.nameEntities("Entities",em);
        relationships1.setFrom(entities212);
//      ...................... Relationships ........................
        Entities entities213 = new Entities();
        entities213 = findBean.nameEntities("Relationships",em);
        relationships1.setTo(entities213);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities214 = new Cardinalities();
        cardinalities214 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships1.setCardinalities(cardinalities214);
        em.persist(relationships1);
        em.flush();

        Relationships relationships2 = new Relationships();
        relationships2.setOptionality(true);
        relationships2.setIsEmbedded(false);
//      ...................... Entities ........................
        Entities entities215 = new Entities();
        entities215 = findBean.nameEntities("Entities",em);
        relationships2.setFrom(entities215);
//      ...................... Imports ........................
        Entities entities216 = new Entities();
        entities216 = findBean.nameEntities("Imports",em);
        relationships2.setTo(entities216);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities217 = new Cardinalities();
        cardinalities217 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships2.setCardinalities(cardinalities217);
        em.persist(relationships2);
        em.flush();

        Relationships relationships3 = new Relationships();
        relationships3.setOptionality(true);
        relationships3.setIsEmbedded(false);
//      ...................... Entities ........................
        Entities entities218 = new Entities();
        entities218 = findBean.nameEntities("Entities",em);
        relationships3.setFrom(entities218);
//      ...................... NameQueries ........................
        Entities entities219 = new Entities();
        entities219 = findBean.nameEntities("NameQueries",em);
        relationships3.setTo(entities219);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities220 = new Cardinalities();
        cardinalities220 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships3.setCardinalities(cardinalities220);
        em.persist(relationships3);
        em.flush();

        Relationships relationships4 = new Relationships();
        relationships4.setOptionality(true);
        relationships4.setIsEmbedded(false);
//      ...................... Entities ........................
        Entities entities221 = new Entities();
        entities221 = findBean.nameEntities("Entities",em);
        relationships4.setFrom(entities221);
//      ...................... Attributes ........................
        Entities entities222 = new Entities();
        entities222 = findBean.nameEntities("Attributes",em);
        relationships4.setTo(entities222);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities223 = new Cardinalities();
        cardinalities223 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships4.setCardinalities(cardinalities223);
        em.persist(relationships4);
        em.flush();

        Relationships relationships5 = new Relationships();
        relationships5.setOptionality(true);
        relationships5.setIsEmbedded(false);
        relationships5.setName("to");
//      ...................... Entities ........................
        Entities entities224 = new Entities();
        entities224 = findBean.nameEntities("Entities",em);
        relationships5.setFrom(entities224);
//      ...................... Relationships ........................
        Entities entities225 = new Entities();
        entities225 = findBean.nameEntities("Relationships",em);
        relationships5.setTo(entities225);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities226 = new Cardinalities();
        cardinalities226 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships5.setCardinalities(cardinalities226);
        em.persist(relationships5);
        em.flush();

        Relationships relationships6 = new Relationships();
        relationships6.setOptionality(true);
        relationships6.setIsEmbedded(false);
//      ...................... Entities ........................
        Entities entities227 = new Entities();
        entities227 = findBean.nameEntities("Entities",em);
        relationships6.setFrom(entities227);
//      ...................... FilesModels ........................
        Entities entities228 = new Entities();
        entities228 = findBean.nameEntities("FilesModels",em);
        relationships6.setTo(entities228);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities229 = new Cardinalities();
        cardinalities229 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships6.setCardinalities(cardinalities229);
        em.persist(relationships6);
        em.flush();

        Relationships relationships7 = new Relationships();
        relationships7.setOptionality(true);
        relationships7.setIsEmbedded(false);
//      ...................... Attributes ........................
        Entities entities230 = new Entities();
        entities230 = findBean.nameEntities("Attributes",em);
        relationships7.setFrom(entities230);
//      ...................... AttributesProperties ........................
        Entities entities231 = new Entities();
        entities231 = findBean.nameEntities("AttributesProperties",em);
        relationships7.setTo(entities231);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities232 = new Cardinalities();
        cardinalities232 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships7.setCardinalities(cardinalities232);
        em.persist(relationships7);
        em.flush();

        Relationships relationships8 = new Relationships();
        relationships8.setOptionality(true);
        relationships8.setIsEmbedded(false);
//      ...................... Cardinalities ........................
        Entities entities233 = new Entities();
        entities233 = findBean.nameEntities("Cardinalities",em);
        relationships8.setFrom(entities233);
//      ...................... Relationships ........................
        Entities entities234 = new Entities();
        entities234 = findBean.nameEntities("Relationships",em);
        relationships8.setTo(entities234);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities235 = new Cardinalities();
        cardinalities235 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships8.setCardinalities(cardinalities235);
        em.persist(relationships8);
        em.flush();

        Relationships relationships9 = new Relationships();
        relationships9.setOptionality(true);
        relationships9.setIsEmbedded(false);
//      ...................... Cardinalities ........................
        Entities entities236 = new Entities();
        entities236 = findBean.nameEntities("Cardinalities",em);
        relationships9.setFrom(entities236);
//      ...................... Imports ........................
        Entities entities237 = new Entities();
        entities237 = findBean.nameEntities("Imports",em);
        relationships9.setTo(entities237);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities238 = new Cardinalities();
        cardinalities238 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships9.setCardinalities(cardinalities238);
        em.persist(relationships9);
        em.flush();

        Relationships relationships10 = new Relationships();
        relationships10.setOptionality(true);
        relationships10.setIsEmbedded(false);
//      ...................... GroupIds ........................
        Entities entities239 = new Entities();
        entities239 = findBean.nameEntities("GroupIds",em);
        relationships10.setFrom(entities239);
//      ...................... FilesModels ........................
        Entities entities240 = new Entities();
        entities240 = findBean.nameEntities("FilesModels",em);
        relationships10.setTo(entities240);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities241 = new Cardinalities();
        cardinalities241 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships10.setCardinalities(cardinalities241);
        em.persist(relationships10);
        em.flush();

        Relationships relationships11 = new Relationships();
        relationships11.setOptionality(true);
        relationships11.setIsEmbedded(false);
//      ...................... GroupIds ........................
        Entities entities242 = new Entities();
        entities242 = findBean.nameEntities("GroupIds",em);
        relationships11.setFrom(entities242);
//      ...................... Links ........................
        Entities entities243 = new Entities();
        entities243 = findBean.nameEntities("Links",em);
        relationships11.setTo(entities243);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities244 = new Cardinalities();
        cardinalities244 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships11.setCardinalities(cardinalities244);
        em.persist(relationships11);
        em.flush();

        Relationships relationships12 = new Relationships();
        relationships12.setOptionality(true);
        relationships12.setIsEmbedded(false);
//      ...................... GroupIds ........................
        Entities entities245 = new Entities();
        entities245 = findBean.nameEntities("GroupIds",em);
        relationships12.setFrom(entities245);
//      ...................... Entities ........................
        Entities entities246 = new Entities();
        entities246 = findBean.nameEntities("Entities",em);
        relationships12.setTo(entities246);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities247 = new Cardinalities();
        cardinalities247 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships12.setCardinalities(cardinalities247);
        em.persist(relationships12);
        em.flush();

        Relationships relationships13 = new Relationships();
        relationships13.setOptionality(true);
        relationships13.setIsEmbedded(false);
//      ...................... AttributesProperties ........................
        Entities entities248 = new Entities();
        entities248 = findBean.nameEntities("AttributesProperties",em);
        relationships13.setFrom(entities248);
//      ...................... Imports ........................
        Entities entities249 = new Entities();
        entities249 = findBean.nameEntities("Imports",em);
        relationships13.setTo(entities249);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities250 = new Cardinalities();
        cardinalities250 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships13.setCardinalities(cardinalities250);
        em.persist(relationships13);
        em.flush();

        Relationships relationships14 = new Relationships();
        relationships14.setOptionality(true);
        relationships14.setIsEmbedded(false);
//      ...................... LinksTypes ........................
        Entities entities251 = new Entities();
        entities251 = findBean.nameEntities("LinksTypes",em);
        relationships14.setFrom(entities251);
//      ...................... Links ........................
        Entities entities252 = new Entities();
        entities252 = findBean.nameEntities("Links",em);
        relationships14.setTo(entities252);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities253 = new Cardinalities();
        cardinalities253 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships14.setCardinalities(cardinalities253);
        em.persist(relationships14);
        em.flush();

        Relationships relationships15 = new Relationships();
        relationships15.setOptionality(true);
        relationships15.setIsEmbedded(false);
//      ...................... Relationships ........................
        Entities entities254 = new Entities();
        entities254 = findBean.nameEntities("Relationships",em);
        relationships15.setFrom(entities254);
//      ...................... AttributesProperties ........................
        Entities entities255 = new Entities();
        entities255 = findBean.nameEntities("AttributesProperties",em);
        relationships15.setTo(entities255);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities256 = new Cardinalities();
        cardinalities256 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships15.setCardinalities(cardinalities256);
        em.persist(relationships15);
        em.flush();

        Relationships relationships16 = new Relationships();
        relationships16.setOptionality(true);
        relationships16.setIsEmbedded(false);
//      ...................... AttributesTypes ........................
        Entities entities257 = new Entities();
        entities257 = findBean.nameEntities("AttributesTypes",em);
        relationships16.setFrom(entities257);
//      ...................... AttributesProperties ........................
        Entities entities258 = new Entities();
        entities258 = findBean.nameEntities("AttributesProperties",em);
        relationships16.setTo(entities258);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities259 = new Cardinalities();
        cardinalities259 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships16.setCardinalities(cardinalities259);
        em.persist(relationships16);
        em.flush();

        Relationships relationships17 = new Relationships();
        relationships17.setOptionality(true);
        relationships17.setIsEmbedded(false);
//      ...................... AttributesTypes ........................
        Entities entities260 = new Entities();
        entities260 = findBean.nameEntities("AttributesTypes",em);
        relationships17.setFrom(entities260);
//      ...................... Attributes ........................
        Entities entities261 = new Entities();
        entities261 = findBean.nameEntities("Attributes",em);
        relationships17.setTo(entities261);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities262 = new Cardinalities();
        cardinalities262 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships17.setCardinalities(cardinalities262);
        em.persist(relationships17);
        em.flush();

        Relationships relationships18 = new Relationships();
        relationships18.setOptionality(true);
        relationships18.setIsEmbedded(false);
//      ...................... DomainModels ........................
        Entities entities263 = new Entities();
        entities263 = findBean.nameEntities("DomainModels",em);
        relationships18.setFrom(entities263);
//      ...................... FilesModels ........................
        Entities entities264 = new Entities();
        entities264 = findBean.nameEntities("FilesModels",em);
        relationships18.setTo(entities264);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities265 = new Cardinalities();
        cardinalities265 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships18.setCardinalities(cardinalities265);
        em.persist(relationships18);
        em.flush();

        Relationships relationships19 = new Relationships();
        relationships19.setOptionality(true);
        relationships19.setIsEmbedded(false);
//      ...................... DomainModels ........................
        Entities entities266 = new Entities();
        entities266 = findBean.nameEntities("DomainModels",em);
        relationships19.setFrom(entities266);
//      ...................... GroupIds ........................
        Entities entities267 = new Entities();
        entities267 = findBean.nameEntities("GroupIds",em);
        relationships19.setTo(entities267);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities268 = new Cardinalities();
        cardinalities268 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships19.setCardinalities(cardinalities268);
        em.persist(relationships19);
        em.flush();

        Relationships relationships20 = new Relationships();
        relationships20.setOptionality(true);
        relationships20.setIsEmbedded(false);
//      ...................... SystemsModels ........................
        Entities entities269 = new Entities();
        entities269 = findBean.nameEntities("SystemsModels",em);
        relationships20.setFrom(entities269);
//      ...................... FilesModels ........................
        Entities entities270 = new Entities();
        entities270 = findBean.nameEntities("FilesModels",em);
        relationships20.setTo(entities270);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities271 = new Cardinalities();
        cardinalities271 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships20.setCardinalities(cardinalities271);
        em.persist(relationships20);
        em.flush();

        Relationships relationships21 = new Relationships();
        relationships21.setOptionality(true);
        relationships21.setIsEmbedded(false);
//      ...................... SystemsModels ........................
        Entities entities272 = new Entities();
        entities272 = findBean.nameEntities("SystemsModels",em);
        relationships21.setFrom(entities272);
//      ...................... DomainModels ........................
        Entities entities273 = new Entities();
        entities273 = findBean.nameEntities("DomainModels",em);
        relationships21.setTo(entities273);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities274 = new Cardinalities();
        cardinalities274 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships21.setCardinalities(cardinalities274);
        em.persist(relationships21);
        em.flush();

        Relationships relationships22 = new Relationships();
        relationships22.setOptionality(true);
        relationships22.setIsEmbedded(false);
//      ...................... Dependency ........................
        Entities entities275 = new Entities();
        entities275 = findBean.nameEntities("Dependency",em);
        relationships22.setFrom(entities275);
//      ...................... Imports ........................
        Entities entities276 = new Entities();
        entities276 = findBean.nameEntities("Imports",em);
        relationships22.setTo(entities276);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities277 = new Cardinalities();
        cardinalities277 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships22.setCardinalities(cardinalities277);
        em.persist(relationships22);
        em.flush();

        Relationships relationships23 = new Relationships();
        relationships23.setOptionality(true);
        relationships23.setIsEmbedded(false);
//      ...................... LinksTypes1 ........................
        Entities entities278 = new Entities();
        entities278 = findBean.nameEntities("LinksTypes1",em);
        relationships23.setFrom(entities278);
//      ...................... LinksTypes1 ........................
        Entities entities279 = new Entities();
        entities279 = findBean.nameEntities("LinksTypes1",em);
        relationships23.setTo(entities279);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities280 = new Cardinalities();
        cardinalities280 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships23.setCardinalities(cardinalities280);
        em.persist(relationships23);
        em.flush();

        Relationships relationships24 = new Relationships();
        relationships24.setOptionality(true);
        relationships24.setIsEmbedded(false);
//      ...................... LinksTypes1 ........................
        Entities entities281 = new Entities();
        entities281 = findBean.nameEntities("LinksTypes1",em);
        relationships24.setFrom(entities281);
//      ...................... Links1 ........................
        Entities entities282 = new Entities();
        entities282 = findBean.nameEntities("Links1",em);
        relationships24.setTo(entities282);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities283 = new Cardinalities();
        cardinalities283 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships24.setCardinalities(cardinalities283);
        em.persist(relationships24);
        em.flush();

        Relationships relationships25 = new Relationships();
        relationships25.setOptionality(true);
        relationships25.setIsEmbedded(false);
//      ...................... Links1 ........................
        Entities entities284 = new Entities();
        entities284 = findBean.nameEntities("Links1",em);
        relationships25.setFrom(entities284);
//      ...................... Links1 ........................
        Entities entities285 = new Entities();
        entities285 = findBean.nameEntities("Links1",em);
        relationships25.setTo(entities285);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities286 = new Cardinalities();
        cardinalities286 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships25.setCardinalities(cardinalities286);
        em.persist(relationships25);
        em.flush();

    } // data()

} // DataDb
