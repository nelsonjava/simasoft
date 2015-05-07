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
        domainModels.setName(Utils.nameRandom());
        em.persist(domainModels);
        em.flush();

        GroupIds groupIds = new GroupIds();
        groupIds.setGroupId(Utils.nameRandom());
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
        LinksModels(groupIds);
        TiposLinksModels(groupIds);
        NameQueries(groupIds);
        TypesAttributes(groupIds);
        DomainModels(groupIds);
        SystemsModels(groupIds);
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
//        entity.setType("String");
        entity.setTypesAttributes(typesentity);
        entity.setEntities(relationships);
        em.persist(entity);
        em.flush();

        TypesAttributes typesoptionality = new TypesAttributes();
        typesoptionality = findTypesAttributes("Boolean");

        Attributes optionality = new Attributes();
        optionality.setName("optionality");
//        optionality.setType("Boolean");
        optionality.setTypesAttributes(typesoptionality);
        optionality.setEntities(relationships);
        em.persist(optionality);
        em.flush();

        TypesAttributes typesname = new TypesAttributes();
        typesname = findTypesAttributes("String");

        Attributes name = new Attributes();
        name.setName("name");
//        name.setType("String");
        name.setTypesAttributes(typesname);
        name.setEntities(relationships);
        em.persist(name);
        em.flush();

        TypesAttributes typesmappedby = new TypesAttributes();
        typesmappedby = findTypesAttributes("String");

        Attributes mappedby = new Attributes();
        mappedby.setName("mappedby");
//        mappedby.setType("String");
        mappedby.setTypesAttributes(typesmappedby);
        mappedby.setEntities(relationships);
        em.persist(mappedby);
        em.flush();

        TypesAttributes typesannotationsMethod = new TypesAttributes();
        typesannotationsMethod = findTypesAttributes("String");

        Attributes annotationsMethod = new Attributes();
        annotationsMethod.setName("annotationsMethod");
//        annotationsMethod.setType("String");
        annotationsMethod.setTypesAttributes(typesannotationsMethod);
        annotationsMethod.setEntities(relationships);
        em.persist(annotationsMethod);
        em.flush();

        TypesAttributes typesannotationsField = new TypesAttributes();
        typesannotationsField = findTypesAttributes("String");

        Attributes annotationsField = new Attributes();
        annotationsField.setName("annotationsField");
//        annotationsField.setType("String");
        annotationsField.setTypesAttributes(typesannotationsField);
        annotationsField.setEntities(relationships);
        em.persist(annotationsField);
        em.flush();

        TypesAttributes typestabla = new TypesAttributes();
        typestabla = findTypesAttributes("String");

        Attributes tabla = new Attributes();
        tabla.setName("tabla");
//        tabla.setType("String");
        tabla.setTypesAttributes(typestabla);
        tabla.setEntities(relationships);
        em.persist(tabla);
        em.flush();

        TypesAttributes typesidTabla1 = new TypesAttributes();
        typesidTabla1 = findTypesAttributes("String");

        Attributes idTabla1 = new Attributes();
        idTabla1.setName("idTabla1");
//        idTabla1.setType("String");
        idTabla1.setTypesAttributes(typesidTabla1);
        idTabla1.setEntities(relationships);
        em.persist(idTabla1);
        em.flush();

        TypesAttributes typesidTabla2 = new TypesAttributes();
        typesidTabla2 = findTypesAttributes("String");

        Attributes idTabla2 = new Attributes();
        idTabla2.setName("idTabla2");
//        idTabla2.setType("String");
        idTabla2.setTypesAttributes(typesidTabla2);
        idTabla2.setEntities(relationships);
        em.persist(idTabla2);
        em.flush();

        TypesAttributes typesdescription = new TypesAttributes();
        typesdescription = findTypesAttributes("String");

        Attributes description = new Attributes();
        description.setName("description");
//        description.setType("String");
        description.setTypesAttributes(typesdescription);
        description.setEntities(relationships);
        em.persist(description);
        em.flush();

        TypesAttributes typesobservaciones = new TypesAttributes();
        typesobservaciones = findTypesAttributes("String");

        Attributes observaciones = new Attributes();
        observaciones.setName("observaciones");
//        observaciones.setType("String");
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
//        name.setType("String");
        name.setTypesAttributes(typesname);
        name.setEntities(entities);
        em.persist(name);
        em.flush();

        TypesAttributes typesserialID = new TypesAttributes();
        typesserialID = findTypesAttributes("String");

        Attributes serialID = new Attributes();
        serialID.setName("serialID");
//        serialID.setType("String");
        serialID.setTypesAttributes(typesserialID);
        serialID.setEntities(entities);
        em.persist(serialID);
        em.flush();

        TypesAttributes typestabla = new TypesAttributes();
        typestabla = findTypesAttributes("String");

        Attributes tabla = new Attributes();
        tabla.setName("tabla");
//        tabla.setType("String");
        tabla.setTypesAttributes(typestabla);
        tabla.setEntities(entities);
        em.persist(tabla);
        em.flush();

        TypesAttributes typestablaSecuencia = new TypesAttributes();
        typestablaSecuencia = findTypesAttributes("String");

        Attributes tablaSecuencia = new Attributes();
        tablaSecuencia.setName("tablaSecuencia");
//        tablaSecuencia.setType("String");
        tablaSecuencia.setTypesAttributes(typestablaSecuencia);
        tablaSecuencia.setEntities(entities);
        em.persist(tablaSecuencia);
        em.flush();

        TypesAttributes typesmodifier = new TypesAttributes();
        typesmodifier = findTypesAttributes("String");

        Attributes modifier = new Attributes();
        modifier.setName("modifier");
//        modifier.setType("String");
        modifier.setTypesAttributes(typesmodifier);
        modifier.setEntities(entities);
        em.persist(modifier);
        em.flush();

        TypesAttributes typesextend = new TypesAttributes();
        typesextend = findTypesAttributes("String");

        Attributes extend = new Attributes();
        extend.setName("extend");
//        extend.setType("String");
        extend.setTypesAttributes(typesextend);
        extend.setEntities(entities);
        em.persist(extend);
        em.flush();

        TypesAttributes typesimports = new TypesAttributes();
        typesimports = findTypesAttributes("String");

        Attributes imports = new Attributes();
        imports.setName("imports");
//        imports.setType("String");
        imports.setTypesAttributes(typesimports);
        imports.setEntities(entities);
        em.persist(imports);
        em.flush();

        TypesAttributes typesannotations = new TypesAttributes();
        typesannotations = findTypesAttributes("String");

        Attributes annotations = new Attributes();
        annotations.setName("annotations");
//        annotations.setType("String");
        annotations.setTypesAttributes(typesannotations);
        annotations.setEntities(entities);
        em.persist(annotations);
        em.flush();

        TypesAttributes typessource = new TypesAttributes();
        typessource = findTypesAttributes("String");

        Attributes source = new Attributes();
        source.setName("source");
//        source.setType("String");
        source.setTypesAttributes(typessource);
        source.setEntities(entities);
        em.persist(source);
        em.flush();

        TypesAttributes typesdescription = new TypesAttributes();
        typesdescription = findTypesAttributes("String");

        Attributes description = new Attributes();
        description.setName("description");
//        description.setType("String");
        description.setTypesAttributes(typesdescription);
        description.setEntities(entities);
        em.persist(description);
        em.flush();

        TypesAttributes typesobservaciones = new TypesAttributes();
        typesobservaciones = findTypesAttributes("String");

        Attributes observaciones = new Attributes();
        observaciones.setName("observaciones");
//        observaciones.setType("String");
        observaciones.setTypesAttributes(typesobservaciones);
        observaciones.setEntities(entities);
        em.persist(observaciones);
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
//        name.setType("String");
        name.setTypesAttributes(typesname);
        name.setEntities(attributes);
        em.persist(name);
        em.flush();

        TypesAttributes typeslength = new TypesAttributes();
        typeslength = findTypesAttributes("Integer");

        Attributes length = new Attributes();
        length.setName("length");
//        length.setType("Integer");
        length.setTypesAttributes(typeslength);
        length.setEntities(attributes);
        em.persist(length);
        em.flush();

        TypesAttributes typesprecision = new TypesAttributes();
        typesprecision = findTypesAttributes("Integer");

        Attributes precision = new Attributes();
        precision.setName("precision");
//        precision.setType("Integer");
        precision.setTypesAttributes(typesprecision);
        precision.setEntities(attributes);
        em.persist(precision);
        em.flush();

        TypesAttributes typesnullable = new TypesAttributes();
        typesnullable = findTypesAttributes("Boolean");

        Attributes nullable = new Attributes();
        nullable.setName("nullable");
//        nullable.setType("Boolean");
        nullable.setTypesAttributes(typesnullable);
        nullable.setEntities(attributes);
        em.persist(nullable);
        em.flush();

        TypesAttributes typesunico = new TypesAttributes();
        typesunico = findTypesAttributes("Boolean");

        Attributes unico = new Attributes();
        unico.setName("unico");
//        unico.setType("Boolean");
        unico.setTypesAttributes(typesunico);
        unico.setEntities(attributes);
        em.persist(unico);
        em.flush();

        TypesAttributes typesdescripcion = new TypesAttributes();
        typesdescripcion = findTypesAttributes("String");

        Attributes descripcion = new Attributes();
        descripcion.setName("descripcion");
//        descripcion.setType("String");
        descripcion.setTypesAttributes(typesdescripcion);
        descripcion.setEntities(attributes);
        em.persist(descripcion);
        em.flush();

        TypesAttributes typesfield = new TypesAttributes();
        typesfield = findTypesAttributes("String");

        Attributes field = new Attributes();
        field.setName("field");
//        field.setType("String");
        field.setTypesAttributes(typesfield);
        field.setEntities(attributes);
        em.persist(field);
        em.flush();

        TypesAttributes typesaccess = new TypesAttributes();
        typesaccess = findTypesAttributes("String");

        Attributes access = new Attributes();
        access.setName("access");
//        access.setType("String");
        access.setTypesAttributes(typesaccess);
        access.setEntities(attributes);
        em.persist(access);
        em.flush();

        TypesAttributes typescolumnDefinition = new TypesAttributes();
        typescolumnDefinition = findTypesAttributes("String");

        Attributes columnDefinition = new Attributes();
        columnDefinition.setName("columnDefinition");
//        columnDefinition.setType("String");
        columnDefinition.setTypesAttributes(typescolumnDefinition);
        columnDefinition.setEntities(attributes);
        em.persist(columnDefinition);
        em.flush();

        TypesAttributes typesannotationsField = new TypesAttributes();
        typesannotationsField = findTypesAttributes("String");

        Attributes annotationsField = new Attributes();
        annotationsField.setName("annotationsField");
//        annotationsField.setType("String");
        annotationsField.setTypesAttributes(typesannotationsField);
        annotationsField.setEntities(attributes);
        em.persist(annotationsField);
        em.flush();

        TypesAttributes typesannotationsMethod = new TypesAttributes();
        typesannotationsMethod = findTypesAttributes("String");

        Attributes annotationsMethod = new Attributes();
        annotationsMethod.setName("annotationsMethod");
//        annotationsMethod.setType("String");
        annotationsMethod.setTypesAttributes(typesannotationsMethod);
        annotationsMethod.setEntities(attributes);
        em.persist(annotationsMethod);
        em.flush();

        TypesAttributes typesobservaciones = new TypesAttributes();
        typesobservaciones = findTypesAttributes("String");

        Attributes observaciones = new Attributes();
        observaciones.setName("observaciones");
//        observaciones.setType("String");
        observaciones.setTypesAttributes(typesobservaciones);
        observaciones.setEntities(attributes);
        em.persist(observaciones);
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
//        name.setType("String");
        name.setTypesAttributes(typesname);
        name.setEntities(cardinalities);
        em.persist(name);
        em.flush();

        TypesAttributes typescardinality = new TypesAttributes();
        typescardinality = findTypesAttributes("String");

        Attributes cardinality = new Attributes();
        cardinality.setName("cardinality");
//        cardinality.setType("String");
        cardinality.setTypesAttributes(typescardinality);
        cardinality.setEntities(cardinalities);
        em.persist(cardinality);
        em.flush();

        TypesAttributes typesunidireccional = new TypesAttributes();
        typesunidireccional = findTypesAttributes("Boolean");

        Attributes unidireccional = new Attributes();
        unidireccional.setName("unidireccional");
//        unidireccional.setType("Boolean");
        unidireccional.setTypesAttributes(typesunidireccional);
        unidireccional.setEntities(cardinalities);
        em.persist(unidireccional);
        em.flush();

        TypesAttributes typesannotations = new TypesAttributes();
        typesannotations = findTypesAttributes("String");

        Attributes annotations = new Attributes();
        annotations.setName("annotations");
//        annotations.setType("String");
        annotations.setTypesAttributes(typesannotations);
        annotations.setEntities(cardinalities);
        em.persist(annotations);
        em.flush();

        TypesAttributes typesobservaciones = new TypesAttributes();
        typesobservaciones = findTypesAttributes("String");

        Attributes observaciones = new Attributes();
        observaciones.setName("observaciones");
//        observaciones.setType("String");
        observaciones.setTypesAttributes(typesobservaciones);
        observaciones.setEntities(cardinalities);
        em.persist(observaciones);
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
//        name.setType("String");
        name.setTypesAttributes(typesname);
        name.setEntities(groupId);
        em.persist(name);
        em.flush();

        TypesAttributes typesgroupId = new TypesAttributes();
        typesgroupId = findTypesAttributes("String");

        Attributes attributes = new Attributes();
        attributes.setName("groupId");
//        attributes.setType("String");
        attributes.setTypesAttributes(typesgroupId);
        attributes.setEntities(groupId);
        em.persist(attributes);
        em.flush();

        TypesAttributes typesartifactId = new TypesAttributes();
        typesartifactId = findTypesAttributes("String");

        Attributes artifactId = new Attributes();
        artifactId.setName("artifactId");
//        artifactId.setType("String");
        artifactId.setTypesAttributes(typesartifactId);
        artifactId.setEntities(groupId);
        em.persist(artifactId);
        em.flush();

        TypesAttributes typesversion = new TypesAttributes();
        typesversion = findTypesAttributes("String");

        Attributes version = new Attributes();
        version.setName("version");
//        version.setType("String");
        version.setTypesAttributes(typesversion);
        version.setEntities(groupId);
        em.persist(version);
        em.flush();

        TypesAttributes typescodigo = new TypesAttributes();
        typescodigo = findTypesAttributes("String");

        Attributes codigo = new Attributes();
        codigo.setName("codigo");
//        codigo.setType("String");
        codigo.setTypesAttributes(typescodigo);
        codigo.setEntities(groupId);
        em.persist(codigo);
        em.flush();

        TypesAttributes typesdate = new TypesAttributes();
        typesdate = findTypesAttributes("Date");

        Attributes date = new Attributes();
        date.setName("date");
//        date.setType("Date");
        date.setTypesAttributes(typesdate);
        date.setEntities(groupId);
        em.persist(date);
        em.flush();

        TypesAttributes typesdescription = new TypesAttributes();
        typesdescription = findTypesAttributes("String");

        Attributes description = new Attributes();
        description.setName("description");
//        description.setType("String");
        description.setTypesAttributes(typesdescription);
        description.setEntities(groupId);
        em.persist(description);
        em.flush();

        TypesAttributes typesobservaciones = new TypesAttributes();
        typesobservaciones = findTypesAttributes("String");

        Attributes observaciones = new Attributes();
        observaciones.setName("observaciones");
//        observaciones.setType("String");
        observaciones.setTypesAttributes(typesobservaciones);
        observaciones.setEntities(groupId);
        em.persist(observaciones);
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
//        name.setType("String");
        name.setTypesAttributes(typesname);
        name.setEntities(propertiesAttributes);
        em.persist(name);
        em.flush();

        TypesAttributes typesvalue = new TypesAttributes();
        typesvalue = findTypesAttributes("String");

        Attributes value = new Attributes();
        value.setName("value");
//        value.setType("String");
        value.setTypesAttributes(typesvalue);
        value.setEntities(propertiesAttributes);
        em.persist(value);
        em.flush();

        TypesAttributes typesobservaciones = new TypesAttributes();
        typesobservaciones = findTypesAttributes("String");

        Attributes observaciones = new Attributes();
        observaciones.setName("observaciones");
//        observaciones.setType("String");
        observaciones.setTypesAttributes(typesobservaciones);
        observaciones.setEntities(propertiesAttributes);
        em.persist(observaciones);
        em.flush();

    } // PropertiesAttributes()

    public void FilesModels(GroupIds groupIds) {

        Entities filesModels = new Entities();
        filesModels.setName("FilesModels");
        filesModels.setGroupIds(groupIds);
        em.persist(filesModels);
        em.flush();

//      ---------------------- Attributes:FilesModels -------------------------

        TypesAttributes typesarchivo = new TypesAttributes();
        typesarchivo = findTypesAttributes("String");

        Attributes archivo = new Attributes();
        archivo.setName("archivo");
//        archivo.setType("String");
        archivo.setTypesAttributes(typesarchivo);
        archivo.setEntities(filesModels);
        em.persist(archivo);
        em.flush();

        TypesAttributes typesextension = new TypesAttributes();
        typesextension = findTypesAttributes("String");

        Attributes extension = new Attributes();
        extension.setName("extension");
//        extension.setType("String");
        extension.setTypesAttributes(typesextension);
        extension.setEntities(filesModels);
        em.persist(extension);
        em.flush();

        TypesAttributes typesdata = new TypesAttributes();
        typesdata = findTypesAttributes("Blob");

        Attributes data = new Attributes();
        data.setName("data");
//        data.setType("Blob");
        data.setTypesAttributes(typesdata);
        data.setEntities(filesModels);
        em.persist(data);
        em.flush();

        TypesAttributes typesobservaciones = new TypesAttributes();
        typesobservaciones = findTypesAttributes("String");

        Attributes observaciones = new Attributes();
        observaciones.setName("observaciones");
//        observaciones.setType("String");
        observaciones.setTypesAttributes(typesobservaciones);
        observaciones.setEntities(filesModels);
        em.persist(observaciones);
        em.flush();

    } // FilesModels()

    public void LinksModels(GroupIds groupIds) {

        Entities linksModels = new Entities();
        linksModels.setName("LinksModels");
        linksModels.setGroupIds(groupIds);
        em.persist(linksModels);
        em.flush();

//      ---------------------- Attributes:LinksModels -------------------------

        TypesAttributes typestitulo = new TypesAttributes();
        typestitulo = findTypesAttributes("String");

        Attributes titulo = new Attributes();
        titulo.setName("titulo");
//        titulo.setType("String");
        titulo.setTypesAttributes(typestitulo);
        titulo.setEntities(linksModels);
        em.persist(titulo);
        em.flush();

        TypesAttributes typeslink = new TypesAttributes();
        typeslink = findTypesAttributes("String");

        Attributes link = new Attributes();
        link.setName("link");
//        link.setType("String");
        link.setTypesAttributes(typeslink);
        link.setEntities(linksModels);
        em.persist(link);
        em.flush();

        TypesAttributes typesobservaciones = new TypesAttributes();
        typesobservaciones = findTypesAttributes("String");

        Attributes observaciones = new Attributes();
        observaciones.setName("observaciones");
//        observaciones.setType("String");
        observaciones.setTypesAttributes(typesobservaciones);
        observaciones.setEntities(linksModels);
        em.persist(observaciones);
        em.flush();

    } // LinksModels()

    public void TiposLinksModels(GroupIds groupIds) {

        Entities tiposLinksModels = new Entities();
        tiposLinksModels.setName("TiposLinksModels");
        tiposLinksModels.setGroupIds(groupIds);
        em.persist(tiposLinksModels);
        em.flush();

//      ---------------------- Attributes:TiposLinksModels -------------------------

        TypesAttributes typesnombre = new TypesAttributes();
        typesnombre = findTypesAttributes("String");

        Attributes nombre = new Attributes();
        nombre.setName("nombre");
//        nombre.setType("String");
        nombre.setTypesAttributes(typesnombre);
        nombre.setEntities(tiposLinksModels);
        em.persist(nombre);
        em.flush();

    } // TiposLinksModels()

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
//        name.setType("String");
        name.setTypesAttributes(typesname);
        name.setEntities(nameQueries);
        em.persist(name);
        em.flush();

        TypesAttributes typesquery = new TypesAttributes();
        typesquery = findTypesAttributes("String");

        Attributes query = new Attributes();
        query.setName("query");
//        query.setType("String");
        query.setTypesAttributes(typesquery);
        query.setEntities(nameQueries);
        em.persist(query);
        em.flush();

        TypesAttributes typesobservaciones = new TypesAttributes();
        typesobservaciones = findTypesAttributes("String");

        Attributes observaciones = new Attributes();
        observaciones.setName("observaciones");
//        observaciones.setType("String");
        observaciones.setTypesAttributes(typesobservaciones);
        observaciones.setEntities(nameQueries);
        em.persist(observaciones);
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
//        name.setType("String");
        name.setTypesAttributes(typesname);
        name.setEntities(typesAttributes);
        em.persist(name);
        em.flush();

        TypesAttributes typestype = new TypesAttributes();
        typestype = findTypesAttributes("String");

        Attributes type = new Attributes();
        type.setName("type");
//        type.setType("String");
        type.setTypesAttributes(typestype);
        type.setEntities(typesAttributes);
        em.persist(type);
        em.flush();

        TypesAttributes typeslength = new TypesAttributes();
        typeslength = findTypesAttributes("Integer");

        Attributes length = new Attributes();
        length.setName("length");
//        length.setType("Integer");
        length.setTypesAttributes(typeslength);
        length.setEntities(typesAttributes);
        em.persist(length);
        em.flush();

        TypesAttributes typesprecision = new TypesAttributes();
        typesprecision = findTypesAttributes("Integer");

        Attributes precision = new Attributes();
        precision.setName("precision");
//        precision.setType("Integer");
        precision.setTypesAttributes(typesprecision);
        precision.setEntities(typesAttributes);
        em.persist(precision);
        em.flush();

        TypesAttributes typesannotations = new TypesAttributes();
        typesannotations = findTypesAttributes("String");

        Attributes annotations = new Attributes();
        annotations.setName("annotations");
//        annotations.setType("String");
        annotations.setTypesAttributes(typesannotations);
        annotations.setEntities(typesAttributes);
        em.persist(annotations);
        em.flush();

        TypesAttributes typesobservaciones = new TypesAttributes();
        typesobservaciones = findTypesAttributes("String");

        Attributes observaciones = new Attributes();
        observaciones.setName("observaciones");
//        observaciones.setType("String");
        observaciones.setTypesAttributes(typesobservaciones);
        observaciones.setEntities(typesAttributes);
        em.persist(observaciones);
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
//        name.setType("String");
        name.setTypesAttributes(typesname);
        name.setEntities(domainModels);
        em.persist(name);
        em.flush();

        TypesAttributes typesgroupId = new TypesAttributes();
        typesgroupId = findTypesAttributes("String");

        Attributes groupId = new Attributes();
        groupId.setName("groupId");
//        groupId.setType("String");
        groupId.setTypesAttributes(typesgroupId);
        groupId.setEntities(domainModels);
        em.persist(groupId);
        em.flush();

        TypesAttributes typesartifactId = new TypesAttributes();
        typesartifactId = findTypesAttributes("String");

        Attributes artifactId = new Attributes();
        artifactId.setName("artifactId");
//        artifactId.setType("String");
        artifactId.setTypesAttributes(typesartifactId);
        artifactId.setEntities(domainModels);
        em.persist(artifactId);
        em.flush();

        TypesAttributes typesversion = new TypesAttributes();
        typesversion = findTypesAttributes("String");

        Attributes version = new Attributes();
        version.setName("version");
//        version.setType("String");
        version.setTypesAttributes(typesversion);
        version.setEntities(domainModels);
        em.persist(version);
        em.flush();

        TypesAttributes typescodigo = new TypesAttributes();
        typescodigo = findTypesAttributes("String");

        Attributes codigo = new Attributes();
        codigo.setName("codigo");
//        codigo.setType("String");
        codigo.setTypesAttributes(typescodigo);
        codigo.setEntities(domainModels);
        em.persist(codigo);
        em.flush();

        TypesAttributes typesdate = new TypesAttributes();
        typesdate = findTypesAttributes("Date");

        Attributes date = new Attributes();
        date.setName("date");
//        date.setType("Date");
        date.setTypesAttributes(typesdate);
        date.setEntities(domainModels);
        em.persist(date);
        em.flush();

        TypesAttributes typesdescription = new TypesAttributes();
        typesdescription = findTypesAttributes("String");

        Attributes description = new Attributes();
        description.setName("description");
//        description.setType("String");
        description.setTypesAttributes(typesdescription);
        description.setEntities(domainModels);
        em.persist(description);
        em.flush();

        TypesAttributes typesobservaciones = new TypesAttributes();
        typesobservaciones = findTypesAttributes("String");

        Attributes observaciones = new Attributes();
        observaciones.setName("observaciones");
//        observaciones.setType("String");
        observaciones.setTypesAttributes(typesobservaciones);
        observaciones.setEntities(domainModels);
        em.persist(observaciones);
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
//        name.setType("String");
        name.setTypesAttributes(typesname);
        name.setEntities(systemsModels);
        em.persist(name);
        em.flush();

        TypesAttributes typesdescription = new TypesAttributes();
        typesdescription = findTypesAttributes("String");

        Attributes description = new Attributes();
        description.setName("description");
//        description.setType("String");
        description.setTypesAttributes(typesdescription);
        description.setEntities(systemsModels);
        em.persist(description);
        em.flush();

        TypesAttributes typesobservaciones = new TypesAttributes();
        typesobservaciones = findTypesAttributes("String");

        Attributes observaciones = new Attributes();
        observaciones.setName("observaciones");
//        observaciones.setType("String");
        observaciones.setTypesAttributes(typesobservaciones);
        observaciones.setEntities(systemsModels);
        em.persist(observaciones);
        em.flush();

    } // SystemsModels()

//  ---------------------- Relationships -------------------------

    public void Relations() {

//  ---------------------- Entities 1..* NameQueries -------------------------

        Entities fromEntities0 = new Entities();
        Cardinalities Entities0 = new Cardinalities();
        Entities   toEntities0 = new Entities();
        fromEntities0 = findEntities("Entities");
        Entities0 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toEntities0 = findEntities("NameQueries");
        Relationships relEntities0 = new Relationships();
        relEntities0.setFrom(fromEntities0);
        relEntities0.setCardinalities(Entities0);
        relEntities0.setTo(toEntities0);
        relEntities0.setOptionality(true);
        em.persist(relEntities0);
        em.flush();

//  ---------------------- Entities 1..* Relationships -------------------------

        Entities fromEntities1 = new Entities();
        Cardinalities Entities1 = new Cardinalities();
        Entities   toEntities1 = new Entities();
        fromEntities1 = findEntities("Entities");
        Entities1 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toEntities1 = findEntities("Relationships");
        Relationships relEntities1 = new Relationships();
        relEntities1.setFrom(fromEntities1);
        relEntities1.setCardinalities(Entities1);
        relEntities1.setTo(toEntities1);
        relEntities1.setOptionality(true);
        em.persist(relEntities1);
        em.flush();

//  ---------------------- Entities 1..* FilesModels -------------------------

        Entities fromEntities2 = new Entities();
        Cardinalities Entities2 = new Cardinalities();
        Entities   toEntities2 = new Entities();
        fromEntities2 = findEntities("Entities");
        Entities2 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toEntities2 = findEntities("FilesModels");
        Relationships relEntities2 = new Relationships();
        relEntities2.setFrom(fromEntities2);
        relEntities2.setCardinalities(Entities2);
        relEntities2.setTo(toEntities2);
        relEntities2.setOptionality(true);
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
        em.persist(relEntities5);
        em.flush();

//  ---------------------- Attributes 1..* PropertiesAttributes -------------------------

        Entities fromAttributes1 = new Entities();
        Cardinalities Attributes1 = new Cardinalities();
        Entities   toAttributes1 = new Entities();
        fromAttributes1 = findEntities("Attributes");
        Attributes1 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toAttributes1 = findEntities("PropertiesAttributes");
        Relationships relAttributes1 = new Relationships();
        relAttributes1.setFrom(fromAttributes1);
        relAttributes1.setCardinalities(Attributes1);
        relAttributes1.setTo(toAttributes1);
        relAttributes1.setOptionality(true);
        em.persist(relAttributes1);
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
        em.persist(relCardinalities0);
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
        em.persist(relGroupIds0);
        em.flush();

//  ---------------------- GroupIds 1..* LinksModels -------------------------

        Entities fromGroupIds1 = new Entities();
        Cardinalities GroupIds1 = new Cardinalities();
        Entities   toGroupIds1 = new Entities();
        fromGroupIds1 = findEntities("GroupIds");
        GroupIds1 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toGroupIds1 = findEntities("LinksModels");
        Relationships relGroupIds1 = new Relationships();
        relGroupIds1.setFrom(fromGroupIds1);
        relGroupIds1.setCardinalities(GroupIds1);
        relGroupIds1.setTo(toGroupIds1);
        relGroupIds1.setOptionality(true);
        em.persist(relGroupIds1);
        em.flush();

//  ---------------------- GroupIds 1..* Entities -------------------------

        Entities fromGroupIds3 = new Entities();
        Cardinalities GroupIds3 = new Cardinalities();
        Entities   toGroupIds3 = new Entities();
        fromGroupIds3 = findEntities("GroupIds");
        GroupIds3 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toGroupIds3 = findEntities("Entities");
        Relationships relGroupIds3 = new Relationships();
        relGroupIds3.setFrom(fromGroupIds3);
        relGroupIds3.setCardinalities(GroupIds3);
        relGroupIds3.setTo(toGroupIds3);
        relGroupIds3.setOptionality(true);
        em.persist(relGroupIds3);
        em.flush();

//  ---------------------- TiposLinksModels 1..* LinksModels -------------------------

        Entities fromTiposLinksModels0 = new Entities();
        Cardinalities TiposLinksModels0 = new Cardinalities();
        Entities   toTiposLinksModels0 = new Entities();
        fromTiposLinksModels0 = findEntities("TiposLinksModels");
        TiposLinksModels0 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toTiposLinksModels0 = findEntities("LinksModels");
        Relationships relTiposLinksModels0 = new Relationships();
        relTiposLinksModels0.setFrom(fromTiposLinksModels0);
        relTiposLinksModels0.setCardinalities(TiposLinksModels0);
        relTiposLinksModels0.setTo(toTiposLinksModels0);
        relTiposLinksModels0.setOptionality(true);
        em.persist(relTiposLinksModels0);
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
        em.persist(relRelationships3);
        em.flush();

//  ---------------------- TypesAttributes 1..* Attributes -------------------------

        Entities fromTypesAttributes0 = new Entities();
        Cardinalities TypesAttributes0 = new Cardinalities();
        Entities   toTypesAttributes0 = new Entities();
        fromTypesAttributes0 = findEntities("TypesAttributes");
        TypesAttributes0 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toTypesAttributes0 = findEntities("Attributes");
        Relationships relTypesAttributes0 = new Relationships();
        relTypesAttributes0.setFrom(fromTypesAttributes0);
        relTypesAttributes0.setCardinalities(TypesAttributes0);
        relTypesAttributes0.setTo(toTypesAttributes0);
        relTypesAttributes0.setOptionality(true);
        em.persist(relTypesAttributes0);
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
        em.persist(relDomainModels1);
        em.flush();

//  ---------------------- DomainModels 1..* FilesModels -------------------------

        Entities fromDomainModels2 = new Entities();
        Cardinalities DomainModels2 = new Cardinalities();
        Entities   toDomainModels2 = new Entities();
        fromDomainModels2 = findEntities("DomainModels");
        DomainModels2 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toDomainModels2 = findEntities("FilesModels");
        Relationships relDomainModels2 = new Relationships();
        relDomainModels2.setFrom(fromDomainModels2);
        relDomainModels2.setCardinalities(DomainModels2);
        relDomainModels2.setTo(toDomainModels2);
        relDomainModels2.setOptionality(true);
        em.persist(relDomainModels2);
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

//  ---------------------- SystemsModels 1..* FilesModels -------------------------

        Entities fromSystemsModels1 = new Entities();
        Cardinalities SystemsModels1 = new Cardinalities();
        Entities   toSystemsModels1 = new Entities();
        fromSystemsModels1 = findEntities("SystemsModels");
        SystemsModels1 = findCardinalities("Uno a Muchos Bidirecccional No.5");
        toSystemsModels1 = findEntities("FilesModels");
        Relationships relSystemsModels1 = new Relationships();
        relSystemsModels1.setFrom(fromSystemsModels1);
        relSystemsModels1.setCardinalities(SystemsModels1);
        relSystemsModels1.setTo(toSystemsModels1);
        relSystemsModels1.setOptionality(true);
        em.persist(relSystemsModels1);
        em.flush();


    } // Relations()
} // DomainModelsSetup

