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
        entities2.setName("TiposInventarios");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId2 = new GroupIds();
        groupId2 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities2.setGroupIds(groupId2);
        em.persist(entities2);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes3 = new Attributes();
        attributes3.setName("nombre");
        attributes3.setNullable(true);
        attributes3.setSingle(false);
//      ...................... TiposInventarios ........................
        Entities entity3 = new Entities();
        entity3 = findBean.nameEntities("TiposInventarios",em);
        attributes3.setEntities(entity3);
//      ...................... String ........................
        AttributesTypes attributesTypes4 = new AttributesTypes();
        attributesTypes4 = findBean.nameAttributesTypes("String",em);
        attributes3.setAttributesTypes(attributesTypes4);
        em.persist(attributes3);
        em.flush();

        Entities entities4 = new Entities();
        entities4.setName("Activities");
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
//      ...................... Activities ........................
        Entities entity6 = new Entities();
        entity6 = findBean.nameEntities("Activities",em);
        attributes5.setEntities(entity6);
//      ...................... String ........................
        AttributesTypes attributesTypes7 = new AttributesTypes();
        attributesTypes7 = findBean.nameAttributesTypes("String",em);
        attributes5.setAttributesTypes(attributesTypes7);
        em.persist(attributes5);
        em.flush();

        Attributes attributes6 = new Attributes();
        attributes6.setName("detail");
        attributes6.setNullable(true);
        attributes6.setSingle(false);
//      ...................... Activities ........................
        Entities entity8 = new Entities();
        entity8 = findBean.nameEntities("Activities",em);
        attributes6.setEntities(entity8);
//      ...................... String ........................
        AttributesTypes attributesTypes9 = new AttributesTypes();
        attributesTypes9 = findBean.nameAttributesTypes("String",em);
        attributes6.setAttributesTypes(attributesTypes9);
        em.persist(attributes6);
        em.flush();

        Entities entities7 = new Entities();
        entities7.setName("Marcas");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId10 = new GroupIds();
        groupId10 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities7.setGroupIds(groupId10);
        em.persist(entities7);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes8 = new Attributes();
        attributes8.setName("nombre");
        attributes8.setNullable(true);
        attributes8.setSingle(false);
//      ...................... Marcas ........................
        Entities entity11 = new Entities();
        entity11 = findBean.nameEntities("Marcas",em);
        attributes8.setEntities(entity11);
//      ...................... String ........................
        AttributesTypes attributesTypes12 = new AttributesTypes();
        attributesTypes12 = findBean.nameAttributesTypes("String",em);
        attributes8.setAttributesTypes(attributesTypes12);
        em.persist(attributes8);
        em.flush();

        Entities entities9 = new Entities();
        entities9.setName("Vlan");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId13 = new GroupIds();
        groupId13 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities9.setGroupIds(groupId13);
        em.persist(entities9);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes10 = new Attributes();
        attributes10.setName("nombre");
        attributes10.setNullable(true);
        attributes10.setSingle(false);
//      ...................... Vlan ........................
        Entities entity14 = new Entities();
        entity14 = findBean.nameEntities("Vlan",em);
        attributes10.setEntities(entity14);
//      ...................... String ........................
        AttributesTypes attributesTypes15 = new AttributesTypes();
        attributesTypes15 = findBean.nameAttributesTypes("String",em);
        attributes10.setAttributesTypes(attributesTypes15);
        em.persist(attributes10);
        em.flush();

        Attributes attributes11 = new Attributes();
        attributes11.setName("ip");
        attributes11.setNullable(true);
        attributes11.setSingle(false);
//      ...................... Vlan ........................
        Entities entity16 = new Entities();
        entity16 = findBean.nameEntities("Vlan",em);
        attributes11.setEntities(entity16);
//      ...................... String ........................
        AttributesTypes attributesTypes17 = new AttributesTypes();
        attributesTypes17 = findBean.nameAttributesTypes("String",em);
        attributes11.setAttributesTypes(attributesTypes17);
        em.persist(attributes11);
        em.flush();

        Entities entities12 = new Entities();
        entities12.setName("TiposAreasFisicas");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId18 = new GroupIds();
        groupId18 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities12.setGroupIds(groupId18);
        em.persist(entities12);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes13 = new Attributes();
        attributes13.setName("nombre");
        attributes13.setNullable(true);
        attributes13.setSingle(false);
//      ...................... TiposAreasFisicas ........................
        Entities entity19 = new Entities();
        entity19 = findBean.nameEntities("TiposAreasFisicas",em);
        attributes13.setEntities(entity19);
//      ...................... String ........................
        AttributesTypes attributesTypes20 = new AttributesTypes();
        attributesTypes20 = findBean.nameAttributesTypes("String",em);
        attributes13.setAttributesTypes(attributesTypes20);
        em.persist(attributes13);
        em.flush();

        Entities entities14 = new Entities();
        entities14.setName("Facturas");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId21 = new GroupIds();
        groupId21 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities14.setGroupIds(groupId21);
        em.persist(entities14);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes15 = new Attributes();
        attributes15.setName("numero");
        attributes15.setNullable(true);
        attributes15.setSingle(false);
//      ...................... Facturas ........................
        Entities entity22 = new Entities();
        entity22 = findBean.nameEntities("Facturas",em);
        attributes15.setEntities(entity22);
//      ...................... String ........................
        AttributesTypes attributesTypes23 = new AttributesTypes();
        attributesTypes23 = findBean.nameAttributesTypes("String",em);
        attributes15.setAttributesTypes(attributesTypes23);
        em.persist(attributes15);
        em.flush();

        Entities entities16 = new Entities();
        entities16.setName("Series");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId24 = new GroupIds();
        groupId24 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities16.setGroupIds(groupId24);
        em.persist(entities16);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes17 = new Attributes();
        attributes17.setName("nombre");
        attributes17.setNullable(true);
        attributes17.setSingle(false);
//      ...................... Series ........................
        Entities entity25 = new Entities();
        entity25 = findBean.nameEntities("Series",em);
        attributes17.setEntities(entity25);
//      ...................... String ........................
        AttributesTypes attributesTypes26 = new AttributesTypes();
        attributesTypes26 = findBean.nameAttributesTypes("String",em);
        attributes17.setAttributesTypes(attributesTypes26);
        em.persist(attributes17);
        em.flush();

        Attributes attributes18 = new Attributes();
        attributes18.setName("codigo");
        attributes18.setNullable(true);
        attributes18.setSingle(false);
//      ...................... Series ........................
        Entities entity27 = new Entities();
        entity27 = findBean.nameEntities("Series",em);
        attributes18.setEntities(entity27);
//      ...................... String ........................
        AttributesTypes attributesTypes28 = new AttributesTypes();
        attributesTypes28 = findBean.nameAttributesTypes("String",em);
        attributes18.setAttributesTypes(attributesTypes28);
        em.persist(attributes18);
        em.flush();

        Attributes attributes19 = new Attributes();
        attributes19.setName("observaciones");
        attributes19.setNullable(true);
        attributes19.setSingle(false);
//      ...................... Series ........................
        Entities entity29 = new Entities();
        entity29 = findBean.nameEntities("Series",em);
        attributes19.setEntities(entity29);
//      ...................... String ........................
        AttributesTypes attributesTypes30 = new AttributesTypes();
        attributesTypes30 = findBean.nameAttributesTypes("String",em);
        attributes19.setAttributesTypes(attributesTypes30);
        em.persist(attributes19);
        em.flush();

        Entities entities20 = new Entities();
        entities20.setName("AreasFisicas");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId31 = new GroupIds();
        groupId31 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities20.setGroupIds(groupId31);
        em.persist(entities20);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes21 = new Attributes();
        attributes21.setName("nombre");
        attributes21.setNullable(true);
        attributes21.setSingle(false);
//      ...................... AreasFisicas ........................
        Entities entity32 = new Entities();
        entity32 = findBean.nameEntities("AreasFisicas",em);
        attributes21.setEntities(entity32);
//      ...................... String ........................
        AttributesTypes attributesTypes33 = new AttributesTypes();
        attributesTypes33 = findBean.nameAttributesTypes("String",em);
        attributes21.setAttributesTypes(attributesTypes33);
        em.persist(attributes21);
        em.flush();

        Entities entities22 = new Entities();
        entities22.setName("Empresas");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId34 = new GroupIds();
        groupId34 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities22.setGroupIds(groupId34);
        em.persist(entities22);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes23 = new Attributes();
        attributes23.setName("nombre");
        attributes23.setNullable(true);
        attributes23.setSingle(false);
//      ...................... Empresas ........................
        Entities entity35 = new Entities();
        entity35 = findBean.nameEntities("Empresas",em);
        attributes23.setEntities(entity35);
//      ...................... String ........................
        AttributesTypes attributesTypes36 = new AttributesTypes();
        attributesTypes36 = findBean.nameAttributesTypes("String",em);
        attributes23.setAttributesTypes(attributesTypes36);
        em.persist(attributes23);
        em.flush();

        Attributes attributes24 = new Attributes();
        attributes24.setName("nit");
        attributes24.setNullable(true);
        attributes24.setSingle(false);
//      ...................... Empresas ........................
        Entities entity37 = new Entities();
        entity37 = findBean.nameEntities("Empresas",em);
        attributes24.setEntities(entity37);
//      ...................... String ........................
        AttributesTypes attributesTypes38 = new AttributesTypes();
        attributesTypes38 = findBean.nameAttributesTypes("String",em);
        attributes24.setAttributesTypes(attributesTypes38);
        em.persist(attributes24);
        em.flush();

        Attributes attributes25 = new Attributes();
        attributes25.setName("link");
        attributes25.setNullable(true);
        attributes25.setSingle(false);
//      ...................... Empresas ........................
        Entities entity39 = new Entities();
        entity39 = findBean.nameEntities("Empresas",em);
        attributes25.setEntities(entity39);
//      ...................... String ........................
        AttributesTypes attributesTypes40 = new AttributesTypes();
        attributesTypes40 = findBean.nameAttributesTypes("String",em);
        attributes25.setAttributesTypes(attributesTypes40);
        em.persist(attributes25);
        em.flush();

        Attributes attributes26 = new Attributes();
        attributes26.setName("direccion");
        attributes26.setNullable(true);
        attributes26.setSingle(false);
//      ...................... Empresas ........................
        Entities entity41 = new Entities();
        entity41 = findBean.nameEntities("Empresas",em);
        attributes26.setEntities(entity41);
//      ...................... String ........................
        AttributesTypes attributesTypes42 = new AttributesTypes();
        attributesTypes42 = findBean.nameAttributesTypes("String",em);
        attributes26.setAttributesTypes(attributesTypes42);
        em.persist(attributes26);
        em.flush();

        Attributes attributes27 = new Attributes();
        attributes27.setName("telefonos");
        attributes27.setNullable(true);
        attributes27.setSingle(false);
//      ...................... Empresas ........................
        Entities entity43 = new Entities();
        entity43 = findBean.nameEntities("Empresas",em);
        attributes27.setEntities(entity43);
//      ...................... String ........................
        AttributesTypes attributesTypes44 = new AttributesTypes();
        attributesTypes44 = findBean.nameAttributesTypes("String",em);
        attributes27.setAttributesTypes(attributesTypes44);
        em.persist(attributes27);
        em.flush();

        Attributes attributes28 = new Attributes();
        attributes28.setName("email");
        attributes28.setNullable(true);
        attributes28.setSingle(false);
//      ...................... Empresas ........................
        Entities entity45 = new Entities();
        entity45 = findBean.nameEntities("Empresas",em);
        attributes28.setEntities(entity45);
//      ...................... String ........................
        AttributesTypes attributesTypes46 = new AttributesTypes();
        attributesTypes46 = findBean.nameAttributesTypes("String",em);
        attributes28.setAttributesTypes(attributesTypes46);
        em.persist(attributes28);
        em.flush();

        Entities entities29 = new Entities();
        entities29.setName("ActivitiesTypes");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId47 = new GroupIds();
        groupId47 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities29.setGroupIds(groupId47);
        em.persist(entities29);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes30 = new Attributes();
        attributes30.setName("name");
        attributes30.setNullable(true);
        attributes30.setSingle(false);
//      ...................... ActivitiesTypes ........................
        Entities entity48 = new Entities();
        entity48 = findBean.nameEntities("ActivitiesTypes",em);
        attributes30.setEntities(entity48);
//      ...................... String ........................
        AttributesTypes attributesTypes49 = new AttributesTypes();
        attributesTypes49 = findBean.nameAttributesTypes("String",em);
        attributes30.setAttributesTypes(attributesTypes49);
        em.persist(attributes30);
        em.flush();

        Entities entities31 = new Entities();
        entities31.setName("Items");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId50 = new GroupIds();
        groupId50 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities31.setGroupIds(groupId50);
        em.persist(entities31);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes32 = new Attributes();
        attributes32.setName("hojaVida");
        attributes32.setNullable(true);
        attributes32.setSingle(false);
//      ...................... Items ........................
        Entities entity51 = new Entities();
        entity51 = findBean.nameEntities("Items",em);
        attributes32.setEntities(entity51);
//      ...................... String ........................
        AttributesTypes attributesTypes52 = new AttributesTypes();
        attributesTypes52 = findBean.nameAttributesTypes("String",em);
        attributes32.setAttributesTypes(attributesTypes52);
        em.persist(attributes32);
        em.flush();

        Attributes attributes33 = new Attributes();
        attributes33.setName("codigo");
        attributes33.setNullable(true);
        attributes33.setSingle(false);
//      ...................... Items ........................
        Entities entity53 = new Entities();
        entity53 = findBean.nameEntities("Items",em);
        attributes33.setEntities(entity53);
//      ...................... String ........................
        AttributesTypes attributesTypes54 = new AttributesTypes();
        attributesTypes54 = findBean.nameAttributesTypes("String",em);
        attributes33.setAttributesTypes(attributesTypes54);
        em.persist(attributes33);
        em.flush();

        Attributes attributes34 = new Attributes();
        attributes34.setName("codigoInventario");
        attributes34.setNullable(true);
        attributes34.setSingle(false);
//      ...................... Items ........................
        Entities entity55 = new Entities();
        entity55 = findBean.nameEntities("Items",em);
        attributes34.setEntities(entity55);
//      ...................... String ........................
        AttributesTypes attributesTypes56 = new AttributesTypes();
        attributesTypes56 = findBean.nameAttributesTypes("String",em);
        attributes34.setAttributesTypes(attributesTypes56);
        em.persist(attributes34);
        em.flush();

        Attributes attributes35 = new Attributes();
        attributes35.setName("serial");
        attributes35.setNullable(true);
        attributes35.setSingle(false);
//      ...................... Items ........................
        Entities entity57 = new Entities();
        entity57 = findBean.nameEntities("Items",em);
        attributes35.setEntities(entity57);
//      ...................... String ........................
        AttributesTypes attributesTypes58 = new AttributesTypes();
        attributesTypes58 = findBean.nameAttributesTypes("String",em);
        attributes35.setAttributesTypes(attributesTypes58);
        em.persist(attributes35);
        em.flush();

        Attributes attributes36 = new Attributes();
        attributes36.setName("codigoBarras");
        attributes36.setNullable(true);
        attributes36.setSingle(false);
//      ...................... Items ........................
        Entities entity59 = new Entities();
        entity59 = findBean.nameEntities("Items",em);
        attributes36.setEntities(entity59);
//      ...................... String ........................
        AttributesTypes attributesTypes60 = new AttributesTypes();
        attributesTypes60 = findBean.nameAttributesTypes("String",em);
        attributes36.setAttributesTypes(attributesTypes60);
        em.persist(attributes36);
        em.flush();

        Attributes attributes37 = new Attributes();
        attributes37.setName("fechaAdquisicion");
        attributes37.setNullable(true);
        attributes37.setSingle(false);
//      ...................... Items ........................
        Entities entity61 = new Entities();
        entity61 = findBean.nameEntities("Items",em);
        attributes37.setEntities(entity61);
//      ...................... Date ........................
        AttributesTypes attributesTypes62 = new AttributesTypes();
        attributesTypes62 = findBean.nameAttributesTypes("Date",em);
        attributes37.setAttributesTypes(attributesTypes62);
        em.persist(attributes37);
        em.flush();

        Attributes attributes38 = new Attributes();
        attributes38.setName("fechaVencimiento");
        attributes38.setNullable(true);
        attributes38.setSingle(false);
//      ...................... Items ........................
        Entities entity63 = new Entities();
        entity63 = findBean.nameEntities("Items",em);
        attributes38.setEntities(entity63);
//      ...................... Date ........................
        AttributesTypes attributesTypes64 = new AttributesTypes();
        attributesTypes64 = findBean.nameAttributesTypes("Date",em);
        attributes38.setAttributesTypes(attributesTypes64);
        em.persist(attributes38);
        em.flush();

        Attributes attributes39 = new Attributes();
        attributes39.setName("vencimientoGarantia");
        attributes39.setNullable(true);
        attributes39.setSingle(false);
//      ...................... Items ........................
        Entities entity65 = new Entities();
        entity65 = findBean.nameEntities("Items",em);
        attributes39.setEntities(entity65);
//      ...................... Date ........................
        AttributesTypes attributesTypes66 = new AttributesTypes();
        attributesTypes66 = findBean.nameAttributesTypes("Date",em);
        attributes39.setAttributesTypes(attributesTypes66);
        em.persist(attributes39);
        em.flush();

        Attributes attributes40 = new Attributes();
        attributes40.setName("minimo");
        attributes40.setNullable(true);
        attributes40.setSingle(false);
//      ...................... Items ........................
        Entities entity67 = new Entities();
        entity67 = findBean.nameEntities("Items",em);
        attributes40.setEntities(entity67);
//      ...................... Integer ........................
        AttributesTypes attributesTypes68 = new AttributesTypes();
        attributesTypes68 = findBean.nameAttributesTypes("Integer",em);
        attributes40.setAttributesTypes(attributesTypes68);
        em.persist(attributes40);
        em.flush();

        Attributes attributes41 = new Attributes();
        attributes41.setName("maximo");
        attributes41.setNullable(true);
        attributes41.setSingle(false);
//      ...................... Items ........................
        Entities entity69 = new Entities();
        entity69 = findBean.nameEntities("Items",em);
        attributes41.setEntities(entity69);
//      ...................... Integer ........................
        AttributesTypes attributesTypes70 = new AttributesTypes();
        attributesTypes70 = findBean.nameAttributesTypes("Integer",em);
        attributes41.setAttributesTypes(attributesTypes70);
        em.persist(attributes41);
        em.flush();

        Attributes attributes42 = new Attributes();
        attributes42.setName("cantidad");
        attributes42.setNullable(true);
        attributes42.setSingle(false);
//      ...................... Items ........................
        Entities entity71 = new Entities();
        entity71 = findBean.nameEntities("Items",em);
        attributes42.setEntities(entity71);
//      ...................... Integer ........................
        AttributesTypes attributesTypes72 = new AttributesTypes();
        attributesTypes72 = findBean.nameAttributesTypes("Integer",em);
        attributes42.setAttributesTypes(attributesTypes72);
        em.persist(attributes42);
        em.flush();

        Attributes attributes43 = new Attributes();
        attributes43.setName("ubicado");
        attributes43.setNullable(true);
        attributes43.setSingle(false);
//      ...................... Items ........................
        Entities entity73 = new Entities();
        entity73 = findBean.nameEntities("Items",em);
        attributes43.setEntities(entity73);
//      ...................... String ........................
        AttributesTypes attributesTypes74 = new AttributesTypes();
        attributesTypes74 = findBean.nameAttributesTypes("String",em);
        attributes43.setAttributesTypes(attributesTypes74);
        em.persist(attributes43);
        em.flush();

        Entities entities44 = new Entities();
        entities44.setName("TiposItems");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId75 = new GroupIds();
        groupId75 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities44.setGroupIds(groupId75);
        em.persist(entities44);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes45 = new Attributes();
        attributes45.setName("nombre");
        attributes45.setNullable(true);
        attributes45.setSingle(false);
//      ...................... TiposItems ........................
        Entities entity76 = new Entities();
        entity76 = findBean.nameEntities("TiposItems",em);
        attributes45.setEntities(entity76);
//      ...................... String ........................
        AttributesTypes attributesTypes77 = new AttributesTypes();
        attributesTypes77 = findBean.nameAttributesTypes("String",em);
        attributes45.setAttributesTypes(attributesTypes77);
        em.persist(attributes45);
        em.flush();

        Entities entities46 = new Entities();
        entities46.setName("SwitchPorts");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId78 = new GroupIds();
        groupId78 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities46.setGroupIds(groupId78);
        em.persist(entities46);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes47 = new Attributes();
        attributes47.setName("port");
        attributes47.setNullable(true);
        attributes47.setSingle(false);
//      ...................... SwitchPorts ........................
        Entities entity79 = new Entities();
        entity79 = findBean.nameEntities("SwitchPorts",em);
        attributes47.setEntities(entity79);
//      ...................... String ........................
        AttributesTypes attributesTypes80 = new AttributesTypes();
        attributesTypes80 = findBean.nameAttributesTypes("String",em);
        attributes47.setAttributesTypes(attributesTypes80);
        em.persist(attributes47);
        em.flush();

        Attributes attributes48 = new Attributes();
        attributes48.setName("code");
        attributes48.setNullable(true);
        attributes48.setSingle(false);
//      ...................... SwitchPorts ........................
        Entities entity81 = new Entities();
        entity81 = findBean.nameEntities("SwitchPorts",em);
        attributes48.setEntities(entity81);
//      ...................... String ........................
        AttributesTypes attributesTypes82 = new AttributesTypes();
        attributesTypes82 = findBean.nameAttributesTypes("String",em);
        attributes48.setAttributesTypes(attributesTypes82);
        em.persist(attributes48);
        em.flush();

        Attributes attributes49 = new Attributes();
        attributes49.setName("state");
        attributes49.setNullable(true);
        attributes49.setSingle(false);
//      ...................... SwitchPorts ........................
        Entities entity83 = new Entities();
        entity83 = findBean.nameEntities("SwitchPorts",em);
        attributes49.setEntities(entity83);
//      ...................... String ........................
        AttributesTypes attributesTypes84 = new AttributesTypes();
        attributesTypes84 = findBean.nameAttributesTypes("String",em);
        attributes49.setAttributesTypes(attributesTypes84);
        em.persist(attributes49);
        em.flush();

        Entities entities50 = new Entities();
        entities50.setName("TasksTypes");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId85 = new GroupIds();
        groupId85 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities50.setGroupIds(groupId85);
        em.persist(entities50);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes51 = new Attributes();
        attributes51.setName("name");
        attributes51.setNullable(true);
        attributes51.setSingle(false);
//      ...................... TasksTypes ........................
        Entities entity86 = new Entities();
        entity86 = findBean.nameEntities("TasksTypes",em);
        attributes51.setEntities(entity86);
//      ...................... String ........................
        AttributesTypes attributesTypes87 = new AttributesTypes();
        attributesTypes87 = findBean.nameAttributesTypes("String",em);
        attributes51.setAttributesTypes(attributesTypes87);
        em.persist(attributes51);
        em.flush();

        Entities entities52 = new Entities();
        entities52.setName("TiposSecciones");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId88 = new GroupIds();
        groupId88 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities52.setGroupIds(groupId88);
        em.persist(entities52);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes53 = new Attributes();
        attributes53.setName("nombre");
        attributes53.setNullable(true);
        attributes53.setSingle(false);
//      ...................... TiposSecciones ........................
        Entities entity89 = new Entities();
        entity89 = findBean.nameEntities("TiposSecciones",em);
        attributes53.setEntities(entity89);
//      ...................... String ........................
        AttributesTypes attributesTypes90 = new AttributesTypes();
        attributesTypes90 = findBean.nameAttributesTypes("String",em);
        attributes53.setAttributesTypes(attributesTypes90);
        em.persist(attributes53);
        em.flush();

        Entities entities54 = new Entities();
        entities54.setName("TiposDocumentales");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId91 = new GroupIds();
        groupId91 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities54.setGroupIds(groupId91);
        em.persist(entities54);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes55 = new Attributes();
        attributes55.setName("nombre");
        attributes55.setNullable(true);
        attributes55.setSingle(false);
//      ...................... TiposDocumentales ........................
        Entities entity92 = new Entities();
        entity92 = findBean.nameEntities("TiposDocumentales",em);
        attributes55.setEntities(entity92);
//      ...................... String ........................
        AttributesTypes attributesTypes93 = new AttributesTypes();
        attributesTypes93 = findBean.nameAttributesTypes("String",em);
        attributes55.setAttributesTypes(attributesTypes93);
        em.persist(attributes55);
        em.flush();

        Entities entities56 = new Entities();
        entities56.setName("Switchs");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId94 = new GroupIds();
        groupId94 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities56.setGroupIds(groupId94);
        em.persist(entities56);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes57 = new Attributes();
        attributes57.setName("nombre");
        attributes57.setNullable(true);
        attributes57.setSingle(false);
//      ...................... Switchs ........................
        Entities entity95 = new Entities();
        entity95 = findBean.nameEntities("Switchs",em);
        attributes57.setEntities(entity95);
//      ...................... String ........................
        AttributesTypes attributesTypes96 = new AttributesTypes();
        attributesTypes96 = findBean.nameAttributesTypes("String",em);
        attributes57.setAttributesTypes(attributesTypes96);
        em.persist(attributes57);
        em.flush();

        Entities entities58 = new Entities();
        entities58.setName("NamesItems");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId97 = new GroupIds();
        groupId97 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities58.setGroupIds(groupId97);
        em.persist(entities58);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes59 = new Attributes();
        attributes59.setName("nombre");
        attributes59.setNullable(true);
        attributes59.setSingle(false);
//      ...................... NamesItems ........................
        Entities entity98 = new Entities();
        entity98 = findBean.nameEntities("NamesItems",em);
        attributes59.setEntities(entity98);
//      ...................... String ........................
        AttributesTypes attributesTypes99 = new AttributesTypes();
        attributesTypes99 = findBean.nameAttributesTypes("String",em);
        attributes59.setAttributesTypes(attributesTypes99);
        em.persist(attributes59);
        em.flush();

        Attributes attributes60 = new Attributes();
        attributes60.setName("modelo");
        attributes60.setNullable(true);
        attributes60.setSingle(false);
//      ...................... NamesItems ........................
        Entities entity100 = new Entities();
        entity100 = findBean.nameEntities("NamesItems",em);
        attributes60.setEntities(entity100);
//      ...................... String ........................
        AttributesTypes attributesTypes101 = new AttributesTypes();
        attributesTypes101 = findBean.nameAttributesTypes("String",em);
        attributes60.setAttributesTypes(attributesTypes101);
        em.persist(attributes60);
        em.flush();

        Attributes attributes61 = new Attributes();
        attributes61.setName("nroProducto");
        attributes61.setNullable(true);
        attributes61.setSingle(false);
//      ...................... NamesItems ........................
        Entities entity102 = new Entities();
        entity102 = findBean.nameEntities("NamesItems",em);
        attributes61.setEntities(entity102);
//      ...................... String ........................
        AttributesTypes attributesTypes103 = new AttributesTypes();
        attributesTypes103 = findBean.nameAttributesTypes("String",em);
        attributes61.setAttributesTypes(attributesTypes103);
        em.persist(attributes61);
        em.flush();

        Attributes attributes62 = new Attributes();
        attributes62.setName("nroParte");
        attributes62.setNullable(true);
        attributes62.setSingle(false);
//      ...................... NamesItems ........................
        Entities entity104 = new Entities();
        entity104 = findBean.nameEntities("NamesItems",em);
        attributes62.setEntities(entity104);
//      ...................... String ........................
        AttributesTypes attributesTypes105 = new AttributesTypes();
        attributesTypes105 = findBean.nameAttributesTypes("String",em);
        attributes62.setAttributesTypes(attributesTypes105);
        em.persist(attributes62);
        em.flush();

        Attributes attributes63 = new Attributes();
        attributes63.setName("link");
        attributes63.setNullable(true);
        attributes63.setSingle(false);
//      ...................... NamesItems ........................
        Entities entity106 = new Entities();
        entity106 = findBean.nameEntities("NamesItems",em);
        attributes63.setEntities(entity106);
//      ...................... String ........................
        AttributesTypes attributesTypes107 = new AttributesTypes();
        attributesTypes107 = findBean.nameAttributesTypes("String",em);
        attributes63.setAttributesTypes(attributesTypes107);
        em.persist(attributes63);
        em.flush();

        Entities entities64 = new Entities();
        entities64.setName("ItemsFacturas");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId108 = new GroupIds();
        groupId108 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities64.setGroupIds(groupId108);
        em.persist(entities64);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes65 = new Attributes();
        attributes65.setName("cantidad");
        attributes65.setNullable(true);
        attributes65.setSingle(false);
//      ...................... ItemsFacturas ........................
        Entities entity109 = new Entities();
        entity109 = findBean.nameEntities("ItemsFacturas",em);
        attributes65.setEntities(entity109);
//      ...................... Integer ........................
        AttributesTypes attributesTypes110 = new AttributesTypes();
        attributesTypes110 = findBean.nameAttributesTypes("Integer",em);
        attributes65.setAttributesTypes(attributesTypes110);
        em.persist(attributes65);
        em.flush();

        Attributes attributes66 = new Attributes();
        attributes66.setName("valorUnitario");
        attributes66.setNullable(true);
        attributes66.setSingle(false);
//      ...................... ItemsFacturas ........................
        Entities entity111 = new Entities();
        entity111 = findBean.nameEntities("ItemsFacturas",em);
        attributes66.setEntities(entity111);
//      ...................... double ........................
        AttributesTypes attributesTypes112 = new AttributesTypes();
        attributesTypes112 = findBean.nameAttributesTypes("double",em);
        attributes66.setAttributesTypes(attributesTypes112);
        em.persist(attributes66);
        em.flush();

        Entities entities67 = new Entities();
        entities67.setName("Secciones");
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
//      ...................... Secciones ........................
        Entities entity114 = new Entities();
        entity114 = findBean.nameEntities("Secciones",em);
        attributes68.setEntities(entity114);
//      ...................... String ........................
        AttributesTypes attributesTypes115 = new AttributesTypes();
        attributesTypes115 = findBean.nameAttributesTypes("String",em);
        attributes68.setAttributesTypes(attributesTypes115);
        em.persist(attributes68);
        em.flush();

        Attributes attributes69 = new Attributes();
        attributes69.setName("codigo");
        attributes69.setNullable(true);
        attributes69.setSingle(false);
//      ...................... Secciones ........................
        Entities entity116 = new Entities();
        entity116 = findBean.nameEntities("Secciones",em);
        attributes69.setEntities(entity116);
//      ...................... String ........................
        AttributesTypes attributesTypes117 = new AttributesTypes();
        attributesTypes117 = findBean.nameAttributesTypes("String",em);
        attributes69.setAttributesTypes(attributesTypes117);
        em.persist(attributes69);
        em.flush();

        Attributes attributes70 = new Attributes();
        attributes70.setName("email");
        attributes70.setNullable(true);
        attributes70.setSingle(false);
//      ...................... Secciones ........................
        Entities entity118 = new Entities();
        entity118 = findBean.nameEntities("Secciones",em);
        attributes70.setEntities(entity118);
//      ...................... String ........................
        AttributesTypes attributesTypes119 = new AttributesTypes();
        attributesTypes119 = findBean.nameAttributesTypes("String",em);
        attributes70.setAttributesTypes(attributesTypes119);
        em.persist(attributes70);
        em.flush();

        Entities entities71 = new Entities();
        entities71.setName("Sites");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId120 = new GroupIds();
        groupId120 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities71.setGroupIds(groupId120);
        em.persist(entities71);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes72 = new Attributes();
        attributes72.setName("title");
        attributes72.setNullable(true);
        attributes72.setSingle(false);
//      ...................... Sites ........................
        Entities entity121 = new Entities();
        entity121 = findBean.nameEntities("Sites",em);
        attributes72.setEntities(entity121);
//      ...................... String ........................
        AttributesTypes attributesTypes122 = new AttributesTypes();
        attributesTypes122 = findBean.nameAttributesTypes("String",em);
        attributes72.setAttributesTypes(attributesTypes122);
        em.persist(attributes72);
        em.flush();

        Attributes attributes73 = new Attributes();
        attributes73.setName("link");
        attributes73.setNullable(false);
        attributes73.setSingle(true);
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

        Entities entities74 = new Entities();
        entities74.setName("EstadosItems");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId125 = new GroupIds();
        groupId125 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities74.setGroupIds(groupId125);
        em.persist(entities74);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes75 = new Attributes();
        attributes75.setName("nombre");
        attributes75.setNullable(true);
        attributes75.setSingle(false);
//      ...................... EstadosItems ........................
        Entities entity126 = new Entities();
        entity126 = findBean.nameEntities("EstadosItems",em);
        attributes75.setEntities(entity126);
//      ...................... String ........................
        AttributesTypes attributesTypes127 = new AttributesTypes();
        attributesTypes127 = findBean.nameAttributesTypes("String",em);
        attributes75.setAttributesTypes(attributesTypes127);
        em.persist(attributes75);
        em.flush();

        Entities entities76 = new Entities();
        entities76.setName("TipoPersonal");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId128 = new GroupIds();
        groupId128 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities76.setGroupIds(groupId128);
        em.persist(entities76);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes77 = new Attributes();
        attributes77.setName("nombre");
        attributes77.setNullable(true);
        attributes77.setSingle(false);
//      ...................... TipoPersonal ........................
        Entities entity129 = new Entities();
        entity129 = findBean.nameEntities("TipoPersonal",em);
        attributes77.setEntities(entity129);
//      ...................... String ........................
        AttributesTypes attributesTypes130 = new AttributesTypes();
        attributesTypes130 = findBean.nameAttributesTypes("String",em);
        attributes77.setAttributesTypes(attributesTypes130);
        em.persist(attributes77);
        em.flush();

        Entities entities78 = new Entities();
        entities78.setName("Tasks");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId131 = new GroupIds();
        groupId131 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities78.setGroupIds(groupId131);
        em.persist(entities78);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes79 = new Attributes();
        attributes79.setName("name");
        attributes79.setNullable(true);
        attributes79.setSingle(false);
//      ...................... Tasks ........................
        Entities entity132 = new Entities();
        entity132 = findBean.nameEntities("Tasks",em);
        attributes79.setEntities(entity132);
//      ...................... String ........................
        AttributesTypes attributesTypes133 = new AttributesTypes();
        attributesTypes133 = findBean.nameAttributesTypes("String",em);
        attributes79.setAttributesTypes(attributesTypes133);
        em.persist(attributes79);
        em.flush();

        Attributes attributes80 = new Attributes();
        attributes80.setName("date");
        attributes80.setNullable(true);
        attributes80.setSingle(false);
//      ...................... Tasks ........................
        Entities entity134 = new Entities();
        entity134 = findBean.nameEntities("Tasks",em);
        attributes80.setEntities(entity134);
//      ...................... Date ........................
        AttributesTypes attributesTypes135 = new AttributesTypes();
        attributesTypes135 = findBean.nameAttributesTypes("Date",em);
        attributes80.setAttributesTypes(attributesTypes135);
        em.persist(attributes80);
        em.flush();

        Attributes attributes81 = new Attributes();
        attributes81.setName("priority");
        attributes81.setNullable(true);
        attributes81.setSingle(false);
//      ...................... Tasks ........................
        Entities entity136 = new Entities();
        entity136 = findBean.nameEntities("Tasks",em);
        attributes81.setEntities(entity136);
//      ...................... Integer ........................
        AttributesTypes attributesTypes137 = new AttributesTypes();
        attributesTypes137 = findBean.nameAttributesTypes("Integer",em);
        attributes81.setAttributesTypes(attributesTypes137);
        em.persist(attributes81);
        em.flush();

        Attributes attributes82 = new Attributes();
        attributes82.setName("detail");
        attributes82.setNullable(true);
        attributes82.setSingle(false);
//      ...................... Tasks ........................
        Entities entity138 = new Entities();
        entity138 = findBean.nameEntities("Tasks",em);
        attributes82.setEntities(entity138);
//      ...................... String ........................
        AttributesTypes attributesTypes139 = new AttributesTypes();
        attributesTypes139 = findBean.nameAttributesTypes("String",em);
        attributes82.setAttributesTypes(attributesTypes139);
        em.persist(attributes82);
        em.flush();

        Attributes attributes83 = new Attributes();
        attributes83.setName("isOpend");
        attributes83.setNullable(true);
        attributes83.setSingle(false);
//      ...................... Tasks ........................
        Entities entity140 = new Entities();
        entity140 = findBean.nameEntities("Tasks",em);
        attributes83.setEntities(entity140);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes141 = new AttributesTypes();
        attributesTypes141 = findBean.nameAttributesTypes("Boolean",em);
        attributes83.setAttributesTypes(attributesTypes141);
        em.persist(attributes83);
        em.flush();

        Entities entities84 = new Entities();
        entities84.setName("Calendars");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId142 = new GroupIds();
        groupId142 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities84.setGroupIds(groupId142);
        em.persist(entities84);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes85 = new Attributes();
        attributes85.setName("name");
        attributes85.setNullable(true);
        attributes85.setSingle(false);
//      ...................... Calendars ........................
        Entities entity143 = new Entities();
        entity143 = findBean.nameEntities("Calendars",em);
        attributes85.setEntities(entity143);
//      ...................... String ........................
        AttributesTypes attributesTypes144 = new AttributesTypes();
        attributesTypes144 = findBean.nameAttributesTypes("String",em);
        attributes85.setAttributesTypes(attributesTypes144);
        em.persist(attributes85);
        em.flush();

        Attributes attributes86 = new Attributes();
        attributes86.setName("date");
        attributes86.setNullable(true);
        attributes86.setSingle(false);
//      ...................... Calendars ........................
        Entities entity145 = new Entities();
        entity145 = findBean.nameEntities("Calendars",em);
        attributes86.setEntities(entity145);
//      ...................... Date ........................
        AttributesTypes attributesTypes146 = new AttributesTypes();
        attributesTypes146 = findBean.nameAttributesTypes("Date",em);
        attributes86.setAttributesTypes(attributesTypes146);
        em.persist(attributes86);
        em.flush();

        Entities entities87 = new Entities();
        entities87.setName("Personas");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId147 = new GroupIds();
        groupId147 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities87.setGroupIds(groupId147);
        em.persist(entities87);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes88 = new Attributes();
        attributes88.setName("primerApellido");
        attributes88.setNullable(true);
        attributes88.setSingle(false);
//      ...................... Personas ........................
        Entities entity148 = new Entities();
        entity148 = findBean.nameEntities("Personas",em);
        attributes88.setEntities(entity148);
//      ...................... String ........................
        AttributesTypes attributesTypes149 = new AttributesTypes();
        attributesTypes149 = findBean.nameAttributesTypes("String",em);
        attributes88.setAttributesTypes(attributesTypes149);
        em.persist(attributes88);
        em.flush();

        Attributes attributes89 = new Attributes();
        attributes89.setName("segundoApellido");
        attributes89.setNullable(true);
        attributes89.setSingle(false);
//      ...................... Personas ........................
        Entities entity150 = new Entities();
        entity150 = findBean.nameEntities("Personas",em);
        attributes89.setEntities(entity150);
//      ...................... String ........................
        AttributesTypes attributesTypes151 = new AttributesTypes();
        attributesTypes151 = findBean.nameAttributesTypes("String",em);
        attributes89.setAttributesTypes(attributesTypes151);
        em.persist(attributes89);
        em.flush();

        Attributes attributes90 = new Attributes();
        attributes90.setName("primerNombre");
        attributes90.setNullable(true);
        attributes90.setSingle(false);
//      ...................... Personas ........................
        Entities entity152 = new Entities();
        entity152 = findBean.nameEntities("Personas",em);
        attributes90.setEntities(entity152);
//      ...................... String ........................
        AttributesTypes attributesTypes153 = new AttributesTypes();
        attributesTypes153 = findBean.nameAttributesTypes("String",em);
        attributes90.setAttributesTypes(attributesTypes153);
        em.persist(attributes90);
        em.flush();

        Attributes attributes91 = new Attributes();
        attributes91.setName("segundoNombre");
        attributes91.setNullable(true);
        attributes91.setSingle(false);
//      ...................... Personas ........................
        Entities entity154 = new Entities();
        entity154 = findBean.nameEntities("Personas",em);
        attributes91.setEntities(entity154);
//      ...................... String ........................
        AttributesTypes attributesTypes155 = new AttributesTypes();
        attributesTypes155 = findBean.nameAttributesTypes("String",em);
        attributes91.setAttributesTypes(attributesTypes155);
        em.persist(attributes91);
        em.flush();

        Attributes attributes92 = new Attributes();
        attributes92.setName("direccion");
        attributes92.setNullable(true);
        attributes92.setSingle(false);
//      ...................... Personas ........................
        Entities entity156 = new Entities();
        entity156 = findBean.nameEntities("Personas",em);
        attributes92.setEntities(entity156);
//      ...................... String ........................
        AttributesTypes attributesTypes157 = new AttributesTypes();
        attributesTypes157 = findBean.nameAttributesTypes("String",em);
        attributes92.setAttributesTypes(attributesTypes157);
        em.persist(attributes92);
        em.flush();

        Attributes attributes93 = new Attributes();
        attributes93.setName("telefonos");
        attributes93.setNullable(true);
        attributes93.setSingle(false);
//      ...................... Personas ........................
        Entities entity158 = new Entities();
        entity158 = findBean.nameEntities("Personas",em);
        attributes93.setEntities(entity158);
//      ...................... String ........................
        AttributesTypes attributesTypes159 = new AttributesTypes();
        attributesTypes159 = findBean.nameAttributesTypes("String",em);
        attributes93.setAttributesTypes(attributesTypes159);
        em.persist(attributes93);
        em.flush();

        Attributes attributes94 = new Attributes();
        attributes94.setName("email");
        attributes94.setNullable(true);
        attributes94.setSingle(false);
//      ...................... Personas ........................
        Entities entity160 = new Entities();
        entity160 = findBean.nameEntities("Personas",em);
        attributes94.setEntities(entity160);
//      ...................... String ........................
        AttributesTypes attributesTypes161 = new AttributesTypes();
        attributesTypes161 = findBean.nameAttributesTypes("String",em);
        attributes94.setAttributesTypes(attributesTypes161);
        em.persist(attributes94);
        em.flush();

        Entities entities95 = new Entities();
        entities95.setName("Inventarios");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId162 = new GroupIds();
        groupId162 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities95.setGroupIds(groupId162);
        em.persist(entities95);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes96 = new Attributes();
        attributes96.setName("nombre");
        attributes96.setNullable(true);
        attributes96.setSingle(false);
//      ...................... Inventarios ........................
        Entities entity163 = new Entities();
        entity163 = findBean.nameEntities("Inventarios",em);
        attributes96.setEntities(entity163);
//      ...................... String ........................
        AttributesTypes attributesTypes164 = new AttributesTypes();
        attributesTypes164 = findBean.nameAttributesTypes("String",em);
        attributes96.setAttributesTypes(attributesTypes164);
        em.persist(attributes96);
        em.flush();

        Entities entities97 = new Entities();
        entities97.setName("IpAddresses");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId165 = new GroupIds();
        groupId165 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities97.setGroupIds(groupId165);
        em.persist(entities97);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes98 = new Attributes();
        attributes98.setName("ip");
        attributes98.setNullable(true);
        attributes98.setSingle(false);
//      ...................... IpAddresses ........................
        Entities entity166 = new Entities();
        entity166 = findBean.nameEntities("IpAddresses",em);
        attributes98.setEntities(entity166);
//      ...................... String ........................
        AttributesTypes attributesTypes167 = new AttributesTypes();
        attributesTypes167 = findBean.nameAttributesTypes("String",em);
        attributes98.setAttributesTypes(attributesTypes167);
        em.persist(attributes98);
        em.flush();

        Attributes attributes99 = new Attributes();
        attributes99.setName("link");
        attributes99.setNullable(true);
        attributes99.setSingle(false);
//      ...................... IpAddresses ........................
        Entities entity168 = new Entities();
        entity168 = findBean.nameEntities("IpAddresses",em);
        attributes99.setEntities(entity168);
//      ...................... String ........................
        AttributesTypes attributesTypes169 = new AttributesTypes();
        attributesTypes169 = findBean.nameAttributesTypes("String",em);
        attributes99.setAttributesTypes(attributesTypes169);
        em.persist(attributes99);
        em.flush();

        Attributes attributes100 = new Attributes();
        attributes100.setName("isSecure");
        attributes100.setNullable(true);
        attributes100.setSingle(false);
//      ...................... IpAddresses ........................
        Entities entity170 = new Entities();
        entity170 = findBean.nameEntities("IpAddresses",em);
        attributes100.setEntities(entity170);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes171 = new AttributesTypes();
        attributesTypes171 = findBean.nameAttributesTypes("Boolean",em);
        attributes100.setAttributesTypes(attributesTypes171);
        em.persist(attributes100);
        em.flush();

        Entities entities101 = new Entities();
        entities101.setName("SitesTypes");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId172 = new GroupIds();
        groupId172 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities101.setGroupIds(groupId172);
        em.persist(entities101);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes102 = new Attributes();
        attributes102.setName("name");
        attributes102.setNullable(true);
        attributes102.setSingle(false);
//      ...................... SitesTypes ........................
        Entities entity173 = new Entities();
        entity173 = findBean.nameEntities("SitesTypes",em);
        attributes102.setEntities(entity173);
//      ...................... String ........................
        AttributesTypes attributesTypes174 = new AttributesTypes();
        attributesTypes174 = findBean.nameAttributesTypes("String",em);
        attributes102.setAttributesTypes(attributesTypes174);
        em.persist(attributes102);
        em.flush();

        Entities entities103 = new Entities();
        entities103.setName("Macs");
//      ...................... co.simasoft.models.naif.crm ........................
        GroupIds groupId175 = new GroupIds();
        groupId175 = findBean.groupIdGroupIds("co.simasoft.models.naif.crm",em);
        entities103.setGroupIds(groupId175);
        em.persist(entities103);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes104 = new Attributes();
        attributes104.setName("ip");
        attributes104.setNullable(true);
        attributes104.setSingle(false);
//      ...................... Macs ........................
        Entities entity176 = new Entities();
        entity176 = findBean.nameEntities("Macs",em);
        attributes104.setEntities(entity176);
//      ...................... String ........................
        AttributesTypes attributesTypes177 = new AttributesTypes();
        attributesTypes177 = findBean.nameAttributesTypes("String",em);
        attributes104.setAttributesTypes(attributesTypes177);
        em.persist(attributes104);
        em.flush();

        Attributes attributes105 = new Attributes();
        attributes105.setName("mac");
        attributes105.setNullable(true);
        attributes105.setSingle(false);
//      ...................... Macs ........................
        Entities entity178 = new Entities();
        entity178 = findBean.nameEntities("Macs",em);
        attributes105.setEntities(entity178);
//      ...................... String ........................
        AttributesTypes attributesTypes179 = new AttributesTypes();
        attributesTypes179 = findBean.nameAttributesTypes("String",em);
        attributes105.setAttributesTypes(attributesTypes179);
        em.persist(attributes105);
        em.flush();

        Attributes attributes106 = new Attributes();
        attributes106.setName("state");
        attributes106.setNullable(true);
        attributes106.setSingle(false);
//      ...................... Macs ........................
        Entities entity180 = new Entities();
        entity180 = findBean.nameEntities("Macs",em);
        attributes106.setEntities(entity180);
//      ...................... String ........................
        AttributesTypes attributesTypes181 = new AttributesTypes();
        attributesTypes181 = findBean.nameAttributesTypes("String",em);
        attributes106.setAttributesTypes(attributesTypes181);
        em.persist(attributes106);
        em.flush();

//      ---------------------- Relationships ------------------------

/*
. Calendars . *..* Activities rolA: rolB:from OK

. AreasFisicas . 1..* AreasFisicas rolA: rolB:

. Facturas . 1..* ItemsFacturas rolA: rolB:

. Personas . *..* Sites rolA: rolB:from OK

. Items . 1..* Switchs rolA: rolB:

. Marcas . 1..* NamesItems rolA: rolB:

. Sites . 1..* IpAddresses rolA: rolB:

. Personas . 1..* Secciones rolA: rolB:

. SitesTypes . 1..* SitesTypes rolA: rolB:

. Switchs . 1..* SwitchPorts rolA: rolB:

. TiposSecciones . 1..* Secciones rolA: rolB:

. Activities . *..* Tasks rolA:from rolB: OK

. Secciones . 1..* Items rolA: rolB:

. Items . 1..* ItemsFacturas rolA: rolB:

. NamesItems . 1..* Items rolA: rolB:

. Activities . *..* Sites rolA: rolB:from OK

. TiposItems . 1..* Items rolA: rolB:

. TiposDocumentales . 1..* Series rolA: rolB:

. Secciones . *..* Activities rolA: rolB:from OK

. EstadosItems . 1..* Items rolA: rolB:

. Items . 1..* Macs rolA: rolB:

. Items . 1..* Items rolA: rolB:

. Empresas . 1..* Facturas rolA: rolB:

. Macs . 1..1 SwitchPorts rolA:from rolB: OK

. TiposInventarios . 1..* Inventarios rolA: rolB:

. Series . 1..* Sites rolA: rolB:

. TipoPersonal . 1..* Personas rolA: rolB:

. Personas . *..* Activities rolA:from rolB: OK

. Empresas . 1..* Personas rolA: rolB:

. Vlan . 1..* Macs rolA: rolB:

. Secciones . *..* Series rolA:from rolB: OK

. TiposAreasFisicas . 1..* AreasFisicas rolA: rolB:

. Tasks . *..* Sites rolA:from rolB: OK

. ActivitiesTypes . *..* Activities rolA: rolB:from OK

. Secciones . 1..* Secciones rolA: rolB:

. Inventarios . 1..* Items rolA: rolB:

. AreasFisicas . 1..* Items rolA: rolB:

. Empresas . *..* Sites rolA: rolB:from OK

. Series . 1..* Series rolA: rolB:

. Secciones . *..* Tasks rolA:from rolB: OK

. TasksTypes . 1..* Tasks rolA: rolB:

. SitesTypes . *..* Sites rolA: rolB:from OK

. Marcas . *..* Empresas rolA:from rolB: OK

*/
        Relationships relationships1 = new Relationships();
        relationships1.setOptionality(true);
        relationships1.setIsEmbedded(false);
//      ...................... Calendars ........................
        Entities entities182 = new Entities();
        entities182 = findBean.nameEntities("Calendars",em);
        relationships1.setFrom(entities182);
//      ...................... Activities ........................
        Entities entities183 = new Entities();
        entities183 = findBean.nameEntities("Activities",em);
        relationships1.setTo(entities183);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities184 = new Cardinalities();
        cardinalities184 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships1.setCardinalities(cardinalities184);
        em.persist(relationships1);
        em.flush();

        Relationships relationships2 = new Relationships();
        relationships2.setOptionality(true);
        relationships2.setIsEmbedded(false);
//      ...................... AreasFisicas ........................
        Entities entities185 = new Entities();
        entities185 = findBean.nameEntities("AreasFisicas",em);
        relationships2.setFrom(entities185);
//      ...................... AreasFisicas ........................
        Entities entities186 = new Entities();
        entities186 = findBean.nameEntities("AreasFisicas",em);
        relationships2.setTo(entities186);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities187 = new Cardinalities();
        cardinalities187 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships2.setCardinalities(cardinalities187);
        em.persist(relationships2);
        em.flush();

        Relationships relationships3 = new Relationships();
        relationships3.setOptionality(true);
        relationships3.setIsEmbedded(false);
//      ...................... Facturas ........................
        Entities entities188 = new Entities();
        entities188 = findBean.nameEntities("Facturas",em);
        relationships3.setFrom(entities188);
//      ...................... ItemsFacturas ........................
        Entities entities189 = new Entities();
        entities189 = findBean.nameEntities("ItemsFacturas",em);
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
//      ...................... Personas ........................
        Entities entities191 = new Entities();
        entities191 = findBean.nameEntities("Personas",em);
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
//      ...................... Items ........................
        Entities entities194 = new Entities();
        entities194 = findBean.nameEntities("Items",em);
        relationships5.setFrom(entities194);
//      ...................... Switchs ........................
        Entities entities195 = new Entities();
        entities195 = findBean.nameEntities("Switchs",em);
        relationships5.setTo(entities195);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities196 = new Cardinalities();
        cardinalities196 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships5.setCardinalities(cardinalities196);
        em.persist(relationships5);
        em.flush();

        Relationships relationships6 = new Relationships();
        relationships6.setOptionality(true);
        relationships6.setIsEmbedded(false);
//      ...................... Marcas ........................
        Entities entities197 = new Entities();
        entities197 = findBean.nameEntities("Marcas",em);
        relationships6.setFrom(entities197);
//      ...................... NamesItems ........................
        Entities entities198 = new Entities();
        entities198 = findBean.nameEntities("NamesItems",em);
        relationships6.setTo(entities198);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities199 = new Cardinalities();
        cardinalities199 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships6.setCardinalities(cardinalities199);
        em.persist(relationships6);
        em.flush();

        Relationships relationships7 = new Relationships();
        relationships7.setOptionality(true);
        relationships7.setIsEmbedded(false);
//      ...................... Sites ........................
        Entities entities200 = new Entities();
        entities200 = findBean.nameEntities("Sites",em);
        relationships7.setFrom(entities200);
//      ...................... IpAddresses ........................
        Entities entities201 = new Entities();
        entities201 = findBean.nameEntities("IpAddresses",em);
        relationships7.setTo(entities201);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities202 = new Cardinalities();
        cardinalities202 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships7.setCardinalities(cardinalities202);
        em.persist(relationships7);
        em.flush();

        Relationships relationships8 = new Relationships();
        relationships8.setOptionality(true);
        relationships8.setIsEmbedded(false);
//      ...................... Personas ........................
        Entities entities203 = new Entities();
        entities203 = findBean.nameEntities("Personas",em);
        relationships8.setFrom(entities203);
//      ...................... Secciones ........................
        Entities entities204 = new Entities();
        entities204 = findBean.nameEntities("Secciones",em);
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
//      ...................... SitesTypes ........................
        Entities entities206 = new Entities();
        entities206 = findBean.nameEntities("SitesTypes",em);
        relationships9.setFrom(entities206);
//      ...................... SitesTypes ........................
        Entities entities207 = new Entities();
        entities207 = findBean.nameEntities("SitesTypes",em);
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
//      ...................... Switchs ........................
        Entities entities209 = new Entities();
        entities209 = findBean.nameEntities("Switchs",em);
        relationships10.setFrom(entities209);
//      ...................... SwitchPorts ........................
        Entities entities210 = new Entities();
        entities210 = findBean.nameEntities("SwitchPorts",em);
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
//      ...................... TiposSecciones ........................
        Entities entities212 = new Entities();
        entities212 = findBean.nameEntities("TiposSecciones",em);
        relationships11.setFrom(entities212);
//      ...................... Secciones ........................
        Entities entities213 = new Entities();
        entities213 = findBean.nameEntities("Secciones",em);
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
//      ...................... Secciones ........................
        Entities entities218 = new Entities();
        entities218 = findBean.nameEntities("Secciones",em);
        relationships13.setFrom(entities218);
//      ...................... Items ........................
        Entities entities219 = new Entities();
        entities219 = findBean.nameEntities("Items",em);
        relationships13.setTo(entities219);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities220 = new Cardinalities();
        cardinalities220 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships13.setCardinalities(cardinalities220);
        em.persist(relationships13);
        em.flush();

        Relationships relationships14 = new Relationships();
        relationships14.setOptionality(true);
        relationships14.setIsEmbedded(false);
//      ...................... Items ........................
        Entities entities221 = new Entities();
        entities221 = findBean.nameEntities("Items",em);
        relationships14.setFrom(entities221);
//      ...................... ItemsFacturas ........................
        Entities entities222 = new Entities();
        entities222 = findBean.nameEntities("ItemsFacturas",em);
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
//      ...................... NamesItems ........................
        Entities entities224 = new Entities();
        entities224 = findBean.nameEntities("NamesItems",em);
        relationships15.setFrom(entities224);
//      ...................... Items ........................
        Entities entities225 = new Entities();
        entities225 = findBean.nameEntities("Items",em);
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
//      ...................... Activities ........................
        Entities entities227 = new Entities();
        entities227 = findBean.nameEntities("Activities",em);
        relationships16.setFrom(entities227);
//      ...................... Sites ........................
        Entities entities228 = new Entities();
        entities228 = findBean.nameEntities("Sites",em);
        relationships16.setTo(entities228);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities229 = new Cardinalities();
        cardinalities229 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships16.setCardinalities(cardinalities229);
        em.persist(relationships16);
        em.flush();

        Relationships relationships17 = new Relationships();
        relationships17.setOptionality(true);
        relationships17.setIsEmbedded(false);
//      ...................... TiposItems ........................
        Entities entities230 = new Entities();
        entities230 = findBean.nameEntities("TiposItems",em);
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
//      ...................... TiposDocumentales ........................
        Entities entities233 = new Entities();
        entities233 = findBean.nameEntities("TiposDocumentales",em);
        relationships18.setFrom(entities233);
//      ...................... Series ........................
        Entities entities234 = new Entities();
        entities234 = findBean.nameEntities("Series",em);
        relationships18.setTo(entities234);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities235 = new Cardinalities();
        cardinalities235 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships18.setCardinalities(cardinalities235);
        em.persist(relationships18);
        em.flush();

        Relationships relationships19 = new Relationships();
        relationships19.setOptionality(true);
        relationships19.setIsEmbedded(false);
//      ...................... Secciones ........................
        Entities entities236 = new Entities();
        entities236 = findBean.nameEntities("Secciones",em);
        relationships19.setFrom(entities236);
//      ...................... Activities ........................
        Entities entities237 = new Entities();
        entities237 = findBean.nameEntities("Activities",em);
        relationships19.setTo(entities237);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities238 = new Cardinalities();
        cardinalities238 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships19.setCardinalities(cardinalities238);
        em.persist(relationships19);
        em.flush();

        Relationships relationships20 = new Relationships();
        relationships20.setOptionality(true);
        relationships20.setIsEmbedded(false);
//      ...................... EstadosItems ........................
        Entities entities239 = new Entities();
        entities239 = findBean.nameEntities("EstadosItems",em);
        relationships20.setFrom(entities239);
//      ...................... Items ........................
        Entities entities240 = new Entities();
        entities240 = findBean.nameEntities("Items",em);
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
//      ...................... Items ........................
        Entities entities242 = new Entities();
        entities242 = findBean.nameEntities("Items",em);
        relationships21.setFrom(entities242);
//      ...................... Macs ........................
        Entities entities243 = new Entities();
        entities243 = findBean.nameEntities("Macs",em);
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
//      ...................... Items ........................
        Entities entities246 = new Entities();
        entities246 = findBean.nameEntities("Items",em);
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
//      ...................... Empresas ........................
        Entities entities248 = new Entities();
        entities248 = findBean.nameEntities("Empresas",em);
        relationships23.setFrom(entities248);
//      ...................... Facturas ........................
        Entities entities249 = new Entities();
        entities249 = findBean.nameEntities("Facturas",em);
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
//      ...................... Macs ........................
        Entities entities251 = new Entities();
        entities251 = findBean.nameEntities("Macs",em);
        relationships24.setFrom(entities251);
//      ...................... SwitchPorts ........................
        Entities entities252 = new Entities();
        entities252 = findBean.nameEntities("SwitchPorts",em);
        relationships24.setTo(entities252);
//      ...................... Uno a Uno Bidirecccional No.2 ........................
        Cardinalities cardinalities253 = new Cardinalities();
        cardinalities253 = findBean.nameCardinalities("Uno a Uno Bidirecccional No.2",em);
        relationships24.setCardinalities(cardinalities253);
        em.persist(relationships24);
        em.flush();

        Relationships relationships25 = new Relationships();
        relationships25.setOptionality(true);
        relationships25.setIsEmbedded(false);
//      ...................... TiposInventarios ........................
        Entities entities254 = new Entities();
        entities254 = findBean.nameEntities("TiposInventarios",em);
        relationships25.setFrom(entities254);
//      ...................... Inventarios ........................
        Entities entities255 = new Entities();
        entities255 = findBean.nameEntities("Inventarios",em);
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
//      ...................... Series ........................
        Entities entities257 = new Entities();
        entities257 = findBean.nameEntities("Series",em);
        relationships26.setFrom(entities257);
//      ...................... Sites ........................
        Entities entities258 = new Entities();
        entities258 = findBean.nameEntities("Sites",em);
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
//      ...................... TipoPersonal ........................
        Entities entities260 = new Entities();
        entities260 = findBean.nameEntities("TipoPersonal",em);
        relationships27.setFrom(entities260);
//      ...................... Personas ........................
        Entities entities261 = new Entities();
        entities261 = findBean.nameEntities("Personas",em);
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
//      ...................... Personas ........................
        Entities entities263 = new Entities();
        entities263 = findBean.nameEntities("Personas",em);
        relationships28.setFrom(entities263);
//      ...................... Activities ........................
        Entities entities264 = new Entities();
        entities264 = findBean.nameEntities("Activities",em);
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
//      ...................... Empresas ........................
        Entities entities266 = new Entities();
        entities266 = findBean.nameEntities("Empresas",em);
        relationships29.setFrom(entities266);
//      ...................... Personas ........................
        Entities entities267 = new Entities();
        entities267 = findBean.nameEntities("Personas",em);
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
//      ...................... Vlan ........................
        Entities entities269 = new Entities();
        entities269 = findBean.nameEntities("Vlan",em);
        relationships30.setFrom(entities269);
//      ...................... Macs ........................
        Entities entities270 = new Entities();
        entities270 = findBean.nameEntities("Macs",em);
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
//      ...................... Secciones ........................
        Entities entities272 = new Entities();
        entities272 = findBean.nameEntities("Secciones",em);
        relationships31.setFrom(entities272);
//      ...................... Series ........................
        Entities entities273 = new Entities();
        entities273 = findBean.nameEntities("Series",em);
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
//      ...................... TiposAreasFisicas ........................
        Entities entities275 = new Entities();
        entities275 = findBean.nameEntities("TiposAreasFisicas",em);
        relationships32.setFrom(entities275);
//      ...................... AreasFisicas ........................
        Entities entities276 = new Entities();
        entities276 = findBean.nameEntities("AreasFisicas",em);
        relationships32.setTo(entities276);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities277 = new Cardinalities();
        cardinalities277 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships32.setCardinalities(cardinalities277);
        em.persist(relationships32);
        em.flush();

        Relationships relationships33 = new Relationships();
        relationships33.setOptionality(true);
        relationships33.setIsEmbedded(false);
//      ...................... Tasks ........................
        Entities entities278 = new Entities();
        entities278 = findBean.nameEntities("Tasks",em);
        relationships33.setFrom(entities278);
//      ...................... Sites ........................
        Entities entities279 = new Entities();
        entities279 = findBean.nameEntities("Sites",em);
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
//      ...................... ActivitiesTypes ........................
        Entities entities281 = new Entities();
        entities281 = findBean.nameEntities("ActivitiesTypes",em);
        relationships34.setFrom(entities281);
//      ...................... Activities ........................
        Entities entities282 = new Entities();
        entities282 = findBean.nameEntities("Activities",em);
        relationships34.setTo(entities282);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities283 = new Cardinalities();
        cardinalities283 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships34.setCardinalities(cardinalities283);
        em.persist(relationships34);
        em.flush();

        Relationships relationships35 = new Relationships();
        relationships35.setOptionality(true);
        relationships35.setIsEmbedded(false);
//      ...................... Secciones ........................
        Entities entities284 = new Entities();
        entities284 = findBean.nameEntities("Secciones",em);
        relationships35.setFrom(entities284);
//      ...................... Secciones ........................
        Entities entities285 = new Entities();
        entities285 = findBean.nameEntities("Secciones",em);
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
//      ...................... Inventarios ........................
        Entities entities287 = new Entities();
        entities287 = findBean.nameEntities("Inventarios",em);
        relationships36.setFrom(entities287);
//      ...................... Items ........................
        Entities entities288 = new Entities();
        entities288 = findBean.nameEntities("Items",em);
        relationships36.setTo(entities288);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities289 = new Cardinalities();
        cardinalities289 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships36.setCardinalities(cardinalities289);
        em.persist(relationships36);
        em.flush();

        Relationships relationships37 = new Relationships();
        relationships37.setOptionality(true);
        relationships37.setIsEmbedded(false);
//      ...................... AreasFisicas ........................
        Entities entities290 = new Entities();
        entities290 = findBean.nameEntities("AreasFisicas",em);
        relationships37.setFrom(entities290);
//      ...................... Items ........................
        Entities entities291 = new Entities();
        entities291 = findBean.nameEntities("Items",em);
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
//      ...................... Empresas ........................
        Entities entities293 = new Entities();
        entities293 = findBean.nameEntities("Empresas",em);
        relationships38.setFrom(entities293);
//      ...................... Sites ........................
        Entities entities294 = new Entities();
        entities294 = findBean.nameEntities("Sites",em);
        relationships38.setTo(entities294);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities295 = new Cardinalities();
        cardinalities295 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships38.setCardinalities(cardinalities295);
        em.persist(relationships38);
        em.flush();

        Relationships relationships39 = new Relationships();
        relationships39.setOptionality(true);
        relationships39.setIsEmbedded(false);
//      ...................... Series ........................
        Entities entities296 = new Entities();
        entities296 = findBean.nameEntities("Series",em);
        relationships39.setFrom(entities296);
//      ...................... Series ........................
        Entities entities297 = new Entities();
        entities297 = findBean.nameEntities("Series",em);
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
//      ...................... Secciones ........................
        Entities entities299 = new Entities();
        entities299 = findBean.nameEntities("Secciones",em);
        relationships40.setFrom(entities299);
//      ...................... Tasks ........................
        Entities entities300 = new Entities();
        entities300 = findBean.nameEntities("Tasks",em);
        relationships40.setTo(entities300);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities301 = new Cardinalities();
        cardinalities301 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships40.setCardinalities(cardinalities301);
        em.persist(relationships40);
        em.flush();

        Relationships relationships41 = new Relationships();
        relationships41.setOptionality(true);
        relationships41.setIsEmbedded(false);
//      ...................... TasksTypes ........................
        Entities entities302 = new Entities();
        entities302 = findBean.nameEntities("TasksTypes",em);
        relationships41.setFrom(entities302);
//      ...................... Tasks ........................
        Entities entities303 = new Entities();
        entities303 = findBean.nameEntities("Tasks",em);
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
//      ...................... SitesTypes ........................
        Entities entities305 = new Entities();
        entities305 = findBean.nameEntities("SitesTypes",em);
        relationships42.setFrom(entities305);
//      ...................... Sites ........................
        Entities entities306 = new Entities();
        entities306 = findBean.nameEntities("Sites",em);
        relationships42.setTo(entities306);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities307 = new Cardinalities();
        cardinalities307 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships42.setCardinalities(cardinalities307);
        em.persist(relationships42);
        em.flush();

        Relationships relationships43 = new Relationships();
        relationships43.setOptionality(true);
        relationships43.setIsEmbedded(false);
//      ...................... Marcas ........................
        Entities entities308 = new Entities();
        entities308 = findBean.nameEntities("Marcas",em);
        relationships43.setFrom(entities308);
//      ...................... Empresas ........................
        Entities entities309 = new Entities();
        entities309 = findBean.nameEntities("Empresas",em);
        relationships43.setTo(entities309);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities310 = new Cardinalities();
        cardinalities310 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships43.setCardinalities(cardinalities310);
        em.persist(relationships43);
        em.flush();

    } // data()

} // crm
