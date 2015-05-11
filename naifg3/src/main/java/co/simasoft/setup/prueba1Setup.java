package co.simasoft.setup;

import co.simasoft.models.naif.domainmodels.*;

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
@Named("prueba1Setup")
public class prueba1Setup {

    private static final String QUERYA = "SELECT c FROM TypesAttributes c WHERE c.name LIKE :custName";
    private static final String QUERYB = "SELECT c FROM Entities c WHERE c.name LIKE :custName";
    private static final String QUERYC = "SELECT c FROM Cardinalities c WHERE c.name LIKE :custName";

    @PersistenceContext(unitName = "DomainModelsPU-JTA")
    private EntityManager em;

    private static final Logger log = Logger.getLogger(prueba1Setup.class.getName());

    public TypesAttributes findTypesAttributes(String name) {

        TypesAttributes typesAttributes = new TypesAttributes();
        List<TypesAttributes> results = em.createQuery(QUERYA).setParameter("custName", name).getResultList();

        if (!results.isEmpty()) {
           typesAttributes = results.get(0);
        }
        return typesAttributes;
    }

    public Entities findEntities(String name) {

        Entities entities = new Entities();
        List<Entities> results = em.createQuery(QUERYB).setParameter("custName", name).getResultList();

        if (!results.isEmpty()) {
           entities = results.get(0);
        }
        return entities;
    }

    public Cardinalities findCardinalities(String name) {

        Cardinalities cardinalities = new Cardinalities();
        List<Cardinalities> results = em.createQuery(QUERYC).setParameter("custName", name).getResultList();

        if (!results.isEmpty()) {
           cardinalities = results.get(0);
        }
        return cardinalities;
    }

    public void data() {

        DomainModels domainModels = new DomainModels();
        domainModels.setName(Utils.nameRandom());
        em.persist(domainModels);
        em.flush();

        GroupIds groupIds = new GroupIds();
        groupIds.setGroupId(Utils.nameRandom());
        groupIds.setDomainModels(domainModels);
        em.persist(groupIds);
        em.flush();

        PropertiesAttributes(groupIds);
        TypesAttributes(groupIds);
        SystemsModels(groupIds);
        DomainModels(groupIds);
        Relations();

    } // data()

    public void PropertiesAttributes(GroupIds groupIds) {

        Entities propertiesAttributes = new Entities();
        propertiesAttributes.setName("PropertiesAttributes");
        propertiesAttributes.setGroupIds(groupIds);
        em.persist(propertiesAttributes);
        em.flush();

//      ---------------------- Attributes:PropertiesAttributes -------------------------

        TypesAttributes typesname = new TypesAttributes();
        typesname = findTypesAttributes("String");

        Attributes name = new Attributes();
        name.setName("name");
        name.setTypesAttributes(typesname);
        name.setEntities(propertiesAttributes);
        em.persist(name);
        em.flush();

        TypesAttributes typesvalue = new TypesAttributes();
        typesvalue = findTypesAttributes("String");

        Attributes value = new Attributes();
        value.setName("value");
        value.setTypesAttributes(typesvalue);
        value.setEntities(propertiesAttributes);
        em.persist(value);
        em.flush();

        TypesAttributes typesobservaciones = new TypesAttributes();
        typesobservaciones = findTypesAttributes("String");

        Attributes observaciones = new Attributes();
        observaciones.setName("observaciones");
        observaciones.setTypesAttributes(typesobservaciones);
        observaciones.setEntities(propertiesAttributes);
        em.persist(observaciones);
        em.flush();

    } // PropertiesAttributes()

    public void TypesAttributes(GroupIds groupIds) {

        Entities typesAttributes = new Entities();
        typesAttributes.setName("TypesAttributes");
        typesAttributes.setGroupIds(groupIds);
        em.persist(typesAttributes);
        em.flush();

//      ---------------------- Attributes:TypesAttributes -------------------------

        TypesAttributes typesname = new TypesAttributes();
        typesname = findTypesAttributes("String");

        Attributes name = new Attributes();
        name.setName("name");
        name.setTypesAttributes(typesname);
        name.setEntities(typesAttributes);
        em.persist(name);
        em.flush();

        TypesAttributes typestype = new TypesAttributes();
        typestype = findTypesAttributes("String");

        Attributes type = new Attributes();
        type.setName("type");
        type.setTypesAttributes(typestype);
        type.setEntities(typesAttributes);
        em.persist(type);
        em.flush();

        TypesAttributes typeslength = new TypesAttributes();
        typeslength = findTypesAttributes("Integer");

        Attributes length = new Attributes();
        length.setName("length");
        length.setTypesAttributes(typeslength);
        length.setEntities(typesAttributes);
        em.persist(length);
        em.flush();

        TypesAttributes typesprecision = new TypesAttributes();
        typesprecision = findTypesAttributes("Integer");

        Attributes precision = new Attributes();
        precision.setName("precision");
        precision.setTypesAttributes(typesprecision);
        precision.setEntities(typesAttributes);
        em.persist(precision);
        em.flush();

        TypesAttributes typesannotations = new TypesAttributes();
        typesannotations = findTypesAttributes("String");

        Attributes annotations = new Attributes();
        annotations.setName("annotations");
        annotations.setTypesAttributes(typesannotations);
        annotations.setEntities(typesAttributes);
        em.persist(annotations);
        em.flush();

        TypesAttributes typesobservaciones = new TypesAttributes();
        typesobservaciones = findTypesAttributes("String");

        Attributes observaciones = new Attributes();
        observaciones.setName("observaciones");
        observaciones.setTypesAttributes(typesobservaciones);
        observaciones.setEntities(typesAttributes);
        em.persist(observaciones);
        em.flush();

    } // TypesAttributes()

    public void SystemsModels(GroupIds groupIds) {

        Entities systemsModels = new Entities();
        systemsModels.setName("SystemsModels");
        systemsModels.setGroupIds(groupIds);
        em.persist(systemsModels);
        em.flush();

//      ---------------------- Attributes:SystemsModels -------------------------

        TypesAttributes typesname = new TypesAttributes();
        typesname = findTypesAttributes("String");

        Attributes name = new Attributes();
        name.setName("name");
        name.setTypesAttributes(typesname);
        name.setEntities(systemsModels);
        em.persist(name);
        em.flush();

        TypesAttributes typesdescription = new TypesAttributes();
        typesdescription = findTypesAttributes("String");

        Attributes description = new Attributes();
        description.setName("description");
        description.setTypesAttributes(typesdescription);
        description.setEntities(systemsModels);
        em.persist(description);
        em.flush();

        TypesAttributes typesobservaciones = new TypesAttributes();
        typesobservaciones = findTypesAttributes("String");

        Attributes observaciones = new Attributes();
        observaciones.setName("observaciones");
        observaciones.setTypesAttributes(typesobservaciones);
        observaciones.setEntities(systemsModels);
        em.persist(observaciones);
        em.flush();

    } // SystemsModels()

    public void DomainModels(GroupIds groupIds) {

        Entities domainModels = new Entities();
        domainModels.setName("DomainModels");
        domainModels.setGroupIds(groupIds);
        em.persist(domainModels);
        em.flush();

//      ---------------------- Attributes:DomainModels -------------------------

        TypesAttributes typesname = new TypesAttributes();
        typesname = findTypesAttributes("String");

        Attributes name = new Attributes();
        name.setName("name");
        name.setTypesAttributes(typesname);
        name.setEntities(domainModels);
        em.persist(name);
        em.flush();

        TypesAttributes typesgroupId = new TypesAttributes();
        typesgroupId = findTypesAttributes("String");

        Attributes groupId = new Attributes();
        groupId.setName("groupId");
        groupId.setTypesAttributes(typesgroupId);
        groupId.setEntities(domainModels);
        em.persist(groupId);
        em.flush();

        TypesAttributes typesartifactId = new TypesAttributes();
        typesartifactId = findTypesAttributes("String");

        Attributes artifactId = new Attributes();
        artifactId.setName("artifactId");
        artifactId.setTypesAttributes(typesartifactId);
        artifactId.setEntities(domainModels);
        em.persist(artifactId);
        em.flush();

        TypesAttributes typesversion = new TypesAttributes();
        typesversion = findTypesAttributes("String");

        Attributes version = new Attributes();
        version.setName("version");
        version.setTypesAttributes(typesversion);
        version.setEntities(domainModels);
        em.persist(version);
        em.flush();

        TypesAttributes typescodigo = new TypesAttributes();
        typescodigo = findTypesAttributes("String");

        Attributes codigo = new Attributes();
        codigo.setName("codigo");
        codigo.setTypesAttributes(typescodigo);
        codigo.setEntities(domainModels);
        em.persist(codigo);
        em.flush();

        TypesAttributes typesdate = new TypesAttributes();
        typesdate = findTypesAttributes("Date");

        Attributes date = new Attributes();
        date.setName("date");
        date.setTypesAttributes(typesdate);
        date.setEntities(domainModels);
        em.persist(date);
        em.flush();

        TypesAttributes typesdescription = new TypesAttributes();
        typesdescription = findTypesAttributes("String");

        Attributes description = new Attributes();
        description.setName("description");
        description.setTypesAttributes(typesdescription);
        description.setEntities(domainModels);
        em.persist(description);
        em.flush();

        TypesAttributes typesobservaciones = new TypesAttributes();
        typesobservaciones = findTypesAttributes("String");

        Attributes observaciones = new Attributes();
        observaciones.setName("observaciones");
        observaciones.setTypesAttributes(typesobservaciones);
        observaciones.setEntities(domainModels);
        em.persist(observaciones);
        em.flush();

    } // DomainModels()

//  ---------------------- Relationships -------------------------

    public void Relations() {

//  ---------------------- PropertiesAttributes *..* TypesAttributes -------------------------

        Entities fromPropertiesAttributes0 = new Entities();
        Cardinalities PropertiesAttributes0 = new Cardinalities();
        Entities   toPropertiesAttributes0 = new Entities();
        fromPropertiesAttributes0 = findEntities("PropertiesAttributes");
        PropertiesAttributes0 = findCardinalities("Muchos a Muchos Bidirecccional No.7");
        toPropertiesAttributes0 = findEntities("TypesAttributes");
        Relationships relPropertiesAttributes0 = new Relationships();
        relPropertiesAttributes0.setFrom(fromPropertiesAttributes0);
        relPropertiesAttributes0.setCardinalities(PropertiesAttributes0);
        relPropertiesAttributes0.setTo(toPropertiesAttributes0);
        relPropertiesAttributes0.setOptionality(true);
        em.persist(relPropertiesAttributes0);
        em.flush();

//  ---------------------- TypesAttributes *..* PropertiesAttributes -------------------------

        Entities fromTypesAttributes0 = new Entities();
        Cardinalities TypesAttributes0 = new Cardinalities();
        Entities   toTypesAttributes0 = new Entities();
        fromTypesAttributes0 = findEntities("TypesAttributes");
        TypesAttributes0 = findCardinalities("Muchos a Muchos Bidirecccional No.7");
        toTypesAttributes0 = findEntities("PropertiesAttributes");
        Relationships relTypesAttributes0 = new Relationships();
        relTypesAttributes0.setFrom(fromTypesAttributes0);
        relTypesAttributes0.setCardinalities(TypesAttributes0);
        relTypesAttributes0.setTo(toTypesAttributes0);
        relTypesAttributes0.setOptionality(true);
        em.persist(relTypesAttributes0);
        em.flush();

//  ---------------------- SystemsModels 1..* DomainModels -------------------------

        Entities fromSystemsModels0 = new Entities();
        Cardinalities SystemsModels0 = new Cardinalities();
        Entities   toSystemsModels0 = new Entities();
        fromSystemsModels0 = findEntities("SystemsModels");
        SystemsModels0 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toSystemsModels0 = findEntities("DomainModels");
        Relationships relSystemsModels0 = new Relationships();
        relSystemsModels0.setFrom(fromSystemsModels0);
        relSystemsModels0.setCardinalities(SystemsModels0);
        relSystemsModels0.setTo(toSystemsModels0);
        relSystemsModels0.setOptionality(true);
        em.persist(relSystemsModels0);
        em.flush();

    } // Relations()
} // DomainModelsSetup

