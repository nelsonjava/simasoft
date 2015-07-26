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
@Named("taskSetup")
public class taskSetup {

    @PersistenceContext(unitName = "naifg8PU-JTA")
    private EntityManager em;

    FindBean findBean = new FindBean();

    private static final Logger log = Logger.getLogger(DataDb.class.getName());

    public void data() {

//      ---------------------- DomainModels ------------------------

        DomainModels domainModels = new DomainModels();
        domainModels.setGroupId("co.simasoft");
        domainModels.setArtifactId("task");
        domainModels.setVersion("1.0-SNAPSHOT");
        em.persist(domainModels);
        em.flush();

//      ---------------------- GroupIds ------------------------

        GroupIds groupIds1 = new GroupIds();
        groupIds1.setGroupId("co.simasoft.models.naif.task.archival");
//      ...................... task ........................
        DomainModels domainModel1 = new DomainModels();
        domainModel1 = findBean.artifactIdDomainModels("task",em);
        groupIds1.setDomainModels(domainModel1);
        em.persist(groupIds1);
        em.flush();

//      ---------------------- Entities ------------------------

        Entities entities2 = new Entities();
        entities2.setName("ConservationUnits");
//      ...................... co.simasoft.models.naif.task.archival ........................
        GroupIds groupId2 = new GroupIds();
        groupId2 = findBean.groupIdGroupIds("co.simasoft.models.naif.task.archival",em);
        entities2.setGroupIds(groupId2);
        em.persist(entities2);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes3 = new Attributes();
        attributes3.setName("code");
        attributes3.setNullable(true);
        attributes3.setSingle(false);
//      ...................... ConservationUnits ........................
        Entities entity3 = new Entities();
        entity3 = findBean.nameEntities("ConservationUnits",em);
        attributes3.setEntities(entity3);
//      ...................... String ........................
        AttributesTypes attributesTypes4 = new AttributesTypes();
        attributesTypes4 = findBean.nameAttributesTypes("String",em);
        attributes3.setAttributesTypes(attributesTypes4);
        em.persist(attributes3);
        em.flush();

        Attributes attributes4 = new Attributes();
        attributes4.setName("name");
        attributes4.setNullable(true);
        attributes4.setSingle(false);
//      ...................... ConservationUnits ........................
        Entities entity5 = new Entities();
        entity5 = findBean.nameEntities("ConservationUnits",em);
        attributes4.setEntities(entity5);
//      ...................... String ........................
        AttributesTypes attributesTypes6 = new AttributesTypes();
        attributesTypes6 = findBean.nameAttributesTypes("String",em);
        attributes4.setAttributesTypes(attributesTypes6);
        em.persist(attributes4);
        em.flush();

        Entities entities5 = new Entities();
        entities5.setName("SectionsTypes");
//      ...................... co.simasoft.models.naif.task.archival ........................
        GroupIds groupId7 = new GroupIds();
        groupId7 = findBean.groupIdGroupIds("co.simasoft.models.naif.task.archival",em);
        entities5.setGroupIds(groupId7);
        em.persist(entities5);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes6 = new Attributes();
        attributes6.setName("name");
        attributes6.setNullable(true);
        attributes6.setSingle(false);
//      ...................... SectionsTypes ........................
        Entities entity8 = new Entities();
        entity8 = findBean.nameEntities("SectionsTypes",em);
        attributes6.setEntities(entity8);
//      ...................... String ........................
        AttributesTypes attributesTypes9 = new AttributesTypes();
        attributesTypes9 = findBean.nameAttributesTypes("String",em);
        attributes6.setAttributesTypes(attributesTypes9);
        em.persist(attributes6);
        em.flush();

        Entities entities7 = new Entities();
        entities7.setName("DocumentalsSupports");
//      ...................... co.simasoft.models.naif.task.archival ........................
        GroupIds groupId10 = new GroupIds();
        groupId10 = findBean.groupIdGroupIds("co.simasoft.models.naif.task.archival",em);
        entities7.setGroupIds(groupId10);
        em.persist(entities7);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes8 = new Attributes();
        attributes8.setName("code");
        attributes8.setNullable(true);
        attributes8.setSingle(false);
//      ...................... DocumentalsSupports ........................
        Entities entity11 = new Entities();
        entity11 = findBean.nameEntities("DocumentalsSupports",em);
        attributes8.setEntities(entity11);
//      ...................... String ........................
        AttributesTypes attributesTypes12 = new AttributesTypes();
        attributesTypes12 = findBean.nameAttributesTypes("String",em);
        attributes8.setAttributesTypes(attributesTypes12);
        em.persist(attributes8);
        em.flush();

        Attributes attributes9 = new Attributes();
        attributes9.setName("name");
        attributes9.setNullable(true);
        attributes9.setSingle(false);
//      ...................... DocumentalsSupports ........................
        Entities entity13 = new Entities();
        entity13 = findBean.nameEntities("DocumentalsSupports",em);
        attributes9.setEntities(entity13);
//      ...................... String ........................
        AttributesTypes attributesTypes14 = new AttributesTypes();
        attributesTypes14 = findBean.nameAttributesTypes("String",em);
        attributes9.setAttributesTypes(attributesTypes14);
        em.persist(attributes9);
        em.flush();

        Entities entities10 = new Entities();
        entities10.setName("Series");
//      ...................... co.simasoft.models.naif.task.archival ........................
        GroupIds groupId15 = new GroupIds();
        groupId15 = findBean.groupIdGroupIds("co.simasoft.models.naif.task.archival",em);
        entities10.setGroupIds(groupId15);
        em.persist(entities10);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes11 = new Attributes();
        attributes11.setName("code");
        attributes11.setNullable(true);
        attributes11.setSingle(false);
//      ...................... Series ........................
        Entities entity16 = new Entities();
        entity16 = findBean.nameEntities("Series",em);
        attributes11.setEntities(entity16);
//      ...................... String ........................
        AttributesTypes attributesTypes17 = new AttributesTypes();
        attributesTypes17 = findBean.nameAttributesTypes("String",em);
        attributes11.setAttributesTypes(attributesTypes17);
        em.persist(attributes11);
        em.flush();

        Attributes attributes12 = new Attributes();
        attributes12.setName("name");
        attributes12.setNullable(true);
        attributes12.setSingle(false);
//      ...................... Series ........................
        Entities entity18 = new Entities();
        entity18 = findBean.nameEntities("Series",em);
        attributes12.setEntities(entity18);
//      ...................... String ........................
        AttributesTypes attributesTypes19 = new AttributesTypes();
        attributesTypes19 = findBean.nameAttributesTypes("String",em);
        attributes12.setAttributesTypes(attributesTypes19);
        em.persist(attributes12);
        em.flush();

        Attributes attributes13 = new Attributes();
        attributes13.setName("located");
        attributes13.setNullable(true);
        attributes13.setSingle(false);
//      ...................... Series ........................
        Entities entity20 = new Entities();
        entity20 = findBean.nameEntities("Series",em);
        attributes13.setEntities(entity20);
//      ...................... String ........................
        AttributesTypes attributesTypes21 = new AttributesTypes();
        attributesTypes21 = findBean.nameAttributesTypes("String",em);
        attributes13.setAttributesTypes(attributesTypes21);
        em.persist(attributes13);
        em.flush();

        Attributes attributes14 = new Attributes();
        attributes14.setName("link");
        attributes14.setNullable(true);
        attributes14.setSingle(false);
//      ...................... Series ........................
        Entities entity22 = new Entities();
        entity22 = findBean.nameEntities("Series",em);
        attributes14.setEntities(entity22);
//      ...................... String ........................
        AttributesTypes attributesTypes23 = new AttributesTypes();
        attributesTypes23 = findBean.nameAttributesTypes("String",em);
        attributes14.setAttributesTypes(attributesTypes23);
        em.persist(attributes14);
        em.flush();

        Entities entities15 = new Entities();
        entities15.setName("Sections");
//      ...................... co.simasoft.models.naif.task.archival ........................
        GroupIds groupId24 = new GroupIds();
        groupId24 = findBean.groupIdGroupIds("co.simasoft.models.naif.task.archival",em);
        entities15.setGroupIds(groupId24);
        em.persist(entities15);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes16 = new Attributes();
        attributes16.setName("code");
        attributes16.setNullable(true);
        attributes16.setSingle(false);
//      ...................... Sections ........................
        Entities entity25 = new Entities();
        entity25 = findBean.nameEntities("Sections",em);
        attributes16.setEntities(entity25);
//      ...................... String ........................
        AttributesTypes attributesTypes26 = new AttributesTypes();
        attributesTypes26 = findBean.nameAttributesTypes("String",em);
        attributes16.setAttributesTypes(attributesTypes26);
        em.persist(attributes16);
        em.flush();

        Attributes attributes17 = new Attributes();
        attributes17.setName("name");
        attributes17.setNullable(true);
        attributes17.setSingle(false);
//      ...................... Sections ........................
        Entities entity27 = new Entities();
        entity27 = findBean.nameEntities("Sections",em);
        attributes17.setEntities(entity27);
//      ...................... String ........................
        AttributesTypes attributesTypes28 = new AttributesTypes();
        attributesTypes28 = findBean.nameAttributesTypes("String",em);
        attributes17.setAttributesTypes(attributesTypes28);
        em.persist(attributes17);
        em.flush();

        Attributes attributes18 = new Attributes();
        attributes18.setName("email");
        attributes18.setNullable(true);
        attributes18.setSingle(false);
//      ...................... Sections ........................
        Entities entity29 = new Entities();
        entity29 = findBean.nameEntities("Sections",em);
        attributes18.setEntities(entity29);
//      ...................... String ........................
        AttributesTypes attributesTypes30 = new AttributesTypes();
        attributesTypes30 = findBean.nameAttributesTypes("String",em);
        attributes18.setAttributesTypes(attributesTypes30);
        em.persist(attributes18);
        em.flush();

        Entities entities19 = new Entities();
        entities19.setName("DocumentalsUnits");
//      ...................... co.simasoft.models.naif.task.archival ........................
        GroupIds groupId31 = new GroupIds();
        groupId31 = findBean.groupIdGroupIds("co.simasoft.models.naif.task.archival",em);
        entities19.setGroupIds(groupId31);
        em.persist(entities19);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes20 = new Attributes();
        attributes20.setName("name");
        attributes20.setNullable(true);
        attributes20.setSingle(false);
//      ...................... DocumentalsUnits ........................
        Entities entity32 = new Entities();
        entity32 = findBean.nameEntities("DocumentalsUnits",em);
        attributes20.setEntities(entity32);
//      ...................... String ........................
        AttributesTypes attributesTypes33 = new AttributesTypes();
        attributesTypes33 = findBean.nameAttributesTypes("String",em);
        attributes20.setAttributesTypes(attributesTypes33);
        em.persist(attributes20);
        em.flush();

        Attributes attributes21 = new Attributes();
        attributes21.setName("date");
        attributes21.setNullable(true);
        attributes21.setSingle(false);
//      ...................... DocumentalsUnits ........................
        Entities entity34 = new Entities();
        entity34 = findBean.nameEntities("DocumentalsUnits",em);
        attributes21.setEntities(entity34);
//      ...................... String ........................
        AttributesTypes attributesTypes35 = new AttributesTypes();
        attributesTypes35 = findBean.nameAttributesTypes("String",em);
        attributes21.setAttributesTypes(attributesTypes35);
        em.persist(attributes21);
        em.flush();

        Attributes attributes22 = new Attributes();
        attributes22.setName("link");
        attributes22.setNullable(true);
        attributes22.setSingle(false);
//      ...................... DocumentalsUnits ........................
        Entities entity36 = new Entities();
        entity36 = findBean.nameEntities("DocumentalsUnits",em);
        attributes22.setEntities(entity36);
//      ...................... String ........................
        AttributesTypes attributesTypes37 = new AttributesTypes();
        attributesTypes37 = findBean.nameAttributesTypes("String",em);
        attributes22.setAttributesTypes(attributesTypes37);
        em.persist(attributes22);
        em.flush();

        Entities entities23 = new Entities();
        entities23.setName("Funds");
//      ...................... co.simasoft.models.naif.task.archival ........................
        GroupIds groupId38 = new GroupIds();
        groupId38 = findBean.groupIdGroupIds("co.simasoft.models.naif.task.archival",em);
        entities23.setGroupIds(groupId38);
        em.persist(entities23);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes24 = new Attributes();
        attributes24.setName("code");
        attributes24.setNullable(true);
        attributes24.setSingle(false);
//      ...................... Funds ........................
        Entities entity39 = new Entities();
        entity39 = findBean.nameEntities("Funds",em);
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
//      ...................... Funds ........................
        Entities entity41 = new Entities();
        entity41 = findBean.nameEntities("Funds",em);
        attributes25.setEntities(entity41);
//      ...................... String ........................
        AttributesTypes attributesTypes42 = new AttributesTypes();
        attributesTypes42 = findBean.nameAttributesTypes("String",em);
        attributes25.setAttributesTypes(attributesTypes42);
        em.persist(attributes25);
        em.flush();

        Entities entities26 = new Entities();
        entities26.setName("DocumentsTypes");
//      ...................... co.simasoft.models.naif.task.archival ........................
        GroupIds groupId43 = new GroupIds();
        groupId43 = findBean.groupIdGroupIds("co.simasoft.models.naif.task.archival",em);
        entities26.setGroupIds(groupId43);
        em.persist(entities26);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes27 = new Attributes();
        attributes27.setName("name");
        attributes27.setNullable(true);
        attributes27.setSingle(false);
//      ...................... DocumentsTypes ........................
        Entities entity44 = new Entities();
        entity44 = findBean.nameEntities("DocumentsTypes",em);
        attributes27.setEntities(entity44);
//      ...................... String ........................
        AttributesTypes attributesTypes45 = new AttributesTypes();
        attributesTypes45 = findBean.nameAttributesTypes("String",em);
        attributes27.setAttributesTypes(attributesTypes45);
        em.persist(attributes27);
        em.flush();

        GroupIds groupIds28 = new GroupIds();
        groupIds28.setGroupId("co.simasoft.models.naif.task.sites");
//      ...................... task ........................
        DomainModels domainModel46 = new DomainModels();
        domainModel46 = findBean.artifactIdDomainModels("task",em);
        groupIds28.setDomainModels(domainModel46);
        em.persist(groupIds28);
        em.flush();

//      ---------------------- Entities ------------------------

        Entities entities29 = new Entities();
        entities29.setName("SitesTypes");
//      ...................... co.simasoft.models.naif.task.sites ........................
        GroupIds groupId47 = new GroupIds();
        groupId47 = findBean.groupIdGroupIds("co.simasoft.models.naif.task.sites",em);
        entities29.setGroupIds(groupId47);
        em.persist(entities29);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes30 = new Attributes();
        attributes30.setName("name");
        attributes30.setNullable(true);
        attributes30.setSingle(false);
//      ...................... SitesTypes ........................
        Entities entity48 = new Entities();
        entity48 = findBean.nameEntities("SitesTypes",em);
        attributes30.setEntities(entity48);
//      ...................... String ........................
        AttributesTypes attributesTypes49 = new AttributesTypes();
        attributesTypes49 = findBean.nameAttributesTypes("String",em);
        attributes30.setAttributesTypes(attributesTypes49);
        em.persist(attributes30);
        em.flush();

        Entities entities31 = new Entities();
        entities31.setName("Sites");
//      ...................... co.simasoft.models.naif.task.sites ........................
        GroupIds groupId50 = new GroupIds();
        groupId50 = findBean.groupIdGroupIds("co.simasoft.models.naif.task.sites",em);
        entities31.setGroupIds(groupId50);
        em.persist(entities31);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes32 = new Attributes();
        attributes32.setName("title");
        attributes32.setNullable(true);
        attributes32.setSingle(false);
//      ...................... Sites ........................
        Entities entity51 = new Entities();
        entity51 = findBean.nameEntities("Sites",em);
        attributes32.setEntities(entity51);
//      ...................... String ........................
        AttributesTypes attributesTypes52 = new AttributesTypes();
        attributesTypes52 = findBean.nameAttributesTypes("String",em);
        attributes32.setAttributesTypes(attributesTypes52);
        em.persist(attributes32);
        em.flush();

        Attributes attributes33 = new Attributes();
        attributes33.setName("link");
        attributes33.setNullable(false);
        attributes33.setSingle(true);
//      ...................... Sites ........................
        Entities entity53 = new Entities();
        entity53 = findBean.nameEntities("Sites",em);
        attributes33.setEntities(entity53);
//      ...................... String ........................
        AttributesTypes attributesTypes54 = new AttributesTypes();
        attributesTypes54 = findBean.nameAttributesTypes("String",em);
        attributes33.setAttributesTypes(attributesTypes54);
        em.persist(attributes33);
        em.flush();

        GroupIds groupIds34 = new GroupIds();
        groupIds34.setGroupId("co.simasoft.models.naif.task.activities");
//      ...................... task ........................
        DomainModels domainModel55 = new DomainModels();
        domainModel55 = findBean.artifactIdDomainModels("task",em);
        groupIds34.setDomainModels(domainModel55);
        em.persist(groupIds34);
        em.flush();

//      ---------------------- Entities ------------------------

        Entities entities35 = new Entities();
        entities35.setName("Diaries");
//      ...................... co.simasoft.models.naif.task.activities ........................
        GroupIds groupId56 = new GroupIds();
        groupId56 = findBean.groupIdGroupIds("co.simasoft.models.naif.task.activities",em);
        entities35.setGroupIds(groupId56);
        em.persist(entities35);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes36 = new Attributes();
        attributes36.setName("date");
        attributes36.setNullable(true);
        attributes36.setSingle(false);
//      ...................... Diaries ........................
        Entities entity57 = new Entities();
        entity57 = findBean.nameEntities("Diaries",em);
        attributes36.setEntities(entity57);
//      ...................... Date ........................
        AttributesTypes attributesTypes58 = new AttributesTypes();
        attributesTypes58 = findBean.nameAttributesTypes("Date",em);
        attributes36.setAttributesTypes(attributesTypes58);
        em.persist(attributes36);
        em.flush();

        Attributes attributes37 = new Attributes();
        attributes37.setName("detail");
        attributes37.setNullable(true);
        attributes37.setSingle(false);
//      ...................... Diaries ........................
        Entities entity59 = new Entities();
        entity59 = findBean.nameEntities("Diaries",em);
        attributes37.setEntities(entity59);
//      ...................... String ........................
        AttributesTypes attributesTypes60 = new AttributesTypes();
        attributesTypes60 = findBean.nameAttributesTypes("String",em);
        attributes37.setAttributesTypes(attributesTypes60);
        em.persist(attributes37);
        em.flush();

        Entities entities38 = new Entities();
        entities38.setName("Guides");
//      ...................... co.simasoft.models.naif.task.activities ........................
        GroupIds groupId61 = new GroupIds();
        groupId61 = findBean.groupIdGroupIds("co.simasoft.models.naif.task.activities",em);
        entities38.setGroupIds(groupId61);
        em.persist(entities38);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes39 = new Attributes();
        attributes39.setName("title");
        attributes39.setNullable(true);
        attributes39.setSingle(false);
//      ...................... Guides ........................
        Entities entity62 = new Entities();
        entity62 = findBean.nameEntities("Guides",em);
        attributes39.setEntities(entity62);
//      ...................... String ........................
        AttributesTypes attributesTypes63 = new AttributesTypes();
        attributesTypes63 = findBean.nameAttributesTypes("String",em);
        attributes39.setAttributesTypes(attributesTypes63);
        em.persist(attributes39);
        em.flush();

        Attributes attributes40 = new Attributes();
        attributes40.setName("guide");
        attributes40.setNullable(true);
        attributes40.setSingle(false);
//      ...................... Guides ........................
        Entities entity64 = new Entities();
        entity64 = findBean.nameEntities("Guides",em);
        attributes40.setEntities(entity64);
//      ...................... String ........................
        AttributesTypes attributesTypes65 = new AttributesTypes();
        attributesTypes65 = findBean.nameAttributesTypes("String",em);
        attributes40.setAttributesTypes(attributesTypes65);
        em.persist(attributes40);
        em.flush();

        Entities entities41 = new Entities();
        entities41.setName("Calendars");
//      ...................... co.simasoft.models.naif.task.activities ........................
        GroupIds groupId66 = new GroupIds();
        groupId66 = findBean.groupIdGroupIds("co.simasoft.models.naif.task.activities",em);
        entities41.setGroupIds(groupId66);
        em.persist(entities41);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes42 = new Attributes();
        attributes42.setName("name");
        attributes42.setNullable(true);
        attributes42.setSingle(false);
//      ...................... Calendars ........................
        Entities entity67 = new Entities();
        entity67 = findBean.nameEntities("Calendars",em);
        attributes42.setEntities(entity67);
//      ...................... String ........................
        AttributesTypes attributesTypes68 = new AttributesTypes();
        attributesTypes68 = findBean.nameAttributesTypes("String",em);
        attributes42.setAttributesTypes(attributesTypes68);
        em.persist(attributes42);
        em.flush();

        Attributes attributes43 = new Attributes();
        attributes43.setName("date");
        attributes43.setNullable(true);
        attributes43.setSingle(false);
//      ...................... Calendars ........................
        Entities entity69 = new Entities();
        entity69 = findBean.nameEntities("Calendars",em);
        attributes43.setEntities(entity69);
//      ...................... Date ........................
        AttributesTypes attributesTypes70 = new AttributesTypes();
        attributesTypes70 = findBean.nameAttributesTypes("Date",em);
        attributes43.setAttributesTypes(attributesTypes70);
        em.persist(attributes43);
        em.flush();

        Entities entities44 = new Entities();
        entities44.setName("Tasks");
//      ...................... co.simasoft.models.naif.task.activities ........................
        GroupIds groupId71 = new GroupIds();
        groupId71 = findBean.groupIdGroupIds("co.simasoft.models.naif.task.activities",em);
        entities44.setGroupIds(groupId71);
        em.persist(entities44);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes45 = new Attributes();
        attributes45.setName("name");
        attributes45.setNullable(true);
        attributes45.setSingle(false);
//      ...................... Tasks ........................
        Entities entity72 = new Entities();
        entity72 = findBean.nameEntities("Tasks",em);
        attributes45.setEntities(entity72);
//      ...................... String ........................
        AttributesTypes attributesTypes73 = new AttributesTypes();
        attributesTypes73 = findBean.nameAttributesTypes("String",em);
        attributes45.setAttributesTypes(attributesTypes73);
        em.persist(attributes45);
        em.flush();

        Attributes attributes46 = new Attributes();
        attributes46.setName("startDate");
        attributes46.setNullable(true);
        attributes46.setSingle(false);
//      ...................... Tasks ........................
        Entities entity74 = new Entities();
        entity74 = findBean.nameEntities("Tasks",em);
        attributes46.setEntities(entity74);
//      ...................... Date ........................
        AttributesTypes attributesTypes75 = new AttributesTypes();
        attributesTypes75 = findBean.nameAttributesTypes("Date",em);
        attributes46.setAttributesTypes(attributesTypes75);
        em.persist(attributes46);
        em.flush();

        Attributes attributes47 = new Attributes();
        attributes47.setName("finalDate");
        attributes47.setNullable(true);
        attributes47.setSingle(false);
//      ...................... Tasks ........................
        Entities entity76 = new Entities();
        entity76 = findBean.nameEntities("Tasks",em);
        attributes47.setEntities(entity76);
//      ...................... Date ........................
        AttributesTypes attributesTypes77 = new AttributesTypes();
        attributesTypes77 = findBean.nameAttributesTypes("Date",em);
        attributes47.setAttributesTypes(attributesTypes77);
        em.persist(attributes47);
        em.flush();

        Attributes attributes48 = new Attributes();
        attributes48.setName("priority");
        attributes48.setNullable(true);
        attributes48.setSingle(false);
//      ...................... Tasks ........................
        Entities entity78 = new Entities();
        entity78 = findBean.nameEntities("Tasks",em);
        attributes48.setEntities(entity78);
//      ...................... Integer ........................
        AttributesTypes attributesTypes79 = new AttributesTypes();
        attributesTypes79 = findBean.nameAttributesTypes("Integer",em);
        attributes48.setAttributesTypes(attributesTypes79);
        em.persist(attributes48);
        em.flush();

        Attributes attributes49 = new Attributes();
        attributes49.setName("detail");
        attributes49.setNullable(true);
        attributes49.setSingle(false);
//      ...................... Tasks ........................
        Entities entity80 = new Entities();
        entity80 = findBean.nameEntities("Tasks",em);
        attributes49.setEntities(entity80);
//      ...................... String ........................
        AttributesTypes attributesTypes81 = new AttributesTypes();
        attributesTypes81 = findBean.nameAttributesTypes("String",em);
        attributes49.setAttributesTypes(attributesTypes81);
        em.persist(attributes49);
        em.flush();

        Entities entities50 = new Entities();
        entities50.setName("Activities");
//      ...................... co.simasoft.models.naif.task.activities ........................
        GroupIds groupId82 = new GroupIds();
        groupId82 = findBean.groupIdGroupIds("co.simasoft.models.naif.task.activities",em);
        entities50.setGroupIds(groupId82);
        em.persist(entities50);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes51 = new Attributes();
        attributes51.setName("name");
        attributes51.setNullable(true);
        attributes51.setSingle(false);
//      ...................... Activities ........................
        Entities entity83 = new Entities();
        entity83 = findBean.nameEntities("Activities",em);
        attributes51.setEntities(entity83);
//      ...................... String ........................
        AttributesTypes attributesTypes84 = new AttributesTypes();
        attributesTypes84 = findBean.nameAttributesTypes("String",em);
        attributes51.setAttributesTypes(attributesTypes84);
        em.persist(attributes51);
        em.flush();

        Attributes attributes52 = new Attributes();
        attributes52.setName("detail");
        attributes52.setNullable(true);
        attributes52.setSingle(false);
//      ...................... Activities ........................
        Entities entity85 = new Entities();
        entity85 = findBean.nameEntities("Activities",em);
        attributes52.setEntities(entity85);
//      ...................... String ........................
        AttributesTypes attributesTypes86 = new AttributesTypes();
        attributesTypes86 = findBean.nameAttributesTypes("String",em);
        attributes52.setAttributesTypes(attributesTypes86);
        em.persist(attributes52);
        em.flush();

        Attributes attributes53 = new Attributes();
        attributes53.setName("startDate");
        attributes53.setNullable(true);
        attributes53.setSingle(false);
//      ...................... Activities ........................
        Entities entity87 = new Entities();
        entity87 = findBean.nameEntities("Activities",em);
        attributes53.setEntities(entity87);
//      ...................... Date ........................
        AttributesTypes attributesTypes88 = new AttributesTypes();
        attributesTypes88 = findBean.nameAttributesTypes("Date",em);
        attributes53.setAttributesTypes(attributesTypes88);
        em.persist(attributes53);
        em.flush();

        Attributes attributes54 = new Attributes();
        attributes54.setName("finalDate");
        attributes54.setNullable(true);
        attributes54.setSingle(false);
//      ...................... Activities ........................
        Entities entity89 = new Entities();
        entity89 = findBean.nameEntities("Activities",em);
        attributes54.setEntities(entity89);
//      ...................... Date ........................
        AttributesTypes attributesTypes90 = new AttributesTypes();
        attributesTypes90 = findBean.nameAttributesTypes("Date",em);
        attributes54.setAttributesTypes(attributesTypes90);
        em.persist(attributes54);
        em.flush();

        Attributes attributes55 = new Attributes();
        attributes55.setName("timelyDate");
        attributes55.setNullable(true);
        attributes55.setSingle(false);
//      ...................... Activities ........................
        Entities entity91 = new Entities();
        entity91 = findBean.nameEntities("Activities",em);
        attributes55.setEntities(entity91);
//      ...................... Date ........................
        AttributesTypes attributesTypes92 = new AttributesTypes();
        attributesTypes92 = findBean.nameAttributesTypes("Date",em);
        attributes55.setAttributesTypes(attributesTypes92);
        em.persist(attributes55);
        em.flush();

        Attributes attributes56 = new Attributes();
        attributes56.setName("untimelyDate");
        attributes56.setNullable(true);
        attributes56.setSingle(false);
//      ...................... Activities ........................
        Entities entity93 = new Entities();
        entity93 = findBean.nameEntities("Activities",em);
        attributes56.setEntities(entity93);
//      ...................... Date ........................
        AttributesTypes attributesTypes94 = new AttributesTypes();
        attributesTypes94 = findBean.nameAttributesTypes("Date",em);
        attributes56.setAttributesTypes(attributesTypes94);
        em.persist(attributes56);
        em.flush();

        Entities entities57 = new Entities();
        entities57.setName("ActivitiesTypes");
//      ...................... co.simasoft.models.naif.task.activities ........................
        GroupIds groupId95 = new GroupIds();
        groupId95 = findBean.groupIdGroupIds("co.simasoft.models.naif.task.activities",em);
        entities57.setGroupIds(groupId95);
        em.persist(entities57);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes58 = new Attributes();
        attributes58.setName("name");
        attributes58.setNullable(true);
        attributes58.setSingle(false);
//      ...................... ActivitiesTypes ........................
        Entities entity96 = new Entities();
        entity96 = findBean.nameEntities("ActivitiesTypes",em);
        attributes58.setEntities(entity96);
//      ...................... String ........................
        AttributesTypes attributesTypes97 = new AttributesTypes();
        attributesTypes97 = findBean.nameAttributesTypes("String",em);
        attributes58.setAttributesTypes(attributesTypes97);
        em.persist(attributes58);
        em.flush();

        GroupIds groupIds59 = new GroupIds();
        groupIds59.setGroupId("co.simasoft.models.naif.task.persons");
//      ...................... task ........................
        DomainModels domainModel98 = new DomainModels();
        domainModel98 = findBean.artifactIdDomainModels("task",em);
        groupIds59.setDomainModels(domainModel98);
        em.persist(groupIds59);
        em.flush();

//      ---------------------- Entities ------------------------

        Entities entities60 = new Entities();
        entities60.setName("Persons");
//      ...................... co.simasoft.models.naif.task.persons ........................
        GroupIds groupId99 = new GroupIds();
        groupId99 = findBean.groupIdGroupIds("co.simasoft.models.naif.task.persons",em);
        entities60.setGroupIds(groupId99);
        em.persist(entities60);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes61 = new Attributes();
        attributes61.setName("firstLastName");
        attributes61.setNullable(true);
        attributes61.setSingle(false);
//      ...................... Persons ........................
        Entities entity100 = new Entities();
        entity100 = findBean.nameEntities("Persons",em);
        attributes61.setEntities(entity100);
//      ...................... String ........................
        AttributesTypes attributesTypes101 = new AttributesTypes();
        attributesTypes101 = findBean.nameAttributesTypes("String",em);
        attributes61.setAttributesTypes(attributesTypes101);
        em.persist(attributes61);
        em.flush();

        Attributes attributes62 = new Attributes();
        attributes62.setName("secondLastName");
        attributes62.setNullable(true);
        attributes62.setSingle(false);
//      ...................... Persons ........................
        Entities entity102 = new Entities();
        entity102 = findBean.nameEntities("Persons",em);
        attributes62.setEntities(entity102);
//      ...................... String ........................
        AttributesTypes attributesTypes103 = new AttributesTypes();
        attributesTypes103 = findBean.nameAttributesTypes("String",em);
        attributes62.setAttributesTypes(attributesTypes103);
        em.persist(attributes62);
        em.flush();

        Attributes attributes63 = new Attributes();
        attributes63.setName("firstName");
        attributes63.setNullable(true);
        attributes63.setSingle(false);
//      ...................... Persons ........................
        Entities entity104 = new Entities();
        entity104 = findBean.nameEntities("Persons",em);
        attributes63.setEntities(entity104);
//      ...................... String ........................
        AttributesTypes attributesTypes105 = new AttributesTypes();
        attributesTypes105 = findBean.nameAttributesTypes("String",em);
        attributes63.setAttributesTypes(attributesTypes105);
        em.persist(attributes63);
        em.flush();

        Attributes attributes64 = new Attributes();
        attributes64.setName("secondName");
        attributes64.setNullable(true);
        attributes64.setSingle(false);
//      ...................... Persons ........................
        Entities entity106 = new Entities();
        entity106 = findBean.nameEntities("Persons",em);
        attributes64.setEntities(entity106);
//      ...................... String ........................
        AttributesTypes attributesTypes107 = new AttributesTypes();
        attributesTypes107 = findBean.nameAttributesTypes("String",em);
        attributes64.setAttributesTypes(attributesTypes107);
        em.persist(attributes64);
        em.flush();

        Attributes attributes65 = new Attributes();
        attributes65.setName("address");
        attributes65.setNullable(true);
        attributes65.setSingle(false);
//      ...................... Persons ........................
        Entities entity108 = new Entities();
        entity108 = findBean.nameEntities("Persons",em);
        attributes65.setEntities(entity108);
//      ...................... String ........................
        AttributesTypes attributesTypes109 = new AttributesTypes();
        attributesTypes109 = findBean.nameAttributesTypes("String",em);
        attributes65.setAttributesTypes(attributesTypes109);
        em.persist(attributes65);
        em.flush();

        Attributes attributes66 = new Attributes();
        attributes66.setName("telephones");
        attributes66.setNullable(true);
        attributes66.setSingle(false);
//      ...................... Persons ........................
        Entities entity110 = new Entities();
        entity110 = findBean.nameEntities("Persons",em);
        attributes66.setEntities(entity110);
//      ...................... String ........................
        AttributesTypes attributesTypes111 = new AttributesTypes();
        attributesTypes111 = findBean.nameAttributesTypes("String",em);
        attributes66.setAttributesTypes(attributesTypes111);
        em.persist(attributes66);
        em.flush();

        Attributes attributes67 = new Attributes();
        attributes67.setName("email");
        attributes67.setNullable(true);
        attributes67.setSingle(false);
//      ...................... Persons ........................
        Entities entity112 = new Entities();
        entity112 = findBean.nameEntities("Persons",em);
        attributes67.setEntities(entity112);
//      ...................... String ........................
        AttributesTypes attributesTypes113 = new AttributesTypes();
        attributesTypes113 = findBean.nameAttributesTypes("String",em);
        attributes67.setAttributesTypes(attributesTypes113);
        em.persist(attributes67);
        em.flush();

        Attributes attributes68 = new Attributes();
        attributes68.setName("skype");
        attributes68.setNullable(true);
        attributes68.setSingle(false);
//      ...................... Persons ........................
        Entities entity114 = new Entities();
        entity114 = findBean.nameEntities("Persons",em);
        attributes68.setEntities(entity114);
//      ...................... String ........................
        AttributesTypes attributesTypes115 = new AttributesTypes();
        attributesTypes115 = findBean.nameAttributesTypes("String",em);
        attributes68.setAttributesTypes(attributesTypes115);
        em.persist(attributes68);
        em.flush();

        Entities entities69 = new Entities();
        entities69.setName("PersonalType");
//      ...................... co.simasoft.models.naif.task.persons ........................
        GroupIds groupId116 = new GroupIds();
        groupId116 = findBean.groupIdGroupIds("co.simasoft.models.naif.task.persons",em);
        entities69.setGroupIds(groupId116);
        em.persist(entities69);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes70 = new Attributes();
        attributes70.setName("name");
        attributes70.setNullable(true);
        attributes70.setSingle(false);
//      ...................... PersonalType ........................
        Entities entity117 = new Entities();
        entity117 = findBean.nameEntities("PersonalType",em);
        attributes70.setEntities(entity117);
//      ...................... String ........................
        AttributesTypes attributesTypes118 = new AttributesTypes();
        attributesTypes118 = findBean.nameAttributesTypes("String",em);
        attributes70.setAttributesTypes(attributesTypes118);
        em.persist(attributes70);
        em.flush();

//      ---------------------- Relationships ------------------------

/*
. Series . 1..* DocumentalsUnits rolA: rolB:

. Sections . 1..* Activities rolA:from rolB: OK

. SectionsTypes . 1..* Sections rolA: rolB:

. Funds . 1..* Sections rolA: rolB:

. DocumentsTypes . 1..* Series rolA: rolB:

. Sections . 1..* Sections rolA: rolB:

. Series . *..* Sites rolA:from rolB: OK

. DocumentalsSupports . 1..* DocumentalsUnits rolA: rolB:

. Series . 1..* Series rolA: rolB:

. Sections . *..* Series rolA:from rolB: OK

. Sections . *..* Tasks rolA:from rolB: OK

. ConservationUnits . 1..* DocumentalsUnits rolA: rolB:

*/
        Relationships relationships1 = new Relationships();
        relationships1.setOptionality(true);
        relationships1.setIsEmbedded(false);
//      ...................... Series ........................
        Entities entities119 = new Entities();
        entities119 = findBean.nameEntities("Series",em);
        relationships1.setFrom(entities119);
//      ...................... DocumentalsUnits ........................
        Entities entities120 = new Entities();
        entities120 = findBean.nameEntities("DocumentalsUnits",em);
        relationships1.setTo(entities120);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities121 = new Cardinalities();
        cardinalities121 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships1.setCardinalities(cardinalities121);
        em.persist(relationships1);
        em.flush();

        Relationships relationships2 = new Relationships();
        relationships2.setOptionality(true);
        relationships2.setIsEmbedded(false);
//      ...................... Sections ........................
        Entities entities122 = new Entities();
        entities122 = findBean.nameEntities("Sections",em);
        relationships2.setFrom(entities122);
//      ...................... Activities ........................
        Entities entities123 = new Entities();
        entities123 = findBean.nameEntities("Activities",em);
        relationships2.setTo(entities123);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities124 = new Cardinalities();
        cardinalities124 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships2.setCardinalities(cardinalities124);
        em.persist(relationships2);
        em.flush();

        Relationships relationships3 = new Relationships();
        relationships3.setOptionality(true);
        relationships3.setIsEmbedded(false);
//      ...................... SectionsTypes ........................
        Entities entities125 = new Entities();
        entities125 = findBean.nameEntities("SectionsTypes",em);
        relationships3.setFrom(entities125);
//      ...................... Sections ........................
        Entities entities126 = new Entities();
        entities126 = findBean.nameEntities("Sections",em);
        relationships3.setTo(entities126);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities127 = new Cardinalities();
        cardinalities127 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships3.setCardinalities(cardinalities127);
        em.persist(relationships3);
        em.flush();

        Relationships relationships4 = new Relationships();
        relationships4.setOptionality(true);
        relationships4.setIsEmbedded(false);
//      ...................... Funds ........................
        Entities entities128 = new Entities();
        entities128 = findBean.nameEntities("Funds",em);
        relationships4.setFrom(entities128);
//      ...................... Sections ........................
        Entities entities129 = new Entities();
        entities129 = findBean.nameEntities("Sections",em);
        relationships4.setTo(entities129);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities130 = new Cardinalities();
        cardinalities130 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships4.setCardinalities(cardinalities130);
        em.persist(relationships4);
        em.flush();

        Relationships relationships5 = new Relationships();
        relationships5.setOptionality(true);
        relationships5.setIsEmbedded(false);
//      ...................... DocumentsTypes ........................
        Entities entities131 = new Entities();
        entities131 = findBean.nameEntities("DocumentsTypes",em);
        relationships5.setFrom(entities131);
//      ...................... Series ........................
        Entities entities132 = new Entities();
        entities132 = findBean.nameEntities("Series",em);
        relationships5.setTo(entities132);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities133 = new Cardinalities();
        cardinalities133 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships5.setCardinalities(cardinalities133);
        em.persist(relationships5);
        em.flush();

        Relationships relationships6 = new Relationships();
        relationships6.setOptionality(true);
        relationships6.setIsEmbedded(false);
//      ...................... Sections ........................
        Entities entities134 = new Entities();
        entities134 = findBean.nameEntities("Sections",em);
        relationships6.setFrom(entities134);
//      ...................... Sections ........................
        Entities entities135 = new Entities();
        entities135 = findBean.nameEntities("Sections",em);
        relationships6.setTo(entities135);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities136 = new Cardinalities();
        cardinalities136 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships6.setCardinalities(cardinalities136);
        em.persist(relationships6);
        em.flush();

        Relationships relationships7 = new Relationships();
        relationships7.setOptionality(true);
        relationships7.setIsEmbedded(false);
//      ...................... Series ........................
        Entities entities137 = new Entities();
        entities137 = findBean.nameEntities("Series",em);
        relationships7.setFrom(entities137);
//      ...................... Sites ........................
        Entities entities138 = new Entities();
        entities138 = findBean.nameEntities("Sites",em);
        relationships7.setTo(entities138);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities139 = new Cardinalities();
        cardinalities139 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships7.setCardinalities(cardinalities139);
        em.persist(relationships7);
        em.flush();

        Relationships relationships8 = new Relationships();
        relationships8.setOptionality(true);
        relationships8.setIsEmbedded(false);
//      ...................... DocumentalsSupports ........................
        Entities entities140 = new Entities();
        entities140 = findBean.nameEntities("DocumentalsSupports",em);
        relationships8.setFrom(entities140);
//      ...................... DocumentalsUnits ........................
        Entities entities141 = new Entities();
        entities141 = findBean.nameEntities("DocumentalsUnits",em);
        relationships8.setTo(entities141);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities142 = new Cardinalities();
        cardinalities142 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships8.setCardinalities(cardinalities142);
        em.persist(relationships8);
        em.flush();

        Relationships relationships9 = new Relationships();
        relationships9.setOptionality(true);
        relationships9.setIsEmbedded(false);
//      ...................... Series ........................
        Entities entities143 = new Entities();
        entities143 = findBean.nameEntities("Series",em);
        relationships9.setFrom(entities143);
//      ...................... Series ........................
        Entities entities144 = new Entities();
        entities144 = findBean.nameEntities("Series",em);
        relationships9.setTo(entities144);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities145 = new Cardinalities();
        cardinalities145 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships9.setCardinalities(cardinalities145);
        em.persist(relationships9);
        em.flush();

        Relationships relationships10 = new Relationships();
        relationships10.setOptionality(true);
        relationships10.setIsEmbedded(false);
//      ...................... Sections ........................
        Entities entities146 = new Entities();
        entities146 = findBean.nameEntities("Sections",em);
        relationships10.setFrom(entities146);
//      ...................... Series ........................
        Entities entities147 = new Entities();
        entities147 = findBean.nameEntities("Series",em);
        relationships10.setTo(entities147);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities148 = new Cardinalities();
        cardinalities148 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships10.setCardinalities(cardinalities148);
        em.persist(relationships10);
        em.flush();

        Relationships relationships11 = new Relationships();
        relationships11.setOptionality(true);
        relationships11.setIsEmbedded(false);
//      ...................... Sections ........................
        Entities entities149 = new Entities();
        entities149 = findBean.nameEntities("Sections",em);
        relationships11.setFrom(entities149);
//      ...................... Tasks ........................
        Entities entities150 = new Entities();
        entities150 = findBean.nameEntities("Tasks",em);
        relationships11.setTo(entities150);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities151 = new Cardinalities();
        cardinalities151 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships11.setCardinalities(cardinalities151);
        em.persist(relationships11);
        em.flush();

        Relationships relationships12 = new Relationships();
        relationships12.setOptionality(true);
        relationships12.setIsEmbedded(false);
//      ...................... ConservationUnits ........................
        Entities entities152 = new Entities();
        entities152 = findBean.nameEntities("ConservationUnits",em);
        relationships12.setFrom(entities152);
//      ...................... DocumentalsUnits ........................
        Entities entities153 = new Entities();
        entities153 = findBean.nameEntities("DocumentalsUnits",em);
        relationships12.setTo(entities153);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities154 = new Cardinalities();
        cardinalities154 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships12.setCardinalities(cardinalities154);
        em.persist(relationships12);
        em.flush();

/*
. SitesTypes . *..* Sites rolA:from rolB: OK

*/
        Relationships relationships13 = new Relationships();
        relationships13.setOptionality(true);
        relationships13.setIsEmbedded(false);
//      ...................... SitesTypes ........................
        Entities entities155 = new Entities();
        entities155 = findBean.nameEntities("SitesTypes",em);
        relationships13.setFrom(entities155);
//      ...................... Sites ........................
        Entities entities156 = new Entities();
        entities156 = findBean.nameEntities("Sites",em);
        relationships13.setTo(entities156);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities157 = new Cardinalities();
        cardinalities157 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships13.setCardinalities(cardinalities157);
        em.persist(relationships13);
        em.flush();

/*
. Tasks . 1..* Sites rolA:from rolB: OK

. ActivitiesTypes . 1..* Activities rolA: rolB:

. Calendars . 1..* Activities rolA: rolB:

. Activities . 1..* Tasks rolA: rolB:

. Activities . *..* Guides rolA:from rolB: OK

. Tasks . 1..* Diaries rolA: rolB:

. Activities . 1..* Activities rolA: rolB:

. Activities . *..* Sites rolA:from rolB: OK

*/
        Relationships relationships14 = new Relationships();
        relationships14.setOptionality(true);
        relationships14.setIsEmbedded(false);
//      ...................... Tasks ........................
        Entities entities158 = new Entities();
        entities158 = findBean.nameEntities("Tasks",em);
        relationships14.setFrom(entities158);
//      ...................... Sites ........................
        Entities entities159 = new Entities();
        entities159 = findBean.nameEntities("Sites",em);
        relationships14.setTo(entities159);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities160 = new Cardinalities();
        cardinalities160 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships14.setCardinalities(cardinalities160);
        em.persist(relationships14);
        em.flush();

        Relationships relationships15 = new Relationships();
        relationships15.setOptionality(true);
        relationships15.setIsEmbedded(false);
//      ...................... ActivitiesTypes ........................
        Entities entities161 = new Entities();
        entities161 = findBean.nameEntities("ActivitiesTypes",em);
        relationships15.setFrom(entities161);
//      ...................... Activities ........................
        Entities entities162 = new Entities();
        entities162 = findBean.nameEntities("Activities",em);
        relationships15.setTo(entities162);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities163 = new Cardinalities();
        cardinalities163 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships15.setCardinalities(cardinalities163);
        em.persist(relationships15);
        em.flush();

        Relationships relationships16 = new Relationships();
        relationships16.setOptionality(true);
        relationships16.setIsEmbedded(false);
//      ...................... Calendars ........................
        Entities entities164 = new Entities();
        entities164 = findBean.nameEntities("Calendars",em);
        relationships16.setFrom(entities164);
//      ...................... Activities ........................
        Entities entities165 = new Entities();
        entities165 = findBean.nameEntities("Activities",em);
        relationships16.setTo(entities165);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities166 = new Cardinalities();
        cardinalities166 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships16.setCardinalities(cardinalities166);
        em.persist(relationships16);
        em.flush();

        Relationships relationships17 = new Relationships();
        relationships17.setOptionality(true);
        relationships17.setIsEmbedded(false);
//      ...................... Activities ........................
        Entities entities167 = new Entities();
        entities167 = findBean.nameEntities("Activities",em);
        relationships17.setFrom(entities167);
//      ...................... Tasks ........................
        Entities entities168 = new Entities();
        entities168 = findBean.nameEntities("Tasks",em);
        relationships17.setTo(entities168);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities169 = new Cardinalities();
        cardinalities169 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships17.setCardinalities(cardinalities169);
        em.persist(relationships17);
        em.flush();

        Relationships relationships18 = new Relationships();
        relationships18.setOptionality(true);
        relationships18.setIsEmbedded(false);
//      ...................... Activities ........................
        Entities entities170 = new Entities();
        entities170 = findBean.nameEntities("Activities",em);
        relationships18.setFrom(entities170);
//      ...................... Guides ........................
        Entities entities171 = new Entities();
        entities171 = findBean.nameEntities("Guides",em);
        relationships18.setTo(entities171);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities172 = new Cardinalities();
        cardinalities172 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships18.setCardinalities(cardinalities172);
        em.persist(relationships18);
        em.flush();

        Relationships relationships19 = new Relationships();
        relationships19.setOptionality(true);
        relationships19.setIsEmbedded(false);
//      ...................... Tasks ........................
        Entities entities173 = new Entities();
        entities173 = findBean.nameEntities("Tasks",em);
        relationships19.setFrom(entities173);
//      ...................... Diaries ........................
        Entities entities174 = new Entities();
        entities174 = findBean.nameEntities("Diaries",em);
        relationships19.setTo(entities174);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities175 = new Cardinalities();
        cardinalities175 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships19.setCardinalities(cardinalities175);
        em.persist(relationships19);
        em.flush();

        Relationships relationships20 = new Relationships();
        relationships20.setOptionality(true);
        relationships20.setIsEmbedded(false);
//      ...................... Activities ........................
        Entities entities176 = new Entities();
        entities176 = findBean.nameEntities("Activities",em);
        relationships20.setFrom(entities176);
//      ...................... Activities ........................
        Entities entities177 = new Entities();
        entities177 = findBean.nameEntities("Activities",em);
        relationships20.setTo(entities177);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities178 = new Cardinalities();
        cardinalities178 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships20.setCardinalities(cardinalities178);
        em.persist(relationships20);
        em.flush();

        Relationships relationships21 = new Relationships();
        relationships21.setOptionality(true);
        relationships21.setIsEmbedded(false);
//      ...................... Activities ........................
        Entities entities179 = new Entities();
        entities179 = findBean.nameEntities("Activities",em);
        relationships21.setFrom(entities179);
//      ...................... Sites ........................
        Entities entities180 = new Entities();
        entities180 = findBean.nameEntities("Sites",em);
        relationships21.setTo(entities180);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities181 = new Cardinalities();
        cardinalities181 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships21.setCardinalities(cardinalities181);
        em.persist(relationships21);
        em.flush();

/*
. Persons . 1..* Activities rolA: rolB:

. Persons . 1..* Sections rolA: rolB:

. PersonalType . 1..* Persons rolA: rolB:

*/
        Relationships relationships22 = new Relationships();
        relationships22.setOptionality(true);
        relationships22.setIsEmbedded(false);
//      ...................... Persons ........................
        Entities entities182 = new Entities();
        entities182 = findBean.nameEntities("Persons",em);
        relationships22.setFrom(entities182);
//      ...................... Activities ........................
        Entities entities183 = new Entities();
        entities183 = findBean.nameEntities("Activities",em);
        relationships22.setTo(entities183);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities184 = new Cardinalities();
        cardinalities184 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships22.setCardinalities(cardinalities184);
        em.persist(relationships22);
        em.flush();

        Relationships relationships23 = new Relationships();
        relationships23.setOptionality(true);
        relationships23.setIsEmbedded(false);
//      ...................... Persons ........................
        Entities entities185 = new Entities();
        entities185 = findBean.nameEntities("Persons",em);
        relationships23.setFrom(entities185);
//      ...................... Sections ........................
        Entities entities186 = new Entities();
        entities186 = findBean.nameEntities("Sections",em);
        relationships23.setTo(entities186);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities187 = new Cardinalities();
        cardinalities187 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships23.setCardinalities(cardinalities187);
        em.persist(relationships23);
        em.flush();

        Relationships relationships24 = new Relationships();
        relationships24.setOptionality(true);
        relationships24.setIsEmbedded(false);
//      ...................... PersonalType ........................
        Entities entities188 = new Entities();
        entities188 = findBean.nameEntities("PersonalType",em);
        relationships24.setFrom(entities188);
//      ...................... Persons ........................
        Entities entities189 = new Entities();
        entities189 = findBean.nameEntities("Persons",em);
        relationships24.setTo(entities189);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities190 = new Cardinalities();
        cardinalities190 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships24.setCardinalities(cardinalities190);
        em.persist(relationships24);
        em.flush();

    } // data()

} // task
