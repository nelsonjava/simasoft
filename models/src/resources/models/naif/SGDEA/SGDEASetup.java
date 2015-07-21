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
        entities2.setName("UnidadesConservacion");
//      ...................... co.simasoft.models.naif.sgdea ........................
        GroupIds groupId2 = new GroupIds();
        groupId2 = findBean.groupIdGroupIds("co.simasoft.models.naif.sgdea",em);
        entities2.setGroupIds(groupId2);
        em.persist(entities2);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes3 = new Attributes();
        attributes3.setName("nombre");
        attributes3.setNullable(true);
        attributes3.setSingle(false);
//      ...................... UnidadesConservacion ........................
        Entities entity3 = new Entities();
        entity3 = findBean.nameEntities("UnidadesConservacion",em);
        attributes3.setEntities(entity3);
//      ...................... String ........................
        AttributesTypes attributesTypes4 = new AttributesTypes();
        attributesTypes4 = findBean.nameAttributesTypes("String",em);
        attributes3.setAttributesTypes(attributesTypes4);
        em.persist(attributes3);
        em.flush();

        Entities entities4 = new Entities();
        entities4.setName("TiposDocumentales");
//      ...................... co.simasoft.models.naif.sgdea ........................
        GroupIds groupId5 = new GroupIds();
        groupId5 = findBean.groupIdGroupIds("co.simasoft.models.naif.sgdea",em);
        entities4.setGroupIds(groupId5);
        em.persist(entities4);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes5 = new Attributes();
        attributes5.setName("nombre");
        attributes5.setNullable(true);
        attributes5.setSingle(false);
//      ...................... TiposDocumentales ........................
        Entities entity6 = new Entities();
        entity6 = findBean.nameEntities("TiposDocumentales",em);
        attributes5.setEntities(entity6);
//      ...................... String ........................
        AttributesTypes attributesTypes7 = new AttributesTypes();
        attributesTypes7 = findBean.nameAttributesTypes("String",em);
        attributes5.setAttributesTypes(attributesTypes7);
        em.persist(attributes5);
        em.flush();

        Entities entities6 = new Entities();
        entities6.setName("Trd");
//      ...................... co.simasoft.models.naif.sgdea ........................
        GroupIds groupId8 = new GroupIds();
        groupId8 = findBean.groupIdGroupIds("co.simasoft.models.naif.sgdea",em);
        entities6.setGroupIds(groupId8);
        em.persist(entities6);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes7 = new Attributes();
        attributes7.setName("procedimientos");
        attributes7.setNullable(true);
        attributes7.setSingle(false);
//      ...................... Trd ........................
        Entities entity9 = new Entities();
        entity9 = findBean.nameEntities("Trd",em);
        attributes7.setEntities(entity9);
//      ...................... String ........................
        AttributesTypes attributesTypes10 = new AttributesTypes();
        attributesTypes10 = findBean.nameAttributesTypes("String",em);
        attributes7.setAttributesTypes(attributesTypes10);
        em.persist(attributes7);
        em.flush();

        Attributes attributes8 = new Attributes();
        attributes8.setName("observaciones");
        attributes8.setNullable(true);
        attributes8.setSingle(false);
//      ...................... Trd ........................
        Entities entity11 = new Entities();
        entity11 = findBean.nameEntities("Trd",em);
        attributes8.setEntities(entity11);
//      ...................... String ........................
        AttributesTypes attributesTypes12 = new AttributesTypes();
        attributesTypes12 = findBean.nameAttributesTypes("String",em);
        attributes8.setAttributesTypes(attributesTypes12);
        em.persist(attributes8);
        em.flush();

        Entities entities9 = new Entities();
        entities9.setName("Secciones");
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
//      ...................... Secciones ........................
        Entities entity14 = new Entities();
        entity14 = findBean.nameEntities("Secciones",em);
        attributes10.setEntities(entity14);
//      ...................... String ........................
        AttributesTypes attributesTypes15 = new AttributesTypes();
        attributesTypes15 = findBean.nameAttributesTypes("String",em);
        attributes10.setAttributesTypes(attributesTypes15);
        em.persist(attributes10);
        em.flush();

        Attributes attributes11 = new Attributes();
        attributes11.setName("codigo");
        attributes11.setNullable(true);
        attributes11.setSingle(false);
//      ...................... Secciones ........................
        Entities entity16 = new Entities();
        entity16 = findBean.nameEntities("Secciones",em);
        attributes11.setEntities(entity16);
//      ...................... String ........................
        AttributesTypes attributesTypes17 = new AttributesTypes();
        attributesTypes17 = findBean.nameAttributesTypes("String",em);
        attributes11.setAttributesTypes(attributesTypes17);
        em.persist(attributes11);
        em.flush();

        Attributes attributes12 = new Attributes();
        attributes12.setName("observaciones");
        attributes12.setNullable(true);
        attributes12.setSingle(false);
//      ...................... Secciones ........................
        Entities entity18 = new Entities();
        entity18 = findBean.nameEntities("Secciones",em);
        attributes12.setEntities(entity18);
//      ...................... String ........................
        AttributesTypes attributesTypes19 = new AttributesTypes();
        attributesTypes19 = findBean.nameAttributesTypes("String",em);
        attributes12.setAttributesTypes(attributesTypes19);
        em.persist(attributes12);
        em.flush();

        Attributes attributes13 = new Attributes();
        attributes13.setName("nroTransferencias");
        attributes13.setNullable(true);
        attributes13.setSingle(false);
//      ...................... Secciones ........................
        Entities entity20 = new Entities();
        entity20 = findBean.nameEntities("Secciones",em);
        attributes13.setEntities(entity20);
//      ...................... Integer ........................
        AttributesTypes attributesTypes21 = new AttributesTypes();
        attributesTypes21 = findBean.nameAttributesTypes("Integer",em);
        attributes13.setAttributesTypes(attributesTypes21);
        em.persist(attributes13);
        em.flush();

        Entities entities14 = new Entities();
        entities14.setName("DisposicionFinal");
//      ...................... co.simasoft.models.naif.sgdea ........................
        GroupIds groupId22 = new GroupIds();
        groupId22 = findBean.groupIdGroupIds("co.simasoft.models.naif.sgdea",em);
        entities14.setGroupIds(groupId22);
        em.persist(entities14);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes15 = new Attributes();
        attributes15.setName("nombre");
        attributes15.setNullable(true);
        attributes15.setSingle(false);
//      ...................... DisposicionFinal ........................
        Entities entity23 = new Entities();
        entity23 = findBean.nameEntities("DisposicionFinal",em);
        attributes15.setEntities(entity23);
//      ...................... String ........................
        AttributesTypes attributesTypes24 = new AttributesTypes();
        attributesTypes24 = findBean.nameAttributesTypes("String",em);
        attributes15.setAttributesTypes(attributesTypes24);
        em.persist(attributes15);
        em.flush();

        Entities entities16 = new Entities();
        entities16.setName("FrecuenciasConsulta");
//      ...................... co.simasoft.models.naif.sgdea ........................
        GroupIds groupId25 = new GroupIds();
        groupId25 = findBean.groupIdGroupIds("co.simasoft.models.naif.sgdea",em);
        entities16.setGroupIds(groupId25);
        em.persist(entities16);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes17 = new Attributes();
        attributes17.setName("nombre");
        attributes17.setNullable(true);
        attributes17.setSingle(false);
//      ...................... FrecuenciasConsulta ........................
        Entities entity26 = new Entities();
        entity26 = findBean.nameEntities("FrecuenciasConsulta",em);
        attributes17.setEntities(entity26);
//      ...................... String ........................
        AttributesTypes attributesTypes27 = new AttributesTypes();
        attributesTypes27 = findBean.nameAttributesTypes("String",em);
        attributes17.setAttributesTypes(attributesTypes27);
        em.persist(attributes17);
        em.flush();

        Entities entities18 = new Entities();
        entities18.setName("UnidadesDocumentales");
//      ...................... co.simasoft.models.naif.sgdea ........................
        GroupIds groupId28 = new GroupIds();
        groupId28 = findBean.groupIdGroupIds("co.simasoft.models.naif.sgdea",em);
        entities18.setGroupIds(groupId28);
        em.persist(entities18);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes19 = new Attributes();
        attributes19.setName("nombre");
        attributes19.setNullable(true);
        attributes19.setSingle(false);
//      ...................... UnidadesDocumentales ........................
        Entities entity29 = new Entities();
        entity29 = findBean.nameEntities("UnidadesDocumentales",em);
        attributes19.setEntities(entity29);
//      ...................... String ........................
        AttributesTypes attributesTypes30 = new AttributesTypes();
        attributesTypes30 = findBean.nameAttributesTypes("String",em);
        attributes19.setAttributesTypes(attributesTypes30);
        em.persist(attributes19);
        em.flush();

        Entities entities20 = new Entities();
        entities20.setName("FinalidadInventario");
//      ...................... co.simasoft.models.naif.sgdea ........................
        GroupIds groupId31 = new GroupIds();
        groupId31 = findBean.groupIdGroupIds("co.simasoft.models.naif.sgdea",em);
        entities20.setGroupIds(groupId31);
        em.persist(entities20);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes21 = new Attributes();
        attributes21.setName("nombre");
        attributes21.setNullable(true);
        attributes21.setSingle(false);
//      ...................... FinalidadInventario ........................
        Entities entity32 = new Entities();
        entity32 = findBean.nameEntities("FinalidadInventario",em);
        attributes21.setEntities(entity32);
//      ...................... String ........................
        AttributesTypes attributesTypes33 = new AttributesTypes();
        attributesTypes33 = findBean.nameAttributesTypes("String",em);
        attributes21.setAttributesTypes(attributesTypes33);
        em.persist(attributes21);
        em.flush();

        Entities entities22 = new Entities();
        entities22.setName("Personas");
//      ...................... co.simasoft.models.naif.sgdea ........................
        GroupIds groupId34 = new GroupIds();
        groupId34 = findBean.groupIdGroupIds("co.simasoft.models.naif.sgdea",em);
        entities22.setGroupIds(groupId34);
        em.persist(entities22);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes23 = new Attributes();
        attributes23.setName("primerNombre");
        attributes23.setNullable(true);
        attributes23.setSingle(false);
//      ...................... Personas ........................
        Entities entity35 = new Entities();
        entity35 = findBean.nameEntities("Personas",em);
        attributes23.setEntities(entity35);
//      ...................... String ........................
        AttributesTypes attributesTypes36 = new AttributesTypes();
        attributesTypes36 = findBean.nameAttributesTypes("String",em);
        attributes23.setAttributesTypes(attributesTypes36);
        em.persist(attributes23);
        em.flush();

        Attributes attributes24 = new Attributes();
        attributes24.setName("segundoNombre");
        attributes24.setNullable(true);
        attributes24.setSingle(false);
//      ...................... Personas ........................
        Entities entity37 = new Entities();
        entity37 = findBean.nameEntities("Personas",em);
        attributes24.setEntities(entity37);
//      ...................... String ........................
        AttributesTypes attributesTypes38 = new AttributesTypes();
        attributesTypes38 = findBean.nameAttributesTypes("String",em);
        attributes24.setAttributesTypes(attributesTypes38);
        em.persist(attributes24);
        em.flush();

        Attributes attributes25 = new Attributes();
        attributes25.setName("primerApellido");
        attributes25.setNullable(true);
        attributes25.setSingle(false);
//      ...................... Personas ........................
        Entities entity39 = new Entities();
        entity39 = findBean.nameEntities("Personas",em);
        attributes25.setEntities(entity39);
//      ...................... String ........................
        AttributesTypes attributesTypes40 = new AttributesTypes();
        attributesTypes40 = findBean.nameAttributesTypes("String",em);
        attributes25.setAttributesTypes(attributesTypes40);
        em.persist(attributes25);
        em.flush();

        Attributes attributes26 = new Attributes();
        attributes26.setName("segundoApellido");
        attributes26.setNullable(true);
        attributes26.setSingle(false);
//      ...................... Personas ........................
        Entities entity41 = new Entities();
        entity41 = findBean.nameEntities("Personas",em);
        attributes26.setEntities(entity41);
//      ...................... String ........................
        AttributesTypes attributesTypes42 = new AttributesTypes();
        attributesTypes42 = findBean.nameAttributesTypes("String",em);
        attributes26.setAttributesTypes(attributesTypes42);
        em.persist(attributes26);
        em.flush();

        Attributes attributes27 = new Attributes();
        attributes27.setName("email");
        attributes27.setNullable(true);
        attributes27.setSingle(false);
//      ...................... Personas ........................
        Entities entity43 = new Entities();
        entity43 = findBean.nameEntities("Personas",em);
        attributes27.setEntities(entity43);
//      ...................... String ........................
        AttributesTypes attributesTypes44 = new AttributesTypes();
        attributesTypes44 = findBean.nameAttributesTypes("String",em);
        attributes27.setAttributesTypes(attributesTypes44);
        em.persist(attributes27);
        em.flush();

        Entities entities28 = new Entities();
        entities28.setName("Series");
//      ...................... co.simasoft.models.naif.sgdea ........................
        GroupIds groupId45 = new GroupIds();
        groupId45 = findBean.groupIdGroupIds("co.simasoft.models.naif.sgdea",em);
        entities28.setGroupIds(groupId45);
        em.persist(entities28);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes29 = new Attributes();
        attributes29.setName("nombre");
        attributes29.setNullable(true);
        attributes29.setSingle(false);
//      ...................... Series ........................
        Entities entity46 = new Entities();
        entity46 = findBean.nameEntities("Series",em);
        attributes29.setEntities(entity46);
//      ...................... String ........................
        AttributesTypes attributesTypes47 = new AttributesTypes();
        attributesTypes47 = findBean.nameAttributesTypes("String",em);
        attributes29.setAttributesTypes(attributesTypes47);
        em.persist(attributes29);
        em.flush();

        Attributes attributes30 = new Attributes();
        attributes30.setName("codigo");
        attributes30.setNullable(true);
        attributes30.setSingle(false);
//      ...................... Series ........................
        Entities entity48 = new Entities();
        entity48 = findBean.nameEntities("Series",em);
        attributes30.setEntities(entity48);
//      ...................... String ........................
        AttributesTypes attributesTypes49 = new AttributesTypes();
        attributesTypes49 = findBean.nameAttributesTypes("String",em);
        attributes30.setAttributesTypes(attributesTypes49);
        em.persist(attributes30);
        em.flush();

        Attributes attributes31 = new Attributes();
        attributes31.setName("observaciones");
        attributes31.setNullable(true);
        attributes31.setSingle(false);
//      ...................... Series ........................
        Entities entity50 = new Entities();
        entity50 = findBean.nameEntities("Series",em);
        attributes31.setEntities(entity50);
//      ...................... String ........................
        AttributesTypes attributesTypes51 = new AttributesTypes();
        attributesTypes51 = findBean.nameAttributesTypes("String",em);
        attributes31.setAttributesTypes(attributesTypes51);
        em.persist(attributes31);
        em.flush();

        Entities entities32 = new Entities();
        entities32.setName("FondosDocumentales");
//      ...................... co.simasoft.models.naif.sgdea ........................
        GroupIds groupId52 = new GroupIds();
        groupId52 = findBean.groupIdGroupIds("co.simasoft.models.naif.sgdea",em);
        entities32.setGroupIds(groupId52);
        em.persist(entities32);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes33 = new Attributes();
        attributes33.setName("nombre");
        attributes33.setNullable(true);
        attributes33.setSingle(false);
//      ...................... FondosDocumentales ........................
        Entities entity53 = new Entities();
        entity53 = findBean.nameEntities("FondosDocumentales",em);
        attributes33.setEntities(entity53);
//      ...................... String ........................
        AttributesTypes attributesTypes54 = new AttributesTypes();
        attributesTypes54 = findBean.nameAttributesTypes("String",em);
        attributes33.setAttributesTypes(attributesTypes54);
        em.persist(attributes33);
        em.flush();

        Attributes attributes34 = new Attributes();
        attributes34.setName("fechaCreacion");
        attributes34.setNullable(true);
        attributes34.setSingle(false);
//      ...................... FondosDocumentales ........................
        Entities entity55 = new Entities();
        entity55 = findBean.nameEntities("FondosDocumentales",em);
        attributes34.setEntities(entity55);
//      ...................... Date ........................
        AttributesTypes attributesTypes56 = new AttributesTypes();
        attributesTypes56 = findBean.nameAttributesTypes("Date",em);
        attributes34.setAttributesTypes(attributesTypes56);
        em.persist(attributes34);
        em.flush();

        Attributes attributes35 = new Attributes();
        attributes35.setName("fechaTerminacion");
        attributes35.setNullable(true);
        attributes35.setSingle(false);
//      ...................... FondosDocumentales ........................
        Entities entity57 = new Entities();
        entity57 = findBean.nameEntities("FondosDocumentales",em);
        attributes35.setEntities(entity57);
//      ...................... Date ........................
        AttributesTypes attributesTypes58 = new AttributesTypes();
        attributesTypes58 = findBean.nameAttributesTypes("Date",em);
        attributes35.setAttributesTypes(attributesTypes58);
        em.persist(attributes35);
        em.flush();

        Attributes attributes36 = new Attributes();
        attributes36.setName("disposiciones");
        attributes36.setNullable(true);
        attributes36.setSingle(false);
//      ...................... FondosDocumentales ........................
        Entities entity59 = new Entities();
        entity59 = findBean.nameEntities("FondosDocumentales",em);
        attributes36.setEntities(entity59);
//      ...................... String ........................
        AttributesTypes attributesTypes60 = new AttributesTypes();
        attributesTypes60 = findBean.nameAttributesTypes("String",em);
        attributes36.setAttributesTypes(attributesTypes60);
        em.persist(attributes36);
        em.flush();

        Attributes attributes37 = new Attributes();
        attributes37.setName("organismos");
        attributes37.setNullable(true);
        attributes37.setSingle(false);
//      ...................... FondosDocumentales ........................
        Entities entity61 = new Entities();
        entity61 = findBean.nameEntities("FondosDocumentales",em);
        attributes37.setEntities(entity61);
//      ...................... String ........................
        AttributesTypes attributesTypes62 = new AttributesTypes();
        attributesTypes62 = findBean.nameAttributesTypes("String",em);
        attributes37.setAttributesTypes(attributesTypes62);
        em.persist(attributes37);
        em.flush();

        Entities entities38 = new Entities();
        entities38.setName("Empresas");
//      ...................... co.simasoft.models.naif.sgdea ........................
        GroupIds groupId63 = new GroupIds();
        groupId63 = findBean.groupIdGroupIds("co.simasoft.models.naif.sgdea",em);
        entities38.setGroupIds(groupId63);
        em.persist(entities38);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes39 = new Attributes();
        attributes39.setName("nombre");
        attributes39.setNullable(true);
        attributes39.setSingle(false);
//      ...................... Empresas ........................
        Entities entity64 = new Entities();
        entity64 = findBean.nameEntities("Empresas",em);
        attributes39.setEntities(entity64);
//      ...................... String ........................
        AttributesTypes attributesTypes65 = new AttributesTypes();
        attributesTypes65 = findBean.nameAttributesTypes("String",em);
        attributes39.setAttributesTypes(attributesTypes65);
        em.persist(attributes39);
        em.flush();

        Attributes attributes40 = new Attributes();
        attributes40.setName("nit");
        attributes40.setNullable(true);
        attributes40.setSingle(false);
//      ...................... Empresas ........................
        Entities entity66 = new Entities();
        entity66 = findBean.nameEntities("Empresas",em);
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
//      ...................... Empresas ........................
        Entities entity68 = new Entities();
        entity68 = findBean.nameEntities("Empresas",em);
        attributes41.setEntities(entity68);
//      ...................... String ........................
        AttributesTypes attributesTypes69 = new AttributesTypes();
        attributesTypes69 = findBean.nameAttributesTypes("String",em);
        attributes41.setAttributesTypes(attributesTypes69);
        em.persist(attributes41);
        em.flush();

        Attributes attributes42 = new Attributes();
        attributes42.setName("link");
        attributes42.setNullable(true);
        attributes42.setSingle(false);
//      ...................... Empresas ........................
        Entities entity70 = new Entities();
        entity70 = findBean.nameEntities("Empresas",em);
        attributes42.setEntities(entity70);
//      ...................... String ........................
        AttributesTypes attributesTypes71 = new AttributesTypes();
        attributesTypes71 = findBean.nameAttributesTypes("String",em);
        attributes42.setAttributesTypes(attributesTypes71);
        em.persist(attributes42);
        em.flush();

        Attributes attributes43 = new Attributes();
        attributes43.setName("tels");
        attributes43.setNullable(true);
        attributes43.setSingle(false);
//      ...................... Empresas ........................
        Entities entity72 = new Entities();
        entity72 = findBean.nameEntities("Empresas",em);
        attributes43.setEntities(entity72);
//      ...................... String ........................
        AttributesTypes attributesTypes73 = new AttributesTypes();
        attributesTypes73 = findBean.nameAttributesTypes("String",em);
        attributes43.setAttributesTypes(attributesTypes73);
        em.persist(attributes43);
        em.flush();

        Attributes attributes44 = new Attributes();
        attributes44.setName("email");
        attributes44.setNullable(true);
        attributes44.setSingle(false);
//      ...................... Empresas ........................
        Entities entity74 = new Entities();
        entity74 = findBean.nameEntities("Empresas",em);
        attributes44.setEntities(entity74);
//      ...................... String ........................
        AttributesTypes attributesTypes75 = new AttributesTypes();
        attributesTypes75 = findBean.nameAttributesTypes("String",em);
        attributes44.setAttributesTypes(attributesTypes75);
        em.persist(attributes44);
        em.flush();

        Entities entities45 = new Entities();
        entities45.setName("VigenciaFondos");
//      ...................... co.simasoft.models.naif.sgdea ........................
        GroupIds groupId76 = new GroupIds();
        groupId76 = findBean.groupIdGroupIds("co.simasoft.models.naif.sgdea",em);
        entities45.setGroupIds(groupId76);
        em.persist(entities45);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes46 = new Attributes();
        attributes46.setName("nombre");
        attributes46.setNullable(true);
        attributes46.setSingle(false);
//      ...................... VigenciaFondos ........................
        Entities entity77 = new Entities();
        entity77 = findBean.nameEntities("VigenciaFondos",em);
        attributes46.setEntities(entity77);
//      ...................... String ........................
        AttributesTypes attributesTypes78 = new AttributesTypes();
        attributesTypes78 = findBean.nameAttributesTypes("String",em);
        attributes46.setAttributesTypes(attributesTypes78);
        em.persist(attributes46);
        em.flush();

        Attributes attributes47 = new Attributes();
        attributes47.setName("siAbierto");
        attributes47.setNullable(true);
        attributes47.setSingle(false);
//      ...................... VigenciaFondos ........................
        Entities entity79 = new Entities();
        entity79 = findBean.nameEntities("VigenciaFondos",em);
        attributes47.setEntities(entity79);
//      ...................... Boolean ........................
        AttributesTypes attributesTypes80 = new AttributesTypes();
        attributesTypes80 = findBean.nameAttributesTypes("Boolean",em);
        attributes47.setAttributesTypes(attributesTypes80);
        em.persist(attributes47);
        em.flush();

        Attributes attributes48 = new Attributes();
        attributes48.setName("observaciones");
        attributes48.setNullable(true);
        attributes48.setSingle(false);
//      ...................... VigenciaFondos ........................
        Entities entity81 = new Entities();
        entity81 = findBean.nameEntities("VigenciaFondos",em);
        attributes48.setEntities(entity81);
//      ...................... String ........................
        AttributesTypes attributesTypes82 = new AttributesTypes();
        attributesTypes82 = findBean.nameAttributesTypes("String",em);
        attributes48.setAttributesTypes(attributesTypes82);
        em.persist(attributes48);
        em.flush();

        Entities entities49 = new Entities();
        entities49.setName("InventarioDocumental");
//      ...................... co.simasoft.models.naif.sgdea ........................
        GroupIds groupId83 = new GroupIds();
        groupId83 = findBean.groupIdGroupIds("co.simasoft.models.naif.sgdea",em);
        entities49.setGroupIds(groupId83);
        em.persist(entities49);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes50 = new Attributes();
        attributes50.setName("fechaEntrega");
        attributes50.setNullable(true);
        attributes50.setSingle(false);
//      ...................... InventarioDocumental ........................
        Entities entity84 = new Entities();
        entity84 = findBean.nameEntities("InventarioDocumental",em);
        attributes50.setEntities(entity84);
//      ...................... Date ........................
        AttributesTypes attributesTypes85 = new AttributesTypes();
        attributesTypes85 = findBean.nameAttributesTypes("Date",em);
        attributes50.setAttributesTypes(attributesTypes85);
        em.persist(attributes50);
        em.flush();

        Attributes attributes51 = new Attributes();
        attributes51.setName("nroTransferencia");
        attributes51.setNullable(true);
        attributes51.setSingle(false);
//      ...................... InventarioDocumental ........................
        Entities entity86 = new Entities();
        entity86 = findBean.nameEntities("InventarioDocumental",em);
        attributes51.setEntities(entity86);
//      ...................... Integer ........................
        AttributesTypes attributesTypes87 = new AttributesTypes();
        attributesTypes87 = findBean.nameAttributesTypes("Integer",em);
        attributes51.setAttributesTypes(attributesTypes87);
        em.persist(attributes51);
        em.flush();

        Attributes attributes52 = new Attributes();
        attributes52.setName("fechaInicial");
        attributes52.setNullable(true);
        attributes52.setSingle(false);
//      ...................... InventarioDocumental ........................
        Entities entity88 = new Entities();
        entity88 = findBean.nameEntities("InventarioDocumental",em);
        attributes52.setEntities(entity88);
//      ...................... Date ........................
        AttributesTypes attributesTypes89 = new AttributesTypes();
        attributesTypes89 = findBean.nameAttributesTypes("Date",em);
        attributes52.setAttributesTypes(attributesTypes89);
        em.persist(attributes52);
        em.flush();

        Attributes attributes53 = new Attributes();
        attributes53.setName("fechaFinal");
        attributes53.setNullable(true);
        attributes53.setSingle(false);
//      ...................... InventarioDocumental ........................
        Entities entity90 = new Entities();
        entity90 = findBean.nameEntities("InventarioDocumental",em);
        attributes53.setEntities(entity90);
//      ...................... Date ........................
        AttributesTypes attributesTypes91 = new AttributesTypes();
        attributesTypes91 = findBean.nameAttributesTypes("Date",em);
        attributes53.setAttributesTypes(attributesTypes91);
        em.persist(attributes53);
        em.flush();

        Attributes attributes54 = new Attributes();
        attributes54.setName("folios");
        attributes54.setNullable(true);
        attributes54.setSingle(false);
//      ...................... InventarioDocumental ........................
        Entities entity92 = new Entities();
        entity92 = findBean.nameEntities("InventarioDocumental",em);
        attributes54.setEntities(entity92);
//      ...................... Integer ........................
        AttributesTypes attributesTypes93 = new AttributesTypes();
        attributesTypes93 = findBean.nameAttributesTypes("Integer",em);
        attributes54.setAttributesTypes(attributesTypes93);
        em.persist(attributes54);
        em.flush();

        Attributes attributes55 = new Attributes();
        attributes55.setName("cantidad");
        attributes55.setNullable(true);
        attributes55.setSingle(false);
//      ...................... InventarioDocumental ........................
        Entities entity94 = new Entities();
        entity94 = findBean.nameEntities("InventarioDocumental",em);
        attributes55.setEntities(entity94);
//      ...................... Integer ........................
        AttributesTypes attributesTypes95 = new AttributesTypes();
        attributesTypes95 = findBean.nameAttributesTypes("Integer",em);
        attributes55.setAttributesTypes(attributesTypes95);
        em.persist(attributes55);
        em.flush();

        Attributes attributes56 = new Attributes();
        attributes56.setName("fechaDepuracion");
        attributes56.setNullable(true);
        attributes56.setSingle(false);
//      ...................... InventarioDocumental ........................
        Entities entity96 = new Entities();
        entity96 = findBean.nameEntities("InventarioDocumental",em);
        attributes56.setEntities(entity96);
//      ...................... Date ........................
        AttributesTypes attributesTypes97 = new AttributesTypes();
        attributesTypes97 = findBean.nameAttributesTypes("Date",em);
        attributes56.setAttributesTypes(attributesTypes97);
        em.persist(attributes56);
        em.flush();

        Attributes attributes57 = new Attributes();
        attributes57.setName("disposcionFinal");
        attributes57.setNullable(true);
        attributes57.setSingle(false);
//      ...................... InventarioDocumental ........................
        Entities entity98 = new Entities();
        entity98 = findBean.nameEntities("InventarioDocumental",em);
        attributes57.setEntities(entity98);
//      ...................... String ........................
        AttributesTypes attributesTypes99 = new AttributesTypes();
        attributesTypes99 = findBean.nameAttributesTypes("String",em);
        attributes57.setAttributesTypes(attributesTypes99);
        em.persist(attributes57);
        em.flush();

        Entities entities58 = new Entities();
        entities58.setName("RetencionDocumental");
//      ...................... co.simasoft.models.naif.sgdea ........................
        GroupIds groupId100 = new GroupIds();
        groupId100 = findBean.groupIdGroupIds("co.simasoft.models.naif.sgdea",em);
        entities58.setGroupIds(groupId100);
        em.persist(entities58);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes59 = new Attributes();
        attributes59.setName("year");
        attributes59.setNullable(true);
        attributes59.setSingle(false);
//      ...................... RetencionDocumental ........................
        Entities entity101 = new Entities();
        entity101 = findBean.nameEntities("RetencionDocumental",em);
        attributes59.setEntities(entity101);
//      ...................... Integer ........................
        AttributesTypes attributesTypes102 = new AttributesTypes();
        attributesTypes102 = findBean.nameAttributesTypes("Integer",em);
        attributes59.setAttributesTypes(attributesTypes102);
        em.persist(attributes59);
        em.flush();

        Attributes attributes60 = new Attributes();
        attributes60.setName("nombre");
        attributes60.setNullable(true);
        attributes60.setSingle(false);
//      ...................... RetencionDocumental ........................
        Entities entity103 = new Entities();
        entity103 = findBean.nameEntities("RetencionDocumental",em);
        attributes60.setEntities(entity103);
//      ...................... String ........................
        AttributesTypes attributesTypes104 = new AttributesTypes();
        attributesTypes104 = findBean.nameAttributesTypes("String",em);
        attributes60.setAttributesTypes(attributesTypes104);
        em.persist(attributes60);
        em.flush();

        Entities entities61 = new Entities();
        entities61.setName("SoporteDocumental");
//      ...................... co.simasoft.models.naif.sgdea ........................
        GroupIds groupId105 = new GroupIds();
        groupId105 = findBean.groupIdGroupIds("co.simasoft.models.naif.sgdea",em);
        entities61.setGroupIds(groupId105);
        em.persist(entities61);
        em.flush();

//      ---------------------- Attributes ------------------------

        Attributes attributes62 = new Attributes();
        attributes62.setName("nombre");
        attributes62.setNullable(true);
        attributes62.setSingle(false);
//      ...................... SoporteDocumental ........................
        Entities entity106 = new Entities();
        entity106 = findBean.nameEntities("SoporteDocumental",em);
        attributes62.setEntities(entity106);
//      ...................... String ........................
        AttributesTypes attributesTypes107 = new AttributesTypes();
        attributesTypes107 = findBean.nameAttributesTypes("String",em);
        attributes62.setAttributesTypes(attributesTypes107);
        em.persist(attributes62);
        em.flush();

//      ---------------------- Relationships ------------------------

/*
Personas 1..* Secciones
Series *..* TiposDocumentales
DisposicionFinal 1..* Trd
FondosDocumentales 1..* Secciones
Empresas 1..* FondosDocumentales
TiposDocumentales *..* Series
FrecuenciasConsulta 1..* UnidadesDocumentales
Secciones 1..* Secciones
UnidadesDocumentales *..* SoporteDocumental
UnidadesDocumentales 1..* InventarioDocumental
Series 1..* Series
RetencionDocumental 1..* Trd
SoporteDocumental *..* UnidadesDocumentales
RetencionDocumental 1..* Trd
UnidadesConservacion 1..* UnidadesDocumentales
Secciones *..* Series
FinalidadInventario 1..* InventarioDocumental
UnidadesDocumentales 1..* Series
Series *..* Secciones
Trd 1..* Series
VigenciaFondos 1..* FondosDocumentales
*/
        Relationships relationships1 = new Relationships();
        relationships1.setOptionality(true);
        relationships1.setIsEmbedded(false);
//      ...................... Personas ........................
        Entities entities108 = new Entities();
        entities108 = findBean.nameEntities("Personas",em);
        relationships1.setFrom(entities108);
//      ...................... Secciones ........................
        Entities entities109 = new Entities();
        entities109 = findBean.nameEntities("Secciones",em);
        relationships1.setTo(entities109);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities110 = new Cardinalities();
        cardinalities110 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships1.setCardinalities(cardinalities110);
        em.persist(relationships1);
        em.flush();

        Relationships relationships3 = new Relationships();
        relationships3.setOptionality(true);
        relationships3.setIsEmbedded(false);
//      ...................... DisposicionFinal ........................
        Entities entities114 = new Entities();
        entities114 = findBean.nameEntities("DisposicionFinal",em);
        relationships3.setFrom(entities114);
//      ...................... Trd ........................
        Entities entities115 = new Entities();
        entities115 = findBean.nameEntities("Trd",em);
        relationships3.setTo(entities115);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities116 = new Cardinalities();
        cardinalities116 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships3.setCardinalities(cardinalities116);
        em.persist(relationships3);
        em.flush();

        Relationships relationships4 = new Relationships();
        relationships4.setOptionality(true);
        relationships4.setIsEmbedded(false);
//      ...................... FondosDocumentales ........................
        Entities entities117 = new Entities();
        entities117 = findBean.nameEntities("FondosDocumentales",em);
        relationships4.setFrom(entities117);
//      ...................... Secciones ........................
        Entities entities118 = new Entities();
        entities118 = findBean.nameEntities("Secciones",em);
        relationships4.setTo(entities118);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities119 = new Cardinalities();
        cardinalities119 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships4.setCardinalities(cardinalities119);
        em.persist(relationships4);
        em.flush();

        Relationships relationships5 = new Relationships();
        relationships5.setOptionality(true);
        relationships5.setIsEmbedded(false);
//      ...................... Empresas ........................
        Entities entities120 = new Entities();
        entities120 = findBean.nameEntities("Empresas",em);
        relationships5.setFrom(entities120);
//      ...................... FondosDocumentales ........................
        Entities entities121 = new Entities();
        entities121 = findBean.nameEntities("FondosDocumentales",em);
        relationships5.setTo(entities121);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities122 = new Cardinalities();
        cardinalities122 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships5.setCardinalities(cardinalities122);
        em.persist(relationships5);
        em.flush();

        Relationships relationships6 = new Relationships();
        relationships6.setOptionality(false);
        relationships6.setIsEmbedded(false);
//      ...................... TiposDocumentales ........................
        Entities entities123 = new Entities();
        entities123 = findBean.nameEntities("TiposDocumentales",em);
        relationships6.setFrom(entities123);
//      ...................... Series ........................
        Entities entities124 = new Entities();
        entities124 = findBean.nameEntities("Series",em);
        relationships6.setTo(entities124);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities125 = new Cardinalities();
        cardinalities125 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships6.setCardinalities(cardinalities125);
        em.persist(relationships6);
        em.flush();

        Relationships relationships7 = new Relationships();
        relationships7.setOptionality(true);
        relationships7.setIsEmbedded(false);
//      ...................... FrecuenciasConsulta ........................
        Entities entities126 = new Entities();
        entities126 = findBean.nameEntities("FrecuenciasConsulta",em);
        relationships7.setFrom(entities126);
//      ...................... UnidadesDocumentales ........................
        Entities entities127 = new Entities();
        entities127 = findBean.nameEntities("UnidadesDocumentales",em);
        relationships7.setTo(entities127);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities128 = new Cardinalities();
        cardinalities128 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
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
//      ...................... UnidadesDocumentales ........................
        Entities entities132 = new Entities();
        entities132 = findBean.nameEntities("UnidadesDocumentales",em);
        relationships9.setFrom(entities132);
//      ...................... SoporteDocumental ........................
        Entities entities133 = new Entities();
        entities133 = findBean.nameEntities("SoporteDocumental",em);
        relationships9.setTo(entities133);
//      ...................... Muchos a Muchos Bidirecccional No.7 ........................
        Cardinalities cardinalities134 = new Cardinalities();
        cardinalities134 = findBean.nameCardinalities("Muchos a Muchos Bidirecccional No.7",em);
        relationships9.setCardinalities(cardinalities134);
        em.persist(relationships9);
        em.flush();

        Relationships relationships10 = new Relationships();
        relationships10.setOptionality(true);
        relationships10.setIsEmbedded(false);
//      ...................... UnidadesDocumentales ........................
        Entities entities135 = new Entities();
        entities135 = findBean.nameEntities("UnidadesDocumentales",em);
        relationships10.setFrom(entities135);
//      ...................... InventarioDocumental ........................
        Entities entities136 = new Entities();
        entities136 = findBean.nameEntities("InventarioDocumental",em);
        relationships10.setTo(entities136);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities137 = new Cardinalities();
        cardinalities137 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships10.setCardinalities(cardinalities137);
        em.persist(relationships10);
        em.flush();

        Relationships relationships11 = new Relationships();
        relationships11.setOptionality(true);
        relationships11.setIsEmbedded(false);
//      ...................... Series ........................
        Entities entities138 = new Entities();
        entities138 = findBean.nameEntities("Series",em);
        relationships11.setFrom(entities138);
//      ...................... Series ........................
        Entities entities139 = new Entities();
        entities139 = findBean.nameEntities("Series",em);
        relationships11.setTo(entities139);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities140 = new Cardinalities();
        cardinalities140 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
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
        relationships12.setName("gestion");
        em.persist(relationships12);
        em.flush();

        Relationships relationships14 = new Relationships();
        relationships14.setOptionality(true);
        relationships14.setIsEmbedded(false);
//      ...................... RetencionDocumental ........................
        Entities entities147 = new Entities();
        entities147 = findBean.nameEntities("RetencionDocumental",em);
        relationships14.setFrom(entities147);
//      ...................... Trd ........................
        Entities entities148 = new Entities();
        entities148 = findBean.nameEntities("Trd",em);
        relationships14.setTo(entities148);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities149 = new Cardinalities();
        cardinalities149 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships14.setCardinalities(cardinalities149);
        relationships14.setName("central");
        em.persist(relationships14);
        em.flush();

        Relationships relationships15 = new Relationships();
        relationships15.setOptionality(true);
        relationships15.setIsEmbedded(false);
//      ...................... UnidadesConservacion ........................
        Entities entities150 = new Entities();
        entities150 = findBean.nameEntities("UnidadesConservacion",em);
        relationships15.setFrom(entities150);
//      ...................... UnidadesDocumentales ........................
        Entities entities151 = new Entities();
        entities151 = findBean.nameEntities("UnidadesDocumentales",em);
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
//      ...................... Secciones ........................
        Entities entities153 = new Entities();
        entities153 = findBean.nameEntities("Secciones",em);
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
//      ...................... FinalidadInventario ........................
        Entities entities156 = new Entities();
        entities156 = findBean.nameEntities("FinalidadInventario",em);
        relationships17.setFrom(entities156);
//      ...................... InventarioDocumental ........................
        Entities entities157 = new Entities();
        entities157 = findBean.nameEntities("InventarioDocumental",em);
        relationships17.setTo(entities157);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities158 = new Cardinalities();
        cardinalities158 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships17.setCardinalities(cardinalities158);
        em.persist(relationships17);
        em.flush();

        Relationships relationships18 = new Relationships();
        relationships18.setOptionality(true);
        relationships18.setIsEmbedded(false);
//      ...................... UnidadesDocumentales ........................
        Entities entities159 = new Entities();
        entities159 = findBean.nameEntities("UnidadesDocumentales",em);
        relationships18.setFrom(entities159);
//      ...................... Series ........................
        Entities entities160 = new Entities();
        entities160 = findBean.nameEntities("Series",em);
        relationships18.setTo(entities160);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities161 = new Cardinalities();
        cardinalities161 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships18.setCardinalities(cardinalities161);
        em.persist(relationships18);
        em.flush();

        Relationships relationships20 = new Relationships();
        relationships20.setOptionality(true);
        relationships20.setIsEmbedded(false);
//      ...................... Trd ........................
        Entities entities165 = new Entities();
        entities165 = findBean.nameEntities("Trd",em);
        relationships20.setFrom(entities165);
//      ...................... Series ........................
        Entities entities166 = new Entities();
        entities166 = findBean.nameEntities("Series",em);
        relationships20.setTo(entities166);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities167 = new Cardinalities();
        cardinalities167 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships20.setCardinalities(cardinalities167);
        em.persist(relationships20);
        em.flush();

        Relationships relationships21 = new Relationships();
        relationships21.setOptionality(true);
        relationships21.setIsEmbedded(false);
//      ...................... VigenciaFondos ........................
        Entities entities168 = new Entities();
        entities168 = findBean.nameEntities("VigenciaFondos",em);
        relationships21.setFrom(entities168);
//      ...................... FondosDocumentales ........................
        Entities entities169 = new Entities();
        entities169 = findBean.nameEntities("FondosDocumentales",em);
        relationships21.setTo(entities169);
//      ...................... Uno a Muchos Bidirecccional No.5 ........................
        Cardinalities cardinalities170 = new Cardinalities();
        cardinalities170 = findBean.nameCardinalities("Uno a Muchos Bidirecccional No.5",em);
        relationships21.setCardinalities(cardinalities170);
        em.persist(relationships21);
        em.flush();

    } // data()

} // SGDEA
