scaffold-setup --provider Faces
scaffold-generate --web-root /admin --provider Faces --targets co.simasoft.models.*;
project-new --named wnaifg25
jpa-setup
scaffold-setup --provider AngularJS

#  AttributesProperties entity
#  ############
jpa-new-entity --named AttributesProperties --targetPackage co.simasoft.models
jpa-new-field --named name --type String
jpa-new-field --named value --type String

#  ModelsGroupIds entity
#  ############
jpa-new-entity --named ModelsGroupIds --targetPackage co.simasoft.models
jpa-new-field --named isIsolated --type Boolean
jpa-new-field --named isSimplified --type Boolean

#  Attributes entity
#  ############
jpa-new-entity --named Attributes --targetPackage co.simasoft.models
jpa-new-field --named isUnique --type Boolean
jpa-new-field --named isSimplified --type Boolean
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

#  Imports entity
#  ############
jpa-new-entity --named Imports --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  Sites entity
#  ############
jpa-new-entity --named Sites --targetPackage co.simasoft.models
jpa-new-field --named title --type String
jpa-new-field --named link --type String
jpa-new-field --named abc --type String

#  Entities entity
#  ############
jpa-new-entity --named Entities --targetPackage co.simasoft.models
jpa-new-field --named name --type String
jpa-new-field --named groupId --type String
jpa-new-field --named serialID --type String
jpa-new-field --named table --type String
jpa-new-field --named description --type String

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
jpa-new-field --named isCreate --type Boolean
jpa-new-field --named isSearch --type Boolean
jpa-new-field --named isView --type Boolean
jpa-new-field --named name --type String
jpa-new-field --named isOptionality --type Boolean
jpa-new-field --named isEmbedded --type Boolean
jpa-new-field --named isSimplified --type Boolean

#  DevelopmentsModels entity
#  ############
jpa-new-entity --named DevelopmentsModels --targetPackage co.simasoft.models
jpa-new-field --named code --type String
jpa-new-field --named name --type String

#  Fields entity
#  ############
jpa-new-entity --named Fields --targetPackage co.simasoft.models
jpa-new-field --named name --type String
jpa-new-field --named description --type String
jpa-new-field --named length --type Integer
jpa-new-field --named precision --type Integer

#  Cardinalities entity
#  ############
jpa-new-entity --named Cardinalities --targetPackage co.simasoft.models
jpa-new-field --named name --type String
jpa-new-field --named cardinality --type String
jpa-new-field --named isUnidirectional --type Boolean

#  GroupIdsRelationships entity
#  ############
jpa-new-entity --named GroupIdsRelationships --targetPackage co.simasoft.models
jpa-new-field --named isIsolated --type Boolean
jpa-new-field --named isSimplified --type Boolean

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
jpa-new-field --named artifactId --type String
jpa-new-field --named groupId --type String
jpa-new-field --named version --type String
jpa-new-field --named code --type String
jpa-new-field --named date --type java.util.Date --temporalType TIMESTAMP

#  NameQueries entity
#  ############
jpa-new-entity --named NameQueries --targetPackage co.simasoft.models
jpa-new-field --named name --type String
jpa-new-field --named query --type String

#  Dependencies entity
#  ############
jpa-new-entity --named Dependencies --targetPackage co.simasoft.models
jpa-new-field --named groupId --type String
jpa-new-field --named artifactId --type String
jpa-new-field --named version --type String
jpa-new-field --named type --type String
jpa-new-field --named scope --type String
jpa-new-field --named maven --type String

#  Developments entity
#  ############
jpa-new-entity --named Developments --targetPackage co.simasoft.models
jpa-new-field --named code --type String
jpa-new-field --named date --type java.util.Date --temporalType TIMESTAMP
jpa-new-field --named artifactId --type String
jpa-new-field --named groupId --type String
jpa-new-field --named version --type String

#  AttributesProperties Relationships 
#  ############
#  AttributesProperties  Imports
cd ..
cd AttributesProperties.java
jpa-new-field --named imports --type co.simasoft.models.Imports --relationshipType Many-to-Many  ----inverseFieldName attributesProperties;

#  AttributesProperties  Sites
cd ..
cd AttributesProperties.java
jpa-new-field --named sites --type co.simasoft.models.Sites --relationshipType Many-to-Many  ----inverseFieldName attributesProperties;

#  AttributesTypes  AttributesProperties
cd ..
cd AttributesProperties.java
jpa-new-field --named attributesTypes --type co.simasoft.models.AttributesTypes --relationshipType Many-to-One;

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

#  ModelsGroupIds Relationships 
#  ############
#  Models  ModelsGroupIds
cd ..
cd ModelsGroupIds.java
jpa-new-field --named models --type co.simasoft.models.Models --relationshipType Many-to-One;

#  GroupIds  ModelsGroupIds
cd ..
cd ModelsGroupIds.java
jpa-new-field --named groupIds --type co.simasoft.models.GroupIds --relationshipType Many-to-One;

#  Attributes Relationships 
#  ############
#  Attributes  Sites
cd ..
cd Attributes.java
jpa-new-field --named sites --type co.simasoft.models.Sites --relationshipType Many-to-Many  ----inverseFieldName attributes;

#  Attributes  AttributesProperties
cd ..
cd Attributes.java
jpa-new-field --named attributesProperties --type co.simasoft.models.AttributesProperties --relationshipType Many-to-Many  ----inverseFieldName attributes;

#  Entities  Attributes
cd ..
cd Attributes.java
jpa-new-field --named entities --type co.simasoft.models.Entities --relationshipType Many-to-One;

#  AttributesTypes  Attributes
cd ..
cd Attributes.java
jpa-new-field --named attributesTypes --type co.simasoft.models.AttributesTypes --relationshipType Many-to-One;

#  Imports Relationships 
#  ############
#  Imports  Sites
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

#  Sites Relationships 
#  ############
#  Developments  Sites
cd ..
cd Sites.java
jpa-new-field --named developments --type co.simasoft.models.Developments --relationshipType Many-to-One;

#  SitesTypes  Sites
cd ..
cd Sites.java
jpa-new-field --named sitesTypes --type co.simasoft.models.SitesTypes --relationshipType Many-to-One;

#  Dependencies  Sites
cd ..
cd Sites.java
jpa-new-field --named dependencies --type co.simasoft.models.Dependencies --relationshipType Many-to-One;

#  AttributesTypes  Sites
cd ..
cd Sites.java
jpa-new-field --named attributesTypes --type co.simasoft.models.AttributesTypes --relationshipType Many-to-One;

#  Imports  Sites
cd ..
cd Sites.java
jpa-new-field --named imports --type co.simasoft.models.Imports --relationshipType Many-to-One;

#  AttributesProperties  Sites
cd ..
cd Sites.java
jpa-new-field --named attributesProperties --type co.simasoft.models.AttributesProperties --relationshipType Many-to-One;

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

#  Models  Sites
cd ..
cd Sites.java
jpa-new-field --named models --type co.simasoft.models.Models --relationshipType Many-to-One;

#  Entities Relationships 
#  ############
#  Entities  Relationships
cd ..
cd Entities.java
jpa-new-field --named relationships --type co.simasoft.models.Relationships --relationshipType One-to-Many;

#  Entities  Relationships
cd ..
cd Entities.java
jpa-new-field --named relationships --type co.simasoft.models.Relationships --relationshipType One-to-Many;

#  Entities  Attributes
cd ..
cd Entities.java
jpa-new-field --named attributes --type co.simasoft.models.Attributes --relationshipType One-to-Many;

#  Entities  NameQueries
cd ..
cd Entities.java
jpa-new-field --named nameQueries --type co.simasoft.models.NameQueries --relationshipType One-to-Many;

#  Entities  Sites
cd ..
cd Entities.java
jpa-new-field --named sites --type co.simasoft.models.Sites --relationshipType Many-to-Many  ----inverseFieldName entities;

#  Entities  Imports
cd ..
cd Entities.java
jpa-new-field --named imports --type co.simasoft.models.Imports --relationshipType Many-to-Many  ----inverseFieldName entities;

#  Entities  AttributesProperties
cd ..
cd Entities.java
jpa-new-field --named attributesProperties --type co.simasoft.models.AttributesProperties --relationshipType Many-to-Many  ----inverseFieldName entities;

#  GroupIds Relationships 
#  ############
#  GroupIds  ModelsGroupIds
cd ..
cd GroupIds.java
jpa-new-field --named modelsGroupIds --type co.simasoft.models.ModelsGroupIds --relationshipType One-to-Many;

#  GroupIds  GroupIdsRelationships
cd ..
cd GroupIds.java
jpa-new-field --named groupIdsRelationships --type co.simasoft.models.GroupIdsRelationships --relationshipType One-to-Many;

#  Relationships Relationships 
#  ############
#  Relationships  GroupIdsRelationships
cd ..
cd Relationships.java
jpa-new-field --named groupIdsRelationships --type co.simasoft.models.GroupIdsRelationships --relationshipType One-to-Many;

#  Relationships  AttributesProperties
cd ..
cd Relationships.java
jpa-new-field --named attributesProperties --type co.simasoft.models.AttributesProperties --relationshipType Many-to-Many  ----inverseFieldName relationships;

#  Entities  Relationships
cd ..
cd Relationships.java
jpa-new-field --named entities --type co.simasoft.models.Entities --relationshipType Many-to-One;

#  Entities  Relationships
cd ..
cd Relationships.java
jpa-new-field --named entities --type co.simasoft.models.Entities --relationshipType Many-to-One;

#  Cardinalities  Relationships
cd ..
cd Relationships.java
jpa-new-field --named cardinalities --type co.simasoft.models.Cardinalities --relationshipType Many-to-One;

#  DevelopmentsModels Relationships 
#  ############
#  Developments  DevelopmentsModels
cd ..
cd DevelopmentsModels.java
jpa-new-field --named developments --type co.simasoft.models.Developments --relationshipType Many-to-One;

#  Models  DevelopmentsModels
cd ..
cd DevelopmentsModels.java
jpa-new-field --named models --type co.simasoft.models.Models --relationshipType Many-to-One;

#  Fields Relationships 
#  ############
#  AttributesTypes  Fields
cd ..
cd Fields.java
jpa-new-field --named attributesTypes --type co.simasoft.models.AttributesTypes --relationshipType Many-to-One;

#  Cardinalities Relationships 
#  ############
#  Cardinalities  Relationships
cd ..
cd Cardinalities.java
jpa-new-field --named relationships --type co.simasoft.models.Relationships --relationshipType One-to-Many;

#  Cardinalities  Sites
cd ..
cd Cardinalities.java
jpa-new-field --named sites --type co.simasoft.models.Sites --relationshipType Many-to-Many  ----inverseFieldName cardinalities;

#  Cardinalities  Imports
cd ..
cd Cardinalities.java
jpa-new-field --named imports --type co.simasoft.models.Imports --relationshipType Many-to-Many  ----inverseFieldName cardinalities;

#  GroupIdsRelationships Relationships 
#  ############
#  Relationships  GroupIdsRelationships
cd ..
cd GroupIdsRelationships.java
jpa-new-field --named relationships --type co.simasoft.models.Relationships --relationshipType Many-to-One;

#  GroupIds  GroupIdsRelationships
cd ..
cd GroupIdsRelationships.java
jpa-new-field --named groupIds --type co.simasoft.models.GroupIds --relationshipType Many-to-One;

#  AttributesTypes Relationships 
#  ############
#  AttributesTypes  AttributesProperties
cd ..
cd AttributesTypes.java
jpa-new-field --named attributesProperties --type co.simasoft.models.AttributesProperties --relationshipType Many-to-Many  ----inverseFieldName attributesTypes;

#  AttributesTypes  Fields
cd ..
cd AttributesTypes.java
jpa-new-field --named fields --type co.simasoft.models.Fields --relationshipType One-to-Many;

#  AttributesTypes  Sites
cd ..
cd AttributesTypes.java
jpa-new-field --named sites --type co.simasoft.models.Sites --relationshipType Many-to-Many  ----inverseFieldName attributesTypes;

#  AttributesTypes  Attributes
cd ..
cd AttributesTypes.java
jpa-new-field --named attributes --type co.simasoft.models.Attributes --relationshipType One-to-Many;

#  SitesTypes Relationships 
#  ############
#  SitesTypes  Sites
cd ..
cd SitesTypes.java
jpa-new-field --named sites --type co.simasoft.models.Sites --relationshipType Many-to-Many  ----inverseFieldName sitesTypes;

#Unitaria  SitesTypes  SitesTypes
cd ..
cd SitesTypes.java
jpa-new-field --named objHijos --type co.simasoft.models.SitesTypes --relationshipType One-to-Many;

#Unitaria  SitesTypes  SitesTypes
cd ..
cd SitesTypes.java
jpa-new-field --named objPadre --type co.simasoft.models.SitesTypes --relationshipType Many-to-One;

#  Models Relationships 
#  ############
#  Models  ModelsGroupIds
cd ..
cd Models.java
jpa-new-field --named modelsGroupIds --type co.simasoft.models.ModelsGroupIds --relationshipType One-to-Many;

#  Models  DevelopmentsModels
cd ..
cd Models.java
jpa-new-field --named developmentsModels --type co.simasoft.models.DevelopmentsModels --relationshipType One-to-Many;

#  Models  Sites
cd ..
cd Models.java
jpa-new-field --named sites --type co.simasoft.models.Sites --relationshipType Many-to-Many  ----inverseFieldName models;

#  NameQueries Relationships 
#  ############
#  Entities  NameQueries
cd ..
cd NameQueries.java
jpa-new-field --named entities --type co.simasoft.models.Entities --relationshipType Many-to-One;

#  Dependencies Relationships 
#  ############
#  Dependencies  Imports
cd ..
cd Dependencies.java
jpa-new-field --named imports --type co.simasoft.models.Imports --relationshipType One-to-Many;

#  Dependencies  Sites
cd ..
cd Dependencies.java
jpa-new-field --named sites --type co.simasoft.models.Sites --relationshipType Many-to-Many  ----inverseFieldName dependencies;

#  Developments Relationships 
#  ############
#  Developments  Sites
cd ..
cd Developments.java
jpa-new-field --named sites --type co.simasoft.models.Sites --relationshipType Many-to-Many  ----inverseFieldName developments;

#  Developments  DevelopmentsModels
cd ..
cd Developments.java
jpa-new-field --named developmentsModels --type co.simasoft.models.DevelopmentsModels --relationshipType One-to-Many;

rest-generate-endpoints-from-entities --targets co.simasoft.models.*
