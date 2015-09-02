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

//      ---------------------- Models ------------------------

        Models models = new Models();
        models.setArtifactId("naifg");
        models.setGroupId("co.simasoft.naifg");
        models.setVersion("1.0-SNAPSHOT");
        models.setCode("null");
        em.persist(models);
        em.flush();

//      ---------------------- ModelsGroupIds ----------------------

        ModelsGroupIds modelsGroupIds1 = new ModelsGroupIds();
        Models modelss1 = findBean.artifactIdModels("naifg",em);
        GroupIds groupIdd1 = findBean.artifactIdGroupIds("co.simasoft.models.dev.naifg",em);
        modelsGroupIds1.setModels(modelss1);
        modelsGroupIds1.setGroupIds(groupIdd1);
        modelsGroupIds1.setIsSingle(false);
        modelsGroupIds1.setIsSimplified(false);
        em.persist(modelsGroupIds1);
        em.flush();

        ModelsGroupIds modelsGroupIds2 = new ModelsGroupIds();
        Models modelss2 = findBean.artifactIdModels("naifg",em);
        GroupIds groupIdd2 = findBean.artifactIdGroupIds("co.simasoft.models.dev.naifg.dependencies",em);
        modelsGroupIds2.setModels(modelss2);
        modelsGroupIds2.setGroupIds(groupIdd2);
        modelsGroupIds2.setIsSingle(false);
        modelsGroupIds2.setIsSimplified(false);
        em.persist(modelsGroupIds2);
        em.flush();

        ModelsGroupIds modelsGroupIds3 = new ModelsGroupIds();
        Models modelss3 = findBean.artifactIdModels("naifg",em);
        GroupIds groupIdd3 = findBean.artifactIdGroupIds("co.simasoft.models.core.sites",em);
        modelsGroupIds3.setModels(modelss3);
        modelsGroupIds3.setGroupIds(groupIdd3);
        modelsGroupIds3.setIsSingle(true);
        modelsGroupIds3.setIsSimplified(true);
        em.persist(modelsGroupIds3);
        em.flush();

//      ---------------------- Developments ------------------------

        Developments dev = new Developments();
        dev.setGroupId("co.simasoft");
        dev.setArtifactId("naifg");
        dev.setVersion("1.0-SNAPSHOT");
        dev.setCode("null");
        Set<Models> models1 = new HashSet<Models>();
        Models model1 = findBean.artifactIdModels("naifg",em);
        models1.add(model1);
        dev.setModels(models1);
        dev.setVersion("1.0-SNAPSHOT");
        dev.setCode("null");
        em.persist(dev);
        em.flush();

//      ---------------------- Entities ------------------------

//      ---------------------- Relationships ------------------------

/*
. Models . 1..* ModelsGroupIds
. Models . *..* Sites
. Attributes . *..* AttributesProperties
. Attributes . *..* Sites
. Relationships . *..* AttributesProperties
. Developments . *..* Models
. Developments . *..* Sites
. GroupIds . 1..* Entities
. GroupIds . 1..* ModelsGroupIds
. Cardinalities . *..* Imports
. Cardinalities . 1..* Relationships
. Cardinalities . *..* Sites
. Entities . 1..* Attributes
. Entities . 1..* NameQueries
. Entities . *..* Imports
. Entities . *..* AttributesProperties
. Entities . *..* Sites
. Entities . 1..* Relationships
. Entities . 1..* Relationships
. Imports . *..* Sites
. Dependencies . 1..* Imports
. Dependencies . *..* Sites
. AttributesProperties . *..* Imports
. AttributesProperties . *..* Sites
. AttributesTypes . *..* Sites
. AttributesTypes . *..* AttributesProperties
. AttributesTypes . 1..* Attributes
. SitesTypes . 1..* SitesTypes
. SitesTypes . *..* Sites
*/
        Relationships relationships1 = new Relationships();
        relationships1.setIsOptionality(true);
        relationships1.setIsEmbedded(false);
        relationships1.setName("");
//      ...................... Models ........................
        Entities entities1 = new Entities();
        entities1 = findBean.nameEntities("Models",em);
        relationships1.setFrom(entities1);
//      ...................... ModelsGroupIds ........................
        Entities entities2 = new Entities();
        entities2 = findBean.nameEntities("ModelsGroupIds",em);
        relationships1.setTo(entities2);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities3 = new Cardinalities();
        cardinalities3 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships1.setCardinalities(cardinalities3);
        em.persist(relationships1);
        em.flush();

        Relationships relationships2 = new Relationships();
        relationships2.setIsOptionality(true);
        relationships2.setIsEmbedded(false);
        relationships2.setName("");
//      ...................... Models ........................
        Entities entities4 = new Entities();
        entities4 = findBean.nameEntities("Models",em);
        relationships2.setFrom(entities4);
//      ...................... Sites ........................
        Entities entities5 = new Entities();
        entities5 = findBean.nameEntities("Sites",em);
        relationships2.setTo(entities5);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities6 = new Cardinalities();
        cardinalities6 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships2.setCardinalities(cardinalities6);
        em.persist(relationships2);
        em.flush();

        Relationships relationships3 = new Relationships();
        relationships3.setIsOptionality(true);
        relationships3.setIsEmbedded(false);
        relationships3.setName("");
//      ...................... Attributes ........................
        Entities entities7 = new Entities();
        entities7 = findBean.nameEntities("Attributes",em);
        relationships3.setFrom(entities7);
//      ...................... AttributesProperties ........................
        Entities entities8 = new Entities();
        entities8 = findBean.nameEntities("AttributesProperties",em);
        relationships3.setTo(entities8);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities9 = new Cardinalities();
        cardinalities9 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships3.setCardinalities(cardinalities9);
        em.persist(relationships3);
        em.flush();

        Relationships relationships4 = new Relationships();
        relationships4.setIsOptionality(true);
        relationships4.setIsEmbedded(false);
        relationships4.setName("");
//      ...................... Attributes ........................
        Entities entities10 = new Entities();
        entities10 = findBean.nameEntities("Attributes",em);
        relationships4.setFrom(entities10);
//      ...................... Sites ........................
        Entities entities11 = new Entities();
        entities11 = findBean.nameEntities("Sites",em);
        relationships4.setTo(entities11);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities12 = new Cardinalities();
        cardinalities12 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships4.setCardinalities(cardinalities12);
        em.persist(relationships4);
        em.flush();

        Relationships relationships5 = new Relationships();
        relationships5.setIsOptionality(true);
        relationships5.setIsEmbedded(false);
        relationships5.setName("");
//      ...................... Relationships ........................
        Entities entities13 = new Entities();
        entities13 = findBean.nameEntities("Relationships",em);
        relationships5.setFrom(entities13);
//      ...................... AttributesProperties ........................
        Entities entities14 = new Entities();
        entities14 = findBean.nameEntities("AttributesProperties",em);
        relationships5.setTo(entities14);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities15 = new Cardinalities();
        cardinalities15 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships5.setCardinalities(cardinalities15);
        em.persist(relationships5);
        em.flush();

        Relationships relationships6 = new Relationships();
        relationships6.setIsOptionality(true);
        relationships6.setIsEmbedded(false);
        relationships6.setName("");
//      ...................... Developments ........................
        Entities entities16 = new Entities();
        entities16 = findBean.nameEntities("Developments",em);
        relationships6.setFrom(entities16);
//      ...................... Models ........................
        Entities entities17 = new Entities();
        entities17 = findBean.nameEntities("Models",em);
        relationships6.setTo(entities17);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities18 = new Cardinalities();
        cardinalities18 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships6.setCardinalities(cardinalities18);
        em.persist(relationships6);
        em.flush();

        Relationships relationships7 = new Relationships();
        relationships7.setIsOptionality(true);
        relationships7.setIsEmbedded(false);
        relationships7.setName("");
//      ...................... Developments ........................
        Entities entities19 = new Entities();
        entities19 = findBean.nameEntities("Developments",em);
        relationships7.setFrom(entities19);
//      ...................... Sites ........................
        Entities entities20 = new Entities();
        entities20 = findBean.nameEntities("Sites",em);
        relationships7.setTo(entities20);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities21 = new Cardinalities();
        cardinalities21 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships7.setCardinalities(cardinalities21);
        em.persist(relationships7);
        em.flush();

        Relationships relationships8 = new Relationships();
        relationships8.setIsOptionality(true);
        relationships8.setIsEmbedded(false);
        relationships8.setName("");
//      ...................... GroupIds ........................
        Entities entities22 = new Entities();
        entities22 = findBean.nameEntities("GroupIds",em);
        relationships8.setFrom(entities22);
//      ...................... Entities ........................
        Entities entities23 = new Entities();
        entities23 = findBean.nameEntities("Entities",em);
        relationships8.setTo(entities23);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities24 = new Cardinalities();
        cardinalities24 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships8.setCardinalities(cardinalities24);
        em.persist(relationships8);
        em.flush();

        Relationships relationships9 = new Relationships();
        relationships9.setIsOptionality(true);
        relationships9.setIsEmbedded(false);
        relationships9.setName("");
//      ...................... GroupIds ........................
        Entities entities25 = new Entities();
        entities25 = findBean.nameEntities("GroupIds",em);
        relationships9.setFrom(entities25);
//      ...................... ModelsGroupIds ........................
        Entities entities26 = new Entities();
        entities26 = findBean.nameEntities("ModelsGroupIds",em);
        relationships9.setTo(entities26);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities27 = new Cardinalities();
        cardinalities27 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships9.setCardinalities(cardinalities27);
        em.persist(relationships9);
        em.flush();

        Relationships relationships10 = new Relationships();
        relationships10.setIsOptionality(true);
        relationships10.setIsEmbedded(false);
        relationships10.setName("");
//      ...................... Cardinalities ........................
        Entities entities28 = new Entities();
        entities28 = findBean.nameEntities("Cardinalities",em);
        relationships10.setFrom(entities28);
//      ...................... Imports ........................
        Entities entities29 = new Entities();
        entities29 = findBean.nameEntities("Imports",em);
        relationships10.setTo(entities29);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities30 = new Cardinalities();
        cardinalities30 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships10.setCardinalities(cardinalities30);
        em.persist(relationships10);
        em.flush();

        Relationships relationships11 = new Relationships();
        relationships11.setIsOptionality(true);
        relationships11.setIsEmbedded(false);
        relationships11.setName("");
//      ...................... Cardinalities ........................
        Entities entities31 = new Entities();
        entities31 = findBean.nameEntities("Cardinalities",em);
        relationships11.setFrom(entities31);
//      ...................... Relationships ........................
        Entities entities32 = new Entities();
        entities32 = findBean.nameEntities("Relationships",em);
        relationships11.setTo(entities32);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities33 = new Cardinalities();
        cardinalities33 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships11.setCardinalities(cardinalities33);
        em.persist(relationships11);
        em.flush();

        Relationships relationships12 = new Relationships();
        relationships12.setIsOptionality(true);
        relationships12.setIsEmbedded(false);
        relationships12.setName("");
//      ...................... Cardinalities ........................
        Entities entities34 = new Entities();
        entities34 = findBean.nameEntities("Cardinalities",em);
        relationships12.setFrom(entities34);
//      ...................... Sites ........................
        Entities entities35 = new Entities();
        entities35 = findBean.nameEntities("Sites",em);
        relationships12.setTo(entities35);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities36 = new Cardinalities();
        cardinalities36 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships12.setCardinalities(cardinalities36);
        em.persist(relationships12);
        em.flush();

        Relationships relationships13 = new Relationships();
        relationships13.setIsOptionality(true);
        relationships13.setIsEmbedded(false);
        relationships13.setName("");
//      ...................... Entities ........................
        Entities entities37 = new Entities();
        entities37 = findBean.nameEntities("Entities",em);
        relationships13.setFrom(entities37);
//      ...................... Attributes ........................
        Entities entities38 = new Entities();
        entities38 = findBean.nameEntities("Attributes",em);
        relationships13.setTo(entities38);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities39 = new Cardinalities();
        cardinalities39 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships13.setCardinalities(cardinalities39);
        em.persist(relationships13);
        em.flush();

        Relationships relationships14 = new Relationships();
        relationships14.setIsOptionality(true);
        relationships14.setIsEmbedded(false);
        relationships14.setName("");
//      ...................... Entities ........................
        Entities entities40 = new Entities();
        entities40 = findBean.nameEntities("Entities",em);
        relationships14.setFrom(entities40);
//      ...................... NameQueries ........................
        Entities entities41 = new Entities();
        entities41 = findBean.nameEntities("NameQueries",em);
        relationships14.setTo(entities41);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities42 = new Cardinalities();
        cardinalities42 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships14.setCardinalities(cardinalities42);
        em.persist(relationships14);
        em.flush();

        Relationships relationships15 = new Relationships();
        relationships15.setIsOptionality(true);
        relationships15.setIsEmbedded(false);
        relationships15.setName("");
//      ...................... Entities ........................
        Entities entities43 = new Entities();
        entities43 = findBean.nameEntities("Entities",em);
        relationships15.setFrom(entities43);
//      ...................... Imports ........................
        Entities entities44 = new Entities();
        entities44 = findBean.nameEntities("Imports",em);
        relationships15.setTo(entities44);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities45 = new Cardinalities();
        cardinalities45 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships15.setCardinalities(cardinalities45);
        em.persist(relationships15);
        em.flush();

        Relationships relationships16 = new Relationships();
        relationships16.setIsOptionality(true);
        relationships16.setIsEmbedded(false);
        relationships16.setName("");
//      ...................... Entities ........................
        Entities entities46 = new Entities();
        entities46 = findBean.nameEntities("Entities",em);
        relationships16.setFrom(entities46);
//      ...................... AttributesProperties ........................
        Entities entities47 = new Entities();
        entities47 = findBean.nameEntities("AttributesProperties",em);
        relationships16.setTo(entities47);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities48 = new Cardinalities();
        cardinalities48 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships16.setCardinalities(cardinalities48);
        em.persist(relationships16);
        em.flush();

        Relationships relationships17 = new Relationships();
        relationships17.setIsOptionality(true);
        relationships17.setIsEmbedded(false);
        relationships17.setName("");
//      ...................... Entities ........................
        Entities entities49 = new Entities();
        entities49 = findBean.nameEntities("Entities",em);
        relationships17.setFrom(entities49);
//      ...................... Sites ........................
        Entities entities50 = new Entities();
        entities50 = findBean.nameEntities("Sites",em);
        relationships17.setTo(entities50);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities51 = new Cardinalities();
        cardinalities51 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships17.setCardinalities(cardinalities51);
        em.persist(relationships17);
        em.flush();

        Relationships relationships18 = new Relationships();
        relationships18.setIsOptionality(true);
        relationships18.setIsEmbedded(false);
        relationships18.setName("from");
//      ...................... Entities ........................
        Entities entities52 = new Entities();
        entities52 = findBean.nameEntities("Entities",em);
        relationships18.setFrom(entities52);
//      ...................... Relationships ........................
        Entities entities53 = new Entities();
        entities53 = findBean.nameEntities("Relationships",em);
        relationships18.setTo(entities53);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities54 = new Cardinalities();
        cardinalities54 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships18.setCardinalities(cardinalities54);
        em.persist(relationships18);
        em.flush();

        Relationships relationships19 = new Relationships();
        relationships19.setIsOptionality(true);
        relationships19.setIsEmbedded(false);
        relationships19.setName("to");
//      ...................... Entities ........................
        Entities entities55 = new Entities();
        entities55 = findBean.nameEntities("Entities",em);
        relationships19.setFrom(entities55);
//      ...................... Relationships ........................
        Entities entities56 = new Entities();
        entities56 = findBean.nameEntities("Relationships",em);
        relationships19.setTo(entities56);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities57 = new Cardinalities();
        cardinalities57 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships19.setCardinalities(cardinalities57);
        em.persist(relationships19);
        em.flush();

        Relationships relationships20 = new Relationships();
        relationships20.setIsOptionality(true);
        relationships20.setIsEmbedded(false);
        relationships20.setName("");
//      ...................... Imports ........................
        Entities entities58 = new Entities();
        entities58 = findBean.nameEntities("Imports",em);
        relationships20.setFrom(entities58);
//      ...................... Sites ........................
        Entities entities59 = new Entities();
        entities59 = findBean.nameEntities("Sites",em);
        relationships20.setTo(entities59);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities60 = new Cardinalities();
        cardinalities60 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships20.setCardinalities(cardinalities60);
        em.persist(relationships20);
        em.flush();

        Relationships relationships21 = new Relationships();
        relationships21.setIsOptionality(true);
        relationships21.setIsEmbedded(false);
        relationships21.setName("");
//      ...................... Dependencies ........................
        Entities entities61 = new Entities();
        entities61 = findBean.nameEntities("Dependencies",em);
        relationships21.setFrom(entities61);
//      ...................... Imports ........................
        Entities entities62 = new Entities();
        entities62 = findBean.nameEntities("Imports",em);
        relationships21.setTo(entities62);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities63 = new Cardinalities();
        cardinalities63 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships21.setCardinalities(cardinalities63);
        em.persist(relationships21);
        em.flush();

        Relationships relationships22 = new Relationships();
        relationships22.setIsOptionality(true);
        relationships22.setIsEmbedded(false);
        relationships22.setName("");
//      ...................... Dependencies ........................
        Entities entities64 = new Entities();
        entities64 = findBean.nameEntities("Dependencies",em);
        relationships22.setFrom(entities64);
//      ...................... Sites ........................
        Entities entities65 = new Entities();
        entities65 = findBean.nameEntities("Sites",em);
        relationships22.setTo(entities65);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities66 = new Cardinalities();
        cardinalities66 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships22.setCardinalities(cardinalities66);
        em.persist(relationships22);
        em.flush();

        Relationships relationships23 = new Relationships();
        relationships23.setIsOptionality(true);
        relationships23.setIsEmbedded(false);
        relationships23.setName("");
//      ...................... AttributesProperties ........................
        Entities entities67 = new Entities();
        entities67 = findBean.nameEntities("AttributesProperties",em);
        relationships23.setFrom(entities67);
//      ...................... Imports ........................
        Entities entities68 = new Entities();
        entities68 = findBean.nameEntities("Imports",em);
        relationships23.setTo(entities68);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities69 = new Cardinalities();
        cardinalities69 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships23.setCardinalities(cardinalities69);
        em.persist(relationships23);
        em.flush();

        Relationships relationships24 = new Relationships();
        relationships24.setIsOptionality(true);
        relationships24.setIsEmbedded(false);
        relationships24.setName("");
//      ...................... AttributesProperties ........................
        Entities entities70 = new Entities();
        entities70 = findBean.nameEntities("AttributesProperties",em);
        relationships24.setFrom(entities70);
//      ...................... Sites ........................
        Entities entities71 = new Entities();
        entities71 = findBean.nameEntities("Sites",em);
        relationships24.setTo(entities71);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities72 = new Cardinalities();
        cardinalities72 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships24.setCardinalities(cardinalities72);
        em.persist(relationships24);
        em.flush();

        Relationships relationships25 = new Relationships();
        relationships25.setIsOptionality(true);
        relationships25.setIsEmbedded(false);
        relationships25.setName("");
//      ...................... AttributesTypes ........................
        Entities entities73 = new Entities();
        entities73 = findBean.nameEntities("AttributesTypes",em);
        relationships25.setFrom(entities73);
//      ...................... Sites ........................
        Entities entities74 = new Entities();
        entities74 = findBean.nameEntities("Sites",em);
        relationships25.setTo(entities74);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities75 = new Cardinalities();
        cardinalities75 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships25.setCardinalities(cardinalities75);
        em.persist(relationships25);
        em.flush();

        Relationships relationships26 = new Relationships();
        relationships26.setIsOptionality(true);
        relationships26.setIsEmbedded(false);
        relationships26.setName("");
//      ...................... AttributesTypes ........................
        Entities entities76 = new Entities();
        entities76 = findBean.nameEntities("AttributesTypes",em);
        relationships26.setFrom(entities76);
//      ...................... AttributesProperties ........................
        Entities entities77 = new Entities();
        entities77 = findBean.nameEntities("AttributesProperties",em);
        relationships26.setTo(entities77);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities78 = new Cardinalities();
        cardinalities78 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships26.setCardinalities(cardinalities78);
        em.persist(relationships26);
        em.flush();

        Relationships relationships27 = new Relationships();
        relationships27.setIsOptionality(true);
        relationships27.setIsEmbedded(false);
        relationships27.setName("");
//      ...................... AttributesTypes ........................
        Entities entities79 = new Entities();
        entities79 = findBean.nameEntities("AttributesTypes",em);
        relationships27.setFrom(entities79);
//      ...................... Attributes ........................
        Entities entities80 = new Entities();
        entities80 = findBean.nameEntities("Attributes",em);
        relationships27.setTo(entities80);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities81 = new Cardinalities();
        cardinalities81 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships27.setCardinalities(cardinalities81);
        em.persist(relationships27);
        em.flush();

        Relationships relationships28 = new Relationships();
        relationships28.setIsOptionality(true);
        relationships28.setIsEmbedded(false);
        relationships28.setName("");
//      ...................... SitesTypes ........................
        Entities entities82 = new Entities();
        entities82 = findBean.nameEntities("SitesTypes",em);
        relationships28.setFrom(entities82);
//      ...................... SitesTypes ........................
        Entities entities83 = new Entities();
        entities83 = findBean.nameEntities("SitesTypes",em);
        relationships28.setTo(entities83);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities84 = new Cardinalities();
        cardinalities84 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships28.setCardinalities(cardinalities84);
        em.persist(relationships28);
        em.flush();

        Relationships relationships29 = new Relationships();
        relationships29.setIsOptionality(true);
        relationships29.setIsEmbedded(false);
        relationships29.setName("");
//      ...................... SitesTypes ........................
        Entities entities85 = new Entities();
        entities85 = findBean.nameEntities("SitesTypes",em);
        relationships29.setFrom(entities85);
//      ...................... Sites ........................
        Entities entities86 = new Entities();
        entities86 = findBean.nameEntities("Sites",em);
        relationships29.setTo(entities86);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities87 = new Cardinalities();
        cardinalities87 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships29.setCardinalities(cardinalities87);
        em.persist(relationships29);
        em.flush();

    } // data()

} // naifgSetup
