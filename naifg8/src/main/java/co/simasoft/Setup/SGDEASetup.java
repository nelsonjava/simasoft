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
@Named("SGDEASetup")
public class SGDEASetup {

    @PersistenceContext(unitName = "naifg8PU-JTA")
    private EntityManager em;

    FindBean findBean = new FindBean();

    private static final Logger log = Logger.getLogger(DataDb.class.getName());

    public void data() {

//      ---------------------- DomainModels ------------------------

        DomainModels domainModels = new DomainModels();
        domainModels.setGroupId("co.simasoft");
        domainModels.setArtifactId("SGDEA");
        domainModels.setVersion("1.0-SNAPSHOT");
        em.persist(domainModels);
        em.flush();

//      ---------------------- GroupIds ------------------------

        GroupIds groupIds1 = new GroupIds();
        groupIds1.setGroupId("co.simasoft.models.naif.sgdea");
//      ...................... SGDEA ........................
        DomainModels domainModel1 = new DomainModels();
        domainModel1 = findBean.artifactIdDomainModels("SGDEA",em);
        groupIds1.setDomainModels(domainModel1);
        em.persist(groupIds1);
        em.flush();

//      ---------------------- Entities ------------------------

        Entities entities2 = new Entities();
        entities2.setName("RetencionDocumental");
//      ...................... co.simasoft.models.naif.sgdea ........................
        GroupIds groupId2 = new GroupIds();
        groupId2 = findBean.groupIdGroupIds("co.simasoft.models.naif.sgdea",em);
        entities2.setGroupIds(groupId2);
        em.persist(entities2);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes3 = new Attributes();
        attributes3.setName("year");
        attributes3.setNullable(true);
        attributes3.setSingle(false);
//      ...................... RetencionDocumental ........................
        Entities entity3 = new Entities();
        entity3 = findBean.nameEntities("RetencionDocumental",em);
        attributes3.setEntities(entity3);
//      ...................... Integer ........................
        AttributesTypes attributesTypes4 = new AttributesTypes();
        attributesTypes4 = findBean.nameAttributesTypes("Integer",em);
        attributes3.setAttributesTypes(attributesTypes4);
        em.persist(attributes3);
        em.flush();

        Attributes attributes4 = new Attributes();
        attributes4.setName("nombre");
        attributes4.setNullable(true);
        attributes4.setSingle(false);
//      ...................... RetencionDocumental ........................
        Entities entity5 = new Entities();
        entity5 = findBean.nameEntities("RetencionDocumental",em);
        attributes4.setEntities(entity5);
//      ...................... String ........................
        AttributesTypes attributesTypes6 = new AttributesTypes();
        attributesTypes6 = findBean.nameAttributesTypes("String",em);
        attributes4.setAttributesTypes(attributesTypes6);
        em.persist(attributes4);
        em.flush();

        Entities entities5 = new Entities();
        entities5.setName("TiposDocumentales");
//      ...................... co.simasoft.models.naif.sgdea ........................
        GroupIds groupId7 = new GroupIds();
        groupId7 = findBean.groupIdGroupIds("co.simasoft.models.naif.sgdea",em);
        entities5.setGroupIds(groupId7);
        em.persist(entities5);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes6 = new Attributes();
        attributes6.setName("nombre");
        attributes6.setNullable(true);
        attributes6.setSingle(false);
//      ...................... TiposDocumentales ........................
        Entities entity8 = new Entities();
        entity8 = findBean.nameEntities("TiposDocumentales",em);
        attributes6.setEntities(entity8);
//      ...................... String ........................
        AttributesTypes attributesTypes9 = new AttributesTypes();
        attributesTypes9 = findBean.nameAttributesTypes("String",em);
        attributes6.setAttributesTypes(attributesTypes9);
        em.persist(attributes6);
        em.flush();

        Entities entities7 = new Entities();
        entities7.setName("SoporteDocumental");
//      ...................... co.simasoft.models.naif.sgdea ........................
        GroupIds groupId10 = new GroupIds();
        groupId10 = findBean.groupIdGroupIds("co.simasoft.models.naif.sgdea",em);
        entities7.setGroupIds(groupId10);
        em.persist(entities7);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes8 = new Attributes();
        attributes8.setName("nombre");
        attributes8.setNullable(true);
        attributes8.setSingle(false);
//      ...................... SoporteDocumental ........................
        Entities entity11 = new Entities();
        entity11 = findBean.nameEntities("SoporteDocumental",em);
        attributes8.setEntities(entity11);
//      ...................... String ........................
        AttributesTypes attributesTypes12 = new AttributesTypes();
        attributesTypes12 = findBean.nameAttributesTypes("String",em);
        attributes8.setAttributesTypes(attributesTypes12);
        em.persist(attributes8);
        em.flush();

        Entities entities9 = new Entities();
        entities9.setName("VigenciaFondos");
//      ...................... co.simasoft.models.naif.sgdea ........................
        GroupIds groupId13 = new GroupIds();
        groupId13 = findBean.groupIdGroupIds("co.simasoft.models.naif.sgdea",em);
        entities9.setGroupIds(groupId13);
        em.persist(entities9);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes10 = new Attributes();
        attributes10.setName("nombre");
        attributes10.setNullable(true);
        attributes10.setSingle(false);
//      ...................... VigenciaFondos ........................
        Entities entity14 = new Entities();
        entity14 = findBean.nameEntities("VigenciaFondos",em);
        attributes10.setEntities(entity14);
//      ...................... String ........................
        AttributesTypes attributesTypes15 = new AttributesTypes();
        attributesTypes15 = findBean.nameAttributesTypes("String",em);
        attributes10.setAttributesTypes(attributesTypes15);
        em.persist(attributes10);
        em.flush();

        Attributes attributes11 = new Attributes();
        attributes11.setName("siAbierto");
        attributes11.setNullable(true);
        attributes11.setSingle(false);
//      ...................... VigenciaFondos ........................
        Entities entity16 = new Entities();
        entity16 = findBean.nameEntities("VigenciaFondos",em);
        attributes11.setEntities(entity16);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes17 = new AttributesTypes();
        attributesTypes17 = findBean.nameAttributesTypes("Boolean",em);
        attributes11.setAttributesTypes(attributesTypes17);
        em.persist(attributes11);
        em.flush();

        Attributes attributes12 = new Attributes();
        attributes12.setName("observaciones");
        attributes12.setNullable(true);
        attributes12.setSingle(false);
//      ...................... VigenciaFondos ........................
        Entities entity18 = new Entities();
        entity18 = findBean.nameEntities("VigenciaFondos",em);
        attributes12.setEntities(entity18);
//      ...................... String ........................
        AttributesTypes attributesTypes19 = new AttributesTypes();
        attributesTypes19 = findBean.nameAttributesTypes("String",em);
        attributes12.setAttributesTypes(attributesTypes19);
        em.persist(attributes12);
        em.flush();

        Entities entities13 = new Entities();
        entities13.setName("Personas");
//      ...................... co.simasoft.models.naif.sgdea ........................
        GroupIds groupId20 = new GroupIds();
        groupId20 = findBean.groupIdGroupIds("co.simasoft.models.naif.sgdea",em);
        entities13.setGroupIds(groupId20);
        em.persist(entities13);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes14 = new Attributes();
        attributes14.setName("primerNombre");
        attributes14.setNullable(true);
        attributes14.setSingle(false);
//      ...................... Personas ........................
        Entities entity21 = new Entities();
        entity21 = findBean.nameEntities("Personas",em);
        attributes14.setEntities(entity21);
//      ...................... String ........................
        AttributesTypes attributesTypes22 = new AttributesTypes();
        attributesTypes22 = findBean.nameAttributesTypes("String",em);
        attributes14.setAttributesTypes(attributesTypes22);
        em.persist(attributes14);
        em.flush();

        Attributes attributes15 = new Attributes();
        attributes15.setName("segundoNombre");
        attributes15.setNullable(true);
        attributes15.setSingle(false);
//      ...................... Personas ........................
        Entities entity23 = new Entities();
        entity23 = findBean.nameEntities("Personas",em);
        attributes15.setEntities(entity23);
//      ...................... String ........................
        AttributesTypes attributesTypes24 = new AttributesTypes();
        attributesTypes24 = findBean.nameAttributesTypes("String",em);
        attributes15.setAttributesTypes(attributesTypes24);
        em.persist(attributes15);
        em.flush();

        Attributes attributes16 = new Attributes();
        attributes16.setName("primerApellido");
        attributes16.setNullable(true);
        attributes16.setSingle(false);
//      ...................... Personas ........................
        Entities entity25 = new Entities();
        entity25 = findBean.nameEntities("Personas",em);
        attributes16.setEntities(entity25);
//      ...................... String ........................
        AttributesTypes attributesTypes26 = new AttributesTypes();
        attributesTypes26 = findBean.nameAttributesTypes("String",em);
        attributes16.setAttributesTypes(attributesTypes26);
        em.persist(attributes16);
        em.flush();

        Attributes attributes17 = new Attributes();
        attributes17.setName("segundoApellido");
        attributes17.setNullable(true);
        attributes17.setSingle(false);
//      ...................... Personas ........................
        Entities entity27 = new Entities();
        entity27 = findBean.nameEntities("Personas",em);
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
//      ...................... Personas ........................
        Entities entity29 = new Entities();
        entity29 = findBean.nameEntities("Personas",em);
        attributes18.setEntities(entity29);
//      ...................... String ........................
        AttributesTypes attributesTypes30 = new AttributesTypes();
        attributesTypes30 = findBean.nameAttributesTypes("String",em);
        attributes18.setAttributesTypes(attributesTypes30);
        em.persist(attributes18);
        em.flush();

        Entities entities19 = new Entities();
        entities19.setName("InventarioDocumental");
//      ...................... co.simasoft.models.naif.sgdea ........................
        GroupIds groupId31 = new GroupIds();
        groupId31 = findBean.groupIdGroupIds("co.simasoft.models.naif.sgdea",em);
        entities19.setGroupIds(groupId31);
        em.persist(entities19);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes20 = new Attributes();
        attributes20.setName("fechaEntrega");
        attributes20.setNullable(true);
        attributes20.setSingle(false);
//      ...................... InventarioDocumental ........................
        Entities entity32 = new Entities();
        entity32 = findBean.nameEntities("InventarioDocumental",em);
        attributes20.setEntities(entity32);
//      ...................... Date ........................
        AttributesTypes attributesTypes33 = new AttributesTypes();
        attributesTypes33 = findBean.nameAttributesTypes("Date",em);
        attributes20.setAttributesTypes(attributesTypes33);
        em.persist(attributes20);
        em.flush();

        Attributes attributes21 = new Attributes();
        attributes21.setName("nroTransferencia");
        attributes21.setNullable(true);
        attributes21.setSingle(false);
//      ...................... InventarioDocumental ........................
        Entities entity34 = new Entities();
        entity34 = findBean.nameEntities("InventarioDocumental",em);
        attributes21.setEntities(entity34);
//      ...................... Integer ........................
        AttributesTypes attributesTypes35 = new AttributesTypes();
        attributesTypes35 = findBean.nameAttributesTypes("Integer",em);
        attributes21.setAttributesTypes(attributesTypes35);
        em.persist(attributes21);
        em.flush();

        Attributes attributes22 = new Attributes();
        attributes22.setName("fechaInicial");
        attributes22.setNullable(true);
        attributes22.setSingle(false);
//      ...................... InventarioDocumental ........................
        Entities entity36 = new Entities();
        entity36 = findBean.nameEntities("InventarioDocumental",em);
        attributes22.setEntities(entity36);
//      ...................... Date ........................
        AttributesTypes attributesTypes37 = new AttributesTypes();
        attributesTypes37 = findBean.nameAttributesTypes("Date",em);
        attributes22.setAttributesTypes(attributesTypes37);
        em.persist(attributes22);
        em.flush();

        Attributes attributes23 = new Attributes();
        attributes23.setName("fechaFinal");
        attributes23.setNullable(true);
        attributes23.setSingle(false);
//      ...................... InventarioDocumental ........................
        Entities entity38 = new Entities();
        entity38 = findBean.nameEntities("InventarioDocumental",em);
        attributes23.setEntities(entity38);
//      ...................... Date ........................
        AttributesTypes attributesTypes39 = new AttributesTypes();
        attributesTypes39 = findBean.nameAttributesTypes("Date",em);
        attributes23.setAttributesTypes(attributesTypes39);
        em.persist(attributes23);
        em.flush();

        Attributes attributes24 = new Attributes();
        attributes24.setName("folios");
        attributes24.setNullable(true);
        attributes24.setSingle(false);
//      ...................... InventarioDocumental ........................
        Entities entity40 = new Entities();
        entity40 = findBean.nameEntities("InventarioDocumental",em);
        attributes24.setEntities(entity40);
//      ...................... Integer ........................
        AttributesTypes attributesTypes41 = new AttributesTypes();
        attributesTypes41 = findBean.nameAttributesTypes("Integer",em);
        attributes24.setAttributesTypes(attributesTypes41);
        em.persist(attributes24);
        em.flush();

        Attributes attributes25 = new Attributes();
        attributes25.setName("cantidad");
        attributes25.setNullable(true);
        attributes25.setSingle(false);
//      ...................... InventarioDocumental ........................
        Entities entity42 = new Entities();
        entity42 = findBean.nameEntities("InventarioDocumental",em);
        attributes25.setEntities(entity42);
//      ...................... Integer ........................
        AttributesTypes attributesTypes43 = new AttributesTypes();
        attributesTypes43 = findBean.nameAttributesTypes("Integer",em);
        attributes25.setAttributesTypes(attributesTypes43);
        em.persist(attributes25);
        em.flush();

        Attributes attributes26 = new Attributes();
        attributes26.setName("fechaDepuracion");
        attributes26.setNullable(true);
        attributes26.setSingle(false);
//      ...................... InventarioDocumental ........................
        Entities entity44 = new Entities();
        entity44 = findBean.nameEntities("InventarioDocumental",em);
        attributes26.setEntities(entity44);
//      ...................... Date ........................
        AttributesTypes attributesTypes45 = new AttributesTypes();
        attributesTypes45 = findBean.nameAttributesTypes("Date",em);
        attributes26.setAttributesTypes(attributesTypes45);
        em.persist(attributes26);
        em.flush();

        Attributes attributes27 = new Attributes();
        attributes27.setName("disposcionFinal");
        attributes27.setNullable(true);
        attributes27.setSingle(false);
//      ...................... InventarioDocumental ........................
        Entities entity46 = new Entities();
        entity46 = findBean.nameEntities("InventarioDocumental",em);
        attributes27.setEntities(entity46);
//      ...................... String ........................
        AttributesTypes attributesTypes47 = new AttributesTypes();
        attributesTypes47 = findBean.nameAttributesTypes("String",em);
        attributes27.setAttributesTypes(attributesTypes47);
        em.persist(attributes27);
        em.flush();

        Entities entities28 = new Entities();
        entities28.setName("Secciones");
//      ...................... co.simasoft.models.naif.sgdea ........................
        GroupIds groupId48 = new GroupIds();
        groupId48 = findBean.groupIdGroupIds("co.simasoft.models.naif.sgdea",em);
        entities28.setGroupIds(groupId48);
        em.persist(entities28);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes29 = new Attributes();
        attributes29.setName("nombre");
        attributes29.setNullable(true);
        attributes29.setSingle(false);
//      ...................... Secciones ........................
        Entities entity49 = new Entities();
        entity49 = findBean.nameEntities("Secciones",em);
        attributes29.setEntities(entity49);
//      ...................... String ........................
        AttributesTypes attributesTypes50 = new AttributesTypes();
        attributesTypes50 = findBean.nameAttributesTypes("String",em);
        attributes29.setAttributesTypes(attributesTypes50);
        em.persist(attributes29);
        em.flush();

        Attributes attributes30 = new Attributes();
        attributes30.setName("codigo");
        attributes30.setNullable(true);
        attributes30.setSingle(false);
//      ...................... Secciones ........................
        Entities entity51 = new Entities();
        entity51 = findBean.nameEntities("Secciones",em);
        attributes30.setEntities(entity51);
//      ...................... String ........................
        AttributesTypes attributesTypes52 = new AttributesTypes();
        attributesTypes52 = findBean.nameAttributesTypes("String",em);
        attributes30.setAttributesTypes(attributesTypes52);
        em.persist(attributes30);
        em.flush();

        Attributes attributes31 = new Attributes();
        attributes31.setName("observaciones");
        attributes31.setNullable(true);
        attributes31.setSingle(false);
//      ...................... Secciones ........................
        Entities entity53 = new Entities();
        entity53 = findBean.nameEntities("Secciones",em);
        attributes31.setEntities(entity53);
//      ...................... String ........................
        AttributesTypes attributesTypes54 = new AttributesTypes();
        attributesTypes54 = findBean.nameAttributesTypes("String",em);
        attributes31.setAttributesTypes(attributesTypes54);
        em.persist(attributes31);
        em.flush();

        Attributes attributes32 = new Attributes();
        attributes32.setName("nroTransferencias");
        attributes32.setNullable(true);
        attributes32.setSingle(false);
//      ...................... Secciones ........................
        Entities entity55 = new Entities();
        entity55 = findBean.nameEntities("Secciones",em);
        attributes32.setEntities(entity55);
//      ...................... Integer ........................
        AttributesTypes attributesTypes56 = new AttributesTypes();
        attributesTypes56 = findBean.nameAttributesTypes("Integer",em);
        attributes32.setAttributesTypes(attributesTypes56);
        em.persist(attributes32);
        em.flush();

        Entities entities33 = new Entities();
        entities33.setName("UnidadesConservacion");
//      ...................... co.simasoft.models.naif.sgdea ........................
        GroupIds groupId57 = new GroupIds();
        groupId57 = findBean.groupIdGroupIds("co.simasoft.models.naif.sgdea",em);
        entities33.setGroupIds(groupId57);
        em.persist(entities33);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes34 = new Attributes();
        attributes34.setName("nombre");
        attributes34.setNullable(true);
        attributes34.setSingle(false);
//      ...................... UnidadesConservacion ........................
        Entities entity58 = new Entities();
        entity58 = findBean.nameEntities("UnidadesConservacion",em);
        attributes34.setEntities(entity58);
//      ...................... String ........................
        AttributesTypes attributesTypes59 = new AttributesTypes();
        attributesTypes59 = findBean.nameAttributesTypes("String",em);
        attributes34.setAttributesTypes(attributesTypes59);
        em.persist(attributes34);
        em.flush();

        Entities entities35 = new Entities();
        entities35.setName("Empresas");
//      ...................... co.simasoft.models.naif.sgdea ........................
        GroupIds groupId60 = new GroupIds();
        groupId60 = findBean.groupIdGroupIds("co.simasoft.models.naif.sgdea",em);
        entities35.setGroupIds(groupId60);
        em.persist(entities35);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes36 = new Attributes();
        attributes36.setName("nombre");
        attributes36.setNullable(true);
        attributes36.setSingle(false);
//      ...................... Empresas ........................
        Entities entity61 = new Entities();
        entity61 = findBean.nameEntities("Empresas",em);
        attributes36.setEntities(entity61);
//      ...................... String ........................
        AttributesTypes attributesTypes62 = new AttributesTypes();
        attributesTypes62 = findBean.nameAttributesTypes("String",em);
        attributes36.setAttributesTypes(attributesTypes62);
        em.persist(attributes36);
        em.flush();

        Attributes attributes37 = new Attributes();
        attributes37.setName("nit");
        attributes37.setNullable(true);
        attributes37.setSingle(false);
//      ...................... Empresas ........................
        Entities entity63 = new Entities();
        entity63 = findBean.nameEntities("Empresas",em);
        attributes37.setEntities(entity63);
//      ...................... String ........................
        AttributesTypes attributesTypes64 = new AttributesTypes();
        attributesTypes64 = findBean.nameAttributesTypes("String",em);
        attributes37.setAttributesTypes(attributesTypes64);
        em.persist(attributes37);
        em.flush();

        Attributes attributes38 = new Attributes();
        attributes38.setName("direccion");
        attributes38.setNullable(true);
        attributes38.setSingle(false);
//      ...................... Empresas ........................
        Entities entity65 = new Entities();
        entity65 = findBean.nameEntities("Empresas",em);
        attributes38.setEntities(entity65);
//      ...................... String ........................
        AttributesTypes attributesTypes66 = new AttributesTypes();
        attributesTypes66 = findBean.nameAttributesTypes("String",em);
        attributes38.setAttributesTypes(attributesTypes66);
        em.persist(attributes38);
        em.flush();

        Attributes attributes39 = new Attributes();
        attributes39.setName("link");
        attributes39.setNullable(true);
        attributes39.setSingle(false);
//      ...................... Empresas ........................
        Entities entity67 = new Entities();
        entity67 = findBean.nameEntities("Empresas",em);
        attributes39.setEntities(entity67);
//      ...................... String ........................
        AttributesTypes attributesTypes68 = new AttributesTypes();
        attributesTypes68 = findBean.nameAttributesTypes("String",em);
        attributes39.setAttributesTypes(attributesTypes68);
        em.persist(attributes39);
        em.flush();

        Attributes attributes40 = new Attributes();
        attributes40.setName("tels");
        attributes40.setNullable(true);
        attributes40.setSingle(false);
//      ...................... Empresas ........................
        Entities entity69 = new Entities();
        entity69 = findBean.nameEntities("Empresas",em);
        attributes40.setEntities(entity69);
//      ...................... String ........................
        AttributesTypes attributesTypes70 = new AttributesTypes();
        attributesTypes70 = findBean.nameAttributesTypes("String",em);
        attributes40.setAttributesTypes(attributesTypes70);
        em.persist(attributes40);
        em.flush();

        Attributes attributes41 = new Attributes();
        attributes41.setName("email");
        attributes41.setNullable(true);
        attributes41.setSingle(false);
//      ...................... Empresas ........................
        Entities entity71 = new Entities();
        entity71 = findBean.nameEntities("Empresas",em);
        attributes41.setEntities(entity71);
//      ...................... String ........................
        AttributesTypes attributesTypes72 = new AttributesTypes();
        attributesTypes72 = findBean.nameAttributesTypes("String",em);
        attributes41.setAttributesTypes(attributesTypes72);
        em.persist(attributes41);
        em.flush();

        Entities entities42 = new Entities();
        entities42.setName("FrecuenciasConsulta");
//      ...................... co.simasoft.models.naif.sgdea ........................
        GroupIds groupId73 = new GroupIds();
        groupId73 = findBean.groupIdGroupIds("co.simasoft.models.naif.sgdea",em);
        entities42.setGroupIds(groupId73);
        em.persist(entities42);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes43 = new Attributes();
        attributes43.setName("nombre");
        attributes43.setNullable(true);
        attributes43.setSingle(false);
//      ...................... FrecuenciasConsulta ........................
        Entities entity74 = new Entities();
        entity74 = findBean.nameEntities("FrecuenciasConsulta",em);
        attributes43.setEntities(entity74);
//      ...................... String ........................
        AttributesTypes attributesTypes75 = new AttributesTypes();
        attributesTypes75 = findBean.nameAttributesTypes("String",em);
        attributes43.setAttributesTypes(attributesTypes75);
        em.persist(attributes43);
        em.flush();

        Entities entities44 = new Entities();
        entities44.setName("FinalidadInventario");
//      ...................... co.simasoft.models.naif.sgdea ........................
        GroupIds groupId76 = new GroupIds();
        groupId76 = findBean.groupIdGroupIds("co.simasoft.models.naif.sgdea",em);
        entities44.setGroupIds(groupId76);
        em.persist(entities44);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes45 = new Attributes();
        attributes45.setName("nombre");
        attributes45.setNullable(true);
        attributes45.setSingle(false);
//      ...................... FinalidadInventario ........................
        Entities entity77 = new Entities();
        entity77 = findBean.nameEntities("FinalidadInventario",em);
        attributes45.setEntities(entity77);
//      ...................... String ........................
        AttributesTypes attributesTypes78 = new AttributesTypes();
        attributesTypes78 = findBean.nameAttributesTypes("String",em);
        attributes45.setAttributesTypes(attributesTypes78);
        em.persist(attributes45);
        em.flush();

        Entities entities46 = new Entities();
        entities46.setName("FondosDocumentales");
//      ...................... co.simasoft.models.naif.sgdea ........................
        GroupIds groupId79 = new GroupIds();
        groupId79 = findBean.groupIdGroupIds("co.simasoft.models.naif.sgdea",em);
        entities46.setGroupIds(groupId79);
        em.persist(entities46);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes47 = new Attributes();
        attributes47.setName("nombre");
        attributes47.setNullable(true);
        attributes47.setSingle(false);
//      ...................... FondosDocumentales ........................
        Entities entity80 = new Entities();
        entity80 = findBean.nameEntities("FondosDocumentales",em);
        attributes47.setEntities(entity80);
//      ...................... String ........................
        AttributesTypes attributesTypes81 = new AttributesTypes();
        attributesTypes81 = findBean.nameAttributesTypes("String",em);
        attributes47.setAttributesTypes(attributesTypes81);
        em.persist(attributes47);
        em.flush();

        Attributes attributes48 = new Attributes();
        attributes48.setName("fechaCreacion");
        attributes48.setNullable(true);
        attributes48.setSingle(false);
//      ...................... FondosDocumentales ........................
        Entities entity82 = new Entities();
        entity82 = findBean.nameEntities("FondosDocumentales",em);
        attributes48.setEntities(entity82);
//      ...................... Date ........................
        AttributesTypes attributesTypes83 = new AttributesTypes();
        attributesTypes83 = findBean.nameAttributesTypes("Date",em);
        attributes48.setAttributesTypes(attributesTypes83);
        em.persist(attributes48);
        em.flush();

        Attributes attributes49 = new Attributes();
        attributes49.setName("fechaTerminacion");
        attributes49.setNullable(true);
        attributes49.setSingle(false);
//      ...................... FondosDocumentales ........................
        Entities entity84 = new Entities();
        entity84 = findBean.nameEntities("FondosDocumentales",em);
        attributes49.setEntities(entity84);
//      ...................... Date ........................
        AttributesTypes attributesTypes85 = new AttributesTypes();
        attributesTypes85 = findBean.nameAttributesTypes("Date",em);
        attributes49.setAttributesTypes(attributesTypes85);
        em.persist(attributes49);
        em.flush();

        Attributes attributes50 = new Attributes();
        attributes50.setName("disposiciones");
        attributes50.setNullable(true);
        attributes50.setSingle(false);
//      ...................... FondosDocumentales ........................
        Entities entity86 = new Entities();
        entity86 = findBean.nameEntities("FondosDocumentales",em);
        attributes50.setEntities(entity86);
//      ...................... String ........................
        AttributesTypes attributesTypes87 = new AttributesTypes();
        attributesTypes87 = findBean.nameAttributesTypes("String",em);
        attributes50.setAttributesTypes(attributesTypes87);
        em.persist(attributes50);
        em.flush();

        Attributes attributes51 = new Attributes();
        attributes51.setName("organismos");
        attributes51.setNullable(true);
        attributes51.setSingle(false);
//      ...................... FondosDocumentales ........................
        Entities entity88 = new Entities();
        entity88 = findBean.nameEntities("FondosDocumentales",em);
        attributes51.setEntities(entity88);
//      ...................... String ........................
        AttributesTypes attributesTypes89 = new AttributesTypes();
        attributesTypes89 = findBean.nameAttributesTypes("String",em);
        attributes51.setAttributesTypes(attributesTypes89);
        em.persist(attributes51);
        em.flush();

        Entities entities52 = new Entities();
        entities52.setName("DisposicionFinal");
//      ...................... co.simasoft.models.naif.sgdea ........................
        GroupIds groupId90 = new GroupIds();
        groupId90 = findBean.groupIdGroupIds("co.simasoft.models.naif.sgdea",em);
        entities52.setGroupIds(groupId90);
        em.persist(entities52);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes53 = new Attributes();
        attributes53.setName("nombre");
        attributes53.setNullable(true);
        attributes53.setSingle(false);
//      ...................... DisposicionFinal ........................
        Entities entity91 = new Entities();
        entity91 = findBean.nameEntities("DisposicionFinal",em);
        attributes53.setEntities(entity91);
//      ...................... String ........................
        AttributesTypes attributesTypes92 = new AttributesTypes();
        attributesTypes92 = findBean.nameAttributesTypes("String",em);
        attributes53.setAttributesTypes(attributesTypes92);
        em.persist(attributes53);
        em.flush();

        Entities entities54 = new Entities();
        entities54.setName("UnidadesDocumentales");
//      ...................... co.simasoft.models.naif.sgdea ........................
        GroupIds groupId93 = new GroupIds();
        groupId93 = findBean.groupIdGroupIds("co.simasoft.models.naif.sgdea",em);
        entities54.setGroupIds(groupId93);
        em.persist(entities54);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes55 = new Attributes();
        attributes55.setName("nombre");
        attributes55.setNullable(true);
        attributes55.setSingle(false);
//      ...................... UnidadesDocumentales ........................
        Entities entity94 = new Entities();
        entity94 = findBean.nameEntities("UnidadesDocumentales",em);
        attributes55.setEntities(entity94);
//      ...................... String ........................
        AttributesTypes attributesTypes95 = new AttributesTypes();
        attributesTypes95 = findBean.nameAttributesTypes("String",em);
        attributes55.setAttributesTypes(attributesTypes95);
        em.persist(attributes55);
        em.flush();

        Entities entities56 = new Entities();
        entities56.setName("Series");
//      ...................... co.simasoft.models.naif.sgdea ........................
        GroupIds groupId96 = new GroupIds();
        groupId96 = findBean.groupIdGroupIds("co.simasoft.models.naif.sgdea",em);
        entities56.setGroupIds(groupId96);
        em.persist(entities56);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes57 = new Attributes();
        attributes57.setName("nombre");
        attributes57.setNullable(true);
        attributes57.setSingle(false);
//      ...................... Series ........................
        Entities entity97 = new Entities();
        entity97 = findBean.nameEntities("Series",em);
        attributes57.setEntities(entity97);
//      ...................... String ........................
        AttributesTypes attributesTypes98 = new AttributesTypes();
        attributesTypes98 = findBean.nameAttributesTypes("String",em);
        attributes57.setAttributesTypes(attributesTypes98);
        em.persist(attributes57);
        em.flush();

        Attributes attributes58 = new Attributes();
        attributes58.setName("codigo");
        attributes58.setNullable(true);
        attributes58.setSingle(false);
//      ...................... Series ........................
        Entities entity99 = new Entities();
        entity99 = findBean.nameEntities("Series",em);
        attributes58.setEntities(entity99);
//      ...................... String ........................
        AttributesTypes attributesTypes100 = new AttributesTypes();
        attributesTypes100 = findBean.nameAttributesTypes("String",em);
        attributes58.setAttributesTypes(attributesTypes100);
        em.persist(attributes58);
        em.flush();

        Attributes attributes59 = new Attributes();
        attributes59.setName("observaciones");
        attributes59.setNullable(true);
        attributes59.setSingle(false);
//      ...................... Series ........................
        Entities entity101 = new Entities();
        entity101 = findBean.nameEntities("Series",em);
        attributes59.setEntities(entity101);
//      ...................... String ........................
        AttributesTypes attributesTypes102 = new AttributesTypes();
        attributesTypes102 = findBean.nameAttributesTypes("String",em);
        attributes59.setAttributesTypes(attributesTypes102);
        em.persist(attributes59);
        em.flush();

        Entities entities60 = new Entities();
        entities60.setName("Trd");
//      ...................... co.simasoft.models.naif.sgdea ........................
        GroupIds groupId103 = new GroupIds();
        groupId103 = findBean.groupIdGroupIds("co.simasoft.models.naif.sgdea",em);
        entities60.setGroupIds(groupId103);
        em.persist(entities60);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes61 = new Attributes();
        attributes61.setName("procedimientos");
        attributes61.setNullable(true);
        attributes61.setSingle(false);
//      ...................... Trd ........................
        Entities entity104 = new Entities();
        entity104 = findBean.nameEntities("Trd",em);
        attributes61.setEntities(entity104);
//      ...................... String ........................
        AttributesTypes attributesTypes105 = new AttributesTypes();
        attributesTypes105 = findBean.nameAttributesTypes("String",em);
        attributes61.setAttributesTypes(attributesTypes105);
        em.persist(attributes61);
        em.flush();

        Attributes attributes62 = new Attributes();
        attributes62.setName("observaciones");
        attributes62.setNullable(true);
        attributes62.setSingle(false);
//      ...................... Trd ........................
        Entities entity106 = new Entities();
        entity106 = findBean.nameEntities("Trd",em);
        attributes62.setEntities(entity106);
//      ...................... String ........................
        AttributesTypes attributesTypes107 = new AttributesTypes();
        attributesTypes107 = findBean.nameAttributesTypes("String",em);
        attributes62.setAttributesTypes(attributesTypes107);
        em.persist(attributes62);
        em.flush();

//      ---------------------- Relationships ------------------------

/*
UnidadesDocumentales 1..* InventarioDocumental
Empresas 1..* FondosDocumentales
UnidadesDocumentales *..* UnidadesConservacion
Series *..* Secciones
UnidadesConservacion *..* UnidadesDocumentales
Series 1..* Series
SoporteDocumental *..* Series
Secciones 1..* Secciones
Trd 1..* Series
FrecuenciasConsulta 1..* UnidadesDocumentales
Series *..* TiposDocumentales
RetencionDocumental 1..* Trd
FondosDocumentales 1..* Secciones
FinalidadInventario 1..* InventarioDocumental
VigenciaFondos 1..* FondosDocumentales
UnidadesDocumentales *..* Series
Secciones *..* Series
Personas 1..* Secciones
RetencionDocumental 1..* Trd
Series *..* SoporteDocumental
TiposDocumentales *..* Series
Series *..* UnidadesDocumentales
DisposicionFinal 1..* Series
*/
        Relationships relationships1 = new Relationships();
        relationships1.setOptionality(true);
        relationships1.setIsEmbedded(false);
//      ...................... UnidadesDocumentales ........................
        Entities entities108 = new Entities();
        entities108 = findBean.nameEntities("UnidadesDocumentales",em);
        relationships1.setFrom(entities108);
//      ...................... InventarioDocumental ........................
        Entities entities109 = new Entities();
        entities109 = findBean.nameEntities("InventarioDocumental",em);
        relationships1.setTo(entities109);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities110 = new Cardinalities();
        cardinalities110 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships1.setCardinalities(cardinalities110);
        em.persist(relationships1);
        em.flush();

        Relationships relationships2 = new Relationships();
        relationships2.setOptionality(true);
        relationships2.setIsEmbedded(false);
//      ...................... Empresas ........................
        Entities entities111 = new Entities();
        entities111 = findBean.nameEntities("Empresas",em);
        relationships2.setFrom(entities111);
//      ...................... FondosDocumentales ........................
        Entities entities112 = new Entities();
        entities112 = findBean.nameEntities("FondosDocumentales",em);
        relationships2.setTo(entities112);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities113 = new Cardinalities();
        cardinalities113 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships2.setCardinalities(cardinalities113);
        em.persist(relationships2);
        em.flush();

        Relationships relationships3 = new Relationships();
        relationships3.setOptionality(true);
        relationships3.setIsEmbedded(false);
//      ...................... UnidadesDocumentales ........................
        Entities entities114 = new Entities();
        entities114 = findBean.nameEntities("UnidadesDocumentales",em);
        relationships3.setFrom(entities114);
//      ...................... UnidadesConservacion ........................
        Entities entities115 = new Entities();
        entities115 = findBean.nameEntities("UnidadesConservacion",em);
        relationships3.setTo(entities115);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities116 = new Cardinalities();
        cardinalities116 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships3.setCardinalities(cardinalities116);
        em.persist(relationships3);
        em.flush();

        Relationships relationships4 = new Relationships();
        relationships4.setOptionality(true);
        relationships4.setIsEmbedded(false);
//      ...................... Series ........................
        Entities entities117 = new Entities();
        entities117 = findBean.nameEntities("Series",em);
        relationships4.setFrom(entities117);
//      ...................... Secciones ........................
        Entities entities118 = new Entities();
        entities118 = findBean.nameEntities("Secciones",em);
        relationships4.setTo(entities118);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities119 = new Cardinalities();
        cardinalities119 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships4.setCardinalities(cardinalities119);
        em.persist(relationships4);
        em.flush();

        Relationships relationships5 = new Relationships();
        relationships5.setOptionality(true);
        relationships5.setIsEmbedded(false);
//      ...................... UnidadesConservacion ........................
        Entities entities120 = new Entities();
        entities120 = findBean.nameEntities("UnidadesConservacion",em);
        relationships5.setFrom(entities120);
//      ...................... UnidadesDocumentales ........................
        Entities entities121 = new Entities();
        entities121 = findBean.nameEntities("UnidadesDocumentales",em);
        relationships5.setTo(entities121);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities122 = new Cardinalities();
        cardinalities122 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships5.setCardinalities(cardinalities122);
        em.persist(relationships5);
        em.flush();

        Relationships relationships6 = new Relationships();
        relationships6.setOptionality(true);
        relationships6.setIsEmbedded(false);
//      ...................... Series ........................
        Entities entities123 = new Entities();
        entities123 = findBean.nameEntities("Series",em);
        relationships6.setFrom(entities123);
//      ...................... Series ........................
        Entities entities124 = new Entities();
        entities124 = findBean.nameEntities("Series",em);
        relationships6.setTo(entities124);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities125 = new Cardinalities();
        cardinalities125 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships6.setCardinalities(cardinalities125);
        em.persist(relationships6);
        em.flush();

        Relationships relationships7 = new Relationships();
        relationships7.setOptionality(true);
        relationships7.setIsEmbedded(false);
//      ...................... SoporteDocumental ........................
        Entities entities126 = new Entities();
        entities126 = findBean.nameEntities("SoporteDocumental",em);
        relationships7.setFrom(entities126);
//      ...................... Series ........................
        Entities entities127 = new Entities();
        entities127 = findBean.nameEntities("Series",em);
        relationships7.setTo(entities127);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities128 = new Cardinalities();
        cardinalities128 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships7.setCardinalities(cardinalities128);
        em.persist(relationships7);
        em.flush();

        Relationships relationships8 = new Relationships();
        relationships8.setOptionality(true);
        relationships8.setIsEmbedded(false);
//      ...................... Secciones ........................
        Entities entities129 = new Entities();
        entities129 = findBean.nameEntities("Secciones",em);
        relationships8.setFrom(entities129);
//      ...................... Secciones ........................
        Entities entities130 = new Entities();
        entities130 = findBean.nameEntities("Secciones",em);
        relationships8.setTo(entities130);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities131 = new Cardinalities();
        cardinalities131 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships8.setCardinalities(cardinalities131);
        em.persist(relationships8);
        em.flush();

        Relationships relationships9 = new Relationships();
        relationships9.setOptionality(true);
        relationships9.setIsEmbedded(false);
//      ...................... Trd ........................
        Entities entities132 = new Entities();
        entities132 = findBean.nameEntities("Trd",em);
        relationships9.setFrom(entities132);
//      ...................... Series ........................
        Entities entities133 = new Entities();
        entities133 = findBean.nameEntities("Series",em);
        relationships9.setTo(entities133);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities134 = new Cardinalities();
        cardinalities134 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships9.setCardinalities(cardinalities134);
        em.persist(relationships9);
        em.flush();

        Relationships relationships10 = new Relationships();
        relationships10.setOptionality(true);
        relationships10.setIsEmbedded(false);
//      ...................... FrecuenciasConsulta ........................
        Entities entities135 = new Entities();
        entities135 = findBean.nameEntities("FrecuenciasConsulta",em);
        relationships10.setFrom(entities135);
//      ...................... UnidadesDocumentales ........................
        Entities entities136 = new Entities();
        entities136 = findBean.nameEntities("UnidadesDocumentales",em);
        relationships10.setTo(entities136);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities137 = new Cardinalities();
        cardinalities137 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships10.setCardinalities(cardinalities137);
        em.persist(relationships10);
        em.flush();

        Relationships relationships11 = new Relationships();
        relationships11.setOptionality(false);
        relationships11.setIsEmbedded(false);
//      ...................... Series ........................
        Entities entities138 = new Entities();
        entities138 = findBean.nameEntities("Series",em);
        relationships11.setFrom(entities138);
//      ...................... TiposDocumentales ........................
        Entities entities139 = new Entities();
        entities139 = findBean.nameEntities("TiposDocumentales",em);
        relationships11.setTo(entities139);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities140 = new Cardinalities();
        cardinalities140 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships11.setCardinalities(cardinalities140);
        em.persist(relationships11);
        em.flush();

        Relationships relationships12 = new Relationships();
        relationships12.setOptionality(true);
        relationships12.setIsEmbedded(false);
//      ...................... RetencionDocumental ........................
        Entities entities141 = new Entities();
        entities141 = findBean.nameEntities("RetencionDocumental",em);
        relationships12.setFrom(entities141);
//      ...................... Trd ........................
        Entities entities142 = new Entities();
        entities142 = findBean.nameEntities("Trd",em);
        relationships12.setTo(entities142);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities143 = new Cardinalities();
        cardinalities143 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships12.setCardinalities(cardinalities143);
        em.persist(relationships12);
        em.flush();

        Relationships relationships13 = new Relationships();
        relationships13.setOptionality(true);
        relationships13.setIsEmbedded(false);
//      ...................... FondosDocumentales ........................
        Entities entities144 = new Entities();
        entities144 = findBean.nameEntities("FondosDocumentales",em);
        relationships13.setFrom(entities144);
//      ...................... Secciones ........................
        Entities entities145 = new Entities();
        entities145 = findBean.nameEntities("Secciones",em);
        relationships13.setTo(entities145);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities146 = new Cardinalities();
        cardinalities146 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships13.setCardinalities(cardinalities146);
        em.persist(relationships13);
        em.flush();

        Relationships relationships14 = new Relationships();
        relationships14.setOptionality(true);
        relationships14.setIsEmbedded(false);
//      ...................... FinalidadInventario ........................
        Entities entities147 = new Entities();
        entities147 = findBean.nameEntities("FinalidadInventario",em);
        relationships14.setFrom(entities147);
//      ...................... InventarioDocumental ........................
        Entities entities148 = new Entities();
        entities148 = findBean.nameEntities("InventarioDocumental",em);
        relationships14.setTo(entities148);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities149 = new Cardinalities();
        cardinalities149 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships14.setCardinalities(cardinalities149);
        em.persist(relationships14);
        em.flush();

        Relationships relationships15 = new Relationships();
        relationships15.setOptionality(true);
        relationships15.setIsEmbedded(false);
//      ...................... VigenciaFondos ........................
        Entities entities150 = new Entities();
        entities150 = findBean.nameEntities("VigenciaFondos",em);
        relationships15.setFrom(entities150);
//      ...................... FondosDocumentales ........................
        Entities entities151 = new Entities();
        entities151 = findBean.nameEntities("FondosDocumentales",em);
        relationships15.setTo(entities151);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities152 = new Cardinalities();
        cardinalities152 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships15.setCardinalities(cardinalities152);
        em.persist(relationships15);
        em.flush();

        Relationships relationships16 = new Relationships();
        relationships16.setOptionality(true);
        relationships16.setIsEmbedded(false);
//      ...................... UnidadesDocumentales ........................
        Entities entities153 = new Entities();
        entities153 = findBean.nameEntities("UnidadesDocumentales",em);
        relationships16.setFrom(entities153);
//      ...................... Series ........................
        Entities entities154 = new Entities();
        entities154 = findBean.nameEntities("Series",em);
        relationships16.setTo(entities154);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities155 = new Cardinalities();
        cardinalities155 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships16.setCardinalities(cardinalities155);
        em.persist(relationships16);
        em.flush();

        Relationships relationships17 = new Relationships();
        relationships17.setOptionality(true);
        relationships17.setIsEmbedded(false);
//      ...................... Secciones ........................
        Entities entities156 = new Entities();
        entities156 = findBean.nameEntities("Secciones",em);
        relationships17.setFrom(entities156);
//      ...................... Series ........................
        Entities entities157 = new Entities();
        entities157 = findBean.nameEntities("Series",em);
        relationships17.setTo(entities157);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities158 = new Cardinalities();
        cardinalities158 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships17.setCardinalities(cardinalities158);
        em.persist(relationships17);
        em.flush();

        Relationships relationships18 = new Relationships();
        relationships18.setOptionality(true);
        relationships18.setIsEmbedded(false);
//      ...................... Personas ........................
        Entities entities159 = new Entities();
        entities159 = findBean.nameEntities("Personas",em);
        relationships18.setFrom(entities159);
//      ...................... Secciones ........................
        Entities entities160 = new Entities();
        entities160 = findBean.nameEntities("Secciones",em);
        relationships18.setTo(entities160);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities161 = new Cardinalities();
        cardinalities161 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships18.setCardinalities(cardinalities161);
        em.persist(relationships18);
        em.flush();

        Relationships relationships19 = new Relationships();
        relationships19.setOptionality(true);
        relationships19.setIsEmbedded(false);
//      ...................... RetencionDocumental ........................
        Entities entities162 = new Entities();
        entities162 = findBean.nameEntities("RetencionDocumental",em);
        relationships19.setFrom(entities162);
//      ...................... Trd ........................
        Entities entities163 = new Entities();
        entities163 = findBean.nameEntities("Trd",em);
        relationships19.setTo(entities163);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities164 = new Cardinalities();
        cardinalities164 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships19.setCardinalities(cardinalities164);
        em.persist(relationships19);
        em.flush();

        Relationships relationships20 = new Relationships();
        relationships20.setOptionality(true);
        relationships20.setIsEmbedded(false);
//      ...................... Series ........................
        Entities entities165 = new Entities();
        entities165 = findBean.nameEntities("Series",em);
        relationships20.setFrom(entities165);
//      ...................... SoporteDocumental ........................
        Entities entities166 = new Entities();
        entities166 = findBean.nameEntities("SoporteDocumental",em);
        relationships20.setTo(entities166);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities167 = new Cardinalities();
        cardinalities167 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships20.setCardinalities(cardinalities167);
        em.persist(relationships20);
        em.flush();

        Relationships relationships21 = new Relationships();
        relationships21.setOptionality(false);
        relationships21.setIsEmbedded(false);
//      ...................... TiposDocumentales ........................
        Entities entities168 = new Entities();
        entities168 = findBean.nameEntities("TiposDocumentales",em);
        relationships21.setFrom(entities168);
//      ...................... Series ........................
        Entities entities169 = new Entities();
        entities169 = findBean.nameEntities("Series",em);
        relationships21.setTo(entities169);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities170 = new Cardinalities();
        cardinalities170 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships21.setCardinalities(cardinalities170);
        em.persist(relationships21);
        em.flush();

        Relationships relationships22 = new Relationships();
        relationships22.setOptionality(true);
        relationships22.setIsEmbedded(false);
//      ...................... Series ........................
        Entities entities171 = new Entities();
        entities171 = findBean.nameEntities("Series",em);
        relationships22.setFrom(entities171);
//      ...................... UnidadesDocumentales ........................
        Entities entities172 = new Entities();
        entities172 = findBean.nameEntities("UnidadesDocumentales",em);
        relationships22.setTo(entities172);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities173 = new Cardinalities();
        cardinalities173 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships22.setCardinalities(cardinalities173);
        em.persist(relationships22);
        em.flush();

        Relationships relationships23 = new Relationships();
        relationships23.setOptionality(true);
        relationships23.setIsEmbedded(false);
//      ...................... DisposicionFinal ........................
        Entities entities174 = new Entities();
        entities174 = findBean.nameEntities("DisposicionFinal",em);
        relationships23.setFrom(entities174);
//      ...................... Series ........................
        Entities entities175 = new Entities();
        entities175 = findBean.nameEntities("Series",em);
        relationships23.setTo(entities175);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities176 = new Cardinalities();
        cardinalities176 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships23.setCardinalities(cardinalities176);
        em.persist(relationships23);
        em.flush();

    } // data()

} // SGDEA
