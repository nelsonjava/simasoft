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

#  Entities Relationships 
#  ############
#  Entities  GroupIds
cd ..
cd Entities.java
jpa-new-field --named groupIds --type co.simasoft.models.GroupIds --relationshipType Many-to-One;

rest-generate-endpoints-from-entities --targets co.simasoft.models.*
