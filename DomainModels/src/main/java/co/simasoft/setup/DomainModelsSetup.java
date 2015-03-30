package co.simasoft.setup;

import co.simasoft.models.naif.DomainModels.*;

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

    @PersistenceContext(unitName = "DomainModelsPU-JTA")
    private EntityManager em;

    private static final Logger log = Logger.getLogger(DomainModelsSetup.class.getName());

    public void data() {
      
        System.out.println("Hello World!");      

        DomainModels domainModels = new DomainModels();
        domainModels.setName("DomainModels");
        em.persist(domainModels);
        em.flush();

        Entities(domainModels);
        Attributes(domainModels);
        Cardinalities(domainModels);
        DomainModels(domainModels);
        PropertiesAttributes(domainModels);
        SystemsModels(domainModels);
        FilesModels(domainModels);
        LinksModels(domainModels);
        TiposLinksModels(domainModels);
        NameQueries(domainModels);
        Relationships(domainModels);
        TypesAttributes(domainModels);
    } // data()

    public void Entities(DomainModels domainModel) {

        Entities entities = new Entities();
        entities.setName("Entities");
        entities.setDomainModels(domainModel);
        em.persist(entities);
        em.flush();

        Attributes name = new Attributes();
        name.setName("name");
        name.setType("String");
        name.setEntities(entities);
        em.persist(name);
        em.flush();

        Attributes tabla = new Attributes();
        tabla.setName("tabla");
        tabla.setType("String");
        tabla.setEntities(entities);
        em.persist(tabla);
        em.flush();

        Attributes tablaSecuencia = new Attributes();
        tablaSecuencia.setName("tablaSecuencia");
        tablaSecuencia.setType("String");
        tablaSecuencia.setEntities(entities);
        em.persist(tablaSecuencia);
        em.flush();

        Attributes modifier = new Attributes();
        modifier.setName("modifier");
        modifier.setType("String");
        modifier.setEntities(entities);
        em.persist(modifier);
        em.flush();

        Attributes extend = new Attributes();
        extend.setName("extend");
        extend.setType("String");
        extend.setEntities(entities);
        em.persist(extend);
        em.flush();

        Attributes imports = new Attributes();
        imports.setName("imports");
        imports.setType("String");
        imports.setEntities(entities);
        em.persist(imports);
        em.flush();

        Attributes annotations = new Attributes();
        annotations.setName("annotations");
        annotations.setType("String");
        annotations.setEntities(entities);
        em.persist(annotations);
        em.flush();

        Attributes source = new Attributes();
        source.setName("source");
        source.setType("String");
        source.setEntities(entities);
        em.persist(source);
        em.flush();

        Attributes description = new Attributes();
        description.setName("description");
        description.setType("String");
        description.setEntities(entities);
        em.persist(description);
        em.flush();

        Attributes observaciones = new Attributes();
        observaciones.setName("observaciones");
        observaciones.setType("String");
        observaciones.setEntities(entities);
        em.persist(observaciones);
        em.flush();

    } // Entities()

    public void Attributes(DomainModels domainModel) {

        Entities attributes = new Entities();
        attributes.setName("Attributes");
        attributes.setDomainModels(domainModel);
        em.persist(attributes);
        em.flush();

        Attributes name = new Attributes();
        name.setName("name");
        name.setType("String");
        name.setEntities(attributes);
        em.persist(name);
        em.flush();

        Attributes type = new Attributes();
        type.setName("type");
        type.setType("String");
        type.setEntities(attributes);
        em.persist(type);
        em.flush();

        Attributes length = new Attributes();
        length.setName("length");
        length.setType("Integer");
        length.setEntities(attributes);
        em.persist(length);
        em.flush();

        Attributes precision = new Attributes();
        precision.setName("precision");
        precision.setType("Integer");
        precision.setEntities(attributes);
        em.persist(precision);
        em.flush();

        Attributes nullable = new Attributes();
        nullable.setName("nullable");
        nullable.setType("boolean");
        nullable.setEntities(attributes);
        em.persist(nullable);
        em.flush();

        Attributes unico = new Attributes();
        unico.setName("unico");
        unico.setType("boolean");
        unico.setEntities(attributes);
        em.persist(unico);
        em.flush();

        Attributes descripcion = new Attributes();
        descripcion.setName("descripcion");
        descripcion.setType("String");
        descripcion.setEntities(attributes);
        em.persist(descripcion);
        em.flush();

        Attributes field = new Attributes();
        field.setName("field");
        field.setType("String");
        field.setEntities(attributes);
        em.persist(field);
        em.flush();

        Attributes access = new Attributes();
        access.setName("access");
        access.setType("String");
        access.setEntities(attributes);
        em.persist(access);
        em.flush();

        Attributes columnDefinition = new Attributes();
        columnDefinition.setName("columnDefinition");
        columnDefinition.setType("String");
        columnDefinition.setEntities(attributes);
        em.persist(columnDefinition);
        em.flush();

        Attributes annotationsField = new Attributes();
        annotationsField.setName("annotationsField");
        annotationsField.setType("String");
        annotationsField.setEntities(attributes);
        em.persist(annotationsField);
        em.flush();

        Attributes annotationsMethod = new Attributes();
        annotationsMethod.setName("annotationsMethod");
        annotationsMethod.setType("String");
        annotationsMethod.setEntities(attributes);
        em.persist(annotationsMethod);
        em.flush();

        Attributes observaciones = new Attributes();
        observaciones.setName("observaciones");
        observaciones.setType("String");
        observaciones.setEntities(attributes);
        em.persist(observaciones);
        em.flush();

    } // Attributes()

    public void Cardinalities(DomainModels domainModel) {

        Entities cardinalities = new Entities();
        cardinalities.setName("Cardinalities");
        cardinalities.setDomainModels(domainModel);
        em.persist(cardinalities);
        em.flush();

        Attributes name = new Attributes();
        name.setName("name");
        name.setType("String");
        name.setEntities(cardinalities);
        em.persist(name);
        em.flush();

        Attributes cardinality = new Attributes();
        cardinality.setName("cardinality");
        cardinality.setType("String");
        cardinality.setEntities(cardinalities);
        em.persist(cardinality);
        em.flush();

        Attributes unidireccional = new Attributes();
        unidireccional.setName("unidireccional");
        unidireccional.setType("boolean");
        unidireccional.setEntities(cardinalities);
        em.persist(unidireccional);
        em.flush();

        Attributes observaciones = new Attributes();
        observaciones.setName("observaciones");
        observaciones.setType("String");
        observaciones.setEntities(cardinalities);
        em.persist(observaciones);
        em.flush();

    } // Cardinalities()

    public void DomainModels(DomainModels domainModel) {

        Entities domainModels = new Entities();
        domainModels.setName("DomainModels");
        domainModels.setDomainModels(domainModel);
        em.persist(domainModels);
        em.flush();

        Attributes name = new Attributes();
        name.setName("name");
        name.setType("String");
        name.setEntities(domainModels);
        em.persist(name);
        em.flush();

        Attributes paquete = new Attributes();
        paquete.setName("paquete");
        paquete.setType("String");
        paquete.setEntities(domainModels);
        em.persist(paquete);
        em.flush();

        Attributes release = new Attributes();
        release.setName("release");
        release.setType("String");
        release.setEntities(domainModels);
        em.persist(release);
        em.flush();

        Attributes codigo = new Attributes();
        codigo.setName("codigo");
        codigo.setType("String");
        codigo.setEntities(domainModels);
        em.persist(codigo);
        em.flush();

        Attributes date = new Attributes();
        date.setName("date");
        date.setType("Date");
        date.setEntities(domainModels);
        em.persist(date);
        em.flush();

        Attributes description = new Attributes();
        description.setName("description");
        description.setType("String");
        description.setEntities(domainModels);
        em.persist(description);
        em.flush();

        Attributes observaciones = new Attributes();
        observaciones.setName("observaciones");
        observaciones.setType("String");
        observaciones.setEntities(domainModels);
        em.persist(observaciones);
        em.flush();

    } // DomainModels()

    public void PropertiesAttributes(DomainModels domainModel) {

        Entities propertiesAttributes = new Entities();
        propertiesAttributes.setName("PropertiesAttributes");
        propertiesAttributes.setDomainModels(domainModel);
        em.persist(propertiesAttributes);
        em.flush();

        Attributes name = new Attributes();
        name.setName("name");
        name.setType("String");
        name.setEntities(propertiesAttributes);
        em.persist(name);
        em.flush();

        Attributes value = new Attributes();
        value.setName("value");
        value.setType("String");
        value.setEntities(propertiesAttributes);
        em.persist(value);
        em.flush();

        Attributes observaciones = new Attributes();
        observaciones.setName("observaciones");
        observaciones.setType("String");
        observaciones.setEntities(propertiesAttributes);
        em.persist(observaciones);
        em.flush();

    } // PropertiesAttributes()

    public void SystemsModels(DomainModels domainModel) {

        Entities systemsModels = new Entities();
        systemsModels.setName("SystemsModels");
        systemsModels.setDomainModels(domainModel);
        em.persist(systemsModels);
        em.flush();

        Attributes name = new Attributes();
        name.setName("name");
        name.setType("String");
        name.setEntities(systemsModels);
        em.persist(name);
        em.flush();

        Attributes codigo = new Attributes();
        codigo.setName("codigo");
        codigo.setType("String");
        codigo.setEntities(systemsModels);
        em.persist(codigo);
        em.flush();

        Attributes release = new Attributes();
        release.setName("release");
        release.setType("String");
        release.setEntities(systemsModels);
        em.persist(release);
        em.flush();

        Attributes fecha = new Attributes();
        fecha.setName("fecha");
        fecha.setType("Date");
        fecha.setEntities(systemsModels);
        em.persist(fecha);
        em.flush();

        Attributes description = new Attributes();
        description.setName("description");
        description.setType("String");
        description.setEntities(systemsModels);
        em.persist(description);
        em.flush();

    } // SystemsModels()

    public void FilesModels(DomainModels domainModel) {

        Entities filesModels = new Entities();
        filesModels.setName("FilesModels");
        filesModels.setDomainModels(domainModel);
        em.persist(filesModels);
        em.flush();

        Attributes codigo = new Attributes();
        codigo.setName("codigo");
        codigo.setType("String");
        codigo.setEntities(filesModels);
        em.persist(codigo);
        em.flush();

        Attributes archivo = new Attributes();
        archivo.setName("archivo");
        archivo.setType("String");
        archivo.setEntities(filesModels);
        em.persist(archivo);
        em.flush();

        Attributes extension = new Attributes();
        extension.setName("extension");
        extension.setType("String");
        extension.setEntities(filesModels);
        em.persist(extension);
        em.flush();

        Attributes data = new Attributes();
        data.setName("data");
        data.setType("byte");
        data.setEntities(filesModels);
        em.persist(data);
        em.flush();

        Attributes type = new Attributes();
        type.setName("type");
        type.setType("String");
        type.setEntities(filesModels);
        em.persist(type);
        em.flush();

        Attributes observacion = new Attributes();
        observacion.setName("observacion");
        observacion.setType("String");
        observacion.setEntities(filesModels);
        em.persist(observacion);
        em.flush();

    } // FilesModels()

    public void LinksModels(DomainModels domainModel) {

        Entities linksModels = new Entities();
        linksModels.setName("LinksModels");
        linksModels.setDomainModels(domainModel);
        em.persist(linksModels);
        em.flush();

        Attributes titulo = new Attributes();
        titulo.setName("titulo");
        titulo.setType("String");
        titulo.setEntities(linksModels);
        em.persist(titulo);
        em.flush();

        Attributes link = new Attributes();
        link.setName("link");
        link.setType("String");
        link.setEntities(linksModels);
        em.persist(link);
        em.flush();

        Attributes observacion = new Attributes();
        observacion.setName("observacion");
        observacion.setType("String");
        observacion.setEntities(linksModels);
        em.persist(observacion);
        em.flush();

    } // LinksModels()

    public void TiposLinksModels(DomainModels domainModel) {

        Entities tiposLinksModels = new Entities();
        tiposLinksModels.setName("TiposLinksModels");
        tiposLinksModels.setDomainModels(domainModel);
        em.persist(tiposLinksModels);
        em.flush();

        Attributes nombre = new Attributes();
        nombre.setName("nombre");
        nombre.setType("String");
        nombre.setEntities(tiposLinksModels);
        em.persist(nombre);
        em.flush();

    } // TiposLinksModels()

    public void NameQueries(DomainModels domainModel) {

        Entities nameQueries = new Entities();
        nameQueries.setName("NameQueries");
        nameQueries.setDomainModels(domainModel);
        em.persist(nameQueries);
        em.flush();

        Attributes name = new Attributes();
        name.setName("name");
        name.setType("String");
        name.setEntities(nameQueries);
        em.persist(name);
        em.flush();

        Attributes query = new Attributes();
        query.setName("query");
        query.setType("String");
        query.setEntities(nameQueries);
        em.persist(query);
        em.flush();

        Attributes observaciones = new Attributes();
        observaciones.setName("observaciones");
        observaciones.setType("String");
        observaciones.setEntities(nameQueries);
        em.persist(observaciones);
        em.flush();

    } // NameQueries()

    public void Relationships(DomainModels domainModel) {

        Entities relationships = new Entities();
        relationships.setName("Relationships");
        relationships.setDomainModels(domainModel);
        em.persist(relationships);
        em.flush();

        Attributes entity = new Attributes();
        entity.setName("entity");
        entity.setType("String");
        entity.setEntities(relationships);
        em.persist(entity);
        em.flush();

        Attributes optionality = new Attributes();
        optionality.setName("optionality");
        optionality.setType("boolean");
        optionality.setEntities(relationships);
        em.persist(optionality);
        em.flush();

        Attributes name = new Attributes();
        name.setName("name");
        name.setType("String");
        name.setEntities(relationships);
        em.persist(name);
        em.flush();

        Attributes mappedby = new Attributes();
        mappedby.setName("mappedby");
        mappedby.setType("String");
        mappedby.setEntities(relationships);
        em.persist(mappedby);
        em.flush();

        Attributes annotationsMethod = new Attributes();
        annotationsMethod.setName("annotationsMethod");
        annotationsMethod.setType("String");
        annotationsMethod.setEntities(relationships);
        em.persist(annotationsMethod);
        em.flush();

        Attributes annotationsField = new Attributes();
        annotationsField.setName("annotationsField");
        annotationsField.setType("String");
        annotationsField.setEntities(relationships);
        em.persist(annotationsField);
        em.flush();

        Attributes tabla = new Attributes();
        tabla.setName("tabla");
        tabla.setType("String");
        tabla.setEntities(relationships);
        em.persist(tabla);
        em.flush();

        Attributes idTabla1 = new Attributes();
        idTabla1.setName("idTabla1");
        idTabla1.setType("String");
        idTabla1.setEntities(relationships);
        em.persist(idTabla1);
        em.flush();

        Attributes idTabla2 = new Attributes();
        idTabla2.setName("idTabla2");
        idTabla2.setType("String");
        idTabla2.setEntities(relationships);
        em.persist(idTabla2);
        em.flush();

        Attributes description = new Attributes();
        description.setName("description");
        description.setType("String");
        description.setEntities(relationships);
        em.persist(description);
        em.flush();

        Attributes observaciones = new Attributes();
        observaciones.setName("observaciones");
        observaciones.setType("String");
        observaciones.setEntities(relationships);
        em.persist(observaciones);
        em.flush();

    } // Relationships()

    public void TypesAttributes(DomainModels domainModel) {

        Entities typesAttributes = new Entities();
        typesAttributes.setName("TypesAttributes");
        typesAttributes.setDomainModels(domainModel);
        em.persist(typesAttributes);
        em.flush();

        Attributes name = new Attributes();
        name.setName("name");
        name.setType("String");
        name.setEntities(typesAttributes);
        em.persist(name);
        em.flush();

        Attributes length = new Attributes();
        length.setName("length");
        length.setType("Integer");
        length.setEntities(typesAttributes);
        em.persist(length);
        em.flush();

        Attributes precision = new Attributes();
        precision.setName("precision");
        precision.setType("Integer");
        precision.setEntities(typesAttributes);
        em.persist(precision);
        em.flush();

        Attributes annotations = new Attributes();
        annotations.setName("annotations");
        annotations.setType("String");
        annotations.setEntities(typesAttributes);
        em.persist(annotations);
        em.flush();

        Attributes observaciones = new Attributes();
        observaciones.setName("observaciones");
        observaciones.setType("String");
        observaciones.setEntities(typesAttributes);
        em.persist(observaciones);
        em.flush();

    } // TypesAttributes()

} // DomainModelsSetup

