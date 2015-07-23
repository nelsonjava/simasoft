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
        entities2.setName("Activities");
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
//      ...................... Activities ........................
        Entities entity3 = new Entities();
        entity3 = findBean.nameEntities("Activities",em);
        attributes3.setEntities(entity3);
//      ...................... String ........................
        AttributesTypes attributesTypes4 = new AttributesTypes();
        attributesTypes4 = findBean.nameAttributesTypes("String",em);
        attributes3.setAttributesTypes(attributesTypes4);
        em.persist(attributes3);
        em.flush();

        Attributes attributes4 = new Attributes();
        attributes4.setName("detail");
        attributes4.setNullable(true);
        attributes4.setSingle(false);
//      ...................... Activities ........................
        Entities entity5 = new Entities();
        entity5 = findBean.nameEntities("Activities",em);
        attributes4.setEntities(entity5);
//      ...................... String ........................
        AttributesTypes attributesTypes6 = new AttributesTypes();
        attributesTypes6 = findBean.nameAttributesTypes("String",em);
        attributes4.setAttributesTypes(attributesTypes6);
        em.persist(attributes4);
        em.flush();

        Entities entities5 = new Entities();
        entities5.setName("Secciones");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId7 = new GroupIds();
        groupId7 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities5.setGroupIds(groupId7);
        em.persist(entities5);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes6 = new Attributes();
        attributes6.setName("nombre");
        attributes6.setNullable(true);
        attributes6.setSingle(false);
//      ...................... Secciones ........................
        Entities entity8 = new Entities();
        entity8 = findBean.nameEntities("Secciones",em);
        attributes6.setEntities(entity8);
//      ...................... String ........................
        AttributesTypes attributesTypes9 = new AttributesTypes();
        attributesTypes9 = findBean.nameAttributesTypes("String",em);
        attributes6.setAttributesTypes(attributesTypes9);
        em.persist(attributes6);
        em.flush();

        Attributes attributes7 = new Attributes();
        attributes7.setName("codigo");
        attributes7.setNullable(true);
        attributes7.setSingle(false);
//      ...................... Secciones ........................
        Entities entity10 = new Entities();
        entity10 = findBean.nameEntities("Secciones",em);
        attributes7.setEntities(entity10);
//      ...................... String ........................
        AttributesTypes attributesTypes11 = new AttributesTypes();
        attributesTypes11 = findBean.nameAttributesTypes("String",em);
        attributes7.setAttributesTypes(attributesTypes11);
        em.persist(attributes7);
        em.flush();

        Attributes attributes8 = new Attributes();
        attributes8.setName("email");
        attributes8.setNullable(true);
        attributes8.setSingle(false);
//      ...................... Secciones ........................
        Entities entity12 = new Entities();
        entity12 = findBean.nameEntities("Secciones",em);
        attributes8.setEntities(entity12);
//      ...................... String ........................
        AttributesTypes attributesTypes13 = new AttributesTypes();
        attributesTypes13 = findBean.nameAttributesTypes("String",em);
        attributes8.setAttributesTypes(attributesTypes13);
        em.persist(attributes8);
        em.flush();

        Entities entities9 = new Entities();
        entities9.setName("TiposItems");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId14 = new GroupIds();
        groupId14 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities9.setGroupIds(groupId14);
        em.persist(entities9);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes10 = new Attributes();
        attributes10.setName("nombre");
        attributes10.setNullable(true);
        attributes10.setSingle(false);
//      ...................... TiposItems ........................
        Entities entity15 = new Entities();
        entity15 = findBean.nameEntities("TiposItems",em);
        attributes10.setEntities(entity15);
//      ...................... String ........................
        AttributesTypes attributesTypes16 = new AttributesTypes();
        attributesTypes16 = findBean.nameAttributesTypes("String",em);
        attributes10.setAttributesTypes(attributesTypes16);
        em.persist(attributes10);
        em.flush();

        Entities entities11 = new Entities();
        entities11.setName("Tasks");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId17 = new GroupIds();
        groupId17 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities11.setGroupIds(groupId17);
        em.persist(entities11);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes12 = new Attributes();
        attributes12.setName("name");
        attributes12.setNullable(true);
        attributes12.setSingle(false);
//      ...................... Tasks ........................
        Entities entity18 = new Entities();
        entity18 = findBean.nameEntities("Tasks",em);
        attributes12.setEntities(entity18);
//      ...................... String ........................
        AttributesTypes attributesTypes19 = new AttributesTypes();
        attributesTypes19 = findBean.nameAttributesTypes("String",em);
        attributes12.setAttributesTypes(attributesTypes19);
        em.persist(attributes12);
        em.flush();

        Attributes attributes13 = new Attributes();
        attributes13.setName("date");
        attributes13.setNullable(true);
        attributes13.setSingle(false);
//      ...................... Tasks ........................
        Entities entity20 = new Entities();
        entity20 = findBean.nameEntities("Tasks",em);
        attributes13.setEntities(entity20);
//      ...................... Date ........................
        AttributesTypes attributesTypes21 = new AttributesTypes();
        attributesTypes21 = findBean.nameAttributesTypes("Date",em);
        attributes13.setAttributesTypes(attributesTypes21);
        em.persist(attributes13);
        em.flush();

        Attributes attributes14 = new Attributes();
        attributes14.setName("priority");
        attributes14.setNullable(true);
        attributes14.setSingle(false);
//      ...................... Tasks ........................
        Entities entity22 = new Entities();
        entity22 = findBean.nameEntities("Tasks",em);
        attributes14.setEntities(entity22);
//      ...................... Integer ........................
        AttributesTypes attributesTypes23 = new AttributesTypes();
        attributesTypes23 = findBean.nameAttributesTypes("Integer",em);
        attributes14.setAttributesTypes(attributesTypes23);
        em.persist(attributes14);
        em.flush();

        Attributes attributes15 = new Attributes();
        attributes15.setName("detail");
        attributes15.setNullable(true);
        attributes15.setSingle(false);
//      ...................... Tasks ........................
        Entities entity24 = new Entities();
        entity24 = findBean.nameEntities("Tasks",em);
        attributes15.setEntities(entity24);
//      ...................... String ........................
        AttributesTypes attributesTypes25 = new AttributesTypes();
        attributesTypes25 = findBean.nameAttributesTypes("String",em);
        attributes15.setAttributesTypes(attributesTypes25);
        em.persist(attributes15);
        em.flush();

        Attributes attributes16 = new Attributes();
        attributes16.setName("isOpend");
        attributes16.setNullable(true);
        attributes16.setSingle(false);
//      ...................... Tasks ........................
        Entities entity26 = new Entities();
        entity26 = findBean.nameEntities("Tasks",em);
        attributes16.setEntities(entity26);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes27 = new AttributesTypes();
        attributesTypes27 = findBean.nameAttributesTypes("Boolean",em);
        attributes16.setAttributesTypes(attributesTypes27);
        em.persist(attributes16);
        em.flush();

        Entities entities17 = new Entities();
        entities17.setName("NamesItems");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId28 = new GroupIds();
        groupId28 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities17.setGroupIds(groupId28);
        em.persist(entities17);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes18 = new Attributes();
        attributes18.setName("nombre");
        attributes18.setNullable(true);
        attributes18.setSingle(false);
//      ...................... NamesItems ........................
        Entities entity29 = new Entities();
        entity29 = findBean.nameEntities("NamesItems",em);
        attributes18.setEntities(entity29);
//      ...................... String ........................
        AttributesTypes attributesTypes30 = new AttributesTypes();
        attributesTypes30 = findBean.nameAttributesTypes("String",em);
        attributes18.setAttributesTypes(attributesTypes30);
        em.persist(attributes18);
        em.flush();

        Attributes attributes19 = new Attributes();
        attributes19.setName("modelo");
        attributes19.setNullable(true);
        attributes19.setSingle(false);
//      ...................... NamesItems ........................
        Entities entity31 = new Entities();
        entity31 = findBean.nameEntities("NamesItems",em);
        attributes19.setEntities(entity31);
//      ...................... String ........................
        AttributesTypes attributesTypes32 = new AttributesTypes();
        attributesTypes32 = findBean.nameAttributesTypes("String",em);
        attributes19.setAttributesTypes(attributesTypes32);
        em.persist(attributes19);
        em.flush();

        Attributes attributes20 = new Attributes();
        attributes20.setName("nroProducto");
        attributes20.setNullable(true);
        attributes20.setSingle(false);
//      ...................... NamesItems ........................
        Entities entity33 = new Entities();
        entity33 = findBean.nameEntities("NamesItems",em);
        attributes20.setEntities(entity33);
//      ...................... String ........................
        AttributesTypes attributesTypes34 = new AttributesTypes();
        attributesTypes34 = findBean.nameAttributesTypes("String",em);
        attributes20.setAttributesTypes(attributesTypes34);
        em.persist(attributes20);
        em.flush();

        Attributes attributes21 = new Attributes();
        attributes21.setName("nroParte");
        attributes21.setNullable(true);
        attributes21.setSingle(false);
//      ...................... NamesItems ........................
        Entities entity35 = new Entities();
        entity35 = findBean.nameEntities("NamesItems",em);
        attributes21.setEntities(entity35);
//      ...................... String ........................
        AttributesTypes attributesTypes36 = new AttributesTypes();
        attributesTypes36 = findBean.nameAttributesTypes("String",em);
        attributes21.setAttributesTypes(attributesTypes36);
        em.persist(attributes21);
        em.flush();

        Attributes attributes22 = new Attributes();
        attributes22.setName("link");
        attributes22.setNullable(true);
        attributes22.setSingle(false);
//      ...................... NamesItems ........................
        Entities entity37 = new Entities();
        entity37 = findBean.nameEntities("NamesItems",em);
        attributes22.setEntities(entity37);
//      ...................... String ........................
        AttributesTypes attributesTypes38 = new AttributesTypes();
        attributesTypes38 = findBean.nameAttributesTypes("String",em);
        attributes22.setAttributesTypes(attributesTypes38);
        em.persist(attributes22);
        em.flush();

        Entities entities23 = new Entities();
        entities23.setName("TipoPersonal");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId39 = new GroupIds();
        groupId39 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities23.setGroupIds(groupId39);
        em.persist(entities23);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes24 = new Attributes();
        attributes24.setName("nombre");
        attributes24.setNullable(true);
        attributes24.setSingle(false);
//      ...................... TipoPersonal ........................
        Entities entity40 = new Entities();
        entity40 = findBean.nameEntities("TipoPersonal",em);
        attributes24.setEntities(entity40);
//      ...................... String ........................
        AttributesTypes attributesTypes41 = new AttributesTypes();
        attributesTypes41 = findBean.nameAttributesTypes("String",em);
        attributes24.setAttributesTypes(attributesTypes41);
        em.persist(attributes24);
        em.flush();

        Entities entities25 = new Entities();
        entities25.setName("Macs");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId42 = new GroupIds();
        groupId42 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities25.setGroupIds(groupId42);
        em.persist(entities25);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes26 = new Attributes();
        attributes26.setName("ip");
        attributes26.setNullable(true);
        attributes26.setSingle(false);
//      ...................... Macs ........................
        Entities entity43 = new Entities();
        entity43 = findBean.nameEntities("Macs",em);
        attributes26.setEntities(entity43);
//      ...................... String ........................
        AttributesTypes attributesTypes44 = new AttributesTypes();
        attributesTypes44 = findBean.nameAttributesTypes("String",em);
        attributes26.setAttributesTypes(attributesTypes44);
        em.persist(attributes26);
        em.flush();

        Attributes attributes27 = new Attributes();
        attributes27.setName("mac");
        attributes27.setNullable(true);
        attributes27.setSingle(false);
//      ...................... Macs ........................
        Entities entity45 = new Entities();
        entity45 = findBean.nameEntities("Macs",em);
        attributes27.setEntities(entity45);
//      ...................... String ........................
        AttributesTypes attributesTypes46 = new AttributesTypes();
        attributesTypes46 = findBean.nameAttributesTypes("String",em);
        attributes27.setAttributesTypes(attributesTypes46);
        em.persist(attributes27);
        em.flush();

        Entities entities28 = new Entities();
        entities28.setName("TiposInventarios");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId47 = new GroupIds();
        groupId47 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities28.setGroupIds(groupId47);
        em.persist(entities28);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes29 = new Attributes();
        attributes29.setName("nombre");
        attributes29.setNullable(true);
        attributes29.setSingle(false);
//      ...................... TiposInventarios ........................
        Entities entity48 = new Entities();
        entity48 = findBean.nameEntities("TiposInventarios",em);
        attributes29.setEntities(entity48);
//      ...................... String ........................
        AttributesTypes attributesTypes49 = new AttributesTypes();
        attributesTypes49 = findBean.nameAttributesTypes("String",em);
        attributes29.setAttributesTypes(attributesTypes49);
        em.persist(attributes29);
        em.flush();

        Entities entities30 = new Entities();
        entities30.setName("ActivitiesTypes");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId50 = new GroupIds();
        groupId50 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities30.setGroupIds(groupId50);
        em.persist(entities30);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes31 = new Attributes();
        attributes31.setName("name");
        attributes31.setNullable(true);
        attributes31.setSingle(false);
//      ...................... ActivitiesTypes ........................
        Entities entity51 = new Entities();
        entity51 = findBean.nameEntities("ActivitiesTypes",em);
        attributes31.setEntities(entity51);
//      ...................... String ........................
        AttributesTypes attributesTypes52 = new AttributesTypes();
        attributesTypes52 = findBean.nameAttributesTypes("String",em);
        attributes31.setAttributesTypes(attributesTypes52);
        em.persist(attributes31);
        em.flush();

        Entities entities32 = new Entities();
        entities32.setName("Facturas");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId53 = new GroupIds();
        groupId53 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities32.setGroupIds(groupId53);
        em.persist(entities32);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes33 = new Attributes();
        attributes33.setName("numero");
        attributes33.setNullable(true);
        attributes33.setSingle(false);
//      ...................... Facturas ........................
        Entities entity54 = new Entities();
        entity54 = findBean.nameEntities("Facturas",em);
        attributes33.setEntities(entity54);
//      ...................... String ........................
        AttributesTypes attributesTypes55 = new AttributesTypes();
        attributesTypes55 = findBean.nameAttributesTypes("String",em);
        attributes33.setAttributesTypes(attributesTypes55);
        em.persist(attributes33);
        em.flush();

        Entities entities34 = new Entities();
        entities34.setName("EstadosItems");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId56 = new GroupIds();
        groupId56 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities34.setGroupIds(groupId56);
        em.persist(entities34);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes35 = new Attributes();
        attributes35.setName("nombre");
        attributes35.setNullable(true);
        attributes35.setSingle(false);
//      ...................... EstadosItems ........................
        Entities entity57 = new Entities();
        entity57 = findBean.nameEntities("EstadosItems",em);
        attributes35.setEntities(entity57);
//      ...................... String ........................
        AttributesTypes attributesTypes58 = new AttributesTypes();
        attributesTypes58 = findBean.nameAttributesTypes("String",em);
        attributes35.setAttributesTypes(attributesTypes58);
        em.persist(attributes35);
        em.flush();

        Entities entities36 = new Entities();
        entities36.setName("Personas");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId59 = new GroupIds();
        groupId59 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities36.setGroupIds(groupId59);
        em.persist(entities36);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes37 = new Attributes();
        attributes37.setName("primerApellido");
        attributes37.setNullable(true);
        attributes37.setSingle(false);
//      ...................... Personas ........................
        Entities entity60 = new Entities();
        entity60 = findBean.nameEntities("Personas",em);
        attributes37.setEntities(entity60);
//      ...................... String ........................
        AttributesTypes attributesTypes61 = new AttributesTypes();
        attributesTypes61 = findBean.nameAttributesTypes("String",em);
        attributes37.setAttributesTypes(attributesTypes61);
        em.persist(attributes37);
        em.flush();

        Attributes attributes38 = new Attributes();
        attributes38.setName("segundoApellido");
        attributes38.setNullable(true);
        attributes38.setSingle(false);
//      ...................... Personas ........................
        Entities entity62 = new Entities();
        entity62 = findBean.nameEntities("Personas",em);
        attributes38.setEntities(entity62);
//      ...................... String ........................
        AttributesTypes attributesTypes63 = new AttributesTypes();
        attributesTypes63 = findBean.nameAttributesTypes("String",em);
        attributes38.setAttributesTypes(attributesTypes63);
        em.persist(attributes38);
        em.flush();

        Attributes attributes39 = new Attributes();
        attributes39.setName("primerNombre");
        attributes39.setNullable(true);
        attributes39.setSingle(false);
//      ...................... Personas ........................
        Entities entity64 = new Entities();
        entity64 = findBean.nameEntities("Personas",em);
        attributes39.setEntities(entity64);
//      ...................... String ........................
        AttributesTypes attributesTypes65 = new AttributesTypes();
        attributesTypes65 = findBean.nameAttributesTypes("String",em);
        attributes39.setAttributesTypes(attributesTypes65);
        em.persist(attributes39);
        em.flush();

        Attributes attributes40 = new Attributes();
        attributes40.setName("segundoNombre");
        attributes40.setNullable(true);
        attributes40.setSingle(false);
//      ...................... Personas ........................
        Entities entity66 = new Entities();
        entity66 = findBean.nameEntities("Personas",em);
        attributes40.setEntities(entity66);
//      ...................... String ........................
        AttributesTypes attributesTypes67 = new AttributesTypes();
        attributesTypes67 = findBean.nameAttributesTypes("String",em);
        attributes40.setAttributesTypes(attributesTypes67);
        em.persist(attributes40);
        em.flush();

        Attributes attributes41 = new Attributes();
        attributes41.setName("direccion");
        attributes41.setNullable(true);
        attributes41.setSingle(false);
//      ...................... Personas ........................
        Entities entity68 = new Entities();
        entity68 = findBean.nameEntities("Personas",em);
        attributes41.setEntities(entity68);
//      ...................... String ........................
        AttributesTypes attributesTypes69 = new AttributesTypes();
        attributesTypes69 = findBean.nameAttributesTypes("String",em);
        attributes41.setAttributesTypes(attributesTypes69);
        em.persist(attributes41);
        em.flush();

        Attributes attributes42 = new Attributes();
        attributes42.setName("telefonos");
        attributes42.setNullable(true);
        attributes42.setSingle(false);
//      ...................... Personas ........................
        Entities entity70 = new Entities();
        entity70 = findBean.nameEntities("Personas",em);
        attributes42.setEntities(entity70);
//      ...................... String ........................
        AttributesTypes attributesTypes71 = new AttributesTypes();
        attributesTypes71 = findBean.nameAttributesTypes("String",em);
        attributes42.setAttributesTypes(attributesTypes71);
        em.persist(attributes42);
        em.flush();

        Attributes attributes43 = new Attributes();
        attributes43.setName("email");
        attributes43.setNullable(true);
        attributes43.setSingle(false);
//      ...................... Personas ........................
        Entities entity72 = new Entities();
        entity72 = findBean.nameEntities("Personas",em);
        attributes43.setEntities(entity72);
//      ...................... String ........................
        AttributesTypes attributesTypes73 = new AttributesTypes();
        attributesTypes73 = findBean.nameAttributesTypes("String",em);
        attributes43.setAttributesTypes(attributesTypes73);
        em.persist(attributes43);
        em.flush();

        Entities entities44 = new Entities();
        entities44.setName("Inventarios");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId74 = new GroupIds();
        groupId74 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities44.setGroupIds(groupId74);
        em.persist(entities44);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes45 = new Attributes();
        attributes45.setName("nombre");
        attributes45.setNullable(true);
        attributes45.setSingle(false);
//      ...................... Inventarios ........................
        Entities entity75 = new Entities();
        entity75 = findBean.nameEntities("Inventarios",em);
        attributes45.setEntities(entity75);
//      ...................... String ........................
        AttributesTypes attributesTypes76 = new AttributesTypes();
        attributesTypes76 = findBean.nameAttributesTypes("String",em);
        attributes45.setAttributesTypes(attributesTypes76);
        em.persist(attributes45);
        em.flush();

        Entities entities46 = new Entities();
        entities46.setName("Empresas");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId77 = new GroupIds();
        groupId77 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities46.setGroupIds(groupId77);
        em.persist(entities46);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes47 = new Attributes();
        attributes47.setName("nombre");
        attributes47.setNullable(true);
        attributes47.setSingle(false);
//      ...................... Empresas ........................
        Entities entity78 = new Entities();
        entity78 = findBean.nameEntities("Empresas",em);
        attributes47.setEntities(entity78);
//      ...................... String ........................
        AttributesTypes attributesTypes79 = new AttributesTypes();
        attributesTypes79 = findBean.nameAttributesTypes("String",em);
        attributes47.setAttributesTypes(attributesTypes79);
        em.persist(attributes47);
        em.flush();

        Attributes attributes48 = new Attributes();
        attributes48.setName("nit");
        attributes48.setNullable(true);
        attributes48.setSingle(false);
//      ...................... Empresas ........................
        Entities entity80 = new Entities();
        entity80 = findBean.nameEntities("Empresas",em);
        attributes48.setEntities(entity80);
//      ...................... String ........................
        AttributesTypes attributesTypes81 = new AttributesTypes();
        attributesTypes81 = findBean.nameAttributesTypes("String",em);
        attributes48.setAttributesTypes(attributesTypes81);
        em.persist(attributes48);
        em.flush();

        Attributes attributes49 = new Attributes();
        attributes49.setName("link");
        attributes49.setNullable(true);
        attributes49.setSingle(false);
//      ...................... Empresas ........................
        Entities entity82 = new Entities();
        entity82 = findBean.nameEntities("Empresas",em);
        attributes49.setEntities(entity82);
//      ...................... String ........................
        AttributesTypes attributesTypes83 = new AttributesTypes();
        attributesTypes83 = findBean.nameAttributesTypes("String",em);
        attributes49.setAttributesTypes(attributesTypes83);
        em.persist(attributes49);
        em.flush();

        Attributes attributes50 = new Attributes();
        attributes50.setName("direccion");
        attributes50.setNullable(true);
        attributes50.setSingle(false);
//      ...................... Empresas ........................
        Entities entity84 = new Entities();
        entity84 = findBean.nameEntities("Empresas",em);
        attributes50.setEntities(entity84);
//      ...................... String ........................
        AttributesTypes attributesTypes85 = new AttributesTypes();
        attributesTypes85 = findBean.nameAttributesTypes("String",em);
        attributes50.setAttributesTypes(attributesTypes85);
        em.persist(attributes50);
        em.flush();

        Attributes attributes51 = new Attributes();
        attributes51.setName("telefonos");
        attributes51.setNullable(true);
        attributes51.setSingle(false);
//      ...................... Empresas ........................
        Entities entity86 = new Entities();
        entity86 = findBean.nameEntities("Empresas",em);
        attributes51.setEntities(entity86);
//      ...................... String ........................
        AttributesTypes attributesTypes87 = new AttributesTypes();
        attributesTypes87 = findBean.nameAttributesTypes("String",em);
        attributes51.setAttributesTypes(attributesTypes87);
        em.persist(attributes51);
        em.flush();

        Attributes attributes52 = new Attributes();
        attributes52.setName("email");
        attributes52.setNullable(true);
        attributes52.setSingle(false);
//      ...................... Empresas ........................
        Entities entity88 = new Entities();
        entity88 = findBean.nameEntities("Empresas",em);
        attributes52.setEntities(entity88);
//      ...................... String ........................
        AttributesTypes attributesTypes89 = new AttributesTypes();
        attributesTypes89 = findBean.nameAttributesTypes("String",em);
        attributes52.setAttributesTypes(attributesTypes89);
        em.persist(attributes52);
        em.flush();

        Entities entities53 = new Entities();
        entities53.setName("Switchs");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId90 = new GroupIds();
        groupId90 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities53.setGroupIds(groupId90);
        em.persist(entities53);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes54 = new Attributes();
        attributes54.setName("nombre");
        attributes54.setNullable(true);
        attributes54.setSingle(false);
//      ...................... Switchs ........................
        Entities entity91 = new Entities();
        entity91 = findBean.nameEntities("Switchs",em);
        attributes54.setEntities(entity91);
//      ...................... String ........................
        AttributesTypes attributesTypes92 = new AttributesTypes();
        attributesTypes92 = findBean.nameAttributesTypes("String",em);
        attributes54.setAttributesTypes(attributesTypes92);
        em.persist(attributes54);
        em.flush();

        Entities entities55 = new Entities();
        entities55.setName("ItemsFacturas");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId93 = new GroupIds();
        groupId93 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities55.setGroupIds(groupId93);
        em.persist(entities55);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes56 = new Attributes();
        attributes56.setName("cantidad");
        attributes56.setNullable(true);
        attributes56.setSingle(false);
//      ...................... ItemsFacturas ........................
        Entities entity94 = new Entities();
        entity94 = findBean.nameEntities("ItemsFacturas",em);
        attributes56.setEntities(entity94);
//      ...................... Integer ........................
        AttributesTypes attributesTypes95 = new AttributesTypes();
        attributesTypes95 = findBean.nameAttributesTypes("Integer",em);
        attributes56.setAttributesTypes(attributesTypes95);
        em.persist(attributes56);
        em.flush();

        Attributes attributes57 = new Attributes();
        attributes57.setName("valorUnitario");
        attributes57.setNullable(true);
        attributes57.setSingle(false);
//      ...................... ItemsFacturas ........................
        Entities entity96 = new Entities();
        entity96 = findBean.nameEntities("ItemsFacturas",em);
        attributes57.setEntities(entity96);
//      ...................... double ........................
        AttributesTypes attributesTypes97 = new AttributesTypes();
        attributesTypes97 = findBean.nameAttributesTypes("double",em);
        attributes57.setAttributesTypes(attributesTypes97);
        em.persist(attributes57);
        em.flush();

        Entities entities58 = new Entities();
        entities58.setName("TiposAreasFisicas");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId98 = new GroupIds();
        groupId98 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities58.setGroupIds(groupId98);
        em.persist(entities58);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes59 = new Attributes();
        attributes59.setName("nombre");
        attributes59.setNullable(true);
        attributes59.setSingle(false);
//      ...................... TiposAreasFisicas ........................
        Entities entity99 = new Entities();
        entity99 = findBean.nameEntities("TiposAreasFisicas",em);
        attributes59.setEntities(entity99);
//      ...................... String ........................
        AttributesTypes attributesTypes100 = new AttributesTypes();
        attributesTypes100 = findBean.nameAttributesTypes("String",em);
        attributes59.setAttributesTypes(attributesTypes100);
        em.persist(attributes59);
        em.flush();

        Entities entities60 = new Entities();
        entities60.setName("IpAddress");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId101 = new GroupIds();
        groupId101 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities60.setGroupIds(groupId101);
        em.persist(entities60);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes61 = new Attributes();
        attributes61.setName("ip");
        attributes61.setNullable(true);
        attributes61.setSingle(false);
//      ...................... IpAddress ........................
        Entities entity102 = new Entities();
        entity102 = findBean.nameEntities("IpAddress",em);
        attributes61.setEntities(entity102);
//      ...................... String ........................
        AttributesTypes attributesTypes103 = new AttributesTypes();
        attributesTypes103 = findBean.nameAttributesTypes("String",em);
        attributes61.setAttributesTypes(attributesTypes103);
        em.persist(attributes61);
        em.flush();

        Attributes attributes62 = new Attributes();
        attributes62.setName("link");
        attributes62.setNullable(true);
        attributes62.setSingle(false);
//      ...................... IpAddress ........................
        Entities entity104 = new Entities();
        entity104 = findBean.nameEntities("IpAddress",em);
        attributes62.setEntities(entity104);
//      ...................... String ........................
        AttributesTypes attributesTypes105 = new AttributesTypes();
        attributesTypes105 = findBean.nameAttributesTypes("String",em);
        attributes62.setAttributesTypes(attributesTypes105);
        em.persist(attributes62);
        em.flush();

        Attributes attributes63 = new Attributes();
        attributes63.setName("isSecurity");
        attributes63.setNullable(true);
        attributes63.setSingle(false);
//      ...................... IpAddress ........................
        Entities entity106 = new Entities();
        entity106 = findBean.nameEntities("IpAddress",em);
        attributes63.setEntities(entity106);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes107 = new AttributesTypes();
        attributesTypes107 = findBean.nameAttributesTypes("Boolean",em);
        attributes63.setAttributesTypes(attributesTypes107);
        em.persist(attributes63);
        em.flush();

        Entities entities64 = new Entities();
        entities64.setName("Vlan");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId108 = new GroupIds();
        groupId108 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities64.setGroupIds(groupId108);
        em.persist(entities64);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes65 = new Attributes();
        attributes65.setName("nombre");
        attributes65.setNullable(true);
        attributes65.setSingle(false);
//      ...................... Vlan ........................
        Entities entity109 = new Entities();
        entity109 = findBean.nameEntities("Vlan",em);
        attributes65.setEntities(entity109);
//      ...................... String ........................
        AttributesTypes attributesTypes110 = new AttributesTypes();
        attributesTypes110 = findBean.nameAttributesTypes("String",em);
        attributes65.setAttributesTypes(attributesTypes110);
        em.persist(attributes65);
        em.flush();

        Attributes attributes66 = new Attributes();
        attributes66.setName("ip");
        attributes66.setNullable(true);
        attributes66.setSingle(false);
//      ...................... Vlan ........................
        Entities entity111 = new Entities();
        entity111 = findBean.nameEntities("Vlan",em);
        attributes66.setEntities(entity111);
//      ...................... String ........................
        AttributesTypes attributesTypes112 = new AttributesTypes();
        attributesTypes112 = findBean.nameAttributesTypes("String",em);
        attributes66.setAttributesTypes(attributesTypes112);
        em.persist(attributes66);
        em.flush();

        Entities entities67 = new Entities();
        entities67.setName("Marcas");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId113 = new GroupIds();
        groupId113 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities67.setGroupIds(groupId113);
        em.persist(entities67);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes68 = new Attributes();
        attributes68.setName("nombre");
        attributes68.setNullable(true);
        attributes68.setSingle(false);
//      ...................... Marcas ........................
        Entities entity114 = new Entities();
        entity114 = findBean.nameEntities("Marcas",em);
        attributes68.setEntities(entity114);
//      ...................... String ........................
        AttributesTypes attributesTypes115 = new AttributesTypes();
        attributesTypes115 = findBean.nameAttributesTypes("String",em);
        attributes68.setAttributesTypes(attributesTypes115);
        em.persist(attributes68);
        em.flush();

        Entities entities69 = new Entities();
        entities69.setName("SitesTypes");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId116 = new GroupIds();
        groupId116 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities69.setGroupIds(groupId116);
        em.persist(entities69);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes70 = new Attributes();
        attributes70.setName("name");
        attributes70.setNullable(true);
        attributes70.setSingle(false);
//      ...................... SitesTypes ........................
        Entities entity117 = new Entities();
        entity117 = findBean.nameEntities("SitesTypes",em);
        attributes70.setEntities(entity117);
//      ...................... String ........................
        AttributesTypes attributesTypes118 = new AttributesTypes();
        attributesTypes118 = findBean.nameAttributesTypes("String",em);
        attributes70.setAttributesTypes(attributesTypes118);
        em.persist(attributes70);
        em.flush();

        Entities entities71 = new Entities();
        entities71.setName("TasksTypes");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId119 = new GroupIds();
        groupId119 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities71.setGroupIds(groupId119);
        em.persist(entities71);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes72 = new Attributes();
        attributes72.setName("name");
        attributes72.setNullable(true);
        attributes72.setSingle(false);
//      ...................... TasksTypes ........................
        Entities entity120 = new Entities();
        entity120 = findBean.nameEntities("TasksTypes",em);
        attributes72.setEntities(entity120);
//      ...................... String ........................
        AttributesTypes attributesTypes121 = new AttributesTypes();
        attributesTypes121 = findBean.nameAttributesTypes("String",em);
        attributes72.setAttributesTypes(attributesTypes121);
        em.persist(attributes72);
        em.flush();

        Entities entities73 = new Entities();
        entities73.setName("TiposSecciones");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId122 = new GroupIds();
        groupId122 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities73.setGroupIds(groupId122);
        em.persist(entities73);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes74 = new Attributes();
        attributes74.setName("nombre");
        attributes74.setNullable(true);
        attributes74.setSingle(false);
//      ...................... TiposSecciones ........................
        Entities entity123 = new Entities();
        entity123 = findBean.nameEntities("TiposSecciones",em);
        attributes74.setEntities(entity123);
//      ...................... String ........................
        AttributesTypes attributesTypes124 = new AttributesTypes();
        attributesTypes124 = findBean.nameAttributesTypes("String",em);
        attributes74.setAttributesTypes(attributesTypes124);
        em.persist(attributes74);
        em.flush();

        Entities entities75 = new Entities();
        entities75.setName("AreasFisicas");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId125 = new GroupIds();
        groupId125 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities75.setGroupIds(groupId125);
        em.persist(entities75);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes76 = new Attributes();
        attributes76.setName("nombre");
        attributes76.setNullable(true);
        attributes76.setSingle(false);
//      ...................... AreasFisicas ........................
        Entities entity126 = new Entities();
        entity126 = findBean.nameEntities("AreasFisicas",em);
        attributes76.setEntities(entity126);
//      ...................... String ........................
        AttributesTypes attributesTypes127 = new AttributesTypes();
        attributesTypes127 = findBean.nameAttributesTypes("String",em);
        attributes76.setAttributesTypes(attributesTypes127);
        em.persist(attributes76);
        em.flush();

        Entities entities77 = new Entities();
        entities77.setName("Calendars");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId128 = new GroupIds();
        groupId128 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities77.setGroupIds(groupId128);
        em.persist(entities77);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes78 = new Attributes();
        attributes78.setName("name");
        attributes78.setNullable(true);
        attributes78.setSingle(false);
//      ...................... Calendars ........................
        Entities entity129 = new Entities();
        entity129 = findBean.nameEntities("Calendars",em);
        attributes78.setEntities(entity129);
//      ...................... String ........................
        AttributesTypes attributesTypes130 = new AttributesTypes();
        attributesTypes130 = findBean.nameAttributesTypes("String",em);
        attributes78.setAttributesTypes(attributesTypes130);
        em.persist(attributes78);
        em.flush();

        Attributes attributes79 = new Attributes();
        attributes79.setName("date");
        attributes79.setNullable(true);
        attributes79.setSingle(false);
//      ...................... Calendars ........................
        Entities entity131 = new Entities();
        entity131 = findBean.nameEntities("Calendars",em);
        attributes79.setEntities(entity131);
//      ...................... Date ........................
        AttributesTypes attributesTypes132 = new AttributesTypes();
        attributesTypes132 = findBean.nameAttributesTypes("Date",em);
        attributes79.setAttributesTypes(attributesTypes132);
        em.persist(attributes79);
        em.flush();

        Entities entities80 = new Entities();
        entities80.setName("SwitchPorts");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId133 = new GroupIds();
        groupId133 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities80.setGroupIds(groupId133);
        em.persist(entities80);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes81 = new Attributes();
        attributes81.setName("port");
        attributes81.setNullable(true);
        attributes81.setSingle(false);
//      ...................... SwitchPorts ........................
        Entities entity134 = new Entities();
        entity134 = findBean.nameEntities("SwitchPorts",em);
        attributes81.setEntities(entity134);
//      ...................... String ........................
        AttributesTypes attributesTypes135 = new AttributesTypes();
        attributesTypes135 = findBean.nameAttributesTypes("String",em);
        attributes81.setAttributesTypes(attributesTypes135);
        em.persist(attributes81);
        em.flush();

        Attributes attributes82 = new Attributes();
        attributes82.setName("code");
        attributes82.setNullable(true);
        attributes82.setSingle(false);
//      ...................... SwitchPorts ........................
        Entities entity136 = new Entities();
        entity136 = findBean.nameEntities("SwitchPorts",em);
        attributes82.setEntities(entity136);
//      ...................... String ........................
        AttributesTypes attributesTypes137 = new AttributesTypes();
        attributesTypes137 = findBean.nameAttributesTypes("String",em);
        attributes82.setAttributesTypes(attributesTypes137);
        em.persist(attributes82);
        em.flush();

        Attributes attributes83 = new Attributes();
        attributes83.setName("state");
        attributes83.setNullable(true);
        attributes83.setSingle(false);
//      ...................... SwitchPorts ........................
        Entities entity138 = new Entities();
        entity138 = findBean.nameEntities("SwitchPorts",em);
        attributes83.setEntities(entity138);
//      ...................... String ........................
        AttributesTypes attributesTypes139 = new AttributesTypes();
        attributesTypes139 = findBean.nameAttributesTypes("String",em);
        attributes83.setAttributesTypes(attributesTypes139);
        em.persist(attributes83);
        em.flush();

        Entities entities84 = new Entities();
        entities84.setName("Items");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId140 = new GroupIds();
        groupId140 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities84.setGroupIds(groupId140);
        em.persist(entities84);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes85 = new Attributes();
        attributes85.setName("hojaVida");
        attributes85.setNullable(true);
        attributes85.setSingle(false);
//      ...................... Items ........................
        Entities entity141 = new Entities();
        entity141 = findBean.nameEntities("Items",em);
        attributes85.setEntities(entity141);
//      ...................... String ........................
        AttributesTypes attributesTypes142 = new AttributesTypes();
        attributesTypes142 = findBean.nameAttributesTypes("String",em);
        attributes85.setAttributesTypes(attributesTypes142);
        em.persist(attributes85);
        em.flush();

        Attributes attributes86 = new Attributes();
        attributes86.setName("codigo");
        attributes86.setNullable(true);
        attributes86.setSingle(false);
//      ...................... Items ........................
        Entities entity143 = new Entities();
        entity143 = findBean.nameEntities("Items",em);
        attributes86.setEntities(entity143);
//      ...................... String ........................
        AttributesTypes attributesTypes144 = new AttributesTypes();
        attributesTypes144 = findBean.nameAttributesTypes("String",em);
        attributes86.setAttributesTypes(attributesTypes144);
        em.persist(attributes86);
        em.flush();

        Attributes attributes87 = new Attributes();
        attributes87.setName("codigoInventario");
        attributes87.setNullable(true);
        attributes87.setSingle(false);
//      ...................... Items ........................
        Entities entity145 = new Entities();
        entity145 = findBean.nameEntities("Items",em);
        attributes87.setEntities(entity145);
//      ...................... String ........................
        AttributesTypes attributesTypes146 = new AttributesTypes();
        attributesTypes146 = findBean.nameAttributesTypes("String",em);
        attributes87.setAttributesTypes(attributesTypes146);
        em.persist(attributes87);
        em.flush();

        Attributes attributes88 = new Attributes();
        attributes88.setName("serial");
        attributes88.setNullable(true);
        attributes88.setSingle(false);
//      ...................... Items ........................
        Entities entity147 = new Entities();
        entity147 = findBean.nameEntities("Items",em);
        attributes88.setEntities(entity147);
//      ...................... String ........................
        AttributesTypes attributesTypes148 = new AttributesTypes();
        attributesTypes148 = findBean.nameAttributesTypes("String",em);
        attributes88.setAttributesTypes(attributesTypes148);
        em.persist(attributes88);
        em.flush();

        Attributes attributes89 = new Attributes();
        attributes89.setName("codigoBarras");
        attributes89.setNullable(true);
        attributes89.setSingle(false);
//      ...................... Items ........................
        Entities entity149 = new Entities();
        entity149 = findBean.nameEntities("Items",em);
        attributes89.setEntities(entity149);
//      ...................... String ........................
        AttributesTypes attributesTypes150 = new AttributesTypes();
        attributesTypes150 = findBean.nameAttributesTypes("String",em);
        attributes89.setAttributesTypes(attributesTypes150);
        em.persist(attributes89);
        em.flush();

        Attributes attributes90 = new Attributes();
        attributes90.setName("fechaAdquisicion");
        attributes90.setNullable(true);
        attributes90.setSingle(false);
//      ...................... Items ........................
        Entities entity151 = new Entities();
        entity151 = findBean.nameEntities("Items",em);
        attributes90.setEntities(entity151);
//      ...................... Date ........................
        AttributesTypes attributesTypes152 = new AttributesTypes();
        attributesTypes152 = findBean.nameAttributesTypes("Date",em);
        attributes90.setAttributesTypes(attributesTypes152);
        em.persist(attributes90);
        em.flush();

        Attributes attributes91 = new Attributes();
        attributes91.setName("fechaVencimiento");
        attributes91.setNullable(true);
        attributes91.setSingle(false);
//      ...................... Items ........................
        Entities entity153 = new Entities();
        entity153 = findBean.nameEntities("Items",em);
        attributes91.setEntities(entity153);
//      ...................... Date ........................
        AttributesTypes attributesTypes154 = new AttributesTypes();
        attributesTypes154 = findBean.nameAttributesTypes("Date",em);
        attributes91.setAttributesTypes(attributesTypes154);
        em.persist(attributes91);
        em.flush();

        Attributes attributes92 = new Attributes();
        attributes92.setName("vencimientoGarantia");
        attributes92.setNullable(true);
        attributes92.setSingle(false);
//      ...................... Items ........................
        Entities entity155 = new Entities();
        entity155 = findBean.nameEntities("Items",em);
        attributes92.setEntities(entity155);
//      ...................... Date ........................
        AttributesTypes attributesTypes156 = new AttributesTypes();
        attributesTypes156 = findBean.nameAttributesTypes("Date",em);
        attributes92.setAttributesTypes(attributesTypes156);
        em.persist(attributes92);
        em.flush();

        Attributes attributes93 = new Attributes();
        attributes93.setName("minimo");
        attributes93.setNullable(true);
        attributes93.setSingle(false);
//      ...................... Items ........................
        Entities entity157 = new Entities();
        entity157 = findBean.nameEntities("Items",em);
        attributes93.setEntities(entity157);
//      ...................... Integer ........................
        AttributesTypes attributesTypes158 = new AttributesTypes();
        attributesTypes158 = findBean.nameAttributesTypes("Integer",em);
        attributes93.setAttributesTypes(attributesTypes158);
        em.persist(attributes93);
        em.flush();

        Attributes attributes94 = new Attributes();
        attributes94.setName("maximo");
        attributes94.setNullable(true);
        attributes94.setSingle(false);
//      ...................... Items ........................
        Entities entity159 = new Entities();
        entity159 = findBean.nameEntities("Items",em);
        attributes94.setEntities(entity159);
//      ...................... Integer ........................
        AttributesTypes attributesTypes160 = new AttributesTypes();
        attributesTypes160 = findBean.nameAttributesTypes("Integer",em);
        attributes94.setAttributesTypes(attributesTypes160);
        em.persist(attributes94);
        em.flush();

        Attributes attributes95 = new Attributes();
        attributes95.setName("cantidad");
        attributes95.setNullable(true);
        attributes95.setSingle(false);
//      ...................... Items ........................
        Entities entity161 = new Entities();
        entity161 = findBean.nameEntities("Items",em);
        attributes95.setEntities(entity161);
//      ...................... Integer ........................
        AttributesTypes attributesTypes162 = new AttributesTypes();
        attributesTypes162 = findBean.nameAttributesTypes("Integer",em);
        attributes95.setAttributesTypes(attributesTypes162);
        em.persist(attributes95);
        em.flush();

        Attributes attributes96 = new Attributes();
        attributes96.setName("ubicado");
        attributes96.setNullable(true);
        attributes96.setSingle(false);
//      ...................... Items ........................
        Entities entity163 = new Entities();
        entity163 = findBean.nameEntities("Items",em);
        attributes96.setEntities(entity163);
//      ...................... String ........................
        AttributesTypes attributesTypes164 = new AttributesTypes();
        attributesTypes164 = findBean.nameAttributesTypes("String",em);
        attributes96.setAttributesTypes(attributesTypes164);
        em.persist(attributes96);
        em.flush();

        Entities entities97 = new Entities();
        entities97.setName("Sites");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId165 = new GroupIds();
        groupId165 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities97.setGroupIds(groupId165);
        em.persist(entities97);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes98 = new Attributes();
        attributes98.setName("title");
        attributes98.setNullable(true);
        attributes98.setSingle(false);
//      ...................... Sites ........................
        Entities entity166 = new Entities();
        entity166 = findBean.nameEntities("Sites",em);
        attributes98.setEntities(entity166);
//      ...................... String ........................
        AttributesTypes attributesTypes167 = new AttributesTypes();
        attributesTypes167 = findBean.nameAttributesTypes("String",em);
        attributes98.setAttributesTypes(attributesTypes167);
        em.persist(attributes98);
        em.flush();

        Attributes attributes99 = new Attributes();
        attributes99.setName("link");
        attributes99.setNullable(false);
        attributes99.setSingle(true);
//      ...................... Sites ........................
        Entities entity168 = new Entities();
        entity168 = findBean.nameEntities("Sites",em);
        attributes99.setEntities(entity168);
//      ...................... String ........................
        AttributesTypes attributesTypes169 = new AttributesTypes();
        attributesTypes169 = findBean.nameAttributesTypes("String",em);
        attributes99.setAttributesTypes(attributesTypes169);
        em.persist(attributes99);
        em.flush();

//      ---------------------- Relationships ------------------------

/*
. Secciones . *..* Tasks
. Tasks . *..* Secciones

. Tasks . *..* Sites
. Sites . *..* Tasks

. Marcas . *..* Empresas
. Empresas . *..* Marcas

. Empresas . *..* Sites
. Sites . *..* Empresas

. SitesTypes . *..* Sites
. Sites . *..* SitesTypes

. Secciones . *..* Activities
. Activities . *..* Secciones

. Activities . *..* Sites
. Sites . *..* Activities

. Calendars . *..* Activities
. Activities . *..* Calendars

. Personas . *..* Sites
. Sites . *..* Personas

. ActivitiesTypes . *..* Activities
. Activities . *..* ActivitiesTypes

. Personas . *..* Activities
. Activities . *..* Personas

. Activities . *..* Tasks
. Tasks . *..* Activities


TipoPersonal 1..* Personas
Sites 1..* IpAddress
TiposAreasFisicas 1..* AreasFisicas
Empresas 1..* Personas
NamesItems 1..* Items
SwitchPorts 1..* Items
Facturas 1..* ItemsFacturas
Items 1..* Switchs
Items 1..* Macs
. Items . 1..* Items
TiposInventarios 1..* Inventarios
Items 1..* ItemsFacturas
Inventarios 1..* Items
TiposItems 1..* Items
Secciones 1..* Secciones
TasksTypes 1..* Tasks
Secciones 1..* Items
Switchs 1..* SwitchPorts
EstadosItems 1..* Items
Vlan 1..* Macs
Empresas 1..* Facturas
Personas 1..* Secciones
Marcas 1..* NamesItems
SitesTypes 1..* SitesTypes
AreasFisicas 1..* Items
TiposSecciones 1..* Secciones
AreasFisicas 1..* AreasFisicas
*/
        Relationships relationships1 = new Relationships();
        relationships1.setOptionality(true);
        relationships1.setIsEmbedded(false);
//      ...................... TiposSecciones ........................
        Entities entities170 = new Entities();
        entities170 = findBean.nameEntities("TiposSecciones",em);
        relationships1.setFrom(entities170);
//      ...................... Secciones ........................
        Entities entities171 = new Entities();
        entities171 = findBean.nameEntities("Secciones",em);
        relationships1.setTo(entities171);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities172 = new Cardinalities();
        cardinalities172 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships1.setCardinalities(cardinalities172);
        em.persist(relationships1);
        em.flush();

        Relationships relationships2 = new Relationships();
        relationships2.setOptionality(true);
        relationships2.setIsEmbedded(false);
//      ...................... Calendars ........................
        Entities entities173 = new Entities();
        entities173 = findBean.nameEntities("Calendars",em);
        relationships2.setFrom(entities173);
//      ...................... Activities ........................
        Entities entities174 = new Entities();
        entities174 = findBean.nameEntities("Activities",em);
        relationships2.setTo(entities174);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities175 = new Cardinalities();
        cardinalities175 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships2.setCardinalities(cardinalities175);
        em.persist(relationships2);
        em.flush();

        Relationships relationships6 = new Relationships();
        relationships6.setOptionality(true);
        relationships6.setIsEmbedded(false);
//      ...................... ActivitiesTypes ........................
        Entities entities185 = new Entities();
        entities185 = findBean.nameEntities("ActivitiesTypes",em);
        relationships6.setFrom(entities185);
//      ...................... Activities ........................
        Entities entities186 = new Entities();
        entities186 = findBean.nameEntities("Activities",em);
        relationships6.setTo(entities186);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities187 = new Cardinalities();
        cardinalities187 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships6.setCardinalities(cardinalities187);
        em.persist(relationships6);
        em.flush();

        Relationships relationships8 = new Relationships();
        relationships8.setOptionality(true);
        relationships8.setIsEmbedded(false);
//      ...................... Facturas ........................
        Entities entities191 = new Entities();
        entities191 = findBean.nameEntities("Facturas",em);
        relationships8.setFrom(entities191);
//      ...................... ItemsFacturas ........................
        Entities entities192 = new Entities();
        entities192 = findBean.nameEntities("ItemsFacturas",em);
        relationships8.setTo(entities192);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities193 = new Cardinalities();
        cardinalities193 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships8.setCardinalities(cardinalities193);
        em.persist(relationships8);
        em.flush();

        Relationships relationships9 = new Relationships();
        relationships9.setOptionality(true);
        relationships9.setIsEmbedded(false);
//      ...................... SitesTypes ........................
        Entities entities194 = new Entities();
        entities194 = findBean.nameEntities("SitesTypes",em);
        relationships9.setFrom(entities194);
//      ...................... SitesTypes ........................
        Entities entities195 = new Entities();
        entities195 = findBean.nameEntities("SitesTypes",em);
        relationships9.setTo(entities195);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities196 = new Cardinalities();
        cardinalities196 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships9.setCardinalities(cardinalities196);
        em.persist(relationships9);
        em.flush();

        Relationships relationships10 = new Relationships();
        relationships10.setOptionality(true);
        relationships10.setIsEmbedded(false);
//      ...................... TiposItems ........................
        Entities entities197 = new Entities();
        entities197 = findBean.nameEntities("TiposItems",em);
        relationships10.setFrom(entities197);
//      ...................... Items ........................
        Entities entities198 = new Entities();
        entities198 = findBean.nameEntities("Items",em);
        relationships10.setTo(entities198);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities199 = new Cardinalities();
        cardinalities199 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships10.setCardinalities(cardinalities199);
        em.persist(relationships10);
        em.flush();

        Relationships relationships11 = new Relationships();
        relationships11.setOptionality(true);
        relationships11.setIsEmbedded(false);
//      ...................... Switchs ........................
        Entities entities200 = new Entities();
        entities200 = findBean.nameEntities("Switchs",em);
        relationships11.setFrom(entities200);
//      ...................... SwitchPorts ........................
        Entities entities201 = new Entities();
        entities201 = findBean.nameEntities("SwitchPorts",em);
        relationships11.setTo(entities201);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities202 = new Cardinalities();
        cardinalities202 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships11.setCardinalities(cardinalities202);
        em.persist(relationships11);
        em.flush();

        Relationships relationships12 = new Relationships();
        relationships12.setOptionality(true);
        relationships12.setIsEmbedded(false);
//      ...................... Inventarios ........................
        Entities entities203 = new Entities();
        entities203 = findBean.nameEntities("Inventarios",em);
        relationships12.setFrom(entities203);
//      ...................... Items ........................
        Entities entities204 = new Entities();
        entities204 = findBean.nameEntities("Items",em);
        relationships12.setTo(entities204);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities205 = new Cardinalities();
        cardinalities205 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships12.setCardinalities(cardinalities205);
        em.persist(relationships12);
        em.flush();

        Relationships relationships13 = new Relationships();
        relationships13.setOptionality(true);
        relationships13.setIsEmbedded(false);
//      ...................... Tasks ........................
        Entities entities206 = new Entities();
        entities206 = findBean.nameEntities("Tasks",em);
        relationships13.setFrom(entities206);
//      ...................... Sites ........................
        Entities entities207 = new Entities();
        entities207 = findBean.nameEntities("Sites",em);
        relationships13.setTo(entities207);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities208 = new Cardinalities();
        cardinalities208 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships13.setCardinalities(cardinalities208);
        em.persist(relationships13);
        em.flush();

        Relationships relationships16 = new Relationships();
        relationships16.setOptionality(true);
        relationships16.setIsEmbedded(false);
//      ...................... Personas ........................
        Entities entities215 = new Entities();
        entities215 = findBean.nameEntities("Personas",em);
        relationships16.setFrom(entities215);
//      ...................... Sites ........................
        Entities entities216 = new Entities();
        entities216 = findBean.nameEntities("Sites",em);
        relationships16.setTo(entities216);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities217 = new Cardinalities();
        cardinalities217 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships16.setCardinalities(cardinalities217);
        em.persist(relationships16);
        em.flush();

        Relationships relationships17 = new Relationships();
        relationships17.setOptionality(true);
        relationships17.setIsEmbedded(false);
//      ...................... Marcas ........................
        Entities entities218 = new Entities();
        entities218 = findBean.nameEntities("Marcas",em);
        relationships17.setFrom(entities218);
//      ...................... NamesItems ........................
        Entities entities219 = new Entities();
        entities219 = findBean.nameEntities("NamesItems",em);
        relationships17.setTo(entities219);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities220 = new Cardinalities();
        cardinalities220 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships17.setCardinalities(cardinalities220);
        em.persist(relationships17);
        em.flush();

        Relationships relationships18 = new Relationships();
        relationships18.setOptionality(true);
        relationships18.setIsEmbedded(false);
//      ...................... AreasFisicas ........................
        Entities entities221 = new Entities();
        entities221 = findBean.nameEntities("AreasFisicas",em);
        relationships18.setFrom(entities221);
//      ...................... Items ........................
        Entities entities222 = new Entities();
        entities222 = findBean.nameEntities("Items",em);
        relationships18.setTo(entities222);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities223 = new Cardinalities();
        cardinalities223 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships18.setCardinalities(cardinalities223);
        em.persist(relationships18);
        em.flush();

        Relationships relationships20 = new Relationships();
        relationships20.setOptionality(true);
        relationships20.setIsEmbedded(false);
//      ...................... Items ........................
        Entities entities227 = new Entities();
        entities227 = findBean.nameEntities("Items",em);
        relationships20.setFrom(entities227);
//      ...................... Macs ........................
        Entities entities228 = new Entities();
        entities228 = findBean.nameEntities("Macs",em);
        relationships20.setTo(entities228);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities229 = new Cardinalities();
        cardinalities229 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships20.setCardinalities(cardinalities229);
        em.persist(relationships20);
        em.flush();

        Relationships relationships21 = new Relationships();
        relationships21.setOptionality(true);
        relationships21.setIsEmbedded(false);
//      ...................... TipoPersonal ........................
        Entities entities230 = new Entities();
        entities230 = findBean.nameEntities("TipoPersonal",em);
        relationships21.setFrom(entities230);
//      ...................... Personas ........................
        Entities entities231 = new Entities();
        entities231 = findBean.nameEntities("Personas",em);
        relationships21.setTo(entities231);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities232 = new Cardinalities();
        cardinalities232 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships21.setCardinalities(cardinalities232);
        em.persist(relationships21);
        em.flush();

        Relationships relationships22 = new Relationships();
        relationships22.setOptionality(true);
        relationships22.setIsEmbedded(false);
//      ...................... Secciones ........................
        Entities entities233 = new Entities();
        entities233 = findBean.nameEntities("Secciones",em);
        relationships22.setFrom(entities233);
//      ...................... Activities ........................
        Entities entities234 = new Entities();
        entities234 = findBean.nameEntities("Activities",em);
        relationships22.setTo(entities234);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities235 = new Cardinalities();
        cardinalities235 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships22.setCardinalities(cardinalities235);
        em.persist(relationships22);
        em.flush();

        Relationships relationships24 = new Relationships();
        relationships24.setOptionality(true);
        relationships24.setIsEmbedded(false);
//      ...................... AreasFisicas ........................
        Entities entities239 = new Entities();
        entities239 = findBean.nameEntities("AreasFisicas",em);
        relationships24.setFrom(entities239);
//      ...................... AreasFisicas ........................
        Entities entities240 = new Entities();
        entities240 = findBean.nameEntities("AreasFisicas",em);
        relationships24.setTo(entities240);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities241 = new Cardinalities();
        cardinalities241 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships24.setCardinalities(cardinalities241);
        em.persist(relationships24);
        em.flush();

        Relationships relationships25 = new Relationships();
        relationships25.setOptionality(true);
        relationships25.setIsEmbedded(false);
//      ...................... NamesItems ........................
        Entities entities242 = new Entities();
        entities242 = findBean.nameEntities("NamesItems",em);
        relationships25.setFrom(entities242);
//      ...................... Items ........................
        Entities entities243 = new Entities();
        entities243 = findBean.nameEntities("Items",em);
        relationships25.setTo(entities243);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities244 = new Cardinalities();
        cardinalities244 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships25.setCardinalities(cardinalities244);
        em.persist(relationships25);
        em.flush();

        Relationships relationships27 = new Relationships();
        relationships27.setOptionality(true);
        relationships27.setIsEmbedded(false);
//      ...................... Sites ........................
        Entities entities248 = new Entities();
        entities248 = findBean.nameEntities("Sites",em);
        relationships27.setFrom(entities248);
//      ...................... IpAddress ........................
        Entities entities249 = new Entities();
        entities249 = findBean.nameEntities("IpAddress",em);
        relationships27.setTo(entities249);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities250 = new Cardinalities();
        cardinalities250 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships27.setCardinalities(cardinalities250);
        em.persist(relationships27);
        em.flush();

        Relationships relationships28 = new Relationships();
        relationships28.setOptionality(true);
        relationships28.setIsEmbedded(false);
//      ...................... Empresas ........................
        Entities entities251 = new Entities();
        entities251 = findBean.nameEntities("Empresas",em);
        relationships28.setFrom(entities251);
//      ...................... Sites ........................
        Entities entities252 = new Entities();
        entities252 = findBean.nameEntities("Sites",em);
        relationships28.setTo(entities252);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities253 = new Cardinalities();
        cardinalities253 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships28.setCardinalities(cardinalities253);
        em.persist(relationships28);
        em.flush();

        Relationships relationships29 = new Relationships();
        relationships29.setOptionality(true);
        relationships29.setIsEmbedded(false);
//      ...................... Activities ........................
        Entities entities254 = new Entities();
        entities254 = findBean.nameEntities("Activities",em);
        relationships29.setFrom(entities254);
//      ...................... Sites ........................
        Entities entities255 = new Entities();
        entities255 = findBean.nameEntities("Sites",em);
        relationships29.setTo(entities255);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities256 = new Cardinalities();
        cardinalities256 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships29.setCardinalities(cardinalities256);
        em.persist(relationships29);
        em.flush();

        Relationships relationships30 = new Relationships();
        relationships30.setOptionality(true);
        relationships30.setIsEmbedded(false);
//      ...................... TasksTypes ........................
        Entities entities257 = new Entities();
        entities257 = findBean.nameEntities("TasksTypes",em);
        relationships30.setFrom(entities257);
//      ...................... Tasks ........................
        Entities entities258 = new Entities();
        entities258 = findBean.nameEntities("Tasks",em);
        relationships30.setTo(entities258);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities259 = new Cardinalities();
        cardinalities259 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships30.setCardinalities(cardinalities259);
        em.persist(relationships30);
        em.flush();

        Relationships relationships31 = new Relationships();
        relationships31.setOptionality(true);
        relationships31.setIsEmbedded(false);
//      ...................... Empresas ........................
        Entities entities260 = new Entities();
        entities260 = findBean.nameEntities("Empresas",em);
        relationships31.setFrom(entities260);
//      ...................... Facturas ........................
        Entities entities261 = new Entities();
        entities261 = findBean.nameEntities("Facturas",em);
        relationships31.setTo(entities261);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities262 = new Cardinalities();
        cardinalities262 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships31.setCardinalities(cardinalities262);
        em.persist(relationships31);
        em.flush();

        Relationships relationships32 = new Relationships();
        relationships32.setOptionality(true);
        relationships32.setIsEmbedded(false);
//      ...................... EstadosItems ........................
        Entities entities263 = new Entities();
        entities263 = findBean.nameEntities("EstadosItems",em);
        relationships32.setFrom(entities263);
//      ...................... Items ........................
        Entities entities264 = new Entities();
        entities264 = findBean.nameEntities("Items",em);
        relationships32.setTo(entities264);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities265 = new Cardinalities();
        cardinalities265 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships32.setCardinalities(cardinalities265);
        em.persist(relationships32);
        em.flush();

        Relationships relationships33 = new Relationships();
        relationships33.setOptionality(true);
        relationships33.setIsEmbedded(false);
//      ...................... Secciones ........................
        Entities entities266 = new Entities();
        entities266 = findBean.nameEntities("Secciones",em);
        relationships33.setFrom(entities266);
//      ...................... Tasks ........................
        Entities entities267 = new Entities();
        entities267 = findBean.nameEntities("Tasks",em);
        relationships33.setTo(entities267);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities268 = new Cardinalities();
        cardinalities268 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships33.setCardinalities(cardinalities268);
        em.persist(relationships33);
        em.flush();

        Relationships relationships34 = new Relationships();
        relationships34.setOptionality(true);
        relationships34.setIsEmbedded(false);
//      ...................... Personas ........................
        Entities entities269 = new Entities();
        entities269 = findBean.nameEntities("Personas",em);
        relationships34.setFrom(entities269);
//      ...................... Activities ........................
        Entities entities270 = new Entities();
        entities270 = findBean.nameEntities("Activities",em);
        relationships34.setTo(entities270);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities271 = new Cardinalities();
        cardinalities271 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships34.setCardinalities(cardinalities271);
        em.persist(relationships34);
        em.flush();

        Relationships relationships36 = new Relationships();
        relationships36.setOptionality(true);
        relationships36.setIsEmbedded(false);
//      ...................... Secciones ........................
        Entities entities275 = new Entities();
        entities275 = findBean.nameEntities("Secciones",em);
        relationships36.setFrom(entities275);
//      ...................... Secciones ........................
        Entities entities276 = new Entities();
        entities276 = findBean.nameEntities("Secciones",em);
        relationships36.setTo(entities276);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities277 = new Cardinalities();
        cardinalities277 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships36.setCardinalities(cardinalities277);
        em.persist(relationships36);
        em.flush();

        Relationships relationships37 = new Relationships();
        relationships37.setOptionality(true);
        relationships37.setIsEmbedded(false);
//      ...................... Items ........................
        Entities entities278 = new Entities();
        entities278 = findBean.nameEntities("Items",em);
        relationships37.setFrom(entities278);
//      ...................... ItemsFacturas ........................
        Entities entities279 = new Entities();
        entities279 = findBean.nameEntities("ItemsFacturas",em);
        relationships37.setTo(entities279);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities280 = new Cardinalities();
        cardinalities280 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships37.setCardinalities(cardinalities280);
        em.persist(relationships37);
        em.flush();

        Relationships relationships38 = new Relationships();
        relationships38.setOptionality(true);
        relationships38.setIsEmbedded(false);
//      ...................... SitesTypes ........................
        Entities entities281 = new Entities();
        entities281 = findBean.nameEntities("SitesTypes",em);
        relationships38.setFrom(entities281);
//      ...................... Sites ........................
        Entities entities282 = new Entities();
        entities282 = findBean.nameEntities("Sites",em);
        relationships38.setTo(entities282);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities283 = new Cardinalities();
        cardinalities283 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships38.setCardinalities(cardinalities283);
        em.persist(relationships38);
        em.flush();

        Relationships relationships39 = new Relationships();
        relationships39.setOptionality(true);
        relationships39.setIsEmbedded(false);
//      ...................... Items ........................
        Entities entities284 = new Entities();
        entities284 = findBean.nameEntities("Items",em);
        relationships39.setFrom(entities284);
//      ...................... Switchs ........................
        Entities entities285 = new Entities();
        entities285 = findBean.nameEntities("Switchs",em);
        relationships39.setTo(entities285);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities286 = new Cardinalities();
        cardinalities286 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships39.setCardinalities(cardinalities286);
        em.persist(relationships39);
        em.flush();

        Relationships relationships41 = new Relationships();
        relationships41.setOptionality(true);
        relationships41.setIsEmbedded(false);
//      ...................... Items ........................
        Entities entities290 = new Entities();
        entities290 = findBean.nameEntities("Items",em);
        relationships41.setFrom(entities290);
//      ...................... Items ........................
        Entities entities291 = new Entities();
        entities291 = findBean.nameEntities("Items",em);
        relationships41.setTo(entities291);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities292 = new Cardinalities();
        cardinalities292 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships41.setCardinalities(cardinalities292);
        em.persist(relationships41);
        em.flush();

        Relationships relationships42 = new Relationships();
        relationships42.setOptionality(true);
        relationships42.setIsEmbedded(false);
//      ...................... Marcas ........................
        Entities entities293 = new Entities();
        entities293 = findBean.nameEntities("Marcas",em);
        relationships42.setFrom(entities293);
//      ...................... Empresas ........................
        Entities entities294 = new Entities();
        entities294 = findBean.nameEntities("Empresas",em);
        relationships42.setTo(entities294);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities295 = new Cardinalities();
        cardinalities295 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships42.setCardinalities(cardinalities295);
        em.persist(relationships42);
        em.flush();

        Relationships relationships43 = new Relationships();
        relationships43.setOptionality(true);
        relationships43.setIsEmbedded(false);
//      ...................... Vlan ........................
        Entities entities296 = new Entities();
        entities296 = findBean.nameEntities("Vlan",em);
        relationships43.setFrom(entities296);
//      ...................... Macs ........................
        Entities entities297 = new Entities();
        entities297 = findBean.nameEntities("Macs",em);
        relationships43.setTo(entities297);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities298 = new Cardinalities();
        cardinalities298 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships43.setCardinalities(cardinalities298);
        em.persist(relationships43);
        em.flush();

        Relationships relationships44 = new Relationships();
        relationships44.setOptionality(true);
        relationships44.setIsEmbedded(false);
//      ...................... Personas ........................
        Entities entities299 = new Entities();
        entities299 = findBean.nameEntities("Personas",em);
        relationships44.setFrom(entities299);
//      ...................... Secciones ........................
        Entities entities300 = new Entities();
        entities300 = findBean.nameEntities("Secciones",em);
        relationships44.setTo(entities300);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities301 = new Cardinalities();
        cardinalities301 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships44.setCardinalities(cardinalities301);
        em.persist(relationships44);
        em.flush();

        Relationships relationships45 = new Relationships();
        relationships45.setOptionality(true);
        relationships45.setIsEmbedded(false);
//      ...................... Empresas ........................
        Entities entities302 = new Entities();
        entities302 = findBean.nameEntities("Empresas",em);
        relationships45.setFrom(entities302);
//      ...................... Personas ........................
        Entities entities303 = new Entities();
        entities303 = findBean.nameEntities("Personas",em);
        relationships45.setTo(entities303);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities304 = new Cardinalities();
        cardinalities304 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships45.setCardinalities(cardinalities304);
        em.persist(relationships45);
        em.flush();

        Relationships relationships47 = new Relationships();
        relationships47.setOptionality(true);
        relationships47.setIsEmbedded(false);
//      ...................... SwitchPorts ........................
        Entities entities308 = new Entities();
        entities308 = findBean.nameEntities("SwitchPorts",em);
        relationships47.setFrom(entities308);
//      ...................... Items ........................
        Entities entities309 = new Entities();
        entities309 = findBean.nameEntities("Items",em);
        relationships47.setTo(entities309);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities310 = new Cardinalities();
        cardinalities310 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships47.setCardinalities(cardinalities310);
        em.persist(relationships47);
        em.flush();

        Relationships relationships48 = new Relationships();
        relationships48.setOptionality(true);
        relationships48.setIsEmbedded(false);
//      ...................... Activities ........................
        Entities entities311 = new Entities();
        entities311 = findBean.nameEntities("Activities",em);
        relationships48.setFrom(entities311);
//      ...................... Tasks ........................
        Entities entities312 = new Entities();
        entities312 = findBean.nameEntities("Tasks",em);
        relationships48.setTo(entities312);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities313 = new Cardinalities();
        cardinalities313 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships48.setCardinalities(cardinalities313);
        em.persist(relationships48);
        em.flush();

        Relationships relationships49 = new Relationships();
        relationships49.setOptionality(true);
        relationships49.setIsEmbedded(false);
//      ...................... TiposInventarios ........................
        Entities entities314 = new Entities();
        entities314 = findBean.nameEntities("TiposInventarios",em);
        relationships49.setFrom(entities314);
//      ...................... Inventarios ........................
        Entities entities315 = new Entities();
        entities315 = findBean.nameEntities("Inventarios",em);
        relationships49.setTo(entities315);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities316 = new Cardinalities();
        cardinalities316 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships49.setCardinalities(cardinalities316);
        em.persist(relationships49);
        em.flush();

        Relationships relationships50 = new Relationships();
        relationships50.setOptionality(true);
        relationships50.setIsEmbedded(false);
//      ...................... Secciones ........................
        Entities entities317 = new Entities();
        entities317 = findBean.nameEntities("Secciones",em);
        relationships50.setFrom(entities317);
//      ...................... Items ........................
        Entities entities318 = new Entities();
        entities318 = findBean.nameEntities("Items",em);
        relationships50.setTo(entities318);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities319 = new Cardinalities();
        cardinalities319 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships50.setCardinalities(cardinalities319);
        em.persist(relationships50);
        em.flush();

        Relationships relationships51 = new Relationships();
        relationships51.setOptionality(true);
        relationships51.setIsEmbedded(false);
//      ...................... TiposAreasFisicas ........................
        Entities entities320 = new Entities();
        entities320 = findBean.nameEntities("TiposAreasFisicas",em);
        relationships51.setFrom(entities320);
//      ...................... AreasFisicas ........................
        Entities entities321 = new Entities();
        entities321 = findBean.nameEntities("AreasFisicas",em);
        relationships51.setTo(entities321);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities322 = new Cardinalities();
        cardinalities322 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships51.setCardinalities(cardinalities322);
        em.persist(relationships51);
        em.flush();

    } // data()

} // crm
