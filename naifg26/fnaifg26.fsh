scaffold-setup --provider Faces
scaffold-generate --web-root /admin --provider Faces --targets co.simasoft.models.*;
project-new --named wnaifg26
jpa-setup
scaffold-setup --provider AngularJS

#  AttributesProperties entity
#  ############
jpa-new-entity --named AttributesProperties --targetPackage co.simasoft.models
jpa-new-field --named name --type String
jpa-new-field --named value --type String

#  GroupsModels entity
#  ############
jpa-new-entity --named GroupsModels --targetPackage co.simasoft.models
jpa-new-field --named name --type String
jpa-new-field --named code --type String

#  Attributes entity
#  ############
jpa-new-entity --named Attributes --targetPackage co.simasoft.models
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
jpa-new-field --named isUnique --type Boolean
jpa-new-field --named isSimplified --type Boolean

#  DevelopmentsGroups entity
#  ############
jpa-new-entity --named DevelopmentsGroups --targetPackage co.simasoft.models
jpa-new-field --named code --type String
jpa-new-field --named name --type String

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
jpa-new-field --named isEmbedded --type Boolean
jpa-new-field --named isSimplified --type Boolean
jpa-new-field --named isCreate --type Boolean
jpa-new-field --named isSearch --type Boolean
jpa-new-field --named isView --type Boolean

#  Fields entity
#  ############
jpa-new-entity --named Fields --targetPackage co.simasoft.models
jpa-new-field --named name --type String
jpa-new-field --named description --type String
jpa-new-field --named length --type Integer
jpa-new-field --named precision --type Integer

#  Groups entity
#  ############
jpa-new-entity --named Groups --targetPackage co.simasoft.models
jpa-new-field --named name --type String
jpa-new-field --named code --type String

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

#  SitesTypes entity
#  ############
jpa-new-entity --named SitesTypes --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  Models entity
#  ############
jpa-new-entity --named Models --targetPackage co.simasoft.models
jpa-new-field --named code --type String
jpa-new-field --named name --type String

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
jpa-new-field --named code --type String

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

#  AttributesTypes  AttributesProperties
cd ..
cd AttributesProperties.java
jpa-new-field --named attributesTypes --type co.simasoft.models.AttributesTypes --relationshipType Many-to-One;

#  Cardinalities  AttributesProperties
cd ..
cd AttributesProperties.java
jpa-new-field --named cardinalities --type co.simasoft.models.Cardinalities --relationshipType Many-to-One;

#  Relationships  AttributesProperties
cd ..
cd AttributesProperties.java
jpa-new-field --named relationships --type co.simasoft.models.Relationships --relationshipType Many-to-One;

#  Entities  AttributesProperties
cd ..
cd AttributesProperties.java
jpa-new-field --named entities --type co.simasoft.models.Entities --relationshipType Many-to-One;

#  Attributes  AttributesProperties
cd ..
cd AttributesProperties.java
jpa-new-field --named attributes --type co.simasoft.models.Attributes --relationshipType Many-to-One;

#  GroupsModels Relationships 
#  ############
#  Models  GroupsModels
cd ..
cd GroupsModels.java
jpa-new-field --named models --type co.simasoft.models.Models --relationshipType Many-to-One;

#  Groups  GroupsModels
cd ..
cd GroupsModels.java
jpa-new-field --named groups --type co.simasoft.models.Groups --relationshipType Many-to-One;

#  Attributes Relationships 
#  ############
#  Attributes Muchos a Muchos Bidirecccional No.7 AttributesProperties
cd ..
cd Attributes.java
jpa-new-field --named attributesProperties --type co.simasoft.models.AttributesProperties --relationshipType Many-to-Many  ----inverseFieldName attributes;

#  Attributes Muchos a Muchos Bidirecccional No.7 Sites
cd ..
cd Attributes.java
jpa-new-field --named sites --type co.simasoft.models.Sites --relationshipType Many-to-Many  ----inverseFieldName attributes;

#  Entities  Attributes
cd ..
cd Attributes.java
jpa-new-field --named entities --type co.simasoft.models.Entities --relationshipType Many-to-One;

#  AttributesTypes  Attributes
cd ..
cd Attributes.java
jpa-new-field --named attributesTypes --type co.simasoft.models.AttributesTypes --relationshipType Many-to-One;

#  DevelopmentsGroups Relationships 
#  ############
#  Groups  DevelopmentsGroups
cd ..
cd DevelopmentsGroups.java
jpa-new-field --named groups --type co.simasoft.models.Groups --relationshipType Many-to-One;

#  Developments  DevelopmentsGroups
cd ..
cd DevelopmentsGroups.java
jpa-new-field --named developments --type co.simasoft.models.Developments --relationshipType Many-to-One;

#  Imports Relationships 
#  ############
#  Imports Muchos a Muchos Bidirecccional No.7 Sites
cd ..
cd Imports.java
jpa-new-field --named sites --type co.simasoft.models.Sites --relationshipType Many-to-Many  ----inverseFieldName imports;

#  Dependencies  Imports
cd ..
cd Imports.java
jpa-new-field --named dependencies --type co.simasoft.models.Dependencies --relationshipType Many-to-One;

#  AttributesProperties  Imports
cd ..
cd Imports.java
jpa-new-field --named attributesProperties --type co.simasoft.models.AttributesProperties --relationshipType Many-to-One;

#  Entities  Imports
cd ..
cd Imports.java
jpa-new-field --named entities --type co.simasoft.models.Entities --relationshipType Many-to-One;

#  Cardinalities  Imports
cd ..
cd Imports.java
jpa-new-field --named cardinalities --type co.simasoft.models.Cardinalities --relationshipType Many-to-One;

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

#  Entities Muchos a Muchos Bidirecccional No.7 Imports
cd ..
cd Entities.java
jpa-new-field --named imports --type co.simasoft.models.Imports --relationshipType Many-to-Many  ----inverseFieldName entities;

#  Entities Muchos a Muchos Bidirecccional No.7 AttributesProperties
cd ..
cd Entities.java
jpa-new-field --named attributesProperties --type co.simasoft.models.AttributesProperties --relationshipType Many-to-Many  ----inverseFieldName entities;

#  Entities Muchos a Muchos Bidirecccional No.7 Sites
cd ..
cd Entities.java
jpa-new-field --named sites --type co.simasoft.models.Sites --relationshipType Many-to-Many  ----inverseFieldName entities;

#  Entities Uno a Muchos Bidirecccional No.5 Relationships
cd ..
cd Entities.java
jpa-new-field --named relationships --type co.simasoft.models.Relationships --relationshipType One-to-Many;

#  GroupIds  Entities
cd ..
cd Entities.java
jpa-new-field --named groupIds --type co.simasoft.models.GroupIds --relationshipType Many-to-One;

#  Sites Relationships 
#  ############
#  SitesTypes  Sites
cd ..
cd Sites.java
jpa-new-field --named sitesTypes --type co.simasoft.models.SitesTypes --relationshipType Many-to-One;

#  Dependencies  Sites
cd ..
cd Sites.java
jpa-new-field --named dependencies --type co.simasoft.models.Dependencies --relationshipType Many-to-One;

#  AttributesProperties  Sites
cd ..
cd Sites.java
jpa-new-field --named attributesProperties --type co.simasoft.models.AttributesProperties --relationshipType Many-to-One;

#  Imports  Sites
cd ..
cd Sites.java
jpa-new-field --named imports --type co.simasoft.models.Imports --relationshipType Many-to-One;

#  AttributesTypes  Sites
cd ..
cd Sites.java
jpa-new-field --named attributesTypes --type co.simasoft.models.AttributesTypes --relationshipType Many-to-One;

#  Developments  Sites
cd ..
cd Sites.java
jpa-new-field --named developments --type co.simasoft.models.Developments --relationshipType Many-to-One;

#  Models  Sites
cd ..
cd Sites.java
jpa-new-field --named models --type co.simasoft.models.Models --relationshipType Many-to-One;

#  Entities  Sites
cd ..
cd Sites.java
jpa-new-field --named entities --type co.simasoft.models.Entities --relationshipType Many-to-One;

#  Cardinalities  Sites
cd ..
cd Sites.java
jpa-new-field --named cardinalities --type co.simasoft.models.Cardinalities --relationshipType Many-to-One;

#  Attributes  Sites
cd ..
cd Sites.java
jpa-new-field --named attributes --type co.simasoft.models.Attributes --relationshipType Many-to-One;

#  GroupIds Relationships 
#  ############
#  GroupIds Uno a Muchos Bidirecccional No.5 Entities
cd ..
cd GroupIds.java
jpa-new-field --named entities --type co.simasoft.models.Entities --relationshipType One-to-Many;

#  Relationships Relationships 
#  ############
#  Relationships Muchos a Muchos Bidirecccional No.7 AttributesProperties
cd ..
cd Relationships.java
jpa-new-field --named attributesProperties --type co.simasoft.models.AttributesProperties --relationshipType Many-to-Many  ----inverseFieldName relationships;

#  Relationships Uno a Muchos Bidirecccional No.5 ModelRelationships
cd ..
cd Relationships.java
jpa-new-field --named modelRelationships --type co.simasoft.models.ModelRelationships --relationshipType One-to-Many;

#  Entities  Relationships
cd ..
cd Relationships.java
jpa-new-field --named entities --type co.simasoft.models.Entities --relationshipType Many-to-One;

#  Cardinalities  Relationships
cd ..
cd Relationships.java
jpa-new-field --named cardinalities --type co.simasoft.models.Cardinalities --relationshipType Many-to-One;

#  Entities  Relationships
cd ..
cd Relationships.java
jpa-new-field --named entities --type co.simasoft.models.Entities --relationshipType Many-to-One;

#  Fields Relationships 
#  ############
#  AttributesTypes  Fields
cd ..
cd Fields.java
jpa-new-field --named attributesTypes --type co.simasoft.models.AttributesTypes --relationshipType Many-to-One;

#  Groups Relationships 
#  ############
#  Groups Uno a Muchos Bidirecccional No.5 GroupsModels
cd ..
cd Groups.java
jpa-new-field --named groupsModels --type co.simasoft.models.GroupsModels --relationshipType One-to-Many;

#  Groups Uno a Muchos Bidirecccional No.5 DevelopmentsGroups
cd ..
cd Groups.java
jpa-new-field --named developmentsGroups --type co.simasoft.models.DevelopmentsGroups --relationshipType One-to-Many;

#  Cardinalities Relationships 
#  ############
#  Cardinalities Uno a Muchos Bidirecccional No.5 Relationships
cd ..
cd Cardinalities.java
jpa-new-field --named relationships --type co.simasoft.models.Relationships --relationshipType One-to-Many;

#  Cardinalities Muchos a Muchos Bidirecccional No.7 AttributesProperties
cd ..
cd Cardinalities.java
jpa-new-field --named attributesProperties --type co.simasoft.models.AttributesProperties --relationshipType Many-to-Many  ----inverseFieldName cardinalities;

#  Cardinalities Muchos a Muchos Bidirecccional No.7 Imports
cd ..
cd Cardinalities.java
jpa-new-field --named imports --type co.simasoft.models.Imports --relationshipType Many-to-Many  ----inverseFieldName cardinalities;

#  Cardinalities Muchos a Muchos Bidirecccional No.7 Sites
cd ..
cd Cardinalities.java
jpa-new-field --named sites --type co.simasoft.models.Sites --relationshipType Many-to-Many  ----inverseFieldName cardinalities;

#Unitaria  Cardinalities Uno a Muchos Bidirecccional No.5 Cardinalities
cd ..
cd Cardinalities.java
jpa-new-field --named objHijos --type co.simasoft.models.Cardinalities --relationshipType One-to-Many;

#Unitaria  Cardinalities  Cardinalities
cd ..
cd Cardinalities.java
jpa-new-field --named objPadre --type co.simasoft.models.Cardinalities --relationshipType Many-to-One;

#  AttributesTypes Relationships 
#  ############
#  AttributesTypes Muchos a Muchos Bidirecccional No.7 AttributesProperties
cd ..
cd AttributesTypes.java
jpa-new-field --named attributesProperties --type co.simasoft.models.AttributesProperties --relationshipType Many-to-Many  ----inverseFieldName attributesTypes;

#  AttributesTypes Uno a Muchos Bidirecccional No.5 Fields
cd ..
cd AttributesTypes.java
jpa-new-field --named fields --type co.simasoft.models.Fields --relationshipType One-to-Many;

#  AttributesTypes Muchos a Muchos Bidirecccional No.7 Sites
cd ..
cd AttributesTypes.java
jpa-new-field --named sites --type co.simasoft.models.Sites --relationshipType Many-to-Many  ----inverseFieldName attributesTypes;

#  AttributesTypes Uno a Muchos Bidirecccional No.5 Attributes
cd ..
cd AttributesTypes.java
jpa-new-field --named attributes --type co.simasoft.models.Attributes --relationshipType One-to-Many;

#  SitesTypes Relationships 
#  ############
#  SitesTypes Muchos a Muchos Bidirecccional No.7 Sites
cd ..
cd SitesTypes.java
jpa-new-field --named sites --type co.simasoft.models.Sites --relationshipType Many-to-Many  ----inverseFieldName sitesTypes;

#Unitaria  SitesTypes Uno a Muchos Bidirecccional No.5 SitesTypes
cd ..
cd SitesTypes.java
jpa-new-field --named objHijos --type co.simasoft.models.SitesTypes --relationshipType One-to-Many;

#Unitaria  SitesTypes  SitesTypes
cd ..
cd SitesTypes.java
jpa-new-field --named objPadre --type co.simasoft.models.SitesTypes --relationshipType Many-to-One;

#  Models Relationships 
#  ############
#  Models Uno a Muchos Bidirecccional No.5 GroupsModels
cd ..
cd Models.java
jpa-new-field --named groupsModels --type co.simasoft.models.GroupsModels --relationshipType One-to-Many;

#  Models Muchos a Muchos Bidirecccional No.7 Sites
cd ..
cd Models.java
jpa-new-field --named sites --type co.simasoft.models.Sites --relationshipType Many-to-Many  ----inverseFieldName models;

#  Models Uno a Muchos Bidirecccional No.5 ModelRelationships
cd ..
cd Models.java
jpa-new-field --named modelRelationships --type co.simasoft.models.ModelRelationships --relationshipType One-to-Many;

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

#  ModelRelationships Relationships 
#  ############
#  Models  ModelRelationships
cd ..
cd ModelRelationships.java
jpa-new-field --named models --type co.simasoft.models.Models --relationshipType Many-to-One;

#  Relationships  ModelRelationships
cd ..
cd ModelRelationships.java
jpa-new-field --named relationships --type co.simasoft.models.Relationships --relationshipType Many-to-One;

#  Developments Relationships 
#  ############
#  Developments Muchos a Muchos Bidirecccional No.7 Sites
cd ..
cd Developments.java
jpa-new-field --named sites --type co.simasoft.models.Sites --relationshipType Many-to-Many  ----inverseFieldName developments;

#  Developments Uno a Muchos Bidirecccional No.5 DevelopmentsGroups
cd ..
cd Developments.java
jpa-new-field --named developmentsGroups --type co.simasoft.models.DevelopmentsGroups --relationshipType One-to-Many;

rest-generate-endpoints-from-entities --targets co.simasoft.models.*
