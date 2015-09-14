package co.simasoft.setup;

import co.simasoft.beans.*;
import co.simasoft.utils.*;

import co.simasoft.models.core.sites.*;
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
        groupIds1.setGroupId("co.simasoft.models.dev.naifg.dependencies");
        groupIds1.setArtifactId("co.simasoft.models.dev.naifg.dependencies");
        em.persist(groupIds1);
        em.flush();

        GroupIds groupIds2 = new GroupIds();
        groupIds2.setGroupId("co.simasoft.models.dev.naifg");
        groupIds2.setArtifactId("co.simasoft.models.dev.naifg");
        em.persist(groupIds2);
        em.flush();

//      ---------------------- Models ------------------------

        Models models = new Models();
        models.setGroupId("co.simasoft.naifg");
        models.setArtifactId("naifg");
        models.setVersion("1.0-SNAPSHOT");
        em.persist(models);
        em.flush();

//      ---------------------- ModelsGroupIds ----------------------

        ModelsGroupIds modelsGroupIds1 = new ModelsGroupIds();
        Models modelss1 = findBean.artifactIdModels("naifg",em);
        GroupIds groupIdd1 = findBean.artifactIdGroupIds("co.simasoft.models.dev.naifg",em);
        modelsGroupIds1.setModels(modelss1);
        modelsGroupIds1.setGroupIds(groupIdd1);
        modelsGroupIds1.setIsIsolated(false);
        modelsGroupIds1.setIsSimplified(false);
        em.persist(modelsGroupIds1);
        em.flush();

        ModelsGroupIds modelsGroupIds2 = new ModelsGroupIds();
        Models modelss2 = findBean.artifactIdModels("naifg",em);
        GroupIds groupIdd2 = findBean.artifactIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        modelsGroupIds2.setModels(modelss2);
        modelsGroupIds2.setGroupIds(groupIdd2);
        modelsGroupIds2.setIsIsolated(false);
        modelsGroupIds2.setIsSimplified(false);
        em.persist(modelsGroupIds2);
        em.flush();

        ModelsGroupIds modelsGroupIds3 = new ModelsGroupIds();
        Models modelss3 = findBean.artifactIdModels("naifg",em);
        GroupIds groupIdd3 = findBean.artifactIdGroupIds("co.simasoft.models.core.sites",em);
        modelsGroupIds3.setModels(modelss3);
        modelsGroupIds3.setGroupIds(groupIdd3);
        modelsGroupIds3.setIsIsolated(true);
        modelsGroupIds3.setIsSimplified(true);
        em.persist(modelsGroupIds3);
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

        Entities entities1 = new Entities();
        entities1.setName("AttributesProperties");
        entities1.setIsSimplified(false);
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId1 = new GroupIds();
        groupId1 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities1.setGroupIds(groupId1);
        em.persist(entities1);
        em.flush();

        Attributes attributes2 = new Attributes();
        attributes2.setName("name");
        attributes2.setIsNullable(false);
        attributes2.setIsUnique(true);
        attributes2.setIsSimplified(false);
        attributes2.setIsCreate(true);
        attributes2.setIsSearch(true);
        attributes2.setIsView(true);
        attributes2.setIsViewRelation(true);
        attributes2.setIsViewColumn(true);
//      ...................... AttributesProperties ........................
        Entities entity2 = new Entities();
        entity2 = findBean.nameEntities("AttributesProperties",em);
        attributes2.setEntities(entity2);
//      ...................... String ........................
        AttributesTypes attributesTypes3 = new AttributesTypes();
        attributesTypes3 = findBean.nameAttributesTypes("String",em);
        attributes2.setAttributesTypes(attributesTypes3);
        em.persist(attributes2);
        em.flush();

        Attributes attributes3 = new Attributes();
        attributes3.setName("value");
        attributes3.setIsNullable(false);
        attributes3.setIsUnique(true);
        attributes3.setIsSimplified(false);
        attributes3.setIsCreate(true);
        attributes3.setIsSearch(true);
        attributes3.setIsView(true);
        attributes3.setIsViewRelation(false);
        attributes3.setIsViewColumn(true);
//      ...................... AttributesProperties ........................
        Entities entity4 = new Entities();
        entity4 = findBean.nameEntities("AttributesProperties",em);
        attributes3.setEntities(entity4);
//      ...................... String ........................
        AttributesTypes attributesTypes5 = new AttributesTypes();
        attributesTypes5 = findBean.nameAttributesTypes("String",em);
        attributes3.setAttributesTypes(attributesTypes5);
        em.persist(attributes3);
        em.flush();

        Entities entities4 = new Entities();
        entities4.setName("AttributesTypes");
        entities4.setIsSimplified(false);
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId6 = new GroupIds();
        groupId6 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities4.setGroupIds(groupId6);
        em.persist(entities4);
        em.flush();

        Attributes attributes5 = new Attributes();
        attributes5.setName("name");
        attributes5.setIsNullable(false);
        attributes5.setIsUnique(true);
        attributes5.setIsSimplified(false);
        attributes5.setIsCreate(true);
        attributes5.setIsSearch(true);
        attributes5.setIsView(true);
        attributes5.setIsViewRelation(true);
        attributes5.setIsViewColumn(true);        
//      ...................... AttributesTypes ........................
        Entities entity7 = new Entities();
        entity7 = findBean.nameEntities("AttributesTypes",em);
        attributes5.setEntities(entity7);
//      ...................... String ........................
        AttributesTypes attributesTypes8 = new AttributesTypes();
        attributesTypes8 = findBean.nameAttributesTypes("String",em);
        attributes5.setAttributesTypes(attributesTypes8);
        em.persist(attributes5);
        em.flush();

        Attributes attributes6 = new Attributes();
        attributes6.setName("type");
        attributes6.setIsNullable(false);
        attributes6.setIsUnique(false);
        attributes6.setIsSimplified(false);
        attributes6.setIsCreate(true);
        attributes6.setIsSearch(true);
        attributes6.setIsView(true);
        attributes6.setIsViewRelation(true);
        attributes6.setIsViewColumn(true);
//      ...................... AttributesTypes ........................
        Entities entity9 = new Entities();
        entity9 = findBean.nameEntities("AttributesTypes",em);
        attributes6.setEntities(entity9);
//      ...................... String ........................
        AttributesTypes attributesTypes10 = new AttributesTypes();
        attributesTypes10 = findBean.nameAttributesTypes("String",em);
        attributes6.setAttributesTypes(attributesTypes10);
        em.persist(attributes6);
        em.flush();

        Attributes attributes7 = new Attributes();
        attributes7.setName("length");
        attributes7.setIsNullable(true);
        attributes7.setIsUnique(false);
        attributes7.setIsSimplified(false);
        attributes7.setIsCreate(true);
        attributes7.setIsSearch(true);
        attributes7.setIsView(true);
        attributes7.setIsViewRelation(false);
        attributes7.setIsViewColumn(true);        
//      ...................... AttributesTypes ........................
        Entities entity11 = new Entities();
        entity11 = findBean.nameEntities("AttributesTypes",em);
        attributes7.setEntities(entity11);
//      ...................... Integer ........................
        AttributesTypes attributesTypes12 = new AttributesTypes();
        attributesTypes12 = findBean.nameAttributesTypes("Integer",em);
        attributes7.setAttributesTypes(attributesTypes12);
        em.persist(attributes7);
        em.flush();

        Attributes attributes8 = new Attributes();
        attributes8.setName("precision");
        attributes8.setIsNullable(true);
        attributes8.setIsUnique(false);
        attributes8.setIsSimplified(false);
        attributes8.setIsCreate(true);
        attributes8.setIsSearch(true);
        attributes8.setIsView(true);
        attributes8.setIsViewRelation(false);
        attributes8.setIsViewColumn(true);
//      ...................... AttributesTypes ........................
        Entities entity13 = new Entities();
        entity13 = findBean.nameEntities("AttributesTypes",em);
        attributes8.setEntities(entity13);
//      ...................... Integer ........................
        AttributesTypes attributesTypes14 = new AttributesTypes();
        attributesTypes14 = findBean.nameAttributesTypes("Integer",em);
        attributes8.setAttributesTypes(attributesTypes14);
        em.persist(attributes8);
        em.flush();

        Attributes attributes9 = new Attributes();
        attributes9.setName("annotations");
        attributes9.setIsNullable(true);
        attributes9.setIsUnique(false);
        attributes9.setIsSimplified(false);
        attributes9.setIsCreate(true);
        attributes9.setIsSearch(true);
        attributes9.setIsView(true);
        attributes9.setIsViewRelation(false);
        attributes9.setIsViewColumn(true);        
//      ...................... AttributesTypes ........................
        Entities entity15 = new Entities();
        entity15 = findBean.nameEntities("AttributesTypes",em);
        attributes9.setEntities(entity15);
//      ...................... String ........................
        AttributesTypes attributesTypes16 = new AttributesTypes();
        attributesTypes16 = findBean.nameAttributesTypes("String",em);
        attributes9.setAttributesTypes(attributesTypes16);
        em.persist(attributes9);
        em.flush();

        Entities entities10 = new Entities();
        entities10.setName("Imports");
        entities10.setIsSimplified(false);
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId17 = new GroupIds();
        groupId17 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities10.setGroupIds(groupId17);
        em.persist(entities10);
        em.flush();

        Attributes attributes11 = new Attributes();
        attributes11.setName("name");
        attributes11.setIsNullable(false);
        attributes11.setIsUnique(true);
        attributes11.setIsSimplified(false);
        attributes11.setIsCreate(true);
        attributes11.setIsSearch(true);
        attributes11.setIsView(true);
        attributes11.setIsViewRelation(true);
        attributes11.setIsViewColumn(true);
//      ...................... Imports ........................
        Entities entity18 = new Entities();
        entity18 = findBean.nameEntities("Imports",em);
        attributes11.setEntities(entity18);
//      ...................... String ........................
        AttributesTypes attributesTypes19 = new AttributesTypes();
        attributesTypes19 = findBean.nameAttributesTypes("String",em);
        attributes11.setAttributesTypes(attributesTypes19);
        em.persist(attributes11);
        em.flush();

        Entities entities12 = new Entities();
        entities12.setName("Dependencies");
        entities12.setIsSimplified(false);
//      ...................... co.simasoft.models.dev.naifg.dependencies ........................
        GroupIds groupId20 = new GroupIds();
        groupId20 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        entities12.setGroupIds(groupId20);
        em.persist(entities12);
        em.flush();

        Attributes attributes13 = new Attributes();
        attributes13.setName("groupId");
        attributes13.setIsNullable(false);
        attributes13.setIsUnique(false);
        attributes13.setIsSimplified(false);
        attributes13.setIsCreate(true);
        attributes13.setIsSearch(true);
        attributes13.setIsView(true);
        attributes13.setIsViewRelation(false);
        attributes13.setIsViewColumn(true);
//      ...................... Dependencies ........................
        Entities entity21 = new Entities();
        entity21 = findBean.nameEntities("Dependencies",em);
        attributes13.setEntities(entity21);
//      ...................... String ........................
        AttributesTypes attributesTypes22 = new AttributesTypes();
        attributesTypes22 = findBean.nameAttributesTypes("String",em);
        attributes13.setAttributesTypes(attributesTypes22);
        em.persist(attributes13);
        em.flush();

        Attributes attributes14 = new Attributes();
        attributes14.setName("artifactId");
        attributes14.setIsNullable(false);
        attributes14.setIsUnique(false);
        attributes14.setIsSimplified(false);
        attributes14.setIsCreate(true);
        attributes14.setIsSearch(true);
        attributes14.setIsView(true);
        attributes14.setIsViewRelation(true);
        attributes14.setIsViewColumn(true);        
//      ...................... Dependencies ........................
        Entities entity23 = new Entities();
        entity23 = findBean.nameEntities("Dependencies",em);
        attributes14.setEntities(entity23);
//      ...................... String ........................
        AttributesTypes attributesTypes24 = new AttributesTypes();
        attributesTypes24 = findBean.nameAttributesTypes("String",em);
        attributes14.setAttributesTypes(attributesTypes24);
        em.persist(attributes14);
        em.flush();

        Attributes attributes15 = new Attributes();
        attributes15.setName("version");
        attributes15.setIsNullable(true);
        attributes15.setIsUnique(false);
        attributes15.setIsSimplified(false);
        attributes15.setIsCreate(true);
        attributes15.setIsSearch(true);
        attributes15.setIsView(true);
        attributes15.setIsViewRelation(false);
        attributes15.setIsViewColumn(true);
//      ...................... Dependencies ........................
        Entities entity25 = new Entities();
        entity25 = findBean.nameEntities("Dependencies",em);
        attributes15.setEntities(entity25);
//      ...................... String ........................
        AttributesTypes attributesTypes26 = new AttributesTypes();
        attributesTypes26 = findBean.nameAttributesTypes("String",em);
        attributes15.setAttributesTypes(attributesTypes26);
        em.persist(attributes15);
        em.flush();

        Attributes attributes16 = new Attributes();
        attributes16.setName("type");
        attributes16.setIsNullable(true);
        attributes16.setIsUnique(false);
        attributes16.setIsSimplified(false);
        attributes16.setIsCreate(true);
        attributes16.setIsSearch(true);
        attributes16.setIsView(true);
        attributes16.setIsViewRelation(false);
        attributes16.setIsViewColumn(true);        
//      ...................... Dependencies ........................
        Entities entity27 = new Entities();
        entity27 = findBean.nameEntities("Dependencies",em);
        attributes16.setEntities(entity27);
//      ...................... String ........................
        AttributesTypes attributesTypes28 = new AttributesTypes();
        attributesTypes28 = findBean.nameAttributesTypes("String",em);
        attributes16.setAttributesTypes(attributesTypes28);
        em.persist(attributes16);
        em.flush();

        Attributes attributes17 = new Attributes();
        attributes17.setName("scope");
        attributes17.setIsNullable(true);
        attributes17.setIsUnique(false);
        attributes17.setIsSimplified(false);
        attributes17.setIsCreate(true);
        attributes17.setIsSearch(true);
        attributes17.setIsView(true);
        attributes17.setIsViewRelation(false);
        attributes17.setIsViewColumn(true);        
//      ...................... Dependencies ........................
        Entities entity29 = new Entities();
        entity29 = findBean.nameEntities("Dependencies",em);
        attributes17.setEntities(entity29);
//      ...................... String ........................
        AttributesTypes attributesTypes30 = new AttributesTypes();
        attributesTypes30 = findBean.nameAttributesTypes("String",em);
        attributes17.setAttributesTypes(attributesTypes30);
        em.persist(attributes17);
        em.flush();

        Attributes attributes18 = new Attributes();
        attributes18.setName("maven");
        attributes18.setIsNullable(false);
        attributes18.setIsUnique(true);
        attributes18.setIsSimplified(false);
        attributes18.setIsCreate(true);
        attributes18.setIsSearch(true);
        attributes18.setIsView(true);
        attributes18.setIsViewRelation(false);
        attributes18.setIsViewColumn(true);        
//      ...................... Dependencies ........................
        Entities entity31 = new Entities();
        entity31 = findBean.nameEntities("Dependencies",em);
        attributes18.setEntities(entity31);
//      ...................... String ........................
        AttributesTypes attributesTypes32 = new AttributesTypes();
        attributesTypes32 = findBean.nameAttributesTypes("String",em);
        attributes18.setAttributesTypes(attributesTypes32);
        em.persist(attributes18);
        em.flush();

//      ---------------------- Entities ------------------------

//      ---------------------- Entities ------------------------

//      ---------------------- Entities ------------------------

//      ---------------------- Entities ------------------------

//      ---------------------- Entities ------------------------

        Entities entities19 = new Entities();
        entities19.setName("Entities");
        entities19.setIsSimplified(false);
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId33 = new GroupIds();
        groupId33 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities19.setGroupIds(groupId33);
        em.persist(entities19);
        em.flush();

        Attributes attributes20 = new Attributes();
        attributes20.setName("name");
        attributes20.setIsNullable(false);
        attributes20.setIsUnique(true);
        attributes20.setIsSimplified(false);
        attributes20.setIsCreate(true);
        attributes20.setIsSearch(true);
        attributes20.setIsView(true);
        attributes20.setIsViewRelation(true);
        attributes20.setIsViewColumn(true);
//      ...................... Entities ........................
        Entities entity34 = new Entities();
        entity34 = findBean.nameEntities("Entities",em);
        attributes20.setEntities(entity34);
//      ...................... String ........................
        AttributesTypes attributesTypes35 = new AttributesTypes();
        attributesTypes35 = findBean.nameAttributesTypes("String",em);
        attributes20.setAttributesTypes(attributesTypes35);
        em.persist(attributes20);
        em.flush();

        Attributes attributes21 = new Attributes();
        attributes21.setName("serialID");
        attributes21.setIsNullable(true);
        attributes21.setIsUnique(false);
        attributes21.setIsSimplified(false);
        attributes21.setIsCreate(true);
        attributes21.setIsSearch(true);
        attributes21.setIsView(true);
        attributes21.setIsViewRelation(false);
        attributes21.setIsViewColumn(true);
//      ...................... Entities ........................
        Entities entity36 = new Entities();
        entity36 = findBean.nameEntities("Entities",em);
        attributes21.setEntities(entity36);
//      ...................... String ........................
        AttributesTypes attributesTypes37 = new AttributesTypes();
        attributesTypes37 = findBean.nameAttributesTypes("String",em);
        attributes21.setAttributesTypes(attributesTypes37);
        em.persist(attributes21);
        em.flush();

        Attributes attributes22 = new Attributes();
        attributes22.setName("table");
        attributes22.setIsNullable(true);
        attributes22.setIsUnique(false);
        attributes22.setIsSimplified(false);
        attributes22.setIsCreate(true);
        attributes22.setIsSearch(true);
        attributes22.setIsView(true);
        attributes22.setIsViewRelation(false);
        attributes22.setIsViewColumn(false);
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
        attributes23.setName("description");
        attributes23.setIsNullable(true);
        attributes23.setIsUnique(false);
        attributes23.setIsSimplified(false);
        attributes23.setIsCreate(true);
        attributes23.setIsSearch(true);
        attributes23.setIsView(true);
        attributes23.setIsViewRelation(false);
        attributes23.setIsViewColumn(false);
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
        attributes24.setName("isSimplified");
        attributes24.setIsNullable(true);
        attributes24.setIsUnique(false);
        attributes24.setIsSimplified(false);
        attributes24.setIsCreate(true);
        attributes24.setIsSearch(true);
        attributes24.setIsView(true);
        attributes24.setIsViewRelation(false);
        attributes24.setIsViewColumn(true);
//      ...................... Entities ........................
        Entities entity42 = new Entities();
        entity42 = findBean.nameEntities("Entities",em);
        attributes24.setEntities(entity42);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes43 = new AttributesTypes();
        attributesTypes43 = findBean.nameAttributesTypes("Boolean",em);
        attributes24.setAttributesTypes(attributesTypes43);
        em.persist(attributes24);
        em.flush();

        Entities entities25 = new Entities();
        entities25.setName("Attributes");
        entities25.setIsSimplified(false);
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId44 = new GroupIds();
        groupId44 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities25.setGroupIds(groupId44);
        em.persist(entities25);
        em.flush();

        Attributes attributes26 = new Attributes();
        attributes26.setName("name");
        attributes26.setIsNullable(false);
        attributes26.setIsUnique(false);
        attributes26.setIsSimplified(false);
        attributes26.setIsCreate(true);
        attributes26.setIsSearch(true);
        attributes26.setIsView(true);
        attributes26.setIsViewRelation(true);
        attributes26.setIsViewColumn(true);
//      ...................... Attributes ........................
        Entities entity45 = new Entities();
        entity45 = findBean.nameEntities("Attributes",em);
        attributes26.setEntities(entity45);
//      ...................... String ........................
        AttributesTypes attributesTypes46 = new AttributesTypes();
        attributesTypes46 = findBean.nameAttributesTypes("String",em);
        attributes26.setAttributesTypes(attributesTypes46);
        em.persist(attributes26);
        em.flush();

        Attributes attributes27 = new Attributes();
        attributes27.setName("length");
        attributes27.setIsNullable(true);
        attributes27.setIsUnique(false);
        attributes27.setIsSimplified(false);
        attributes27.setIsCreate(true);
        attributes27.setIsSearch(true);
        attributes27.setIsView(true);
        attributes27.setIsViewRelation(false);
        attributes27.setIsViewColumn(false);
//      ...................... Attributes ........................
        Entities entity47 = new Entities();
        entity47 = findBean.nameEntities("Attributes",em);
        attributes27.setEntities(entity47);
//      ...................... Integer ........................
        AttributesTypes attributesTypes48 = new AttributesTypes();
        attributesTypes48 = findBean.nameAttributesTypes("Integer",em);
        attributes27.setAttributesTypes(attributesTypes48);
        em.persist(attributes27);
        em.flush();

        Attributes attributes28 = new Attributes();
        attributes28.setName("precision");
        attributes28.setIsNullable(true);
        attributes28.setIsUnique(false);
        attributes28.setIsSimplified(false);
        attributes28.setIsCreate(true);
        attributes28.setIsSearch(true);
        attributes28.setIsView(true);
        attributes28.setIsViewRelation(false);
        attributes28.setIsViewColumn(false);
//      ...................... Attributes ........................
        Entities entity49 = new Entities();
        entity49 = findBean.nameEntities("Attributes",em);
        attributes28.setEntities(entity49);
//      ...................... Integer ........................
        AttributesTypes attributesTypes50 = new AttributesTypes();
        attributesTypes50 = findBean.nameAttributesTypes("Integer",em);
        attributes28.setAttributesTypes(attributesTypes50);
        em.persist(attributes28);
        em.flush();

        Attributes attributes29 = new Attributes();
        attributes29.setName("isNullable");
        attributes29.setIsNullable(true);
        attributes29.setIsUnique(false);
        attributes29.setIsSimplified(false);
        attributes29.setIsCreate(true);
        attributes29.setIsSearch(true);
        attributes29.setIsView(true);
        attributes29.setIsViewRelation(false);
        attributes29.setIsViewColumn(true);
//      ...................... Attributes ........................
        Entities entity51 = new Entities();
        entity51 = findBean.nameEntities("Attributes",em);
        attributes29.setEntities(entity51);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes52 = new AttributesTypes();
        attributesTypes52 = findBean.nameAttributesTypes("Boolean",em);
        attributes29.setAttributesTypes(attributesTypes52);
        em.persist(attributes29);
        em.flush();

        Attributes attributes30 = new Attributes();
        attributes30.setName("isUnique");
        attributes30.setIsNullable(true);
        attributes30.setIsUnique(false);
        attributes30.setIsSimplified(false);
        attributes30.setIsCreate(true);
        attributes30.setIsSearch(true);
        attributes30.setIsView(true);
        attributes30.setIsViewRelation(false);
        attributes30.setIsViewColumn(true);
//      ...................... Attributes ........................
        Entities entity53 = new Entities();
        entity53 = findBean.nameEntities("Attributes",em);
        attributes30.setEntities(entity53);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes54 = new AttributesTypes();
        attributesTypes54 = findBean.nameAttributesTypes("Boolean",em);
        attributes30.setAttributesTypes(attributesTypes54);
        em.persist(attributes30);
        em.flush();

        Attributes attributes31 = new Attributes();
        attributes31.setName("description");
        attributes31.setIsNullable(true);
        attributes31.setIsUnique(false);
        attributes31.setIsSimplified(false);
        attributes31.setIsCreate(true);
        attributes31.setIsSearch(true);
        attributes31.setIsView(true);
        attributes31.setIsViewRelation(false);
        attributes31.setIsViewColumn(false);
//      ...................... Attributes ........................
        Entities entity55 = new Entities();
        entity55 = findBean.nameEntities("Attributes",em);
        attributes31.setEntities(entity55);
//      ...................... String ........................
        AttributesTypes attributesTypes56 = new AttributesTypes();
        attributesTypes56 = findBean.nameAttributesTypes("String",em);
        attributes31.setAttributesTypes(attributesTypes56);
        em.persist(attributes31);
        em.flush();

        Attributes attributes32 = new Attributes();
        attributes32.setName("isSimplified");
        attributes32.setIsNullable(true);
        attributes32.setIsUnique(false);
        attributes32.setIsSimplified(false);
        attributes32.setIsCreate(true);
        attributes32.setIsSearch(true);
        attributes32.setIsView(true);
        attributes32.setIsViewRelation(false);
        attributes32.setIsViewColumn(true);
//      ...................... Attributes ........................
        Entities entity57 = new Entities();
        entity57 = findBean.nameEntities("Attributes",em);
        attributes32.setEntities(entity57);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes58 = new AttributesTypes();
        attributesTypes58 = findBean.nameAttributesTypes("Boolean",em);
        attributes32.setAttributesTypes(attributesTypes58);
        em.persist(attributes32);
        em.flush();

        Attributes attributes33 = new Attributes();
        attributes33.setName("isCreate");
        attributes33.setIsNullable(true);
        attributes33.setIsUnique(false);
        attributes33.setIsSimplified(false);
        attributes33.setIsCreate(true);
        attributes33.setIsSearch(true);
        attributes33.setIsView(true);
        attributes33.setIsViewRelation(false);
        attributes33.setIsViewColumn(false);
//      ...................... Attributes ........................
        Entities entity59 = new Entities();
        entity59 = findBean.nameEntities("Attributes",em);
        attributes33.setEntities(entity59);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes60 = new AttributesTypes();
        attributesTypes60 = findBean.nameAttributesTypes("Boolean",em);
        attributes33.setAttributesTypes(attributesTypes60);
        em.persist(attributes33);
        em.flush();

        Attributes attributes34 = new Attributes();
        attributes34.setName("isSearch");
        attributes34.setIsNullable(true);
        attributes34.setIsUnique(false);
        attributes34.setIsSimplified(false);
        attributes34.setIsCreate(true);
        attributes34.setIsSearch(true);
        attributes34.setIsView(true);
        attributes34.setIsViewRelation(false);
        attributes34.setIsViewColumn(false);
//      ...................... Attributes ........................
        Entities entity61 = new Entities();
        entity61 = findBean.nameEntities("Attributes",em);
        attributes34.setEntities(entity61);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes62 = new AttributesTypes();
        attributesTypes62 = findBean.nameAttributesTypes("Boolean",em);
        attributes34.setAttributesTypes(attributesTypes62);
        em.persist(attributes34);
        em.flush();

        Attributes attributes35 = new Attributes();
        attributes35.setName("isView");
        attributes35.setIsNullable(true);
        attributes35.setIsUnique(false);
        attributes35.setIsSimplified(false);
        attributes35.setIsCreate(true);
        attributes35.setIsSearch(true);
        attributes35.setIsView(true);
        attributes35.setIsViewRelation(false);
        attributes35.setIsViewColumn(false);
//      ...................... Attributes ........................
        Entities entity63 = new Entities();
        entity63 = findBean.nameEntities("Attributes",em);
        attributes35.setEntities(entity63);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes64 = new AttributesTypes();
        attributesTypes64 = findBean.nameAttributesTypes("Boolean",em);
        attributes35.setAttributesTypes(attributesTypes64);
        em.persist(attributes35);
        em.flush();

        Attributes attributes36 = new Attributes();
        attributes36.setName("isViewColumn");
        attributes36.setIsNullable(true);
        attributes36.setIsUnique(false);
        attributes36.setIsSimplified(false);
        attributes36.setIsCreate(true);
        attributes36.setIsSearch(true);
        attributes36.setIsView(true);
        attributes36.setIsViewRelation(false);
        attributes36.setIsViewColumn(true);
//      ...................... Attributes ........................
        Entities entity65 = new Entities();
        entity65 = findBean.nameEntities("Attributes",em);
        attributes36.setEntities(entity65);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes66 = new AttributesTypes();
        attributesTypes66 = findBean.nameAttributesTypes("Boolean",em);
        attributes36.setAttributesTypes(attributesTypes66);
        em.persist(attributes36);
        em.flush();

        Attributes attributes37 = new Attributes();
        attributes37.setName("isViewRelation");
        attributes37.setIsNullable(true);
        attributes37.setIsUnique(false);
        attributes37.setIsSimplified(false);
        attributes37.setIsCreate(true);
        attributes37.setIsSearch(true);
        attributes37.setIsView(true);
        attributes37.setIsViewRelation(false);
        attributes37.setIsViewColumn(true);
//      ...................... Attributes ........................
        Entities entity67 = new Entities();
        entity67 = findBean.nameEntities("Attributes",em);
        attributes37.setEntities(entity67);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes68 = new AttributesTypes();
        attributesTypes68 = findBean.nameAttributesTypes("Boolean",em);
        attributes37.setAttributesTypes(attributesTypes68);
        em.persist(attributes37);
        em.flush();

        Entities entities38 = new Entities();
        entities38.setName("Cardinalities");
        entities38.setIsSimplified(false);
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
        attributes39.setIsSimplified(false);
        attributes39.setIsCreate(true);
        attributes39.setIsSearch(true);
        attributes39.setIsView(true);
        attributes39.setIsViewRelation(true);
        attributes39.setIsViewColumn(true);        
//      ...................... Cardinalities ........................
        Entities entity70 = new Entities();
        entity70 = findBean.nameEntities("Cardinalities",em);
        attributes39.setEntities(entity70);
//      ...................... String ........................
        AttributesTypes attributesTypes71 = new AttributesTypes();
        attributesTypes71 = findBean.nameAttributesTypes("String",em);
        attributes39.setAttributesTypes(attributesTypes71);
        em.persist(attributes39);
        em.flush();

        Attributes attributes40 = new Attributes();
        attributes40.setName("cardinality");
        attributes40.setIsNullable(false);
        attributes40.setIsUnique(false);
        attributes40.setIsSimplified(false);
        attributes40.setIsCreate(true);
        attributes40.setIsSearch(true);
        attributes40.setIsView(true);
        attributes40.setIsViewRelation(false);
        attributes40.setIsViewColumn(true);
//      ...................... Cardinalities ........................
        Entities entity72 = new Entities();
        entity72 = findBean.nameEntities("Cardinalities",em);
        attributes40.setEntities(entity72);
//      ...................... String ........................
        AttributesTypes attributesTypes73 = new AttributesTypes();
        attributesTypes73 = findBean.nameAttributesTypes("String",em);
        attributes40.setAttributesTypes(attributesTypes73);
        em.persist(attributes40);
        em.flush();

        Attributes attributes41 = new Attributes();
        attributes41.setName("isUnidirectional");
        attributes41.setIsNullable(true);
        attributes41.setIsUnique(false);
        attributes41.setIsSimplified(false);
        attributes41.setIsCreate(true);
        attributes41.setIsSearch(true);
        attributes41.setIsView(true);
        attributes41.setIsViewRelation(false);
        attributes41.setIsViewColumn(true);        
//      ...................... Cardinalities ........................
        Entities entity74 = new Entities();
        entity74 = findBean.nameEntities("Cardinalities",em);
        attributes41.setEntities(entity74);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes75 = new AttributesTypes();
        attributesTypes75 = findBean.nameAttributesTypes("Boolean",em);
        attributes41.setAttributesTypes(attributesTypes75);
        em.persist(attributes41);
        em.flush();

        Entities entities42 = new Entities();
        entities42.setName("NameQueries");
        entities42.setIsSimplified(false);
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId76 = new GroupIds();
        groupId76 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities42.setGroupIds(groupId76);
        em.persist(entities42);
        em.flush();

        Attributes attributes43 = new Attributes();
        attributes43.setName("name");
        attributes43.setIsNullable(false);
        attributes43.setIsUnique(true);
        attributes43.setIsSimplified(false);
        attributes43.setIsCreate(true);
        attributes43.setIsSearch(true);
        attributes43.setIsView(true);
        attributes43.setIsViewRelation(true);
        attributes43.setIsViewColumn(true);        
//      ...................... NameQueries ........................
        Entities entity77 = new Entities();
        entity77 = findBean.nameEntities("NameQueries",em);
        attributes43.setEntities(entity77);
//      ...................... String ........................
        AttributesTypes attributesTypes78 = new AttributesTypes();
        attributesTypes78 = findBean.nameAttributesTypes("String",em);
        attributes43.setAttributesTypes(attributesTypes78);
        em.persist(attributes43);
        em.flush();

        Attributes attributes44 = new Attributes();
        attributes44.setName("query");
        attributes44.setIsNullable(false);
        attributes44.setIsUnique(true);
        attributes44.setIsSimplified(false);
        attributes44.setIsCreate(true);
        attributes44.setIsSearch(true);
        attributes44.setIsView(true);
        attributes44.setIsViewRelation(false);
        attributes44.setIsViewColumn(true);        
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

        Entities entities45 = new Entities();
        entities45.setName("Relationships");
        entities45.setIsSimplified(false);
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId81 = new GroupIds();
        groupId81 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities45.setGroupIds(groupId81);
        em.persist(entities45);
        em.flush();

        Attributes attributes46 = new Attributes();
        attributes46.setName("name");
        attributes46.setIsNullable(true);
        attributes46.setIsUnique(false);
        attributes46.setIsSimplified(false);
        attributes46.setIsCreate(true);
        attributes46.setIsSearch(true);
        attributes46.setIsView(true);
        attributes46.setIsViewRelation(true);
        attributes46.setIsViewColumn(true);

//      ...................... Relationships ........................
        Entities entity82 = new Entities();
        entity82 = findBean.nameEntities("Relationships",em);
        attributes46.setEntities(entity82);
//      ...................... String ........................
        AttributesTypes attributesTypes83 = new AttributesTypes();
        attributesTypes83 = findBean.nameAttributesTypes("String",em);
        attributes46.setAttributesTypes(attributesTypes83);
        em.persist(attributes46);
        em.flush();

        Attributes attributes47 = new Attributes();
        attributes47.setName("isOptionality");
        attributes47.setIsNullable(true);
        attributes47.setIsUnique(false);
        attributes47.setIsSimplified(false);
        attributes47.setIsCreate(true);
        attributes47.setIsSearch(true);
        attributes47.setIsView(true);
        attributes47.setIsViewRelation(false);
        attributes47.setIsViewColumn(true);
//      ...................... Relationships ........................
        Entities entity84 = new Entities();
        entity84 = findBean.nameEntities("Relationships",em);
        attributes47.setEntities(entity84);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes85 = new AttributesTypes();
        attributesTypes85 = findBean.nameAttributesTypes("Boolean",em);
        attributes47.setAttributesTypes(attributesTypes85);
        em.persist(attributes47);
        em.flush();

        Attributes attributes48 = new Attributes();
        attributes48.setName("isEmbedded");
        attributes48.setIsNullable(true);
        attributes48.setIsUnique(false);
        attributes48.setIsSimplified(false);
        attributes48.setIsCreate(true);
        attributes48.setIsSearch(true);
        attributes48.setIsView(true);
        attributes48.setIsViewRelation(false);
        attributes48.setIsViewColumn(true);
//      ...................... Relationships ........................
        Entities entity86 = new Entities();
        entity86 = findBean.nameEntities("Relationships",em);
        attributes48.setEntities(entity86);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes87 = new AttributesTypes();
        attributesTypes87 = findBean.nameAttributesTypes("Boolean",em);
        attributes48.setAttributesTypes(attributesTypes87);
        em.persist(attributes48);
        em.flush();

        Attributes attributes49 = new Attributes();
        attributes49.setName("isSimplified");
        attributes49.setIsNullable(true);
        attributes49.setIsUnique(false);
        attributes49.setIsSimplified(false);
        attributes49.setIsCreate(true);
        attributes49.setIsSearch(true);
        attributes49.setIsView(true);
        attributes49.setIsViewRelation(false);
        attributes49.setIsViewColumn(true);
//      ...................... Relationships ........................
        Entities entity88 = new Entities();
        entity88 = findBean.nameEntities("Relationships",em);
        attributes49.setEntities(entity88);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes89 = new AttributesTypes();
        attributesTypes89 = findBean.nameAttributesTypes("Boolean",em);
        attributes49.setAttributesTypes(attributesTypes89);
        em.persist(attributes49);
        em.flush();

        Attributes attributes50 = new Attributes();
        attributes50.setName("isCreate");
        attributes50.setIsNullable(true);
        attributes50.setIsUnique(false);
        attributes50.setIsSimplified(false);
        attributes50.setIsCreate(true);
        attributes50.setIsSearch(true);
        attributes50.setIsView(true);
        attributes50.setIsViewRelation(false);
        attributes50.setIsViewColumn(true);
//      ...................... Relationships ........................
        Entities entity90 = new Entities();
        entity90 = findBean.nameEntities("Relationships",em);
        attributes50.setEntities(entity90);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes91 = new AttributesTypes();
        attributesTypes91 = findBean.nameAttributesTypes("Boolean",em);
        attributes50.setAttributesTypes(attributesTypes91);
        em.persist(attributes50);
        em.flush();

        Attributes attributes51 = new Attributes();
        attributes51.setName("isSearch");
        attributes51.setIsNullable(true);
        attributes51.setIsUnique(false);
        attributes51.setIsSimplified(false);
        attributes51.setIsCreate(true);
        attributes51.setIsSearch(true);
        attributes51.setIsView(true);
        attributes51.setIsViewRelation(false);
        attributes51.setIsViewColumn(true);
//      ...................... Relationships ........................
        Entities entity92 = new Entities();
        entity92 = findBean.nameEntities("Relationships",em);
        attributes51.setEntities(entity92);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes93 = new AttributesTypes();
        attributesTypes93 = findBean.nameAttributesTypes("Boolean",em);
        attributes51.setAttributesTypes(attributesTypes93);
        em.persist(attributes51);
        em.flush();

        Attributes attributes52 = new Attributes();
        attributes52.setName("isView");
        attributes52.setIsNullable(true);
        attributes52.setIsUnique(false);
        attributes52.setIsSimplified(false);
        attributes52.setIsCreate(true);
        attributes52.setIsSearch(true);
        attributes52.setIsView(true);
        attributes52.setIsViewRelation(false);
        attributes52.setIsViewColumn(true);
//      ...................... Relationships ........................
        Entities entity94 = new Entities();
        entity94 = findBean.nameEntities("Relationships",em);
        attributes52.setEntities(entity94);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes95 = new AttributesTypes();
        attributesTypes95 = findBean.nameAttributesTypes("Boolean",em);
        attributes52.setAttributesTypes(attributesTypes95);
        em.persist(attributes52);
        em.flush();

        Entities entities53 = new Entities();
        entities53.setName("GroupIds");
        entities53.setIsSimplified(false);
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId96 = new GroupIds();
        groupId96 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities53.setGroupIds(groupId96);
        em.persist(entities53);
        em.flush();

        Attributes attributes54 = new Attributes();
        attributes54.setName("artifactId");
        attributes54.setIsNullable(false);
        attributes54.setIsUnique(true);
        attributes54.setIsSimplified(false);
        attributes54.setIsCreate(true);
        attributes54.setIsSearch(true);
        attributes54.setIsView(true);
        attributes54.setIsViewRelation(true);
        attributes54.setIsViewColumn(true);        
//      ...................... GroupIds ........................
        Entities entity97 = new Entities();
        entity97 = findBean.nameEntities("GroupIds",em);
        attributes54.setEntities(entity97);
//      ...................... String ........................
        AttributesTypes attributesTypes98 = new AttributesTypes();
        attributesTypes98 = findBean.nameAttributesTypes("String",em);
        attributes54.setAttributesTypes(attributesTypes98);
        em.persist(attributes54);
        em.flush();

        Attributes attributes55 = new Attributes();
        attributes55.setName("groupId");
        attributes55.setIsNullable(false);
        attributes55.setIsUnique(true);
        attributes55.setIsSimplified(false);
        attributes55.setIsCreate(true);
        attributes55.setIsSearch(true);
        attributes55.setIsView(true);
        attributes55.setIsViewRelation(false);
        attributes55.setIsViewColumn(true);        
//      ...................... GroupIds ........................
        Entities entity99 = new Entities();
        entity99 = findBean.nameEntities("GroupIds",em);
        attributes55.setEntities(entity99);
//      ...................... String ........................
        AttributesTypes attributesTypes100 = new AttributesTypes();
        attributesTypes100 = findBean.nameAttributesTypes("String",em);
        attributes55.setAttributesTypes(attributesTypes100);
        em.persist(attributes55);
        em.flush();

        Attributes attributes56 = new Attributes();
        attributes56.setName("version");
        attributes56.setIsNullable(true);
        attributes56.setIsUnique(false);
        attributes56.setIsSimplified(false);
        attributes56.setIsCreate(true);
        attributes56.setIsSearch(true);
        attributes56.setIsView(true);
        attributes56.setIsViewRelation(false);
        attributes56.setIsViewColumn(true);        
//      ...................... GroupIds ........................
        Entities entity101 = new Entities();
        entity101 = findBean.nameEntities("GroupIds",em);
        attributes56.setEntities(entity101);
//      ...................... String ........................
        AttributesTypes attributesTypes102 = new AttributesTypes();
        attributesTypes102 = findBean.nameAttributesTypes("String",em);
        attributes56.setAttributesTypes(attributesTypes102);
        em.persist(attributes56);
        em.flush();

        Attributes attributes57 = new Attributes();
        attributes57.setName("code");
        attributes57.setIsNullable(true);
        attributes57.setIsUnique(false);
        attributes57.setIsSimplified(false);
        attributes57.setIsCreate(true);
        attributes57.setIsSearch(true);
        attributes57.setIsView(true);
        attributes57.setIsViewRelation(false);
        attributes57.setIsViewColumn(true);        
//      ...................... GroupIds ........................
        Entities entity103 = new Entities();
        entity103 = findBean.nameEntities("GroupIds",em);
        attributes57.setEntities(entity103);
//      ...................... String ........................
        AttributesTypes attributesTypes104 = new AttributesTypes();
        attributesTypes104 = findBean.nameAttributesTypes("String",em);
        attributes57.setAttributesTypes(attributesTypes104);
        em.persist(attributes57);
        em.flush();

        Attributes attributes58 = new Attributes();
        attributes58.setName("date");
        attributes58.setIsNullable(true);
        attributes58.setIsUnique(false);
        attributes58.setIsSimplified(false);
        attributes58.setIsCreate(true);
        attributes58.setIsSearch(true);
        attributes58.setIsView(true);
        attributes58.setIsViewRelation(false);
        attributes58.setIsViewColumn(true);        
//      ...................... GroupIds ........................
        Entities entity105 = new Entities();
        entity105 = findBean.nameEntities("GroupIds",em);
        attributes58.setEntities(entity105);
//      ...................... Date ........................
        AttributesTypes attributesTypes106 = new AttributesTypes();
        attributesTypes106 = findBean.nameAttributesTypes("Date",em);
        attributes58.setAttributesTypes(attributesTypes106);
        em.persist(attributes58);
        em.flush();

        Entities entities59 = new Entities();
        entities59.setName("Models");
        entities59.setIsSimplified(false);
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId107 = new GroupIds();
        groupId107 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities59.setGroupIds(groupId107);
        em.persist(entities59);
        em.flush();

        Attributes attributes60 = new Attributes();
        attributes60.setName("artifactId");
        attributes60.setIsNullable(false);
        attributes60.setIsUnique(true);
        attributes60.setIsSimplified(false);
        attributes60.setIsCreate(true);
        attributes60.setIsSearch(true);
        attributes60.setIsView(true);
        attributes60.setIsViewRelation(true);
        attributes60.setIsViewColumn(true);        
//      ...................... Models ........................
        Entities entity108 = new Entities();
        entity108 = findBean.nameEntities("Models",em);
        attributes60.setEntities(entity108);
//      ...................... String ........................
        AttributesTypes attributesTypes109 = new AttributesTypes();
        attributesTypes109 = findBean.nameAttributesTypes("String",em);
        attributes60.setAttributesTypes(attributesTypes109);
        em.persist(attributes60);
        em.flush();

        Attributes attributes61 = new Attributes();
        attributes61.setName("groupId");
        attributes61.setIsNullable(false);
        attributes61.setIsUnique(true);
        attributes61.setIsSimplified(false);
        attributes61.setIsCreate(true);
        attributes61.setIsSearch(true);
        attributes61.setIsView(true);
        attributes61.setIsViewRelation(false);
        attributes61.setIsViewColumn(true);        
//      ...................... Models ........................
        Entities entity110 = new Entities();
        entity110 = findBean.nameEntities("Models",em);
        attributes61.setEntities(entity110);
//      ...................... String ........................
        AttributesTypes attributesTypes111 = new AttributesTypes();
        attributesTypes111 = findBean.nameAttributesTypes("String",em);
        attributes61.setAttributesTypes(attributesTypes111);
        em.persist(attributes61);
        em.flush();

        Attributes attributes62 = new Attributes();
        attributes62.setName("version");
        attributes62.setIsNullable(true);
        attributes62.setIsUnique(false);
        attributes62.setIsSimplified(false);
        attributes62.setIsCreate(true);
        attributes62.setIsSearch(true);
        attributes62.setIsView(true);
        attributes62.setIsViewRelation(false);
        attributes62.setIsViewColumn(true);
//      ...................... Models ........................
        Entities entity112 = new Entities();
        entity112 = findBean.nameEntities("Models",em);
        attributes62.setEntities(entity112);
//      ...................... String ........................
        AttributesTypes attributesTypes113 = new AttributesTypes();
        attributesTypes113 = findBean.nameAttributesTypes("String",em);
        attributes62.setAttributesTypes(attributesTypes113);
        em.persist(attributes62);
        em.flush();

        Attributes attributes63 = new Attributes();
        attributes63.setName("code");
        attributes63.setIsNullable(true);
        attributes63.setIsUnique(false);
        attributes63.setIsSimplified(false);
        attributes63.setIsCreate(true);
        attributes63.setIsSearch(true);
        attributes63.setIsView(true);
        attributes63.setIsViewRelation(false);
        attributes63.setIsViewColumn(true);        
//      ...................... Models ........................
        Entities entity114 = new Entities();
        entity114 = findBean.nameEntities("Models",em);
        attributes63.setEntities(entity114);
//      ...................... String ........................
        AttributesTypes attributesTypes115 = new AttributesTypes();
        attributesTypes115 = findBean.nameAttributesTypes("String",em);
        attributes63.setAttributesTypes(attributesTypes115);
        em.persist(attributes63);
        em.flush();

        Attributes attributes64 = new Attributes();
        attributes64.setName("date");
        attributes64.setIsNullable(true);
        attributes64.setIsUnique(false);
        attributes64.setIsSimplified(false);
        attributes64.setIsCreate(true);
        attributes64.setIsSearch(true);
        attributes64.setIsView(true);
        attributes64.setIsViewRelation(false);
        attributes64.setIsViewColumn(true);        
//      ...................... Models ........................
        Entities entity116 = new Entities();
        entity116 = findBean.nameEntities("Models",em);
        attributes64.setEntities(entity116);
//      ...................... Date ........................
        AttributesTypes attributesTypes117 = new AttributesTypes();
        attributesTypes117 = findBean.nameAttributesTypes("Date",em);
        attributes64.setAttributesTypes(attributesTypes117);
        em.persist(attributes64);
        em.flush();

        Entities entities65 = new Entities();
        entities65.setName("Developments");
        entities65.setIsSimplified(false);
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId118 = new GroupIds();
        groupId118 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities65.setGroupIds(groupId118);
        em.persist(entities65);
        em.flush();

        Attributes attributes66 = new Attributes();
        attributes66.setName("artifactId");
        attributes66.setIsNullable(false);
        attributes66.setIsUnique(true);
        attributes66.setIsSimplified(false);
        attributes66.setIsCreate(true);
        attributes66.setIsSearch(true);
        attributes66.setIsView(true);
        attributes66.setIsViewRelation(true);
        attributes66.setIsViewColumn(true);        
//      ...................... Developments ........................
        Entities entity119 = new Entities();
        entity119 = findBean.nameEntities("Developments",em);
        attributes66.setEntities(entity119);
//      ...................... String ........................
        AttributesTypes attributesTypes120 = new AttributesTypes();
        attributesTypes120 = findBean.nameAttributesTypes("String",em);
        attributes66.setAttributesTypes(attributesTypes120);
        em.persist(attributes66);
        em.flush();

        Attributes attributes67 = new Attributes();
        attributes67.setName("groupId");
        attributes67.setIsNullable(true);
        attributes67.setIsUnique(false);
        attributes67.setIsSimplified(false);
        attributes67.setIsCreate(true);
        attributes67.setIsSearch(true);
        attributes67.setIsView(true);
        attributes67.setIsViewRelation(false);
        attributes67.setIsViewColumn(true);        
//      ...................... Developments ........................
        Entities entity121 = new Entities();
        entity121 = findBean.nameEntities("Developments",em);
        attributes67.setEntities(entity121);
//      ...................... String ........................
        AttributesTypes attributesTypes122 = new AttributesTypes();
        attributesTypes122 = findBean.nameAttributesTypes("String",em);
        attributes67.setAttributesTypes(attributesTypes122);
        em.persist(attributes67);
        em.flush();

        Attributes attributes68 = new Attributes();
        attributes68.setName("version");
        attributes68.setIsNullable(true);
        attributes68.setIsUnique(false);
        attributes68.setIsSimplified(false);
        attributes68.setIsCreate(true);
        attributes68.setIsSearch(true);
        attributes68.setIsView(true);
        attributes68.setIsViewRelation(false);
        attributes68.setIsViewColumn(true);        
//      ...................... Developments ........................
        Entities entity123 = new Entities();
        entity123 = findBean.nameEntities("Developments",em);
        attributes68.setEntities(entity123);
//      ...................... String ........................
        AttributesTypes attributesTypes124 = new AttributesTypes();
        attributesTypes124 = findBean.nameAttributesTypes("String",em);
        attributes68.setAttributesTypes(attributesTypes124);
        em.persist(attributes68);
        em.flush();

        Attributes attributes69 = new Attributes();
        attributes69.setName("code");
        attributes69.setIsNullable(true);
        attributes69.setIsUnique(false);
        attributes69.setIsSimplified(false);
        attributes69.setIsCreate(true);
        attributes69.setIsSearch(true);
        attributes69.setIsView(true);
        attributes69.setIsViewRelation(false);
        attributes69.setIsViewColumn(true);        
//      ...................... Developments ........................
        Entities entity125 = new Entities();
        entity125 = findBean.nameEntities("Developments",em);
        attributes69.setEntities(entity125);
//      ...................... String ........................
        AttributesTypes attributesTypes126 = new AttributesTypes();
        attributesTypes126 = findBean.nameAttributesTypes("String",em);
        attributes69.setAttributesTypes(attributesTypes126);
        em.persist(attributes69);
        em.flush();

        Attributes attributes70 = new Attributes();
        attributes70.setName("date");
        attributes70.setIsNullable(true);
        attributes70.setIsUnique(false);
        attributes70.setIsSimplified(false);
        attributes70.setIsCreate(true);
        attributes70.setIsSearch(true);
        attributes70.setIsView(true);
        attributes70.setIsViewRelation(false);
        attributes70.setIsViewColumn(true);        
//      ...................... Developments ........................
        Entities entity127 = new Entities();
        entity127 = findBean.nameEntities("Developments",em);
        attributes70.setEntities(entity127);
//      ...................... Date ........................
        AttributesTypes attributesTypes128 = new AttributesTypes();
        attributesTypes128 = findBean.nameAttributesTypes("Date",em);
        attributes70.setAttributesTypes(attributesTypes128);
        em.persist(attributes70);
        em.flush();

        Entities entities71 = new Entities();
        entities71.setName("ModelsGroupIds");
        entities71.setIsSimplified(false);
//      ...................... co.simasoft.models.dev.naifg ........................
        GroupIds groupId129 = new GroupIds();
        groupId129 = findBean.groupIdGroupIds("co.simasoft.models.dev.naifg",em);
        entities71.setGroupIds(groupId129);
        em.persist(entities71);
        em.flush();

        Attributes attributes72 = new Attributes();
        attributes72.setName("isIsolated");
        attributes72.setIsNullable(true);
        attributes72.setIsUnique(false);
        attributes72.setIsSimplified(false);
        attributes72.setIsCreate(true);
        attributes72.setIsSearch(true);
        attributes72.setIsView(true);
        attributes72.setIsViewRelation(false);
        attributes72.setIsViewColumn(true);        
//      ...................... ModelsGroupIds ........................
        Entities entity130 = new Entities();
        entity130 = findBean.nameEntities("ModelsGroupIds",em);
        attributes72.setEntities(entity130);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes131 = new AttributesTypes();
        attributesTypes131 = findBean.nameAttributesTypes("Boolean",em);
        attributes72.setAttributesTypes(attributesTypes131);
        em.persist(attributes72);
        em.flush();

        Attributes attributes73 = new Attributes();
        attributes73.setName("isSimplified");
        attributes73.setIsNullable(true);
        attributes73.setIsUnique(false);
        attributes73.setIsSimplified(false);
        attributes73.setIsCreate(true);
        attributes73.setIsSearch(true);
        attributes73.setIsView(true);
        attributes73.setIsViewRelation(false);
        attributes73.setIsViewColumn(true);
//      ...................... ModelsGroupIds ........................
        Entities entity132 = new Entities();
        entity132 = findBean.nameEntities("ModelsGroupIds",em);
        attributes73.setEntities(entity132);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes133 = new AttributesTypes();
        attributesTypes133 = findBean.nameAttributesTypes("Boolean",em);
        attributes73.setAttributesTypes(attributesTypes133);
        em.persist(attributes73);
        em.flush();

//      ---------------------- Relationships ------------------------

/*
*/
/*
. Entities . *..* Sites rolA:from rolB: OK

. Attributes . *..* AttributesProperties rolA:from rolB: OK

. Entities . *..* AttributesProperties rolA:from rolB: OK

. Entities . *..* Imports rolA:from rolB: OK

. Cardinalities . *..* Imports rolA:from rolB: OK

. Models . *..* Sites rolA:from rolB: OK

. Developments . *..* Sites rolA:from rolB: OK

. AttributesTypes . 1..* Attributes rolA: rolB:

. Relationships . *..* AttributesProperties rolA:from rolB: OK

. Cardinalities . *..* Sites rolA:from rolB: OK

. Attributes . *..* Sites rolA:from rolB: OK

*/
        Relationships relationships1 = new Relationships();
        relationships1.setIsOptionality(true);
        relationships1.setIsEmbedded(false);
        relationships1.setIsSimplified(false);
        relationships1.setIsCreate(true);
        relationships1.setIsSearch(true);
        relationships1.setIsView(true);
//      ...................... Entities ........................
        Entities entities134 = new Entities();
        entities134 = findBean.nameEntities("Entities",em);
        relationships1.setFrom(entities134);
//      ...................... Sites ........................
        Entities entities135 = new Entities();
        entities135 = findBean.nameEntities("Sites",em);
        relationships1.setTo(entities135);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities136 = new Cardinalities();
        cardinalities136 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships1.setCardinalities(cardinalities136);
        em.persist(relationships1);
        em.flush();

        Relationships relationships2 = new Relationships();
        relationships2.setIsOptionality(true);
        relationships2.setIsEmbedded(false);
        relationships2.setIsSimplified(false);
        relationships2.setIsCreate(true);
        relationships2.setIsSearch(true);
        relationships2.setIsView(true);
//      ...................... Attributes ........................
        Entities entities137 = new Entities();
        entities137 = findBean.nameEntities("Attributes",em);
        relationships2.setFrom(entities137);
//      ...................... AttributesProperties ........................
        Entities entities138 = new Entities();
        entities138 = findBean.nameEntities("AttributesProperties",em);
        relationships2.setTo(entities138);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities139 = new Cardinalities();
        cardinalities139 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships2.setCardinalities(cardinalities139);
        em.persist(relationships2);
        em.flush();

        Relationships relationships3 = new Relationships();
        relationships3.setIsOptionality(true);
        relationships3.setIsEmbedded(false);
        relationships3.setIsSimplified(false);
        relationships3.setIsCreate(true);
        relationships3.setIsSearch(true);
        relationships3.setIsView(true);
//      ...................... Entities ........................
        Entities entities140 = new Entities();
        entities140 = findBean.nameEntities("Entities",em);
        relationships3.setFrom(entities140);
//      ...................... AttributesProperties ........................
        Entities entities141 = new Entities();
        entities141 = findBean.nameEntities("AttributesProperties",em);
        relationships3.setTo(entities141);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities142 = new Cardinalities();
        cardinalities142 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships3.setCardinalities(cardinalities142);
        em.persist(relationships3);
        em.flush();

        Relationships relationships4 = new Relationships();
        relationships4.setIsOptionality(true);
        relationships4.setIsEmbedded(false);
        relationships4.setIsSimplified(false);
        relationships4.setIsCreate(true);
        relationships4.setIsSearch(true);
        relationships4.setIsView(true);
//      ...................... Entities ........................
        Entities entities143 = new Entities();
        entities143 = findBean.nameEntities("Entities",em);
        relationships4.setFrom(entities143);
//      ...................... Imports ........................
        Entities entities144 = new Entities();
        entities144 = findBean.nameEntities("Imports",em);
        relationships4.setTo(entities144);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities145 = new Cardinalities();
        cardinalities145 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships4.setCardinalities(cardinalities145);
        em.persist(relationships4);
        em.flush();

        Relationships relationships5 = new Relationships();
        relationships5.setIsOptionality(true);
        relationships5.setIsEmbedded(false);
        relationships5.setIsSimplified(false);
        relationships5.setIsCreate(true);
        relationships5.setIsSearch(true);
        relationships5.setIsView(true);
//      ...................... Cardinalities ........................
        Entities entities146 = new Entities();
        entities146 = findBean.nameEntities("Cardinalities",em);
        relationships5.setFrom(entities146);
//      ...................... Imports ........................
        Entities entities147 = new Entities();
        entities147 = findBean.nameEntities("Imports",em);
        relationships5.setTo(entities147);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities148 = new Cardinalities();
        cardinalities148 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships5.setCardinalities(cardinalities148);
        em.persist(relationships5);
        em.flush();

        Relationships relationships6 = new Relationships();
        relationships6.setIsOptionality(true);
        relationships6.setIsEmbedded(false);
        relationships6.setIsSimplified(false);
        relationships6.setIsCreate(true);
        relationships6.setIsSearch(true);
        relationships6.setIsView(true);
//      ...................... Models ........................
        Entities entities149 = new Entities();
        entities149 = findBean.nameEntities("Models",em);
        relationships6.setFrom(entities149);
//      ...................... Sites ........................
        Entities entities150 = new Entities();
        entities150 = findBean.nameEntities("Sites",em);
        relationships6.setTo(entities150);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities151 = new Cardinalities();
        cardinalities151 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships6.setCardinalities(cardinalities151);
        em.persist(relationships6);
        em.flush();

        Relationships relationships7 = new Relationships();
        relationships7.setIsOptionality(true);
        relationships7.setIsEmbedded(false);
        relationships7.setIsSimplified(false);
        relationships7.setIsCreate(true);
        relationships7.setIsSearch(true);
        relationships7.setIsView(true);
//      ...................... Developments ........................
        Entities entities152 = new Entities();
        entities152 = findBean.nameEntities("Developments",em);
        relationships7.setFrom(entities152);
//      ...................... Sites ........................
        Entities entities153 = new Entities();
        entities153 = findBean.nameEntities("Sites",em);
        relationships7.setTo(entities153);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities154 = new Cardinalities();
        cardinalities154 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships7.setCardinalities(cardinalities154);
        em.persist(relationships7);
        em.flush();

        Relationships relationships8 = new Relationships();
        relationships8.setIsOptionality(true);
        relationships8.setIsEmbedded(false);
        relationships8.setIsSimplified(false);
        relationships8.setIsCreate(true);
        relationships8.setIsSearch(true);
        relationships8.setIsView(true);
//      ...................... AttributesTypes ........................
        Entities entities155 = new Entities();
        entities155 = findBean.nameEntities("AttributesTypes",em);
        relationships8.setFrom(entities155);
//      ...................... Attributes ........................
        Entities entities156 = new Entities();
        entities156 = findBean.nameEntities("Attributes",em);
        relationships8.setTo(entities156);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities157 = new Cardinalities();
        cardinalities157 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships8.setCardinalities(cardinalities157);
        em.persist(relationships8);
        em.flush();

        Relationships relationships9 = new Relationships();
        relationships9.setIsOptionality(true);
        relationships9.setIsEmbedded(false);
        relationships9.setIsSimplified(false);
        relationships9.setIsCreate(true);
        relationships9.setIsSearch(true);
        relationships9.setIsView(true);
//      ...................... Relationships ........................
        Entities entities158 = new Entities();
        entities158 = findBean.nameEntities("Relationships",em);
        relationships9.setFrom(entities158);
//      ...................... AttributesProperties ........................
        Entities entities159 = new Entities();
        entities159 = findBean.nameEntities("AttributesProperties",em);
        relationships9.setTo(entities159);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities160 = new Cardinalities();
        cardinalities160 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships9.setCardinalities(cardinalities160);
        em.persist(relationships9);
        em.flush();

        Relationships relationships10 = new Relationships();
        relationships10.setIsOptionality(true);
        relationships10.setIsEmbedded(false);
        relationships10.setIsSimplified(false);
        relationships10.setIsCreate(true);
        relationships10.setIsSearch(true);
        relationships10.setIsView(true);
//      ...................... Cardinalities ........................
        Entities entities161 = new Entities();
        entities161 = findBean.nameEntities("Cardinalities",em);
        relationships10.setFrom(entities161);
//      ...................... Sites ........................
        Entities entities162 = new Entities();
        entities162 = findBean.nameEntities("Sites",em);
        relationships10.setTo(entities162);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities163 = new Cardinalities();
        cardinalities163 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships10.setCardinalities(cardinalities163);
        em.persist(relationships10);
        em.flush();

        Relationships relationships11 = new Relationships();
        relationships11.setIsOptionality(true);
        relationships11.setIsEmbedded(false);
        relationships11.setIsSimplified(false);
        relationships11.setIsCreate(true);
        relationships11.setIsSearch(true);
        relationships11.setIsView(true);
//      ...................... Attributes ........................
        Entities entities164 = new Entities();
        entities164 = findBean.nameEntities("Attributes",em);
        relationships11.setFrom(entities164);
//      ...................... Sites ........................
        Entities entities165 = new Entities();
        entities165 = findBean.nameEntities("Sites",em);
        relationships11.setTo(entities165);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities166 = new Cardinalities();
        cardinalities166 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships11.setCardinalities(cardinalities166);
        em.persist(relationships11);
        em.flush();

/*
. AttributesTypes . *..* AttributesProperties rolA:from rolB: OK

. Dependencies . 1..* Imports rolA: rolB:

. AttributesProperties . *..* Imports rolA:from rolB: OK

*/
        Relationships relationships12 = new Relationships();
        relationships12.setIsOptionality(true);
        relationships12.setIsEmbedded(false);
        relationships12.setIsSimplified(false);
        relationships12.setIsCreate(true);
        relationships12.setIsSearch(true);
        relationships12.setIsView(true);
//      ...................... AttributesTypes ........................
        Entities entities167 = new Entities();
        entities167 = findBean.nameEntities("AttributesTypes",em);
        relationships12.setFrom(entities167);
//      ...................... AttributesProperties ........................
        Entities entities168 = new Entities();
        entities168 = findBean.nameEntities("AttributesProperties",em);
        relationships12.setTo(entities168);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities169 = new Cardinalities();
        cardinalities169 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships12.setCardinalities(cardinalities169);
        em.persist(relationships12);
        em.flush();

        Relationships relationships13 = new Relationships();
        relationships13.setIsOptionality(true);
        relationships13.setIsEmbedded(false);
        relationships13.setIsSimplified(false);
        relationships13.setIsCreate(true);
        relationships13.setIsSearch(true);
        relationships13.setIsView(true);
//      ...................... Dependencies ........................
        Entities entities170 = new Entities();
        entities170 = findBean.nameEntities("Dependencies",em);
        relationships13.setFrom(entities170);
//      ...................... Imports ........................
        Entities entities171 = new Entities();
        entities171 = findBean.nameEntities("Imports",em);
        relationships13.setTo(entities171);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities172 = new Cardinalities();
        cardinalities172 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships13.setCardinalities(cardinalities172);
        em.persist(relationships13);
        em.flush();

        Relationships relationships14 = new Relationships();
        relationships14.setIsOptionality(true);
        relationships14.setIsEmbedded(false);
        relationships14.setIsSimplified(false);
        relationships14.setIsCreate(true);
        relationships14.setIsSearch(true);
        relationships14.setIsView(true);
//      ...................... AttributesProperties ........................
        Entities entities173 = new Entities();
        entities173 = findBean.nameEntities("AttributesProperties",em);
        relationships14.setFrom(entities173);
//      ...................... Imports ........................
        Entities entities174 = new Entities();
        entities174 = findBean.nameEntities("Imports",em);
        relationships14.setTo(entities174);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities175 = new Cardinalities();
        cardinalities175 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships14.setCardinalities(cardinalities175);
        em.persist(relationships14);
        em.flush();

/*
. GroupIds . 1..* ModelsGroupIds rolA: rolB:

. Models . 1..* ModelsGroupIds rolA: rolB:

. Cardinalities . 1..* Relationships rolA: rolB:

. Entities . 1..* Attributes rolA: rolB:

. Entities . 1..* NameQueries rolA: rolB:

. GroupIds . 1..* Entities rolA: rolB:

. Developments . *..* Models rolA:from rolB: OK

. Entities . 1..* Relationships rolA: rolB:

. Entities . 1..* Relationships rolA: rolB:

*/
        Relationships relationships15 = new Relationships();
        relationships15.setIsOptionality(true);
        relationships15.setIsEmbedded(false);
        relationships15.setIsSimplified(false);
        relationships15.setIsCreate(true);
        relationships15.setIsSearch(true);
        relationships15.setIsView(true);
//      ...................... GroupIds ........................
        Entities entities176 = new Entities();
        entities176 = findBean.nameEntities("GroupIds",em);
        relationships15.setFrom(entities176);
//      ...................... ModelsGroupIds ........................
        Entities entities177 = new Entities();
        entities177 = findBean.nameEntities("ModelsGroupIds",em);
        relationships15.setTo(entities177);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities178 = new Cardinalities();
        cardinalities178 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships15.setCardinalities(cardinalities178);
        em.persist(relationships15);
        em.flush();

        Relationships relationships16 = new Relationships();
        relationships16.setIsOptionality(true);
        relationships16.setIsEmbedded(false);
        relationships16.setIsSimplified(false);
        relationships16.setIsCreate(true);
        relationships16.setIsSearch(true);
        relationships16.setIsView(true);
//      ...................... Models ........................
        Entities entities179 = new Entities();
        entities179 = findBean.nameEntities("Models",em);
        relationships16.setFrom(entities179);
//      ...................... ModelsGroupIds ........................
        Entities entities180 = new Entities();
        entities180 = findBean.nameEntities("ModelsGroupIds",em);
        relationships16.setTo(entities180);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities181 = new Cardinalities();
        cardinalities181 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships16.setCardinalities(cardinalities181);
        em.persist(relationships16);
        em.flush();

        Relationships relationships17 = new Relationships();
        relationships17.setIsOptionality(true);
        relationships17.setIsEmbedded(false);
        relationships17.setIsSimplified(false);
        relationships17.setIsCreate(true);
        relationships17.setIsSearch(true);
        relationships17.setIsView(true);
//      ...................... Cardinalities ........................
        Entities entities182 = new Entities();
        entities182 = findBean.nameEntities("Cardinalities",em);
        relationships17.setFrom(entities182);
//      ...................... Relationships ........................
        Entities entities183 = new Entities();
        entities183 = findBean.nameEntities("Relationships",em);
        relationships17.setTo(entities183);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities184 = new Cardinalities();
        cardinalities184 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships17.setCardinalities(cardinalities184);
        em.persist(relationships17);
        em.flush();

        Relationships relationships18 = new Relationships();
        relationships18.setIsOptionality(true);
        relationships18.setIsEmbedded(false);
        relationships18.setIsSimplified(false);
        relationships18.setIsCreate(true);
        relationships18.setIsSearch(true);
        relationships18.setIsView(true);
//      ...................... Entities ........................
        Entities entities185 = new Entities();
        entities185 = findBean.nameEntities("Entities",em);
        relationships18.setFrom(entities185);
//      ...................... Attributes ........................
        Entities entities186 = new Entities();
        entities186 = findBean.nameEntities("Attributes",em);
        relationships18.setTo(entities186);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities187 = new Cardinalities();
        cardinalities187 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships18.setCardinalities(cardinalities187);
        em.persist(relationships18);
        em.flush();

        Relationships relationships19 = new Relationships();
        relationships19.setIsOptionality(true);
        relationships19.setIsEmbedded(false);
        relationships19.setIsSimplified(false);
        relationships19.setIsCreate(true);
        relationships19.setIsSearch(true);
        relationships19.setIsView(true);
//      ...................... Entities ........................
        Entities entities188 = new Entities();
        entities188 = findBean.nameEntities("Entities",em);
        relationships19.setFrom(entities188);
//      ...................... NameQueries ........................
        Entities entities189 = new Entities();
        entities189 = findBean.nameEntities("NameQueries",em);
        relationships19.setTo(entities189);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities190 = new Cardinalities();
        cardinalities190 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships19.setCardinalities(cardinalities190);
        em.persist(relationships19);
        em.flush();

        Relationships relationships20 = new Relationships();
        relationships20.setIsOptionality(true);
        relationships20.setIsEmbedded(false);
        relationships20.setIsSimplified(false);
        relationships20.setIsCreate(true);
        relationships20.setIsSearch(true);
        relationships20.setIsView(true);
//      ...................... GroupIds ........................
        Entities entities191 = new Entities();
        entities191 = findBean.nameEntities("GroupIds",em);
        relationships20.setFrom(entities191);
//      ...................... Entities ........................
        Entities entities192 = new Entities();
        entities192 = findBean.nameEntities("Entities",em);
        relationships20.setTo(entities192);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities193 = new Cardinalities();
        cardinalities193 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships20.setCardinalities(cardinalities193);
        em.persist(relationships20);
        em.flush();

        Relationships relationships21 = new Relationships();
        relationships21.setIsOptionality(true);
        relationships21.setIsEmbedded(false);
        relationships21.setIsSimplified(false);
        relationships21.setIsCreate(true);
        relationships21.setIsSearch(true);
        relationships21.setIsView(true);
//      ...................... Developments ........................
        Entities entities194 = new Entities();
        entities194 = findBean.nameEntities("Developments",em);
        relationships21.setFrom(entities194);
//      ...................... Models ........................
        Entities entities195 = new Entities();
        entities195 = findBean.nameEntities("Models",em);
        relationships21.setTo(entities195);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities196 = new Cardinalities();
        cardinalities196 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships21.setCardinalities(cardinalities196);
        em.persist(relationships21);
        em.flush();

        Relationships relationships22 = new Relationships();
        relationships22.setIsOptionality(true);
        relationships22.setIsEmbedded(false);
        relationships22.setIsSimplified(false);
        relationships22.setIsCreate(true);
        relationships22.setIsSearch(true);
        relationships22.setIsView(true);
//      ...................... Entities ........................
        Entities entities197 = new Entities();
        entities197 = findBean.nameEntities("Entities",em);
        relationships22.setFrom(entities197);
//      ...................... Relationships ........................
        Entities entities198 = new Entities();
        entities198 = findBean.nameEntities("Relationships",em);
        relationships22.setTo(entities198);
        relationships22.setName("from");
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities199 = new Cardinalities();
        cardinalities199 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships22.setCardinalities(cardinalities199);
        em.persist(relationships22);
        em.flush();

        Relationships relationships23 = new Relationships();
        relationships23.setIsOptionality(true);
        relationships23.setIsEmbedded(false);
        relationships23.setIsSimplified(false);
        relationships23.setIsCreate(true);
        relationships23.setIsSearch(true);
        relationships23.setIsView(true);
//      ...................... Entities ........................
        Entities entities200 = new Entities();
        entities200 = findBean.nameEntities("Entities",em);
        relationships23.setFrom(entities200);
        relationships23.setName("to");
//      ...................... Relationships ........................
        Entities entities201 = new Entities();
        entities201 = findBean.nameEntities("Relationships",em);
        relationships23.setTo(entities201);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities202 = new Cardinalities();
        cardinalities202 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships23.setCardinalities(cardinalities202);
        em.persist(relationships23);
        em.flush();

/*
. Imports . *..* Sites rolA:from rolB: OK

. Dependencies . *..* Sites rolA:from rolB: OK

. AttributesTypes . *..* Sites rolA:from rolB: OK

. AttributesProperties . *..* Sites rolA:from rolB: OK

*/
        Relationships relationships24 = new Relationships();
        relationships24.setIsOptionality(true);
        relationships24.setIsEmbedded(false);
        relationships24.setIsSimplified(false);
        relationships24.setIsCreate(true);
        relationships24.setIsSearch(true);
        relationships24.setIsView(true);
//      ...................... Imports ........................
        Entities entities203 = new Entities();
        entities203 = findBean.nameEntities("Imports",em);
        relationships24.setFrom(entities203);
//      ...................... Sites ........................
        Entities entities204 = new Entities();
        entities204 = findBean.nameEntities("Sites",em);
        relationships24.setTo(entities204);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities205 = new Cardinalities();
        cardinalities205 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships24.setCardinalities(cardinalities205);
        em.persist(relationships24);
        em.flush();

        Relationships relationships25 = new Relationships();
        relationships25.setIsOptionality(true);
        relationships25.setIsEmbedded(false);
        relationships25.setIsSimplified(false);
        relationships25.setIsCreate(true);
        relationships25.setIsSearch(true);
        relationships25.setIsView(true);
//      ...................... Dependencies ........................
        Entities entities206 = new Entities();
        entities206 = findBean.nameEntities("Dependencies",em);
        relationships25.setFrom(entities206);
//      ...................... Sites ........................
        Entities entities207 = new Entities();
        entities207 = findBean.nameEntities("Sites",em);
        relationships25.setTo(entities207);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities208 = new Cardinalities();
        cardinalities208 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships25.setCardinalities(cardinalities208);
        em.persist(relationships25);
        em.flush();

        Relationships relationships26 = new Relationships();
        relationships26.setIsOptionality(true);
        relationships26.setIsEmbedded(false);
        relationships26.setIsSimplified(false);
        relationships26.setIsCreate(true);
        relationships26.setIsSearch(true);
        relationships26.setIsView(true);
//      ...................... AttributesTypes ........................
        Entities entities209 = new Entities();
        entities209 = findBean.nameEntities("AttributesTypes",em);
        relationships26.setFrom(entities209);
//      ...................... Sites ........................
        Entities entities210 = new Entities();
        entities210 = findBean.nameEntities("Sites",em);
        relationships26.setTo(entities210);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities211 = new Cardinalities();
        cardinalities211 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships26.setCardinalities(cardinalities211);
        em.persist(relationships26);
        em.flush();

        Relationships relationships27 = new Relationships();
        relationships27.setIsOptionality(true);
        relationships27.setIsEmbedded(false);
        relationships27.setIsSimplified(false);
        relationships27.setIsCreate(true);
        relationships27.setIsSearch(true);
        relationships27.setIsView(true);
//      ...................... AttributesProperties ........................
        Entities entities212 = new Entities();
        entities212 = findBean.nameEntities("AttributesProperties",em);
        relationships27.setFrom(entities212);
//      ...................... Sites ........................
        Entities entities213 = new Entities();
        entities213 = findBean.nameEntities("Sites",em);
        relationships27.setTo(entities213);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities214 = new Cardinalities();
        cardinalities214 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships27.setCardinalities(cardinalities214);
        em.persist(relationships27);
        em.flush();

/*
*/
    } // data()

} // naifg
