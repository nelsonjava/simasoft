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
@Named("InventarySetup")
public class InventarySetup {

    @PersistenceContext(unitName = "naifg8PU-JTA")
    private EntityManager em;

    FindBean findBean = new FindBean();

    private static final Logger log = Logger.getLogger(DataDb.class.getName());

    public void data() {

//      ---------------------- DomainModels ------------------------

        DomainModels domainModels = new DomainModels();
        domainModels.setGroupId("co.simasoft");
        domainModels.setArtifactId("Inventary");
        domainModels.setVersion("1.0-SNAPSHOT");
        em.persist(domainModels);
        em.flush();

//      ---------------------- GroupIds ------------------------

        GroupIds groupIds1 = new GroupIds();
        groupIds1.setGroupId("co.simasoft.models.naif.inventary");
//      ...................... Inventary ........................
        DomainModels domainModel1 = new DomainModels();
        domainModel1 = findBean.artifactIdDomainModels("Inventary",em);
        groupIds1.setDomainModels(domainModel1);
        em.persist(groupIds1);
        em.flush();

//      ---------------------- Entities ------------------------

        Entities entities2 = new Entities();
        entities2.setName("Items");
//      ...................... co.simasoft.models.naif.inventary ........................
        GroupIds groupId2 = new GroupIds();
        groupId2 = findBean.groupIdGroupIds("co.simasoft.models.naif.inventary",em);
        entities2.setGroupIds(groupId2);
        em.persist(entities2);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes3 = new Attributes();
        attributes3.setName("hojaVida");
        attributes3.setNullable(true);
        attributes3.setSingle(false);
//      ...................... Items ........................
        Entities entity3 = new Entities();
        entity3 = findBean.nameEntities("Items",em);
        attributes3.setEntities(entity3);
//      ...................... int ........................
        AttributesTypes attributesTypes4 = new AttributesTypes();
        attributesTypes4 = findBean.nameAttributesTypes("int",em);
        attributes3.setAttributesTypes(attributesTypes4);
        em.persist(attributes3);
        em.flush();

        Attributes attributes4 = new Attributes();
        attributes4.setName("codigo");
        attributes4.setNullable(true);
        attributes4.setSingle(false);
//      ...................... Items ........................
        Entities entity5 = new Entities();
        entity5 = findBean.nameEntities("Items",em);
        attributes4.setEntities(entity5);
//      ...................... String ........................
        AttributesTypes attributesTypes6 = new AttributesTypes();
        attributesTypes6 = findBean.nameAttributesTypes("String",em);
        attributes4.setAttributesTypes(attributesTypes6);
        em.persist(attributes4);
        em.flush();

        Attributes attributes5 = new Attributes();
        attributes5.setName("codigoInventario");
        attributes5.setNullable(true);
        attributes5.setSingle(false);
//      ...................... Items ........................
        Entities entity7 = new Entities();
        entity7 = findBean.nameEntities("Items",em);
        attributes5.setEntities(entity7);
//      ...................... String ........................
        AttributesTypes attributesTypes8 = new AttributesTypes();
        attributesTypes8 = findBean.nameAttributesTypes("String",em);
        attributes5.setAttributesTypes(attributesTypes8);
        em.persist(attributes5);
        em.flush();

        Attributes attributes6 = new Attributes();
        attributes6.setName("serial");
        attributes6.setNullable(true);
        attributes6.setSingle(false);
//      ...................... Items ........................
        Entities entity9 = new Entities();
        entity9 = findBean.nameEntities("Items",em);
        attributes6.setEntities(entity9);
//      ...................... String ........................
        AttributesTypes attributesTypes10 = new AttributesTypes();
        attributesTypes10 = findBean.nameAttributesTypes("String",em);
        attributes6.setAttributesTypes(attributesTypes10);
        em.persist(attributes6);
        em.flush();

        Attributes attributes7 = new Attributes();
        attributes7.setName("codigoBarras");
        attributes7.setNullable(true);
        attributes7.setSingle(false);
//      ...................... Items ........................
        Entities entity11 = new Entities();
        entity11 = findBean.nameEntities("Items",em);
        attributes7.setEntities(entity11);
//      ...................... String ........................
        AttributesTypes attributesTypes12 = new AttributesTypes();
        attributesTypes12 = findBean.nameAttributesTypes("String",em);
        attributes7.setAttributesTypes(attributesTypes12);
        em.persist(attributes7);
        em.flush();

        Attributes attributes8 = new Attributes();
        attributes8.setName("fechaAdquisicion");
        attributes8.setNullable(true);
        attributes8.setSingle(false);
//      ...................... Items ........................
        Entities entity13 = new Entities();
        entity13 = findBean.nameEntities("Items",em);
        attributes8.setEntities(entity13);
//      ...................... Date ........................
        AttributesTypes attributesTypes14 = new AttributesTypes();
        attributesTypes14 = findBean.nameAttributesTypes("Date",em);
        attributes8.setAttributesTypes(attributesTypes14);
        em.persist(attributes8);
        em.flush();

        Attributes attributes9 = new Attributes();
        attributes9.setName("fechaVencimiento");
        attributes9.setNullable(true);
        attributes9.setSingle(false);
//      ...................... Items ........................
        Entities entity15 = new Entities();
        entity15 = findBean.nameEntities("Items",em);
        attributes9.setEntities(entity15);
//      ...................... Date ........................
        AttributesTypes attributesTypes16 = new AttributesTypes();
        attributesTypes16 = findBean.nameAttributesTypes("Date",em);
        attributes9.setAttributesTypes(attributesTypes16);
        em.persist(attributes9);
        em.flush();

        Attributes attributes10 = new Attributes();
        attributes10.setName("vencimientoGarantia");
        attributes10.setNullable(true);
        attributes10.setSingle(false);
//      ...................... Items ........................
        Entities entity17 = new Entities();
        entity17 = findBean.nameEntities("Items",em);
        attributes10.setEntities(entity17);
//      ...................... Date ........................
        AttributesTypes attributesTypes18 = new AttributesTypes();
        attributesTypes18 = findBean.nameAttributesTypes("Date",em);
        attributes10.setAttributesTypes(attributesTypes18);
        em.persist(attributes10);
        em.flush();

        Attributes attributes11 = new Attributes();
        attributes11.setName("minimo");
        attributes11.setNullable(true);
        attributes11.setSingle(false);
//      ...................... Items ........................
        Entities entity19 = new Entities();
        entity19 = findBean.nameEntities("Items",em);
        attributes11.setEntities(entity19);
//      ...................... Integer ........................
        AttributesTypes attributesTypes20 = new AttributesTypes();
        attributesTypes20 = findBean.nameAttributesTypes("Integer",em);
        attributes11.setAttributesTypes(attributesTypes20);
        em.persist(attributes11);
        em.flush();

        Attributes attributes12 = new Attributes();
        attributes12.setName("maximo");
        attributes12.setNullable(true);
        attributes12.setSingle(false);
//      ...................... Items ........................
        Entities entity21 = new Entities();
        entity21 = findBean.nameEntities("Items",em);
        attributes12.setEntities(entity21);
//      ...................... Integer ........................
        AttributesTypes attributesTypes22 = new AttributesTypes();
        attributesTypes22 = findBean.nameAttributesTypes("Integer",em);
        attributes12.setAttributesTypes(attributesTypes22);
        em.persist(attributes12);
        em.flush();

        Attributes attributes13 = new Attributes();
        attributes13.setName("cantidad");
        attributes13.setNullable(true);
        attributes13.setSingle(false);
//      ...................... Items ........................
        Entities entity23 = new Entities();
        entity23 = findBean.nameEntities("Items",em);
        attributes13.setEntities(entity23);
//      ...................... Integer ........................
        AttributesTypes attributesTypes24 = new AttributesTypes();
        attributesTypes24 = findBean.nameAttributesTypes("Integer",em);
        attributes13.setAttributesTypes(attributesTypes24);
        em.persist(attributes13);
        em.flush();

        Attributes attributes14 = new Attributes();
        attributes14.setName("ubicado");
        attributes14.setNullable(true);
        attributes14.setSingle(false);
//      ...................... Items ........................
        Entities entity25 = new Entities();
        entity25 = findBean.nameEntities("Items",em);
        attributes14.setEntities(entity25);
//      ...................... String ........................
        AttributesTypes attributesTypes26 = new AttributesTypes();
        attributesTypes26 = findBean.nameAttributesTypes("String",em);
        attributes14.setAttributesTypes(attributesTypes26);
        em.persist(attributes14);
        em.flush();

        Entities entities15 = new Entities();
        entities15.setName("Personas");
//      ...................... co.simasoft.models.naif.inventary ........................
        GroupIds groupId27 = new GroupIds();
        groupId27 = findBean.groupIdGroupIds("co.simasoft.models.naif.inventary",em);
        entities15.setGroupIds(groupId27);
        em.persist(entities15);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes16 = new Attributes();
        attributes16.setName("primerApellido");
        attributes16.setNullable(true);
        attributes16.setSingle(false);
//      ...................... Personas ........................
        Entities entity28 = new Entities();
        entity28 = findBean.nameEntities("Personas",em);
        attributes16.setEntities(entity28);
//      ...................... String ........................
        AttributesTypes attributesTypes29 = new AttributesTypes();
        attributesTypes29 = findBean.nameAttributesTypes("String",em);
        attributes16.setAttributesTypes(attributesTypes29);
        em.persist(attributes16);
        em.flush();

        Attributes attributes17 = new Attributes();
        attributes17.setName("segundoApellido");
        attributes17.setNullable(true);
        attributes17.setSingle(false);
//      ...................... Personas ........................
        Entities entity30 = new Entities();
        entity30 = findBean.nameEntities("Personas",em);
        attributes17.setEntities(entity30);
//      ...................... String ........................
        AttributesTypes attributesTypes31 = new AttributesTypes();
        attributesTypes31 = findBean.nameAttributesTypes("String",em);
        attributes17.setAttributesTypes(attributesTypes31);
        em.persist(attributes17);
        em.flush();

        Attributes attributes18 = new Attributes();
        attributes18.setName("primerNombre");
        attributes18.setNullable(true);
        attributes18.setSingle(false);
//      ...................... Personas ........................
        Entities entity32 = new Entities();
        entity32 = findBean.nameEntities("Personas",em);
        attributes18.setEntities(entity32);
//      ...................... String ........................
        AttributesTypes attributesTypes33 = new AttributesTypes();
        attributesTypes33 = findBean.nameAttributesTypes("String",em);
        attributes18.setAttributesTypes(attributesTypes33);
        em.persist(attributes18);
        em.flush();

        Attributes attributes19 = new Attributes();
        attributes19.setName("segundoNombre");
        attributes19.setNullable(true);
        attributes19.setSingle(false);
//      ...................... Personas ........................
        Entities entity34 = new Entities();
        entity34 = findBean.nameEntities("Personas",em);
        attributes19.setEntities(entity34);
//      ...................... String ........................
        AttributesTypes attributesTypes35 = new AttributesTypes();
        attributesTypes35 = findBean.nameAttributesTypes("String",em);
        attributes19.setAttributesTypes(attributesTypes35);
        em.persist(attributes19);
        em.flush();

        Attributes attributes20 = new Attributes();
        attributes20.setName("direccion");
        attributes20.setNullable(true);
        attributes20.setSingle(false);
//      ...................... Personas ........................
        Entities entity36 = new Entities();
        entity36 = findBean.nameEntities("Personas",em);
        attributes20.setEntities(entity36);
//      ...................... String ........................
        AttributesTypes attributesTypes37 = new AttributesTypes();
        attributesTypes37 = findBean.nameAttributesTypes("String",em);
        attributes20.setAttributesTypes(attributesTypes37);
        em.persist(attributes20);
        em.flush();

        Attributes attributes21 = new Attributes();
        attributes21.setName("telefonos");
        attributes21.setNullable(true);
        attributes21.setSingle(false);
//      ...................... Personas ........................
        Entities entity38 = new Entities();
        entity38 = findBean.nameEntities("Personas",em);
        attributes21.setEntities(entity38);
//      ...................... String ........................
        AttributesTypes attributesTypes39 = new AttributesTypes();
        attributesTypes39 = findBean.nameAttributesTypes("String",em);
        attributes21.setAttributesTypes(attributesTypes39);
        em.persist(attributes21);
        em.flush();

        Attributes attributes22 = new Attributes();
        attributes22.setName("email");
        attributes22.setNullable(true);
        attributes22.setSingle(false);
//      ...................... Personas ........................
        Entities entity40 = new Entities();
        entity40 = findBean.nameEntities("Personas",em);
        attributes22.setEntities(entity40);
//      ...................... String ........................
        AttributesTypes attributesTypes41 = new AttributesTypes();
        attributesTypes41 = findBean.nameAttributesTypes("String",em);
        attributes22.setAttributesTypes(attributesTypes41);
        em.persist(attributes22);
        em.flush();

        Entities entities23 = new Entities();
        entities23.setName("TiposAreasFisicas");
//      ...................... co.simasoft.models.naif.inventary ........................
        GroupIds groupId42 = new GroupIds();
        groupId42 = findBean.groupIdGroupIds("co.simasoft.models.naif.inventary",em);
        entities23.setGroupIds(groupId42);
        em.persist(entities23);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes24 = new Attributes();
        attributes24.setName("nombre");
        attributes24.setNullable(true);
        attributes24.setSingle(false);
//      ...................... TiposAreasFisicas ........................
        Entities entity43 = new Entities();
        entity43 = findBean.nameEntities("TiposAreasFisicas",em);
        attributes24.setEntities(entity43);
//      ...................... String ........................
        AttributesTypes attributesTypes44 = new AttributesTypes();
        attributesTypes44 = findBean.nameAttributesTypes("String",em);
        attributes24.setAttributesTypes(attributesTypes44);
        em.persist(attributes24);
        em.flush();

        Entities entities25 = new Entities();
        entities25.setName("TipoPersonal");
//      ...................... co.simasoft.models.naif.inventary ........................
        GroupIds groupId45 = new GroupIds();
        groupId45 = findBean.groupIdGroupIds("co.simasoft.models.naif.inventary",em);
        entities25.setGroupIds(groupId45);
        em.persist(entities25);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes26 = new Attributes();
        attributes26.setName("nombre");
        attributes26.setNullable(true);
        attributes26.setSingle(false);
//      ...................... TipoPersonal ........................
        Entities entity46 = new Entities();
        entity46 = findBean.nameEntities("TipoPersonal",em);
        attributes26.setEntities(entity46);
//      ...................... String ........................
        AttributesTypes attributesTypes47 = new AttributesTypes();
        attributesTypes47 = findBean.nameAttributesTypes("String",em);
        attributes26.setAttributesTypes(attributesTypes47);
        em.persist(attributes26);
        em.flush();

        Entities entities27 = new Entities();
        entities27.setName("TiposInventarios");
//      ...................... co.simasoft.models.naif.inventary ........................
        GroupIds groupId48 = new GroupIds();
        groupId48 = findBean.groupIdGroupIds("co.simasoft.models.naif.inventary",em);
        entities27.setGroupIds(groupId48);
        em.persist(entities27);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes28 = new Attributes();
        attributes28.setName("nombre");
        attributes28.setNullable(true);
        attributes28.setSingle(false);
//      ...................... TiposInventarios ........................
        Entities entity49 = new Entities();
        entity49 = findBean.nameEntities("TiposInventarios",em);
        attributes28.setEntities(entity49);
//      ...................... String ........................
        AttributesTypes attributesTypes50 = new AttributesTypes();
        attributesTypes50 = findBean.nameAttributesTypes("String",em);
        attributes28.setAttributesTypes(attributesTypes50);
        em.persist(attributes28);
        em.flush();

        Entities entities29 = new Entities();
        entities29.setName("Empresas");
//      ...................... co.simasoft.models.naif.inventary ........................
        GroupIds groupId51 = new GroupIds();
        groupId51 = findBean.groupIdGroupIds("co.simasoft.models.naif.inventary",em);
        entities29.setGroupIds(groupId51);
        em.persist(entities29);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes30 = new Attributes();
        attributes30.setName("nombre");
        attributes30.setNullable(true);
        attributes30.setSingle(false);
//      ...................... Empresas ........................
        Entities entity52 = new Entities();
        entity52 = findBean.nameEntities("Empresas",em);
        attributes30.setEntities(entity52);
//      ...................... String ........................
        AttributesTypes attributesTypes53 = new AttributesTypes();
        attributesTypes53 = findBean.nameAttributesTypes("String",em);
        attributes30.setAttributesTypes(attributesTypes53);
        em.persist(attributes30);
        em.flush();

        Attributes attributes31 = new Attributes();
        attributes31.setName("nit");
        attributes31.setNullable(true);
        attributes31.setSingle(false);
//      ...................... Empresas ........................
        Entities entity54 = new Entities();
        entity54 = findBean.nameEntities("Empresas",em);
        attributes31.setEntities(entity54);
//      ...................... String ........................
        AttributesTypes attributesTypes55 = new AttributesTypes();
        attributesTypes55 = findBean.nameAttributesTypes("String",em);
        attributes31.setAttributesTypes(attributesTypes55);
        em.persist(attributes31);
        em.flush();

        Attributes attributes32 = new Attributes();
        attributes32.setName("link");
        attributes32.setNullable(true);
        attributes32.setSingle(false);
//      ...................... Empresas ........................
        Entities entity56 = new Entities();
        entity56 = findBean.nameEntities("Empresas",em);
        attributes32.setEntities(entity56);
//      ...................... String ........................
        AttributesTypes attributesTypes57 = new AttributesTypes();
        attributesTypes57 = findBean.nameAttributesTypes("String",em);
        attributes32.setAttributesTypes(attributesTypes57);
        em.persist(attributes32);
        em.flush();

        Attributes attributes33 = new Attributes();
        attributes33.setName("direccion");
        attributes33.setNullable(true);
        attributes33.setSingle(false);
//      ...................... Empresas ........................
        Entities entity58 = new Entities();
        entity58 = findBean.nameEntities("Empresas",em);
        attributes33.setEntities(entity58);
//      ...................... String ........................
        AttributesTypes attributesTypes59 = new AttributesTypes();
        attributesTypes59 = findBean.nameAttributesTypes("String",em);
        attributes33.setAttributesTypes(attributesTypes59);
        em.persist(attributes33);
        em.flush();

        Attributes attributes34 = new Attributes();
        attributes34.setName("telefonos");
        attributes34.setNullable(true);
        attributes34.setSingle(false);
//      ...................... Empresas ........................
        Entities entity60 = new Entities();
        entity60 = findBean.nameEntities("Empresas",em);
        attributes34.setEntities(entity60);
//      ...................... String ........................
        AttributesTypes attributesTypes61 = new AttributesTypes();
        attributesTypes61 = findBean.nameAttributesTypes("String",em);
        attributes34.setAttributesTypes(attributesTypes61);
        em.persist(attributes34);
        em.flush();

        Attributes attributes35 = new Attributes();
        attributes35.setName("email");
        attributes35.setNullable(true);
        attributes35.setSingle(false);
//      ...................... Empresas ........................
        Entities entity62 = new Entities();
        entity62 = findBean.nameEntities("Empresas",em);
        attributes35.setEntities(entity62);
//      ...................... String ........................
        AttributesTypes attributesTypes63 = new AttributesTypes();
        attributesTypes63 = findBean.nameAttributesTypes("String",em);
        attributes35.setAttributesTypes(attributesTypes63);
        em.persist(attributes35);
        em.flush();

        Entities entities36 = new Entities();
        entities36.setName("NamesItems");
//      ...................... co.simasoft.models.naif.inventary ........................
        GroupIds groupId64 = new GroupIds();
        groupId64 = findBean.groupIdGroupIds("co.simasoft.models.naif.inventary",em);
        entities36.setGroupIds(groupId64);
        em.persist(entities36);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes37 = new Attributes();
        attributes37.setName("nombre");
        attributes37.setNullable(true);
        attributes37.setSingle(false);
//      ...................... NamesItems ........................
        Entities entity65 = new Entities();
        entity65 = findBean.nameEntities("NamesItems",em);
        attributes37.setEntities(entity65);
//      ...................... String ........................
        AttributesTypes attributesTypes66 = new AttributesTypes();
        attributesTypes66 = findBean.nameAttributesTypes("String",em);
        attributes37.setAttributesTypes(attributesTypes66);
        em.persist(attributes37);
        em.flush();

        Attributes attributes38 = new Attributes();
        attributes38.setName("modelo");
        attributes38.setNullable(true);
        attributes38.setSingle(false);
//      ...................... NamesItems ........................
        Entities entity67 = new Entities();
        entity67 = findBean.nameEntities("NamesItems",em);
        attributes38.setEntities(entity67);
//      ...................... String ........................
        AttributesTypes attributesTypes68 = new AttributesTypes();
        attributesTypes68 = findBean.nameAttributesTypes("String",em);
        attributes38.setAttributesTypes(attributesTypes68);
        em.persist(attributes38);
        em.flush();

        Attributes attributes39 = new Attributes();
        attributes39.setName("nroProducto");
        attributes39.setNullable(true);
        attributes39.setSingle(false);
//      ...................... NamesItems ........................
        Entities entity69 = new Entities();
        entity69 = findBean.nameEntities("NamesItems",em);
        attributes39.setEntities(entity69);
//      ...................... String ........................
        AttributesTypes attributesTypes70 = new AttributesTypes();
        attributesTypes70 = findBean.nameAttributesTypes("String",em);
        attributes39.setAttributesTypes(attributesTypes70);
        em.persist(attributes39);
        em.flush();

        Attributes attributes40 = new Attributes();
        attributes40.setName("nroParte");
        attributes40.setNullable(true);
        attributes40.setSingle(false);
//      ...................... NamesItems ........................
        Entities entity71 = new Entities();
        entity71 = findBean.nameEntities("NamesItems",em);
        attributes40.setEntities(entity71);
//      ...................... String ........................
        AttributesTypes attributesTypes72 = new AttributesTypes();
        attributesTypes72 = findBean.nameAttributesTypes("String",em);
        attributes40.setAttributesTypes(attributesTypes72);
        em.persist(attributes40);
        em.flush();

        Attributes attributes41 = new Attributes();
        attributes41.setName("link");
        attributes41.setNullable(true);
        attributes41.setSingle(false);
//      ...................... NamesItems ........................
        Entities entity73 = new Entities();
        entity73 = findBean.nameEntities("NamesItems",em);
        attributes41.setEntities(entity73);
//      ...................... String ........................
        AttributesTypes attributesTypes74 = new AttributesTypes();
        attributesTypes74 = findBean.nameAttributesTypes("String",em);
        attributes41.setAttributesTypes(attributesTypes74);
        em.persist(attributes41);
        em.flush();

        Entities entities42 = new Entities();
        entities42.setName("ItemsFacturas");
//      ...................... co.simasoft.models.naif.inventary ........................
        GroupIds groupId75 = new GroupIds();
        groupId75 = findBean.groupIdGroupIds("co.simasoft.models.naif.inventary",em);
        entities42.setGroupIds(groupId75);
        em.persist(entities42);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes43 = new Attributes();
        attributes43.setName("cantidad");
        attributes43.setNullable(true);
        attributes43.setSingle(false);
//      ...................... ItemsFacturas ........................
        Entities entity76 = new Entities();
        entity76 = findBean.nameEntities("ItemsFacturas",em);
        attributes43.setEntities(entity76);
//      ...................... Integer ........................
        AttributesTypes attributesTypes77 = new AttributesTypes();
        attributesTypes77 = findBean.nameAttributesTypes("Integer",em);
        attributes43.setAttributesTypes(attributesTypes77);
        em.persist(attributes43);
        em.flush();

        Attributes attributes44 = new Attributes();
        attributes44.setName("valorUnitario");
        attributes44.setNullable(true);
        attributes44.setSingle(false);
//      ...................... ItemsFacturas ........................
        Entities entity78 = new Entities();
        entity78 = findBean.nameEntities("ItemsFacturas",em);
        attributes44.setEntities(entity78);
//      ...................... Double ........................
        AttributesTypes attributesTypes79 = new AttributesTypes();
        attributesTypes79 = findBean.nameAttributesTypes("Double",em);
        attributes44.setAttributesTypes(attributesTypes79);
        em.persist(attributes44);
        em.flush();

        Entities entities45 = new Entities();
        entities45.setName("SwitchPortsTypes");
//      ...................... co.simasoft.models.naif.inventary ........................
        GroupIds groupId80 = new GroupIds();
        groupId80 = findBean.groupIdGroupIds("co.simasoft.models.naif.inventary",em);
        entities45.setGroupIds(groupId80);
        em.persist(entities45);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes46 = new Attributes();
        attributes46.setName("nombre");
        attributes46.setNullable(true);
        attributes46.setSingle(false);
//      ...................... SwitchPortsTypes ........................
        Entities entity81 = new Entities();
        entity81 = findBean.nameEntities("SwitchPortsTypes",em);
        attributes46.setEntities(entity81);
//      ...................... String ........................
        AttributesTypes attributesTypes82 = new AttributesTypes();
        attributesTypes82 = findBean.nameAttributesTypes("String",em);
        attributes46.setAttributesTypes(attributesTypes82);
        em.persist(attributes46);
        em.flush();

        Entities entities47 = new Entities();
        entities47.setName("MAC-IP");
//      ...................... co.simasoft.models.naif.inventary ........................
        GroupIds groupId83 = new GroupIds();
        groupId83 = findBean.groupIdGroupIds("co.simasoft.models.naif.inventary",em);
        entities47.setGroupIds(groupId83);
        em.persist(entities47);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes48 = new Attributes();
        attributes48.setName("ip");
        attributes48.setNullable(true);
        attributes48.setSingle(false);
//      ...................... MAC-IP ........................
        Entities entity84 = new Entities();
        entity84 = findBean.nameEntities("MAC-IP",em);
        attributes48.setEntities(entity84);
//      ...................... String ........................
        AttributesTypes attributesTypes85 = new AttributesTypes();
        attributesTypes85 = findBean.nameAttributesTypes("String",em);
        attributes48.setAttributesTypes(attributesTypes85);
        em.persist(attributes48);
        em.flush();

        Attributes attributes49 = new Attributes();
        attributes49.setName("mac");
        attributes49.setNullable(true);
        attributes49.setSingle(false);
//      ...................... MAC-IP ........................
        Entities entity86 = new Entities();
        entity86 = findBean.nameEntities("MAC-IP",em);
        attributes49.setEntities(entity86);
//      ...................... String ........................
        AttributesTypes attributesTypes87 = new AttributesTypes();
        attributesTypes87 = findBean.nameAttributesTypes("String",em);
        attributes49.setAttributesTypes(attributesTypes87);
        em.persist(attributes49);
        em.flush();

        Entities entities50 = new Entities();
        entities50.setName("Facturas");
//      ...................... co.simasoft.models.naif.inventary ........................
        GroupIds groupId88 = new GroupIds();
        groupId88 = findBean.groupIdGroupIds("co.simasoft.models.naif.inventary",em);
        entities50.setGroupIds(groupId88);
        em.persist(entities50);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes51 = new Attributes();
        attributes51.setName("numero");
        attributes51.setNullable(true);
        attributes51.setSingle(false);
//      ...................... Facturas ........................
        Entities entity89 = new Entities();
        entity89 = findBean.nameEntities("Facturas",em);
        attributes51.setEntities(entity89);
//      ...................... String ........................
        AttributesTypes attributesTypes90 = new AttributesTypes();
        attributesTypes90 = findBean.nameAttributesTypes("String",em);
        attributes51.setAttributesTypes(attributesTypes90);
        em.persist(attributes51);
        em.flush();

        Entities entities52 = new Entities();
        entities52.setName("Inventarios");
//      ...................... co.simasoft.models.naif.inventary ........................
        GroupIds groupId91 = new GroupIds();
        groupId91 = findBean.groupIdGroupIds("co.simasoft.models.naif.inventary",em);
        entities52.setGroupIds(groupId91);
        em.persist(entities52);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes53 = new Attributes();
        attributes53.setName("nombre");
        attributes53.setNullable(true);
        attributes53.setSingle(false);
//      ...................... Inventarios ........................
        Entities entity92 = new Entities();
        entity92 = findBean.nameEntities("Inventarios",em);
        attributes53.setEntities(entity92);
//      ...................... String ........................
        AttributesTypes attributesTypes93 = new AttributesTypes();
        attributesTypes93 = findBean.nameAttributesTypes("String",em);
        attributes53.setAttributesTypes(attributesTypes93);
        em.persist(attributes53);
        em.flush();

        Entities entities54 = new Entities();
        entities54.setName("TiposSecciones");
//      ...................... co.simasoft.models.naif.inventary ........................
        GroupIds groupId94 = new GroupIds();
        groupId94 = findBean.groupIdGroupIds("co.simasoft.models.naif.inventary",em);
        entities54.setGroupIds(groupId94);
        em.persist(entities54);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes55 = new Attributes();
        attributes55.setName("nombre");
        attributes55.setNullable(true);
        attributes55.setSingle(false);
//      ...................... TiposSecciones ........................
        Entities entity95 = new Entities();
        entity95 = findBean.nameEntities("TiposSecciones",em);
        attributes55.setEntities(entity95);
//      ...................... String ........................
        AttributesTypes attributesTypes96 = new AttributesTypes();
        attributesTypes96 = findBean.nameAttributesTypes("String",em);
        attributes55.setAttributesTypes(attributesTypes96);
        em.persist(attributes55);
        em.flush();

        Entities entities56 = new Entities();
        entities56.setName("VLAN");
//      ...................... co.simasoft.models.naif.inventary ........................
        GroupIds groupId97 = new GroupIds();
        groupId97 = findBean.groupIdGroupIds("co.simasoft.models.naif.inventary",em);
        entities56.setGroupIds(groupId97);
        em.persist(entities56);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes57 = new Attributes();
        attributes57.setName("nombre");
        attributes57.setNullable(true);
        attributes57.setSingle(false);
//      ...................... VLAN ........................
        Entities entity98 = new Entities();
        entity98 = findBean.nameEntities("VLAN",em);
        attributes57.setEntities(entity98);
//      ...................... String ........................
        AttributesTypes attributesTypes99 = new AttributesTypes();
        attributesTypes99 = findBean.nameAttributesTypes("String",em);
        attributes57.setAttributesTypes(attributesTypes99);
        em.persist(attributes57);
        em.flush();

        Attributes attributes58 = new Attributes();
        attributes58.setName("ip");
        attributes58.setNullable(true);
        attributes58.setSingle(false);
//      ...................... VLAN ........................
        Entities entity100 = new Entities();
        entity100 = findBean.nameEntities("VLAN",em);
        attributes58.setEntities(entity100);
//      ...................... String ........................
        AttributesTypes attributesTypes101 = new AttributesTypes();
        attributesTypes101 = findBean.nameAttributesTypes("String",em);
        attributes58.setAttributesTypes(attributesTypes101);
        em.persist(attributes58);
        em.flush();

        Entities entities59 = new Entities();
        entities59.setName("AreasFisicas");
//      ...................... co.simasoft.models.naif.inventary ........................
        GroupIds groupId102 = new GroupIds();
        groupId102 = findBean.groupIdGroupIds("co.simasoft.models.naif.inventary",em);
        entities59.setGroupIds(groupId102);
        em.persist(entities59);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes60 = new Attributes();
        attributes60.setName("nombre");
        attributes60.setNullable(true);
        attributes60.setSingle(false);
//      ...................... AreasFisicas ........................
        Entities entity103 = new Entities();
        entity103 = findBean.nameEntities("AreasFisicas",em);
        attributes60.setEntities(entity103);
//      ...................... String ........................
        AttributesTypes attributesTypes104 = new AttributesTypes();
        attributesTypes104 = findBean.nameAttributesTypes("String",em);
        attributes60.setAttributesTypes(attributesTypes104);
        em.persist(attributes60);
        em.flush();

        Entities entities61 = new Entities();
        entities61.setName("EstadosItems");
//      ...................... co.simasoft.models.naif.inventary ........................
        GroupIds groupId105 = new GroupIds();
        groupId105 = findBean.groupIdGroupIds("co.simasoft.models.naif.inventary",em);
        entities61.setGroupIds(groupId105);
        em.persist(entities61);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes62 = new Attributes();
        attributes62.setName("nombre");
        attributes62.setNullable(true);
        attributes62.setSingle(false);
//      ...................... EstadosItems ........................
        Entities entity106 = new Entities();
        entity106 = findBean.nameEntities("EstadosItems",em);
        attributes62.setEntities(entity106);
//      ...................... String ........................
        AttributesTypes attributesTypes107 = new AttributesTypes();
        attributesTypes107 = findBean.nameAttributesTypes("String",em);
        attributes62.setAttributesTypes(attributesTypes107);
        em.persist(attributes62);
        em.flush();

        Entities entities63 = new Entities();
        entities63.setName("SwitchPorts");
//      ...................... co.simasoft.models.naif.inventary ........................
        GroupIds groupId108 = new GroupIds();
        groupId108 = findBean.groupIdGroupIds("co.simasoft.models.naif.inventary",em);
        entities63.setGroupIds(groupId108);
        em.persist(entities63);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes64 = new Attributes();
        attributes64.setName("port");
        attributes64.setNullable(true);
        attributes64.setSingle(false);
//      ...................... SwitchPorts ........................
        Entities entity109 = new Entities();
        entity109 = findBean.nameEntities("SwitchPorts",em);
        attributes64.setEntities(entity109);
//      ...................... String ........................
        AttributesTypes attributesTypes110 = new AttributesTypes();
        attributesTypes110 = findBean.nameAttributesTypes("String",em);
        attributes64.setAttributesTypes(attributesTypes110);
        em.persist(attributes64);
        em.flush();

        Attributes attributes65 = new Attributes();
        attributes65.setName("code");
        attributes65.setNullable(true);
        attributes65.setSingle(false);
//      ...................... SwitchPorts ........................
        Entities entity111 = new Entities();
        entity111 = findBean.nameEntities("SwitchPorts",em);
        attributes65.setEntities(entity111);
//      ...................... String ........................
        AttributesTypes attributesTypes112 = new AttributesTypes();
        attributesTypes112 = findBean.nameAttributesTypes("String",em);
        attributes65.setAttributesTypes(attributesTypes112);
        em.persist(attributes65);
        em.flush();

        Attributes attributes66 = new Attributes();
        attributes66.setName("state");
        attributes66.setNullable(true);
        attributes66.setSingle(false);
//      ...................... SwitchPorts ........................
        Entities entity113 = new Entities();
        entity113 = findBean.nameEntities("SwitchPorts",em);
        attributes66.setEntities(entity113);
//      ...................... String ........................
        AttributesTypes attributesTypes114 = new AttributesTypes();
        attributesTypes114 = findBean.nameAttributesTypes("String",em);
        attributes66.setAttributesTypes(attributesTypes114);
        em.persist(attributes66);
        em.flush();

        Attributes attributes67 = new Attributes();
        attributes67.setName("PatchPanelPorts");
        attributes67.setNullable(true);
        attributes67.setSingle(false);
//      ...................... SwitchPorts ........................
        Entities entity115 = new Entities();
        entity115 = findBean.nameEntities("SwitchPorts",em);
        attributes67.setEntities(entity115);
//      ...................... String ........................
        AttributesTypes attributesTypes116 = new AttributesTypes();
        attributesTypes116 = findBean.nameAttributesTypes("String",em);
        attributes67.setAttributesTypes(attributesTypes116);
        em.persist(attributes67);
        em.flush();

        Entities entities68 = new Entities();
        entities68.setName("Marcas");
//      ...................... co.simasoft.models.naif.inventary ........................
        GroupIds groupId117 = new GroupIds();
        groupId117 = findBean.groupIdGroupIds("co.simasoft.models.naif.inventary",em);
        entities68.setGroupIds(groupId117);
        em.persist(entities68);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes69 = new Attributes();
        attributes69.setName("nombre");
        attributes69.setNullable(true);
        attributes69.setSingle(false);
//      ...................... Marcas ........................
        Entities entity118 = new Entities();
        entity118 = findBean.nameEntities("Marcas",em);
        attributes69.setEntities(entity118);
//      ...................... String ........................
        AttributesTypes attributesTypes119 = new AttributesTypes();
        attributesTypes119 = findBean.nameAttributesTypes("String",em);
        attributes69.setAttributesTypes(attributesTypes119);
        em.persist(attributes69);
        em.flush();

        Entities entities70 = new Entities();
        entities70.setName("TiposItems");
//      ...................... co.simasoft.models.naif.inventary ........................
        GroupIds groupId120 = new GroupIds();
        groupId120 = findBean.groupIdGroupIds("co.simasoft.models.naif.inventary",em);
        entities70.setGroupIds(groupId120);
        em.persist(entities70);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes71 = new Attributes();
        attributes71.setName("nombre");
        attributes71.setNullable(true);
        attributes71.setSingle(false);
//      ...................... TiposItems ........................
        Entities entity121 = new Entities();
        entity121 = findBean.nameEntities("TiposItems",em);
        attributes71.setEntities(entity121);
//      ...................... String ........................
        AttributesTypes attributesTypes122 = new AttributesTypes();
        attributesTypes122 = findBean.nameAttributesTypes("String",em);
        attributes71.setAttributesTypes(attributesTypes122);
        em.persist(attributes71);
        em.flush();

        Entities entities72 = new Entities();
        entities72.setName("Secciones");
//      ...................... co.simasoft.models.naif.inventary ........................
        GroupIds groupId123 = new GroupIds();
        groupId123 = findBean.groupIdGroupIds("co.simasoft.models.naif.inventary",em);
        entities72.setGroupIds(groupId123);
        em.persist(entities72);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes73 = new Attributes();
        attributes73.setName("nombre");
        attributes73.setNullable(true);
        attributes73.setSingle(false);
//      ...................... Secciones ........................
        Entities entity124 = new Entities();
        entity124 = findBean.nameEntities("Secciones",em);
        attributes73.setEntities(entity124);
//      ...................... String ........................
        AttributesTypes attributesTypes125 = new AttributesTypes();
        attributesTypes125 = findBean.nameAttributesTypes("String",em);
        attributes73.setAttributesTypes(attributesTypes125);
        em.persist(attributes73);
        em.flush();

        Attributes attributes74 = new Attributes();
        attributes74.setName("codigo");
        attributes74.setNullable(true);
        attributes74.setSingle(false);
//      ...................... Secciones ........................
        Entities entity126 = new Entities();
        entity126 = findBean.nameEntities("Secciones",em);
        attributes74.setEntities(entity126);
//      ...................... String ........................
        AttributesTypes attributesTypes127 = new AttributesTypes();
        attributesTypes127 = findBean.nameAttributesTypes("String",em);
        attributes74.setAttributesTypes(attributesTypes127);
        em.persist(attributes74);
        em.flush();

//      ---------------------- Relationships ------------------------

/*
Empresas 1..* Facturas
TiposInventarios 1..* Inventarios
Facturas 1..* ItemsFacturas
Items 1..* ItemsFacturas
TiposItems 1..* Items
SwitchPorts 1..* Items
TiposAreasFisicas 1..* AreasFisicas
Secciones 1..* Items
NamesItems 1..* Items
Marcas *..* Empresas
Empresas 1..* Personas
Inventarios 1..* Items
TiposSecciones 1..* Secciones
EstadosItems 1..* Items
Empresas *..* Marcas
Marcas 1..* NamesItems
Items 1..* MAC-IP
SwitchPortsTypes 1..* SwitchPorts
AreasFisicas 1..* Items
Personas 1..* Secciones
TipoPersonal 1..* Personas
AreasFisicas 1..* AreasFisicas
VLAN 1..* MAC-IP
Secciones 1..* Secciones
*/
        Relationships relationships1 = new Relationships();
        relationships1.setOptionality(true);
        relationships1.setIsEmbedded(false);
//      ...................... Empresas ........................
        Entities entities128 = new Entities();
        entities128 = findBean.nameEntities("Empresas",em);
        relationships1.setFrom(entities128);
//      ...................... Facturas ........................
        Entities entities129 = new Entities();
        entities129 = findBean.nameEntities("Facturas",em);
        relationships1.setTo(entities129);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities130 = new Cardinalities();
        cardinalities130 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships1.setCardinalities(cardinalities130);
        em.persist(relationships1);
        em.flush();

        Relationships relationships2 = new Relationships();
        relationships2.setOptionality(true);
        relationships2.setIsEmbedded(false);
//      ...................... TiposInventarios ........................
        Entities entities131 = new Entities();
        entities131 = findBean.nameEntities("TiposInventarios",em);
        relationships2.setFrom(entities131);
//      ...................... Inventarios ........................
        Entities entities132 = new Entities();
        entities132 = findBean.nameEntities("Inventarios",em);
        relationships2.setTo(entities132);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities133 = new Cardinalities();
        cardinalities133 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships2.setCardinalities(cardinalities133);
        em.persist(relationships2);
        em.flush();

        Relationships relationships3 = new Relationships();
        relationships3.setOptionality(true);
        relationships3.setIsEmbedded(false);
//      ...................... Facturas ........................
        Entities entities134 = new Entities();
        entities134 = findBean.nameEntities("Facturas",em);
        relationships3.setFrom(entities134);
//      ...................... ItemsFacturas ........................
        Entities entities135 = new Entities();
        entities135 = findBean.nameEntities("ItemsFacturas",em);
        relationships3.setTo(entities135);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities136 = new Cardinalities();
        cardinalities136 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships3.setCardinalities(cardinalities136);
        em.persist(relationships3);
        em.flush();

        Relationships relationships4 = new Relationships();
        relationships4.setOptionality(true);
        relationships4.setIsEmbedded(false);
//      ...................... Items ........................
        Entities entities137 = new Entities();
        entities137 = findBean.nameEntities("Items",em);
        relationships4.setFrom(entities137);
//      ...................... ItemsFacturas ........................
        Entities entities138 = new Entities();
        entities138 = findBean.nameEntities("ItemsFacturas",em);
        relationships4.setTo(entities138);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities139 = new Cardinalities();
        cardinalities139 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships4.setCardinalities(cardinalities139);
        em.persist(relationships4);
        em.flush();

        Relationships relationships5 = new Relationships();
        relationships5.setOptionality(true);
        relationships5.setIsEmbedded(false);
//      ...................... TiposItems ........................
        Entities entities140 = new Entities();
        entities140 = findBean.nameEntities("TiposItems",em);
        relationships5.setFrom(entities140);
//      ...................... Items ........................
        Entities entities141 = new Entities();
        entities141 = findBean.nameEntities("Items",em);
        relationships5.setTo(entities141);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities142 = new Cardinalities();
        cardinalities142 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships5.setCardinalities(cardinalities142);
        em.persist(relationships5);
        em.flush();

        Relationships relationships6 = new Relationships();
        relationships6.setOptionality(true);
        relationships6.setIsEmbedded(false);
//      ...................... SwitchPorts ........................
        Entities entities143 = new Entities();
        entities143 = findBean.nameEntities("SwitchPorts",em);
        relationships6.setFrom(entities143);
//      ...................... Items ........................
        Entities entities144 = new Entities();
        entities144 = findBean.nameEntities("Items",em);
        relationships6.setTo(entities144);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities145 = new Cardinalities();
        cardinalities145 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships6.setCardinalities(cardinalities145);
        em.persist(relationships6);
        em.flush();

        Relationships relationships7 = new Relationships();
        relationships7.setOptionality(true);
        relationships7.setIsEmbedded(false);
//      ...................... TiposAreasFisicas ........................
        Entities entities146 = new Entities();
        entities146 = findBean.nameEntities("TiposAreasFisicas",em);
        relationships7.setFrom(entities146);
//      ...................... AreasFisicas ........................
        Entities entities147 = new Entities();
        entities147 = findBean.nameEntities("AreasFisicas",em);
        relationships7.setTo(entities147);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities148 = new Cardinalities();
        cardinalities148 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships7.setCardinalities(cardinalities148);
        em.persist(relationships7);
        em.flush();

        Relationships relationships8 = new Relationships();
        relationships8.setOptionality(true);
        relationships8.setIsEmbedded(false);
//      ...................... Secciones ........................
        Entities entities149 = new Entities();
        entities149 = findBean.nameEntities("Secciones",em);
        relationships8.setFrom(entities149);
//      ...................... Items ........................
        Entities entities150 = new Entities();
        entities150 = findBean.nameEntities("Items",em);
        relationships8.setTo(entities150);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities151 = new Cardinalities();
        cardinalities151 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships8.setCardinalities(cardinalities151);
        em.persist(relationships8);
        em.flush();

        Relationships relationships9 = new Relationships();
        relationships9.setOptionality(true);
        relationships9.setIsEmbedded(false);
//      ...................... NamesItems ........................
        Entities entities152 = new Entities();
        entities152 = findBean.nameEntities("NamesItems",em);
        relationships9.setFrom(entities152);
//      ...................... Items ........................
        Entities entities153 = new Entities();
        entities153 = findBean.nameEntities("Items",em);
        relationships9.setTo(entities153);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities154 = new Cardinalities();
        cardinalities154 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships9.setCardinalities(cardinalities154);
        em.persist(relationships9);
        em.flush();

        Relationships relationships10 = new Relationships();
        relationships10.setOptionality(true);
        relationships10.setIsEmbedded(false);
//      ...................... Marcas ........................
        Entities entities155 = new Entities();
        entities155 = findBean.nameEntities("Marcas",em);
        relationships10.setFrom(entities155);
//      ...................... Empresas ........................
        Entities entities156 = new Entities();
        entities156 = findBean.nameEntities("Empresas",em);
        relationships10.setTo(entities156);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities157 = new Cardinalities();
        cardinalities157 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships10.setCardinalities(cardinalities157);
        em.persist(relationships10);
        em.flush();

        Relationships relationships11 = new Relationships();
        relationships11.setOptionality(true);
        relationships11.setIsEmbedded(false);
//      ...................... Empresas ........................
        Entities entities158 = new Entities();
        entities158 = findBean.nameEntities("Empresas",em);
        relationships11.setFrom(entities158);
//      ...................... Personas ........................
        Entities entities159 = new Entities();
        entities159 = findBean.nameEntities("Personas",em);
        relationships11.setTo(entities159);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities160 = new Cardinalities();
        cardinalities160 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships11.setCardinalities(cardinalities160);
        em.persist(relationships11);
        em.flush();

        Relationships relationships12 = new Relationships();
        relationships12.setOptionality(true);
        relationships12.setIsEmbedded(false);
//      ...................... Inventarios ........................
        Entities entities161 = new Entities();
        entities161 = findBean.nameEntities("Inventarios",em);
        relationships12.setFrom(entities161);
//      ...................... Items ........................
        Entities entities162 = new Entities();
        entities162 = findBean.nameEntities("Items",em);
        relationships12.setTo(entities162);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities163 = new Cardinalities();
        cardinalities163 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships12.setCardinalities(cardinalities163);
        em.persist(relationships12);
        em.flush();

        Relationships relationships13 = new Relationships();
        relationships13.setOptionality(true);
        relationships13.setIsEmbedded(false);
//      ...................... TiposSecciones ........................
        Entities entities164 = new Entities();
        entities164 = findBean.nameEntities("TiposSecciones",em);
        relationships13.setFrom(entities164);
//      ...................... Secciones ........................
        Entities entities165 = new Entities();
        entities165 = findBean.nameEntities("Secciones",em);
        relationships13.setTo(entities165);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities166 = new Cardinalities();
        cardinalities166 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships13.setCardinalities(cardinalities166);
        em.persist(relationships13);
        em.flush();

        Relationships relationships14 = new Relationships();
        relationships14.setOptionality(true);
        relationships14.setIsEmbedded(false);
//      ...................... EstadosItems ........................
        Entities entities167 = new Entities();
        entities167 = findBean.nameEntities("EstadosItems",em);
        relationships14.setFrom(entities167);
//      ...................... Items ........................
        Entities entities168 = new Entities();
        entities168 = findBean.nameEntities("Items",em);
        relationships14.setTo(entities168);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities169 = new Cardinalities();
        cardinalities169 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships14.setCardinalities(cardinalities169);
        em.persist(relationships14);
        em.flush();

        Relationships relationships15 = new Relationships();
        relationships15.setOptionality(true);
        relationships15.setIsEmbedded(false);
//      ...................... Empresas ........................
        Entities entities170 = new Entities();
        entities170 = findBean.nameEntities("Empresas",em);
        relationships15.setFrom(entities170);
//      ...................... Marcas ........................
        Entities entities171 = new Entities();
        entities171 = findBean.nameEntities("Marcas",em);
        relationships15.setTo(entities171);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities172 = new Cardinalities();
        cardinalities172 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships15.setCardinalities(cardinalities172);
        em.persist(relationships15);
        em.flush();

        Relationships relationships16 = new Relationships();
        relationships16.setOptionality(true);
        relationships16.setIsEmbedded(false);
//      ...................... Marcas ........................
        Entities entities173 = new Entities();
        entities173 = findBean.nameEntities("Marcas",em);
        relationships16.setFrom(entities173);
//      ...................... NamesItems ........................
        Entities entities174 = new Entities();
        entities174 = findBean.nameEntities("NamesItems",em);
        relationships16.setTo(entities174);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities175 = new Cardinalities();
        cardinalities175 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships16.setCardinalities(cardinalities175);
        em.persist(relationships16);
        em.flush();

        Relationships relationships17 = new Relationships();
        relationships17.setOptionality(true);
        relationships17.setIsEmbedded(false);
//      ...................... Items ........................
        Entities entities176 = new Entities();
        entities176 = findBean.nameEntities("Items",em);
        relationships17.setFrom(entities176);
//      ...................... MAC-IP ........................
        Entities entities177 = new Entities();
        entities177 = findBean.nameEntities("MAC-IP",em);
        relationships17.setTo(entities177);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities178 = new Cardinalities();
        cardinalities178 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships17.setCardinalities(cardinalities178);
        em.persist(relationships17);
        em.flush();

        Relationships relationships18 = new Relationships();
        relationships18.setOptionality(true);
        relationships18.setIsEmbedded(false);
//      ...................... SwitchPortsTypes ........................
        Entities entities179 = new Entities();
        entities179 = findBean.nameEntities("SwitchPortsTypes",em);
        relationships18.setFrom(entities179);
//      ...................... SwitchPorts ........................
        Entities entities180 = new Entities();
        entities180 = findBean.nameEntities("SwitchPorts",em);
        relationships18.setTo(entities180);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities181 = new Cardinalities();
        cardinalities181 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships18.setCardinalities(cardinalities181);
        em.persist(relationships18);
        em.flush();

        Relationships relationships19 = new Relationships();
        relationships19.setOptionality(true);
        relationships19.setIsEmbedded(false);
//      ...................... AreasFisicas ........................
        Entities entities182 = new Entities();
        entities182 = findBean.nameEntities("AreasFisicas",em);
        relationships19.setFrom(entities182);
//      ...................... Items ........................
        Entities entities183 = new Entities();
        entities183 = findBean.nameEntities("Items",em);
        relationships19.setTo(entities183);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities184 = new Cardinalities();
        cardinalities184 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships19.setCardinalities(cardinalities184);
        em.persist(relationships19);
        em.flush();

        Relationships relationships20 = new Relationships();
        relationships20.setOptionality(true);
        relationships20.setIsEmbedded(false);
//      ...................... Personas ........................
        Entities entities185 = new Entities();
        entities185 = findBean.nameEntities("Personas",em);
        relationships20.setFrom(entities185);
//      ...................... Secciones ........................
        Entities entities186 = new Entities();
        entities186 = findBean.nameEntities("Secciones",em);
        relationships20.setTo(entities186);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities187 = new Cardinalities();
        cardinalities187 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships20.setCardinalities(cardinalities187);
        em.persist(relationships20);
        em.flush();

        Relationships relationships21 = new Relationships();
        relationships21.setOptionality(true);
        relationships21.setIsEmbedded(false);
//      ...................... TipoPersonal ........................
        Entities entities188 = new Entities();
        entities188 = findBean.nameEntities("TipoPersonal",em);
        relationships21.setFrom(entities188);
//      ...................... Personas ........................
        Entities entities189 = new Entities();
        entities189 = findBean.nameEntities("Personas",em);
        relationships21.setTo(entities189);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities190 = new Cardinalities();
        cardinalities190 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships21.setCardinalities(cardinalities190);
        em.persist(relationships21);
        em.flush();

        Relationships relationships22 = new Relationships();
        relationships22.setOptionality(true);
        relationships22.setIsEmbedded(false);
//      ...................... AreasFisicas ........................
        Entities entities191 = new Entities();
        entities191 = findBean.nameEntities("AreasFisicas",em);
        relationships22.setFrom(entities191);
//      ...................... AreasFisicas ........................
        Entities entities192 = new Entities();
        entities192 = findBean.nameEntities("AreasFisicas",em);
        relationships22.setTo(entities192);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities193 = new Cardinalities();
        cardinalities193 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships22.setCardinalities(cardinalities193);
        em.persist(relationships22);
        em.flush();

        Relationships relationships23 = new Relationships();
        relationships23.setOptionality(true);
        relationships23.setIsEmbedded(false);
//      ...................... VLAN ........................
        Entities entities194 = new Entities();
        entities194 = findBean.nameEntities("VLAN",em);
        relationships23.setFrom(entities194);
//      ...................... MAC-IP ........................
        Entities entities195 = new Entities();
        entities195 = findBean.nameEntities("MAC-IP",em);
        relationships23.setTo(entities195);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities196 = new Cardinalities();
        cardinalities196 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships23.setCardinalities(cardinalities196);
        em.persist(relationships23);
        em.flush();

        Relationships relationships24 = new Relationships();
        relationships24.setOptionality(true);
        relationships24.setIsEmbedded(false);
//      ...................... Secciones ........................
        Entities entities197 = new Entities();
        entities197 = findBean.nameEntities("Secciones",em);
        relationships24.setFrom(entities197);
//      ...................... Secciones ........................
        Entities entities198 = new Entities();
        entities198 = findBean.nameEntities("Secciones",em);
        relationships24.setTo(entities198);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities199 = new Cardinalities();
        cardinalities199 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships24.setCardinalities(cardinalities199);
        em.persist(relationships24);
        em.flush();

    } // data()

} // Inventary
