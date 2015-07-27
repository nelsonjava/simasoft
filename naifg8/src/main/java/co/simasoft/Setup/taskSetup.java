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
        groupIds1.setGroupId("co.simasoft.models.naif.task.persons");
//      ...................... task ........................
        DomainModels domainModel1 = new DomainModels();
        domainModel1 = findBean.artifactIdDomainModels("task",em);
        groupIds1.setDomainModels(domainModel1);
        em.persist(groupIds1);
        em.flush();

//      ---------------------- Entities ------------------------

        Entities entities2 = new Entities();
        entities2.setName("PersonalType");
//      ...................... co.simasoft.models.naif.task.persons ........................
        GroupIds groupId2 = new GroupIds();
        groupId2 = findBean.groupIdGroupIds("co.simasoft.models.naif.task.persons",em);
        entities2.setGroupIds(groupId2);
        em.persist(entities2);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes3 = new Attributes();
        attributes3.setName("name");
        attributes3.setNullable(true);
        attributes3.setSingle(false);
//      ...................... PersonalType ........................
        Entities entity3 = new Entities();
        entity3 = findBean.nameEntities("PersonalType",em);
        attributes3.setEntities(entity3);
//      ...................... String ........................
        AttributesTypes attributesTypes4 = new AttributesTypes();
        attributesTypes4 = findBean.nameAttributesTypes("String",em);
        attributes3.setAttributesTypes(attributesTypes4);
        em.persist(attributes3);
        em.flush();

        Entities entities4 = new Entities();
        entities4.setName("Persons");
//      ...................... co.simasoft.models.naif.task.persons ........................
        GroupIds groupId5 = new GroupIds();
        groupId5 = findBean.groupIdGroupIds("co.simasoft.models.naif.task.persons",em);
        entities4.setGroupIds(groupId5);
        em.persist(entities4);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes5 = new Attributes();
        attributes5.setName("firstLastName");
        attributes5.setNullable(true);
        attributes5.setSingle(false);
//      ...................... Persons ........................
        Entities entity6 = new Entities();
        entity6 = findBean.nameEntities("Persons",em);
        attributes5.setEntities(entity6);
//      ...................... String ........................
        AttributesTypes attributesTypes7 = new AttributesTypes();
        attributesTypes7 = findBean.nameAttributesTypes("String",em);
        attributes5.setAttributesTypes(attributesTypes7);
        em.persist(attributes5);
        em.flush();

        Attributes attributes6 = new Attributes();
        attributes6.setName("secondLastName");
        attributes6.setNullable(true);
        attributes6.setSingle(false);
//      ...................... Persons ........................
        Entities entity8 = new Entities();
        entity8 = findBean.nameEntities("Persons",em);
        attributes6.setEntities(entity8);
//      ...................... String ........................
        AttributesTypes attributesTypes9 = new AttributesTypes();
        attributesTypes9 = findBean.nameAttributesTypes("String",em);
        attributes6.setAttributesTypes(attributesTypes9);
        em.persist(attributes6);
        em.flush();

        Attributes attributes7 = new Attributes();
        attributes7.setName("firstName");
        attributes7.setNullable(true);
        attributes7.setSingle(false);
//      ...................... Persons ........................
        Entities entity10 = new Entities();
        entity10 = findBean.nameEntities("Persons",em);
        attributes7.setEntities(entity10);
//      ...................... String ........................
        AttributesTypes attributesTypes11 = new AttributesTypes();
        attributesTypes11 = findBean.nameAttributesTypes("String",em);
        attributes7.setAttributesTypes(attributesTypes11);
        em.persist(attributes7);
        em.flush();

        Attributes attributes8 = new Attributes();
        attributes8.setName("secondName");
        attributes8.setNullable(true);
        attributes8.setSingle(false);
//      ...................... Persons ........................
        Entities entity12 = new Entities();
        entity12 = findBean.nameEntities("Persons",em);
        attributes8.setEntities(entity12);
//      ...................... String ........................
        AttributesTypes attributesTypes13 = new AttributesTypes();
        attributesTypes13 = findBean.nameAttributesTypes("String",em);
        attributes8.setAttributesTypes(attributesTypes13);
        em.persist(attributes8);
        em.flush();

        Attributes attributes9 = new Attributes();
        attributes9.setName("address");
        attributes9.setNullable(true);
        attributes9.setSingle(false);
//      ...................... Persons ........................
        Entities entity14 = new Entities();
        entity14 = findBean.nameEntities("Persons",em);
        attributes9.setEntities(entity14);
//      ...................... String ........................
        AttributesTypes attributesTypes15 = new AttributesTypes();
        attributesTypes15 = findBean.nameAttributesTypes("String",em);
        attributes9.setAttributesTypes(attributesTypes15);
        em.persist(attributes9);
        em.flush();

        Attributes attributes10 = new Attributes();
        attributes10.setName("telephones");
        attributes10.setNullable(true);
        attributes10.setSingle(false);
//      ...................... Persons ........................
        Entities entity16 = new Entities();
        entity16 = findBean.nameEntities("Persons",em);
        attributes10.setEntities(entity16);
//      ...................... String ........................
        AttributesTypes attributesTypes17 = new AttributesTypes();
        attributesTypes17 = findBean.nameAttributesTypes("String",em);
        attributes10.setAttributesTypes(attributesTypes17);
        em.persist(attributes10);
        em.flush();

        Attributes attributes11 = new Attributes();
        attributes11.setName("email");
        attributes11.setNullable(true);
        attributes11.setSingle(false);
//      ...................... Persons ........................
        Entities entity18 = new Entities();
        entity18 = findBean.nameEntities("Persons",em);
        attributes11.setEntities(entity18);
//      ...................... String ........................
        AttributesTypes attributesTypes19 = new AttributesTypes();
        attributesTypes19 = findBean.nameAttributesTypes("String",em);
        attributes11.setAttributesTypes(attributesTypes19);
        em.persist(attributes11);
        em.flush();

        Attributes attributes12 = new Attributes();
        attributes12.setName("skype");
        attributes12.setNullable(true);
        attributes12.setSingle(false);
//      ...................... Persons ........................
        Entities entity20 = new Entities();
        entity20 = findBean.nameEntities("Persons",em);
        attributes12.setEntities(entity20);
//      ...................... String ........................
        AttributesTypes attributesTypes21 = new AttributesTypes();
        attributesTypes21 = findBean.nameAttributesTypes("String",em);
        attributes12.setAttributesTypes(attributesTypes21);
        em.persist(attributes12);
        em.flush();

        GroupIds groupIds13 = new GroupIds();
        groupIds13.setGroupId("co.simasoft.models.naif.task.archival");
//      ...................... task ........................
        DomainModels domainModel22 = new DomainModels();
        domainModel22 = findBean.artifactIdDomainModels("task",em);
        groupIds13.setDomainModels(domainModel22);
        em.persist(groupIds13);
        em.flush();

//      ---------------------- Entities ------------------------

        Entities entities14 = new Entities();
        entities14.setName("DocumentsTypes");
//      ...................... co.simasoft.models.naif.task.archival ........................
        GroupIds groupId23 = new GroupIds();
        groupId23 = findBean.groupIdGroupIds("co.simasoft.models.naif.task.archival",em);
        entities14.setGroupIds(groupId23);
        em.persist(entities14);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes15 = new Attributes();
        attributes15.setName("name");
        attributes15.setNullable(true);
        attributes15.setSingle(false);
//      ...................... DocumentsTypes ........................
        Entities entity24 = new Entities();
        entity24 = findBean.nameEntities("DocumentsTypes",em);
        attributes15.setEntities(entity24);
//      ...................... String ........................
        AttributesTypes attributesTypes25 = new AttributesTypes();
        attributesTypes25 = findBean.nameAttributesTypes("String",em);
        attributes15.setAttributesTypes(attributesTypes25);
        em.persist(attributes15);
        em.flush();

        Entities entities16 = new Entities();
        entities16.setName("DocumentalsSupports");
//      ...................... co.simasoft.models.naif.task.archival ........................
        GroupIds groupId26 = new GroupIds();
        groupId26 = findBean.groupIdGroupIds("co.simasoft.models.naif.task.archival",em);
        entities16.setGroupIds(groupId26);
        em.persist(entities16);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes17 = new Attributes();
        attributes17.setName("code");
        attributes17.setNullable(true);
        attributes17.setSingle(false);
//      ...................... DocumentalsSupports ........................
        Entities entity27 = new Entities();
        entity27 = findBean.nameEntities("DocumentalsSupports",em);
        attributes17.setEntities(entity27);
//      ...................... String ........................
        AttributesTypes attributesTypes28 = new AttributesTypes();
        attributesTypes28 = findBean.nameAttributesTypes("String",em);
        attributes17.setAttributesTypes(attributesTypes28);
        em.persist(attributes17);
        em.flush();

        Attributes attributes18 = new Attributes();
        attributes18.setName("name");
        attributes18.setNullable(true);
        attributes18.setSingle(false);
//      ...................... DocumentalsSupports ........................
        Entities entity29 = new Entities();
        entity29 = findBean.nameEntities("DocumentalsSupports",em);
        attributes18.setEntities(entity29);
//      ...................... String ........................
        AttributesTypes attributesTypes30 = new AttributesTypes();
        attributesTypes30 = findBean.nameAttributesTypes("String",em);
        attributes18.setAttributesTypes(attributesTypes30);
        em.persist(attributes18);
        em.flush();

        Entities entities19 = new Entities();
        entities19.setName("Series");
//      ...................... co.simasoft.models.naif.task.archival ........................
        GroupIds groupId31 = new GroupIds();
        groupId31 = findBean.groupIdGroupIds("co.simasoft.models.naif.task.archival",em);
        entities19.setGroupIds(groupId31);
        em.persist(entities19);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes20 = new Attributes();
        attributes20.setName("code");
        attributes20.setNullable(true);
        attributes20.setSingle(false);
//      ...................... Series ........................
        Entities entity32 = new Entities();
        entity32 = findBean.nameEntities("Series",em);
        attributes20.setEntities(entity32);
//      ...................... String ........................
        AttributesTypes attributesTypes33 = new AttributesTypes();
        attributesTypes33 = findBean.nameAttributesTypes("String",em);
        attributes20.setAttributesTypes(attributesTypes33);
        em.persist(attributes20);
        em.flush();

        Attributes attributes21 = new Attributes();
        attributes21.setName("name");
        attributes21.setNullable(true);
        attributes21.setSingle(false);
//      ...................... Series ........................
        Entities entity34 = new Entities();
        entity34 = findBean.nameEntities("Series",em);
        attributes21.setEntities(entity34);
//      ...................... String ........................
        AttributesTypes attributesTypes35 = new AttributesTypes();
        attributesTypes35 = findBean.nameAttributesTypes("String",em);
        attributes21.setAttributesTypes(attributesTypes35);
        em.persist(attributes21);
        em.flush();

        Attributes attributes22 = new Attributes();
        attributes22.setName("located");
        attributes22.setNullable(true);
        attributes22.setSingle(false);
//      ...................... Series ........................
        Entities entity36 = new Entities();
        entity36 = findBean.nameEntities("Series",em);
        attributes22.setEntities(entity36);
//      ...................... String ........................
        AttributesTypes attributesTypes37 = new AttributesTypes();
        attributesTypes37 = findBean.nameAttributesTypes("String",em);
        attributes22.setAttributesTypes(attributesTypes37);
        em.persist(attributes22);
        em.flush();

        Attributes attributes23 = new Attributes();
        attributes23.setName("link");
        attributes23.setNullable(true);
        attributes23.setSingle(false);
//      ...................... Series ........................
        Entities entity38 = new Entities();
        entity38 = findBean.nameEntities("Series",em);
        attributes23.setEntities(entity38);
//      ...................... String ........................
        AttributesTypes attributesTypes39 = new AttributesTypes();
        attributesTypes39 = findBean.nameAttributesTypes("String",em);
        attributes23.setAttributesTypes(attributesTypes39);
        em.persist(attributes23);
        em.flush();

        Entities entities24 = new Entities();
        entities24.setName("ConservationUnits");
//      ...................... co.simasoft.models.naif.task.archival ........................
        GroupIds groupId40 = new GroupIds();
        groupId40 = findBean.groupIdGroupIds("co.simasoft.models.naif.task.archival",em);
        entities24.setGroupIds(groupId40);
        em.persist(entities24);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes25 = new Attributes();
        attributes25.setName("code");
        attributes25.setNullable(true);
        attributes25.setSingle(false);
//      ...................... ConservationUnits ........................
        Entities entity41 = new Entities();
        entity41 = findBean.nameEntities("ConservationUnits",em);
        attributes25.setEntities(entity41);
//      ...................... String ........................
        AttributesTypes attributesTypes42 = new AttributesTypes();
        attributesTypes42 = findBean.nameAttributesTypes("String",em);
        attributes25.setAttributesTypes(attributesTypes42);
        em.persist(attributes25);
        em.flush();

        Attributes attributes26 = new Attributes();
        attributes26.setName("name");
        attributes26.setNullable(true);
        attributes26.setSingle(false);
//      ...................... ConservationUnits ........................
        Entities entity43 = new Entities();
        entity43 = findBean.nameEntities("ConservationUnits",em);
        attributes26.setEntities(entity43);
//      ...................... String ........................
        AttributesTypes attributesTypes44 = new AttributesTypes();
        attributesTypes44 = findBean.nameAttributesTypes("String",em);
        attributes26.setAttributesTypes(attributesTypes44);
        em.persist(attributes26);
        em.flush();

        Entities entities27 = new Entities();
        entities27.setName("DocumentalsUnits");
//      ...................... co.simasoft.models.naif.task.archival ........................
        GroupIds groupId45 = new GroupIds();
        groupId45 = findBean.groupIdGroupIds("co.simasoft.models.naif.task.archival",em);
        entities27.setGroupIds(groupId45);
        em.persist(entities27);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes28 = new Attributes();
        attributes28.setName("name");
        attributes28.setNullable(true);
        attributes28.setSingle(false);
//      ...................... DocumentalsUnits ........................
        Entities entity46 = new Entities();
        entity46 = findBean.nameEntities("DocumentalsUnits",em);
        attributes28.setEntities(entity46);
//      ...................... String ........................
        AttributesTypes attributesTypes47 = new AttributesTypes();
        attributesTypes47 = findBean.nameAttributesTypes("String",em);
        attributes28.setAttributesTypes(attributesTypes47);
        em.persist(attributes28);
        em.flush();

        Attributes attributes29 = new Attributes();
        attributes29.setName("creationDate");
        attributes29.setNullable(true);
        attributes29.setSingle(false);
//      ...................... DocumentalsUnits ........................
        Entities entity48 = new Entities();
        entity48 = findBean.nameEntities("DocumentalsUnits",em);
        attributes29.setEntities(entity48);
//      ...................... Date ........................
        AttributesTypes attributesTypes49 = new AttributesTypes();
        attributesTypes49 = findBean.nameAttributesTypes("Date",em);
        attributes29.setAttributesTypes(attributesTypes49);
        em.persist(attributes29);
        em.flush();

        Entities entities30 = new Entities();
        entities30.setName("OriginalOrder");
//      ...................... co.simasoft.models.naif.task.archival ........................
        GroupIds groupId50 = new GroupIds();
        groupId50 = findBean.groupIdGroupIds("co.simasoft.models.naif.task.archival",em);
        entities30.setGroupIds(groupId50);
        em.persist(entities30);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes31 = new Attributes();
        attributes31.setName("entryDate");
        attributes31.setNullable(true);
        attributes31.setSingle(false);
//      ...................... OriginalOrder ........................
        Entities entity51 = new Entities();
        entity51 = findBean.nameEntities("OriginalOrder",em);
        attributes31.setEntities(entity51);
//      ...................... Date ........................
        AttributesTypes attributesTypes52 = new AttributesTypes();
        attributesTypes52 = findBean.nameAttributesTypes("Date",em);
        attributes31.setAttributesTypes(attributesTypes52);
        em.persist(attributes31);
        em.flush();

        Attributes attributes32 = new Attributes();
        attributes32.setName("startDate");
        attributes32.setNullable(true);
        attributes32.setSingle(false);
//      ...................... OriginalOrder ........................
        Entities entity53 = new Entities();
        entity53 = findBean.nameEntities("OriginalOrder",em);
        attributes32.setEntities(entity53);
//      ...................... Date ........................
        AttributesTypes attributesTypes54 = new AttributesTypes();
        attributesTypes54 = findBean.nameAttributesTypes("Date",em);
        attributes32.setAttributesTypes(attributesTypes54);
        em.persist(attributes32);
        em.flush();

        Attributes attributes33 = new Attributes();
        attributes33.setName("finalDate");
        attributes33.setNullable(true);
        attributes33.setSingle(false);
//      ...................... OriginalOrder ........................
        Entities entity55 = new Entities();
        entity55 = findBean.nameEntities("OriginalOrder",em);
        attributes33.setEntities(entity55);
//      ...................... Date ........................
        AttributesTypes attributesTypes56 = new AttributesTypes();
        attributesTypes56 = findBean.nameAttributesTypes("Date",em);
        attributes33.setAttributesTypes(attributesTypes56);
        em.persist(attributes33);
        em.flush();

        Attributes attributes34 = new Attributes();
        attributes34.setName("folios");
        attributes34.setNullable(true);
        attributes34.setSingle(false);
//      ...................... OriginalOrder ........................
        Entities entity57 = new Entities();
        entity57 = findBean.nameEntities("OriginalOrder",em);
        attributes34.setEntities(entity57);
//      ...................... Integer ........................
        AttributesTypes attributesTypes58 = new AttributesTypes();
        attributesTypes58 = findBean.nameAttributesTypes("Integer",em);
        attributes34.setAttributesTypes(attributesTypes58);
        em.persist(attributes34);
        em.flush();

        Attributes attributes35 = new Attributes();
        attributes35.setName("link");
        attributes35.setNullable(true);
        attributes35.setSingle(false);
//      ...................... OriginalOrder ........................
        Entities entity59 = new Entities();
        entity59 = findBean.nameEntities("OriginalOrder",em);
        attributes35.setEntities(entity59);
//      ...................... String ........................
        AttributesTypes attributesTypes60 = new AttributesTypes();
        attributesTypes60 = findBean.nameAttributesTypes("String",em);
        attributes35.setAttributesTypes(attributesTypes60);
        em.persist(attributes35);
        em.flush();

        Attributes attributes36 = new Attributes();
        attributes36.setName("located");
        attributes36.setNullable(true);
        attributes36.setSingle(false);
//      ...................... OriginalOrder ........................
        Entities entity61 = new Entities();
        entity61 = findBean.nameEntities("OriginalOrder",em);
        attributes36.setEntities(entity61);
//      ...................... String ........................
        AttributesTypes attributesTypes62 = new AttributesTypes();
        attributesTypes62 = findBean.nameAttributesTypes("String",em);
        attributes36.setAttributesTypes(attributesTypes62);
        em.persist(attributes36);
        em.flush();

        Entities entities37 = new Entities();
        entities37.setName("Funds");
//      ...................... co.simasoft.models.naif.task.archival ........................
        GroupIds groupId63 = new GroupIds();
        groupId63 = findBean.groupIdGroupIds("co.simasoft.models.naif.task.archival",em);
        entities37.setGroupIds(groupId63);
        em.persist(entities37);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes38 = new Attributes();
        attributes38.setName("code");
        attributes38.setNullable(true);
        attributes38.setSingle(false);
//      ...................... Funds ........................
        Entities entity64 = new Entities();
        entity64 = findBean.nameEntities("Funds",em);
        attributes38.setEntities(entity64);
//      ...................... String ........................
        AttributesTypes attributesTypes65 = new AttributesTypes();
        attributesTypes65 = findBean.nameAttributesTypes("String",em);
        attributes38.setAttributesTypes(attributesTypes65);
        em.persist(attributes38);
        em.flush();

        Attributes attributes39 = new Attributes();
        attributes39.setName("name");
        attributes39.setNullable(true);
        attributes39.setSingle(false);
//      ...................... Funds ........................
        Entities entity66 = new Entities();
        entity66 = findBean.nameEntities("Funds",em);
        attributes39.setEntities(entity66);
//      ...................... String ........................
        AttributesTypes attributesTypes67 = new AttributesTypes();
        attributesTypes67 = findBean.nameAttributesTypes("String",em);
        attributes39.setAttributesTypes(attributesTypes67);
        em.persist(attributes39);
        em.flush();

        Entities entities40 = new Entities();
        entities40.setName("SectionsTypes");
//      ...................... co.simasoft.models.naif.task.archival ........................
        GroupIds groupId68 = new GroupIds();
        groupId68 = findBean.groupIdGroupIds("co.simasoft.models.naif.task.archival",em);
        entities40.setGroupIds(groupId68);
        em.persist(entities40);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes41 = new Attributes();
        attributes41.setName("name");
        attributes41.setNullable(true);
        attributes41.setSingle(false);
//      ...................... SectionsTypes ........................
        Entities entity69 = new Entities();
        entity69 = findBean.nameEntities("SectionsTypes",em);
        attributes41.setEntities(entity69);
//      ...................... String ........................
        AttributesTypes attributesTypes70 = new AttributesTypes();
        attributesTypes70 = findBean.nameAttributesTypes("String",em);
        attributes41.setAttributesTypes(attributesTypes70);
        em.persist(attributes41);
        em.flush();

        Entities entities42 = new Entities();
        entities42.setName("Sections");
//      ...................... co.simasoft.models.naif.task.archival ........................
        GroupIds groupId71 = new GroupIds();
        groupId71 = findBean.groupIdGroupIds("co.simasoft.models.naif.task.archival",em);
        entities42.setGroupIds(groupId71);
        em.persist(entities42);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes43 = new Attributes();
        attributes43.setName("code");
        attributes43.setNullable(true);
        attributes43.setSingle(false);
//      ...................... Sections ........................
        Entities entity72 = new Entities();
        entity72 = findBean.nameEntities("Sections",em);
        attributes43.setEntities(entity72);
//      ...................... String ........................
        AttributesTypes attributesTypes73 = new AttributesTypes();
        attributesTypes73 = findBean.nameAttributesTypes("String",em);
        attributes43.setAttributesTypes(attributesTypes73);
        em.persist(attributes43);
        em.flush();

        Attributes attributes44 = new Attributes();
        attributes44.setName("name");
        attributes44.setNullable(true);
        attributes44.setSingle(false);
//      ...................... Sections ........................
        Entities entity74 = new Entities();
        entity74 = findBean.nameEntities("Sections",em);
        attributes44.setEntities(entity74);
//      ...................... String ........................
        AttributesTypes attributesTypes75 = new AttributesTypes();
        attributesTypes75 = findBean.nameAttributesTypes("String",em);
        attributes44.setAttributesTypes(attributesTypes75);
        em.persist(attributes44);
        em.flush();

        Attributes attributes45 = new Attributes();
        attributes45.setName("email");
        attributes45.setNullable(true);
        attributes45.setSingle(false);
//      ...................... Sections ........................
        Entities entity76 = new Entities();
        entity76 = findBean.nameEntities("Sections",em);
        attributes45.setEntities(entity76);
//      ...................... String ........................
        AttributesTypes attributesTypes77 = new AttributesTypes();
        attributesTypes77 = findBean.nameAttributesTypes("String",em);
        attributes45.setAttributesTypes(attributesTypes77);
        em.persist(attributes45);
        em.flush();

        GroupIds groupIds46 = new GroupIds();
        groupIds46.setGroupId("co.simasoft.models.naif.task.activities");
//      ...................... task ........................
        DomainModels domainModel78 = new DomainModels();
        domainModel78 = findBean.artifactIdDomainModels("task",em);
        groupIds46.setDomainModels(domainModel78);
        em.persist(groupIds46);
        em.flush();

//      ---------------------- Entities ------------------------

        Entities entities47 = new Entities();
        entities47.setName("Activities");
//      ...................... co.simasoft.models.naif.task.activities ........................
        GroupIds groupId79 = new GroupIds();
        groupId79 = findBean.groupIdGroupIds("co.simasoft.models.naif.task.activities",em);
        entities47.setGroupIds(groupId79);
        em.persist(entities47);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes48 = new Attributes();
        attributes48.setName("name");
        attributes48.setNullable(true);
        attributes48.setSingle(false);
//      ...................... Activities ........................
        Entities entity80 = new Entities();
        entity80 = findBean.nameEntities("Activities",em);
        attributes48.setEntities(entity80);
//      ...................... String ........................
        AttributesTypes attributesTypes81 = new AttributesTypes();
        attributesTypes81 = findBean.nameAttributesTypes("String",em);
        attributes48.setAttributesTypes(attributesTypes81);
        em.persist(attributes48);
        em.flush();

        Attributes attributes49 = new Attributes();
        attributes49.setName("detail");
        attributes49.setNullable(true);
        attributes49.setSingle(false);
//      ...................... Activities ........................
        Entities entity82 = new Entities();
        entity82 = findBean.nameEntities("Activities",em);
        attributes49.setEntities(entity82);
//      ...................... String ........................
        AttributesTypes attributesTypes83 = new AttributesTypes();
        attributesTypes83 = findBean.nameAttributesTypes("String",em);
        attributes49.setAttributesTypes(attributesTypes83);
        em.persist(attributes49);
        em.flush();

        Attributes attributes50 = new Attributes();
        attributes50.setName("startDate");
        attributes50.setNullable(true);
        attributes50.setSingle(false);
//      ...................... Activities ........................
        Entities entity84 = new Entities();
        entity84 = findBean.nameEntities("Activities",em);
        attributes50.setEntities(entity84);
//      ...................... Date ........................
        AttributesTypes attributesTypes85 = new AttributesTypes();
        attributesTypes85 = findBean.nameAttributesTypes("Date",em);
        attributes50.setAttributesTypes(attributesTypes85);
        em.persist(attributes50);
        em.flush();

        Attributes attributes51 = new Attributes();
        attributes51.setName("finalDate");
        attributes51.setNullable(true);
        attributes51.setSingle(false);
//      ...................... Activities ........................
        Entities entity86 = new Entities();
        entity86 = findBean.nameEntities("Activities",em);
        attributes51.setEntities(entity86);
//      ...................... Date ........................
        AttributesTypes attributesTypes87 = new AttributesTypes();
        attributesTypes87 = findBean.nameAttributesTypes("Date",em);
        attributes51.setAttributesTypes(attributesTypes87);
        em.persist(attributes51);
        em.flush();

        Attributes attributes52 = new Attributes();
        attributes52.setName("timelyDate");
        attributes52.setNullable(true);
        attributes52.setSingle(false);
//      ...................... Activities ........................
        Entities entity88 = new Entities();
        entity88 = findBean.nameEntities("Activities",em);
        attributes52.setEntities(entity88);
//      ...................... Date ........................
        AttributesTypes attributesTypes89 = new AttributesTypes();
        attributesTypes89 = findBean.nameAttributesTypes("Date",em);
        attributes52.setAttributesTypes(attributesTypes89);
        em.persist(attributes52);
        em.flush();

        Attributes attributes53 = new Attributes();
        attributes53.setName("untimelyDate");
        attributes53.setNullable(true);
        attributes53.setSingle(false);
//      ...................... Activities ........................
        Entities entity90 = new Entities();
        entity90 = findBean.nameEntities("Activities",em);
        attributes53.setEntities(entity90);
//      ...................... Date ........................
        AttributesTypes attributesTypes91 = new AttributesTypes();
        attributesTypes91 = findBean.nameAttributesTypes("Date",em);
        attributes53.setAttributesTypes(attributesTypes91);
        em.persist(attributes53);
        em.flush();

        Entities entities54 = new Entities();
        entities54.setName("Diaries");
//      ...................... co.simasoft.models.naif.task.activities ........................
        GroupIds groupId92 = new GroupIds();
        groupId92 = findBean.groupIdGroupIds("co.simasoft.models.naif.task.activities",em);
        entities54.setGroupIds(groupId92);
        em.persist(entities54);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes55 = new Attributes();
        attributes55.setName("date");
        attributes55.setNullable(true);
        attributes55.setSingle(false);
//      ...................... Diaries ........................
        Entities entity93 = new Entities();
        entity93 = findBean.nameEntities("Diaries",em);
        attributes55.setEntities(entity93);
//      ...................... Date ........................
        AttributesTypes attributesTypes94 = new AttributesTypes();
        attributesTypes94 = findBean.nameAttributesTypes("Date",em);
        attributes55.setAttributesTypes(attributesTypes94);
        em.persist(attributes55);
        em.flush();

        Attributes attributes56 = new Attributes();
        attributes56.setName("detail");
        attributes56.setNullable(true);
        attributes56.setSingle(false);
//      ...................... Diaries ........................
        Entities entity95 = new Entities();
        entity95 = findBean.nameEntities("Diaries",em);
        attributes56.setEntities(entity95);
//      ...................... String ........................
        AttributesTypes attributesTypes96 = new AttributesTypes();
        attributesTypes96 = findBean.nameAttributesTypes("String",em);
        attributes56.setAttributesTypes(attributesTypes96);
        em.persist(attributes56);
        em.flush();

        Entities entities57 = new Entities();
        entities57.setName("Guides");
//      ...................... co.simasoft.models.naif.task.activities ........................
        GroupIds groupId97 = new GroupIds();
        groupId97 = findBean.groupIdGroupIds("co.simasoft.models.naif.task.activities",em);
        entities57.setGroupIds(groupId97);
        em.persist(entities57);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes58 = new Attributes();
        attributes58.setName("title");
        attributes58.setNullable(true);
        attributes58.setSingle(false);
//      ...................... Guides ........................
        Entities entity98 = new Entities();
        entity98 = findBean.nameEntities("Guides",em);
        attributes58.setEntities(entity98);
//      ...................... String ........................
        AttributesTypes attributesTypes99 = new AttributesTypes();
        attributesTypes99 = findBean.nameAttributesTypes("String",em);
        attributes58.setAttributesTypes(attributesTypes99);
        em.persist(attributes58);
        em.flush();

        Attributes attributes59 = new Attributes();
        attributes59.setName("guide");
        attributes59.setNullable(true);
        attributes59.setSingle(false);
//      ...................... Guides ........................
        Entities entity100 = new Entities();
        entity100 = findBean.nameEntities("Guides",em);
        attributes59.setEntities(entity100);
//      ...................... String ........................
        AttributesTypes attributesTypes101 = new AttributesTypes();
        attributesTypes101 = findBean.nameAttributesTypes("String",em);
        attributes59.setAttributesTypes(attributesTypes101);
        em.persist(attributes59);
        em.flush();

        Entities entities60 = new Entities();
        entities60.setName("ActivitiesTypes");
//      ...................... co.simasoft.models.naif.task.activities ........................
        GroupIds groupId102 = new GroupIds();
        groupId102 = findBean.groupIdGroupIds("co.simasoft.models.naif.task.activities",em);
        entities60.setGroupIds(groupId102);
        em.persist(entities60);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes61 = new Attributes();
        attributes61.setName("name");
        attributes61.setNullable(true);
        attributes61.setSingle(false);
//      ...................... ActivitiesTypes ........................
        Entities entity103 = new Entities();
        entity103 = findBean.nameEntities("ActivitiesTypes",em);
        attributes61.setEntities(entity103);
//      ...................... String ........................
        AttributesTypes attributesTypes104 = new AttributesTypes();
        attributesTypes104 = findBean.nameAttributesTypes("String",em);
        attributes61.setAttributesTypes(attributesTypes104);
        em.persist(attributes61);
        em.flush();

        Entities entities62 = new Entities();
        entities62.setName("Tasks");
//      ...................... co.simasoft.models.naif.task.activities ........................
        GroupIds groupId105 = new GroupIds();
        groupId105 = findBean.groupIdGroupIds("co.simasoft.models.naif.task.activities",em);
        entities62.setGroupIds(groupId105);
        em.persist(entities62);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes63 = new Attributes();
        attributes63.setName("name");
        attributes63.setNullable(true);
        attributes63.setSingle(false);
//      ...................... Tasks ........................
        Entities entity106 = new Entities();
        entity106 = findBean.nameEntities("Tasks",em);
        attributes63.setEntities(entity106);
//      ...................... String ........................
        AttributesTypes attributesTypes107 = new AttributesTypes();
        attributesTypes107 = findBean.nameAttributesTypes("String",em);
        attributes63.setAttributesTypes(attributesTypes107);
        em.persist(attributes63);
        em.flush();

        Attributes attributes64 = new Attributes();
        attributes64.setName("startDate");
        attributes64.setNullable(true);
        attributes64.setSingle(false);
//      ...................... Tasks ........................
        Entities entity108 = new Entities();
        entity108 = findBean.nameEntities("Tasks",em);
        attributes64.setEntities(entity108);
//      ...................... Date ........................
        AttributesTypes attributesTypes109 = new AttributesTypes();
        attributesTypes109 = findBean.nameAttributesTypes("Date",em);
        attributes64.setAttributesTypes(attributesTypes109);
        em.persist(attributes64);
        em.flush();

        Attributes attributes65 = new Attributes();
        attributes65.setName("finalDate");
        attributes65.setNullable(true);
        attributes65.setSingle(false);
//      ...................... Tasks ........................
        Entities entity110 = new Entities();
        entity110 = findBean.nameEntities("Tasks",em);
        attributes65.setEntities(entity110);
//      ...................... Date ........................
        AttributesTypes attributesTypes111 = new AttributesTypes();
        attributesTypes111 = findBean.nameAttributesTypes("Date",em);
        attributes65.setAttributesTypes(attributesTypes111);
        em.persist(attributes65);
        em.flush();

        Attributes attributes66 = new Attributes();
        attributes66.setName("priority");
        attributes66.setNullable(true);
        attributes66.setSingle(false);
//      ...................... Tasks ........................
        Entities entity112 = new Entities();
        entity112 = findBean.nameEntities("Tasks",em);
        attributes66.setEntities(entity112);
//      ...................... Integer ........................
        AttributesTypes attributesTypes113 = new AttributesTypes();
        attributesTypes113 = findBean.nameAttributesTypes("Integer",em);
        attributes66.setAttributesTypes(attributesTypes113);
        em.persist(attributes66);
        em.flush();

        Attributes attributes67 = new Attributes();
        attributes67.setName("detail");
        attributes67.setNullable(true);
        attributes67.setSingle(false);
//      ...................... Tasks ........................
        Entities entity114 = new Entities();
        entity114 = findBean.nameEntities("Tasks",em);
        attributes67.setEntities(entity114);
//      ...................... String ........................
        AttributesTypes attributesTypes115 = new AttributesTypes();
        attributesTypes115 = findBean.nameAttributesTypes("String",em);
        attributes67.setAttributesTypes(attributesTypes115);
        em.persist(attributes67);
        em.flush();

        Entities entities68 = new Entities();
        entities68.setName("Calendars");
//      ...................... co.simasoft.models.naif.task.activities ........................
        GroupIds groupId116 = new GroupIds();
        groupId116 = findBean.groupIdGroupIds("co.simasoft.models.naif.task.activities",em);
        entities68.setGroupIds(groupId116);
        em.persist(entities68);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes69 = new Attributes();
        attributes69.setName("name");
        attributes69.setNullable(true);
        attributes69.setSingle(false);
//      ...................... Calendars ........................
        Entities entity117 = new Entities();
        entity117 = findBean.nameEntities("Calendars",em);
        attributes69.setEntities(entity117);
//      ...................... String ........................
        AttributesTypes attributesTypes118 = new AttributesTypes();
        attributesTypes118 = findBean.nameAttributesTypes("String",em);
        attributes69.setAttributesTypes(attributesTypes118);
        em.persist(attributes69);
        em.flush();

        Attributes attributes70 = new Attributes();
        attributes70.setName("date");
        attributes70.setNullable(true);
        attributes70.setSingle(false);
//      ...................... Calendars ........................
        Entities entity119 = new Entities();
        entity119 = findBean.nameEntities("Calendars",em);
        attributes70.setEntities(entity119);
//      ...................... Date ........................
        AttributesTypes attributesTypes120 = new AttributesTypes();
        attributesTypes120 = findBean.nameAttributesTypes("Date",em);
        attributes70.setAttributesTypes(attributesTypes120);
        em.persist(attributes70);
        em.flush();

        GroupIds groupIds71 = new GroupIds();
        groupIds71.setGroupId("co.simasoft.models.naif.task.sites");
//      ...................... task ........................
        DomainModels domainModel121 = new DomainModels();
        domainModel121 = findBean.artifactIdDomainModels("task",em);
        groupIds71.setDomainModels(domainModel121);
        em.persist(groupIds71);
        em.flush();

//      ---------------------- Entities ------------------------

        Entities entities72 = new Entities();
        entities72.setName("SitesTypes");
//      ...................... co.simasoft.models.naif.task.sites ........................
        GroupIds groupId122 = new GroupIds();
        groupId122 = findBean.groupIdGroupIds("co.simasoft.models.naif.task.sites",em);
        entities72.setGroupIds(groupId122);
        em.persist(entities72);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes73 = new Attributes();
        attributes73.setName("name");
        attributes73.setNullable(true);
        attributes73.setSingle(false);
//      ...................... SitesTypes ........................
        Entities entity123 = new Entities();
        entity123 = findBean.nameEntities("SitesTypes",em);
        attributes73.setEntities(entity123);
//      ...................... String ........................
        AttributesTypes attributesTypes124 = new AttributesTypes();
        attributesTypes124 = findBean.nameAttributesTypes("String",em);
        attributes73.setAttributesTypes(attributesTypes124);
        em.persist(attributes73);
        em.flush();

        Entities entities74 = new Entities();
        entities74.setName("Sites");
//      ...................... co.simasoft.models.naif.task.sites ........................
        GroupIds groupId125 = new GroupIds();
        groupId125 = findBean.groupIdGroupIds("co.simasoft.models.naif.task.sites",em);
        entities74.setGroupIds(groupId125);
        em.persist(entities74);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes75 = new Attributes();
        attributes75.setName("title");
        attributes75.setNullable(true);
        attributes75.setSingle(false);
//      ...................... Sites ........................
        Entities entity126 = new Entities();
        entity126 = findBean.nameEntities("Sites",em);
        attributes75.setEntities(entity126);
//      ...................... String ........................
        AttributesTypes attributesTypes127 = new AttributesTypes();
        attributesTypes127 = findBean.nameAttributesTypes("String",em);
        attributes75.setAttributesTypes(attributesTypes127);
        em.persist(attributes75);
        em.flush();

        Attributes attributes76 = new Attributes();
        attributes76.setName("link");
        attributes76.setNullable(false);
        attributes76.setSingle(true);
//      ...................... Sites ........................
        Entities entity128 = new Entities();
        entity128 = findBean.nameEntities("Sites",em);
        attributes76.setEntities(entity128);
//      ...................... String ........................
        AttributesTypes attributesTypes129 = new AttributesTypes();
        attributesTypes129 = findBean.nameAttributesTypes("String",em);
        attributes76.setAttributesTypes(attributesTypes129);
        em.persist(attributes76);
        em.flush();

//      ---------------------- Relationships ------------------------

/*
. Persons . 1..* Activities rolA: rolB:

. Persons . 1..* Sections rolA: rolB:

. PersonalType . 1..* Persons rolA: rolB:

*/
        Relationships relationships1 = new Relationships();
        relationships1.setOptionality(true);
        relationships1.setIsEmbedded(false);
//      ...................... Persons ........................
        Entities entities130 = new Entities();
        entities130 = findBean.nameEntities("Persons",em);
        relationships1.setFrom(entities130);
//      ...................... Activities ........................
        Entities entities131 = new Entities();
        entities131 = findBean.nameEntities("Activities",em);
        relationships1.setTo(entities131);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities132 = new Cardinalities();
        cardinalities132 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships1.setCardinalities(cardinalities132);
        em.persist(relationships1);
        em.flush();

        Relationships relationships2 = new Relationships();
        relationships2.setOptionality(true);
        relationships2.setIsEmbedded(false);
//      ...................... Persons ........................
        Entities entities133 = new Entities();
        entities133 = findBean.nameEntities("Persons",em);
        relationships2.setFrom(entities133);
//      ...................... Sections ........................
        Entities entities134 = new Entities();
        entities134 = findBean.nameEntities("Sections",em);
        relationships2.setTo(entities134);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities135 = new Cardinalities();
        cardinalities135 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships2.setCardinalities(cardinalities135);
        em.persist(relationships2);
        em.flush();

        Relationships relationships3 = new Relationships();
        relationships3.setOptionality(true);
        relationships3.setIsEmbedded(false);
//      ...................... PersonalType ........................
        Entities entities136 = new Entities();
        entities136 = findBean.nameEntities("PersonalType",em);
        relationships3.setFrom(entities136);
//      ...................... Persons ........................
        Entities entities137 = new Entities();
        entities137 = findBean.nameEntities("Persons",em);
        relationships3.setTo(entities137);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities138 = new Cardinalities();
        cardinalities138 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships3.setCardinalities(cardinalities138);
        em.persist(relationships3);
        em.flush();

/*
. Sections . 1..* Activities rolA:from rolB: OK

. DocumentsTypes . 1..* Series rolA: rolB:

. ConservationUnits . 1..* DocumentalsUnits rolA: rolB:

. Funds . 1..* Sections rolA: rolB:

. Sections . *..* Tasks rolA:from rolB: OK

. Series . *..* Sites rolA:from rolB: OK

. Series . 1..* DocumentalsUnits rolA: rolB:

. Series . 1..* Series rolA: rolB:

. SectionsTypes . 1..* Sections rolA: rolB:

. DocumentalsSupports . 1..* OriginalOrder rolA: rolB:

. Sections . 1..* Sections rolA: rolB:

. DocumentalsUnits . 1..* OriginalOrder rolA: rolB:

. Sections . *..* Series rolA:from rolB: OK

*/
        Relationships relationships4 = new Relationships();
        relationships4.setOptionality(true);
        relationships4.setIsEmbedded(false);
//      ...................... Sections ........................
        Entities entities139 = new Entities();
        entities139 = findBean.nameEntities("Sections",em);
        relationships4.setFrom(entities139);
//      ...................... Activities ........................
        Entities entities140 = new Entities();
        entities140 = findBean.nameEntities("Activities",em);
        relationships4.setTo(entities140);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities141 = new Cardinalities();
        cardinalities141 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships4.setCardinalities(cardinalities141);
        em.persist(relationships4);
        em.flush();

        Relationships relationships5 = new Relationships();
        relationships5.setOptionality(true);
        relationships5.setIsEmbedded(false);
//      ...................... DocumentsTypes ........................
        Entities entities142 = new Entities();
        entities142 = findBean.nameEntities("DocumentsTypes",em);
        relationships5.setFrom(entities142);
//      ...................... Series ........................
        Entities entities143 = new Entities();
        entities143 = findBean.nameEntities("Series",em);
        relationships5.setTo(entities143);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities144 = new Cardinalities();
        cardinalities144 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships5.setCardinalities(cardinalities144);
        em.persist(relationships5);
        em.flush();

        Relationships relationships6 = new Relationships();
        relationships6.setOptionality(true);
        relationships6.setIsEmbedded(false);
//      ...................... ConservationUnits ........................
        Entities entities145 = new Entities();
        entities145 = findBean.nameEntities("ConservationUnits",em);
        relationships6.setFrom(entities145);
//      ...................... DocumentalsUnits ........................
        Entities entities146 = new Entities();
        entities146 = findBean.nameEntities("DocumentalsUnits",em);
        relationships6.setTo(entities146);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities147 = new Cardinalities();
        cardinalities147 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships6.setCardinalities(cardinalities147);
        em.persist(relationships6);
        em.flush();

        Relationships relationships7 = new Relationships();
        relationships7.setOptionality(true);
        relationships7.setIsEmbedded(false);
//      ...................... Funds ........................
        Entities entities148 = new Entities();
        entities148 = findBean.nameEntities("Funds",em);
        relationships7.setFrom(entities148);
//      ...................... Sections ........................
        Entities entities149 = new Entities();
        entities149 = findBean.nameEntities("Sections",em);
        relationships7.setTo(entities149);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities150 = new Cardinalities();
        cardinalities150 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships7.setCardinalities(cardinalities150);
        em.persist(relationships7);
        em.flush();

        Relationships relationships8 = new Relationships();
        relationships8.setOptionality(true);
        relationships8.setIsEmbedded(false);
//      ...................... Sections ........................
        Entities entities151 = new Entities();
        entities151 = findBean.nameEntities("Sections",em);
        relationships8.setFrom(entities151);
//      ...................... Tasks ........................
        Entities entities152 = new Entities();
        entities152 = findBean.nameEntities("Tasks",em);
        relationships8.setTo(entities152);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities153 = new Cardinalities();
        cardinalities153 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships8.setCardinalities(cardinalities153);
        em.persist(relationships8);
        em.flush();

        Relationships relationships9 = new Relationships();
        relationships9.setOptionality(true);
        relationships9.setIsEmbedded(false);
//      ...................... Series ........................
        Entities entities154 = new Entities();
        entities154 = findBean.nameEntities("Series",em);
        relationships9.setFrom(entities154);
//      ...................... Sites ........................
        Entities entities155 = new Entities();
        entities155 = findBean.nameEntities("Sites",em);
        relationships9.setTo(entities155);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities156 = new Cardinalities();
        cardinalities156 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships9.setCardinalities(cardinalities156);
        em.persist(relationships9);
        em.flush();

        Relationships relationships10 = new Relationships();
        relationships10.setOptionality(true);
        relationships10.setIsEmbedded(false);
//      ...................... Series ........................
        Entities entities157 = new Entities();
        entities157 = findBean.nameEntities("Series",em);
        relationships10.setFrom(entities157);
//      ...................... DocumentalsUnits ........................
        Entities entities158 = new Entities();
        entities158 = findBean.nameEntities("DocumentalsUnits",em);
        relationships10.setTo(entities158);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities159 = new Cardinalities();
        cardinalities159 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships10.setCardinalities(cardinalities159);
        em.persist(relationships10);
        em.flush();

        Relationships relationships11 = new Relationships();
        relationships11.setOptionality(true);
        relationships11.setIsEmbedded(false);
//      ...................... Series ........................
        Entities entities160 = new Entities();
        entities160 = findBean.nameEntities("Series",em);
        relationships11.setFrom(entities160);
//      ...................... Series ........................
        Entities entities161 = new Entities();
        entities161 = findBean.nameEntities("Series",em);
        relationships11.setTo(entities161);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities162 = new Cardinalities();
        cardinalities162 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships11.setCardinalities(cardinalities162);
        em.persist(relationships11);
        em.flush();

        Relationships relationships12 = new Relationships();
        relationships12.setOptionality(true);
        relationships12.setIsEmbedded(false);
//      ...................... SectionsTypes ........................
        Entities entities163 = new Entities();
        entities163 = findBean.nameEntities("SectionsTypes",em);
        relationships12.setFrom(entities163);
//      ...................... Sections ........................
        Entities entities164 = new Entities();
        entities164 = findBean.nameEntities("Sections",em);
        relationships12.setTo(entities164);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities165 = new Cardinalities();
        cardinalities165 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships12.setCardinalities(cardinalities165);
        em.persist(relationships12);
        em.flush();

        Relationships relationships13 = new Relationships();
        relationships13.setOptionality(true);
        relationships13.setIsEmbedded(false);
//      ...................... DocumentalsSupports ........................
        Entities entities166 = new Entities();
        entities166 = findBean.nameEntities("DocumentalsSupports",em);
        relationships13.setFrom(entities166);
//      ...................... OriginalOrder ........................
        Entities entities167 = new Entities();
        entities167 = findBean.nameEntities("OriginalOrder",em);
        relationships13.setTo(entities167);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities168 = new Cardinalities();
        cardinalities168 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships13.setCardinalities(cardinalities168);
        em.persist(relationships13);
        em.flush();

        Relationships relationships14 = new Relationships();
        relationships14.setOptionality(true);
        relationships14.setIsEmbedded(false);
//      ...................... Sections ........................
        Entities entities169 = new Entities();
        entities169 = findBean.nameEntities("Sections",em);
        relationships14.setFrom(entities169);
//      ...................... Sections ........................
        Entities entities170 = new Entities();
        entities170 = findBean.nameEntities("Sections",em);
        relationships14.setTo(entities170);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities171 = new Cardinalities();
        cardinalities171 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships14.setCardinalities(cardinalities171);
        em.persist(relationships14);
        em.flush();

        Relationships relationships15 = new Relationships();
        relationships15.setOptionality(true);
        relationships15.setIsEmbedded(false);
//      ...................... DocumentalsUnits ........................
        Entities entities172 = new Entities();
        entities172 = findBean.nameEntities("DocumentalsUnits",em);
        relationships15.setFrom(entities172);
//      ...................... OriginalOrder ........................
        Entities entities173 = new Entities();
        entities173 = findBean.nameEntities("OriginalOrder",em);
        relationships15.setTo(entities173);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities174 = new Cardinalities();
        cardinalities174 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships15.setCardinalities(cardinalities174);
        em.persist(relationships15);
        em.flush();

        Relationships relationships16 = new Relationships();
        relationships16.setOptionality(true);
        relationships16.setIsEmbedded(false);
//      ...................... Sections ........................
        Entities entities175 = new Entities();
        entities175 = findBean.nameEntities("Sections",em);
        relationships16.setFrom(entities175);
//      ...................... Series ........................
        Entities entities176 = new Entities();
        entities176 = findBean.nameEntities("Series",em);
        relationships16.setTo(entities176);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities177 = new Cardinalities();
        cardinalities177 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships16.setCardinalities(cardinalities177);
        em.persist(relationships16);
        em.flush();

/*
. Tasks . 1..* Diaries rolA: rolB:

. Calendars . 1..* Activities rolA: rolB:

. Activities . *..* Guides rolA:from rolB: OK

. Activities . *..* Sites rolA:from rolB: OK

. Activities . 1..* Activities rolA: rolB:

. Activities . 1..* Tasks rolA: rolB:

. Tasks . 1..* Sites rolA:from rolB: OK

. ActivitiesTypes . 1..* Activities rolA: rolB:

*/
        Relationships relationships17 = new Relationships();
        relationships17.setOptionality(true);
        relationships17.setIsEmbedded(false);
//      ...................... Tasks ........................
        Entities entities178 = new Entities();
        entities178 = findBean.nameEntities("Tasks",em);
        relationships17.setFrom(entities178);
//      ...................... Diaries ........................
        Entities entities179 = new Entities();
        entities179 = findBean.nameEntities("Diaries",em);
        relationships17.setTo(entities179);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities180 = new Cardinalities();
        cardinalities180 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships17.setCardinalities(cardinalities180);
        em.persist(relationships17);
        em.flush();

        Relationships relationships18 = new Relationships();
        relationships18.setOptionality(true);
        relationships18.setIsEmbedded(false);
//      ...................... Calendars ........................
        Entities entities181 = new Entities();
        entities181 = findBean.nameEntities("Calendars",em);
        relationships18.setFrom(entities181);
//      ...................... Activities ........................
        Entities entities182 = new Entities();
        entities182 = findBean.nameEntities("Activities",em);
        relationships18.setTo(entities182);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities183 = new Cardinalities();
        cardinalities183 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships18.setCardinalities(cardinalities183);
        em.persist(relationships18);
        em.flush();

        Relationships relationships19 = new Relationships();
        relationships19.setOptionality(true);
        relationships19.setIsEmbedded(false);
//      ...................... Activities ........................
        Entities entities184 = new Entities();
        entities184 = findBean.nameEntities("Activities",em);
        relationships19.setFrom(entities184);
//      ...................... Guides ........................
        Entities entities185 = new Entities();
        entities185 = findBean.nameEntities("Guides",em);
        relationships19.setTo(entities185);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities186 = new Cardinalities();
        cardinalities186 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships19.setCardinalities(cardinalities186);
        em.persist(relationships19);
        em.flush();

        Relationships relationships20 = new Relationships();
        relationships20.setOptionality(true);
        relationships20.setIsEmbedded(false);
//      ...................... Activities ........................
        Entities entities187 = new Entities();
        entities187 = findBean.nameEntities("Activities",em);
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
        relationships21.setOptionality(true);
        relationships21.setIsEmbedded(false);
//      ...................... Activities ........................
        Entities entities190 = new Entities();
        entities190 = findBean.nameEntities("Activities",em);
        relationships21.setFrom(entities190);
//      ...................... Activities ........................
        Entities entities191 = new Entities();
        entities191 = findBean.nameEntities("Activities",em);
        relationships21.setTo(entities191);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities192 = new Cardinalities();
        cardinalities192 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships21.setCardinalities(cardinalities192);
        em.persist(relationships21);
        em.flush();

        Relationships relationships22 = new Relationships();
        relationships22.setOptionality(true);
        relationships22.setIsEmbedded(false);
//      ...................... Activities ........................
        Entities entities193 = new Entities();
        entities193 = findBean.nameEntities("Activities",em);
        relationships22.setFrom(entities193);
//      ...................... Tasks ........................
        Entities entities194 = new Entities();
        entities194 = findBean.nameEntities("Tasks",em);
        relationships22.setTo(entities194);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities195 = new Cardinalities();
        cardinalities195 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships22.setCardinalities(cardinalities195);
        em.persist(relationships22);
        em.flush();

        Relationships relationships23 = new Relationships();
        relationships23.setOptionality(true);
        relationships23.setIsEmbedded(false);
//      ...................... Tasks ........................
        Entities entities196 = new Entities();
        entities196 = findBean.nameEntities("Tasks",em);
        relationships23.setFrom(entities196);
//      ...................... Sites ........................
        Entities entities197 = new Entities();
        entities197 = findBean.nameEntities("Sites",em);
        relationships23.setTo(entities197);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities198 = new Cardinalities();
        cardinalities198 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships23.setCardinalities(cardinalities198);
        em.persist(relationships23);
        em.flush();

        Relationships relationships24 = new Relationships();
        relationships24.setOptionality(true);
        relationships24.setIsEmbedded(false);
//      ...................... ActivitiesTypes ........................
        Entities entities199 = new Entities();
        entities199 = findBean.nameEntities("ActivitiesTypes",em);
        relationships24.setFrom(entities199);
//      ...................... Activities ........................
        Entities entities200 = new Entities();
        entities200 = findBean.nameEntities("Activities",em);
        relationships24.setTo(entities200);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities201 = new Cardinalities();
        cardinalities201 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships24.setCardinalities(cardinalities201);
        em.persist(relationships24);
        em.flush();

/*
. SitesTypes . *..* Sites rolA:from rolB: OK

*/
        Relationships relationships25 = new Relationships();
        relationships25.setOptionality(true);
        relationships25.setIsEmbedded(false);
//      ...................... SitesTypes ........................
        Entities entities202 = new Entities();
        entities202 = findBean.nameEntities("SitesTypes",em);
        relationships25.setFrom(entities202);
//      ...................... Sites ........................
        Entities entities203 = new Entities();
        entities203 = findBean.nameEntities("Sites",em);
        relationships25.setTo(entities203);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities204 = new Cardinalities();
        cardinalities204 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships25.setCardinalities(cardinalities204);
        em.persist(relationships25);
        em.flush();

    } // data()

} // task
