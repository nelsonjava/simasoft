scaffold-setup --provider Faces
scaffold-generate --web-root /admin --provider Faces --targets co.simasoft.models.*;
project-new --named wrelationships7
jpa-setup
scaffold-setup --provider AngularJS

#  IpAddress entity
#  ############
jpa-new-entity --named IpAddress --targetPackage co.simasoft.models
jpa-new-field --named ipAddress --type String
jpa-new-field --named isActive --type Boolean
jpa-new-field --named state --type String

#  Sites entity
#  ############
jpa-new-entity --named Sites --targetPackage co.simasoft.models
jpa-new-field --named title --type String
jpa-new-field --named link --type String
jpa-new-field --named abc --type String

#  IpAddress Relationships 
#  ############
#  IpAddress Muchos a Muchos Bidirecccional No.7 Sites
cd ..
cd IpAddress.java
jpa-new-field --named sites --type co.simasoft.models.Sites --relationshipType Many-to-Many  ----inverseFieldName ipAddress;

#  Sites Relationships 
#  ############
#  Sites Muchos a Muchos Unidireccional No.6 IpAddress
cd ..
cd Sites.java
jpa-new-field --named ipAddress --type co.simasoft.models.IpAddress --relationshipType Many-to-Many  ----inverseFieldName sites;

rest-generate-endpoints-from-entities --targets co.simasoft.models.*
