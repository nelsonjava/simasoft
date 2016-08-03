scaffold-setup --provider Faces
scaffold-generate --web-root /admin --provider Faces --targets co.simasoft.models.*;
project-new --named wprueba5
jpa-setup
scaffold-setup --provider AngularJS

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
jpa-new-field --named isOptionality --type Boolean
jpa-new-field --named isEmbedded --type Boolean
jpa-new-field --named isSimplified --type Boolean
jpa-new-field --named isCreate --type Boolean
jpa-new-field --named isSearch --type Boolean
jpa-new-field --named isView --type Boolean
jpa-new-field --named name --type String

#  Cardinalities entity
#  ############
jpa-new-entity --named Cardinalities --targetPackage co.simasoft.models
jpa-new-field --named name --type String
jpa-new-field --named cardinality --type String
jpa-new-field --named isUnidirectional --type Boolean

#  Entities entity
#  ############
jpa-new-entity --named Entities --targetPackage co.simasoft.models
jpa-new-field --named name --type String
jpa-new-field --named serialID --type String
jpa-new-field --named table --type String
jpa-new-field --named description --type String

#  GroupIds Relationships 
#  ############
#  GroupIds Uno a Muchos Bidirecccional No.5 Entities
cd ..
cd GroupIds.java
jpa-new-field --named entities --type co.simasoft.models.Entities --relationshipType One-to-Many;

#  Relationships Relationships 
#  ############
#  Relationships Muchos a Uno Unidireccional No.3 Entities
cd ..
cd Relationships.java
jpa-new-field --named entities --type co.simasoft.models.Entities --relationshipType Many-to-One;

#  Relationships Muchos a Uno Unidireccional No.3 Entities
cd ..
cd Relationships.java
jpa-new-field --named entities --type co.simasoft.models.Entities --relationshipType Many-to-One;

#  Cardinalities Relationships 
#  ############
#Unitaria  Cardinalities Uno a Muchos Bidirecccional No.5 Cardinalities
cd ..
cd Cardinalities.java
jpa-new-field --named objHijos --type co.simasoft.models.Cardinalities --relationshipType One-to-Many;

#Unitaria  Cardinalities Muchos a Uno Unidireccional No.3 Cardinalities
cd ..
cd Cardinalities.java
jpa-new-field --named objPadre --type co.simasoft.models.Cardinalities --relationshipType Many-to-One;

#  Entities Relationships 
#  ############
#  Entities Uno a Muchos Bidirecccional No.5 Relationships
cd ..
cd Entities.java
jpa-new-field --named relationships --type co.simasoft.models.Relationships --relationshipType One-to-Many;

#  Entities Uno a Muchos Bidirecccional No.5 Relationships
cd ..
cd Entities.java
jpa-new-field --named relationships --type co.simasoft.models.Relationships --relationshipType One-to-Many;

#  Entities Muchos a Uno Unidireccional No.3 GroupIds
cd ..
cd Entities.java
jpa-new-field --named groupIds --type co.simasoft.models.GroupIds --relationshipType Many-to-One;

rest-generate-endpoints-from-entities --targets co.simasoft.models.*
