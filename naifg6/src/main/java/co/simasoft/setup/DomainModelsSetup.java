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

    private static final String QUERYA = "SELECT c FROM TypesAttributes c WHERE c.name LIKE :custName";
    private static final String QUERYB = "SELECT c FROM Entities c WHERE c.name LIKE :custName";
    private static final String QUERYC = "SELECT c FROM Cardinalities c WHERE c.name LIKE :custName";

    @PersistenceContext(unitName = "DomainModelsPU-JTA")
    private EntityManager em;

    private static final Logger log = Logger.getLogger(DomainModelsSetup.class.getName());

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
        domainModels.setGroupId("co.simasoft");
        domainModels.setArtifactId("naifg7");
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
        TypesAttributes(groupIds);
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

        TypesAttributes typesentity = new TypesAttributes();
        typesentity = findTypesAttributes("String");

        Attributes entity = new Attributes();
        entity.setName("entity");
        entity.setNullable(true);
        entity.setSingle(false);
        entity.setTypesAttributes(typesentity);
        entity.setEntities(relationships);
        em.persist(entity);
        em.flush();

        TypesAttributes typesisEmbedded = new TypesAttributes();
        typesisEmbedded = findTypesAttributes("Boolean");

        Attributes isEmbedded = new Attributes();
        isEmbedded.setName("isEmbedded");
        isEmbedded.setNullable(true);
        isEmbedded.setSingle(false);
        isEmbedded.setTypesAttributes(typesisEmbedded);
        isEmbedded.setEntities(relationships);
        em.persist(isEmbedded);
        em.flush();


        TypesAttributes typesoptionality = new TypesAttributes();
        typesoptionality = findTypesAttributes("Boolean");

        Attributes optionality = new Attributes();
        optionality.setName("optionality");
        optionality.setNullable(true);
        optionality.setSingle(false);
        optionality.setTypesAttributes(typesoptionality);
        optionality.setEntities(relationships);
        em.persist(optionality);
        em.flush();

        TypesAttributes typesname = new TypesAttributes();
        typesname = findTypesAttributes("String");

        Attributes name = new Attributes();
        name.setName("name");
        name.setNullable(true);
        name.setSingle(false);
        name.setTypesAttributes(typesname);
        name.setEntities(relationships);
        em.persist(name);
        em.flush();

        TypesAttributes typesmappedby = new TypesAttributes();
        typesmappedby = findTypesAttributes("String");

        Attributes mappedby = new Attributes();
        mappedby.setName("mappedby");
        mappedby.setNullable(true);
        mappedby.setSingle(false);
        mappedby.setTypesAttributes(typesmappedby);
        mappedby.setEntities(relationships);
        em.persist(mappedby);
        em.flush();

        TypesAttributes typesannotationsMethod = new TypesAttributes();
        typesannotationsMethod = findTypesAttributes("String");

        Attributes annotationsMethod = new Attributes();
        annotationsMethod.setName("annotationsMethod");
        annotationsMethod.setNullable(true);
        annotationsMethod.setSingle(false);
        annotationsMethod.setTypesAttributes(typesannotationsMethod);
        annotationsMethod.setEntities(relationships);
        em.persist(annotationsMethod);
        em.flush();

        TypesAttributes typesannotationsField = new TypesAttributes();
        typesannotationsField = findTypesAttributes("String");

        Attributes annotationsField = new Attributes();
        annotationsField.setName("annotationsField");
        annotationsField.setNullable(true);
        annotationsField.setSingle(false);
        annotationsField.setTypesAttributes(typesannotationsField);
        annotationsField.setEntities(relationships);
        em.persist(annotationsField);
        em.flush();

        TypesAttributes typestabla = new TypesAttributes();
        typestabla = findTypesAttributes("String");

        Attributes tabla = new Attributes();
        tabla.setName("table");
        tabla.setNullable(true);
        tabla.setSingle(false);
        tabla.setTypesAttributes(typestabla);
        tabla.setEntities(relationships);
        em.persist(tabla);
        em.flush();

        TypesAttributes typesidTabla1 = new TypesAttributes();
        typesidTabla1 = findTypesAttributes("String");

        Attributes idTabla1 = new Attributes();
        idTabla1.setName("idTable1");
        idTabla1.setNullable(true);
        idTabla1.setSingle(false);
        idTabla1.setTypesAttributes(typesidTabla1);
        idTabla1.setEntities(relationships);
        em.persist(idTabla1);
        em.flush();

        TypesAttributes typesidTabla2 = new TypesAttributes();
        typesidTabla2 = findTypesAttributes("String");

        Attributes idTabla2 = new Attributes();
        idTabla2.setName("idTable2");
        idTabla2.setNullable(true);
        idTabla2.setSingle(false);
        idTabla2.setTypesAttributes(typesidTabla2);
        idTabla2.setEntities(relationships);
        em.persist(idTabla2);
        em.flush();

        TypesAttributes typesdescription = new TypesAttributes();
        typesdescription = findTypesAttributes("String");

        Attributes description = new Attributes();
        description.setName("description");
        description.setNullable(true);
        description.setSingle(false);
        description.setTypesAttributes(typesdescription);
        description.setEntities(relationships);
        em.persist(description);
        em.flush();

        TypesAttributes typesobservaciones = new TypesAttributes();
        typesobservaciones = findTypesAttributes("String");

        Attributes observaciones = new Attributes();
        observaciones.setName("observations");
        observaciones.setNullable(true);
        observaciones.setSingle(false);
        observaciones.setTypesAttributes(typesobservaciones);
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

        TypesAttributes typesname = new TypesAttributes();
        typesname = findTypesAttributes("String");

        Attributes name = new Attributes();
        name.setName("name");
        name.setNullable(false);
        name.setSingle(false);
        name.setTypesAttributes(typesname);
        name.setEntities(entities);
        em.persist(name);
        em.flush();

        TypesAttributes typesserialID = new TypesAttributes();
        typesserialID = findTypesAttributes("String");

        Attributes serialID = new Attributes();
        serialID.setName("serialID");
        serialID.setNullable(true);
        serialID.setSingle(true);
        serialID.setTypesAttributes(typesserialID);
        serialID.setEntities(entities);
        em.persist(serialID);
        em.flush();

        TypesAttributes typestable = new TypesAttributes();
        typestable = findTypesAttributes("String");

        Attributes table = new Attributes();
        table.setName("table");
        table.setNullable(true);
        table.setSingle(false);
        table.setTypesAttributes(typestable);
        table.setEntities(entities);
        em.persist(table);
        em.flush();

        TypesAttributes typestableSecuencia = new TypesAttributes();
        typestableSecuencia = findTypesAttributes("String");

        Attributes tableSecuencia = new Attributes();
        tableSecuencia.setName("tableSecuencia");
        tableSecuencia.setNullable(true);
        tableSecuencia.setSingle(false);
        tableSecuencia.setTypesAttributes(typestableSecuencia);
        tableSecuencia.setEntities(entities);
        em.persist(tableSecuencia);
        em.flush();

        TypesAttributes typesmodifier = new TypesAttributes();
        typesmodifier = findTypesAttributes("String");

        Attributes modifier = new Attributes();
        modifier.setName("modifier");
        modifier.setNullable(true);
        modifier.setSingle(false);
        modifier.setTypesAttributes(typesmodifier);
        modifier.setEntities(entities);
        em.persist(modifier);
        em.flush();

        TypesAttributes typesextend = new TypesAttributes();
        typesextend = findTypesAttributes("String");

        Attributes extend = new Attributes();
        extend.setName("extend");
        extend.setNullable(true);
        extend.setSingle(false);
        extend.setTypesAttributes(typesextend);
        extend.setEntities(entities);
        em.persist(extend);
        em.flush();

        TypesAttributes typesannotations = new TypesAttributes();
        typesannotations = findTypesAttributes("Text");

        Attributes annotations = new Attributes();
        annotations.setName("annotations");
        annotations.setNullable(true);
        annotations.setSingle(false);
        annotations.setTypesAttributes(typesannotations);
        annotations.setEntities(entities);
        em.persist(annotations);
        em.flush();

        TypesAttributes typessource = new TypesAttributes();
        typessource = findTypesAttributes("Text");

        Attributes source = new Attributes();
        source.setName("source");
        source.setNullable(true);
        source.setSingle(false);
        source.setTypesAttributes(typessource);
        source.setEntities(entities);
        em.persist(source);
        em.flush();

        TypesAttributes typesdescription = new TypesAttributes();
        typesdescription = findTypesAttributes("String");

        Attributes description = new Attributes();
        description.setName("description");
        description.setNullable(true);
        description.setSingle(false);
        description.setTypesAttributes(typesdescription);
        description.setEntities(entities);
        em.persist(description);
        em.flush();

        TypesAttributes typesobservations = new TypesAttributes();
        typesobservations = findTypesAttributes("Text");

        Attributes observations = new Attributes();
        observations.setName("observations");
        observations.setNullable(true);
        observations.setSingle(false);
        observations.setTypesAttributes(typesobservations);
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

        TypesAttributes typesname = new TypesAttributes();
        typesname = findTypesAttributes("String");

        Attributes name = new Attributes();
        name.setName("name");
        name.setNullable(false);
        name.setSingle(false);
        name.setTypesAttributes(typesname);
        name.setEntities(attributes);
        em.persist(name);
        em.flush();

        TypesAttributes typeslength = new TypesAttributes();
        typeslength = findTypesAttributes("Integer");

        Attributes length = new Attributes();
        length.setName("length");
        length.setNullable(true);
        length.setSingle(false);
        length.setTypesAttributes(typeslength);
        length.setEntities(attributes);
        em.persist(length);
        em.flush();

        TypesAttributes typesprecision = new TypesAttributes();
        typesprecision = findTypesAttributes("Integer");

        Attributes precision = new Attributes();
        precision.setName("precision");
        precision.setNullable(true);
        precision.setSingle(false);
        precision.setTypesAttributes(typesprecision);
        precision.setEntities(attributes);
        em.persist(precision);
        em.flush();

        TypesAttributes typesnullable = new TypesAttributes();
        typesnullable = findTypesAttributes("Boolean");

        Attributes nullable = new Attributes();
        nullable.setName("nullable");
        nullable.setNullable(true);
        nullable.setSingle(false);
        nullable.setTypesAttributes(typesnullable);
        nullable.setEntities(attributes);
        em.persist(nullable);
        em.flush();

        TypesAttributes typesunique = new TypesAttributes();
        typesunique = findTypesAttributes("Boolean");

        Attributes unique = new Attributes();
        unique.setName("single");
        unique.setNullable(true);
        unique.setSingle(false);
        unique.setTypesAttributes(typesunique);
        unique.setEntities(attributes);
        em.persist(unique);
        em.flush();

        TypesAttributes typesdescripcion = new TypesAttributes();
        typesdescripcion = findTypesAttributes("String");

        Attributes descripcion = new Attributes();
        descripcion.setName("descripcion");
        descripcion.setNullable(true);
        descripcion.setSingle(false);
        descripcion.setTypesAttributes(typesdescripcion);
        descripcion.setEntities(attributes);
        em.persist(descripcion);
        em.flush();

        TypesAttributes typesfield = new TypesAttributes();
        typesfield = findTypesAttributes("String");

        Attributes field = new Attributes();
        field.setName("field");
        field.setNullable(true);
        field.setSingle(false);
        field.setTypesAttributes(typesfield);
        field.setEntities(attributes);
        em.persist(field);
        em.flush();

        TypesAttributes typesaccess = new TypesAttributes();
        typesaccess = findTypesAttributes("String");

        Attributes access = new Attributes();
        access.setName("access");
        access.setNullable(true);
        access.setSingle(false);
        access.setTypesAttributes(typesaccess);
        access.setEntities(attributes);
        em.persist(access);
        em.flush();

        TypesAttributes typescolumnDefinition = new TypesAttributes();
        typescolumnDefinition = findTypesAttributes("String");

        Attributes columnDefinition = new Attributes();
        columnDefinition.setName("columnDefinition");
        columnDefinition.setNullable(true);
        columnDefinition.setSingle(false);
        columnDefinition.setTypesAttributes(typescolumnDefinition);
        columnDefinition.setEntities(attributes);
        em.persist(columnDefinition);
        em.flush();

        TypesAttributes typesannotationsField = new TypesAttributes();
        typesannotationsField = findTypesAttributes("Text");

        Attributes annotationsField = new Attributes();
        annotationsField.setName("annotationsField");
        annotationsField.setNullable(true);
        annotationsField.setSingle(false);
        annotationsField.setTypesAttributes(typesannotationsField);
        annotationsField.setEntities(attributes);
        em.persist(annotationsField);
        em.flush();

        TypesAttributes typesannotationsMethod = new TypesAttributes();
        typesannotationsMethod = findTypesAttributes("Text");

        Attributes annotationsMethod = new Attributes();
        annotationsMethod.setName("annotationsMethod");
        annotationsMethod.setNullable(true);
        annotationsMethod.setSingle(false);
        annotationsMethod.setTypesAttributes(typesannotationsMethod);
        annotationsMethod.setEntities(attributes);
        em.persist(annotationsMethod);
        em.flush();

        TypesAttributes typesobservations = new TypesAttributes();
        typesobservations = findTypesAttributes("Text");

        Attributes observations = new Attributes();
        observations.setName("observations");
        observations.setNullable(true);
        observations.setSingle(false);
        observations.setTypesAttributes(typesobservations);
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

        TypesAttributes typesname = new TypesAttributes();
        typesname = findTypesAttributes("String");

        Attributes name = new Attributes();
        name.setName("name");
        name.setNullable(false);
        name.setSingle(true);
        name.setTypesAttributes(typesname);
        name.setEntities(cardinalities);
        em.persist(name);
        em.flush();

        TypesAttributes typescardinality = new TypesAttributes();
        typescardinality = findTypesAttributes("String");

        Attributes cardinality = new Attributes();
        cardinality.setName("cardinality");
        cardinality.setNullable(false);
        cardinality.setSingle(false);
        cardinality.setTypesAttributes(typescardinality);
        cardinality.setEntities(cardinalities);
        em.persist(cardinality);
        em.flush();

        TypesAttributes typesunidirectional = new TypesAttributes();
        typesunidirectional = findTypesAttributes("Boolean");

        Attributes unidirectional = new Attributes();
        unidirectional.setName("unidirectional");
        unidirectional.setNullable(true);
        unidirectional.setSingle(false);
        unidirectional.setTypesAttributes(typesunidirectional);
        unidirectional.setEntities(cardinalities);
        em.persist(unidirectional);
        em.flush();

        TypesAttributes typesannotations = new TypesAttributes();
        typesannotations = findTypesAttributes("Text");

        Attributes annotations = new Attributes();
        annotations.setName("annotations");
        annotations.setNullable(true);
        annotations.setSingle(false);
        annotations.setTypesAttributes(typesannotations);
        annotations.setEntities(cardinalities);
        em.persist(annotations);
        em.flush();

        TypesAttributes typesobservations = new TypesAttributes();
        typesobservations = findTypesAttributes("Text");

        Attributes observations = new Attributes();
        observations.setName("observations");
        observations.setNullable(true);
        observations.setSingle(false);
        observations.setTypesAttributes(typesobservations);
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

        TypesAttributes typesname = new TypesAttributes();
        typesname = findTypesAttributes("String");

        Attributes name = new Attributes();
        name.setName("name");
        name.setNullable(true);
        name.setSingle(false);
        name.setTypesAttributes(typesname);
        name.setEntities(groupId);
        em.persist(name);
        em.flush();

        TypesAttributes typesgroupId = new TypesAttributes();
        typesgroupId = findTypesAttributes("String");

        Attributes attributes = new Attributes();
        attributes.setName("groupId");
        attributes.setNullable(false);
        attributes.setSingle(false);
        attributes.setTypesAttributes(typesgroupId);
        attributes.setEntities(groupId);
        em.persist(attributes);
        em.flush();
        TypesAttributes typesartifactId = new TypesAttributes();
        typesartifactId = findTypesAttributes("String");

        Attributes artifactId = new Attributes();
        artifactId.setName("artifactId");
        artifactId.setNullable(true);
        artifactId.setSingle(true);
        artifactId.setTypesAttributes(typesartifactId);
        artifactId.setEntities(groupId);
        em.persist(artifactId);
        em.flush();

        TypesAttributes typesversion = new TypesAttributes();
        typesversion = findTypesAttributes("String");

        Attributes version = new Attributes();
        version.setName("version");
        version.setNullable(true);
        version.setSingle(false);
        version.setTypesAttributes(typesversion);
        version.setEntities(groupId);
        em.persist(version);
        em.flush();

        TypesAttributes typescode = new TypesAttributes();
        typescode = findTypesAttributes("String");

        Attributes code = new Attributes();
        code.setName("code");
        code.setNullable(true);
        code.setSingle(true);
        code.setTypesAttributes(typescode);
        code.setEntities(groupId);
        em.persist(code);
        em.flush();

        TypesAttributes typesdate = new TypesAttributes();
        typesdate = findTypesAttributes("Date");

        Attributes date = new Attributes();
        date.setName("date");
        date.setNullable(true);
        date.setSingle(false);
        date.setTypesAttributes(typesdate);
        date.setEntities(groupId);
        em.persist(date);
        em.flush();

        TypesAttributes typesdescription = new TypesAttributes();
        typesdescription = findTypesAttributes("String");

        Attributes description = new Attributes();
        description.setName("description");
        description.setNullable(true);
        description.setSingle(false);
        description.setTypesAttributes(typesdescription);
        description.setEntities(groupId);
        em.persist(description);
        em.flush();

        TypesAttributes typesobservations = new TypesAttributes();
        typesobservations = findTypesAttributes("Text");

        Attributes observations = new Attributes();
        observations.setName("observations");
        observations.setNullable(true);
        observations.setSingle(false);
        observations.setTypesAttributes(typesobservations);
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

        TypesAttributes typesname = new TypesAttributes();
        typesname = findTypesAttributes("String");

        Attributes name = new Attributes();
        name.setName("name");
        name.setNullable(false);
        name.setSingle(true);
        name.setTypesAttributes(typesname);
        name.setEntities(propertiesAttributes);
        em.persist(name);
        em.flush();

        TypesAttributes typesvalue = new TypesAttributes();
        typesvalue = findTypesAttributes("String");

        Attributes value = new Attributes();
        value.setName("value");
        value.setNullable(false);
        value.setSingle(true);
        value.setTypesAttributes(typesvalue);
        value.setEntities(propertiesAttributes);
        em.persist(value);
        em.flush();

        TypesAttributes typesobservations = new TypesAttributes();
        typesobservations = findTypesAttributes("Text");

        Attributes observations = new Attributes();
        observations.setName("observations");
        observations.setNullable(true);
        observations.setSingle(false);
        observations.setTypesAttributes(typesobservations);
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

        TypesAttributes typesname = new TypesAttributes();
        typesname = findTypesAttributes("String");

        Attributes name = new Attributes();
        name.setName("name");
        name.setNullable(false);
        name.setSingle(true);
        name.setTypesAttributes(typesname);
        name.setEntities(filesModels);
        em.persist(name);
        em.flush();

        TypesAttributes typesextension = new TypesAttributes();
        typesextension = findTypesAttributes("String");

        Attributes extension = new Attributes();
        extension.setName("extension");
        extension.setNullable(false);
        extension.setSingle(false);
        extension.setTypesAttributes(typesextension);
        extension.setEntities(filesModels);
        em.persist(extension);
        em.flush();

        TypesAttributes typesdate = new TypesAttributes();
        typesdate = findTypesAttributes("Date");

        Attributes date = new Attributes();
        date.setName("date");
        date.setNullable(false);
        date.setSingle(false);
        date.setTypesAttributes(typesdate);
        date.setEntities(filesModels);
        em.persist(date);
        em.flush();

        TypesAttributes typesurl = new TypesAttributes();
        typesurl = findTypesAttributes("String");

        Attributes url = new Attributes();
        url.setName("url");
        url.setNullable(false);
        url.setSingle(false);
        url.setTypesAttributes(typesurl);
        url.setEntities(filesModels);
        em.persist(url);
        em.flush();

        TypesAttributes typesdata = new TypesAttributes();
        typesdata = findTypesAttributes("byte");

        Attributes data = new Attributes();
        data.setName("data");
        data.setNullable(true);
        data.setSingle(false);
        data.setTypesAttributes(typesdata);
        data.setEntities(filesModels);
        em.persist(data);
        em.flush();

        TypesAttributes typesobservations = new TypesAttributes();
        typesobservations = findTypesAttributes("Text");

        Attributes observations = new Attributes();
        observations.setName("observations");
        observations.setNullable(true);
        observations.setSingle(false);
        observations.setTypesAttributes(typesobservations);
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

        TypesAttributes typestitle = new TypesAttributes();
        typestitle = findTypesAttributes("String");

        Attributes title = new Attributes();
        title.setName("title");
        title.setNullable(false);
        title.setSingle(true);
        title.setTypesAttributes(typestitle);
        title.setEntities(links);
        em.persist(title);
        em.flush();

        TypesAttributes typeslink = new TypesAttributes();
        typeslink = findTypesAttributes("String");

        Attributes link = new Attributes();
        link.setName("link");
        link.setNullable(false);
        link.setSingle(true);
        link.setTypesAttributes(typeslink);
        link.setEntities(links);
        em.persist(link);
        em.flush();

        TypesAttributes typesobservations = new TypesAttributes();
        typesobservations = findTypesAttributes("Text");

        Attributes observations = new Attributes();
        observations.setName("observations");
        observations.setNullable(true);
        observations.setSingle(false);
        observations.setTypesAttributes(typesobservations);
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

        TypesAttributes typesname = new TypesAttributes();
        typesname = findTypesAttributes("String");

        Attributes name = new Attributes();
        name.setName("name");
        name.setNullable(false);
        name.setSingle(true);
        name.setTypesAttributes(typesname);
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

        TypesAttributes typesname = new TypesAttributes();
        typesname = findTypesAttributes("String");

        Attributes name = new Attributes();
        name.setName("name");
        name.setNullable(false);
        name.setSingle(true);
        name.setTypesAttributes(typesname);
        name.setEntities(nameQueries);
        em.persist(name);
        em.flush();

        TypesAttributes typesquery = new TypesAttributes();
        typesquery = findTypesAttributes("Text");

        Attributes query = new Attributes();
        query.setName("query");
        query.setNullable(false);
        query.setSingle(true);
        query.setTypesAttributes(typesquery);
        query.setEntities(nameQueries);
        em.persist(query);
        em.flush();

        TypesAttributes typesobservations = new TypesAttributes();
        typesobservations = findTypesAttributes("Text");

        Attributes observations = new Attributes();
        observations.setName("observations");
        observations.setNullable(true);
        observations.setSingle(false);
        observations.setTypesAttributes(typesobservations);
        observations.setEntities(nameQueries);
        em.persist(observations);
        em.flush();

    } // NameQueries()

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
        name.setNullable(false);
        name.setSingle(true);
        name.setTypesAttributes(typesname);
        name.setEntities(typesAttributes);
        em.persist(name);
        em.flush();

        TypesAttributes typestype = new TypesAttributes();
        typestype = findTypesAttributes("String");

        Attributes type = new Attributes();
        type.setName("type");
        type.setNullable(false);
        type.setSingle(false);
        type.setTypesAttributes(typestype);
        type.setEntities(typesAttributes);
        em.persist(type);
        em.flush();

        TypesAttributes typeslength = new TypesAttributes();
        typeslength = findTypesAttributes("Integer");

        Attributes length = new Attributes();
        length.setName("length");
        length.setNullable(true);
        length.setSingle(false);
        length.setTypesAttributes(typeslength);
        length.setEntities(typesAttributes);
        em.persist(length);
        em.flush();

        TypesAttributes typesprecision = new TypesAttributes();
        typesprecision = findTypesAttributes("Integer");

        Attributes precision = new Attributes();
        precision.setName("precision");
        precision.setNullable(true);
        precision.setSingle(false);
        precision.setTypesAttributes(typesprecision);
        precision.setEntities(typesAttributes);
        em.persist(precision);
        em.flush();

        TypesAttributes typesannotations = new TypesAttributes();
        typesannotations = findTypesAttributes("Text");

        Attributes annotations = new Attributes();
        annotations.setName("annotations");
        annotations.setNullable(true);
        annotations.setSingle(false);
        annotations.setTypesAttributes(typesannotations);
        annotations.setEntities(typesAttributes);
        em.persist(annotations);
        em.flush();

        TypesAttributes typesobservations = new TypesAttributes();
        typesobservations = findTypesAttributes("Text");

        Attributes observations = new Attributes();
        observations.setName("observations");
        observations.setNullable(true);
        observations.setSingle(false);
        observations.setTypesAttributes(typesobservations);
        observations.setEntities(typesAttributes);
        em.persist(observations);
        em.flush();

    } // TypesAttributes()

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
        name.setNullable(true);
        name.setSingle(false);
        name.setTypesAttributes(typesname);
        name.setEntities(domainModels);
        em.persist(name);
        em.flush();

        TypesAttributes typesgroupId = new TypesAttributes();
        typesgroupId = findTypesAttributes("String");

        Attributes groupId = new Attributes();
        groupId.setName("groupId");
        groupId.setNullable(false);
        groupId.setSingle(false);
        groupId.setTypesAttributes(typesgroupId);
        groupId.setEntities(domainModels);
        em.persist(groupId);
        em.flush();

        TypesAttributes typesartifactId = new TypesAttributes();
        typesartifactId = findTypesAttributes("String");

        Attributes artifactId = new Attributes();
        artifactId.setName("artifactId");
        artifactId.setNullable(false);
        artifactId.setSingle(true);
        artifactId.setTypesAttributes(typesartifactId);
        artifactId.setEntities(domainModels);
        em.persist(artifactId);
        em.flush();

        TypesAttributes typesversion = new TypesAttributes();
        typesversion = findTypesAttributes("String");

        Attributes version = new Attributes();
        version.setName("version");
        version.setNullable(false);
        version.setSingle(false);
        version.setTypesAttributes(typesversion);
        version.setEntities(domainModels);
        em.persist(version);
        em.flush();

        TypesAttributes typescode = new TypesAttributes();
        typescode = findTypesAttributes("String");

        Attributes code = new Attributes();
        code.setName("code");
        code.setNullable(true);
        code.setSingle(true);
        code.setTypesAttributes(typescode);
        code.setEntities(domainModels);
        em.persist(code);
        em.flush();

        TypesAttributes typesdate = new TypesAttributes();
        typesdate = findTypesAttributes("Date");

        Attributes date = new Attributes();
        date.setName("date");
        date.setNullable(true);
        date.setSingle(false);
        date.setTypesAttributes(typesdate);
        date.setEntities(domainModels);
        em.persist(date);
        em.flush();

        TypesAttributes typesdescription = new TypesAttributes();
        typesdescription = findTypesAttributes("String");

        Attributes description = new Attributes();
        description.setName("description");
        description.setNullable(true);
        description.setSingle(false);
        description.setTypesAttributes(typesdescription);
        description.setEntities(domainModels);
        em.persist(description);
        em.flush();

        TypesAttributes typesobservations = new TypesAttributes();
        typesobservations = findTypesAttributes("Text");

        Attributes observations = new Attributes();
        observations.setName("observations");
        observations.setNullable(true);
        observations.setSingle(false);
        observations.setTypesAttributes(typesobservations);
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

        TypesAttributes typesname = new TypesAttributes();
        typesname = findTypesAttributes("String");

        Attributes name = new Attributes();
        name.setName("name");
        name.setNullable(false);
        name.setSingle(true);
        name.setTypesAttributes(typesname);
        name.setEntities(systemsModels);
        em.persist(name);
        em.flush();

        TypesAttributes typesdescription = new TypesAttributes();
        typesdescription = findTypesAttributes("String");

        Attributes description = new Attributes();
        description.setName("description");
        description.setNullable(true);
        description.setSingle(false);
        description.setTypesAttributes(typesdescription);
        description.setEntities(systemsModels);
        em.persist(description);
        em.flush();

        TypesAttributes typesobservations = new TypesAttributes();
        typesobservations = findTypesAttributes("Text");

        Attributes observations = new Attributes();
        observations.setName("observations");
        observations.setNullable(true);
        observations.setSingle(false);
        observations.setTypesAttributes(typesobservations);
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

        TypesAttributes typesname = new TypesAttributes();
        typesname = findTypesAttributes("String");

        Attributes name = new Attributes();
        name.setName("name");
        name.setNullable(false);
        name.setSingle(true);
        name.setTypesAttributes(typesname);
        name.setEntities(imports);
        em.persist(name);
        em.flush();

        TypesAttributes typesobservations = new TypesAttributes();
        typesobservations = findTypesAttributes("Text");

        Attributes observations = new Attributes();
        observations.setName("observations");
        observations.setNullable(true);
        observations.setSingle(false);
        observations.setTypesAttributes(typesobservations);
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

        TypesAttributes typesgroupId = new TypesAttributes();
        typesgroupId = findTypesAttributes("String");

        Attributes groupId = new Attributes();
        groupId.setName("groupId");
        groupId.setNullable(false);
        groupId.setSingle(false);
        groupId.setTypesAttributes(typesgroupId);
        groupId.setEntities(dependency);
        em.persist(groupId);
        em.flush();

        TypesAttributes typesartifactId = new TypesAttributes();
        typesartifactId = findTypesAttributes("String");

        Attributes artifactId = new Attributes();
        artifactId.setName("artifactId");
        artifactId.setNullable(false);
        artifactId.setSingle(false);
        artifactId.setTypesAttributes(typesartifactId);
        artifactId.setEntities(dependency);
        em.persist(artifactId);
        em.flush();

        TypesAttributes typesversion = new TypesAttributes();
        typesversion = findTypesAttributes("String");

        Attributes version = new Attributes();
        version.setName("version");
        version.setNullable(true);
        version.setSingle(false);
        version.setTypesAttributes(typesversion);
        version.setEntities(dependency);
        em.persist(version);
        em.flush();

        TypesAttributes typestype = new TypesAttributes();
        typestype = findTypesAttributes("String");

        Attributes type = new Attributes();
        type.setName("type");
        type.setNullable(true);
        type.setSingle(false);
        type.setTypesAttributes(typestype);
        type.setEntities(dependency);
        em.persist(type);
        em.flush();

        TypesAttributes typesscope = new TypesAttributes();
        typesscope = findTypesAttributes("String");

        Attributes scope = new Attributes();
        scope.setName("scope");
        scope.setNullable(true);
        scope.setSingle(false);
        scope.setTypesAttributes(typesscope);
        scope.setEntities(dependency);
        em.persist(scope);
        em.flush();

        TypesAttributes typesmaven = new TypesAttributes();
        typesmaven = findTypesAttributes("Text");

        Attributes maven = new Attributes();
        maven.setName("maven");
        maven.setNullable(false);
        maven.setSingle(true);
        maven.setTypesAttributes(typesmaven);
        maven.setEntities(dependency);
        em.persist(maven);
        em.flush();

        TypesAttributes typeslink = new TypesAttributes();
        typeslink = findTypesAttributes("String");

        Attributes link = new Attributes();
        link.setName("link");
        link.setNullable(false);
        link.setSingle(false);
        link.setTypesAttributes(typeslink);
        link.setEntities(dependency);
        em.persist(link);
        em.flush();

        TypesAttributes typesobservations = new TypesAttributes();
        typesobservations = findTypesAttributes("Text");

        Attributes observations = new Attributes();
        observations.setName("observations");
        observations.setNullable(true);
        observations.setSingle(false);
        observations.setTypesAttributes(typesobservations);
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

//  ---------------------- PropertiesAttributes *..* TypesAttributes -------------------------

/*
        Entities fromPropertiesAttributes2 = new Entities();
        Cardinalities PropertiesAttributes2 = new Cardinalities();
        Entities   toPropertiesAttributes2 = new Entities();
        fromPropertiesAttributes2 = findEntities("PropertiesAttributes");
        PropertiesAttributes2 = findCardinalities("Muchos a Muchos Bidirecccional No.7");
        toPropertiesAttributes2 = findEntities("TypesAttributes");
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
        relTypesAttributes0.setIsEmbedded(false);
        em.persist(relTypesAttributes0);
        em.flush();

//  ---------------------- TypesAttributes 1..* Attributes -------------------------

        Entities fromTypesAttributes1 = new Entities();
        Cardinalities TypesAttributes1 = new Cardinalities();
        Entities   toTypesAttributes1 = new Entities();
        fromTypesAttributes1 = findEntities("TypesAttributes");
        TypesAttributes1 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toTypesAttributes1 = findEntities("Attributes");
        Relationships relTypesAttributes1 = new Relationships();
        relTypesAttributes1.setFrom(fromTypesAttributes1);
        relTypesAttributes1.setCardinalities(TypesAttributes1);
        relTypesAttributes1.setTo(toTypesAttributes1);
        relTypesAttributes1.setOptionality(true);
        relTypesAttributes1.setIsEmbedded(false);
        em.persist(relTypesAttributes1);
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

