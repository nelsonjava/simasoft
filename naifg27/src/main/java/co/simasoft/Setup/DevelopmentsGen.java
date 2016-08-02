package co.simasoft.setup;

import co.simasoft.utils.*;
import co.simasoft.beans.*;

import co.simasoft.models.*;

import java.io.*;
import java.util.*;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.inject.Named;

import org.jboss.logging.Logger;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@LocalBean
@Named("DevelopmentsGen")
public class DevelopmentsGen extends FileTxt {

    private String texto = "";
    private static final Logger log = Logger.getLogger(DevelopmentsGen.class.getName());
    private static final String QUERYA = "SELECT c FROM AttributesProperties c WHERE c.name LIKE :custName";

    @PersistenceContext(unitName = "naifg27PU-JTA")
    private EntityManager em;

    ArrayList<Packages> packages = new ArrayList<Packages>();
    LinkedHashSet<String> imports = new LinkedHashSet<String>();

    Set<String> entitiesNames = new HashSet<String>();
    ArrayList<Entidad> entidades = new ArrayList<Entidad>(0);

    ArrayList<Relationships> relationships = new ArrayList<Relationships>(0);

    FindBean findBean = new FindBean();

    public void data(Developments developments) {
    try {

        clearFileTxt();

        texto = "developments:"+developments.getArtifactId();
        log.info(texto);
        line(texto);

        relationships = relationships(developments);
        entitiesNames = entitiesNames(relationships);
        entidades = Entidades(entitiesNames);

        line("");
        texto = "==== Imports ====";
        log.info(texto);
        line(texto);

        for (String txt : imports){

            texto = txt;
            log.info(texto);
            line(texto);

        }

        saveFile("\\docs", "logs.txt");

        ModelsGen modelsGen = new ModelsGen(developments.getGroupId(),developments.getArtifactId());
        modelsGen.setImports(imports);
        modelsGen.setPackages(packages);
        modelsGen.setEntities(entidades);
        modelsGen.WarH2();
        modelsGen.jdocbook();
        modelsGen.ForgeWarH2();

    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    } // data()

    public ArrayList<Relationships> relationships(Developments developments){

        ArrayList<Relationships> relations = new ArrayList<Relationships>(0);

        for (DevelopmentsGroups developmentsGroups : developments.getDevelopmentsGroups()){

            texto = "developmentsGroups:"+developmentsGroups.getName();
            log.info(texto);
            line(texto);

            for (GroupsModels groupsModels : developmentsGroups.getGroups().getGroupsModels()){

                 line("");
                 texto = "==== RELACIONES:"+groupsModels.getName()+" ====:"+Integer.toString(groupsModels.getModels().getModelRelationships().size());
                 log.info(texto);
                 line(texto);

                 for (ModelRelationships modelRelationships : groupsModels.getModels().getModelRelationships()){

                      Relationships relation = modelRelationships.getRelationships();
                      relation.setName(relation.getName());

                      texto = String.valueOf(relation.getId())+":"+
                              relation.getFrom().getName()+" "+
                              relation.getCardinalities().getCardinality()+" "+
                              relation.getTo().getName();
                              if(relation.getCardinalities().getIsUnidirectional()){
                                 texto += " Unidirectional ";
                              }
                              else {
                                 texto += " Bidirectional ";
                              }
                              texto += relation.getName();

                      log.info(texto);
                      line(texto);

                      relations.add(relation);


                 } // modelRelationships

            } // groupsModels

        } // developmentsGroups

        return relations;

    } // relationships(...)


    public Set<String> entitiesNames(ArrayList<Relationships> relationships){
	Set<String> entitiesNames = new HashSet<String>();
        for (Relationships relation : relationships){
            entitiesNames.add(relation.getFrom().getName());
            entitiesNames.add(relation.getTo().getName());
        }
        return entitiesNames;
    } // entitiesNames

    public ArrayList<Entidad> Entidades(Set<String> entitiesNames) {

        ArrayList<Entidad> entidades = new ArrayList<Entidad>(0);

        line("");
        texto = "==== ENTIDADES ====:"+Integer.toString(entitiesNames.size());
        log.info(texto);
        line(texto);

        for(String nameEntity : entitiesNames){

            Entities entity = findBean.nameEntities(nameEntity,em);
            Entidad entidad = new Entidad(entity.getName());

            texto = entidad.getName();
            log.info(texto);
            line(texto);

            entidad.setGroupId(entity.getGroupIds().getGroupId());
            entidad.setAtributos(AddAtributos(entity.getAttributes()));
            entidad.setRelations(AddRelations(entidad));

            entidades.add(entidad);


            imports.add("import "+entity.getGroupIds().getGroupId()+".*;");

        }

        packages.add(new Packages("co.simasoft",entidades));

        return entidades;

    } // Entidades(...)

    public ArrayList<Relation> AddRelations(Entidad entidad) {

        ArrayList<Relation> relations = new ArrayList<Relation>(0);
        Cardinalities cardinalitiesFrom = new Cardinalities();

        texto = "   ***Relationships:";
        log.info(texto);
        line(texto);


        for(Relationships relationship : relationships){

            if(entidad.getName().equals(relationship.getFrom().getName())){

               Relation relationFrom = new Relation();
               relationFrom.setFrom(relationship.getFrom().getName());
               relationFrom.setTo(relationship.getTo().getName());

               cardinalitiesFrom = relationship.getCardinalities();
               relationFrom.setCardinality(cardinalitiesFrom.getCardinality());
               relationFrom.setNameCardinality(cardinalitiesFrom.getName());
               relationFrom.setName(relationship.getName());
               relationFrom.setUnidireccional(true);

               relations.add(relationFrom);

               imports.add("import javax.persistence.OneToMany;");
               imports.add("import javax.persistence.ManyToOne;");
               imports.add("import javax.persistence.ManyToMany;");

               texto = "      "+
                       relationFrom.getFrom()+" "+
                       relationFrom.getCardinality()+" "+
                       relationFrom.getTo();

                       if(cardinalitiesFrom.getIsUnidirectional()){
                          texto += " Unidirectional";
                       }
                       else {
                          texto += " Bidirectional";
                       }

               log.info(texto);
               line(texto);

/*
               if (!cardinalitiesFrom.getIsUnidirectional()){ // Bidireccional

                   Relation relationTo = new Relation();
                   relationTo.setFrom(relationship.getTo().getName());
                   relationTo.setTo(relationship.getFrom().getName());

                   Cardinalities cardinalitiesTo = cardinalitiesFrom.getObjPadre();
                   relationTo.setCardinality(cardinalitiesTo.getCardinality());
                   relationTo.setName(relationship.getName());
                   relationTo.setUnidireccional(true);

                   relations.add(relationTo);

                   texto = "      "+
                           relationTo.getFrom()+" "+
                           relationTo.getCardinality()+" "+
                           relationTo.getTo()+
                           " Unidirectional.";

                   log.info(texto);
                   line(texto);
               }
*/

            } // if

        } // for relationship


        for(Relationships relationship : relationships){

            if (entidad.getName().equals(relationship.getTo().getName())){

                cardinalitiesFrom = relationship.getCardinalities();

                if (!cardinalitiesFrom.getIsUnidirectional()){ // // Bidireccional

                    Relation relationTo = new Relation();
                    relationTo.setFrom(relationship.getTo().getName());
                    relationTo.setTo(relationship.getFrom().getName());

                    Cardinalities cardinalitiesTo = cardinalitiesFrom.getObjPadre();
                    relationTo.setCardinality(cardinalitiesTo.getCardinality());
                    relationTo.setName(relationship.getName());
                    relationTo.setUnidireccional(true);

                    relations.add(relationTo);

                    texto = "      "+
                           relationTo.getFrom()+" "+
                           relationTo.getCardinality()+" "+
                           relationTo.getTo()+
                           " Unidirectional.";

                    log.info(texto);
                    line(texto);

                }

            }

        } // for relationship



/*
        for(Relationships relationship : relationships){

            if(entidad.getName().equals(relationship.getTo().getName())){
               Relation relation = new Relation();
               relation.setFrom(relationship.getFrom().getName());
               relation.setTo(relationship.getTo().getName());
               relation.setCardinality("*..1");
               relation.setName(relationship.getName());
               relation.setUnidireccional(true);

               relations.add(relation);

               texto = "      "+
                       relation.getFrom()+" "+
                       relation.getCardinality()+" "+
                       relation.getTo();

               log.info(texto);
               line(texto);
            }

        }
*/

        return relations;
    } // function



    public ArrayList<Atributos> AddAtributos(Set<Attributes> attributes) {

        ArrayList<Atributos> atributos = new ArrayList<Atributos>(0);

        for(Attributes attribute : attributes){

            texto = "---"+attribute.getName();
            log.info(texto);
            line(texto);

            Atributos atributo = new Atributos();
            atributo.setOrden(attribute.getOrden());
            atributo.setField(attribute.getName());
            atributo.setDescription(attribute.getDescription());
            atributo.setType(attribute.getAttributesTypes().getType());
            atributo.setLength(attribute.getLength());
            atributo.setPrecision(attribute.getPrecision());
            atributo.setNulo(attribute.getIsNullable());
            atributo.setUnique(attribute.getIsUnique());
            atributo.setIsSimplified(attribute.getIsSimplified());
            atributo.setIsCreate(attribute.getIsCreate());
            atributo.setIsSearch(attribute.getIsSearch());
            atributo.setIsView(attribute.getIsView());
            atributo.setIsViewColumn(attribute.getIsViewColumn());
            if(Utils.isEmpty(attribute.getIsViewRelation())){
               atributo.setIsViewRelation(false);
            }
            else{
               atributo.setIsViewRelation(attribute.getIsViewRelation());
            }
            atributo.setAnnotations(annotations(attribute));

            atributos.add(atributo);


        } // attributes

        return atributos;

    } // function



    public String annotations(Attributes attribute) {

        String annotations = "";
        AttributesProperties properties = new AttributesProperties();
        if(attribute.getIsNullable() & attribute.getIsUnique()){
           properties = findAttributesProperties("NullUnique1");
           annotations += "    "+properties.getValue();
        }
        if(attribute.getIsNullable() & !attribute.getIsUnique()){
           properties = findAttributesProperties("NullUnique2");
           annotations += "    "+properties.getValue();
        }
        if(!attribute.getIsNullable() & attribute.getIsUnique()){
           properties = findAttributesProperties("NullUnique3");
           annotations += "    "+properties.getValue();
        }
        if(!attribute.getIsNullable() & !attribute.getIsUnique()){
           properties = findAttributesProperties("NullUnique4");
           annotations += "    "+properties.getValue();
        }

        Set<AttributesProperties> attributesProperties = attribute.getAttributesTypes().getAttributesProperties();
        if(attributesProperties.size() > 0){
           annotations += "\n";
        }

        int i=0;
        for(AttributesProperties attributeProperties : attributesProperties ){
            annotations += "    "+attributeProperties.getValue();
            if(++i < attributesProperties.size()){
               annotations += "\n";
            }
            for(Imports importss : attributeProperties.getImports() ){
                imports.add(importss.getName());
            }
        }

        return annotations;
    }

    public AttributesProperties findAttributesProperties(String name) {

        AttributesProperties attributesProperties = new AttributesProperties();
        List<AttributesProperties> results = em.createQuery("SELECT c FROM AttributesProperties c WHERE c.name LIKE :custName").setParameter("custName", name).getResultList();

        if (!results.isEmpty()) {
           attributesProperties = results.get(0);
        }
        return attributesProperties;
    }





} // DevelopmentsGen