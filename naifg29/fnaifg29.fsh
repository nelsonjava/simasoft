scaffold-setup --provider Faces
scaffold-generate --web-root /admin --provider Faces --targets co.simasoft.models.*;
project-new --named wnaifg29
jpa-setup
scaffold-setup --provider AngularJS

#  AttributesProperties entity
#  ############
jpa-new-entity --named AttributesProperties --targetPackage co.simasoft.models
jpa-new-field --named name --type String
jpa-new-field --named value --type String

#  Attributes entity
#  ############
jpa-new-entity --named Attributes --targetPackage co.simasoft.models
jpa-new-field --named isUnique --type Boolean
jpa-new-field --named isCreate --type Boolean
jpa-new-field --named isSearch --type Boolean
jpa-new-field --named isView --type Boolean
jpa-new-field --named isViewColumn --type Boolean
jpa-new-field --named isViewRelation --type Boolean
jpa-new-field --named name --type String
jpa-new-field --named description --type String
jpa-new-field --named length --type Integer
jpa-new-field --named precision --type Integer
jpa-new-field --named isNullable --type Boolean

#  ModelsGroups entity
#  ############
jpa-new-entity --named ModelsGroups --targetPackage co.simasoft.models
jpa-new-field --named name --type String
jpa-new-field --named code --type String

#  Imports entity
#  ############
jpa-new-entity --named Imports --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  Entities entity
#  ############
jpa-new-entity --named Entities --targetPackage co.simasoft.models
jpa-new-field --named name --type String
jpa-new-field --named serialID --type String
jpa-new-field --named table --type String
jpa-new-field --named description --type String

#  Sites entity
#  ############
jpa-new-entity --named Sites --targetPackage co.simasoft.models
jpa-new-field --named title --type String
jpa-new-field --named link --type String
jpa-new-field --named abc --type String

#  Pom entity
#  ############
jpa-new-entity --named Pom --targetPackage co.simasoft.models
jpa-new-field --named groupId --type String
jpa-new-field --named artifactId --type String
jpa-new-field --named version --type String

#  GroupIds entity
#  ############
jpa-new-entity --named GroupIds --targetPackage co.simasoft.models
jpa-new-field --named artifactId --type String
jpa-new-field --named groupId --type String
jpa-new-field --named version --type String
jpa-new-field --named code --type String
jpa-new-field --named date --type java.util.Date --temporalType TIMESTAMP

#  Relationships entity
#  ############
jpa-new-entity --named Relationships --targetPackage co.simasoft.models
jpa-new-field --named name --type String
jpa-new-field --named isOptionality --type Boolean
jpa-new-field --named isCreate --type Boolean
jpa-new-field --named isSearch --type Boolean
jpa-new-field --named isView --type Boolean

#  Fields entity
#  ############
jpa-new-entity --named Fields --targetPackage co.simasoft.models
jpa-new-field --named description --type String
jpa-new-field --named length --type Integer
jpa-new-field --named precision --type Integer
jpa-new-field --named isNullable --type Boolean
jpa-new-field --named isUnique --type Boolean
jpa-new-field --named isCreate --type Boolean
jpa-new-field --named isSearch --type Boolean
jpa-new-field --named isView --type Boolean
jpa-new-field --named isViewColumn --type Boolean
jpa-new-field --named isViewRelation --type Boolean
jpa-new-field --named name --type String

#  Cardinalities entity
#  ############
jpa-new-entity --named Cardinalities --targetPackage co.simasoft.models
jpa-new-field --named name --type String
jpa-new-field --named cardinality --type String
jpa-new-field --named isUnidirectional --type Boolean

#  AttributesTypes entity
#  ############
jpa-new-entity --named AttributesTypes --targetPackage co.simasoft.models
jpa-new-field --named name --type String
jpa-new-field --named type --type String
jpa-new-field --named length --type Integer
jpa-new-field --named precision --type Integer
jpa-new-field --named annotations --type String

#  GroupIdsTypes entity
#  ############
jpa-new-entity --named GroupIdsTypes --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  SitesTypes entity
#  ############
jpa-new-entity --named SitesTypes --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  Models entity
#  ############
jpa-new-entity --named Models --targetPackage co.simasoft.models
jpa-new-field --named name --type String
jpa-new-field --named code --type String

#  Dependencies entity
#  ############
jpa-new-entity --named Dependencies --targetPackage co.simasoft.models
jpa-new-field --named groupId --type String
jpa-new-field --named artifactId --type String
jpa-new-field --named version --type String
jpa-new-field --named type --type String
jpa-new-field --named scope --type String
jpa-new-field --named maven --type String

#  ModelRelationships entity
#  ############
jpa-new-entity --named ModelRelationships --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  Developments entity
#  ############
jpa-new-entity --named Developments --targetPackage co.simasoft.models
jpa-new-field --named artifactId --type String
jpa-new-field --named groupId --type String
jpa-new-field --named version --type String
jpa-new-field --named code --type String
jpa-new-field --named date --type java.util.Date --temporalType TIMESTAMP

#  AttributesProperties Relationships 
#  ############
#  AttributesProperties Muchos a Muchos Bidirecccional No.7 Imports
cd ..
cd AttributesProperties.java
jpa-new-field --named imports --type co.simasoft.models.Imports --relationshipType Many-to-Many  ----inverseFieldName attributesProperties;

#  AttributesProperties Muchos a Muchos Bidirecccional No.7 Sites
cd ..
cd AttributesProperties.java
jpa-new-field --named sites --type co.simasoft.models.Sites --relationshipType Many-to-Many  ----inverseFieldName attributesProperties;

#  AttributesProperties Muchos a Muchos Unidireccional No.6 AttributesTypes
cd ..
cd AttributesProperties.java
jpa-new-field --named attributesTypes --type co.simasoft.models.AttributesTypes --relationshipType Many-to-Many  ----inverseFieldName attributesProperties;

#  AttributesProperties Muchos a Muchos Unidireccional No.6 Cardinalities
cd ..
cd AttributesProperties.java
jpa-new-field --named cardinalities --type co.simasoft.models.Cardinalities --relationshipType Many-to-Many  ----inverseFieldName attributesProperties;

#  AttributesProperties Muchos a Muchos Unidireccional No.6 Relationships
cd ..
cd AttributesProperties.java
jpa-new-field --named relationships --type co.simasoft.models.Relationships --relationshipType Many-to-Many  ----inverseFieldName attributesProperties;

#  AttributesProperties Muchos a Uno Unidireccional No.3 Entities
cd ..
cd AttributesProperties.java
jpa-new-field --named entities --type co.simasoft.models.Entities --relationshipType Many-to-One;

#  AttributesProperties Muchos a Muchos Unidireccional No.6 Attributes
cd ..
cd AttributesProperties.java
jpa-new-field --named attributes --type co.simasoft.models.Attributes --relationshipType Many-to-Many  ----inverseFieldName attributesProperties;

#  Attributes Relationships 
#  ############
#  Attributes Uno a Muchos Bidirecccional No.5 Sites
cd ..
cd Attributes.java
jpa-new-field --named sites --type co.simasoft.models.Sites --relationshipType One-to-Many;

#  Attributes Muchos a Muchos Bidirecccional No.7 AttributesProperties
cd ..
cd Attributes.java
jpa-new-field --named attributesProperties --type co.simasoft.models.AttributesProperties --relationshipType Many-to-Many  ----inverseFieldName attributes;

#  Attributes Muchos a Uno Unidireccional No.3 Entities
cd ..
cd Attributes.java
jpa-new-field --named entities --type co.simasoft.models.Entities --relationshipType Many-to-One;

#  Attributes Muchos a Uno Unidireccional No.3 AttributesTypes
cd ..
cd Attributes.java
jpa-new-field --named attributesTypes --type co.simasoft.models.AttributesTypes --relationshipType Many-to-One;

#  Attributes Muchos a Uno Unidireccional No.3 Fields
cd ..
cd Attributes.java
jpa-new-field --named fields --type co.simasoft.models.Fields --relationshipType Many-to-One;

#  ModelsGroups Relationships 
#  ############
#  ModelsGroups Muchos a Muchos Bidirecccional No.7 Models
cd ..
cd ModelsGroups.java
jpa-new-field --named models --type co.simasoft.models.Models --relationshipType Many-to-Many  ----inverseFieldName modelsGroups;

#  ModelsGroups Muchos a Muchos Unidireccional No.6 Developments
cd ..
cd ModelsGroups.java
jpa-new-field --named developments --type co.simasoft.models.Developments --relationshipType Many-to-Many  ----inverseFieldName modelsGroups;

#  Imports Relationships 
#  ############
#  Imports Muchos a Muchos Bidirecccional No.7 Sites
cd ..
cd Imports.java
jpa-new-field --named sites --type co.simasoft.models.Sites --relationshipType Many-to-Many  ----inverseFieldName imports;

#  Imports Muchos a Uno Unidireccional No.3 Dependencies
cd ..
cd Imports.java
jpa-new-field --named dependencies --type co.simasoft.models.Dependencies --relationshipType Many-to-One;

#  Imports Muchos a Muchos Unidireccional No.6 AttributesProperties
cd ..
cd Imports.java
jpa-new-field --named attributesProperties --type co.simasoft.models.AttributesProperties --relationshipType Many-to-Many  ----inverseFieldName imports;

#  Imports Muchos a Muchos Unidireccional No.6 Cardinalities
cd ..
cd Imports.java
jpa-new-field --named cardinalities --type co.simasoft.models.Cardinalities --relationshipType Many-to-Many  ----inverseFieldName imports;

#  Imports Muchos a Muchos Unidireccional No.6 Entities
cd ..
cd Imports.java
jpa-new-field --named entities --type co.simasoft.models.Entities --relationshipType Many-to-Many  ----inverseFieldName imports;

#  Entities Relationships 
#  ############
#  Entities Uno a Muchos Bidirecccional No.5 Attributes
cd ..
cd Entities.java
jpa-new-field --named attributes --type co.simasoft.models.Attributes --relationshipType One-to-Many;

#  Entities Uno a Muchos Bidirecccional No.5 Relationships
cd ..
cd Entities.java
jpa-new-field --named relationships --type co.simasoft.models.Relationships --relationshipType One-to-Many;

#  Entities Uno a Muchos Bidirecccional No.5 Relationships
cd ..
cd Entities.java
jpa-new-field --named relationships --type co.simasoft.models.Relationships --relationshipType One-to-Many;

#  Entities Muchos a Muchos Bidirecccional No.7 Sites
cd ..
cd Entities.java
jpa-new-field --named sites --type co.simasoft.models.Sites --relationshipType Many-to-Many  ----inverseFieldName entities;

#  Entities Uno a Muchos Bidirecccional No.5 AttributesProperties
cd ..
cd Entities.java
jpa-new-field --named attributesProperties --type co.simasoft.models.AttributesProperties --relationshipType One-to-Many;

#  Entities Muchos a Muchos Bidirecccional No.7 Imports
cd ..
cd Entities.java
jpa-new-field --named imports --type co.simasoft.models.Imports --relationshipType Many-to-Many  ----inverseFieldName entities;

#  Entities Muchos a Uno Unidireccional No.3 GroupIds
cd ..
cd Entities.java
jpa-new-field --named groupIds --type co.simasoft.models.GroupIds --relationshipType Many-to-One;

#  Sites Relationships 
#  ############
#  Sites Muchos a Muchos Bidirecccional No.7 SitesTypes
cd ..
cd Sites.java
jpa-new-field --named sitesTypes --type co.simasoft.models.SitesTypes --relationshipType Many-to-Many  ----inverseFieldName sites;

#  Sites Muchos a Muchos Unidireccional No.6 Models
cd ..
cd Sites.java
jpa-new-field --named models --type co.simasoft.models.Models --relationshipType Many-to-Many  ----inverseFieldName sites;

#  Sites Muchos a Muchos Unidireccional No.6 Entities
cd ..
cd Sites.java
jpa-new-field --named entities --type co.simasoft.models.Entities --relationshipType Many-to-Many  ----inverseFieldName sites;

#  Sites Muchos a Muchos Unidireccional No.6 Developments
cd ..
cd Sites.java
jpa-new-field --named developments --type co.simasoft.models.Developments --relationshipType Many-to-Many  ----inverseFieldName sites;

#  Sites Muchos a Muchos Unidireccional No.6 GroupIds
cd ..
cd Sites.java
jpa-new-field --named groupIds --type co.simasoft.models.GroupIds --relationshipType Many-to-Many  ----inverseFieldName sites;

#  Sites Muchos a Muchos Unidireccional No.6 Cardinalities
cd ..
cd Sites.java
jpa-new-field --named cardinalities --type co.simasoft.models.Cardinalities --relationshipType Many-to-Many  ----inverseFieldName sites;

#  Sites Muchos a Uno Unidireccional No.3 Attributes
cd ..
cd Sites.java
jpa-new-field --named attributes --type co.simasoft.models.Attributes --relationshipType Many-to-One;

#  Sites Muchos a Muchos Unidireccional No.6 Imports
cd ..
cd Sites.java
jpa-new-field --named imports --type co.simasoft.models.Imports --relationshipType Many-to-Many  ----inverseFieldName sites;

#  Sites Muchos a Muchos Unidireccional No.6 AttributesProperties
cd ..
cd Sites.java
jpa-new-field --named attributesProperties --type co.simasoft.models.AttributesProperties --relationshipType Many-to-Many  ----inverseFieldName sites;

#  Sites Muchos a Muchos Unidireccional No.6 Dependencies
cd ..
cd Sites.java
jpa-new-field --named dependencies --type co.simasoft.models.Dependencies --relationshipType Many-to-Many  ----inverseFieldName sites;

#  Sites Muchos a Muchos Unidireccional No.6 AttributesTypes
cd ..
cd Sites.java
jpa-new-field --named attributesTypes --type co.simasoft.models.AttributesTypes --relationshipType Many-to-Many  ----inverseFieldName sites;

#  Pom Relationships 
#  ############
#  Pom Uno a Muchos Bidirecccional No.5 Dependencies
cd ..
cd Pom.java
jpa-new-field --named dependencies --type co.simasoft.models.Dependencies --relationshipType One-to-Many;

#  Pom Muchos a Muchos Unidireccional No.6 Developments
cd ..
cd Pom.java
jpa-new-field --named developments --type co.simasoft.models.Developments --relationshipType Many-to-Many  ----inverseFieldName pom;

#  Pom Muchos a Muchos Unidireccional No.6 GroupIds
cd ..
cd Pom.java
jpa-new-field --named groupIds --type co.simasoft.models.GroupIds --relationshipType Many-to-Many  ----inverseFieldName pom;

#  GroupIds Relationships 
#  ############
#  GroupIds Uno a Muchos Bidirecccional No.5 Entities
cd ..
cd GroupIds.java
jpa-new-field --named entities --type co.simasoft.models.Entities --relationshipType One-to-Many;

#  GroupIds Uno a Muchos Bidirecccional No.5 Models
cd ..
cd GroupIds.java
jpa-new-field --named models --type co.simasoft.models.Models --relationshipType One-to-Many;

#  GroupIds Muchos a Muchos Bidirecccional No.7 Sites
cd ..
cd GroupIds.java
jpa-new-field --named sites --type co.simasoft.models.Sites --relationshipType Many-to-Many  ----inverseFieldName groupIds;

#  GroupIds Muchos a Muchos Bidirecccional No.7 Pom
cd ..
cd GroupIds.java
jpa-new-field --named pom --type co.simasoft.models.Pom --relationshipType Many-to-Many  ----inverseFieldName groupIds;

#  GroupIds Muchos a Uno Unidireccional No.3 GroupIdsTypes
cd ..
cd GroupIds.java
jpa-new-field --named groupIdsTypes --type co.simasoft.models.GroupIdsTypes --relationshipType Many-to-One;

#  Relationships Relationships 
#  ############
#  Relationships Uno a Muchos Bidirecccional No.5 ModelRelationships
cd ..
cd Relationships.java
jpa-new-field --named modelRelationships --type co.simasoft.models.ModelRelationships --relationshipType One-to-Many;

#  Relationships Muchos a Muchos Bidirecccional No.7 AttributesProperties
cd ..
cd Relationships.java
jpa-new-field --named attributesProperties --type co.simasoft.models.AttributesProperties --relationshipType Many-to-Many  ----inverseFieldName relationships;

#  Relationships Muchos a Uno Unidireccional No.3 Cardinalities
cd ..
cd Relationships.java
jpa-new-field --named cardinalities --type co.simasoft.models.Cardinalities --relationshipType Many-to-One;

#  Relationships Muchos a Uno Unidireccional No.3 Entities
cd ..
cd Relationships.java
jpa-new-field --named entities --type co.simasoft.models.Entities --relationshipType Many-to-One;

#  Relationships Muchos a Uno Unidireccional No.3 Entities
cd ..
cd Relationships.java
jpa-new-field --named entities --type co.simasoft.models.Entities --relationshipType Many-to-One;

#  Fields Relationships 
#  ############
#  Fields Uno a Muchos Bidirecccional No.5 Attributes
cd ..
cd Fields.java
jpa-new-field --named attributes --type co.simasoft.models.Attributes --relationshipType One-to-Many;

#  Fields Muchos a Uno Unidireccional No.3 AttributesTypes
cd ..
cd Fields.java
jpa-new-field --named attributesTypes --type co.simasoft.models.AttributesTypes --relationshipType Many-to-One;

#  Cardinalities Relationships 
#  ############
#  Cardinalities Uno a Muchos Bidirecccional No.5 Relationships
cd ..
cd Cardinalities.java
jpa-new-field --named relationships --type co.simasoft.models.Relationships --relationshipType One-to-Many;

#Unitaria  Cardinalities Uno a Muchos Bidirecccional No.5 Cardinalities
cd ..
cd Cardinalities.java
jpa-new-field --named objHijos --type co.simasoft.models.Cardinalities --relationshipType One-to-Many;

#  Cardinalities Muchos a Muchos Bidirecccional No.7 Sites
cd ..
cd Cardinalities.java
jpa-new-field --named sites --type co.simasoft.models.Sites --relationshipType Many-to-Many  ----inverseFieldName cardinalities;

#  Cardinalities Muchos a Muchos Bidirecccional No.7 AttributesProperties
cd ..
cd Cardinalities.java
jpa-new-field --named attributesProperties --type co.simasoft.models.AttributesProperties --relationshipType Many-to-Many  ----inverseFieldName cardinalities;

#  Cardinalities Muchos a Muchos Bidirecccional No.7 Imports
cd ..
cd Cardinalities.java
jpa-new-field --named imports --type co.simasoft.models.Imports --relationshipType Many-to-Many  ----inverseFieldName cardinalities;

#Unitaria  Cardinalities Muchos a Uno Unidireccional No.3 Cardinalities
cd ..
cd Cardinalities.java
jpa-new-field --named objPadre --type co.simasoft.models.Cardinalities --relationshipType Many-to-One;

#  AttributesTypes Relationships 
#  ############
#  AttributesTypes Uno a Muchos Bidirecccional No.5 Fields
cd ..
cd AttributesTypes.java
jpa-new-field --named fields --type co.simasoft.models.Fields --relationshipType One-to-Many;

#  AttributesTypes Muchos a Muchos Bidirecccional No.7 AttributesProperties
cd ..
cd AttributesTypes.java
jpa-new-field --named attributesProperties --type co.simasoft.models.AttributesProperties --relationshipType Many-to-Many  ----inverseFieldName attributesTypes;

#  AttributesTypes Muchos a Muchos Bidirecccional No.7 Sites
cd ..
cd AttributesTypes.java
jpa-new-field --named sites --type co.simasoft.models.Sites --relationshipType Many-to-Many  ----inverseFieldName attributesTypes;

#  AttributesTypes Uno a Muchos Bidirecccional No.5 Attributes
cd ..
cd AttributesTypes.java
jpa-new-field --named attributes --type co.simasoft.models.Attributes --relationshipType One-to-Many;

#  GroupIdsTypes Relationships 
#  ############
#  GroupIdsTypes Uno a Muchos Bidirecccional No.5 GroupIds
cd ..
cd GroupIdsTypes.java
jpa-new-field --named groupIds --type co.simasoft.models.GroupIds --relationshipType One-to-Many;

#  SitesTypes Relationships 
#  ############
#Unitaria  SitesTypes Uno a Muchos Bidirecccional No.5 SitesTypes
cd ..
cd SitesTypes.java
jpa-new-field --named objHijos --type co.simasoft.models.SitesTypes --relationshipType One-to-Many;

#Unitaria  SitesTypes Muchos a Uno Unidireccional No.3 SitesTypes
cd ..
cd SitesTypes.java
jpa-new-field --named objPadre --type co.simasoft.models.SitesTypes --relationshipType Many-to-One;

#  SitesTypes Muchos a Muchos Unidireccional No.6 Sites
cd ..
cd SitesTypes.java
jpa-new-field --named sites --type co.simasoft.models.Sites --relationshipType Many-to-Many  ----inverseFieldName sitesTypes;

#  Models Relationships 
#  ############
#  Models Muchos a Muchos Bidirecccional No.7 Sites
cd ..
cd Models.java
jpa-new-field --named sites --type co.simasoft.models.Sites --relationshipType Many-to-Many  ----inverseFieldName models;

#  Models Uno a Muchos Bidirecccional No.5 ModelRelationships
cd ..
cd Models.java
jpa-new-field --named modelRelationships --type co.simasoft.models.ModelRelationships --relationshipType One-to-Many;

#  Models Muchos a Muchos Unidireccional No.6 ModelsGroups
cd ..
cd Models.java
jpa-new-field --named modelsGroups --type co.simasoft.models.ModelsGroups --relationshipType Many-to-Many  ----inverseFieldName models;

#  Models Muchos a Uno Unidireccional No.3 GroupIds
cd ..
cd Models.java
jpa-new-field --named groupIds --type co.simasoft.models.GroupIds --relationshipType Many-to-One;

#  Dependencies Relationships 
#  ############
#  Dependencies Uno a Muchos Bidirecccional No.5 Imports
cd ..
cd Dependencies.java
jpa-new-field --named imports --type co.simasoft.models.Imports --relationshipType One-to-Many;

#  Dependencies Muchos a Muchos Bidirecccional No.7 Sites
cd ..
cd Dependencies.java
jpa-new-field --named sites --type co.simasoft.models.Sites --relationshipType Many-to-Many  ----inverseFieldName dependencies;

#  Dependencies Muchos a Uno Unidireccional No.3 Pom
cd ..
cd Dependencies.java
jpa-new-field --named pom --type co.simasoft.models.Pom --relationshipType Many-to-One;

#  ModelRelationships Relationships 
#  ############
#  ModelRelationships Muchos a Uno Unidireccional No.3 Relationships
cd ..
cd ModelRelationships.java
jpa-new-field --named relationships --type co.simasoft.models.Relationships --relationshipType Many-to-One;

#  ModelRelationships Muchos a Uno Unidireccional No.3 Models
cd ..
cd ModelRelationships.java
jpa-new-field --named models --type co.simasoft.models.Models --relationshipType Many-to-One;

#  Developments Relationships 
#  ############
#  Developments Muchos a Muchos Bidirecccional No.7 Sites
cd ..
cd Developments.java
jpa-new-field --named sites --type co.simasoft.models.Sites --relationshipType Many-to-Many  ----inverseFieldName developments;

#  Developments Muchos a Muchos Bidirecccional No.7 Pom
cd ..
cd Developments.java
jpa-new-field --named pom --type co.simasoft.models.Pom --relationshipType Many-to-Many  ----inverseFieldName developments;

#  Developments Muchos a Muchos Bidirecccional No.7 ModelsGroups
cd ..
cd Developments.java
jpa-new-field --named modelsGroups --type co.simasoft.models.ModelsGroups --relationshipType Many-to-Many  ----inverseFieldName developments;

rest-generate-endpoints-from-entities --targets co.simasoft.models.*
