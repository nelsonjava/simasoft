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
@Named("DomainModelsSetup")
public class DomainModelsSetup {

    private static final String QUERYA = "SELECT c FROM AttributesTypes c WHERE c.name LIKE :custName";
    private static final String QUERYB = "SELECT c FROM Entities c WHERE c.name LIKE :custName";
    private static final String QUERYC = "SELECT c FROM Cardinalities c WHERE c.name LIKE :custName";

    @PersistenceContext(unitName = "naifg7PU-JTA")
    private EntityManager em;

    private static final Logger log = Logger.getLogger(DomainModelsSetup.class.getName());

    public AttributesTypes findAttributesTypes(String name) {

        AttributesTypes attributesTypes = new AttributesTypes();
        List<AttributesTypes> results = em.createQuery(QUERYA).setParameter("custName", name).getResultList();

        if (!results.isEmpty()) {
           attributesTypes = results.get(0);
        }
        return attributesTypes;
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
        domainModels.setGroupId("co.simasoft");
        domainModels.setArtifactId("naifg8");
        domainModels.setVersion("1.0.0-SNAPSHOT");

        em.persist(domainModels);
        em.flush();

        GroupIds groupIds = new GroupIds();
        groupIds.setGroupId("co.simasoft.models.naif.domainmodels");
        groupIds.setDomainModels(domainModels);
        em.persist(groupIds);
        em.flush();

        Relationships(groupIds);
        Entities(groupIds);
        Attributes(groupIds);
        Cardinalities(groupIds);
        GroupIds(groupIds);
        PropertiesAttributes(groupIds);
        FilesModels(groupIds);
        Links(groupIds);
        LinksTypes(groupIds);
        NameQueries(groupIds);
        AttributesTypes(groupIds);
        DomainModels(groupIds);
        SystemsModels(groupIds);
        Imports(groupIds);
        Dependency(groupIds);
        Relations();

    } // data()

    public void Relationships(GroupIds groupIds) {

        Entities relationships = new Entities();
        relationships.setName("Relationships");
        relationships.setGroupIds(groupIds);
        em.persist(relationships);
        em.flush();

//      ---------------------- Attributes:Relationships -------------------------

        AttributesTypes typesentity = new AttributesTypes();
        typesentity = findAttributesTypes("String");

        Attributes entity = new Attributes();
        entity.setName("entity");
        entity.setNullable(true);
        entity.setSingle(false);
        entity.setAttributesTypes(typesentity);
        entity.setEntities(relationships);
        em.persist(entity);
        em.flush();

        AttributesTypes typesisEmbedded = new AttributesTypes();
        typesisEmbedded = findAttributesTypes("Boolean");

        Attributes isEmbedded = new Attributes();
        isEmbedded.setName("isEmbedded");
        isEmbedded.setNullable(true);
        isEmbedded.setSingle(false);
        isEmbedded.setAttributesTypes(typesisEmbedded);
        isEmbedded.setEntities(relationships);
        em.persist(isEmbedded);
        em.flush();


        AttributesTypes typesoptionality = new AttributesTypes();
        typesoptionality = findAttributesTypes("Boolean");

        Attributes optionality = new Attributes();
        optionality.setName("optionality");
        optionality.setNullable(true);
        optionality.setSingle(false);
        optionality.setAttributesTypes(typesoptionality);
        optionality.setEntities(relationships);
        em.persist(optionality);
        em.flush();

        AttributesTypes typesname = new AttributesTypes();
        typesname = findAttributesTypes("String");

        Attributes name = new Attributes();
        name.setName("name");
        name.setNullable(true);
        name.setSingle(false);
        name.setAttributesTypes(typesname);
        name.setEntities(relationships);
        em.persist(name);
        em.flush();

        AttributesTypes typesmappedby = new AttributesTypes();
        typesmappedby = findAttributesTypes("String");

        Attributes mappedby = new Attributes();
        mappedby.setName("mappedby");
        mappedby.setNullable(true);
        mappedby.setSingle(false);
        mappedby.setAttributesTypes(typesmappedby);
        mappedby.setEntities(relationships);
        em.persist(mappedby);
        em.flush();

        AttributesTypes typesannotationsMethod = new AttributesTypes();
        typesannotationsMethod = findAttributesTypes("String");

        Attributes annotationsMethod = new Attributes();
        annotationsMethod.setName("annotationsMethod");
        annotationsMethod.setNullable(true);
        annotationsMethod.setSingle(false);
        annotationsMethod.setAttributesTypes(typesannotationsMethod);
        annotationsMethod.setEntities(relationships);
        em.persist(annotationsMethod);
        em.flush();

        AttributesTypes typesannotationsField = new AttributesTypes();
        typesannotationsField = findAttributesTypes("String");

        Attributes annotationsField = new Attributes();
        annotationsField.setName("annotationsField");
        annotationsField.setNullable(true);
        annotationsField.setSingle(false);
        annotationsField.setAttributesTypes(typesannotationsField);
        annotationsField.setEntities(relationships);
        em.persist(annotationsField);
        em.flush();

        AttributesTypes typestabla = new AttributesTypes();
        typestabla = findAttributesTypes("String");

        Attributes tabla = new Attributes();
        tabla.setName("table");
        tabla.setNullable(true);
        tabla.setSingle(false);
        tabla.setAttributesTypes(typestabla);
        tabla.setEntities(relationships);
        em.persist(tabla);
        em.flush();

        AttributesTypes typesidTabla1 = new AttributesTypes();
        typesidTabla1 = findAttributesTypes("String");

        Attributes idTabla1 = new Attributes();
        idTabla1.setName("idTable1");
        idTabla1.setNullable(true);
        idTabla1.setSingle(false);
        idTabla1.setAttributesTypes(typesidTabla1);
        idTabla1.setEntities(relationships);
        em.persist(idTabla1);
        em.flush();

        AttributesTypes typesidTabla2 = new AttributesTypes();
        typesidTabla2 = findAttributesTypes("String");

        Attributes idTabla2 = new Attributes();
        idTabla2.setName("idTable2");
        idTabla2.setNullable(true);
        idTabla2.setSingle(false);
        idTabla2.setAttributesTypes(typesidTabla2);
        idTabla2.setEntities(relationships);
        em.persist(idTabla2);
        em.flush();

        AttributesTypes typesdescription = new AttributesTypes();
        typesdescription = findAttributesTypes("String");

        Attributes description = new Attributes();
        description.setName("description");
        description.setNullable(true);
        description.setSingle(false);
        description.setAttributesTypes(typesdescription);
        description.setEntities(relationships);
        em.persist(description);
        em.flush();

        AttributesTypes typesobservaciones = new AttributesTypes();
        typesobservaciones = findAttributesTypes("String");

        Attributes observaciones = new Attributes();
        observaciones.setName("observations");
        observaciones.setNullable(true);
        observaciones.setSingle(false);
        observaciones.setAttributesTypes(typesobservaciones);
        observaciones.setEntities(relationships);
        em.persist(observaciones);
        em.flush();

    } // Relationships()

    public void Entities(GroupIds groupIds) {

        Entities entities = new Entities();
        entities.setName("Entities");
        entities.setGroupIds(groupIds);
        em.persist(entities);
        em.flush();

//      ---------------------- Attributes:Entities -------------------------

        AttributesTypes typesname = new AttributesTypes();
        typesname = findAttributesTypes("String");

        Attributes name = new Attributes();
        name.setName("name");
        name.setNullable(false);
        name.setSingle(false);
        name.setAttributesTypes(typesname);
        name.setEntities(entities);
        em.persist(name);
        em.flush();

        AttributesTypes typesserialID = new AttributesTypes();
        typesserialID = findAttributesTypes("String");

        Attributes serialID = new Attributes();
        serialID.setName("serialID");
        serialID.setNullable(true);
        serialID.setSingle(true);
        serialID.setAttributesTypes(typesserialID);
        serialID.setEntities(entities);
        em.persist(serialID);
        em.flush();

        AttributesTypes typestable = new AttributesTypes();
        typestable = findAttributesTypes("String");

        Attributes table = new Attributes();
        table.setName("table");
        table.setNullable(true);
        table.setSingle(false);
        table.setAttributesTypes(typestable);
        table.setEntities(entities);
        em.persist(table);
        em.flush();

        AttributesTypes typestableSecuencia = new AttributesTypes();
        typestableSecuencia = findAttributesTypes("String");

        Attributes tableSecuencia = new Attributes();
        tableSecuencia.setName("tableSecuencia");
        tableSecuencia.setNullable(true);
        tableSecuencia.setSingle(false);
        tableSecuencia.setAttributesTypes(typestableSecuencia);
        tableSecuencia.setEntities(entities);
        em.persist(tableSecuencia);
        em.flush();

        AttributesTypes typesmodifier = new AttributesTypes();
        typesmodifier = findAttributesTypes("String");

        Attributes modifier = new Attributes();
        modifier.setName("modifier");
        modifier.setNullable(true);
        modifier.setSingle(false);
        modifier.setAttributesTypes(typesmodifier);
        modifier.setEntities(entities);
        em.persist(modifier);
        em.flush();

        AttributesTypes typesextend = new AttributesTypes();
        typesextend = findAttributesTypes("String");

        Attributes extend = new Attributes();
        extend.setName("extend");
        extend.setNullable(true);
        extend.setSingle(false);
        extend.setAttributesTypes(typesextend);
        extend.setEntities(entities);
        em.persist(extend);
        em.flush();

        AttributesTypes typesannotations = new AttributesTypes();
        typesannotations = findAttributesTypes("Text");

        Attributes annotations = new Attributes();
        annotations.setName("annotations");
        annotations.setNullable(true);
        annotations.setSingle(false);
        annotations.setAttributesTypes(typesannotations);
        annotations.setEntities(entities);
        em.persist(annotations);
        em.flush();

        AttributesTypes typessource = new AttributesTypes();
        typessource = findAttributesTypes("Text");

        Attributes source = new Attributes();
        source.setName("source");
        source.setNullable(true);
        source.setSingle(false);
        source.setAttributesTypes(typessource);
        source.setEntities(entities);
        em.persist(source);
        em.flush();

        AttributesTypes typesdescription = new AttributesTypes();
        typesdescription = findAttributesTypes("String");

        Attributes description = new Attributes();
        description.setName("description");
        description.setNullable(true);
        description.setSingle(false);
        description.setAttributesTypes(typesdescription);
        description.setEntities(entities);
        em.persist(description);
        em.flush();

        AttributesTypes typesobservations = new AttributesTypes();
        typesobservations = findAttributesTypes("Text");

        Attributes observations = new Attributes();
        observations.setName("observations");
        observations.setNullable(true);
        observations.setSingle(false);
        observations.setAttributesTypes(typesobservations);
        observations.setEntities(entities);
        em.persist(observations);
        em.flush();

    } // Entities()

    public void Attributes(GroupIds groupIds) {

        Entities attributes = new Entities();
        attributes.setName("Attributes");
        attributes.setGroupIds(groupIds);
        em.persist(attributes);
        em.flush();

//      ---------------------- Attributes:Attributes -------------------------

        AttributesTypes typesname = new AttributesTypes();
        typesname = findAttributesTypes("String");

        Attributes name = new Attributes();
        name.setName("name");
        name.setNullable(false);
        name.setSingle(false);
        name.setAttributesTypes(typesname);
        name.setEntities(attributes);
        em.persist(name);
        em.flush();

        AttributesTypes typeslength = new AttributesTypes();
        typeslength = findAttributesTypes("Integer");

        Attributes length = new Attributes();
        length.setName("length");
        length.setNullable(true);
        length.setSingle(false);
        length.setAttributesTypes(typeslength);
        length.setEntities(attributes);
        em.persist(length);
        em.flush();

        AttributesTypes typesprecision = new AttributesTypes();
        typesprecision = findAttributesTypes("Integer");

        Attributes precision = new Attributes();
        precision.setName("precision");
        precision.setNullable(true);
        precision.setSingle(false);
        precision.setAttributesTypes(typesprecision);
        precision.setEntities(attributes);
        em.persist(precision);
        em.flush();

        AttributesTypes typesnullable = new AttributesTypes();
        typesnullable = findAttributesTypes("Boolean");

        Attributes nullable = new Attributes();
        nullable.setName("nullable");
        nullable.setNullable(true);
        nullable.setSingle(false);
        nullable.setAttributesTypes(typesnullable);
        nullable.setEntities(attributes);
        em.persist(nullable);
        em.flush();

        AttributesTypes typesunique = new AttributesTypes();
        typesunique = findAttributesTypes("Boolean");

        Attributes unique = new Attributes();
        unique.setName("single");
        unique.setNullable(true);
        unique.setSingle(false);
        unique.setAttributesTypes(typesunique);
        unique.setEntities(attributes);
        em.persist(unique);
        em.flush();

        AttributesTypes typesdescripcion = new AttributesTypes();
        typesdescripcion = findAttributesTypes("String");

        Attributes descripcion = new Attributes();
        descripcion.setName("descripcion");
        descripcion.setNullable(true);
        descripcion.setSingle(false);
        descripcion.setAttributesTypes(typesdescripcion);
        descripcion.setEntities(attributes);
        em.persist(descripcion);
        em.flush();

        AttributesTypes typesfield = new AttributesTypes();
        typesfield = findAttributesTypes("String");

        Attributes field = new Attributes();
        field.setName("field");
        field.setNullable(true);
        field.setSingle(false);
        field.setAttributesTypes(typesfield);
        field.setEntities(attributes);
        em.persist(field);
        em.flush();

        AttributesTypes typesaccess = new AttributesTypes();
        typesaccess = findAttributesTypes("String");

        Attributes access = new Attributes();
        access.setName("access");
        access.setNullable(true);
        access.setSingle(false);
        access.setAttributesTypes(typesaccess);
        access.setEntities(attributes);
        em.persist(access);
        em.flush();

        AttributesTypes typescolumnDefinition = new AttributesTypes();
        typescolumnDefinition = findAttributesTypes("String");

        Attributes columnDefinition = new Attributes();
        columnDefinition.setName("columnDefinition");
        columnDefinition.setNullable(true);
        columnDefinition.setSingle(false);
        columnDefinition.setAttributesTypes(typescolumnDefinition);
        columnDefinition.setEntities(attributes);
        em.persist(columnDefinition);
        em.flush();

        AttributesTypes typesannotationsField = new AttributesTypes();
        typesannotationsField = findAttributesTypes("Text");

        Attributes annotationsField = new Attributes();
        annotationsField.setName("annotationsField");
        annotationsField.setNullable(true);
        annotationsField.setSingle(false);
        annotationsField.setAttributesTypes(typesannotationsField);
        annotationsField.setEntities(attributes);
        em.persist(annotationsField);
        em.flush();

        AttributesTypes typesannotationsMethod = new AttributesTypes();
        typesannotationsMethod = findAttributesTypes("Text");

        Attributes annotationsMethod = new Attributes();
        annotationsMethod.setName("annotationsMethod");
        annotationsMethod.setNullable(true);
        annotationsMethod.setSingle(false);
        annotationsMethod.setAttributesTypes(typesannotationsMethod);
        annotationsMethod.setEntities(attributes);
        em.persist(annotationsMethod);
        em.flush();

        AttributesTypes typesobservations = new AttributesTypes();
        typesobservations = findAttributesTypes("Text");

        Attributes observations = new Attributes();
        observations.setName("observations");
        observations.setNullable(true);
        observations.setSingle(false);
        observations.setAttributesTypes(typesobservations);
        observations.setEntities(attributes);
        em.persist(observations);
        em.flush();

    } // Attributes()

    public void Cardinalities(GroupIds groupIds) {

        Entities cardinalities = new Entities();
        cardinalities.setName("Cardinalities");
        cardinalities.setGroupIds(groupIds);
        em.persist(cardinalities);
        em.flush();

//      ---------------------- Attributes:Cardinalities -------------------------

        AttributesTypes typesname = new AttributesTypes();
        typesname = findAttributesTypes("String");

        Attributes name = new Attributes();
        name.setName("name");
        name.setNullable(false);
        name.setSingle(true);
        name.setAttributesTypes(typesname);
        name.setEntities(cardinalities);
        em.persist(name);
        em.flush();

        AttributesTypes typescardinality = new AttributesTypes();
        typescardinality = findAttributesTypes("String");

        Attributes cardinality = new Attributes();
        cardinality.setName("cardinality");
        cardinality.setNullable(false);
        cardinality.setSingle(false);
        cardinality.setAttributesTypes(typescardinality);
        cardinality.setEntities(cardinalities);
        em.persist(cardinality);
        em.flush();

        AttributesTypes typesunidirectional = new AttributesTypes();
        typesunidirectional = findAttributesTypes("Boolean");

        Attributes unidirectional = new Attributes();
        unidirectional.setName("unidirectional");
        unidirectional.setNullable(true);
        unidirectional.setSingle(false);
        unidirectional.setAttributesTypes(typesunidirectional);
        unidirectional.setEntities(cardinalities);
        em.persist(unidirectional);
        em.flush();

        AttributesTypes typesannotations = new AttributesTypes();
        typesannotations = findAttributesTypes("Text");

        Attributes annotations = new Attributes();
        annotations.setName("annotations");
        annotations.setNullable(true);
        annotations.setSingle(false);
        annotations.setAttributesTypes(typesannotations);
        annotations.setEntities(cardinalities);
        em.persist(annotations);
        em.flush();

        AttributesTypes typesobservations = new AttributesTypes();
        typesobservations = findAttributesTypes("Text");

        Attributes observations = new Attributes();
        observations.setName("observations");
        observations.setNullable(true);
        observations.setSingle(false);
        observations.setAttributesTypes(typesobservations);
        observations.setEntities(cardinalities);
        em.persist(observations);
        em.flush();

    } // Cardinalities()

    public void GroupIds(GroupIds groupIds) {

        Entities groupId = new Entities();
        groupId.setName("GroupIds");
        groupId.setGroupIds(groupIds);
        em.persist(groupId);
        em.flush();
//      ---------------------- Attributes:GroupIds -------------------------

        AttributesTypes typesname = new AttributesTypes();
        typesname = findAttributesTypes("String");

        Attributes name = new Attributes();
        name.setName("name");
        name.setNullable(true);
        name.setSingle(false);
        name.setAttributesTypes(typesname);
        name.setEntities(groupId);
        em.persist(name);
        em.flush();

        AttributesTypes typesgroupId = new AttributesTypes();
        typesgroupId = findAttributesTypes("String");

        Attributes attributes = new Attributes();
        attributes.setName("groupId");
        attributes.setNullable(false);
        attributes.setSingle(false);
        attributes.setAttributesTypes(typesgroupId);
        attributes.setEntities(groupId);
        em.persist(attributes);
        em.flush();
        AttributesTypes typesartifactId = new AttributesTypes();
        typesartifactId = findAttributesTypes("String");

        Attributes artifactId = new Attributes();
        artifactId.setName("artifactId");
        artifactId.setNullable(true);
        artifactId.setSingle(true);
        artifactId.setAttributesTypes(typesartifactId);
        artifactId.setEntities(groupId);
        em.persist(artifactId);
        em.flush();

        AttributesTypes typesversion = new AttributesTypes();
        typesversion = findAttributesTypes("String");

        Attributes version = new Attributes();
        version.setName("version");
        version.setNullable(true);
        version.setSingle(false);
        version.setAttributesTypes(typesversion);
        version.setEntities(groupId);
        em.persist(version);
        em.flush();

        AttributesTypes typescode = new AttributesTypes();
        typescode = findAttributesTypes("String");

        Attributes code = new Attributes();
        code.setName("code");
        code.setNullable(true);
        code.setSingle(true);
        code.setAttributesTypes(typescode);
        code.setEntities(groupId);
        em.persist(code);
        em.flush();

        AttributesTypes typesdate = new AttributesTypes();
        typesdate = findAttributesTypes("Date");

        Attributes date = new Attributes();
        date.setName("date");
        date.setNullable(true);
        date.setSingle(false);
        date.setAttributesTypes(typesdate);
        date.setEntities(groupId);
        em.persist(date);
        em.flush();

        AttributesTypes typesdescription = new AttributesTypes();
        typesdescription = findAttributesTypes("String");

        Attributes description = new Attributes();
        description.setName("description");
        description.setNullable(true);
        description.setSingle(false);
        description.setAttributesTypes(typesdescription);
        description.setEntities(groupId);
        em.persist(description);
        em.flush();

        AttributesTypes typesobservations = new AttributesTypes();
        typesobservations = findAttributesTypes("Text");

        Attributes observations = new Attributes();
        observations.setName("observations");
        observations.setNullable(true);
        observations.setSingle(false);
        observations.setAttributesTypes(typesobservations);
        observations.setEntities(groupId);
        em.persist(observations);
        em.flush();

    } // GroupIds()

    public void PropertiesAttributes(GroupIds groupIds) {

        Entities propertiesAttributes = new Entities();
        propertiesAttributes.setName("PropertiesAttributes");
        propertiesAttributes.setGroupIds(groupIds);
        em.persist(propertiesAttributes);
        em.flush();

//      ---------------------- Attributes:PropertiesAttributes -------------------------

        AttributesTypes typesname = new AttributesTypes();
        typesname = findAttributesTypes("String");

        Attributes name = new Attributes();
        name.setName("name");
        name.setNullable(false);
        name.setSingle(true);
        name.setAttributesTypes(typesname);
        name.setEntities(propertiesAttributes);
        em.persist(name);
        em.flush();

        AttributesTypes typesvalue = new AttributesTypes();
        typesvalue = findAttributesTypes("String");

        Attributes value = new Attributes();
        value.setName("value");
        value.setNullable(false);
        value.setSingle(true);
        value.setAttributesTypes(typesvalue);
        value.setEntities(propertiesAttributes);
        em.persist(value);
        em.flush();

        AttributesTypes typesobservations = new AttributesTypes();
        typesobservations = findAttributesTypes("Text");

        Attributes observations = new Attributes();
        observations.setName("observations");
        observations.setNullable(true);
        observations.setSingle(false);
        observations.setAttributesTypes(typesobservations);
        observations.setEntities(propertiesAttributes);
        em.persist(observations);
        em.flush();

    } // PropertiesAttributes()

    public void FilesModels(GroupIds groupIds) {

        Entities filesModels = new Entities();
        filesModels.setName("FilesModels");
        filesModels.setGroupIds(groupIds);
        em.persist(filesModels);
        em.flush();

//      ---------------------- Attributes:FilesModels -------------------------

        AttributesTypes typesname = new AttributesTypes();
        typesname = findAttributesTypes("String");

        Attributes name = new Attributes();
        name.setName("name");
        name.setNullable(false);
        name.setSingle(true);
        name.setAttributesTypes(typesname);
        name.setEntities(filesModels);
        em.persist(name);
        em.flush();

        AttributesTypes typesextension = new AttributesTypes();
        typesextension = findAttributesTypes("String");

        Attributes extension = new Attributes();
        extension.setName("extension");
        extension.setNullable(false);
        extension.setSingle(false);
        extension.setAttributesTypes(typesextension);
        extension.setEntities(filesModels);
        em.persist(extension);
        em.flush();

        AttributesTypes typesdate = new AttributesTypes();
        typesdate = findAttributesTypes("Date");

        Attributes date = new Attributes();
        date.setName("date");
        date.setNullable(false);
        date.setSingle(false);
        date.setAttributesTypes(typesdate);
        date.setEntities(filesModels);
        em.persist(date);
        em.flush();

        AttributesTypes typesurl = new AttributesTypes();
        typesurl = findAttributesTypes("String");

        Attributes url = new Attributes();
        url.setName("url");
        url.setNullable(false);
        url.setSingle(false);
        url.setAttributesTypes(typesurl);
        url.setEntities(filesModels);
        em.persist(url);
        em.flush();

        AttributesTypes typesdata = new AttributesTypes();
        typesdata = findAttributesTypes("byte");

        Attributes data = new Attributes();
        data.setName("data");
        data.setNullable(true);
        data.setSingle(false);
        data.setAttributesTypes(typesdata);
        data.setEntities(filesModels);
        em.persist(data);
        em.flush();

        AttributesTypes typesobservations = new AttributesTypes();
        typesobservations = findAttributesTypes("Text");

        Attributes observations = new Attributes();
        observations.setName("observations");
        observations.setNullable(true);
        observations.setSingle(false);
        observations.setAttributesTypes(typesobservations);
        observations.setEntities(filesModels);
        em.persist(observations);
        em.flush();

    } // FilesModels()

    public void Links(GroupIds groupIds) {

        Entities links = new Entities();
        links.setName("Links");
        links.setGroupIds(groupIds);
        em.persist(links);
        em.flush();

//      ---------------------- Attributes:Links -------------------------

        AttributesTypes typestitle = new AttributesTypes();
        typestitle = findAttributesTypes("String");

        Attributes title = new Attributes();
        title.setName("title");
        title.setNullable(false);
        title.setSingle(true);
        title.setAttributesTypes(typestitle);
        title.setEntities(links);
        em.persist(title);
        em.flush();

        AttributesTypes typeslink = new AttributesTypes();
        typeslink = findAttributesTypes("String");

        Attributes link = new Attributes();
        link.setName("link");
        link.setNullable(false);
        link.setSingle(true);
        link.setAttributesTypes(typeslink);
        link.setEntities(links);
        em.persist(link);
        em.flush();

        AttributesTypes typesobservations = new AttributesTypes();
        typesobservations = findAttributesTypes("Text");

        Attributes observations = new Attributes();
        observations.setName("observations");
        observations.setNullable(true);
        observations.setSingle(false);
        observations.setAttributesTypes(typesobservations);
        observations.setEntities(links);
        em.persist(observations);
        em.flush();

    } // Links()

    public void LinksTypes(GroupIds groupIds) {

        Entities linksTypes = new Entities();
        linksTypes.setName("LinksTypes");
        linksTypes.setGroupIds(groupIds);
        em.persist(linksTypes);
        em.flush();

//      ---------------------- Attributes:LinksTypes -------------------------

        AttributesTypes typesname = new AttributesTypes();
        typesname = findAttributesTypes("String");

        Attributes name = new Attributes();
        name.setName("name");
        name.setNullable(false);
        name.setSingle(true);
        name.setAttributesTypes(typesname);
        name.setEntities(linksTypes);
        em.persist(name);
        em.flush();

    } // LinksTypes()

    public void NameQueries(GroupIds groupIds) {

        Entities nameQueries = new Entities();
        nameQueries.setName("NameQueries");
        nameQueries.setGroupIds(groupIds);
        em.persist(nameQueries);
        em.flush();

//      ---------------------- Attributes:NameQueries -------------------------

        AttributesTypes typesname = new AttributesTypes();
        typesname = findAttributesTypes("String");

        Attributes name = new Attributes();
        name.setName("name");
        name.setNullable(false);
        name.setSingle(true);
        name.setAttributesTypes(typesname);
        name.setEntities(nameQueries);
        em.persist(name);
        em.flush();

        AttributesTypes typesquery = new AttributesTypes();
        typesquery = findAttributesTypes("Text");

        Attributes query = new Attributes();
        query.setName("query");
        query.setNullable(false);
        query.setSingle(true);
        query.setAttributesTypes(typesquery);
        query.setEntities(nameQueries);
        em.persist(query);
        em.flush();

        AttributesTypes typesobservations = new AttributesTypes();
        typesobservations = findAttributesTypes("Text");

        Attributes observations = new Attributes();
        observations.setName("observations");
        observations.setNullable(true);
        observations.setSingle(false);
        observations.setAttributesTypes(typesobservations);
        observations.setEntities(nameQueries);
        em.persist(observations);
        em.flush();

    } // NameQueries()

    public void AttributesTypes(GroupIds groupIds) {

        Entities AttributesTypes = new Entities();
        AttributesTypes.setName("AttributesTypes");
        AttributesTypes.setGroupIds(groupIds);
        em.persist(AttributesTypes);
        em.flush();

//      ---------------------- Attributes:AttributesTypes -------------------------

        AttributesTypes typesname = new AttributesTypes();
        typesname = findAttributesTypes("String");

        Attributes name = new Attributes();
        name.setName("name");
        name.setNullable(false);
        name.setSingle(true);
        name.setAttributesTypes(typesname);
        name.setEntities(AttributesTypes);
        em.persist(name);
        em.flush();

        AttributesTypes typestype = new AttributesTypes();
        typestype = findAttributesTypes("String");

        Attributes type = new Attributes();
        type.setName("type");
        type.setNullable(false);
        type.setSingle(false);
        type.setAttributesTypes(typestype);
        type.setEntities(AttributesTypes);
        em.persist(type);
        em.flush();

        AttributesTypes typeslength = new AttributesTypes();
        typeslength = findAttributesTypes("Integer");

        Attributes length = new Attributes();
        length.setName("length");
        length.setNullable(true);
        length.setSingle(false);
        length.setAttributesTypes(typeslength);
        length.setEntities(AttributesTypes);
        em.persist(length);
        em.flush();

        AttributesTypes typesprecision = new AttributesTypes();
        typesprecision = findAttributesTypes("Integer");

        Attributes precision = new Attributes();
        precision.setName("precision");
        precision.setNullable(true);
        precision.setSingle(false);
        precision.setAttributesTypes(typesprecision);
        precision.setEntities(AttributesTypes);
        em.persist(precision);
        em.flush();

        AttributesTypes typesannotations = new AttributesTypes();
        typesannotations = findAttributesTypes("Text");

        Attributes annotations = new Attributes();
        annotations.setName("annotations");
        annotations.setNullable(true);
        annotations.setSingle(false);
        annotations.setAttributesTypes(typesannotations);
        annotations.setEntities(AttributesTypes);
        em.persist(annotations);
        em.flush();

        AttributesTypes typesobservations = new AttributesTypes();
        typesobservations = findAttributesTypes("Text");

        Attributes observations = new Attributes();
        observations.setName("observations");
        observations.setNullable(true);
        observations.setSingle(false);
        observations.setAttributesTypes(typesobservations);
        observations.setEntities(AttributesTypes);
        em.persist(observations);
        em.flush();

    } // AttributesTypes()

    public void DomainModels(GroupIds groupIds) {

        Entities domainModels = new Entities();
        domainModels.setName("DomainModels");
        domainModels.setGroupIds(groupIds);
        em.persist(domainModels);
        em.flush();

//      ---------------------- Attributes:DomainModels -------------------------

        AttributesTypes typesname = new AttributesTypes();
        typesname = findAttributesTypes("String");

        Attributes name = new Attributes();
        name.setName("name");
        name.setNullable(true);
        name.setSingle(false);
        name.setAttributesTypes(typesname);
        name.setEntities(domainModels);
        em.persist(name);
        em.flush();

        AttributesTypes typesgroupId = new AttributesTypes();
        typesgroupId = findAttributesTypes("String");

        Attributes groupId = new Attributes();
        groupId.setName("groupId");
        groupId.setNullable(false);
        groupId.setSingle(false);
        groupId.setAttributesTypes(typesgroupId);
        groupId.setEntities(domainModels);
        em.persist(groupId);
        em.flush();

        AttributesTypes typesartifactId = new AttributesTypes();
        typesartifactId = findAttributesTypes("String");

        Attributes artifactId = new Attributes();
        artifactId.setName("artifactId");
        artifactId.setNullable(false);
        artifactId.setSingle(true);
        artifactId.setAttributesTypes(typesartifactId);
        artifactId.setEntities(domainModels);
        em.persist(artifactId);
        em.flush();

        AttributesTypes typesversion = new AttributesTypes();
        typesversion = findAttributesTypes("String");

        Attributes version = new Attributes();
        version.setName("version");
        version.setNullable(false);
        version.setSingle(false);
        version.setAttributesTypes(typesversion);
        version.setEntities(domainModels);
        em.persist(version);
        em.flush();

        AttributesTypes typescode = new AttributesTypes();
        typescode = findAttributesTypes("String");

        Attributes code = new Attributes();
        code.setName("code");
        code.setNullable(true);
        code.setSingle(true);
        code.setAttributesTypes(typescode);
        code.setEntities(domainModels);
        em.persist(code);
        em.flush();

        AttributesTypes typesdate = new AttributesTypes();
        typesdate = findAttributesTypes("Date");

        Attributes date = new Attributes();
        date.setName("date");
        date.setNullable(true);
        date.setSingle(false);
        date.setAttributesTypes(typesdate);
        date.setEntities(domainModels);
        em.persist(date);
        em.flush();

        AttributesTypes typesdescription = new AttributesTypes();
        typesdescription = findAttributesTypes("String");

        Attributes description = new Attributes();
        description.setName("description");
        description.setNullable(true);
        description.setSingle(false);
        description.setAttributesTypes(typesdescription);
        description.setEntities(domainModels);
        em.persist(description);
        em.flush();

        AttributesTypes typesobservations = new AttributesTypes();
        typesobservations = findAttributesTypes("Text");

        Attributes observations = new Attributes();
        observations.setName("observations");
        observations.setNullable(true);
        observations.setSingle(false);
        observations.setAttributesTypes(typesobservations);
        observations.setEntities(domainModels);
        em.persist(observations);
        em.flush();

    } // DomainModels()

    public void SystemsModels(GroupIds groupIds) {

        Entities systemsModels = new Entities();
        systemsModels.setName("SystemsModels");
        systemsModels.setGroupIds(groupIds);
        em.persist(systemsModels);
        em.flush();

//      ---------------------- Attributes:SystemsModels -------------------------

        AttributesTypes typesname = new AttributesTypes();
        typesname = findAttributesTypes("String");

        Attributes name = new Attributes();
        name.setName("name");
        name.setNullable(false);
        name.setSingle(true);
        name.setAttributesTypes(typesname);
        name.setEntities(systemsModels);
        em.persist(name);
        em.flush();

        AttributesTypes typesdescription = new AttributesTypes();
        typesdescription = findAttributesTypes("String");

        Attributes description = new Attributes();
        description.setName("description");
        description.setNullable(true);
        description.setSingle(false);
        description.setAttributesTypes(typesdescription);
        description.setEntities(systemsModels);
        em.persist(description);
        em.flush();

        AttributesTypes typesobservations = new AttributesTypes();
        typesobservations = findAttributesTypes("Text");

        Attributes observations = new Attributes();
        observations.setName("observations");
        observations.setNullable(true);
        observations.setSingle(false);
        observations.setAttributesTypes(typesobservations);
        observations.setEntities(systemsModels);
        em.persist(observations);
        em.flush();

    } // SystemsModels()

    public void Imports(GroupIds groupIds) {

        Entities imports = new Entities();
        imports.setName("Imports");
        imports.setGroupIds(groupIds);
        em.persist(imports);
        em.flush();

//      ---------------------- Attributes:Imports -------------------------

        AttributesTypes typesname = new AttributesTypes();
        typesname = findAttributesTypes("String");

        Attributes name = new Attributes();
        name.setName("name");
        name.setNullable(false);
        name.setSingle(true);
        name.setAttributesTypes(typesname);
        name.setEntities(imports);
        em.persist(name);
        em.flush();

        AttributesTypes typesobservations = new AttributesTypes();
        typesobservations = findAttributesTypes("Text");

        Attributes observations = new Attributes();
        observations.setName("observations");
        observations.setNullable(true);
        observations.setSingle(false);
        observations.setAttributesTypes(typesobservations);
        observations.setEntities(imports);
        em.persist(observations);
        em.flush();

    } // Imports()

    public void Dependency(GroupIds groupIds) {

        Entities dependency = new Entities();
        dependency.setName("Dependency");
        dependency.setGroupIds(groupIds);
        em.persist(dependency);
        em.flush();

//      ---------------------- Attributes:Dependency -------------------------

        AttributesTypes typesgroupId = new AttributesTypes();
        typesgroupId = findAttributesTypes("String");

        Attributes groupId = new Attributes();
        groupId.setName("groupId");
        groupId.setNullable(false);
        groupId.setSingle(false);
        groupId.setAttributesTypes(typesgroupId);
        groupId.setEntities(dependency);
        em.persist(groupId);
        em.flush();

        AttributesTypes typesartifactId = new AttributesTypes();
        typesartifactId = findAttributesTypes("String");

        Attributes artifactId = new Attributes();
        artifactId.setName("artifactId");
        artifactId.setNullable(false);
        artifactId.setSingle(false);
        artifactId.setAttributesTypes(typesartifactId);
        artifactId.setEntities(dependency);
        em.persist(artifactId);
        em.flush();

        AttributesTypes typesversion = new AttributesTypes();
        typesversion = findAttributesTypes("String");

        Attributes version = new Attributes();
        version.setName("version");
        version.setNullable(true);
        version.setSingle(false);
        version.setAttributesTypes(typesversion);
        version.setEntities(dependency);
        em.persist(version);
        em.flush();

        AttributesTypes typestype = new AttributesTypes();
        typestype = findAttributesTypes("String");

        Attributes type = new Attributes();
        type.setName("type");
        type.setNullable(true);
        type.setSingle(false);
        type.setAttributesTypes(typestype);
        type.setEntities(dependency);
        em.persist(type);
        em.flush();

        AttributesTypes typesscope = new AttributesTypes();
        typesscope = findAttributesTypes("String");

        Attributes scope = new Attributes();
        scope.setName("scope");
        scope.setNullable(true);
        scope.setSingle(false);
        scope.setAttributesTypes(typesscope);
        scope.setEntities(dependency);
        em.persist(scope);
        em.flush();

        AttributesTypes typesmaven = new AttributesTypes();
        typesmaven = findAttributesTypes("Text");

        Attributes maven = new Attributes();
        maven.setName("maven");
        maven.setNullable(false);
        maven.setSingle(true);
        maven.setAttributesTypes(typesmaven);
        maven.setEntities(dependency);
        em.persist(maven);
        em.flush();

        AttributesTypes typeslink = new AttributesTypes();
        typeslink = findAttributesTypes("String");

        Attributes link = new Attributes();
        link.setName("link");
        link.setNullable(false);
        link.setSingle(false);
        link.setAttributesTypes(typeslink);
        link.setEntities(dependency);
        em.persist(link);
        em.flush();

        AttributesTypes typesobservations = new AttributesTypes();
        typesobservations = findAttributesTypes("Text");

        Attributes observations = new Attributes();
        observations.setName("observations");
        observations.setNullable(true);
        observations.setSingle(false);
        observations.setAttributesTypes(typesobservations);
        observations.setEntities(dependency);
        em.persist(observations);
        em.flush();

    } // Dependency()

//  ---------------------- Relationships -------------------------

    public void Relations() {

//  ---------------------- Entities 1..* Relationships -------------------------

        Entities fromEntities0 = new Entities();
        Cardinalities Entities0 = new Cardinalities();
        Entities   toEntities0 = new Entities();
        fromEntities0 = findEntities("Entities");
        Entities0 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toEntities0 = findEntities("Relationships");
        Relationships relEntities0 = new Relationships();
        relEntities0.setFrom(fromEntities0);
        relEntities0.setCardinalities(Entities0);
        relEntities0.setTo(toEntities0);
        relEntities0.setOptionality(true);
        relEntities0.setIsEmbedded(false);
        relEntities0.setName("from");
        em.persist(relEntities0);
        em.flush();

//  ---------------------- Entities *..* Imports -------------------------

        Entities fromEntities1 = new Entities();
        Cardinalities Entities1 = new Cardinalities();
        Entities   toEntities1 = new Entities();
        fromEntities1 = findEntities("Entities");
        Entities1 = findCardinalities("Muchos a Muchos Bidirecccional No.7");
        toEntities1 = findEntities("Imports");
        Relationships relEntities1 = new Relationships();
        relEntities1.setFrom(fromEntities1);
        relEntities1.setCardinalities(Entities1);
        relEntities1.setTo(toEntities1);
        relEntities1.setOptionality(true);
        relEntities1.setIsEmbedded(false);
        em.persist(relEntities1);
        em.flush();

//  ---------------------- Entities 1..* NameQueries -------------------------

        Entities fromEntities2 = new Entities();
        Cardinalities Entities2 = new Cardinalities();
        Entities   toEntities2 = new Entities();
        fromEntities2 = findEntities("Entities");
        Entities2 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toEntities2 = findEntities("NameQueries");
        Relationships relEntities2 = new Relationships();
        relEntities2.setFrom(fromEntities2);
        relEntities2.setCardinalities(Entities2);
        relEntities2.setTo(toEntities2);
        relEntities2.setOptionality(true);
        relEntities2.setIsEmbedded(false);
        em.persist(relEntities2);
        em.flush();

//  ---------------------- Entities 1..* Attributes -------------------------

        Entities fromEntities3 = new Entities();
        Cardinalities Entities3 = new Cardinalities();
        Entities   toEntities3 = new Entities();
        fromEntities3 = findEntities("Entities");
        Entities3 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toEntities3 = findEntities("Attributes");
        Relationships relEntities3 = new Relationships();
        relEntities3.setFrom(fromEntities3);
        relEntities3.setCardinalities(Entities3);
        relEntities3.setTo(toEntities3);
        relEntities3.setOptionality(true);
        relEntities3.setIsEmbedded(false);
        em.persist(relEntities3);
        em.flush();

//  ---------------------- Entities 1..* Relationships -------------------------

        Entities fromEntities5 = new Entities();
        Cardinalities Entities5 = new Cardinalities();
        Entities   toEntities5 = new Entities();
        fromEntities5 = findEntities("Entities");
        Entities5 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toEntities5 = findEntities("Relationships");
        Relationships relEntities5 = new Relationships();
        relEntities5.setFrom(fromEntities5);
        relEntities5.setCardinalities(Entities5);
        relEntities5.setTo(toEntities5);
        relEntities5.setOptionality(true);
        relEntities5.setIsEmbedded(false);
        relEntities5.setName("to");
        em.persist(relEntities5);
        em.flush();

//  ---------------------- Entities 1..* FilesModels -------------------------

        Entities fromEntities6 = new Entities();
        Cardinalities Entities6 = new Cardinalities();
        Entities   toEntities6 = new Entities();
        fromEntities6 = findEntities("Entities");
        Entities6 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toEntities6 = findEntities("FilesModels");
        Relationships relEntities6 = new Relationships();
        relEntities6.setFrom(fromEntities6);
        relEntities6.setCardinalities(Entities6);
        relEntities6.setTo(toEntities6);
        relEntities6.setOptionality(true);
        relEntities6.setIsEmbedded(false);
        em.persist(relEntities6);
        em.flush();

//  ---------------------- Attributes *..* PropertiesAttributes -------------------------

        Entities fromAttributes2 = new Entities();
        Cardinalities Attributes2 = new Cardinalities();
        Entities   toAttributes2 = new Entities();
        fromAttributes2 = findEntities("Attributes");
        Attributes2 = findCardinalities("Muchos a Muchos Bidirecccional No.7");
        toAttributes2 = findEntities("PropertiesAttributes");
        Relationships relAttributes2 = new Relationships();
        relAttributes2.setFrom(fromAttributes2);
        relAttributes2.setCardinalities(Attributes2);
        relAttributes2.setTo(toAttributes2);
        relAttributes2.setOptionality(true);
        relAttributes2.setIsEmbedded(false);
        em.persist(relAttributes2);
        em.flush();

//  ---------------------- Cardinalities 1..* Relationships -------------------------

        Entities fromCardinalities0 = new Entities();
        Cardinalities Cardinalities0 = new Cardinalities();
        Entities   toCardinalities0 = new Entities();
        fromCardinalities0 = findEntities("Cardinalities");
        Cardinalities0 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toCardinalities0 = findEntities("Relationships");
        Relationships relCardinalities0 = new Relationships();
        relCardinalities0.setFrom(fromCardinalities0);
        relCardinalities0.setCardinalities(Cardinalities0);
        relCardinalities0.setTo(toCardinalities0);
        relCardinalities0.setOptionality(true);
        relCardinalities0.setIsEmbedded(false);
        em.persist(relCardinalities0);
        em.flush();

//  ---------------------- Cardinalities *..* Imports -------------------------

        Entities fromCardinalities1 = new Entities();
        Cardinalities Cardinalities1 = new Cardinalities();
        Entities   toCardinalities1 = new Entities();
        fromCardinalities1 = findEntities("Cardinalities");
        Cardinalities1 = findCardinalities("Muchos a Muchos Bidirecccional No.7");
        toCardinalities1 = findEntities("Imports");
        Relationships relCardinalities1 = new Relationships();
        relCardinalities1.setFrom(fromCardinalities1);
        relCardinalities1.setCardinalities(Cardinalities1);
        relCardinalities1.setTo(toCardinalities1);
        relCardinalities1.setOptionality(true);
        relCardinalities1.setIsEmbedded(false);
        em.persist(relCardinalities1);
        em.flush();

//  ---------------------- GroupIds 1..* FilesModels -------------------------

        Entities fromGroupIds0 = new Entities();
        Cardinalities GroupIds0 = new Cardinalities();
        Entities   toGroupIds0 = new Entities();
        fromGroupIds0 = findEntities("GroupIds");
        GroupIds0 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toGroupIds0 = findEntities("FilesModels");
        Relationships relGroupIds0 = new Relationships();
        relGroupIds0.setFrom(fromGroupIds0);
        relGroupIds0.setCardinalities(GroupIds0);
        relGroupIds0.setTo(toGroupIds0);
        relGroupIds0.setOptionality(true);
        relGroupIds0.setIsEmbedded(false);
        em.persist(relGroupIds0);
        em.flush();

//  ---------------------- GroupIds 1..* Links -------------------------

        Entities fromGroupIds1 = new Entities();
        Cardinalities GroupIds1 = new Cardinalities();
        Entities   toGroupIds1 = new Entities();
        fromGroupIds1 = findEntities("GroupIds");
        GroupIds1 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toGroupIds1 = findEntities("Links");
        Relationships relGroupIds1 = new Relationships();
        relGroupIds1.setFrom(fromGroupIds1);
        relGroupIds1.setCardinalities(GroupIds1);
        relGroupIds1.setTo(toGroupIds1);
        relGroupIds1.setOptionality(true);
        relGroupIds1.setIsEmbedded(false);
        em.persist(relGroupIds1);
        em.flush();

//  ---------------------- GroupIds 1..* Entities -------------------------

        Entities fromGroupIds2 = new Entities();
        Cardinalities GroupIds2 = new Cardinalities();
        Entities   toGroupIds2 = new Entities();
        fromGroupIds2 = findEntities("GroupIds");
        GroupIds2 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toGroupIds2 = findEntities("Entities");
        Relationships relGroupIds2 = new Relationships();
        relGroupIds2.setFrom(fromGroupIds2);
        relGroupIds2.setCardinalities(GroupIds2);
        relGroupIds2.setTo(toGroupIds2);
        relGroupIds2.setOptionality(true);
        relGroupIds2.setIsEmbedded(false);
        em.persist(relGroupIds2);
        em.flush();

//  ---------------------- PropertiesAttributes *..* Imports -------------------------

        Entities fromPropertiesAttributes0 = new Entities();
        Cardinalities PropertiesAttributes0 = new Cardinalities();
        Entities   toPropertiesAttributes0 = new Entities();
        fromPropertiesAttributes0 = findEntities("PropertiesAttributes");
        PropertiesAttributes0 = findCardinalities("Muchos a Muchos Bidirecccional No.7");
        toPropertiesAttributes0 = findEntities("Imports");
        Relationships relPropertiesAttributes0 = new Relationships();
        relPropertiesAttributes0.setFrom(fromPropertiesAttributes0);
        relPropertiesAttributes0.setCardinalities(PropertiesAttributes0);
        relPropertiesAttributes0.setTo(toPropertiesAttributes0);
        relPropertiesAttributes0.setOptionality(true);
        relPropertiesAttributes0.setIsEmbedded(false);
        em.persist(relPropertiesAttributes0);
        em.flush();

//  ---------------------- PropertiesAttributes *..* Attributes -------------------------

/*
        Entities fromPropertiesAttributes1 = new Entities();
        Cardinalities PropertiesAttributes1 = new Cardinalities();
        Entities   toPropertiesAttributes1 = new Entities();
        fromPropertiesAttributes1 = findEntities("PropertiesAttributes");
        PropertiesAttributes1 = findCardinalities("Muchos a Muchos Bidirecccional No.7");
        toPropertiesAttributes1 = findEntities("Attributes");
        Relationships relPropertiesAttributes1 = new Relationships();
        relPropertiesAttributes1.setFrom(fromPropertiesAttributes1);
        relPropertiesAttributes1.setCardinalities(PropertiesAttributes1);
        relPropertiesAttributes1.setTo(toPropertiesAttributes1);
        relPropertiesAttributes1.setOptionality(true);
        relPropertiesAttributes1.setIsEmbedded(false);
        em.persist(relPropertiesAttributes1);
        em.flush();
*/        

//  ---------------------- PropertiesAttributes *..* AttributesTypes -------------------------

/*
        Entities fromPropertiesAttributes2 = new Entities();
        Cardinalities PropertiesAttributes2 = new Cardinalities();
        Entities   toPropertiesAttributes2 = new Entities();
        fromPropertiesAttributes2 = findEntities("PropertiesAttributes");
        PropertiesAttributes2 = findCardinalities("Muchos a Muchos Bidirecccional No.7");
        toPropertiesAttributes2 = findEntities("AttributesTypes");
        Relationships relPropertiesAttributes2 = new Relationships();
        relPropertiesAttributes2.setFrom(fromPropertiesAttributes2);
        relPropertiesAttributes2.setCardinalities(PropertiesAttributes2);
        relPropertiesAttributes2.setTo(toPropertiesAttributes2);
        relPropertiesAttributes2.setOptionality(true);
        relPropertiesAttributes2.setIsEmbedded(false);
        em.persist(relPropertiesAttributes2);
        em.flush();
*/

//  ---------------------- LinksTypes 1..* Links -------------------------

        Entities fromLinksTypes0 = new Entities();
        Cardinalities LinksTypes0 = new Cardinalities();
        Entities   toLinksTypes0 = new Entities();
        fromLinksTypes0 = findEntities("LinksTypes");
        LinksTypes0 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toLinksTypes0 = findEntities("Links");
        Relationships relLinksTypes0 = new Relationships();
        relLinksTypes0.setFrom(fromLinksTypes0);
        relLinksTypes0.setCardinalities(LinksTypes0);
        relLinksTypes0.setTo(toLinksTypes0);
        relLinksTypes0.setOptionality(true);
        relLinksTypes0.setIsEmbedded(false);
        em.persist(relLinksTypes0);
        em.flush();

//  ---------------------- Relationships 1..* PropertiesAttributes -------------------------

        Entities fromRelationships3 = new Entities();
        Cardinalities Relationships3 = new Cardinalities();
        Entities   toRelationships3 = new Entities();
        fromRelationships3 = findEntities("Relationships");
        Relationships3 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toRelationships3 = findEntities("PropertiesAttributes");
        Relationships relRelationships3 = new Relationships();
        relRelationships3.setFrom(fromRelationships3);
        relRelationships3.setCardinalities(Relationships3);
        relRelationships3.setTo(toRelationships3);
        relRelationships3.setOptionality(true);
        relRelationships3.setIsEmbedded(false);
        em.persist(relRelationships3);
        em.flush();

//  ---------------------- AttributesTypes *..* PropertiesAttributes -------------------------

        Entities fromAttributesTypes0 = new Entities();
        Cardinalities AttributesTypes0 = new Cardinalities();
        Entities   toAttributesTypes0 = new Entities();
        fromAttributesTypes0 = findEntities("AttributesTypes");
        AttributesTypes0 = findCardinalities("Muchos a Muchos Bidirecccional No.7");
        toAttributesTypes0 = findEntities("PropertiesAttributes");
        Relationships relAttributesTypes0 = new Relationships();
        relAttributesTypes0.setFrom(fromAttributesTypes0);
        relAttributesTypes0.setCardinalities(AttributesTypes0);
        relAttributesTypes0.setTo(toAttributesTypes0);
        relAttributesTypes0.setOptionality(true);
        relAttributesTypes0.setIsEmbedded(false);
        em.persist(relAttributesTypes0);
        em.flush();

//  ---------------------- AttributesTypes 1..* Attributes -------------------------

        Entities fromAttributesTypes1 = new Entities();
        Cardinalities AttributesTypes1 = new Cardinalities();
        Entities   toAttributesTypes1 = new Entities();
        fromAttributesTypes1 = findEntities("AttributesTypes");
        AttributesTypes1 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toAttributesTypes1 = findEntities("Attributes");
        Relationships relAttributesTypes1 = new Relationships();
        relAttributesTypes1.setFrom(fromAttributesTypes1);
        relAttributesTypes1.setCardinalities(AttributesTypes1);
        relAttributesTypes1.setTo(toAttributesTypes1);
        relAttributesTypes1.setOptionality(true);
        relAttributesTypes1.setIsEmbedded(false);
        em.persist(relAttributesTypes1);
        em.flush();

//  ---------------------- DomainModels 1..* FilesModels -------------------------

        Entities fromDomainModels0 = new Entities();
        Cardinalities DomainModels0 = new Cardinalities();
        Entities   toDomainModels0 = new Entities();
        fromDomainModels0 = findEntities("DomainModels");
        DomainModels0 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toDomainModels0 = findEntities("FilesModels");
        Relationships relDomainModels0 = new Relationships();
        relDomainModels0.setFrom(fromDomainModels0);
        relDomainModels0.setCardinalities(DomainModels0);
        relDomainModels0.setTo(toDomainModels0);
        relDomainModels0.setOptionality(true);
        relDomainModels0.setIsEmbedded(false);
        em.persist(relDomainModels0);
        em.flush();

//  ---------------------- DomainModels 1..* GroupIds -------------------------

        Entities fromDomainModels1 = new Entities();
        Cardinalities DomainModels1 = new Cardinalities();
        Entities   toDomainModels1 = new Entities();
        fromDomainModels1 = findEntities("DomainModels");
        DomainModels1 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toDomainModels1 = findEntities("GroupIds");
        Relationships relDomainModels1 = new Relationships();
        relDomainModels1.setFrom(fromDomainModels1);
        relDomainModels1.setCardinalities(DomainModels1);
        relDomainModels1.setTo(toDomainModels1);
        relDomainModels1.setOptionality(true);
        relDomainModels1.setIsEmbedded(false);
        em.persist(relDomainModels1);
        em.flush();

//  ---------------------- SystemsModels 1..* FilesModels -------------------------

        Entities fromSystemsModels0 = new Entities();
        Cardinalities SystemsModels0 = new Cardinalities();
        Entities   toSystemsModels0 = new Entities();
        fromSystemsModels0 = findEntities("SystemsModels");
        SystemsModels0 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toSystemsModels0 = findEntities("FilesModels");
        Relationships relSystemsModels0 = new Relationships();
        relSystemsModels0.setFrom(fromSystemsModels0);
        relSystemsModels0.setCardinalities(SystemsModels0);
        relSystemsModels0.setTo(toSystemsModels0);
        relSystemsModels0.setOptionality(true);
        relSystemsModels0.setIsEmbedded(false);
        em.persist(relSystemsModels0);
        em.flush();

//  ---------------------- SystemsModels 1..* DomainModels -------------------------

        Entities fromSystemsModels1 = new Entities();
        Cardinalities SystemsModels1 = new Cardinalities();
        Entities   toSystemsModels1 = new Entities();
        fromSystemsModels1 = findEntities("SystemsModels");
        SystemsModels1 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toSystemsModels1 = findEntities("DomainModels");
        Relationships relSystemsModels1 = new Relationships();
        relSystemsModels1.setFrom(fromSystemsModels1);
        relSystemsModels1.setCardinalities(SystemsModels1);
        relSystemsModels1.setTo(toSystemsModels1);
        relSystemsModels1.setOptionality(true);
        relSystemsModels1.setIsEmbedded(false);
        em.persist(relSystemsModels1);
        em.flush();

//  ---------------------- Imports *..* PropertiesAttributes -------------------------

/*
        Entities fromImports1 = new Entities();
        Cardinalities Imports1 = new Cardinalities();
        Entities   toImports1 = new Entities();
        fromImports1 = findEntities("Imports");
        Imports1 = findCardinalities("Muchos a Muchos Bidirecccional No.7");
        toImports1 = findEntities("PropertiesAttributes");
        Relationships relImports1 = new Relationships();
        relImports1.setFrom(fromImports1);
        relImports1.setCardinalities(Imports1);
        relImports1.setTo(toImports1);
        relImports1.setOptionality(true);
        relImports1.setIsEmbedded(false);
        em.persist(relImports1);
        em.flush();
*/        

//  ---------------------- Imports *..* Entities -------------------------

/*
        Entities fromImports2 = new Entities();
        Cardinalities Imports2 = new Cardinalities();
        Entities   toImports2 = new Entities();
        fromImports2 = findEntities("Imports");
        Imports2 = findCardinalities("Muchos a Muchos Bidirecccional No.7");
        toImports2 = findEntities("Entities");
        Relationships relImports2 = new Relationships();
        relImports2.setFrom(fromImports2);
        relImports2.setCardinalities(Imports2);
        relImports2.setTo(toImports2);
        relImports2.setOptionality(true);
        relImports2.setIsEmbedded(false);
        em.persist(relImports2);
        em.flush();
*/        

//  ---------------------- Imports *..* Cardinalities -------------------------

/*
        Entities fromImports3 = new Entities();
        Cardinalities Imports3 = new Cardinalities();
        Entities   toImports3 = new Entities();
        fromImports3 = findEntities("Imports");
        Imports3 = findCardinalities("Muchos a Muchos Bidirecccional No.7");
        toImports3 = findEntities("Cardinalities");
        Relationships relImports3 = new Relationships();
        relImports3.setFrom(fromImports3);
        relImports3.setCardinalities(Imports3);
        relImports3.setTo(toImports3);
        relImports3.setOptionality(true);
        relImports3.setIsEmbedded(false);
        em.persist(relImports3);
        em.flush();
*/        

//  ---------------------- Dependency 1..* Imports -------------------------

        Entities fromDependency0 = new Entities();
        Cardinalities Dependency0 = new Cardinalities();
        Entities   toDependency0 = new Entities();
        fromDependency0 = findEntities("Dependency");
        Dependency0 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toDependency0 = findEntities("Imports");
        Relationships relDependency0 = new Relationships();
        relDependency0.setFrom(fromDependency0);
        relDependency0.setCardinalities(Dependency0);
        relDependency0.setTo(toDependency0);
        relDependency0.setOptionality(true);
        relDependency0.setIsEmbedded(false);
        em.persist(relDependency0);
        em.flush();

    } // Relations()
} // DomainModelsSetup

